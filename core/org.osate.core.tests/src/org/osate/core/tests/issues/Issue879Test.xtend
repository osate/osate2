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
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import static extension org.osate.testsupport.AssertHelper.assertWarning

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue879Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
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
	
	val static ERROR_NO_END_TO_END_FLOW1 = "Cannot create end to end flow 'etef1' because there are no semantic connections that connect to the start of the flow 'fpath1' at feature 'af1'"
	val static ERROR_NO_END_TO_END_FLOW2 = "Cannot create end to end flow 'etef1' because there are no semantic connections that continue the flow 'fsrc1' from feature 'af2'"
	@Test
	def void test1() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"simple".assertEquals(name)
			
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
				ownedFlowImplementations.findFirst[specification.name == MY_PATH] => [
					assertWarning(testFileResult.issues, issueCollection, WARNING_FLOW_EMPTY)
				]
			]			
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void test2() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE2)
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
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
		
		// instantiate and test
		
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A1_I] as AbstractImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.length == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			ERROR_NO_END_TO_END_FLOW1.assertEquals(message)			
		]
	}
	
	@Test
	def void test3() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + FILE3)
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
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
		
		// instantiate and test
		
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == A1_I] as AbstractImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.length == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			ERROR_NO_END_TO_END_FLOW2.assertEquals(message)			
		]
	}
}
