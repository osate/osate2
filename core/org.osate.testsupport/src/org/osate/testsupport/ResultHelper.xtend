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

class ResultHelper {
	def static AnalysisResult loadResult(ResourceSet resourceSet, String path) {
		val resource = resourceSet.createResource(URI.createURI(path))
		val url = new URL('''file:«System.getProperty("user.dir")»/../«path»''')
		val inputStream = url.openConnection.inputStream
		resource.load(inputStream, null)
		inputStream.close
		resource.contents.head as AnalysisResult
	}
	
	def static assertAnalysisResult(AnalysisResult expected, AnalysisResult actual) {
		expected.analysis.assertEquals(actual.analysis)
		expected.message.assertEquals(actual.message)
		expected.modelElement.assertEObject(actual.modelElement)
		expected.results.size.assertEquals(actual.results.size)
		(0 ..< expected.results.size).forEach[expected.results.get(it).assertResult(actual.results.get(it))]
	}
	
	def static void assertResult(Result expected, Result actual) {
		expected.message.assertEquals(actual.message)
		expected.modelElement.assertEObject(actual.modelElement)
		expected.values.size.assertEquals(actual.values.size)
		(0 ..< expected.values.size).forEach[expected.values.get(it).assertValue(actual.values.get(it))]
		expected.diagnostics.size.assertEquals(actual.diagnostics.size)
		(0 ..< expected.diagnostics.size).forEach[expected.diagnostics.get(it).assertDiagnostic(actual.diagnostics.get(it))]
		expected.subResults.size.assertEquals(actual.subResults.size)
		(0 ..< expected.subResults.size).forEach[expected.subResults.get(it).assertResult(actual.subResults.get(it))]
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
		expected.type.assertEquals(actual.type)
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