package org.osate.xtext.aadl2.serializer;

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
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;

@SuppressWarnings("restriction")
public class AbstractAadl2SyntacticSequencer extends AbstractSyntacticSequencer {

	protected Aadl2GrammarAccess grammarAccess;
	protected AbstractElementAlias match_AadlPackage___ColonColonKeyword_6_0_IDTerminalRuleCall_6_1__a;
	protected AbstractElementAlias match_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q;
	protected AbstractElementAlias match_FlowPathImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q;
	protected AbstractElementAlias match_FlowPathImpl___IDTerminalRuleCall_8_0_FullStopKeyword_8_1__q;
	protected AbstractElementAlias match_FlowSinkImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q;
	protected AbstractElementAlias match_FlowSourceImpl___IDTerminalRuleCall_5_0_FullStopKeyword_5_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (Aadl2GrammarAccess) access;
		match_AadlPackage___ColonColonKeyword_6_0_IDTerminalRuleCall_6_1__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getColonColonKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getIDTerminalRuleCall_6_1()));
		match_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getPropertiesKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getNoneKeyword_3_1_1_0()), new TokenAlias(false, false, grammarAccess.getAadlPackageAccess().getSemicolonKeyword_3_1_1_1()));
		match_FlowPathImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFlowPathImplAccess().getIDTerminalRuleCall_4_0()), new TokenAlias(false, false, grammarAccess.getFlowPathImplAccess().getFullStopKeyword_4_1()));
		match_FlowPathImpl___IDTerminalRuleCall_8_0_FullStopKeyword_8_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFlowPathImplAccess().getIDTerminalRuleCall_8_0()), new TokenAlias(false, false, grammarAccess.getFlowPathImplAccess().getFullStopKeyword_8_1()));
		match_FlowSinkImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFlowSinkImplAccess().getIDTerminalRuleCall_4_0()), new TokenAlias(false, false, grammarAccess.getFlowSinkImplAccess().getFullStopKeyword_4_1()));
		match_FlowSourceImpl___IDTerminalRuleCall_5_0_FullStopKeyword_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getFlowSourceImplAccess().getIDTerminalRuleCall_5_0()), new TokenAlias(false, false, grammarAccess.getFlowSourceImplAccess().getFullStopKeyword_5_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getFULLINAMERule())
			return getFULLINAMEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSTARRule())
			return getSTARToken(semanticObject, ruleCall, node);
		return "";
	}
	
	protected String getFULLINAMEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getSTARToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "*";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AadlPackage___ColonColonKeyword_6_0_IDTerminalRuleCall_6_1__a.equals(syntax))
				emit_AadlPackage___ColonColonKeyword_6_0_IDTerminalRuleCall_6_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q.equals(syntax))
				emit_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FlowPathImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q.equals(syntax))
				emit_FlowPathImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FlowPathImpl___IDTerminalRuleCall_8_0_FullStopKeyword_8_1__q.equals(syntax))
				emit_FlowPathImpl___IDTerminalRuleCall_8_0_FullStopKeyword_8_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FlowSinkImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q.equals(syntax))
				emit_FlowSinkImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_FlowSourceImpl___IDTerminalRuleCall_5_0_FullStopKeyword_5_1__q.equals(syntax))
				emit_FlowSourceImpl___IDTerminalRuleCall_5_0_FullStopKeyword_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('::' ID)*
	 */
	protected void emit_AadlPackage___ColonColonKeyword_6_0_IDTerminalRuleCall_6_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('properties' 'none' ';')?
	 */
	protected void emit_AadlPackage___PropertiesKeyword_3_0_NoneKeyword_3_1_1_0_SemicolonKeyword_3_1_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (ID '.')?
	 */
	protected void emit_FlowPathImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (ID '.')?
	 */
	protected void emit_FlowPathImpl___IDTerminalRuleCall_8_0_FullStopKeyword_8_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (ID '.')?
	 */
	protected void emit_FlowSinkImpl___IDTerminalRuleCall_4_0_FullStopKeyword_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (ID '.')?
	 */
	protected void emit_FlowSourceImpl___IDTerminalRuleCall_5_0_FullStopKeyword_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
