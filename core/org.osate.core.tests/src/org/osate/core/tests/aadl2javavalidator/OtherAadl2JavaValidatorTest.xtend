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

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractType
import org.osate.aadl2.BusType
import org.osate.aadl2.ComponentType
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.PropertySet
import org.osate.aadl2.SubprogramImplementation
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.SystemType
import org.osate.aadl2.UnitsType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class OtherAadl2JavaValidatorTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	//Tests checkFlowConnectionOrder
	@Test
	def void testFlowSegmentTypes() {
		val aadlText = '''
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
«««					fconn1: feature af1 -> af1;
					fconn1: feature asub1.af2 -> af1;
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
«««					asub2: abstract;
					asub2: abstract a2;
				connections
«««					fconn3: feature af2 -> af2;
					fconn3: feature asub2.af2 -> af2;
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
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"legalFlowSegmentsTypeTest".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFlowImplementations.get(0) => [
					"fpath1".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"fconn1".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn1' does not match the in flow feature 'af1'")
					]
				]
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
				ownedFlowImplementations.get(7) => [
					"fsource4".assertEquals(specification.name)
					ownedFlowSegments.get(0) => [
						"asub1".assertEquals(flowElement.name)
						//Tests checkFlowSubcomponentFlow
						assertError(testFileResult.issues, issueCollection, "Connection 'fconn2' continues inside subcomponent 'asub1'")
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
					ownedFlowSegments.get(1) => [
						"fconn2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub2'")
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
					ownedFlowSegments.get(1) => [
						"fconn2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub2'")
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
					ownedFlowSegments.get(1) => [
						"fconn2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub2'")
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
					ownedFlowSegments.get(1) => [
						"fconn2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn2' does not match the out flow feature of the preceding subcomponent flow specification 'call1.fsource23'")
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
					ownedFlowSegments.get(1) => [
						"fconn2".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub3'")
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
					ownedFlowSegments.get(1) => [
						"fconn4".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn4' does not match the preceding subcomponent 'asub2'")
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
					ownedFlowSegments.get(1) => [
						"fconn4".assertEquals(flowElement.name)
						//Tests checkFlowConnectionOrder
						assertError(testFileResult.issues, issueCollection, "The source of connection 'fconn4' does not match the preceding subcomponent 'asub2'")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests typeCheckModeTransitionTrigger
	@Test
	def void testModeTransitionTriggerTypes() {
		val aadlText = '''
			package legalTypeTest
			public
				abstract a1
				features
					af1: feature;
					dp1: in data port a2.i;
					edp1: in event data port a2.i;
					fg1: feature group fgt1;
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
				internal features
					es1: event;
				processor features
					pp1: port;
				calls sequence1: {
					call1: subprogram subp1.i;
				};
				modes
					m1: initial mode;
					m2: mode;
					mt1: m1 -[
						--AbstractFeature
						af1,
						--InternalFeature
						self.es1,
						--Port
						dp1,
						--PortProxy
						processor.pp1,
						
						--DataPort.AbstractFeature
						dp1.af2,
						--DataPort.InternalFeature
						dp1.es2,
						--DataPort.Port
						dp1.ep1,
						--DataPort.PortProxy
						dp1.pp2,
						
						--EventDataPort.AbstractFeature
						edp1.af2,
						--EventDataPort.InternalFeature
						edp1.es2,
						--EventDataPort.Port
						edp1.ep1,
						--EventDataPort.PortProxy
						edp1.pp2,
						
						--FeatureGroup.AbstractFeature
						fg1.af3,
						--FeatureGroup.Port
						fg1.ep2,
						
						--Subcomponent.AbstractFeature
						asub1.af2,
						--Subcomponent.InternalFeature
						asub1.es2,
						--Subcomponent.Port
						asub1.ep1,
						--Subcomponent.PortProxy
						asub1.pp2,
						
						--SubprogramCall.AbstractFeature
						call1.af4,
						--SubprogramCall.InternalFeature
						call1.es3,
						--SubprogramCall.Port
						call1.ep3,
						--SubprogramCall.PortProxy
						call1.pp3
					]-> m2;
				end a1.i;
				
				abstract a2
				features
					af2: feature;
					ep1: in event port;
				end a2;
				
				abstract implementation a2.i
				internal features
					es2: event;
				processor features
					pp2: port;
				end a2.i;
				
				feature group fgt1
				features
					af3: feature;
					ep2: in event port;
				end fgt1;
				
				subprogram subp1
				features
					af4: feature;
					ep3: out event port;
					param1: in parameter a2.i;
				end subp1;
				
				subprogram implementation subp1.i
				internal features
					es3: event;
				processor features
					pp3: port;
				modes
					m3: initial mode;
					m4: mode;
					mt2: m3 -[
						--Parameter.AbstractFeature
						param1.af2,
						--Parameter.InternalFeature
						param1.es2,
						--Parameter.Port
						param1.ep1,
						--Parameter.PortProxy
						param1.pp2
					]-> m4;
				end subp1.i;
			end legalTypeTest;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"legalTypeTest".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedModeTransitions.head => [
					"mt1".assertEquals(name)
					ownedTriggers.get(4) => [
						"dp1".assertEquals(context.name)
						"af2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(5) => [
						"dp1".assertEquals(context.name)
						"es2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(6) => [
						"dp1".assertEquals(context.name)
						"ep1".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(7) => [
						"dp1".assertEquals(context.name)
						"pp2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(8) => [
						"edp1".assertEquals(context.name)
						"af2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(9) => [
						"edp1".assertEquals(context.name)
						"es2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(10) => [
						"edp1".assertEquals(context.name)
						"ep1".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(11) => [
						"edp1".assertEquals(context.name)
						"pp2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(15) => [
						"asub1".assertEquals(context.name)
						"es2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "An 'event source' in Abstract Subcomponent is not a valid mode transition trigger.")
					]
					ownedTriggers.get(17) => [
						"asub1".assertEquals(context.name)
						"pp2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "A 'port proxy' in Abstract Subcomponent is not a valid mode transition trigger.")
					]
					ownedTriggers.get(19) => [
						"call1".assertEquals(context.name)
						"es3".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "An 'event source' in Subprogram Call is not a valid mode transition trigger.")
					]
					ownedTriggers.get(21) => [
						"call1".assertEquals(context.name)
						"pp3".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "A 'port proxy' in Subprogram Call is not a valid mode transition trigger.")
					]
				]
			]
			publicSection.ownedClassifiers.get(6) as SubprogramImplementation => [
				"subp1.i".assertEquals(name)
				ownedModeTransitions.head => [
					"mt2".assertEquals(name)
					ownedTriggers.get(0) => [
						"param1".assertEquals(context.name)
						"af2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(1) => [
						"param1".assertEquals(context.name)
						"es2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(2) => [
						"param1".assertEquals(context.name)
						"ep1".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid mode transition trigger.")
					]
					ownedTriggers.get(3) => [
						"param1".assertEquals(context.name)
						"pp2".assertEquals(triggerPort.name)
						//Tests typeCheckModeTransitionTrigger
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid mode transition trigger.")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests caseUnitLiteral
	@Test
	def void testUnitLiterals() {
		val aadlText = '''
			property set ps is
				ut1: type units (ul1, ul2 => ul1 * 10, ul3 => ul4 * 10, ul4 => ul4 * 10);
			end ps;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as PropertySet => [
			"ps".assertEquals(name)
			ownedPropertyTypes.head as UnitsType => [
				"ut1".assertEquals(name)
				ownedLiterals.get(2) => [
					"ul3".assertEquals(name)
					//Tests caseUnitLiteral
					assertError(testFileResult.issues, issueCollection, "'ul4' is not declared before 'ul3'")
				]
				ownedLiterals.get(3) => [
					"ul4".assertEquals(name)
					//Tests caseUnitLiteral
					assertError(testFileResult.issues, issueCollection, "'ul4' cannot be its own base unit")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests checkArraySizeIsAadlintegerNoUnits
	@Test
	def void testArraySizeIsAadlintegerNoUnits() {
		val aadlText = '''
			package testArraySize
			public
			  abstract a
			  features
			    p: in data port [Max_Time];
			  end a;
			end testArraySize;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"testArraySize".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"a".assertEquals(name)
				ownedDataPorts.get(0) => [
					"p".assertEquals(name)
					arrayDimensions.head.size.assertError(testFileResult.issues, issueCollection, "Array size should only be an Integer type with no units")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests for duplicate elements ignoring case
	@Test
	def void testDuplicateElementIgnoreCase() {
		val aadlText = '''
			package duplicateTest
			public
				bus b
				end b;
				bus B
				end B;
			end duplicateTest;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"duplicateTest".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as BusType => [
				"b".assertEquals(name)
				assertError(testFileResult.issues, issueCollection, "Duplicate Element 'b' in PublicPackageSection 'duplicateTest_public'")
			]
			publicSection.ownedClassifiers.get(1) as BusType => [
				"B".assertEquals(name)
				assertError(testFileResult.issues, issueCollection, "Duplicate Element 'B' in PublicPackageSection 'duplicateTest_public'")
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests for validating references to internal features and processor features 
	@Test
	def void testCheckReferencesToInternalFeatures() {
		val aadlText = '''
			package pkgTestInternalProcessorFeatures
			public
				abstract a
				end a;
				abstract a2
					features
						dp2: in data port;
				end a2;
				abstract implementation a.i
					subcomponents
						asub1: abstract a2;
					internal features
						eds1: event data;
					processor features
						pp1: port;
					connections
					--Correct
						conn1: port self.eds1 -> asub1.dp2;
					--Should be marked with an error
						conn2: port processor.eds1 -> asub1.dp2;
					--Correct
						conn3: port processor.pp1 -> asub1.dp2;
					--Should be marked with an error
						conn4: port self.pp1 -> asub1.dp2;
				end a.i;
			end pkgTestInternalProcessorFeatures;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkgTestInternalProcessorFeatures".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as AbstractImplementation => [
				"a.i".assertEquals(name)
				//checkReferencesToInternalFeatures
				ownedConnections.get(1) =>[
					"conn2".assertEquals(name)
					source.assertError(testFileResult.issues, issueCollection, "Only processor features may follow the keyword 'processor'") 
				]
				//checkReferencesToInternalFeatures
				ownedConnections.get(3) =>[
					"conn4".assertEquals(name)
					source.assertError(testFileResult.issues, issueCollection, "Only internal features may follow the keyword 'self'") 
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests for validation for ComponentImplementationReference list 
	@Test
	def void testCheckSubcomponentImplementationReferenceList() {
		val aadlText1 = '''
		property set ps2 is
			const1: constant aadlinteger => 2 ; 
		end ps2;
		'''
		val aadlText = '''
		package testcompimplreflist
		public
			with ps2;
			abstract a
			end a;
			abstract implementation a.i1
				subcomponents
					bsub0: bus b2[2] (b2.i, b2.i);
					bsub1: bus b2[2] (b2.i, b2.i, b2.i);
					bsub2: bus b2.i[2] (b2.i, b2.i);
					bsub3: bus b2[ps2::const1] (b2.i, b2.i);
					bsub4: bus b2[2] (b1.i, b2.i);
			end a.i1;
			bus b1
			end b1;
			bus implementation b1.i
			end b1.i;
			bus b2
			end b2;
			bus implementation b2.i
			end b2.i;
		end TestCompImplRefList;
		'''
		val testFileResult = issues = testHelper.testString(aadlText, aadlText1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		// checkSubcomponentImplementationReferenceList
		testFileResult.resource.contents.head as AadlPackage => [
			"testcompimplreflist".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a.i1".assertEquals(name)
				ownedBusSubcomponents.head =>[
					"bsub0".assertEquals(name)
					assertWarning(testFileResult.issues, issueCollection, "List of implementation reference not fully implemented in instantiator.") 
				]
				ownedBusSubcomponents.get(1) =>[
					"bsub1".assertEquals(name)
					assertWarning(testFileResult.issues, issueCollection, "List of implementation reference not fully implemented in instantiator.") 
					assertError(testFileResult.issues, issueCollection, "Size of component implementation reference list not the same as array size.") 
				]
				ownedBusSubcomponents.get(2) =>[
					"bsub2".assertEquals(name)
					assertWarning(testFileResult.issues, issueCollection, "List of implementation reference not fully implemented in instantiator.") 
					assertError(testFileResult.issues, issueCollection, "Implementation reference list not allowed when the subcomponent classifier is not a component type.") 
				]
				ownedBusSubcomponents.get(3) =>[
					"bsub3".assertEquals(name)
					assertWarning(testFileResult.issues, issueCollection, "List of implementation reference not fully implemented in instantiator.") 
//	became a constant				arrayDimensions.head.assertError(testFileResult.issues, issueCollection, "Array size cannot be a property if implementation reference list is defined.") 
				]
				ownedBusSubcomponents.get(4) =>[
					"bsub4".assertEquals(name)
					assertWarning(testFileResult.issues, issueCollection, "List of implementation reference not fully implemented in instantiator.") 
					implementationReferences.head.assertError(testFileResult.issues, issueCollection, "Implementation reference not of the specified type.") 
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests validation of feature group type declared as inverse
	@Test
	def void testCheckFeaturesInInverseFeatureGroupType() {
		val aadlText = '''
			package testfeaturegroupinverse
			public
				feature group fg1
					features
						b1: requires bus access mybus;
						d1: out data port;
				end fg1;
				feature group fg2
					features
						b2: requires bus access mybus;
						d2: out data port;
					inverse of fg1
				end fg2;
				feature group fg3
					features
						b3: provides bus access mybus;
						d3: in data port;
						d4: in data port;
					inverse of fg1
				end fg3;
				feature group fg4
					inverse of fg1
				end fg4;
				bus mybus
				end mybus;
			end testfeaturegroupinverse;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		// checkSubcomponentImplementationReferenceList
		testFileResult.resource.contents.head as AadlPackage => [
			"testfeaturegroupinverse".assertEquals(name)
			publicSection.ownedElements.get(1) as FeatureGroupType => [
				"fg2".assertEquals(name)
				ownedBusAccesses.head =>[
					"b2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Feature Group feature access kind is same as that of its inverse")
				]
				ownedDataPorts.head =>[
					"d2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Feature Group feature direction not opposite that of its inverse")
				]
			]
			publicSection.ownedElements.get(2) as FeatureGroupType => [
				"fg3".assertEquals(name)
				assertError(testFileResult.issues, issueCollection, "Feature Group features list count differs from that of its inverse")
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests validation of ModalElement missing mode values
	@Test
	def void testCheckModalElementMissingModeValues() {
		val aadlText1 = '''
			property set psmemmv is
				def1: aadlstring => 'z' applies to (all);
			end psmemmv;	
		'''
		val aadlText = '''
			package testmemissingmodevalues
			public
				with psmemmv;
				system s1
					features
						af1 : feature;
						af2 : feature;
					modes
						m1: initial mode;
						m2: mode;
						m3: mode;
				end s1;
				system implementation s1.i
					subcomponents
						asub1: abstract a1;
					connections
«««						conn1: feature af1->af2 {psmemmv::def1 => "g" in modes(m3);} in modes(m1, m2);
						conn1: feature asub1.af3->af2 {psmemmv::def1 => "g" in modes(m3);} in modes(m1, m2);
«««						conn2: feature af1->af2 {psmemmv::def1 => "g" in modes(m1);} in modes(m1, m2);
						conn2: feature asub1.af3->af2 {psmemmv::def1 => "g" in modes(m1);} in modes(m1, m2);
«««						conn3: feature af1->af2 {psmemmv::def1 => "g" in modes(m1); };
						conn3: feature asub1.af3->af2 {psmemmv::def1 => "g" in modes(m1); };
				end s1.i;
				abstract a1
					features
						af3: feature;
				end a1;
			end testmemissingmodevalues;
		'''
		val testFileResult = issues = testHelper.testString(aadlText, aadlText1)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"testmemissingmodevalues".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as SystemImplementation => [
				"s1.i".assertEquals(name)
				ownedConnections.head => [
					"conn1".assertEquals(name)
					ownedPropertyAssociations.head =>[
						ownedValues.head => [
						assertError(testFileResult.issues, issueCollection, 
									"m3 is not a valid mode because it is not in the modes defined for container conn1")
							
						] 
					]
				]
				ownedConnections.get(1) => [
					"conn2".assertEquals(name)
					ownedPropertyAssociations.head =>[
						assertWarning(testFileResult.issues, issueCollection, 
									"Value not set for mode m2 for property psmemmv::def1")
					]
				]
				ownedConnections.get(2) => [
					"conn3".assertEquals(name)
					ownedPropertyAssociations.head =>[
						assertWarning(testFileResult.issues, issueCollection, 
									"Value not set for mode m2 for property psmemmv::def1","Value not set for mode m3 for property psmemmv::def1")
					]
				]
			]
		]			
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests validation of flow implementation in and out complies with specification 
	@Test
	def void testCheckFlowPathElements() {
		val aadlText = '''
			package testCheckFlowPathElements
			public
				system implementation S.i
				  subcomponents
				    s1: system s;
				    s2: system s;
				  connections
				    c1: feature group s1.fg_out -> s2.fg_in;
					flows
						fl1: flow path fg_in.p -> fg_out.p;
						fl2: flow path fg_in -> fg_out;
						fl3: flow path fg_in.p -> fg_out.p;
				end S.i;
				feature group fg
					features
						p: in data port;
				end fg;
				system s
					features
						fg_in: feature group fg;
						fg_out: feature group inverse of fg;
					flows
						fl1: flow path fg_in -> fg_out;
						fl2: flow path fg_in -> fg_out;
						fl3: flow path fg_in.p -> fg_out.p ;
					end s;
			end testCheckFlowPathElements;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		// checkFlowPathElements
		testFileResult.resource.contents.head as AadlPackage => [
			"testCheckFlowPathElements".assertEquals(name)
			publicSection.ownedClassifiers.head as SystemImplementation => [
				"S.i".assertEquals(name)
				ownedFlowImplementations.get(1) => [
					"fl2".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
				ownedFlowImplementations.get(2) => [
					"fl3".assertEquals(specification.name)
					assertWarning(testFileResult.issues, issueCollection, "Flow implementation is empty and does not add value to the model")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests validation of FeatureGroup Connections 
	//particularly when feature groups are inverted features  
	@Test
	def void testCheckFeatureGroupConnectionDirection() {
		val aadlText = '''
						package testfgconndirection
						public
							-- Feature group with the data port.
							feature group fgA
								features
									o1: out data port;
							end fgA;
							-- Nested feature group.
							feature group fgB
								features
									fg1: feature group fgA;
							end fgB;
							-- Sender system.
							system sys1
								features
									o: feature group fgB;
							end sys1;
							-- Receiver system.
							system sys2
								features
									i: feature group inverse of fgB;
							end sys2;
							-- Inner system in receiver system that receives nested feature group.
							system inner
								features
									fg1: feature group inverse of fgA;
							end inner;
							-- Implementation of the receiver system.
							system implementation sys2.i
								subcomponents
									inner: system inner;
								connections
									c1: feature group i.fg1 -> inner.fg1; -- works
									c2: feature group inner.fg1 -> i.fg1; -- should fail.
									c3: feature group i.fg1 <-> inner.fg1; -- works.
							end sys2.i;
							-- Top-level to tie everything together.
							system top
							end top;
							system implementation top.i
								subcomponents
									s1: system sys1;
									s2: system sys2.i;
								connections
									tt: feature group s1.o -> s2.i;
							end top.i;
						end testfgconndirection;
						'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		// checkFeatureGroupConnectionDirection
		testFileResult.resource.contents.head as AadlPackage => [
			"testfgconndirection".assertEquals(name)
			publicSection.ownedClassifiers.get(5) as SystemImplementation => [
				"sys2.i".assertEquals(name)
				ownedConnections.get(1) => [
					"c2".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, 
										"Feature inner.fg1.o1 must not be in due to the direction of the connection"
										, "Feature i.fg1.o1 must not be in due to the direction of the connection")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests validation of ComponentType Features and Prototypes including where refinement is used 
	@Test
	def void testCheckComponentTypeUniqueNames() {
		val aadlText = '''
					package testtypeuniquenames
					public
						system s1
							prototypes
								dp7: in feature;
								dp12: in feature;
							features
								af1: feature;
								dp2: in data port;
								dp3: in data port;
								dp4: feature;
								dp5: feature;
								dp6: in event port;
								dp10: in data port;
								dp11: in data port;
								dp13: in data port;
							flows
								fsource1: flow source af1;
							modes
								m1: initial mode;
						end s1;
						system s2 extends s1
							prototypes
								dp1: in feature;
								dp7: in feature;
								dp11: feature;
							features
								dp1: in feature;
								dp2: in data port;
								dp3: refined to in data port;
								dp4: in data port;
								dp5: refined to in data port;
								dp6: in data port;
								dp12: in data port;
								dp13: refined to in data port;
							flows
								fsource1: flow source af1;
							modes
								m1 : mode;
						end s2;
						system s3 extends s2
						end s3;
						system s4 extends s3
							features
								dp3: in data port;
								dp13: refined to in data port;
								dp10: in data port;
						end s4;
					end testtypeuniquenames;
					'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"testtypeuniquenames".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as ComponentType => [
				"s2".assertEquals(name)
				ownedPrototypes.head => [
					"dp1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'dp1' in s2")
				]
				ownedPrototypes.get(1) => [
					"dp7".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "FeaturePrototype identifier 'dp7' previously defined in s1. Maybe you forgot 'refined to'")
				]
				ownedPrototypes.get(2) => [
					"dp11".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp11' previously defined in s1")
				]
				ownedModes.head => [
					"m1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Mode identifier 'm1' previously defined.")
				]
				ownedFlowSpecifications.head => [
					"fsource1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "FlowSpecification identifier 'fsource1' previously defined. Maybe you forgot 'refined to'")
				]
				ownedFeatures.head => [
					"dp1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'dp1' in s2")
				]
				ownedFeatures.get(1) => [
					"dp2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp2' previously defined in s1. Maybe you forgot 'refined to'")
				]
				ownedFeatures.get(3) => [
					"dp4".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp4' previously defined in s1. Maybe you forgot 'refined to'")
				]
				ownedFeatures.get(5) => [
					"dp6".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "EventPort identifier 'dp6' previously defined in s1")
				]
				ownedFeatures.get(6) => [
					"dp12".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "FeaturePrototype identifier 'dp12' previously defined in s1")
				]
			]
			
			publicSection.ownedClassifiers.get(3) as ComponentType => [
				"s4".assertEquals(name)
				ownedFeatures.head => [
					"dp3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp3' previously defined in s2. Maybe you forgot 'refined to'")
				]
				ownedFeatures.get(2) => [
					"dp10".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp10' previously defined in s1. Maybe you forgot 'refined to'")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests validation of ComponentType Features and Prototypes including where refinement is used 
	@Test
	def void testCheckFeatureGroupTypeUniqueNames() {
		val aadlText = '''
						package testfguniquenames
						public
							feature group fg1
								prototypes
									af11: feature;
									dp12: in feature;
								features
									dp2: in data port;
									dp3: in data port;
									dp4: feature;
									dp5: feature;
									dp6: in event port;
									dp10: in data port;
									dp11: feature;
									dp13: in data port;
							end fg1;
							feature group fg2 extends fg1
								prototypes
									af11: feature;
									dp11: feature;
								features
									dp1: in data port;
									dp1: in data port;
									dp2: in data port ;
									dp3: refined to in data port;
									dp4: in data port;
									dp5: refined to in data port;
									dp6: in data port;
									dp12: in data port;
									dp13: refined to in data port;
							end fg2;
							feature group fg3 extends fg2
							end fg3;
							feature group fg4 extends fg3
						 		features
						 			dp3: in data port;
						 			dp10: in data port;
							end fg4;
						end testfguniquenames;
					'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"testfguniquenames".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as FeatureGroupType => [
				"fg2".assertEquals(name)
				ownedPrototypes.head => [
					"af11".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "FeaturePrototype identifier 'af11' previously defined in fg1. Maybe you forgot 'refined to'")
				]
				ownedPrototypes.get(1) => [
					"dp11".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "AbstractFeature identifier 'dp11' previously defined in fg1")
				]
				ownedFeatures.head => [
					"dp1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'dp1' in fg2")
				]
				ownedFeatures.get(1) => [
					"dp1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'dp1' in fg2")
				]
				ownedFeatures.get(2) => [
					"dp2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp2' previously defined in fg1. Maybe you forgot 'refined to'")
				]
				ownedFeatures.get(4) => [
					"dp4".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp4' previously defined in fg1. Maybe you forgot 'refined to'")
				]
				ownedFeatures.get(6) => [
					"dp6".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "EventPort identifier 'dp6' previously defined in fg1")
				]
				ownedFeatures.get(7) => [
					"dp12".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "FeaturePrototype identifier 'dp12' previously defined in fg1")
				]
			]
			
			publicSection.ownedClassifiers.get(3) as FeatureGroupType => [
				"fg4".assertEquals(name)
				ownedFeatures.head => [
					"dp3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp3' previously defined in fg2. Maybe you forgot 'refined to'")
				]
				ownedFeatures.get(1) => [
					"dp10".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "DataPort identifier 'dp10' previously defined in fg1. Maybe you forgot 'refined to'")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	//Tests validation of ComponentImplementation elements for unique names
	@Test
	def void testCheckComponentImplementationUniqueNames() {
		val aadlText = '''
						package componentimpluniquenames
							public
								abstract ab1 extends ab0
									prototypes
										dp3: data;
										dp4: data;
									features
										dp1: in data port; 
										dp2: out data port;
										dp99: out data port;
										name1: feature;
								end ab1;
								abstract ab0
									features
										m1: in data port; 
								end ab0;
								abstract implementation ab0.i1
									modes
										m1: initial mode;
								end ab0.i1;
								abstract implementation ab1.i1 extends ab0.i1
									prototypes
										dp3: data;
										dp4: refined to data;
										conn3: data;
									subcomponents
										m1: abstract ab1;
										absub1: abstract ab1;
										absub2: abstract ab1;
										absub99: abstract ab99;
									connections
										conn1: port absub99.dp101 -> dp2;
										conn2: port absub99.dp101 -> dp2;
										conn4: port absub99.dp101 -> dp2;
									modes
										m6:	mode;
										m7:	mode;
										mt1: m6 -[name1]-> m7;
								end ab1.i1;	
								abstract implementation ab1.i2 extends ab1.i1
									prototypes
										dup1: data;
										dup1: data;
										dp3: data;
										dp4: refined to data;
										dp99: data;
										mt1: data;
									subcomponents
										absub1: abstract ab1;
										absub2: refined to abstract ab1;
										name1: abstract ab1;
										name10: abstract ab1;
									connections
										conn1: port absub99.dp101 -> dp2;
										conn2: refined to port {Latency => 10ms..100ms;};
										conn3: port absub99.dp101 -> dp2;
										conn4: refined to port;
									modes
										m5:	mode;
										m10: mode;
										m11: mode;
										mt10: m10 -[dp1]-> m11;
										mt11: m10 -[dp1]-> m11;
								end ab1.i2;	
								abstract implementation ab1.i3 extends ab1.i2
									prototypes
										dp3: data;
										dp4: refined to data;
										mt11: data;
									subcomponents
										absub1: abstract ab1;
										absub2: refined to abstract ab1;
									connections
										conn1: port absub99.dp101 -> dp2;
										conn4: port absub99.dp101 -> dp2 ;
										conn2: refined to port {Latency => 10ms..100ms;};
									modes
										m5:	mode;
										mt10: m10 -[dp1]-> m11;
										mt12: m10 -[dp1]-> m11; 
								end ab1.i3;	
								system s1
								end s1;
								system implementation s1.i1
									subcomponents
										sub50: subprogram;
								end s1.i1;
								subprogram subprog1
								end subprog1;
								subprogram subprog2
								end subprog2;
								subprogram implementation subprog2.spi2
								end subprog2.spi2;
								subprogram implementation subprog1.spi1
									subcomponents
										dupename7 : data;
									calls
										callseq1:{
											callspi2: subprogram subprog2.spi2;
											callspi2: subprogram subprog2.spi2;
											callspi3: subprogram subprog2.spi2;
										};
										callseq2:{
											callspi3: subprogram subprog2.spi2;
										};
										callseq3:{
											callspi4: subprogram subprog2.spi2;
										};
										callseq3:{
											callspi5: subprogram subprog2.spi2;
										};
										callseq4:{
											callspi6: subprogram subprog2.spi2;
										};
								end subprog1.spi1;
								subprogram implementation subprog1.spi3 extends subprog1.spi1
									calls
										callseq5: {
											-- callspi6 previously defined
											callspi6: subprogram subprog2.spi2;
											-- dupename7 name was used for subcomponent in subprog1.spi1
											dupename7: subprogram subprog2.spi2; 
											-- callspi8 ok
											callspi8: subprogram subprog2.spi2;
										};
								end subprog1.spi3;
								device dev1
									features
										event102: out event data port;
									flows
										flow102: flow source event102;
								end dev1;
								system sys101
									features
										portA: in event data port;
										portB: out event data port;
									flows
										flow101: flow path portA -> portB;
								end sys101;
								system sys100
								end sys100;
								system implementation sys100.impl1
									subcomponents
										dev1: device dev1;
										sys101: system sys101;
									connections
										c1: port dev1.event102 -> sys101.portA;
									flows
										ete1 : end to end flow dev1.flow102 -> C1 -> sys101.flow101;
										ete2 : end to end flow dev1.flow102 -> C1 -> sys101.flow101;
								end sys100.impl1;
								system implementation sys100.impl2 extends sys100.impl1
									subcomponents
									-- ete1 previously used for end to end flow
									ete1: device dev1;
								flows
									-- ete2 already defined
									ete2 : end to end flow dev1.flow102 -> C1 -> sys101.flow101;
									-- ete3 duplicate
									ete3 : end to end flow dev1.flow102 -> C1 -> sys101.flow101;
									ete3 : end to end flow dev1.flow102 -> C1 -> sys101.flow101;
									-- ete4 ok
									ete4 : end to end flow dev1.flow102 -> C1 -> sys101.flow101;
							end sys100.impl2;
							abstract ab99
								features
									dp101: out data port;
									dp102: out data port;
							end ab99;
						end componentimpluniquenames;
						'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		
		testFileResult.resource.contents.head as AadlPackage => [
			"componentimpluniquenames".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as AbstractImplementation => [
				"ab0.i1".assertEquals(name)
				ownedModes.head => [
					"m1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Identifier 'm1' has previously been defined in 'componentimpluniquenames::ab0'")
				]
			]
			publicSection.ownedClassifiers.get(3) as AbstractImplementation => [
				"ab1.i1".assertEquals(name)
				ownedPrototypes.head => [
					"dp3".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "DataPrototype identifier 'dp3' previously defined in ab1. Maybe you forgot 'refined to'")
				]
				ownedSubcomponents.head => [
					"m1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Identifier 'm1' has previously been defined in 'componentimpluniquenames::ab0'")
				]
			]
			publicSection.ownedClassifiers.get(4) as AbstractImplementation => [
				"ab1.i2".assertEquals(name)
				ownedPrototypes.head => [
					"dup1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'dup1' in ab1.i2")
				]
				ownedPrototypes.get(1) => [
					"dup1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'dup1' in ab1.i2")
				]
				ownedPrototypes.get(2) => [
					"dp3".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "DataPrototype identifier 'dp3' previously defined in ab1. Maybe you forgot 'refined to'")
				]
				ownedPrototypes.get(4) => [
					"dp99".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Identifier 'dp99' has previously been defined in 'componentimpluniquenames::ab1'")
				]
				ownedPrototypes.get(5) => [
					"mt1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Identifier 'mt1' has previously been defined in 'componentimpluniquenames::ab1.i1'")
				]
				ownedSubcomponents.head => [
					"absub1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "AbstractSubcomponent identifier 'absub1' previously defined in ab1.i1. Maybe you forgot 'refined to'")
				]
				ownedSubcomponents.get(2) => [
					"name1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Identifier 'name1' has previously been defined in 'componentimpluniquenames::ab1'")
				]
				ownedConnections.head => [
					"conn1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Connection 'conn1' has previously been defined in 'componentimpluniquenames::ab1.i1'. Maybe you forgot 'refined to'")
				]
				ownedConnections.get(2) => [
					"conn3".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Identifier 'conn3' has previously been defined in 'componentimpluniquenames::ab1.i1'")
				]
			]
			publicSection.ownedClassifiers.get(5) as AbstractImplementation => [
				"ab1.i3".assertEquals(name)
				ownedPrototypes.head => [
					"dp3".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "DataPrototype identifier 'dp3' previously defined in ab1. Maybe you forgot 'refined to'")
				]
				ownedPrototypes.get(2) => [
					"mt11".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Identifier 'mt11' has previously been defined in 'componentimpluniquenames::ab1.i2'")
				]
				ownedSubcomponents.head => [
					"absub1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "AbstractSubcomponent identifier 'absub1' previously defined in ab1.i2. Maybe you forgot 'refined to'")
				]
				ownedConnections.head => [
					"conn1".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Connection 'conn1' has previously been defined in 'componentimpluniquenames::ab1.i2'. Maybe you forgot 'refined to'")
				]
				ownedConnections.get(1) => [
					"conn4".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Connection 'conn4' has previously been defined in 'componentimpluniquenames::ab1.i2'. Maybe you forgot 'refined to'")
				]
				ownedModes.head => [
					"m5".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Mode 'm5' has previously been defined in 'componentimpluniquenames::ab1.i2'")
				]
				ownedModeTransitions.head => [
					"mt10".assertEquals(name);
					assertError(testFileResult.issues, issueCollection, "Mode Transition 'mt10' has previously been defined in 'componentimpluniquenames::ab1.i2'")
				]
			]
			
			publicSection.ownedClassifiers.get(11) as SubprogramImplementation => [
				"subprog1.spi1".assertEquals(name)
				ownedSubprogramCallSequences.head => [
					"callseq1".assertEquals(name);
					ownedSubprogramCalls.head => [
						"callspi2".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'callspi2' in subprog1.spi1")
					]
					ownedSubprogramCalls.get(1) => [
						"callspi2".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'callspi2' in subprog1.spi1")
					]
					ownedSubprogramCalls.get(2) => [
						"callspi3".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'callspi3' in subprog1.spi1")
					]
				]
				ownedSubprogramCallSequences.get(1) => [
					"callseq2".assertEquals(name);
					ownedSubprogramCalls.head => [
						"callspi3".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'callspi3' in subprog1.spi1")
					]
				]
				ownedSubprogramCallSequences.get(2) => [
					"callseq3".assertEquals(name);
						assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'callseq3' in subprog1.spi1")
				]
				ownedSubprogramCallSequences.get(3) => [
					"callseq3".assertEquals(name);
						assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'callseq3' in subprog1.spi1")
				]
			]

			publicSection.ownedClassifiers.get(12) as SubprogramImplementation => [
				"subprog1.spi3".assertEquals(name)
				ownedSubprogramCallSequences.head => [
					"callseq5".assertEquals(name);
					ownedSubprogramCalls.head => [
						"callspi6".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Identifier 'callspi6' has previously been defined in 'componentimpluniquenames::subprog1.spi1'")
					]
					ownedSubprogramCalls.get(1) => [
						"dupename7".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Identifier 'dupename7' has previously been defined in 'componentimpluniquenames::subprog1.spi1'")
					]
				]
			]

			publicSection.ownedClassifiers.get(17) as SystemImplementation => [
				"sys100.impl2".assertEquals(name)
				ownedSubcomponents.head => [
					"ete1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Identifier 'ete1' has previously been defined in 'componentimpluniquenames::sys100.impl1'")
				]
				ownedEndToEndFlows.head => [
					"ete2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "End to end flow 'ete2' has previously been defined in 'componentimpluniquenames::sys100.impl1'. Maybe you forgot 'refined to'")
				]
				ownedEndToEndFlows.get(1) => [
					"ete3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'ete3' in sys100.impl2")
				]
				ownedEndToEndFlows.get(2) => [
					"ete3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Duplicate identifiers 'ete3' in sys100.impl2")
				]
			]
		]

		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests checkComponentTypeModes(ComponentType)
	@Test
	def void testCheckComponentTypeModes() {
		val aadlText = '''
			package check_component_type_modes_test
			public
				system s1
					--Error: no initial modes.
					modes
						m1: mode;
				end s1;
				
				system s2
					--Error: too many initial modes.
					modes
						m2: initial mode;
						m3: initial mode;
				end s2;
				
				system s3
					requires modes
						m4: mode;
				end s3;
				
				system s4 extends s3
					--Error: inherits requires modes.
					modes
						m5: mode;
				end s4;
				
				system s5
					modes
						m6: initial mode;
				end s5;
				
				system s6 extends s5
					modes
						--Error: inherits initial mode.
						m7: initial mode;
				end s6;
				
				system s7 extends s5
					--Error: inherits modes.
					requires modes
						m8: mode;
				end s7;
				
				system s8
					requires modes
						--Error: initial requires mode.
						m9: initial mode;
				end s8;
			end check_component_type_modes_test;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"check_component_type_modes_test".assertEquals(name)
			publicSection => [
				ownedClassifiers.get(0) => [
					"s1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "One mode must be initial.")
				]
				ownedClassifiers.get(1) => [
					"s2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Only one mode can be initial.")
				]
				ownedClassifiers.get(3) => [
					"s4".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Must be requires modes because requires modes are inherited.")
				]
				ownedClassifiers.get(5) as SystemType => [
					"s6".assertEquals(name)
					ownedModes.head => [
						"m7".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Initial mode not allowed because the initial mode is inherited.")
					]
				]
				ownedClassifiers.get(6) => [
					"s7".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Must be modes because modes are inherited.")
				]
				ownedClassifiers.get(7) as SystemType => [
					"s8".assertEquals(name)
					ownedModes.head => [
						"m9".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Initial mode not allowed for requires modes.")
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	//Tests checkComponentImplementationModes(ComponentImplementation)
	@Test
	def void testCheckComponentImplementationModes() {
		val aadlText = '''
			package check_component_implementation_modes_test
			public
				system s1
					requires modes
						m1: mode;
				end s1;
				
				system implementation s1.i1
					--Error: type has requires modes.
					modes
						m2: mode;
				end s1.i1;
				
				system s2
					modes
						m3: initial mode;
				end s2;
				
				system implementation s2.i1
					modes
						--Error: type has modes.
						m4: mode;
				end s2.i1;
				
				system s3
				end s3;
				
				system implementation s3.i1
					modes
						m5: initial mode;
				end s3.i1;
				
				system implementation s3.i2 extends s3.i1
					modes
						--Error: inherited initial mode.
						m6: initial mode;
				end s3.i2;
				
				system implementation s3.i3
					--Error: no initial modes.
					modes
						m7: mode;
				end s3.i3;
				
				system implementation s3.i4
					--Error: too many initial modes.
					modes
						m8: initial mode;
						m9: initial mode;
				end s3.i4;
			end check_component_implementation_modes_test;
		'''
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"check_component_implementation_modes_test".assertEquals(name)
			publicSection => [
				ownedClassifiers.get(1) => [
					"s1.i1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Modes subclause not allowed because type has requires modes.")
				]
				ownedClassifiers.get(3) as SystemImplementation => [
					"s2.i1".assertEquals(name)
					ownedModes.head => [
						"m4".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Mode not allowed because type has modes.")
					]
				]
				ownedClassifiers.get(6) as SystemImplementation => [
					"s3.i2".assertEquals(name)
					ownedModes.head => [
						"m6".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Initial mode not allowed because the initial mode is inherited.")
					]
				]
				ownedClassifiers.get(7) => [
					"s3.i3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "One mode must be initial.")
				]
				ownedClassifiers.get(8) => [
					"s3.i4".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Only one mode can be initial.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}