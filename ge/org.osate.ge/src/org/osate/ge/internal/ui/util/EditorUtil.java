package org.osate.ge.internal.ui.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class EditorUtil {
	public static AgeDiagramEditor openEditor(final IFile diagramFile) {
		final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		final DiagramEditorInput editorInput = new DiagramEditorInput(uri, AgeDiagramTypeProvider.id);
		try {
			final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, AgeDiagramEditor.DIAGRAM_EDITOR_ID);
			if(editor instanceof AgeDiagramEditor) {
				return (AgeDiagramEditor)editor;
			} else {
				throw new RuntimeException("Unexpected editor: " + editor);
			}
		} catch (PartInitException e) {
			throw new RuntimeException(e);
		}
	}
}
