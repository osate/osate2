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
import org.osate.verify.verify.VerificationLibrary
import org.eclipse.xtext.resource.IReferenceDescription
import java.util.List
import org.eclipse.xtext.util.IAcceptor
import com.google.inject.Singleton
import org.eclipse.emf.common.util.URI

class AlisaWorkbenchReferenceFinder {
	@Inject
	var IGlobalScopeProvider scopeProvider

	extension CommonGlobalScopeProvider cgsp = scopeProvider as CommonGlobalScopeProvider

		def getRequirements(ComponentInstance io){
			val x = io.componentClassifier.getGlobalEObjectDescriptions(ReqSpecPackage.eINSTANCE.requirement,null)
			// TODO if implementation also look at the type.
			// TODO if classifier is an extension we inherit requirements
			val y = x.map[EObjectOrProxy as Requirement]
			for ( r : y) {
				val cl1 = r.target
				val ComponentClassifier t2 = (io as ComponentInstance).componentClassifier
				val c1n = cl1.getQualifiedName()
				val c2n = t2.getQualifiedName()
				println(c1n + " "+c2n)
			}
			y.filter[req| isSame((req as Requirement).target as ComponentClassifier, (io as ComponentInstance).componentClassifier )]
			//(req as Requirement).target.getQualifiedName().equalsIgnoreCase((io as ComponentInstance).componentClassifier.getQualifiedName())]
	//		io.componentClassifier.getGlobalEObjectDescriptions(ReqSpecPackage.eINSTANCE.requirement)
	//		 [IEObjectDescription ed | (ed.EObjectOrProxy as Requirement).target == (io as ComponentInstance).componentClassifier]
	//		 .map[ed|ed.EObjectOrProxy as Requirement]
		}
		
		def boolean isSame (ComponentClassifier cl1, ComponentClassifier cl2){
			cl1.getQualifiedName().equalsIgnoreCase(cl2.getQualifiedName())
		}
		
		def getVerificationActivities(Requirement reqspec){
	//		reqspec.getGlobalEObjectDescriptions(VerifyPackage.eINSTANCE.verificationContainer,null).
	//		map[EObjectOrProxy as VerificationContainer].filter[va | va.target == reqspec] 
			reqspec.getGlobalEObjectDescriptions(VerifyPackage.eINSTANCE.verificationLibrary)
			[ed | (ed.EObjectOrProxy as VerificationLibrary)?.target == reqspec] 
			.map[ed|ed.EObjectOrProxy as VerificationLibrary]
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
//		 	for (IResourceDescription iResourceDescription : rdlist) {
//				Iterable<IReferenceDescription> reflist = iResourceDescription.getReferenceDescriptions();
//				for (IReferenceDescription iReferenceDescription : reflist) {
//					URI srcURI=iReferenceDescription.getSourceEObjectUri();
//					URI dstURI = iReferenceDescription.getTargetEObjectUri();
//					EReference ref = iReferenceDescription.getEReference();
//					System.out.println("Ref ");
//				}
//			}
		
//	XXX		final List<IReferenceDescription> references = newArrayList();
//			IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
//				@Override
//				public void accept(IReferenceDescription reference) {
//					references.add(reference);
//				}
//			};
//			referenceFinder.findReferences(getTargetURIs(target), singleton(resource.getURI()),
//				null, acceptor, monitor.newChild(40));


// filter can be some predicate
//	protected Predicate<IReferenceDescription> getFilter(EObject primaryTarget) {
//		return Predicates.alwaysTrue();
//	}

//			this.filteringAcceptor = new IAcceptor<IReferenceDescription>() {
//				public void accept(IReferenceDescription t) {
//					if (filter.apply(t))
//						acceptor.accept(t);
//				}
//			};

//			referenceFinder.findAllReferences(targetURIs, localResourceAccess, filteringAcceptor, null);
		
	
}