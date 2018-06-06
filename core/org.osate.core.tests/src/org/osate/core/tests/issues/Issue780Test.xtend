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
class Issue780Test extends OsateTest {
	@Test
	def void issue780() {
		val aadlFile = "issue780.aadl"
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

		// check connection names to validate directions
		val names = connections.map[it.name].sort
		assertTrue('In top_i_Instance: Did not find expected connections',
			names ==
				#['fg -> l.fg', 'fg -> l.ps.p1', 'fg -> l.ps.p1', 'l.fg -> fg', 'l.fg -> ps.p2', 'l.fg -> ps.p2',
					'l.fg -> r.fg', 'l.fg -> r.ps.p2', 'l.ps.p2 -> fg', 'l.ps.p2 -> fg', 'l.ps.p2 -> ps.p2',
					'l.ps.p2 -> ps.p2', 'l.ps.p2 -> r.fg', 'l.ps.p2 -> r.ps.p2', 'ps.p1 -> l.fg', 'ps.p1 -> l.fg',
					'ps.p1 -> l.ps.p1', 'ps.p1 -> l.ps.p1', 'r.fg -> l.ps.p1', 'r.ps.p1 -> l.fg', 'r.ps.p1 -> l.ps.p1'])
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
	'''
}
