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

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue702Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue702() {
		
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			assertEquals("fgpt", name)
			publicSection.ownedClassifiers.get(2) as SystemImplementation => [
				assertEquals("sys.root", name)
				val sysImpl = cls.findFirst[name == 'sys.root'] as SystemImplementation
				val instance = InstantiateModel.instantiate(sysImpl)
				instance => [
					"sys_root_Instance".assertEquals(name)
					assertEquals(3, connectionInstances.size)
				]
			]
		]
	}
	
	val aadlText = '''
package fgpt
public
	feature group Sense_Whole
		features
			D1: in data port;
			D2: in data port;
			D3: in data port;
			D4: in data port;
			D5: in data port;
	end Sense_Whole;
	
	system sys
	end sys;
	
	system implementation sys.root
		subcomponents
			External: system Ext.base;
			Container: system Container.base;
		connections
			sense: feature group External.Sense -> Container.Sense;
	end sys.root;
	
	system Container
		features
			Sense: feature group Sense_Whole;
	end Container;
	
	system implementation Container.base
		subcomponents
			S1: system Sub1.base;
		connections
			Sub1_D1: port Sense.D1 -> S1.D1;
			Sub1_D2: port Sense.D2 -> S1.D2;
			Sub1_D3: port Sense.D3 -> S1.D3;
	end Container.base;
	
	system Sub1
		features
			D1: in data port;
			D2: in data port;
			D3: in data port;
	end Sub1;
	
	system implementation Sub1.base
	end Sub1.base;
	
	system Ext
		features
			Sense: feature group inverse of Sense_Whole;
	end Ext;
	
	system implementation Ext.base
	end Ext.base;
end fgpt;
		'''
}