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
	protected AbstractElementAlias match_Goal_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_Goal_IssuesKeyword_5_9_0_q;
	protected AbstractElementAlias match_Goal_RefinesKeyword_5_4_0_q;
	protected AbstractElementAlias match_Goal_StakeholderKeyword_5_6_0_q;
	protected AbstractElementAlias match_Goal___ConflictsKeyword_5_5_0_WithKeyword_5_5_1__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_7_0_DocumentKeyword_5_7_1_RequirementKeyword_5_7_2__q;
	protected AbstractElementAlias match_Goal___SeeKeyword_5_8_0_DocumentKeyword_5_8_1__q;
	protected AbstractElementAlias match_Requirement_CategoryKeyword_5_0_0_q;
	protected AbstractElementAlias match_Requirement_IssuesKeyword_5_13_0_q;
	protected AbstractElementAlias match_Requirement_RefinesKeyword_5_8_0_q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_GoalKeyword_5_10_2__q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_11_0_DocumentKeyword_5_11_1_RequirementKeyword_5_11_2__q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q;
	protected AbstractElementAlias match_Requirement___SeeKeyword_5_9_0_GoalKeyword_5_9_1__q;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ReqSpecGrammarAccess) access;
		match_Goal_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
		match_Goal_IssuesKeyword_5_9_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getIssuesKeyword_5_9_0());
		match_Goal_RefinesKeyword_5_4_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getRefinesKeyword_5_4_0());
		match_Goal_StakeholderKeyword_5_6_0_q = new TokenAlias(false, true, grammarAccess.getGoalAccess().getStakeholderKeyword_5_6_0());
		match_Goal___ConflictsKeyword_5_5_0_WithKeyword_5_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getConflictsKeyword_5_5_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getWithKeyword_5_5_1()));
		match_Goal___SeeKeyword_5_7_0_DocumentKeyword_5_7_1_RequirementKeyword_5_7_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_7_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getDocumentKeyword_5_7_1()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getRequirementKeyword_5_7_2()));
		match_Goal___SeeKeyword_5_8_0_DocumentKeyword_5_8_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getGoalAccess().getSeeKeyword_5_8_0()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getDocumentKeyword_5_8_1()));
		match_Requirement_CategoryKeyword_5_0_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getCategoryKeyword_5_0_0());
		match_Requirement_IssuesKeyword_5_13_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getIssuesKeyword_5_13_0());
		match_Requirement_RefinesKeyword_5_8_0_q = new TokenAlias(false, true, grammarAccess.getRequirementAccess().getRefinesKeyword_5_8_0());
		match_Requirement___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_GoalKeyword_5_10_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_10_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getDocumentKeyword_5_10_1()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getGoalKeyword_5_10_2()));
		match_Requirement___SeeKeyword_5_11_0_DocumentKeyword_5_11_1_RequirementKeyword_5_11_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_11_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getDocumentKeyword_5_11_1()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getRequirementKeyword_5_11_2()));
		match_Requirement___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_12_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getDocumentKeyword_5_12_1()));
		match_Requirement___SeeKeyword_5_9_0_GoalKeyword_5_9_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRequirementAccess().getSeeKeyword_5_9_0()), new TokenAlias(false, false, grammarAccess.getRequirementAccess().getGoalKeyword_5_9_1()));
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Goal_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_Goal_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_IssuesKeyword_5_9_0_q.equals(syntax))
				emit_Goal_IssuesKeyword_5_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_RefinesKeyword_5_4_0_q.equals(syntax))
				emit_Goal_RefinesKeyword_5_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_StakeholderKeyword_5_6_0_q.equals(syntax))
				emit_Goal_StakeholderKeyword_5_6_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___ConflictsKeyword_5_5_0_WithKeyword_5_5_1__q.equals(syntax))
				emit_Goal___ConflictsKeyword_5_5_0_WithKeyword_5_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___SeeKeyword_5_7_0_DocumentKeyword_5_7_1_RequirementKeyword_5_7_2__q.equals(syntax))
				emit_Goal___SeeKeyword_5_7_0_DocumentKeyword_5_7_1_RequirementKeyword_5_7_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal___SeeKeyword_5_8_0_DocumentKeyword_5_8_1__q.equals(syntax))
				emit_Goal___SeeKeyword_5_8_0_DocumentKeyword_5_8_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_CategoryKeyword_5_0_0_q.equals(syntax))
				emit_Requirement_CategoryKeyword_5_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_IssuesKeyword_5_13_0_q.equals(syntax))
				emit_Requirement_IssuesKeyword_5_13_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement_RefinesKeyword_5_8_0_q.equals(syntax))
				emit_Requirement_RefinesKeyword_5_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_GoalKeyword_5_10_2__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_GoalKeyword_5_10_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_11_0_DocumentKeyword_5_11_1_RequirementKeyword_5_11_2__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_11_0_DocumentKeyword_5_11_1_RequirementKeyword_5_11_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Requirement___SeeKeyword_5_9_0_GoalKeyword_5_9_1__q.equals(syntax))
				emit_Requirement___SeeKeyword_5_9_0_GoalKeyword_5_9_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XImportDeclaration_SemicolonKeyword_2_q.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'category'?
	 */
	protected void emit_Goal_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_Goal_IssuesKeyword_5_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'refines'?
	 */
	protected void emit_Goal_RefinesKeyword_5_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'stakeholder'?
	 */
	protected void emit_Goal_StakeholderKeyword_5_6_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('conflicts' 'with')?
	 */
	protected void emit_Goal___ConflictsKeyword_5_5_0_WithKeyword_5_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('see' 'document' 'requirement')?
	 */
	protected void emit_Goal___SeeKeyword_5_7_0_DocumentKeyword_5_7_1_RequirementKeyword_5_7_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('see' 'document')?
	 */
	protected void emit_Goal___SeeKeyword_5_8_0_DocumentKeyword_5_8_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'category'?
	 */
	protected void emit_Requirement_CategoryKeyword_5_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_Requirement_IssuesKeyword_5_13_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'refines'?
	 */
	protected void emit_Requirement_RefinesKeyword_5_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('see' 'document' 'goal')?
	 */
	protected void emit_Requirement___SeeKeyword_5_10_0_DocumentKeyword_5_10_1_GoalKeyword_5_10_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('see' 'document' 'requirement')?
	 */
	protected void emit_Requirement___SeeKeyword_5_11_0_DocumentKeyword_5_11_1_RequirementKeyword_5_11_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('see' 'document')?
	 */
	protected void emit_Requirement___SeeKeyword_5_12_0_DocumentKeyword_5_12_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('see' 'goal')?
	 */
	protected void emit_Requirement___SeeKeyword_5_9_0_GoalKeyword_5_9_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
