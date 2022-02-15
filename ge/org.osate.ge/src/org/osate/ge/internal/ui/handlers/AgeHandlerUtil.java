/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.ui.tools.Tool;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;

import com.google.common.collect.ImmutableList;

/**
 * Contains utility functions for implementing command handlers
 *
 */
public final class AgeHandlerUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private AgeHandlerUtil() {
	}

	/**
	 * Returns the current selection as diagram elements. Any of the selected objects which cannot be adapted to {@link DiagramElement} will be ignored.
	 * @return the current selection as diagram elements
	 */
	public static List<DiagramElement> getSelectedDiagramElements() {
		final ISelection selection = getCurrentSelection();
		return SelectionUtil.getSelectedDiagramElements(selection, true);
	}

	/**
	 * Returns the current selection as diagram nodes. Any of the selected objects which cannot be adapted to {@link DiagramNode} will be ignored.
	 * @return the current selection as diagram nodes
	 */
	public static List<DiagramNode> getSelectedDiagramNodes() {
		return SelectionUtil.getSelectedDiagramNodes(getCurrentSelection(), true);
	}

	/**
	 * Returns the current selection as business objecs contexts. Any of the selected objects which cannot be adapted to {@link BusinessObjectContext}
	 * will be ignored.
	 * @return the current selection as business object contexts
	 */
	public static ImmutableList<BusinessObjectContext> getSelectedBusinessObjectContexts() {
		return SelectionUtil.getSelectedBusinessObjectContexts(getCurrentSelection());
	}

	/**
	 * Returns the primary selection from a list of selected diagram elements.
	 * @param elements the element from which to return the primary selection.
	 * @return the first element is the specified list. Returns null if the list is empty.
	 */
	public static DiagramElement getPrimaryDiagramElement(final List<DiagramElement> elements) {
		if (elements.isEmpty()) {
			return null;
		}

		return elements.get(elements.size() - 1);
	}

	/**
	 * Activates a tool for the active editor
	 * @param event the event used to determine the active editor
	 * @param tool the tool to activate
	 */
	public static void activateTool(final ExecutionEvent event, final Tool tool) {
		final IEditorPart editorPart = HandlerUtil.getActiveEditor(event);
		final UiService uiService = Adapters.adapt(editorPart, UiService.class);
		if (uiService == null) {
			throw new RuntimeException("Unable to get UiService");
		}

		uiService.activateTool(tool);
	}

	/**
	 * Returns the current selection of the active window.
	 * @return the current selection of the active window. If the active workbench window could not be retrieved, an empty selection will be returned.
	 */
	public static ISelection getCurrentSelection() {
		final IWorkbenchWindow win = UiUtil.getActiveWorkbenchWindow();
		if (win == null) {
			return StructuredSelection.EMPTY;
		}

		return win.getSelectionService().getSelection();
	}

	/**
	 * Returns the active editor part based on the evaluation context provided to a command.
	 * @param evaluationContext the evaluation context that was provided to the command
	 * @return the active editor based on the specified evaluation context. Returns null if the active editor could not be retrieved.
	 */
	public static IEditorPart getActiveEditorFromContext(final Object evaluationContext) {
		if (!(evaluationContext instanceof IEvaluationContext)) {
			return null;
		}

		final IEvaluationContext context = (IEvaluationContext) evaluationContext;
		final Object editorObj = context.getVariable(ISources.ACTIVE_EDITOR_NAME);
		return editorObj instanceof IEditorPart ? (IEditorPart) editorObj : null;
	}
}
