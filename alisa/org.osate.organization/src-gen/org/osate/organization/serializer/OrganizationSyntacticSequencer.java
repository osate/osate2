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
package org.osate.organization.serializer;

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
import org.osate.organization.services.OrganizationGrammarAccess;

@SuppressWarnings("all")
public class OrganizationSyntacticSequencer extends AbstractSyntacticSequencer {

	protected OrganizationGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Stakeholder_RightSquareBracketKeyword_1_1_a;
	protected AbstractElementAlias match_Stakeholder_RightSquareBracketKeyword_1_1_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (OrganizationGrammarAccess) access;
		match_Stakeholder_RightSquareBracketKeyword_1_1_a = new TokenAlias(true, true, grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_1_1());
		match_Stakeholder_RightSquareBracketKeyword_1_1_p = new TokenAlias(true, false, grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_1_1());
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
			if (match_Stakeholder_RightSquareBracketKeyword_1_1_a.equals(syntax))
				emit_Stakeholder_RightSquareBracketKeyword_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Stakeholder_RightSquareBracketKeyword_1_1_p.equals(syntax))
				emit_Stakeholder_RightSquareBracketKeyword_1_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ']'*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'stakeholder' name=ID
	 *     (rule start) (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     description=STRING (ambiguity) 'stakeholder' name=ID
	 *     description=STRING (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     description=STRING (ambiguity) (rule end)
	 *     email=STRING (ambiguity) 'stakeholder' name=ID
	 *     email=STRING (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     email=STRING (ambiguity) (rule end)
	 *     fullname=STRING (ambiguity) 'stakeholder' name=ID
	 *     fullname=STRING (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     fullname=STRING (ambiguity) (rule end)
	 *     name=ID '[' (ambiguity) 'stakeholder' name=ID
	 *     name=ID '[' (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     name=ID '[' (ambiguity) (rule end)
	 *     phone=STRING (ambiguity) 'stakeholder' name=ID
	 *     phone=STRING (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     phone=STRING (ambiguity) (rule end)
	 *     role=STRING (ambiguity) 'stakeholder' name=ID
	 *     role=STRING (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     role=STRING (ambiguity) (rule end)
	 *     title=STRING (ambiguity) 'stakeholder' name=ID
	 *     title=STRING (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     title=STRING (ambiguity) (rule end)
	 */
	protected void emit_Stakeholder_RightSquareBracketKeyword_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ']'+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) (rule start)
	 *     supervisor=[Stakeholder|QID] (ambiguity) 'stakeholder' name=ID
	 *     supervisor=[Stakeholder|QID] (ambiguity) 'supervisor' supervisor=[Stakeholder|QID]
	 *     supervisor=[Stakeholder|QID] (ambiguity) (rule end)
	 */
	protected void emit_Stakeholder_RightSquareBracketKeyword_1_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
