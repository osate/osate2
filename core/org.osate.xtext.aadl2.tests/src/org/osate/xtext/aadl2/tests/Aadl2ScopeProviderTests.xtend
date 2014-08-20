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
	
	//Tests scope_ComponentPrototype_constrainingClassifier and scope_FeaturePrototype_constrainingClassifier
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
				  renmaed_classifier renames abstract pack5::a7;
				
				  abstract a1
				    prototypes
				      proto1: abstract a2;
				      proto2: feature a2;
				  end a1;
				  
				  abstract a2
				  end a2;
				  
				  abstract implementation a2.i
				  end a2.i;
				end pack1;
			''',
			"pack2.aadl" -> '''
				package pack2
				public
				  abstract a3
				  end a3;
				  
				  abstract implementation a3.i
				  end a3.i;
			''',
			"pack3.aadl" -> '''
				package pack3
				public
				  abstract a4
				  end a4;
				  
				  abstract implementation a4.i
				  end a4.i;
				end pack3;
			''',
			"pack4.aadl" -> '''
				package pack4
				public
				  abstract a5
				  end a5;
				  
				  abstract implementation a5.i
				  end a5.i;
				end pack4;
			''',
			"pack5.aadl" -> '''
				package pack5
				public
				  abstract a6
				  end a6;
				  
				  abstract a7
				  end a7;
				end pack5;
			'''
		)
		suppressSerialization
		val pack1 = testFile("pack1.aadl").resource.contents.head as AadlPackage
		assertAllCrossReferencesResolvable(pack1)

		val prototypes = pack1.publicSection.ownedClassifiers.get(0).ownedPrototypes
		prototypes.get(0) => [
			Assert::assertEquals("proto1", name)
			//Tests scope_ComponentPrototype_constrainingClassifier
			assertScope(Aadl2Package::eINSTANCE.componentPrototype_ConstrainingClassifier, "a6, renmaed_classifier, a4, a4.i, " +
				"renamed_package.a5, renamed_package.a5.i, a1, a2, a2.i, pack1.a1, pack1.a2, pack1.a2.i, pack3.a4, pack3.a4.i, " +
				"pack2.a3, pack2.a3.i, pack5.a6, pack5.a7, pack4.a5, pack4.a5.i, Base_Types.Boolean, Base_Types.Integer, " +
				"Base_Types.Integer_8, Base_Types.Integer_16, Base_Types.Integer_32, Base_Types.Integer_64, Base_Types.Unsigned_8, " +
				"Base_Types.Unsigned_16, Base_Types.Unsigned_32, Base_Types.Unsigned_64, Base_Types.Natural, Base_Types.Float, " +
				"Base_Types.Float_32, Base_Types.Float_64, Base_Types.Character, Base_Types.String")
		]
		prototypes.get(1) => [
			Assert::assertEquals("proto2", name)
			//Tests scope_FeaturePrototype_constrainingClassifier
			assertScope(Aadl2Package::eINSTANCE.featurePrototype_ConstrainingClassifier, "a6, renmaed_classifier, a4, a4.i, " +
				"renamed_package.a5, renamed_package.a5.i, a1, a2, a2.i, pack1.a1, pack1.a2, pack1.a2.i, pack3.a4, pack3.a4.i, " +
				"pack2.a3, pack2.a3.i, pack5.a6, pack5.a7, pack4.a5, pack4.a5.i, Base_Types.Boolean, Base_Types.Integer, " +
				"Base_Types.Integer_8, Base_Types.Integer_16, Base_Types.Integer_32, Base_Types.Integer_64, Base_Types.Unsigned_8, " +
				"Base_Types.Unsigned_16, Base_Types.Unsigned_32, Base_Types.Unsigned_64, Base_Types.Natural, Base_Types.Float, " +
				"Base_Types.Float_32, Base_Types.Float_64, Base_Types.Character, Base_Types.String")
		]
	}
	
	//Tests scope_Prototype_refined
	@Test
	def void scope_Prototype_refined() {
		val classifiers = ('''
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
			end pack;
		'''.parse as AadlPackage).publicSection.ownedClassifiers
		classifiers.get(0) => [
			Assert::assertEquals("a1", name)
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "")
		]
		classifiers.get(1) => [
			Assert::assertEquals("a2", name)
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "proto1")
		]
		classifiers.get(2) => [
			Assert::assertEquals("fgt1", name)
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "")
		]
		classifiers.get(3) => [
			Assert::assertEquals("fgt2", name)
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "proto2")
		]
	}
	
	/*
	 * Tests scope_PrototypeBinding_formal(ComponentPrototypeActual, EReference), scope_PrototypeBinding_formal(FeatureGroupPrototypeActual, EReference),
	 * scope_PrototypeBinding_formal(ComponentImplementationReference, EReference), scope_PrototypeBinding_formal(Subcomponent, EReference), and
	 * scope_PrototypeBinding_formal(Classifier, EReference)
	 */
	@Test
	def void scope_PrototypeBinding_formal() {
		val classifiers = ('''
			package pack
			public
			  abstract a1
			  prototypes
			    proto1: abstract;
			    proto3: feature group;
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
			    proto3 => feature group fgt1
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
			  end fgt1;
			  
			  feature group fgt2 extends fgt1 (
			    proto4 => in data port
			  )
			  end fgt2;
			end pack;
		'''.parse as AadlPackage).publicSection.ownedClassifiers
		
		classifiers.get(1) => [
			Assert::assertEquals("a2", name)
			ownedPrototypeBindings.get(0) as ComponentPrototypeBinding => [
				//Tests scope_PrototypeBinding_formal(Classifier, EReference)
				assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3")
				Assert::assertEquals("proto1", formal.name)
				actuals.get(0) => [
					Assert::assertEquals("a3", subcomponentType.name)
					//Tests scope_PrototypeBinding_formal(ComponentPrototypeActual, EReference)
					bindings.get(0).assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto2")
				]
			]
			ownedPrototypeBindings.get(1) as FeatureGroupPrototypeBinding => [
				//Tests scope_PrototypeBinding_formal(Classifier, EReference)
				assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3")
				Assert::assertEquals("proto3", formal.name)
				actual => [
					Assert::assertEquals("fgt1", (featureType as NamedElement).name)
					//Tests scope_PrototypeBinding_formal(FeatureGroupPrototypeActual, EReference)
					bindings.get(0).assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto4")
				]
			]
		]
		classifiers.get(2) as ComponentImplementation => [
			Assert::assertEquals("a1.i1", name)
			ownedSubcomponents.get(0) => [
				Assert::assertEquals("asub1", name)
				implementationReferences.get(0) => [
					Assert::assertEquals("a3.i1", implementation.name)
					//Tests scope_PrototypeBinding_formal(ComponentImplementationReference, EReference)
					ownedPrototypeBindings.get(0).assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto2")
				]
			]
			ownedSubcomponents.get(1) => [
				Assert::assertEquals("asub2", name)
				//Tests scope_PrototypeBinding_formal(Subcomponent, EReference)
				ownedPrototypeBindings.get(0).assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto2")
			]
		]
		classifiers.get(3) => [
			Assert::assertEquals("a1.i2", name)
			//Tests scope_PrototypeBinding_formal(Classifier, EReference)
			ownedPrototypeBindings.get(0).assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3")
			//Tests scope_PrototypeBinding_formal(Classifier, EReference)
			ownedPrototypeBindings.get(1).assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto1, proto3")
		]
		classifiers.get(7) => [
			Assert::assertEquals("fgt2", name)
			//Tests scope_PrototypeBinding_formal(Classifier, EReference)
			ownedPrototypeBindings.get(0).assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, "proto4")
		]
	}
	
	def private assertScope(EObject context, EReference reference, CharSequence expected) {
		context.assertNoErrors
		Assert.assertEquals(expected, context.getScope(reference).allElements.map[name].join(", "))
	}
}