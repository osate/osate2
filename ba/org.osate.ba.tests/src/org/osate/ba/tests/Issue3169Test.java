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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * AS5506/3 Rev. A D.7 defines {@code and then} and {@code or else} as distinct short-circuit logical operators.
 * Verifies that both operators survive in the declarative and strict models, round-trip through the registered
 * unparser without becoming ordinary {@code and} or {@code or}, normalize hidden text between their keywords, and
 * accept Boolean operands only.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3169Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3169/";
	private static final List<String> OPERATORS = List.of("and then", "or else");

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void shortCircuitOperatorsSurviveTranslation() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3169.aadl");
		validationHelper.assertNoIssues(root);
		assertEquals(OPERATORS, declarativeOperators(annex(root)));
		assertEquals(OPERATORS, strictOperators(annex(root)));
	}

	@Test
	public void shortCircuitOperatorsRoundTripThroughTheUnparser() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3169.aadl");
		validationHelper.assertNoIssues(root);
		var copy = EcoreUtil.copy(annex(root).getParsedAnnexSubclause());

		final String serialized;
		root.eResource().getContents().add(copy);
		try {
			serialized = ((AnnexUnparserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID))
					.getAnnexUnparser("behavior_specification")
					.unparseAnnexSubclause(copy, "");
		} finally {
			root.eResource().getContents().remove(copy);
		}
		var normalized = serialized.replaceAll("\\s+", " ");
		assertTrue(serialized, normalized.contains("left and then right"));
		assertTrue(serialized, normalized.contains("left or else right"));

		var source = NodeModelUtils.getNode(root).getText();
		var reparsed = testHelper.parseString(source.substring(0, source.indexOf("{**") + 3) + serialized
				+ source.substring(source.indexOf("**}")));
		validationHelper.assertNoIssues(reparsed);
		assertEquals(OPERATORS, declarativeOperators(annex(reparsed)));
		assertEquals(OPERATORS, strictOperators(annex(reparsed)));
	}

	@Test
	public void shortCircuitOperatorsRequireBooleanOperands() throws Exception {
		var messages = testHelper.testFile(MODELS + "InvalidShortCircuitOperands.aadl")
				.getIssues()
				.stream()
				.map(issue -> issue.getMessage())
				.sorted()
				.toList();
		assertEquals(List.of("There is no applicable operator \"and then\" for type Base_Types::Integer",
				"There is no applicable operator \"or else\" for type Base_Types::Integer"), messages);
	}

	private static DefaultAnnexSubclause annex(final AadlPackage root) {
		return AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
	}

	private static List<String> declarativeOperators(final DefaultAnnexSubclause annex) {
		var source = (org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex) annex.getParsedAnnexSubclause();
		return source.getTransitions()
				.stream()
				.map(transition -> (BinaryExpression) transition.getCondition().getExecute().getValue())
				.map(BinaryExpression::getOperator)
				.toList();
	}

	private static List<String> strictOperators(final DefaultAnnexSubclause annex) {
		return BehaviorAnnexUtil.getStrictModel(annex)
				.getTransitions()
				.stream()
				.map(transition -> (ValueExpression) transition.getCondition())
				.map(expression -> expression.getLogicalOperators().getFirst().getLiteral())
				.toList();
	}
}
