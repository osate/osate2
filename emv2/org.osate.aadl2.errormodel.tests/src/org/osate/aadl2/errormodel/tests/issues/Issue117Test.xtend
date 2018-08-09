package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue117Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue117() {
		val issue117 = '''
			package pkg1
			public
				abstract a1
					annex EMV2 {**
						use types pkg1;
						
						component error behavior
						propagations
							condition1: all -[ ]-> all;
							condition2: all -[ memory ]-> all;
							condition3: all -[ ]-> all {errorType1};
							condition4: all -[ memory ]-> all {errorType1};
						end component;
					**};
				end a1;
				
				annex EMV2 {**
					error types
						errorType1: type;
					end types;
				**};
			end pkg1;
		'''
		val testFileResult = issues = testHelper.testString(issue117)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a1".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).outgoingPropagationConditions.head => [
					"condition1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Propagation condition must have at least a condition within brackets or a type set for the outgoing propagation")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}