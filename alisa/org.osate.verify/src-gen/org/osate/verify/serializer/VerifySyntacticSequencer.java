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
	protected AbstractElementAlias match_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_5_0__q;
	protected AbstractElementAlias match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p;
	protected AbstractElementAlias match_JavaMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q;
	protected AbstractElementAlias match_VerificationActivity_CategoryKeyword_9_1_0_0_q;
	protected AbstractElementAlias match_VerificationActivity___LeftSquareBracketKeyword_9_0_RightSquareBracketKeyword_9_2__q;
	protected AbstractElementAlias match_VerificationActivity___PropertyKeyword_8_0_ValuesKeyword_8_1_LeftParenthesisKeyword_8_2_RightParenthesisKeyword_8_4__q;
	protected AbstractElementAlias match_VerificationMethod_CategoryKeyword_6_4_0_q;
	protected AbstractElementAlias match_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q__q;
	protected AbstractElementAlias match_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q;
	protected AbstractElementAlias match_VerificationMethod___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q;
	protected AbstractElementAlias match_VerificationPlan_IssuesKeyword_7_3_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (VerifyGrammarAccess) access;
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_Claim_ActivitiesKeyword_5_0_0_a = new TokenAlias(true, true, grammarAccess.getClaimAccess().getActivitiesKeyword_5_0_0());
		match_Claim_ActivitiesKeyword_5_0_0_p = new TokenAlias(true, false, grammarAccess.getClaimAccess().getActivitiesKeyword_5_0_0());
		match_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_5_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getClaimAccess().getActivitiesKeyword_5_0_0()), new TokenAlias(false, false, grammarAccess.getClaimAccess().getIssuesKeyword_5_5_0()));
		match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getCompositeEvidenceExprAccess().getLeftParenthesisKeyword_0_0());
		match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getCompositeEvidenceExprAccess().getLeftParenthesisKeyword_0_0());
		match_JavaMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getJavaMethodAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getJavaMethodAccess().getRightParenthesisKeyword_2_2()));
		match_VerificationActivity_CategoryKeyword_9_1_0_0_q = new TokenAlias(false, true, grammarAccess.getVerificationActivityAccess().getCategoryKeyword_9_1_0_0());
		match_VerificationActivity___LeftSquareBracketKeyword_9_0_RightSquareBracketKeyword_9_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getLeftSquareBracketKeyword_9_0()), new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getRightSquareBracketKeyword_9_2()));
		match_VerificationActivity___PropertyKeyword_8_0_ValuesKeyword_8_1_LeftParenthesisKeyword_8_2_RightParenthesisKeyword_8_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getPropertyKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getValuesKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getLeftParenthesisKeyword_8_2()), new TokenAlias(false, false, grammarAccess.getVerificationActivityAccess().getRightParenthesisKeyword_8_4()));
		match_VerificationMethod_CategoryKeyword_6_4_0_q = new TokenAlias(false, true, grammarAccess.getVerificationMethodAccess().getCategoryKeyword_6_4_0());
		match_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_2()), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getPropertiesKeyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_3_1()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_3_3())), new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getReturnsKeyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_4_1()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_4_3())));
		match_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getPropertiesKeyword_2_3_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_3_1()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_3_3()));
		match_VerificationMethod___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getReturnsKeyword_2_4_0()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getLeftParenthesisKeyword_2_4_1()), new TokenAlias(false, false, grammarAccess.getVerificationMethodAccess().getRightParenthesisKeyword_2_4_3()));
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
			if (match_AParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_AParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_AParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Claim_ActivitiesKeyword_5_0_0_a.equals(syntax))
				emit_Claim_ActivitiesKeyword_5_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Claim_ActivitiesKeyword_5_0_0_p.equals(syntax))
				emit_Claim_ActivitiesKeyword_5_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_5_0__q.equals(syntax))
				emit_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_5_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_CompositeEvidenceExpr_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_JavaMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q.equals(syntax))
				emit_JavaMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationActivity_CategoryKeyword_9_1_0_0_q.equals(syntax))
				emit_VerificationActivity_CategoryKeyword_9_1_0_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationActivity___LeftSquareBracketKeyword_9_0_RightSquareBracketKeyword_9_2__q.equals(syntax))
				emit_VerificationActivity___LeftSquareBracketKeyword_9_0_RightSquareBracketKeyword_9_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationActivity___PropertyKeyword_8_0_ValuesKeyword_8_1_LeftParenthesisKeyword_8_2_RightParenthesisKeyword_8_4__q.equals(syntax))
				emit_VerificationActivity___PropertyKeyword_8_0_ValuesKeyword_8_1_LeftParenthesisKeyword_8_2_RightParenthesisKeyword_8_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationMethod_CategoryKeyword_6_4_0_q.equals(syntax))
				emit_VerificationMethod_CategoryKeyword_6_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q__q.equals(syntax))
				emit_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q.equals(syntax))
				emit_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationMethod___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q.equals(syntax))
				emit_VerificationMethod___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationPlan_IssuesKeyword_7_3_0_q.equals(syntax))
				emit_VerificationPlan_IssuesKeyword_7_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     'activities'*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'claim' '[' (ambiguity) ']' (rule start)
	 *     (rule start) 'claim' '[' (ambiguity) 'assert' assert=ArgumentExpr
	 *     (rule start) 'claim' '[' (ambiguity) 'issues' issues+=STRING
	 *     (rule start) 'claim' '[' (ambiguity) 'weight' weight=INT
	 *     (rule start) 'claim' '[' (ambiguity) rationale=Rationale
	 *     (rule start) 'claim' '[' (ambiguity) subclaim+=Claim
	 *     activities+=VerificationActivity (ambiguity) ']' (rule end)
	 *     activities+=VerificationActivity (ambiguity) 'assert' assert=ArgumentExpr
	 *     activities+=VerificationActivity (ambiguity) 'issues' issues+=STRING
	 *     activities+=VerificationActivity (ambiguity) 'weight' weight=INT
	 *     activities+=VerificationActivity (ambiguity) activities+=VerificationActivity
	 *     activities+=VerificationActivity (ambiguity) rationale=Rationale
	 *     activities+=VerificationActivity (ambiguity) subclaim+=Claim
	 *     assert=ArgumentExpr (ambiguity) ']' (rule end)
	 *     assert=ArgumentExpr (ambiguity) 'assert' assert=ArgumentExpr
	 *     assert=ArgumentExpr (ambiguity) 'issues' issues+=STRING
	 *     assert=ArgumentExpr (ambiguity) 'weight' weight=INT
	 *     assert=ArgumentExpr (ambiguity) rationale=Rationale
	 *     assert=ArgumentExpr (ambiguity) subclaim+=Claim
	 *     issues+=STRING (ambiguity) ']' (rule end)
	 *     issues+=STRING (ambiguity) 'assert' assert=ArgumentExpr
	 *     issues+=STRING (ambiguity) 'weight' weight=INT
	 *     issues+=STRING (ambiguity) rationale=Rationale
	 *     issues+=STRING (ambiguity) subclaim+=Claim
	 *     rationale=Rationale (ambiguity) ']' (rule end)
	 *     rationale=Rationale (ambiguity) 'assert' assert=ArgumentExpr
	 *     rationale=Rationale (ambiguity) 'issues' issues+=STRING
	 *     rationale=Rationale (ambiguity) 'weight' weight=INT
	 *     rationale=Rationale (ambiguity) rationale=Rationale
	 *     rationale=Rationale (ambiguity) subclaim+=Claim
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) ']' (rule end)
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) 'assert' assert=ArgumentExpr
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) 'issues' issues+=STRING
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) 'weight' weight=INT
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) rationale=Rationale
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) subclaim+=Claim
	 *     subclaim+=Claim (ambiguity) ']' (rule end)
	 *     subclaim+=Claim (ambiguity) 'assert' assert=ArgumentExpr
	 *     subclaim+=Claim (ambiguity) 'issues' issues+=STRING
	 *     subclaim+=Claim (ambiguity) 'weight' weight=INT
	 *     subclaim+=Claim (ambiguity) rationale=Rationale
	 *     subclaim+=Claim (ambiguity) subclaim+=Claim
	 *     title=STRING '[' (ambiguity) ']' (rule end)
	 *     title=STRING '[' (ambiguity) 'assert' assert=ArgumentExpr
	 *     title=STRING '[' (ambiguity) 'issues' issues+=STRING
	 *     title=STRING '[' (ambiguity) 'weight' weight=INT
	 *     title=STRING '[' (ambiguity) rationale=Rationale
	 *     title=STRING '[' (ambiguity) subclaim+=Claim
	 *     weight=INT (ambiguity) ']' (rule end)
	 *     weight=INT (ambiguity) 'assert' assert=ArgumentExpr
	 *     weight=INT (ambiguity) 'issues' issues+=STRING
	 *     weight=INT (ambiguity) 'weight' weight=INT
	 *     weight=INT (ambiguity) rationale=Rationale
	 *     weight=INT (ambiguity) subclaim+=Claim
	 */
	protected void emit_Claim_ActivitiesKeyword_5_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'activities'+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'claim' '[' (ambiguity) activities+=VerificationActivity
	 *     assert=ArgumentExpr (ambiguity) activities+=VerificationActivity
	 *     issues+=STRING (ambiguity) activities+=VerificationActivity
	 *     rationale=Rationale (ambiguity) activities+=VerificationActivity
	 *     requirement=[Requirement|QualifiedName] '[' (ambiguity) activities+=VerificationActivity
	 *     subclaim+=Claim (ambiguity) activities+=VerificationActivity
	 *     title=STRING '[' (ambiguity) activities+=VerificationActivity
	 *     weight=INT (ambiguity) activities+=VerificationActivity
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
	protected void emit_Claim___ActivitiesKeyword_5_0_0_a_IssuesKeyword_5_5_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     methodPath=QualifiedName (ambiguity) (rule end)
	 */
	protected void emit_JavaMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|QualifiedName] (ambiguity) category+=[Category|QualifiedName]
	 */
	protected void emit_VerificationActivity_CategoryKeyword_9_1_0_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     actuals+=AExpression ')' ('property' 'values' '(' ')')? (ambiguity) (rule end)
	 *     method=[VerificationMethod|QualifiedName] '(' ')' ('property' 'values' '(' ')')? (ambiguity) (rule end)
	 *     propertyValues+=AExpression ')' (ambiguity) (rule end)
	 */
	protected void emit_VerificationActivity___LeftSquareBracketKeyword_9_0_RightSquareBracketKeyword_9_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('property' 'values' '(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     actuals+=AExpression ')' (ambiguity) '[' 'category' category+=[Category|QualifiedName]
	 *     actuals+=AExpression ')' (ambiguity) '[' 'timeout' timeout=AIntegerTerm
	 *     actuals+=AExpression ')' (ambiguity) '[' 'weight' weight=INT
	 *     actuals+=AExpression ')' (ambiguity) ('[' ']')? (rule end)
	 *     method=[VerificationMethod|QualifiedName] '(' ')' (ambiguity) '[' 'category' category+=[Category|QualifiedName]
	 *     method=[VerificationMethod|QualifiedName] '(' ')' (ambiguity) '[' 'timeout' timeout=AIntegerTerm
	 *     method=[VerificationMethod|QualifiedName] '(' ')' (ambiguity) '[' 'weight' weight=INT
	 *     method=[VerificationMethod|QualifiedName] '(' ')' (ambiguity) ('[' ']')? (rule end)
	 */
	protected void emit_VerificationActivity___PropertyKeyword_8_0_ValuesKeyword_8_1_LeftParenthesisKeyword_8_2_RightParenthesisKeyword_8_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'category'?
	 *
	 * This ambiguous syntax occurs at:
	 *     category+=[Category|QualifiedName] (ambiguity) category+=[Category|QualifiedName]
	 */
	protected void emit_VerificationMethod_CategoryKeyword_6_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')' ('properties' '(' ')')? ('returns' '(' ')')?)?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ID (ambiguity) ':' title=STRING
	 *     name=ID (ambiguity) '[' ']' (rule end)
	 *     name=ID (ambiguity) '[' 'category' category+=[Category|QualifiedName]
	 *     name=ID (ambiguity) '[' description=Description
	 *     name=ID (ambiguity) '[' methodKind=MethodKind
	 *     name=ID (ambiguity) '[' precondition=VerificationPrecondition
	 *     name=ID (ambiguity) '[' validation=VerificationValidation
	 *     name=ID (ambiguity) 'for' componentCategory+=ComponentCategory
	 *     name=ID (ambiguity) 'for' target=[ComponentClassifier|AadlClassifierReference]
	 */
	protected void emit_VerificationMethod___LeftParenthesisKeyword_2_0_RightParenthesisKeyword_2_2___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('properties' '(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     formals+=FormalParameter ')' (ambiguity) 'returns' '(' results+=FormalParameter
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? ':' title=STRING
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? '[' ']' (rule end)
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? '[' 'category' category+=[Category|QualifiedName]
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? '[' description=Description
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? '[' methodKind=MethodKind
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? '[' precondition=VerificationPrecondition
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? '[' validation=VerificationValidation
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? 'for' componentCategory+=ComponentCategory
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? 'for' target=[ComponentClassifier|AadlClassifierReference]
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? isPredicate?='boolean'
	 *     formals+=FormalParameter ')' (ambiguity) ('returns' '(' ')')? isResultReport?='report'
	 *     name=ID '(' ')' (ambiguity) 'returns' '(' results+=FormalParameter
	 *     name=ID '(' ')' (ambiguity) ('returns' '(' ')')? isPredicate?='boolean'
	 *     name=ID '(' ')' (ambiguity) ('returns' '(' ')')? isResultReport?='report'
	 *     targetType=TargetType ')' (ambiguity) 'returns' '(' results+=FormalParameter
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? ':' title=STRING
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? '[' ']' (rule end)
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? '[' 'category' category+=[Category|QualifiedName]
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? '[' description=Description
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? '[' methodKind=MethodKind
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? '[' precondition=VerificationPrecondition
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? '[' validation=VerificationValidation
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? 'for' componentCategory+=ComponentCategory
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? 'for' target=[ComponentClassifier|AadlClassifierReference]
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? isPredicate?='boolean'
	 *     targetType=TargetType ')' (ambiguity) ('returns' '(' ')')? isResultReport?='report'
	 */
	protected void emit_VerificationMethod___PropertiesKeyword_2_3_0_LeftParenthesisKeyword_2_3_1_RightParenthesisKeyword_2_3_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('returns' '(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) ':' title=STRING
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) '[' ']' (rule end)
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) '[' 'category' category+=[Category|QualifiedName]
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) '[' description=Description
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) '[' methodKind=MethodKind
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) '[' precondition=VerificationPrecondition
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) '[' validation=VerificationValidation
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) 'for' componentCategory+=ComponentCategory
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) 'for' target=[ComponentClassifier|AadlClassifierReference]
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) isPredicate?='boolean'
	 *     formals+=FormalParameter ')' ('properties' '(' ')')? (ambiguity) isResultReport?='report'
	 *     name=ID '(' ')' ('properties' '(' ')')? (ambiguity) isPredicate?='boolean'
	 *     name=ID '(' ')' ('properties' '(' ')')? (ambiguity) isResultReport?='report'
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) ':' title=STRING
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) '[' ']' (rule end)
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) '[' 'category' category+=[Category|QualifiedName]
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) '[' description=Description
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) '[' methodKind=MethodKind
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) '[' precondition=VerificationPrecondition
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) '[' validation=VerificationValidation
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) 'for' componentCategory+=ComponentCategory
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) 'for' target=[ComponentClassifier|AadlClassifierReference]
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) isPredicate?='boolean'
	 *     properties+=[Property|AADLPROPERTYREFERENCE] ')' (ambiguity) isResultReport?='report'
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) ':' title=STRING
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) '[' ']' (rule end)
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) '[' 'category' category+=[Category|QualifiedName]
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) '[' description=Description
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) '[' methodKind=MethodKind
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) '[' precondition=VerificationPrecondition
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) '[' validation=VerificationValidation
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) 'for' componentCategory+=ComponentCategory
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) 'for' target=[ComponentClassifier|AadlClassifierReference]
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) isPredicate?='boolean'
	 *     targetType=TargetType ')' ('properties' '(' ')')? (ambiguity) isResultReport?='report'
	 */
	protected void emit_VerificationMethod___ReturnsKeyword_2_4_0_LeftParenthesisKeyword_2_4_1_RightParenthesisKeyword_2_4_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
