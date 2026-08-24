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
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * What instantiation makes of feature arrays. Like subcomponent array elements, the feature instances
 * all carry the name of the feature; unlike them, a feature instance is indexed with a single number
 * rather than a list, and that number starts at one for an array and is zero for a feature that is not
 * one.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class FeatureArrayInstantiationTest extends AbstractComponentInstantiationTest {
	private static final String FILE = "FeatureArrays.aadl";

	@Test
	public void featureArrayIsIndexedFromOne() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var thread = component(component(result.instance(), "p"), "t");

		var ports = features(thread, "ports");
		assertEquals(3, ports.size());
		assertEquals(List.of(1L, 2L, 3L), ports.stream().map(FeatureInstance::getIndex).toList());
		assertEquals(List.of("Top_i_Instance.p.t.ports[1]", "Top_i_Instance.p.t.ports[2]",
				"Top_i_Instance.p.t.ports[3]"), paths(ports));
		assertSame(ports.get(0).getFeature(), ports.get(2).getFeature());
		assertEquals(List.of("ports", "ports", "ports"), featureNames(thread));
	}

	@Test
	public void featureArrayOnASystemIsInstantiatedTheSameWay() throws Exception {
		var result = instantiate(FILE, "Top.i");
		var system = component(result.instance(), "s");

		var ports = features(system, "ports");
		assertEquals(2, ports.size());
		assertEquals(List.of(1L, 2L), ports.stream().map(FeatureInstance::getIndex).toList());
		assertEquals(List.of(), diagnostics(result));
	}

	/**
	 * A feature array on a classifier that may not have one, and a feature array declared inside a
	 * feature group type, are both instantiated as a single feature with a warning. The AADL validator
	 * rejects both, but instantiation can be run on a model that has errors, so both paths are reachable.
	 *
	 * <p>
	 * The neighbouring warning about a feature array with more than one dimension has no test, because
	 * the grammar accepts only one dimension on a feature, so no model can reach it.
	 * </p>
	 */
	@Test
	public void arrayWhereNoArrayIsAllowedBecomesASingleFeature() throws Exception {
		var result = instantiateIgnoringAadlIssues("InvalidFeatureArrays.aadl", "Top.i");
		var root = result.instance();

		String notAllowed = "Feature arrays are allowed only in abstract, thread, device, memory, system, and "
				+ "processor classifiers.";
		assertEquals(List.of("ERROR: " + notAllowed, "ERROR: " + notAllowed), result.aadlIssues());

		var onProcess = features(component(root, "p"), "ports");
		assertEquals(1, onProcess.size());
		assertEquals(0, onProcess.get(0).getIndex());
		assertEquals("Top_i_Instance.p.ports", path(onProcess.get(0)));

		var group = feature(component(root, "g"), "fg");
		assertEquals(List.of("inner"), featureNames(group));
		assertEquals(0, feature(group, "inner").getIndex());

		assertEquals(List.of("Warning Top_i_Instance.p.ports: No array allowed here, instantiated as a single feature",
				"Warning Top_i_Instance.g.fg.inner: No array allowed here, instantiated as a single feature"),
				diagnostics(result));
	}
}
