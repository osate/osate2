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
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.reqspec.reqSpec.GlobalConstants
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.StakeholderGoals
import org.osate.alisa.common.util.CommonUtilExtension
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

class ReqspecGlobalReferenceFinder implements IReqspecGlobalReferenceFinder{
		
	@Inject
	var ICommonGlobalReferenceFinder commonRefFinder
		
		override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentInstance ci){
			ci.componentClassifier.systemRequirementSets
		}
		
		override Iterable<SystemRequirementSet> getSystemRequirementSets(ComponentClassifier cc){
		   val Iterable<SystemRequirementSet> result = commonRefFinder.getEObjectDescriptions(
			cc, ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET, "reqspec").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, cc) as SystemRequirementSet]
			return result.filter[ sr | CommonUtilExtension.isSameorExtends(cc, sr.target)]
		}
		
		override Iterable<SystemRequirementSet> getSystemRequirementSetsNoExtends(ComponentClassifier cc){
		   val Iterable<SystemRequirementSet> result = commonRefFinder.getEObjectDescriptions(
			cc, ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET, "reqspec").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, cc) as SystemRequirementSet]
			return result.filter[ sr | cc === sr.target]
		}

		override Iterable<Requirement> getAllRequirements(ComponentInstance ci){
			ci.componentClassifier.allRequirements
		}
		override Iterable<Requirement> getAllRequirements(ComponentClassifier cc){
			cc.systemRequirementSets.map[it.requirements].flatten
		}

		override Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc){
		   val Iterable<StakeholderGoals> result = commonRefFinder.getEObjectDescriptions(
			cc, ReqSpecPackage.Literals.STAKEHOLDER_GOALS, "goals").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, cc) as StakeholderGoals]
			return result.filter[ sr | CommonUtilExtension.isSameorExtends(cc, sr.target)]
		}
		
		override getStakeholderGoals(ComponentInstance ci) {
			ci.componentClassifier.stakeholderGoals
		}

	override Iterable<GlobalConstants> getAllGlobalConstants(EObject context){
		val Iterable<GlobalConstants> result = commonRefFinder.getEObjectDescriptions(
			context, ReqSpecPackage.Literals.GLOBAL_CONSTANTS, "constants").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as GlobalConstants]
		return result
	}
	

}