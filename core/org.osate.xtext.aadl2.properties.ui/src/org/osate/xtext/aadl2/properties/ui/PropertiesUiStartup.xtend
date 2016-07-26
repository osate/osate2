package org.osate.xtext.aadl2.properties.ui

import java.lang.reflect.InvocationTargetException
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.ui.IStartup
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.osate.xtext.aadl2.properties.ui.internal.PropertiesActivator

class PropertiesUiStartup implements IStartup {
	override earlyStartup() {
		val WorkspaceModifyOperation operation = [monitor |
			val pluginResourcesProject = ResourcesPlugin.workspace.root.getProject("Plugin_Resources")
			if (pluginResourcesProject.exists) {
				setModifiable(pluginResourcesProject)
				pluginResourcesProject.delete(true, true, monitor)
			}
		]
		try {
			operation.run(null)
		} catch (InvocationTargetException e) {
			PropertiesActivator.instance.log.log(new Status(IStatus.ERROR, PropertiesActivator.instance.bundle.symbolicName, "Could not delete 'Plugin_Resources' project.", e))
		} catch (InterruptedException e) {
			PropertiesActivator.instance.log.log(new Status(IStatus.ERROR, PropertiesActivator.instance.bundle.symbolicName, "Could not delete 'Plugin_Resources' project.", e))
		}
	}
	
	def private static void setModifiable(IContainer container) {
		container.members.forEach[member |
			val attributes = member.resourceAttributes
			if (attributes.readOnly) {
				attributes.readOnly = false
				member.resourceAttributes = attributes
			}
			
			if (member instanceof IContainer) {
				setModifiable(member)
			}
		]
	}
}