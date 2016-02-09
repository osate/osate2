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
					abstract aSub : pkg1::s.i1::aSub [ 0 ]
					som "No Modes"
				}''')
			assertSerialize("s.i3", '''
				system s_i3_Instance : pkg1::s.i3 {
					process psSub : pkg1::s.i2::psSub [ 0 ] {
						thread tSub : pkg1::ps.i::tSub [ 0 ]
					}
					som "No Modes"
				}''')
			assertSerialize("s.i4", '''
				system s_i4_Instance : pkg1::s.i4 {
					abstract aSub1 : pkg1::s.i4::aSub1 [ 0 ]
					abstract aSub2 : pkg1::s.i4::aSub2 [ 1 ]
					abstract aSub2 : pkg1::s.i4::aSub2 [ 2 ]
					abstract aSub2 : pkg1::s.i4::aSub2 [ 3 ]
					abstract aSub3 : pkg1::s.i4::aSub3 [ 1 , 1 ]
					abstract aSub3 : pkg1::s.i4::aSub3 [ 1 , 2 ]
					abstract aSub3 : pkg1::s.i4::aSub3 [ 2 , 1 ]
					abstract aSub3 : pkg1::s.i4::aSub3 [ 2 , 2 ]
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
				abstract aSub : a::b::c::d::s.i::aSub [ 0 ]
				som "No Modes"
			}''')
	}
	
	def private assertSerialize(AadlPackage aadlPackage, String implName, String expected) {
		val impl = aadlPackage.publicSection.ownedClassifiers.filter(ComponentImplementation).findFirst[implName == name]
		impl.assertNotNull
		expected.assertEquals(impl.buildInstanceModelFile.serialize)
	}
}