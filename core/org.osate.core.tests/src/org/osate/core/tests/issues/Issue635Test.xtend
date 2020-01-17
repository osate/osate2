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

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue635Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue635() {
		
		val pkg = testHelper.parseString(aadlText, psText)
		val cls = pkg.ownedPublicSection.ownedClassifiers

		assertTrue('System implementation "top.i" not found', cls.exists[name == 'top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.i'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('top_i_Instance', instance.name)

		// check if there are 21 connections
		var pas = instance.ownedPropertyAssociations
		var names = pas.map[it.property.name]
		assertEquals('In top_i_Instance: Did not find expected properties', names, #['p0', 'p2'])

		pas = instance.featureInstances.get(0).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature group fg: Did not find expected properties', names, #['q0', 'q3'])

		pas = instance.featureInstances.get(0).featureInstances.get(0).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature fg.f2: Did not find expected properties', names, #['q0', 'q1'])

		pas = instance.featureInstances.get(0).featureInstances.get(1).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature fg.f1: Did not find expected properties', names, #['q0', 'q2', 'r1'])

		pas = instance.featureInstances.get(0).featureInstances.get(2).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In feature fg.f0: Did not find expected properties', names, #['q0'])
		
		pas = instance.componentInstances.get(0).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In component sub: Did not find expected properties', names, #['p2', 'p1'])

		pas = instance.componentInstances.get(1).ownedPropertyAssociations
		names = pas.map[it.property.name]
		assertEquals('In component sub1: Did not find expected properties', names, #['p2', 'p3'])

	}

	val psText = '''
		property set ps635 is
			p0: aadlboolean applies to (data, system implementation);
			p1: aadlboolean applies to (system type);
			p2: aadlboolean applies to (memory, system);
			p3: aadlboolean applies to (system subcomponent);
			q0: aadlboolean applies to (feature);
			q1: aadlboolean applies to (access);
			q2: aadlboolean applies to (port);
			q3: aadlboolean applies to (feature group);
			q4: aadlboolean applies to (feature group type);
			r1: aadlboolean applies to (all);
		end ps635;
	'''
	val aadlText = '''
		package issue635
		public
			with ps635;
		
			feature group fg
				features
					f0: feature {
						ps635::q0 => true;	
					};
					f1: in data port {
						ps635::q0 => true;	
						ps635::q2 => true;	
						ps635::r1 => true;
					};
					f2: provides bus access {
						ps635::q0 => true;	
						ps635::q1 => true;	
					};
			end fg;
			
			system top
				features
					fg: feature group fg;
				properties
					ps635::p1 => false;
					ps635::p2 => false;
					
					ps635::q0 => true applies to fg;
					ps635::q3 => false applies to fg;
			end top;
		
			system implementation top.i
				subcomponents
					sub: system top;
					sub1: system;
				properties
					ps635::p0 => true;
					ps635::p2 => true;
					ps635::p2 => true applies to sub1;
					ps635::p3 => true applies to sub1;
			end top.i;
			
		end issue635;
	'''
}
