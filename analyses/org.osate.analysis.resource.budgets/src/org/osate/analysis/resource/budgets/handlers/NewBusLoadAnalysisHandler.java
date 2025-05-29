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
package org.osate.analysis.resource.budgets.handlers;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.analysis.resource.budgets.busload.NewBusLoadAnalysis;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;
import org.osate.ui.handlers.AbstractAnalysisHandler;

/**
 * @since 3.0
 */
public final class NewBusLoadAnalysisHandler extends AbstractAnalysisHandler {
	private static final String MARKER_TYPE = "org.osate.analysis.resource.budgets.BusLoadAnalysisMarker";
	private static final String REPORT_SUB_DIR = "BusLoad";

	public NewBusLoadAnalysisHandler() {
		super();
	}

	@Override
	protected String getSubDirName() {
		return REPORT_SUB_DIR;
	}

	@Override
	protected String getOutputFileForAaxlFile(final IFile aaxlFile, final String filename) {
		return filename + "__BusLoad.csv";
	}

	@Override
	protected Job createAnalysisJob(final IFile aaxlFile, final IFile outputFile) {
		return new BusLoadJob(aaxlFile, outputFile);
	}

	private final class BusLoadJob extends WorkspaceJob {
		private final IFile aaxlFile;
		private final IFile outputFile;

		public BusLoadJob(final IFile aaxlFile, final IFile outputFile) {
			super("Bus load analysis of " + aaxlFile.getName());
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
				final AnalysisResult analysisResult = new NewBusLoadAnalysis().invoke(subMonitor.split(1),
						(SystemInstance) AadlUtil.getElement(aaxlFile));
				if (subMonitor.isCanceled()) {
					throw new OperationCanceledException();
				}
				generateMarkers(analysisResult, errManager);
				subMonitor.worked(1);
				new ResutWriter(outputFile).writeAnalysisResults(analysisResult, subMonitor.split(1));
			} catch (final OperationCanceledException e) {
				cancelled = true;
			}

			return cancelled ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}

	}

	// === CSV Output methods ===

	private final class ResutWriter extends CSVAnalysisResultWriter {
		protected ResutWriter(final IFile outputFile) {
			super(outputFile);
		}

		@Override
		protected void generateContentforSOM(final PrintWriter pw, final Result somResult,
				final IProgressMonitor monitor) {
			/*
			 * Go through the children twice: First to print summary information and then to recursively
			 * print the sub information.
			 */

			printItems(pw, "Physical Bus", "Capacity (KB/s)", "Budget (KB/s)", "Required Budget (KB/s)",
					"Actual (KB/s)");

			for (final Result subResult : somResult.getSubResults()) {
				// Label, Capacity, Budget, Required Capacity, Actual
				printItems(pw, subResult.getMessage(), Double.toString(ResultUtil.getReal(subResult, 0)),
						Double.toString(ResultUtil.getReal(subResult, 1)),
						Double.toString(ResultUtil.getReal(subResult, 2)),
						Double.toString(ResultUtil.getReal(subResult, 3)));
			}
			pw.println();

			// NO DIAGNOSTICS AT THE SOM LEVEL

			final SubMonitor subMonitor = SubMonitor.convert(monitor, somResult.getSubResults().size());
			somResult.getSubResults()
					.forEach(busResult -> generateContentforBus(pw, busResult, null, subMonitor.split(1)));
			pw.println(); // add a second newline, the first is from the end of generateContentForBus()
		}

		private void generateContentforBus(final PrintWriter pw, final Result busResult, final Result boundTo,
				final IProgressMonitor monitor) {
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 2);

			final long dataOverhead = ResultUtil.getInteger(busResult, 7);
			if (boundTo == null) {
				printItem(pw, "Bus " + busResult.getMessage() + " has data overhead of " + dataOverhead + " bytes");
			} else {
				printItem(pw, "Virtual bus " + busResult.getMessage() + " bound to " + boundTo.getMessage()
						+ " has data overhead of " + dataOverhead + " bytes");
			}
			pw.println();

			/*
			 * Go through the children twice: First to print summary information and then to recursively
			 * print the sub information.
			 */

			printItems(pw, "Bound Virtual Bus/Connection", "Capacity (KB/s)", "Budget (KB/s)", "Required Budget (KB/s)",
					"Actual (KB/s)");

			final int numBus = (int) ResultUtil.getInteger(busResult, 4);
			final int numConnections = (int) ResultUtil.getInteger(busResult, 5);
			final List<Result> subResults = busResult.getSubResults();
			for (final Result subResult : subResults.subList(0, numBus)) {
				// Label, Capacity, Budget, Required Capacity, Actual
				printItems(pw, subResult.getMessage(), Double.toString(ResultUtil.getReal(subResult, 0)),
						Double.toString(ResultUtil.getReal(subResult, 1)),
						Double.toString(ResultUtil.getReal(subResult, 2)),
						Double.toString(ResultUtil.getReal(subResult, 3)));
			}
			for (final Result subResult : subResults.subList(numBus, subResults.size())) {
				// Label, NO CAPACITY, Budget, NO REQUIRED CAPACITY, Actual
				// Capacity, NO BUDGET, Required
				printItems(pw, subResult.getMessage(), "", Double.toString(ResultUtil.getReal(subResult, 0)), "",
						Double.toString(ResultUtil.getReal(subResult, 1)));
			}
			pw.println();

			generateContentforDiagnostics(pw, busResult.getDiagnostics(), subMonitor.split(1));
			if (!busResult.getDiagnostics().isEmpty()) {
				pw.println();
			}

			final SubMonitor loopMonitor = subMonitor.split(1).setWorkRemaining(subResults.size());
			subResults.subList(0, numBus).forEach(br -> generateContentforBus(pw, br, busResult, loopMonitor.split(1)));
			subResults.subList(numBus, numBus + numConnections)
					.forEach(br -> generateContentforConnection(pw, br, busResult, loopMonitor.split(1)));
			subResults.subList(numBus + numConnections, subResults.size())
					.forEach(br -> generateContentforBroadcast(pw, br, busResult, loopMonitor.split(1)));
		}

		private void generateContentforBroadcast(final PrintWriter pw, final Result broadcastResult,
				final Result boundTo, final IProgressMonitor monitor) {
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 2);

			printItem(pw, broadcastResult.getMessage() + " over bus " + boundTo.getMessage());
			pw.println();

			/*
			 * Go through the children twice: First to print summary information and then to recursively
			 * print the sub information.
			 */

			printItems(pw, "Included Connection", "Budget (KB/s)", "Actual (KB/s)");

			final List<Result> subResults = broadcastResult.getSubResults();
			for (final Result subResult : subResults) {
				printItems(pw, subResult.getMessage(), Double.toString(ResultUtil.getReal(subResult, 0)),
						Double.toString(ResultUtil.getReal(subResult, 1)));
			}
			pw.println();

			generateContentforDiagnostics(pw, broadcastResult.getDiagnostics(), subMonitor.split(1));
			if (!broadcastResult.getDiagnostics().isEmpty()) {
				pw.println();
			}

			final SubMonitor loopMonitor = subMonitor.split(1).setWorkRemaining(subResults.size());
			subResults.forEach(br -> generateContentforConnection(pw, br, broadcastResult, loopMonitor.split(1)));
		}

		private void generateContentforConnection(final PrintWriter pw, final Result connectionResult,
				final Result boundTo, final IProgressMonitor monitor) {
			// only do something if there are diagnostics
			final SubMonitor subMonitor = SubMonitor.convert(monitor, 1);

			if (!connectionResult.getDiagnostics().isEmpty()) {
				printItem(pw, "Connection " + connectionResult.getMessage() + " bound to " + boundTo.getMessage());
				pw.println();
				final SubMonitor loopMonitor = subMonitor.split(1)
						.setWorkRemaining(connectionResult.getDiagnostics().size());
				generateContentforDiagnostics(pw, connectionResult.getDiagnostics(), loopMonitor);
				pw.println();
			} else {
				subMonitor.setWorkRemaining(0);
			}
		}
	}
}
