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
package org.osate.core.tests.aadl2scopeprovider

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractType
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.SubprogramType
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class RefinedElementsTest extends OsateTest {
	@Inject extension ParseHelper<ModelUnit>
	@Inject extension ValidationTestHelper
	
	/*
	 * Tests scope_Prototype_refined, scope_Subcomponent_refined, scope_Feature_refined, scope_Connection_refined, scope_FlowSpecification_refined, and
	 * scope_EndToEndFlow_refined
	 */
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
			  flows
			    fsource1: flow source af1;
			    fsink1: flow sink af1;
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
			  flows
			    fsource1: refined to flow source;
			    fsource2: flow source af1;
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
			    asub1: abstract a1;
			  connections
			    fgconn1: feature group fg1 <-> fg1;
			    fconn1: feature asub1.af1 -> asub1.af1;
			  flows
			    etef1: end to end flow asub1.fsource1 -> fconn1 -> asub1.fsink1;
			  end a1.i1;
			  
			  abstract implementation a1.i2 extends a1.i1
			  subcomponents
			    asub1: refined to abstract;
			    asub2: abstract;
			  connections
			    fgconn1: refined to feature group;
			    fgconn2: feature group fg1 <-> fg1;
			  flows
			    etef1: refined to end to end flow in modes (m1);
			    etef2: end to end flow asub1.fsource1 -> fconn1 -> asub1.fsink1;
			  modes
			    m1: initial mode;
			    m2: mode;
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
				ownedFlowSpecifications.get(0) => [
					"fsource1".assertEquals(name)
					//Tests scope_FlowSpecification_refined
					assertScope(Aadl2Package::eINSTANCE.flowSpecification_Refined, #[])
				]
				ownedFlowSpecifications.get(1) => [
					"fsink1".assertEquals(name)
					//Tests scope_FlowSpecification_refined
					assertScope(Aadl2Package::eINSTANCE.flowSpecification_Refined, #[])
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
				ownedFlowSpecifications.get(0) => [
					"fsource1".assertEquals(name)
					//Tests scope_FlowSpecification_refined
					assertScope(Aadl2Package::eINSTANCE.flowSpecification_Refined, #["fsink1", "fsource1"])
				]
				ownedFlowSpecifications.get(1) => [
					"fsource2".assertEquals(name)
					//Tests scope_FlowSpecification_refined
					assertScope(Aadl2Package::eINSTANCE.flowSpecification_Refined, #["fsink1", "fsource1"])
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
				ownedFeatureGroupConnections.head => [
					"fgconn1".assertEquals(name)
					//Tests scope_Connection_refined
					assertScope(Aadl2Package::eINSTANCE.connection_Refined, #[])
				]
				ownedFeatureConnections.head => [
					"fconn1".assertEquals(name)
					//Tests scope_Connection_refined
					assertScope(Aadl2Package::eINSTANCE.connection_Refined, #[])
				]
				ownedEndToEndFlows.head => [
					"etef1".assertEquals(name)
					//Tests scope_EndToEndFlow_refined
					assertScope(Aadl2Package::eINSTANCE.endToEndFlow_Refined, #[])
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
					assertScope(Aadl2Package::eINSTANCE.connection_Refined, #["fconn1", "fgconn1"])
				]
				ownedConnections.get(1) => [
					"fgconn2".assertEquals(name)
					//Tests scope_Connection_refined
					assertScope(Aadl2Package::eINSTANCE.connection_Refined, #["fconn1", "fgconn1"])
				]
				ownedEndToEndFlows.get(0) => [
					"etef1".assertEquals(name)
					//Tests scope_EndToEndFlow_refined
					assertScope(Aadl2Package::eINSTANCE.endToEndFlow_Refined, #["etef1"])
				]
				ownedEndToEndFlows.get(1) => [
					"etef2".assertEquals(name)
					//Tests scope_EndToEndFlow_refined
					assertScope(Aadl2Package::eINSTANCE.endToEndFlow_Refined, #["etef1"])
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
}