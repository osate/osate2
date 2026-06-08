/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.TestHelper
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2455Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue2455Test(){

		val testFileResult = issues = testHelper.testFile("org.osate.aadl2.errormodel.tests/models/Issue2455/Cyclic_Error_types.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"Cyclic_Error_Types".assertEquals(name)
			publicSection.ownedAnnexLibraries.get(0) as DefaultAnnexLibrary => [
				"EMV2".assertEquals(name)
				it.parsedAnnexLibrary as ErrorModelLibrary => [
					it.types.get(0).assertError(testFileResult.issues, issueCollection, "Cycle in supertype hierarchy of error type a at type b")
					it.types.get(1).assertError(testFileResult.issues, issueCollection, "Cycle in supertype hierarchy of error type b at type a")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
		}
}