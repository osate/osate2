package org.osate.aadl2.errormodel.tests.errormodelscopeprovider

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull

@RunWith(XtextRunner2)
@InjectWith(ErrorModelUiInjectorProvider)
class SubcomponentReferenceTest extends OsateTest {
	override getProjectName() {
		"Subcomponent_Reference_Test"
	}
	
	/*
	 * Tests scope_SubcomponentElement_subcomponent(ComponentImplementation, EReference),
	 * scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference), and
	 * scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
	 */
	@Test
	def void testSubcomponentReference() {
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
					
					propagation paths
						propPath1: asub1.point1 -> asub1.asub2.point2;
						propPath2: asub1.asub2.asub3.point3 -> asub1.asub2.asub3.asub4.point4;
					end paths;
				**};
				end a1.i;
				
				abstract a2
				annex EMV2 {**
					use behavior lib1::bvr2;
					
					propagation paths
						point1: propagation point;
					end paths;
				**};
				end a2;
				
				abstract implementation a2.i
				subcomponents
					asub2: abstract a3.i;
				end a2.i;
				
				abstract a3
				annex EMV2 {**
					use behavior lib1::bvr3;
					
					propagation paths
						point2: propagation point;
					end paths;
				**};
				end a3;
				
				abstract implementation a3.i
				subcomponents
					asub3: abstract a4.i;
				end a3.i;
				
				abstract a4
				annex EMV2 {**
					use behavior lib1::bvr4;
					
					propagation paths
						point3: propagation point;
					end paths;
				**};
				end a4;
				
				abstract implementation a4.i
				subcomponents
					asub4: abstract a5;
				end a4.i;
				
				abstract a5
				annex EMV2 {**
					propagation paths
						point4: propagation point;
					end paths;
				**};
				end a5;
			end subclause1;
		''')
		ignoreSerializationDifferences
		testFile(subclause1FileName).resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) => [
				"a1.i".assertEquals(name)
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					states.get(0) => [
						"compositeState1".assertEquals(name)
						(condition as SConditionElement).qualifiedState => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub1"])
							next.assertNull
						]
					]
					states.get(1) => [
						"compositeState2".assertEquals(name)
						(condition as SConditionElement).qualifiedState => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub1"])
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								//Tests scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference)
								assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub2"])
								next.assertNull
							]
						]
					]
					states.get(2) => [
						"compositeState3".assertEquals(name)
						(condition as SConditionElement).qualifiedState => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub1"])
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								//Tests scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference)
								assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub2"])
								next => [
									"asub3".assertEquals(subcomponent.subcomponent.name)
									//Tests scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState, EReference)
									assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub3"])
									next.assertNull
								]
							]
						]
					]
					paths.get(0) => [
						"propPath1".assertEquals(name)
						source => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub1"])
							next.assertNull
						]
						target => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub1"])
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
								assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub2"])
								next.assertNull
							]
						]
					]
					paths.get(1) => [
						"propPath2".assertEquals(name)
						source => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub1"])
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
								assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub2"])
								next => [
									"asub3".assertEquals(subcomponent.subcomponent.name)
									//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
									assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub3"])
									next.assertNull
								]
							]
						]
						target => [
							"asub1".assertEquals(subcomponent.subcomponent.name)
							//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub1"])
							next => [
								"asub2".assertEquals(subcomponent.subcomponent.name)
								//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
								assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub2"])
								next => [
									"asub3".assertEquals(subcomponent.subcomponent.name)
									//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
									assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub3"])
									next => [
										"asub4".assertEquals(subcomponent.subcomponent.name)
										//Tests scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint, EReference)
										assertScope(ErrorModelPackage.eINSTANCE.subcomponentElement_Subcomponent, #["asub4"])
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
}