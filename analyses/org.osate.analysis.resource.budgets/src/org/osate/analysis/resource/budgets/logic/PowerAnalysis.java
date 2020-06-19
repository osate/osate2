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

/**
 * @since 2.0
 */
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
}