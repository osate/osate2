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

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Handler for the command for hiding all the contents of a diagram element
 *
 */
public class HideAllContentsHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof InternalDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get the extension registry
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = EclipseContextFactory.getServiceContext(bundle.getBundleContext())
				.get(ExtensionRegistryService.class);
		if (extService == null) {
			throw new RuntimeException("Unable to retrieve extension registry");
		}

		// Get diagram and selected elements
		final InternalDiagramEditor diagramEditor = (InternalDiagramEditor) activeEditor;
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		diagram.modify("Hide All Contents", m -> {
			// Remove children of selected elements
			for (final DiagramElement e : selectedDiagramElements) {
				for (final DiagramElement child : e.getChildren()) {
					m.removeElement(child);
				}
			}
		});

		// Update the diagram
		diagramEditor.updateDiagram();

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedDiagramElements().size() > 0);
	}
}
