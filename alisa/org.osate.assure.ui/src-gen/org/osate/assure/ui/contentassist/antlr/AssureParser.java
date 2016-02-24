/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
package org.osate.assure.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.assure.services.AssureGrammarAccess;

public class AssureParser extends AbstractContentAssistParser {
	
	@Inject
	private AssureGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser createParser() {
		org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser result = new org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getAssureResultAccess().getAlternatives(), "rule__AssureResult__Alternatives");
					put(grammarAccess.getVerificationExprAccess().getAlternatives(), "rule__VerificationExpr__Alternatives");
					put(grammarAccess.getQualifiedVerificationPlanElementReferenceAccess().getAlternatives(), "rule__QualifiedVerificationPlanElementReference__Alternatives");
					put(grammarAccess.getDescriptionElementAccess().getAlternatives(), "rule__DescriptionElement__Alternatives");
					put(grammarAccess.getValDeclarationAccess().getAlternatives_2(), "rule__ValDeclaration__Alternatives_2");
					put(grammarAccess.getComputeDeclarationAccess().getAlternatives_2(), "rule__ComputeDeclaration__Alternatives_2");
					put(grammarAccess.getOpEqualityAccess().getAlternatives(), "rule__OpEquality__Alternatives");
					put(grammarAccess.getOpCompareAccess().getAlternatives(), "rule__OpCompare__Alternatives");
					put(grammarAccess.getOpOtherAccess().getAlternatives(), "rule__OpOther__Alternatives");
					put(grammarAccess.getOpOtherAccess().getAlternatives_5_1(), "rule__OpOther__Alternatives_5_1");
					put(grammarAccess.getOpOtherAccess().getAlternatives_6_1(), "rule__OpOther__Alternatives_6_1");
					put(grammarAccess.getOpAddAccess().getAlternatives(), "rule__OpAdd__Alternatives");
					put(grammarAccess.getOpMultiAccess().getAlternatives(), "rule__OpMulti__Alternatives");
					put(grammarAccess.getAUnaryOperationAccess().getAlternatives(), "rule__AUnaryOperation__Alternatives");
					put(grammarAccess.getOpUnaryAccess().getAlternatives(), "rule__OpUnary__Alternatives");
					put(grammarAccess.getAPrimaryExpressionAccess().getAlternatives(), "rule__APrimaryExpression__Alternatives");
					put(grammarAccess.getALiteralAccess().getAlternatives(), "rule__ALiteral__Alternatives");
					put(grammarAccess.getNumAltAccess().getAlternatives(), "rule__NumAlt__Alternatives");
					put(grammarAccess.getABooleanLiteralAccess().getAlternatives_1(), "rule__ABooleanLiteral__Alternatives_1");
					put(grammarAccess.getComponentCategoryAccess().getAlternatives(), "rule__ComponentCategory__Alternatives");
					put(grammarAccess.getElseTypeAccess().getAlternatives(), "rule__ElseType__Alternatives");
					put(grammarAccess.getVerificationResultStateAccess().getAlternatives(), "rule__VerificationResultState__Alternatives");
					put(grammarAccess.getVerificationExecutionStateAccess().getAlternatives(), "rule__VerificationExecutionState__Alternatives");
					put(grammarAccess.getResultIssueTypeAccess().getAlternatives(), "rule__ResultIssueType__Alternatives");
					put(grammarAccess.getAssuranceCaseResultAccess().getGroup(), "rule__AssuranceCaseResult__Group__0");
					put(grammarAccess.getAssuranceCaseResultAccess().getGroup_4(), "rule__AssuranceCaseResult__Group_4__0");
					put(grammarAccess.getModelResultAccess().getGroup(), "rule__ModelResult__Group__0");
					put(grammarAccess.getModelResultAccess().getGroup_6(), "rule__ModelResult__Group_6__0");
					put(grammarAccess.getSubsystemResultAccess().getGroup(), "rule__SubsystemResult__Group__0");
					put(grammarAccess.getSubsystemResultAccess().getGroup_4(), "rule__SubsystemResult__Group_4__0");
					put(grammarAccess.getClaimResultAccess().getGroup(), "rule__ClaimResult__Group__0");
					put(grammarAccess.getClaimResultAccess().getGroup_4(), "rule__ClaimResult__Group_4__0");
					put(grammarAccess.getClaimResultAccess().getGroup_5(), "rule__ClaimResult__Group_5__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup(), "rule__PreconditionResult__Group__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup_8(), "rule__PreconditionResult__Group_8__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup_9(), "rule__PreconditionResult__Group_9__0");
					put(grammarAccess.getPreconditionResultAccess().getGroup_11(), "rule__PreconditionResult__Group_11__0");
					put(grammarAccess.getValidationResultAccess().getGroup(), "rule__ValidationResult__Group__0");
					put(grammarAccess.getValidationResultAccess().getGroup_8(), "rule__ValidationResult__Group_8__0");
					put(grammarAccess.getValidationResultAccess().getGroup_9(), "rule__ValidationResult__Group_9__0");
					put(grammarAccess.getValidationResultAccess().getGroup_11(), "rule__ValidationResult__Group_11__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup(), "rule__VerificationActivityResult__Group__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_8(), "rule__VerificationActivityResult__Group_8__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_9(), "rule__VerificationActivityResult__Group_9__0");
					put(grammarAccess.getVerificationActivityResultAccess().getGroup_11(), "rule__VerificationActivityResult__Group_11__0");
					put(grammarAccess.getElseResultAccess().getGroup(), "rule__ElseResult__Group__0");
					put(grammarAccess.getElseResultAccess().getGroup_2(), "rule__ElseResult__Group_2__0");
					put(grammarAccess.getElseResultAccess().getGroup_3(), "rule__ElseResult__Group_3__0");
					put(grammarAccess.getElseResultAccess().getGroup_4(), "rule__ElseResult__Group_4__0");
					put(grammarAccess.getThenResultAccess().getGroup(), "rule__ThenResult__Group__0");
					put(grammarAccess.getMetricsAccess().getGroup(), "rule__Metrics__Group__0");
					put(grammarAccess.getMetricsAccess().getGroup_1(), "rule__Metrics__Group_1__0");
					put(grammarAccess.getMetricsAccess().getGroup_2(), "rule__Metrics__Group_2__0");
					put(grammarAccess.getMetricsAccess().getGroup_3(), "rule__Metrics__Group_3__0");
					put(grammarAccess.getMetricsAccess().getGroup_4(), "rule__Metrics__Group_4__0");
					put(grammarAccess.getMetricsAccess().getGroup_5(), "rule__Metrics__Group_5__0");
					put(grammarAccess.getMetricsAccess().getGroup_6(), "rule__Metrics__Group_6__0");
					put(grammarAccess.getMetricsAccess().getGroup_7(), "rule__Metrics__Group_7__0");
					put(grammarAccess.getMetricsAccess().getGroup_8(), "rule__Metrics__Group_8__0");
					put(grammarAccess.getMetricsAccess().getGroup_9(), "rule__Metrics__Group_9__0");
					put(grammarAccess.getMetricsAccess().getGroup_10(), "rule__Metrics__Group_10__0");
					put(grammarAccess.getMetricsAccess().getGroup_11(), "rule__Metrics__Group_11__0");
					put(grammarAccess.getMetricsAccess().getGroup_12(), "rule__Metrics__Group_12__0");
					put(grammarAccess.getMetricsAccess().getGroup_13(), "rule__Metrics__Group_13__0");
					put(grammarAccess.getMetricsAccess().getGroup_14(), "rule__Metrics__Group_14__0");
					put(grammarAccess.getQualifiedClaimReferenceAccess().getGroup(), "rule__QualifiedClaimReference__Group__0");
					put(grammarAccess.getQualifiedVAReferenceAccess().getGroup(), "rule__QualifiedVAReference__Group__0");
					put(grammarAccess.getNestedClaimReferenceAccess().getGroup(), "rule__NestedClaimReference__Group__0");
					put(grammarAccess.getNestedClaimReferenceAccess().getGroup_1(), "rule__NestedClaimReference__Group_1__0");
					put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
					put(grammarAccess.getRationaleAccess().getGroup(), "rule__Rationale__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup(), "rule__Uncertainty__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_0(), "rule__Uncertainty__Group_2_0__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_1(), "rule__Uncertainty__Group_2_1__0");
					put(grammarAccess.getResultIssueAccess().getGroup(), "rule__ResultIssue__Group__0");
					put(grammarAccess.getResultIssueAccess().getGroup_2(), "rule__ResultIssue__Group_2__0");
					put(grammarAccess.getResultIssueAccess().getGroup_3(), "rule__ResultIssue__Group_3__0");
					put(grammarAccess.getResultIssueAccess().getGroup_4(), "rule__ResultIssue__Group_4__0");
					put(grammarAccess.getResultIssueAccess().getGroup_5(), "rule__ResultIssue__Group_5__0");
					put(grammarAccess.getValDeclarationAccess().getGroup(), "rule__ValDeclaration__Group__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_2_0(), "rule__ValDeclaration__Group_2_0__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_2_0_0(), "rule__ValDeclaration__Group_2_0_0__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup(), "rule__ComputeDeclaration__Group__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_2_0(), "rule__ComputeDeclaration__Group_2_0__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_2_0_0(), "rule__ComputeDeclaration__Group_2_0_0__0");
					put(grammarAccess.getAPropertyReferenceAccess().getGroup(), "rule__APropertyReference__Group__0");
					put(grammarAccess.getAVariableReferenceAccess().getGroup(), "rule__AVariableReference__Group__0");
					put(grammarAccess.getShowValueAccess().getGroup(), "rule__ShowValue__Group__0");
					put(grammarAccess.getShowValueAccess().getGroup_1(), "rule__ShowValue__Group_1__0");
					put(grammarAccess.getImageReferenceAccess().getGroup(), "rule__ImageReference__Group__0");
					put(grammarAccess.getIMGREFAccess().getGroup(), "rule__IMGREF__Group__0");
					put(grammarAccess.getIMGREFAccess().getGroup_0(), "rule__IMGREF__Group_0__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup(), "rule__AOrExpression__Group__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup_1(), "rule__AOrExpression__Group_1__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup_1_0(), "rule__AOrExpression__Group_1_0__0");
					put(grammarAccess.getAOrExpressionAccess().getGroup_1_0_0(), "rule__AOrExpression__Group_1_0_0__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup(), "rule__AAndExpression__Group__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup_1(), "rule__AAndExpression__Group_1__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup_1_0(), "rule__AAndExpression__Group_1_0__0");
					put(grammarAccess.getAAndExpressionAccess().getGroup_1_0_0(), "rule__AAndExpression__Group_1_0_0__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup(), "rule__AEqualityExpression__Group__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup_1(), "rule__AEqualityExpression__Group_1__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0(), "rule__AEqualityExpression__Group_1_0__0");
					put(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0_0(), "rule__AEqualityExpression__Group_1_0_0__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup(), "rule__ARelationalExpression__Group__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup_1(), "rule__ARelationalExpression__Group_1__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup_1_0(), "rule__ARelationalExpression__Group_1_0__0");
					put(grammarAccess.getARelationalExpressionAccess().getGroup_1_0_0(), "rule__ARelationalExpression__Group_1_0_0__0");
					put(grammarAccess.getOpCompareAccess().getGroup_1(), "rule__OpCompare__Group_1__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup(), "rule__AOtherOperatorExpression__Group__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup_1(), "rule__AOtherOperatorExpression__Group_1__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup_1_0(), "rule__AOtherOperatorExpression__Group_1_0__0");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getGroup_1_0_0(), "rule__AOtherOperatorExpression__Group_1_0_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_2(), "rule__OpOther__Group_2__0");
					put(grammarAccess.getOpOtherAccess().getGroup_5(), "rule__OpOther__Group_5__0");
					put(grammarAccess.getOpOtherAccess().getGroup_5_1_0(), "rule__OpOther__Group_5_1_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_5_1_0_0(), "rule__OpOther__Group_5_1_0_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_6(), "rule__OpOther__Group_6__0");
					put(grammarAccess.getOpOtherAccess().getGroup_6_1_0(), "rule__OpOther__Group_6_1_0__0");
					put(grammarAccess.getOpOtherAccess().getGroup_6_1_0_0(), "rule__OpOther__Group_6_1_0_0__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup(), "rule__AAdditiveExpression__Group__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1(), "rule__AAdditiveExpression__Group_1__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0(), "rule__AAdditiveExpression__Group_1_0__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0(), "rule__AAdditiveExpression__Group_1_0_0__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup(), "rule__AMultiplicativeExpression__Group__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1(), "rule__AMultiplicativeExpression__Group_1__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0(), "rule__AMultiplicativeExpression__Group_1_0__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0(), "rule__AMultiplicativeExpression__Group_1_0_0__0");
					put(grammarAccess.getAUnaryOperationAccess().getGroup_0(), "rule__AUnaryOperation__Group_0__0");
					put(grammarAccess.getAFunctionCallAccess().getGroup(), "rule__AFunctionCall__Group__0");
					put(grammarAccess.getAFunctionCallAccess().getGroup_4(), "rule__AFunctionCall__Group_4__0");
					put(grammarAccess.getAThisAccess().getGroup(), "rule__AThis__Group__0");
					put(grammarAccess.getAIntegerTermAccess().getGroup(), "rule__AIntegerTerm__Group__0");
					put(grammarAccess.getARealTermAccess().getGroup(), "rule__ARealTerm__Group__0");
					put(grammarAccess.getANumericRangeTermAccess().getGroup(), "rule__ANumericRangeTerm__Group__0");
					put(grammarAccess.getANumericRangeTermAccess().getGroup_3(), "rule__ANumericRangeTerm__Group_3__0");
					put(grammarAccess.getASetTermAccess().getGroup(), "rule__ASetTerm__Group__0");
					put(grammarAccess.getASetTermAccess().getGroup_2(), "rule__ASetTerm__Group_2__0");
					put(grammarAccess.getASetTermAccess().getGroup_2_1(), "rule__ASetTerm__Group_2_1__0");
					put(grammarAccess.getAListTermAccess().getGroup(), "rule__AListTerm__Group__0");
					put(grammarAccess.getAListTermAccess().getGroup_3(), "rule__AListTerm__Group_3__0");
					put(grammarAccess.getAListTermAccess().getGroup_3_1(), "rule__AListTerm__Group_3_1__0");
					put(grammarAccess.getAParenthesizedExpressionAccess().getGroup(), "rule__AParenthesizedExpression__Group__0");
					put(grammarAccess.getABooleanLiteralAccess().getGroup(), "rule__ABooleanLiteral__Group__0");
					put(grammarAccess.getANullLiteralAccess().getGroup(), "rule__ANullLiteral__Group__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_8(), "rule__ComponentCategory__Group_8__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_10(), "rule__ComponentCategory__Group_10__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_12(), "rule__ComponentCategory__Group_12__0");
					put(grammarAccess.getComponentCategoryAccess().getGroup_13(), "rule__ComponentCategory__Group_13__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup(), "rule__AadlClassifierReference__Group__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1(), "rule__AadlClassifierReference__Group_1__0");
					put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_2(), "rule__AadlClassifierReference__Group_2__0");
					put(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup(), "rule__AADLPROPERTYREFERENCE__Group__0");
					put(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup_1(), "rule__AADLPROPERTYREFERENCE__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getAssuranceCaseResultAccess().getNameAssignment_1(), "rule__AssuranceCaseResult__NameAssignment_1");
					put(grammarAccess.getAssuranceCaseResultAccess().getMetricsAssignment_3(), "rule__AssuranceCaseResult__MetricsAssignment_3");
					put(grammarAccess.getAssuranceCaseResultAccess().getMessageAssignment_4_1(), "rule__AssuranceCaseResult__MessageAssignment_4_1");
					put(grammarAccess.getAssuranceCaseResultAccess().getModelResultAssignment_5(), "rule__AssuranceCaseResult__ModelResultAssignment_5");
					put(grammarAccess.getModelResultAccess().getPlanAssignment_1(), "rule__ModelResult__PlanAssignment_1");
					put(grammarAccess.getModelResultAccess().getTargetAssignment_3(), "rule__ModelResult__TargetAssignment_3");
					put(grammarAccess.getModelResultAccess().getMetricsAssignment_5(), "rule__ModelResult__MetricsAssignment_5");
					put(grammarAccess.getModelResultAccess().getMessageAssignment_6_1(), "rule__ModelResult__MessageAssignment_6_1");
					put(grammarAccess.getModelResultAccess().getClaimResultAssignment_7(), "rule__ModelResult__ClaimResultAssignment_7");
					put(grammarAccess.getModelResultAccess().getSubsystemResultAssignment_8(), "rule__ModelResult__SubsystemResultAssignment_8");
					put(grammarAccess.getModelResultAccess().getSubAssuranceCaseAssignment_9(), "rule__ModelResult__SubAssuranceCaseAssignment_9");
					put(grammarAccess.getSubsystemResultAccess().getTargetSystemAssignment_1(), "rule__SubsystemResult__TargetSystemAssignment_1");
					put(grammarAccess.getSubsystemResultAccess().getMetricsAssignment_3(), "rule__SubsystemResult__MetricsAssignment_3");
					put(grammarAccess.getSubsystemResultAccess().getMessageAssignment_4_1(), "rule__SubsystemResult__MessageAssignment_4_1");
					put(grammarAccess.getSubsystemResultAccess().getClaimResultAssignment_5(), "rule__SubsystemResult__ClaimResultAssignment_5");
					put(grammarAccess.getSubsystemResultAccess().getSubsystemResultAssignment_6(), "rule__SubsystemResult__SubsystemResultAssignment_6");
					put(grammarAccess.getClaimResultAccess().getTargetReferenceAssignment_1(), "rule__ClaimResult__TargetReferenceAssignment_1");
					put(grammarAccess.getClaimResultAccess().getMetricsAssignment_3(), "rule__ClaimResult__MetricsAssignment_3");
					put(grammarAccess.getClaimResultAccess().getModelElementAssignment_4_1(), "rule__ClaimResult__ModelElementAssignment_4_1");
					put(grammarAccess.getClaimResultAccess().getMessageAssignment_5_1(), "rule__ClaimResult__MessageAssignment_5_1");
					put(grammarAccess.getClaimResultAccess().getSubClaimResultAssignment_6(), "rule__ClaimResult__SubClaimResultAssignment_6");
					put(grammarAccess.getClaimResultAccess().getVerificationActivityResultAssignment_7(), "rule__ClaimResult__VerificationActivityResultAssignment_7");
					put(grammarAccess.getPreconditionResultAccess().getTargetAssignment_2(), "rule__PreconditionResult__TargetAssignment_2");
					put(grammarAccess.getPreconditionResultAccess().getExecutionStateAssignment_5(), "rule__PreconditionResult__ExecutionStateAssignment_5");
					put(grammarAccess.getPreconditionResultAccess().getResultStateAssignment_7(), "rule__PreconditionResult__ResultStateAssignment_7");
					put(grammarAccess.getPreconditionResultAccess().getIssuesAssignment_8_2(), "rule__PreconditionResult__IssuesAssignment_8_2");
					put(grammarAccess.getPreconditionResultAccess().getResultReportAssignment_9_1(), "rule__PreconditionResult__ResultReportAssignment_9_1");
					put(grammarAccess.getPreconditionResultAccess().getMetricsAssignment_10(), "rule__PreconditionResult__MetricsAssignment_10");
					put(grammarAccess.getPreconditionResultAccess().getMessageAssignment_11_1(), "rule__PreconditionResult__MessageAssignment_11_1");
					put(grammarAccess.getValidationResultAccess().getTargetAssignment_2(), "rule__ValidationResult__TargetAssignment_2");
					put(grammarAccess.getValidationResultAccess().getExecutionStateAssignment_5(), "rule__ValidationResult__ExecutionStateAssignment_5");
					put(grammarAccess.getValidationResultAccess().getResultStateAssignment_7(), "rule__ValidationResult__ResultStateAssignment_7");
					put(grammarAccess.getValidationResultAccess().getIssuesAssignment_8_2(), "rule__ValidationResult__IssuesAssignment_8_2");
					put(grammarAccess.getValidationResultAccess().getResultReportAssignment_9_1(), "rule__ValidationResult__ResultReportAssignment_9_1");
					put(grammarAccess.getValidationResultAccess().getMetricsAssignment_10(), "rule__ValidationResult__MetricsAssignment_10");
					put(grammarAccess.getValidationResultAccess().getMessageAssignment_11_1(), "rule__ValidationResult__MessageAssignment_11_1");
					put(grammarAccess.getVerificationActivityResultAccess().getTargetReferenceAssignment_2(), "rule__VerificationActivityResult__TargetReferenceAssignment_2");
					put(grammarAccess.getVerificationActivityResultAccess().getExecutionStateAssignment_5(), "rule__VerificationActivityResult__ExecutionStateAssignment_5");
					put(grammarAccess.getVerificationActivityResultAccess().getResultStateAssignment_7(), "rule__VerificationActivityResult__ResultStateAssignment_7");
					put(grammarAccess.getVerificationActivityResultAccess().getIssuesAssignment_8_2(), "rule__VerificationActivityResult__IssuesAssignment_8_2");
					put(grammarAccess.getVerificationActivityResultAccess().getResultReportAssignment_9_1(), "rule__VerificationActivityResult__ResultReportAssignment_9_1");
					put(grammarAccess.getVerificationActivityResultAccess().getMetricsAssignment_10(), "rule__VerificationActivityResult__MetricsAssignment_10");
					put(grammarAccess.getVerificationActivityResultAccess().getMessageAssignment_11_1(), "rule__VerificationActivityResult__MessageAssignment_11_1");
					put(grammarAccess.getVerificationActivityResultAccess().getPreconditionResultAssignment_12(), "rule__VerificationActivityResult__PreconditionResultAssignment_12");
					put(grammarAccess.getVerificationActivityResultAccess().getValidationResultAssignment_13(), "rule__VerificationActivityResult__ValidationResultAssignment_13");
					put(grammarAccess.getElseResultAccess().getFirstAssignment_1(), "rule__ElseResult__FirstAssignment_1");
					put(grammarAccess.getElseResultAccess().getErrorAssignment_2_1(), "rule__ElseResult__ErrorAssignment_2_1");
					put(grammarAccess.getElseResultAccess().getFailAssignment_3_1(), "rule__ElseResult__FailAssignment_3_1");
					put(grammarAccess.getElseResultAccess().getTimeoutAssignment_4_1(), "rule__ElseResult__TimeoutAssignment_4_1");
					put(grammarAccess.getElseResultAccess().getDidFailAssignment_6(), "rule__ElseResult__DidFailAssignment_6");
					put(grammarAccess.getElseResultAccess().getMetricsAssignment_7(), "rule__ElseResult__MetricsAssignment_7");
					put(grammarAccess.getThenResultAccess().getFirstAssignment_1(), "rule__ThenResult__FirstAssignment_1");
					put(grammarAccess.getThenResultAccess().getSecondAssignment_3(), "rule__ThenResult__SecondAssignment_3");
					put(grammarAccess.getThenResultAccess().getDidThenFailAssignment_5(), "rule__ThenResult__DidThenFailAssignment_5");
					put(grammarAccess.getThenResultAccess().getMetricsAssignment_6(), "rule__ThenResult__MetricsAssignment_6");
					put(grammarAccess.getMetricsAccess().getTbdCountAssignment_1_1(), "rule__Metrics__TbdCountAssignment_1_1");
					put(grammarAccess.getMetricsAccess().getSuccessCountAssignment_2_1(), "rule__Metrics__SuccessCountAssignment_2_1");
					put(grammarAccess.getMetricsAccess().getFailCountAssignment_3_1(), "rule__Metrics__FailCountAssignment_3_1");
					put(grammarAccess.getMetricsAccess().getTimeoutCountAssignment_4_1(), "rule__Metrics__TimeoutCountAssignment_4_1");
					put(grammarAccess.getMetricsAccess().getErrorCountAssignment_5_1(), "rule__Metrics__ErrorCountAssignment_5_1");
					put(grammarAccess.getMetricsAccess().getDidelseCountAssignment_6_1(), "rule__Metrics__DidelseCountAssignment_6_1");
					put(grammarAccess.getMetricsAccess().getThenskipCountAssignment_7_1(), "rule__Metrics__ThenskipCountAssignment_7_1");
					put(grammarAccess.getMetricsAccess().getPreconditionfailCountAssignment_8_1(), "rule__Metrics__PreconditionfailCountAssignment_8_1");
					put(grammarAccess.getMetricsAccess().getValidationfailCountAssignment_9_1(), "rule__Metrics__ValidationfailCountAssignment_9_1");
					put(grammarAccess.getMetricsAccess().getFeaturesCountAssignment_10_1(), "rule__Metrics__FeaturesCountAssignment_10_1");
					put(grammarAccess.getMetricsAccess().getFeaturesRequirementsCountAssignment_11_1(), "rule__Metrics__FeaturesRequirementsCountAssignment_11_1");
					put(grammarAccess.getMetricsAccess().getQualityCategoryRequirementsCountAssignment_12_1(), "rule__Metrics__QualityCategoryRequirementsCountAssignment_12_1");
					put(grammarAccess.getMetricsAccess().getWeightAssignment_13_1(), "rule__Metrics__WeightAssignment_13_1");
					put(grammarAccess.getMetricsAccess().getExecutionTimeAssignment_14_1(), "rule__Metrics__ExecutionTimeAssignment_14_1");
					put(grammarAccess.getQualifiedClaimReferenceAccess().getVerificationPlanAssignment_0(), "rule__QualifiedClaimReference__VerificationPlanAssignment_0");
					put(grammarAccess.getQualifiedClaimReferenceAccess().getRequirementAssignment_2(), "rule__QualifiedClaimReference__RequirementAssignment_2");
					put(grammarAccess.getQualifiedVAReferenceAccess().getVerificationPlanAssignment_0(), "rule__QualifiedVAReference__VerificationPlanAssignment_0");
					put(grammarAccess.getQualifiedVAReferenceAccess().getRequirementAssignment_2(), "rule__QualifiedVAReference__RequirementAssignment_2");
					put(grammarAccess.getQualifiedVAReferenceAccess().getVerificationActivityAssignment_4(), "rule__QualifiedVAReference__VerificationActivityAssignment_4");
					put(grammarAccess.getNestedClaimReferenceAccess().getRequirementAssignment_0(), "rule__NestedClaimReference__RequirementAssignment_0");
					put(grammarAccess.getNestedClaimReferenceAccess().getSubAssignment_1_1(), "rule__NestedClaimReference__SubAssignment_1_1");
					put(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1(), "rule__Description__DescriptionAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getTextAssignment_0(), "rule__DescriptionElement__TextAssignment_0");
					put(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_1(), "rule__DescriptionElement__ShowValueAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_2(), "rule__DescriptionElement__ThisTargetAssignment_2");
					put(grammarAccess.getDescriptionElementAccess().getImageAssignment_3(), "rule__DescriptionElement__ImageAssignment_3");
					put(grammarAccess.getRationaleAccess().getTextAssignment_1(), "rule__Rationale__TextAssignment_1");
					put(grammarAccess.getUncertaintyAccess().getVolatilityAssignment_2_0_1(), "rule__Uncertainty__VolatilityAssignment_2_0_1");
					put(grammarAccess.getUncertaintyAccess().getImpactAssignment_2_1_1(), "rule__Uncertainty__ImpactAssignment_2_1_1");
					put(grammarAccess.getResultIssueAccess().getIssueTypeAssignment_0(), "rule__ResultIssue__IssueTypeAssignment_0");
					put(grammarAccess.getResultIssueAccess().getMessageAssignment_1(), "rule__ResultIssue__MessageAssignment_1");
					put(grammarAccess.getResultIssueAccess().getTargetAssignment_2_1(), "rule__ResultIssue__TargetAssignment_2_1");
					put(grammarAccess.getResultIssueAccess().getExceptionTypeAssignment_3_1(), "rule__ResultIssue__ExceptionTypeAssignment_3_1");
					put(grammarAccess.getResultIssueAccess().getDiagnosticIdAssignment_4_1(), "rule__ResultIssue__DiagnosticIdAssignment_4_1");
					put(grammarAccess.getResultIssueAccess().getIssuesAssignment_5_1(), "rule__ResultIssue__IssuesAssignment_5_1");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_2_0_0_0(), "rule__ValDeclaration__TypeAssignment_2_0_0_0");
					put(grammarAccess.getValDeclarationAccess().getNameAssignment_2_0_0_1(), "rule__ValDeclaration__NameAssignment_2_0_0_1");
					put(grammarAccess.getValDeclarationAccess().getNameAssignment_2_1(), "rule__ValDeclaration__NameAssignment_2_1");
					put(grammarAccess.getValDeclarationAccess().getRightAssignment_4(), "rule__ValDeclaration__RightAssignment_4");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_2_0_0_0(), "rule__ComputeDeclaration__TypeAssignment_2_0_0_0");
					put(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2_0_0_1(), "rule__ComputeDeclaration__NameAssignment_2_0_0_1");
					put(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2_1(), "rule__ComputeDeclaration__NameAssignment_2_1");
					put(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2(), "rule__APropertyReference__PropertyAssignment_2");
					put(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1(), "rule__AVariableReference__VariableAssignment_1");
					put(grammarAccess.getShowValueAccess().getRefAssignment_0(), "rule__ShowValue__RefAssignment_0");
					put(grammarAccess.getShowValueAccess().getUnitAssignment_1_1(), "rule__ShowValue__UnitAssignment_1_1");
					put(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1(), "rule__ImageReference__ImgfileAssignment_1");
					put(grammarAccess.getAOrExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AOrExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAOrExpressionAccess().getRightOperandAssignment_1_1(), "rule__AOrExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAAndExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AAndExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAAndExpressionAccess().getRightOperandAssignment_1_1(), "rule__AAndExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAEqualityExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AEqualityExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAEqualityExpressionAccess().getRightOperandAssignment_1_1(), "rule__AEqualityExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getARelationalExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__ARelationalExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getARelationalExpressionAccess().getRightOperandAssignment_1_1(), "rule__ARelationalExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AOtherOperatorExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAOtherOperatorExpressionAccess().getRightOperandAssignment_1_1(), "rule__AOtherOperatorExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AAdditiveExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAAdditiveExpressionAccess().getRightOperandAssignment_1_1(), "rule__AAdditiveExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1(), "rule__AMultiplicativeExpression__FeatureAssignment_1_0_0_1");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getRightOperandAssignment_1_1(), "rule__AMultiplicativeExpression__RightOperandAssignment_1_1");
					put(grammarAccess.getAUnaryOperationAccess().getFeatureAssignment_0_1(), "rule__AUnaryOperation__FeatureAssignment_0_1");
					put(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2(), "rule__AUnaryOperation__OperandAssignment_0_2");
					put(grammarAccess.getAFunctionCallAccess().getFunctionAssignment_1(), "rule__AFunctionCall__FunctionAssignment_1");
					put(grammarAccess.getAFunctionCallAccess().getFunctionCallArgumentsAssignment_3(), "rule__AFunctionCall__FunctionCallArgumentsAssignment_3");
					put(grammarAccess.getAFunctionCallAccess().getFunctionCallArgumentsAssignment_4_1(), "rule__AFunctionCall__FunctionCallArgumentsAssignment_4_1");
					put(grammarAccess.getAIntegerTermAccess().getValueAssignment_0(), "rule__AIntegerTerm__ValueAssignment_0");
					put(grammarAccess.getAIntegerTermAccess().getUnitAssignment_1(), "rule__AIntegerTerm__UnitAssignment_1");
					put(grammarAccess.getARealTermAccess().getValueAssignment_0(), "rule__ARealTerm__ValueAssignment_0");
					put(grammarAccess.getARealTermAccess().getUnitAssignment_1(), "rule__ARealTerm__UnitAssignment_1");
					put(grammarAccess.getANumericRangeTermAccess().getMinimumAssignment_0(), "rule__ANumericRangeTerm__MinimumAssignment_0");
					put(grammarAccess.getANumericRangeTermAccess().getMaximumAssignment_2(), "rule__ANumericRangeTerm__MaximumAssignment_2");
					put(grammarAccess.getANumericRangeTermAccess().getDeltaAssignment_3_1(), "rule__ANumericRangeTerm__DeltaAssignment_3_1");
					put(grammarAccess.getASetTermAccess().getElementsAssignment_2_0(), "rule__ASetTerm__ElementsAssignment_2_0");
					put(grammarAccess.getASetTermAccess().getElementsAssignment_2_1_1(), "rule__ASetTerm__ElementsAssignment_2_1_1");
					put(grammarAccess.getAListTermAccess().getElementsAssignment_3_0(), "rule__AListTerm__ElementsAssignment_3_0");
					put(grammarAccess.getAListTermAccess().getElementsAssignment_3_1_1(), "rule__AListTerm__ElementsAssignment_3_1_1");
					put(grammarAccess.getABooleanLiteralAccess().getValueAssignment_1_0(), "rule__ABooleanLiteral__ValueAssignment_1_0");
					put(grammarAccess.getStringTermAccess().getValueAssignment(), "rule__StringTerm__ValueAssignment");
					put(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), "rule__Uncertainty__UnorderedGroup_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser typedParser = (org.osate.assure.ui.contentassist.antlr.internal.InternalAssureParser) parser;
			typedParser.entryRuleAssuranceCaseResult();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public AssureGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(AssureGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
