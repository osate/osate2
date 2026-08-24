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
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * The two guards that keep instantiation from recursing forever on a model that contains itself. The
 * AADL validator rejects both shapes, but nothing keeps {@code InstantiateModel} from being run on a
 * model that has errors, so both guards are reachable and both are what stands between such a model and
 * a stack overflow.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class CyclicContainmentInstantiationTest extends AbstractComponentInstantiationTest {

	/**
	 * Two implementations that contain each other. The hierarchy is built until a subcomponent turns up
	 * that is already in its own ancestry, and that subcomponent is reported instead of instantiated.
	 */
	@Test
	public void subcomponentThatContainsItselfIsReportedOnce() throws Exception {
		var result = instantiateIgnoringAadlIssues("CyclicContainment.aadl", "Top.i");
		var root = result.instance();

		assertEquals(List.of("ERROR: Invalid circular dependency. Subcomponent 'b' directly or indirectly contains "
				+ "'A.i'.",
				"ERROR: Invalid circular dependency. Subcomponent 'a' directly or indirectly contains 'B.i'.",
				"ERROR: Invalid circular dependency. Subcomponent 'a' directly or indirectly contains 'Top.i'."),
				result.aadlIssues());

		var outer = component(root, "a");
		var middle = component(outer, "b");
		var inner = component(middle, "a");
		assertEquals("Top_i_Instance.a.b.a", path(inner));
		assertTrue(inner.getComponentInstances().isEmpty());
		assertEquals(List.of("Error Top_i_Instance.a.b.a: Cyclic containment dependency: Subcomponent 'b' has "
				+ "already been instantiated as enclosing component."), diagnostics(result));
	}

	/**
	 * A feature group type that contains itself. One level of the member is created, and the expansion of
	 * that member stops with the feature reported on the feature instance being expanded.
	 */
	@Test
	public void featureGroupThatContainsItselfIsReportedOnce() throws Exception {
		var result = instantiateIgnoringAadlIssues("CyclicFeatureGroup.aadl", "Top.i");

		assertEquals(List.of("ERROR: Feature group directly or indirectly contains itself"), result.aadlIssues());

		var group = feature(result.instance(), "fg");
		assertEquals(List.of("self_ref"), featureNames(group));
		var member = feature(group, "self_ref");
		assertTrue(member.getFeatureInstances().isEmpty());
		assertEquals(List.of("Error Top_i_Instance.fg.self_ref: Cyclic containment dependency: Feature 'self_ref' "
				+ "has already been instantiated as enclosing feature group."), diagnostics(result));
	}
}
