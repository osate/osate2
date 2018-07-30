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

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import org.osate.organization.organization.Organization

@RunWith(XtextRunner)
@InjectWith(FullAlisaInjectorProvider)  // this one generates null pointer as the parsed resource is empty when FullAlisa is an extension of Assure
class AssureTests extends XtextTest {
	@Inject
	TestHelper<AadlPackage> aadl2TestHelper
	
	@Inject
	TestHelper <Organization> organizationTestHelper

	val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	val propertiesprefix = projectprefix+"Properties/"
	val aadlprefix = projectprefix+"aadl/"
	val alisaprefix = projectprefix+"alisa/"

	@Test
	def void aadltest() {
		val aadltestFileResult = issues = aadl2TestHelper.testFile(aadlprefix+"SimpleControlSystem.aadl",propertiesprefix+"ACVIP.aadl", 
			propertiesprefix+"Physical.aadl",aadlprefix+"PhysicalResources.aadl",aadlprefix+"DataDictionary.aadl",
			aadlprefix+"Platform.aadl",aadlprefix+"Software.aadl", aadlprefix+"DigitalControlSystem.aadl"
			
		)
		val issueCollection = new FluentIssueCollection(aadltestFileResult.resource, newArrayList, newArrayList)
		aadltestFileResult.resource.contents.head as AadlPackage => [
			"SimpleControlSystem".assertEquals(name)	
			
			]	
		}
	@Test
	def void orgtest() {
		val orgtestFileResult = issues = organizationTestHelper.testFile(alisaprefix+"sei.org"
			
		)
		val issueCollection = new FluentIssueCollection(orgtestFileResult.resource, newArrayList, newArrayList)
		orgtestFileResult.resource.contents.head as Organization => [
			"sei".assertEquals(name)	
			
			]	
		}
	
}