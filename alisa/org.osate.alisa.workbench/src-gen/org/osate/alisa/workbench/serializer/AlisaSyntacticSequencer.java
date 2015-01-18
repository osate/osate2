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
	protected AbstractElementAlias match_AssuranceCasePlan_PlansKeyword_5_2_1_a;
	protected AbstractElementAlias match_AssuranceCasePlan_PlansKeyword_5_2_1_p;
	protected AbstractElementAlias match_AssuranceCasePlan___PlansKeyword_5_2_1_p_ConstantsKeyword_5_2_0_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlisaGrammarAccess) access;
		match_AssuranceCasePlan_PlansKeyword_5_2_1_a = new TokenAlias(true, true, grammarAccess.getAssuranceCasePlanAccess().getPlansKeyword_5_2_1());
		match_AssuranceCasePlan_PlansKeyword_5_2_1_p = new TokenAlias(true, false, grammarAccess.getAssuranceCasePlanAccess().getPlansKeyword_5_2_1());
		match_AssuranceCasePlan___PlansKeyword_5_2_1_p_ConstantsKeyword_5_2_0_0__q = new GroupAlias(false, true, new TokenAlias(true, false, grammarAccess.getAssuranceCasePlanAccess().getPlansKeyword_5_2_1()), new TokenAlias(false, false, grammarAccess.getAssuranceCasePlanAccess().getConstantsKeyword_5_2_0_0()));
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
			if(match_AssuranceCasePlan_PlansKeyword_5_2_1_a.equals(syntax))
				emit_AssuranceCasePlan_PlansKeyword_5_2_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceCasePlan_PlansKeyword_5_2_1_p.equals(syntax))
				emit_AssuranceCasePlan_PlansKeyword_5_2_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceCasePlan___PlansKeyword_5_2_1_p_ConstantsKeyword_5_2_0_0__q.equals(syntax))
				emit_AssuranceCasePlan___PlansKeyword_5_2_1_p_ConstantsKeyword_5_2_0_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'plans'*
	 */
	protected void emit_AssuranceCasePlan_PlansKeyword_5_2_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'plans'+
	 */
	protected void emit_AssuranceCasePlan_PlansKeyword_5_2_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('plans'+ 'constants')?
	 */
	protected void emit_AssuranceCasePlan___PlansKeyword_5_2_1_p_ConstantsKeyword_5_2_0_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
