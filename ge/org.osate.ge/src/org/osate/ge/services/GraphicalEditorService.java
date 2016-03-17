package org.osate.ge.services;

import org.osate.ge.GraphicalEditor;

public interface GraphicalEditorService {
	/**
	 * Opens a diagram which is linked to the specified specified business object in a graphical editor. If a diagram is not found, one is created.
	 * @param bo
	 * @return the editor in which the diagram was open. Throws an exception if the editor could not be opened.
	 */
	GraphicalEditor openBusinessObject(Object bo);
}
