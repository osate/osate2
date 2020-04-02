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
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractType
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordValue
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull
import static extension org.osate.testsupport.AssertHelper.*

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class OtherErrorModelScopeProviderTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)

	/*
	 * Tests scope_ErrorModelLibrary, scope_TypeMappingSet, scope_ErrorModelSubclause_useBehavior, and
	 * scope_TypeTransformationSet
	 */
	@Test
	def void testErrorModelLibraryReference() {
		val pkg = '''
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
		'''
		val testFileResult = issues = testHelper.testString(pkg)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection => [
				(ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
					// Tests scope_ErrorModelLibrary
					assertScope(ErrorModelPackage.eINSTANCE.errorModelLibrary_UseTypes, #["pkg"])
					// Tests scope_ErrorModelLibrary
					assertScope(ErrorModelPackage.eINSTANCE.errorModelLibrary_Extends, #["pkg"])
					behaviors.head => [
						"b".assertEquals(name)
						// Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorStateMachine_UseTypes, #["pkg"])
						// Tests scope_TypeTransformationSet
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorStateMachine_UseTransformation,
							#["t", "pkg::t"])
					]
					mappings.head => [
						"m".assertEquals(name)
						// Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.typeMappingSet_UseTypes, #["pkg"])
					]
					transformations.head => [
						"t".assertEquals(name)
						// Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.typeTransformationSet_UseTypes, #["pkg"])
					]
				]
				ownedClassifiers.head => [
					"a".assertEquals(name)
					(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause =>
						[
							// Tests scope_ErrorModelLibrary
							assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseTypes, #["pkg"])
							// Tests scope_TypeMappingSet
							assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeEquivalence, #["pkg::m"])
							// Tests scope_TypeMappingSet
							assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeMappingSet, #["pkg::m"])
							// Tests scope_ErrorModelSubclause_useBehavior
							assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseBehavior, #["pkg::b"])
							flows.head => [
								"p".assertEquals(name)
								assertWarning(testFileResult.issues, issueCollection,
									"Legacy support: please declare 'use mappings' at subclause level.")
								// Tests scope_TypeMappingSet
								assertScope(ErrorModelPackage.eINSTANCE.errorPath_TypeMappingSet, #["pkg::m"])
							]
							// Tests scope_TypeTransformationSet
							assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseTransformation, #["pkg::t"])
							// Tests scope_TypeTransformationSet
							assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeTransformationSet,
								#["pkg::t"])
						]
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}

	/*
	 * Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(Classifier, EReference),
	 * ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference), and
	 * ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
	 */
	@Test
	def void testFeatureorPPReference() {
		val pkg = '''
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
		'''
		testHelper.parseString(pkg) => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a.i".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					propagations.head.featureorPPRef => [
					"fg1".assertEquals(featureorPP.name)
					// Tests scope_FeatureorPPReference_featureorPP
					assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP,
						#["eds", "es", "fg1", "op1", "point1", "point2"])
					next => [
						"fg2".assertEquals(featureorPP.name)
						// Tests scope_FeatureorPPReference_featureorPP
						assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["fg2", "op2"])
						next => [
							"op3".assertEquals(featureorPP.name)
							// Tests scope_FeatureorPPReference_featureorPP
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
		val pkg = '''
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
		'''
		testHelper.parseString(pkg) => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"a".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val outgoingScope = #["p1", "p2", "fg1.p3", "fg1.fg2.p4", "memory", "binding"]
					val incomingScope = #["p4", "p5", "fg1.p4", "fg1.fg2.p5", "memory", "binding"]
					flows.get(0) => [
						"errSource".assertEquals(name)
						// Tests scope_ErrorSource_outgoing
						assertScope(ErrorModelPackage.eINSTANCE.errorSource_SourceModelElement, outgoingScope)
					]
					flows.get(1) => [
						"errSink".assertEquals(name)
						// Tests scope_ErrorSink_incoming
						assertScope(ErrorModelPackage.eINSTANCE.errorSink_Incoming, incomingScope)
					]
					flows.get(2) => [
						"errPath".assertEquals(name)
						// Tests scope_ErrorPath_incoming
						assertScope(ErrorModelPackage.eINSTANCE.errorPath_Incoming, incomingScope)
						// Tests scope_ErrorPath_outgoing
						assertScope(ErrorModelPackage.eINSTANCE.errorPath_Outgoing, outgoingScope)
					]
					outgoingPropagationConditions.head => [
						"condition1".assertEquals(name)
						// Tests scope_OutgoingPropagationCondition_outgoing
						assertScope(ErrorModelPackage.eINSTANCE.outgoingPropagationCondition_Outgoing, outgoingScope)
					]
				]
			]
		]
	}

	// Tests scope_ErrorSource_failureModeReference
	@Test
	def void testErrorBehaviorStateOrTypeSetReference() {
		val lib = '''
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
		'''
		val subclause = '''
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
		'''
		testHelper.parseString(subclause, lib) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a1".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					flows.head as ErrorSource => [
					"errSource1".assertEquals(name)
					// Tests scope_ErrorSource_failureModeReference
					assertScope(ErrorModelPackage.eINSTANCE.errorSource_FailureModeReference,
						#["ts1", "bvr_state1", "bvr_state2"])
				]
			]
		]
	}

	// Tests scope_QualifiedPropagationPoint_propagationPoint
	@Test
	def void testPropagationPointReference() {
		val subclause = '''
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
		'''
		testHelper.parseString(subclause) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(9) => [
				"a5.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					paths.get(0) => [
						"propPath1".assertEquals(name)
						source => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							// Tests scope_QualifiedPropagationPoint_propagationPoint
							next => [
								"point1".assertEquals(propagationPoint.name)
								assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint,
									#["point1"])
								next.assertNull
							]
						]
						target => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								// Tests scope_QualifiedPropagationPoint_propagationPoint
								next => [
									"point2".assertEquals(propagationPoint.name)
									assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint,
										#["point2"])
									next.assertNull
								]
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
									// Tests scope_QualifiedPropagationPoint_propagationPoint
									next => [
										"point3".assertEquals(propagationPoint.name)
										assertScope(
											ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint,
											#["point3"])
										next.assertNull
									]
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
										// Tests scope_QualifiedPropagationPoint_propagationPoint
										next => [
											"point4".assertEquals(propagationPoint.name)
											assertScope(
												ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint,
												#["point4"])
											next.assertNull
										]
									]
								]
							]
						]
					]
				]
			]
		]
	}

	// Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference) and scope_ErrorBehaviorState(Classifier, EReference)
	@Test
	def void testErrorBehaviorStateReference() {
		val lib = '''
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
		'''
		val subclause = '''
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
		'''
		val expectedScope = #["bvr_state1", "bvr_state2"]
		testHelper.parseString(lib) => [
			"lib1".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).
				behaviors.head => [
				"bvr".assertEquals(name)
				transitions.get(0) => [
					"transition1".assertEquals(name)
					// Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
					// Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Target, expectedScope)
				]
				transitions.get(1) => [
					"transition2".assertEquals(name)
					// Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
					// Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					destinationBranches.get(0).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target,
						expectedScope)
					// Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference)
					destinationBranches.get(1).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target,
						expectedScope)
				]
			]
		]
		testHelper.parseString(subclause, lib) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					transitions.get(0) => [
						"transition3".assertEquals(name)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Target, expectedScope)
					]
					transitions.get(1) => [
						"transition4".assertEquals(name)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						destinationBranches.get(0).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target,
							expectedScope)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						destinationBranches.get(1).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target,
							expectedScope)
					]
					outgoingPropagationConditions.head => [
						"propagationCondition1".assertEquals(name)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.outgoingPropagationCondition_State, expectedScope)
					]
					errorDetections.head => [
						"detection1".assertEquals(name)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorDetection_State, expectedScope)
					]
					errorStateToModeMappings.head => [
						"bvr_state1".assertEquals(errorState.name)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorStateToModeMapping_ErrorState, expectedScope)
					]
					states.head => [
						"compositeState1".assertEquals(name)
						// Tests scope_ErrorBehaviorState(Classifier, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.compositeState_State, expectedScope)
					]
				]
			]
		]
	}

	// Tests scope_ConnectionErrorSource_connection
	@Test
	def void testConnectionReference() {
		val subclause = '''
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
		'''
		testHelper.parseString(subclause) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(3) => [
				"a2.i".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					connectionErrorSources.head => [
					"source1".assertEquals(name)
					// Tests scope_ConnectionErrorSource_connection
					assertScope(ErrorModelPackage.eINSTANCE.errorSource_SourceModelElement, #["conn1", "conn2"])
				]
			]
		]
	}

	// Tests scope_ReportingPortReference_element and ErrorCodeValue's constant reference
	@Test
	def void testErrorDetectionReferences() {
		val ps = '''
			property set ps1 is
				const1: constant aadlinteger => 42;
			end ps1;
		'''
		val subclause = '''
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
				annex EMV2 {**
					component error behavior
					detections
						detection1: all -[ access ]-> dp1!;
					end component;
				**};
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
						detection2: all -[ access ]-> dp1! (ps1::const1);
					end component;
				**};
				end a2.i;
			end subclause1;
		'''
		testHelper.parseString(subclause, ps) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(2) => [
				"a2".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					errorDetections.head => [
					"detection1".assertEquals(name)
					// Tests scope_ReportingPortReference_element
					detectionReportingPort.assertScope(ErrorModelPackage.eINSTANCE.reportingPortReference_Element,
						#["af1", "dp1", "ep1", "edp1", "af2", "dp2", "ep2", "edp2"])
				]
			]
			publicSection.ownedClassifiers.get(3) => [
				"a2.i".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					errorDetections.head => [
					"detection2".assertEquals(name)
					// Tests scope_ReportingPortReference_element
					detectionReportingPort.assertScope(ErrorModelPackage.eINSTANCE.reportingPortReference_Element, #[
						"af1",
						"dp1",
						"ep1",
						"edp1",
						"es1",
						"eds1",
						"af2",
						"dp2",
						"ep2",
						"edp2",
						"es2",
						"eds2"
					])
					// Tests ErrorCodeValue's constant reference
					errorCode.assertScope(ErrorModelPackage.eINSTANCE.errorCodeValue_Constant, #[
						"Max_Aadlinteger",
						"Max_Base_Address",
						"Max_Byte_Count",
						"Max_Memory_Size",
						"Max_Queue_Size",
						"Max_Target_Integer",
						"Max_Thread_Limit",
						"Max_Time",
						"Max_Urgency",
						"Max_Volume",
						"Max_Word_Space",
						"Supported_Classifier_Complement_Matches",
						"Supported_Classifier_Equivalence_Matches",
						"Supported_Classifier_Subset_Matches",
						"Supported_Type_Conversions",
						"ps1::const1",
						"AADL_Project::Max_Aadlinteger",
						"AADL_Project::Max_Base_Address",
						"AADL_Project::Max_Byte_Count",
						"AADL_Project::Max_Memory_Size",
						"AADL_Project::Max_Queue_Size",
						"AADL_Project::Max_Target_Integer",
						"AADL_Project::Max_Thread_Limit",
						"AADL_Project::Max_Time",
						"AADL_Project::Max_Urgency",
						"AADL_Project::Max_Volume",
						"AADL_Project::Max_Word_Space",
						"AADL_Project::Supported_Classifier_Complement_Matches",
						"AADL_Project::Supported_Classifier_Equivalence_Matches",
						"AADL_Project::Supported_Classifier_Subset_Matches",
						"AADL_Project::Supported_Type_Conversions"
					])
				]
			]
		]
	}

	// Tests scope_ErrorStateToModeMapping_mappedModes
	@Test
	def void testModeReference() {
		val lib = '''
			package lib1
			public
				annex EMV2 {**
					error behavior bvr1
					states
						bvr_state1: state;
					end behavior;
				**};
			end lib1;
		'''
		val subclause =  '''
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
		'''
		testHelper.parseString(subclause,lib) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a2".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					errorStateToModeMappings.head => [
					"bvr_state1".assertEquals(errorState.name)
					// Tests scope_ErrorStateToModeMapping_mappedModes
					assertScope(ErrorModelPackage.eINSTANCE.errorStateToModeMapping_MappedModes,
						#["m1", "m2", "m3", "m4"])
				]
			]
		]
	}

	// Tests scope_QualifiedErrorBehaviorState_state
	@Test
	def void testQualifiedErrorBehaviorState() {
		val lib = '''
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
		'''
		val subclause = '''
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
		'''
		testHelper.parseString(subclause, lib) => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					states.get(0) => [
						"compositeState1".assertEquals(name)
						(condition as SConditionElement).qualifiedState => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							// Tests scope_QualifiedErrorBehaviorState_state
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
								// Tests scope_QualifiedErrorBehaviorState_state
								assertScope(ErrorModelPackage.eINSTANCE.qualifiedErrorBehaviorState_State,
									#["bvr_state3"])
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
									// Tests scope_QualifiedErrorBehaviorState_state
									assertScope(ErrorModelPackage.eINSTANCE.qualifiedErrorBehaviorState_State,
										#["bvr_state4"])
									next.assertNull
								]
							]
						]
					]
				]
			]
		]
	}

	// Tests scope_EMV2PathElement_errorType
	@Test
	def void testEMV2PathElement_errorType() {
		val ps = '''
			property set ps1 is
				def1: aadlinteger applies to (all);
			end ps1;
		'''
		val pkg = '''
			package pkg1
			public
				with ps1;
				
				abstract a1
					annex EMV2 {**
						use types pkg1;
						
						error propagations
							memory: in propagation {t1};
							memory: not in propagation {t2};
							memory: out propagation {t3};
							memory: not out propagation {t4};
						end propagations;
						
						properties
							ps1::def1 => 1 applies to memory.t1;
					**};
				end a1;
				
				annex EMV2 {**
					error types
						t1: type;
						t2: type;
						t3: type;
						t4: type;
					end types;
				**};
			end pkg1;
		'''
		testHelper.parseString(pkg, ps) => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a1".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					properties.head => [
					1.assertEquals((ownedValues.head.ownedValue as IntegerLiteral).value)
					// Tests scope_EMV2PathElement_errorType
					emv2Path.head.emv2Target.assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_ErrorType,
						#["t1", "t2", "t3", "t4"])
				]
			]
		]
	}

	// Tests scope_BasicPropertyAssociation_property
	@Test
	def void testRecordFieldNameReference() {
		 val ps = '''
			property set ps1 is
				def1: record (
					field1: aadlinteger;
					field2: aadlinteger;
					field3: record (
						field4: aadlinteger;
						field5: aadlinteger;
						field6: record (
							field7: aadlinteger;
							field8: aadlinteger;
							field9: aadlinteger;
						);
					);
				) applies to (all);
			end ps1;
		'''
		val pkg = '''
			package pkg1
			public
				with ps1;
				
				annex EMV2 {**
					error types
						t1: type;
					properties
						ps1::def1 => [
							field1 => 1;
							field2 => 2;
							field3 => [
								field4 => 4;
								field5 => 5;
								field6 => [
									field7 => 7;
									field8 => 8;
									field9 => 9;
								];
							];
						] applies to t1;
					end types;
				**};
			end pkg1;
		'''
		testHelper.parseString(pkg, ps) => [
			"pkg1".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).
				properties.head.ownedValues.head.ownedValue as RecordValue => [
				val firstLevelScope = #["field1", "field2", "field3"]
				val secondLevelScope = #["field4", "field5", "field6"]
				val thirdLevelScope = #["field7", "field8", "field9"]
				ownedFieldValues.get(0) => [
					"field1".assertEquals(property.name)
					// Tests scope_BasicPropertyAssociation_property
					assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property, firstLevelScope)
				]
				ownedFieldValues.get(1) => [
					"field2".assertEquals(property.name)
					// Tests scope_BasicPropertyAssociation_property
					assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property, firstLevelScope)
				]
				ownedFieldValues.get(2) => [
					"field3".assertEquals(property.name)
					// Tests scope_BasicPropertyAssociation_property
					assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property, firstLevelScope)
					ownedValue as RecordValue => [
						ownedFieldValues.get(0) => [
							"field4".assertEquals(property.name)
							// Tests scope_BasicPropertyAssociation_property
							assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property, secondLevelScope)
						]
						ownedFieldValues.get(1) => [
							"field5".assertEquals(property.name)
							// Tests scope_BasicPropertyAssociation_property
							assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property, secondLevelScope)
						]
						ownedFieldValues.get(2) => [
							"field6".assertEquals(property.name)
							// Tests scope_BasicPropertyAssociation_property
							assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property, secondLevelScope)
							ownedValue as RecordValue => [
								ownedFieldValues.get(0) => [
									"field7".assertEquals(property.name)
									// Tests scope_BasicPropertyAssociation_property
									assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property,
										thirdLevelScope)
								]
								ownedFieldValues.get(1) => [
									"field8".assertEquals(property.name)
									// Tests scope_BasicPropertyAssociation_property
									assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property,
										thirdLevelScope)
								]
								ownedFieldValues.get(2) => [
									"field9".assertEquals(property.name)
									// Tests scope_BasicPropertyAssociation_property
									assertScope(Aadl2Package.eINSTANCE.basicPropertyAssociation_Property,
										thirdLevelScope)
								]
							]
						]
					]
				]
			]
		]
	}

	// Tests scope_ContainmentPathElement_namedElement
	@Test
	def void testUnitLiteralReference() {
		val ps = '''
			property set ps1 is
				def1: aadlinteger units Time_Units applies to (all);
				def2: record (
					field1: aadlreal units Data_Rate_Units;
					field2: record (
						field3: range of aadlinteger units Processor_Speed_Units;
						field4: record (
							field5: range of aadlreal units Size_Units;
						);
					);
				) applies to (all);
			end ps1;
		'''
		val pkg = '''
			package pkg1
			public
				with ps1;
				
				system s
				end s;
				
				annex EMV2 {**
					error types
						t1: type;
					properties
						ps1::def1 => 1 ms applies to t1;
						ps1::def2 => [
							field1 => 2.2 Bytesps;
							field2 => [
								field3 => 3 KIPS .. 4 GIPS;
								field4 => [
									field5 => 5.5 bits .. 6.6 TByte;
								];
							];
						] applies to t1;
					end types;
				**};
			end pkg1;
		'''
		testHelper.parseString(pkg, ps) => [
			"pkg1".assertEquals(name)
			(publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
				properties.get(0) => [
					"def1".assertEquals(property.name)
					// Tests scope_ContainmentPathElement_namedElement
					ownedValues.head.ownedValue.assertScope(Aadl2Package.eINSTANCE.numberValue_Unit,
						#["ps", "ns", "us", "ms", "sec", "min", "hr"])
				]
				properties.get(1) => [
					"def2".assertEquals(property.name)
					ownedValues.head.ownedValue as RecordValue => [
						ownedFieldValues.get(0) => [
							"field1".assertEquals(property.name)
							// Tests scope_ContainmentPathElement_namedElement
							ownedValue.assertScope(Aadl2Package.eINSTANCE.numberValue_Unit,
								#["bitsps", "Bytesps", "KBytesps", "MBytesps", "GBytesps"])
						]
						ownedFieldValues.get(1) => [
							"field2".assertEquals(property.name)
							ownedValue as RecordValue => [
								ownedFieldValues.get(0) => [
									"field3".assertEquals(property.name)
									ownedValue as RangeValue => [
										// Tests scope_ContainmentPathElement_namedElement
										minimum.assertScope(Aadl2Package.eINSTANCE.numberValue_Unit,
											#["KIPS", "MIPS", "GIPS"])
										// Tests scope_ContainmentPathElement_namedElement
										maximum.assertScope(Aadl2Package.eINSTANCE.numberValue_Unit,
											#["KIPS", "MIPS", "GIPS"])
									]
								]
								ownedFieldValues.get(1) => [
									"field4".assertEquals(property.name)
									(ownedValue as RecordValue).ownedFieldValues.head => [
										"field5".assertEquals(property.name)
										ownedValue as RangeValue => [
											// Tests scope_ContainmentPathElement_namedElement
											minimum.assertScope(Aadl2Package.eINSTANCE.numberValue_Unit,
												#["bits", "Bytes", "KByte", "MByte", "GByte", "TByte"])
											// Tests scope_ContainmentPathElement_namedElement
											maximum.assertScope(Aadl2Package.eINSTANCE.numberValue_Unit,
												#["bits", "Bytes", "KByte", "MByte", "GByte", "TByte"])
										]
									]
								]
							]
						]
					]
				]
			]
		]
	}
}
