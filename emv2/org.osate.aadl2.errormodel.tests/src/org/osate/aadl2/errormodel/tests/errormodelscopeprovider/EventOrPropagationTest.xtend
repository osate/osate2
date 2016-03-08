package org.osate.aadl2.errormodel.tests.errormodelscopeprovider

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
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

@RunWith(XtextRunner2)
@InjectWith(ErrorModelUiInjectorProvider)
class EventOrPropagationTest extends OsateTest {
	override getProjectName() {
		"Event_Or_Propagation_Test"
	}
	
	/*
	 * Tests scope_ConditionElement_incoming(ErrorBehaviorStateMachine, EReference),
	 * scope_ConditionElement_incoming(Classifier, EReference), and
	 * scope_ConditionElement_incoming(ErrorDetection, EReference)
	 */
	@Test
	def void testEventOrPropagationReference() {
		val lib1FileName = "lib1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error types
						et1: type;
					end types;
					
					error behavior bvr
					events
						err_evt1: error event;
					states
						state1: state;
					transitions
						transition1: all -[ err_evt1 ]-> same state;
					end behavior;
				**};
			end lib1;
		''', subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				features
					dp1: in data port;
					dp2: out data port;
					dp3: in data port;
					dp4: out data port;
					dp5: in data port;
					dp6: out data port;
					dp7: in data port;
					dp8: out data port;
					fg1: feature group fgt1;
				annex EMV2 {**
					use types lib1;
					
					error propagations
						dp1: in propagation {et1};
						dp2: out propagation {et1};
						processor: in propagation {et1};
						memory: out propagation {et1};
						fg1.dp9: in propagation {et1};
						fg1.dp10: out propagation {et1};
						fg1.fg2.dp11: in propagation {et1};
						fg1.fg2.dp12: out propagation {et1};
						point1: in propagation {et1};
						point2: out propagation {et1};
					end propagations;
					
					component error behavior
					events
						err_evt2: error event;
					end component;
					
					propagation paths
						point1: propagation point;
						point2: propagation point;
					end paths;
				**};
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a1;
				internal features
					es1: event;
					es2: event;
					eds1: event data;
					eds2: event data;
				annex EMV2 {**
					use types lib1;
					
					error propagations
						dp3: in propagation {et1};
						dp4: out propagation {et1};
						connection: in propagation {et1};
						binding: out propagation {et1};
						es1: in propagation {et1};
						es2: out propagation {et1};
						eds1: in propagation {et1};
						eds2: out propagation {et1};
					end propagations;
					
					component error behavior
					events
						err_evt3: error event;
					end component;
				**};
				end a1.i;
				
				abstract a2 extends a1
				annex EMV2 {**
					use types lib1;
					
					error propagations
						dp5: in propagation {et1};
						dp6: out propagation {et1};
						bindings: in propagation {et1};
						access: out propagation {et1};
					end propagations;
					
					component error behavior
					events
						err_evt4: error event;
					end component;
				**};
				end a2;
				
				abstract implementation a2.i extends a1.i
				subcomponents
					asub2: abstract a1.i;
				annex EMV2 {**
					use types lib1;
					use behavior lib1::bvr;
					
					error propagations
						dp7: in propagation {et1};
						dp8: out propagation {et1};
					end propagations;
					
					component error behavior
					events
						err_evt5: error event;
					transitions
						transition2: all -[ err_evt2 ]-> same state;
					propagations
						condition1: all -[ err_evt3 ]-> all;
					detections
						detection1: all -[ asub2.asub1.point2 ]-> dp1!;
					end component;
					
					composite error behavior
					states
						compositeState1: [ in dp1 ]-> state1;
					end composite;
				**};
				end a2.i;
				
				feature group fgt1
				features
					dp9: in data port;
					dp10: out data port;
					fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
				features
					dp11: in data port;
					dp12: out data port;
				end fgt2;
			end subclause1;
		''')
		suppressSerialization
		val lib1TestResult = testFile(lib1FileName)
		val subclause1TestResult = testFile(subclause1FileName)
		lib1TestResult.resource.contents.head as AadlPackage => [
			"lib1".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).behaviors.head => [
				"bvr".assertEquals(name)
				transitions.head => [
					"transition1".assertEquals(name)
					//Tests scope_ConditionElement_incoming(ErrorBehaviorStateMachine, EReference)
					condition.assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["err_evt1"])
				]
			]
		]
		subclause1TestResult.resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(3) => [
				"a2.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val expectedScope = #["asub1", "asub2", "bindings", "connection", "dp1", "dp3", "dp5", "dp7", 
						"eds1", "err_evt1", "err_evt2", "err_evt3", "err_evt4", "err_evt5", "es1", 
						"fg1.dp9", "fg1.fg2.dp11", "point1", "processor"
					]
//					val expectedScope1 = expectedScope + #[ "asub2.dp2", "asub2.memory", "asub2.fg1.dp10", "asub2.fg1.fg2.dp12", "asub2.point2",
//							"asub2.dp4", "asub2.binding", "asub2.es2", "asub2.eds2", "asub2.asub1.dp2",
//							"asub2.asub1.memory", "asub2.asub1.fg1.dp10", "asub2.asub1.fg1.fg2.dp12",
//							"asub2.asub1.point2", "asub1.dp2", "asub1.memory", "asub1.fg1.dp10", "asub1.fg1.fg2.dp12",
//							"asub1.point2"
//					]
					val expectedScope2 = #["dp1", "processor", "fg1.dp9",
						"fg1.fg2.dp11", "point1", "dp3", "connection", "es1", "eds1", "dp5", "bindings", "dp7"
					]
					transitions.head => [
						"transition2".assertEquals(name)
						//Tests scope_ConditionElement_incoming(Classifier, EReference)
						condition.assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, expectedScope)
					]
					outgoingPropagationConditions.head => [
						"condition1".assertEquals(name)
						//Tests scope_ConditionElement_incoming(Classifier, EReference)
						condition.assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, expectedScope)
					]
					errorDetections.head => [
						"detection1".assertEquals(name)
						//Tests scope_ConditionElement_incoming(ErrorDetection, EReference)
						condition.assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, expectedScope 
							)
					]
					states.head => [
						"compositeState1".assertEquals(name)
						//Tests scope_ConditionElement_incoming(Classifier, EReference)
						condition.assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, expectedScope2)
					]
				]
			]
		]
	}
}