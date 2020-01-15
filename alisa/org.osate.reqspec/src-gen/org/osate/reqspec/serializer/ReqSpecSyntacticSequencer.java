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
	protected AbstractElementAlias match_DocGoal_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_DocGoal_EvolvesKeyword_5_8_0_q;
	protected AbstractElementAlias match_DocGoal_IssuesKeyword_5_12_0_q;
	protected AbstractElementAlias match_DocGoal_RefinesKeyword_5_6_0_q;
	protected AbstractElementAlias match_DocGoal_StakeholderKeyword_5_10_0_q;
	protected AbstractElementAlias match_DocGoal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q;
	protected AbstractElementAlias match_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q;
	protected AbstractElementAlias match_DocRequirement_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_DocRequirement_DecomposesKeyword_5_10_0_q;
	protected AbstractElementAlias match_DocRequirement_EvolvesKeyword_5_12_0_q;
	protected AbstractElementAlias match_DocRequirement_IssuesKeyword_5_17_0_q;
	protected AbstractElementAlias match_DocRequirement_RefinesKeyword_5_9_0_q;
	protected AbstractElementAlias match_DocRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q;
	protected AbstractElementAlias match_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q;
	protected AbstractElementAlias match_GlobalRequirementSet_IssuesKeyword_7_6_0_q;
	protected AbstractElementAlias match_GlobalRequirementSet___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q;
	protected AbstractElementAlias match_GlobalRequirementSet___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q;
	protected AbstractElementAlias match_GlobalRequirement_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_GlobalRequirement_DecomposesKeyword_5_10_0_q;
	protected AbstractElementAlias match_GlobalRequirement_EvolvesKeyword_5_11_0_q;
	protected AbstractElementAlias match_GlobalRequirement_IssuesKeyword_5_17_0_q;
	protected AbstractElementAlias match_GlobalRequirement_RefinesKeyword_5_9_0_q;
	protected AbstractElementAlias match_GlobalRequirement___DevelopmentKeyword_5_13_0_StakeholderKeyword_5_13_1__q;
	protected AbstractElementAlias match_GlobalRequirement___SeeKeyword_5_14_0_GoalKeyword_5_14_1__q;
	protected AbstractElementAlias match_GlobalRequirement___SeeKeyword_5_15_0_RequirementKeyword_5_15_1__q;
	protected AbstractElementAlias match_GlobalRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q;
	protected AbstractElementAlias match_Goal_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_Goal_EvolvesKeyword_5_8_0_q;
	protected AbstractElementAlias match_Goal_IssuesKeyword_5_13_0_q;
	protected AbstractElementAlias match_Goal_RefinesKeyword_5_6_0_q;
	protected AbstractElementAlias match_Goal_StakeholderKeyword_5_10_0_q;
	protected AbstractElementAlias match_Goal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_11_0_GoalKeyword_5_11_1__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q;
	protected AbstractElementAlias match_ReqDocument_IssuesKeyword_4_3_0_q;
	protected AbstractElementAlias match_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q;
	protected AbstractElementAlias match_StakeholderGoals_IssuesKeyword_7_4_0_q;
	protected AbstractElementAlias match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q;
	protected AbstractElementAlias match_SystemRequirementSet_IssuesKeyword_9_7_0_q;
	protected AbstractElementAlias match_SystemRequirementSet___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q;
	protected AbstractElementAlias match_SystemRequirementSet___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q;
	protected AbstractElementAlias match_SystemRequirement_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_SystemRequirement_DecomposesKeyword_5_12_0_q;
	protected AbstractElementAlias match_SystemRequirement_EvolvesKeyword_5_13_0_q;
	protected AbstractElementAlias match_SystemRequirement_IssuesKeyword_5_18_0_q;
	protected AbstractElementAlias match_SystemRequirement_RefinesKeyword_5_11_0_q;
	protected AbstractElementAlias match_SystemRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q;
	protected AbstractElementAlias match_SystemRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q;
	protected AbstractElementAlias match_SystemRequirement___SeeKeyword_5_16_0_RequirementKeyword_5_16_1__q;
	protected AbstractElementAlias match_SystemRequirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ReqSpecGrammarAccess) access;
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_DocGoal_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getCategoryKeyword_5_0_0());
		match_DocGoal_EvolvesKeyword_5_8_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getEvolvesKeyword_5_8_0());
		match_DocGoal_IssuesKeyword_5_12_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getIssuesKeyword_5_12_0());
		match_DocGoal_RefinesKeyword_5_6_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getRefinesKeyword_5_6_0());
		match_DocGoal_StakeholderKeyword_5_10_0_q = new TokenAlias(false, true, grammarAccess.getDocGoalAccess().getStakeholderKeyword_5_10_0());
		match_DocGoal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getConflictsKeyword_5_7_0()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getWithKeyword_5_7_1()));
		match_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getSeeKeyword_5_11_0()), new TokenAlias(false, false, grammarAccess.getDocGoalAccess().getDocumentKeyword_5_11_1()));
		match_DocRequirement_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getCategoryKeyword_5_0_0());
		match_DocRequirement_DecomposesKeyword_5_10_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getDecomposesKeyword_5_10_0());
		match_DocRequirement_EvolvesKeyword_5_12_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getEvolvesKeyword_5_12_0());
		match_DocRequirement_IssuesKeyword_5_17_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getIssuesKeyword_5_17_0());
		match_DocRequirement_RefinesKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getDocRequirementAccess().getRefinesKeyword_5_9_0());
		match_DocRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDevelopmentKeyword_5_14_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getStakeholderKeyword_5_14_1()));
		match_DocRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_15_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getGoalKeyword_5_15_1()));
		match_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getSeeKeyword_5_16_0()), new TokenAlias(false, false, grammarAccess.getDocRequirementAccess().getDocumentKeyword_5_16_1()));
		match_GlobalRequirementSet_IssuesKeyword_7_6_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementSetAccess().getIssuesKeyword_7_6_0());
		match_GlobalRequirementSet___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_4_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementSetAccess().getDocumentKeyword_7_4_1()));
		match_GlobalRequirementSet___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementSetAccess().getSeeKeyword_7_5_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementSetAccess().getGoalsKeyword_7_5_1()));
		match_GlobalRequirement_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getCategoryKeyword_5_0_0());
		match_GlobalRequirement_DecomposesKeyword_5_10_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getDecomposesKeyword_5_10_0());
		match_GlobalRequirement_EvolvesKeyword_5_11_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getEvolvesKeyword_5_11_0());
		match_GlobalRequirement_IssuesKeyword_5_17_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getIssuesKeyword_5_17_0());
		match_GlobalRequirement_RefinesKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getGlobalRequirementAccess().getRefinesKeyword_5_9_0());
		match_GlobalRequirement___DevelopmentKeyword_5_13_0_StakeholderKeyword_5_13_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getDevelopmentKeyword_5_13_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getStakeholderKeyword_5_13_1()));
		match_GlobalRequirement___SeeKeyword_5_14_0_GoalKeyword_5_14_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_14_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getGoalKeyword_5_14_1()));
		match_GlobalRequirement___SeeKeyword_5_15_0_RequirementKeyword_5_15_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_15_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getRequirementKeyword_5_15_1()));
		match_GlobalRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getSeeKeyword_5_16_0()), new TokenAlias(false, false, grammarAccess.getGlobalRequirementAccess().getDocumentKeyword_5_16_1()));
		match_Goal_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
		match_Goal_EvolvesKeyword_5_8_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getEvolvesKeyword_5_8_0());
		match_Goal_IssuesKeyword_5_13_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getIssuesKeyword_5_13_0());
		match_Goal_RefinesKeyword_5_6_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getRefinesKeyword_5_6_0());
		match_Goal_StakeholderKeyword_5_10_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getStakeholderKeyword_5_10_0());
		match_Goal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getConflictsKeyword_5_7_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getWithKeyword_5_7_1()));
		match_Goal___SeeKeyword_5_11_0_GoalKeyword_5_11_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_11_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getGoalKeyword_5_11_1()));
		match_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getDocumentKeyword_5_12_1()));
		match_ReqDocument_IssuesKeyword_4_3_0_q = new TokenAlias(false, true, grammarAccess.getReqDocumentAccess().getIssuesKeyword_4_3_0());
		match_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getReqDocumentAccess().getSeeKeyword_4_2_0()), new TokenAlias(false, false, grammarAccess.getReqDocumentAccess().getDocumentKeyword_4_2_1()));
		match_StakeholderGoals_IssuesKeyword_7_4_0_q = new TokenAlias(false, true, grammarAccess.getStakeholderGoalsAccess().getIssuesKeyword_7_4_0());
		match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getStakeholderGoalsAccess().getSeeKeyword_7_3_0()), new TokenAlias(false, false, grammarAccess.getStakeholderGoalsAccess().getDocumentKeyword_7_3_1()));
		match_SystemRequirementSet_IssuesKeyword_9_7_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementSetAccess().getIssuesKeyword_9_7_0());
		match_SystemRequirementSet___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_5_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementSetAccess().getDocumentKeyword_9_5_1()));
		match_SystemRequirementSet___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementSetAccess().getSeeKeyword_9_6_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementSetAccess().getGoalsKeyword_9_6_1()));
		match_SystemRequirement_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getCategoryKeyword_5_0_0());
		match_SystemRequirement_DecomposesKeyword_5_12_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getDecomposesKeyword_5_12_0());
		match_SystemRequirement_EvolvesKeyword_5_13_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getEvolvesKeyword_5_13_0());
		match_SystemRequirement_IssuesKeyword_5_18_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getIssuesKeyword_5_18_0());
		match_SystemRequirement_RefinesKeyword_5_11_0_q = new TokenAlias(false, true, grammarAccess.getSystemRequirementAccess().getRefinesKeyword_5_11_0());
		match_SystemRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getDevelopmentKeyword_5_14_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getStakeholderKeyword_5_14_1()));
		match_SystemRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_15_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getGoalKeyword_5_15_1()));
		match_SystemRequirement___SeeKeyword_5_16_0_RequirementKeyword_5_16_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_16_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getRequirementKeyword_5_16_1()));
		match_SystemRequirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getSeeKeyword_5_17_0()), new TokenAlias(false, false, grammarAccess.getSystemRequirementAccess().getDocumentKeyword_5_17_1()));
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
			if (match_AParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocGoal_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_DocGoal_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocGoal_EvolvesKeyword_5_8_0_q.equals(syntax))
				emit_DocGoal_EvolvesKeyword_5_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocGoal_IssuesKeyword_5_12_0_q.equals(syntax))
				emit_DocGoal_IssuesKeyword_5_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocGoal_RefinesKeyword_5_6_0_q.equals(syntax))
				emit_DocGoal_RefinesKeyword_5_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocGoal_StakeholderKeyword_5_10_0_q.equals(syntax))
				emit_DocGoal_StakeholderKeyword_5_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocGoal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q.equals(syntax))
				emit_DocGoal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q.equals(syntax))
				emit_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_DocRequirement_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement_DecomposesKeyword_5_10_0_q.equals(syntax))
				emit_DocRequirement_DecomposesKeyword_5_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement_EvolvesKeyword_5_12_0_q.equals(syntax))
				emit_DocRequirement_EvolvesKeyword_5_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement_IssuesKeyword_5_17_0_q.equals(syntax))
				emit_DocRequirement_IssuesKeyword_5_17_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement_RefinesKeyword_5_9_0_q.equals(syntax))
				emit_DocRequirement_RefinesKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q.equals(syntax))
				emit_DocRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q.equals(syntax))
				emit_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirementSet_IssuesKeyword_7_6_0_q.equals(syntax))
				emit_GlobalRequirementSet_IssuesKeyword_7_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirementSet___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q.equals(syntax))
				emit_GlobalRequirementSet___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirementSet___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q.equals(syntax))
				emit_GlobalRequirementSet___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_GlobalRequirement_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement_DecomposesKeyword_5_10_0_q.equals(syntax))
				emit_GlobalRequirement_DecomposesKeyword_5_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement_EvolvesKeyword_5_11_0_q.equals(syntax))
				emit_GlobalRequirement_EvolvesKeyword_5_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement_IssuesKeyword_5_17_0_q.equals(syntax))
				emit_GlobalRequirement_IssuesKeyword_5_17_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement_RefinesKeyword_5_9_0_q.equals(syntax))
				emit_GlobalRequirement_RefinesKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement___DevelopmentKeyword_5_13_0_StakeholderKeyword_5_13_1__q.equals(syntax))
				emit_GlobalRequirement___DevelopmentKeyword_5_13_0_StakeholderKeyword_5_13_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement___SeeKeyword_5_14_0_GoalKeyword_5_14_1__q.equals(syntax))
				emit_GlobalRequirement___SeeKeyword_5_14_0_GoalKeyword_5_14_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement___SeeKeyword_5_15_0_RequirementKeyword_5_15_1__q.equals(syntax))
				emit_GlobalRequirement___SeeKeyword_5_15_0_RequirementKeyword_5_15_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_GlobalRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q.equals(syntax))
				emit_GlobalRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_Goal_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal_EvolvesKeyword_5_8_0_q.equals(syntax))
				emit_Goal_EvolvesKeyword_5_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal_IssuesKeyword_5_13_0_q.equals(syntax))
				emit_Goal_IssuesKeyword_5_13_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal_RefinesKeyword_5_6_0_q.equals(syntax))
				emit_Goal_RefinesKeyword_5_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal_StakeholderKeyword_5_10_0_q.equals(syntax))
				emit_Goal_StakeholderKeyword_5_10_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q.equals(syntax))
				emit_Goal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal___SeeKeyword_5_11_0_GoalKeyword_5_11_1__q.equals(syntax))
				emit_Goal___SeeKeyword_5_11_0_GoalKeyword_5_11_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q.equals(syntax))
				emit_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ReqDocument_IssuesKeyword_4_3_0_q.equals(syntax))
				emit_ReqDocument_IssuesKeyword_4_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q.equals(syntax))
				emit_ReqDocument___SeeKeyword_4_2_0_DocumentKeyword_4_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_StakeholderGoals_IssuesKeyword_7_4_0_q.equals(syntax))
				emit_StakeholderGoals_IssuesKeyword_7_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q.equals(syntax))
				emit_StakeholderGoals___SeeKeyword_7_3_0_DocumentKeyword_7_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirementSet_IssuesKeyword_9_7_0_q.equals(syntax))
				emit_SystemRequirementSet_IssuesKeyword_9_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirementSet___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q.equals(syntax))
				emit_SystemRequirementSet___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirementSet___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q.equals(syntax))
				emit_SystemRequirementSet___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_SystemRequirement_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement_DecomposesKeyword_5_12_0_q.equals(syntax))
				emit_SystemRequirement_DecomposesKeyword_5_12_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement_EvolvesKeyword_5_13_0_q.equals(syntax))
				emit_SystemRequirement_EvolvesKeyword_5_13_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement_IssuesKeyword_5_18_0_q.equals(syntax))
				emit_SystemRequirement_IssuesKeyword_5_18_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement_RefinesKeyword_5_11_0_q.equals(syntax))
				emit_SystemRequirement_RefinesKeyword_5_11_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q.equals(syntax))
				emit_SystemRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q.equals(syntax))
				emit_SystemRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement___SeeKeyword_5_16_0_RequirementKeyword_5_16_1__q.equals(syntax))
				emit_SystemRequirement___SeeKeyword_5_16_0_RequirementKeyword_5_16_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SystemRequirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1__q.equals(syntax))
				emit_SystemRequirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) '[' minimum=AExpression
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'if' if=AExpression
	 *     (rule start) (ambiguity) function=QualifiedName
	 *     (rule start) (ambiguity) modelElement=[NamedElement|ThisKeyword]
	 *     (rule start) (ambiguity) operator=OpUnary
	 *     (rule start) (ambiguity) value=AInt
	 *     (rule start) (ambiguity) value=AReal
	 *     (rule start) (ambiguity) value=NoQuoteString
	 *     (rule start) (ambiguity) value?='true'
	 *     (rule start) (ambiguity) variable=[AVariableDeclaration|ID]
	 *     (rule start) (ambiguity) {ABinaryOperation.left=}
	 *     (rule start) (ambiguity) {AModelReference.prev=}
	 *     (rule start) (ambiguity) {APropertyReference.modelElementReference=}
	 *     (rule start) (ambiguity) {AUnitExpression.expression=}
	 */
	protected void emit_AParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) '[' minimum=AExpression
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) 'if' if=AExpression
	 *     (rule start) (ambiguity) function=QualifiedName
	 *     (rule start) (ambiguity) modelElement=[NamedElement|ThisKeyword]
	 *     (rule start) (ambiguity) operator=OpUnary
	 *     (rule start) (ambiguity) value=AInt
	 *     (rule start) (ambiguity) value=AReal
	 *     (rule start) (ambiguity) value=NoQuoteString
	 *     (rule start) (ambiguity) value?='true'
	 *     (rule start) (ambiguity) variable=[AVariableDeclaration|ID]
	 *     (rule start) (ambiguity) {ABinaryOperation.left=}
	 *     (rule start) (ambiguity) {AModelReference.prev=}
	 *     (rule start) (ambiguity) {APropertyReference.modelElementReference=}
	 *     (rule start) (ambiguity) {AUnitExpression.expression=}
	 */
	protected void emit_AParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|QualifiedName] (ambiguity) category+=[Category|QualifiedName]
	 */
	protected void emit_DocGoal_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocGoal_EvolvesKeyword_5_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_DocGoal_IssuesKeyword_5_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Goal|QualifiedName] (ambiguity) refinesReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocGoal_RefinesKeyword_5_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'stakeholder'?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderReference+=[Stakeholder|QualifiedName] (ambiguity) stakeholderReference+=[Stakeholder|QualifiedName]
	 */
	protected void emit_DocGoal_StakeholderKeyword_5_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('conflicts' 'with')?
	 *
	 * This ambiguous syntax occurs at:
	 *     conflictsReference+=[Goal|QualifiedName] (ambiguity) conflictsReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocGoal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_DocGoal___SeeKeyword_5_11_0_DocumentKeyword_5_11_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|QualifiedName] (ambiguity) category+=[Category|QualifiedName]
	 */
	protected void emit_DocRequirement_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_DecomposesKeyword_5_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_EvolvesKeyword_5_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_DocRequirement_IssuesKeyword_5_17_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_DocRequirement_RefinesKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_DocRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_DocRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_DocRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_GlobalRequirementSet_IssuesKeyword_7_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_GlobalRequirementSet___SeeKeyword_7_4_0_DocumentKeyword_7_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goals')?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderGoals+=[ReqRoot|QualifiedName] (ambiguity) stakeholderGoals+=[ReqRoot|QualifiedName]
	 */
	protected void emit_GlobalRequirementSet___SeeKeyword_7_5_0_GoalsKeyword_7_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|QualifiedName] (ambiguity) category+=[Category|QualifiedName]
	 */
	protected void emit_GlobalRequirement_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement_DecomposesKeyword_5_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement_EvolvesKeyword_5_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_GlobalRequirement_IssuesKeyword_5_17_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement_RefinesKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_GlobalRequirement___DevelopmentKeyword_5_13_0_StakeholderKeyword_5_13_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_GlobalRequirement___SeeKeyword_5_14_0_GoalKeyword_5_14_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     requirementReference+=[Requirement|QualifiedName] (ambiguity) requirementReference+=[Requirement|QualifiedName]
	 */
	protected void emit_GlobalRequirement___SeeKeyword_5_15_0_RequirementKeyword_5_15_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_GlobalRequirement___SeeKeyword_5_16_0_DocumentKeyword_5_16_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|QualifiedName] (ambiguity) category+=[Category|QualifiedName]
	 */
	protected void emit_Goal_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_Goal_EvolvesKeyword_5_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_Goal_IssuesKeyword_5_13_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Goal|QualifiedName] (ambiguity) refinesReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal_RefinesKeyword_5_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'stakeholder'?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderReference+=[Stakeholder|QualifiedName] (ambiguity) stakeholderReference+=[Stakeholder|QualifiedName]
	 */
	protected void emit_Goal_StakeholderKeyword_5_10_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('conflicts' 'with')?
	 *
	 * This ambiguous syntax occurs at:
	 *     conflictsReference+=[Goal|QualifiedName] (ambiguity) conflictsReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal___ConflictsKeyword_5_7_0_WithKeyword_5_7_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_Goal___SeeKeyword_5_11_0_GoalKeyword_5_11_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_Goal___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_SystemRequirementSet_IssuesKeyword_9_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_SystemRequirementSet___SeeKeyword_9_5_0_DocumentKeyword_9_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goals')?
	 *
	 * This ambiguous syntax occurs at:
	 *     stakeholderGoals+=[ReqRoot|QualifiedName] (ambiguity) stakeholderGoals+=[ReqRoot|QualifiedName]
	 */
	protected void emit_SystemRequirementSet___SeeKeyword_9_6_0_GoalsKeyword_9_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|QualifiedName] (ambiguity) category+=[Category|QualifiedName]
	 */
	protected void emit_SystemRequirement_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'decomposes'?
	 *
	 * This ambiguous syntax occurs at:
	 *     decomposesReference+=[Requirement|QualifiedName] (ambiguity) decomposesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement_DecomposesKeyword_5_12_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'evolves'?
	 *
	 * This ambiguous syntax occurs at:
	 *     evolvesReference+=[Requirement|QualifiedName] (ambiguity) evolvesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement_EvolvesKeyword_5_13_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_SystemRequirement_IssuesKeyword_5_18_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'refines'?
	 *
	 * This ambiguous syntax occurs at:
	 *     refinesReference+=[Requirement|QualifiedName] (ambiguity) refinesReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement_RefinesKeyword_5_11_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('development' 'stakeholder')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentStakeholder+=[Stakeholder|QualifiedName] (ambiguity) developmentStakeholder+=[Stakeholder|QualifiedName]
	 */
	protected void emit_SystemRequirement___DevelopmentKeyword_5_14_0_StakeholderKeyword_5_14_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'goal')?
	 *
	 * This ambiguous syntax occurs at:
	 *     goalReference+=[Goal|QualifiedName] (ambiguity) goalReference+=[Goal|QualifiedName]
	 */
	protected void emit_SystemRequirement___SeeKeyword_5_15_0_GoalKeyword_5_15_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'requirement')?
	 *
	 * This ambiguous syntax occurs at:
	 *     requirementReference+=[Requirement|QualifiedName] (ambiguity) requirementReference+=[Requirement|QualifiedName]
	 */
	protected void emit_SystemRequirement___SeeKeyword_5_16_0_RequirementKeyword_5_16_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('see' 'document')?
	 *
	 * This ambiguous syntax occurs at:
	 *     docReference+=ExternalDocument (ambiguity) docReference+=ExternalDocument
	 */
	protected void emit_SystemRequirement___SeeKeyword_5_17_0_DocumentKeyword_5_17_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
