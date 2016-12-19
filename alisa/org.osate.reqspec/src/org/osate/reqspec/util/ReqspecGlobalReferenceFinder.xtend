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

package org.osate.reqspec.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.alisa.common.util.CommonReferenceHelper
import org.osate.reqspec.reqSpec.GlobalConstants
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet

@ImplementedBy(ReqspecGlobalReferenceFinder)
interface IReqspecGlobalReferenceFinder {
	/**
	 * these methods should not be used to construct scopes
	 */
	def Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentInstance ci);

	def Iterable<Requirement> getAllRequirements(ComponentInstance ci);

	def Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentClassifier cc);

	def Iterable<Requirement> getAllRequirements(ComponentClassifier cc);

	def Iterable<SystemRequirementSet> getSystemRequirementSetsNoExtends(ComponentClassifier cc);

	def Iterable<GlobalConstants> getAllGlobalConstants(EObject context);

	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc);

	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentInstance ci);
}

class ReqspecGlobalReferenceFinder implements IReqspecGlobalReferenceFinder {

	@Inject
	var CommonReferenceHelper refHelper

	@Inject
	var ICommonGlobalReferenceFinder commonRefFinder

	override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentInstance ci) {
		ci.componentClassifier.systemRequirementSets
	}

	override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentClassifier cc) {
		val hierarchy = new ArrayList<EObject>
		var Classifier c = cc
		while (c != null) {
			hierarchy.add(c)
			c = c.extended
		}
		refHelper.getReferences(hierarchy, "reqspec", SystemRequirementSet)
	}

	override Iterable<SystemRequirementSet> getSystemRequirementSetsNoExtends(ComponentClassifier cc) {
		refHelper.getReferences(cc, SystemRequirementSet)
	}

	override Iterable<Requirement> getAllRequirements(ComponentInstance ci) {
		ci.componentClassifier.allRequirements
	}

	override Iterable<Requirement> getAllRequirements(ComponentClassifier cc) {
		cc.systemRequirementSets.map[it.requirements].flatten
	}

	override Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc) {
		refHelper.getReferences(cc, "goals", StakeholderGoals)
	}

	override getStakeholderGoals(ComponentInstance ci) {
		ci.componentClassifier.stakeholderGoals
	}

	override Iterable<GlobalConstants> getAllGlobalConstants(EObject context) {
		val Iterable<GlobalConstants> result = commonRefFinder.getEObjectDescriptions(context,
			ReqSpecPackage.Literals.GLOBAL_CONSTANTS, "constants").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as GlobalConstants
		]
		return result
	}

}