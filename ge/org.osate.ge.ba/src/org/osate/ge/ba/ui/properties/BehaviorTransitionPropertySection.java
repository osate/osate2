/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.ba.ui.properties;

import java.util.Optional;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.declarative.DeclarativeBehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ProjectUtil;
import org.osate.ge.ba.ui.EmbeddedTextEditor;
import org.osate.ge.ba.util.BehaviorTransitionEmbeddedTextUtil;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.ui.PropertySectionUtil;

/**
 * Property section for {@link BehaviorTransition}
 */
public class BehaviorTransitionPropertySection extends AbstractPropertySection {
	/**
	 * Filter which determines if the property section is compatible with an object.
	 */
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBocCompatible(toTest, boc -> isBehaviorTransition(boc));
		}
	}

	/**
	 * Testing ID for the styled text widget containing the transition's condition
	 * @see SwtUtil#getTestingId(org.eclipse.swt.widgets.Widget)
	 */
	public static final String WIDGET_ID_CONDITION = "org.osate.ge.ba.behaviortransition.dispatchcondition";

	/**
	 * Testing ID for the edit button for the transition's condition
	 * @see SwtUtil#getTestingId(org.eclipse.swt.widgets.Widget)
	 */
	public static final String WIDGET_ID_EDIT_CONDITION = WIDGET_ID_CONDITION + ".edit";

	/**
	 * Testing ID for the styled text widget containing the transition's action block
	 * @see SwtUtil#getTestingId(org.eclipse.swt.widgets.Widget)
	 */
	public static final String WIDGET_ID_ACTION_BLOCK = "org.osate.ge.ba.behaviortransition.actionblock";

	/**
	 * Testing ID for the edit button for the transition's action block
	 * @see SwtUtil#getTestingId(org.eclipse.swt.widgets.Widget)
	 */
	public static final String WIDGET_ID_EDIT_ACTION_BLOCK = WIDGET_ID_ACTION_BLOCK + ".edit";

	private Composite container;
	private EmbeddedTextEditor conditionTextEditor;
	private EmbeddedTextEditor actionBlockTextEditor;
	private BusinessObjectSelection selectedBos;

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		// Create composite for widgets
		container = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

		final Label conditionLabel = new Label(container, SWT.NONE);
		conditionLabel.setText("Condition:");
		SwtUtil.setColorsToMatchParent(conditionLabel);

		conditionTextEditor = EmbeddedTextEditor.createSingleline(container);
		conditionTextEditor.setStyledTextTestId(WIDGET_ID_CONDITION);
		conditionTextEditor.setEditButtonTestId(WIDGET_ID_EDIT_CONDITION);

		final Label actionLabel = new Label(container, SWT.NONE);
		actionLabel.setText("Action:");
		SwtUtil.setColorsToMatchParent(actionLabel);

		actionBlockTextEditor = EmbeddedTextEditor.createMultiline(container);
		actionBlockTextEditor.setStyledTextTestId(WIDGET_ID_ACTION_BLOCK);
		actionBlockTextEditor.setEditButtonTestId(WIDGET_ID_EDIT_ACTION_BLOCK);
	}

	@Override
	public void refresh() {
		final Optional<BusinessObjectContext> optSelectedBoc = selectedBos.bocStream()
				.filter(boc -> isBehaviorTransition(boc)
						&& ProjectUtil.getProjectForBo(boc.getBusinessObject()).isPresent())
				.findAny();

		if (optSelectedBoc.isPresent()) {
			final BusinessObjectContext selectedBoc = optSelectedBoc.orElseThrow();
			final boolean isSingleSelection = selectedBos.bocStream().limit(2).count() == 1;
			if (!isSingleSelection) {
				setControlsToMultipleSelected();
			} else {
				final BehaviorTransition behaviorTransition = (BehaviorTransition) selectedBoc.getBusinessObject();
				conditionTextEditor.setEditorTextValue(behaviorTransition,
						sourceText -> BehaviorTransitionEmbeddedTextUtil.createConditionTextValue(behaviorTransition, sourceText));
				actionBlockTextEditor.setEditorTextValue(behaviorTransition,
						sourceText -> BehaviorTransitionEmbeddedTextUtil.getActionBlockTextValue(behaviorTransition, sourceText));
			}
		}
	}

	private void setControlsToMultipleSelected() {
		final String msg = "<Multiple>";
		conditionTextEditor.setEnabled(false);
		conditionTextEditor.setStyledTextText(msg);

		actionBlockTextEditor.setEnabled(false);
		actionBlockTextEditor.setStyledTextText(msg);
	}

	private static boolean isBehaviorTransition(final BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		return bo instanceof BehaviorTransition || bo instanceof DeclarativeBehaviorTransition;
	}
}
