package org.osate.aadl2.errormodel.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextRunner2
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner2)
@InjectWith(ErrorModelUiInjectorProvider)
class Issue117 extends OsateTest {
	override getProjectName() {
		"issue117"
	}
	
	@Test
	def void issue117() {
		val fileName = "issue117.aadl"
		createFiles(fileName -> '''
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
		''')
		suppressSerialization
		val testFileResult = testFile(fileName)
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
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}