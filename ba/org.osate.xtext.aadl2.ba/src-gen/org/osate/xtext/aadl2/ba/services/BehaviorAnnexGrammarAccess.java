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
package org.osate.xtext.aadl2.ba.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;

@Singleton
public class BehaviorAnnexGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class AnnexSubclauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.AnnexSubclause");
		private final RuleCall cBehaviorAnnexParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AnnexSubclause returns aadl2::AnnexSubclause:
		//    BehaviorAnnex
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//BehaviorAnnex
		public RuleCall getBehaviorAnnexParserRuleCall() { return cBehaviorAnnexParserRuleCall; }
	}
	public class BehaviorAnnexElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAnnex");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBehaviorAnnexAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cVariablesKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cVariableGroupsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cVariableGroupsBehaviorVariableGroupParserRuleCall_1_1_0 = (RuleCall)cVariableGroupsAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cStatesKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cStateGroupsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cStateGroupsBehaviorStateGroupParserRuleCall_2_1_0 = (RuleCall)cStateGroupsAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cTransitionsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTransitionsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTransitionsBehaviorTransitionParserRuleCall_3_1_0 = (RuleCall)cTransitionsAssignment_3_1.eContents().get(0);
		
		//BehaviorAnnex:
		//    {BehaviorAnnex}
		//    ('variables' variableGroups+=BehaviorVariableGroup+)?
		//    ('states' stateGroups+=BehaviorStateGroup+)?
		//    ('transitions' transitions+=BehaviorTransition+)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{BehaviorAnnex}
		//('variables' variableGroups+=BehaviorVariableGroup+)?
		//('states' stateGroups+=BehaviorStateGroup+)?
		//('transitions' transitions+=BehaviorTransition+)?
		public Group getGroup() { return cGroup; }
		
		//{BehaviorAnnex}
		public Action getBehaviorAnnexAction_0() { return cBehaviorAnnexAction_0; }
		
		//('variables' variableGroups+=BehaviorVariableGroup+)?
		public Group getGroup_1() { return cGroup_1; }
		
		//'variables'
		public Keyword getVariablesKeyword_1_0() { return cVariablesKeyword_1_0; }
		
		//variableGroups+=BehaviorVariableGroup+
		public Assignment getVariableGroupsAssignment_1_1() { return cVariableGroupsAssignment_1_1; }
		
		//BehaviorVariableGroup
		public RuleCall getVariableGroupsBehaviorVariableGroupParserRuleCall_1_1_0() { return cVariableGroupsBehaviorVariableGroupParserRuleCall_1_1_0; }
		
		//('states' stateGroups+=BehaviorStateGroup+)?
		public Group getGroup_2() { return cGroup_2; }
		
		//'states'
		public Keyword getStatesKeyword_2_0() { return cStatesKeyword_2_0; }
		
		//stateGroups+=BehaviorStateGroup+
		public Assignment getStateGroupsAssignment_2_1() { return cStateGroupsAssignment_2_1; }
		
		//BehaviorStateGroup
		public RuleCall getStateGroupsBehaviorStateGroupParserRuleCall_2_1_0() { return cStateGroupsBehaviorStateGroupParserRuleCall_2_1_0; }
		
		//('transitions' transitions+=BehaviorTransition+)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'transitions'
		public Keyword getTransitionsKeyword_3_0() { return cTransitionsKeyword_3_0; }
		
		//transitions+=BehaviorTransition+
		public Assignment getTransitionsAssignment_3_1() { return cTransitionsAssignment_3_1; }
		
		//BehaviorTransition
		public RuleCall getTransitionsBehaviorTransitionParserRuleCall_3_1_0() { return cTransitionsBehaviorTransitionParserRuleCall_3_1_0; }
	}
	public class BehaviorVariableGroupElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariableGroup");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVariablesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cVariablesBehaviorVariableParserRuleCall_0_0 = (RuleCall)cVariablesAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cVariablesAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cVariablesBehaviorVariableParserRuleCall_1_1_0 = (RuleCall)cVariablesAssignment_1_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cDataClassifierAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cDataClassifierComponentClassifierCrossReference_3_0 = (CrossReference)cDataClassifierAssignment_3.eContents().get(0);
		private final RuleCall cDataClassifierComponentClassifierQCREFParserRuleCall_3_0_1 = (RuleCall)cDataClassifierComponentClassifierCrossReference_3_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonEqualsSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cInitialValueAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cInitialValueValueConstantParserRuleCall_4_1_0 = (RuleCall)cInitialValueAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLeftCurlyBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cPropertyAssociationsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cPropertyAssociationsBehaviorPropertyAssociationParserRuleCall_5_1_0 = (RuleCall)cPropertyAssociationsAssignment_5_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//BehaviorVariableGroup:
		//    variables+=BehaviorVariable (',' variables+=BehaviorVariable)*
		//    ':' dataClassifier=[aadl2::ComponentClassifier|QCREF]
		//    (':=' initialValue=ValueConstant)?
		//    ('{' propertyAssociations+=BehaviorPropertyAssociation+ '}')?
		//    ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//variables+=BehaviorVariable (',' variables+=BehaviorVariable)*
		//':' dataClassifier=[aadl2::ComponentClassifier|QCREF]
		//(':=' initialValue=ValueConstant)?
		//('{' propertyAssociations+=BehaviorPropertyAssociation+ '}')?
		//';'
		public Group getGroup() { return cGroup; }
		
		//variables+=BehaviorVariable
		public Assignment getVariablesAssignment_0() { return cVariablesAssignment_0; }
		
		//BehaviorVariable
		public RuleCall getVariablesBehaviorVariableParserRuleCall_0_0() { return cVariablesBehaviorVariableParserRuleCall_0_0; }
		
		//(',' variables+=BehaviorVariable)*
		public Group getGroup_1() { return cGroup_1; }
		
		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }
		
		//variables+=BehaviorVariable
		public Assignment getVariablesAssignment_1_1() { return cVariablesAssignment_1_1; }
		
		//BehaviorVariable
		public RuleCall getVariablesBehaviorVariableParserRuleCall_1_1_0() { return cVariablesBehaviorVariableParserRuleCall_1_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//dataClassifier=[aadl2::ComponentClassifier|QCREF]
		public Assignment getDataClassifierAssignment_3() { return cDataClassifierAssignment_3; }
		
		//[aadl2::ComponentClassifier|QCREF]
		public CrossReference getDataClassifierComponentClassifierCrossReference_3_0() { return cDataClassifierComponentClassifierCrossReference_3_0; }
		
		//QCREF
		public RuleCall getDataClassifierComponentClassifierQCREFParserRuleCall_3_0_1() { return cDataClassifierComponentClassifierQCREFParserRuleCall_3_0_1; }
		
		//(':=' initialValue=ValueConstant)?
		public Group getGroup_4() { return cGroup_4; }
		
		//':='
		public Keyword getColonEqualsSignKeyword_4_0() { return cColonEqualsSignKeyword_4_0; }
		
		//initialValue=ValueConstant
		public Assignment getInitialValueAssignment_4_1() { return cInitialValueAssignment_4_1; }
		
		//ValueConstant
		public RuleCall getInitialValueValueConstantParserRuleCall_4_1_0() { return cInitialValueValueConstantParserRuleCall_4_1_0; }
		
		//('{' propertyAssociations+=BehaviorPropertyAssociation+ '}')?
		public Group getGroup_5() { return cGroup_5; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_5_0() { return cLeftCurlyBracketKeyword_5_0; }
		
		//propertyAssociations+=BehaviorPropertyAssociation+
		public Assignment getPropertyAssociationsAssignment_5_1() { return cPropertyAssociationsAssignment_5_1; }
		
		//BehaviorPropertyAssociation
		public RuleCall getPropertyAssociationsBehaviorPropertyAssociationParserRuleCall_5_1_0() { return cPropertyAssociationsBehaviorPropertyAssociationParserRuleCall_5_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_5_2() { return cRightCurlyBracketKeyword_5_2; }
		
		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}
	public class BehaviorVariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorVariable");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Assignment cArrayDimensionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cArrayDimensionsArrayDimensionParserRuleCall_1_0 = (RuleCall)cArrayDimensionsAssignment_1.eContents().get(0);
		
		//BehaviorVariable:
		//    name=ID arrayDimensions+=ArrayDimension*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID arrayDimensions+=ArrayDimension*
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//arrayDimensions+=ArrayDimension*
		public Assignment getArrayDimensionsAssignment_1() { return cArrayDimensionsAssignment_1; }
		
		//ArrayDimension
		public RuleCall getArrayDimensionsArrayDimensionParserRuleCall_1_0() { return cArrayDimensionsArrayDimensionParserRuleCall_1_0; }
	}
	public class ArrayDimensionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ArrayDimension");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cSizeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSizeIntegerValueParserRuleCall_1_0 = (RuleCall)cSizeAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ArrayDimension:
		//    '[' size=IntegerValue ']'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'[' size=IntegerValue ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//size=IntegerValue
		public Assignment getSizeAssignment_1() { return cSizeAssignment_1; }
		
		//IntegerValue
		public RuleCall getSizeIntegerValueParserRuleCall_1_0() { return cSizeIntegerValueParserRuleCall_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}
	public class BehaviorPropertyAssociationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorPropertyAssociation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyPropertyQPREFParserRuleCall_0_0_1 = (RuleCall)cPropertyPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedValuePropertyExpressionParserRuleCall_2_0 = (RuleCall)cOwnedValueAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//BehaviorPropertyAssociation:
		//    property=[aadl2::Property|QPREF] '=>' ownedValue=PropertyExpression ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//property=[aadl2::Property|QPREF] '=>' ownedValue=PropertyExpression ';'
		public Group getGroup() { return cGroup; }
		
		//property=[aadl2::Property|QPREF]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }
		
		//[aadl2::Property|QPREF]
		public CrossReference getPropertyPropertyCrossReference_0_0() { return cPropertyPropertyCrossReference_0_0; }
		
		//QPREF
		public RuleCall getPropertyPropertyQPREFParserRuleCall_0_0_1() { return cPropertyPropertyQPREFParserRuleCall_0_0_1; }
		
		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }
		
		//ownedValue=PropertyExpression
		public Assignment getOwnedValueAssignment_2() { return cOwnedValueAssignment_2; }
		
		//PropertyExpression
		public RuleCall getOwnedValuePropertyExpressionParserRuleCall_2_0() { return cOwnedValuePropertyExpressionParserRuleCall_2_0; }
		
		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}
	public class BehaviorStateGroupElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorStateGroup");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cStatesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cStatesBehaviorStateParserRuleCall_0_0 = (RuleCall)cStatesAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cCommaKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cStatesAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cStatesBehaviorStateParserRuleCall_1_1_0 = (RuleCall)cStatesAssignment_1_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cInitialAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final Keyword cInitialInitialKeyword_3_0 = (Keyword)cInitialAssignment_3.eContents().get(0);
		private final Assignment cCompleteAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final Keyword cCompleteCompleteKeyword_4_0 = (Keyword)cCompleteAssignment_4.eContents().get(0);
		private final Assignment cFinalAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final Keyword cFinalFinalKeyword_5_0 = (Keyword)cFinalAssignment_5.eContents().get(0);
		private final Keyword cStateKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cSemicolonKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//BehaviorStateGroup:
		//    states+=BehaviorState (',' states+=BehaviorState)*
		//    ':' initial?='initial'? complete?='complete'? final?='final'? 'state' ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//states+=BehaviorState (',' states+=BehaviorState)*
		//':' initial?='initial'? complete?='complete'? final?='final'? 'state' ';'
		public Group getGroup() { return cGroup; }
		
		//states+=BehaviorState
		public Assignment getStatesAssignment_0() { return cStatesAssignment_0; }
		
		//BehaviorState
		public RuleCall getStatesBehaviorStateParserRuleCall_0_0() { return cStatesBehaviorStateParserRuleCall_0_0; }
		
		//(',' states+=BehaviorState)*
		public Group getGroup_1() { return cGroup_1; }
		
		//','
		public Keyword getCommaKeyword_1_0() { return cCommaKeyword_1_0; }
		
		//states+=BehaviorState
		public Assignment getStatesAssignment_1_1() { return cStatesAssignment_1_1; }
		
		//BehaviorState
		public RuleCall getStatesBehaviorStateParserRuleCall_1_1_0() { return cStatesBehaviorStateParserRuleCall_1_1_0; }
		
		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }
		
		//initial?='initial'?
		public Assignment getInitialAssignment_3() { return cInitialAssignment_3; }
		
		//'initial'
		public Keyword getInitialInitialKeyword_3_0() { return cInitialInitialKeyword_3_0; }
		
		//complete?='complete'?
		public Assignment getCompleteAssignment_4() { return cCompleteAssignment_4; }
		
		//'complete'
		public Keyword getCompleteCompleteKeyword_4_0() { return cCompleteCompleteKeyword_4_0; }
		
		//final?='final'?
		public Assignment getFinalAssignment_5() { return cFinalAssignment_5; }
		
		//'final'
		public Keyword getFinalFinalKeyword_5_0() { return cFinalFinalKeyword_5_0; }
		
		//'state'
		public Keyword getStateKeyword_6() { return cStateKeyword_6; }
		
		//';'
		public Keyword getSemicolonKeyword_7() { return cSemicolonKeyword_7; }
	}
	public class BehaviorStateElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorState");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//BehaviorState:
		//    name=ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class BehaviorTransitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTransition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Assignment cPriorityAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cPriorityINTEGER_LITTerminalRuleCall_0_1_1_0 = (RuleCall)cPriorityAssignment_0_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_0_1_2 = (Keyword)cGroup_0_1.eContents().get(2);
		private final Keyword cColonKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Assignment cSourceStatesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cSourceStatesBehaviorStateCrossReference_1_0 = (CrossReference)cSourceStatesAssignment_1.eContents().get(0);
		private final RuleCall cSourceStatesBehaviorStateIDTerminalRuleCall_1_0_1 = (RuleCall)cSourceStatesBehaviorStateCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cCommaKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSourceStatesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cSourceStatesBehaviorStateCrossReference_2_1_0 = (CrossReference)cSourceStatesAssignment_2_1.eContents().get(0);
		private final RuleCall cSourceStatesBehaviorStateIDTerminalRuleCall_2_1_0_1 = (RuleCall)cSourceStatesBehaviorStateCrossReference_2_1_0.eContents().get(1);
		private final Keyword cHyphenMinusLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cConditionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cConditionBehaviorConditionParserRuleCall_4_0 = (RuleCall)cConditionAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketHyphenMinusGreaterThanSignKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDestinationStateAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cDestinationStateBehaviorStateCrossReference_6_0 = (CrossReference)cDestinationStateAssignment_6.eContents().get(0);
		private final RuleCall cDestinationStateBehaviorStateIDTerminalRuleCall_6_0_1 = (RuleCall)cDestinationStateBehaviorStateCrossReference_6_0.eContents().get(1);
		private final Assignment cActionBlockAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cActionBlockBehaviorActionBlockParserRuleCall_7_0 = (RuleCall)cActionBlockAssignment_7.eContents().get(0);
		private final Keyword cSemicolonKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//BehaviorTransition:
		//    (name=ID ('[' priority=INTEGER_LIT ']')? ':')?
		//    sourceStates+=[BehaviorState|ID] (',' sourceStates+=[BehaviorState|ID])*
		//    '-[' condition=BehaviorCondition? ']->'
		//    destinationState=[BehaviorState|ID]
		//    actionBlock=BehaviorActionBlock?
		//    ';'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(name=ID ('[' priority=INTEGER_LIT ']')? ':')?
		//sourceStates+=[BehaviorState|ID] (',' sourceStates+=[BehaviorState|ID])*
		//'-[' condition=BehaviorCondition? ']->'
		//destinationState=[BehaviorState|ID]
		//actionBlock=BehaviorActionBlock?
		//';'
		public Group getGroup() { return cGroup; }
		
		//(name=ID ('[' priority=INTEGER_LIT ']')? ':')?
		public Group getGroup_0() { return cGroup_0; }
		
		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }
		
		//('[' priority=INTEGER_LIT ']')?
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0_1_0() { return cLeftSquareBracketKeyword_0_1_0; }
		
		//priority=INTEGER_LIT
		public Assignment getPriorityAssignment_0_1_1() { return cPriorityAssignment_0_1_1; }
		
		//INTEGER_LIT
		public RuleCall getPriorityINTEGER_LITTerminalRuleCall_0_1_1_0() { return cPriorityINTEGER_LITTerminalRuleCall_0_1_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_0_1_2() { return cRightSquareBracketKeyword_0_1_2; }
		
		//':'
		public Keyword getColonKeyword_0_2() { return cColonKeyword_0_2; }
		
		//sourceStates+=[BehaviorState|ID]
		public Assignment getSourceStatesAssignment_1() { return cSourceStatesAssignment_1; }
		
		//[BehaviorState|ID]
		public CrossReference getSourceStatesBehaviorStateCrossReference_1_0() { return cSourceStatesBehaviorStateCrossReference_1_0; }
		
		//ID
		public RuleCall getSourceStatesBehaviorStateIDTerminalRuleCall_1_0_1() { return cSourceStatesBehaviorStateIDTerminalRuleCall_1_0_1; }
		
		//(',' sourceStates+=[BehaviorState|ID])*
		public Group getGroup_2() { return cGroup_2; }
		
		//','
		public Keyword getCommaKeyword_2_0() { return cCommaKeyword_2_0; }
		
		//sourceStates+=[BehaviorState|ID]
		public Assignment getSourceStatesAssignment_2_1() { return cSourceStatesAssignment_2_1; }
		
		//[BehaviorState|ID]
		public CrossReference getSourceStatesBehaviorStateCrossReference_2_1_0() { return cSourceStatesBehaviorStateCrossReference_2_1_0; }
		
		//ID
		public RuleCall getSourceStatesBehaviorStateIDTerminalRuleCall_2_1_0_1() { return cSourceStatesBehaviorStateIDTerminalRuleCall_2_1_0_1; }
		
		//'-['
		public Keyword getHyphenMinusLeftSquareBracketKeyword_3() { return cHyphenMinusLeftSquareBracketKeyword_3; }
		
		//condition=BehaviorCondition?
		public Assignment getConditionAssignment_4() { return cConditionAssignment_4; }
		
		//BehaviorCondition
		public RuleCall getConditionBehaviorConditionParserRuleCall_4_0() { return cConditionBehaviorConditionParserRuleCall_4_0; }
		
		//']->'
		public Keyword getRightSquareBracketHyphenMinusGreaterThanSignKeyword_5() { return cRightSquareBracketHyphenMinusGreaterThanSignKeyword_5; }
		
		//destinationState=[BehaviorState|ID]
		public Assignment getDestinationStateAssignment_6() { return cDestinationStateAssignment_6; }
		
		//[BehaviorState|ID]
		public CrossReference getDestinationStateBehaviorStateCrossReference_6_0() { return cDestinationStateBehaviorStateCrossReference_6_0; }
		
		//ID
		public RuleCall getDestinationStateBehaviorStateIDTerminalRuleCall_6_0_1() { return cDestinationStateBehaviorStateIDTerminalRuleCall_6_0_1; }
		
		//actionBlock=BehaviorActionBlock?
		public Assignment getActionBlockAssignment_7() { return cActionBlockAssignment_7; }
		
		//BehaviorActionBlock
		public RuleCall getActionBlockBehaviorActionBlockParserRuleCall_7_0() { return cActionBlockBehaviorActionBlockParserRuleCall_7_0; }
		
		//';'
		public Keyword getSemicolonKeyword_8() { return cSemicolonKeyword_8; }
	}
	public class BehaviorConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorCondition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cOnKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Alternatives cAlternatives_0_1 = (Alternatives)cGroup_0.eContents().get(1);
		private final Assignment cDispatchAssignment_0_1_0 = (Assignment)cAlternatives_0_1.eContents().get(0);
		private final RuleCall cDispatchDispatchConditionParserRuleCall_0_1_0_0 = (RuleCall)cDispatchAssignment_0_1_0.eContents().get(0);
		private final Assignment cInternalAssignment_0_1_1 = (Assignment)cAlternatives_0_1.eContents().get(1);
		private final RuleCall cInternalInternalConditionParserRuleCall_0_1_1_0 = (RuleCall)cInternalAssignment_0_1_1.eContents().get(0);
		private final Assignment cModeSwitchAssignment_0_1_2 = (Assignment)cAlternatives_0_1.eContents().get(2);
		private final RuleCall cModeSwitchModeSwitchConditionParserRuleCall_0_1_2_0 = (RuleCall)cModeSwitchAssignment_0_1_2.eContents().get(0);
		private final Assignment cExecuteAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cExecuteExecuteConditionParserRuleCall_1_0 = (RuleCall)cExecuteAssignment_1.eContents().get(0);
		
		//BehaviorCondition:
		//    'on' (dispatch=DispatchCondition | internal=InternalCondition | modeSwitch=ModeSwitchCondition)
		//    | execute=ExecuteCondition
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'on' (dispatch=DispatchCondition | internal=InternalCondition | modeSwitch=ModeSwitchCondition)
		//| execute=ExecuteCondition
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'on' (dispatch=DispatchCondition | internal=InternalCondition | modeSwitch=ModeSwitchCondition)
		public Group getGroup_0() { return cGroup_0; }
		
		//'on'
		public Keyword getOnKeyword_0_0() { return cOnKeyword_0_0; }
		
		//(dispatch=DispatchCondition | internal=InternalCondition | modeSwitch=ModeSwitchCondition)
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }
		
		//dispatch=DispatchCondition
		public Assignment getDispatchAssignment_0_1_0() { return cDispatchAssignment_0_1_0; }
		
		//DispatchCondition
		public RuleCall getDispatchDispatchConditionParserRuleCall_0_1_0_0() { return cDispatchDispatchConditionParserRuleCall_0_1_0_0; }
		
		//internal=InternalCondition
		public Assignment getInternalAssignment_0_1_1() { return cInternalAssignment_0_1_1; }
		
		//InternalCondition
		public RuleCall getInternalInternalConditionParserRuleCall_0_1_1_0() { return cInternalInternalConditionParserRuleCall_0_1_1_0; }
		
		//modeSwitch=ModeSwitchCondition
		public Assignment getModeSwitchAssignment_0_1_2() { return cModeSwitchAssignment_0_1_2; }
		
		//ModeSwitchCondition
		public RuleCall getModeSwitchModeSwitchConditionParserRuleCall_0_1_2_0() { return cModeSwitchModeSwitchConditionParserRuleCall_0_1_2_0; }
		
		//execute=ExecuteCondition
		public Assignment getExecuteAssignment_1() { return cExecuteAssignment_1; }
		
		//ExecuteCondition
		public RuleCall getExecuteExecuteConditionParserRuleCall_1_0() { return cExecuteExecuteConditionParserRuleCall_1_0; }
	}
	public class ExecuteConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ExecuteCondition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cValueValueExpressionParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cTimeoutAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cTimeoutTimeoutKeyword_1_0 = (Keyword)cTimeoutAssignment_1.eContents().get(0);
		private final Assignment cOtherwiseAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final Keyword cOtherwiseOtherwiseKeyword_2_0 = (Keyword)cOtherwiseAssignment_2.eContents().get(0);
		
		//ExecuteCondition:
		//    value=ValueExpression
		//    | timeout?='timeout'
		//    | otherwise?='otherwise'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=ValueExpression
		//| timeout?='timeout'
		//| otherwise?='otherwise'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//value=ValueExpression
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }
		
		//ValueExpression
		public RuleCall getValueValueExpressionParserRuleCall_0_0() { return cValueValueExpressionParserRuleCall_0_0; }
		
		//timeout?='timeout'
		public Assignment getTimeoutAssignment_1() { return cTimeoutAssignment_1; }
		
		//'timeout'
		public Keyword getTimeoutTimeoutKeyword_1_0() { return cTimeoutTimeoutKeyword_1_0; }
		
		//otherwise?='otherwise'
		public Assignment getOtherwiseAssignment_2() { return cOtherwiseAssignment_2; }
		
		//'otherwise'
		public Keyword getOtherwiseOtherwiseKeyword_2_0() { return cOtherwiseOtherwiseKeyword_2_0; }
	}
	public class DispatchConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchCondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDispatchConditionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cDispatchKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTriggerAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTriggerDispatchTriggerConditionParserRuleCall_2_0 = (RuleCall)cTriggerAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFrozenKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cFrozenPortsAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final RuleCall cFrozenPortsReferenceParserRuleCall_3_2_0 = (RuleCall)cFrozenPortsAssignment_3_2.eContents().get(0);
		private final Group cGroup_3_3 = (Group)cGroup_3.eContents().get(3);
		private final Keyword cCommaKeyword_3_3_0 = (Keyword)cGroup_3_3.eContents().get(0);
		private final Assignment cFrozenPortsAssignment_3_3_1 = (Assignment)cGroup_3_3.eContents().get(1);
		private final RuleCall cFrozenPortsReferenceParserRuleCall_3_3_1_0 = (RuleCall)cFrozenPortsAssignment_3_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_4 = (Keyword)cGroup_3.eContents().get(4);
		
		//// Both the trigger and the frozen port list are optional, so the action creates the object for a bare 'on dispatch'.
		//DispatchCondition:
		//    {DispatchCondition} 'dispatch' trigger=DispatchTriggerCondition?
		//    ('frozen' '(' frozenPorts+=Reference (',' frozenPorts+=Reference)* ')')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{DispatchCondition} 'dispatch' trigger=DispatchTriggerCondition?
		//('frozen' '(' frozenPorts+=Reference (',' frozenPorts+=Reference)* ')')?
		public Group getGroup() { return cGroup; }
		
		//{DispatchCondition}
		public Action getDispatchConditionAction_0() { return cDispatchConditionAction_0; }
		
		//'dispatch'
		public Keyword getDispatchKeyword_1() { return cDispatchKeyword_1; }
		
		//trigger=DispatchTriggerCondition?
		public Assignment getTriggerAssignment_2() { return cTriggerAssignment_2; }
		
		//DispatchTriggerCondition
		public RuleCall getTriggerDispatchTriggerConditionParserRuleCall_2_0() { return cTriggerDispatchTriggerConditionParserRuleCall_2_0; }
		
		//('frozen' '(' frozenPorts+=Reference (',' frozenPorts+=Reference)* ')')?
		public Group getGroup_3() { return cGroup_3; }
		
		//'frozen'
		public Keyword getFrozenKeyword_3_0() { return cFrozenKeyword_3_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3_1() { return cLeftParenthesisKeyword_3_1; }
		
		//frozenPorts+=Reference
		public Assignment getFrozenPortsAssignment_3_2() { return cFrozenPortsAssignment_3_2; }
		
		//Reference
		public RuleCall getFrozenPortsReferenceParserRuleCall_3_2_0() { return cFrozenPortsReferenceParserRuleCall_3_2_0; }
		
		//(',' frozenPorts+=Reference)*
		public Group getGroup_3_3() { return cGroup_3_3; }
		
		//','
		public Keyword getCommaKeyword_3_3_0() { return cCommaKeyword_3_3_0; }
		
		//frozenPorts+=Reference
		public Assignment getFrozenPortsAssignment_3_3_1() { return cFrozenPortsAssignment_3_3_1; }
		
		//Reference
		public RuleCall getFrozenPortsReferenceParserRuleCall_3_3_1_0() { return cFrozenPortsReferenceParserRuleCall_3_3_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3_4() { return cRightParenthesisKeyword_3_4; }
	}
	public class DispatchTriggerConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchTriggerCondition");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cExpressionAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cExpressionDispatchTriggerLogicalExpressionParserRuleCall_0_0 = (RuleCall)cExpressionAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cTimeoutAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cTimeoutTimeoutKeyword_1_0_0 = (Keyword)cTimeoutAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cGroup_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Assignment cResetPortsAssignment_1_1_1 = (Assignment)cGroup_1_1.eContents().get(1);
		private final RuleCall cResetPortsReferenceParserRuleCall_1_1_1_0 = (RuleCall)cResetPortsAssignment_1_1_1.eContents().get(0);
		private final Group cGroup_1_1_2 = (Group)cGroup_1_1.eContents().get(2);
		private final Keyword cOrKeyword_1_1_2_0 = (Keyword)cGroup_1_1_2.eContents().get(0);
		private final Assignment cResetPortsAssignment_1_1_2_1 = (Assignment)cGroup_1_1_2.eContents().get(1);
		private final RuleCall cResetPortsReferenceParserRuleCall_1_1_2_1_0 = (RuleCall)cResetPortsAssignment_1_1_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_1_3 = (Keyword)cGroup_1_1.eContents().get(3);
		private final Assignment cTimeAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cTimeBehaviorTimeParserRuleCall_1_2_0 = (RuleCall)cTimeAssignment_1_2.eContents().get(0);
		private final Assignment cStopAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final Keyword cStopStopKeyword_2_0 = (Keyword)cStopAssignment_2.eContents().get(0);
		
		//// The reset ports of a completion relative timeout. D.4 requires the time when they are listed, but a reset-port list
		//// without one is worth a diagnostic of its own rather than a syntax error, so the time stays optional here.
		//DispatchTriggerCondition:
		//    expression=DispatchTriggerLogicalExpression
		//    | timeout?='timeout' ('(' resetPorts+=Reference ('or' resetPorts+=Reference)* ')')? time=BehaviorTime?
		//    | stop?='stop'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//expression=DispatchTriggerLogicalExpression
		//| timeout?='timeout' ('(' resetPorts+=Reference ('or' resetPorts+=Reference)* ')')? time=BehaviorTime?
		//| stop?='stop'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//expression=DispatchTriggerLogicalExpression
		public Assignment getExpressionAssignment_0() { return cExpressionAssignment_0; }
		
		//DispatchTriggerLogicalExpression
		public RuleCall getExpressionDispatchTriggerLogicalExpressionParserRuleCall_0_0() { return cExpressionDispatchTriggerLogicalExpressionParserRuleCall_0_0; }
		
		//timeout?='timeout' ('(' resetPorts+=Reference ('or' resetPorts+=Reference)* ')')? time=BehaviorTime?
		public Group getGroup_1() { return cGroup_1; }
		
		//timeout?='timeout'
		public Assignment getTimeoutAssignment_1_0() { return cTimeoutAssignment_1_0; }
		
		//'timeout'
		public Keyword getTimeoutTimeoutKeyword_1_0_0() { return cTimeoutTimeoutKeyword_1_0_0; }
		
		//('(' resetPorts+=Reference ('or' resetPorts+=Reference)* ')')?
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_1_0() { return cLeftParenthesisKeyword_1_1_0; }
		
		//resetPorts+=Reference
		public Assignment getResetPortsAssignment_1_1_1() { return cResetPortsAssignment_1_1_1; }
		
		//Reference
		public RuleCall getResetPortsReferenceParserRuleCall_1_1_1_0() { return cResetPortsReferenceParserRuleCall_1_1_1_0; }
		
		//('or' resetPorts+=Reference)*
		public Group getGroup_1_1_2() { return cGroup_1_1_2; }
		
		//'or'
		public Keyword getOrKeyword_1_1_2_0() { return cOrKeyword_1_1_2_0; }
		
		//resetPorts+=Reference
		public Assignment getResetPortsAssignment_1_1_2_1() { return cResetPortsAssignment_1_1_2_1; }
		
		//Reference
		public RuleCall getResetPortsReferenceParserRuleCall_1_1_2_1_0() { return cResetPortsReferenceParserRuleCall_1_1_2_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_1_3() { return cRightParenthesisKeyword_1_1_3; }
		
		//time=BehaviorTime?
		public Assignment getTimeAssignment_1_2() { return cTimeAssignment_1_2; }
		
		//BehaviorTime
		public RuleCall getTimeBehaviorTimeParserRuleCall_1_2_0() { return cTimeBehaviorTimeParserRuleCall_1_2_0; }
		
		//stop?='stop'
		public Assignment getStopAssignment_2() { return cStopAssignment_2; }
		
		//'stop'
		public Keyword getStopStopKeyword_2_0() { return cStopStopKeyword_2_0; }
	}
	public class DispatchTriggerLogicalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchTriggerLogicalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cConjunctionsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cConjunctionsDispatchConjunctionParserRuleCall_0_0 = (RuleCall)cConjunctionsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cOrKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cConjunctionsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cConjunctionsDispatchConjunctionParserRuleCall_1_1_0 = (RuleCall)cConjunctionsAssignment_1_1.eContents().get(0);
		
		//DispatchTriggerLogicalExpression:
		//    conjunctions+=DispatchConjunction ('or' conjunctions+=DispatchConjunction)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//conjunctions+=DispatchConjunction ('or' conjunctions+=DispatchConjunction)*
		public Group getGroup() { return cGroup; }
		
		//conjunctions+=DispatchConjunction
		public Assignment getConjunctionsAssignment_0() { return cConjunctionsAssignment_0; }
		
		//DispatchConjunction
		public RuleCall getConjunctionsDispatchConjunctionParserRuleCall_0_0() { return cConjunctionsDispatchConjunctionParserRuleCall_0_0; }
		
		//('or' conjunctions+=DispatchConjunction)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'or'
		public Keyword getOrKeyword_1_0() { return cOrKeyword_1_0; }
		
		//conjunctions+=DispatchConjunction
		public Assignment getConjunctionsAssignment_1_1() { return cConjunctionsAssignment_1_1; }
		
		//DispatchConjunction
		public RuleCall getConjunctionsDispatchConjunctionParserRuleCall_1_1_0() { return cConjunctionsDispatchConjunctionParserRuleCall_1_1_0; }
	}
	public class DispatchConjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.DispatchConjunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTriggersAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTriggersReferenceParserRuleCall_0_0 = (RuleCall)cTriggersAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cAndKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTriggersAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTriggersReferenceParserRuleCall_1_1_0 = (RuleCall)cTriggersAssignment_1_1.eContents().get(0);
		
		//DispatchConjunction:
		//    triggers+=Reference ('and' triggers+=Reference)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//triggers+=Reference ('and' triggers+=Reference)*
		public Group getGroup() { return cGroup; }
		
		//triggers+=Reference
		public Assignment getTriggersAssignment_0() { return cTriggersAssignment_0; }
		
		//Reference
		public RuleCall getTriggersReferenceParserRuleCall_0_0() { return cTriggersReferenceParserRuleCall_0_0; }
		
		//('and' triggers+=Reference)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'and'
		public Keyword getAndKeyword_1_0() { return cAndKeyword_1_0; }
		
		//triggers+=Reference
		public Assignment getTriggersAssignment_1_1() { return cTriggersAssignment_1_1; }
		
		//Reference
		public RuleCall getTriggersReferenceParserRuleCall_1_1_0() { return cTriggersReferenceParserRuleCall_1_1_0; }
	}
	public class ModeSwitchConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchCondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cConjunctionsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cConjunctionsModeSwitchConjunctionParserRuleCall_0_0 = (RuleCall)cConjunctionsAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cLogicalOperatorsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cLogicalOperatorsLogicalOrOperatorParserRuleCall_1_0_0 = (RuleCall)cLogicalOperatorsAssignment_1_0.eContents().get(0);
		private final Assignment cConjunctionsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cConjunctionsModeSwitchConjunctionParserRuleCall_1_1_0 = (RuleCall)cConjunctionsAssignment_1_1.eContents().get(0);
		
		//ModeSwitchCondition:
		//    conjunctions+=ModeSwitchConjunction
		//    (logicalOperators+=LogicalOrOperator conjunctions+=ModeSwitchConjunction)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//conjunctions+=ModeSwitchConjunction
		//(logicalOperators+=LogicalOrOperator conjunctions+=ModeSwitchConjunction)*
		public Group getGroup() { return cGroup; }
		
		//conjunctions+=ModeSwitchConjunction
		public Assignment getConjunctionsAssignment_0() { return cConjunctionsAssignment_0; }
		
		//ModeSwitchConjunction
		public RuleCall getConjunctionsModeSwitchConjunctionParserRuleCall_0_0() { return cConjunctionsModeSwitchConjunctionParserRuleCall_0_0; }
		
		//(logicalOperators+=LogicalOrOperator conjunctions+=ModeSwitchConjunction)*
		public Group getGroup_1() { return cGroup_1; }
		
		//logicalOperators+=LogicalOrOperator
		public Assignment getLogicalOperatorsAssignment_1_0() { return cLogicalOperatorsAssignment_1_0; }
		
		//LogicalOrOperator
		public RuleCall getLogicalOperatorsLogicalOrOperatorParserRuleCall_1_0_0() { return cLogicalOperatorsLogicalOrOperatorParserRuleCall_1_0_0; }
		
		//conjunctions+=ModeSwitchConjunction
		public Assignment getConjunctionsAssignment_1_1() { return cConjunctionsAssignment_1_1; }
		
		//ModeSwitchConjunction
		public RuleCall getConjunctionsModeSwitchConjunctionParserRuleCall_1_1_0() { return cConjunctionsModeSwitchConjunctionParserRuleCall_1_1_0; }
	}
	public class ModeSwitchConjunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchConjunction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTriggersAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTriggersModeSwitchTriggerParserRuleCall_0_0 = (RuleCall)cTriggersAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Assignment cLogicalOperatorsAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final RuleCall cLogicalOperatorsLogicalAndOperatorParserRuleCall_1_0_0 = (RuleCall)cLogicalOperatorsAssignment_1_0.eContents().get(0);
		private final Assignment cTriggersAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTriggersModeSwitchTriggerParserRuleCall_1_1_0 = (RuleCall)cTriggersAssignment_1_1.eContents().get(0);
		
		//ModeSwitchConjunction:
		//    triggers+=ModeSwitchTrigger
		//    (logicalOperators+=LogicalAndOperator triggers+=ModeSwitchTrigger)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//triggers+=ModeSwitchTrigger
		//(logicalOperators+=LogicalAndOperator triggers+=ModeSwitchTrigger)*
		public Group getGroup() { return cGroup; }
		
		//triggers+=ModeSwitchTrigger
		public Assignment getTriggersAssignment_0() { return cTriggersAssignment_0; }
		
		//ModeSwitchTrigger
		public RuleCall getTriggersModeSwitchTriggerParserRuleCall_0_0() { return cTriggersModeSwitchTriggerParserRuleCall_0_0; }
		
		//(logicalOperators+=LogicalAndOperator triggers+=ModeSwitchTrigger)*
		public Group getGroup_1() { return cGroup_1; }
		
		//logicalOperators+=LogicalAndOperator
		public Assignment getLogicalOperatorsAssignment_1_0() { return cLogicalOperatorsAssignment_1_0; }
		
		//LogicalAndOperator
		public RuleCall getLogicalOperatorsLogicalAndOperatorParserRuleCall_1_0_0() { return cLogicalOperatorsLogicalAndOperatorParserRuleCall_1_0_0; }
		
		//triggers+=ModeSwitchTrigger
		public Assignment getTriggersAssignment_1_1() { return cTriggersAssignment_1_1; }
		
		//ModeSwitchTrigger
		public RuleCall getTriggersModeSwitchTriggerParserRuleCall_1_1_0() { return cTriggersModeSwitchTriggerParserRuleCall_1_1_0; }
	}
	public class ModeSwitchTriggerElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ModeSwitchTrigger");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cReferenceAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cReferenceReferenceParserRuleCall_0_0 = (RuleCall)cReferenceAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cExpressionAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cExpressionModeSwitchConditionParserRuleCall_1_1_0 = (RuleCall)cExpressionAssignment_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//ModeSwitchTrigger:
		//    reference=Reference
		//    | '(' expression=ModeSwitchCondition ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//reference=Reference
		//| '(' expression=ModeSwitchCondition ')'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//reference=Reference
		public Assignment getReferenceAssignment_0() { return cReferenceAssignment_0; }
		
		//Reference
		public RuleCall getReferenceReferenceParserRuleCall_0_0() { return cReferenceReferenceParserRuleCall_0_0; }
		
		//'(' expression=ModeSwitchCondition ')'
		public Group getGroup_1() { return cGroup_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }
		
		//expression=ModeSwitchCondition
		public Assignment getExpressionAssignment_1_1() { return cExpressionAssignment_1_1; }
		
		//ModeSwitchCondition
		public RuleCall getExpressionModeSwitchConditionParserRuleCall_1_1_0() { return cExpressionModeSwitchConditionParserRuleCall_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }
	}
	public class InternalConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.InternalCondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInternalKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cInternalPortsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cInternalPortsReferenceParserRuleCall_1_0 = (RuleCall)cInternalPortsAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cOrKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cInternalPortsAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cInternalPortsReferenceParserRuleCall_2_1_0 = (RuleCall)cInternalPortsAssignment_2_1.eContents().get(0);
		
		//// The listed names are internal event or event data features of the containing component. Like every other name in
		//// the annex they stay symbolic here; the translator resolves them against the owner.
		//InternalCondition:
		//    'internal' internalPorts+=Reference ('or' internalPorts+=Reference)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'internal' internalPorts+=Reference ('or' internalPorts+=Reference)*
		public Group getGroup() { return cGroup; }
		
		//'internal'
		public Keyword getInternalKeyword_0() { return cInternalKeyword_0; }
		
		//internalPorts+=Reference
		public Assignment getInternalPortsAssignment_1() { return cInternalPortsAssignment_1; }
		
		//Reference
		public RuleCall getInternalPortsReferenceParserRuleCall_1_0() { return cInternalPortsReferenceParserRuleCall_1_0; }
		
		//('or' internalPorts+=Reference)*
		public Group getGroup_2() { return cGroup_2; }
		
		//'or'
		public Keyword getOrKeyword_2_0() { return cOrKeyword_2_0; }
		
		//internalPorts+=Reference
		public Assignment getInternalPortsAssignment_2_1() { return cInternalPortsAssignment_2_1; }
		
		//Reference
		public RuleCall getInternalPortsReferenceParserRuleCall_2_1_0() { return cInternalPortsReferenceParserRuleCall_2_1_0; }
	}
	public class BehaviorActionBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActionBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cContentAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cContentBehaviorActionsParserRuleCall_1_0 = (RuleCall)cContentAssignment_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cTimeoutKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTimeoutAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTimeoutBehaviorTimeParserRuleCall_3_1_0 = (RuleCall)cTimeoutAssignment_3_1.eContents().get(0);
		
		//BehaviorActionBlock:
		//    '{' content=BehaviorActions '}'
		//    ('timeout' timeout=BehaviorTime)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'{' content=BehaviorActions '}'
		//('timeout' timeout=BehaviorTime)?
		public Group getGroup() { return cGroup; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }
		
		//content=BehaviorActions
		public Assignment getContentAssignment_1() { return cContentAssignment_1; }
		
		//BehaviorActions
		public RuleCall getContentBehaviorActionsParserRuleCall_1_0() { return cContentBehaviorActionsParserRuleCall_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_2() { return cRightCurlyBracketKeyword_2; }
		
		//('timeout' timeout=BehaviorTime)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'timeout'
		public Keyword getTimeoutKeyword_3_0() { return cTimeoutKeyword_3_0; }
		
		//timeout=BehaviorTime
		public Assignment getTimeoutAssignment_3_1() { return cTimeoutAssignment_3_1; }
		
		//BehaviorTime
		public RuleCall getTimeoutBehaviorTimeParserRuleCall_3_1_0() { return cTimeoutBehaviorTimeParserRuleCall_3_1_0; }
	}
	public class BehaviorActionsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorActions");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cBehaviorActionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cAlternatives_1.eContents().get(0);
		private final Action cBehaviorActionSequenceActionsAction_1_0_0 = (Action)cGroup_1_0.eContents().get(0);
		private final Keyword cSemicolonKeyword_1_0_1 = (Keyword)cGroup_1_0.eContents().get(1);
		private final Assignment cActionsAssignment_1_0_2 = (Assignment)cGroup_1_0.eContents().get(2);
		private final RuleCall cActionsBehaviorActionParserRuleCall_1_0_2_0 = (RuleCall)cActionsAssignment_1_0_2.eContents().get(0);
		private final Group cGroup_1_0_3 = (Group)cGroup_1_0.eContents().get(3);
		private final Keyword cSemicolonKeyword_1_0_3_0 = (Keyword)cGroup_1_0_3.eContents().get(0);
		private final Assignment cActionsAssignment_1_0_3_1 = (Assignment)cGroup_1_0_3.eContents().get(1);
		private final RuleCall cActionsBehaviorActionParserRuleCall_1_0_3_1_0 = (RuleCall)cActionsAssignment_1_0_3_1.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Action cBehaviorActionSetActionsAction_1_1_0 = (Action)cGroup_1_1.eContents().get(0);
		private final Keyword cAmpersandKeyword_1_1_1 = (Keyword)cGroup_1_1.eContents().get(1);
		private final Assignment cActionsAssignment_1_1_2 = (Assignment)cGroup_1_1.eContents().get(2);
		private final RuleCall cActionsBehaviorActionParserRuleCall_1_1_2_0 = (RuleCall)cActionsAssignment_1_1_2.eContents().get(0);
		private final Group cGroup_1_1_3 = (Group)cGroup_1_1.eContents().get(3);
		private final Keyword cAmpersandKeyword_1_1_3_0 = (Keyword)cGroup_1_1_3.eContents().get(0);
		private final Assignment cActionsAssignment_1_1_3_1 = (Assignment)cGroup_1_1_3.eContents().get(1);
		private final RuleCall cActionsBehaviorActionParserRuleCall_1_1_3_1_0 = (RuleCall)cActionsAssignment_1_1_3_1.eContents().get(0);
		
		//BehaviorActions:
		//    BehaviorAction
		//    (
		//        {BehaviorActionSequence.actions+=current} ';' actions+=BehaviorAction
		//            (';' actions+=BehaviorAction)*
		//        | {BehaviorActionSet.actions+=current} '&' actions+=BehaviorAction
		//            ('&' actions+=BehaviorAction)*
		//    )?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//BehaviorAction
		//(
		//    {BehaviorActionSequence.actions+=current} ';' actions+=BehaviorAction
		//        (';' actions+=BehaviorAction)*
		//    | {BehaviorActionSet.actions+=current} '&' actions+=BehaviorAction
		//        ('&' actions+=BehaviorAction)*
		//)?
		public Group getGroup() { return cGroup; }
		
		//BehaviorAction
		public RuleCall getBehaviorActionParserRuleCall_0() { return cBehaviorActionParserRuleCall_0; }
		
		//(
		//    {BehaviorActionSequence.actions+=current} ';' actions+=BehaviorAction
		//        (';' actions+=BehaviorAction)*
		//    | {BehaviorActionSet.actions+=current} '&' actions+=BehaviorAction
		//        ('&' actions+=BehaviorAction)*
		//)?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//{BehaviorActionSequence.actions+=current} ';' actions+=BehaviorAction
		//    (';' actions+=BehaviorAction)*
		public Group getGroup_1_0() { return cGroup_1_0; }
		
		//{BehaviorActionSequence.actions+=current}
		public Action getBehaviorActionSequenceActionsAction_1_0_0() { return cBehaviorActionSequenceActionsAction_1_0_0; }
		
		//';'
		public Keyword getSemicolonKeyword_1_0_1() { return cSemicolonKeyword_1_0_1; }
		
		//actions+=BehaviorAction
		public Assignment getActionsAssignment_1_0_2() { return cActionsAssignment_1_0_2; }
		
		//BehaviorAction
		public RuleCall getActionsBehaviorActionParserRuleCall_1_0_2_0() { return cActionsBehaviorActionParserRuleCall_1_0_2_0; }
		
		//(';' actions+=BehaviorAction)*
		public Group getGroup_1_0_3() { return cGroup_1_0_3; }
		
		//';'
		public Keyword getSemicolonKeyword_1_0_3_0() { return cSemicolonKeyword_1_0_3_0; }
		
		//actions+=BehaviorAction
		public Assignment getActionsAssignment_1_0_3_1() { return cActionsAssignment_1_0_3_1; }
		
		//BehaviorAction
		public RuleCall getActionsBehaviorActionParserRuleCall_1_0_3_1_0() { return cActionsBehaviorActionParserRuleCall_1_0_3_1_0; }
		
		//{BehaviorActionSet.actions+=current} '&' actions+=BehaviorAction
		//           ('&' actions+=BehaviorAction)*
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//{BehaviorActionSet.actions+=current}
		public Action getBehaviorActionSetActionsAction_1_1_0() { return cBehaviorActionSetActionsAction_1_1_0; }
		
		//'&'
		public Keyword getAmpersandKeyword_1_1_1() { return cAmpersandKeyword_1_1_1; }
		
		//actions+=BehaviorAction
		public Assignment getActionsAssignment_1_1_2() { return cActionsAssignment_1_1_2; }
		
		//BehaviorAction
		public RuleCall getActionsBehaviorActionParserRuleCall_1_1_2_0() { return cActionsBehaviorActionParserRuleCall_1_1_2_0; }
		
		//('&' actions+=BehaviorAction)*
		public Group getGroup_1_1_3() { return cGroup_1_1_3; }
		
		//'&'
		public Keyword getAmpersandKeyword_1_1_3_0() { return cAmpersandKeyword_1_1_3_0; }
		
		//actions+=BehaviorAction
		public Assignment getActionsAssignment_1_1_3_1() { return cActionsAssignment_1_1_3_1; }
		
		//BehaviorAction
		public RuleCall getActionsBehaviorActionParserRuleCall_1_1_3_1_0() { return cActionsBehaviorActionParserRuleCall_1_1_3_1_0; }
	}
	public class BehaviorActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorAction");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAssignmentActionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCommunicationActionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cTimedActionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cIfStatementParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cForStatementParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cWhileStatementParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cDoUntilStatementParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cBehaviorActionBlockParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		
		//BehaviorAction:
		//    => AssignmentAction
		//    | CommunicationAction
		//    | TimedAction
		//    | IfStatement
		//    | ForStatement
		//    | WhileStatement
		//    | DoUntilStatement
		//    | BehaviorActionBlock
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//=> AssignmentAction
		//| CommunicationAction
		//| TimedAction
		//| IfStatement
		//| ForStatement
		//| WhileStatement
		//| DoUntilStatement
		//| BehaviorActionBlock
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//=> AssignmentAction
		public RuleCall getAssignmentActionParserRuleCall_0() { return cAssignmentActionParserRuleCall_0; }
		
		//CommunicationAction
		public RuleCall getCommunicationActionParserRuleCall_1() { return cCommunicationActionParserRuleCall_1; }
		
		//TimedAction
		public RuleCall getTimedActionParserRuleCall_2() { return cTimedActionParserRuleCall_2; }
		
		//IfStatement
		public RuleCall getIfStatementParserRuleCall_3() { return cIfStatementParserRuleCall_3; }
		
		//ForStatement
		public RuleCall getForStatementParserRuleCall_4() { return cForStatementParserRuleCall_4; }
		
		//WhileStatement
		public RuleCall getWhileStatementParserRuleCall_5() { return cWhileStatementParserRuleCall_5; }
		
		//DoUntilStatement
		public RuleCall getDoUntilStatementParserRuleCall_6() { return cDoUntilStatementParserRuleCall_6; }
		
		//BehaviorActionBlock
		public RuleCall getBehaviorActionBlockParserRuleCall_7() { return cBehaviorActionBlockParserRuleCall_7; }
	}
	public class AssignmentActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.AssignmentAction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTargetAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTargetReferenceParserRuleCall_0_0 = (RuleCall)cTargetAssignment_0.eContents().get(0);
		private final Keyword cColonEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cValueAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cValueValueExpressionParserRuleCall_2_0_0 = (RuleCall)cValueAssignment_2_0.eContents().get(0);
		private final Assignment cAnyAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final Keyword cAnyAnyKeyword_2_1_0 = (Keyword)cAnyAssignment_2_1.eContents().get(0);
		
		//AssignmentAction:
		//    target=Reference ':=' (value=ValueExpression | any?='any')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//target=Reference ':=' (value=ValueExpression | any?='any')
		public Group getGroup() { return cGroup; }
		
		//target=Reference
		public Assignment getTargetAssignment_0() { return cTargetAssignment_0; }
		
		//Reference
		public RuleCall getTargetReferenceParserRuleCall_0_0() { return cTargetReferenceParserRuleCall_0_0; }
		
		//':='
		public Keyword getColonEqualsSignKeyword_1() { return cColonEqualsSignKeyword_1; }
		
		//(value=ValueExpression | any?='any')
		public Alternatives getAlternatives_2() { return cAlternatives_2; }
		
		//value=ValueExpression
		public Assignment getValueAssignment_2_0() { return cValueAssignment_2_0; }
		
		//ValueExpression
		public RuleCall getValueValueExpressionParserRuleCall_2_0_0() { return cValueValueExpressionParserRuleCall_2_0_0; }
		
		//any?='any'
		public Assignment getAnyAssignment_2_1() { return cAnyAssignment_2_1; }
		
		//'any'
		public Keyword getAnyAnyKeyword_2_1_0() { return cAnyAnyKeyword_2_1_0; }
	}
	public class CommunicationActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.CommunicationAction");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Assignment cReferenceAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cReferenceReferenceParserRuleCall_0_0_0 = (RuleCall)cReferenceAssignment_0_0.eContents().get(0);
		private final Alternatives cAlternatives_0_1 = (Alternatives)cGroup_0.eContents().get(1);
		private final Group cGroup_0_1_0 = (Group)cAlternatives_0_1.eContents().get(0);
		private final Assignment cSendAssignment_0_1_0_0 = (Assignment)cGroup_0_1_0.eContents().get(0);
		private final Keyword cSendExclamationMarkKeyword_0_1_0_0_0 = (Keyword)cSendAssignment_0_1_0_0.eContents().get(0);
		private final Group cGroup_0_1_0_1 = (Group)cGroup_0_1_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0_1_0_1_0 = (Keyword)cGroup_0_1_0_1.eContents().get(0);
		private final Assignment cParametersAssignment_0_1_0_1_1 = (Assignment)cGroup_0_1_0_1.eContents().get(1);
		private final RuleCall cParametersValueExpressionParserRuleCall_0_1_0_1_1_0 = (RuleCall)cParametersAssignment_0_1_0_1_1.eContents().get(0);
		private final Group cGroup_0_1_0_1_2 = (Group)cGroup_0_1_0_1.eContents().get(2);
		private final Keyword cCommaKeyword_0_1_0_1_2_0 = (Keyword)cGroup_0_1_0_1_2.eContents().get(0);
		private final Assignment cParametersAssignment_0_1_0_1_2_1 = (Assignment)cGroup_0_1_0_1_2.eContents().get(1);
		private final RuleCall cParametersValueExpressionParserRuleCall_0_1_0_1_2_1_0 = (RuleCall)cParametersAssignment_0_1_0_1_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_1_0_1_3 = (Keyword)cGroup_0_1_0_1.eContents().get(3);
		private final Group cGroup_0_1_1 = (Group)cAlternatives_0_1.eContents().get(1);
		private final Assignment cDequeueAssignment_0_1_1_0 = (Assignment)cGroup_0_1_1.eContents().get(0);
		private final Keyword cDequeueQuestionMarkKeyword_0_1_1_0_0 = (Keyword)cDequeueAssignment_0_1_1_0.eContents().get(0);
		private final Group cGroup_0_1_1_1 = (Group)cGroup_0_1_1.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0_1_1_1_0 = (Keyword)cGroup_0_1_1_1.eContents().get(0);
		private final Assignment cTargetAssignment_0_1_1_1_1 = (Assignment)cGroup_0_1_1_1.eContents().get(1);
		private final RuleCall cTargetReferenceParserRuleCall_0_1_1_1_1_0 = (RuleCall)cTargetAssignment_0_1_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_0_1_1_1_2 = (Keyword)cGroup_0_1_1_1.eContents().get(2);
		private final Assignment cFreezeAssignment_0_1_2 = (Assignment)cAlternatives_0_1.eContents().get(2);
		private final Keyword cFreezeGreaterThanSignGreaterThanSignKeyword_0_1_2_0 = (Keyword)cFreezeAssignment_0_1_2.eContents().get(0);
		private final Assignment cLockAssignment_0_1_3 = (Assignment)cAlternatives_0_1.eContents().get(3);
		private final Keyword cLockExclamationMarkLessThanSignKeyword_0_1_3_0 = (Keyword)cLockAssignment_0_1_3.eContents().get(0);
		private final Assignment cUnlockAssignment_0_1_4 = (Assignment)cAlternatives_0_1.eContents().get(4);
		private final Keyword cUnlockExclamationMarkGreaterThanSignKeyword_0_1_4_0 = (Keyword)cUnlockAssignment_0_1_4.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Assignment cAllAssignment_1_0 = (Assignment)cGroup_1.eContents().get(0);
		private final Keyword cAllAsteriskKeyword_1_0_0 = (Keyword)cAllAssignment_1_0.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cAllLockAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final Keyword cAllLockExclamationMarkLessThanSignKeyword_1_1_0_0 = (Keyword)cAllLockAssignment_1_1_0.eContents().get(0);
		private final Assignment cAllUnlockAssignment_1_1_1 = (Assignment)cAlternatives_1_1.eContents().get(1);
		private final Keyword cAllUnlockExclamationMarkGreaterThanSignKeyword_1_1_1_0 = (Keyword)cAllUnlockAssignment_1_1_1.eContents().get(0);
		
		//CommunicationAction:
		//    (
		//        reference=Reference
		//        (
		//            send?='!' ('(' parameters+=ValueExpression (',' parameters+=ValueExpression)* ')')?
		//            | dequeue?='?' ('(' target=Reference ')')?
		//            | freeze?='>>'
		//            | lock?='!<'
		//            | unlock?='!>'
		//        )
		//    )
		//    | all?='*' (allLock?='!<' | allUnlock?='!>')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(
		//    reference=Reference
		//    (
		//        send?='!' ('(' parameters+=ValueExpression (',' parameters+=ValueExpression)* ')')?
		//        | dequeue?='?' ('(' target=Reference ')')?
		//        | freeze?='>>'
		//        | lock?='!<'
		//        | unlock?='!>'
		//    )
		//)
		//| all?='*' (allLock?='!<' | allUnlock?='!>')
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//(
		//    reference=Reference
		//    (
		//        send?='!' ('(' parameters+=ValueExpression (',' parameters+=ValueExpression)* ')')?
		//        | dequeue?='?' ('(' target=Reference ')')?
		//        | freeze?='>>'
		//        | lock?='!<'
		//        | unlock?='!>'
		//    )
		//)
		public Group getGroup_0() { return cGroup_0; }
		
		//reference=Reference
		public Assignment getReferenceAssignment_0_0() { return cReferenceAssignment_0_0; }
		
		//Reference
		public RuleCall getReferenceReferenceParserRuleCall_0_0_0() { return cReferenceReferenceParserRuleCall_0_0_0; }
		
		//(
		//    send?='!' ('(' parameters+=ValueExpression (',' parameters+=ValueExpression)* ')')?
		//    | dequeue?='?' ('(' target=Reference ')')?
		//    | freeze?='>>'
		//    | lock?='!<'
		//    | unlock?='!>'
		//)
		public Alternatives getAlternatives_0_1() { return cAlternatives_0_1; }
		
		//send?='!' ('(' parameters+=ValueExpression (',' parameters+=ValueExpression)* ')')?
		public Group getGroup_0_1_0() { return cGroup_0_1_0; }
		
		//send?='!'
		public Assignment getSendAssignment_0_1_0_0() { return cSendAssignment_0_1_0_0; }
		
		//'!'
		public Keyword getSendExclamationMarkKeyword_0_1_0_0_0() { return cSendExclamationMarkKeyword_0_1_0_0_0; }
		
		//('(' parameters+=ValueExpression (',' parameters+=ValueExpression)* ')')?
		public Group getGroup_0_1_0_1() { return cGroup_0_1_0_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_1_0_1_0() { return cLeftParenthesisKeyword_0_1_0_1_0; }
		
		//parameters+=ValueExpression
		public Assignment getParametersAssignment_0_1_0_1_1() { return cParametersAssignment_0_1_0_1_1; }
		
		//ValueExpression
		public RuleCall getParametersValueExpressionParserRuleCall_0_1_0_1_1_0() { return cParametersValueExpressionParserRuleCall_0_1_0_1_1_0; }
		
		//(',' parameters+=ValueExpression)*
		public Group getGroup_0_1_0_1_2() { return cGroup_0_1_0_1_2; }
		
		//','
		public Keyword getCommaKeyword_0_1_0_1_2_0() { return cCommaKeyword_0_1_0_1_2_0; }
		
		//parameters+=ValueExpression
		public Assignment getParametersAssignment_0_1_0_1_2_1() { return cParametersAssignment_0_1_0_1_2_1; }
		
		//ValueExpression
		public RuleCall getParametersValueExpressionParserRuleCall_0_1_0_1_2_1_0() { return cParametersValueExpressionParserRuleCall_0_1_0_1_2_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_0_1_0_1_3() { return cRightParenthesisKeyword_0_1_0_1_3; }
		
		//dequeue?='?' ('(' target=Reference ')')?
		public Group getGroup_0_1_1() { return cGroup_0_1_1; }
		
		//dequeue?='?'
		public Assignment getDequeueAssignment_0_1_1_0() { return cDequeueAssignment_0_1_1_0; }
		
		//'?'
		public Keyword getDequeueQuestionMarkKeyword_0_1_1_0_0() { return cDequeueQuestionMarkKeyword_0_1_1_0_0; }
		
		//('(' target=Reference ')')?
		public Group getGroup_0_1_1_1() { return cGroup_0_1_1_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0_1_1_1_0() { return cLeftParenthesisKeyword_0_1_1_1_0; }
		
		//target=Reference
		public Assignment getTargetAssignment_0_1_1_1_1() { return cTargetAssignment_0_1_1_1_1; }
		
		//Reference
		public RuleCall getTargetReferenceParserRuleCall_0_1_1_1_1_0() { return cTargetReferenceParserRuleCall_0_1_1_1_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_0_1_1_1_2() { return cRightParenthesisKeyword_0_1_1_1_2; }
		
		//freeze?='>>'
		public Assignment getFreezeAssignment_0_1_2() { return cFreezeAssignment_0_1_2; }
		
		//'>>'
		public Keyword getFreezeGreaterThanSignGreaterThanSignKeyword_0_1_2_0() { return cFreezeGreaterThanSignGreaterThanSignKeyword_0_1_2_0; }
		
		//lock?='!<'
		public Assignment getLockAssignment_0_1_3() { return cLockAssignment_0_1_3; }
		
		//'!<'
		public Keyword getLockExclamationMarkLessThanSignKeyword_0_1_3_0() { return cLockExclamationMarkLessThanSignKeyword_0_1_3_0; }
		
		//unlock?='!>'
		public Assignment getUnlockAssignment_0_1_4() { return cUnlockAssignment_0_1_4; }
		
		//'!>'
		public Keyword getUnlockExclamationMarkGreaterThanSignKeyword_0_1_4_0() { return cUnlockExclamationMarkGreaterThanSignKeyword_0_1_4_0; }
		
		//all?='*' (allLock?='!<' | allUnlock?='!>')
		public Group getGroup_1() { return cGroup_1; }
		
		//all?='*'
		public Assignment getAllAssignment_1_0() { return cAllAssignment_1_0; }
		
		//'*'
		public Keyword getAllAsteriskKeyword_1_0_0() { return cAllAsteriskKeyword_1_0_0; }
		
		//(allLock?='!<' | allUnlock?='!>')
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }
		
		//allLock?='!<'
		public Assignment getAllLockAssignment_1_1_0() { return cAllLockAssignment_1_1_0; }
		
		//'!<'
		public Keyword getAllLockExclamationMarkLessThanSignKeyword_1_1_0_0() { return cAllLockExclamationMarkLessThanSignKeyword_1_1_0_0; }
		
		//allUnlock?='!>'
		public Assignment getAllUnlockAssignment_1_1_1() { return cAllUnlockAssignment_1_1_1; }
		
		//'!>'
		public Keyword getAllUnlockExclamationMarkGreaterThanSignKeyword_1_1_1_0() { return cAllUnlockExclamationMarkGreaterThanSignKeyword_1_1_1_0; }
	}
	public class TimedActionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.TimedAction");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cComputationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cLowerTimeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cLowerTimeBehaviorTimeParserRuleCall_2_0 = (RuleCall)cLowerTimeAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFullStopFullStopKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cUpperTimeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cUpperTimeBehaviorTimeParserRuleCall_3_1_0 = (RuleCall)cUpperTimeAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cInKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Keyword cBindingKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Assignment cProcessorsAssignment_5_3 = (Assignment)cGroup_5.eContents().get(3);
		private final CrossReference cProcessorsComponentClassifierCrossReference_5_3_0 = (CrossReference)cProcessorsAssignment_5_3.eContents().get(0);
		private final RuleCall cProcessorsComponentClassifierQCREFParserRuleCall_5_3_0_1 = (RuleCall)cProcessorsComponentClassifierCrossReference_5_3_0.eContents().get(1);
		private final Group cGroup_5_4 = (Group)cGroup_5.eContents().get(4);
		private final Keyword cCommaKeyword_5_4_0 = (Keyword)cGroup_5_4.eContents().get(0);
		private final Assignment cProcessorsAssignment_5_4_1 = (Assignment)cGroup_5_4.eContents().get(1);
		private final CrossReference cProcessorsComponentClassifierCrossReference_5_4_1_0 = (CrossReference)cProcessorsAssignment_5_4_1.eContents().get(0);
		private final RuleCall cProcessorsComponentClassifierQCREFParserRuleCall_5_4_1_0_1 = (RuleCall)cProcessorsComponentClassifierCrossReference_5_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5_5 = (Keyword)cGroup_5.eContents().get(5);
		
		//TimedAction:
		//    'computation' '(' lowerTime=BehaviorTime ('..' upperTime=BehaviorTime)? ')'
		//    ('in' 'binding' '(' processors+=[aadl2::ComponentClassifier|QCREF]
		//        (',' processors+=[aadl2::ComponentClassifier|QCREF])* ')')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'computation' '(' lowerTime=BehaviorTime ('..' upperTime=BehaviorTime)? ')'
		//('in' 'binding' '(' processors+=[aadl2::ComponentClassifier|QCREF]
		//    (',' processors+=[aadl2::ComponentClassifier|QCREF])* ')')?
		public Group getGroup() { return cGroup; }
		
		//'computation'
		public Keyword getComputationKeyword_0() { return cComputationKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//lowerTime=BehaviorTime
		public Assignment getLowerTimeAssignment_2() { return cLowerTimeAssignment_2; }
		
		//BehaviorTime
		public RuleCall getLowerTimeBehaviorTimeParserRuleCall_2_0() { return cLowerTimeBehaviorTimeParserRuleCall_2_0; }
		
		//('..' upperTime=BehaviorTime)?
		public Group getGroup_3() { return cGroup_3; }
		
		//'..'
		public Keyword getFullStopFullStopKeyword_3_0() { return cFullStopFullStopKeyword_3_0; }
		
		//upperTime=BehaviorTime
		public Assignment getUpperTimeAssignment_3_1() { return cUpperTimeAssignment_3_1; }
		
		//BehaviorTime
		public RuleCall getUpperTimeBehaviorTimeParserRuleCall_3_1_0() { return cUpperTimeBehaviorTimeParserRuleCall_3_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
		
		//('in' 'binding' '(' processors+=[aadl2::ComponentClassifier|QCREF]
		//    (',' processors+=[aadl2::ComponentClassifier|QCREF])* ')')?
		public Group getGroup_5() { return cGroup_5; }
		
		//'in'
		public Keyword getInKeyword_5_0() { return cInKeyword_5_0; }
		
		//'binding'
		public Keyword getBindingKeyword_5_1() { return cBindingKeyword_5_1; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_5_2() { return cLeftParenthesisKeyword_5_2; }
		
		//processors+=[aadl2::ComponentClassifier|QCREF]
		public Assignment getProcessorsAssignment_5_3() { return cProcessorsAssignment_5_3; }
		
		//[aadl2::ComponentClassifier|QCREF]
		public CrossReference getProcessorsComponentClassifierCrossReference_5_3_0() { return cProcessorsComponentClassifierCrossReference_5_3_0; }
		
		//QCREF
		public RuleCall getProcessorsComponentClassifierQCREFParserRuleCall_5_3_0_1() { return cProcessorsComponentClassifierQCREFParserRuleCall_5_3_0_1; }
		
		//(',' processors+=[aadl2::ComponentClassifier|QCREF])*
		public Group getGroup_5_4() { return cGroup_5_4; }
		
		//','
		public Keyword getCommaKeyword_5_4_0() { return cCommaKeyword_5_4_0; }
		
		//processors+=[aadl2::ComponentClassifier|QCREF]
		public Assignment getProcessorsAssignment_5_4_1() { return cProcessorsAssignment_5_4_1; }
		
		//[aadl2::ComponentClassifier|QCREF]
		public CrossReference getProcessorsComponentClassifierCrossReference_5_4_1_0() { return cProcessorsComponentClassifierCrossReference_5_4_1_0; }
		
		//QCREF
		public RuleCall getProcessorsComponentClassifierQCREFParserRuleCall_5_4_1_0_1() { return cProcessorsComponentClassifierQCREFParserRuleCall_5_4_1_0_1; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5_5() { return cRightParenthesisKeyword_5_5; }
	}
	public class IfStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.IfStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIfKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cConditionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cConditionValueExpressionParserRuleCall_2_0 = (RuleCall)cConditionAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cThenActionsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cThenActionsBehaviorActionsParserRuleCall_4_0 = (RuleCall)cThenActionsAssignment_4.eContents().get(0);
		private final Assignment cElseIfsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cElseIfsElseIfClauseParserRuleCall_5_0 = (RuleCall)cElseIfsAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cElseKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cElseActionsAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cElseActionsBehaviorActionsParserRuleCall_6_1_0 = (RuleCall)cElseActionsAssignment_6_1.eContents().get(0);
		private final Keyword cEndKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cIfKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//IfStatement:
		//    'if' '(' condition=ValueExpression ')' thenActions=BehaviorActions
		//    elseIfs+=ElseIfClause*
		//    ('else' elseActions=BehaviorActions)?
		//    'end' 'if'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'if' '(' condition=ValueExpression ')' thenActions=BehaviorActions
		//elseIfs+=ElseIfClause*
		//('else' elseActions=BehaviorActions)?
		//'end' 'if'
		public Group getGroup() { return cGroup; }
		
		//'if'
		public Keyword getIfKeyword_0() { return cIfKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//condition=ValueExpression
		public Assignment getConditionAssignment_2() { return cConditionAssignment_2; }
		
		//ValueExpression
		public RuleCall getConditionValueExpressionParserRuleCall_2_0() { return cConditionValueExpressionParserRuleCall_2_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//thenActions=BehaviorActions
		public Assignment getThenActionsAssignment_4() { return cThenActionsAssignment_4; }
		
		//BehaviorActions
		public RuleCall getThenActionsBehaviorActionsParserRuleCall_4_0() { return cThenActionsBehaviorActionsParserRuleCall_4_0; }
		
		//elseIfs+=ElseIfClause*
		public Assignment getElseIfsAssignment_5() { return cElseIfsAssignment_5; }
		
		//ElseIfClause
		public RuleCall getElseIfsElseIfClauseParserRuleCall_5_0() { return cElseIfsElseIfClauseParserRuleCall_5_0; }
		
		//('else' elseActions=BehaviorActions)?
		public Group getGroup_6() { return cGroup_6; }
		
		//'else'
		public Keyword getElseKeyword_6_0() { return cElseKeyword_6_0; }
		
		//elseActions=BehaviorActions
		public Assignment getElseActionsAssignment_6_1() { return cElseActionsAssignment_6_1; }
		
		//BehaviorActions
		public RuleCall getElseActionsBehaviorActionsParserRuleCall_6_1_0() { return cElseActionsBehaviorActionsParserRuleCall_6_1_0; }
		
		//'end'
		public Keyword getEndKeyword_7() { return cEndKeyword_7; }
		
		//'if'
		public Keyword getIfKeyword_8() { return cIfKeyword_8; }
	}
	public class ElseIfClauseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ElseIfClause");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cElsifKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cConditionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cConditionValueExpressionParserRuleCall_2_0 = (RuleCall)cConditionAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cActionsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cActionsBehaviorActionsParserRuleCall_4_0 = (RuleCall)cActionsAssignment_4.eContents().get(0);
		
		//ElseIfClause:
		//    'elsif' '(' condition=ValueExpression ')' actions=BehaviorActions
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'elsif' '(' condition=ValueExpression ')' actions=BehaviorActions
		public Group getGroup() { return cGroup; }
		
		//'elsif'
		public Keyword getElsifKeyword_0() { return cElsifKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//condition=ValueExpression
		public Assignment getConditionAssignment_2() { return cConditionAssignment_2; }
		
		//ValueExpression
		public RuleCall getConditionValueExpressionParserRuleCall_2_0() { return cConditionValueExpressionParserRuleCall_2_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//actions=BehaviorActions
		public Assignment getActionsAssignment_4() { return cActionsAssignment_4; }
		
		//BehaviorActions
		public RuleCall getActionsBehaviorActionsParserRuleCall_4_0() { return cActionsBehaviorActionsParserRuleCall_4_0; }
	}
	public class ForStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ForStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Assignment cForAssignment_0_0 = (Assignment)cAlternatives_0.eContents().get(0);
		private final Keyword cForForKeyword_0_0_0 = (Keyword)cForAssignment_0_0.eContents().get(0);
		private final Assignment cForallAssignment_0_1 = (Assignment)cAlternatives_0.eContents().get(1);
		private final Keyword cForallForallKeyword_0_1_0 = (Keyword)cForallAssignment_0_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cVariableAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cVariableIDTerminalRuleCall_2_0 = (RuleCall)cVariableAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cDataClassifierAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cDataClassifierComponentClassifierCrossReference_4_0 = (CrossReference)cDataClassifierAssignment_4.eContents().get(0);
		private final RuleCall cDataClassifierComponentClassifierQCREFParserRuleCall_4_0_1 = (RuleCall)cDataClassifierComponentClassifierCrossReference_4_0.eContents().get(1);
		private final Keyword cInKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cValuesAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cValuesElementValuesParserRuleCall_6_0 = (RuleCall)cValuesAssignment_6.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Keyword cLeftCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Assignment cActionsAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cActionsBehaviorActionsParserRuleCall_9_0 = (RuleCall)cActionsAssignment_9.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);
		
		//ForStatement:
		//    (for?='for' | forall?='forall')
		//    '(' variable=ID ':' dataClassifier=[aadl2::ComponentClassifier|QCREF]
		//    'in' values=ElementValues ')'
		//    '{' actions=BehaviorActions '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//(for?='for' | forall?='forall')
		//'(' variable=ID ':' dataClassifier=[aadl2::ComponentClassifier|QCREF]
		//'in' values=ElementValues ')'
		//'{' actions=BehaviorActions '}'
		public Group getGroup() { return cGroup; }
		
		//(for?='for' | forall?='forall')
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//for?='for'
		public Assignment getForAssignment_0_0() { return cForAssignment_0_0; }
		
		//'for'
		public Keyword getForForKeyword_0_0_0() { return cForForKeyword_0_0_0; }
		
		//forall?='forall'
		public Assignment getForallAssignment_0_1() { return cForallAssignment_0_1; }
		
		//'forall'
		public Keyword getForallForallKeyword_0_1_0() { return cForallForallKeyword_0_1_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//variable=ID
		public Assignment getVariableAssignment_2() { return cVariableAssignment_2; }
		
		//ID
		public RuleCall getVariableIDTerminalRuleCall_2_0() { return cVariableIDTerminalRuleCall_2_0; }
		
		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }
		
		//dataClassifier=[aadl2::ComponentClassifier|QCREF]
		public Assignment getDataClassifierAssignment_4() { return cDataClassifierAssignment_4; }
		
		//[aadl2::ComponentClassifier|QCREF]
		public CrossReference getDataClassifierComponentClassifierCrossReference_4_0() { return cDataClassifierComponentClassifierCrossReference_4_0; }
		
		//QCREF
		public RuleCall getDataClassifierComponentClassifierQCREFParserRuleCall_4_0_1() { return cDataClassifierComponentClassifierQCREFParserRuleCall_4_0_1; }
		
		//'in'
		public Keyword getInKeyword_5() { return cInKeyword_5; }
		
		//values=ElementValues
		public Assignment getValuesAssignment_6() { return cValuesAssignment_6; }
		
		//ElementValues
		public RuleCall getValuesElementValuesParserRuleCall_6_0() { return cValuesElementValuesParserRuleCall_6_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_7() { return cRightParenthesisKeyword_7; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_8() { return cLeftCurlyBracketKeyword_8; }
		
		//actions=BehaviorActions
		public Assignment getActionsAssignment_9() { return cActionsAssignment_9; }
		
		//BehaviorActions
		public RuleCall getActionsBehaviorActionsParserRuleCall_9_0() { return cActionsBehaviorActionsParserRuleCall_9_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_10() { return cRightCurlyBracketKeyword_10; }
	}
	public class WhileStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.WhileStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cWhileKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cConditionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cConditionValueExpressionParserRuleCall_2_0 = (RuleCall)cConditionAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cActionsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cActionsBehaviorActionsParserRuleCall_5_0 = (RuleCall)cActionsAssignment_5.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//WhileStatement:
		//    'while' '(' condition=ValueExpression ')' '{' actions=BehaviorActions '}'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'while' '(' condition=ValueExpression ')' '{' actions=BehaviorActions '}'
		public Group getGroup() { return cGroup; }
		
		//'while'
		public Keyword getWhileKeyword_0() { return cWhileKeyword_0; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }
		
		//condition=ValueExpression
		public Assignment getConditionAssignment_2() { return cConditionAssignment_2; }
		
		//ValueExpression
		public RuleCall getConditionValueExpressionParserRuleCall_2_0() { return cConditionValueExpressionParserRuleCall_2_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }
		
		//actions=BehaviorActions
		public Assignment getActionsAssignment_5() { return cActionsAssignment_5; }
		
		//BehaviorActions
		public RuleCall getActionsBehaviorActionsParserRuleCall_5_0() { return cActionsBehaviorActionsParserRuleCall_5_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}
	public class DoUntilStatementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.DoUntilStatement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDoKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cActionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cActionsBehaviorActionsParserRuleCall_1_0 = (RuleCall)cActionsAssignment_1.eContents().get(0);
		private final Keyword cUntilKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cConditionAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cConditionValueExpressionParserRuleCall_4_0 = (RuleCall)cConditionAssignment_4.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//DoUntilStatement:
		//    'do' actions=BehaviorActions 'until' '(' condition=ValueExpression ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'do' actions=BehaviorActions 'until' '(' condition=ValueExpression ')'
		public Group getGroup() { return cGroup; }
		
		//'do'
		public Keyword getDoKeyword_0() { return cDoKeyword_0; }
		
		//actions=BehaviorActions
		public Assignment getActionsAssignment_1() { return cActionsAssignment_1; }
		
		//BehaviorActions
		public RuleCall getActionsBehaviorActionsParserRuleCall_1_0() { return cActionsBehaviorActionsParserRuleCall_1_0; }
		
		//'until'
		public Keyword getUntilKeyword_2() { return cUntilKeyword_2; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }
		
		//condition=ValueExpression
		public Assignment getConditionAssignment_4() { return cConditionAssignment_4; }
		
		//ValueExpression
		public RuleCall getConditionValueExpressionParserRuleCall_4_0() { return cConditionValueExpressionParserRuleCall_4_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}
	public class ElementValuesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ElementValues");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cLowerAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cLowerIntegerValueParserRuleCall_0_0 = (RuleCall)cLowerAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cUpperAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cUpperIntegerValueParserRuleCall_1_1_0 = (RuleCall)cUpperAssignment_1_1.eContents().get(0);
		
		//ElementValues:
		//    lower=IntegerValue ('..' upper=IntegerValue)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//lower=IntegerValue ('..' upper=IntegerValue)?
		public Group getGroup() { return cGroup; }
		
		//lower=IntegerValue
		public Assignment getLowerAssignment_0() { return cLowerAssignment_0; }
		
		//IntegerValue
		public RuleCall getLowerIntegerValueParserRuleCall_0_0() { return cLowerIntegerValueParserRuleCall_0_0; }
		
		//('..' upper=IntegerValue)?
		public Group getGroup_1() { return cGroup_1; }
		
		//'..'
		public Keyword getFullStopFullStopKeyword_1_0() { return cFullStopFullStopKeyword_1_0; }
		
		//upper=IntegerValue
		public Assignment getUpperAssignment_1_1() { return cUpperAssignment_1_1; }
		
		//IntegerValue
		public RuleCall getUpperIntegerValueParserRuleCall_1_1_0() { return cUpperIntegerValueParserRuleCall_1_1_0; }
	}
	public class BehaviorTimeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorTime");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cValueIntegerValueParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cUnitAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_1_0 = (CrossReference)cUnitAssignment_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_0.eContents().get(1);
		
		//BehaviorTime:
		//    value=IntegerValue unit=[aadl2::UnitLiteral|ID]
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=IntegerValue unit=[aadl2::UnitLiteral|ID]
		public Group getGroup() { return cGroup; }
		
		//value=IntegerValue
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }
		
		//IntegerValue
		public RuleCall getValueIntegerValueParserRuleCall_0_0() { return cValueIntegerValueParserRuleCall_0_0; }
		
		//unit=[aadl2::UnitLiteral|ID]
		public Assignment getUnitAssignment_1() { return cUnitAssignment_1; }
		
		//[aadl2::UnitLiteral|ID]
		public CrossReference getUnitUnitLiteralCrossReference_1_0() { return cUnitUnitLiteralCrossReference_1_0; }
		
		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_0_1; }
	}
	public class IntegerValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.IntegerValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBehaviorIntegerLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cHashPropertyReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cReferenceExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//IntegerValue:
		//    BehaviorIntegerLiteral
		//    | HashPropertyReference
		//    | ReferenceExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//BehaviorIntegerLiteral
		//| HashPropertyReference
		//| ReferenceExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//BehaviorIntegerLiteral
		public RuleCall getBehaviorIntegerLiteralParserRuleCall_0() { return cBehaviorIntegerLiteralParserRuleCall_0; }
		
		//HashPropertyReference
		public RuleCall getHashPropertyReferenceParserRuleCall_1() { return cHashPropertyReferenceParserRuleCall_1; }
		
		//ReferenceExpression
		public RuleCall getReferenceExpressionParserRuleCall_2() { return cReferenceExpressionParserRuleCall_2; }
	}
	public class ValueExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cRelationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOperatorLogicalOperatorParserRuleCall_1_1_0 = (RuleCall)cOperatorAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightRelationParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//// The expression rules follow the D.7 productions rather than one rule per operator, because the standard puts every
		//// logical operator on a single precedence level and associates the operators of one level from left to right.
		//// 'a or b and c' therefore means '(a or b) and c'.
		//ValueExpression:
		//    Relation
		//    ({BinaryExpression.left=current} operator=LogicalOperator right=Relation)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Relation
		//({BinaryExpression.left=current} operator=LogicalOperator right=Relation)*
		public Group getGroup() { return cGroup; }
		
		//Relation
		public RuleCall getRelationParserRuleCall_0() { return cRelationParserRuleCall_0; }
		
		//({BinaryExpression.left=current} operator=LogicalOperator right=Relation)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{BinaryExpression.left=current}
		public Action getBinaryExpressionLeftAction_1_0() { return cBinaryExpressionLeftAction_1_0; }
		
		//operator=LogicalOperator
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//LogicalOperator
		public RuleCall getOperatorLogicalOperatorParserRuleCall_1_1_0() { return cOperatorLogicalOperatorParserRuleCall_1_1_0; }
		
		//right=Relation
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//Relation
		public RuleCall getRightRelationParserRuleCall_1_2_0() { return cRightRelationParserRuleCall_1_2_0; }
	}
	public class LogicalOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLogicalAndOperatorParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cLogicalOrOperatorParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//LogicalOperator returns ecore::EString:
		//    LogicalAndOperator | LogicalOrOperator
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//LogicalAndOperator | LogicalOrOperator
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//LogicalAndOperator
		public RuleCall getLogicalAndOperatorParserRuleCall_0() { return cLogicalAndOperatorParserRuleCall_0; }
		
		//LogicalOrOperator
		public RuleCall getLogicalOrOperatorParserRuleCall_1() { return cLogicalOrOperatorParserRuleCall_1; }
	}
	public class LogicalOrOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalOrOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cOrKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Keyword cElseKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Keyword cXorKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//LogicalOrOperator returns ecore::EString:
		//    'or' ('else')? | 'xor'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'or' ('else')? | 'xor'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'or' ('else')?
		public Group getGroup_0() { return cGroup_0; }
		
		//'or'
		public Keyword getOrKeyword_0_0() { return cOrKeyword_0_0; }
		
		//('else')?
		public Keyword getElseKeyword_0_1() { return cElseKeyword_0_1; }
		
		//'xor'
		public Keyword getXorKeyword_1() { return cXorKeyword_1; }
	}
	public class LogicalAndOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.LogicalAndOperator");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAndKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cThenKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//LogicalAndOperator returns ecore::EString:
		//    'and' ('then')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'and' ('then')?
		public Group getGroup() { return cGroup; }
		
		//'and'
		public Keyword getAndKeyword_0() { return cAndKeyword_0; }
		
		//('then')?
		public Keyword getThenKeyword_1() { return cThenKeyword_1; }
	}
	public class RelationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.Relation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cSimpleExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOperatorRelationalOperatorParserRuleCall_1_1_0 = (RuleCall)cOperatorAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightSimpleExpressionParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Relation returns ValueExpression:
		//    SimpleExpression
		//    ({BinaryExpression.left=current} operator=RelationalOperator right=SimpleExpression)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//SimpleExpression
		//({BinaryExpression.left=current} operator=RelationalOperator right=SimpleExpression)?
		public Group getGroup() { return cGroup; }
		
		//SimpleExpression
		public RuleCall getSimpleExpressionParserRuleCall_0() { return cSimpleExpressionParserRuleCall_0; }
		
		//({BinaryExpression.left=current} operator=RelationalOperator right=SimpleExpression)?
		public Group getGroup_1() { return cGroup_1; }
		
		//{BinaryExpression.left=current}
		public Action getBinaryExpressionLeftAction_1_0() { return cBinaryExpressionLeftAction_1_0; }
		
		//operator=RelationalOperator
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//RelationalOperator
		public RuleCall getOperatorRelationalOperatorParserRuleCall_1_1_0() { return cOperatorRelationalOperatorParserRuleCall_1_1_0; }
		
		//right=SimpleExpression
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//SimpleExpression
		public RuleCall getRightSimpleExpressionParserRuleCall_1_2_0() { return cRightSimpleExpressionParserRuleCall_1_2_0; }
	}
	public class RelationalOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.RelationalOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cExclamationMarkEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cLessThanSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cLessThanSignEqualsSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cGreaterThanSignKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cGreaterThanSignEqualsSignKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		
		//RelationalOperator returns ecore::EString:
		//    '=' | '!=' | '<' | '<=' | '>' | '>='
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'=' | '!=' | '<' | '<=' | '>' | '>='
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'='
		public Keyword getEqualsSignKeyword_0() { return cEqualsSignKeyword_0; }
		
		//'!='
		public Keyword getExclamationMarkEqualsSignKeyword_1() { return cExclamationMarkEqualsSignKeyword_1; }
		
		//'<'
		public Keyword getLessThanSignKeyword_2() { return cLessThanSignKeyword_2; }
		
		//'<='
		public Keyword getLessThanSignEqualsSignKeyword_3() { return cLessThanSignEqualsSignKeyword_3; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_4() { return cGreaterThanSignKeyword_4; }
		
		//'>='
		public Keyword getGreaterThanSignEqualsSignKeyword_5() { return cGreaterThanSignEqualsSignKeyword_5; }
	}
	public class SimpleExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.SimpleExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Action cUnaryExpressionAction_0_0_0 = (Action)cGroup_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_0_0_1 = (Assignment)cGroup_0_0.eContents().get(1);
		private final RuleCall cOperatorUnaryAddingOperatorParserRuleCall_0_0_1_0 = (RuleCall)cOperatorAssignment_0_0_1.eContents().get(0);
		private final Assignment cOperandAssignment_0_0_2 = (Assignment)cGroup_0_0.eContents().get(2);
		private final RuleCall cOperandTermParserRuleCall_0_0_2_0 = (RuleCall)cOperandAssignment_0_0_2.eContents().get(0);
		private final RuleCall cTermParserRuleCall_0_1 = (RuleCall)cAlternatives_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOperatorBinaryAddingOperatorParserRuleCall_1_1_0 = (RuleCall)cOperatorAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightTermParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//// The unary adding operator leads the whole simple expression, so it binds below the multiplying and the numeric
		//// operators: '-a mod b' is '-(a mod b)' and '-a ** b' is '-(a ** b)'. D.7 admits '-' only; '+' remains accepted here
		//// and is tracked separately as issue #3170.
		//SimpleExpression returns ValueExpression:
		//    ({UnaryExpression} operator=UnaryAddingOperator operand=Term | Term)
		//    ({BinaryExpression.left=current} operator=BinaryAddingOperator right=Term)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//({UnaryExpression} operator=UnaryAddingOperator operand=Term | Term)
		//({BinaryExpression.left=current} operator=BinaryAddingOperator right=Term)*
		public Group getGroup() { return cGroup; }
		
		//({UnaryExpression} operator=UnaryAddingOperator operand=Term | Term)
		public Alternatives getAlternatives_0() { return cAlternatives_0; }
		
		//{UnaryExpression} operator=UnaryAddingOperator operand=Term
		public Group getGroup_0_0() { return cGroup_0_0; }
		
		//{UnaryExpression}
		public Action getUnaryExpressionAction_0_0_0() { return cUnaryExpressionAction_0_0_0; }
		
		//operator=UnaryAddingOperator
		public Assignment getOperatorAssignment_0_0_1() { return cOperatorAssignment_0_0_1; }
		
		//UnaryAddingOperator
		public RuleCall getOperatorUnaryAddingOperatorParserRuleCall_0_0_1_0() { return cOperatorUnaryAddingOperatorParserRuleCall_0_0_1_0; }
		
		//operand=Term
		public Assignment getOperandAssignment_0_0_2() { return cOperandAssignment_0_0_2; }
		
		//Term
		public RuleCall getOperandTermParserRuleCall_0_0_2_0() { return cOperandTermParserRuleCall_0_0_2_0; }
		
		//Term
		public RuleCall getTermParserRuleCall_0_1() { return cTermParserRuleCall_0_1; }
		
		//({BinaryExpression.left=current} operator=BinaryAddingOperator right=Term)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{BinaryExpression.left=current}
		public Action getBinaryExpressionLeftAction_1_0() { return cBinaryExpressionLeftAction_1_0; }
		
		//operator=BinaryAddingOperator
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//BinaryAddingOperator
		public RuleCall getOperatorBinaryAddingOperatorParserRuleCall_1_1_0() { return cOperatorBinaryAddingOperatorParserRuleCall_1_1_0; }
		
		//right=Term
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//Term
		public RuleCall getRightTermParserRuleCall_1_2_0() { return cRightTermParserRuleCall_1_2_0; }
	}
	public class UnaryAddingOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnaryAddingOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cPlusSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//UnaryAddingOperator returns ecore::EString:
		//    '-' | '+'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'-' | '+'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }
		
		//'+'
		public Keyword getPlusSignKeyword_1() { return cPlusSignKeyword_1; }
	}
	public class BinaryAddingOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BinaryAddingOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//BinaryAddingOperator returns ecore::EString:
		//    '+' | '-'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'+' | '-'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'+'
		public Keyword getPlusSignKeyword_0() { return cPlusSignKeyword_0; }
		
		//'-'
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
	}
	public class TermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.Term");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cFactorParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cBinaryExpressionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOperatorMultiplyingOperatorParserRuleCall_1_1_0 = (RuleCall)cOperatorAssignment_1_1.eContents().get(0);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightFactorParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Term returns ValueExpression:
		//    Factor
		//    ({BinaryExpression.left=current} operator=MultiplyingOperator right=Factor)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Factor
		//({BinaryExpression.left=current} operator=MultiplyingOperator right=Factor)*
		public Group getGroup() { return cGroup; }
		
		//Factor
		public RuleCall getFactorParserRuleCall_0() { return cFactorParserRuleCall_0; }
		
		//({BinaryExpression.left=current} operator=MultiplyingOperator right=Factor)*
		public Group getGroup_1() { return cGroup_1; }
		
		//{BinaryExpression.left=current}
		public Action getBinaryExpressionLeftAction_1_0() { return cBinaryExpressionLeftAction_1_0; }
		
		//operator=MultiplyingOperator
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//MultiplyingOperator
		public RuleCall getOperatorMultiplyingOperatorParserRuleCall_1_1_0() { return cOperatorMultiplyingOperatorParserRuleCall_1_1_0; }
		
		//right=Factor
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }
		
		//Factor
		public RuleCall getRightFactorParserRuleCall_1_2_0() { return cRightFactorParserRuleCall_1_2_0; }
	}
	public class MultiplyingOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.MultiplyingOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAsteriskKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cSolidusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cModKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cRemKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//MultiplyingOperator returns ecore::EString:
		//    '*' | '/' | 'mod' | 'rem'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'*' | '/' | 'mod' | 'rem'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'*'
		public Keyword getAsteriskKeyword_0() { return cAsteriskKeyword_0; }
		
		//'/'
		public Keyword getSolidusKeyword_1() { return cSolidusKeyword_1; }
		
		//'mod'
		public Keyword getModKeyword_2() { return cModKeyword_2; }
		
		//'rem'
		public Keyword getRemKeyword_3() { return cRemKeyword_3; }
	}
	public class FactorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.Factor");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cValueParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Action cBinaryExpressionLeftAction_0_1_0 = (Action)cGroup_0_1.eContents().get(0);
		private final Assignment cOperatorAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final RuleCall cOperatorBinaryNumericOperatorParserRuleCall_0_1_1_0 = (RuleCall)cOperatorAssignment_0_1_1.eContents().get(0);
		private final Assignment cRightAssignment_0_1_2 = (Assignment)cGroup_0_1.eContents().get(2);
		private final RuleCall cRightValueParserRuleCall_0_1_2_0 = (RuleCall)cRightAssignment_0_1_2.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cUnaryExpressionAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Assignment cOperatorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cOperatorUnaryValueOperatorParserRuleCall_1_1_0 = (RuleCall)cOperatorAssignment_1_1.eContents().get(0);
		private final Assignment cOperandAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cOperandValueParserRuleCall_1_2_0 = (RuleCall)cOperandAssignment_1_2.eContents().get(0);
		
		//// A factor admits at most one exponentiation and applies a unary numeric or boolean operator to a single value, so
		//// 'a ** b ** c', 'abs -a', and 'not not a' need explicit parentheses.
		//Factor returns ValueExpression:
		//    Value
		//    ({BinaryExpression.left=current} operator=BinaryNumericOperator right=Value)?
		//    | {UnaryExpression} operator=UnaryValueOperator operand=Value
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Value
		//({BinaryExpression.left=current} operator=BinaryNumericOperator right=Value)?
		//| {UnaryExpression} operator=UnaryValueOperator operand=Value
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Value
		//({BinaryExpression.left=current} operator=BinaryNumericOperator right=Value)?
		public Group getGroup_0() { return cGroup_0; }
		
		//Value
		public RuleCall getValueParserRuleCall_0_0() { return cValueParserRuleCall_0_0; }
		
		//({BinaryExpression.left=current} operator=BinaryNumericOperator right=Value)?
		public Group getGroup_0_1() { return cGroup_0_1; }
		
		//{BinaryExpression.left=current}
		public Action getBinaryExpressionLeftAction_0_1_0() { return cBinaryExpressionLeftAction_0_1_0; }
		
		//operator=BinaryNumericOperator
		public Assignment getOperatorAssignment_0_1_1() { return cOperatorAssignment_0_1_1; }
		
		//BinaryNumericOperator
		public RuleCall getOperatorBinaryNumericOperatorParserRuleCall_0_1_1_0() { return cOperatorBinaryNumericOperatorParserRuleCall_0_1_1_0; }
		
		//right=Value
		public Assignment getRightAssignment_0_1_2() { return cRightAssignment_0_1_2; }
		
		//Value
		public RuleCall getRightValueParserRuleCall_0_1_2_0() { return cRightValueParserRuleCall_0_1_2_0; }
		
		//{UnaryExpression} operator=UnaryValueOperator operand=Value
		public Group getGroup_1() { return cGroup_1; }
		
		//{UnaryExpression}
		public Action getUnaryExpressionAction_1_0() { return cUnaryExpressionAction_1_0; }
		
		//operator=UnaryValueOperator
		public Assignment getOperatorAssignment_1_1() { return cOperatorAssignment_1_1; }
		
		//UnaryValueOperator
		public RuleCall getOperatorUnaryValueOperatorParserRuleCall_1_1_0() { return cOperatorUnaryValueOperatorParserRuleCall_1_1_0; }
		
		//operand=Value
		public Assignment getOperandAssignment_1_2() { return cOperandAssignment_1_2; }
		
		//Value
		public RuleCall getOperandValueParserRuleCall_1_2_0() { return cOperandValueParserRuleCall_1_2_0; }
	}
	public class BinaryNumericOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BinaryNumericOperator");
		private final Keyword cAsteriskAsteriskKeyword = (Keyword)rule.eContents().get(1);
		
		//BinaryNumericOperator returns ecore::EString:
		//    '**'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'**'
		public Keyword getAsteriskAsteriskKeyword() { return cAsteriskAsteriskKeyword; }
	}
	public class UnaryValueOperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnaryValueOperator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAbsKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cNotKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//UnaryValueOperator returns ecore::EString:
		//    'abs' | 'not'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'abs' | 'not'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'abs'
		public Keyword getAbsKeyword_0() { return cAbsKeyword_0; }
		
		//'not'
		public Keyword getNotKeyword_1() { return cNotKeyword_1; }
	}
	public class ValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.Value");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cValueConstantParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReferenceExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cParenthesizedExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Value returns ValueExpression:
		//    ValueConstant
		//    | ReferenceExpression
		//    | ParenthesizedExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ValueConstant
		//| ReferenceExpression
		//| ParenthesizedExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//ValueConstant
		public RuleCall getValueConstantParserRuleCall_0() { return cValueConstantParserRuleCall_0; }
		
		//ReferenceExpression
		public RuleCall getReferenceExpressionParserRuleCall_1() { return cReferenceExpressionParserRuleCall_1; }
		
		//ParenthesizedExpression
		public RuleCall getParenthesizedExpressionParserRuleCall_2() { return cParenthesizedExpressionParserRuleCall_2; }
	}
	public class ParenthesizedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ParenthesizedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionValueExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//// A parenthesized value expression is one value of the enclosing factor. The group is an object of its own so that the
		//// grouping the model records is the grouping the source requested, and so that the serializer emits it from the model
		//// rather than reconstructing it from the parse text.
		//ParenthesizedExpression:
		//    '(' expression=ValueExpression ')'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'(' expression=ValueExpression ')'
		public Group getGroup() { return cGroup; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }
		
		//expression=ValueExpression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }
		
		//ValueExpression
		public RuleCall getExpressionValueExpressionParserRuleCall_1_0() { return cExpressionValueExpressionParserRuleCall_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}
	public class ValueConstantElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ValueConstant");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBehaviorIntegerLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cBehaviorRealLiteralParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cBehaviorStringLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cBehaviorBooleanLiteralParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cHashPropertyReferenceParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//ValueConstant:
		//    BehaviorIntegerLiteral
		//    | BehaviorRealLiteral
		//    | BehaviorStringLiteral
		//    | BehaviorBooleanLiteral
		//    | HashPropertyReference
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//BehaviorIntegerLiteral
		//| BehaviorRealLiteral
		//| BehaviorStringLiteral
		//| BehaviorBooleanLiteral
		//| HashPropertyReference
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//BehaviorIntegerLiteral
		public RuleCall getBehaviorIntegerLiteralParserRuleCall_0() { return cBehaviorIntegerLiteralParserRuleCall_0; }
		
		//BehaviorRealLiteral
		public RuleCall getBehaviorRealLiteralParserRuleCall_1() { return cBehaviorRealLiteralParserRuleCall_1; }
		
		//BehaviorStringLiteral
		public RuleCall getBehaviorStringLiteralParserRuleCall_2() { return cBehaviorStringLiteralParserRuleCall_2; }
		
		//BehaviorBooleanLiteral
		public RuleCall getBehaviorBooleanLiteralParserRuleCall_3() { return cBehaviorBooleanLiteralParserRuleCall_3; }
		
		//HashPropertyReference
		public RuleCall getHashPropertyReferenceParserRuleCall_4() { return cHashPropertyReferenceParserRuleCall_4; }
	}
	public class BehaviorIntegerLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorIntegerLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueINTEGER_LITTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//BehaviorIntegerLiteral:
		//    value=INTEGER_LIT
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=INTEGER_LIT
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//INTEGER_LIT
		public RuleCall getValueINTEGER_LITTerminalRuleCall_0() { return cValueINTEGER_LITTerminalRuleCall_0; }
	}
	public class BehaviorRealLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorRealLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueREAL_LITTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//BehaviorRealLiteral:
		//    value=REAL_LIT
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=REAL_LIT
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//REAL_LIT
		public RuleCall getValueREAL_LITTerminalRuleCall_0() { return cValueREAL_LITTerminalRuleCall_0; }
	}
	public class BehaviorStringLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorStringLiteral");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//BehaviorStringLiteral:
		//    value=STRING
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//value=STRING
		public Assignment getValueAssignment() { return cValueAssignment; }
		
		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_0() { return cValueSTRINGTerminalRuleCall_0; }
	}
	public class BehaviorBooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.BehaviorBooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBehaviorBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cValueTrueKeyword_1_0_0 = (Keyword)cValueAssignment_1_0.eContents().get(0);
		private final Keyword cFalseKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		//BehaviorBooleanLiteral:
		//    {BehaviorBooleanLiteral} (value?='true' | 'false')
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{BehaviorBooleanLiteral} (value?='true' | 'false')
		public Group getGroup() { return cGroup; }
		
		//{BehaviorBooleanLiteral}
		public Action getBehaviorBooleanLiteralAction_0() { return cBehaviorBooleanLiteralAction_0; }
		
		//(value?='true' | 'false')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//value?='true'
		public Assignment getValueAssignment_1_0() { return cValueAssignment_1_0; }
		
		//'true'
		public Keyword getValueTrueKeyword_1_0_0() { return cValueTrueKeyword_1_0_0; }
		
		//'false'
		public Keyword getFalseKeyword_1_1() { return cFalseKeyword_1_1; }
	}
	public class ReferenceExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cReferenceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cReferenceReferenceParserRuleCall_0_0 = (RuleCall)cReferenceAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cPropertyAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final RuleCall cPropertyPropertyReferenceTailParserRuleCall_1_0_0 = (RuleCall)cPropertyAssignment_1_0.eContents().get(0);
		private final Assignment cDequeueAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cDequeueQuestionMarkKeyword_1_1_0 = (Keyword)cDequeueAssignment_1_1.eContents().get(0);
		private final Group cGroup_1_2 = (Group)cAlternatives_1.eContents().get(2);
		private final Keyword cApostropheKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Alternatives cAlternatives_1_2_1 = (Alternatives)cGroup_1_2.eContents().get(1);
		private final Assignment cCountAssignment_1_2_1_0 = (Assignment)cAlternatives_1_2_1.eContents().get(0);
		private final Keyword cCountCountKeyword_1_2_1_0_0 = (Keyword)cCountAssignment_1_2_1_0.eContents().get(0);
		private final Assignment cFreshAssignment_1_2_1_1 = (Assignment)cAlternatives_1_2_1.eContents().get(1);
		private final Keyword cFreshFreshKeyword_1_2_1_1_0 = (Keyword)cFreshAssignment_1_2_1_1.eContents().get(0);
		private final Assignment cUpdatedAssignment_1_2_1_2 = (Assignment)cAlternatives_1_2_1.eContents().get(2);
		private final Keyword cUpdatedUpdatedKeyword_1_2_1_2_0 = (Keyword)cUpdatedAssignment_1_2_1_2.eContents().get(0);
		
		//ReferenceExpression:
		//    reference=Reference
		//    (
		//        property=PropertyReferenceTail
		//        | dequeue?='?'
		//        | "'" (count?='count' | fresh?='fresh' | updated?='updated')
		//    )?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//reference=Reference
		//(
		//    property=PropertyReferenceTail
		//    | dequeue?='?'
		//    | "'" (count?='count' | fresh?='fresh' | updated?='updated')
		//)?
		public Group getGroup() { return cGroup; }
		
		//reference=Reference
		public Assignment getReferenceAssignment_0() { return cReferenceAssignment_0; }
		
		//Reference
		public RuleCall getReferenceReferenceParserRuleCall_0_0() { return cReferenceReferenceParserRuleCall_0_0; }
		
		//(
		//    property=PropertyReferenceTail
		//    | dequeue?='?'
		//    | "'" (count?='count' | fresh?='fresh' | updated?='updated')
		//)?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//property=PropertyReferenceTail
		public Assignment getPropertyAssignment_1_0() { return cPropertyAssignment_1_0; }
		
		//PropertyReferenceTail
		public RuleCall getPropertyPropertyReferenceTailParserRuleCall_1_0_0() { return cPropertyPropertyReferenceTailParserRuleCall_1_0_0; }
		
		//dequeue?='?'
		public Assignment getDequeueAssignment_1_1() { return cDequeueAssignment_1_1; }
		
		//'?'
		public Keyword getDequeueQuestionMarkKeyword_1_1_0() { return cDequeueQuestionMarkKeyword_1_1_0; }
		
		//"'" (count?='count' | fresh?='fresh' | updated?='updated')
		public Group getGroup_1_2() { return cGroup_1_2; }
		
		//"'"
		public Keyword getApostropheKeyword_1_2_0() { return cApostropheKeyword_1_2_0; }
		
		//(count?='count' | fresh?='fresh' | updated?='updated')
		public Alternatives getAlternatives_1_2_1() { return cAlternatives_1_2_1; }
		
		//count?='count'
		public Assignment getCountAssignment_1_2_1_0() { return cCountAssignment_1_2_1_0; }
		
		//'count'
		public Keyword getCountCountKeyword_1_2_1_0_0() { return cCountCountKeyword_1_2_1_0_0; }
		
		//fresh?='fresh'
		public Assignment getFreshAssignment_1_2_1_1() { return cFreshAssignment_1_2_1_1; }
		
		//'fresh'
		public Keyword getFreshFreshKeyword_1_2_1_1_0() { return cFreshFreshKeyword_1_2_1_1_0; }
		
		//updated?='updated'
		public Assignment getUpdatedAssignment_1_2_1_2() { return cUpdatedAssignment_1_2_1_2; }
		
		//'updated'
		public Keyword getUpdatedUpdatedKeyword_1_2_1_2_0() { return cUpdatedUpdatedKeyword_1_2_1_2_0; }
	}
	public class HashPropertyReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.HashPropertyReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumberSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cPropertyQualifiedNameParserRuleCall_1_0 = (RuleCall)cPropertyAssignment_1.eContents().get(0);
		private final Assignment cIndexesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIndexesPropertyArrayIndexParserRuleCall_2_0 = (RuleCall)cIndexesAssignment_2.eContents().get(0);
		private final Assignment cFieldsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFieldsNamedPropertyFieldParserRuleCall_3_0 = (RuleCall)cFieldsAssignment_3.eContents().get(0);
		
		//HashPropertyReference:
		//    '#' property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'#' property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*
		public Group getGroup() { return cGroup; }
		
		//'#'
		public Keyword getNumberSignKeyword_0() { return cNumberSignKeyword_0; }
		
		//property=QualifiedName
		public Assignment getPropertyAssignment_1() { return cPropertyAssignment_1; }
		
		//QualifiedName
		public RuleCall getPropertyQualifiedNameParserRuleCall_1_0() { return cPropertyQualifiedNameParserRuleCall_1_0; }
		
		//indexes+=PropertyArrayIndex*
		public Assignment getIndexesAssignment_2() { return cIndexesAssignment_2; }
		
		//PropertyArrayIndex
		public RuleCall getIndexesPropertyArrayIndexParserRuleCall_2_0() { return cIndexesPropertyArrayIndexParserRuleCall_2_0; }
		
		//fields+=NamedPropertyField*
		public Assignment getFieldsAssignment_3() { return cFieldsAssignment_3; }
		
		//NamedPropertyField
		public RuleCall getFieldsNamedPropertyFieldParserRuleCall_3_0() { return cFieldsNamedPropertyFieldParserRuleCall_3_0; }
	}
	public class PropertyReferenceTailElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyReferenceTail");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumberSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cPropertyQualifiedNameParserRuleCall_1_0 = (RuleCall)cPropertyAssignment_1.eContents().get(0);
		private final Assignment cIndexesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIndexesPropertyArrayIndexParserRuleCall_2_0 = (RuleCall)cIndexesAssignment_2.eContents().get(0);
		private final Assignment cFieldsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFieldsNamedPropertyFieldParserRuleCall_3_0 = (RuleCall)cFieldsAssignment_3.eContents().get(0);
		
		//PropertyReferenceTail:
		//    '#' property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'#' property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*
		public Group getGroup() { return cGroup; }
		
		//'#'
		public Keyword getNumberSignKeyword_0() { return cNumberSignKeyword_0; }
		
		//property=QualifiedName
		public Assignment getPropertyAssignment_1() { return cPropertyAssignment_1; }
		
		//QualifiedName
		public RuleCall getPropertyQualifiedNameParserRuleCall_1_0() { return cPropertyQualifiedNameParserRuleCall_1_0; }
		
		//indexes+=PropertyArrayIndex*
		public Assignment getIndexesAssignment_2() { return cIndexesAssignment_2; }
		
		//PropertyArrayIndex
		public RuleCall getIndexesPropertyArrayIndexParserRuleCall_2_0() { return cIndexesPropertyArrayIndexParserRuleCall_2_0; }
		
		//fields+=NamedPropertyField*
		public Assignment getFieldsAssignment_3() { return cFieldsAssignment_3; }
		
		//NamedPropertyField
		public RuleCall getFieldsNamedPropertyFieldParserRuleCall_3_0() { return cFieldsNamedPropertyFieldParserRuleCall_3_0; }
	}
	public class NamedPropertyFieldElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.NamedPropertyField");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFullStopKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Assignment cIndexesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIndexesPropertyArrayIndexParserRuleCall_2_0 = (RuleCall)cIndexesAssignment_2.eContents().get(0);
		
		//NamedPropertyField:
		//    '.' name=ID indexes+=PropertyArrayIndex*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'.' name=ID indexes+=PropertyArrayIndex*
		public Group getGroup() { return cGroup; }
		
		//'.'
		public Keyword getFullStopKeyword_0() { return cFullStopKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//indexes+=PropertyArrayIndex*
		public Assignment getIndexesAssignment_2() { return cIndexesAssignment_2; }
		
		//PropertyArrayIndex
		public RuleCall getIndexesPropertyArrayIndexParserRuleCall_2_0() { return cIndexesPropertyArrayIndexParserRuleCall_2_0; }
	}
	public class PropertyArrayIndexElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyArrayIndex");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValuePropertyIndexValueParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//PropertyArrayIndex:
		//    '[' value=PropertyIndexValue ']'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'[' value=PropertyIndexValue ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//value=PropertyIndexValue
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//PropertyIndexValue
		public RuleCall getValuePropertyIndexValueParserRuleCall_1_0() { return cValuePropertyIndexValueParserRuleCall_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}
	public class PropertyIndexValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyIndexValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBehaviorIntegerLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPropertyIndexPropertyReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cUnindexedReferenceExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//PropertyIndexValue:
		//    BehaviorIntegerLiteral
		//    | PropertyIndexPropertyReference
		//    | UnindexedReferenceExpression
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//BehaviorIntegerLiteral
		//| PropertyIndexPropertyReference
		//| UnindexedReferenceExpression
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//BehaviorIntegerLiteral
		public RuleCall getBehaviorIntegerLiteralParserRuleCall_0() { return cBehaviorIntegerLiteralParserRuleCall_0; }
		
		//PropertyIndexPropertyReference
		public RuleCall getPropertyIndexPropertyReferenceParserRuleCall_1() { return cPropertyIndexPropertyReferenceParserRuleCall_1; }
		
		//UnindexedReferenceExpression
		public RuleCall getUnindexedReferenceExpressionParserRuleCall_2() { return cUnindexedReferenceExpressionParserRuleCall_2; }
	}
	public class PropertyIndexPropertyReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.PropertyIndexPropertyReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumberSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPropertyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cPropertyQualifiedNameParserRuleCall_1_0 = (RuleCall)cPropertyAssignment_1.eContents().get(0);
		
		//PropertyIndexPropertyReference:
		//    '#' property=QualifiedName
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'#' property=QualifiedName
		public Group getGroup() { return cGroup; }
		
		//'#'
		public Keyword getNumberSignKeyword_0() { return cNumberSignKeyword_0; }
		
		//property=QualifiedName
		public Assignment getPropertyAssignment_1() { return cPropertyAssignment_1; }
		
		//QualifiedName
		public RuleCall getPropertyQualifiedNameParserRuleCall_1_0() { return cPropertyQualifiedNameParserRuleCall_1_0; }
	}
	public class UnindexedReferenceExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cReferenceAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cReferenceUnindexedReferenceParserRuleCall_0_0 = (RuleCall)cReferenceAssignment_0.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cDequeueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cDequeueQuestionMarkKeyword_1_0_0 = (Keyword)cDequeueAssignment_1_0.eContents().get(0);
		private final Group cGroup_1_1 = (Group)cAlternatives_1.eContents().get(1);
		private final Keyword cApostropheKeyword_1_1_0 = (Keyword)cGroup_1_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1_1 = (Alternatives)cGroup_1_1.eContents().get(1);
		private final Assignment cCountAssignment_1_1_1_0 = (Assignment)cAlternatives_1_1_1.eContents().get(0);
		private final Keyword cCountCountKeyword_1_1_1_0_0 = (Keyword)cCountAssignment_1_1_1_0.eContents().get(0);
		private final Assignment cFreshAssignment_1_1_1_1 = (Assignment)cAlternatives_1_1_1.eContents().get(1);
		private final Keyword cFreshFreshKeyword_1_1_1_1_0 = (Keyword)cFreshAssignment_1_1_1_1.eContents().get(0);
		private final Assignment cUpdatedAssignment_1_1_1_2 = (Assignment)cAlternatives_1_1_1.eContents().get(2);
		private final Keyword cUpdatedUpdatedKeyword_1_1_1_2_0 = (Keyword)cUpdatedAssignment_1_1_1_2.eContents().get(0);
		
		//UnindexedReferenceExpression:
		//    reference=UnindexedReference
		//    (dequeue?='?' | "'" (count?='count' | fresh?='fresh' | updated?='updated'))?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//reference=UnindexedReference
		//(dequeue?='?' | "'" (count?='count' | fresh?='fresh' | updated?='updated'))?
		public Group getGroup() { return cGroup; }
		
		//reference=UnindexedReference
		public Assignment getReferenceAssignment_0() { return cReferenceAssignment_0; }
		
		//UnindexedReference
		public RuleCall getReferenceUnindexedReferenceParserRuleCall_0_0() { return cReferenceUnindexedReferenceParserRuleCall_0_0; }
		
		//(dequeue?='?' | "'" (count?='count' | fresh?='fresh' | updated?='updated'))?
		public Alternatives getAlternatives_1() { return cAlternatives_1; }
		
		//dequeue?='?'
		public Assignment getDequeueAssignment_1_0() { return cDequeueAssignment_1_0; }
		
		//'?'
		public Keyword getDequeueQuestionMarkKeyword_1_0_0() { return cDequeueQuestionMarkKeyword_1_0_0; }
		
		//"'" (count?='count' | fresh?='fresh' | updated?='updated')
		public Group getGroup_1_1() { return cGroup_1_1; }
		
		//"'"
		public Keyword getApostropheKeyword_1_1_0() { return cApostropheKeyword_1_1_0; }
		
		//(count?='count' | fresh?='fresh' | updated?='updated')
		public Alternatives getAlternatives_1_1_1() { return cAlternatives_1_1_1; }
		
		//count?='count'
		public Assignment getCountAssignment_1_1_1_0() { return cCountAssignment_1_1_1_0; }
		
		//'count'
		public Keyword getCountCountKeyword_1_1_1_0_0() { return cCountCountKeyword_1_1_1_0_0; }
		
		//fresh?='fresh'
		public Assignment getFreshAssignment_1_1_1_1() { return cFreshAssignment_1_1_1_1; }
		
		//'fresh'
		public Keyword getFreshFreshKeyword_1_1_1_1_0() { return cFreshFreshKeyword_1_1_1_1_0; }
		
		//updated?='updated'
		public Assignment getUpdatedAssignment_1_1_1_2() { return cUpdatedAssignment_1_1_1_2; }
		
		//'updated'
		public Keyword getUpdatedUpdatedKeyword_1_1_1_2_0() { return cUpdatedUpdatedKeyword_1_1_1_2_0; }
	}
	public class UnindexedReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSegmentsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSegmentsUnindexedReferenceSegmentParserRuleCall_0_0 = (RuleCall)cSegmentsAssignment_0.eContents().get(0);
		private final Assignment cTailsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTailsUnindexedReferenceTailParserRuleCall_1_0 = (RuleCall)cTailsAssignment_1.eContents().get(0);
		
		//UnindexedReference:
		//    segments+=UnindexedReferenceSegment
		//    (tails+=UnindexedReferenceTail)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//segments+=UnindexedReferenceSegment
		//(tails+=UnindexedReferenceTail)*
		public Group getGroup() { return cGroup; }
		
		//segments+=UnindexedReferenceSegment
		public Assignment getSegmentsAssignment_0() { return cSegmentsAssignment_0; }
		
		//UnindexedReferenceSegment
		public RuleCall getSegmentsUnindexedReferenceSegmentParserRuleCall_0_0() { return cSegmentsUnindexedReferenceSegmentParserRuleCall_0_0; }
		
		//(tails+=UnindexedReferenceTail)*
		public Assignment getTailsAssignment_1() { return cTailsAssignment_1; }
		
		//UnindexedReferenceTail
		public RuleCall getTailsUnindexedReferenceTailParserRuleCall_1_0() { return cTailsUnindexedReferenceTailParserRuleCall_1_0; }
	}
	public class UnindexedReferenceTailElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceTail");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSeparatorAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSeparatorReferenceSeparatorParserRuleCall_0_0 = (RuleCall)cSeparatorAssignment_0.eContents().get(0);
		private final Assignment cSegmentAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSegmentUnindexedReferenceSegmentParserRuleCall_1_0 = (RuleCall)cSegmentAssignment_1.eContents().get(0);
		
		//UnindexedReferenceTail:
		//    separator=ReferenceSeparator segment=UnindexedReferenceSegment
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//separator=ReferenceSeparator segment=UnindexedReferenceSegment
		public Group getGroup() { return cGroup; }
		
		//separator=ReferenceSeparator
		public Assignment getSeparatorAssignment_0() { return cSeparatorAssignment_0; }
		
		//ReferenceSeparator
		public RuleCall getSeparatorReferenceSeparatorParserRuleCall_0_0() { return cSeparatorReferenceSeparatorParserRuleCall_0_0; }
		
		//segment=UnindexedReferenceSegment
		public Assignment getSegmentAssignment_1() { return cSegmentAssignment_1; }
		
		//UnindexedReferenceSegment
		public RuleCall getSegmentUnindexedReferenceSegmentParserRuleCall_1_0() { return cSegmentUnindexedReferenceSegmentParserRuleCall_1_0; }
	}
	public class UnindexedReferenceSegmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.UnindexedReferenceSegment");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//UnindexedReferenceSegment:
		//    name=ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QualifiedName returns ecore::EString:
		//    ID ('::' ID)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('::' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('::' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	public class ReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.Reference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSegmentsAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSegmentsReferenceSegmentParserRuleCall_0_0 = (RuleCall)cSegmentsAssignment_0.eContents().get(0);
		private final Assignment cTailsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTailsReferenceTailParserRuleCall_1_0 = (RuleCall)cTailsAssignment_1.eContents().get(0);
		
		//Reference:
		//    segments+=ReferenceSegment
		//    (tails+=ReferenceTail)*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//segments+=ReferenceSegment
		//(tails+=ReferenceTail)*
		public Group getGroup() { return cGroup; }
		
		//segments+=ReferenceSegment
		public Assignment getSegmentsAssignment_0() { return cSegmentsAssignment_0; }
		
		//ReferenceSegment
		public RuleCall getSegmentsReferenceSegmentParserRuleCall_0_0() { return cSegmentsReferenceSegmentParserRuleCall_0_0; }
		
		//(tails+=ReferenceTail)*
		public Assignment getTailsAssignment_1() { return cTailsAssignment_1; }
		
		//ReferenceTail
		public RuleCall getTailsReferenceTailParserRuleCall_1_0() { return cTailsReferenceTailParserRuleCall_1_0; }
	}
	public class ReferenceTailElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceTail");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cSeparatorAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cSeparatorReferenceSeparatorParserRuleCall_0_0 = (RuleCall)cSeparatorAssignment_0.eContents().get(0);
		private final Assignment cSegmentAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cSegmentReferenceSegmentParserRuleCall_1_0 = (RuleCall)cSegmentAssignment_1.eContents().get(0);
		
		//ReferenceTail:
		//    separator=ReferenceSeparator segment=ReferenceSegment
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//separator=ReferenceSeparator segment=ReferenceSegment
		public Group getGroup() { return cGroup; }
		
		//separator=ReferenceSeparator
		public Assignment getSeparatorAssignment_0() { return cSeparatorAssignment_0; }
		
		//ReferenceSeparator
		public RuleCall getSeparatorReferenceSeparatorParserRuleCall_0_0() { return cSeparatorReferenceSeparatorParserRuleCall_0_0; }
		
		//segment=ReferenceSegment
		public Assignment getSegmentAssignment_1() { return cSegmentAssignment_1; }
		
		//ReferenceSegment
		public RuleCall getSegmentReferenceSegmentParserRuleCall_1_0() { return cSegmentReferenceSegmentParserRuleCall_1_0; }
	}
	public class ReferenceSeparatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSeparator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cColonColonKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//ReferenceSeparator returns ecore::EString:
		//    '::' | '.'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'::' | '.'
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//'::'
		public Keyword getColonColonKeyword_0() { return cColonColonKeyword_0; }
		
		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }
	}
	public class ReferenceSegmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ReferenceSegment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Assignment cIndexesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cIndexesArrayIndexParserRuleCall_1_0 = (RuleCall)cIndexesAssignment_1.eContents().get(0);
		
		//ReferenceSegment:
		//    name=ID indexes+=ArrayIndex*
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID indexes+=ArrayIndex*
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//indexes+=ArrayIndex*
		public Assignment getIndexesAssignment_1() { return cIndexesAssignment_1; }
		
		//ArrayIndex
		public RuleCall getIndexesArrayIndexParserRuleCall_1_0() { return cIndexesArrayIndexParserRuleCall_1_0; }
	}
	public class ArrayIndexElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.ba.BehaviorAnnex.ArrayIndex");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueIntegerValueParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//ArrayIndex:
		//    '[' value=IntegerValue ']'
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//'[' value=IntegerValue ']'
		public Group getGroup() { return cGroup; }
		
		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }
		
		//value=IntegerValue
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//IntegerValue
		public RuleCall getValueIntegerValueParserRuleCall_1_0() { return cValueIntegerValueParserRuleCall_1_0; }
		
		//']'
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}
	
	
	private final AnnexSubclauseElements pAnnexSubclause;
	private final BehaviorAnnexElements pBehaviorAnnex;
	private final BehaviorVariableGroupElements pBehaviorVariableGroup;
	private final BehaviorVariableElements pBehaviorVariable;
	private final ArrayDimensionElements pArrayDimension;
	private final BehaviorPropertyAssociationElements pBehaviorPropertyAssociation;
	private final BehaviorStateGroupElements pBehaviorStateGroup;
	private final BehaviorStateElements pBehaviorState;
	private final BehaviorTransitionElements pBehaviorTransition;
	private final BehaviorConditionElements pBehaviorCondition;
	private final ExecuteConditionElements pExecuteCondition;
	private final DispatchConditionElements pDispatchCondition;
	private final DispatchTriggerConditionElements pDispatchTriggerCondition;
	private final DispatchTriggerLogicalExpressionElements pDispatchTriggerLogicalExpression;
	private final DispatchConjunctionElements pDispatchConjunction;
	private final ModeSwitchConditionElements pModeSwitchCondition;
	private final ModeSwitchConjunctionElements pModeSwitchConjunction;
	private final ModeSwitchTriggerElements pModeSwitchTrigger;
	private final InternalConditionElements pInternalCondition;
	private final BehaviorActionBlockElements pBehaviorActionBlock;
	private final BehaviorActionsElements pBehaviorActions;
	private final BehaviorActionElements pBehaviorAction;
	private final AssignmentActionElements pAssignmentAction;
	private final CommunicationActionElements pCommunicationAction;
	private final TimedActionElements pTimedAction;
	private final IfStatementElements pIfStatement;
	private final ElseIfClauseElements pElseIfClause;
	private final ForStatementElements pForStatement;
	private final WhileStatementElements pWhileStatement;
	private final DoUntilStatementElements pDoUntilStatement;
	private final ElementValuesElements pElementValues;
	private final BehaviorTimeElements pBehaviorTime;
	private final IntegerValueElements pIntegerValue;
	private final ValueExpressionElements pValueExpression;
	private final LogicalOperatorElements pLogicalOperator;
	private final LogicalOrOperatorElements pLogicalOrOperator;
	private final LogicalAndOperatorElements pLogicalAndOperator;
	private final RelationElements pRelation;
	private final RelationalOperatorElements pRelationalOperator;
	private final SimpleExpressionElements pSimpleExpression;
	private final UnaryAddingOperatorElements pUnaryAddingOperator;
	private final BinaryAddingOperatorElements pBinaryAddingOperator;
	private final TermElements pTerm;
	private final MultiplyingOperatorElements pMultiplyingOperator;
	private final FactorElements pFactor;
	private final BinaryNumericOperatorElements pBinaryNumericOperator;
	private final UnaryValueOperatorElements pUnaryValueOperator;
	private final ValueElements pValue;
	private final ParenthesizedExpressionElements pParenthesizedExpression;
	private final ValueConstantElements pValueConstant;
	private final BehaviorIntegerLiteralElements pBehaviorIntegerLiteral;
	private final BehaviorRealLiteralElements pBehaviorRealLiteral;
	private final BehaviorStringLiteralElements pBehaviorStringLiteral;
	private final BehaviorBooleanLiteralElements pBehaviorBooleanLiteral;
	private final ReferenceExpressionElements pReferenceExpression;
	private final HashPropertyReferenceElements pHashPropertyReference;
	private final PropertyReferenceTailElements pPropertyReferenceTail;
	private final NamedPropertyFieldElements pNamedPropertyField;
	private final PropertyArrayIndexElements pPropertyArrayIndex;
	private final PropertyIndexValueElements pPropertyIndexValue;
	private final PropertyIndexPropertyReferenceElements pPropertyIndexPropertyReference;
	private final UnindexedReferenceExpressionElements pUnindexedReferenceExpression;
	private final UnindexedReferenceElements pUnindexedReference;
	private final UnindexedReferenceTailElements pUnindexedReferenceTail;
	private final UnindexedReferenceSegmentElements pUnindexedReferenceSegment;
	private final QualifiedNameElements pQualifiedName;
	private final ReferenceElements pReference;
	private final ReferenceTailElements pReferenceTail;
	private final ReferenceSeparatorElements pReferenceSeparator;
	private final ReferenceSegmentElements pReferenceSegment;
	private final ArrayIndexElements pArrayIndex;
	
	private final Grammar grammar;
	
	private final PropertiesGrammarAccess gaProperties;

	@Inject
	public BehaviorAnnexGrammarAccess(GrammarProvider grammarProvider,
			PropertiesGrammarAccess gaProperties) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaProperties = gaProperties;
		this.pAnnexSubclause = new AnnexSubclauseElements();
		this.pBehaviorAnnex = new BehaviorAnnexElements();
		this.pBehaviorVariableGroup = new BehaviorVariableGroupElements();
		this.pBehaviorVariable = new BehaviorVariableElements();
		this.pArrayDimension = new ArrayDimensionElements();
		this.pBehaviorPropertyAssociation = new BehaviorPropertyAssociationElements();
		this.pBehaviorStateGroup = new BehaviorStateGroupElements();
		this.pBehaviorState = new BehaviorStateElements();
		this.pBehaviorTransition = new BehaviorTransitionElements();
		this.pBehaviorCondition = new BehaviorConditionElements();
		this.pExecuteCondition = new ExecuteConditionElements();
		this.pDispatchCondition = new DispatchConditionElements();
		this.pDispatchTriggerCondition = new DispatchTriggerConditionElements();
		this.pDispatchTriggerLogicalExpression = new DispatchTriggerLogicalExpressionElements();
		this.pDispatchConjunction = new DispatchConjunctionElements();
		this.pModeSwitchCondition = new ModeSwitchConditionElements();
		this.pModeSwitchConjunction = new ModeSwitchConjunctionElements();
		this.pModeSwitchTrigger = new ModeSwitchTriggerElements();
		this.pInternalCondition = new InternalConditionElements();
		this.pBehaviorActionBlock = new BehaviorActionBlockElements();
		this.pBehaviorActions = new BehaviorActionsElements();
		this.pBehaviorAction = new BehaviorActionElements();
		this.pAssignmentAction = new AssignmentActionElements();
		this.pCommunicationAction = new CommunicationActionElements();
		this.pTimedAction = new TimedActionElements();
		this.pIfStatement = new IfStatementElements();
		this.pElseIfClause = new ElseIfClauseElements();
		this.pForStatement = new ForStatementElements();
		this.pWhileStatement = new WhileStatementElements();
		this.pDoUntilStatement = new DoUntilStatementElements();
		this.pElementValues = new ElementValuesElements();
		this.pBehaviorTime = new BehaviorTimeElements();
		this.pIntegerValue = new IntegerValueElements();
		this.pValueExpression = new ValueExpressionElements();
		this.pLogicalOperator = new LogicalOperatorElements();
		this.pLogicalOrOperator = new LogicalOrOperatorElements();
		this.pLogicalAndOperator = new LogicalAndOperatorElements();
		this.pRelation = new RelationElements();
		this.pRelationalOperator = new RelationalOperatorElements();
		this.pSimpleExpression = new SimpleExpressionElements();
		this.pUnaryAddingOperator = new UnaryAddingOperatorElements();
		this.pBinaryAddingOperator = new BinaryAddingOperatorElements();
		this.pTerm = new TermElements();
		this.pMultiplyingOperator = new MultiplyingOperatorElements();
		this.pFactor = new FactorElements();
		this.pBinaryNumericOperator = new BinaryNumericOperatorElements();
		this.pUnaryValueOperator = new UnaryValueOperatorElements();
		this.pValue = new ValueElements();
		this.pParenthesizedExpression = new ParenthesizedExpressionElements();
		this.pValueConstant = new ValueConstantElements();
		this.pBehaviorIntegerLiteral = new BehaviorIntegerLiteralElements();
		this.pBehaviorRealLiteral = new BehaviorRealLiteralElements();
		this.pBehaviorStringLiteral = new BehaviorStringLiteralElements();
		this.pBehaviorBooleanLiteral = new BehaviorBooleanLiteralElements();
		this.pReferenceExpression = new ReferenceExpressionElements();
		this.pHashPropertyReference = new HashPropertyReferenceElements();
		this.pPropertyReferenceTail = new PropertyReferenceTailElements();
		this.pNamedPropertyField = new NamedPropertyFieldElements();
		this.pPropertyArrayIndex = new PropertyArrayIndexElements();
		this.pPropertyIndexValue = new PropertyIndexValueElements();
		this.pPropertyIndexPropertyReference = new PropertyIndexPropertyReferenceElements();
		this.pUnindexedReferenceExpression = new UnindexedReferenceExpressionElements();
		this.pUnindexedReference = new UnindexedReferenceElements();
		this.pUnindexedReferenceTail = new UnindexedReferenceTailElements();
		this.pUnindexedReferenceSegment = new UnindexedReferenceSegmentElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.pReference = new ReferenceElements();
		this.pReferenceTail = new ReferenceTailElements();
		this.pReferenceSeparator = new ReferenceSeparatorElements();
		this.pReferenceSegment = new ReferenceSegmentElements();
		this.pArrayIndex = new ArrayIndexElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.xtext.aadl2.ba.BehaviorAnnex".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public PropertiesGrammarAccess getPropertiesGrammarAccess() {
		return gaProperties;
	}

	
	//AnnexSubclause returns aadl2::AnnexSubclause:
	//    BehaviorAnnex
	//;
	public AnnexSubclauseElements getAnnexSubclauseAccess() {
		return pAnnexSubclause;
	}
	
	public ParserRule getAnnexSubclauseRule() {
		return getAnnexSubclauseAccess().getRule();
	}
	
	//BehaviorAnnex:
	//    {BehaviorAnnex}
	//    ('variables' variableGroups+=BehaviorVariableGroup+)?
	//    ('states' stateGroups+=BehaviorStateGroup+)?
	//    ('transitions' transitions+=BehaviorTransition+)?
	//;
	public BehaviorAnnexElements getBehaviorAnnexAccess() {
		return pBehaviorAnnex;
	}
	
	public ParserRule getBehaviorAnnexRule() {
		return getBehaviorAnnexAccess().getRule();
	}
	
	//BehaviorVariableGroup:
	//    variables+=BehaviorVariable (',' variables+=BehaviorVariable)*
	//    ':' dataClassifier=[aadl2::ComponentClassifier|QCREF]
	//    (':=' initialValue=ValueConstant)?
	//    ('{' propertyAssociations+=BehaviorPropertyAssociation+ '}')?
	//    ';'
	//;
	public BehaviorVariableGroupElements getBehaviorVariableGroupAccess() {
		return pBehaviorVariableGroup;
	}
	
	public ParserRule getBehaviorVariableGroupRule() {
		return getBehaviorVariableGroupAccess().getRule();
	}
	
	//BehaviorVariable:
	//    name=ID arrayDimensions+=ArrayDimension*
	//;
	public BehaviorVariableElements getBehaviorVariableAccess() {
		return pBehaviorVariable;
	}
	
	public ParserRule getBehaviorVariableRule() {
		return getBehaviorVariableAccess().getRule();
	}
	
	//ArrayDimension:
	//    '[' size=IntegerValue ']'
	//;
	public ArrayDimensionElements getArrayDimensionAccess() {
		return pArrayDimension;
	}
	
	public ParserRule getArrayDimensionRule() {
		return getArrayDimensionAccess().getRule();
	}
	
	//BehaviorPropertyAssociation:
	//    property=[aadl2::Property|QPREF] '=>' ownedValue=PropertyExpression ';'
	//;
	public BehaviorPropertyAssociationElements getBehaviorPropertyAssociationAccess() {
		return pBehaviorPropertyAssociation;
	}
	
	public ParserRule getBehaviorPropertyAssociationRule() {
		return getBehaviorPropertyAssociationAccess().getRule();
	}
	
	//BehaviorStateGroup:
	//    states+=BehaviorState (',' states+=BehaviorState)*
	//    ':' initial?='initial'? complete?='complete'? final?='final'? 'state' ';'
	//;
	public BehaviorStateGroupElements getBehaviorStateGroupAccess() {
		return pBehaviorStateGroup;
	}
	
	public ParserRule getBehaviorStateGroupRule() {
		return getBehaviorStateGroupAccess().getRule();
	}
	
	//BehaviorState:
	//    name=ID
	//;
	public BehaviorStateElements getBehaviorStateAccess() {
		return pBehaviorState;
	}
	
	public ParserRule getBehaviorStateRule() {
		return getBehaviorStateAccess().getRule();
	}
	
	//BehaviorTransition:
	//    (name=ID ('[' priority=INTEGER_LIT ']')? ':')?
	//    sourceStates+=[BehaviorState|ID] (',' sourceStates+=[BehaviorState|ID])*
	//    '-[' condition=BehaviorCondition? ']->'
	//    destinationState=[BehaviorState|ID]
	//    actionBlock=BehaviorActionBlock?
	//    ';'
	//;
	public BehaviorTransitionElements getBehaviorTransitionAccess() {
		return pBehaviorTransition;
	}
	
	public ParserRule getBehaviorTransitionRule() {
		return getBehaviorTransitionAccess().getRule();
	}
	
	//BehaviorCondition:
	//    'on' (dispatch=DispatchCondition | internal=InternalCondition | modeSwitch=ModeSwitchCondition)
	//    | execute=ExecuteCondition
	//;
	public BehaviorConditionElements getBehaviorConditionAccess() {
		return pBehaviorCondition;
	}
	
	public ParserRule getBehaviorConditionRule() {
		return getBehaviorConditionAccess().getRule();
	}
	
	//ExecuteCondition:
	//    value=ValueExpression
	//    | timeout?='timeout'
	//    | otherwise?='otherwise'
	//;
	public ExecuteConditionElements getExecuteConditionAccess() {
		return pExecuteCondition;
	}
	
	public ParserRule getExecuteConditionRule() {
		return getExecuteConditionAccess().getRule();
	}
	
	//// Both the trigger and the frozen port list are optional, so the action creates the object for a bare 'on dispatch'.
	//DispatchCondition:
	//    {DispatchCondition} 'dispatch' trigger=DispatchTriggerCondition?
	//    ('frozen' '(' frozenPorts+=Reference (',' frozenPorts+=Reference)* ')')?
	//;
	public DispatchConditionElements getDispatchConditionAccess() {
		return pDispatchCondition;
	}
	
	public ParserRule getDispatchConditionRule() {
		return getDispatchConditionAccess().getRule();
	}
	
	//// The reset ports of a completion relative timeout. D.4 requires the time when they are listed, but a reset-port list
	//// without one is worth a diagnostic of its own rather than a syntax error, so the time stays optional here.
	//DispatchTriggerCondition:
	//    expression=DispatchTriggerLogicalExpression
	//    | timeout?='timeout' ('(' resetPorts+=Reference ('or' resetPorts+=Reference)* ')')? time=BehaviorTime?
	//    | stop?='stop'
	//;
	public DispatchTriggerConditionElements getDispatchTriggerConditionAccess() {
		return pDispatchTriggerCondition;
	}
	
	public ParserRule getDispatchTriggerConditionRule() {
		return getDispatchTriggerConditionAccess().getRule();
	}
	
	//DispatchTriggerLogicalExpression:
	//    conjunctions+=DispatchConjunction ('or' conjunctions+=DispatchConjunction)*
	//;
	public DispatchTriggerLogicalExpressionElements getDispatchTriggerLogicalExpressionAccess() {
		return pDispatchTriggerLogicalExpression;
	}
	
	public ParserRule getDispatchTriggerLogicalExpressionRule() {
		return getDispatchTriggerLogicalExpressionAccess().getRule();
	}
	
	//DispatchConjunction:
	//    triggers+=Reference ('and' triggers+=Reference)*
	//;
	public DispatchConjunctionElements getDispatchConjunctionAccess() {
		return pDispatchConjunction;
	}
	
	public ParserRule getDispatchConjunctionRule() {
		return getDispatchConjunctionAccess().getRule();
	}
	
	//ModeSwitchCondition:
	//    conjunctions+=ModeSwitchConjunction
	//    (logicalOperators+=LogicalOrOperator conjunctions+=ModeSwitchConjunction)*
	//;
	public ModeSwitchConditionElements getModeSwitchConditionAccess() {
		return pModeSwitchCondition;
	}
	
	public ParserRule getModeSwitchConditionRule() {
		return getModeSwitchConditionAccess().getRule();
	}
	
	//ModeSwitchConjunction:
	//    triggers+=ModeSwitchTrigger
	//    (logicalOperators+=LogicalAndOperator triggers+=ModeSwitchTrigger)*
	//;
	public ModeSwitchConjunctionElements getModeSwitchConjunctionAccess() {
		return pModeSwitchConjunction;
	}
	
	public ParserRule getModeSwitchConjunctionRule() {
		return getModeSwitchConjunctionAccess().getRule();
	}
	
	//ModeSwitchTrigger:
	//    reference=Reference
	//    | '(' expression=ModeSwitchCondition ')'
	//;
	public ModeSwitchTriggerElements getModeSwitchTriggerAccess() {
		return pModeSwitchTrigger;
	}
	
	public ParserRule getModeSwitchTriggerRule() {
		return getModeSwitchTriggerAccess().getRule();
	}
	
	//// The listed names are internal event or event data features of the containing component. Like every other name in
	//// the annex they stay symbolic here; the translator resolves them against the owner.
	//InternalCondition:
	//    'internal' internalPorts+=Reference ('or' internalPorts+=Reference)*
	//;
	public InternalConditionElements getInternalConditionAccess() {
		return pInternalCondition;
	}
	
	public ParserRule getInternalConditionRule() {
		return getInternalConditionAccess().getRule();
	}
	
	//BehaviorActionBlock:
	//    '{' content=BehaviorActions '}'
	//    ('timeout' timeout=BehaviorTime)?
	//;
	public BehaviorActionBlockElements getBehaviorActionBlockAccess() {
		return pBehaviorActionBlock;
	}
	
	public ParserRule getBehaviorActionBlockRule() {
		return getBehaviorActionBlockAccess().getRule();
	}
	
	//BehaviorActions:
	//    BehaviorAction
	//    (
	//        {BehaviorActionSequence.actions+=current} ';' actions+=BehaviorAction
	//            (';' actions+=BehaviorAction)*
	//        | {BehaviorActionSet.actions+=current} '&' actions+=BehaviorAction
	//            ('&' actions+=BehaviorAction)*
	//    )?
	//;
	public BehaviorActionsElements getBehaviorActionsAccess() {
		return pBehaviorActions;
	}
	
	public ParserRule getBehaviorActionsRule() {
		return getBehaviorActionsAccess().getRule();
	}
	
	//BehaviorAction:
	//    => AssignmentAction
	//    | CommunicationAction
	//    | TimedAction
	//    | IfStatement
	//    | ForStatement
	//    | WhileStatement
	//    | DoUntilStatement
	//    | BehaviorActionBlock
	//;
	public BehaviorActionElements getBehaviorActionAccess() {
		return pBehaviorAction;
	}
	
	public ParserRule getBehaviorActionRule() {
		return getBehaviorActionAccess().getRule();
	}
	
	//AssignmentAction:
	//    target=Reference ':=' (value=ValueExpression | any?='any')
	//;
	public AssignmentActionElements getAssignmentActionAccess() {
		return pAssignmentAction;
	}
	
	public ParserRule getAssignmentActionRule() {
		return getAssignmentActionAccess().getRule();
	}
	
	//CommunicationAction:
	//    (
	//        reference=Reference
	//        (
	//            send?='!' ('(' parameters+=ValueExpression (',' parameters+=ValueExpression)* ')')?
	//            | dequeue?='?' ('(' target=Reference ')')?
	//            | freeze?='>>'
	//            | lock?='!<'
	//            | unlock?='!>'
	//        )
	//    )
	//    | all?='*' (allLock?='!<' | allUnlock?='!>')
	//;
	public CommunicationActionElements getCommunicationActionAccess() {
		return pCommunicationAction;
	}
	
	public ParserRule getCommunicationActionRule() {
		return getCommunicationActionAccess().getRule();
	}
	
	//TimedAction:
	//    'computation' '(' lowerTime=BehaviorTime ('..' upperTime=BehaviorTime)? ')'
	//    ('in' 'binding' '(' processors+=[aadl2::ComponentClassifier|QCREF]
	//        (',' processors+=[aadl2::ComponentClassifier|QCREF])* ')')?
	//;
	public TimedActionElements getTimedActionAccess() {
		return pTimedAction;
	}
	
	public ParserRule getTimedActionRule() {
		return getTimedActionAccess().getRule();
	}
	
	//IfStatement:
	//    'if' '(' condition=ValueExpression ')' thenActions=BehaviorActions
	//    elseIfs+=ElseIfClause*
	//    ('else' elseActions=BehaviorActions)?
	//    'end' 'if'
	//;
	public IfStatementElements getIfStatementAccess() {
		return pIfStatement;
	}
	
	public ParserRule getIfStatementRule() {
		return getIfStatementAccess().getRule();
	}
	
	//ElseIfClause:
	//    'elsif' '(' condition=ValueExpression ')' actions=BehaviorActions
	//;
	public ElseIfClauseElements getElseIfClauseAccess() {
		return pElseIfClause;
	}
	
	public ParserRule getElseIfClauseRule() {
		return getElseIfClauseAccess().getRule();
	}
	
	//ForStatement:
	//    (for?='for' | forall?='forall')
	//    '(' variable=ID ':' dataClassifier=[aadl2::ComponentClassifier|QCREF]
	//    'in' values=ElementValues ')'
	//    '{' actions=BehaviorActions '}'
	//;
	public ForStatementElements getForStatementAccess() {
		return pForStatement;
	}
	
	public ParserRule getForStatementRule() {
		return getForStatementAccess().getRule();
	}
	
	//WhileStatement:
	//    'while' '(' condition=ValueExpression ')' '{' actions=BehaviorActions '}'
	//;
	public WhileStatementElements getWhileStatementAccess() {
		return pWhileStatement;
	}
	
	public ParserRule getWhileStatementRule() {
		return getWhileStatementAccess().getRule();
	}
	
	//DoUntilStatement:
	//    'do' actions=BehaviorActions 'until' '(' condition=ValueExpression ')'
	//;
	public DoUntilStatementElements getDoUntilStatementAccess() {
		return pDoUntilStatement;
	}
	
	public ParserRule getDoUntilStatementRule() {
		return getDoUntilStatementAccess().getRule();
	}
	
	//ElementValues:
	//    lower=IntegerValue ('..' upper=IntegerValue)?
	//;
	public ElementValuesElements getElementValuesAccess() {
		return pElementValues;
	}
	
	public ParserRule getElementValuesRule() {
		return getElementValuesAccess().getRule();
	}
	
	//BehaviorTime:
	//    value=IntegerValue unit=[aadl2::UnitLiteral|ID]
	//;
	public BehaviorTimeElements getBehaviorTimeAccess() {
		return pBehaviorTime;
	}
	
	public ParserRule getBehaviorTimeRule() {
		return getBehaviorTimeAccess().getRule();
	}
	
	//IntegerValue:
	//    BehaviorIntegerLiteral
	//    | HashPropertyReference
	//    | ReferenceExpression
	//;
	public IntegerValueElements getIntegerValueAccess() {
		return pIntegerValue;
	}
	
	public ParserRule getIntegerValueRule() {
		return getIntegerValueAccess().getRule();
	}
	
	//// The expression rules follow the D.7 productions rather than one rule per operator, because the standard puts every
	//// logical operator on a single precedence level and associates the operators of one level from left to right.
	//// 'a or b and c' therefore means '(a or b) and c'.
	//ValueExpression:
	//    Relation
	//    ({BinaryExpression.left=current} operator=LogicalOperator right=Relation)*
	//;
	public ValueExpressionElements getValueExpressionAccess() {
		return pValueExpression;
	}
	
	public ParserRule getValueExpressionRule() {
		return getValueExpressionAccess().getRule();
	}
	
	//LogicalOperator returns ecore::EString:
	//    LogicalAndOperator | LogicalOrOperator
	//;
	public LogicalOperatorElements getLogicalOperatorAccess() {
		return pLogicalOperator;
	}
	
	public ParserRule getLogicalOperatorRule() {
		return getLogicalOperatorAccess().getRule();
	}
	
	//LogicalOrOperator returns ecore::EString:
	//    'or' ('else')? | 'xor'
	//;
	public LogicalOrOperatorElements getLogicalOrOperatorAccess() {
		return pLogicalOrOperator;
	}
	
	public ParserRule getLogicalOrOperatorRule() {
		return getLogicalOrOperatorAccess().getRule();
	}
	
	//LogicalAndOperator returns ecore::EString:
	//    'and' ('then')?
	//;
	public LogicalAndOperatorElements getLogicalAndOperatorAccess() {
		return pLogicalAndOperator;
	}
	
	public ParserRule getLogicalAndOperatorRule() {
		return getLogicalAndOperatorAccess().getRule();
	}
	
	//Relation returns ValueExpression:
	//    SimpleExpression
	//    ({BinaryExpression.left=current} operator=RelationalOperator right=SimpleExpression)?
	//;
	public RelationElements getRelationAccess() {
		return pRelation;
	}
	
	public ParserRule getRelationRule() {
		return getRelationAccess().getRule();
	}
	
	//RelationalOperator returns ecore::EString:
	//    '=' | '!=' | '<' | '<=' | '>' | '>='
	//;
	public RelationalOperatorElements getRelationalOperatorAccess() {
		return pRelationalOperator;
	}
	
	public ParserRule getRelationalOperatorRule() {
		return getRelationalOperatorAccess().getRule();
	}
	
	//// The unary adding operator leads the whole simple expression, so it binds below the multiplying and the numeric
	//// operators: '-a mod b' is '-(a mod b)' and '-a ** b' is '-(a ** b)'. D.7 admits '-' only; '+' remains accepted here
	//// and is tracked separately as issue #3170.
	//SimpleExpression returns ValueExpression:
	//    ({UnaryExpression} operator=UnaryAddingOperator operand=Term | Term)
	//    ({BinaryExpression.left=current} operator=BinaryAddingOperator right=Term)*
	//;
	public SimpleExpressionElements getSimpleExpressionAccess() {
		return pSimpleExpression;
	}
	
	public ParserRule getSimpleExpressionRule() {
		return getSimpleExpressionAccess().getRule();
	}
	
	//UnaryAddingOperator returns ecore::EString:
	//    '-' | '+'
	//;
	public UnaryAddingOperatorElements getUnaryAddingOperatorAccess() {
		return pUnaryAddingOperator;
	}
	
	public ParserRule getUnaryAddingOperatorRule() {
		return getUnaryAddingOperatorAccess().getRule();
	}
	
	//BinaryAddingOperator returns ecore::EString:
	//    '+' | '-'
	//;
	public BinaryAddingOperatorElements getBinaryAddingOperatorAccess() {
		return pBinaryAddingOperator;
	}
	
	public ParserRule getBinaryAddingOperatorRule() {
		return getBinaryAddingOperatorAccess().getRule();
	}
	
	//Term returns ValueExpression:
	//    Factor
	//    ({BinaryExpression.left=current} operator=MultiplyingOperator right=Factor)*
	//;
	public TermElements getTermAccess() {
		return pTerm;
	}
	
	public ParserRule getTermRule() {
		return getTermAccess().getRule();
	}
	
	//MultiplyingOperator returns ecore::EString:
	//    '*' | '/' | 'mod' | 'rem'
	//;
	public MultiplyingOperatorElements getMultiplyingOperatorAccess() {
		return pMultiplyingOperator;
	}
	
	public ParserRule getMultiplyingOperatorRule() {
		return getMultiplyingOperatorAccess().getRule();
	}
	
	//// A factor admits at most one exponentiation and applies a unary numeric or boolean operator to a single value, so
	//// 'a ** b ** c', 'abs -a', and 'not not a' need explicit parentheses.
	//Factor returns ValueExpression:
	//    Value
	//    ({BinaryExpression.left=current} operator=BinaryNumericOperator right=Value)?
	//    | {UnaryExpression} operator=UnaryValueOperator operand=Value
	//;
	public FactorElements getFactorAccess() {
		return pFactor;
	}
	
	public ParserRule getFactorRule() {
		return getFactorAccess().getRule();
	}
	
	//BinaryNumericOperator returns ecore::EString:
	//    '**'
	//;
	public BinaryNumericOperatorElements getBinaryNumericOperatorAccess() {
		return pBinaryNumericOperator;
	}
	
	public ParserRule getBinaryNumericOperatorRule() {
		return getBinaryNumericOperatorAccess().getRule();
	}
	
	//UnaryValueOperator returns ecore::EString:
	//    'abs' | 'not'
	//;
	public UnaryValueOperatorElements getUnaryValueOperatorAccess() {
		return pUnaryValueOperator;
	}
	
	public ParserRule getUnaryValueOperatorRule() {
		return getUnaryValueOperatorAccess().getRule();
	}
	
	//Value returns ValueExpression:
	//    ValueConstant
	//    | ReferenceExpression
	//    | ParenthesizedExpression
	//;
	public ValueElements getValueAccess() {
		return pValue;
	}
	
	public ParserRule getValueRule() {
		return getValueAccess().getRule();
	}
	
	//// A parenthesized value expression is one value of the enclosing factor. The group is an object of its own so that the
	//// grouping the model records is the grouping the source requested, and so that the serializer emits it from the model
	//// rather than reconstructing it from the parse text.
	//ParenthesizedExpression:
	//    '(' expression=ValueExpression ')'
	//;
	public ParenthesizedExpressionElements getParenthesizedExpressionAccess() {
		return pParenthesizedExpression;
	}
	
	public ParserRule getParenthesizedExpressionRule() {
		return getParenthesizedExpressionAccess().getRule();
	}
	
	//ValueConstant:
	//    BehaviorIntegerLiteral
	//    | BehaviorRealLiteral
	//    | BehaviorStringLiteral
	//    | BehaviorBooleanLiteral
	//    | HashPropertyReference
	//;
	public ValueConstantElements getValueConstantAccess() {
		return pValueConstant;
	}
	
	public ParserRule getValueConstantRule() {
		return getValueConstantAccess().getRule();
	}
	
	//BehaviorIntegerLiteral:
	//    value=INTEGER_LIT
	//;
	public BehaviorIntegerLiteralElements getBehaviorIntegerLiteralAccess() {
		return pBehaviorIntegerLiteral;
	}
	
	public ParserRule getBehaviorIntegerLiteralRule() {
		return getBehaviorIntegerLiteralAccess().getRule();
	}
	
	//BehaviorRealLiteral:
	//    value=REAL_LIT
	//;
	public BehaviorRealLiteralElements getBehaviorRealLiteralAccess() {
		return pBehaviorRealLiteral;
	}
	
	public ParserRule getBehaviorRealLiteralRule() {
		return getBehaviorRealLiteralAccess().getRule();
	}
	
	//BehaviorStringLiteral:
	//    value=STRING
	//;
	public BehaviorStringLiteralElements getBehaviorStringLiteralAccess() {
		return pBehaviorStringLiteral;
	}
	
	public ParserRule getBehaviorStringLiteralRule() {
		return getBehaviorStringLiteralAccess().getRule();
	}
	
	//BehaviorBooleanLiteral:
	//    {BehaviorBooleanLiteral} (value?='true' | 'false')
	//;
	public BehaviorBooleanLiteralElements getBehaviorBooleanLiteralAccess() {
		return pBehaviorBooleanLiteral;
	}
	
	public ParserRule getBehaviorBooleanLiteralRule() {
		return getBehaviorBooleanLiteralAccess().getRule();
	}
	
	//ReferenceExpression:
	//    reference=Reference
	//    (
	//        property=PropertyReferenceTail
	//        | dequeue?='?'
	//        | "'" (count?='count' | fresh?='fresh' | updated?='updated')
	//    )?
	//;
	public ReferenceExpressionElements getReferenceExpressionAccess() {
		return pReferenceExpression;
	}
	
	public ParserRule getReferenceExpressionRule() {
		return getReferenceExpressionAccess().getRule();
	}
	
	//HashPropertyReference:
	//    '#' property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*
	//;
	public HashPropertyReferenceElements getHashPropertyReferenceAccess() {
		return pHashPropertyReference;
	}
	
	public ParserRule getHashPropertyReferenceRule() {
		return getHashPropertyReferenceAccess().getRule();
	}
	
	//PropertyReferenceTail:
	//    '#' property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*
	//;
	public PropertyReferenceTailElements getPropertyReferenceTailAccess() {
		return pPropertyReferenceTail;
	}
	
	public ParserRule getPropertyReferenceTailRule() {
		return getPropertyReferenceTailAccess().getRule();
	}
	
	//NamedPropertyField:
	//    '.' name=ID indexes+=PropertyArrayIndex*
	//;
	public NamedPropertyFieldElements getNamedPropertyFieldAccess() {
		return pNamedPropertyField;
	}
	
	public ParserRule getNamedPropertyFieldRule() {
		return getNamedPropertyFieldAccess().getRule();
	}
	
	//PropertyArrayIndex:
	//    '[' value=PropertyIndexValue ']'
	//;
	public PropertyArrayIndexElements getPropertyArrayIndexAccess() {
		return pPropertyArrayIndex;
	}
	
	public ParserRule getPropertyArrayIndexRule() {
		return getPropertyArrayIndexAccess().getRule();
	}
	
	//PropertyIndexValue:
	//    BehaviorIntegerLiteral
	//    | PropertyIndexPropertyReference
	//    | UnindexedReferenceExpression
	//;
	public PropertyIndexValueElements getPropertyIndexValueAccess() {
		return pPropertyIndexValue;
	}
	
	public ParserRule getPropertyIndexValueRule() {
		return getPropertyIndexValueAccess().getRule();
	}
	
	//PropertyIndexPropertyReference:
	//    '#' property=QualifiedName
	//;
	public PropertyIndexPropertyReferenceElements getPropertyIndexPropertyReferenceAccess() {
		return pPropertyIndexPropertyReference;
	}
	
	public ParserRule getPropertyIndexPropertyReferenceRule() {
		return getPropertyIndexPropertyReferenceAccess().getRule();
	}
	
	//UnindexedReferenceExpression:
	//    reference=UnindexedReference
	//    (dequeue?='?' | "'" (count?='count' | fresh?='fresh' | updated?='updated'))?
	//;
	public UnindexedReferenceExpressionElements getUnindexedReferenceExpressionAccess() {
		return pUnindexedReferenceExpression;
	}
	
	public ParserRule getUnindexedReferenceExpressionRule() {
		return getUnindexedReferenceExpressionAccess().getRule();
	}
	
	//UnindexedReference:
	//    segments+=UnindexedReferenceSegment
	//    (tails+=UnindexedReferenceTail)*
	//;
	public UnindexedReferenceElements getUnindexedReferenceAccess() {
		return pUnindexedReference;
	}
	
	public ParserRule getUnindexedReferenceRule() {
		return getUnindexedReferenceAccess().getRule();
	}
	
	//UnindexedReferenceTail:
	//    separator=ReferenceSeparator segment=UnindexedReferenceSegment
	//;
	public UnindexedReferenceTailElements getUnindexedReferenceTailAccess() {
		return pUnindexedReferenceTail;
	}
	
	public ParserRule getUnindexedReferenceTailRule() {
		return getUnindexedReferenceTailAccess().getRule();
	}
	
	//UnindexedReferenceSegment:
	//    name=ID
	//;
	public UnindexedReferenceSegmentElements getUnindexedReferenceSegmentAccess() {
		return pUnindexedReferenceSegment;
	}
	
	public ParserRule getUnindexedReferenceSegmentRule() {
		return getUnindexedReferenceSegmentAccess().getRule();
	}
	
	//QualifiedName returns ecore::EString:
	//    ID ('::' ID)*
	//;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//Reference:
	//    segments+=ReferenceSegment
	//    (tails+=ReferenceTail)*
	//;
	public ReferenceElements getReferenceAccess() {
		return pReference;
	}
	
	public ParserRule getReferenceRule() {
		return getReferenceAccess().getRule();
	}
	
	//ReferenceTail:
	//    separator=ReferenceSeparator segment=ReferenceSegment
	//;
	public ReferenceTailElements getReferenceTailAccess() {
		return pReferenceTail;
	}
	
	public ParserRule getReferenceTailRule() {
		return getReferenceTailAccess().getRule();
	}
	
	//ReferenceSeparator returns ecore::EString:
	//    '::' | '.'
	//;
	public ReferenceSeparatorElements getReferenceSeparatorAccess() {
		return pReferenceSeparator;
	}
	
	public ParserRule getReferenceSeparatorRule() {
		return getReferenceSeparatorAccess().getRule();
	}
	
	//ReferenceSegment:
	//    name=ID indexes+=ArrayIndex*
	//;
	public ReferenceSegmentElements getReferenceSegmentAccess() {
		return pReferenceSegment;
	}
	
	public ParserRule getReferenceSegmentRule() {
		return getReferenceSegmentAccess().getRule();
	}
	
	//ArrayIndex:
	//    '[' value=IntegerValue ']'
	//;
	public ArrayIndexElements getArrayIndexAccess() {
		return pArrayIndex;
	}
	
	public ParserRule getArrayIndexRule() {
		return getArrayIndexAccess().getRule();
	}
	
	//PModel returns aadl2::Element:
	//    ContainedPropertyAssociation //| BasicPropertyAssociation | PropertyAssociation
	//    ;
	public PropertiesGrammarAccess.PModelElements getPModelAccess() {
		return gaProperties.getPModelAccess();
	}
	
	public ParserRule getPModelRule() {
		return getPModelAccess().getRule();
	}
	
	//// Properties
	//ContainedPropertyAssociation returns aadl2::PropertyAssociation:
	//    property=[aadl2::Property|QPREF]
	//    ('=>' | append?='+=>') (constant?='constant')?
	//    (
	//     ownedValue+=OptionalModalPropertyValue
	//    ( ',' ownedValue+=OptionalModalPropertyValue )*
	//    )
	//    ('applies' 'to' appliesTo+=ContainmentPath
	//        (',' appliesTo+=ContainmentPath)*
	//    )?
	//    ('in' 'binding' '(' inBinding+=[aadl2::Classifier|QCREF]')')?
	//    ';';
	public PropertiesGrammarAccess.ContainedPropertyAssociationElements getContainedPropertyAssociationAccess() {
		return gaProperties.getContainedPropertyAssociationAccess();
	}
	
	public ParserRule getContainedPropertyAssociationRule() {
		return getContainedPropertyAssociationAccess().getRule();
	}
	
	//PropertyAssociation returns aadl2::PropertyAssociation:
	//    property=[aadl2::Property|QPREF]
	//    ('=>' | append?='+=>') (constant?='constant')?
	//    (
	//     ownedValue+=OptionalModalPropertyValue
	//    ( ',' ownedValue+=OptionalModalPropertyValue )*
	//    )
	//    ('in' 'binding' '(' inBinding+=[aadl2::Classifier|QCREF]')')?
	//    ';'
	//    ;
	public PropertiesGrammarAccess.PropertyAssociationElements getPropertyAssociationAccess() {
		return gaProperties.getPropertyAssociationAccess();
	}
	
	public ParserRule getPropertyAssociationRule() {
		return getPropertyAssociationAccess().getRule();
	}
	
	//BasicPropertyAssociation returns aadl2::PropertyAssociation:
	//    property=[aadl2::Property|QPREF]
	//    '=>' ownedValue+=PropertyValue ';'
	//    ;
	public PropertiesGrammarAccess.BasicPropertyAssociationElements getBasicPropertyAssociationAccess() {
		return gaProperties.getBasicPropertyAssociationAccess();
	}
	
	public ParserRule getBasicPropertyAssociationRule() {
		return getBasicPropertyAssociationAccess().getRule();
	}
	
	//ContainmentPath returns aadl2::ContainedNamedElement:
	//    path=ContainmentPathElement
	////    ( 'annex' containmentPathElement+=AnnexPath )?
	//;
	public PropertiesGrammarAccess.ContainmentPathElements getContainmentPathAccess() {
		return gaProperties.getContainmentPathAccess();
	}
	
	public ParserRule getContainmentPathRule() {
		return getContainmentPathAccess().getRule();
	}
	
	////AnnexPath returns aadl2::ContainmentPathElement:
	////     namedElement=[aadl2::NamedElement|IDANNEXTEXT];
	//ModalPropertyValue returns aadl2::ModalPropertyValue:
	//    ownedValue=PropertyExpression
	//    'in' 'modes' '('
	//    inMode+=[aadl2::Mode|ID] (',' inMode+=[aadl2::Mode|ID])*
	//    ')'
	//    ;
	public PropertiesGrammarAccess.ModalPropertyValueElements getModalPropertyValueAccess() {
		return gaProperties.getModalPropertyValueAccess();
	}
	
	public ParserRule getModalPropertyValueRule() {
		return getModalPropertyValueAccess().getRule();
	}
	
	//OptionalModalPropertyValue returns aadl2::ModalPropertyValue:
	//    ownedValue=PropertyExpression
	//    // phf made this optional: need to check separately that only the last one is optional
	//    ( 'in' 'modes' '('
	//    inMode+=[aadl2::Mode|ID] (',' inMode+=[aadl2::Mode|ID])*
	//    ')')?
	//    ;
	public PropertiesGrammarAccess.OptionalModalPropertyValueElements getOptionalModalPropertyValueAccess() {
		return gaProperties.getOptionalModalPropertyValueAccess();
	}
	
	public ParserRule getOptionalModalPropertyValueRule() {
		return getOptionalModalPropertyValueAccess().getRule();
	}
	
	//    // &&&&&&&&&& handling of in binding
	//PropertyValue returns aadl2::ModalPropertyValue:
	//    ownedValue=PropertyExpression
	//    ;
	public PropertiesGrammarAccess.PropertyValueElements getPropertyValueAccess() {
		return gaProperties.getPropertyValueAccess();
	}
	
	public ParserRule getPropertyValueRule() {
		return getPropertyValueAccess().getRule();
	}
	
	//PropertyExpression returns aadl2::PropertyExpression:
	////    OldRecordTerm |
	//      RecordTerm | ReferenceTerm | ComponentClassifierTerm
	//     | ComputedTerm | StringTerm |  NumericRangeTerm
	//    | RealTerm | IntegerTerm
	//          | ListTerm
	//          | BooleanLiteral | LiteralorReferenceTerm
	//    ;
	public PropertiesGrammarAccess.PropertyExpressionElements getPropertyExpressionAccess() {
		return gaProperties.getPropertyExpressionAccess();
	}
	
	public ParserRule getPropertyExpressionRule() {
		return getPropertyExpressionAccess().getRule();
	}
	
	//LiteralorReferenceTerm returns aadl2::NamedValue:
	//  namedValue=[aadl2::AbstractNamedValue|QPREF]
	//;
	public PropertiesGrammarAccess.LiteralorReferenceTermElements getLiteralorReferenceTermAccess() {
		return gaProperties.getLiteralorReferenceTermAccess();
	}
	
	public ParserRule getLiteralorReferenceTermRule() {
		return getLiteralorReferenceTermAccess().getRule();
	}
	
	//BooleanLiteral returns aadl2::BooleanLiteral:
	//  {aadl2::BooleanLiteral}(value?='true'|'false')
	//  ;
	public PropertiesGrammarAccess.BooleanLiteralElements getBooleanLiteralAccess() {
		return gaProperties.getBooleanLiteralAccess();
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}
	
	//ConstantValue returns aadl2::NamedValue:
	//  namedValue=[aadl2::PropertyConstant|QPREF]
	//  ;
	public PropertiesGrammarAccess.ConstantValueElements getConstantValueAccess() {
		return gaProperties.getConstantValueAccess();
	}
	
	public ParserRule getConstantValueRule() {
		return getConstantValueAccess().getRule();
	}
	
	//ReferenceTerm returns aadl2::ReferenceValue:
	//  'reference' '('
	//  path=ContainmentPathElement
	////    ( 'annex' ID '{**'
	////    containmentPathElement+=ContainmentPathElement
	////    ( '.' containmentPathElement+=ContainmentPathElement)*
	////    '**}')?
	//  ')'
	//  ;
	public PropertiesGrammarAccess.ReferenceTermElements getReferenceTermAccess() {
		return gaProperties.getReferenceTermAccess();
	}
	
	public ParserRule getReferenceTermRule() {
		return getReferenceTermAccess().getRule();
	}
	
	//RecordTerm returns aadl2::RecordValue:
	//   '['
	//   (ownedFieldValue+=FieldPropertyAssociation)+
	//  ']'
	//  ;
	public PropertiesGrammarAccess.RecordTermElements getRecordTermAccess() {
		return gaProperties.getRecordTermAccess();
	}
	
	public ParserRule getRecordTermRule() {
		return getRecordTermAccess().getRule();
	}
	
	//OldRecordTerm returns aadl2::RecordValue:
	//   '('
	//   (ownedFieldValue+=FieldPropertyAssociation)+
	//  ')'
	//  ;
	public PropertiesGrammarAccess.OldRecordTermElements getOldRecordTermAccess() {
		return gaProperties.getOldRecordTermAccess();
	}
	
	public ParserRule getOldRecordTermRule() {
		return getOldRecordTermAccess().getRule();
	}
	
	//ComputedTerm returns aadl2::ComputedValue:
	//   'compute' '('
	//   function=ID
	//  ')'
	//  ;
	public PropertiesGrammarAccess.ComputedTermElements getComputedTermAccess() {
		return gaProperties.getComputedTermAccess();
	}
	
	public ParserRule getComputedTermRule() {
		return getComputedTermAccess().getRule();
	}
	
	//ComponentClassifierTerm returns aadl2::ClassifierValue:
	//   'classifier' '('
	//   classifier=[aadl2::ComponentClassifier|QCREF]
	//  ')'
	//  ;
	public PropertiesGrammarAccess.ComponentClassifierTermElements getComponentClassifierTermAccess() {
		return gaProperties.getComponentClassifierTermAccess();
	}
	
	public ParserRule getComponentClassifierTermRule() {
		return getComponentClassifierTermAccess().getRule();
	}
	
	//ListTerm returns aadl2::ListValue:
	//    {aadl2::ListValue}
	//   '('
	//   (ownedListElement+=(PropertyExpression)
	//   (',' ownedListElement+=(PropertyExpression))*)?
	//  ')'
	//  ;
	public PropertiesGrammarAccess.ListTermElements getListTermAccess() {
		return gaProperties.getListTermAccess();
	}
	
	public ParserRule getListTermRule() {
		return getListTermAccess().getRule();
	}
	
	//FieldPropertyAssociation returns aadl2::BasicPropertyAssociation:
	//    property=[aadl2::BasicProperty|ID]
	//    '=>'
	//    ownedValue=PropertyExpression
	//    ';';
	public PropertiesGrammarAccess.FieldPropertyAssociationElements getFieldPropertyAssociationAccess() {
		return gaProperties.getFieldPropertyAssociationAccess();
	}
	
	public ParserRule getFieldPropertyAssociationRule() {
		return getFieldPropertyAssociationAccess().getRule();
	}
	
	//// from AADL2
	//// need to add annex path element
	//ContainmentPathElement returns aadl2::ContainmentPathElement:
	//    (
	//        (
	//            namedElement=[aadl2::NamedElement|ID]
	//             (arrayRange+=ArrayRange)*
	//        )
	//        ('.' path=ContainmentPathElement)?
	////     |      'annex' namedElement=[aadl2::NamedElement|ID]
	//    )
	//;
	public PropertiesGrammarAccess.ContainmentPathElementElements getContainmentPathElementAccess() {
		return gaProperties.getContainmentPathElementAccess();
	}
	
	public ParserRule getContainmentPathElementRule() {
		return getContainmentPathElementAccess().getRule();
	}
	
	//ANNEXREF :
	//    // check what values are ok inside ** **
	//    '{' STAR STAR ID STAR STAR '}';
	public PropertiesGrammarAccess.ANNEXREFElements getANNEXREFAccess() {
		return gaProperties.getANNEXREFAccess();
	}
	
	public ParserRule getANNEXREFRule() {
		return getANNEXREFAccess().getRule();
	}
	
	//PlusMinus returns aadl2::OperationKind: '+' | '-';
	public PropertiesGrammarAccess.PlusMinusElements getPlusMinusAccess() {
		return gaProperties.getPlusMinusAccess();
	}
	
	public ParserRule getPlusMinusRule() {
		return getPlusMinusAccess().getRule();
	}
	
	//StringTerm returns aadl2::StringLiteral:
	//    value=NoQuoteString ;
	public PropertiesGrammarAccess.StringTermElements getStringTermAccess() {
		return gaProperties.getStringTermAccess();
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}
	
	//NoQuoteString :
	//    // remove quotes from string in ValueConverter
	//    STRING
	//;
	public PropertiesGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaProperties.getNoQuoteStringAccess();
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}
	
	//ArrayRange returns aadl2::ArrayRange: {aadl2::ArrayRange}
	//    '[' lowerBound=INTVALUE ('..' upperBound=INTVALUE)?
	//    ']'
	//;
	public PropertiesGrammarAccess.ArrayRangeElements getArrayRangeAccess() {
		return gaProperties.getArrayRangeAccess();
	}
	
	public ParserRule getArrayRangeRule() {
		return getArrayRangeAccess().getRule();
	}
	
	//SignedConstant returns aadl2::Operation:
	//    op=PlusMinus ownedPropertyExpression+=ConstantValue
	//    ;
	public PropertiesGrammarAccess.SignedConstantElements getSignedConstantAccess() {
		return gaProperties.getSignedConstantAccess();
	}
	
	public ParserRule getSignedConstantRule() {
		return getSignedConstantAccess().getRule();
	}
	
	//IntegerTerm returns aadl2::IntegerLiteral:
	//    value=SignedInt (unit=[aadl2::UnitLiteral|ID])?
	//    ;
	public PropertiesGrammarAccess.IntegerTermElements getIntegerTermAccess() {
		return gaProperties.getIntegerTermAccess();
	}
	
	public ParserRule getIntegerTermRule() {
		return getIntegerTermAccess().getRule();
	}
	
	//SignedInt returns aadl2::Integer:
	//    ('+'|'-')?INTEGER_LIT ;
	public PropertiesGrammarAccess.SignedIntElements getSignedIntAccess() {
		return gaProperties.getSignedIntAccess();
	}
	
	public ParserRule getSignedIntRule() {
		return getSignedIntAccess().getRule();
	}
	
	//RealTerm returns aadl2::RealLiteral:
	//    value=SignedReal (unit=[aadl2::UnitLiteral|ID])?
	//    ;
	public PropertiesGrammarAccess.RealTermElements getRealTermAccess() {
		return gaProperties.getRealTermAccess();
	}
	
	public ParserRule getRealTermRule() {
		return getRealTermAccess().getRule();
	}
	
	//SignedReal returns aadl2::Real:
	//    ('+'|'-')?REAL_LIT ;
	public PropertiesGrammarAccess.SignedRealElements getSignedRealAccess() {
		return gaProperties.getSignedRealAccess();
	}
	
	public ParserRule getSignedRealRule() {
		return getSignedRealAccess().getRule();
	}
	
	//NumericRangeTerm returns aadl2::RangeValue:
	//    minimum=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//        '..' maximum=NumAlt//(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//    ( 'delta' delta=NumAlt//(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//    )?
	//    ;
	public PropertiesGrammarAccess.NumericRangeTermElements getNumericRangeTermAccess() {
		return gaProperties.getNumericRangeTermAccess();
	}
	
	public ParserRule getNumericRangeTermRule() {
		return getNumericRangeTermAccess().getRule();
	}
	
	//NumAlt  returns aadl2::PropertyExpression:
	//    RealTerm|IntegerTerm| SignedConstant | ConstantValue
	//;
	public PropertiesGrammarAccess.NumAltElements getNumAltAccess() {
		return gaProperties.getNumAltAccess();
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}
	
	//terminal SL_COMMENT:
	//    '--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaProperties.getSL_COMMENTRule();
	}
	
	//INTVALUE returns aadl2::Integer:
	//    INTEGER_LIT //NUMERAL
	//;
	public PropertiesGrammarAccess.INTVALUEElements getINTVALUEAccess() {
		return gaProperties.getINTVALUEAccess();
	}
	
	public ParserRule getINTVALUERule() {
		return getINTVALUEAccess().getRule();
	}
	
	////terminal NUMERAL:
	////    (DIGIT)+('_' (DIGIT)+)*
	////;
	////terminal INT returns ecore::EInt: (DIGIT)+('_' (DIGIT)+)*;
	//terminal fragment
	//EXPONENT  :  ('e'|'E') ('+'|'-')? ( DIGIT )+  ;
	public TerminalRule getEXPONENTRule() {
		return gaProperties.getEXPONENTRule();
	}
	
	//terminal fragment
	//INT_EXPONENT :  ('e'|'E') ('+')? ( DIGIT )+ ;
	public TerminalRule getINT_EXPONENTRule() {
		return gaProperties.getINT_EXPONENTRule();
	}
	
	//terminal REAL_LIT :
	//    (DIGIT)+('_' (DIGIT)+)* ( '.' (DIGIT)+('_' (DIGIT)+)* ( EXPONENT )?)
	//  ;
	public TerminalRule getREAL_LITRule() {
		return gaProperties.getREAL_LITRule();
	}
	
	//terminal INTEGER_LIT :
	//        (DIGIT)+('_' (DIGIT)+)*
	//        (( '#' BASED_INTEGER  '#' ( INT_EXPONENT )? )
	//            | (INT_EXPONENT)?
	//        )
	//  ;
	public TerminalRule getINTEGER_LITRule() {
		return gaProperties.getINTEGER_LITRule();
	}
	
	//terminal fragment
	//DIGIT     :  ( '0'..'9' ) ;
	public TerminalRule getDIGITRule() {
		return gaProperties.getDIGITRule();
	}
	
	//terminal fragment
	//EXTENDED_DIGIT     :  ( '0'..'9' | 'a'..'f' | 'A'..'F') ;
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaProperties.getEXTENDED_DIGITRule();
	}
	
	//terminal fragment
	//BASED_INTEGER      :  ( EXTENDED_DIGIT ) ( ('_')? EXTENDED_DIGIT )* ;
	public TerminalRule getBASED_INTEGERRule() {
		return gaProperties.getBASED_INTEGERRule();
	}
	
	//QCLREF:
	//    ID '::' ID;
	public PropertiesGrammarAccess.QCLREFElements getQCLREFAccess() {
		return gaProperties.getQCLREFAccess();
	}
	
	public ParserRule getQCLREFRule() {
		return getQCLREFAccess().getRule();
	}
	
	//QPREF:
	//    ID ('::' ID)?;
	public PropertiesGrammarAccess.QPREFElements getQPREFAccess() {
		return gaProperties.getQPREFAccess();
	}
	
	public ParserRule getQPREFRule() {
		return getQPREFAccess().getRule();
	}
	
	//QCREF:
	//    (ID '::')* ID ('.' ID)?;
	public PropertiesGrammarAccess.QCREFElements getQCREFAccess() {
		return gaProperties.getQCREFAccess();
	}
	
	public ParserRule getQCREFRule() {
		return getQCREFAccess().getRule();
	}
	
	//STAR : '*';
	public PropertiesGrammarAccess.STARElements getSTARAccess() {
		return gaProperties.getSTARAccess();
	}
	
	public ParserRule getSTARRule() {
		return getSTARAccess().getRule();
	}
	
	//terminal STRING:
	//    '"' ('""' | !'"')* '"'
	//;
	public TerminalRule getSTRINGRule() {
		return gaProperties.getSTRINGRule();
	}
	
	////terminal ID          : '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	//terminal ID:    ('a'..'z'
	//        |'A'..'Z'
	//        ) ( ('_')? ('a'..'z'
	//        |'A'..'Z'
	//        |'0'..'9'))*;
	public TerminalRule getIDRule() {
		return gaProperties.getIDRule();
	}
	
	//terminal WS			: (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaProperties.getWSRule();
	}
}
