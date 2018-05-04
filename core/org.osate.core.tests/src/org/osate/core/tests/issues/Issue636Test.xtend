package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue636Test extends OsateTest {
	@Test
	def void issue636TestA() {
		val aadlFile = "issue464.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.i" not found', cls.exists [
			name == 'top.i'
		])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('top_i_Instance', instance.name)

		// check if e2e flows are instantiated exactly once
		val connections = instance.connectionInstances
		assertTrue('Expected 2 connection instances but found ' + connections.size, connections.size == 2)
	}

	val aadlText = '''
		package issue636
		public
			feature group fg
				features
					di: in data port;
					do: out data port;
			end fg;
			
			feature group fgi
				features
					do: out data port;
					di: in data port;
				inverse of fg
			end fgi;
			
			system left
				features
					fgi: feature group fgi;
			end left;
			
			system rss
				features
					si: in data port;
					so: out data port;
			end rss;
			
			system right
				features
					fg: feature group fg;
			end right;
		
			system implementation right.i
				subcomponents
					rss: system rss;
				connections
					c3: feature fg.di -> rss.si;
					c4: feature rss.so -> fg.do;
			end right.i;
			
			system top
			end top;
			
			system implementation top.i
				subcomponents
					left: system left;
					right: system right.i;
				connections
					c1: feature group left.fgi <-> right.fg;
			end top.i;
			
		end issue636;
	'''
}
