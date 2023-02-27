/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
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
import org.osate.aadl2.impl.ThreadTypeImpl
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.*
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2652Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testIssue2652(){
		val pkg1 = '''
			package ReservedPorts
			public
			
			  thread Correct
			    features
			      complete: out event port;
			      error: out event data port;
			      abort: out event port;
			      stop: out event port;
			  end Correct;
			
			  thread Invalid
			    features
			      -- there should be errors on each feature
			      complete: in data port;
			      error: in event port;
			      abort: out event data port;
			      stop: in event port;
			  end Invalid;
			  
			end ReservedPorts;
		'''
		val testFileResult = issues = testHelper.testString(pkg1)
      
		val issueCollection = new FluentIssueCollection(testFileResult.getResource(), newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"ReservedPorts".assertEquals(name)
			publicSection.ownedClassifiers.findFirst[name == "Invalid"] as ThreadTypeImpl => [
				"Invalid".assertEquals(name)
				
				"complete".assertEquals(ownedDataPorts.get(0).name)
				ownedDataPorts.get(0).assertError(testFileResult.issues, issueCollection, ownedDataPorts.get(0).getName() + " must be an out event port.")
				
				"error".assertEquals(ownedEventPorts.get(0).name)
				ownedEventPorts.get(0).assertError(testFileResult.issues, issueCollection, ownedEventPorts.get(0).getName() + " must be an out event data port.")
				
				"abort".assertEquals(ownedEventDataPorts.get(0).name)
				ownedEventDataPorts.get(0).assertError(testFileResult.issues, issueCollection, ownedEventDataPorts.get(0).getName() + " must be an out event port.")
				
				"stop".assertEquals(ownedEventPorts.get(1).name)
				ownedEventPorts.get(1).assertError(testFileResult.issues, issueCollection, ownedEventPorts.get(1).getName() + " must be an out event port.")
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}