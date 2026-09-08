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
package org.osate.aadl2.errormodel.tests.errormodelscopeprovider;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Verifies repair and recover event-initiator scopes for library and classifier contexts.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class EventInitiatorTest extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;
	private AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.emv2")).<AssertHelper>get(AssertHelper.class);

	/**
	 * Tests scope_RepairEvent_eventInitiator(Classifier, EReference),
	 * scope_RepairEvent_eventInitiator(ErrorBehaviorStateMachine, EReference),
	 * scope_RecoverEvent_eventInitiator(Classifier, EReference), and
	 * scope_RecoverEvent_eventInitiator(ErrorBehaviorStateMachine, EReference)
	 */
	@Test
	public void testEventInitiatorReference() throws Exception {
		var lib1 = """
				package lib1
				public
				\tannex EMV2 {**
				\t\terror behavior bvr1
				\t\tevents
				\t\t\trepair_evt1: repair event;
				\t\t\trecover_evt1: recover event;
				\t\tend behavior;
				\t**};
				end lib1;
				""";
		var subclause1 = """
				package subclause1
				public
				\tabstract a1
				\tprototypes
				\t\taproto1: abstract;
				\t\tbproto1: bus;
				\t\tdproto1: data;
				\t\tdevproto1: device;
				\t\tmproto1: memory;
				\t\tprocproto1: processor;
				\t\tpsproto1: process;
				\t\tsubpgproto1: subprogram group;
				\t\tsubpproto1: subprogram;
				\t\tsproto1: system;
				\t\ttgproto1: thread group;
				\t\ttproto1: thread;
				\t\tvbproto1: virtual bus;
				\t\tvpproto1: virtual processor;
				\t\tfgproto1: feature group;
				\t\tfproto1: feature;
				\tfeatures
				\t\tba1: provides bus access;
				\t\tda1: provides data access;
				\t\tsubpa1: provides subprogram access;
				\t\tsubpga1: provides subprogram group access;
				\t\taf1: feature;
				\t\tfg1: feature group;
				\t\tdp1: in data port;
				\t\tedp1: in event data port;
				\t\tep1: in event port;
				\tflows
				\t\tsource1: flow source af1;
				\t\tsink1: flow sink af1;
				\t\tpath1: flow path af1 -> af1;
				\tmodes
				\t\tm1: initial mode;
				\t\tm2: mode;
				\t\tmt1: m1 -[ ep1 ]-> m2;
				\tend a1;
				\t
				\tabstract implementation a1.i
				\tsubcomponents
				\t\tasub1: abstract a1;
				\t\tbsub1: bus;
				\t\tdsub1: data;
				\t\tdevsub1: device;
				\t\tmsub1: memory;
				\t\tprocsub1: processor;
				\t\tpssub1: process;
				\t\tsubpgsub1: subprogram group;
				\t\tsubpsub1: subprogram;
				\t\tssub1: system;
				\t\ttgsub1: thread group;
				\t\ttsub1: thread;
				\t\tvbsub1: virtual bus;
				\t\tvpsub1: virtual processor;
				\tinternal features
				\t\tes1: event;
				\t\teds1: event data;
				\tprocessor features
				\t\tpp1: port;
				\t\tsp1: subprogram;
				\tcalls
				\t\tseq1: {
				\t\t\tcall1: subprogram subp1;
				\t\t};
				\tconnections
				\t\tconn1: bus access ba1 -> asub1.ba1;
				\t\tconn2: feature af1 -> asub1.af1;
				\t\tconn3: feature group fg1 -> asub1.fg1;
				\t\tconn4: parameter dp1 -> call1.param1;
				\t\tconn5: port ep1 -> asub1.ep1;
				\tflows
				\t\tetef1: end to end flow asub1.source1 -> conn2 -> asub1.sink1;
				\tend a1.i;
				\t
				\tabstract a2 extends a1
				\tend a2;
				\t
				\tabstract implementation a2.i extends a1.i
				\tannex EMV2 {**
				\t\tcomponent error behavior
				\t\tevents
				\t\t\trepair_evt2: repair event when ep1;
				\t\t\trecover_evt2: recover event when ep1;
				\t\tend component;
				\t**};
				\tend a2.i;
				\t
				\tsubprogram subp1
				\tfeatures
				\t\tparam1: in parameter;
				\t\tep2: out event port;
				\tannex EMV2 {**
				\t\tcomponent error behavior
				\t\tevents
				\t\t\trepair_evt3: repair event when ep2;
				\t\t\trecover_evt3: recover event when ep2;
				\t\tend component;
				\t**};
				\tend subp1;
				end subclause1;
				""";
		var aadlPackage = this.testHelper.parseString(lib1);
		Assert.assertEquals("lib1", aadlPackage.getName());
		var errorBehaviorStateMachine = (((ErrorModelLibrary) ((DefaultAnnexLibrary) (aadlPackage.getPublicSection()
				.getOwnedAnnexLibraries()).getFirst()).getParsedAnnexLibrary()).getBehaviors()).getFirst();
		Assert.assertEquals("bvr1", errorBehaviorStateMachine.getName());
		var errorBehaviorEvent5 = errorBehaviorStateMachine.getEvents().get(0);
		Assert.assertEquals("repair_evt1", errorBehaviorEvent5.getName());
		this.assertHelper.assertScope(errorBehaviorEvent5, ErrorModelPackage.eINSTANCE.getRepairEvent_EventInitiator(),
				Set.of());
		var errorBehaviorEvent6 = errorBehaviorStateMachine.getEvents().get(1);
		Assert.assertEquals("recover_evt1", errorBehaviorEvent6.getName());
		this.assertHelper.assertScope(errorBehaviorEvent6, ErrorModelPackage.eINSTANCE.getRecoverEvent_EventInitiator(),
				Set.of());

		var aadlPackage2 = this.testHelper.parseString(subclause1, lib1);
		Assert.assertEquals("subclause1", aadlPackage2.getName());
		var classifier = aadlPackage2.getPublicSection().getOwnedClassifiers().get(3);
		Assert.assertEquals("a2.i", classifier.getName());
		var errorModelSubclause = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause());
		final List<String> expectedScope = List.of("aproto1", "bproto1", "dproto1", "devproto1", "mproto1",
				"procproto1", "psproto1", "subpgproto1", "subpproto1", "sproto1", "tgproto1", "tproto1", "vbproto1",
				"vpproto1", "fgproto1", "fproto1", "ba1", "da1", "subpa1", "subpga1", "af1", "fg1", "dp1", "edp1",
				"ep1", "source1", "sink1", "path1", "m1", "m2", "mt1", "asub1", "bsub1", "dsub1", "devsub1", "msub1",
				"procsub1", "pssub1", "subpgsub1", "subpsub1", "ssub1", "tgsub1", "tsub1", "vbsub1", "vpsub1", "es1",
				"eds1", "pp1", "sp1", "seq1", "call1", "conn1", "conn2", "conn3", "conn4", "conn5", "etef1");
		var errorBehaviorEvent = errorModelSubclause.getEvents().get(0);
		Assert.assertEquals("repair_evt2", errorBehaviorEvent.getName());
		this.assertHelper.assertScope(errorBehaviorEvent, ErrorModelPackage.eINSTANCE.getRepairEvent_EventInitiator(),
				expectedScope);
		var errorBehaviorEvent2 = errorModelSubclause.getEvents().get(1);
		Assert.assertEquals("recover_evt2", errorBehaviorEvent2.getName());
		this.assertHelper.assertScope(errorBehaviorEvent2, ErrorModelPackage.eINSTANCE.getRecoverEvent_EventInitiator(),
				expectedScope);
		var classifier2 = aadlPackage2.getPublicSection().getOwnedClassifiers().get(4);
		Assert.assertEquals("subp1", classifier2.getName());
		var errorModelSubclause2 = ((ErrorModelSubclause) ((DefaultAnnexSubclause) (classifier2
				.getOwnedAnnexSubclauses()).getFirst()).getParsedAnnexSubclause());
		final List<String> expectedScope2 = List.of("param1", "ep2");
		var errorBehaviorEvent3 = errorModelSubclause2.getEvents().get(0);
		Assert.assertEquals("repair_evt3", errorBehaviorEvent3.getName());
		this.assertHelper.assertScope(errorBehaviorEvent3, ErrorModelPackage.eINSTANCE.getRepairEvent_EventInitiator(),
				expectedScope2);
		var errorBehaviorEvent4 = errorModelSubclause2.getEvents().get(1);
		Assert.assertEquals("recover_evt3", errorBehaviorEvent4.getName());
		this.assertHelper.assertScope(errorBehaviorEvent4, ErrorModelPackage.eINSTANCE.getRecoverEvent_EventInitiator(),
				expectedScope2);

	}
}
