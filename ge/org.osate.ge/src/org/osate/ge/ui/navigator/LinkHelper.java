package org.osate.ge.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;

public class LinkHelper implements ILinkHelper {

	@Override
	public IStructuredSelection findSelection(final IEditorInput anInput) {
		final IFile file = ResourceUtil.getFile(anInput);
		if(file != null) {
			return new StructuredSelection(file);
		}
		
		return StructuredSelection.EMPTY;
	}

	@Override
	public void activateEditor(final IWorkbenchPage aPage, final IStructuredSelection aSelection) {
		// Not used. The default activateEditor behavior works as desired.
	}
}
