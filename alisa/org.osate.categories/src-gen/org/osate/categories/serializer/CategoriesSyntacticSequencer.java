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
	protected AbstractElementAlias match_CategoryFilter_RightSquareBracketKeyword_2_1_a;
	protected AbstractElementAlias match_CategoryFilter_RightSquareBracketKeyword_2_1_p;
	protected AbstractElementAlias match_CategoryFilter___RightSquareBracketKeyword_2_1_a_QualityKeyword_1_0__q;
	protected AbstractElementAlias match_CategoryFilter___RightSquareBracketKeyword_2_1_p_PhaseKeyword_2_0_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (CategoriesGrammarAccess) access;
		match_CategoryFilter_RightSquareBracketKeyword_2_1_a = new TokenAlias(true, true, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_2_1());
		match_CategoryFilter_RightSquareBracketKeyword_2_1_p = new TokenAlias(true, false, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_2_1());
		match_CategoryFilter___RightSquareBracketKeyword_2_1_a_QualityKeyword_1_0__q = new GroupAlias(false, true, new TokenAlias(true, true, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getQualityKeyword_1_0()));
		match_CategoryFilter___RightSquareBracketKeyword_2_1_p_PhaseKeyword_2_0_0__q = new GroupAlias(false, true, new TokenAlias(true, false, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getCategoryFilterAccess().getPhaseKeyword_2_0_0()));
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
			if(match_CategoryFilter_RightSquareBracketKeyword_2_1_a.equals(syntax))
				emit_CategoryFilter_RightSquareBracketKeyword_2_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter_RightSquareBracketKeyword_2_1_p.equals(syntax))
				emit_CategoryFilter_RightSquareBracketKeyword_2_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter___RightSquareBracketKeyword_2_1_a_QualityKeyword_1_0__q.equals(syntax))
				emit_CategoryFilter___RightSquareBracketKeyword_2_1_a_QualityKeyword_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CategoryFilter___RightSquareBracketKeyword_2_1_p_PhaseKeyword_2_0_0__q.equals(syntax))
				emit_CategoryFilter___RightSquareBracketKeyword_2_1_p_PhaseKeyword_2_0_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ']'*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'phase' phaseCategory+=[PhaseCategory|ID]
	 *     (rule start) (ambiguity) 'quality' qualityCategory+=[QualityCategory|ID]
	 *     (rule start) (ambiguity) (rule start)
	 *     (rule start) (ambiguity) name=ID
	 *     anyQualityAttribute?='any' (ambiguity) 'phase' phaseCategory+=[PhaseCategory|ID]
	 *     anyQualityAttribute?='any' (ambiguity) 'quality' qualityCategory+=[QualityCategory|ID]
	 *     anyQualityAttribute?='any' (ambiguity) (rule end)
	 *     anyQualityAttribute?='any' (ambiguity) name=ID
	 *     anyUserSelection?='any' (ambiguity) 'phase' phaseCategory+=[PhaseCategory|ID]
	 *     anyUserSelection?='any' (ambiguity) 'quality' qualityCategory+=[QualityCategory|ID]
	 *     anyUserSelection?='any' (ambiguity) (rule end)
	 *     anyUserSelection?='any' (ambiguity) name=ID
	 *     name=ID '[' (ambiguity) 'phase' phaseCategory+=[PhaseCategory|ID]
	 *     name=ID '[' (ambiguity) 'quality' qualityCategory+=[QualityCategory|ID]
	 *     name=ID '[' (ambiguity) (rule end)
	 *     name=ID '[' (ambiguity) name=ID
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) 'phase' phaseCategory+=[PhaseCategory|ID]
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) (rule end)
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) name=ID
	 *     userCategory+=[UserCategory|ID] (ambiguity) 'phase' phaseCategory+=[PhaseCategory|ID]
	 *     userCategory+=[UserCategory|ID] (ambiguity) 'quality' qualityCategory+=[QualityCategory|ID]
	 *     userCategory+=[UserCategory|ID] (ambiguity) (rule end)
	 *     userCategory+=[UserCategory|ID] (ambiguity) name=ID
	 */
	protected void emit_CategoryFilter_RightSquareBracketKeyword_2_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ']'+
	 *
	 * This ambiguous syntax occurs at:
	 *     anyDevelopmentPhase?='any' (ambiguity) 'phase' phaseCategory+=[PhaseCategory|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) 'quality' qualityCategory+=[QualityCategory|ID]
	 *     anyDevelopmentPhase?='any' (ambiguity) (rule end)
	 *     anyDevelopmentPhase?='any' (ambiguity) name=ID
	 *     phaseCategory+=[PhaseCategory|ID] (ambiguity) 'quality' qualityCategory+=[QualityCategory|ID]
	 *     phaseCategory+=[PhaseCategory|ID] (ambiguity) (rule end)
	 *     phaseCategory+=[PhaseCategory|ID] (ambiguity) name=ID
	 */
	protected void emit_CategoryFilter_RightSquareBracketKeyword_2_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'* 'quality')?
	 *
	 * This ambiguous syntax occurs at:
	 *     qualityCategory+=[QualityCategory|ID] (ambiguity) qualityCategory+=[QualityCategory|ID]
	 */
	protected void emit_CategoryFilter___RightSquareBracketKeyword_2_1_a_QualityKeyword_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     (']'+ 'phase')?
	 *
	 * This ambiguous syntax occurs at:
	 *     phaseCategory+=[PhaseCategory|ID] (ambiguity) phaseCategory+=[PhaseCategory|ID]
	 */
	protected void emit_CategoryFilter___RightSquareBracketKeyword_2_1_p_PhaseKeyword_2_0_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
