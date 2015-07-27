package org.osate.alisa.workbench.util

import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.osate.aadl2.instance.ComponentInstance
import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.ComponentClassifier
import org.osate.reqspec.reqSpec.ReqSpecPackage
import org.osate.verify.verify.VerifyPackage
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder
import org.eclipse.xtext.resource.IReferenceDescription
import java.util.List
import org.eclipse.xtext.util.IAcceptor
import com.google.inject.Singleton
import org.eclipse.emf.common.util.URI
import org.osate.verify.verify.VerificationPlan
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import org.osate.reqspec.reqSpec.SystemRequirements

class AlisaWorkbenchReferenceFinder {
	@Inject
	var IGlobalScopeProvider scopeProvider
	

		def Iterable<Requirement> getRequirements(ComponentInstance io){
			val x = (scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(io.componentClassifier,ReqSpecPackage.eINSTANCE.requirement,null)
			// TODO if implementation also look at the type.
			// TODO if classifier is an extension we inherit requirements
			val y = x.map[EObjectOrProxy as Requirement]
			for ( r : y) {
				val cl1 = containingSystemRequirements(r)?.target?:r.target
				val ComponentClassifier t2 = (io as ComponentInstance).componentClassifier
				val c1n = cl1.getQualifiedName()
				val c2n = t2.getQualifiedName()
				println(c1n + " "+c2n)
			}
			y.filter[req| (io as ComponentInstance).componentClassifier.isSameorExtends((req as Requirement).targetClassifier as ComponentClassifier )]
			//(req as Requirement).target.getQualifiedName().equalsIgnoreCase((io as ComponentInstance).componentClassifier.getQualifiedName())]
	//		io.componentClassifier.getGlobalEObjectDescriptions(ReqSpecPackage.eINSTANCE.requirement)
	//		 [IEObjectDescription ed | (ed.EObjectOrProxy as Requirement).target == (io as ComponentInstance).componentClassifier]
	//		 .map[ed|ed.EObjectOrProxy as Requirement]
		}
		
		def Iterable<SystemRequirements> getSystemRequirements(ComponentInstance io){
						(scopeProvider as CommonGlobalScopeProvider).getGlobalEObjectDescriptions(io.componentClassifier,ReqSpecPackage.eINSTANCE.systemRequirements,null).map[EObjectOrProxy as SystemRequirements]
						.filter[sysreqs| isSameorExtends(sysreqs.target, io.componentClassifier)]
		}
		
		def Iterable<Requirement> getAllRequirements(ComponentInstance ci){
			getSystemRequirements(ci).map[it.content].flatten
		}
		
		
		def getVerificationActivities(Requirement reqspec){
	//		reqspec.getGlobalEObjectDescriptions(VerifyPackage.eINSTANCE.verificationContainer,null).
	//		map[EObjectOrProxy as VerificationContainer].filter[va | va.target == reqspec] 
//			reqspec.getGlobalEObjectDescriptions(VerifyPackage.eINSTANCE.verificationPlan)
//			[ed | (ed.EObjectOrProxy as VerificationPlan)?.claim ] 
//			.map[ed|ed.EObjectOrProxy as verificationPlan]
// XXX TODO collect all VAs in all claims of a verification plan.
		}
		
	@Inject
	private IReferenceFinder referenceFinder;

		def List<IReferenceDescription> myFindReferences(URI uri){
			val List<IReferenceDescription> references = newArrayList();
			val IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
				override accept(IReferenceDescription reference) {
					references.add(reference);
				}
			};
			val Iterable<URI> targetURIs = #[uri];
			referenceFinder.findAllReferences(targetURIs, null, acceptor, null);
			references
		}
		
		def  rfGetSystemRequirements(ComponentInstance ci){
			
		}
		
	
}