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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.workspace.WorkspacePlugin;

import com.google.inject.Inject;

public class SerializeHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null) {
			return null;
		}
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
				selection = xtextEditor.getSelectionProvider().getSelection();
			}
			xtextEditor.getDocument().readOnly(new IUnitOfWork<EObject, XtextResource>() {
				@Override
				public EObject exec(final XtextResource resource) throws Exception {
					EObject targetElement = null;
					if (selection instanceof IStructuredSelection) {
						IStructuredSelection ss = (IStructuredSelection) selection;
						Object eon = ss.getFirstElement();
						if (eon instanceof EObjectNode) {
							targetElement = ((EObjectNode) eon).getEObject(resource);
						}
					} else {
						targetElement = eObjectAtOffsetHelper.resolveElementAt(resource,
								((ITextSelection) selection).getOffset());
					}
					final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
							.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
					domain.getCommandStack().execute(new RecordingCommand(domain) {
						@Override
						protected void doExecute() {

							URI xtxturi = resource.getURI();
							URI xtxt2uri = xtxturi.trimFileExtension().appendFileExtension("aaxl2");
							Resource res = OsateResourceUtil.getEmptyAaxl2Resource(xtxt2uri);
							Aadl2ResourceFactoryImpl resFactory = new Aadl2ResourceFactoryImpl();
							Aadl2ResourceImpl aaxlresource = (Aadl2ResourceImpl) resFactory.createResource(xtxt2uri);
							ResourceSet rss = resource.getResourceSet();
							EcoreUtil.resolveAll(resource);
							EList<EObject> content = resource.getContents();
							EObject eobject = content.get(0);
							aaxlresource.getContents().add(eobject);
							rss.getResources().add(aaxlresource);
							try {
								Preferences prefs = WorkspacePlugin.getDefault().getPluginPreferences();
								Boolean expandFlag = prefs.getBoolean(WorkspacePlugin.EXPAND_DEFAULT_FLAG);
								Map options = new HashMap();
								options.put(XMLResource.OPTION_ENCODING, "UTF-8");
								options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
								if (expandFlag) {
									options.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
								}

								aaxlresource.save(options);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// put the root object back into the original resource
							resource.getContents().add(eobject);
							rss.getResources().remove(aaxlresource);
							// now load and unparse
							Resource ress = OsateResourceUtil.getResource(xtxt2uri);
							AadlPackage target = (AadlPackage) ress.getContents().get(0);
							target.setName(target.getName() + "1");
							URI xtxtnewuri = xtxt2uri.trimFileExtension().trimSegments(1)
									.appendSegment(target.getName()).appendFileExtension("aadl");
							Resource xtxtres = rss.createResource(xtxtnewuri);
							xtxtres.getContents().add(target);
							OsateResourceUtil.save(xtxtres);
							res.getContents().add(target);
							rss.getResources().remove(xtxtres);
						}
					});

//							// sample of creating a fresh model
//							AadlPackage pack = Aadl2Factory.eINSTANCE.createAadlPackage();
//							pack.setName("mypack");
//							PublicPackageSection psec = Aadl2Factory.eINSTANCE.createPublicPackageSection();
//							pack.setOwnedPublicSection(psec);
////							DefaultAnnexLibrary dal = Aadl2Factory.eINSTANCE.createDefaultAnnexLibrary();
////							dal.setName("mine");
////							dal.setSourceText("{** hi **}");
////							psec.getOwnedAnnexLibraries().add(dal);
//							ErrorModelLibrary eml = ErrorModelFactory.eINSTANCE.createErrorModelLibrary();
//							eml.setName("EMV2");
//							psec.getOwnedAnnexLibraries().add(eml);
//							ErrorTypeLibrary etl = ErrorModelFactory.eINSTANCE.createErrorTypeLibrary();
//							eml.setTypeLibrary(etl);
//							ErrorType et = ErrorModelFactory.eINSTANCE.createErrorType();
//							et.setName("down");
//							etl.getTypes().add(et);
//							TypeSet ts = ErrorModelFactory.eINSTANCE.createTypeSet();
//							TypeSetElement tse = ErrorModelFactory.eINSTANCE.createTypeSetElement();
//							ts.getElementType().add(tse);
//							tse.setType(et);
//							etl.getTypes().add(ts);
//							SaveOptions.Builder sb = SaveOptions.newBuilder();
//							sb = sb.format().noValidation();
//							sb = sb.format();
//							res.getContents().add(pack);
//							res.save(sb.getOptions().toOptionsMap());
////							res.save(null);
////							saveBySerialize2(res);
////							resource.getContents().add(res.getContents().get(0));
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
	private void saveBySerialize2(Resource res) {
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
