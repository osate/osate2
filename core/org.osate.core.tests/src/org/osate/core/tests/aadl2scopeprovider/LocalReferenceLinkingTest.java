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
 * aries to this license with respect to the terms applicable to the Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.aadl2scopeprovider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes local AADL references before replacing custom lookup with scope-based linking. The model combines
 * successive refinements, feature prototype references, inherited modes, and local prefixes for contextual paths.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class LocalReferenceLinkingTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/localReferenceScope/LocalReferences.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private TestHelper<PropertySet> propertySetHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void refinementsSelectTheirNearestInheritedDeclarations() throws Exception {
		var pkg = parseValidModel();
		var base = (AbstractType) classifier(pkg, "Base");
		var middle = (AbstractType) classifier(pkg, "Middle");
		var leaf = (AbstractType) classifier(pkg, "Leaf");
		for (int index = 0; index < 3; index++) {
			assertSame(base.getOwnedPrototypes().get(index), middle.getOwnedPrototypes().get(index).getRefined());
			assertSame(middle.getOwnedPrototypes().get(index), leaf.getOwnedPrototypes().get(index).getRefined());
		}
		assertSame(base.getOwnedEventPorts().getFirst(), middle.getOwnedEventPorts().getFirst().getRefined());
		assertSame(middle.getOwnedEventPorts().getFirst(), leaf.getOwnedEventPorts().getFirst().getRefined());
		var baseImpl = (ComponentImplementation) classifier(pkg, "Base.base");
		var middleImpl = (ComponentImplementation) classifier(pkg, "Middle.middle");
		var leafImpl = (ComponentImplementation) classifier(pkg, "Leaf.leaf");
		assertSame(baseImpl.getOwnedSubcomponents().getFirst(),
				middleImpl.getOwnedSubcomponents().getFirst().getRefined());
		assertSame(middleImpl.getOwnedSubcomponents().getFirst(),
				leafImpl.getOwnedSubcomponents().getFirst().getRefined());
	}

	@Test
	public void implementationPrototypeRefinementSelectsTheTypePrototype() throws Exception {
		var pkg = parseValidModel();
		var base = classifier(pkg, "Base");
		var implementation = classifier(pkg, "Base.prototype_refinement");
		assertSame(base.getOwnedPrototypes().get(1), implementation.getOwnedPrototypes().getFirst().getRefined());
	}

	@Test
	public void featurePrototypeReferencesSelectTheLocalRefinement() throws Exception {
		var pkg = parseValidModel();
		var leaf = (AbstractType) classifier(pkg, "Leaf");
		var prototype = leaf.getOwnedPrototypes().getFirst();
		assertSame(prototype, leaf.getOwnedAbstractFeatures().getFirst().getFeaturePrototype());
		var implementation = (ComponentImplementation) classifier(pkg, "Leaf.leaf");
		var consumer = implementation.getOwnedSubcomponents().get(1);
		var binding = (FeaturePrototypeBinding) consumer.getOwnedPrototypeBindings().getFirst();
		assertSame(prototype, ((FeaturePrototypeReference) binding.getActual()).getPrototype());
	}

	@Test
	public void localModesResolveOnTransitionsBindingsAndSubcomponents() throws Exception {
		var pkg = parseValidModel();
		var base = (AbstractType) classifier(pkg, "Base");
		var initial = base.getOwnedModes().getFirst();
		var second = base.getOwnedModes().get(1);
		var forward = base.getOwnedModeTransitions().getFirst();
		assertSame(initial, forward.getSource());
		assertSame(second, forward.getDestination());
		var implementation = (ComponentImplementation) classifier(pkg, "Base.base");
		var backward = implementation.getOwnedModeTransitions().getFirst();
		assertSame(second, backward.getSource());
		assertSame(initial, backward.getDestination());
		var child = implementation.getOwnedSubcomponents().getFirst();
		assertSame(initial, child.getOwnedModeBindings().getFirst().getParentMode());
		assertSame(second, child.getOwnedModeBindings().get(1).getParentMode());
		var other = implementation.getOwnedSubcomponents().get(1);
		assertSame(initial, other.getInModes().getFirst());
		var leaf = (ComponentImplementation) classifier(pkg, "Leaf.leaf");
		assertSame(initial, leaf.getOwnedSubcomponents().get(1).getInModes().getFirst());
	}

	@Test
	public void contextPrefixesResolveMembersOfTheContainingImplementation() throws Exception {
		var pkg = parseValidModel();
		var implementation = (ComponentImplementation) classifier(pkg, "Base.base");
		var child = implementation.getOwnedSubcomponents().getFirst();
		assertSame(child, implementation.getOwnedConnections().getFirst().getDestination().getContext());
		assertSame(child,
				implementation.getOwnedFlowImplementations().getFirst().getOwnedFlowSegments().get(1).getContext());
		assertSame(child, implementation.getOwnedEndToEndFlows().getFirst()
				.getOwnedEndToEndFlowSegments().getFirst().getContext());
		assertSame(child,
				implementation.getOwnedModeTransitions().getFirst().getOwnedTriggers().getFirst().getContext());
		var leaf = (ComponentImplementation) classifier(pkg, "Leaf.leaf");
		assertSame(leaf.getOwnedSubcomponents().getFirst(),
				leaf.getOwnedConnections().getFirst().getDestination().getContext());
	}

	@Test
	public void unitConversionsResolveWithinTheirOwnUnitsType() throws Exception {
		var propertySet = propertySetHelper.parseFile("org.osate.core.tests/models/localReferenceScope/LocalUnits.aadl");
		validationHelper.assertNoIssues(propertySet);
		for (var type : propertySet.getOwnedPropertyTypes()) {
			var units = (UnitsType) type;
			assertSame(units.getOwnedLiterals().getFirst(), ((UnitLiteral) units.getOwnedLiterals().get(1)).getBaseUnit());
		}
	}

	@Test
	public void invalidLocalReferencesRemainUnresolved() throws Exception {
		var pkg = testHelper.parseFile("org.osate.core.tests/models/localReferenceScope/InvalidLocalReferences.aadl",
				MODEL);
		var issues = validationHelper.validate(pkg);
		assertEquals(List.of("Couldn't resolve reference to Feature 'missing_feature'.",
				"Couldn't resolve reference to FeaturePrototype 'missing_feature_proto'.",
				"Couldn't resolve reference to Prototype 'missing_proto'.",
				"Couldn't resolve reference to Subcomponent 'missing_sub'.",
				"Couldn't resolve reference to mode 'absent_mode'.",
				"Couldn't resolve reference to mode 'missing_parent'."),
				issues.stream().map(Issue::getMessage).sorted().toList());
		assertEquals(List.of(Diagnostic.LINKING_DIAGNOSTIC), issues.stream().map(Issue::getCode).distinct().toList());
	}

	private AadlPackage parseValidModel() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		return pkg;
	}

	private static Classifier classifier(AadlPackage pkg, String name) {
		return pkg.getPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> name.equals(classifier.getName())).findFirst().orElseThrow();
	}
}
