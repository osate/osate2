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
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue53Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue53() {
		val issue53 = '''
package issue53
public
system pedals
features
pedal_position : out data port ;
annex EMV2 {**                                                                                                   
use types errorlibrary;
use behavior ErrorLibrary::FailStop;

error propagations
    pedal_position : out propagation {badvalue};
end propagations;

properties
    EMV2::Likelihood    => ARP4761::Probable applies to pedal_position.serviceomission;
    EMV2::Severity     => ARP4761::Major applies to pedal_position.badvalue;
    **};
end pedals;

end issue53;
		'''
		val testFileResult = issues = testHelper.testString(issue53)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue53".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"pedals".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).properties.head => [
					assertError(testFileResult.issues, issueCollection, "Property EMV2::Likelihood applies to refers to type ServiceOmission not contained in type set of error propagation pedal_position")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}