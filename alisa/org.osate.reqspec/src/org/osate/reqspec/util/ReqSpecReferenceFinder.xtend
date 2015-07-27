package org.osate.reqspec.util

import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.aadl2.ComponentClassifier
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider
import org.eclipse.emf.ecore.EObject
import org.osate.aadl2.Aadl2Package
import com.google.inject.ImplementedBy

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
}