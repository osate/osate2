/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */

package org.osate.verify.util

import java.lang.reflect.Method
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.common.util.EList
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.BooleanLiteral
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instance.EndToEndFlowInstance
import org.osate.aadl2.instance.FeatureInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.InstancePackage
import org.osate.aadl2.instance.ModeInstance
import org.osate.alisa.common.util.ExecuteJavaUtil
import org.osate.verify.verify.FormalParameter
import org.osate.verify.verify.JavaMethod
import org.osate.verify.verify.JavaParameter
import org.osate.verify.verify.PluginMethod
import org.osate.verify.verify.VerificationMethod

import static extension org.osate.verify.analysisplugins.AnalysisPluginInterface.*
import org.osate.alisa.common.common.TargetType

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
			case "FlowLatencyAnalysis",
			case "FlowLatencyAnalysisParameterized",
			case "MaxFlowLatencyAnalysis",
			case "MinFlowLatencyAnalysis",
			case "FlowLatencyJitterAnalysis":
				if(target === null) true else target.flowLatencyAnalysis(parameters.map[p|(p as BooleanLiteral).isValue])
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
			case "CheckSafety":
				if(target === null) true else target.CheckSafety
			case "CheckSecurity":
				if(target === null) true else target.CheckSecurity
			default:
				null
		}
	}

}
