/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
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

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(ReqSpecAadl2InjectorProvider))
class ReqSpecTests extends XtextTest {
	
	@Inject
	TestHelper<ReqSpec> reqspecTestHelper
	
	@Inject extension ValidationTestHelper

	val projectprefix = "org.osate.reqspec.tests/models/"

	
	@Test
	// we need to remove the AADL reference here because AADL does not test headlessly
	def void testUnitResolution() {
		val issues = reqspecTestHelper.testFile(projectprefix+"CSUnitTest.reqspec", projectprefix+"sei.org", projectprefix+"ControlSystem.aadl")
		issues.resource.assertNoErrors
		val rs = issues.resource.contents.get(0) as ReqSpec
			assertEquals(rs.parts.size, 1)
			assertTrue(rs.parts.size > 0)
			val srs = rs.parts.get(0) as SystemRequirementSet 
			assertEquals(srs.name, "csunittest")
			val req = srs.requirements.get(0) as Requirement 
			assertEquals(req.name,"R1")
			assertTrue(req.constants.size > 0)
			val vd = req.constants.get(0) as ReqValDeclaration
			assertEquals(vd.name,"MaximumWeight")
	}
}