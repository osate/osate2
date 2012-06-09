package org.osate.xtext.aadl2.ui.handlers;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.properties.InstanceUtil;

import com.google.inject.Inject;

public class SerializeHandler extends AbstractHandler {


//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		IWorkbench wb = PlatformUI.getWorkbench();
//		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
//		IWorkbenchPage page = win.getActivePage();
//		IWorkbenchPart part = page.getActivePart();
//		IEditorPart activeEditor = page.getActiveEditor();
//		if (activeEditor == null)
//			return null;
//		XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
//		if (xtextEditor != null) {
//			if (part instanceof ContentOutline) {
//			} else {
//			}
////			xtextEditor.getDocument().modify( // use readOnly is no modification to the model
////					new IUnitOfWork<EObject, XtextResource>() {
////						public EObject exec(XtextResource resource)
////								throws Exception {
////							if (resource.getContents().isEmpty()) return null;
////							AadlPackage o = (AadlPackage)resource.getContents().get(0);
////							o.setName("mypack"); 
////							saveBySerialize2(resource);
////							return null;
////						}
////					});
//			xtextEditor.getDocument().modify(
//					new IUnitOfWork<EObject, XtextResource>() {
//						public EObject exec(XtextResource resource)
//								throws Exception {
//							URI xtxturi = resource.getURI();
//							URI xtxt2uri = xtxturi.trimFileExtension().trimSegments(1).appendSegment("mypack").appendFileExtension("aadl");
//							Resource res = OsateResourceUtil.getEmptyAadl2Resource(xtxt2uri);
////							if (resource.getContents().isEmpty()) return null;
////							EObject o = resource.getContents().get(0);
////							EObject on = EcoreUtil.copy(o);
////							res.getContents().add(o);
////							((NamedElement)on).setName("mypack"); 
//							// sample of creating a fresh model
//							AadlPackage pack = Aadl2Factory.eINSTANCE.createAadlPackage();
//							pack.setName("mypack");
//							pack.setOwnedPublicSection(Aadl2Factory.eINSTANCE.createPublicPackageSection());
//							res.getContents().add(pack);
//							res.save(null);
////							saveBySerialize2(res);
////							resource.getContents().add(res.getContents().get(0));
//							return null;
//						}
//					});
//		}
//		return null;
//	}
	

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
								if (targetElement instanceof NamedElement){
										System.out.println("Inst: Resoruce set simpl: " + targetElement.eResource().getResourceSet());
										if (targetElement instanceof Subcomponent){
											Classifier cl = ((Subcomponent)targetElement).getAllClassifier();
											if (cl instanceof ComponentImplementation){
												System.out.println("Inst: Subcomponents " + ((ComponentImplementation)cl).getAllSubcomponents());
											}
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
	
	/**
	 * method uses XText Serializer
	 * Have had problems with it
	 * @param res
	 */
	private void saveBySerialize2(Resource res){
		SaveOptions.Builder sb = SaveOptions.newBuilder();
//		sb = sb.format().noValidation();
//		sb = sb.format();
		try {
			res.save(sb.getOptions().toOptionsMap());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
