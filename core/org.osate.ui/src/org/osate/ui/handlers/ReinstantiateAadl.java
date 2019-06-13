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
package org.osate.ui.handlers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.core.AadlNature;
import org.osate.workspace.WorkspacePlugin;

/**
 * Scans the workspace for AADL system instances and rebuilds them, or
 * removes them if the instantiated system component no longer exists.
 */
public class ReinstantiateAadl extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Job job = new ReinstantiateJob(getCurrentSelection(event));
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true); // important!
		job.schedule();
		return null;
	}

	private final class ReinstantiateJob extends WorkspaceJob {
		private final Set<IResource> selection;

		public ReinstantiateJob(final Set<IResource> selection) {
			super("Reinstantiate models");
			this.selection = selection;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) {
			monitor.beginTask("Reinstantiate all instance models", IProgressMonitor.UNKNOWN);
			try {
				if (!selection.isEmpty()) {
					for (Iterator<IResource> iterator = selection.iterator(); iterator.hasNext();) {
						IResource obj = iterator.next();
						InstantiateModel.rebuildInstanceModelFile(obj);
					}
				} else {
					InstantiateModel.rebuildAllInstanceModelFiles(monitor);
				}
			} catch (Exception e) {
				System.err.println("Model Instantiate: Error while re-instantiating the model: " + e.getMessage());

			}
			monitor.done();
			return Status.OK_STATUS;
		}
	}

	/** Set of currently selected instance models as IResources.
	 *   If the set is empty then the action will run on
	 * all instance models in open AADL projects in the workspace.
	 */
	private Set<IResource> getCurrentSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		Set<IResource> currentSelection = new HashSet<>();
		if (selection instanceof IStructuredSelection) {
			for (final Iterator<?> elts = ((IStructuredSelection) selection).iterator(); elts.hasNext();) {
				final Object object = elts.next();
				if (object != null) {
					IResource p = null;
					if (object instanceof IResource) {
						p = (IResource) object;
					} else if (object instanceof IAdaptable) {
						p = ((IAdaptable) object).getAdapter(IResource.class);
					}
					if (p != null && isInstanceFile(p) && AadlNature.hasNature(p.getProject())) {
						currentSelection.add(p);
					}
				}
			}
		}
		return currentSelection;
	}

	// This was originally in org.osate.workspace.IResourceUtility, but that class is being removed soon.
	private static final QualifiedName IsInstanceModel = new QualifiedName("org.osate.IsInstanceModel",
			"IsInstanceModel");

	// This was originally in org.osate.workspace.IResourceUtility, but that class is being removed soon.
	/**
	 * is file an AADL instance model
	 */
	private static boolean isInstanceFile(IResource file) {
		if (file instanceof IFile) {
			return (file.getName()
					.endsWith(WorkspacePlugin.INSTANCE_MODEL_POSTFIX + "." + WorkspacePlugin.MODEL_FILE_EXT)
					|| file.getName().endsWith(WorkspacePlugin.INSTANCE_FILE_EXT));
		}
		if (file != null && file.exists()) {
			try {
				return file.getPersistentProperty(IsInstanceModel) != null;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
		return false;
	}
}