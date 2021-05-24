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
package org.osate.ge.internal.ui.editor;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ui.IWorkbenchPart3;
import org.osate.ge.GraphicalEditor;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.botree.TreeUpdater;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.ui.tools.Tool;

/**
 * Internal interface for the diagram editor. Defines functionality needed internally which must be provided by the editor implementation.
 */
public interface InternalDiagramEditor extends GraphicalEditor, IWorkbenchPart3 {
	/**
	 * Returns the project in which the diagram is located.
	 * @return the project containing the diagram.
	 */
	IProject getProject();

	/**
	 * Returns the file from which the diagram was loaded.
	 * @return the file from which the diagram was loaded.
	 */
	IFile getDiagramFile();

	/**
	 * Updates the diagram . If the current thread is not the UI thread, the update will be performed by the UI thread asynchronously.
	 */
	void updateNowIfModelHasChanged();

	/**
	 * Sets a flag which ensures the diagram is updated after the next model update regardless of whether the editor is visible.
	 */
	void forceDiagramUpdateOnNextModelChange();

	/**
	 * Returns the diagram which is being edited.
	 * @return the diagram
	 */
	AgeDiagram getDiagram();

	/**
	 * Clears the current selection in the editor and the outline
	 */
	void clearSelection();

	/**
	 * Closes the editor
	 */
	void closeEditor();

	/**
	 * Activates the specified tool
	 * @param tool the tool to activate
	 */
	void activateTool(final Tool tool);

	/**
	 * Deactivate the active tool.
	 */
	void deactivateActiveTool();

	/**
	 * Updates the diagram and performs incremental layout
	 */
	void updateDiagram();

	/**
	 * Returns an action executor that ensures that when an action is undone, the editor is automatically activated as appropriate.
	 * @return
	 */
	ActionExecutor getActionExecutor();

	/**
	 * Performs a diagram modification.
	 * @param label the label to use for the modification.
	 * @param modifier the modifier for the transaction
	 */
	void modifyDiagram(final String label, final DiagramModifier modifier);

	/**
	 * Returns the diagram update used to update the diagram
	 * @return the diagram updater
	 */
	DiagramUpdater getDiagramUpdater();

	/**
	 * Returns the {@link TreeUpdater} used to update the business object tree.
	 * @return the business object tree updater.
	 */
	TreeUpdater getBoTreeUpdater();

	/**
	 * Returns the action handler that should be executed to handle a global action.
	 * @param actionId the global action ID
	 * @return the editor specific action handler for the global action. Null if the editor does not define a handler for the action.
	 */
	IAction getGlobalActionHandler(String actionId);

	/**
	 * Returns a list containing the selected diagram elements.
	 * @return a list containing the selected diagram elements.
	 */
	List<DiagramElement> getSelectedDiagramElements();

	/**
	 * Returns a set containing the selected diagram elements.
	 * @return a set containing the selected diagram elements.
	 */
	default Set<DiagramElement> getSelectedDiagramElementSet() {
		return new HashSet<>(getSelectedDiagramElements());
	}

	/**
	 * Sets the selection to the specified diagram nodes.
	 * @param diagramNodes the nodes to select.
	 */
	void selectDiagramNodes(Collection<? extends DiagramNode> diagramNodes);

	/**
	 * Adds a listener that will be called when the selection changes.
	 * @param listener the selection listener.
	 */
	void addSelectionChangedListener(ISelectionChangedListener listener);

	/**
	 * Returns whether the editor has been disposed.
	 * @return whether the editor has been disposed.
	 */
	boolean isDisposed();

	/**
	 * Returns whether the diagram displayed by the editor is editable.
	 * @return whether the contents of the editor can be edited.
	 */
	boolean isEditable();
}
