package org.osate.ge.services;

import org.eclipse.jface.action.IAction;

/**
 * Contains methods for interacting with the graphical editor's user interface components.
 * All methods must be called from the display thread
 * @author philip.alldredge
 *
 */
public interface UiService {
	/**
	 * Returns an IAction for activating the tool with the specified tool ID. Throws an exception if an action cannot be returned.
	 * @param toolId
	 * @return an action for activating for the specified tool ID.
	 */
	IAction getActivateToolAction(final String toolId);
	
	void deactivateActiveTool();
}
