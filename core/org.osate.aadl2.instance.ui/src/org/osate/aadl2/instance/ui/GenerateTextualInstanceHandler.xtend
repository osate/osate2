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