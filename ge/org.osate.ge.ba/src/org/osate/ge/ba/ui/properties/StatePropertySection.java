/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

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
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ui.PropertySectionUtil;

class StatePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof BehaviorState);
		}
	}

	private final String labelText;
	private final String modifyLabel;
	private final Function<Boolean, BiConsumer<BehaviorState, BusinessObjectContext>> setStateProperty;
	private final Function<BehaviorState, Boolean> getPropertyValue;
	private BusinessObjectSelection selectedBos;
	private Button statePropertyBtn;

	public StatePropertySection(final String labelText, final String modifyLabel,
			final Function<Boolean, BiConsumer<BehaviorState, BusinessObjectContext>> setStateProperty,
			final Function<BehaviorState, Boolean> getPropertyValue) {
		this.labelText = labelText;
		this.modifyLabel = modifyLabel;
		this.setStateProperty = setStateProperty;
		this.getPropertyValue = getPropertyValue;
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = PropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), labelText);
		statePropertyBtn = PropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				new SelectionAdapter() {
					@Override
					public void widgetSelected(final SelectionEvent e) {
						selectedBos.modify(modifyLabel,
								boc -> boc.getBusinessObject(BehaviorState.class).isPresent(),
								boc -> boc.getBusinessObject(BehaviorState.class).get(),
								setStateProperty.apply(statePropertyBtn.getSelection()));
					}
				}, "", SWT.CHECK);

		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		statePropertyBtn.setLayoutData(fd);
	}

	@Override
	public void refresh() {
		final Stream<BehaviorState> behaviorStates = selectedBos.boStream(BehaviorState.class);
		final Entry<Boolean, Boolean> btnSelectionAndGray = getButtonSelectionAndGrayedState(
				behaviorStates.iterator());

		// Set button grayed and selection state
		statePropertyBtn.setSelection(btnSelectionAndGray.getKey());
		statePropertyBtn.setGrayed(btnSelectionAndGray.getValue());
	}

	private SimpleEntry<Boolean, Boolean> getButtonSelectionAndGrayedState(final Iterator<BehaviorState> it) {
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
