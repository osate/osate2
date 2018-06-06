package org.osate.ge.internal.util;

import org.eclipse.core.resources.IFile;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class DiagramUtil {
	public static boolean isDiagram(final IFile file) {
		return file.getName().toLowerCase().endsWith(AgeDiagramEditor.EXTENSION);
	}

}
