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
package org.osate.ge.errormodel.ui.properties;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.check.CheckboxEditor;
import org.osate.ge.swt.check.CheckboxEditorModel;
import org.osate.ge.ui.PropertySectionUtil;
import org.osate.ge.ui.UiBusinessObjectSelection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;

public class ErrorBehaviorStatePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				return bo instanceof ErrorBehaviorState
						&& ((ErrorBehaviorState) bo).eContainer() instanceof ErrorBehaviorStateMachine;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private CheckboxEditor initialStateEditor;

	private InitialStateModel initialStateModel = new InitialStateModel();

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = PropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "");

		initialStateEditor = new CheckboxEditor(composite, initialStateModel);

		{
			final FormData fd = new FormData();
			fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
			fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
			initialStateEditor.setLayoutData(fd);
		}
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		initialStateModel.setBusinessObjectSelection(selectedBos);
	}

	private static class InitialStateModel extends BaseObservableModel implements CheckboxEditorModel {
		private BusinessObjectSelection bos;

		public InitialStateModel() {
			setBusinessObjectSelection(new UiBusinessObjectSelection());
		}

		/**
		* Refreshes the internal state of the model based on the specified business object selection
		*/
		public final void setBusinessObjectSelection(final BusinessObjectSelection value) {
			this.bos = Objects.requireNonNull(value, "value must not be null");
			triggerChangeEvent();
		}

		@Override
		public void setValue(boolean value) {
			bos.modify(ErrorBehaviorState.class, state -> {
				final ErrorBehaviorStateMachine sm = (ErrorBehaviorStateMachine) state.eContainer();

				// Clear initial state of all states
				for (final ErrorBehaviorState tmpState : sm.getStates()) {
					if (tmpState.isIntial()) {
						tmpState.setIntial(false);
					}
				}

				// Set selected state as the initial state
				state.setIntial(value);
			});
		}

		@Override
		public boolean isEnabled() {
			return bos.boStream(ErrorBehaviorState.class).limit(2).count() == 1;
		}

		@Override
		public Boolean getValue() {
			final Set<ErrorBehaviorState> states = bos.boStream(ErrorBehaviorState.class)
					.collect(Collectors.toSet());
			return states.size() == 1 && states.iterator().next().isIntial();
		}

		@Override
		public String getLabel() {
			return "Initial";
		}
	}
}
