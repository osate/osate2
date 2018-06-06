package org.osate.core.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2UiInjectorProvider
import org.osate.testsupport.OsateTest

import static extension org.junit.Assert.*
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.convertToIResource

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue879Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue879/"
	val static FILE1 = "simple.aadl"
	val static FILE2 = "pkg1.aadl"
	val static FILE3 = "pkg2.aadl"
	
	val static WARNING_FLOW_EMPTY = "Flow implementation is empty and does not add value to the model"
	
	val static S_J = "S.j"
	val static S_K = "S.k"
	
	val static MY_SOURCE = "mySrc"
	val static MY_SINK = "mySink"
	val static MY_PATH = "myPath"
	
	val static A1_I = "a1.i"
	val static A2_I = "a2.i"
	
	val static INSTANCE_NAME = "a1_i_Instance"
	
	val static FPATH1 = "fpath1"
	val static FSRC1 = "fsrc1"
	
	val static ERROR_NO_END_TO_END_FLOW1 = "Cannot create end to end flow 'etef1' because the end of the semantic connection 'sub1.af3 -> sub2.sub4.af3' does not connect to the start of flow 'fpath1'"
	val static ERROR_NO_END_TO_END_FLOW2 = "Cannot create end to end flow 'etef1' because there are no semantic connections that continue the flow 'fsrc1' from feature 'af2'"
	@Test
	def void test1() {
		val testFileResult = loadFile(FILE1, PROJECT_LOCATION + FILE1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"simple".assertEquals(name)
			
//			publicSection.ownedClassifiers.findFirst[name == S_I] as SystemImplementation => [
//				assertError(testFileResult.issues, issueCollection, ERROR_NO_SINK1, ERROR_NO_SRC1, ERROR_NO_PATH1)
//			]			

			publicSection.ownedClassifiers.findFirst[name == S_J] as SystemImplementation => [
				ownedFlowImplementations.findFirst[specification.name == MY_SOURCE] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
				ownedFlowImplementations.findFirst[specification.name == MY_SINK] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
				ownedFlowImplementations.findFirst[specification.name == MY_PATH] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
			]			
			
			publicSection.ownedClassifiers.findFirst[name == S_K] as SystemImplementation => [
//				assertError(testFileResult.issues, issueCollection, ERROR_NO_SINK2, ERROR_NO_SRC2)
				
				ownedFlowImplementations.findFirst[specification.name == MY_PATH] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
			]			
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void test2() {
		val testFileResult = loadFile(FILE2, PROJECT_LOCATION + FILE2)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		pkg => [
			"pkg1".assertEquals(name)
			
			publicSection.ownedClassifiers.findFirst[name == A2_I] as AbstractImplementation => [
				ownedFlowImplementations.findFirst[specification.name == FPATH1] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
			]			
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
		
		// instantiate and test
		
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A1_I] as AbstractImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals(INSTANCE_NAME, instance.name)

		val markers = instance.eResource.convertToIResource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE)
		assertTrue(markers.length == 1)
		markers.get(0) => [
			IMarker.SEVERITY_ERROR.assertEquals(attributes.get(IMarker.SEVERITY))
			ERROR_NO_END_TO_END_FLOW1.assertEquals(attributes.get(IMarker.MESSAGE))			
		]
	}
	
	@Test
	def void test3() {
		val testFileResult = loadFile(FILE3, PROJECT_LOCATION + FILE3)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		pkg => [
			"pkg2".assertEquals(name)
			
			publicSection.ownedClassifiers.findFirst[name == A2_I] as AbstractImplementation => [
				ownedFlowImplementations.findFirst[specification.name == FSRC1] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
			]			
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
		
		// instantiate and test
		
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A1_I] as AbstractImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals(INSTANCE_NAME, instance.name)

		val markers = instance.eResource.convertToIResource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE)
		assertTrue(markers.length == 1)
		markers.get(0) => [
			IMarker.SEVERITY_ERROR.assertEquals(attributes.get(IMarker.SEVERITY))
			ERROR_NO_END_TO_END_FLOW2.assertEquals(attributes.get(IMarker.MESSAGE))			
		]
	}

	private def FluentIssueCollection loadFile(String fname, String path) {
		createFiles(fname -> readFile(path))
		ignoreSerializationDifferences
		testFile(fname)
	}
}
