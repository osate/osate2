package org.osate.xtext.aadl2.instance.tests

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.DirectionType
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.instance.FeatureCategory
import org.osate.aadl2.instance.SystemInstance
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.instance.InstanceUiInjectorProvider

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(InstanceUiInjectorProvider)
class ParserTest extends OsateTest {
	override getProjectName() {
		"ParserTest"
	}
	
	@Test
	def void testEmptyInstance() {
		val pkg1FileName = "pkg1.aadl"
		val si1FileName = "si1.instance"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				system s
				end s;
				
				system implementation s.i
				end s.i;
			end pkg1;
		''', si1FileName -> '''
			system si1 : pkg1::s.i {
				som "No Modes"
			}
		''')
		suppressSerialization
		testFile(pkg1FileName)
		testFile(si1FileName).resource.contents.head as SystemInstance => [
			"si1".assertEquals(name)
			ComponentCategory.SYSTEM.assertEquals(category)
			"s.i".assertEquals(componentImplementation.name)
			1.assertEquals(systemOperationModes.size)
			systemOperationModes.head => [
				"No Modes".assertEquals(name)
			]
		]
	}
	
	@Test
	def void testCategories() {
		val pkg1FileName = "pkg1.aadl"
		val abstractFileName = "a.instance"
		val busFileName = "b.instance"
		val dataFileName = "d.instance"
		val deviceFileName = "dev.instance"
		val memoryFileName = "m.instance"
		val processFileName = "ps.instance"
		val processorFileName = "proc.instance"
		val subprogramFileName = "subp.instance"
		val subprogramGroupFileName = "subpg.instance"
		val systemFileName = "s.instance"
		val threadFileName = "t.instance"
		val threadGroupFileName = "tg.instance"
		val virtualBusFileName = "vb.instance"
		val virtualProcessorFileName = "vp.instance"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				abstract a
				end a;
				
				abstract implementation a.i
				end a.i;
				
				bus b
				end b;
				
				bus implementation b.i
				end b.i;
				
				data d
				end d;
				
				data implementation d.i
				end d.i;
				
				device dev
				end dev;
				
				device implementation dev.i
				end dev.i;
				
				memory m
				end m;
				
				memory implementation m.i
				end m.i;
				
				process ps
				end ps;
				
				process implementation ps.i
				end ps.i;
				
				processor proc
				end proc;
				
				processor implementation proc.i
				end proc.i;
				
				subprogram subp
				end subp;
				
				subprogram implementation subp.i
				end subp.i;
				
				subprogram group subpg
				end subpg;
				
				subprogram group implementation subpg.i
				end subpg.i;
				
				system s
				end sy;
				
				system implementation s.i
				end s.i;
				
				thread t
				end t;
				
				thread implementation t.i
				end t.i;
				
				thread group tg
				end tg;
				
				thread group implementation tg.i
				end tg.i;
				
				virtual bus vb
				end vb;
				
				virtual bus implementation vb.i
				end vb.i;
				
				virtual processor vp
				end vp;
				
				virtual processor implementation vp.i
				end vp.i;
			end pkg1;
		''', abstractFileName -> '''
			abstract aInstance : pkg1::a.i {
				som "No Modes"
			}
		''', busFileName -> '''
			bus bInstance : pkg1::b.i {
				som "No Modes"
			}
		''', dataFileName -> '''
			data dInstance : pkg1::d.i {
				som "No Modes"
			}
		''', deviceFileName -> '''
			device devInstance : pkg1::dev.i {
				som "No Modes"
			}
		''', memoryFileName -> '''
			memory mInstance : pkg1::m.i {
				som "No Modes"
			}
		''', processFileName -> '''
			process psInstance : pkg1::ps.i {
				som "No Modes"
			}
		''', processorFileName -> '''
			processor procInstance : pkg1::proc.i {
				som "No Modes"
			}
		''', subprogramFileName -> '''
			subprogram subpInstance : pkg1::subp.i {
				som "No Modes"
			}
		''', subprogramGroupFileName -> '''
			subprogram group subpgInstance : pkg1::subpg.i {
				som "No Modes"
			}
		''', systemFileName -> '''
			system sInstance : pkg1::s.i {
				som "No Modes"
			}
		''', threadFileName -> '''
			thread tInstance : pkg1::t.i {
				som "No Modes"
			}
		''', threadGroupFileName -> '''
			thread group tgInstance : pkg1::tg.i {
				som "No Modes"
			}
		''', virtualBusFileName -> '''
			virtual bus vbInstance : pkg1::vb.i {
				som "No Modes"
			}
		''', virtualProcessorFileName -> '''
			virtual processor vpInstance : pkg1::vp.i {
				som "No Modes"
			}
		''')
		suppressSerialization
		testFile(pkg1FileName)
		testFile(abstractFileName).resource.contents.head as SystemInstance => [
			"aInstance".assertEquals(name)
			ComponentCategory.ABSTRACT.assertEquals(category)
		]
		testFile(busFileName).resource.contents.head as SystemInstance => [
			"bInstance".assertEquals(name)
			ComponentCategory.BUS.assertEquals(category)
		]
		testFile(dataFileName).resource.contents.head as SystemInstance => [
			"dInstance".assertEquals(name)
			ComponentCategory.DATA.assertEquals(category)
		]
		testFile(deviceFileName).resource.contents.head as SystemInstance => [
			"devInstance".assertEquals(name)
			ComponentCategory.DEVICE.assertEquals(category)
		]
		testFile(memoryFileName).resource.contents.head as SystemInstance => [
			"mInstance".assertEquals(name)
			ComponentCategory.MEMORY.assertEquals(category)
		]
		testFile(processFileName).resource.contents.head as SystemInstance => [
			"psInstance".assertEquals(name)
			ComponentCategory.PROCESS.assertEquals(category)
		]
		testFile(processorFileName).resource.contents.head as SystemInstance => [
			"procInstance".assertEquals(name)
			ComponentCategory.PROCESSOR.assertEquals(category)
		]
		testFile(subprogramFileName).resource.contents.head as SystemInstance => [
			"subpInstance".assertEquals(name)
			ComponentCategory.SUBPROGRAM.assertEquals(category)
		]
		testFile(subprogramGroupFileName).resource.contents.head as SystemInstance => [
			"subpgInstance".assertEquals(name)
			ComponentCategory.SUBPROGRAM_GROUP.assertEquals(category)
		]
		testFile(systemFileName).resource.contents.head as SystemInstance => [
			"sInstance".assertEquals(name)
			ComponentCategory.SYSTEM.assertEquals(category)
		]
		testFile(threadFileName).resource.contents.head as SystemInstance => [
			"tInstance".assertEquals(name)
			ComponentCategory.THREAD.assertEquals(category)
		]
		testFile(threadGroupFileName).resource.contents.head as SystemInstance => [
			"tgInstance".assertEquals(name)
			ComponentCategory.THREAD_GROUP.assertEquals(category)
		]
		testFile(virtualBusFileName).resource.contents.head as SystemInstance => [
			"vbInstance".assertEquals(name)
			ComponentCategory.VIRTUAL_BUS.assertEquals(category)
		]
		testFile(virtualProcessorFileName).resource.contents.head as SystemInstance => [
			"vpInstance".assertEquals(name)
			ComponentCategory.VIRTUAL_PROCESSOR.assertEquals(category)
		]
	}
	
	@Test
	def void testSubcomponents() {
		val pkg1FileName = "pkg1.aadl"
		val si1FileName = "si1.instance"
		val si2FileName = "si2.instance"
		val si3FileName = "si3.instance"
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
				subcomponents
					psSub: process ps.i;
				end s.i2;
				
				process ps
				end ps;
				
				process implementation ps.i
				subcomponents
					tSub: thread;
				end ps.i;
				
				system implementation s.i3
				subcomponents
					aSub1: abstract;
					aSub2: abstract[3];
					aSub3: abstract[2][2];
				end s.i3;
			end pkg1;
		''', si1FileName -> '''
			system si1 : pkg1::s.i1 {
				abstract aSub[0] : pkg1::s.i1::aSub
				som "No Modes"
			}
		''', si2FileName -> '''
			system si2 : pkg1::s.i2 {
				process psSub[0] : pkg1::s.i2::psSub {
					thread tSub[0] : pkg1::ps.i::tSub
				}
				som "No Modes"
			}
		''', si3FileName -> '''
			system si3 : pkg1::s.i3 {
				abstract aSub1[0] : pkg1::s.i3::aSub1
				abstract aSub2[1] : pkg1::s.i3::aSub2
				abstract aSub2[2] : pkg1::s.i3::aSub2
				abstract aSub2[3] : pkg1::s.i3::aSub2
				abstract aSub3[1][1] : pkg1::s.i3::aSub3
				abstract aSub3[1][2] : pkg1::s.i3::aSub3
				abstract aSub3[2][1] : pkg1::s.i3::aSub3
				abstract aSub3[2][2] : pkg1::s.i3::aSub3
				som "No Modes"
			}
		''')
		suppressSerialization
		testFile(pkg1FileName)
		testFile(si1FileName).resource.contents.head as SystemInstance => [
			"si1".assertEquals(name)
			1.assertEquals(componentInstances.size)
			componentInstances.head => [
				"aSub".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i1".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub".assertEquals(subcomponent.name)
				1.assertEquals(indices.size)
				0L.assertEquals(indices.head)
				componentInstances.empty.assertTrue
			]
		]
		testFile(si2FileName).resource.contents.head as SystemInstance => [
			"si2".assertEquals(name)
			1.assertEquals(componentInstances.size)
			componentInstances.head => [
				"psSub".assertEquals(name)
				ComponentCategory.PROCESS.assertEquals(category)
				"pkg1::s.i2".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"psSub".assertEquals(subcomponent.name)
				1.assertEquals(indices.size)
				0L.assertEquals(indices.head)
				1.assertEquals(componentInstances.size)
				componentInstances.head => [
					"tSub".assertEquals(name)
					ComponentCategory.THREAD.assertEquals(category)
					"pkg1::ps.i".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
					"tSub".assertEquals(subcomponent.name)
					1.assertEquals(indices.size)
					0L.assertEquals(indices.head)
					componentInstances.empty.assertTrue
				]
			]
		]
		testFile(si3FileName).resource.contents.head as SystemInstance => [
			"si3".assertEquals(name)
			8.assertEquals(componentInstances.size)
			componentInstances.get(0) => [
				"aSub1".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub1".assertEquals(subcomponent.name)
				1.assertEquals(indices.size)
				0L.assertEquals(indices.head)
				componentInstances.empty.assertTrue
			]
			componentInstances.get(1) => [
				"aSub2".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub2".assertEquals(subcomponent.name)
				1.assertEquals(indices.size)
				1L.assertEquals(indices.head)
				componentInstances.empty.assertTrue
			]
			componentInstances.get(2) => [
				"aSub2".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub2".assertEquals(subcomponent.name)
				1.assertEquals(indices.size)
				2L.assertEquals(indices.head)
				componentInstances.empty.assertTrue
			]
			componentInstances.get(3) => [
				"aSub2".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub2".assertEquals(subcomponent.name)
				1.assertEquals(indices.size)
				3L.assertEquals(indices.head)
				componentInstances.empty.assertTrue
			]
			componentInstances.get(4) => [
				"aSub3".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub3".assertEquals(subcomponent.name)
				2.assertEquals(indices.size)
				1L.assertEquals(indices.get(0))
				1L.assertEquals(indices.get(1))
				componentInstances.empty.assertTrue
			]
			componentInstances.get(5) => [
				"aSub3".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub3".assertEquals(subcomponent.name)
				2.assertEquals(indices.size)
				1L.assertEquals(indices.get(0))
				2L.assertEquals(indices.get(1))
				componentInstances.empty.assertTrue
			]
			componentInstances.get(6) => [
				"aSub3".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub3".assertEquals(subcomponent.name)
				2.assertEquals(indices.size)
				2L.assertEquals(indices.get(0))
				1L.assertEquals(indices.get(1))
				componentInstances.empty.assertTrue
			]
			componentInstances.get(7) => [
				"aSub3".assertEquals(name)
				ComponentCategory.ABSTRACT.assertEquals(category)
				"pkg1::s.i3".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub3".assertEquals(subcomponent.name)
				2.assertEquals(indices.size)
				2L.assertEquals(indices.get(0))
				2L.assertEquals(indices.get(0))
				componentInstances.empty.assertTrue
			]
		]
	}
	
	@Test
	def void testNestedPackage() {
		val pkg1FileName = "a-b-c-d.aadl"
		val si1FileName = "si1.instance"
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
		''', si1FileName -> '''
			system si1 : a::b::c::d::s.i {
				abstract aSub[0] : a::b::c::d::s.i::aSub
				som "No Modes"
			}
		''')
		suppressSerialization
		testFile(pkg1FileName)
		testFile(si1FileName).resource.contents.head as SystemInstance => [
			"si1".assertEquals(name)
			"a::b::c::d::s.i".assertEquals(componentImplementation.getQualifiedName)
			1.assertEquals(componentInstances.size)
			componentInstances.head => [
				"a::b::c::d::s.i".assertEquals(subcomponent.getContainerOfType(ComponentImplementation).getQualifiedName)
				"aSub".assertEquals(subcomponent.name)
			]
		]
	}
	
	@Test
	def void testFeatures() {
		val pkg1FileName = "pkg1.aadl"
		val si1FileName = "si1.instance"
		val si2FileName = "si2.instance"
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
		''', si1FileName -> '''
			system si1 : pkg1::s1.i {
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
				abstract asub[0] : pkg1::s1.i::asub {
					in out featureGroup fg : pkg1::a::fg
					in out abstractFeature af : pkg1::a::af
					in out busAccess ba : pkg1::a::ba
					in out subprogramAccess subpa : pkg1::a::subpa
					in dataPort dp : pkg1::a::dp
					out eventPort ep : pkg1::a::ep
					in eventDataPort edp : pkg1::a::edp
					in out subprogramGroupAccess subpga : pkg1::a::subpga
				}
				subprogram subpsub[0] : pkg1::s1.i::subpsub {
					in parameter p : pkg1::subp::p
				}
				som "No Modes"
			}
		''', si2FileName -> '''
			system si2 : pkg1::s2.i {
				in dataPort dp1 : pkg1::s2::dp1
				in dataPort dp2[1] : pkg1::s2::dp2
				in dataPort dp2[2] : pkg1::s2::dp2
				in dataPort dp2[3] : pkg1::s2::dp2
				som "No Modes"
			}
		''')
		suppressSerialization
		testFile(pkg1FileName)
		testFile(si1FileName).resource.contents.head as SystemInstance => [
			"si1".assertEquals(name)
			9.assertEquals(featureInstances.size)
			featureInstances.get(0) => [
				"fg1".assertEquals(name)
				DirectionType.IN_OUT.assertEquals(direction)
				FeatureCategory.FEATURE_GROUP.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"fg1".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(1) => [
				"fg2".assertEquals(name)
				DirectionType.IN_OUT.assertEquals(direction)
				FeatureCategory.FEATURE_GROUP.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"fg2".assertEquals(feature.name)
				0.assertEquals(index)
				9.assertEquals(featureInstances.size)
				featureInstances.get(0) => [
					"ba".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.BUS_ACCESS.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"ba".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(1) => [
					"dp".assertEquals(name)
					DirectionType.IN.assertEquals(direction)
					FeatureCategory.DATA_PORT.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"dp".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(2) => [
					"edp".assertEquals(name)
					DirectionType.IN.assertEquals(direction)
					FeatureCategory.EVENT_DATA_PORT.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"edp".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(3) => [
					"ep".assertEquals(name)
					DirectionType.OUT.assertEquals(direction)
					FeatureCategory.EVENT_PORT.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"ep".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(4) => [
					"fg1".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.FEATURE_GROUP.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"fg1".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(5) => [
					"p".assertEquals(name)
					DirectionType.IN.assertEquals(direction)
					FeatureCategory.PARAMETER.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"p".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(6) => [
					"subpa".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.SUBPROGRAM_ACCESS.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"subpa".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(7) => [
					"subpga".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.SUBPROGRAM_GROUP_ACCESS.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"subpga".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(8) => [
					"af".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.ABSTRACT_FEATURE.assertEquals(category)
					"pkg1::fgt1".assertEquals(feature.getContainerOfType(FeatureGroupType).getQualifiedName)
					"af".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
			]
			featureInstances.get(2) => [
				"af".assertEquals(name)
				DirectionType.IN_OUT.assertEquals(direction)
				FeatureCategory.ABSTRACT_FEATURE.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"af".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(3) => [
				"ba".assertEquals(name)
				DirectionType.IN_OUT.assertEquals(direction)
				FeatureCategory.BUS_ACCESS.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"ba".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(4) => [
				"dp".assertEquals(name)
				DirectionType.IN.assertEquals(direction)
				FeatureCategory.DATA_PORT.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"dp".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(5) => [
				"subpga".assertEquals(name)
				DirectionType.IN_OUT.assertEquals(direction)
				FeatureCategory.SUBPROGRAM_GROUP_ACCESS.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"subpga".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(6) => [
				"subpa".assertEquals(name)
				DirectionType.IN_OUT.assertEquals(direction)
				FeatureCategory.SUBPROGRAM_ACCESS.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"subpa".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(7) => [
				"ep".assertEquals(name)
				DirectionType.OUT.assertEquals(direction)
				FeatureCategory.EVENT_PORT.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"ep".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(8) => [
				"edp".assertEquals(name)
				DirectionType.IN.assertEquals(direction)
				FeatureCategory.EVENT_DATA_PORT.assertEquals(category)
				"pkg1::s1".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"edp".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			componentInstances.get(0) => [
				"asub".assertEquals(name)
				8.assertEquals(featureInstances.size)
				featureInstances.get(0) => [
					"fg".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.FEATURE_GROUP.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"fg".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(1) => [
					"af".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.ABSTRACT_FEATURE.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"af".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(2) => [
					"ba".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.BUS_ACCESS.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"ba".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(3) => [
					"subpa".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.SUBPROGRAM_ACCESS.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"subpa".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(4) => [
					"dp".assertEquals(name)
					DirectionType.IN.assertEquals(direction)
					FeatureCategory.DATA_PORT.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"dp".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(5) => [
					"ep".assertEquals(name)
					DirectionType.OUT.assertEquals(direction)
					FeatureCategory.EVENT_PORT.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"ep".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(6) => [
					"edp".assertEquals(name)
					DirectionType.IN.assertEquals(direction)
					FeatureCategory.EVENT_DATA_PORT.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"edp".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
				featureInstances.get(7) => [
					"subpga".assertEquals(name)
					DirectionType.IN_OUT.assertEquals(direction)
					FeatureCategory.SUBPROGRAM_GROUP_ACCESS.assertEquals(category)
					"pkg1::a".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"subpga".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
			]
			componentInstances.get(1) => [
				"subpsub".assertEquals(name)
				1.assertEquals(featureInstances.size)
				featureInstances.head => [
					"p".assertEquals(name)
					DirectionType.IN.assertEquals(direction)
					FeatureCategory.PARAMETER.assertEquals(category)
					"pkg1::subp".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
					"p".assertEquals(feature.name)
					0.assertEquals(index)
					featureInstances.empty.assertTrue
				]
			]
		]
		testFile(si2FileName).resource.contents.head as SystemInstance => [
			"si2".assertEquals(name)
			4.assertEquals(featureInstances.size)
			featureInstances.get(0) => [
				"dp1".assertEquals(name)
				DirectionType.IN.assertEquals(direction)
				FeatureCategory.DATA_PORT.assertEquals(category)
				"pkg1::s2".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"dp1".assertEquals(feature.name)
				0.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(1) => [
				"dp2".assertEquals(name)
				DirectionType.IN.assertEquals(direction)
				FeatureCategory.DATA_PORT.assertEquals(category)
				"pkg1::s2".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"dp2".assertEquals(feature.name)
				1.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(2) => [
				"dp2".assertEquals(name)
				DirectionType.IN.assertEquals(direction)
				FeatureCategory.DATA_PORT.assertEquals(category)
				"pkg1::s2".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"dp2".assertEquals(feature.name)
				2.assertEquals(index)
				featureInstances.empty.assertTrue
			]
			featureInstances.get(3) => [
				"dp2".assertEquals(name)
				DirectionType.IN.assertEquals(direction)
				FeatureCategory.DATA_PORT.assertEquals(category)
				"pkg1::s2".assertEquals(feature.getContainerOfType(ComponentType).getQualifiedName)
				"dp2".assertEquals(feature.name)
				3.assertEquals(index)
				featureInstances.empty.assertTrue
			]
		]
	}
}