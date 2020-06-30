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
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import static extension org.osate.testsupport.AssertHelper.*
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.aadl2.instantiation.InstantiateModel

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue582AbstractToDataAccessClassifierTest extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue582/"
		
	
	@Test
	def void testDeclarative() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			publicSection.ownedClassifiers.findFirst[name == "Top.allExplicit"] as SystemImplementation => [
				ownedAccessConnections.findFirst[name == "c11"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'provides'.")
				]
				ownedAccessConnections.findFirst[name == "c12"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'provides'.")
				]
				ownedAccessConnections.findFirst[name == "c21"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'provides'.")
				]
				ownedAccessConnections.findFirst[name == "c22"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'provides'.")
				]
				ownedAccessConnections.findFirst[name == "c33"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'requires'.")
				]
				ownedAccessConnections.findFirst[name == "c34"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'requires'.")
				]
				ownedAccessConnections.findFirst[name == "c43"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'requires'.")
				]
				ownedAccessConnections.findFirst[name == "c44"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'requires'.")
				]

				ownedAccessConnections.findFirst[name == "c23"] => [
					it.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'p_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'")
				]
				ownedAccessConnections.findFirst[name == "c32"] => [
					it.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'p_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'")
				]

				ownedAccessConnections.findFirst[name == "c14"] => [
					it.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'r_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'")
				]
				ownedAccessConnections.findFirst[name == "c41"] => [
					it.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'r_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'")
				]
			]			
		]

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void testAllExplicit() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.allExplicit"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.p_type -> destSys.p_type"])
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.p_type -> destSys.p_notype"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.p_type -> destSys.r_type"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.p_type -> destSys.r_notype"])
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.p_notype -> destSys.p_type"])
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.p_notype -> destSys.p_notype"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.p_notype -> destSys.r_type"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.p_notype -> destSys.r_notype"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.r_notype -> destSys.p_type"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.r_type -> destSys.p_notype"])
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.r_type -> destSys.r_type"])
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.r_type -> destSys.r_notype"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.r_notype -> destSys.p_type"])
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.r_notype -> destSys.p_notype"])
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.r_notype -> destSys.r_type"])
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.r_notype -> destSys.r_notype"])
		
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 12)

		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.p_type to Top_allExplicit_Instance.destSys.p_type has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.p_type to Top_allExplicit_Instance.destSys.p_notype has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.p_notype to Top_allExplicit_Instance.destSys.p_type has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.p_notype to Top_allExplicit_Instance.destSys.p_notype has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.r_type to Top_allExplicit_Instance.destSys.r_type has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.r_type to Top_allExplicit_Instance.destSys.r_notype has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.r_notype to Top_allExplicit_Instance.destSys.r_type has no valid direction. Connection instance not created."])
		assertNotNull(messages.findFirst[where == instance && kind == QueuingAnalysisErrorReporter.ERROR && message == "Connection from Top_allExplicit_Instance.srcSys.r_notype to Top_allExplicit_Instance.destSys.r_notype has no valid direction. Connection instance not created."])


		assertNotNull(messages.findFirst[where == instance.connectionInstances.findFirst[name == "srcSys.p_type -> destSys.r_notype"] && kind == QueuingAnalysisErrorReporter.WARNING && message == "Expected feature 'destSys.r_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'"])
		assertNotNull(messages.findFirst[where == instance.connectionInstances.findFirst[name == "srcSys.r_type -> destSys.p_notype"] && kind == QueuingAnalysisErrorReporter.WARNING && message == "Expected feature 'destSys.p_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'"])
		assertNotNull(messages.findFirst[where == instance.connectionInstances.findFirst[name == "srcSys.p_notype -> destSys.r_type"] && kind == QueuingAnalysisErrorReporter.WARNING && message == "Expected feature 'srcSys.p_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'"])
		assertNotNull(messages.findFirst[where == instance.connectionInstances.findFirst[name == "srcSys.r_notype -> destSys.p_type"] && kind == QueuingAnalysisErrorReporter.WARNING && message == "Expected feature 'srcSys.r_notype' to have classifier 'TestAbstractToDataAccessClassifier::D'"])
	}

	@Test
	def void test_notype_to_notype() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.notype_to_notype"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_provides_nt_to_provides_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_nt_to_provides_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_provides_nt_to_provides_nt_Instance.srcSys.f0 to Top_provides_nt_to_provides_nt_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}

	@Test
	def void test_provides_nt_to_provides_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_nt_to_provides_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_provides_nt_to_provides_t_Instance.srcSys.f0 to Top_provides_nt_to_provides_t_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}

	@Test
	def void test_provides_nt_to_requires_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_nt_to_requires_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_provides_nt_to_requires_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_nt_to_requires_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
			assertEquals(message, "Expected feature 'srcSys.f0' to have classifier 'TestAbstractToDataAccessClassifier::D'")
		]
	}

	@Test
	def void test_provides_t_to_provides_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_t_to_provides_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_provides_t_to_provides_nt_Instance.srcSys.f0 to Top_provides_t_to_provides_nt_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}

	@Test
	def void test_provides_t_to_provides_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_t_to_provides_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_provides_t_to_provides_t_Instance.srcSys.f0 to Top_provides_t_to_provides_t_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}

	@Test
	def void test_provides_t_to_requires_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_t_to_requires_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
			assertEquals(message, "Expected feature 'destSys.f0' to have classifier 'TestAbstractToDataAccessClassifier::D'")
		]
	}

	@Test
	def void test_provides_t_to_requires_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_t_to_requires_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_nt_to_provides_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_nt_to_provides_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_nt_to_provides_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_nt_to_provides_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
			assertEquals(message, "Expected feature 'srcSys.f0' to have classifier 'TestAbstractToDataAccessClassifier::D'")
		]
	}

	@Test
	def void test_requires_nt_to_requires_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_nt_to_requires_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_requires_nt_to_requires_nt_Instance.srcSys.f0 to Top_requires_nt_to_requires_nt_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}

	@Test
	def void test_requires_nt_to_requires_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_nt_to_requires_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_requires_nt_to_requires_t_Instance.srcSys.f0 to Top_requires_nt_to_requires_t_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}






	@Test
	def void test_requires_t_to_provides_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_t_to_provides_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.WARNING.assertEquals(kind)
			assertEquals(message, "Expected feature 'destSys.f0' to have classifier 'TestAbstractToDataAccessClassifier::D'")
		]
	}

	@Test
	def void test_requires_t_to_provides_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_t_to_provides_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_t_to_requires_nt() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_t_to_requires_nt"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_requires_t_to_requires_nt_Instance.srcSys.f0 to Top_requires_t_to_requires_nt_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}

	@Test
	def void test_requires_t_to_requires_t() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_t_to_requires_t"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNull(instance.connectionInstances.findFirst[name == "srcSys.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 1)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.ERROR.assertEquals(kind)
			assertEquals(message, "Connection from Top_requires_t_to_requires_t_Instance.srcSys.f0 to Top_requires_t_to_requires_t_Instance.destSys.f0 has no valid direction. Connection instance not created.")
		]
	}}
