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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.BehaviorRealLiteral;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * Verifies that translation to the strict Behavior Annex model preserves the value of every numeric literal form the
 * core AADL grammar admits, and that a spelling the grammar accepts but the integer reader cannot represent is
 * reported on the literal instead of silently becoming zero.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3175Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3175/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void initialValuesKeepTheirValueAndBase() throws Exception {
		assertEquals(
				List.of("42 base 10", "1000000 base 10", "2000 base 10", "255 base 16", "160 base 2", "1.25", "1050.0"),
				strictAnnex().getVariables().stream().map(variable -> describe(variable.getOwnedValueConstant()))
						.toList());
	}

	@Test
	public void literalsInsideValueExpressionsKeepTheirValueAndBase() throws Exception {
		assertEquals(List.of("15 base 8", "0.25"), literals(strictAnnex().getActions().get(0)));
	}

	@Test
	public void transitionPriorityKeepsItsValue() throws Exception {
		// 16#10# is sixteen, not the ten that a decimal reader would return.
		assertEquals(16L, strictAnnex().getTransitions().get(1).getPriority());
	}

	@Test
	public void unrepresentableIntegerLiteralsAreReported() throws Exception {
		assertEquals(List.of(
				"ERROR: Cannot represent integer literal 99999999999999999999:"
						+ " Integer value is not representable",
				"ERROR: Cannot represent integer literal 20#5#: Base not between 2 and 16: 20",
				"ERROR: Cannot represent integer literal 2#9#:"
						+ " '9' at string index 2 is not an extended digit in base 2",
				"ERROR: Cannot represent integer literal 99999999999999999999:"
						+ " Integer value is not representable"),
				testHelper.testFile(MODELS + "OutOfRange.aadl")
						.getIssues()
						.stream()
						.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
						.toList());
	}

	private BehaviorAnnex strictAnnex() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3175.aadl");
		validationHelper.assertNoIssues(root);
		return BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
	}

	/** Describes every numeric literal below the given object, in document order. */
	private static List<String> literals(final EObject strict) {
		var result = new ArrayList<String>();
		strict.eAllContents().forEachRemaining(object -> {
			if (object instanceof BehaviorIntegerLiteral || object instanceof BehaviorRealLiteral) {
				result.add(describe(object));
			}
		});
		return result;
	}

	private static String describe(final EObject literal) {
		if (literal instanceof BehaviorIntegerLiteral integerLiteral) {
			return integerLiteral.getValue() + " base " + integerLiteral.getBase();
		}
		return Double.toString(((BehaviorRealLiteral) literal).getValue());
	}
}
