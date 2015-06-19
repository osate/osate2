package org.osate.aadl2.errormodel.tests.errormodelscopeprovider

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull

@RunWith(XtextRunner2)
@InjectWith(ErrorModelUiInjectorProvider)
class ErrorModelScopeProviderTest extends OsateTest {
	override getProjectName() {
		"Error_Model_Scope_Provider_Test"
	}
	
	@Test
	//Tests scope_ErrorModelLibrary
	def void testErrorModelLibraryReference() {
		createFiles("pkg.aadl" -> '''
			package pkg
			public
				annex EMV2 {**
					error types extends ErrorLibrary with
					end types;
					
					error behavior b
						use types ErrorLibrary;
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
					**};
				end a;
			end pkg;
		''')
		suppressSerialization
		testFile("pkg.aadl").resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection => [
				(ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary => [
					//Tests scope_ErrorModelLibrary
					assertScope(ErrorModelPackage.eINSTANCE.errorModelLibrary_Extends, false, #["ErrorLibrary", "pkg"])
					behaviors.head => [
						"b".assertEquals(name)
						//Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorStateMachine_UseTypes, false, #["ErrorLibrary", "pkg"])
					]
					mappings.head => [
						"m".assertEquals(name)
						//Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.typeMappingSet_UseTypes, false, #["ErrorLibrary", "pkg"])
					]
					transformations.head => [
						"t".assertEquals(name)
						//Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.typeTransformationSet_UseTypes, false, #["ErrorLibrary", "pkg"])
					]
				]
				ownedClassifiers.head => [
					"a".assertEquals(name)
					(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
						//Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseTypes, false, #["ErrorLibrary", "pkg"])
					]
				]
			]
		]
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
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).propagations.head => [
					//Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(Classifier, EReference)
					assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, false, #["eds", "es", "fg1", "op1", "point1", "point2"])
					featureorPPRef => [
						"fg1".assertEquals(featureorPP.name)
						//Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, false, #["fg2", "op2"])
						//Tests ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
						assertSerializerScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, false, #["eds", "es", "fg1", "op1", "point1", "point2"])
						next => [
							"fg2".assertEquals(featureorPP.name)
							//Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, false, #["op3"])
							//Tests ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
							assertSerializerScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, false, #["fg2", "op2"])
							next => [
								"op3".assertEquals(featureorPP.name)
								//Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
								assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, false, #[])
								//Tests ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
								assertSerializerScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, false, #["op3"])
								next.assertNull
							]
						]
					]
				]
			]
		]
	}
}