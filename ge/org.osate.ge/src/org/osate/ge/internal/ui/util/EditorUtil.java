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
package org.osate.ge.internal.ui.util;

import java.util.Objects;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.FileEditorInput;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.internal.ui.handlers.ConfigureDiagramHandler;

/**
 * Utility class containing members related to graphical editor
 *
 */
public final class EditorUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private EditorUtil() {
	}

	private static final String DIAGRAM_EDITOR_ID = "org.osate.gef.ui.editor.AgeEditor";

	/**
	 * Opens the specified diagram file in the diagram editor
	 * @param diagramFile the diagram file to open
	 * @param promptToConfigure if true, the configure diagram dialog will be opened after the editor is opened
	 * @return the opened editor
	 */
	public static InternalDiagramEditor openEditor(final IFile diagramFile, final boolean promptToConfigure) {
		final FileEditorInput editorInput = new FileEditorInput(diagramFile);
		try {
			final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.openEditor(editorInput, DIAGRAM_EDITOR_ID);
			if (editor instanceof InternalDiagramEditor) {
				final InternalDiagramEditor ageEditor = ((InternalDiagramEditor) editor);

				// Prompt to configure the diagram
				if(editor != null && promptToConfigure) {
					final IHandlerService handlerService = Objects.requireNonNull(
							PlatformUI.getWorkbench().getService(IHandlerService.class),
							"Unable to retrieve handler service");
					handlerService.executeCommand(ConfigureDiagramHandler.COMMAND_ID, null);
				}

				return ageEditor;
			} else {
				throw new RuntimeException("Unexpected editor: " + editor);
			}
		} catch (PartInitException | ExecutionException | NotDefinedException | NotEnabledException
				| NotHandledException e) {
			throw new RuntimeException(e);
		}
	}
}
