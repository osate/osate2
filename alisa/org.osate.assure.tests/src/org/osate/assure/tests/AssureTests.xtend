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

package org.osate.assure.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.osate.assure.AssureInjectorProvider
import com.itemis.xtext.testing.XtextTest
import com.google.inject.Inject
import org.osate.testsupport.TestHelper
import org.osate.aadl2.AadlPackage
import org.osate.reqspec.reqSpec.ReqSpec
import org.junit.Test
import com.itemis.xtext.testing.FluentIssueCollection
import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(AssureInjectorProvider)
class AssureTests extends XtextTest {
	@Inject
	TestHelper<AadlPackage> aadl2testHelper
	TestHelper<ReqSpec> reqspectestHelper

	val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	val projectaadlprefix = projectprefix+"aadl/"

	@Test
	def void reqspectest() {
		val aadltestFileResult = issues = aadl2testHelper.testFile(projectaadlprefix+"SimpleControlSystem.aadl", projectaadlprefix+"DataDictionary.aadl",
			projectaadlprefix+"Platform.aadl",projectaadlprefix+"Software.aadl", projectaadlprefix+"DigitalControlSystem.aadl"
			,projectprefix+"Properties/ACVIP.aadl"
		)
		val issueCollection = new FluentIssueCollection(aadltestFileResult.resource, newArrayList, newArrayList)
		aadltestFileResult.resource.contents.head as AadlPackage => [
			"SimpleControlSystem".assertEquals(name)	
			
			]	
		}
	
}