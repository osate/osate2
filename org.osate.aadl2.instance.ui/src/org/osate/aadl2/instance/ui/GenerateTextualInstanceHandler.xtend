package org.osate.aadl2.instance.ui

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.dialogs.ProgressMonitorDialog
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instance.textual.ui.internal.InstanceActivator

import static extension org.eclipse.emf.ecore.util.EcoreUtil.copy
import static extension org.eclipse.ui.handlers.HandlerUtil.getActiveShell
import static extension org.eclipse.ui.handlers.HandlerUtil.getActiveWorkbenchWindow
import static extension org.eclipse.ui.handlers.HandlerUtil.getCurrentSelection
import static extension org.eclipse.ui.ide.IDE.openEditor

class GenerateTextualInstanceHandler extends AbstractHandler {
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	@Inject
	extension FileExtensionProvider
	
	new() {
		val injector = InstanceActivator.instance.getInjector(InstanceActivator.ORG_OSATE_AADL2_INSTANCE_TEXTUAL_INSTANCE)
		injector.injectMembers(this)
	}
	
	override execute(ExecutionEvent event) throws ExecutionException {
		new ProgressMonitorDialog(event.activeShell).run(true, true, [
			beginTask("Generating Text", 2)
			val sourceFile = (event.currentSelection as IStructuredSelection).firstElement as IFile
			val sourceUri = URI.createPlatformResourceURI(sourceFile.fullPath.toString, false)
			val sourceResource = resourceSetProvider.get.getResource(sourceUri, true)
			
			val destUri = sourceUri.trimFileExtension.appendFileExtension(primaryFileExtension)
			val destResource = resourceSetProvider.get.createResource(destUri)
			destResource.contents += sourceResource.contents.head.copy
			destResource.allContents.filter(ComponentInstance).filter[!(it instanceof SystemInstance) && indices.size == 1 && indices.head == 0L].forEach[indices.clear]
			destResource.save(null)
			worked(1)
			
			if (!canceled) {
				val destFile = sourceFile.workspace.root.getFile(new Path(destUri.toPlatformString(false)))
				event.activeShell.display.syncExec[event.activeWorkbenchWindow.activePage.openEditor(destFile)]
				worked(1)
			}
			done
		])

		null
	}
}