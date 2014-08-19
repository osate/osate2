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

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import com.google.inject.Inject
import org.junit.Assert
import org.eclipse.xtext.scoping.IScopeProvider
import org.osate.aadl2.ModelUnit
import org.eclipse.xtext.junit4.util.ParseHelper

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Aadl2ScopeProviderTests extends OsateTest {
	@Inject extension ParseHelper<ModelUnit>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider
	
	@Before
	def setUp() {
		createProject("Aadl2_Scope_Provider_Test", "packages")
		buildProject("Plugin_Resources", true)
		setResourceRoot("platform:/resource/Aadl2_Scope_Provider_Test/packages")
	}
	
	@Test
	def void scope_ComponentPrototype_constrainingClassifier() {
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
		val result = testFile("pack1.aadl")
		val pack1 = result.resource.contents.head as AadlPackage
		assertAllCrossReferencesResolvable(pack1)

		pack1.publicSection.ownedClassifiers.get(0).ownedPrototypes.get(0) => [
			assertScope(Aadl2Package::eINSTANCE.componentPrototype_ConstrainingClassifier, "a6, renmaed_classifier, a4, a4.i, " +
				"renamed_package.a5, renamed_package.a5.i, a1, a2, a2.i, pack1.a1, pack1.a2, pack1.a2.i, pack2.a3, pack2.a3.i, " +
				"pack5.a6, pack5.a7, pack4.a5, pack4.a5.i, pack3.a4, pack3.a4.i, Base_Types.Boolean, Base_Types.Integer, " +
				"Base_Types.Integer_8, Base_Types.Integer_16, Base_Types.Integer_32, Base_Types.Integer_64, Base_Types.Unsigned_8, " +
				"Base_Types.Unsigned_16, Base_Types.Unsigned_32, Base_Types.Unsigned_64, Base_Types.Natural, Base_Types.Float, " +
				"Base_Types.Float_32, Base_Types.Float_64, Base_Types.Character, Base_Types.String")
		]
	}
	
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
			Assert::assertEquals(name, "a1")
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "")
		]
		classifiers.get(1) => [
			Assert::assertEquals(name, "a2")
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "proto1")
		]
		classifiers.get(2) => [
			Assert::assertEquals(name, "fgt1")
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "")
		]
		classifiers.get(3) => [
			Assert::assertEquals(name, "fgt2")
			assertScope(Aadl2Package::eINSTANCE.prototype_Refined, "proto2")
		]
	}
	
	def private assertScope(EObject context, EReference reference, CharSequence expected) {
		context.assertNoErrors
		Assert.assertEquals(expected, context.getScope(reference).allElements.map[name].join(", "))
	}
}