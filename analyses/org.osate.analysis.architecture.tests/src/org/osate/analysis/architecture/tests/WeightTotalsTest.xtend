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
		val subsFileName = "subs.aadl"
		val connsFileName = "conns.aadl"
		val sumExceedGrossFileName = "sum_exceed_gross.aadl"
		val grossExceedSumFileName = "gross_exceed_sum.aadl"
		val weightExceedLimitFileName = "weight_exceed_limit.aadl"
		val subLimitExceedLimitFileName = "sublimit_exceed_limit.aadl"
		val weightEqualsLimitFileName = "weight_equals_limit.aadl"
		createFiles(
			subsFileName -> readFile(DIR_NAME + subsFileName),
			connsFileName -> readFile(DIR_NAME + connsFileName),
			sumExceedGrossFileName -> readFile(DIR_NAME + sumExceedGrossFileName),
			grossExceedSumFileName -> readFile(DIR_NAME + grossExceedSumFileName),
			weightExceedLimitFileName -> readFile(DIR_NAME + weightExceedLimitFileName),
			subLimitExceedLimitFileName -> readFile(DIR_NAME + subLimitExceedLimitFileName),
			weightEqualsLimitFileName -> readFile(DIR_NAME + weightEqualsLimitFileName)
		)
		suppressSerialization
		testWeightForFile(subsFileName)
		testWeightForFile(connsFileName)
		testWeightForFile(sumExceedGrossFileName)
		testWeightForFile(grossExceedSumFileName)
		testWeightForFile(weightExceedLimitFileName)
		testWeightForFile(subLimitExceedLimitFileName)
		testWeightForFile(weightEqualsLimitFileName)
	}
	
	/*
	 * Runs the weight analysis on the second classifier in the package which is assumed to be a system
	 * implementation with the name "s1.i1".
	 */
	def private void testWeightForFile(String fileName) {
		testFile(fileName).resource.contents.head as AadlPackage => [
			fileName.subSequence(0, fileName.lastIndexOf(".")).assertEquals(name)
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