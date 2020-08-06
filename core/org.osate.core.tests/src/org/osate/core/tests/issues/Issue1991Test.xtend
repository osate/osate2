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

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1991Test extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	//Tests checkDataSizeProperty
	@Test
	def void fgTest(){
		val test ='''
		package FGtest
		public
			feature group FG
				features
					outPort: out event port;
					inPort: in event port;
			end FG;
			
			
			thread T
				features
					fg: feature group FG;
					fg_inv: feature group inverse of fg;
				flows
					fsrc1: flow source fg;
		    		fsrc2: flow source fg_inv;
		
		    		fsnk1: flow sink fg;
		    		fsnk2: flow sink fg_inv;
		    		
		
		    		fpath1: flow path fg -> fg_inv;
		    		fpath2: flow path fg_inv -> fg;
		    		fpath3: flow path fg -> fg_inv;
		    		fpath4: flow path fg_inv -> fg;
			end T;
			
			thread implementation T.impl
				flows
					fsrc1: flow source fg.inPort; 
		    		fsrc2: flow source fg_inv.outPort; 
		    		
		    		fsnk1: flow sink fg.outPort;
		    		fsnk2: flow sink fg_inv.inPort; 
		
		    		fpath1: flow path fg.outPort -> fg_inv.outPort; 
		    		fpath2: flow path fg_inv.inPort -> fg.inPort;
		    		fpath3: flow path fg.inPort -> fg_inv.inPort;
		    		fpath4: flow path fg_inv.outPort -> fg.outPort;
			end T.impl;
		end FGtest;
		'''
		
		val testFileResult = issues = testHelper.testString(test)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"FGtest".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as ThreadImplementation => [
				"T.impl".assertEquals(name)
				allFlowImplementations.get(0) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg.inPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(1) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.outPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(2) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg.outPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(3) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.inPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(4) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg.outPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(5) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.inPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(4) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.outPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(5) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg.inPort' must be an out or in out feature.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	@Test
	def void fgtTest(){
		val test ='''
		package FGTtest
		public
			feature group FG
				features
					outPort: out event port;
					inPort: in event port;
			end FG;
			
			feature group FG_inv inverse of FG
			end FG_inv;
			
			thread T
				features
					fg: feature group FG;
					fg_inv: feature group FG_inv;
				flows
					fsrc1: flow source fg;
		    		fsrc2: flow source fg_inv;
		
		    		fsnk1: flow sink fg;
		    		fsnk2: flow sink fg_inv;
		
		    		fpath1: flow path fg -> fg_inv;
		    		fpath2: flow path fg_inv -> fg;
		    		fpath3: flow path fg -> fg_inv;
		    		fpath4: flow path fg_inv -> fg;
			end T;
			
			thread implementation T.impl
				flows
					fsrc1: flow source fg.inPort;
		    		fsrc2: flow source fg_inv.outPort; 
		    		
		    		fsnk1: flow sink fg.outPort;
		    		fsnk2: flow sink fg_inv.inPort; 
		    		
					fpath1: flow path fg.outPort -> fg_inv.outPort;
					fpath2: flow path fg_inv.inPort -> fg.inPort;
					fpath3: flow path fg.inPort -> fg_inv.inPort;
		    		fpath4: flow path fg_inv.outPort -> fg.outPort;
			end T.impl;
		end FGTtest;
		'''
		
		val testFileResult = issues = testHelper.testString(test)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"FGTtest".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as ThreadImplementation => [
				"T.impl".assertEquals(name)
				allFlowImplementations.get(0) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg.inPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(1) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.outPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(2) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg.outPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(3) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.inPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(4) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg.outPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(5) as FlowImplementation => [
					it.inEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.inPort' must be an in or in out feature.")
				]
				allFlowImplementations.get(4) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg_inv.outPort' must be an out or in out feature.")
				]
				allFlowImplementations.get(5) as FlowImplementation => [
					it.outEnd.assertError(testFileResult.issues, issueCollection, "'fg.inPort' must be an out or in out feature.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
		
}