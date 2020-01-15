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
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue109Test {
	val static FILE = "org.osate.core.tests/models/issue109/issue109.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testInstantiation() {
		val pkg = testHelper.parseFile(FILE)
		val impl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == 'T.i'] as ComponentImplementation
		
		val instance = InstantiateModel.instantiate(impl)
		assertEquals('T_i_Instance', instance.name)
		
		val mt1 = instance.modeTransitionInstances.get(0)
		val compB = instance.componentInstances.findFirst[name == 'b']
		val mt2 = compB.modeTransitionInstances.get(0)
		val mt3 = compB.modeTransitionInstances.get(1)

		assertTrue(mt1.triggers.size == 1)
		assertTrue(mt1.triggers.get(0) == compB.featureInstances.findFirst[name == 'e'])
		
		assertTrue(mt2.triggers.size == 1)
		assertTrue(mt2.triggers.get(0) == compB.featureInstances.findFirst[name == 'e'])
		
		assertTrue(mt3.triggers.size == 1)
		assertTrue(mt3.triggers.get(0) == compB.featureInstances.findFirst[name == 'fg'].featureInstances.findFirst[name =='f'])
	}
}
