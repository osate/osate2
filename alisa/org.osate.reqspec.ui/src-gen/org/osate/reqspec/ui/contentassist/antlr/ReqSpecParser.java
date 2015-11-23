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
package org.osate.reqspec.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.reqspec.services.ReqSpecGrammarAccess;

public class ReqSpecParser extends AbstractContentAssistParser {
	
	@Inject
	private ReqSpecGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.reqspec.ui.contentassist.antlr.internal.InternalReqSpecParser createParser() {
		org.osate.reqspec.ui.contentassist.antlr.internal.InternalReqSpecParser result = new org.osate.reqspec.ui.contentassist.antlr.internal.InternalReqSpecParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getReqSpecAccess().getPartsAlternatives_0(), "rule__ReqSpec__PartsAlternatives_0");
					put(grammarAccess.getReqSpecContainerAccess().getAlternatives(), "rule__ReqSpecContainer__Alternatives");
					put(grammarAccess.getContractualElementAccess().getAlternatives(), "rule__ContractualElement__Alternatives");
					put(grammarAccess.getReqRootAccess().getAlternatives(), "rule__ReqRoot__Alternatives");
					put(grammarAccess.getStakeholderGoalsAccess().getAlternatives_4_1(), "rule__StakeholderGoals__Alternatives_4_1");
					put(grammarAccess.getReqDocumentAccess().getContentAlternatives_4_1_0(), "rule__ReqDocument__ContentAlternatives_4_1_0");
					put(grammarAccess.getDocumentSectionAccess().getContentAlternatives_4_1_0(), "rule__DocumentSection__ContentAlternatives_4_1_0");
					put(grammarAccess.getDocGoalAccess().getAlternatives_3_1(), "rule__DocGoal__Alternatives_3_1");
					put(grammarAccess.getSystemRequirementAccess().getAlternatives_5_9_1(), "rule__SystemRequirement__Alternatives_5_9_1");
					put(grammarAccess.getRequirementAccess().getAlternatives_3_1(), "rule__Requirement__Alternatives_3_1");
					put(grammarAccess.getRequirementAccess().getAlternatives_5_7_1(), "rule__Requirement__Alternatives_5_7_1");
					put(grammarAccess.getDocRequirementAccess().getAlternatives_3_1(), "rule__DocRequirement__Alternatives_3_1");
					put(grammarAccess.getDocRequirementAccess().getAlternatives_5_7_1(), "rule__DocRequirement__Alternatives_5_7_1");
					put(grammarAccess.getReqPredicateAccess().getAlternatives(), "rule__ReqPredicate__Alternatives");
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
					put(grammarAccess.getGlobalConstantsAccess().getGroup(), "rule__GlobalConstants__Group__0");
					put(grammarAccess.getStakeholderGoalsAccess().getGroup(), "rule__StakeholderGoals__Group__0");
					put(grammarAccess.getStakeholderGoalsAccess().getGroup_3(), "rule__StakeholderGoals__Group_3__0");
					put(grammarAccess.getStakeholderGoalsAccess().getGroup_4(), "rule__StakeholderGoals__Group_4__0");
					put(grammarAccess.getStakeholderGoalsAccess().getGroup_5(), "rule__StakeholderGoals__Group_5__0");
					put(grammarAccess.getStakeholderGoalsAccess().getGroup_7_3(), "rule__StakeholderGoals__Group_7_3__0");
					put(grammarAccess.getStakeholderGoalsAccess().getGroup_7_4(), "rule__StakeholderGoals__Group_7_4__0");
					put(grammarAccess.getReqDocumentAccess().getGroup(), "rule__ReqDocument__Group__0");
					put(grammarAccess.getReqDocumentAccess().getGroup_2(), "rule__ReqDocument__Group_2__0");
					put(grammarAccess.getReqDocumentAccess().getGroup_4_2(), "rule__ReqDocument__Group_4_2__0");
					put(grammarAccess.getReqDocumentAccess().getGroup_4_3(), "rule__ReqDocument__Group_4_3__0");
					put(grammarAccess.getDocumentSectionAccess().getGroup(), "rule__DocumentSection__Group__0");
					put(grammarAccess.getDocumentSectionAccess().getGroup_2(), "rule__DocumentSection__Group_2__0");
					put(grammarAccess.getSystemRequirementsAccess().getGroup(), "rule__SystemRequirements__Group__0");
					put(grammarAccess.getSystemRequirementsAccess().getGroup_3(), "rule__SystemRequirements__Group_3__0");
					put(grammarAccess.getSystemRequirementsAccess().getGroup_6(), "rule__SystemRequirements__Group_6__0");
					put(grammarAccess.getSystemRequirementsAccess().getGroup_8_4(), "rule__SystemRequirements__Group_8_4__0");
					put(grammarAccess.getSystemRequirementsAccess().getGroup_8_5(), "rule__SystemRequirements__Group_8_5__0");
					put(grammarAccess.getSystemRequirementsAccess().getGroup_8_6(), "rule__SystemRequirements__Group_8_6__0");
					put(grammarAccess.getRequirementLibraryAccess().getGroup(), "rule__RequirementLibrary__Group__0");
					put(grammarAccess.getRequirementLibraryAccess().getGroup_2(), "rule__RequirementLibrary__Group_2__0");
					put(grammarAccess.getRequirementLibraryAccess().getGroup_3(), "rule__RequirementLibrary__Group_3__0");
					put(grammarAccess.getRequirementLibraryAccess().getGroup_5_4(), "rule__RequirementLibrary__Group_5_4__0");
					put(grammarAccess.getRequirementLibraryAccess().getGroup_5_5(), "rule__RequirementLibrary__Group_5_5__0");
					put(grammarAccess.getRequirementLibraryAccess().getGroup_5_6(), "rule__RequirementLibrary__Group_5_6__0");
					put(grammarAccess.getDocGoalAccess().getGroup(), "rule__DocGoal__Group__0");
					put(grammarAccess.getDocGoalAccess().getGroup_2(), "rule__DocGoal__Group_2__0");
					put(grammarAccess.getDocGoalAccess().getGroup_3(), "rule__DocGoal__Group_3__0");
					put(grammarAccess.getDocGoalAccess().getGroup_3_1_1(), "rule__DocGoal__Group_3_1_1__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_0(), "rule__DocGoal__Group_5_0__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_1(), "rule__DocGoal__Group_5_1__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_2(), "rule__DocGoal__Group_5_2__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_7(), "rule__DocGoal__Group_5_7__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_8(), "rule__DocGoal__Group_5_8__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_9(), "rule__DocGoal__Group_5_9__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_10(), "rule__DocGoal__Group_5_10__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_11(), "rule__DocGoal__Group_5_11__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_12(), "rule__DocGoal__Group_5_12__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_13(), "rule__DocGoal__Group_5_13__0");
					put(grammarAccess.getGoalAccess().getGroup(), "rule__Goal__Group__0");
					put(grammarAccess.getGoalAccess().getGroup_2(), "rule__Goal__Group_2__0");
					put(grammarAccess.getGoalAccess().getGroup_3(), "rule__Goal__Group_3__0");
					put(grammarAccess.getGoalAccess().getGroup_5_0(), "rule__Goal__Group_5_0__0");
					put(grammarAccess.getGoalAccess().getGroup_5_1(), "rule__Goal__Group_5_1__0");
					put(grammarAccess.getGoalAccess().getGroup_5_2(), "rule__Goal__Group_5_2__0");
					put(grammarAccess.getGoalAccess().getGroup_5_7(), "rule__Goal__Group_5_7__0");
					put(grammarAccess.getGoalAccess().getGroup_5_8(), "rule__Goal__Group_5_8__0");
					put(grammarAccess.getGoalAccess().getGroup_5_9(), "rule__Goal__Group_5_9__0");
					put(grammarAccess.getGoalAccess().getGroup_5_10(), "rule__Goal__Group_5_10__0");
					put(grammarAccess.getGoalAccess().getGroup_5_11(), "rule__Goal__Group_5_11__0");
					put(grammarAccess.getGoalAccess().getGroup_5_12(), "rule__Goal__Group_5_12__0");
					put(grammarAccess.getGoalAccess().getGroup_5_13(), "rule__Goal__Group_5_13__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup(), "rule__SystemRequirement__Group__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_2(), "rule__SystemRequirement__Group_2__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_3(), "rule__SystemRequirement__Group_3__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_0(), "rule__SystemRequirement__Group_5_0__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_1(), "rule__SystemRequirement__Group_5_1__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_2(), "rule__SystemRequirement__Group_5_2__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_9(), "rule__SystemRequirement__Group_5_9__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_10(), "rule__SystemRequirement__Group_5_10__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_11(), "rule__SystemRequirement__Group_5_11__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_12(), "rule__SystemRequirement__Group_5_12__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_13(), "rule__SystemRequirement__Group_5_13__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_14(), "rule__SystemRequirement__Group_5_14__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_15(), "rule__SystemRequirement__Group_5_15__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_16(), "rule__SystemRequirement__Group_5_16__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_17(), "rule__SystemRequirement__Group_5_17__0");
					put(grammarAccess.getRequirementAccess().getGroup(), "rule__Requirement__Group__0");
					put(grammarAccess.getRequirementAccess().getGroup_2(), "rule__Requirement__Group_2__0");
					put(grammarAccess.getRequirementAccess().getGroup_3(), "rule__Requirement__Group_3__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_0(), "rule__Requirement__Group_5_0__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_7(), "rule__Requirement__Group_5_7__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_8(), "rule__Requirement__Group_5_8__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_9(), "rule__Requirement__Group_5_9__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_10(), "rule__Requirement__Group_5_10__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_11(), "rule__Requirement__Group_5_11__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_12(), "rule__Requirement__Group_5_12__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_13(), "rule__Requirement__Group_5_13__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_14(), "rule__Requirement__Group_5_14__0");
					put(grammarAccess.getRequirementAccess().getGroup_5_15(), "rule__Requirement__Group_5_15__0");
					put(grammarAccess.getDocRequirementAccess().getGroup(), "rule__DocRequirement__Group__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_2(), "rule__DocRequirement__Group_2__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_3(), "rule__DocRequirement__Group_3__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_3_1_1(), "rule__DocRequirement__Group_3_1_1__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_0(), "rule__DocRequirement__Group_5_0__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_7(), "rule__DocRequirement__Group_5_7__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_8(), "rule__DocRequirement__Group_5_8__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_9(), "rule__DocRequirement__Group_5_9__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_10(), "rule__DocRequirement__Group_5_10__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_11(), "rule__DocRequirement__Group_5_11__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_12(), "rule__DocRequirement__Group_5_12__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_13(), "rule__DocRequirement__Group_5_13__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_14(), "rule__DocRequirement__Group_5_14__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_15(), "rule__DocRequirement__Group_5_15__0");
					put(grammarAccess.getInformalPredicateAccess().getGroup(), "rule__InformalPredicate__Group__0");
					put(grammarAccess.getPredicateAccess().getGroup(), "rule__Predicate__Group__0");
					put(grammarAccess.getValuePredicateAccess().getGroup(), "rule__ValuePredicate__Group__0");
					put(grammarAccess.getExternalDocumentAccess().getGroup(), "rule__ExternalDocument__Group__0");
					put(grammarAccess.getExternalDocumentAccess().getGroup_1(), "rule__ExternalDocument__Group_1__0");
					put(grammarAccess.getDOCPATHAccess().getGroup(), "rule__DOCPATH__Group__0");
					put(grammarAccess.getDOCPATHAccess().getGroup_0(), "rule__DOCPATH__Group_0__0");
					put(grammarAccess.getDOCFRAGMENTAccess().getGroup(), "rule__DOCFRAGMENT__Group__0");
					put(grammarAccess.getDOCFRAGMENTAccess().getGroup_1(), "rule__DOCFRAGMENT__Group_1__0");
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
					put(grammarAccess.getReqSpecAccess().getPartsAssignment(), "rule__ReqSpec__PartsAssignment");
					put(grammarAccess.getGlobalConstantsAccess().getNameAssignment_1(), "rule__GlobalConstants__NameAssignment_1");
					put(grammarAccess.getGlobalConstantsAccess().getConstantsAssignment_3(), "rule__GlobalConstants__ConstantsAssignment_3");
					put(grammarAccess.getStakeholderGoalsAccess().getNameAssignment_2(), "rule__StakeholderGoals__NameAssignment_2");
					put(grammarAccess.getStakeholderGoalsAccess().getTitleAssignment_3_1(), "rule__StakeholderGoals__TitleAssignment_3_1");
					put(grammarAccess.getStakeholderGoalsAccess().getTargetAssignment_4_1_0(), "rule__StakeholderGoals__TargetAssignment_4_1_0");
					put(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryAssignment_4_1_1(), "rule__StakeholderGoals__ComponentCategoryAssignment_4_1_1");
					put(grammarAccess.getStakeholderGoalsAccess().getGlobalAssignment_4_1_2(), "rule__StakeholderGoals__GlobalAssignment_4_1_2");
					put(grammarAccess.getStakeholderGoalsAccess().getImportConstantsAssignment_5_2(), "rule__StakeholderGoals__ImportConstantsAssignment_5_2");
					put(grammarAccess.getStakeholderGoalsAccess().getDescriptionAssignment_7_0(), "rule__StakeholderGoals__DescriptionAssignment_7_0");
					put(grammarAccess.getStakeholderGoalsAccess().getConstantsAssignment_7_1(), "rule__StakeholderGoals__ConstantsAssignment_7_1");
					put(grammarAccess.getStakeholderGoalsAccess().getContentAssignment_7_2(), "rule__StakeholderGoals__ContentAssignment_7_2");
					put(grammarAccess.getStakeholderGoalsAccess().getDocReferenceAssignment_7_3_1(), "rule__StakeholderGoals__DocReferenceAssignment_7_3_1");
					put(grammarAccess.getStakeholderGoalsAccess().getIssuesAssignment_7_4_1(), "rule__StakeholderGoals__IssuesAssignment_7_4_1");
					put(grammarAccess.getReqDocumentAccess().getNameAssignment_1(), "rule__ReqDocument__NameAssignment_1");
					put(grammarAccess.getReqDocumentAccess().getTitleAssignment_2_1(), "rule__ReqDocument__TitleAssignment_2_1");
					put(grammarAccess.getReqDocumentAccess().getDescriptionAssignment_4_0(), "rule__ReqDocument__DescriptionAssignment_4_0");
					put(grammarAccess.getReqDocumentAccess().getContentAssignment_4_1(), "rule__ReqDocument__ContentAssignment_4_1");
					put(grammarAccess.getReqDocumentAccess().getDocReferenceAssignment_4_2_1(), "rule__ReqDocument__DocReferenceAssignment_4_2_1");
					put(grammarAccess.getReqDocumentAccess().getIssuesAssignment_4_3_1(), "rule__ReqDocument__IssuesAssignment_4_3_1");
					put(grammarAccess.getDocumentSectionAccess().getLabelAssignment_1(), "rule__DocumentSection__LabelAssignment_1");
					put(grammarAccess.getDocumentSectionAccess().getTitleAssignment_2_1(), "rule__DocumentSection__TitleAssignment_2_1");
					put(grammarAccess.getDocumentSectionAccess().getDescriptionAssignment_4_0(), "rule__DocumentSection__DescriptionAssignment_4_0");
					put(grammarAccess.getDocumentSectionAccess().getContentAssignment_4_1(), "rule__DocumentSection__ContentAssignment_4_1");
					put(grammarAccess.getSystemRequirementsAccess().getNameAssignment_2(), "rule__SystemRequirements__NameAssignment_2");
					put(grammarAccess.getSystemRequirementsAccess().getTitleAssignment_3_1(), "rule__SystemRequirements__TitleAssignment_3_1");
					put(grammarAccess.getSystemRequirementsAccess().getTargetAssignment_5(), "rule__SystemRequirements__TargetAssignment_5");
					put(grammarAccess.getSystemRequirementsAccess().getImportConstantsAssignment_6_2(), "rule__SystemRequirements__ImportConstantsAssignment_6_2");
					put(grammarAccess.getSystemRequirementsAccess().getDescriptionAssignment_8_0(), "rule__SystemRequirements__DescriptionAssignment_8_0");
					put(grammarAccess.getSystemRequirementsAccess().getConstantsAssignment_8_1(), "rule__SystemRequirements__ConstantsAssignment_8_1");
					put(grammarAccess.getSystemRequirementsAccess().getComputesAssignment_8_2(), "rule__SystemRequirements__ComputesAssignment_8_2");
					put(grammarAccess.getSystemRequirementsAccess().getContentAssignment_8_3(), "rule__SystemRequirements__ContentAssignment_8_3");
					put(grammarAccess.getSystemRequirementsAccess().getDocReferenceAssignment_8_4_1(), "rule__SystemRequirements__DocReferenceAssignment_8_4_1");
					put(grammarAccess.getSystemRequirementsAccess().getStakeholderGoalsAssignment_8_5_2(), "rule__SystemRequirements__StakeholderGoalsAssignment_8_5_2");
					put(grammarAccess.getSystemRequirementsAccess().getIssuesAssignment_8_6_1(), "rule__SystemRequirements__IssuesAssignment_8_6_1");
					put(grammarAccess.getRequirementLibraryAccess().getNameAssignment_1(), "rule__RequirementLibrary__NameAssignment_1");
					put(grammarAccess.getRequirementLibraryAccess().getTitleAssignment_2_1(), "rule__RequirementLibrary__TitleAssignment_2_1");
					put(grammarAccess.getRequirementLibraryAccess().getImportConstantsAssignment_3_2(), "rule__RequirementLibrary__ImportConstantsAssignment_3_2");
					put(grammarAccess.getRequirementLibraryAccess().getDescriptionAssignment_5_0(), "rule__RequirementLibrary__DescriptionAssignment_5_0");
					put(grammarAccess.getRequirementLibraryAccess().getConstantsAssignment_5_1(), "rule__RequirementLibrary__ConstantsAssignment_5_1");
					put(grammarAccess.getRequirementLibraryAccess().getComputesAssignment_5_2(), "rule__RequirementLibrary__ComputesAssignment_5_2");
					put(grammarAccess.getRequirementLibraryAccess().getContentAssignment_5_3(), "rule__RequirementLibrary__ContentAssignment_5_3");
					put(grammarAccess.getRequirementLibraryAccess().getDocReferenceAssignment_5_4_1(), "rule__RequirementLibrary__DocReferenceAssignment_5_4_1");
					put(grammarAccess.getRequirementLibraryAccess().getStakeholderGoalsAssignment_5_5_2(), "rule__RequirementLibrary__StakeholderGoalsAssignment_5_5_2");
					put(grammarAccess.getRequirementLibraryAccess().getIssuesAssignment_5_6_1(), "rule__RequirementLibrary__IssuesAssignment_5_6_1");
					put(grammarAccess.getDocGoalAccess().getNameAssignment_1(), "rule__DocGoal__NameAssignment_1");
					put(grammarAccess.getDocGoalAccess().getTitleAssignment_2_1(), "rule__DocGoal__TitleAssignment_2_1");
					put(grammarAccess.getDocGoalAccess().getTargetDescriptionAssignment_3_1_0(), "rule__DocGoal__TargetDescriptionAssignment_3_1_0");
					put(grammarAccess.getDocGoalAccess().getTargetAssignment_3_1_1_0(), "rule__DocGoal__TargetAssignment_3_1_1_0");
					put(grammarAccess.getDocGoalAccess().getTargetElementAssignment_3_1_1_1(), "rule__DocGoal__TargetElementAssignment_3_1_1_1");
					put(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_0_1(), "rule__DocGoal__CategoryAssignment_5_0_1");
					put(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_1_1(), "rule__DocGoal__CategoryAssignment_5_1_1");
					put(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_2_1(), "rule__DocGoal__CategoryAssignment_5_2_1");
					put(grammarAccess.getDocGoalAccess().getDescriptionAssignment_5_3(), "rule__DocGoal__DescriptionAssignment_5_3");
					put(grammarAccess.getDocGoalAccess().getConstantsAssignment_5_4(), "rule__DocGoal__ConstantsAssignment_5_4");
					put(grammarAccess.getDocGoalAccess().getRationaleAssignment_5_5(), "rule__DocGoal__RationaleAssignment_5_5");
					put(grammarAccess.getDocGoalAccess().getChangeUncertaintyAssignment_5_6(), "rule__DocGoal__ChangeUncertaintyAssignment_5_6");
					put(grammarAccess.getDocGoalAccess().getRefinesReferenceAssignment_5_7_1(), "rule__DocGoal__RefinesReferenceAssignment_5_7_1");
					put(grammarAccess.getDocGoalAccess().getConflictsReferenceAssignment_5_8_2(), "rule__DocGoal__ConflictsReferenceAssignment_5_8_2");
					put(grammarAccess.getDocGoalAccess().getEvolvesReferenceAssignment_5_9_1(), "rule__DocGoal__EvolvesReferenceAssignment_5_9_1");
					put(grammarAccess.getDocGoalAccess().getDroppedAssignment_5_10_0(), "rule__DocGoal__DroppedAssignment_5_10_0");
					put(grammarAccess.getDocGoalAccess().getDropRationaleAssignment_5_10_1(), "rule__DocGoal__DropRationaleAssignment_5_10_1");
					put(grammarAccess.getDocGoalAccess().getStakeholderReferenceAssignment_5_11_1(), "rule__DocGoal__StakeholderReferenceAssignment_5_11_1");
					put(grammarAccess.getDocGoalAccess().getDocReferenceAssignment_5_12_1(), "rule__DocGoal__DocReferenceAssignment_5_12_1");
					put(grammarAccess.getDocGoalAccess().getIssuesAssignment_5_13_1(), "rule__DocGoal__IssuesAssignment_5_13_1");
					put(grammarAccess.getGoalAccess().getNameAssignment_1(), "rule__Goal__NameAssignment_1");
					put(grammarAccess.getGoalAccess().getTitleAssignment_2_1(), "rule__Goal__TitleAssignment_2_1");
					put(grammarAccess.getGoalAccess().getTargetElementAssignment_3_1(), "rule__Goal__TargetElementAssignment_3_1");
					put(grammarAccess.getGoalAccess().getCategoryAssignment_5_0_1(), "rule__Goal__CategoryAssignment_5_0_1");
					put(grammarAccess.getGoalAccess().getCategoryAssignment_5_1_1(), "rule__Goal__CategoryAssignment_5_1_1");
					put(grammarAccess.getGoalAccess().getCategoryAssignment_5_2_1(), "rule__Goal__CategoryAssignment_5_2_1");
					put(grammarAccess.getGoalAccess().getDescriptionAssignment_5_3(), "rule__Goal__DescriptionAssignment_5_3");
					put(grammarAccess.getGoalAccess().getConstantsAssignment_5_4(), "rule__Goal__ConstantsAssignment_5_4");
					put(grammarAccess.getGoalAccess().getRationaleAssignment_5_5(), "rule__Goal__RationaleAssignment_5_5");
					put(grammarAccess.getGoalAccess().getChangeUncertaintyAssignment_5_6(), "rule__Goal__ChangeUncertaintyAssignment_5_6");
					put(grammarAccess.getGoalAccess().getRefinesReferenceAssignment_5_7_1(), "rule__Goal__RefinesReferenceAssignment_5_7_1");
					put(grammarAccess.getGoalAccess().getConflictsReferenceAssignment_5_8_2(), "rule__Goal__ConflictsReferenceAssignment_5_8_2");
					put(grammarAccess.getGoalAccess().getEvolvesReferenceAssignment_5_9_1(), "rule__Goal__EvolvesReferenceAssignment_5_9_1");
					put(grammarAccess.getGoalAccess().getDroppedAssignment_5_10_0(), "rule__Goal__DroppedAssignment_5_10_0");
					put(grammarAccess.getGoalAccess().getDropRationaleAssignment_5_10_1(), "rule__Goal__DropRationaleAssignment_5_10_1");
					put(grammarAccess.getGoalAccess().getStakeholderReferenceAssignment_5_11_1(), "rule__Goal__StakeholderReferenceAssignment_5_11_1");
					put(grammarAccess.getGoalAccess().getDocReferenceAssignment_5_12_1(), "rule__Goal__DocReferenceAssignment_5_12_1");
					put(grammarAccess.getGoalAccess().getIssuesAssignment_5_13_1(), "rule__Goal__IssuesAssignment_5_13_1");
					put(grammarAccess.getSystemRequirementAccess().getNameAssignment_1(), "rule__SystemRequirement__NameAssignment_1");
					put(grammarAccess.getSystemRequirementAccess().getTitleAssignment_2_1(), "rule__SystemRequirement__TitleAssignment_2_1");
					put(grammarAccess.getSystemRequirementAccess().getTargetElementAssignment_3_1(), "rule__SystemRequirement__TargetElementAssignment_3_1");
					put(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_0_1(), "rule__SystemRequirement__CategoryAssignment_5_0_1");
					put(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_1_1(), "rule__SystemRequirement__CategoryAssignment_5_1_1");
					put(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_2_1(), "rule__SystemRequirement__CategoryAssignment_5_2_1");
					put(grammarAccess.getSystemRequirementAccess().getDescriptionAssignment_5_3(), "rule__SystemRequirement__DescriptionAssignment_5_3");
					put(grammarAccess.getSystemRequirementAccess().getConstantsAssignment_5_4(), "rule__SystemRequirement__ConstantsAssignment_5_4");
					put(grammarAccess.getSystemRequirementAccess().getComputesAssignment_5_5(), "rule__SystemRequirement__ComputesAssignment_5_5");
					put(grammarAccess.getSystemRequirementAccess().getPredicateAssignment_5_6(), "rule__SystemRequirement__PredicateAssignment_5_6");
					put(grammarAccess.getSystemRequirementAccess().getRationaleAssignment_5_7(), "rule__SystemRequirement__RationaleAssignment_5_7");
					put(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyAssignment_5_8(), "rule__SystemRequirement__ChangeUncertaintyAssignment_5_8");
					put(grammarAccess.getSystemRequirementAccess().getExceptionAssignment_5_9_1_0(), "rule__SystemRequirement__ExceptionAssignment_5_9_1_0");
					put(grammarAccess.getSystemRequirementAccess().getExceptionTextAssignment_5_9_1_1(), "rule__SystemRequirement__ExceptionTextAssignment_5_9_1_1");
					put(grammarAccess.getSystemRequirementAccess().getRefinesReferenceAssignment_5_10_1(), "rule__SystemRequirement__RefinesReferenceAssignment_5_10_1");
					put(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceAssignment_5_11_1(), "rule__SystemRequirement__DecomposesReferenceAssignment_5_11_1");
					put(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceAssignment_5_12_1(), "rule__SystemRequirement__EvolvesReferenceAssignment_5_12_1");
					put(grammarAccess.getSystemRequirementAccess().getDroppedAssignment_5_13_0(), "rule__SystemRequirement__DroppedAssignment_5_13_0");
					put(grammarAccess.getSystemRequirementAccess().getDropRationaleAssignment_5_13_1(), "rule__SystemRequirement__DropRationaleAssignment_5_13_1");
					put(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2(), "rule__SystemRequirement__DevelopmentStakeholderAssignment_5_14_2");
					put(grammarAccess.getSystemRequirementAccess().getGoalReferenceAssignment_5_15_1(), "rule__SystemRequirement__GoalReferenceAssignment_5_15_1");
					put(grammarAccess.getSystemRequirementAccess().getDocReferenceAssignment_5_16_1(), "rule__SystemRequirement__DocReferenceAssignment_5_16_1");
					put(grammarAccess.getSystemRequirementAccess().getIssuesAssignment_5_17_1(), "rule__SystemRequirement__IssuesAssignment_5_17_1");
					put(grammarAccess.getRequirementAccess().getNameAssignment_1(), "rule__Requirement__NameAssignment_1");
					put(grammarAccess.getRequirementAccess().getTitleAssignment_2_1(), "rule__Requirement__TitleAssignment_2_1");
					put(grammarAccess.getRequirementAccess().getComponentCategoryAssignment_3_1_0(), "rule__Requirement__ComponentCategoryAssignment_3_1_0");
					put(grammarAccess.getRequirementAccess().getGlobalAssignment_3_1_1(), "rule__Requirement__GlobalAssignment_3_1_1");
					put(grammarAccess.getRequirementAccess().getCategoryAssignment_5_0_1(), "rule__Requirement__CategoryAssignment_5_0_1");
					put(grammarAccess.getRequirementAccess().getDescriptionAssignment_5_1(), "rule__Requirement__DescriptionAssignment_5_1");
					put(grammarAccess.getRequirementAccess().getConstantsAssignment_5_2(), "rule__Requirement__ConstantsAssignment_5_2");
					put(grammarAccess.getRequirementAccess().getComputesAssignment_5_3(), "rule__Requirement__ComputesAssignment_5_3");
					put(grammarAccess.getRequirementAccess().getPredicateAssignment_5_4(), "rule__Requirement__PredicateAssignment_5_4");
					put(grammarAccess.getRequirementAccess().getRationaleAssignment_5_5(), "rule__Requirement__RationaleAssignment_5_5");
					put(grammarAccess.getRequirementAccess().getChangeUncertaintyAssignment_5_6(), "rule__Requirement__ChangeUncertaintyAssignment_5_6");
					put(grammarAccess.getRequirementAccess().getExceptionAssignment_5_7_1_0(), "rule__Requirement__ExceptionAssignment_5_7_1_0");
					put(grammarAccess.getRequirementAccess().getExceptionTextAssignment_5_7_1_1(), "rule__Requirement__ExceptionTextAssignment_5_7_1_1");
					put(grammarAccess.getRequirementAccess().getRefinesReferenceAssignment_5_8_1(), "rule__Requirement__RefinesReferenceAssignment_5_8_1");
					put(grammarAccess.getRequirementAccess().getDecomposesReferenceAssignment_5_9_1(), "rule__Requirement__DecomposesReferenceAssignment_5_9_1");
					put(grammarAccess.getRequirementAccess().getEvolvesReferenceAssignment_5_10_1(), "rule__Requirement__EvolvesReferenceAssignment_5_10_1");
					put(grammarAccess.getRequirementAccess().getDroppedAssignment_5_11_0(), "rule__Requirement__DroppedAssignment_5_11_0");
					put(grammarAccess.getRequirementAccess().getDropRationaleAssignment_5_11_1(), "rule__Requirement__DropRationaleAssignment_5_11_1");
					put(grammarAccess.getRequirementAccess().getDevelopmentStakeholderAssignment_5_12_2(), "rule__Requirement__DevelopmentStakeholderAssignment_5_12_2");
					put(grammarAccess.getRequirementAccess().getGoalReferenceAssignment_5_13_1(), "rule__Requirement__GoalReferenceAssignment_5_13_1");
					put(grammarAccess.getRequirementAccess().getDocReferenceAssignment_5_14_1(), "rule__Requirement__DocReferenceAssignment_5_14_1");
					put(grammarAccess.getRequirementAccess().getIssuesAssignment_5_15_1(), "rule__Requirement__IssuesAssignment_5_15_1");
					put(grammarAccess.getDocRequirementAccess().getNameAssignment_1(), "rule__DocRequirement__NameAssignment_1");
					put(grammarAccess.getDocRequirementAccess().getTitleAssignment_2_1(), "rule__DocRequirement__TitleAssignment_2_1");
					put(grammarAccess.getDocRequirementAccess().getTargetDescriptionAssignment_3_1_0(), "rule__DocRequirement__TargetDescriptionAssignment_3_1_0");
					put(grammarAccess.getDocRequirementAccess().getTargetAssignment_3_1_1_0(), "rule__DocRequirement__TargetAssignment_3_1_1_0");
					put(grammarAccess.getDocRequirementAccess().getTargetElementAssignment_3_1_1_1(), "rule__DocRequirement__TargetElementAssignment_3_1_1_1");
					put(grammarAccess.getDocRequirementAccess().getComponentCategoryAssignment_3_1_2(), "rule__DocRequirement__ComponentCategoryAssignment_3_1_2");
					put(grammarAccess.getDocRequirementAccess().getGlobalAssignment_3_1_3(), "rule__DocRequirement__GlobalAssignment_3_1_3");
					put(grammarAccess.getDocRequirementAccess().getCategoryAssignment_5_0_1(), "rule__DocRequirement__CategoryAssignment_5_0_1");
					put(grammarAccess.getDocRequirementAccess().getDescriptionAssignment_5_1(), "rule__DocRequirement__DescriptionAssignment_5_1");
					put(grammarAccess.getDocRequirementAccess().getConstantsAssignment_5_2(), "rule__DocRequirement__ConstantsAssignment_5_2");
					put(grammarAccess.getDocRequirementAccess().getComputesAssignment_5_3(), "rule__DocRequirement__ComputesAssignment_5_3");
					put(grammarAccess.getDocRequirementAccess().getPredicateAssignment_5_4(), "rule__DocRequirement__PredicateAssignment_5_4");
					put(grammarAccess.getDocRequirementAccess().getRationaleAssignment_5_5(), "rule__DocRequirement__RationaleAssignment_5_5");
					put(grammarAccess.getDocRequirementAccess().getChangeUncertaintyAssignment_5_6(), "rule__DocRequirement__ChangeUncertaintyAssignment_5_6");
					put(grammarAccess.getDocRequirementAccess().getExceptionAssignment_5_7_1_0(), "rule__DocRequirement__ExceptionAssignment_5_7_1_0");
					put(grammarAccess.getDocRequirementAccess().getExceptionTextAssignment_5_7_1_1(), "rule__DocRequirement__ExceptionTextAssignment_5_7_1_1");
					put(grammarAccess.getDocRequirementAccess().getRefinesReferenceAssignment_5_8_1(), "rule__DocRequirement__RefinesReferenceAssignment_5_8_1");
					put(grammarAccess.getDocRequirementAccess().getDecomposesReferenceAssignment_5_9_1(), "rule__DocRequirement__DecomposesReferenceAssignment_5_9_1");
					put(grammarAccess.getDocRequirementAccess().getEvolvesReferenceAssignment_5_10_1(), "rule__DocRequirement__EvolvesReferenceAssignment_5_10_1");
					put(grammarAccess.getDocRequirementAccess().getDroppedAssignment_5_11_0(), "rule__DocRequirement__DroppedAssignment_5_11_0");
					put(grammarAccess.getDocRequirementAccess().getDropRationaleAssignment_5_11_1(), "rule__DocRequirement__DropRationaleAssignment_5_11_1");
					put(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderAssignment_5_12_2(), "rule__DocRequirement__DevelopmentStakeholderAssignment_5_12_2");
					put(grammarAccess.getDocRequirementAccess().getGoalReferenceAssignment_5_13_1(), "rule__DocRequirement__GoalReferenceAssignment_5_13_1");
					put(grammarAccess.getDocRequirementAccess().getDocReferenceAssignment_5_14_1(), "rule__DocRequirement__DocReferenceAssignment_5_14_1");
					put(grammarAccess.getDocRequirementAccess().getIssuesAssignment_5_15_1(), "rule__DocRequirement__IssuesAssignment_5_15_1");
					put(grammarAccess.getInformalPredicateAccess().getDescriptionAssignment_2(), "rule__InformalPredicate__DescriptionAssignment_2");
					put(grammarAccess.getPredicateAccess().getXpressionAssignment_1(), "rule__Predicate__XpressionAssignment_1");
					put(grammarAccess.getValuePredicateAccess().getXpressionAssignment_2(), "rule__ValuePredicate__XpressionAssignment_2");
					put(grammarAccess.getExternalDocumentAccess().getDocReferenceAssignment_0(), "rule__ExternalDocument__DocReferenceAssignment_0");
					put(grammarAccess.getExternalDocumentAccess().getDocFragmentAssignment_1_1(), "rule__ExternalDocument__DocFragmentAssignment_1_1");
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
					put(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), "rule__StakeholderGoals__UnorderedGroup_7");
					put(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), "rule__ReqDocument__UnorderedGroup_4");
					put(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_4(), "rule__DocumentSection__UnorderedGroup_4");
					put(grammarAccess.getSystemRequirementsAccess().getUnorderedGroup_8(), "rule__SystemRequirements__UnorderedGroup_8");
					put(grammarAccess.getRequirementLibraryAccess().getUnorderedGroup_5(), "rule__RequirementLibrary__UnorderedGroup_5");
					put(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), "rule__DocGoal__UnorderedGroup_5");
					put(grammarAccess.getGoalAccess().getUnorderedGroup_5(), "rule__Goal__UnorderedGroup_5");
					put(grammarAccess.getSystemRequirementAccess().getUnorderedGroup_5(), "rule__SystemRequirement__UnorderedGroup_5");
					put(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), "rule__Requirement__UnorderedGroup_5");
					put(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), "rule__DocRequirement__UnorderedGroup_5");
					put(grammarAccess.getUncertaintyAccess().getUnorderedGroup_2(), "rule__Uncertainty__UnorderedGroup_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.reqspec.ui.contentassist.antlr.internal.InternalReqSpecParser typedParser = (org.osate.reqspec.ui.contentassist.antlr.internal.InternalReqSpecParser) parser;
			typedParser.entryRuleReqSpec();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public ReqSpecGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ReqSpecGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
