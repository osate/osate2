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

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNull

@RunWith(XtextRunner2)
@InjectWith(ErrorModelUiInjectorProvider)
class ErrorModelScopeProviderTest extends OsateTest {
	override getProjectName() {
		"Error_Model_Scope_Provider_Test"
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
					error types extends ErrorLibrary with
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
					assertScope(ErrorModelPackage.eINSTANCE.errorModelLibrary_Extends, false, #["ErrorLibrary", "pkg"])
					behaviors.head => [
						"b".assertEquals(name)
						//Tests scope_ErrorModelLibrary
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorStateMachine_UseTypes, false, #["ErrorLibrary", "pkg"])
						//Tests scope_TypeTransformationSet
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorStateMachine_UseTransformation, false, #["t", "pkg::t"])
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
						//Tests scope_TypeMappingSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeEquivalence, false, #["pkg::m"])
						//Tests scope_TypeMappingSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeMappingSet, false, #["pkg::m"])
						//Tests scope_ErrorModelSubclause_useBehavior
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseBehavior, false, #["pkg::b"])
						flows.head => [
							"p".assertEquals(name)
							assertWarning(testFileResult.issues, issueCollection, "Legacy support: please declare 'use mappings' at subclause level.")
							//Tests scope_TypeMappingSet
							assertScope(ErrorModelPackage.eINSTANCE.errorPath_TypeMappingSet, false, #["pkg::m"])
						]
						//Tests scope_TypeTransformationSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_UseTransformation, false, #["pkg::t"])
						//Tests scope_TypeTransformationSet
						assertScope(ErrorModelPackage.eINSTANCE.errorModelSubclause_TypeTransformationSet, false, #["pkg::t"])
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
	
	//Tests scope_ErrorSource_outgoing
	@Test
	def void testErrorPropagationReference() {
		createFiles("pkg.aadl" -> '''
			package pkg
			public
				abstract a
				features
					p1: out data port;
					p2: out data port;
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
					flows
						s: error source fg1.p3;
					end propagations;
				**};
				end a;
				
				feature group fgt1
				features
					p3: out data port;
					fg2: feature group fgt2;
				end fgt1;
				
				feature group fgt2
				features
					p4: out data port;
				end fgt2;
			end pkg;
		''')
		suppressSerialization
		testFile("pkg.aadl").resource.contents.head as AadlPackage => [
			"pkg".assertEquals(name)
			publicSection.ownedClassifiers.head as AbstractType => [
				"a".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).flows.head => [
					"s".assertEquals(name)
					//Tests scope_ErrorSource_outgoing
					assertScope(ErrorModelPackage.eINSTANCE.errorSource_Outgoing, false, #["binding", "fg1.fg2.p4", "fg1.p3", "memory", "p1", "p2"])
				]
			]
		]
	}
}