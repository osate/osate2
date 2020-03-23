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
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.IntegerLiteral
import java.text.MessageFormat

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1842Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue1842/"
	val static TEST_PS = "test_ps.aadl"
	val static CYCLE_EXAMPLE = "cycle_example.aadl"
		
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testForCycles() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + CYCLE_EXAMPLE, PROJECT_LOCATION + TEST_PS)
		
		// get the property reference
		val dummyProperty = pkg.ownedPublicSection.ownedClassifiers.get(0).ownedPropertyAssociations.get(0).property
		assertEquals("dummy", dummyProperty.name);
		
		// get the first type
		val system_a = pkg.ownedPublicSection.ownedClassifiers.get(1)
		assertEquals("A", system_a.name)
		
		// get the first implementation
		val system_c_i = pkg.ownedPublicSection.ownedClassifiers.get(4)
		assertEquals("C.i", system_c_i.name)
		
		system_a.getPropertyValue(dummyProperty)
		assertTrue(true) // won't get here if we get stuck in a cycle
		
		system_c_i.getPropertyValue(dummyProperty)
		assertTrue(true) // won't get here if we get stuck in a cycle
	}
	
}

