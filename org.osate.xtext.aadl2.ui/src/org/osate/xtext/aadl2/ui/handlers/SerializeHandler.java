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

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.Aadl2RuntimeModule;
import org.osate.xtext.aadl2.errormodel.ErrorModelRuntimeModule;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSetElement;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SerializeHandler extends AbstractHandler {


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
		if (xtextEditor != null) {
			if (part instanceof ContentOutline) {
			} else {
			}
//			xtextEditor.getDocument().modify( // use readOnly is no modification to the model
//					new IUnitOfWork<EObject, XtextResource>() {
//						public EObject exec(XtextResource resource)
//								throws Exception {
//							if (resource.getContents().isEmpty()) return null;
//							AadlPackage o = (AadlPackage)resource.getContents().get(0);
//							o.setName("mypack"); 
//							saveBySerialize2(resource);
//							return null;
//						}
//					});
			final ISelection selection;
			if (part instanceof ContentOutline) {
				selection = ((ContentOutline) part).getSelection();
			} else {
				selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
			}
			xtextEditor.getDocument().modify(
					new IUnitOfWork<EObject, XtextResource>() {
						public EObject exec(XtextResource resource)
								throws Exception {
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
//							Injector injector = Guice.createInjector(new  Aadl2RuntimeModule());  
//						    Serializer serializer = injector.getInstance(Serializer.class);  
//							String text = serializer.serialize(targetElement);
//
							URI xtxturi = resource.getURI();
							URI xtxt2uri = xtxturi.trimFileExtension().trimSegments(1).appendSegment("yourpack").appendFileExtension("aadl");
//							URI xtxtaem = xtxturi.trimFileExtension().appendFileExtension("aaem");
							Resource res = OsateResourceUtil.getEmptyAaxl2Resource(xtxt2uri);
//							Resource aemres = OsateResourceUtil.getResource(xtxtaem);
//							EObject eo = aemres.getContents().get(0);
//							EObject neweo = EcoreUtil.copy(eo);
//							res.getContents().add(neweo);
//							String text = serializer.serialize(neweo);
//							SaveOptions.Builder sb = SaveOptions.newBuilder();
//							sb = sb.format().noValidation();
//							sb = sb.format();
//							res.save(sb.getOptions().toOptionsMap());
//							if (resource.getContents().isEmpty()) return null;
//							EObject o = resource.getContents().get(0);
//							((NamedElement)o).setName("mypack"); 
							// sample of creating a fresh model
							AadlPackage pack = Aadl2Factory.eINSTANCE.createAadlPackage();
							pack.setName("mypack");
							PublicPackageSection psec = Aadl2Factory.eINSTANCE.createPublicPackageSection();
							pack.setOwnedPublicSection(psec);
//							DefaultAnnexLibrary dal = Aadl2Factory.eINSTANCE.createDefaultAnnexLibrary();
//							dal.setName("mine");
//							dal.setSourceText("{** hi **}");
//							psec.getOwnedAnnexLibraries().add(dal);
							ErrorModelLibrary eml = ErrorModelFactory.eINSTANCE.createErrorModelLibrary();
							eml.setName("EMV2");
							psec.getOwnedAnnexLibraries().add(eml);
							ErrorTypeLibrary etl = ErrorModelFactory.eINSTANCE.createErrorTypeLibrary();
							eml.setTypeLibrary(etl);
							ErrorType et = ErrorModelFactory.eINSTANCE.createErrorType();
							et.setName("down");
							etl.getTypes().add(et);
							TypeSet ts = ErrorModelFactory.eINSTANCE.createTypeSet();
							TypeSetElement tse = ErrorModelFactory.eINSTANCE.createTypeSetElement();
							ts.getElementType().add(tse);
							tse.setType(et);
							etl.getTypes().add(ts);
							SaveOptions.Builder sb = SaveOptions.newBuilder();
							sb = sb.format().noValidation();
							sb = sb.format();
							res.getContents().add(pack);
							res.save(sb.getOptions().toOptionsMap());
//							res.save(null);
//							saveBySerialize2(res);
//							resource.getContents().add(res.getContents().get(0));
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
