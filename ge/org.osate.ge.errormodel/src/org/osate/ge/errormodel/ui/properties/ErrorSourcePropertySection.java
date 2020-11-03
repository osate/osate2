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
package org.osate.ge.errormodel.ui.properties;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.util.Strings;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.errormodel.ui.swt.FaultSourceField;
import org.osate.ge.errormodel.ui.viewmodels.FaultSourceModel;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.ui.PropertySectionUtil;
import org.osate.ge.ui.UiBusinessObjectSelection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.IfCondition;

public class ErrorSourcePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				return bo instanceof ErrorSource;
			});
		}
	}

	private static final String WIDGET_ID_PREFIX = "org.osate.ge.errormodel.ui.properties.errorSource.";
	public static final String WIDGET_ID_FAULT_SOURCE_LABEL = WIDGET_ID_PREFIX + "faultSource.Label";
	public static final String WIDGET_ID_FAULT_SOURCE_CHOOSE_BUTTON = WIDGET_ID_PREFIX + "faultSource.Choose";
	public static final String WIDGET_ID_FAULT_CONDITION_TEXT = WIDGET_ID_PREFIX + "faultCondition";
	private BusinessObjectSelection selectedBos;
	private final FaultSourceModel model = new FaultSourceModel(new UiBusinessObjectSelection());
	private FaultSourceField faultSourceField;
	private Text faultConditionField;
	private final FocusListener faultConditionFocusListener = new FocusAdapter() {
		@Override
		public void focusLost(final FocusEvent e) {
			selectedBos.modify(ErrorSource.class, (src) -> {
				if (Strings.isEmpty(faultConditionField.getText().trim())) {
					if (src.getFlowcondition() != null) {
						EcoreUtil.remove(src.getFlowcondition());
					}
				} else {
					IfCondition condition = src.getFlowcondition();
					if (condition == null) {
						condition = ErrorModelFactory.eINSTANCE.createIfCondition();
						src.setFlowcondition(condition);
					}

					condition.setDescription(faultConditionField.getText());
				}
			});
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite container = getWidgetFactory().createFlatFormComposite(parent);

		final Label faultSourceLabel = PropertySectionUtil.createSectionLabel(container, getWidgetFactory(),
				"Fault Source:");
		faultSourceField = new FaultSourceField(container, model);
		faultSourceField.setValueLabelTestingId(WIDGET_ID_FAULT_SOURCE_LABEL);
		faultSourceField.setModifyButtonTestingId(WIDGET_ID_FAULT_SOURCE_CHOOSE_BUTTON);

		final Label faultConditionLabel = PropertySectionUtil.createSectionLabel(container, getWidgetFactory(),
				"Fault\nCondition:");
		faultConditionField = new Text(container, SWT.SINGLE | SWT.BORDER);
		faultConditionField.addFocusListener(faultConditionFocusListener);
		SwtUtil.setTestingId(faultConditionField, WIDGET_ID_FAULT_CONDITION_TEXT);

		{
			final FormData fd = new FormData();
			fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
			fd.top = new FormAttachment(faultSourceLabel, 0, SWT.CENTER);
			fd.right = new FormAttachment(100, 0);
			fd.width = 200;
			faultSourceField.setLayoutData(fd);
		}

		{
			final FormData fd = new FormData();
			fd.top = new FormAttachment(faultSourceLabel, ITabbedPropertyConstants.VSPACE);
			faultConditionLabel.setLayoutData(fd);
		}

		{
			final FormData fd = new FormData();
			fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
			fd.top = new FormAttachment(faultConditionLabel, 0, SWT.CENTER);
			fd.right = new FormAttachment(100, 0);
			fd.width = 200;
			faultConditionField.setLayoutData(fd);
		}
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		model.setBusinessObjectSelection(selectedBos);

		// Update the flow description field
		final Set<String> flowDescriptions = selectedBos.boStream(ErrorSource.class).map(
				s -> s.getFlowcondition() == null ? "" : Strings.emptyIfNull(s.getFlowcondition().getDescription()))
				.collect(Collectors.toSet());
		if (flowDescriptions.isEmpty()) {
			faultConditionField.setText("<No Selection>");
			faultConditionField.setEnabled(false);
		} else if (flowDescriptions.size() == 1) {
			faultConditionField.setText(flowDescriptions.iterator().next());
			faultConditionField.setEnabled(true);
		} else {
			faultConditionField.setText("<Multiple Values>");
			faultConditionField.setEnabled(false);
		}
	}
}
