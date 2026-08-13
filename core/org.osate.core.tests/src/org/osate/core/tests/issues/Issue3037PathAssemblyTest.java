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
 * Characterizes across-first path assembly for issue #3037.
 *
 * <p>
 * A path key reads completeness, ultimate endpoints, and the traversed declarations
 * with their orientation and context. Those last three fields are what a materialized
 * connection instance records as its connection references, so they can be compared
 * directly with the baseline. The endpoints cannot be compared yet: a path that ends
 * at a feature group is narrowed to the leaf pair the baseline materializes by
 * feature-group expansion, which happens during materialization.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037PathAssemblyTest extends XtextTest {
	private static final String DUPLICATE = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";
	private static final String INTERNAL = "org.osate.core.tests/models/issue3027/Issue3027.aadl";
	private static final String NESTED = "org.osate.core.tests/models/issue3019/Issue3019.aadl";
	private static final String BOUNDARY = "org.osate.core.tests/models/issue3038/Issue3038.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/**
	 * Both orientations of the bidirectional pivot become paths, and their declaration
	 * order, orientation flags, and contexts match the two connection instances the
	 * baseline materializes exactly.
	 */
	@Test
	public void bothOrientationsBecomePaths() throws Exception {
		assertEquals(List.of(
				"complete|Sys_Imp_Instance.proc.fgPorts -> Sys_Imp_Instance.sub.iproc.fgPorts"
						+ " | decl7.0(f)@Sys_Imp_Instance,decl5.0(f)@Sys_Imp_Instance.sub,",
				"complete|Sys_Imp_Instance.sub.iproc.fgPorts -> Sys_Imp_Instance.proc.fgPorts"
						+ " | decl5.0(r)@Sys_Imp_Instance.sub,decl7.0(r)@Sys_Imp_Instance,"),
				paths(DUPLICATE, "Sys.Imp"));
	}

	/** One unidirectional pivot, one path, no leg segments to add. */
	@Test
	public void aSinglePivotBecomesOnePath() throws Exception {
		assertEquals(List.of("complete|Top_i_Instance.sensor.alarm -> Top_i_Instance.monitor.incoming"
				+ " | decl3.1(f)@Top_i_Instance,"), paths(INTERNAL, "Top.i"));
	}

	/**
	 * The assembly rule, confirmed against the baseline. A source leg walks outwards from
	 * the pivot, so the finished path needs it reversed and each of its segments
	 * re-oriented. The baseline reports this model's outgoing connection as declarations
	 * {@code up, nested_up, across} with contexts {@code leaf_side, producer_side, Top}
	 * and every reverse flag false, which is exactly what assembly produces from legs
	 * that were resolved reversed.
	 */
	@Test
	public void aSourceLegIsReversedAndReoriented() throws Exception {
		assertEquals(List.of(
				"complete|Top_i_Instance.producer_side.leaf_side.leaf.io -> Top_i_Instance.consumer_side.boundary"
						+ " | decl8.0(f)@Top_i_Instance.producer_side.leaf_side,"
						+ "decl10.0(f)@Top_i_Instance.producer_side,decl13.0(f)@Top_i_Instance,",
				"complete|Top_i_Instance.consumer_side.boundary -> Top_i_Instance.producer_side.leaf_side.leaf.io"
						+ " | decl13.0(r)@Top_i_Instance,decl10.0(r)@Top_i_Instance.producer_side,"
						+ "decl8.0(r)@Top_i_Instance.producer_side.leaf_side,"),
				paths(NESTED, "Top.i"));
	}

	/**
	 * A boundary seed produces an incomplete path with no pivot, in each direction its
	 * feature supports.
	 *
	 * <p>
	 * The count is checked against the baseline, which materializes both directions for
	 * this model since issue #3040. Before that fix it materialized only the outgoing
	 * one, and comparing across-first against it here is what exposed the missing
	 * inward connection.
	 * </p>
	 */
	@Test
	public void boundarySeedsProduceIncompletePathsInBothDirections() throws Exception {
		assertEquals(List.of(
				"incomplete|Producer_i_Instance.boundary -> Producer_i_Instance.leaf_side.leaf.io"
						+ " | decl6.0(r)@Producer_i_Instance,decl4.0(r)@Producer_i_Instance.leaf_side,",
				"incomplete|Producer_i_Instance.leaf_side.leaf.io -> Producer_i_Instance.boundary"
						+ " | decl4.0(f)@Producer_i_Instance.leaf_side,decl6.0(f)@Producer_i_Instance,"),
				paths(BOUNDARY, "Producer.i"));
		assertEquals("across-first assembles one path per connection instance the baseline materializes", 2,
				isolated.run(BOUNDARY, "Producer.i", "SOURCE_FIRST", false).instance()
						.getAllConnectionInstances()
						.size());
	}

	private List<String> paths(String model, String implementation) throws Exception {
		CharacterizationRun run = isolated.run(model, implementation, "SOURCE_FIRST", false);
		return run.pathKeys().stream().map(Issue3037PathAssemblyTest::compact).toList();
	}

	private static String compact(String key) {
		return key
				.replaceAll("[A-Za-z0-9]+\\.aadl#/0/@ownedPublicSection/@ownedClassifier\\.(\\d+)/@owned[A-Za-z]+\\.(\\d+)",
						"decl$1.$2")
				.replaceAll("\\|FeatureInstance\\|[a-zA-Z]+\\|\\d+", "")
				.replaceAll("\\|SystemInstance|\\|ComponentInstance", "");
	}
}
