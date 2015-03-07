package org.osate.verify.userextensions

import org.osate.aadl2.instance.ComponentInstance

import static org.junit.Assert.*

import static extension org.osate.xtext.aadl2.properties.util.GetProperties.*
import java.util.List
import org.osate.aadl2.ComponentCategory

class CompositionalWeightAnalysis  {

	/**
	 * sum up weight limits of direct subcomponents 
	 */
	def static double sumSubWeightLimits(ComponentInstance ci) {
		ci.componentInstances.map[a|a.getWeightLimit(0.0)].sum
	}
	
	def static double sum(List<Double> doublecollection){
		doublecollection.fold(0.0)[a,b| a + b]
	}
	
	def static double WeightLimitReserve(ComponentInstance ci){
		if (ci.componentInstances.empty) return 0.0
		return ci.getWeightLimit(0.0)- ci.sumSubWeightLimits
	}
	
	def static boolean WeightLimitInvariant(ComponentInstance ci){
		if (ci.componentInstances.empty) return true
		return ci.getWeightLimit(0.0)== ci.sumSubWeightLimits
	}
	
	def static int subsWithWeightLimit(ComponentInstance ci){
		if (ci.componentInstances.empty) return -1
		return ci.componentInstances.filter[hasAssignedPropertyValue("SEI::WeightLimit")].length
	}
	
	def static boolean assumeWithWeightLimit(ComponentInstance ci){
		val count = subsWithWeightLimit(ci)
		if (count < 0) return true
		val sz = ci.componentInstances.length
		val ratio = (count*100) / sz
		assertEquals(ratio+"% of "+ci.name+" subcomponents without weight limit",count , sz)
		true
	}

	def static double sumAllWeightLimits(ComponentInstance ci) {
		if (ci.componentInstances.empty){
			return ci.getWeightLimit(0.0)
		} else {
			return ci.componentInstances.map[sub|sub.sumAllWeightLimits].sum
		}
	}
	
}
