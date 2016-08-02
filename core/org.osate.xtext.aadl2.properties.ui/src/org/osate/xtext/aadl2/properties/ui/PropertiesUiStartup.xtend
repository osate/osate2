package org.osate.xtext.aadl2.properties.ui

import java.io.IOException
import java.io.InputStream
import java.lang.reflect.InvocationTargetException
import java.nio.ByteBuffer
import java.nio.channels.Channels
import java.util.Map
import java.util.Optional
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.IStartup
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.pluginsupport.PluginSupportUtil
import org.osate.xtext.aadl2.properties.ui.internal.PropertiesActivator

class PropertiesUiStartup implements IStartup {
	override earlyStartup() {
		val AtomicBoolean projectRemains = new AtomicBoolean(false)
		val WorkspaceModifyOperation operation = [monitor |
			val pluginResourcesProject = ResourcesPlugin.workspace.root.getProject("Plugin_Resources")
			if (pluginResourcesProject.exists) {
				setModifiable(pluginResourcesProject)
				val contributedPaths = newHashMap(PluginSupportUtil.contributedAadl.map[uri |
					val index = PluginSupportUtil.getFirstSignificantIndex(uri)
					val path = if (index.present) {
						Optional.of(uri.segmentsList.subList(index.asInt, uri.segmentCount).join("/"))
					} else {
						Optional.empty
					}
					path -> uri
				].filter[key.present].map[key.get -> value])
				deleteUnmodifiedContributed(pluginResourcesProject, contributedPaths, OsateResourceUtil.createResourceSet.URIConverter, monitor)
				val visibleMembers = pluginResourcesProject.members.filter[!name.startsWith(".")]
				if (visibleMembers.empty) {
					pluginResourcesProject.delete(true, true, monitor)
				} else {
					projectRemains.set(true)
				}
			}
		]
		try {
			operation.run(null)
			if (projectRemains.get) {
				Display.^default.asyncExec[MessageDialog.openError(null, "Custom Files in 'Plugin_Resources' Project",
					"AADL files contributed from plugins are no longer placed into the 'Plugin_Resources' project in" +
					" the workspace. All of the unmodified contributed AADL files in the 'Plugin_Resources' project" +
					" have been deleted, however some custom files have remained. Please copy these files into a" +
					" separate project and remove them from the 'Plugin_Resources' project."
				)]
			}
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
	
	def private static void deleteUnmodifiedContributed(IContainer container, Map<String, URI> contributedPaths, URIConverter uriConverter, IProgressMonitor monitor) {
		val files = container.members.filter(IFile)
		val contributed = files.filter[contributedPaths.containsKey(projectRelativePath.toString)]
		val unmodified = contributed.filter[file |
			val contributedStream = uriConverter.createInputStream(contributedPaths.get(file.projectRelativePath.toString))
			val fileStream = file.contents
			contributedStream == fileStream
		]
		unmodified.forEach[delete(true, true, monitor)]

		val folders = container.members.filter(IFolder).filter[!name.startsWith(".")]
		folders.forEach[folder |
			deleteUnmodifiedContributed(folder, contributedPaths, uriConverter, monitor)
			val visibleMembers = folder.members.filter[!name.startsWith(".")]
			if (visibleMembers.empty) {
				folder.delete(true, true, monitor)
			}
		]
	}
	
	//Copied from http://stackoverflow.com/questions/4245863/fast-way-to-compare-inputstreams
	def private static boolean operator_equals(InputStream i1, InputStream i2) throws IOException {
		val ch1 = Channels.newChannel(i1)
		val ch2 = Channels.newChannel(i2)
		
		val buf1 = ByteBuffer.allocateDirect(1024)
		val buf2 = ByteBuffer.allocateDirect(1024)
		
		try {
			while (true) {
				val n1 = ch1.read(buf1)
				val n2 = ch2.read(buf2)
				
				if (n1 == -1 || n2 == -1) {
					return n1 == n2
				}
				
				buf1.flip
				buf2.flip
				
				for (var i = 0; i < Math.min(n1, n2); i++) {
					if (buf1.get != buf2.get) {
						return false
					}
				}
				
				buf1.compact
				buf2.compact
			}
		} finally {
			i1.close
			i2.close
		}
	}
}