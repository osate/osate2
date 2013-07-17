package org.osate.xtext.aadl2.errormodel.serializer;

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
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractErrorModelSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ErrorModelGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ConditionTerm_LeftParenthesisKeyword_3_0_a;
	protected AbstractElementAlias match_ConditionTerm_LeftParenthesisKeyword_3_0_p;
	protected AbstractElementAlias match_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_5_TypesKeyword_1_6_SemicolonKeyword_1_7__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ComponentKeyword_4_0_ErrorKeyword_4_1_BehaviorKeyword_4_2_EndKeyword_4_9_ComponentKeyword_4_10_SemicolonKeyword_4_11__q;
	protected AbstractElementAlias match_ErrorModelSubclause___CompositeKeyword_5_0_ErrorKeyword_5_1_BehaviorKeyword_5_2_EndKeyword_5_4_CompositeKeyword_5_5_SemicolonKeyword_5_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ConnectionKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_5_ConnectionKeyword_6_6_SemicolonKeyword_6_7__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ErrorKeyword_3_0_PropagationsKeyword_3_1_EndKeyword_3_4_PropagationsKeyword_3_5_SemicolonKeyword_3_6__q;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_3_0_a;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_3_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ErrorModelGrammarAccess) access;
		match_ConditionTerm_LeftParenthesisKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_3_0());
		match_ConditionTerm_LeftParenthesisKeyword_3_0_p = new TokenAlias(true, false, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_3_0());
		match_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_5_TypesKeyword_1_6_SemicolonKeyword_1_7__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getErrorKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getEndKeyword_1_5()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_6()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_7()));
		match_ErrorModelSubclause___ComponentKeyword_4_0_ErrorKeyword_4_1_BehaviorKeyword_4_2_EndKeyword_4_9_ComponentKeyword_4_10_SemicolonKeyword_4_11__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_4_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_4_9()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_4_10()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_4_11()));
		match_ErrorModelSubclause___CompositeKeyword_5_0_ErrorKeyword_5_1_BehaviorKeyword_5_2_EndKeyword_5_4_CompositeKeyword_5_5_SemicolonKeyword_5_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_5_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_5_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_5_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_6()));
		match_ErrorModelSubclause___ConnectionKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_5_ConnectionKeyword_6_6_SemicolonKeyword_6_7__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_6_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_6_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_6_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_6_6()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_7()));
		match_ErrorModelSubclause___ErrorKeyword_3_0_PropagationsKeyword_3_1_EndKeyword_3_4_PropagationsKeyword_3_5_SemicolonKeyword_3_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_3_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_3_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_3_6()));
		match_SConditionTerm_LeftParenthesisKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_3_0());
		match_SConditionTerm_LeftParenthesisKeyword_3_0_p = new TokenAlias(true, false, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_3_0());
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
			if(match_ConditionTerm_LeftParenthesisKeyword_3_0_a.equals(syntax))
				emit_ConditionTerm_LeftParenthesisKeyword_3_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ConditionTerm_LeftParenthesisKeyword_3_0_p.equals(syntax))
				emit_ConditionTerm_LeftParenthesisKeyword_3_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_5_TypesKeyword_1_6_SemicolonKeyword_1_7__q.equals(syntax))
				emit_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_5_TypesKeyword_1_6_SemicolonKeyword_1_7__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___ComponentKeyword_4_0_ErrorKeyword_4_1_BehaviorKeyword_4_2_EndKeyword_4_9_ComponentKeyword_4_10_SemicolonKeyword_4_11__q.equals(syntax))
				emit_ErrorModelSubclause___ComponentKeyword_4_0_ErrorKeyword_4_1_BehaviorKeyword_4_2_EndKeyword_4_9_ComponentKeyword_4_10_SemicolonKeyword_4_11__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___CompositeKeyword_5_0_ErrorKeyword_5_1_BehaviorKeyword_5_2_EndKeyword_5_4_CompositeKeyword_5_5_SemicolonKeyword_5_6__q.equals(syntax))
				emit_ErrorModelSubclause___CompositeKeyword_5_0_ErrorKeyword_5_1_BehaviorKeyword_5_2_EndKeyword_5_4_CompositeKeyword_5_5_SemicolonKeyword_5_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___ConnectionKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_5_ConnectionKeyword_6_6_SemicolonKeyword_6_7__q.equals(syntax))
				emit_ErrorModelSubclause___ConnectionKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_5_ConnectionKeyword_6_6_SemicolonKeyword_6_7__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___ErrorKeyword_3_0_PropagationsKeyword_3_1_EndKeyword_3_4_PropagationsKeyword_3_5_SemicolonKeyword_3_6__q.equals(syntax))
				emit_ErrorModelSubclause___ErrorKeyword_3_0_PropagationsKeyword_3_1_EndKeyword_3_4_PropagationsKeyword_3_5_SemicolonKeyword_3_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SConditionTerm_LeftParenthesisKeyword_3_0_a.equals(syntax))
				emit_SConditionTerm_LeftParenthesisKeyword_3_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SConditionTerm_LeftParenthesisKeyword_3_0_p.equals(syntax))
				emit_SConditionTerm_LeftParenthesisKeyword_3_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ConditionTerm_LeftParenthesisKeyword_3_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ConditionTerm_LeftParenthesisKeyword_3_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('error' 'types' 'end' 'types' ';')?
	 */
	protected void emit_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_5_TypesKeyword_1_6_SemicolonKeyword_1_7__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     'component' 
	     'error' 
	     'behavior' 
	     'end' 
	     'component' 
	     ';'
	 )?
	 */
	protected void emit_ErrorModelSubclause___ComponentKeyword_4_0_ErrorKeyword_4_1_BehaviorKeyword_4_2_EndKeyword_4_9_ComponentKeyword_4_10_SemicolonKeyword_4_11__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     'composite' 
	     'error' 
	     'behavior' 
	     'end' 
	     'composite' 
	     ';'
	 )?
	 */
	protected void emit_ErrorModelSubclause___CompositeKeyword_5_0_ErrorKeyword_5_1_BehaviorKeyword_5_2_EndKeyword_5_4_CompositeKeyword_5_5_SemicolonKeyword_5_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     'connection' 
	     'error' 
	     'behavior' 
	     'end' 
	     'connection' 
	     ';'
	 )?
	 */
	protected void emit_ErrorModelSubclause___ConnectionKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_5_ConnectionKeyword_6_6_SemicolonKeyword_6_7__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('error' 'propagations' 'end' 'propagations' ';')?
	 */
	protected void emit_ErrorModelSubclause___ErrorKeyword_3_0_PropagationsKeyword_3_1_EndKeyword_3_4_PropagationsKeyword_3_5_SemicolonKeyword_3_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_SConditionTerm_LeftParenthesisKeyword_3_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_SConditionTerm_LeftParenthesisKeyword_3_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
