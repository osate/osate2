package org.osate.xtext.aadl2.instance.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.serializer.ISerializer
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.instance.InstanceUiInjectorProvider

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNotNull
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner)
@InjectWith(InstanceUiInjectorProvider)
class SerializerTest extends OsateTest {
	@Inject
	extension ISerializer
	
	override getProjectName() {
		"SerializerTest"
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
					abstract aSub [ 0 ] : pkg1::s.i1::aSub
					som "No Modes"
				}''')
			assertSerialize("s.i3", '''
				system s_i3_Instance : pkg1::s.i3 {
					process psSub [ 0 ] : pkg1::s.i2::psSub {
						thread tSub [ 0 ] : pkg1::ps.i::tSub
					}
					som "No Modes"
				}''')
			assertSerialize("s.i4", '''
				system s_i4_Instance : pkg1::s.i4 {
					abstract aSub1 [ 0 ] : pkg1::s.i4::aSub1
					abstract aSub2 [ 1 ] : pkg1::s.i4::aSub2
					abstract aSub2 [ 2 ] : pkg1::s.i4::aSub2
					abstract aSub2 [ 3 ] : pkg1::s.i4::aSub2
					abstract aSub3 [ 1 ] [ 1 ] : pkg1::s.i4::aSub3
					abstract aSub3 [ 1 ] [ 2 ] : pkg1::s.i4::aSub3
					abstract aSub3 [ 2 ] [ 1 ] : pkg1::s.i4::aSub3
					abstract aSub3 [ 2 ] [ 2 ] : pkg1::s.i4::aSub3
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
				abstract aSub [ 0 ] : a::b::c::d::s.i::aSub
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
					in out featureGroup fg1 : pkg1::s1::fg1
					in out featureGroup fg2 : pkg1::s1::fg2 {
						in out busAccess ba : pkg1::fgt1::ba
						in dataPort dp : pkg1::fgt1::dp
						in eventDataPort edp : pkg1::fgt1::edp
						out eventPort ep : pkg1::fgt1::ep
						in out featureGroup fg1 : pkg1::fgt1::fg1
						in parameter p : pkg1::fgt1::p
						in out subprogramAccess subpa : pkg1::fgt1::subpa
						in out subprogramGroupAccess subpga : pkg1::fgt1::subpga
						in out abstractFeature af : pkg1::fgt1::af
					}
					in out abstractFeature af : pkg1::s1::af
					in out busAccess ba : pkg1::s1::ba
					in dataPort dp : pkg1::s1::dp
					in out subprogramGroupAccess subpga : pkg1::s1::subpga
					in out subprogramAccess subpa : pkg1::s1::subpa
					out eventPort ep : pkg1::s1::ep
					in eventDataPort edp : pkg1::s1::edp
					abstract asub [ 0 ] : pkg1::s1.i::asub {
						in out featureGroup fg : pkg1::a::fg
						in out abstractFeature af : pkg1::a::af
						in out busAccess ba : pkg1::a::ba
						in out subprogramAccess subpa : pkg1::a::subpa
						in dataPort dp : pkg1::a::dp
						out eventPort ep : pkg1::a::ep
						in eventDataPort edp : pkg1::a::edp
						in out subprogramGroupAccess subpga : pkg1::a::subpga
					}
					subprogram subpsub [ 0 ] : pkg1::s1.i::subpsub {
						in parameter p : pkg1::subp::p
					}
					som "No Modes"
				}''')
			assertSerialize("s2.i", '''
				system s2_i_Instance : pkg1::s2.i {
					in dataPort dp1 : pkg1::s2::dp1
					in dataPort dp2 [ 1 ] : pkg1::s2::dp2
					in dataPort dp2 [ 2 ] : pkg1::s2::dp2
					in dataPort dp2 [ 3 ] : pkg1::s2::dp2
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
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			assertSerialize("s.i", '''
				system s_i_Instance : pkg1::s.i {
					device sub1 [ 0 ] : pkg1::s.i::sub1 {
						out dataPort op : pkg1::dev1::op source of ( 1.0 , 1.1 )
					}
					device sub2 [ 0 ] : pkg1::s.i::sub2 {
						in dataPort ip : pkg1::dev2::ip destination of ( 1.0 , 1.1 )
					}
					complete portConnection "sub1.op -> sub2.ip" : sub1[0].op -> sub2[0].ip {
						sub1[0].op -> sub2[0].ip : pkg1::s.i::conn1 in parent
					}
					complete portConnection "sub1.op -> sub2.ip" : sub1[0].op -> sub2[0].ip {
						sub1[0].op -> sub2[0].ip : pkg1::s.i::conn2 in parent
					}
					som "No Modes"
				}''')
		]
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
					b1: bus;
					b2: bus;
				connections
					conn1: bus access psub.ba -> b1;
					conn2: bus access b2 -> psub.ba;
				end s.i;
			end pkg1;
		''')
		suppressSerialization
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			assertSerialize("s.i", '''
				system s_i_Instance : pkg1::s.i {
					bus b1 [ 0 ] : pkg1::s.i::b1 destination of ( 1 )
					bus b2 [ 0 ] : pkg1::s.i::b2 source of ( 0 )
					processor psub [ 0 ] : pkg1::s.i::psub {
						in out busAccess ba : pkg1::p::ba source of ( 1.1 ) destination of ( 1.0 )
					}
					complete accessConnection "b2 -> psub.ba" : b2[0] -> psub[0].ba {
						b2[0] -> psub[0].ba : pkg1::s.i::conn2 in parent
					}
					complete accessConnection "psub.ba -> b1" : psub[0].ba -> b1[0] {
						psub[0].ba -> b1[0] : pkg1::s.i::conn1 in parent
					}
					som "No Modes"
				}''')
		]
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
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			assertSerialize("s.i", '''
				system s_i_Instance : pkg1::s.i {
					process p1sub [ 0 ] : pkg1::s.i::p1sub {
						out dataPort op : pkg1::p1::op
						thread t1sub [ 0 ] : pkg1::p1.i::t1sub {
							out dataPort op : pkg1::t1::op source of ( 2.0 )
						}
					}
					process p2sub [ 0 ] : pkg1::s.i::p2sub {
						in dataPort ip : pkg1::p2::ip
						thread t2sub [ 0 ] : pkg1::p2.i::t2sub {
							in dataPort ip : pkg1::t2::ip destination of ( 2.0 )
						}
					}
					complete portConnection "p1sub.t1sub.op -> p2sub.t2sub.ip" :
					p1sub[0].t1sub[0].op -> p2sub[0].t2sub[0].ip {
						p1sub[0].t1sub[0].op -> p1sub[0].op : pkg1::p1.i::p1conn in p1sub[0]
						p1sub[0].op -> p2sub[0].ip : pkg1::s.i::conn in parent
						p2sub[0].ip -> p2sub[0].t2sub[0].ip : pkg1::p2.i::p2conn in p2sub[0]
					}
					som "No Modes"
				}''')
		]
	}
	
	def private assertSerialize(AadlPackage aadlPackage, String implName, String expected) {
		val impl = aadlPackage.publicSection.ownedClassifiers.filter(ComponentImplementation).findFirst[implName == name]
		impl.assertNotNull
		expected.assertEquals(impl.buildInstanceModelFile.serialize)
	}
}