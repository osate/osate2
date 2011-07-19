/*
 * Created on Jan 30, 2004
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
 * @version $Id$
 */
package org.osate.ui.actions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.core.AadlNature;
import org.osate.core.builder.AadlBuilder;
import org.osate.internal.workspace.AadlWorkspace;
import org.osate.ui.OsateUiPlugin;
import org.osate.workspace.IAadlProject;
import org.osate.workspace.IAadlWorkspace;
import org.osate.workspace.IResourceUtility;



/**
 * Scans the workspace for AADL system instances and rebuilds them, or 
 * removes them if the instantiated system component no longer exists.
 */
public class ReinstantiateAadl implements IWorkbenchWindowActionDelegate, IObjectActionDelegate {
	private static final IAadlWorkspace workspace = AadlWorkspace.getAadlWorkspace();
	private static final InternalErrorReporter internalErrorLogger =
		new LogInternalErrorReporter(OsateUiPlugin.getDefault().getBundle());
	
	/** Set of currently selected instance models as IResources.  
	 *   If the set is empty then the action will run on 
	 * all instance models in open AADL projects in the workspace.
	 */
	private Set currentSelection = Collections.EMPTY_SET;


	
	/**
	 * The constructor.
	 */
	public ReinstantiateAadl() {
	}

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
    }

	public void run(final IAction action) {
		
		final Job job = new ReinstantiateJob(currentSelection);
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true); // important!
		job.schedule();
	}

	private final class ReinstantiateJob extends WorkspaceJob {
		private final Set selection;
		
		public ReinstantiateJob(final Set selection) {
			super("Reinstantiate models");
			this.selection = selection;
		}
		
		public IStatus runInWorkspace(final IProgressMonitor monitor) {
			monitor.beginTask("Reinstantiate all instance models",
					IProgressMonitor.UNKNOWN);
			AadlBuilder build = new AadlBuilder();
			IAadlProject[] projs = null;
			if (currentSelection.isEmpty()) {
				projs = workspace.getOpenAadlProjects();
				for (int i = 0; i < projs.length; i++){
					final IAadlProject project = projs[i];
					EList<IFile> files = project.getAllInstanceModelFiles(null);
					for (final IFile ires : files) {
						boolean cancelled = build.doReinstantiate(ires, monitor);
						
						if (cancelled) {
							throw new OperationCanceledException();
						}
					}
				}
			} else {
				for (Iterator it = selection.iterator(); it.hasNext();) {
					final IResource ires = (IResource) it.next();
					boolean cancelled = build.doReinstantiate(ires, monitor);
					
					if (cancelled) {
						throw new OperationCanceledException();
					}
				}
			}
			monitor.done();
			return Status.OK_STATUS;
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			currentSelection = new HashSet();
			for (final Iterator elts = ((IStructuredSelection) selection).iterator(); elts.hasNext();) {
				final Object object = elts.next();
				if (object != null) {
					IResource p = null;
					if (object instanceof IResource) {
						p = (IResource) object;
					} else if (object instanceof IAdaptable) {
						p = (IResource) ((IAdaptable) object).getAdapter(IResource.class);
					}
					if (p != null && IResourceUtility.isInstanceFile(p) 
							&& AadlNature.hasNature(p.getProject()) ) {
						currentSelection.add(p);
					}
				}
			}
		}
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
	}
}