package org.osate.reqspec.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.instance.ComponentInstance
import org.osate.alisa.common.scoping.ICommonGlobalReferenceFinder
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.SystemRequirements

@ImplementedBy(ReqspecReferenceFinder)
interface IReqspecReferenceFinder {
	def Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci);
	def Iterable<Requirement> getAllRequirements(ComponentInstance ci);
	def Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc);
	def Iterable<Requirement> getAllRequirements(ComponentClassifier cc);
}

class ReqspecReferenceFinder implements IReqspecReferenceFinder{
		
	@Inject
	var ICommonGlobalReferenceFinder refFinder
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentInstance ci){
			ci.componentClassifier.systemRequirements
		}
		
		override Iterable<SystemRequirements> getSystemRequirements(ComponentClassifier cc){
			val srURIs = refFinder.getEObjectReferences(cc, ReqSpecPackage.Literals.SYSTEM_REQUIREMENTS__TARGET, "reqspec") 
			val resset = cc.eResource.resourceSet
			return srURIs.map[ srURI | resset.getEObject(srURI, true) as SystemRequirements]
		}
		
		override Iterable<Requirement> getAllRequirements(ComponentInstance ci){
			ci.componentClassifier.allRequirements
		}
		override Iterable<Requirement> getAllRequirements(ComponentClassifier cc){
			cc.systemRequirements.map[it.content].flatten
		}

}