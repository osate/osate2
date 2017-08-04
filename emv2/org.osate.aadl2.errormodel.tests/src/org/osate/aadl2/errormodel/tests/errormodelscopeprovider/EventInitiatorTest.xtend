package org.osate.aadl2.errormodel.tests.errormodelscopeprovider

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class EventInitiatorTest extends OsateTest {
	/*
	 * Tests scope_RepairEvent_eventInitiator(Classifier, EReference),
	 * scope_RepairEvent_eventInitiator(ErrorBehaviorStateMachine, EReference),
	 * scope_RecoverEvent_eventInitiator(Classifier, EReference), and
	 * scope_RecoverEvent_eventInitiator(ErrorBehaviorStateMachine, EReference)
	 */
	@Test
	def void testEventInitiatorReference() {
		val lib1FileName = "lib1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(lib1FileName -> '''
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
		''', subclause1FileName -> '''
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
					ep2: in event port;
				annex EMV2 {**
					component error behavior
					events
						repair_evt3: repair event when ep2;
						recover_evt3: recover event when ep2;
					end component;
				**};
				end subp1;
			end subclause1;
		''')
		ignoreSerializationDifferences
		val lib1TestResult = testFile(lib1FileName)
		val subclause1TestResult = testFile(subclause1FileName)
		lib1TestResult.resource.contents.head as AadlPackage => [
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
		subclause1TestResult.resource.contents.head as AadlPackage => [
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