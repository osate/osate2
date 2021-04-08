package org.osate.aadl2.errormodel.tests.issues

import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.osate.testsupport.TestHelper
import org.osate.aadl2.AadlPackage
import com.itemis.xtext.testing.XtextTest
import org.junit.Test
import com.itemis.xtext.testing.FluentIssueCollection
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2604 extends XtextTest{
	val static folderPath = "org.osate.aadl2.errormodel.tests/models/Issue2604/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void compositeStateTest(){
			val testFileResult = issues = testHelper.testFile(folderPath + "composite_state.aadl")
			val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
			
			testFileResult.resource.contents.head as AadlPackage => [
				"composite_state".assertEquals(name)
				publicSection.ownedClassifiers.get(2) => [
					it.ownedAnnexSubclauses.get(0) as DefaultAnnexSubclause => [
						it.parsedAnnexSubclause as ErrorModelSubclause => [
							states.get(0) => [
								it.assertError(testFileResult.issues, issueCollection, "Target error type may only have a single error type")
							]
							states.get(1) => [
								it.assertError(testFileResult.issues, issueCollection, "Target error type may only have a single error type")
							]
						]
					]
				]
			]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void errorPathTest(){
		val testFileResult = issues = testHelper.testFile(folderPath + "error_path.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
			
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				it.ownedAnnexSubclauses.get(0) as DefaultAnnexSubclause => [
					it.parsedAnnexSubclause as ErrorModelSubclause => [
						it.flows.get(1) => [
							it.assertError(testFileResult.issues, issueCollection, "Outgoing propagation may only have a single error type")
						]
						it.flows.get(2) =>[
							it.assertError(testFileResult.issues, issueCollection, "Outgoing propagation may only have a single error type")
						]			
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void errorPropagationTest(){
		val testFileResult = issues = testHelper.testFile(folderPath + "propagation_test.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
			
		testFileResult.resource.contents.head as AadlPackage => [
			"propagation_test".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				it.ownedAnnexSubclauses.get(0) as DefaultAnnexSubclause => [
					it.parsedAnnexSubclause as ErrorModelSubclause => [
						it.outgoingPropagationConditions.get(0) => [
							it.assertError(testFileResult.issues, issueCollection, "Outgoing error propagation may only have a single error type")
						]
						it.outgoingPropagationConditions.get(1) => [
							it.assertError(testFileResult.issues, issueCollection, "Outgoing error propagation may only have a single error type")
						]	
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void typeMappingTest(){
		val testFileResult = issues = testHelper.testFile(folderPath + "type_mappings.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
			
		testFileResult.resource.contents.head as AadlPackage => [
			"type_mappings".assertEquals(name)
			publicSection.ownedAnnexLibraries.get(0) as DefaultAnnexLibrary => [
				it.parsedAnnexLibrary as ErrorModelLibrary => [
					it.mappings.get(0) => [
						it.mapping.get(0) =>[
							it.assertError(testFileResult.issues, issueCollection, "Target error type may only have a single error type")
						]
						it.mapping.get(1) => [
							it.assertError(testFileResult.issues, issueCollection, "Target error type may only have a single error type")
						]
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void typeTransformationTest(){
		val testFileResult = issues = testHelper.testFile(folderPath + "type_transformations.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
			
		testFileResult.resource.contents.head as AadlPackage => [
			"type_transformations".assertEquals(name)
			publicSection.ownedAnnexLibraries.get(0) as DefaultAnnexLibrary => [
				it.parsedAnnexLibrary as ErrorModelLibrary => [
					it.transformations.get(0) => [
						it.transformation.get(0) => [
							it.assertError(testFileResult.issues, issueCollection, "Target error type may only have a single error type")
						]
						it.transformation.get(1) => [
							it.assertError(testFileResult.issues, issueCollection, "Target error type may only have a single error type")
						]
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}