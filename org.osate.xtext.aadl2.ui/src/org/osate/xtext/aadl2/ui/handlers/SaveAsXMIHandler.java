package org.osate.xtext.aadl2.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2ResourceImpl;

import com.google.inject.Inject;

public class SaveAsXMIHandler extends AbstractHandler {


	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null)
			return null;
		XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
		final ISelection selection;
		if (xtextEditor != null) {
			if (part instanceof ContentOutline) {
				selection = ((ContentOutline) part).getSelection();
			} else {
				selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
			}

			xtextEditor.getDocument().readOnly(
					new IUnitOfWork<EObject, XtextResource>() {
						public EObject exec(XtextResource resource) throws Exception {
							EObject targetElement = null;
							if (selection instanceof IStructuredSelection) {
								IStructuredSelection ss = (IStructuredSelection) selection;
								Object eon = ss.getFirstElement();
								if (eon instanceof EObjectNode) {
									targetElement = ((EObjectNode)eon).getEObject(resource);
								}
							} else {
								targetElement = eObjectAtOffsetHelper.resolveElementAt(resource,
										((ITextSelection)selection).getOffset());
							}
							
							if (targetElement != null) {
//								ResourceSet rs = new ResourceSetImpl();
//								Resource resource = rs.getResource(URI.createURI("./mymodel.dmodel"), true);
								EObject eobject = resource.getContents().get(0);
								//persist xmi resource
								Aadl2ResourceFactoryImpl resFactory = new Aadl2ResourceFactoryImpl();
								URI xtxturi = resource.getURI();
								URI xmiuri = xtxturi.trimFileExtension().appendFileExtension("aaxl2");
								Aadl2ResourceImpl xmiresource =  (Aadl2ResourceImpl) resFactory.createResource(xmiuri);
								xmiresource.getContents().add(eobject);
								xmiresource.save();
								
								return null;
							}
							return null;
						}
					});
		}
		return null;
	}
	
//	@Override
//	public boolean isEnabled() {
//		IWorkbench wb = PlatformUI.getWorkbench();
//		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
//		IWorkbenchPage page = win.getActivePage();
//		IWorkbenchPart part = page.getActivePart();
//		IEditorPart activeEditor = page.getActiveEditor();
//		if (activeEditor == null)
//			return false;
//		XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
//		final ISelection selection;
//		if (xtextEditor != null) {
//			if (part instanceof ContentOutline) {
//				selection = ((ContentOutline) part).getSelection();
//			} else {
//				selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
//			}
//		}
//		Resource resource = xtextEditor.getResource();
//		Resource resource = xtextEditor.getEditorSite().g;
//		EObject targetElement = null;
//		if (selection instanceof IStructuredSelection) {
//			IStructuredSelection ss = (IStructuredSelection) selection;
//			Object eon = ss.getFirstElement();
//			if (eon instanceof EObjectNode) {
//				targetElement = ((EObjectNode)eon).getEObject(resource);
//			}
//		} else {
//			targetElement = eObjectAtOffsetHelper.resolveElementAt(resource,
//					((ITextSelection)selection).getOffset());
//		}
//
//		return  true;
//	}

}
