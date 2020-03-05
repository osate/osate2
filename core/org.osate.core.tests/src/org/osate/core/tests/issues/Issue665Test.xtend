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
class Issue665Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue665/"
	
	val static TEST_PS = "TestPS.aadl"
	val static EXTENSION = ".aadl"
	
	val static FEATURE_ERROR_TEMPLATE = "Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"features{0}::{1}\" tries to replace it."
	val static FEATURE_GROUP_ERROR_TEMPLATE = "Property association for \"TestPS::myProp\" is constant.  A contained property association in classifier \"fg{0}::{1}\" tries to replace it."

	val static A_I = "A.i"

	val static INSTANCE_NAME = "A_i_Instance"

	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testSemanticConnection1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "sc1" + EXTENSION, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "whole.i"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals("whole_i_Instance", instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find the semantic connection
		val sc = instance.connectionInstances.get(0)
		
		assertEquals(0, messages.size)
	}	

	@Test
	def void testSemanticConnection2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "sc2" + EXTENSION, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "whole.i"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals("whole_i_Instance", instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find the semantic connection
		val sc = instance.connectionInstances.get(0)
		
		assertEquals(0, messages.size)
	}	

	@Test
	def void testSemanticConnection3() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "sc3" + EXTENSION, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "whole.i"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals("whole_i_Instance", instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find the semantic connection
		val sc = instance.connectionInstances.get(0)
		
		assertEquals(2, messages.size)
		messages.get(1) => [
			assertEquals(sc, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Value for property TestPS::myProp not consistent along connection", message)
		]
		messages.get(0) => [
			assertEquals(sc, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Value for property TestPS::myProp2 not consistent along connection", message)
		]
	}	

	@Test
	def void testSemanticConnection4() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "sc4" + EXTENSION, PROJECT_LOCATION + TEST_PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == "whole.i"] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)

		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals("whole_i_Instance", instance.name)
		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		
		// Find the semantic connection
		val sc = instance.connectionInstances.get(0)
		
		assertEquals(2, messages.size)
		messages.get(1) => [
			assertEquals(sc, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Value for property TestPS::myProp not consistent along connection", message)
		]
		messages.get(0) => [
			assertEquals(sc, where)
			assertEquals(QueuingAnalysisErrorReporter.ERROR, kind)
			assertEquals("Value for property TestPS::myProp2 not consistent along connection", message)
		]
	}

}

