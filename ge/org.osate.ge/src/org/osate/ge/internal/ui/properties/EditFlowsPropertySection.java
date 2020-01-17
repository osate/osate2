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
package org.osate.ge.internal.ui.properties;

import java.util.Objects;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.EditFlowsDialog;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class EditFlowsPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> getComponentImplementation(bo) != null);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button editFlowsBtn;

	private static ComponentImplementation getComponentImplementation(final Object bo) {
		if (bo instanceof ComponentImplementation) {
			return (ComponentImplementation) bo;
		} else if (bo instanceof Subcomponent) {
			return ((Subcomponent) bo).getComponentImplementation();
		}

		return null;
	}

	private final SelectionListener editFlowsSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Bundle bundle = FrameworkUtil.getBundle(getClass());
			final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
			final NamingService namingService = Objects.requireNonNull(context.getActive(NamingService.class),
					"Unable to retrieve naming service");

			final ComponentImplementation readonlyComponentImplementation = selectedBos.bocStream().findFirst()
					.map(boc -> getComponentImplementation(boc.getBusinessObject())).orElse(null);
			if (readonlyComponentImplementation == null) {
				return;
			}

			// Show the edit flows dialog
			final EditFlowsDialog dlg = new EditFlowsDialog(Display.getCurrent().getActiveShell(), namingService,
					readonlyComponentImplementation);
			if (dlg.open() != Window.CANCEL) {
				selectedBos.modify(boc -> getComponentImplementation(boc.getBusinessObject()), (compImpl, boc) -> {
					// Clear existing flows
					compImpl.getOwnedEndToEndFlows().clear();
					compImpl.getOwnedFlowImplementations().clear();

					for (final Flow flow : dlg.getFlows()) {
						if (flow instanceof EndToEndFlow) {
							compImpl.getOwnedEndToEndFlows().add((EndToEndFlow) flow);
							compImpl.setNoFlows(false);
						} else if (flow instanceof FlowImplementation) {
							compImpl.getOwnedFlowImplementations().add((FlowImplementation) flow);
							compImpl.setNoFlows(false);
						}
					}
				});
			}
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);

		editFlowsBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, null,
				editFlowsSelectionListener,
				"Edit...", SWT.PUSH);
		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		editFlowsBtn.setLayoutData(fd);
		InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "Flows:");
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		editFlowsBtn.setEnabled(selectedBos.bocStream().count() == 1);
	}
}
