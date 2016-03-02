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
package org.osate.reqspec.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.osate.reqspec.services.ReqSpecGrammarAccess;

@SuppressWarnings("all")
public class ReqSpecSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ReqSpecGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_DocGoal_CategoryKeyword_5_1_0_q;
	protected AbstractElementAlias match_DocGoal_EvolvesKeyword_5_9_0_q;
	protected AbstractElementAlias match_DocGoal_IssuesKeyword_5_13_0_q;
	protected AbstractElementAlias match_DocGoal_QualityKeyword_5_0_0_q;
	protected AbstractElementAlias match_DocGoal_RefinesKeyword_5_7_0_q;
	protected AbstractElementAlias match_DocGoal_StakeholderKeyword_5_11_0_q;
	protected AbstractElementAlias match_DocGoal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q;
	protected AbstractElementAlias match_DocGoal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q;
	protected AbstractElementAlias match_DocRequirement_CategoryKeyword_6_1_0_q;
	protected AbstractElementAlias match_DocRequirement_DecomposesKeyword_6_11_0_q;
	protected AbstractElementAlias match_DocRequirement_EvolvesKeyword_6_13_0_q;
	protected AbstractElementAlias match_DocRequirement_IssuesKeyword_6_18_0_q;
	protected AbstractElementAlias match_DocRequirement_QualityKeyword_6_0_0_q;
	protected AbstractElementAlias match_DocRequirement_RefinesKeyword_6_10_0_q;
	protected AbstractElementAlias match_DocRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q;
	protected AbstractElementAlias match_GlobalRequirement_CategoryKeyword_6_1_0_q;
	protected AbstractElementAlias match_GlobalRequirement_DecomposesKeyword_6_11_0_q;
	protected AbstractElementAlias match_GlobalRequirement_EvolvesKeyword_6_12_0_q;
	protected AbstractElementAlias match_GlobalRequirement_IssuesKeyword_6_18_0_q;
	protected AbstractElementAlias match_GlobalRequirement_QualityKeyword_6_0_0_q;
	protected AbstractElementAlias match_GlobalRequirement_RefinesKeyword_6_10_0_q;
	protected AbstractElementAlias match_GlobalRequirement___DevelopmentKeyword_6_14_0_StakeholderKeyword_6_14_1__q;
	protected AbstractElementAlias match_GlobalRequirement___SeeKeyword_6_15_0_GoalKeyword_6_15_1__q;
	protected AbstractElementAlias match_GlobalRequirement___SeeKeyword_6_16_0_RequirementKeyword_6_16_1__q;
	protected AbstractElementAlias match_GlobalRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q;
	protected AbstractElementAlias match_GlobalRequirements_IssuesKeyword_7_6_0_q;
	protected AbstractElementAlias match_GlobalRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q;
	protected AbstractElementAlias match_GlobalRequirements___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q;
	protected AbstractElementAlias match_Goal_CategoryKeyword_5_1_0_q;
	protected AbstractElementAlias match_Goal_EvolvesKeyword_5_9_0_q;
	protected AbstractElementAlias match_Goal_IssuesKeyword_5_14_0_q;
	protected AbstractElementAlias match_Goal_QualityKeyword_5_0_0_q;
	protected AbstractElementAlias match_Goal_RefinesKeyword_5_7_0_q;
	protected AbstractElementAlias match_Goal_StakeholderKeyword_5_11_0_q;
	protected AbstractElementAlias match_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_12_0_GoalKeyword_5_12_1__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q;
	protected AbstractElementAlias match_ReqDocument_IssuesKeyword_4_3_0_q;
	protected AbstractElementAlias match_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q;
	protected AbstractElementAlias match_ResultIssue___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q;
	protected AbstractElementAlias match_StakeholderGoals_IssuesKeyword_7_4_0_q;
	protected AbstractElementAlias match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q;
	protected AbstractElementAlias match_SystemRequirement_CategoryKeyword_6_1_0_q;
	protected AbstractElementAlias match_SystemRequirement_DecomposesKeyword_6_11_0_q;
	protected AbstractElementAlias match_SystemRequirement_EvolvesKeyword_6_13_0_q;
	protected AbstractElementAlias match_SystemRequirement_IssuesKeyword_6_19_0_q;
	protected AbstractElementAlias match_SystemRequirement_QualityKeyword_6_0_0_q;
	protected AbstractElementAlias match_SystemRequirement_RefinesKeyword_6_10_0_q;
	protected AbstractElementAlias match_SystemRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q;
	protected AbstractElementAlias match_SystemRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q;
	protected AbstractElementAlias match_SystemRequirement___SeeKeyword_6_17_0_RequirementKeyword_6_17_1__q;
	protected AbstractElementAlias match_SystemRequirement___SeeKeyword_6_18_0_DocumentKeyword_6_18_1__q;
	protected AbstractElementAlias match_SystemRequirements_IssuesKeyword_9_7_0_q;
	protected AbstractElementAlias match_SystemRequirements___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q;
	protected AbstractElementAlias match_SystemRequirements___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ReqSpecGrammarAccess) access;
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_DocGoal_CategoryKeyword_5_1_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getCategoryKeyword_5_1_0());
		match_DocGoal_EvolvesKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getEvolvesKeyword_5_9_0());
		match_DocGoal_IssuesKeyword_5_13_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getIssuesKeyword_5_13_0());
		match_DocGoal_QualityKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getQualityKeyword_5_0_0());
		match_DocGoal_RefinesKeyword_5_7_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getRefinesKeyword_5_7_0());
		match_DocGoal_StakeholderKeyword_5_11_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getStakeholderKeyword_5_11_0());
		match_DocGoal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getConflictsKeyword_5_8_0()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getWithKeyword_5_8_1()));
		match_DocGoal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getSeeKeyword_5_12_0()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getDocumentKeyword_5_12_1()));
		match_DocRequirement_CategoryKeyword_6_1_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getCategoryKeyword_6_1_0());
		match_DocRequirement_DecomposesKeyword_6_11_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getDecomposesKeyword_6_11_0());
		match_DocRequirement_EvolvesKeyword_6_13_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getEvolvesKeyword_6_13_0());
		match_DocRequirement_IssuesKeyword_6_18_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getIssuesKeyword_6_18_0());
		match_DocRequirement_QualityKeyword_6_0_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getQualityKeyword_6_0_0());
		match_DocRequirement_RefinesKeyword_6_10_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getRefinesKeyword_6_10_0());
		match_DocRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDevelopmentKeyword_6_15_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getStakeholderKeyword_6_15_1()));
		match_DocRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_6_16_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getGoalKeyword_6_16_1()));
		match_DocRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_6_17_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDocumentKeyword_6_17_1()));
		match_GlobalRequirement_CategoryKeyword_6_1_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getCategoryKeyword_6_1_0());
		match_GlobalRequirement_DecomposesKeyword_6_11_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getDecomposesKeyword_6_11_0());
		match_GlobalRequirement_EvolvesKeyword_6_12_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getEvolvesKeyword_6_12_0());
		match_GlobalRequirement_IssuesKeyword_6_18_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getIssuesKeyword_6_18_0());
		match_GlobalRequirement_QualityKeyword_6_0_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getQualityKeyword_6_0_0());
		match_GlobalRequirement_RefinesKeyword_6_10_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getRefinesKeyword_6_10_0());
		match_GlobalRequirement___DevelopmentKeyword_6_14_0_StakeholderKeyword_6_14_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getDevelopmentKeyword_6_14_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getStakeholderKeyword_6_14_1()));
		match_GlobalRequirement___SeeKeyword_6_15_0_GoalKeyword_6_15_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_6_15_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getGoalKeyword_6_15_1()));
		match_GlobalRequirement___SeeKeyword_6_16_0_RequirementKeyword_6_16_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_6_16_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_6_16_1()));
		match_GlobalRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_6_17_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getDocumentKeyword_6_17_1()));
		match_GlobalRequirements_IssuesKeyword_7_6_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementsAccess().getIssuesKeyword_7_6_0());
		match_GlobalRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementsAccess().getSeeKeyword_7_4_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementsAccess().getDocumentKeyword_7_4_1()));
		match_GlobalRequirements___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementsAccess().getSeeKeyword_7_5_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementsAccess().getGoalsKeyword_7_5_1()));
		match_Goal_CategoryKeyword_5_1_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getCategoryKeyword_5_1_0());
		match_Goal_EvolvesKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getEvolvesKeyword_5_9_0());
		match_Goal_IssuesKeyword_5_14_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getIssuesKeyword_5_14_0());
		match_Goal_QualityKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getQualityKeyword_5_0_0());
		match_Goal_RefinesKeyword_5_7_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getRefinesKeyword_5_7_0());
		match_Goal_StakeholderKeyword_5_11_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getStakeholderKeyword_5_11_0());
		match_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getConflictsKeyword_5_8_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getWithKeyword_5_8_1()));
		match_Goal___SeeKeyword_5_12_0_GoalKeyword_5_12_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getGoalKeyword_5_12_1()));
		match_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_13_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getDocumentKeyword_5_13_1()));
		match_ReqDocument_IssuesKeyword_4_3_0_q = new TokenAlias(false, true, grammarAccess.getReqDocumentAccess().getIssuesKeyword_4_3_0());
		match_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getReqDocumentAccess().getSeeKeyword_4_2_0()), new TokenAlias(false, false, grammarAccess.getReqDocumentAccess().getDocumentKeyword_4_2_1()));
		match_ResultIssue___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2()));
		match_StakeholderGoals_IssuesKeyword_7_4_0_q = new TokenAlias(false, true, grammarAccess.getStakeholderGoalsAccess().getIssuesKeyword_7_4_0());
		match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getStakeholderGoalsAccess().getSeeKeyword_7_3_0()), new TokenAlias(false, false, grammarAccess.getStakeholderGoalsAccess().getDocumentKeyword_7_3_1()));
		match_SystemRequirement_CategoryKeyword_6_1_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getCategoryKeyword_6_1_0());
		match_SystemRequirement_DecomposesKeyword_6_11_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getDecomposesKeyword_6_11_0());
		match_SystemRequirement_EvolvesKeyword_6_13_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getEvolvesKeyword_6_13_0());
		match_SystemRequirement_IssuesKeyword_6_19_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getIssuesKeyword_6_19_0());
		match_SystemRequirement_QualityKeyword_6_0_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getQualityKeyword_6_0_0());
		match_SystemRequirement_RefinesKeyword_6_10_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getRefinesKeyword_6_10_0());
		match_SystemRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getDevelopmentKeyword_6_15_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getStakeholderKeyword_6_15_1()));
		match_SystemRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getSeeKeyword_6_16_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getGoalKeyword_6_16_1()));
		match_SystemRequirement___SeeKeyword_6_17_0_RequirementKeyword_6_17_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getSeeKeyword_6_17_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getRequirementKeyword_6_17_1()));
		match_SystemRequirement___SeeKeyword_6_18_0_DocumentKeyword_6_18_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getSeeKeyword_6_18_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getDocumentKeyword_6_18_1()));
		match_SystemRequirements_IssuesKeyword_9_7_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementsAccess().getIssuesKeyword_9_7_0());
		match_SystemRequirements___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementsAccess().getSeeKeyword_9_5_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementsAccess().getDocumentKeyword_9_5_1()));
		match_SystemRequirements___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementsAccess().getSeeKeyword_9_6_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementsAccess().getGoalsKeyword_9_6_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_CategoryKeyword_5_1_0_q.equals(syntax))
				emit_DocGoal_CategoryKeyword_5_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_EvolvesKeyword_5_9_0_q.equals(syntax))
				emit_DocGoal_EvolvesKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_IssuesKeyword_5_13_0_q.equals(syntax))
				emit_DocGoal_IssuesKeyword_5_13_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_QualityKeyword_5_0_0_q.equals(syntax))
				emit_DocGoal_QualityKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_RefinesKeyword_5_7_0_q.equals(syntax))
				emit_DocGoal_RefinesKeyword_5_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal_StakeholderKeyword_5_11_0_q.equals(syntax))
				emit_DocGoal_StakeholderKeyword_5_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q.equals(syntax))
				emit_DocGoal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocGoal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q.equals(syntax))
				emit_DocGoal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_CategoryKeyword_6_1_0_q.equals(syntax))
				emit_DocRequirement_CategoryKeyword_6_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_DecomposesKeyword_6_11_0_q.equals(syntax))
				emit_DocRequirement_DecomposesKeyword_6_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_EvolvesKeyword_6_13_0_q.equals(syntax))
				emit_DocRequirement_EvolvesKeyword_6_13_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_IssuesKeyword_6_18_0_q.equals(syntax))
				emit_DocRequirement_IssuesKeyword_6_18_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_QualityKeyword_6_0_0_q.equals(syntax))
				emit_DocRequirement_QualityKeyword_6_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement_RefinesKeyword_6_10_0_q.equals(syntax))
				emit_DocRequirement_RefinesKeyword_6_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q.equals(syntax))
				emit_DocRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DocRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement_CategoryKeyword_6_1_0_q.equals(syntax))
				emit_GlobalRequirement_CategoryKeyword_6_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement_DecomposesKeyword_6_11_0_q.equals(syntax))
				emit_GlobalRequirement_DecomposesKeyword_6_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement_EvolvesKeyword_6_12_0_q.equals(syntax))
				emit_GlobalRequirement_EvolvesKeyword_6_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement_IssuesKeyword_6_18_0_q.equals(syntax))
				emit_GlobalRequirement_IssuesKeyword_6_18_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement_QualityKeyword_6_0_0_q.equals(syntax))
				emit_GlobalRequirement_QualityKeyword_6_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement_RefinesKeyword_6_10_0_q.equals(syntax))
				emit_GlobalRequirement_RefinesKeyword_6_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement___DevelopmentKeyword_6_14_0_StakeholderKeyword_6_14_1__q.equals(syntax))
				emit_GlobalRequirement___DevelopmentKeyword_6_14_0_StakeholderKeyword_6_14_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement___SeeKeyword_6_15_0_GoalKeyword_6_15_1__q.equals(syntax))
				emit_GlobalRequirement___SeeKeyword_6_15_0_GoalKeyword_6_15_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement___SeeKeyword_6_16_0_RequirementKeyword_6_16_1__q.equals(syntax))
				emit_GlobalRequirement___SeeKeyword_6_16_0_RequirementKeyword_6_16_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q.equals(syntax))
				emit_GlobalRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirements_IssuesKeyword_7_6_0_q.equals(syntax))
				emit_GlobalRequirements_IssuesKeyword_7_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q.equals(syntax))
				emit_GlobalRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GlobalRequirements___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q.equals(syntax))
				emit_GlobalRequirements___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_CategoryKeyword_5_1_0_q.equals(syntax))
				emit_Goal_CategoryKeyword_5_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_EvolvesKeyword_5_9_0_q.equals(syntax))
				emit_Goal_EvolvesKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_IssuesKeyword_5_14_0_q.equals(syntax))
				emit_Goal_IssuesKeyword_5_14_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_QualityKeyword_5_0_0_q.equals(syntax))
				emit_Goal_QualityKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_RefinesKeyword_5_7_0_q.equals(syntax))
				emit_Goal_RefinesKeyword_5_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_StakeholderKeyword_5_11_0_q.equals(syntax))
				emit_Goal_StakeholderKeyword_5_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q.equals(syntax))
				emit_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___SeeKeyword_5_12_0_GoalKeyword_5_12_1__q.equals(syntax))
				emit_Goal___SeeKeyword_5_12_0_GoalKeyword_5_12_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q.equals(syntax))
				emit_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ReqDocument_IssuesKeyword_4_3_0_q.equals(syntax))
				emit_ReqDocument_IssuesKeyword_4_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q.equals(syntax))
				emit_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultIssue___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q.equals(syntax))
				emit_ResultIssue___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_StakeholderGoals_IssuesKeyword_7_4_0_q.equals(syntax))
				emit_StakeholderGoals_IssuesKeyword_7_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q.equals(syntax))
				emit_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement_CategoryKeyword_6_1_0_q.equals(syntax))
				emit_SystemRequirement_CategoryKeyword_6_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement_DecomposesKeyword_6_11_0_q.equals(syntax))
				emit_SystemRequirement_DecomposesKeyword_6_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement_EvolvesKeyword_6_13_0_q.equals(syntax))
				emit_SystemRequirement_EvolvesKeyword_6_13_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement_IssuesKeyword_6_19_0_q.equals(syntax))
				emit_SystemRequirement_IssuesKeyword_6_19_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement_QualityKeyword_6_0_0_q.equals(syntax))
				emit_SystemRequirement_QualityKeyword_6_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement_RefinesKeyword_6_10_0_q.equals(syntax))
				emit_SystemRequirement_RefinesKeyword_6_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q.equals(syntax))
				emit_SystemRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q.equals(syntax))
				emit_SystemRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement___SeeKeyword_6_17_0_RequirementKeyword_6_17_1__q.equals(syntax))
				emit_SystemRequirement___SeeKeyword_6_17_0_RequirementKeyword_6_17_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirement___SeeKeyword_6_18_0_DocumentKeyword_6_18_1__q.equals(syntax))
				emit_SystemRequirement___SeeKeyword_6_18_0_DocumentKeyword_6_18_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirements_IssuesKeyword_9_7_0_q.equals(syntax))
				emit_SystemRequirements_IssuesKeyword_9_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirements___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q.equals(syntax))
				emit_SystemRequirements___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SystemRequirements___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q.equals(syntax))
				emit_SystemRequirements___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=AExpression
	 *     (rule start) (ambiguity) '#' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) '@' modelElement=[NamedElement|QualifiedName]
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) 'this' (rule start)
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=AExpression
	 *     (rule start) (ambiguity) feature=OpUnary
	 *     (rule start) (ambiguity) function=ID
	 *     (rule start) (ambiguity) value=AInt
	 *     (rule start) (ambiguity) value=AReal
	 *     (rule start) (ambiguity) value=NoQuoteString
	 *     (rule start) (ambiguity) value?='true'
	 *     (rule start) (ambiguity) variable=[AVariableDeclaration|ID]
	 *     (rule start) (ambiguity) {ABinaryOperation.leftOperand=}
	 */
	protected void emit_AParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' ')' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=AExpression
	 *     (rule start) (ambiguity) '#' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) '@' modelElement=[NamedElement|QualifiedName]
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) 'null' ')' (rule start)
	 *     (rule start) (ambiguity) 'this' ')' (rule start)
	 *     (rule start) (ambiguity) '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=AExpression
	 *     (rule start) (ambiguity) feature=OpUnary
	 *     (rule start) (ambiguity) function=ID
	 *     (rule start) (ambiguity) value=AInt
	 *     (rule start) (ambiguity) value=AReal
	 *     (rule start) (ambiguity) value=NoQuoteString
	 *     (rule start) (ambiguity) value?='true'
	 *     (rule start) (ambiguity) variable=[AVariableDeclaration|ID]
	 *     (rule start) (ambiguity) {ABinaryOperation.leftOperand=}
	 */
	protected void emit_AParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     userCategory+=[UserCategory|ID] (ambiguity) userCategory+=[UserCategory|ID]
	 */
	protected void emit_DocGoal_CategoryKeyword_5_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocGoal_EvolvesKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_DocGoal_IssuesKeyword_5_13_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'quality'?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) qualityCategory+=[QualityCategory|ID]
	 */
	protected void emit_DocGoal_QualityKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Goal|QualifiedName] (ambiguity) refinesReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocGoal_RefinesKeyword_5_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'stakeholder'?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderReference+=[Stakeholder|QualifiedName] (ambiguity) stakeholderReference+=[Stakeholder|QualifiedName]
	 */
	protected void emit_DocGoal_StakeholderKeyword_5_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('conflicts' 'with')?
	 *
	 * This ambiguous syntax occurs at:
	 *     conflictsReference+=[Goal|QualifiedName] (ambiguity) conflictsReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocGoal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_DocGoal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     userCategory+=[UserCategory|ID] (ambiguity) userCategory+=[UserCategory|ID]
	 */
	protected void emit_DocRequirement_CategoryKeyword_6_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_DecomposesKeyword_6_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_EvolvesKeyword_6_13_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_DocRequirement_IssuesKeyword_6_18_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'quality'?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) qualityCategory+=[QualityCategory|ID]
	 */
	protected void emit_DocRequirement_QualityKeyword_6_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_RefinesKeyword_6_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_DocRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_DocRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     userCategory+=[UserCategory|ID] (ambiguity) userCategory+=[UserCategory|ID]
	 */
	protected void emit_GlobalRequirement_CategoryKeyword_6_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement_DecomposesKeyword_6_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement_EvolvesKeyword_6_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_GlobalRequirement_IssuesKeyword_6_18_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'quality'?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) qualityCategory+=[QualityCategory|ID]
	 */
	protected void emit_GlobalRequirement_QualityKeyword_6_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement_RefinesKeyword_6_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_GlobalRequirement___DevelopmentKeyword_6_14_0_StakeholderKeyword_6_14_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_GlobalRequirement___SeeKeyword_6_15_0_GoalKeyword_6_15_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     requirementReference+=[Requirement|QualifiedName] (ambiguity) requirementReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement___SeeKeyword_6_16_0_RequirementKeyword_6_16_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_GlobalRequirement___SeeKeyword_6_17_0_DocumentKeyword_6_17_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_GlobalRequirements_IssuesKeyword_7_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_GlobalRequirements___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goals')?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderGoals+=[ReqRoot|QualifiedName] (ambiguity) stakeholderGoals+=[ReqRoot|QualifiedName]
	 */
	protected void emit_GlobalRequirements___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     userCategory+=[UserCategory|ID] (ambiguity) userCategory+=[UserCategory|ID]
	 */
	protected void emit_Goal_CategoryKeyword_5_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_Goal_EvolvesKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_Goal_IssuesKeyword_5_14_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'quality'?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) qualityCategory+=[QualityCategory|ID]
	 */
	protected void emit_Goal_QualityKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Goal|QualifiedName] (ambiguity) refinesReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal_RefinesKeyword_5_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'stakeholder'?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderReference+=[Stakeholder|QualifiedName] (ambiguity) stakeholderReference+=[Stakeholder|QualifiedName]
	 */
	protected void emit_Goal_StakeholderKeyword_5_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('conflicts' 'with')?
	 *
	 * This ambiguous syntax occurs at:
	 *     conflictsReference+=[Goal|QualifiedName] (ambiguity) conflictsReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal___ConflictsKeyword_5_8_0_WithKeyword_5_8_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal___SeeKeyword_5_12_0_GoalKeyword_5_12_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_Goal___SeeKeyword_5_13_0_DocumentKeyword_5_13_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_ReqDocument_IssuesKeyword_4_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     diagnosticId=STRING (ambiguity) (rule end)
	 *     exceptionType=STRING (ambiguity) (rule end)
	 *     message=STRING (ambiguity) (rule end)
	 *     target=[EObject|URIID] (ambiguity) (rule end)
	 */
	protected void emit_ResultIssue___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_StakeholderGoals_IssuesKeyword_7_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     userCategory+=[UserCategory|ID] (ambiguity) userCategory+=[UserCategory|ID]
	 */
	protected void emit_SystemRequirement_CategoryKeyword_6_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement_DecomposesKeyword_6_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement_EvolvesKeyword_6_13_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_SystemRequirement_IssuesKeyword_6_19_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'quality'?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) qualityCategory+=[QualityCategory|ID]
	 */
	protected void emit_SystemRequirement_QualityKeyword_6_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement_RefinesKeyword_6_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_SystemRequirement___DevelopmentKeyword_6_15_0_StakeholderKeyword_6_15_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_SystemRequirement___SeeKeyword_6_16_0_GoalKeyword_6_16_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     requirementReference+=[Requirement|QualifiedName] (ambiguity) requirementReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement___SeeKeyword_6_17_0_RequirementKeyword_6_17_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_SystemRequirement___SeeKeyword_6_18_0_DocumentKeyword_6_18_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_SystemRequirements_IssuesKeyword_9_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_SystemRequirements___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goals')?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderGoals+=[ReqRoot|QualifiedName] (ambiguity) stakeholderGoals+=[ReqRoot|QualifiedName]
	 */
	protected void emit_SystemRequirements___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
