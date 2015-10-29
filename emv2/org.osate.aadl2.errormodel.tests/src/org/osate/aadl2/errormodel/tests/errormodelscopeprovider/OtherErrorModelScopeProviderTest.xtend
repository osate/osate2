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
	
	//Tests scope_ErrorSource_outgoing, scope_ErrorSink_incoming, scope_ErrorPath_incoming, and scope_ErrorPath_outgoing
	@Test
	def void testErrorPropagationReference() {
		createFiles("pkg.aadl" -> '''
			package pkg
			public
				abstract a
				features
					p1: out data port;
					p2: out data port;
					p5: out data port;
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
						
						p1: in propagation {AboveRange};
						p5: in propagation {AboveRange};
						fg1.p3: in propagation {AboveRange};
						fg1.fg2.p4: in propagation {AboveRange};
						memory: in propagation {AboveRange};
						binding: in propagation {AboveRange};
					flows
						errSource: error source fg1.p3;
						errSink: error sink fg1.p3;
						errPath: error path fg1.p3 -> fg1.p3;
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
				(ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause => [
					val outgoingScope = #["p1", "p2", "fg1.p3", "fg1.fg2.p4", "memory", "binding"]
					val incomingScope = #["p1", "p5", "fg1.p3", "fg1.fg2.p4", "memory", "binding"]
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
						//Tests scope_QualifiedPropagationPoint_propagationPoint
						source.assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point1"])
						//Tests scope_QualifiedPropagationPoint_propagationPoint
						target.assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point2"])
					]
					paths.get(1) => [
						"propPath2".assertEquals(name)
						//Tests scope_QualifiedPropagationPoint_propagationPoint
						source.assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point3"])
						//Tests scope_QualifiedPropagationPoint_propagationPoint
						target.assertScope(ErrorModelPackage.eINSTANCE.qualifiedPropagationPoint_PropagationPoint, #["point4"])
					]
				]
			]
		]
	}
	
	/*
	 * scope_RepairEvent_eventInitiator(Classifier, EReference), scope_RepairEvent_eventInitiator(ErrorBehaviorStateMachine, EReference),
	 * scope_RecoverEvent_eventInitiator(Classifier, EReference), and scope_RecoverEvent_eventInitiator(ErrorBehaviorStateMachine, EReference)
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
		suppressSerialization
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
	
	//Tests scope_ErrorBehaviorState(ErrorBehaviorStateMachine, EReference) and scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
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
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Target, expectedScope)
					]
					transitions.get(1) => [
						"transition4".assertEquals(name)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorBehaviorTransition_Source, expectedScope)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						destinationBranches.get(0).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target, expectedScope)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						destinationBranches.get(1).assertScope(ErrorModelPackage.eINSTANCE.transitionBranch_Target, expectedScope)
					]
					outgoingPropagationConditions.head => [
						"propagationCondition1".assertEquals(name)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.outgoingPropagationCondition_State, expectedScope)
					]
					errorDetections.head => [
						"detection1".assertEquals(name)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorDetection_State, expectedScope)
					]
					errorStateToModeMappings.head => [
						"bvr_state1".assertEquals(errorState.name)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.errorStateToModeMapping_ErrorState, expectedScope)
					]
					states.head => [
						"compositeState1".assertEquals(name)
						//Tests scope_ErrorBehaviorState(ErrorModelSubclause, EReference)
						assertScope(ErrorModelPackage.eINSTANCE.compositeState_State, expectedScope)
					]
				]
			]
		]
	}
	
	//Tests BranchValue's symbolicLabel reference
	@Test
	def void testPropertyReference() {
		val ps1FileName = "ps1.aadl"
		val lib1FileName = "lib1.aadl"
		val subclause1FileName = "subclause1.aadl"
		createFiles(ps1FileName -> '''
			property set ps1 is
				def1: aadlreal applies to (all);
			end ps1;
		''', lib1FileName -> '''
			package lib1
			public
				annex EMV2 {**
					error behavior bvr
					events
						err_evt1: error event;
					states
						bvr_state1: state;
						bvr_state2: state;
					transitions
						transition1: bvr_state1 -[ err_evt1 ]-> (bvr_state2 with 0.2, bvr_state2 with ps1::def1);
					end behavior;
				**};
			end lib1;
		''', subclause1FileName -> '''
			package subclause1
			public
				with ps1;
				
				abstract a
				annex EMV2 {**
					use behavior lib1::bvr;
					
					component error behavior
					events
						err_evt2: error event;
					transitions
						transition2: bvr_state1 -[ err_evt2 ]-> (bvr_state2 with 0.2, bvr_state2 with ps1::def1);
					end component;
					
					properties
						ps1::def1 => 0.8 applies to transition2;
				**};
				end a;
			end subclause1;
		''')
		suppressSerialization
		
		val expectedScope = #["Acceptable_Array_Size", "Access_Right", "Access_Time", "Activate_Deadline",
			"Activate_Entrypoint", "Activate_Entrypoint_Call_Sequence", "Activate_Entrypoint_Source_Text",
			"Activate_Execution_Time", "Active_Thread_Handling_Protocol", "Active_Thread_Queue_Handling_Protocol",
			"Actual_Connection_Binding", "Actual_Function_Binding", "Actual_Latency", "Actual_Memory_Binding",
			"Actual_Processor_Binding", "Actual_Subprogram_Call", "Actual_Subprogram_Call_Binding",
			"Allowed_Connection_Binding", "Allowed_Connection_Binding_Class", "Allowed_Connection_Type",
			"Allowed_Dispatch_Protocol", "Allowed_Memory_Binding", "Allowed_Memory_Binding_Class",
			"Allowed_Message_Size", "Allowed_Period", "Allowed_Physical_Access", "Allowed_Physical_Access_Class",
			"Allowed_Processor_Binding", "Allowed_Processor_Binding_Class", "Allowed_Subprogram_Call",
			"Allowed_Subprogram_Call_Binding", "Assign_Time", "Base_Address", "Byte_Count", "Classifier_Matching_Rule",
			"Classifier_Substitution_Rule", "Client_Subprogram_Execution_Time", "Clock_Jitter", "Clock_Period",
			"Clock_Period_Range", "Code_Size", "Collocated", "Compute_Deadline", "Compute_Entrypoint",
			"Compute_Entrypoint_Call_Sequence", "Compute_Entrypoint_Source_Text", "Compute_Execution_Time",
			"Concurrency_Control_Protocol", "Connection_Pattern", "Connection_Set", "Criticality", "Data_Rate",
			"Data_Size", "Deactivate_Dealing", "Deactivate_Entrypoint", "Deactivate_Entrypoint_Call_Sequence",
			"Deactivate_Entrypoint_Source_Text", "Deactivate_Execution_Time", "Deactivation_Policy", "Deadline",
			"Dequeue_Protocol", "Dequeued_Items", "Device_Driver", "Device_Register_Address", "Dispatch_Able",
			"Dispatch_Jitter", "Dispatch_Offset", "Dispatch_Protocol", "Dispatch_Trigger", "Execution_Time",
			"Fan_Out_Policy", "Finalize_Deadline", "Finalize_Entrypoint", "Finalize_Entrypoint_Call_Sequence",
			"Finalize_Entrypoint_Source_Text", "Finalize_Execution_Time", "First_Dispatch_Time", "Frame_Period",
			"Hardware_Description_Source_Text", "Hardware_Source_Language", "Heap_Size", "Implemented_As",
			"Initialize_Deadline", "Initialize_Entrypoint", "Initialize_Entrypoint_Call_Sequence",
			"Initialize_Entrypoint_Source_Text", "Initialize_Execution_Time", "Input_Rate", "Input_Time", "Latency",
			"Load_Deadline", "Load_Time", "Memory_Protocol", "Memory_Size", "Mode_Transition_Response",
			"Not_Collocated", "Output_Rate", "Output_Time", "Overflow_Handling_Protocol", "POSIX_Scheduling_Policy",
			"Period", "Preemptive_Scheduler", "Priority", "Priority_Map", "Priority_Range",
			"Process_Swap_Execution_Time", "Processor_Capacity", "Prototype_Substitution_Rule",
			"Provided_Connection_Quality_Of_Service", "Provided_Virtual_Bus_Class", "Queue_Processing_Protocol",
			"Queue_Size", "Read_Time", "Recover_Deadline", "Recover_Entrypoint", "Recover_Entrypoint_Call_Sequence",
			"Recover_Entrypoint_Source_Text", "Recover_Execution_Time", "Reference_Processor", "Required_Connection",
			"Required_Connection_Quality_Of_Service", "Required_Virtual_Bus_Class", "Resumption_Policy",
			"Runtime_Protection", "Runtime_Protection_Support", "Scheduler_Quantum", "Scheduling_Protocol", "Slot_Time",
			"Source_Language", "Source_Name", "Source_Text", "Stack_Size", "Startup_Deadline", "Startup_Execution_Time",
			"Subprogram_Call_Rate", "Subprogram_Call_Type", "Supported_Source_Language", "Synchronized_Component",
			"Thread_Limit", "Thread_Swap_Execution_Time", "Time_Slot", "Timing", "Transmission_Time",
			"Transmission_Type", "Type_Source_Name", "Urgency", "Word_Size", "Word_Space", "Write_Time", "ps1::def1",
			"Communication_Properties::Actual_Latency", "Communication_Properties::Connection_Pattern",
			"Communication_Properties::Connection_Set", "Communication_Properties::Data_Rate",
			"Communication_Properties::Fan_Out_Policy", "Communication_Properties::Input_Rate",
			"Communication_Properties::Input_Time", "Communication_Properties::Latency",
			"Communication_Properties::Output_Rate", "Communication_Properties::Output_Time",
			"Communication_Properties::Overflow_Handling_Protocol",
			"Communication_Properties::Queue_Processing_Protocol", "Communication_Properties::Queue_Size",
			"Communication_Properties::Required_Connection", "Communication_Properties::Subprogram_Call_Rate",
			"Communication_Properties::Timing", "Communication_Properties::Transmission_Time",
			"Communication_Properties::Transmission_Type", "Deployment_Properties::Actual_Connection_Binding",
			"Deployment_Properties::Actual_Function_Binding", "Deployment_Properties::Actual_Memory_Binding",
			"Deployment_Properties::Actual_Processor_Binding", "Deployment_Properties::Actual_Subprogram_Call",
			"Deployment_Properties::Actual_Subprogram_Call_Binding",
			"Deployment_Properties::Allowed_Connection_Binding",
			"Deployment_Properties::Allowed_Connection_Binding_Class", "Deployment_Properties::Allowed_Connection_Type",
			"Deployment_Properties::Allowed_Dispatch_Protocol", "Deployment_Properties::Allowed_Memory_Binding",
			"Deployment_Properties::Allowed_Memory_Binding_Class", "Deployment_Properties::Allowed_Period",
			"Deployment_Properties::Allowed_Physical_Access", "Deployment_Properties::Allowed_Physical_Access_Class",
			"Deployment_Properties::Allowed_Processor_Binding",
			"Deployment_Properties::Allowed_Processor_Binding_Class", "Deployment_Properties::Allowed_Subprogram_Call",
			"Deployment_Properties::Allowed_Subprogram_Call_Binding", "Deployment_Properties::Collocated",
			"Deployment_Properties::Memory_Protocol", "Deployment_Properties::Not_Collocated",
			"Deployment_Properties::Preemptive_Scheduler", "Deployment_Properties::Priority_Map",
			"Deployment_Properties::Priority_Range", "Deployment_Properties::Provided_Connection_Quality_Of_Service",
			"Deployment_Properties::Provided_Virtual_Bus_Class",
			"Deployment_Properties::Required_Connection_Quality_Of_Service",
			"Deployment_Properties::Required_Virtual_Bus_Class", "Deployment_Properties::Runtime_Protection_Support",
			"Deployment_Properties::Scheduling_Protocol", "Deployment_Properties::Thread_Limit",
			"Memory_Properties::Access_Right", "Memory_Properties::Access_Time",
			"Memory_Properties::Allowed_Message_Size", "Memory_Properties::Assign_Time",
			"Memory_Properties::Base_Address", "Memory_Properties::Byte_Count", "Memory_Properties::Code_Size",
			"Memory_Properties::Data_Size", "Memory_Properties::Device_Register_Address",
			"Memory_Properties::Heap_Size", "Memory_Properties::Memory_Size", "Memory_Properties::Read_Time",
			"Memory_Properties::Stack_Size", "Memory_Properties::Word_Size", "Memory_Properties::Word_Space",
			"Memory_Properties::Write_Time", "Modeling_Properties::Acceptable_Array_Size",
			"Modeling_Properties::Classifier_Matching_Rule", "Modeling_Properties::Classifier_Substitution_Rule",
			"Modeling_Properties::Implemented_As", "Modeling_Properties::Prototype_Substitution_Rule",
			"Programming_Properties::Activate_Entrypoint", "Programming_Properties::Activate_Entrypoint_Call_Sequence",
			"Programming_Properties::Activate_Entrypoint_Source_Text", "Programming_Properties::Compute_Entrypoint",
			"Programming_Properties::Compute_Entrypoint_Call_Sequence",
			"Programming_Properties::Compute_Entrypoint_Source_Text", "Programming_Properties::Deactivate_Entrypoint",
			"Programming_Properties::Deactivate_Entrypoint_Call_Sequence",
			"Programming_Properties::Deactivate_Entrypoint_Source_Text", "Programming_Properties::Device_Driver",
			"Programming_Properties::Finalize_Entrypoint", "Programming_Properties::Finalize_Entrypoint_Call_Sequence",
			"Programming_Properties::Finalize_Entrypoint_Source_Text",
			"Programming_Properties::Hardware_Description_Source_Text",
			"Programming_Properties::Hardware_Source_Language", "Programming_Properties::Initialize_Entrypoint",
			"Programming_Properties::Initialize_Entrypoint_Call_Sequence",
			"Programming_Properties::Initialize_Entrypoint_Source_Text", "Programming_Properties::Recover_Entrypoint",
			"Programming_Properties::Recover_Entrypoint_Call_Sequence",
			"Programming_Properties::Recover_Entrypoint_Source_Text", "Programming_Properties::Source_Language",
			"Programming_Properties::Source_Name", "Programming_Properties::Source_Text",
			"Programming_Properties::Supported_Source_Language", "Programming_Properties::Type_Source_Name",
			"Thread_Properties::Active_Thread_Handling_Protocol",
			"Thread_Properties::Active_Thread_Queue_Handling_Protocol",
			"Thread_Properties::Concurrency_Control_Protocol", "Thread_Properties::Criticality",
			"Thread_Properties::Deactivation_Policy", "Thread_Properties::Dequeue_Protocol",
			"Thread_Properties::Dequeued_Items", "Thread_Properties::Dispatch_Able",
			"Thread_Properties::Dispatch_Protocol", "Thread_Properties::Dispatch_Trigger",
			"Thread_Properties::Mode_Transition_Response", "Thread_Properties::POSIX_Scheduling_Policy",
			"Thread_Properties::Priority", "Thread_Properties::Resumption_Policy",
			"Thread_Properties::Runtime_Protection", "Thread_Properties::Subprogram_Call_Type",
			"Thread_Properties::Synchronized_Component", "Thread_Properties::Time_Slot", "Thread_Properties::Urgency",
			"Timing_Properties::Activate_Deadline", "Timing_Properties::Activate_Execution_Time",
			"Timing_Properties::Client_Subprogram_Execution_Time", "Timing_Properties::Clock_Jitter",
			"Timing_Properties::Clock_Period", "Timing_Properties::Clock_Period_Range",
			"Timing_Properties::Compute_Deadline", "Timing_Properties::Compute_Execution_Time",
			"Timing_Properties::Deactivate_Dealing", "Timing_Properties::Deactivate_Execution_Time",
			"Timing_Properties::Deadline", "Timing_Properties::Dispatch_Jitter", "Timing_Properties::Dispatch_Offset",
			"Timing_Properties::Execution_Time", "Timing_Properties::Finalize_Deadline",
			"Timing_Properties::Finalize_Execution_Time", "Timing_Properties::First_Dispatch_Time",
			"Timing_Properties::Frame_Period", "Timing_Properties::Initialize_Deadline",
			"Timing_Properties::Initialize_Execution_Time", "Timing_Properties::Load_Deadline",
			"Timing_Properties::Load_Time", "Timing_Properties::Period",
			"Timing_Properties::Process_Swap_Execution_Time", "Timing_Properties::Processor_Capacity",
			"Timing_Properties::Recover_Deadline", "Timing_Properties::Recover_Execution_Time",
			"Timing_Properties::Reference_Processor", "Timing_Properties::Scheduler_Quantum",
			"Timing_Properties::Slot_Time", "Timing_Properties::Startup_Deadline",
			"Timing_Properties::Startup_Execution_Time", "Timing_Properties::Thread_Swap_Execution_Time"
		]
		
		val lib1TestResult = testFile(lib1FileName)
		val lib1IssueCollection = new FluentIssueCollection(lib1TestResult.resource, newArrayList, newArrayList)
		lib1TestResult.resource.contents.head as AadlPackage => [
			"lib1".assertEquals(name)
			((publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary).parsedAnnexLibrary as ErrorModelLibrary).behaviors.head => [
				"bvr".assertEquals(name)
				transitions.head => [
					"transition1".assertEquals(name)
					assertError(lib1TestResult.issues, lib1IssueCollection, "Sum of branch probabilities must be 1")
					//Tests BranchValue's symbolicLabel reference
					destinationBranches.get(1).value.assertScope(ErrorModelPackage.eINSTANCE.branchValue_Symboliclabel, expectedScope)
				]
			]
		]
		assertConstraints(lib1IssueCollection.sizeIs(lib1IssueCollection.issues.size))
		
		val subclause1TestResult = testFile(subclause1FileName)
		val subclause1IssueCollection = new FluentIssueCollection(subclause1TestResult.resource, newArrayList, newArrayList)
		subclause1TestResult.resource.contents.head as AadlPackage => [
			"subclause1".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"a".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).transitions.head => [
					"transition2".assertEquals(name)
					assertError(subclause1TestResult.issues, subclause1IssueCollection, "Sum of branch probabilities must be 1")
					//Tests BranchValue's symbolicLabel reference
					destinationBranches.get(1).value.assertScope(ErrorModelPackage.eINSTANCE.branchValue_Symboliclabel, expectedScope)
				]
			]
		]
		assertConstraints(subclause1IssueCollection.sizeIs(subclause1IssueCollection.issues.size))
	}
}