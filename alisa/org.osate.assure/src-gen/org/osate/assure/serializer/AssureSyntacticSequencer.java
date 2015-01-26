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
	protected AbstractElementAlias match_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AssureGrammarAccess) access;
		match_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getVerificationActivityResultAccess().getIssuesKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getVerificationActivityResultAccess().getLeftSquareBracketKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getVerificationActivityResultAccess().getRightSquareBracketKeyword_8_3()));
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
			if(match_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q.equals(syntax))
				emit_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('issues' '[' ']')?
	 */
	protected void emit_VerificationActivityResult___IssuesKeyword_8_0_LeftSquareBracketKeyword_8_1_RightSquareBracketKeyword_8_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
