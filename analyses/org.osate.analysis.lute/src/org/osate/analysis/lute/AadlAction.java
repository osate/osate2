/**
 * <copyright>
 * Copyright  2013 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * </copyright>
 * 
 */
package org.osate.analysis.lute;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.lute.utils.LuteLogger;

abstract public class AadlAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	private Object currentSelection;

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) selection;
			if (iss.size() == 1) {
				currentSelection = iss.getFirstElement();
			}
		}
	}
	
	abstract protected IStatus runJob(Element sel, IProgressMonitor monitor, LuteLogger log);
	
	public void run(IAction action) {
		final LuteLogger log = new LuteLogger(LuteLogger.INFO, "AADL Validation", getWindow());

		WorkspaceJob job = new WorkspaceJob("AADL Job") {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException 
			{
				IEditorPart activeEditor;
				EObjectNode node;
				XtextEditor xtextEditor;
				
				
				activeEditor = window.getActivePage().getActiveEditor();
				
				if (activeEditor == null)
				{
					return Status.CANCEL_STATUS;
				}
				
				if ((!(currentSelection instanceof EObjectNode)) &&
					(!(currentSelection instanceof SystemInstance)))
				{
					return Status.CANCEL_STATUS;
				}
				
				xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);

				if (xtextEditor != null)
				{
					node = (EObjectNode) currentSelection;
					
					final URI uri = node.getEObjectURI();
					
					xtextEditor.getDocument().readOnly(
						new IUnitOfWork<IStatus, XtextResource>() {
							public IStatus exec(XtextResource resource) throws Exception {
								EObject eobj = resource.getResourceSet().getEObject(uri, true);
								if (eobj instanceof Element) {
									return runJob((Element) eobj, monitor, log);
								}
									
								return Status.CANCEL_STATUS;
							}
						});
				}
				else
				{
					return runJob((Element) currentSelection, monitor, log);
				}
				
				return Status.OK_STATUS;
			}
		};
		
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true);
		job.schedule();
	}
	
	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
	
	protected IWorkbenchWindow getWindow() {
		return window;
	}

	protected Shell getShell() {
		return window.getShell();
	}

	protected AnalysisErrorReporterManager getErrorManager() {
		return AnalysisErrorReporterManager.NULL_ERROR_MANANGER;
	}
}
