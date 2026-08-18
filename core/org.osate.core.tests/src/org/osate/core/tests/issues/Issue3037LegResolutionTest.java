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
 * Characterizes across-first leg resolution for issue #3037, against real models,
 * before joining exists.
 *
 * <p>
 * A leg key reads role, terminal endpoint, traversed declarations with their
 * orientation, and the terminal policy that stopped the walk. Element URIs are
 * compacted to {@code decl<classifier>.<member>} and the metaclass and category
 * suffixes of an instance key are dropped.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037LegResolutionTest extends XtextTest {
	private static final String DUPLICATE = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";
	private static final String INTERNAL = "org.osate.core.tests/models/issue3027/Issue3027.aadl";
	private static final String NESTED = "org.osate.core.tests/models/issue3019/Issue3019.aadl";
	private static final String BOUNDARY = "org.osate.core.tests/models/issue3038/Issue3038.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/**
	 * Neither peer has an implementation, so each leg stops at the feature group it
	 * starts from, except the one that descends the single declaration inside
	 * {@code sub.i}. The endpoints stay feature groups: narrowing them to the leaf pair
	 * the baseline materializes is feature-group expansion, which happens after joining,
	 * not during leg resolution.
	 */
	@Test
	public void legsStopAtComponentsWithoutAnImplementation() throws Exception {
		assertEquals(List.of("SOURCE_LEG|Sys_Imp_Instance.proc.fgPorts||component type only",
				"DESTINATION_LEG|Sys_Imp_Instance.sub.iproc.fgPorts|decl5.0(f),|component type only",
				"SOURCE_LEG|Sys_Imp_Instance.sub.iproc.fgPorts|decl5.0(f),|component type only",
				"DESTINATION_LEG|Sys_Imp_Instance.proc.fgPorts||component type only"),
				legs(DUPLICATE, "Sys.Imp"));
	}

	/** A thread, device, processor, or virtual processor ends a semantic connection. */
	@Test
	public void legsStopAtConnectionEndingComponents() throws Exception {
		assertEquals(List.of("SOURCE_LEG|Top_i_Instance.sensor.alarm||connection ending component",
				"DESTINATION_LEG|Top_i_Instance.monitor.incoming||connection ending component"),
				legs(INTERNAL, "Top.i"));
	}

	/**
	 * The case that decides whether legs work at all for feature groups. Standing at
	 * {@code producer_side.boundary}, the only continuing declaration reaches into a
	 * <em>member</em> of that feature group rather than connecting it whole, so a leg
	 * that demanded an exact endpoint match would stop immediately and lose the path.
	 * Accepting a declaration that touches the feature or anything nested in it lets the
	 * leg descend two levels to the thread port, which is the ultimate source the
	 * baseline reports.
	 *
	 * <p>
	 * That declaration continues one member of {@code leaf_side.boundary} and leaves the
	 * other with nowhere to go, so a destination leg also stops at {@code beta}. Nothing
	 * inside a process ends a connection and {@code beta} triggers no mode transition, so
	 * that leg is a dead end: the baseline reports the same member and creates no
	 * connection instance for it either.
	 * </p>
	 */
	@Test
	public void legsDescendIntoFeatureGroupMembers() throws Exception {
		assertEquals(List.of(
				"SOURCE_LEG|Top_i_Instance.producer_side.leaf_side.leaf.io"
						+ "|decl10.0(r),decl8.0(r),|connection ending component",
				"DESTINATION_LEG|Top_i_Instance.consumer_side.boundary||component type only",
				"SOURCE_LEG|Top_i_Instance.consumer_side.boundary||component type only",
				"DESTINATION_LEG|Top_i_Instance.producer_side.leaf_side.boundary.beta"
						+ "|decl10.0(r),|nothing continues this member",
				"DESTINATION_LEG|Top_i_Instance.producer_side.leaf_side.leaf.io"
						+ "|decl10.0(r),decl8.0(r),|connection ending component"),
				legs(NESTED, "Top.i"));
	}

	/**
	 * A boundary seed has one leg, and it descends the same way an across seed's leg
	 * does. Both directions reach the thread port here because the boundary feature is
	 * bidirectional; only the outgoing direction survives in the baseline, so direction
	 * filtering belongs to joining rather than to leg resolution.
	 */
	@Test
	public void boundarySeedsResolveOneLegEach() throws Exception {
		assertEquals(List.of(
				"DESTINATION_LEG|Producer_i_Instance.leaf_side.leaf.io"
						+ "|decl6.0(r),decl4.0(r),|connection ending component",
				"SOURCE_LEG|Producer_i_Instance.leaf_side.leaf.io"
						+ "|decl6.0(r),decl4.0(r),|connection ending component"),
				legs(BOUNDARY, "Producer.i"));
	}

	private List<String> legs(String model, String implementation) throws Exception {
		CharacterizationRun run = isolated.run(model, implementation, "SOURCE_FIRST", false);
		return run.legKeys().stream().map(Issue3037LegResolutionTest::compact).toList();
	}

	private static String compact(String key) {
		return key
				.replaceAll("[A-Za-z0-9]+\\.aadl#/0/@ownedPublicSection/@ownedClassifier\\.(\\d+)/@owned[A-Za-z]+\\.(\\d+)",
						"decl$1.$2")
				.replaceAll("\\|FeatureInstance\\|[a-zA-Z]+\\|\\d+", "");
	}
}
