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
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner2)
@InjectWith(ErrorModelUiInjectorProvider)
class ErrorTypesTest extends OsateTest {
	override getProjectName() {
		"Error_Types_Test"
	}
	
	/*
	 * Tests scope_ErrorType, scope_TypeSet_aliasedType, scope_TypeToken_type(ErrorModelLibrary, EReference),
	 * scope_TypeToken_type(ErrorBehaviorStateMachine, EReference), scope_TypeToken_type(TypeMappingSet, EReference),
	 * scope_TypeToken_type(TypeTransformationSet, EReference), and scope_TypeToken_type(ErrorModelSubclause, EReference)
	 */
	@Test
	def void testErrorTypesReference() {
		val lib1FileName = "lib1.aadl"
		val lib2FileName = "lib2.aadl"
		val lib3FileName = "lib3.aadl"
		val lib4FileName = "lib4.aadl"
		val lib5FileName = "lib5.aadl"
		val lib6FileName = "lib6.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error types
						t1: type;
						conflict1: type;
						conflict2: type;
						
						ts1: type set {t1};
						conflict_ts1: type set {t1};
						conflict_ts2: type set {t1};
					end types;
				**};
			end lib1;
		''', lib2FileName -> '''
			package lib2
			public
				annex EMV2 {**
					error types extends lib1 with
						t2: type;
						
						ts2: type set {t2};
					end types;
				**};
			end lib2;
		''', lib3FileName -> '''
			package lib3
			public
				annex EMV2 {**
					error types
						t3: type;
						conflict1: type;
						
						ts3: type set {t3};
						conflict_ts1: type set {t3};
					end types;
				**};
			end lib3;
		''', lib4FileName -> '''
			package lib4
			public
				annex EMV2 {**
					error types extends lib3 with
						t4: type;
						
						ts4: type set {t4};
					end types;
				**};
			end lib4;
		''', lib5FileName -> '''
			package lib5
			public
				annex EMV2 {**
					error types extends lib1 with
					end types;
				**};
			end lib5;
		''', lib6FileName -> '''
			package lib6
			public
				annex EMV2 {**
					error types
						use types lib2, lib5;
						extends lib4 with
						
						conflict2: type;
						t6: type;
						
						conflict_ts2: type set {t6};
						ts6: type set {t6};
					end types;
					
					error behavior bvr1 use types lib2, lib5, lib6;
					events
						err_evt1: error event {t1, ts2};
					states
						bvr_state1: state {t1, ts2};
						bvr_state2: state {t2};
					transitions
						transition1: bvr_state1 {t1} -[ err_evt1 {t1} ]-> bvr_state2 {t2};
						transition2: bvr_state1 -[ err_evt1 ]-> (bvr_state2 {t2} with 0.2, bvr_state2 {ts2} with 0.8);
					end behavior;
					
					type mappings mappings1 use types lib2, lib5, lib6;
						{t1} -> {t2};
					end mappings;
					
					type transformations transformation1 use types lib2, lib5, lib6;
						{t1} -[ ]-> {t2};
					end transformations;
				**};
			end lib6;
		''', subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				annex EMV2 {**
					use behavior lib6::bvr1;
				**};
				end a1;
				
				abstract a2
				features
					ep1: in event port;
				modes
					m1: mode;
				end a2;
				
				abstract implementation a2.i
				subcomponents
					asub1: abstract a1;
				annex EMV2 {**
					use types lib2, lib5, lib6;
					use behavior lib6::bvr1;
					
					error propagations
						processor: in propagation {t1};
					flows
						errSource1: error source all {t1} when {t1};
						errSource2: error source all {t1} when {ts1};
						errSink1: error sink all {t1};
						errPath1: error path all {t1} -> all {t1};
					end propagations;
					
					component error behavior
					events
						errEvent1: error event {t1};
					transitions
						errBvrTransition1: bvr_state1 {t1} -[ errEvent1 {t1} ]-> bvr_state2 {t2};
						errBvrTransition2: bvr_state1 -[ errEvent1 ]-> (bvr_state2 {t2} with 0.2, bvr_state2 {t2} with 0.8);
					propagations
						propCondition1: bvr_state1 {t1} -[ processor {t1} ]-> all {t1};
					detections
						detection1: bvr_state1 {t1} -[ errEvent1 {t1} ]-> ep1!;
					mode mappings
						bvr_state1 {t1} in modes (m1);
					end component;
					
					composite error behavior states
						compositeState1: [asub1.bvr_state1 {t1}]-> bvr_state2 {t1};
						compositeState2: [in processor {t1}]-> bvr_state2 {t1};
					end composite;
					
					connection error
						connErrSource1: error source all {t1} when {t1};
					end connection;
				**};
				end a2.i;
			end subclause1;
		''')
		suppressSerialization
		val lib1TestResult = testFile(lib1FileName)
		val lib2TestResult = testFile(lib2FileName)
		val lib3TestResult = testFile(lib3FileName)
		val lib4TestResult = testFile(lib4FileName)
		val lib6TestResult = testFile(lib6FileName)
		val subclause1TestResult = testFile(subclause1FileName)
		lib1TestResult.resource.contents.head as AadlPackage => [
			"lib1".assertEquals(name)
			(publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
				val expectedTypeScope = #["t1", "conflict1", "conflict2"]
				types.get(0) => [
					"t1".assertEquals(name)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				types.get(1) => [
					"conflict1".assertEquals(name)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				types.get(2) => [
					"conflict2".assertEquals(name)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				
				val expectedTypeSetScope = #["ts1", "conflict_ts1", "conflict_ts2"]
				typesets.get(0) => [
					"ts1".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, expectedTypeSetScope)
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeScope + expectedTypeSetScope)
				]
				typesets.get(1) => [
					"conflict_ts1".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, expectedTypeSetScope)
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeScope + expectedTypeSetScope)
				]
				typesets.get(2) => [
					"conflict_ts2".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, expectedTypeSetScope)
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeScope + expectedTypeSetScope)
				]
			]
		]
		lib2TestResult.resource.contents.head as AadlPackage => [
			"lib2".assertEquals(name)
			(publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
				types.head => [
					"t2".assertEquals(name)
					val expectedTypeScope = #["t1", "conflict1", "conflict2", "t2"]
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				typesets.head => [
					"ts2".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, #["ts1", "conflict_ts1", "conflict_ts2", "ts2"])
					//scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, #["t1", "conflict1", "conflict2", "ts1", "conflict_ts1", "conflict_ts2", "t2", "ts2"])
				]
			]
		]
		lib3TestResult.resource.contents.head as AadlPackage => [
			"lib3".assertEquals(name)
			(publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
				val expectedTypeScope = #["t3", "conflict1"]
				types.get(0) => [
					"t3".assertEquals(name)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				types.get(1) => [
					"conflict1".assertEquals(name)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				
				val expectedTypeSetScope = #["ts3", "conflict_ts1"]
				typesets.get(0) => [
					"ts3".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, expectedTypeSetScope)
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeScope + expectedTypeSetScope)
				]
				typesets.get(1) => [
					"conflict_ts1".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, expectedTypeSetScope)
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeScope + expectedTypeSetScope)
				]
			]
		]
		lib4TestResult.resource.contents.head as AadlPackage => [
			"lib4".assertEquals(name)
			(publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
				types.head => [
					"t4".assertEquals(name)
					val expectedTypeScope = #["t3", "conflict1", "t4"]
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				typesets.head => [
					"ts4".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, #["ts3", "conflict_ts1", "ts4"])
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, #["t3", "conflict1", "ts3", "conflict_ts1", "t4", "ts4"])
				]
			]
		]
		lib6TestResult.resource.contents.head as AadlPackage => [
			"lib6".assertEquals(name)
			(publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
				val expectedTypeScope = #["t1", "lib2::conflict1", "lib2::conflict2", "t2", "lib5::conflict1", "lib5::conflict2", "t3", "conflict1", "t4", "conflict2", "t6"]
				types.get(0) => [
					"conflict2".assertEquals(name)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				types.get(1) => [
					"t6".assertEquals(name)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
					//Tests scope_ErrorType
					assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
				]
				
				val expectedTypeSetScope = #["ts1", "lib2::conflict_ts1", "lib2::conflict_ts2", "ts2", "lib5::conflict_ts1", "lib5::conflict_ts2", "ts3", "conflict_ts1", "ts4", "conflict_ts2", "ts6"]
				typesets.get(0) => [
					"conflict_ts2".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, expectedTypeSetScope)
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeScope + expectedTypeSetScope)
				]
				typesets.get(1) => [
					"ts6".assertEquals(name)
					//Tests scope_TypeSet_aliasedType
					assertScope(ErrorModelPackage.eINSTANCE.typeSet_AliasedType, expectedTypeSetScope)
					//Tests scope_TypeToken_type(ErrorModelLibrary, EReference)
					typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeScope + expectedTypeSetScope)
				]
				
				val expectedTypeTokenScope = #["t1", "lib2::conflict1", "lib5::conflict1", "lib2::conflict2", "lib5::conflict2", "ts1",
					"lib2::conflict_ts1", "lib5::conflict_ts1", "lib2::conflict_ts2", "lib5::conflict_ts2", "t2", "ts2", "t3",
					"lib6::conflict1", "ts3", "lib6::conflict_ts1", "t4", "ts4", "lib6::conflict2", "t6", "lib6::conflict_ts2", "ts6"
				]
				behaviors.head => [
					"bvr1".assertEquals(name)
					events.head as ErrorEvent => [
						"err_evt1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						typeSet.typeTokens.get(0).assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						typeSet.typeTokens.get(1).assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
					]
					states.get(0) => [
						"bvr_state1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						typeSet.typeTokens.get(0).assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						typeSet.typeTokens.get(1).assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
					]
					states.get(1) => [
						"bvr_state2".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						typeSet.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
					]
					transitions.get(0) => [
						"transition1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						(condition as ConditionElement).constraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						targetToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
					]
					transitions.get(1) => [
						"transition2".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						destinationBranches.get(0).targetToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
						//Tests scope_TypeToken_type(ErrorBehaviorStateMachine, EReference)
						destinationBranches.get(1).targetToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
					]
				]
				
				mappings.head => [
					"mappings1".assertEquals(name)
					//Tests scope_TypeToken_type(TypeMappingSet, EReference)
					mapping.head.source.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
					//Tests scope_TypeToken_type(TypeMappingSet, EReference)
					mapping.head.target.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
				]
				
				transformations.head => [
					"transformation1".assertEquals(name)
					//Tests scope_TypeToken_type(TypeTransformationSet, EReference)
					transformation.head.source.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
					//Tests scope_TypeToken_type(TypeTransformationSet, EReference)
					transformation.head.target.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedTypeTokenScope)
				]
			]
		]
		subclause1TestResult.resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(2) => [
				"a2.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val expectedScope = #["t1", "lib2::conflict1", "lib5::conflict1", "lib2::conflict2", "lib5::conflict2", "ts1",
						"lib2::conflict_ts1", "lib5::conflict_ts1", "lib2::conflict_ts2", "lib5::conflict_ts2", "t2", "ts2", "t3",
						"lib6::conflict1", "ts3", "lib6::conflict_ts1", "t4", "ts4", "lib6::conflict2", "t6", "lib6::conflict_ts2", "ts6"
					]
					propagations.head => [
						"processor".assertEquals(kind)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeSet.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					flows.get(0) as ErrorSource => [
						"errSource1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						failureModeType.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					flows.get(1) as ErrorSource => [
						"errSource2".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						failureModeType.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					flows.get(2) => [
						"errSink1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					flows.get(3) as ErrorPath => [
						"errPath1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						targetToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					events.head as ErrorEvent => [
						"errEvent1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeSet.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					transitions.get(0) => [
						"errBvrTransition1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						(condition as ConditionElement).constraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						targetToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					transitions.get(1) => [
						"errBvrTransition2".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						destinationBranches.get(0).targetToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						destinationBranches.get(1).targetToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					outgoingPropagationConditions.head => [
						"propCondition1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						(condition as ConditionElement).constraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					errorDetections.head => [
						"detection1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						(condition as ConditionElement).constraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					errorStateToModeMappings.head => [
						"bvr_state1".assertEquals(errorState.name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					states.get(0) => [
						"compositeState1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						(condition as ConditionElement).constraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typedToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					states.get(1) => [
						"compositeState2".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						(condition as ConditionElement).constraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typedToken.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
					connectionErrorSources.head => [
						"connErrSource1".assertEquals(name)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						typeTokenConstraint.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
						//Tests scope_TypeToken_type(ErrorModelSubclause, EReference)
						failureModeType.typeTokens.head.assertScope(ErrorModelPackage.eINSTANCE.typeToken_Type, expectedScope)
					]
				]
			]
		]
	}
}