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
package org.osate.ui.internal.instantiate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobGroup;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.instantiation.RootMissingException;
import org.osate.core.AadlNature;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.OsateUiPlugin;

/**
 * @since 3.0
 */
abstract class AbstractInstantiationEngine<T> {
	protected final Collection<?> selectionAsList;

	public AbstractInstantiationEngine(final Collection<?> selectionAsList) {
		this.selectionAsList = selectionAsList;
	}

	/**
	 * Instantiate models based on the selected items.  Blocks the current job/thread until it is finished, so this should
	 * not be called from the ui thread.
	 *
	 * XXX: Say something about the abstract methods here
	 */
	public final List<IFile> instantiate(final IProgressMonitor monitor) {
		final Set<T> inputs = getInputsFromSelection(selectionAsList);
		final int size = inputs.size();

		boolean cancelled = false;

		if (size > 0) {
			/*
			 * This map is shared by all the jobs to build the set of results. It is created here,
			 * given to all the jobs, and then used to build te final method result.
			 */
			final Map<T, InternalJobResult> results = new ConcurrentHashMap<>(size);

			final PrereqHelper helper = getPrereqHelper(size, ResourcesPlugin.getWorkspace().getRuleFactory());
			for (final T input : inputs) {
				helper.handleInput(input);

				/*
				 * Init each result as cancelled because if the job is cancelled before it starts, it will never
				 * add a new result record to the map. This way those jobs that never run are accounted for.
				 */
				results.put(input, InternalJobResult.NOT_EXECUTED);
			}

			/* Make sure the resources are saved if they are open in an editor */
			if (!saveDirtyEditors()) {
				cancelled = true;
			} else {
				/*
				 * NB. Chances are the prerequisites (helper.performPrereqs()) will run code using Workspace.run(). This will cause
				 * the auto build thread to be interrupted and rescheduled if it is currently running.
				 */
				if (helper.performPrereqs()) {
					final SubMonitor subMonitor = SubMonitor.convert(monitor, 3);
					subMonitor.subTask("Waiting for build to finish");
					/* Wait for any builds to finish: Taken from DebugUIPlugin.launchInBackground(). */
					final IJobManager jobManager = Job.getJobManager();
					try {
						jobManager.join(ResourcesPlugin.FAMILY_MANUAL_BUILD, subMonitor.split(1));
						jobManager.join(ResourcesPlugin.FAMILY_AUTO_BUILD, subMonitor.split(1));
					} catch (OperationCanceledException | InterruptedException e) {
						cancelled = true;
					}

					/* NB. THere really isn't any way to guarantee that a new build doesn't start here */
					if (!cancelled) {
						final JobGroup jobGroup = new JobGroup("Instantiation", 0, 0);
						for (int i = 0; i < size; i++) {
							final Job job = helper.getJob(i, results);
							job.setUser(true);
							job.setJobGroup(jobGroup);
							job.schedule();
							/*
							 * NB. These jobs will interrupt the build job, if there is a new one. More accurately,
							 * the auto build job periodically checks to see if its rule blocks any other jobs, and
							 * if so, it interrupts and reschedules itself.
							 */
						}

						final Job resultJob = new ResultJob(jobGroup, results);
						resultJob.setRule(null); // doesn't use resources
						resultJob.setUser(false); // background helper job, don't let the user see it
						resultJob.setSystem(true); // background helper job, don't let the user see it
						resultJob.schedule();

						// Wait for the whole thing to complete
						try {
							subMonitor.subTask("Waiting for (re)instantiations to finish");
							resultJob.join(0L, subMonitor.split(1));
						} catch (final OperationCanceledException | InterruptedException e) {
							cancelled = true;
						}
					}
				}
			}

			if (cancelled) {
				return Collections.emptyList();
			} else {
				final List<IFile> successfullyInstantiated = new ArrayList<>(size);
				for (final InternalJobResult ijr : results.values()) {
					if (ijr.aaxlFile != null) {
						successfullyInstantiated.add(ijr.aaxlFile);
					}
				}
				return Collections.unmodifiableList(successfullyInstantiated);
			}
		}

		// Nothing was selected, so we didn't do anything
		return Collections.emptyList();
	}

	/**
	 * This a class so that it can have persistent state.  {@link #handleInput(Object)} can build up state that is
	 * used by the other two methods.  This is meant to determine what needs to be set up in the workspace before the
	 * instantiation can actually run.  Generally, this is expected to be determining what output folders need to exist.
	 * These would be computed for each input item on a call to {@link #handleInput(Object), and then actually created
	 * on a call to {@link #performPrereqs()}.  Finally {@link #getJob(int, Map)} is called for each of the input files,
	 * in the same order as {@link #handleInput(Object)} was called.  It is expected to return a job that can
	 * perform the instantiation and to set the rules on the job based on the prerequisites that have been accumulating.
	 */
	protected abstract class PrereqHelper {
		public abstract void handleInput(final T input);

		/**
		 * @return {@code true} if prerequisites succeeded.  Returns {@code false} if they failed,
		 * in which case the instantiation process is over.
		 */
		public abstract boolean performPrereqs();

		public abstract AbstractInstantiationJob getJob(int i, Map<T, InternalJobResult> results);
	}

	protected abstract PrereqHelper getPrereqHelper(int size, IResourceRuleFactory ruleFactory);

	protected abstract class AbstractInstantiationJob extends WorkspaceJob {
		private final Map<T, InternalJobResult> results;

		protected AbstractInstantiationJob(final String name, final Map<T, InternalJobResult> results) {
			super(name);
			this.results = results;
		}

		@Override
		public final IStatus runInWorkspace(final IProgressMonitor monitor) {
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 1);

			/*
			 * Error handling in buildIntanceModel is complicated and probably should not be handled the
			 * way it is, but I don't want to fix that right now, so we are going to capture all the information
			 * we can from it and display it to the user at the end of the operation.
			 */
			boolean successful = false;
			String errorMessage = null;
			Exception exception = null;
			boolean cancelled = false;

			boolean delete = false;
			try {
				final SystemInstance systemInstance = buildSystemInstance(subMonitor.split(1));
				successful = systemInstance != null;
				errorMessage = InstantiateModel.getErrorMessage();
				delete = !successful;
			} catch (final InterruptedException | OperationCanceledException e) {
				// Instantiation was canceled by the user.
				cancelled = true;
				delete = true;
			} catch (final RootMissingException e) {
				successful = false;
				errorMessage = "Root component implementation declaration no longer exists; instance model removed";
				delete = true;
			} catch (final Exception e) {
				OsateUiPlugin.log(e);
				successful = false;
				exception = e;
				delete = true;
			}

			final IFile outputFile = getOutputFile();
			if (delete) {
				// Remove the partially instantiated resource
				try {
					if (outputFile.exists()) {
						outputFile.delete(0, null);
					}
				} catch (final CoreException ce) {
					// eat it
				}
			}

			final InternalJobResult result = new InternalJobResult(successful, cancelled, errorMessage, exception,
					successful ? outputFile : null);
			results.put(getInput(), result);
			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}

		protected abstract SystemInstance buildSystemInstance(IProgressMonitor monitor)
				throws InterruptedException, OperationCanceledException, RootMissingException, Exception;

		protected abstract IFile getOutputFile();

		protected abstract T getInput();
	}

	private final class ResultJob extends Job {
		private final JobGroup instantiationJobs;
		private final Map<T, InternalJobResult> results;

		public ResultJob(final JobGroup intantiationJob, final Map<T, InternalJobResult> results) {
			super("Instantiation Result Job (hidden)");
			this.instantiationJobs = intantiationJob;
			this.results = results;
		}

		@Override
		public IStatus run(final IProgressMonitor monitor) {
			// Wait for the instantiation jobs to finish
			boolean cancelled = false;
			try {
				instantiationJobs.join(0L, null);

				/* User can suppress the dialog if all the results are successful */
				if (OsateCorePlugin.getDefault().getAlwaysShowInstantiationResults()
						|| !InternalJobResult.allSuccessful(results.values())) {
					/* Get the results and display them */
					PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
						final InstantiationResultsDialog<?> d = new InstantiationResultsDialog<T>(
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), getResultActionName(),
								getResultLabelName(), getResultLabelProvider(), results,
								OsateCorePlugin.getDefault().getPreferenceStore());
						d.open();
					});
				}
			} catch (final InterruptedException | OperationCanceledException e) {
				/*
				 * InterruptedException thrown if we are somehow cancelled. Not sure if
				 * or how this can happen, but if it does, just give up.
				 *
				 * OperationCancelledException is thrown if the progress monitor given
				 * to join() is cancelled, but we didn't give it one, so it should
				 * never occur.
				 */
				cancelled = true;
			}

			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}

	protected abstract Set<T> getInputsFromSelection(Collection<?> selectionAsList);

	protected abstract String getResultActionName();

	protected abstract String getResultLabelName();

	protected abstract Function<T, String> getResultLabelProvider();

	/**
	 * Ask to save all the dirty editors that belong to open AADL projects.
	 * @return {@code true} If the action should continue; {@code false} if the user
	 * selected the cancel option in the save dialog.
	 */
	// XXX: Should this be somewhere else, seems generally useful
	private static boolean saveDirtyEditors() {
		/* Find all the open AADL projects */
		final IProject[] allProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		final List<IProject> openAADLProjects = new ArrayList<>(allProjects.length);
		for (final IProject project : allProjects) {
			if (project.isOpen() && AadlNature.hasNature(project)) {
				openAADLProjects.add(project);
			}
		}

		final AtomicBoolean result = new AtomicBoolean();
		PlatformUI.getWorkbench().getDisplay().syncExec(() -> {
			result.set(IDE.saveAllEditors(openAADLProjects.toArray(new IProject[openAADLProjects.size()]), true));
		});
		return result.get();
	}
}
