package org.osate.ge.internal.ui.util;

import java.util.Objects;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.handlers.ConfigureDiagramHandler;

public class EditorUtil {
	public static AgeDiagramEditor openEditor(final IFile diagramFile, final boolean promptToConfigure) {
		final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		final DiagramEditorInput editorInput = new DiagramEditorInput(uri, AgeDiagramTypeProvider.id);
		try {
			final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, AgeDiagramEditor.DIAGRAM_EDITOR_ID);
			if(editor instanceof AgeDiagramEditor) {
				final AgeDiagramEditor ageEditor = ((AgeDiagramEditor) editor);

				// Prompt to configure the diagram
				if(editor != null && promptToConfigure) {
					final IHandlerService handlerService = Objects.requireNonNull(
							PlatformUI.getWorkbench().getService(IHandlerService.class),
							"Unable to retrieve handler service");
					handlerService.executeCommand(ConfigureDiagramHandler.COMMAND_ID, null);
				}

				return ageEditor;
			} else {
				throw new RuntimeException("Unexpected editor: " + editor);
			}
		} catch (PartInitException | ExecutionException | NotDefinedException | NotEnabledException
				| NotHandledException e) {
			throw new RuntimeException(e);
		}
	}
}
