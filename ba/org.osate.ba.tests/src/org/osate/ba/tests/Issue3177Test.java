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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.IntegerLiteral;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BehaviorActionSequence;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.SimpleExpression;
import org.osate.ba.aadlba.Term;
import org.osate.ba.aadlba.Value;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * AS5506/3 Rev. A D.7 puts every logical operator on one precedence level, associates operators of one level from left
 * to right, applies the unary adding operator to a whole term, and admits at most one exponentiation and a single
 * value as the operand of a unary numeric or boolean operator. Verifies that the declarative model records that
 * grouping, that the strict model keeps a parenthesized value expression as one operand instead of splicing it into
 * the enclosing expression, that no operator is dropped, and that the forms the standard grammar does not admit are
 * rejected.
 *
 * <p>
 * The declarative renderings below are prefix trees so that a shape difference cannot be hidden by textual
 * association, and the strict renderings follow the standard's value_expression/relation/simple_expression/term/factor
 * nesting, parenthesizing a nested value expression only.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3177Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3177/";
	private static final String MODEL = MODELS + "Issue3177.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void mixedLogicalOperatorsAssociateLeftToRight() throws Exception {
		var root = parse();
		assertEquals("(and (or left middle) right)", declarativeExpression(root, 0));
		assertEquals("left or middle and right", strictExpression(root, 0));
	}

	@Test
	public void aParenthesizedLogicalGroupStaysOneOperand() throws Exception {
		var root = parse();
		assertEquals("(and left (group (or middle right)))", declarativeExpression(root, 1));
		assertEquals("left and (middle or right)", strictExpression(root, 1));
	}

	@Test
	public void exponentiationBindsTighterThanTheUnaryAddingOperator() throws Exception {
		var root = parse();
		assertEquals("(- (** 2 2))", declarativeExpression(root, 2));
		assertEquals("-2 ** 2", strictExpression(root, 2));
	}

	@Test
	public void theUnaryAddingOperatorAppliesToTheWholeTerm() throws Exception {
		var root = parse();
		assertEquals("(- (mod total 3))", declarativeExpression(root, 3));
		assertEquals("-total mod 3", strictExpression(root, 3));
	}

	@Test
	public void aParenthesizedExponentiationChainIsAccepted() throws Exception {
		var root = parse();
		assertEquals("(** (group (** total 2)) 3)", declarativeExpression(root, 4));
		assertEquals("(total ** 2) ** 3", strictExpression(root, 4));
	}

	/**
	 * Requires the serializer to emit the grouping from the model rather than from the parse text, which is what makes
	 * an explicitly grouped expression survive a model-to-text round trip.
	 */
	@Test
	public void groupingSurvivesTheUnparserRoundTrip() throws Exception {
		var root = parse();
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
		var normalized = serialized.replaceAll("\\s+", " ").replace("( ", "(").replace(" )", ")");
		assertTrue(serialized, normalized.contains("left and (middle or right)"));
		assertTrue(serialized, normalized.contains("(total ** 2) ** 3"));

		var source = NodeModelUtils.getNode(root).getText();
		var reparsed = testHelper.parseString(source.substring(0, source.indexOf("{**") + 3) + serialized
				+ source.substring(source.indexOf("**}")));
		validationHelper.assertNoIssues(reparsed);
		for (var index = 0; index < 5; index++) {
			assertEquals(declarativeExpression(root, index), declarativeExpression(reparsed, index));
			assertEquals(strictExpression(root, index), strictExpression(reparsed, index));
		}
	}

	@Test
	public void anUnparenthesizedExponentiationChainIsRejected() throws Exception {
		assertSyntaxError("PowerChain.aadl");
	}

	@Test
	public void aRepeatedUnaryAddingOperatorIsRejected() throws Exception {
		assertSyntaxError("RepeatedUnaryMinus.aadl");
	}

	@Test
	public void aSignedOperandOfAbsIsRejected() throws Exception {
		assertSyntaxError("AbsNegatedOperand.aadl");
	}

	@Test
	public void aRepeatedNotIsRejected() throws Exception {
		assertSyntaxError("RepeatedNot.aadl");
	}

	/** Keeps the fixture's assignment sequence and the indexes the expectations above use in step. */
	@Test
	public void theFixtureSuppliesEveryAssertedExpression() throws Exception {
		var root = parse();
		var actions = strictAssignments(root);
		assertEquals(
				List.of("left or middle and right", "left and (middle or right)", "-2 ** 2", "-total mod 3",
						"(total ** 2) ** 3"),
				actions.stream().map(action -> strict((ValueExpression) action.getValueExpression())).toList());
	}

	private AadlPackage parse() throws Exception {
		var root = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(root);
		return root;
	}

	private void assertSyntaxError(final String model) throws Exception {
		var result = testHelper.testFile(MODELS + model);
		assertTrue(result.getSummary(), result.getIssues().stream().anyMatch(Issue::isSyntaxError));
	}

	private static DefaultAnnexSubclause annex(final AadlPackage root) {
		return AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
	}

	private static String declarativeExpression(final AadlPackage root, final int index) {
		var source = (BehaviorAnnex) annex(root).getParsedAnnexSubclause();
		var actions = (org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence) source.getTransitions()
				.getFirst()
				.getActionBlock()
				.getContent();
		var assignment = (org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction) actions.getActions().get(index);
		return declarative(assignment.getValue());
	}

	private static String declarative(final EObject expression) {
		if (expression instanceof BinaryExpression binary) {
			return "(" + binary.getOperator() + " " + declarative(binary.getLeft()) + " "
					+ declarative(binary.getRight()) + ")";
		}
		if (expression instanceof UnaryExpression unary) {
			return "(" + unary.getOperator() + " " + declarative(unary.getOperand()) + ")";
		}
		// Read reflectively so that this test compiles against the model that has no explicit group class yet.
		if ("ParenthesizedExpression".equals(expression.eClass().getName())) {
			var feature = expression.eClass().getEStructuralFeature("expression");
			assertNotNull("A group must contain its expression", feature);
			return "(group " + declarative((EObject) expression.eGet(feature)) + ")";
		}
		if (expression instanceof BehaviorIntegerLiteral literal) {
			return literal.getValue();
		}
		if (expression instanceof ReferenceExpression reference) {
			return reference.getReference().getSegments().getFirst().getName();
		}
		return expression.eClass().getName();
	}

	private static String strictExpression(final AadlPackage root, final int index) {
		return strict((ValueExpression) strictAssignments(root).get(index).getValueExpression());
	}

	private static List<AssignmentAction> strictAssignments(final AadlPackage root) {
		var actions = (BehaviorActionSequence) BehaviorAnnexUtil.getStrictModel(annex(root))
				.getTransitions()
				.getFirst()
				.getActionBlock()
				.getContent();
		return actions.getActions().stream().map(AssignmentAction.class::cast).toList();
	}

	private static String strict(final ValueExpression expression) {
		var relations = expression.getRelations();
		var operators = expression.getLogicalOperators();
		assertEquals("A value expression needs one logical operator between adjacent relations",
				relations.size() - 1, operators.size());
		var result = new StringBuilder(strict(relations.getFirst()));
		for (var index = 0; index < operators.size(); index++) {
			result.append(' ').append(operators.get(index).getLiteral()).append(' ')
					.append(strict(relations.get(index + 1)));
		}
		return result.toString();
	}

	private static String strict(final Relation relation) {
		var result = strict(relation.getFirstExpression());
		if (relation.isSetRelationalOperator()) {
			result += " " + relation.getRelationalOperator().getLiteral() + " "
					+ strict(relation.getSecondExpression());
		}
		return result;
	}

	private static String strict(final SimpleExpression expression) {
		var terms = expression.getTerms();
		var operators = expression.getBinaryAddingOperators();
		assertEquals("A simple expression needs one binary adding operator between adjacent terms", terms.size() - 1,
				operators.size());
		var result = new StringBuilder();
		if (expression.isSetUnaryAddingOperator()) {
			result.append(expression.getUnaryAddingOperator().getLiteral());
		}
		result.append(strict(terms.getFirst()));
		for (var index = 0; index < operators.size(); index++) {
			result.append(' ').append(operators.get(index).getLiteral()).append(' ')
					.append(strict(terms.get(index + 1)));
		}
		return result.toString();
	}

	private static String strict(final Term term) {
		var factors = term.getFactors();
		var operators = term.getMultiplyingOperators();
		assertEquals("A term needs one multiplying operator between adjacent factors", factors.size() - 1,
				operators.size());
		var result = new StringBuilder(strict(factors.getFirst()));
		for (var index = 0; index < operators.size(); index++) {
			result.append(' ').append(operators.get(index).getLiteral()).append(' ')
					.append(strict(factors.get(index + 1)));
		}
		return result.toString();
	}

	private static String strict(final Factor factor) {
		if (factor.isSetUnaryNumericOperator()) {
			return "abs " + strict(factor.getFirstValue());
		}
		if (factor.isSetUnaryBooleanOperator()) {
			return "not " + strict(factor.getFirstValue());
		}
		var result = strict(factor.getFirstValue());
		if (factor.isSetBinaryNumericOperator()) {
			result += " ** " + strict(factor.getSecondValue());
		}
		return result;
	}

	private static String strict(final Value value) {
		if (value instanceof ValueExpression nested) {
			return "(" + strict(nested) + ")";
		}
		if (value instanceof IntegerLiteral literal) {
			return Long.toString(literal.getValue());
		}
		if (value instanceof ElementHolder holder) {
			return holder.getElement().getName();
		}
		return value.eClass().getName();
	}
}
