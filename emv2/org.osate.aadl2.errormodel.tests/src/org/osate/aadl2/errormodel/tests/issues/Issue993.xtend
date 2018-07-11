package org.osate.aadl2.errormodel.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractType
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.testsupport.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getPropagationName
import org.osate.aadl2.SystemType
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint
import org.osate.aadl2.SystemImplementation
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class Issue993 extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue993/"
	
	@Test
	def void testPkg1() {
		val pkg1FileName = "Issue993.aadl"
		createFiles(pkg1FileName -> readFile(PROJECT_LOCATION + pkg1FileName))
		ignoreSerializationDifferences
		val testFileResult = testFile(pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue993".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemType => [
				"s".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					points.get(0) as PropagationPoint => [
						"externalEffect".assertEquals(name)
					]
				]
			]
			publicSection.ownedClassifiers.get(2) as SystemImplementation => [
				"main.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					points.get(0) as PropagationPoint => [
						"externalEffect".assertEquals(name)
					]
					paths.size.assertEquals(2) 
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}