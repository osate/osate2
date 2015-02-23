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
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution
import org.eclipse.xtext.builder.impl.ToBeBuilt
import org.eclipse.xtext.ui.resource.IStorage2UriMapper
import org.eclipse.xtext.util.IResourceScopeCache

class AlisaToBeBuiltComputer implements IToBeBuiltComputerContribution {

	@Inject
	private IBuilderState builderState

	@Inject
	private IStorage2UriMapper mapper
	
	override isPossiblyHandled(IStorage storage) {
		isAlisaResource(storage)
	}

	override isRejected(IFolder folder) {
		false
	}

	override removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
	}

	override removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		updateStorage(toBeBuilt, storage, monitor)
	}

	override updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {
	}

	override updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {

		if (isAlisaResource(storage)) {
			val dependencies = new HashMap<URI, HashSet<URI>>

			// direct dependencies
			for (rd : builderState.allResourceDescriptions.filter[d|isAlisaResource(d.URI)]) {
				val sourceURI = rd.URI
				for (reference : rd.referenceDescriptions) {
					val targetURI = reference.targetEObjectUri.trimFragment
					if (isAlisaResource(targetURI)) {
						val deps = dependencies.get(targetURI) ?: new HashSet<URI>
						deps += sourceURI
						if (dependencies.get(targetURI) == null) {
							dependencies.put(targetURI, deps)
						}
					}
				}
			}
			val storageURI = mapper.getUri(storage)
			val deps = newHashSet(storageURI)
			var oldSize = 0

			// transitive
			while (deps.size > oldSize) {
				oldSize = deps.size
				val newDependencies = deps.map([dependencies.get(it) ?: #{}]).flatten.toList
				deps.addAll(newDependencies)
			}
			toBeBuilt.toBeUpdated.addAll(deps)

			System.out.println('\n\n======= ' + storage.name)
			deps.forEach[uri|System.out.println(uri)]
			System.out.println('======= ')

			true
		} else {
			false
		}

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
