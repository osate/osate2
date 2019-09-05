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
import org.osate.aadl2.SubprogramImplementation
import org.osate.aadl2.SubprogramType
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class ConnectionAndFlowTypesTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	/*
	 * Tests typeCheckAccessConnectionEnd, typeCheckFeatureConnectionEnd, typeCheckFeatureGroupConnectionEnd, typeCheckParameterConnectionEnd,
	 * typeCheckPortConnectionEnd, and checkFlowFeatureType
	 */
	@Test
	def void testConnectionAndFlowTypes() {
		val legalTypeTest = '''
				package legalTypeTest
				public
					abstract container
					features
						da1: requires data access d1;
						ba1: requires bus access;
						af1: feature;
						fg1: feature group fgt1;
						ep1: in event port;
						ep2: out event port;
						dp1: in data port a1.i;
						dp2: in data port d1;
						edp1: in event data port a1.i;
						edp2: out event data port;
						edp3: in event data port d1;
					flows
						--DataAccess
						fsource1: flow source da1;
						--AbstractFeature
						fsource2: flow source af1;
						--FeatureGroup
						fsource3: flow source fg1;
						--Port
						fsource4: flow source ep2;
						
						--DataPort.DataAccess
						fsource5: flow source dp1.da3;
						--DataPort.AbstractFeature
						fsource6: flow source dp1.af3;
						--DataPort.FeatureGroup
						fsource7: flow source dp1.fg3;
						--DataPort.Port
						fsource8: flow source dp1.ep5;
						
						--EventDataPort.DataAccess
						fsource9: flow source edp1.da3;
						--EventDataPort.AbstractFeature
						fsource10: flow source edp1.af3;
						--EventDataPort.FeatureGroup
						fsource11: flow source edp1.fg3;
						--EventDataPort.Port
						fsource12: flow source edp1.ep5;
						
						--FeatureGroup.DataAccess
						fsource13: flow source fg1.da5;
						--FeatureGroup.AbstractFeature
						fsource14: flow source fg1.af4;
						--FeatureGroup.FeatureGroup
						fsource15: flow source fg1.fg4;
						--FeatureGroup.Parameter
						fsource16: flow source fg1.param4;
						--FeatureGroup.Port
						fsource17: flow source fg1.ep8;
					end container;
					
					abstract implementation container.i
					subcomponents
						asub1: abstract a1.i;
						bsub1: bus;
						dsub1: data d1;
						--Allow the error so that we can test the type
						--check validation for port connection ends
						--when the context is a DataSubcomponent.
						dsub2: data a1.i;
						subpgsub1: subprogram group;
						subpsub1: subprogram subpcontainer;
					internal features
						eds1: event data;
					processor features
						pp1: port;
						sp1: subprogram subpcontainer;
					calls sequence1: {
						call1: subprogram subpcontainer.i;
					};
					connections
						--AccessConnections
						--AccessConnections
						--AccessConnections
						--AccessConnections
						
						
						
						--BusSubcomponent
						aconn1: bus access bsub1 <-> asub1.ba2;
						--DataSubcomponent
						aconn2: data access dsub1 <-> asub1.da3;
						--SubprogramGroupSubcomponent
						aconn3: subprogram group access subpgsub1 <-> asub1.subpga1;
						--SubprogramSubcomponent
						aconn4: subprogram access subpsub1 <-> asub1.subpa2;
						--SubprogramProxy
						aconn5: subprogram access processor.sp1 <-> asub1.subpa2;
						--PortProxy
						aconn6: data access processor.pp1 <-> asub1.da3;
						--InternalFeature
						aconn7: data access eds1 <-> asub1.da3;
						--Feature
						aconn8: data access af1 <-> asub1.da3;
						--FeatureGroup
						aconn9: data access fg1 <-> asub1.da3;
						--Access
						aconn10: bus access ba1 <-> asub1.ba2;
						--DataAccess
						aconn11: data access da1 <-> asub1.da3;
						--Port
						aconn12: data access ep1 <-> asub1.da3;
						--DataPort
						aconn13: data access dp1 <-> asub1.da3;
						--EventDataPort
						aconn14: data access edp1 <-> asub1.da3;
						
						--DataPort.BusSubcomponent
						aconn15: bus access dp1.bsub2 <-> asub1.ba2;
						--DataPort.DataSubcomponent
						aconn16: data access dp1.dsub4 <-> asub1.da3;
						--DataPort.SubprogramGroupSubcomponent
						aconn17: subprogram group access dp1.subpgsub2 <-> asub1.subpga1;
						--DataPort.SubprogramSubcomponent
						aconn18: subprogram access dp1.subpsub3 <-> asub1.subpa2;
						--DataPort.SubprogramProxy
						aconn19: subprogram access dp1.sp3 <-> asub1.subpa2;
						--DataPort.PortProxy
						aconn20: data access dp1.pp3 <-> asub1.da3;
						--DataPort.InternalFeature
						aconn21: data access dp1.eds3 <-> asub1.da3;
						--DataPort.Feature
						aconn22: data access dp1.af3 <-> asub1.da3;
						--DataPort.FeatureGroup
						aconn23: data access dp1.fg3 <-> asub1.da3;
						--DataPort.Access
						aconn24: bus access dp1.ba2 <-> asub1.ba2;
						--DataPort.DataAccess
						aconn25: data access dp1.da3 <-> asub1.da3;
						--DataPort.Port
						aconn26: data access dp1.ep5 <-> asub1.da3;
						--DataPort.DataPort
						aconn27: data access dp1.dp3 <-> asub1.da3;
						--DataPort.EventDataPort
						aconn28: data access dp1.edp6 <-> asub1.da3;
						
						--EventDataPort.BusSubcomponent
						aconn29: bus access edp1.bsub2 <-> asub1.ba2;
						--EventDataPort.DataSubcomponent
						aconn30: data access edp1.dsub4 <-> asub1.da3;
						--EventDataPort.SubprogramGroupSubcomponent
						aconn31: subprogram group access edp1.subpgsub2 <-> asub1.subpga1;
						--EventDataPort.SubprogramSubcomponent
						aconn32: subprogram access edp1.subpsub3 <-> asub1.subpa2;
						--EventDataPort.SubprogramProxy
						aconn33: subprogram access edp1.sp3 <-> asub1.subpa2;
						--EventDataPort.PortProxy
						aconn34: data access edp1.pp3 <-> asub1.da3;
						--EventDataPort.InternalFeature
						aconn35: data access edp1.eds3 <-> asub1.da3;
						--EventDataPort.Feature
						aconn36: data access edp1.af3 <-> asub1.da3;
						--EventDataPort.FeatureGroup
						aconn37: data access edp1.fg3 <-> asub1.da3;
						--EventDataPort.Access
						aconn38: bus access edp1.ba2 <-> asub1.ba2;
						--EventDataPort.DataAccess
						aconn39: data access edp1.da3 <-> asub1.da3;
						--EventDataPort.Port
						aconn40: data access edp1.ep5 <-> asub1.da3;
						--EventDataPort.DataPort
						aconn41: data access edp1.dp3 <-> asub1.da3;
						--EventDataPort.EventDataPort
						aconn42: data access edp1.edp6 <-> asub1.da3;
						
						--FeatureGroup.Feature
						aconn43: data access fg1.af4 <-> asub1.da3;
						--FeatureGroup.FeatureGroup
						aconn44: data access fg1.fg4 <-> asub1.da3;
						--FeatureGroup.Parameter
						aconn45: data access fg1.param3 <-> asub1.da3;
						--FeatureGroup.Access
						aconn46: bus access fg1.ba4 <-> asub1.ba2;
						--FeatureGroup.DataAccess
						aconn47: data access fg1.da5 <-> asub1.da3;
						--FeatureGroup.Port
						aconn48: data access fg1.ep7 <-> asub1.da3;
						--FeatureGroup.DataPort
						aconn49: data access fg1.dp6 <-> asub1.da3;
						--FeatureGroup.EventDataPort
						aconn50: data access fg1.edp7 <-> asub1.da3;
						
						--Subcomponent.BusSubcomponent
						aconn51: bus access asub1.bsub2 <-> asub1.ba2;
						--Subcomponent.DataSubcomponent
						aconn52: data access asub1.dsub4 <-> asub1.da3;
						--Subcomponent.SubprogramGroupSubcomponent
						aconn53: subprogram group access asub1.subpgsub2 <-> asub1.subpga1;
						--Subcomponent.SubprogramSubcomponent
						aconn54: subprogram access asub1.subpsub3 <-> asub1.subpa2;
						--Subcomponent.SubprogramProxy
						aconn55: subprogram access asub1.sp3 <-> asub1.subpa2;
						--Subcomponent.PortProxy
						aconn56: data access asub1.pp3 <-> asub1.da3;
						--Subcomponent.InternalFeature
						aconn57: data access asub1.eds3 <-> asub1.da3;
						--Subcomponent.Feature
						aconn58: data access asub1.af3 <-> asub1.da3;
						--Subcomponent.FeatureGroup
						aconn59: data access asub1.fg3 <-> asub1.da3;
						--Subcomponent.Parameter
						aconn60: data access subpsub1.param1 <-> asub1.da3;
						--Subcomponent.Access
						aconn61: bus access asub1.ba2 <-> asub1.ba3;
						--Subcomponent.DataAccess
						aconn62: data access asub1.da3 <-> asub1.da4;
						--Subcomponent.Port
						aconn63: data access asub1.ep5 <-> asub1.da3;
						--Subcomponent.DataPort
						aconn64: data access asub1.dp3 <-> asub1.da3;
						--Subcomponent.EventDataPort
						aconn65: data access asub1.edp6 <-> asub1.da3;
						
						--SubprogramCall.DataSubcomponent
						aconn66: data access call1.dsub3 <-> asub1.da3;
						--SubprogramCall.SubprogramSubcomponent
						aconn67: subprogram access call1.subpsub2 <-> asub1.subpa2;
						--SubprogramCall.SubprogramProxy
						aconn68: subprogram access call1.sp2 <-> asub1.subpa2;
						--SubprogramCall.PortProxy
						aconn69: data access call1.pp2 <-> asub1.da3;
						--SubprogramCall.InternalFeature
						aconn70: data access call1.eds2 <-> asub1.da3;
						--SubprogramCall.Feature
						aconn71: data access call1.af2 <-> asub1.da3;
						--SubprogramCall.FeatureGroup
						aconn72: data access call1.fg2 <-> asub1.da3;
						--SubprogramCall.Parameter
						aconn73: data access call1.param1 <-> asub1.da3;
						--SubprogramCall.Access
						aconn74: subprogram access call1.subpa1 <-> asub1.subpa2;
						--SubprogramCall.DataAccess
						aconn75: data access call1.da2 <-> asub1.da3;
						--SubprogramCall.Port
						aconn76: data access call1.ep3 <-> asub1.da3;
						--SubprogramCall.EventDataPort
						aconn77: data access call1.edp4 <-> asub1.da3;
						
						
						
						--FeatureConnections
						--FeatureConnections
						--FeatureConnections
						--FeatureConnections
						
						
						
						--BusSubcomponent
						fconn1: feature bsub1 <-> asub1.af3;
						--DataSubcomponent
						fconn2: feature dsub1 <-> asub1.af3;
						--SubprogramGroupSubcomponent
						fconn3: feature subpgsub1 <-> asub1.af3;
						--SubprogramSubcomponent
						fconn4: feature subpsub1 <-> asub1.af3;
						--SubprogramProxy
						fconn5: feature sp1 <-> asub1.af3;
						--PortProxy
						fconn6: feature pp1 <-> asub1.af3;
						--InternalFeature
						fconn7: feature eds1 <-> asub1.af3;
						--Feature
						fconn8: feature af1 <-> asub1.af3;
						--FeatureGroup
						fconn9: feature fg1 <-> asub1.af3;
						--Access
						fconn10: feature ba1 <-> asub1.af3;
						--DataAccess
						fconn11: feature da1 <-> asub1.af3;
						--Port
						fconn12: feature ep1 <-> asub1.af3;
						--DataPort
						fconn13: feature dp1 <-> asub1.af3;
						--EventDataPort
						fconn14: feature edp1 <-> asub1.af3;
						
						--DataPort.BusSubcomponent
						fconn15: feature dp1.bsub2 <-> asub1.af3;
						--DataPort.DataSubcomponent
						fconn16: feature dp1.dsub4 <-> asub1.af3;
						--DataPort.SubprogramGroupSubcomponent
						fconn17: feature dp1.subpgsub2 <-> asub1.af3;
						--DataPort.SubprogramSubcomponent
						fconn18: feature dp1.subpsub3 <-> asub1.af3;
						--DataPort.SubprogramProxy
						fconn19: feature dp1.sp3 <-> asub1.af3;
						--DataPort.PortProxy
						fconn20: feature dp1.pp3 <-> asub1.af3;
						--DataPort.InternalFeature
						fconn21: feature dp1.eds3 <-> asub1.af3;
						--DataPort.Feature
						fconn22: feature dp1.af3 <-> asub1.af3;
						--DataPort.FeatureGroup
						fconn23: feature dp1.fg3 <-> asub1.af3;
						--DataPort.Access
						fconn24: feature dp1.ba2 <-> asub1.af3;
						--DataPort.DataAccess
						fconn25: feature dp1.da3 <-> asub1.af3;
						--DataPort.Port
						fconn26: feature dp1.ep5 <-> asub1.af3;
						--DataPort.DataPort
						fconn27: feature dp1.dp3 <-> asub1.af3;
						--DataPort.EventDataPort
						fconn28: feature dp1.edp6 <-> asub1.af3;
						
						--EventDataPort.BusSubcomponent
						fconn29: feature edp1.bsub2 <-> asub1.af3;
						--EventDataPort.DataSubcomponent
						fconn30: feature edp1.dsub4 <-> asub1.af3;
						--EventDataPort.SubprogramGroupSubcomponent
						fconn31: feature edp1.subpgsub2 <-> asub1.af3;
						--EventDataPort.SubprogramSubcomponent
						fconn32: feature edp1.subpsub3 <-> asub1.af3;
						--EventDataPort.SubprogramProxy
						fconn33: feature edp1.sp3 <-> asub1.af3;
						--EventDataPort.PortProxy
						fconn34: feature edp1.pp3 <-> asub1.af3;
						--EventDataPort.InternalFeature
						fconn35: feature edp1.eds3 <-> asub1.af3;
						--EventDataPort.Feature
						fconn36: feature edp1.af3 <-> asub1.af3;
						--EventDataPort.FeatureGroup
						fconn37: feature edp1.fg3 <-> asub1.af3;
						--EventDataPort.Access
						fconn38: feature edp1.ba2 <-> asub1.af3;
						--EventDataPort.DataAccess
						fconn39: feature edp1.da3 <-> asub1.af3;
						--EventDataPort.Port
						fconn40: feature edp1.ep5 <-> asub1.af3;
						--EventDataPort.DataPort
						fconn41: feature edp1.dp3 <-> asub1.af3;
						--EventDataPort.EventDataPort
						fconn42: feature edp1.edp6 <-> asub1.af3;
						
						--FeatureGroup.Feature
						fconn43: feature fg1.af4 <-> asub1.af3;
						--FeatureGroup.FeatureGroup
						fconn44: feature fg1.fg4 <-> asub1.af3;
						--FeatureGroup.Parameter
						fconn45: feature fg1.param3 <-> asub1.af3;
						--FeatureGroup.Access
						fconn46: feature fg1.ba4 <-> asub1.af3;
						--FeatureGroup.DataAccess
						fconn47: feature fg1.da5 <-> asub1.af3;
						--FeatureGroup.Port
						fconn48: feature fg1.ep7 <-> asub1.af3;
						--FeatureGroup.DataPort
						fconn49: feature fg1.dp6 <-> asub1.af3;
						--FeatureGroup.EventDataPort
						fconn50: feature fg1.edp7 <-> asub1.af3;
						
						--Subcomponent.BusSubcomponent
						fconn51: feature asub1.bsub2 <-> asub1.af3;
						--Subcomponent.DataSubcomponent
						fconn52: feature asub1.dsub4 <-> asub1.af3;
						--Subcomponent.SubprogramGroupSubcomponent
						fconn53: feature asub1.subpgsub2 <-> asub1.af3;
						--Subcomponent.SubprogramSubcomponent
						fconn54: feature asub1.subpsub3 <-> asub1.af3;
						--Subcomponent.SubprogramProxy
						fconn55: feature asub1.sp3 <-> asub1.af3;
						--Subcomponent.PortProxy
						fconn56: feature asub1.pp3 <-> asub1.af3;
						--Subcomponent.InternalFeature
						fconn57: feature asub1.eds3 <-> asub1.af3;
						--Subcomponent.Feature
						fconn58: feature asub1.af3 <-> asub1.af3;
						--Subcomponent.FeatureGroup
						fconn59: feature asub1.fg3 <-> asub1.af3;
						--Subcomponent.Parameter
						fconn60: feature subpsub1.param1 <-> asub1.af3;
						--Subcomponent.Access
						fconn61: feature asub1.ba2 <-> asub1.af3;
						--Subcomponent.DataAccess
						fconn62: feature asub1.da3 <-> asub1.af3;
						--Subcomponent.Port
						fconn63: feature asub1.ep5 <-> asub1.af3;
						--Subcomponent.DataPort
						fconn64: feature asub1.dp3 <-> asub1.af3;
						--Subcomponent.EventDataPort
						fconn65: feature asub1.edp6 <-> asub1.af3;
						
						--SubprogramCall.DataSubcomponent
						fconn66: feature call1.dsub3 <-> asub1.af3;
						--SubprogramCall.SubprogramSubcomponent
						fconn67: feature call1.subpsub2 <-> asub1.af3;
						--SubprogramCall.SubprogramProxy
						fconn68: feature call1.sp2 <-> asub1.af3;
						--SubprogramCall.PortProxy
						fconn69: feature call1.pp2 <-> asub1.af3;
						--SubprogramCall.InternalFeature
						fconn70: feature call1.eds2 <-> asub1.af3;
						--SubprogramCall.Feature
						fconn71: feature call1.af2 <-> asub1.af3;
						--SubprogramCall.FeatureGroup
						fconn72: feature call1.fg2 <-> asub1.af3;
						--SubprogramCall.Parameter
						fconn73: feature call1.param1 <-> asub1.af3;
						--SubprogramCall.Access
						fconn74: feature call1.subpa1 <-> asub1.af3;
						--SubprogramCall.DataAccess
						fconn75: feature call1.da2 <-> asub1.af3;
						
						
						
						--FeatureGroupConnections
						--FeatureGroupConnections
						--FeatureGroupConnections
						--FeatureGroupConnections
						
						
						
						--BusSubcomponent
						fgconn1: feature group bsub1 <-> asub1.fg3;
						--DataSubcomponent
						fgconn2: feature group dsub1 <-> asub1.fg3;
						--SubprogramGroupSubcomponent
						fgconn3: feature group subpgsub1 <-> asub1.fg3;
						--SubprogramSubcomponent
						fgconn4: feature group subpsub1 <-> asub1.fg3;
						--SubprogramProxy
						fgconn5: feature group sp1 <-> asub1.fg3;
						--PortProxy
						fgconn6: feature group pp1 <-> asub1.fg3;
						--InternalFeature
						fgconn7: feature group eds1 <-> asub1.fg3;
						--Feature
						fgconn8: feature group af1 <-> asub1.fg3;
						--FeatureGroup
						fgconn9: feature group fg1 <-> asub1.fg3;
						--Access
						fgconn10: feature group ba1 <-> asub1.fg3;
						--DataAccess
						fgconn11: feature group da1 <-> asub1.fg3;
						--Port
						fgconn12: feature group ep1 <-> asub1.fg3;
						--DataPort
						fgconn13: feature group dp1 <-> asub1.fg3;
						--EventDataPort
						fgconn14: feature group edp1 <-> asub1.fg3;
						
						--DataPort.BusSubcomponent
						fgconn15: feature group dp1.bsub2 <-> asub1.fg3;
						--DataPort.DataSubcomponent
						fgconn16: feature group dp1.dsub4 <-> asub1.fg3;
						--DataPort.SubprogramGroupSubcomponent
						fgconn17: feature group dp1.subpgsub2 <-> asub1.fg3;
						--DataPort.SubprogramSubcomponent
						fgconn18: feature group dp1.subpsub3 <-> asub1.fg3;
						--DataPort.SubprogramProxy
						fgconn19: feature group dp1.sp3 <-> asub1.fg3;
						--DataPort.PortProxy
						fgconn20: feature group dp1.pp3 <-> asub1.fg3;
						--DataPort.InternalFeature
						fgconn21: feature group dp1.eds3 <-> asub1.fg3;
						--DataPort.Feature
						fgconn22: feature group dp1.af3 <-> asub1.fg3;
						--DataPort.FeatureGroup
						fgconn23: feature group dp1.fg3 <-> asub1.fg3;
						--DataPort.Access
						fgconn24: feature group dp1.ba2 <-> asub1.fg3;
						--DataPort.DataAccess
						fgconn25: feature group dp1.da3 <-> asub1.fg3;
						--DataPort.Port
						fgconn26: feature group dp1.ep5 <-> asub1.fg3;
						--DataPort.DataPort
						fgconn27: feature group dp1.dp3 <-> asub1.fg3;
						--DataPort.EventDataPort
						fgconn28: feature group dp1.edp6 <-> asub1.fg3;
						
						--EventDataPort.BusSubcomponent
						fgconn29: feature group edp1.bsub2 <-> asub1.fg3;
						--EventDataPort.DataSubcomponent
						fgconn30: feature group edp1.dsub4 <-> asub1.fg3;
						--EventDataPort.SubprogramGroupSubcomponent
						fgconn31: feature group edp1.subpgsub2 <-> asub1.fg3;
						--EventDataPort.SubprogramSubcomponent
						fgconn32: feature group edp1.subpsub3 <-> asub1.fg3;
						--EventDataPort.SubprogramProxy
						fgconn33: feature group edp1.sp3 <-> asub1.fg3;
						--EventDataPort.PortProxy
						fgconn34: feature group edp1.pp3 <-> asub1.fg3;
						--EventDataPort.InternalFeature
						fgconn35: feature group edp1.eds3 <-> asub1.fg3;
						--EventDataPort.Feature
						fgconn36: feature group edp1.af3 <-> asub1.fg3;
						--EventDataPort.FeatureGroup
						fgconn37: feature group edp1.fg3 <-> asub1.fg3;
						--EventDataPort.Access
						fgconn38: feature group edp1.ba2 <-> asub1.fg3;
						--EventDataPort.DataAccess
						fgconn39: feature group edp1.da3 <-> asub1.fg3;
						--EventDataPort.Port
						fgconn40: feature group edp1.ep5 <-> asub1.fg3;
						--EventDataPort.DataPort
						fgconn41: feature group edp1.dp3 <-> asub1.fg3;
						--EventDataPort.EventDataPort
						fgconn42: feature group edp1.edp6 <-> asub1.fg3;
						
						--FeatureGroup.Feature
						fgconn43: feature group fg1.af4 <-> asub1.fg3;
						--FeatureGroup.FeatureGroup
						fgconn44: feature group fg1.fg4 <-> asub1.fg3;
						--FeatureGroup.Parameter
						fgconn45: feature group fg1.param3 <-> asub1.fg3;
						--FeatureGroup.Access
						fgconn46: feature group fg1.ba4 <-> asub1.fg3;
						--FeatureGroup.DataAccess
						fgconn47: feature group fg1.da5 <-> asub1.fg3;
						--FeatureGroup.Port
						fgconn48: feature group fg1.ep7 <-> asub1.fg3;
						--FeatureGroup.DataPort
						fgconn49: feature group fg1.dp6 <-> asub1.fg3;
						--FeatureGroup.EventDataPort
						fgconn50: feature group fg1.edp7 <-> asub1.fg3;
						
						--Subcomponent.BusSubcomponent
						fgconn51: feature group asub1.bsub2 <-> asub1.fg3;
						--Subcomponent.DataSubcomponent
						fgconn52: feature group asub1.dsub4 <-> asub1.fg3;
						--Subcomponent.SubprogramGroupSubcomponent
						fgconn53: feature group asub1.subpgsub2 <-> asub1.fg3;
						--Subcomponent.SubprogramSubcomponent
						fgconn54: feature group asub1.subpsub3 <-> asub1.fg3;
						--Subcomponent.SubprogramProxy
						fgconn55: feature group asub1.sp3 <-> asub1.fg3;
						--Subcomponent.PortProxy
						fgconn56: feature group asub1.pp3 <-> asub1.fg3;
						--Subcomponent.InternalFeature
						fgconn57: feature group asub1.eds3 <-> asub1.fg3;
						--Subcomponent.Feature
						fgconn58: feature group asub1.af3 <-> asub1.fg3;
						--Subcomponent.FeatureGroup
						fgconn59: feature group asub1.fg3 <-> asub1.fg3;
						--Subcomponent.Parameter
						fgconn60: feature group subpsub1.param1 <-> asub1.fg3;
						--Subcomponent.Access
						fgconn61: feature group asub1.ba2 <-> asub1.fg3;
						--Subcomponent.DataAccess
						fgconn62: feature group asub1.da3 <-> asub1.fg3;
						--Subcomponent.Port
						fgconn63: feature group asub1.ep5 <-> asub1.fg3;
						--Subcomponent.DataPort
						fgconn64: feature group asub1.dp3 <-> asub1.fg3;
						--Subcomponent.EventDataPort
						fgconn65: feature group asub1.edp6 <-> asub1.fg3;
						
						--SubprogramCall.DataSubcomponent
						fgconn66: feature group call1.dsub3 <-> asub1.fg3;
						--SubprogramCall.SubprogramSubcomponent
						fgconn67: feature group call1.subpsub2 <-> asub1.fg3;
						--SubprogramCall.SubprogramProxy
						fgconn68: feature group call1.sp2 <-> asub1.fg3;
						--SubprogramCall.PortProxy
						fgconn69: feature group call1.pp2 <-> asub1.fg3;
						--SubprogramCall.InternalFeature
						fgconn70: feature group call1.eds2 <-> asub1.fg3;
						--SubprogramCall.Feature
						fgconn71: feature group call1.af2 <-> asub1.fg3;
						--SubprogramCall.FeatureGroup
						fgconn72: feature group call1.fg2 <-> asub1.fg3;
						--SubprogramCall.Parameter
						fgconn73: feature group call1.param1 <-> asub1.fg3;
						--SubprogramCall.Access
						fgconn74: feature group call1.subpa1 <-> asub1.fg3;
						--SubprogramCall.DataAccess
						fgconn75: feature group call1.da2 <-> asub1.fg3;
						--SubprogramCall.Port
						fgconn76: feature group call1.ep3 <-> asub1.fg3;
						--SubprogramCall.EventDataPort
						fgconn77: feature group call1.edp5 <-> asub1.fg3;
						
						
						
						--ParameterConnections
						--ParameterConnections
						--ParameterConnections
						--ParameterConnections
						
						
						
						--BusSubcomponent
						paramconn1: parameter bsub1 -> call1.param1;
						--DataSubcomponent
						paramconn2: parameter dsub1 -> call1.param2;
						--SubprogramGroupSubcomponent
						paramconn3: parameter subpgsub1 -> call1.param1;
						--SubprogramSubcomponent
						paramconn4: parameter subpsub1 -> call1.param1;
						--SubprogramProxy
						paramconn5: parameter sp1 -> call1.param1;
						--PortProxy
						paramconn6: parameter pp1 -> call1.param1;
						--InternalFeature
						paramconn7: parameter eds1 -> call1.param1;
						--Feature
						paramconn8: parameter af1 -> call1.param1;
						--FeatureGroup
						paramconn9: parameter fg1 -> call1.param1;
						--Access
						paramconn10: parameter ba1 -> call1.param1;
						--DataAccess
						paramconn11: parameter da1 -> call1.param2;
						--Port
						paramconn12: parameter ep1 -> call1.param1;
						--DataPort
						paramconn13: parameter dp1 -> call1.param1;
						--EventDataPort
						paramconn14: parameter edp1 -> call1.param1;
						
						--DataPort.BusSubcomponent
						paramconn15: parameter dp1.bsub2 -> call1.param1;
						--DataPort.DataSubcomponent
						paramconn16: parameter dp1.dsub4 -> call1.param2;
						--DataPort.SubprogramGroupSubcomponent
						paramconn17: parameter dp1.subpgsub2 -> call1.param1;
						--DataPort.SubprogramSubcomponent
						paramconn18: parameter dp1.subpsub3 -> call1.param1;
						--DataPort.SubprogramProxy
						paramconn19: parameter dp1.sp3 -> call1.param1;
						--DataPort.PortProxy
						paramconn20: parameter dp1.pp3 -> call1.param1;
						--DataPort.InternalFeature
						paramconn21: parameter dp1.eds3 -> call1.param1;
						--DataPort.Feature
						paramconn22: parameter dp1.af3 -> call1.param1;
						--DataPort.FeatureGroup
						paramconn23: parameter dp1.fg3 -> call1.param1;
						--DataPort.Access
						paramconn24: parameter dp1.ba2 -> call1.param1;
						--DataPort.DataAccess
						paramconn25: parameter dp1.da3 -> call1.param2;
						--DataPort.Port
						paramconn26: parameter dp1.ep5 -> call1.param1;
						--DataPort.DataPort
						paramconn27: parameter dp1.dp3 -> call1.param2;
						--DataPort.EventDataPort
						paramconn28: parameter dp1.edp6 -> call1.param2;
						
						--EventDataPort.BusSubcomponent
						paramconn29: parameter edp1.bsub2 -> call1.param1;
						--EventDataPort.DataSubcomponent
						paramconn30: parameter edp1.dsub4 -> call1.param2;
						--EventDataPort.SubprogramGroupSubcomponent
						paramconn31: parameter edp1.subpgsub2 -> call1.param1;
						--EventDataPort.SubprogramSubcomponent
						paramconn32: parameter edp1.subpsub3 -> call1.param1;
						--EventDataPort.SubprogramProxy
						paramconn33: parameter edp1.sp3 -> call1.param1;
						--EventDataPort.PortProxy
						paramconn34: parameter edp1.pp3 -> call1.param1;
						--EventDataPort.InternalFeature
						paramconn35: parameter edp1.eds3 -> call1.param1;
						--EventDataPort.Feature
						paramconn36: parameter edp1.af3 -> call1.param1;
						--EventDataPort.FeatureGroup
						paramconn37: parameter edp1.fg3 -> call1.param1;
						--EventDataPort.Access
						paramconn38: parameter edp1.ba2 -> call1.param1;
						--EventDataPort.DataAccess
						paramconn39: parameter edp1.da3 -> call1.param2;
						--EventDataPort.Port
						paramconn40: parameter edp1.ep5 -> call1.param1;
						--EventDataPort.DataPort
						paramconn41: parameter edp1.dp3 -> call1.param2;
						--EventDataPort.EventDataPort
						paramconn42: parameter edp1.edp6 -> call1.param2;
						
						--FeatureGroup.Feature
						paramconn43: parameter fg1.af4 -> call1.param1;
						--FeatureGroup.FeatureGroup
						paramconn44: parameter fg1.fg4 -> call1.param1;
						--FeatureGroup.Parameter
						paramconn45: parameter fg1.param3 -> call1.param2;
						--FeatureGroup.Access
						paramconn46: parameter fg1.ba4 -> call1.param1;
						--FeatureGroup.DataAccess
						paramconn47: parameter fg1.da5 -> call1.param2;
						--FeatureGroup.Port
						paramconn48: parameter fg1.ep7 -> call1.param1;
						--FeatureGroup.DataPort
						paramconn49: parameter fg1.dp6 -> call1.param2;
						--FeatureGroup.EventDataPort
						paramconn50: parameter fg1.edp7 -> call1.param2;
						
						--Subcomponent.BusSubcomponent
						paramconn51: parameter asub1.bsub2 -> call1.param1;
						--Subcomponent.DataSubcomponent
						paramconn52: parameter asub1.dsub4 -> call1.param2;
						--Subcomponent.SubprogramGroupSubcomponent
						paramconn53: parameter asub1.subpgsub2 -> call1.param1;
						--Subcomponent.SubprogramSubcomponent
						paramconn54: parameter asub1.subpsub3 -> call1.param1;
						--Subcomponent.SubprogramProxy
						paramconn55: parameter asub1.sp3 -> call1.param1;
						--Subcomponent.PortProxy
						paramconn56: parameter asub1.pp3 -> call1.param1;
						--Subcomponent.InternalFeature
						paramconn57: parameter asub1.eds3 -> call1.param1;
						--Subcomponent.Feature
						paramconn58: parameter asub1.af3 -> call1.param1;
						--Subcomponent.FeatureGroup
						paramconn59: parameter asub1.fg3 -> call1.param1;
						--Subcomponent.Parameter
						paramconn60: parameter subpsub1.param1 -> call1.param1;
						--Subcomponent.Access
						paramconn61: parameter asub1.ba2 -> call1.param1;
						--Subcomponent.DataAccess
						paramconn62: parameter asub1.da3 -> call1.param2;
						--Subcomponent.Port
						paramconn63: parameter asub1.ep5 -> call1.param1;
						--Subcomponent.DataPort
						paramconn64: parameter asub1.dp3 -> call1.param2;
						--Subcomponent.EventDataPort
						paramconn65: parameter asub1.edp6 -> call1.param2;
						
						--SubprogramCall.DataSubcomponent
						paramconn66: parameter call1.dsub3 -> call1.param2;
						--SubprogramCall.SubprogramSubcomponent
						paramconn67: parameter call1.subpsub2 -> call1.param1;
						--SubprogramCall.SubprogramProxy
						paramconn68: parameter call1.sp2 -> call1.param1;
						--SubprogramCall.PortProxy
						paramconn69: parameter call1.pp2 -> call1.param1;
						--SubprogramCall.InternalFeature
						paramconn70: parameter call1.eds2 -> call1.param1;
						--SubprogramCall.Feature
						paramconn71: parameter call1.af2 -> call1.param1;
						--SubprogramCall.FeatureGroup
						paramconn72: parameter call1.fg2 -> call1.param1;
						--SubprogramCall.Parameter
						paramconn73: parameter call1.param1 -> call1.param1;
						--SubprogramCall.Access
						paramconn74: parameter call1.subpa1 -> call1.param1;
						--SubprogramCall.DataAccess
						paramconn75: parameter call1.da2 -> call1.param2;
						--SubprogramCall.Port
						paramconn76: parameter call1.ep3 -> call1.param1;
						--SubprogramCall.EventDataPort
						paramconn77: parameter call1.edp4 -> call1.param2;
						
						
						
						--PortConnections
						--PortConnections
						--PortConnections
						--PortConnections
						
						
						
						--BusSubcomponent
						portconn1: port bsub1 -> asub1.dp3;
						--DataSubcomponent
						portconn2: port dsub1 -> asub1.dp3;
						--SubprogramGroupSubcomponent
						portconn3: port subpgsub1 -> asub1.dp3;
						--SubprogramSubcomponent
						portconn4: port subpsub1 -> asub1.dp3;
						--SubprogramProxy
						portconn5: port sp1 -> asub1.dp3;
						--PortProxy
						portconn6: port processor.pp1 -> asub1.dp3;
						--InternalFeature
						portconn7: port self.eds1 -> asub1.dp3;
						--Feature
						portconn8: port af1 -> asub1.dp3;
						--FeatureGroup
						portconn9: port fg1 -> asub1.dp3;
						--Access
						portconn10: port ba1 -> asub1.dp3;
						--DataAccess
						portconn11: port da1 -> asub1.dp3;
						--Port
						portconn12: port ep1 -> asub1.ep5;
						--DataPort
						portconn13: port dp2 -> asub1.dp3;
						--EventDataPort
						portconn14: port edp3 -> asub1.dp3;
						
						--DataPort.BusSubcomponent
						portconn15: port dp1.bsub2 -> asub1.dp3;
						--DataPort.DataSubcomponent
						portconn16: port dp1.dsub4 -> asub1.dp3;
						--DataPort.SubprogramGroupSubcomponent
						portconn17: port dp1.subpgsub2 -> asub1.dp3;
						--DataPort.SubprogramSubcomponent
						portconn18: port dp1.subpsub3 -> asub1.dp3;
						--DataPort.SubprogramProxy
						portconn19: port dp1.sp3 -> asub1.dp3;
						--DataPort.PortProxy
						portconn20: port dp1.pp3 -> asub1.dp3;
						--DataPort.InternalFeature
						portconn21: port dp1.eds3 -> asub1.dp3;
						--DataPort.Feature
						portconn22: port dp1.af3 -> asub1.dp3;
						--DataPort.FeatureGroup
						portconn23: port dp1.fg3 -> asub1.dp3;
						--DataPort.Access
						portconn24: port dp1.ba2 -> asub1.dp3;
						--DataPort.DataAccess
						portconn25: port dp1.da3 -> asub1.dp3;
						--DataPort.Port
						portconn26: port dp1.ep5 -> asub1.ep5;
						--DataPort.DataPort
						portconn27: port dp1.dp3 -> asub1.dp3;
						--DataPort.EventDataPort
						portconn28: port dp1.edp6 -> asub1.dp3;
						
						--EventDataPort.BusSubcomponent
						portconn29: port edp1.bsub2 -> asub1.dp3;
						--EventDataPort.DataSubcomponent
						portconn30: port edp1.dsub4 -> asub1.dp3;
						--EventDataPort.SubprogramGroupSubcomponent
						portconn31: port edp1.subpgsub2 -> asub1.dp3;
						--EventDataPort.SubprogramSubcomponent
						portconn32: port edp1.subpsub3 -> asub1.dp3;
						--EventDataPort.SubprogramProxy
						portconn33: port edp1.sp3 -> asub1.dp3;
						--EventDataPort.PortProxy
						portconn34: port edp1.pp3 -> asub1.dp3;
						--EventDataPort.InternalFeature
						portconn35: port edp1.eds3 -> asub1.dp3;
						--EventDataPort.Feature
						portconn36: port edp1.af3 -> asub1.dp3;
						--EventDataPort.FeatureGroup
						portconn37: port edp1.fg3 -> asub1.dp3;
						--EventDataPort.Access
						portconn38: port edp1.ba2 -> asub1.dp3;
						--EventDataPort.DataAccess
						portconn39: port edp1.da3 -> asub1.dp3;
						--EventDataPort.Port
						portconn40: port edp1.ep5 -> asub1.ep5;
						--EventDataPort.DataPort
						portconn41: port edp1.dp3 -> asub1.dp3;
						--EventDataPort.EventDataPort
						portconn42: port edp1.edp6 -> asub1.dp3;
						
						--FeatureGroup.Feature
						portconn43: port fg1.af4 -> asub1.dp3;
						--FeatureGroup.FeatureGroup
						portconn44: port fg1.fg4 -> asub1.dp3;
						--FeatureGroup.Parameter
						portconn45: port fg1.param3 -> asub1.dp3;
						--FeatureGroup.Access
						portconn46: port fg1.ba4 -> asub1.dp3;
						--FeatureGroup.DataAccess
						portconn47: port fg1.da5 -> asub1.dp3;
						--FeatureGroup.Port
						portconn48: port fg1.ep7 -> asub1.ep5;
						--FeatureGroup.DataPort
						portconn49: port fg1.dp6 -> asub1.dp3;
						--FeatureGroup.EventDataPort
						portconn50: port fg1.edp7 -> asub1.dp3;
						
						--Subcomponent.BusSubcomponent
						portconn51: port asub1.bsub2 -> asub1.dp3;
						--Subcomponent.DataSubcomponent
						portconn52: port asub1.dsub4 -> asub1.dp3;
						--Subcomponent.SubprogramGroupSubcomponent
						portconn53: port asub1.subpgsub2 -> asub1.dp3;
						--Subcomponent.SubprogramSubcomponent
						portconn54: port asub1.subpsub3 -> asub1.dp3;
						--Subcomponent.SubprogramProxy
						portconn55: port asub1.sp3 -> asub1.dp3;
						--Subcomponent.PortProxy
						portconn56: port asub1.pp3 -> asub1.dp3;
						--Subcomponent.InternalFeature
						portconn57: port asub1.eds3 -> asub1.dp3;
						--Subcomponent.Feature
						portconn58: port asub1.af3 -> asub1.dp3;
						--Subcomponent.FeatureGroup
						portconn59: port asub1.fg3 -> asub1.dp3;
						--Subcomponent.Parameter
						portconn60: port subpsub1.param1 -> asub1.dp3;
						--Subcomponent.Access
						portconn61: port asub1.ba2 -> asub1.dp3;
						--Subcomponent.DataAccess
						portconn62: port asub1.da3 -> asub1.dp3;
						--Subcomponent.Port
						portconn63: port asub1.ep6 -> asub1.ep5;
						--Subcomponent.DataPort
						portconn64: port asub1.dp4 -> asub1.dp3;
						--Subcomponent.EventDataPort
						portconn65: port asub1.edp6 -> asub1.dp4;
						
						--DataSubcomponent.BusSubcomponent
						portconn66: port dsub2.bsub2 -> asub1.dp3;
						--DataSubcomponent.DataSubcomponent
						portconn67: port dsub2.dsub4 -> asub1.dp3;
						--DataSubcomponent.SubprogramGroupSubcomponent
						portconn68: port dsub2.subpgsub2 -> asub1.dp3;
						--DataSubcomponent.SubprogramSubcomponent
						portconn69: port dsub2.subpsub3 -> asub1.dp3;
						--DataSubcomponent.SubprogramProxy
						portconn70: port dsub2.sp3 -> asub1.dp3;
						--DataSubcomponent.PortProxy
						portconn71: port dsub2.pp3 -> asub1.dp3;
						--DataSubcomponent.InternalFeature
						portconn72: port dsub2.eds3 -> asub1.dp3;
						--DataSubcomponent.Feature
						portconn73: port dsub2.af3 -> asub1.dp3;
						--DataSubcomponent.FeatureGroup
						portconn74: port dsub2.fg3 -> asub1.dp3;
						--DataSubcomponent.Access
						portconn75: port dsub2.ba2 -> asub1.dp3;
						--DataSubcomponent.DataAccess
						portconn76: port dsub2.da3 -> asub1.dp3;
						--DataSubcomponent.Port
						portconn77: port dsub2.ep5 -> asub1.ep6;
						--DataSubcomponent.DataPort
						portconn78: port dsub2.dp3 -> asub1.dp4;
						--DataSubcomponent.EventDataPort
						portconn79: port dsub2.edp6 -> asub1.dp4;
						
						--SubprogramCall.DataSubcomponent
						portconn80: port call1.dsub3 -> asub1.dp5;
						--SubprogramCall.SubprogramSubcomponent
						portconn81: port call1.subpsub2 -> asub1.dp3;
						--SubprogramCall.SubprogramProxy
						portconn82: port call1.sp2 -> asub1.dp3;
						--SubprogramCall.PortProxy
						portconn83: port call1.pp2 -> asub1.dp5;
						--SubprogramCall.InternalFeature
						portconn84: port call1.eds2 -> asub1.dp5;
						--SubprogramCall.Feature
						portconn85: port call1.af2 -> asub1.dp3;
						--SubprogramCall.FeatureGroup
						portconn86: port call1.fg2 -> asub1.dp3;
						--SubprogramCall.Parameter
						portconn87: port call1.param1 -> asub1.dp3;
						--SubprogramCall.Access
						portconn88: port call1.subpa1 -> asub1.dp3;
						--SubprogramCall.DataAccess
						portconn89: port call1.da2 -> asub1.dp5;
						--SubprogramCall.Port
						portconn90: port call1.ep4 -> ep2;
						--SubprogramCall.EventDataPort
						portconn91: port call1.edp5 -> edp2;
					end container.i;
					
					subprogram subpcontainer
					features
						param1: in out parameter a1.i;
						param2: in parameter d1;
						param5: out parameter;
						af2: feature;
						fg2: feature group;
						subpa1: requires subprogram access subpcontainer;
						da2: requires data access d1;
						ep3: out event port;
						ep4: out event port;
						edp4: out event data port d1;
						edp5: out event data port;
					flows
						--Parameter
						fsource18: flow source param5;
						
						--Parameter.DataAccess
						fsource19: flow source param1.da3;
						--Parameter.AbstractFeature
						fsource20: flow source param1.af3;
						--Parameter.FeatureGroup
						fsource21: flow source param1.fg3;
						--Parameter.Port
						fsource22: flow source param1.ep5;
					end subpcontainer;
					
					subprogram implementation subpcontainer.i
					subcomponents
						asub2: abstract a1;
						dsub3: data d1;
						subpsub2: subprogram subpcontainer;
					internal features
						eds2: event data;
					processor features
						sp2: subprogram subpcontainer;
						pp2: port;
					calls
						sequence2: {
							call2: subprogram subpcontainer;
						};
					connections
						--AccessConnections
						--AccessConnections
						--AccessConnections
						--AccessConnections
						
						
						
						--Parameter
						aconn78: data access param1 <-> asub2.da3;
						
						--Parameter.BusSubcomponent
						aconn79: bus access param1.bsub2 <-> asub2.ba2;
						--Parameter.DataSubcomponent
						aconn80: data access param1.dsub4 <-> asub2.da3;
						--Parameter.SubprogramGroupSubcomponent
						aconn81: subprogram group access param1.subpgsub2 <-> asub2.subpga1;
						--Parameter.SubprogramSubcomponent
						aconn82: subprogram access param1.subpsub3 <-> asub2.subpa2;
						--Parameter.SubprogramProxy
						aconn83: subprogram access param1.sp3 <-> asub2.subpa2;
						--Parameter.PortProxy
						aconn84: data access param1.pp3 <-> asub2.da3;
						--Parameter.InternalFeature
						aconn85: data access param1.eds3 <-> asub2.da3;
						--Parameter.Feature
						aconn86: data access param1.af3 <-> asub2.da3;
						--Parameter.FeatureGroup
						aconn87: data access param1.fg3 <-> asub2.da3;
						--Parameter.Access
						aconn88: bus access param1.ba2 <-> asub2.ba2;
						--Parameter.DataAccess
						aconn89: data access param1.da3 <-> asub2.da3;
						--Parameter.Port
						aconn90: data access param1.ep5 <-> asub2.da3;
						--Parameter.DataPort
						aconn91: data access param1.dp3 <-> asub2.da3;
						--Parameter.EventDataPort
						aconn92: data access param1.edp6 <-> asub2.da3;
						
						
						
						--FeatureConnections
						--FeatureConnections
						--FeatureConnections
						--FeatureConnections
						
						
						
						--Parameter
						fconn78: feature param1 <-> asub2.af3;
						
						--Parameter.BusSubcomponent
						fconn79: feature param1.bsub2 <-> asub2.af3;
						--Parameter.DataSubcomponent
						fconn80: feature param1.dsub4 <-> asub2.af3;
						--Parameter.SubprogramGroupSubcomponent
						fconn81: feature param1.subpgsub2 <-> asub2.af3;
						--Parameter.SubprogramSubcomponent
						fconn82: feature param1.subpsub3 <-> asub2.af3;
						--Parameter.SubprogramProxy
						fconn83: feature param1.sp3 <-> asub2.af3;
						--Parameter.PortProxy
						fconn84: feature param1.pp3 <-> asub2.af3;
						--Parameter.InternalFeature
						fconn85: feature param1.eds3 <-> asub2.af3;
						--Parameter.Feature
						fconn86: feature param1.af3 <-> asub2.af3;
						--Parameter.FeatureGroup
						fconn87: feature param1.fg3 <-> asub2.af3;
						--Parameter.Access
						fconn88: feature param1.ba2 <-> asub2.af3;
						--Parameter.DataAccess
						fconn89: feature param1.da3 <-> asub2.af3;
						--Parameter.Port
						fconn90: feature param1.ep5 <-> asub2.af3;
						--Parameter.DataPort
						fconn91: feature param1.dp3 <-> asub2.af3;
						--Parameter.EventDataPort
						fconn92: feature param1.edp6 <-> asub2.af3;
						
						
						
						--FeatureGroupConnections
						--FeatureGroupConnections
						--FeatureGroupConnections
						--FeatureGroupConnections
						
						
						
						--Parameter
						fgconn78: feature group param1 <-> asub2.fg3;
						
						--Parameter.BusSubcomponent
						fgconn79: feature group param1.bsub2 <-> asub2.fg3;
						--Parameter.DataSubcomponent
						fgconn80: feature group param1.dsub4 <-> asub2.fg3;
						--Parameter.SubprogramGroupSubcomponent
						fgconn81: feature group param1.subpgsub2 <-> asub2.fg3;
						--Parameter.SubprogramSubcomponent
						fgconn82: feature group param1.subpsub3 <-> asub2.fg3;
						--Parameter.SubprogramProxy
						fgconn83: feature group param1.sp3 <-> asub2.fg3;
						--Parameter.PortProxy
						fgconn84: feature group param1.pp3 <-> asub2.fg3;
						--Parameter.InternalFeature
						fgconn85: feature group param1.eds3 <-> asub2.fg3;
						--Parameter.Feature
						fgconn86: feature group param1.af3 <-> asub2.fg3;
						--Parameter.FeatureGroup
						fgconn87: feature group param1.fg3 <-> asub2.fg3;
						--Parameter.Access
						fgconn88: feature group param1.ba2 <-> asub2.fg3;
						--Parameter.DataAccess
						fgconn89: feature group param1.da3 <-> asub2.fg3;
						--Parameter.Port
						fgconn90: feature group param1.ep5 <-> asub2.fg3;
						--Parameter.DataPort
						fgconn91: feature group param1.dp3 <-> asub2.fg3;
						--Parameter.EventDataPort
						fgconn92: feature group param1.edp6 <-> asub2.fg3;
						
						
						
						--ParameterConnections
						--ParameterConnections
						--ParameterConnections
						--ParameterConnections
						
						
						
						--Parameter
						paramconn78: parameter param1 -> call2.param1;
						
						--Parameter.BusSubcomponent
						paramconn79: parameter param1.bsub2 -> param1;
						--Parameter.DataSubcomponent
						paramconn80: parameter param1.dsub4 -> param2;
						--Parameter.SubprogramGroupSubcomponent
						paramconn81: parameter param1.subpgsub2 -> param1;
						--Parameter.SubprogramSubcomponent
						paramconn82: parameter param1.subpsub3 -> param1;
						--Parameter.SubprogramProxy
						paramconn83: parameter param1.sp3 -> param1;
						--Parameter.PortProxy
						paramconn84: parameter param1.pp3 -> param1;
						--Parameter.InternalFeature
						paramconn85: parameter param1.eds3 -> param1;
						--Parameter.Feature
						paramconn86: parameter param1.af3 -> param1;
						--Parameter.FeatureGroup
						paramconn87: parameter param1.fg3 -> param1;
						--Parameter.Access
						paramconn88: parameter param1.ba2 -> param1;
						--Parameter.DataAccess
						paramconn89: parameter param1.da3 -> param2;
						--Parameter.Port
						paramconn90: parameter param1.ep5 -> param1;
						--Parameter.DataPort
						paramconn91: parameter param1.dp3 -> param2;
						--Parameter.EventDataPort
						paramconn92: parameter param1.edp6 -> param2;
						
						
						
						--PortConnections
						--PortConnections
						--PortConnections
						--PortConnections
						
						
						
						--Parameter
						portconn92: port param1 -> asub2.dp3;
						
						--Parameter.BusSubcomponent
						portconn93: port param1.bsub2 -> asub2.dp3;
						--Parameter.DataSubcomponent
						portconn94: port param1.dsub4 -> asub2.dp3;
						--Parameter.SubprogramGroupSubcomponent
						portconn95: port param1.subpgsub2 -> asub2.dp3;
						--Parameter.SubprogramSubcomponent
						portconn96: port param1.subpsub3 -> asub2.dp3;
						--Parameter.SubprogramProxy
						portconn97: port param1.sp3 -> asub2.dp3;
						--Parameter.PortProxy
						portconn98: port param1.pp3 -> asub2.dp3;
						--Parameter.InternalFeature
						portconn99: port param1.eds3 -> asub2.dp3;
						--Parameter.Feature
						portconn100: port param1.af3 -> asub2.dp3;
						--Parameter.FeatureGroup
						portconn101: port param1.fg3 -> asub2.dp3;
						--Parameter.Access
						portconn102: port param1.ba2 -> asub2.dp3;
						--Parameter.DataAccess
						portconn103: port param1.da3 -> asub2.dp3;
						--Parameter.Port
						portconn104: port param1.ep5 -> asub2.ep5;
						--Parameter.DataPort
						portconn105: port param1.dp3 -> asub2.dp3;
						--Parameter.EventDataPort
						portconn106: port param1.edp6 -> asub2.dp3;
					end subpcontainer.i;
					
					abstract a1
					features
						da3: requires data access d1;
						da4: provides data access d1;
						ba2: requires bus access;
						ba3: provides bus access;
						subpga1: requires subprogram group access;
						subpa2: requires subprogram access subpcontainer;
						af3: feature;
						fg3: feature group;
						ep5: in out event port;
						ep6: in out event port;
						dp3: in out data port d1;
						dp4: in out data port d1;
						dp5: in out data port d1;
						edp6: in out event data port d1;
					end a1;
					
					abstract implementation a1.i
					subcomponents
						asub3: abstract;
						bsub2: bus;
						dsub4: data d1;
						subpgsub2: subprogram group;
						subpsub3: subprogram subpcontainer;
					internal features
						eds3: event data;
					processor features
						pp3: port;
						sp3: subprogram subpcontainer;
					end a1.i;
					
					feature group fgt1
					features
						af4: feature;
						fg4: feature group;
						ba4: requires bus access;
						da5: requires data access d1;
						ep7: in event port;
						ep8: out event port;
						dp6: in data port d1;
						edp7: in event data port d1;
						param3: in parameter d1;
						param4: out parameter;
					end fgt1;
					
					data d1
					end d1;
				end legalTypeTest;
			'''

		suppressSerialization
		val testFileResult = issues = testHelper.testString(legalTypeTest)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"legalTypeTest".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"container".assertEquals(name)
				ownedFlowSpecifications.get(4) => [
					"fsource5".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(5) => [
					"fsource6".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(6) => [
					"fsource7".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(7) => [
					"fsource8".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(8) => [
					"fsource9".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(9) => [
					"fsource10".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(10) => [
					"fsource11".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(11) => [
					"fsource12".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid flow specification feature.")
				]
			]
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"container.i".assertEquals(name)
				ownedDataSubcomponents.get(1) => [
					"dsub2".assertEquals(name)
					//Not specifically testing for these errors, but the assert is here for completeness.  See comment on dsub2 for why these errors are here.
					assertError(testFileResult.issues, issueCollection,
						"A data subcomponent cannot refer to an abstract implementation that contains a bus subcomponent.",
						"A data subcomponent cannot refer to an abstract implementation that contains a subprogram group subcomponent.",
						"A data subcomponent cannot refer to an abstract type that contains a provides data access.",
						"A data subcomponent cannot refer to an abstract type that contains a requires data access.",
						"A data subcomponent cannot refer to an abstract type that contains a provides bus access.",
						"A data subcomponent cannot refer to an abstract type that contains a requires bus access.",
						"A data subcomponent cannot refer to an abstract type that contains an in out data port.",
						"A data subcomponent cannot refer to an abstract type that contains an in out event port.",
						"A data subcomponent cannot refer to an abstract type that contains an in out event data port."
					)
				]
				ownedAccessConnections.get(5) => [
					"aconn6".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' is not a valid access connection end.")
				]
				ownedAccessConnections.get(6) => [
					"aconn7".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' is not a valid access connection end.")
				]
				ownedAccessConnections.get(7) => [
					"aconn8".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' is not a valid access connection end.")
				]
				ownedAccessConnections.get(8) => [
					"aconn9".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' is not a valid access connection end.")
				]
				ownedAccessConnections.get(11) => [
					"aconn12".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(12) => [
					"aconn13".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(13) => [
					"aconn14".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(14) => [
					"aconn15".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(15) => [
					"aconn16".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(16) => [
					"aconn17".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(17) => [
					"aconn18".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(18) => [
					"aconn19".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(19) => [
					"aconn20".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(20) => [
					"aconn21".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(21) => [
					"aconn22".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(22) => [
					"aconn23".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(23) => [
					"aconn24".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(24) => [
					"aconn25".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(25) => [
					"aconn26".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(26) => [
					"aconn27".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(27) => [
					"aconn28".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(28) => [
					"aconn29".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(29) => [
					"aconn30".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(30) => [
					"aconn31".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(31) => [
					"aconn32".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(32) => [
					"aconn33".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(33) => [
					"aconn34".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(34) => [
					"aconn35".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(35) => [
					"aconn36".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(36) => [
					"aconn37".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(37) => [
					"aconn38".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(38) => [
					"aconn39".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(39) => [
					"aconn40".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(40) => [
					"aconn41".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(41) => [
					"aconn42".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid access connection end.")
				]
				ownedAccessConnections.get(42) => [
					"aconn43".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'feature group' is not a valid access connection end.")
				]
				ownedAccessConnections.get(43) => [
					"aconn44".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'feature group' is not a valid access connection end.")
				]
				ownedAccessConnections.get(44) => [
					"aconn45".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'feature group' is not a valid access connection end.")
				]
				ownedAccessConnections.get(47) => [
					"aconn48".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'feature group' is not a valid access connection end.")
				]
				ownedAccessConnections.get(48) => [
					"aconn49".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in a 'feature group' is not a valid access connection end.")
				]
				ownedAccessConnections.get(49) => [
					"aconn50".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in a 'feature group' is not a valid access connection end.")
				]
				ownedAccessConnections.get(50) => [
					"aconn51".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in an 'abstract subcomponent' is not a valid access connection end.")
				]
//				ownedAccessConnections.get(51) => [
//					"aconn52".assertEquals(name)
//					//Tests typeCheckAccessConnectionEnd
//					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' in an 'abstract subcomponent' is not a valid access connection end.")
//				]
				ownedAccessConnections.get(52) => [
					"aconn53".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(53) => [
					"aconn54".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(54) => [
					"aconn55".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(55) => [
					"aconn56".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(56) => [
					"aconn57".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(57) => [
					"aconn58".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(58) => [
					"aconn59".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(59) => [
					"aconn60".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(62) => [
					"aconn63".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(63) => [
					"aconn64".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(64) => [
					"aconn65".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in an 'abstract subcomponent' is not a valid access connection end.")
				]
				ownedAccessConnections.get(65) => [
					"aconn66".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(66) => [
					"aconn67".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(67) => [
					"aconn68".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(68) => [
					"aconn69".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(69) => [
					"aconn70".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(70) => [
					"aconn71".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(71) => [
					"aconn72".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(72) => [
					"aconn73".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(75) => [
					"aconn76".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedAccessConnections.get(76) => [
					"aconn77".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in a 'subprogram call' is not a valid access connection end.")
				]
				ownedFeatureConnections.get(0) => [
					"fconn1".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(1) => [
					"fconn2".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(2) => [
					"fconn3".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(3) => [
					"fconn4".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(4) => [
					"fconn5".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(14) => [
					"fconn15".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(15) => [
					"fconn16".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(16) => [
					"fconn17".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(17) => [
					"fconn18".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(18) => [
					"fconn19".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(19) => [
					"fconn20".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(20) => [
					"fconn21".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(21) => [
					"fconn22".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(22) => [
					"fconn23".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(23) => [
					"fconn24".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(24) => [
					"fconn25".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(25) => [
					"fconn26".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(26) => [
					"fconn27".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(27) => [
					"fconn28".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(28) => [
					"fconn29".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(29) => [
					"fconn30".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(30) => [
					"fconn31".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(31) => [
					"fconn32".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(32) => [
					"fconn33".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(33) => [
					"fconn34".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(34) => [
					"fconn35".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(35) => [
					"fconn36".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(36) => [
					"fconn37".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(37) => [
					"fconn38".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(38) => [
					"fconn39".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(39) => [
					"fconn40".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(40) => [
					"fconn41".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(41) => [
					"fconn42".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(50) => [
					"fconn51".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in an 'abstract subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(51) => [
					"fconn52".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' in an 'abstract subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(52) => [
					"fconn53".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in an 'abstract subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(53) => [
					"fconn54".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in an 'abstract subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(54) => [
					"fconn55".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in an 'abstract subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(55) => [
					"fconn56".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in an 'abstract subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(56) => [
					"fconn57".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in an 'abstract subcomponent' is not a valid feature connection end.")
				]
				// From fixing Issue 1954
				ownedFeatureConnections.get(59) => [
					"fconn60".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(65) => [
					"fconn66".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' in a 'subprogram call' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(66) => [
					"fconn67".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'subprogram call' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(67) => [
					"fconn68".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'subprogram call' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(68) => [
					"fconn69".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'subprogram call' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(69) => [
					"fconn70".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'subprogram call' is not a valid feature connection end.")
				]
				ownedFeatureGroupConnections.get(0) => [
					"fgconn1".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(1) => [
					"fgconn2".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(2) => [
					"fgconn3".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(3) => [
					"fgconn4".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(4) => [
					"fgconn5".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(5) => [
					"fgconn6".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(6) => [
					"fgconn7".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(7) => [
					"fgconn8".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(9) => [
					"fgconn10".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(10) => [
					"fgconn11".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(11) => [
					"fgconn12".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(12) => [
					"fgconn13".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(13) => [
					"fgconn14".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(14) => [
					"fgconn15".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(15) => [
					"fgconn16".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(16) => [
					"fgconn17".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(17) => [
					"fgconn18".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(18) => [
					"fgconn19".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(19) => [
					"fgconn20".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(20) => [
					"fgconn21".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(21) => [
					"fgconn22".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(22) => [
					"fgconn23".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(23) => [
					"fgconn24".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(24) => [
					"fgconn25".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(25) => [
					"fgconn26".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(26) => [
					"fgconn27".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(27) => [
					"fgconn28".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(28) => [
					"fgconn29".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(29) => [
					"fgconn30".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(30) => [
					"fgconn31".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(31) => [
					"fgconn32".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(32) => [
					"fgconn33".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(33) => [
					"fgconn34".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(34) => [
					"fgconn35".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(35) => [
					"fgconn36".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(36) => [
					"fgconn37".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(37) => [
					"fgconn38".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(38) => [
					"fgconn39".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(39) => [
					"fgconn40".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(40) => [
					"fgconn41".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(41) => [
					"fgconn42".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'event data port' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(42) => [
					"fgconn43".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'feature group' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(44) => [
					"fgconn45".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'feature group' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(45) => [
					"fgconn46".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in a 'feature group' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(46) => [
					"fgconn47".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in a 'feature group' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(47) => [
					"fgconn48".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'feature group' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(48) => [
					"fgconn49".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in a 'feature group' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(49) => [
					"fgconn50".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in a 'feature group' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(50) => [
					"fgconn51".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(51) => [
					"fgconn52".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(52) => [
					"fgconn53".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(53) => [
					"fgconn54".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(54) => [
					"fgconn55".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(55) => [
					"fgconn56".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(56) => [
					"fgconn57".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(57) => [
					"fgconn58".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(59) => [
					"fgconn60".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(60) => [
					"fgconn61".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(61) => [
					"fgconn62".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(62) => [
					"fgconn63".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(63) => [
					"fgconn64".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(64) => [
					"fgconn65".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in an 'abstract subcomponent' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(65) => [
					"fgconn66".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(66) => [
					"fgconn67".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(67) => [
					"fgconn68".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(68) => [
					"fgconn69".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(69) => [
					"fgconn70".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(70) => [
					"fgconn71".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(71) => [
					"fgconn72".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(72) => [
					"fgconn73".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(73) => [
					"fgconn74".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(74) => [
					"fgconn75".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(75) => [
					"fgconn76".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(76) => [
					"fgconn77".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram call' is not a valid feature group connection end.")
				]
				ownedParameterConnections.get(0) => [
					"paramconn1".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(2) => [
					"paramconn3".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(3) => [
					"paramconn4".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(4) => [
					"paramconn5".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(5) => [
					"paramconn6".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(6) => [
					"paramconn7".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(7) => [
					"paramconn8".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(8) => [
					"paramconn9".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(9) => [
					"paramconn10".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(11) => [
					"paramconn12".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(14) => [
					"paramconn15".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(16) => [
					"paramconn17".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(17) => [
					"paramconn18".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(18) => [
					"paramconn19".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(19) => [
					"paramconn20".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(20) => [
					"paramconn21".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(21) => [
					"paramconn22".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(22) => [
					"paramconn23".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(23) => [
					"paramconn24".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(24) => [
					"paramconn25".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(25) => [
					"paramconn26".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(26) => [
					"paramconn27".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(27) => [
					"paramconn28".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in a 'data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(28) => [
					"paramconn29".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(30) => [
					"paramconn31".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(31) => [
					"paramconn32".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(32) => [
					"paramconn33".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(33) => [
					"paramconn34".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(34) => [
					"paramconn35".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(35) => [
					"paramconn36".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(36) => [
					"paramconn37".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(37) => [
					"paramconn38".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(38) => [
					"paramconn39".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(39) => [
					"paramconn40".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(40) => [
					"paramconn41".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(41) => [
					"paramconn42".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in an 'event data port' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(42) => [
					"paramconn43".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'feature group' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(43) => [
					"paramconn44".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'feature group' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(45) => [
					"paramconn46".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in a 'feature group' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(47) => [
					"paramconn48".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'feature group' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(50) => [
					"paramconn51".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(51) => [
					"paramconn52".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(52) => [
					"paramconn53".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(53) => [
					"paramconn54".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(54) => [
					"paramconn55".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(55) => [
					"paramconn56".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(56) => [
					"paramconn57".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(57) => [
					"paramconn58".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(58) => [
					"paramconn59".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(59) => [
					"paramconn60".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'subprogram subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(60) => [
					"paramconn61".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(61) => [
					"paramconn62".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(62) => [
					"paramconn63".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(63) => [
					"paramconn64".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(64) => [
					"paramconn65".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in an 'abstract subcomponent' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(65) => [
					"paramconn66".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(66) => [
					"paramconn67".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(67) => [
					"paramconn68".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(68) => [
					"paramconn69".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(69) => [
					"paramconn70".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(70) => [
					"paramconn71".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(71) => [
					"paramconn72".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(73) => [
					"paramconn74".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram access' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(74) => [
					"paramconn75".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(75) => [
					"paramconn76".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(76) => [
					"paramconn77".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in a 'subprogram call' is not a valid parameter connection end.")
				]
				ownedPortConnections.get(0) => [
					"portconn1".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(2) => [
					"portconn3".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(3) => [
					"portconn4".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(4) => [
					"portconn5".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' is not a valid port connection end.")
				]
				ownedPortConnections.get(7) => [
					"portconn8".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' is not a valid port connection end.")
				]
				ownedPortConnections.get(8) => [
					"portconn9".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' is not a valid port connection end.")
				]
				ownedPortConnections.get(9) => [
					"portconn10".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' is not a valid port connection end.")
				]
				ownedPortConnections.get(14) => [
					"portconn15".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(15) => [
					"portconn16".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
				]
				ownedPortConnections.get(16) => [
					"portconn17".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(17) => [
					"portconn18".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(18) => [
					"portconn19".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(19) => [
					"portconn20".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(20) => [
					"portconn21".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(21) => [
					"portconn22".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(22) => [
					"portconn23".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(23) => [
					"portconn24".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(24) => [
					"portconn25".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(25) => [
					"portconn26".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(26) => [
					"portconn27".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(27) => [
					"portconn28".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in a 'data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(28) => [
					"portconn29".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(29) => [
					"portconn30".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
				]
				ownedPortConnections.get(30) => [
					"portconn31".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(31) => [
					"portconn32".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(32) => [
					"portconn33".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(33) => [
					"portconn34".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(34) => [
					"portconn35".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(35) => [
					"portconn36".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(36) => [
					"portconn37".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(37) => [
					"portconn38".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(38) => [
					"portconn39".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(39) => [
					"portconn40".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(40) => [
					"portconn41".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(41) => [
					"portconn42".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in an 'event data port' is not a valid port connection end.")
				]
				ownedPortConnections.get(42) => [
					"portconn43".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'feature group' is not a valid port connection end.")
				]
				ownedPortConnections.get(43) => [
					"portconn44".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'feature group' is not a valid port connection end.")
				]
				ownedPortConnections.get(44) => [
					"portconn45".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'feature group' is not a valid port connection end.")
				]
				ownedPortConnections.get(45) => [
					"portconn46".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in a 'feature group' is not a valid port connection end.")
				]
				ownedPortConnections.get(50) => [
					"portconn51".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(51) => [
					"portconn52".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data subcomponent' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(52) => [
					"portconn53".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(53) => [
					"portconn54".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(54) => [
					"portconn55".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(55) => [
					"portconn56".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(56) => [
					"portconn57".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(57) => [
					"portconn58".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(58) => [
					"portconn59".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(59) => [
					"portconn60".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(60) => [
					"portconn61".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in an 'abstract subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(65) => [
					"portconn66".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(67) => [
					"portconn68".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(68) => [
					"portconn69".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(69) => [
					"portconn70".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(70) => [
					"portconn71".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(71) => [
					"portconn72".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(72) => [
					"portconn73".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(73) => [
					"portconn74".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(74) => [
					"portconn75".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in a 'data subcomponent' is not a valid port connection end.")
				]
				ownedPortConnections.get(80) => [
					"portconn81".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'subprogram call' is not a valid port connection end.")
				]
				ownedPortConnections.get(81) => [
					"portconn82".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'subprogram call' is not a valid port connection end.")
				]
				ownedPortConnections.get(82) => [
					"portconn83".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'subprogram call' is not a valid port connection end.")
				]
				ownedPortConnections.get(83) => [
					"portconn84".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'subprogram call' is not a valid port connection end.")
				]
				ownedPortConnections.get(84) => [
					"portconn85".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'subprogram call' is not a valid port connection end.")
				]
				ownedPortConnections.get(85) => [
					"portconn86".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'subprogram call' is not a valid port connection end.")
				]
				ownedPortConnections.get(86) => [
					"portconn87".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' in a 'subprogram call' is not a valid port connection end.")
				]
				ownedPortConnections.get(87) => [
					"portconn88".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram access' in a 'subprogram call' is not a valid port connection end.")
				]
			]
			publicSection.ownedClassifiers.get(2) as SubprogramType => [
				"subpcontainer".assertEquals(name)
				ownedFlowSpecifications.get(1) => [
					"fsource19".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(2) => [
					"fsource20".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(3) => [
					"fsource21".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid flow specification feature.")
				]
				ownedFlowSpecifications.get(4) => [
					"fsource22".assertEquals(name)
					//Tests checkFlowFeatureType
					outEnd.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid flow specification feature.")
				]
			]
			publicSection.ownedClassifiers.get(3) as SubprogramImplementation => [
				"subpcontainer.i".assertEquals(name)
				ownedAccessConnections.get(0) => [
					"aconn78".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(1) => [
					"aconn79".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(2) => [
					"aconn80".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(3) => [
					"aconn81".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(4) => [
					"aconn82".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(5) => [
					"aconn83".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(6) => [
					"aconn84".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(7) => [
					"aconn85".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(8) => [
					"aconn86".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(9) => [
					"aconn87".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(10) => [
					"aconn88".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(11) => [
					"aconn89".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(12) => [
					"aconn90".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(13) => [
					"aconn91".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedAccessConnections.get(14) => [
					"aconn92".assertEquals(name)
					//Tests typeCheckAccessConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid access connection end.")
				]
				ownedFeatureConnections.get(1) => [
					"fconn79".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(2) => [
					"fconn80".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(3) => [
					"fconn81".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(4) => [
					"fconn82".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(5) => [
					"fconn83".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(6) => [
					"fconn84".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(7) => [
					"fconn85".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(8) => [
					"fconn86".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(9) => [
					"fconn87".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(10) => [
					"fconn88".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(11) => [
					"fconn89".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(12) => [
					"fconn90".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(13) => [
					"fconn91".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureConnections.get(14) => [
					"fconn92".assertEquals(name)
					//Tests typeCheckFeatureConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature connection end.")
				]
				ownedFeatureGroupConnections.get(0) => [
					"fgconn78".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(1) => [
					"fgconn79".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(2) => [
					"fgconn80".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(3) => [
					"fgconn81".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(4) => [
					"fgconn82".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(5) => [
					"fgconn83".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(6) => [
					"fgconn84".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(7) => [
					"fgconn85".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(8) => [
					"fgconn86".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(9) => [
					"fgconn87".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(10) => [
					"fgconn88".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(11) => [
					"fgconn89".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(12) => [
					"fgconn90".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(13) => [
					"fgconn91".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedFeatureGroupConnections.get(14) => [
					"fgconn92".assertEquals(name)
					//Tests typeCheckFeatureGroupConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid feature group connection end.")
				]
				ownedParameterConnections.get(1) => [
					"paramconn79".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus subcomponent' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(3) => [
					"paramconn81".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram group subcomponent' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(4) => [
					"paramconn82".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram subcomponent' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(5) => [
					"paramconn83".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'subprogram proxy' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(6) => [
					"paramconn84".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'port proxy' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(7) => [
					"paramconn85".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data source' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(8) => [
					"paramconn86".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'abstract feature' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(9) => [
					"paramconn87".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'feature group' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(10) => [
					"paramconn88".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'bus access' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(11) => [
					"paramconn89".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data access' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(12) => [
					"paramconn90".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event port' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(13) => [
					"paramconn91".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'data port' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedParameterConnections.get(14) => [
					"paramconn92".assertEquals(name)
					//Tests typeCheckParameterConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "An 'event data port' in a 'parameter' is not a valid parameter connection end.")
				]
				ownedPortConnections.get(0) => [
					"portconn92".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "A 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(1) => [
					"portconn93".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(2) => [
					"portconn94".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(3) => [
					"portconn95".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(4) => [
					"portconn96".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(5) => [
					"portconn97".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(6) => [
					"portconn98".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(7) => [
					"portconn99".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(8) => [
					"portconn100".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(9) => [
					"portconn101".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(10) => [
					"portconn102".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(11) => [
					"portconn103".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(12) => [
					"portconn104".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(13) => [
					"portconn105".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
				ownedPortConnections.get(14) => [
					"portconn106".assertEquals(name)
					//Tests typeCheckPortConnectionEnd
					source.assertError(testFileResult.issues, issueCollection, "Anything in a 'parameter' is not a valid port connection end.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}