// Based on SelectionHelper form the OSATE2-Ocarina plugin
/*
* Use of the OSATE2-Ocarina plugin is subject to the terms of the license set forth
* at http://www.eclipse.org/legal/cpl-v10.html.
*
* Note: Contributions by user philip.alldredge@uah.edu were performed under contract W31P4Q-05-A-031 for the US Army. 
* These contributions are covered by US Government Unlimited Rights per DFARS 252.227-7014. You are entitled to use this software under the conditions of the Common Public License.
*/
package edu.uah.rsesc.aadl.age.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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
public class SelectionHelper {
	private static EObjectAtOffsetHelper eObjectAtOffsetHelper = new EObjectAtOffsetHelper();

	public static ISelection getSelection() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null) {
			throw new RuntimeException("Unexpected case. Unable to get active editor");
		}

		final ISelection selection;
		if (part instanceof ContentOutline) {
			selection = ((ContentOutline) part).getSelection();
		} else {
			selection = getXtextEditor().getSelectionProvider().getSelection();
		}

		return selection;
	}

	// Based on code in: org.osate.xtext.aadl2.ui.handlers.InstantiateHandler
	// Gets the selected model object
	public static EObject getSelectedObject() {
		return getEObjectFromSelection(getSelection());
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

	public static XtextEditor getXtextEditor() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null) {
			throw new RuntimeException("Unexpected case. Unable to get active editor");
		}

		XtextEditor xtextEditor = (XtextEditor)activeEditor.getAdapter(XtextEditor.class);
		if (xtextEditor == null) {
			throw new RuntimeException("Unexpected case. Unable to get Xtext editor");
		}

		return xtextEditor;
	}
	
	/**
	 * Returns the current project
	 * @return the project that contains the current selection.
	 */
	public static IProject getProject() {
		EObject selectedObject = SelectionHelper.getSelectedObject();
		if(selectedObject == null) {
			throw new RuntimeException("Unable to retrieve project. Selection is null.");
		}
		
		final IPath projectPath = new Path(selectedObject.eResource().getURI().toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if(projectResource instanceof IProject) {
			return (IProject)projectResource;
		}

		throw new RuntimeException("Unable to receive project. Resource is of type " + projectResource.getClass().getName());
	}
}