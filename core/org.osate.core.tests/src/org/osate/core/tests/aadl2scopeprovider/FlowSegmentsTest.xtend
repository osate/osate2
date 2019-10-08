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
package org.osate.core.tests.aadl2scopeprovider

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.SubprogramImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class FlowSegmentsTest extends XtextTest {
		
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Inject
	extension AssertHelper
	
	//Tests scope_FlowSegment_context, scope_FlowSegment_flowElement, scope_EndToEndFlowSegment_context, and scope_EndToEndFlowSegment_flowElement
	@Test
	def void testFlowSegments() {
		val flowSegmentScopeTest = '''
			package flowSegmentScopeTest
			public
				abstract a1
				prototypes
					fgproto1: feature group fgt1;
					aproto1: abstract a2.i;
					subpproto1: subprogram subp1.i;
					subpgproto1: subprogram group subpg1;
				features
					af1: feature;
					da1: provides data access;
					subpa1: provides subprogram access subp1.i;
					subpa2: provides subprogram access subpproto1;
					subpga1: provides subprogram group access subpg1;
					subpga2: provides subprogram group access subpgproto1;
					dp1: in data port;
					edp1: in event data port;
					fg1: feature group fgt1;
					fg2: feature group fgproto1;
				flows
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
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
					asub2: abstract aproto1;
					subpsub1: subprogram subp1.i;
					subpsub2: subprogram subpproto1;
					subpgsub1: subprogram group subpg1;
					subpgsub2: subprogram group subpg1 (subpproto5 => subprogram subp1.i);
					subpgsub3: subprogram group subpgproto1;
				calls sequence1: {
					call1: subprogram subp1.i;
					call2: subprogram subpsub1;
					call3: subprogram subpsub2;
					call4: subprogram subpproto1;
					call5: subprogram subpa1;
					call6: subprogram subpa2;
					call7: subprogram subp1.subpa4;
					call8: subprogram fg1.subpa3;
«««					call9: subprogram fg2.subpa3;
«««					call10: subprogram subpga1.subpa5;
					call12: subprogram subpgsub1.subpa5;
					call13: subprogram subpgsub2.subpa6;
				};
				connections
					fconn1: feature asub1.af2 -> af1;
					fconn2: feature asub1.af2 -> asub1.af2;
				flows
					fsource1: flow source asub1 -> fconn1 -> af1;
					fsource2: flow source fg1.da3 -> fconn1 -> af1;
					fsource3: flow source fg2.da3 -> fconn1 -> af1;
					fsource4: flow source asub1.fsource20 -> fconn1 -> af1;
					fsource5: flow source asub2.fsource20 -> fconn1 -> af1;
					fsource6: flow source call1.da4 -> fconn1 -> af1;
					fsource7: flow source call2.da4 -> fconn1 -> af1;
					fsource8: flow source call3.da4 -> fconn1 -> af1;
					fsource9: flow source call4.da4 -> fconn1 -> af1;
					fsource10: flow source call5.da4 -> fconn1 -> af1;
					fsource11: flow source call6.da4 -> fconn1 -> af1;
					fsource12: flow source call7.da4 -> fconn1 -> af1;
					fsource13: flow source call8.da4 -> fconn1 -> af1;
«««					fsource14: flow source call9.da4 -> fconn1 -> af1;
«««					fsource15: flow source call10.da4 -> fconn1 -> af1;
					fsource17: flow source call12.da4 -> fconn1 -> af1;
					fsource18: flow source call13.da4 -> fconn1 -> af1;
					
					etef1: end to end flow asub1.fsource20 -> fconn2 -> asub2.fsink1;
					etef2: end to end flow fg1.da3 -> fconn2 -> asub1.fsink1;
					etef3: end to end flow fg2.da3 -> fconn2 -> asub1.fsink1;
					etef4: end to end flow call1.da4 -> fconn2 -> asub1.fsink1;
					etef5: end to end flow call2.da4 -> fconn2 -> asub1.fsink1;
					etef6: end to end flow call3.da4 -> fconn2 -> asub1.fsink1;
					etef7: end to end flow call4.da4 -> fconn2 -> asub1.fsink1;
					etef8: end to end flow call5.da4 -> fconn2 -> asub1.fsink1;
					etef9: end to end flow call6.da4 -> fconn2 -> asub1.fsink1;
					etef10: end to end flow call7.da4 -> fconn2 -> asub1.fsink1;
					etef11: end to end flow call8.da4 -> fconn2 -> asub1.fsink1;
«««					etef12: end to end flow call9.da4 -> fconn2 -> asub1.fsink1;
«««					etef13: end to end flow call10.da4 -> fconn2 -> asub1.fsink1;
					etef15: end to end flow call12.da4 -> fconn2 -> asub1.fsink1;
					etef16: end to end flow call13.da4 -> fconn2 -> asub1.fsink1;
				end a1.i;
				
				abstract a2
				features
					af2: feature;
					da2: provides data access;
				flows
					fsource20: flow source af2;
					fsink1: flow sink af2;
				end a2;
				
				abstract implementation a2.i
				subcomponents
					asub3: abstract a2;
				connections
					fconn3: feature af2 -> asub3.af2;
					fconn4: feature asub3.af2 -> asub3.af2;
				flows
					etef18: end to end flow asub3.fsource20 -> fconn4 -> asub3.fsink1;
				end a2.i;
				
				feature group fgt1
				prototypes
					subpproto2: subprogram subp1.i;
				features
					da3: provides data access;
					subpa3: provides subprogram access subpproto2;
				end fgt1;
				
				subprogram subp1
				prototypes
					aproto2: abstract a2.i;
					subpproto3: subprogram subp1.i;
				features
					af3: feature;
					da4: requires data access;
					subpa4: requires subprogram access subpproto3;
					param1: in parameter a2.i;
					param2: in parameter aproto2;
				flows
					fsource21: flow source af3;
					fsource22: flow source af3;
				end subp1;
				
				subprogram implementation subp1.i
				subcomponents
					asub4: abstract a2.i;
				connections
					fconn5: feature asub4.af2 -> af3;
					fconn6: feature asub4.af2 -> asub4.af2;
				flows
					fsource21: flow source param1.da2 -> fconn5 -> af3;
					fsource22: flow source param2.da2 -> fconn5 -> af3;
					
					etef19: end to end flow param1.da2 -> fconn6 -> asub4.fsink1;
					etef20: end to end flow param2.da2 -> fconn6 -> asub4.fsink1;
				end subp1.i;
				
				subprogram group subpg1
				prototypes
					subpproto4: subprogram subp1.i;
					subpproto5: subprogram;
				features
					subpa5: provides subprogram access subpproto4;
					subpa6: provides subprogram access subpproto5;
				end subpg1;
			end flowSegmentScopeTest;
		'''
		val testFileResult = issues = testHelper.testString(flowSegmentScopeTest)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"flowSegmentScopeTest".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFlowImplementations.get(0) => [
					"fsource1".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						context.assertNull
						"asub1".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Connection 'fconn1' continues inside subcomponent 'asub1'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(1) => [
					"fsource2".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"fg1".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Group.Data Access 'fg1.da3'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["da3"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(2) => [
					"fsource3".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"fg2".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Group.Data Access 'fg2.da3'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["da3"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(3) => [
					"fsource4".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"fsource20".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub3", "da2", "fconn3", "fconn4", "fsink1", "fsource20"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(4) => [
					"fsource5".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"asub2".assertEquals(context.name)
						"fsource20".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub3", "da2", "fconn3", "fconn4", "fsink1", "fsource20"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(5) => [
					"fsource6".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call1.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(6) => [
					"fsource7".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call2".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call2.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(7) => [
					"fsource8".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call3".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call3.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(8) => [
					"fsource9".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call4".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call4.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(9) => [
					"fsource10".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call5".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call5.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(10) => [
					"fsource11".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call6".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call6.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(11) => [
					"fsource12".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call7".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call7.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(12) => [
					"fsource13".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call8".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call8.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(13) => [
					"fsource17".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call12".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call12.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedFlowImplementations.get(14) => [
					"fsource18".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedFlowSegments.get(0) => [
						"call13".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call13.da4'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn1".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3", "call4",
							"call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
						])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub1", "asub2", "da1", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
				]
				ownedEndToEndFlows.get(0) => [
					"etef1".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"asub1".assertEquals(context.name)
						"fsource20".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])

						//connection end does not match
						assertError(testFileResult.issues, issueCollection, "The destination of connection 'fconn2' does not match the succeeding subcomponent or in flow spec feature 'asub2.af2'")
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub2".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(1) => [
					"etef2".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"fg1".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'feature group' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["da3"])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(2) => [
					"etef3".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"fg2".assertEquals(context.name)
						"da3".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'feature group' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["da3"])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(3) => [
					"etef4".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call1".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(4) => [
					"etef5".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call2".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(5) => [
					"etef6".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call3".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(6) => [
					"etef7".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call4".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(7) => [
					"etef8".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call5".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(8) => [
					"etef9".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call6".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(9) => [
					"etef10".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call7".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(10) => [
					"etef11".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call8".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(11) => [
					"etef15".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call12".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(12) => [
					"etef16".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
						"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
						"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
						"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
						"subpsub2"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"call13".assertEquals(context.name)
						"da4".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn2".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub1", "asub2", "da1", "etef1", "etef10", "etef11", "etef15",
							"etef16", "etef2", "etef3", "etef4", "etef5", "etef6", "etef7", "etef8", "etef9", "fconn1", "fconn2", "fsource1", "fsource10",
							"fsource11", "fsource12", "fsource13", "fsource14", "fsource15", "fsource16", "fsource17", "fsource18", "fsource19", "fsource2",
							"fsource3", "fsource4", "fsource5", "fsource6", "fsource7", "fsource8", "fsource9", "subpgsub1", "subpgsub2", "subpgsub3",
							"subpsub1", "subpsub2"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub1".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub1", "asub2", "call1", "call12", "call13", "call2", "call3",
							"call4", "call5", "call6", "call7", "call8", "dp1", "edp1", "fg1", "fg2", "subpa1", "subpa2","subpgsub1", "subpgsub2", "subpgsub3", "subpsub1",
							"subpsub2"
						])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
			]
			publicSection.ownedClassifiers.get(3) as AbstractImplementation => [
				"a2.i".assertEquals(name)
				ownedEndToEndFlows.get(0) => [
					"etef18".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
						"fsource20"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"asub3".assertEquals(context.name)
						"fsource20".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub3"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["da2", "fsink1", "fsource20"])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn4".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub3"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub3".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub3"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["da2", "fsink1", "fsource20"])
					]
				]
			]
			publicSection.ownedClassifiers.get(6) as SubprogramImplementation => [
				"subp1.i".assertEquals(name)
				ownedFlowImplementations.get(0) => [
					"fsource21".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					ownedFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Data Access 'param1.da2'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub3", "da2", "fconn3", "fconn4", "fsink1", "fsource20"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn5".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
				]
				ownedFlowImplementations.get(1) => [
					"fsource22".assertEquals(specification.name)
					//Tests scope_FlowSegment_flowElement(FlowImplementation, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					ownedFlowSegments.get(0) => [
						"param2".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Data Access 'param2.da2'")
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub3", "da2", "fconn3", "fconn4", "fsink1", "fsource20"])
					]
					ownedFlowSegments.get(1) => [
						context.assertNull
						"fconn5".assertEquals(flowElement.name)
						//Tests scope_FlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.flowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_FlowSegment_flowElement(FlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.flowSegment_FlowElement, #["asub4", "da4", "fconn5", "fconn6", "fsource21", "fsource22"])
					]
				]
				ownedEndToEndFlows.get(0) => [
					"etef19".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6", "fsource21",
						"fsource22"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"param1".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn6".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub4".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
				ownedEndToEndFlows.get(1) => [
					"etef20".assertEquals(name)
					//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlow, EReference)
					assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6", "fsource21",
						"fsource22"
					])
					ownedEndToEndFlowSegments.get(0) => [
						"param2".assertEquals(context.name)
						"da2".assertEquals(flowElement.name)
						assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid subcomponent flow.")
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
					ownedEndToEndFlowSegments.get(1) => [
						context.assertNull
						"fconn6".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub4", "da4", "etef19", "etef20", "fconn5", "fconn6",
							"fsource21", "fsource22"
						])
					]
					ownedEndToEndFlowSegments.get(2) => [
						"asub4".assertEquals(context.name)
						"fsink1".assertEquals(flowElement.name)
						//Tests scope_EndToEndFlowSegment_context
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_Context, #["asub4", "param1", "param2","subpa4"])
						//Tests scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment, EReference)
						assertScope(Aadl2Package::eINSTANCE.endToEndFlowSegment_FlowElement, #["asub3", "da2", "etef18", "fconn3", "fconn4", "fsink1",
							"fsource20"
						])
					]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}