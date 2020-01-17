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

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue508Test extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue508() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.impl" not found', cls.exists[name == 'top.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('top_impl_Instance', instance.name)

		// check if there are 2 connections in sub1
		val sub1 = instance.componentInstances.findFirst[name == 'sub1']
		val connections1 = sub1.connectionInstances
		assertTrue('In sub1: Expected 2 connections but found ' + connections1.size, connections1.size == 2)

		// check if there are 2 connections in sub2
		val sub2 = instance.componentInstances.findFirst[name == 'sub2']
		val connections2 = sub2.connectionInstances
		assertTrue('In sub2: Expected 2 connections but found ' + connections2.size, connections2.size == 2)
	}

	val aadlText = '''
		package issue508
		public
			feature group fgt
				features
					p1: out data port;
					p2: out data port;
			end fgt;

			system top
			end top;

			system implementation top.impl
				subcomponents
					sub1: system s1.impl;
					sub2: system s2.impl;
			end top.impl;

			system s1
			end s1;

			system implementation s1.impl
				subcomponents
					send: system sender;
					receive: system receiver;
				connections
					c1: feature group send.fg1 -> receive.fg2;
			end s1.impl;

			system s2
			end s2;

			system implementation s2.impl
				subcomponents
					send: system sender;
					receive: system receiver;
				connections
					c2: feature group send.fg1 <-> receive.fg2;
			end s2.impl;

			system sender
				features
					fg1: feature group fgt;
			end sender;

			system receiver
				features
					fg2: feature group inverse of fgt;
			end receiver;

		end issue508;
	'''
}
