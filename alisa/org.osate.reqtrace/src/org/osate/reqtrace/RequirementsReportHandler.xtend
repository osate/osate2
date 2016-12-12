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
		val selectionPath = ((event.currentSelection as IStructuredSelection).firstElement as IFile).fullPath
		val dialog = new RequirementsReportConfigDialog(event.activeShell, EMITTERS.keySet.sort)
		if (dialog.open == Window.OK) {
			Job.create("Generating Report", [
				val factory = Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY) as IReportEngineFactory
				val config = new EngineConfig => [appContext.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.class.classLoader)]
				factory.createReportEngine(config) => [
					val url = '''platform:/plugin/«Activator.PLUGIN_ID»/requirements.rptdesign'''
					val report = openReportDesign(new URL(url).openConnection.inputStream)
					createRunAndRenderTask(report) => [
						setParameterValue("AADLFile", selectionPath.toString)
						setParameterValue("FileType", selectionPath.fileExtension)
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