package org.osate.core.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ThreadImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue929Test extends OsateTest {
	@Test
	def void issue929() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> readFile("org.osate.core.tests/models/issue929/" + pkg1FileName))
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
						assertError(testFileResult.issues, issueCollection, "The source of connection 'conn3' does not match the out flow feature of the preceding subcomponent flow specification 'sub1.f2'")
					]
				]
				ownedFlowImplementations.get(2) => [
					"f3".assertEquals(specification.name)
					ownedFlowSegments.get(2) => [
						"conn4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "The source of connection 'conn4' does not match the out flow feature of the preceding subcomponent flow specification 'sub1.f2'")
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}