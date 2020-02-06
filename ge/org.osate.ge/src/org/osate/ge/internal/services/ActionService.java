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
package org.osate.ge.internal.services;

import java.util.function.Consumer;

/**
 * ActionExecutor that manages an action stack. The action stack allows undoing and redoing actions.
 * It also provides notifications of changes to the action stack.
 *
 * ActionService implementations must handle the execution of actions while another action is running.
 *
 */
public interface ActionService extends ActionExecutor {
	public interface ActionStackChangeListener {
		void actionStackChanged();
	}

	public interface ActionGroup {

	}

	void addChangeListener(ActionStackChangeListener listener);
	void removeChangeListener(ActionStackChangeListener listener);

	/**
	 *
	 * @return true if an action is currently being executed.
	 */
	boolean isActionExecuting();

	String getUndoLabel();
	boolean canUndo();
	void undo();

	String getRedoLabel();
	boolean canRedo();
	void redo();

	/**
	 * Clears the action stack
	 */
	void clearActionStack();
	void removeInvalidActions();

	/**
	 * Recommended to use execute() instead. Exposed to allow better integration with Graphiti.
	 * @param label
	 * @param mode
	 * @return an object for referencing the action group. May return null if the action group is not a top level action group.
	 */
	ActionGroup beginExecuteGroup(final String label, ExecutionMode mode);

	boolean endExecuteGroup(final ActionGroup actionGroup);

	/**
	 * Adds a wrapper to the current action group that will be used when undo/redoing. If the wrapper has already been added
	 * to the current action group, this method is a no-op.
	 * @param wrapper
	 */
	void addUndoWrapper(final Consumer<Runnable> wrapper);
}
