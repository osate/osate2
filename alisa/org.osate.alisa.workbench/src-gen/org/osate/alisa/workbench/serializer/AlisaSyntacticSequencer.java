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
package org.osate.alisa.workbench.serializer;

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
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

@SuppressWarnings("all")
public class AlisaSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AlisaGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_AssurancePlan_AssureKeyword_7_1_0_q;
	protected AbstractElementAlias match_AssurancePlan_IssuesKeyword_7_4_0_q;
	protected AbstractElementAlias match_AssurancePlan___AssumeKeyword_7_3_0_SubsystemKeyword_7_3_1__q;
	protected AbstractElementAlias match_AssurancePlan___AssureKeyword_7_2_0_0_SubsystemKeyword_7_2_0_1__q;
	protected AbstractElementAlias match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p;
	protected AbstractElementAlias match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p;
	protected AbstractElementAlias match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p;
	protected AbstractElementAlias match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p_DevelopmentKeyword_8_1_4_0_0_PhaseKeyword_8_1_4_0_1__q;
	protected AbstractElementAlias match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p_RequirementKeyword_8_1_0_2_0_TypeKeyword_8_1_0_2_1__q;
	protected AbstractElementAlias match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_IssuesKeyword_8_2_0__q;
	protected AbstractElementAlias match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_MethodKeyword_8_1_1_0_TypeKeyword_8_1_1_1__q;
	protected AbstractElementAlias match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_QualityKeyword_8_1_3_0_AttributeKeyword_8_1_3_1__q;
	protected AbstractElementAlias match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_UserKeyword_8_1_2_0_SelectionKeyword_8_1_2_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlisaGrammarAccess) access;
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AssurancePlan_AssureKeyword_7_1_0_q = new TokenAlias(false, true, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_1_0());
		match_AssurancePlan_IssuesKeyword_7_4_0_q = new TokenAlias(false, true, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_4_0());
		match_AssurancePlan___AssumeKeyword_7_3_0_SubsystemKeyword_7_3_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_3_0()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_3_1()));
		match_AssurancePlan___AssureKeyword_7_2_0_0_SubsystemKeyword_7_2_0_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getAssureKeyword_7_2_0_0()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getSubsystemKeyword_7_2_0_1()));
		match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1())));
		match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p = new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1()));
		match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p = new GroupAlias(true, false, new TokenAlias(false, true, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1())));
		match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p_DevelopmentKeyword_8_1_4_0_0_PhaseKeyword_8_1_4_0_1__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1()))), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getDevelopmentKeyword_8_1_4_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getPhaseKeyword_8_1_4_0_1()));
		match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p_RequirementKeyword_8_1_0_2_0_TypeKeyword_8_1_0_2_1__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1())), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getRequirementKeyword_8_1_0_2_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getTypeKeyword_8_1_0_2_1()));
		match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_IssuesKeyword_8_2_0__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(false, true, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1()))), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_8_2_0()));
		match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_MethodKeyword_8_1_1_0_TypeKeyword_8_1_1_1__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(false, true, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1()))), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getMethodKeyword_8_1_1_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getTypeKeyword_8_1_1_1()));
		match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_QualityKeyword_8_1_3_0_AttributeKeyword_8_1_3_1__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(false, true, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1()))), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getQualityKeyword_8_1_3_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getAttributeKeyword_8_1_3_1()));
		match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_UserKeyword_8_1_2_0_SelectionKeyword_8_1_2_1__q = new GroupAlias(false, true, new GroupAlias(true, false, new TokenAlias(false, true, grammarAccess.getAssuranceTaskAccess().getRightSquareBracketKeyword_8_1_4_1()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_8_1_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getLeftSquareBracketKeyword_8_1_0_1()))), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getUserKeyword_8_1_2_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getSelectionKeyword_8_1_2_1()));
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
			else if(match_AssurancePlan_AssureKeyword_7_1_0_q.equals(syntax))
				emit_AssurancePlan_AssureKeyword_7_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan_IssuesKeyword_7_4_0_q.equals(syntax))
				emit_AssurancePlan_IssuesKeyword_7_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan___AssumeKeyword_7_3_0_SubsystemKeyword_7_3_1__q.equals(syntax))
				emit_AssurancePlan___AssumeKeyword_7_3_0_SubsystemKeyword_7_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan___AssureKeyword_7_2_0_0_SubsystemKeyword_7_2_0_1__q.equals(syntax))
				emit_AssurancePlan___AssureKeyword_7_2_0_0_SubsystemKeyword_7_2_0_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p.equals(syntax))
				emit_AssuranceTask___RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p.equals(syntax))
				emit_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p.equals(syntax))
				emit_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p_DevelopmentKeyword_8_1_4_0_0_PhaseKeyword_8_1_4_0_1__q.equals(syntax))
				emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p_DevelopmentKeyword_8_1_4_0_0_PhaseKeyword_8_1_4_0_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p_RequirementKeyword_8_1_0_2_0_TypeKeyword_8_1_0_2_1__q.equals(syntax))
				emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p_RequirementKeyword_8_1_0_2_0_TypeKeyword_8_1_0_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_IssuesKeyword_8_2_0__q.equals(syntax))
				emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_IssuesKeyword_8_2_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_MethodKeyword_8_1_1_0_TypeKeyword_8_1_1_1__q.equals(syntax))
				emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_MethodKeyword_8_1_1_0_TypeKeyword_8_1_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_QualityKeyword_8_1_3_0_AttributeKeyword_8_1_3_1__q.equals(syntax))
				emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_QualityKeyword_8_1_3_0_AttributeKeyword_8_1_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_UserKeyword_8_1_2_0_SelectionKeyword_8_1_2_1__q.equals(syntax))
				emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_UserKeyword_8_1_2_0_SelectionKeyword_8_1_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     (rule start) (ambiguity) '@' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=AExpression
	 *     (rule start) (ambiguity) feature=OpUnary
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
	 *     (rule start) (ambiguity) '@' property=[AbstractNamedValue|AADLPROPERTYREFERENCE]
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) 'null' ')' (rule start)
	 *     (rule start) (ambiguity) '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '{' elements+=AExpression
	 *     (rule start) (ambiguity) feature=OpUnary
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
	 *     'assure'?
	 *
	 * This ambiguous syntax occurs at:
	 *     assure+=[VerificationPlan|QualifiedName] (ambiguity) assure+=[VerificationPlan|QualifiedName]
	 */
	protected void emit_AssurancePlan_AssureKeyword_7_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_AssurancePlan_IssuesKeyword_7_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('assume' 'subsystem')?
	 *
	 * This ambiguous syntax occurs at:
	 *     assumeSubsystems+=[Subcomponent|ID] (ambiguity) assumeSubsystems+=[Subcomponent|ID]
	 */
	protected void emit_AssurancePlan___AssumeKeyword_7_3_0_SubsystemKeyword_7_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('assure' 'subsystem')?
	 *
	 * This ambiguous syntax occurs at:
	 *     assureSubsystems+=[Subcomponent|ID] (ambiguity) assureSubsystems+=[Subcomponent|ID]
	 */
	protected void emit_AssurancePlan___AssureKeyword_7_2_0_0_SubsystemKeyword_7_2_0_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']' ('filter' '[')*)+
	 *
	 * This ambiguous syntax occurs at:
	 *     anyDevelopmentPhase?='any' (ambiguity)
	 *     anyDevelopmentPhase?='any' (ambiguity) ']' (rule end)
	 *     anyDevelopmentPhase?='any' (ambiguity) 'description' description=Description
	 *     anyDevelopmentPhase?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) 'issues' issues+=STRING
	 *     anyDevelopmentPhase?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity)
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) ']' (rule end)
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'description' description=Description
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'issues' issues+=STRING
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 */
	protected void emit_AssuranceTask___RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'* 'filter' '[')+
	 *
	 * This ambiguous syntax occurs at:
	 *     anyMethodType?='any' (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     anyRequirementType?='any' (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     anyUserSelection?='any' (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     description=Description (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     issues+=STRING (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     methodType+=[MethodType|ID] (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'requirement' 'type' requirementType+=[RequirementType|ID]
	 */
	protected void emit_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'? ('filter' '[')?)+
	 *
	 * This ambiguous syntax occurs at:
	 *     anyMethodType?='any' (ambiguity) ']' (rule end)
	 *     anyMethodType?='any' (ambiguity) 'description' description=Description
	 *     anyMethodType?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyMethodType?='any' (ambiguity) 'issues' issues+=STRING
	 *     anyMethodType?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyMethodType?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyMethodType?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyQualityAttribute?='any' (ambiguity) ']' (rule end)
	 *     anyQualityAttribute?='any' (ambiguity) 'description' description=Description
	 *     anyQualityAttribute?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'issues' issues+=STRING
	 *     anyQualityAttribute?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyRequirementType?='any' (ambiguity) ']' (rule end)
	 *     anyRequirementType?='any' (ambiguity) 'description' description=Description
	 *     anyRequirementType?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyRequirementType?='any' (ambiguity) 'issues' issues+=STRING
	 *     anyRequirementType?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyRequirementType?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyRequirementType?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyUserSelection?='any' (ambiguity) ']' (rule end)
	 *     anyUserSelection?='any' (ambiguity) 'description' description=Description
	 *     anyUserSelection?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyUserSelection?='any' (ambiguity) 'issues' issues+=STRING
	 *     anyUserSelection?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyUserSelection?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyUserSelection?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) ']' (rule end)
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'description' description=Description
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'issues' issues+=STRING
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     assurancePlan=[AssurancePlan|QualifiedName] '[' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     description=Description (ambiguity) ']' (rule end)
	 *     description=Description (ambiguity) 'description' description=Description
	 *     description=Description (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     description=Description (ambiguity) 'issues' issues+=STRING
	 *     description=Description (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     description=Description (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     description=Description (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     issues+=STRING (ambiguity) ']' (rule end)
	 *     issues+=STRING (ambiguity) 'description' description=Description
	 *     issues+=STRING (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     issues+=STRING (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     issues+=STRING (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     issues+=STRING (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     methodType+=[MethodType|ID] (ambiguity) ']' (rule end)
	 *     methodType+=[MethodType|ID] (ambiguity) 'description' description=Description
	 *     methodType+=[MethodType|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     methodType+=[MethodType|ID] (ambiguity) 'issues' issues+=STRING
	 *     methodType+=[MethodType|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     methodType+=[MethodType|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) ']' (rule end)
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'description' description=Description
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'issues' issues+=STRING
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) ']' (rule end)
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'description' description=Description
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'issues' issues+=STRING
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     userSelection+=[UserSelection|ID] (ambiguity) ']' (rule end)
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'description' description=Description
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'issues' issues+=STRING
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 */
	protected void emit_AssuranceTask___RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ((']' ('filter' '[')*)+ 'development' 'phase')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) developmentPhase+=[DevelopmentPhase|ID]
	 */
	protected void emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__a__p_DevelopmentKeyword_8_1_4_0_0_PhaseKeyword_8_1_4_0_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ((']'* 'filter' '[')+ 'requirement' 'type')?
	 *
	 * This ambiguous syntax occurs at:
	 *     requirementType+=[RequirementType|ID] (ambiguity) requirementType+=[RequirementType|ID]
	 */
	protected void emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_a_FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__p_RequirementKeyword_8_1_0_2_0_TypeKeyword_8_1_0_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ((']'? ('filter' '[')?)+ 'issues')?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_IssuesKeyword_8_2_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ((']'? ('filter' '[')?)+ 'method' 'type')?
	 *
	 * This ambiguous syntax occurs at:
	 *     methodType+=[MethodType|ID] (ambiguity) methodType+=[MethodType|ID]
	 */
	protected void emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_MethodKeyword_8_1_1_0_TypeKeyword_8_1_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ((']'? ('filter' '[')?)+ 'quality' 'attribute')?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) qualityAttribute+=[QualityAttribute|ID]
	 */
	protected void emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_QualityKeyword_8_1_3_0_AttributeKeyword_8_1_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ((']'? ('filter' '[')?)+ 'user' 'selection')?
	 *
	 * This ambiguous syntax occurs at:
	 *     userSelection+=[UserSelection|ID] (ambiguity) userSelection+=[UserSelection|ID]
	 */
	protected void emit_AssuranceTask_____RightSquareBracketKeyword_8_1_4_1_q___FilterKeyword_8_1_0_0_LeftSquareBracketKeyword_8_1_0_1__q__p_UserKeyword_8_1_2_0_SelectionKeyword_8_1_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
