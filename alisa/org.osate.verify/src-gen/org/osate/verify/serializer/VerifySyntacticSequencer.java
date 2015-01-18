package org.osate.verify.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.osate.verify.services.VerifyGrammarAccess;

@SuppressWarnings("all")
public class VerifySyntacticSequencer extends AbstractSyntacticSequencer {

	protected VerifyGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_a;
	protected AbstractElementAlias match_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_p;
	protected AbstractElementAlias match_VerificationActivity_CategoryKeyword_5_2_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (VerifyGrammarAccess) access;
		match_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getAtomicEvidenceExprAccess().getLeftParenthesisKeyword_1_0());
		match_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_p = new TokenAlias(true, false, grammarAccess.getAtomicEvidenceExprAccess().getLeftParenthesisKeyword_1_0());
		match_VerificationActivity_CategoryKeyword_5_2_0_q = new TokenAlias(false, true, grammarAccess.getVerificationActivityAccess().getCategoryKeyword_5_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_a.equals(syntax))
				emit_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_p.equals(syntax))
				emit_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VerificationActivity_CategoryKeyword_5_2_0_q.equals(syntax))
				emit_VerificationActivity_CategoryKeyword_5_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_AtomicEvidenceExpr_LeftParenthesisKeyword_1_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'category'?
	 */
	protected void emit_VerificationActivity_CategoryKeyword_5_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
