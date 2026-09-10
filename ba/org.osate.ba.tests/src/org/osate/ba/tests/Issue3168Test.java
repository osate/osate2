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
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.StringJoiner;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorTime;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.DispatchCondition;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * The AS5506/3 Rev. A D.4 {@code completion_relative_timeout_catch} production attaches a reset-port list to a
 * timeout: {@code timeout [ ( timeout_reset_port { or timeout_reset_port }* ) ] behavior_time}. A reset port is an
 * event port or an event data port, incoming or outgoing, and it only resets the timeout instead of taking part in the
 * dispatch condition. Verifies that such a timeout parses, that each listed name becomes a reset port of the matching
 * category in the strict model in the order written, that the behavior time survives beside the list, that the list
 * round-trips through the registered unparser, that a name which is not an event or event data port is rejected, and
 * that a reset-port list without a behavior time is rejected.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3168Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3168/";

	/**
	 * The strict shape of {@code Issue3168.aadl}: two completion relative timeouts with reset ports and one without,
	 * each keeping its own behavior time.
	 */
	private static final List<String> RESOLVED_TIMEOUTS = List.of(
			"single_reset -> CompletionRelativeTimeout 20 ms (EventPortHolder:heartbeat)",
			"several_resets -> CompletionRelativeTimeout 30 ms (EventDataPortHolder:reading, EventPortHolder:alarm,"
					+ " EventPortHolder:heartbeat)",
			"no_reset -> CompletionRelativeTimeout 40 ms ()");

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * Pins the reset port of each listed name and the behavior time beside it, reading {@code resetPorts} reflectively
	 * so that a run without the support reports the representation it did build rather than failing to compile.
	 */
	@Test
	public void completionRelativeTimeoutHoldsItsResetPorts() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3168.aadl");
		validationHelper.assertNoIssues(root);
		assertEquals(RESOLVED_TIMEOUTS, describeTimeouts(strictAnnex(root)));
	}

	/**
	 * Serializes a copy of the annex instead of the annex itself: the registered unparser returns the source text of
	 * anything that still has a node model, and the generated sequencers are what has to emit the reset-port list. The
	 * copy joins the parsed resource for the duration, because serializing the unit and classifier cross-references
	 * needs the scope that resource provides.
	 */
	@Test
	public void resetPortsRoundTripThroughTheUnparser() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3168.aadl");
		validationHelper.assertNoIssues(root);
		var copy = EcoreUtil.copy(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst().getParsedAnnexSubclause());

		final String serialized;
		root.eResource().getContents().add(copy);
		try {
			serialized = ((AnnexUnparserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID))
					.getAnnexUnparser("behavior_specification")
					.unparseAnnexSubclause(copy, "");
		} finally {
			root.eResource().getContents().remove(copy);
		}
		var normalized = serialized.replaceAll("\\s+", " ").replace("( ", "(").replace(" )", ")");
		assertTrue(serialized, normalized.contains("timeout (heartbeat) 20 ms"));
		assertTrue(serialized, normalized.contains("timeout (reading or alarm or heartbeat) 30 ms"));
		assertTrue(serialized, normalized.contains("timeout 40 ms"));

		var source = NodeModelUtils.getNode(root).getText();
		var reparsed = testHelper.parseString(source.substring(0, source.indexOf("{**") + 3) + serialized
				+ source.substring(source.indexOf("**}")));
		validationHelper.assertNoIssues(reparsed);
		assertEquals(RESOLVED_TIMEOUTS, describeTimeouts(strictAnnex(reparsed)));
	}

	@Test
	public void resetPortsAreEventOrEventDataPortsOnly() throws Exception {
		var notAResetPort = "' is not a timeout reset port: a completion relative timeout can only list event or event"
				+ " data ports";
		assertEquals(List.of("ERROR: 'cache" + notAResetPort, "ERROR: 'sample" + notAResetPort,
				"ERROR: 'tally" + notAResetPort), issues("TimeoutResetPortNames.aadl"));
	}

	@Test
	public void resetPortsRequireABehaviorTime() throws Exception {
		assertEquals(List.of("ERROR: A timeout with reset ports is a completion relative timeout, which must specify a"
				+ " behavior time"), issues("TimeoutResetPortsWithoutTime.aadl"));
	}

	private static BehaviorAnnex strictAnnex(final AadlPackage root) {
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

	private static List<String> describeTimeouts(final BehaviorAnnex annex) {
		return annex.getTransitions().stream().map(Issue3168Test::describe).toList();
	}

	private static String describe(final BehaviorTransition transition) {
		if (!(transition.getCondition() instanceof DispatchCondition dispatch)
				|| dispatch.getDispatchTriggerCondition() == null) {
			return transition.getName() + " -> <no dispatch trigger condition>";
		}
		var timeout = dispatch.getDispatchTriggerCondition();
		var description = new StringBuilder(transition.getName() + " -> " + timeout.eClass().getName());
		if (timeout instanceof BehaviorTime time) {
			description.append(' ')
					.append(time.getIntegerValue() instanceof IntegerLiteral literal ? literal.getValue()
							: time.getIntegerValue().eClass().getName())
					.append(' ')
					.append(name(time.getUnit()));
		}
		var resetPorts = timeout.eClass().getEStructuralFeature("resetPorts");
		if (resetPorts == null) {
			return description.append(" <no resetPorts feature>").toString();
		}
		var ports = new StringJoiner(", ", " (", ")");
		for (var port : (List<?>) timeout.eGet(resetPorts)) {
			ports.add(port instanceof ElementHolder holder
					? ((EObject) port).eClass().getName() + ":" + name(holder.getElement())
					: ((EObject) port).eClass().getName());
		}
		return description.append(ports).toString();
	}

	private static String name(final NamedElement element) {
		return element == null ? "<null>" : element.getName();
	}
}
