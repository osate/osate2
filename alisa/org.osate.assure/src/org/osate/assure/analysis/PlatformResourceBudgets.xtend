package org.osate.assure.analysis

import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.SystemInstance

import static org.junit.Assert.*

import static extension org.osate.xtext.aadl2.properties.util.GetProperties.*
import java.util.List
import static org.junit.Assert.*

class CompositionalWeightAnalysis  {

	/**
	 * sum up weight limits of direct subcomponents 
	 */
	def double sumSubWeightLimits(ComponentInstance ci) {
		ci.componentInstances.map[getWeightLimit(0.0)].sum
	}
	
	def double sum(List<Double> doublecollection){
		doublecollection.fold(0.0)[a,b| a + b]
	}
	
	def double WeightLimitReserve(ComponentInstance ci){
		if (ci.componentInstances.empty) return 0.0
		return ci.getWeightLimit(0.0)- ci.sumSubWeightLimits
	}
	
	def boolean WeightLimitInvariant(ComponentInstance ci){
		if (ci.componentInstances.empty) return true
		return ci.getWeightLimit(0.0)== ci.sumSubWeightLimits
	}
	
	def int subsWithWeightLimit(ComponentInstance ci){
		if (ci.componentInstances.empty) return -1
		return ci.componentInstances.filter[hasAssignedPropertyValue("SEI::WeightLimit")].length
	}
	
	def boolean assumeWithWeightLimit(ComponentInstance ci){
		val count = subsWithWeightLimit(ci)
		if (count < 0) return true
		val sz = ci.componentInstances.length
		val ratio = (count*100) / sz
		assertEquals(ratio+"% of "+ci.name+" subcomponents without weight limit",count , sz)
		true
	}

	def double sumAllWeightLimits(ComponentInstance ci) {
		ci.allComponentInstances.map[getWeightLimit(0.0)].sum
	}
	
}
