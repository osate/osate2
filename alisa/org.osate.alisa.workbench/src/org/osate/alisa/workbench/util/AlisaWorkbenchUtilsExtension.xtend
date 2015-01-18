package org.osate.alisa.workbench.util

import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.workbench.alisa.AssuranceCasePlan
import org.osate.verify.verify.VerificationPlan
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ComponentImplementation

class AlisaWorkbenchUtilsExtension {
		
	def getVerificationPlans(ComponentInstance io, AssuranceCasePlan acp) {
		val myplans = acp.plans.filter [ VerificationPlan vp |
			vp.target.isSame(io.componentClassifier)
		]
		myplans
	}
	
	def isSame(ComponentClassifier cl1, ComponentClassifier cl2){
		var lcl1 = cl1
		var lcl2 = cl2
		if (cl1 instanceof ComponentType && cl2 instanceof ComponentImplementation)
		lcl2 = (cl2 as ComponentImplementation).type
		if (cl2 instanceof ComponentType && cl1 instanceof ComponentImplementation)
		lcl1 = (cl1 as ComponentImplementation).type
		cl1.name.equalsIgnoreCase(cl2.name)
	}
// XXX global find reference methods
//	@Inject
//	var IGlobalScopeProvider scopeProvider
//
//	extension CommonGlobalScopeProvider cgsp = scopeProvider as CommonGlobalScopeProvider
//
	//	def getRequirements(ComponentInstance io){
	//		val x = io.componentClassifier.getGlobalEObjectDescriptions(ReqSpecPackage.eINSTANCE.requirement,null)
	//		
	//		val y = x.map[EObjectOrProxy as Requirement]
	//		for ( r : y) {
	//			val cl1 = r.target
	//			val ComponentClassifier t2 = (io as ComponentInstance).componentClassifier
	//			val c1n = cl1.getQualifiedName()
	//			val c2n = t2.getQualifiedName()
	//			println(c1n + " "+c2n)
	//		}
	//		y.filter[req| samereqs((req as Requirement).target as ComponentClassifier, (io as ComponentInstance).componentClassifier )]//(req as Requirement).target.getQualifiedName().equalsIgnoreCase((io as ComponentInstance).componentClassifier.getQualifiedName())]
	////		io.componentClassifier.getGlobalEObjectDescriptions(ReqSpecPackage.eINSTANCE.requirement)
	////		 [IEObjectDescription ed | (ed.EObjectOrProxy as Requirement).target == (io as ComponentInstance).componentClassifier]
	////		 .map[ed|ed.EObjectOrProxy as Requirement]
	//	}
	//	
	//	def boolean samereqs (ComponentClassifier cl1, ComponentClassifier cl2){
	//		cl1.getQualifiedName().equalsIgnoreCase(cl2.getQualifiedName())
	//	}
	//	
	//	def getVerificationActivities(Requirement reqspec){
	////		reqspec.getGlobalEObjectDescriptions(VerifyPackage.eINSTANCE.verificationContainer,null).
	////		map[EObjectOrProxy as VerificationContainer].filter[va | va.target == reqspec] 
	//		reqspec.getGlobalEObjectDescriptions(VerifyPackage.eINSTANCE.verificationContainer)
	//		[ed | (ed.EObjectOrProxy as VerificationContainer)?.target == reqspec] 
	//		.map[ed|ed.EObjectOrProxy as VerificationContainer]
	//	}
//	def getRequirementTarget(Requirement req, InstanceObject io) {
//		io.findElementInstance(req.target)
//	}
//
//	def findElementInstance(InstanceObject io, NamedElement element) {
//		switch io {
//			ComponentInstance: io.allOwnedElements.findFirst[ei|
//				(ei as InstanceObject).name.equalsIgnoreCase(element.name)] as NamedElement
//			default: io
//		}
//	}
	
}