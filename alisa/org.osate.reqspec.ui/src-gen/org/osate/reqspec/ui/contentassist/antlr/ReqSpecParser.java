/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
					put(grammarAccess.getContractualElementAccess().getAlternatives(), "rule__ContractualElement__Alternatives");
					put(grammarAccess.getReqRootAccess().getAlternatives(), "rule__ReqRoot__Alternatives");
					put(grammarAccess.getStakeholderGoalsAccess().getAlternatives_4_1(), "rule__StakeholderGoals__Alternatives_4_1");
					put(grammarAccess.getReqDocumentAccess().getContentAlternatives_4_1_0(), "rule__ReqDocument__ContentAlternatives_4_1_0");
					put(grammarAccess.getDocumentSectionAccess().getAlternatives_1(), "rule__DocumentSection__Alternatives_1");
					put(grammarAccess.getDocumentSectionAccess().getContentAlternatives_3_1_0(), "rule__DocumentSection__ContentAlternatives_3_1_0");
					put(grammarAccess.getSystemRequirementSetAccess().getAlternatives_9(), "rule__SystemRequirementSet__Alternatives_9");
					put(grammarAccess.getGlobalRequirementSetAccess().getAlternatives_7(), "rule__GlobalRequirementSet__Alternatives_7");
					put(grammarAccess.getDocGoalAccess().getAlternatives_3_1(), "rule__DocGoal__Alternatives_3_1");
					put(grammarAccess.getSystemRequirementAccess().getAlternatives_5(), "rule__SystemRequirement__Alternatives_5");
					put(grammarAccess.getSystemRequirementAccess().getAlternatives_5_6_1(), "rule__SystemRequirement__Alternatives_5_6_1");
					put(grammarAccess.getGlobalRequirementAccess().getAlternatives_3_1(), "rule__GlobalRequirement__Alternatives_3_1");
					put(grammarAccess.getGlobalRequirementAccess().getAlternatives_5_8_1(), "rule__GlobalRequirement__Alternatives_5_8_1");
					put(grammarAccess.getDocRequirementAccess().getAlternatives_3_1(), "rule__DocRequirement__Alternatives_3_1");
					put(grammarAccess.getDocRequirementAccess().getAlternatives_5_8_1(), "rule__DocRequirement__Alternatives_5_8_1");
					put(grammarAccess.getIncludeGlobalRequirementAccess().getAlternatives_2_1(), "rule__IncludeGlobalRequirement__Alternatives_2_1");
					put(grammarAccess.getWhenConditionAccess().getAlternatives_1(), "rule__WhenCondition__Alternatives_1");
					put(grammarAccess.getReqPredicateAccess().getAlternatives(), "rule__ReqPredicate__Alternatives");
					put(grammarAccess.getDesiredValueAccess().getAlternatives_1(), "rule__DesiredValue__Alternatives_1");
					put(grammarAccess.getValDeclarationAccess().getAlternatives_3_1(), "rule__ValDeclaration__Alternatives_3_1");
					put(grammarAccess.getValDeclarationAccess().getAlternatives_3_1_2_1(), "rule__ValDeclaration__Alternatives_3_1_2_1");
					put(grammarAccess.getDescriptionElementAccess().getAlternatives(), "rule__DescriptionElement__Alternatives");
					put(grammarAccess.getTypeRefAccess().getAlternatives(), "rule__TypeRef__Alternatives");
					put(grammarAccess.getComputeDeclarationAccess().getAlternatives_4(), "rule__ComputeDeclaration__Alternatives_4");
					put(grammarAccess.getComputeDeclarationAccess().getAlternatives_4_2_1(), "rule__ComputeDeclaration__Alternatives_4_2_1");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getAlternatives(), "rule__AModelOrPropertyReference__Alternatives");
					put(grammarAccess.getShowValueAccess().getAlternatives_1_0(), "rule__ShowValue__Alternatives_1_0");
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
					put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
					put(grammarAccess.getTargetTypeAccess().getAlternatives(), "rule__TargetType__Alternatives");
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
					put(grammarAccess.getDocumentSectionAccess().getGroup_1_0(), "rule__DocumentSection__Group_1_0__0");
					put(grammarAccess.getDocumentSectionAccess().getGroup_1_0_1(), "rule__DocumentSection__Group_1_0_1__0");
					put(grammarAccess.getSystemRequirementSetAccess().getGroup(), "rule__SystemRequirementSet__Group__0");
					put(grammarAccess.getSystemRequirementSetAccess().getGroup_4(), "rule__SystemRequirementSet__Group_4__0");
					put(grammarAccess.getSystemRequirementSetAccess().getGroup_7(), "rule__SystemRequirementSet__Group_7__0");
					put(grammarAccess.getSystemRequirementSetAccess().getGroup_9_5(), "rule__SystemRequirementSet__Group_9_5__0");
					put(grammarAccess.getSystemRequirementSetAccess().getGroup_9_6(), "rule__SystemRequirementSet__Group_9_6__0");
					put(grammarAccess.getSystemRequirementSetAccess().getGroup_9_7(), "rule__SystemRequirementSet__Group_9_7__0");
					put(grammarAccess.getGlobalRequirementSetAccess().getGroup(), "rule__GlobalRequirementSet__Group__0");
					put(grammarAccess.getGlobalRequirementSetAccess().getGroup_4(), "rule__GlobalRequirementSet__Group_4__0");
					put(grammarAccess.getGlobalRequirementSetAccess().getGroup_5(), "rule__GlobalRequirementSet__Group_5__0");
					put(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_4(), "rule__GlobalRequirementSet__Group_7_4__0");
					put(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_5(), "rule__GlobalRequirementSet__Group_7_5__0");
					put(grammarAccess.getGlobalRequirementSetAccess().getGroup_7_6(), "rule__GlobalRequirementSet__Group_7_6__0");
					put(grammarAccess.getDocGoalAccess().getGroup(), "rule__DocGoal__Group__0");
					put(grammarAccess.getDocGoalAccess().getGroup_2(), "rule__DocGoal__Group_2__0");
					put(grammarAccess.getDocGoalAccess().getGroup_3(), "rule__DocGoal__Group_3__0");
					put(grammarAccess.getDocGoalAccess().getGroup_3_1_1(), "rule__DocGoal__Group_3_1_1__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_0(), "rule__DocGoal__Group_5_0__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_6(), "rule__DocGoal__Group_5_6__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_7(), "rule__DocGoal__Group_5_7__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_8(), "rule__DocGoal__Group_5_8__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_9(), "rule__DocGoal__Group_5_9__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_10(), "rule__DocGoal__Group_5_10__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_11(), "rule__DocGoal__Group_5_11__0");
					put(grammarAccess.getDocGoalAccess().getGroup_5_12(), "rule__DocGoal__Group_5_12__0");
					put(grammarAccess.getGoalAccess().getGroup(), "rule__Goal__Group__0");
					put(grammarAccess.getGoalAccess().getGroup_2(), "rule__Goal__Group_2__0");
					put(grammarAccess.getGoalAccess().getGroup_3(), "rule__Goal__Group_3__0");
					put(grammarAccess.getGoalAccess().getGroup_5_0(), "rule__Goal__Group_5_0__0");
					put(grammarAccess.getGoalAccess().getGroup_5_6(), "rule__Goal__Group_5_6__0");
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
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_6(), "rule__SystemRequirement__Group_5_6__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_7(), "rule__SystemRequirement__Group_5_7__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_8(), "rule__SystemRequirement__Group_5_8__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_11(), "rule__SystemRequirement__Group_5_11__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_12(), "rule__SystemRequirement__Group_5_12__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_13(), "rule__SystemRequirement__Group_5_13__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_14(), "rule__SystemRequirement__Group_5_14__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_15(), "rule__SystemRequirement__Group_5_15__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_16(), "rule__SystemRequirement__Group_5_16__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_17(), "rule__SystemRequirement__Group_5_17__0");
					put(grammarAccess.getSystemRequirementAccess().getGroup_5_18(), "rule__SystemRequirement__Group_5_18__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup(), "rule__GlobalRequirement__Group__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_2(), "rule__GlobalRequirement__Group_2__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_3(), "rule__GlobalRequirement__Group_3__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_0(), "rule__GlobalRequirement__Group_5_0__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_8(), "rule__GlobalRequirement__Group_5_8__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_9(), "rule__GlobalRequirement__Group_5_9__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_10(), "rule__GlobalRequirement__Group_5_10__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_11(), "rule__GlobalRequirement__Group_5_11__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_12(), "rule__GlobalRequirement__Group_5_12__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_13(), "rule__GlobalRequirement__Group_5_13__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_14(), "rule__GlobalRequirement__Group_5_14__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_15(), "rule__GlobalRequirement__Group_5_15__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_16(), "rule__GlobalRequirement__Group_5_16__0");
					put(grammarAccess.getGlobalRequirementAccess().getGroup_5_17(), "rule__GlobalRequirement__Group_5_17__0");
					put(grammarAccess.getDocRequirementAccess().getGroup(), "rule__DocRequirement__Group__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_2(), "rule__DocRequirement__Group_2__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_3(), "rule__DocRequirement__Group_3__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_3_1_1(), "rule__DocRequirement__Group_3_1_1__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_0(), "rule__DocRequirement__Group_5_0__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_8(), "rule__DocRequirement__Group_5_8__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_9(), "rule__DocRequirement__Group_5_9__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_10(), "rule__DocRequirement__Group_5_10__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_11(), "rule__DocRequirement__Group_5_11__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_12(), "rule__DocRequirement__Group_5_12__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_13(), "rule__DocRequirement__Group_5_13__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_14(), "rule__DocRequirement__Group_5_14__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_15(), "rule__DocRequirement__Group_5_15__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_16(), "rule__DocRequirement__Group_5_16__0");
					put(grammarAccess.getDocRequirementAccess().getGroup_5_17(), "rule__DocRequirement__Group_5_17__0");
					put(grammarAccess.getIncludeGlobalRequirementAccess().getGroup(), "rule__IncludeGlobalRequirement__Group__0");
					put(grammarAccess.getIncludeGlobalRequirementAccess().getGroup_2(), "rule__IncludeGlobalRequirement__Group_2__0");
					put(grammarAccess.getWhenConditionAccess().getGroup(), "rule__WhenCondition__Group__0");
					put(grammarAccess.getWhenConditionAccess().getGroup_1_0(), "rule__WhenCondition__Group_1_0__0");
					put(grammarAccess.getWhenConditionAccess().getGroup_1_0_3(), "rule__WhenCondition__Group_1_0_3__0");
					put(grammarAccess.getWhenConditionAccess().getGroup_1_1(), "rule__WhenCondition__Group_1_1__0");
					put(grammarAccess.getWhenConditionAccess().getGroup_1_1_4(), "rule__WhenCondition__Group_1_1_4__0");
					put(grammarAccess.getWhenConditionAccess().getGroup_1_2(), "rule__WhenCondition__Group_1_2__0");
					put(grammarAccess.getInformalPredicateAccess().getGroup(), "rule__InformalPredicate__Group__0");
					put(grammarAccess.getValuePredicateAccess().getGroup(), "rule__ValuePredicate__Group__0");
					put(grammarAccess.getValuePredicateAccess().getGroup_3(), "rule__ValuePredicate__Group_3__0");
					put(grammarAccess.getDesiredValueAccess().getGroup(), "rule__DesiredValue__Group__0");
					put(grammarAccess.getExternalDocumentAccess().getGroup(), "rule__ExternalDocument__Group__0");
					put(grammarAccess.getExternalDocumentAccess().getGroup_1(), "rule__ExternalDocument__Group_1__0");
					put(grammarAccess.getValDeclarationAccess().getGroup(), "rule__ValDeclaration__Group__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3(), "rule__ValDeclaration__Group_3__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3_1_1(), "rule__ValDeclaration__Group_3_1_1__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3_1_2(), "rule__ValDeclaration__Group_3_1_2__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_3_1_2_1_1(), "rule__ValDeclaration__Group_3_1_2_1_1__0");
					put(grammarAccess.getValDeclarationAccess().getGroup_6(), "rule__ValDeclaration__Group_6__0");
					put(grammarAccess.getDOCPATHAccess().getGroup(), "rule__DOCPATH__Group__0");
					put(grammarAccess.getDOCPATHAccess().getGroup_0(), "rule__DOCPATH__Group_0__0");
					put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
					put(grammarAccess.getRationaleAccess().getGroup(), "rule__Rationale__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup(), "rule__Uncertainty__Group__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_3_0(), "rule__Uncertainty__Group_3_0__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_3_1(), "rule__Uncertainty__Group_3_1__0");
					put(grammarAccess.getUncertaintyAccess().getGroup_3_2(), "rule__Uncertainty__Group_3_2__0");
					put(grammarAccess.getTypeRefAccess().getGroup_0(), "rule__TypeRef__Group_0__0");
					put(grammarAccess.getTypeRefAccess().getGroup_1(), "rule__TypeRef__Group_1__0");
					put(grammarAccess.getTypeRefAccess().getGroup_1_2(), "rule__TypeRef__Group_1_2__0");
					put(grammarAccess.getTypeRefAccess().getGroup_2(), "rule__TypeRef__Group_2__0");
					put(grammarAccess.getTypeRefAccess().getGroup_2_2(), "rule__TypeRef__Group_2_2__0");
					put(grammarAccess.getTypeRefAccess().getGroup_3(), "rule__TypeRef__Group_3__0");
					put(grammarAccess.getTypeRefAccess().getGroup_4(), "rule__TypeRef__Group_4__0");
					put(grammarAccess.getTypeRefAccess().getGroup_5(), "rule__TypeRef__Group_5__0");
					put(grammarAccess.getPropertyRefAccess().getGroup(), "rule__PropertyRef__Group__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup(), "rule__ComputeDeclaration__Group__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_4_1(), "rule__ComputeDeclaration__Group_4_1__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_4_2(), "rule__ComputeDeclaration__Group_4_2__0");
					put(grammarAccess.getComputeDeclarationAccess().getGroup_4_2_1_1(), "rule__ComputeDeclaration__Group_4_2_1_1__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0(), "rule__AModelOrPropertyReference__Group_0__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1(), "rule__AModelOrPropertyReference__Group_0_1__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0(), "rule__AModelOrPropertyReference__Group_0_1_0__0");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0_0(), "rule__AModelOrPropertyReference__Group_0_1_0_0__0");
					put(grammarAccess.getAModelReferenceAccess().getGroup(), "rule__AModelReference__Group__0");
					put(grammarAccess.getAModelReferenceAccess().getGroup_1(), "rule__AModelReference__Group_1__0");
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
					put(grammarAccess.getAFunctionCallAccess().getGroup_3(), "rule__AFunctionCall__Group_3__0");
					put(grammarAccess.getAFunctionCallAccess().getGroup_3_1(), "rule__AFunctionCall__Group_3_1__0");
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
					put(grammarAccess.getReqSpecAccess().getPartsAssignment(), "rule__ReqSpec__PartsAssignment");
					put(grammarAccess.getGlobalConstantsAccess().getNameAssignment_1(), "rule__GlobalConstants__NameAssignment_1");
					put(grammarAccess.getGlobalConstantsAccess().getConstantsAssignment_3(), "rule__GlobalConstants__ConstantsAssignment_3");
					put(grammarAccess.getStakeholderGoalsAccess().getNameAssignment_2(), "rule__StakeholderGoals__NameAssignment_2");
					put(grammarAccess.getStakeholderGoalsAccess().getTitleAssignment_3_1(), "rule__StakeholderGoals__TitleAssignment_3_1");
					put(grammarAccess.getStakeholderGoalsAccess().getTargetAssignment_4_1_0(), "rule__StakeholderGoals__TargetAssignment_4_1_0");
					put(grammarAccess.getStakeholderGoalsAccess().getComponentCategoryAssignment_4_1_1(), "rule__StakeholderGoals__ComponentCategoryAssignment_4_1_1");
					put(grammarAccess.getStakeholderGoalsAccess().getImportConstantsAssignment_5_2(), "rule__StakeholderGoals__ImportConstantsAssignment_5_2");
					put(grammarAccess.getStakeholderGoalsAccess().getDescriptionAssignment_7_0(), "rule__StakeholderGoals__DescriptionAssignment_7_0");
					put(grammarAccess.getStakeholderGoalsAccess().getConstantsAssignment_7_1(), "rule__StakeholderGoals__ConstantsAssignment_7_1");
					put(grammarAccess.getStakeholderGoalsAccess().getGoalsAssignment_7_2(), "rule__StakeholderGoals__GoalsAssignment_7_2");
					put(grammarAccess.getStakeholderGoalsAccess().getDocReferenceAssignment_7_3_2(), "rule__StakeholderGoals__DocReferenceAssignment_7_3_2");
					put(grammarAccess.getStakeholderGoalsAccess().getIssuesAssignment_7_4_1(), "rule__StakeholderGoals__IssuesAssignment_7_4_1");
					put(grammarAccess.getReqDocumentAccess().getNameAssignment_1(), "rule__ReqDocument__NameAssignment_1");
					put(grammarAccess.getReqDocumentAccess().getTitleAssignment_2_1(), "rule__ReqDocument__TitleAssignment_2_1");
					put(grammarAccess.getReqDocumentAccess().getDescriptionAssignment_4_0(), "rule__ReqDocument__DescriptionAssignment_4_0");
					put(grammarAccess.getReqDocumentAccess().getContentAssignment_4_1(), "rule__ReqDocument__ContentAssignment_4_1");
					put(grammarAccess.getReqDocumentAccess().getDocReferenceAssignment_4_2_2(), "rule__ReqDocument__DocReferenceAssignment_4_2_2");
					put(grammarAccess.getReqDocumentAccess().getIssuesAssignment_4_3_1(), "rule__ReqDocument__IssuesAssignment_4_3_1");
					put(grammarAccess.getDocumentSectionAccess().getLabelAssignment_1_0_0(), "rule__DocumentSection__LabelAssignment_1_0_0");
					put(grammarAccess.getDocumentSectionAccess().getTitleAssignment_1_0_1_1(), "rule__DocumentSection__TitleAssignment_1_0_1_1");
					put(grammarAccess.getDocumentSectionAccess().getTitleAssignment_1_1(), "rule__DocumentSection__TitleAssignment_1_1");
					put(grammarAccess.getDocumentSectionAccess().getDescriptionAssignment_3_0(), "rule__DocumentSection__DescriptionAssignment_3_0");
					put(grammarAccess.getDocumentSectionAccess().getContentAssignment_3_1(), "rule__DocumentSection__ContentAssignment_3_1");
					put(grammarAccess.getSystemRequirementSetAccess().getNameAssignment_3(), "rule__SystemRequirementSet__NameAssignment_3");
					put(grammarAccess.getSystemRequirementSetAccess().getTitleAssignment_4_1(), "rule__SystemRequirementSet__TitleAssignment_4_1");
					put(grammarAccess.getSystemRequirementSetAccess().getTargetAssignment_6(), "rule__SystemRequirementSet__TargetAssignment_6");
					put(grammarAccess.getSystemRequirementSetAccess().getImportConstantsAssignment_7_2(), "rule__SystemRequirementSet__ImportConstantsAssignment_7_2");
					put(grammarAccess.getSystemRequirementSetAccess().getDescriptionAssignment_9_0(), "rule__SystemRequirementSet__DescriptionAssignment_9_0");
					put(grammarAccess.getSystemRequirementSetAccess().getConstantsAssignment_9_1(), "rule__SystemRequirementSet__ConstantsAssignment_9_1");
					put(grammarAccess.getSystemRequirementSetAccess().getComputesAssignment_9_2(), "rule__SystemRequirementSet__ComputesAssignment_9_2");
					put(grammarAccess.getSystemRequirementSetAccess().getRequirementsAssignment_9_3(), "rule__SystemRequirementSet__RequirementsAssignment_9_3");
					put(grammarAccess.getSystemRequirementSetAccess().getIncludeAssignment_9_4(), "rule__SystemRequirementSet__IncludeAssignment_9_4");
					put(grammarAccess.getSystemRequirementSetAccess().getDocReferenceAssignment_9_5_2(), "rule__SystemRequirementSet__DocReferenceAssignment_9_5_2");
					put(grammarAccess.getSystemRequirementSetAccess().getStakeholderGoalsAssignment_9_6_2(), "rule__SystemRequirementSet__StakeholderGoalsAssignment_9_6_2");
					put(grammarAccess.getSystemRequirementSetAccess().getIssuesAssignment_9_7_1(), "rule__SystemRequirementSet__IssuesAssignment_9_7_1");
					put(grammarAccess.getGlobalRequirementSetAccess().getNameAssignment_3(), "rule__GlobalRequirementSet__NameAssignment_3");
					put(grammarAccess.getGlobalRequirementSetAccess().getTitleAssignment_4_1(), "rule__GlobalRequirementSet__TitleAssignment_4_1");
					put(grammarAccess.getGlobalRequirementSetAccess().getImportConstantsAssignment_5_2(), "rule__GlobalRequirementSet__ImportConstantsAssignment_5_2");
					put(grammarAccess.getGlobalRequirementSetAccess().getDescriptionAssignment_7_0(), "rule__GlobalRequirementSet__DescriptionAssignment_7_0");
					put(grammarAccess.getGlobalRequirementSetAccess().getConstantsAssignment_7_1(), "rule__GlobalRequirementSet__ConstantsAssignment_7_1");
					put(grammarAccess.getGlobalRequirementSetAccess().getComputesAssignment_7_2(), "rule__GlobalRequirementSet__ComputesAssignment_7_2");
					put(grammarAccess.getGlobalRequirementSetAccess().getRequirementsAssignment_7_3(), "rule__GlobalRequirementSet__RequirementsAssignment_7_3");
					put(grammarAccess.getGlobalRequirementSetAccess().getDocReferenceAssignment_7_4_2(), "rule__GlobalRequirementSet__DocReferenceAssignment_7_4_2");
					put(grammarAccess.getGlobalRequirementSetAccess().getStakeholderGoalsAssignment_7_5_2(), "rule__GlobalRequirementSet__StakeholderGoalsAssignment_7_5_2");
					put(grammarAccess.getGlobalRequirementSetAccess().getIssuesAssignment_7_6_1(), "rule__GlobalRequirementSet__IssuesAssignment_7_6_1");
					put(grammarAccess.getDocGoalAccess().getNameAssignment_1(), "rule__DocGoal__NameAssignment_1");
					put(grammarAccess.getDocGoalAccess().getTitleAssignment_2_1(), "rule__DocGoal__TitleAssignment_2_1");
					put(grammarAccess.getDocGoalAccess().getTargetDescriptionAssignment_3_1_0(), "rule__DocGoal__TargetDescriptionAssignment_3_1_0");
					put(grammarAccess.getDocGoalAccess().getTargetAssignment_3_1_1_0(), "rule__DocGoal__TargetAssignment_3_1_1_0");
					put(grammarAccess.getDocGoalAccess().getTargetElementAssignment_3_1_1_1(), "rule__DocGoal__TargetElementAssignment_3_1_1_1");
					put(grammarAccess.getDocGoalAccess().getCategoryAssignment_5_0_1(), "rule__DocGoal__CategoryAssignment_5_0_1");
					put(grammarAccess.getDocGoalAccess().getDescriptionAssignment_5_1(), "rule__DocGoal__DescriptionAssignment_5_1");
					put(grammarAccess.getDocGoalAccess().getConstantsAssignment_5_2(), "rule__DocGoal__ConstantsAssignment_5_2");
					put(grammarAccess.getDocGoalAccess().getWhenconditionAssignment_5_3(), "rule__DocGoal__WhenconditionAssignment_5_3");
					put(grammarAccess.getDocGoalAccess().getRationaleAssignment_5_4(), "rule__DocGoal__RationaleAssignment_5_4");
					put(grammarAccess.getDocGoalAccess().getChangeUncertaintyAssignment_5_5(), "rule__DocGoal__ChangeUncertaintyAssignment_5_5");
					put(grammarAccess.getDocGoalAccess().getRefinesReferenceAssignment_5_6_1(), "rule__DocGoal__RefinesReferenceAssignment_5_6_1");
					put(grammarAccess.getDocGoalAccess().getConflictsReferenceAssignment_5_7_2(), "rule__DocGoal__ConflictsReferenceAssignment_5_7_2");
					put(grammarAccess.getDocGoalAccess().getEvolvesReferenceAssignment_5_8_1(), "rule__DocGoal__EvolvesReferenceAssignment_5_8_1");
					put(grammarAccess.getDocGoalAccess().getDroppedAssignment_5_9_0(), "rule__DocGoal__DroppedAssignment_5_9_0");
					put(grammarAccess.getDocGoalAccess().getDropRationaleAssignment_5_9_1(), "rule__DocGoal__DropRationaleAssignment_5_9_1");
					put(grammarAccess.getDocGoalAccess().getStakeholderReferenceAssignment_5_10_1(), "rule__DocGoal__StakeholderReferenceAssignment_5_10_1");
					put(grammarAccess.getDocGoalAccess().getDocReferenceAssignment_5_11_2(), "rule__DocGoal__DocReferenceAssignment_5_11_2");
					put(grammarAccess.getDocGoalAccess().getIssuesAssignment_5_12_1(), "rule__DocGoal__IssuesAssignment_5_12_1");
					put(grammarAccess.getGoalAccess().getNameAssignment_1(), "rule__Goal__NameAssignment_1");
					put(grammarAccess.getGoalAccess().getTitleAssignment_2_1(), "rule__Goal__TitleAssignment_2_1");
					put(grammarAccess.getGoalAccess().getTargetElementAssignment_3_1(), "rule__Goal__TargetElementAssignment_3_1");
					put(grammarAccess.getGoalAccess().getCategoryAssignment_5_0_1(), "rule__Goal__CategoryAssignment_5_0_1");
					put(grammarAccess.getGoalAccess().getDescriptionAssignment_5_1(), "rule__Goal__DescriptionAssignment_5_1");
					put(grammarAccess.getGoalAccess().getConstantsAssignment_5_2(), "rule__Goal__ConstantsAssignment_5_2");
					put(grammarAccess.getGoalAccess().getWhenconditionAssignment_5_3(), "rule__Goal__WhenconditionAssignment_5_3");
					put(grammarAccess.getGoalAccess().getRationaleAssignment_5_4(), "rule__Goal__RationaleAssignment_5_4");
					put(grammarAccess.getGoalAccess().getChangeUncertaintyAssignment_5_5(), "rule__Goal__ChangeUncertaintyAssignment_5_5");
					put(grammarAccess.getGoalAccess().getRefinesReferenceAssignment_5_6_1(), "rule__Goal__RefinesReferenceAssignment_5_6_1");
					put(grammarAccess.getGoalAccess().getConflictsReferenceAssignment_5_7_2(), "rule__Goal__ConflictsReferenceAssignment_5_7_2");
					put(grammarAccess.getGoalAccess().getEvolvesReferenceAssignment_5_8_1(), "rule__Goal__EvolvesReferenceAssignment_5_8_1");
					put(grammarAccess.getGoalAccess().getDroppedAssignment_5_9_0(), "rule__Goal__DroppedAssignment_5_9_0");
					put(grammarAccess.getGoalAccess().getDropRationaleAssignment_5_9_1(), "rule__Goal__DropRationaleAssignment_5_9_1");
					put(grammarAccess.getGoalAccess().getStakeholderReferenceAssignment_5_10_1(), "rule__Goal__StakeholderReferenceAssignment_5_10_1");
					put(grammarAccess.getGoalAccess().getGoalReferenceAssignment_5_11_2(), "rule__Goal__GoalReferenceAssignment_5_11_2");
					put(grammarAccess.getGoalAccess().getDocReferenceAssignment_5_12_2(), "rule__Goal__DocReferenceAssignment_5_12_2");
					put(grammarAccess.getGoalAccess().getIssuesAssignment_5_13_1(), "rule__Goal__IssuesAssignment_5_13_1");
					put(grammarAccess.getSystemRequirementAccess().getNameAssignment_1(), "rule__SystemRequirement__NameAssignment_1");
					put(grammarAccess.getSystemRequirementAccess().getTitleAssignment_2_1(), "rule__SystemRequirement__TitleAssignment_2_1");
					put(grammarAccess.getSystemRequirementAccess().getTargetElementAssignment_3_1(), "rule__SystemRequirement__TargetElementAssignment_3_1");
					put(grammarAccess.getSystemRequirementAccess().getCategoryAssignment_5_0_1(), "rule__SystemRequirement__CategoryAssignment_5_0_1");
					put(grammarAccess.getSystemRequirementAccess().getDescriptionAssignment_5_1(), "rule__SystemRequirement__DescriptionAssignment_5_1");
					put(grammarAccess.getSystemRequirementAccess().getWhenconditionAssignment_5_2(), "rule__SystemRequirement__WhenconditionAssignment_5_2");
					put(grammarAccess.getSystemRequirementAccess().getPredicateAssignment_5_3(), "rule__SystemRequirement__PredicateAssignment_5_3");
					put(grammarAccess.getSystemRequirementAccess().getRationaleAssignment_5_4(), "rule__SystemRequirement__RationaleAssignment_5_4");
					put(grammarAccess.getSystemRequirementAccess().getChangeUncertaintyAssignment_5_5(), "rule__SystemRequirement__ChangeUncertaintyAssignment_5_5");
					put(grammarAccess.getSystemRequirementAccess().getExceptionAssignment_5_6_1_0(), "rule__SystemRequirement__ExceptionAssignment_5_6_1_0");
					put(grammarAccess.getSystemRequirementAccess().getExceptionTextAssignment_5_6_1_1(), "rule__SystemRequirement__ExceptionTextAssignment_5_6_1_1");
					put(grammarAccess.getSystemRequirementAccess().getInheritsReferenceAssignment_5_7_1(), "rule__SystemRequirement__InheritsReferenceAssignment_5_7_1");
					put(grammarAccess.getSystemRequirementAccess().getDroppedAssignment_5_8_0(), "rule__SystemRequirement__DroppedAssignment_5_8_0");
					put(grammarAccess.getSystemRequirementAccess().getDropRationaleAssignment_5_8_1(), "rule__SystemRequirement__DropRationaleAssignment_5_8_1");
					put(grammarAccess.getSystemRequirementAccess().getConstantsAssignment_5_9(), "rule__SystemRequirement__ConstantsAssignment_5_9");
					put(grammarAccess.getSystemRequirementAccess().getComputesAssignment_5_10(), "rule__SystemRequirement__ComputesAssignment_5_10");
					put(grammarAccess.getSystemRequirementAccess().getRefinesReferenceAssignment_5_11_1(), "rule__SystemRequirement__RefinesReferenceAssignment_5_11_1");
					put(grammarAccess.getSystemRequirementAccess().getDecomposesReferenceAssignment_5_12_1(), "rule__SystemRequirement__DecomposesReferenceAssignment_5_12_1");
					put(grammarAccess.getSystemRequirementAccess().getEvolvesReferenceAssignment_5_13_1(), "rule__SystemRequirement__EvolvesReferenceAssignment_5_13_1");
					put(grammarAccess.getSystemRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2(), "rule__SystemRequirement__DevelopmentStakeholderAssignment_5_14_2");
					put(grammarAccess.getSystemRequirementAccess().getGoalReferenceAssignment_5_15_2(), "rule__SystemRequirement__GoalReferenceAssignment_5_15_2");
					put(grammarAccess.getSystemRequirementAccess().getRequirementReferenceAssignment_5_16_2(), "rule__SystemRequirement__RequirementReferenceAssignment_5_16_2");
					put(grammarAccess.getSystemRequirementAccess().getDocReferenceAssignment_5_17_2(), "rule__SystemRequirement__DocReferenceAssignment_5_17_2");
					put(grammarAccess.getSystemRequirementAccess().getIssuesAssignment_5_18_1(), "rule__SystemRequirement__IssuesAssignment_5_18_1");
					put(grammarAccess.getGlobalRequirementAccess().getNameAssignment_1(), "rule__GlobalRequirement__NameAssignment_1");
					put(grammarAccess.getGlobalRequirementAccess().getTitleAssignment_2_1(), "rule__GlobalRequirement__TitleAssignment_2_1");
					put(grammarAccess.getGlobalRequirementAccess().getComponentCategoryAssignment_3_1_0(), "rule__GlobalRequirement__ComponentCategoryAssignment_3_1_0");
					put(grammarAccess.getGlobalRequirementAccess().getTargetTypeAssignment_3_1_1(), "rule__GlobalRequirement__TargetTypeAssignment_3_1_1");
					put(grammarAccess.getGlobalRequirementAccess().getCategoryAssignment_5_0_1(), "rule__GlobalRequirement__CategoryAssignment_5_0_1");
					put(grammarAccess.getGlobalRequirementAccess().getDescriptionAssignment_5_1(), "rule__GlobalRequirement__DescriptionAssignment_5_1");
					put(grammarAccess.getGlobalRequirementAccess().getConstantsAssignment_5_2(), "rule__GlobalRequirement__ConstantsAssignment_5_2");
					put(grammarAccess.getGlobalRequirementAccess().getComputesAssignment_5_3(), "rule__GlobalRequirement__ComputesAssignment_5_3");
					put(grammarAccess.getGlobalRequirementAccess().getWhenconditionAssignment_5_4(), "rule__GlobalRequirement__WhenconditionAssignment_5_4");
					put(grammarAccess.getGlobalRequirementAccess().getPredicateAssignment_5_5(), "rule__GlobalRequirement__PredicateAssignment_5_5");
					put(grammarAccess.getGlobalRequirementAccess().getRationaleAssignment_5_6(), "rule__GlobalRequirement__RationaleAssignment_5_6");
					put(grammarAccess.getGlobalRequirementAccess().getChangeUncertaintyAssignment_5_7(), "rule__GlobalRequirement__ChangeUncertaintyAssignment_5_7");
					put(grammarAccess.getGlobalRequirementAccess().getExceptionAssignment_5_8_1_0(), "rule__GlobalRequirement__ExceptionAssignment_5_8_1_0");
					put(grammarAccess.getGlobalRequirementAccess().getExceptionTextAssignment_5_8_1_1(), "rule__GlobalRequirement__ExceptionTextAssignment_5_8_1_1");
					put(grammarAccess.getGlobalRequirementAccess().getRefinesReferenceAssignment_5_9_1(), "rule__GlobalRequirement__RefinesReferenceAssignment_5_9_1");
					put(grammarAccess.getGlobalRequirementAccess().getDecomposesReferenceAssignment_5_10_1(), "rule__GlobalRequirement__DecomposesReferenceAssignment_5_10_1");
					put(grammarAccess.getGlobalRequirementAccess().getEvolvesReferenceAssignment_5_11_1(), "rule__GlobalRequirement__EvolvesReferenceAssignment_5_11_1");
					put(grammarAccess.getGlobalRequirementAccess().getDroppedAssignment_5_12_0(), "rule__GlobalRequirement__DroppedAssignment_5_12_0");
					put(grammarAccess.getGlobalRequirementAccess().getDropRationaleAssignment_5_12_1(), "rule__GlobalRequirement__DropRationaleAssignment_5_12_1");
					put(grammarAccess.getGlobalRequirementAccess().getDevelopmentStakeholderAssignment_5_13_2(), "rule__GlobalRequirement__DevelopmentStakeholderAssignment_5_13_2");
					put(grammarAccess.getGlobalRequirementAccess().getGoalReferenceAssignment_5_14_2(), "rule__GlobalRequirement__GoalReferenceAssignment_5_14_2");
					put(grammarAccess.getGlobalRequirementAccess().getRequirementReferenceAssignment_5_15_2(), "rule__GlobalRequirement__RequirementReferenceAssignment_5_15_2");
					put(grammarAccess.getGlobalRequirementAccess().getDocReferenceAssignment_5_16_2(), "rule__GlobalRequirement__DocReferenceAssignment_5_16_2");
					put(grammarAccess.getGlobalRequirementAccess().getIssuesAssignment_5_17_1(), "rule__GlobalRequirement__IssuesAssignment_5_17_1");
					put(grammarAccess.getDocRequirementAccess().getNameAssignment_1(), "rule__DocRequirement__NameAssignment_1");
					put(grammarAccess.getDocRequirementAccess().getTitleAssignment_2_1(), "rule__DocRequirement__TitleAssignment_2_1");
					put(grammarAccess.getDocRequirementAccess().getTargetDescriptionAssignment_3_1_0(), "rule__DocRequirement__TargetDescriptionAssignment_3_1_0");
					put(grammarAccess.getDocRequirementAccess().getTargetAssignment_3_1_1_0(), "rule__DocRequirement__TargetAssignment_3_1_1_0");
					put(grammarAccess.getDocRequirementAccess().getTargetElementAssignment_3_1_1_1(), "rule__DocRequirement__TargetElementAssignment_3_1_1_1");
					put(grammarAccess.getDocRequirementAccess().getComponentCategoryAssignment_3_1_2(), "rule__DocRequirement__ComponentCategoryAssignment_3_1_2");
					put(grammarAccess.getDocRequirementAccess().getCategoryAssignment_5_0_1(), "rule__DocRequirement__CategoryAssignment_5_0_1");
					put(grammarAccess.getDocRequirementAccess().getDescriptionAssignment_5_1(), "rule__DocRequirement__DescriptionAssignment_5_1");
					put(grammarAccess.getDocRequirementAccess().getConstantsAssignment_5_2(), "rule__DocRequirement__ConstantsAssignment_5_2");
					put(grammarAccess.getDocRequirementAccess().getComputesAssignment_5_3(), "rule__DocRequirement__ComputesAssignment_5_3");
					put(grammarAccess.getDocRequirementAccess().getWhenconditionAssignment_5_4(), "rule__DocRequirement__WhenconditionAssignment_5_4");
					put(grammarAccess.getDocRequirementAccess().getPredicateAssignment_5_5(), "rule__DocRequirement__PredicateAssignment_5_5");
					put(grammarAccess.getDocRequirementAccess().getRationaleAssignment_5_6(), "rule__DocRequirement__RationaleAssignment_5_6");
					put(grammarAccess.getDocRequirementAccess().getChangeUncertaintyAssignment_5_7(), "rule__DocRequirement__ChangeUncertaintyAssignment_5_7");
					put(grammarAccess.getDocRequirementAccess().getExceptionAssignment_5_8_1_0(), "rule__DocRequirement__ExceptionAssignment_5_8_1_0");
					put(grammarAccess.getDocRequirementAccess().getExceptionTextAssignment_5_8_1_1(), "rule__DocRequirement__ExceptionTextAssignment_5_8_1_1");
					put(grammarAccess.getDocRequirementAccess().getRefinesReferenceAssignment_5_9_1(), "rule__DocRequirement__RefinesReferenceAssignment_5_9_1");
					put(grammarAccess.getDocRequirementAccess().getDecomposesReferenceAssignment_5_10_1(), "rule__DocRequirement__DecomposesReferenceAssignment_5_10_1");
					put(grammarAccess.getDocRequirementAccess().getInheritsReferenceAssignment_5_11_1(), "rule__DocRequirement__InheritsReferenceAssignment_5_11_1");
					put(grammarAccess.getDocRequirementAccess().getEvolvesReferenceAssignment_5_12_1(), "rule__DocRequirement__EvolvesReferenceAssignment_5_12_1");
					put(grammarAccess.getDocRequirementAccess().getDroppedAssignment_5_13_0(), "rule__DocRequirement__DroppedAssignment_5_13_0");
					put(grammarAccess.getDocRequirementAccess().getDropRationaleAssignment_5_13_1(), "rule__DocRequirement__DropRationaleAssignment_5_13_1");
					put(grammarAccess.getDocRequirementAccess().getDevelopmentStakeholderAssignment_5_14_2(), "rule__DocRequirement__DevelopmentStakeholderAssignment_5_14_2");
					put(grammarAccess.getDocRequirementAccess().getGoalReferenceAssignment_5_15_2(), "rule__DocRequirement__GoalReferenceAssignment_5_15_2");
					put(grammarAccess.getDocRequirementAccess().getDocReferenceAssignment_5_16_2(), "rule__DocRequirement__DocReferenceAssignment_5_16_2");
					put(grammarAccess.getDocRequirementAccess().getIssuesAssignment_5_17_1(), "rule__DocRequirement__IssuesAssignment_5_17_1");
					put(grammarAccess.getIncludeGlobalRequirementAccess().getIncludeAssignment_1(), "rule__IncludeGlobalRequirement__IncludeAssignment_1");
					put(grammarAccess.getIncludeGlobalRequirementAccess().getLocalAssignment_2_1_0(), "rule__IncludeGlobalRequirement__LocalAssignment_2_1_0");
					put(grammarAccess.getIncludeGlobalRequirementAccess().getTargetElementAssignment_2_1_1(), "rule__IncludeGlobalRequirement__TargetElementAssignment_2_1_1");
					put(grammarAccess.getWhenConditionAccess().getInModeAssignment_1_0_2(), "rule__WhenCondition__InModeAssignment_1_0_2");
					put(grammarAccess.getWhenConditionAccess().getInModeAssignment_1_0_3_1(), "rule__WhenCondition__InModeAssignment_1_0_3_1");
					put(grammarAccess.getWhenConditionAccess().getInErrorStateAssignment_1_1_3(), "rule__WhenCondition__InErrorStateAssignment_1_1_3");
					put(grammarAccess.getWhenConditionAccess().getInErrorStateAssignment_1_1_4_1(), "rule__WhenCondition__InErrorStateAssignment_1_1_4_1");
					put(grammarAccess.getWhenConditionAccess().getConditionAssignment_1_2_0(), "rule__WhenCondition__ConditionAssignment_1_2_0");
					put(grammarAccess.getInformalPredicateAccess().getDescriptionAssignment_2(), "rule__InformalPredicate__DescriptionAssignment_2");
					put(grammarAccess.getValuePredicateAccess().getXpressionAssignment_2(), "rule__ValuePredicate__XpressionAssignment_2");
					put(grammarAccess.getValuePredicateAccess().getDesiredValueAssignment_3_1(), "rule__ValuePredicate__DesiredValueAssignment_3_1");
					put(grammarAccess.getDesiredValueAccess().getDesiredAssignment_0(), "rule__DesiredValue__DesiredAssignment_0");
					put(grammarAccess.getDesiredValueAccess().getUptoAssignment_1_0(), "rule__DesiredValue__UptoAssignment_1_0");
					put(grammarAccess.getDesiredValueAccess().getValueAssignment_2(), "rule__DesiredValue__ValueAssignment_2");
					put(grammarAccess.getExternalDocumentAccess().getDocReferenceAssignment_0(), "rule__ExternalDocument__DocReferenceAssignment_0");
					put(grammarAccess.getExternalDocumentAccess().getDocFragmentAssignment_1_1(), "rule__ExternalDocument__DocFragmentAssignment_1_1");
					put(grammarAccess.getValDeclarationAccess().getNameAssignment_2(), "rule__ValDeclaration__NameAssignment_2");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_0(), "rule__ValDeclaration__TypeAssignment_3_1_0");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_1_1(), "rule__ValDeclaration__TypeAssignment_3_1_1_1");
					put(grammarAccess.getValDeclarationAccess().getRangeAssignment_3_1_2_0(), "rule__ValDeclaration__RangeAssignment_3_1_2_0");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_0(), "rule__ValDeclaration__TypeAssignment_3_1_2_1_0");
					put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_1_1(), "rule__ValDeclaration__TypeAssignment_3_1_2_1_1_1");
					put(grammarAccess.getValDeclarationAccess().getValueAssignment_5(), "rule__ValDeclaration__ValueAssignment_5");
					put(grammarAccess.getValDeclarationAccess().getPropertyAssignment_6_1(), "rule__ValDeclaration__PropertyAssignment_6_1");
					put(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1(), "rule__Description__DescriptionAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getTextAssignment_0(), "rule__DescriptionElement__TextAssignment_0");
					put(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_1(), "rule__DescriptionElement__ThisTargetAssignment_1");
					put(grammarAccess.getDescriptionElementAccess().getImageAssignment_2(), "rule__DescriptionElement__ImageAssignment_2");
					put(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_3(), "rule__DescriptionElement__ShowValueAssignment_3");
					put(grammarAccess.getRationaleAccess().getDescriptionAssignment_1(), "rule__Rationale__DescriptionAssignment_1");
					put(grammarAccess.getUncertaintyAccess().getVolatilityAssignment_3_0_1(), "rule__Uncertainty__VolatilityAssignment_3_0_1");
					put(grammarAccess.getUncertaintyAccess().getPrecedenceAssignment_3_1_1(), "rule__Uncertainty__PrecedenceAssignment_3_1_1");
					put(grammarAccess.getUncertaintyAccess().getImpactAssignment_3_2_1(), "rule__Uncertainty__ImpactAssignment_3_2_1");
					put(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_1_2_1(), "rule__TypeRef__ReferencedUnitsTypeAssignment_1_2_1");
					put(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_2_2_1(), "rule__TypeRef__ReferencedUnitsTypeAssignment_2_2_1");
					put(grammarAccess.getTypeRefAccess().getRefAssignment_5_1(), "rule__TypeRef__RefAssignment_5_1");
					put(grammarAccess.getPropertyRefAccess().getRefAssignment_1(), "rule__PropertyRef__RefAssignment_1");
					put(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2(), "rule__ComputeDeclaration__NameAssignment_2");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_0(), "rule__ComputeDeclaration__TypeAssignment_4_0");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_1_1(), "rule__ComputeDeclaration__TypeAssignment_4_1_1");
					put(grammarAccess.getComputeDeclarationAccess().getRangeAssignment_4_2_0(), "rule__ComputeDeclaration__RangeAssignment_4_2_0");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_0(), "rule__ComputeDeclaration__TypeAssignment_4_2_1_0");
					put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_1_1(), "rule__ComputeDeclaration__TypeAssignment_4_2_1_1_1");
					put(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1(), "rule__AModelOrPropertyReference__PropertyAssignment_0_1_1");
					put(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_0(), "rule__AModelReference__ModelElementAssignment_0");
					put(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_1_2(), "rule__AModelReference__ModelElementAssignment_1_2");
					put(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2(), "rule__APropertyReference__PropertyAssignment_2");
					put(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1(), "rule__AVariableReference__VariableAssignment_1");
					put(grammarAccess.getShowValueAccess().getExpressionAssignment_0(), "rule__ShowValue__ExpressionAssignment_0");
					put(grammarAccess.getShowValueAccess().getConvertAssignment_1_0_0(), "rule__ShowValue__ConvertAssignment_1_0_0");
					put(grammarAccess.getShowValueAccess().getDropAssignment_1_0_1(), "rule__ShowValue__DropAssignment_1_0_1");
					put(grammarAccess.getShowValueAccess().getUnitAssignment_1_1(), "rule__ShowValue__UnitAssignment_1_1");
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
					put(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_0(), "rule__AFunctionCall__ArgumentsAssignment_3_0");
					put(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_1_1(), "rule__AFunctionCall__ArgumentsAssignment_3_1_1");
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
					put(grammarAccess.getStakeholderGoalsAccess().getUnorderedGroup_7(), "rule__StakeholderGoals__UnorderedGroup_7");
					put(grammarAccess.getReqDocumentAccess().getUnorderedGroup_4(), "rule__ReqDocument__UnorderedGroup_4");
					put(grammarAccess.getDocumentSectionAccess().getUnorderedGroup_3(), "rule__DocumentSection__UnorderedGroup_3");
					put(grammarAccess.getDocGoalAccess().getUnorderedGroup_5(), "rule__DocGoal__UnorderedGroup_5");
					put(grammarAccess.getGoalAccess().getUnorderedGroup_5(), "rule__Goal__UnorderedGroup_5");
					put(grammarAccess.getGlobalRequirementAccess().getUnorderedGroup_5(), "rule__GlobalRequirement__UnorderedGroup_5");
					put(grammarAccess.getDocRequirementAccess().getUnorderedGroup_5(), "rule__DocRequirement__UnorderedGroup_5");
					put(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), "rule__Uncertainty__UnorderedGroup_3");
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
