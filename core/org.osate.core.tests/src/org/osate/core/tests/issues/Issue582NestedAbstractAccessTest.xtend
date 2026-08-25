/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
import org.osate.aadl2.instance.ConnectionInstance
import org.osate.aadl2.instantiation.InstantiateModel

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue582NestedAbstractAccessTest extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue582/"
		
	
	@Test
	def void testDeclarative() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			publicSection.ownedClassifiers.findFirst[name == "SrcSys.allExplicit"] as SystemImplementation => [
				ownedFeatureConnections.findFirst[name == "blank_to_provides"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "blank_to_requires"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "provides_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'provides_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "provides_to_requires"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination must both be provides or requires for a connection mapping features up or down the containment hierarchy.")
				]
				ownedFeatureConnections.findFirst[name == "requires_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'requires_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "requires_to_provides"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination must both be provides or requires for a connection mapping features up or down the containment hierarchy.")
				]
			]

			publicSection.ownedClassifiers.findFirst[name == "Top.allExplicit"] as SystemImplementation => [
				ownedFeatureConnections.findFirst[name == "blank_to_blank_to_provides"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "blank_to_blank_to_requires"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "blank_to_provides_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "blank_to_provides_to_provides"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'provides'.")
				]
				ownedFeatureConnections.findFirst[name == "blank_to_requires_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "blank_to_requires_to_requires"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'requires'.")
				]
				ownedFeatureConnections.findFirst[name == "provides_to_blank_to_provides"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'provides_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "provides_to_blank_to_requires"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'provides_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "provides_to_provides_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "provides_to_provides_to_provides"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'provides'.")
				]
				ownedFeatureConnections.findFirst[name == "provides_to_requires_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "provides_to_requires_to_requires"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'requires'.")
				]
				ownedFeatureConnections.findFirst[name == "requires_to_blank_to_provides"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'requires_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "requires_to_blank_to_requires"] => [
					source.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'requires_to_blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedFeatureConnections.findFirst[name == "requires_to_provides_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "requires_to_provides_to_provides"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'provides'.")
				]
				ownedFeatureConnections.findFirst[name == "requires_to_requires_to_blank"] => [
					destination.assertWarning(testFileResult.issues, issueCollection, "Expected feature 'blank_feature' to have classifier 'TestNestedAbstractAccess::D'")
				]
				ownedAccessConnections.findFirst[name == "requires_to_requires_to_requires"] => [
					it.assertError(testFileResult.issues, issueCollection, "Source and destination of access connections between sibling components cannot both be 'requires'.")
				]
			]			
		]

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void testAllExplicit() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.allExplicit"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(10, messages.size)
		assertEquals(#[
			"srcSys.s.blank_feature -> destSys.provides_feature",
			"srcSys.s.blank_feature -> destSys.requires_feature",
			"srcSys.s.provides_feature -> destSys.blank_feature",
			"srcSys.s.provides_feature -> destSys.provides_feature",
			"srcSys.s.provides_feature -> destSys.provides_feature",
			"srcSys.s.provides_feature -> destSys.requires_feature",
			"srcSys.s.requires_feature -> destSys.blank_feature",
			"srcSys.s.requires_feature -> destSys.provides_feature",
			"srcSys.s.requires_feature -> destSys.requires_feature",
			"srcSys.s.requires_feature -> destSys.requires_feature"
		].sort,
			messages.filter[message == "Connection has no valid direction"]
				.map[(where as ConnectionInstance).name].sort)

		assertEquals(27, instance.connectionInstances.size)
	}

	@Test
	def void test_blank_to_blank_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_blank_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_blank_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_blank_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_blank_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_blank_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_provides_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_provides_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_provides_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_provides_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_blank_to_provides_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_provides_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_requires_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_requires_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_requires_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_requires_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_blank_to_requires_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.blank_to_requires_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_provides_to_blank_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_blank_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_provides_to_blank_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_blank_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_provides_to_blank_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_blank_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_provides_to_provides_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_provides_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_provides_to_provides_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_provides_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_provides_to_provides_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_provides_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_provides_to_requires_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_requires_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_provides_to_requires_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_requires_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_provides_to_requires_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.provides_to_requires_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_requires_to_blank_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_blank_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_to_blank_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_blank_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_to_blank_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_blank_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_to_provides_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_provides_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_requires_to_provides_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_provides_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_requires_to_provides_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_provides_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}

	@Test
	def void test_requires_to_requires_to_blank() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_requires_to_blank"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_to_requires_to_provides() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_requires_to_provides"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertTrue(messages.size == 0)
	}

	@Test
	def void test_requires_to_requires_to_requires() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNestedAbstractAccess.aadl")
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "Top.requires_to_requires_to_requires"] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		
		assertNotNull(instance.connectionInstances.findFirst[name == "srcSys.s.f0 -> destSys.f0"])

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		assertEquals(1, messages.size)
		messages.get(0) => [
			QueuingAnalysisErrorReporter.Kind.ERROR.assertEquals(kind)
			assertEquals("Connection has no valid direction", message)
			assertEquals("srcSys.s.f0 -> destSys.f0", (where as ConnectionInstance).name)
		]
	}
}
