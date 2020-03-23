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
package org.osate.aadl2.instance.textual.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.instance.textual.InstanceInjectorProvider
import org.osate.testsupport.TestHelper

@RunWith(XtextRunner)
@InjectWith(InstanceInjectorProvider)
class Issue667Test extends AbstractSerializerTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue667() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s1
					requires modes
						m1: initial mode;
						m2: mode;
				end s1;
				
				system implementation s1.i
					subcomponents
						sub1: system s2.i in modes (m1 => m3, m2 => m4);
						sub2: system s3.i in modes (m2);
					connections
						conn1: feature sub1.f1 -> sub2.f2 in modes (m2);
				end s1.i;
				
				system s2
					features
						f1: feature;
					requires modes
						m3: mode;
						m4: mode;
				end s2;
				
				system implementation s2.i
					subcomponents
						sub3: system s3;
					connections
						conn2: feature sub3.f2 -> f1 in modes (m4);
				end s2.i;
				
				system s3
					features
						f2: feature;
				end s3;
				
				system implementation s3.i
					subcomponents
						sub4: system s3;
					connections
						conn3: feature f2 -> sub4.f2 in modes (m5);
					modes
						m5: initial mode;
						m6: mode;
				end s3.i;
			end pkg1;
		''')
		assertSerialize(pkg1, "s1.i", '''
			system s1_i_Instance : pkg1::s1.i {
				system pkg1::s2.i sub1 [ 0 ] in modes ( m1 , m2 ) : pkg1::s1.i:sub1 {
					in out abstractFeature f1 : pkg1::s2:f1
					system pkg1::s3 sub3 [ 0 ] : pkg1::s2.i:sub3 {
						in out abstractFeature f2 : pkg1::s3:f2
					}
					derived mode m3 = m1 : pkg1::s2:m3
					derived mode m4 = m2 : pkg1::s2:m4
				}
				system pkg1::s3.i sub2 [ 0 ] in modes ( m2 ) : pkg1::s1.i:sub2 {
					in out abstractFeature f2 : pkg1::s3:f2
					system pkg1::s3 sub4 [ 0 ] : pkg1::s3.i:sub4 {
						in out abstractFeature f2 : pkg1::s3:f2
					}
					initial mode m5 : pkg1::s3.i:m5
					mode m6 : pkg1::s3.i:m6
				}
				complete featureConnection "sub1.sub3.f2 -> sub2.sub4.f2" : sub1[0].sub3[0].f2 -> sub2[0].sub4[0].f2 in modes ( som_2 ) {
					sub1[0].sub3[0].f2 -> sub1[0].f1 : pkg1::s2.i:conn2 in sub1[0]
					sub1[0].f1 -> sub2[0].f2 : pkg1::s1.i:conn1 in parent
					sub2[0].f2 -> sub2[0].sub4[0].f2 : pkg1::s3.i:conn3 in sub2[0]
				}
				initial mode m1 : pkg1::s1:m1
				mode m2 : pkg1::s1:m2
				som "som_1" m1 , sub1[0].m3
				som "som_2" m2 , sub1[0].m4 , sub2[0].m5
				som "som_3" m2 , sub1[0].m4 , sub2[0].m6
			}''')
	}
}