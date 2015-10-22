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
	
	//Tests scope_ErrorType
	@Test
	def void testErrorTypeReference() {
		val lib1FileName = "lib1.aadl"
		val lib2FileName = "lib2.aadl"
		val lib3FileName = "lib3.aadl"
		val lib4FileName = "lib4.aadl"
		val lib5FileName = "lib5.aadl"
		val lib6FileName = "lib6.aadl"
		createFiles(lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error types
						t1: type;
						conflict1: type;
						conflict2: type;
					end types;
				**};
			end lib1;
		''', lib2FileName -> '''
			package lib2
			public
				annex EMV2 {**
					error types extends lib1 with
						t2: type;
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
					end types;
				**};
			end lib3;
		''', lib4FileName -> '''
			package lib4
			public
				annex EMV2 {**
					error types extends lib3 with
						t4: type;
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
					end types;
				**};
			end lib6;
		''')
		suppressSerialization
		val lib1TestResult = testFile(lib1FileName)
		val lib2TestResult = testFile(lib2FileName)
		val lib3TestResult = testFile(lib3FileName)
		val lib4TestResult = testFile(lib4FileName)
		val lib6TestResult = testFile(lib6FileName)
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
			]
		]
		lib2TestResult.resource.contents.head as AadlPackage => [
			"lib2".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).types.head => [
				"t2".assertEquals(name)
				val expectedTypeScope = #["t1", "conflict1", "conflict2", "t2"]
				//Tests scope_ErrorType
				assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
				//Tests scope_ErrorType
				assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
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
			]
		]
		lib4TestResult.resource.contents.head as AadlPackage => [
			"lib4".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).types.head => [
				"t4".assertEquals(name)
				val expectedTypeScope = #["t3", "conflict1", "t4"]
				//Tests scope_ErrorType
				assertScope(ErrorModelPackage.eINSTANCE.errorType_SuperType, expectedTypeScope)
				//Tests scope_ErrorType
				assertScope(ErrorModelPackage.eINSTANCE.errorType_AliasedType, expectedTypeScope)
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
					assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["eds", "es", "fg1", "op1", "point1", "point2"])
					featureorPPRef => [
						"fg1".assertEquals(featureorPP.name)
						//Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["fg2", "op2"])
						//Tests ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
						assertSerializerScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["eds", "es", "fg1", "op1", "point1", "point2"])
						next => [
							"fg2".assertEquals(featureorPP.name)
							//Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
							assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["op3"])
							//Tests ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
							assertSerializerScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["fg2", "op2"])
							next => [
								"op3".assertEquals(featureorPP.name)
								//Tests ErrorModelScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
								assertScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #[])
								//Tests ErrorModelSerializerScopeProvider.scope_FeatureorPPReference_featureorPP(FeatureorPPReference, EReference)
								assertSerializerScope(ErrorModelPackage.eINSTANCE.featureorPPReference_FeatureorPP, #["op3"])
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
					assertScope(ErrorModelPackage.eINSTANCE.errorSource_Outgoing, #["binding", "fg1.fg2.p4", "fg1.p3", "memory", "p1", "p2"])
				]
			]
		]
	}
}