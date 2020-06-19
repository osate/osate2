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
import org.osate.aadl2.AbstractImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertWarning

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue781Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue781() {
		val pkg1 = '''
			package pkg1
			public
				abstract a1
					features
						af1: feature;
						fg1: feature group fgt1;
					flows
						flow1: flow source af1;
						flow2: flow sink af1;
						flow3: flow path af1 -> af1;
						flow4: flow source fg1;
						flow5: flow sink fg1;
						flow6: flow path fg1 -> fg1;
				end a1;
				
				abstract implementation a1.i
				  subcomponents
				    s1: abstract a1;
				    s2: abstract a1;
				  connections
				    c1: feature s1.af1 -> s2.af1;
				flows
					flow1: flow source af1;
					flow2: flow sink af1;
					flow3: flow path af1 -> af1;
					flow4: flow source fg1.af2;
					flow5: flow sink fg1.af2;
					flow6: flow path fg1.af2 -> fg1.af2;
				end a1.i;
				
				feature group fgt1
					features
						af2: feature;
				end fgt1;
			end pkg1;
		'''
		val testFileResult = issues = testHelper.testString(pkg1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFlowImplementations.get(0) => [
					"flow1".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
				ownedFlowImplementations.get(1) => [
					"flow2".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
				ownedFlowImplementations.get(2) => [
					"flow3".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}