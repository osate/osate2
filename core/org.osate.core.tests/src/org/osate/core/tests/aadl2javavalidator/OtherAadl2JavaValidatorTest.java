/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.core.tests.aadl2javavalidator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.BusType;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.UnitsType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class OtherAadl2JavaValidatorTest extends XtextTest {
	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	// Tests checkFlowConnectionOrder
	@Test
	public void testFlowSegmentTypes() throws Exception {
		var aadlText = """
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
						--fconn1: feature af1 -> af1;
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
						--asub2: abstract;
						asub2: abstract a2;
					connections
						--fconn3: feature af2 -> af2;
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("legalFlowSegmentsTypeTest", pkg.getName());
		var abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("a1.i", abstractImplementation.getName());
		var flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(0);
		assertEquals("fpath1", flowImplementation.getSpecification().getName());
		var flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("fconn1", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "The source of connection 'fconn1' does not match the in flow feature 'af1'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(1);
		assertEquals("fpath2", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("da1", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "Expected Connection, found Data Access 'da1'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(2);
		assertEquals("fpath3", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("fpath1", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "Expected Connection, found Flow Specification 'fpath1'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(3);
		assertEquals("fpath4", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("asub1", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "Expected Connection, found Abstract Subcomponent 'asub1'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(4);
		assertEquals("fsource1", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("fconn1", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Connection 'fconn1'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(6);
		assertEquals("fsource3", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("fsource1", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Flow Specification 'fsource1'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(7);
		assertEquals("fsource4", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("asub1", flowSegment.getFlowElement().getName());
		// Tests checkFlowSubcomponentFlow
		assertError(flowSegment, "Connection 'fconn2' continues inside subcomponent 'asub1'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(8);
		assertEquals("fsource5", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("dp1", flowSegment.getContext().getName());
		assertEquals("fconn3", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Feature Connection 'dp1.fconn3'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(9);
		assertEquals("fsource6", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("dp1", flowSegment.getContext().getName());
		assertEquals("da2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Data Access 'dp1.da2'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(10);
		assertEquals("fsource7", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("dp1", flowSegment.getContext().getName());
		assertEquals("fsource22", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Flow Specification 'dp1.fsource22'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(11);
		assertEquals("fsource8", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("dp1", flowSegment.getContext().getName());
		assertEquals("asub2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Data Port.Abstract Subcomponent 'dp1.asub2'");
		flowSegment = flowImplementation.getOwnedFlowSegments().get(1);
		assertEquals("fconn2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub2'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(12);
		assertEquals("fsource9", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("edp1", flowSegment.getContext().getName());
		assertEquals("fconn3", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Feature Connection 'edp1.fconn3'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(13);
		assertEquals("fsource10", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("edp1", flowSegment.getContext().getName());
		assertEquals("da2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Data Access 'edp1.da2'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(14);
		assertEquals("fsource11", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("edp1", flowSegment.getContext().getName());
		assertEquals("fsource22", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Flow Specification 'edp1.fsource22'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(15);
		assertEquals("fsource12", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("edp1", flowSegment.getContext().getName());
		assertEquals("asub2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Event Data Port.Abstract Subcomponent 'edp1.asub2'");
		flowSegment = flowImplementation.getOwnedFlowSegments().get(1);
		assertEquals("fconn2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub2'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(16);
		assertEquals("fsource13", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("fg1", flowSegment.getContext().getName());
		assertEquals("da4", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Feature Group.Data Access 'fg1.da4'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(17);
		assertEquals("fsource14", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("asub1", flowSegment.getContext().getName());
		assertEquals("fconn3", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Abstract Subcomponent.Feature Connection 'asub1.fconn3'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(18);
		assertEquals("fsource15", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("asub1", flowSegment.getContext().getName());
		assertEquals("da2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Abstract Subcomponent.Data Access 'asub1.da2'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(20);
		assertEquals("fsource17", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("asub1", flowSegment.getContext().getName());
		assertEquals("asub2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Abstract Subcomponent.Abstract Subcomponent 'asub1.asub2'");
		flowSegment = flowImplementation.getOwnedFlowSegments().get(1);
		assertEquals("fconn2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub2'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(21);
		assertEquals("fsource18", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("call1", flowSegment.getContext().getName());
		assertEquals("fconn4", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Feature Connection 'call1.fconn4'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(22);
		assertEquals("fsource19", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("call1", flowSegment.getContext().getName());
		assertEquals("da3", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Data Access 'call1.da3'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(23);
		assertEquals("fsource20", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("call1", flowSegment.getContext().getName());
		assertEquals("fsource23", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Flow Specification 'call1.fsource23'");
		flowSegment = flowImplementation.getOwnedFlowSegments().get(1);
		assertEquals("fconn2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"The source of connection 'fconn2' does not match the out flow feature of the preceding subcomponent flow specification 'call1.fsource23'");
		flowImplementation = abstractImplementation.getOwnedFlowImplementations().get(24);
		assertEquals("fsource21", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("call1", flowSegment.getContext().getName());
		assertEquals("asub3", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Subprogram Call.Abstract Subcomponent 'call1.asub3'");
		flowSegment = flowImplementation.getOwnedFlowSegments().get(1);
		assertEquals("fconn2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "The source of connection 'fconn2' does not match the preceding subcomponent 'asub3'");
		var subprogramImplementation = (SubprogramImplementation) pkg.getPublicSection().getOwnedClassifiers().get(5);
		assertEquals("subp1.i", subprogramImplementation.getName());
		flowImplementation = subprogramImplementation.getOwnedFlowImplementations().get(0);
		assertEquals("fsource23", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("param1", flowSegment.getContext().getName());
		assertEquals("asub2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Abstract Subcomponent 'param1.asub2'");
		flowSegment = flowImplementation.getOwnedFlowSegments().get(1);
		assertEquals("fconn4", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "The source of connection 'fconn4' does not match the preceding subcomponent 'asub2'");
		flowImplementation = subprogramImplementation.getOwnedFlowImplementations().get(1);
		assertEquals("fsource24", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("param1", flowSegment.getContext().getName());
		assertEquals("da2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Data Access 'param1.da2'");
		flowImplementation = subprogramImplementation.getOwnedFlowImplementations().get(2);
		assertEquals("fsource25", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("param1", flowSegment.getContext().getName());
		assertEquals("fsource22", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Flow Specification 'param1.fsource22'");
		flowImplementation = subprogramImplementation.getOwnedFlowImplementations().get(3);
		assertEquals("fsource26", flowImplementation.getSpecification().getName());
		flowSegment = flowImplementation.getOwnedFlowSegments().get(0);
		assertEquals("param1", flowSegment.getContext().getName());
		assertEquals("asub2", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment,
				"Expected Data Access, Subcomponent, or Subcomponent.Flow Specification; found Parameter.Abstract Subcomponent 'param1.asub2'");
		flowSegment = flowImplementation.getOwnedFlowSegments().get(1);
		assertEquals("fconn4", flowSegment.getFlowElement().getName());
		// Tests checkFlowConnectionOrder
		assertError(flowSegment, "The source of connection 'fconn4' does not match the preceding subcomponent 'asub2'");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests typeCheckModeTransitionTrigger
	@Test
	public void testModeTransitionTriggerTypes() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("legalTypeTest", pkg.getName());
		var abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("a1.i", abstractImplementation.getName());
		var modeTransition = abstractImplementation.getOwnedModeTransitions().getFirst();
		assertEquals("mt1", modeTransition.getName());
		var trigger = modeTransition.getOwnedTriggers().get(4);
		assertEquals("dp1", trigger.getContext().getName());
		assertEquals("af2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(5);
		assertEquals("dp1", trigger.getContext().getName());
		assertEquals("es2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(6);
		assertEquals("dp1", trigger.getContext().getName());
		assertEquals("ep1", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(7);
		assertEquals("dp1", trigger.getContext().getName());
		assertEquals("pp2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(8);
		assertEquals("edp1", trigger.getContext().getName());
		assertEquals("af2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in an 'event data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(9);
		assertEquals("edp1", trigger.getContext().getName());
		assertEquals("es2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in an 'event data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(10);
		assertEquals("edp1", trigger.getContext().getName());
		assertEquals("ep1", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in an 'event data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(11);
		assertEquals("edp1", trigger.getContext().getName());
		assertEquals("pp2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in an 'event data port' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(15);
		assertEquals("asub1", trigger.getContext().getName());
		assertEquals("es2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "An 'event source' in Abstract Subcomponent is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(17);
		assertEquals("asub1", trigger.getContext().getName());
		assertEquals("pp2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "A 'port proxy' in Abstract Subcomponent is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(19);
		assertEquals("call1", trigger.getContext().getName());
		assertEquals("es3", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "An 'event source' in Subprogram Call is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(21);
		assertEquals("call1", trigger.getContext().getName());
		assertEquals("pp3", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "A 'port proxy' in Subprogram Call is not a valid mode transition trigger.");
		var subprogramImplementation = (SubprogramImplementation) pkg.getPublicSection().getOwnedClassifiers().get(6);
		assertEquals("subp1.i", subprogramImplementation.getName());
		modeTransition = subprogramImplementation.getOwnedModeTransitions().getFirst();
		assertEquals("mt2", modeTransition.getName());
		trigger = modeTransition.getOwnedTriggers().get(0);
		assertEquals("param1", trigger.getContext().getName());
		assertEquals("af2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'parameter' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(1);
		assertEquals("param1", trigger.getContext().getName());
		assertEquals("es2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'parameter' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(2);
		assertEquals("param1", trigger.getContext().getName());
		assertEquals("ep1", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'parameter' is not a valid mode transition trigger.");
		trigger = modeTransition.getOwnedTriggers().get(3);
		assertEquals("param1", trigger.getContext().getName());
		assertEquals("pp2", trigger.getTriggerPort().getName());
		// Tests typeCheckModeTransitionTrigger
		assertError(trigger, "Anything in a 'parameter' is not a valid mode transition trigger.");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests caseUnitLiteral
	@Test
	public void testUnitLiterals() throws Exception {
		var aadlText = """
				property set ps is
					ut1: type units (ul1, ul2 => ul1 * 10, ul3 => ul4 * 10, ul4 => ul4 * 10);
				end ps;
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var propertySet = (PropertySet) testFileResult.getResource().getContents().getFirst();
		assertEquals("ps", propertySet.getName());
		var unitsType = (UnitsType) propertySet.getOwnedPropertyTypes().getFirst();
		assertEquals("ut1", unitsType.getName());
		var literal = unitsType.getOwnedLiterals().get(2);
		assertEquals("ul3", literal.getName());
		// Tests caseUnitLiteral
		assertError(literal, "'ul4' is not declared before 'ul3'");
		literal = unitsType.getOwnedLiterals().get(3);
		assertEquals("ul4", literal.getName());
		// Tests caseUnitLiteral
		assertError(literal, "'ul4' cannot be its own base unit");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests checkArraySizeIsAadlintegerNoUnits
	@Test
	public void testArraySizeIsAadlintegerNoUnits() throws Exception {
		var aadlText = """
				package testArraySize
				public
				  abstract a
				  features
				    p: in data port [Max_Time];
				  end a;
				end testArraySize;
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testArraySize", pkg.getName());
		var abstractType = (AbstractType) pkg.getPublicSection().getOwnedClassifiers().get(0);
		assertEquals("a", abstractType.getName());
		var dataPort = abstractType.getOwnedDataPorts().get(0);
		assertEquals("p", dataPort.getName());
		assertError(dataPort.getArrayDimensions().getFirst().getSize(),
				"Array size should only be an Integer type with no units");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests for duplicate elements ignoring case
	@Test
	public void testDuplicateElementIgnoreCase() throws Exception {
		var aadlText = """
				package duplicateTest
				public
					bus b
					end b;
					bus B
					end B;
				end duplicateTest;
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("duplicateTest", pkg.getName());
		var busType = (BusType) pkg.getPublicSection().getOwnedClassifiers().get(0);
		assertEquals("b", busType.getName());
		assertError(busType, "Duplicate Element 'b' in PublicPackageSection 'duplicateTest_public'");
		busType = (BusType) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("B", busType.getName());
		assertError(busType, "Duplicate Element 'B' in PublicPackageSection 'duplicateTest_public'");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests for validating references to internal features and processor features
	@Test
	public void testCheckReferencesToInternalFeatures() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("pkgTestInternalProcessorFeatures", pkg.getName());
		var abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		assertEquals("a.i", abstractImplementation.getName());
		// checkReferencesToInternalFeatures
		var connection = abstractImplementation.getOwnedConnections().get(1);
		assertEquals("conn2", connection.getName());
		assertError(connection.getSource(), "Only processor features may follow the keyword 'processor'");
		// checkReferencesToInternalFeatures
		connection = abstractImplementation.getOwnedConnections().get(3);
		assertEquals("conn4", connection.getName());
		assertError(connection.getSource(), "Only internal features may follow the keyword 'self'");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests for validation for ComponentImplementationReference list
	@Test
	public void testCheckSubcomponentImplementationReferenceList() throws Exception {
		var aadlText1 = """
				property set ps2 is
					const1: constant aadlinteger => 2 ;
				end ps2;
				""";
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText, aadlText1);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		// checkSubcomponentImplementationReferenceList
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testcompimplreflist", pkg.getName());
		var abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("a.i1", abstractImplementation.getName());
		var busSubcomponent = abstractImplementation.getOwnedBusSubcomponents().getFirst();
		assertEquals("bsub0", busSubcomponent.getName());
		assertWarning(busSubcomponent, "List of implementation reference not fully implemented in instantiator.");
		busSubcomponent = abstractImplementation.getOwnedBusSubcomponents().get(1);
		assertEquals("bsub1", busSubcomponent.getName());
		assertWarning(busSubcomponent, "List of implementation reference not fully implemented in instantiator.");
		assertError(busSubcomponent, "Size of component implementation reference list not the same as array size.");
		busSubcomponent = abstractImplementation.getOwnedBusSubcomponents().get(2);
		assertEquals("bsub2", busSubcomponent.getName());
		assertWarning(busSubcomponent, "List of implementation reference not fully implemented in instantiator.");
		assertError(busSubcomponent,
				"Implementation reference list not allowed when the subcomponent classifier is not a component type.");
		busSubcomponent = abstractImplementation.getOwnedBusSubcomponents().get(3);
		assertEquals("bsub3", busSubcomponent.getName());
		assertWarning(busSubcomponent, "List of implementation reference not fully implemented in instantiator.");
		/*
		 * The array size became a constant, so this no longer reports "Array size cannot be a property if
		 * implementation reference list is defined." on the array dimension.
		 */
		busSubcomponent = abstractImplementation.getOwnedBusSubcomponents().get(4);
		assertEquals("bsub4", busSubcomponent.getName());
		assertWarning(busSubcomponent, "List of implementation reference not fully implemented in instantiator.");
		assertError(busSubcomponent.getImplementationReferences().getFirst(),
				"Implementation reference not of the specified type.");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests validation of feature group type declared as inverse
	@Test
	public void testCheckFeaturesInInverseFeatureGroupType() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		// checkSubcomponentImplementationReferenceList
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testfeaturegroupinverse", pkg.getName());
		var featureGroupType = (FeatureGroupType) pkg.getPublicSection().getOwnedElements().get(1);
		assertEquals("fg2", featureGroupType.getName());
		var busAccess = featureGroupType.getOwnedBusAccesses().getFirst();
		assertEquals("b2", busAccess.getName());
		assertError(busAccess, "Feature Group feature access kind is same as that of its inverse");
		var dataPort = featureGroupType.getOwnedDataPorts().getFirst();
		assertEquals("d2", dataPort.getName());
		assertError(dataPort, "Feature Group feature direction not opposite that of its inverse");
		featureGroupType = (FeatureGroupType) pkg.getPublicSection().getOwnedElements().get(2);
		assertEquals("fg3", featureGroupType.getName());
		assertError(featureGroupType, "Feature Group features list count differs from that of its inverse");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests validation of ModalElement missing mode values
	@Test
	public void testCheckModalElementMissingModeValues() throws Exception {
		var aadlText1 = """
				property set psmemmv is
					def1: aadlstring => 'z' applies to (all);
				end psmemmv;
				""";
		var aadlText = """
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
							--conn1: feature af1->af2 {psmemmv::def1 => "g" in modes(m3);} in modes(m1, m2);
							conn1: feature asub1.af3->af2 {psmemmv::def1 => "g" in modes(m3);} in modes(m1, m2);
							--conn2: feature af1->af2 {psmemmv::def1 => "g" in modes(m1);} in modes(m1, m2);
							conn2: feature asub1.af3->af2 {psmemmv::def1 => "g" in modes(m1);} in modes(m1, m2);
							--conn3: feature af1->af2 {psmemmv::def1 => "g" in modes(m1); };
							conn3: feature asub1.af3->af2 {psmemmv::def1 => "g" in modes(m1); };
					end s1.i;
					abstract a1
						features
							af3: feature;
					end a1;
				end testmemissingmodevalues;
				""";
		testFileResult = issues = testHelper.testString(aadlText, aadlText1);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testmemissingmodevalues", pkg.getName());
		var systemImplementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("s1.i", systemImplementation.getName());
		var connection = systemImplementation.getOwnedConnections().getFirst();
		assertEquals("conn1", connection.getName());
		var association = connection.getOwnedPropertyAssociations().getFirst();
		var value = association.getOwnedValues().getFirst();
		assertError(value, "m3 is not a valid mode because it is not in the modes defined for container conn1");
		connection = systemImplementation.getOwnedConnections().get(1);
		assertEquals("conn2", connection.getName());
		association = connection.getOwnedPropertyAssociations().getFirst();
		assertWarning(association, "Value not set for mode m2 for property psmemmv::def1");
		connection = systemImplementation.getOwnedConnections().get(2);
		assertEquals("conn3", connection.getName());
		association = connection.getOwnedPropertyAssociations().getFirst();
		assertWarning(association, "Value not set for mode m2 for property psmemmv::def1",
				"Value not set for mode m3 for property psmemmv::def1");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests validation of flow implementation in and out complies with specification
	@Test
	public void testCheckFlowPathElements() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		// checkFlowPathElements
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testCheckFlowPathElements", pkg.getName());
		var systemImplementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().getFirst();
		assertEquals("S.i", systemImplementation.getName());
		var flowImplementation = systemImplementation.getOwnedFlowImplementations().get(1);
		assertEquals("fl2", flowImplementation.getSpecification().getName());
		assertWarning(flowImplementation, "Flow implementation is empty and does not add value to the model");
		flowImplementation = systemImplementation.getOwnedFlowImplementations().get(2);
		assertEquals("fl3", flowImplementation.getSpecification().getName());
		assertWarning(flowImplementation, "Flow implementation is empty and does not add value to the model");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests validation of FeatureGroup Connections
	// particularly when feature groups are inverted features
	@Test
	public void testCheckFeatureGroupConnectionDirection() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		// checkFeatureGroupConnectionDirection
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testfgconndirection", pkg.getName());
		var systemImplementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(5);
		assertEquals("sys2.i", systemImplementation.getName());
		var connection = systemImplementation.getOwnedConnections().get(1);
		assertEquals("c2", connection.getName());
		assertError(connection.getSource(),
				"Feature inner.fg1.o1 must not be in due to the direction of the connection");
		assertError(connection.getDestination(),
				"Feature i.fg1.o1 must not be in due to the direction of the connection");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests validation of ComponentType Features and Prototypes including where refinement is used
	@Test
	public void testCheckComponentTypeUniqueNames() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testtypeuniquenames", pkg.getName());
		var componentType = (ComponentType) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("s2", componentType.getName());
		var prototype = componentType.getOwnedPrototypes().getFirst();
		assertEquals("dp1", prototype.getName());
		assertError(prototype, "Duplicate identifiers 'dp1' in s2");
		prototype = componentType.getOwnedPrototypes().get(1);
		assertEquals("dp7", prototype.getName());
		assertError(prototype,
				"FeaturePrototype identifier 'dp7' previously defined in s1. Maybe you forgot 'refined to'");
		prototype = componentType.getOwnedPrototypes().get(2);
		assertEquals("dp11", prototype.getName());
		assertError(prototype, "DataPort identifier 'dp11' previously defined in s1");
		var mode = componentType.getOwnedModes().getFirst();
		assertEquals("m1", mode.getName());
		assertError(mode, "Mode identifier 'm1' previously defined.");
		var flowSpecification = componentType.getOwnedFlowSpecifications().getFirst();
		assertEquals("fsource1", flowSpecification.getName());
		assertError(flowSpecification,
				"FlowSpecification identifier 'fsource1' previously defined. Maybe you forgot 'refined to'");
		var feature = componentType.getOwnedFeatures().getFirst();
		assertEquals("dp1", feature.getName());
		assertError(feature, "Duplicate identifiers 'dp1' in s2");
		feature = componentType.getOwnedFeatures().get(1);
		assertEquals("dp2", feature.getName());
		assertError(feature, "DataPort identifier 'dp2' previously defined in s1. Maybe you forgot 'refined to'");
		feature = componentType.getOwnedFeatures().get(3);
		assertEquals("dp4", feature.getName());
		assertError(feature, "DataPort identifier 'dp4' previously defined in s1. Maybe you forgot 'refined to'");
		feature = componentType.getOwnedFeatures().get(5);
		assertEquals("dp6", feature.getName());
		assertError(feature, "EventPort identifier 'dp6' previously defined in s1");
		feature = componentType.getOwnedFeatures().get(6);
		assertEquals("dp12", feature.getName());
		assertError(feature, "FeaturePrototype identifier 'dp12' previously defined in s1");
		componentType = (ComponentType) pkg.getPublicSection().getOwnedClassifiers().get(3);
		assertEquals("s4", componentType.getName());
		feature = componentType.getOwnedFeatures().getFirst();
		assertEquals("dp3", feature.getName());
		assertError(feature, "DataPort identifier 'dp3' previously defined in s2. Maybe you forgot 'refined to'");
		feature = componentType.getOwnedFeatures().get(2);
		assertEquals("dp10", feature.getName());
		assertError(feature, "DataPort identifier 'dp10' previously defined in s1. Maybe you forgot 'refined to'");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests validation of ComponentType Features and Prototypes including where refinement is used
	@Test
	public void testCheckFeatureGroupTypeUniqueNames() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("testfguniquenames", pkg.getName());
		var featureGroupType = (FeatureGroupType) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals("fg2", featureGroupType.getName());
		var prototype = featureGroupType.getOwnedPrototypes().getFirst();
		assertEquals("af11", prototype.getName());
		assertError(prototype,
				"FeaturePrototype identifier 'af11' previously defined in fg1. Maybe you forgot 'refined to'");
		prototype = featureGroupType.getOwnedPrototypes().get(1);
		assertEquals("dp11", prototype.getName());
		assertError(prototype, "AbstractFeature identifier 'dp11' previously defined in fg1");
		var feature = featureGroupType.getOwnedFeatures().getFirst();
		assertEquals("dp1", feature.getName());
		assertError(feature, "Duplicate identifiers 'dp1' in fg2");
		feature = featureGroupType.getOwnedFeatures().get(1);
		assertEquals("dp1", feature.getName());
		assertError(feature, "Duplicate identifiers 'dp1' in fg2");
		feature = featureGroupType.getOwnedFeatures().get(2);
		assertEquals("dp2", feature.getName());
		assertError(feature, "DataPort identifier 'dp2' previously defined in fg1. Maybe you forgot 'refined to'");
		feature = featureGroupType.getOwnedFeatures().get(4);
		assertEquals("dp4", feature.getName());
		assertError(feature, "DataPort identifier 'dp4' previously defined in fg1. Maybe you forgot 'refined to'");
		feature = featureGroupType.getOwnedFeatures().get(6);
		assertEquals("dp6", feature.getName());
		assertError(feature, "EventPort identifier 'dp6' previously defined in fg1");
		feature = featureGroupType.getOwnedFeatures().get(7);
		assertEquals("dp12", feature.getName());
		assertError(feature, "FeaturePrototype identifier 'dp12' previously defined in fg1");
		featureGroupType = (FeatureGroupType) pkg.getPublicSection().getOwnedClassifiers().get(3);
		assertEquals("fg4", featureGroupType.getName());
		feature = featureGroupType.getOwnedFeatures().getFirst();
		assertEquals("dp3", feature.getName());
		assertError(feature, "DataPort identifier 'dp3' previously defined in fg2. Maybe you forgot 'refined to'");
		feature = featureGroupType.getOwnedFeatures().get(1);
		assertEquals("dp10", feature.getName());
		assertError(feature, "DataPort identifier 'dp10' previously defined in fg1. Maybe you forgot 'refined to'");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests validation of ComponentImplementation elements for unique names
	@Test
	public void testCheckComponentImplementationUniqueNames() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("componentimpluniquenames", pkg.getName());
		var abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		assertEquals("ab0.i1", abstractImplementation.getName());
		var mode = abstractImplementation.getOwnedModes().getFirst();
		assertEquals("m1", mode.getName());
		assertError(mode, "Identifier 'm1' has previously been defined in 'componentimpluniquenames::ab0'");
		abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		assertEquals("ab1.i1", abstractImplementation.getName());
		var prototype = abstractImplementation.getOwnedPrototypes().getFirst();
		assertEquals("dp3", prototype.getName());
		assertError(prototype,
				"DataPrototype identifier 'dp3' previously defined in ab1. Maybe you forgot 'refined to'");
		var subcomponent = abstractImplementation.getOwnedSubcomponents().getFirst();
		assertEquals("m1", subcomponent.getName());
		assertError(subcomponent, "Identifier 'm1' has previously been defined in 'componentimpluniquenames::ab0'");
		abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(4);
		assertEquals("ab1.i2", abstractImplementation.getName());
		prototype = abstractImplementation.getOwnedPrototypes().getFirst();
		assertEquals("dup1", prototype.getName());
		assertError(prototype, "Duplicate identifiers 'dup1' in ab1.i2");
		prototype = abstractImplementation.getOwnedPrototypes().get(1);
		assertEquals("dup1", prototype.getName());
		assertError(prototype, "Duplicate identifiers 'dup1' in ab1.i2");
		prototype = abstractImplementation.getOwnedPrototypes().get(2);
		assertEquals("dp3", prototype.getName());
		assertError(prototype,
				"DataPrototype identifier 'dp3' previously defined in ab1. Maybe you forgot 'refined to'");
		prototype = abstractImplementation.getOwnedPrototypes().get(4);
		assertEquals("dp99", prototype.getName());
		assertError(prototype, "Identifier 'dp99' has previously been defined in 'componentimpluniquenames::ab1'");
		prototype = abstractImplementation.getOwnedPrototypes().get(5);
		assertEquals("mt1", prototype.getName());
		assertError(prototype, "Identifier 'mt1' has previously been defined in 'componentimpluniquenames::ab1.i1'");
		subcomponent = abstractImplementation.getOwnedSubcomponents().getFirst();
		assertEquals("absub1", subcomponent.getName());
		assertError(subcomponent,
				"AbstractSubcomponent identifier 'absub1' previously defined in ab1.i1. Maybe you forgot 'refined to'");
		subcomponent = abstractImplementation.getOwnedSubcomponents().get(2);
		assertEquals("name1", subcomponent.getName());
		assertError(subcomponent, "Identifier 'name1' has previously been defined in 'componentimpluniquenames::ab1'");
		var connection = abstractImplementation.getOwnedConnections().getFirst();
		assertEquals("conn1", connection.getName());
		assertError(connection,
				"Connection 'conn1' has previously been defined in 'componentimpluniquenames::ab1.i1'. Maybe you forgot 'refined to'");
		connection = abstractImplementation.getOwnedConnections().get(2);
		assertEquals("conn3", connection.getName());
		assertError(connection, "Identifier 'conn3' has previously been defined in 'componentimpluniquenames::ab1.i1'");
		abstractImplementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(5);
		assertEquals("ab1.i3", abstractImplementation.getName());
		prototype = abstractImplementation.getOwnedPrototypes().getFirst();
		assertEquals("dp3", prototype.getName());
		assertError(prototype,
				"DataPrototype identifier 'dp3' previously defined in ab1. Maybe you forgot 'refined to'");
		prototype = abstractImplementation.getOwnedPrototypes().get(2);
		assertEquals("mt11", prototype.getName());
		assertError(prototype, "Identifier 'mt11' has previously been defined in 'componentimpluniquenames::ab1.i2'");
		subcomponent = abstractImplementation.getOwnedSubcomponents().getFirst();
		assertEquals("absub1", subcomponent.getName());
		assertError(subcomponent,
				"AbstractSubcomponent identifier 'absub1' previously defined in ab1.i2. Maybe you forgot 'refined to'");
		connection = abstractImplementation.getOwnedConnections().getFirst();
		assertEquals("conn1", connection.getName());
		assertError(connection,
				"Connection 'conn1' has previously been defined in 'componentimpluniquenames::ab1.i2'. Maybe you forgot 'refined to'");
		connection = abstractImplementation.getOwnedConnections().get(1);
		assertEquals("conn4", connection.getName());
		assertError(connection,
				"Connection 'conn4' has previously been defined in 'componentimpluniquenames::ab1.i2'. Maybe you forgot 'refined to'");
		mode = abstractImplementation.getOwnedModes().getFirst();
		assertEquals("m5", mode.getName());
		assertError(mode, "Mode 'm5' has previously been defined in 'componentimpluniquenames::ab1.i2'");
		var modeTransition = abstractImplementation.getOwnedModeTransitions().getFirst();
		assertEquals("mt10", modeTransition.getName());
		assertError(modeTransition,
				"Mode Transition 'mt10' has previously been defined in 'componentimpluniquenames::ab1.i2'");
		var subprogramImplementation = (SubprogramImplementation) pkg.getPublicSection().getOwnedClassifiers().get(11);
		assertEquals("subprog1.spi1", subprogramImplementation.getName());
		var callSequence = subprogramImplementation.getOwnedSubprogramCallSequences().getFirst();
		assertEquals("callseq1", callSequence.getName());
		assertError(callSequence, "Multiple sequences declared for non-modal implementation");
		var call = callSequence.getOwnedSubprogramCalls().getFirst();
		assertEquals("callspi2", call.getName());
		assertError(call, "Duplicate identifiers 'callspi2' in subprog1.spi1");
		call = callSequence.getOwnedSubprogramCalls().get(1);
		assertEquals("callspi2", call.getName());
		assertError(call, "Duplicate identifiers 'callspi2' in subprog1.spi1");
		call = callSequence.getOwnedSubprogramCalls().get(2);
		assertEquals("callspi3", call.getName());
		assertError(call, "Duplicate identifiers 'callspi3' in subprog1.spi1");
		callSequence = subprogramImplementation.getOwnedSubprogramCallSequences().get(1);
		assertEquals("callseq2", callSequence.getName());
		assertError(callSequence, "Multiple sequences declared for non-modal implementation");
		call = callSequence.getOwnedSubprogramCalls().getFirst();
		assertEquals("callspi3", call.getName());
		assertError(call, "Duplicate identifiers 'callspi3' in subprog1.spi1");
		callSequence = subprogramImplementation.getOwnedSubprogramCallSequences().get(2);
		assertEquals("callseq3", callSequence.getName());
		assertError(callSequence, "Duplicate identifiers 'callseq3' in subprog1.spi1",
				"Multiple sequences declared for non-modal implementation");
		callSequence = subprogramImplementation.getOwnedSubprogramCallSequences().get(3);
		assertEquals("callseq3", callSequence.getName());
		assertError(callSequence, "Duplicate identifiers 'callseq3' in subprog1.spi1",
				"Multiple sequences declared for non-modal implementation");
		callSequence = subprogramImplementation.getOwnedSubprogramCallSequences().get(4);
		assertEquals("callseq4", callSequence.getName());
		assertError(callSequence, "Multiple sequences declared for non-modal implementation");
		subprogramImplementation = (SubprogramImplementation) pkg.getPublicSection().getOwnedClassifiers().get(12);
		assertEquals("subprog1.spi3", subprogramImplementation.getName());
		callSequence = subprogramImplementation.getOwnedSubprogramCallSequences().getFirst();
		assertEquals("callseq5", callSequence.getName());
		assertError(callSequence, "Multiple sequences declared for non-modal implementation");
		call = callSequence.getOwnedSubprogramCalls().getFirst();
		assertEquals("callspi6", call.getName());
		assertError(call,
				"Identifier 'callspi6' has previously been defined in 'componentimpluniquenames::subprog1.spi1'");
		call = callSequence.getOwnedSubprogramCalls().get(1);
		assertEquals("dupename7", call.getName());
		assertError(call,
				"Identifier 'dupename7' has previously been defined in 'componentimpluniquenames::subprog1.spi1'");
		var systemImplementation = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(17);
		assertEquals("sys100.impl2", systemImplementation.getName());
		subcomponent = systemImplementation.getOwnedSubcomponents().getFirst();
		assertEquals("ete1", subcomponent.getName());
		assertError(subcomponent,
				"Identifier 'ete1' has previously been defined in 'componentimpluniquenames::sys100.impl1'");
		var endToEndFlow = systemImplementation.getOwnedEndToEndFlows().getFirst();
		assertEquals("ete2", endToEndFlow.getName());
		assertError(endToEndFlow,
				"End to end flow 'ete2' has previously been defined in 'componentimpluniquenames::sys100.impl1'. Maybe you forgot 'refined to'");
		endToEndFlow = systemImplementation.getOwnedEndToEndFlows().get(1);
		assertEquals("ete3", endToEndFlow.getName());
		assertError(endToEndFlow, "Duplicate identifiers 'ete3' in sys100.impl2");
		endToEndFlow = systemImplementation.getOwnedEndToEndFlows().get(2);
		assertEquals("ete3", endToEndFlow.getName());
		assertError(endToEndFlow, "Duplicate identifiers 'ete3' in sys100.impl2");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests checkComponentTypeModes(ComponentType)
	@Test
	public void testCheckComponentTypeModes() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("check_component_type_modes_test", pkg.getName());
		var publicSection = pkg.getPublicSection();
		var classifier = publicSection.getOwnedClassifiers().get(0);
		assertEquals("s1", classifier.getName());
		assertError(classifier, "One mode must be initial.");
		classifier = publicSection.getOwnedClassifiers().get(1);
		assertEquals("s2", classifier.getName());
		assertError(classifier, "Only one mode can be initial.");
		classifier = publicSection.getOwnedClassifiers().get(3);
		assertEquals("s4", classifier.getName());
		assertError(classifier, "Must be requires modes because requires modes are inherited.");
		var systemType = (SystemType) publicSection.getOwnedClassifiers().get(5);
		assertEquals("s6", systemType.getName());
		var mode = systemType.getOwnedModes().getFirst();
		assertEquals("m7", mode.getName());
		assertError(mode, "Initial mode not allowed because the initial mode is inherited.");
		classifier = publicSection.getOwnedClassifiers().get(6);
		assertEquals("s7", classifier.getName());
		assertError(classifier, "Must be modes because modes are inherited.");
		systemType = (SystemType) publicSection.getOwnedClassifiers().get(7);
		assertEquals("s8", systemType.getName());
		mode = systemType.getOwnedModes().getFirst();
		assertEquals("m9", mode.getName());
		assertError(mode, "Initial mode not allowed for requires modes.");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	// Tests checkComponentImplementationModes(ComponentImplementation)
	@Test
	public void testCheckComponentImplementationModes() throws Exception {
		var aadlText = """
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
				""";
		testFileResult = issues = testHelper.testString(aadlText);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();
		assertEquals("check_component_implementation_modes_test", pkg.getName());
		var publicSection = pkg.getPublicSection();
		var classifier = publicSection.getOwnedClassifiers().get(1);
		assertEquals("s1.i1", classifier.getName());
		assertError(classifier, "Modes subclause not allowed because type has requires modes.");
		var systemImplementation = (SystemImplementation) publicSection.getOwnedClassifiers().get(3);
		assertEquals("s2.i1", systemImplementation.getName());
		var mode = systemImplementation.getOwnedModes().getFirst();
		assertEquals("m4", mode.getName());
		assertError(mode, "Mode not allowed because type has modes.");
		systemImplementation = (SystemImplementation) publicSection.getOwnedClassifiers().get(6);
		assertEquals("s3.i2", systemImplementation.getName());
		mode = systemImplementation.getOwnedModes().getFirst();
		assertEquals("m6", mode.getName());
		assertError(mode, "Initial mode not allowed because the initial mode is inherited.");
		classifier = publicSection.getOwnedClassifiers().get(7);
		assertEquals("s3.i3", classifier.getName());
		assertError(classifier, "One mode must be initial.");
		classifier = publicSection.getOwnedClassifiers().get(8);
		assertEquals("s3.i4", classifier.getName());
		assertError(classifier, "Only one mode can be initial.");

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertError(EObject object, String... messages) {
		AssertHelper.assertError(object, testFileResult.getIssues(), issueCollection, messages);
	}

	private void assertWarning(EObject object, String... messages) {
		AssertHelper.assertWarning(object, testFileResult.getIssues(), issueCollection, messages);
	}
}
