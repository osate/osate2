package org.osate.analysis.resource.budgets.power;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Report.ReportType;
import org.osate.analysis.flows.reporting.model.Section;
import org.osate.analysis.resource.budgets.internal.busload.model.ConnectionEnd;
import org.osate.analysis.resource.budgets.internal.busload.model.Feature;
import org.osate.analysis.resource.budgets.internal.busload.model.PowerRequirementModel;
import org.osate.analysis.resource.budgets.internal.busload.model.Visitor;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;


public class PowerRequirementAnalysis {
	private static final String INITIAL_MODE_LABEL = "Initial Mode";
	private static final String CHOOSE_MODE_LABEL = "Choose Mode...";
	private static final String ALL_MODES_LABEL = "All Modes";

	private static final String[] ALL_MODE_CHOICE_LABELS = { INITIAL_MODE_LABEL, CHOOSE_MODE_LABEL, ALL_MODES_LABEL };

	private static final int INITIAL_MODE = 0;
	private static final int CHOOSE_MODE = 1;

	private static final int DEFAULT_MODE_CHOICE = INITIAL_MODE;

	private int lastDefaultModeChoice = DEFAULT_MODE_CHOICE;
	private Report powerReport;

	private double capacity = 0;
	private double budgetTotal = 0;
	private double supplyTotal = 0;

	public PowerRequirementAnalysis() {
		super();
	}

	public AnalysisResult invoke(final IProgressMonitor monitor, final SystemInstance systemInstance) {
		final IProgressMonitor pm = monitor == null ? new NullProgressMonitor() : monitor;
		return analyzeBody(pm, systemInstance);
	}

	private AnalysisResult analyzeBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			final SystemInstance root = ((InstanceObject) obj).getSystemInstance();

			final AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Power  Requirements", root);
			analysisResult.setResultType(ResultType.SUCCESS);
			analysisResult.setMessage("Power requirements analysis of " + root.getFullName());

			final SystemInstance si = root;
			final int whichMode;

			if (si.getSystemOperationModes().size() > 1) {
				whichMode = Dialog.askQuestion("Choose Mode",
						"Please choose in which mode(s) the model should be analyzed.", ALL_MODE_CHOICE_LABELS,
						lastDefaultModeChoice);
			} else {
				// A system with no modes still has at least one SOM named NORMAL_SOM_NAME aka "no modes"
				whichMode = INITIAL_MODE;
			}

			if (whichMode != -1) {
				lastDefaultModeChoice = whichMode;

				SystemOperationMode chosenSOM = null;
				if (!si.getSystemOperationModes().isEmpty()) {
					// the SOM list should not be empty
					if (whichMode == INITIAL_MODE) {
						// this may also be "No Modes" aka NORMAL_SOM_NAME
						chosenSOM = si.getInitialSystemOperationMode();
					} else if (whichMode == CHOOSE_MODE) {
						List<String> ar = new ArrayList<String>();
						si.getSystemOperationModes().forEach((som) -> ar.add(som.getFullName()));
						int choosen = Dialog.askQuestion("Choose Mode",
								"Please choose in which mode(s) the model should be analyzed.",
								ar.toArray(new String[ar.size()]),
								lastDefaultModeChoice);

						chosenSOM = si.getSystemOperationModes().get(choosen);

						/*
						 * final SOMChooserDialog somDialog = new SOMChooserDialog(getShell(), si, false);
						 * if (somDialog.openThreadSafe() == Window.OK) {
						 * chosenSOM = somDialog.getSOM();
						 * } else {
						 * return null;
						 * }
						 */
					}
				}

				final AnalysisErrorReporterManager errManager = new AnalysisErrorReporterManager(
						new MarkerAnalysisErrorReporter.Factory(AadlConstants.AADLOBJECTMARKER));
				if (chosenSOM != null) {
					// analyzeInstanceModelInMode(monitor, errManager, si, chosenSOM);
					final Result somResult = ResultUtil.createResult(
							Aadl2Util.isPrintableSOMName(chosenSOM) ? Aadl2Util.getPrintableSOMMembers(chosenSOM) : "",
							chosenSOM, ResultType.SUCCESS);
					analysisResult.getResults().add(somResult);

					final PowerRequirementModel model = PowerRequirementModel.buildModel(root, chosenSOM);
					// i can get totals from everything in the model

					// Analyze the model
					model.visit(new PowerRequirementAnalysisVisitor(somResult, model.getCapacity(),
							model.getTotalBudget(), model.getTotalSupply()));
				} else {
					final SOMIterator soms = new SOMIterator(si);
					while (soms.hasNext()) {
						final SystemOperationMode som = soms.nextSOM();
						// analyzeInstanceModelInMode(monitor, errManager, si, som);
						final Result somResult = ResultUtil.createResult(
								Aadl2Util.isPrintableSOMName(som) ? Aadl2Util.getPrintableSOMMembers(som) : "", som,
								ResultType.SUCCESS);
						analysisResult.getResults().add(somResult);

						final PowerRequirementModel model = PowerRequirementModel.buildModel(root, som);

						// Analyze the model
						model.visit(new PowerRequirementAnalysisVisitor(somResult, model.getCapacity(),
								model.getTotalBudget(), model.getTotalSupply()));
					}
				}
			}

			monitor.done();

			return analysisResult;
		} else {
			Dialog.showError("Power Requirements Analysis Error", "Can only check system instances");
			return null;
		}
	}

	private void analyzeInstanceModelInMode(final IProgressMonitor monitor,
			final AnalysisErrorReporterManager errManager, final SystemInstance si, final SystemOperationMode som) {
		errManager.addPrefix(Aadl2Util.getPrintableSOMName(som) + ": ");
		si.setCurrentSystemOperationMode(som);
		analyzeInstanceModel(monitor, errManager, si, som);
		si.clearCurrentSystemOperationMode();
		errManager.removePrefix();
	}

	protected void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			SystemInstance root, SystemOperationMode som) {
		monitor.beginTask("Power Analysis", 1);
//		PowerAnalysis pas = new PowerAnalysis(errManager);
		powerReport = new Report(root, "Power", "Power", ReportType.TABLE);
//		pas.analyzePowerBudget(root, powerReport, som);
		analyzePowerBudget(root, powerReport, som, errManager);
		monitor.done();
	}

	public void analyzePowerBudget(SystemInstance si, Report powerReport, SystemOperationMode som,
			AnalysisErrorReporterManager errManager) {
		final String somName = Aadl2Util.getPrintableSOMName(som);
		String systemName = si.getComponentClassifier().getName();

		final Section section = new Section(systemName + somName);
		powerReport.addSection(section);
		ForAllElement DoCapacity = new ForAllElement() {
			@Override
			protected void action(Element aobj) {
				capacity = 0.0;
				budgetTotal = 0.0;
				supplyTotal = 0.0;
				ComponentInstance ci = (ComponentInstance) aobj;
				capacity = GetProperties.getPowerCapacity(ci, 0.0);
				if (capacity == 0) {
					return;
				}
				// components that represent a power system with capacity
				powerComponentHeader(section, "Computing Electrical Power for " + ci.getName());
				String supplyLine = "";
				String budgetLine = "";
				for (FeatureInstance fi : ci.getFeatureInstances()) {
					double supply = GetProperties.getPowerBudget(fi, 0.0);
					if (supply > 0) {
						// supply in form of power budget drawn this power supply from other supply
						// this could be a requires bus access, or an incoming abstract feature
						// there must be a connection on this feature
						if (!fi.getDstConnectionInstances().isEmpty() || !fi.getSrcConnectionInstances().isEmpty()) {
							supplyLine = supplyLine + (supplyLine.isEmpty() ? "" : ", ")
									+ PowerRequirementAnalysis.toString(supply) + " from "
									+ fi.getContainingComponentInstance().getName();
							supplyTotal += supply;
						} else {
							// warning unconnected power requirement
						}
					}
					for (ConnectionInstance inconni : fi.getDstConnectionInstances()) {
						// incoming connections: does the other end provide power?
						ConnectionInstanceEnd srcfi = inconni.getSource();
						supply = GetProperties.getPowerSupply(srcfi, 0.0);
						if (supply > 0) {
							supplyLine = supplyLine + (supplyLine.isEmpty() ? "" : ", ")
									+ PowerRequirementAnalysis.toString(supply) + " from "
									+ srcfi.getContainingComponentInstance().getName();
							supplyTotal += supply;
						}
					}
					for (ConnectionInstance outconni : fi.getSrcConnectionInstances()) {
						// outgoing connection. Does the other end have a power budget?
						ConnectionInstanceEnd dstfi = outconni.getDestination();
						double budget = GetProperties.getPowerBudget(dstfi, 0.0);
						if (budget > 0) {
							budgetLine = budgetLine + (budgetLine.isEmpty() ? "" : ", ")
									+ PowerRequirementAnalysis.toString(budget) + " for "
									+ dstfi.getContainingComponentInstance().getName();
							budgetTotal += budget;
						}
					}
				}
				// power supply and budget based on access connections to this bus
				// we are checking whether there are connections with the component with power capacity as source or destination
				// this could be a bus, possibly an abstract component
				for (ConnectionInstance ac : ci.getSrcConnectionInstances()) {
					// Outgoing from Power system as bus
					FeatureInstance dstfi = (FeatureInstance) ac.getDestination();
					double budget = GetProperties.getPowerBudget(dstfi, 0.0);
					if (budget > 0) {
						budgetLine = budgetLine + (budgetLine.isEmpty() ? "" : ", ")
								+ PowerRequirementAnalysis.toString(budget) + " for "
								+ dstfi.getContainingComponentInstance().getName();
						budgetTotal += budget;
					}
					double supply = GetProperties.getPowerSupply(dstfi, 0.0);
					if (supply > 0) {
						supplyLine = supplyLine + (supplyLine.isEmpty() ? "" : ", ")
								+ PowerRequirementAnalysis.toString(supply) + " from "
								+ dstfi.getContainingComponentInstance().getName();
						supplyTotal += supply;
					}
				}
				for (ConnectionInstance ac : ci.getDstConnectionInstances()) {
					// Incoming to Power system as bus
					FeatureInstance srcfi = (FeatureInstance) ac.getSource();
					double budget = GetProperties.getPowerBudget(srcfi, 0.0);
					if (budget > 0) {
						budgetLine = budgetLine + (budgetLine.isEmpty() ? "" : ", ")
								+ PowerRequirementAnalysis.toString(budget) + " for "
								+ srcfi.getContainingComponentInstance().getName();
						budgetTotal += budget;
					}
					double supply = GetProperties.getPowerSupply(srcfi, 0.0);
					if (supply > 0) {
						supplyLine = supplyLine + (supplyLine.isEmpty() ? "" : ", ")
								+ PowerRequirementAnalysis.toString(supply) + " from "
								+ srcfi.getContainingComponentInstance().getName();
						supplyTotal += supply;
					}
				}
				report(section, ci, somName, ci.getName() + " power", capacity, budgetTotal, supplyTotal, budgetLine,
						supplyLine, errManager);
			}
		};
		DoCapacity.processPreOrderComponentInstance(si);
	}

	private void powerComponentHeader(Section s, String header) {
		Line line = new Line();
		line.addHeaderContent(header);
		s.addLine(line);
	}

	private void report(Section section, ComponentInstance ci, String somName, String resourceName, double capacity,
			double budget, double supply, String budgetDetail, String supplyDetails,
			AnalysisErrorReporterManager errManager) {
		powerComponentInfo(section, "Capacity: " + toString(capacity), "");
		powerComponentInfo(section, "Supply: " + toString(supply), supplyDetails);
		powerComponentInfo(section, "Budget: " + toString(budget), budgetDetail);
		if (capacity > 0.0 && budget > 0.0) {
			if (budget > capacity) {
				String message = "** " + resourceName + " budget total " + toString(budget) + " exceeds capacity "
						+ toString(capacity);
				errManager.error(ci, somName + ": " + message);
				powerComponentError(section, message);
			} else {
				String message = resourceName + " budget total " + toString(budget) + " within capacity "
						+ toString(capacity);
				errManager.info(ci, somName + ": " + message);
				powerComponentSuccess(section, message);
			}
		}
		String suppliedmsg = "";
		double available = 0.0;
		if (supply == 0.0) {
			available = capacity;
			suppliedmsg = " capacity ";
		} else {
			available = supply;
			suppliedmsg = " supply ";
		}

		if (budget > available) {
			String message = "** " + "budget total " + toString(budget) + " exceeds" + suppliedmsg
					+ toString(available);
			powerComponentError(section, message);
			errManager.error(ci, somName + ": " + message);
		} else {
			String message = "budget total " + toString(budget) + " within" + suppliedmsg + toString(available);
			errManager.info(ci, somName + ": " + message);
			powerComponentSuccess(section, message);
		}
		Line l = new Line();
		l.addContent("");
		section.addLine(l);
	}

	private void powerComponentInfo(Section s, String header, String optional) {
		Line line = new Line();
		line.addHeaderContent(header);
		if (!optional.isEmpty()) {
			line.addContent(optional);
		}
		s.addLine(line);
	}

	private void powerComponentSuccess(Section s, String msg) {
		Line line = new Line();
		line.addInfo(msg);
		s.addLine(line);
	}

	private void powerComponentError(Section s, String msg) {
		Line line = new Line();
		line.addError(msg);
		s.addLine(line);
	}

	// ==== Analysis Visitor ====

	private class PowerRequirementAnalysisVisitor implements Visitor {
		private Deque<Result> previousResult = new LinkedList<>();
		private Result currentResult;

		private final double capacity, tBudget, tSupply;

		public PowerRequirementAnalysisVisitor(final Result rootResult, double capacity, double budget, double supply) {
			this.currentResult = rootResult;
			this.capacity = capacity;
			this.tBudget = budget;
			this.tSupply = supply;
		}

		@Override
		public void visitConnectionEndPrefix(final ConnectionEnd connEnd) {
			final ConnectionInstanceEnd connInstanceEnd = connEnd.getConnectionInstanceEnd();

			// Create a new result object for the connection end
			final Result connEndResult = ResultUtil.createResult(connInstanceEnd.getName(), connInstanceEnd,
					ResultType.SUCCESS);
			currentResult.getSubResults().add(connEndResult);
			previousResult.push(currentResult);
			currentResult = connEndResult;
		}

		@Override
		public void visitConnectionEndPostfix(final ConnectionEnd connEnd) {
			// unroll the result stack
			final Result connEndResult = currentResult;
			currentResult = previousResult.pop();

			double budget = connEnd.getBudget();
			double supply = connEnd.getSupply();

			ResultUtil.addRealValue(connEndResult, budget);
			ResultUtil.addRealValue(connEndResult, supply);

			ResultUtil.addStringValue(connEndResult,
					"Budget " + PowerRequirementAnalysis.toString(budget) + " for "
							+ connEnd.getConnectionInstanceEnd().getName() + " out of total "
							+ PowerRequirementAnalysis.toString(tBudget));

			ResultUtil.addStringValue(connEndResult,
					"Supply " + PowerRequirementAnalysis.toString(supply) + " from "
							+ connEnd.getConnectionInstanceEnd().getName() + " out of total "
							+ PowerRequirementAnalysis.toString(tSupply));

			ResultUtil.addStringValue(connEndResult, "Total capacity " + PowerRequirementAnalysis.toString(capacity));
		}

		@Override
		public void visitFeaturePrefix(final Feature feature) {
			final FeatureInstance featureInstance = feature.getFeatureInstance();

			// Create a new result object for the connection end
			final Result featureResult = ResultUtil.createResult(featureInstance.getName(), featureInstance,
					ResultType.SUCCESS);
			currentResult.getSubResults().add(featureResult);
			previousResult.push(currentResult);
			currentResult = featureResult;
		}

		@Override
		public void visitFeaturePostfix(final Feature feature) {
			// unroll the result stack
			final Result connEndResult = currentResult;
			currentResult = previousResult.pop();

			double budget = feature.getBudget();
			double supply = feature.getSupply();

			ResultUtil.addRealValue(connEndResult, budget);
			ResultUtil.addRealValue(connEndResult, supply);

			ResultUtil.addStringValue(connEndResult,
					"Budget " + PowerRequirementAnalysis.toString(budget) + " for "
							+ feature.getFeatureInstance().getName() + " out of total "
							+ PowerRequirementAnalysis.toString(budgetTotal));

			ResultUtil.addStringValue(connEndResult,
					"Supply " + PowerRequirementAnalysis.toString(supply) + " from "
							+ feature.getFeatureInstance().getName() + " out of total "
							+ PowerRequirementAnalysis.toString(supplyTotal));

			ResultUtil.addStringValue(connEndResult, "Total capacity " + PowerRequirementAnalysis.toString(capacity));
		}

	}

	private static String toString(double value) {
		return value > 2000.0 ? value / 1000 + " W" : value + " mW";
	}
}