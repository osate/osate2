/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.aadl2scopeprovider;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class RefinedElementsTest extends XtextTest {
	private static final String REFINED_ELEMENTS = """
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
			    asub1: refined to abstract a1;
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
			    edport3: out event data port;
			    eport3: out event port;
			    fg3: feature group;
			    param2: in parameter;
			    suba3: requires subprogram access;
			    subga3: requires subprogram group access;
			    da3: requires data access;
			    af3: feature;
			  end sub1;

			  subprogram sub2 extends sub1
			  features
			    edport3: refined to out event data port;
			    eport3: refined to out event port;
			    fg3: refined to feature group;
			    param2: refined to in parameter;
			    suba3: refined to requires subprogram access;
			    subga3: refined to requires subprogram group access;
			    da3: refined to requires data access;
			    af3: refined to feature;
			  end sub2;
			end pack;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	AssertHelper assertHelper;

	@Inject
	ValidationTestHelper validationTestHelper;

	/*
	 * Tests scope_Prototype_refined, scope_Subcomponent_refined, scope_Feature_refined, scope_Connection_refined,
	 * scope_FlowSpecification_refined, and scope_EndToEndFlow_refined
	 */
	@Test
	public void testRefinedElements() throws Exception {
		var pkg = testHelper.parseString(REFINED_ELEMENTS);
		assertEquals("pack", pkg.getName());
		validationTestHelper.assertNoIssues(pkg);
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();

		var a1 = (AbstractType) classifiers.get(0);
		assertEquals("a1", a1.getName());
		assertPrototypeScope(a1.getOwnedPrototypes().getFirst(), "proto1", List.of());
		assertFeatureScope(a1.getOwnedDataPorts().getFirst(), "dport1", List.of());
		assertFeatureScope(a1.getOwnedEventDataPorts().getFirst(), "edport1", List.of());
		assertFeatureScope(a1.getOwnedEventPorts().getFirst(), "eport1", List.of());
		assertFeatureScope(a1.getOwnedFeatureGroups().getFirst(), "fg1", List.of());
		assertFeatureScope(a1.getOwnedSubprogramAccesses().getFirst(), "suba1", List.of());
		assertFeatureScope(a1.getOwnedSubprogramGroupAccesses().getFirst(), "subga1", List.of());
		assertFeatureScope(a1.getOwnedBusAccesses().getFirst(), "ba1", List.of());
		assertFeatureScope(a1.getOwnedDataAccesses().getFirst(), "da1", List.of());
		assertFeatureScope(a1.getOwnedAbstractFeatures().getFirst(), "af1", List.of());
		assertFlowSpecificationScope(a1.getOwnedFlowSpecifications().get(0), "fsource1", List.of());
		assertFlowSpecificationScope(a1.getOwnedFlowSpecifications().get(1), "fsink1", List.of());

		var a2 = (AbstractType) classifiers.get(1);
		assertEquals("a2", a2.getName());
		assertPrototypeScope(a2.getOwnedPrototypes().getFirst(), "proto1", List.of("proto1"));
		var refinedFeatureScopeForA2 = List.of("af1", "ba1", "da1", "dport1", "edport1", "eport1", "fg1", "suba1",
				"subga1");
		assertFeatureScope(a2.getOwnedDataPorts().getFirst(), "dport1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedEventDataPorts().getFirst(), "edport1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedEventPorts().getFirst(), "eport1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedFeatureGroups().getFirst(), "fg1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedSubprogramAccesses().getFirst(), "suba1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedSubprogramGroupAccesses().getFirst(), "subga1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedBusAccesses().getFirst(), "ba1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedDataAccesses().getFirst(), "da1", refinedFeatureScopeForA2);
		assertFeatureScope(a2.getOwnedAbstractFeatures().getFirst(), "af1", refinedFeatureScopeForA2);
		var refinedFlowScopeForA2 = List.of("fsink1", "fsource1");
		assertFlowSpecificationScope(a2.getOwnedFlowSpecifications().get(0), "fsource1", refinedFlowScopeForA2);
		assertFlowSpecificationScope(a2.getOwnedFlowSpecifications().get(1), "fsource2", refinedFlowScopeForA2);

		var fgt1 = (FeatureGroupType) classifiers.get(2);
		assertEquals("fgt1", fgt1.getName());
		assertPrototypeScope(fgt1.getOwnedPrototypes().getFirst(), "proto2", List.of());
		assertFeatureScope(fgt1.getOwnedDataPorts().getFirst(), "dport2", List.of());
		assertFeatureScope(fgt1.getOwnedEventDataPorts().getFirst(), "edport2", List.of());
		assertFeatureScope(fgt1.getOwnedEventPorts().getFirst(), "eport2", List.of());
		assertFeatureScope(fgt1.getOwnedFeatureGroups().getFirst(), "fg2", List.of());
		assertFeatureScope(fgt1.getOwnedParameters().getFirst(), "param1", List.of());
		assertFeatureScope(fgt1.getOwnedSubprogramAccesses().getFirst(), "suba2", List.of());
		assertFeatureScope(fgt1.getOwnedSubprogramGroupAccesses().getFirst(), "subga2", List.of());
		assertFeatureScope(fgt1.getOwnedBusAccesses().getFirst(), "ba2", List.of());
		assertFeatureScope(fgt1.getOwnedDataAccesses().getFirst(), "da2", List.of());
		assertFeatureScope(fgt1.getOwnedAbstractFeatures().getFirst(), "af2", List.of());

		var fgt2 = (FeatureGroupType) classifiers.get(3);
		assertEquals("fgt2", fgt2.getName());
		assertPrototypeScope(fgt2.getOwnedPrototypes().getFirst(), "proto2", List.of("proto2"));
		var refinedFeatureScopeForFgt2 = List.of("af2", "ba2", "da2", "dport2", "edport2", "eport2", "fg2", "param1",
				"suba2", "subga2");
		assertFeatureScope(fgt2.getOwnedDataPorts().getFirst(), "dport2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedEventDataPorts().getFirst(), "edport2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedEventPorts().getFirst(), "eport2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedFeatureGroups().getFirst(), "fg2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedParameters().getFirst(), "param1", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedSubprogramAccesses().getFirst(), "suba2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedSubprogramGroupAccesses().getFirst(), "subga2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedBusAccesses().getFirst(), "ba2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedDataAccesses().getFirst(), "da2", refinedFeatureScopeForFgt2);
		assertFeatureScope(fgt2.getOwnedAbstractFeatures().getFirst(), "af2", refinedFeatureScopeForFgt2);

		var a1i1 = (ComponentImplementation) classifiers.get(4);
		assertEquals("a1.i1", a1i1.getName());
		assertSubcomponentScope(a1i1.getOwnedSubcomponents().getFirst(), "asub1", List.of());
		assertConnectionScope(a1i1.getOwnedFeatureGroupConnections().getFirst(), "fgconn1", List.of());
		assertConnectionScope(a1i1.getOwnedFeatureConnections().getFirst(), "fconn1", List.of());
		assertEndToEndFlowScope(a1i1.getOwnedEndToEndFlows().getFirst(), "etef1", List.of());

		var a1i2 = (ComponentImplementation) classifiers.get(5);
		assertEquals("a1.i2", a1i2.getName());
		assertSubcomponentScope(a1i2.getOwnedSubcomponents().get(0), "asub1", List.of("asub1"));
		assertSubcomponentScope(a1i2.getOwnedSubcomponents().get(1), "asub2", List.of("asub1"));
		var refinedConnectionScope = List.of("fconn1", "fgconn1");
		assertConnectionScope(a1i2.getOwnedConnections().get(0), "fgconn1", refinedConnectionScope);
		assertConnectionScope(a1i2.getOwnedConnections().get(1), "fgconn2", refinedConnectionScope);
		assertEndToEndFlowScope(a1i2.getOwnedEndToEndFlows().get(0), "etef1", List.of("etef1"));
		assertEndToEndFlowScope(a1i2.getOwnedEndToEndFlows().get(1), "etef2", List.of("etef1"));

		var sub1 = (SubprogramType) classifiers.get(6);
		assertEquals("sub1", sub1.getName());
		assertFeatureScope(sub1.getOwnedEventDataPorts().getFirst(), "edport3", List.of());
		assertFeatureScope(sub1.getOwnedEventPorts().getFirst(), "eport3", List.of());
		assertFeatureScope(sub1.getOwnedFeatureGroups().getFirst(), "fg3", List.of());
		assertFeatureScope(sub1.getOwnedParameters().getFirst(), "param2", List.of());
		assertFeatureScope(sub1.getOwnedSubprogramAccesses().getFirst(), "suba3", List.of());
		assertFeatureScope(sub1.getOwnedSubprogramGroupAccesses().getFirst(), "subga3", List.of());
		assertFeatureScope(sub1.getOwnedDataAccesses().getFirst(), "da3", List.of());
		assertFeatureScope(sub1.getOwnedAbstractFeatures().getFirst(), "af3", List.of());

		var sub2 = (SubprogramType) classifiers.get(7);
		assertEquals("sub2", sub2.getName());
		var refinedFeatureScopeForSub2 = List.of("af3", "da3", "edport3", "eport3", "fg3", "param2", "suba3", "subga3");
		assertFeatureScope(sub2.getOwnedEventDataPorts().getFirst(), "edport3", refinedFeatureScopeForSub2);
		assertFeatureScope(sub2.getOwnedEventPorts().getFirst(), "eport3", refinedFeatureScopeForSub2);
		assertFeatureScope(sub2.getOwnedFeatureGroups().getFirst(), "fg3", refinedFeatureScopeForSub2);
		assertFeatureScope(sub2.getOwnedParameters().getFirst(), "param2", refinedFeatureScopeForSub2);
		assertFeatureScope(sub2.getOwnedSubprogramAccesses().getFirst(), "suba3", refinedFeatureScopeForSub2);
		assertFeatureScope(sub2.getOwnedSubprogramGroupAccesses().getFirst(), "subga3", refinedFeatureScopeForSub2);
		assertFeatureScope(sub2.getOwnedDataAccesses().getFirst(), "da3", refinedFeatureScopeForSub2);
		assertFeatureScope(sub2.getOwnedAbstractFeatures().getFirst(), "af3", refinedFeatureScopeForSub2);
	}

	/** Tests scope_Prototype_refined. */
	private void assertPrototypeScope(Prototype prototype, String name, List<String> expected) {
		assertScope(prototype, name, Aadl2Package.eINSTANCE.getPrototype_Refined(), expected);
	}

	/** Tests scope_Feature_refined. */
	private void assertFeatureScope(Feature feature, String name, List<String> expected) {
		assertScope(feature, name, Aadl2Package.eINSTANCE.getFeature_Refined(), expected);
	}

	/** Tests scope_FlowSpecification_refined. */
	private void assertFlowSpecificationScope(FlowSpecification flowSpecification, String name,
			List<String> expected) {
		assertScope(flowSpecification, name, Aadl2Package.eINSTANCE.getFlowSpecification_Refined(), expected);
	}

	/** Tests scope_Subcomponent_refined. */
	private void assertSubcomponentScope(Subcomponent subcomponent, String name, List<String> expected) {
		assertScope(subcomponent, name, Aadl2Package.eINSTANCE.getSubcomponent_Refined(), expected);
	}

	/** Tests scope_Connection_refined. */
	private void assertConnectionScope(Connection connection, String name, List<String> expected) {
		assertScope(connection, name, Aadl2Package.eINSTANCE.getConnection_Refined(), expected);
	}

	/** Tests scope_EndToEndFlow_refined. */
	private void assertEndToEndFlowScope(EndToEndFlow flow, String name, List<String> expected) {
		assertScope(flow, name, Aadl2Package.eINSTANCE.getEndToEndFlow_Refined(), expected);
	}

	private void assertScope(NamedElement element, String name, EReference reference, List<String> expected) {
		assertEquals(name, element.getName());
		assertHelper.assertScope(element, reference, expected);
	}
}
