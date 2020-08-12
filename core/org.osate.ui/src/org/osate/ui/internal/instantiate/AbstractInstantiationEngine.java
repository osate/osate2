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
	protected final List<?> selectionAsList;

	public AbstractInstantiationEngine(final List<?> selectionAsList) {
		this.selectionAsList = selectionAsList;
	}

	/**
	 * Instantiate models based on the selected items.  Blocks the current job/thread until it is finished, so this should
	 * not be called from the ui thread.
	 *
	 * XXX: Needs to return ok or cancel status
	 *
	 * XXX: Needs to return the list of successfully instantiated models
	 *
	 * XXX: Say something about the abstract methods here
	 */
	public final List<SystemInstance> instantiate() {
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
				if (helper.performPrereqs()) {
					final JobGroup jobGroup = new JobGroup("Instantiation", 0, 0);
					final Job myJobs[] = new Job[size];
					for (int i = 0; i < size; i++) {
						final Job job = helper.getJob(i, results);
						job.setUser(true);
						job.setJobGroup(jobGroup);
						myJobs[i] = job;
					}

					final Job resultJob = new ResultJob(jobGroup, results);
					resultJob.setRule(null); // doesn't use resources
					resultJob.setUser(false); // background helper job, don't let the user see it
					resultJob.setSystem(true); // background helper job, don't let the user see it
					resultJob.schedule();

					// now launch the main jobs
					for (final Job job : myJobs) {
						job.schedule();
					}

					// Wait for the whole thing to complete
					try {
						resultJob.join();
					} catch (final InterruptedException e) {
						cancelled = true;
					}
				}
			}

			if (cancelled) {
				return Collections.emptyList();
			} else {
				final List<SystemInstance> successfullyInstantiated = new ArrayList<>(size);
				for (final InternalJobResult ijr : results.values()) {
					if (ijr.systemInstance != null) {
						successfullyInstantiated.add(ijr.systemInstance);
					}
				}
				return Collections.unmodifiableList(successfullyInstantiated);
			}
		}

		// Nothing was selected, so we didn't do anything
		return Collections.emptyList();
	}

	protected abstract class PrereqHelper {
		public abstract void handleInput(final T input);

		/**
		 * @return {@code true} if prerequisites succeeded.
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
			SystemInstance systemInstance = null;

			boolean delete = false;
			try {
				systemInstance = buildSystemInstance(subMonitor.split(1));
				successful = systemInstance != null;
				errorMessage = InstantiateModel.getErrorMessage();
				delete = !successful;
			} catch (final InterruptedException | OperationCanceledException e) {
				// Instantiation was canceled by the user.
				cancelled = true;
				systemInstance = null;
				delete = true;
			} catch (final RootMissingException e) {
				successful = false;
				errorMessage = "Root component implementation declaration no longer exists; instance model removed";
				systemInstance = null;
				delete = true;
			} catch (final Exception e) {
				OsateUiPlugin.log(e);
				successful = false;
				exception = e;
				systemInstance = null;
				delete = true;
			}

			if (delete) {
				// Remove the partially instantiated resource
				try {
					final IFile outputFile = getOutputFile();
					if (outputFile.exists()) {
						outputFile.delete(0, null);
					}
				} catch (final CoreException ce) {
					// eat it
				}
			}

			final InternalJobResult result = new InternalJobResult(successful, cancelled, errorMessage, exception,
					systemInstance);
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

	protected abstract Set<T> getInputsFromSelection(List<?> selectionAsList);

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
