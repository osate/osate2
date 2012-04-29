package org.osate.xtext.aadl2.ui.handlers;

import java.util.Iterator;

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
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Comment;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.workspace.WorkspacePlugin;
import org.osate.xtext.aadl2.util.AadlUnparser;

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
						public EObject exec(XtextResource resource)
								throws Exception {
							// Resolve references such that HREFs use symbolic
							// XMI links rather than XText links
							EcoreUtil.resolveAll(resource);
							EList<EObject> content = resource.getContents();
							if (!content.isEmpty()) {
								// add comments into the model
							    for (EObject eObject : content)
							    {
							    	if (eObject instanceof Element)
							    			processComment((Element)eObject);
							        for (Iterator<EObject> i = eObject.eAllContents(); i.hasNext(); ){
							        	Object o = i.next();
								    	if (o instanceof Element)
							    			processComment((Element)o);
							        }
							    }
								
								ResourceSet rss = resource.getResourceSet();
								EObject eobject = content.get(0);
								// save XMI
								URI xtxturi = resource.getURI();

								URI xmiuri = xtxturi.trimFileExtension()
										.appendFileExtension(
												WorkspacePlugin.MODEL_FILE_EXT);
//								Aadl2ResourceFactoryImpl resFactory = new Aadl2ResourceFactoryImpl();
//								Aadl2ResourceImpl aaxlresource = (Aadl2ResourceImpl) resFactory
//										.createResource(xmiuri);
								Resource aaxlresource = OsateResourceUtil.getEmptyAadl2Resource(xmiuri, (Element)eobject);
								aaxlresource.getContents().add(eobject);
								rss.getResources().add(aaxlresource);
								aaxlresource.save(null);
								// put the root object back into the original resource
								resource.getContents().add(eobject);
								rss.getResources().remove(aaxlresource);
							}
							return null;
							// }
							// return null;
						}
					});
		}
		return null;
	}
	
	public void processComment(Element o){
		if (o instanceof Comment) return;
		INode node = NodeModelUtils.findActualNodeFor(o);
		if (node == null) 
			return;
		BidiTreeIterator<INode> ti = node.getAsTreeIterable().iterator();
		while (ti.hasNext()) {
			INode next = ti.next();
			if (isCommentNode(next)){
				EObject eo = NodeModelUtils.findActualSemanticObjectFor(next);
				if (eo==o){
				Comment com = Aadl2Factory.eINSTANCE.createComment();
				com.setBody(next.getText().replaceAll("\r\n", ""));
				o.getOwnedComments().add(com);
				}
			}
		}
	}
	
	public boolean isCommentNode(INode node) {
		if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()
				&& node.getGrammarElement() instanceof AbstractRule)
			return isComment((AbstractRule) node.getGrammarElement());
		return false;
	}

	public boolean isComment(AbstractRule rule) {
		return rule != null && ( "SL_COMMENT".equals(rule.getName()));
	}

}
