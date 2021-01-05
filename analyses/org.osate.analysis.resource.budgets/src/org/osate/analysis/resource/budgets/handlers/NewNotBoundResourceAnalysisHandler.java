package org.osate.analysis.resource.budgets.handlers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.resource.budgets.notbound.NewNotBoundResoureAnalysis;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

/**
 * @since 4.1
 */
public class NewNotBoundResourceAnalysisHandler extends NewAbstractAaxlHandler {
	private static final String MARKER_TYPE = "org.osate.analysis.resource.budgets.NotBoundAnalysisMarker";
	private static final String REPORT_SUB_DIR = "NotBound";

	public NewNotBoundResourceAnalysisHandler() {
		super();
	}

	@Override
	protected String getSubDirName() {
		return REPORT_SUB_DIR;
	}

	@Override
	protected String getOutputFileForAaxlFile(final IFile aaxlFile, final String filename) {
		return filename + "__NotBoundResourceBudgets.csv";
	}

	@Override
	protected Job createAnalysisJob(final IFile aaxlFile, final IFile outputFile) {
		return new NotBoundJob(aaxlFile, outputFile);
	}

	private final class NotBoundJob extends WorkspaceJob {
		private final IFile aaxlFile;
		private final IFile outputFile;

		public NotBoundJob(final IFile aaxlFile, final IFile outputFile) {
			super("Not bound resource analysis of " + aaxlFile.getName());
			this.aaxlFile = aaxlFile;
			this.outputFile = outputFile;
		}

		@Override
		public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
			final AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
					new MarkerAnalysisErrorReporter.Factory(MARKER_TYPE));

			// Three phases (1) analysis, (2) marker generation, (3) csv file
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 3);
			boolean cancelled = false;

			try {
				final AnalysisResult analysisResult = new NewNotBoundResoureAnalysis().invoke(subMonitor.split(1),
						(SystemInstance) AadlUtil.getElement(aaxlFile));
				if (subMonitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				generateMarkers(analysisResult, errManager);
				subMonitor.worked(1);

				final String csvContent = getCSVasString(analysisResult);
				final InputStream inputStream = new ByteArrayInputStream(csvContent.getBytes());
				writeCSVFile(inputStream, outputFile, subMonitor.split(1));
			} catch (final OperationCanceledException e) {
				cancelled = true;
			}

			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}

	// === CSV Output methods ===

	private static String getCSVasString(final AnalysisResult analysisResult) {
		final StringWriter writer = new StringWriter();
		final PrintWriter pw = new PrintWriter(writer);
		generateCSVforAnalysis(pw, analysisResult);
		pw.close();
		return writer.toString();
	}

	private static void generateCSVforAnalysis(final PrintWriter pw, final AnalysisResult analysisResult) {
		pw.println(analysisResult.getMessage());
		pw.println();
		pw.println();
		analysisResult.getResults().forEach(somResult -> generateCSVforSOM(pw, somResult));
	}

	private static void generateCSVforSOM(final PrintWriter pw, final Result somResult) {
		if (Aadl2Util.isPrintableSOMName((SystemOperationMode) somResult.getModelElement())) {
			printItem(pw, "Analysis results in modes " + somResult.getMessage());
			pw.println();
		}

		printItem(pw, "Detailed Processor MIPS Capacity Report " + somResult.getMessage());
		pw.println();

		printItems(pw, "Component", "Capacity");
		pw.println();

		int virtProcessorCount = 0;
		for (final Result subResult : somResult.getSubResults()) {
			// loop through processors
			if (ComponentCategory.PROCESSOR.getName().equalsIgnoreCase(ResultUtil.getString(subResult, 0))) {
				for (final Result compResult : subResult.getSubResults()) {
					printItems(pw, ResultUtil.getString(compResult, 0) + " " + ResultUtil.getString(compResult, 3),
							ResultUtil.getString(compResult, 2));
					pw.println();
				}

				printItems(pw, "Total", ResultUtil.getString(subResult, 2));
				pw.println();
			}
			else if (ComponentCategory.VIRTUAL_PROCESSOR.getName()
					.equalsIgnoreCase(ResultUtil.getString(subResult, 0))) {
				virtProcessorCount++;
			}
		}

		pw.println();

		if (virtProcessorCount > 0) {
			printItem(pw, "Detailed Virtual Processor MIPS Capacity Report " + somResult.getMessage());
			pw.println();

			printItems(pw, "Component", "Capacity");
			pw.println();

			for (final Result subResult : somResult.getSubResults()) {
				// loop through virtual processors
				if (ComponentCategory.PROCESSOR.getName().equalsIgnoreCase(ResultUtil.getString(subResult, 0))) {
					for (final Result compResult : subResult.getSubResults()) {
						printItems(pw, ResultUtil.getString(compResult, 0) + " " + ResultUtil.getString(compResult, 3),
								ResultUtil.getString(compResult, 2));
						pw.println();
					}

					printItems(pw, "Total", ResultUtil.getString(subResult, 3));
					pw.println();
				}
			}
		}

		printItem(pw, "Detailed MIPS Budget Report " + somResult.getMessage());
		printItems(pw, "Component", "Budget", "Actual", "Notes");

		for (final Result subResult : somResult.getSubResults()) {
			// loop through MIPS processors

		}

		// NO DIAGNOSTICS AT THE SOM LEVEL

//			somResult.getSubResults().forEach(busResult -> generateCSVforBus(pw, busResult, null));
		pw.println(); // add a second newline, the first is from the end of generateCSVforBus()
	}
}