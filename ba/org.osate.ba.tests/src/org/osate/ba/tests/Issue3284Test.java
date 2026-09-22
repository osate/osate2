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

/**
 * Numeric conformance. A classifier-less integer conforms to a fixed point or floating point representation as well as
 * to an integer, and needs no note because a literal has no declared type to convert from. Classifier-typed numerics
 * conform when they share a representation, and an integer widens to a floating point one; both are accepted and noted,
 * because the model relies on a conversion it does not state.
 * <p>
 * What stays an error: narrowing a real to an integer, {@code mod} and {@code rem} on a real operand, and a shared
 * representation between types that are not numeric. The result of a mixed expression is floating point, which is what
 * makes the narrowing error reachable.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3284Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3284/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void universalIntegersConformToFixedAndFloat() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3284.aadl"));
	}

	/**
	 * Narrowing stays an error. Mixing integer and floating point operands is accepted and noted, and the note is the
	 * evidence that the result is floating point rather than integral.
	 */
	@Test
	public void narrowingStaysAnErrorAndMixingIsNoted() throws Exception {
		assertDiagnostics("MixedNumerics", List.of(
				new Expected(Severity.ERROR, "1 + 1.0",
						"type error for 'assignment', 'MixedNumerics::int_type' expected, found 'universal real'."),
				new Expected(Severity.ERROR, "1 mod fixed_value",
						"Invalid operand types for operator \"mod\": left operand has type universal integer, right operand has type MixedNumerics::percent_type"),
				new Expected(Severity.ERROR, "float_value",
						"type error for 'assignment', 'MixedNumerics::int_type' expected, found 'MixedNumerics::ratio_type'."),
				new Expected(Severity.INFO, "int_value + float_value",
						"Operator \"+\" mixes integer and floating point operands: MixedNumerics::int_type and MixedNumerics::ratio_type, giving MixedNumerics::ratio_type")));
	}

	/**
	 * Numeric types that share only a data representation conform, and an integer widens to a floating point target.
	 * Both are accepted and noted. Booleans and enumerations are not numeric, so a shared representation is not enough
	 * for them and those two assignments stay errors.
	 */
	@Test
	public void sharedRepresentationsAndWideningAreAcceptedWithANote() throws Exception {
		assertDiagnostics("SharedRepresentation", List.of(
				new Expected(Severity.INFO, "int_b",
						"The assignment relies on the shared data representation of 'SharedRepresentation::first_integer' and 'SharedRepresentation::second_integer'"),
				new Expected(Severity.INFO, "float_b",
						"The assignment relies on the shared data representation of 'SharedRepresentation::first_float' and 'SharedRepresentation::second_float'"),
				new Expected(Severity.INFO, "fixed_b",
						"The assignment relies on the shared data representation of 'SharedRepresentation::first_fixed' and 'SharedRepresentation::second_fixed'"),
				new Expected(Severity.INFO, "int_b + int_a",
						"Operands of \"+\" are different types with the same data representation: SharedRepresentation::second_integer and SharedRepresentation::first_integer"),
				new Expected(Severity.INFO, "int_b + int_a",
						"The assignment relies on the shared data representation of 'SharedRepresentation::first_integer' and 'SharedRepresentation::second_integer'"),
				new Expected(Severity.INFO, "int_a",
						"The assignment widens an integer value to 'SharedRepresentation::first_float'"),
				new Expected(Severity.INFO, "int_a + float_b",
						"Operator \"+\" mixes integer and floating point operands: SharedRepresentation::first_integer and SharedRepresentation::second_float, giving SharedRepresentation::second_float"),
				new Expected(Severity.INFO, "int_a + float_b",
						"The assignment relies on the shared data representation of 'SharedRepresentation::first_float' and 'SharedRepresentation::second_float'"),
				new Expected(Severity.ERROR, "flag_b",
						"type error for 'assignment', 'SharedRepresentation::first_flag' expected, found 'SharedRepresentation::second_flag'."),
				new Expected(Severity.ERROR, "choice_b",
						"type error for 'assignment', 'SharedRepresentation::first_choice' expected, found 'SharedRepresentation::second_choice'.")));
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream()
				.map(issue -> new Expected(issue.getSeverity(),
						source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()),
						issue.getMessage()))
				.toList());
	}

	private record Expected(Severity severity, String target, String message) {
	}
}
