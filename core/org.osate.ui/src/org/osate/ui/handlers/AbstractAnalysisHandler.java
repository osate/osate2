/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.FileNameConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.core.AadlNature;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.Result;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.internal.instantiate.InstantiationEngine;

/**
 * Working replacement for {@link #AaxlReadOnlyHandlerAsJob}.  Not at all "ready for prime-time", which
 * is why it is currently package visibility.  Also consider integrating with
 * {@code org.osate.ui.handlers.AbstractMultiJobHandler}.
 *
 * <p>Assumptions: The analysis selection is a bunch of working sets, AADL projects, folders, and aaxl files.
 * There is a method for getting a list of unique aaxl files from that.  IT is assumed analysis can
 * run on each aaxl file independently.  Analysis may produce markers on each aaxl file, and may create a
 * single output file for each input aaxl file.  For each input file, the output file is located
 * in "reports/subdir/" rooted in the same directory as the input file.  The analysis names "subdir"
 * using an abstract method.  The output file is named using an abstract method.
 *
 * <p>We need more experience writing some "modern" osate analyses.  This class is expected to evolve as
 * it sees more use.  It's possible we will find some analysis that doesn't fit
 * the assumptions at all.
 *
 * @author aarong
 * @since 6.2
 */
public abstract class AbstractAnalysisHandler extends AbstractHandler {
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
			super("Analysis kickoff");
			this.selectionAsList = selectionAsList;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			/* Find the aaxl files and the component implementations from the UI selection */
			final Set<IFile> aaxlFiles = new HashSet<>();
			final Set<Object> forEngine = new HashSet<>();
			findAllInstanceFilesAndComponentImpls(selectionAsList, aaxlFiles, forEngine);

			/*
			 * Instantiate the component implementations and add those that were successful to the
			 * set of aaxl files.
			 */
			if (!forEngine.isEmpty()) {
				final InstantiationEngine engine = new InstantiationEngine(forEngine);
				final List<IFile> newAaxlFiles = engine.instantiate(monitor);
				aaxlFiles.addAll(newAaxlFiles);
			}
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
	 * files.  Also finds all the COmponentImplementations that are selected and adds those to the
	 * set referenced by {@code forEngine}.  If a resource is an AADL project, working set, or folder then the contents are recursively searched.
	 * Duplicates are handled: if a resource is encountered more than once it only appears once in
	 * the returned list.  Hidden folders (those that start with {@code .}) are ignored.
	 *
	 * @param A collection of Eclipse {@link IResource} objects and {@link IWorkingSet} objects.
	 * @return A list of {@link IFile} objects that refer to AADL instance model files.
	 */
	private static void findAllInstanceFilesAndComponentImpls(final Collection<Object> rsrcs,
			final Set<IFile> instanceFiles, final Set<Object> forEngine) {
		findAllInstanceFilesAndComponentImpls(rsrcs.toArray(new Object[rsrcs.size()]), instanceFiles, forEngine);
	}

	private static void findAllInstanceFilesAndComponentImpls(final Object[] rsrcs, final Set<IFile> instanceFiles,
			final Set<Object> forEngine) {
		for (final Object rsrc : rsrcs) {
			if (rsrc instanceof IWorkingSet) {
				findAllInstanceFilesAndComponentImpls(((IWorkingSet) rsrc).getElements(), instanceFiles, forEngine);
			} else if (rsrc instanceof IFile) {
				final IFile file = (IFile) rsrc;
				final String ext = file.getFileExtension();
				if (ext != null && ext.equals(FileNameConstants.INSTANCE_FILE_EXT)) {
					instanceFiles.add(file);
				}
			} else if (rsrc instanceof SystemInstance) {
				instanceFiles.add(OsateResourceUtil.toIFile(((SystemInstance) rsrc).eResource().getURI()));
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
						findAllInstanceFilesAndComponentImpls(container.members(), instanceFiles, forEngine);
					} catch (final CoreException e) {
						OsateUiPlugin.getDefault().getLog().error(e.getMessage(), e);
					}
				}
			} else {
				// pass through to the instantiation engine
				forEngine.add(rsrc);
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
				OsateUiPlugin.getDefault().getLog().error(e.getMessage(), e);
			}
		}
	}

	// ============================================================
	// == Generate markers for the whole analysis result tree
	// ============================================================

	/**
	 * Generate an Eclipse marker for each diagnostic in the analysis results tree.  This method
	 * assumes that the first layer of {@link Result} objects is one result per system operation mode,
	 * and the name of the system operation mode is used as the message of that result.
	 * @param analysisResult The analysis result tree to generate markers from
	 * @param errManager The error manager used to generate markers.
	 */
	protected static void generateMarkers(final AnalysisResult analysisResult,
			final AnalysisErrorReporterManager errManager) {
		// Handle each SOM
		analysisResult.getResults().forEach(r -> {
			final String somName = r.getMessage();
			final String somPostfix = somName.isEmpty() ? "" : (" in modes " + somName);
			generateMarkersForResult(r, errManager, somPostfix);
		});
	}

	private static void generateMarkersForResult(final Result result, final AnalysisErrorReporterManager errManager,
			final String somPostfix) {
		generateMarkersFromDiagnostics(result.getDiagnostics(), errManager, somPostfix);
		result.getSubResults().forEach(r -> generateMarkersForResult(r, errManager, somPostfix));
	}

	private static void generateMarkersFromDiagnostics(final List<Diagnostic> diagnostics,
			final AnalysisErrorReporterManager errManager, final String somPostfix) {
		diagnostics.forEach(issue -> {
			switch (issue.getDiagnosticType()) {
			case ERROR:
				errManager.error((Element) issue.getModelElement(), issue.getMessage() + somPostfix);
				break;
			case INFO:
				errManager.info((Element) issue.getModelElement(), issue.getMessage() + somPostfix);
				break;
			case WARNING:
				errManager.warning((Element) issue.getModelElement(), issue.getMessage() + somPostfix);
				break;
			default:
				// Do nothing.
			}
		});
	}

	// ============================================================
	// == Output the results
	// ============================================================

	/*
	 * XXX: SHould this be moved somewhere else? Maybe org.osate.result.util?? I kept
	 * the methods names more generic, that is, "content" instead of "CSV" in case they
	 * are later moved to a superclass.
	 */

	// Should this have a superclass? Are there other output types we want to deal with?
	protected static abstract class CSVAnalysisResultWriter {
		private final IFile outputFile;

		protected CSVAnalysisResultWriter(final IFile outputFile) {
			this.outputFile = outputFile;
		}

		/**
		 * Write the results from given Analysis Results object.
		 *
		 * @param analysisResult The analysis results to write.
		 * @param monitor The progress monitor to use; may be {@code null}.
		 */
		public void writeAnalysisResults(final AnalysisResult analysisResult, final IProgressMonitor monitor) {
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 3);
			final String csvContent = getContentAsString(analysisResult, subMonitor.split(1));
			final InputStream inputStream = new ByteArrayInputStream(csvContent.getBytes());

			try {
				if (outputFile.exists()) {
					outputFile.setContents(inputStream, true, true, subMonitor.split(1));
				} else {
					outputFile.create(inputStream, true, subMonitor.split(1));
				}
			} catch (final CoreException e) {
				Activator.logThrowable(e);
			}
		}

		private String getContentAsString(final AnalysisResult analysisResult, final IProgressMonitor monitor) {
			final StringWriter writer = new StringWriter();
			final PrintWriter pw = new PrintWriter(writer);
			generateContentforAnalysis(pw, analysisResult, monitor);
			pw.close();
			return writer.toString();
		}

		private void generateContentforAnalysis(final PrintWriter pw, final AnalysisResult analysisResult,
				final IProgressMonitor monitor) {
			pw.println(analysisResult.getMessage());
			pw.println();
			pw.println();

			final SubMonitor subMonitor = SubMonitor.convert(monitor, analysisResult.getResults().size());
			analysisResult.getResults().forEach(somResult -> {
				if (Aadl2Util.isPrintableSOMName((SystemOperationMode) somResult.getModelElement())) {
					printItem(pw, "Analysis results in modes " + somResult.getMessage());
					pw.println();
				}
				generateContentforSOM(pw, somResult, subMonitor.split(1));
			});
		}

		protected abstract void generateContentforSOM(final PrintWriter pw, final Result somResult,
				final IProgressMonitor monitor);

		// ==== Low-level CSV format

		protected final void generateContentforDiagnostics(final PrintWriter pw, final List<Diagnostic> diagnostics,
				final IProgressMonitor monitor) {
			final SubMonitor subMonitor = SubMonitor.convert(monitor, diagnostics.size());
			for (final Diagnostic issue : diagnostics) {
				printItem(pw, issue.getDiagnosticType().getName() + ": " + issue.getMessage());
				pw.println();
				subMonitor.split(1);
			}
		}

		protected final void printItems(final PrintWriter pw, final String item1, final String... items) {
			printItem(pw, item1);
			for (final String nextItem : items) {
				printSeparator(pw);
				printItem(pw, nextItem);
			}
			pw.println();
		}

		protected final void printItem(final PrintWriter pw, final String item) {
			// TODO: Doesn't handle quotes in the item!
			pw.print('"');
			pw.print(item);
			pw.print('"');
		}

		protected final void printSeparator(final PrintWriter pw) {
			pw.print(',');
		}
	}
}
