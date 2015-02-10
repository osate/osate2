package org.osate.alisa.workbench.serializer;

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
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

@SuppressWarnings("all")
public class AlisaSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AlisaGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AssuranceCaseConfiguration_PlansKeyword_6_1_0_q;
	protected AbstractElementAlias match_AssuranceCaseConfiguration_WhenKeyword_6_2_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlisaGrammarAccess) access;
		match_AssuranceCaseConfiguration_PlansKeyword_6_1_0_q = new TokenAlias(false, true, grammarAccess.getAssuranceCaseConfigurationAccess().getPlansKeyword_6_1_0());
		match_AssuranceCaseConfiguration_WhenKeyword_6_2_0_q = new TokenAlias(false, true, grammarAccess.getAssuranceCaseConfigurationAccess().getWhenKeyword_6_2_0());
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
			if(match_AssuranceCaseConfiguration_PlansKeyword_6_1_0_q.equals(syntax))
				emit_AssuranceCaseConfiguration_PlansKeyword_6_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AssuranceCaseConfiguration_WhenKeyword_6_2_0_q.equals(syntax))
				emit_AssuranceCaseConfiguration_WhenKeyword_6_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'plans'?
	 */
	protected void emit_AssuranceCaseConfiguration_PlansKeyword_6_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'when'?
	 */
	protected void emit_AssuranceCaseConfiguration_WhenKeyword_6_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
