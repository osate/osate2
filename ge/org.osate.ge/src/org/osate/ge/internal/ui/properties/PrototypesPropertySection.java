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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Classifier;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.selection.AgeBusinessObjectSelection;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ModelChangeNotifier;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.ui.LtkRenameAction;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.viewModels.PrototypesModel;
import org.osate.ge.swt.prototypes.PrototypesEditor;
import org.osate.ge.ui.properties.PropertySectionUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Property section for editing prototypes.
 *
 */
public class PrototypesPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof Classifier);
		}
	}

	private BusinessObjectSelection selectedBos;
	private final PrototypesModel model = new PrototypesModel(
			(prototypeSupplier, name, originalName) -> {
				final AgeDiagramEditor editor = UiUtil.getActiveDiagramEditor();
				if (editor == null) {
					throw new RuntimeException("Editor not active");
				}

				final ProjectProvider projectProvider = (ProjectProvider) Objects
						.requireNonNull(editor.getAdapter(ProjectProvider.class),
								"Unable to get project provider");
				final ModelChangeNotifier modelChangeNotifier = (ModelChangeNotifier) Objects.requireNonNull(
						editor.getAdapter(ModelChangeNotifier.class), "Unable to get model change notifier");
				final ActionService actionService = (ActionService) Objects
						.requireNonNull(editor.getAdapter(ActionService.class), "Unable to get action service");

				final LtkRenameAction action = new LtkRenameAction(projectProvider, modelChangeNotifier,
						currentName -> prototypeSupplier.getBusinessObject(currentName), name, originalName);
				actionService.execute("Rename Prototype " + originalName + " to " + name,
						ActionExecutor.ExecutionMode.NORMAL, action);
			}, getNamingService(),
			new AgeBusinessObjectSelection());

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label label = getWidgetFactory().createLabel(composite, "Prototypes:");
		final PrototypesEditor<?, ?> editor = new PrototypesEditor<>(composite, model);

		// Configure layout data
		{
			final FormData data = new FormData();
			data.left = new FormAttachment(0, 0);
			data.right = new FormAttachment(editor, -ITabbedPropertyConstants.HSPACE);
			data.top = new FormAttachment(editor, 0, SWT.CENTER);
			label.setLayoutData(data);
		}

		{
			final FormData data = new FormData();
			data.left = new FormAttachment(0, AbstractPropertySection.STANDARD_LABEL_WIDTH);
			data.right = new FormAttachment(100, 0);
			data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
			editor.setLayoutData(data);
		}

		composite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				if (aTabbedPropertySheetPage != null) {
					aTabbedPropertySheetPage.resizeScrolledComposite();
				}
			}
		});
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

	private static NamingService getNamingService() {
		final Bundle bundle = FrameworkUtil.getBundle(PropertySectionUtil.class);
		final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
		return Objects.requireNonNull(context.getActive(NamingService.class), "Unable to retrieve naming service");
	}
}
