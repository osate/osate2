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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two traversal strategies over structural expansion, for issue #3037.
 *
 * <p>
 * Enumeration hands the pipeline in {@code InstantiateModel.finalizeConnections()} one
 * provisional connection instance per declaration, and that pipeline replicates it across
 * component arrays, applies {@code Connection_Pattern} and {@code Connection_Set}, and
 * deletes the provisional instance. Across-first must feed it exactly what source-first
 * feeds it, which these fixtures are what checks: they cover replication, every pattern
 * the corpus declares, matched and crossed connection sets, the same properties supplied
 * directly, contextually, by refinement, and per mode, and array indices on a contained
 * property association.
 * </p>
 *
 * <p>
 * The models belong to the Plan 1 issues that repaired this pipeline, so a disagreement
 * here is about what across-first hands over, not about the expansion itself.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037StructuralExpansionTest extends XtextTest {
	private static final String EXPANSION = "org.osate.core.tests/models/issue3032/Issue3032.aadl";
	private static final String SET = "org.osate.core.tests/models/issue3032/Issue3032Set.aadl";
	private static final String PROPERTIES = "org.osate.core.tests/models/issue3032/Issue3032Properties.aadl";
	private static final String VALIDATION = "org.osate.core.tests/models/issue3032/Issue3032Validation.aadl";
	private static final String CONTAINED = "org.osate.core.tests/models/issue3032/Issue3032ContainedProperties.aadl";
	private static final String ENDPOINTS = "org.osate.core.tests/models/issue3017/Issue3017.aadl";
	private static final String CONTEXTS = "org.osate.core.tests/models/issue3034/Issue3034.aadl";
	private static final String NESTED_ARRAYS = "org.osate.core.tests/models/issue3034/Issue3034Nested.aadl";
	private static final String ONE_TO_ALL = "org.osate.core.tests/models/Issue2057/port_to_port.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/** An array of producers and an array of consumers, expanded and then flowed over. */
	@Test
	public void arrayReplicationAgrees() throws Exception {
		assertConnections(EXPANSION, "Container.i", "producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(EXPANSION, "Top.i", "producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(ENDPOINTS, "Container.i");
		assertConnections(ENDPOINTS, "Top.i");
	}

	/**
	 * Where the pattern comes from must not matter: on the connection, on the enclosing
	 * implementation, on a refined connection, or per mode.
	 */
	@Test
	public void connectionPatternAgrees() throws Exception {
		assertConnections(PROPERTIES, "Direct.i", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[2].inp", "producers[2].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(PROPERTIES, "Top.direct", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[2].inp", "producers[2].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(PROPERTIES, "Top.contextual", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[2].inp", "producers[2].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(PROPERTIES, "Top.inheriting", "producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(PROPERTIES, "Top.modal", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[2].inp", "producers[2].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(VALIDATION, "Container.i", "producers[1].outp --> consumer.inp",
				"producers[2].outp --> consumer.inp");
		assertConnections(VALIDATION, "Top.i", "producers[1].outp --> consumer.inp",
				"producers[2].outp --> consumer.inp");
		assertConnections(ONE_TO_ALL, "top.impl", "src.op --> threads[1].ip", "src.op --> threads[2].ip",
				"src.op --> threads[3].ip", "src.op --> threads[4].ip", "src.op --> threads[5].ip",
				"src.op --> threads[6].ip", "src.op --> threads[7].ip", "src.op --> threads[8].ip",
				"threads[1].ip --> src.op", "threads[2].ip --> src.op", "threads[3].ip --> src.op",
				"threads[4].ip --> src.op", "threads[5].ip --> src.op", "threads[6].ip --> src.op",
				"threads[7].ip --> src.op", "threads[8].ip --> src.op");
	}

	/**
	 * Matched index pairs, crossed index pairs, and a set supplied contextually. The
	 * crossed case is the one where the declared end-to-end flow cannot be built, so its
	 * comparison covers the resulting diagnostics as well.
	 */
	@Test
	public void connectionSetAgrees() throws Exception {
		assertConnections(SET, "Matched.i", "producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(SET, "Crossed.i", "producers[1].outp --> consumers[2].inp",
				"producers[2].outp --> consumers[1].inp");
		assertConnections(SET, "Top.matched", "producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(SET, "Top.crossed", "producers[1].outp --> consumers[2].inp",
				"producers[2].outp --> consumers[1].inp");
		assertConnections(PROPERTIES, "Top.contextualSet", "producers[1].outp --> consumers[2].inp");
	}

	/** A contained property association that names array indices. */
	@Test
	public void containedPropertiesOnArrayElementsAgree() throws Exception {
		assertConnections(CONTAINED, "Inner.i", "producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(CONTAINED, "Top.uniform", "producers[1].outp --> consumers[1].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(CONTAINED, "Top.perElement", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[1].inp", "producers[2].outp --> consumers[2].inp",
				"producers[2].outp --> consumers[2].inp");
	}

	/**
	 * Replicated connection references and their contexts, including the nested arrays
	 * whose later elements are produced by replication rather than by enumeration.
	 */
	@Test
	public void replicatedReferenceContextsAgree() throws Exception {
		assertConnections(CONTEXTS, "Top.first", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[1].inp", "producers[2].outp --> consumers[2].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(CONTEXTS, "Top.second", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[1].inp", "producers[2].outp --> consumers[2].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(CONTEXTS, "Top.noIndex", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[1].inp", "producers[2].outp --> consumers[2].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(CONTEXTS, "Top.componentTarget", "producers[1].outp --> consumers[1].inp",
				"producers[1].outp --> consumers[1].inp", "producers[2].outp --> consumers[2].inp",
				"producers[2].outp --> consumers[2].inp");
		assertConnections(NESTED_ARRAYS, "Top.i", "producer_side.p.outp --> consumer_side.cs.inp",
				"producer_side.p.outp -> consumer_side.cs.inp");
	}

	private void assertConnections(String model, String implementation, String... expected) throws Exception {
		InstanceCharacterization.assertConnections(isolated, model, implementation, expected);
	}
}
