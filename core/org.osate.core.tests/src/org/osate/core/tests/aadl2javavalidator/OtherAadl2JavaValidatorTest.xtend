/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.core.tests.aadl2javavalidator

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.SubprogramImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class OtherAadl2JavaValidatorTest extends OsateTest {
	static val TEST_PROJECT_NAME = "Aadl2_Java_Validator_Test"
	
	@Before
	def setUp() {
		createProject(TEST_PROJECT_NAME, "packages")
		buildProject("Plugin_Resources", true)
		setResourceRoot("platform:/resource/" + TEST_PROJECT_NAME + "/packages")
	}
	
	@After
	def cleanUp() {
		deleteProject(TEST_PROJECT_NAME)
	}
	
	//Tests checkFlowConnectionOrder
	@Test
	def void testFlowSegmentTypes() {
		createFiles("legalFlowSegmentsTypeTest.aadl" -> '''
			package legalFlowSegmentsTypeTest
			public
				abstract a1
				features
					af1: feature;
					da1: provides data access;
					dp1: in data port a2.i;
					edp1: in event data port a2.i;
					fg1: feature group fgt1;
				flows
					fpath1: flow path af1 -> af1;
					fpath2: flow path af1 -> af1;
					fpath3: flow path af1 -> af1;
					fpath4: flow path af1 -> af1;
					fsource1: flow source af1;
					fsource2: flow source af1;
					fsource3: flow source af1;
					fsource4: flow source af1;
					fsource5: flow source af1;
					fsource6: flow source af1;
					fsource7: flow source af1;
					fsource8: flow source af1;
					fsource9: flow source af1;
					fsource10: flow source af1;
					fsource11: flow source af1;
					fsource12: flow source af1;
					fsource13: flow source af1;
					fsource14: flow source af1;
					fsource15: flow source af1;
					fsource16: flow source af1;
					fsource17: flow source af1;
					fsource18: flow source af1;
					fsource19: flow source af1;
					fsource20: flow source af1;
					fsource21: flow source af1;
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
				calls sequence1: {
					call1: subprogram subp1.i;
				};
				connections
					fconn1: feature af1 -> af1;
					fconn2: feature asub1.af2 -> af1;
				flows
					--Connection (at ConnectionFlow)
					fpath1: flow path af1 -> fconn1 -> af1;
					--DataAccess (at ConnectionFlow)
					fpath2: flow path af1 -> da1 -> af1;
					--FlowSpecification (at ConnectionFlow)
					fpath3: flow path af1 -> fpath1 -> af1;
					--Subcomponent (at ConnectionFlow)
					fpath4: flow path af1 -> asub1 -> af1;
					
					--Connection (at SubcomponentFlow)
					fsource1: flow source fconn1 -> fconn2 -> af1;
					--DataAccess (at SubcomponentFlow)
					fsource2: flow source da1 -> fconn2 -> af1;
					--FlowSpecification (at SubcomponentFlow)
					fsource3: flow source fsource1 -> fconn2 -> af1;
					--Subcomponent (at SubcomponentFlow)
					fsource4: flow source asub1 -> fconn2 -> af1;
					
					--DataPort.Connection
					fsource5: flow source dp1.fconn3 -> fconn2 -> af1;
					--DataPort.DataAccess
					fsource6: flow source dp1.da2 -> fconn2 -> af1;
					--DataPort.FlowSpecification
					fsource7: flow source dp1.fsource22 -> fconn2 -> af1;
					--DataPort.Subcomponent
					fsource8: flow source dp1.asub2 -> fconn2 -> af1;
					
					--EventDataPort.Connection
					fsource9: flow source edp1.fconn3 -> fconn2 -> af1;
					--EventDataPort.DataAccess
					fsource10: flow source edp1.da2 -> fconn2 -> af1;
					--EventDataPort.FlowSpecification
					fsource11: flow source edp1.fsource22 -> fconn2 -> af1;
					--EventDataPort.Subcomponent
					fsource12: flow source edp1.asub2 -> fconn2 -> af1;
					
					--FeatureGroup.DataAccess
					fsource13: flow source fg1.da4 -> fconn2 -> af1;
					
					--Subcomponent.Connection
					fsource14: flow source asub1.fconn3 -> fconn2 -> af1;
					--Subcomponent.DataAccess
					fsource15: flow source asub1.da2 -> fconn2 -> af1;
					--Subcomponent.FlowSpecification
					fsource16: flow source asub1.fsource22 -> fconn2 -> af1;
					--Subcomponent.Subcomponent
					fsource17: flow source asub1.asub2 -> fconn2 -> af1;
					
					--SubprogramCall.Connection
					fsource18: flow source call1.fconn4 -> fconn2 -> af1;
					--SubprogramCall.DataAccess
					fsource19: flow source call1.da3 -> fconn2 -> af1;
					--SubprogramCall.FlowSpecification
					fsource20: flow source call1.fsource23 -> fconn2 -> af1;
					--SubprogramCall.Subcomponent
					fsource21: flow source call1.asub3 -> fconn2 -> af1;
				end a1.i;
				
				abstract a2
				features
					af2: feature;
					da2: provides data access;
				flows
					fsource22: flow source af2;
				end a2;
				
				abstract implementation a2.i
				subcomponents
					asub2: abstract;
				connections
					fconn3: feature af2 -> af2;
				end a2.i;
				
				subprogram subp1
				features
					af3: feature;
					param1: in parameter a2.i;
					da3: requires data access;
				flows
					fsource23: flow source af3;
					fsource24: flow source af3;
					fsource25: flow source af3;
					fsource26: flow source af3;
				end subp1;
				
				subprogram implementation subp1.i
				subcomponents
					asub3: abstract a2;
				connections
					fconn4: feature asub3.af2 -> af3;
				flows
					--Parameter.Connection
					fsource23: flow source param1.asub2 -> fconn4 -> af3;
					--Parameter.DataAccess
					fsource24: flow source param1.da2 -> fconn4 -> af3;
					--Parameter.FlowSpecification
					fsource25: flow source param1.fsource22 -> fconn4 -> af3;
					--Parameter.Subcomponent
					fsource26: flow source param1.asub2 -> fconn4 -> af3;
				end subp1.i;
				
				feature group fgt1
				features
					da4: provides data access;
				end fgt1;
			end legalFlowSegmentsTypeTest;
		''')
		suppressSerialization
		val testFileResult = testFile("legalFlowSegmentsTypeTest.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"legalFlowSegmentsTypeTest".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFlowImplementations.get(1) => [
					"fpath2".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"da1".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Connection, found Data Access 'da1'")
					]
				]
				ownedFlowImplementations.get(2) => [
					"fpath3".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"fpath1".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Connection, found Flow Specification 'fpath1'")
					]
				]
				ownedFlowImplementations.get(3) => [
					"fpath4".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"asub1".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Connection, found Abstract Subcomponent 'asub1'")
					]
				]
				ownedFlowImplementations.get(4) => [
					"fsource1".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"fconn1".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Connection 'fconn1'")
					]
				]
				ownedFlowImplementations.get(6) => [
					"fsource3".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"fsource1".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Flow Specification 'fsource1'")
					]
				]
				ownedFlowImplementations.get(8) => [
					"fsource5".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"fconn3".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Feature Connection 'dp1.fconn3'")
					]
				]
				ownedFlowImplementations.get(9) => [
					"fsource6".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Data Access 'dp1.da2'")
					]
				]
				ownedFlowImplementations.get(10) => [
					"fsource7".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"fsource22".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Flow Specification 'dp1.fsource22'")
					]
				]
				ownedFlowImplementations.get(11) => [
					"fsource8".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"asub2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Abstract Subcomponent 'dp1.asub2'")
					]
				]
				ownedFlowImplementations.get(12) => [
					"fsource9".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"fconn3".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Feature Connection 'edp1.fconn3'")
					]
				]
				ownedFlowImplementations.get(13) => [
					"fsource10".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Data Access 'edp1.da2'")
					]
				]
				ownedFlowImplementations.get(14) => [
					"fsource11".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"fsource22".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Flow Specification 'edp1.fsource22'")
					]
				]
				ownedFlowImplementations.get(15) => [
					"fsource12".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"asub2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Abstract Subcomponent 'edp1.asub2'")
					]
				]
				ownedFlowImplementations.get(16) => [
					"fsource13".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"fg1".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Group.Data Access 'fg1.da4'")
					]
				]
				ownedFlowImplementations.get(17) => [
					"fsource14".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"fconn3".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Abstract Subcomponent.Feature Connection 'asub1.fconn3'")
					]
				]
				ownedFlowImplementations.get(18) => [
					"fsource15".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Abstract Subcomponent.Data Access 'asub1.da2'")
					]
				]
				ownedFlowImplementations.get(20) => [
					"fsource17".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"asub2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Abstract Subcomponent.Abstract Subcomponent 'asub1.asub2'")
					]
				]
				ownedFlowImplementations.get(21) => [
					"fsource18".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"fconn4".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Feature Connection 'call1.fconn4'")
					]
				]
				ownedFlowImplementations.get(22) => [
					"fsource19".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call1.da3'")
					]
				]
				ownedFlowImplementations.get(23) => [
					"fsource20".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"fsource23".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Flow Specification 'call1.fsource23'")
					]
				]
				ownedFlowImplementations.get(24) => [
					"fsource21".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"asub3".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Abstract Subcomponent 'call1.asub3'")
					]
				]
			]
			publicSection.ownedClassifiers.get(5) as SubprogramImplementation => [
				"subp1.i".assertEquals(name)
				ownedFlowImplementations.get(0) => [
					"fsource23".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"asub2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Abstract Subcomponent 'param1.asub2'")
					]
				]
				ownedFlowImplementations.get(1) => [
					"fsource24".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Data Access 'param1.da2'")
					]
				]
				ownedFlowImplementations.get(2) => [
					"fsource25".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"fsource22".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Flow Specification 'param1.fsource22'")
					]
				]
				ownedFlowImplementations.get(3) => [
					"fsource26".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"asub2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Abstract Subcomponent 'param1.asub2'")
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests typeCheckEndToEndFlowSegments
	@Test
	def void testEndToEndFlowSegmentTypes() {
		createFiles("legalETEFlowSegmentsTypeTest.aadl" -> '''
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
		''')
		suppressSerialization
		val testFileResult = testFile("legalETEFlowSegmentsTypeTest.aadl")
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
				ownedEndToEndFlows.get(8) => [
					"etef9".assertEquals(name)
					ownedEndToEndFlowSegments.get(2) => [
						"da1".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Illegal reference to 'da1'.  Cannot refer to a data access except for the first and last segment of an end-to-end flow.")
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
				]
				ownedEndToEndFlows.get(15) => [
					"etef16".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"dp1".assertEquals(context.name)
						"asub3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid subcomponent flow.")
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
				]
				ownedEndToEndFlows.get(20) => [
					"etef21".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"edp1".assertEquals(context.name)
						"asub3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid subcomponent flow.")
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
				]
				ownedEndToEndFlows.get(31) => [
					"etef32".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"asub4".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
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
				]
				ownedEndToEndFlows.get(4) => [
					"etef39".assertEquals(name)
					ownedEndToEndFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"asub3".assertEquals(flowElement.name)
						//Tests typeCheckEndToEndFlowSegments
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}