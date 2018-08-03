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
package org.osate.assure.serializer;

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
import org.osate.assure.services.AssureGrammarAccess;

@SuppressWarnings("all")
public class AssureSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AssureGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_AParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_PreconditionResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q;
	protected AbstractElementAlias match_PredicateResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q;
	protected AbstractElementAlias match_ResultIssue___LeftSquareBracketKeyword_4_0_RightSquareBracketKeyword_4_2__q;
	protected AbstractElementAlias match_ValidationResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q;
	protected AbstractElementAlias match_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AssureGrammarAccess) access;
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_AParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_PreconditionResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getPreconditionResultAccess().getIssuesKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getPreconditionResultAccess().getLeftSquareBracketKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getPreconditionResultAccess().getRightSquareBracketKeyword_8_3()));
		match_PredicateResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getPredicateResultAccess().getIssuesKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getPredicateResultAccess().getLeftSquareBracketKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getPredicateResultAccess().getRightSquareBracketKeyword_8_3()));
		match_ResultIssue___LeftSquareBracketKeyword_4_0_RightSquareBracketKeyword_4_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_4_2()));
		match_ValidationResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getValidationResultAccess().getIssuesKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getValidationResultAccess().getLeftSquareBracketKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getValidationResultAccess().getRightSquareBracketKeyword_8_3()));
		match_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationActivityResultAccess().getIssuesKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getVerificationActivityResultAccess().getLeftSquareBracketKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getVerificationActivityResultAccess().getRightSquareBracketKeyword_8_3()));
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
			else if (match_PreconditionResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q.equals(syntax))
				emit_PreconditionResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_PredicateResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q.equals(syntax))
				emit_PredicateResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ResultIssue___LeftSquareBracketKeyword_4_0_RightSquareBracketKeyword_4_2__q.equals(syntax))
				emit_ResultIssue___LeftSquareBracketKeyword_4_0_RightSquareBracketKeyword_4_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ValidationResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q.equals(syntax))
				emit_ValidationResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q.equals(syntax))
				emit_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     ('issues' '[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     resultState=VerificationResultState (ambiguity) 'results' results=[AnalysisResult|QualifiedName]
	 *     resultState=VerificationResultState (ambiguity) metrics=Metrics
	 */
	protected void emit_PreconditionResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('issues' '[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     resultState=VerificationResultState (ambiguity) 'results' results=[AnalysisResult|QualifiedName]
	 *     resultState=VerificationResultState (ambiguity) metrics=Metrics
	 */
	protected void emit_PredicateResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     exceptionType=STRING (ambiguity) (rule end)
	 *     message=STRING (ambiguity) (rule end)
	 *     sourceReference=[EObject|NoQuoteString] (ambiguity) (rule end)
	 */
	protected void emit_ResultIssue___LeftSquareBracketKeyword_4_0_RightSquareBracketKeyword_4_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('issues' '[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     resultState=VerificationResultState (ambiguity) 'results' results=[AnalysisResult|QualifiedName]
	 *     resultState=VerificationResultState (ambiguity) metrics=Metrics
	 */
	protected void emit_ValidationResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('issues' '[' ']')?
	 *
	 * This ambiguous syntax occurs at:
	 *     resultState=VerificationResultState (ambiguity) 'results' results=[AnalysisResult|QualifiedName]
	 *     resultState=VerificationResultState (ambiguity) metrics=Metrics
	 */
	protected void emit_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
