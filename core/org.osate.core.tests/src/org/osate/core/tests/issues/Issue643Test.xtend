/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import org.osate.aadl2.SystemImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue643Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue643/"
		
	val END_TO_END_FLOW_LENGTH = 5 
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "issue643.aadl")
		testSystem(pkg, "top.i", 1, END_TO_END_FLOW_LENGTH)
	}
	
	@Test
	def void test2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "issue643b.aadl")
		testSystem(pkg, "top.i", 1, END_TO_END_FLOW_LENGTH)
		testSystem(pkg, "top2.i", 1, END_TO_END_FLOW_LENGTH)
	}
	
	def private void testSystem(AadlPackage pkg, String sysName, int numFlows, int flowLength) {
		val system = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == sysName] as SystemImplementation
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		val instance = InstantiateModel.instantiate(system, errorManager)
		assertEquals(numFlows, instance.endToEndFlows.size)
		for (var i = 0; i < numFlows; i++) {
			assertEquals(flowLength, instance.endToEndFlows.get(i).flowElements.size)
		}
	}
}
