package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*
import org.osate.aadl2.SystemImplementation
import com.itemis.xtext.testing.FluentIssueCollection

import static extension org.junit.Assert.assertEquals
import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI

import org.osate.aadl2.ThreadImplementation
import org.eclipse.emf.ecore.EObject
import java.util.List
import org.eclipse.xtext.validation.Issue

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue879Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue879/"
	val static FILE1 = "simple.aadl"
	
	val static ERROR_NO_SINK1 = "Component implementation 'S.i' does not implement the flow specification 'mySink' from component type 'S'"
	val static ERROR_NO_SRC1 = "Component implementation 'S.i' does not implement the flow specification 'mySrc' from component type 'S'"
	val static ERROR_NO_PATH1 = "Component implementation 'S.i' does not implement the flow specification 'myPath' from component type 'S'"

	val static ERROR_NO_SINK2 = "Component implementation 'S.k' does not implement the flow specification 'mySink' from component type 'S'"
	val static ERROR_NO_SRC2 = "Component implementation 'S.k' does not implement the flow specification 'mySrc' from component type 'S'"

	@Test
	def void test1() {
		val testFileResult = loadFile(FILE1, PROJECT_LOCATION + FILE1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"simple".assertEquals(name)
			
			publicSection.ownedClassifiers.findFirst[name == "S.i"] as SystemImplementation => [
				assertError(testFileResult.issues, issueCollection, ERROR_NO_SINK1, ERROR_NO_SRC1, ERROR_NO_PATH1)
			]			
			
			publicSection.ownedClassifiers.findFirst[name == "S.k"] as SystemImplementation => [
				assertError(testFileResult.issues, issueCollection, ERROR_NO_SINK2, ERROR_NO_SRC2)
			]			
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}

	private def FluentIssueCollection loadFile(String fname, String path) {
		createFiles(fname -> readFile(path))
		ignoreSerializationDifferences
		testFile(fname)
	}

	def protected static assertNoIssues(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection) {
		val issuesForEObject = allIssues.filter[uriToProblem == eObject.URI]
		assertTrue(issuesForEObject.isEmpty)
	}
}
