package org.osate.xtext.aadl2.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.core.OsateCorePlugin;

import com.google.inject.Inject;

public class InstantiateHandler extends AbstractHandler {


	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;


	protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
			.getDefault().getBundle());
//	protected static final InstantiateModel instantiateModel =
//			new InstantiateModel(new NullProgressMonitor(),
//					new AnalysisErrorReporterManager(
//							internalErrorLogger,
//							new MarkerAnalysisErrorReporter.Factory(
//									AadlConstants.INSTANTIATION_OBJECT_MARKER)));


	
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
								if (targetElement instanceof NamedElement){
									System.out.println("instantiate " + ((NamedElement)targetElement).getName());
									ComponentImplementation cc = ((NamedElement) targetElement).getContainingComponentImpl();
									if (cc instanceof SystemImplementation){
										SystemImplementation si = (SystemImplementation)cc;
//										URI instanceURI = InstantiateModel.getInstanceModelURI(si);
//										Aadl2ResourceFactoryImpl resFactory = new Aadl2ResourceFactoryImpl();
//										Aadl2ResourceImpl aadlResource =  (Aadl2ResourceImpl) resFactory.createResource(instanceURI);
//
//										// now instantiate the rest of the model
//										SystemInstance root = instantiateModel.createSystemInstanceInt(si,aadlResource);
										buildInstanceModelFile(si);
									} else {
										System.out.println("Must select a system implementation. Selected " + targetElement.eClass().getName()+" "+targetElement.toString());
									}
									if (targetElement instanceof SystemInstance){
										final InstantiateModel instantiateModel =
												new InstantiateModel(new NullProgressMonitor(),
														new AnalysisErrorReporterManager(
																internalErrorLogger,
																new MarkerAnalysisErrorReporter.Factory(
																		AadlConstants.INSTANTIATION_OBJECT_MARKER)));
										instantiateModel.createXSystemInstance((SystemInstance)targetElement);
										
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
	 * This method will construct an instance model, save it on disk and return
	 * its root object This method has the knowledge of how the instance model
	 * file name is constructed
	 * 
	 * @param si system implementation
	 * 
	 * @return SystemInstance or <code>null</code> if cancelled.
	 */
	public SystemInstance buildInstanceModelFile(final SystemImplementation si) {
		// add it to a resource; otherwise we cannot attach error messages to
		// the instance file
		URI instanceURI = OsateResourceUtil.getInstanceModelURI(si);
		Resource aadlResource = OsateResourceUtil.getEmptyAaxl2Resource(instanceURI,si);

		// now instantiate the rest of the model
		final InstantiateModel instantiateModel =
				new InstantiateModel(new NullProgressMonitor(),
						new AnalysisErrorReporterManager(
								internalErrorLogger,
								new MarkerAnalysisErrorReporter.Factory(
										AadlConstants.INSTANTIATION_OBJECT_MARKER)));
		SystemInstance root = instantiateModel.createSystemInstance(si, aadlResource);
		return root;
	}

	/*
	 * This method returns a system instance for the given system
	 * implementation. If the instance model already exists it will be returned.
	 * If it does not exist one will be constructed.
	 * 
	 * @param si system implementation
	 * 
	 * @return SystemInstance
	 */
	public SystemInstance getSystemInstance(final SystemImplementation si) {
		SystemInstance systemInstance = findSystemInstance(si);
		if (systemInstance == null) {
			systemInstance = buildInstanceModelFile(si);
		}
		return systemInstance;
	}

	/*
	 * This method returns a system instance for the given system
	 * implementation. If the instance model already exists it will be returned.
	 * If it does not exist null is returned
	 * 
	 * @param si system implementation
	 * 
	 * @return SystemInstance or null if it does not exist
	 */
	public SystemInstance findSystemInstance(final SystemImplementation si) {
		URI instanceURI = OsateResourceUtil.getInstanceModelURI(si);
		Resource instanceRes = OsateResourceUtil.findResource(instanceURI);
		if (instanceRes == null || instanceRes.getContents().isEmpty()) {
			return null;
		} else {
			SystemInstance systemInstance = (SystemInstance) instanceRes.getContents().get(0);
			return systemInstance;
		}
	}

}
