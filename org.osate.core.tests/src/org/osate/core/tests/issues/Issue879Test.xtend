package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import org.osate.aadl2.SystemImplementation
import com.itemis.xtext.testing.FluentIssueCollection

import static extension org.junit.Assert.assertEquals

import org.osate.aadl2.FlowImplementation

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

	val static WARNING_FLOW_EMPTY = "Flow implementation is empty and does not add value to the model"
	
	val static S_I = "S.i"
	val static S_J = "S.j"
	val static S_K = "S.k"
	
	val static MY_SOURCE = "mySrc"
	val static MY_SINK = "mySink"
	val static MY_PATH = "myPath"
	
	@Test
	def void test1() {
		val testFileResult = loadFile(FILE1, PROJECT_LOCATION + FILE1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"simple".assertEquals(name)
			
			publicSection.ownedClassifiers.findFirst[name == S_I] as SystemImplementation => [
				assertError(testFileResult.issues, issueCollection, ERROR_NO_SINK1, ERROR_NO_SRC1, ERROR_NO_PATH1)
			]			

			publicSection.ownedClassifiers.findFirst[name == S_J] as SystemImplementation => [
				ownedFlowImplementations.findFirst[specification.name == MY_SOURCE] as FlowImplementation => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
				ownedFlowImplementations.findFirst[specification.name == MY_SINK] as FlowImplementation => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
				ownedFlowImplementations.findFirst[specification.name == MY_PATH] as FlowImplementation => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
			]			
			
			publicSection.ownedClassifiers.findFirst[name == S_K] as SystemImplementation => [
				assertError(testFileResult.issues, issueCollection, ERROR_NO_SINK2, ERROR_NO_SRC2)
				
				ownedFlowImplementations.findFirst[specification.name == MY_PATH] as FlowImplementation => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
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
}
