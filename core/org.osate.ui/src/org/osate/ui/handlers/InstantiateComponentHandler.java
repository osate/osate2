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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.dialogs.InstantiationResultsDialog;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Inject;

public class InstantiateComponentHandler extends AbstractHandler {
	@Inject
	private XtextResourceSetProvider resourceSetProvider;

	public InstantiateComponentHandler() {
		Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<?> selectionAsList = HandlerUtil.getCurrentStructuredSelection(event).toList();
		final int size = selectionAsList.size();

		/*
		 * This map is shared by all the jobs to build the set of results. It is created here,
		 * given to all the jobs, and then forgotten.
		 */
		final Map<ComponentImplementation, Result> results = new ConcurrentHashMap<>(size);

		final List<ComponentImplementation> selectedCompImpls = new ArrayList<>(size);
		final List<IFile> outputFiles = new ArrayList<>(size);
		for (final Object selection : selectionAsList) {
			final URI uri;
			if (selection instanceof EObjectNode) {
				uri = ((EObjectNode) selection).getEObjectURI();
			} else if (selection instanceof EObjectURIWrapper) {
				uri = ((EObjectURIWrapper) selection).getUri();
			} else {
				throw new AssertionError("Unexpected selection: " + selection);
			}

			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1));
			final ResourceSet resourceSet = resourceSetProvider.get(project);
			final ComponentImplementation impl = (ComponentImplementation) resourceSet.getEObject(uri, true);
			selectedCompImpls.add(impl);
			outputFiles.add(OsateResourceUtil.toIFile(InstantiateModel.getInstanceModelURI(impl)));

			/*
			 * Init each result as cancelled because if the job is cancelled before it starts, it will never
			 * add a new result record to the map. This way those jobs that never run are accounted for.
			 */
			results.put(impl, new Result(false, true, null, null));
		}

		final IResourceRuleFactory factory = ResourcesPlugin.getWorkspace().getRuleFactory();
		final JobGroup jobGroup = new JobGroup("Instantiation", 0, 0);
		final Job myJobs[] = new Job[size];
		for (int i = 0; i < size; i++) {
			final IFile outputFile = outputFiles.get(i);
			final Job job = new InstantiationJob(selectedCompImpls.get(i), outputFile, results);
			/*
			 * NB. According to <https://www.eclipse.org/articles/Article-Concurrency/jobs-api.html> locking
			 * is only needed for modification, not for reading from resources. This seems sketchy to me
			 * but I'm going to go with it. Readers are supposed to written defensively, to expect that
			 * things might go wonky.
			 *
			 * We create and possibly remove the aaxl file in the case of errors.
			 */
			job.setRule(MultiRule.combine(factory.createRule(outputFile), factory.deleteRule(outputFile)));
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

		// Supposed to always return null
		return null;
	}

	/* Make everything final here so that this class is thread-safe immutable */
	public static final class Result {
		public final boolean successful;
		public final boolean cancelled;
		public final String errorMessage;
		public final Exception exception;

		public Result(final boolean successful, final boolean cancelled,
				final String errorMessage,
				final Exception exception) {
			this.successful = successful;
			this.cancelled = cancelled;
			this.errorMessage = errorMessage;
			this.exception = exception;
		}
	}

	private static final class InstantiationJob extends WorkspaceJob {
		private final ComponentImplementation compImpl;
		private final IFile outputFile;

		private final Map<ComponentImplementation, Result> results;

		public InstantiationJob(final ComponentImplementation compImpl, final IFile outputFile,
				final Map<ComponentImplementation, Result> results) {
			super("Instantiate " + compImpl.getQualifiedName());
			this.compImpl = compImpl;
			this.outputFile = outputFile;
			this.results = results;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) {
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
				final SystemInstance instance = InstantiateModel.buildInstanceModelFile(compImpl, subMonitor.split(1));
				successful = instance != null;
				errorMessage = InstantiateModel.getErrorMessage();
				delete = !successful;
			} catch (final InterruptedException | OperationCanceledException e) {
				// Instantiation was canceled by the user.
				cancelled = true;
				delete = true;
			} catch (final Exception e) {
				OsateUiPlugin.log(e);
				successful = false;
				exception = e;
				delete = true;
			}

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

			final Result result = new Result(successful, cancelled, errorMessage, exception);
			results.put(compImpl, result);

			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}

	private static final class ResultJob extends WorkspaceJob {
		private final JobGroup instantiationJobs;
		private final Map<ComponentImplementation, Result> results;

		public ResultJob(final JobGroup intantiationJob, final Map<ComponentImplementation, Result> results) {
			super("Instantiation Result Job (hidden)");
			this.instantiationJobs = intantiationJob;
			this.results = results;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) {
			// Wait for the instantiation jobs to finish
			boolean cancelled = false;
			try {
				instantiationJobs.join(0L, null);

				/* Get the results and display them */
				PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
					final InstantiationResultsDialog<?> d = new InstantiationResultsDialog<ComponentImplementation>(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Instantiation",
							"Component Implementation", compImpl -> compImpl.getQualifiedName(), results);
					d.open();
				});

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
}
