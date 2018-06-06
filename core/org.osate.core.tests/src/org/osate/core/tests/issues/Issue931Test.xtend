package org.osate.core.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.NamedElement
import org.osate.testsupport.Aadl2UiInjectorProvider
import org.osate.testsupport.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue931Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue931/"

	@Test
	def void issue931() {
		val pkg1FileName = "issue931.aadl"
		createFiles(
			pkg1FileName -> readFile(PROJECT_LOCATION + pkg1FileName)
		)
		suppressSerialization
		val testFileResult = testFile(pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		issueCollection.isEmpty.assertEquals(true)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue931".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as NamedElement => [
				"s".assertEquals(name)
			]
		]
	}
}
