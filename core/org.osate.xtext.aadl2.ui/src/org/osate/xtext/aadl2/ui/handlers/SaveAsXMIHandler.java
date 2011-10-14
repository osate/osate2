package org.osate.xtext.aadl2.ui.handlers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
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
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.core.OsateCorePlugin;
import org.osate.workspace.WorkspacePlugin;

import com.google.inject.Inject;
import com.google.inject.Injector;

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
						public EObject exec(XtextResource resource)
								throws Exception {
							// Resolve references such that HREFs use symbolix
							// XMI links rather than XText links
							EcoreUtil.resolveAll(resource);
							EList<EObject> content = resource.getContents();
							if (!content.isEmpty()) {
								ResourceSet rss = resource.getResourceSet();
								EObject eobject = content.get(0);
								

								// save XMI
								URI xtxturi = resource.getURI();
								URI xmiuri = xtxturi.trimFileExtension()
										.appendFileExtension(
												WorkspacePlugin.MODEL_FILE_EXT);
								Aadl2ResourceFactoryImpl resFactory = new Aadl2ResourceFactoryImpl();
								Aadl2ResourceImpl aaxlresource = (Aadl2ResourceImpl) resFactory
										.createResource(xmiuri);
								aaxlresource.getContents().add(eobject);
								rss.getResources().add(aaxlresource);
								aaxlresource.save();
								// put the root object back into the original resource
								resource.getContents().add(eobject);
								rss.getResources().remove(aaxlresource);

// code to experiment with serialization								
//								Resource lres = rss.getResource(xmiuri, true);
//								EList<EObject> ccontent = lres.getContents();
//								if (!ccontent.isEmpty()) {
//									EObject eeobject = ccontent.get(0);
//
//								SaveOptions.Builder sb = SaveOptions.newBuilder();
////								sb = sb.noValidation();
//								ISerializer serializer = resource.getSerializer();
//								String textualRepresentation = serializer.serialize(eeobject,sb.getOptions());
//
//								
//								
//								// persist xmi resource
//								xmiuri = xtxturi.trimSegments(1).appendSegment("mine").appendFileExtension("aadl");
//								XtextResource aadlresource = (XtextResource) rss.createResource(xmiuri);
//								aadlresource.getContents().add(eeobject);
//								rss.getResources().add(aadlresource);
//
//								Map<Object,Object> options = new HashMap();
//								sb.getOptions().addTo(options);
// 								aadlresource.save(options);
//								// put the root object back into the original resource
//								resource.getContents().add(eobject);
//								rss.getResources().remove(aadlresource);
//								}

							}

							return null;
							// }
							// return null;
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
