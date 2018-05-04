package org.osate.core.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SubprogramType
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue910Test extends OsateTest {
	@Test
	def void issue910() {
		val pkgFileName = "issue910.aadl"
		createFiles(pkgFileName -> readFile("org.osate.core.tests/models/issue910/" + pkgFileName))
		suppressSerialization
		val testFileResult = testFile(pkgFileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"Issue910".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as SubprogramType => [
				"sp".assertEquals(name)
				ownedEventPorts.get(0) => [
					"e1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Subprograms can only have out ports.")
				]
				ownedEventPorts.get(1) => [
					"e2".assertEquals(name)
				]
				ownedEventPorts.get(2) => [
					"e3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Subprograms can only have out ports.")
				]
				ownedEventDataPorts.get(0) => [
					"ed1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Subprograms can only have out ports.")
				]
				ownedEventDataPorts.get(1) => [
					"ed2".assertEquals(name)
				]
				ownedEventDataPorts.get(2) => [
					"ed3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Subprograms can only have out ports.")
				]
			]
		]
		issueCollection.sizeIs(4)
		assertConstraints(issueCollection)
	}
}