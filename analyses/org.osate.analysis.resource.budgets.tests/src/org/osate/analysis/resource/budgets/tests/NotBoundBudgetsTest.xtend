package org.osate.analysis.resource.budgets.tests

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.resource.budgets.handlers.DoResourceBudget
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class NotBoundBudgetsTest extends OsateTest {
	val static DIR_NAME = "org.osate.analysis.resource.budgets.tests/models/Not_Bound_Budgets/"
	
	@Test
	def void testNotBoundBudgets() {
		val fileNames = #[
			"empty",
			"virtual_processors",
			"MIPS_Budget",
			"memories",
			"memory_budget",
			"RAM_Budget",
			"ROM_Budget",
			"inactive_subcomponent",
			"processors"
		].map[it + ".aadl"]
		createFiles(fileNames.map[it -> readFile(DIR_NAME + it)])
		suppressSerialization
		fileNames.forEach[fileName | testFile(fileName).resource.contents.head as AadlPackage => [
			fileName.subSequence(0, fileName.lastIndexOf(".")).assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					val analysis = new DoResourceBudget
					analysis.setErrManager
					analysis.setSummaryReport
					analysis.doAaxlAction(new NullProgressMonitor, it)
				]
			]
		]]
	}
}