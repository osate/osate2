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
		f.allClassifier !== null
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