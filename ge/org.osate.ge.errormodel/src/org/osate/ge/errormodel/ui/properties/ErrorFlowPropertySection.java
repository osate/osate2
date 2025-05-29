/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.GridDataFactory;
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
import org.osate.ge.errormodel.ui.swt.TypeTokenListField;
import org.osate.ge.errormodel.ui.viewmodels.ErrorFlowTypeTokensModel;
import org.osate.ge.swt.SwtUtil;
import org.osate.ge.ui.PropertySectionUtil;
import org.osate.ge.ui.UiBusinessObjectSelection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;

/**
 * Property section for {@link ErrorFlow} elements
 */
public class ErrorFlowPropertySection extends AbstractPropertySection {
	/**
	 * Filter which determines if the property section is compatible with an object.
	 */
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, ErrorFlow.class::isInstance);
		}
	}

	private static final String WIDGET_ID_PREFIX = "org.osate.ge.errormodel.ui.properties.errorFlow.";

	/**
	 * Testing ID of the label containing the flow's type set tokens
	 * @see SwtUtil#getTestingId(org.eclipse.swt.widgets.Widget)
	 */
	public static final String WIDGET_ID_ERROR_TYPE_SET_TOKENS_LABEL = WIDGET_ID_PREFIX + "typeSetTokens.label";

	/**
	 * Testing ID of the choose button for the flow's type set tokens
	 * @see SwtUtil#getTestingId(org.eclipse.swt.widgets.Widget)
	 */
	public static final String WIDGET_ID_ERROR_TYPE_SET_TOKENS_CHOOSE_BUTTON = WIDGET_ID_PREFIX
			+ "typeSetTokens.choose";

	private BusinessObjectSelection selectedBos;
	private final ErrorFlowTypeTokensModel model = new ErrorFlowTypeTokensModel(new UiBusinessObjectSelection());

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		final Label typeSetLabel = PropertySectionUtil.createSectionLabel(container, getWidgetFactory(),
				"Error Type Set:");

		final TypeTokenListField typeSetTokens = new TypeTokenListField(container, model);
		typeSetTokens.setValueLabelTestingId(WIDGET_ID_ERROR_TYPE_SET_TOKENS_LABEL);
		typeSetTokens.setModifyButtonTestingId(WIDGET_ID_ERROR_TYPE_SET_TOKENS_CHOOSE_BUTTON);
		typeSetTokens
				.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		final FormData typeSetTokensFormData = new FormData();
		typeSetTokensFormData.left = new FormAttachment(0, AbstractPropertySection.STANDARD_LABEL_WIDTH);
		typeSetTokensFormData.right = new FormAttachment(100, 0);
		typeSetTokensFormData.top = new FormAttachment(typeSetLabel, 0, SWT.CENTER);
		typeSetTokensFormData.width = 200;
		typeSetTokens.setLayoutData(typeSetTokensFormData);
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		model.setBusinessObjectSelection(selectedBos);
	}
}
