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
package org.osate.aadl2.errormodel.tests.errormodelscopeprovider

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class EventInitiatorTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)

	/*
	 * Tests scope_RepairEvent_eventInitiator(Classifier, EReference),
	 * scope_RepairEvent_eventInitiator(ErrorBehaviorStateMachine, EReference),
	 * scope_RecoverEvent_eventInitiator(Classifier, EReference), and
	 * scope_RecoverEvent_eventInitiator(ErrorBehaviorStateMachine, EReference)
	 */
	@Test
	def void testEventInitiatorReference() {
		val lib1 = '''
			package lib1
			public
				annex EMV2 {**
					error behavior bvr1
					events
						repair_evt1: repair event;
						recover_evt1: recover event;
					end behavior;
				**};
			end lib1;
		'''
		val subclause1 = '''
			package subclause1
			public
				abstract a1
				prototypes
					aproto1: abstract;
					bproto1: bus;
					dproto1: data;
					devproto1: device;
					mproto1: memory;
					procproto1: processor;
					psproto1: process;
					subpgproto1: subprogram group;
					subpproto1: subprogram;
					sproto1: system;
					tgproto1: thread group;
					tproto1: thread;
					vbproto1: virtual bus;
					vpproto1: virtual processor;
					fgproto1: feature group;
					fproto1: feature;
				features
					ba1: provides bus access;
					da1: provides data access;
					subpa1: provides subprogram access;
					subpga1: provides subprogram group access;
					af1: feature;
					fg1: feature group;
					dp1: in data port;
					edp1: in event data port;
					ep1: in event port;
				flows
					source1: flow source af1;
					sink1: flow sink af1;
					path1: flow path af1 -> af1;
				modes
					m1: initial mode;
					m2: mode;
					mt1: m1 -[ ep1 ]-> m2;
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a1;
					bsub1: bus;
					dsub1: data;
					devsub1: device;
					msub1: memory;
					procsub1: processor;
					pssub1: process;
					subpgsub1: subprogram group;
					subpsub1: subprogram;
					ssub1: system;
					tgsub1: thread group;
					tsub1: thread;
					vbsub1: virtual bus;
					vpsub1: virtual processor;
				internal features
					es1: event;
					eds1: event data;
				processor features
					pp1: port;
					sp1: subprogram;
				calls
					seq1: {
						call1: subprogram subp1;
					};
				connections
					conn1: bus access ba1 -> asub1.ba1;
					conn2: feature af1 -> asub1.af1;
					conn3: feature group fg1 -> asub1.fg1;
					conn4: parameter dp1 -> call1.param1;
					conn5: port ep1 -> asub1.ep1;
				flows
					etef1: end to end flow asub1.source1 -> conn2 -> asub1.sink1;
				end a1.i;
				
				abstract a2 extends a1
				end a2;
				
				abstract implementation a2.i extends a1.i
				annex EMV2 {**
					component error behavior
					events
						repair_evt2: repair event when ep1;
						recover_evt2: recover event when ep1;
					end component;
				**};
				end a2.i;
				
				subprogram subp1
				features
					param1: in parameter;
					ep2: out event port;
				annex EMV2 {**
					component error behavior
					events
						repair_evt3: repair event when ep2;
						recover_evt3: recover event when ep2;
					end component;
				**};
				end subp1;
			end subclause1;
		'''
		testHelper.parseString(lib1) => [
			"lib1".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).behaviors.head => [
				"bvr1".assertEquals(name)
				events.get(0) => [
					"repair_evt1".assertEquals(name)
					//Tests scope_RepairEvent_eventInitiator(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.repairEvent_EventInitiator, emptySet)
				]
				events.get(1) => [
					"recover_evt1".assertEquals(name)
					//Tests scope_RecoverEvent_eventInitiator(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.recoverEvent_EventInitiator, emptySet)
				]
			]
		]
		testHelper.parseString(subclause1, lib1) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(3) => [
				"a2.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val expectedScope = #["aproto1", "bproto1", "dproto1", "devproto1", "mproto1", "procproto1", "psproto1",
						"subpgproto1", "subpproto1", "sproto1", "tgproto1", "tproto1", "vbproto1", "vpproto1", "fgproto1",
						"fproto1", "ba1", "da1", "subpa1", "subpga1", "af1", "fg1", "dp1", "edp1", "ep1", "source1", "sink1",
						"path1", "m1", "m2", "mt1", "asub1", "bsub1", "dsub1", "devsub1", "msub1", "procsub1", "pssub1",
						"subpgsub1", "subpsub1", "ssub1", "tgsub1", "tsub1", "vbsub1", "vpsub1", "es1", "eds1", "pp1", "sp1",
						"seq1", "call1", "conn1", "conn2", "conn3", "conn4", "conn5", "etef1"
					]
					events.get(0) => [
						"repair_evt2".assertEquals(name)
						//Tests scope_RepairEvent_eventInitiator(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.repairEvent_EventInitiator, expectedScope)
					]
					events.get(1) => [
						"recover_evt2".assertEquals(name)
						//Tests scope_RecoverEvent_eventInitiator(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.recoverEvent_EventInitiator, expectedScope)
					]
				]
			]
			publicSection.ownedClassifiers.get(4) => [
				"subp1".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val expectedScope = #["param1", "ep2"]
					events.get(0) => [
						"repair_evt3".assertEquals(name)
						//Tests scope_RepairEvent_eventInitiator(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.repairEvent_EventInitiator, expectedScope)
					]
					events.get(1) => [
						"recover_evt3".assertEquals(name)
						//Tests scope_RecoverEvent_eventInitiator(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.recoverEvent_EventInitiator, expectedScope)
					]
				]
			]
		]
	}
}