/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.alisa.common.scoping

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import java.util.ArrayList
import java.util.Collections
import java.util.Stack
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.osate.aadl2.ComponentClassifier

import static extension org.osate.alisa.common.util.CommonUtilExtension.*

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

@ImplementedBy(CommonGlobalReferenceFinder)
interface ICommonGlobalReferenceFinder {
	/**
	 * getEObjectReferences assume that references have been resolved. Therefore do not use them to construct scopes.
	 */
	def Iterable<URI> getEObjectReferences(ComponentClassifier target, EReference ereference, String URIExtension);

	/**
	 * getEObjectReferences assume that references have been resolved. Therefore do not use them to construct scopes.
	 */
	def Iterable<URI> getEObjectReferences(URI target, EReference ereference, String URIExtension);

	/**
	 * getEObjectDescriptions can be used to construct scopes, which themselves are used to resolve references.
	 */
	def Iterable<IEObjectDescription> getEObjectDescriptions(EObject context, EClass eclass, String URIExtension);

	/**
	 * getDuplicates is a method that finds duplicates for the target object, which is assumed to exist in the global scope
	 */
	def Iterable<IEObjectDescription> getDuplicates(EObject target) ;
}

class CommonGlobalReferenceFinder implements ICommonGlobalReferenceFinder {

	@Inject
	protected IResourceDescriptions rds

	override Iterable<URI> getEObjectReferences(ComponentClassifier target, EReference ereference,
		String URIExtension) {
		val result = new BasicEList
		for (rd : rds.allResourceDescriptions.filter[d|isURIExtension(d.URI, URIExtension)]) {
			for (reference : rd.referenceDescriptions) {
				val referencetargetURI = reference.targetEObjectUri
				val referencesourceURI = reference.sourceEObjectUri
				if (ereference == reference.EReference && isSameorExtendsURI(target, referencetargetURI)) {
					result += referencesourceURI
				}
			}
		}
		return result
	}

	override Iterable<URI> getEObjectReferences(URI targetURI, EReference ereference, String URIExtension) {
		val result = new BasicEList
		for (rd : rds.allResourceDescriptions.filter[d|isURIExtension(d.URI, URIExtension)]) {
			for (reference : rd.referenceDescriptions) {
				val referencetargetURI = reference.targetEObjectUri
				val referencesourceURI = reference.sourceEObjectUri
				if (ereference == reference.EReference && targetURI == referencetargetURI) {
					result += referencesourceURI
				}
			}
		}
		return result
	}

	private def boolean isURIExtension(URI uri, String URIExtension) {
		URIExtension.equalsIgnoreCase(uri.fileExtension)
	}

	@Inject
	IContainer.Manager manager;

	override Iterable<IEObjectDescription> getEObjectDescriptions(EObject context, EClass eclass, String URIExtension) {
		val result = new ArrayList<IEObjectDescription>
		val IResourceDescription descr = rds.getResourceDescription(context.eResource.getURI());
		if(descr === null) return result
		for (IContainer visibleContainer : manager.getVisibleContainers(descr, rds)) {
			for (IResourceDescription rd : visibleContainer.getResourceDescriptions().filter [ d |
				isURIExtension(d.URI, URIExtension)
			]) {
				result += rd.getExportedObjectsByType(eclass);
			}
		}
		return result
	}

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider ;

	/**
	 * Get all global definitions of objects with the qualified name and the same eClass as target.
	 */
	override Iterable<IEObjectDescription> getDuplicates(EObject target) {
		val res = new Stack<IEObjectDescription>()
		val context = target.eResource();
		if (context === null || context.getResourceSet() === null) {
			return Collections.EMPTY_LIST;
		}
		val qn = qualifiedNameProvider?.getFullyQualifiedName(target)
		if(qn === null) return Collections.EMPTY_LIST;
		val IResourceDescription descr = rds.getResourceDescription(context.getURI());
		if(descr === null) return res
		for (IContainer container : manager.getVisibleContainers(descr, rds)) {
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

}
