/*
 * <copyright>
 * Copyright  2006 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.analysis.resource.budgets.logic;

import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.Report;
import org.osate.analysis.flows.reporting.model.Section;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class PowerAnalysis {

	private final AnalysisErrorReporterManager errManager;

	private double capacity = 0;
	private double budgetTotal = 0;
	private double supplyTotal = 0;

	public PowerAnalysis(AnalysisErrorReporterManager errManager) {
		this.errManager = errManager;
	}

	public void analyzePowerBudget(SystemInstance si, Report powerReport, SystemOperationMode som) {
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
									+ PowerAnalysis.this.toString(supply) + " from "
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
									+ PowerAnalysis.this.toString(supply) + " from "
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
									+ PowerAnalysis.this.toString(budget) + " for "
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
								+ PowerAnalysis.this.toString(budget) + " for "
								+ dstfi.getContainingComponentInstance().getName();
						budgetTotal += budget;
					}
					double supply = GetProperties.getPowerSupply(dstfi, 0.0);
					if (supply > 0) {
						supplyLine = supplyLine + (supplyLine.isEmpty() ? "" : ", ")
								+ PowerAnalysis.this.toString(supply) + " from "
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
								+ PowerAnalysis.this.toString(budget) + " for "
								+ srcfi.getContainingComponentInstance().getName();
						budgetTotal += budget;
					}
					double supply = GetProperties.getPowerSupply(srcfi, 0.0);
					if (supply > 0) {
						supplyLine = supplyLine + (supplyLine.isEmpty() ? "" : ", ")
								+ PowerAnalysis.this.toString(supply) + " from "
								+ srcfi.getContainingComponentInstance().getName();
						supplyTotal += supply;
					}
				}
				report(section, ci, somName, ci.getName() + " power", capacity, budgetTotal, supplyTotal, budgetLine,
						supplyLine);
			}
		};
		DoCapacity.processPreOrderComponentInstance(si);
	}

	private void powerComponentHeader(Section s, String header) {
		Line line = new Line();
		line.addHeaderContent(header);
		s.addLine(line);
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

	private String toString(double value) {
		return value > 2000.0 ? value / 1000 + " W" : value + " mW";
	}

	private void report(Section section, ComponentInstance ci, String somName, String resourceName, double capacity,
			double budget, double supply, String budgetDetail, String supplyDetails) {
		powerComponentInfo(section, "Capacity: " + toString(capacity), "");
		powerComponentInfo(section, "Supply: " + toString(supply), supplyDetails);
		powerComponentInfo(section, "Budget: " + toString(budget), budgetDetail);
		String modelExceeds = "";
		String modelStats = "";
		if (capacity > 0.0 && budget > 0.0) {
			if (budget > capacity) {
				modelExceeds = "** " + resourceName + " budget total " + toString(budget) + " exceeds capacity "
						+ toString(capacity);
				errManager.error(ci, somName + ": " + modelExceeds);
				powerComponentError(section, modelExceeds);
			} else {
				modelExceeds = resourceName + " budget total " + toString(budget) + " within capacity "
						+ toString(capacity);
				errManager.info(ci, somName + ": " + modelStats);
				powerComponentSuccess(section, modelStats);
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
			modelStats = "** " + "budget total " + toString(budget) + " exceeds" + suppliedmsg + toString(available);
			powerComponentError(section, modelStats);
			errManager.error(ci, somName + ": " + modelStats);
		} else {
			modelStats = "budget total " + toString(budget) + " within" + suppliedmsg + toString(available);
			errManager.info(ci, somName + ": " + modelStats);
			powerComponentSuccess(section, modelStats);
		}
		Line l = new Line();
		l.addContent("");
		section.addLine(l);
	}
}