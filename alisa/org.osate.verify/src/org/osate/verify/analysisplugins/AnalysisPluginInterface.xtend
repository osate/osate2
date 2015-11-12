package org.osate.verify.analysisplugins

import org.eclipse.core.runtime.NullProgressMonitor
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.osate.analysis.architecture.actions.CheckA429PortConnectionConsistency
import org.osate.analysis.architecture.actions.CheckConnectionBindingConsistency
import org.osate.analysis.architecture.actions.DoPortConnectionConsistency
import org.osate.analysis.architecture.actions.DoPropertyTotals
import org.osate.analysis.flows.actions.CheckFlowLatency
import org.osate.analysis.flows.preferences.Values
import org.osate.analysis.resource.budgets.actions.DoBoundResourceAnalysis
import org.osate.analysis.resource.budgets.actions.DoBoundSwitchBandWidthAnalysis
import org.osate.analysis.resource.budgets.actions.DoPowerAnalysis
import org.osate.analysis.resource.budgets.actions.DoResourceBudget
import org.osate.analysis.resource.management.actions.Binpack
import org.osate.analysis.security.actions.CheckSafety
import org.osate.analysis.security.actions.CheckSecurity

import static org.osate.verify.util.VerifyUtilExtension.*

class AnalysisPluginInterface {
	
	def static String flowLatencyAnalysis(InstanceObject etefi, String[] prefs) {
			val checker = new CheckFlowLatency()
		val markerType = checker.getMarkerType
		val instance = etefi.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			val som = instance.systemOperationModes.head
			if (!prefs.nullOrEmpty){
				Values.prefs = prefs
			}
			try{
			checker.invoke(new NullProgressMonitor,  instance, som)
				setHasRun(markerType, instance)
				Values.prefs = null
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			} 
		}
		markerType
	}

	

//=======================architecture.analysis========================//
	def static String A429Consistency(InstanceObject ci) {
			val checker = new CheckA429PortConnectionConsistency()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
			checker.invoke(new NullProgressMonitor,  instance)
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
			try{
				checker.invoke(new NullProgressMonitor, instance, som)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

//=======================security========================//	
	def static String CheckSafety(InstanceObject ci) {
			val checker = new CheckSafety()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			val som = instance.systemOperationModes.head					
			try{
				checker.invoke(new NullProgressMonitor, instance, som)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def static String CheckSecurity(InstanceObject ci) {
			val checker = new CheckSecurity()
		val markerType = checker.getMarkerType
		val instance = ci.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			val som = instance.systemOperationModes.head					
			try{
				checker.invoke(new NullProgressMonitor, instance, som)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}
	
}