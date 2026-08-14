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
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.core.tests.instantiation.StrategyDifference;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two traversal strategies over modes, system operation modes, and
 * end-to-end flows, for issue #3037.
 *
 * <p>
 * Across-first carries a path's mode constraint without enforcing it, exactly as
 * source-first does: a topologically valid path is materialized, the shared pipeline
 * computes its system operation modes, and a path active in none of them is reported and
 * deleted. Deciding earlier would change which diagnostics a model produces, so
 * {@code Top.noSom} is here to prove that the decision is still made where it was.
 * </p>
 *
 * <p>
 * End-to-end flows are built from the connection collection, whose order allowlist entry 1
 * releases, so sibling flows are compared as a keyed multiset while the ordered element
 * sequence inside each flow is compared exactly. {@code Top.siblingFlows} declares three
 * flows over the same connections to make that distinction bite.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037ModeAndFlowTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/ModesAndFlows.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void theFixtureIsValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));
	}

	/** Modes on the pivot and on both legs inside a component with a mode machine of its own. */
	@Test
	public void modesAtEveryPathPositionAgree() throws Exception {
		assertSameModel("Middle.i");
		assertSameModel("Top.modalLegs");
	}

	/**
	 * A path whose modes admit no system operation mode: reported and deleted, not skipped.
	 * Asserted directly as well as comparatively, so the case cannot go vacuous if some
	 * later change stops producing the path at all.
	 */
	@Test
	public void aPathActiveInNoSystemOperationModeAgrees() throws Exception {
		assertSameModel("Top.noSom");

		CharacterizationRun run = isolated.run(MODEL, "Top.noSom", "ACROSS_FIRST", false);
		InstanceSnapshot snapshot = InstanceSnapshot.of(run.instance(), run.errorManager());
		assertEquals(List.of(), InstanceReport.connectionLines(snapshot));
		assertEquals(List.of("Warning | Connection feeder.emitter.outp -> drain.receiver.inp was removed because it is"
				+ " not active in any system operation mode | at Top_noSom_Instance|SystemInstance"
				+ " | in ModesAndFlows_Top_noSom_Instance.aaxl2"), InstanceReport.diagnosticSet(snapshot));
	}

	/** A modal component array with a pattern, so mode assignment and expansion both apply. */
	@Test
	public void modalArrayExpansionAgrees() throws Exception {
		assertSameModel("Top.modalArray");
	}

	/**
	 * Three sibling end-to-end flows over the same connections, each in its own modes. The
	 * count is asserted so that the comparison cannot pass by both strategies producing no
	 * flows, and each flow's ordered element sequence is what the comparison checks exactly.
	 */
	@Test
	public void siblingEndToEndFlowsAgree() throws Exception {
		assertSameModel("Top.siblingFlows");

		CharacterizationRun run = isolated.run(MODEL, "Top.siblingFlows", "ACROSS_FIRST", false);
		InstanceSnapshot snapshot = InstanceSnapshot.of(run.instance(), run.errorManager());
		assertEquals(3, InstanceReport.flowLines(snapshot).size());
	}

	private void assertSameModel(String implementation) throws Exception {
		StrategyDifference.assertSameModel(isolated, MODEL, implementation);
	}
}
