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
package org.osate.analysis.resource.budgets.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.core.AadlNature;
import org.osate.workspace.WorkspacePlugin;

/**
 * Working replacement for {@link #AaxlReadOnlyHandlerAsJob}.  Not at all "ready for prime-time", which
 * is why it is currently package visibility.  Also consider integrating with
 * {@code org.osate.ui.handlers.AbstractMultiJobHandler}.
 *
 * Assumptions: The analysis selection is a bunch of working sets, AADL projects, folders, and aaxl files.
 * There is a method for getting a list of unique aaxl files from that.  IT is assumed analysis can
 * run on each aaxl file independently.  Analysis may produce markers on each aaxl file, and may create a
 * single output file for each input aaxl file.  For each input file, the output file is located
 * in "reports/subdir/" rooted in the same directory as the input file.  The analysis names "subdir"
 * using an abstract method.  The output file is named using an abstract method.
 *
 * We need more experience writing some "modern" osate analyses.  I'm sure this draft class will
 * need to be modified further.  It's possible we will find some analysis that doesn't fit
 * the assumptions at all.
 *
 * @author aarong
 *
 * @since 3.0
 */
abstract class NewAbstractAaxlHandler extends AbstractHandler {
	private static final String REPORTS_DIR = "/reports";

	@Override
	public final Object execute(final ExecutionEvent event) throws ExecutionException {
		/*
		 * Do as little as possible here so we don't hold up the UI thread. Just get the
		 * selected items in a raw list and start a new job to figure everything else out.
		 */
		@SuppressWarnings("unchecked")
		final List<Object> selectionAsList = HandlerUtil.getCurrentStructuredSelection(event).toList();
		final Job job = new KickoffJob(selectionAsList);
		job.setRule(null); // doesn't use resources
		job.setUser(false); // background helper job, don't let the user see it
		job.setSystem(true); // background helper job, don't let the user see it
		job.schedule();

		// Supposed to always return null
		return null;
	}

	/*
	 * Job that starts everything else out. Goes through the selection and finds all the
	 * selected Aaxl files. Figures out the resource locking and output files needed
	 * to analyze each instance model.
	 *
	 * AS STATED ABOVE, THE ASSUMPTION HERE IS THAT EACH INSTANCE MODEL CAN BE ANALYZED INDEPENDENT
	 * OF THE OTHER ONES.
	 *
	 * WE ALSO ASSUME THAT EACH INPUT FILE CREATES A SINGLE OUTPUT FILE (probably a .csv file).
	 */
	private final class KickoffJob extends Job {
		private final List<Object> selectionAsList;

		public KickoffJob(final List<Object> selectionAsList) {
			super("Analysis Kickoff (hidden)");
			this.selectionAsList = selectionAsList;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			// Get all the Aaxl files from the selection
			final List<IFile> aaxlFiles = findAllInstanceFiles(selectionAsList);
			final int size = aaxlFiles.size();

			/*
			 * Go through all the input files and find all the output files and associated
			 * scheduling rules.
			 */
			final IResourceRuleFactory ruleFactory = ResourcesPlugin.getWorkspace().getRuleFactory();
			ISchedulingRule prereqRule = null; // Initially empty
			final Set<IFolder> outputFolders = new HashSet<>();
			final List<IFile> outputFiles = new ArrayList<>(size);
			final Job myJobs[] = new Job[size];

			int idx = 0;
			for (final IFile aaxlFile : aaxlFiles) {
				// Get the output file, its location, and the base filename of the input file
				final IPath pathSansExtension = aaxlFile.getFullPath().removeFileExtension();
				final String filename = pathSansExtension.lastSegment();
				final IPath reportsPath = pathSansExtension.removeLastSegments(1).append(REPORTS_DIR);
				final IPath outputPath = reportsPath.append("/" + getSubDirName());

				final IFolder reportsFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(reportsPath);
				final IFolder outputFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(outputPath);
				outputFolders.add(outputFolder);

				final IFile outputFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFile(outputPath.append("/" + getOutputFileForAaxlFile(aaxlFile, filename)));
				outputFiles.add(outputFile);
				prereqRule = MultiRule.combine(prereqRule, MultiRule.combine(
						ruleFactory.createRule(reportsFolder),
						MultiRule.combine(ruleFactory.createRule(outputFolder), ruleFactory.createRule(outputFile))));

				final ISchedulingRule jobRule = MultiRule.combine(ruleFactory.modifyRule(outputFile),
						ruleFactory.markerRule(aaxlFile));
				final Job job = createAnalysisJob(aaxlFile, outputFile);
				job.setRule(jobRule);
				job.setUser(true);
				myJobs[idx] = job;

				idx += 1;
			}

			/*
			 * Make sure all the output folders exists before hand. Could add the folder creation rules to the
			 * jobs below, but they would limit the parallelism too much. So we create them atomically here first,
			 * before we launch the main worker jobs.
			 *
			 * We also create (touch) all the output files before hand because creation requires locking the parent container,
			 * whereas modifying only requires locking the file itself.
			 *
			 * This means that the methods in the subclass that output to the file must use IFile.setContents().
			 */
			boolean prereqFailed = false;
			try {
				ResourcesPlugin.getWorkspace().run(m -> {
					for (final IFolder folder : outputFolders) {
						makeSureFoldersExist(folder);
					}
					for (final IFile file : outputFiles) {
						if (!file.exists()) {
							file.create(EmptyInputStream.INSTANCE, true, null);
						}
					}
				}, prereqRule, IWorkspace.AVOID_UPDATE, null);
			} catch (CoreException e) {
				prereqFailed = true;
				Activator.logThrowable(e);

				PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
					MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							"Error starting analysis",
							"Exception starting analysis, see the error log: " + e.getMessage());
				});
			}

			if (!prereqFailed) {
				// now launch the main jobs
				for (final Job job : myJobs) {
					job.schedule();
				}
			}

			return Status.OK_STATUS;
		}
	}

	/**
	 * Return the name of the subdirectory under the "reports" directory that the output files
	 * for this analysis are located in.
	 *
	 * @return The name of the subdirectory, e.g., {@code "BusLoad"}.
	 */
	protected abstract String getSubDirName();

	/**
	 * Given an instance model file that is to be analyzed, return the name of the output file
	 * to generate after analyzing the given file.  This name does not include path information, and
	 * is usually generated by appending a label to the filename and then adding the appropriate file
	 * extension.  For example, the bus load analysis just returns the {@code filename} with the
	 * extension {@code .csv}.
	 *
	 * @param aaxlFile The file bing analyzed.
	 *
	 * @param filename The filename part of the file for convenience.  This does not include the file
	 * extension.
	 *
	 * @return The output file name.
	 */
	protected abstract String getOutputFileForAaxlFile(IFile aaxlFile, String filename);

	/**
	 * Return a job that analyzes the given instance model file and puts the results in the
	 * given output file.  We assume here that the analysis doesn't rely on anything other than
	 * the given instance model file.  More specifically, if multiple instance models were selected
	 * to launch this action, they can all be analyzed independently of each other.
	 *
	 * <p><em>Note: If the job needs IScheudlingRules beyond the ability to create markers on the instance model
	 * file or to write to the output file, it is currently out of luck. This is an area of future
	 * abstraction if needed.</em></p>
	 *
	 * @param aaxlFile The instance model file to analyze.
	 *
	 * @param outputFile The file to write output to.  This file is guaranteed to exist already.  The
	 * existing contents of the file are not guaranteed.  That is, the file may be new and empty, or it
	 * may contain the results from a previous analysis run, or it could just be garbage.
	 *
	 * @return A job class that executes analysis on the given instnace model file.
	 */
	protected abstract Job createAnalysisJob(IFile aaxlFile, IFile outputFile);

	private static final class EmptyInputStream extends InputStream {
		public static final EmptyInputStream INSTANCE = new EmptyInputStream();

		private EmptyInputStream() {
			super();
		}

		@Override
		public int read() throws IOException {
			return -1;
		}
	}

	/**
	 * Given a collection of resources, find all the resources that are instance model ({@code .aaxl})
	 * files.  If a resource is an AADL project, working set, or folder then the contents are recursively searched.
	 * Duplicates are handled: if a resource is encountered more than once it only appears once in
	 * the returned list.  Hidden folders (those that start with {@code .}) are ignored.
	 *
	 * @param A collection of Eclipse {@link IResource} objects and {@link IWorkingSet} objects.
	 * @return A list of {@link IFile} objects that refer to AADL instance model files.
	 */
	public static List<IFile> findAllInstanceFiles(final Collection<Object> rsrcs) {
		final List<IFile> instanceFiles = new ArrayList<>();
		findAllInstanceFiles(rsrcs.toArray(new Object[rsrcs.size()]), instanceFiles);
		// remove duplicates
		return instanceFiles.stream().distinct().collect(Collectors.toList());
	}

	private static void findAllInstanceFiles(final Object[] rsrcs, final List<IFile> instanceFiles) {
		for (final Object rsrc : rsrcs) {
			if (rsrc instanceof IWorkingSet) {
				findAllInstanceFiles(((IWorkingSet) rsrc).getElements(), instanceFiles);
			} else if (rsrc instanceof IFile) {
				final IFile file = (IFile) rsrc;
				final String ext = file.getFileExtension();
				if (ext.equals(WorkspacePlugin.INSTANCE_FILE_EXT)) {
					instanceFiles.add(file);
				}
			} else if (rsrc instanceof IContainer) {
				final IContainer container = (IContainer) rsrc;
				if (container instanceof IProject) {
					final IProject project = (IProject) container;
					if (!project.isOpen() || !AadlNature.hasNature(project)) {
						// Project is closed or is not an AADL project, so ignore it
						continue;
					}
				}

				if (!container.getName().startsWith(".")) {
					try {
						findAllInstanceFiles(container.members(), instanceFiles);
					} catch (final CoreException e) {
						WorkspacePlugin.log(e);
					}
				}
			}
		}
	}

	/**
	 * make sure the folders exist all along the path
	 *
	 * @param path
	 */
	private static void makeSureFoldersExist(IFolder folder) {
		if (!folder.exists()) {
			makeSureFoldersExist((IFolder) folder.getParent());
			try {
				folder.create(true, true, null);
			} catch (final CoreException e) {
				WorkspacePlugin.log(e);
			}
		}
	}

}
