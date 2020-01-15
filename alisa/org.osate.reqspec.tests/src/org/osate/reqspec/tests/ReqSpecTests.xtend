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

package org.osate.reqspec.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.reqspec.reqSpec.ReqSpec
import org.osate.reqspec.reqSpec.ReqValDeclaration
import org.osate.reqspec.reqSpec.Requirement
import org.osate.reqspec.reqSpec.SystemRequirementSet
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*
import static org.osate.reqspec.util.ReqSpecUtilExtension.*
import org.osate.reqspec.util.ReqSpecUtilExtension
import org.osate.alisa.common.common.ValDeclaration
import org.osate.reqspec.reqSpec.ReqSpecPackage
import com.itemis.xtext.testing.FluentIssueCollection
import static extension org.osate.testsupport.AssertHelper.*
 
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ReqSpecAadl2InjectorProvider))
class ReqSpecTests extends XtextTest {
	
	@Inject
	TestHelper<ReqSpec> reqspecTestHelper
	
	@Inject extension ValidationTestHelper

	val projectprefix = "org.osate.reqspec.tests/models/ControlSystem/"

	
	@Test
	def void testUnitResolution() {
		val reqspec = reqspecTestHelper.parseFile(projectprefix+"CSUnitTest.reqspec", projectprefix+"sei.org", projectprefix+"ControlSystem.aadl")
		reqspec.eResource.assertNoErrors
			assertEquals(reqspec.parts.size, 1)
			val srs = reqspec.parts.get(0) as SystemRequirementSet 
			assertEquals(srs.name, "csunittest")
			val req = srs.requirements.get(0) as Requirement 
			assertEquals(req.name,"R1")
			assertTrue(req.constants.size > 0)
			val vd = req.constants.get(0) as ReqValDeclaration
			assertEquals(vd.name,"MaximumWeight")
	}

	@Test
	// this test uses ValidationTestHelper.
	// Its methods use text position for the model element.
	// If position is set to -1,-1 then any object that is of the specified class is considered a match.
	// When using these methods we are not able to determine whether there are issues in the model that are not asserted
	def void testControlSystemNoGoalsReqs() {
		val reqspec = reqspecTestHelper.parseFile(projectprefix+"CSReqs.reqspec", projectprefix+"predefined.cat",projectprefix+"sei.org", projectprefix+"ControlSystem.aadl")
			assertEquals(reqspec.parts.size, 1)
			assertTrue(reqspec.parts.size > 0)
			val srs = reqspec.parts.get(0) as SystemRequirementSet 
			assertEquals(srs.name, "dcsreqs")
			val req = srs.requirements.get(0) as Requirement 
			assertEquals(req.name,"R1")
			assertEquals(req.constants.size ,1)
			val vd = req.constants.get(0) as ReqValDeclaration
			assertEquals(vd.name,"MaximumWeight")
			req.assertError(ReqSpecPackage.Literals.REQUIREMENT, "org.eclipse.xtext.diagnostics.Diagnostic.Linking", 469,11,"Couldn't resolve reference to Goal 'CSgoals.ng2'.")
			srs.assertWarning(ReqSpecPackage.Literals.SYSTEM_REQUIREMENT_SET, "featuresWithoutRequirement", 200,283, "Features without requirement: R1")
	}
	
		@Test
	// This test uses the FluentIssueCollection as mechanism to track asserted issues
	def void testControlSystemNoGoalsReqsFluency() {
		val testFileResult = issues = reqspecTestHelper.testFile(projectprefix+"CSReqs.reqspec", projectprefix+"predefined.cat",projectprefix+"sei.org", projectprefix+"ControlSystem.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val reqspec = issues.resource.contents.get(0) as ReqSpec
			assertEquals(reqspec.parts.size, 1)
			assertTrue(reqspec.parts.size > 0)
			val srs = reqspec.parts.get(0) as SystemRequirementSet 
			assertEquals(srs.name, "dcsreqs")
			val req = srs.requirements.get(0) as Requirement 
			assertEquals(req.name,"R1")
			assertEquals(req.constants.size ,1)
			val vd = req.constants.get(0) as ReqValDeclaration
			assertEquals(vd.name,"MaximumWeight")
			req.assertError(testFileResult.issues, issueCollection, "Couldn't resolve reference to Goal 'CSgoals.ng2'.")
			srs.assertWarning(testFileResult.issues, issueCollection, "Features without requirement: R1")
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	

}