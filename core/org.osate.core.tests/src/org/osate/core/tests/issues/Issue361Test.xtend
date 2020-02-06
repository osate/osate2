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
class Issue361Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue361() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "Block.impl" not found', cls.exists[name == 'Block.impl'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Block.impl'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('Block_impl_Instance', instance.name)

		// check that there are two external connections
		val conns = instance.connectionInstances
		val names = conns.map[name]
		assertTrue('Connection "ins.input -> blk_process.input" not created', names.contains('ins.input -> blk_process.input'))
		assertTrue('Connection "blk_process.output -> outs.output" not created', names.contains('blk_process.output -> outs.output'))
		assertTrue('Expected two connection instances but found ' + conns.size, conns.size == 2)
	}

	val aadlText = '''
package issue361
public
	with Base_Types;

	feature group blk_ins
		features
			input: in data port Base_Types::Boolean;
	end blk_ins;

	feature group blk_outs
		features
			output: out data port Base_Types::Boolean;
	end blk_outs;

	system Block
		features 
			ins: feature group blk_ins;
			outs: feature group blk_outs;
	end Block;

	system implementation Block.impl
		subcomponents
			blk_process: process BlockProcess.impl;
		connections
			pin: port ins.input -> blk_process.input;
			pout: port blk_process.output -> outs.output;
	end Block.impl;

	process BlockProcess
		features
			input: in data port Base_Types::Boolean;
			output: out data port Base_Types::Boolean;
	end BlockProcess;

	process implementation BlockProcess.impl
	end BlockProcess.impl;

end issue361;
	'''
}
