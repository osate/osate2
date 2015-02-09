package org.osate.measures

import org.osate.aadl2.ComponentType
import org.osate.aadl2.Feature
import org.osate.aadl2.EventPort
import org.osate.aadl2.ComponentImplementation

class AadlPackageMeasures {
	// precentage of features that are supposed to have a type that do not have one
	def int featureWithTypeMeasure(ComponentType ct){
		val featureWithType = ct.getAllFeatures().filter[fea|fea.typedFeature]
		val featureHasType = featureWithType.filter[f|f.hasClassifier]
		(featureHasType.size*100)/featureWithType.size
	}
	
	def boolean typedFeature(Feature f){
		!(f instanceof EventPort )
	}
	
	def boolean hasClassifier(Feature f){
		f.allClassifier != null
	}
	
	def int subcomponentsWithoutConnection(ComponentImplementation cimpl){
		val subs = cimpl.allSubcomponents
		val sub1 = subs.head
		val feas = sub1.allFeatures
		val fea1 = feas.head
		val conns = cimpl.allConnections
		0
	}
	
}