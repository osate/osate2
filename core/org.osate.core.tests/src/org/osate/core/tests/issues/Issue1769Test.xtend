package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ReferenceValue
import org.osate.aadl2.SystemImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1769Test extends XtextTest {
	val static PATH = "org.osate.core.tests/models/issue1769/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue1769() {
		val testFileResult = issues = testHelper.testFile(PATH + "reference_arrays.aadl", PATH + "ps1.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"reference_arrays".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i".assertEquals(name)
				ownedPropertyAssociations.get(3) => [
					"def4".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "'m1' is not an array")
					]
				]
				ownedPropertyAssociations.get(4) => [
					"def5".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "'sub2' is not an array")
					]
				]
				ownedPropertyAssociations.get(5) => [
					"def6".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Too few array dimensions: 'sub1' has 2")
					]
				]
				ownedPropertyAssociations.get(6) => [
					"def7".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.get(2) => [
						assertError(testFileResult.issues, issueCollection, "Too many array dimensions: 'sub1' has 2")
					]
				]
				ownedPropertyAssociations.get(7) => [
					"def8".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Array indices start at 1")
					]
				]
				ownedPropertyAssociations.get(8) => [
					"def9".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Index is greater than array size 5")
					]
				]
				ownedPropertyAssociations.get(9) => [
					"def10".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Array indices start at 1")
					]
				]
				ownedPropertyAssociations.get(10) => [
					"def11".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Upper bound is greater than array size 5")
					]
				]
				ownedPropertyAssociations.get(11) => [
					"def12".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection,
							"Array indices start at 1",
							"Upper bound is greater than array size 5"
						)
					]
				]
				ownedPropertyAssociations.get(12) => [
					"def13".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Range lower bound is greater than upper bound")
					]
				]
				ownedPropertyAssociations.get(13) => [
					"def14".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Index is greater than array size 5")
					]
				]
				ownedPropertyAssociations.get(14) => [
					"def15".assertEquals(property.name)
					(ownedValues.head.ownedValue as ReferenceValue).path.arrayRanges.head => [
						assertError(testFileResult.issues, issueCollection, "Upper bound is greater than array size 5")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}