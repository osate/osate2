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
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getPropagationName

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class Issue963Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue963/"
	
	@Test
	def void testPkg1() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> readFile(PROJECT_LOCATION + pkg1FileName))
		ignoreSerializationDifferences
		testFile(pkg1FileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"a1".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					properties.get(0).emv2Path.head.emv2Target => [
						"fg1".assertEquals((namedElement as ErrorPropagation).propagationName)
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["f1", "fg1"])
						path => [
							"type1".assertEquals(namedElement.name)
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["type1", "type2", "pkg1::type1", "pkg1::type2"])
							path.assertNull
						]
					]
					properties.get(1).emv2Path.head.emv2Target => [
						"f1".assertEquals((namedElement as ErrorPropagation).propagationName)
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["f1", "fg1"])
						path => [
							"type1".assertEquals(namedElement.name)
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["type1", "type2", "pkg1::type1", "pkg1::type2"])
							path.assertNull
						]
					]
				]
			]
		]
	}
	
	@Test
	def void testPkg2() {
		val pkg2FileName = "pkg2.aadl"
		createFiles(pkg2FileName -> readFile(PROJECT_LOCATION + pkg2FileName))
		ignoreSerializationDifferences
		val testFileResult = testFile(pkg2FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg2".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					properties.get(0).emv2Path.head.emv2Target => [
						"fg1".assertEquals((namedElement as ErrorPropagation).propagationName)
						Assert.assertTrue(namedElement instanceof ErrorPropagation)
						path => [
							"type1".assertEquals(namedElement.name)
							path.assertNull
						]
					]
					properties.get(1).emv2Path.head.emv2Target => [
						"fg2".assertEquals(namedElement.name)
						Assert.assertTrue(namedElement instanceof FeatureGroup)
						path => [
							assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
							path.assertNull
						]
					]
					properties.get(2).emv2Path.head.emv2Target => [
						"fg3".assertEquals(namedElement.name)
						Assert.assertTrue(namedElement instanceof FeatureGroup)
						path => [
							assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
							path.assertNull
						]
					]
					properties.get(3).emv2Path.head.emv2Target => [
						"fg4".assertEquals(namedElement.name)
						Assert.assertTrue(namedElement instanceof FeatureGroup)
						path => [
							assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
							path.assertNull
						]
					]
					properties.get(4).emv2Path.head.emv2Target => [
						"fg4".assertEquals(namedElement.name)
						path => [
							"fg4.fg9".assertEquals((namedElement as ErrorPropagation).propagationName)
							Assert.assertTrue(namedElement instanceof ErrorPropagation)
							path => [
								"type1".assertEquals(namedElement.name)
								path.assertNull
							]
						]
					]
					properties.get(5).emv2Path.head.emv2Target => [
						"fg4".assertEquals(namedElement.name)
						path => [
							"fg10".assertEquals(namedElement.name)
							Assert.assertTrue(namedElement instanceof FeatureGroup)
							path => [
								assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
								path.assertNull
							]
						]
					]
					properties.get(6).emv2Path.head.emv2Target => [
						"fg4".assertEquals(namedElement.name)
						path => [
							"fg11".assertEquals(namedElement.name)
							Assert.assertTrue(namedElement instanceof FeatureGroup)
							path => [
								assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
								path.assertNull
							]
						]
					]
					properties.get(7).emv2Path.head.emv2Target => [
						"fg4".assertEquals(namedElement.name)
						path => [
							"fg12".assertEquals(namedElement.name)
							Assert.assertTrue(namedElement instanceof FeatureGroup)
							path => [
								assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
								path.assertNull
							]
						]
					]
					properties.get(8).emv2Path.head.emv2Target => [
						"fg5".assertEquals((namedElement as ErrorPropagation).propagationName)
						Assert.assertTrue(namedElement instanceof ErrorPropagation)
						path => [
							"type1".assertEquals(namedElement.name)
							path.assertNull
						]
					]
					properties.get(9).emv2Path.head.emv2Target => [
						"fg6".assertEquals(namedElement.name)
						Assert.assertTrue(namedElement instanceof FeatureGroup)
						path => [
							assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
							path.assertNull
						]
					]
					properties.get(10).emv2Path.head.emv2Target => [
						"fg7".assertEquals(namedElement.name)
						Assert.assertTrue(namedElement instanceof FeatureGroup)
						path => [
							assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
							path.assertNull
						]
					]
					properties.get(11).emv2Path.head.emv2Target => [
						"fg8".assertEquals(namedElement.name)
						Assert.assertTrue(namedElement instanceof FeatureGroup)
						path => [
							assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
							path.assertNull
						]
					]
					properties.get(12).emv2Path.head.emv2Target => [
						"fg8".assertEquals(namedElement.name)
						path => [
							"fg8.fg9".assertEquals((namedElement as ErrorPropagation).propagationName)
							Assert.assertTrue(namedElement instanceof ErrorPropagation)
							path => [
								"type1".assertEquals(namedElement.name)
								path.assertNull
							]
						]
					]
					properties.get(13).emv2Path.head.emv2Target => [
						"fg8".assertEquals(namedElement.name)
						path => [
							"fg10".assertEquals(namedElement.name)
							Assert.assertTrue(namedElement instanceof FeatureGroup)
							path => [
								assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
								path.assertNull
							]
						]
					]
					properties.get(14).emv2Path.head.emv2Target => [
						"fg8".assertEquals(namedElement.name)
						path => [
							"fg11".assertEquals(namedElement.name)
							Assert.assertTrue(namedElement instanceof FeatureGroup)
							path => [
								assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
								path.assertNull
							]
						]
					]
					properties.get(15).emv2Path.head.emv2Target => [
						"fg8".assertEquals(namedElement.name)
						path => [
							"fg12".assertEquals(namedElement.name)
							Assert.assertTrue(namedElement instanceof FeatureGroup)
							path => [
								assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to 'type1'.")
								path.assertNull
							]
						]
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}