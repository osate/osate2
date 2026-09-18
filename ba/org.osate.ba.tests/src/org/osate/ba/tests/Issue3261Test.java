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

	@Test
	public void extensionsAndLiteralsPreserveTypeAndShapeRestrictions() throws Exception {
		assertDiagnostics("IncompatibleExtensions", List.of(
				new Expected("sibling_value",
						"type error for 'assignment', 'IncompatibleExtensions::child_integer' expected, found 'IncompatibleExtensions::sibling_integer'."),
				new Expected("child_value + sibling_value",
						"Invalid operand types for operator \"+\": left operand has type IncompatibleExtensions::child_integer, right operand has type IncompatibleExtensions::sibling_integer"),
				new Expected("real_value",
						"type error for 'assignment', 'IncompatibleExtensions::integer_type' expected, found 'IncompatibleExtensions::changed_representation'."),
				new Expected("base_value",
						"type error for 'assignment', 'IncompatibleExtensions::changed_representation' expected, found 'IncompatibleExtensions::integer_type'."),
				new Expected("base_value + real_value",
						"Invalid operand types for operator \"+\": left operand has type IncompatibleExtensions::integer_type, right operand has type IncompatibleExtensions::changed_representation"),
				new Expected("numeric_value",
						"type error for 'assignment', 'IncompatibleExtensions::opaque' expected, found 'IncompatibleExtensions::numeric_opaque'."),
				new Expected("opaque_value",
						"type error for 'assignment', 'IncompatibleExtensions::numeric_opaque' expected, found 'IncompatibleExtensions::opaque'."),
				new Expected("larger_array",
						"type error for 'assignment', 'IncompatibleExtensions::integer_type[2]' expected, found 'IncompatibleExtensions::child_integer[3]'."),
				new Expected("matrix",
						"type error for 'assignment', 'IncompatibleExtensions::integer_type[2]' expected, found 'IncompatibleExtensions::child_integer[2][2]'."),
				new Expected("1 + sibling_value",
						"type error for 'assignment', 'IncompatibleExtensions::child_integer' expected, found 'IncompatibleExtensions::sibling_integer'."),
				new Expected("sibling_value + 1",
						"type error for 'assignment', 'IncompatibleExtensions::child_integer' expected, found 'IncompatibleExtensions::sibling_integer'."),
				new Expected("1.0 + real_value",
						"type error for 'assignment', 'IncompatibleExtensions::real_type' expected, found 'IncompatibleExtensions::changed_representation'."),
				new Expected("real_value + 1.0",
						"type error for 'assignment', 'IncompatibleExtensions::real_type' expected, found 'IncompatibleExtensions::changed_representation'."),
				new Expected("true and derived_flag",
						"type error for 'assignment', 'IncompatibleExtensions::unrelated_boolean' expected, found 'IncompatibleExtensions::child_boolean'."),
				new Expected("derived_flag or false",
						"type error for 'assignment', 'IncompatibleExtensions::unrelated_boolean' expected, found 'IncompatibleExtensions::child_boolean'.")));
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
