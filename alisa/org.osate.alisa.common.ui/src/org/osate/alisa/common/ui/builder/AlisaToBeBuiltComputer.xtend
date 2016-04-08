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

package org.osate.alisa.common.ui.builder

import com.google.inject.Inject
import java.util.HashMap
import java.util.HashSet
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IStorage
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.builderState.IBuilderState
import org.eclipse.xtext.builder.clustering.CopiedResourceDescription
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution
import org.eclipse.xtext.builder.impl.ToBeBuilt
import org.eclipse.xtext.ui.resource.IStorage2UriMapper

class AlisaToBeBuiltComputer implements IToBeBuiltComputerContribution {

	@Inject
	protected IBuilderState builderState

	@Inject
	protected IStorage2UriMapper mapper
	
//	@Inject
//	private DependencyCache dependencyCache
//	
//	@Singleton
//	public static class DependencyCache {
//		protected Map<URI, Set<URI>> storageToDependencies = newHashMap;
//	}

	override removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
	}

	override updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {
	}

	override removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		if (isAlisaResource(storage)) {
			toBeBuilt.toBeUpdated.addAll(storage.dependencies)
			toBeBuilt.toBeDeleted.add(mapper.getUri(storage))
			true
		} else {
			false
		}
	}

	override updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		if (isAlisaResource(storage)) {
			toBeBuilt.toBeUpdated.addAll(storage.dependencies)
			toBeBuilt.toBeUpdated.add(mapper.getUri(storage))
			true
		} else {
			false
		}
	}

	override isPossiblyHandled(IStorage storage) {
		isAlisaResource(storage)
	}

	override isRejected(IFolder folder) {
		false
	}

	private def dependencies(IStorage storage) {
		val depCache = new HashMap<URI, HashSet<URI>>

		// direct dependencies
		for (rd : builderState.allResourceDescriptions.filter[d|isAlisaResource(d.URI)]) {
			val sourceURI = rd.URI
			// added this check - otherwise I was getting IllegalStateException at org.eclipse.xtext.builder.clustering.CopiedResourceDescription.getReferenceDescriptions(CopiedResourceDescription.java:82) 
			if (!(rd instanceof CopiedResourceDescription)){
			for (reference : rd.referenceDescriptions) {
				val targetURI = reference.targetEObjectUri.trimFragment
				if (isAlisaResource(targetURI)) {
					val deps = depCache.get(targetURI) ?: new HashSet<URI>
					deps += sourceURI
					if (depCache.get(targetURI) == null) {
						depCache.put(targetURI, deps)
					}
				}
			}
			}
		}

		val deps = new HashSet<URI>
		val uri = mapper.getUri(storage)

		if (uri != null) {
			deps += depCache.get(uri) ?: #{}
			var changed = !deps.isEmpty

			while (changed) {
				val newDependencies = deps.map([depCache.get(it) ?: #{}]).flatten.toList
				changed = deps += newDependencies
			}
		}
//		System.out.println('\n\nDependencies added for ' + storage.name)
//		deps.forEach[System.out.println(it)]
//		System.out.println('======= ')
		deps
	}

	private def boolean isAlisaResource(IStorage storage) {
		val uri = mapper.getUri(storage)
		if (uri != null)
			isAlisaResource(uri)
		else
			false
	}

	private def boolean isAlisaResource(URI uri) {
		isAlisaResource(uri.fileExtension)
	}

	def boolean isAlisaResource(String ext) {
		#{'cat', 'filter', 'org', 'verify', 'methodregistry', 'constants','goals', 'goaldoc', 'reqspec', 'reqdoc', 'alisa', 'aadl'}.contains(ext)
	}

}
