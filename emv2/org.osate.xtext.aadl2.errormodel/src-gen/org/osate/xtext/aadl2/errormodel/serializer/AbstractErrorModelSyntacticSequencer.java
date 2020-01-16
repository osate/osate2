/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
	protected AbstractElementAlias match_EMV2Library___ErrorTypesKeywordsParserRuleCall_0_1_2_0_EndTypesKeywordsParserRuleCall_0_1_2_5_SemicolonKeyword_0_1_2_6__q;
	protected AbstractElementAlias match_EMV2Library___ErrorTypesKeywordsParserRuleCall_1_6_0_EndTypesKeywordsParserRuleCall_1_6_5_SemicolonKeyword_1_6_6__q;
	protected AbstractElementAlias match_EMV2Subclause___ComponentErrorBehaviorKeywordsParserRuleCall_8_0_EndComponentKeywordsParserRuleCall_8_7_SemicolonKeyword_8_8__q;
	protected AbstractElementAlias match_EMV2Subclause___CompositeErrorBehaviorKeywordsParserRuleCall_9_0_EndCompositeKeywordsParserRuleCall_9_2_SemicolonKeyword_9_3__q;
	protected AbstractElementAlias match_EMV2Subclause___ConnectionErrorKeywordsParserRuleCall_10_0_EndConnectionKeywordsParserRuleCall_10_3_SemicolonKeyword_10_4__q;
	protected AbstractElementAlias match_EMV2Subclause___ErrorPropagationsKeywordsParserRuleCall_7_0_EndPropagationsKeywordsParserRuleCall_7_3_SemicolonKeyword_7_4__q;
	protected AbstractElementAlias match_EMV2Subclause___PropagationPathsKeywordsParserRuleCall_11_0_EndPathsKeywordsParserRuleCall_11_3_SemicolonKeyword_11_4__q;
	protected AbstractElementAlias match_ErrorModelLibrary___ErrorTypesKeywordsParserRuleCall_1_0_EndTypesKeywordsParserRuleCall_1_5_SemicolonKeyword_1_6__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ComponentErrorBehaviorKeywordsParserRuleCall_6_0_EndComponentKeywordsParserRuleCall_6_7_SemicolonKeyword_6_8__q;
	protected AbstractElementAlias match_ErrorModelSubclause___CompositeErrorBehaviorKeywordsParserRuleCall_7_0_EndCompositeKeywordsParserRuleCall_7_2_SemicolonKeyword_7_3__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ConnectionErrorKeywordsParserRuleCall_8_0_EndConnectionKeywordsParserRuleCall_8_3_SemicolonKeyword_8_4__q;
	protected AbstractElementAlias match_ErrorModelSubclause___ErrorPropagationsKeywordsParserRuleCall_5_0_EndPropagationsKeywordsParserRuleCall_5_3_SemicolonKeyword_5_4__q;
	protected AbstractElementAlias match_ErrorModelSubclause___PropagationPathsKeywordsParserRuleCall_9_0_EndPathsKeywordsParserRuleCall_9_3_SemicolonKeyword_9_4__q;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_4_0_a;
	protected AbstractElementAlias match_SConditionTerm_LeftParenthesisKeyword_4_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ErrorModelGrammarAccess) access;
		match_ConditionTerm_LeftParenthesisKeyword_4_0_a = new TokenAlias(true, true, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0());
		match_ConditionTerm_LeftParenthesisKeyword_4_0_p = new TokenAlias(true, false, grammarAccess.getConditionTermAccess().getLeftParenthesisKeyword_4_0());
		match_EMV2Library___ErrorTypesKeywordsParserRuleCall_0_1_2_0_EndTypesKeywordsParserRuleCall_0_1_2_5_SemicolonKeyword_0_1_2_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getErrorTypesKeywordsParserRuleCall_0_1_2_0()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getEndTypesKeywordsParserRuleCall_0_1_2_5()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_0_1_2_6()));
		match_EMV2Library___ErrorTypesKeywordsParserRuleCall_1_6_0_EndTypesKeywordsParserRuleCall_1_6_5_SemicolonKeyword_1_6_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getErrorTypesKeywordsParserRuleCall_1_6_0()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getEndTypesKeywordsParserRuleCall_1_6_5()), new TokenAlias(false, false, grammarAccess.getEMV2LibraryAccess().getSemicolonKeyword_1_6_6()));
		match_EMV2Subclause___ComponentErrorBehaviorKeywordsParserRuleCall_8_0_EndComponentKeywordsParserRuleCall_8_7_SemicolonKeyword_8_8__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getComponentErrorBehaviorKeywordsParserRuleCall_8_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndComponentKeywordsParserRuleCall_8_7()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_8_8()));
		match_EMV2Subclause___CompositeErrorBehaviorKeywordsParserRuleCall_9_0_EndCompositeKeywordsParserRuleCall_9_2_SemicolonKeyword_9_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getCompositeErrorBehaviorKeywordsParserRuleCall_9_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndCompositeKeywordsParserRuleCall_9_2()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_9_3()));
		match_EMV2Subclause___ConnectionErrorKeywordsParserRuleCall_10_0_EndConnectionKeywordsParserRuleCall_10_3_SemicolonKeyword_10_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getConnectionErrorKeywordsParserRuleCall_10_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndConnectionKeywordsParserRuleCall_10_3()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_10_4()));
		match_EMV2Subclause___ErrorPropagationsKeywordsParserRuleCall_7_0_EndPropagationsKeywordsParserRuleCall_7_3_SemicolonKeyword_7_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getErrorPropagationsKeywordsParserRuleCall_7_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndPropagationsKeywordsParserRuleCall_7_3()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_7_4()));
		match_EMV2Subclause___PropagationPathsKeywordsParserRuleCall_11_0_EndPathsKeywordsParserRuleCall_11_3_SemicolonKeyword_11_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getPropagationPathsKeywordsParserRuleCall_11_0()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getEndPathsKeywordsParserRuleCall_11_3()), new TokenAlias(false, false, grammarAccess.getEMV2SubclauseAccess().getSemicolonKeyword_11_4()));
		match_ErrorModelLibrary___ErrorTypesKeywordsParserRuleCall_1_0_EndTypesKeywordsParserRuleCall_1_5_SemicolonKeyword_1_6__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getErrorTypesKeywordsParserRuleCall_1_0()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getEndTypesKeywordsParserRuleCall_1_5()), new TokenAlias(false, false, grammarAccess.getErrorModelLibraryAccess().getSemicolonKeyword_1_6()));
		match_ErrorModelSubclause___ComponentErrorBehaviorKeywordsParserRuleCall_6_0_EndComponentKeywordsParserRuleCall_6_7_SemicolonKeyword_6_8__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getComponentErrorBehaviorKeywordsParserRuleCall_6_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndComponentKeywordsParserRuleCall_6_7()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_6_8()));
		match_ErrorModelSubclause___CompositeErrorBehaviorKeywordsParserRuleCall_7_0_EndCompositeKeywordsParserRuleCall_7_2_SemicolonKeyword_7_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getCompositeErrorBehaviorKeywordsParserRuleCall_7_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndCompositeKeywordsParserRuleCall_7_2()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_7_3()));
		match_ErrorModelSubclause___ConnectionErrorKeywordsParserRuleCall_8_0_EndConnectionKeywordsParserRuleCall_8_3_SemicolonKeyword_8_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorKeywordsParserRuleCall_8_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndConnectionKeywordsParserRuleCall_8_3()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_8_4()));
		match_ErrorModelSubclause___ErrorPropagationsKeywordsParserRuleCall_5_0_EndPropagationsKeywordsParserRuleCall_5_3_SemicolonKeyword_5_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getErrorPropagationsKeywordsParserRuleCall_5_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndPropagationsKeywordsParserRuleCall_5_3()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_5_4()));
		match_ErrorModelSubclause___PropagationPathsKeywordsParserRuleCall_9_0_EndPathsKeywordsParserRuleCall_9_3_SemicolonKeyword_9_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getPropagationPathsKeywordsParserRuleCall_9_0()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getEndPathsKeywordsParserRuleCall_9_3()), new TokenAlias(false, false, grammarAccess.getErrorModelSubclauseAccess().getSemicolonKeyword_9_4()));
		match_SConditionTerm_LeftParenthesisKeyword_4_0_a = new TokenAlias(true, true, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0());
		match_SConditionTerm_LeftParenthesisKeyword_4_0_p = new TokenAlias(true, false, grammarAccess.getSConditionTermAccess().getLeftParenthesisKeyword_4_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getAppliesToKeywordsRule())
			return getAppliesToKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getComponentErrorBehaviorKeywordsRule())
			return getComponentErrorBehaviorKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getCompositeErrorBehaviorKeywordsRule())
			return getCompositeErrorBehaviorKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getConnectionErrorKeywordsRule())
			return getConnectionErrorKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndBehaviorKeywordsRule())
			return getEndBehaviorKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndComponentKeywordsRule())
			return getEndComponentKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndCompositeKeywordsRule())
			return getEndCompositeKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndConnectionKeywordsRule())
			return getEndConnectionKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndMappingsKeywordsRule())
			return getEndMappingsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndPathsKeywordsRule())
			return getEndPathsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndPropagationsKeywordsRule())
			return getEndPropagationsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndSubclauseKeywordsRule())
			return getEndSubclauseKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndTransformationsKeywordsRule())
			return getEndTransformationsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getEndTypesKeywordsRule())
			return getEndTypesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getErrorBehaviorKeywordsRule())
			return getErrorBehaviorKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getErrorEventKeywordsRule())
			return getErrorEventKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getErrorPathKeywordsRule())
			return getErrorPathKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getErrorPropagationsKeywordsRule())
			return getErrorPropagationsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getErrorSinkKeywordsRule())
			return getErrorSinkKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getErrorSourceKeywordsRule())
			return getErrorSourceKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getErrorTypesKeywordsRule())
			return getErrorTypesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInBindingKeywordsRule())
			return getInBindingKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getInModesKeywordsRule())
			return getInModesKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getModeMappingsKeywordsRule())
			return getModeMappingsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getPropagationPathsKeywordsRule())
			return getPropagationPathsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getPropagationPointKeywordsRule())
			return getPropagationPointKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getQEMREFRule())
			return getQEMREFToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getRecoverEventKeywordsRule())
			return getRecoverEventKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getRepairEventKeywordsRule())
			return getRepairEventKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getSameStateKeywordsRule())
			return getSameStateKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getTypeMappingsKeywordsRule())
			return getTypeMappingsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getTypeSetKeywordsRule())
			return getTypeSetKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getTypeTransformationsKeywordsRule())
			return getTypeTransformationsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getUseBehaviorKeywordsRule())
			return getUseBehaviorKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getUseMappingsKeywordsRule())
			return getUseMappingsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getUseTransformationsKeywordsRule())
			return getUseTransformationsKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getUseTypeEquivalenceKeywordsRule())
			return getUseTypeEquivalenceKeywordsToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getUseTypesKeywordsRule())
			return getUseTypesKeywordsToken(semanticObject, ruleCall, node);
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
	 * ComponentErrorBehaviorKeywords:
	 * 	'component' 'error' 'behavior'
	 * ;
	 */
	protected String getComponentErrorBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "component error behavior";
	}
	
	/**
	 * CompositeErrorBehaviorKeywords:
	 * 	'composite' 'error' 'behavior'
	 * ;
	 */
	protected String getCompositeErrorBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "composite error behavior";
	}
	
	/**
	 * ConnectionErrorKeywords:
	 * 	'connection' 'error'
	 * ;
	 */
	protected String getConnectionErrorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "connection error";
	}
	
	/**
	 * EndBehaviorKeywords:
	 * 	'end' 'behavior'
	 * ;
	 */
	protected String getEndBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end behavior";
	}
	
	/**
	 * EndComponentKeywords:
	 * 	'end' 'component'
	 * ;
	 */
	protected String getEndComponentKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end component";
	}
	
	/**
	 * EndCompositeKeywords:
	 * 	'end' 'composite'
	 * ;
	 */
	protected String getEndCompositeKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end composite";
	}
	
	/**
	 * EndConnectionKeywords:
	 * 	'end' 'connection'
	 * ;
	 */
	protected String getEndConnectionKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end connection";
	}
	
	/**
	 * EndMappingsKeywords:
	 * 	'end' 'mappings'
	 * ;
	 */
	protected String getEndMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end mappings";
	}
	
	/**
	 * EndPathsKeywords:
	 * 	'end' 'paths'
	 * ;
	 */
	protected String getEndPathsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end paths";
	}
	
	/**
	 * EndPropagationsKeywords:
	 * 	'end' 'propagations'
	 * ;
	 */
	protected String getEndPropagationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end propagations";
	}
	
	/**
	 * EndSubclauseKeywords:
	 * 	'end' 'subclause'
	 * ;
	 */
	protected String getEndSubclauseKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end subclause";
	}
	
	/**
	 * EndTransformationsKeywords:
	 * 	'end' 'transformations'
	 * ;
	 */
	protected String getEndTransformationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end transformations";
	}
	
	/**
	 * EndTypesKeywords:
	 * 	'end' 'types'
	 * ;
	 */
	protected String getEndTypesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "end types";
	}
	
	/**
	 * ErrorBehaviorKeywords:
	 * 	'error' 'behavior'
	 * ;
	 */
	protected String getErrorBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error behavior";
	}
	
	/**
	 * ErrorEventKeywords:
	 * 	'error' 'event'
	 * ;
	 */
	protected String getErrorEventKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error event";
	}
	
	/**
	 * ErrorPathKeywords:
	 * 	'error' 'path'
	 * ;
	 */
	protected String getErrorPathKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error path";
	}
	
	/**
	 * ErrorPropagationsKeywords:
	 * 	'error' 'propagations'
	 * ;
	 */
	protected String getErrorPropagationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error propagations";
	}
	
	/**
	 * ErrorSinkKeywords:
	 * 	'error' 'sink'
	 * ;
	 */
	protected String getErrorSinkKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error sink";
	}
	
	/**
	 * ErrorSourceKeywords:
	 * 	'error' 'source'
	 * ;
	 */
	protected String getErrorSourceKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error source";
	}
	
	/**
	 * ErrorTypesKeywords:
	 * 	'error' 'types'
	 * ;
	 */
	protected String getErrorTypesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "error types";
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
	 * ModeMappingsKeywords:
	 * 	'mode' 'mappings'
	 * ;
	 */
	protected String getModeMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "mode mappings";
	}
	
	/**
	 * PropagationPathsKeywords:
	 * 	'propagation' 'paths'
	 * ;
	 */
	protected String getPropagationPathsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "propagation paths";
	}
	
	/**
	 * PropagationPointKeywords:
	 * 	'propagation' 'point'
	 * ;
	 */
	protected String getPropagationPointKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "propagation point";
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
	
	/**
	 * RecoverEventKeywords:
	 * 	'recover' 'event'
	 * ;
	 */
	protected String getRecoverEventKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "recover event";
	}
	
	/**
	 * RepairEventKeywords:
	 * 	'repair' 'event'
	 * ;
	 */
	protected String getRepairEventKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "repair event";
	}
	
	/**
	 * SameStateKeywords:
	 * 	'same' 'state'
	 * ;
	 */
	protected String getSameStateKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "same state";
	}
	
	/**
	 * TypeMappingsKeywords:
	 * 	'type' 'mappings'
	 * ;
	 */
	protected String getTypeMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "type mappings";
	}
	
	/**
	 * TypeSetKeywords:
	 * 	'type' 'set'
	 * ;
	 */
	protected String getTypeSetKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "type set";
	}
	
	/**
	 * TypeTransformationsKeywords:
	 * 	'type' 'transformations'
	 * ;
	 */
	protected String getTypeTransformationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "type transformations";
	}
	
	/**
	 * UseBehaviorKeywords:
	 * 	'use' 'behavior'
	 * ;
	 */
	protected String getUseBehaviorKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "use behavior";
	}
	
	/**
	 * UseMappingsKeywords:
	 * 	'use' 'mappings'
	 * ;
	 */
	protected String getUseMappingsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "use mappings";
	}
	
	/**
	 * UseTransformationsKeywords:
	 * 	'use' 'transformations'
	 * ;
	 */
	protected String getUseTransformationsKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "use transformations";
	}
	
	/**
	 * UseTypeEquivalenceKeywords:
	 * 	'use' 'type' 'equivalence'
	 * ;
	 */
	protected String getUseTypeEquivalenceKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "use type equivalence";
	}
	
	/**
	 * UseTypesKeywords:
	 * 	'use' 'types'
	 * ;
	 */
	protected String getUseTypesKeywordsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "use types";
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
			else if (match_EMV2Library___ErrorTypesKeywordsParserRuleCall_0_1_2_0_EndTypesKeywordsParserRuleCall_0_1_2_5_SemicolonKeyword_0_1_2_6__q.equals(syntax))
				emit_EMV2Library___ErrorTypesKeywordsParserRuleCall_0_1_2_0_EndTypesKeywordsParserRuleCall_0_1_2_5_SemicolonKeyword_0_1_2_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Library___ErrorTypesKeywordsParserRuleCall_1_6_0_EndTypesKeywordsParserRuleCall_1_6_5_SemicolonKeyword_1_6_6__q.equals(syntax))
				emit_EMV2Library___ErrorTypesKeywordsParserRuleCall_1_6_0_EndTypesKeywordsParserRuleCall_1_6_5_SemicolonKeyword_1_6_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___ComponentErrorBehaviorKeywordsParserRuleCall_8_0_EndComponentKeywordsParserRuleCall_8_7_SemicolonKeyword_8_8__q.equals(syntax))
				emit_EMV2Subclause___ComponentErrorBehaviorKeywordsParserRuleCall_8_0_EndComponentKeywordsParserRuleCall_8_7_SemicolonKeyword_8_8__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___CompositeErrorBehaviorKeywordsParserRuleCall_9_0_EndCompositeKeywordsParserRuleCall_9_2_SemicolonKeyword_9_3__q.equals(syntax))
				emit_EMV2Subclause___CompositeErrorBehaviorKeywordsParserRuleCall_9_0_EndCompositeKeywordsParserRuleCall_9_2_SemicolonKeyword_9_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___ConnectionErrorKeywordsParserRuleCall_10_0_EndConnectionKeywordsParserRuleCall_10_3_SemicolonKeyword_10_4__q.equals(syntax))
				emit_EMV2Subclause___ConnectionErrorKeywordsParserRuleCall_10_0_EndConnectionKeywordsParserRuleCall_10_3_SemicolonKeyword_10_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___ErrorPropagationsKeywordsParserRuleCall_7_0_EndPropagationsKeywordsParserRuleCall_7_3_SemicolonKeyword_7_4__q.equals(syntax))
				emit_EMV2Subclause___ErrorPropagationsKeywordsParserRuleCall_7_0_EndPropagationsKeywordsParserRuleCall_7_3_SemicolonKeyword_7_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_EMV2Subclause___PropagationPathsKeywordsParserRuleCall_11_0_EndPathsKeywordsParserRuleCall_11_3_SemicolonKeyword_11_4__q.equals(syntax))
				emit_EMV2Subclause___PropagationPathsKeywordsParserRuleCall_11_0_EndPathsKeywordsParserRuleCall_11_3_SemicolonKeyword_11_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelLibrary___ErrorTypesKeywordsParserRuleCall_1_0_EndTypesKeywordsParserRuleCall_1_5_SemicolonKeyword_1_6__q.equals(syntax))
				emit_ErrorModelLibrary___ErrorTypesKeywordsParserRuleCall_1_0_EndTypesKeywordsParserRuleCall_1_5_SemicolonKeyword_1_6__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___ComponentErrorBehaviorKeywordsParserRuleCall_6_0_EndComponentKeywordsParserRuleCall_6_7_SemicolonKeyword_6_8__q.equals(syntax))
				emit_ErrorModelSubclause___ComponentErrorBehaviorKeywordsParserRuleCall_6_0_EndComponentKeywordsParserRuleCall_6_7_SemicolonKeyword_6_8__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___CompositeErrorBehaviorKeywordsParserRuleCall_7_0_EndCompositeKeywordsParserRuleCall_7_2_SemicolonKeyword_7_3__q.equals(syntax))
				emit_ErrorModelSubclause___CompositeErrorBehaviorKeywordsParserRuleCall_7_0_EndCompositeKeywordsParserRuleCall_7_2_SemicolonKeyword_7_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___ConnectionErrorKeywordsParserRuleCall_8_0_EndConnectionKeywordsParserRuleCall_8_3_SemicolonKeyword_8_4__q.equals(syntax))
				emit_ErrorModelSubclause___ConnectionErrorKeywordsParserRuleCall_8_0_EndConnectionKeywordsParserRuleCall_8_3_SemicolonKeyword_8_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___ErrorPropagationsKeywordsParserRuleCall_5_0_EndPropagationsKeywordsParserRuleCall_5_3_SemicolonKeyword_5_4__q.equals(syntax))
				emit_ErrorModelSubclause___ErrorPropagationsKeywordsParserRuleCall_5_0_EndPropagationsKeywordsParserRuleCall_5_3_SemicolonKeyword_5_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ErrorModelSubclause___PropagationPathsKeywordsParserRuleCall_9_0_EndPathsKeywordsParserRuleCall_9_3_SemicolonKeyword_9_4__q.equals(syntax))
				emit_ErrorModelSubclause___PropagationPathsKeywordsParserRuleCall_9_0_EndPathsKeywordsParserRuleCall_9_3_SemicolonKeyword_9_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     (ErrorTypesKeywords EndTypesKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QEMREF (ambiguity) (rule end)
	 *     name=QEMREF (ambiguity) behaviors+=ErrorBehaviorStateMachine
	 *     name=QEMREF (ambiguity) mappings+=TypeMappingSet
	 *     name=QEMREF (ambiguity) transformations+=TypeTransformationSet
	 */
	protected void emit_EMV2Library___ErrorTypesKeywordsParserRuleCall_0_1_2_0_EndTypesKeywordsParserRuleCall_0_1_2_5_SemicolonKeyword_0_1_2_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ErrorTypesKeywords EndTypesKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) '**}' ';' 'end' QEMREF ';' (rule end)
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) behaviors+=ErrorBehaviorStateMachine
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) mappings+=TypeMappingSet
	 *     name=QEMREF 'public' 'annex' ID '{**' (ambiguity) transformations+=TypeTransformationSet
	 */
	protected void emit_EMV2Library___ErrorTypesKeywordsParserRuleCall_1_6_0_EndTypesKeywordsParserRuleCall_1_6_5_SemicolonKeyword_1_6_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ComponentErrorBehaviorKeywords EndComponentKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     flows+=ErrorFlow EndPropagationsKeywords ';' (ambiguity) (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow EndPropagationsKeywords ';' (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     name=QCREF (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     name=QCREF (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     propagations+=ErrorPropagation EndPropagationsKeywords ';' (ambiguity) (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     propagations+=ErrorPropagation EndPropagationsKeywords ';' (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 */
	protected void emit_EMV2Subclause___ComponentErrorBehaviorKeywordsParserRuleCall_8_0_EndComponentKeywordsParserRuleCall_8_7_SemicolonKeyword_8_8__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? (PropagationPathsKeywords EndPathsKeywords ';')? EndSubclauseKeywords ';' (rule end)
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? (PropagationPathsKeywords EndPathsKeywords ';')? EndSubclauseKeywords ';' (rule end)
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow EndPropagationsKeywords ';' (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     name=QCREF (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     propagations+=ErrorPropagation EndPropagationsKeywords ';' (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 */
	protected void emit_EMV2Subclause___CompositeErrorBehaviorKeywordsParserRuleCall_9_0_EndCompositeKeywordsParserRuleCall_9_2_SemicolonKeyword_9_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ConnectionErrorKeywords EndConnectionKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? EndSubclauseKeywords ';' (rule end)
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? EndSubclauseKeywords ';' (rule end)
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 */
	protected void emit_EMV2Subclause___ConnectionErrorKeywordsParserRuleCall_10_0_EndConnectionKeywordsParserRuleCall_10_3_SemicolonKeyword_10_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ErrorPropagationsKeywords EndPropagationsKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     name=QCREF (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     name=QCREF (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     name=QCREF (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     name=QCREF (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     name=QCREF (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     name=QCREF (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     name=QCREF (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     name=QCREF (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 */
	protected void emit_EMV2Subclause___ErrorPropagationsKeywordsParserRuleCall_7_0_EndPropagationsKeywordsParserRuleCall_7_3_SemicolonKeyword_7_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (PropagationPathsKeywords EndPathsKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         name=QCREF 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         EndSubclauseKeywords 
	 *         ';' 
	 *         (rule end)
	 *     )
	 *     connectionErrorSources+=ErrorSource EndConnectionKeywords ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     connectionErrorSources+=ErrorSource EndConnectionKeywords ';' (ambiguity) EndSubclauseKeywords ';' (rule end)
	 *     states+=CompositeState EndCompositeKeywords ';' (ConnectionErrorKeywords EndConnectionKeywords ';')? (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     states+=CompositeState EndCompositeKeywords ';' (ConnectionErrorKeywords EndConnectionKeywords ';')? (ambiguity) EndSubclauseKeywords ';' (rule end)
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' EndConnectionKeywords ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' EndConnectionKeywords ';' (ambiguity) EndSubclauseKeywords ';' (rule end)
	 */
	protected void emit_EMV2Subclause___PropagationPathsKeywordsParserRuleCall_11_0_EndPathsKeywordsParserRuleCall_11_3_SemicolonKeyword_11_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ErrorTypesKeywords EndTypesKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 *     (rule start) (ambiguity) behaviors+=ErrorBehaviorStateMachine
	 *     (rule start) (ambiguity) mappings+=TypeMappingSet
	 *     (rule start) (ambiguity) transformations+=TypeTransformationSet
	 */
	protected void emit_ErrorModelLibrary___ErrorTypesKeywordsParserRuleCall_1_0_EndTypesKeywordsParserRuleCall_1_5_SemicolonKeyword_1_6__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ComponentErrorBehaviorKeywords EndComponentKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ambiguity) 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (rule start) (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     (rule start) (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     flows+=ErrorFlow EndPropagationsKeywords ';' (ambiguity) (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow EndPropagationsKeywords ';' (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     propagations+=ErrorPropagation EndPropagationsKeywords ';' (ambiguity) (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     propagations+=ErrorPropagation EndPropagationsKeywords ';' (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ambiguity) CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 */
	protected void emit_ErrorModelSubclause___ComponentErrorBehaviorKeywordsParserRuleCall_6_0_EndComponentKeywordsParserRuleCall_6_7_SemicolonKeyword_6_8__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (ambiguity) 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (rule start) (ErrorPropagationsKeywords EndPropagationsKeywords ';')? (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     flows+=ErrorFlow EndPropagationsKeywords ';' (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     propagations+=ErrorPropagation EndPropagationsKeywords ';' (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) (ConnectionErrorKeywords EndConnectionKeywords ';')? PropagationPathsKeywords points+=PropagationPoint
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords UseTransformationsKeywords typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (ambiguity) ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 */
	protected void emit_ErrorModelSubclause___CompositeErrorBehaviorKeywordsParserRuleCall_7_0_EndCompositeKeywordsParserRuleCall_7_2_SemicolonKeyword_7_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ConnectionErrorKeywords EndConnectionKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ambiguity) 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     errorStateToModeMappings+=ErrorStateToModeMapping EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     outgoingPropagationConditions+=OutgoingPropagationCondition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? 'properties' properties+=EMV2PropertyAssociation
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     states+=CompositeState EndCompositeKeywords ';' (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) (PropagationPathsKeywords EndPathsKeywords ';')? (rule end)
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords paths+=PropagationPath
	 *     useTransformation=[TypeTransformationSet|QEMREF] ';' EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ambiguity) PropagationPathsKeywords points+=PropagationPoint
	 */
	protected void emit_ErrorModelSubclause___ConnectionErrorKeywordsParserRuleCall_8_0_EndConnectionKeywordsParserRuleCall_8_3_SemicolonKeyword_8_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (ErrorPropagationsKeywords EndPropagationsKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule start)
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (PropagationPathsKeywords EndPathsKeywords ';')? 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         paths+=PropagationPath
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         PropagationPathsKeywords 
	 *         points+=PropagationPoint
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         UseTransformationsKeywords 
	 *         typeTransformationSet=[TypeTransformationSet|QEMREF]
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ambiguity) 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         ConnectionErrorKeywords 
	 *         connectionErrorSources+=ErrorSource
	 *     )
	 *     (rule start) (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? ConnectionErrorKeywords connectionErrorSources+=ErrorSource
	 *     (rule start) (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     (rule start) (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     (rule start) (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     (rule start) (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     (rule start) (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     (rule start) (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     (rule start) (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeEquivalence=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     typeMappingSet=[TypeMappingSet|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useBehavior=[ErrorBehaviorStateMachine|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? CompositeErrorBehaviorKeywords 'states' states+=CompositeState
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'detections' errorDetections+=ErrorDetection
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'events' events+=ErrorBehaviorEvent
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'propagations' outgoingPropagationConditions+=OutgoingPropagationCondition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords 'transitions' transitions+=ErrorBehaviorTransition
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords ModeMappingsKeywords errorStateToModeMappings+=ErrorStateToModeMapping
	 *     useTypes+=[ErrorModelLibrary|QEMREF] ';' (ambiguity) ComponentErrorBehaviorKeywords UseTransformationsKeywords useTransformation=[TypeTransformationSet|QEMREF]
	 */
	protected void emit_ErrorModelSubclause___ErrorPropagationsKeywordsParserRuleCall_5_0_EndPropagationsKeywordsParserRuleCall_5_3_SemicolonKeyword_5_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (PropagationPathsKeywords EndPathsKeywords ';')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         (rule start) 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule start)
	 *     )
	 *     (
	 *         errorDetections+=ErrorDetection 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         errorStateToModeMappings+=ErrorStateToModeMapping 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         events+=ErrorBehaviorEvent 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         flows+=ErrorFlow 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         outgoingPropagationConditions+=OutgoingPropagationCondition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         propagations+=ErrorPropagation 
	 *         EndPropagationsKeywords 
	 *         ';' 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         transitions+=ErrorBehaviorTransition 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeEquivalence=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         typeMappingSet=[TypeMappingSet|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useBehavior=[ErrorBehaviorStateMachine|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTransformation=[TypeTransformationSet|QEMREF] 
	 *         ';' 
	 *         EndComponentKeywords 
	 *         ';' 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         'properties' 
	 *         properties+=EMV2PropertyAssociation
	 *     )
	 *     (
	 *         useTypes+=[ErrorModelLibrary|QEMREF] 
	 *         ';' 
	 *         (ErrorPropagationsKeywords EndPropagationsKeywords ';')? 
	 *         (ComponentErrorBehaviorKeywords EndComponentKeywords ';')? 
	 *         (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? 
	 *         (ConnectionErrorKeywords EndConnectionKeywords ';')? 
	 *         (ambiguity) 
	 *         (rule end)
	 *     )
	 *     connectionErrorSources+=ErrorSource EndConnectionKeywords ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     connectionErrorSources+=ErrorSource EndConnectionKeywords ';' (ambiguity) (rule end)
	 *     errorDetections+=ErrorDetection EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ConnectionErrorKeywords EndConnectionKeywords ';')? (ambiguity) (rule end)
	 *     events+=ErrorBehaviorEvent EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ConnectionErrorKeywords EndConnectionKeywords ';')? (ambiguity) (rule end)
	 *     states+=CompositeState EndCompositeKeywords ';' (ConnectionErrorKeywords EndConnectionKeywords ';')? (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     states+=CompositeState EndCompositeKeywords ';' (ConnectionErrorKeywords EndConnectionKeywords ';')? (ambiguity) (rule end)
	 *     transitions+=ErrorBehaviorTransition EndComponentKeywords ';' (CompositeErrorBehaviorKeywords EndCompositeKeywords ';')? (ConnectionErrorKeywords EndConnectionKeywords ';')? (ambiguity) (rule end)
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' EndConnectionKeywords ';' (ambiguity) 'properties' properties+=EMV2PropertyAssociation
	 *     typeTransformationSet=[TypeTransformationSet|QEMREF] ';' EndConnectionKeywords ';' (ambiguity) (rule end)
	 */
	protected void emit_ErrorModelSubclause___PropagationPathsKeywordsParserRuleCall_9_0_EndPathsKeywordsParserRuleCall_9_3_SemicolonKeyword_9_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
