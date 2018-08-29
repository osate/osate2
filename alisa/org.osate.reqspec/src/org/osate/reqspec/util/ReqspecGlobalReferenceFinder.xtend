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
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.reqspec.reqSpec.SystemRequirementSet

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

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

	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc);

	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentInstance ci);
}

class ReqspecGlobalReferenceFinder implements IReqspecGlobalReferenceFinder {


	override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentInstance ci) {
		ci.componentClassifier.systemRequirementSets
	}

	override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentClassifier cc) {
		Aadl2GlobalScopeUtil.getAll(cc, ReqSpecPackage.eINSTANCE.systemRequirementSet).filter[srs|cc.isSameorExtends(srs.target)]
	}

	override Iterable<SystemRequirementSet> getSystemRequirementSetsNoExtends(ComponentClassifier cc) {
		Aadl2GlobalScopeUtil.getAll(cc, ReqSpecPackage.eINSTANCE.systemRequirementSet).filter[srs|cc === srs.target]
	}

	override Iterable<Requirement> getAllRequirements(ComponentInstance ci) {
		ci.componentClassifier.allRequirements
	}

	override Iterable<Requirement> getAllRequirements(ComponentClassifier cc) {
		cc.systemRequirementSets.map[it.requirements].flatten
	}

	override Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc) {
		Aadl2GlobalScopeUtil.getAll(cc, ReqSpecPackage.eINSTANCE.stakeholderGoals).filter[sgs|cc === sgs.target]
	}

	override getStakeholderGoals(ComponentInstance ci) {
		ci.componentClassifier.stakeholderGoals
	}

}
