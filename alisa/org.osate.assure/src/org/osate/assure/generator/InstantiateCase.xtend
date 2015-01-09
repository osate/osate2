package org.osate.assure.generator

import org.osate.aadl2.instance.SystemInstance
import org.osate.assure.assure.CaseResult
import org.osate.assure.assure.AssureFactory
import org.osate.aadl2.instance.ComponentInstance
import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.instance.InstanceObject
import org.osate.alisa.common.util.AlisaUtilExtension
import org.osate.alisa.common.scoping.AlisaGlobalScopeProvider
import org.osate.aadl2.Element
import org.osate.aadl2.NamedElement
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationAssumption

class InstantiateCase {
//	val factory =AssureFactory.eINSTANCE
	extension AlisaGlobalScopeProvider agsp = new AlisaGlobalScopeProvider
	
	def instantiate(SystemInstance si){
//		val CaseResult theCase = factory.createCaseResult()
		si.generate
	}
	
	def String generate ( ComponentInstance ci){
		'''
		case «ci.name» for «ci.instanceObjectPath»
		[
		«FOR subci : ci.allComponentInstances»
			«subci.generate»
		«ENDFOR»
		«FOR reqspec : ci.requirements»
			«reqspec.generate(ci)»
		«ENDFOR»
		]
		'''
	}
		
	def generate (Requirement reqspec, InstanceObject io){
		'''
		claim «io.name»-«reqspec.name» of «reqspec»
		for «io.instanceObjectPath» 
		[
		«FOR subreqspec : reqspec.subrequirement»
			«subreqspec.generate(io)»
		«ENDFOR»
		«FOR va : reqspec.verificationActivities»
			«va.generate(io)»
		«ENDFOR»
		]
		'''
	}
		
	def generate (VerificationActivity va, InstanceObject io){
		'''
		verification «io.name»-«va.name» of «va»
		for «io.instanceObjectPath» 
		[
		«FOR subva : va.assumption »
			«subva.generate(io)»
		«ENDFOR»
		]
		'''
	}
		
	def generate (VerificationAssumption va, InstanceObject io){
		'''
		verification «io.name»-«va.name» of «va»
		for «io.instanceObjectPath» 
		[
		]
		'''
	}
	
	def getRequirements(InstanceObject io){
		io.references.map[uri|io.eResource.resourceSet.getEObject(uri, true) as Requirement]
	}
	
	def getVerificationActivities(Requirement reqspec){
		reqspec.references.map[uri|reqspec.eResource.resourceSet.getEObject(uri, true) as VerificationActivity]
	}
	
	def getRequirementTarget(Requirement req, InstanceObject io){
		io.findElementInstance(req.target)
	}
	
	def findElementInstance(InstanceObject io, NamedElement element){
		switch io {
			ComponentInstance : io.allOwnedElements.findFirst[ei| (ei as InstanceObject).name.equalsIgnoreCase(element.name)] as NamedElement
			default: io
		}
	}
}