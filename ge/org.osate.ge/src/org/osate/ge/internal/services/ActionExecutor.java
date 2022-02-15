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
package org.osate.ge.internal.services;

/**
 * Interface for an object which executed actions
 *
 */
public interface ActionExecutor {
	/**
	 * Modes which affect how an action is executed.
	 *
	 */
	enum ExecutionMode {
		/**
		 * The action will be executed. If an action is not in progress, an entry on the undo stack will be created.
		 */
		NORMAL,
		/**
		 * The action will be executed and will become part of the previous action. It will be append to end of the previous action.
		 * If there isn't a previous action, the behavior will be the same as {@link #HIDE}.
		 */
		APPEND_ELSE_HIDE,
		/**
		 * The action will be executed but will not be added to the undo stack. This should only be used in the rare case that the action should not
		 * be added to undo stack and it will not interfere with undoing previous actions.
		 */
		HIDE,
	}

	/**
	 * Executes an action.
	 * @param label the label for the action
	 * @param mode the mode to use to execute the action
	 * @param action the action to execute
	 * @return true if a reversable modification was performed.
	 */
	boolean execute(String label, ExecutionMode mode, AgeAction action);
}
