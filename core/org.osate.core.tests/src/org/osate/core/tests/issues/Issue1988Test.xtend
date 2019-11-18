package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import org.osate.aadl2.ProcessImplementation
import com.itemis.xtext.testing.XtextTest
import com.itemis.xtext.testing.FluentIssueCollection
import static extension org.osate.testsupport.AssertHelper.assertWarning
import org.osate.aadl2.ThreadImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1988Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1988/"

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testPortSrc() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "PortSrc.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		val p_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "p.i"] as ProcessImplementation
			
		p_i.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'p1' to have classifier 'PortSrc::D'")
		]	
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testPortDst() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "PortDst.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		val p_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "p.i"] as ProcessImplementation
			
		p_i.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'ip2' to have classifier 'PortDst::D'")
		]	
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testPortEmpty() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "PortEmpty.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
			
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testPortOkay() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "PortOkay.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
			
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testAccessSrc() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "AccessSrc.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
			
		val p_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "p.i"] as ProcessImplementation
		p_i.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'p1' to have classifier 'AccessSrc::D'")
		]	

		val t1_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "t1.i"] as ThreadImplementation
		t1_i.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected subcomponent 'd' to have classifier 'AccessSrc::D'")
		]	

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testAccessDst() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "AccessDst.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;

		val p_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "p.i"] as ProcessImplementation
		p_i.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'ip2' to have classifier 'AccessDst::D'")
		]	

		val t1_i = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "t1.i"] as ThreadImplementation
		t1_i.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'p2' to have classifier 'AccessDst::D'")
		]	

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testAccessEmpty() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "AccessEmpty.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
			
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testAccessOkay() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "AccessOkay.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
			
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testParameterSrc() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "ParameterSrc.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		val th2_bad = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "th2.bad"] as ThreadImplementation
			
		th2_bad.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'ip2' to have classifier 'ParameterSrc::D'")
		]	
		th2_bad.ownedConnections.get(1) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'p2' to have classifier 'ParameterSrc::D'")
		]	
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testParameterDst() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "ParameterDst.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		val th2_bad = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "th2.bad"] as ThreadImplementation
			
		th2_bad.ownedConnections.get(0) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected feature 'p1' to have classifier 'ParameterDst::D'")
		]	
		th2_bad.ownedConnections.get(1) => [
			assertWarning(testFileResult.issues, issueCollection, "Expected subcomponent 'myData' to have classifier 'ParameterDst::D'")
		]	
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testParameterEmpty() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "ParameterEmpty.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
			
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void testParameterOkay() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "ParameterOkay.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage;
			
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}

