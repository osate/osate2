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

import java.util.List;
import java.util.StringJoiner;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * The AS5506/3 Rev. A D.3 {@code internal_condition} production guards a transition with {@code on internal} and a list
 * of the containing component's internal event or internal event data features. Verifies that such a condition parses,
 * that each listed name becomes an internal port holder of the matching category in the strict model, that the D.3 rule
 * confining internal conditions to transitions out of execution states is enforced, that a name which is not an internal
 * port is rejected, and that D.6.(L11) keeps an internal condition out of a subclause that also sends an internal
 * feature.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3165Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3165/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * Pins the strict condition metaclass and the holder of each listed name, comparing metaclass names so that a run
	 * without the internal-condition support reports the representation it did build rather than failing to compile.
	 */
	@Test
	public void internalConditionHoldsItsInternalPorts() throws Exception {
		assertEquals(List.of("enter_working -> <no condition>",
				"react_to_event -> InternalCondition(EventSourceHolder:first_event)",
				"react_to_either -> InternalCondition(EventSourceHolder:first_event, "
						+ "EventDataSourceHolder:second_event)"),
				strictAnnex().getTransitions().stream().map(Issue3165Test::describe).toList());
	}

	/**
	 * The last diagnostic is the pre-existing D.3.(L7) rule, which the complete-state transition also breaks: the
	 * standard requires a dispatch condition there, so an internal condition is doubly wrong on it.
	 */
	@Test
	public void internalConditionsLeaveExecutionStatesOnly() throws Exception {
		var executionStates = "Only transitions out of execution states may have an internal condition, and a state"
				+ " qualified as initial, complete, or final is not an execution state : Behavior Annex D.3 legality"
				+ " rule failed.";
		assertEquals(List.of("ERROR: " + executionStates, "ERROR: " + executionStates,
				"ERROR: Transitions out of complete states must have dispatch condition : Behavior Annex D.3.(L7)"
						+ " legality rule failed."),
				issues("InternalConditionSources.aadl"));
	}

	@Test
	public void internalConditionListsInternalPortsOnly() throws Exception {
		var notAnInternalPort = "' is not an internal port: an internal condition can only list internal event or"
				+ " internal event data features";
		assertEquals(List.of("ERROR: 'progress" + notAnInternalPort, "ERROR: 'tally" + notAnInternalPort,
				"ERROR: 'trigger" + notAnInternalPort), issues("InternalConditionNames.aadl"));
	}

	@Test
	public void internalConditionDoesNotShareItsSubclauseWithAnInternalSend() throws Exception {
		assertEquals(List.of("ERROR: An internal condition cannot be in the same behavior annex subclause as a send"
				+ " action on an internal feature : Behavior Annex D.6.(L11) legality rule failed."),
				issues("InternalConditionAndSend.aadl"));
	}

	private BehaviorAnnex strictAnnex() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3165.aadl");
		validationHelper.assertNoIssues(root);
		return BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
	}

	/**
	 * Sorted, because the order in which Xtext hands back the issues of one resource is not the order the checkers
	 * report them in and is not stable across runs.
	 */
	private List<String> issues(final String model) throws Exception {
		return testHelper.testFile(MODELS + model)
				.getIssues()
				.stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
				.sorted()
				.toList();
	}

	private static String describe(final BehaviorTransition transition) {
		var condition = transition.getCondition();
		if (condition == null) {
			return transition.getName() + " -> <no condition>";
		}
		var ports = new StringJoiner(", ", condition.eClass().getName() + "(", ")");
		ports.setEmptyValue(condition.eClass().getName());
		for (var child : condition.eContents()) {
			ports.add(child instanceof ElementHolder holder
					? child.eClass().getName() + ":" + name(holder.getElement())
					: child.eClass().getName());
		}
		return transition.getName() + " -> " + ports;
	}

	private static String name(final NamedElement element) {
		return element == null ? "<null>" : element.getName();
	}
}
