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
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue923Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue923/"
	val static FILE1 = "FeatureGroupTest.aadl"

	val static MAIN_IMPL = "Main.impl"

	val static INSTANCE_NAME = "Main_impl_Instance"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == MAIN_IMPL] as SystemImplementation
		
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(INSTANCE_NAME, instance.name)

		// first connection was already correct, but let's make sure it stays that way
		val c1_src = instance.componentInstances.get(0).featureInstances.get(0).featureInstances.get(0).featureInstances.get(0)
		val c1_dst = instance.componentInstances.get(1).featureInstances.get(0).featureInstances.get(0).featureInstances.get(0)
		assertTrue(instance.connectionInstances.get(0).connectionReferences.get(0).source == c1_src)
		assertTrue(instance.connectionInstances.get(0).connectionReferences.get(0).destination == c1_dst)

		// second connection was wrong, but that's make sure it stays that way
		val c2_src = instance.componentInstances.get(0).featureInstances.get(0).featureInstances.get(0).featureInstances.get(0)
		val c2_dst = instance.componentInstances.get(1).featureInstances.get(1).featureInstances.get(0)
		assertTrue(instance.connectionInstances.get(1).connectionReferences.get(0).source == c2_src)
		assertTrue(instance.connectionInstances.get(1).connectionReferences.get(0).destination == c2_dst)
	}
}
