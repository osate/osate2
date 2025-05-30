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
package org.osate.ge.internal.ui.handlers;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.diagram.runtime.updating.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.updating.BusinessObjectTreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.dialogs.DefaultDiagramConfigurationDialogModel;
import org.osate.ge.internal.ui.dialogs.DiagramConfigurationDialog;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;

/**
 * Handler for the configure diagram command
 *
 */
public class ConfigureDiagramHandler extends AbstractHandler {
	/**
	 * The ID of the configure diagram command
	 */
	public static String COMMAND_ID = "org.osate.ge.configureDiagram";

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getActiveEditorFromContext(evaluationContext) instanceof InternalDiagramEditor);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof InternalDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected elements
		final InternalDiagramEditor diagramEditor = (InternalDiagramEditor) activeEditor;
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = diagramEditor.getDiagram();
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		// Get services
		final BusinessObjectTreeUpdater boTreeUpdater = diagramEditor.getBoTreeUpdater();
		final DiagramUpdater diagramUpdater = diagramEditor.getDiagramUpdater();
		final ProjectProvider projectProvider = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ProjectProvider.class), "Unable to retrieve project provider");
		final LayoutInfoProvider layoutInfoProvider = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, LayoutInfoProvider.class),
				"Unable to retrieve layout information provider");
		final ExtensionRegistryService extService = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ExtensionRegistryService.class), "Unable to retrieve extension service");
		final ProjectReferenceService referenceService = Objects.requireNonNull(
				Adapters.adapt(diagramEditor, ProjectReferenceService.class), "Unable to retrieve reference service");

		BusinessObjectNode boTree = DiagramToBusinessObjectTreeConverter.createBusinessObjectNode(diagram);

		// Update the tree so that it's business objects are refreshed
		boTree = boTreeUpdater.updateTree(diagram.getConfiguration(), boTree);

		final DefaultDiagramConfigurationDialogModel model = new DefaultDiagramConfigurationDialogModel(
				referenceService, extService, projectProvider, diagram.getConfiguration().getDiagramType());
		// Create a BO path for the initial selection. The initial selection will be the first diagram element which will be included in the BO tree.
		Object[] initialSelectionBoPath = null;
		for (final DiagramElement selectedDiagramElement : selectedDiagramElements) {
			if (model.shouldShowBusinessObject(selectedDiagramElement.getBusinessObject())) { // Only build a selection path if the BO will be shown
				DiagramNode tmp = selectedDiagramElement;
				final LinkedList<Object> boList = new LinkedList<>();
				while (tmp instanceof DiagramElement) {
					boList.addFirst(tmp.getBusinessObject());
					tmp = tmp.getParent();
				}

				initialSelectionBoPath = boList.toArray();
				break;
			}
		}

		// Show the dialog
		final DiagramConfigurationDialog.Result result = DiagramConfigurationDialog.show(null, model,
				diagram.getConfiguration(), boTree, initialSelectionBoPath);
		if (result != null) {
			// Update the diagram
			diagramEditor.getActionExecutor().execute("Set Diagram Configuration", ExecutionMode.NORMAL, () -> {
				diagram.modify("Set Diagram Configuration", m -> {
					m.setDiagramConfiguration(result.getDiagramConfiguration());
					diagramUpdater.updateDiagram(diagram, result.getBusinessObjectTree());
				});
				// Clear ghosts triggered by this update to prevent them from being unghosted during the next update.
				diagramUpdater.clearGhosts();

				diagram.modify("Layout",
						m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, layoutInfoProvider));

				return null;
			});
		}

		return null;
	}
}
