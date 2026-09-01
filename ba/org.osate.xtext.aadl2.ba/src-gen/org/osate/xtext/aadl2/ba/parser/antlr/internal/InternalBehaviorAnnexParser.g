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
parser grammar InternalBehaviorAnnexParser;

options {
    tokenVocab=InternalBehaviorAnnexLexer;
    superClass=AbstractInternalAntlrParser;
}

@header {
package org.osate.xtext.aadl2.ba.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;

}

@members {

     private BehaviorAnnexGrammarAccess grammarAccess;

    public InternalBehaviorAnnexParser(TokenStream input, BehaviorAnnexGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
        return "AnnexSubclause";
       }

       @Override
       protected BehaviorAnnexGrammarAccess getGrammarAccess() {
           return grammarAccess;
       }

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleAnnexSubclause
entryRuleAnnexSubclause returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getAnnexSubclauseRule()); }
    iv_ruleAnnexSubclause=ruleAnnexSubclause
    { $current=$iv_ruleAnnexSubclause.current; }
    EOF;

// Rule AnnexSubclause
ruleAnnexSubclause returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    {
        newCompositeNode(grammarAccess.getAnnexSubclauseAccess().getBehaviorAnnexParserRuleCall());
    }
    this_BehaviorAnnex_0=ruleBehaviorAnnex
    {
        $current = $this_BehaviorAnnex_0.current;
        afterParserOrEnumRuleCall();
    }
;

// Entry rule entryRuleBehaviorAnnex
entryRuleBehaviorAnnex returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorAnnexRule()); }
    iv_ruleBehaviorAnnex=ruleBehaviorAnnex
    { $current=$iv_ruleBehaviorAnnex.current; }
    EOF;

// Rule BehaviorAnnex
ruleBehaviorAnnex returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                $current = forceCreateModelElement(
                    grammarAccess.getBehaviorAnnexAccess().getBehaviorAnnexAction_0(),
                    $current);
            }
        )
        (
            otherlv_1=Variables
            {
                newLeafNode(otherlv_1, grammarAccess.getBehaviorAnnexAccess().getVariablesKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorAnnexAccess().getVariableGroupsBehaviorVariableGroupParserRuleCall_1_1_0());
                    }
                    lv_variableGroups_2_0=ruleBehaviorVariableGroup
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorAnnexRule());
                        }
                        add(
                            $current,
                            "variableGroups",
                            lv_variableGroups_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariableGroup");
                        afterParserOrEnumRuleCall();
                    }
                )
            )+
        )?
        (
            otherlv_3=States
            {
                newLeafNode(otherlv_3, grammarAccess.getBehaviorAnnexAccess().getStatesKeyword_2_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorAnnexAccess().getStateGroupsBehaviorStateGroupParserRuleCall_2_1_0());
                    }
                    lv_stateGroups_4_0=ruleBehaviorStateGroup
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorAnnexRule());
                        }
                        add(
                            $current,
                            "stateGroups",
                            lv_stateGroups_4_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorStateGroup");
                        afterParserOrEnumRuleCall();
                    }
                )
            )+
        )?
        (
            otherlv_5=Transitions
            {
                newLeafNode(otherlv_5, grammarAccess.getBehaviorAnnexAccess().getTransitionsKeyword_3_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorAnnexAccess().getTransitionsBehaviorTransitionParserRuleCall_3_1_0());
                    }
                    lv_transitions_6_0=ruleBehaviorTransition
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorAnnexRule());
                        }
                        add(
                            $current,
                            "transitions",
                            lv_transitions_6_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTransition");
                        afterParserOrEnumRuleCall();
                    }
                )
            )+
        )?
    )
;

// Entry rule entryRuleBehaviorVariableGroup
entryRuleBehaviorVariableGroup returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorVariableGroupRule()); }
    iv_ruleBehaviorVariableGroup=ruleBehaviorVariableGroup
    { $current=$iv_ruleBehaviorVariableGroup.current; }
    EOF;

// Rule BehaviorVariableGroup
ruleBehaviorVariableGroup returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getVariablesBehaviorVariableParserRuleCall_0_0());
                }
                lv_variables_0_0=ruleBehaviorVariable
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
                    }
                    add(
                        $current,
                        "variables",
                        lv_variables_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariable");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=Comma
            {
                newLeafNode(otherlv_1, grammarAccess.getBehaviorVariableGroupAccess().getCommaKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getVariablesBehaviorVariableParserRuleCall_1_1_0());
                    }
                    lv_variables_2_0=ruleBehaviorVariable
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
                        }
                        add(
                            $current,
                            "variables",
                            lv_variables_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariable");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
        otherlv_3=Colon
        {
            newLeafNode(otherlv_3, grammarAccess.getBehaviorVariableGroupAccess().getColonKeyword_2());
        }
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorVariableGroupRule());
                    }
                }
                {
                    newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getDataClassifierComponentClassifierCrossReference_3_0());
                }
                ruleQCREF
                {
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_5=ColonEqualsSign
            {
                newLeafNode(otherlv_5, grammarAccess.getBehaviorVariableGroupAccess().getColonEqualsSignKeyword_4_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getInitialValueValueConstantParserRuleCall_4_1_0());
                    }
                    lv_initialValue_6_0=ruleValueConstant
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
                        }
                        set(
                            $current,
                            "initialValue",
                            lv_initialValue_6_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueConstant");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
        (
            otherlv_7=LeftCurlyBracket
            {
                newLeafNode(otherlv_7, grammarAccess.getBehaviorVariableGroupAccess().getLeftCurlyBracketKeyword_5_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorVariableGroupAccess().getPropertyAssociationsBehaviorPropertyAssociationParserRuleCall_5_1_0());
                    }
                    lv_propertyAssociations_8_0=ruleBehaviorPropertyAssociation
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorVariableGroupRule());
                        }
                        add(
                            $current,
                            "propertyAssociations",
                            lv_propertyAssociations_8_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorPropertyAssociation");
                        afterParserOrEnumRuleCall();
                    }
                )
            )+
            otherlv_9=RightCurlyBracket
            {
                newLeafNode(otherlv_9, grammarAccess.getBehaviorVariableGroupAccess().getRightCurlyBracketKeyword_5_2());
            }
        )?
        otherlv_10=Semicolon
        {
            newLeafNode(otherlv_10, grammarAccess.getBehaviorVariableGroupAccess().getSemicolonKeyword_6());
        }
    )
;

// Entry rule entryRuleBehaviorVariable
entryRuleBehaviorVariable returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorVariableRule()); }
    iv_ruleBehaviorVariable=ruleBehaviorVariable
    { $current=$iv_ruleBehaviorVariable.current; }
    EOF;

// Rule BehaviorVariable
ruleBehaviorVariable returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                lv_name_0_0=RULE_ID
                {
                    newLeafNode(lv_name_0_0, grammarAccess.getBehaviorVariableAccess().getNameIDTerminalRuleCall_0_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorVariableRule());
                    }
                    setWithLastConsumed(
                        $current,
                        "name",
                        lv_name_0_0,
                        "org.osate.xtext.aadl2.properties.Properties.ID");
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorVariableAccess().getArrayDimensionsArrayDimensionParserRuleCall_1_0());
                }
                lv_arrayDimensions_1_0=ruleArrayDimension
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorVariableRule());
                    }
                    add(
                        $current,
                        "arrayDimensions",
                        lv_arrayDimensions_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ArrayDimension");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
    )
;

// Entry rule entryRuleArrayDimension
entryRuleArrayDimension returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getArrayDimensionRule()); }
    iv_ruleArrayDimension=ruleArrayDimension
    { $current=$iv_ruleArrayDimension.current; }
    EOF;

// Rule ArrayDimension
ruleArrayDimension returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=LeftSquareBracket
        {
            newLeafNode(otherlv_0, grammarAccess.getArrayDimensionAccess().getLeftSquareBracketKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getArrayDimensionAccess().getSizeIntegerValueParserRuleCall_1_0());
                }
                lv_size_1_0=ruleIntegerValue
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getArrayDimensionRule());
                    }
                    set(
                        $current,
                        "size",
                        lv_size_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_2=RightSquareBracket
        {
            newLeafNode(otherlv_2, grammarAccess.getArrayDimensionAccess().getRightSquareBracketKeyword_2());
        }
    )
;

// Entry rule entryRuleBehaviorPropertyAssociation
entryRuleBehaviorPropertyAssociation returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorPropertyAssociationRule()); }
    iv_ruleBehaviorPropertyAssociation=ruleBehaviorPropertyAssociation
    { $current=$iv_ruleBehaviorPropertyAssociation.current; }
    EOF;

// Rule BehaviorPropertyAssociation
ruleBehaviorPropertyAssociation returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorPropertyAssociationRule());
                    }
                }
                {
                    newCompositeNode(grammarAccess.getBehaviorPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
                }
                ruleQPREF
                {
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_1=EqualsSignGreaterThanSign
        {
            newLeafNode(otherlv_1, grammarAccess.getBehaviorPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
                }
                lv_ownedValue_2_0=rulePropertyExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorPropertyAssociationRule());
                    }
                    set(
                        $current,
                        "ownedValue",
                        lv_ownedValue_2_0,
                        "org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_3=Semicolon
        {
            newLeafNode(otherlv_3, grammarAccess.getBehaviorPropertyAssociationAccess().getSemicolonKeyword_3());
        }
    )
;

// Entry rule entryRuleBehaviorStateGroup
entryRuleBehaviorStateGroup returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorStateGroupRule()); }
    iv_ruleBehaviorStateGroup=ruleBehaviorStateGroup
    { $current=$iv_ruleBehaviorStateGroup.current; }
    EOF;

// Rule BehaviorStateGroup
ruleBehaviorStateGroup returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorStateGroupAccess().getStatesBehaviorStateParserRuleCall_0_0());
                }
                lv_states_0_0=ruleBehaviorState
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorStateGroupRule());
                    }
                    add(
                        $current,
                        "states",
                        lv_states_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorState");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=Comma
            {
                newLeafNode(otherlv_1, grammarAccess.getBehaviorStateGroupAccess().getCommaKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorStateGroupAccess().getStatesBehaviorStateParserRuleCall_1_1_0());
                    }
                    lv_states_2_0=ruleBehaviorState
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorStateGroupRule());
                        }
                        add(
                            $current,
                            "states",
                            lv_states_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorState");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
        otherlv_3=Colon
        {
            newLeafNode(otherlv_3, grammarAccess.getBehaviorStateGroupAccess().getColonKeyword_2());
        }
        (
            (
                lv_initial_4_0=Initial
                {
                    newLeafNode(lv_initial_4_0, grammarAccess.getBehaviorStateGroupAccess().getInitialInitialKeyword_3_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorStateGroupRule());
                    }
                    setWithLastConsumed($current, "initial", lv_initial_4_0 != null, "initial");
                }
            )
        )?
        (
            (
                lv_complete_5_0=Complete
                {
                    newLeafNode(lv_complete_5_0, grammarAccess.getBehaviorStateGroupAccess().getCompleteCompleteKeyword_4_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorStateGroupRule());
                    }
                    setWithLastConsumed($current, "complete", lv_complete_5_0 != null, "complete");
                }
            )
        )?
        (
            (
                lv_final_6_0=Final
                {
                    newLeafNode(lv_final_6_0, grammarAccess.getBehaviorStateGroupAccess().getFinalFinalKeyword_5_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorStateGroupRule());
                    }
                    setWithLastConsumed($current, "final", lv_final_6_0 != null, "final");
                }
            )
        )?
        otherlv_7=State
        {
            newLeafNode(otherlv_7, grammarAccess.getBehaviorStateGroupAccess().getStateKeyword_6());
        }
        otherlv_8=Semicolon
        {
            newLeafNode(otherlv_8, grammarAccess.getBehaviorStateGroupAccess().getSemicolonKeyword_7());
        }
    )
;

// Entry rule entryRuleBehaviorState
entryRuleBehaviorState returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorStateRule()); }
    iv_ruleBehaviorState=ruleBehaviorState
    { $current=$iv_ruleBehaviorState.current; }
    EOF;

// Rule BehaviorState
ruleBehaviorState returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            lv_name_0_0=RULE_ID
            {
                newLeafNode(lv_name_0_0, grammarAccess.getBehaviorStateAccess().getNameIDTerminalRuleCall_0());
            }
            {
                if ($current==null) {
                    $current = createModelElement(grammarAccess.getBehaviorStateRule());
                }
                setWithLastConsumed(
                    $current,
                    "name",
                    lv_name_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.ID");
            }
        )
    )
;

// Entry rule entryRuleBehaviorTransition
entryRuleBehaviorTransition returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorTransitionRule()); }
    iv_ruleBehaviorTransition=ruleBehaviorTransition
    { $current=$iv_ruleBehaviorTransition.current; }
    EOF;

// Rule BehaviorTransition
ruleBehaviorTransition returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                (
                    lv_name_0_0=RULE_ID
                    {
                        newLeafNode(lv_name_0_0, grammarAccess.getBehaviorTransitionAccess().getNameIDTerminalRuleCall_0_0_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getBehaviorTransitionRule());
                        }
                        setWithLastConsumed(
                            $current,
                            "name",
                            lv_name_0_0,
                            "org.osate.xtext.aadl2.properties.Properties.ID");
                    }
                )
            )
            (
                otherlv_1=LeftSquareBracket
                {
                    newLeafNode(otherlv_1, grammarAccess.getBehaviorTransitionAccess().getLeftSquareBracketKeyword_0_1_0());
                }
                (
                    (
                        lv_priority_2_0=RULE_INTEGER_LIT
                        {
                            newLeafNode(lv_priority_2_0, grammarAccess.getBehaviorTransitionAccess().getPriorityINTEGER_LITTerminalRuleCall_0_1_1_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getBehaviorTransitionRule());
                            }
                            setWithLastConsumed(
                                $current,
                                "priority",
                                lv_priority_2_0,
                                "org.osate.xtext.aadl2.properties.Properties.INTEGER_LIT");
                        }
                    )
                )
                otherlv_3=RightSquareBracket
                {
                    newLeafNode(otherlv_3, grammarAccess.getBehaviorTransitionAccess().getRightSquareBracketKeyword_0_1_2());
                }
            )?
            otherlv_4=Colon
            {
                newLeafNode(otherlv_4, grammarAccess.getBehaviorTransitionAccess().getColonKeyword_0_2());
            }
        )?
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorTransitionRule());
                    }
                }
                otherlv_5=RULE_ID
                {
                    newLeafNode(otherlv_5, grammarAccess.getBehaviorTransitionAccess().getSourceStatesBehaviorStateCrossReference_1_0());
                }
            )
        )
        (
            otherlv_6=Comma
            {
                newLeafNode(otherlv_6, grammarAccess.getBehaviorTransitionAccess().getCommaKeyword_2_0());
            }
            (
                (
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getBehaviorTransitionRule());
                        }
                    }
                    otherlv_7=RULE_ID
                    {
                        newLeafNode(otherlv_7, grammarAccess.getBehaviorTransitionAccess().getSourceStatesBehaviorStateCrossReference_2_1_0());
                    }
                )
            )
        )*
        otherlv_8=HyphenMinusLeftSquareBracket
        {
            newLeafNode(otherlv_8, grammarAccess.getBehaviorTransitionAccess().getHyphenMinusLeftSquareBracketKeyword_3());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorTransitionAccess().getConditionBehaviorConditionParserRuleCall_4_0());
                }
                lv_condition_9_0=ruleBehaviorCondition
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorTransitionRule());
                    }
                    set(
                        $current,
                        "condition",
                        lv_condition_9_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorCondition");
                    afterParserOrEnumRuleCall();
                }
            )
        )?
        otherlv_10=RightSquareBracketHyphenMinusGreaterThanSign
        {
            newLeafNode(otherlv_10, grammarAccess.getBehaviorTransitionAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_5());
        }
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorTransitionRule());
                    }
                }
                otherlv_11=RULE_ID
                {
                    newLeafNode(otherlv_11, grammarAccess.getBehaviorTransitionAccess().getDestinationStateBehaviorStateCrossReference_6_0());
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorTransitionAccess().getActionBlockBehaviorActionBlockParserRuleCall_7_0());
                }
                lv_actionBlock_12_0=ruleBehaviorActionBlock
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorTransitionRule());
                    }
                    set(
                        $current,
                        "actionBlock",
                        lv_actionBlock_12_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActionBlock");
                    afterParserOrEnumRuleCall();
                }
            )
        )?
        otherlv_13=Semicolon
        {
            newLeafNode(otherlv_13, grammarAccess.getBehaviorTransitionAccess().getSemicolonKeyword_8());
        }
    )
;

// Entry rule entryRuleBehaviorCondition
entryRuleBehaviorCondition returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorConditionRule()); }
    iv_ruleBehaviorCondition=ruleBehaviorCondition
    { $current=$iv_ruleBehaviorCondition.current; }
    EOF;

// Rule BehaviorCondition
ruleBehaviorCondition returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            otherlv_0=On
            {
                newLeafNode(otherlv_0, grammarAccess.getBehaviorConditionAccess().getOnKeyword_0_0());
            }
            (
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getBehaviorConditionAccess().getDispatchDispatchConditionParserRuleCall_0_1_0_0());
                        }
                        lv_dispatch_1_0=ruleDispatchCondition
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                            }
                            set(
                                $current,
                                "dispatch",
                                lv_dispatch_1_0,
                                "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchCondition");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
                    |
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getBehaviorConditionAccess().getModeSwitchModeSwitchConditionParserRuleCall_0_1_1_0());
                        }
                        lv_modeSwitch_2_0=ruleModeSwitchCondition
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                            }
                            set(
                                $current,
                                "modeSwitch",
                                lv_modeSwitch_2_0,
                                "org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchCondition");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
            )
        )
            |
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorConditionAccess().getExecuteExecuteConditionParserRuleCall_1_0());
                }
                lv_execute_3_0=ruleExecuteCondition
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorConditionRule());
                    }
                    set(
                        $current,
                        "execute",
                        lv_execute_3_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ExecuteCondition");
                    afterParserOrEnumRuleCall();
                }
            )
        )
    )
;

// Entry rule entryRuleExecuteCondition
entryRuleExecuteCondition returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getExecuteConditionRule()); }
    iv_ruleExecuteCondition=ruleExecuteCondition
    { $current=$iv_ruleExecuteCondition.current; }
    EOF;

// Rule ExecuteCondition
ruleExecuteCondition returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getExecuteConditionAccess().getValueValueExpressionParserRuleCall_0_0());
                }
                lv_value_0_0=ruleValueExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getExecuteConditionRule());
                    }
                    set(
                        $current,
                        "value",
                        lv_value_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
            |
        (
            (
                lv_timeout_1_0=Timeout
                {
                    newLeafNode(lv_timeout_1_0, grammarAccess.getExecuteConditionAccess().getTimeoutTimeoutKeyword_1_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getExecuteConditionRule());
                    }
                    setWithLastConsumed($current, "timeout", lv_timeout_1_0 != null, "timeout");
                }
            )
        )
            |
        (
            (
                lv_otherwise_2_0=Otherwise
                {
                    newLeafNode(lv_otherwise_2_0, grammarAccess.getExecuteConditionAccess().getOtherwiseOtherwiseKeyword_2_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getExecuteConditionRule());
                    }
                    setWithLastConsumed($current, "otherwise", lv_otherwise_2_0 != null, "otherwise");
                }
            )
        )
    )
;

// Entry rule entryRuleDispatchCondition
entryRuleDispatchCondition returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getDispatchConditionRule()); }
    iv_ruleDispatchCondition=ruleDispatchCondition
    { $current=$iv_ruleDispatchCondition.current; }
    EOF;

// Rule DispatchCondition
ruleDispatchCondition returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=Dispatch
        {
            newLeafNode(otherlv_0, grammarAccess.getDispatchConditionAccess().getDispatchKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getDispatchConditionAccess().getTriggerDispatchTriggerConditionParserRuleCall_1_0());
                }
                lv_trigger_1_0=ruleDispatchTriggerCondition
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                    }
                    set(
                        $current,
                        "trigger",
                        lv_trigger_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchTriggerCondition");
                    afterParserOrEnumRuleCall();
                }
            )
        )?
        (
            otherlv_2=Frozen
            {
                newLeafNode(otherlv_2, grammarAccess.getDispatchConditionAccess().getFrozenKeyword_2_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getDispatchConditionAccess().getFrozenPortsReferenceParserRuleCall_2_1_0());
                    }
                    lv_frozenPorts_3_0=ruleReference
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                        }
                        add(
                            $current,
                            "frozenPorts",
                            lv_frozenPorts_3_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
            (
                otherlv_4=Comma
                {
                    newLeafNode(otherlv_4, grammarAccess.getDispatchConditionAccess().getCommaKeyword_2_2_0());
                }
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getDispatchConditionAccess().getFrozenPortsReferenceParserRuleCall_2_2_1_0());
                        }
                        lv_frozenPorts_5_0=ruleReference
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getDispatchConditionRule());
                            }
                            add(
                                $current,
                                "frozenPorts",
                                lv_frozenPorts_5_0,
                                "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
            )*
        )?
    )
;

// Entry rule entryRuleDispatchTriggerCondition
entryRuleDispatchTriggerCondition returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getDispatchTriggerConditionRule()); }
    iv_ruleDispatchTriggerCondition=ruleDispatchTriggerCondition
    { $current=$iv_ruleDispatchTriggerCondition.current; }
    EOF;

// Rule DispatchTriggerCondition
ruleDispatchTriggerCondition returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getDispatchTriggerConditionAccess().getExpressionDispatchTriggerLogicalExpressionParserRuleCall_0_0());
                }
                lv_expression_0_0=ruleDispatchTriggerLogicalExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getDispatchTriggerConditionRule());
                    }
                    set(
                        $current,
                        "expression",
                        lv_expression_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchTriggerLogicalExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
            |
        (
            (
                (
                    lv_timeout_1_0=Timeout
                    {
                        newLeafNode(lv_timeout_1_0, grammarAccess.getDispatchTriggerConditionAccess().getTimeoutTimeoutKeyword_1_0_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getDispatchTriggerConditionRule());
                        }
                        setWithLastConsumed($current, "timeout", lv_timeout_1_0 != null, "timeout");
                    }
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getDispatchTriggerConditionAccess().getTimeBehaviorTimeParserRuleCall_1_1_0());
                    }
                    lv_time_2_0=ruleBehaviorTime
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getDispatchTriggerConditionRule());
                        }
                        set(
                            $current,
                            "time",
                            lv_time_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
                        afterParserOrEnumRuleCall();
                    }
                )
            )?
        )
            |
        (
            (
                lv_stop_3_0=Stop
                {
                    newLeafNode(lv_stop_3_0, grammarAccess.getDispatchTriggerConditionAccess().getStopStopKeyword_2_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getDispatchTriggerConditionRule());
                    }
                    setWithLastConsumed($current, "stop", lv_stop_3_0 != null, "stop");
                }
            )
        )
    )
;

// Entry rule entryRuleDispatchTriggerLogicalExpression
entryRuleDispatchTriggerLogicalExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionRule()); }
    iv_ruleDispatchTriggerLogicalExpression=ruleDispatchTriggerLogicalExpression
    { $current=$iv_ruleDispatchTriggerLogicalExpression.current; }
    EOF;

// Rule DispatchTriggerLogicalExpression
ruleDispatchTriggerLogicalExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsDispatchConjunctionParserRuleCall_0_0());
                }
                lv_conjunctions_0_0=ruleDispatchConjunction
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getDispatchTriggerLogicalExpressionRule());
                    }
                    add(
                        $current,
                        "conjunctions",
                        lv_conjunctions_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchConjunction");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=Or
            {
                newLeafNode(otherlv_1, grammarAccess.getDispatchTriggerLogicalExpressionAccess().getOrKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsDispatchConjunctionParserRuleCall_1_1_0());
                    }
                    lv_conjunctions_2_0=ruleDispatchConjunction
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getDispatchTriggerLogicalExpressionRule());
                        }
                        add(
                            $current,
                            "conjunctions",
                            lv_conjunctions_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchConjunction");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRuleDispatchConjunction
entryRuleDispatchConjunction returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getDispatchConjunctionRule()); }
    iv_ruleDispatchConjunction=ruleDispatchConjunction
    { $current=$iv_ruleDispatchConjunction.current; }
    EOF;

// Rule DispatchConjunction
ruleDispatchConjunction returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getDispatchConjunctionAccess().getTriggersReferenceParserRuleCall_0_0());
                }
                lv_triggers_0_0=ruleReference
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getDispatchConjunctionRule());
                    }
                    add(
                        $current,
                        "triggers",
                        lv_triggers_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=And
            {
                newLeafNode(otherlv_1, grammarAccess.getDispatchConjunctionAccess().getAndKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getDispatchConjunctionAccess().getTriggersReferenceParserRuleCall_1_1_0());
                    }
                    lv_triggers_2_0=ruleReference
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getDispatchConjunctionRule());
                        }
                        add(
                            $current,
                            "triggers",
                            lv_triggers_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRuleModeSwitchCondition
entryRuleModeSwitchCondition returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getModeSwitchConditionRule()); }
    iv_ruleModeSwitchCondition=ruleModeSwitchCondition
    { $current=$iv_ruleModeSwitchCondition.current; }
    EOF;

// Rule ModeSwitchCondition
ruleModeSwitchCondition returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getConjunctionsModeSwitchConjunctionParserRuleCall_0_0());
                }
                lv_conjunctions_0_0=ruleModeSwitchConjunction
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getModeSwitchConditionRule());
                    }
                    add(
                        $current,
                        "conjunctions",
                        lv_conjunctions_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchConjunction");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=Or
            {
                newLeafNode(otherlv_1, grammarAccess.getModeSwitchConditionAccess().getOrKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getModeSwitchConditionAccess().getConjunctionsModeSwitchConjunctionParserRuleCall_1_1_0());
                    }
                    lv_conjunctions_2_0=ruleModeSwitchConjunction
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getModeSwitchConditionRule());
                        }
                        add(
                            $current,
                            "conjunctions",
                            lv_conjunctions_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchConjunction");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRuleModeSwitchConjunction
entryRuleModeSwitchConjunction returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getModeSwitchConjunctionRule()); }
    iv_ruleModeSwitchConjunction=ruleModeSwitchConjunction
    { $current=$iv_ruleModeSwitchConjunction.current; }
    EOF;

// Rule ModeSwitchConjunction
ruleModeSwitchConjunction returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersReferenceParserRuleCall_0_0());
                }
                lv_triggers_0_0=ruleReference
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getModeSwitchConjunctionRule());
                    }
                    add(
                        $current,
                        "triggers",
                        lv_triggers_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=And
            {
                newLeafNode(otherlv_1, grammarAccess.getModeSwitchConjunctionAccess().getAndKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getModeSwitchConjunctionAccess().getTriggersReferenceParserRuleCall_1_1_0());
                    }
                    lv_triggers_2_0=ruleReference
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getModeSwitchConjunctionRule());
                        }
                        add(
                            $current,
                            "triggers",
                            lv_triggers_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRuleBehaviorActionBlock
entryRuleBehaviorActionBlock returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorActionBlockRule()); }
    iv_ruleBehaviorActionBlock=ruleBehaviorActionBlock
    { $current=$iv_ruleBehaviorActionBlock.current; }
    EOF;

// Rule BehaviorActionBlock
ruleBehaviorActionBlock returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=LeftCurlyBracket
        {
            newLeafNode(otherlv_0, grammarAccess.getBehaviorActionBlockAccess().getLeftCurlyBracketKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorActionBlockAccess().getContentBehaviorActionsParserRuleCall_1_0());
                }
                lv_content_1_0=ruleBehaviorActions
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorActionBlockRule());
                    }
                    set(
                        $current,
                        "content",
                        lv_content_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_2=RightCurlyBracket
        {
            newLeafNode(otherlv_2, grammarAccess.getBehaviorActionBlockAccess().getRightCurlyBracketKeyword_2());
        }
        (
            otherlv_3=Timeout
            {
                newLeafNode(otherlv_3, grammarAccess.getBehaviorActionBlockAccess().getTimeoutKeyword_3_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getBehaviorActionBlockAccess().getTimeoutBehaviorTimeParserRuleCall_3_1_0());
                    }
                    lv_timeout_4_0=ruleBehaviorTime
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getBehaviorActionBlockRule());
                        }
                        set(
                            $current,
                            "timeout",
                            lv_timeout_4_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
    )
;

// Entry rule entryRuleBehaviorActions
entryRuleBehaviorActions returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorActionsRule()); }
    iv_ruleBehaviorActions=ruleBehaviorActions
    { $current=$iv_ruleBehaviorActions.current; }
    EOF;

// Rule BehaviorActions
ruleBehaviorActions returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getBehaviorActionsAccess().getBehaviorActionParserRuleCall_0());
        }
        this_BehaviorAction_0=ruleBehaviorAction
        {
            $current = $this_BehaviorAction_0.current;
            afterParserOrEnumRuleCall();
        }
        (
            (
                (
                    {
                        $current = forceCreateModelElementAndAdd(
                            grammarAccess.getBehaviorActionsAccess().getBehaviorActionSequenceActionsAction_1_0_0(),
                            $current);
                    }
                )
                otherlv_2=Semicolon
                {
                    newLeafNode(otherlv_2, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_1());
                }
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_2_0());
                        }
                        lv_actions_3_0=ruleBehaviorAction
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                            }
                            add(
                                $current,
                                "actions",
                                lv_actions_3_0,
                                "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
                (
                    otherlv_4=Semicolon
                    {
                        newLeafNode(otherlv_4, grammarAccess.getBehaviorActionsAccess().getSemicolonKeyword_1_0_3_0());
                    }
                    (
                        (
                            {
                                newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_0_3_1_0());
                            }
                            lv_actions_5_0=ruleBehaviorAction
                            {
                                if ($current==null) {
                                    $current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                                }
                                add(
                                    $current,
                                    "actions",
                                    lv_actions_5_0,
                                    "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
                                afterParserOrEnumRuleCall();
                            }
                        )
                    )
                )*
            )
                |
            (
                (
                    {
                        $current = forceCreateModelElementAndAdd(
                            grammarAccess.getBehaviorActionsAccess().getBehaviorActionSetActionsAction_1_1_0(),
                            $current);
                    }
                )
                otherlv_7=Ampersand
                {
                    newLeafNode(otherlv_7, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_1());
                }
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_2_0());
                        }
                        lv_actions_8_0=ruleBehaviorAction
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                            }
                            add(
                                $current,
                                "actions",
                                lv_actions_8_0,
                                "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
                (
                    otherlv_9=Ampersand
                    {
                        newLeafNode(otherlv_9, grammarAccess.getBehaviorActionsAccess().getAmpersandKeyword_1_1_3_0());
                    }
                    (
                        (
                            {
                                newCompositeNode(grammarAccess.getBehaviorActionsAccess().getActionsBehaviorActionParserRuleCall_1_1_3_1_0());
                            }
                            lv_actions_10_0=ruleBehaviorAction
                            {
                                if ($current==null) {
                                    $current = createModelElementForParent(grammarAccess.getBehaviorActionsRule());
                                }
                                add(
                                    $current,
                                    "actions",
                                    lv_actions_10_0,
                                    "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
                                afterParserOrEnumRuleCall();
                            }
                        )
                    )
                )*
            )
        )?
    )
;

// Entry rule entryRuleBehaviorAction
entryRuleBehaviorAction returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorActionRule()); }
    iv_ruleBehaviorAction=ruleBehaviorAction
    { $current=$iv_ruleBehaviorAction.current; }
    EOF;

// Rule BehaviorAction
ruleBehaviorAction returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (ruleAssignmentAction)=>
            {
                newCompositeNode(grammarAccess.getBehaviorActionAccess().getAssignmentActionParserRuleCall_0());
            }
            this_AssignmentAction_0=ruleAssignmentAction
            {
                $current = $this_AssignmentAction_0.current;
                afterParserOrEnumRuleCall();
            }
        )
            |
        {
            newCompositeNode(grammarAccess.getBehaviorActionAccess().getCommunicationActionParserRuleCall_1());
        }
        this_CommunicationAction_1=ruleCommunicationAction
        {
            $current = $this_CommunicationAction_1.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getBehaviorActionAccess().getTimedActionParserRuleCall_2());
        }
        this_TimedAction_2=ruleTimedAction
        {
            $current = $this_TimedAction_2.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getBehaviorActionAccess().getIfStatementParserRuleCall_3());
        }
        this_IfStatement_3=ruleIfStatement
        {
            $current = $this_IfStatement_3.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getBehaviorActionAccess().getForStatementParserRuleCall_4());
        }
        this_ForStatement_4=ruleForStatement
        {
            $current = $this_ForStatement_4.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getBehaviorActionAccess().getWhileStatementParserRuleCall_5());
        }
        this_WhileStatement_5=ruleWhileStatement
        {
            $current = $this_WhileStatement_5.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getBehaviorActionAccess().getDoUntilStatementParserRuleCall_6());
        }
        this_DoUntilStatement_6=ruleDoUntilStatement
        {
            $current = $this_DoUntilStatement_6.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getBehaviorActionAccess().getBehaviorActionBlockParserRuleCall_7());
        }
        this_BehaviorActionBlock_7=ruleBehaviorActionBlock
        {
            $current = $this_BehaviorActionBlock_7.current;
            afterParserOrEnumRuleCall();
        }
    )
;

// Entry rule entryRuleAssignmentAction
entryRuleAssignmentAction returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getAssignmentActionRule()); }
    iv_ruleAssignmentAction=ruleAssignmentAction
    { $current=$iv_ruleAssignmentAction.current; }
    EOF;

// Rule AssignmentAction
ruleAssignmentAction returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getAssignmentActionAccess().getTargetReferenceParserRuleCall_0_0());
                }
                lv_target_0_0=ruleReference
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getAssignmentActionRule());
                    }
                    set(
                        $current,
                        "target",
                        lv_target_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_1=ColonEqualsSign
        {
            newLeafNode(otherlv_1, grammarAccess.getAssignmentActionAccess().getColonEqualsSignKeyword_1());
        }
        (
            (
                (
                    {
                        newCompositeNode(grammarAccess.getAssignmentActionAccess().getValueValueExpressionParserRuleCall_2_0_0());
                    }
                    lv_value_2_0=ruleValueExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getAssignmentActionRule());
                        }
                        set(
                            $current,
                            "value",
                            lv_value_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
                |
            (
                (
                    lv_any_3_0=Any
                    {
                        newLeafNode(lv_any_3_0, grammarAccess.getAssignmentActionAccess().getAnyAnyKeyword_2_1_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getAssignmentActionRule());
                        }
                        setWithLastConsumed($current, "any", lv_any_3_0 != null, "any");
                    }
                )
            )
        )
    )
;

// Entry rule entryRuleCommunicationAction
entryRuleCommunicationAction returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getCommunicationActionRule()); }
    iv_ruleCommunicationAction=ruleCommunicationAction
    { $current=$iv_ruleCommunicationAction.current; }
    EOF;

// Rule CommunicationAction
ruleCommunicationAction returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                (
                    {
                        newCompositeNode(grammarAccess.getCommunicationActionAccess().getReferenceReferenceParserRuleCall_0_0_0());
                    }
                    lv_reference_0_0=ruleReference
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                        }
                        set(
                            $current,
                            "reference",
                            lv_reference_0_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
            (
                (
                    (
                        (
                            lv_send_1_0=ExclamationMark
                            {
                                newLeafNode(lv_send_1_0, grammarAccess.getCommunicationActionAccess().getSendExclamationMarkKeyword_0_1_0_0_0());
                            }
                            {
                                if ($current==null) {
                                    $current = createModelElement(grammarAccess.getCommunicationActionRule());
                                }
                                setWithLastConsumed($current, "send", lv_send_1_0 != null, "!");
                            }
                        )
                    )
                    (
                        otherlv_2=LeftParenthesis
                        {
                            newLeafNode(otherlv_2, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_0_1_0());
                        }
                        (
                            (
                                {
                                    newCompositeNode(grammarAccess.getCommunicationActionAccess().getParametersValueExpressionParserRuleCall_0_1_0_1_1_0());
                                }
                                lv_parameters_3_0=ruleValueExpression
                                {
                                    if ($current==null) {
                                        $current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                                    }
                                    add(
                                        $current,
                                        "parameters",
                                        lv_parameters_3_0,
                                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                                    afterParserOrEnumRuleCall();
                                }
                            )
                        )
                        (
                            otherlv_4=Comma
                            {
                                newLeafNode(otherlv_4, grammarAccess.getCommunicationActionAccess().getCommaKeyword_0_1_0_1_2_0());
                            }
                            (
                                (
                                    {
                                        newCompositeNode(grammarAccess.getCommunicationActionAccess().getParametersValueExpressionParserRuleCall_0_1_0_1_2_1_0());
                                    }
                                    lv_parameters_5_0=ruleValueExpression
                                    {
                                        if ($current==null) {
                                            $current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                                        }
                                        add(
                                            $current,
                                            "parameters",
                                            lv_parameters_5_0,
                                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                                        afterParserOrEnumRuleCall();
                                    }
                                )
                            )
                        )*
                        otherlv_6=RightParenthesis
                        {
                            newLeafNode(otherlv_6, grammarAccess.getCommunicationActionAccess().getRightParenthesisKeyword_0_1_0_1_3());
                        }
                    )?
                )
                    |
                (
                    (
                        (
                            lv_dequeue_7_0=QuestionMark
                            {
                                newLeafNode(lv_dequeue_7_0, grammarAccess.getCommunicationActionAccess().getDequeueQuestionMarkKeyword_0_1_1_0_0());
                            }
                            {
                                if ($current==null) {
                                    $current = createModelElement(grammarAccess.getCommunicationActionRule());
                                }
                                setWithLastConsumed($current, "dequeue", lv_dequeue_7_0 != null, "?");
                            }
                        )
                    )
                    (
                        otherlv_8=LeftParenthesis
                        {
                            newLeafNode(otherlv_8, grammarAccess.getCommunicationActionAccess().getLeftParenthesisKeyword_0_1_1_1_0());
                        }
                        (
                            (
                                {
                                    newCompositeNode(grammarAccess.getCommunicationActionAccess().getTargetReferenceParserRuleCall_0_1_1_1_1_0());
                                }
                                lv_target_9_0=ruleReference
                                {
                                    if ($current==null) {
                                        $current = createModelElementForParent(grammarAccess.getCommunicationActionRule());
                                    }
                                    set(
                                        $current,
                                        "target",
                                        lv_target_9_0,
                                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                                    afterParserOrEnumRuleCall();
                                }
                            )
                        )
                        otherlv_10=RightParenthesis
                        {
                            newLeafNode(otherlv_10, grammarAccess.getCommunicationActionAccess().getRightParenthesisKeyword_0_1_1_1_2());
                        }
                    )?
                )
                    |
                (
                    (
                        lv_freeze_11_0=GreaterThanSignGreaterThanSign
                        {
                            newLeafNode(lv_freeze_11_0, grammarAccess.getCommunicationActionAccess().getFreezeGreaterThanSignGreaterThanSignKeyword_0_1_2_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getCommunicationActionRule());
                            }
                            setWithLastConsumed($current, "freeze", lv_freeze_11_0 != null, ">>");
                        }
                    )
                )
                    |
                (
                    (
                        lv_lock_12_0=ExclamationMarkLessThanSign
                        {
                            newLeafNode(lv_lock_12_0, grammarAccess.getCommunicationActionAccess().getLockExclamationMarkLessThanSignKeyword_0_1_3_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getCommunicationActionRule());
                            }
                            setWithLastConsumed($current, "lock", lv_lock_12_0 != null, "!<");
                        }
                    )
                )
                    |
                (
                    (
                        lv_unlock_13_0=ExclamationMarkGreaterThanSign
                        {
                            newLeafNode(lv_unlock_13_0, grammarAccess.getCommunicationActionAccess().getUnlockExclamationMarkGreaterThanSignKeyword_0_1_4_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getCommunicationActionRule());
                            }
                            setWithLastConsumed($current, "unlock", lv_unlock_13_0 != null, "!>");
                        }
                    )
                )
            )
        )
            |
        (
            (
                (
                    lv_all_14_0=Asterisk
                    {
                        newLeafNode(lv_all_14_0, grammarAccess.getCommunicationActionAccess().getAllAsteriskKeyword_1_0_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getCommunicationActionRule());
                        }
                        setWithLastConsumed($current, "all", lv_all_14_0 != null, "*");
                    }
                )
            )
            (
                (
                    (
                        lv_allLock_15_0=ExclamationMarkLessThanSign
                        {
                            newLeafNode(lv_allLock_15_0, grammarAccess.getCommunicationActionAccess().getAllLockExclamationMarkLessThanSignKeyword_1_1_0_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getCommunicationActionRule());
                            }
                            setWithLastConsumed($current, "allLock", lv_allLock_15_0 != null, "!<");
                        }
                    )
                )
                    |
                (
                    (
                        lv_allUnlock_16_0=ExclamationMarkGreaterThanSign
                        {
                            newLeafNode(lv_allUnlock_16_0, grammarAccess.getCommunicationActionAccess().getAllUnlockExclamationMarkGreaterThanSignKeyword_1_1_1_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getCommunicationActionRule());
                            }
                            setWithLastConsumed($current, "allUnlock", lv_allUnlock_16_0 != null, "!>");
                        }
                    )
                )
            )
        )
    )
;

// Entry rule entryRuleTimedAction
entryRuleTimedAction returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getTimedActionRule()); }
    iv_ruleTimedAction=ruleTimedAction
    { $current=$iv_ruleTimedAction.current; }
    EOF;

// Rule TimedAction
ruleTimedAction returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=Computation
        {
            newLeafNode(otherlv_0, grammarAccess.getTimedActionAccess().getComputationKeyword_0());
        }
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getTimedActionAccess().getLowerTimeBehaviorTimeParserRuleCall_2_0());
                }
                lv_lowerTime_2_0=ruleBehaviorTime
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getTimedActionRule());
                    }
                    set(
                        $current,
                        "lowerTime",
                        lv_lowerTime_2_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_3=FullStopFullStop
            {
                newLeafNode(otherlv_3, grammarAccess.getTimedActionAccess().getFullStopFullStopKeyword_3_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getTimedActionAccess().getUpperTimeBehaviorTimeParserRuleCall_3_1_0());
                    }
                    lv_upperTime_4_0=ruleBehaviorTime
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getTimedActionRule());
                        }
                        set(
                            $current,
                            "upperTime",
                            lv_upperTime_4_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
        otherlv_5=RightParenthesis
        {
            newLeafNode(otherlv_5, grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_4());
        }
        (
            otherlv_6=In
            {
                newLeafNode(otherlv_6, grammarAccess.getTimedActionAccess().getInKeyword_5_0());
            }
            otherlv_7=Binding
            {
                newLeafNode(otherlv_7, grammarAccess.getTimedActionAccess().getBindingKeyword_5_1());
            }
            otherlv_8=LeftParenthesis
            {
                newLeafNode(otherlv_8, grammarAccess.getTimedActionAccess().getLeftParenthesisKeyword_5_2());
            }
            (
                (
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getTimedActionRule());
                        }
                    }
                    {
                        newCompositeNode(grammarAccess.getTimedActionAccess().getProcessorsComponentClassifierCrossReference_5_3_0());
                    }
                    ruleQCREF
                    {
                        afterParserOrEnumRuleCall();
                    }
                )
            )
            (
                otherlv_10=Comma
                {
                    newLeafNode(otherlv_10, grammarAccess.getTimedActionAccess().getCommaKeyword_5_4_0());
                }
                (
                    (
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getTimedActionRule());
                            }
                        }
                        {
                            newCompositeNode(grammarAccess.getTimedActionAccess().getProcessorsComponentClassifierCrossReference_5_4_1_0());
                        }
                        ruleQCREF
                        {
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
            )*
            otherlv_12=RightParenthesis
            {
                newLeafNode(otherlv_12, grammarAccess.getTimedActionAccess().getRightParenthesisKeyword_5_5());
            }
        )?
    )
;

// Entry rule entryRuleIfStatement
entryRuleIfStatement returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getIfStatementRule()); }
    iv_ruleIfStatement=ruleIfStatement
    { $current=$iv_ruleIfStatement.current; }
    EOF;

// Rule IfStatement
ruleIfStatement returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=If
        {
            newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
        }
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getIfStatementAccess().getConditionValueExpressionParserRuleCall_2_0());
                }
                lv_condition_2_0=ruleValueExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    }
                    set(
                        $current,
                        "condition",
                        lv_condition_2_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_3=RightParenthesis
        {
            newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getIfStatementAccess().getThenActionsBehaviorActionsParserRuleCall_4_0());
                }
                lv_thenActions_4_0=ruleBehaviorActions
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    }
                    set(
                        $current,
                        "thenActions",
                        lv_thenActions_4_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfsElseIfClauseParserRuleCall_5_0());
                }
                lv_elseIfs_5_0=ruleElseIfClause
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    }
                    add(
                        $current,
                        "elseIfs",
                        lv_elseIfs_5_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ElseIfClause");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
        (
            otherlv_6=Else
            {
                newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getIfStatementAccess().getElseActionsBehaviorActionsParserRuleCall_6_1_0());
                    }
                    lv_elseActions_7_0=ruleBehaviorActions
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getIfStatementRule());
                        }
                        set(
                            $current,
                            "elseActions",
                            lv_elseActions_7_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
        otherlv_8=End
        {
            newLeafNode(otherlv_8, grammarAccess.getIfStatementAccess().getEndKeyword_7());
        }
        otherlv_9=If
        {
            newLeafNode(otherlv_9, grammarAccess.getIfStatementAccess().getIfKeyword_8());
        }
    )
;

// Entry rule entryRuleElseIfClause
entryRuleElseIfClause returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getElseIfClauseRule()); }
    iv_ruleElseIfClause=ruleElseIfClause
    { $current=$iv_ruleElseIfClause.current; }
    EOF;

// Rule ElseIfClause
ruleElseIfClause returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=Elsif
        {
            newLeafNode(otherlv_0, grammarAccess.getElseIfClauseAccess().getElsifKeyword_0());
        }
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getElseIfClauseAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getElseIfClauseAccess().getConditionValueExpressionParserRuleCall_2_0());
                }
                lv_condition_2_0=ruleValueExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getElseIfClauseRule());
                    }
                    set(
                        $current,
                        "condition",
                        lv_condition_2_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_3=RightParenthesis
        {
            newLeafNode(otherlv_3, grammarAccess.getElseIfClauseAccess().getRightParenthesisKeyword_3());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getElseIfClauseAccess().getActionsBehaviorActionsParserRuleCall_4_0());
                }
                lv_actions_4_0=ruleBehaviorActions
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getElseIfClauseRule());
                    }
                    set(
                        $current,
                        "actions",
                        lv_actions_4_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                    afterParserOrEnumRuleCall();
                }
            )
        )
    )
;

// Entry rule entryRuleForStatement
entryRuleForStatement returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getForStatementRule()); }
    iv_ruleForStatement=ruleForStatement
    { $current=$iv_ruleForStatement.current; }
    EOF;

// Rule ForStatement
ruleForStatement returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                (
                    lv_for_0_0=For
                    {
                        newLeafNode(lv_for_0_0, grammarAccess.getForStatementAccess().getForForKeyword_0_0_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getForStatementRule());
                        }
                        setWithLastConsumed($current, "for", lv_for_0_0 != null, "for");
                    }
                )
            )
                |
            (
                (
                    lv_forall_1_0=Forall
                    {
                        newLeafNode(lv_forall_1_0, grammarAccess.getForStatementAccess().getForallForallKeyword_0_1_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getForStatementRule());
                        }
                        setWithLastConsumed($current, "forall", lv_forall_1_0 != null, "forall");
                    }
                )
            )
        )
        otherlv_2=LeftParenthesis
        {
            newLeafNode(otherlv_2, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                lv_variable_3_0=RULE_ID
                {
                    newLeafNode(lv_variable_3_0, grammarAccess.getForStatementAccess().getVariableIDTerminalRuleCall_2_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getForStatementRule());
                    }
                    setWithLastConsumed(
                        $current,
                        "variable",
                        lv_variable_3_0,
                        "org.osate.xtext.aadl2.properties.Properties.ID");
                }
            )
        )
        otherlv_4=Colon
        {
            newLeafNode(otherlv_4, grammarAccess.getForStatementAccess().getColonKeyword_3());
        }
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getForStatementRule());
                    }
                }
                {
                    newCompositeNode(grammarAccess.getForStatementAccess().getDataClassifierComponentClassifierCrossReference_4_0());
                }
                ruleQCREF
                {
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_6=In
        {
            newLeafNode(otherlv_6, grammarAccess.getForStatementAccess().getInKeyword_5());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getForStatementAccess().getValuesElementValuesParserRuleCall_6_0());
                }
                lv_values_7_0=ruleElementValues
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getForStatementRule());
                    }
                    set(
                        $current,
                        "values",
                        lv_values_7_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ElementValues");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_8=RightParenthesis
        {
            newLeafNode(otherlv_8, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());
        }
        otherlv_9=LeftCurlyBracket
        {
            newLeafNode(otherlv_9, grammarAccess.getForStatementAccess().getLeftCurlyBracketKeyword_8());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getForStatementAccess().getActionsBehaviorActionsParserRuleCall_9_0());
                }
                lv_actions_10_0=ruleBehaviorActions
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getForStatementRule());
                    }
                    set(
                        $current,
                        "actions",
                        lv_actions_10_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_11=RightCurlyBracket
        {
            newLeafNode(otherlv_11, grammarAccess.getForStatementAccess().getRightCurlyBracketKeyword_10());
        }
    )
;

// Entry rule entryRuleWhileStatement
entryRuleWhileStatement returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getWhileStatementRule()); }
    iv_ruleWhileStatement=ruleWhileStatement
    { $current=$iv_ruleWhileStatement.current; }
    EOF;

// Rule WhileStatement
ruleWhileStatement returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=While
        {
            newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
        }
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionValueExpressionParserRuleCall_2_0());
                }
                lv_condition_2_0=ruleValueExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getWhileStatementRule());
                    }
                    set(
                        $current,
                        "condition",
                        lv_condition_2_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_3=RightParenthesis
        {
            newLeafNode(otherlv_3, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3());
        }
        otherlv_4=LeftCurlyBracket
        {
            newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getLeftCurlyBracketKeyword_4());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getWhileStatementAccess().getActionsBehaviorActionsParserRuleCall_5_0());
                }
                lv_actions_5_0=ruleBehaviorActions
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getWhileStatementRule());
                    }
                    set(
                        $current,
                        "actions",
                        lv_actions_5_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_6=RightCurlyBracket
        {
            newLeafNode(otherlv_6, grammarAccess.getWhileStatementAccess().getRightCurlyBracketKeyword_6());
        }
    )
;

// Entry rule entryRuleDoUntilStatement
entryRuleDoUntilStatement returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getDoUntilStatementRule()); }
    iv_ruleDoUntilStatement=ruleDoUntilStatement
    { $current=$iv_ruleDoUntilStatement.current; }
    EOF;

// Rule DoUntilStatement
ruleDoUntilStatement returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=Do
        {
            newLeafNode(otherlv_0, grammarAccess.getDoUntilStatementAccess().getDoKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getDoUntilStatementAccess().getActionsBehaviorActionsParserRuleCall_1_0());
                }
                lv_actions_1_0=ruleBehaviorActions
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getDoUntilStatementRule());
                    }
                    set(
                        $current,
                        "actions",
                        lv_actions_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_2=Until
        {
            newLeafNode(otherlv_2, grammarAccess.getDoUntilStatementAccess().getUntilKeyword_2());
        }
        otherlv_3=LeftParenthesis
        {
            newLeafNode(otherlv_3, grammarAccess.getDoUntilStatementAccess().getLeftParenthesisKeyword_3());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getDoUntilStatementAccess().getConditionValueExpressionParserRuleCall_4_0());
                }
                lv_condition_4_0=ruleValueExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getDoUntilStatementRule());
                    }
                    set(
                        $current,
                        "condition",
                        lv_condition_4_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_5=RightParenthesis
        {
            newLeafNode(otherlv_5, grammarAccess.getDoUntilStatementAccess().getRightParenthesisKeyword_5());
        }
    )
;

// Entry rule entryRuleElementValues
entryRuleElementValues returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getElementValuesRule()); }
    iv_ruleElementValues=ruleElementValues
    { $current=$iv_ruleElementValues.current; }
    EOF;

// Rule ElementValues
ruleElementValues returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getElementValuesAccess().getLowerIntegerValueParserRuleCall_0_0());
                }
                lv_lower_0_0=ruleIntegerValue
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getElementValuesRule());
                    }
                    set(
                        $current,
                        "lower",
                        lv_lower_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=FullStopFullStop
            {
                newLeafNode(otherlv_1, grammarAccess.getElementValuesAccess().getFullStopFullStopKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getElementValuesAccess().getUpperIntegerValueParserRuleCall_1_1_0());
                    }
                    lv_upper_2_0=ruleIntegerValue
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getElementValuesRule());
                        }
                        set(
                            $current,
                            "upper",
                            lv_upper_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
    )
;

// Entry rule entryRuleBehaviorTime
entryRuleBehaviorTime returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorTimeRule()); }
    iv_ruleBehaviorTime=ruleBehaviorTime
    { $current=$iv_ruleBehaviorTime.current; }
    EOF;

// Rule BehaviorTime
ruleBehaviorTime returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getBehaviorTimeAccess().getValueIntegerValueParserRuleCall_0_0());
                }
                lv_value_0_0=ruleIntegerValue
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getBehaviorTimeRule());
                    }
                    set(
                        $current,
                        "value",
                        lv_value_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getBehaviorTimeRule());
                    }
                }
                otherlv_1=RULE_ID
                {
                    newLeafNode(otherlv_1, grammarAccess.getBehaviorTimeAccess().getUnitUnitLiteralCrossReference_1_0());
                }
            )
        )
    )
;

// Entry rule entryRuleIntegerValue
entryRuleIntegerValue returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getIntegerValueRule()); }
    iv_ruleIntegerValue=ruleIntegerValue
    { $current=$iv_ruleIntegerValue.current; }
    EOF;

// Rule IntegerValue
ruleIntegerValue returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getIntegerValueAccess().getBehaviorIntegerLiteralParserRuleCall_0());
        }
        this_BehaviorIntegerLiteral_0=ruleBehaviorIntegerLiteral
        {
            $current = $this_BehaviorIntegerLiteral_0.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getIntegerValueAccess().getHashPropertyReferenceParserRuleCall_1());
        }
        this_HashPropertyReference_1=ruleHashPropertyReference
        {
            $current = $this_HashPropertyReference_1.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getIntegerValueAccess().getReferenceExpressionParserRuleCall_2());
        }
        this_ReferenceExpression_2=ruleReferenceExpression
        {
            $current = $this_ReferenceExpression_2.current;
            afterParserOrEnumRuleCall();
        }
    )
;

// Entry rule entryRuleValueExpression
entryRuleValueExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getValueExpressionRule()); }
    iv_ruleValueExpression=ruleValueExpression
    { $current=$iv_ruleValueExpression.current; }
    EOF;

// Rule ValueExpression
ruleValueExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    {
        newCompositeNode(grammarAccess.getValueExpressionAccess().getLogicalOrExpressionParserRuleCall());
    }
    this_LogicalOrExpression_0=ruleLogicalOrExpression
    {
        $current = $this_LogicalOrExpression_0.current;
        afterParserOrEnumRuleCall();
    }
;

// Entry rule entryRuleLogicalOrExpression
entryRuleLogicalOrExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); }
    iv_ruleLogicalOrExpression=ruleLogicalOrExpression
    { $current=$iv_ruleLogicalOrExpression.current; }
    EOF;

// Rule LogicalOrExpression
ruleLogicalOrExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
        }
        this_LogicalAndExpression_0=ruleLogicalAndExpression
        {
            $current = $this_LogicalAndExpression_0.current;
            afterParserOrEnumRuleCall();
        }
        (
            (
                {
                    $current = forceCreateModelElementAndSet(
                        grammarAccess.getLogicalOrExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                        $current);
                }
            )
            (
                (
                    (
                        lv_operator_2_1=Or
                        {
                            newLeafNode(lv_operator_2_1, grammarAccess.getLogicalOrExpressionAccess().getOperatorOrKeyword_1_1_0_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getLogicalOrExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_1, null);
                        }
                            |
                        lv_operator_2_2=Xor
                        {
                            newLeafNode(lv_operator_2_2, grammarAccess.getLogicalOrExpressionAccess().getOperatorXorKeyword_1_1_0_1());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getLogicalOrExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_2, null);
                        }
                    )
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
                    }
                    lv_right_3_0=ruleLogicalAndExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
                        }
                        set(
                            $current,
                            "right",
                            lv_right_3_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalAndExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRuleLogicalAndExpression
entryRuleLogicalAndExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); }
    iv_ruleLogicalAndExpression=ruleLogicalAndExpression
    { $current=$iv_ruleLogicalAndExpression.current; }
    EOF;

// Rule LogicalAndExpression
ruleLogicalAndExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRelationalExpressionParserRuleCall_0());
        }
        this_RelationalExpression_0=ruleRelationalExpression
        {
            $current = $this_RelationalExpression_0.current;
            afterParserOrEnumRuleCall();
        }
        (
            (
                {
                    $current = forceCreateModelElementAndSet(
                        grammarAccess.getLogicalAndExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                        $current);
                }
            )
            (
                (
                    lv_operator_2_0=And
                    {
                        newLeafNode(lv_operator_2_0, grammarAccess.getLogicalAndExpressionAccess().getOperatorAndKeyword_1_1_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getLogicalAndExpressionRule());
                        }
                        setWithLastConsumed($current, "operator", lv_operator_2_0, "and");
                    }
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0());
                    }
                    lv_right_3_0=ruleRelationalExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
                        }
                        set(
                            $current,
                            "right",
                            lv_right_3_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.RelationalExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRuleRelationalExpression
entryRuleRelationalExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getRelationalExpressionRule()); }
    iv_ruleRelationalExpression=ruleRelationalExpression
    { $current=$iv_ruleRelationalExpression.current; }
    EOF;

// Rule RelationalExpression
ruleRelationalExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
        }
        this_AdditiveExpression_0=ruleAdditiveExpression
        {
            $current = $this_AdditiveExpression_0.current;
            afterParserOrEnumRuleCall();
        }
        (
            (
                {
                    $current = forceCreateModelElementAndSet(
                        grammarAccess.getRelationalExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                        $current);
                }
            )
            (
                (
                    (
                        lv_operator_2_1=EqualsSign
                        {
                            newLeafNode(lv_operator_2_1, grammarAccess.getRelationalExpressionAccess().getOperatorEqualsSignKeyword_1_1_0_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_1, null);
                        }
                            |
                        lv_operator_2_2=ExclamationMarkEqualsSign
                        {
                            newLeafNode(lv_operator_2_2, grammarAccess.getRelationalExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_2, null);
                        }
                            |
                        lv_operator_2_3=LessThanSign
                        {
                            newLeafNode(lv_operator_2_3, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_2());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_3, null);
                        }
                            |
                        lv_operator_2_4=LessThanSignEqualsSign
                        {
                            newLeafNode(lv_operator_2_4, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_3());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_4, null);
                        }
                            |
                        lv_operator_2_5=GreaterThanSign
                        {
                            newLeafNode(lv_operator_2_5, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_5, null);
                        }
                            |
                        lv_operator_2_6=GreaterThanSignEqualsSign
                        {
                            newLeafNode(lv_operator_2_6, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_5());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_6, null);
                        }
                    )
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
                    }
                    lv_right_3_0=ruleAdditiveExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                        }
                        set(
                            $current,
                            "right",
                            lv_right_3_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.AdditiveExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
    )
;

// Entry rule entryRuleAdditiveExpression
entryRuleAdditiveExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getAdditiveExpressionRule()); }
    iv_ruleAdditiveExpression=ruleAdditiveExpression
    { $current=$iv_ruleAdditiveExpression.current; }
    EOF;

// Rule AdditiveExpression
ruleAdditiveExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
        }
        this_MultiplicativeExpression_0=ruleMultiplicativeExpression
        {
            $current = $this_MultiplicativeExpression_0.current;
            afterParserOrEnumRuleCall();
        }
        (
            (
                {
                    $current = forceCreateModelElementAndSet(
                        grammarAccess.getAdditiveExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                        $current);
                }
            )
            (
                (
                    (
                        lv_operator_2_1=PlusSign
                        {
                            newLeafNode(lv_operator_2_1, grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getAdditiveExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_1, null);
                        }
                            |
                        lv_operator_2_2=HyphenMinus
                        {
                            newLeafNode(lv_operator_2_2, grammarAccess.getAdditiveExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_1());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getAdditiveExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_2, null);
                        }
                    )
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0());
                    }
                    lv_right_3_0=ruleMultiplicativeExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
                        }
                        set(
                            $current,
                            "right",
                            lv_right_3_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.MultiplicativeExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRuleMultiplicativeExpression
entryRuleMultiplicativeExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); }
    iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression
    { $current=$iv_ruleMultiplicativeExpression.current; }
    EOF;

// Rule MultiplicativeExpression
ruleMultiplicativeExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPowerExpressionParserRuleCall_0());
        }
        this_PowerExpression_0=rulePowerExpression
        {
            $current = $this_PowerExpression_0.current;
            afterParserOrEnumRuleCall();
        }
        (
            (
                {
                    $current = forceCreateModelElementAndSet(
                        grammarAccess.getMultiplicativeExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                        $current);
                }
            )
            (
                (
                    (
                        lv_operator_2_1=Asterisk
                        {
                            newLeafNode(lv_operator_2_1, grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_1_0_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_1, null);
                        }
                            |
                        lv_operator_2_2=Solidus
                        {
                            newLeafNode(lv_operator_2_2, grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_1_0_1());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_2, null);
                        }
                            |
                        lv_operator_2_3=Mod
                        {
                            newLeafNode(lv_operator_2_3, grammarAccess.getMultiplicativeExpressionAccess().getOperatorModKeyword_1_1_0_2());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_3, null);
                        }
                            |
                        lv_operator_2_4=Rem
                        {
                            newLeafNode(lv_operator_2_4, grammarAccess.getMultiplicativeExpressionAccess().getOperatorRemKeyword_1_1_0_3());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_2_4, null);
                        }
                    )
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());
                    }
                    lv_right_3_0=rulePowerExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                        }
                        set(
                            $current,
                            "right",
                            lv_right_3_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.PowerExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )*
    )
;

// Entry rule entryRulePowerExpression
entryRulePowerExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPowerExpressionRule()); }
    iv_rulePowerExpression=rulePowerExpression
    { $current=$iv_rulePowerExpression.current; }
    EOF;

// Rule PowerExpression
rulePowerExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0());
        }
        this_UnaryExpression_0=ruleUnaryExpression
        {
            $current = $this_UnaryExpression_0.current;
            afterParserOrEnumRuleCall();
        }
        (
            (
                {
                    $current = forceCreateModelElementAndSet(
                        grammarAccess.getPowerExpressionAccess().getBinaryExpressionLeftAction_1_0(),
                        $current);
                }
            )
            (
                (
                    lv_operator_2_0=AsteriskAsterisk
                    {
                        newLeafNode(lv_operator_2_0, grammarAccess.getPowerExpressionAccess().getOperatorAsteriskAsteriskKeyword_1_1_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getPowerExpressionRule());
                        }
                        setWithLastConsumed($current, "operator", lv_operator_2_0, "**");
                    }
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getPowerExpressionAccess().getRightPowerExpressionParserRuleCall_1_2_0());
                    }
                    lv_right_3_0=rulePowerExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getPowerExpressionRule());
                        }
                        set(
                            $current,
                            "right",
                            lv_right_3_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.PowerExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
    )
;

// Entry rule entryRuleUnaryExpression
entryRuleUnaryExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getUnaryExpressionRule()); }
    iv_ruleUnaryExpression=ruleUnaryExpression
    { $current=$iv_ruleUnaryExpression.current; }
    EOF;

// Rule UnaryExpression
ruleUnaryExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    $current = forceCreateModelElement(
                        grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_0_0(),
                        $current);
                }
            )
            (
                (
                    (
                        lv_operator_1_1=PlusSign
                        {
                            newLeafNode(lv_operator_1_1, grammarAccess.getUnaryExpressionAccess().getOperatorPlusSignKeyword_0_1_0_0());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_1_1, null);
                        }
                            |
                        lv_operator_1_2=HyphenMinus
                        {
                            newLeafNode(lv_operator_1_2, grammarAccess.getUnaryExpressionAccess().getOperatorHyphenMinusKeyword_0_1_0_1());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_1_2, null);
                        }
                            |
                        lv_operator_1_3=Abs
                        {
                            newLeafNode(lv_operator_1_3, grammarAccess.getUnaryExpressionAccess().getOperatorAbsKeyword_0_1_0_2());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_1_3, null);
                        }
                            |
                        lv_operator_1_4=Not
                        {
                            newLeafNode(lv_operator_1_4, grammarAccess.getUnaryExpressionAccess().getOperatorNotKeyword_0_1_0_3());
                        }
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            }
                            setWithLastConsumed($current, "operator", lv_operator_1_4, null);
                        }
                    )
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_0_2_0());
                    }
                    lv_operand_2_0=ruleUnaryExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                        }
                        set(
                            $current,
                            "operand",
                            lv_operand_2_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnaryExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )
            |
        {
            newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_1());
        }
        this_PrimaryExpression_3=rulePrimaryExpression
        {
            $current = $this_PrimaryExpression_3.current;
            afterParserOrEnumRuleCall();
        }
    )
;

// Entry rule entryRulePrimaryExpression
entryRulePrimaryExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPrimaryExpressionRule()); }
    iv_rulePrimaryExpression=rulePrimaryExpression
    { $current=$iv_rulePrimaryExpression.current; }
    EOF;

// Rule PrimaryExpression
rulePrimaryExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueConstantParserRuleCall_0());
        }
        this_ValueConstant_0=ruleValueConstant
        {
            $current = $this_ValueConstant_0.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getReferenceExpressionParserRuleCall_1());
        }
        this_ReferenceExpression_1=ruleReferenceExpression
        {
            $current = $this_ReferenceExpression_1.current;
            afterParserOrEnumRuleCall();
        }
            |
        (
            otherlv_2=LeftParenthesis
            {
                newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());
            }
            {
                newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueExpressionParserRuleCall_2_1());
            }
            this_ValueExpression_3=ruleValueExpression
            {
                $current = $this_ValueExpression_3.current;
                afterParserOrEnumRuleCall();
            }
            otherlv_4=RightParenthesis
            {
                newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2());
            }
        )
    )
;

// Entry rule entryRuleValueConstant
entryRuleValueConstant returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getValueConstantRule()); }
    iv_ruleValueConstant=ruleValueConstant
    { $current=$iv_ruleValueConstant.current; }
    EOF;

// Rule ValueConstant
ruleValueConstant returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorIntegerLiteralParserRuleCall_0());
        }
        this_BehaviorIntegerLiteral_0=ruleBehaviorIntegerLiteral
        {
            $current = $this_BehaviorIntegerLiteral_0.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorRealLiteralParserRuleCall_1());
        }
        this_BehaviorRealLiteral_1=ruleBehaviorRealLiteral
        {
            $current = $this_BehaviorRealLiteral_1.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorStringLiteralParserRuleCall_2());
        }
        this_BehaviorStringLiteral_2=ruleBehaviorStringLiteral
        {
            $current = $this_BehaviorStringLiteral_2.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getValueConstantAccess().getBehaviorBooleanLiteralParserRuleCall_3());
        }
        this_BehaviorBooleanLiteral_3=ruleBehaviorBooleanLiteral
        {
            $current = $this_BehaviorBooleanLiteral_3.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getValueConstantAccess().getHashPropertyReferenceParserRuleCall_4());
        }
        this_HashPropertyReference_4=ruleHashPropertyReference
        {
            $current = $this_HashPropertyReference_4.current;
            afterParserOrEnumRuleCall();
        }
    )
;

// Entry rule entryRuleBehaviorIntegerLiteral
entryRuleBehaviorIntegerLiteral returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorIntegerLiteralRule()); }
    iv_ruleBehaviorIntegerLiteral=ruleBehaviorIntegerLiteral
    { $current=$iv_ruleBehaviorIntegerLiteral.current; }
    EOF;

// Rule BehaviorIntegerLiteral
ruleBehaviorIntegerLiteral returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            lv_value_0_0=RULE_INTEGER_LIT
            {
                newLeafNode(lv_value_0_0, grammarAccess.getBehaviorIntegerLiteralAccess().getValueINTEGER_LITTerminalRuleCall_0());
            }
            {
                if ($current==null) {
                    $current = createModelElement(grammarAccess.getBehaviorIntegerLiteralRule());
                }
                setWithLastConsumed(
                    $current,
                    "value",
                    lv_value_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.INTEGER_LIT");
            }
        )
    )
;

// Entry rule entryRuleBehaviorRealLiteral
entryRuleBehaviorRealLiteral returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorRealLiteralRule()); }
    iv_ruleBehaviorRealLiteral=ruleBehaviorRealLiteral
    { $current=$iv_ruleBehaviorRealLiteral.current; }
    EOF;

// Rule BehaviorRealLiteral
ruleBehaviorRealLiteral returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            lv_value_0_0=RULE_REAL_LIT
            {
                newLeafNode(lv_value_0_0, grammarAccess.getBehaviorRealLiteralAccess().getValueREAL_LITTerminalRuleCall_0());
            }
            {
                if ($current==null) {
                    $current = createModelElement(grammarAccess.getBehaviorRealLiteralRule());
                }
                setWithLastConsumed(
                    $current,
                    "value",
                    lv_value_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.REAL_LIT");
            }
        )
    )
;

// Entry rule entryRuleBehaviorStringLiteral
entryRuleBehaviorStringLiteral returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorStringLiteralRule()); }
    iv_ruleBehaviorStringLiteral=ruleBehaviorStringLiteral
    { $current=$iv_ruleBehaviorStringLiteral.current; }
    EOF;

// Rule BehaviorStringLiteral
ruleBehaviorStringLiteral returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            lv_value_0_0=RULE_STRING
            {
                newLeafNode(lv_value_0_0, grammarAccess.getBehaviorStringLiteralAccess().getValueSTRINGTerminalRuleCall_0());
            }
            {
                if ($current==null) {
                    $current = createModelElement(grammarAccess.getBehaviorStringLiteralRule());
                }
                setWithLastConsumed(
                    $current,
                    "value",
                    lv_value_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.STRING");
            }
        )
    )
;

// Entry rule entryRuleBehaviorBooleanLiteral
entryRuleBehaviorBooleanLiteral returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBehaviorBooleanLiteralRule()); }
    iv_ruleBehaviorBooleanLiteral=ruleBehaviorBooleanLiteral
    { $current=$iv_ruleBehaviorBooleanLiteral.current; }
    EOF;

// Rule BehaviorBooleanLiteral
ruleBehaviorBooleanLiteral returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                $current = forceCreateModelElement(
                    grammarAccess.getBehaviorBooleanLiteralAccess().getBehaviorBooleanLiteralAction_0(),
                    $current);
            }
        )
        (
            (
                (
                    lv_value_1_0=True
                    {
                        newLeafNode(lv_value_1_0, grammarAccess.getBehaviorBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getBehaviorBooleanLiteralRule());
                        }
                        setWithLastConsumed($current, "value", lv_value_1_0 != null, "true");
                    }
                )
            )
                |
            otherlv_2=False
            {
                newLeafNode(otherlv_2, grammarAccess.getBehaviorBooleanLiteralAccess().getFalseKeyword_1_1());
            }
        )
    )
;

// Entry rule entryRuleReferenceExpression
entryRuleReferenceExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getReferenceExpressionRule()); }
    iv_ruleReferenceExpression=ruleReferenceExpression
    { $current=$iv_ruleReferenceExpression.current; }
    EOF;

// Rule ReferenceExpression
ruleReferenceExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getReferenceExpressionAccess().getReferenceReferenceParserRuleCall_0_0());
                }
                lv_reference_0_0=ruleReference
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getReferenceExpressionRule());
                    }
                    set(
                        $current,
                        "reference",
                        lv_reference_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                (
                    {
                        newCompositeNode(grammarAccess.getReferenceExpressionAccess().getPropertyPropertyReferenceTailParserRuleCall_1_0_0());
                    }
                    lv_property_1_0=rulePropertyReferenceTail
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getReferenceExpressionRule());
                        }
                        set(
                            $current,
                            "property",
                            lv_property_1_0,
                            "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyReferenceTail");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
                |
            (
                (
                    lv_dequeue_2_0=QuestionMark
                    {
                        newLeafNode(lv_dequeue_2_0, grammarAccess.getReferenceExpressionAccess().getDequeueQuestionMarkKeyword_1_1_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getReferenceExpressionRule());
                        }
                        setWithLastConsumed($current, "dequeue", lv_dequeue_2_0 != null, "?");
                    }
                )
            )
                |
            (
                otherlv_3=Apostrophe
                {
                    newLeafNode(otherlv_3, grammarAccess.getReferenceExpressionAccess().getApostropheKeyword_1_2_0());
                }
                (
                    (
                        (
                            lv_count_4_0=Count
                            {
                                newLeafNode(lv_count_4_0, grammarAccess.getReferenceExpressionAccess().getCountCountKeyword_1_2_1_0_0());
                            }
                            {
                                if ($current==null) {
                                    $current = createModelElement(grammarAccess.getReferenceExpressionRule());
                                }
                                setWithLastConsumed($current, "count", lv_count_4_0 != null, "count");
                            }
                        )
                    )
                        |
                    (
                        (
                            lv_fresh_5_0=Fresh
                            {
                                newLeafNode(lv_fresh_5_0, grammarAccess.getReferenceExpressionAccess().getFreshFreshKeyword_1_2_1_1_0());
                            }
                            {
                                if ($current==null) {
                                    $current = createModelElement(grammarAccess.getReferenceExpressionRule());
                                }
                                setWithLastConsumed($current, "fresh", lv_fresh_5_0 != null, "fresh");
                            }
                        )
                    )
                )
            )
        )?
    )
;

// Entry rule entryRuleHashPropertyReference
entryRuleHashPropertyReference returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getHashPropertyReferenceRule()); }
    iv_ruleHashPropertyReference=ruleHashPropertyReference
    { $current=$iv_ruleHashPropertyReference.current; }
    EOF;

// Rule HashPropertyReference
ruleHashPropertyReference returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=NumberSign
        {
            newLeafNode(otherlv_0, grammarAccess.getHashPropertyReferenceAccess().getNumberSignKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getPropertyQualifiedNameParserRuleCall_1_0());
                }
                lv_property_1_0=ruleQualifiedName
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getHashPropertyReferenceRule());
                    }
                    set(
                        $current,
                        "property",
                        lv_property_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.QualifiedName");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());
                }
                lv_indexes_2_0=rulePropertyArrayIndex
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getHashPropertyReferenceRule());
                    }
                    add(
                        $current,
                        "indexes",
                        lv_indexes_2_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyArrayIndex");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
        (
            (
                {
                    newCompositeNode(grammarAccess.getHashPropertyReferenceAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());
                }
                lv_fields_3_0=ruleNamedPropertyField
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getHashPropertyReferenceRule());
                    }
                    add(
                        $current,
                        "fields",
                        lv_fields_3_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.NamedPropertyField");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
    )
;

// Entry rule entryRulePropertyReferenceTail
entryRulePropertyReferenceTail returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPropertyReferenceTailRule()); }
    iv_rulePropertyReferenceTail=rulePropertyReferenceTail
    { $current=$iv_rulePropertyReferenceTail.current; }
    EOF;

// Rule PropertyReferenceTail
rulePropertyReferenceTail returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=NumberSign
        {
            newLeafNode(otherlv_0, grammarAccess.getPropertyReferenceTailAccess().getNumberSignKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getPropertyQualifiedNameParserRuleCall_1_0());
                }
                lv_property_1_0=ruleQualifiedName
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getPropertyReferenceTailRule());
                    }
                    set(
                        $current,
                        "property",
                        lv_property_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.QualifiedName");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());
                }
                lv_indexes_2_0=rulePropertyArrayIndex
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getPropertyReferenceTailRule());
                    }
                    add(
                        $current,
                        "indexes",
                        lv_indexes_2_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyArrayIndex");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
        (
            (
                {
                    newCompositeNode(grammarAccess.getPropertyReferenceTailAccess().getFieldsNamedPropertyFieldParserRuleCall_3_0());
                }
                lv_fields_3_0=ruleNamedPropertyField
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getPropertyReferenceTailRule());
                    }
                    add(
                        $current,
                        "fields",
                        lv_fields_3_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.NamedPropertyField");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
    )
;

// Entry rule entryRuleNamedPropertyField
entryRuleNamedPropertyField returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getNamedPropertyFieldRule()); }
    iv_ruleNamedPropertyField=ruleNamedPropertyField
    { $current=$iv_ruleNamedPropertyField.current; }
    EOF;

// Rule NamedPropertyField
ruleNamedPropertyField returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=FullStop
        {
            newLeafNode(otherlv_0, grammarAccess.getNamedPropertyFieldAccess().getFullStopKeyword_0());
        }
        (
            (
                lv_name_1_0=RULE_ID
                {
                    newLeafNode(lv_name_1_0, grammarAccess.getNamedPropertyFieldAccess().getNameIDTerminalRuleCall_1_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getNamedPropertyFieldRule());
                    }
                    setWithLastConsumed(
                        $current,
                        "name",
                        lv_name_1_0,
                        "org.osate.xtext.aadl2.properties.Properties.ID");
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getNamedPropertyFieldAccess().getIndexesPropertyArrayIndexParserRuleCall_2_0());
                }
                lv_indexes_2_0=rulePropertyArrayIndex
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getNamedPropertyFieldRule());
                    }
                    add(
                        $current,
                        "indexes",
                        lv_indexes_2_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyArrayIndex");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
    )
;

// Entry rule entryRulePropertyArrayIndex
entryRulePropertyArrayIndex returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPropertyArrayIndexRule()); }
    iv_rulePropertyArrayIndex=rulePropertyArrayIndex
    { $current=$iv_rulePropertyArrayIndex.current; }
    EOF;

// Rule PropertyArrayIndex
rulePropertyArrayIndex returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=LeftSquareBracket
        {
            newLeafNode(otherlv_0, grammarAccess.getPropertyArrayIndexAccess().getLeftSquareBracketKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getPropertyArrayIndexAccess().getValuePropertyIndexValueParserRuleCall_1_0());
                }
                lv_value_1_0=rulePropertyIndexValue
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getPropertyArrayIndexRule());
                    }
                    set(
                        $current,
                        "value",
                        lv_value_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyIndexValue");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_2=RightSquareBracket
        {
            newLeafNode(otherlv_2, grammarAccess.getPropertyArrayIndexAccess().getRightSquareBracketKeyword_2());
        }
    )
;

// Entry rule entryRulePropertyIndexValue
entryRulePropertyIndexValue returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPropertyIndexValueRule()); }
    iv_rulePropertyIndexValue=rulePropertyIndexValue
    { $current=$iv_rulePropertyIndexValue.current; }
    EOF;

// Rule PropertyIndexValue
rulePropertyIndexValue returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getPropertyIndexValueAccess().getBehaviorIntegerLiteralParserRuleCall_0());
        }
        this_BehaviorIntegerLiteral_0=ruleBehaviorIntegerLiteral
        {
            $current = $this_BehaviorIntegerLiteral_0.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyIndexValueAccess().getPropertyIndexPropertyReferenceParserRuleCall_1());
        }
        this_PropertyIndexPropertyReference_1=rulePropertyIndexPropertyReference
        {
            $current = $this_PropertyIndexPropertyReference_1.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyIndexValueAccess().getUnindexedReferenceExpressionParserRuleCall_2());
        }
        this_UnindexedReferenceExpression_2=ruleUnindexedReferenceExpression
        {
            $current = $this_UnindexedReferenceExpression_2.current;
            afterParserOrEnumRuleCall();
        }
    )
;

// Entry rule entryRulePropertyIndexPropertyReference
entryRulePropertyIndexPropertyReference returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPropertyIndexPropertyReferenceRule()); }
    iv_rulePropertyIndexPropertyReference=rulePropertyIndexPropertyReference
    { $current=$iv_rulePropertyIndexPropertyReference.current; }
    EOF;

// Rule PropertyIndexPropertyReference
rulePropertyIndexPropertyReference returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=NumberSign
        {
            newLeafNode(otherlv_0, grammarAccess.getPropertyIndexPropertyReferenceAccess().getNumberSignKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getPropertyIndexPropertyReferenceAccess().getPropertyQualifiedNameParserRuleCall_1_0());
                }
                lv_property_1_0=ruleQualifiedName
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getPropertyIndexPropertyReferenceRule());
                    }
                    set(
                        $current,
                        "property",
                        lv_property_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.QualifiedName");
                    afterParserOrEnumRuleCall();
                }
            )
        )
    )
;

// Entry rule entryRuleUnindexedReferenceExpression
entryRuleUnindexedReferenceExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getUnindexedReferenceExpressionRule()); }
    iv_ruleUnindexedReferenceExpression=ruleUnindexedReferenceExpression
    { $current=$iv_ruleUnindexedReferenceExpression.current; }
    EOF;

// Rule UnindexedReferenceExpression
ruleUnindexedReferenceExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getUnindexedReferenceExpressionAccess().getReferenceUnindexedReferenceParserRuleCall_0_0());
                }
                lv_reference_0_0=ruleUnindexedReference
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getUnindexedReferenceExpressionRule());
                    }
                    set(
                        $current,
                        "reference",
                        lv_reference_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReference");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                (
                    lv_dequeue_1_0=QuestionMark
                    {
                        newLeafNode(lv_dequeue_1_0, grammarAccess.getUnindexedReferenceExpressionAccess().getDequeueQuestionMarkKeyword_1_0_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getUnindexedReferenceExpressionRule());
                        }
                        setWithLastConsumed($current, "dequeue", lv_dequeue_1_0 != null, "?");
                    }
                )
            )
                |
            (
                otherlv_2=Apostrophe
                {
                    newLeafNode(otherlv_2, grammarAccess.getUnindexedReferenceExpressionAccess().getApostropheKeyword_1_1_0());
                }
                (
                    (
                        (
                            lv_count_3_0=Count
                            {
                                newLeafNode(lv_count_3_0, grammarAccess.getUnindexedReferenceExpressionAccess().getCountCountKeyword_1_1_1_0_0());
                            }
                            {
                                if ($current==null) {
                                    $current = createModelElement(grammarAccess.getUnindexedReferenceExpressionRule());
                                }
                                setWithLastConsumed($current, "count", lv_count_3_0 != null, "count");
                            }
                        )
                    )
                        |
                    (
                        (
                            lv_fresh_4_0=Fresh
                            {
                                newLeafNode(lv_fresh_4_0, grammarAccess.getUnindexedReferenceExpressionAccess().getFreshFreshKeyword_1_1_1_1_0());
                            }
                            {
                                if ($current==null) {
                                    $current = createModelElement(grammarAccess.getUnindexedReferenceExpressionRule());
                                }
                                setWithLastConsumed($current, "fresh", lv_fresh_4_0 != null, "fresh");
                            }
                        )
                    )
                )
            )
        )?
    )
;

// Entry rule entryRuleUnindexedReference
entryRuleUnindexedReference returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getUnindexedReferenceRule()); }
    iv_ruleUnindexedReference=ruleUnindexedReference
    { $current=$iv_ruleUnindexedReference.current; }
    EOF;

// Rule UnindexedReference
ruleUnindexedReference returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getSegmentsUnindexedReferenceSegmentParserRuleCall_0_0());
                }
                lv_segments_0_0=ruleUnindexedReferenceSegment
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getUnindexedReferenceRule());
                    }
                    add(
                        $current,
                        "segments",
                        lv_segments_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceSegment");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getUnindexedReferenceAccess().getTailsUnindexedReferenceTailParserRuleCall_1_0());
                }
                lv_tails_1_0=ruleUnindexedReferenceTail
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getUnindexedReferenceRule());
                    }
                    add(
                        $current,
                        "tails",
                        lv_tails_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceTail");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
    )
;

// Entry rule entryRuleUnindexedReferenceTail
entryRuleUnindexedReferenceTail returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getUnindexedReferenceTailRule()); }
    iv_ruleUnindexedReferenceTail=ruleUnindexedReferenceTail
    { $current=$iv_ruleUnindexedReferenceTail.current; }
    EOF;

// Rule UnindexedReferenceTail
ruleUnindexedReferenceTail returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getUnindexedReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0());
                }
                lv_separator_0_0=ruleReferenceSeparator
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getUnindexedReferenceTailRule());
                    }
                    set(
                        $current,
                        "separator",
                        lv_separator_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSeparator");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getUnindexedReferenceTailAccess().getSegmentUnindexedReferenceSegmentParserRuleCall_1_0());
                }
                lv_segment_1_0=ruleUnindexedReferenceSegment
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getUnindexedReferenceTailRule());
                    }
                    set(
                        $current,
                        "segment",
                        lv_segment_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceSegment");
                    afterParserOrEnumRuleCall();
                }
            )
        )
    )
;

// Entry rule entryRuleUnindexedReferenceSegment
entryRuleUnindexedReferenceSegment returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getUnindexedReferenceSegmentRule()); }
    iv_ruleUnindexedReferenceSegment=ruleUnindexedReferenceSegment
    { $current=$iv_ruleUnindexedReferenceSegment.current; }
    EOF;

// Rule UnindexedReferenceSegment
ruleUnindexedReferenceSegment returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            lv_name_0_0=RULE_ID
            {
                newLeafNode(lv_name_0_0, grammarAccess.getUnindexedReferenceSegmentAccess().getNameIDTerminalRuleCall_0());
            }
            {
                if ($current==null) {
                    $current = createModelElement(grammarAccess.getUnindexedReferenceSegmentRule());
                }
                setWithLastConsumed(
                    $current,
                    "name",
                    lv_name_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.ID");
            }
        )
    )
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
    { newCompositeNode(grammarAccess.getQualifiedNameRule()); }
    iv_ruleQualifiedName=ruleQualifiedName
    { $current=$iv_ruleQualifiedName.current.getText(); }
    EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        this_ID_0=RULE_ID
        {
            $current.merge(this_ID_0);
        }
        {
            newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
        }
        (
            kw=ColonColon
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0());
            }
            this_ID_2=RULE_ID
            {
                $current.merge(this_ID_2);
            }
            {
                newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            }
        )*
    )
;

// Entry rule entryRuleReference
entryRuleReference returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getReferenceRule()); }
    iv_ruleReference=ruleReference
    { $current=$iv_ruleReference.current; }
    EOF;

// Rule Reference
ruleReference returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getReferenceAccess().getSegmentsReferenceSegmentParserRuleCall_0_0());
                }
                lv_segments_0_0=ruleReferenceSegment
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getReferenceRule());
                    }
                    add(
                        $current,
                        "segments",
                        lv_segments_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSegment");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getReferenceAccess().getTailsReferenceTailParserRuleCall_1_0());
                }
                lv_tails_1_0=ruleReferenceTail
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getReferenceRule());
                    }
                    add(
                        $current,
                        "tails",
                        lv_tails_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceTail");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
    )
;

// Entry rule entryRuleReferenceTail
entryRuleReferenceTail returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getReferenceTailRule()); }
    iv_ruleReferenceTail=ruleReferenceTail
    { $current=$iv_ruleReferenceTail.current; }
    EOF;

// Rule ReferenceTail
ruleReferenceTail returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0());
                }
                lv_separator_0_0=ruleReferenceSeparator
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getReferenceTailRule());
                    }
                    set(
                        $current,
                        "separator",
                        lv_separator_0_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSeparator");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getReferenceTailAccess().getSegmentReferenceSegmentParserRuleCall_1_0());
                }
                lv_segment_1_0=ruleReferenceSegment
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getReferenceTailRule());
                    }
                    set(
                        $current,
                        "segment",
                        lv_segment_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSegment");
                    afterParserOrEnumRuleCall();
                }
            )
        )
    )
;

// Entry rule entryRuleReferenceSeparator
entryRuleReferenceSeparator returns [String current=null]:
    { newCompositeNode(grammarAccess.getReferenceSeparatorRule()); }
    iv_ruleReferenceSeparator=ruleReferenceSeparator
    { $current=$iv_ruleReferenceSeparator.current.getText(); }
    EOF;

// Rule ReferenceSeparator
ruleReferenceSeparator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        kw=ColonColon
        {
            $current.merge(kw);
            newLeafNode(kw, grammarAccess.getReferenceSeparatorAccess().getColonColonKeyword_0());
        }
            |
        kw=FullStop
        {
            $current.merge(kw);
            newLeafNode(kw, grammarAccess.getReferenceSeparatorAccess().getFullStopKeyword_1());
        }
    )
;

// Entry rule entryRuleReferenceSegment
entryRuleReferenceSegment returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getReferenceSegmentRule()); }
    iv_ruleReferenceSegment=ruleReferenceSegment
    { $current=$iv_ruleReferenceSegment.current; }
    EOF;

// Rule ReferenceSegment
ruleReferenceSegment returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                lv_name_0_0=RULE_ID
                {
                    newLeafNode(lv_name_0_0, grammarAccess.getReferenceSegmentAccess().getNameIDTerminalRuleCall_0_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getReferenceSegmentRule());
                    }
                    setWithLastConsumed(
                        $current,
                        "name",
                        lv_name_0_0,
                        "org.osate.xtext.aadl2.properties.Properties.ID");
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getReferenceSegmentAccess().getIndexesArrayIndexParserRuleCall_1_0());
                }
                lv_indexes_1_0=ruleArrayIndex
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getReferenceSegmentRule());
                    }
                    add(
                        $current,
                        "indexes",
                        lv_indexes_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.ArrayIndex");
                    afterParserOrEnumRuleCall();
                }
            )
        )*
    )
;

// Entry rule entryRuleArrayIndex
entryRuleArrayIndex returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getArrayIndexRule()); }
    iv_ruleArrayIndex=ruleArrayIndex
    { $current=$iv_ruleArrayIndex.current; }
    EOF;

// Rule ArrayIndex
ruleArrayIndex returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=LeftSquareBracket
        {
            newLeafNode(otherlv_0, grammarAccess.getArrayIndexAccess().getLeftSquareBracketKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getArrayIndexAccess().getValueIntegerValueParserRuleCall_1_0());
                }
                lv_value_1_0=ruleIntegerValue
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getArrayIndexRule());
                    }
                    set(
                        $current,
                        "value",
                        lv_value_1_0,
                        "org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_2=RightSquareBracket
        {
            newLeafNode(otherlv_2, grammarAccess.getArrayIndexAccess().getRightSquareBracketKeyword_2());
        }
    )
;

// Entry rule entryRuleContainedPropertyAssociation
entryRuleContainedPropertyAssociation returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); }
    iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation
    { $current=$iv_ruleContainedPropertyAssociation.current; }
    EOF;

// Rule ContainedPropertyAssociation
ruleContainedPropertyAssociation returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    }
                }
                {
                    newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0());
                }
                ruleQPREF
                {
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=EqualsSignGreaterThanSign
            {
                newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
            }
                |
            (
                (
                    lv_append_2_0=PlusSignEqualsSignGreaterThanSign
                    {
                        newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                        }
                        setWithLastConsumed($current, "append", lv_append_2_0 != null, "+=>");
                    }
                )
            )
        )
        (
            (
                lv_constant_3_0=Constant
                {
                    newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    }
                    setWithLastConsumed($current, "constant", lv_constant_3_0 != null, "constant");
                }
            )
        )?
        (
            (
                (
                    {
                        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0());
                    }
                    lv_ownedValue_4_0=ruleOptionalModalPropertyValue
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                        }
                        add(
                            $current,
                            "ownedValue",
                            lv_ownedValue_4_0,
                            "org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
            (
                otherlv_5=Comma
                {
                    newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
                }
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0());
                        }
                        lv_ownedValue_6_0=ruleOptionalModalPropertyValue
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                            }
                            add(
                                $current,
                                "ownedValue",
                                lv_ownedValue_6_0,
                                "org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
            )*
        )
        (
            otherlv_7=Applies
            {
                newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());
            }
            otherlv_8=To
            {
                newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0());
                    }
                    lv_appliesTo_9_0=ruleContainmentPath
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                        }
                        add(
                            $current,
                            "appliesTo",
                            lv_appliesTo_9_0,
                            "org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
            (
                otherlv_10=Comma
                {
                    newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());
                }
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0());
                        }
                        lv_appliesTo_11_0=ruleContainmentPath
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                            }
                            add(
                                $current,
                                "appliesTo",
                                lv_appliesTo_11_0,
                                "org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
            )*
        )?
        (
            otherlv_12=In
            {
                newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getInKeyword_5_0());
            }
            otherlv_13=Binding
            {
                newLeafNode(otherlv_13, grammarAccess.getContainedPropertyAssociationAccess().getBindingKeyword_5_1());
            }
            otherlv_14=LeftParenthesis
            {
                newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_2());
            }
            (
                (
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                        }
                    }
                    {
                        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_3_0());
                    }
                    ruleQCREF
                    {
                        afterParserOrEnumRuleCall();
                    }
                )
            )
            otherlv_16=RightParenthesis
            {
                newLeafNode(otherlv_16, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_4());
            }
        )?
        otherlv_17=Semicolon
        {
            newLeafNode(otherlv_17, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
        }
    )
;

// Entry rule entryRuleContainmentPath
entryRuleContainmentPath returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getContainmentPathRule()); }
    iv_ruleContainmentPath=ruleContainmentPath
    { $current=$iv_ruleContainmentPath.current; }
    EOF;

// Rule ContainmentPath
ruleContainmentPath returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0());
            }
            lv_path_0_0=ruleContainmentPathElement
            {
                if ($current==null) {
                    $current = createModelElementForParent(grammarAccess.getContainmentPathRule());
                }
                set(
                    $current,
                    "path",
                    lv_path_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
                afterParserOrEnumRuleCall();
            }
        )
    )
;

// Entry rule entryRuleOptionalModalPropertyValue
entryRuleOptionalModalPropertyValue returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); }
    iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue
    { $current=$iv_ruleOptionalModalPropertyValue.current; }
    EOF;

// Rule OptionalModalPropertyValue
ruleOptionalModalPropertyValue returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0());
                }
                lv_ownedValue_0_0=rulePropertyExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
                    }
                    set(
                        $current,
                        "ownedValue",
                        lv_ownedValue_0_0,
                        "org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_1=In
            {
                newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
            }
            otherlv_2=Modes
            {
                newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
            }
            otherlv_3=LeftParenthesis
            {
                newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
            }
            (
                (
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                        }
                    }
                    otherlv_4=RULE_ID
                    {
                        newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0());
                    }
                )
            )
            (
                otherlv_5=Comma
                {
                    newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                }
                (
                    (
                        {
                            if ($current==null) {
                                $current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                            }
                        }
                        otherlv_6=RULE_ID
                        {
                            newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0());
                        }
                    )
                )
            )*
            otherlv_7=RightParenthesis
            {
                newLeafNode(otherlv_7, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_5());
            }
        )?
    )
;

// Entry rule entryRulePropertyValue
entryRulePropertyValue returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPropertyValueRule()); }
    iv_rulePropertyValue=rulePropertyValue
    { $current=$iv_rulePropertyValue.current; }
    EOF;

// Rule PropertyValue
rulePropertyValue returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0());
            }
            lv_ownedValue_0_0=rulePropertyExpression
            {
                if ($current==null) {
                    $current = createModelElementForParent(grammarAccess.getPropertyValueRule());
                }
                set(
                    $current,
                    "ownedValue",
                    lv_ownedValue_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                afterParserOrEnumRuleCall();
            }
        )
    )
;

// Entry rule entryRulePropertyExpression
entryRulePropertyExpression returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getPropertyExpressionRule()); }
    iv_rulePropertyExpression=rulePropertyExpression
    { $current=$iv_rulePropertyExpression.current; }
    EOF;

// Rule PropertyExpression
rulePropertyExpression returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0());
        }
        this_RecordTerm_0=ruleRecordTerm
        {
            $current = $this_RecordTerm_0.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1());
        }
        this_ReferenceTerm_1=ruleReferenceTerm
        {
            $current = $this_ReferenceTerm_1.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2());
        }
        this_ComponentClassifierTerm_2=ruleComponentClassifierTerm
        {
            $current = $this_ComponentClassifierTerm_2.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3());
        }
        this_ComputedTerm_3=ruleComputedTerm
        {
            $current = $this_ComputedTerm_3.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4());
        }
        this_StringTerm_4=ruleStringTerm
        {
            $current = $this_StringTerm_4.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5());
        }
        this_NumericRangeTerm_5=ruleNumericRangeTerm
        {
            $current = $this_NumericRangeTerm_5.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6());
        }
        this_RealTerm_6=ruleRealTerm
        {
            $current = $this_RealTerm_6.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7());
        }
        this_IntegerTerm_7=ruleIntegerTerm
        {
            $current = $this_IntegerTerm_7.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8());
        }
        this_ListTerm_8=ruleListTerm
        {
            $current = $this_ListTerm_8.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9());
        }
        this_BooleanLiteral_9=ruleBooleanLiteral
        {
            $current = $this_BooleanLiteral_9.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10());
        }
        this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm
        {
            $current = $this_LiteralorReferenceTerm_10.current;
            afterParserOrEnumRuleCall();
        }
    )
;

// Entry rule entryRuleLiteralorReferenceTerm
entryRuleLiteralorReferenceTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); }
    iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm
    { $current=$iv_ruleLiteralorReferenceTerm.current; }
    EOF;

// Rule LiteralorReferenceTerm
ruleLiteralorReferenceTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                if ($current==null) {
                    $current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
                }
            }
            {
                newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0());
            }
            ruleQPREF
            {
                afterParserOrEnumRuleCall();
            }
        )
    )
;

// Entry rule entryRuleBooleanLiteral
entryRuleBooleanLiteral returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getBooleanLiteralRule()); }
    iv_ruleBooleanLiteral=ruleBooleanLiteral
    { $current=$iv_ruleBooleanLiteral.current; }
    EOF;

// Rule BooleanLiteral
ruleBooleanLiteral returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                $current = forceCreateModelElement(
                    grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                    $current);
            }
        )
        (
            (
                (
                    lv_value_1_0=True
                    {
                        newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                    }
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getBooleanLiteralRule());
                        }
                        setWithLastConsumed($current, "value", lv_value_1_0 != null, "true");
                    }
                )
            )
                |
            otherlv_2=False
            {
                newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
            }
        )
    )
;

// Entry rule entryRuleConstantValue
entryRuleConstantValue returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getConstantValueRule()); }
    iv_ruleConstantValue=ruleConstantValue
    { $current=$iv_ruleConstantValue.current; }
    EOF;

// Rule ConstantValue
ruleConstantValue returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                if ($current==null) {
                    $current = createModelElement(grammarAccess.getConstantValueRule());
                }
            }
            {
                newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0());
            }
            ruleQPREF
            {
                afterParserOrEnumRuleCall();
            }
        )
    )
;

// Entry rule entryRuleReferenceTerm
entryRuleReferenceTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getReferenceTermRule()); }
    iv_ruleReferenceTerm=ruleReferenceTerm
    { $current=$iv_ruleReferenceTerm.current; }
    EOF;

// Rule ReferenceTerm
ruleReferenceTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=Reference
        {
            newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
        }
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0());
                }
                lv_path_2_0=ruleContainmentPathElement
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getReferenceTermRule());
                    }
                    set(
                        $current,
                        "path",
                        lv_path_2_0,
                        "org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_3=RightParenthesis
        {
            newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
        }
    )
;

// Entry rule entryRuleRecordTerm
entryRuleRecordTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getRecordTermRule()); }
    iv_ruleRecordTerm=ruleRecordTerm
    { $current=$iv_ruleRecordTerm.current; }
    EOF;

// Rule RecordTerm
ruleRecordTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=LeftSquareBracket
        {
            newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0());
                }
                lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getRecordTermRule());
                    }
                    add(
                        $current,
                        "ownedFieldValue",
                        lv_ownedFieldValue_1_0,
                        "org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
                    afterParserOrEnumRuleCall();
                }
            )
        )+
        otherlv_2=RightSquareBracket
        {
            newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
        }
    )
;

// Entry rule entryRuleComputedTerm
entryRuleComputedTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getComputedTermRule()); }
    iv_ruleComputedTerm=ruleComputedTerm
    { $current=$iv_ruleComputedTerm.current; }
    EOF;

// Rule ComputedTerm
ruleComputedTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=Compute
        {
            newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
        }
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                lv_function_2_0=RULE_ID
                {
                    newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0());
                }
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getComputedTermRule());
                    }
                    setWithLastConsumed(
                        $current,
                        "function",
                        lv_function_2_0,
                        "org.osate.xtext.aadl2.properties.Properties.ID");
                }
            )
        )
        otherlv_3=RightParenthesis
        {
            newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
        }
    )
;

// Entry rule entryRuleComponentClassifierTerm
entryRuleComponentClassifierTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getComponentClassifierTermRule()); }
    iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm
    { $current=$iv_ruleComponentClassifierTerm.current; }
    EOF;

// Rule ComponentClassifierTerm
ruleComponentClassifierTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        otherlv_0=Classifier
        {
            newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
        }
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getComponentClassifierTermRule());
                    }
                }
                {
                    newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0());
                }
                ruleQCREF
                {
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_3=RightParenthesis
        {
            newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
        }
    )
;

// Entry rule entryRuleListTerm
entryRuleListTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getListTermRule()); }
    iv_ruleListTerm=ruleListTerm
    { $current=$iv_ruleListTerm.current; }
    EOF;

// Rule ListTerm
ruleListTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                $current = forceCreateModelElement(
                    grammarAccess.getListTermAccess().getListValueAction_0(),
                    $current);
            }
        )
        otherlv_1=LeftParenthesis
        {
            newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
        }
        (
            (
                (
                    {
                        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0());
                    }
                    lv_ownedListElement_2_0=rulePropertyExpression
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getListTermRule());
                        }
                        add(
                            $current,
                            "ownedListElement",
                            lv_ownedListElement_2_0,
                            "org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
            (
                otherlv_3=Comma
                {
                    newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                }
                (
                    (
                        {
                            newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0());
                        }
                        lv_ownedListElement_4_0=rulePropertyExpression
                        {
                            if ($current==null) {
                                $current = createModelElementForParent(grammarAccess.getListTermRule());
                            }
                            add(
                                $current,
                                "ownedListElement",
                                lv_ownedListElement_4_0,
                                "org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                            afterParserOrEnumRuleCall();
                        }
                    )
                )
            )*
        )?
        otherlv_5=RightParenthesis
        {
            newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
        }
    )
;

// Entry rule entryRuleFieldPropertyAssociation
entryRuleFieldPropertyAssociation returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); }
    iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation
    { $current=$iv_ruleFieldPropertyAssociation.current; }
    EOF;

// Rule FieldPropertyAssociation
ruleFieldPropertyAssociation returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
                    }
                }
                otherlv_0=RULE_ID
                {
                    newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0());
                }
            )
        )
        otherlv_1=EqualsSignGreaterThanSign
        {
            newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0());
                }
                lv_ownedValue_2_0=rulePropertyExpression
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
                    }
                    set(
                        $current,
                        "ownedValue",
                        lv_ownedValue_2_0,
                        "org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_3=Semicolon
        {
            newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
        }
    )
;

// Entry rule entryRuleContainmentPathElement
entryRuleContainmentPathElement returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getContainmentPathElementRule()); }
    iv_ruleContainmentPathElement=ruleContainmentPathElement
    { $current=$iv_ruleContainmentPathElement.current; }
    EOF;

// Rule ContainmentPathElement
ruleContainmentPathElement returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                (
                    {
                        if ($current==null) {
                            $current = createModelElement(grammarAccess.getContainmentPathElementRule());
                        }
                    }
                    otherlv_0=RULE_ID
                    {
                        newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0());
                    }
                )
            )
            (
                (
                    {
                        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0());
                    }
                    lv_arrayRange_1_0=ruleArrayRange
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                        }
                        add(
                            $current,
                            "arrayRange",
                            lv_arrayRange_1_0,
                            "org.osate.xtext.aadl2.properties.Properties.ArrayRange");
                        afterParserOrEnumRuleCall();
                    }
                )
            )*
        )
        (
            otherlv_2=FullStop
            {
                newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getFullStopKeyword_1_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_1_1_0());
                    }
                    lv_path_3_0=ruleContainmentPathElement
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                        }
                        set(
                            $current,
                            "path",
                            lv_path_3_0,
                            "org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
    )
;

// Entry rule entryRulePlusMinus
entryRulePlusMinus returns [String current=null]:
    { newCompositeNode(grammarAccess.getPlusMinusRule()); }
    iv_rulePlusMinus=rulePlusMinus
    { $current=$iv_rulePlusMinus.current.getText(); }
    EOF;

// Rule PlusMinus
rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        kw=PlusSign
        {
            $current.merge(kw);
            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0());
        }
            |
        kw=HyphenMinus
        {
            $current.merge(kw);
            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1());
        }
    )
;

// Entry rule entryRuleStringTerm
entryRuleStringTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getStringTermRule()); }
    iv_ruleStringTerm=ruleStringTerm
    { $current=$iv_ruleStringTerm.current; }
    EOF;

// Rule StringTerm
ruleStringTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0());
            }
            lv_value_0_0=ruleNoQuoteString
            {
                if ($current==null) {
                    $current = createModelElementForParent(grammarAccess.getStringTermRule());
                }
                set(
                    $current,
                    "value",
                    lv_value_0_0,
                    "org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
                afterParserOrEnumRuleCall();
            }
        )
    )
;

// Entry rule entryRuleNoQuoteString
entryRuleNoQuoteString returns [String current=null]:
    { newCompositeNode(grammarAccess.getNoQuoteStringRule()); }
    iv_ruleNoQuoteString=ruleNoQuoteString
    { $current=$iv_ruleNoQuoteString.current.getText(); }
    EOF;

// Rule NoQuoteString
ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    this_STRING_0=RULE_STRING
    {
        $current.merge(this_STRING_0);
    }
    {
        newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall());
    }
;

// Entry rule entryRuleArrayRange
entryRuleArrayRange returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getArrayRangeRule()); }
    iv_ruleArrayRange=ruleArrayRange
    { $current=$iv_ruleArrayRange.current; }
    EOF;

// Rule ArrayRange
ruleArrayRange returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            {
                $current = forceCreateModelElement(
                    grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                    $current);
            }
        )
        otherlv_1=LeftSquareBracket
        {
            newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0());
                }
                lv_lowerBound_2_0=ruleINTVALUE
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                    }
                    set(
                        $current,
                        "lowerBound",
                        lv_lowerBound_2_0,
                        "org.osate.xtext.aadl2.properties.Properties.INTVALUE");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_3=FullStopFullStop
            {
                newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0());
                    }
                    lv_upperBound_4_0=ruleINTVALUE
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                        }
                        set(
                            $current,
                            "upperBound",
                            lv_upperBound_4_0,
                            "org.osate.xtext.aadl2.properties.Properties.INTVALUE");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
        otherlv_5=RightSquareBracket
        {
            newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
        }
    )
;

// Entry rule entryRuleSignedConstant
entryRuleSignedConstant returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getSignedConstantRule()); }
    iv_ruleSignedConstant=ruleSignedConstant
    { $current=$iv_ruleSignedConstant.current; }
    EOF;

// Rule SignedConstant
ruleSignedConstant returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0());
                }
                lv_op_0_0=rulePlusMinus
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getSignedConstantRule());
                    }
                    set(
                        $current,
                        "op",
                        lv_op_0_0,
                        "org.osate.xtext.aadl2.properties.Properties.PlusMinus");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0());
                }
                lv_ownedPropertyExpression_1_0=ruleConstantValue
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getSignedConstantRule());
                    }
                    add(
                        $current,
                        "ownedPropertyExpression",
                        lv_ownedPropertyExpression_1_0,
                        "org.osate.xtext.aadl2.properties.Properties.ConstantValue");
                    afterParserOrEnumRuleCall();
                }
            )
        )
    )
;

// Entry rule entryRuleIntegerTerm
entryRuleIntegerTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getIntegerTermRule()); }
    iv_ruleIntegerTerm=ruleIntegerTerm
    { $current=$iv_ruleIntegerTerm.current; }
    EOF;

// Rule IntegerTerm
ruleIntegerTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0());
                }
                lv_value_0_0=ruleSignedInt
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getIntegerTermRule());
                    }
                    set(
                        $current,
                        "value",
                        lv_value_0_0,
                        "org.osate.xtext.aadl2.properties.Properties.SignedInt");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getIntegerTermRule());
                    }
                }
                otherlv_1=RULE_ID
                {
                    newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0());
                }
            )
        )?
    )
;

// Entry rule entryRuleSignedInt
entryRuleSignedInt returns [String current=null]:
    { newCompositeNode(grammarAccess.getSignedIntRule()); }
    iv_ruleSignedInt=ruleSignedInt
    { $current=$iv_ruleSignedInt.current.getText(); }
    EOF;

// Rule SignedInt
ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            kw=PlusSign
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0());
            }
                |
            kw=HyphenMinus
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1());
            }
        )?
        this_INTEGER_LIT_2=RULE_INTEGER_LIT
        {
            $current.merge(this_INTEGER_LIT_2);
        }
        {
            newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1());
        }
    )
;

// Entry rule entryRuleRealTerm
entryRuleRealTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getRealTermRule()); }
    iv_ruleRealTerm=ruleRealTerm
    { $current=$iv_ruleRealTerm.current; }
    EOF;

// Rule RealTerm
ruleRealTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0());
                }
                lv_value_0_0=ruleSignedReal
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getRealTermRule());
                    }
                    set(
                        $current,
                        "value",
                        lv_value_0_0,
                        "org.osate.xtext.aadl2.properties.Properties.SignedReal");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            (
                {
                    if ($current==null) {
                        $current = createModelElement(grammarAccess.getRealTermRule());
                    }
                }
                otherlv_1=RULE_ID
                {
                    newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0());
                }
            )
        )?
    )
;

// Entry rule entryRuleSignedReal
entryRuleSignedReal returns [String current=null]:
    { newCompositeNode(grammarAccess.getSignedRealRule()); }
    iv_ruleSignedReal=ruleSignedReal
    { $current=$iv_ruleSignedReal.current.getText(); }
    EOF;

// Rule SignedReal
ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            kw=PlusSign
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0());
            }
                |
            kw=HyphenMinus
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1());
            }
        )?
        this_REAL_LIT_2=RULE_REAL_LIT
        {
            $current.merge(this_REAL_LIT_2);
        }
        {
            newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1());
        }
    )
;

// Entry rule entryRuleNumericRangeTerm
entryRuleNumericRangeTerm returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getNumericRangeTermRule()); }
    iv_ruleNumericRangeTerm=ruleNumericRangeTerm
    { $current=$iv_ruleNumericRangeTerm.current; }
    EOF;

// Rule NumericRangeTerm
ruleNumericRangeTerm returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            (
                {
                    newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0());
                }
                lv_minimum_0_0=ruleNumAlt
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                    }
                    set(
                        $current,
                        "minimum",
                        lv_minimum_0_0,
                        "org.osate.xtext.aadl2.properties.Properties.NumAlt");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        otherlv_1=FullStopFullStop
        {
            newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
        }
        (
            (
                {
                    newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0());
                }
                lv_maximum_2_0=ruleNumAlt
                {
                    if ($current==null) {
                        $current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                    }
                    set(
                        $current,
                        "maximum",
                        lv_maximum_2_0,
                        "org.osate.xtext.aadl2.properties.Properties.NumAlt");
                    afterParserOrEnumRuleCall();
                }
            )
        )
        (
            otherlv_3=Delta
            {
                newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
            }
            (
                (
                    {
                        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0());
                    }
                    lv_delta_4_0=ruleNumAlt
                    {
                        if ($current==null) {
                            $current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                        }
                        set(
                            $current,
                            "delta",
                            lv_delta_4_0,
                            "org.osate.xtext.aadl2.properties.Properties.NumAlt");
                        afterParserOrEnumRuleCall();
                    }
                )
            )
        )?
    )
;

// Entry rule entryRuleNumAlt
entryRuleNumAlt returns [EObject current=null]:
    { newCompositeNode(grammarAccess.getNumAltRule()); }
    iv_ruleNumAlt=ruleNumAlt
    { $current=$iv_ruleNumAlt.current; }
    EOF;

// Rule NumAlt
ruleNumAlt returns [EObject current=null]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        {
            newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0());
        }
        this_RealTerm_0=ruleRealTerm
        {
            $current = $this_RealTerm_0.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1());
        }
        this_IntegerTerm_1=ruleIntegerTerm
        {
            $current = $this_IntegerTerm_1.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2());
        }
        this_SignedConstant_2=ruleSignedConstant
        {
            $current = $this_SignedConstant_2.current;
            afterParserOrEnumRuleCall();
        }
            |
        {
            newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3());
        }
        this_ConstantValue_3=ruleConstantValue
        {
            $current = $this_ConstantValue_3.current;
            afterParserOrEnumRuleCall();
        }
    )
;

// Entry rule entryRuleINTVALUE
entryRuleINTVALUE returns [String current=null]:
    { newCompositeNode(grammarAccess.getINTVALUERule()); }
    iv_ruleINTVALUE=ruleINTVALUE
    { $current=$iv_ruleINTVALUE.current.getText(); }
    EOF;

// Rule INTVALUE
ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    this_INTEGER_LIT_0=RULE_INTEGER_LIT
    {
        $current.merge(this_INTEGER_LIT_0);
    }
    {
        newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall());
    }
;

// Entry rule entryRuleQPREF
entryRuleQPREF returns [String current=null]:
    { newCompositeNode(grammarAccess.getQPREFRule()); }
    iv_ruleQPREF=ruleQPREF
    { $current=$iv_ruleQPREF.current.getText(); }
    EOF;

// Rule QPREF
ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        this_ID_0=RULE_ID
        {
            $current.merge(this_ID_0);
        }
        {
            newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0());
        }
        (
            kw=ColonColon
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0());
            }
            this_ID_2=RULE_ID
            {
                $current.merge(this_ID_2);
            }
            {
                newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1());
            }
        )?
    )
;

// Entry rule entryRuleQCREF
entryRuleQCREF returns [String current=null]:
    { newCompositeNode(grammarAccess.getQCREFRule()); }
    iv_ruleQCREF=ruleQCREF
    { $current=$iv_ruleQCREF.current.getText(); }
    EOF;

// Rule QCREF
ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    (
        (
            this_ID_0=RULE_ID
            {
                $current.merge(this_ID_0);
            }
            {
                newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0());
            }
            kw=ColonColon
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1());
            }
        )*
        this_ID_2=RULE_ID
        {
            $current.merge(this_ID_2);
        }
        {
            newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1());
        }
        (
            kw=FullStop
            {
                $current.merge(kw);
                newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0());
            }
            this_ID_4=RULE_ID
            {
                $current.merge(this_ID_4);
            }
            {
                newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1());
            }
        )?
    )
;

// Entry rule entryRuleSTAR
entryRuleSTAR returns [String current=null]:
    { newCompositeNode(grammarAccess.getSTARRule()); }
    iv_ruleSTAR=ruleSTAR
    { $current=$iv_ruleSTAR.current.getText(); }
    EOF;

// Rule STAR
ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
    enterRule();
}
@after {
    leaveRule();
}:
    kw=Asterisk
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword());
    }
;
