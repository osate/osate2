/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
	protected AbstractElementAlias match_ConditionTerm_LeftParenthesisKeyword_4_0_a;
	protected AbstractElementAlias match_ConditionTerm_LeftParenthesisKeyword_4_0_p;
	protected AbstractElementAlias match_EMV2Library___ErrorKeyword_0_1_2_0_TypesKeyword_0_1_2_1_EndKeyword_0_1_2_6_TypesKeyword_0_1_2_7_SemicolonKeyword_0_1_2_8__q;
	protected AbstractElementAlias match_EMV2Library___ErrorKeyword_1_6_0_TypesKeyword_1_6_1_EndKeyword_1_6_6_TypesKeyword_1_6_7_SemicolonKeyword_1_6_8__q;
	protected AbstractElementAlias match_EMV2Subclause___ComponentKeyword_8_0_ErrorKeyword_8_1_BehaviorKeyword_8_2_EndKeyword_8_9_ComponentKeyword_8_10_SemicolonKeyword_8_11__q;
	protected AbstractElementAlias match_EMV2Subclause___CompositeKeyword_9_0_ErrorKeyword_9_1_BehaviorKeyword_9_2_EndKeyword_9_4_CompositeKeyword_9_5_SemicolonKeyword_9_6__q;
	protected AbstractElementAlias match_EMV2Subclause___ConnectionKeyword_10_0_ErrorKeyword_10_1_EndKeyword_10_4_ConnectionKeyword_10_5_SemicolonKeyword_10_6__q;
	protected AbstractElementAlias match_EMV2Subclause___ErrorKeyword_7_0_PropagationsKeyword_7_1_EndKeyword_7_4_PropagationsKeyword_7_5_SemicolonKeyword_7_6__q;
	protected AbstractElementAlias match_EMV2Subclause___PropagationKeyword_11_0_PathsKeyword_11_1_EndKeyword_11_4_PathsKeyword_11_5_SemicolonKeyword_11_6__q;
	protected AbstractElementAlias match_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_6_TypesKeyword_1_7_SemicolonKeyword_1_8__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q;
	protected AbstractElementAlias match_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_4_0_a;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_4_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ErrorModelGrammarAccess) access;
		match_ConditionTerm_LeftParenthesisKeyword_4_0_a = new TokenAlias(true, true, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0());
		match_ConditionTerm_LeftParenthesisKeyword_4_0_p = new TokenAlias(true, false, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0());
		match_EMV2Library___ErrorKeyword_0_1_2_0_TypesKeyword_0_1_2_1_EndKeyword_0_1_2_6_TypesKeyword_0_1_2_7_SemicolonKeyword_0_1_2_8__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getErrorKeyword_0_1_2_0()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_0_1_2_1()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getEndKeyword_0_1_2_6()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_0_1_2_7()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_8()));
		match_EMV2Library___ErrorKeyword_1_6_0_TypesKeyword_1_6_1_EndKeyword_1_6_6_TypesKeyword_1_6_7_SemicolonKeyword_1_6_8__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getErrorKeyword_1_6_0()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_1_6_1()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getEndKeyword_1_6_6()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getTypesKeyword_1_6_7()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_8()));
		match_EMV2Subclause___ComponentKeyword_8_0_ErrorKeyword_8_1_BehaviorKeyword_8_2_EndKeyword_8_9_ComponentKeyword_8_10_SemicolonKeyword_8_11__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getComponentKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getBehaviorKeyword_8_2()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_8_9()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getComponentKeyword_8_10()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_11()));
		match_EMV2Subclause___CompositeKeyword_9_0_ErrorKeyword_9_1_BehaviorKeyword_9_2_EndKeyword_9_4_CompositeKeyword_9_5_SemicolonKeyword_9_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getCompositeKeyword_9_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_9_1()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getBehaviorKeyword_9_2()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_9_4()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getCompositeKeyword_9_5()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_9_6()));
		match_EMV2Subclause___ConnectionKeyword_10_0_ErrorKeyword_10_1_EndKeyword_10_4_ConnectionKeyword_10_5_SemicolonKeyword_10_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getConnectionKeyword_10_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_10_1()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_10_4()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getConnectionKeyword_10_5()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_6()));
		match_EMV2Subclause___ErrorKeyword_7_0_PropagationsKeyword_7_1_EndKeyword_7_4_PropagationsKeyword_7_5_SemicolonKeyword_7_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getErrorKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getPropagationsKeyword_7_1()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_7_4()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getPropagationsKeyword_7_5()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_7_6()));
		match_EMV2Subclause___PropagationKeyword_11_0_PathsKeyword_11_1_EndKeyword_11_4_PathsKeyword_11_5_SemicolonKeyword_11_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getPropagationKeyword_11_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getPathsKeyword_11_1()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndKeyword_11_4()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getPathsKeyword_11_5()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_11_6()));
		match_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_6_TypesKeyword_1_7_SemicolonKeyword_1_8__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getErrorKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getEndKeyword_1_6()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getTypesKeyword_1_7()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_8()));
		match_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_6_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_6_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_6_9()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getComponentKeyword_6_10()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_11()));
		match_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_7_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_7_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getBehaviorKeyword_7_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_7_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getCompositeKeyword_7_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_7_6()));
		match_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_8_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_8_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_8_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getConnectionKeyword_8_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_6()));
		match_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_5_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationsKeyword_5_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_6()));
		match_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationKeyword_9_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPathsKeyword_9_1()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndKeyword_9_4()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPathsKeyword_9_5()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_9_6()));
		match_SConditionTerm_LeftParenthesisKeyword_4_0_a = new TokenAlias(true, true, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0());
		match_SConditionTerm_LeftParenthesisKeyword_4_0_p = new TokenAlias(true, false, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getAppliesToKeywordsRule())
			return getAppliesToKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInBindingKeywordsRule())
			return getInBindingKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInModesKeywordsRule())
			return getInModesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getQEMREFRule())
			return getQEMREFToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * AppliesToKeywords:
	 * 	'applies' 'to'
	 * ;
	 */
	protected String getAppliesToKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "applies to";
	}
	
	/**
	 * terminal ID:	('a'..'z'
	 *         |'A'..'Z'
	 *         ) ( ('_')? ('a'..'z'
	 *         |'A'..'Z'
	 *         |'0'..'9'))*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * InBindingKeywords:
	 * 	'in' 'binding'
	 * ;
	 */
	protected String getInBindingKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "in binding";
	}
	
	/**
	 * InModesKeywords:
	 * 	'in' 'modes'
	 * ;
	 */
	protected String getInModesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "in modes";
	}
	
	/**
	 * QEMREF:
	 * 	 ID ('::' ID)* ;
	 */
	protected String getQEMREFToken(EObject semanticObject, RuleCall ruleCall, INode node) {
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
			if (match_ConditionTerm_LeftParenthesisKeyword_4_0_a.equals(syntax))
				emit_ConditionTerm_LeftParenthesisKeyword_4_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ConditionTerm_LeftParenthesisKeyword_4_0_p.equals(syntax))
				emit_ConditionTerm_LeftParenthesisKeyword_4_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Library___ErrorKeyword_0_1_2_0_TypesKeyword_0_1_2_1_EndKeyword_0_1_2_6_TypesKeyword_0_1_2_7_SemicolonKeyword_0_1_2_8__q.equals(syntax))
				emit_EMV2Library___ErrorKeyword_0_1_2_0_TypesKeyword_0_1_2_1_EndKeyword_0_1_2_6_TypesKeyword_0_1_2_7_SemicolonKeyword_0_1_2_8__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Library___ErrorKeyword_1_6_0_TypesKeyword_1_6_1_EndKeyword_1_6_6_TypesKeyword_1_6_7_SemicolonKeyword_1_6_8__q.equals(syntax))
				emit_EMV2Library___ErrorKeyword_1_6_0_TypesKeyword_1_6_1_EndKeyword_1_6_6_TypesKeyword_1_6_7_SemicolonKeyword_1_6_8__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___ComponentKeyword_8_0_ErrorKeyword_8_1_BehaviorKeyword_8_2_EndKeyword_8_9_ComponentKeyword_8_10_SemicolonKeyword_8_11__q.equals(syntax))
				emit_EMV2Subclause___ComponentKeyword_8_0_ErrorKeyword_8_1_BehaviorKeyword_8_2_EndKeyword_8_9_ComponentKeyword_8_10_SemicolonKeyword_8_11__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___CompositeKeyword_9_0_ErrorKeyword_9_1_BehaviorKeyword_9_2_EndKeyword_9_4_CompositeKeyword_9_5_SemicolonKeyword_9_6__q.equals(syntax))
				emit_EMV2Subclause___CompositeKeyword_9_0_ErrorKeyword_9_1_BehaviorKeyword_9_2_EndKeyword_9_4_CompositeKeyword_9_5_SemicolonKeyword_9_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___ConnectionKeyword_10_0_ErrorKeyword_10_1_EndKeyword_10_4_ConnectionKeyword_10_5_SemicolonKeyword_10_6__q.equals(syntax))
				emit_EMV2Subclause___ConnectionKeyword_10_0_ErrorKeyword_10_1_EndKeyword_10_4_ConnectionKeyword_10_5_SemicolonKeyword_10_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___ErrorKeyword_7_0_PropagationsKeyword_7_1_EndKeyword_7_4_PropagationsKeyword_7_5_SemicolonKeyword_7_6__q.equals(syntax))
				emit_EMV2Subclause___ErrorKeyword_7_0_PropagationsKeyword_7_1_EndKeyword_7_4_PropagationsKeyword_7_5_SemicolonKeyword_7_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___PropagationKeyword_11_0_PathsKeyword_11_1_EndKeyword_11_4_PathsKeyword_11_5_SemicolonKeyword_11_6__q.equals(syntax))
				emit_EMV2Subclause___PropagationKeyword_11_0_PathsKeyword_11_1_EndKeyword_11_4_PathsKeyword_11_5_SemicolonKeyword_11_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_6_TypesKeyword_1_7_SemicolonKeyword_1_8__q.equals(syntax))
				emit_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_6_TypesKeyword_1_7_SemicolonKeyword_1_8__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q.equals(syntax))
				emit_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q.equals(syntax))
				emit_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q.equals(syntax))
				emit_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q.equals(syntax))
				emit_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q.equals(syntax))
				emit_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SConditionTerm_LeftParenthesisKeyword_4_0_a.equals(syntax))
				emit_SConditionTerm_LeftParenthesisKeyword_4_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SConditionTerm_LeftParenthesisKeyword_4_0_p.equals(syntax))
				emit_SConditionTerm_LeftParenthesisKeyword_4_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'all' '(' operands+=ConditionElement
	 *     (rule start) (ambiguity) 'all' '-' count=INTVALUE
	 *     (rule start) (ambiguity) count=INTVALUE
	 *     (rule start) (ambiguity) qualifiedErrorPropagationReference=QualifiedErrorEventOrPropagation
	 *     (rule start) (ambiguity) {AndExpression.operands+=}
	 *     (rule start) (ambiguity) {OrExpression.operands+=}
	 */
	protected void emit_ConditionTerm_LeftParenthesisKeyword_4_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {AndExpression.operands+=}
	 *     (rule start) (ambiguity) {OrExpression.operands+=}
	 */
	protected void emit_ConditionTerm_LeftParenthesisKeyword_4_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('error' 'types' 'end' 'types' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QEMREF (ambiguity) (rule end)
	 *     name=QEMREF (ambiguity) behaviors+=ErrorBehaviorStateMachine
	 *     name=QEMREF (ambiguity) mappings+=TypeMappingSet
	 *     name=QEMREF (ambiguity) transformations+=TypeTransformationSet
	 */
	protected void emit_EMV2Library___ErrorKeyword_0_1_2_0_TypesKeyword_0_1_2_1_EndKeyword_0_1_2_6_TypesKeyword_0_1_2_7_SemicolonKeyword_0_1_2_8__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('error' 'types' 'end' 'types' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) '**}' ';' 'end' QEMREF ';' (rule end)
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) behaviors+=ErrorBehaviorStateMachine
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) mappings+=TypeMappingSet
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) transformations+=TypeTransformationSet
	 */
	protected void emit_EMV2Library___ErrorKeyword_1_6_0_TypesKeyword_1_6_1_EndKeyword_1_6_6_TypesKeyword_1_6_7_SemicolonKeyword_1_6_8__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         'component' 
	  *         'error' 
	  *         'behavior' 
	  *         'end' 
	  *         'component' 
	  *         ';'
	  *     )?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     name=QCREF ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     name=QCREF ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     propagations+=ErrorPropagation 'end' 'propagations' ';' (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     propagations+=ErrorPropagation 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 */
	protected void emit_EMV2Subclause___ComponentKeyword_8_0_ErrorKeyword_8_1_BehaviorKeyword_8_2_EndKeyword_8_9_ComponentKeyword_8_10_SemicolonKeyword_8_11__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         'composite' 
	  *         'error' 
	  *         'behavior' 
	  *         'end' 
	  *         'composite' 
	  *         ';'
	  *     )?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     name=QCREF ('error' 'propagations' 'end' 'propagations' ';')? ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     propagations+=ErrorPropagation 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 */
	protected void emit_EMV2Subclause___CompositeKeyword_9_0_ErrorKeyword_9_1_BehaviorKeyword_9_2_EndKeyword_9_4_CompositeKeyword_9_5_SemicolonKeyword_9_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('connection' 'error' 'end' 'connection' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'end' 'subclause' ';' (rule end)
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 */
	protected void emit_EMV2Subclause___ConnectionKeyword_10_0_ErrorKeyword_10_1_EndKeyword_10_4_ConnectionKeyword_10_5_SemicolonKeyword_10_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('error' 'propagations' 'end' 'propagations' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     name=QCREF (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     name=QCREF (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     name=QCREF (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     name=QCREF (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     name=QCREF (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     name=QCREF (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     name=QCREF (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     name=QCREF (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 */
	protected void emit_EMV2Subclause___ErrorKeyword_7_0_PropagationsKeyword_7_1_EndKeyword_7_4_PropagationsKeyword_7_5_SemicolonKeyword_7_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('propagation' 'paths' 'end' 'paths' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'end' 
	 *         'subclause' 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     connectionErrorSources+=ErrorSource 'end' 'connection' ';' (ambiguity) 'end' 'subclause' ';' (rule end)
	 *     connectionErrorSources+=ErrorSource 'end' 'connection' ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) 'end' 'subclause' ';' (rule end)
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) 'end' 'subclause' ';' (rule end)
	 *     states+=CompositeState 'end' 'composite' ';' ('connection' 'error' 'end' 'connection' ';')? (ambiguity) 'end' 'subclause' ';' (rule end)
	 *     states+=CompositeState 'end' 'composite' ';' ('connection' 'error' 'end' 'connection' ';')? (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) 'end' 'subclause' ';' (rule end)
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' 'end' 'connection' ';' (ambiguity) 'end' 'subclause' ';' (rule end)
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' 'end' 'connection' ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 */
	protected void emit_EMV2Subclause___PropagationKeyword_11_0_PathsKeyword_11_1_EndKeyword_11_4_PathsKeyword_11_5_SemicolonKeyword_11_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('error' 'types' 'end' 'types' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 *     (rule start) (ambiguity) behaviors+=ErrorBehaviorStateMachine
	 *     (rule start) (ambiguity) mappings+=TypeMappingSet
	 *     (rule start) (ambiguity) transformations+=TypeTransformationSet
	 */
	protected void emit_ErrorModelLibrary___ErrorKeyword_1_0_TypesKeyword_1_1_EndKeyword_1_6_TypesKeyword_1_7_SemicolonKeyword_1_8__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         'component' 
	  *         'error' 
	  *         'behavior' 
	  *         'end' 
	  *         'component' 
	  *         ';'
	  *     )?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         (ambiguity) 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (rule start) ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     (rule start) ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     flows+=ErrorFlow 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     propagations+=ErrorPropagation 'end' 'propagations' ';' (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     propagations+=ErrorPropagation 'end' 'propagations' ';' (ambiguity) ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' ('error' 'propagations' 'end' 'propagations' ';')? (ambiguity) 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 */
	protected void emit_ErrorModelSubclause___ComponentKeyword_6_0_ErrorKeyword_6_1_BehaviorKeyword_6_2_EndKeyword_6_9_ComponentKeyword_6_10_SemicolonKeyword_6_11__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (
	  *         'composite' 
	  *         'error' 
	  *         'behavior' 
	  *         'end' 
	  *         'composite' 
	  *         ';'
	  *     )?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         (ambiguity) 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (rule start) ('error' 'propagations' 'end' 'propagations' ';')? ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     flows+=ErrorFlow 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     propagations+=ErrorPropagation 'end' 'propagations' ';' ('component' 'error' 'behavior' 'end' 'component' ';')? (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) 'connection' 'error' 'use' 'transformations' typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? 'propagation' 'paths' points+=PropagationPoint
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' (ambiguity) ('connection' 'error' 'end' 'connection' ';')? ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 */
	protected void emit_ErrorModelSubclause___CompositeKeyword_7_0_ErrorKeyword_7_1_BehaviorKeyword_7_2_EndKeyword_7_4_CompositeKeyword_7_5_SemicolonKeyword_7_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('connection' 'error' 'end' 'connection' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         (ambiguity) 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     states+=CompositeState 'end' 'composite' ';' (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) 'propagation' 'paths' points+=PropagationPoint
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? (ambiguity) ('propagation' 'paths' 'end' 'paths' ';')? (rule end)
	 */
	protected void emit_ErrorModelSubclause___ConnectionKeyword_8_0_ErrorKeyword_8_1_EndKeyword_8_4_ConnectionKeyword_8_5_SemicolonKeyword_8_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('error' 'propagations' 'end' 'propagations' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         'use' 
	 *         'transformations' 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         'connection' 
	 *         'error' 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         'propagation' 
	 *         'paths' 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         ('propagation' 'paths' 'end' 'paths' ';')? 
	 *         (rule end)
	 *     )
	 *     (rule start) (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     (rule start) (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     (rule start) (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     (rule start) (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     (rule start) (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     (rule start) (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     (rule start) (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     (rule start) (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? ('composite' 'error' 'behavior' 'end' 'composite' ';')? 'connection' 'error' connectionErrorSources+=ErrorSource
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'detections' errorDetections+=ErrorDetection
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'events' events+=ErrorBehaviorEvent
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'mode' 'mappings' errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'transitions' transitions+=ErrorBehaviorTransition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) 'component' 'error' 'behavior' 'use' 'transformations' useTransformation=[TypeTransformationSet|QEMREF]
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ('component' 'error' 'behavior' 'end' 'component' ';')? 'composite' 'error' 'behavior' 'states' states+=CompositeState
	 */
	protected void emit_ErrorModelSubclause___ErrorKeyword_5_0_PropagationsKeyword_5_1_EndKeyword_5_4_PropagationsKeyword_5_5_SemicolonKeyword_5_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('propagation' 'paths' 'end' 'paths' ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         (rule start)
	 *     )
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         'end' 
	 *         'propagations' 
	 *         ';' 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         'end' 
	 *         'component' 
	 *         ';' 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         ('error' 'propagations' 'end' 'propagations' ';')? 
	 *         ('component' 'error' 'behavior' 'end' 'component' ';')? 
	 *         ('composite' 'error' 'behavior' 'end' 'composite' ';')? 
	 *         ('connection' 'error' 'end' 'connection' ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     connectionErrorSources+=ErrorSource 'end' 'connection' ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     connectionErrorSources+=ErrorSource 'end' 'connection' ';' (ambiguity) (rule end)
	 *     errorDetections+=ErrorDetection 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) (rule end)
	 *     errorStateToModeMappings+=ErrorStateToModeMapping 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) (rule end)
	 *     events+=ErrorBehaviorEvent 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) (rule end)
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) (rule end)
	 *     states+=CompositeState 'end' 'composite' ';' ('connection' 'error' 'end' 'connection' ';')? (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     states+=CompositeState 'end' 'composite' ';' ('connection' 'error' 'end' 'connection' ';')? (ambiguity) (rule end)
	 *     transitions+=ErrorBehaviorTransition 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) (rule end)
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' 'end' 'connection' ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' 'end' 'connection' ';' (ambiguity) (rule end)
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' 'end' 'component' ';' ('composite' 'error' 'behavior' 'end' 'composite' ';')? ('connection' 'error' 'end' 'connection' ';')? (ambiguity) (rule end)
	 */
	protected void emit_ErrorModelSubclause___PropagationKeyword_9_0_PathsKeyword_9_1_EndKeyword_9_4_PathsKeyword_9_5_SemicolonKeyword_9_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'all' '(' operands+=SConditionElement
	 *     (rule start) (ambiguity) 'all' '-' count=INTVALUE
	 *     (rule start) (ambiguity) 'in' qualifiedErrorPropagationReference=QualifiedErrorPropagation
	 *     (rule start) (ambiguity) count=INTVALUE
	 *     (rule start) (ambiguity) qualifiedState=QualifiedErrorBehaviorState
	 *     (rule start) (ambiguity) {AndExpression.operands+=}
	 *     (rule start) (ambiguity) {OrExpression.operands+=}
	 */
	protected void emit_SConditionTerm_LeftParenthesisKeyword_4_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {AndExpression.operands+=}
	 *     (rule start) (ambiguity) {OrExpression.operands+=}
	 */
	protected void emit_SConditionTerm_LeftParenthesisKeyword_4_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
