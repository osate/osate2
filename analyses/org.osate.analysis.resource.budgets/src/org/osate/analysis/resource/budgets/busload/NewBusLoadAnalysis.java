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
package org.osate.analysis.resource.budgets.busload;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.resource.budgets.busload.model.Bus;
import org.osate.analysis.resource.budgets.busload.model.BusLoadModel;
import org.osate.analysis.resource.budgets.busload.model.BusLoadModel.PrintVisitor;
import org.osate.analysis.resource.budgets.busload.model.BusOrVirtualBus;
import org.osate.analysis.resource.budgets.busload.model.Connection;
import org.osate.analysis.resource.budgets.busload.model.Visitor;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.DiagnosticType;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public final class NewBusLoadAnalysis {
	private static final String MARKER_TYPE = "org.osate.analysis.resource.budgets.BusLoadAnalysisMarker";

	private final AnalysisErrorReporterManager errManager;
	private final String actionName;

	public NewBusLoadAnalysis(final String actionName) {
		this.errManager = new AnalysisErrorReporterManager(new MarkerAnalysisErrorReporter.Factory(MARKER_TYPE));
		this.actionName = actionName;
	}

	public AnalysisResult analysisBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			final PrintWriter pw = new PrintWriter(System.out, true);
			monitor.beginTask(actionName, IProgressMonitor.UNKNOWN);

			final SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			final AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Bus  Load", root);
			analysisResult.setResultType(ResultType.SUCCESS);
			analysisResult.setMessage("Bus load analysis of " + root.getFullName());

			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();
				final Result somResult = ResultUtil.createResult(
						"Analysis of system operation mode " + som.toString(), som, ResultType.SUCCESS);
				analysisResult.getResults().add(somResult);
				final BusLoadModel model = BusLoadModel.buildModel(root, som);

				// Analyze the model
				model.visit(new BusLoadAnalysisVisitor(somResult));

				pw.println("Model for system operation mode " + som);
				pw.println();
				final PrintVisitor pv = new PrintVisitor() {
					@Override
					public void visitBusOrVirtualBusPrefix(final BusOrVirtualBus b) {
						println("Capacity = " + b.getCapacity() + " KB/s");
						println("Budget = " + b.getBudget() + " KB/s");
						println("Required budget = " + b.getTotalBudget() + " KB/s");
						println("Actual usage = " + b.getActual() + " KB/s");
					}

					@Override
					public void visitConnection(final Connection c) {
						println("Budget = " + c.getBudget() + " KB/s");
						println("Actual usage = " + c.getActual() + " KB/s");
					}
				};
				model.print(pw, pv);
				pw.println();
				pw.println("===============================================");
				pw.println();
			}
			monitor.done();

			// TODO: Move this later
			generateMarkers(analysisResult, errManager);
			// TODO: Deal with progress monitor
			writeCSVFile(analysisResult, null);

			return analysisResult;
		} else {
			Dialog.showError("Bound Bus Bandwidth Analysis Error", "Can only check system instances");
			return null;
		}

	}

	// ==== Analysis Visitor ====

	private class BusLoadAnalysisVisitor implements Visitor {
		private Deque<Result> previousResult = new LinkedList<>();
		private Result currentResult;

		private Deque<Double> previousOverhead = new LinkedList<>();
		private double dataOverheadKBytesps = 0.0;

		public BusLoadAnalysisVisitor(final Result rootResult) {
			this.currentResult = rootResult;
		}

		@Override
		public void visitBusOrVirtualBusPrefix(final BusOrVirtualBus bus) {
			final ComponentInstance busInstance = bus.getBusInstance();

			// Create a new result object for the bus
			final Result busResult = ResultUtil.createResult(busInstance.getName(), busInstance,
					ResultType.SUCCESS);
			currentResult.getSubResults().add(busResult);
			previousResult.push(currentResult);
			currentResult = busResult;

			// Increment the data overhead
			final double newOverheadKBytesps = GetProperties.getDataSize(busInstance,
					GetProperties.getKBUnitLiteral(busInstance));
			previousOverhead.push(dataOverheadKBytesps);
			dataOverheadKBytesps += newOverheadKBytesps;
		}

		@Override
		public void visitBusOrVirtualBusPostfix(final BusOrVirtualBus bus) {
			// unroll the result stack
			final Result busResult = currentResult;
			currentResult = previousResult.pop();

			// Unroll the overhead calculation
			dataOverheadKBytesps = previousOverhead.pop();

			// Compute the actual usage and budget requirements
			double actual = 0.0;
			double totalBudget = 0.0;

			for (final BusOrVirtualBus b : bus.getBoundBuses()) {
				actual += b.getActual();
				totalBudget += b.getBudget();
			}
			for (final Connection c : bus.getBoundConnections()) {
				actual += c.getActual();
				totalBudget += c.getBudget();
			}
			bus.setActual(actual);
			bus.setTotalBudget(totalBudget);

			final ComponentInstance busInstance = bus.getBusInstance();
			final double capacity = GetProperties.getBandWidthCapacityInKBytesps(busInstance, 0.0);
			final double budget = GetProperties.getBandWidthBudgetInKBytesps(busInstance, 0.0);
			bus.setCapacity(capacity);
			bus.setBudget(budget);

			ResultUtil.addRealValue(busResult, capacity);
			ResultUtil.addRealValue(busResult, budget);
			ResultUtil.addRealValue(busResult, totalBudget);
			ResultUtil.addRealValue(busResult, actual);
			ResultUtil.addIntegerValue(busResult, bus.getBoundBuses().size());
			ResultUtil.addIntegerValue(busResult, bus.getBoundConnections().size());

			if (capacity == 0.0) {
				warning(busResult, busInstance, (bus instanceof Bus ? "Bus " : "Virtual bus ") +
						busInstance.getName() + " has no capacity");
			} else {
				if (actual > capacity) {
					error(busResult, busInstance,
							(bus instanceof Bus ? "Bus " : "Virtual bus ") + busInstance.getName()
							+ " -- Actual bandwidth > capacity: " + actual + " KB/s > "
							+ capacity + " KB/s");
				}
			}

			if (budget == 0.0) {
				warning(busResult, busInstance, (bus instanceof Bus ? "Bus " : "Virtual bus ") +
						busInstance.getName() + " has no bandwidth budget");
			} else {
				if (budget > capacity) {
					error(busResult, busInstance,
							(bus instanceof Bus ? "Bus " : "Virtual bus ") + busInstance.getName()
									+ " -- budget > capacity: " + budget + " KB/s > " + capacity + " KB/s");
				}
				if (totalBudget > budget) {
					error(busResult, busInstance,
							(bus instanceof Bus ? "Bus " : "Virtual bus ") + busInstance.getName()
							+ " -- Required budget > budget: " + totalBudget + " KB/s > " + budget
							+ " KB/s");
				}
			}
		}

		@Override
		public void visitConnection(final Connection connection) {
			final ConnectionInstance connectionInstance = connection.getConnectionInstance();
			final Result connectionResult = ResultUtil.createResult(connectionInstance.getName(),
					connectionInstance, ResultType.SUCCESS);
			currentResult.getSubResults().add(connectionResult);

			final double actual = getConnectionActualKBytesps(connectionInstance, dataOverheadKBytesps);
			connection.setActual(actual);

			final double budget = GetProperties.getBandWidthBudgetInKBytesps(connectionInstance, 0.0);
			connection.setBudget(budget);

			ResultUtil.addRealValue(connectionResult, budget);
			ResultUtil.addRealValue(connectionResult, actual);

			if (budget > 0.0) {
				if (actual > budget) {
					error(connectionResult, connectionInstance,
							"Connection " + connectionInstance.getName() + " -- Actual bandwidth > budget: " + actual
									+ " KB/s > "
							+ budget + " KB/s");
				}
			} else {
				warning(connectionResult, connectionInstance,
						"Connection " + connectionInstance.getName() + " has no bandwidth budget");
			}
		}
	}

	// ==== Helper methods for the visitor ===

	/**
	 * Calculate bandwidth demand from rate & data size
	 * @param ci The connection instance to calculate for
	 * @param dataOverheadKBytesps The current data overhead from bound buses expressed in KB/s.  This is applied to
	 * the connections message size.
	 */
	private static double getConnectionActualKBytesps(final ConnectionInstance ci, final double dataOverheadKBytesps) {
		double actualDataRate = 0;
		final ConnectionInstanceEnd cie = ci.getSource();
		if (cie instanceof FeatureInstance) {
			final FeatureInstance fi = (FeatureInstance) cie;
			final double datasize = dataOverheadKBytesps
					+ GetProperties.getSourceDataSize(fi, GetProperties.getKBUnitLiteral(fi));
			final double srcRate = GetProperties.getOutgoingMessageRatePerSecond(fi);
			actualDataRate = datasize * srcRate;
		}
		return actualDataRate;
	}

	// ==== Error reporting methods for the visitor ===

	private static void error(final Result result, final InstanceObject io, final String msg) {
		result.getDiagnostics().add(ResultUtil.createDiagnostic(msg, io, DiagnosticType.ERROR));
		System.out.println("ERROR: " + msg);
	}

	private static void warning(final Result result, final InstanceObject io, final String msg) {
		result.getDiagnostics().add(ResultUtil.createDiagnostic(msg, io, DiagnosticType.WARNING));
		System.out.println("WARNING: " + msg);
	}

	// TODO: Move this somewhere else
	private static void generateMarkers(final AnalysisResult analysisResult,
			final AnalysisErrorReporterManager errManager) {
		// Handle each SOM
		analysisResult.getResults().forEach(r -> {
			String somPostfix = Aadl2Util.isNoModes((SystemOperationMode) r.getModelElement()) ? ""
					: (" in modes " + r.getMessage());
			generateMarkersForSOM(r, errManager, somPostfix);
		});
	}

	// TODO: Move this somewhere else
	private static void generateMarkersForSOM(final Result result, final AnalysisErrorReporterManager errManager,
			final String somPostfix) {
		generateMarkersFromDiagnostics(result.getDiagnostics(), errManager, somPostfix);
		result.getSubResults().forEach(r -> generateMarkersForSOM(r, errManager, somPostfix));
	}

	// TODO: Move this somewhere else
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

	// TODO: Move this somewhere else
	private static void writeCSVFile(final AnalysisResult analysisResult, final IProgressMonitor monitor) {
		/* Get the location of the instance model file and build the path to the result file. */
		IPath path = OsateResourceUtil.toIFile(analysisResult.getModelElement().eResource().getURI()).getFullPath()
				.removeFileExtension();
		final String filename = path.lastSegment();
		path = path.removeLastSegments(1).append("/reports/BusLoad/" + filename + ".csv");
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

		final String csvContent = getCSVasString(analysisResult);
		final InputStream inputStream = new ByteArrayInputStream(csvContent.getBytes());

		if (file != null) {
			try {
				if (file.exists()) {
					file.setContents(inputStream, true, true, monitor);
				} else {
					AadlUtil.makeSureFoldersExist(path);
					file.create(inputStream, true, monitor);
				}
			} catch (final CoreException e) {
				Activator.logThrowable(e);
			}
		}
	}

	// TODO: Move this somewhere else
	private static String getCSVasString(final AnalysisResult analysisResult) {
		final StringWriter writer = new StringWriter();
		final PrintWriter pw = new PrintWriter(writer);
		generateCSVforAnalysis(pw, analysisResult);
		pw.close();
		return writer.toString();
	}

	// TODO: Move this somewhere else
	private static void generateCSVforAnalysis(final PrintWriter pw, final AnalysisResult analysisResult) {
		pw.println(analysisResult.getMessage());
		pw.println();
		pw.println();
		analysisResult.getResults().forEach(somResult -> generateCSVforSOM(pw, somResult));
	}

	// TODO: Move this somewhere else
	private static void generateCSVforSOM(final PrintWriter pw, final Result somResult) {
		if (!Aadl2Util.isNoModes((SystemOperationMode) somResult.getModelElement())) {
			pw.println(somResult.getMessage());
			pw.println();
		}
		somResult.getSubResults().forEach(busResult -> generateCSVforBus(pw, busResult, null));
		pw.println(); // add a second newline, the first is from the end of generateCSVforBus()
	}

	// TODO: Move this somewhere else
	private static void generateCSVforBus(final PrintWriter pw, final Result busResult, final Result boundTo) {
		if (boundTo == null) {
			pw.print("Bus ");
			pw.println(busResult.getMessage());
		} else {
			pw.print("Virtual bus ");
			pw.print(busResult.getMessage());
			pw.print(" bound to ");
			pw.println(boundTo.getMessage());
		}

		/*
		 * Go through the children twice: First to print summary information and then to recursively
		 * print the sub information.
		 */

		pw.println(
				"Bound Virtual Bus/Connection, Capacity (KB/s), Budget (KB/s), Required Budget (KB/s), Actual (KB/s)");

		final int numBus = (int) ResultUtil.getInteger(busResult, 4);
		final List<Result> subResults = busResult.getSubResults();
		for (final Result subResult : subResults.subList(0, numBus)) {
			pw.print(subResult.getMessage());
			pw.print(", ");
			pw.print(ResultUtil.getReal(subResult, 0)); // Capacity
			pw.print(", ");
			pw.print(ResultUtil.getReal(subResult, 1)); // Budget
			pw.print(", ");
			pw.print(ResultUtil.getReal(subResult, 2)); // Required Capacity
			pw.print(", ");
			pw.print(ResultUtil.getReal(subResult, 3)); // Actual
			pw.println();
		}
		for (final Result subResult : subResults.subList(numBus, subResults.size())) {
			pw.print(subResult.getMessage());
			pw.print(", ");
			// NO CAPACITY
			pw.print(", ");
			pw.print(ResultUtil.getReal(subResult, 0)); // Budget
			pw.print(", ");
			// NO REQUIRED CAPACITY
			pw.print(", ");
			pw.print(ResultUtil.getReal(subResult, 1)); // Actual
			pw.println();
		}
		pw.println();

		subResults.subList(0, numBus).forEach(br -> generateCSVforBus(pw, br, busResult));
	}
}
