package org.osate.reqspec.util

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
import org.eclipse.emf.ecore.util.EcoreUtil

@ImplementedBy(ReqspecReferenceFinder)
interface IReqspecReferenceFinder {
	def Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci);
	def Iterable<Requirement> getAllRequirements(ComponentInstance ci);
	def Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc);
	def Iterable<Requirement> getAllRequirements(ComponentClassifier cc);
}

class ReqspecReferenceFinder implements IReqspecReferenceFinder{
		
	@Inject
	var IGlobalScopeProvider scopeProvider
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci){
			ci.componentClassifier.systemRequirements
		}
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc){
						(scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(cc,ReqSpecPackage.eINSTANCE.systemRequirements,null).map[EcoreUtil.resolve(EObjectOrProxy,cc) as SystemRequirements]
						.filter[sysreqs| cc.isSameorExtends( sysreqs.target)]
		}
		
		override Iterable<Requirement> getAllRequirements(ComponentInstance ci){
			ci.componentClassifier.allRequirements
		}
		override Iterable<Requirement> getAllRequirements(ComponentClassifier cc){
			cc.systemRequirements.map[it.content].flatten
		}

}