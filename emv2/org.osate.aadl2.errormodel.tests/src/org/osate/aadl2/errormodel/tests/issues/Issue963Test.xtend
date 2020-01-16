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
package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
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
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull
import static extension org.osate.testsupport.AssertHelper.*
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getPropagationName


@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue963Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue963/"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)

	@Test
	def void testPkg1() {
		val pkg1FileName = "pkg1.aadl"
		val pkg = testHelper.parseFile(PROJECT_LOCATION + pkg1FileName)
		pkg => [
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
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + pkg2FileName)
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
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}