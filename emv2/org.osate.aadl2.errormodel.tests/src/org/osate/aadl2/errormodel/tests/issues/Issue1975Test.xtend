package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.SystemType
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Properties.*
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.*

import static extension org.junit.Assert.assertEquals
import org.osate.aadl2.BusType
import static org.junit.Assert.assertTrue

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue1975Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue1975/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testPkg1() {
		val pkg1FileName = "BindingsPath.aadl"
		val pkg = testHelper.parseFile(PROJECT_LOCATION + pkg1FileName)
		pkg => [
			"BindingsPath".assertEquals(name)
			publicSection.ownedClassifiers.head as BusType => [
				"PCI".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					properties.get(0) as EMV2PropertyAssociation => [
						emv2Path.get(0) => [
							val et = getErrorType()
							assertTrue(et !== null)
							"ServiceOmission".assertEquals(et.name)
						]
						0.567.assertEquals(getOccurrenceValue(),0.01)
					]
				]
			]
		]
	}
}