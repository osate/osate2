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
import static org.junit.Assert.assertTrue;

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
 * Characterizes across-first seed discovery for issue #3037, against real models,
 * before legs and joining exist.
 *
 * <p>
 * Seed keys are compacted before comparison: element URIs collapse to
 * {@code decl<classifier>.<member>} and the metaclass and category suffixes of an
 * instance key are dropped. What remains is what the assertions are about — which
 * declaration, in which orientation, between which endpoints — without pinning
 * details that are asserted elsewhere.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037SeedDiscoveryTest extends XtextTest {
	private static final String DUPLICATE = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";
	private static final String BOUNDARY = "org.osate.core.tests/models/issue3038/Issue3038.aadl";
	private static final String INTERNAL = "org.osate.core.tests/models/issue3027/Issue3027.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/**
	 * The issue #565 model has one across declaration, {@code c1} between the two
	 * peers, and it is bidirectional, so it seeds both legal orientations. The two
	 * seeds differ in orientation, in endpoint pair, and in the order of their feature
	 * chains, which is what keeps the two connection instances the baseline
	 * materializes distinct.
	 *
	 * <p>
	 * {@code c2}, which descends from the enclosing feature group into {@code iproc},
	 * is deliberately absent: it does not cross between peers, so it is a leg segment
	 * rather than a pivot.
	 * </p>
	 */
	@Test
	public void bidirectionalAcrossDeclarationSeedsBothOrientations() throws Exception {
		CharacterizationRun run = isolated.run(DUPLICATE, "Sys.Imp", "SOURCE_FIRST", false);

		assertEquals(List.of(
				"across|decl7.0@Sys_Imp_Instance|forward"
						+ "|Sys_Imp_Instance.proc.fgPorts->Sys_Imp_Instance.sub.fgPorts"
						+ "|decl2.0@Sys_Imp_Instance.proc.fgPorts/|decl4.0@Sys_Imp_Instance.sub.fgPorts/",
				"across|decl7.0@Sys_Imp_Instance|reverse"
						+ "|Sys_Imp_Instance.sub.fgPorts->Sys_Imp_Instance.proc.fgPorts"
						+ "|decl4.0@Sys_Imp_Instance.sub.fgPorts/|decl2.0@Sys_Imp_Instance.proc.fgPorts/"),
				compact(run));
		assertEquals(Long.valueOf(2), run.counters().get("SEEDS_DISCOVERED"));
	}

	/**
	 * The issue #3038 model crosses between no peers, so it has no across seed. Its
	 * boundary feature group is bidirectional and is therefore seeded in both
	 * directions.
	 *
	 * <p>
	 * The point of this test is the seed that is <em>not</em> here. Source-first
	 * traversal seeds a boundary feature group and, separately, every feature contained
	 * in it, so the contained-member seed re-enumerates a path the enclosing seed
	 * already covers; that redundant seed is what crashed in issue #3038, and its
	 * correct outcome turned out to be to produce nothing. Across-first does not
	 * generate it at all. Reaching into the feature group is the job of the
	 * declaration's own connected-element chain.
	 * </p>
	 */
	@Test
	public void boundarySeedsAreTopLevelOnly() throws Exception {
		CharacterizationRun run = isolated.run(BOUNDARY, "Producer.i", "SOURCE_FIRST", false);

		assertEquals(List.of("boundary|Producer_i_Instance.boundary|in", "boundary|Producer_i_Instance.boundary|out"),
				compact(run));
		assertTrue("no seed may be created for a feature contained in a boundary feature group",
				run.seedKeys().stream().noneMatch(key -> key.contains("boundary.inner")));
	}

	/**
	 * A connection into an internal feature is ignored, and it is not a pivot either.
	 *
	 * <p>
	 * An internal feature is never instantiated: the instance metamodel has no feature
	 * category for one, so it can never be the endpoint of a connection instance, and
	 * since issue #3028 the declarative validator rejects it at a destination outright.
	 * {@code to_internal} therefore yields no seed of any kind, while the ordinary
	 * peer-to-peer connection beside it does. That places the terminal policy in leg
	 * resolution rather than in seeding: the connection is not an across declaration, so
	 * seeding never considers it.
	 * </p>
	 */
	@Test
	public void connectionIntoAnInternalFeatureIsNotSeeded() throws Exception {
		CharacterizationRun run = isolated.run(INTERNAL, "Top.i", "SOURCE_FIRST", false);

		assertEquals(List.of("across|decl3.1@Top_i_Instance|forward"
				+ "|Top_i_Instance.sensor.alarm->Top_i_Instance.monitor.incoming"
				+ "|decl0.0@Top_i_Instance.sensor.alarm/|decl1.0@Top_i_Instance.monitor.incoming/"), compact(run));
		assertTrue("no seed may refer to an internal feature",
				run.seedKeys().stream().noneMatch(key -> key.contains("raised_event")));
	}

	private static List<String> compact(CharacterizationRun run) {
		return run.seedKeys().stream().map(Issue3037SeedDiscoveryTest::compact).toList();
	}

	private static String compact(String key) {
		return key
				.replaceAll("[A-Za-z0-9]+\\.aadl#/0/@ownedPublicSection/@ownedClassifier\\.(\\d+)/@owned[A-Za-z]+\\.(\\d+)",
						"decl$1.$2")
				.replaceAll("\\|FeatureInstance\\|[a-zA-Z]+\\|\\d+", "")
				.replaceAll("\\|SystemInstance", "")
				.replaceAll("\\|ComponentInstance", "");
	}
}
