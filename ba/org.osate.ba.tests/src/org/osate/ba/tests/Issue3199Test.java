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
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Exercises declarative type conformance through embedded BA validation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3199Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3199/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void unrelatedClassifiersAndRealizationsRemainDistinct() throws Exception {
		assertDiagnostics("ClassifierIdentity", List.of(new Expected("second",
				"type error for 'assignment', 'ClassifierIdentity::first_type' expected, found 'ClassifierIdentity::second_type'."),
				new Expected("implementation",
						"type error for 'assignment', 'ClassifierIdentity::first_type' expected, found 'ClassifierIdentity::first_type.impl'."),
				new Expected("true and second_flag",
						"type error for 'assignment', 'ClassifierIdentity::first_boolean' expected, found 'ClassifierIdentity::second_boolean'."),
				new Expected("second_flag or false",
						"type error for 'assignment', 'ClassifierIdentity::first_boolean' expected, found 'ClassifierIdentity::second_boolean'.")));
	}

	@Test
	public void assignmentsSendsAndOperandsRejectTheReportedMismatches() throws Exception {
		assertDiagnostics("Issue3199", List.of(
				new Expected("\"text\"",
						"type error for 'assignment', 'Base_Types::Integer' expected, found 'standard string'."),
				new Expected("out_text!(42)",
						"type error for 'port send action', 'Base_Types::String' expected, found 'universal integer'."),
				new Expected("1 + \"text\"",
						"Invalid operand types for operator \"+\": left operand has type universal integer, right operand has type standard string"),
				new Expected("counter < \"text\"",
						"Invalid operand types for operator \"<\": left operand has type Base_Types::Integer, right operand has type standard string")));
	}

	@Test
	public void universalLiteralsFixedPointGroupingAndUpdatedAreAccepted() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "ConformingTypes.aadl"));
	}

	@Test
	public void numericsDoNotWidenImplicitly() throws Exception {
		assertDiagnostics("NumericTypes", List.of(
				new Expected("1",
						"type error for 'assignment', 'Base_Types::Float' expected, found 'universal integer'."),
				new Expected("integer_value",
						"type error for 'assignment', 'Base_Types::Float' expected, found 'Base_Types::Integer'."),
				new Expected("1 + 1.0",
						"Invalid operand types for operator \"+\": left operand has type universal integer, right operand has type universal real"),
				new Expected("integer_value + real_value",
						"Invalid operand types for operator \"+\": left operand has type Base_Types::Integer, right operand has type Base_Types::Float")));
	}

	@Test
	public void arrayRankAndKnownExtentsMustMatch() throws Exception {
		assertDiagnostics("ArrayTypes", List.of(new Expected("larger_array",
				"type error for 'assignment', 'Base_Types::Integer[2]' expected, found 'Base_Types::Integer[3]'."),
				new Expected("matrix",
						"type error for 'assignment', 'Base_Types::Integer[2]' expected, found 'Base_Types::Integer[2][2]'.")));
	}

	@Test
	public void dequeueCallsAndInternalSendsUseTheSameConformance() throws Exception {
		assertDiagnostics("CommunicationTypes", List.of(new Expected("input?(counter)",
				"type error for 'port dequeue action', 'Base_Types::String' expected, found 'Base_Types::Integer'."),
				new Expected("counter",
						"type error for 'actual for 'argument'', 'Base_Types::String' expected, found 'Base_Types::Integer'."),
				new Expected("counter",
						"type error for 'actual for 'result'', 'Base_Types::String' expected, found 'Base_Types::Integer'."),
				new Expected("\"text\"",
						"type error for 'internal port send action', 'Base_Types::Integer' expected, found 'standard string'.")));
	}

	@Test
	public void typeErrorsDoNotSuppressInitializationAndLegalityDiagnostics() throws Exception {
		var root = testHelper.parseFile(PATH + "SourceDiagnostics.aadl");
		var issues = validationHelper.validate(root);
		assertEquals(List.of("Behavior variable 'counter' may be read before it is initialized",
				"SourceDiagnostics::worker.impl has no complete state : Behavior Annex D.3.(L3) legality rule failed.",
				"type error for 'behavior variable initializer', 'Base_Types::Boolean' expected, found 'universal integer'."),
				issues.stream().map(issue -> {
					assertEquals(Severity.ERROR, issue.getSeverity());
					return issue.getMessage();
				}).sorted().toList());
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			return new Expected(source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()),
					issue.getMessage());
		}).toList());
	}

	private record Expected(String target, String message) {
	}
}
