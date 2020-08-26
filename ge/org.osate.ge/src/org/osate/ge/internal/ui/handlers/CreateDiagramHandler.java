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
package org.osate.ge.internal.ui.handlers;

import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.util.EditorUtil;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.util.Log;

/**
 * Handler for create diagram menu commands
 *
 */
public class CreateDiagramHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			Log.ok(getClass().getSimpleName() + " Started");

			// Determine the context BO
			final Object contextBo = Objects.requireNonNull(SelectionUtil
					.getDiagramContext(AgeHandlerUtil.getCurrentSelection(), HandlerUtil.getActiveEditor(event)),
					"Unable to determine context business object");

			final DiagramService diagramService = (DiagramService) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getService(DiagramService.class);
			final IFile diagramFile = diagramService.createDiagram(contextBo);

			if(diagramFile != null) {
				EditorUtil.openEditor(diagramFile, false);
			}

			Log.ok(getClass().getSimpleName() + " Finished");
		} catch(RuntimeException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), Activator.PLUGIN_ID, "Error creating diagram: " + e.getMessage());
			Log.error("Error creating diagram", e);
			throw e;
		}

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		final Object contextBo = SelectionUtil.getDiagramContext(
				AgeHandlerUtil.getCurrentSelection(),
				AgeHandlerUtil.getActiveEditorFromContext(evaluationContext));
		setBaseEnabled(contextBo != null);
	}
}
