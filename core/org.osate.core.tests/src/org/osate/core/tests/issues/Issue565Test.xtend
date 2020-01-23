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
class Issue565Test extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue565() {
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "Top.i" not found', cls.exists[name == 'Top.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'Top.i'] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals('Top_i_Instance', instance.name)

		// check if there are 2 connections
		val connections = instance.connectionInstances
		assertTrue('In Top_i_instance: Expected 2 connections but found ' + connections.size, connections.size == 2)
	}

	val aadlText = '''
	package issue565
	public

		data MsgType
		end MsgType;

		feature group FGType
			features
				inPort: in out data port msgType;
		end FGType;

		process Proc
			features
				fgPorts: feature group FGType;
		end Proc;

		process InverseProc
			features
				fgPorts: feature group inverse of FGType;
		end InverseProc;

		system Sub
			features
				fgPorts: feature group inverse of FGType;
		end Sub;

		system implementation Sub.i
			subcomponents
				iproc: process InverseProc;
			connections
				c2: feature group fgPorts <-> iproc.fgPorts;
		end Sub.i;

		system Top
		end Top;

		system implementation Top.i
			subcomponents
				proc: process Proc;
				sub: system Sub.i;
			connections
				c1: feature group proc.fgPorts <-> sub.fgPorts;
		end Top.i;

	end issue565;
	'''
}
