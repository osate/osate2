package edu.uah.rsesc.aadl.age.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.core.OsateCorePlugin;

import com.google.inject.Injector;

public class EditorListener implements IPartListener {
	private IXtextModelListener modelListener = (new IXtextModelListener() {
		@Override
		public void modelChanged(final XtextResource resource) {
			//org.eclipse.xtext.resource.SynchronizedXtextResourceSet@50f6880e resources=[org.eclipse.xtext.linking.lazy.LazyLinkingResource@394393a3 uri='platform:/resource/TestProject/packages/test_case.aadl']
			// TODO: Find way to get this resource sent to the diagram editor.... As read only... All the links would need to be reevaluated
			// How slow to refresh diagram?			
			/*
			if(resource.getContents().size() > 0) {
				final EObject contents = resource.getContents().get(0);
				if(contents instanceof AadlPackage) {
					final AadlPackage pkg = (AadlPackage)contents;
					for(final NamedElement el : pkg.getPublicSection().getMembers()) {
						System.out.println(el);
					}
				}
			}*/
		}				
	});
	
	public EditorListener(final IWorkbenchPage activePage) {
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
