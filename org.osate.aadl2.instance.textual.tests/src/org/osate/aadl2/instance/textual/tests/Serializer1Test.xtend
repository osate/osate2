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

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.instance.textual.InstanceUiInjectorProvider

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(InstanceUiInjectorProvider)
class Serializer1Test extends AbstractSerializerTest {
	override getProjectName() {
		"SerializerTest1"
	}
	
	@Test
	def void testEmptyInstance() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system s
				end s;
				
				system implementation s.i
				end s.i;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				som "No Modes"
			}''')
	}
	
	@Test
	def void testSubcomponents() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system s
				end s;
				
				system implementation s.i1
				subcomponents
					aSub: abstract;
				end s.i1;
				
				system implementation s.i2
				prototypes
					psProto: process;
				subcomponents
					psSub: process psProto;
				end s.i2;
				
				system implementation s.i3 extends s.i2 (psProto => process ps.i)
				end s.i3;
				
				process ps
				end ps;
				
				process implementation ps.i
				subcomponents
					tSub: thread;
				end ps.i;
				
				system implementation s.i4
				subcomponents
					aSub1: abstract;
					aSub2: abstract[3];
					aSub3: abstract[2][2];
				end s.i4;
			end pkg1;
		''')
		suppressSerialization
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			assertSerialize("s.i1", '''
				system s_i1_Instance : pkg1::s.i1 {
					abstract aSub [ 0 ] : pkg1::s.i1:aSub
					som "No Modes"
				}''')
			assertSerialize("s.i3", '''
				system s_i3_Instance : pkg1::s.i3 {
					process pkg1::ps.i psSub [ 0 ] : pkg1::s.i2:psSub {
						thread tSub [ 0 ] : pkg1::ps.i:tSub
					}
					som "No Modes"
				}''')
			assertSerialize("s.i4", '''
				system s_i4_Instance : pkg1::s.i4 {
					abstract aSub1 [ 0 ] : pkg1::s.i4:aSub1
					abstract aSub2 [ 1 ] : pkg1::s.i4:aSub2
					abstract aSub2 [ 2 ] : pkg1::s.i4:aSub2
					abstract aSub2 [ 3 ] : pkg1::s.i4:aSub2
					abstract aSub3 [ 1 ] [ 1 ] : pkg1::s.i4:aSub3
					abstract aSub3 [ 1 ] [ 2 ] : pkg1::s.i4:aSub3
					abstract aSub3 [ 2 ] [ 1 ] : pkg1::s.i4:aSub3
					abstract aSub3 [ 2 ] [ 2 ] : pkg1::s.i4:aSub3
					som "No Modes"
				}''')
		]
	}
	
	@Test
	def void testNestedPackage() {
		val pkg1FileName = "a-b-c-d.aadl"
		createFiles(pkg1FileName -> '''
			package a::b::c::d
			public
				system s
				end s;
				
				system implementation s.i
				subcomponents
					aSub: abstract;
				end s.i;
			end a::b::c::d;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : a::b::c::d::s.i {
				abstract aSub [ 0 ] : a::b::c::d::s.i:aSub
				som "No Modes"
			}''')
	}
	
	@Test
	def void testFeatures() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				feature group fgt1
				features
					dp: in data port;
					ep: out event port;
					edp: in event data port;
					p: in parameter;
					ba: provides bus access;
					da: provides data access;
					subpa: provides subprogram access;
					subpga: provides subprogram group access;
					fg1: feature group;
					af: feature;
				end fgt1;
				
				abstract a
				features
					dp: in data port;
					ep: out event port;
					edp: in event data port;
					ba: provides bus access;
					da: provides data access;
					subpa: provides subprogram access;
					subpga: provides subprogram group access;
					fg: feature group;
					af: feature;
				end a;
				
				subprogram subp
				features
					p: in parameter;
				end subp;
				
				system s1
				features
					dp: in data port;
					ep: out event port;
					edp: in event data port;
					ba: provides bus access;
					da: provides data access;
					subpa: provides subprogram access;
					subpga: provides subprogram group access;
					fg1: feature group;
					fg2: feature group fgt1;
					af: feature;
				end s1;
				
				system implementation s1.i
				subcomponents
					asub: abstract a;
					subpsub: subprogram subp;
				end s1.i;
				
				system s2
				features
					dp1: in data port;
					dp2: in data port[3];
				end s2;
				
				system implementation s2.i
				end s2.i;
			end pkg1;
		''')
		suppressSerialization
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			assertSerialize("s1.i", '''
				system s1_i_Instance : pkg1::s1.i {
					in out featureGroup fg1 : pkg1::s1:fg1
					in out featureGroup fg2 : pkg1::s1:fg2 {
						in out busAccess ba : pkg1::fgt1:ba
						in out dataAccess da : pkg1::fgt1:da
						in dataPort dp : pkg1::fgt1:dp
						in eventDataPort edp : pkg1::fgt1:edp
						out eventPort ep : pkg1::fgt1:ep
						in out featureGroup fg1 : pkg1::fgt1:fg1
						in parameter p : pkg1::fgt1:p
						in out subprogramAccess subpa : pkg1::fgt1:subpa
						in out subprogramGroupAccess subpga : pkg1::fgt1:subpga
						in out abstractFeature af : pkg1::fgt1:af
					}
					in out abstractFeature af : pkg1::s1:af
					in out busAccess ba : pkg1::s1:ba
					in out dataAccess da : pkg1::s1:da
					in dataPort dp : pkg1::s1:dp
					in out subprogramGroupAccess subpga : pkg1::s1:subpga
					in out subprogramAccess subpa : pkg1::s1:subpa
					out eventPort ep : pkg1::s1:ep
					in eventDataPort edp : pkg1::s1:edp
					abstract pkg1::a asub [ 0 ] : pkg1::s1.i:asub {
						in out featureGroup fg : pkg1::a:fg
						in out abstractFeature af : pkg1::a:af
						in out busAccess ba : pkg1::a:ba
						in out dataAccess da : pkg1::a:da
						in out subprogramAccess subpa : pkg1::a:subpa
						in dataPort dp : pkg1::a:dp
						out eventPort ep : pkg1::a:ep
						in eventDataPort edp : pkg1::a:edp
						in out subprogramGroupAccess subpga : pkg1::a:subpga
					}
					subprogram pkg1::subp subpsub [ 0 ] : pkg1::s1.i:subpsub {
						in parameter p : pkg1::subp:p
					}
					som "No Modes"
				}''')
			assertSerialize("s2.i", '''
				system s2_i_Instance : pkg1::s2.i {
					in dataPort dp1 : pkg1::s2:dp1
					in dataPort dp2 [ 1 ] : pkg1::s2:dp2
					in dataPort dp2 [ 2 ] : pkg1::s2:dp2
					in dataPort dp2 [ 3 ] : pkg1::s2:dp2
					som "No Modes"
				}''')
		]
	}
	
	@Test
	def void testSimpleAcrossConnection() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system s
				end s;
				
				system implementation s.i
				subcomponents
					sub1: device dev1;
					sub2: device dev2;
				connections
					conn1: port sub1.op -> sub2.ip;
					conn2: port sub1.op -> sub2.ip;
				end s.i;
				
				device dev1
				features
					op: out data port;
				end dev1;
				
				device dev2
				features
					ip: in data port;
				end dev2;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				device pkg1::dev1 sub1 [ 0 ] : pkg1::s.i:sub1 {
					out dataPort op : pkg1::dev1:op
				}
				device pkg1::dev2 sub2 [ 0 ] : pkg1::s.i:sub2 {
					in dataPort ip : pkg1::dev2:ip
				}
				complete portConnection "sub1.op -> sub2.ip" : sub1[0].op -> sub2[0].ip {
					sub1[0].op -> sub2[0].ip : pkg1::s.i:conn1 in parent
				}
				complete portConnection "sub1.op -> sub2.ip" : sub1[0].op -> sub2[0].ip {
					sub1[0].op -> sub2[0].ip : pkg1::s.i:conn2 in parent
				}
				som "No Modes"
			}''')
	}
	
	@Test
	def void testAcrossToComponentConnection() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				processor p
				features
					ba: requires bus access;
				end p;
				
				system s
				end s;
				
				system implementation s.i
				subcomponents
					psub: processor p;
					b: bus;
				connections
					conn1: bus access psub.ba <-> b;
				end s.i;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				bus b [ 0 ] : pkg1::s.i:b
				processor pkg1::p psub [ 0 ] : pkg1::s.i:psub {
					in out busAccess ba : pkg1::p:ba
				}
				complete accessConnection "b <-> psub.ba" : b[0] <-> psub[0].ba {
					b[0] -> psub[0].ba : pkg1::s.i:conn1 in parent
				}
				som "No Modes"
			}''')
	}
	
	@Test
	def void testUpAndDownAndAcrossConnection() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				thread t1
				features
					op: out data port;
				end t1;
				
				process p1
				features
					op: out data port;
				end p1;
				
				process implementation p1.i
				subcomponents
					t1sub: thread t1;
				connections
					p1conn: port t1sub.op -> op;
				end p1.i;
				
				thread t2
				features
					ip: in data port;
				end t2;
				
				process p2
				features
					ip: in data port;
				end p2;
				
				process implementation p2.i
				subcomponents
					t2sub: thread t2;
				connections
					p2conn: port ip -> t2sub.ip;
				end p2.i;
				
				system s
				end s;
				
				system implementation s.i
				subcomponents
					p1sub: process p1.i;
					p2sub: process p2.i;
				connections
					conn: port p1sub.op -> p2sub.ip;
				end s.i;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				process pkg1::p1.i p1sub [ 0 ] : pkg1::s.i:p1sub {
					out dataPort op : pkg1::p1:op
					thread pkg1::t1 t1sub [ 0 ] : pkg1::p1.i:t1sub {
						out dataPort op : pkg1::t1:op
					}
				}
				process pkg1::p2.i p2sub [ 0 ] : pkg1::s.i:p2sub {
					in dataPort ip : pkg1::p2:ip
					thread pkg1::t2 t2sub [ 0 ] : pkg1::p2.i:t2sub {
						in dataPort ip : pkg1::t2:ip
					}
				}
				complete portConnection "p1sub.t1sub.op -> p2sub.t2sub.ip" : p1sub[0].t1sub[0].op -> p2sub[0].t2sub[0].ip {
					p1sub[0].t1sub[0].op -> p1sub[0].op : pkg1::p1.i:p1conn in p1sub[0]
					p1sub[0].op -> p2sub[0].ip : pkg1::s.i:conn in parent
					p2sub[0].ip -> p2sub[0].t2sub[0].ip : pkg1::p2.i:p2conn in p2sub[0]
				}
				som "No Modes"
			}''')
	}
	
	@Test
	def void testUpAndDownConnections() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				process p
				features
					ip: in data port;
					op: out data port;
				end p;
				
				system s
				features
					ip: in data port;
					op: out data port;
				end s;
				
				system implementation s.i
				subcomponents
					psub: process p;
				connections
					conn1: port ip -> psub.ip;
					conn2: port psub.op -> op;
				end s.i;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				in dataPort ip : pkg1::s:ip
				out dataPort op : pkg1::s:op
				process pkg1::p psub [ 0 ] : pkg1::s.i:psub {
					in dataPort ip : pkg1::p:ip
					out dataPort op : pkg1::p:op
				}
				portConnection "ip -> psub.ip" : ip -> psub[0].ip {
					ip -> psub[0].ip : pkg1::s.i:conn1 in parent
				}
				portConnection "psub.op -> op" : psub[0].op -> op {
					psub[0].op -> op : pkg1::s.i:conn2 in parent
				}
				som "No Modes"
			}''')
	}
	
	@Test
	def void testConnectionInSubcomponent() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				thread t1
				features
					op: out data port;
				end t1;
				
				thread t2
				features
					ip: in data port;
				end t2;
				
				process p
				end p;
				
				process implementation p.i
				subcomponents
					t1sub: thread t1;
					t2sub: thread t2;
				connections
					conn1: port t1sub.op -> t2sub.ip;
				end p.i;
				
				system s
				end s;
				
				system implementation s.i
				subcomponents
					psub: process p.i;
				end s.i;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				process pkg1::p.i psub [ 0 ] : pkg1::s.i:psub {
					thread pkg1::t1 t1sub [ 0 ] : pkg1::p.i:t1sub {
						out dataPort op : pkg1::t1:op
					}
					thread pkg1::t2 t2sub [ 0 ] : pkg1::p.i:t2sub {
						in dataPort ip : pkg1::t2:ip
					}
					complete portConnection "t1sub.op -> t2sub.ip" : t1sub[0].op -> t2sub[0].ip {
						t1sub[0].op -> t2sub[0].ip : pkg1::p.i:conn1 in parent
					}
				}
				som "No Modes"
			}''')
	}
	
	@Test
	def void testConnectionKinds() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				abstract a1
				features
					af1: feature;
					ba1: provides bus access;
					ep1: out event port;
					fg1: feature group;
				end a1;
				
				abstract a2
				features
					af2: feature;
					ba2: requires bus access;
					ep2: in event port;
					fg2: feature group;
				end a2;
				
				abstract top
				end top;
				
				abstract implementation top.i
				subcomponents
					a1sub: abstract a1;
					a2sub: abstract a2;
				connections
					conn1: feature a1sub.af1 -> a2sub.af2;
					conn2: bus access a1sub.ba1 -> a2sub.ba2;
					conn3: port a1sub.ep1 -> a2sub.ep2;
					conn4: feature group a1sub.fg1 -> a2sub.fg2;
				end top.i;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "top.i", '''
			abstract top_i_Instance : pkg1::top.i {
				abstract pkg1::a1 a1sub [ 0 ] : pkg1::top.i:a1sub {
					in out featureGroup fg1 : pkg1::a1:fg1
					in out abstractFeature af1 : pkg1::a1:af1
					in out busAccess ba1 : pkg1::a1:ba1
					out eventPort ep1 : pkg1::a1:ep1
				}
				abstract pkg1::a2 a2sub [ 0 ] : pkg1::top.i:a2sub {
					in out featureGroup fg2 : pkg1::a2:fg2
					in out abstractFeature af2 : pkg1::a2:af2
					in out busAccess ba2 : pkg1::a2:ba2
					in eventPort ep2 : pkg1::a2:ep2
				}
				complete featureGroupConnection "a1sub.fg1 -> a2sub.fg2" : a1sub[0].fg1 -> a2sub[0].fg2 {
					a1sub[0].fg1 -> a2sub[0].fg2 : pkg1::top.i:conn4 in parent
				}
				complete featureConnection "a1sub.af1 -> a2sub.af2" : a1sub[0].af1 -> a2sub[0].af2 {
					a1sub[0].af1 -> a2sub[0].af2 : pkg1::top.i:conn1 in parent
				}
				complete accessConnection "a1sub.ba1 -> a2sub.ba2" : a1sub[0].ba1 -> a2sub[0].ba2 {
					a1sub[0].ba1 -> a2sub[0].ba2 : pkg1::top.i:conn2 in parent
				}
				complete portConnection "a1sub.ep1 -> a2sub.ep2" : a1sub[0].ep1 -> a2sub[0].ep2 {
					a1sub[0].ep1 -> a2sub[0].ep2 : pkg1::top.i:conn3 in parent
				}
				som "No Modes"
			}''')
	}
	
	@Test
	def void testFeatureGroupConnections() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				feature group fgt1
				features
					dp1: out data port;
					ep1: out event port;
				end fgt1;
				
				feature group fgt2
				end fgt2;
				
				thread t1
				features
					fg1: feature group fgt1;
					fg2: feature group fgt2;
					fg3: feature group;
				end t1;
				
				process p1
				features
					fg4: feature group fgt1;
					fg5: feature group fgt2;
					fg6: feature group;
				end p1;
				
				process implementation p1.i
				subcomponents
					t1sub: thread t1;
				connections
					conn1: feature group t1sub.fg1 -> fg4;
					conn2: feature group t1sub.fg2 -> fg5;
					conn3: feature group t1sub.fg3 -> fg6;
				end p1.i;
				
				thread t2
				features
					fg7: feature group inverse of fgt1;
					fg8: feature group inverse of fgt2;
					fg9: feature group;
				end t2;
				
				process p2
				features
					fg10: feature group inverse of fgt1;
					fg11: feature group inverse of fgt2;
					fg12: feature group;
				end p2;
				
				process implementation p2.i
				subcomponents
					t2sub: thread t2;
				connections
					conn4: feature group fg10 -> t2sub.fg7;
					conn5: feature group fg11 -> t2sub.fg8;
					conn6: feature group fg12 -> t2sub.fg9;
				end p2.i;
				
				system s
				end s;
				
				system implementation s.i
				subcomponents
					p1sub: process p1.i;
					p2sub: process p2.i;
				connections
					conn7: feature group p1sub.fg4 -> p2sub.fg10;
					conn8: feature group p1sub.fg5 -> p2sub.fg11;
					conn9: feature group p1sub.fg6 -> p2sub.fg12;
				end s.i;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				process pkg1::p1.i p1sub [ 0 ] : pkg1::s.i:p1sub {
					in out featureGroup fg4 : pkg1::p1:fg4 {
						out dataPort dp1 : pkg1::fgt1:dp1
						out eventPort ep1 : pkg1::fgt1:ep1
					}
					in out featureGroup fg5 : pkg1::p1:fg5
					in out featureGroup fg6 : pkg1::p1:fg6
					thread pkg1::t1 t1sub [ 0 ] : pkg1::p1.i:t1sub {
						in out featureGroup fg1 : pkg1::t1:fg1 {
							out dataPort dp1 : pkg1::fgt1:dp1
							out eventPort ep1 : pkg1::fgt1:ep1
						}
						in out featureGroup fg2 : pkg1::t1:fg2
						in out featureGroup fg3 : pkg1::t1:fg3
					}
				}
				process pkg1::p2.i p2sub [ 0 ] : pkg1::s.i:p2sub {
					in out featureGroup fg10 : pkg1::p2:fg10 {
						in dataPort dp1 : pkg1::fgt1:dp1
						in eventPort ep1 : pkg1::fgt1:ep1
					}
					in out featureGroup fg11 : pkg1::p2:fg11
					in out featureGroup fg12 : pkg1::p2:fg12
					thread pkg1::t2 t2sub [ 0 ] : pkg1::p2.i:t2sub {
						in out featureGroup fg7 : pkg1::t2:fg7 {
							in dataPort dp1 : pkg1::fgt1:dp1
							in eventPort ep1 : pkg1::fgt1:ep1
						}
						in out featureGroup fg8 : pkg1::t2:fg8
						in out featureGroup fg9 : pkg1::t2:fg9
					}
				}
				complete portConnection "p1sub.t1sub.fg1.dp1 -> p2sub.t2sub.fg7.dp1" : p1sub[0].t1sub[0].fg1.dp1 -> p2sub[0].t2sub[0].fg7.dp1 {
					p1sub[0].t1sub[0].fg1.dp1 -> p1sub[0].fg4.dp1 : pkg1::p1.i:conn1 in p1sub[0]
					p1sub[0].fg4.dp1 -> p2sub[0].fg10.dp1 : pkg1::s.i:conn7 in parent
					p2sub[0].fg10.dp1 -> p2sub[0].t2sub[0].fg7.dp1 : pkg1::p2.i:conn4 in p2sub[0]
				}
				complete portConnection "p1sub.t1sub.fg1.ep1 -> p2sub.t2sub.fg7.ep1" : p1sub[0].t1sub[0].fg1.ep1 -> p2sub[0].t2sub[0].fg7.ep1 {
					p1sub[0].t1sub[0].fg1.ep1 -> p1sub[0].fg4.ep1 : pkg1::p1.i:conn1 in p1sub[0]
					p1sub[0].fg4.ep1 -> p2sub[0].fg10.ep1 : pkg1::s.i:conn7 in parent
					p2sub[0].fg10.ep1 -> p2sub[0].t2sub[0].fg7.ep1 : pkg1::p2.i:conn4 in p2sub[0]
				}
				complete featureGroupConnection "p1sub.t1sub.fg2 -> p2sub.t2sub.fg8" : p1sub[0].t1sub[0].fg2 -> p2sub[0].t2sub[0].fg8 {
					p1sub[0].t1sub[0].fg2 -> p1sub[0].fg5 : pkg1::p1.i:conn2 in p1sub[0]
					p1sub[0].fg5 -> p2sub[0].fg11 : pkg1::s.i:conn8 in parent
					p2sub[0].fg11 -> p2sub[0].t2sub[0].fg8 : pkg1::p2.i:conn5 in p2sub[0]
				}
				complete featureGroupConnection "p1sub.t1sub.fg3 -> p2sub.t2sub.fg9" : p1sub[0].t1sub[0].fg3 -> p2sub[0].t2sub[0].fg9 {
					p1sub[0].t1sub[0].fg3 -> p1sub[0].fg6 : pkg1::p1.i:conn3 in p1sub[0]
					p1sub[0].fg6 -> p2sub[0].fg12 : pkg1::s.i:conn9 in parent
					p2sub[0].fg12 -> p2sub[0].t2sub[0].fg9 : pkg1::p2.i:conn6 in p2sub[0]
				}
				som "No Modes"
			}''')
	}
	
	@Test
	def void testFlowSpecification() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system s
					features
						p1: in data port;
						p2: out data port;
						p3: in data port[2];
						fg1: feature group fgt1;
						fg2: feature group fgt2[2];
					flows
						f1: flow source p2;
						f2: flow sink p1;
						f3: flow path p1 -> p2;
						f4: flow sink p3;
						f5: flow sink fg1.p4;
						f6: flow sink fg1.p5;
						f7: flow sink fg2.p6;
				end s;
				
				system implementation s.i
					subcomponents
						s2_sub: system s2;
					connections
						conn1: port p1 -> s2_sub.p7;
				end s.i;
				
				feature group fgt1
					features
						p4: in data port;
						p5: in data port[2];
				end fgt1;
				
				feature group fgt2
					features
						p6: in data port;
				end fgt2;
				
				system s2
					features
						p7: in data port;
					flows
						f8: flow sink p7;
				end s2;
			end pkg1;
		''')
		suppressSerialization
		assertSerialize(testFile(pkg1FileName).resource.contents.head as AadlPackage, "s.i", '''
			system s_i_Instance : pkg1::s.i {
				in out featureGroup fg1 : pkg1::s:fg1 {
					in dataPort p4 : pkg1::fgt1:p4
					in dataPort p5 [ 1 ] : pkg1::fgt1:p5
					in dataPort p5 [ 2 ] : pkg1::fgt1:p5
				}
				in out featureGroup fg2 [ 1 ] : pkg1::s:fg2 {
					in dataPort p6 : pkg1::fgt2:p6
				}
				in out featureGroup fg2 [ 2 ] : pkg1::s:fg2 {
					in dataPort p6 : pkg1::fgt2:p6
				}
				in dataPort p1 : pkg1::s:p1
				out dataPort p2 : pkg1::s:p2
				in dataPort p3 [ 1 ] : pkg1::s:p3
				in dataPort p3 [ 2 ] : pkg1::s:p3
				system pkg1::s2 s2_sub [ 0 ] : pkg1::s.i:s2_sub {
					in dataPort p7 : pkg1::s2:p7
					flow f8 ( p7 -> ) : pkg1::s2:f8
				}
				portConnection "p1 -> s2_sub.p7" : p1 -> s2_sub[0].p7 {
					p1 -> s2_sub[0].p7 : pkg1::s.i:conn1 in parent
				}
				flow f1 ( -> p2 ) : pkg1::s:f1
				flow f2 ( p1 -> ) : pkg1::s:f2
				flow f3 ( p1 -> p2 ) : pkg1::s:f3
				flow f4 ( p3[1] -> ) : pkg1::s:f4
				flow f5 ( fg1.p4 -> ) : pkg1::s:f5
				flow f6 ( fg1.p5[1] -> ) : pkg1::s:f6
				flow f7 ( fg2[1].p6 -> ) : pkg1::s:f7
				som "No Modes"
			}''')
	}
}