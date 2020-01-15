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
import org.osate.aadl2.SubprogramImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue727Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testConnections() {
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			"pkg1".assertEquals(name)
			cls.get(1) as AbstractImplementation => [
					"a.i".assertEquals(name)
					ownedPortConnections.head => [
						"conn1".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
					ownedFeatureConnections.head => [
						"conn2".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
					ownedFeatureGroupConnections.head => [
						"conn3".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
					ownedAccessConnections.head => [
						"conn4".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
				]
				cls.get(3) as SubprogramImplementation => [
					"subp.i".assertEquals(name)
					ownedParameterConnections.head => [
						"conn5".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
				]
			]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	val aadlText = '''
package pkg1
public
	abstract a
		features
			p1: in data port;
			p2: out data port;
			af1: feature;
			af2: feature;
			fg1: feature group;
			fg2: feature group;
			da1: provides data access;
			da2: requires data access;
	end a;
	
	abstract implementation a.i
		connections
			conn1: port p1 -> p2;
			conn2: feature af1 -> af2;
			conn3: feature group fg1 -> fg2;
			conn4: data access da1 -> da2;
	end a.i;
	
	subprogram subp
		features
			param1: in parameter;
			param2: out parameter;
	end subp;
	
	subprogram implementation subp.i
		connections
			conn5: parameter param1 -> param2;
	end subp.i;
end pkg1;
'''

}