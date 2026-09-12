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
package org.osate.ba.tests.characterization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.ba.tests.BehaviorAnnexInjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/**
 * States what AS5506/3 Rev. A requires of each Behavior Annex construct the current front end does not yet handle.
 * Every test here is a standard expectation: it passes only when the implementation conforms. A construct that is
 * still unimplemented is {@link Ignore}d and names the issue that tracks it, and
 * {@link #everyStandardExpectationNamesItsTrackingIssue()} enforces both that listing and the set of skips, so a skip
 * cannot be added silently.
 *
 * <p>
 * This class deliberately holds no record of today's nonconforming behavior. The exact diagnostics each fixture
 * currently produces are compared by {@link BehaviorAnnexValidatedDiagnosticsTest} against
 * {@code expected/diagnostics-validated}, with the BA validator registered exactly as it is here, and by
 * {@link BehaviorAnnexCharacterizationTest} against the plain-AADL {@code expected/diagnostics} baseline. Keeping the
 * message text in those goldens is what lets these expectations state the standard outcome alone.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class BehaviorAnnexConformanceTest {
	private static final String MODEL_DIRECTORY = "org.osate.ba.tests/models/characterization/conformance/";

	/**
	 * The standard expectations that are still skipped, each with the issue that tracks the missing implementation.
	 * G01 (#3165), G03 (#3167), G04 (#3168), G05 (#3169), G08 (#3172), and G10 (#3174) are absent because
	 * {@link #internalConditionIsAcceptedByTheStandard()}, {@link #frozenPortParenthesesAreAcceptedByTheStandard()},
	 * {@link #timeoutResetPortsAreAcceptedByTheStandard()}, {@link #shortCircuitOperatorsAreAcceptedByTheStandard()},
	 * {@link #selfPropertyReferenceIsAcceptedByTheStandard()}, and
	 * {@link #internalPortActionsAreAcceptedByTheStandard()} pass.
	 */
	private static final List<String> TRACKED_SKIPS = List.of(
			"externalConditionOperatorsAreAcceptedByTheStandard -> #3166",
			"unaryPlusIsRejectedByTheStandard -> #3170",
			"optionalLoopClassifierIsAcceptedByTheStandard -> #3173");

	/** The fixtures a standard expectation in this class asserts about. */
	private static final List<String> ASSERTED_FIXTURES = List.of("InternalCondition.aadl",
			"ExternalConditionXor.aadl", "ExternalConditionGrouping.aadl", "FrozenPortParentheses.aadl",
			"TimeoutResetPorts.aadl", "ShortCircuitOperators.aadl", "UnaryPlus.aadl", "PortUpdated.aadl",
			"SelfPropertyReference.aadl", "OptionalForClassifier.aadl", "OptionalForallClassifier.aadl",
			"InternalPortActions.aadl");

	@Inject
	private TestHelper<?> testHelper;

	@Test
	public void internalConditionIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("InternalCondition.aadl");
	}

	@Ignore("Issue #3166: implement all external-condition logical operators and grouping")
	@Test
	public void externalConditionOperatorsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("ExternalConditionXor.aadl");
		assertNoIssues("ExternalConditionGrouping.aadl");
	}

	@Test
	public void frozenPortParenthesesAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("FrozenPortParentheses.aadl");
	}

	@Test
	public void timeoutResetPortsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("TimeoutResetPorts.aadl");
	}

	@Test
	public void shortCircuitOperatorsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("ShortCircuitOperators.aadl");
	}

	@Ignore("Issue #3170: reject unary plus as required by AS5506/3 Rev A")
	@Test
	public void unaryPlusIsRejectedByTheStandard() throws Exception {
		assertSyntaxErrorOn("UnaryPlus.aadl", "+1");
	}

	@Test
	public void portUpdatedIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("PortUpdated.aadl");
	}

	@Test
	public void selfPropertyReferenceIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("SelfPropertyReference.aadl");
	}

	@Ignore("Issue #3173: make for and forall classifiers optional")
	@Test
	public void optionalLoopClassifierIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("OptionalForClassifier.aadl");
		assertNoIssues("OptionalForallClassifier.aadl");
	}

	@Test
	public void internalPortActionsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("InternalPortActions.aadl");
	}

	/**
	 * Requires every skipped expectation to name a tracking issue and to appear in {@link #TRACKED_SKIPS}. Without
	 * this, the backlog value of the skips depends on nobody adding an untracked one.
	 */
	@Test
	public void everyStandardExpectationNamesItsTrackingIssue() {
		final var actualSkips = new ArrayList<String>();
		final var untracked = new ArrayList<String>();
		for (final var method : BehaviorAnnexConformanceTest.class.getDeclaredMethods()) {
			final var ignore = method.getAnnotation(Ignore.class);
			if (method.getAnnotation(Test.class) == null || ignore == null) {
				continue;
			}
			final var issue = trackedIssue(ignore.value());
			if (issue == null) {
				untracked.add(method.getName() + " -> " + ignore.value());
			} else {
				actualSkips.add(method.getName() + " -> " + issue);
			}
		}

		assertEquals("Every skipped standard expectation must name its tracking issue as \"Issue #<number>: ...\"",
				List.of(), untracked);
		assertEquals("The skipped standard expectations and TRACKED_SKIPS must agree", new TreeSet<>(TRACKED_SKIPS),
				new TreeSet<>(actualSkips));
	}

	/**
	 * Requires every conformance fixture to carry a standard expectation. A fixture nothing asserts about records a
	 * gap without stating the required outcome.
	 */
	@Test
	public void everyConformanceFixtureHasAStandardExpectation() throws Exception {
		assertEquals("Every fixture in " + MODEL_DIRECTORY + " needs a standard expectation in this class",
				new TreeSet<>(ASSERTED_FIXTURES), fixtureNames());
	}

	private static String trackedIssue(final String reason) {
		if (reason == null || !reason.startsWith("Issue #")) {
			return null;
		}
		final var colon = reason.indexOf(':');
		if (colon < 0) {
			return null;
		}
		final var number = reason.substring("Issue #".length(), colon);
		return number.isEmpty() || !number.chars().allMatch(Character::isDigit) ? null : "#" + number;
	}

	private static Set<String> fixtureNames() throws Exception {
		final var directory = Paths.get(System.getProperty("user.dir")).toAbsolutePath().getParent()
				.resolve(MODEL_DIRECTORY);
		try (var files = Files.list(directory)) {
			final var result = new TreeSet<String>();
			files.map(path -> path.getFileName().toString())
					.filter(name -> name.endsWith(".aadl"))
					.forEach(result::add);
			return result;
		}
	}

	private void assertNoIssues(final String model) throws Exception {
		final var result = testHelper.testFile(MODEL_DIRECTORY + model);
		assertTrue(result.getSummary(), result.getIssues().isEmpty());
	}

	/**
	 * Requires exactly one syntax error covering {@code offendingText}, which must occur once in the fixture. Anchoring
	 * on the source text instead of a message keeps the expectation exact about where the standard requires a
	 * rejection without prescribing the wording a future parser will use.
	 */
	private void assertSyntaxErrorOn(final String model, final String offendingText) throws Exception {
		final var source = Files.readString(Paths.get(System.getProperty("user.dir")).toAbsolutePath().getParent()
				.resolve(MODEL_DIRECTORY + model), StandardCharsets.UTF_8);
		final var offset = source.indexOf(offendingText);
		assertTrue(model + " must contain " + offendingText, offset >= 0);
		assertEquals(offendingText + " must occur once in " + model + " for this expectation to be unambiguous", -1,
				source.indexOf(offendingText, offset + 1));

		final var issues = testHelper.testFile(MODEL_DIRECTORY + model).getIssues();
		final var covering = new ArrayList<String>();
		for (final Issue issue : issues) {
			if (issue.isSyntaxError() && issue.getOffset() != null && issue.getLength() != null
					&& issue.getOffset().intValue() <= offset
					&& offset < issue.getOffset().intValue() + issue.getLength().intValue()) {
				covering.add(issue.getMessage());
			}
		}
		final var reported = BehaviorAnnexCharacterizationTest.formatDiagnostics(issues);
		assertEquals("Expected one syntax error covering " + offendingText + " in " + model
				+ ". Diagnostics reported:\n" + (reported.isEmpty() ? "<none>\n" : reported), 1, covering.size());
	}
}
