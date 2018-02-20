package org.osate.ui.handlers;

import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.instantiation.InstantiateModel;

public class ReinstantiateHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile file = (IFile) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();

		Arrays.stream(page.getEditorReferences()).filter(editor -> editor.getPartName().equals(file.getName()))
				.forEach(editor -> page.closeEditor(editor.getEditor(true), true));

		try {
			InstantiateModel.rebuildInstanceModelFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}