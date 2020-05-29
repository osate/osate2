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
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.osate.testsupport.AssertHelper.*
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.SystemType

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2319Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2319/"

	@Test
	def void testSubcomponent() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "TestSubcomponentRefinement.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			ownedPublicSection => [
				ownedClassifiers.findFirst[name == "Top.i1"] as ComponentImplementation => [
					ownedSubcomponents.findFirst[name == "s"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier S")
					]
				]

				ownedClassifiers.findFirst[name == "Top.i3"] as ComponentImplementation => [
					ownedSubcomponents.findFirst[name == "s"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier S refined to Other does not satisfy 'Type Extension'")
					]
				]

				ownedClassifiers.findFirst[name == "Top.i4"] as ComponentImplementation => [
					ownedSubcomponents.findFirst[name == "s"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier S1")
					]
				]

				ownedClassifiers.findFirst[name == "Top.i5"] as ComponentImplementation => [
					ownedSubcomponents.findFirst[name == "s"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier S1 refined to S does not satisfy 'Type Extension'")
					]
				]

				ownedClassifiers.findFirst[name == "Top.i7"] as ComponentImplementation => [
					ownedSubcomponents.findFirst[name == "s"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier S1 refined to Other does not satisfy 'Type Extension'")
					]
				]

			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void testPortRefinement() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "TestPortRefinement.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			ownedPublicSection => [
				ownedClassifiers.findFirst[name == "SrcSys2"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier D refined to E does not satisfy 'Type Extension'")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys7"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier D")
					]
				]

				ownedClassifiers.findFirst[name == "x1"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier D2")
					]
				]

				ownedClassifiers.findFirst[name == "x2"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier D2 refined to D does not satisfy 'Type Extension'")
					]
				]

				ownedClassifiers.findFirst[name == "x5"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier D2 refined to E does not satisfy 'Type Extension'")
					]
				]

			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	@Test
	def void testAbstractFeatures() {
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + "TestAbstractFeatureRefinement.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)

		testFileResult.resource.contents.head as AadlPackage => [
			ownedPublicSection => [
				ownedClassifiers.findFirst[name == "SrcSys2"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier D refined to E does not satisfy 'Type Extension'")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys5"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier D refined to E does not satisfy 'Type Extension'")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys7"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier D")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys8"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier D")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys9"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier D")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys12"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier D refined to E does not satisfy 'Type Extension'")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys13"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Refinement removes classifier D")
					]
				]

				ownedClassifiers.findFirst[name == "SrcSys15"] as SystemType => [
					ownedFeatures.findFirst[name == "f0"] => [
						assertWarning(testFileResult.issues, issueCollection, "Classifier D refined to B does not satisfy 'Type Extension'")
					]
				]

			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}
