package org.osate.verify.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.verify.verify.VerificationPlan

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import org.osate.verify.verify.VerifyPackage
import org.osate.reqspec.reqSpec.ReqSpecPackage

@ImplementedBy(VerifyGlobalReferenceFinder)
interface IVerifyGlobalReferenceFinder {
	/**
	 * do not use these methods to construction of scopes as they are operating on references
	 */
	def Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc );
}

class VerifyGlobalReferenceFinder implements IVerifyGlobalReferenceFinder{
		
	@Inject
	var ICommonGlobalReferenceFinder refFinder
		
		override Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc){
			val srURIs = refFinder.getEObjectReferences(cc, ReqSpecPackage.eINSTANCE.systemRequirements_Target, "reqspec")
			val vpURIs = srURIs.map[srURI|refFinder.getEObjectReferences(srURI, VerifyPackage.Literals.VERIFICATION_PLAN__SYSTEM_REQUIREMENTS, "verify")].flatten
			val resset = cc.eResource.resourceSet
			return vpURIs.map[ vpURI | resset.getEObject(vpURI, true) as VerificationPlan]
	}

}