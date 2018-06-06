package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2UiInjectorProvider
import org.osate.testsupport.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue560Test extends OsateTest {
	@Test
	def void issue560() {
		val aadlFile = "issue560.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.i" not found', cls.exists[name == 'top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('top_i_Instance', instance.name)

		// check if there is 1 connection
		val connections = instance.connectionInstances
		assertTrue('In top_i_instance: Expected 1 connection but found ' + connections.size, connections.size == 1)
	}

	val aadlText = '''
		package issue560
		public

			system top
				prototypes
					fgproto1: feature group fgt1;
				features
					fg1: feature group fgt1;
					fg4: feature group fgproto1;
			end top;

			system implementation top.i
				subcomponents
					asub1: abstract a2.i;
				connections
					conn5: feature group fg4.fg3 -> asub1.fg2;
			end top.i;

			abstract a2
				features
					fg2: feature group;
			end a2;

			abstract implementation a2.i
			end a2.i;

			feature group fgt1
				features
					fg3: feature group;
			end fgt1;
		end issue560;
	'''
}
