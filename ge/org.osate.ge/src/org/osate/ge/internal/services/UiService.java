package org.osate.ge.internal.services;

/**
 * Contains methods for interacting with the graphical editor's user interface components.
 * All methods must be called from the display thread
 *
 */
public interface UiService {
	/**
	 * Activates the specified tool.
	 * Tools are objects that allow the user to perform a specific action using the editor. Only a single tool may be active at a time and tools should have their own
	 * user interface to provide feedback to the user.
	 * The following annotations are used with tools:
	 * Activate - Required
	 * Deactivate - Required
	 * SelectionChanged - Optional
	 */
	void activateTool(final Object tool);

	void deactivateActiveTool();

	void clearSelection();
}
