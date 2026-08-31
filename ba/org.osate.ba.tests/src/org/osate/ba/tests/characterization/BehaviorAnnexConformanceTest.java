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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisToParseErrorReporterAdapter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingParseErrorReporter.Message;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.AadlBaParserAction;
import org.osate.ba.AadlBaResolver;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;

/**
 * Records the Behavior Annex constructs required by AS5506/3 Rev A but not implemented by the current parser,
 * resolver, or type checker. Each active test pins today's legacy-front-end behavior, while the paired ignored test
 * states the standard-conforming outcome that the Xtext implementation may satisfy as part of issue #2445. The Xtext
 * parser is not required to reproduce the legacy rejection.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class BehaviorAnnexConformanceTest {
	private static final String MODEL_DIRECTORY = "org.osate.ba.tests/models/characterization/conformance/";

	@Inject
	private TestHelper<?> testHelper;

	@Test
	public void internalConditionCurrentFailure() throws Exception {
		assertDiagnostics("InternalCondition.aadl",
				List.of("syntax | extraneous input 'first_event' expecting {'and', 'or', '[', ']->', '.'}"));
	}

	@Ignore("Issue #2445: implement internal conditions")
	@Test
	public void internalConditionIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("InternalCondition.aadl");
	}

	@Test
	public void externalConditionOperatorsCurrentFailure() throws Exception {
		assertDiagnostics("ExternalConditionXor.aadl",
				List.of("syntax | mismatched input 'xor' expecting {'and', 'or', '[', ']->', '.'}"));
		assertDiagnostics("ExternalConditionGrouping.aadl",
				List.of("syntax | extraneous input 'or' expecting {<EOF>, IDENT}",
						"syntax | no viable alternative at input 'on('",
						"syntax | unterminated behavior transition (missing ending ';')"));
	}

	@Ignore("Issue #2445: implement all external-condition logical operators and grouping")
	@Test
	public void externalConditionOperatorsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("ExternalConditionXor.aadl");
		assertNoIssues("ExternalConditionGrouping.aadl");
	}

	@Test
	public void frozenPortParenthesesCurrentFailure() throws Exception {
		assertDiagnostics("FrozenPortParentheses.aadl",
				List.of("syntax | extraneous input '(' expecting IDENT",
						"syntax | extraneous input ')' expecting {'[', ',', ']->', '.', IDENT}"));
	}

	@Ignore("Issue #2445: conform frozen-port syntax to AS5506/3 Rev A")
	@Test
	public void frozenPortParenthesesAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("FrozenPortParentheses.aadl");
	}

	@Test
	public void timeoutResetPortsCurrentFailure() throws Exception {
		assertDiagnostics("TimeoutResetPorts.aadl", List.of("syntax | mismatched input '(' expecting ']->'"));
	}

	@Ignore("Issue #2445: implement completion-relative timeout reset ports")
	@Test
	public void timeoutResetPortsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("TimeoutResetPorts.aadl");
	}

	@Test
	public void shortCircuitOperatorsCurrentFailure() throws Exception {
		assertDiagnostics("ShortCircuitOperators.aadl",
				List.of("syntax | extraneous input 'right' expecting {'and', 'mod', 'or', 'rem', 'xor', '[', "
						+ "']->', '?', '.', ''', '=', '!=', '<', '<=', '>', '>=', '+', '-', '*', '/', '**', '=='}",
						"syntax | no viable alternative at input 'else'"));
	}

	@Ignore("Issue #2445: implement and then and or else")
	@Test
	public void shortCircuitOperatorsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("ShortCircuitOperators.aadl");
	}

	@Test
	public void unaryPlusCurrentOverAcceptance() throws Exception {
		assertNoIssues("UnaryPlus.aadl");
	}

	@Ignore("Issue #2445: reject unary plus as required by AS5506/3 Rev A")
	@Test
	public void unaryPlusIsRejectedByTheStandard() throws Exception {
		assertHasSyntaxError("UnaryPlus.aadl");
	}

	@Test
	public void portUpdatedCurrentFailure() throws Exception {
		assertDiagnostics("PortUpdated.aadl",
				List.of("syntax | mismatched input 'updated' expecting {'count', 'fresh'}"));
	}

	@Ignore("Issue #2445: implement the port updated value")
	@Test
	public void portUpdatedIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("PortUpdated.aadl");
	}

	@Test
	public void selfPropertyReferenceCurrentFailure() throws Exception {
		assertDiagnostics("SelfPropertyReference.aadl", List.of("semantic | 'self' is not found"));
	}

	@Ignore("Issue #2445: implement self as a component element reference")
	@Test
	public void selfPropertyReferenceIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("SelfPropertyReference.aadl");
	}

	@Test
	public void optionalLoopClassifierCurrentFailure() throws Exception {
		assertDiagnostics("OptionalForClassifier.aadl",
				List.of("syntax | no viable alternative at input '{for(iin'",
						"syntax | unterminated behavior transition (missing ending ';')"));
		assertDiagnostics("OptionalForallClassifier.aadl",
				List.of("syntax | no viable alternative at input '{forall(iin'",
						"syntax | unterminated behavior transition (missing ending ';')"));
	}

	@Ignore("Issue #2445: make for and forall classifiers optional")
	@Test
	public void optionalLoopClassifierIsAcceptedByTheStandard() throws Exception {
		assertNoIssues("OptionalForClassifier.aadl");
		assertNoIssues("OptionalForallClassifier.aadl");
	}

	@Test
	public void internalPortActionsCurrentFailure() throws Exception {
		assertDiagnostics("InternalPortActions.aadl",
				List.of("semantic | 'internal_action' is not found", "semantic | 'internal_target' is not found"));
	}

	@Ignore("Issue #2445: support internal ports as targets and communication actions")
	@Test
	public void internalPortActionsAreAcceptedByTheStandard() throws Exception {
		assertNoIssues("InternalPortActions.aadl");
	}

	private void assertNoIssues(final String model) throws Exception {
		final FluentIssueCollection result = testHelper.testFile(MODEL_DIRECTORY + model);
		assertTrue(result.getSummary(), result.getIssues().isEmpty());
	}

	private void assertHasSyntaxError(final String model) throws Exception {
		final FluentIssueCollection result = testHelper.testFile(MODEL_DIRECTORY + model);
		assertTrue(result.getSummary(), result.getIssues().stream().anyMatch(Issue::isSyntaxError));
	}

	private void assertDiagnostics(final String model, final List<String> expected) throws Exception {
		final Element root = (Element) testHelper.parseFile(MODEL_DIRECTORY + model);
		final DefaultAnnexSubclause defaultAnnex = AnnexUtil.getAllDefaultAnnexSubclauses(root).get(0);
		final String sourceText = defaultAnnex.getSourceText();
		final String annexText = sourceText.startsWith("{**")
				? sourceText.substring(3, sourceText.length() - 3)
				: sourceText;
		final QueuingParseErrorReporter parseReporter = new QueuingParseErrorReporter();
		parseReporter.setContextResource(defaultAnnex.eResource());
		AnnexUtil.setCurrentAnnexSubclause(defaultAnnex);
		final AnnexSubclause parsed;
		try {
			parsed = new AadlBaParserAction().parseAnnexSubclause(AadlBaParserAction.ANNEX_NAME, annexText, model, 1,
					AnnexUtil.getAnnexOffset(defaultAnnex), parseReporter);
		} finally {
			AnnexUtil.setCurrentAnnexSubclause(null);
		}

		final List<String> actual;
		if (parseReporter.getNumErrors() > 0) {
			actual = describe("syntax", parseReporter.getErrors());
		} else {
			parsed.setName(AadlBaParserAction.ANNEX_NAME);
			defaultAnnex.setParsedAnnexSubclause(parsed);
			parsed.getInModes().addAll(defaultAnnex.getInModes());
			final QueuingParseErrorReporter resolverReporter = new QueuingParseErrorReporter();
			resolverReporter.setContextResource(defaultAnnex.eResource());
			final AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
					new AnalysisToParseErrorReporterAdapter.Factory(resource -> resolverReporter));
			new AadlBaResolver().resolveAnnex(AadlBaParserAction.ANNEX_NAME, Collections.singletonList(parsed),
					errorManager);
			actual = describe("semantic", resolverReporter.getErrors());
		}
		assertEquals(expected, actual);
	}

	private static List<String> describe(final String origin, final List<Message> messages) {
		return messages.stream()
				.map(message -> origin + " | " + message.message)
				.sorted()
				.collect(Collectors.toList());
	}
}
