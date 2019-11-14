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