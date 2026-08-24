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
package org.osate.core.tests.instantiation.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * What instantiation makes of prototypes: a component prototype decides the classifier of a
 * subcomponent instance, a feature prototype decides the category of a feature instance, and a feature
 * group prototype decides which features a feature group expands into.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PrototypeInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "PrototypeResolution.aadl";

	/** A bound component prototype gives the subcomponent instance the classifier it is bound to. */
	@Test
	public void boundComponentPrototypeDecidesTheClassifier() throws Exception {
		var bound = component(instantiate(FILE, "Top.i").instance(), "component_bound");

		assertEquals("PrototypeResolution::B.i", component(bound, "u").getClassifier().getQualifiedName());
		assertEquals("PrototypeResolution::B.i", component(bound, "c").getClassifier().getQualifiedName());
	}

	/**
	 * Without a binding, a prototype falls back to its constraining classifier if it has one, and to no
	 * classifier at all otherwise.
	 */
	@Test
	public void unboundComponentPrototypeFallsBackToItsConstrainingClassifier() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var unbound = component(result.instance(), "component_unbound");

		assertNull(component(unbound, "u").getClassifier());
		assertEquals("PrototypeResolution::B", component(unbound, "c").getClassifier().getQualifiedName());
		assertTrue(diagnostics(result).contains("Warning Top_i_Instance.component_unbound.u: "
				+ "Instantiated subcomponent doesn't have a component classifier"));
	}

	/**
	 * A feature declared with a feature prototype takes its category from what the prototype is bound
	 * to, and stays an abstract feature when the prototype is not bound (see issue #3067).
	 */
	@Test
	public void featurePrototypeDecidesTheFeatureCategory() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		var port = feature(component(root, "feature_port"), "f");
		assertEquals(FeatureCategory.DATA_PORT, port.getCategory());
		assertEquals(DirectionType.IN, port.getDirection());

		var access = feature(component(root, "feature_access"), "f");
		assertEquals(FeatureCategory.DATA_ACCESS, access.getCategory());

		var unbound = feature(component(root, "feature_unbound"), "f");
		assertEquals(FeatureCategory.ABSTRACT_FEATURE, unbound.getCategory());
		assertEquals(DirectionType.IN, unbound.getDirection());
	}

	/**
	 * A bound feature group prototype expands into the features of the feature group type it is bound to,
	 * and nothing is reported for it (see issue #3075).
	 */
	@Test
	public void boundFeatureGroupPrototypeExpandsIntoItsMembers() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var group = feature(component(result.instance(), "group_bound"), "fg");

		assertEquals(FeatureCategory.FEATURE_GROUP, group.getCategory());
		assertEquals(List.of("p"), featureNames(group));
		assertFalse(diagnostics(result).stream()
				.anyMatch(message -> message.startsWith("Warning Top_i_Instance.group_bound.fg: ")));
	}

	/**
	 * A feature group prototype that is neither bound nor constrained has no feature group type to expand.
	 * That is reported and the feature group is instantiated without members (see issue #3074).
	 */
	@Test
	public void unboundFeatureGroupPrototypeIsReported() throws Exception {
		var result = instantiate("UnboundFeatureGroupPrototype.aadl", "Top.i");
		var group = feature(component(result.instance(), "unbound"), "fg");

		assertEquals(FeatureCategory.FEATURE_GROUP, group.getCategory());
		assertEquals(List.of(), featureNames(group));
		assertTrue(diagnostics(result).contains("Error Top_i_Instance.unbound.fg: "
				+ "Could not resolve feature group type of feature group prototype Top_i_Instance.unbound.fg"));
	}
}
