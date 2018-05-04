package org.osate.analysis.resource.budgets.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.resource.budgets.handlers.DoBoundSwitchBandWidthAnalysis
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class BandwidthTest extends OsateTest {
	val static DIR_NAME = "org.osate.analysis.resource.budgets.tests/models/Bandwidth/"
	
	@Test
	def void testBandwidth() {
		val fileNames = #[
			"missing_reference_processor",
			"broadcast",
			"no_capacity_but_bound",
			"capacity",
			"capacity_and_bound",
			"modal",
			"connection_budget",
			"actual_only",
			"connection_not_active",
			"broadcast_with_connection",
			"source_not_feature"
		].map[it + ".aadl"]
		createFiles(fileNames.map[it -> readFile(DIR_NAME + it)])
		suppressSerialization
		fileNames.forEach[fileName | testFile(fileName).resource.contents.head as AadlPackage => [
			fileName.subSequence(0, fileName.lastIndexOf(".")).assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val dbsba = new DoBoundSwitchBandWidthAnalysis
					dbsba.setErrManager
					dbsba.setSummaryReport
					dbsba.doAaxlAction(new NullProgressMonitor, it)
				]
			]
		]]
	}
}