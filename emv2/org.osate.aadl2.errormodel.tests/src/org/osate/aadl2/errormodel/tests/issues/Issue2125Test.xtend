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
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.common.util.URI
import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*
import org.osate.testsupport.AssertHelper
import org.osate.aadl2.DeviceImplementation
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue2125Test extends XtextTest {
	val static PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/Issue2125/"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	
	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)
	
	@Test
	def void testPkg1() {
		val pkg1FileName = "ErrorStateWithTypes.aadl"
		val testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"ErrorStateWithTypes".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as DeviceImplementation => [
				"iPCA_Error_Detector.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					transitions.get(1) as ErrorBehaviorTransition => [
						assertError(testFileResult.issues, issueCollection, "Target state failed_undetected requires type but the triggering error event post_not_detect_failure or source state working does not have a type")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}