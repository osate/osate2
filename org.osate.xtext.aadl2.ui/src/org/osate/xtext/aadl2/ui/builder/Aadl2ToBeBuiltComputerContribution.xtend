package org.osate.xtext.aadl2.ui.builder

import com.google.inject.Inject
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution
import org.eclipse.xtext.ui.resource.IStorage2UriMapper
import org.eclipse.xtext.builder.impl.ToBeBuilt
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.resources.IStorage
import org.eclipse.core.resources.IFolder

class Aadl2ToBeBuiltComputerContribution implements IToBeBuiltComputerContribution {
	@Inject IStorage2UriMapper mapper
	
	override removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
	}
	
	override updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {
	}
	
	override removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		false
	}
	
	override updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		false
	}
	
	override isPossiblyHandled(IStorage storage) {
		mapper.getUri(storage).fileExtension == "aadl"
	}
	
	override isRejected(IFolder folder) {
		false
	}
}