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
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PrototypeBinding;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class OtherAadl2ScopeProviderTest extends XtextTest {
	private static final List<String> COMPONENT_CLASSIFIER_SCOPE_FOR_PACK1 = List.of("a1", "a2", "a2.i", "a4", "a4.i",
			"a6", "d1", "d1.i", "d3", "d3.i", "d5", "renamed_abstract", "renamed_data", "renamed_subprogram", "subp1",
			"subp1.i", "subp3", "subp3.i", "subp5", "pack1::a1", "pack1::a2", "pack1::a2.i", "pack1::d1", "pack1::d1.i",
			"pack1::subp1", "pack1::subp1.i", "pack2::a3", "pack2::a3.i", "pack2::d2", "pack2::d2.i", "pack2::subp2",
			"pack2::subp2.i", "pack3::a4", "pack3::a4.i", "pack3::d3", "pack3::d3.i", "pack3::subp3", "pack3::subp3.i",
			"pack4::a5", "pack4::a5.i", "pack4::d4", "pack4::d4.i", "pack4::subp4", "pack4::subp4.i", "pack5::a6",
			"pack5::a7", "pack5::d5", "pack5::d5.i", "pack5::d6", "pack5::d6.i", "pack5::subp5", "pack5::subp5.i",
			"pack5::subp6", "pack5::subp6.i", "renamed_package::a5", "renamed_package::a5.i", "renamed_package::d4",
			"renamed_package::d4.i", "renamed_package::subp4", "renamed_package::subp4.i");

	private static final List<String> DATA_CLASSIFIER_SCOPE_FOR_PACK1 = List.of("d1", "d1.i", "d3", "d3.i", "d5",
			"renamed_data", "pack1::d1", "pack1::d1.i", "pack2::d2", "pack2::d2.i", "pack3::d3", "pack3::d3.i",
			"pack4::d4", "pack4::d4.i", "pack5::d5", "pack5::d5.i", "pack5::d6", "pack5::d6.i", "renamed_package::d4",
			"renamed_package::d4.i");

	private static final List<String> A1_PROTOTYPE_SCOPE = List.of("proto1", "proto11", "proto3", "proto5", "proto8",
			"proto9");

	private static final List<String> FGT1_PROTOTYPE_SCOPE = List.of("proto10", "proto12", "proto4", "proto6");

	private static final List<String> PACK_FEATURE_GROUP_TYPE_SCOPE = List.of("fgt1", "fgt2", "proto3", "proto5",
			"pack::fgt1", "pack::fgt2");

	private static final List<String> A1_I_MODES = List.of("m1", "m2", "m3", "m4", "mt1", "mt2", "mt3", "mt4");

	private static final List<String> A2_MODES = List.of("m5", "m6", "m7", "m8", "mt5", "mt6", "mt7", "mt8");

	@Inject
	ValidationTestHelper validationTestHelper;

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Inject
	AssertHelper assertHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	/*
	 * Tests scope_ComponentPrototype_constrainingClassifier, scope_FeaturePrototype_constrainingClassifier,
	 * scope_FeatureGroupPrototypeActual_featureType, scope_PortSpecification_classifier,
	 * scope_AccessSpecification_classifier, scope_ComponentPrototypeActual_subcomponentType,
	 * scope_EventDataSource_dataClassifier, scope_PortProxy_dataClassifier, and
	 * scope_SubprogramProxy_subprogramClassifier
	 */
	@Test
	public void testRenamesInClassifierReferenceScope() throws Exception {
		var pack1 = """
				package pack1
				public
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
				""";
		var pack2 = """
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
				""";
		var pack3 = """
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
				""";
		var pack4 = """
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
				""";
		var pack5 = """
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
				""";
		var pkg = testHelper.parseString(pack1, pack2, pack3, pack4, pack5);
		assertEquals("pack1", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();

		var a1 = classifiers.get(0);
		assertEquals("a1", a1.getName());
		var proto1 = a1.getOwnedPrototypes().get(0);
		assertEquals("proto1", proto1.getName());
		// Tests scope_ComponentPrototype_constrainingClassifier
		assertHelper.assertScope(proto1, Aadl2Package.eINSTANCE.getComponentPrototype_ConstrainingClassifier(),
				COMPONENT_CLASSIFIER_SCOPE_FOR_PACK1);
		var proto2 = a1.getOwnedPrototypes().get(1);
		assertEquals("proto2", proto2.getName());
		// Tests scope_FeaturePrototype_constrainingClassifier
		assertHelper.assertScope(proto2, Aadl2Package.eINSTANCE.getFeaturePrototype_ConstrainingClassifier(),
				COMPONENT_CLASSIFIER_SCOPE_FOR_PACK1);

		var a2 = classifiers.get(1);
		assertEquals("a2", a2.getName());
		var proto3Binding = (FeatureGroupPrototypeBinding) a2.getOwnedPrototypeBindings().get(0);
		assertEquals("proto3", proto3Binding.getFormal().getName());
		// Tests scope_FeatureGroupPrototypeActual_featureType
		assertHelper.assertScope(proto3Binding.getActual(),
				Aadl2Package.eINSTANCE.getFeatureGroupPrototypeActual_FeatureType(),
				List.of("fgt1", "fgt3", "fgt5", "proto3", "renamed_feature_group", "pack1::fgt1", "pack2::fgt2",
						"pack3::fgt3", "pack4::fgt4", "pack5::fgt5", "renamed_package::fgt4"));
		var proto4Binding = (FeaturePrototypeBinding) a2.getOwnedPrototypeBindings().get(1);
		assertEquals("proto4", proto4Binding.getFormal().getName());
		// Tests scope_PortSpecification_classifier
		assertHelper.assertScope(proto4Binding.getActual(), Aadl2Package.eINSTANCE.getPortSpecification_Classifier(),
				COMPONENT_CLASSIFIER_SCOPE_FOR_PACK1);
		var proto5Binding = (FeaturePrototypeBinding) a2.getOwnedPrototypeBindings().get(2);
		assertEquals("proto5", proto5Binding.getFormal().getName());
		// Tests scope_AccessSpecification_classifier
		assertHelper.assertScope(proto5Binding.getActual(), Aadl2Package.eINSTANCE.getAccessSpecification_Classifier(),
				COMPONENT_CLASSIFIER_SCOPE_FOR_PACK1);
		var proto6Binding = (ComponentPrototypeBinding) a2.getOwnedPrototypeBindings().get(3);
		assertEquals("proto6", proto6Binding.getFormal().getName());
		// Tests scope_ComponentPrototypeActual_subcomponentType
		assertHelper.assertScope(proto6Binding.getActuals().get(0),
				Aadl2Package.eINSTANCE.getComponentPrototypeActual_SubcomponentType(),
				concat(List.of("proto1", "proto6"), COMPONENT_CLASSIFIER_SCOPE_FOR_PACK1));

		var a2i = (ComponentImplementation) classifiers.get(2);
		assertEquals("a2.i", a2i.getName());
		var eds1 = a2i.getOwnedEventDataSources().getFirst();
		assertEquals("eds1", eds1.getName());
		// Tests scope_EventDataSource_dataClassifier
		assertHelper.assertScope(eds1, Aadl2Package.eINSTANCE.getEventDataSource_DataClassifier(),
				DATA_CLASSIFIER_SCOPE_FOR_PACK1);
		var pp1 = a2i.getOwnedPortProxies().getFirst();
		assertEquals("pp1", pp1.getName());
		// Tests scope_PortProxy_dataClassifier
		assertHelper.assertScope(pp1, Aadl2Package.eINSTANCE.getPortProxy_DataClassifier(),
				DATA_CLASSIFIER_SCOPE_FOR_PACK1);
		var sp1 = a2i.getOwnedSubprogramProxies().getFirst();
		assertEquals("sp1", sp1.getName());
		// Tests scope_SubprogramProxy_subprogramClassifier
		assertHelper.assertScope(sp1, Aadl2Package.eINSTANCE.getSubprogramProxy_SubprogramClassifier(),
				List.of("renamed_subprogram", "subp1", "subp1.i", "subp3", "subp3.i", "subp5", "pack1::subp1",
						"pack1::subp1.i", "pack2::subp2", "pack2::subp2.i", "pack3::subp3", "pack3::subp3.i",
						"pack4::subp4", "pack4::subp4.i", "pack5::subp5", "pack5::subp5.i", "pack5::subp6",
						"pack5::subp6.i", "renamed_package::subp4", "renamed_package::subp4.i"));
	}

	/*
	 * Tests scope_PrototypeBinding_formal, scope_FeatureGroupPrototypeActual_featureType,
	 * scope_FeaturePrototypeReference_prototype, and scope_ComponentPrototypeActual_subcomponentType
	 */
	@Test
	public void testPrototypeBindings() throws Exception {
		var pack = """
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
				    asub1: abstract a3 [](a3.i1 (
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
				""";
		var pkg = parse(pack);
		assertEquals("pack", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();
		var subcomponentTypeScope = List.of("a1", "a1.i1", "a1.i2", "a1.i3", "a2", "a3", "a3.i1", "proto1", "proto11",
				"pack::a1", "pack::a1.i1", "pack::a1.i2", "pack::a1.i3", "pack::a2", "pack::a3", "pack::a3.i1");

		var a2 = classifiers.get(1);
		assertEquals("a2", a2.getName());
		var proto1Binding = (ComponentPrototypeBinding) a2.getOwnedPrototypeBindings().get(0);
		assertEquals("proto1", proto1Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(proto1Binding, A1_PROTOTYPE_SCOPE);
		var proto1Actual = proto1Binding.getActuals().getFirst();
		assertEquals("a3", proto1Actual.getSubcomponentType().getName());
		// Tests scope_ComponentPrototypeActual_subcomponentType
		assertHelper.assertScope(proto1Actual, Aadl2Package.eINSTANCE.getComponentPrototypeActual_SubcomponentType(),
				subcomponentTypeScope);
		var proto2Binding = proto1Actual.getBindings().getFirst();
		assertEquals("proto2", proto2Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(ComponentPrototypeActual, EReference)
		assertFormalScope(proto2Binding, List.of("proto2"));

		var proto3Binding = (FeatureGroupPrototypeBinding) a2.getOwnedPrototypeBindings().get(1);
		assertEquals("proto3", proto3Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(proto3Binding, A1_PROTOTYPE_SCOPE);
		var proto3Actual = proto3Binding.getActual();
		assertEquals("fgt1", ((NamedElement) proto3Actual.getFeatureType()).getName());
		// Tests scope_FeatureGroupPrototypeActual_featureType
		assertHelper.assertScope(proto3Actual, Aadl2Package.eINSTANCE.getFeatureGroupPrototypeActual_FeatureType(),
				PACK_FEATURE_GROUP_TYPE_SCOPE);
		var proto4Binding = proto3Actual.getBindings().getFirst();
		assertEquals("proto4", proto4Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(FeatureGroupPrototypeActual, EReference)
		assertFormalScope(proto4Binding, FGT1_PROTOTYPE_SCOPE);

		var a1i1 = (ComponentImplementation) classifiers.get(2);
		assertEquals("a1.i1", a1i1.getName());
		var asub1 = a1i1.getOwnedSubcomponents().get(0);
		assertEquals("asub1", asub1.getName());
		AssertHelper.assertWarning(asub1, testFileResult.getIssues(), issueCollection,
				"List of implementation reference not fully implemented in instantiator.");
		var implementationReference = asub1.getImplementationReferences().getFirst();
		assertEquals("a3.i1", implementationReference.getImplementation().getName());
		var referenceBinding = implementationReference.getOwnedPrototypeBindings().getFirst();
		assertEquals("proto2", referenceBinding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(ComponentImplementationReference, EReference)
		assertFormalScope(referenceBinding, List.of("proto2"));
		var asub2 = a1i1.getOwnedSubcomponents().get(1);
		assertEquals("asub2", asub2.getName());
		var subcomponentBinding = asub2.getOwnedPrototypeBindings().getFirst();
		assertEquals("proto2", subcomponentBinding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Subcomponent, EReference)
		assertFormalScope(subcomponentBinding, List.of("proto2"));

		var a1i2 = classifiers.get(3);
		assertEquals("a1.i2", a1i2.getName());
		var i2Proto1Binding = (ComponentPrototypeBinding) a1i2.getOwnedPrototypeBindings().get(0);
		assertEquals("proto1", i2Proto1Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(i2Proto1Binding, A1_PROTOTYPE_SCOPE);
		// Tests scope_ComponentPrototypeActual_subcomponentType
		assertHelper.assertScope(i2Proto1Binding.getActuals().getFirst(),
				Aadl2Package.eINSTANCE.getComponentPrototypeActual_SubcomponentType(), subcomponentTypeScope);
		var i2Proto3Binding = (FeatureGroupPrototypeBinding) a1i2.getOwnedPrototypeBindings().get(1);
		assertEquals("proto3", i2Proto3Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(i2Proto3Binding, A1_PROTOTYPE_SCOPE);
		// Tests scope_FeatureGroupPrototypeActual_featureType
		assertHelper.assertScope(i2Proto3Binding.getActual(),
				Aadl2Package.eINSTANCE.getFeatureGroupPrototypeActual_FeatureType(), PACK_FEATURE_GROUP_TYPE_SCOPE);
		var i2Proto5Binding = (FeatureGroupPrototypeBinding) a1i2.getOwnedPrototypeBindings().get(2);
		assertEquals("proto5", i2Proto5Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(i2Proto5Binding, A1_PROTOTYPE_SCOPE);
		// Tests scope_FeatureGroupPrototypeActual_featureType
		assertHelper.assertScope(i2Proto5Binding.getActual(),
				Aadl2Package.eINSTANCE.getFeatureGroupPrototypeActual_FeatureType(), PACK_FEATURE_GROUP_TYPE_SCOPE);
		var i2Proto8Binding = (FeaturePrototypeBinding) a1i2.getOwnedPrototypeBindings().get(3);
		assertEquals("proto8", i2Proto8Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(i2Proto8Binding, A1_PROTOTYPE_SCOPE);
		// Tests scope_FeaturePrototypeReference_prototype
		assertHelper.assertScope(i2Proto8Binding.getActual(),
				Aadl2Package.eINSTANCE.getFeaturePrototypeReference_Prototype(), List.of("proto8", "proto9"));
		var i2Proto11Binding = (ComponentPrototypeBinding) a1i2.getOwnedPrototypeBindings().get(4);
		assertEquals("proto11", i2Proto11Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(i2Proto11Binding, A1_PROTOTYPE_SCOPE);
		// Tests scope_ComponentPrototypeActual_subcomponentType
		assertHelper.assertScope(i2Proto11Binding.getActuals().getFirst(),
				Aadl2Package.eINSTANCE.getComponentPrototypeActual_SubcomponentType(), subcomponentTypeScope);

		var a1i3 = classifiers.get(4);
		assertEquals("a1.i3", a1i3.getName());
		var i3Proto1Binding = (ComponentPrototypeBinding) a1i3.getOwnedPrototypeBindings().get(0);
		assertEquals("proto1", i3Proto1Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(i3Proto1Binding, A1_PROTOTYPE_SCOPE);
		// Tests scope_ComponentPrototypeActual_subcomponentType
		assertHelper.assertScope(i3Proto1Binding.getActuals().getFirst(),
				Aadl2Package.eINSTANCE.getComponentPrototypeActual_SubcomponentType(), subcomponentTypeScope);

		var fgt2 = classifiers.get(8);
		assertEquals("fgt2", fgt2.getName());
		var fgt2Proto4Binding = fgt2.getOwnedPrototypeBindings().get(0);
		assertEquals("proto4", fgt2Proto4Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(fgt2Proto4Binding, FGT1_PROTOTYPE_SCOPE);
		var fgt2Proto6Binding = (FeatureGroupPrototypeBinding) fgt2.getOwnedPrototypeBindings().get(1);
		assertEquals("proto6", fgt2Proto6Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(fgt2Proto6Binding, FGT1_PROTOTYPE_SCOPE);
		// Tests scope_FeatureGroupPrototypeActual_featureType
		assertHelper.assertScope(fgt2Proto6Binding.getActual(),
				Aadl2Package.eINSTANCE.getFeatureGroupPrototypeActual_FeatureType(),
				List.of("fgt1", "fgt2", "proto6", "proto7", "pack::fgt1", "pack::fgt2"));
		var fgt2Proto10Binding = (FeaturePrototypeBinding) fgt2.getOwnedPrototypeBindings().get(2);
		assertEquals("proto10", fgt2Proto10Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(fgt2Proto10Binding, FGT1_PROTOTYPE_SCOPE);
		// Tests scope_FeaturePrototypeReference_prototype
		assertHelper.assertScope(fgt2Proto10Binding.getActual(),
				Aadl2Package.eINSTANCE.getFeaturePrototypeReference_Prototype(), List.of("proto10", "proto4"));
		var fgt2Proto12Binding = (ComponentPrototypeBinding) fgt2.getOwnedPrototypeBindings().get(3);
		assertEquals("proto12", fgt2Proto12Binding.getFormal().getName());
		// Tests scope_PrototypeBinding_formal(Classifier, EReference)
		assertFormalScope(fgt2Proto12Binding, FGT1_PROTOTYPE_SCOPE);
		// Tests scope_ComponentPrototypeActual_subcomponentType
		assertHelper.assertScope(fgt2Proto12Binding.getActuals().getFirst(),
				Aadl2Package.eINSTANCE.getComponentPrototypeActual_SubcomponentType(),
				List.of("a1", "a1.i1", "a1.i2", "a1.i3", "a2", "a3", "a3.i1", "proto12", "proto13", "pack::a1",
						"pack::a1.i1", "pack::a1.i2", "pack::a1.i3", "pack::a2", "pack::a3", "pack::a3.i1"));

		assertAllIssuesReported();
	}

	// Tests scope_ModalPath_inModeOrTransition and scope_FlowImplementation_specification
	@Test
	public void testInModesAndFlows() throws Exception {
		var pack = """
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
				  calls
				    sequence1: {
				      call1: subprogram subp1;
				      call2: subprogram subp2;
				    };
				  connections
					portconn1: port ep1 -> asub1.ep1 in modes (m1, m2, mt1, mt2);
					portconn2: port asub2.ep2 -> asub3.ep3;
					aconn1: data access da1 -> asub1.da1 in modes (m1, m2, mt1, mt2);
				    fgconn1: feature group fg1 <-> fg1 in modes (m1, m2, mt1, mt2);
				    fconn1: feature fg1 -> asub1.fg1 in modes (m1, m2, mt1, mt2);
				    paramconn1: parameter call1.param1 -> call2.param2 in modes (m1, m2, mt1, mt2);
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
				  subcomponents
				    dummy: abstract a2;
				  connections
				    c1: port dummy.ep2 -> dummy.ep3;
				  flows
				    fsource1: flow source ep2 in modes (m5, m6, m7, mt5, mt6, mt7);
				    fsink1: flow sink ep3 in modes (m5, m6, m7, mt5, mt6, mt7);
				  end a2.i;

				  subprogram subp1
				  features
				    param1: out parameter;
				  end subp1;

				  subprogram subp2
				  features
				    param2: in parameter;
				  end subp2;
				end pack;
				""";
		var pkg = parse(pack);
		assertEquals("pack", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();

		var a1i = (AbstractImplementation) classifiers.get(1);
		assertEquals("a1.i", a1i.getName());
		// Tests scope_ModalPath_inModeOrTransition
		assertInModes(a1i.getOwnedPortConnections().get(0), "portconn1", A1_I_MODES);
		assertInModes(a1i.getOwnedPortConnections().get(1), "portconn2", A1_I_MODES);
		assertInModes(a1i.getOwnedAccessConnections().getFirst(), "aconn1", A1_I_MODES);
		assertInModes(a1i.getOwnedFeatureGroupConnections().getFirst(), "fgconn1", A1_I_MODES);
		assertInModes(a1i.getOwnedFeatureConnections().getFirst(), "fconn1", A1_I_MODES);
		assertInModes(a1i.getOwnedParameterConnections().getFirst(), "paramconn1", A1_I_MODES);
		assertInModes(a1i.getOwnedEndToEndFlows().getFirst(), "ete1", A1_I_MODES);

		var a2 = (AbstractType) classifiers.get(2);
		assertEquals("a2", a2.getName());
		// Tests scope_ModalPath_inModeOrTransition
		assertInModes(a2.getOwnedFlowSpecifications().get(0), "fsource1", A2_MODES);
		assertInModes(a2.getOwnedFlowSpecifications().get(1), "fsink1", A2_MODES);

		var a2i = (AbstractImplementation) classifiers.get(3);
		assertEquals("a2.i", a2i.getName());
		var flowImplementations = a2i.getOwnedFlowImplementations();
		for (var index = 0; index < 2; index++) {
			var flowImplementation = flowImplementations.get(index);
			assertEquals(index == 0 ? "fsource1" : "fsink1", flowImplementation.getSpecification().getName());
			// Tests scope_FlowImplementation_specification
			assertHelper.assertScope(flowImplementation,
					Aadl2Package.eINSTANCE.getFlowImplementation_Specification(), List.of("fsink1", "fsource1"));
			// Tests scope_ModalPath_inModeOrTransition
			assertHelper.assertScope(flowImplementation, Aadl2Package.eINSTANCE.getModalPath_InModeOrTransition(),
					A2_MODES);
			AssertHelper.assertWarning(flowImplementation, testFileResult.getIssues(), issueCollection,
					"Flow implementation is empty and does not add value to the model");
		}

		assertAllIssuesReported();
	}

	// Tests scope_ModeBinding_parentMode and scope_ModeBinding_derivedMode
	@Test
	public void testModeBindings() throws Exception {
		var pack = """
				package pack
				public
					abstract a1
					prototypes
						aproto1: abstract a2;
						aproto2: abstract;
					end a1;

					abstract implementation a1.i (aproto2 => abstract a2)
					subcomponents
						asub1: abstract in modes (m1);
						asub2: abstract a2 in modes (m1 => m3);
						asub3: abstract aproto1 in modes (m1 => m3);
						asub4: abstract aproto2 in modes (m1 => m3);
					modes
						m1: initial mode;
						m2: mode;
					end a1.i;

					abstract a2
					requires modes
						m3: mode;
						m4: mode;
					end a2;
				end pack;
				""";
		var pkg = testHelper.parseString(pack);
		validationTestHelper.assertNoIssues(pkg);
		assertEquals("pack", pkg.getName());
		var implementation = (AbstractImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var subcomponents = implementation.getOwnedAbstractSubcomponents();

		var asub1 = subcomponents.get(0);
		assertEquals("asub1", asub1.getName());
		var asub1Binding = asub1.getOwnedModeBindings().getFirst();
		assertEquals("m1", asub1Binding.getParentMode().getName());
		assertNull(asub1Binding.getDerivedMode());
		// Tests scope_ModeBinding_parentMode
		assertHelper.assertScope(asub1Binding, Aadl2Package.eINSTANCE.getModeBinding_ParentMode(),
				List.of("m1", "m2"));
		// Tests scope_ModeBinding_derivedMode
		assertHelper.assertScope(asub1Binding, Aadl2Package.eINSTANCE.getModeBinding_DerivedMode(), List.of());

		for (var index = 1; index <= 3; index++) {
			var subcomponent = subcomponents.get(index);
			assertEquals("asub" + (index + 1), subcomponent.getName());
			var binding = subcomponent.getOwnedModeBindings().getFirst();
			assertEquals("m1", binding.getParentMode().getName());
			assertEquals("m3", binding.getDerivedMode().getName());
			// Tests scope_ModeBinding_parentMode
			assertHelper.assertScope(binding, Aadl2Package.eINSTANCE.getModeBinding_ParentMode(), List.of("m1", "m2"));
			// Tests scope_ModeBinding_derivedMode
			assertHelper.assertScope(binding, Aadl2Package.eINSTANCE.getModeBinding_DerivedMode(),
					List.of("m3", "m4"));
		}
	}

	private AadlPackage parse(String source) throws Exception {
		testFileResult = issues = testHelper.testString(source);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());
		return (AadlPackage) testFileResult.getResource().getContents().getFirst();
	}

	private void assertAllIssuesReported() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertInModes(NamedElement modalPath, String name, List<String> expected) {
		assertEquals(name, modalPath.getName());
		assertHelper.assertScope(modalPath, Aadl2Package.eINSTANCE.getModalPath_InModeOrTransition(), expected);
	}

	private void assertFormalScope(PrototypeBinding binding, List<String> expected) {
		assertHelper.assertScope(binding, Aadl2Package.eINSTANCE.getPrototypeBinding_Formal(), expected);
	}

	private static List<String> concat(List<String> first, List<String> second) {
		return Stream.concat(first.stream(), second.stream()).toList();
	}
}
