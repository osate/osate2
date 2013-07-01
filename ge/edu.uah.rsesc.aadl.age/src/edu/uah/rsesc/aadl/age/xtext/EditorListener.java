package edu.uah.rsesc.aadl.age.xtext;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

public class EditorListener implements IPartListener {
	private IXtextModelListener modelListener;
	
	public EditorListener(final IWorkbenchPage activePage, final IXtextModelListener modelListener) {
		this.modelListener = modelListener;
		
		for(final IEditorReference editorRef : activePage.getEditorReferences()) {
			IEditorPart editor = editorRef.getEditor(false);
			if (editor != null) {
				partOpened(editor);
			}
		}
	}
	
	@Override
	public void partActivated(IWorkbenchPart part) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		if(part instanceof XtextEditor) {
			final XtextEditor editor = (XtextEditor)part;
			editor.getDocument().addModelListener(modelListener);
		}
	}
	
	@Override
	public void partClosed(IWorkbenchPart part) {
		if(part instanceof XtextEditor) {
			final XtextEditor editor = (XtextEditor)part;
			editor.getDocument().removeModelListener(modelListener);
		}
	}
}
