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

import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.PropertySectionUtil;

public class StatePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof BehaviorState);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button completeStatePropertyBtn;
	private Button finalStatePropertyBtn;
	private Button initialStatePropertyBtn;

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label completeSectionLabel = PropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Complete:");

		completeStatePropertyBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				new SetPropertyStateSelectionListener("Set Complete State", completeStatePropertyBtn), "", SWT.CHECK);
		setButtonLayoutData(completeStatePropertyBtn, completeSectionLabel);

		final Label finalSectionLabel = PropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "Final:");
		setLabelLayoutData(finalSectionLabel, completeSectionLabel);

		finalStatePropertyBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				new SetPropertyStateSelectionListener("Set Final State", finalStatePropertyBtn), "", SWT.CHECK);
		setButtonLayoutData(finalStatePropertyBtn, finalSectionLabel);

		final Label initialSectionLabel = PropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Initial:");
		setLabelLayoutData(initialSectionLabel, finalSectionLabel);


		initialStatePropertyBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				new SetPropertyStateSelectionListener("Set Initial State", initialStatePropertyBtn), "", SWT.CHECK);

		setButtonLayoutData(initialStatePropertyBtn, initialSectionLabel);
	}

	private void setButtonLayoutData(final Button statePropertyBtn, final Label labelReference) {
		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(labelReference, 0, SWT.CENTER);
		statePropertyBtn.setLayoutData(fd);
	}

	private void setLabelLayoutData(final Label initialSectionLabel, final Label labelReference) {
		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, 0);
		fd.top = new FormAttachment(labelReference, ITabbedPropertyConstants.VSPACE);
		initialSectionLabel.setLayoutData(fd);
	}

	@Override
	public void refresh() {
		final List<BehaviorState> behaviorStates = selectedBos.boStream(BehaviorState.class)
				.collect(Collectors.toList());
		final Entry<Boolean, Boolean> completeBtnSelectionAndGray = getButtonSelectionAndGrayedState(
				behaviorStates.iterator(), behaviorState -> behaviorState.isComplete());
		// Set button grayed and selection state
		completeStatePropertyBtn.setSelection(completeBtnSelectionAndGray.getKey());
		completeStatePropertyBtn.setGrayed(completeBtnSelectionAndGray.getValue());

		final Entry<Boolean, Boolean> finalBtnSelectionAndGray = getButtonSelectionAndGrayedState(
				behaviorStates.iterator(), behaviorState -> behaviorState.isFinal());
		// Set button grayed and selection state
		finalStatePropertyBtn.setSelection(finalBtnSelectionAndGray.getKey());
		finalStatePropertyBtn.setGrayed(finalBtnSelectionAndGray.getValue());

		final Entry<Boolean, Boolean> initialBtnSelectionAndGray = getButtonSelectionAndGrayedState(
				behaviorStates.iterator(), behaviorState -> behaviorState.isInitial());
		// Set button grayed and selection state
		initialStatePropertyBtn.setSelection(initialBtnSelectionAndGray.getKey());
		initialStatePropertyBtn.setGrayed(initialBtnSelectionAndGray.getValue());
	}

	private class SetPropertyStateSelectionListener extends SelectionAdapter {
		private final String label;
		private final Button statePropertyBtn;

		public SetPropertyStateSelectionListener(final String label, final Button statePropertyBtn) {
			this.label = label;
			this.statePropertyBtn = statePropertyBtn;
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			selectedBos.modify(label, boc -> boc.getBusinessObject(BehaviorState.class).isPresent(),
					boc -> boc.getBusinessObject(BehaviorState.class).get(),
					(behaviorState, boc) -> behaviorState.setFinal(statePropertyBtn.getSelection()));
		}
	}

	private SimpleEntry<Boolean, Boolean> getButtonSelectionAndGrayedState(final Iterator<BehaviorState> it,
			final Function<BehaviorState, Boolean> getPropertyValue) {
		final boolean isPropertyValue = getPropertyValue.apply(it.next());
		while (it.hasNext()) {
			if (getPropertyValue.apply(it.next()) != isPropertyValue) {
				// Set grayed and selection to true
				return new SimpleEntry<Boolean, Boolean>(true, true);
			}
		}

		// Return selection state and grayed state
		return new SimpleEntry<Boolean, Boolean>(isPropertyValue, false);
	}
}
