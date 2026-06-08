/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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