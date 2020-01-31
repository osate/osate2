/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
				e.printStackTrace(System.err);

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