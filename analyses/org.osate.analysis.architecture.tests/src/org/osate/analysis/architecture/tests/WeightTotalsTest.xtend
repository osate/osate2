package org.osate.analysis.architecture.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.architecture.PropertyTotals
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.osate.testsupport.ResultHelper.*

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.instantiate

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class WeightTotalsTest {
	val static DIR_NAME = "org.osate.analysis.architecture.tests/models/WeightTotals/"
	
	val static generate = false
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
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
		]
		fileNames.forEach[fileName |
			testHelper.parseFile(DIR_NAME + fileName + ".aadl") => [
				fileName.assertEquals(name)
				publicSection.ownedClassifiers.get(1) as SystemImplementation => [
					"s1.i1".assertEquals(name)
					instantiate => [
						"s1_i1_Instance".assertEquals(name)
						
						val actual = PropertyTotals.invoke(it)
						
						val resultPath = '''«DIR_NAME»results/«fileName».result'''
						generateOrAssert(generate, resultPath,actual)
					]
				]
			]
		]
	}
}