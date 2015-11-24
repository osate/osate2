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
package org.osate.verify.serializer;

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
import org.osate.verify.services.VerifyGrammarAccess;

@SuppressWarnings("all")
public class VerifySyntacticSequencer extends AbstractSyntacticSequencer {

	protected VerifyGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_Claim_ActivitiesKeyword_5_0_0_a;
	protected AbstractElementAlias match_Claim_ActivitiesKeyword_5_0_0_p;
	protected AbstractElementAlias match_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_4_0__q;
	protected AbstractElementAlias match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p;
	protected AbstractElementAlias match_VerificationActivity___PropertyKeyword_10_0_ValuesKeyword_10_1_LeftParenthesisKeyword_10_2_RightParenthesisKeyword_10_4__q;
	protected AbstractElementAlias match_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q__q;
	protected AbstractElementAlias match_VerificationMethod___MethodKeyword_5_4_0_TypeKeyword_5_4_1__q;
	protected AbstractElementAlias match_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q;
	protected AbstractElementAlias match_VerificationMethod___QualityKeyword_5_5_0_AttributeKeyword_5_5_1__q;
	protected AbstractElementAlias match_VerificationMethod___UserKeyword_5_6_0_SelectionKeyword_5_6_1__q;
	protected AbstractElementAlias match_VerificationPlan_IssuesKeyword_7_3_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (VerifyGrammarAccess) access;
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_Claim_ActivitiesKeyword_5_0_0_a = new TokenAlias(true, true, grammarAccess.getClaimAccess().getActivitiesKeyword_5_0_0());
		match_Claim_ActivitiesKeyword_5_0_0_p = new TokenAlias(true, false, grammarAccess.getClaimAccess().getActivitiesKeyword_5_0_0());
		match_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_4_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getClaimAccess().getActivitiesKeyword_5_0_0()), new TokenAlias(false, false, grammarAccess.getClaimAccess().getIssuesKeyword_5_4_0()));
		match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getCompositeEvidenceExprAccess().getLeftParenthesisKeyword_0_0());
		match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getCompositeEvidenceExprAccess().getLeftParenthesisKeyword_0_0());
		match_VerificationActivity___PropertyKeyword_10_0_ValuesKeyword_10_1_LeftParenthesisKeyword_10_2_RightParenthesisKeyword_10_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getPropertyKeyword_10_0()), new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getValuesKeyword_10_1()), new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getLeftParenthesisKeyword_10_2()), new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getRightParenthesisKeyword_10_4()));
		match_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_2()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getPropertiesKeyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_3_1()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_3_3())));
		match_VerificationMethod___MethodKeyword_5_4_0_TypeKeyword_5_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getMethodKeyword_5_4_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getTypeKeyword_5_4_1()));
		match_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getPropertiesKeyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_3_1()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_3_3()));
		match_VerificationMethod___QualityKeyword_5_5_0_AttributeKeyword_5_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getQualityKeyword_5_5_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getAttributeKeyword_5_5_1()));
		match_VerificationMethod___UserKeyword_5_6_0_SelectionKeyword_5_6_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getUserKeyword_5_6_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getSelectionKeyword_5_6_1()));
		match_VerificationPlan_IssuesKeyword_7_3_0_q = new TokenAlias(false, true, grammarAccess.getVerificationPlanAccess().getIssuesKeyword_7_3_0());
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
			else if(match_Claim_ActivitiesKeyword_5_0_0_a.equals(syntax))
				emit_Claim_ActivitiesKeyword_5_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Claim_ActivitiesKeyword_5_0_0_p.equals(syntax))
				emit_Claim_ActivitiesKeyword_5_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_4_0__q.equals(syntax))
				emit_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_4_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationActivity___PropertyKeyword_10_0_ValuesKeyword_10_1_LeftParenthesisKeyword_10_2_RightParenthesisKeyword_10_4__q.equals(syntax))
				emit_VerificationActivity___PropertyKeyword_10_0_ValuesKeyword_10_1_LeftParenthesisKeyword_10_2_RightParenthesisKeyword_10_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q__q.equals(syntax))
				emit_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationMethod___MethodKeyword_5_4_0_TypeKeyword_5_4_1__q.equals(syntax))
				emit_VerificationMethod___MethodKeyword_5_4_0_TypeKeyword_5_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q.equals(syntax))
				emit_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationMethod___QualityKeyword_5_5_0_AttributeKeyword_5_5_1__q.equals(syntax))
				emit_VerificationMethod___QualityKeyword_5_5_0_AttributeKeyword_5_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationMethod___UserKeyword_5_6_0_SelectionKeyword_5_6_1__q.equals(syntax))
				emit_VerificationMethod___UserKeyword_5_6_0_SelectionKeyword_5_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationPlan_IssuesKeyword_7_3_0_q.equals(syntax))
				emit_VerificationPlan_IssuesKeyword_7_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     'activities'*
	 *
	 * This ambiguous syntax occurs at:
	 *     activities+=VerificationActivity (ambiguity) ']' (rule end)
	 *     activities+=VerificationActivity (ambiguity) 'assert' assert=ArgumentExpr
	 *     activities+=VerificationActivity (ambiguity) 'issues' issues+=STRING
	 *     activities+=VerificationActivity (ambiguity) activities+=VerificationActivity
	 *     activities+=VerificationActivity (ambiguity) rationale=Rationale
	 *     activities+=VerificationActivity (ambiguity) subclaim+=Claim
	 *     assert=ArgumentExpr (ambiguity) ']' (rule end)
	 *     assert=ArgumentExpr (ambiguity) 'assert' assert=ArgumentExpr
	 *     assert=ArgumentExpr (ambiguity) 'issues' issues+=STRING
	 *     assert=ArgumentExpr (ambiguity) rationale=Rationale
	 *     assert=ArgumentExpr (ambiguity) subclaim+=Claim
	 *     issues+=STRING (ambiguity) ']' (rule end)
	 *     issues+=STRING (ambiguity) 'assert' assert=ArgumentExpr
	 *     issues+=STRING (ambiguity) rationale=Rationale
	 *     issues+=STRING (ambiguity) subclaim+=Claim
	 *     rationale=Rationale (ambiguity) ']' (rule end)
	 *     rationale=Rationale (ambiguity) 'assert' assert=ArgumentExpr
	 *     rationale=Rationale (ambiguity) 'issues' issues+=STRING
	 *     rationale=Rationale (ambiguity) rationale=Rationale
	 *     rationale=Rationale (ambiguity) subclaim+=Claim
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) ']' (rule end)
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) 'assert' assert=ArgumentExpr
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) 'issues' issues+=STRING
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) rationale=Rationale
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) subclaim+=Claim
	 *     subclaim+=Claim (ambiguity) ']' (rule end)
	 *     subclaim+=Claim (ambiguity) 'assert' assert=ArgumentExpr
	 *     subclaim+=Claim (ambiguity) 'issues' issues+=STRING
	 *     subclaim+=Claim (ambiguity) rationale=Rationale
	 *     subclaim+=Claim (ambiguity) subclaim+=Claim
	 *     title=STRING '[' (ambiguity) ']' (rule end)
	 *     title=STRING '[' (ambiguity) 'assert' assert=ArgumentExpr
	 *     title=STRING '[' (ambiguity) 'issues' issues+=STRING
	 *     title=STRING '[' (ambiguity) rationale=Rationale
	 *     title=STRING '[' (ambiguity) subclaim+=Claim
	 *     weight=Number ')' '[' (ambiguity) ']' (rule end)
	 *     weight=Number ')' '[' (ambiguity) 'assert' assert=ArgumentExpr
	 *     weight=Number ')' '[' (ambiguity) 'issues' issues+=STRING
	 *     weight=Number ')' '[' (ambiguity) rationale=Rationale
	 *     weight=Number ')' '[' (ambiguity) subclaim+=Claim
	 */
	protected void emit_Claim_ActivitiesKeyword_5_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'activities'+
	 *
	 * This ambiguous syntax occurs at:
	 *     assert=ArgumentExpr (ambiguity) activities+=VerificationActivity
	 *     issues+=STRING (ambiguity) activities+=VerificationActivity
	 *     rationale=Rationale (ambiguity) activities+=VerificationActivity
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) activities+=VerificationActivity
	 *     subclaim+=Claim (ambiguity) activities+=VerificationActivity
	 *     title=STRING '[' (ambiguity) activities+=VerificationActivity
	 *     weight=Number ')' '[' (ambiguity) activities+=VerificationActivity
	 */
	protected void emit_Claim_ActivitiesKeyword_5_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('activities'* 'issues')?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_4_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'all' '[' elements+=ThenEvidenceExpr
	 *     (rule start) (ambiguity) verification=[VerificationActivity|ID]
	 *     (rule start) (ambiguity) {ElseExpr.left=}
	 *     (rule start) (ambiguity) {ThenExpr.left=}
	 */
	protected void emit_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) verification=[VerificationActivity|ID]
	 *     (rule start) (ambiguity) {ElseExpr.left=}
	 *     (rule start) (ambiguity) {ThenExpr.left=}
	 */
	protected void emit_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('property' 'values' '(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     method=[VerificationMethod|QualifiedName] '(' ')' (ambiguity) 'timeout' timeout=INT
	 *     method=[VerificationMethod|QualifiedName] '(' ')' (ambiguity) (rule end)
	 *     parameters+=[ValDeclaration|ID] ')' (ambiguity) 'timeout' timeout=INT
	 *     parameters+=[ValDeclaration|ID] ')' (ambiguity) (rule end)
	 */
	protected void emit_VerificationActivity___PropertyKeyword_10_0_ValuesKeyword_10_1_LeftParenthesisKeyword_10_2_RightParenthesisKeyword_10_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')' ('properties' '(' ')')?)?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) ':' title=STRING
	 *     name=ID (ambiguity) '[' ']' (rule end)
	 *     name=ID (ambiguity) '[' 'method' 'type' methodType+=[MethodType|ID]
	 *     name=ID (ambiguity) '[' 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     name=ID (ambiguity) '[' 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     name=ID (ambiguity) '[' description=Description
	 *     name=ID (ambiguity) '[' methodKind=MethodKind
	 *     name=ID (ambiguity) '[' precondition=VerificationPrecondition
	 *     name=ID (ambiguity) '[' validation=VerificationValidation
	 */
	protected void emit_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('method' 'type')?
	 *
	 * This ambiguous syntax occurs at:
	 *     methodType+=[MethodType|ID] (ambiguity) methodType+=[MethodType|ID]
	 */
	protected void emit_VerificationMethod___MethodKeyword_5_4_0_TypeKeyword_5_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('properties' '(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID '(' ')' (ambiguity) isPredicate?='boolean'
	 *     name=ID '(' ')' (ambiguity) isResultReport?='report'
	 *     params+=FormalParameter ')' (ambiguity) ':' title=STRING
	 *     params+=FormalParameter ')' (ambiguity) '[' ']' (rule end)
	 *     params+=FormalParameter ')' (ambiguity) '[' 'method' 'type' methodType+=[MethodType|ID]
	 *     params+=FormalParameter ')' (ambiguity) '[' 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     params+=FormalParameter ')' (ambiguity) '[' 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     params+=FormalParameter ')' (ambiguity) '[' description=Description
	 *     params+=FormalParameter ')' (ambiguity) '[' methodKind=MethodKind
	 *     params+=FormalParameter ')' (ambiguity) '[' precondition=VerificationPrecondition
	 *     params+=FormalParameter ')' (ambiguity) '[' validation=VerificationValidation
	 *     params+=FormalParameter ')' (ambiguity) isPredicate?='boolean'
	 *     params+=FormalParameter ')' (ambiguity) isResultReport?='report'
	 */
	protected void emit_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('quality' 'attribute')?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) qualityAttribute+=[QualityAttribute|ID]
	 */
	protected void emit_VerificationMethod___QualityKeyword_5_5_0_AttributeKeyword_5_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('user' 'selection')?
	 *
	 * This ambiguous syntax occurs at:
	 *     userSelection+=[UserSelection|ID] (ambiguity) userSelection+=[UserSelection|ID]
	 */
	protected void emit_VerificationMethod___UserKeyword_5_6_0_SelectionKeyword_5_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     issues+=STRING (ambiguity) issues+=STRING
	 */
	protected void emit_VerificationPlan_IssuesKeyword_7_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
