package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertWarning

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue781Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue781() {
		val pkg1 = '''
			package pkg1
			public
				abstract a1
					features
						af1: feature;
						fg1: feature group fgt1;
					flows
						flow1: flow source af1;
						flow2: flow sink af1;
						flow3: flow path af1 -> af1;
						flow4: flow source fg1;
						flow5: flow sink fg1;
						flow6: flow path fg1 -> fg1;
				end a1;
				
				abstract implementation a1.i
				  subcomponents
				    s1: abstract a1;
				    s2: abstract a1;
				  connections
				    c1: feature s1.af1 -> s2.af1;
				flows
					flow1: flow source af1;
					flow2: flow sink af1;
					flow3: flow path af1 -> af1;
					flow4: flow source fg1.af2;
					flow5: flow sink fg1.af2;
					flow6: flow path fg1.af2 -> fg1.af2;
				end a1.i;
				
				feature group fgt1
					features
						af2: feature;
				end fgt1;
			end pkg1;
		'''
		val testFileResult = issues = testHelper.testString(pkg1)
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
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}