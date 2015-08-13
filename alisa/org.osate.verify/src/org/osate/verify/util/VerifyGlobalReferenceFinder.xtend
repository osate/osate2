package org.osate.verify.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.verify.verify.VerificationPlan

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import org.osate.verify.verify.VerifyPackage
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

@ImplementedBy(VerifyGlobalReferenceFinder)
interface IVerifyGlobalReferenceFinder {
	/**
	 * do not use this methods to construction of scopes as they are operating on references
	 * cc is the classifier that must be the same or an ancestor of the classifier referenced by the system requirements or the verification plan
	 * context determines the resourceset into which the verificaiton plans are loaded
	 */
	def Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc ,EObject context);
	/**
	 * This method does not use EReferences
	 * context determines the visibility of the verification plans EObjectDescriptions to be found
	 */
	def Iterable<VerificationPlan> getForallVerificationPlans(EObject context);
}

class VerifyGlobalReferenceFinder implements IVerifyGlobalReferenceFinder{
		
	@Inject
	var ICommonGlobalReferenceFinder refFinder
		
		override Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc, EObject context){
			val srURIs = refFinder.getEObjectReferences(cc, ReqSpecPackage.eINSTANCE.systemRequirements_Target, "reqspec")
			val vpURIs = srURIs.map[srURI|refFinder.getEObjectReferences(srURI, VerifyPackage.Literals.VERIFICATION_PLAN__SYSTEM_REQUIREMENTS, "verify")].flatten
			val resset = context.eResource.resourceSet
			return vpURIs.map[ vpURI | resset.getEObject(vpURI, true) as VerificationPlan]
	}

		
		override Iterable<VerificationPlan> getForallVerificationPlans(EObject context){
			 refFinder.getEObjectDescriptions(context, VerifyPackage.Literals.VERIFICATION_PLAN, "verify").map [ eod |
			EcoreUtil.resolve(eod.EObjectOrProxy, context) as VerificationPlan
		].filter[vp|vp.systemRequirements?.global]
	}

}