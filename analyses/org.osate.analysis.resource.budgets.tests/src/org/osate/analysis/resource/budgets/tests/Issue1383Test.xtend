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
package org.osate.analysis.resource.budgets.tests

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
import org.osate.result.Result
import java.util.List
import org.osate.result.util.ResultUtil
import org.osate.analysis.resource.budgets.power.PowerRequirementAnalysis
import org.osate.result.Diagnostic
import org.osate.result.DiagnosticType

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2InjectorProvider))
class Issue1383Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	val static PROJECT_LOCATION = "org.osate.analysis.resource.budgets.tests/models/Issue1383/"
	
	@Test
	def void testBasicResourceBudgetExample() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "Example.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "MySystem.Tier0"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check power requirements
		val checker = new PowerRequirementAnalysis()
		val analysisResult = checker.invoke(null, instance)
		val somResult = analysisResult.results.get(0)
		val powerResult = somResult.subResults.get(0)
		checkRBValues(powerResult);
		
		val powerResult2 = somResult.subResults.get(1)
		checkRBValues(powerResult2);
		
		val powerResult3 = somResult.subResults.get(2)
		checkRBValues(powerResult3);
		
		val powerResult4 = somResult.subResults.get(3)
		checkRBValues(powerResult4);
		
		val powerResult5 = somResult.subResults.get(4)
		checkRBValues(powerResult5);
	}
	
	@Test
	def void testOverloadedCapacity() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestOverCapacity.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "MySystem.Tier0"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check power requirements
		val checker = new PowerRequirementAnalysis()
		val analysisResult = checker.invoke(null, instance)
		val somResult = analysisResult.results.get(0)
		val powerResult = somResult.subResults.get(0)
		checkOverValues(powerResult);
		
		val powerResult2 = somResult.subResults.get(1)
		checkOverValues(powerResult2);
		
		val powerResult3 = somResult.subResults.get(2)
		checkOverValues(powerResult3);
		
		val powerResult4 = somResult.subResults.get(3)
		checkOverValues(powerResult4);
		
		val powerResult5 = somResult.subResults.get(4)
		checkOverValues(powerResult5);
	}
	
	@Test
	def void testNoSupply() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "TestNoSupply.aadl")

		// instantiate
		val cls = pkg.ownedPublicSection.ownedClassifiers
		val sysImpl = cls.findFirst[name == "MySystem.Tier0"] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)

		// check power requirements
		val checker = new PowerRequirementAnalysis()
		val analysisResult = checker.invoke(null, instance)
		val somResult = analysisResult.results.get(0)
		val powerResult = somResult.subResults.get(0)
		checkNoSupplyValues(powerResult);
		
		val powerResult2 = somResult.subResults.get(1)
		checkNoSupplyValues(powerResult2);
		
		val powerResult3 = somResult.subResults.get(2)
		checkNoSupplyValues(powerResult3);
		
		val powerResult4 = somResult.subResults.get(3)
		checkNoSupplyValues(powerResult4);
	}

	private static def void checkNoSupplyValues(Result result){
		val compName = ResultUtil.getString(result, 7)
		
		if (compName == "hw")
		checkValues(result, #[800.0, 0.0, 40000.0, 92500.0, 0.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds capacity 40.0 W")])
		else if (compName == "sensor1")
		checkValues(result, #[450.0, 0.0, 40000.0, 92500.0, 0.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds capacity 40.0 W")])
		else if (compName == "sensor2")
		checkValues(result, #[450.0, 0.0, 40000.0, 92500.0, 0.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds capacity 40.0 W")])
		else if (compName == "actuator")
		checkValues(result, #[90800.0, 0.0, 40000.0, 92500.0, 0.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds capacity 40.0 W")])
	}

	private static def void checkOverValues(Result result){
		val compName = ResultUtil.getString(result, 7)
		
		if (compName == "EPSU")
		checkValues(result, #[0.0, 80000.0, 40000.0, 92500.0, 80000.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds supply 80.0 W")])
		else if (compName == "hw")
		checkValues(result, #[800.0, 0.0, 40000.0, 92500.0, 80000.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds supply 80.0 W")])
		else if (compName == "sensor1")
		checkValues(result, #[450.0, 0.0, 40000.0, 92500.0, 80000.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds supply 80.0 W")])
		else if (compName == "sensor2")
		checkValues(result, #[450.0, 0.0, 40000.0, 92500.0, 80000.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds supply 80.0 W")])
		else if (compName == "actuator")
		checkValues(result, #[90800.0, 0.0, 40000.0, 92500.0, 80000.0], #[error("Grid budget total 92.5 W exceeds capacity 40.0 W"), error("budget total 92.5 W exceeds supply 80.0 W")])
	}
	
	private static def void checkRBValues(Result result){
		val compName = ResultUtil.getString(result, 7)
		
		if (compName == "EPSU")
		checkValues(result, #[0.0, 40000.0, 40000.0, 2500.0, 40000.0], #[])
		else if (compName == "hw")
		checkValues(result, #[800.0, 0.0, 40000.0, 2500.0, 40000.0], #[])
		else if (compName == "sensor1")
		checkValues(result, #[450.0, 0.0, 40000.0, 2500.0, 40000.0], #[])
		else if (compName == "sensor2")
		checkValues(result, #[450.0, 0.0, 40000.0, 2500.0, 40000.0], #[])
		else if (compName == "actuator")
		checkValues(result, #[800.0, 0.0, 40000.0, 2500.0, 40000.0], #[])
	}

	private static def List<Object> error(String msg) {
		return #[DiagnosticType.ERROR, msg]
	}
	
	private static def List<Object> warning(String msg) {
		return #[DiagnosticType.WARNING, msg]
	}
	
	private static def void checkDiagnostic(Diagnostic d, DiagnosticType type, String msg) {
		assertEquals(type, d.diagnosticType)
		assertEquals(msg, d.message)
	}

	private static def void checkValues(Result result, List<Double> values, List<List<Object>> diagnostics) {
		for (var i = 0; i < values.size; i++) {
			val expected = values.get(i)
			val actual = ResultUtil.getReal(result, i)
			assertEquals(expected, actual, 0.0)
		}
		
		assertEquals(diagnostics.size, result.diagnostics.size)
		for (var i = 0; i < diagnostics.size; i++) {
			val expected = diagnostics.get(i)
			checkDiagnostic(result.diagnostics.get(i), expected.get(0) as DiagnosticType, expected.get(1) as String)
		}
	}
	
	private static def void checkIntegerValue(Result result, int idx, long expected) {
		val actual = ResultUtil.getInteger(result, idx)
		assertEquals(expected, actual)
	}
}
