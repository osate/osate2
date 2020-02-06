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
class Issue567Test extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue567() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "S.top" not found', cls.exists[name == 'S.top'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'S.top'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('S_top_Instance', instance.name)

		// check if there are 2 connections
		val connections = instance.connectionInstances
		assertTrue('In S_top_instance: Expected 2 connections but found ' + connections.size, connections.size == 2)
		
		// check if there is 1 end to end flow
		val etes = instance.endToEndFlows
		assertTrue('In S_top_instance: Expected 1 end to end flow but found ' + etes.size, etes.size == 1)
	}

	val aadlText = '''
package issue567
public

	feature group FG
		features
			outMsg: out event data port;
			inMsg: in data port;
	end FG;

	system Box
		features
			ioports: feature group FG;
		flows
			outFlow: flow source ioports.outMsg;
			inFlow: flow sink ioports.inMsg;
	end Box;

	process P
		features
			ioports: feature group inverse of FG;
		flows
			processFlow: flow path ioports.outMsg -> ioports.inMsg;
	end P;

	process implementation P.i
		subcomponents
			t1: thread T.i;
		connections
			c: feature group ioports <-> t1.ioports;
		flows
			processFlow: flow path ioports.outMsg -> c -> t1.threadFlow -> c -> ioports.inMsg;
	end P.i;

	thread T
		features
			ioports: feature group inverse of FG;
		flows
			threadFlow: flow path ioports.outMsg -> ioports.inMsg;
	end T;

	thread implementation T.i
	end T.i;

	system S
	end S;

	system implementation S.top
		subcomponents
			proc: process P.i;
			box: system Box;
		connections
			c: feature group box.ioports <-> proc.ioports;
		flows
			f_bb_proc_bb: end to end flow box.outFlow -> c -> proc.processFlow -> c -> box.inFlow;
	end S.top;

end issue567;	'''
}
