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
	protected AbstractElementAlias match_AssurancePlan_AssertKeyword_7_1_0_q;
	protected AbstractElementAlias match_AssurancePlan_AssumeKeyword_7_2_0_q;
	protected AbstractElementAlias match_AssurancePlan_IssuesKeyword_7_3_0_q;
	protected AbstractElementAlias match_AssuranceTask_FilterKeyword_7_1_0_0_0_a;
	protected AbstractElementAlias match_AssuranceTask_FilterKeyword_7_1_0_0_0_p;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_ClaimsKeyword_7_1_1_0__q;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_IssuesKeyword_7_2_0__q;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_SelectionsKeyword_7_1_0_2_0__q;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_VerificationsKeyword_7_1_0_1_0__q;
	protected AbstractElementAlias match_AssuranceTask___FilterKeyword_7_1_0_0_0_p_RequirementsKeyword_7_1_0_0_1_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlisaGrammarAccess) access;
		match_AssurancePlan_AssertKeyword_7_1_0_q = new TokenAlias(false, true, grammarAccess.getAssurancePlanAccess().getAssertKeyword_7_1_0());
		match_AssurancePlan_AssumeKeyword_7_2_0_q = new TokenAlias(false, true, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_2_0());
		match_AssurancePlan_IssuesKeyword_7_3_0_q = new TokenAlias(false, true, grammarAccess.getAssurancePlanAccess().getIssuesKeyword_7_3_0());
		match_AssuranceTask_FilterKeyword_7_1_0_0_0_a = new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0());
		match_AssuranceTask_FilterKeyword_7_1_0_0_0_p = new TokenAlias(true, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0());
		match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_ClaimsKeyword_7_1_1_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getClaimsKeyword_7_1_1_0()));
		match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_IssuesKeyword_7_2_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getIssuesKeyword_7_2_0()));
		match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_SelectionsKeyword_7_1_0_2_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getSelectionsKeyword_7_1_0_2_0()));
		match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_VerificationsKeyword_7_1_0_1_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getVerificationsKeyword_7_1_0_1_0()));
		match_AssuranceTask___FilterKeyword_7_1_0_0_0_p_RequirementsKeyword_7_1_0_0_1_0__q = new GroupAlias(false, true, new TokenAlias(true, false, grammarAccess.getAssuranceTaskAccess().getFilterKeyword_7_1_0_0_0()), new TokenAlias(false, false, grammarAccess.getAssuranceTaskAccess().getRequirementsKeyword_7_1_0_0_1_0()));
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
			if(match_AssurancePlan_AssertKeyword_7_1_0_q.equals(syntax))
				emit_AssurancePlan_AssertKeyword_7_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan_AssumeKeyword_7_2_0_q.equals(syntax))
				emit_AssurancePlan_AssumeKeyword_7_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssurancePlan_IssuesKeyword_7_3_0_q.equals(syntax))
				emit_AssurancePlan_IssuesKeyword_7_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_FilterKeyword_7_1_0_0_0_a.equals(syntax))
				emit_AssuranceTask_FilterKeyword_7_1_0_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask_FilterKeyword_7_1_0_0_0_p.equals(syntax))
				emit_AssuranceTask_FilterKeyword_7_1_0_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_ClaimsKeyword_7_1_1_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_ClaimsKeyword_7_1_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_IssuesKeyword_7_2_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_IssuesKeyword_7_2_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_SelectionsKeyword_7_1_0_2_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_SelectionsKeyword_7_1_0_2_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_0_a_VerificationsKeyword_7_1_0_1_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_VerificationsKeyword_7_1_0_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceTask___FilterKeyword_7_1_0_0_0_p_RequirementsKeyword_7_1_0_0_1_0__q.equals(syntax))
				emit_AssuranceTask___FilterKeyword_7_1_0_0_0_p_RequirementsKeyword_7_1_0_0_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'assert'?
	 */
	protected void emit_AssurancePlan_AssertKeyword_7_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'assume'?
	 */
	protected void emit_AssurancePlan_AssumeKeyword_7_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'issues'?
	 */
	protected void emit_AssurancePlan_IssuesKeyword_7_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'filter'*
	 */
	protected void emit_AssuranceTask_FilterKeyword_7_1_0_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'filter'+
	 */
	protected void emit_AssuranceTask_FilterKeyword_7_1_0_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('filter'* 'claims')?
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_ClaimsKeyword_7_1_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('filter'* 'issues')?
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_IssuesKeyword_7_2_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('filter'* 'selections')?
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_SelectionsKeyword_7_1_0_2_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('filter'* 'verifications')?
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_0_a_VerificationsKeyword_7_1_0_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('filter'+ 'requirements')?
	 */
	protected void emit_AssuranceTask___FilterKeyword_7_1_0_0_0_p_RequirementsKeyword_7_1_0_0_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
