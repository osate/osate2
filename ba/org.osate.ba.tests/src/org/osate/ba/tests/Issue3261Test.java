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

/** Exercises bidirectional classifier-extension compatibility through embedded BA validation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3261Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3261/";
	private static final String PKG = "IncompatibleExtensions";
	private static final String SHARED_INTEGER = "The assignment relies on the shared data representation of '"
			+ PKG + "::child_integer' and '" + PKG + "::sibling_integer'";
	private static final String SHARED_REAL = "The assignment relies on the shared data representation of '" + PKG
			+ "::real_type' and '" + PKG + "::changed_representation'";
	private static final String NARROWED = "type error for 'assignment', '" + PKG + "::integer_type' expected, found '"
			+ PKG + "::changed_representation'.";
	private static final String UNRELATED_BOOLEAN = "type error for 'assignment', '" + PKG
			+ "::unrelated_boolean' expected, found '" + PKG + "::child_boolean'.";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void baseAndExtendedAssignmentsAndOperandsAreAccepted() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3261.aadl"));
	}

	@Test
	public void compatibleExtensionsWorkInBothDirections() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "TypeExtensions.aadl"));
	}

	/**
	 * Since #3284 a numeric conversion is accepted and noted rather than rejected, so the sibling cases and the
	 * integer-to-float cases are now notes. What still fails is unchanged by that relaxation: a mismatched array shape,
	 * a classifier with no data representation, narrowing a real to an integer, and a shared representation between
	 * types that are not numeric.
	 */
	@Test
	public void numericConversionsAreNotedAndOtherMismatchesFail() throws Exception {
		assertDiagnostics("IncompatibleExtensions", List.of(
				new Expected(Severity.INFO, "sibling_value", SHARED_INTEGER),
				new Expected(Severity.INFO, "child_value + sibling_value",
						"Operands of \"+\" are different types with the same data representation: %s::child_integer and %s::sibling_integer"
								.formatted(PKG, PKG)),
				new Expected("real_value", NARROWED),
				new Expected(Severity.INFO, "base_value",
						"The assignment widens an integer value to '%s::changed_representation'".formatted(PKG)),
				new Expected(Severity.INFO, "base_value + real_value",
						"Operator \"+\" mixes integer and floating point operands: %s::integer_type and %s::changed_representation, giving %s::changed_representation"
								.formatted(PKG, PKG, PKG)),
				new Expected("base_value + real_value", NARROWED),
				new Expected("numeric_value",
						"type error for 'assignment', '%s::opaque' expected, found '%s::numeric_opaque'."
								.formatted(PKG, PKG)),
				new Expected("opaque_value",
						"type error for 'assignment', '%s::numeric_opaque' expected, found '%s::opaque'."
								.formatted(PKG, PKG)),
				new Expected("larger_array",
						"type error for 'assignment', '%s::integer_type[2]' expected, found '%s::child_integer[3]'."
								.formatted(PKG, PKG)),
				new Expected("matrix",
						"type error for 'assignment', '%s::integer_type[2]' expected, found '%s::child_integer[2][2]'."
								.formatted(PKG, PKG)),
				new Expected(Severity.INFO, "1 + sibling_value", SHARED_INTEGER),
				new Expected(Severity.INFO, "sibling_value + 1", SHARED_INTEGER),
				new Expected(Severity.INFO, "1.0 + real_value", SHARED_REAL),
				new Expected(Severity.INFO, "real_value + 1.0", SHARED_REAL),
				new Expected("true and derived_flag", UNRELATED_BOOLEAN),
				new Expected("derived_flag or false", UNRELATED_BOOLEAN)));
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
		/** Most expectations are errors; the severity is written out only where a diagnostic is a note. */
		Expected(String target, String message) {
			this(Severity.ERROR, target, message);
		}
	}
}
