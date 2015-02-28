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
	protected AbstractElementAlias match_AssurancePlan___AssumeKeyword_7_2_0_VerifiedKeyword_7_2_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlisaGrammarAccess) access;
		match_AssurancePlan_AssertKeyword_7_1_0_q = new TokenAlias(false, true, grammarAccess.getAssurancePlanAccess().getAssertKeyword_7_1_0());
		match_AssurancePlan___AssumeKeyword_7_2_0_VerifiedKeyword_7_2_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getAssumeKeyword_7_2_0()), new TokenAlias(false, false, grammarAccess.getAssurancePlanAccess().getVerifiedKeyword_7_2_1()));
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
			else if(match_AssurancePlan___AssumeKeyword_7_2_0_VerifiedKeyword_7_2_1__q.equals(syntax))
				emit_AssurancePlan___AssumeKeyword_7_2_0_VerifiedKeyword_7_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     ('assume' 'verified')?
	 */
	protected void emit_AssurancePlan___AssumeKeyword_7_2_0_VerifiedKeyword_7_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
