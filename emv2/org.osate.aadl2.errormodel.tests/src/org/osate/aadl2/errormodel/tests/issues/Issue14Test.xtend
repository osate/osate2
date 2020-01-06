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
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue14Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue14() {
		val issue14 = '''
package issue14
public
	device battery
		features
			socket: requires bus access mybus;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				socket: out propagation {ServiceOmission};
				socket: in propagation {ItemOmission};
				end propagations;
			**};
	end battery;
	bus mybus
	
	end mybus;
	system power
		features
			line1: requires bus access mybus;
			line2: requires bus access mybus;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				line1: out propagation {ValueError};
				line1: in propagation {TimingError};
				line2: out propagation {ValueError};
				end propagations;
			**};
	end power;
	system implementation power.generic
		subcomponents
			battery1: device battery;
			battery2: device battery;
		connections
			pwr1: bus access line1 <-> battery1.socket;
			pwr2: bus access  battery2.socket <-> line2;
	end power.generic;
end issue14;
		'''
		val testFileResult = issues = testHelper.testString(issue14)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue14".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as ComponentImplementation=> [
				"power.generic".assertEquals(name)
				allConnections.get(0) => [
					"pwr1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Reverse direction: Destination propagation  socket{ServiceOmission} has error types not handled by source propagation line1{ValueError}", "Source propagation  line1{TimingError} has error types not handled by destination propagation socket{ItemOmission}")
				]
				allConnections.get(1) => [
					"pwr2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Source propagation  socket{ServiceOmission} has error types not handled by destination propagation line2{ValueError}")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	@Test
	def void issue14_1() {
		val issue14 = '''
package issue14_1
public
	abstract sender
		features
			outp: in out data port;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				outp: out propagation {ServiceOmission};
				end propagations;
			**};
	end sender;
	abstract receiver
		features
			inp: in out data port;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				inp: in propagation {ValueError};
				inp: out propagation {ValueError};
				end propagations;
			**};
	end receiver;
	system processing
	end processing;
	system implementation processing.generic
		subcomponents
			send: abstract sender;
			receive: abstract receiver;
		connections
			conn1: port send.outp <-> receive.inp; 
	end processing.generic;
end issue14_1;
		'''
		val testFileResult = issues = testHelper.testString(issue14)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue14_1".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as ComponentImplementation=> [
				"processing.generic".assertEquals(name)
				allConnections.get(0) => [
					"conn1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Source propagation  outp{ServiceOmission} has error types not handled by destination propagation inp{ValueError}")
					assertWarning(testFileResult.issues, issueCollection, "No incoming error propagation for outgoing propagation inp{ValueError}")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}