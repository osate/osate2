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
@InjectWith(Aadl2InjectorProvider)
class Issue539Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue539() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "top.impl" not found', cls.exists[name == 'top.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'top.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('top_impl_Instance', instance.name)

		// check if there are 2 connections in top
		val connections = instance.connectionInstances
		assertTrue('In top_impl_instance: Expected 2 connections but found ' + connections.size, connections.size == 2)
	}

	val aadlText = '''
package issue539
public
	
	system top
	end top;

	system implementation top.impl
		subcomponents
			proc1: process test_process_type;
			proc2: process test_process_type;
		connections
			fg_con: feature group proc1.tfg <-> proc2.tfg_inv;
	end top.impl;

	process test_process_type
		features
			tfg: feature group test_feature_group_type;
			tfg_inv: feature group inverse of test_feature_group_type;
	end test_process_type;

	feature group test_feature_group_type
		features
			in1: in data port;
			out1: out data port;
	end test_feature_group_type;

end issue539;
'''
}
