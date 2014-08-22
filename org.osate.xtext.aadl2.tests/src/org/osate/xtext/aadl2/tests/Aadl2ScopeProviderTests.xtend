/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.tests

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.scoping.IScopeProvider
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentPrototypeBinding
import org.osate.aadl2.ModelUnit
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider
import org.junit.After
import org.osate.aadl2.FeatureGroupPrototypeBinding
import org.osate.aadl2.NamedElement
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.FeaturePrototypeBinding
import org.osate.aadl2.AbstractImplementation

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Aadl2ScopeProviderTests extends OsateTest {
	@Inject extension ParseHelper<ModelUnit>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider
	
	static val TEST_PROJECT_NAME = "Aadl2_Scope_Provider_Test"
	
	@Before
	def setUp() {
		createProject(TEST_PROJECT_NAME, "packages")
		buildProject("Plugin_Resources", true)
		setResourceRoot("platform:/resource/Aadl2_Scope_Provider_Test/packages")
	}
	
	@After
	def cleanUp() {
		deleteProject(TEST_PROJECT_NAME)
	}
	
	/*
	 * Tests scope_ComponentPrototype_constrainingClassifier, scope_FeaturePrototype_constrainingClassifier, scope_FeatureGroupPrototypeActual_featureType,
	 * scope_PortSpecification_classifier, scope_AccessSpecification_classifier, and scope_ComponentPrototypeActual_subcomponentType
	 */
	@Test
	def void testRenamesInClassifierReferenceScope() {
		createFiles(
			"pack1.aadl" -> '''
				package pack1
				public
				  with pack3;
				  with pack4;
				  with pack5;
				  renames pack3::all;
				  renamed_package renames package pack4;
				  renames abstract pack5::a6;
				  renames feature group pack5::fgt5;
				  renmaed_classifier renames abstract pack5::a7;
				  renamed_feature_group renames feature group pack5::fgt5;
				
				  abstract a1
				    prototypes
				      proto1: abstract a2;
				      proto2: feature a2;
				      proto3: feature group;
				      proto4: feature;
				      proto5: feature;
				      proto6: data;
				  end a1;
				  
				  abstract a2 extends a1 (
				    proto3 => feature group fgt1,
				    proto4 => in data port d1,
				    proto5 => provides data access d1,
				    proto6 => data d1
				  )
				  end a2;
				  
				  abstract implementation a2.i
				  end a2.i;
				  
				  feature group fgt1
				  end fgt1;
				  
				  data d1
				  end d1;
				  
				  data implementation d1.i
				  end d1.i;
				end pack1;
			''',
			"pack2.aadl" -> '''
				package pack2
				public
				  abstract a3
				  end a3;
				  
				  abstract implementation a3.i
				  end a3.i;
				  
				  feature group fgt2
				  end fgt2;
				  
				  data d2
				  end d2;
				  
				  data implementation d2.i
				  end d2.i;
			''',
			"pack3.aadl" -> '''
				package pack3
				public
				  abstract a4
				  end a4;
				  
				  abstract implementation a4.i
				  end a4.i;
				  
				  feature group fgt3
				  end fgt3;
				  
				  data d3
				  end d3;
				  
				  data implementation d3.i
				  end d3.i;
				end pack3;
			''',
			"pack4.aadl" -> '''
				package pack4
				public
				  abstract a5
				  end a5;
				  
				  abstract implementation a5.i
				  end a5.i;
				  
				  feature group fgt4
				  end fgt4;
				  
				  data d4
				  end d4;
				  
				  data implementation d4.i
				  end d4.i;
				end pack4;
			''',
			"pack5.aadl" -> '''
				package pack5
				public
				  abstract a6
				  end a6;
				  
				  abstract a7
				  end a7;
				  
				  feature group fgt5
				  end fgt5;
				  
				  data d5
				  end d5;
				  
				  data implementation d5.i
				  end d5.i;
				end pack5;
			'''
		)
		suppressSerialization
		val pack1 = testFile("pack1.aadl").resource.contents.head as AadlPackage
		assertAllCrossReferencesResolvable(pack1)
		
		val componentClassifierScopeForPack1 = '''
			a6, renmaed_classifier, a4, a4.i, d3, d3.i, renamed_package.a5, renamed_package.a5.i, renamed_package.d4, renamed_package.d4.i, 
			a1, a2, a2.i, d1, d1.i, pack1.a1, pack1.a2, pack1.a2.i, pack1.d1, pack1.d1.i, pack3.a4, pack3.a4.i, pack3.d3, pack3.d3.i, pack2.a3, 
			pack2.a3.i, pack2.d2, pack2.d2.i, pack5.a6, pack5.a7, pack5.d5, pack5.d5.i, pack4.a5, pack4.a5.i, pack4.d4, pack4.d4.i, 
			Base_Types.Boolean, Base_Types.Integer, Base_Types.Integer_8, Base_Types.Integer_16, Base_Types.Integer_32, Base_Types.Integer_64, 
			Base_Types.Unsigned_8, Base_Types.Unsigned_16, Base_Types.Unsigned_32, Base_Types.Unsigned_64, Base_Types.Natural, Base_Types.Float, 
			Base_Types.Float_32, Base_Types.Float_64, Base_Types.Character, Base_Types.String
		'''.toString.replaceAll(System.lineSeparator, "")
		
		pack1 => [
			Assert::assertEquals("pack1", name)
			publicSection.ownedClassifiers.get(0) => [
				Assert::assertEquals("a1", name)
				ownedPrototypes.get(0) => [
					Assert::assertEquals("proto1", name)
					//Tests scope_ComponentPrototype_constrainingClassifier
					assertScope(Aadl2Package::eINSTANCE.componentPrototype_ConstrainingClassifier, componentClassifierScopeForPack1)
				]
				ownedPrototypes.get(1) => [
					Assert::assertEquals("proto2", name)
					//Tests scope_FeaturePrototype_constrainingClassifier
					assertScope(Aadl2Package::eINSTANCE.featurePrototype_ConstrainingClassifier, componentClassifierScopeForPack1)
				]
			]
			publicSection.ownedClassifiers.get(1) => [
				Assert::assertEquals("a2", name)
				ownedPrototypeBindings.get(0) as FeatureGroupPrototypeBinding => [
					Assert::assertEquals("proto3", formal.name)
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, "proto3, fgt5, renamed_feature_group, " +
						"fgt3, renamed_package.fgt4, fgt1, pack1.fgt1, pack3.fgt3, pack2.fgt2, pack5.fgt5, pack4.fgt4"
					)
				]
				ownedPrototypeBindings.get(1) as FeaturePrototypeBinding => [
					Assert::assertEquals("proto4", formal.name)
					//Tests scope_PortSpecification_classifier
					actual.assertScope(Aadl2Package::eINSTANCE.portSpecification_Classifier, componentClassifierScopeForPack1)
				]
				ownedPrototypeBindings.get(2) as FeaturePrototypeBinding => [
					Assert::assertEquals("proto5", formal.name)
					//Tests scope_AccessSpecification_classifier
					actual.assertScope(Aadl2Package::eINSTANCE.accessSpecification_Classifier, componentClassifierScopeForPack1)
				]
				ownedPrototypeBindings.get(3) as ComponentPrototypeBinding => [
					Assert::assertEquals("proto6", formal.name)
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.get(0).assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, "proto1, proto6, " + componentClassifierScopeForPack1)
				]
			]
		]
	}
	
	//Tests scope_Prototype_refined and scope_Subcomponent_refined
	@Test
	def void testRefinedElements() {
		('''
			package pack
			public
			  abstract a1
			  prototypes
			    proto1: abstract;
			  end a1;
			  
			  abstract a2 extends a1
			  prototypes
			    proto1: refined to abstract;
			  end a2;
			  
			  feature group fgt1
			  prototypes
			    proto2: abstract;
			  end fgt1;
			  
			  feature group fgt2 extends fgt1
			  prototypes
			    proto2: refined to abstract;
			  end fgt2;
			  
			  abstract implementation a1.i1
			  subcomponents
			    asub1: abstract;
			  end a1.i1;
			  
			  abstract implementation a1.i2 extends a1.i1
			  subcomponents
			    asub1: refined to abstract;
			    asub2: abstract;
			  end a1.i2;
			end pack;
		'''.parse as AadlPackage) => [
			Assert::assertEquals("pack", name)
			publicSection.ownedClassifiers.get(0) => [
				Assert::assertEquals("a1", name)
				ownedPrototypes.get(0) => [
					Assert::assertEquals("proto1", name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "")
				]
			]
			publicSection.ownedClassifiers.get(1) => [
				Assert::assertEquals("a2", name)
				ownedPrototypes.get(0) => [
					Assert::assertEquals("proto1", name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "proto1")
				]
			]
			publicSection.ownedClassifiers.get(2) => [
				Assert::assertEquals("fgt1", name)
				ownedPrototypes.get(0) => [
					Assert::assertEquals("proto2", name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "")
				]
			]
			publicSection.ownedClassifiers.get(3) => [
				Assert::assertEquals("fgt2", name)
				ownedPrototypes.get(0) => [
					Assert::assertEquals("proto2", name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "proto2")
				]
			]
			publicSection.ownedClassifiers.get(5) as ComponentImplementation => [
				Assert::assertEquals("a1.i2", name)
				ownedSubcomponents.get(0) => [
					Assert::assertEquals("asub1", name)
					//Tests scope_Subcomponent_refined
					assertScope(Aadl2Package::eINSTANCE.subcomponent_Refined, "asub1")
				]
			]
		]
	}
	
	/*
	 * Tests scope_PrototypeBinding_formal, scope_FeatureGroupPrototypeActual_featureType, scope_FeaturePrototypeReference_prototype, and
	 * scope_ComponentPrototypeActual_subcomponentType
	 */
	@Test
	def void testPrototypeBindings() {
		('''
			package pack
			public
			  abstract a1
			  prototypes
			    proto1: abstract;
			    proto3: feature group;
			    proto5: feature group;
			    proto8: feature;
			    proto9: feature;
			    proto11: abstract;
			  end a1;
			  
			  abstract a2 extends a1 (
			    proto1 => abstract a3 (
			      proto2 => in data port
			    ),
			    proto3 => feature group fgt1 (
			      proto4 => in data port
			    )
			  )
			  end a2;
			  
			  abstract implementation a1.i1
			  subcomponents
			    asub1: abstract [](a3.i1 (
			      proto2 => in data port
			    ));
			    asub2: abstract a3 (
			      proto2 => in data port
			    );
			  end a1.i1;
			  
			  abstract implementation a1.i2 extends a1.i1 (
			    proto1 => abstract a3,
			    proto3 => feature group fgt1,
			    proto5 => feature group proto3,
			    proto8 => feature proto9,
			    proto11 => abstract proto1
			  )
			  end a1.i2;
			  
			  abstract a3
			  prototypes
			    proto2: feature;
			  end a3;
			  
			  abstract implementation a3.i1
			  end a3.i1;
			  
			  feature group fgt1
			  prototypes
			    proto4: feature;
			    proto6: feature group;
			    proto10: feature;
			    proto12: abstract;
			  end fgt1;
			  
			  feature group fgt2 extends fgt1 (
			    proto4 => in data port,
			    proto6 => feature group proto7,
			    proto10 => feature proto4,
			    proto12 => abstract proto13
			  )
			  prototypes
			    proto7: feature group;
			    proto13: abstract;
			  end fgt2;
			end pack;
		'''.parse as AadlPackage) => [
			Assert::assertEquals("pack", name)
			publicSection.ownedClassifiers.get(1) => [
				Assert::assertEquals("a2", name)
				ownedPrototypeBindings.get(0) as ComponentPrototypeBinding => [
					Assert::assertEquals("proto1", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3, proto5, proto8, proto9, proto11")
					actuals.get(0) => [
						Assert::assertEquals("a3", subcomponentType.name)
						bindings.get(0) => [
							Assert::assertEquals("proto2", formal.name)
							//Tests scope_PrototypeBinding_formal(ComponentPrototypeActual, EReference)
							assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto2")
						]
					]
				]
				ownedPrototypeBindings.get(1) as FeatureGroupPrototypeBinding => [
					Assert::assertEquals("proto3", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3, proto5, proto8, proto9, proto11")
					actual => [
						Assert::assertEquals("fgt1", (featureType as NamedElement).name)
						//Tests scope_FeatureGroupPrototypeActual_featureType
						assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, "proto3, proto5, fgt1, fgt2, pack.fgt1, pack.fgt2")
						bindings.get(0) => [
							Assert::assertEquals("proto4", formal.name)
							//Tests scope_PrototypeBinding_formal(FeatureGroupPrototypeActual, EReference)
							assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto4, proto6, proto10, proto12")
						]
					]
				]
			]
			publicSection.ownedClassifiers.get(2) as ComponentImplementation => [
				Assert::assertEquals("a1.i1", name)
				ownedSubcomponents.get(0) => [
					Assert::assertEquals("asub1", name)
					implementationReferences.get(0) => [
						Assert::assertEquals("a3.i1", implementation.name)
						ownedPrototypeBindings.get(0) => [
							Assert::assertEquals("proto2", formal.name)
							//Tests scope_PrototypeBinding_formal(ComponentImplementationReference, EReference)
							assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto2")
						]
					]
				]
				ownedSubcomponents.get(1) => [
					Assert::assertEquals("asub2", name)
					ownedPrototypeBindings.get(0) => [
						Assert::assertEquals("proto2", formal.name)
						//Tests scope_PrototypeBinding_formal(Subcomponent, EReference)
						assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto2")
					]
				]
			]
			publicSection.ownedClassifiers.get(3) => [
				Assert::assertEquals("a1.i2", name)
				ownedPrototypeBindings.get(0) as ComponentPrototypeBinding => [
					Assert::assertEquals("proto1", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3, proto5, proto8, proto9, proto11")
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.get(0).assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, "proto1, proto11, a1, a2, a1.i1, a1.i2, a3, " +
						"a3.i1, pack.a1, pack.a2, pack.a1.i1, pack.a1.i2, pack.a3, pack.a3.i1"
					)
				]
				ownedPrototypeBindings.get(1) as FeatureGroupPrototypeBinding => [
					Assert::assertEquals("proto3", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3, proto5, proto8, proto9, proto11")
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, "proto3, proto5, fgt1, fgt2, pack.fgt1, pack.fgt2")
				]
				ownedPrototypeBindings.get(2) as FeatureGroupPrototypeBinding => [
					Assert::assertEquals("proto5", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3, proto5, proto8, proto9, proto11")
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, "proto3, proto5, fgt1, fgt2, pack.fgt1, pack.fgt2")
				]
				ownedPrototypeBindings.get(3) as FeaturePrototypeBinding => [
					Assert::assertEquals("proto8", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3, proto5, proto8, proto9, proto11")
					//Tests scope_FeaturePrototypeReference_prototype
					actual.assertScope(Aadl2Package::eINSTANCE.featurePrototypeReference_Prototype, "proto8, proto9")
				]
				ownedPrototypeBindings.get(4) as ComponentPrototypeBinding => [
					Assert::assertEquals("proto11", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3, proto5, proto8, proto9, proto11")
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.get(0).assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, "proto1, proto11, a1, a2, a1.i1, a1.i2, a3, " +
						"a3.i1, pack.a1, pack.a2, pack.a1.i1, pack.a1.i2, pack.a3, pack.a3.i1"
					)
				]
			]
			publicSection.ownedClassifiers.get(7) => [
				Assert::assertEquals("fgt2", name)
				ownedPrototypeBindings.get(0) => [
					Assert::assertEquals("proto4", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto4, proto6, proto10, proto12")
				]
				ownedPrototypeBindings.get(1) as FeatureGroupPrototypeBinding => [
					Assert::assertEquals("proto6", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto4, proto6, proto10, proto12")
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, "proto6, proto7, fgt1, fgt2, pack.fgt1, pack.fgt2")
				]
				ownedPrototypeBindings.get(2) as FeaturePrototypeBinding => [
					Assert::assertEquals("proto10", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto4, proto6, proto10, proto12")
					//Tests scope_FeaturePrototypeReference_prototype
					actual.assertScope(Aadl2Package::eINSTANCE.featurePrototypeReference_Prototype, "proto4, proto10")
				]
				ownedPrototypeBindings.get(3) as ComponentPrototypeBinding => [
					Assert::assertEquals("proto12", formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto4, proto6, proto10, proto12")
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.get(0).assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, "proto12, proto13, a1, a2, a1.i1, a1.i2, a3, " +
						"a3.i1, pack.a1, pack.a2, pack.a1.i1, pack.a1.i2, pack.a3, pack.a3.i1"
					)
				]
			]
		]
	}
	
	/*
	 * Tests scope_AbstractSubcomponent_abstractSubcomponentType, scope_SystemSubcomponent_systemSubcomponentType,
	 * scope_ProcessSubcomponent_processSubcomponentType, scope_ThreadGroupSubcomponent_threadGroupSubcomponentType,
	 * scope_ThreadSubcomponent_threadSubcomponentType, scope_SubprogramSubcomponent_subprogramSubcomponentType,
	 * scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType, scope_ProcessorSubcomponent_processorSubcomponentType,
	 * scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType, scope_DeviceSubcomponent_deviceSubcomponentType,
	 * scope_MemorySubcomponent_memorySubcomponentType, scope_BusSubcomponent_busSubcomponentType,
	 * scope_VirtualBusSubcomponent_virtualBusSubcomponentType, and scope_DataSubcomponent_dataSubcomponentType
	 */
	 @Test
	def void testSubcomponents() {
		createFiles(
			"pack1.aadl" -> '''
				package pack1
				public
				  with pack3;
				  with pack4;
				  with pack5;
				  
				  renames pack3::all;
				  renamed_package renames package pack4;
				  
				  renames abstract pack5::a5;
				  renames system pack5::s5;
				  renames process pack5::p5;
				  renames thread group pack5::tg5;
				  renames thread pack5::t5;
				  renames subprogram pack5::sub5;
				  renames subprogram group pack5::subg5;
				  renames processor pack5::proc5;
				  renames virtual processor pack5::vp5;
				  renames device pack5::dev5;
				  renames memory pack5::m5;
				  renames bus pack5::b5;
				  renames virtual bus pack5::vb5;
				  renames data pack5::d5;
				  
				  ra renames abstract pack5::a6;
				  rs renames system pack5::s6;
				  rp renames process pack5::p6;
				  rtg renames thread group pack5::tg6;
				  rt renames thread pack5::t6;
				  rsub renames subprogram pack5::sub6;
				  rsubg renames subprogram group pack5::subg6;
				  rproc renames processor pack5::proc6;
				  rvp renames virtual processor pack5::vp6;
				  rdev renames device pack5::dev6;
				  rm renames memory pack5::m6;
				  rb renames bus pack5::b6;
				  rvb renames virtual bus pack5::vb6;
				  rd renames data pack5::d6;
				  
				  abstract container
				  prototypes
				    aproto: abstract;
				    sproto: system;
				    pproto: process;
				    tgproto: thread group;
				    tproto: thread;
				    subproto: subprogram;
				    subgproto: subprogram group;
				    procproto: processor;
				    vpproto: virtual processor;
				    devproto: device;
				    mproto: memory;
				    bproto: bus;
				    vbproto: virtual bus;
				    dproto: data;
				  end container;
				  
				  abstract implementation container.i
				  subcomponents
				    asub: abstract a1;
				    ssub: system s1;
				    psub: process p1;
				    tgsub: thread group tg1;
				    tsub: thread t1;
				    subsub: subprogram sub1;
				    subgsub: subprogram group subg1;
				    procsub: processor proc1;
				    vpsub: virtual processor vp1;
				    devsub: device dev1;
				    msub: memory m1;
				    bsub: bus b1;
				    vbsub: virtual bus vb1;
				    dsub: data d1;
				  end container.i;
				  
				  abstract a1
				  end a1;
				  
				  abstract implementation a1.i
				  end a1.i;
				  
				  system s1
				  end s1;
				  
				  system implementation s1.i
				  end s1.i;
				  
				  process p1
				  end p1;
				  
				  process implementation p1.i
				  end p1.i;
				  
				  thread group tg1
				  end tg1;
				  
				  thread group implementation tg1.i
				  end tg1.i;
				  
				  thread t1
				  end t1;
				  
				  thread implementation t1.i
				  end t1.i;
				  
				  subprogram sub1
				  end sub1;
				  
				  subprogram implementation sub1.i
				  end sub1.i;
				  
				  subprogram group subg1
				  end subg1;
				  
				  subprogram group implementation subg1.i
				  end subg1.i;
				  
				  processor proc1
				  end proc1;
				  
				  processor implementation proc1.i
				  end proc1.i;
				  
				  virtual processor vp1
				  end vp1;
				  
				  virtual processor implementation vp1.i
				  end vp1.i;
				  
				  device dev1
				  end dev1;
				  
				  device implementation dev1.i
				  end dev1.i;
				  
				  memory m1
				  end m1;
				  
				  memory implementation m1.i
				  end m1.i;
				  
				  bus b1
				  end b1;
				  
				  bus implementation b1.i
				  end b1.i;
				  
				  virtual bus vb1
				  end vb1;
				  
				  virtual bus implementation vb1.i
				  end vb1.i;
				  
				  data d1
				  end d1;
				  
				  data implementation d1.i
				  end d1.i;
				end pack1;
			''',
			"pack2.aadl" -> '''
				package pack2
				public
				  abstract a2
				  end a2;
				  
				  abstract implementation a2.i
				  end a2.i;
				  
				  system s2
				  end s2;
				  
				  system implementation s2.i
				  end s2.i;
				  
				  process p2
				  end p2;
				  
				  process implementation p2.i
				  end p2.i;
				  
				  thread group tg2
				  end tg2;
				  
				  thread group implementation tg2.i
				  end tg2.i;
				  
				  thread t2
				  end t2;
				  
				  thread implementation t2.i
				  end t2.i;
				  
				  subprogram sub2
				  end sub2;
				  
				  subprogram implementation sub2.i
				  end sub2.i;
				  
				  subprogram group subg2
				  end subg2;
				  
				  subprogram group implementation subg2.i
				  end subg2.i;
				  
				  processor proc2
				  end proc2;
				  
				  processor implementation proc2.i
				  end proc2.i;
				  
				  virtual processor vp2
				  end vp2;
				  
				  virtual processor implementation vp2.i
				  end vp2.i;
				  
				  device dev2
				  end dev2;
				  
				  device implementation dev2.i
				  end dev2.i;
				  
				  memory m2
				  end m2;
				  
				  memory implementation m2.i
				  end m2.i;
				  
				  bus b2
				  end b2;
				  
				  bus implementation b2.i
				  end b2.i;
				  
				  virtual bus vb2
				  end vb2;
				  
				  virtual bus implementation vb2.i
				  end vb2.i;
				  
				  data d2
				  end d2;
				  
				  data implementation d2.i
				  end d2.i;
				end pack2;
			''',
			"pack3.aadl" -> '''
				package pack3
				public
				  abstract a3
				  end a3;
				  
				  abstract implementation a3.i
				  end a3.i;
				  
				  system s3
				  end s3;
				  
				  system implementation s3.i
				  end s3.i;
				  
				  process p3
				  end p3;
				  
				  process implementation p3.i
				  end p3.i;
				  
				  thread group tg3
				  end tg3;
				  
				  thread group implementation tg3.i
				  end tg3.i;
				  
				  thread t3
				  end t3;
				  
				  thread implementation t3.i
				  end t3.i;
				  
				  subprogram sub3
				  end sub3;
				  
				  subprogram implementation sub3.i
				  end sub3.i;
				  
				  subprogram group subg3
				  end subg3;
				  
				  subprogram group implementation subg3.i
				  end subg3.i;
				  
				  processor proc3
				  end proc3;
				  
				  processor implementation proc3.i
				  end proc3.i;
				  
				  virtual processor vp3
				  end vp3;
				  
				  virtual processor implementation vp3.i
				  end vp3.i;
				  
				  device dev3
				  end dev3;
				  
				  device implementation dev3.i
				  end dev3.i;
				  
				  memory m3
				  end m3;
				  
				  memory implementation m3.i
				  end m3.i;
				  
				  bus b3
				  end b3;
				  
				  bus implementation b3.i
				  end b3.i;
				  
				  virtual bus vb3
				  end vb3;
				  
				  virtual bus implementation vb3.i
				  end vb3.i;
				  
				  data d3
				  end d3;
				  
				  data implementation d3.i
				  end d3.i;
				end pack3;
			''',
			"pack4.aadl" -> '''
				package pack4
				public
				  abstract a4
				  end a4;
				  
				  abstract implementation a4.i
				  end a4.i;
				  
				  system s4
				  end s4;
				  
				  system implementation s4.i
				  end s4.i;
				  
				  process p4
				  end p4;
				  
				  process implementation p4.i
				  end p4.i;
				  
				  thread group tg4
				  end tg4;
				  
				  thread group implementation tg4.i
				  end tg4.i;
				  
				  thread t4
				  end t4;
				  
				  thread implementation t4.i
				  end t4.i;
				  
				  subprogram sub4
				  end sub4;
				  
				  subprogram implementation sub4.i
				  end sub4.i;
				  
				  subprogram group subg4
				  end subg4;
				  
				  subprogram group implementation subg4.i
				  end subg4.i;
				  
				  processor proc4
				  end proc4;
				  
				  processor implementation proc4.i
				  end proc4.i;
				  
				  virtual processor vp4
				  end vp4;
				  
				  virtual processor implementation vp4.i
				  end vp4.i;
				  
				  device dev4
				  end dev4;
				  
				  device implementation dev4.i
				  end dev4.i;
				  
				  memory m4
				  end m4;
				  
				  memory implementation m4.i
				  end m4.i;
				  
				  bus b4
				  end b4;
				  
				  bus implementation b4.i
				  end b4.i;
				  
				  virtual bus vb4
				  end vb4;
				  
				  virtual bus implementation vb4.i
				  end vb4.i;
				  
				  data d4
				  end d4;
				  
				  data implementation d4.i
				  end d4.i;
				end pack4;
			''',
			"pack5.aadl" -> '''
				package pack5
				public
				  abstract a5
				  end a5;
				  
				  abstract implementation a5.i
				  end a5.i;
				  
				  system s5
				  end s5;
				  
				  system implementation s5.i
				  end s5.i;
				  
				  process p5
				  end p5;
				  
				  process implementation p5.i
				  end p5.i;
				  
				  thread group tg5
				  end tg5;
				  
				  thread group implementation tg5.i
				  end tg5.i;
				  
				  thread t5
				  end t5;
				  
				  thread implementation t5.i
				  end t5.i;
				  
				  subprogram sub5
				  end sub5;
				  
				  subprogram implementation sub5.i
				  end sub5.i;
				  
				  subprogram group subg5
				  end subg5;
				  
				  subprogram group implementation subg5.i
				  end subg5.i;
				  
				  processor proc5
				  end proc5;
				  
				  processor implementation proc5.i
				  end proc5.i;
				  
				  virtual processor vp5
				  end vp5;
				  
				  virtual processor implementation vp5.i
				  end vp5.i;
				  
				  device dev5
				  end dev5;
				  
				  device implementation dev5.i
				  end dev5.i;
				  
				  memory m5
				  end m5;
				  
				  memory implementation m5.i
				  end m5.i;
				  
				  bus b5
				  end b5;
				  
				  bus implementation b5.i
				  end b5.i;
				  
				  virtual bus vb5
				  end vb5;
				  
				  virtual bus implementation vb5.i
				  end vb5.i;
				  
				  data d5
				  end d5;
				  
				  data implementation d5.i
				  end d5.i;
				  
				  abstract a6
				  end a6;
				  
				  system s6
				  end s6;
				  
				  process p6
				  end p6;
				  
				  thread group tg6
				  end tg6;
				  
				  thread t6
				  end t6;
				  
				  subprogram sub6
				  end sub6;
				  
				  subprogram group subg6
				  end subg6;
				  
				  processor proc6
				  end proc6;
				  
				  virtual processor vp6
				  end vp6;
				  
				  device dev6
				  end dev6;
				  
				  memory m6
				  end m6;
				  
				  bus b6
				  end b6;
				  
				  virtual bus vb6
				  end vb6;
				  
				  data d6
				  end d6;
				end pack5;
			'''
		)
		suppressSerialization
		val pack1 = testFile("pack1.aadl").resource.contents.head as AadlPackage
		assertAllCrossReferencesResolvable(pack1)
		
		pack1 => [
			Assert::assertEquals("pack1", name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				Assert::assertEquals("container.i", name)
				ownedAbstractSubcomponents.head => [
					Assert::assertEquals("asub", name)
					//Tests scope_AbstractSubcomponent_abstractSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.abstractSubcomponent_AbstractSubcomponentType, "aproto, a5, ra, a3, a3.i, renamed_package.a4, " +
						"renamed_package.a4.i, container, container.i, a1, a1.i, pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack3.a3, " +
						"pack3.a3.i, pack2.a2, pack2.a2.i, pack5.a5, pack5.a5.i, pack5.a6, pack4.a4, pack4.a4.i"
					)
				]
				ownedSystemSubcomponents.head => [
					Assert::assertEquals("ssub", name)
					//Tests scope_SystemSubcomponent_systemSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.systemSubcomponent_SystemSubcomponentType, "aproto, sproto, a5, s5, ra, rs, a3, a3.i, s3, s3.i, " +
						"renamed_package.a4, renamed_package.a4.i, renamed_package.s4, renamed_package.s4.i, container, container.i, a1, a1.i, s1, s1.i, " +
						"pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.s1, pack1.s1.i, pack3.a3, pack3.a3.i, pack3.s3, pack3.s3.i, " +
						"pack2.a2, pack2.a2.i, pack2.s2, pack2.s2.i, pack5.a5, pack5.a5.i, pack5.s5, pack5.s5.i, pack5.a6, pack5.s6, pack4.a4, pack4.a4.i, " +
						"pack4.s4, pack4.s4.i"
					)
				]
				ownedProcessSubcomponents.head => [
					Assert::assertEquals("psub", name)
					//Tests scope_ProcessSubcomponent_processSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.processSubcomponent_ProcessSubcomponentType, "aproto, pproto, a5, p5, ra, rp, a3, a3.i, p3, p3.i, " +
						"renamed_package.a4, renamed_package.a4.i, renamed_package.p4, renamed_package.p4.i, container, container.i, a1, a1.i, p1, p1.i, " +
						"pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.p1, pack1.p1.i, pack3.a3, pack3.a3.i, pack3.p3, pack3.p3.i, " +
						"pack2.a2, pack2.a2.i, pack2.p2, pack2.p2.i, pack5.a5, pack5.a5.i, pack5.p5, pack5.p5.i, pack5.a6, pack5.p6, pack4.a4, pack4.a4.i, " +
						"pack4.p4, pack4.p4.i"
					)
				]
				ownedThreadGroupSubcomponents.head => [
					Assert::assertEquals("tgsub", name)
					//Tests scope_ThreadGroupSubcomponent_threadGroupSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.threadGroupSubcomponent_ThreadGroupSubcomponentType, "aproto, tgproto, a5, tg5, ra, rtg, a3, a3.i, " +
						"tg3, tg3.i, renamed_package.a4, renamed_package.a4.i, renamed_package.tg4, renamed_package.tg4.i, container, container.i, a1, a1.i, " +
						"tg1, tg1.i, pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.tg1, pack1.tg1.i, pack3.a3, pack3.a3.i, pack3.tg3, " +
						"pack3.tg3.i, pack2.a2, pack2.a2.i, pack2.tg2, pack2.tg2.i, pack5.a5, pack5.a5.i, pack5.tg5, pack5.tg5.i, pack5.a6, pack5.tg6, " +
						"pack4.a4, pack4.a4.i, pack4.tg4, pack4.tg4.i"
					)
				]
				ownedThreadSubcomponents.head => [
					Assert::assertEquals("tsub", name)
					//Tests scope_ThreadSubcomponent_threadSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.threadSubcomponent_ThreadSubcomponentType, "aproto, tproto, a5, t5, ra, rt, a3, a3.i, t3, t3.i, " +
						"renamed_package.a4, renamed_package.a4.i, renamed_package.t4, renamed_package.t4.i, container, container.i, a1, a1.i, t1, t1.i, " +
						"pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.t1, pack1.t1.i, pack3.a3, pack3.a3.i, pack3.t3, pack3.t3.i, " +
						"pack2.a2, pack2.a2.i, pack2.t2, pack2.t2.i, pack5.a5, pack5.a5.i, pack5.t5, pack5.t5.i, pack5.a6, pack5.t6, pack4.a4, pack4.a4.i, " +
						"pack4.t4, pack4.t4.i"
					)
				]
				ownedSubprogramSubcomponents.head => [
					Assert::assertEquals("subsub", name)
					//Tests scope_SubprogramSubcomponent_subprogramSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.subprogramSubcomponent_SubprogramSubcomponentType, "aproto, subproto, a5, sub5, ra, rsub, a3, a3.i, " +
						"sub3, sub3.i, renamed_package.a4, renamed_package.a4.i, renamed_package.sub4, renamed_package.sub4.i, container, container.i, a1, " +
						"a1.i, sub1, sub1.i, pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.sub1, pack1.sub1.i, pack3.a3, pack3.a3.i, " +
						"pack3.sub3, pack3.sub3.i, pack2.a2, pack2.a2.i, pack2.sub2, pack2.sub2.i, pack5.a5, pack5.a5.i, pack5.sub5, pack5.sub5.i, pack5.a6, " +
						"pack5.sub6, pack4.a4, pack4.a4.i, pack4.sub4, pack4.sub4.i"
					)
				]
				ownedSubprogramGroupSubcomponents.head => [
					Assert::assertEquals("subgsub", name)
					//Tests scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.subprogramGroupSubcomponent_SubprogramGroupSubcomponentType, "aproto, subgproto, a5, subg5, ra, rsubg, " +
						"a3, a3.i, subg3, subg3.i, renamed_package.a4, renamed_package.a4.i, renamed_package.subg4, renamed_package.subg4.i, container, " +
						"container.i, a1, a1.i, subg1, subg1.i, pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.subg1, pack1.subg1.i, pack3.a3, " +
						"pack3.a3.i, pack3.subg3, pack3.subg3.i, pack2.a2, pack2.a2.i, pack2.subg2, pack2.subg2.i, pack5.a5, pack5.a5.i, pack5.subg5, " +
						"pack5.subg5.i, pack5.a6, pack5.subg6, pack4.a4, pack4.a4.i, pack4.subg4, pack4.subg4.i"
					)
				]
				ownedProcessorSubcomponents.head => [
					Assert::assertEquals("procsub", name)
					//Tests scope_ProcessorSubcomponent_processorSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.processorSubcomponent_ProcessorSubcomponentType, "aproto, procproto, a5, proc5, ra, rproc, a3, a3.i, " +
						"proc3, proc3.i, renamed_package.a4, renamed_package.a4.i, renamed_package.proc4, renamed_package.proc4.i, container, container.i, a1, " +
						"a1.i, proc1, proc1.i, pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.proc1, pack1.proc1.i, pack3.a3, pack3.a3.i, " +
						"pack3.proc3, pack3.proc3.i, pack2.a2, pack2.a2.i, pack2.proc2, pack2.proc2.i, pack5.a5, pack5.a5.i, pack5.proc5, pack5.proc5.i, " +
						"pack5.a6, pack5.proc6, pack4.a4, pack4.a4.i, pack4.proc4, pack4.proc4.i"
					)
				]
				ownedVirtualProcessorSubcomponents.head => [
					Assert::assertEquals("vpsub", name)
					//Tests scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.virtualProcessorSubcomponent_VirtualProcessorSubcomponentType, "aproto, vpproto, a5, vp5, ra, rvp, a3, " +
						"a3.i, vp3, vp3.i, renamed_package.a4, renamed_package.a4.i, renamed_package.vp4, renamed_package.vp4.i, container, container.i, a1, " +
						"a1.i, vp1, vp1.i, pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.vp1, pack1.vp1.i, pack3.a3, pack3.a3.i, pack3.vp3, " +
						"pack3.vp3.i, pack2.a2, pack2.a2.i, pack2.vp2, pack2.vp2.i, pack5.a5, pack5.a5.i, pack5.vp5, pack5.vp5.i, pack5.a6, pack5.vp6, pack4.a4, " +
						"pack4.a4.i, pack4.vp4, pack4.vp4.i"
					)
				]
				ownedDeviceSubcomponents.head => [
					Assert::assertEquals("devsub", name)
					//Tests scope_DeviceSubcomponent_deviceSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.deviceSubcomponent_DeviceSubcomponentType, "aproto, devproto, a5, dev5, ra, rdev, a3, a3.i, dev3, dev3.i, " +
						"renamed_package.a4, renamed_package.a4.i, renamed_package.dev4, renamed_package.dev4.i, container, container.i, a1, a1.i, dev1, dev1.i, " +
						"pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.dev1, pack1.dev1.i, pack3.a3, pack3.a3.i, pack3.dev3, pack3.dev3.i, " +
						"pack2.a2, pack2.a2.i, pack2.dev2, pack2.dev2.i, pack5.a5, pack5.a5.i, pack5.dev5, pack5.dev5.i, pack5.a6, pack5.dev6, pack4.a4, " +
						"pack4.a4.i, pack4.dev4, pack4.dev4.i"
					)
				]
				ownedMemorySubcomponents.head => [
					Assert::assertEquals("msub", name)
					//Tests scope_MemorySubcomponent_memorySubcomponentType
					assertScope(Aadl2Package::eINSTANCE.memorySubcomponent_MemorySubcomponentType, "aproto, mproto, a5, m5, ra, rm, a3, a3.i, m3, m3.i, " +
						"renamed_package.a4, renamed_package.a4.i, renamed_package.m4, renamed_package.m4.i, container, container.i, a1, a1.i, m1, m1.i, " +
						"pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.m1, pack1.m1.i, pack3.a3, pack3.a3.i, pack3.m3, pack3.m3.i, pack2.a2, " +
						"pack2.a2.i, pack2.m2, pack2.m2.i, pack5.a5, pack5.a5.i, pack5.m5, pack5.m5.i, pack5.a6, pack5.m6, pack4.a4, pack4.a4.i, pack4.m4, pack4.m4.i"
					)
				]
				ownedBusSubcomponents.head => [
					Assert::assertEquals("bsub", name)
					//Tests scope_BusSubcomponent_busSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.busSubcomponent_BusSubcomponentType, "aproto, bproto, a5, b5, ra, rb, a3, a3.i, b3, b3.i, " +
						"renamed_package.a4, renamed_package.a4.i, renamed_package.b4, renamed_package.b4.i, container, container.i, a1, a1.i, b1, b1.i, " +
						"pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.b1, pack1.b1.i, pack3.a3, pack3.a3.i, pack3.b3, pack3.b3.i, pack2.a2, " +
						"pack2.a2.i, pack2.b2, pack2.b2.i, pack5.a5, pack5.a5.i, pack5.b5, pack5.b5.i, pack5.a6, pack5.b6, pack4.a4, pack4.a4.i, pack4.b4, pack4.b4.i"
					)
				]
				ownedVirtualBusSubcomponents.head => [
					Assert::assertEquals("vbsub", name)
					//Tests scope_VirtualBusSubcomponent_virtualBusSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.virtualBusSubcomponent_VirtualBusSubcomponentType, "aproto, vbproto, a5, vb5, ra, rvb, a3, a3.i, vb3, " +
						"vb3.i, renamed_package.a4, renamed_package.a4.i, renamed_package.vb4, renamed_package.vb4.i, container, container.i, a1, a1.i, vb1, " +
						"vb1.i, pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.vb1, pack1.vb1.i, pack3.a3, pack3.a3.i, pack3.vb3, pack3.vb3.i, " +
						"pack2.a2, pack2.a2.i, pack2.vb2, pack2.vb2.i, pack5.a5, pack5.a5.i, pack5.vb5, pack5.vb5.i, pack5.a6, pack5.vb6, pack4.a4, pack4.a4.i, " +
						"pack4.vb4, pack4.vb4.i"
					)
				]
				ownedDataSubcomponents.head => [
					Assert::assertEquals("dsub", name)
					//Tests scope_DataSubcomponent_dataSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.dataSubcomponent_DataSubcomponentType, "aproto, dproto, a5, d5, ra, rd, a3, a3.i, d3, d3.i, " +
						"renamed_package.a4, renamed_package.a4.i, renamed_package.d4, renamed_package.d4.i, container, container.i, a1, a1.i, d1, d1.i, " +
						"pack1.container, pack1.container.i, pack1.a1, pack1.a1.i, pack1.d1, pack1.d1.i, pack3.a3, pack3.a3.i, pack3.d3, pack3.d3.i, pack2.a2, " +
						"pack2.a2.i, pack2.d2, pack2.d2.i, pack5.a5, pack5.a5.i, pack5.d5, pack5.d5.i, pack5.a6, pack5.d6, pack4.a4, pack4.a4.i, pack4.d4, " +
						"pack4.d4.i, Base_Types.Boolean, Base_Types.Integer, Base_Types.Integer_8, Base_Types.Integer_16, Base_Types.Integer_32, " +
						"Base_Types.Integer_64, Base_Types.Unsigned_8, Base_Types.Unsigned_16, Base_Types.Unsigned_32, Base_Types.Unsigned_64, " +
						"Base_Types.Natural, Base_Types.Float, Base_Types.Float_32, Base_Types.Float_64, Base_Types.Character, Base_Types.String"
					)
				]
			]
		]
	}
	
	def private assertScope(EObject context, EReference reference, CharSequence expected) {
		context.assertNoErrors
		Assert.assertEquals(expected, context.getScope(reference).allElements.map[name].join(", "))
	}
}