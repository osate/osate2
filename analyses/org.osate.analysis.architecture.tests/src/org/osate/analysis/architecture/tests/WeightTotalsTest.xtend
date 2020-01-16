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
package org.osate.analysis.architecture.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.analysis.architecture.PropertyTotals
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.osate.testsupport.ResultHelper.*

import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.instantiation.InstantiateModel.instantiate

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class WeightTotalsTest {
	val static DIR_NAME = "org.osate.analysis.architecture.tests/models/WeightTotals/"
	
	val static generate = false
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testWeightTotals() {
		val fileNames = #[
			"subs",
			"conns",
			"sum_exceed_gross",
			"gross_exceed_sum",
			"weight_exceed_limit",
			"sublimit_exceed_limit",
			"weight_equals_limit"
		]
		fileNames.forEach[fileName |
			testHelper.parseFile(DIR_NAME + fileName + ".aadl") => [
				fileName.assertEquals(name)
				publicSection.ownedClassifiers.get(1) as SystemImplementation => [
					"s1.i1".assertEquals(name)
					instantiate => [
						"s1_i1_Instance".assertEquals(name)
						
						val actual = PropertyTotals.invoke(it)
						
						val resultPath = '''«DIR_NAME»results/«fileName».result'''
						generateOrAssert(generate, resultPath,actual)
					]
				]
			]
		]
	}
}