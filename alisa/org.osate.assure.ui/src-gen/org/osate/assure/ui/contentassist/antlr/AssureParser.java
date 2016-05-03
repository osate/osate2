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
					put(grammarAccess.getModelResultAccess().getAlternatives_8(), "rule__ModelResult__Alternatives_8");
					put(grammarAccess.getAssureResultAccess().getAlternatives(), "rule__AssureResult__Alternatives");
					put(grammarAccess.getVerificationExprAccess().getAlternatives(), "rule__VerificationExpr__Alternatives");
					put(grammarAccess.getQualifiedVerificationPlanElementReferenceAccess().getAlternatives(), "rule__QualifiedVerificationPlanElementReference__Alternatives");
					put(grammarAccess.getDescriptionElementAccess().getAlternatives(), "rule__DescriptionElement__Alternatives");
					put(grammarAccess.getTypeRefAccess().getAlternatives(), "rule__TypeRef__Alternatives");
					put(grammarAccess.getValDeclarationAccess().getAlternatives_3_1(), "rule__ValDeclaration__Alternatives_3_1");
					put(grammarAccess.getValDeclarationAccess().getAlternatives_3_1_2_1(), "rule__ValDeclaration__Alternatives_3_1_2_1");
					put(grammarAccess.getComputeDeclarationAccess().getAlternatives_4(), "rule__ComputeDeclaration__Alternatives_4");
					put(grammarAccess.getComputeDeclarationAccess().getAlternatives_4_2_1(), "rule__ComputeDeclaration__Alternatives_4_2_1");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getAlternatives(), "rule__AModelOrPropertyReference__Alternatives");
					put(grammarAccess.getShowValueAccess().getAlternatives_1(), "rule__ShowValue__Alternatives_1");
					put(grammarAccess.getOpOrAccess().getAlternatives(), "rule__OpOr__Alternatives");
					put(grammarAccess.getOpAndAccess().getAlternatives(), "rule__OpAnd__Alternatives");
					put(grammarAccess.getOpEqualityAccess().getAlternatives(), "rule__OpEquality__Alternatives");
					put(grammarAccess.getOpCompareAccess().getAlternatives(), "rule__OpCompare__Alternatives");
					put(grammarAccess.getOpAddAccess().getAlternatives(), "rule__OpAdd__Alternatives");
					put(grammarAccess.getOpMultiAccess().getAlternatives(), "rule__OpMulti__Alternatives");
					put(grammarAccess.getAUnaryOperationAccess().getAlternatives(), "rule__AUnaryOperation__Alternatives");
					put(grammarAccess.getOpUnaryAccess().getAlternatives(), "rule__OpUnary__Alternatives");
					put(grammarAccess.getAUnitExpressionAccess().getAlternatives_1_1(), "rule__AUnitExpression__Alternatives_1_1");
					put(grammarAccess.getAPrimaryExpressionAccess().getAlternatives(), "rule__APrimaryExpression__Alternatives");
					put(grammarAccess.getALiteralAccess().getAlternatives(), "rule__ALiteral__Alternatives");
					put(grammarAccess.getABooleanLiteralAccess().getAlternatives_1(), "rule__ABooleanLiteral__Alternatives_1");
					put(grammarAccess.getComponentCategoryAccess().getAlternatives(), "rule__ComponentCategory__Alternatives");
					put(grammarAccess.getElseTypeAccess().getAlternatives(), "rule__ElseType__Alternatives");
					put(grammarAccess.getVerificationResultStateAccess().getAlternatives(), "rule__VerificationResultState__Alternatives");
					put(grammarAccess.getVerificationExecutionStateAccess().getAlternatives(), "rule__VerificationExecutionState__Alternatives");
					put(grammarAccess.getResultIssueTypeAccess().getAlternatives(), "rule__ResultIssueType__Alternatives");
					put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
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
					put(grammarAccess.getMetricsAccess().getGroup_15(), "rule__Metrics__Group_15__0");
					put(grammarAccess.getMetricsAccess().getGroup_16(), "rule__Metrics__Group_16__0");
					put(grammarAccess.getMetricsAccess().getGroup_17(), "rule__Metrics__Group_17__0");
					put(grammarAccess.getMetricsAccess().getGroup_18(), "rule__Metrics__Group_18__0");
					put(grammarAccess.getMetricsAccess().getGroup_19(), "rule__Metrics__Group_19__0");
					put(grammarAccess.getMetricsAccess().getGroup_20(), "rule__Metrics__Group_20__0");
					put(grammarAccess.getMetricsAccess().getGroup_21(), "rule__Metrics__Group_21__0");
					put(grammarAccess.getMetricsAccess().getGroup_22(), "rule__Metrics__Group_22__0");
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
					put(grammarAccess.getTypeRefAccess().getGroup_0(), "rule__TypeRef__Group_0__0");
					put(grammarAccess.getTypeRefAccess().getGroup_1(), "rule__TypeRef__Group_1__0");
					put(grammarAccess.getTypeRefAccess().getGroup_1_2(), "rule__TypeRef__Group_1_2__0");
					put(grammarAccess.getTypeRefAccess().getGroup_2(), "rule__TypeRef__Group_2__0");
					put(grammarAccess.getTypeRefAccess().getGroup_2_2(), "rule__TypeRef__Group_2_2__0");
					put(grammarAccess.getTypeRefAccess().getGroup_3(), "rule__TypeRef__Group_3__0");
					put(grammarAccess.getTypeRefAccess().getGroup_4(), "rule__TypeRef__Group_4__0");
					put(grammarAccess.getTypeRefAccess().getGroup_5(), "rule__TypeRef__Group_5__0");
					put(grammarAccess.getPropertyRefAccess().getGroup(), "rule__PropertyRef__Group__0");
					put(grammarAccess.getValDeclarationAccess().getGroup(), "rule__ValDeclaration__Group__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3(), "rule__ValDeclaration__Group_3__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3_1_1(), "rule__ValDeclaration__Group_3_1_1__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3_1_2(), "rule__ValDeclaration__Group_3_1_2__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3_1_2_1_1(), "rule__ValDeclaration__Group_3_1_2_1_1__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup(), "rule__ComputeDeclaration__Group__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_4_1(), "rule__ComputeDeclaration__Group_4_1__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_4_2(), "rule__ComputeDeclaration__Group_4_2__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_4_2_1_1(), "rule__ComputeDeclaration__Group_4_2_1_1__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0(), "rule__AModelOrPropertyReference__Group_0__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1(), "rule__AModelOrPropertyReference__Group_0_1__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0(), "rule__AModelOrPropertyReference__Group_0_1_0__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0_0(), "rule__AModelOrPropertyReference__Group_0_1_0_0__0");
					put(grammarAccess.getNestedModelelementAccess().getGroup(), "rule__NestedModelelement__Group__0");
					put(grammarAccess.getNestedModelelementAccess().getGroup_1(), "rule__NestedModelelement__Group_1__0");
					put(grammarAccess.getAModelReferenceAccess().getGroup(), "rule__AModelReference__Group__0");
					put(grammarAccess.getAModelReferenceAccess().getGroup_1(), "rule__AModelReference__Group_1__0");
					put(grammarAccess.getAPropertyReferenceAccess().getGroup(), "rule__APropertyReference__Group__0");
					put(grammarAccess.getAVariableReferenceAccess().getGroup(), "rule__AVariableReference__Group__0");
					put(grammarAccess.getShowValueAccess().getGroup(), "rule__ShowValue__Group__0");
					put(grammarAccess.getShowValueAccess().getGroup_1_1(), "rule__ShowValue__Group_1_1__0");
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
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup(), "rule__AAdditiveExpression__Group__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1(), "rule__AAdditiveExpression__Group_1__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0(), "rule__AAdditiveExpression__Group_1_0__0");
					put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0(), "rule__AAdditiveExpression__Group_1_0_0__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup(), "rule__AMultiplicativeExpression__Group__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1(), "rule__AMultiplicativeExpression__Group_1__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0(), "rule__AMultiplicativeExpression__Group_1_0__0");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0(), "rule__AMultiplicativeExpression__Group_1_0_0__0");
					put(grammarAccess.getAUnaryOperationAccess().getGroup_0(), "rule__AUnaryOperation__Group_0__0");
					put(grammarAccess.getAUnitExpressionAccess().getGroup(), "rule__AUnitExpression__Group__0");
					put(grammarAccess.getAUnitExpressionAccess().getGroup_1(), "rule__AUnitExpression__Group_1__0");
					put(grammarAccess.getAFunctionCallAccess().getGroup(), "rule__AFunctionCall__Group__0");
					put(grammarAccess.getAFunctionCallAccess().getGroup_4(), "rule__AFunctionCall__Group_4__0");
					put(grammarAccess.getARangeExpressionAccess().getGroup(), "rule__ARangeExpression__Group__0");
					put(grammarAccess.getARangeExpressionAccess().getGroup_5(), "rule__ARangeExpression__Group_5__0");
					put(grammarAccess.getAIfExpressionAccess().getGroup(), "rule__AIfExpression__Group__0");
					put(grammarAccess.getAIfExpressionAccess().getGroup_5(), "rule__AIfExpression__Group_5__0");
					put(grammarAccess.getABooleanLiteralAccess().getGroup(), "rule__ABooleanLiteral__Group__0");
					put(grammarAccess.getAParenthesizedExpressionAccess().getGroup(), "rule__AParenthesizedExpression__Group__0");
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
					put(grammarAccess.getModelResultAccess().getSubsystemResultAssignment_8_0(), "rule__ModelResult__SubsystemResultAssignment_8_0");
					put(grammarAccess.getModelResultAccess().getSubAssuranceCaseAssignment_8_1(), "rule__ModelResult__SubAssuranceCaseAssignment_8_1");
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
					put(grammarAccess.getMetricsAccess().getTotalQualityCategoryCountAssignment_13_1(), "rule__Metrics__TotalQualityCategoryCountAssignment_13_1");
					put(grammarAccess.getMetricsAccess().getRequirementsWithoutPlanClaimCountAssignment_14_1(), "rule__Metrics__RequirementsWithoutPlanClaimCountAssignment_14_1");
					put(grammarAccess.getMetricsAccess().getNoVerificationPlansCountAssignment_15_1(), "rule__Metrics__NoVerificationPlansCountAssignment_15_1");
					put(grammarAccess.getMetricsAccess().getRequirementsCountAssignment_16_1(), "rule__Metrics__RequirementsCountAssignment_16_1");
					put(grammarAccess.getMetricsAccess().getExceptionsCountAssignment_17_1(), "rule__Metrics__ExceptionsCountAssignment_17_1");
					put(grammarAccess.getMetricsAccess().getReqTargetHasEMV2SubclauseCountAssignment_18_1(), "rule__Metrics__ReqTargetHasEMV2SubclauseCountAssignment_18_1");
					put(grammarAccess.getMetricsAccess().getFeaturesRequiringClassifierCountAssignment_19_1(), "rule__Metrics__FeaturesRequiringClassifierCountAssignment_19_1");
					put(grammarAccess.getMetricsAccess().getFeaturesWithRequiredClassifierCountAssignment_20_1(), "rule__Metrics__FeaturesWithRequiredClassifierCountAssignment_20_1");
					put(grammarAccess.getMetricsAccess().getWeightAssignment_21_1(), "rule__Metrics__WeightAssignment_21_1");
					put(grammarAccess.getMetricsAccess().getExecutionTimeAssignment_22_1(), "rule__Metrics__ExecutionTimeAssignment_22_1");
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
					put(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_1_2_1(), "rule__TypeRef__ReferencedUnitsTypeAssignment_1_2_1");
					put(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_2_2_1(), "rule__TypeRef__ReferencedUnitsTypeAssignment_2_2_1");
					put(grammarAccess.getTypeRefAccess().getRefAssignment_5_1(), "rule__TypeRef__RefAssignment_5_1");
					put(grammarAccess.getPropertyRefAccess().getRefAssignment_1(), "rule__PropertyRef__RefAssignment_1");
					put(grammarAccess.getValDeclarationAccess().getNameAssignment_2(), "rule__ValDeclaration__NameAssignment_2");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_0(), "rule__ValDeclaration__TypeAssignment_3_1_0");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_1_1(), "rule__ValDeclaration__TypeAssignment_3_1_1_1");
					put(grammarAccess.getValDeclarationAccess().getRangeAssignment_3_1_2_0(), "rule__ValDeclaration__RangeAssignment_3_1_2_0");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_0(), "rule__ValDeclaration__TypeAssignment_3_1_2_1_0");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_1_1(), "rule__ValDeclaration__TypeAssignment_3_1_2_1_1_1");
					put(grammarAccess.getValDeclarationAccess().getValueAssignment_5(), "rule__ValDeclaration__ValueAssignment_5");
					put(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2(), "rule__ComputeDeclaration__NameAssignment_2");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_0(), "rule__ComputeDeclaration__TypeAssignment_4_0");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_1_1(), "rule__ComputeDeclaration__TypeAssignment_4_1_1");
					put(grammarAccess.getComputeDeclarationAccess().getRangeAssignment_4_2_0(), "rule__ComputeDeclaration__RangeAssignment_4_2_0");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_0(), "rule__ComputeDeclaration__TypeAssignment_4_2_1_0");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_1_1(), "rule__ComputeDeclaration__TypeAssignment_4_2_1_1_1");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1(), "rule__AModelOrPropertyReference__PropertyAssignment_0_1_1");
					put(grammarAccess.getNestedModelelementAccess().getModelElementAssignment_0(), "rule__NestedModelelement__ModelElementAssignment_0");
					put(grammarAccess.getNestedModelelementAccess().getNextAssignment_1_1(), "rule__NestedModelelement__NextAssignment_1_1");
					put(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_0(), "rule__AModelReference__ModelElementAssignment_0");
					put(grammarAccess.getAModelReferenceAccess().getNextAssignment_1_1(), "rule__AModelReference__NextAssignment_1_1");
					put(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2(), "rule__APropertyReference__PropertyAssignment_2");
					put(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1(), "rule__AVariableReference__VariableAssignment_1");
					put(grammarAccess.getShowValueAccess().getRefAssignment_0(), "rule__ShowValue__RefAssignment_0");
					put(grammarAccess.getShowValueAccess().getUnitAssignment_1_1_1(), "rule__ShowValue__UnitAssignment_1_1_1");
					put(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1(), "rule__ImageReference__ImgfileAssignment_1");
					put(grammarAccess.getAOrExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AOrExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAOrExpressionAccess().getRightAssignment_1_1(), "rule__AOrExpression__RightAssignment_1_1");
					put(grammarAccess.getAAndExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AAndExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAAndExpressionAccess().getRightAssignment_1_1(), "rule__AAndExpression__RightAssignment_1_1");
					put(grammarAccess.getAEqualityExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AEqualityExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAEqualityExpressionAccess().getRightAssignment_1_1(), "rule__AEqualityExpression__RightAssignment_1_1");
					put(grammarAccess.getARelationalExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__ARelationalExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getARelationalExpressionAccess().getRightAssignment_1_1(), "rule__ARelationalExpression__RightAssignment_1_1");
					put(grammarAccess.getAAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AAdditiveExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAAdditiveExpressionAccess().getRightAssignment_1_1(), "rule__AAdditiveExpression__RightAssignment_1_1");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AMultiplicativeExpression__OperatorAssignment_1_0_0_1");
					put(grammarAccess.getAMultiplicativeExpressionAccess().getRightAssignment_1_1(), "rule__AMultiplicativeExpression__RightAssignment_1_1");
					put(grammarAccess.getAUnaryOperationAccess().getOperatorAssignment_0_1(), "rule__AUnaryOperation__OperatorAssignment_0_1");
					put(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2(), "rule__AUnaryOperation__OperandAssignment_0_2");
					put(grammarAccess.getAUnitExpressionAccess().getConvertAssignment_1_1_0(), "rule__AUnitExpression__ConvertAssignment_1_1_0");
					put(grammarAccess.getAUnitExpressionAccess().getDropAssignment_1_1_1(), "rule__AUnitExpression__DropAssignment_1_1_1");
					put(grammarAccess.getAUnitExpressionAccess().getUnitAssignment_1_2(), "rule__AUnitExpression__UnitAssignment_1_2");
					put(grammarAccess.getAFunctionCallAccess().getFunctionAssignment_1(), "rule__AFunctionCall__FunctionAssignment_1");
					put(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3(), "rule__AFunctionCall__ArgumentsAssignment_3");
					put(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_4_1(), "rule__AFunctionCall__ArgumentsAssignment_4_1");
					put(grammarAccess.getARangeExpressionAccess().getMinimumAssignment_2(), "rule__ARangeExpression__MinimumAssignment_2");
					put(grammarAccess.getARangeExpressionAccess().getMaximumAssignment_4(), "rule__ARangeExpression__MaximumAssignment_4");
					put(grammarAccess.getARangeExpressionAccess().getDeltaAssignment_5_1(), "rule__ARangeExpression__DeltaAssignment_5_1");
					put(grammarAccess.getAIfExpressionAccess().getIfAssignment_2(), "rule__AIfExpression__IfAssignment_2");
					put(grammarAccess.getAIfExpressionAccess().getThenAssignment_4(), "rule__AIfExpression__ThenAssignment_4");
					put(grammarAccess.getAIfExpressionAccess().getElseAssignment_5_1(), "rule__AIfExpression__ElseAssignment_5_1");
					put(grammarAccess.getAIntegerTermAccess().getValueAssignment(), "rule__AIntegerTerm__ValueAssignment");
					put(grammarAccess.getARealTermAccess().getValueAssignment(), "rule__ARealTerm__ValueAssignment");
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
