/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.ui.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.navigator.AadlNavigator;

import com.google.inject.Inject;

public class InstantiateHandler extends AbstractHandler {


	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;


	protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
			.getDefault().getBundle());



	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		final ISelection selection;
		IEditorPart activeEditor = page.getActiveEditor();
		if (part instanceof AadlNavigator){
			selection= page.getSelection();
			if (selection instanceof TreeSelection){
				for (Iterator iterator = ((TreeSelection)selection).iterator(); iterator.hasNext();) {
					final Object f = (Object) iterator.next();
					if (f instanceof IResource){
						IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
						for (int i = 0; i < editorRefs.length; i++) {
							IEditorReference edref = editorRefs[i];
							String pname = edref.getPartName();
							IEditorPart edpart = edref.getEditor(true);
							String fname = ((IResource) f).getName();
							if ( pname.equals(fname)){
								page.closeEditor(edpart, true);
							}
						}

						Resource res = OsateResourceUtil.getResource((IResource)f);

						try {
							InstantiateModel.rebuildInstanceModelFile((IResource)f);//res);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		} else if (activeEditor != null){
			XtextEditor xtextEditor = (activeEditor == null)?null:(XtextEditor) activeEditor.getAdapter(XtextEditor.class);
			if (part instanceof ContentOutline) {
				selection = ((ContentOutline) part).getSelection();
			} else {
				selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
			}
			if (xtextEditor != null) {
				// make sure the model has been saved
				if (xtextEditor.isDirty())
					xtextEditor.doSave(new NullProgressMonitor());

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
									targetElement = eObjectAtOffsetHelper.resolveContainedElementAt(resource,
											((ITextSelection)selection).getOffset());
								}

								if (targetElement != null) {
									if (targetElement instanceof Element){
										ComponentImplementation cc = ((Element) targetElement).getContainingComponentImpl();
										if (cc instanceof SystemImplementation){
											SystemImplementation si = (SystemImplementation)cc;
											System.out.println("instantiate " + si.getName());
											try
											{
												SystemInstance sinst = InstantiateModel.buildInstanceModelFile(si);
												if (sinst == null)
												{
													String message;
													message = "Error when instantiating the model";
													if (InstantiateModel.getErrorMessage() != null)
													{
														message = message + " - reason: " + InstantiateModel.getErrorMessage() + "\nRefer to the help content and FAQ for more information";
													}
													Dialog.showError("Model Instantiate", message);
												}
											}
											catch (UnsupportedOperationException uoe)
											{
												Dialog.showError("Model Instantiate", "Operation is not supported: " + uoe.getMessage());
											}
											catch (Exception other)
											{
												other.printStackTrace();
												Dialog.showError("Model Instantiate", "Error when instantiating the model");
											}

										} 
										else 
										{
											Dialog.showInfo("Model Instantiation","Must select a system implementation. Selected " + targetElement.eClass().getName()+" "+targetElement.toString());
										}
									} else {
										Dialog.showInfo("Model Instantiation","Please select an AADL model element. You selected " + targetElement.eClass().getName()+" "+ targetElement.toString());
									}
									return null;
								}
								return null;
							}
						});
			}
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

	/*
	 * XXX buildInstanceModelFile has moved to InstantiateModel
	 */


}
