package org.osate.xtext.aadl2.ui.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.presentation.Aadl2ModelEditor;
import org.osate.aadl2.properties.InstanceUtil;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.core.AadlNature;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.navigator.AadlNavigator;
import org.osate.workspace.WorkspacePlugin;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;
import org.osate.xtext.aadl2.util.AadlUnparser;

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
//						IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
//						for (int i = 0; i < editorRefs.length; i++) {
//							IEditorReference edref = editorRefs[i];
//							String pname = edref.getPartName();
//							IEditorPart edpart = edref.getEditor(true);
//							String fname = ((IResource) f).getName();
//							if (edpart instanceof Aadl2ModelEditor && pname.equals(fname)){
//								page.closeEditor(edpart, true);
//							}
//						}
					    
										Resource res = OsateResourceUtil.getResource((IResource)f);
										SystemInstance target = (SystemInstance)res.getContents().get(0);
										SystemImplementation si = target.getSystemImplementation();
										SystemInstance sinst = InstantiateModel.buildInstanceModelFile(si);
//										InstantiateModel.rebuildInstanceModelFile(res);
//										// unloading causes other entities (e.g., instance editor) to have to load the instance again
//										// which they can do when notified
//										res.unload();

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
									targetElement = eObjectAtOffsetHelper.resolveElementAt(resource,
											((ITextSelection)selection).getOffset());
								}
								
								if (targetElement != null) {
									if (targetElement instanceof NamedElement){
										System.out.println("instantiate " + ((NamedElement)targetElement).getName());
										ComponentImplementation cc = ((NamedElement) targetElement).getContainingComponentImpl();
										if (cc instanceof SystemImplementation){
											SystemImplementation si = (SystemImplementation)cc;

											SystemInstance sinst = InstantiateModel.buildInstanceModelFile(si);

										} else {
											System.out.println("Must select a system implementation. Selected " + targetElement.eClass().getName()+" "+targetElement.toString());
										}
									} else {
										System.out.println("Please select a model element. You selected " + targetElement.eClass().getName()+" "+ targetElement.toString());
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
