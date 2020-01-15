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
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue961Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue961/"
	val static FILE1 = "abstractprocess.aadl"
	val static FILE2 = "package2.aadl"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1)
		
		val instance1 = getSystemInstance(pkg, "s.i", "s_i_Instance")
		testSubComponentCategory(instance1, "p", ComponentCategory.PROCESS)
		testSubComponentCategory(instance1, "b", ComponentCategory.BUS)
		
		val instance2 = getSystemInstance(pkg, "s.j", "s_j_Instance")
		testSubComponentCategory(instance2, "x", ComponentCategory.ABSTRACT)
		
		val instance3 = getSystemInstance(pkg, "s.k", "s_k_Instance")
		testSubComponentCategory(instance3, "x", ComponentCategory.PROCESS)
	}

	@Test
	def void test2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE2)

		val instance = getSystemInstance(pkg, "SSS.i", "SSS_i_Instance")		
		testSubSubComponentCategory(instance, "sub1", "s1", ComponentCategory.BUS)
		testSubSubComponentCategory(instance, "sub2", "s1", ComponentCategory.PROCESS)
	}
	
	private def static SystemInstance getSystemInstance(
		AadlPackage pkg, String systemImplName, String expectedInstanceName
	) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + systemImplName + '" not found', cls.exists[name == systemImplName])
		
		// Instantiate system
		val sysImpl = cls.findFirst[name == systemImplName] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(expectedInstanceName, instance.name)
		return instance
		
	}
	
	private def static testSubComponentCategory(
		SystemInstance instance, String subName, ComponentCategory expectedCategory
	) {
		val sub = instance.componentInstances.findFirst[name == subName]
		val subCat = sub.category;
		assertTrue(subName + ' has category ' + subCat + '; expected "' + expectedCategory.getName + '"', subCat == expectedCategory)
	}
	
	private def static testSubSubComponentCategory(
		SystemInstance instance, String sub1Name, String sub2Name, ComponentCategory expectedCategory
	) {
		val sub = instance.componentInstances.findFirst[name == sub1Name]
		val subSub = sub.componentInstances.findFirst[name == sub2Name]
		val subSubCat = subSub.category;
		assertTrue(sub1Name + '.' + sub2Name + ' has category ' + subSubCat + '; expected "' + expectedCategory.getName + '"', subSubCat == expectedCategory)
	}
}
