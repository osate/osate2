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
package org.osate.core.tests.aadl2javavalidator

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
class EndToEndFlowSegmentTypesTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	//Tests typeCheckEndToEndFlowSegments
	@Test
	def void testEndToEndFlowSegmentTypes() {
		val aadlText = '''
			package legalETEFlowSegmentsTypeTest
			public
				abstract a1
				features
					da1: provides data access;
					af1: feature;
					dp1: in data port a3.i;
					edp1: in event data port a3.i;
					fg1: feature group fgt1;
				flows
					fpath1: flow path af1 -> af1;
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
				calls sequence1: {
					call1: subprogram subp1.i;
				};
				connections
					fconn1: feature asub1.af2 -> asub1.af2;
				flows
					--EndToEndFlow (at ETEConnectionFlow)
					etef1: end to end flow asub1.fpath2 -> etef2 -> asub1.fpath2;
					--Connection (at ETEConnectionFlow)
					etef2: end to end flow asub1.fpath2 -> fconn1 -> asub1.fpath2;
					--DataAccess (at ETEConnectionFlow)
					etef3: end to end flow asub1.fpath2 -> da1 -> asub1.fpath2;
					--FlowSpecification (at ETEConnectionFlow)
					etef4: end to end flow asub1.fpath2 -> fpath1 -> asub1.fpath2;
					--Subcomponent (at ETEConnectionFlow)
					etef5: end to end flow asub1.fpath2 -> asub1 -> asub1.fpath2;
					
					--EndToEndFlow (at ETESubcomponentFlow)
					etef6: end to end flow etef2 -> fconn1 -> asub1.fpath2;
					--Connection (at ETESubcomponentFlow)
					etef7: end to end flow fconn1 -> fconn1 -> asub1.fpath2;
					--DataAccess (at ETESubcomponentFlow, first and last segments)
					etef8: end to end flow da1 -> fconn1 -> da1;
					--DataAccess (at ETESubcomponentFlow, intermediate segment)
					etef9: end to end flow asub1.fpath2 -> fconn1 -> da1 -> fconn1 -> asub1.fpath2;
					--FlowSpecification (at ETESubcomponentFlow)
					etef10: end to end flow fpath1 -> fconn1 -> asub1.fpath2;
					--Subcomponent (at ETESubcomponentFlow)
					etef11: end to end flow asub1 -> fconn1 -> asub1.fpath2;
					
					--DataPort.EndToEndFlow
					etef12: end to end flow dp1.etef34 -> fconn1 -> asub1.fpath2;
					--DataPort.Connection
					etef13: end to end flow dp1.fconn3 -> fconn1 -> asub1.fpath2;
					--DataPort.DataAccess
					etef14: end to end flow dp1.da3 -> fconn1 -> asub1.fpath2;
					--DataPort.FlowSpecification
					etef15: end to end flow dp1.fpath3 -> fconn1 -> asub1.fpath2;
					--DataPort.Subcomponent
					etef16: end to end flow dp1.asub3 -> fconn1 -> asub1.fpath2;
					
					--EventDataPort.EndToEndFlow
					etef17: end to end flow edp1.etef34 -> fconn1 -> asub1.fpath2;
					--EventDataPort.Connection
					etef18: end to end flow edp1.fconn3 -> fconn1 -> asub1.fpath2;
					--EventDataPort.DataAccess
					etef19: end to end flow edp1.da3 -> fconn1 -> asub1.fpath2;
					--EventDataPort.FlowSpecification
					etef20: end to end flow edp1.fpath3 -> fconn1 -> asub1.fpath2;
					--EventDataPort.Subcomponent
					etef21: end to end flow edp1.asub3 -> fconn1 -> asub1.fpath2;
					
					--FeatureGroup.DataAccess
					etef22: end to end flow fg1.da4 -> fconn1 -> asub1.fpath2;
					
					--Subcomponent.EndToEndFlow
					etef23: end to end flow asub1.etef33 -> fconn1 -> asub1.fpath2;
					--Subcomponent.Connection
					etef24: end to end flow asub1.fconn2 -> fconn1 -> asub1.fpath2;
					--Subcomponent.DataAccess
					etef25: end to end flow asub1.da2 -> fconn1 -> asub1.fpath2;
					--Subcomponent.FlowSpecification
					etef26: end to end flow asub1.fpath2 -> fconn1 -> asub1.fpath2;
					--Subcomponent.Subcomponent
					etef27: end to end flow asub1.asub2 -> fconn1 -> asub1.fpath2;
					
					--SubprogramCall.EndToEndFlow
					etef28: end to end flow call1.etef35 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.Connection
					etef29: end to end flow call1.fconn4 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.DataAccess
					etef30: end to end flow call1.da5 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.FlowSpecification
					etef31: end to end flow call1.fpath4 -> fconn1 -> asub1.fpath2;
					--SubprogramCall.Subcomponent
					etef32: end to end flow call1.asub4 -> fconn1 -> asub1.fpath2;
				end a1.i;
				
				abstract a2
				features
					af2: feature;
					da2: provides data access;
				flows
					fpath2: flow path af2 -> af2;
				end a2;
				
				abstract implementation a2.i
				subcomponents
					asub2: abstract a2;
				connections
					fconn2: feature asub2.af2 -> asub2.af2;
				flows
					etef33: end to end flow asub2.fpath2 -> fconn2 -> asub2.fpath2;
				end a2.i;
				
				abstract a3
				features
					da3: provides data access;
					af3: feature;
				flows
					fpath3: flow path af3 -> af3;
				end a3;
				
				abstract implementation a3.i
				subcomponents
					asub3: abstract a2;
				connections
					fconn3: feature asub3.af2 -> asub3.af2;
				flows
					etef34: end to end flow asub3.fpath2 -> fconn3 -> asub3.fpath2;
				end a3.i;
				
				feature group fgt1
				features
					da4: provides data access;
				end fgt1;
				
				subprogram subp1
				features
					param1: in parameter a3.i;
					da5: requires data access;
					af4: feature;
				flows
					fpath4: flow path af4 -> af4;
				end subp1;
				
				subprogram implementation subp1.i
				subcomponents
					asub4: abstract a3.i;
				connections
					fconn4: feature asub4.af3 -> asub4.af3;
				flows
					--Parameter.EndToEndFlow
					etef35: end to end flow param1.etef34 -> fconn4 -> asub4.fpath3;
					--Parameter.Connection
					etef36: end to end flow param1.fconn3 -> fconn4 -> asub4.fpath3;
					--Parameter.DataAccess
					etef37: end to end flow param1.da3 -> fconn4 -> asub4.fpath3;
					--Parameter.FlowSpecification
					etef38: end to end flow param1.fpath3 -> fconn4 -> asub4.fpath3;
					--Parameter.Subcomponent
					etef39: end to end flow param1.asub3 -> fconn4 -> asub4.fpath3;
				end subp1.i;
			end legalETEFlowSegmentsTypeTest;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"legalETEFlowSegmentsTypeTest".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedEndToEndFlows.get(0) => [
					"etef1".assertEquals(name)
					ownedEndToEndFlowSegments.get(1) => [
						"etef2".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Expected Connection, found End To End Flow.")
					]
				]
				ownedEndToEndFlows.get(2) => [
					"etef3".assertEquals(name)
					ownedEndToEndFlowSegments.get(1) => [
						"da1".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Expected Connection, found Data Access.")
					]
				]
				ownedEndToEndFlows.get(3) => [
					"etef4".assertEquals(name)
					ownedEndToEndFlowSegments.get(1) => [
						"fpath1".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Expected Connection, found Flow Specification.")
					]
				]
				ownedEndToEndFlows.get(4) => [
					"etef5".assertEquals(name)
					ownedEndToEndFlowSegments.get(1) => [
						"asub1".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Expected Connection, found Abstract Subcomponent.")
					]
				]
				ownedEndToEndFlows.get(6) => [
					"etef7".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"fconn1".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Illegal reference to connection 'fconn1'.  Expecting subcomponent flow or end-to-end flow reference.")
					]
				]
				ownedEndToEndFlows.get(9) => [
					"etef10".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"fpath1".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Illegal reference to 'fpath1'.  Cannot refer to a flow specification in the local classifier's namespace.")
					]
				]
				ownedEndToEndFlows.get(11) => [
					"etef12".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"etef34".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(12) => [
					"etef13".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"fconn3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(13) => [
					"etef14".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(14) => [
					"etef15".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"fpath3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn1".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the preceding subcomponent or out flow spec feature 'dp1.af3'")
					]
				]
				ownedEndToEndFlows.get(15) => [
					"etef16".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"asub3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn1".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the preceding subcomponent or out flow spec feature 'asub3'")
					]
				]
				ownedEndToEndFlows.get(16) => [
					"etef17".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"etef34".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(17) => [
					"etef18".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"fconn3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(18) => [
					"etef19".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(19) => [
					"etef20".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"fpath3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn1".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the preceding subcomponent or out flow spec feature 'edp1.af3'")
					]
				]
				ownedEndToEndFlows.get(20) => [
					"etef21".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"asub3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn1".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the preceding subcomponent or out flow spec feature 'asub3'")
					]
				]
				ownedEndToEndFlows.get(21) => [
					"etef22".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"fg1".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'feature group' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(22) => [
					"etef23".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"etef33".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "An 'end to end flow' in an 'abstract subcomponent' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(23) => [
					"etef24".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"fconn2".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "A 'feature connection' in an 'abstract subcomponent' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(24) => [
					"etef25".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "A 'data access' in an 'abstract subcomponent' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(26) => [
					"etef27".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"asub2".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "An 'abstract subcomponent' in an 'abstract subcomponent' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn1".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the preceding subcomponent or out flow spec feature 'asub2'")
					]
				]
				ownedEndToEndFlows.get(27) => [
					"etef28".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"etef35".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(28) => [
					"etef29".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"fconn4".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(29) => [
					"etef30".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"da5".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(30) => [
					"etef31".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"fpath4".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn1".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the preceding subcomponent or out flow spec feature 'call1.af4'")
					]
				]
				ownedEndToEndFlows.get(31) => [
					"etef32".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"asub4".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn1".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the preceding subcomponent or out flow spec feature 'asub4'")
					]
				]
			]
			publicSection.ownedClassifiers.get(8) as SubprogramImplementation => [
				"subp1.i".assertEquals(name)
				ownedEndToEndFlows.get(0) => [
					"etef35".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"etef34".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(1) => [
					"etef36".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"fconn3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(2) => [
					"etef37".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
					]
				]
				ownedEndToEndFlows.get(3) => [
					"etef38".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"fpath3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn4".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn4' does not match the preceding subcomponent or out flow spec feature 'param1.af3'")
					]
				]
				ownedEndToEndFlows.get(4) => [
					"etef39".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"asub3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
					]
					ownedEndToEndFlowSegments.get(1) => [
						"fconn4".assertEquals(flowElement.name)
						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn4' does not match the preceding subcomponent or out flow spec feature 'asub3'")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}