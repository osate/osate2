/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.verify.analysisplugins;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.architecture.handlers.CheckA429PortConnectionConsistency;
import org.osate.analysis.architecture.handlers.CheckConnectionBindingConsistency;
import org.osate.analysis.architecture.handlers.DoPortConnectionConsistency;
import org.osate.analysis.architecture.handlers.DoPropertyTotals;
import org.osate.analysis.resource.budgets.handlers.BoundResourceAnalysisHandler;
import org.osate.analysis.resource.budgets.handlers.BusLoadAnalysisHandler;
import org.osate.analysis.resource.budgets.handlers.NotBoundResourceAnalysisHandler;
import org.osate.analysis.resource.budgets.handlers.PowerAnalysisHandler;
import org.osate.verify.internal.util.VerifyUtilExtension;

public class AnalysisPluginInterface {
	// Architecture analyses.
	public static String A429Consistency(final InstanceObject ci) {
		var checker = new CheckA429PortConnectionConsistency();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}

	public static String ConnectionBindingConsistency(final InstanceObject ci) {
		var checker = new CheckConnectionBindingConsistency();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}

	public static String PortDataConsistency(final InstanceObject ci) {
		var checker = new DoPortConnectionConsistency();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}

	public static String MassAnalysis(final InstanceObject ci) {
		var checker = new DoPropertyTotals();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}

	public static String BoundResourceAnalysis(final InstanceObject ci) {
		var checker = new BoundResourceAnalysisHandler();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}

	public static String NetworkBandWidthAnalysis(final InstanceObject ci) {
		var checker = new BusLoadAnalysisHandler();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}

	public static String PowerAnalysis(final InstanceObject ci) {
		var checker = new PowerAnalysisHandler();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}

	public static String ResourceBudget(final InstanceObject ci) {
		var checker = new NotBoundResourceAnalysisHandler();
		var markerType = checker.getMarkerType();
		var instance = (SystemInstance) ci.getElementRoot();
		if (!VerifyUtilExtension.getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor(), instance);
				VerifyUtilExtension.setHasRun(markerType, instance);
			} catch (Throwable exception) {
				VerifyUtilExtension.unsetHasRun(markerType, instance);
			}
		}
		return markerType;
	}
}
