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
package org.osate.ge.internal.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.ui.editor.EditorRenameUtil;
import org.osate.ge.internal.ui.editor.InternalDiagramEditor;
import org.osate.ge.swt.name.NameEditorDialogModel;

public class RenameHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		final boolean enabled = calculateEnabled(evaluationContext);
		setBaseEnabled(enabled);
	}

	private boolean calculateEnabled(final Object evaluationContext) {
		final IEditorPart activeEditor = AgeHandlerUtil.getActiveEditorFromContext(evaluationContext);
		if (!(activeEditor instanceof InternalDiagramEditor)) {
			return false;
		}

		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil
				.getSelectedDiagramElements();
		if (selectedDiagramElements.size() != 1) {
			return false;
		}

		for (final DiagramElement de : selectedDiagramElements) {
			if (!EditorRenameUtil.canRename(de)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof InternalDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected elements
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		if (selectedDiagramElements.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final DiagramElement selectedElement = selectedDiagramElements.get(0);
		final InternalDiagramEditor editor = (InternalDiagramEditor) activeEditor;

		org.osate.ge.swt.name.NameEditorDialog.open(Display.getCurrent().getActiveShell(),
				new NameEditorDialogModel() {
			@Override
			public String getName() {
				return EditorRenameUtil.getCurrentName(selectedElement);
			}

			@Override
			public String validateName(String newName) {
						return EditorRenameUtil.validateName(selectedElement, newName);
			}

			@Override
					public void setName(final String value) {
				EditorRenameUtil.rename(selectedElement, value, editor);
			}
		});

		return null;
	}
}