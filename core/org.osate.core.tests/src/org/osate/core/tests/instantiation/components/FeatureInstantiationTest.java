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
import static org.junit.Assert.assertSame;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * The category and the direction a feature instance gets for every kind of feature. Access features
 * have no direction of their own, so instantiation derives one from the access kind: provides becomes
 * out, requires becomes in. A virtual bus access instantiates as a bus access, because the instance
 * model has no separate category for it.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FeatureInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "FeatureKinds.aadl";

	/**
	 * Feature instances are grouped by the kind of feature they come from, not created in declaration
	 * order.
	 */
	@Test
	public void featureInstancesAreGroupedByKind() throws Exception {
		var thread = thread(instantiate(FILE, "Top.i").instance());

		assertEquals(List.of("fgroup", "abstract_plain", "abstract_in", "abstract_out", "data_in", "data_out",
				"event_data_inout", "event_out", "data_access_req", "data_access_prov", "subprogram_access",
				"subprogram_group_access"), featureNames(thread));
	}

	@Test
	public void portsKeepTheirCategoryAndDirection() throws Exception {
		var thread = thread(instantiate(FILE, "Top.i").instance());

		assertFeature(thread, "data_in", FeatureCategory.DATA_PORT, DirectionType.IN);
		assertFeature(thread, "data_out", FeatureCategory.DATA_PORT, DirectionType.OUT);
		assertFeature(thread, "event_out", FeatureCategory.EVENT_PORT, DirectionType.OUT);
		assertFeature(thread, "event_data_inout", FeatureCategory.EVENT_DATA_PORT, DirectionType.IN_OUT);
	}

	/** An access feature gets out for provides and in for requires. */
	@Test
	public void accessDirectionComesFromTheAccessKind() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var thread = thread(result.instance());

		assertFeature(thread, "data_access_req", FeatureCategory.DATA_ACCESS, DirectionType.IN);
		assertFeature(thread, "data_access_prov", FeatureCategory.DATA_ACCESS, DirectionType.OUT);
		assertFeature(thread, "subprogram_access", FeatureCategory.SUBPROGRAM_ACCESS, DirectionType.OUT);
		assertFeature(thread, "subprogram_group_access", FeatureCategory.SUBPROGRAM_GROUP_ACCESS, DirectionType.IN);

		var device = component(result.instance(), "d");
		assertFeature(device, "bus_access_req", FeatureCategory.BUS_ACCESS, DirectionType.IN);
		assertFeature(device, "bus_access_prov", FeatureCategory.BUS_ACCESS, DirectionType.OUT);
	}

	/** A virtual bus access is instantiated as a bus access. */
	@Test
	public void virtualBusAccessBecomesBusAccess() throws Exception {
		var device = component(instantiate(FILE, "Top.i").instance(), "d");

		assertFeature(device, "virtual_bus_access", FeatureCategory.BUS_ACCESS, DirectionType.IN);
	}

	/** An abstract feature without a direction is in out; with one it keeps that direction. */
	@Test
	public void abstractFeatureDirectionDefaultsToInOut() throws Exception {
		var thread = thread(instantiate(FILE, "Top.i").instance());

		assertFeature(thread, "abstract_plain", FeatureCategory.ABSTRACT_FEATURE, DirectionType.IN_OUT);
		assertFeature(thread, "abstract_in", FeatureCategory.ABSTRACT_FEATURE, DirectionType.IN);
		assertFeature(thread, "abstract_out", FeatureCategory.ABSTRACT_FEATURE, DirectionType.OUT);
	}

	/** A feature group instance is in out and holds the features of its type. */
	@Test
	public void featureGroupIsInOutAndHoldsItsMembers() throws Exception {
		var thread = thread(instantiate(FILE, "Top.i").instance());

		var group = feature(thread, "fgroup");
		assertEquals(FeatureCategory.FEATURE_GROUP, group.getCategory());
		assertEquals(DirectionType.IN_OUT, group.getDirection());
		assertEquals(List.of("member"), featureNames(group));
		assertEquals(FeatureCategory.DATA_PORT, feature(group, "member").getCategory());
	}

	/** Parameters of a subprogram subcomponent are instantiated like any other feature. */
	@Test
	public void parametersAreInstantiatedOnSubprogramInstances() throws Exception {
		var subprogram = component(thread(instantiate(FILE, "Top.i").instance()), "called");

		assertFeature(subprogram, "param_in", FeatureCategory.PARAMETER, DirectionType.IN);
		assertFeature(subprogram, "param_out", FeatureCategory.PARAMETER, DirectionType.OUT);
	}

	/** A feature that is not an array is indexed with zero and refers back to its declaration. */
	@Test
	public void featureThatIsNotAnArrayHasIndexZero() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var thread = thread(result.instance());

		var dataIn = feature(thread, "data_in");
		assertEquals(0, dataIn.getIndex());
		assertEquals("data_in", dataIn.getFeature().getName());
		assertSame(thread, dataIn.getComponentInstance());
		assertEquals(List.of(), diagnostics(result));
	}

	private static ComponentInstance thread(ComponentInstance root) {
		return component(component(root, "p"), "t");
	}

	private static void assertFeature(ComponentInstance owner, String name, FeatureCategory category,
			DirectionType direction) {
		var featureInstance = feature(owner, name);
		assertEquals(name, category, featureInstance.getCategory());
		assertEquals(name, direction, featureInstance.getDirection());
	}
}
