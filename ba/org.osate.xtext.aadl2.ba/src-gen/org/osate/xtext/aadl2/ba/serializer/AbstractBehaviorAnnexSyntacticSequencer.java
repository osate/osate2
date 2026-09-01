/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.serializer;

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
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractBehaviorAnnexSyntacticSequencer extends AbstractSyntacticSequencer {

    protected BehaviorAnnexGrammarAccess grammarAccess;
    protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_2_0_a;
    protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_2_0_p;

    @Inject
    protected void init(IGrammarAccess access) {
        grammarAccess = (BehaviorAnnexGrammarAccess) access;
        match_PrimaryExpression_LeftParenthesisKeyword_2_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());
        match_PrimaryExpression_LeftParenthesisKeyword_2_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());
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
            if (match_PrimaryExpression_LeftParenthesisKeyword_2_0_a.equals(syntax))
                emit_PrimaryExpression_LeftParenthesisKeyword_2_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
            else if (match_PrimaryExpression_LeftParenthesisKeyword_2_0_p.equals(syntax))
                emit_PrimaryExpression_LeftParenthesisKeyword_2_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
            else acceptNodes(getLastNavigableState(), syntaxNodes);
        }
    }

    /**
     * <pre>
     * Ambiguous syntax:
     *     '('*
     *
     * This ambiguous syntax occurs at:
     *     (rule start) (ambiguity) '#' property=QualifiedName
     *     (rule start) (ambiguity) 'false' (rule start)
     *     (rule start) (ambiguity) operator='+'
     *     (rule start) (ambiguity) operator='-'
     *     (rule start) (ambiguity) operator='abs'
     *     (rule start) (ambiguity) operator='not'
     *     (rule start) (ambiguity) reference=Reference
     *     (rule start) (ambiguity) value=INTEGER_LIT
     *     (rule start) (ambiguity) value=REAL_LIT
     *     (rule start) (ambiguity) value=STRING
     *     (rule start) (ambiguity) value?='true'
     *     (rule start) (ambiguity) {BinaryExpression.left=}

     * </pre>
     */
    protected void emit_PrimaryExpression_LeftParenthesisKeyword_2_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
        acceptNodes(transition, nodes);
    }

    /**
     * <pre>
     * Ambiguous syntax:
     *     '('+
     *
     * This ambiguous syntax occurs at:
     *     (rule start) (ambiguity) operator='+'
     *     (rule start) (ambiguity) operator='-'
     *     (rule start) (ambiguity) operator='abs'
     *     (rule start) (ambiguity) operator='not'
     *     (rule start) (ambiguity) {BinaryExpression.left=}

     * </pre>
     */
    protected void emit_PrimaryExpression_LeftParenthesisKeyword_2_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
        acceptNodes(transition, nodes);
    }

}
