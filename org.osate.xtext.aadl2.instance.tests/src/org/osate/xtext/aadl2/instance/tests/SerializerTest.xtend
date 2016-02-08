package org.osate.xtext.aadl2.instance.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.serializer.ISerializer
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.instance.InstanceUiInjectorProvider

import static extension org.junit.Assert.assertEquals
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
		val impl = (testFile(pkg1FileName).resource.contents.head as AadlPackage).publicSection.ownedClassifiers.get(1) as SystemImplementation
		"s.i".assertEquals(impl.name)
		'''
			system s_i_Instance : pkg1::s.i {
				som "No Modes"
			}'''.toString.assertEquals(impl.buildInstanceModelFile.serialize)
	}
}