package org.osate.aadl2.errormodel.tests.errormodelscopeprovider

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractType
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull

@RunWith(XtextRunner2)
@InjectWith(ErrorModelUiInjectorProvider)
class OtherErrorModelScopeProviderTest extends OsateTest {
	override getProjectName() {
		"Other_Error_Model_Scope_Provider_Test"
	}
	
	/*
	 * Tests scope_ErrorModelLibrary, scope_TypeMappingSet, scope_ErrorModelSubclause_useBehavior, and
	 * scope_TypeTransformationSet
	 */
	@Test
	def void testErrorModelLibraryReference() {
		createFiles("pkg.aadl" -> '''
			package pkg
			public
				annex EMV2 {**
					error types
						use types ErrorLibrary;
						extends ErrorLibrary with
					end types;
					
					error behavior b
						use types ErrorLibrary;
						use transformations t;
					end behavior;
					
					type mappings m
						use types ErrorLibrary;
						{ServiceError} -> {ItemOmission};
					end mappings;
					
					type transformations t
						use types ErrorLibrary;
						all -[]-> {ServiceError};
					end transformations;
				**};
				
				abstract a
					annex EMV2 {**
						use types ErrorLibrary;
						use type equivalence pkg::m;
						use mappings pkg::m;
						use behavior pkg::b;
						
						error propagations
						flows
							p: error path all -> all use mappings pkg::m;
						end propagations;
						
						component error behavior
							use transformations pkg::t;
						end component;
						
						connection error
							use transformations pkg::t;
						end connection;
					**};
				end a;
			end pkg;
		''')
		suppressSerialization
		val testFileResult = testFile("pkg.aadl")
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection => [
				(ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
					//Tests scope_ErrorModelLibrary
					assertScopeModelUnitNamesOnly(ErrorModelPackage.eINSTANCE.errorModelLibrary_UseTypes, #["pkg"])
					//Tests scope_ErrorModelLibrary
					assertScopeModelUnitNamesOnly(ErrorModelPackage.eINSTANCE.errorModelLibrary_Extends, #["pkg"])
					behaviors.head => [
						"b".assertEquals(name)
						//Tests scope_ErrorModelLibrary
						assertScopeModelUnitNamesOnly(ErrorModelPackage.eINSTANCE.errorBehaviorStateMachine_UseTypes, #["pkg"])
						//Tests scope_TypeTransformationSet
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorStateMachine_UseTransformation, #["t", "pkg::t"])
					]
					mappings.head => [
						"m".assertEquals(name)
						//Tests scope_ErrorModelLibrary
						assertScopeModelUnitNamesOnly(ErrorModelPackage.eINSTANCE.typeMappingSet_UseTypes, #["pkg"])
					]
					transformations.head => [
						"t".assertEquals(name)
						//Tests scope_ErrorModelLibrary
						assertScopeModelUnitNamesOnly(ErrorModelPackage.eINSTANCE.typeTransformationSet_UseTypes, #["pkg"])
					]
				]
				ownedClassifiers.head => [
					"a".assertEquals(name)
					(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
						//Tests scope_ErrorModelLibrary
						assertScopeModelUnitNamesOnly(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseTypes, #["pkg"])
						//Tests scope_TypeMappingSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeEquivalence, #["pkg::m"])
						//Tests scope_TypeMappingSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeMappingSet, #["pkg::m"])
						//Tests scope_ErrorModelSubclause_useBehavior
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseBehavior, #["pkg::b"])
						flows.head => [
							"p".assertEquals(name)
							assertWarning(testFileResult.issues, issueCollection, "Legacy support: please declare 'use mappings' at subclause level.")
							//Tests scope_TypeMappingSet
							assertScope(ErrorModelPackage.eINSTANCE.errorPath_TypeMappingSet, #["pkg::m"])
						]
						//Tests scope_TypeTransformationSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseTransformation, #["pkg::t"])
						//Tests scope_TypeTransformationSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeTransformationSet, #["pkg::t"])
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
	
	/*
	 * Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(Classifier, EReference),
	 * ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference), and
	 * ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
	 */
	@Test
	def void testFeatureorPPReference() {
		createFiles("pkg.aadl" -> '''
			package pkg
			public
				abstract a
				features
					op1: out data port;
					fg1: feature group fgt1;
				end a;
				
				abstract implementation a.i
				internal features
					es: event;
					eds: event data;
				annex EMV2 {**
					use types ErrorLibrary;
					
					error propagations
						fg1.fg2.op3: out propagation {ServiceOmission};
					end propagations;
					
					propagation paths
						point1: propagation point;
						point2: propagation point;
					end paths;
				**};
				end a.i;
				
				feature group fgt1
				features
					op2: out data port;
					fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
				features
					op3: out data port;
				end fgt2;
			end pkg;
		''')
		suppressSerialization
		testFile("pkg.aadl").resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a.i".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).propagations.head.featureorPPRef => [
					"fg1".assertEquals(featureorPP.name)
					//Tests scope_FeatureorPPReference_featureorPP
					assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["eds", "es", "fg1", "op1", "point1", "point2"])
					next => [
						"fg2".assertEquals(featureorPP.name)
						//Tests scope_FeatureorPPReference_featureorPP
						assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["fg2", "op2"])
						next => [
							"op3".assertEquals(featureorPP.name)
							//Tests scope_FeatureorPPReference_featureorPP
							assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["op3"])
							next.assertNull
						]
					]
				]
			]
		]
	}
	
	/*
	 * Tests scope_ErrorSource_outgoing, scope_ErrorSink_incoming, scope_ErrorPath_incoming, scope_ErrorPath_outgoing,
	 * and scope_OutgoingPropagationCondition_outgoing
	 */
	@Test
	def void testErrorPropagationReference() {
		createFiles("pkg.aadl" -> '''
			package pkg
			public
				abstract a
				features
					p1: out data port;
					p2: out data port;
					p4: in data port;
					p5: in data port;
					fg1: feature group fgt1;
				annex EMV2 {**
					use types ErrorLibrary;
					
					error propagations
						p1: out propagation {AboveRange};
						p2: out propagation {AboveRange};
						fg1.p3: out propagation {AboveRange};
						fg1.fg2.p4: out propagation {AboveRange};
						memory: out propagation {AboveRange};
						binding: out propagation {AboveRange};
						
						p4: in propagation {AboveRange};
						p5: in propagation {AboveRange};
						fg1.p4: in propagation {AboveRange};
						fg1.fg2.p5: in propagation {AboveRange};
						memory: in propagation {AboveRange};
						binding: in propagation {AboveRange};
					flows
						errSource: error source fg1.p3;
						errSink: error sink fg1.p4;
						errPath: error path fg1.p4 -> fg1.p3;
					end propagations;
					
					component error behavior
					propagations
						condition1: all -[ p4 ]-> p1;
					end component;
				**};
				end a;
				
				feature group fgt1
				features
					p3: out data port;
					p4: in data port;
					fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
				features
					p4: out data port;
					p5: in data port;
				end fgt2;
			end pkg;
		''')
		suppressSerialization
		testFile("pkg.aadl").resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"a".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val outgoingScope = #["p1", "p2", "fg1.p3", "fg1.fg2.p4", "memory", "binding"]
					val incomingScope = #["p4", "p5", "fg1.p4", "fg1.fg2.p5", "memory", "binding"]
					flows.get(0) => [
						"errSource".assertEquals(name)
						//Tests scope_ErrorSource_outgoing
						assertScope(ErrorModelPackage.eINSTANCE.errorSource_Outgoing, outgoingScope)
					]
					flows.get(1) => [
						"errSink".assertEquals(name)
						//Tests scope_ErrorSink_incoming
						assertScope(ErrorModelPackage.eINSTANCE.errorSink_Incoming, incomingScope)
					]
					flows.get(2) => [
						"errPath".assertEquals(name)
						//Tests scope_ErrorPath_incoming
						assertScope(ErrorModelPackage.eINSTANCE.errorPath_Incoming, incomingScope)
						//Tests scope_ErrorPath_outgoing
						assertScope(ErrorModelPackage.eINSTANCE.errorPath_Outgoing, outgoingScope)
					]
					outgoingPropagationConditions.head => [
						"condition1".assertEquals(name)
						//Tests scope_OutgoingPropagationCondition_outgoing
						assertScope(ErrorModelPackage.eINSTANCE.outgoingPropagationCondition_Outgoing, outgoingScope)
					]
				]
			]
		]
	}
	
	//Tests scope_ErrorSource_failureModeReference
	@Test
	def void testErrorBehaviorStateOrTypeSetReference() {
		val lib1FileName = "lib1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error types
						t1: type;
						ts1: type set {t1};
					end types;
					
					error behavior bvr1
					states
						bvr_state1: initial state;
						bvr_state2: state;
					end behavior;
				**};
			end lib1;
		''', subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				annex EMV2 {**
					use types lib1;
					use behavior lib1::bvr1;
					
					error propagations
					flows
						errSource1: error source all when bvr_state1;
					end propagations;
				**};
				end a1;
			end subclause1;
		''')
		suppressSerialization
		testFile(subclause1FileName).resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a1".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).flows.head as ErrorSource => [
					"errSource1".assertEquals(name)
					//Tests scope_ErrorSource_failureModeReference
					assertScope(ErrorModelPackage.eINSTANCE.errorSource_FailureModeReference, #["ts1", "bvr_state1", "bvr_state2"])
				]
			]
		]
	}
	
	//Tests scope_QualifiedPropagationPoint_propagationPoint
	@Test
	def void testPropagationPointReference() {
		val subclause1FileName = "subclause1.aadl"
		createFiles(subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub2: abstract a2.i;
				annex EMV2 {**
					propagation paths
						point1: propagation point;
					end paths;
				**};
				end a1.i;
				
				abstract a2
				end a2;
				
				abstract implementation a2.i
				subcomponents
					asub3: abstract a3.i;
				annex EMV2 {**
					propagation paths
						point2: propagation point;
					end paths;
				**};
				end a2.i;
				
				abstract a3
				end a3;
				
				abstract implementation a3.i
				subcomponents
					asub4: abstract a4.i;
				annex EMV2 {**
					propagation paths
						point3: propagation point;
					end paths;
				**};
				end a3.i;
				
				abstract a4
				end a4;
				
				abstract implementation a4.i
				annex EMV2 {**
					propagation paths
						point4: propagation point;
					end paths;
				**};
				end a4.i;
				
				abstract a5
				end a5;
				
				abstract implementation a5.i
				subcomponents
					asub1: abstract a1.i;
				annex EMV2 {**
					propagation paths
						propPath1: asub1.point1 -> asub1.asub2.point2;
						propPath2: asub1.asub2.asub3.point3 -> asub1.asub2.asub3.asub4.point4;
					end paths;
				**};
				end a5.i;
			end subclause1;
		''')
		suppressSerialization
		testFile(subclause1FileName).resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(9) => [
				"a5.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					paths.get(0) => [
						"propPath1".assertEquals(name)
						source => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_QualifiedPropagationPoint_propagationPoint
							assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point1"])
							next.assertNull
						]
						target => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								//Tests scope_QualifiedPropagationPoint_propagationPoint
								assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point2"])
								next.assertNull
							]
						]
					]
					paths.get(1) => [
						"propPath2".assertEquals(name)
						source => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								next => [
									"asub3".assertEquals(subcomponent.subcomponent.name)
									//Tests scope_QualifiedPropagationPoint_propagationPoint
									assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point3"])
									next.assertNull
								]
							]
						]
						target => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								next => [
									"asub3".assertEquals(subcomponent.subcomponent.name)
									next => [
										"asub4".assertEquals(subcomponent.subcomponent.name)
										//Tests scope_QualifiedPropagationPoint_propagationPoint
										assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point4"])
										next.assertNull
									]
								]
							]
						]
					]
				]
			]
		]
	}
	
	//Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference) and scope_ErrorBehaviorState(Classifier, EReference)
	@Test
	def void testErrorBehaviorStateReference() {
		val lib1FileName = "lib1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error types
						t1: type;
					end types;
					
					error behavior bvr
					events
						err_evt1: error event;
					states
						bvr_state1: state;
						bvr_state2: state;
					transitions
						transition1: bvr_state1 -[ err_evt1 ]-> bvr_state2;
						transition2: bvr_state1 -[ err_evt1 ]-> (bvr_state2 with 0.2, bvr_state2 with 0.8);
					end behavior;
				**};
			end lib1;
		''', subclause1FileName -> '''
			package subclause1
			public
				abstract a
				features
					ep1: in event port;
				modes
					m1: initial mode;
				annex EMV2 {**
					use types lib1;
					use behavior lib1::bvr;
					
					error propagations
						processor: in propagation {t1};
					end propagations;
					
					component error behavior
					events
						err_evt2: error event;
					transitions
						transition3: bvr_state1 -[ err_evt2 ]-> bvr_state2;
						transition4: bvr_state1 -[ err_evt2 ]-> (bvr_state2 with 0.2, bvr_state2 with 0.8);
					propagations
						propagationCondition1: bvr_state1 -[ processor ]-> all;
					detections
						detection1: bvr_state1 -[ err_evt2 ]-> ep1!;
					mode mappings
						bvr_state1 in modes (m1);
					end component;
					
					composite error behavior states
						compositeState1: [ others ]-> bvr_state1;
					end composite;
				**};
				end a;
			end subclause1;
		''')
		suppressSerialization
		val lib1TestResult = testFile(lib1FileName)
		val subclause1TestResult = testFile(subclause1FileName)
		val expectedScope = #["bvr_state1", "bvr_state2"]
		lib1TestResult.resource.contents.head as AadlPackage => [
			"lib1".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).behaviors.head => [
				"bvr".assertEquals(name)
				transitions.get(0) => [
					"transition1".assertEquals(name)
					//Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
					//Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Target, expectedScope)
				]
				transitions.get(1) => [
					"transition2".assertEquals(name)
					//Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
					//Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					destinationBranches.get(0).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target, expectedScope)
					//Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					destinationBranches.get(1).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target, expectedScope)
				]
			]
		]
		subclause1TestResult.resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					transitions.get(0) => [
						"transition3".assertEquals(name)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Target, expectedScope)
					]
					transitions.get(1) => [
						"transition4".assertEquals(name)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						destinationBranches.get(0).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target, expectedScope)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						destinationBranches.get(1).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target, expectedScope)
					]
					outgoingPropagationConditions.head => [
						"propagationCondition1".assertEquals(name)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.outgoingPropagationCondition_State, expectedScope)
					]
					errorDetections.head => [
						"detection1".assertEquals(name)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorDetection_State, expectedScope)
					]
					errorStateToModeMappings.head => [
						"bvr_state1".assertEquals(errorState.name)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorStateToModeMapping_ErrorState, expectedScope)
					]
					states.head => [
						"compositeState1".assertEquals(name)
						//Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.compositeState_State, expectedScope)
					]
				]
			]
		]
	}
	
	//Tests scope_ConnectionErrorSource_connection
	@Test
	def void testConnectionReference() {
		val subclause1FileName = "subclause1.aadl"
		createFiles(subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				features
					f1: feature;
				end a1;
				
				abstract implementation a1.i
				subcomponents
					sub1: abstract a1;
				connections
					conn1: feature sub1.f1 -> f1;
				end a1.i;
				
				abstract a2 extends a1
				end a2;
				
				abstract implementation a2.i extends a1.i
				connections
					conn2: feature f1 -> sub1.f1;
				annex EMV2 {**
					connection error
						source1: error source conn1;
					end connection;
				**};
				end a2.i;
			end subclause1;
		''')
		suppressSerialization
		testFile(subclause1FileName).resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(3) => [
				"a2.i".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).connectionErrorSources.head => [
					"source1".assertEquals(name)
					//Tests scope_ConnectionErrorSource_connection
					assertScope(ErrorModelPackage.eINSTANCE.connectionErrorSource_Connection, #["conn1", "conn2"])
				]
			]
		]
	}
	
	//Tests scope_ErrorDetection_detectionReportingPort and ErrorCodeValue's constant reference
	@Test
	def void testErrorDetectionReferences() {
		val ps1FileName = "ps1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(ps1FileName -> '''
			property set ps1 is
				const1: constant aadlinteger => 42;
			end ps1;
		''', subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				features
					af1: feature;
					dp1: in data port;
					ep1: in event port;
					edp1: in event data port;
				end a1;
				
				abstract implementation a1.i
				internal features
					es1: event;
					eds1: event data;
				end a1.i;
				
				abstract a2 extends a1
				features
					af2: feature;
					dp2: in data port;
					ep2: in event port;
					edp2: in event data port;
				end a2;
				
				abstract implementation a2.i extends a1.i
				internal features
					es2: event;
					eds2: event data;
				annex EMV2 {**
					use types ErrorLibrary;
					
					error propagations
						access: in propagation {AboveRange};
					end propagations;
					
					component error behavior
					detections
						detection1: all -[ access ]-> dp1! (ps1::const1);
					end component;
				**};
				end a2.i;
			end subclause1;
		''')
		suppressSerialization
		testFile(subclause1FileName).resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(3) => [
				"a2.i".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).errorDetections.head => [
					"detection1".assertEquals(name)
					//Tests scope_ErrorDetection_detectionReportingPort
					assertScope(ErrorModelPackage.eINSTANCE.errorDetection_DetectionReportingPort, #["af1", "dp1",
						"ep1", "edp1", "es1", "eds1", "af2", "dp2", "ep2", "edp2", "es2", "eds2"
					])
					//Tests ErrorCodeValue's constant reference
					errorCode.assertScope(ErrorModelPackage.eINSTANCE.errorCodeValue_Constant, #["Max_Aadlinteger",
						"Max_Base_Address", "Max_Byte_Count", "Max_Memory_Size", "Max_Queue_Size", "Max_Target_Integer",
						"Max_Thread_Limit", "Max_Time", "Max_Urgency", "Max_Volume", "Max_Word_Space",
						"Supported_Classifier_Complement_Matches", "Supported_Classifier_Equivalence_Matches",
						"Supported_Classifier_Subset_Matches", "Supported_Type_Conversions", "ps1::const1",
						"AADL_Project::Max_Aadlinteger", "AADL_Project::Max_Base_Address",
						"AADL_Project::Max_Byte_Count", "AADL_Project::Max_Memory_Size", "AADL_Project::Max_Queue_Size",
						"AADL_Project::Max_Target_Integer", "AADL_Project::Max_Thread_Limit", "AADL_Project::Max_Time",
						"AADL_Project::Max_Urgency", "AADL_Project::Max_Volume", "AADL_Project::Max_Word_Space",
						"AADL_Project::Supported_Classifier_Complement_Matches",
						"AADL_Project::Supported_Classifier_Equivalence_Matches",
						"AADL_Project::Supported_Classifier_Subset_Matches", "AADL_Project::Supported_Type_Conversions"
					])
				]
			]
		]
	}
	
	//Tests scope_ErrorStateToModeMapping_mappedModes
	@Test
	def void testModeReference() {
		val lib1FileName = "lib1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error behavior bvr1
					states
						bvr_state1: state;
					end behavior;
				**};
			end lib1;
		''', subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				modes
					m1: initial mode;
					m2: mode;
				end a1;
				
				abstract a2 extends a1
				modes
					m3: mode;
					m4: mode;
				annex EMV2 {**
					use behavior lib1::bvr1;
					
					component error behavior
					mode mappings
						bvr_state1 in modes (m1, m3);
					end component;
				**};
				end a2;
			end subclause1;
		''')
		suppressSerialization
		testFile(subclause1FileName).resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a2".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).errorStateToModeMappings.head => [
					"bvr_state1".assertEquals(errorState.name)
					//Tests scope_ErrorStateToModeMapping_mappedModes
					assertScope(ErrorModelPackage.eINSTANCE.errorStateToModeMapping_MappedModes, #["m1", "m2", "m3", "m4"])
				]
			]
		]
	}
	
	//Tests scope_QualifiedErrorBehaviorState_state
	@Test
	def void testQualifiedErrorBehaviorState() {
		val lib1FileName = "lib1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error behavior bvr1
					states
						bvr_state1: state;
					end behavior;
					
					error behavior bvr2
					states
						bvr_state2: state;
					end behavior;
					
					error behavior bvr3
					states
						bvr_state3: state;
					end behavior;
					
					error behavior bvr4
					states
						bvr_state4: state;
					end behavior;
				**};
			end lib1;
		''', subclause1FileName -> '''
			package subclause1
			public
				abstract a1
				end a1;
				
				abstract implementation a1.i
				subcomponents
					asub1: abstract a2.i;
				annex EMV2 {**
					use behavior lib1::bvr1;
					
					composite error behavior states
						compositeState1: [ asub1.bvr_state2 ]-> bvr_state1;
						compositeState2: [ asub1.asub2.bvr_state3 ]-> bvr_state1;
						compositeState3: [ asub1.asub2.asub3.bvr_state4 ]-> bvr_state1;
					end composite;
				**};
				end a1.i;
				
				abstract a2
				annex EMV2 {**
					use behavior lib1::bvr2;
				**};
				end a2;
				
				abstract implementation a2.i
				subcomponents
					asub2: abstract a3.i;
				end a2.i;
				
				abstract a3
				annex EMV2 {**
					use behavior lib1::bvr3;
				**};
				end a3;
				
				abstract implementation a3.i
				subcomponents
					asub3: abstract a4;
				end a3.i;
				
				abstract a4
				annex EMV2 {**
					use behavior lib1::bvr4;
				**};
				end a4;
			end subclause1;
		''')
		suppressSerialization
		testFile(subclause1FileName).resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					states.get(0) => [
						"compositeState1".assertEquals(name)
						(condition as SConditionElement).qualifiedState => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_QualifiedErrorBehaviorState_state
							assertScope(ErrorModelPackage.eINSTANCE.qualifiedErrorBehaviorState_State, #["bvr_state2"])
							next.assertNull
						]
					]
					states.get(1) => [
						"compositeState2".assertEquals(name)
						(condition as SConditionElement).qualifiedState => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								//Tests scope_QualifiedErrorBehaviorState_state
								assertScope(ErrorModelPackage.eINSTANCE.qualifiedErrorBehaviorState_State, #["bvr_state3"])
								next.assertNull
							]
						]
					]
					states.get(2) => [
						"compositeState3".assertEquals(name)
						(condition as SConditionElement).qualifiedState => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								next => [
									"asub3".assertEquals(subcomponent.subcomponent.name)
									//Tests scope_QualifiedErrorBehaviorState_state
									assertScope(ErrorModelPackage.eINSTANCE.qualifiedErrorBehaviorState_State, #["bvr_state4"])
									next.assertNull
								]
							]
						]
					]
				]
			]
		]
	}
}