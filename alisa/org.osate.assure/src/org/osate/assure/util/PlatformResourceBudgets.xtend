package org.osate.assure.util

import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.SystemInstance
import static extension org.junit.Assert.*
import static extension org.osate.xtext.aadl2.properties.util.GetProperties.*
import org.osate.aadl2.ComponentImplementation
import org.junit.Test
import org.osate.aadl2.NamedElement
import org.osate.aadl2.instance.InstanceObject
import org.eclipse.core.runtime.NullProgressMonitor
import org.osate.analysis.flows.actions.CheckFlowLatency
import static extension org.osate.assure.util.AssureUtilExtension.*
import org.osate.aadl2.instance.EndToEndFlowInstance
import org.osate.assure.assure.VerificationActivityResult

class PlatformResourceBudgets extends DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {

	/**
	 * normal constructor
	 */
	public new() {
		super()
	}

	/**
	 * constructor to initialize to he parameter for JUnit
	 */
	new(SystemInstance si) {
		systemInstance = si
	}

	// JUnit type parameterization
	var static SystemInstance systemInstance

	/**
	 * sum up MIPS budgets of subcomponent implementations.
	 * This variant uses set operations to calculates the sum over the MIPS budgets
	 * It works on component implementations on the assumption
	 * that each subcomponent has an assigned budget
	 */
	def double sumSubBudgets(ComponentImplementation cimpl) {
		cimpl.allSubcomponents.map[getMIPSBudgetInMIPS(0.0)].reduce[a, b|a + b]
	}

	/**
	 * sum up MIPS budgets of subcomponent implementations.
	 * This variant uses set operations to calculates the sum over the MIPS budgets
	 * It works on component implementations on the assumption
	 * that each subcomponent has an assigned budget
	 */
	def double sumSubBudgets(ComponentInstance ci) {

		//		ci.allComponentInstances.map[getMIPSBudgetInMIPS(0.0)].reduce[a, b|a + b]
		ci.allComponentInstances.map[getGrossWeight(0.0)].reduce[a, b|a + b]
	}

	/**
	 * This method invokes the summation and then evaluates the result against the predicate
	 * The predicate is a lambda function with the limit bound to an external value
	 */
	def Boolean evaluateSubBudget(ComponentInstance ne, (double)=>boolean pred) {
		val actualBudget = ne.sumSubBudgets
		assertTrue(ne.name + " is over budget " + actualBudget, pred.apply(actualBudget))
		true
	}

	//	@For SCS.tier0 == prove declaration == for in ReqSpec 
	def Boolean assertSumSubBudgets(ComponentInstance root) {
		val BudgetLimit = 0.5
		root.evaluateSubBudget[actualBudget|actualBudget <= BudgetLimit]
	}

	def void assertSumSubBudgetsMax(ComponentInstance root, int max) {
		root.evaluateSubBudget[actualBudget|actualBudget <= max]
	}

	@Test
	// just to pick up the JUnit parameterization
	def void assertSumSubBudgets() {
		systemInstance.assertSumSubBudgets
	}

	def boolean validateSubBudgetPrecondition(NamedElement ne) {
		true
	}

	def String allFlowLatencyAnalysis(SystemInstance instance) {
		val checker = new CheckFlowLatency()
		val markerType = checker.getMarkerType
		if (!getHasRun(markerType, instance)) {
			val som = instance.systemOperationModes.head
			try{
				checker.invoke(new NullProgressMonitor, null, instance, som)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	def String flowLatencyAnalysis(EndToEndFlowInstance etefi) {
			val checker = new CheckFlowLatency()
		val markerType = checker.getMarkerType
		val instance = etefi.elementRoot as SystemInstance
		if (!getHasRun(markerType, instance)) {
			val som = instance.systemOperationModes.head
			try{
			checker.invoke(new NullProgressMonitor, null, instance, som)
				setHasRun(markerType, instance)
			} catch (Throwable e) {
				unsetHasRun(markerType, instance)
			}
		}
		markerType
	}

	override Object dispatchVerificationMethod(String methodPath, VerificationActivityResult vr) {
		val target = vr.claimSubject
		if (target instanceof ComponentInstance) {
			switch (methodPath) {
				case "org.osate.assure.util.PlatformResourceBudgets.assertSumSubBudgets": {
					target.assertSumSubBudgets
				}
				case "org.osate.assure.util.PlatformResourceBudgets.sumSubBudgets": {
					target.sumSubBudgets
				}
				case "org.osate.assure.util.PlatformResourceBudgets.flowLatencyAnalysis": {
					if (target instanceof SystemInstance) {
						val mt = target.allFlowLatencyAnalysis
						return vr.addAllErrorMarkers(target,mt)
					}
					return null
				}
			}
		} else if (target instanceof EndToEndFlowInstance){
			switch (methodPath) {
				case "org.osate.assure.util.PlatformResourceBudgets.flowLatencyAnalysis": {
					val mt = target.flowLatencyAnalysis
					return vr.addErrorMarkers(target,mt)
				}
			}
		}
	}

}
