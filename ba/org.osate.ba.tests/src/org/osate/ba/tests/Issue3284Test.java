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
 * Numeric conformance. Integer, fixed point, and floating point are ordered by the values they hold. A conversion up
 * that order keeps the value and is noted; a conversion down it may lose precision and is warned about. Two numeric
 * types that share a representation conform and are noted. A classifier-less integer conforms to any of the three and
 * is not reported at all, because a literal has no declared type to convert from.
 * <p>
 * What stays an error: {@code mod} or {@code rem} on a real operand, and a shared representation between types that are
 * not numeric. A mixed expression takes the wider representation, which is what makes the narrowing diagnostic on its
 * result reachable rather than silently integral.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3284Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3284/";
	private static final String PKG = "SharedRepresentation";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void universalIntegersConformToFixedAndFloat() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3284.aadl"));
	}

	/**
	 * Narrowing is warned about rather than rejected. The warning on the mixed literal expression is the evidence that
	 * its result is floating point rather than integral, and {@code mod} still refuses a real operand outright.
	 */
	@Test
	public void narrowingWarnsAndMixingIsNoted() throws Exception {
		assertDiagnostics("MixedNumerics", List.of(
				new Expected(Severity.WARNING, "1 + 1.0",
						"The assignment narrows 'universal real' to 'MixedNumerics::int_type', which may lose precision"),
				new Expected(Severity.ERROR, "1 mod fixed_value",
						"Invalid operand types for operator \"mod\": left operand has type universal integer, right operand has type MixedNumerics::percent_type"),
				new Expected(Severity.WARNING, "float_value",
						"The assignment narrows 'MixedNumerics::ratio_type' to 'MixedNumerics::int_type', which may lose precision"),
				new Expected(Severity.INFO, "int_value + float_value",
						"Operator \"+\" mixes numeric representations: MixedNumerics::int_type and MixedNumerics::ratio_type, giving MixedNumerics::ratio_type")));
	}

	/**
	 * Integer, fixed point, and floating point are ordered by the values they hold. A conversion up that order keeps the
	 * value and is noted; a conversion down it may lose precision and is warned about. Types that share a representation
	 * conform and are noted. Booleans and enumerations are not numeric, so a shared representation is not enough for
	 * them and those two assignments stay errors.
	 */
	@Test
	public void numericConversionsAreNotedAndNarrowingIsWarnedAbout() throws Exception {
		assertDiagnostics("SharedRepresentation", List.of(
				new Expected(Severity.INFO, "int_b", shared("first_integer", "second_integer")),
				new Expected(Severity.INFO, "float_b", shared("first_float", "second_float")),
				new Expected(Severity.INFO, "fixed_b", shared("first_fixed", "second_fixed")),
				new Expected(Severity.INFO, "int_b + int_a",
						"Operands of \"+\" are different types with the same data representation: %s::second_integer and %s::first_integer"
								.formatted(PKG, PKG)),
				new Expected(Severity.INFO, "int_b + int_a", shared("first_integer", "second_integer")),
				new Expected(Severity.INFO, "int_a", widens("first_integer", "first_float")),
				new Expected(Severity.INFO, "int_a + float_b",
						"Operator \"+\" mixes numeric representations: %s::first_integer and %s::second_float, giving %s::second_float"
								.formatted(PKG, PKG, PKG)),
				new Expected(Severity.INFO, "int_a + float_b", shared("first_float", "second_float")),
				new Expected(Severity.INFO, "int_a", widens("first_integer", "first_fixed")),
				new Expected(Severity.INFO, "fixed_a", widens("first_fixed", "first_float")),
				new Expected(Severity.WARNING, "float_a", narrows("first_float", "first_integer")),
				new Expected(Severity.WARNING, "fixed_a", narrows("first_fixed", "first_integer")),
				new Expected(Severity.WARNING, "float_a", narrows("first_float", "first_fixed")),
				new Expected(Severity.ERROR, "flag_b",
						"type error for 'assignment', '%s::first_flag' expected, found '%s::second_flag'."
								.formatted(PKG, PKG)),
				new Expected(Severity.ERROR, "choice_b",
						"type error for 'assignment', '%s::first_choice' expected, found '%s::second_choice'."
								.formatted(PKG, PKG))));
	}

	private static String shared(final String expected, final String found) {
		return "The assignment relies on the shared data representation of '%s::%s' and '%s::%s'".formatted(PKG,
				expected, PKG, found);
	}

	private static String widens(final String found, final String expected) {
		return "The assignment widens '%s::%s' to '%s::%s'".formatted(PKG, found, PKG, expected);
	}

	private static String narrows(final String found, final String expected) {
		return "The assignment narrows '%s::%s' to '%s::%s', which may lose precision".formatted(PKG, found, PKG,
				expected);
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
