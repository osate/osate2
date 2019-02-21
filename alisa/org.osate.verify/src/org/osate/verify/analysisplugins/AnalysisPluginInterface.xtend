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

package org.osate.verify.analysisplugins

import org.eclipse.core.runtime.NullProgressMonitor
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.analysis.architecture.handlers.CheckA429PortConnectionConsistency
import org.osate.analysis.architecture.handlers.CheckConnectionBindingConsistency
import org.osate.analysis.architecture.handlers.DoPortConnectionConsistency
import org.osate.analysis.architecture.handlers.DoPropertyTotals
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch
import org.osate.analysis.resource.budgets.handlers.DoBoundResourceAnalysis
import org.osate.analysis.resource.budgets.handlers.DoBoundSwitchBandWidthAnalysis
import org.osate.analysis.resource.budgets.handlers.DoPowerAnalysis
import org.osate.analysis.resource.budgets.handlers.DoResourceBudget
import org.osate.analysis.resource.management.handlers.Binpack
import org.osate.result.AnalysisResult

import static org.osate.verify.util.VerifyUtilExtension.*

class AnalysisPluginInterface {

	def static AnalysisResult flowLatencyAnalysis(InstanceObject etefi, boolean[] prefs) {
		var AnalysisResult res = null;
		val root = etefi.systemInstance
		val checker = new FlowLatencyAnalysisSwitch(root)
		val markerType = "LatencyAnalysis"
		if (!getHasRun(markerType, root)) {
			val som = root.systemOperationModes.head
			try {
				if (prefs !== null && prefs.size === 4) {
					res = checker.invokeAndSaveResult(root, som, prefs.get(0), prefs.get(1), prefs.get(2), prefs.get(3))
				} else {
					res = checker.invokeAndSaveResult(root, som, false, true, true, true)
				}
				setHasRun(markerType, root)
				setAnalysisResult(root, res)
			} catch (Throwable e) {
				unsetHasRun(markerType, root)
			}
		} else {
			res = getAnalysisResult(root)
		}
		res
	}

//=======================architecture.analysis========================//
	def static String A429Consistency(InstanceObject ci) {
		val checker = new CheckA429PortConnectionConsistency()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String ConnectionBindingConsistency(InstanceObject ci) {
		val checker = new CheckConnectionBindingConsistency()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String PortDataConsistency(InstanceObject ci) {
		val checker = new DoPortConnectionConsistency()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String MassAnalysis(InstanceObject ci) {
		val checker = new DoPropertyTotals()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String BoundResourceAnalysis(InstanceObject ci) {
		val checker = new DoBoundResourceAnalysis()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String NetworkBandWidthAnalysis(InstanceObject ci) {
		val checker = new DoBoundSwitchBandWidthAnalysis
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String PowerAnalysis(InstanceObject ci) {
		val checker = new DoPowerAnalysis()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String ResourceBudget(InstanceObject ci) {
		val checker = new DoResourceBudget()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try {
				checker.invoke(new NullProgressMonitor, instance)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

//=======================resource management========================//	
	def static String Binpack(InstanceObject ci) {
		val checker = new Binpack()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			val som = instance.systemOperationModes.head
			try {
				checker.invoke(new NullProgressMonitor, instance, som)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

}
