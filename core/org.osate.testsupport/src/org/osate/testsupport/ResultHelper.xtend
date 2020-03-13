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
package org.osate.testsupport

import java.net.URL
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.osate.result.AnalysisResult
import org.osate.result.BooleanValue
import org.osate.result.Diagnostic
import org.osate.result.IntegerValue
import org.osate.result.RealValue
import org.osate.result.Result
import org.osate.result.StringValue
import org.osate.result.Value

import static extension org.junit.Assert.assertEquals
import org.eclipse.emf.ecore.resource.Resource

class ResultHelper {
	def static AnalysisResult loadResult(ResourceSet resourceSet, String path) {
		val resource = resourceSet.createResource(URI.createURI(path))
		val url = new URL('''file:«System.getProperty("user.dir")»/../«path»''')
		val inputStream = url.openConnection.inputStream
		resource.load(inputStream, null)
		inputStream.close
		resource.contents.head as AnalysisResult
	}
	
	def static void generateOrAssert(boolean generate, String resultPath, AnalysisResult actual) {
		if (generate) {
			val uri = URI.createFileURI('''«System.getProperty("user.dir")»/../«resultPath»''')
			val resource = actual.modelElement.eResource.resourceSet.createResource(uri)
			resource.contents.add(actual)
			resource.save(null)
		} else {
			val expected = ResultHelper.loadResult(actual.modelElement.eResource.resourceSet, resultPath)
			assertAnalysisResult(resultPath, expected, actual)
		}

	}
	
	def static assertAnalysisResult(String name, AnalysisResult expected, AnalysisResult actual) {
		expected.resultType.assertEquals(actual.resultType)
		expected.analysis.assertEquals(actual.analysis)
		expected.message.assertEquals(actual.message)
		expected.modelElement.assertEObject(actual.modelElement)
		expected.results.size.assertEquals(actual.results.size)
		(0 ..< expected.results.size).forEach[name.assertResult(expected.results.get(it), actual.results.get(it))]
	}
	
	def static void assertResult(String name, Result expected, Result actual) {
		expected.resultType.assertEquals(actual.resultType)
		expected.message.assertEquals(actual.message)
		expected.modelElement.assertEObject(actual.modelElement)
		expected.values.size.assertEquals(actual.values.size)
		(0 ..< expected.values.size).forEach[expected.values.get(it).assertValue(actual.values.get(it))]
		expected.diagnostics.size.assertEquals(actual.diagnostics.size)
		(0 ..< expected.diagnostics.size).forEach[expected.diagnostics.get(it).assertDiagnostic(actual.diagnostics.get(it))]
		assertEquals(name, expected.subResults.size, actual.subResults.size)
//		expected.subResults.size.assertEquals(actual.subResults.size)
		(0 ..< expected.subResults.size).forEach[name.assertResult(expected.subResults.get(it), actual.subResults.get(it))]
	}
	
	def static void assertValue(Value expected, Value actual) {
		expected.eClass.name.assertEquals(actual.eClass.name)
		switch expected {
			BooleanValue: expected.value.assertEquals((actual as BooleanValue).value)
			IntegerValue: {
				expected.value.assertEquals((actual as IntegerValue).value)
				expected.unit.assertEquals((actual as IntegerValue).unit)
			}
			RealValue: {
				expected.value.assertEquals((actual as RealValue).value, 0.000_001)
				expected.unit.assertEquals((actual as RealValue).unit)
			}
			StringValue: expected.value.assertEquals((actual as StringValue).value)
		}
	}
	
	def static void assertDiagnostic(Diagnostic expected, Diagnostic actual) {
		expected.diagnosticType.assertEquals(actual.diagnosticType)
		expected.message.assertEquals(actual.message)
	}
	
	def static void assertEObject(EObject expected, EObject actual) {
		val expectedURI = if (expected !== null) {
			EcoreUtil.getURI(expected)
		}
		val actualURI = if (actual !== null) {
			EcoreUtil.getURI(actual)
		}
		expectedURI.assertEquals(actualURI)
	}
}