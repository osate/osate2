package org.osate.propertiescodegen.ui

import java.io.ByteArrayInputStream
import java.lang.reflect.InvocationTargetException
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.ui.dialogs.ContainerGenerator
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.ui.statushandlers.StatusManager
import org.osate.aadl2.PropertySet
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.propertiescodegen.PropertiesCodeGen
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage

class PropertiesCodeGenHandler extends AbstractHandler {
	override execute(ExecutionEvent event) throws ExecutionException {
		switch selection : HandlerUtil.getCurrentStructuredSelection(event).firstElement {
			ContributedAadlStorage: generate(selection.uri, selection.project, event)
			IFile: {
				val markers = selection.findMarkers(null, true, IResource.DEPTH_ONE)
				if (!markers.exists[it.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR]) {
					generate(OsateResourceUtil.toResourceURI(selection), selection.project, event)
				} else {
					MessageDialog.openError(
						HandlerUtil.getActiveShell(event),
						"Errors in Property Set",
						'''Cannot generate Java property getters for "«selection.name»" because it has errors.'''
					)
				}
			}
		}
		null
	}
	
	def private static void generate(URI propertySetURI, IProject project, ExecutionEvent event) {
		val resource = new ResourceSetImpl().getResource(propertySetURI, true)
		val propertySet = resource.contents.head as PropertySet
		val generatedPackage = PropertiesCodeGen.generateJava(propertySet)
		val javaFiles = generatedPackage.classes
		val WorkspaceModifyOperation operation = [ monitor |
			val subMonitor = SubMonitor.convert(monitor, "Generating Java Property Getters", javaFiles.size * 2 + 1)
			val folderPath = project.fullPath.append(generatedPackage.packagePath)
			val folder = new ContainerGenerator(folderPath).generateContainer(subMonitor.split(1))
			subMonitor.workRemaining = folder.members.size + javaFiles.size
			javaFiles.forEach [ javaFile |
				val stream = new ByteArrayInputStream(javaFile.contents.bytes)
				val file = folder.getFile(new Path(javaFile.fileName))
				if (file.exists) {
					file.setContents(stream, false, true, subMonitor.split(1))
				} else {
					file.create(stream, false, subMonitor.split(1))
				}
			]
		]
		try {
			HandlerUtil.getActiveWorkbenchWindow(event).run(true, true, operation)
		} catch (InvocationTargetException e) {
			val status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while generating Java property getters.",
				e.targetException)
			StatusManager.manager.handle(status, StatusManager.LOG.bitwiseOr(StatusManager.SHOW))
		}
	}
}