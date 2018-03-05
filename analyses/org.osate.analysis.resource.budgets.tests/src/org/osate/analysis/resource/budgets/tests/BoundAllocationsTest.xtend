package org.osate.analysis.resource.budgets.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.resource.budgets.handlers.DoBoundResourceAnalysis
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class BoundAllocationsTest extends OsateTest {
	val static DIR_NAME = "org.osate.analysis.resource.budgets.tests/models/Bound_Allocations/"
	
	@Test
	def void testBoundAllocations() {
		val fileNames = #[
			"empty.aadl",
			"processors.aadl",
			"virtual_processors.aadl",
			"bound_processor.aadl",
			"bound_virtual_processors.aadl",
			"hardware_bound_to_processor.aadl",
			"bound_with_subcomponents.aadl",
			"top_system_bound.aadl",
			"exceed_budget.aadl",
			"below_budget.aadl",
			"memories.aadl",
			"bound_memory.aadl",
			"rom_budget.aadl"
		]
		createFiles(fileNames.map[it -> readFile(DIR_NAME + it)])
		suppressSerialization
		fileNames.forEach[fileName |
			testFile(fileName).resource.contents.head as AadlPackage => [
				fileName.subSequence(0, fileName.lastIndexOf(".")).assertEquals(name)
				publicSection.ownedClassifiers.get(1) as SystemImplementation => [
					"s1.i1".assertEquals(name)
					buildInstanceModelFile => [
						"s1_i1_Instance".assertEquals(name)
						val drb = new DoBoundResourceAnalysis
						drb.setErrManager
						drb.setSummaryReport
						drb.doAaxlAction(new NullProgressMonitor, it)
					]
				]
			]
		]
	}
}