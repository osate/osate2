package org.osate.xtext.aadl2.instance.tests

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.instance.SystemInstance
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.instance.InstanceUiInjectorProvider

import static extension org.junit.Assert.assertEquals

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
}