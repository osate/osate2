package org.osate.assure.analysis

import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance
import org.eclipse.core.runtime.NullProgressMonitor
import org.osate.analysis.architecture.actions.DoPortConnectionConsistency
import org.osate.analysis.architecture.actions.CheckA429PortConnectionConsistency
import org.osate.analysis.architecture.actions.CheckConnectionBindingConsistency
import org.osate.analysis.resource.budgets.actions.DoPowerAnalysis
import org.osate.analysis.architecture.actions.DoPropertyTotals
import org.osate.analysis.flows.actions.CheckFlowLatency
import static extension org.osate.assure.util.AssureUtilExtension.*

class AnalysisPluginInterface {
	
	def static String flowLatencyAnalysis(InstanceObject etefi) {
			val checker = new CheckFlowLatency()
		val markerType = checker.getMarkerType
		val instance = etefi.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			val som = instance.systemOperationModes.head
			try{
			checker.invoke(new NullProgressMonitor,  instance, som)
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
	
	
}