package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class Issue734 extends OsateTest {
	override getProjectName() {
		"issue734"
	}
	
	@Test
	def void issue734() {
		val fileName = "issue734.aadl"
		createFiles(fileName -> '''
			package pkg1
			public
				system s1
				end s1;
				
				system implementation s1.i1
					subcomponents
						sub1: device dev1;
						sub2: device dev2;
						sub3: device dev3;
						sub4: system s2.i1;
					connections
						conn1: feature group sub1.f1 -> sub4.f4;
						conn2: feature group sub2.f2 -> sub4.f5;
						conn3: feature group sub4.f6 -> sub3.f3;
					flows
						flow1: end to end flow sub2.flow4 -> conn2 -> sub4.flow7 -> conn3 -> sub3.flow5;
						flow2: end to end flow sub1.flow3 -> conn1 -> sub4.flow6 -> conn3 -> sub3.flow5;
				end s1.i1;
				
				device dev1
					features
						f1: feature group fgt1;
					flows
						flow3: flow source f1;
				end dev1;
				
				device dev2
					features
						f2: feature group fgt2;
					flows
						flow4: flow source f2;
				end dev2;
				
				device dev3
					features
						f3: feature group fgt3;
					flows
						flow5: flow sink f3;
				end dev3;
				
				system s2
					features
						f4: feature group inverse of fgt1;
						f5: feature group inverse of fgt2;
						f6: feature group inverse of fgt3;
					flows
						flow6: flow path f4.f19 -> f6.f21;
						flow7: flow path f5.f20 -> f6.f21;
				end s2;
				
				system implementation s2.i1
					subcomponents
						sub5: process p1.i1;
					connections
						conn4: port f4.f19 -> sub5.f7;
						conn5: port f5.f20 -> sub5.f8;
						conn6: port sub5.f9 -> f6.f21;
					flows
						flow6: flow path f4.f19 -> conn4 -> sub5.flow8 -> conn6 -> f6.f21;
						flow7: flow path f5.f20 -> conn5 -> sub5.flow9 -> conn6 -> f6.f21;
				end s2.i1;
				
				process p1
					features
						f7: in data port;
						f8: in data port;
						f9: out data port;
					flows
						flow8: flow path f7 -> f9;
						flow9: flow path f8 -> f9;
				end p1;
				
				process implementation p1.i1
					subcomponents
						sub6: thread t1;
						sub7: thread t2;
						sub8: thread t3;
					connections
						conn7: port sub7.f15 -> sub8.f16;
						conn8: port sub6.f12 -> sub7.f14;
						conn9: port sub6.f13 -> sub8.f17;
						conn10: port f7 -> sub6.f10;
						conn11: port f8 -> sub6.f11;
						conn12: port sub8.f18 -> f9;
					flows
						flow8: flow path f7 -> conn10 -> sub6.flow10 -> conn8 -> sub7.flow12 -> conn7 -> sub8.flow13 -> conn12 -> f9;
						flow9: flow path f8 -> conn11 -> sub6.flow11 -> conn9 -> sub8.flow14 -> conn12 -> f9;
				end p1.i1;
				
				thread t1
					features
						f10: in data port;
						f11: in data port;
						f12: out data port;
						f13: out data port;
					flows
						flow10: flow path f10 -> f12;
						flow11: flow path f11 -> f13;
				end t1;
				
				thread t2
					features
						f14: in data port;
						f15: out data port;
					flows
						flow12: flow path f14 -> f15;
				end t2;
				
				thread t3
					features
						f16: in data port;
						f17: in data port;
						f18: out data port;
					flows
						flow13: flow path f16 -> f18;
						flow14: flow path f17 -> f18;
				end t3;
				
				feature group fgt1
					features
						f19: out data port;
				end fgt1;
				
				feature group fgt2
					features
						f20: out data port;
				end fgt2;
				
				feature group fgt3
					features
						f21: in data port;
				end fgt3;
			end pkg1;
		''')
		suppressSerialization
		testFile(fileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				buildInstanceModelFile => [
					"s1_i1_Instance".assertEquals(name)
					3.assertEquals(connectionInstances.size)
				]
			]
		]
	}
}