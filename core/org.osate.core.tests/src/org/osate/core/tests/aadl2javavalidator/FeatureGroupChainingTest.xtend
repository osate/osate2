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
package org.osate.core.tests.aadl2javavalidator

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class FeatureGroupChainingTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testFeatureGroupChaining() {
		val aadlText = '''
			package pkg1
			public
				abstract a1
				end a1;
				
				abstract implementation a1.i
					subcomponents
						sub1: abstract a2;
						sub2: abstract a2;
					connections
						--Type of fg4 is inverse of type of fg2 with features redeclared. Works.
						conn1: feature group sub1.fg1.fg2 -> sub2.fg3.fg4;
						--Type of fg8 is inverse of type of fg6 with no local features. Works.
						conn2: feature group sub1.fg5.fg6 -> sub2.fg7.fg8;
						--fg10 and fg12 have same type, but fg12 is declared inverse. Works.
						conn3: feature group sub1.fg9.fg10 -> sub2.fg11.fg12;
						--fg13 and fg15 have same type, but fg15 is declared inverse. Works.
						conn4: feature group sub1.fg13.fg14 -> sub2.fg15.fg14;
						--Same type for fg18 and fg20, but no inverses. Error.
						conn5: feature group sub1.fg17.fg18 -> sub2.fg19.fg20;
						
						
						--Member directions opposite. Works.
						conn6: feature group sub1.fg21.fg22 -> sub2.fg23.fg24 {Classifier_Matching_Rule => Subset;};
						--Member directions same, fg28 is inverse. Works.
						conn7: feature group sub1.fg25.fg26 -> sub2.fg27.fg28 {Classifier_Matching_Rule => Subset;};
						--Member directions same, type of fg32 is inverse with no local features. Works.
						conn8: feature group sub1.fg29.fg30 -> sub2.fg31.fg32 {Classifier_Matching_Rule => Subset;};
						--Member directions oppposite in type of fg36, which is inverse with feature redeclared. Works.
						conn9: feature group sub1.fg33.fg34 -> sub2.fg35.fg36 {Classifier_Matching_Rule => Subset;};
						--Member directions same, no inverses. Error.
						conn10: feature group sub1.fg37.fg38 -> sub2.fg39.fg40 {Classifier_Matching_Rule => Subset;};
				end a1.i;
				
				abstract a2
					features
						fg1: feature group fgt1;
						fg3: feature group fgt3;
						fg5: feature group fgt5;
						fg7: feature group fgt7;
						fg9: feature group fgt9;
						fg11: feature group fgt11;
						fg13: feature group fgt13;
						fg15: feature group inverse of fgt13;
						fg17: feature group fgt17;
						fg19: feature group fgt19;
						fg21: feature group fgt21;
						fg23: feature group fgt23;
						fg25: feature group fgt25;
						fg27: feature group fgt27;
						fg29: feature group fgt29;
						fg31: feature group fgt31;
						fg33: feature group fgt33;
						fg35: feature group fgt35;
						fg37: feature group fgt37;
						fg39: feature group fgt39;
				end a2;
				
				feature group fgt1
					features
						fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
					features
						p1: out data port;
				end fgt2;
				
				feature group fgt3
					features
						fg4: feature group fgt4;
				end fgt3;
				
				feature group fgt4
					features
						p1: in data port;
					inverse of fgt2
				end fgt4;
				
				feature group fgt5
					features
						fg6: feature group fgt6;
				end fgt5;
				
				feature group fgt6
					features
						p2: out data port;
				end fgt6;
				
				feature group fgt7
					features
						fg8: feature group fgt8;
				end fgt7;
				
				feature group fgt8
					inverse of fgt6
				end fgt8;
				
				feature group fgt9
					features
						fg10: feature group fgt10;
				end fgt9;
				
				feature group fgt10
					features
						p3: out data port;
				end fgt10;
				
				feature group fgt11
					features
						fg12: feature group inverse of fgt10;
				end fgt11;
				
				feature group fgt13
					features
						fg14: feature group fgt14;
				end fgt13;
				
				feature group fgt14
					features
						p4: out data port;
				end fgt14;
				
				feature group fgt17
					features
						fg18: feature group fgt18;
				end fgt17;
				
				feature group fgt18
					features
						p5: out data port;
				end fgt18;
				
				feature group fgt19
					features
						fg20: feature group fgt18;
				end fgt19;
				
				feature group fgt21
					features
						fg22: feature group fgt22;
				end fgt21;
				
				feature group fgt22
					features
						p6: out data port;
				end fgt22;
				
				feature group fgt23
					features
						fg24: feature group fgt24;
				end fgt23;
				
				feature group fgt24
					features
						p6: in data port;
				end fgt24;
				
				feature group fgt25
					features
						fg26: feature group fgt26;
				end fgt25;
				
				feature group fgt26
					features
						p7: out data port;
				end fgt26;
				
				feature group fgt27
					features
						fg28: feature group inverse of fgt28;
				end fgt27;
				
				feature group fgt28
					features
						p7: out data port;
				end fgt28;
				
				feature group fgt29
					features
						fg30: feature group fgt30;
				end fgt29;
				
				feature group fgt30
					features
						p8: out data port;
				end fgt30;
				
				feature group fgt31
					features
						fg32: feature group fgt32;
				end fgt31;
				
				feature group fgt32
					inverse of fgt32_a
				end fgt32;
				
				feature group fgt32_a
					features
						p8: out data port;
				end fgt32_a;
				
				feature group fgt33
					features
						fg34: feature group fgt34;
				end fgt33;
				
				feature group fgt34
					features
						p9: out data port;
				end fgt34;
				
				feature group fgt35
					features
						fg36: feature group fgt36;
				end fgt35;
				
				feature group fgt36
					features
						p9: in data port;
					inverse of fgt36_a
				end fgt36;
				
				feature group fgt36_a
					features
						p9: out data port;
				end fgt36_a;
				
				feature group fgt37
					features
						fg38: feature group fgt38;
				end fgt37;
				
				feature group fgt38
					features
						p10: out data port;
				end fgt38;
				
				feature group fgt39
					features
						fg40: feature group fgt40;
				end fgt39;
				
				feature group fgt40
					features
						p10: out data port;
				end fgt40;
			end pkg1;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFeatureGroupConnections.get(4) => [
					"conn5".assertEquals(name)
					assertError(testFileResult.issues, issueCollection,
							"The feature groups 'fg18' and 'fg20' are not inverses of each other.",
							"Feature sub2.fg19.fg20.p5 must not be out due to the direction of the connection")
				]
				ownedFeatureGroupConnections.get(9) => [
					"conn10".assertEquals(name)
					assertError(testFileResult.issues, issueCollection,
							"The direction of the source feature group feature 'fg38.p10' and destination feature group feature 'fg40.p10' of connection conn10 must be opposites.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}