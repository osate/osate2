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
package org.osate.categories.serializer;

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
import org.osate.categories.services.CategoriesGrammarAccess;

@SuppressWarnings("all")
public class CategoriesSyntacticSequencer extends AbstractSyntacticSequencer {

	protected CategoriesGrammarAccess grammarAccess;
	protected AbstractElementAlias match_CategoryFilter_RightSquareBracketKeyword_4_1_a;
	protected AbstractElementAlias match_CategoryFilter_RightSquareBracketKeyword_4_1_p;
	protected AbstractElementAlias match_CategoryFilter___RightSquareBracketKeyword_4_1_a_MethodKeyword_1_0_TypeKeyword_1_1__q;
	protected AbstractElementAlias match_CategoryFilter___RightSquareBracketKeyword_4_1_a_QualityKeyword_3_0_AttributeKeyword_3_1__q;
	protected AbstractElementAlias match_CategoryFilter___RightSquareBracketKeyword_4_1_a_UserKeyword_2_0_SelectionKeyword_2_1__q;
	protected AbstractElementAlias match_CategoryFilter___RightSquareBracketKeyword_4_1_p_DevelopmentKeyword_4_0_0_PhaseKeyword_4_0_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CategoriesGrammarAccess) access;
		match_CategoryFilter_RightSquareBracketKeyword_4_1_a = new TokenAlias(true, true, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_4_1());
		match_CategoryFilter_RightSquareBracketKeyword_4_1_p = new TokenAlias(true, false, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_4_1());
		match_CategoryFilter___RightSquareBracketKeyword_4_1_a_MethodKeyword_1_0_TypeKeyword_1_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getMethodKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getTypeKeyword_1_1()));
		match_CategoryFilter___RightSquareBracketKeyword_4_1_a_QualityKeyword_3_0_AttributeKeyword_3_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getQualityKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getAttributeKeyword_3_1()));
		match_CategoryFilter___RightSquareBracketKeyword_4_1_a_UserKeyword_2_0_SelectionKeyword_2_1__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getUserKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getSelectionKeyword_2_1()));
		match_CategoryFilter___RightSquareBracketKeyword_4_1_p_DevelopmentKeyword_4_0_0_PhaseKeyword_4_0_1__q = new GroupAlias(false, true, new TokenAlias(true, false, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getDevelopmentKeyword_4_0_0()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getPhaseKeyword_4_0_1()));
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
			if(match_CategoryFilter_RightSquareBracketKeyword_4_1_a.equals(syntax))
				emit_CategoryFilter_RightSquareBracketKeyword_4_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter_RightSquareBracketKeyword_4_1_p.equals(syntax))
				emit_CategoryFilter_RightSquareBracketKeyword_4_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter___RightSquareBracketKeyword_4_1_a_MethodKeyword_1_0_TypeKeyword_1_1__q.equals(syntax))
				emit_CategoryFilter___RightSquareBracketKeyword_4_1_a_MethodKeyword_1_0_TypeKeyword_1_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter___RightSquareBracketKeyword_4_1_a_QualityKeyword_3_0_AttributeKeyword_3_1__q.equals(syntax))
				emit_CategoryFilter___RightSquareBracketKeyword_4_1_a_QualityKeyword_3_0_AttributeKeyword_3_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter___RightSquareBracketKeyword_4_1_a_UserKeyword_2_0_SelectionKeyword_2_1__q.equals(syntax))
				emit_CategoryFilter___RightSquareBracketKeyword_4_1_a_UserKeyword_2_0_SelectionKeyword_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter___RightSquareBracketKeyword_4_1_p_DevelopmentKeyword_4_0_0_PhaseKeyword_4_0_1__q.equals(syntax))
				emit_CategoryFilter___RightSquareBracketKeyword_4_1_p_DevelopmentKeyword_4_0_0_PhaseKeyword_4_0_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ']'*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     (rule start) (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     (rule start) (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     (rule start) (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     (rule start) (ambiguity) (rule start)
	 *     (rule start) (ambiguity) name=ID
	 *     anyMethodType?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyMethodType?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyMethodType?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyMethodType?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyMethodType?='any' (ambiguity) (rule end)
	 *     anyMethodType?='any' (ambiguity) name=ID
	 *     anyQualityAttribute?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyQualityAttribute?='any' (ambiguity) (rule end)
	 *     anyQualityAttribute?='any' (ambiguity) name=ID
	 *     anyRequirementType?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyRequirementType?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyRequirementType?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyRequirementType?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyRequirementType?='any' (ambiguity) (rule end)
	 *     anyRequirementType?='any' (ambiguity) name=ID
	 *     anyUserSelection?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyUserSelection?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyUserSelection?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyUserSelection?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyUserSelection?='any' (ambiguity) (rule end)
	 *     anyUserSelection?='any' (ambiguity) name=ID
	 *     methodType+=[MethodType|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     methodType+=[MethodType|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     methodType+=[MethodType|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     methodType+=[MethodType|ID] (ambiguity) (rule end)
	 *     methodType+=[MethodType|ID] (ambiguity) name=ID
	 *     name=ID '[' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     name=ID '[' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     name=ID '[' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     name=ID '[' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     name=ID '[' (ambiguity) (rule end)
	 *     name=ID '[' (ambiguity) name=ID
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) (rule end)
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) name=ID
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     requirementType+=[RequirementType|ID] (ambiguity) (rule end)
	 *     requirementType+=[RequirementType|ID] (ambiguity) name=ID
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     userSelection+=[UserSelection|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     userSelection+=[UserSelection|ID] (ambiguity) (rule end)
	 *     userSelection+=[UserSelection|ID] (ambiguity) name=ID
	 */
	protected void emit_CategoryFilter_RightSquareBracketKeyword_4_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ']'+
	 *
	 * This ambiguous syntax occurs at:
	 *     anyDevelopmentPhase?='any' (ambiguity) 'development' 'phase' developmentPhase+=[DevelopmentPhase|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) (rule end)
	 *     anyDevelopmentPhase?='any' (ambiguity) name=ID
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'method' 'type' methodType+=[MethodType|ID]
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'quality' 'attribute' qualityAttribute+=[QualityAttribute|ID]
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) 'user' 'selection' userSelection+=[UserSelection|ID]
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) (rule end)
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) name=ID
	 */
	protected void emit_CategoryFilter_RightSquareBracketKeyword_4_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'* 'method' 'type')?
	 *
	 * This ambiguous syntax occurs at:
	 *     methodType+=[MethodType|ID] (ambiguity) methodType+=[MethodType|ID]
	 */
	protected void emit_CategoryFilter___RightSquareBracketKeyword_4_1_a_MethodKeyword_1_0_TypeKeyword_1_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'* 'quality' 'attribute')?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityAttribute+=[QualityAttribute|ID] (ambiguity) qualityAttribute+=[QualityAttribute|ID]
	 */
	protected void emit_CategoryFilter___RightSquareBracketKeyword_4_1_a_QualityKeyword_3_0_AttributeKeyword_3_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'* 'user' 'selection')?
	 *
	 * This ambiguous syntax occurs at:
	 *     userSelection+=[UserSelection|ID] (ambiguity) userSelection+=[UserSelection|ID]
	 */
	protected void emit_CategoryFilter___RightSquareBracketKeyword_4_1_a_UserKeyword_2_0_SelectionKeyword_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'+ 'development' 'phase')?
	 *
	 * This ambiguous syntax occurs at:
	 *     developmentPhase+=[DevelopmentPhase|ID] (ambiguity) developmentPhase+=[DevelopmentPhase|ID]
	 */
	protected void emit_CategoryFilter___RightSquareBracketKeyword_4_1_p_DevelopmentKeyword_4_0_0_PhaseKeyword_4_0_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
