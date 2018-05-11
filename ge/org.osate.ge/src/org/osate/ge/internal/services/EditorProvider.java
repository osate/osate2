package org.osate.ge.internal.services;

import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public interface EditorProvider {	
	/**
	 * Get the editor for the current diagram.
	 * @return
	 */
	AgeDiagramEditor getEditor();
}
