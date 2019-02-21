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
package org.osate.alisa.common.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class CommonGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class DescriptionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.Description");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDescriptionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cDescriptionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDescriptionDescriptionElementParserRuleCall_1_0 = (RuleCall)cDescriptionAssignment_1.eContents().get(0);
		
		//Description:
		//	'description' description+=DescriptionElement+;
		@Override public ParserRule getRule() { return rule; }

		//'description' description+=DescriptionElement+
		public Group getGroup() { return cGroup; }

		//'description'
		public Keyword getDescriptionKeyword_0() { return cDescriptionKeyword_0; }

		//description+=DescriptionElement+
		public Assignment getDescriptionAssignment_1() { return cDescriptionAssignment_1; }

		//DescriptionElement
		public RuleCall getDescriptionDescriptionElementParserRuleCall_1_0() { return cDescriptionDescriptionElementParserRuleCall_1_0; }
	}

	public class DescriptionElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.DescriptionElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cTextAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cTextSTRINGTerminalRuleCall_0_0 = (RuleCall)cTextAssignment_0.eContents().get(0);
		private final Assignment cThisTargetAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cThisTargetThisKeyword_1_0 = (Keyword)cThisTargetAssignment_1.eContents().get(0);
		private final Assignment cImageAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final RuleCall cImageImageReferenceParserRuleCall_2_0 = (RuleCall)cImageAssignment_2.eContents().get(0);
		private final Assignment cShowValueAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final RuleCall cShowValueShowValueParserRuleCall_3_0 = (RuleCall)cShowValueAssignment_3.eContents().get(0);
		
		//DescriptionElement:
		//	text=STRING | => thisTarget?='this' | => image=ImageReference | showValue=ShowValue;
		@Override public ParserRule getRule() { return rule; }

		//text=STRING | => thisTarget?='this' | => image=ImageReference | showValue=ShowValue
		public Alternatives getAlternatives() { return cAlternatives; }

		//text=STRING
		public Assignment getTextAssignment_0() { return cTextAssignment_0; }

		//STRING
		public RuleCall getTextSTRINGTerminalRuleCall_0_0() { return cTextSTRINGTerminalRuleCall_0_0; }

		//=> thisTarget?='this'
		public Assignment getThisTargetAssignment_1() { return cThisTargetAssignment_1; }

		//'this'
		public Keyword getThisTargetThisKeyword_1_0() { return cThisTargetThisKeyword_1_0; }

		//=> image=ImageReference
		public Assignment getImageAssignment_2() { return cImageAssignment_2; }

		//ImageReference
		public RuleCall getImageImageReferenceParserRuleCall_2_0() { return cImageImageReferenceParserRuleCall_2_0; }

		//showValue=ShowValue
		public Assignment getShowValueAssignment_3() { return cShowValueAssignment_3; }

		//ShowValue
		public RuleCall getShowValueShowValueParserRuleCall_3_0() { return cShowValueShowValueParserRuleCall_3_0; }
	}

	public class RationaleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.Rationale");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRationaleKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTextAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTextSTRINGTerminalRuleCall_1_0 = (RuleCall)cTextAssignment_1.eContents().get(0);
		
		//Rationale:
		//	'rationale' text=STRING;
		@Override public ParserRule getRule() { return rule; }

		//'rationale' text=STRING
		public Group getGroup() { return cGroup; }

		//'rationale'
		public Keyword getRationaleKeyword_0() { return cRationaleKeyword_0; }

		//text=STRING
		public Assignment getTextAssignment_1() { return cTextAssignment_1; }

		//STRING
		public RuleCall getTextSTRINGTerminalRuleCall_1_0() { return cTextSTRINGTerminalRuleCall_1_0; }
	}

	public class UncertaintyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.Uncertainty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUncertaintyAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cUncertaintyKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final UnorderedGroup cUnorderedGroup_3 = (UnorderedGroup)cGroup.eContents().get(3);
		private final Group cGroup_3_0 = (Group)cUnorderedGroup_3.eContents().get(0);
		private final Keyword cVolatilityKeyword_3_0_0 = (Keyword)cGroup_3_0.eContents().get(0);
		private final Assignment cVolatilityAssignment_3_0_1 = (Assignment)cGroup_3_0.eContents().get(1);
		private final RuleCall cVolatilityINTTerminalRuleCall_3_0_1_0 = (RuleCall)cVolatilityAssignment_3_0_1.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cUnorderedGroup_3.eContents().get(1);
		private final Keyword cPrecedenceKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cPrecedenceAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cPrecedenceINTTerminalRuleCall_3_1_1_0 = (RuleCall)cPrecedenceAssignment_3_1_1.eContents().get(0);
		private final Group cGroup_3_2 = (Group)cUnorderedGroup_3.eContents().get(2);
		private final Keyword cImpactKeyword_3_2_0 = (Keyword)cGroup_3_2.eContents().get(0);
		private final Assignment cImpactAssignment_3_2_1 = (Assignment)cGroup_3_2.eContents().get(1);
		private final RuleCall cImpactINTTerminalRuleCall_3_2_1_0 = (RuleCall)cImpactAssignment_3_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//Uncertainty:
		//	{Uncertainty} 'uncertainty'
		//	'[' (('volatility' volatility=INT)?
		//	& ('precedence' precedence=INT)?
		//	& ('impact' impact=INT)?)
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//{Uncertainty} 'uncertainty' '[' (('volatility' volatility=INT)? & ('precedence' precedence=INT)? & ('impact'
		//impact=INT)?) ']'
		public Group getGroup() { return cGroup; }

		//{Uncertainty}
		public Action getUncertaintyAction_0() { return cUncertaintyAction_0; }

		//'uncertainty'
		public Keyword getUncertaintyKeyword_1() { return cUncertaintyKeyword_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//('volatility' volatility=INT)? & ('precedence' precedence=INT)? & ('impact' impact=INT)?
		public UnorderedGroup getUnorderedGroup_3() { return cUnorderedGroup_3; }

		//('volatility' volatility=INT)?
		public Group getGroup_3_0() { return cGroup_3_0; }

		//'volatility'
		public Keyword getVolatilityKeyword_3_0_0() { return cVolatilityKeyword_3_0_0; }

		//volatility=INT
		public Assignment getVolatilityAssignment_3_0_1() { return cVolatilityAssignment_3_0_1; }

		//INT
		public RuleCall getVolatilityINTTerminalRuleCall_3_0_1_0() { return cVolatilityINTTerminalRuleCall_3_0_1_0; }

		//('precedence' precedence=INT)?
		public Group getGroup_3_1() { return cGroup_3_1; }

		//'precedence'
		public Keyword getPrecedenceKeyword_3_1_0() { return cPrecedenceKeyword_3_1_0; }

		//precedence=INT
		public Assignment getPrecedenceAssignment_3_1_1() { return cPrecedenceAssignment_3_1_1; }

		//INT
		public RuleCall getPrecedenceINTTerminalRuleCall_3_1_1_0() { return cPrecedenceINTTerminalRuleCall_3_1_1_0; }

		//('impact' impact=INT)?
		public Group getGroup_3_2() { return cGroup_3_2; }

		//'impact'
		public Keyword getImpactKeyword_3_2_0() { return cImpactKeyword_3_2_0; }

		//impact=INT
		public Assignment getImpactAssignment_3_2_1() { return cImpactAssignment_3_2_1; }

		//INT
		public RuleCall getImpactINTTerminalRuleCall_3_2_1_0() { return cImpactINTTerminalRuleCall_3_2_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class TypeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.TypeRef");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cAadlBooleanAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Keyword cBooleanKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Action cAadlIntegerAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cIntegerKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Group cGroup_1_2 = (Group)cGroup_1.eContents().get(2);
		private final Keyword cUnitsKeyword_1_2_0 = (Keyword)cGroup_1_2.eContents().get(0);
		private final Assignment cReferencedUnitsTypeAssignment_1_2_1 = (Assignment)cGroup_1_2.eContents().get(1);
		private final CrossReference cReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0 = (CrossReference)cReferencedUnitsTypeAssignment_1_2_1.eContents().get(0);
		private final RuleCall cReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_1_2_1_0_1 = (RuleCall)cReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Action cAadlRealAction_2_0 = (Action)cGroup_2.eContents().get(0);
		private final Keyword cRealKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Group cGroup_2_2 = (Group)cGroup_2.eContents().get(2);
		private final Keyword cUnitsKeyword_2_2_0 = (Keyword)cGroup_2_2.eContents().get(0);
		private final Assignment cReferencedUnitsTypeAssignment_2_2_1 = (Assignment)cGroup_2_2.eContents().get(1);
		private final CrossReference cReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0 = (CrossReference)cReferencedUnitsTypeAssignment_2_2_1.eContents().get(0);
		private final RuleCall cReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_2_2_1_0_1 = (RuleCall)cReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cAlternatives.eContents().get(3);
		private final Action cAadlStringAction_3_0 = (Action)cGroup_3.eContents().get(0);
		private final Keyword cStringKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Group cGroup_4 = (Group)cAlternatives.eContents().get(4);
		private final Action cModelRefAction_4_0 = (Action)cGroup_4.eContents().get(0);
		private final Keyword cModelKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		private final Keyword cElementKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Action cTypeRefAction_5_0 = (Action)cGroup_5.eContents().get(0);
		private final Assignment cRefAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final CrossReference cRefPropertyTypeCrossReference_5_1_0 = (CrossReference)cRefAssignment_5_1.eContents().get(0);
		private final RuleCall cRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1 = (RuleCall)cRefPropertyTypeCrossReference_5_1_0.eContents().get(1);
		
		//TypeRef aadl2::PropertyType:
		//	{aadl2::AadlBoolean} 'boolean'
		//	| {aadl2::AadlInteger} 'integer' ('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
		//	| {aadl2::AadlReal} 'real' ('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
		//	| {aadl2::AadlString} 'string'
		//	| {ModelRef} 'model' 'element'
		//	| {TypeRef} ref=[aadl2::PropertyType|AADLPROPERTYREFERENCE];
		@Override public ParserRule getRule() { return rule; }

		//{aadl2::AadlBoolean} 'boolean' | {aadl2::AadlInteger} 'integer' ('units'
		//referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])? | {aadl2::AadlReal} 'real' ('units'
		//referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])? | {aadl2::AadlString} 'string' | {ModelRef} 'model'
		//'element' | {TypeRef} ref=[aadl2::PropertyType|AADLPROPERTYREFERENCE]
		public Alternatives getAlternatives() { return cAlternatives; }

		//{aadl2::AadlBoolean} 'boolean'
		public Group getGroup_0() { return cGroup_0; }

		//{aadl2::AadlBoolean}
		public Action getAadlBooleanAction_0_0() { return cAadlBooleanAction_0_0; }

		//'boolean'
		public Keyword getBooleanKeyword_0_1() { return cBooleanKeyword_0_1; }

		//{aadl2::AadlInteger} 'integer' ('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
		public Group getGroup_1() { return cGroup_1; }

		//{aadl2::AadlInteger}
		public Action getAadlIntegerAction_1_0() { return cAadlIntegerAction_1_0; }

		//'integer'
		public Keyword getIntegerKeyword_1_1() { return cIntegerKeyword_1_1; }

		//('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
		public Group getGroup_1_2() { return cGroup_1_2; }

		//'units'
		public Keyword getUnitsKeyword_1_2_0() { return cUnitsKeyword_1_2_0; }

		//referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE]
		public Assignment getReferencedUnitsTypeAssignment_1_2_1() { return cReferencedUnitsTypeAssignment_1_2_1; }

		//[aadl2::UnitsType|AADLPROPERTYREFERENCE]
		public CrossReference getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0() { return cReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_1_2_1_0_1() { return cReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_1_2_1_0_1; }

		//{aadl2::AadlReal} 'real' ('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
		public Group getGroup_2() { return cGroup_2; }

		//{aadl2::AadlReal}
		public Action getAadlRealAction_2_0() { return cAadlRealAction_2_0; }

		//'real'
		public Keyword getRealKeyword_2_1() { return cRealKeyword_2_1; }

		//('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
		public Group getGroup_2_2() { return cGroup_2_2; }

		//'units'
		public Keyword getUnitsKeyword_2_2_0() { return cUnitsKeyword_2_2_0; }

		//referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE]
		public Assignment getReferencedUnitsTypeAssignment_2_2_1() { return cReferencedUnitsTypeAssignment_2_2_1; }

		//[aadl2::UnitsType|AADLPROPERTYREFERENCE]
		public CrossReference getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0() { return cReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_2_2_1_0_1() { return cReferencedUnitsTypeUnitsTypeAADLPROPERTYREFERENCEParserRuleCall_2_2_1_0_1; }

		//{aadl2::AadlString} 'string'
		public Group getGroup_3() { return cGroup_3; }

		//{aadl2::AadlString}
		public Action getAadlStringAction_3_0() { return cAadlStringAction_3_0; }

		//'string'
		public Keyword getStringKeyword_3_1() { return cStringKeyword_3_1; }

		//{ModelRef} 'model' 'element'
		public Group getGroup_4() { return cGroup_4; }

		//{ModelRef}
		public Action getModelRefAction_4_0() { return cModelRefAction_4_0; }

		//'model'
		public Keyword getModelKeyword_4_1() { return cModelKeyword_4_1; }

		//'element'
		public Keyword getElementKeyword_4_2() { return cElementKeyword_4_2; }

		//{TypeRef} ref=[aadl2::PropertyType|AADLPROPERTYREFERENCE]
		public Group getGroup_5() { return cGroup_5; }

		//{TypeRef}
		public Action getTypeRefAction_5_0() { return cTypeRefAction_5_0; }

		//ref=[aadl2::PropertyType|AADLPROPERTYREFERENCE]
		public Assignment getRefAssignment_5_1() { return cRefAssignment_5_1; }

		//[aadl2::PropertyType|AADLPROPERTYREFERENCE]
		public CrossReference getRefPropertyTypeCrossReference_5_1_0() { return cRefPropertyTypeCrossReference_5_1_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1() { return cRefPropertyTypeAADLPROPERTYREFERENCEParserRuleCall_5_1_0_1; }
	}

	public class PropertyRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.PropertyRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPropertyRefAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cRefAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRefPropertyCrossReference_1_0 = (CrossReference)cRefAssignment_1.eContents().get(0);
		private final RuleCall cRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1 = (RuleCall)cRefPropertyCrossReference_1_0.eContents().get(1);
		
		//PropertyRef aadl2::PropertyType:
		//	{PropertyRef} ref=[aadl2::Property|AADLPROPERTYREFERENCE];
		@Override public ParserRule getRule() { return rule; }

		//{PropertyRef} ref=[aadl2::Property|AADLPROPERTYREFERENCE]
		public Group getGroup() { return cGroup; }

		//{PropertyRef}
		public Action getPropertyRefAction_0() { return cPropertyRefAction_0; }

		//ref=[aadl2::Property|AADLPROPERTYREFERENCE]
		public Assignment getRefAssignment_1() { return cRefAssignment_1; }

		//[aadl2::Property|AADLPROPERTYREFERENCE]
		public CrossReference getRefPropertyCrossReference_1_0() { return cRefPropertyCrossReference_1_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1() { return cRefPropertyAADLPROPERTYREFERENCEParserRuleCall_1_0_1; }
	}

	public class ValDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ValDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cValDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cValKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Alternatives cAlternatives_3_1 = (Alternatives)cGroup_3.eContents().get(1);
		private final Assignment cTypeAssignment_3_1_0 = (Assignment)cAlternatives_3_1.eContents().get(0);
		private final RuleCall cTypeTypeRefParserRuleCall_3_1_0_0 = (RuleCall)cTypeAssignment_3_1_0.eContents().get(0);
		private final Group cGroup_3_1_1 = (Group)cAlternatives_3_1.eContents().get(1);
		private final Keyword cTypeofKeyword_3_1_1_0 = (Keyword)cGroup_3_1_1.eContents().get(0);
		private final Assignment cTypeAssignment_3_1_1_1 = (Assignment)cGroup_3_1_1.eContents().get(1);
		private final RuleCall cTypePropertyRefParserRuleCall_3_1_1_1_0 = (RuleCall)cTypeAssignment_3_1_1_1.eContents().get(0);
		private final Group cGroup_3_1_2 = (Group)cAlternatives_3_1.eContents().get(2);
		private final Assignment cRangeAssignment_3_1_2_0 = (Assignment)cGroup_3_1_2.eContents().get(0);
		private final Keyword cRangeLeftSquareBracketKeyword_3_1_2_0_0 = (Keyword)cRangeAssignment_3_1_2_0.eContents().get(0);
		private final Alternatives cAlternatives_3_1_2_1 = (Alternatives)cGroup_3_1_2.eContents().get(1);
		private final Assignment cTypeAssignment_3_1_2_1_0 = (Assignment)cAlternatives_3_1_2_1.eContents().get(0);
		private final RuleCall cTypeTypeRefParserRuleCall_3_1_2_1_0_0 = (RuleCall)cTypeAssignment_3_1_2_1_0.eContents().get(0);
		private final Group cGroup_3_1_2_1_1 = (Group)cAlternatives_3_1_2_1.eContents().get(1);
		private final Keyword cTypeofKeyword_3_1_2_1_1_0 = (Keyword)cGroup_3_1_2_1_1.eContents().get(0);
		private final Assignment cTypeAssignment_3_1_2_1_1_1 = (Assignment)cGroup_3_1_2_1_1.eContents().get(1);
		private final RuleCall cTypePropertyRefParserRuleCall_3_1_2_1_1_1_0 = (RuleCall)cTypeAssignment_3_1_2_1_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3_1_2_2 = (Keyword)cGroup_3_1_2.eContents().get(2);
		private final Keyword cEqualsSignKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cValueAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cValueAExpressionParserRuleCall_5_0 = (RuleCall)cValueAssignment_5.eContents().get(0);
		
		//ValDeclaration AVariableDeclaration:
		//	{ValDeclaration} 'val' name=ID (':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof'
		//	type=PropertyRef) ']'))? '=' value=AExpression;
		@Override public ParserRule getRule() { return rule; }

		//{ValDeclaration} 'val' name=ID (':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof'
		//type=PropertyRef) ']'))? '=' value=AExpression
		public Group getGroup() { return cGroup; }

		//{ValDeclaration}
		public Action getValDeclarationAction_0() { return cValDeclarationAction_0; }

		//'val'
		public Keyword getValKeyword_1() { return cValKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//(':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof' type=PropertyRef) ']'))?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof' type=PropertyRef) ']'
		public Alternatives getAlternatives_3_1() { return cAlternatives_3_1; }

		//type=TypeRef
		public Assignment getTypeAssignment_3_1_0() { return cTypeAssignment_3_1_0; }

		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_3_1_0_0() { return cTypeTypeRefParserRuleCall_3_1_0_0; }

		//'typeof' type=PropertyRef
		public Group getGroup_3_1_1() { return cGroup_3_1_1; }

		//'typeof'
		public Keyword getTypeofKeyword_3_1_1_0() { return cTypeofKeyword_3_1_1_0; }

		//type=PropertyRef
		public Assignment getTypeAssignment_3_1_1_1() { return cTypeAssignment_3_1_1_1; }

		//PropertyRef
		public RuleCall getTypePropertyRefParserRuleCall_3_1_1_1_0() { return cTypePropertyRefParserRuleCall_3_1_1_1_0; }

		//range?='[' (type=TypeRef | 'typeof' type=PropertyRef) ']'
		public Group getGroup_3_1_2() { return cGroup_3_1_2; }

		//range?='['
		public Assignment getRangeAssignment_3_1_2_0() { return cRangeAssignment_3_1_2_0; }

		//'['
		public Keyword getRangeLeftSquareBracketKeyword_3_1_2_0_0() { return cRangeLeftSquareBracketKeyword_3_1_2_0_0; }

		//type=TypeRef | 'typeof' type=PropertyRef
		public Alternatives getAlternatives_3_1_2_1() { return cAlternatives_3_1_2_1; }

		//type=TypeRef
		public Assignment getTypeAssignment_3_1_2_1_0() { return cTypeAssignment_3_1_2_1_0; }

		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_3_1_2_1_0_0() { return cTypeTypeRefParserRuleCall_3_1_2_1_0_0; }

		//'typeof' type=PropertyRef
		public Group getGroup_3_1_2_1_1() { return cGroup_3_1_2_1_1; }

		//'typeof'
		public Keyword getTypeofKeyword_3_1_2_1_1_0() { return cTypeofKeyword_3_1_2_1_1_0; }

		//type=PropertyRef
		public Assignment getTypeAssignment_3_1_2_1_1_1() { return cTypeAssignment_3_1_2_1_1_1; }

		//PropertyRef
		public RuleCall getTypePropertyRefParserRuleCall_3_1_2_1_1_1_0() { return cTypePropertyRefParserRuleCall_3_1_2_1_1_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_3_1_2_2() { return cRightSquareBracketKeyword_3_1_2_2; }

		//'='
		public Keyword getEqualsSignKeyword_4() { return cEqualsSignKeyword_4; }

		//value=AExpression
		public Assignment getValueAssignment_5() { return cValueAssignment_5; }

		//AExpression
		public RuleCall getValueAExpressionParserRuleCall_5_0() { return cValueAExpressionParserRuleCall_5_0; }
	}

	public class ComputeDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ComputeDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cComputeDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cComputeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Keyword cColonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Alternatives cAlternatives_4 = (Alternatives)cGroup.eContents().get(4);
		private final Assignment cTypeAssignment_4_0 = (Assignment)cAlternatives_4.eContents().get(0);
		private final RuleCall cTypeTypeRefParserRuleCall_4_0_0 = (RuleCall)cTypeAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cAlternatives_4.eContents().get(1);
		private final Keyword cTypeofKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cTypeAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final RuleCall cTypePropertyRefParserRuleCall_4_1_1_0 = (RuleCall)cTypeAssignment_4_1_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cAlternatives_4.eContents().get(2);
		private final Assignment cRangeAssignment_4_2_0 = (Assignment)cGroup_4_2.eContents().get(0);
		private final Keyword cRangeLeftSquareBracketKeyword_4_2_0_0 = (Keyword)cRangeAssignment_4_2_0.eContents().get(0);
		private final Alternatives cAlternatives_4_2_1 = (Alternatives)cGroup_4_2.eContents().get(1);
		private final Assignment cTypeAssignment_4_2_1_0 = (Assignment)cAlternatives_4_2_1.eContents().get(0);
		private final RuleCall cTypeTypeRefParserRuleCall_4_2_1_0_0 = (RuleCall)cTypeAssignment_4_2_1_0.eContents().get(0);
		private final Group cGroup_4_2_1_1 = (Group)cAlternatives_4_2_1.eContents().get(1);
		private final Keyword cTypeofKeyword_4_2_1_1_0 = (Keyword)cGroup_4_2_1_1.eContents().get(0);
		private final Assignment cTypeAssignment_4_2_1_1_1 = (Assignment)cGroup_4_2_1_1.eContents().get(1);
		private final RuleCall cTypePropertyRefParserRuleCall_4_2_1_1_1_0 = (RuleCall)cTypeAssignment_4_2_1_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4_2_2 = (Keyword)cGroup_4_2.eContents().get(2);
		
		//ComputeDeclaration AVariableDeclaration:
		//	{ComputeDeclaration}
		//	'compute' name=ID ':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof'
		//	type=PropertyRef) ']');
		@Override public ParserRule getRule() { return rule; }

		//{ComputeDeclaration} 'compute' name=ID ':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef |
		//'typeof' type=PropertyRef) ']')
		public Group getGroup() { return cGroup; }

		//{ComputeDeclaration}
		public Action getComputeDeclarationAction_0() { return cComputeDeclarationAction_0; }

		//'compute'
		public Keyword getComputeKeyword_1() { return cComputeKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//':'
		public Keyword getColonKeyword_3() { return cColonKeyword_3; }

		//type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof' type=PropertyRef) ']'
		public Alternatives getAlternatives_4() { return cAlternatives_4; }

		//type=TypeRef
		public Assignment getTypeAssignment_4_0() { return cTypeAssignment_4_0; }

		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_4_0_0() { return cTypeTypeRefParserRuleCall_4_0_0; }

		//'typeof' type=PropertyRef
		public Group getGroup_4_1() { return cGroup_4_1; }

		//'typeof'
		public Keyword getTypeofKeyword_4_1_0() { return cTypeofKeyword_4_1_0; }

		//type=PropertyRef
		public Assignment getTypeAssignment_4_1_1() { return cTypeAssignment_4_1_1; }

		//PropertyRef
		public RuleCall getTypePropertyRefParserRuleCall_4_1_1_0() { return cTypePropertyRefParserRuleCall_4_1_1_0; }

		//range?='[' (type=TypeRef | 'typeof' type=PropertyRef) ']'
		public Group getGroup_4_2() { return cGroup_4_2; }

		//range?='['
		public Assignment getRangeAssignment_4_2_0() { return cRangeAssignment_4_2_0; }

		//'['
		public Keyword getRangeLeftSquareBracketKeyword_4_2_0_0() { return cRangeLeftSquareBracketKeyword_4_2_0_0; }

		//type=TypeRef | 'typeof' type=PropertyRef
		public Alternatives getAlternatives_4_2_1() { return cAlternatives_4_2_1; }

		//type=TypeRef
		public Assignment getTypeAssignment_4_2_1_0() { return cTypeAssignment_4_2_1_0; }

		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_4_2_1_0_0() { return cTypeTypeRefParserRuleCall_4_2_1_0_0; }

		//'typeof' type=PropertyRef
		public Group getGroup_4_2_1_1() { return cGroup_4_2_1_1; }

		//'typeof'
		public Keyword getTypeofKeyword_4_2_1_1_0() { return cTypeofKeyword_4_2_1_1_0; }

		//type=PropertyRef
		public Assignment getTypeAssignment_4_2_1_1_1() { return cTypeAssignment_4_2_1_1_1; }

		//PropertyRef
		public RuleCall getTypePropertyRefParserRuleCall_4_2_1_1_1_0() { return cTypePropertyRefParserRuleCall_4_2_1_1_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4_2_2() { return cRightSquareBracketKeyword_4_2_2; }
	}

	public class AModelOrPropertyReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AModelOrPropertyReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final RuleCall cAModelReferenceParserRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Group cGroup_0_1 = (Group)cGroup_0.eContents().get(1);
		private final Group cGroup_0_1_0 = (Group)cGroup_0_1.eContents().get(0);
		private final Group cGroup_0_1_0_0 = (Group)cGroup_0_1_0.eContents().get(0);
		private final Action cAPropertyReferenceModelElementReferenceAction_0_1_0_0_0 = (Action)cGroup_0_1_0_0.eContents().get(0);
		private final Keyword cNumberSignKeyword_0_1_0_0_1 = (Keyword)cGroup_0_1_0_0.eContents().get(1);
		private final Assignment cPropertyAssignment_0_1_1 = (Assignment)cGroup_0_1.eContents().get(1);
		private final CrossReference cPropertyAbstractNamedValueCrossReference_0_1_1_0 = (CrossReference)cPropertyAssignment_0_1_1.eContents().get(0);
		private final RuleCall cPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_0_1_1_0_1 = (RuleCall)cPropertyAbstractNamedValueCrossReference_0_1_1_0.eContents().get(1);
		private final RuleCall cAPropertyReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//// Reference to property, property constant, or model element.
		//AModelOrPropertyReference AExpression:
		//	AModelReference (=> ({APropertyReference.modelElementReference=current} '#')
		//	property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE])?
		//	| APropertyReference;
		@Override public ParserRule getRule() { return rule; }

		//AModelReference (=> ({APropertyReference.modelElementReference=current} '#')
		//property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE])? | APropertyReference
		public Alternatives getAlternatives() { return cAlternatives; }

		//AModelReference (=> ({APropertyReference.modelElementReference=current} '#')
		//property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE])?
		public Group getGroup_0() { return cGroup_0; }

		//AModelReference
		public RuleCall getAModelReferenceParserRuleCall_0_0() { return cAModelReferenceParserRuleCall_0_0; }

		//(=> ({APropertyReference.modelElementReference=current} '#')
		//property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE])?
		public Group getGroup_0_1() { return cGroup_0_1; }

		//=> ({APropertyReference.modelElementReference=current} '#')
		public Group getGroup_0_1_0() { return cGroup_0_1_0; }

		//{APropertyReference.modelElementReference=current} '#'
		public Group getGroup_0_1_0_0() { return cGroup_0_1_0_0; }

		//{APropertyReference.modelElementReference=current}
		public Action getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0() { return cAPropertyReferenceModelElementReferenceAction_0_1_0_0_0; }

		//'#'
		public Keyword getNumberSignKeyword_0_1_0_0_1() { return cNumberSignKeyword_0_1_0_0_1; }

		//property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public Assignment getPropertyAssignment_0_1_1() { return cPropertyAssignment_0_1_1; }

		//[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public CrossReference getPropertyAbstractNamedValueCrossReference_0_1_1_0() { return cPropertyAbstractNamedValueCrossReference_0_1_1_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_0_1_1_0_1() { return cPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_0_1_1_0_1; }

		//APropertyReference
		public RuleCall getAPropertyReferenceParserRuleCall_1() { return cAPropertyReferenceParserRuleCall_1; }
	}

	public class AModelReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AModelReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cModelElementAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cModelElementNamedElementCrossReference_0_0 = (CrossReference)cModelElementAssignment_0.eContents().get(0);
		private final RuleCall cModelElementNamedElementThisKeywordParserRuleCall_0_0_1 = (RuleCall)cModelElementNamedElementCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAModelReferencePrevAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cFullStopKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cModelElementAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cModelElementNamedElementCrossReference_1_2_0 = (CrossReference)cModelElementAssignment_1_2.eContents().get(0);
		private final RuleCall cModelElementNamedElementIDTerminalRuleCall_1_2_0_1 = (RuleCall)cModelElementNamedElementCrossReference_1_2_0.eContents().get(1);
		
		//AModelReference:
		//	modelElement=[aadl2::NamedElement|ThisKeyword] ({AModelReference.prev=current} '.'
		//	modelElement=[aadl2::NamedElement])*;
		@Override public ParserRule getRule() { return rule; }

		//modelElement=[aadl2::NamedElement|ThisKeyword] ({AModelReference.prev=current} '.' modelElement=[aadl2::NamedElement])*
		public Group getGroup() { return cGroup; }

		//modelElement=[aadl2::NamedElement|ThisKeyword]
		public Assignment getModelElementAssignment_0() { return cModelElementAssignment_0; }

		//[aadl2::NamedElement|ThisKeyword]
		public CrossReference getModelElementNamedElementCrossReference_0_0() { return cModelElementNamedElementCrossReference_0_0; }

		//ThisKeyword
		public RuleCall getModelElementNamedElementThisKeywordParserRuleCall_0_0_1() { return cModelElementNamedElementThisKeywordParserRuleCall_0_0_1; }

		//({AModelReference.prev=current} '.' modelElement=[aadl2::NamedElement])*
		public Group getGroup_1() { return cGroup_1; }

		//{AModelReference.prev=current}
		public Action getAModelReferencePrevAction_1_0() { return cAModelReferencePrevAction_1_0; }

		//'.'
		public Keyword getFullStopKeyword_1_1() { return cFullStopKeyword_1_1; }

		//modelElement=[aadl2::NamedElement]
		public Assignment getModelElementAssignment_1_2() { return cModelElementAssignment_1_2; }

		//[aadl2::NamedElement]
		public CrossReference getModelElementNamedElementCrossReference_1_2_0() { return cModelElementNamedElementCrossReference_1_2_0; }

		//ID
		public RuleCall getModelElementNamedElementIDTerminalRuleCall_1_2_0_1() { return cModelElementNamedElementIDTerminalRuleCall_1_2_0_1; }
	}

	public class APropertyReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.APropertyReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAPropertyReferenceAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cPropertyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cPropertyAbstractNamedValueCrossReference_2_0 = (CrossReference)cPropertyAssignment_2.eContents().get(0);
		private final RuleCall cPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1 = (RuleCall)cPropertyAbstractNamedValueCrossReference_2_0.eContents().get(1);
		
		//APropertyReference:
		//	{APropertyReference} '#' property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE];
		@Override public ParserRule getRule() { return rule; }

		//{APropertyReference} '#' property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public Group getGroup() { return cGroup; }

		//{APropertyReference}
		public Action getAPropertyReferenceAction_0() { return cAPropertyReferenceAction_0; }

		//'#'
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }

		//property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public Assignment getPropertyAssignment_2() { return cPropertyAssignment_2; }

		//[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public CrossReference getPropertyAbstractNamedValueCrossReference_2_0() { return cPropertyAbstractNamedValueCrossReference_2_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1() { return cPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1; }
	}

	public class AVariableReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AVariableReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAVariableReferenceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cVariableAVariableDeclarationCrossReference_1_0 = (CrossReference)cVariableAssignment_1.eContents().get(0);
		private final RuleCall cVariableAVariableDeclarationIDTerminalRuleCall_1_0_1 = (RuleCall)cVariableAVariableDeclarationCrossReference_1_0.eContents().get(1);
		
		//AVariableReference AExpression:
		//	{AVariableReference} variable=[AVariableDeclaration];
		@Override public ParserRule getRule() { return rule; }

		//{AVariableReference} variable=[AVariableDeclaration]
		public Group getGroup() { return cGroup; }

		//{AVariableReference}
		public Action getAVariableReferenceAction_0() { return cAVariableReferenceAction_0; }

		//variable=[AVariableDeclaration]
		public Assignment getVariableAssignment_1() { return cVariableAssignment_1; }

		//[AVariableDeclaration]
		public CrossReference getVariableAVariableDeclarationCrossReference_1_0() { return cVariableAVariableDeclarationCrossReference_1_0; }

		//ID
		public RuleCall getVariableAVariableDeclarationIDTerminalRuleCall_1_0_1() { return cVariableAVariableDeclarationIDTerminalRuleCall_1_0_1; }
	}

	public class ShowValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ShowValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cExpressionAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cExpressionAVariableReferenceParserRuleCall_0_0 = (RuleCall)cExpressionAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_1_0 = (Alternatives)cGroup_1.eContents().get(0);
		private final Assignment cConvertAssignment_1_0_0 = (Assignment)cAlternatives_1_0.eContents().get(0);
		private final Keyword cConvertPercentSignKeyword_1_0_0_0 = (Keyword)cConvertAssignment_1_0_0.eContents().get(0);
		private final Assignment cDropAssignment_1_0_1 = (Assignment)cAlternatives_1_0.eContents().get(1);
		private final Keyword cDropInKeyword_1_0_1_0 = (Keyword)cDropAssignment_1_0_1.eContents().get(0);
		private final Assignment cUnitAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_1_1_0 = (CrossReference)cUnitAssignment_1_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_1_0.eContents().get(1);
		
		//ShowValue AUnitExpression:
		//	expression=AVariableReference ((convert?='%' | drop?='in') unit=[aadl2::UnitLiteral])?;
		@Override public ParserRule getRule() { return rule; }

		////ref=[AVariableDeclaration|ID] ('%'|'in' unit=[aadl2::UnitLiteral|ID])?;	
		//expression=AVariableReference ((convert?='%' | drop?='in') unit=[aadl2::UnitLiteral])?
		public Group getGroup() { return cGroup; }

		////ref=[AVariableDeclaration|ID] ('%'|'in' unit=[aadl2::UnitLiteral|ID])?;	
		//expression=AVariableReference
		public Assignment getExpressionAssignment_0() { return cExpressionAssignment_0; }

		//AVariableReference
		public RuleCall getExpressionAVariableReferenceParserRuleCall_0_0() { return cExpressionAVariableReferenceParserRuleCall_0_0; }

		//((convert?='%' | drop?='in') unit=[aadl2::UnitLiteral])?
		public Group getGroup_1() { return cGroup_1; }

		//convert?='%' | drop?='in'
		public Alternatives getAlternatives_1_0() { return cAlternatives_1_0; }

		//convert?='%'
		public Assignment getConvertAssignment_1_0_0() { return cConvertAssignment_1_0_0; }

		//'%'
		public Keyword getConvertPercentSignKeyword_1_0_0_0() { return cConvertPercentSignKeyword_1_0_0_0; }

		//drop?='in'
		public Assignment getDropAssignment_1_0_1() { return cDropAssignment_1_0_1; }

		//'in'
		public Keyword getDropInKeyword_1_0_1_0() { return cDropInKeyword_1_0_1_0; }

		//unit=[aadl2::UnitLiteral]
		public Assignment getUnitAssignment_1_1() { return cUnitAssignment_1_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_1_0() { return cUnitUnitLiteralCrossReference_1_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_1_0_1; }
	}

	public class ImageReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ImageReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImgKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cImgfileAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cImgfileIMGREFParserRuleCall_1_0 = (RuleCall)cImgfileAssignment_1.eContents().get(0);
		
		//ImageReference:
		//	'img' imgfile=IMGREF;
		@Override public ParserRule getRule() { return rule; }

		//'img' imgfile=IMGREF
		public Group getGroup() { return cGroup; }

		//'img'
		public Keyword getImgKeyword_0() { return cImgKeyword_0; }

		//imgfile=IMGREF
		public Assignment getImgfileAssignment_1() { return cImgfileAssignment_1; }

		//IMGREF
		public RuleCall getImgfileIMGREFParserRuleCall_1_0() { return cImgfileIMGREFParserRuleCall_1_0; }
	}

	public class IMGREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.IMGREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cSolidusKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cIDTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//IMGREF:
		//	(ID '/')* ID '.' ID;
		@Override public ParserRule getRule() { return rule; }

		//(ID '/')* ID '.' ID
		public Group getGroup() { return cGroup; }

		//(ID '/')*
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//'/'
		public Keyword getSolidusKeyword_0_1() { return cSolidusKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//'.'
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//ID
		public RuleCall getIDTerminalRuleCall_3() { return cIDTerminalRuleCall_3; }
	}

	public class AExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AExpression");
		private final RuleCall cAOrExpressionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AExpression aadl2::PropertyExpression:
		//	AOrExpression;
		@Override public ParserRule getRule() { return rule; }

		//AOrExpression
		public RuleCall getAOrExpressionParserRuleCall() { return cAOrExpressionParserRuleCall; }
	}

	public class AOrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AOrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpOrParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAAndExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//AOrExpression aadl2::PropertyExpression:
		//	AAndExpression (=> ({ABinaryOperation.left=current} operator=OpOr) right=AAndExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AAndExpression (=> ({ABinaryOperation.left=current} operator=OpOr) right=AAndExpression)*
		public Group getGroup() { return cGroup; }

		//AAndExpression
		public RuleCall getAAndExpressionParserRuleCall_0() { return cAAndExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.left=current} operator=OpOr) right=AAndExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.left=current} operator=OpOr)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.left=current} operator=OpOr
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.left=current}
		public Action getABinaryOperationLeftAction_1_0_0_0() { return cABinaryOperationLeftAction_1_0_0_0; }

		//operator=OpOr
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }

		//OpOr
		public RuleCall getOperatorOpOrParserRuleCall_1_0_0_1_0() { return cOperatorOpOrParserRuleCall_1_0_0_1_0; }

		//right=AAndExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//AAndExpression
		public RuleCall getRightAAndExpressionParserRuleCall_1_1_0() { return cRightAAndExpressionParserRuleCall_1_1_0; }
	}

	public class OpOrElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.OpOr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cOrKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cVerticalLineVerticalLineKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpOr Operation:
		//	'or' | '||';
		@Override public ParserRule getRule() { return rule; }

		//'or' | '||'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'or'
		public Keyword getOrKeyword_0() { return cOrKeyword_0; }

		//'||'
		public Keyword getVerticalLineVerticalLineKeyword_1() { return cVerticalLineVerticalLineKeyword_1; }
	}

	public class AAndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AAndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAEqualityExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpAndParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAEqualityExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//AAndExpression aadl2::PropertyExpression:
		//	AEqualityExpression (=> ({ABinaryOperation.left=current} operator=OpAnd) right=AEqualityExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AEqualityExpression (=> ({ABinaryOperation.left=current} operator=OpAnd) right=AEqualityExpression)*
		public Group getGroup() { return cGroup; }

		//AEqualityExpression
		public RuleCall getAEqualityExpressionParserRuleCall_0() { return cAEqualityExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.left=current} operator=OpAnd) right=AEqualityExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.left=current} operator=OpAnd)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.left=current} operator=OpAnd
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.left=current}
		public Action getABinaryOperationLeftAction_1_0_0_0() { return cABinaryOperationLeftAction_1_0_0_0; }

		//operator=OpAnd
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }

		//OpAnd
		public RuleCall getOperatorOpAndParserRuleCall_1_0_0_1_0() { return cOperatorOpAndParserRuleCall_1_0_0_1_0; }

		//right=AEqualityExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//AEqualityExpression
		public RuleCall getRightAEqualityExpressionParserRuleCall_1_1_0() { return cRightAEqualityExpressionParserRuleCall_1_1_0; }
	}

	public class OpAndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.OpAnd");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAndKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAmpersandAmpersandKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpAnd Operation:
		//	'and' | '&&';
		@Override public ParserRule getRule() { return rule; }

		//'and' | '&&'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'and'
		public Keyword getAndKeyword_0() { return cAndKeyword_0; }

		//'&&'
		public Keyword getAmpersandAmpersandKeyword_1() { return cAmpersandAmpersandKeyword_1; }
	}

	public class AEqualityExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AEqualityExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cARelationalExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpEqualityParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightARelationalExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//AEqualityExpression aadl2::PropertyExpression:
		//	ARelationalExpression (=> ({ABinaryOperation.left=current} operator=OpEquality) right=ARelationalExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//ARelationalExpression (=> ({ABinaryOperation.left=current} operator=OpEquality) right=ARelationalExpression)*
		public Group getGroup() { return cGroup; }

		//ARelationalExpression
		public RuleCall getARelationalExpressionParserRuleCall_0() { return cARelationalExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.left=current} operator=OpEquality) right=ARelationalExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.left=current} operator=OpEquality)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.left=current} operator=OpEquality
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.left=current}
		public Action getABinaryOperationLeftAction_1_0_0_0() { return cABinaryOperationLeftAction_1_0_0_0; }

		//operator=OpEquality
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }

		//OpEquality
		public RuleCall getOperatorOpEqualityParserRuleCall_1_0_0_1_0() { return cOperatorOpEqualityParserRuleCall_1_0_0_1_0; }

		//right=ARelationalExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//ARelationalExpression
		public RuleCall getRightARelationalExpressionParserRuleCall_1_1_0() { return cRightARelationalExpressionParserRuleCall_1_1_0; }
	}

	public class OpEqualityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.OpEquality");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cEqualsSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cExclamationMarkEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpEquality Operation:
		//	'==' | '!=';
		@Override public ParserRule getRule() { return rule; }

		//'==' | '!='
		public Alternatives getAlternatives() { return cAlternatives; }

		//'=='
		public Keyword getEqualsSignEqualsSignKeyword_0() { return cEqualsSignEqualsSignKeyword_0; }

		//'!='
		public Keyword getExclamationMarkEqualsSignKeyword_1() { return cExclamationMarkEqualsSignKeyword_1; }
	}

	public class ARelationalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ARelationalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAAdditiveExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpCompareParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAAdditiveExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//ARelationalExpression aadl2::PropertyExpression:
		//	AAdditiveExpression (=> ({ABinaryOperation.left=current} operator=OpCompare) right=AAdditiveExpression)*;
		@Override public ParserRule getRule() { return rule; }

		////	AOtherOperatorExpression
		////	( =>({ABinaryOperation.leftOperand=current} feature=OpCompare) rightOperand=AOtherOperatorExpression)*;
		//AAdditiveExpression (=> ({ABinaryOperation.left=current} operator=OpCompare) right=AAdditiveExpression)*
		public Group getGroup() { return cGroup; }

		////	AOtherOperatorExpression
		////	( =>({ABinaryOperation.leftOperand=current} feature=OpCompare) rightOperand=AOtherOperatorExpression)*;
		//AAdditiveExpression
		public RuleCall getAAdditiveExpressionParserRuleCall_0() { return cAAdditiveExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.left=current} operator=OpCompare) right=AAdditiveExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.left=current} operator=OpCompare)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.left=current} operator=OpCompare
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.left=current}
		public Action getABinaryOperationLeftAction_1_0_0_0() { return cABinaryOperationLeftAction_1_0_0_0; }

		//operator=OpCompare
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }

		//OpCompare
		public RuleCall getOperatorOpCompareParserRuleCall_1_0_0_1_0() { return cOperatorOpCompareParserRuleCall_1_0_0_1_0; }

		//right=AAdditiveExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//AAdditiveExpression
		public RuleCall getRightAAdditiveExpressionParserRuleCall_1_1_0() { return cRightAAdditiveExpressionParserRuleCall_1_1_0; }
	}

	public class OpCompareElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.OpCompare");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cGreaterThanSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cLessThanSignEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cLessThanSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cGreaterThanSignLessThanSignKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		
		//OpCompare Operation:
		//	'>=' | '<=' | '>' | '<' | '><';
		@Override public ParserRule getRule() { return rule; }

		//'>=' | '<=' | '>' | '<' | '><'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'>='
		public Keyword getGreaterThanSignEqualsSignKeyword_0() { return cGreaterThanSignEqualsSignKeyword_0; }

		//'<='
		public Keyword getLessThanSignEqualsSignKeyword_1() { return cLessThanSignEqualsSignKeyword_1; }

		//'>'
		public Keyword getGreaterThanSignKeyword_2() { return cGreaterThanSignKeyword_2; }

		//'<'
		public Keyword getLessThanSignKeyword_3() { return cLessThanSignKeyword_3; }

		//'><'
		public Keyword getGreaterThanSignLessThanSignKeyword_4() { return cGreaterThanSignLessThanSignKeyword_4; }
	}

	public class AAdditiveExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AAdditiveExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAMultiplicativeExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpAddParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAMultiplicativeExpressionParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		////AOtherOperatorExpression returns aadl2::PropertyExpression:
		////	AAdditiveExpression (=>({ABinaryOperation.leftOperand=current} feature=OpOther)
		////	rightOperand=AAdditiveExpression)*;
		////
		////OpOther:
		////	  '->' 
		////	| '..<'
		////	| '>' '..'
		////	| '..'
		////	| '=>' 
		////	| '>' (=>('>' '>') | '>') 
		////	| '<' (=>('<' '<') | '<' | '=>')
		////	| '<>'
		////	| '?:';
		//AAdditiveExpression aadl2::PropertyExpression:
		//	AMultiplicativeExpression (=> ({ABinaryOperation.left=current} operator=OpAdd) right=AMultiplicativeExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AMultiplicativeExpression (=> ({ABinaryOperation.left=current} operator=OpAdd) right=AMultiplicativeExpression)*
		public Group getGroup() { return cGroup; }

		//AMultiplicativeExpression
		public RuleCall getAMultiplicativeExpressionParserRuleCall_0() { return cAMultiplicativeExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.left=current} operator=OpAdd) right=AMultiplicativeExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.left=current} operator=OpAdd)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.left=current} operator=OpAdd
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.left=current}
		public Action getABinaryOperationLeftAction_1_0_0_0() { return cABinaryOperationLeftAction_1_0_0_0; }

		//operator=OpAdd
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }

		//OpAdd
		public RuleCall getOperatorOpAddParserRuleCall_1_0_0_1_0() { return cOperatorOpAddParserRuleCall_1_0_0_1_0; }

		//right=AMultiplicativeExpression
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//AMultiplicativeExpression
		public RuleCall getRightAMultiplicativeExpressionParserRuleCall_1_1_0() { return cRightAMultiplicativeExpressionParserRuleCall_1_1_0; }
	}

	public class OpAddElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.OpAdd");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpAdd Operation:
		//	'+' | '-';
		@Override public ParserRule getRule() { return rule; }

		//'+' | '-'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'+'
		public Keyword getPlusSignKeyword_0() { return cPlusSignKeyword_0; }

		//'-'
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
	}

	public class AMultiplicativeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AMultiplicativeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAUnaryOperationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cOperatorAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cOperatorOpMultiParserRuleCall_1_0_0_1_0 = (RuleCall)cOperatorAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightAUnaryOperationParserRuleCall_1_1_0 = (RuleCall)cRightAssignment_1_1.eContents().get(0);
		
		//AMultiplicativeExpression aadl2::PropertyExpression:
		//	AUnaryOperation (=> ({ABinaryOperation.left=current} operator=OpMulti) right=AUnaryOperation)*;
		@Override public ParserRule getRule() { return rule; }

		//AUnaryOperation (=> ({ABinaryOperation.left=current} operator=OpMulti) right=AUnaryOperation)*
		public Group getGroup() { return cGroup; }

		//AUnaryOperation
		public RuleCall getAUnaryOperationParserRuleCall_0() { return cAUnaryOperationParserRuleCall_0; }

		//(=> ({ABinaryOperation.left=current} operator=OpMulti) right=AUnaryOperation)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.left=current} operator=OpMulti)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.left=current} operator=OpMulti
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.left=current}
		public Action getABinaryOperationLeftAction_1_0_0_0() { return cABinaryOperationLeftAction_1_0_0_0; }

		//operator=OpMulti
		public Assignment getOperatorAssignment_1_0_0_1() { return cOperatorAssignment_1_0_0_1; }

		//OpMulti
		public RuleCall getOperatorOpMultiParserRuleCall_1_0_0_1_0() { return cOperatorOpMultiParserRuleCall_1_0_0_1_0; }

		//right=AUnaryOperation
		public Assignment getRightAssignment_1_1() { return cRightAssignment_1_1; }

		//AUnaryOperation
		public RuleCall getRightAUnaryOperationParserRuleCall_1_1_0() { return cRightAUnaryOperationParserRuleCall_1_1_0; }
	}

	public class OpMultiElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.OpMulti");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAsteriskKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cSolidusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cDivKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cModKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//OpMulti Operation:
		//	'*' | '/' | 'div' | 'mod';
		@Override public ParserRule getRule() { return rule; }

		//'*' | '/' | 'div' | 'mod'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'*'
		public Keyword getAsteriskKeyword_0() { return cAsteriskKeyword_0; }

		//'/'
		public Keyword getSolidusKeyword_1() { return cSolidusKeyword_1; }

		//'div'
		public Keyword getDivKeyword_2() { return cDivKeyword_2; }

		//'mod'
		public Keyword getModKeyword_3() { return cModKeyword_3; }
	}

	public class AUnaryOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AUnaryOperation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cAUnaryOperationAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cOperatorAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cOperatorOpUnaryParserRuleCall_0_1_0 = (RuleCall)cOperatorAssignment_0_1.eContents().get(0);
		private final Assignment cOperandAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOperandAUnaryOperationParserRuleCall_0_2_0 = (RuleCall)cOperandAssignment_0_2.eContents().get(0);
		private final RuleCall cAUnitExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AUnaryOperation aadl2::PropertyExpression:
		//	{AUnaryOperation} => operator=OpUnary operand=AUnaryOperation | AUnitExpression;
		@Override public ParserRule getRule() { return rule; }

		//{AUnaryOperation} => operator=OpUnary operand=AUnaryOperation | AUnitExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//{AUnaryOperation} => operator=OpUnary operand=AUnaryOperation
		public Group getGroup_0() { return cGroup_0; }

		//{AUnaryOperation}
		public Action getAUnaryOperationAction_0_0() { return cAUnaryOperationAction_0_0; }

		//=> operator=OpUnary
		public Assignment getOperatorAssignment_0_1() { return cOperatorAssignment_0_1; }

		//OpUnary
		public RuleCall getOperatorOpUnaryParserRuleCall_0_1_0() { return cOperatorOpUnaryParserRuleCall_0_1_0; }

		//operand=AUnaryOperation
		public Assignment getOperandAssignment_0_2() { return cOperandAssignment_0_2; }

		//AUnaryOperation
		public RuleCall getOperandAUnaryOperationParserRuleCall_0_2_0() { return cOperandAUnaryOperationParserRuleCall_0_2_0; }

		//AUnitExpression
		public RuleCall getAUnitExpressionParserRuleCall_1() { return cAUnitExpressionParserRuleCall_1; }
	}

	public class OpUnaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.OpUnary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cNotKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cPlusSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//OpUnary Operation:
		//	"not" | "-" | "+";
		@Override public ParserRule getRule() { return rule; }

		//"not" | "-" | "+"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"not"
		public Keyword getNotKeyword_0() { return cNotKeyword_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }

		//"+"
		public Keyword getPlusSignKeyword_2() { return cPlusSignKeyword_2; }
	}

	public class AUnitExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AUnitExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAPrimaryExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAUnitExpressionExpressionAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cConvertAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final Keyword cConvertPercentSignKeyword_1_1_0_0 = (Keyword)cConvertAssignment_1_1_0.eContents().get(0);
		private final Assignment cDropAssignment_1_1_1 = (Assignment)cAlternatives_1_1.eContents().get(1);
		private final Keyword cDropInKeyword_1_1_1_0 = (Keyword)cDropAssignment_1_1_1.eContents().get(0);
		private final Assignment cUnitAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cUnitUnitLiteralCrossReference_1_2_0 = (CrossReference)cUnitAssignment_1_2.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_2_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_2_0.eContents().get(1);
		
		//AUnitExpression aadl2::PropertyExpression:
		//	APrimaryExpression ({AUnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?;
		@Override public ParserRule getRule() { return rule; }

		//APrimaryExpression ({AUnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?
		public Group getGroup() { return cGroup; }

		//APrimaryExpression
		public RuleCall getAPrimaryExpressionParserRuleCall_0() { return cAPrimaryExpressionParserRuleCall_0; }

		//({AUnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?
		public Group getGroup_1() { return cGroup_1; }

		//{AUnitExpression.expression=current}
		public Action getAUnitExpressionExpressionAction_1_0() { return cAUnitExpressionExpressionAction_1_0; }

		//(convert?='%' | drop?='in')?
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//convert?='%'
		public Assignment getConvertAssignment_1_1_0() { return cConvertAssignment_1_1_0; }

		//'%'
		public Keyword getConvertPercentSignKeyword_1_1_0_0() { return cConvertPercentSignKeyword_1_1_0_0; }

		//drop?='in'
		public Assignment getDropAssignment_1_1_1() { return cDropAssignment_1_1_1; }

		//'in'
		public Keyword getDropInKeyword_1_1_1_0() { return cDropInKeyword_1_1_1_0; }

		//unit=[aadl2::UnitLiteral]
		public Assignment getUnitAssignment_1_2() { return cUnitAssignment_1_2; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_2_0() { return cUnitUnitLiteralCrossReference_1_2_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_2_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_2_0_1; }
	}

	public class APrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.APrimaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cALiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAVariableReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cAModelOrPropertyReferenceParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cAFunctionCallParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cARangeExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cAIfExpressionParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cAParenthesizedExpressionParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		
		//APrimaryExpression aadl2::PropertyExpression:
		//	ALiteral | AVariableReference | AModelOrPropertyReference | AFunctionCall | ARangeExpression | AIfExpression
		//	| AParenthesizedExpression;
		@Override public ParserRule getRule() { return rule; }

		//ALiteral | AVariableReference | AModelOrPropertyReference | AFunctionCall | ARangeExpression | AIfExpression |
		//AParenthesizedExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//ALiteral
		public RuleCall getALiteralParserRuleCall_0() { return cALiteralParserRuleCall_0; }

		//AVariableReference
		public RuleCall getAVariableReferenceParserRuleCall_1() { return cAVariableReferenceParserRuleCall_1; }

		//AModelOrPropertyReference
		public RuleCall getAModelOrPropertyReferenceParserRuleCall_2() { return cAModelOrPropertyReferenceParserRuleCall_2; }

		//AFunctionCall
		public RuleCall getAFunctionCallParserRuleCall_3() { return cAFunctionCallParserRuleCall_3; }

		//ARangeExpression
		public RuleCall getARangeExpressionParserRuleCall_4() { return cARangeExpressionParserRuleCall_4; }

		//AIfExpression
		public RuleCall getAIfExpressionParserRuleCall_5() { return cAIfExpressionParserRuleCall_5; }

		//AParenthesizedExpression
		public RuleCall getAParenthesizedExpressionParserRuleCall_6() { return cAParenthesizedExpressionParserRuleCall_6; }
	}

	public class AFunctionCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AFunctionCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAFunctionCallAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cFunctionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFunctionQualifiedNameParserRuleCall_1_0 = (RuleCall)cFunctionAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cArgumentsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cArgumentsAExpressionParserRuleCall_3_0_0 = (RuleCall)cArgumentsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cArgumentsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cArgumentsAExpressionParserRuleCall_3_1_1_0 = (RuleCall)cArgumentsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//AFunctionCall aadl2::PropertyExpression:
		//	{AFunctionCall} function=QualifiedName '(' (arguments+=AExpression (',' arguments+=AExpression)*)? ')';
		@Override public ParserRule getRule() { return rule; }

		//{AFunctionCall} function=QualifiedName '(' (arguments+=AExpression (',' arguments+=AExpression)*)? ')'
		public Group getGroup() { return cGroup; }

		//{AFunctionCall}
		public Action getAFunctionCallAction_0() { return cAFunctionCallAction_0; }

		//function=QualifiedName
		public Assignment getFunctionAssignment_1() { return cFunctionAssignment_1; }

		//QualifiedName
		public RuleCall getFunctionQualifiedNameParserRuleCall_1_0() { return cFunctionQualifiedNameParserRuleCall_1_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//(arguments+=AExpression (',' arguments+=AExpression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//arguments+=AExpression
		public Assignment getArgumentsAssignment_3_0() { return cArgumentsAssignment_3_0; }

		//AExpression
		public RuleCall getArgumentsAExpressionParserRuleCall_3_0_0() { return cArgumentsAExpressionParserRuleCall_3_0_0; }

		//(',' arguments+=AExpression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//arguments+=AExpression
		public Assignment getArgumentsAssignment_3_1_1() { return cArgumentsAssignment_3_1_1; }

		//AExpression
		public RuleCall getArgumentsAExpressionParserRuleCall_3_1_1_0() { return cArgumentsAExpressionParserRuleCall_3_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_4() { return cRightParenthesisKeyword_4; }
	}

	public class ARangeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ARangeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cARangeAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cMinimumAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMinimumAExpressionParserRuleCall_2_0 = (RuleCall)cMinimumAssignment_2.eContents().get(0);
		private final Keyword cFullStopFullStopKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cMaximumAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cMaximumAExpressionParserRuleCall_4_0 = (RuleCall)cMaximumAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cDeltaKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cDeltaAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cDeltaAExpressionParserRuleCall_5_1_0 = (RuleCall)cDeltaAssignment_5_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//ARangeExpression aadl2::PropertyExpression:
		//	{ARange} '[' minimum=AExpression '..' maximum=AExpression (=> 'delta' delta=AExpression)? ']';
		@Override public ParserRule getRule() { return rule; }

		//{ARange} '[' minimum=AExpression '..' maximum=AExpression (=> 'delta' delta=AExpression)? ']'
		public Group getGroup() { return cGroup; }

		//{ARange}
		public Action getARangeAction_0() { return cARangeAction_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//minimum=AExpression
		public Assignment getMinimumAssignment_2() { return cMinimumAssignment_2; }

		//AExpression
		public RuleCall getMinimumAExpressionParserRuleCall_2_0() { return cMinimumAExpressionParserRuleCall_2_0; }

		//'..'
		public Keyword getFullStopFullStopKeyword_3() { return cFullStopFullStopKeyword_3; }

		//maximum=AExpression
		public Assignment getMaximumAssignment_4() { return cMaximumAssignment_4; }

		//AExpression
		public RuleCall getMaximumAExpressionParserRuleCall_4_0() { return cMaximumAExpressionParserRuleCall_4_0; }

		//(=> 'delta' delta=AExpression)?
		public Group getGroup_5() { return cGroup_5; }

		//=> 'delta'
		public Keyword getDeltaKeyword_5_0() { return cDeltaKeyword_5_0; }

		//delta=AExpression
		public Assignment getDeltaAssignment_5_1() { return cDeltaAssignment_5_1; }

		//AExpression
		public RuleCall getDeltaAExpressionParserRuleCall_5_1_0() { return cDeltaAExpressionParserRuleCall_5_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class AIfExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AIfExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAConditionalAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cIfKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIfAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIfAExpressionParserRuleCall_2_0 = (RuleCall)cIfAssignment_2.eContents().get(0);
		private final Keyword cThenKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cThenAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cThenAExpressionParserRuleCall_4_0 = (RuleCall)cThenAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cElseKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cElseAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cElseAExpressionParserRuleCall_5_1_0 = (RuleCall)cElseAssignment_5_1.eContents().get(0);
		private final Keyword cEndifKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//AIfExpression aadl2::PropertyExpression:
		//	{AConditional} 'if' if=AExpression 'then' then=AExpression ('else' else=AExpression)? 'endif';
		@Override public ParserRule getRule() { return rule; }

		//{AConditional} 'if' if=AExpression 'then' then=AExpression ('else' else=AExpression)? 'endif'
		public Group getGroup() { return cGroup; }

		//{AConditional}
		public Action getAConditionalAction_0() { return cAConditionalAction_0; }

		//'if'
		public Keyword getIfKeyword_1() { return cIfKeyword_1; }

		//if=AExpression
		public Assignment getIfAssignment_2() { return cIfAssignment_2; }

		//AExpression
		public RuleCall getIfAExpressionParserRuleCall_2_0() { return cIfAExpressionParserRuleCall_2_0; }

		//'then'
		public Keyword getThenKeyword_3() { return cThenKeyword_3; }

		//then=AExpression
		public Assignment getThenAssignment_4() { return cThenAssignment_4; }

		//AExpression
		public RuleCall getThenAExpressionParserRuleCall_4_0() { return cThenAExpressionParserRuleCall_4_0; }

		//('else' else=AExpression)?
		public Group getGroup_5() { return cGroup_5; }

		//'else'
		public Keyword getElseKeyword_5_0() { return cElseKeyword_5_0; }

		//else=AExpression
		public Assignment getElseAssignment_5_1() { return cElseAssignment_5_1; }

		//AExpression
		public RuleCall getElseAExpressionParserRuleCall_5_1_0() { return cElseAExpressionParserRuleCall_5_1_0; }

		//'endif'
		public Keyword getEndifKeyword_6() { return cEndifKeyword_6; }
	}

	public class ALiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ALiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cABooleanLiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cARealTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cAIntegerTermParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cStringTermParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//ALiteral aadl2::PropertyExpression:
		//	ABooleanLiteral | ARealTerm | AIntegerTerm | StringTerm;
		@Override public ParserRule getRule() { return rule; }

		////	ASetTerm | AListTerm |
		//ABooleanLiteral | ARealTerm | AIntegerTerm | StringTerm
		public Alternatives getAlternatives() { return cAlternatives; }

		////	ASetTerm | AListTerm |
		//ABooleanLiteral
		public RuleCall getABooleanLiteralParserRuleCall_0() { return cABooleanLiteralParserRuleCall_0; }

		//ARealTerm
		public RuleCall getARealTermParserRuleCall_1() { return cARealTermParserRuleCall_1; }

		//AIntegerTerm
		public RuleCall getAIntegerTermParserRuleCall_2() { return cAIntegerTermParserRuleCall_2; }

		//StringTerm
		public RuleCall getStringTermParserRuleCall_3() { return cStringTermParserRuleCall_3; }
	}

	public class AIntegerTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AIntegerTerm");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueAIntParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//AIntegerTerm aadl2::IntegerLiteral:
		//	value=AInt;
		@Override public ParserRule getRule() { return rule; }

		//value=AInt
		public Assignment getValueAssignment() { return cValueAssignment; }

		//AInt
		public RuleCall getValueAIntParserRuleCall_0() { return cValueAIntParserRuleCall_0; }
	}

	public class AIntElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AInt");
		private final RuleCall cINTTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AInt aadl2::Integer:
		//	INT;
		@Override public ParserRule getRule() { return rule; }

		//INT
		public RuleCall getINTTerminalRuleCall() { return cINTTerminalRuleCall; }
	}

	public class ARealTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ARealTerm");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueARealParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//ARealTerm aadl2::RealLiteral:
		//	value=AReal;
		@Override public ParserRule getRule() { return rule; }

		//value=AReal
		public Assignment getValueAssignment() { return cValueAssignment; }

		//AReal
		public RuleCall getValueARealParserRuleCall_0() { return cValueARealParserRuleCall_0; }
	}

	public class ARealElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AReal");
		private final RuleCall cREAL_LITTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AReal aadl2::Real:
		//	REAL_LIT;
		@Override public ParserRule getRule() { return rule; }

		//REAL_LIT
		public RuleCall getREAL_LITTerminalRuleCall() { return cREAL_LITTerminalRuleCall; }
	}

	public class ABooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ABooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cValueTrueKeyword_1_0_0 = (Keyword)cValueAssignment_1_0.eContents().get(0);
		private final Keyword cFalseKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		////ASetTerm returns aadl2::PropertyExpression:
		////	{ASetLiteral}  '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
		////;
		////
		////AListTerm returns aadl2::PropertyExpression:
		////	{AListTerm} '[' (elements+=AExpression (',' elements+=AExpression )*)? ']'
		////;
		//ABooleanLiteral aadl2::PropertyExpression:
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

	public class StringTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.StringTerm");
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.NoQuoteString");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//NoQuoteString:
		//	STRING;
		@Override public ParserRule getRule() { return rule; }

		//// remove quotes from string in ValueConverter
		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}

	public class AParenthesizedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AParenthesizedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cAExpressionParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//AParenthesizedExpression aadl2::PropertyExpression:
		//	'(' AExpression ')';
		@Override public ParserRule getRule() { return rule; }

		//'(' AExpression ')'
		public Group getGroup() { return cGroup; }

		//'('
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//AExpression
		public RuleCall getAExpressionParserRuleCall_1() { return cAExpressionParserRuleCall_1; }

		//')'
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}

	public class ComponentCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ComponentCategory");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAbstractKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cBusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cDataKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cDeviceKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cMemoryKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cProcessKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		private final Keyword cProcessorKeyword_6 = (Keyword)cAlternatives.eContents().get(6);
		private final Keyword cSubprogramKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Group cGroup_8 = (Group)cAlternatives.eContents().get(8);
		private final Keyword cSubprogramKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cGroupKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cSystemKeyword_9 = (Keyword)cAlternatives.eContents().get(9);
		private final Group cGroup_10 = (Group)cAlternatives.eContents().get(10);
		private final Keyword cThreadKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Keyword cGroupKeyword_10_1 = (Keyword)cGroup_10.eContents().get(1);
		private final Keyword cThreadKeyword_11 = (Keyword)cAlternatives.eContents().get(11);
		private final Group cGroup_12 = (Group)cAlternatives.eContents().get(12);
		private final Keyword cVirtualKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Keyword cBusKeyword_12_1 = (Keyword)cGroup_12.eContents().get(1);
		private final Group cGroup_13 = (Group)cAlternatives.eContents().get(13);
		private final Keyword cVirtualKeyword_13_0 = (Keyword)cGroup_13.eContents().get(0);
		private final Keyword cProcessorKeyword_13_1 = (Keyword)cGroup_13.eContents().get(1);
		
		//ComponentCategory aadl2::ComponentCategory:
		//	'abstract' | 'bus' | 'data'
		//	| 'device' | 'memory' | 'process' | 'processor' | 'subprogram'
		//	| 'subprogram' 'group' | 'system' | 'thread' 'group'
		//	| 'thread' | 'virtual' 'bus' | 'virtual' 'processor';
		@Override public ParserRule getRule() { return rule; }

		//'abstract' | 'bus' | 'data' | 'device' | 'memory' | 'process' | 'processor' | 'subprogram' | 'subprogram' 'group' |
		//'system' | 'thread' 'group' | 'thread' | 'virtual' 'bus' | 'virtual' 'processor'
		public Alternatives getAlternatives() { return cAlternatives; }

		//'abstract'
		public Keyword getAbstractKeyword_0() { return cAbstractKeyword_0; }

		//'bus'
		public Keyword getBusKeyword_1() { return cBusKeyword_1; }

		//'data'
		public Keyword getDataKeyword_2() { return cDataKeyword_2; }

		//'device'
		public Keyword getDeviceKeyword_3() { return cDeviceKeyword_3; }

		//'memory'
		public Keyword getMemoryKeyword_4() { return cMemoryKeyword_4; }

		//'process'
		public Keyword getProcessKeyword_5() { return cProcessKeyword_5; }

		//'processor'
		public Keyword getProcessorKeyword_6() { return cProcessorKeyword_6; }

		//'subprogram'
		public Keyword getSubprogramKeyword_7() { return cSubprogramKeyword_7; }

		//'subprogram' 'group'
		public Group getGroup_8() { return cGroup_8; }

		//'subprogram'
		public Keyword getSubprogramKeyword_8_0() { return cSubprogramKeyword_8_0; }

		//'group'
		public Keyword getGroupKeyword_8_1() { return cGroupKeyword_8_1; }

		//'system'
		public Keyword getSystemKeyword_9() { return cSystemKeyword_9; }

		//'thread' 'group'
		public Group getGroup_10() { return cGroup_10; }

		//'thread'
		public Keyword getThreadKeyword_10_0() { return cThreadKeyword_10_0; }

		//'group'
		public Keyword getGroupKeyword_10_1() { return cGroupKeyword_10_1; }

		//'thread'
		public Keyword getThreadKeyword_11() { return cThreadKeyword_11; }

		//'virtual' 'bus'
		public Group getGroup_12() { return cGroup_12; }

		//'virtual'
		public Keyword getVirtualKeyword_12_0() { return cVirtualKeyword_12_0; }

		//'bus'
		public Keyword getBusKeyword_12_1() { return cBusKeyword_12_1; }

		//'virtual' 'processor'
		public Group getGroup_13() { return cGroup_13; }

		//'virtual'
		public Keyword getVirtualKeyword_13_0() { return cVirtualKeyword_13_0; }

		//'processor'
		public Keyword getProcessorKeyword_13_1() { return cProcessorKeyword_13_1; }
	}

	public class AadlClassifierReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AadlClassifierReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cFullStopKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		
		//// Qualified classifier reference
		//AadlClassifierReference:
		//	ID ('::' ID)+ ('.' ID)?;
		@Override public ParserRule getRule() { return rule; }

		//ID ('::' ID)+ ('.' ID)?
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//('::' ID)+
		public Group getGroup_1() { return cGroup_1; }

		//'::'
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }

		//('.' ID)?
		public Group getGroup_2() { return cGroup_2; }

		//'.'
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }
	}

	public class AADLPROPERTYREFERENCEElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.AADLPROPERTYREFERENCE");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//AADLPROPERTYREFERENCE:
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

	public class URIIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.URIID");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//URIID:
		//	STRING;
		@Override public ParserRule getRule() { return rule; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}

	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		////terminal URIID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'#'|'@'|'/'|':')*;
		//QualifiedName:
		//	ID ('.' ID)*;
		@Override public ParserRule getRule() { return rule; }

		//ID ('.' ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//('.' ID)*
		public Group getGroup_1() { return cGroup_1; }

		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}

	public class ThisKeywordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.ThisKeyword");
		private final Keyword cThisKeyword = (Keyword)rule.eContents().get(1);
		
		//ThisKeyword:
		//	'this';
		@Override public ParserRule getRule() { return rule; }

		//'this'
		public Keyword getThisKeyword() { return cThisKeyword; }
	}
	
	
	public class OperationElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.Operation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cOREnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cOROrKeyword_0_0 = (Keyword)cOREnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cALT_OREnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cALT_ORVerticalLineVerticalLineKeyword_1_0 = (Keyword)cALT_OREnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cANDEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cANDAndKeyword_2_0 = (Keyword)cANDEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cALT_ANDEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cALT_ANDAmpersandAmpersandKeyword_3_0 = (Keyword)cALT_ANDEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cEQEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cEQEqualsSignEqualsSignKeyword_4_0 = (Keyword)cEQEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cNEQEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cNEQExclamationMarkEqualsSignKeyword_5_0 = (Keyword)cNEQEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cGEQEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cGEQGreaterThanSignEqualsSignKeyword_6_0 = (Keyword)cGEQEnumLiteralDeclaration_6.eContents().get(0);
		private final EnumLiteralDeclaration cLEQEnumLiteralDeclaration_7 = (EnumLiteralDeclaration)cAlternatives.eContents().get(7);
		private final Keyword cLEQLessThanSignEqualsSignKeyword_7_0 = (Keyword)cLEQEnumLiteralDeclaration_7.eContents().get(0);
		private final EnumLiteralDeclaration cGTEnumLiteralDeclaration_8 = (EnumLiteralDeclaration)cAlternatives.eContents().get(8);
		private final Keyword cGTGreaterThanSignKeyword_8_0 = (Keyword)cGTEnumLiteralDeclaration_8.eContents().get(0);
		private final EnumLiteralDeclaration cLTEnumLiteralDeclaration_9 = (EnumLiteralDeclaration)cAlternatives.eContents().get(9);
		private final Keyword cLTLessThanSignKeyword_9_0 = (Keyword)cLTEnumLiteralDeclaration_9.eContents().get(0);
		private final EnumLiteralDeclaration cINEnumLiteralDeclaration_10 = (EnumLiteralDeclaration)cAlternatives.eContents().get(10);
		private final Keyword cINGreaterThanSignLessThanSignKeyword_10_0 = (Keyword)cINEnumLiteralDeclaration_10.eContents().get(0);
		private final EnumLiteralDeclaration cPLUSEnumLiteralDeclaration_11 = (EnumLiteralDeclaration)cAlternatives.eContents().get(11);
		private final Keyword cPLUSPlusSignKeyword_11_0 = (Keyword)cPLUSEnumLiteralDeclaration_11.eContents().get(0);
		private final EnumLiteralDeclaration cMINUSEnumLiteralDeclaration_12 = (EnumLiteralDeclaration)cAlternatives.eContents().get(12);
		private final Keyword cMINUSHyphenMinusKeyword_12_0 = (Keyword)cMINUSEnumLiteralDeclaration_12.eContents().get(0);
		private final EnumLiteralDeclaration cMULTEnumLiteralDeclaration_13 = (EnumLiteralDeclaration)cAlternatives.eContents().get(13);
		private final Keyword cMULTAsteriskKeyword_13_0 = (Keyword)cMULTEnumLiteralDeclaration_13.eContents().get(0);
		private final EnumLiteralDeclaration cDIVEnumLiteralDeclaration_14 = (EnumLiteralDeclaration)cAlternatives.eContents().get(14);
		private final Keyword cDIVSolidusKeyword_14_0 = (Keyword)cDIVEnumLiteralDeclaration_14.eContents().get(0);
		private final EnumLiteralDeclaration cINTDIVEnumLiteralDeclaration_15 = (EnumLiteralDeclaration)cAlternatives.eContents().get(15);
		private final Keyword cINTDIVDivKeyword_15_0 = (Keyword)cINTDIVEnumLiteralDeclaration_15.eContents().get(0);
		private final EnumLiteralDeclaration cMODEnumLiteralDeclaration_16 = (EnumLiteralDeclaration)cAlternatives.eContents().get(16);
		private final Keyword cMODModKeyword_16_0 = (Keyword)cMODEnumLiteralDeclaration_16.eContents().get(0);
		private final EnumLiteralDeclaration cNOTEnumLiteralDeclaration_17 = (EnumLiteralDeclaration)cAlternatives.eContents().get(17);
		private final Keyword cNOTNotKeyword_17_0 = (Keyword)cNOTEnumLiteralDeclaration_17.eContents().get(0);
		
		//enum Operation:
		//	OR='or' | ALT_OR='||'
		//	| AND='and' | ALT_AND='&&'
		//	| EQ='==' | NEQ='!='
		//	| GEQ='>=' | LEQ='<=' | GT='>' | LT='<' | IN='><'
		//	| PLUS='+' | MINUS='-'
		//	| MULT='*' | DIV='/' | INTDIV='div' | MOD='mod'
		//	| NOT='not';
		public EnumRule getRule() { return rule; }

		//OR='or' | ALT_OR='||' | AND='and' | ALT_AND='&&' | EQ='==' | NEQ='!=' | GEQ='>=' | LEQ='<=' | GT='>' | LT='<' | IN='><'
		//| PLUS='+' | MINUS='-' | MULT='*' | DIV='/' | INTDIV='div' | MOD='mod' | NOT='not'
		public Alternatives getAlternatives() { return cAlternatives; }

		//OR='or'
		public EnumLiteralDeclaration getOREnumLiteralDeclaration_0() { return cOREnumLiteralDeclaration_0; }

		//'or'
		public Keyword getOROrKeyword_0_0() { return cOROrKeyword_0_0; }

		//ALT_OR='||'
		public EnumLiteralDeclaration getALT_OREnumLiteralDeclaration_1() { return cALT_OREnumLiteralDeclaration_1; }

		//'||'
		public Keyword getALT_ORVerticalLineVerticalLineKeyword_1_0() { return cALT_ORVerticalLineVerticalLineKeyword_1_0; }

		//AND='and'
		public EnumLiteralDeclaration getANDEnumLiteralDeclaration_2() { return cANDEnumLiteralDeclaration_2; }

		//'and'
		public Keyword getANDAndKeyword_2_0() { return cANDAndKeyword_2_0; }

		//ALT_AND='&&'
		public EnumLiteralDeclaration getALT_ANDEnumLiteralDeclaration_3() { return cALT_ANDEnumLiteralDeclaration_3; }

		//'&&'
		public Keyword getALT_ANDAmpersandAmpersandKeyword_3_0() { return cALT_ANDAmpersandAmpersandKeyword_3_0; }

		//EQ='=='
		public EnumLiteralDeclaration getEQEnumLiteralDeclaration_4() { return cEQEnumLiteralDeclaration_4; }

		//'=='
		public Keyword getEQEqualsSignEqualsSignKeyword_4_0() { return cEQEqualsSignEqualsSignKeyword_4_0; }

		//NEQ='!='
		public EnumLiteralDeclaration getNEQEnumLiteralDeclaration_5() { return cNEQEnumLiteralDeclaration_5; }

		//'!='
		public Keyword getNEQExclamationMarkEqualsSignKeyword_5_0() { return cNEQExclamationMarkEqualsSignKeyword_5_0; }

		//GEQ='>='
		public EnumLiteralDeclaration getGEQEnumLiteralDeclaration_6() { return cGEQEnumLiteralDeclaration_6; }

		//'>='
		public Keyword getGEQGreaterThanSignEqualsSignKeyword_6_0() { return cGEQGreaterThanSignEqualsSignKeyword_6_0; }

		//LEQ='<='
		public EnumLiteralDeclaration getLEQEnumLiteralDeclaration_7() { return cLEQEnumLiteralDeclaration_7; }

		//'<='
		public Keyword getLEQLessThanSignEqualsSignKeyword_7_0() { return cLEQLessThanSignEqualsSignKeyword_7_0; }

		//GT='>'
		public EnumLiteralDeclaration getGTEnumLiteralDeclaration_8() { return cGTEnumLiteralDeclaration_8; }

		//'>'
		public Keyword getGTGreaterThanSignKeyword_8_0() { return cGTGreaterThanSignKeyword_8_0; }

		//LT='<'
		public EnumLiteralDeclaration getLTEnumLiteralDeclaration_9() { return cLTEnumLiteralDeclaration_9; }

		//'<'
		public Keyword getLTLessThanSignKeyword_9_0() { return cLTLessThanSignKeyword_9_0; }

		//IN='><'
		public EnumLiteralDeclaration getINEnumLiteralDeclaration_10() { return cINEnumLiteralDeclaration_10; }

		//'><'
		public Keyword getINGreaterThanSignLessThanSignKeyword_10_0() { return cINGreaterThanSignLessThanSignKeyword_10_0; }

		//PLUS='+'
		public EnumLiteralDeclaration getPLUSEnumLiteralDeclaration_11() { return cPLUSEnumLiteralDeclaration_11; }

		//'+'
		public Keyword getPLUSPlusSignKeyword_11_0() { return cPLUSPlusSignKeyword_11_0; }

		//MINUS='-'
		public EnumLiteralDeclaration getMINUSEnumLiteralDeclaration_12() { return cMINUSEnumLiteralDeclaration_12; }

		//'-'
		public Keyword getMINUSHyphenMinusKeyword_12_0() { return cMINUSHyphenMinusKeyword_12_0; }

		//MULT='*'
		public EnumLiteralDeclaration getMULTEnumLiteralDeclaration_13() { return cMULTEnumLiteralDeclaration_13; }

		//'*'
		public Keyword getMULTAsteriskKeyword_13_0() { return cMULTAsteriskKeyword_13_0; }

		//DIV='/'
		public EnumLiteralDeclaration getDIVEnumLiteralDeclaration_14() { return cDIVEnumLiteralDeclaration_14; }

		//'/'
		public Keyword getDIVSolidusKeyword_14_0() { return cDIVSolidusKeyword_14_0; }

		//INTDIV='div'
		public EnumLiteralDeclaration getINTDIVEnumLiteralDeclaration_15() { return cINTDIVEnumLiteralDeclaration_15; }

		//'div'
		public Keyword getINTDIVDivKeyword_15_0() { return cINTDIVDivKeyword_15_0; }

		//MOD='mod'
		public EnumLiteralDeclaration getMODEnumLiteralDeclaration_16() { return cMODEnumLiteralDeclaration_16; }

		//'mod'
		public Keyword getMODModKeyword_16_0() { return cMODModKeyword_16_0; }

		//NOT='not'
		public EnumLiteralDeclaration getNOTEnumLiteralDeclaration_17() { return cNOTEnumLiteralDeclaration_17; }

		//'not'
		public Keyword getNOTNotKeyword_17_0() { return cNOTNotKeyword_17_0; }
	}

	public class TargetTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.TargetType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cCOMPONENTEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cCOMPONENTComponentKeyword_0_0 = (Keyword)cCOMPONENTEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cFEATUREEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cFEATUREFeatureKeyword_1_0 = (Keyword)cFEATUREEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cCONNECTIONEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cCONNECTIONConnectionKeyword_2_0 = (Keyword)cCONNECTIONEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cFLOWEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cFLOWFlowKeyword_3_0 = (Keyword)cFLOWEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cMODEEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cMODEModeKeyword_4_0 = (Keyword)cMODEEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cELEMENTEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cELEMENTElementKeyword_5_0 = (Keyword)cELEMENTEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cROOTEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cROOTRootKeyword_6_0 = (Keyword)cROOTEnumLiteralDeclaration_6.eContents().get(0);
		
		//enum TargetType:
		//	COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | ELEMENT='element' |
		//	ROOT='root';
		public EnumRule getRule() { return rule; }

		//COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | ELEMENT='element' |
		//ROOT='root'
		public Alternatives getAlternatives() { return cAlternatives; }

		//COMPONENT='component'
		public EnumLiteralDeclaration getCOMPONENTEnumLiteralDeclaration_0() { return cCOMPONENTEnumLiteralDeclaration_0; }

		//'component'
		public Keyword getCOMPONENTComponentKeyword_0_0() { return cCOMPONENTComponentKeyword_0_0; }

		//FEATURE='feature'
		public EnumLiteralDeclaration getFEATUREEnumLiteralDeclaration_1() { return cFEATUREEnumLiteralDeclaration_1; }

		//'feature'
		public Keyword getFEATUREFeatureKeyword_1_0() { return cFEATUREFeatureKeyword_1_0; }

		//CONNECTION='connection'
		public EnumLiteralDeclaration getCONNECTIONEnumLiteralDeclaration_2() { return cCONNECTIONEnumLiteralDeclaration_2; }

		//'connection'
		public Keyword getCONNECTIONConnectionKeyword_2_0() { return cCONNECTIONConnectionKeyword_2_0; }

		//FLOW='flow'
		public EnumLiteralDeclaration getFLOWEnumLiteralDeclaration_3() { return cFLOWEnumLiteralDeclaration_3; }

		//'flow'
		public Keyword getFLOWFlowKeyword_3_0() { return cFLOWFlowKeyword_3_0; }

		//MODE='mode'
		public EnumLiteralDeclaration getMODEEnumLiteralDeclaration_4() { return cMODEEnumLiteralDeclaration_4; }

		//'mode'
		public Keyword getMODEModeKeyword_4_0() { return cMODEModeKeyword_4_0; }

		//ELEMENT='element'
		public EnumLiteralDeclaration getELEMENTEnumLiteralDeclaration_5() { return cELEMENTEnumLiteralDeclaration_5; }

		//'element'
		public Keyword getELEMENTElementKeyword_5_0() { return cELEMENTElementKeyword_5_0; }

		//ROOT='root'
		public EnumLiteralDeclaration getROOTEnumLiteralDeclaration_6() { return cROOTEnumLiteralDeclaration_6; }

		//'root'
		public Keyword getROOTRootKeyword_6_0() { return cROOTRootKeyword_6_0; }
	}
	
	private final DescriptionElements pDescription;
	private final DescriptionElementElements pDescriptionElement;
	private final RationaleElements pRationale;
	private final UncertaintyElements pUncertainty;
	private final TypeRefElements pTypeRef;
	private final PropertyRefElements pPropertyRef;
	private final ValDeclarationElements pValDeclaration;
	private final ComputeDeclarationElements pComputeDeclaration;
	private final AModelOrPropertyReferenceElements pAModelOrPropertyReference;
	private final AModelReferenceElements pAModelReference;
	private final APropertyReferenceElements pAPropertyReference;
	private final AVariableReferenceElements pAVariableReference;
	private final ShowValueElements pShowValue;
	private final ImageReferenceElements pImageReference;
	private final IMGREFElements pIMGREF;
	private final OperationElements eOperation;
	private final AExpressionElements pAExpression;
	private final AOrExpressionElements pAOrExpression;
	private final OpOrElements pOpOr;
	private final AAndExpressionElements pAAndExpression;
	private final OpAndElements pOpAnd;
	private final AEqualityExpressionElements pAEqualityExpression;
	private final OpEqualityElements pOpEquality;
	private final ARelationalExpressionElements pARelationalExpression;
	private final OpCompareElements pOpCompare;
	private final AAdditiveExpressionElements pAAdditiveExpression;
	private final OpAddElements pOpAdd;
	private final AMultiplicativeExpressionElements pAMultiplicativeExpression;
	private final OpMultiElements pOpMulti;
	private final AUnaryOperationElements pAUnaryOperation;
	private final OpUnaryElements pOpUnary;
	private final AUnitExpressionElements pAUnitExpression;
	private final APrimaryExpressionElements pAPrimaryExpression;
	private final AFunctionCallElements pAFunctionCall;
	private final ARangeExpressionElements pARangeExpression;
	private final AIfExpressionElements pAIfExpression;
	private final ALiteralElements pALiteral;
	private final AIntegerTermElements pAIntegerTerm;
	private final AIntElements pAInt;
	private final ARealTermElements pARealTerm;
	private final ARealElements pAReal;
	private final ABooleanLiteralElements pABooleanLiteral;
	private final StringTermElements pStringTerm;
	private final NoQuoteStringElements pNoQuoteString;
	private final AParenthesizedExpressionElements pAParenthesizedExpression;
	private final ComponentCategoryElements pComponentCategory;
	private final TargetTypeElements eTargetType;
	private final TerminalRule tEXPONENT;
	private final TerminalRule tINT_EXPONENT;
	private final TerminalRule tREAL_LIT;
	private final TerminalRule tDIGIT;
	private final TerminalRule tEXTENDED_DIGIT;
	private final TerminalRule tBASED_INTEGER;
	private final AadlClassifierReferenceElements pAadlClassifierReference;
	private final AADLPROPERTYREFERENCEElements pAADLPROPERTYREFERENCE;
	private final URIIDElements pURIID;
	private final QualifiedNameElements pQualifiedName;
	private final ThisKeywordElements pThisKeyword;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public CommonGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pDescription = new DescriptionElements();
		this.pDescriptionElement = new DescriptionElementElements();
		this.pRationale = new RationaleElements();
		this.pUncertainty = new UncertaintyElements();
		this.pTypeRef = new TypeRefElements();
		this.pPropertyRef = new PropertyRefElements();
		this.pValDeclaration = new ValDeclarationElements();
		this.pComputeDeclaration = new ComputeDeclarationElements();
		this.pAModelOrPropertyReference = new AModelOrPropertyReferenceElements();
		this.pAModelReference = new AModelReferenceElements();
		this.pAPropertyReference = new APropertyReferenceElements();
		this.pAVariableReference = new AVariableReferenceElements();
		this.pShowValue = new ShowValueElements();
		this.pImageReference = new ImageReferenceElements();
		this.pIMGREF = new IMGREFElements();
		this.eOperation = new OperationElements();
		this.pAExpression = new AExpressionElements();
		this.pAOrExpression = new AOrExpressionElements();
		this.pOpOr = new OpOrElements();
		this.pAAndExpression = new AAndExpressionElements();
		this.pOpAnd = new OpAndElements();
		this.pAEqualityExpression = new AEqualityExpressionElements();
		this.pOpEquality = new OpEqualityElements();
		this.pARelationalExpression = new ARelationalExpressionElements();
		this.pOpCompare = new OpCompareElements();
		this.pAAdditiveExpression = new AAdditiveExpressionElements();
		this.pOpAdd = new OpAddElements();
		this.pAMultiplicativeExpression = new AMultiplicativeExpressionElements();
		this.pOpMulti = new OpMultiElements();
		this.pAUnaryOperation = new AUnaryOperationElements();
		this.pOpUnary = new OpUnaryElements();
		this.pAUnitExpression = new AUnitExpressionElements();
		this.pAPrimaryExpression = new APrimaryExpressionElements();
		this.pAFunctionCall = new AFunctionCallElements();
		this.pARangeExpression = new ARangeExpressionElements();
		this.pAIfExpression = new AIfExpressionElements();
		this.pALiteral = new ALiteralElements();
		this.pAIntegerTerm = new AIntegerTermElements();
		this.pAInt = new AIntElements();
		this.pARealTerm = new ARealTermElements();
		this.pAReal = new ARealElements();
		this.pABooleanLiteral = new ABooleanLiteralElements();
		this.pStringTerm = new StringTermElements();
		this.pNoQuoteString = new NoQuoteStringElements();
		this.pAParenthesizedExpression = new AParenthesizedExpressionElements();
		this.pComponentCategory = new ComponentCategoryElements();
		this.eTargetType = new TargetTypeElements();
		this.tEXPONENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.EXPONENT");
		this.tINT_EXPONENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.INT_EXPONENT");
		this.tREAL_LIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.REAL_LIT");
		this.tDIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.DIGIT");
		this.tEXTENDED_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.EXTENDED_DIGIT");
		this.tBASED_INTEGER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.alisa.common.Common.BASED_INTEGER");
		this.pAadlClassifierReference = new AadlClassifierReferenceElements();
		this.pAADLPROPERTYREFERENCE = new AADLPROPERTYREFERENCEElements();
		this.pURIID = new URIIDElements();
		this.pQualifiedName = new QualifiedNameElements();
		this.pThisKeyword = new ThisKeywordElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.alisa.common.Common".equals(grammar.getName())) {
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
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Description:
	//	'description' description+=DescriptionElement+;
	public DescriptionElements getDescriptionAccess() {
		return pDescription;
	}
	
	public ParserRule getDescriptionRule() {
		return getDescriptionAccess().getRule();
	}

	//DescriptionElement:
	//	text=STRING | => thisTarget?='this' | => image=ImageReference | showValue=ShowValue;
	public DescriptionElementElements getDescriptionElementAccess() {
		return pDescriptionElement;
	}
	
	public ParserRule getDescriptionElementRule() {
		return getDescriptionElementAccess().getRule();
	}

	//Rationale:
	//	'rationale' text=STRING;
	public RationaleElements getRationaleAccess() {
		return pRationale;
	}
	
	public ParserRule getRationaleRule() {
		return getRationaleAccess().getRule();
	}

	//Uncertainty:
	//	{Uncertainty} 'uncertainty'
	//	'[' (('volatility' volatility=INT)?
	//	& ('precedence' precedence=INT)?
	//	& ('impact' impact=INT)?)
	//	']';
	public UncertaintyElements getUncertaintyAccess() {
		return pUncertainty;
	}
	
	public ParserRule getUncertaintyRule() {
		return getUncertaintyAccess().getRule();
	}

	//TypeRef aadl2::PropertyType:
	//	{aadl2::AadlBoolean} 'boolean'
	//	| {aadl2::AadlInteger} 'integer' ('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
	//	| {aadl2::AadlReal} 'real' ('units' referencedUnitsType=[aadl2::UnitsType|AADLPROPERTYREFERENCE])?
	//	| {aadl2::AadlString} 'string'
	//	| {ModelRef} 'model' 'element'
	//	| {TypeRef} ref=[aadl2::PropertyType|AADLPROPERTYREFERENCE];
	public TypeRefElements getTypeRefAccess() {
		return pTypeRef;
	}
	
	public ParserRule getTypeRefRule() {
		return getTypeRefAccess().getRule();
	}

	//PropertyRef aadl2::PropertyType:
	//	{PropertyRef} ref=[aadl2::Property|AADLPROPERTYREFERENCE];
	public PropertyRefElements getPropertyRefAccess() {
		return pPropertyRef;
	}
	
	public ParserRule getPropertyRefRule() {
		return getPropertyRefAccess().getRule();
	}

	//ValDeclaration AVariableDeclaration:
	//	{ValDeclaration} 'val' name=ID (':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof'
	//	type=PropertyRef) ']'))? '=' value=AExpression;
	public ValDeclarationElements getValDeclarationAccess() {
		return pValDeclaration;
	}
	
	public ParserRule getValDeclarationRule() {
		return getValDeclarationAccess().getRule();
	}

	//ComputeDeclaration AVariableDeclaration:
	//	{ComputeDeclaration}
	//	'compute' name=ID ':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof'
	//	type=PropertyRef) ']');
	public ComputeDeclarationElements getComputeDeclarationAccess() {
		return pComputeDeclaration;
	}
	
	public ParserRule getComputeDeclarationRule() {
		return getComputeDeclarationAccess().getRule();
	}

	//// Reference to property, property constant, or model element.
	//AModelOrPropertyReference AExpression:
	//	AModelReference (=> ({APropertyReference.modelElementReference=current} '#')
	//	property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE])?
	//	| APropertyReference;
	public AModelOrPropertyReferenceElements getAModelOrPropertyReferenceAccess() {
		return pAModelOrPropertyReference;
	}
	
	public ParserRule getAModelOrPropertyReferenceRule() {
		return getAModelOrPropertyReferenceAccess().getRule();
	}

	//AModelReference:
	//	modelElement=[aadl2::NamedElement|ThisKeyword] ({AModelReference.prev=current} '.'
	//	modelElement=[aadl2::NamedElement])*;
	public AModelReferenceElements getAModelReferenceAccess() {
		return pAModelReference;
	}
	
	public ParserRule getAModelReferenceRule() {
		return getAModelReferenceAccess().getRule();
	}

	//APropertyReference:
	//	{APropertyReference} '#' property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE];
	public APropertyReferenceElements getAPropertyReferenceAccess() {
		return pAPropertyReference;
	}
	
	public ParserRule getAPropertyReferenceRule() {
		return getAPropertyReferenceAccess().getRule();
	}

	//AVariableReference AExpression:
	//	{AVariableReference} variable=[AVariableDeclaration];
	public AVariableReferenceElements getAVariableReferenceAccess() {
		return pAVariableReference;
	}
	
	public ParserRule getAVariableReferenceRule() {
		return getAVariableReferenceAccess().getRule();
	}

	//ShowValue AUnitExpression:
	//	expression=AVariableReference ((convert?='%' | drop?='in') unit=[aadl2::UnitLiteral])?;
	public ShowValueElements getShowValueAccess() {
		return pShowValue;
	}
	
	public ParserRule getShowValueRule() {
		return getShowValueAccess().getRule();
	}

	//ImageReference:
	//	'img' imgfile=IMGREF;
	public ImageReferenceElements getImageReferenceAccess() {
		return pImageReference;
	}
	
	public ParserRule getImageReferenceRule() {
		return getImageReferenceAccess().getRule();
	}

	//IMGREF:
	//	(ID '/')* ID '.' ID;
	public IMGREFElements getIMGREFAccess() {
		return pIMGREF;
	}
	
	public ParserRule getIMGREFRule() {
		return getIMGREFAccess().getRule();
	}

	//enum Operation:
	//	OR='or' | ALT_OR='||'
	//	| AND='and' | ALT_AND='&&'
	//	| EQ='==' | NEQ='!='
	//	| GEQ='>=' | LEQ='<=' | GT='>' | LT='<' | IN='><'
	//	| PLUS='+' | MINUS='-'
	//	| MULT='*' | DIV='/' | INTDIV='div' | MOD='mod'
	//	| NOT='not';
	public OperationElements getOperationAccess() {
		return eOperation;
	}
	
	public EnumRule getOperationRule() {
		return getOperationAccess().getRule();
	}

	//AExpression aadl2::PropertyExpression:
	//	AOrExpression;
	public AExpressionElements getAExpressionAccess() {
		return pAExpression;
	}
	
	public ParserRule getAExpressionRule() {
		return getAExpressionAccess().getRule();
	}

	//AOrExpression aadl2::PropertyExpression:
	//	AAndExpression (=> ({ABinaryOperation.left=current} operator=OpOr) right=AAndExpression)*;
	public AOrExpressionElements getAOrExpressionAccess() {
		return pAOrExpression;
	}
	
	public ParserRule getAOrExpressionRule() {
		return getAOrExpressionAccess().getRule();
	}

	//OpOr Operation:
	//	'or' | '||';
	public OpOrElements getOpOrAccess() {
		return pOpOr;
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}

	//AAndExpression aadl2::PropertyExpression:
	//	AEqualityExpression (=> ({ABinaryOperation.left=current} operator=OpAnd) right=AEqualityExpression)*;
	public AAndExpressionElements getAAndExpressionAccess() {
		return pAAndExpression;
	}
	
	public ParserRule getAAndExpressionRule() {
		return getAAndExpressionAccess().getRule();
	}

	//OpAnd Operation:
	//	'and' | '&&';
	public OpAndElements getOpAndAccess() {
		return pOpAnd;
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}

	//AEqualityExpression aadl2::PropertyExpression:
	//	ARelationalExpression (=> ({ABinaryOperation.left=current} operator=OpEquality) right=ARelationalExpression)*;
	public AEqualityExpressionElements getAEqualityExpressionAccess() {
		return pAEqualityExpression;
	}
	
	public ParserRule getAEqualityExpressionRule() {
		return getAEqualityExpressionAccess().getRule();
	}

	//OpEquality Operation:
	//	'==' | '!=';
	public OpEqualityElements getOpEqualityAccess() {
		return pOpEquality;
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}

	//ARelationalExpression aadl2::PropertyExpression:
	//	AAdditiveExpression (=> ({ABinaryOperation.left=current} operator=OpCompare) right=AAdditiveExpression)*;
	public ARelationalExpressionElements getARelationalExpressionAccess() {
		return pARelationalExpression;
	}
	
	public ParserRule getARelationalExpressionRule() {
		return getARelationalExpressionAccess().getRule();
	}

	//OpCompare Operation:
	//	'>=' | '<=' | '>' | '<' | '><';
	public OpCompareElements getOpCompareAccess() {
		return pOpCompare;
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}

	////AOtherOperatorExpression returns aadl2::PropertyExpression:
	////	AAdditiveExpression (=>({ABinaryOperation.leftOperand=current} feature=OpOther)
	////	rightOperand=AAdditiveExpression)*;
	////
	////OpOther:
	////	  '->' 
	////	| '..<'
	////	| '>' '..'
	////	| '..'
	////	| '=>' 
	////	| '>' (=>('>' '>') | '>') 
	////	| '<' (=>('<' '<') | '<' | '=>')
	////	| '<>'
	////	| '?:';
	//AAdditiveExpression aadl2::PropertyExpression:
	//	AMultiplicativeExpression (=> ({ABinaryOperation.left=current} operator=OpAdd) right=AMultiplicativeExpression)*;
	public AAdditiveExpressionElements getAAdditiveExpressionAccess() {
		return pAAdditiveExpression;
	}
	
	public ParserRule getAAdditiveExpressionRule() {
		return getAAdditiveExpressionAccess().getRule();
	}

	//OpAdd Operation:
	//	'+' | '-';
	public OpAddElements getOpAddAccess() {
		return pOpAdd;
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}

	//AMultiplicativeExpression aadl2::PropertyExpression:
	//	AUnaryOperation (=> ({ABinaryOperation.left=current} operator=OpMulti) right=AUnaryOperation)*;
	public AMultiplicativeExpressionElements getAMultiplicativeExpressionAccess() {
		return pAMultiplicativeExpression;
	}
	
	public ParserRule getAMultiplicativeExpressionRule() {
		return getAMultiplicativeExpressionAccess().getRule();
	}

	//OpMulti Operation:
	//	'*' | '/' | 'div' | 'mod';
	public OpMultiElements getOpMultiAccess() {
		return pOpMulti;
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}

	//AUnaryOperation aadl2::PropertyExpression:
	//	{AUnaryOperation} => operator=OpUnary operand=AUnaryOperation | AUnitExpression;
	public AUnaryOperationElements getAUnaryOperationAccess() {
		return pAUnaryOperation;
	}
	
	public ParserRule getAUnaryOperationRule() {
		return getAUnaryOperationAccess().getRule();
	}

	//OpUnary Operation:
	//	"not" | "-" | "+";
	public OpUnaryElements getOpUnaryAccess() {
		return pOpUnary;
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}

	//AUnitExpression aadl2::PropertyExpression:
	//	APrimaryExpression ({AUnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?;
	public AUnitExpressionElements getAUnitExpressionAccess() {
		return pAUnitExpression;
	}
	
	public ParserRule getAUnitExpressionRule() {
		return getAUnitExpressionAccess().getRule();
	}

	//APrimaryExpression aadl2::PropertyExpression:
	//	ALiteral | AVariableReference | AModelOrPropertyReference | AFunctionCall | ARangeExpression | AIfExpression
	//	| AParenthesizedExpression;
	public APrimaryExpressionElements getAPrimaryExpressionAccess() {
		return pAPrimaryExpression;
	}
	
	public ParserRule getAPrimaryExpressionRule() {
		return getAPrimaryExpressionAccess().getRule();
	}

	//AFunctionCall aadl2::PropertyExpression:
	//	{AFunctionCall} function=QualifiedName '(' (arguments+=AExpression (',' arguments+=AExpression)*)? ')';
	public AFunctionCallElements getAFunctionCallAccess() {
		return pAFunctionCall;
	}
	
	public ParserRule getAFunctionCallRule() {
		return getAFunctionCallAccess().getRule();
	}

	//ARangeExpression aadl2::PropertyExpression:
	//	{ARange} '[' minimum=AExpression '..' maximum=AExpression (=> 'delta' delta=AExpression)? ']';
	public ARangeExpressionElements getARangeExpressionAccess() {
		return pARangeExpression;
	}
	
	public ParserRule getARangeExpressionRule() {
		return getARangeExpressionAccess().getRule();
	}

	//AIfExpression aadl2::PropertyExpression:
	//	{AConditional} 'if' if=AExpression 'then' then=AExpression ('else' else=AExpression)? 'endif';
	public AIfExpressionElements getAIfExpressionAccess() {
		return pAIfExpression;
	}
	
	public ParserRule getAIfExpressionRule() {
		return getAIfExpressionAccess().getRule();
	}

	//ALiteral aadl2::PropertyExpression:
	//	ABooleanLiteral | ARealTerm | AIntegerTerm | StringTerm;
	public ALiteralElements getALiteralAccess() {
		return pALiteral;
	}
	
	public ParserRule getALiteralRule() {
		return getALiteralAccess().getRule();
	}

	//AIntegerTerm aadl2::IntegerLiteral:
	//	value=AInt;
	public AIntegerTermElements getAIntegerTermAccess() {
		return pAIntegerTerm;
	}
	
	public ParserRule getAIntegerTermRule() {
		return getAIntegerTermAccess().getRule();
	}

	//AInt aadl2::Integer:
	//	INT;
	public AIntElements getAIntAccess() {
		return pAInt;
	}
	
	public ParserRule getAIntRule() {
		return getAIntAccess().getRule();
	}

	//ARealTerm aadl2::RealLiteral:
	//	value=AReal;
	public ARealTermElements getARealTermAccess() {
		return pARealTerm;
	}
	
	public ParserRule getARealTermRule() {
		return getARealTermAccess().getRule();
	}

	//AReal aadl2::Real:
	//	REAL_LIT;
	public ARealElements getARealAccess() {
		return pAReal;
	}
	
	public ParserRule getARealRule() {
		return getARealAccess().getRule();
	}

	////ASetTerm returns aadl2::PropertyExpression:
	////	{ASetLiteral}  '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
	////;
	////
	////AListTerm returns aadl2::PropertyExpression:
	////	{AListTerm} '[' (elements+=AExpression (',' elements+=AExpression )*)? ']'
	////;
	//ABooleanLiteral aadl2::PropertyExpression:
	//	{aadl2::BooleanLiteral} (value?='true' | 'false');
	public ABooleanLiteralElements getABooleanLiteralAccess() {
		return pABooleanLiteral;
	}
	
	public ParserRule getABooleanLiteralRule() {
		return getABooleanLiteralAccess().getRule();
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

	//AParenthesizedExpression aadl2::PropertyExpression:
	//	'(' AExpression ')';
	public AParenthesizedExpressionElements getAParenthesizedExpressionAccess() {
		return pAParenthesizedExpression;
	}
	
	public ParserRule getAParenthesizedExpressionRule() {
		return getAParenthesizedExpressionAccess().getRule();
	}

	//ComponentCategory aadl2::ComponentCategory:
	//	'abstract' | 'bus' | 'data'
	//	| 'device' | 'memory' | 'process' | 'processor' | 'subprogram'
	//	| 'subprogram' 'group' | 'system' | 'thread' 'group'
	//	| 'thread' | 'virtual' 'bus' | 'virtual' 'processor';
	public ComponentCategoryElements getComponentCategoryAccess() {
		return pComponentCategory;
	}
	
	public ParserRule getComponentCategoryRule() {
		return getComponentCategoryAccess().getRule();
	}

	//enum TargetType:
	//	COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | ELEMENT='element' |
	//	ROOT='root';
	public TargetTypeElements getTargetTypeAccess() {
		return eTargetType;
	}
	
	public EnumRule getTargetTypeRule() {
		return getTargetTypeAccess().getRule();
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

	//// Qualified classifier reference
	//AadlClassifierReference:
	//	ID ('::' ID)+ ('.' ID)?;
	public AadlClassifierReferenceElements getAadlClassifierReferenceAccess() {
		return pAadlClassifierReference;
	}
	
	public ParserRule getAadlClassifierReferenceRule() {
		return getAadlClassifierReferenceAccess().getRule();
	}

	//AADLPROPERTYREFERENCE:
	//	ID ('::' ID)?;
	public AADLPROPERTYREFERENCEElements getAADLPROPERTYREFERENCEAccess() {
		return pAADLPROPERTYREFERENCE;
	}
	
	public ParserRule getAADLPROPERTYREFERENCERule() {
		return getAADLPROPERTYREFERENCEAccess().getRule();
	}

	//URIID:
	//	STRING;
	public URIIDElements getURIIDAccess() {
		return pURIID;
	}
	
	public ParserRule getURIIDRule() {
		return getURIIDAccess().getRule();
	}

	////terminal URIID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'#'|'@'|'/'|':')*;
	//QualifiedName:
	//	ID ('.' ID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//ThisKeyword:
	//	'this';
	public ThisKeywordElements getThisKeywordAccess() {
		return pThisKeyword;
	}
	
	public ParserRule getThisKeywordRule() {
		return getThisKeywordAccess().getRule();
	}

	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
