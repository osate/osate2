package org.osate.ui.utils;

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

public class SelectionHelper
{
	private static EObjectAtOffsetHelper eObjectAtOffsetHelper = new EObjectAtOffsetHelper();

	public static XtextEditor getXtextEditor() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null) {
			throw new RuntimeException("Unexpected case. Unable to get active editor");
		}

		XtextEditor xtextEditor = (XtextEditor) activeEditor
				.getAdapter(XtextEditor.class);
		if (xtextEditor == null) {
			throw new RuntimeException("Unexpected case. Unable to get Xtext editor");
		}

		return xtextEditor;
	}
	
	
	public static EObject getEObjectFromSelection(final ISelection selection) {
		return getXtextEditor().getDocument().readOnly(
				new IUnitOfWork<EObject, XtextResource>() {
					public EObject exec(XtextResource resource)
							throws Exception {
						EObject targetElement = null;
						if (selection instanceof IStructuredSelection) {
							IStructuredSelection ss = (IStructuredSelection) selection;
							Object eon = ss.getFirstElement();
							if (eon instanceof EObjectNode) {
								targetElement = ((EObjectNode) eon)
										.getEObject(resource);
							}
						} else {
							targetElement = eObjectAtOffsetHelper
									.resolveElementAt(resource,
											((ITextSelection) selection)
													.getOffset());
						}

						return targetElement;
					}
				});
	}	
	
	public static EObject getSelectedObjectinOutline ()
	{
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		final IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		final IEditorPart activeEditor = workbenchPage.getActiveEditor();
		EObject res;
		
		res = null;
		
		if (activeEditor == null) {
			return null;
		}

		IWorkbenchPart workbenchPart = workbenchPage.getActivePart();

		if (workbenchPart instanceof ContentOutline) {
			ISelection selection = ((ContentOutline) workbenchPart).getSelection();
			res = getEObjectFromSelection(selection);
		}

		return res;
	}
}