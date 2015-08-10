package org.osate.verify.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.SystemRequirements

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import org.osate.aadl2.ComponentClassifier
import org.osate.verify.verify.VerificationPlan
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.verify.verify.VerifyPackage
import org.eclipse.emf.ecore.EObject

@ImplementedBy(VerifyReferenceFinder)
interface IVerifyReferenceFinder {
	def Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc , EObject context);
}

class VerifyReferenceFinder implements IVerifyReferenceFinder{
		
	@Inject
	var IGlobalScopeProvider scopeProvider
		
		override Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc, EObject context){
			val x = (scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(context,VerifyPackage.eINSTANCE.verificationPlan,null)
			for (vp : x){
				val n = vp.name
				val n2 = vp.name
			}
			val y = x.map[ied|EcoreUtil.resolve(ied.EObjectOrProxy, context) as VerificationPlan]
			val z = y.filter [  vp | cc.isSameorExtends(vp.systemRequirements?.target)]
			return z
	}

}