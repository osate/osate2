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
			1.assertEquals(systemOperationModes.size)
			systemOperationModes.head => [
				"No Modes".assertEquals(name)
			]
		]
	}
}