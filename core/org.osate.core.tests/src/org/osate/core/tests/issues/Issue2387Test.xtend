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
import org.osate.aadl2.StringLiteral

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2387Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2387/"
	val static FILE1 = "instance_bug.aadl"
	val static PS = "ps.aadl"

	val static S_I = "s.i"
	val static X_I = "X.i"

	val static INSTANCE_NAME1 = "s_i_Instance"
	val static INSTANCE_NAME2 = "X_i_Instance"
	
	val static STRING_PROPERTY = "string_property"
	val static STRING_WITH_DEFAULT = "string_with_default"
	
	val static DEFAULT_VALUE = "default value"
	val static BOB = "bob"
	val static XXX = "XXX"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test_instantiation_of_property_reference_with_default_value() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1, PROJECT_LOCATION + PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == S_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME1, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		// No errors or warnings
		assertTrue(messages.size == 0)
		
		// property association for property `string_property` of root s.i should be "default value"
		instance => [
			assertEquals(1, ownedPropertyAssociations.size)
			ownedPropertyAssociations.get(0) => [
				assertEquals(STRING_PROPERTY, property.name)
				assertEquals(1, ownedValues.size)
				ownedValues.get(0) => [
					assertTrue(ownedValue instanceof StringLiteral)
					assertEquals(DEFAULT_VALUE, (ownedValue as StringLiteral).value)
				]
			]
		]

		// property association for property `string_property` of feature f should be "bob"
		instance => [
			assertEquals(1, featureInstances.size)
			featureInstances.get(0) => [
				assertEquals(1, ownedPropertyAssociations.size)
				ownedPropertyAssociations.get(0) => [
					assertEquals(STRING_PROPERTY, property.name)
					assertEquals(1, ownedValues.size)
					ownedValues.get(0) => [
						assertTrue(ownedValue instanceof StringLiteral)
						assertEquals(BOB, (ownedValue as StringLiteral).value)
					]
				]
			]
			
		]
	}

	
	@Test
	def void test_default_values_do_not_bleed_through() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1, PROJECT_LOCATION + PS)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == X_I] as SystemImplementation
		
		val errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory)
		
		val instance = InstantiateModel.instantiate(sysImpl, errorManager)
		assertEquals(INSTANCE_NAME2, instance.name)

		val messages = (errorManager.getReporter(instance.eResource) as QueuingAnalysisErrorReporter).errors
		// No errors or warnings
		assertTrue(messages.size == 0)
		
		instance => [
			assertEquals(0, ownedPropertyAssociations.size)
			assertEquals(2, componentInstances.size)
			componentInstances.get(0) => [
				assertEquals(1, ownedPropertyAssociations.size)
				ownedPropertyAssociations.get(0) => [
					assertEquals(STRING_WITH_DEFAULT, property.name)
					assertEquals(1, ownedValues.size)
					ownedValues.get(0) => [
						assertTrue(ownedValue instanceof StringLiteral)
						assertEquals(XXX, (ownedValue as StringLiteral).value)
					]
				]
			]
			componentInstances.get(1) => [
				assertEquals(0, ownedPropertyAssociations.size)
				assertEquals(2, featureInstances.size)
				featureInstances.get(0) => [
					assertEquals(0, ownedPropertyAssociations.size)
				]
				featureInstances.get(1) => [
					assertEquals(0, ownedPropertyAssociations.size)
				]
			]
			
			assertEquals(2, systemOperationModes.size)
			systemOperationModes.get(0) => [
				assertEquals(0, ownedPropertyAssociations.size)
			]
			systemOperationModes.get(1) => [
				assertEquals(0, ownedPropertyAssociations.size)
			]
		]
	}
}
