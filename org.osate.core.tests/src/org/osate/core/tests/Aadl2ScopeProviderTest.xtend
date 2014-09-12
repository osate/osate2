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
package org.osate.core.tests

import com.google.inject.Inject
import java.util.Comparator
import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.AbstractType
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentPrototypeBinding
import org.osate.aadl2.ComponentType
import org.osate.aadl2.FeatureGroupPrototypeBinding
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.FeaturePrototypeBinding
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.NamedElement
import org.osate.aadl2.SubprogramType
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider

import static extension org.junit.Assert.assertEquals

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Aadl2ScopeProviderTest extends OsateTest {
	@Inject extension ParseHelper<ModelUnit>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider
	
	static val TEST_PROJECT_NAME = "Aadl2_Scope_Provider_Test"
	
	val pluginResourcesNames = workspaceRoot.getProject("Plugin_Resources").members.filter(typeof(IFile)).map[name].filter[toLowerCase.endsWith(".aadl")].map[substring(0, lastIndexOf("."))]
	
	@Before
	def setUp() {
		createProject(TEST_PROJECT_NAME, "packages")
		buildProject("Plugin_Resources", true)
		setResourceRoot("platform:/resource/" + TEST_PROJECT_NAME + "/packages")
	}
	
	@After
	def cleanUp() {
		deleteProject(TEST_PROJECT_NAME)
	}
	
//	@BeforeClass
//	def static showReferences() {
//		println
//		typeof(Aadl2Package).methods.filter[declaringClass == typeof(Aadl2Package) && returnType == typeof(EReference)].map[it -> invoke(Aadl2Package::eINSTANCE) as EReference].
//			filter[!value.containment && !value.derived].filter[value.EReferenceType == Aadl2Package::eINSTANCE.feature].
//			forEach[println(key.name.substring(3, key.name.indexOf("_")) + "." + value.name + "->" + value.EReferenceType.name)]
//	}
	
	/*
	 * Tests scope_ComponentPrototype_constrainingClassifier, scope_FeaturePrototype_constrainingClassifier, scope_FeatureGroupPrototypeActual_featureType,
	 * scope_PortSpecification_classifier, scope_AccessSpecification_classifier, scope_ComponentPrototypeActual_subcomponentType,
	 * scope_EventDataSource_dataClassifier, scope_PortProxy_dataClassifier, and scope_SubprogramProxy_subprogramClassifier
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
				  renames data pack5::d5;
				  renames subprogram pack5::subp5;
				  renames feature group pack5::fgt5;
				  
				  renamed_abstract renames abstract pack5::a7;
				  renamed_data renames data pack5::d6;
				  renamed_subprogram renames subprogram pack5::subp6;
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
				  internal features
				    eds1: event data d1;
				  processor features
				    pp1: port d1;
				    sp1: subprogram subp1;
				  end a2.i;
				  
				  feature group fgt1
				  end fgt1;
				  
				  data d1
				  end d1;
				  
				  data implementation d1.i
				  end d1.i;
				  
				  subprogram subp1
				  end subp1;
				  
				  subprogram implementation subp1.i
				  end subp1.i;
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
				  
				  subprogram subp2
				  end subp2;
				  
				  subprogram implementation subp2.i
				  end subp2.i;
				end pack2;
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
				  
				  subprogram subp3
				  end subp3;
				  
				  subprogram implementation subp3.i
				  end subp3.i;
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
				  
				  subprogram subp4
				  end subp4;
				  
				  subprogram implementation subp4.i
				  end subp4.i;
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
				  
				  subprogram subp5
				  end subp5;
				  
				  subprogram implementation subp5.i
				  end subp5.i;
				  
				  data d6
				  end d6;
				  
				  data implementation d6.i
				  end d6.i;
				  
				  subprogram subp6
				  end subp6;
				  
				  subprogram implementation subp6.i
				  end subp6.i;
				end pack5;
			'''
		)
		suppressSerialization
		testFile("pack2.aadl").resource.contents.head.assertNoIssues
		testFile("pack3.aadl").resource.contents.head.assertNoIssues
		testFile("pack4.aadl").resource.contents.head.assertNoIssues
		testFile("pack5.aadl").resource.contents.head.assertNoIssues
		val pack1 = testFile("pack1.aadl").resource.contents.head as AadlPackage
		pack1.assertNoIssues
		
		val componentClassifierScopeForPack1 = #["a1", "a2", "a2.i", "a4", "a4.i", "a6", "d1", "d1.i", "d3", "d3.i", "d5", "renamed_abstract", "renamed_data",
			"renamed_subprogram", "subp1", "subp1.i", "subp3", "subp3.i", "subp5", "pack1::a1", "pack1::a2", "pack1::a2.i", "pack1::d1", "pack1::d1.i",
			"pack1::subp1", "pack1::subp1.i", "pack2::a3", "pack2::a3.i", "pack2::d2", "pack2::d2.i", "pack2::subp2", "pack2::subp2.i", "pack3::a4",
			"pack3::a4.i", "pack3::d3", "pack3::d3.i", "pack3::subp3", "pack3::subp3.i", "pack4::a5", "pack4::a5.i", "pack4::d4", "pack4::d4.i",
			"pack4::subp4", "pack4::subp4.i", "pack5::a6", "pack5::a7", "pack5::d5", "pack5::d5.i", "pack5::d6", "pack5::d6.i", "pack5::subp5",
			"pack5::subp5.i", "pack5::subp6", "pack5::subp6.i", "renamed_package::a5", "renamed_package::a5.i", "renamed_package::d4", "renamed_package::d4.i",
			"renamed_package::subp4", "renamed_package::subp4.i"
		]
		
		pack1 => [
			"pack1".assertEquals(name)
			publicSection.ownedClassifiers.get(0) => [
				"a1".assertEquals(name)
				ownedPrototypes.get(0) => [
					"proto1".assertEquals(name)
					//Tests scope_ComponentPrototype_constrainingClassifier
					assertScope(Aadl2Package::eINSTANCE.componentPrototype_ConstrainingClassifier, componentClassifierScopeForPack1)
				]
				ownedPrototypes.get(1) => [
					"proto2".assertEquals(name)
					//Tests scope_FeaturePrototype_constrainingClassifier
					assertScope(Aadl2Package::eINSTANCE.featurePrototype_ConstrainingClassifier, componentClassifierScopeForPack1)
				]
			]
			publicSection.ownedClassifiers.get(1) => [
				"a2".assertEquals(name)
				ownedPrototypeBindings.get(0) as FeatureGroupPrototypeBinding => [
					"proto3".assertEquals(formal.name)
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, #["fgt1", "fgt3", "fgt5", "proto3",
						"renamed_feature_group", "pack1::fgt1", "pack2::fgt2", "pack3::fgt3", "pack4::fgt4", "pack5::fgt5", "renamed_package::fgt4"
					])
				]
				ownedPrototypeBindings.get(1) as FeaturePrototypeBinding => [
					"proto4".assertEquals(formal.name)
					//Tests scope_PortSpecification_classifier
					actual.assertScope(Aadl2Package::eINSTANCE.portSpecification_Classifier, componentClassifierScopeForPack1)
				]
				ownedPrototypeBindings.get(2) as FeaturePrototypeBinding => [
					"proto5".assertEquals(formal.name)
					//Tests scope_AccessSpecification_classifier
					actual.assertScope(Aadl2Package::eINSTANCE.accessSpecification_Classifier, componentClassifierScopeForPack1)
				]
				ownedPrototypeBindings.get(3) as ComponentPrototypeBinding => [
					"proto6".assertEquals(formal.name)
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.get(0).assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, #["proto1", "proto6"] + componentClassifierScopeForPack1)
				]
			]
			publicSection.ownedClassifiers.get(2) as ComponentImplementation => [
				"a2.i".assertEquals(name)
				ownedEventDataSources.head => [
					"eds1".assertEquals(name)
					//Tests scope_EventDataSource_dataClassifier
					assertScope(Aadl2Package::eINSTANCE.eventDataSource_DataClassifier, #["d1", "d1.i", "d3", "d3.i", "d5", "renamed_data", "pack1::d1",
						"pack1::d1.i", "pack2::d2", "pack2::d2.i", "pack3::d3", "pack3::d3.i", "pack4::d4", "pack4::d4.i", "pack5::d5", "pack5::d5.i",
						"pack5::d6", "pack5::d6.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedPortProxies.head => [
					"pp1".assertEquals(name)
					//Tests scope_PortProxy_dataClassifier
					assertScope(Aadl2Package::eINSTANCE.portProxy_DataClassifier, #["d1", "d1.i", "d3", "d3.i", "d5", "renamed_data", "pack1::d1",
						"pack1::d1.i", "pack2::d2", "pack2::d2.i", "pack3::d3", "pack3::d3.i", "pack4::d4", "pack4::d4.i", "pack5::d5", "pack5::d5.i",
						"pack5::d6", "pack5::d6.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedSubprogramProxies.head => [
					"sp1".assertEquals(name)
					//Tests scope_SubprogramProxy_subprogramClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramProxy_SubprogramClassifier, #["renamed_subprogram", "subp1", "subp1.i", "subp3", "subp3.i",
						"subp5", "pack1::subp1", "pack1::subp1.i", "pack2::subp2", "pack2::subp2.i", "pack3::subp3", "pack3::subp3.i", "pack4::subp4",
						"pack4::subp4.i", "pack5::subp5", "pack5::subp5.i", "pack5::subp6", "pack5::subp6.i", "renamed_package::subp4",
						"renamed_package::subp4.i"
					])
				]
			]
		]
	}
	
	//Tests scope_Prototype_refined, scope_Subcomponent_refined, scope_Feature_refined, and scope_Connection_refined
	@Test
	def void testRefinedElements() {
		('''
			package pack
			public
			  abstract a1
			  prototypes
			    proto1: abstract;
			  features
			    dport1: in data port;
			    edport1: in event data port;
			    eport1: in event port;
			    fg1: feature group;
			    suba1: provides subprogram access;
			    subga1: provides subprogram group access;
			    ba1: provides bus access;
			    da1: provides data access;
			    af1: feature;
			  end a1;
			  
			  abstract a2 extends a1
			  prototypes
			    proto1: refined to abstract;
			  features
			    dport1: refined to in data port;
			    edport1: refined to in event data port;
			    eport1: refined to in event port;
			    fg1: refined to feature group;
			    suba1: refined to provides subprogram access;
			    subga1: refined to provides subprogram group access;
			    ba1: refined to provides bus access;
			    da1: refined to provides data access;
			    af1: refined to feature;
			  end a2;
			  
			  feature group fgt1
			  prototypes
			    proto2: abstract;
			  features
			    dport2: in data port;
			    edport2: in event data port;
			    eport2: in event port;
			    fg2: feature group;
			    param1: in parameter;
			    suba2: provides subprogram access;
			    subga2: provides subprogram group access;
			    ba2: provides bus access;
			    da2: provides data access;
			    af2: feature;
			  end fgt1;
			  
			  feature group fgt2 extends fgt1
			  prototypes
			    proto2: refined to abstract;
			  features
			    dport2: refined to in data port;
			    edport2: refined to in event data port;
			    eport2: refined to in event port;
			    fg2: refined to feature group;
			    param1: refined to in parameter;
			    suba2: refined to provides subprogram access;
			    subga2: refined to provides subprogram group access;
			    ba2: refined to provides bus access;
			    da2: refined to provides data access;
			    af2: refined to feature;
			  end fgt2;
			  
			  abstract implementation a1.i1
			  subcomponents
			    asub1: abstract;
			  connections
			    fgconn1: feature group fg1 <-> fg1;
			  end a1.i1;
			  
			  abstract implementation a1.i2 extends a1.i1
			  subcomponents
			    asub1: refined to abstract;
			    asub2: abstract;
			  connections
			    fgconn1: refined to feature group;
			    fgconn2: feature group fg1 <-> fg1;
			  end a1.i2;
			  
			  subprogram sub1
			  features
			    edport3: in event data port;
			    eport3: in event port;
			    fg3: feature group;
			    param2: in parameter;
			    suba3: requires subprogram access;
			    subga3: requires subprogram group access;
			    da3: requires data access;
			    af3: feature;
			  end sub1;
			  
			  subprogram sub2 extends sub1
			  features
			    edport3: refined to in event data port;
			    eport3: refined to in event port;
			    fg3: refined to feature group;
			    param2: refined to in parameter;
			    suba3: refined to requires subprogram access;
			    subga3: refined to requires subprogram group access;
			    da3: refined to requires data access;
			    af3: refined to feature;
			  end sub2;
			end pack;
		'''.parse as AadlPackage) => [
			"pack".assertEquals(name)
			assertNoIssues
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"a1".assertEquals(name)
				ownedPrototypes.head => [
					"proto1".assertEquals(name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, #[])
				]
				ownedDataPorts.head => [
					"dport1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedEventDataPorts.head => [
					"edport1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedEventPorts.head => [
					"eport1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedFeatureGroups.head => [
					"fg1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedSubprogramAccesses.head => [
					"suba1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedSubprogramGroupAccesses.head => [
					"subga1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedBusAccesses.head => [
					"ba1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedDataAccesses.head => [
					"da1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedAbstractFeatures.head => [
					"af1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
			]
			publicSection.ownedClassifiers.get(1) as AbstractType => [
				"a2".assertEquals(name)
				ownedPrototypes.head => [
					"proto1".assertEquals(name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, #["proto1"])
				]
				val refinedFeatureScopeForA2 = #["af1", "ba1", "da1", "dport1", "edport1", "eport1", "fg1", "suba1", "subga1"]
				ownedDataPorts.head => [
					"dport1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedEventDataPorts.head => [
					"edport1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedEventPorts.head => [
					"eport1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedFeatureGroups.head => [
					"fg1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedSubprogramAccesses.head => [
					"suba1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedSubprogramGroupAccesses.head => [
					"subga1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedBusAccesses.head => [
					"ba1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedDataAccesses.head => [
					"da1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
				ownedAbstractFeatures.head => [
					"af1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForA2)
				]
			]
			publicSection.ownedClassifiers.get(2) as FeatureGroupType=> [
				"fgt1".assertEquals(name)
				ownedPrototypes.head => [
					"proto2".assertEquals(name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, #[])
				]
				ownedDataPorts.head => [
					"dport2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedEventDataPorts.head => [
					"edport2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedEventPorts.head => [
					"eport2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedFeatureGroups.head => [
					"fg2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedParameters.head => [
					"param1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedSubprogramAccesses.head => [
					"suba2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedSubprogramGroupAccesses.head => [
					"subga2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedBusAccesses.head => [
					"ba2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedDataAccesses.head => [
					"da2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedAbstractFeatures.head => [
					"af2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
			]
			publicSection.ownedClassifiers.get(3) as FeatureGroupType => [
				"fgt2".assertEquals(name)
				ownedPrototypes.head => [
					"proto2".assertEquals(name)
					//Tests scope_Prototype_refined
					assertScope(Aadl2Package::eINSTANCE.prototype_Refined, #["proto2"])
				]
				val refinedFeatureScopeForFgt2 = #["af2", "ba2", "da2", "dport2", "edport2", "eport2", "fg2", "param1", "suba2", "subga2"]
				ownedDataPorts.head => [
					"dport2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedEventDataPorts.head => [
					"edport2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedEventPorts.head => [
					"eport2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedFeatureGroups.head => [
					"fg2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedParameters.head => [
					"param1".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedSubprogramAccesses.head => [
					"suba2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedSubprogramGroupAccesses.head => [
					"subga2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedBusAccesses.head => [
					"ba2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedDataAccesses.head => [
					"da2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
				ownedAbstractFeatures.head => [
					"af2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForFgt2)
				]
			]
			publicSection.ownedClassifiers.get(4) as ComponentImplementation => [
				"a1.i1".assertEquals(name)
				ownedSubcomponents.head => [
					"asub1".assertEquals(name)
					//Tests scope_Subcomponent_refined
					assertScope(Aadl2Package::eINSTANCE.subcomponent_Refined, #[])
				]
				ownedConnections.head => [
					"fgconn1".assertEquals(name)
					//Tests scope_Connection_refined
					assertScope(Aadl2Package::eINSTANCE.connection_Refined, #[])
				]
			]
			publicSection.ownedClassifiers.get(5) as ComponentImplementation => [
				"a1.i2".assertEquals(name)
				ownedSubcomponents.get(0) => [
					"asub1".assertEquals(name)
					//Tests scope_Subcomponent_refined
					assertScope(Aadl2Package::eINSTANCE.subcomponent_Refined, #["asub1"])
				]
				ownedSubcomponents.get(1) => [
					"asub2".assertEquals(name)
					//Tests scope_Subcomponent_refined
					assertScope(Aadl2Package::eINSTANCE.subcomponent_Refined, #["asub1"])
				]
				ownedConnections.get(0) => [
					"fgconn1".assertEquals(name)
					//Tests scope_Connection_refined
					assertScope(Aadl2Package::eINSTANCE.connection_Refined, #["fgconn1"])
				]
				ownedConnections.get(1) => [
					"fgconn2".assertEquals(name)
					//Tests scope_Connection_refined
					assertScope(Aadl2Package::eINSTANCE.connection_Refined, #["fgconn1"])
				]
			]
			publicSection.ownedClassifiers.get(6) as SubprogramType => [
				"sub1".assertEquals(name)
				ownedEventDataPorts.head => [
					"edport3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedEventPorts.head => [
					"eport3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedFeatureGroups.head => [
					"fg3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedParameters.head => [
					"param2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedSubprogramAccesses.head => [
					"suba3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedSubprogramGroupAccesses.head => [
					"subga3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedDataAccesses.head => [
					"da3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
				ownedAbstractFeatures.head => [
					"af3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, #[])
				]
			]
			publicSection.ownedClassifiers.get(7) as SubprogramType => [
				"sub2".assertEquals(name)
				val refinedFeatureScopeForSub2 = #["af3", "da3", "edport3", "eport3", "fg3", "param2", "suba3", "subga3"]
				ownedEventDataPorts.head => [
					"edport3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
				]
				ownedEventPorts.head => [
					"eport3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
				]
				ownedFeatureGroups.head => [
					"fg3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
				]
				ownedParameters.head => [
					"param2".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
				]
				ownedSubprogramAccesses.head => [
					"suba3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
				]
				ownedSubprogramGroupAccesses.head => [
					"subga3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
				]
				ownedDataAccesses.head => [
					"da3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
				]
				ownedAbstractFeatures.head => [
					"af3".assertEquals(name)
					//Tests scope_Feature_refined
					assertScope(Aadl2Package::eINSTANCE.feature_Refined, refinedFeatureScopeForSub2)
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
			  
			  abstract implementation a1.i3 (
			    proto1 => abstract a3
			  )
			  end a1.i3;
			  
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
			"pack".assertEquals(name)
			assertNoIssues
			publicSection.ownedClassifiers.get(1) => [
				"a2".assertEquals(name)
				ownedPrototypeBindings.get(0) as ComponentPrototypeBinding => [
					"proto1".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					actuals.head => [
						"a3".assertEquals(subcomponentType.name)
						//Tests scope_ComponentPrototypeActual_subcomponentType
						assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, #["a1", "a1.i1", "a1.i2", "a1.i3", "a2", "a3", "a3.i1",
							"proto1", "proto11", "pack::a1", "pack::a1.i1", "pack::a1.i2", "pack::a1.i3", "pack::a2", "pack::a3", "pack::a3.i1"
						])
						bindings.head => [
							"proto2".assertEquals(formal.name)
							//Tests scope_PrototypeBinding_formal(ComponentPrototypeActual, EReference)
							assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto2"])
						]
					]
				]
				ownedPrototypeBindings.get(1) as FeatureGroupPrototypeBinding => [
					"proto3".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					actual => [
						"fgt1".assertEquals((featureType as NamedElement).name)
						//Tests scope_FeatureGroupPrototypeActual_featureType
						assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, #["fgt1", "fgt2", "proto3", "proto5", "pack::fgt1",
							"pack::fgt2"
						])
						bindings.head => [
							"proto4".assertEquals(formal.name)
							//Tests scope_PrototypeBinding_formal(FeatureGroupPrototypeActual, EReference)
							assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto10", "proto12", "proto4", "proto6"])
						]
					]
				]
			]
			publicSection.ownedClassifiers.get(2) as ComponentImplementation => [
				"a1.i1".assertEquals(name)
				ownedSubcomponents.get(0) => [
					"asub1".assertEquals(name)
					implementationReferences.head => [
						"a3.i1".assertEquals(implementation.name)
						ownedPrototypeBindings.head => [
							"proto2".assertEquals(formal.name)
							//Tests scope_PrototypeBinding_formal(ComponentImplementationReference, EReference)
							assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto2"])
						]
					]
				]
				ownedSubcomponents.get(1) => [
					"asub2".assertEquals(name)
					ownedPrototypeBindings.head => [
						"proto2".assertEquals(formal.name)
						//Tests scope_PrototypeBinding_formal(Subcomponent, EReference)
						assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto2"])
					]
				]
			]
			publicSection.ownedClassifiers.get(3) => [
				"a1.i2".assertEquals(name)
				ownedPrototypeBindings.get(0) as ComponentPrototypeBinding => [
					"proto1".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.head.assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, #["a1", "a1.i1", "a1.i2", "a1.i3", "a2", "a3",
						"a3.i1", "proto1", "proto11", "pack::a1", "pack::a1.i1", "pack::a1.i2", "pack::a1.i3", "pack::a2", "pack::a3", "pack::a3.i1"
					])
				]
				ownedPrototypeBindings.get(1) as FeatureGroupPrototypeBinding => [
					"proto3".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, #["fgt1", "fgt2", "proto3", "proto5", "pack::fgt1",
						"pack::fgt2"
					])
				]
				ownedPrototypeBindings.get(2) as FeatureGroupPrototypeBinding => [
					"proto5".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, #["fgt1", "fgt2", "proto3", "proto5", "pack::fgt1",
						"pack::fgt2"
					])
				]
				ownedPrototypeBindings.get(3) as FeaturePrototypeBinding => [
					"proto8".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					//Tests scope_FeaturePrototypeReference_prototype
					actual.assertScope(Aadl2Package::eINSTANCE.featurePrototypeReference_Prototype, #["proto8", "proto9"])
				]
				ownedPrototypeBindings.get(4) as ComponentPrototypeBinding => [
					"proto11".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.head.assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, #["a1", "a1.i1", "a1.i2", "a1.i3", "a2", "a3",
						"a3.i1", "proto1", "proto11", "pack::a1", "pack::a1.i1", "pack::a1.i2", "pack::a1.i3", "pack::a2", "pack::a3", "pack::a3.i1"
					])
				]
			]
			publicSection.ownedClassifiers.get(4) => [
				"a1.i3".assertEquals(name)
				ownedPrototypeBindings.get(0) as ComponentPrototypeBinding => [
					"proto1".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto1", "proto11", "proto3", "proto5", "proto8", "proto9"])
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.head.assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, #["a1", "a1.i1", "a1.i2", "a1.i3", "a2", "a3",
						"a3.i1", "proto1", "proto11", "pack::a1", "pack::a1.i1", "pack::a1.i2", "pack::a1.i3", "pack::a2", "pack::a3", "pack::a3.i1"
					])
				]
			]
			publicSection.ownedClassifiers.get(8) => [
				"fgt2".assertEquals(name)
				ownedPrototypeBindings.get(0) => [
					"proto4".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto10", "proto12", "proto4", "proto6"])
				]
				ownedPrototypeBindings.get(1) as FeatureGroupPrototypeBinding => [
					"proto6".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto10", "proto12", "proto4", "proto6"])
					//Tests scope_FeatureGroupPrototypeActual_featureType
					actual.assertScope(Aadl2Package::eINSTANCE.featureGroupPrototypeActual_FeatureType, #["fgt1", "fgt2", "proto6", "proto7", "pack::fgt1",
						"pack::fgt2"
					])
				]
				ownedPrototypeBindings.get(2) as FeaturePrototypeBinding => [
					"proto10".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto10", "proto12", "proto4", "proto6"])
					//Tests scope_FeaturePrototypeReference_prototype
					actual.assertScope(Aadl2Package::eINSTANCE.featurePrototypeReference_Prototype, #["proto10", "proto4"])
				]
				ownedPrototypeBindings.get(3) as ComponentPrototypeBinding => [
					"proto12".assertEquals(formal.name)
					//Tests scope_PrototypeBinding_formal(Classifier, EReference)
					assertScope(Aadl2Package::eINSTANCE.prototypeBinding_Formal, #["proto10", "proto12", "proto4", "proto6"])
					//Tests scope_ComponentPrototypeActual_subcomponentType
					actuals.head.assertScope(Aadl2Package::eINSTANCE.componentPrototypeActual_SubcomponentType, #["a1", "a1.i1", "a1.i2", "a1.i3", "a2", "a3",
						"a3.i1", "proto12", "proto13", "pack::a1", "pack::a1.i1", "pack::a1.i2", "pack::a1.i3", "pack::a2", "pack::a3", "pack::a3.i1"
					])
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
	 * scope_MemorySubcomponent_memorySubcomponentType, scope_BusSubcomponent_busSubcomponentType, scope_VirtualBusSubcomponent_virtualBusSubcomponentType,
	 * scope_DataSubcomponent_dataSubcomponentType, scope_DataPort_dataFeatureClassifier, scope_EventDataPort_dataFeatureClassifier,
	 * scope_FeatureGroup_featureType, scope_Parameter_dataFeatureClassifier, scope_SubprogramAccess_subprogramFeatureClassifier,
	 * scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier, scope_BusAccess_busFeatureClassifier, scope_DataAccess_dataFeatureClassifier,
	 * and scope_AbstractFeature_featurePrototype
	 */
	 @Test
	def void testFeaturesAndSubcomponents() {
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
				  renames feature group pack5::fgt5;
				  
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
				  rfgt renames feature group pack5::fgt6;
				  
				  abstract container
				  prototypes
				    aproto1: abstract;
				    sproto1: system;
				    pproto1: process;
				    tgproto1: thread group;
				    tproto1: thread;
				    subproto1: subprogram;
				    subgproto1: subprogram group;
				    procproto1: processor;
				    vpproto1: virtual processor;
				    devproto1: device;
				    mproto1: memory;
				    bproto1: bus;
				    vbproto1: virtual bus;
				    dproto1: data;
				    fgproto1: feature group;
				    fproto1: feature;
				  features
				    dport1: in data port d1;
				    edport1: in event data port d1;
				    fg1: feature group fgt1;
				    suba1: provides subprogram access sub1;
				    subga1: provides subprogram group access subg1;
				    ba1: provides bus access b1;
				    da1: provides data access d1;
				    af1: feature fproto1;
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
				  
				  subprogram subcontainer
				  prototypes
				    aproto2: abstract;
				    sproto2: system;
				    pproto2: process;
				    tgproto2: thread group;
				    tproto2: thread;
				    subproto2: subprogram;
				    subgproto2: subprogram group;
				    procproto2: processor;
				    vpproto2: virtual processor;
				    devproto2: device;
				    mproto2: memory;
				    bproto2: bus;
				    vbproto2: virtual bus;
				    dproto2: data;
				    fgproto2: feature group;
				    fproto2: feature;
				  features
				    param1: in parameter d1;
				  end subcontainer;
				  
				  feature group fgtcontainer
				  prototypes
				    aproto3: abstract;
				    sproto3: system;
				    pproto3: process;
				    tgproto3: thread group;
				    tproto3: thread;
				    subproto3: subprogram;
				    subgproto3: subprogram group;
				    procproto3: processor;
				    vpproto3: virtual processor;
				    devproto3: device;
				    mproto3: memory;
				    bproto3: bus;
				    vbproto3: virtual bus;
				    dproto3: data;
				    fgproto3: feature group;
				    fproto3: feature;
				  features
				    dport2: in data port d1;
				    edport2: in event data port d1;
				    fg2: feature group fgt1;
				    param2: in parameter d1;
				    suba2: provides subprogram access sub1;
				    subga2: provides subprogram group access subg1;
				    ba2: provides bus access b1;
				    da2: provides data access d1;
				    af2: feature fproto3;
				  end fgtcontainer;
				  
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
				  
				  feature group fgt1
				  end fgt1;
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
				  
				  feature group fgt2
				  end fgt2;
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
				  
				  feature group fgt3
				  end fgt3;
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
				  
				  feature group fgt4
				  end fgt4;
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
				  
				  feature group fgt5
				  end fgt5;
				  
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
				  
				  feature group fgt6
				  end fgt6;
				end pack5;
			'''
		)
		suppressSerialization
		testFile("pack2.aadl").resource.contents.head.assertNoIssues
		testFile("pack3.aadl").resource.contents.head.assertNoIssues
		testFile("pack4.aadl").resource.contents.head.assertNoIssues
		testFile("pack5.aadl").resource.contents.head.assertNoIssues
		val pack1 = testFile("pack1.aadl").resource.contents.head as AadlPackage
		pack1.assertNoIssues
		
		pack1 => [
			"pack1".assertEquals(name)
			publicSection.ownedClassifiers.get(0) as AbstractType => [
				"container".assertEquals(name)
				ownedDataPorts.head => [
					"dport1".assertEquals(name)
					//Tests scope_DataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedEventDataPorts.head => [
					"edport1".assertEquals(name)
					//Tests scope_EventDataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.eventDataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedFeatureGroups.head => [
					"fg1".assertEquals(name)
					//Tests scope_FeatureGroup_featureType
					assertScope(Aadl2Package::eINSTANCE.featureGroup_FeatureType, #["fgproto1", "fgt1", "fgt3", "fgt5", "fgtcontainer", "rfgt", "pack1::fgt1",
						"pack1::fgtcontainer", "pack2::fgt2", "pack3::fgt3", "pack4::fgt4", "pack5::fgt5", "pack5::fgt6", "renamed_package::fgt4"
					])
				]
				ownedSubprogramAccesses.head => [
					"suba1".assertEquals(name)
					//Tests scope_SubprogramAccess_subprogramFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramAccess_SubprogramFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rsub", "sub1", "sub1.i", "sub3", "sub3.i", "sub5", "subcontainer", "subproto1", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::sub1", "pack1::sub1.i", "pack1::subcontainer", "pack2::a2",
						"pack2::a2.i", "pack2::sub2", "pack2::sub2.i", "pack3::a3", "pack3::a3.i", "pack3::sub3", "pack3::sub3.i", "pack4::a4", "pack4::a4.i",
						"pack4::sub4", "pack4::sub4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::sub5", "pack5::sub5.i", "pack5::sub6",
						"renamed_package::a4", "renamed_package::a4.i", "renamed_package::sub4", "renamed_package::sub4.i"
					])
				]
				ownedSubprogramGroupAccesses.head => [
					"subga1".assertEquals(name)
					//Tests scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramGroupAccess_SubprogramGroupFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rsubg", "subg1", "subg1.i", "subg3", "subg3.i", "subg5", "subgproto1", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::subg1", "pack1::subg1.i", "pack2::a2", "pack2::a2.i", "pack2::subg2",
						"pack2::subg2.i", "pack3::a3", "pack3::a3.i", "pack3::subg3", "pack3::subg3.i", "pack4::a4", "pack4::a4.i", "pack4::subg4",
						"pack4::subg4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::subg5", "pack5::subg5.i", "pack5::subg6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::subg4", "renamed_package::subg4.i"
					])
				]
				ownedBusAccesses.head => [
					"ba1".assertEquals(name)
					//Tests scope_BusAccess_busFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.busAccess_BusFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "b1", "b1.i", "b3",
						"b3.i", "b5", "bproto1", "container", "container.i", "ra", "rb", "pack1::a1", "pack1::a1.i", "pack1::b1", "pack1::b1.i",
						"pack1::container", "pack1::container.i", "pack2::a2", "pack2::a2.i", "pack2::b2", "pack2::b2.i", "pack3::a3", "pack3::a3.i",
						"pack3::b3", "pack3::b3.i", "pack4::a4", "pack4::a4.i", "pack4::b4", "pack4::b4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::b5", "pack5::b5.i", "pack5::b6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::b4", "renamed_package::b4.i"
					])
				]
				ownedDataAccesses.head => [
					"da1".assertEquals(name)
					//Tests scope_DataAccess_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataAccess_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedAbstractFeatures.head => [
					"af1".assertEquals(name)
					//Tests scope_AbstractFeature_featurePrototype
					assertScope(Aadl2Package::eINSTANCE.abstractFeature_FeaturePrototype, #["fproto1"])
				]
			]
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"container.i".assertEquals(name)
				ownedAbstractSubcomponents.head => [
					"asub".assertEquals(name)
					//Tests scope_AbstractSubcomponent_abstractSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.abstractSubcomponent_AbstractSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "pack1::a1", "pack1::a1.i", "pack1::container", "pack1::container.i", "pack2::a2", "pack2::a2.i",
						"pack3::a3", "pack3::a3.i", "pack4::a4", "pack4::a4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "renamed_package::a4",
						"renamed_package::a4.i"
					])
				]
				ownedSystemSubcomponents.head => [
					"ssub".assertEquals(name)
					//Tests scope_SystemSubcomponent_systemSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.systemSubcomponent_SystemSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "ra", "rs", "s1", "s1.i", "s3", "s3.i", "s5", "sproto1", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::s1", "pack1::s1.i", "pack2::a2", "pack2::a2.i", "pack2::s2", "pack2::s2.i", "pack3::a3", "pack3::a3.i",
						"pack3::s3", "pack3::s3.i", "pack4::a4", "pack4::a4.i", "pack4::s4", "pack4::s4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::s5", "pack5::s5.i", "pack5::s6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::s4", "renamed_package::s4.i"
					])
				]
				ownedProcessSubcomponents.head => [
					"psub".assertEquals(name)
					//Tests scope_ProcessSubcomponent_processSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.processSubcomponent_ProcessSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "p1", "p1.i", "p3", "p3.i", "p5", "pproto1", "ra", "rp", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::p1", "pack1::p1.i", "pack2::a2", "pack2::a2.i", "pack2::p2", "pack2::p2.i", "pack3::a3", "pack3::a3.i",
						"pack3::p3", "pack3::p3.i", "pack4::a4", "pack4::a4.i", "pack4::p4", "pack4::p4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::p5", "pack5::p5.i", "pack5::p6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::p4", "renamed_package::p4.i"
					])
				]
				ownedThreadGroupSubcomponents.head => [
					"tgsub".assertEquals(name)
					//Tests scope_ThreadGroupSubcomponent_threadGroupSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.threadGroupSubcomponent_ThreadGroupSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rtg", "tg1", "tg1.i", "tg3", "tg3.i", "tg5", "tgproto1", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::tg1", "pack1::tg1.i", "pack2::a2", "pack2::a2.i", "pack2::tg2", "pack2::tg2.i",
						"pack3::a3", "pack3::a3.i", "pack3::tg3", "pack3::tg3.i", "pack4::a4", "pack4::a4.i", "pack4::tg4", "pack4::tg4.i", "pack5::a5",
						"pack5::a5.i", "pack5::a6", "pack5::tg5", "pack5::tg5.i", "pack5::tg6", "renamed_package::a4", "renamed_package::a4.i",
						"renamed_package::tg4", "renamed_package::tg4.i"
					])
				]
				ownedThreadSubcomponents.head => [
					"tsub".assertEquals(name)
					//Tests scope_ThreadSubcomponent_threadSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.threadSubcomponent_ThreadSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "ra", "rt", "t1", "t1.i", "t3", "t3.i", "t5", "tproto1", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::t1", "pack1::t1.i", "pack2::a2", "pack2::a2.i", "pack2::t2", "pack2::t2.i", "pack3::a3", "pack3::a3.i",
						"pack3::t3", "pack3::t3.i", "pack4::a4", "pack4::a4.i", "pack4::t4", "pack4::t4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::t5", "pack5::t5.i", "pack5::t6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::t4", "renamed_package::t4.i"
					])
				]
				ownedSubprogramSubcomponents.head => [
					"subsub".assertEquals(name)
					//Tests scope_SubprogramSubcomponent_subprogramSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.subprogramSubcomponent_SubprogramSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rsub", "sub1", "sub1.i", "sub3", "sub3.i", "sub5", "subcontainer", "subproto1", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::sub1", "pack1::sub1.i", "pack1::subcontainer", "pack2::a2",
						"pack2::a2.i", "pack2::sub2", "pack2::sub2.i", "pack3::a3", "pack3::a3.i", "pack3::sub3", "pack3::sub3.i", "pack4::a4", "pack4::a4.i",
						"pack4::sub4", "pack4::sub4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::sub5", "pack5::sub5.i", "pack5::sub6",
						"renamed_package::a4", "renamed_package::a4.i", "renamed_package::sub4", "renamed_package::sub4.i"
					])
				]
				ownedSubprogramGroupSubcomponents.head => [
					"subgsub".assertEquals(name)
					//Tests scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.subprogramGroupSubcomponent_SubprogramGroupSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto1", "container", "container.i", "ra", "rsubg", "subg1", "subg1.i", "subg3", "subg3.i", "subg5", "subgproto1", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::subg1", "pack1::subg1.i", "pack2::a2", "pack2::a2.i", "pack2::subg2",
						"pack2::subg2.i", "pack3::a3", "pack3::a3.i", "pack3::subg3", "pack3::subg3.i", "pack4::a4", "pack4::a4.i", "pack4::subg4",
						"pack4::subg4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::subg5", "pack5::subg5.i", "pack5::subg6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::subg4", "renamed_package::subg4.i"
					])
				]
				ownedProcessorSubcomponents.head => [
					"procsub".assertEquals(name)
					//Tests scope_ProcessorSubcomponent_processorSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.processorSubcomponent_ProcessorSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "proc1", "proc1.i", "proc3", "proc3.i", "proc5", "procproto1", "ra", "rproc", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::proc1", "pack1::proc1.i", "pack2::a2", "pack2::a2.i", "pack2::proc2",
						"pack2::proc2.i", "pack3::a3", "pack3::a3.i", "pack3::proc3", "pack3::proc3.i", "pack4::a4", "pack4::a4.i", "pack4::proc4",
						"pack4::proc4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::proc5", "pack5::proc5.i", "pack5::proc6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::proc4", "renamed_package::proc4.i"
					])
				]
				ownedVirtualProcessorSubcomponents.head => [
					"vpsub".assertEquals(name)
					//Tests scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.virtualProcessorSubcomponent_VirtualProcessorSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5",
						"aproto1", "container", "container.i", "ra", "rvp", "vp1", "vp1.i", "vp3", "vp3.i", "vp5", "vpproto1", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::vp1", "pack1::vp1.i", "pack2::a2", "pack2::a2.i", "pack2::vp2", "pack2::vp2.i",
						"pack3::a3", "pack3::a3.i", "pack3::vp3", "pack3::vp3.i", "pack4::a4", "pack4::a4.i", "pack4::vp4", "pack4::vp4.i", "pack5::a5",
						"pack5::a5.i", "pack5::a6", "pack5::vp5", "pack5::vp5.i", "pack5::vp6", "renamed_package::a4", "renamed_package::a4.i",
						"renamed_package::vp4", "renamed_package::vp4.i"
					])
				]
				ownedDeviceSubcomponents.head => [
					"devsub".assertEquals(name)
					//Tests scope_DeviceSubcomponent_deviceSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.deviceSubcomponent_DeviceSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "dev1", "dev1.i", "dev3", "dev3.i", "dev5", "devproto1", "ra", "rdev", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::dev1", "pack1::dev1.i", "pack2::a2", "pack2::a2.i", "pack2::dev2", "pack2::dev2.i", "pack3::a3",
						"pack3::a3.i", "pack3::dev3", "pack3::dev3.i", "pack4::a4", "pack4::a4.i", "pack4::dev4", "pack4::dev4.i", "pack5::a5", "pack5::a5.i",
						"pack5::a6", "pack5::dev5", "pack5::dev5.i", "pack5::dev6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::dev4",
						"renamed_package::dev4.i"
					])
				]
				ownedMemorySubcomponents.head => [
					"msub".assertEquals(name)
					//Tests scope_MemorySubcomponent_memorySubcomponentType
					assertScope(Aadl2Package::eINSTANCE.memorySubcomponent_MemorySubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "m1", "m1.i", "m3", "m3.i", "m5", "mproto1", "ra", "rm", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::m1", "pack1::m1.i", "pack2::a2", "pack2::a2.i", "pack2::m2", "pack2::m2.i", "pack3::a3",
						"pack3::a3.i", "pack3::m3", "pack3::m3.i", "pack4::a4", "pack4::a4.i", "pack4::m4", "pack4::m4.i", "pack5::a5", "pack5::a5.i",
						"pack5::a6", "pack5::m5", "pack5::m5.i", "pack5::m6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::m4",
						"renamed_package::m4.i"
					])
				]
				ownedBusSubcomponents.head => [
					"bsub".assertEquals(name)
					//Tests scope_BusSubcomponent_busSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.busSubcomponent_BusSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "b1", "b1.i", "b3",
						"b3.i", "b5", "bproto1", "container", "container.i", "ra", "rb", "pack1::a1", "pack1::a1.i", "pack1::b1", "pack1::b1.i",
						"pack1::container", "pack1::container.i", "pack2::a2", "pack2::a2.i", "pack2::b2", "pack2::b2.i", "pack3::a3", "pack3::a3.i",
						"pack3::b3", "pack3::b3.i", "pack4::a4", "pack4::a4.i", "pack4::b4", "pack4::b4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::b5", "pack5::b5.i", "pack5::b6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::b4", "renamed_package::b4.i"
					])
				]
				ownedVirtualBusSubcomponents.head => [
					"vbsub".assertEquals(name)
					//Tests scope_VirtualBusSubcomponent_virtualBusSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.virtualBusSubcomponent_VirtualBusSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1",
						"container", "container.i", "ra", "rvb", "vb1", "vb1.i", "vb3", "vb3.i", "vb5", "vbproto1", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::vb1", "pack1::vb1.i", "pack2::a2", "pack2::a2.i", "pack2::vb2", "pack2::vb2.i",
						"pack3::a3", "pack3::a3.i", "pack3::vb3", "pack3::vb3.i", "pack4::a4", "pack4::a4.i", "pack4::vb4", "pack4::vb4.i", "pack5::a5",
						"pack5::a5.i", "pack5::a6", "pack5::vb5", "pack5::vb5.i", "pack5::vb6", "renamed_package::a4", "renamed_package::a4.i",
						"renamed_package::vb4", "renamed_package::vb4.i"
					])
				]
				ownedDataSubcomponents.head => [
					"dsub".assertEquals(name)
					//Tests scope_DataSubcomponent_dataSubcomponentType
					assertScope(Aadl2Package::eINSTANCE.dataSubcomponent_DataSubcomponentType, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto1", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto1", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
			]
			publicSection.ownedClassifiers.get(2) as SubprogramType => [
				"subcontainer".assertEquals(name)
				ownedParameters.head => [
					"param1".assertEquals(name)
					//Tests scope_Parameter_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.parameter_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto2", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto2", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
			]
			publicSection.ownedClassifiers.get(3) as FeatureGroupType => [
				"fgtcontainer".assertEquals(name)
				ownedDataPorts.head => [
					"dport2".assertEquals(name)
					//Tests scope_DataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedEventDataPorts.head => [
					"edport2".assertEquals(name)
					//Tests scope_EventDataPort_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.eventDataPort_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedFeatureGroups.head => [
					"fg2".assertEquals(name)
					//Tests scope_FeatureGroup_featureType
					assertScope(Aadl2Package::eINSTANCE.featureGroup_FeatureType, #["fgproto3", "fgt1", "fgt3", "fgt5", "fgtcontainer", "rfgt", "pack1::fgt1",
						"pack1::fgtcontainer", "pack2::fgt2", "pack3::fgt3", "pack4::fgt4", "pack5::fgt5", "pack5::fgt6", "renamed_package::fgt4"
					])
				]
				ownedParameters.head => [
					"param2".assertEquals(name)
					//Tests scope_Parameter_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.parameter_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedSubprogramAccesses.head => [
					"suba2".assertEquals(name)
					//Tests scope_SubprogramAccess_subprogramFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramAccess_SubprogramFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3",
						"container", "container.i", "ra", "rsub", "sub1", "sub1.i", "sub3", "sub3.i", "sub5", "subcontainer", "subproto3", "pack1::a1",
						"pack1::a1.i", "pack1::container", "pack1::container.i", "pack1::sub1", "pack1::sub1.i", "pack1::subcontainer", "pack2::a2",
						"pack2::a2.i", "pack2::sub2", "pack2::sub2.i", "pack3::a3", "pack3::a3.i", "pack3::sub3", "pack3::sub3.i", "pack4::a4", "pack4::a4.i",
						"pack4::sub4", "pack4::sub4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::sub5", "pack5::sub5.i", "pack5::sub6",
						"renamed_package::a4", "renamed_package::a4.i", "renamed_package::sub4", "renamed_package::sub4.i"
					])
				]
				ownedSubprogramGroupAccesses.head => [
					"subga2".assertEquals(name)
					//Tests scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.subprogramGroupAccess_SubprogramGroupFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3",
						"container", "container.i", "ra", "rsubg", "subg1", "subg1.i", "subg3", "subg3.i", "subg5", "subgproto3", "pack1::a1", "pack1::a1.i",
						"pack1::container", "pack1::container.i", "pack1::subg1", "pack1::subg1.i", "pack2::a2", "pack2::a2.i", "pack2::subg2",
						"pack2::subg2.i", "pack3::a3", "pack3::a3.i", "pack3::subg3", "pack3::subg3.i", "pack4::a4", "pack4::a4.i", "pack4::subg4",
						"pack4::subg4.i", "pack5::a5", "pack5::a5.i", "pack5::a6", "pack5::subg5", "pack5::subg5.i", "pack5::subg6", "renamed_package::a4",
						"renamed_package::a4.i", "renamed_package::subg4", "renamed_package::subg4.i"
					])
				]
				ownedBusAccesses.head => [
					"ba2".assertEquals(name)
					//Tests scope_BusAccess_busFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.busAccess_BusFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "b1", "b1.i", "b3",
						"b3.i", "b5", "bproto3", "container", "container.i", "ra", "rb", "pack1::a1", "pack1::a1.i", "pack1::b1", "pack1::b1.i",
						"pack1::container", "pack1::container.i", "pack2::a2", "pack2::a2.i", "pack2::b2", "pack2::b2.i", "pack3::a3", "pack3::a3.i",
						"pack3::b3", "pack3::b3.i", "pack4::a4", "pack4::a4.i", "pack4::b4", "pack4::b4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::b5", "pack5::b5.i", "pack5::b6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::b4", "renamed_package::b4.i"
					])
				]
				ownedDataAccesses.head => [
					"da2".assertEquals(name)
					//Tests scope_DataAccess_dataFeatureClassifier
					assertScope(Aadl2Package::eINSTANCE.dataAccess_DataFeatureClassifier, #["a1", "a1.i", "a3", "a3.i", "a5", "aproto3", "container",
						"container.i", "d1", "d1.i", "d3", "d3.i", "d5", "dproto3", "ra", "rd", "pack1::a1", "pack1::a1.i", "pack1::container",
						"pack1::container.i", "pack1::d1", "pack1::d1.i", "pack2::a2", "pack2::a2.i", "pack2::d2", "pack2::d2.i", "pack3::a3", "pack3::a3.i",
						"pack3::d3", "pack3::d3.i", "pack4::a4", "pack4::a4.i", "pack4::d4", "pack4::d4.i", "pack5::a5", "pack5::a5.i", "pack5::a6",
						"pack5::d5", "pack5::d5.i", "pack5::d6", "renamed_package::a4", "renamed_package::a4.i", "renamed_package::d4", "renamed_package::d4.i"
					])
				]
				ownedAbstractFeatures.head => [
					"af2".assertEquals(name)
					//Tests scope_AbstractFeature_featurePrototype
					assertScope(Aadl2Package::eINSTANCE.abstractFeature_FeaturePrototype, #["fproto3"])
				]
			]
		]
	}
	
	/*
	 * Tests the reference ArraySize_SizeProperty used in the parser rule ArraySize.
	 * The scope for this rule is automatically provided, so there is no scoping method to test here.
	 */
	@Test
	def void testArraySizeProperty() {
		createFiles(
			"pack.aadl" -> '''
				package pack
				public
				  with ps;
				  
				  abstract a
				  features
				    af: feature[ps::def];
				  properties
				    ps::def => 4;
				  end a;
				end pack;
			''',
			"ps.aadl" -> '''
				property set ps is
				  def: aadlinteger applies to (all);
				  const: constant aadlinteger => 10;
				end ps;
			'''
		)
		suppressSerialization
		testFile("ps.aadl").resource.contents.head.assertNoIssues
		val pack = testFile("pack.aadl").resource.contents.head as AadlPackage
		pack.assertNoIssues
		
		pack => [
			"pack".assertEquals(name)
			publicSection.ownedClassifiers.head as ComponentType => [
				"a".assertEquals(name)
				ownedAbstractFeatures.head => [
					"af".assertEquals(name)
					arrayDimensions.head.size => [
						"ps::def".assertEquals((sizeProperty as NamedElement).qualifiedName())
						//Tests the reference ArraySize_SizeProperty
						assertScope(Aadl2Package::eINSTANCE.arraySize_SizeProperty, #["Acceptable_Array_Size", "Access_Right", "Access_Time",
							"Activate_Deadline", "Activate_Entrypoint", "Activate_Entrypoint_Call_Sequence", "Activate_Entrypoint_Source_Text",
							"Activate_Execution_Time", "Active_Thread_Handling_Protocol", "Active_Thread_Queue_Handling_Protocol", "Actual_Connection_Binding",
							"Actual_Function_Binding", "Actual_Latency", "Actual_Memory_Binding", "Actual_Processor_Binding", "Actual_Subprogram_Call",
							"Actual_Subprogram_Call_Binding", "Allowed_Connection_Binding", "Allowed_Connection_Binding_Class", "Allowed_Connection_Type",
							"Allowed_Dispatch_Protocol", "Allowed_Memory_Binding", "Allowed_Memory_Binding_Class", "Allowed_Message_Size", "Allowed_Period",
							"Allowed_Physical_Access", "Allowed_Physical_Access_Class", "Allowed_Processor_Binding", "Allowed_Processor_Binding_Class",
							"Allowed_Subprogram_Call", "Allowed_Subprogram_Call_Binding", "Assign_Time", "Base_Address", "Byte_Count",
							"Classifier_Matching_Rule", "Classifier_Substitution_Rule", "Client_Subprogram_Execution_Time", "Clock_Jitter", "Clock_Period",
							"Clock_Period_Range", "Code_Size", "Collocated", "Compute_Deadline", "Compute_Entrypoint", "Compute_Entrypoint_Call_Sequence",
							"Compute_Entrypoint_Source_Text", "Compute_Execution_Time", "Concurrency_Control_Protocol", "Connection_Pattern", "Connection_Set",
							"Criticality", "Data_Rate", "Data_Size", "Deactivate_Dealing", "Deactivate_Entrypoint", "Deactivate_Entrypoint_Call_Sequence",
							"Deactivate_Entrypoint_Source_Text", "Deactivate_Execution_Time", "Deactivation_Policy", "Deadline", "Dequeue_Protocol",
							"Dequeued_Items", "Device_Driver", "Device_Register_Address", "Dispatch_Able", "Dispatch_Jitter", "Dispatch_Offset",
							"Dispatch_Protocol", "Dispatch_Trigger", "Execution_Time", "Fan_Out_Policy", "Finalize_Deadline", "Finalize_Entrypoint",
							"Finalize_Entrypoint_Call_Sequence", "Finalize_Entrypoint_Source_Text", "Finalize_Execution_Time", "First_Dispatch_Time",
							"Frame_Period", "Hardware_Description_Source_Text", "Hardware_Source_Language", "Heap_Size", "Implemented_As",
							"Initialize_Deadline", "Initialize_Entrypoint", "Initialize_Entrypoint_Call_Sequence", "Initialize_Entrypoint_Source_Text",
							"Initialize_Execution_Time", "Input_Rate", "Input_Time", "Latency", "Load_Deadline", "Load_Time", "Max_Aadlinteger",
							"Max_Base_Address", "Max_Byte_Count", "Max_Memory_Size", "Max_Queue_Size", "Max_Target_Integer", "Max_Thread_Limit", "Max_Time",
							"Max_Urgency", "Max_Volume", "Max_Word_Space", "Memory_Protocol", "Memory_Size", "Mode_Transition_Response", "Not_Collocated",
							"Output_Rate", "Output_Time", "Overflow_Handling_Protocol", "POSIX_Scheduling_Policy", "Period", "Preemptive_Scheduler",
							"Priority", "Priority_Map", "Priority_Range", "Process_Swap_Execution_Time", "Processor_Capacity", "Prototype_Substitution_Rule",
							"Provided_Connection_Quality_Of_Service", "Provided_Virtual_Bus_Class", "Queue_Processing_Protocol", "Queue_Size", "Read_Time",
							"Recover_Deadline", "Recover_Entrypoint", "Recover_Entrypoint_Call_Sequence", "Recover_Entrypoint_Source_Text",
							"Recover_Execution_Time", "Reference_Processor", "Required_Connection", "Required_Connection_Quality_Of_Service",
							"Required_Virtual_Bus_Class", "Resumption_Policy", "Runtime_Protection", "Runtime_Protection_Support", "Scheduler_Quantum",
							"Scheduling_Protocol", "Slot_Time", "Source_Language", "Source_Name", "Source_Text", "Stack_Size", "Startup_Deadline",
							"Startup_Execution_Time", "Subprogram_Call_Rate", "Subprogram_Call_Type", "Supported_Classifier_Complement_Matches",
							"Supported_Classifier_Equivalence_Matches", "Supported_Classifier_Subset_Matches", "Supported_Source_Language",
							"Supported_Type_Conversions", "Synchronized_Component", "Thread_Limit", "Thread_Swap_Execution_Time", "Time_Slot", "Timing",
							"Transmission_Time", "Transmission_Type", "Type_Source_Name", "Urgency", "Word_Size", "Word_Space", "Write_Time", "ps::const",
							"ps::def", "AADL_Project::Max_Aadlinteger", "AADL_Project::Max_Base_Address", "AADL_Project::Max_Byte_Count",
							"AADL_Project::Max_Memory_Size", "AADL_Project::Max_Queue_Size", "AADL_Project::Max_Target_Integer",
							"AADL_Project::Max_Thread_Limit", "AADL_Project::Max_Time", "AADL_Project::Max_Urgency", "AADL_Project::Max_Volume",
							"AADL_Project::Max_Word_Space", "AADL_Project::Supported_Classifier_Complement_Matches",
							"AADL_Project::Supported_Classifier_Equivalence_Matches", "AADL_Project::Supported_Classifier_Subset_Matches",
							"AADL_Project::Supported_Type_Conversions", "Communication_Properties::Actual_Latency",
							"Communication_Properties::Connection_Pattern", "Communication_Properties::Connection_Set", "Communication_Properties::Data_Rate",
							"Communication_Properties::Fan_Out_Policy", "Communication_Properties::Input_Rate", "Communication_Properties::Input_Time",
							"Communication_Properties::Latency", "Communication_Properties::Output_Rate", "Communication_Properties::Output_Time",
							"Communication_Properties::Overflow_Handling_Protocol", "Communication_Properties::Queue_Processing_Protocol",
							"Communication_Properties::Queue_Size", "Communication_Properties::Required_Connection",
							"Communication_Properties::Subprogram_Call_Rate", "Communication_Properties::Timing",
							"Communication_Properties::Transmission_Time", "Communication_Properties::Transmission_Type",
							"Deployment_Properties::Actual_Connection_Binding", "Deployment_Properties::Actual_Function_Binding",
							"Deployment_Properties::Actual_Memory_Binding", "Deployment_Properties::Actual_Processor_Binding",
							"Deployment_Properties::Actual_Subprogram_Call", "Deployment_Properties::Actual_Subprogram_Call_Binding",
							"Deployment_Properties::Allowed_Connection_Binding", "Deployment_Properties::Allowed_Connection_Binding_Class",
							"Deployment_Properties::Allowed_Connection_Type", "Deployment_Properties::Allowed_Dispatch_Protocol",
							"Deployment_Properties::Allowed_Memory_Binding", "Deployment_Properties::Allowed_Memory_Binding_Class",
							"Deployment_Properties::Allowed_Period", "Deployment_Properties::Allowed_Physical_Access",
							"Deployment_Properties::Allowed_Physical_Access_Class", "Deployment_Properties::Allowed_Processor_Binding",
							"Deployment_Properties::Allowed_Processor_Binding_Class", "Deployment_Properties::Allowed_Subprogram_Call",
							"Deployment_Properties::Allowed_Subprogram_Call_Binding", "Deployment_Properties::Collocated",
							"Deployment_Properties::Memory_Protocol", "Deployment_Properties::Not_Collocated", "Deployment_Properties::Preemptive_Scheduler",
							"Deployment_Properties::Priority_Map", "Deployment_Properties::Priority_Range",
							"Deployment_Properties::Provided_Connection_Quality_Of_Service", "Deployment_Properties::Provided_Virtual_Bus_Class",
							"Deployment_Properties::Required_Connection_Quality_Of_Service", "Deployment_Properties::Required_Virtual_Bus_Class",
							"Deployment_Properties::Runtime_Protection_Support", "Deployment_Properties::Scheduling_Protocol",
							"Deployment_Properties::Thread_Limit", "Memory_Properties::Access_Right", "Memory_Properties::Access_Time",
							"Memory_Properties::Allowed_Message_Size", "Memory_Properties::Assign_Time", "Memory_Properties::Base_Address",
							"Memory_Properties::Byte_Count", "Memory_Properties::Code_Size", "Memory_Properties::Data_Size",
							"Memory_Properties::Device_Register_Address", "Memory_Properties::Heap_Size", "Memory_Properties::Memory_Size",
							"Memory_Properties::Read_Time", "Memory_Properties::Stack_Size", "Memory_Properties::Word_Size", "Memory_Properties::Word_Space",
							"Memory_Properties::Write_Time", "Modeling_Properties::Acceptable_Array_Size", "Modeling_Properties::Classifier_Matching_Rule",
							"Modeling_Properties::Classifier_Substitution_Rule", "Modeling_Properties::Implemented_As",
							"Modeling_Properties::Prototype_Substitution_Rule", "Programming_Properties::Activate_Entrypoint",
							"Programming_Properties::Activate_Entrypoint_Call_Sequence", "Programming_Properties::Activate_Entrypoint_Source_Text",
							"Programming_Properties::Compute_Entrypoint", "Programming_Properties::Compute_Entrypoint_Call_Sequence",
							"Programming_Properties::Compute_Entrypoint_Source_Text", "Programming_Properties::Deactivate_Entrypoint",
							"Programming_Properties::Deactivate_Entrypoint_Call_Sequence", "Programming_Properties::Deactivate_Entrypoint_Source_Text",
							"Programming_Properties::Device_Driver", "Programming_Properties::Finalize_Entrypoint",
							"Programming_Properties::Finalize_Entrypoint_Call_Sequence", "Programming_Properties::Finalize_Entrypoint_Source_Text",
							"Programming_Properties::Hardware_Description_Source_Text", "Programming_Properties::Hardware_Source_Language",
							"Programming_Properties::Initialize_Entrypoint", "Programming_Properties::Initialize_Entrypoint_Call_Sequence",
							"Programming_Properties::Initialize_Entrypoint_Source_Text", "Programming_Properties::Recover_Entrypoint",
							"Programming_Properties::Recover_Entrypoint_Call_Sequence", "Programming_Properties::Recover_Entrypoint_Source_Text",
							"Programming_Properties::Source_Language", "Programming_Properties::Source_Name", "Programming_Properties::Source_Text",
							"Programming_Properties::Supported_Source_Language", "Programming_Properties::Type_Source_Name",
							"Thread_Properties::Active_Thread_Handling_Protocol", "Thread_Properties::Active_Thread_Queue_Handling_Protocol",
							"Thread_Properties::Concurrency_Control_Protocol", "Thread_Properties::Criticality", "Thread_Properties::Deactivation_Policy",
							"Thread_Properties::Dequeue_Protocol", "Thread_Properties::Dequeued_Items", "Thread_Properties::Dispatch_Able",
							"Thread_Properties::Dispatch_Protocol", "Thread_Properties::Dispatch_Trigger", "Thread_Properties::Mode_Transition_Response",
							"Thread_Properties::POSIX_Scheduling_Policy", "Thread_Properties::Priority", "Thread_Properties::Resumption_Policy",
							"Thread_Properties::Runtime_Protection", "Thread_Properties::Subprogram_Call_Type", "Thread_Properties::Synchronized_Component",
							"Thread_Properties::Time_Slot", "Thread_Properties::Urgency", "Timing_Properties::Activate_Deadline",
							"Timing_Properties::Activate_Execution_Time", "Timing_Properties::Client_Subprogram_Execution_Time",
							"Timing_Properties::Clock_Jitter", "Timing_Properties::Clock_Period", "Timing_Properties::Clock_Period_Range",
							"Timing_Properties::Compute_Deadline", "Timing_Properties::Compute_Execution_Time", "Timing_Properties::Deactivate_Dealing",
							"Timing_Properties::Deactivate_Execution_Time", "Timing_Properties::Deadline", "Timing_Properties::Dispatch_Jitter",
							"Timing_Properties::Dispatch_Offset", "Timing_Properties::Execution_Time", "Timing_Properties::Finalize_Deadline",
							"Timing_Properties::Finalize_Execution_Time", "Timing_Properties::First_Dispatch_Time", "Timing_Properties::Frame_Period",
							"Timing_Properties::Initialize_Deadline", "Timing_Properties::Initialize_Execution_Time", "Timing_Properties::Load_Deadline",
							"Timing_Properties::Load_Time", "Timing_Properties::Period", "Timing_Properties::Process_Swap_Execution_Time",
							"Timing_Properties::Processor_Capacity", "Timing_Properties::Recover_Deadline", "Timing_Properties::Recover_Execution_Time",
							"Timing_Properties::Reference_Processor", "Timing_Properties::Scheduler_Quantum", "Timing_Properties::Slot_Time",
							"Timing_Properties::Startup_Deadline", "Timing_Properties::Startup_Execution_Time", "Timing_Properties::Thread_Swap_Execution_Time"
						])
					]
				]
			]
		]
	}
	
	//Tests scope_ConnectedElement_context and scope_ConnectedElement_connectionEnd
	@Test
	def void testConnections() {
		('''
			package pack
			public
			  abstract a1
			  prototypes
			    fgproto1: feature group fgt1;
			    aproto1: abstract a2.i1;
			    subpproto1: subprogram subp1;
			    subpgproto1: subprogram group subpg1;
			  features
			  	ep1: in event port;
			    dp1: in data port a2.i1;
			    dp2: in data port aproto1;
			    edp1: in event data port;
			    fg1: feature group fgt1;
			    fg4: feature group fgproto1;
			    af1: feature;
			    ba1: provides bus access;
			    da1: provides data access;
			  end a1;
			  
			  abstract implementation a1.i1
			  subcomponents
			    asub1: abstract a2.i1;
			    asub2: abstract aproto1;
			    bsub1: bus;
			    dsub1: data;
			    subpgsub1: subprogram group subpg1;
			    subpgsub2: subprogram group subpg1 (subpproto4 => subprogram subp1.i2);
			    subpgsub3: subprogram group subpgproto1;
			    subpsub1: subprogram subp1;
			    subpsub2: subprogram subpproto1;
			  internal features
			    eds1: event data;
			  processor features
			    pp1: port;
			    sp1: subprogram;
			  calls sequence1: {
			    call1: subprogram subp1;
			    call13: subprogram subpgsub1.subpa5;
			    call14: subprogram subpgsub2.subpa6;
«««			    call15: subprogram subpgsub3.subpa5;
			  };
			  connections
			    conn1: feature group asub1.fg2 <-> asub1.fg2;
			    conn2: feature group asub2.fg2 <-> asub1.fg2;
			    conn3: feature group fg1 <-> asub1.fg2;
			    conn4: feature group fg1.fg3 <-> asub1.fg2;
			    conn5: feature group fg4.fg3 <-> asub1.fg2;
			    conn6: port dp1.dsub2 -> asub1.dp2;
			    conn7: port dp2.dsub2 -> asub1.dp2;
			    conn8: port processor.pp1 -> asub1.dp2;
			    conn9: port self.eds1 -> asub1.dp2;
			    conn10: feature subpsub1.param1 <-> asub1.af3;
			    conn11: feature subpsub2.param1 <-> asub1.af3;
			    conn12: subprogram access processor.sp1 <-> asub1.subpa1;
			    conn24: parameter dsub1 -> call13.param1;
			    conn25: parameter dsub1 -> call14.param1;
«««			    conn26: parameter dsub1 -> call15.param1;
			  end a1.i1;
			  
			  abstract a2
			  features
			    fg2: feature group;
			    dp2: in data port;
			    af3: feature;
			    ba3: provides bus access;
			    da3: provides data access;
			    subpa1: requires subprogram access;
			    ep3: in event port;
			    edp3: in event data port;
			  end a2;
			  
			  abstract implementation a2.i1
			  subcomponents
			    dsub2: data;
			    bsub2: bus;
			    subpgsub2: subprogram group;
			    subpsub2: subprogram;
			  internal features
			    eds1: event data;
			  processor features
			    pp1: port;
			    sp1: subprogram;
			  end a2.i1;
			  
			  subprogram subp1
			  prototypes
			    subpproto2: subprogram subp1.i2;
			    fgproto1: feature group fgt2;
			    subpgproto1: subprogram group subpg1;
			  features
			    param1: in parameter;
			    af4: feature;
			    fg4: feature group fgt2;
			    fg5: feature group fgproto1;
			    subpa2: requires subprogram access subp1.i2;
			    subpa3: requires subprogram access subpproto2;
			    subpga1: requires subprogram group access subpg1;
			    subpga2: requires subprogram group access subpgproto1;
			    da4: requires data access;
			    ep4: in event port;
			    edp4: in event data port;
			  end subp1;
			  
			  subprogram implementation subp1.i1
			  subcomponents
			    subpsub3: subprogram subp1.i2;
			    subpsub4: subprogram subpproto2;
			  calls sequence2: {
			    call2: subprogram subp1.i2;
			    call3: subprogram subpsub3;
			    call4: subprogram subpsub4;
			    call5: subprogram subpproto2;
			    call6: subprogram subpa2;
			    call7: subprogram subpa3;
			    call8: subprogram subp1.subpa3;
			    call9: subprogram fg4.subpa4;
«««			    call10: subprogram fg5.subpa4;
«««				call11: subprogram subpga1.subpa5;
«««				call12: subprogram subpga2.subpa5;
			  };
			  connections
			    conn13: parameter param1 -> call2.param1;
			    conn14: parameter param1 -> call3.param1;
			    conn15: parameter param1 -> call4.param1;
			    conn16: parameter param1 -> call5.param1;
			    conn17: parameter param1 -> call6.param1;
			    conn18: parameter param1 -> call7.param1;
			    conn19: parameter param1 -> call8.param1;
			    conn20: parameter param1 -> call9.param1;
«««			    conn21: parameter param1 -> call10.param1;
«««				conn22: parameter param1 -> call11.param1;
«««				conn23: parameter param1 -> call12.param1;
			  end subp1.i1;
			  
			  subprogram implementation subp1.i2
			  subcomponents
			    dsub3: data;
			    subpsub3: subprogram;
			  internal features
			    eds2: event data;
			  processor features
			    pp2: port;
			    sp2: subprogram;
			  end subp1.i2;
			  
			  feature group fgt1
			  features
			    fg3: feature group;
			    af2: feature;
			    param2: in parameter;
			    ba2: provides bus access;
			    da2: provides data access;
			    ep2: in event port;
			    dp2: in data port;
			    edp2: in event data port;
			  end fgt1;
			  
			  feature group fgt2
			  prototypes
			    subpproto3: subprogram subp1.i2;
			  features
			    subpa4: requires subprogram access subpproto3;
			  end fgt2;
			  
			  subprogram group subpg1
			  prototypes
			    subpproto3: subprogram subp1.i2;
			    subpproto4: subprogram;
			  features
			    subpa5: provides subprogram access subpproto3;
			    subpa6: provides subprogram access subpproto4;
			  end subpg1;
			end pack;
		'''.parse as AadlPackage) => [
			assertNoIssues
			"pack".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as ComponentImplementation => [
				"a1.i1".assertEquals(name)
				ownedFeatureGroupConnections.get(0) => [
					"conn1".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3", "eds1",
						"ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedFeatureGroupConnections.get(1) => [
					"conn2".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3", "eds1",
						"ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedFeatureGroupConnections.get(2) => [
					"conn3".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1",
						"eds1", "ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedFeatureGroupConnections.get(3) => [
					"conn4".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af2", "ba2", "da2", "dp2", "edp2", "ep2", "fg3", "param2"])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedFeatureGroupConnections.get(4) => [
					"conn5".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af2", "ba2", "da2", "dp2", "edp2", "ep2", "fg3", "param2"])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedPortConnections.get(0) => [
					"conn6".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3", "eds1",
						"ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedPortConnections.get(1) => [
					"conn7".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3", "eds1",
						"ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedPortConnections.get(2) => [
					"conn8".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1",
						"eds1", "ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedPortConnections.get(3) => [
					"conn9".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1",
						"eds1", "ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedFeatureConnections.get(0) => [
					"conn10".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedFeatureConnections.get(1) => [
					"conn11".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedAccessConnections.head => [
					"conn12".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1",
						"eds1", "ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af3", "ba3", "bsub2", "da3", "dp2", "dsub2", "edp3",
						"eds1", "ep3", "fg2", "pp1", "sp1", "subpa1", "subpgsub2", "subpsub2"
					])
				]
				ownedParameterConnections.get(0) => [
					"conn24".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1",
						"eds1", "ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(1) => [
					"conn25".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1", "eds1",
						"ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af1", "ba1", "bsub1", "da1", "dp1", "dp2", "dsub1", "edp1",
						"eds1", "ep1", "fg1", "fg4", "pp1", "sp1", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["asub1", "asub2", "bsub1", "call1", "call13", "call14", "dp1",
						"dp2", "dsub1", "edp1", "fg1", "fg4", "subpgsub1", "subpgsub2", "subpgsub3", "subpsub1", "subpsub2"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
			]
			publicSection.ownedClassifiers.get(5) as ComponentImplementation => [
				"subp1.i1".assertEquals(name)
				ownedParameterConnections.get(0) => [
					"conn13".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(1) => [
					"conn14".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(2) => [
					"conn15".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(3) => [
					"conn16".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(4) => [
					"conn17".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(5) => [
					"conn18".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(6) => [
					"conn19".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
				ownedParameterConnections.get(7) => [
					"conn20".assertEquals(name)
					//Tests scope_ConnectedElement_connectionEnd(Connection, EReference)
					assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					source.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "edp4", "ep4", "fg4", "fg5", "param1", "subpa2",
						"subpa3", "subpga1", "subpga2", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_context
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_Context, #["call2", "call3", "call4", "call5", "call6", "call7", "call8",
						"call9", "edp4", "fg4", "fg5", "param1", "subpsub3", "subpsub4"
					])
					//Tests scope_ConnectedElement_connectionEnd(ConnectedElement, EReference)
					destination.assertScope(Aadl2Package::eINSTANCE.connectedElement_ConnectionEnd, #["af4", "da4", "dsub3", "edp4", "eds2", "ep4", "fg4",
						"fg5", "param1", "pp2", "sp2", "subpa2", "subpa3", "subpga1", "subpga2", "subpsub3"
					])
				]
			]
		]
	}
	
	//Tests scope_ModalPath_inModeOrTransition
	@Test
	def void test_scope_ModalPath_inModeOrTransition() {
		('''
			package pack
			public
			  abstract a1
			  features
			    fg1: feature group;
			    ep1: in event port;
			    da1: provides data access;
			  end a1;
			  
			  abstract implementation a1.i
			  subcomponents
			    asub1: abstract a1;
			    asub2: abstract a2;
			    asub3: abstract a2;
			  connections
			  	portconn1: port ep1 -> asub1.ep1 in modes (m1, m2, mt1, mt2);
			  	portconn2: port asub2.ep2 -> asub3.ep3;
			  	aconn1: data access da1 -> asub1.da1 in modes (m1, m2, mt1, mt2);
			    fgconn1: feature group fg1 <-> fg1 in modes (m1, m2, mt1, mt2);
			    fconn1: feature fg1 -> asub1.fg1 in modes (m1, m2, mt1, mt2);
			    paramconn1: parameter da1 -> da1 in modes (m1, m2, mt1, mt2);
			  flows
			    ete1: end to end flow asub2.fsource1 -> portconn2 -> asub3.fsink1 in modes (m1, m2, mt1, mt2);
			  modes
			    m1: initial mode;
			    m2: mode;
			    m3: mode;
			    m4: mode;
			    mt1: m1 -[ep1]-> m2;
			    mt2: m2 -[ep1]-> m3;
			    mt3: m3 -[ep1]-> m4;
			    mt4: m4 -[ep1]-> m1;
			  end a1.i;
			  
			  abstract a2
			  features
			    ep2: out event port;
			    ep3: in event port;
			  flows
			    fsource1: flow source ep2 in modes (m5, m6, mt5, mt6);
			    fsink1: flow sink ep3 in modes (m5, m6, mt5, mt6);
			  modes
			    m5: initial mode;
			    m6: mode;
			    m7: mode;
			    m8: mode;
			    mt5: m5 -[ep3]-> m6;
			    mt6: m6 -[ep3]-> m7;
			    mt7: m7 -[ep3]-> m8;
			    mt8: m8 -[ep3]-> m5;
			  end a2;
			  
			  abstract implementation a2.i
			  flows
			    fsource1: flow source ep2 in modes (m5, m6, m7, mt5, mt6, mt7);
			    fsink1: flow sink ep3 in modes (m5, m6, m7, mt5, mt6, mt7);
			  end a2.i;
			end pack;
		'''.parse as AadlPackage) => [
			assertNoIssues
			"pack".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedPortConnections.get(0) => [
					"portconn1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4"])
				]
				ownedPortConnections.get(1) => [
					"portconn2".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4"])
				]
				ownedAccessConnections.head => [
					"aconn1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4"])
				]
				ownedFeatureGroupConnections.head => [
					"fgconn1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4"])
				]
				ownedFeatureConnections.head => [
					"fconn1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4"])
				]
				ownedParameterConnections.head => [
					"paramconn1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4"])
				]
				ownedEndToEndFlows.head => [
					"ete1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4"])
				]
			]
			publicSection.ownedClassifiers.get(2) as AbstractType => [
				"a2".assertEquals(name)
				ownedFlowSpecifications.get(0) => [
					"fsource1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m5", "m6", "m7", "m8", "mt5", "mt6", "mt7", "mt8"])
				]
				ownedFlowSpecifications.get(1) => [
					"fsink1".assertEquals(name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m5", "m6", "m7", "m8", "mt5", "mt6", "mt7", "mt8"])
				]
			]
			publicSection.ownedClassifiers.get(3) as AbstractImplementation => [
				"a2.i".assertEquals(name)
				ownedFlowImplementations.get(0) => [
					"fsource1".assertEquals(specification.name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m5", "m6", "m7", "m8", "mt5", "mt6", "mt7", "mt8"])
				]
				ownedFlowImplementations.get(1) => [
					"fsink1".assertEquals(specification.name)
					//Tests scope_ModalPath_inModeOrTransition
					assertScope(Aadl2Package::eINSTANCE.modalPath_InModeOrTransition, #["m5", "m6", "m7", "m8", "mt5", "mt6", "mt7", "mt8"])
				]
			]
		]
	}
	
	def private assertScope(EObject context, EReference reference, Iterable<String> expected) {
		expected.sort(CUSTOM_NAME_COMPARATOR).join(", ").assertEquals(context.getScope(reference).allElements.map[name.toString("::")].filter[
			val separatorIndex = indexOf("::")
			if (separatorIndex != -1) {
				val propertySetName = substring(0, separatorIndex)
				AadlUtil::isPredeclaredPropertySet(propertySetName) || !pluginResourcesNames.exists[equalsIgnoreCase(propertySetName)]
			} else {
				true
			}
		].sort(CUSTOM_NAME_COMPARATOR).join(", "))
	}
	
	/*
	 * Compares two aadl names such that simple names are less than qualified names.
	 * If the name is qualified then names in predeclared property sets are greater than names in other packages or property sets.
	 * 
	 * Example: "id" < "ps::id" < "Memory_Properties::Heap_Size"
	 */
	val static CUSTOM_NAME_COMPARATOR = new Comparator<String>() {
		override compare(String o1, String o2) {
			val o1SeparatorIndex = o1.indexOf("::")
			val o2SeparatorIndex = o2.indexOf("::")
			if (o1SeparatorIndex == -1 && o2SeparatorIndex == -1) {
				o1.compareTo(o2)
			} else if (o1SeparatorIndex == -1) {
				-1
			} else if (o2SeparatorIndex == -1) {
				1
			} else {
				val o1PsIsPredeclared = AadlUtil::isPredeclaredPropertySet(o1.substring(0, o1SeparatorIndex))
				val o2PsIsPredeclared = AadlUtil::isPredeclaredPropertySet(o2.substring(0, o2SeparatorIndex))
				if (o1PsIsPredeclared == o2PsIsPredeclared) {
					o1.compareTo(o2)
				} else if (o2PsIsPredeclared) {
					-1
				} else {
					1
				}
			}
		}
		
		//Xtend requires this method to be overriden.  I should file a bug with Xtend
		override equals(Object obj) {
			class == obj.class
		}
	}
}