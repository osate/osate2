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
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.window.Window
import org.eclipse.ui.ide.IDE

import static extension org.eclipse.ui.handlers.HandlerUtil.getActiveShell
import static extension org.eclipse.ui.handlers.HandlerUtil.getActiveWorkbenchWindow
import static extension org.eclipse.ui.handlers.HandlerUtil.getCurrentSelection

class RequirementsTracingHandler extends AbstractHandler {
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
		val selectionPath = ((event.currentSelection as IStructuredSelection).firstElement as IFile).fullPath
		val fileType = switch selectionPath.fileExtension {
			case "aadl": "package"
			case "aaxl2",
			case "aail2": "instance"
			default: selectionPath.fileExtension
		}
		val dialog = new ReqTraceConfigDialog(event.activeShell, EMITTERS.keySet.sort, fileType)
		if (dialog.open == Window.OK) {
			Job.create("Generating Report", [
				val factory = Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY) as IReportEngineFactory
				val config = new EngineConfig => [appContext.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.class.classLoader)]
				factory.createReportEngine(config) => [
					val url = '''platform:/plugin/«Activator.PLUGIN_ID»/reqtrace.rptdesign'''
					val report = openReportDesign(new URL(url).openConnection.inputStream)
					createRunAndRenderTask(report) => [
						setParameterValue("ProjectName", selectionPath.segments.head)
						setParameterValue("Directories", selectionPath.removeFirstSegments(1).removeLastSegments(1).toString)
						setParameterValue("FileName", selectionPath.lastSegment)
						
						setParameterValue("AADLFile", selectionPath.toString)
						setParameterValue("FileType", fileType)
						setParameterValue("ReportType", dialog.reportType)
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