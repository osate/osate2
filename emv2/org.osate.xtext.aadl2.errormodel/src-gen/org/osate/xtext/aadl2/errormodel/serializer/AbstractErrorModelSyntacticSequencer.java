package org.osate.xtext.aadl2.errormodel.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
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
	protected AbstractElementAlias match_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q;
	protected AbstractElementAlias match_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_3_0_a;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_3_0_p;
	protected AbstractElementAlias match_TypeTokenOrNoError_LeftCurlyBracketKeyword_2_0_or_LeftParenthesisKeyword_1_0;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ErrorModelGrammarAccess) access;
		match_ConditionTerm_LeftParenthesisKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_3_0());
		match_ConditionTerm_LeftParenthesisKeyword_3_0_p = new TokenAlias(true, false, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_3_0());
		match_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_5_TypesKeyword_1_6_SemicolonKeyword_1_7__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getErrorKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getEndKeyword_1_5()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_6()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_7()));
		match_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_6_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_6_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_6_9()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_6_10()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_11()));
		match_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_7_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_7_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_7_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_7_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_7_6()));
		match_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_8_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_8_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_6()));
		match_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_5_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_5_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_6()));
		match_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationKeyword_9_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPathsKeyword_9_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_9_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPathsKeyword_9_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_9_6()));
		match_SConditionTerm_LeftParenthesisKeyword_3_0_a = new TokenAlias(true, true, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_3_0());
		match_SConditionTerm_LeftParenthesisKeyword_3_0_p = new TokenAlias(true, false, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_3_0());
		match_TypeTokenOrNoError_LeftCurlyBracketKeyword_2_0_or_LeftParenthesisKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTypeTokenOrNoErrorAccess().getLeftCurlyBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getTypeTokenOrNoErrorAccess().getLeftParenthesisKeyword_1_0()));
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
			else if(match_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q.equals(syntax))
				emit_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q.equals(syntax))
				emit_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q.equals(syntax))
				emit_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q.equals(syntax))
				emit_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q.equals(syntax))
				emit_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SConditionTerm_LeftParenthesisKeyword_3_0_a.equals(syntax))
				emit_SConditionTerm_LeftParenthesisKeyword_3_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SConditionTerm_LeftParenthesisKeyword_3_0_p.equals(syntax))
				emit_SConditionTerm_LeftParenthesisKeyword_3_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypeTokenOrNoError_LeftCurlyBracketKeyword_2_0_or_LeftParenthesisKeyword_1_0.equals(syntax))
				emit_TypeTokenOrNoError_LeftCurlyBracketKeyword_2_0_or_LeftParenthesisKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
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
	protected void emit_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	protected void emit_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('connection' 'error' 'end' 'connection' ';')?
	 */
	protected void emit_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('error' 'propagations' 'end' 'propagations' ';')?
	 */
	protected void emit_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('propagation' 'paths' 'end' 'paths' ';')?
	 */
	protected void emit_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	
	/**
	 * Syntax:
	 *     '(' | '{'
	 */
	protected void emit_TypeTokenOrNoError_LeftCurlyBracketKeyword_2_0_or_LeftParenthesisKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
