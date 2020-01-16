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
