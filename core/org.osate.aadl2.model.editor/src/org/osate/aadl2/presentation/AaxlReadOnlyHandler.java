/*
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * %W%
 * @version %I% %H%
 */
package org.osate.aadl2.presentation;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.navigator.AadlNavigator;
import org.osate.workspace.WorkspacePlugin;

/**
 * Handler running as transaction
 */
public abstract class AaxlReadOnlyHandler extends AbstractHandler {
	private static final String DEFAULT_NAME = "Analysis";

	protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(
			OsateCorePlugin.getDefault().getBundle());

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		final ISelection selection;
		IEditorPart activeEditor = page.getActiveEditor();
		if (part instanceof AadlNavigator) {
			selection = page.getSelection();
			if (selection instanceof TreeSelection) {
				for (Iterator iterator = ((TreeSelection) selection).iterator(); iterator.hasNext();) {
					final Object f = iterator.next();
					if (f instanceof IResource) {
						if (WorkspacePlugin.INSTANCE_FILE_EXT.equalsIgnoreCase(((IResource) f).getFileExtension())) {
							try {
								final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
										.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
								// We execute this command on the command stack because otherwise, we will not
								// have write permissions on the editing domain.
								Command cmd = new RecordingCommand(domain) {

									@Override
									protected void doExecute() {
										Resource res = OsateResourceUtil.getResource((IResource) f);
										EObject target = res.getContents().get(0);
										doProcess(target);
										if (res.isModified()) {
										}
									}

								};

								try {
									((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (RollbackException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}
			}
		} else if (activeEditor != null) {
			Aadl2ModelEditor aadl2Editor = (activeEditor == null) ? null
					: (Aadl2ModelEditor) activeEditor.getAdapter(Aadl2ModelEditor.class);
			if (part instanceof ContentOutline) {
				selection = ((ContentOutline) part).getSelection();
			} else {
				selection = aadl2Editor.getSelection();
			}
			if (aadl2Editor != null) {
				// make sure the model has been saved
				if (aadl2Editor.isDirty()) {
					aadl2Editor.doSave(new NullProgressMonitor());
				}
				if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
					Object object = ((IStructuredSelection) selection).getFirstElement();
					if (object instanceof EObject) {
						final EObject target = (EObject) object;
						final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
								.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
						// We execute this command on the command stack because otherwise, we will not
						// have write permissions on the editing domain.
						Command cmd = new RecordingCommand(domain) {

							@Override
							protected void doExecute() {
								doProcess(target);
							}

						};

						try {
							((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (RollbackException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}
		return null;
	}

	protected abstract void doProcess(EObject target);

}
