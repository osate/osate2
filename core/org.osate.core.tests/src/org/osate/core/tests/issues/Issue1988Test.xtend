/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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

