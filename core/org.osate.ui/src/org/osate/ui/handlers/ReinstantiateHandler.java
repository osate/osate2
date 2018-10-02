package org.osate.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.instantiation.InstantiateModel;

public class ReinstantiateHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile file = (IFile) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();

		try {
			InstantiateModel.rebuildInstanceModelFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}