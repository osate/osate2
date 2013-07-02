package edu.uah.rsesc.aadl.age.xtext;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;

public class EditorListener implements IPartListener {
	private ModelListener modelListener;
	private Map<IXtextDocument, IXtextModelListener> xtextModelListeners = new HashMap<IXtextDocument, IXtextModelListener>();
	
	public EditorListener(final IWorkbenchPage activePage, final ModelListener modelListener) {
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
			final IXtextDocument document = editor.getDocument();
			final IXtextModelListener newListener = createListener(document);
			xtextModelListeners.put(document, newListener);
			editor.getDocument().addModelListener(newListener);
			
			// Trigger the initial model changed event
			document.readOnly(new IUnitOfWork<String, XtextResource>() {
				@Override
				public String exec(final XtextResource resource) throws Exception {
					modelListener.modelChanged(document, resource);
					return null;
				}
			});
		}
	}
	
	@Override
	public void partClosed(IWorkbenchPart part) {
		if(part instanceof XtextEditor) {
			final XtextEditor editor = (XtextEditor)part;
			final IXtextDocument document = editor.getDocument();
			final IXtextModelListener listener = xtextModelListeners.get(document);
			if(listener != null) {
				document.removeModelListener(listener);
				modelListener.removeDocumentInfo(document);
			}
		}
	}
	
	private IXtextModelListener createListener(final IXtextDocument document) {
		return new IXtextModelListener() {
			@Override
			public void modelChanged(final XtextResource resource) {
				modelListener.modelChanged(document, resource);
			}
		};
	}
}
