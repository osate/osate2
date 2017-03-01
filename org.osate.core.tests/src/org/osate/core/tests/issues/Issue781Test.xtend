package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class Issue781Test extends OsateTest {
	override getProjectName() {
		"Issue_781_Test"
	}
	
	@Test
	def void testIssue781() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				abstract a1
					features
						af1: feature;
					flows
						flow1: flow source af1;
						flow2: flow sink af1;
						flow3: flow path af1 -> af1;
				end a1;
				
				abstract implementation a1.i
					flows
						flow1: flow source af1;
						flow2: flow sink af1;
						flow3: flow path af1 -> af1;
				end a1.i;
			end pkg1;
		''')
		suppressSerialization
		val testFileResult = testFile(pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFlowImplementations.get(0) => [
					"flow1".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
				ownedFlowImplementations.get(1) => [
					"flow2".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
				ownedFlowImplementations.get(2) => [
					"flow3".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}