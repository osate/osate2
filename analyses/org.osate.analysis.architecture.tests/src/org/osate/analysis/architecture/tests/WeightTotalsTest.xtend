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
	@Test
	def void testWeightTotals() {
		val subsFileName = "subs.aadl"
		createFiles(subsFileName -> readFile("org.osate.analysis.architecture.tests/models/WeightTotals/" + subsFileName))
		suppressSerialization
		testFile(subsFileName).resource.contents.head as AadlPackage => [
			"subs".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val dpt = new DoPropertyTotals
					dpt.initializeAction(elementRoot)
					dpt.setErrManager
					dpt.doAaxlAction(new NullProgressMonitor, it)
				]
			]
		]
	}
}