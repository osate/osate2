/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue734Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue734() {
		
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			"pkg1".assertEquals(name)
			cls.get(1) as SystemImplementation => [
				"s1.i1".assertEquals(name)
				val sysImpl = cls.findFirst[name == 's1.i1'] as SystemImplementation
				val instance = InstantiateModel.instantiate(sysImpl)
				instance => [
					"s1_i1_Instance".assertEquals(name)
					assertEquals(3, connectionInstances.size)
				]
			]
		]
	}
	
	val aadlText = '''
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
'''
}