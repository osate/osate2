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
 * A data implementation may declare a field as a subcomponent without a classifier and attach the Data Model Annex
 * properties to that subcomponent. The subcomponent is then the only element that declares the representation of the
 * field, for a scalar and for an array alike, so that is where the representation, element type, and extent are read
 * from.
 * <p>
 * Such a field declares a representation but no type name, so it conforms to any value of the same representation, the
 * way a literal does. What it does not do is conform to a different representation: the mismatches in
 * {@code AnonymousMismatch} stay errors, and an operator over a Boolean field and an integer literal is reported for
 * operands that do not agree.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3288Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3288/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * The integer, Boolean, and array fields are all declared without a classifier. Every operator here needs the
	 * declared representation: {@code >} and {@code >=} need a numeric one, {@code -} and {@code +} need one to compute
	 * with, and the assignment of a relational expression needs the Boolean field to be Boolean.
	 */
	@Test
	public void classifierLessFieldsTakeTheirDeclaredRepresentation() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3288.aadl"));
	}

	/**
	 * Reading the representation is what makes a real mismatch visible: before it was read, an untyped field conformed
	 * to everything and none of these three was reported.
	 */
	@Test
	public void mismatchedRepresentationsAreStillRejected() throws Exception {
		assertDiagnostics("AnonymousMismatch", List.of(
				new Expected(Severity.ERROR, "pending.open_valve",
						"type error for 'assignment', 'universal integer' expected, found 'standard boolean'."),
				new Expected(Severity.ERROR, "pending.step_total",
						"type error for 'assignment', 'standard boolean' expected, found 'universal integer'."),
				new Expected(Severity.ERROR, "pending.open_valve - 1",
						"Invalid operand types for operator \"-\": left operand has type standard boolean,"
								+ " right operand has type universal integer")));
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
