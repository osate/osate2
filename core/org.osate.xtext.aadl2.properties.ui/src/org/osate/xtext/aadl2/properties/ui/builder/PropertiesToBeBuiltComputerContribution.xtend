package org.osate.xtext.aadl2.properties.ui.builder

import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IStorage
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution
import org.eclipse.xtext.builder.impl.ToBeBuilt
import org.osate.pluginsupport.PluginSupportUtil
import org.osate.pluginsupport.PredeclaredProperties

class PropertiesToBeBuiltComputerContribution implements IToBeBuiltComputerContribution {
	override removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) {
	}
	
	override updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException {
		toBeBuilt.toBeUpdated += PredeclaredProperties.visibleContributedResources
	}
	
	override removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		false
	}
	
	override updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor) {
		false
	}
	
	override isPossiblyHandled(IStorage storage) {
		storage.fullPath.fileExtension == "aadl"
	}
	
	override isRejected(IFolder folder) {
		false
	}
}