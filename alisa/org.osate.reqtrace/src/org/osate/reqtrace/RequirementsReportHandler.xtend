/**
 * <copyright>
 * Copyright 2016 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract FA8721-05-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */

package org.osate.reqtrace

import java.net.URL
import org.eclipse.birt.core.framework.Platform
import org.eclipse.birt.report.engine.api.EngineConfig
import org.eclipse.birt.report.engine.api.EngineConstants
import org.eclipse.birt.report.engine.api.IReportEngineFactory
import org.eclipse.birt.report.engine.api.RenderOption
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.filesystem.EFS
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.window.Window
import org.eclipse.ui.ide.IDE
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.modelsupport.EObjectURIWrapper

import static extension org.eclipse.ui.handlers.HandlerUtil.getActiveShell
import static extension org.eclipse.ui.handlers.HandlerUtil.getActiveWorkbenchWindow
import static extension org.eclipse.ui.handlers.HandlerUtil.getCurrentSelection

class RequirementsReportHandler extends AbstractHandler {
	val static EMITTERS_TO_IGNORE = #{"uk.co.spudsoft.birt.emitters.excel.XlsEmitter",
		"org.eclipse.birt.report.engine.emitter.postscript",
		"org.eclipse.birt.report.engine.emitter.ppt",
		"org.eclipse.birt.report.engine.emitter.prototype.excel",
		"org.eclipse.birt.report.engine.emitter.word"
	}
	val static EMITTERS = newHashMap(Platform.extensionRegistry.getExtensionPoint("org.eclipse.birt.report.engine.emitters").extensions.map[
		configurationElements.filter[name == "emitter"].map[getAttribute("format") -> getAttribute("id")]
	].flatten.filter[!EMITTERS_TO_IGNORE.contains(value)])
	
	override execute(ExecutionEvent event) throws ExecutionException {
		var IPath path = null
		val selectedObjectAndType = switch selectedObject : (event.currentSelection as IStructuredSelection).firstElement {
			IFile: {
					path = selectedObject.fullPath;
					selectedObject.fullPath -> selectedObject.fileExtension
				}
			ComponentClassifier: selectedObject -> "Classifier"
			EObjectURIWrapper: {
				val eObject = new ResourceSetImpl().getEObject(selectedObject.uri, true) as ComponentClassifier
				eObject -> "Classifier"
			}
		}
		
		val dialog = new RequirementsReportConfigDialog(event.activeShell, EMITTERS.keySet.sort)
		if (dialog.open == Window.OK) {
			val selectionPath = path
			Job.create("Generating Report", [
				val factory = Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY) as IReportEngineFactory
				val config = new EngineConfig => [appContext.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.class.classLoader)]
				factory.createReportEngine(config) => [
					val url = '''platform:/plugin/«Activator.PLUGIN_ID»/requirements.rptdesign'''
					val report = openReportDesign(new URL(url).openConnection.inputStream)
					createRunAndRenderTask(report) => [
						if (selectionPath !== null) {
							setParameterValue("ProjectName", selectionPath.segments.head)
							setParameterValue("Directories", selectionPath.removeFirstSegments(1).removeLastSegments(1).toString)
							setParameterValue("FileName", selectionPath.lastSegment)
						}
						setParameterValue("selectedObject", selectedObjectAndType.key)
						setParameterValue("selectionType", selectedObjectAndType.value)
						renderOption = new RenderOption => [
							val file = dialog.outputFile
							emitterID = EMITTERS.get(file.substring(file.lastIndexOf(".") + 1))
							outputFileName = file
						]
						run
						close
					]
					destroy
				]
				if (!canceled && dialog.openFileAutomatically) {
					val fileStore = EFS.localFileSystem.getStore(new Path(dialog.outputFile))
					event.activeShell.display.asyncExec[
						IDE.openEditorOnFileStore(event.activeWorkbenchWindow.activePage, fileStore)
					]
				}
				if (canceled) {
					Status.CANCEL_STATUS
				} else {
					Status.OK_STATUS
				}
			]).schedule
		}
		null
	}
}