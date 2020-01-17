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
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue709Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testConnections() {
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			"pkg1".assertEquals(name)
			cls.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFeatureGroupConnections.get(2) => [
					"conn3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg1' and 'fg1' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(3) => [
					"conn4".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg2' and 'fg2' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(4) => [
					"conn5".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg3' and 'fg3' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(5) => [
					"conn6".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg1' and 'fg4' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(6) => [
					"conn7".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg1' and 'fg5' are not inverses of each other.")
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
			fg1: feature group fgt1;
			fg2: feature group inverse of fgt1;
			fg3: feature group fgt2;
			fg4: feature group inverse of fgt3;
			fg5: feature group fgt4;
	end a1;
	
	abstract implementation a1.i
		subcomponents
			sub1: abstract a1;
			sub2: abstract a1;
		connections
			--Correct
			conn1: feature group sub1.fg1 -> sub2.fg2;
			conn2: feature group sub1.fg1 -> sub2.fg3;
			
			--Same classifier, not inverse
			conn3: feature group sub1.fg1 -> sub2.fg1;
			conn4: feature group sub1.fg2 -> sub2.fg2;
			conn5: feature group sub1.fg3 -> sub2.fg3;
			
			--Inverses, but not same classifier
			conn6: feature group sub1.fg1 -> sub2.fg4;
			conn7: feature group sub1.fg1 -> sub2.fg5;
	end a1.i;
	
	feature group fgt1
	end fgt1;
	
	feature group fgt2
		inverse of fgt1
	end fgt2;
	
	feature group fgt3
	end fgt3;
	
	feature group fgt4
		inverse of fgt3
	end fgt4;
end pkg1;
'''
}