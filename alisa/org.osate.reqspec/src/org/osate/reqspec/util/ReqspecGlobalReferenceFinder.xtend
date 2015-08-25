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
import org.osate.reqspec.reqSpec.SystemRequirements
import org.osate.alisa.common.util.CommonUtilExtension

@ImplementedBy(ReqspecGlobalReferenceFinder)
interface IReqspecGlobalReferenceFinder {
	/**
	 * these methods should not be used to construct scopes
	 */
	def Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci);
	def Iterable<Requirement> getAllRequirements(ComponentInstance ci);
	def Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc);
	def Iterable<Requirement> getAllRequirements(ComponentClassifier cc);
	def Iterable<SystemRequirements> getSystemRequirementsForScopes(ComponentClassifier cc);
	def Iterable<SystemRequirements> getSystemRequirementsForScopesNoExtends(ComponentClassifier cc);
	def Iterable<GlobalConstants> getAllGlobalConstants(EObject context);
	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc);
	def Iterable<StakeholderGoals> getStakeholderGoals(ComponentInstance ci);
}

class ReqspecGlobalReferenceFinder implements IReqspecGlobalReferenceFinder{
		
	@Inject
	var ICommonGlobalReferenceFinder commonRefFinder
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci){
			ci.componentClassifier.systemRequirements
		}
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc){
			val srURIs = commonRefFinder.getEObjectReferences(cc, ReqSpecPackage.Literals.SYSTEM_REQUIREMENTS__TARGET, "reqspec") 
			val resset = cc.eResource.resourceSet
			return srURIs.map[ srURI | resset.getEObject(srURI, true) as SystemRequirements]
		}

		
		override Iterable<SystemRequirements> getSystemRequirementsForScopes(ComponentClassifier cc){
		   val Iterable<SystemRequirements> result = commonRefFinder.getEObjectDescriptions(
			cc, ReqSpecPackage.Literals.SYSTEM_REQUIREMENTS, "reqspec").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, cc) as SystemRequirements]
			return result.filter[ sr | CommonUtilExtension.isSameorExtends(cc, sr.target)]
		}
		
		override Iterable<SystemRequirements> getSystemRequirementsForScopesNoExtends(ComponentClassifier cc){
		   val Iterable<SystemRequirements> result = commonRefFinder.getEObjectDescriptions(
			cc, ReqSpecPackage.Literals.SYSTEM_REQUIREMENTS, "reqspec").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, cc) as SystemRequirements]
			return result.filter[ sr | cc === sr.target]
		}

		override Iterable<Requirement> getAllRequirements(ComponentInstance ci){
			ci.componentClassifier.allRequirements
		}
		override Iterable<Requirement> getAllRequirements(ComponentClassifier cc){
			cc.systemRequirements.map[it.content].flatten
		}

		override Iterable<StakeholderGoals> getStakeholderGoals(ComponentClassifier cc){
			val srURIs = commonRefFinder.getEObjectReferences(cc, ReqSpecPackage.Literals.STAKEHOLDER_GOALS__TARGET, "goals") 
			val resset = cc.eResource.resourceSet
			return srURIs.map[ srURI | resset.getEObject(srURI, true) as StakeholderGoals]
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