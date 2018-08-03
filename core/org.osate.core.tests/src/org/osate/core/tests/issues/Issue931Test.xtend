package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.NamedElement
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue931Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue931/"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue931() {
		val pkg1FileName = "issue931.aadl"
		val testFileResult = testHelper.testFile(PROJECT_LOCATION + pkg1FileName)
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
