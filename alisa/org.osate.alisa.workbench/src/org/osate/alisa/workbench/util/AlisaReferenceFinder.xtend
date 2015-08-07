package org.osate.alisa.workbench.util

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

@ImplementedBy(AlisaReferenceFinder)
interface IAlisaReferenceFinder {
	def Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci);
	def Iterable<Requirement> getAllRequirements(ComponentInstance ci);
	def Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc);
	def Iterable<Requirement> getAllRequirements(ComponentClassifier cc);
	def Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc);
}

class AlisaReferenceFinder implements IAlisaReferenceFinder{
		
	@Inject
	var IGlobalScopeProvider scopeProvider
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci){
			ci.componentClassifier.systemRequirements
		}
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc){
						(scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(cc,ReqSpecPackage.eINSTANCE.systemRequirements,null).map[EObjectOrProxy as SystemRequirements]
						.filter[sysreqs| sysreqs.target.isSameorExtends( cc)]
		}
		
		override Iterable<Requirement> getAllRequirements(ComponentInstance ci){
			ci.componentClassifier.allRequirements
		}
		override Iterable<Requirement> getAllRequirements(ComponentClassifier cc){
			cc.systemRequirements.map[it.content].flatten
		}

		override Iterable<VerificationPlan> getVerificationPlans(ComponentClassifier cc){
			val x = (scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(cc,VerifyPackage.eINSTANCE.verificationPlan,null)
			val y = x.map[ied|EcoreUtil.resolve(ied.EObjectOrProxy, cc) as VerificationPlan]
			val z = y.filter [  vp | cc.isSameorExtends(vp.systemRequirements?.target)]
			return z
	}

}