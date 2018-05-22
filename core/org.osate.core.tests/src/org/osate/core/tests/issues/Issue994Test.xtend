package org.osate.core.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ThreadImplementation
import org.osate.testsupport.Aadl2UiInjectorProvider
import org.osate.testsupport.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue994Test extends OsateTest {
	@Test
	def void issue994() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> readFile("org.osate.core.tests/models/issue994/" + pkg1FileName))
		suppressSerialization
		val testFileResult = testFile(pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as ThreadImplementation => [
				"t1.impl".assertEquals(name)
				ownedFlowImplementations.get(1) => [
					"f2".assertEquals(specification.name)
					ownedFlowSegments.get(2) => [
						"conn3".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "The source of connection 'conn3' does not match the preceding subcomponent 'sub1'")
					]
				]
				ownedFlowImplementations.get(2) => [
					"f3".assertEquals(specification.name)
					ownedFlowSegments.get(2) => [
						"conn4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "The source of connection 'conn4' does not match the preceding subcomponent 'sub1'")
					]
				]
				ownedFlowImplementations.get(3) => [
					"f4".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"conn5".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "The destination component 'call2' of connection 'conn5' does not match the succeeding subcomponent  'sub1'")
					]
				]
				ownedFlowImplementations.get(4) => [
					"f5".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"conn6".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "The destination component 'call3' of connection 'conn6' does not match the succeeding subcomponent  'sub1'")
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}