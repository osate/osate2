package org.osate.reqspec.util

import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.eclipse.emf.ecore.EObject
import org.osate.aadl2.Aadl2Package
import com.google.inject.ImplementedBy
import org.osate.reqspec.reqSpec.Requirement
import org.osate.aadl2.instance.ComponentInstance
import org.osate.reqspec.reqSpec.SystemRequirements
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.emf.common.util.URI
import org.osate.reqspec.reqSpec.ReqSpecPackage
import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.reqspec.util.ReqSpecUtilExtension.*
import java.util.List
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder

@ImplementedBy(ReqSpecReferenceFinder)
interface IReqSpecReferenceFinder {
	def  ComponentClassifier getComponentClassifier(EObject context, String name);
}

class ReqSpecReferenceFinder implements IReqSpecReferenceFinder{
		
	@Inject
	var IGlobalScopeProvider scopeProvider
	
	override  ComponentClassifier getComponentClassifier(EObject context, String name){
		(scopeProvider as CommonGlobalScopeProvider).getGlobalEObject(context,Aadl2Package.eINSTANCE.componentClassifier,name) as ComponentClassifier
	}

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