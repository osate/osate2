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
package org.osate.xtext.aadl2.ba.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.TextPositionInfo;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.Value;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexTextPositionResolver;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** An incremental edit may leave an operand absent while reference services translate the recovered annex. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3312Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> helper;

	@Inject
	private ValidationTestHelper validation;

	@Test
	public void collectsReferencesWithMissingOperand() throws Exception {
		var resource = removeOperand();
		var source = sourceAnnex(resource);
		var positions = new ArrayList<TextPositionInfo>();
		new BehaviorAnnexTextPositionResolver().collectReferencePositions(source, positions::add,
				new NullProgressMonitor());
		assertEquals(List.of(text(resource).indexOf("distance >"), text(resource).indexOf("distance :=")),
				positions.stream().filter(position -> position.getModelObject()
						== source.getVariableGroups().getFirst().getVariables().getFirst())
						.map(TextPositionInfo::getOffset).toList());
	}

	@Test
	public void resolvesElementWithMissingOperand() throws Exception {
		var resource = removeOperand();
		var offset = text(resource).indexOf("distance >");
		assertPosition(resource, offset,
				new BehaviorAnnexTextPositionResolver().resolveElementAt(sourceAnnex(resource), offset));
	}

	@Test
	public void resolvesCrossReferenceWithMissingOperand() throws Exception {
		var resource = removeOperand();
		var offset = text(resource).indexOf("distance >");
		assertPosition(resource, offset,
				new BehaviorAnnexTextPositionResolver().resolveCrossReferencedElementAt(sourceAnnex(resource), offset));
	}

	@Test
	public void translatesMissingOperandAndRestoredExpression() throws Exception {
		var resource = removeOperand();
		assertNull(rightOperand(resource));
		resource.update(text(resource).indexOf("distance > ") + "distance > ".length(), 0, "0");
		validation.assertNoIssues(resource.getContents().getFirst());
		assertEquals(0, ((BehaviorIntegerLiteral) rightOperand(resource)).getValue());
	}

	@Test
	public void toleratesMissingAdditionOperand() throws Exception {
		assertRecoveredReferences("distance + 1", "1");
	}

	@Test
	public void toleratesMissingWhileCondition() throws Exception {
		assertRecoveredReferences("while (true)", "true");
	}

	@Test
	public void toleratesMissingUntilCondition() throws Exception {
		assertRecoveredReferences("until (true)", "true");
	}

	@Test
	public void toleratesMissingArrayIndex() throws Exception {
		assertRecoveredReferences("items[1]", "1");
	}

	@Test
	public void toleratesMissingRangeLowerBound() throws Exception {
		assertRecoveredReferences("in 1 .. 2", "1");
	}

	private void assertRecoveredReferences(String context, String operand) throws Exception {
		var resource = removeOperand("ExpressionContexts.aadl", context, operand);
		var source = sourceAnnex(resource);
		var positions = new ArrayList<TextPositionInfo>();
		new BehaviorAnnexTextPositionResolver().collectReferencePositions(source, positions::add,
				new NullProgressMonitor());
		assertTrue(positions.stream().anyMatch(position -> position.getModelObject()
				== source.getVariableGroups().getFirst().getVariables().getFirst()));
		var offset = text(resource).indexOf(context.replace(operand, "")) + context.indexOf(operand);
		resource.update(offset, 0, operand);
		validation.assertNoIssues(resource.getContents().getFirst());
	}

	private XtextResource removeOperand() throws Exception {
		var resource = removeOperand("Issue3312.aadl", "distance > 0", "0");
		var issues = validation.validate(resource.getContents().getFirst());
		assertEquals(issues.toString(), 1, issues.size());
		assertTrue(issues.toString(), issues.getFirst().isSyntaxError());
		return resource;
	}

	private XtextResource removeOperand(String file, String context, String operand) throws Exception {
		var root = helper.parseFile("org.osate.xtext.aadl2.ba.tests/models/issue3312/" + file);
		validation.assertNoIssues(root);
		var resource = (XtextResource) root.eResource();
		resource.update(text(resource).indexOf(context) + context.indexOf(operand), operand.length(), "");
		var issues = validation.validate(resource.getContents().getFirst());
		assertTrue(issues.toString(), issues.stream()
				.anyMatch(issue -> issue.isSyntaxError() && issue.getSeverity() == Severity.ERROR));
		return resource;
	}

	private static void assertPosition(XtextResource resource, int offset, TextPositionInfo position) {
		assertSame(sourceAnnex(resource).getVariableGroups().getFirst().getVariables().getFirst(),
				position.getModelObject());
		assertEquals(offset, position.getOffset());
		assertEquals("distance".length(), position.getLength());
	}

	private static Value rightOperand(XtextResource resource) {
		var strict = BehaviorAnnexUtil.getStrictModel(defaultAnnex(resource));
		var condition = (IfStatement) strict.getTransitions().getFirst().getActionBlock().getContent();
		return condition.getLogicalValueExpression().getRelations().getFirst().getSecondExpression()
				.getTerms().getFirst().getFactors().getFirst().getFirstValue();
	}

	private static DefaultAnnexSubclause defaultAnnex(XtextResource resource) {
		return AnnexUtil.getAllDefaultAnnexSubclauses((AadlPackage) resource.getContents().getFirst()).getFirst();
	}

	private static BehaviorAnnex sourceAnnex(XtextResource resource) {
		return (BehaviorAnnex) defaultAnnex(resource).getParsedAnnexSubclause();
	}

	private static String text(XtextResource resource) {
		return resource.getParseResult().getRootNode().getText();
	}
}
