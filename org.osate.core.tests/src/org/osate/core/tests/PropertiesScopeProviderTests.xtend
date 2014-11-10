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
//package org.osate.core.tests
//
//import com.google.inject.Inject
//import org.eclipse.core.resources.IncrementalProjectBuilder
//import org.eclipse.core.resources.ResourcesPlugin
//import org.eclipse.core.runtime.CoreException
//import org.eclipse.core.runtime.NullProgressMonitor
//import org.eclipse.emf.ecore.EObject
//import org.eclipse.emf.ecore.EReference
//import org.eclipse.xtext.junit4.InjectWith
//import org.eclipse.xtext.junit4.XtextRunner
//import org.eclipse.xtext.junit4.util.ParseHelper
//import org.eclipse.xtext.junit4.validation.ValidationTestHelper
//import org.eclipse.xtext.scoping.IScopeProvider
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.osate.aadl2.Aadl2Package
//import org.osate.aadl2.AadlPackage
//import org.osate.aadl2.ModelUnit
//import org.osate.xtext.aadl2.Aadl2UiInjectorProvider
//
//import static extension org.junit.Assert.*
//
//@RunWith(typeof(XtextRunner))
//@InjectWith(typeof(Aadl2UiInjectorProvider))
//class PropertiesScopeProviderTests {
//	@Inject extension ParseHelper<ModelUnit>
//	@Inject extension ValidationTestHelper
//	@Inject extension IScopeProvider
//	
//	@Before
//	def setUp() {
//		val workspaceRoot = ResourcesPlugin::getWorkspace().root
//		val project = workspaceRoot.getProject("Plugin_Resources")
//		Assert::assertTrue(project.exists)
//		try {
//			project.build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor)
//		} catch (CoreException e) {
//			e.printStackTrace
//		}
//	}
//	
//	@Test
//	def void testScope_NumberValue_unit() {
//		('''
//			package pack
//			public
//			  thread t
//			    properties
//			      Timing_Properties::Activate_Deadline => 5 ns;
//			  end t;
//			end pack;
//		'''.parse as AadlPackage).publicSection.ownedClassifiers.get(0).ownedPropertyAssociations.get(0) => [
//			assertScope(Aadl2Package::eINSTANCE.numberValue_Unit, "ps, ns, us, ms, sec, min, hr")
//		]
//	}
//	
//	def private assertScope(EObject context, EReference reference, CharSequence expected) {
//		context.assertNoErrors
//		expected.toString.assertEquals(context.getScope(reference).allElements.map[name].join(", "))
//	}
//}