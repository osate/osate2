package org.osate.propertiescodegen.ui

import java.io.ByteArrayInputStream
import java.lang.reflect.InvocationTargetException
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.ui.dialogs.ContainerGenerator
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.ui.statushandlers.StatusManager
import org.osate.aadl2.PropertySet
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.propertiescodegen.PropertiesCodeGen

class PropertiesCodeGenHandler extends AbstractHandler {
	override execute(ExecutionEvent event) throws ExecutionException {
		val file = HandlerUtil.getCurrentStructuredSelection(event).firstElement as IFile
		val markers = file.findMarkers(null, true, IResource.DEPTH_ONE)
		if (!markers.exists[it.getAttribute(IMarker.SEVERITY) == IMarker.SEVERITY_ERROR]) {
			val resource = new ResourceSetImpl().getResource(OsateResourceUtil.toResourceURI(file), true)
			val propertySet = resource.contents.head as PropertySet
			val javaFiles = PropertiesCodeGen.generateJava(propertySet)
			val WorkspaceModifyOperation operation = [ monitor |
				val subMonitor = SubMonitor.convert(monitor, "Generating Java Types", javaFiles.size * 2 + 1)
				val folderPath = file.project.fullPath.append("src-gen/" + propertySet.name.toLowerCase)
				val folder = new ContainerGenerator(folderPath).generateContainer(subMonitor.split(1))
				subMonitor.workRemaining = folder.members.size + javaFiles.size
				folder.members.forEach[it.delete(false, subMonitor.split(1))]
				javaFiles.forEach [ javaFile |
					val stream = new ByteArrayInputStream(javaFile.contents.bytes)
					folder.getFile(new Path(javaFile.fileName)).create(stream, false, subMonitor.split(1))
				]
			]
			try {
				HandlerUtil.getActiveWorkbenchWindow(event).run(true, true, operation)
			} catch (InvocationTargetException e) {
				val status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while generating Java Types.",
					e.targetException)
				StatusManager.manager.handle(status, StatusManager.LOG.bitwiseOr(StatusManager.SHOW))
			}
		} else {
			MessageDialog.openError(HandlerUtil.getActiveShell(event),
				"Errors in Property Set", '''Cannot generate Java types for "«file.name»" because it has errors.''')
		}
		null
	}
}
