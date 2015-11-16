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
package org.osate.results.serializer;

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
import org.osate.results.services.ResultsGrammarAccess;

@SuppressWarnings("all")
public class ResultsSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ResultsGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ResultContributor_IssuesKeyword_5_0_q;
	protected AbstractElementAlias match_ResultReportCollection_IssuesKeyword_8_0_q;
	protected AbstractElementAlias match_ResultReport_IssuesKeyword_9_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ResultsGrammarAccess) access;
		match_ResultContributor_IssuesKeyword_5_0_q = new TokenAlias(false, true, grammarAccess.getResultContributorAccess().getIssuesKeyword_5_0());
		match_ResultReportCollection_IssuesKeyword_8_0_q = new TokenAlias(false, true, grammarAccess.getResultReportCollectionAccess().getIssuesKeyword_8_0());
		match_ResultReport_IssuesKeyword_9_0_q = new TokenAlias(false, true, grammarAccess.getResultReportAccess().getIssuesKeyword_9_0());
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
			if(match_ResultContributor_IssuesKeyword_5_0_q.equals(syntax))
				emit_ResultContributor_IssuesKeyword_5_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultReportCollection_IssuesKeyword_8_0_q.equals(syntax))
				emit_ResultReportCollection_IssuesKeyword_8_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultReport_IssuesKeyword_9_0_q.equals(syntax))
				emit_ResultReport_IssuesKeyword_9_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     cell+=STRING (ambiguity) ']' (rule end)
	 *     cell+=STRING (ambiguity) subcontributor+=ResultContributor
	 */
	protected void emit_ResultContributor_IssuesKeyword_5_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     content+=ResultReport (ambiguity) ']' (rule end)
	 *     decription=STRING (ambiguity) ']' (rule end)
	 *     target=[EObject|URIID] (ambiguity) ']' (rule end)
	 */
	protected void emit_ResultReportCollection_IssuesKeyword_8_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'issues'?
	 *
	 * This ambiguous syntax occurs at:
	 *     content+=ResultContributor (ambiguity) ']' (rule end)
	 *     decription=STRING (ambiguity) ']' (rule end)
	 *     heading=STRING (ambiguity) ']' (rule end)
	 *     resultData+=ResultData (ambiguity) ']' (rule end)
	 *     target=[EObject|URIID] (ambiguity) ']' (rule end)
	 */
	protected void emit_ResultReport_IssuesKeyword_9_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
