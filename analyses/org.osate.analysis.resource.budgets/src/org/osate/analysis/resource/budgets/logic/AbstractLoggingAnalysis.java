/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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

import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;

abstract class AbstractLoggingAnalysis {
	private final boolean doDetailedLog = true;
	
	protected final AbstractAaxlHandler errManager;
	
	protected AbstractLoggingAnalysis(AbstractAaxlHandler handler) {
		errManager = handler;
	}
	
	protected void logHeader(String msg) {
		errManager.logInfo(msg);
	}
	
	protected void detailedLog(InstanceObject obj, double budget, double actual, String msg) {
		if (doDetailedLog) {
			String budgetmsg = budget + " " + AadlProject.KBYTESPS_LITERAL + ",";
			String actualmsg = actual + " " + AadlProject.KBYTESPS_LITERAL + ",";
			String objname = (obj instanceof ConnectionInstance) ? obj.getFullName()
					: ((ComponentInstance) obj).getComponentInstancePath();
			errManager.logInfo(objname + ", " + budgetmsg + actualmsg + msg);
		}
	}
	
	protected void detailedLog(String prefix, ComponentInstance ci, double budget, double actual, String resourceName,
			UnitLiteral unit, String msg) {
		if (doDetailedLog) {
			String budgetmsg = prefix + GetProperties.toStringScaled(budget, unit) + ",";
			String actualmsg = prefix + GetProperties.toStringScaled(actual, unit) + ",";
			errManager.logInfo(prefix + ci.getCategory().getName() + " " + ci.getComponentInstancePath() + ", "
					+ budgetmsg + actualmsg + msg);
		}
	}
	
	protected void detailedLogTotal1(ComponentInstance ci, double budget, UnitLiteral unit) {
		if (doDetailedLog) {
			String budgetmsg = GetProperties.toStringScaled(budget, unit) + ",";
			String front = ci == null ? "Total" : ci.getCategory().getName() + " " + ci.getComponentInstancePath();
			errManager.logInfo(front + ", " + budgetmsg);
		}
	}
	
	protected void detailedLogTotal2(ComponentInstance ci, double budget, UnitLiteral unit) {
		if (doDetailedLog) {
			String budgetmsg = String.format("%.3f " + unit.getName() + ",", budget);// GetProperties.toStringScaled(budget, unit) + ",";
			String front = ci == null ? "Total" : ci.getCategory().getName() + " " + ci.getComponentInstancePath();
			errManager.logInfo(front + ", ," + budgetmsg);
		}
	}
}