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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.OsateLogger;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class DoPowerAnalysisLogic {
	private static final String resourceCategory = "Power";

	private final AnalysisErrorReporterManager errManager;

	private StringBuffer msg = new StringBuffer();
	private double capacity = 0;
	private double budgetTotal = 0;
	private double supplyTotal = 0;
	private int hasPower = 0;
	private EList done;

	public DoPowerAnalysisLogic(AnalysisErrorReporterManager errManager) {
		this.errManager = errManager;
	}

	public void analyzePowerBudget(SystemInstance si) {
		hasPower = 0;
		final SOMIterator soms = new SOMIterator(si);
		while (soms.hasNext()) {
			final SystemOperationMode som = soms.nextSOM();
			final String somName = Aadl2Util.getPrintableSOMName(som);
			msg = new StringBuffer();
			ForAllElement DoCapacity = new ForAllElement() {
				@Override
				protected void action(Element aobj) {
					capacity = 0.0;
					budgetTotal = 0.0;
					supplyTotal = 0.0;
					done = new UniqueEList<Element>();
					ComponentInstance ci = (ComponentInstance) aobj;
					capacity = GetProperties.getPowerCapacity(ci, 0.0);
					if (capacity > 0) {
						OsateLogger.log(somName + "Computing Power for " + ci.getName());
					} else {
						return;
					}
					// supply in form of power budget drawn this power supply from other supply
					for (FeatureInstance fi : ci.getFeatureInstances()) {
						double supply = GetProperties.getPowerBudget(fi, 0.0);
						if (supply > 0) {
							if (!fi.getDstConnectionInstances().isEmpty() || !fi.getSrcConnectionInstances().isEmpty()) {
								OsateLogger.log(somName + "  Supply " + supply + " from "
										+ fi.getContainingComponentInstance().getName());
								supplyTotal += supply;
							} else {
								// warning unconnected power requirement
							}
						}
					}
					// power supply and budget based on access connections to this bus
					for (ConnectionInstance ac : ci.getSrcConnectionInstances()) {
						// TODO-LW: could throw ClassCastException
						FeatureInstance dstfi = (FeatureInstance) ac.getDestination();
						double res = GetProperties.getPowerBudget(dstfi, 0.0);
						if (res > 0) {
							OsateLogger.log(somName + "  Budget " + res + " by Component "
									+ dstfi.getContainingComponentInstance().getName());
							budgetTotal += res;
						}
						res = GetProperties.getPowerSupply(dstfi, 0.0);
						if (res > 0) {
							OsateLogger.log(somName + "  Supply " + res + " from Component "
									+ dstfi.getContainingComponentInstance().getName());
							supplyTotal += res;
						}
					}
					for (ConnectionInstance ac : ci.getDstConnectionInstances()) {
						// TODO-LW: could throw ClassCastException
						FeatureInstance dstfi = (FeatureInstance) ac.getSource();
						double res = GetProperties.getPowerBudget(dstfi, 0.0);
						if (res > 0) {
							OsateLogger.log(somName + "  Budget " + res + " by Component "
									+ dstfi.getContainingComponentInstance().getName());
							budgetTotal += res;
						}
						res = GetProperties.getPowerSupply(dstfi, 0.0);
						if (res > 0) {
							OsateLogger.log(somName + "  Supply " + res + " from Component "
									+ dstfi.getContainingComponentInstance().getName());
							supplyTotal += res;
						}
					}
					report(ci, somName, ci.getName() + " " + resourceCategory, capacity, budgetTotal, supplyTotal);
				}
			};
			DoCapacity.processPreOrderComponentInstance(si);
		}
		if (si.getSystemOperationModes().size() == 1 && msg.length() > 0) {
			// Also report the results using a message dialog
			Dialog.showInfo(resourceCategory + " Budget Statistics", msg.toString());
		} else if (hasPower == 0) {
			Dialog.showInfo(resourceCategory + " Budget Statistics", "No components with power.");
		}
	}

	private String toString(double value) {
		return value > 2000.0 ? value / 1000 + " W" : value + " mW";
	}

	private void report(ComponentInstance ci, String somName, String resourceName, double capacity, double budget,
			double supply) {
		String modelExceeds = "";
		String modelStats = "";
		if (capacity == 0.0 && supply == 0.0 && budget == 0.0) {
			return;
		}
		hasPower++;
		if (capacity > 0.0 && supply > 0.0) {
			if (supply > capacity) {
				modelExceeds = "** " + resourceName + " supply " + toString(supply) + " exceeds capacity "
						+ toString(capacity);
				errManager.error(ci, somName + modelExceeds);
			}
		}
		String suppliedmsg = "";
		double available = 0.0;
		if (supply == 0.0) {
			available = capacity;
		} else {
			available = supply;
			suppliedmsg = " supply ";
		}
		String resourcemsg = resourceName + ((budget > available) ? " overage:" : "");

		if (available > 2000.0 && budget > 2000.0) {
			modelStats = resourcemsg + (suppliedmsg.length() > 0 ? suppliedmsg : " capacity ") + available / 1000
					+ " W vs. budget total " + budget / 1000 + " W";
		} else {
			modelStats = resourcemsg + (suppliedmsg.length() > 0 ? suppliedmsg : " capacity ") + available
					+ " mW vs. budget total " + budget + " mW";
		}
		if (budget > available) {
			errManager.error(ci, somName + modelStats);
		} else {
			errManager.info(ci, somName + modelStats);
		}
		msg.append(modelStats + (modelExceeds.length() > 0 ? "\n***" + modelExceeds : "") + "\n");
	}
}