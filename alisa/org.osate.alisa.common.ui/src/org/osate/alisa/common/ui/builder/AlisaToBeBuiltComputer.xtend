package org.osate.alisa.common.ui.builder

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IStorage
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.builder.builderState.IBuilderState
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
		#{'cat', 'org', 'verify', 'reqspec', 'alisa', 'aadl'}.contains(ext)
	}

}
