/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.properties.ui

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.InvocationTargetException
import java.util.List
import java.util.concurrent.atomic.AtomicBoolean
import java.util.stream.Collectors
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.IStartup
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.osate.pluginsupport.PluginSupportUtil
import org.osate.xtext.aadl2.properties.ui.internal.PropertiesActivator

class PropertiesUiStartup implements IStartup {
	override earlyStartup() {
		val pluginResourcesProject = ResourcesPlugin.workspace.root.getProject("Plugin_Resources")
		if (pluginResourcesProject.exists) {
			val shouldMigrate = new AtomicBoolean(false)
			Display.^default.syncExec[shouldMigrate.set(MessageDialog.openQuestion(null, "Workspace Migration",
				"AADL files contributed from plugins are no longer placed into the 'Plugin_Resources' project in the" +
				" workspace. Migration of the workspace involves deleting all unmodified contributed AADL files from" +
				" 'Plugin_Resources' and removing the 'Plugin_Resources' project if it is empty. Do you want the" +
				" workspace to be migrated?"
			))]
			if (shouldMigrate.get) {
				val projectRemains = new AtomicBoolean(false)
				val WorkspaceModifyOperation operation = [monitor |
					setModifiable(pluginResourcesProject)
					deleteUnmodifiedContributed(pluginResourcesProject, PluginSupportUtil.contributedAadl,
						new ResourceSetImpl().URIConverter, monitor
					)
					val visibleMembers = pluginResourcesProject.members.filter[!name.startsWith(".")]
					if (visibleMembers.empty) {
						pluginResourcesProject.delete(true, true, monitor)
					} else {
						projectRemains.set(true)
					}
				]
				try {
					operation.run(null)
					if (projectRemains.get) {
						Display.^default.asyncExec[MessageDialog.openError(null, "Custom Files in 'Plugin_Resources' Project",
							"All of the unmodified contributed AADL files in the 'Plugin_Resources' project have been" +
							" deleted, however some custom files have remained. Please copy these files into a" +
							" separate project and remove them from the 'Plugin_Resources' project."
						)]
					}
				} catch (InvocationTargetException e) {
					logCouldNotDelete(e)
				} catch (InterruptedException e) {
					logCouldNotDelete(e)
				}
			}
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
	
	def private static void deleteUnmodifiedContributed(IContainer container, List<URI> contributedURIs, URIConverter uriConverter, IProgressMonitor monitor) {
		val files = container.members.filter(IFile)
		val aadlFiles = files.filter[!name.startsWith(".") && fileExtension == "aadl"]
		val unmodifiedContributed = aadlFiles.filter[file | contributedURIs.exists[contributedURI |
			uriConverter.createInputStream(contributedURI).convertToString == file.contents.convertToString
		]]
		unmodifiedContributed.forEach[delete(true, true, monitor)]
		
		val folders = container.members.filter(IFolder).filter[!name.startsWith(".")]
		folders.forEach[folder |
			deleteUnmodifiedContributed(folder, contributedURIs, uriConverter, monitor)
			val visibleMembers = folder.members.filter[!name.startsWith(".")]
			if (visibleMembers.empty) {
				folder.delete(true, true, monitor)
			}
		]
	}
	
	def private static String convertToString(InputStream inputStream) {
		val result = new BufferedReader(new InputStreamReader(inputStream)).lines.collect(Collectors.joining)
		inputStream.close
		result
	}
	
	def private static void logCouldNotDelete(Exception e) {
		val status = new Status(IStatus.ERROR, PropertiesActivator.instance.bundle.symbolicName, "Could not delete 'Plugin_Resources' project.", e)
		PropertiesActivator.instance.log.log(status)
	}
}