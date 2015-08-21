package org.osate.verify.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.SystemRequirements
import org.osate.verify.verify.VerificationPlan
import org.osate.verify.verify.VerifyPackage

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

@ImplementedBy(VerifyGlobalReferenceFinder)
interface IVerifyGlobalReferenceFinder {
	/**
	 * do not use this methods to construction of scopes as they are operating on references
	 * cc is the classifier that must be the same or an ancestor of the classifier referenced by the system requirements or the verification plan
	 * context determines the resourceset into which the verificaiton plans are loaded
	 */
	def Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc ,EObject context);

	/**
	 * method to be used for scope creation as it does not use EReferences
	 */
	def Iterable<VerificationPlan> getVerificationPlansForScopes(ComponentClassifier cc, EObject context);
	/**
	 * This method does not use EReferences
	 * context determines the visibility of the verification plans EObjectDescriptions to be found
	 */
	def Iterable<VerificationPlan> getGlobalReqVerificationPlans(EObject context);
	
	def Iterable<VerificationPlan> getAllVerificationPlansForSystemRequirement(SystemRequirements sysReqs, EObject context);
}

class VerifyGlobalReferenceFinder implements IVerifyGlobalReferenceFinder{
		
	@Inject
	var ICommonGlobalReferenceFinder refFinder
		
		override Iterable<VerificationPlan> getVerificationPlansForScopes(ComponentClassifier cc, EObject context){
			return refFinder.getEObjectDescriptions(context, VerifyPackage.Literals.VERIFICATION_PLAN, "verify").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as VerificationPlan].filter[vp|cc.isSameorExtends(vp.systemRequirements?.target)]
	}
		
		override Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc, EObject context){
			val srURIs = refFinder.getEObjectReferences(cc, ReqSpecPackage.eINSTANCE.systemRequirements_Target, "reqspec")
			val vpURIs = srURIs.map[srURI|refFinder.getEObjectReferences(srURI, VerifyPackage.Literals.VERIFICATION_PLAN__SYSTEM_REQUIREMENTS, "verify")].flatten
			val resset = context.eResource.resourceSet
			return vpURIs.map[ vpURI | resset.getEObject(vpURI, true) as VerificationPlan]
	}

		
		override Iterable<VerificationPlan> getGlobalReqVerificationPlans(EObject context){
			 refFinder.getEObjectDescriptions(context, VerifyPackage.Literals.VERIFICATION_PLAN, "verify").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as VerificationPlan
		].filter[vp|vp.systemRequirements?.global]
		
		}

		override Iterable<VerificationPlan> getAllVerificationPlansForSystemRequirement(SystemRequirements sysReqs, EObject context){
			 refFinder.getEObjectDescriptions(context, VerifyPackage.Literals.VERIFICATION_PLAN, "verify").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as VerificationPlan].filter[vp|vp.systemRequirements === sysReqs]
		}

}