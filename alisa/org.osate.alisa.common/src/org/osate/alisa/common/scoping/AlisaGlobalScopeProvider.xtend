package org.osate.alisa.common.scoping

import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.Collections
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider
import org.eclipse.xtext.resource.IEObjectDescription
import java.util.List
import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.emf.common.util.URI
import com.google.inject.Singleton

@Singleton
class AlisaGlobalScopeProvider extends DefaultGlobalScopeProvider {
//	@Inject 
	private IQualifiedNameProvider qualifiedNameProvider ;

	public static val DUPLICATE_GLOBAL_NAME = "org.osate.alisa.common.DuplicateGlobalName"

	/**
	 * Get all global definitions of objects with the qualified name and the same eClass as target.
	 */
	def List<IEObjectDescription> getDuplicates(EObject target) {
		val qn = qualifiedNameProvider?.getFullyQualifiedName(target)
		if(qn == null) return Collections.EMPTY_LIST;
		val res = new Stack<IEObjectDescription>()
		val context = target.eResource();
		if (context == null || context.getResourceSet() == null) {
			return Collections.EMPTY_LIST;
		}
		val containers = Lists.newArrayList(getVisibleContainers(context));
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

// check out ReferenceFinder in xtext.editor
	def List<URI> getReferences(EObject target) {
		val qn = qualifiedNameProvider.getFullyQualifiedName(target)
		if(qn == null) return Collections.EMPTY_LIST;
		val res = new Stack<URI>()
		val context = target.eResource();
		if (context == null || context.getResourceSet() == null) {
			return Collections.EMPTY_LIST;
		}
		val containers = Lists.newArrayList(getVisibleContainers(context));
		for (container : containers) {
			val rds = container.resourceDescriptions
			for (rd : rds) {
				val imports = rd.importedNames
				if (imports.contains(qn)) {
					val refds = rd.referenceDescriptions
					for (red : refds){
						 if(red.targetEObjectUri == target.URI){
						 	res += red.sourceEObjectUri
						 }
					}
				}
			}
		}
		return res
	}

	def boolean contains(Iterable<QualifiedName> names, QualifiedName qn){
		for (match : names){
			if (match == qn) return true
		}
		return false
	}
	
	def void getFullyQualifiedName(){
		
	}

}
