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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobGroup;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.label.AbstractLabelProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.SubprogramGroupImplementation;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.UiUtil;
import org.osate.ui.dialogs.InstantiationResultsDialog;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;

import com.google.inject.Inject;

/**
 * @since 3.0
 */
public final class InstantiationHandler extends AbstractMultiJobHandler {
	@Inject
	private XtextResourceSetProvider resourceSetProvider;

	public InstantiationHandler() {
		Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Get a COPY of the selection for thread safety
		@SuppressWarnings("unchecked")
		final List<?> selectionAsList = new ArrayList<>(HandlerUtil.getCurrentStructuredSelection(event).toList());

		final Job job = new KickoffJob(selectionAsList);
		job.setRule(null); // doesn't use resources
		job.setUser(false); // background helper job, don't let the user see it
		job.setSystem(true); // background helper job, don't let the user see it
		job.schedule();

		// Supposed to always return null
		return null;
	}

	private final class KickoffJob extends Job {
		private final List<?> selectionAsList;

		public KickoffJob(final List<?> selectionAsList) {
			super("Instantiation Handler (hidden)");
			this.selectionAsList = selectionAsList;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			final Set<ComponentImplementation> selectedCompImplsSet = getComponentImplsFromSelection(selectionAsList);
			final int size = selectedCompImplsSet.size();

			if (size > 0) {
				/*
				 * This map is shared by all the jobs to build the set of results. It is created here,
				 * given to all the jobs, and then forgotten.
				 */
				final Map<ComponentImplementation, Result> results = new ConcurrentHashMap<>(size);

				final List<ComponentImplementation> selectedCompImpls = new ArrayList<>(size);
				final List<IFile> outputFiles = new ArrayList<>(size);
				final Set<IFolder> outputFolders = new HashSet<>();

				final IResourceRuleFactory factory = ResourcesPlugin.getWorkspace().getRuleFactory();
				ISchedulingRule prereqRule = null;

				for (final ComponentImplementation impl : selectedCompImplsSet) {
					selectedCompImpls.add(impl);
					final IFile outputFile = OsateResourceUtil.toIFile(InstantiateModel.getInstanceModelURI(impl));
					outputFiles.add(outputFile);
					final IFolder outputFolder = (IFolder) outputFile.getParent(); // N.B. We KNOW there is an "Instances" folder above the .aaxl file
					outputFolders.add(outputFolder);
					prereqRule = MultiRule.combine(prereqRule, factory.createRule(outputFolder));
					/*
					 * Init each result as cancelled because if the job is cancelled before it starts, it will never
					 * add a new result record to the map. This way those jobs that never run are accounted for.
					 */
					results.put(impl, new Result(false, true, null, null));
				}

				/* Make sure the resources are saved if they are open in an editor */
				if (!saveDirtyEditors()) {
					return Status.CANCEL_STATUS;
				}

				/*
				 * Make sure all the output folders exists before hand. Could add the folder creation rules to the
				 * jobs below, but they would limit the parallelism too much. So we create them atomically here first,
				 * before we launch the main worker jobs.
				 */
				boolean prereqFailed = false;
				try {
					ResourcesPlugin.getWorkspace().run(m -> {
						for (final IFolder folder : outputFolders) {
							if (!folder.exists()) {
								folder.create(false, true, null);
							}
						}
					}, prereqRule, IWorkspace.AVOID_UPDATE, null);
				} catch (CoreException e) {
					prereqFailed = true;
					OsateUiPlugin.log(e);

					PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
						MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
								"Error staring instantiation",
								"Exception starting model instantiation, see the error log: " + e.getMessage());
					});
				}

				if (!prereqFailed) {
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
				}
			}

			return Status.OK_STATUS;
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

	private static final class ResultJob extends Job {
		private final JobGroup instantiationJobs;
		private final Map<ComponentImplementation, Result> results;

		public ResultJob(final JobGroup intantiationJob, final Map<ComponentImplementation, Result> results) {
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
						|| !Result.allSuccessful(results.values())) {
					/* Get the results and display them */
					PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
						final InstantiationResultsDialog<?> d = new InstantiationResultsDialog<ComponentImplementation>(
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Instantiation",
								"Component Implementation", compImpl -> compImpl.getQualifiedName(), results,
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

	private Set<ComponentImplementation> getComponentImplsFromSelection(final List<?> selectionAsList) {
		final Set<ComponentImplementation> ciSet = new HashSet<>();
		final List<ComponentImplementation> fromAadl = new ArrayList<>();

		for (final Object selection : selectionAsList) {
			if (selection instanceof IFile) {
				final URI uri = OsateResourceUtil.toResourceURI((IFile) selection);
				final EList<EObject> contents = new ResourceSetImpl().getResource(uri, true).getContents();
				if (null != contents && !contents.isEmpty()) {
					final EObject root = contents.get(0);
					if (!(root instanceof AadlPackage)) {
						throw new AssertionError("Unexpected selection: " + selection + " is not an AADL package file");
					}
					getComponentImplsFromPackage((AadlPackage) root, fromAadl);
				}
			} else {
				URI uri = null;
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
				ciSet.add(impl);
			}
		}

		if (!fromAadl.isEmpty()) {
			final boolean showDialog = OsateCorePlugin.getDefault().getAlwaysShowInstantiationAadlDialog();
			final boolean systemsOnly = OsateCorePlugin.getDefault().getOnlyInstantiateSystemImpls();

			final List<SystemImplementation> systems = new ArrayList<>();
			for (final ComponentImplementation ci : fromAadl) {
				if (ci instanceof SystemImplementation) {
					systems.add((SystemImplementation) ci);
				}
			}

			if (!showDialog) {
				ciSet.addAll(systemsOnly ? systems : fromAadl);
			} else {
				/*
				 * THe label provider is sloppy, as I'm replacing the text portion of the delegate and just using
				 * the image portion of the delegate, but I don't know how else to get the images.
				 */
				PlatformUI.getWorkbench().getDisplay().syncExec(() -> {
					final ElementListSelectionDialog d = new ElementListSelectionDialog(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							new AbstractLabelProvider(UiUtil.getModelElementLabelProvider()) {
								@Override
								public String getText(final Object element) {
									return ((ComponentImplementation) element).getQualifiedName();
								}
							}) {
						private Button dontShowButton;
						private Button systemsOnlyButton;

						@Override
						protected Control createDialogArea(final Composite parent) {
							Composite contents = (Composite) super.createDialogArea(parent);

							dontShowButton = new Button(contents, SWT.CHECK);
							dontShowButton.setText("Don't show this dialog again");
							GridData data = new GridData();
							data.grabExcessVerticalSpace = false;
							data.grabExcessHorizontalSpace = true;
							data.horizontalAlignment = GridData.FILL;
							data.verticalAlignment = GridData.BEGINNING;
							dontShowButton.setLayoutData(data);
							dontShowButton.setFont(parent.getFont());

							systemsOnlyButton = new Button(contents, SWT.CHECK);
							systemsOnlyButton.setText("Only systems by default");
							GridData data2 = new GridData();
							data2.grabExcessVerticalSpace = false;
							data2.grabExcessHorizontalSpace = true;
							data2.horizontalAlignment = GridData.FILL;
							data2.verticalAlignment = GridData.BEGINNING;
							systemsOnlyButton.setLayoutData(data2);
							systemsOnlyButton.setFont(parent.getFont());
							systemsOnlyButton.setSelection(systemsOnly);

							return contents;
						}

						@Override
						protected void okPressed() {
							final IPreferenceStore prefs = OsateCorePlugin.getDefault().getPreferenceStore();
							if (dontShowButton.getSelection()) {
								// User just toggled the "don't show option"
								if (MessageDialog.openQuestion(getShell(), "Confirm change",
										"This results dialog will be hidden in the future.  "
										+ "You can restore it by going to the \"OSATE > Instantiation\" preference pane.  "
												+ "Do you wish to make this change?")) {
									prefs.setValue(OsateCorePlugin.ALWAYS_SHOW_INSTANTIATION_AADL_DIALOG,
											false);
								}
							}
							prefs.setValue(OsateCorePlugin.ONLY_INSTANTIATE_SYSTEM_IMPLS,
									systemsOnlyButton.getSelection());
							if (prefs.needsSaving()) {
								final Job saveJob = Job.create("Save preferences", monitor -> {
									try {
										((IPersistentPreferenceStore) prefs).save();
									} catch (final IOException e) {
										Display.getDefault().asyncExec(() -> {
											MessageDialog.openError(getShell(), "Error",
													"There was a problem saving the preferences: " + e.getMessage());
										});
									}
								});
								saveJob.schedule();
							}

							super.okPressed();
						}
					};
					d.setTitle("Select Component Implementations");
					d.setMessage("Select the component implementations from the selected .aadl files to instantiate.");
					d.setElements(fromAadl.toArray());
					d.setMultipleSelection(true);
					d.setInitialElementSelections(systemsOnly ? systems : fromAadl);
					d.setBlockOnOpen(true);
					if (d.open() == IStatus.OK) {
						final Object[] result = d.getResult();
						for (final Object ci : result) {
							ciSet.add((ComponentImplementation) ci);
						}
					}
				});
			}
		}

		return ciSet;
	}

	private void getComponentImplsFromPackage(final AadlPackage root, List<ComponentImplementation> ciList) {
		// Get all the public component implementations that are not subprograms or subprogram groups
		for (final Classifier c : root.getPublicSection().getOwnedClassifiers()) {
			if (c instanceof ComponentImplementation
					&& !(c instanceof SubprogramImplementation || c instanceof SubprogramGroupImplementation)) {
				ciList.add((ComponentImplementation) c);
			}
		}
	}
}
