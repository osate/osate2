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
package org.osate.xtext.aadl2.properties.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class PropertiesGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class PModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.PModel");
		private final RuleCall cContainedPropertyAssociationParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//PModel aadl2::Element:
		//	ContainedPropertyAssociation //| BasicPropertyAssociation | PropertyAssociation
		//;
		@Override public ParserRule getRule() { return rule; }

		//ContainedPropertyAssociation
		public RuleCall getContainedPropertyAssociationParserRuleCall() { return cContainedPropertyAssociationParserRuleCall; }
	}

	public class ContainedPropertyAssociationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ContainedPropertyAssociation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyPropertyQPREFParserRuleCall_0_0_1 = (RuleCall)cPropertyPropertyCrossReference_0_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cAppendAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0 = (Keyword)cAppendAssignment_1_1.eContents().get(0);
		private final Assignment cConstantAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cConstantConstantKeyword_2_0 = (Keyword)cConstantAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cOwnedValueAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0 = (RuleCall)cOwnedValueAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cOwnedValueAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0 = (RuleCall)cOwnedValueAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final RuleCall cAppliesToKeywordsParserRuleCall_4_0 = (RuleCall)cGroup_4.eContents().get(0);
		private final Assignment cAppliesToAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cAppliesToContainmentPathParserRuleCall_4_1_0 = (RuleCall)cAppliesToAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cAppliesToAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cAppliesToContainmentPathParserRuleCall_4_2_1_0 = (RuleCall)cAppliesToAssignment_4_2_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final RuleCall cInBindingKeywordsParserRuleCall_5_0 = (RuleCall)cGroup_5.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_5_1 = (Keyword)cGroup_5.eContents().get(1);
		private final Assignment cInBindingAssignment_5_2 = (Assignment)cGroup_5.eContents().get(2);
		private final CrossReference cInBindingClassifierCrossReference_5_2_0 = (CrossReference)cInBindingAssignment_5_2.eContents().get(0);
		private final RuleCall cInBindingClassifierQCREFParserRuleCall_5_2_0_1 = (RuleCall)cInBindingClassifierCrossReference_5_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5_3 = (Keyword)cGroup_5.eContents().get(3);
		private final Keyword cSemicolonKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//// Properties
		//ContainedPropertyAssociation aadl2::PropertyAssociation:
		//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
		//	(',' ownedValue+=OptionalModalPropertyValue)*) (AppliesToKeywords appliesTo+=ContainmentPath (','
		//	appliesTo+=ContainmentPath)*)? (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
		//	';';
		@Override public ParserRule getRule() { return rule; }

		//property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
		//(',' ownedValue+=OptionalModalPropertyValue)*) (AppliesToKeywords appliesTo+=ContainmentPath (','
		//appliesTo+=ContainmentPath)*)? (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')? ';'
		public Group getGroup() { return cGroup; }

		//property=[aadl2::Property|QPREF]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }

		//[aadl2::Property|QPREF]
		public CrossReference getPropertyPropertyCrossReference_0_0() { return cPropertyPropertyCrossReference_0_0; }

		//QPREF
		public RuleCall getPropertyPropertyQPREFParserRuleCall_0_0_1() { return cPropertyPropertyQPREFParserRuleCall_0_0_1; }

		//'=>' | append?='+=>'
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1_0() { return cEqualsSignGreaterThanSignKeyword_1_0; }

		//append?='+=>'
		public Assignment getAppendAssignment_1_1() { return cAppendAssignment_1_1; }

		//'+=>'
		public Keyword getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0() { return cAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0; }

		//constant?='constant'?
		public Assignment getConstantAssignment_2() { return cConstantAssignment_2; }

		//'constant'
		public Keyword getConstantConstantKeyword_2_0() { return cConstantConstantKeyword_2_0; }

		//ownedValue+=OptionalModalPropertyValue (',' ownedValue+=OptionalModalPropertyValue)*
		public Group getGroup_3() { return cGroup_3; }

		//ownedValue+=OptionalModalPropertyValue
		public Assignment getOwnedValueAssignment_3_0() { return cOwnedValueAssignment_3_0; }

		//OptionalModalPropertyValue
		public RuleCall getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0() { return cOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0; }

		//(',' ownedValue+=OptionalModalPropertyValue)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//ownedValue+=OptionalModalPropertyValue
		public Assignment getOwnedValueAssignment_3_1_1() { return cOwnedValueAssignment_3_1_1; }

		//OptionalModalPropertyValue
		public RuleCall getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0() { return cOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0; }

		//(AppliesToKeywords appliesTo+=ContainmentPath (',' appliesTo+=ContainmentPath)*)?
		public Group getGroup_4() { return cGroup_4; }

		//AppliesToKeywords
		public RuleCall getAppliesToKeywordsParserRuleCall_4_0() { return cAppliesToKeywordsParserRuleCall_4_0; }

		//appliesTo+=ContainmentPath
		public Assignment getAppliesToAssignment_4_1() { return cAppliesToAssignment_4_1; }

		//ContainmentPath
		public RuleCall getAppliesToContainmentPathParserRuleCall_4_1_0() { return cAppliesToContainmentPathParserRuleCall_4_1_0; }

		//(',' appliesTo+=ContainmentPath)*
		public Group getGroup_4_2() { return cGroup_4_2; }

		//','
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//appliesTo+=ContainmentPath
		public Assignment getAppliesToAssignment_4_2_1() { return cAppliesToAssignment_4_2_1; }

		//ContainmentPath
		public RuleCall getAppliesToContainmentPathParserRuleCall_4_2_1_0() { return cAppliesToContainmentPathParserRuleCall_4_2_1_0; }

		//(InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
		public Group getGroup_5() { return cGroup_5; }

		//InBindingKeywords
		public RuleCall getInBindingKeywordsParserRuleCall_5_0() { return cInBindingKeywordsParserRuleCall_5_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_5_1() { return cLeftParenthesisKeyword_5_1; }

		//inBinding+=[aadl2::Classifier|QCREF]
		public Assignment getInBindingAssignment_5_2() { return cInBindingAssignment_5_2; }

		//[aadl2::Classifier|QCREF]
		public CrossReference getInBindingClassifierCrossReference_5_2_0() { return cInBindingClassifierCrossReference_5_2_0; }

		//QCREF
		public RuleCall getInBindingClassifierQCREFParserRuleCall_5_2_0_1() { return cInBindingClassifierQCREFParserRuleCall_5_2_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_5_3() { return cRightParenthesisKeyword_5_3; }

		//';'
		public Keyword getSemicolonKeyword_6() { return cSemicolonKeyword_6; }
	}

	public class PropertyAssociationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.PropertyAssociation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyPropertyQPREFParserRuleCall_0_0_1 = (RuleCall)cPropertyPropertyCrossReference_0_0.eContents().get(1);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1_0 = (Keyword)cAlternatives_1.eContents().get(0);
		private final Assignment cAppendAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0 = (Keyword)cAppendAssignment_1_1.eContents().get(0);
		private final Assignment cConstantAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final Keyword cConstantConstantKeyword_2_0 = (Keyword)cConstantAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cOwnedValueAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0 = (RuleCall)cOwnedValueAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cOwnedValueAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0 = (RuleCall)cOwnedValueAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final RuleCall cInBindingKeywordsParserRuleCall_4_0 = (RuleCall)cGroup_4.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Assignment cInBindingAssignment_4_2 = (Assignment)cGroup_4.eContents().get(2);
		private final CrossReference cInBindingClassifierCrossReference_4_2_0 = (CrossReference)cInBindingAssignment_4_2.eContents().get(0);
		private final RuleCall cInBindingClassifierQCREFParserRuleCall_4_2_0_1 = (RuleCall)cInBindingClassifierCrossReference_4_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Keyword cSemicolonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//PropertyAssociation aadl2::PropertyAssociation:
		//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
		//	(',' ownedValue+=OptionalModalPropertyValue)*) (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
		//	';';
		@Override public ParserRule getRule() { return rule; }

		//property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
		//(',' ownedValue+=OptionalModalPropertyValue)*) (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')? ';'
		public Group getGroup() { return cGroup; }

		//property=[aadl2::Property|QPREF]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }

		//[aadl2::Property|QPREF]
		public CrossReference getPropertyPropertyCrossReference_0_0() { return cPropertyPropertyCrossReference_0_0; }

		//QPREF
		public RuleCall getPropertyPropertyQPREFParserRuleCall_0_0_1() { return cPropertyPropertyQPREFParserRuleCall_0_0_1; }

		//'=>' | append?='+=>'
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1_0() { return cEqualsSignGreaterThanSignKeyword_1_0; }

		//append?='+=>'
		public Assignment getAppendAssignment_1_1() { return cAppendAssignment_1_1; }

		//'+=>'
		public Keyword getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0() { return cAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0; }

		//constant?='constant'?
		public Assignment getConstantAssignment_2() { return cConstantAssignment_2; }

		//'constant'
		public Keyword getConstantConstantKeyword_2_0() { return cConstantConstantKeyword_2_0; }

		//ownedValue+=OptionalModalPropertyValue (',' ownedValue+=OptionalModalPropertyValue)*
		public Group getGroup_3() { return cGroup_3; }

		//ownedValue+=OptionalModalPropertyValue
		public Assignment getOwnedValueAssignment_3_0() { return cOwnedValueAssignment_3_0; }

		//OptionalModalPropertyValue
		public RuleCall getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0() { return cOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0; }

		//(',' ownedValue+=OptionalModalPropertyValue)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//ownedValue+=OptionalModalPropertyValue
		public Assignment getOwnedValueAssignment_3_1_1() { return cOwnedValueAssignment_3_1_1; }

		//OptionalModalPropertyValue
		public RuleCall getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0() { return cOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0; }

		//(InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
		public Group getGroup_4() { return cGroup_4; }

		//InBindingKeywords
		public RuleCall getInBindingKeywordsParserRuleCall_4_0() { return cInBindingKeywordsParserRuleCall_4_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_4_1() { return cLeftParenthesisKeyword_4_1; }

		//inBinding+=[aadl2::Classifier|QCREF]
		public Assignment getInBindingAssignment_4_2() { return cInBindingAssignment_4_2; }

		//[aadl2::Classifier|QCREF]
		public CrossReference getInBindingClassifierCrossReference_4_2_0() { return cInBindingClassifierCrossReference_4_2_0; }

		//QCREF
		public RuleCall getInBindingClassifierQCREFParserRuleCall_4_2_0_1() { return cInBindingClassifierQCREFParserRuleCall_4_2_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_4_3() { return cRightParenthesisKeyword_4_3; }

		//';'
		public Keyword getSemicolonKeyword_5() { return cSemicolonKeyword_5; }
	}

	public class BasicPropertyAssociationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.BasicPropertyAssociation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyPropertyQPREFParserRuleCall_0_0_1 = (RuleCall)cPropertyPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedValuePropertyValueParserRuleCall_2_0 = (RuleCall)cOwnedValueAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//BasicPropertyAssociation aadl2::PropertyAssociation:
		//	property=[aadl2::Property|QPREF]
		//	'=>' ownedValue+=PropertyValue ';';
		@Override public ParserRule getRule() { return rule; }

		//property=[aadl2::Property|QPREF] '=>' ownedValue+=PropertyValue ';'
		public Group getGroup() { return cGroup; }

		//property=[aadl2::Property|QPREF]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }

		//[aadl2::Property|QPREF]
		public CrossReference getPropertyPropertyCrossReference_0_0() { return cPropertyPropertyCrossReference_0_0; }

		//QPREF
		public RuleCall getPropertyPropertyQPREFParserRuleCall_0_0_1() { return cPropertyPropertyQPREFParserRuleCall_0_0_1; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }

		//ownedValue+=PropertyValue
		public Assignment getOwnedValueAssignment_2() { return cOwnedValueAssignment_2; }

		//PropertyValue
		public RuleCall getOwnedValuePropertyValueParserRuleCall_2_0() { return cOwnedValuePropertyValueParserRuleCall_2_0; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class ContainmentPathElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
		private final Assignment cPathAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cPathContainmentPathElementParserRuleCall_0 = (RuleCall)cPathAssignment.eContents().get(0);
		
		//ContainmentPath aadl2::ContainedNamedElement:
		//	path=ContainmentPathElement
		//	//	( 'annex' containmentPathElement+=AnnexPath )?
		//;
		@Override public ParserRule getRule() { return rule; }

		//path=ContainmentPathElement
		public Assignment getPathAssignment() { return cPathAssignment; }

		//ContainmentPathElement
		public RuleCall getPathContainmentPathElementParserRuleCall_0() { return cPathContainmentPathElementParserRuleCall_0; }
	}

	public class ModalPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ModalPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedValuePropertyExpressionParserRuleCall_0_0 = (RuleCall)cOwnedValueAssignment_0.eContents().get(0);
		private final RuleCall cInModesKeywordsParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cInModeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cInModeModeCrossReference_3_0 = (CrossReference)cInModeAssignment_3.eContents().get(0);
		private final RuleCall cInModeModeIDTerminalRuleCall_3_0_1 = (RuleCall)cInModeModeCrossReference_3_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cInModeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cInModeModeCrossReference_4_1_0 = (CrossReference)cInModeAssignment_4_1.eContents().get(0);
		private final RuleCall cInModeModeIDTerminalRuleCall_4_1_0_1 = (RuleCall)cInModeModeCrossReference_4_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		////AnnexPath returns aadl2::ContainmentPathElement:
		////	 namedElement=[aadl2::NamedElement|IDANNEXTEXT];
		//ModalPropertyValue aadl2::ModalPropertyValue:
		//	ownedValue=PropertyExpression
		//	InModesKeywords '('
		//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
		//	')';
		@Override public ParserRule getRule() { return rule; }

		//ownedValue=PropertyExpression InModesKeywords '(' inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])* ')'
		public Group getGroup() { return cGroup; }

		//ownedValue=PropertyExpression
		public Assignment getOwnedValueAssignment_0() { return cOwnedValueAssignment_0; }

		//PropertyExpression
		public RuleCall getOwnedValuePropertyExpressionParserRuleCall_0_0() { return cOwnedValuePropertyExpressionParserRuleCall_0_0; }

		//InModesKeywords
		public RuleCall getInModesKeywordsParserRuleCall_1() { return cInModesKeywordsParserRuleCall_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//inMode+=[aadl2::Mode]
		public Assignment getInModeAssignment_3() { return cInModeAssignment_3; }

		//[aadl2::Mode]
		public CrossReference getInModeModeCrossReference_3_0() { return cInModeModeCrossReference_3_0; }

		//ID
		public RuleCall getInModeModeIDTerminalRuleCall_3_0_1() { return cInModeModeIDTerminalRuleCall_3_0_1; }

		//(',' inMode+=[aadl2::Mode])*
		public Group getGroup_4() { return cGroup_4; }

		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//inMode+=[aadl2::Mode]
		public Assignment getInModeAssignment_4_1() { return cInModeAssignment_4_1; }

		//[aadl2::Mode]
		public CrossReference getInModeModeCrossReference_4_1_0() { return cInModeModeCrossReference_4_1_0; }

		//ID
		public RuleCall getInModeModeIDTerminalRuleCall_4_1_0_1() { return cInModeModeIDTerminalRuleCall_4_1_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}

	public class OptionalModalPropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.OptionalModalPropertyValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOwnedValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOwnedValuePropertyExpressionParserRuleCall_0_0 = (RuleCall)cOwnedValueAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final RuleCall cInModesKeywordsParserRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cInModeAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cInModeModeCrossReference_1_2_0 = (CrossReference)cInModeAssignment_1_2.eContents().get(0);
		private final RuleCall cInModeModeIDTerminalRuleCall_1_2_0_1 = (RuleCall)cInModeModeCrossReference_1_2_0.eContents().get(1);
		private final Group cGroup_1_3 = (Group)cGroup_1.eContents().get(3);
		private final Keyword cCommaKeyword_1_3_0 = (Keyword)cGroup_1_3.eContents().get(0);
		private final Assignment cInModeAssignment_1_3_1 = (Assignment)cGroup_1_3.eContents().get(1);
		private final CrossReference cInModeModeCrossReference_1_3_1_0 = (CrossReference)cInModeAssignment_1_3_1.eContents().get(0);
		private final RuleCall cInModeModeIDTerminalRuleCall_1_3_1_0_1 = (RuleCall)cInModeModeCrossReference_1_3_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_1_4 = (Keyword)cGroup_1.eContents().get(4);
		
		//OptionalModalPropertyValue aadl2::ModalPropertyValue:
		//	ownedValue=PropertyExpression (InModesKeywords '('
		//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
		//	')')?;
		@Override public ParserRule getRule() { return rule; }

		//ownedValue=PropertyExpression (InModesKeywords '(' inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])* ')')?
		public Group getGroup() { return cGroup; }

		//ownedValue=PropertyExpression
		public Assignment getOwnedValueAssignment_0() { return cOwnedValueAssignment_0; }

		//PropertyExpression
		public RuleCall getOwnedValuePropertyExpressionParserRuleCall_0_0() { return cOwnedValuePropertyExpressionParserRuleCall_0_0; }

		//(InModesKeywords '(' inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])* ')')?
		public Group getGroup_1() { return cGroup_1; }

		//InModesKeywords
		public RuleCall getInModesKeywordsParserRuleCall_1_0() { return cInModesKeywordsParserRuleCall_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1_1() { return cLeftParenthesisKeyword_1_1; }

		//inMode+=[aadl2::Mode]
		public Assignment getInModeAssignment_1_2() { return cInModeAssignment_1_2; }

		//[aadl2::Mode]
		public CrossReference getInModeModeCrossReference_1_2_0() { return cInModeModeCrossReference_1_2_0; }

		//ID
		public RuleCall getInModeModeIDTerminalRuleCall_1_2_0_1() { return cInModeModeIDTerminalRuleCall_1_2_0_1; }

		//(',' inMode+=[aadl2::Mode])*
		public Group getGroup_1_3() { return cGroup_1_3; }

		//','
		public Keyword getCommaKeyword_1_3_0() { return cCommaKeyword_1_3_0; }

		//inMode+=[aadl2::Mode]
		public Assignment getInModeAssignment_1_3_1() { return cInModeAssignment_1_3_1; }

		//[aadl2::Mode]
		public CrossReference getInModeModeCrossReference_1_3_1_0() { return cInModeModeCrossReference_1_3_1_0; }

		//ID
		public RuleCall getInModeModeIDTerminalRuleCall_1_3_1_0_1() { return cInModeModeIDTerminalRuleCall_1_3_1_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_1_4() { return cRightParenthesisKeyword_1_4; }
	}

	public class PropertyValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.PropertyValue");
		private final Assignment cOwnedValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cOwnedValuePropertyExpressionParserRuleCall_0 = (RuleCall)cOwnedValueAssignment.eContents().get(0);
		
		//// &&&&&&&&&& handling of in binding
		//PropertyValue aadl2::ModalPropertyValue:
		//	ownedValue=PropertyExpression;
		@Override public ParserRule getRule() { return rule; }

		//ownedValue=PropertyExpression
		public Assignment getOwnedValueAssignment() { return cOwnedValueAssignment; }

		//PropertyExpression
		public RuleCall getOwnedValuePropertyExpressionParserRuleCall_0() { return cOwnedValuePropertyExpressionParserRuleCall_0; }
	}

	public class PropertyExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.PropertyExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRecordTermParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReferenceTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cComponentClassifierTermParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cComputedTermParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cStringTermParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cNumericRangeTermParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cRealTermParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cIntegerTermParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		private final RuleCall cListTermParserRuleCall_8 = (RuleCall)cAlternatives.eContents().get(8);
		private final RuleCall cBooleanLiteralParserRuleCall_9 = (RuleCall)cAlternatives.eContents().get(9);
		private final RuleCall cLiteralorReferenceTermParserRuleCall_10 = (RuleCall)cAlternatives.eContents().get(10);
		
		//PropertyExpression aadl2::PropertyExpression:
		//	RecordTerm | ReferenceTerm | ComponentClassifierTerm
		//	| ComputedTerm | StringTerm | NumericRangeTerm
		//	| RealTerm | IntegerTerm
		//	| ListTerm
		//	| BooleanLiteral | LiteralorReferenceTerm;
		@Override public ParserRule getRule() { return rule; }

		////	OldRecordTerm |
		//RecordTerm | ReferenceTerm | ComponentClassifierTerm | ComputedTerm | StringTerm | NumericRangeTerm | RealTerm |
		//IntegerTerm | ListTerm | BooleanLiteral | LiteralorReferenceTerm
		public Alternatives getAlternatives() { return cAlternatives; }

		////	OldRecordTerm |
		//RecordTerm
		public RuleCall getRecordTermParserRuleCall_0() { return cRecordTermParserRuleCall_0; }

		//ReferenceTerm
		public RuleCall getReferenceTermParserRuleCall_1() { return cReferenceTermParserRuleCall_1; }

		//ComponentClassifierTerm
		public RuleCall getComponentClassifierTermParserRuleCall_2() { return cComponentClassifierTermParserRuleCall_2; }

		//ComputedTerm
		public RuleCall getComputedTermParserRuleCall_3() { return cComputedTermParserRuleCall_3; }

		//StringTerm
		public RuleCall getStringTermParserRuleCall_4() { return cStringTermParserRuleCall_4; }

		//NumericRangeTerm
		public RuleCall getNumericRangeTermParserRuleCall_5() { return cNumericRangeTermParserRuleCall_5; }

		//RealTerm
		public RuleCall getRealTermParserRuleCall_6() { return cRealTermParserRuleCall_6; }

		//IntegerTerm
		public RuleCall getIntegerTermParserRuleCall_7() { return cIntegerTermParserRuleCall_7; }

		//ListTerm
		public RuleCall getListTermParserRuleCall_8() { return cListTermParserRuleCall_8; }

		//BooleanLiteral
		public RuleCall getBooleanLiteralParserRuleCall_9() { return cBooleanLiteralParserRuleCall_9; }

		//LiteralorReferenceTerm
		public RuleCall getLiteralorReferenceTermParserRuleCall_10() { return cLiteralorReferenceTermParserRuleCall_10; }
	}

	public class LiteralorReferenceTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.LiteralorReferenceTerm");
		private final Assignment cNamedValueAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cNamedValueAbstractNamedValueCrossReference_0 = (CrossReference)cNamedValueAssignment.eContents().get(0);
		private final RuleCall cNamedValueAbstractNamedValueQPREFParserRuleCall_0_1 = (RuleCall)cNamedValueAbstractNamedValueCrossReference_0.eContents().get(1);
		
		//LiteralorReferenceTerm aadl2::NamedValue:
		//	namedValue=[aadl2::AbstractNamedValue|QPREF];
		@Override public ParserRule getRule() { return rule; }

		//namedValue=[aadl2::AbstractNamedValue|QPREF]
		public Assignment getNamedValueAssignment() { return cNamedValueAssignment; }

		//[aadl2::AbstractNamedValue|QPREF]
		public CrossReference getNamedValueAbstractNamedValueCrossReference_0() { return cNamedValueAbstractNamedValueCrossReference_0; }

		//QPREF
		public RuleCall getNamedValueAbstractNamedValueQPREFParserRuleCall_0_1() { return cNamedValueAbstractNamedValueQPREFParserRuleCall_0_1; }
	}

	public class BooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.BooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cValueTrueKeyword_1_0_0 = (Keyword)cValueAssignment_1_0.eContents().get(0);
		private final Keyword cFalseKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		//BooleanLiteral aadl2::BooleanLiteral:
		//	{aadl2::BooleanLiteral} (value?='true' | 'false');
		@Override public ParserRule getRule() { return rule; }

		//{aadl2::BooleanLiteral} (value?='true' | 'false')
		public Group getGroup() { return cGroup; }

		//{aadl2::BooleanLiteral}
		public Action getBooleanLiteralAction_0() { return cBooleanLiteralAction_0; }

		//value?='true' | 'false'
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//value?='true'
		public Assignment getValueAssignment_1_0() { return cValueAssignment_1_0; }

		//'true'
		public Keyword getValueTrueKeyword_1_0_0() { return cValueTrueKeyword_1_0_0; }

		//'false'
		public Keyword getFalseKeyword_1_1() { return cFalseKeyword_1_1; }
	}

	public class ConstantValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ConstantValue");
		private final Assignment cNamedValueAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cNamedValuePropertyConstantCrossReference_0 = (CrossReference)cNamedValueAssignment.eContents().get(0);
		private final RuleCall cNamedValuePropertyConstantQPREFParserRuleCall_0_1 = (RuleCall)cNamedValuePropertyConstantCrossReference_0.eContents().get(1);
		
		//ConstantValue aadl2::NamedValue:
		//	namedValue=[aadl2::PropertyConstant|QPREF];
		@Override public ParserRule getRule() { return rule; }

		//namedValue=[aadl2::PropertyConstant|QPREF]
		public Assignment getNamedValueAssignment() { return cNamedValueAssignment; }

		//[aadl2::PropertyConstant|QPREF]
		public CrossReference getNamedValuePropertyConstantCrossReference_0() { return cNamedValuePropertyConstantCrossReference_0; }

		//QPREF
		public RuleCall getNamedValuePropertyConstantQPREFParserRuleCall_0_1() { return cNamedValuePropertyConstantQPREFParserRuleCall_0_1; }
	}

	public class ReferenceTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ReferenceTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReferenceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cPathAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cPathContainmentPathElementParserRuleCall_2_0 = (RuleCall)cPathAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ReferenceTerm aadl2::ReferenceValue:
		//	'reference' '('
		//	path=ContainmentPathElement
		//	//	( 'annex' ID '{**' 
		//	//	containmentPathElement+=ContainmentPathElement
		//	//	( '.' containmentPathElement+=ContainmentPathElement)*
		//	//	'**}')?
		//	')';
		@Override public ParserRule getRule() { return rule; }

		//'reference' '(' path=ContainmentPathElement //	( 'annex' ID '{**' 
		////	containmentPathElement+=ContainmentPathElement
		////	( '.' containmentPathElement+=ContainmentPathElement)*
		////	'**}')?
		//')'
		public Group getGroup() { return cGroup; }

		//'reference'
		public Keyword getReferenceKeyword_0() { return cReferenceKeyword_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//path=ContainmentPathElement
		public Assignment getPathAssignment_2() { return cPathAssignment_2; }

		//ContainmentPathElement
		public RuleCall getPathContainmentPathElementParserRuleCall_2_0() { return cPathContainmentPathElementParserRuleCall_2_0; }

		////	( 'annex' ID '{**' 
		////	containmentPathElement+=ContainmentPathElement
		////	( '.' containmentPathElement+=ContainmentPathElement)*
		////	'**}')?
		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class RecordTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.RecordTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedFieldValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0 = (RuleCall)cOwnedFieldValueAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//RecordTerm aadl2::RecordValue:
		//	'['
		//	ownedFieldValue+=FieldPropertyAssociation+
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'[' ownedFieldValue+=FieldPropertyAssociation+ ']'
		public Group getGroup() { return cGroup; }

		//'['
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//ownedFieldValue+=FieldPropertyAssociation+
		public Assignment getOwnedFieldValueAssignment_1() { return cOwnedFieldValueAssignment_1; }

		//FieldPropertyAssociation
		public RuleCall getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0() { return cOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}

	public class OldRecordTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.OldRecordTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cOwnedFieldValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0 = (RuleCall)cOwnedFieldValueAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//OldRecordTerm aadl2::RecordValue:
		//	'('
		//	ownedFieldValue+=FieldPropertyAssociation+
		//	')';
		@Override public ParserRule getRule() { return rule; }

		//'(' ownedFieldValue+=FieldPropertyAssociation+ ')'
		public Group getGroup() { return cGroup; }

		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//ownedFieldValue+=FieldPropertyAssociation+
		public Assignment getOwnedFieldValueAssignment_1() { return cOwnedFieldValueAssignment_1; }

		//FieldPropertyAssociation
		public RuleCall getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0() { return cOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}

	public class ComputedTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ComputedTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cComputeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cFunctionAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cFunctionIDTerminalRuleCall_2_0 = (RuleCall)cFunctionAssignment_2.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ComputedTerm aadl2::ComputedValue:
		//	'compute' '('
		//	function=ID
		//	')';
		@Override public ParserRule getRule() { return rule; }

		//'compute' '(' function=ID ')'
		public Group getGroup() { return cGroup; }

		//'compute'
		public Keyword getComputeKeyword_0() { return cComputeKeyword_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//function=ID
		public Assignment getFunctionAssignment_2() { return cFunctionAssignment_2; }

		//ID
		public RuleCall getFunctionIDTerminalRuleCall_2_0() { return cFunctionIDTerminalRuleCall_2_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class ComponentClassifierTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ComponentClassifierTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cClassifierKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cClassifierAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cClassifierComponentClassifierCrossReference_2_0 = (CrossReference)cClassifierAssignment_2.eContents().get(0);
		private final RuleCall cClassifierComponentClassifierQCREFParserRuleCall_2_0_1 = (RuleCall)cClassifierComponentClassifierCrossReference_2_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ComponentClassifierTerm aadl2::ClassifierValue:
		//	'classifier' '('
		//	classifier=[aadl2::ComponentClassifier|QCREF]
		//	')';
		@Override public ParserRule getRule() { return rule; }

		//'classifier' '(' classifier=[aadl2::ComponentClassifier|QCREF] ')'
		public Group getGroup() { return cGroup; }

		//'classifier'
		public Keyword getClassifierKeyword_0() { return cClassifierKeyword_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//classifier=[aadl2::ComponentClassifier|QCREF]
		public Assignment getClassifierAssignment_2() { return cClassifierAssignment_2; }

		//[aadl2::ComponentClassifier|QCREF]
		public CrossReference getClassifierComponentClassifierCrossReference_2_0() { return cClassifierComponentClassifierCrossReference_2_0; }

		//QCREF
		public RuleCall getClassifierComponentClassifierQCREFParserRuleCall_2_0_1() { return cClassifierComponentClassifierQCREFParserRuleCall_2_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class ListTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ListTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cListValueAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cOwnedListElementAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cOwnedListElementPropertyExpressionParserRuleCall_2_0_0 = (RuleCall)cOwnedListElementAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cOwnedListElementAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0 = (RuleCall)cOwnedListElementAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ListTerm aadl2::ListValue:
		//	{aadl2::ListValue}
		//	'(' (ownedListElement+=PropertyExpression (',' ownedListElement+=PropertyExpression)*)?
		//	')';
		@Override public ParserRule getRule() { return rule; }

		//{aadl2::ListValue} '(' (ownedListElement+=PropertyExpression (',' ownedListElement+=PropertyExpression)*)? ')'
		public Group getGroup() { return cGroup; }

		//{aadl2::ListValue}
		public Action getListValueAction_0() { return cListValueAction_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_1() { return cLeftParenthesisKeyword_1; }

		//(ownedListElement+=PropertyExpression (',' ownedListElement+=PropertyExpression)*)?
		public Group getGroup_2() { return cGroup_2; }

		//ownedListElement+=PropertyExpression
		public Assignment getOwnedListElementAssignment_2_0() { return cOwnedListElementAssignment_2_0; }

		//PropertyExpression
		public RuleCall getOwnedListElementPropertyExpressionParserRuleCall_2_0_0() { return cOwnedListElementPropertyExpressionParserRuleCall_2_0_0; }

		//(',' ownedListElement+=PropertyExpression)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//','
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//ownedListElement+=PropertyExpression
		public Assignment getOwnedListElementAssignment_2_1_1() { return cOwnedListElementAssignment_2_1_1; }

		//PropertyExpression
		public RuleCall getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0() { return cOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_3() { return cRightParenthesisKeyword_3; }
	}

	public class FieldPropertyAssociationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPropertyAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cPropertyBasicPropertyCrossReference_0_0 = (CrossReference)cPropertyAssignment_0.eContents().get(0);
		private final RuleCall cPropertyBasicPropertyIDTerminalRuleCall_0_0_1 = (RuleCall)cPropertyBasicPropertyCrossReference_0_0.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cOwnedValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cOwnedValuePropertyExpressionParserRuleCall_2_0 = (RuleCall)cOwnedValueAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//FieldPropertyAssociation aadl2::BasicPropertyAssociation:
		//	property=[aadl2::BasicProperty]
		//	'=>'
		//	ownedValue=PropertyExpression
		//	';';
		@Override public ParserRule getRule() { return rule; }

		//property=[aadl2::BasicProperty] '=>' ownedValue=PropertyExpression ';'
		public Group getGroup() { return cGroup; }

		//property=[aadl2::BasicProperty]
		public Assignment getPropertyAssignment_0() { return cPropertyAssignment_0; }

		//[aadl2::BasicProperty]
		public CrossReference getPropertyBasicPropertyCrossReference_0_0() { return cPropertyBasicPropertyCrossReference_0_0; }

		//ID
		public RuleCall getPropertyBasicPropertyIDTerminalRuleCall_0_0_1() { return cPropertyBasicPropertyIDTerminalRuleCall_0_0_1; }

		//'=>'
		public Keyword getEqualsSignGreaterThanSignKeyword_1() { return cEqualsSignGreaterThanSignKeyword_1; }

		//ownedValue=PropertyExpression
		public Assignment getOwnedValueAssignment_2() { return cOwnedValueAssignment_2; }

		//PropertyExpression
		public RuleCall getOwnedValuePropertyExpressionParserRuleCall_2_0() { return cOwnedValuePropertyExpressionParserRuleCall_2_0; }

		//';'
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class ContainmentPathElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ContainmentPathElement");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Assignment cNamedElementAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final CrossReference cNamedElementNamedElementCrossReference_0_0_0 = (CrossReference)cNamedElementAssignment_0_0.eContents().get(0);
		private final RuleCall cNamedElementNamedElementIDTerminalRuleCall_0_0_0_1 = (RuleCall)cNamedElementNamedElementCrossReference_0_0_0.eContents().get(1);
		private final Assignment cArrayRangeAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cArrayRangeArrayRangeParserRuleCall_0_1_0 = (RuleCall)cArrayRangeAssignment_0_1.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cPathAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cPathContainmentPathElementParserRuleCall_1_1_0 = (RuleCall)cPathAssignment_1_1.eContents().get(0);
		
		//// from AADL2
		//// need to add annex path element
		//ContainmentPathElement aadl2::ContainmentPathElement:
		//	(namedElement=[aadl2::NamedElement] arrayRange+=ArrayRange*) ('.' path=ContainmentPathElement)?
		//	//	 | 	 'annex' namedElement=[aadl2::NamedElement|ID]
		//;
		@Override public ParserRule getRule() { return rule; }

		//(namedElement=[aadl2::NamedElement] arrayRange+=ArrayRange*) ('.' path=ContainmentPathElement)?
		public Group getGroup() { return cGroup; }

		//namedElement=[aadl2::NamedElement] arrayRange+=ArrayRange*
		public Group getGroup_0() { return cGroup_0; }

		//namedElement=[aadl2::NamedElement]
		public Assignment getNamedElementAssignment_0_0() { return cNamedElementAssignment_0_0; }

		//[aadl2::NamedElement]
		public CrossReference getNamedElementNamedElementCrossReference_0_0_0() { return cNamedElementNamedElementCrossReference_0_0_0; }

		//ID
		public RuleCall getNamedElementNamedElementIDTerminalRuleCall_0_0_0_1() { return cNamedElementNamedElementIDTerminalRuleCall_0_0_0_1; }

		//arrayRange+=ArrayRange*
		public Assignment getArrayRangeAssignment_0_1() { return cArrayRangeAssignment_0_1; }

		//ArrayRange
		public RuleCall getArrayRangeArrayRangeParserRuleCall_0_1_0() { return cArrayRangeArrayRangeParserRuleCall_0_1_0; }

		//('.' path=ContainmentPathElement)?
		public Group getGroup_1() { return cGroup_1; }

		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//path=ContainmentPathElement
		public Assignment getPathAssignment_1_1() { return cPathAssignment_1_1; }

		//ContainmentPathElement
		public RuleCall getPathContainmentPathElementParserRuleCall_1_1_0() { return cPathContainmentPathElementParserRuleCall_1_1_0; }
	}

	public class ANNEXREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ANNEXREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cSTARParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final RuleCall cSTARParserRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		private final RuleCall cIDTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		private final RuleCall cSTARParserRuleCall_4 = (RuleCall)cGroup.eContents().get(4);
		private final RuleCall cSTARParserRuleCall_5 = (RuleCall)cGroup.eContents().get(5);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ANNEXREF: // check what values are ok inside ** **
		//	'{' STAR STAR ID STAR STAR '}';
		@Override public ParserRule getRule() { return rule; }

		//// check what values are ok inside ** **
		//'{' STAR STAR ID STAR STAR '}'
		public Group getGroup() { return cGroup; }

		//// check what values are ok inside ** **
		//'{'
		public Keyword getLeftCurlyBracketKeyword_0() { return cLeftCurlyBracketKeyword_0; }

		//STAR
		public RuleCall getSTARParserRuleCall_1() { return cSTARParserRuleCall_1; }

		//STAR
		public RuleCall getSTARParserRuleCall_2() { return cSTARParserRuleCall_2; }

		//ID
		public RuleCall getIDTerminalRuleCall_3() { return cIDTerminalRuleCall_3; }

		//STAR
		public RuleCall getSTARParserRuleCall_4() { return cSTARParserRuleCall_4; }

		//STAR
		public RuleCall getSTARParserRuleCall_5() { return cSTARParserRuleCall_5; }

		//'}'
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class PlusMinusElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.PlusMinus");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//PlusMinus aadl2::OperationKind:
		//	'+' | '-';
		@Override public ParserRule getRule() { return rule; }

		//'+' | '-'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'+'
		public Keyword getPlusSignKeyword_0() { return cPlusSignKeyword_0; }

		//'-'
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
	}

	public class StringTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.StringTerm");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueNoQuoteStringParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//StringTerm aadl2::StringLiteral:
		//	value=NoQuoteString;
		@Override public ParserRule getRule() { return rule; }

		//value=NoQuoteString
		public Assignment getValueAssignment() { return cValueAssignment; }

		//NoQuoteString
		public RuleCall getValueNoQuoteStringParserRuleCall_0() { return cValueNoQuoteStringParserRuleCall_0; }
	}

	public class NoQuoteStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//NoQuoteString:
		//	STRING;
		@Override public ParserRule getRule() { return rule; }

		//// remove quotes from string in ValueConverter
		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}

	public class ArrayRangeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ArrayRange");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cArrayRangeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cLowerBoundAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cLowerBoundINTVALUEParserRuleCall_2_0 = (RuleCall)cLowerBoundAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFullStopFullStopKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cUpperBoundAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cUpperBoundINTVALUEParserRuleCall_3_1_0 = (RuleCall)cUpperBoundAssignment_3_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//ArrayRange aadl2::ArrayRange:
		//	{aadl2::ArrayRange}
		//	'[' lowerBound=INTVALUE ('..' upperBound=INTVALUE)?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//{aadl2::ArrayRange} '[' lowerBound=INTVALUE ('..' upperBound=INTVALUE)? ']'
		public Group getGroup() { return cGroup; }

		//{aadl2::ArrayRange}
		public Action getArrayRangeAction_0() { return cArrayRangeAction_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//lowerBound=INTVALUE
		public Assignment getLowerBoundAssignment_2() { return cLowerBoundAssignment_2; }

		//INTVALUE
		public RuleCall getLowerBoundINTVALUEParserRuleCall_2_0() { return cLowerBoundINTVALUEParserRuleCall_2_0; }

		//('..' upperBound=INTVALUE)?
		public Group getGroup_3() { return cGroup_3; }

		//'..'
		public Keyword getFullStopFullStopKeyword_3_0() { return cFullStopFullStopKeyword_3_0; }

		//upperBound=INTVALUE
		public Assignment getUpperBoundAssignment_3_1() { return cUpperBoundAssignment_3_1; }

		//INTVALUE
		public RuleCall getUpperBoundINTVALUEParserRuleCall_3_1_0() { return cUpperBoundINTVALUEParserRuleCall_3_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class SignedConstantElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.SignedConstant");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cOpAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cOpPlusMinusParserRuleCall_0_0 = (RuleCall)cOpAssignment_0.eContents().get(0);
		private final Assignment cOwnedPropertyExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cOwnedPropertyExpressionConstantValueParserRuleCall_1_0 = (RuleCall)cOwnedPropertyExpressionAssignment_1.eContents().get(0);
		
		//SignedConstant aadl2::Operation:
		//	op=PlusMinus ownedPropertyExpression+=ConstantValue;
		@Override public ParserRule getRule() { return rule; }

		//op=PlusMinus ownedPropertyExpression+=ConstantValue
		public Group getGroup() { return cGroup; }

		//op=PlusMinus
		public Assignment getOpAssignment_0() { return cOpAssignment_0; }

		//PlusMinus
		public RuleCall getOpPlusMinusParserRuleCall_0_0() { return cOpPlusMinusParserRuleCall_0_0; }

		//ownedPropertyExpression+=ConstantValue
		public Assignment getOwnedPropertyExpressionAssignment_1() { return cOwnedPropertyExpressionAssignment_1; }

		//ConstantValue
		public RuleCall getOwnedPropertyExpressionConstantValueParserRuleCall_1_0() { return cOwnedPropertyExpressionConstantValueParserRuleCall_1_0; }
	}

	public class IntegerTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.IntegerTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cValueSignedIntParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cUnitAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_1_0 = (CrossReference)cUnitAssignment_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_0.eContents().get(1);
		
		//IntegerTerm aadl2::IntegerLiteral:
		//	value=SignedInt unit=[aadl2::UnitLiteral]?;
		@Override public ParserRule getRule() { return rule; }

		//value=SignedInt unit=[aadl2::UnitLiteral]?
		public Group getGroup() { return cGroup; }

		//value=SignedInt
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//SignedInt
		public RuleCall getValueSignedIntParserRuleCall_0_0() { return cValueSignedIntParserRuleCall_0_0; }

		//unit=[aadl2::UnitLiteral]?
		public Assignment getUnitAssignment_1() { return cUnitAssignment_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_0() { return cUnitUnitLiteralCrossReference_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_0_1; }
	}

	public class SignedIntElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.SignedInt");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cINTEGER_LITTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//SignedInt aadl2::Integer:
		//	('+' | '-')? INTEGER_LIT;
		@Override public ParserRule getRule() { return rule; }

		//('+' | '-')? INTEGER_LIT
		public Group getGroup() { return cGroup; }

		//('+' | '-')?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'+'
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//'-'
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall_1() { return cINTEGER_LITTerminalRuleCall_1; }
	}

	public class RealTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.RealTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cValueSignedRealParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cUnitAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_1_0 = (CrossReference)cUnitAssignment_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_0.eContents().get(1);
		
		//RealTerm aadl2::RealLiteral:
		//	value=SignedReal unit=[aadl2::UnitLiteral]?;
		@Override public ParserRule getRule() { return rule; }

		//value=SignedReal unit=[aadl2::UnitLiteral]?
		public Group getGroup() { return cGroup; }

		//value=SignedReal
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//SignedReal
		public RuleCall getValueSignedRealParserRuleCall_0_0() { return cValueSignedRealParserRuleCall_0_0; }

		//unit=[aadl2::UnitLiteral]?
		public Assignment getUnitAssignment_1() { return cUnitAssignment_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_0() { return cUnitUnitLiteralCrossReference_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_0_1; }
	}

	public class SignedRealElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.SignedReal");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Keyword cPlusSignKeyword_0_0 = (Keyword)cAlternatives_0.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_0_1 = (Keyword)cAlternatives_0.eContents().get(1);
		private final RuleCall cREAL_LITTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//SignedReal aadl2::Real:
		//	('+' | '-')? REAL_LIT;
		@Override public ParserRule getRule() { return rule; }

		//('+' | '-')? REAL_LIT
		public Group getGroup() { return cGroup; }

		//('+' | '-')?
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//'+'
		public Keyword getPlusSignKeyword_0_0() { return cPlusSignKeyword_0_0; }

		//'-'
		public Keyword getHyphenMinusKeyword_0_1() { return cHyphenMinusKeyword_0_1; }

		//REAL_LIT
		public RuleCall getREAL_LITTerminalRuleCall_1() { return cREAL_LITTerminalRuleCall_1; }
	}

	public class NumericRangeTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.NumericRangeTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cMinimumAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cMinimumNumAltParserRuleCall_0_0 = (RuleCall)cMinimumAssignment_0.eContents().get(0);
		private final Keyword cFullStopFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cMaximumAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMaximumNumAltParserRuleCall_2_0 = (RuleCall)cMaximumAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cDeltaKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cDeltaAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cDeltaNumAltParserRuleCall_3_1_0 = (RuleCall)cDeltaAssignment_3_1.eContents().get(0);
		
		//NumericRangeTerm aadl2::RangeValue:
		//	minimum=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
		//	'..' maximum=NumAlt ('delta' delta=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//)?;
		@Override public ParserRule getRule() { return rule; }

		//minimum=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
		//'..' maximum=NumAlt ('delta' delta=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//)?
		public Group getGroup() { return cGroup; }

		//minimum=NumAlt
		public Assignment getMinimumAssignment_0() { return cMinimumAssignment_0; }

		//NumAlt
		public RuleCall getMinimumNumAltParserRuleCall_0_0() { return cMinimumNumAltParserRuleCall_0_0; }

		////(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
		//'..'
		public Keyword getFullStopFullStopKeyword_1() { return cFullStopFullStopKeyword_1; }

		//maximum=NumAlt
		public Assignment getMaximumAssignment_2() { return cMaximumAssignment_2; }

		//NumAlt
		public RuleCall getMaximumNumAltParserRuleCall_2_0() { return cMaximumNumAltParserRuleCall_2_0; }

		//('delta' delta=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//)?
		public Group getGroup_3() { return cGroup_3; }

		//'delta'
		public Keyword getDeltaKeyword_3_0() { return cDeltaKeyword_3_0; }

		//delta=NumAlt
		public Assignment getDeltaAssignment_3_1() { return cDeltaAssignment_3_1; }

		//NumAlt
		public RuleCall getDeltaNumAltParserRuleCall_3_1_0() { return cDeltaNumAltParserRuleCall_3_1_0; }
	}

	public class NumAltElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.NumAlt");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cRealTermParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIntegerTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSignedConstantParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cConstantValueParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//NumAlt aadl2::PropertyExpression:
		//	RealTerm | IntegerTerm | SignedConstant | ConstantValue;
		@Override public ParserRule getRule() { return rule; }

		//RealTerm | IntegerTerm | SignedConstant | ConstantValue
		public Alternatives getAlternatives() { return cAlternatives; }

		//RealTerm
		public RuleCall getRealTermParserRuleCall_0() { return cRealTermParserRuleCall_0; }

		//IntegerTerm
		public RuleCall getIntegerTermParserRuleCall_1() { return cIntegerTermParserRuleCall_1; }

		//SignedConstant
		public RuleCall getSignedConstantParserRuleCall_2() { return cSignedConstantParserRuleCall_2; }

		//ConstantValue
		public RuleCall getConstantValueParserRuleCall_3() { return cConstantValueParserRuleCall_3; }
	}

	public class AppliesToKeywordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.AppliesToKeywords");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAppliesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cToKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//AppliesToKeywords:
		//	'applies' 'to';
		@Override public ParserRule getRule() { return rule; }

		//'applies' 'to'
		public Group getGroup() { return cGroup; }

		//'applies'
		public Keyword getAppliesKeyword_0() { return cAppliesKeyword_0; }

		//'to'
		public Keyword getToKeyword_1() { return cToKeyword_1; }
	}

	public class InBindingKeywordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.InBindingKeywords");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cBindingKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//InBindingKeywords:
		//	'in' 'binding';
		@Override public ParserRule getRule() { return rule; }

		//'in' 'binding'
		public Group getGroup() { return cGroup; }

		//'in'
		public Keyword getInKeyword_0() { return cInKeyword_0; }

		//'binding'
		public Keyword getBindingKeyword_1() { return cBindingKeyword_1; }
	}

	public class InModesKeywordsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.InModesKeywords");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cModesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//InModesKeywords:
		//	'in' 'modes';
		@Override public ParserRule getRule() { return rule; }

		//'in' 'modes'
		public Group getGroup() { return cGroup; }

		//'in'
		public Keyword getInKeyword_0() { return cInKeyword_0; }

		//'modes'
		public Keyword getModesKeyword_1() { return cModesKeyword_1; }
	}

	public class INTVALUEElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.INTVALUE");
		private final RuleCall cINTEGER_LITTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//INTVALUE aadl2::Integer:
		//	INTEGER_LIT //NUMERAL 	
		//;
		@Override public ParserRule getRule() { return rule; }

		//INTEGER_LIT
		public RuleCall getINTEGER_LITTerminalRuleCall() { return cINTEGER_LITTerminalRuleCall; }
	}

	public class QCLREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.QCLREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cColonColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//QCLREF:
		//	ID '::' ID;
		@Override public ParserRule getRule() { return rule; }

		//ID '::' ID
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//'::'
		public Keyword getColonColonKeyword_1() { return cColonColonKeyword_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_2() { return cIDTerminalRuleCall_2; }
	}

	public class QPREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.QPREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//QPREF:
		//	ID ('::' ID)?;
		@Override public ParserRule getRule() { return rule; }

		//ID ('::' ID)?
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//('::' ID)?
		public Group getGroup_1() { return cGroup_1; }

		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}

	public class QCREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.QCREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cColonColonKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		
		//QCREF:
		//	(ID '::')* ID ('.' ID)?;
		@Override public ParserRule getRule() { return rule; }

		//(ID '::')* ID ('.' ID)?
		public Group getGroup() { return cGroup; }

		//(ID '::')*
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//'::'
		public Keyword getColonColonKeyword_0_1() { return cColonColonKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//('.' ID)?
		public Group getGroup_2() { return cGroup_2; }

		//'.'
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }
	}

	public class STARElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.STAR");
		private final Keyword cAsteriskKeyword = (Keyword)rule.eContents().get(1);
		
		//STAR:
		//	'*';
		@Override public ParserRule getRule() { return rule; }

		//'*'
		public Keyword getAsteriskKeyword() { return cAsteriskKeyword; }
	}
	
	
	private final PModelElements pPModel;
	private final ContainedPropertyAssociationElements pContainedPropertyAssociation;
	private final PropertyAssociationElements pPropertyAssociation;
	private final BasicPropertyAssociationElements pBasicPropertyAssociation;
	private final ContainmentPathElements pContainmentPath;
	private final ModalPropertyValueElements pModalPropertyValue;
	private final OptionalModalPropertyValueElements pOptionalModalPropertyValue;
	private final PropertyValueElements pPropertyValue;
	private final PropertyExpressionElements pPropertyExpression;
	private final LiteralorReferenceTermElements pLiteralorReferenceTerm;
	private final BooleanLiteralElements pBooleanLiteral;
	private final ConstantValueElements pConstantValue;
	private final ReferenceTermElements pReferenceTerm;
	private final RecordTermElements pRecordTerm;
	private final OldRecordTermElements pOldRecordTerm;
	private final ComputedTermElements pComputedTerm;
	private final ComponentClassifierTermElements pComponentClassifierTerm;
	private final ListTermElements pListTerm;
	private final FieldPropertyAssociationElements pFieldPropertyAssociation;
	private final ContainmentPathElementElements pContainmentPathElement;
	private final ANNEXREFElements pANNEXREF;
	private final PlusMinusElements pPlusMinus;
	private final StringTermElements pStringTerm;
	private final NoQuoteStringElements pNoQuoteString;
	private final ArrayRangeElements pArrayRange;
	private final SignedConstantElements pSignedConstant;
	private final IntegerTermElements pIntegerTerm;
	private final SignedIntElements pSignedInt;
	private final RealTermElements pRealTerm;
	private final SignedRealElements pSignedReal;
	private final NumericRangeTermElements pNumericRangeTerm;
	private final NumAltElements pNumAlt;
	private final AppliesToKeywordsElements pAppliesToKeywords;
	private final InBindingKeywordsElements pInBindingKeywords;
	private final InModesKeywordsElements pInModesKeywords;
	private final TerminalRule tSL_COMMENT;
	private final INTVALUEElements pINTVALUE;
	private final TerminalRule tEXPONENT;
	private final TerminalRule tINT_EXPONENT;
	private final TerminalRule tREAL_LIT;
	private final TerminalRule tINTEGER_LIT;
	private final TerminalRule tDIGIT;
	private final TerminalRule tEXTENDED_DIGIT;
	private final TerminalRule tBASED_INTEGER;
	private final QCLREFElements pQCLREF;
	private final QPREFElements pQPREF;
	private final QCREFElements pQCREF;
	private final STARElements pSTAR;
	private final TerminalRule tSTRING;
	private final TerminalRule tID;
	private final TerminalRule tWS;
	
	private final Grammar grammar;

	@Inject
	public PropertiesGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pPModel = new PModelElements();
		this.pContainedPropertyAssociation = new ContainedPropertyAssociationElements();
		this.pPropertyAssociation = new PropertyAssociationElements();
		this.pBasicPropertyAssociation = new BasicPropertyAssociationElements();
		this.pContainmentPath = new ContainmentPathElements();
		this.pModalPropertyValue = new ModalPropertyValueElements();
		this.pOptionalModalPropertyValue = new OptionalModalPropertyValueElements();
		this.pPropertyValue = new PropertyValueElements();
		this.pPropertyExpression = new PropertyExpressionElements();
		this.pLiteralorReferenceTerm = new LiteralorReferenceTermElements();
		this.pBooleanLiteral = new BooleanLiteralElements();
		this.pConstantValue = new ConstantValueElements();
		this.pReferenceTerm = new ReferenceTermElements();
		this.pRecordTerm = new RecordTermElements();
		this.pOldRecordTerm = new OldRecordTermElements();
		this.pComputedTerm = new ComputedTermElements();
		this.pComponentClassifierTerm = new ComponentClassifierTermElements();
		this.pListTerm = new ListTermElements();
		this.pFieldPropertyAssociation = new FieldPropertyAssociationElements();
		this.pContainmentPathElement = new ContainmentPathElementElements();
		this.pANNEXREF = new ANNEXREFElements();
		this.pPlusMinus = new PlusMinusElements();
		this.pStringTerm = new StringTermElements();
		this.pNoQuoteString = new NoQuoteStringElements();
		this.pArrayRange = new ArrayRangeElements();
		this.pSignedConstant = new SignedConstantElements();
		this.pIntegerTerm = new IntegerTermElements();
		this.pSignedInt = new SignedIntElements();
		this.pRealTerm = new RealTermElements();
		this.pSignedReal = new SignedRealElements();
		this.pNumericRangeTerm = new NumericRangeTermElements();
		this.pNumAlt = new NumAltElements();
		this.pAppliesToKeywords = new AppliesToKeywordsElements();
		this.pInBindingKeywords = new InBindingKeywordsElements();
		this.pInModesKeywords = new InModesKeywordsElements();
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.SL_COMMENT");
		this.pINTVALUE = new INTVALUEElements();
		this.tEXPONENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.EXPONENT");
		this.tINT_EXPONENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.INT_EXPONENT");
		this.tREAL_LIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.REAL_LIT");
		this.tINTEGER_LIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.INTEGER_LIT");
		this.tDIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.DIGIT");
		this.tEXTENDED_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.EXTENDED_DIGIT");
		this.tBASED_INTEGER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.BASED_INTEGER");
		this.pQCLREF = new QCLREFElements();
		this.pQPREF = new QPREFElements();
		this.pQCREF = new QCREFElements();
		this.pSTAR = new STARElements();
		this.tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.STRING");
		this.tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.ID");
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.xtext.aadl2.properties.Properties.WS");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.xtext.aadl2.properties.Properties".equals(grammar.getName())) {
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
	

	
	//PModel aadl2::Element:
	//	ContainedPropertyAssociation //| BasicPropertyAssociation | PropertyAssociation
	//;
	public PModelElements getPModelAccess() {
		return pPModel;
	}
	
	public ParserRule getPModelRule() {
		return getPModelAccess().getRule();
	}

	//// Properties
	//ContainedPropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
	//	(',' ownedValue+=OptionalModalPropertyValue)*) (AppliesToKeywords appliesTo+=ContainmentPath (','
	//	appliesTo+=ContainmentPath)*)? (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
	//	';';
	public ContainedPropertyAssociationElements getContainedPropertyAssociationAccess() {
		return pContainedPropertyAssociation;
	}
	
	public ParserRule getContainedPropertyAssociationRule() {
		return getContainedPropertyAssociationAccess().getRule();
	}

	//PropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF] ('=>' | append?='+=>') constant?='constant'? (ownedValue+=OptionalModalPropertyValue
	//	(',' ownedValue+=OptionalModalPropertyValue)*) (InBindingKeywords '(' inBinding+=[aadl2::Classifier|QCREF] ')')?
	//	';';
	public PropertyAssociationElements getPropertyAssociationAccess() {
		return pPropertyAssociation;
	}
	
	public ParserRule getPropertyAssociationRule() {
		return getPropertyAssociationAccess().getRule();
	}

	//BasicPropertyAssociation aadl2::PropertyAssociation:
	//	property=[aadl2::Property|QPREF]
	//	'=>' ownedValue+=PropertyValue ';';
	public BasicPropertyAssociationElements getBasicPropertyAssociationAccess() {
		return pBasicPropertyAssociation;
	}
	
	public ParserRule getBasicPropertyAssociationRule() {
		return getBasicPropertyAssociationAccess().getRule();
	}

	//ContainmentPath aadl2::ContainedNamedElement:
	//	path=ContainmentPathElement
	//	//	( 'annex' containmentPathElement+=AnnexPath )?
	//;
	public ContainmentPathElements getContainmentPathAccess() {
		return pContainmentPath;
	}
	
	public ParserRule getContainmentPathRule() {
		return getContainmentPathAccess().getRule();
	}

	////AnnexPath returns aadl2::ContainmentPathElement:
	////	 namedElement=[aadl2::NamedElement|IDANNEXTEXT];
	//ModalPropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression
	//	InModesKeywords '('
	//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
	//	')';
	public ModalPropertyValueElements getModalPropertyValueAccess() {
		return pModalPropertyValue;
	}
	
	public ParserRule getModalPropertyValueRule() {
		return getModalPropertyValueAccess().getRule();
	}

	//OptionalModalPropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression (InModesKeywords '('
	//	inMode+=[aadl2::Mode] (',' inMode+=[aadl2::Mode])*
	//	')')?;
	public OptionalModalPropertyValueElements getOptionalModalPropertyValueAccess() {
		return pOptionalModalPropertyValue;
	}
	
	public ParserRule getOptionalModalPropertyValueRule() {
		return getOptionalModalPropertyValueAccess().getRule();
	}

	//// &&&&&&&&&& handling of in binding
	//PropertyValue aadl2::ModalPropertyValue:
	//	ownedValue=PropertyExpression;
	public PropertyValueElements getPropertyValueAccess() {
		return pPropertyValue;
	}
	
	public ParserRule getPropertyValueRule() {
		return getPropertyValueAccess().getRule();
	}

	//PropertyExpression aadl2::PropertyExpression:
	//	RecordTerm | ReferenceTerm | ComponentClassifierTerm
	//	| ComputedTerm | StringTerm | NumericRangeTerm
	//	| RealTerm | IntegerTerm
	//	| ListTerm
	//	| BooleanLiteral | LiteralorReferenceTerm;
	public PropertyExpressionElements getPropertyExpressionAccess() {
		return pPropertyExpression;
	}
	
	public ParserRule getPropertyExpressionRule() {
		return getPropertyExpressionAccess().getRule();
	}

	//LiteralorReferenceTerm aadl2::NamedValue:
	//	namedValue=[aadl2::AbstractNamedValue|QPREF];
	public LiteralorReferenceTermElements getLiteralorReferenceTermAccess() {
		return pLiteralorReferenceTerm;
	}
	
	public ParserRule getLiteralorReferenceTermRule() {
		return getLiteralorReferenceTermAccess().getRule();
	}

	//BooleanLiteral aadl2::BooleanLiteral:
	//	{aadl2::BooleanLiteral} (value?='true' | 'false');
	public BooleanLiteralElements getBooleanLiteralAccess() {
		return pBooleanLiteral;
	}
	
	public ParserRule getBooleanLiteralRule() {
		return getBooleanLiteralAccess().getRule();
	}

	//ConstantValue aadl2::NamedValue:
	//	namedValue=[aadl2::PropertyConstant|QPREF];
	public ConstantValueElements getConstantValueAccess() {
		return pConstantValue;
	}
	
	public ParserRule getConstantValueRule() {
		return getConstantValueAccess().getRule();
	}

	//ReferenceTerm aadl2::ReferenceValue:
	//	'reference' '('
	//	path=ContainmentPathElement
	//	//	( 'annex' ID '{**' 
	//	//	containmentPathElement+=ContainmentPathElement
	//	//	( '.' containmentPathElement+=ContainmentPathElement)*
	//	//	'**}')?
	//	')';
	public ReferenceTermElements getReferenceTermAccess() {
		return pReferenceTerm;
	}
	
	public ParserRule getReferenceTermRule() {
		return getReferenceTermAccess().getRule();
	}

	//RecordTerm aadl2::RecordValue:
	//	'['
	//	ownedFieldValue+=FieldPropertyAssociation+
	//	']';
	public RecordTermElements getRecordTermAccess() {
		return pRecordTerm;
	}
	
	public ParserRule getRecordTermRule() {
		return getRecordTermAccess().getRule();
	}

	//OldRecordTerm aadl2::RecordValue:
	//	'('
	//	ownedFieldValue+=FieldPropertyAssociation+
	//	')';
	public OldRecordTermElements getOldRecordTermAccess() {
		return pOldRecordTerm;
	}
	
	public ParserRule getOldRecordTermRule() {
		return getOldRecordTermAccess().getRule();
	}

	//ComputedTerm aadl2::ComputedValue:
	//	'compute' '('
	//	function=ID
	//	')';
	public ComputedTermElements getComputedTermAccess() {
		return pComputedTerm;
	}
	
	public ParserRule getComputedTermRule() {
		return getComputedTermAccess().getRule();
	}

	//ComponentClassifierTerm aadl2::ClassifierValue:
	//	'classifier' '('
	//	classifier=[aadl2::ComponentClassifier|QCREF]
	//	')';
	public ComponentClassifierTermElements getComponentClassifierTermAccess() {
		return pComponentClassifierTerm;
	}
	
	public ParserRule getComponentClassifierTermRule() {
		return getComponentClassifierTermAccess().getRule();
	}

	//ListTerm aadl2::ListValue:
	//	{aadl2::ListValue}
	//	'(' (ownedListElement+=PropertyExpression (',' ownedListElement+=PropertyExpression)*)?
	//	')';
	public ListTermElements getListTermAccess() {
		return pListTerm;
	}
	
	public ParserRule getListTermRule() {
		return getListTermAccess().getRule();
	}

	//FieldPropertyAssociation aadl2::BasicPropertyAssociation:
	//	property=[aadl2::BasicProperty]
	//	'=>'
	//	ownedValue=PropertyExpression
	//	';';
	public FieldPropertyAssociationElements getFieldPropertyAssociationAccess() {
		return pFieldPropertyAssociation;
	}
	
	public ParserRule getFieldPropertyAssociationRule() {
		return getFieldPropertyAssociationAccess().getRule();
	}

	//// from AADL2
	//// need to add annex path element
	//ContainmentPathElement aadl2::ContainmentPathElement:
	//	(namedElement=[aadl2::NamedElement] arrayRange+=ArrayRange*) ('.' path=ContainmentPathElement)?
	//	//	 | 	 'annex' namedElement=[aadl2::NamedElement|ID]
	//;
	public ContainmentPathElementElements getContainmentPathElementAccess() {
		return pContainmentPathElement;
	}
	
	public ParserRule getContainmentPathElementRule() {
		return getContainmentPathElementAccess().getRule();
	}

	//ANNEXREF: // check what values are ok inside ** **
	//	'{' STAR STAR ID STAR STAR '}';
	public ANNEXREFElements getANNEXREFAccess() {
		return pANNEXREF;
	}
	
	public ParserRule getANNEXREFRule() {
		return getANNEXREFAccess().getRule();
	}

	//PlusMinus aadl2::OperationKind:
	//	'+' | '-';
	public PlusMinusElements getPlusMinusAccess() {
		return pPlusMinus;
	}
	
	public ParserRule getPlusMinusRule() {
		return getPlusMinusAccess().getRule();
	}

	//StringTerm aadl2::StringLiteral:
	//	value=NoQuoteString;
	public StringTermElements getStringTermAccess() {
		return pStringTerm;
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}

	//NoQuoteString:
	//	STRING;
	public NoQuoteStringElements getNoQuoteStringAccess() {
		return pNoQuoteString;
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}

	//ArrayRange aadl2::ArrayRange:
	//	{aadl2::ArrayRange}
	//	'[' lowerBound=INTVALUE ('..' upperBound=INTVALUE)?
	//	']';
	public ArrayRangeElements getArrayRangeAccess() {
		return pArrayRange;
	}
	
	public ParserRule getArrayRangeRule() {
		return getArrayRangeAccess().getRule();
	}

	//SignedConstant aadl2::Operation:
	//	op=PlusMinus ownedPropertyExpression+=ConstantValue;
	public SignedConstantElements getSignedConstantAccess() {
		return pSignedConstant;
	}
	
	public ParserRule getSignedConstantRule() {
		return getSignedConstantAccess().getRule();
	}

	//IntegerTerm aadl2::IntegerLiteral:
	//	value=SignedInt unit=[aadl2::UnitLiteral]?;
	public IntegerTermElements getIntegerTermAccess() {
		return pIntegerTerm;
	}
	
	public ParserRule getIntegerTermRule() {
		return getIntegerTermAccess().getRule();
	}

	//SignedInt aadl2::Integer:
	//	('+' | '-')? INTEGER_LIT;
	public SignedIntElements getSignedIntAccess() {
		return pSignedInt;
	}
	
	public ParserRule getSignedIntRule() {
		return getSignedIntAccess().getRule();
	}

	//RealTerm aadl2::RealLiteral:
	//	value=SignedReal unit=[aadl2::UnitLiteral]?;
	public RealTermElements getRealTermAccess() {
		return pRealTerm;
	}
	
	public ParserRule getRealTermRule() {
		return getRealTermAccess().getRule();
	}

	//SignedReal aadl2::Real:
	//	('+' | '-')? REAL_LIT;
	public SignedRealElements getSignedRealAccess() {
		return pSignedReal;
	}
	
	public ParserRule getSignedRealRule() {
		return getSignedRealAccess().getRule();
	}

	//NumericRangeTerm aadl2::RangeValue:
	//	minimum=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
	//	'..' maximum=NumAlt ('delta' delta=NumAlt //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//)?;
	public NumericRangeTermElements getNumericRangeTermAccess() {
		return pNumericRangeTerm;
	}
	
	public ParserRule getNumericRangeTermRule() {
		return getNumericRangeTermAccess().getRule();
	}

	//NumAlt aadl2::PropertyExpression:
	//	RealTerm | IntegerTerm | SignedConstant | ConstantValue;
	public NumAltElements getNumAltAccess() {
		return pNumAlt;
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}

	//AppliesToKeywords:
	//	'applies' 'to';
	public AppliesToKeywordsElements getAppliesToKeywordsAccess() {
		return pAppliesToKeywords;
	}
	
	public ParserRule getAppliesToKeywordsRule() {
		return getAppliesToKeywordsAccess().getRule();
	}

	//InBindingKeywords:
	//	'in' 'binding';
	public InBindingKeywordsElements getInBindingKeywordsAccess() {
		return pInBindingKeywords;
	}
	
	public ParserRule getInBindingKeywordsRule() {
		return getInBindingKeywordsAccess().getRule();
	}

	//InModesKeywords:
	//	'in' 'modes';
	public InModesKeywordsElements getInModesKeywordsAccess() {
		return pInModesKeywords;
	}
	
	public ParserRule getInModesKeywordsRule() {
		return getInModesKeywordsAccess().getRule();
	}

	//terminal SL_COMMENT:
	//	'--' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	} 

	//INTVALUE aadl2::Integer:
	//	INTEGER_LIT //NUMERAL 	
	//;
	public INTVALUEElements getINTVALUEAccess() {
		return pINTVALUE;
	}
	
	public ParserRule getINTVALUERule() {
		return getINTVALUEAccess().getRule();
	}

	//terminal fragment EXPONENT:
	//	('e' | 'E') ('+' | '-')? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return tEXPONENT;
	} 

	//terminal fragment INT_EXPONENT:
	//	('e' | 'E') '+'? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return tINT_EXPONENT;
	} 

	//terminal REAL_LIT:
	//	DIGIT+ ('_' DIGIT+)* ('.' DIGIT+ ('_' DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return tREAL_LIT;
	} 

	//terminal INTEGER_LIT:
	//	DIGIT+ ('_' DIGIT+)* ('#' BASED_INTEGER '#' INT_EXPONENT? | INT_EXPONENT?);
	public TerminalRule getINTEGER_LITRule() {
		return tINTEGER_LIT;
	} 

	//terminal fragment DIGIT:
	//	'0'..'9';
	public TerminalRule getDIGITRule() {
		return tDIGIT;
	} 

	//terminal fragment EXTENDED_DIGIT:
	//	'0'..'9' | 'a'..'f' | 'A'..'F';
	public TerminalRule getEXTENDED_DIGITRule() {
		return tEXTENDED_DIGIT;
	} 

	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ('_'? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return tBASED_INTEGER;
	} 

	//QCLREF:
	//	ID '::' ID;
	public QCLREFElements getQCLREFAccess() {
		return pQCLREF;
	}
	
	public ParserRule getQCLREFRule() {
		return getQCLREFAccess().getRule();
	}

	//QPREF:
	//	ID ('::' ID)?;
	public QPREFElements getQPREFAccess() {
		return pQPREF;
	}
	
	public ParserRule getQPREFRule() {
		return getQPREFAccess().getRule();
	}

	//QCREF:
	//	(ID '::')* ID ('.' ID)?;
	public QCREFElements getQCREFAccess() {
		return pQCREF;
	}
	
	public ParserRule getQCREFRule() {
		return getQCREFAccess().getRule();
	}

	//STAR:
	//	'*';
	public STARElements getSTARAccess() {
		return pSTAR;
	}
	
	public ParserRule getSTARRule() {
		return getSTARAccess().getRule();
	}

	//terminal STRING:
	//	'"' ('\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | '"'))* '"' |
	//	"'" ('\\' ('b' | 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return tSTRING;
	} 

	//terminal ID:
	//	('a'..'z'
	//	| 'A'..'Z') ('_'? ('a'..'z'
	//	| 'A'..'Z'
	//	| '0'..'9'))*;
	public TerminalRule getIDRule() {
		return tID;
	} 

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return tWS;
	} 
}
