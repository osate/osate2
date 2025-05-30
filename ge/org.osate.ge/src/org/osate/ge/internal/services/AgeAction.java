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
package org.osate.ge.internal.services;

import org.osate.ge.internal.ui.editor.InternalDiagramEditor;

/**
 * An action which supports undo and redo. Actions are executable using an {@link ActionExecutor}. Because the editor's executor may add additional behavior,
 * it is preferred to use the {@link ActionExecutor} returned by the {@link InternalDiagramEditor#getActionExecutor()} rather than the
 * global {@link ActionService} directly.
 *
 */
public interface AgeAction {
	/**
	 * Returns true if the action can be executed
	 * @return true if the action can be executed
	 */
	default boolean canExecute() {
		return true;
	}

	/**
	 * Performs the action
	 * @return an action that will reverse the action or null if there is nothing to reverse. An action that is not reversible, must return
	 * an action which returns false for canExecute().
	 */
	AgeAction execute();

	/**
	 * Returns false if the action is no longer valid and all references to it should be removed. For example if the action references an editor
	 * which has been closed.
	 * @return true if the action is valid and may potentially be executable
	 */
	default boolean isValid() {
		return true;
	}
}
