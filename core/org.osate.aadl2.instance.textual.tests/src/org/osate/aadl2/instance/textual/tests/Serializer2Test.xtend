/*
<copyright>
Copyright  2016 by Carnegie Mellon University, all rights reserved.

Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
at http://www.eclipse.org/org/documents/epl-v10.html.

NO WARRANTY

ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.

Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
employees, and agents from all claims or demands made against them (and any related losses, expenses, or
attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
product liability, personal injury, death, damage to property, or violation of any laws or regulations.

Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
under the contract clause at 252.227.7013.
</copyright>
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
class Serializer2Test extends AbstractSerializerTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testEndToEndFlows() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s1
					features
						p1: in data port;
						p2: out data port;
					flows
						f1: flow path p1 -> p2;
				end s1;
				
				system s2
					features
						p3: in data port;
					flows
						f2: flow sink p3;
				end s2;
				
				system s3
					features
						p4: in data port;
						p5: out data port;
					flows
						f3: flow sink p4;
						f4: flow sink p4;
						f5: flow path p4 -> p5;
				end s3;
				
				system implementation s3.i
					subcomponents
						s1_sub: system s1;
						s2_sub: system s2;
					connections
						conn1: port p4 -> s1_sub.p1;
						conn2: port s1_sub.p2 -> s2_sub.p3;
					flows
						f3: flow sink p4 -> conn1 -> s1_sub.f1 -> conn2 -> s2_sub.f2;
						f4: flow sink p4 -> conn1 -> s1_sub -> conn2 -> s2_sub.f2;
						etef1: end to end flow s1_sub -> conn2 -> s2_sub.f2;
				end s3.i;
				
				system s4
					features
						p6: out data port;
						p7: in data port;
					flows
						f6: flow source p6;
						f7: flow sink p7;
				end s4;
				
				system s5
				end s5;
				
				system implementation s5.i
					subcomponents
						s4_sub: system s4;
						s3_sub: system s3.i;
					connections
						conn3: port s4_sub.p6 -> s3_sub.p4;
						conn4: port s3_sub.p5 -> s4_sub.p7;
					flows
						etef2: end to end flow s4_sub.f6 -> conn3 -> s3_sub.f3;
						etef3: end to end flow s4_sub.f6 -> conn3 -> s3_sub.f4;
						etef4: end to end flow s4_sub.f6 -> conn3 -> s3_sub.f5;
						etef5: end to end flow etef4 -> conn4 -> s4_sub.f7;
				end s5.i;
			end pkg1;
		''')
		assertSerialize(pkg1, "s5.i", '''
			system s5_i_Instance : pkg1::s5.i {
				system pkg1::s4 s4_sub [ 0 ] : pkg1::s5.i:s4_sub {
					out dataPort p6 : pkg1::s4:p6
					in dataPort p7 : pkg1::s4:p7
					flow f6 ( -> p6 ) : pkg1::s4:f6
					flow f7 ( p7 -> ) : pkg1::s4:f7
				}
				system pkg1::s3.i s3_sub [ 0 ] : pkg1::s5.i:s3_sub {
					in dataPort p4 : pkg1::s3:p4
					out dataPort p5 : pkg1::s3:p5
					system pkg1::s1 s1_sub [ 0 ] : pkg1::s3.i:s1_sub {
						in dataPort p1 : pkg1::s1:p1
						out dataPort p2 : pkg1::s1:p2
						flow f1 ( p1 -> p2 ) : pkg1::s1:f1
					}
					system pkg1::s2 s2_sub [ 0 ] : pkg1::s3.i:s2_sub {
						in dataPort p3 : pkg1::s2:p3
						flow f2 ( p3 -> ) : pkg1::s2:f2
					}
					complete portConnection "s1_sub.p2 -> s2_sub.p3" : s1_sub[0].p2 -> s2_sub[0].p3 {
						s1_sub[0].p2 -> s2_sub[0].p3 : pkg1::s3.i:conn2 in parent
					}
					flow f3 ( p4 -> ) : pkg1::s3:f3
					flow f4 ( p4 -> ) : pkg1::s3:f4
					flow f5 ( p4 -> p5 ) : pkg1::s3:f5
					end to end flow etef1 s1_sub[0] -> connection#0 -> s2_sub[0].f2 : pkg1::s3.i:etef1
				}
				complete portConnection "s4_sub.p6 -> s3_sub.s1_sub.p1" : s4_sub[0].p6 -> s3_sub[0].s1_sub[0].p1 {
					s4_sub[0].p6 -> s3_sub[0].p4 : pkg1::s5.i:conn3 in parent
					s3_sub[0].p4 -> s3_sub[0].s1_sub[0].p1 : pkg1::s3.i:conn1 in s3_sub[0]
				}
				complete portConnection "s3_sub.p5 -> s4_sub.p7" : s3_sub[0].p5 -> s4_sub[0].p7 {
					s3_sub[0].p5 -> s4_sub[0].p7 : pkg1::s5.i:conn4 in parent
				}
				end to end flow etef2 s4_sub[0].f6 -> connection#0 -> s3_sub[0].s1_sub[0].f1 -> s3_sub[0].connection#0 -> s3_sub[0].s2_sub[0].f2 : pkg1::s5.i:etef2
				end to end flow etef3 s4_sub[0].f6 -> connection#0 -> s3_sub[0].s1_sub[0] -> s3_sub[0].connection#0 -> s3_sub[0].s2_sub[0].f2 : pkg1::s5.i:etef3
				end to end flow etef4 s4_sub[0].f6 -> connection#0 -> s3_sub[0].f5 : pkg1::s5.i:etef4
				end to end flow etef5 etef4 -> connection#1 -> s4_sub[0].f7 : pkg1::s5.i:etef5
				som "No Modes"
			}''')
	}
	
	@Test
	def void testModes() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s1
					modes
						m1: initial mode;
						m2: mode;
				end s1;
				
				system s2
					requires modes
						m3: initial mode;
						m4: mode;
				end s2;
				
				system s3
					modes
						m5: initial mode;
						m6: mode;
				end s3;
				
				system implementation s3.i
					subcomponents
						s1_sub: system s1;
						s2_sub: system s2;
				end s3.i;
			end pkg1;
		''')
		assertSerialize(pkg1, "s3.i", '''
			system s3_i_Instance : pkg1::s3.i {
				system pkg1::s1 s1_sub [ 0 ] : pkg1::s3.i:s1_sub {
					initial mode m1 : pkg1::s1:m1
					mode m2 : pkg1::s1:m2
				}
				system pkg1::s2 s2_sub [ 0 ] : pkg1::s3.i:s2_sub {
					initial derived mode m3 : pkg1::s2:m3
					derived mode m4 : pkg1::s2:m4
				}
				initial mode m5 : pkg1::s3:m5
				mode m6 : pkg1::s3:m6
				som "som_1" m5 , s1_sub[0].m1
				som "som_2" m5 , s1_sub[0].m2
				som "som_3" m6 , s1_sub[0].m1
				som "som_4" m6 , s1_sub[0].m2
			}''')
	}
	
	@Test
	def void testInModes() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s1
					features
						p1: in data port;
					flows
						f1: flow sink p1 in modes (m1, m2);
					modes
						m1: initial mode;
						m2: mode;
						m3: mode;
				end s1;
				
				system implementation s1.i
					subcomponents
						sub1: system s2;
						sub2: system in modes (m1);
						sub3: system in modes (m1, m2);
						sub4: system s3 in modes (m1, m2, m3);
					connections
						conn1: port sub1.p2 -> sub4.p3 in modes (m3);
					flows
						etef1: end to end flow sub1.f2 -> conn1 -> sub4.f3 in modes (m3);
				end s1.i;
				
				system s2
					features
						p2: out data port;
					flows
						f2: flow source p2;
				end s2;
				
				system s3
					features
						p3: in data port;
					flows
						f3: flow sink p3;
				end s3;
			end pkg1;
		''')
		assertSerialize(pkg1, "s1.i", '''
			system s1_i_Instance : pkg1::s1.i {
				in dataPort p1 : pkg1::s1:p1
				system pkg1::s2 sub1 [ 0 ] : pkg1::s1.i:sub1 {
					out dataPort p2 : pkg1::s2:p2
					flow f2 ( -> p2 ) : pkg1::s2:f2
				}
				system sub2 [ 0 ] in modes ( m1 ) : pkg1::s1.i:sub2
				system sub3 [ 0 ] in modes ( m1 , m2 ) : pkg1::s1.i:sub3
				system pkg1::s3 sub4 [ 0 ] in modes ( m1 , m2 , m3 ) : pkg1::s1.i:sub4 {
					in dataPort p3 : pkg1::s3:p3
					flow f3 ( p3 -> ) : pkg1::s3:f3
				}
				complete portConnection "sub1.p2 -> sub4.p3" : sub1[0].p2 -> sub4[0].p3 in modes ( som_3 ) {
					sub1[0].p2 -> sub4[0].p3 : pkg1::s1.i:conn1 in parent
				}
				flow f1 ( p1 -> ) in modes ( m1 , m2 ) : pkg1::s1:f1
				end to end flow etef1 sub1[0].f2 -> connection#0 -> sub4[0].f3 in modes ( som_3 ) : pkg1::s1.i:etef1
				initial mode m1 : pkg1::s1:m1
				mode m2 : pkg1::s1:m2
				mode m3 : pkg1::s1:m3
				som "som_1" m1
				som "som_2" m2
				som "som_3" m3
			}''')
	}
	
	@Test
	def void testParentMode() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s1
					requires modes
						m1: initial mode;
						m2: mode;
				end s1;
				
				system s2
					requires modes
						m3: initial mode;
						m4: mode;
						m5: mode;
				end s2;
				
				system implementation s2.i
					subcomponents
						sub1: system s1 in modes (m3 => m1, m4 => m2);
				end s2.i;
				
				system s3
					modes
						m6: initial mode;
						m7: mode;
						m5: mode;
				end s3;
				
				system implementation s3.i
					subcomponents
						sub2: system s2.i in modes (m6 => m3, m7 => m3, m5);
				end s3.i;
			end pkg1;
		''')
		assertSerialize(pkg1, "s3.i", '''
			system s3_i_Instance : pkg1::s3.i {
				system pkg1::s2.i sub2 [ 0 ] in modes ( m6 , m7 , m5 ) : pkg1::s3.i:sub2 {
					system pkg1::s1 sub1 [ 0 ] in modes ( m3 , m4 ) : pkg1::s2.i:sub1 {
						initial derived mode m1 = m3 : pkg1::s1:m1
						derived mode m2 = m4 : pkg1::s1:m2
					}
					initial derived mode m3 = ( m6 , m7 ) : pkg1::s2:m3
					derived mode m4 : pkg1::s2:m4
					derived mode m5 = m5 : pkg1::s2:m5
				}
				initial mode m6 : pkg1::s3:m6
				mode m7 : pkg1::s3:m7
				mode m5 : pkg1::s3:m5
				som "som_1" m6 , sub2[0].m3 , sub2[0].sub1[0].m1
				som "som_2" m7 , sub2[0].m3 , sub2[0].sub1[0].m1
				som "som_3" m5 , sub2[0].m5
			}''')
	}
	
	@Test
	def void testModeTransitionInstances() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s
					features
						p1: in event port;
					modes
						m1: initial mode;
						m2: mode;
						mt1: m1 -[p1]-> m2;
				end s;
				
				system implementation s.i
					subcomponents
						sub1: system s;
				end s.i;
			end pkg1;
		''')
		assertSerialize(pkg1, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				in eventPort p1 : pkg1::s:p1
				system pkg1::s sub1 [ 0 ] : pkg1::s.i:sub1 {
					in eventPort p1 : pkg1::s:p1
					initial mode m1 : pkg1::s:m1
					mode m2 : pkg1::s:m2
					mode transition m1_p1_m2 m1 -[ p1 ]-> m2 : pkg1::s:mt1
				}
				initial mode m1 : pkg1::s:m1
				mode m2 : pkg1::s:m2
				mode transition m1_p1_m2 m1 -[ p1 ]-> m2 : pkg1::s:mt1
				som "som_1" m1 , sub1[0].m1
				som "som_2" m1 , sub1[0].m2
				som "som_3" m2 , sub1[0].m1
				som "som_4" m2 , sub1[0].m2
			}''')
	}
	
	@Test
	def void testModeTransitionTriggers() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s1
					features
						port1: in event port;
						port2: in event port;
						port3: in event port;
						arrayPort1: in event port[2];
						fg1: feature group fgt1;
						arrayFg1: feature group fgt1[2];
				end s1;
				
				system implementation s1.i
					subcomponents
						sub1: system s1;
						arraySub1: system s1[2];
						multiArraySub1: system s1[2][2][2];
					internal features
						es1: event;
					processor features
						pp1: port;
					modes
						m1: initial mode;
						m2: mode;
						m3: mode;
						m4: mode;
						m1 -[port1]-> m2;
						m2 -[arrayPort1]-> m1;
						m1 -[self.es1]-> m3;
						m2 -[processor.pp1]-> m3;
						m3 -[fg1.port4]-> m1;
						m3 -[arrayFg1.port4]-> m2;
						m1 -[sub1.port1]-> m4;
						m2 -[arraySub1.arrayPort1]-> m4;
						m3 -[multiArraySub1.arrayPort1]-> m4;
						m4 -[port1, port2, port3]-> m1;
				end s1.i;
				
				feature group fgt1
					features
						port4: in event port;
				end fgt1;
			end pkg1;
		''')
		assertSerialize(pkg1, "s1.i", '''
			system s1_i_Instance : pkg1::s1.i {
				in out featureGroup fg1 : pkg1::s1:fg1 {
					in eventPort port4 : pkg1::fgt1:port4
				}
				in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
					in eventPort port4 : pkg1::fgt1:port4
				}
				in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
					in eventPort port4 : pkg1::fgt1:port4
				}
				in eventPort port1 : pkg1::s1:port1
				in eventPort port2 : pkg1::s1:port2
				in eventPort port3 : pkg1::s1:port3
				in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
				in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				system pkg1::s1 sub1 [ 0 ] : pkg1::s1.i:sub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 arraySub1 [ 1 ] : pkg1::s1.i:arraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 arraySub1 [ 2 ] : pkg1::s1.i:arraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 1 ] [ 1 ] [ 1 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 1 ] [ 1 ] [ 2 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 1 ] [ 2 ] [ 1 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 1 ] [ 2 ] [ 2 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 2 ] [ 1 ] [ 1 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 2 ] [ 1 ] [ 2 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 2 ] [ 2 ] [ 1 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				system pkg1::s1 multiArraySub1 [ 2 ] [ 2 ] [ 2 ] : pkg1::s1.i:multiArraySub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 1 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in out featureGroup arrayFg1 [ 2 ] : pkg1::s1:arrayFg1 {
						in eventPort port4 : pkg1::fgt1:port4
					}
					in eventPort port1 : pkg1::s1:port1
					in eventPort port2 : pkg1::s1:port2
					in eventPort port3 : pkg1::s1:port3
					in eventPort arrayPort1 [ 1 ] : pkg1::s1:arrayPort1
					in eventPort arrayPort1 [ 2 ] : pkg1::s1:arrayPort1
				}
				initial mode m1 : pkg1::s1.i:m1
				mode m2 : pkg1::s1.i:m2
				mode m3 : pkg1::s1.i:m3
				mode m4 : pkg1::s1.i:m4
				mode transition m1_port1_m2 m1 -[ port1 ]-> m2 : pkg1::s1.i:transition#0
				mode transition m2_arrayPort1_m1 m2 -[ arrayPort1[1] ]-> m1 : pkg1::s1.i:transition#1
				mode transition m1_es1_m3 m1 -[ ]-> m3 : pkg1::s1.i:transition#2
				mode transition m2_pp1_m3 m2 -[ ]-> m3 : pkg1::s1.i:transition#3
				mode transition m3_port4_m1 m3 -[ fg1.port4 ]-> m1 : pkg1::s1.i:transition#4
				mode transition m3_port4_m2 m3 -[ arrayFg1[1].port4 ]-> m2 : pkg1::s1.i:transition#5
				mode transition m1_sub1_port1_m4 m1 -[ sub1[0].port1 ]-> m4 : pkg1::s1.i:transition#6
				mode transition m2_arraySub1_arrayPort1_m4 m2 -[ arraySub1[1].arrayPort1[1] ]-> m4 : pkg1::s1.i:transition#7
				mode transition m3_multiArraySub1_arrayPort1_m4 m3 -[ multiArraySub1[1][1][1].arrayPort1[1] ]-> m4 : pkg1::s1.i:transition#8
				mode transition m4_port1_m1 m4 -[ port1 , port2 , port3 ]-> m1 : pkg1::s1.i:transition#9
				som "som_1" m1
				som "som_2" m2
				som "som_3" m3
				som "som_4" m4
			}''')
	}
	
	@Test
	def void testInModeTransitions() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				system s1
					features
						p1: out data port;
				end s1;
				
				system s2
					features
						p2: in data port;
				end s2;
				
				system s3
					features
						p3: in event port;
					flows
						f1: flow sink p3 in modes (mt1);
					modes
						m1: initial mode;
						m2: mode;
						mt1: m1 -[p3]-> m2;
				end s3;
				
				system implementation s3.i
					subcomponents
						sub1: system s1;
						sub2: system s2;
					connections
						conn1: port sub1.p1 -> sub2.p2 in modes (mt1);
				end s3.i;
			end pkg1;
		''')
		assertSerialize(pkg1, "s3.i", '''
			system s3_i_Instance : pkg1::s3.i {
				in eventPort p3 : pkg1::s3:p3
				system pkg1::s1 sub1 [ 0 ] : pkg1::s3.i:sub1 {
					out dataPort p1 : pkg1::s1:p1
				}
				system pkg1::s2 sub2 [ 0 ] : pkg1::s3.i:sub2 {
					in dataPort p2 : pkg1::s2:p2
				}
				complete portConnection "sub1.p1 -> sub2.p2" : sub1[0].p1 -> sub2[0].p2 in transitions ( transition#0 ) {
					sub1[0].p1 -> sub2[0].p2 : pkg1::s3.i:conn1 in parent
				}
				flow f1 ( p3 -> ) in transitions ( transition#0 ) : pkg1::s3:f1
				initial mode m1 : pkg1::s3:m1
				mode m2 : pkg1::s3:m2
				mode transition m1_p3_m2 m1 -[ p3 ]-> m2 : pkg1::s3:mt1
				som "som_1" m1
				som "som_2" m2
			}''')
	}
	
	@Test
	def void testPropertyAssociations() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				with ps1;
				
				system s1
					features
						p1: out data port;
						p2: in event port;
						fg1: feature group fgt1;
					flows
						fs1: flow source p1 {ps1::bool1 => true;};
					modes
						m1: initial mode {ps1::bool1 => true;};
						m2: mode;
						mt1: m1 -[p2]-> m2 {ps1::bool1 => true;};
						m2 -[p2]-> m1 {ps1::bool1 => true;};
				end s1;
				
				system s2
					features
						p3: in data port;
					flows
						fs2: flow sink p3;
				end s2;
				
				system s3
					properties
						ps1::bool1 => true;
				end s3;
				
				system implementation s3.i
					subcomponents
						sub1: system s1 {ps1::bool1 => true;};
						sub2: system s2;
					connections
						conn1: port sub1.p1 -> sub2.p3 {ps1::bool1 => true;};
					flows
						etef1: end to end flow sub1.fs1 -> conn1 -> sub2.fs2 {ps1::bool1 => true;};
				end s3.i;
				
				feature group fgt1
					features
						p4: in data port {ps1::bool1 => true;};
				end fgt1;
			end pkg1;
		''', '''
			property set ps1 is
				bool1: aadlboolean applies to (all);
			end ps1;
		''')
		assertSerialize(pkg1, "s3.i", '''
			system s3_i_Instance : pkg1::s3.i {
				system pkg1::s1 sub1 [ 0 ] : pkg1::s3.i:sub1 {
					in out featureGroup fg1 : pkg1::s1:fg1 {
						in dataPort p4 : pkg1::fgt1:p4 {
							ps1::bool1 => true : pkg1::fgt1:p4:property#0
						}
					}
					out dataPort p1 : pkg1::s1:p1
					in eventPort p2 : pkg1::s1:p2
					flow fs1 ( -> p1 ) : pkg1::s1:fs1 {
						ps1::bool1 => true : pkg1::s1:fs1:property#0
					}
					initial mode m1 : pkg1::s1:m1 {
						ps1::bool1 => true : pkg1::s1:m1:property#0
					}
					mode m2 : pkg1::s1:m2
					mode transition m1_p2_m2 m1 -[ p2 ]-> m2 : pkg1::s1:mt1 {
						ps1::bool1 => true : pkg1::s1:mt1:property#0
					}
					mode transition m2_p2_m1 m2 -[ p2 ]-> m1 : pkg1::s1:transition#1 {
						ps1::bool1 => true : pkg1::s1:transition#1:property#0
					}
					ps1::bool1 => true : pkg1::s3.i:sub1:property#0
				}
				system pkg1::s2 sub2 [ 0 ] : pkg1::s3.i:sub2 {
					in dataPort p3 : pkg1::s2:p3
					flow fs2 ( p3 -> ) : pkg1::s2:fs2
				}
				complete portConnection "sub1.p1 -> sub2.p3" : sub1[0].p1 -> sub2[0].p3 {
					sub1[0].p1 -> sub2[0].p3 : pkg1::s3.i:conn1 in parent
					ps1::bool1 => true : pkg1::s3.i:conn1:property#0
				}
				end to end flow etef1 sub1[0].fs1 -> connection#0 -> sub2[0].fs2 in modes ( som_1 , som_2 ) : pkg1::s3.i:etef1 {
					ps1::bool1 => true : pkg1::s3.i:etef1:property#0
				}
				som "som_1" sub1[0].m1
				som "som_2" sub1[0].m2
				ps1::bool1 => true : pkg1::s3:property#0
			}''')
	}
	
	@Test
	def void testModalProperties() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				with ps1;
				
				system s
					modes
						m1: initial mode;
						m2: mode;
					properties
						ps1::bool1 => true in modes (m1), false in modes(m2);
				end s;
				
				system implementation s.i
					subcomponents
						sub1: system s;
				end s.i;
			end pkg1;
		''', '''
			property set ps1 is
				bool1: aadlboolean applies to (all);
			end ps1;
		''')
		assertSerialize(pkg1, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				system pkg1::s sub1 [ 0 ] : pkg1::s.i:sub1 {
					initial mode m1 : pkg1::s:m1
					mode m2 : pkg1::s:m2
					ps1::bool1 => true in modes ( som_1 , som_3 ) , false in modes ( som_2 , som_4 ) : pkg1::s:property#0
				}
				initial mode m1 : pkg1::s:m1
				mode m2 : pkg1::s:m2
				som "som_1" m1 , sub1[0].m1
				som "som_2" m1 , sub1[0].m2
				som "som_3" m2 , sub1[0].m1
				som "som_4" m2 , sub1[0].m2
				ps1::bool1 => true in modes ( som_1 , som_2 ) , false in modes ( som_3 , som_4 ) : pkg1::s:property#0
			}''')
	}
	
	@Test
	def void testPropertyTypes() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				with ps1;
				
				system s
					properties
						ps1::bool1 => true;
						ps1::string1 => "value";
						ps1::int1 => 42;
						ps1::int2 => -42;
						ps1::int3 => 42cm;
						ps1::real1 => 3.14;
						ps1::real2 => -3.14;
						ps1::real3 => 3.14cm;
						ps1::range1 => 0 .. 10;
						ps1::range2 => 0 .. 10 delta 2;
						ps1::range3 => 0cm .. 10cm;
						ps1::int4 => ps1::const1;
						ps1::int5 => ps1::int1;
						ps1::enum1 => two;
						ps1::classifier1 => classifier (s);
						ps1::int6 => compute (function1);
						ps1::record1 => [
							field1 => 42;
							field2 => [field3 => 42;];
							field4 => two;
							field5 => 42cm;
							field6 => 0cm .. 10cm;
						];
						ps1::list1 => (1, 2, 4, 8);
				end s;
				
				system implementation s.i
				end s.i;
			end pkg1;
		''', '''
			property set ps1 is
				enumType1: type enumeration (one, two, three);
				units1: type units (mm, cm => mm * 10, m => cm * 100);
				
				const1: constant aadlinteger => 42;
				
				bool1: aadlboolean applies to (all);
				string1: aadlstring applies to (all);
				int1: aadlinteger applies to (all);
				int2: aadlinteger applies to (all);
				int3: aadlinteger units ps1::units1 applies to (all);
				real1: aadlreal applies to (all);
				real2: aadlreal applies to (all);
				real3: aadlreal units ps1::units1 applies to (all);
				range1: range of aadlinteger applies to (all);
				range2: range of aadlinteger applies to (all);
				range3: range of aadlinteger units ps1::units1 applies to (all);
				int4: aadlinteger applies to (all);
				int5: aadlinteger applies to (all);
				enum1: ps1::enumType1 applies to (all);
				classifier1: classifier (system) applies to (all);
				int6: aadlinteger applies to (all);
				record1: record (
					field1: aadlinteger;
					field2: record (field3: aadlinteger;);
					field4: ps1::enumType1;
					field5: aadlinteger units ps1::units1;
					field6: range of aadlinteger units ps1::units1;
				) applies to (all);
				list1: list of aadlinteger applies to (all);
			end ps1;
		''')
		assertSerialize(pkg1, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				som "No Modes"
				ps1::bool1 => true : pkg1::s:property#0
				ps1::string1 => "value" : pkg1::s:property#1
				ps1::int1 => 42 : pkg1::s:property#2
				ps1::int2 => -42 : pkg1::s:property#3
				ps1::int3 => 42 cm : pkg1::s:property#4
				ps1::real1 => 3.14 : pkg1::s:property#5
				ps1::real2 => -3.14 : pkg1::s:property#6
				ps1::real3 => 3.14 cm : pkg1::s:property#7
				ps1::range1 => 0 .. 10 : pkg1::s:property#8
				ps1::range2 => 0 .. 10 delta 2 : pkg1::s:property#9
				ps1::range3 => 0 cm .. 10 cm : pkg1::s:property#10
				ps1::int4 => 42 : pkg1::s:property#11
				ps1::int5 => 42 : pkg1::s:property#12
				ps1::enum1 => two : pkg1::s:property#13
				ps1::classifier1 => classifier ( pkg1::s ) : pkg1::s:property#14
				ps1::int6 => compute ( function1 ) : pkg1::s:property#15
				ps1::record1 => [ field1 => 42 ; field2 => [ field3 => 42 ; ] ; field4 => two ; field5 => 42 cm ; field6 => 0 cm .. 10 cm ; ] : pkg1::s:property#16
				ps1::list1 => ( 1 , 2 , 4 , 8 ) : pkg1::s:property#17
			}''')
	}
	
	@Test
	def void testDeclarativeReferenceValue() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				with ps1;
				
				system s1
					prototypes
						proto1: system;
					features
						fg1: feature group fgt1;
						p1: in event port;
					modes
						m1: initial mode;
						m2: mode;
						mt1: m1-[p1]->m2;
				end s1;
				
				system implementation s1.i
					subcomponents
						sub1: system s2;
						sub2: abstract a1.i;
					internal features
						es1: event;
					processor features
						pp1: port;
					properties
						ps1::reference1 => reference (proto1);
						ps1::reference2 => reference (fg1.proto2);
						ps1::reference3 => reference (fg1.fg2.proto3);
						ps1::reference4 => reference (fg1.fg3[1].proto3);
						ps1::reference5 => reference (sub1.proto4);
						ps1::reference6 => reference (es1);
						ps1::reference7 => reference (pp1);
						ps1::reference8 => reference (sub2.sequence1);
						ps1::reference9 => reference (sub2.call1);
						ps1::reference10 => reference (mt1);
				end s1.i;
				
				feature group fgt1
					prototypes
						proto2: system;
					features
						fg2: feature group fgt2;
						fg3: feature group fgt2[2];
				end fgt1;
				
				feature group fgt2
					prototypes
						proto3: system;
				end fgt2;
				
				system s2
					prototypes
						proto4: system;
				end s2;
				
				abstract a1
					features
						sa1: requires subprogram access;
				end a1;
				
				abstract implementation a1.i
					calls
						sequence1: {
							call1: subprogram sa1;
						};
				end a1.i;
			end pkg1;
		''', '''
			property set ps1 is
				reference1: reference (named element) applies to (all);
				reference2: reference (named element) applies to (all);
				reference3: reference (named element) applies to (all);
				reference4: reference (named element) applies to (all);
				reference5: reference (named element) applies to (all);
				reference6: reference (named element) applies to (all);
				reference7: reference (named element) applies to (all);
				reference8: reference (named element) applies to (all);
				reference9: reference (named element) applies to (all);
				reference10: reference (named element) applies to (all);
			end ps1;
		''')
		assertSerialize(pkg1, "s1.i", '''
			system s1_i_Instance : pkg1::s1.i {
				in out featureGroup fg1 : pkg1::s1:fg1 {
					in out featureGroup fg2 : pkg1::fgt1:fg2
					in out featureGroup fg3 [ 1 ] : pkg1::fgt1:fg3
					in out featureGroup fg3 [ 2 ] : pkg1::fgt1:fg3
				}
				in eventPort p1 : pkg1::s1:p1
				abstract pkg1::a1.i sub2 [ 0 ] : pkg1::s1.i:sub2 {
					in out subprogramAccess sa1 : pkg1::a1:sa1
				}
				system pkg1::s2 sub1 [ 0 ] : pkg1::s1.i:sub1
				initial mode m1 : pkg1::s1:m1
				mode m2 : pkg1::s1:m2
				mode transition m1_p1_m2 m1 -[ p1 ]-> m2 : pkg1::s1:mt1
				som "som_1" m1
				som "som_2" m2
				ps1::reference1 => reference ( pkg1::s1:proto1 ) : pkg1::s1.i:property#0
				ps1::reference2 => reference ( pkg1::s1:fg1 / pkg1::fgt1:proto2 ) : pkg1::s1.i:property#1
				ps1::reference3 => reference ( pkg1::s1:fg1 / pkg1::fgt1:fg2 / pkg1::fgt2:proto3 ) : pkg1::s1.i:property#2
				ps1::reference4 => reference ( pkg1::s1:fg1 / pkg1::fgt1:fg3 [ 1 ] / pkg1::fgt2:proto3 ) : pkg1::s1.i:property#3
				ps1::reference5 => reference ( pkg1::s1.i:sub1 / pkg1::s2:proto4 ) : pkg1::s1.i:property#4
				ps1::reference6 => reference ( pkg1::s1.i:es1 ) : pkg1::s1.i:property#5
				ps1::reference7 => reference ( pkg1::s1.i:pp1 ) : pkg1::s1.i:property#6
				ps1::reference8 => reference ( pkg1::s1.i:sub2 / pkg1::a1.i:sequence1 ) : pkg1::s1.i:property#7
				ps1::reference9 => reference ( pkg1::s1.i:sub2 / pkg1::a1.i:call1 ) : pkg1::s1.i:property#8
				ps1::reference10 => reference ( m1_p1_m2 ) : pkg1::s1.i:property#9
			}''')
	}
	
	@Test
	def void testInstanceReferenceValue() {
		val pkg1 = testHelper.parseString('''
			package pkg1
			public
				with ps1;
				
				system s1
					features
						p1: out data port;
					properties
						ps1::reference1 => reference (p1);
				end s1;
				
				system s2
					features
						p2: in data port;
					flows
						f1: flow sink p2;
				end s2;
				
				system s3
					modes
						m1: initial mode;
				end s3;
				
				system implementation s3.i
					subcomponents
						sub1: system s1;
						sub2: system s2;
					connections
						conn1: port sub1.p1 -> sub2.p2;
					flows
						etef1: end to end flow sub1 -> conn1 -> sub2.f1;
					properties
						ps1::reference1 => reference (sub1.p1);
						ps1::reference2 => reference (sub2.f1);
						ps1::reference3 => reference (m1);
						ps1::reference4 => reference (sub1);
						ps1::reference5 => reference (conn1);
						ps1::reference6 => reference (etef1);
				end s3.i;
			end pkg1;
		''', '''
			property set ps1 is
				reference1: reference (named element) applies to (all);
				reference2: reference (named element) applies to (all);
				reference3: reference (named element) applies to (all);
				reference4: reference (named element) applies to (all);
				reference5: reference (named element) applies to (all);
				reference6: reference (named element) applies to (all);
			end ps1;
		''')
		assertSerialize(pkg1, "s3.i", '''
			system s3_i_Instance : pkg1::s3.i {
				system pkg1::s1 sub1 [ 0 ] : pkg1::s3.i:sub1 {
					out dataPort p1 : pkg1::s1:p1
					ps1::reference1 => reference ( sub1[0].p1 ) : pkg1::s1:property#0
				}
				system pkg1::s2 sub2 [ 0 ] : pkg1::s3.i:sub2 {
					in dataPort p2 : pkg1::s2:p2
					flow f1 ( p2 -> ) : pkg1::s2:f1
				}
				complete portConnection "sub1.p1 -> sub2.p2" : sub1[0].p1 -> sub2[0].p2 {
					sub1[0].p1 -> sub2[0].p2 : pkg1::s3.i:conn1 in parent
				}
				end to end flow etef1 sub1[0] -> connection#0 -> sub2[0].f1 : pkg1::s3.i:etef1
				initial mode m1 : pkg1::s3:m1
				som "som_1" m1
				ps1::reference1 => reference ( sub1[0].p1 ) : pkg1::s3.i:property#0
				ps1::reference2 => reference ( sub2[0].f1 ) : pkg1::s3.i:property#1
				ps1::reference3 => reference ( m1 ) : pkg1::s3.i:property#2
				ps1::reference4 => reference ( sub1[0] ) : pkg1::s3.i:property#3
				ps1::reference5 => reference ( connection#0 ) : pkg1::s3.i:property#4
				ps1::reference6 => reference ( etef1 ) : pkg1::s3.i:property#5
			}''')
	}
}