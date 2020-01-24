package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import com.itemis.xtext.testing.XtextTest
import com.itemis.xtext.testing.FluentIssueCollection

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2089Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2089/"
	val static BARNEY = PROJECT_LOCATION + "barney.aadl"
	val static FRED = PROJECT_LOCATION + "fred.aadl"
	val static OTHER = PROJECT_LOCATION + "other.aadl"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testOther() {
		val testFileResult = issues = testHelper.testFile(OTHER, FRED, BARNEY)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		// There should be no errors or warnings
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void testBarney() {
		val testFileResult = issues = testHelper.testFile(BARNEY, OTHER, FRED)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		// There should be no errors or warnings
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void testFred() {
		val testFileResult = issues = testHelper.testFile(FRED, OTHER, BARNEY)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		// There should be no errors or warnings
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}
