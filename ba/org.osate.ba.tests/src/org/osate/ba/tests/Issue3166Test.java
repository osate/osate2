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
import java.util.function.Function;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/** Verifies the complete D.3 external-condition logical expression and its strict-model projection. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3166Test {
	private static final String MODEL = "org.osate.ba.tests/models/issue3166/Issue3166.aadl";
	private static final String EXPRESSION =
			"((first_event or second_event) and then third_event) xor first_event or else (second_event and third_event)";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void allExternalConditionOperatorsSurviveTranslation() throws Exception {
		var root = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(root);
		var annex = annex(root);

		assertEquals(EXPRESSION, declarativeExpression(annex));
		assertEquals(EXPRESSION, strictExpression(annex));
	}

	@Test
	public void groupedExternalConditionRoundTripsThroughTheUnparser() throws Exception {
		var root = testHelper.parseFile(MODEL);
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
		var normalized = serialized.replaceAll("\\s+", " ").replace("( ", "(").replace(" )", ")");
		assertTrue(serialized, normalized.contains(
				"on (first_event or second_event) and then third_event xor first_event or else second_event and third_event"));

		var source = NodeModelUtils.getNode(root).getText();
		var reparsed = testHelper.parseString(source.substring(0, source.indexOf("{**") + 3) + serialized
				+ source.substring(source.indexOf("**}")));
		validationHelper.assertNoIssues(reparsed);
		assertEquals(EXPRESSION, declarativeExpression(annex(reparsed)));
		assertEquals(EXPRESSION, strictExpression(annex(reparsed)));
	}

	private static DefaultAnnexSubclause annex(final AadlPackage root) {
		return AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
	}

	private static String declarativeExpression(final DefaultAnnexSubclause annex) {
		var source = (org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex) annex.getParsedAnnexSubclause();
		return declarativeExpression(source.getTransitions().getFirst().getCondition().getModeSwitch());
	}

	private static String declarativeExpression(final EObject expression) {
		return join(objects(expression, "conjunctions"), strings(expression, "logicalOperators"),
				Issue3166Test::declarativeConjunction);
	}

	private static String declarativeConjunction(final EObject conjunction) {
		var operators = strings(conjunction, "logicalOperators");
		var result = join(objects(conjunction, "triggers"), operators, trigger -> {
			var nested = optionalObject(trigger, "expression");
			return nested == null ? referenceName(object(trigger, "reference"))
					: "(" + declarativeExpression(nested) + ")";
		});
		return operators.isEmpty() ? result : "(" + result + ")";
	}

	private static String strictExpression(final DefaultAnnexSubclause annex) {
		var strict = BehaviorAnnexUtil.getStrictModel(annex);
		return strictExpression(strict.getTransitions().getFirst().getCondition());
	}

	private static String strictExpression(final EObject expression) {
		return join(objects(expression, "modeSwitchConjunctions"), strings(expression, "logicalOperators"),
				Issue3166Test::strictConjunction);
	}

	private static String strictConjunction(final EObject conjunction) {
		var operators = strings(conjunction, "logicalOperators");
		var result = join(objects(conjunction, "modeSwitchTriggers"), operators, trigger -> {
			if ("ModeSwitchTriggerLogicalExpression".equals(trigger.eClass().getName())) {
				return "(" + strictExpression(trigger) + ")";
			}
			return ((NamedElement) value(trigger, "element")).getName();
		});
		return operators.isEmpty() ? result : "(" + result + ")";
	}

	private static String referenceName(final EObject reference) {
		return (String) value(objects(reference, "segments").getFirst(), "name");
	}

	private static String join(final List<EObject> operands, final List<String> operators,
			final Function<EObject, String> formatter) {
		assertEquals("A logical expression needs one operator between adjacent operands", operands.size() - 1,
				operators.size());
		var result = new StringBuilder(formatter.apply(operands.getFirst()));
		for (var i = 0; i < operators.size(); i++) {
			result.append(' ').append(operators.get(i)).append(' ').append(formatter.apply(operands.get(i + 1)));
		}
		return result.toString();
	}

	@SuppressWarnings("unchecked")
	private static List<EObject> objects(final EObject object, final String featureName) {
		return (List<EObject>) value(object, featureName);
	}

	@SuppressWarnings("unchecked")
	private static List<String> strings(final EObject object, final String featureName) {
		return ((List<Object>) value(object, featureName)).stream()
				.map(value -> value instanceof Enumerator enumerator ? enumerator.getLiteral() : value.toString())
				.toList();
	}

	private static EObject object(final EObject owner, final String featureName) {
		return (EObject) value(owner, featureName);
	}

	private static EObject optionalObject(final EObject owner, final String featureName) {
		var feature = owner.eClass().getEStructuralFeature(featureName);
		return feature == null ? null : (EObject) owner.eGet(feature);
	}

	private static Object value(final EObject object, final String featureName) {
		var feature = object.eClass().getEStructuralFeature(featureName);
		assertNotNull(object.eClass().getName() + " must define " + featureName, feature);
		return object.eGet(feature);
	}
}
