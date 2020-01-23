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
class Issue744Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue744() {
	
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			assertEquals("pkg1", name)
			cls.get(1) as AbstractImplementation => [
				assertEquals("a1.i", name)
				ownedPortConnections.head => [
					"conn1".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	val aadlText = '''
package pkg1
public
	abstract a1
		features
			p1: in data port d1.i;
	end a1;
	
	abstract implementation a1.i
		subcomponents
			asub1: abstract a2;
		connections
			conn1: port p1.dsub1 -> asub1.p2;
	end a1.i;
	
	data d1
	end d1;
	
	data implementation d1.i
		subcomponents
			dsub1: data;
	end d1.i;
	
	abstract a2
		features
			p2: in data port;
	end a2;
end pkg1;
'''
}