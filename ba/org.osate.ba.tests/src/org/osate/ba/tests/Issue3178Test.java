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
package org.osate.ba.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Exercises AS5506/3 Rev. A D.3 mode-state refinement through ordinary embedded AADL validation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3178Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3178/";
	private static final String CHECKER = "org.osate.xtext.aadl2.ba.checker";
	private static final String MODE_REFINEMENT = "org.osate.xtext.aadl2.ba.modeRefinement";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void sameNamedCompleteStatesBindToSourceAndDestinationModes() throws Exception {
		var root = testHelper.parseFile(PATH + "Issue3178.aadl");
		validationHelper.assertNoIssues(root);
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		var owner = (ComponentClassifier) annex.getContainingClassifier();
		var strict = BehaviorAnnexUtil.getStrictModel(annex);
		assertSame(mode(owner, "idle"), state(strict, "idle").getBindedMode());
		assertSame(mode(owner, "active"), state(strict, "active").getBindedMode());
		assertSame(mode(owner, "idle"), strict.getTransitions().getFirst().getSourceState().getBindedMode());
		assertSame(mode(owner, "active"), strict.getTransitions().getFirst().getDestinationState().getBindedMode());
	}

	@Test
	public void mismatchedTriggerIsCheckedThroughEmbeddedValidation() throws Exception {
		assertDiagnostics("WrongTrigger", List.of(new Expected("wrong", CHECKER,
				"The behavior transition tries to refine a transition mode but it is not consisting with any "
						+ "transition mode of WrongTrigger::worker.impl component: Behavior Annex D.3.(C4) "
						+ "consistency rule failed.")));
	}

	@Test
	public void everyModeSourceOfExpandedTransitionIsChecked() throws Exception {
		var root = testHelper.parseFile(PATH + "MultipleSources.aadl");
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		var strict = BehaviorAnnexUtil.getStrictModel(annex);
		assertEquals(List.of("first", "second"), strict.getTransitions().stream()
				.map(transition -> transition.getSourceState().getBindedMode().getName()).toList());
		assertDiagnostics(root, List.of(new Expected("wrong", CHECKER,
				"The behavior transition tries to refine a transition mode but it is not consisting with any "
						+ "transition mode of MultipleSources::worker.impl component: Behavior Annex D.3.(C4) "
						+ "consistency rule failed.")));
	}

	@Test
	public void everyCompleteStateMustRepresentAModeOnceOneDoes() throws Exception {
		assertDiagnostics("MixedCompleteStates", List.of(new Expected("waiting", MODE_REFINEMENT,
				"Complete state 'waiting' must be a mode identifier because complete state 'idle' is a mode "
						+ "identifier: Behavior Annex D.3 legality rule failed.")));
	}

	@Test
	public void inModesSubclauseDoesNotBindCompleteStates() throws Exception {
		var root = testHelper.parseFile(PATH + "InModes.aadl");
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		assertEquals(1, annex.getInModes().size());
		assertNull(BehaviorAnnexUtil.getStrictModel(annex).getStates().getFirst().getBindedMode());
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		assertDiagnostics(testHelper.parseFile(PATH + model + ".aadl"), expected);
	}

	private void assertDiagnostics(AadlPackage root, List<Expected> expected) {
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			var target = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			return new Expected(target, issue.getCode(), issue.getMessage());
		}).toList());
	}

	private static Mode mode(ComponentClassifier owner, String name) {
		return owner.getAllModes().stream()
				.filter(mode -> name.equalsIgnoreCase(mode.getName()))
				.findFirst()
				.orElseThrow();
	}

	private static BehaviorState state(org.osate.ba.aadlba.BehaviorAnnex annex, String name) {
		return annex.getStates().stream()
				.filter(state -> name.equalsIgnoreCase(state.getName()))
				.findFirst()
				.orElseThrow();
	}

	private record Expected(String target, String code, String message) {
	}
}
