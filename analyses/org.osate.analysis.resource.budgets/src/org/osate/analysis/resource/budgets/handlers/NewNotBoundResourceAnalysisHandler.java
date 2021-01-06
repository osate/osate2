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
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

/**
 * @since 4.1
 */
public class NewNotBoundResourceAnalysisHandler extends NewAbstractAaxlHandler {
	private static final String MARKER_TYPE = "org.osate.analysis.resource.budgets.NotBoundAnalysisMarker";
	private static final String REPORT_SUB_DIR = "NotBoundResourceBudgets";

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
		pw.println();
		// detailedLog(prefix, ci, budget, subtotal, resourceName, unit, notes);
		/*
		 * String budgetmsg = prefix + GetProperties.toStringScaled(budget, unit) + ",";
		 * String actualmsg = prefix + GetProperties.toStringScaled(actual, unit) + ",";
		 * errManager.logInfo(prefix + ci.getCategory().getName() + " " + ci.getComponentInstancePath() + ", "
		 * + budgetmsg + actualmsg + msg);
		 *
		 * 0 ResultUtil.addRealValue(subResult, budgetSub); // budget
		 * 1 ResultUtil.addRealValue(subResult, budgetSubtotal); // actual
		 * 2 ResultUtil.addStringValue(subResult, notes);
		 * 3 ResultUtil.addStringValue(subResult, m.getLabel()); // resourceName
		 * 4 ResultUtil.addStringValue(subResult, GetProperties.toStringScaled(budgetSub, mipsliteral)); // budget message
		 * 5 ResultUtil.addStringValue(subResult, GetProperties.toStringScaled(budgetSubtotal, mipsliteral)); // actual budget message
		 *
		 * 0 ResultUtil.addStringValue(compResult, "MIPS"); // category
		 * 1 ResultUtil.addStringValue(compResult, mips.getSomName()); // somName
		 * 2 ResultUtil.addStringValue(compResult, GetProperties.toStringScaled(mips.getTotalCapacity(), mipsliteral)); // budget string in MIPS
		 * 3 ResultUtil.addStringValue(compResult, ci.getCategory().getName()); // component category name
		 * 4 ResultUtil.addStringValue(compResult, ci.getComponentInstancePath()); // component path
		 *
		 * 5 ResultUtil.addRealValue(compResult, mips.getTotalBudget(), mipsliteral.getName()); // in MIPS
		 * 6 ResultUtil.addRealValue(compResult, mips.getTotalCapacity(), mipsliteral.getName()); // in MIPS
		 *
		 */

		for (final Result subResult : somResult.getSubResults()) {
			// loop through MIPS
			if ("MIPS".equalsIgnoreCase(ResultUtil.getString(subResult, 0))) {
				for (final Result budgetResult : subResult.getSubResults()) {
					printItems(pw, ResultUtil.getString(subResult, 3) + " " + ResultUtil.getString(subResult, 4),
							ResultUtil.getString(budgetResult, 4), ResultUtil.getString(budgetResult, 5),
							ResultUtil.getString(budgetResult, 2));
					pw.println();
				}

				double total = ResultUtil.getReal(subResult, 5);
				if (total > 0) {
					printItems(pw, "Total", "", String.format("%.3f " + ResultUtil.getString(subResult, 7), total));
					pw.println();

					printItem(pw, "Resource Summary: " + ResultUtil.getString(subResult, 1));
					pw.println();

					for (final Diagnostic d : subResult.getDiagnostics()) {
						String prefix = d.getDiagnosticType() == DiagnosticType.ERROR ? "** "
								: (d.getDiagnosticType() == DiagnosticType.WARNING ? "* " : "");

						printItem(pw, prefix + d.getMessage());
						pw.println();
					}
				}
			}
		}

		// memory
		for (final Result subResult : somResult.getSubResults()) {
			// loop through MIPS
			if (ComponentCategory.MEMORY.getName().equalsIgnoreCase(ResultUtil.getString(subResult, 0))) {
				/*
				 * 0 ResultUtil.addStringValue(memResult, "Memory"); // category
				 * 1 ResultUtil.addStringValue(memResult, memory.getSomName()); // somName
				 *
				 * 2 ResultUtil.addStringValue(memResult,
				 * GetProperties.toStringScaled(memory.getTotalCapacityMemory(), kbliteral)); // budget for Memory string in Kbytes
				 * 3 ResultUtil.addStringValue(memResult, GetProperties.toStringScaled(memory.getTotalCapacityRAM(), kbliteral)); // budget for RAM string in
				 * Kbytes
				 * 4 ResultUtil.addStringValue(memResult, GetProperties.toStringScaled(memory.getTotalCapacityROM(), kbliteral)); // budget for ROM string in
				 * Kbytes
				 *
				 * 5 ResultUtil.addStringValue(memResult, ci.getCategory().getName()); // component category name
				 * 6 ResultUtil.addStringValue(memResult, ci.getComponentInstancePath()); // component path
				 *
				 * 7 ResultUtil.addRealValue(memResult, memory.getTotalBudgetMemory(), kbliteral.getName()); // in Kbytes for Memory
				 * 8 ResultUtil.addRealValue(memResult, memory.getTotalBudgetRAM(), kbliteral.getName()); // in Kbytes for RAM
				 * 9 ResultUtil.addRealValue(memResult, memory.getTotalBudgetROM(), kbliteral.getName()); // in Kbytes for ROM
				 *
				 * 10 ResultUtil.addRealValue(memResult, memory.getTotalCapacityMemory(), kbliteral.getName()); // in Kbytes for Memory
				 * 11 ResultUtil.addRealValue(memResult, memory.getTotalCapacityRAM(), kbliteral.getName()); // in Kbytes for RAM
				 * 12 ResultUtil.addRealValue(memResult, memory.getTotalCapacityROM(), kbliteral.getName()); // in Kbytes for ROM
				 */
				if (ResultUtil.getReal(subResult, 10) > 0) { // total capacity > 0
					pw.println();
					printItem(pw, "Detailed Memory Capacity Report " + ResultUtil.getString(subResult, 1));
					pw.println();
					printItems(pw, "Component", "Capacity");

					for (final Result capResult : subResult.getSubResults()) {
						if ("Memory".equalsIgnoreCase(ResultUtil.getString(capResult, 2))) {
							// print capacities
							printItems(pw,
									ResultUtil.getString(subResult, 5) + " " + ResultUtil.getString(subResult, 6),
									ResultUtil.getString(capResult, 1));
							pw.println();
						}
					}
				}
			}
		}

//			somResult.getSubResults().forEach(busResult -> generateCSVforBus(pw, busResult, null));
		pw.println(); // add a second newline, the first is from the end of generateCSVforBus()
	}
}