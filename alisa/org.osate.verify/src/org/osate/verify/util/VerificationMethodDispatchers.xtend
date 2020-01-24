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

package org.osate.verify.util

import java.util.List
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.PluginMethod

import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*

class VerificationMethodDispatchers {

	public static val eInstance = new VerificationMethodDispatchers

	/**
	 * this method calls the appropriate plugin method.
	 * If the target is null it just returns true.
	 * If the methodID does not match it returns null
	 * If the method is successful it returns the Eclipse Marker type as string
	 */
	def Object dispatchVerificationMethod(PluginMethod vm, InstanceObject target, List<PropertyExpression> parameters) {
		switch (vm.methodID) {
			case "A429Consistency":
				if(target === null) true else target.A429Consistency
			case "ConnectionBindingConsistency":
				if(target === null) true else target.ConnectionBindingConsistency
			case "PortDataConsistency":
				if(target === null) true else target.PortDataConsistency
			case "MassAnalysis":
				if(target === null) true else target.MassAnalysis
			case "BoundResourceAnalysis":
				if(target === null) true else target.BoundResourceAnalysis
			case "NetworkBandwidthAnalysis":
				if(target === null) true else target.NetworkBandWidthAnalysis
			case "PowerAnalysis":
				if(target === null) true else target.PowerAnalysis
			case "ResourceBudgets":
				if(target === null) true else target.ResourceBudget
			case "BinPack":
				if(target === null) true else target.Binpack
			default:
				null
		}
	}

}
