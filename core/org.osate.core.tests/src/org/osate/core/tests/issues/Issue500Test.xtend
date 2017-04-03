package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
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
class Issue500Test extends OsateTest {
	override getProjectName() {
		"issue500"
	}

	@Test
	def void issue500() {
		val aadlFile = "issue500.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers;
		(0..5).forEach[k |
			val name = '''S.i«k»'''
			assertTrue('''System implementation "«name»" not found''', cls.exists[it.name == name])

			// instantiate
			val sysImpl = cls.findFirst[it.name == name] as SystemImplementation
			val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
			val connections = instance.connectionInstances
			
			switch k {
				case 0: {
					assertEquals(instance.name + ': must have 4 connections', 4, connections.size)
					assertEquals(instance.name + ': connection names do not match', 'o1.m1.l1.f -> o2.m1.l1.f, o1.m1.l2.f -> o2.m1.l2.f, o2.m1.l1.f -> o1.m1.l1.f, o2.m1.l2.f -> o1.m1.l2.f', connections.map[it.name].sort.join(', '))
				}
				case 1: {
					assertEquals(instance.name + ': must have 2 connections', 2, connections.size)
					assertEquals(instance.name + ': connection names do not match', 'o1.m1.l1.f -> o2.m1.l2.f, o2.m1.l2.f -> o1.m1.l1.f', connections.map[it.name].sort.join(', '))
				}
				case 2: {
					assertEquals(instance.name + ': must have 2 connections', 2, connections.size)
					assertEquals(instance.name + ': connection names do not match', 'o1.m1.l2.f -> o2.m1.l2.f, o2.m1.l2.f -> o1.m1.l2.f', connections.map[it.name].sort.join(', '))
				}
				case 3: {
					assertEquals(instance.name + ': must have 2 connections', 2, connections.size)
					assertEquals(instance.name + ': connection names do not match', 'm.l1.f -> o.m1.l2.f, o.m1.l2.f -> m.l1.f', connections.map[it.name].sort.join(', '))
				}
				case 4: {
					assertEquals(instance.name + ': must have 4 connections', 4, connections.size)
					assertEquals(instance.name + ': connection names do not match', 'm.l1.f -> o.m1.l1.f, m.l1.f -> o.m1.l2.f, m.l2.f -> o.m1.l1.f, m.l2.f -> o.m1.l2.f', connections.map[it.name].sort.join(', '))
				}
				case 5: {
					assertEquals(instance.name + ': must have 2 connections', 2, connections.size)
					assertEquals(instance.name + ': connection names do not match', 'l.f -> m.mfg.mf1, m.mfg.mf2 -> l.f', connections.map[it.name].sort.join(', '))
				}
			}
		]
	}

	val aadlText = '''
		package issue500
		public
			
			feature group Ofg
				features
					of1: feature group Mfg;
					of2: feature group Mfg;
			end Ofg;
			
			feature group Mfg
				features
					mf1: feature;
					mf2: feature;
			end Mfg;
		
			abstract O
				features
					ofg: feature group Ofg;
					ofgi: feature group inverse of Ofg;
			end O;
			
			abstract implementation O.i
				subcomponents
					m1: abstract M.i;
				connections
					co: feature group m1.mfg <-> ofg.of1;
					coi: feature group m1.mfgi <-> ofgi.of1;
			end O.i;
			
			abstract M
				features
					mfg: feature group Mfg;
					mfgi: feature group inverse of Mfg;
			end M;
		
			abstract implementation M.i
				subcomponents
					l1: abstract L;
					l2: abstract L;
				connections
					cm1: feature l1.f <-> mfg.mf1;
					cm2: feature l2.f <-> mfg.mf2;
					cmi1: feature l1.f <-> mfgi.mf1;
					cmi2: feature l2.f <-> mfgi.mf2;
			end M.i;
			
			abstract L
				features
					f: feature;
			end L;
			
			system S
			end S;
			
			system implementation S.i0
				subcomponents
					o1: abstract O.i;
					o2: abstract O.i;
				connections
					cs: feature group o1.ofg <-> o2.ofgi;
			end S.i0;
		
			system implementation S.i1
				subcomponents
					o1: abstract O.i;
					o2: abstract O.i;
				connections
					cs: feature o1.ofg.of1.mf1 <-> o2.ofgi.of1.mf2;
			end S.i1;
			
			system implementation S.i2
				subcomponents
					o1: abstract O.i;
					o2: abstract O.i;
				connections
					cs: feature o1.ofg.of1.mf2 <-> o2.ofgi.of1.mf2;
			end S.i2;
		
			system implementation S.i3
				subcomponents
					o: abstract O.i;
					m: abstract M.i;
				connections
					cs: feature o.ofg.of1.mf2 <-> m.mfgi.mf1;
			end S.i3;
			
			system implementation S.i4
				subcomponents
					o: abstract O.i;
					m: abstract M.i;
				connections
					cs: feature o.ofg.of1 <-> m.mfgi;
			end S.i4;
			
			system implementation S.i5
				subcomponents
					l: system L;
					m: system M;
				connections
					cs1: feature l.f -> m.mfg.mf1;
					cs2: feature m.mfg.mf2 -> l.f;
			end S.i5;
			
		end issue500;
	'''
}
