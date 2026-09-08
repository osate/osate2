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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/**
 * Verifies where Behavior Annex legality diagnostics are attached. A rule that constrains a transition must mark that
 * transition, and a rule whose message names offending states must mark those state declarations, rather than an
 * unrelated element that is legal on its own.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3155Test {
	private static final String MODEL = "org.osate.ba.tests/models/issue3155/Issue3155.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void transitionRulesMarkTheTransitionOnce() throws Exception {
		var dispatchOutOfIncompleteState = "on dispatch"
				+ " => Only transition out of complete states may have dispatch condition :"
				+ " Behavior Annex D.3.(L6) legality rule failed.";
		assertEquals(List.of(
				"waitState -[]-> doneState;"
						+ " => Transitions out of complete states must have dispatch condition :"
						+ " Behavior Annex D.3.(L7) legality rule failed.",
				dispatchOutOfIncompleteState,
				"doneState -[]-> readyState;" + " => Transitions out of final states are not allowed :"
						+ " Behavior Annex D.3.(L8) legality rule failed.",
				dispatchOutOfIncompleteState,
				// The checkers see one transition per source state, so this failure is found twice; the user sees it
				// once, on the transition that carries it.
				"firstWait, secondWait -[]-> readyState;"
						+ " => Transitions out of complete states must have dispatch condition :"
						+ " Behavior Annex D.3.(L7) legality rule failed."),
				markedText("D.3.(L6)", "D.3.(L7)", "D.3.(L8)"));
	}

	@Test
	public void subprogramStateRulesMarkTheNamedStates() throws Exception {
		assertEquals(List.of(
				"firstInitial => issue3155::subprogramLegality.impl can't have more than one initial state :"
						+ " firstInitial, secondInitial : Behavior Annex D.3.(L1) legality rule failed.",
				"secondInitial => issue3155::subprogramLegality.impl can't have more than one initial state :"
						+ " firstInitial, secondInitial : Behavior Annex D.3.(L1) legality rule failed.",
				"waitState => issue3155::subprogramLegality.impl can't have complete state :"
						+ " waitState : Behavior Annex D.3.(L2) legality rule failed.",
				"firstFinal => issue3155::subprogramLegality.impl has more than one final state :"
						+ " firstFinal, secondFinal : Behavior Annex D.3.(L1) legality rule failed.",
				"secondFinal => issue3155::subprogramLegality.impl has more than one final state :"
						+ " firstFinal, secondFinal : Behavior Annex D.3.(L1) legality rule failed."),
				markedText("D.3.(L1)", "D.3.(L2)"));
	}

	@Test
	public void threadStateRuleMarksTheNamedStates() throws Exception {
		assertEquals(List.of(
				"firstInitial => issue3155::threadLegality.impl can't have more than one initial state :"
						+ " firstInitial, secondInitial : Behavior Annex D.3.(L3) legality rule failed.",
				"secondInitial => issue3155::threadLegality.impl can't have more than one initial state :"
						+ " firstInitial, secondInitial : Behavior Annex D.3.(L3) legality rule failed."),
				markedText("D.3.(L3)"));
	}

	/**
	 * Describes every diagnostic of the given rules as the source text it marks followed by its message, in document
	 * order. The marked text is what makes the attachment visible: an offending transition and a legal state
	 * declaration are different regions of the same subclause.
	 */
	private List<String> markedText(final String... rules) throws Exception {
		var source = Files.readString(Path.of(System.getProperty("user.dir"), "..", MODEL));
		return testHelper.testFile(MODEL)
				.getIssues()
				.stream()
				.filter(issue -> Stream.of(rules).anyMatch(rule -> issue.getMessage().contains(rule)))
				.sorted(Comparator.comparing(Issue::getOffset))
				.map(issue -> source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()).strip()
						+ " => " + issue.getMessage())
				.toList();
	}
}
