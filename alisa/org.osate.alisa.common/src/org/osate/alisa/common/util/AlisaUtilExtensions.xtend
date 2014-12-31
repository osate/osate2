package org.osate.alisa.common.util

import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.URI
import com.google.inject.Inject
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.emf.ecore.EClass
import org.osate.alisa.common.scoping.AlisaGlobalScopeProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.osate.aadl2.Aadl2Package
import org.eclipse.xtext.scoping.Scopes

class AlisaUtilExtensions {
	extension AlisaGlobalScopeProvider agsp = new AlisaGlobalScopeProvider
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter ;
		
		
	def IEObjectDescription getGlobalEObjectDescription(EObject context, EClass eClass, String qname){
		val gscope = context.getGlobalScope(eClass, null)
		gscope.getSingleElement(qualifiedNameConverter?.toQualifiedName(qname))
	}
	
	def EObject getGlobalEObject(EObject context, EClass eClass, String qname){
		val eod = context.getGlobalEObjectDescription(eClass, qname)
		eod.EObjectOrProxy
	}
	
	def URI getGlobalEObjectURI(EObject context, EClass eClass, String qname){
		val eod = context.getGlobalEObjectDescription(eClass, qname)
		eod.EObjectURI
	}
	
	def EObject getPropertyDefinition(EObject context, String qname){
		val eod = context.getGlobalEObjectDescription(Aadl2Package.eINSTANCE.getProperty(), qname)
		eod.EObjectOrProxy
	}
		
	def EObject getClassifier(EObject context, String qname){
		val eod = context.getGlobalEObjectDescription(Aadl2Package.eINSTANCE.classifier, qname)
		eod.EObjectOrProxy
	}
	
		
	def Iterable<IEObjectDescription> getGlobalEObjectDescriptions(EObject context, EClass eClass){
		val gscope = context.getGlobalScope(eClass, null)
		gscope.getAllElements()
	}
		
	def Iterable<EObject> getClassifiers(EObject context){
		context.getGlobalEObjectDescriptions(Aadl2Package.eINSTANCE.classifier).map[EObjectOrProxy]
	}
		
	def Iterable<EObject> getThreads(EObject context){
		context.getGlobalEObjectDescriptions(Aadl2Package.eINSTANCE.thread).map[EObjectOrProxy]
	}
	
}