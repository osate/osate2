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

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue1792Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue1792/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)

	@Test
	def void testPkg1() {
		val pkgpcFileName = "PC.aadl"
		val pkg1FileName = "resolvepropertyconstant.aadl"
		val pkg = testHelper.parseFile(PROJECT_LOCATION + pkg1FileName, PROJECT_LOCATION + pkgpcFileName)
		pkg => [
			"resolvePC".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemType => [
				"s".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					properties.get(0) as EMV2PropertyAssociation => [
						0.567.assertEquals(getOccurrenceValue(),0.01)
					]
					properties.get(1) as EMV2PropertyAssociation => [
						0.123.assertEquals(getOccurrenceValue(),0.01)
					]
				]
			]
		]
	}
}