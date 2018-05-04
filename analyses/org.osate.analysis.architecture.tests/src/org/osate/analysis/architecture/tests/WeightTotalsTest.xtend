package org.osate.analysis.architecture.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.architecture.handlers.DoPropertyTotals
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class WeightTotalsTest extends OsateTest {
	val static DIR_NAME = "org.osate.analysis.architecture.tests/models/WeightTotals/"
	
	@Test
	def void testWeightTotals() {
		val fileNames = #[
			"subs",
			"conns",
			"sum_exceed_gross",
			"gross_exceed_sum",
			"weight_exceed_limit",
			"sublimit_exceed_limit",
			"weight_equals_limit"
		].map[it + ".aadl"]
		createFiles(fileNames.map[it -> readFile(DIR_NAME + it)])
		suppressSerialization
		fileNames.forEach[fileName | testFile(fileName).resource.contents.head as AadlPackage => [
			fileName.subSequence(0, fileName.lastIndexOf(".")).assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val analysis = new DoPropertyTotals
					analysis.setErrManager
					analysis.doAaxlAction(new NullProgressMonitor, it)
				]
			]
		]]
	}
}