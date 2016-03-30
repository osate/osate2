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
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.osate.aadl2.Comment;
import org.osate.aadl2.Element;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.workspace.WorkspacePlugin;

import com.google.inject.Inject;

public class SaveAsXMIHandler extends AbstractHandler {

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
		final ISelection selection;
		if (xtextEditor != null) {
			if (part instanceof ContentOutline) {
				selection = ((ContentOutline) part).getSelection();
			} else {
				selection = xtextEditor.getSelectionProvider().getSelection();
			}

			final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.osate.aadl2.ModelEditingDomain");

			xtextEditor.getDocument().readOnly(new IUnitOfWork<EObject, XtextResource>() {
				@Override
				public EObject exec(final XtextResource resource) throws Exception {
					// Resolve references such that HREFs use symbolic
					// XMI links rather than XText links
					EcoreUtil.resolveAll(resource);
					EList<EObject> content = resource.getContents();
					if (!content.isEmpty()) {
						// add comments into the model
						for (EObject eObject : content) {
							if (eObject instanceof Element) {
								processComment((Element) eObject);
							}
							for (Iterator<EObject> i = eObject.eAllContents(); i.hasNext();) {
								Object o = i.next();
								if (o instanceof Element) {
									processComment((Element) o);
								}
							}
						}

						final ResourceSet rss = resource.getResourceSet();
						final EObject eobject = content.get(0);
						// save XMI
						final URI xtxturi = resource.getURI();
						// We execute this command on the command stack because otherwise, we will not
						// have write permissions on the editing domain.
						domain.getCommandStack().execute(new RecordingCommand(domain) {
							@Override
							protected void doExecute() {

								URI xmiuri = xtxturi.trimFileExtension()
										.appendFileExtension(WorkspacePlugin.MODEL_FILE_EXT);
								Aadl2ResourceFactoryImpl resFactory = new Aadl2ResourceFactoryImpl();
								Aadl2ResourceImpl aaxlresource = (Aadl2ResourceImpl) resFactory.createResource(xmiuri);
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
//											aaxlresource.save(null);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								// put the root object back into the original resource
								resource.getContents().add(eobject);
								rss.getResources().remove(aaxlresource);
							}
						});
					}
					return null;
					// }
					// return null;
				}
			});
		}
		return null;
	}

	public void processComment(Element o) {
		if (o instanceof Comment) {
			return;
		}
		INode node = NodeModelUtils.findActualNodeFor(o);
		if (node == null) {
			return;
		}
		BidiTreeIterator<INode> ti = node.getAsTreeIterable().iterator();
		while (ti.hasNext()) {
			INode next = ti.next();
			if (isCommentNode(next)) {
				EObject eo = NodeModelUtils.findActualSemanticObjectFor(next);
				if (eo == o) {
					Comment com = Aadl2Factory.eINSTANCE.createComment();
					com.setBody(next.getText().replaceAll("\r\n", ""));
					o.getOwnedComments().add(com);
				}
			}
		}
	}

	public boolean isCommentNode(INode node) {
		if (node instanceof ILeafNode && ((ILeafNode) node).isHidden()
				&& node.getGrammarElement() instanceof AbstractRule) {
			return isComment((AbstractRule) node.getGrammarElement());
		}
		return false;
	}

	public boolean isComment(AbstractRule rule) {
		return rule != null && ("SL_COMMENT".equals(rule.getName()));
	}

}
