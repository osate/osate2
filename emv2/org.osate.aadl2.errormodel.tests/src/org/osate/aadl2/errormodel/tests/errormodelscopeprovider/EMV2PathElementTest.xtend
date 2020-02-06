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
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.StringLiteral
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.AssertHelper
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull
import static extension org.osate.testsupport.AssertHelper.assertError
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getPropagationName

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class EMV2PathElementTest extends XtextTest {

	@Inject
	TestHelper<AadlPackage> testHelper

	extension AssertHelper assertHelper = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(
		URI.createFileURI("dummy.emv2")).get(AssertHelper)

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelLibrary -> ErrorBehaviorStateMachine ->
	 * 		ErrorBehaviorTransition -> ConditionExpression -> ... -> QualifiedErrorEventOrPropagation ->
	 * 		EMV2ErrorPropagationPath
	 */
	@Test
	def void testErrorBehaviorTransitionInErrorBehaviorStateMachine() {
		val aadlText = '''
			package ErrorBehaviorTransition_in_ErrorBehaviorStateMachine
			public
				annex EMV2 {**
					error behavior bvr1
					events
						evt1: error event;
					transitions
						trans1: all -[ evt1 ]-> same state;
					end behavior;
				**};
			end ErrorBehaviorTransition_in_ErrorBehaviorStateMachine;
		'''
		val pkg = testHelper.parseString(aadlText)
		pkg => [
			"ErrorBehaviorTransition_in_ErrorBehaviorStateMachine".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).
				behaviors.head => [
				"bvr1".assertEquals(name)
				transitions.head => [
					"trans1".assertEquals(name)
					(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
						"evt1".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["evt1"])
						path.assertNull
					]
				]
			]
		]
	}

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> ErrorBehaviorTransition ->
	 * 		ConditionExpression -> ... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	def void testErrorBehaviorTransitionInErrorModelSubclause() {
		val aadlText = '''
			package ErrorBehaviorTransition_in_ErrorModelSubclause
			public
				abstract a1
					features
						port1: in event port;
						port2: in event port;
						fg1: feature group fgt1;
					annex EMV2 {**
						use types ErrorBehaviorTransition_in_ErrorModelSubclause;
						use behavior ErrorBehaviorTransition_in_ErrorModelSubclause::bvr1;
						
						error propagations
							port1: in propagation {t1};
							fg1.fg2.fg3.port3: in propagation {t1};
						end propagations;
						
						component error behavior
						events
							evt1: error event;
						end component;
					**};
				end a1;
				
				abstract implementation a1.i
					subcomponents
						asub1: abstract a2.i;
					annex EMV2 {**
						error propagations
							port2: in propagation {t1};
							fg1.fg2.fg3.port4: in propagation {t1};
						end propagations;
						
						component error behavior
						events
							evt2: error event;
						transitions
							trans1: all -[ evt1 ]-> same state;
							trans2: all -[ evt2 ]-> same state;
							trans3: all -[ evt3 ]-> same state;
							trans4: all -[ port1 ]-> same state;
							trans5: all -[ port2 ]-> same state;
							trans6: all -[ fg1.fg2.fg3.port3 ]-> same state;
							trans7: all -[ fg1.fg2.fg3.port4 ]-> same state;
							trans8: all -[ asub1.port5 ]-> same state;
							trans9: all -[ asub1.fg4.port3 ]-> same state;
							trans10: all -[ asub1.asub2.asub3.fg5.fg2.fg3.port3 ]-> same state;
						end component;
					**};
				end a1.i;
				
				feature group fgt1
					features
						fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
					features
						fg3: feature group fgt3;
				end fgt2;
				
				feature group fgt3
					features
						port3: in out event port;
						port4: in event port;
				end fgt3;
				
				abstract a2
					features
						port5: out event port;
						fg4: feature group fgt3;
				end a2;
				
				abstract implementation a2.i
					subcomponents
						asub2: abstract a3.i;
					annex EMV2 {**
						use types ErrorBehaviorTransition_in_ErrorModelSubclause;
						
						error propagations
							port5: out propagation {t1};
							fg4.port3: out propagation {t1};
						end propagations;
					**};
				end a2.i;
				
				abstract a3
				end a3;
				
				abstract implementation a3.i
					subcomponents
						asub3: abstract a4.i;
				end a3.i;
				
				abstract a4
					features
						fg5: feature group fgt1;
				end a4;
				
				abstract implementation a4.i
					annex EMV2 {**
						use types ErrorBehaviorTransition_in_ErrorModelSubclause;
						
						error propagations
							fg5.fg2.fg3.port3: in propagation {t1};
						end propagations;
					**};
				end a4.i;
				
				annex EMV2 {**
					error types
						t1: type;
					end types;
					
					error behavior bvr1
					events
						evt3: error event;
					end behavior;
				**};
			end ErrorBehaviorTransition_in_ErrorModelSubclause;
		'''
		val pkg = testHelper.parseString(aadlText)
		pkg => [
			"ErrorBehaviorTransition_in_ErrorModelSubclause".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val firstElementScope = #["evt1", "evt2", "evt3", "port1", "port2", "fg1", "asub1"]
					transitions.get(0) => [
						"trans1".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					transitions.get(1) => [
						"trans2".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					transitions.get(2) => [
						"trans3".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					transitions.get(3) => [
						"trans4".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					transitions.get(4) => [
						"trans5".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port2".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					transitions.get(5) => [
						"trans6".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port3".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
										path.assertNull
									]
								]
							]
						]
					]
					transitions.get(6) => [
						"trans7".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port4".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
										path.assertNull
									]
								]
							]
						]
					]
					transitions.get(7) => [
						"trans8".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"port5".assertEquals((namedElement as ErrorPropagation).propagationName)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path.assertNull
							]
						]
					]
					transitions.get(8) => [
						"trans9".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg4".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path => [
									"fg4.port3".assertEquals((namedElement as ErrorPropagation).propagationName)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["port3"])
									path.assertNull
								]
							]
						]
					]
					transitions.get(9) => [
						"trans10".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"asub2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path => [
									"asub3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["asub3"])
									path => [
										"fg5".assertEquals(namedElement.name)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg5"])
										path => [
											"fg2".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
												#["fg2"])
											path => [
												"fg3".assertEquals(namedElement.name)
												// Tests scope_EMV2PathElement_namedElement
												assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
													#["fg3"])
												path => [
													"fg5.fg2.fg3.port3".assertEquals(
														(namedElement as ErrorPropagation).propagationName)
													// Tests scope_EMV2PathElement_namedElement
													assertScope(
														ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
														#["port3"])
													path.assertNull
												]
											]
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

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> OutgoingPropagationCondition ->
	 * 		ConditionExpression -> ... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	def void testOutgoingPropagationCondition() {
		val aadlText = '''
			package OutgoingPropagationCondition
			public
				abstract a1
					features
						port1: in event port;
						port2: in event port;
						fg1: feature group fgt1;
					annex EMV2 {**
						use types OutgoingPropagationCondition;
						use behavior OutgoingPropagationCondition::bvr1;
						
						error propagations
							port1: in propagation {t1};
							fg1.fg2.fg3.port3: in propagation {t1};
						end propagations;
						
						component error behavior
						events
							evt1: error event;
						end component;
					**};
				end a1;
				
				abstract implementation a1.i
					subcomponents
						asub1: abstract a2.i;
					annex EMV2 {**
						error propagations
							port2: in propagation {t1};
							fg1.fg2.fg3.port4: in propagation {t1};
						end propagations;
						
						component error behavior
						events
							evt2: error event;
						propagations
							condition1: all -[ evt1 ]-> all;
							condition2: all -[ evt2 ]-> all;
							condition3: all -[ evt3 ]-> all;
							condition4: all -[ port1 ]-> all;
							condition5: all -[ port2 ]-> all;
							condition6: all -[ fg1.fg2.fg3.port3 ]-> all;
							condition7: all -[ fg1.fg2.fg3.port4 ]-> all;
							condition8: all -[ asub1.port5 ]-> all;
							condition9: all -[ asub1.fg4.port3 ]-> all;
							condition10: all -[ asub1.asub2.asub3.fg5.fg2.fg3.port3 ]-> all;
						end component;
					**};
				end a1.i;
				
				feature group fgt1
					features
						fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
					features
						fg3: feature group fgt3;
				end fgt2;
				
				feature group fgt3
					features
						port3: in out event port;
						port4: in event port;
				end fgt3;
				
				abstract a2
					features
						port5: out event port;
						fg4: feature group fgt3;
				end a2;
				
				abstract implementation a2.i
					subcomponents
						asub2: abstract a3.i;
					annex EMV2 {**
						use types OutgoingPropagationCondition;
						
						error propagations
							port5: out propagation {t1};
							fg4.port3: out propagation {t1};
						end propagations;
					**};
				end a2.i;
				
				abstract a3
				end a3;
				
				abstract implementation a3.i
					subcomponents
						asub3: abstract a4.i;
				end a3.i;
				
				abstract a4
					features
						fg5: feature group fgt1;
				end a4;
				
				abstract implementation a4.i
					annex EMV2 {**
						use types OutgoingPropagationCondition;
						
						error propagations
							fg5.fg2.fg3.port3: in propagation {t1};
						end propagations;
					**};
				end a4.i;
				
				annex EMV2 {**
					error types
						t1: type;
					end types;
					
					error behavior bvr1
					events
						evt3: error event;
					end behavior;
				**};
			end OutgoingPropagationCondition;
		'''
		val pkg = testHelper.parseString(aadlText)
		pkg => [
			"OutgoingPropagationCondition".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val firstElementScope = #["asub1", "evt1", "evt2", "evt3", "port1", "port2", "fg1"]
					outgoingPropagationConditions.get(0) => [
						"condition1".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					outgoingPropagationConditions.get(1) => [
						"condition2".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					outgoingPropagationConditions.get(2) => [
						"condition3".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					outgoingPropagationConditions.get(3) => [
						"condition4".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					outgoingPropagationConditions.get(4) => [
						"condition5".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port2".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					outgoingPropagationConditions.get(5) => [
						"condition6".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Test scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port3".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
										path.assertNull
									]
								]
							]
						]
					]
					outgoingPropagationConditions.get(6) => [
						"condition7".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port4".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
										path.assertNull
									]
								]
							]
						]
					]
					outgoingPropagationConditions.get(7) => [
						"condition8".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"port5".assertEquals((namedElement as ErrorPropagation).propagationName)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path.assertNull
							]
						]
					]
					outgoingPropagationConditions.get(8) => [
						"condition9".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg4".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path => [
									"fg4.port3".assertEquals((namedElement as ErrorPropagation).propagationName)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["port3"])
									path.assertNull
								]
							]
						]
					]
					outgoingPropagationConditions.get(9) => [
						"condition10".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"asub2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path => [
									"asub3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["asub3"])
									path => [
										"fg5".assertEquals(namedElement.name)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg5"])
										path => [
											"fg2".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
												#["fg2"])
											path => [
												"fg3".assertEquals(namedElement.name)
												// Tests scope_EMV2PathElement_namedElement
												assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
													#["fg3"])
												path => [
													"fg5.fg2.fg3.port3".assertEquals(
														(namedElement as ErrorPropagation).propagationName)
													// Tests scope_EMV2PathElement_namedElement
													assertScope(
														ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
														#["port3"])
													path.assertNull
												]
											]
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

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> ErrorDetection ->
	 * 		ConditionExpression -> ... -> QualifiedErrorEventOrPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	def void testErrorDetection() {
		val aadlText = '''
			package ErrorDetection
			public
				abstract a1
					features
						port1: in event port;
						port2: in event port;
						fg1: feature group fgt1;
					annex EMV2 {**
						use types ErrorDetection;
						use behavior ErrorDetection::bvr1;
						
						error propagations
							port1: in propagation {t1};
							fg1.fg2.fg3.port3: in propagation {t1};
						end propagations;
						
						component error behavior
						events
							evt1: error event;
						end component;
					**};
				end a1;
				
				abstract implementation a1.i
					subcomponents
						asub1: abstract a2.i;
					annex EMV2 {**
						error propagations
							port2: in propagation {t1};
							fg1.fg2.fg3.port4: in propagation {t1};
						end propagations;
						
						component error behavior
						events
							evt2: error event;
						detections
							detection1: all -[ evt1 ]-> port1!;
							detection2: all -[ evt2 ]-> port1!;
							detection3: all -[ evt3 ]-> port1!;
							detection4: all -[ port1 ]-> port1!;
							detection5: all -[ port2 ]-> port1!;
							detection6: all -[ fg1.fg2.fg3.port3 ]-> port1!;
							detection7: all -[ fg1.fg2.fg3.port4 ]-> port1!;
							detection8: all -[ asub1.port5 ]-> port1!;
							detection9: all -[ asub1.fg4.port3 ]-> port1!;
							detection10: all -[ asub1.asub2.asub3.fg5.fg2.fg3.port3 ]-> port1!;
						end component;
					**};
				end a1.i;
				
				feature group fgt1
					features
						fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
					features
						fg3: feature group fgt3;
				end fgt2;
				
				feature group fgt3
					features
						port3: in out event port;
						port4: in event port;
				end fgt3;
				
				abstract a2
					features
						port5: out event port;
						fg4: feature group fgt3;
				end a2;
				
				abstract implementation a2.i
					subcomponents
						asub2: abstract a3.i;
					annex EMV2 {**
						use types ErrorDetection;
						
						error propagations
							port5: out propagation {t1};
							fg4.port3: out propagation {t1};
						end propagations;
					**};
				end a2.i;
				
				abstract a3
				end a3;
				
				abstract implementation a3.i
					subcomponents
						asub3: abstract a4.i;
				end a3.i;
				
				abstract a4
					features
						fg5: feature group fgt1;
				end a4;
				
				abstract implementation a4.i
					annex EMV2 {**
						use types ErrorDetection;
						
						error propagations
							fg5.fg2.fg3.port3: in propagation {t1};
						end propagations;
					**};
				end a4.i;
				
				annex EMV2 {**
					error types
						t1: type;
					end types;
					
					error behavior bvr1
					events
						evt3: error event;
					end behavior;
				**};
			end ErrorDetection;
		'''
		val pkg = testHelper.parseString(aadlText)
		pkg => [
			"ErrorDetection".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val firstElementScope = #["evt1", "evt2", "evt3", "port1", "port2", "fg1", "asub1"]
					errorDetections.get(0) => [
						"detection1".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					errorDetections.get(1) => [
						"detection2".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					errorDetections.get(2) => [
						"detection3".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"evt3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					errorDetections.get(3) => [
						"detection4".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					errorDetections.get(4) => [
						"detection5".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port2".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					errorDetections.get(5) => [
						"detection6".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port3".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
										path.assertNull
									]
								]
							]
						]
					]
					errorDetections.get(6) => [
						"detection7".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port4".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
									]
								]
							]
						]
					]
					errorDetections.get(7) => [
						"detection8".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"port5".assertEquals((namedElement as ErrorPropagation).propagationName)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path.assertNull
							]
						]
					]
					errorDetections.get(8) => [
						"detection9".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg4".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path => [
									"fg4.port3".assertEquals((namedElement as ErrorPropagation).propagationName)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["port3"])
									path.assertNull
								]
							]
						]
					]
					errorDetections.get(9) => [
						"detection10".assertEquals(name)
						(condition as ConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"asub1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"asub2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
									#["asub2", "fg4", "port5"])
								path => [
									"asub3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["asub3"])
									path => [
										"fg5".assertEquals(namedElement.name)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg5"])
										path => [
											"fg2".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
												#["fg2"])
											path => [
												"fg3".assertEquals(namedElement.name)
												// Tests scope_EMV2PathElement_namedElement
												assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
													#["fg3"])
												path => [
													"fg5.fg2.fg3.port3".assertEquals(
														(namedElement as ErrorPropagation).propagationName)
													// Tests scope_EMV2PathElement_namedElement
													assertScope(
														ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
														#["port3"])
													path.assertNull
												]
											]
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

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> CompositeState ->
	 * 		SConditionExpression -> ... -> QualifiedErrorPropagation -> EMV2ErrorPropagationPath
	 */
	@Test
	def void testCompositeState() {
		val aadlText = '''
			package CompositeState
			public
				abstract a1
					features
						port1: in event port;
						port2: in event port;
						fg1: feature group fgt1;
					annex EMV2 {**
						use types CompositeState;
						
						error propagations
							port1: in propagation {t1};
							fg1.fg2.fg3.port3: in propagation {t1};
						end propagations;
					**};
				end a1;
				
				abstract implementation a1.i
					annex EMV2 {**
						use behavior CompositeState::bvr1;
						
						error propagations
							port2: in propagation {t1};
							fg1.fg2.fg3.port4: in propagation {t1};
						end propagations;
						
						composite error behavior
						states
							state1: [ in port1 ]-> state2;
							state2: [ in port2 ]-> state2;
							state3: [ in fg1.fg2.fg3.port3 ]-> state2;
							state4: [ in fg1.fg2.fg3.port4 ]-> state2;
						end composite;
					**};
				end a1.i;
				
				feature group fgt1
					features
						fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
					features
						fg3: feature group fgt3;
				end fgt2;
				
				feature group fgt3
					features
						port3: in event port;
						port4: in event port;
				end fgt3;
				
				annex EMV2 {**
					error types
						t1: type;
					end types;
					
					error behavior bvr1
					states
						state2: state;
					end behavior;
				**};
			end CompositeState;
		'''
		val pkg = testHelper.parseString(aadlText)
		pkg => [
			"CompositeState".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val firstElementScope = #["port1", "port2", "fg1"]
					states.get(0) => [
						"state1".assertEquals(name)
						(condition as SConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					states.get(1) => [
						"state2".assertEquals(name)
						(condition as SConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"port2".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					states.get(2) => [
						"state3".assertEquals(name)
						(condition as SConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port3".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
										path.assertNull
									]
								]
							]
						]
					]
					states.get(3) => [
						"state4".assertEquals(name)
						(condition as SConditionElement).qualifiedErrorPropagationReference.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port4".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port3", "port4"])
										path.assertNull
									]
								]
							]
						]
					]
				]
			]
		]
	}

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelLibrary -> BasicEMV2PropertyAssociation ->
	 * 		BasicEMV2Path -> EMV2PathElementOrKind
	 */
	@Test
	def void testBasicEMV2PropertyAssociationInErrorModelLibrary() {
		val aadlText = '''
			package lib1
			public
				annex EMV2 {**
					error types
						t2: type;
						ts2: type set {t2};
					end types;
				**};
			end lib1;
		'''
		val aadlText1 = '''
			package BasicEMV2PropertyAssociation_in_ErrorModelLibrary
			public
				annex EMV2 {**
					error types extends lib1 with
						t1: type;
						ts1: type set {t1};
					properties
						EMV2::ExposurePeriod => 1.1 applies to t1;
						EMV2::ExposurePeriod => 2.2 applies to ts1;
						EMV2::ExposurePeriod => 3.3 applies to t2;
						EMV2::ExposurePeriod => 4.4 applies to ts2;
					end types;
				**};
			end BasicEMV2PropertyAssociation_in_ErrorModelLibrary;
		'''
		val pkg = testHelper.parseString(aadlText1, aadlText)
		pkg => [
			"BasicEMV2PropertyAssociation_in_ErrorModelLibrary".assertEquals(name)
			(publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
				val scope = #["t1", "ts1", "t2", "ts2"]
				properties.get(0) => [
					1.1.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
					emv2Path.head.emv2Target => [
						"t1".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, scope)
						path.assertNull
					]
				]
				properties.get(1) => [
					2.2.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
					emv2Path.head.emv2Target => [
						"ts1".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, scope)
						path.assertNull
					]
				]
				properties.get(2) => [
					3.3.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
					emv2Path.head.emv2Target => [
						"t2".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, scope)
						path.assertNull
					]
				]
				properties.get(3) => [
					4.4.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
					emv2Path.head.emv2Target => [
						"ts2".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, scope)
						path.assertNull
					]
				]
			]
		]
	}

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelLibrary -> ErrorBehaviorStateMachine ->
	 * 		BasicEMV2PropertyAssociation -> BasicEMV2Path -> EMV2PathElementOrKind
	 */
	@Test
	def void testBasicEMV2PropertyAssociationInErrorBehaviorStateMachine() {
		val aadlText = '''
			package BasicEMV2PropertyAssociation_in_ErrorBehaviorStateMachine
			public
				with EMV2;
				
				annex EMV2 {**
					error behavior bvr1
					events
						evt1: error event;
					states
						state1: state;
					transitions
						trans1: all -[ evt1 ]-> same state;
					properties
						EMV2::ExposurePeriod => 1.1 applies to evt1;
						EMV2::ExposurePeriod => 2.2 applies to state1;
						EMV2::ExposurePeriod => 3.3 applies to trans1;
					end behavior;
				**};
			end BasicEMV2PropertyAssociation_in_ErrorBehaviorStateMachine;
		'''
		val testResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testResult.resource, newArrayList, newArrayList)
		testResult.resource.contents.head as AadlPackage => [
			"BasicEMV2PropertyAssociation_in_ErrorBehaviorStateMachine".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).
				behaviors.head => [
				"bvr1".assertEquals(name)
				val scope = #["evt1", "state1", "trans1"]
				properties.get(0) => [
					1.1.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
					emv2Path.head.emv2Target => [
						"evt1".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, scope)
						path.assertNull
					]
				]
				properties.get(1) => [
					2.2.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
					emv2Path.head.emv2Target => [
						"state1".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, scope)
						path.assertNull
					]
				]
				properties.get(2) => [
					assertError(testResult.issues, issueCollection,
						"Property EMV2::ExposurePeriod does not apply to trans1")
					3.3.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
					emv2Path.head.emv2Target => [
						"trans1".assertEquals(namedElement.name)
						// Tests scope_EMV2PathElement_namedElement
						assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, scope)
						path.assertNull
					]
				]
			]
		]
		issueCollection.sizeIs(testResult.issues.size)
		assertConstraints(issueCollection)
	}

	/*
	 * Tests scope_EMV2PathElement_namedElement for grammar path: ErrorModelSubclause -> EMV2PropertyAssociation ->
	 * 		EMV2Path -> EMV2PathElementOrKind
	 */
	@Test
	def void testEMV2PropertyAssociation() {
		val aadlText = '''
			property set ps1 is
				real1: aadlreal applies to (all);
				ref1: reference (element) applies to (all);
			end ps1;
		'''
		val aadlText1 = '''
			package EMV2PropertyAssociation
			public
				with ps1;
				with EMV2;
				
				abstract a1
					features
						port1: in out event port;
						fg1: feature group fgt1;
					annex EMV2 {**
						use types EMV2PropertyAssociation;
						use behavior EMV2PropertyAssociation::bvr1;
						
						error propagations
							port1: in propagation {t1};
							port1: not in propagation {t2};
							port1: out propagation {t3};
							port1: not out propagation {t4};
							fg1.fg2.fg3.port2: in propagation {t1};
							fg1.fg2.fg3.port2: not in propagation {t2};
							fg1.fg2.fg3.port2: out propagation {t3};
							fg1.fg2.fg3.port2: not out propagation {t4};
						flows
							errorSource1: error source all {t3};
							errorSink1: error sink all {t1};
							errorPath1: error path all -> all;
						end propagations;
						
						component error behavior
						events
							errorEvent1: error event {t1};
							repairEvent1: repair event;
							recoverEvent1: recover event;
						transitions
							transition1: all -[ errorEvent1 ]-> state1;
						propagations
							outgoingPropagationCondition1: all -[ errorEvent1 ]-> all;
						detections
							detection1: all -[ errorEvent1 ]-> port1!;
						end component;
						
						composite error behavior
						states
							compositeState1: [ others ]-> state1;
						end composite;
						
						connection error
							connectionErrorSource1: error source all {t1};
						end connection;
					**};
				end a1;
				
				abstract implementation a1.i
					subcomponents
						asub1: abstract a2.i;
					annex EMV2 {**
						propagation paths
							propagationPath1: asub1.asub2.asub3.propagationPoint1 -> asub1.asub2.asub3.propagationPoint1;
							asub1.asub2.asub3.propagationPoint1 -> asub1.asub2.asub3.propagationPoint1;
						end paths;
						
						properties
							EMV2::ExposurePeriod => 1.1 applies to port1;
							EMV2::ExposurePeriod => 2.2 applies to port1.t1;
							EMV2::ExposurePeriod => 3.3 applies to port1.t2;
							EMV2::ExposurePeriod => 4.4 applies to port1.t3;
							EMV2::ExposurePeriod => 5.5 applies to port1.t4;
							EMV2::ExposurePeriod => 6.6 applies to fg1.fg2.fg3.port2;
							EMV2::ExposurePeriod => 7.7 applies to fg1.fg2.fg3.port2.t1;
							EMV2::ExposurePeriod => 8.8 applies to fg1.fg2.fg3.port2.t2;
							EMV2::ExposurePeriod => 9.9 applies to fg1.fg2.fg3.port2.t3;
							EMV2::ExposurePeriod => 10.10 applies to fg1.fg2.fg3.port2.t4;
							EMV2::ExposurePeriod => 11.11 applies to ^asub1.asub2.asub3@port3;
							EMV2::ExposurePeriod => 12.12 applies to ^asub1.asub2.asub3@port3.t1;
							EMV2::ExposurePeriod => 13.13 applies to ^asub1.asub2.asub3@port3.t2;
							EMV2::ExposurePeriod => 14.14 applies to ^asub1.asub2.asub3@port3.t3;
							EMV2::ExposurePeriod => 15.15 applies to ^asub1.asub2.asub3@port3.t4;
							EMV2::ExposurePeriod => 16.16 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2;
							EMV2::ExposurePeriod => 17.17 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t1;
							EMV2::ExposurePeriod => 18.18 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t2;
							EMV2::ExposurePeriod => 19.19 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t3;
							EMV2::ExposurePeriod => 20.20 applies to ^asub1.asub2.asub3@fg4.fg2.fg3.port2.t4;
							EMV2::ExposurePeriod => 21.21 applies to errorSource1;
							EMV2::ExposurePeriod => 22.22 applies to errorSource1.t3;
							EMV2::ExposurePeriod => 23.23 applies to ^asub1.asub2.asub3@errorSource2;
							EMV2::ExposurePeriod => 24.24 applies to ^asub1.asub2.asub3@errorSource2.t3;
							EMV2::ExposurePeriod => 25.25 applies to errorSink1;
							EMV2::ExposurePeriod => 26.26 applies to errorSink1.t1;
							EMV2::ExposurePeriod => 27.27 applies to ^asub1.asub2.asub3@errorSink2;
							EMV2::ExposurePeriod => 28.28 applies to ^asub1.asub2.asub3@errorSink2.t1;
							EMV2::ExposurePeriod => 29.29 applies to errorPath1;
							EMV2::ExposurePeriod => 30.30 applies to ^asub1.asub2.asub3@errorPath2;
							EMV2::ExposurePeriod => 31.31 applies to errorEvent1;
							EMV2::ExposurePeriod => 32.32 applies to errorEvent1.t1;
							EMV2::ExposurePeriod => 33.33 applies to ^asub1.asub2.asub3@errorEvent2;
							EMV2::ExposurePeriod => 34.34 applies to ^asub1.asub2.asub3@errorEvent2.t1;
							EMV2::ExposurePeriod => 35.35 applies to errorEvent3;
							EMV2::ExposurePeriod => 36.36 applies to errorEvent3.t1;
							EMV2::ExposurePeriod => 37.37 applies to ^asub1.asub2.asub3@errorEvent3;
							EMV2::ExposurePeriod => 38.38 applies to ^asub1.asub2.asub3@errorEvent3.t1;
							EMV2::ExposurePeriod => 39.39 applies to repairEvent1;
							EMV2::ExposurePeriod => 40.40 applies to ^asub1.asub2.asub3@repairEvent2;
							EMV2::ExposurePeriod => 41.41 applies to repairEvent3;
							EMV2::ExposurePeriod => 42.42 applies to ^asub1.asub2.asub3@repairEvent3;
							EMV2::ExposurePeriod => 43.43 applies to recoverEvent1;
							EMV2::ExposurePeriod => 44.44 applies to ^asub1.asub2.asub3@recoverEvent2;
							EMV2::ExposurePeriod => 45.45 applies to recoverEvent3;
							EMV2::ExposurePeriod => 46.46 applies to ^asub1.asub2.asub3@recoverEvent3;
							EMV2::TransientFailureRatio => 47.47 applies to transition1;
							EMV2::TransientFailureRatio => 48.48 applies to transition3;
							EMV2::TransientFailureRatio => 49.49 applies to ^asub1.asub2.asub3@transition2;
							EMV2::TransientFailureRatio => 50.50 applies to ^asub1.asub2.asub3@transition3;
							EMV2::ExposurePeriod => 51.51 applies to outgoingPropagationCondition1;
							ps1::real1 => 52.52 applies to ^asub1.asub2.asub3@outgoingPropagationCondition2;
							EMV2::ExposurePeriod => 53.53 applies to detection1;
							EMV2::DetectionMechanism => "54" applies to ^asub1.asub2.asub3@detection2;
							EMV2::ExposurePeriod => 55.55 applies to compositeState1;
							ps1::real1 => 56.56 applies to ^asub1.asub2.asub3@compositeState2;
							EMV2::ExposurePeriod => 57.57 applies to connectionErrorSource1;
							EMV2::ExposurePeriod => 58.58 applies to connectionErrorSource1.t1;
							ps1::real1 => 59.59 applies to ^asub1.asub2.asub3@connectionErrorSource2;
							EMV2::ExposurePeriod => 60.60 applies to ^asub1.asub2.asub3@connectionErrorSource2.t1;
							EMV2::ExposurePeriod => 61.61 applies to propagationPath1;
							ps1::real1 => 62.62 applies to ^asub1.asub2.asub3@propagationPath2;
							EMV2::ExposurePeriod => 63.63 applies to state1;
							EMV2::ExposurePeriod => 64.64 applies to state1.t1;
							EMV2::ExposurePeriod => 65.65 applies to ^asub1.asub2.asub3@state1;
							EMV2::ExposurePeriod => 66.66 applies to ^asub1.asub2.asub3@state1.t1;
					**};
				end a1.i;
				
				feature group fgt1
					features
						fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
					features
						fg3: feature group fgt3;
				end fgt2;
				
				feature group fgt3
					features
						port2: in out event port;
				end fgt3;
				
				abstract a2
				end a2;
				
				abstract implementation a2.i
					subcomponents
						asub2: abstract a3.i;
				end a2.i;
				
				abstract a3
				end a3;
				
				abstract implementation a3.i
					subcomponents
						asub3: abstract a4.i;
				end a3.i;
				
				abstract a4
					features
						port3: in out event port;
						fg4: feature group fgt1;
					annex EMV2 {**
						use types EMV2PropertyAssociation;
						use behavior EMV2PropertyAssociation::bvr1;
						
						error propagations
							port3: in propagation {t1};
							port3: not in propagation {t2};
							port3: out propagation {t3};
							port3: not out propagation {t4};
							fg4.fg2.fg3.port2: in propagation {t1};
							fg4.fg2.fg3.port2: not in propagation {t2};
							fg4.fg2.fg3.port2: out propagation {t3};
							fg4.fg2.fg3.port2: not out propagation {t4};
						flows
							errorSource2: error source all {t3};
							errorSink2: error sink all {t1};
							errorPath2: error path all -> all;
						end propagations;
						
						component error behavior
						events
							errorEvent2: error event {t1};
							repairEvent2: repair event;
							recoverEvent2: recover event;
						transitions
							transition2: all -[ errorEvent2 ]-> state1;
						propagations
							outgoingPropagationCondition2: all -[ errorEvent2 ]-> all;
						detections
							detection2: all -[ errorEvent2 ]-> port3!;
						end component;
						
						composite error behavior
						states
							compositeState2: [ others ]-> state1;
						end composite;
						
						connection error
							connectionErrorSource2: error source all {t1};
						end connection;
						
						propagation paths
							propagationPoint1: propagation point;
						end paths;
					**};
				end a4;
				
				abstract implementation a4.i
					subcomponents
						asub4: abstract a5;
					annex EMV2 {**
						propagation paths
							propagationPath2: asub4.propagationPoint2 -> asub4.propagationPoint2;
						end paths;
					**};
				end a4.i;
				
				abstract a5
					annex EMV2 {**
						propagation paths
							propagationPoint2: propagation point;
						end paths;
					**};
				end a5;
				
				annex EMV2 {**
					error types
						t1: type;
						t2: type;
						t3: type;
						t4: type;
					end types;
					
					error behavior bvr1 use types EMV2PropertyAssociation;
					events
						errorEvent3: error event {t1};
						repairEvent3: repair event;
						recoverEvent3: recover event;
					states
						state1: initial state {t1};
					transitions
						transition3: all -[ errorEvent3 ]-> state1;
					end behavior;
				**};
			end EMV2PropertyAssociation;
		'''
		val lib1TestResult = issues = testHelper.testString(aadlText1, aadlText)
		val lib1IssueCollection = new FluentIssueCollection(lib1TestResult.resource, newArrayList, newArrayList)
		lib1TestResult.resource.contents.head as AadlPackage => [
			"EMV2PropertyAssociation".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val firstElementScope = #[
						"compositeState1",
						"connectionErrorSource1",
						"detection1",
						"errorEvent1",
						"errorEvent3",
						"errorPath1",
						"errorSink1",
						"errorSource1",
						"fg1",
						"outgoingPropagationCondition1",
						"port1",
						"port1",
						"port1",
						"port1",
						"propagationPath1",
						"recoverEvent1",
						"recoverEvent3",
						"repairEvent1",
						"repairEvent3",
						"state1",
						"transition1",
						"transition3"
					]
					val postSubcomponentScope = #[
						"compositeState2",
						"connectionErrorSource2",
						"detection2",
						"errorEvent2",
						"errorEvent3",
						"errorPath2",
						"errorSink2",
						"errorSource2",
						"fg4",
						"outgoingPropagationCondition2",
						"port3",
						"port3",
						"port3",
						"port3",
						"propagationPath2",
						"recoverEvent2",
						"recoverEvent3",
						"repairEvent2",
						"repairEvent3",
						"state1",
						"transition2",
						"transition3"
					]
					properties.get(0) => [
						1.1.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(1) => [
						2.2.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(2) => [
						3.3.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(3) => [
						4.4.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t3".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(4) => [
						5.5.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port1".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t4".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(5) => [
						6.6.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path.assertNull
									]
								]
							]
						]
					]
					properties.get(6) => [
						7.7.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t1".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(7) => [
						8.8.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t2".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(8) => [
						9.9.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t3".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(9) => [
						10.10.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg1.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t4".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(10) => [
						11.11.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port3".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(11) => [
						12.12.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port3".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(12) => [
						13.13.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port3".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(13) => [
						14.14.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port3".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t3".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(14) => [
						15.15.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"port3".assertEquals((namedElement as ErrorPropagation).propagationName)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t4".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(15) => [
						16.16.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg4".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg4.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path.assertNull
									]
								]
							]
						]
					]
					properties.get(16) => [
						17.17.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg4".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg4.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t1".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(17) => [
						18.18.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg4".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg4.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t2".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(18) => [
						19.19.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg4".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg4.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t3".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(19) => [
						20.20.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"fg4".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"fg2".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg2"])
								path => [
									"fg3".assertEquals(namedElement.name)
									// Tests scope_EMV2PathElement_namedElement
									assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #["fg3"])
									path => [
										"fg4.fg2.fg3.port2".assertEquals(
											(namedElement as ErrorPropagation).propagationName)
										// Tests scope_EMV2PathElement_namedElement
										assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement,
											#["port2", "port2", "port2", "port2"])
										path => [
											"t4".assertEquals(namedElement.name)
											// Tests scope_EMV2PathElement_namedElement
											assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
												"t1",
												"t2",
												"t3",
												"t4",
												"EMV2PropertyAssociation::t1",
												"EMV2PropertyAssociation::t2",
												"EMV2PropertyAssociation::t3",
												"EMV2PropertyAssociation::t4"
											])
											path.assertNull
										]
									]
								]
							]
						]
					]
					properties.get(20) => [
						21.21.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSource1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(21) => [
						22.22.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSource1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t3".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(22) => [
						23.23.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSource2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(23) => [
						24.24.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSource2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t3".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(24) => [
						25.25.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSink1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(25) => [
						26.26.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSink1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(26) => [
						27.27.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSink2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(27) => [
						28.28.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorSink2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(28) => [
						29.29.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorPath1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(29) => [
						30.30.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorPath2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(30) => [
						31.31.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(31) => [
						32.32.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(32) => [
						33.33.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(33) => [
						34.34.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(34) => [
						35.35.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(35) => [
						36.36.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(36) => [
						37.37.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(37) => [
						38.38.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"errorEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(38) => [
						39.39.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"repairEvent1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(39) => [
						40.40.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"repairEvent2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(40) => [
						41.41.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"repairEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(41) => [
						42.42.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"repairEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(42) => [
						43.43.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"recoverEvent1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(43) => [
						44.44.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"recoverEvent2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(44) => [
						45.45.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"recoverEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(45) => [
						46.46.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"recoverEvent3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(46) => [
						47.47.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"transition1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(47) => [
						48.48.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"transition3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(48) => [
						49.49.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"transition2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(49) => [
						50.50.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"transition3".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(50) => [
						assertError(lib1TestResult.issues, lib1IssueCollection,
							"Property EMV2::ExposurePeriod does not apply to outgoingPropagationCondition1")
						51.51.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"outgoingPropagationCondition1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(51) => [
						52.52.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"outgoingPropagationCondition2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(52) => [
						assertError(lib1TestResult.issues, lib1IssueCollection,
							"Property EMV2::ExposurePeriod does not apply to detection1")
						53.53.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"detection1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(53) => [
						"54".assertEquals((ownedValues.head.ownedValue as StringLiteral).value)
						emv2Path.head.emv2Target => [
							"detection2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(54) => [
						assertError(lib1TestResult.issues, lib1IssueCollection,
							"Property EMV2::ExposurePeriod does not apply to compositeState1")
						55.55.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"compositeState1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(55) => [
						56.56.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"compositeState2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(56) => [
						57.57.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"connectionErrorSource1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(57) => [
						58.58.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"connectionErrorSource1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(58) => [
						59.59.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"connectionErrorSource2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(59) => [
						60.60.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"connectionErrorSource2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(60) => [
						assertError(lib1TestResult.issues, lib1IssueCollection,
							"Property EMV2::ExposurePeriod does not apply to propagationPath1")
						61.61.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"propagationPath1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(61) => [
						62.62.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"propagationPath2".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(62) => [
						63.63.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"state1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path.assertNull
						]
					]
					properties.get(63) => [
						64.64.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"state1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, firstElementScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
					properties.get(64) => [
						65.65.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"state1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path.assertNull
						]
					]
					properties.get(65) => [
						66.66.assertEquals((ownedValues.head.ownedValue as RealLiteral).value, 0)
						emv2Path.head.emv2Target => [
							"state1".assertEquals(namedElement.name)
							// Tests scope_EMV2PathElement_namedElement
							assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, postSubcomponentScope)
							path => [
								"t1".assertEquals(namedElement.name)
								// Tests scope_EMV2PathElement_namedElement
								assertScope(ErrorModelPackage.eINSTANCE.EMV2PathElement_NamedElement, #[
									"t1",
									"t2",
									"t3",
									"t4",
									"EMV2PropertyAssociation::t1",
									"EMV2PropertyAssociation::t2",
									"EMV2PropertyAssociation::t3",
									"EMV2PropertyAssociation::t4"
								])
								path.assertNull
							]
						]
					]
				]
			]
		]
		lib1IssueCollection.sizeIs(lib1IssueCollection.issues.size)
		assertConstraints(lib1IssueCollection)
	}
}
