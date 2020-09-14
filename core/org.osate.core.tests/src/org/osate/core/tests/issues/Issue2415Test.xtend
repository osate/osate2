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
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError
import org.osate.aadl2.FlowImplementation
import org.osate.aadl2.ThreadImplementation
import org.osate.aadl2.AbstractImplementation

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue2415Test extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void issue2415Test(){
		val test ='''
		package Issue2415
		public
			
			abstract A
				features
					i: in data port;
					o: out data port;
				flows
					fsrc: flow source o;
					fpth: flow path i -> o;
					fsnk: flow sink i;
			end A;
			
			abstract implementation A.impl
				subcomponents
					mm1: abstract A;
					mm2: abstract A;
				connections
					cml: port i -> mm1.i;
					cmm: port mm1.o -> mm2.i;
					cmr: port mm2.o -> o;
				flows
					--this one is ok
					fpth: flow path i -> cml -> mm1.fpth -> cmm -> mm2.fpth -> cmr -> o;
					fpth: flow path i -> cml -> mm1.fsrc -> cmm -> mm2.fpth -> cmr -> o; 
					fpth: flow path i -> cml -> mm1.fsnk -> cmm -> mm2.fpth -> cmr -> o;
					fpth: flow path i -> cml -> mm2.fsrc -> cmm -> mm2.fpth -> cmr -> o; 
					fpth: flow path i -> cml -> mm2.fsnk -> cmm -> mm2.fpth -> cmr -> o;
					-- this one is ok
					fsrc: flow source mm2.fsrc -> cmr -> o; 
					-- this one is ok
					fsrc: flow source mm1.fsrc -> cmm -> mm2.fpth -> cmr -> o;
					fsrc: flow source mm1.fsrc -> cmm -> mm2.fsrc -> cmr -> o; 
					fsrc: flow source mm1.fsrc -> cmm -> mm2.fsnk -> cmr -> o;
					-- this one is ok
					fsnk: flow sink i -> cml -> mm1.fsnk;
					-- this one is ok
					fsnk: flow sink i -> cml -> mm1.fpth -> cmm -> mm2.fsnk; 
					fsnk: flow sink i -> cml -> mm2.fsrc -> cmm -> mm2.fsnk; 
					fsnk: flow sink i -> cml -> mm1.fsnk -> cmm -> mm2.fsnk;
			end A.impl;
		
			
		end Issue2415;
		'''
		
		val testFileResult = issues = testHelper.testString(test)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"Issue2415".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"A.impl".assertEquals(name)
				allFlowImplementations.get(1) as FlowImplementation => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm1.fsrc'.  Cannot refer to a flow source except for the first segment of a flow implementation.")
				]
				allFlowImplementations.get(2) as FlowImplementation => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm1.fsnk'.  Cannot refer to a flow sink except for the last segment of a flow implementation.")
				]
				allFlowImplementations.get(3) as FlowImplementation => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm2.fsrc'.  Cannot refer to a flow source except for the first segment of a flow implementation.")
				]
				allFlowImplementations.get(4) as FlowImplementation => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm2.fsnk'.  Cannot refer to a flow sink except for the last segment of a flow implementation.")
				]
				allFlowImplementations.get(7) as FlowImplementation => [
					it.ownedFlowSegments.get(2).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm2.fsrc'.  Cannot refer to a flow source except for the first segment of a source specification.")
				]
				allFlowImplementations.get(8) as FlowImplementation => [
					it.ownedFlowSegments.get(2).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm2.fsnk'.  Cannot refer to a flow sink except for the last segment of a sink specification.")
				]
				allFlowImplementations.get(11) as FlowImplementation => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm2.fsrc'.  Cannot refer to a flow source except for the first segment of a source specification.")
				]
				allFlowImplementations.get(12) as FlowImplementation => [
					it.ownedFlowSegments.get(1).assertError(testFileResult.issues, issueCollection, "Illegal reference to 'mm1.fsnk'.  Cannot refer to a flow sink except for the last segment of a sink specification.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}		
}