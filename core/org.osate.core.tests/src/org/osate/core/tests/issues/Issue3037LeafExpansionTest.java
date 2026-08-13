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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the endpoints across-first traversal arrives at with the endpoints the
 * baseline materializes, for issue #3037.
 *
 * <p>
 * A leg stops where declarations stop, so a path can end at a feature group while the
 * baseline creates one connection instance per pair of connected leaves. Leaf
 * expansion closes that gap. Each test asserts the expanded pairs against the
 * connection instances of the same run, so the expectation comes from the baseline
 * rather than from a hardcoded list.
 * </p>
 *
 * <p>
 * These fixtures contain no component arrays, {@code Connection_Pattern}, or
 * {@code Connection_Set}. Those are expanded later, on materialized connection
 * instances, so for such a model the expanded pairs are the provisional endpoints and
 * would legitimately differ from the final connection set.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037LeafExpansionTest extends XtextTest {
	private static final String DUPLICATE = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";
	private static final String INTERNAL = "org.osate.core.tests/models/issue3027/Issue3027.aadl";
	private static final String NESTED = "org.osate.core.tests/models/issue3019/Issue3019.aadl";
	private static final String BOUNDARY = "org.osate.core.tests/models/issue3038/Issue3038.aadl";
	private static final String FLAT_AND_NESTED = "org.osate.core.tests/models/issue3040/Issue3040.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/** Two inverse feature groups, expanded to the leaf pair in each orientation. */
	@Test
	public void inverseFeatureGroupsExpandToLeaves() throws Exception {
		assertSameEndpoints(DUPLICATE, "Sys.Imp");
	}

	/** A leaf-to-leaf path, with the connection into an internal feature ignored. */
	@Test
	public void leafEndpointsNeedNoExpansion() throws Exception {
		assertSameEndpoints(INTERNAL, "Top.i");
	}

	/** One end a thread port, the other reached two feature group levels down. */
	@Test
	public void nestedFeatureGroupsExpandOnOneSide() throws Exception {
		assertSameEndpoints(NESTED, "Top.i");
	}

	/** Subset classifier matching pairs members by name and skips the rest. */
	@Test
	public void subsetMatchingPairsByName() throws Exception {
		assertSameEndpoints(NESTED, "SubsetTop.i");
	}

	/** Incomplete boundary paths in both directions. */
	@Test
	public void boundaryPathsExpandToLeaves() throws Exception {
		assertSameEndpoints(BOUNDARY, "Producer.i");
	}

	/** Nesting a boundary feature group changes only how deep the leaves sit. */
	@Test
	public void nestingDoesNotChangeTheEndpointSet() throws Exception {
		assertSameEndpoints(FLAT_AND_NESTED, "Flat.i");
		assertSameEndpoints(FLAT_AND_NESTED, "Nested.i");
	}

	private void assertSameEndpoints(String model, String implementation) throws Exception {
		CharacterizationRun run = isolated.run(model, implementation, "SOURCE_FIRST", false);

		List<String> baseline = run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(connection -> connection.getSource().getInstanceObjectPath() + " -> "
						+ connection.getDestination().getInstanceObjectPath())
				.sorted()
				.toList();
		List<String> expanded = run.expandedKeys()
				.stream()
				.map(Issue3037LeafExpansionTest::compact)
				.distinct()
				.sorted()
				.toList();

		assertEquals(implementation, baseline, expanded);
	}

	private static String compact(String key) {
		return key.replaceAll("\\|FeatureInstance\\|[a-zA-Z]+\\|\\d+", "")
				.replaceAll("\\|ComponentInstance|\\|SystemInstance", "");
	}
}
