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
package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2128Test extends XtextTest {
	@Inject
	extension ValidationTestHelper
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)
	
	@Test
	def void testScoping() {
		val issue2128Scoping = '''
			package issue_2128_scoping
			public
				abstract a1
					features
						fg1: feature group fgt1;
				end a1;
				
				abstract implementation a1.i
					internal features
						event_source_1: event;
					annex EMV2 {**
						component error behavior
							detections
								detection1: all -[access]-> fg1.fg2.fg3.port3 !;
						end component;
					**};
				end a1.i;
				
				feature group fgt1
					features
						port1: in out data port;
						fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
					features
						port2: in out data port;
						fg3: feature group fgt3;
				end fgt2;
				
				feature group fgt3
					features
						port3: in out data port;
				end fgt3;
			end issue_2128_scoping;
		'''
		val reference = ErrorModelPackage.eINSTANCE.reportingPortReference_Element
		testHelper.parseString(issue2128Scoping) => [
			assertNoIssues
			"issue_2128_scoping".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				val defaultSubclause = ownedAnnexSubclauses.head as DefaultAnnexSubclause
				(defaultSubclause.parsedAnnexSubclause as ErrorModelSubclause).errorDetections.head => [
					"detection1".assertEquals(name)
					detectionReportingPort => [
						"port3".assertEquals(element.name)
						assertScope(reference, #["port3"])
						previous => [
							"fg3".assertEquals(element.name)
							assertScope(reference, #["port2", "fg3"])
							previous => [
								"fg2".assertEquals(element.name)
								assertScope(reference, #["port1", "fg2"])
								previous => [
									"fg1".assertEquals(element.name)
									assertScope(reference, #["fg1", "event_source_1"])
									previous.assertNull
								]
							]
						]
					]
				]
			]
		]
	}
	
	@Test
	def void testValidation() {
		val issue2128Validation = '''
			package issue_2128_validation
			public
				abstract a1
					features
						abstract_feature_1: feature;
						port1: in out data port;
						data_access_1: provides data access;
						fg1: feature group fgt1;
				end a1;
				
				abstract implementation a1.i
					internal features
						event_source_1: event;
					annex EMV2 {**
						component error behavior
							detections
								--Valid
								detection1: all -[access]-> abstract_feature_1 !;
								detection2: all -[access]-> port1 !;
								detection3: all -[access]-> event_source_1 !;
								detection4: all -[access]-> fg1.abstract_feature_2 !;
								detection5: all -[access]-> fg1.port2 !;
								
								--Invalid
								detection6: all -[access]-> fg1 !;
								detection7: all -[access]-> data_access_1 !;
								detection8: all -[access]-> fg1.fg2 !;
								detection9: all -[access]-> fg1.data_access_2 !;
						end component;
					**};
				end a1.i;
				
				feature group fgt1
					features
						abstract_feature_2: feature;
						port2: in out data port;
						data_access_2: provides data access;
						fg2: feature group;
				end fgt1;
			end issue_2128_validation;
		'''
		val testFileResult = issues = testHelper.testString(issue2128Validation)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue_2128_validation".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					errorDetections.get(5) => [
						"detection6".assertEquals(name)
						detectionReportingPort.assertError(testFileResult.issues, issueCollection,
							"'fg1' is not a port, abstract feature, or internal feature.")
					]
					errorDetections.get(6) => [
						"detection7".assertEquals(name)
						detectionReportingPort.assertError(testFileResult.issues, issueCollection,
							"'data_access_1' is not a port, abstract feature, or internal feature.")
					]
					errorDetections.get(7) => [
						"detection8".assertEquals(name)
						detectionReportingPort.assertError(testFileResult.issues, issueCollection,
							"'fg2' is not a port, abstract feature, or internal feature.")
					]
					errorDetections.get(8) => [
						"detection9".assertEquals(name)
						detectionReportingPort.assertError(testFileResult.issues, issueCollection,
							"'data_access_2' is not a port, abstract feature, or internal feature.")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}