package org.osate.core.tests.issues

import com.itemis.xtext.testing.XtextRunner2
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue480Test extends OsateTest {
	override getProjectName() {
		"issue480"
	}

	@Test
	def void issue480() {
		val aadlFile = "issue480.aadl"
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

		// check if there are 21 connections
		val connections = instance.connectionInstances
		assertTrue('In top_i_Instance: Expected 21 connections but found ' + connections.size, connections.size == 21)
	}

	val aadlText = '''
package issue480
public
	
	feature group ps
		features
			p1: in data port;
			p2: out data port;
	end ps;

	system top
		features
			fg: feature group;
			ps: feature group ps;
	end top;
	
	system implementation top.i
		subcomponents
			l: abstract a;
			r: abstract b;
		connections
			c01: feature group l.fg -> fg;
			c02: feature group l.ps <-> fg;
			c03: feature group l.fg <-> ps;
			c04: feature group l.ps <-> ps;

			c11: feature group fg -> l.fg;
			c12: feature group ps <-> l.fg;
			c13: feature group fg <-> l.ps;
			c14: feature group ps <-> l.ps;
			
			c21: feature group l.fg -> r.fg;
			c22: feature group l.ps <-> r.fg;
			c23: feature group l.fg <-> r.ps;
			c24: feature group l.ps <-> r.ps;
	end top.i;
	
	abstract a
		features
			fg: feature group;
			ps: feature group ps;
	end a;
	
	abstract b
		features
			fg: feature group;
			ps: feature group inverse of ps;
	end b;
	
end issue480;
'''}
