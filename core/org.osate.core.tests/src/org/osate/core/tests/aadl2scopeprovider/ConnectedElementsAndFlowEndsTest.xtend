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
import org.osate.aadl2.AbstractType
import org.osate.aadl2.ComponentImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class ConnectedElementsAndFlowEndsTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Inject
	extension AssertHelper
	
	//Tests scope_ConnectedElement_context, scope_ConnectedElement_connectionEnd, scope_FlowEnd_context, and scope_FlowEnd_feature
	@Test
	def void testConnectedElementsAndFlowEnds() {
		val pack = '''
			package pack
			public
			  abstract a1
			  prototypes
			    fgproto1: feature group fgt1;
			    aproto1: abstract a2.i1;
			    subpproto1: subprogram subp1;
			    subpgproto1: subprogram group subpg1;
			  features
			  	ep1: in event port;
			    dp1: in data port a2.i1;
			    dp2: in data port aproto1;
			    edp1: in event data port;
			    fg1: feature group fgt1;
			    fg4: feature group fgproto1;
			    af1: feature;
			    ba1: provides bus access;
			    da1: provides data access;
			  flows
			    fsource1: flow source af1;
			    fsource2: flow source fg1.af2;
			    fsource3: flow source fg4.af2;
			    fsource4: flow source dp1.af3;
			    fsource5: flow source dp2.af3;
			  end a1;
			  
			  abstract implementation a1.i1
			  subcomponents
			    asub1: abstract a2.i1;
			    asub2: abstract aproto1;
			    bsub1: bus;
			    dsub1: data;
			    subpgsub1: subprogram group subpg1;
			    subpgsub2: subprogram group subpg1 (subpproto4 => subprogram subp1.i2);
			    subpgsub3: subprogram group subpgproto1;
			    subpsub1: subprogram subp1;
			    subpsub2: subprogram subpproto1;
			  internal features
			    eds1: event data;
			  processor features
			    pp1: port;
			    sp1: subprogram;
			  calls sequence1: {
			    call1: subprogram subp1;
			    call13: subprogram subpgsub1.subpa5;
			    call14: subprogram subpgsub2.subpa6;
			  };
			  connections
			    conn1: feature group asub1.fg2 <-> asub1.fg2;
			    conn2: feature group asub2.fg2 <-> asub1.fg2;
			    conn3: feature group fg1 <-> asub1.fg2;
			    conn4: feature group fg1.fg3 <-> asub1.fg2;
			    conn5: feature group fg4.fg3 <-> asub1.fg2;
			    conn6: port dp1.dsub2 -> asub1.dp2;
			    conn7: port dp2.dsub2 -> asub1.dp2;
			    conn8: port processor.pp1 -> asub1.dp2;
			    conn9: port self.eds1 -> asub1.dp2;
			    conn10: feature subpsub1.param1 <-> asub1.af3;
			    conn11: feature subpsub2.param1 <-> asub1.af3;
			    conn12: subprogram access processor.sp1 <-> asub1.subpa1;
			    conn24: parameter dsub1 -> call13.param1;
			    conn25: parameter dsub1 -> call14.param1;
			  end a1.i1;
			  
			  abstract a2
			  features
			    fg2: feature group;
			    dp2: in data port;
			    af3: feature;
			    ba3: provides bus access;
			    da3: provides data access;
			    subpa1: requires subprogram access;
			    ep3: in event port;
			    edp3: in event data port;
			  end a2;
			  
			  abstract implementation a2.i1
			  subcomponents
			    dsub2: data;
			    bsub2: bus;
			    subpgsub2: subprogram group;
			    subpsub2: subprogram;
			  internal features
			    eds1: event data;
			  processor features
			    pp1: port;
			    sp1: subprogram;
			  end a2.i1;
			  
			  subprogram subp1
			  prototypes
			    subpproto2: subprogram subp1.i2;
			    fgproto1: feature group fgt2;
			    subpgproto1: subprogram group subpg1;
			  features
			    param1: in out parameter;
			    af4: feature;
			    fg4: feature group fgt2;
			    fg5: feature group fgproto1;
			    subpa2: requires subprogram access subp1.i2;
			    subpa3: requires subprogram access subpproto2;
			    subpga1: requires subprogram group access subpg1;
			    subpga2: requires subprogram group access subpgproto1;
			    da4: requires data access;
			    ep4: out event port;
			    edp4: out event data port;
			  end subp1;
			  
			  subprogram implementation subp1.i1
			  subcomponents
			    subpsub3: subprogram subp1.i2;
			    subpsub4: subprogram subpproto2;
			  calls sequence2: {
			    call2: subprogram subp1.i2;
			    call3: subprogram subpsub3;
			    call4: subprogram subpsub4;
			    call5: subprogram subpproto2;
			    call6: subprogram subpa2;
			    call7: subprogram subpa3;
			    call8: subprogram subp1.subpa3;
			    call9: subprogram fg4.subpa4;
«««			    call10: subprogram fg5.subpa4;
«««				call11: subprogram subpga1.subpa5;
			  };
			  connections
			    conn13: parameter param1 -> call2.param1;
			    conn14: parameter param1 -> call3.param1;
			    conn15: parameter param1 -> call4.param1;
			    conn16: parameter param1 -> call5.param1;
			    conn17: parameter param1 -> call6.param1;
			    conn18: parameter param1 -> call7.param1;
			    conn19: parameter param1 -> call8.param1;
			    conn20: parameter param1 -> call9.param1;
«««			    conn21: parameter param1 -> call10.param1;
«««				conn22: parameter param1 -> call11.param1;
			  end subp1.i1;
			  
			  subprogram implementation subp1.i2
			  subcomponents
			    dsub3: data;
			    subpsub3: subprogram;
			  internal features
			    eds2: event data;
			  processor features
			    pp2: port;
			    sp2: subprogram;
			  end subp1.i2;
			  
			  feature group fgt1
			  features
			    fg3: feature group;
			    af2: feature;
			    param2: in parameter;
			    ba2: provides bus access;
			    da2: provides data access;
			    ep2: in event port;
			    dp2: in data port;
			    edp2: in event data port;
			  end fgt1;
			  
			  feature group fgt2
			  prototypes
			    subpproto3: subprogram subp1.i2;
			  features
			    subpa4: requires subprogram access subpproto3;
			  end fgt2;
			  
			  subprogram group subpg1
			  prototypes
			    subpproto3: subprogram subp1.i2;
			    subpproto4: subprogram;
			  features
			    subpa5: provides subprogram access subpproto3;
			    subpa6: provides subprogram access subpproto4;
			  end subpg1;
			end pack;
		'''
		val testFileResult = issues = testHelper.testString(pack)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pack".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"a1".assertEquals(name)
				ownedFlowSpecifications.get(0) => [
					"fsource1".assertEquals(name)
					//Tests scope_FlowEnd_feature(FlowSpecification, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af1", "ba1", "da1", "dp1", "dp2", "edp1", "ep1", "fg1", "fg4"])
					//Tests scope_FlowEnd_context
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Context, #["dp1", "dp2", "edp1", "fg1", "fg4"])
					//Tests scope_FlowEnd_feature(FlowEnd, EReference)
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af1", "ba1", "da1", "dp1", "dp2", "edp1", "ep1", "fg1", "fg4"])
				]
				ownedFlowSpecifications.get(1) => [
					"fsource2".assertEquals(name)
					//Tests scope_FlowEnd_feature(FlowSpecification, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af1", "ba1", "da1", "dp1", "dp2", "edp1", "ep1", "fg1", "fg4"])
					//Tests scope_FlowEnd_context
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Context, #["dp1", "dp2", "edp1", "fg1", "fg4"])
					//Tests scope_FlowEnd_feature(FlowEnd, EReference)
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af2", "ba2", "da2", "dp2", "edp2", "ep2", "fg3", "param2"])
				]
				ownedFlowSpecifications.get(2) => [
					"fsource3".assertEquals(name)
					//Tests scope_FlowEnd_feature(FlowSpecification, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af1", "ba1", "da1", "dp1", "dp2", "edp1", "ep1", "fg1", "fg4"])
					//Tests scope_FlowEnd_context
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Context, #["dp1", "dp2", "edp1", "fg1", "fg4"])
					//Tests scope_FlowEnd_feature(FlowEnd, EReference)
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af2", "ba2", "da2", "dp2", "edp2", "ep2", "fg3", "param2"])
				]
				ownedFlowSpecifications.get(3) => [
					"fsource4".assertEquals(name)
					//Tests scope_FlowEnd_feature(FlowSpecification, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af1", "ba1", "da1", "dp1", "dp2", "edp1", "ep1", "fg1", "fg4"])
					//Tests scope_FlowEnd_context
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Context, #["dp1", "dp2", "edp1", "fg1", "fg4"])
					//Tests scope_FlowEnd_feature(FlowEnd, EReference)
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af3", "ba3", "da3", "dp2", "edp3", "ep3", "fg2", "subpa1"])
					//Not testing for this error, but the assert is here so that we can test the scope when the context is a data port.
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(4) => [
					"fsource5".assertEquals(name)
					//Tests scope_FlowEnd_feature(FlowSpecification, EReference)
					assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af1", "ba1", "da1", "dp1", "dp2", "edp1", "ep1", "fg1", "fg4"])
					//Tests scope_FlowEnd_context
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Context, #["dp1", "dp2", "edp1", "fg1", "fg4"])
					//Tests scope_FlowEnd_feature(FlowEnd, EReference)
					outEnd.assertScope(Aadl2Package::eINSTANCE.flowEnd_Feature, #["af3", "ba3", "da3", "dp2", "edp3", "ep3", "fg2", "subpa1"])
					//Not testing for this error, but the assert is here so that we can test the scope when the context is a data port.
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid flow specification feature.")
				]
			]
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i1".assertEquals(name)
				ownedFeatureGroupConnections.get(0) => [
					"conn1".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedFeatureGroupConnections.get(1) => [
					"conn2".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedFeatureGroupConnections.get(2) => [
					"conn3".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af2", "ba2", "da2", "dp2", "edp2", "ep2", "fg3", "param2"])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedFeatureGroupConnections.get(3) => [
					"conn4".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedFeatureGroupConnections.get(4) => [
					"conn5".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedPortConnections.get(0) => [
					"conn6".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedPortConnections.get(1) => [
					"conn7".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14",
						"dp1", "dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedPortConnections.get(2) => [
					"conn8".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedPortConnections.get(3) => [
					"conn9".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedFeatureConnections.get(0) => [
					"conn10".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					// From fixing issue 1954
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(1) => [
					"conn11".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					// From fixing issue 1954
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.")
				]
				ownedAccessConnections.head => [
					"conn12".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(0) => [
					"conn24".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(1) => [
					"conn25".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
			]
			publicSection.ownedClassifiers.get(5) as ComponentImplementation => [
				"subp1.i1".assertEquals(name)
				ownedParameterConnections.get(0) => [
					"conn13".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3","subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(1) => [
					"conn14".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(2) => [
					"conn15".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(3) => [
					"conn16".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(4) => [
					"conn17".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(5) => [
					"conn18".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(6) => [
					"conn19".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
				ownedParameterConnections.get(7) => [
					"conn20".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpa2", "subpa3", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, emptyList)
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}