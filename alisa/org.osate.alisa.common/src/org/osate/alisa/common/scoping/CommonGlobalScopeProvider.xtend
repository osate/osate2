package org.osate.alisa.common.scoping

import com.google.common.base.Predicate
import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import java.util.Stack
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import org.osate.aadl2.Aadl2Package
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.emf.common.util.URI

class CommonGlobalScopeProvider extends DefaultGlobalScopeProvider {
	@Inject 
	private IQualifiedNameProvider qualifiedNameProvider ;
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter ;

	/**
	 * Get all global definitions of objects with the qualified name and the same eClass as target.
	 */
	def List<IEObjectDescription> getDuplicates(EObject target) {
		val res = new Stack<IEObjectDescription>()
		val context = target.eResource();
		if (context == null || context.getResourceSet() == null) {
			return Collections.EMPTY_LIST;
		}
		val containers = Lists.newArrayList(getVisibleContainers(context));
		val qn = qualifiedNameProvider?.getFullyQualifiedName(target)
		if(qn == null) return Collections.EMPTY_LIST;
		for (container : containers) {
			val eds = container.getExportedObjects(target.eClass(), qn, true)
			if (!container.hasResourceDescription(context.getURI())) {
				res += eds
			} else {
				if (eds.size > 1) {
					for (ed : eds) {
						if(ed.EObjectURI != target.URI) res += ed
					}
				}
			}
		}
		return res
	}

	
	def IScope getGlobalScope(EObject context, EClass eClass, Predicate<IEObjectDescription> filter){
		context.eResource.getScope(true, eClass, filter  )
	}
		
	def Iterable<IEObjectDescription> getGlobalEObjectDescriptions(EObject context, EClass eClass, Predicate<IEObjectDescription> filter){
		val gscope = context.getGlobalScope(eClass, filter)
		gscope.getAllElements()
	}
		
	def IEObjectDescription getGlobalEObjectDescription(EObject context, EClass eClass, String qname, Predicate<IEObjectDescription> filter){
		val gscope = context.getGlobalScope(eClass, filter)
		gscope.getSingleElement(qualifiedNameConverter?.toQualifiedName(qname))
	}
		
	def IEObjectDescription getGlobalEObjectDescription(EObject context, EClass eClass, String qname){
		val gscope = context.getGlobalScope(eClass, null)
		gscope.getSingleElement(qualifiedNameConverter?.toQualifiedName(qname))
	}
	
	def EObject getGlobalEObject(EObject context, EClass eClass, String qname, Predicate<IEObjectDescription> filter){
		val eod = context.getGlobalEObjectDescription(eClass, qname, filter)
		eod?.EObjectOrProxy
	}
	
	def EObject getGlobalEObject(EObject context, EClass eClass, String qname){
		val eod = context.getGlobalEObjectDescription(eClass, qname)
		eod?.EObjectOrProxy
	}
	
	def URI getGlobalEObjectURI(EObject context, EClass eClass, String qname){
		val eod = context.getGlobalEObjectDescription(eClass, qname)
		eod?.EObjectURI
	}
	
//	def EObject getPropertyDefinition(EObject context, String qname){
//		val eod = context.getGlobalEObjectDescription(Aadl2Package.eINSTANCE.getProperty(), qname)
//		eod.EObjectOrProxy
//	}
//		
//	def EObject getClassifier(EObject context, String qname){
//		val eod = context.getGlobalEObjectDescription(Aadl2Package.eINSTANCE.classifier, qname)
//		eod.EObjectOrProxy
//	}

}
