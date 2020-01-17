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
package org.osate.internal.ui.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;

//import org.eclipse.jdt.core.JavaCore;

//import org.eclipse.jdt.internal.ui.JavaUIStatus;

/**
 * An <code>IRunnableWithProgress</code> that adapts and  <code>IWorkspaceRunnable</code>
 * so that is can be executed inside <code>IRunnableContext</code>. <code>OperationCanceledException</code>
 * thrown by the adapted runnable are caught and re-thrown as a <code>InterruptedException</code>.
 */
public class WorkbenchRunnableAdapter implements IRunnableWithProgress {

	private IWorkspaceRunnable fWorkspaceRunnable;
	private ISchedulingRule fRule;

	/**
	 * Runs a workspace runnable with the workspace lock.
	 */
	public WorkbenchRunnableAdapter(IWorkspaceRunnable runnable) {
		this(runnable, ResourcesPlugin.getWorkspace().getRoot());
	}

	/**
	 * Runs a workspace runnable with the given lock or <code>null</code> to run with no lock at all.
	 */
	public WorkbenchRunnableAdapter(IWorkspaceRunnable runnable, ISchedulingRule rule) {
		fWorkspaceRunnable = runnable;
		fRule = rule;
	}

	public ISchedulingRule getSchedulingRule() {
		return fRule;
	}

	/*
	 * @see IRunnableWithProgress#run(IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			// JavaCore.run(fWorkspaceRunnable, fRule, monitor);
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
//            if (workspace.isTreeLocked()) {
//                new BatchOperation(fWorkspaceRunnable).run(monitor);
//            } else {
			// use IWorkspace.run(...) to ensure that a build will be done in autobuild mode
			// workspace.run(new BatchOperation(fWorkspaceRunnable), fRule, IWorkspace.AVOID_UPDATE, monitor);
			workspace.run(fWorkspaceRunnable, fRule, IWorkspace.AVOID_UPDATE, monitor);
			// }
		} catch (OperationCanceledException e) {
			throw new InterruptedException(e.getMessage());
		} catch (CoreException e) {
			throw new InvocationTargetException(e);
		}
	}

	public void runAsUserJob(String name, final Object jobFamiliy) {
		Job buildJob = new Job(name) {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
			 */
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					WorkbenchRunnableAdapter.this.run(monitor);
				} catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					if (cause instanceof CoreException) {
						return ((CoreException) cause).getStatus();
					} else {
						// return JavaUIStatus.createError(IStatus.ERROR, cause);
					}
				} catch (InterruptedException e) {
					return Status.CANCEL_STATUS;
				} finally {
					monitor.done();
				}
				return Status.OK_STATUS;
			}

			@Override
			public boolean belongsTo(Object family) {
				return jobFamiliy == family;
			}
		};
		buildJob.setRule(fRule);
		buildJob.setUser(true);
		buildJob.schedule();

		// TODO: should block until user pressed 'to background'
	}
}
