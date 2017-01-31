package org.osate.reqtrace.tests

import java.net.URL
import java.util.Map
import org.eclipse.birt.core.framework.Platform
import org.eclipse.birt.report.engine.api.EngineConfig
import org.eclipse.birt.report.engine.api.EngineConstants
import org.eclipse.birt.report.engine.api.IReportEngineFactory
import org.eclipse.birt.report.engine.api.RenderOption
import org.eclipse.core.resources.IResource
import org.eclipse.xtext.util.Files
import org.junit.Assert
import org.osate.core.test.OsateTest

abstract class ReqtraceTest extends OsateTest {
	val static reportResultFileName = "reportResult.html"
	
	val factory = Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY) as IReportEngineFactory
	val config = new EngineConfig => [appContext.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.class.classLoader)]
	
	def void assertReport(String rptdesignUrl, String expectedReport, Map<String, ?> runAndRenderParameters) {
		factory.createReportEngine(config) => [
			val report = openReportDesign(new URL(rptdesignUrl).openConnection.inputStream)
			createRunAndRenderTask(report) => [
				parameterValues = runAndRenderParameters
				renderOption = new RenderOption => [
					emitterID = "org.eclipse.birt.report.engine.emitter.html"
					outputFileName = workspaceRoot.getProject(projectName).location.append(reportResultFileName).toOSString
				]
				run
				close
			]
			destroy
		]
		workspaceRoot.refreshLocal(IResource.DEPTH_INFINITE, null)
		val actualReport = Files.readStreamIntoString(workspaceRoot.getProject(projectName).getFile(reportResultFileName).contents)
		Assert.assertEquals(expectedReport, actualReport.replaceAll('AUTOGENBOOKMARK[^"]*', "").replaceAll("\\p{Alpha}* \\d{1,2}, \\d{4}, \\d{1,2}:\\d{2} (A|P)M", ""))
	}
}