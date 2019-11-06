package org.osate.testsupport

import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.Map
import org.eclipse.birt.core.framework.Platform
import org.eclipse.birt.report.engine.api.EngineConfig
import org.eclipse.birt.report.engine.api.EngineConstants
import org.eclipse.birt.report.engine.api.IReportEngineFactory
import org.eclipse.birt.report.engine.api.RenderOption
import org.junit.Assert

abstract class BIRTTest extends OsateTest {
	val factory = Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY) as IReportEngineFactory
	val config = new EngineConfig => [appContext.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.class.classLoader)]
	
	def void assertReport(String rptdesignUrl, String expectedReport, Map<String, ?> runAndRenderParameters) {
		val output = new ByteArrayOutputStream
		factory.createReportEngine(config) => [
			val report = openReportDesign(new URL(rptdesignUrl).openConnection.inputStream)
			createRunAndRenderTask(report) => [
				parameterValues = runAndRenderParameters
				renderOption = new RenderOption => [
					emitterID = "org.eclipse.birt.report.engine.emitter.html"
					outputStream = output
				]
				run
				close
			]
			destroy
		]
		val actualReport = output.toString
		Assert.assertEquals(expectedReport, actualReport.replaceAll('''AUTOGENBOOKMARK[^"]*''', '').replaceAll('''\p{Alpha}* \d{1,2}, \d{4}.{1,2}\d{1,2}:\d{2} (A|P)M''', ''))
	}
}