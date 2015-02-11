package org.osate.results.serializer;

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
import org.osate.results.services.ResultsGrammarAccess;

@SuppressWarnings("all")
public class ResultsSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ResultsGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ResultContributor_IssuesKeyword_4_0_q;
	protected AbstractElementAlias match_ResultContributor___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q;
	protected AbstractElementAlias match_ResultReportEntry_IssuesKeyword_9_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ResultsGrammarAccess) access;
		match_ResultContributor_IssuesKeyword_4_0_q = new TokenAlias(false, true, grammarAccess.getResultContributorAccess().getIssuesKeyword_4_0());
		match_ResultContributor___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_5_2()));
		match_ResultReportEntry_IssuesKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getResultReportEntryAccess().getIssuesKeyword_9_0());
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
			if(match_ResultContributor_IssuesKeyword_4_0_q.equals(syntax))
				emit_ResultContributor_IssuesKeyword_4_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultContributor___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q.equals(syntax))
				emit_ResultContributor___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultReportEntry_IssuesKeyword_9_0_q.equals(syntax))
				emit_ResultReportEntry_IssuesKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_ResultContributor_IssuesKeyword_4_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('[' ']')?
	 */
	protected void emit_ResultContributor___LeftSquareBracketKeyword_5_0_RightSquareBracketKeyword_5_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_ResultReportEntry_IssuesKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
