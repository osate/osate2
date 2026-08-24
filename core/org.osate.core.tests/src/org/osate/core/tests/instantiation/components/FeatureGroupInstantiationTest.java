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
 * How a feature group is expanded into feature instances: nested groups, the two ways a group can be
 * inverted, extension with a refinement, and the two groups that expand into nothing.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FeatureGroupInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "FeatureGroups.aadl";

	/** A nested feature group is expanded in place, one level of feature instances per level of group. */
	@Test
	public void nestedFeatureGroupIsExpandedInPlace() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		var outer = feature(root, "outer");
		assertEquals(List.of("c", "nested"), featureNames(outer));
		var nested = feature(outer, "nested");
		assertEquals(FeatureCategory.FEATURE_GROUP, nested.getCategory());
		assertEquals(List.of("a", "b"), featureNames(nested));
		assertEquals(DirectionType.IN, feature(nested, "a").getDirection());
		assertEquals(DirectionType.OUT, feature(nested, "b").getDirection());
		assertEquals("Top_i_Instance.outer.nested.a", path(feature(nested, "a")));
	}

	/**
	 * A feature group type that only declares an inverse takes the features of that inverse with their
	 * directions turned around.
	 */
	@Test
	public void featureGroupTypeWithOnlyAnInverseTurnsTheDirectionsAround() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		var inverseType = feature(root, "inverse_type");
		assertEquals(List.of("a", "b"), featureNames(inverseType));
		assertEquals(DirectionType.OUT, feature(inverseType, "a").getDirection());
		assertEquals(DirectionType.IN, feature(inverseType, "b").getDirection());
	}

	/** Declaring the feature itself as the inverse of a type turns the directions around as well. */
	@Test
	public void inverseOnTheFeatureTurnsTheDirectionsAround() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		var inverseFeature = feature(root, "inverse_feature");
		assertEquals(List.of("a", "b"), featureNames(inverseFeature));
		assertEquals(DirectionType.OUT, feature(inverseFeature, "a").getDirection());
		assertEquals(DirectionType.IN, feature(inverseFeature, "b").getDirection());
	}

	/**
	 * An extension contributes the features of the extended type, with a refined feature replacing the
	 * one it refines - at the end of the list, not at the position the refined feature had.
	 */
	@Test
	public void extensionReplacesTheRefinedFeatureAtTheEnd() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		var extended = feature(root, "extended");
		assertEquals(List.of("y", "x"), featureNames(extended));
		assertEquals(DirectionType.OUT, feature(extended, "y").getDirection());
		assertEquals(DirectionType.IN, feature(extended, "x").getDirection());
	}

	/** A feature group type with no features is reported; a feature group with no type is not. */
	@Test
	public void groupWithoutFeaturesIsReportedAndGroupWithoutTypeIsNot() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var root = result.instance();

		var empty = feature(root, "empty");
		assertEquals(FeatureCategory.FEATURE_GROUP, empty.getCategory());
		assertTrue(empty.getFeatureInstances().isEmpty());

		var noType = feature(root, "no_type");
		assertEquals(FeatureCategory.FEATURE_GROUP, noType.getCategory());
		assertTrue(noType.getFeatureInstances().isEmpty());

		assertEquals(List.of("Warning Top_i_Instance.empty: Feature group Top_i_Instance.empty has no features"),
				diagnostics(result));
	}

	/** A feature group instance is in out whatever its members are. */
	@Test
	public void featureGroupInstanceIsInOut() throws Exception {
		var root = instantiate(FILE, "Top.i").instance();

		assertEquals(List.of("outer", "inverse_type", "inverse_feature", "extended", "empty", "no_type"),
				featureNames(root));
		for (var featureInstance : root.getFeatureInstances()) {
			assertEquals(featureInstance.getName(), DirectionType.IN_OUT, featureInstance.getDirection());
			assertEquals(featureInstance.getName(), 0, featureInstance.getIndex());
		}
	}
}
