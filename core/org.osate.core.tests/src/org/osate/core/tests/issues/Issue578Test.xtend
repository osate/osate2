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
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.SystemType
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue578Test extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue578TestA() {
		val aadlText = '''
			package issue578A
			public
				system a
				end a;
				
				system implementation a.impl extends a.impl
				end a.impl;
			end issue578A;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers

		pkg => [
			"issue578A".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"a.impl".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of a.impl has a cycle.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)

		// instantiate
		val sysImpl = cls.findFirst[name == 'a.impl'] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
		val messages = reporter.errors

		messages => [
			size.assertEquals(1)
			head => [
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				assertEquals("Circular extension: Component 'a.impl' directly or indirectly extends itself.", message)
			]
		]
	}

	@Test
	def void issue578TestB() {
		val aadlText = '''
			package issue578B
			public
				system b extends c
				end b;
				system implementation b.impl extends c.impl
				end b.impl;
			
				system c extends b
				end c;
				system implementation c.impl extends b.impl
				end c.impl;
			
			end issue578B;
		'''

		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers

		pkg => [
			"issue578B".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemType => [
				"b".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of b has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"b.impl".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of b.impl has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(2) as SystemType => [
				"c".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of c has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(3) as SystemImplementation => [
				"c.impl".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of c.impl has a cycle.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)

		// instantiate b.impl
		val sysImpl = cls.findFirst[name == 'b.impl'] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
		val messages = reporter.errors

		messages => [
			size.assertEquals(2)
			head => [
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				message => [
					if (indexOf("Classifier") < 0) {
						assertEquals("Circular extension: Component 'b.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'b' directly or indirectly extends itself.")
					}
					
				]
			]
			tail.head => [
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				message => [
					if (indexOf("Classifier") < 0) {
						assertEquals("Circular extension: Component 'b.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'b' directly or indirectly extends itself.")
					}
				]
			]
		]
		// instantiate c.impl
		val sysImplC = cls.findFirst[name == 'c.impl'] as SystemImplementation
		val errorManagerC = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instanceC = InstantiateModel.instantiate(sysImplC, errorManagerC)
		val reporterC = errorManagerC.getReporter(instanceC.eResource) as QueuingAnalysisErrorReporter
		val messagesC = reporterC.errors
		messagesC => [
			size.assertEquals(2)
			head => [
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				message => [
					if (indexOf("Classifier") < 0) {
						assertEquals("Circular extension: Component 'c.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'c' directly or indirectly extends itself.")
					}
				]
			]
			tail.head => [
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				message => [
					if (indexOf("Classifier") < 0) {
						assertEquals("Circular extension: Component 'c.impl' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'c' directly or indirectly extends itself.")
					}
				]
			]
		]
	}

	@Test
	def void issue578TestC() {
		val aadlText = '''
			package issue578c
			public
				system d extends e
				end d;
			
				system e extends d
				end e;
			
				system implementation d.impl
				end d.impl;
			
			end issue578c;
		'''

		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers

		pkg => [
			"issue578c".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemType => [
				"d".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of d has a cycle.")
				]
			]
			publicSection.ownedClassifiers.get(1) as SystemType => [
				"e".assertEquals(name)
				ownedExtension => [
					assertError(testFileResult.issues, issueCollection, "The extends hierarchy of e has a cycle.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)

		// instantiate d.impl
		val sysImpl = cls.findFirst[name == 'd.impl'] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		val reporter = errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter
		val messages = reporter.errors
		messages => [
			size.assertEquals(1)
			head => [
				assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
				message => [
					if (indexOf("Classifier 'd'") < 0) {
						assertEquals("Circular extension: Classifier 'e' directly or indirectly extends itself.")
					} else {
						assertEquals("Circular extension: Classifier 'd' directly or indirectly extends itself.")
					}
				]
			]
		]
	}

}
