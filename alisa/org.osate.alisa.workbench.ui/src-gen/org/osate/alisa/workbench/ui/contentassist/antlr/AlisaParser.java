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
package org.osate.alisa.workbench.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.alisa.workbench.services.AlisaGrammarAccess;

public class AlisaParser extends AbstractContentAssistParser {
	
	@Inject
	private AlisaGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.alisa.workbench.ui.contentassist.antlr.internal.InternalAlisaParser createParser() {
		org.osate.alisa.workbench.ui.contentassist.antlr.internal.InternalAlisaParser result = new org.osate.alisa.workbench.ui.contentassist.antlr.internal.InternalAlisaParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getAlisaWorkAreaAccess().getCasesAlternatives_0(), "rule__AlisaWorkArea__CasesAlternatives_0");
					put(grammarAccess.getAssurancePlanAccess().getAlternatives_7_2(), "rule__AssurancePlan__Alternatives_7_2");
					put(grammarAccess.getAssurancePlanAccess().getAlternatives_7_3_2(), "rule__AssurancePlan__Alternatives_7_3_2");
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
					put(grammarAccess.getNumberAccess().getAlternatives(), "rule__Number__Alternatives");
					put(grammarAccess.getNumberAccess().getAlternatives_1_0(), "rule__Number__Alternatives_1_0");
					put(grammarAccess.getNumberAccess().getAlternatives_1_1_1(), "rule__Number__Alternatives_1_1_1");
					put(grammarAccess.getAssurancePlanAccess().getGroup(), "rule__AssurancePlan__Group__0");
					put(grammarAccess.getAssurancePlanAccess().getGroup_3(), "rule__AssurancePlan__Group_3__0");
					put(grammarAccess.getAssurancePlanAccess().getGroup_7_1(), "rule__AssurancePlan__Group_7_1__0");
					put(grammarAccess.getAssurancePlanAccess().getGroup_7_2_0(), "rule__AssurancePlan__Group_7_2_0__0");
					put(grammarAccess.getAssurancePlanAccess().getGroup_7_3(), "rule__AssurancePlan__Group_7_3__0");
					put(grammarAccess.getAssurancePlanAccess().getGroup_7_4(), "rule__AssurancePlan__Group_7_4__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup(), "rule__AssuranceTask__Group__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_4(), "rule__AssuranceTask__Group_4__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_0(), "rule__AssuranceTask__Group_8_0__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_1_0(), "rule__AssuranceTask__Group_8_1_0__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_1_0_2(), "rule__AssuranceTask__Group_8_1_0_2__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_1_1(), "rule__AssuranceTask__Group_8_1_1__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_1_2(), "rule__AssuranceTask__Group_8_1_2__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_1_3(), "rule__AssuranceTask__Group_8_1_3__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_1_4(), "rule__AssuranceTask__Group_8_1_4__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_1_4_0(), "rule__AssuranceTask__Group_8_1_4_0__0");
					put(grammarAccess.getAssuranceTaskAccess().getGroup_8_2(), "rule__AssuranceTask__Group_8_2__0");
					put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
					put(grammarAccess.getRationaleAccess().getGroup(), "rule__Rationale__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup(), "rule__Uncertainty__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_0(), "rule__Uncertainty__Group_2_0__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_1(), "rule__Uncertainty__Group_2_1__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_2(), "rule__Uncertainty__Group_2_2__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_3(), "rule__Uncertainty__Group_2_3__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_4(), "rule__Uncertainty__Group_2_4__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_5(), "rule__Uncertainty__Group_2_5__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_2_6(), "rule__Uncertainty__Group_2_6__0");
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
					put(grammarAccess.getNumberAccess().getGroup_1(), "rule__Number__Group_1__0");
					put(grammarAccess.getNumberAccess().getGroup_1_1(), "rule__Number__Group_1_1__0");
					put(grammarAccess.getAlisaWorkAreaAccess().getCasesAssignment(), "rule__AlisaWorkArea__CasesAssignment");
					put(grammarAccess.getAssurancePlanAccess().getNameAssignment_2(), "rule__AssurancePlan__NameAssignment_2");
					put(grammarAccess.getAssurancePlanAccess().getTitleAssignment_3_1(), "rule__AssurancePlan__TitleAssignment_3_1");
					put(grammarAccess.getAssurancePlanAccess().getTargetAssignment_5(), "rule__AssurancePlan__TargetAssignment_5");
					put(grammarAccess.getAssurancePlanAccess().getDescriptionAssignment_7_0(), "rule__AssurancePlan__DescriptionAssignment_7_0");
					put(grammarAccess.getAssurancePlanAccess().getAssureAssignment_7_1_1(), "rule__AssurancePlan__AssureAssignment_7_1_1");
					put(grammarAccess.getAssurancePlanAccess().getAssureSubsystemsAssignment_7_2_0_2(), "rule__AssurancePlan__AssureSubsystemsAssignment_7_2_0_2");
					put(grammarAccess.getAssurancePlanAccess().getAssureAllAssignment_7_2_1(), "rule__AssurancePlan__AssureAllAssignment_7_2_1");
					put(grammarAccess.getAssurancePlanAccess().getAssumeSubsystemsAssignment_7_3_2_0(), "rule__AssurancePlan__AssumeSubsystemsAssignment_7_3_2_0");
					put(grammarAccess.getAssurancePlanAccess().getAssumeAllAssignment_7_3_2_1(), "rule__AssurancePlan__AssumeAllAssignment_7_3_2_1");
					put(grammarAccess.getAssurancePlanAccess().getIssuesAssignment_7_4_1(), "rule__AssurancePlan__IssuesAssignment_7_4_1");
					put(grammarAccess.getAssuranceTaskAccess().getNameAssignment_3(), "rule__AssuranceTask__NameAssignment_3");
					put(grammarAccess.getAssuranceTaskAccess().getTitleAssignment_4_1(), "rule__AssuranceTask__TitleAssignment_4_1");
					put(grammarAccess.getAssuranceTaskAccess().getAssurancePlanAssignment_6(), "rule__AssuranceTask__AssurancePlanAssignment_6");
					put(grammarAccess.getAssuranceTaskAccess().getDescriptionAssignment_8_0_1(), "rule__AssuranceTask__DescriptionAssignment_8_0_1");
					put(grammarAccess.getAssuranceTaskAccess().getRequirementTypeAssignment_8_1_0_2_2(), "rule__AssuranceTask__RequirementTypeAssignment_8_1_0_2_2");
					put(grammarAccess.getAssuranceTaskAccess().getAnyRequirementTypeAssignment_8_1_0_2_3(), "rule__AssuranceTask__AnyRequirementTypeAssignment_8_1_0_2_3");
					put(grammarAccess.getAssuranceTaskAccess().getMethodTypeAssignment_8_1_1_2(), "rule__AssuranceTask__MethodTypeAssignment_8_1_1_2");
					put(grammarAccess.getAssuranceTaskAccess().getAnyMethodTypeAssignment_8_1_1_3(), "rule__AssuranceTask__AnyMethodTypeAssignment_8_1_1_3");
					put(grammarAccess.getAssuranceTaskAccess().getUserSelectionAssignment_8_1_2_2(), "rule__AssuranceTask__UserSelectionAssignment_8_1_2_2");
					put(grammarAccess.getAssuranceTaskAccess().getAnyUserSelectionAssignment_8_1_2_3(), "rule__AssuranceTask__AnyUserSelectionAssignment_8_1_2_3");
					put(grammarAccess.getAssuranceTaskAccess().getQualityAttributeAssignment_8_1_3_2(), "rule__AssuranceTask__QualityAttributeAssignment_8_1_3_2");
					put(grammarAccess.getAssuranceTaskAccess().getAnyQualityAttributeAssignment_8_1_3_3(), "rule__AssuranceTask__AnyQualityAttributeAssignment_8_1_3_3");
					put(grammarAccess.getAssuranceTaskAccess().getDevelopmentPhaseAssignment_8_1_4_0_2(), "rule__AssuranceTask__DevelopmentPhaseAssignment_8_1_4_0_2");
					put(grammarAccess.getAssuranceTaskAccess().getAnyDevelopmentPhaseAssignment_8_1_4_0_3(), "rule__AssuranceTask__AnyDevelopmentPhaseAssignment_8_1_4_0_3");
					put(grammarAccess.getAssuranceTaskAccess().getIssuesAssignment_8_2_1(), "rule__AssuranceTask__IssuesAssignment_8_2_1");
					put(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1(), "rule__Description__DescriptionAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getTextAssignment_0(), "rule__DescriptionElement__TextAssignment_0");
					put(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_1(), "rule__DescriptionElement__ShowValueAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_2(), "rule__DescriptionElement__ThisTargetAssignment_2");
					put(grammarAccess.getDescriptionElementAccess().getImageAssignment_3(), "rule__DescriptionElement__ImageAssignment_3");
					put(grammarAccess.getRationaleAccess().getTextAssignment_1(), "rule__Rationale__TextAssignment_1");
					put(grammarAccess.getUncertaintyAccess().getVolatilityAssignment_2_0_1(), "rule__Uncertainty__VolatilityAssignment_2_0_1");
					put(grammarAccess.getUncertaintyAccess().getCostimpactAssignment_2_1_1(), "rule__Uncertainty__CostimpactAssignment_2_1_1");
					put(grammarAccess.getUncertaintyAccess().getScheduleimpactAssignment_2_2_1(), "rule__Uncertainty__ScheduleimpactAssignment_2_2_1");
					put(grammarAccess.getUncertaintyAccess().getFamiliarityAssignment_2_3_1(), "rule__Uncertainty__FamiliarityAssignment_2_3_1");
					put(grammarAccess.getUncertaintyAccess().getTimecriticalityAssignment_2_4_1(), "rule__Uncertainty__TimecriticalityAssignment_2_4_1");
					put(grammarAccess.getUncertaintyAccess().getRiskindexAssignment_2_5_1(), "rule__Uncertainty__RiskindexAssignment_2_5_1");
					put(grammarAccess.getUncertaintyAccess().getMaturityindexAssignment_2_6_1(), "rule__Uncertainty__MaturityindexAssignment_2_6_1");
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
					put(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), "rule__AssurancePlan__UnorderedGroup_7");
					put(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_8(), "rule__AssuranceTask__UnorderedGroup_8");
					put(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_8_1(), "rule__AssuranceTask__UnorderedGroup_8_1");
					put(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), "rule__Uncertainty__UnorderedGroup_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.alisa.workbench.ui.contentassist.antlr.internal.InternalAlisaParser typedParser = (org.osate.alisa.workbench.ui.contentassist.antlr.internal.InternalAlisaParser) parser;
			typedParser.entryRuleAlisaWorkArea();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public AlisaGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(AlisaGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
