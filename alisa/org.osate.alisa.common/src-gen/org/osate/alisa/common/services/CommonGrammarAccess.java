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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Description");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cDescriptionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cDescriptionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cDescriptionDescriptionElementParserRuleCall_1_0 = (RuleCall)cDescriptionAssignment_1.eContents().get(0);
		
		//Description:
		//	"description" description+=DescriptionElement+;
		@Override public ParserRule getRule() { return rule; }

		//"description" description+=DescriptionElement+
		public Group getGroup() { return cGroup; }

		//"description"
		public Keyword getDescriptionKeyword_0() { return cDescriptionKeyword_0; }

		//description+=DescriptionElement+
		public Assignment getDescriptionAssignment_1() { return cDescriptionAssignment_1; }

		//DescriptionElement
		public RuleCall getDescriptionDescriptionElementParserRuleCall_1_0() { return cDescriptionDescriptionElementParserRuleCall_1_0; }
	}

	public class DescriptionElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DescriptionElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cTextAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final RuleCall cTextSTRINGTerminalRuleCall_0_0 = (RuleCall)cTextAssignment_0.eContents().get(0);
		private final Assignment cShowValueAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall cShowValueShowValueParserRuleCall_1_0 = (RuleCall)cShowValueAssignment_1.eContents().get(0);
		private final Assignment cThisTargetAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final Keyword cThisTargetThisKeyword_2_0 = (Keyword)cThisTargetAssignment_2.eContents().get(0);
		private final Assignment cImageAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final RuleCall cImageImageReferenceParserRuleCall_3_0 = (RuleCall)cImageAssignment_3.eContents().get(0);
		
		//DescriptionElement:
		//	text=STRING | showValue=ShowValue | thisTarget?="this" | image=ImageReference;
		@Override public ParserRule getRule() { return rule; }

		//text=STRING | showValue=ShowValue | thisTarget?="this" | image=ImageReference
		public Alternatives getAlternatives() { return cAlternatives; }

		//text=STRING
		public Assignment getTextAssignment_0() { return cTextAssignment_0; }

		//STRING
		public RuleCall getTextSTRINGTerminalRuleCall_0_0() { return cTextSTRINGTerminalRuleCall_0_0; }

		//showValue=ShowValue
		public Assignment getShowValueAssignment_1() { return cShowValueAssignment_1; }

		//ShowValue
		public RuleCall getShowValueShowValueParserRuleCall_1_0() { return cShowValueShowValueParserRuleCall_1_0; }

		//thisTarget?="this"
		public Assignment getThisTargetAssignment_2() { return cThisTargetAssignment_2; }

		//"this"
		public Keyword getThisTargetThisKeyword_2_0() { return cThisTargetThisKeyword_2_0; }

		//image=ImageReference
		public Assignment getImageAssignment_3() { return cImageAssignment_3; }

		//ImageReference
		public RuleCall getImageImageReferenceParserRuleCall_3_0() { return cImageImageReferenceParserRuleCall_3_0; }
	}

	public class RationaleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Rationale");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRationaleKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTextAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTextSTRINGTerminalRuleCall_1_0 = (RuleCall)cTextAssignment_1.eContents().get(0);
		
		//Rationale:
		//	"rationale" text=STRING;
		@Override public ParserRule getRule() { return rule; }

		//"rationale" text=STRING
		public Group getGroup() { return cGroup; }

		//"rationale"
		public Keyword getRationaleKeyword_0() { return cRationaleKeyword_0; }

		//text=STRING
		public Assignment getTextAssignment_1() { return cTextAssignment_1; }

		//STRING
		public RuleCall getTextSTRINGTerminalRuleCall_1_0() { return cTextSTRINGTerminalRuleCall_1_0; }
	}

	public class UncertaintyElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Uncertainty");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cUncertaintyKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final UnorderedGroup cUnorderedGroup_2 = (UnorderedGroup)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cUnorderedGroup_2.eContents().get(0);
		private final Keyword cVolatilityKeyword_2_0_0 = (Keyword)cGroup_2_0.eContents().get(0);
		private final Assignment cVolatilityAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final RuleCall cVolatilityINTTerminalRuleCall_2_0_1_0 = (RuleCall)cVolatilityAssignment_2_0_1.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cUnorderedGroup_2.eContents().get(1);
		private final Keyword cImpactKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cImpactAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cImpactINTTerminalRuleCall_2_1_1_0 = (RuleCall)cImpactAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Uncertainty:
		//	"uncertainty" "[" ("volatility" volatility=INT & "impact" impact=INT) "]";
		@Override public ParserRule getRule() { return rule; }

		//"uncertainty" "[" ("volatility" volatility=INT & "impact" impact=INT) "]"
		public Group getGroup() { return cGroup; }

		//"uncertainty"
		public Keyword getUncertaintyKeyword_0() { return cUncertaintyKeyword_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//"volatility" volatility=INT & "impact" impact=INT
		public UnorderedGroup getUnorderedGroup_2() { return cUnorderedGroup_2; }

		//"volatility" volatility=INT
		public Group getGroup_2_0() { return cGroup_2_0; }

		//"volatility"
		public Keyword getVolatilityKeyword_2_0_0() { return cVolatilityKeyword_2_0_0; }

		//volatility=INT
		public Assignment getVolatilityAssignment_2_0_1() { return cVolatilityAssignment_2_0_1; }

		//INT
		public RuleCall getVolatilityINTTerminalRuleCall_2_0_1_0() { return cVolatilityINTTerminalRuleCall_2_0_1_0; }

		//"impact" impact=INT
		public Group getGroup_2_1() { return cGroup_2_1; }

		//"impact"
		public Keyword getImpactKeyword_2_1_0() { return cImpactKeyword_2_1_0; }

		//impact=INT
		public Assignment getImpactAssignment_2_1_1() { return cImpactAssignment_2_1_1; }

		//INT
		public RuleCall getImpactINTTerminalRuleCall_2_1_1_0() { return cImpactINTTerminalRuleCall_2_1_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class ResultIssueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultIssue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIssueTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cIssueTypeResultIssueTypeEnumRuleCall_0_0 = (RuleCall)cIssueTypeAssignment_0.eContents().get(0);
		private final Assignment cMessageAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_1_0 = (RuleCall)cMessageAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cTargetKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTargetAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cTargetEObjectCrossReference_2_1_0 = (CrossReference)cTargetAssignment_2_1.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_2_1_0_1 = (RuleCall)cTargetEObjectCrossReference_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cExceptionKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cExceptionTypeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cExceptionTypeSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cExceptionTypeAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cDiagnosticIdKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cDiagnosticIdAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cDiagnosticIdSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cDiagnosticIdAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLeftSquareBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cIssuesAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cIssuesResultIssueParserRuleCall_5_1_0 = (RuleCall)cIssuesAssignment_5_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		
		//// This is similar to diagnostics
		//ResultIssue:
		//	issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception"
		//	exceptionType=STRING)? ("diagnosticId" diagnosticId=STRING)? ("[" issues+=ResultIssue* "]")?;
		@Override public ParserRule getRule() { return rule; }

		//issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception" exceptionType=STRING)?
		//("diagnosticId" diagnosticId=STRING)? ("[" issues+=ResultIssue* "]")?
		public Group getGroup() { return cGroup; }

		//issueType=ResultIssueType
		public Assignment getIssueTypeAssignment_0() { return cIssueTypeAssignment_0; }

		//ResultIssueType
		public RuleCall getIssueTypeResultIssueTypeEnumRuleCall_0_0() { return cIssueTypeResultIssueTypeEnumRuleCall_0_0; }

		//message=STRING
		public Assignment getMessageAssignment_1() { return cMessageAssignment_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_1_0() { return cMessageSTRINGTerminalRuleCall_1_0; }

		//("target" target=[ecore::EObject|URIID])?
		public Group getGroup_2() { return cGroup_2; }

		//"target"
		public Keyword getTargetKeyword_2_0() { return cTargetKeyword_2_0; }

		//target=[ecore::EObject|URIID]
		public Assignment getTargetAssignment_2_1() { return cTargetAssignment_2_1; }

		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_2_1_0() { return cTargetEObjectCrossReference_2_1_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_2_1_0_1() { return cTargetEObjectURIIDParserRuleCall_2_1_0_1; }

		//("exception" exceptionType=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//"exception"
		public Keyword getExceptionKeyword_3_0() { return cExceptionKeyword_3_0; }

		//exceptionType=STRING
		public Assignment getExceptionTypeAssignment_3_1() { return cExceptionTypeAssignment_3_1; }

		//STRING
		public RuleCall getExceptionTypeSTRINGTerminalRuleCall_3_1_0() { return cExceptionTypeSTRINGTerminalRuleCall_3_1_0; }

		//("diagnosticId" diagnosticId=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//"diagnosticId"
		public Keyword getDiagnosticIdKeyword_4_0() { return cDiagnosticIdKeyword_4_0; }

		//diagnosticId=STRING
		public Assignment getDiagnosticIdAssignment_4_1() { return cDiagnosticIdAssignment_4_1; }

		//STRING
		public RuleCall getDiagnosticIdSTRINGTerminalRuleCall_4_1_0() { return cDiagnosticIdSTRINGTerminalRuleCall_4_1_0; }

		//("[" issues+=ResultIssue* "]")?
		public Group getGroup_5() { return cGroup_5; }

		//"["
		public Keyword getLeftSquareBracketKeyword_5_0() { return cLeftSquareBracketKeyword_5_0; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_5_1() { return cIssuesAssignment_5_1; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_5_1_0() { return cIssuesResultIssueParserRuleCall_5_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5_2() { return cRightSquareBracketKeyword_5_2; }
	}

	public class ValDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ValDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cValDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cValKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0_0 = (Assignment)cGroup_2_0_0.eContents().get(0);
		private final RuleCall cTypeIDTerminalRuleCall_2_0_0_0_0 = (RuleCall)cTypeAssignment_2_0_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_0_0_1 = (Assignment)cGroup_2_0_0.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_2_0_0_1_0 = (RuleCall)cNameAssignment_2_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_2_1_0 = (RuleCall)cNameAssignment_2_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cRightAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cRightAExpressionParserRuleCall_4_0 = (RuleCall)cRightAssignment_4.eContents().get(0);
		
		//ValDeclaration returns AVariableDeclaration:
		//	{ValDeclaration} "val" (=> (type=ID name=ID) | name=ID) "=" right=AExpression;
		@Override public ParserRule getRule() { return rule; }

		//{ValDeclaration} "val" (=> (type=ID name=ID) | name=ID) "=" right=AExpression
		public Group getGroup() { return cGroup; }

		//{ValDeclaration}
		public Action getValDeclarationAction_0() { return cValDeclarationAction_0; }

		//"val"
		public Keyword getValKeyword_1() { return cValKeyword_1; }

		//=> (type=ID name=ID) | name=ID
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//=> (type=ID name=ID)
		public Group getGroup_2_0() { return cGroup_2_0; }

		//type=ID name=ID
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }

		//type=ID
		public Assignment getTypeAssignment_2_0_0_0() { return cTypeAssignment_2_0_0_0; }

		//ID
		public RuleCall getTypeIDTerminalRuleCall_2_0_0_0_0() { return cTypeIDTerminalRuleCall_2_0_0_0_0; }

		//name=ID
		public Assignment getNameAssignment_2_0_0_1() { return cNameAssignment_2_0_0_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0_0_1_0() { return cNameIDTerminalRuleCall_2_0_0_1_0; }

		//name=ID
		public Assignment getNameAssignment_2_1() { return cNameAssignment_2_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_1_0() { return cNameIDTerminalRuleCall_2_1_0; }

		//"="
		public Keyword getEqualsSignKeyword_3() { return cEqualsSignKeyword_3; }

		//right=AExpression
		public Assignment getRightAssignment_4() { return cRightAssignment_4; }

		//AExpression
		public RuleCall getRightAExpressionParserRuleCall_4_0() { return cRightAExpressionParserRuleCall_4_0; }
	}

	public class ComputeDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ComputeDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cComputeDeclarationAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cComputeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cAlternatives_2.eContents().get(0);
		private final Group cGroup_2_0_0 = (Group)cGroup_2_0.eContents().get(0);
		private final Assignment cTypeAssignment_2_0_0_0 = (Assignment)cGroup_2_0_0.eContents().get(0);
		private final RuleCall cTypeIDTerminalRuleCall_2_0_0_0_0 = (RuleCall)cTypeAssignment_2_0_0_0.eContents().get(0);
		private final Assignment cNameAssignment_2_0_0_1 = (Assignment)cGroup_2_0_0.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_2_0_0_1_0 = (RuleCall)cNameAssignment_2_0_0_1.eContents().get(0);
		private final Assignment cNameAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_2_1_0 = (RuleCall)cNameAssignment_2_1.eContents().get(0);
		
		//ComputeDeclaration returns AVariableDeclaration:
		//	{ComputeDeclaration} "compute" (=> (type=ID name=ID) | name=ID);
		@Override public ParserRule getRule() { return rule; }

		//{ComputeDeclaration} "compute" (=> (type=ID name=ID) | name=ID)
		public Group getGroup() { return cGroup; }

		//{ComputeDeclaration}
		public Action getComputeDeclarationAction_0() { return cComputeDeclarationAction_0; }

		//"compute"
		public Keyword getComputeKeyword_1() { return cComputeKeyword_1; }

		//=> (type=ID name=ID) | name=ID
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//=> (type=ID name=ID)
		public Group getGroup_2_0() { return cGroup_2_0; }

		//type=ID name=ID
		public Group getGroup_2_0_0() { return cGroup_2_0_0; }

		//type=ID
		public Assignment getTypeAssignment_2_0_0_0() { return cTypeAssignment_2_0_0_0; }

		//ID
		public RuleCall getTypeIDTerminalRuleCall_2_0_0_0_0() { return cTypeIDTerminalRuleCall_2_0_0_0_0; }

		//name=ID
		public Assignment getNameAssignment_2_0_0_1() { return cNameAssignment_2_0_0_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0_0_1_0() { return cNameIDTerminalRuleCall_2_0_0_1_0; }

		//name=ID
		public Assignment getNameAssignment_2_1() { return cNameAssignment_2_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_1_0() { return cNameIDTerminalRuleCall_2_1_0; }
	}

	public class APropertyReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "APropertyReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAPropertyReferenceAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cPropertyAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cPropertyAbstractNamedValueCrossReference_2_0 = (CrossReference)cPropertyAssignment_2.eContents().get(0);
		private final RuleCall cPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1 = (RuleCall)cPropertyAbstractNamedValueCrossReference_2_0.eContents().get(1);
		
		//APropertyReference returns AExpression:
		//	{APropertyReference} "#" property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE];
		@Override public ParserRule getRule() { return rule; }

		//{APropertyReference} "#" property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public Group getGroup() { return cGroup; }

		//{APropertyReference}
		public Action getAPropertyReferenceAction_0() { return cAPropertyReferenceAction_0; }

		//"#"
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }

		//property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public Assignment getPropertyAssignment_2() { return cPropertyAssignment_2; }

		//[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE]
		public CrossReference getPropertyAbstractNamedValueCrossReference_2_0() { return cPropertyAbstractNamedValueCrossReference_2_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1() { return cPropertyAbstractNamedValueAADLPROPERTYREFERENCEParserRuleCall_2_0_1; }
	}

	public class AModelReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AModelReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAModelReferenceAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cCommercialAtKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cModelElementAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cModelElementNamedElementCrossReference_2_0 = (CrossReference)cModelElementAssignment_2.eContents().get(0);
		private final RuleCall cModelElementNamedElementQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cModelElementNamedElementCrossReference_2_0.eContents().get(1);
		
		//AModelReference returns AExpression:
		//	{AModelReference} "@" modelElement=[aadl2::NamedElement|QualifiedName];
		@Override public ParserRule getRule() { return rule; }

		//{AModelReference} "@" modelElement=[aadl2::NamedElement|QualifiedName]
		public Group getGroup() { return cGroup; }

		//{AModelReference}
		public Action getAModelReferenceAction_0() { return cAModelReferenceAction_0; }

		//"@"
		public Keyword getCommercialAtKeyword_1() { return cCommercialAtKeyword_1; }

		//modelElement=[aadl2::NamedElement|QualifiedName]
		public Assignment getModelElementAssignment_2() { return cModelElementAssignment_2; }

		//[aadl2::NamedElement|QualifiedName]
		public CrossReference getModelElementNamedElementCrossReference_2_0() { return cModelElementNamedElementCrossReference_2_0; }

		//QualifiedName
		public RuleCall getModelElementNamedElementQualifiedNameParserRuleCall_2_0_1() { return cModelElementNamedElementQualifiedNameParserRuleCall_2_0_1; }
	}

	public class AVariableReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AVariableReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAVariableReferenceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cVariableAVariableDeclarationCrossReference_1_0 = (CrossReference)cVariableAssignment_1.eContents().get(0);
		private final RuleCall cVariableAVariableDeclarationIDTerminalRuleCall_1_0_1 = (RuleCall)cVariableAVariableDeclarationCrossReference_1_0.eContents().get(1);
		
		//AVariableReference returns AExpression:
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ShowValue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cRefAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cRefAVariableDeclarationCrossReference_0_0 = (CrossReference)cRefAssignment_0.eContents().get(0);
		private final RuleCall cRefAVariableDeclarationIDTerminalRuleCall_0_0_1 = (RuleCall)cRefAVariableDeclarationCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cPercentSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cUnitAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_1_1_0 = (CrossReference)cUnitAssignment_1_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_1_0.eContents().get(1);
		
		//ShowValue:
		//	ref=[AVariableDeclaration] ("%" unit=[aadl2::UnitLiteral])?;
		@Override public ParserRule getRule() { return rule; }

		//ref=[AVariableDeclaration] ("%" unit=[aadl2::UnitLiteral])?
		public Group getGroup() { return cGroup; }

		//ref=[AVariableDeclaration]
		public Assignment getRefAssignment_0() { return cRefAssignment_0; }

		//[AVariableDeclaration]
		public CrossReference getRefAVariableDeclarationCrossReference_0_0() { return cRefAVariableDeclarationCrossReference_0_0; }

		//ID
		public RuleCall getRefAVariableDeclarationIDTerminalRuleCall_0_0_1() { return cRefAVariableDeclarationIDTerminalRuleCall_0_0_1; }

		//("%" unit=[aadl2::UnitLiteral])?
		public Group getGroup_1() { return cGroup_1; }

		//"%"
		public Keyword getPercentSignKeyword_1_0() { return cPercentSignKeyword_1_0; }

		//unit=[aadl2::UnitLiteral]
		public Assignment getUnitAssignment_1_1() { return cUnitAssignment_1_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_1_0() { return cUnitUnitLiteralCrossReference_1_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_1_0_1; }
	}

	public class ImageReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ImageReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cImgKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cImgfileAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cImgfileIMGREFParserRuleCall_1_0 = (RuleCall)cImgfileAssignment_1.eContents().get(0);
		
		//ImageReference:
		//	"img" imgfile=IMGREF;
		@Override public ParserRule getRule() { return rule; }

		//"img" imgfile=IMGREF
		public Group getGroup() { return cGroup; }

		//"img"
		public Keyword getImgKeyword_0() { return cImgKeyword_0; }

		//imgfile=IMGREF
		public Assignment getImgfileAssignment_1() { return cImgfileAssignment_1; }

		//IMGREF
		public RuleCall getImgfileIMGREFParserRuleCall_1_0() { return cImgfileIMGREFParserRuleCall_1_0; }
	}

	public class IMGREFElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IMGREF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_0_0 = (RuleCall)cGroup_0.eContents().get(0);
		private final Keyword cSolidusKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final RuleCall cIDTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//IMGREF:
		//	(ID "/")* ID "." ID;
		@Override public ParserRule getRule() { return rule; }

		//(ID "/")* ID "." ID
		public Group getGroup() { return cGroup; }

		//(ID "/")*
		public Group getGroup_0() { return cGroup_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_0_0() { return cIDTerminalRuleCall_0_0; }

		//"/"
		public Keyword getSolidusKeyword_0_1() { return cSolidusKeyword_0_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//"."
		public Keyword getFullStopKeyword_2() { return cFullStopKeyword_2; }

		//ID
		public RuleCall getIDTerminalRuleCall_3() { return cIDTerminalRuleCall_3; }
	}

	public class AExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AExpression");
		private final RuleCall cAOrExpressionParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//// Expressions
		//AExpression returns aadl2::PropertyExpression:
		//	AOrExpression;
		@Override public ParserRule getRule() { return rule; }

		//AOrExpression
		public RuleCall getAOrExpressionParserRuleCall() { return cAOrExpressionParserRuleCall; }
	}

	public class AOrExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AOrExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAAndExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cFeatureOpOrParserRuleCall_1_0_0_1_0 = (RuleCall)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandAAndExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//AOrExpression returns aadl2::PropertyExpression:
		//	AAndExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOr) rightOperand=AAndExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AAndExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOr) rightOperand=AAndExpression)*
		public Group getGroup() { return cGroup; }

		//AAndExpression
		public RuleCall getAAndExpressionParserRuleCall_0() { return cAAndExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.leftOperand=current} feature=OpOr) rightOperand=AAndExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.leftOperand=current} feature=OpOr)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.leftOperand=current} feature=OpOr
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.leftOperand=current}
		public Action getABinaryOperationLeftOperandAction_1_0_0_0() { return cABinaryOperationLeftOperandAction_1_0_0_0; }

		//feature=OpOr
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }

		//OpOr
		public RuleCall getFeatureOpOrParserRuleCall_1_0_0_1_0() { return cFeatureOpOrParserRuleCall_1_0_0_1_0; }

		//rightOperand=AAndExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }

		//AAndExpression
		public RuleCall getRightOperandAAndExpressionParserRuleCall_1_1_0() { return cRightOperandAAndExpressionParserRuleCall_1_1_0; }
	}

	public class OpOrElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpOr");
		private final Keyword cVerticalLineVerticalLineKeyword = (Keyword)rule.eContents().get(1);
		
		//OpOr:
		//	"||";
		@Override public ParserRule getRule() { return rule; }

		//"||"
		public Keyword getVerticalLineVerticalLineKeyword() { return cVerticalLineVerticalLineKeyword; }
	}

	public class AAndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AAndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAEqualityExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cFeatureOpAndParserRuleCall_1_0_0_1_0 = (RuleCall)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandAEqualityExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//AAndExpression returns aadl2::PropertyExpression:
		//	AEqualityExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAnd) rightOperand=AEqualityExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AEqualityExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAnd) rightOperand=AEqualityExpression)*
		public Group getGroup() { return cGroup; }

		//AEqualityExpression
		public RuleCall getAEqualityExpressionParserRuleCall_0() { return cAEqualityExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.leftOperand=current} feature=OpAnd) rightOperand=AEqualityExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.leftOperand=current} feature=OpAnd)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.leftOperand=current} feature=OpAnd
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.leftOperand=current}
		public Action getABinaryOperationLeftOperandAction_1_0_0_0() { return cABinaryOperationLeftOperandAction_1_0_0_0; }

		//feature=OpAnd
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }

		//OpAnd
		public RuleCall getFeatureOpAndParserRuleCall_1_0_0_1_0() { return cFeatureOpAndParserRuleCall_1_0_0_1_0; }

		//rightOperand=AEqualityExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }

		//AEqualityExpression
		public RuleCall getRightOperandAEqualityExpressionParserRuleCall_1_1_0() { return cRightOperandAEqualityExpressionParserRuleCall_1_1_0; }
	}

	public class OpAndElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpAnd");
		private final Keyword cAmpersandAmpersandKeyword = (Keyword)rule.eContents().get(1);
		
		//OpAnd:
		//	"&&";
		@Override public ParserRule getRule() { return rule; }

		//"&&"
		public Keyword getAmpersandAmpersandKeyword() { return cAmpersandAmpersandKeyword; }
	}

	public class AEqualityExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AEqualityExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cARelationalExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cFeatureOpEqualityParserRuleCall_1_0_0_1_0 = (RuleCall)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandARelationalExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//AEqualityExpression returns aadl2::PropertyExpression:
		//	ARelationalExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpEquality)
		//	rightOperand=ARelationalExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//ARelationalExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpEquality)
		//rightOperand=ARelationalExpression)*
		public Group getGroup() { return cGroup; }

		//ARelationalExpression
		public RuleCall getARelationalExpressionParserRuleCall_0() { return cARelationalExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.leftOperand=current} feature=OpEquality) rightOperand=ARelationalExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.leftOperand=current} feature=OpEquality)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.leftOperand=current} feature=OpEquality
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.leftOperand=current}
		public Action getABinaryOperationLeftOperandAction_1_0_0_0() { return cABinaryOperationLeftOperandAction_1_0_0_0; }

		//feature=OpEquality
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }

		//OpEquality
		public RuleCall getFeatureOpEqualityParserRuleCall_1_0_0_1_0() { return cFeatureOpEqualityParserRuleCall_1_0_0_1_0; }

		//rightOperand=ARelationalExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }

		//ARelationalExpression
		public RuleCall getRightOperandARelationalExpressionParserRuleCall_1_1_0() { return cRightOperandARelationalExpressionParserRuleCall_1_1_0; }
	}

	public class OpEqualityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpEquality");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cEqualsSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cExclamationMarkEqualsSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpEquality:
		//	"==" | "!=";
		@Override public ParserRule getRule() { return rule; }

		//"==" | "!="
		public Alternatives getAlternatives() { return cAlternatives; }

		//"=="
		public Keyword getEqualsSignEqualsSignKeyword_0() { return cEqualsSignEqualsSignKeyword_0; }

		//"!="
		public Keyword getExclamationMarkEqualsSignKeyword_1() { return cExclamationMarkEqualsSignKeyword_1; }
	}

	public class ARelationalExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ARelationalExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAOtherOperatorExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cFeatureOpCompareParserRuleCall_1_0_0_1_0 = (RuleCall)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandAOtherOperatorExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//ARelationalExpression returns aadl2::PropertyExpression:
		//	AOtherOperatorExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpCompare)
		//	rightOperand=AOtherOperatorExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AOtherOperatorExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpCompare)
		//rightOperand=AOtherOperatorExpression)*
		public Group getGroup() { return cGroup; }

		//AOtherOperatorExpression
		public RuleCall getAOtherOperatorExpressionParserRuleCall_0() { return cAOtherOperatorExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.leftOperand=current} feature=OpCompare) rightOperand=AOtherOperatorExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.leftOperand=current} feature=OpCompare)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.leftOperand=current} feature=OpCompare
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.leftOperand=current}
		public Action getABinaryOperationLeftOperandAction_1_0_0_0() { return cABinaryOperationLeftOperandAction_1_0_0_0; }

		//feature=OpCompare
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }

		//OpCompare
		public RuleCall getFeatureOpCompareParserRuleCall_1_0_0_1_0() { return cFeatureOpCompareParserRuleCall_1_0_0_1_0; }

		//rightOperand=AOtherOperatorExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }

		//AOtherOperatorExpression
		public RuleCall getRightOperandAOtherOperatorExpressionParserRuleCall_1_1_0() { return cRightOperandAOtherOperatorExpressionParserRuleCall_1_1_0; }
	}

	public class OpCompareElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpCompare");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cGreaterThanSignEqualsSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Group cGroup_1 = (Group)cAlternatives.eContents().get(1);
		private final Keyword cLessThanSignKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cLessThanSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//OpCompare:
		//	">=" | "<" "=" | ">" | "<";
		@Override public ParserRule getRule() { return rule; }

		//">=" | "<" "=" | ">" | "<"
		public Alternatives getAlternatives() { return cAlternatives; }

		//">="
		public Keyword getGreaterThanSignEqualsSignKeyword_0() { return cGreaterThanSignEqualsSignKeyword_0; }

		//"<" "="
		public Group getGroup_1() { return cGroup_1; }

		//"<"
		public Keyword getLessThanSignKeyword_1_0() { return cLessThanSignKeyword_1_0; }

		//"="
		public Keyword getEqualsSignKeyword_1_1() { return cEqualsSignKeyword_1_1; }

		//">"
		public Keyword getGreaterThanSignKeyword_2() { return cGreaterThanSignKeyword_2; }

		//"<"
		public Keyword getLessThanSignKeyword_3() { return cLessThanSignKeyword_3; }
	}

	public class AOtherOperatorExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AOtherOperatorExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAAdditiveExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cFeatureOpOtherParserRuleCall_1_0_0_1_0 = (RuleCall)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandAAdditiveExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//AOtherOperatorExpression returns aadl2::PropertyExpression:
		//	AAdditiveExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOther) rightOperand=AAdditiveExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AAdditiveExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOther) rightOperand=AAdditiveExpression)*
		public Group getGroup() { return cGroup; }

		//AAdditiveExpression
		public RuleCall getAAdditiveExpressionParserRuleCall_0() { return cAAdditiveExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.leftOperand=current} feature=OpOther) rightOperand=AAdditiveExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.leftOperand=current} feature=OpOther)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.leftOperand=current} feature=OpOther
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.leftOperand=current}
		public Action getABinaryOperationLeftOperandAction_1_0_0_0() { return cABinaryOperationLeftOperandAction_1_0_0_0; }

		//feature=OpOther
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }

		//OpOther
		public RuleCall getFeatureOpOtherParserRuleCall_1_0_0_1_0() { return cFeatureOpOtherParserRuleCall_1_0_0_1_0; }

		//rightOperand=AAdditiveExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }

		//AAdditiveExpression
		public RuleCall getRightOperandAAdditiveExpressionParserRuleCall_1_1_0() { return cRightOperandAAdditiveExpressionParserRuleCall_1_1_0; }
	}

	public class OpOtherElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpOther");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cFullStopFullStopLessThanSignKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cGreaterThanSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cFullStopFullStopKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Keyword cFullStopFullStopKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cEqualsSignGreaterThanSignKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Group cGroup_5 = (Group)cAlternatives.eContents().get(5);
		private final Keyword cGreaterThanSignKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Alternatives cAlternatives_5_1 = (Alternatives)cGroup_5.eContents().get(1);
		private final Group cGroup_5_1_0 = (Group)cAlternatives_5_1.eContents().get(0);
		private final Group cGroup_5_1_0_0 = (Group)cGroup_5_1_0.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_5_1_0_0_0 = (Keyword)cGroup_5_1_0_0.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_5_1_0_0_1 = (Keyword)cGroup_5_1_0_0.eContents().get(1);
		private final Keyword cGreaterThanSignKeyword_5_1_1 = (Keyword)cAlternatives_5_1.eContents().get(1);
		private final Group cGroup_6 = (Group)cAlternatives.eContents().get(6);
		private final Keyword cLessThanSignKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Alternatives cAlternatives_6_1 = (Alternatives)cGroup_6.eContents().get(1);
		private final Group cGroup_6_1_0 = (Group)cAlternatives_6_1.eContents().get(0);
		private final Group cGroup_6_1_0_0 = (Group)cGroup_6_1_0.eContents().get(0);
		private final Keyword cLessThanSignKeyword_6_1_0_0_0 = (Keyword)cGroup_6_1_0_0.eContents().get(0);
		private final Keyword cLessThanSignKeyword_6_1_0_0_1 = (Keyword)cGroup_6_1_0_0.eContents().get(1);
		private final Keyword cLessThanSignKeyword_6_1_1 = (Keyword)cAlternatives_6_1.eContents().get(1);
		private final Keyword cEqualsSignGreaterThanSignKeyword_6_1_2 = (Keyword)cAlternatives_6_1.eContents().get(2);
		private final Keyword cLessThanSignGreaterThanSignKeyword_7 = (Keyword)cAlternatives.eContents().get(7);
		private final Keyword cQuestionMarkColonKeyword_8 = (Keyword)cAlternatives.eContents().get(8);
		
		//OpOther:
		//	"->" | "..<" | ">" ".." | ".." | "=>" | ">" (=> (">" ">") | ">") | "<" (=> ("<" "<") | "<" | "=>") | "<>" | "?:";
		@Override public ParserRule getRule() { return rule; }

		//"->" | "..<" | ">" ".." | ".." | "=>" | ">" (=> (">" ">") | ">") | "<" (=> ("<" "<") | "<" | "=>") | "<>" | "?:"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"->"
		public Keyword getHyphenMinusGreaterThanSignKeyword_0() { return cHyphenMinusGreaterThanSignKeyword_0; }

		//"..<"
		public Keyword getFullStopFullStopLessThanSignKeyword_1() { return cFullStopFullStopLessThanSignKeyword_1; }

		//">" ".."
		public Group getGroup_2() { return cGroup_2; }

		//">"
		public Keyword getGreaterThanSignKeyword_2_0() { return cGreaterThanSignKeyword_2_0; }

		//".."
		public Keyword getFullStopFullStopKeyword_2_1() { return cFullStopFullStopKeyword_2_1; }

		//".."
		public Keyword getFullStopFullStopKeyword_3() { return cFullStopFullStopKeyword_3; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_4() { return cEqualsSignGreaterThanSignKeyword_4; }

		//">" (=> (">" ">") | ">")
		public Group getGroup_5() { return cGroup_5; }

		//">"
		public Keyword getGreaterThanSignKeyword_5_0() { return cGreaterThanSignKeyword_5_0; }

		//=> (">" ">") | ">"
		public Alternatives getAlternatives_5_1() { return cAlternatives_5_1; }

		//=> (">" ">")
		public Group getGroup_5_1_0() { return cGroup_5_1_0; }

		//">" ">"
		public Group getGroup_5_1_0_0() { return cGroup_5_1_0_0; }

		//">"
		public Keyword getGreaterThanSignKeyword_5_1_0_0_0() { return cGreaterThanSignKeyword_5_1_0_0_0; }

		//">"
		public Keyword getGreaterThanSignKeyword_5_1_0_0_1() { return cGreaterThanSignKeyword_5_1_0_0_1; }

		//">"
		public Keyword getGreaterThanSignKeyword_5_1_1() { return cGreaterThanSignKeyword_5_1_1; }

		//"<" (=> ("<" "<") | "<" | "=>")
		public Group getGroup_6() { return cGroup_6; }

		//"<"
		public Keyword getLessThanSignKeyword_6_0() { return cLessThanSignKeyword_6_0; }

		//=> ("<" "<") | "<" | "=>"
		public Alternatives getAlternatives_6_1() { return cAlternatives_6_1; }

		//=> ("<" "<")
		public Group getGroup_6_1_0() { return cGroup_6_1_0; }

		//"<" "<"
		public Group getGroup_6_1_0_0() { return cGroup_6_1_0_0; }

		//"<"
		public Keyword getLessThanSignKeyword_6_1_0_0_0() { return cLessThanSignKeyword_6_1_0_0_0; }

		//"<"
		public Keyword getLessThanSignKeyword_6_1_0_0_1() { return cLessThanSignKeyword_6_1_0_0_1; }

		//"<"
		public Keyword getLessThanSignKeyword_6_1_1() { return cLessThanSignKeyword_6_1_1; }

		//"=>"
		public Keyword getEqualsSignGreaterThanSignKeyword_6_1_2() { return cEqualsSignGreaterThanSignKeyword_6_1_2; }

		//"<>"
		public Keyword getLessThanSignGreaterThanSignKeyword_7() { return cLessThanSignGreaterThanSignKeyword_7; }

		//"?:"
		public Keyword getQuestionMarkColonKeyword_8() { return cQuestionMarkColonKeyword_8; }
	}

	public class AAdditiveExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AAdditiveExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAMultiplicativeExpressionParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cFeatureOpAddParserRuleCall_1_0_0_1_0 = (RuleCall)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandAMultiplicativeExpressionParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//AAdditiveExpression returns aadl2::PropertyExpression:
		//	AMultiplicativeExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAdd)
		//	rightOperand=AMultiplicativeExpression)*;
		@Override public ParserRule getRule() { return rule; }

		//AMultiplicativeExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAdd)
		//rightOperand=AMultiplicativeExpression)*
		public Group getGroup() { return cGroup; }

		//AMultiplicativeExpression
		public RuleCall getAMultiplicativeExpressionParserRuleCall_0() { return cAMultiplicativeExpressionParserRuleCall_0; }

		//(=> ({ABinaryOperation.leftOperand=current} feature=OpAdd) rightOperand=AMultiplicativeExpression)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.leftOperand=current} feature=OpAdd)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.leftOperand=current} feature=OpAdd
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.leftOperand=current}
		public Action getABinaryOperationLeftOperandAction_1_0_0_0() { return cABinaryOperationLeftOperandAction_1_0_0_0; }

		//feature=OpAdd
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }

		//OpAdd
		public RuleCall getFeatureOpAddParserRuleCall_1_0_0_1_0() { return cFeatureOpAddParserRuleCall_1_0_0_1_0; }

		//rightOperand=AMultiplicativeExpression
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }

		//AMultiplicativeExpression
		public RuleCall getRightOperandAMultiplicativeExpressionParserRuleCall_1_1_0() { return cRightOperandAMultiplicativeExpressionParserRuleCall_1_1_0; }
	}

	public class OpAddElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpAdd");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cPlusSignKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//OpAdd:
		//	"+" | "-";
		@Override public ParserRule getRule() { return rule; }

		//"+" | "-"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"+"
		public Keyword getPlusSignKeyword_0() { return cPlusSignKeyword_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }
	}

	public class AMultiplicativeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AMultiplicativeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cAUnaryOperationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cABinaryOperationLeftOperandAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Assignment cFeatureAssignment_1_0_0_1 = (Assignment)cGroup_1_0_0.eContents().get(1);
		private final RuleCall cFeatureOpMultiParserRuleCall_1_0_0_1_0 = (RuleCall)cFeatureAssignment_1_0_0_1.eContents().get(0);
		private final Assignment cRightOperandAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cRightOperandAUnaryOperationParserRuleCall_1_1_0 = (RuleCall)cRightOperandAssignment_1_1.eContents().get(0);
		
		//AMultiplicativeExpression returns aadl2::PropertyExpression:
		//	AUnaryOperation (=> ({ABinaryOperation.leftOperand=current} feature=OpMulti) rightOperand=AUnaryOperation)*;
		@Override public ParserRule getRule() { return rule; }

		//AUnaryOperation (=> ({ABinaryOperation.leftOperand=current} feature=OpMulti) rightOperand=AUnaryOperation)*
		public Group getGroup() { return cGroup; }

		//AUnaryOperation
		public RuleCall getAUnaryOperationParserRuleCall_0() { return cAUnaryOperationParserRuleCall_0; }

		//(=> ({ABinaryOperation.leftOperand=current} feature=OpMulti) rightOperand=AUnaryOperation)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ABinaryOperation.leftOperand=current} feature=OpMulti)
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ABinaryOperation.leftOperand=current} feature=OpMulti
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ABinaryOperation.leftOperand=current}
		public Action getABinaryOperationLeftOperandAction_1_0_0_0() { return cABinaryOperationLeftOperandAction_1_0_0_0; }

		//feature=OpMulti
		public Assignment getFeatureAssignment_1_0_0_1() { return cFeatureAssignment_1_0_0_1; }

		//OpMulti
		public RuleCall getFeatureOpMultiParserRuleCall_1_0_0_1_0() { return cFeatureOpMultiParserRuleCall_1_0_0_1_0; }

		//rightOperand=AUnaryOperation
		public Assignment getRightOperandAssignment_1_1() { return cRightOperandAssignment_1_1; }

		//AUnaryOperation
		public RuleCall getRightOperandAUnaryOperationParserRuleCall_1_1_0() { return cRightOperandAUnaryOperationParserRuleCall_1_1_0; }
	}

	public class OpMultiElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpMulti");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAsteriskKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cAsteriskAsteriskKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cSolidusKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cPercentSignKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		
		//OpMulti:
		//	"*" | "**" | "/" | "%";
		@Override public ParserRule getRule() { return rule; }

		//"*" | "**" | "/" | "%"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"*"
		public Keyword getAsteriskKeyword_0() { return cAsteriskKeyword_0; }

		//"**"
		public Keyword getAsteriskAsteriskKeyword_1() { return cAsteriskAsteriskKeyword_1; }

		//"/"
		public Keyword getSolidusKeyword_2() { return cSolidusKeyword_2; }

		//"%"
		public Keyword getPercentSignKeyword_3() { return cPercentSignKeyword_3; }
	}

	public class AUnaryOperationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AUnaryOperation");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Action cAUnaryOperationAction_0_0 = (Action)cGroup_0.eContents().get(0);
		private final Assignment cFeatureAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cFeatureOpUnaryParserRuleCall_0_1_0 = (RuleCall)cFeatureAssignment_0_1.eContents().get(0);
		private final Assignment cOperandAssignment_0_2 = (Assignment)cGroup_0.eContents().get(2);
		private final RuleCall cOperandAUnaryOperationParserRuleCall_0_2_0 = (RuleCall)cOperandAssignment_0_2.eContents().get(0);
		private final RuleCall cAPrimaryExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AUnaryOperation returns aadl2::PropertyExpression:
		//	{AUnaryOperation} feature=OpUnary operand=AUnaryOperation | APrimaryExpression;
		@Override public ParserRule getRule() { return rule; }

		//{AUnaryOperation} feature=OpUnary operand=AUnaryOperation | APrimaryExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//{AUnaryOperation} feature=OpUnary operand=AUnaryOperation
		public Group getGroup_0() { return cGroup_0; }

		//{AUnaryOperation}
		public Action getAUnaryOperationAction_0_0() { return cAUnaryOperationAction_0_0; }

		//feature=OpUnary
		public Assignment getFeatureAssignment_0_1() { return cFeatureAssignment_0_1; }

		//OpUnary
		public RuleCall getFeatureOpUnaryParserRuleCall_0_1_0() { return cFeatureOpUnaryParserRuleCall_0_1_0; }

		//operand=AUnaryOperation
		public Assignment getOperandAssignment_0_2() { return cOperandAssignment_0_2; }

		//AUnaryOperation
		public RuleCall getOperandAUnaryOperationParserRuleCall_0_2_0() { return cOperandAUnaryOperationParserRuleCall_0_2_0; }

		//APrimaryExpression
		public RuleCall getAPrimaryExpressionParserRuleCall_1() { return cAPrimaryExpressionParserRuleCall_1; }
	}

	public class OpUnaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OpUnary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cExclamationMarkKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cHyphenMinusKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cPlusSignKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		
		//OpUnary:
		//	"!" | "-" | "+";
		@Override public ParserRule getRule() { return rule; }

		//"!" | "-" | "+"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"!"
		public Keyword getExclamationMarkKeyword_0() { return cExclamationMarkKeyword_0; }

		//"-"
		public Keyword getHyphenMinusKeyword_1() { return cHyphenMinusKeyword_1; }

		//"+"
		public Keyword getPlusSignKeyword_2() { return cPlusSignKeyword_2; }
	}

	public class APrimaryExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "APrimaryExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cALiteralParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAVariableReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cAPropertyReferenceParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cAFunctionCallParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cAParenthesizedExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//APrimaryExpression returns aadl2::PropertyExpression:
		//	ALiteral | AVariableReference | APropertyReference | AFunctionCall | AParenthesizedExpression;
		@Override public ParserRule getRule() { return rule; }

		//ALiteral | AVariableReference | APropertyReference | AFunctionCall | AParenthesizedExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//ALiteral
		public RuleCall getALiteralParserRuleCall_0() { return cALiteralParserRuleCall_0; }

		//AVariableReference
		public RuleCall getAVariableReferenceParserRuleCall_1() { return cAVariableReferenceParserRuleCall_1; }

		//APropertyReference
		public RuleCall getAPropertyReferenceParserRuleCall_2() { return cAPropertyReferenceParserRuleCall_2; }

		//AFunctionCall
		public RuleCall getAFunctionCallParserRuleCall_3() { return cAFunctionCallParserRuleCall_3; }

		//AParenthesizedExpression
		public RuleCall getAParenthesizedExpressionParserRuleCall_4() { return cAParenthesizedExpressionParserRuleCall_4; }
	}

	public class AFunctionCallElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AFunctionCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAFunctionCallAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cFunctionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFunctionIDTerminalRuleCall_1_0 = (RuleCall)cFunctionAssignment_1.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cFunctionCallArgumentsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cFunctionCallArgumentsAExpressionParserRuleCall_3_0 = (RuleCall)cFunctionCallArgumentsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cFunctionCallArgumentsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cFunctionCallArgumentsAExpressionParserRuleCall_4_1_0 = (RuleCall)cFunctionCallArgumentsAssignment_4_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//AFunctionCall returns aadl2::PropertyExpression:
		//	{AFunctionCall} function=ID "(" functionCallArguments+=AExpression ("," functionCallArguments+=AExpression)* ")";
		@Override public ParserRule getRule() { return rule; }

		//{AFunctionCall} function=ID "(" functionCallArguments+=AExpression ("," functionCallArguments+=AExpression)* ")"
		public Group getGroup() { return cGroup; }

		//{AFunctionCall}
		public Action getAFunctionCallAction_0() { return cAFunctionCallAction_0; }

		//function=ID
		public Assignment getFunctionAssignment_1() { return cFunctionAssignment_1; }

		//ID
		public RuleCall getFunctionIDTerminalRuleCall_1_0() { return cFunctionIDTerminalRuleCall_1_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_2() { return cLeftParenthesisKeyword_2; }

		//functionCallArguments+=AExpression
		public Assignment getFunctionCallArgumentsAssignment_3() { return cFunctionCallArgumentsAssignment_3; }

		//AExpression
		public RuleCall getFunctionCallArgumentsAExpressionParserRuleCall_3_0() { return cFunctionCallArgumentsAExpressionParserRuleCall_3_0; }

		//("," functionCallArguments+=AExpression)*
		public Group getGroup_4() { return cGroup_4; }

		//","
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//functionCallArguments+=AExpression
		public Assignment getFunctionCallArgumentsAssignment_4_1() { return cFunctionCallArgumentsAssignment_4_1; }

		//AExpression
		public RuleCall getFunctionCallArgumentsAExpressionParserRuleCall_4_1_0() { return cFunctionCallArgumentsAExpressionParserRuleCall_4_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}

	public class AThisElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AThis");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAThisAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cThisKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//AThis returns aadl2::PropertyExpression:
		//	{AThis} "this";
		@Override public ParserRule getRule() { return rule; }

		//{AThis} "this"
		public Group getGroup() { return cGroup; }

		//{AThis}
		public Action getAThisAction_0() { return cAThisAction_0; }

		//"this"
		public Keyword getThisKeyword_1() { return cThisKeyword_1; }
	}

	public class ALiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ALiteral");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cASetTermParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAListTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cABooleanLiteralParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cARealTermParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cAIntegerTermParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cANullLiteralParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cStringTermParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cAThisParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		
		//ALiteral returns aadl2::PropertyExpression:
		//	ASetTerm | AListTerm | ABooleanLiteral | ARealTerm | AIntegerTerm | ANullLiteral | StringTerm | AThis;
		@Override public ParserRule getRule() { return rule; }

		//ASetTerm | AListTerm | ABooleanLiteral | ARealTerm | AIntegerTerm | ANullLiteral | StringTerm | AThis
		public Alternatives getAlternatives() { return cAlternatives; }

		//ASetTerm
		public RuleCall getASetTermParserRuleCall_0() { return cASetTermParserRuleCall_0; }

		//AListTerm
		public RuleCall getAListTermParserRuleCall_1() { return cAListTermParserRuleCall_1; }

		//ABooleanLiteral
		public RuleCall getABooleanLiteralParserRuleCall_2() { return cABooleanLiteralParserRuleCall_2; }

		//ARealTerm
		public RuleCall getARealTermParserRuleCall_3() { return cARealTermParserRuleCall_3; }

		//AIntegerTerm
		public RuleCall getAIntegerTermParserRuleCall_4() { return cAIntegerTermParserRuleCall_4; }

		//ANullLiteral
		public RuleCall getANullLiteralParserRuleCall_5() { return cANullLiteralParserRuleCall_5; }

		//StringTerm
		public RuleCall getStringTermParserRuleCall_6() { return cStringTermParserRuleCall_6; }

		//AThis
		public RuleCall getAThisParserRuleCall_7() { return cAThisParserRuleCall_7; }
	}

	public class AIntegerTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AIntegerTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cValueAIntParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cUnitAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_1_0 = (CrossReference)cUnitAssignment_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_0.eContents().get(1);
		
		//AIntegerTerm returns aadl2::IntegerLiteral:
		//	value=AInt unit=[aadl2::UnitLiteral]?;
		@Override public ParserRule getRule() { return rule; }

		//value=AInt unit=[aadl2::UnitLiteral]?
		public Group getGroup() { return cGroup; }

		//value=AInt
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//AInt
		public RuleCall getValueAIntParserRuleCall_0_0() { return cValueAIntParserRuleCall_0_0; }

		//unit=[aadl2::UnitLiteral]?
		public Assignment getUnitAssignment_1() { return cUnitAssignment_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_0() { return cUnitUnitLiteralCrossReference_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_0_1; }
	}

	public class AIntElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AInt");
		private final RuleCall cINTTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AInt returns aadl2::Integer:
		//	INT;
		@Override public ParserRule getRule() { return rule; }

		//INT
		public RuleCall getINTTerminalRuleCall() { return cINTTerminalRuleCall; }
	}

	public class ARealTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ARealTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cValueARealParserRuleCall_0_0 = (RuleCall)cValueAssignment_0.eContents().get(0);
		private final Assignment cUnitAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_1_0 = (CrossReference)cUnitAssignment_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_1_0.eContents().get(1);
		
		//ARealTerm returns aadl2::RealLiteral:
		//	value=AReal unit=[aadl2::UnitLiteral]?;
		@Override public ParserRule getRule() { return rule; }

		//value=AReal unit=[aadl2::UnitLiteral]?
		public Group getGroup() { return cGroup; }

		//value=AReal
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//AReal
		public RuleCall getValueARealParserRuleCall_0_0() { return cValueARealParserRuleCall_0_0; }

		//unit=[aadl2::UnitLiteral]?
		public Assignment getUnitAssignment_1() { return cUnitAssignment_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_1_0() { return cUnitUnitLiteralCrossReference_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_1_0_1; }
	}

	public class ARealElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AReal");
		private final RuleCall cREAL_LITTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//AReal returns aadl2::Real:
		//	REAL_LIT;
		@Override public ParserRule getRule() { return rule; }

		//REAL_LIT
		public RuleCall getREAL_LITTerminalRuleCall() { return cREAL_LITTerminalRuleCall; }
	}

	public class ANumericRangeTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ANumericRangeTerm");
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
		
		//ANumericRangeTerm returns aadl2::RangeValue:
		//	minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
		//	NumAlt ".." maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//	NumAlt ("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//	NumAlt)?;
		@Override public ParserRule getRule() { return rule; }

		//minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
		//NumAlt ".." maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//NumAlt ("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//NumAlt)?
		public Group getGroup() { return cGroup; }

		//minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
		//NumAlt
		public Assignment getMinimumAssignment_0() { return cMinimumAssignment_0; }

		////(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
		//NumAlt
		public RuleCall getMinimumNumAltParserRuleCall_0_0() { return cMinimumNumAltParserRuleCall_0_0; }

		//".."
		public Keyword getFullStopFullStopKeyword_1() { return cFullStopFullStopKeyword_1; }

		//maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//NumAlt
		public Assignment getMaximumAssignment_2() { return cMaximumAssignment_2; }

		////(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//NumAlt
		public RuleCall getMaximumNumAltParserRuleCall_2_0() { return cMaximumNumAltParserRuleCall_2_0; }

		//("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//NumAlt)?
		public Group getGroup_3() { return cGroup_3; }

		//"delta"
		public Keyword getDeltaKeyword_3_0() { return cDeltaKeyword_3_0; }

		//delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//NumAlt
		public Assignment getDeltaAssignment_3_1() { return cDeltaAssignment_3_1; }

		////(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
		//NumAlt
		public RuleCall getDeltaNumAltParserRuleCall_3_1_0() { return cDeltaNumAltParserRuleCall_3_1_0; }
	}

	public class NumAltElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NumAlt");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cARealTermParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAIntegerTermParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//NumAlt returns aadl2::PropertyExpression:
		//	ARealTerm | AIntegerTerm;
		@Override public ParserRule getRule() { return rule; }

		//ARealTerm | AIntegerTerm
		public Alternatives getAlternatives() { return cAlternatives; }

		//ARealTerm
		public RuleCall getARealTermParserRuleCall_0() { return cARealTermParserRuleCall_0; }

		//AIntegerTerm
		public RuleCall getAIntegerTermParserRuleCall_1() { return cAIntegerTermParserRuleCall_1; }
	}

	public class ASetTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ASetTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cASetLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final RuleCall cElementsAExpressionParserRuleCall_2_0_0 = (RuleCall)cElementsAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cElementsAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cElementsAExpressionParserRuleCall_2_1_1_0 = (RuleCall)cElementsAssignment_2_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//ASetTerm returns aadl2::PropertyExpression: //	{ASetLiteral} '#' '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
		//	{ASetLiteral} "{" (elements+=AExpression ("," elements+=AExpression)*)? "}";
		@Override public ParserRule getRule() { return rule; }

		////	{ASetLiteral} '#' '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
		//{ASetLiteral} "{" (elements+=AExpression ("," elements+=AExpression)*)? "}"
		public Group getGroup() { return cGroup; }

		////	{ASetLiteral} '#' '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
		//{ASetLiteral}
		public Action getASetLiteralAction_0() { return cASetLiteralAction_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//(elements+=AExpression ("," elements+=AExpression)*)?
		public Group getGroup_2() { return cGroup_2; }

		//elements+=AExpression
		public Assignment getElementsAssignment_2_0() { return cElementsAssignment_2_0; }

		//AExpression
		public RuleCall getElementsAExpressionParserRuleCall_2_0_0() { return cElementsAExpressionParserRuleCall_2_0_0; }

		//("," elements+=AExpression)*
		public Group getGroup_2_1() { return cGroup_2_1; }

		//","
		public Keyword getCommaKeyword_2_1_0() { return cCommaKeyword_2_1_0; }

		//elements+=AExpression
		public Assignment getElementsAssignment_2_1_1() { return cElementsAssignment_2_1_1; }

		//AExpression
		public RuleCall getElementsAExpressionParserRuleCall_2_1_1_0() { return cElementsAExpressionParserRuleCall_2_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class AListTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AListTerm");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAListTermAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cElementsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cElementsAExpressionParserRuleCall_3_0_0 = (RuleCall)cElementsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cElementsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cElementsAExpressionParserRuleCall_3_1_1_0 = (RuleCall)cElementsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//AListTerm returns aadl2::PropertyExpression:
		//	{AListTerm} "#" "[" (elements+=AExpression ("," elements+=AExpression)*)? "]";
		@Override public ParserRule getRule() { return rule; }

		//{AListTerm} "#" "[" (elements+=AExpression ("," elements+=AExpression)*)? "]"
		public Group getGroup() { return cGroup; }

		//{AListTerm}
		public Action getAListTermAction_0() { return cAListTermAction_0; }

		//"#"
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//(elements+=AExpression ("," elements+=AExpression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//elements+=AExpression
		public Assignment getElementsAssignment_3_0() { return cElementsAssignment_3_0; }

		//AExpression
		public RuleCall getElementsAExpressionParserRuleCall_3_0_0() { return cElementsAExpressionParserRuleCall_3_0_0; }

		//("," elements+=AExpression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//elements+=AExpression
		public Assignment getElementsAssignment_3_1_1() { return cElementsAssignment_3_1_1; }

		//AExpression
		public RuleCall getElementsAExpressionParserRuleCall_3_1_1_0() { return cElementsAExpressionParserRuleCall_3_1_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class AParenthesizedExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AParenthesizedExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cAExpressionParserRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//AParenthesizedExpression returns aadl2::PropertyExpression:
		//	"(" AExpression ")";
		@Override public ParserRule getRule() { return rule; }

		//"(" AExpression ")"
		public Group getGroup() { return cGroup; }

		//"("
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//AExpression
		public RuleCall getAExpressionParserRuleCall_1() { return cAExpressionParserRuleCall_1; }

		//")"
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}

	public class ABooleanLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ABooleanLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cBooleanLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cValueTrueKeyword_1_0_0 = (Keyword)cValueAssignment_1_0.eContents().get(0);
		private final Keyword cFalseKeyword_1_1 = (Keyword)cAlternatives_1.eContents().get(1);
		
		//ABooleanLiteral returns aadl2::PropertyExpression:
		//	{aadl2::BooleanLiteral} (value?="true" | "false");
		@Override public ParserRule getRule() { return rule; }

		//{aadl2::BooleanLiteral} (value?="true" | "false")
		public Group getGroup() { return cGroup; }

		//{aadl2::BooleanLiteral}
		public Action getBooleanLiteralAction_0() { return cBooleanLiteralAction_0; }

		//value?="true" | "false"
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//value?="true"
		public Assignment getValueAssignment_1_0() { return cValueAssignment_1_0; }

		//"true"
		public Keyword getValueTrueKeyword_1_0_0() { return cValueTrueKeyword_1_0_0; }

		//"false"
		public Keyword getFalseKeyword_1_1() { return cFalseKeyword_1_1; }
	}

	public class ANullLiteralElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ANullLiteral");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cANullLiteralAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNullKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//ANullLiteral returns aadl2::PropertyExpression:
		//	{ANullLiteral} "null";
		@Override public ParserRule getRule() { return rule; }

		//{ANullLiteral} "null"
		public Group getGroup() { return cGroup; }

		//{ANullLiteral}
		public Action getANullLiteralAction_0() { return cANullLiteralAction_0; }

		//"null"
		public Keyword getNullKeyword_1() { return cNullKeyword_1; }
	}

	public class StringTermElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StringTerm");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueNoQuoteStringParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//StringTerm returns aadl2::StringLiteral:
		//	value=NoQuoteString;
		@Override public ParserRule getRule() { return rule; }

		//value=NoQuoteString
		public Assignment getValueAssignment() { return cValueAssignment; }

		//NoQuoteString
		public RuleCall getValueNoQuoteStringParserRuleCall_0() { return cValueNoQuoteStringParserRuleCall_0; }
	}

	public class NoQuoteStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NoQuoteString");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//NoQuoteString: // remove quotes from string in ValueConverter
		//	STRING;
		@Override public ParserRule getRule() { return rule; }

		//// remove quotes from string in ValueConverter
		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}

	public class ComponentCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ComponentCategory");
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
		
		//ComponentCategory returns aadl2::ComponentCategory:
		//	"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
		//	"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor";
		@Override public ParserRule getRule() { return rule; }

		//"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
		//"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"abstract"
		public Keyword getAbstractKeyword_0() { return cAbstractKeyword_0; }

		//"bus"
		public Keyword getBusKeyword_1() { return cBusKeyword_1; }

		//"data"
		public Keyword getDataKeyword_2() { return cDataKeyword_2; }

		//"device"
		public Keyword getDeviceKeyword_3() { return cDeviceKeyword_3; }

		//"memory"
		public Keyword getMemoryKeyword_4() { return cMemoryKeyword_4; }

		//"process"
		public Keyword getProcessKeyword_5() { return cProcessKeyword_5; }

		//"processor"
		public Keyword getProcessorKeyword_6() { return cProcessorKeyword_6; }

		//"subprogram"
		public Keyword getSubprogramKeyword_7() { return cSubprogramKeyword_7; }

		//"subprogram" "group"
		public Group getGroup_8() { return cGroup_8; }

		//"subprogram"
		public Keyword getSubprogramKeyword_8_0() { return cSubprogramKeyword_8_0; }

		//"group"
		public Keyword getGroupKeyword_8_1() { return cGroupKeyword_8_1; }

		//"system"
		public Keyword getSystemKeyword_9() { return cSystemKeyword_9; }

		//"thread" "group"
		public Group getGroup_10() { return cGroup_10; }

		//"thread"
		public Keyword getThreadKeyword_10_0() { return cThreadKeyword_10_0; }

		//"group"
		public Keyword getGroupKeyword_10_1() { return cGroupKeyword_10_1; }

		//"thread"
		public Keyword getThreadKeyword_11() { return cThreadKeyword_11; }

		//"virtual" "bus"
		public Group getGroup_12() { return cGroup_12; }

		//"virtual"
		public Keyword getVirtualKeyword_12_0() { return cVirtualKeyword_12_0; }

		//"bus"
		public Keyword getBusKeyword_12_1() { return cBusKeyword_12_1; }

		//"virtual" "processor"
		public Group getGroup_13() { return cGroup_13; }

		//"virtual"
		public Keyword getVirtualKeyword_13_0() { return cVirtualKeyword_13_0; }

		//"processor"
		public Keyword getProcessorKeyword_13_1() { return cProcessorKeyword_13_1; }
	}

	public class AadlClassifierReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AadlClassifierReference");
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
		//	ID ("::" ID)+ ("." ID)?;
		@Override public ParserRule getRule() { return rule; }

		//ID ("::" ID)+ ("." ID)?
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("::" ID)+
		public Group getGroup_1() { return cGroup_1; }

		//"::"
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }

		//("." ID)?
		public Group getGroup_2() { return cGroup_2; }

		//"."
		public Keyword getFullStopKeyword_2_0() { return cFullStopKeyword_2_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_2_1() { return cIDTerminalRuleCall_2_1; }
	}

	public class AADLPROPERTYREFERENCEElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AADLPROPERTYREFERENCE");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//AADLPROPERTYREFERENCE:
		//	ID ("::" ID)?;
		@Override public ParserRule getRule() { return rule; }

		//ID ("::" ID)?
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("::" ID)?
		public Group getGroup_1() { return cGroup_1; }

		//"::"
		public Keyword getColonColonKeyword_1_0() { return cColonColonKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}

	public class URIIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "URIID");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//URIID:
		//	STRING;
		@Override public ParserRule getRule() { return rule; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}

	public class QualifiedNameElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		////terminal URIID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'#'|'@'|'/'|':')*;
		//QualifiedName:
		//	ID ("." ID)*;
		@Override public ParserRule getRule() { return rule; }

		//ID ("." ID)*
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//("." ID)*
		public Group getGroup_1() { return cGroup_1; }

		//"."
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	public class ResultIssueTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ResultIssueType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cTBDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cTBDTbdKeyword_0_0 = (Keyword)cTBDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cERROREnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cERRORErrorKeyword_1_0 = (Keyword)cERROREnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cWARNINGEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cWARNINGWarningKeyword_2_0 = (Keyword)cWARNINGEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cINFOEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cINFOInfoKeyword_3_0 = (Keyword)cINFOEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cSUCCESSEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cSUCCESSSuccessKeyword_4_0 = (Keyword)cSUCCESSEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cFAILEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cFAILFailKeyword_5_0 = (Keyword)cFAILEnumLiteralDeclaration_5.eContents().get(0);
		
		//enum ResultIssueType:
		//	TBD="tbd" | ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail";
		public EnumRule getRule() { return rule; }

		//TBD="tbd" | ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail"
		public Alternatives getAlternatives() { return cAlternatives; }

		//TBD="tbd"
		public EnumLiteralDeclaration getTBDEnumLiteralDeclaration_0() { return cTBDEnumLiteralDeclaration_0; }

		//"tbd"
		public Keyword getTBDTbdKeyword_0_0() { return cTBDTbdKeyword_0_0; }

		//ERROR="error"
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_1() { return cERROREnumLiteralDeclaration_1; }

		//"error"
		public Keyword getERRORErrorKeyword_1_0() { return cERRORErrorKeyword_1_0; }

		//WARNING="warning"
		public EnumLiteralDeclaration getWARNINGEnumLiteralDeclaration_2() { return cWARNINGEnumLiteralDeclaration_2; }

		//"warning"
		public Keyword getWARNINGWarningKeyword_2_0() { return cWARNINGWarningKeyword_2_0; }

		//INFO="info"
		public EnumLiteralDeclaration getINFOEnumLiteralDeclaration_3() { return cINFOEnumLiteralDeclaration_3; }

		//"info"
		public Keyword getINFOInfoKeyword_3_0() { return cINFOInfoKeyword_3_0; }

		//SUCCESS="success"
		public EnumLiteralDeclaration getSUCCESSEnumLiteralDeclaration_4() { return cSUCCESSEnumLiteralDeclaration_4; }

		//"success"
		public Keyword getSUCCESSSuccessKeyword_4_0() { return cSUCCESSSuccessKeyword_4_0; }

		//FAIL="fail"
		public EnumLiteralDeclaration getFAILEnumLiteralDeclaration_5() { return cFAILEnumLiteralDeclaration_5; }

		//"fail"
		public Keyword getFAILFailKeyword_5_0() { return cFAILFailKeyword_5_0; }
	}
	
	private final DescriptionElements pDescription;
	private final DescriptionElementElements pDescriptionElement;
	private final RationaleElements pRationale;
	private final UncertaintyElements pUncertainty;
	private final ResultIssueElements pResultIssue;
	private final ResultIssueTypeElements unknownRuleResultIssueType;
	private final ValDeclarationElements pValDeclaration;
	private final ComputeDeclarationElements pComputeDeclaration;
	private final APropertyReferenceElements pAPropertyReference;
	private final AModelReferenceElements pAModelReference;
	private final AVariableReferenceElements pAVariableReference;
	private final ShowValueElements pShowValue;
	private final ImageReferenceElements pImageReference;
	private final IMGREFElements pIMGREF;
	private final AExpressionElements pAExpression;
	private final AOrExpressionElements pAOrExpression;
	private final OpOrElements pOpOr;
	private final AAndExpressionElements pAAndExpression;
	private final OpAndElements pOpAnd;
	private final AEqualityExpressionElements pAEqualityExpression;
	private final OpEqualityElements pOpEquality;
	private final ARelationalExpressionElements pARelationalExpression;
	private final OpCompareElements pOpCompare;
	private final AOtherOperatorExpressionElements pAOtherOperatorExpression;
	private final OpOtherElements pOpOther;
	private final AAdditiveExpressionElements pAAdditiveExpression;
	private final OpAddElements pOpAdd;
	private final AMultiplicativeExpressionElements pAMultiplicativeExpression;
	private final OpMultiElements pOpMulti;
	private final AUnaryOperationElements pAUnaryOperation;
	private final OpUnaryElements pOpUnary;
	private final APrimaryExpressionElements pAPrimaryExpression;
	private final AFunctionCallElements pAFunctionCall;
	private final AThisElements pAThis;
	private final ALiteralElements pALiteral;
	private final AIntegerTermElements pAIntegerTerm;
	private final AIntElements pAInt;
	private final ARealTermElements pARealTerm;
	private final ARealElements pAReal;
	private final ANumericRangeTermElements pANumericRangeTerm;
	private final NumAltElements pNumAlt;
	private final ASetTermElements pASetTerm;
	private final AListTermElements pAListTerm;
	private final AParenthesizedExpressionElements pAParenthesizedExpression;
	private final ABooleanLiteralElements pABooleanLiteral;
	private final ANullLiteralElements pANullLiteral;
	private final StringTermElements pStringTerm;
	private final NoQuoteStringElements pNoQuoteString;
	private final ComponentCategoryElements pComponentCategory;
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
		this.pResultIssue = new ResultIssueElements();
		this.unknownRuleResultIssueType = new ResultIssueTypeElements();
		this.pValDeclaration = new ValDeclarationElements();
		this.pComputeDeclaration = new ComputeDeclarationElements();
		this.pAPropertyReference = new APropertyReferenceElements();
		this.pAModelReference = new AModelReferenceElements();
		this.pAVariableReference = new AVariableReferenceElements();
		this.pShowValue = new ShowValueElements();
		this.pImageReference = new ImageReferenceElements();
		this.pIMGREF = new IMGREFElements();
		this.pAExpression = new AExpressionElements();
		this.pAOrExpression = new AOrExpressionElements();
		this.pOpOr = new OpOrElements();
		this.pAAndExpression = new AAndExpressionElements();
		this.pOpAnd = new OpAndElements();
		this.pAEqualityExpression = new AEqualityExpressionElements();
		this.pOpEquality = new OpEqualityElements();
		this.pARelationalExpression = new ARelationalExpressionElements();
		this.pOpCompare = new OpCompareElements();
		this.pAOtherOperatorExpression = new AOtherOperatorExpressionElements();
		this.pOpOther = new OpOtherElements();
		this.pAAdditiveExpression = new AAdditiveExpressionElements();
		this.pOpAdd = new OpAddElements();
		this.pAMultiplicativeExpression = new AMultiplicativeExpressionElements();
		this.pOpMulti = new OpMultiElements();
		this.pAUnaryOperation = new AUnaryOperationElements();
		this.pOpUnary = new OpUnaryElements();
		this.pAPrimaryExpression = new APrimaryExpressionElements();
		this.pAFunctionCall = new AFunctionCallElements();
		this.pAThis = new AThisElements();
		this.pALiteral = new ALiteralElements();
		this.pAIntegerTerm = new AIntegerTermElements();
		this.pAInt = new AIntElements();
		this.pARealTerm = new ARealTermElements();
		this.pAReal = new ARealElements();
		this.pANumericRangeTerm = new ANumericRangeTermElements();
		this.pNumAlt = new NumAltElements();
		this.pASetTerm = new ASetTermElements();
		this.pAListTerm = new AListTermElements();
		this.pAParenthesizedExpression = new AParenthesizedExpressionElements();
		this.pABooleanLiteral = new ABooleanLiteralElements();
		this.pANullLiteral = new ANullLiteralElements();
		this.pStringTerm = new StringTermElements();
		this.pNoQuoteString = new NoQuoteStringElements();
		this.pComponentCategory = new ComponentCategoryElements();
		this.tEXPONENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "EXPONENT");
		this.tINT_EXPONENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "INT_EXPONENT");
		this.tREAL_LIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "REAL_LIT");
		this.tDIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "DIGIT");
		this.tEXTENDED_DIGIT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "EXTENDED_DIGIT");
		this.tBASED_INTEGER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "BASED_INTEGER");
		this.pAadlClassifierReference = new AadlClassifierReferenceElements();
		this.pAADLPROPERTYREFERENCE = new AADLPROPERTYREFERENCEElements();
		this.pURIID = new URIIDElements();
		this.pQualifiedName = new QualifiedNameElements();
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
	//	"description" description+=DescriptionElement+;
	public DescriptionElements getDescriptionAccess() {
		return pDescription;
	}
	
	public ParserRule getDescriptionRule() {
		return getDescriptionAccess().getRule();
	}

	//DescriptionElement:
	//	text=STRING | showValue=ShowValue | thisTarget?="this" | image=ImageReference;
	public DescriptionElementElements getDescriptionElementAccess() {
		return pDescriptionElement;
	}
	
	public ParserRule getDescriptionElementRule() {
		return getDescriptionElementAccess().getRule();
	}

	//Rationale:
	//	"rationale" text=STRING;
	public RationaleElements getRationaleAccess() {
		return pRationale;
	}
	
	public ParserRule getRationaleRule() {
		return getRationaleAccess().getRule();
	}

	//Uncertainty:
	//	"uncertainty" "[" ("volatility" volatility=INT & "impact" impact=INT) "]";
	public UncertaintyElements getUncertaintyAccess() {
		return pUncertainty;
	}
	
	public ParserRule getUncertaintyRule() {
		return getUncertaintyAccess().getRule();
	}

	//// This is similar to diagnostics
	//ResultIssue:
	//	issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception"
	//	exceptionType=STRING)? ("diagnosticId" diagnosticId=STRING)? ("[" issues+=ResultIssue* "]")?;
	public ResultIssueElements getResultIssueAccess() {
		return pResultIssue;
	}
	
	public ParserRule getResultIssueRule() {
		return getResultIssueAccess().getRule();
	}

	//enum ResultIssueType:
	//	TBD="tbd" | ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail";
	public ResultIssueTypeElements getResultIssueTypeAccess() {
		return unknownRuleResultIssueType;
	}
	
	public EnumRule getResultIssueTypeRule() {
		return getResultIssueTypeAccess().getRule();
	}

	//ValDeclaration returns AVariableDeclaration:
	//	{ValDeclaration} "val" (=> (type=ID name=ID) | name=ID) "=" right=AExpression;
	public ValDeclarationElements getValDeclarationAccess() {
		return pValDeclaration;
	}
	
	public ParserRule getValDeclarationRule() {
		return getValDeclarationAccess().getRule();
	}

	//ComputeDeclaration returns AVariableDeclaration:
	//	{ComputeDeclaration} "compute" (=> (type=ID name=ID) | name=ID);
	public ComputeDeclarationElements getComputeDeclarationAccess() {
		return pComputeDeclaration;
	}
	
	public ParserRule getComputeDeclarationRule() {
		return getComputeDeclarationAccess().getRule();
	}

	//APropertyReference returns AExpression:
	//	{APropertyReference} "#" property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE];
	public APropertyReferenceElements getAPropertyReferenceAccess() {
		return pAPropertyReference;
	}
	
	public ParserRule getAPropertyReferenceRule() {
		return getAPropertyReferenceAccess().getRule();
	}

	//AModelReference returns AExpression:
	//	{AModelReference} "@" modelElement=[aadl2::NamedElement|QualifiedName];
	public AModelReferenceElements getAModelReferenceAccess() {
		return pAModelReference;
	}
	
	public ParserRule getAModelReferenceRule() {
		return getAModelReferenceAccess().getRule();
	}

	//AVariableReference returns AExpression:
	//	{AVariableReference} variable=[AVariableDeclaration];
	public AVariableReferenceElements getAVariableReferenceAccess() {
		return pAVariableReference;
	}
	
	public ParserRule getAVariableReferenceRule() {
		return getAVariableReferenceAccess().getRule();
	}

	//ShowValue:
	//	ref=[AVariableDeclaration] ("%" unit=[aadl2::UnitLiteral])?;
	public ShowValueElements getShowValueAccess() {
		return pShowValue;
	}
	
	public ParserRule getShowValueRule() {
		return getShowValueAccess().getRule();
	}

	//ImageReference:
	//	"img" imgfile=IMGREF;
	public ImageReferenceElements getImageReferenceAccess() {
		return pImageReference;
	}
	
	public ParserRule getImageReferenceRule() {
		return getImageReferenceAccess().getRule();
	}

	//IMGREF:
	//	(ID "/")* ID "." ID;
	public IMGREFElements getIMGREFAccess() {
		return pIMGREF;
	}
	
	public ParserRule getIMGREFRule() {
		return getIMGREFAccess().getRule();
	}

	//// Expressions
	//AExpression returns aadl2::PropertyExpression:
	//	AOrExpression;
	public AExpressionElements getAExpressionAccess() {
		return pAExpression;
	}
	
	public ParserRule getAExpressionRule() {
		return getAExpressionAccess().getRule();
	}

	//AOrExpression returns aadl2::PropertyExpression:
	//	AAndExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOr) rightOperand=AAndExpression)*;
	public AOrExpressionElements getAOrExpressionAccess() {
		return pAOrExpression;
	}
	
	public ParserRule getAOrExpressionRule() {
		return getAOrExpressionAccess().getRule();
	}

	//OpOr:
	//	"||";
	public OpOrElements getOpOrAccess() {
		return pOpOr;
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}

	//AAndExpression returns aadl2::PropertyExpression:
	//	AEqualityExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAnd) rightOperand=AEqualityExpression)*;
	public AAndExpressionElements getAAndExpressionAccess() {
		return pAAndExpression;
	}
	
	public ParserRule getAAndExpressionRule() {
		return getAAndExpressionAccess().getRule();
	}

	//OpAnd:
	//	"&&";
	public OpAndElements getOpAndAccess() {
		return pOpAnd;
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}

	//AEqualityExpression returns aadl2::PropertyExpression:
	//	ARelationalExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpEquality)
	//	rightOperand=ARelationalExpression)*;
	public AEqualityExpressionElements getAEqualityExpressionAccess() {
		return pAEqualityExpression;
	}
	
	public ParserRule getAEqualityExpressionRule() {
		return getAEqualityExpressionAccess().getRule();
	}

	//OpEquality:
	//	"==" | "!=";
	public OpEqualityElements getOpEqualityAccess() {
		return pOpEquality;
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}

	//ARelationalExpression returns aadl2::PropertyExpression:
	//	AOtherOperatorExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpCompare)
	//	rightOperand=AOtherOperatorExpression)*;
	public ARelationalExpressionElements getARelationalExpressionAccess() {
		return pARelationalExpression;
	}
	
	public ParserRule getARelationalExpressionRule() {
		return getARelationalExpressionAccess().getRule();
	}

	//OpCompare:
	//	">=" | "<" "=" | ">" | "<";
	public OpCompareElements getOpCompareAccess() {
		return pOpCompare;
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}

	//AOtherOperatorExpression returns aadl2::PropertyExpression:
	//	AAdditiveExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOther) rightOperand=AAdditiveExpression)*;
	public AOtherOperatorExpressionElements getAOtherOperatorExpressionAccess() {
		return pAOtherOperatorExpression;
	}
	
	public ParserRule getAOtherOperatorExpressionRule() {
		return getAOtherOperatorExpressionAccess().getRule();
	}

	//OpOther:
	//	"->" | "..<" | ">" ".." | ".." | "=>" | ">" (=> (">" ">") | ">") | "<" (=> ("<" "<") | "<" | "=>") | "<>" | "?:";
	public OpOtherElements getOpOtherAccess() {
		return pOpOther;
	}
	
	public ParserRule getOpOtherRule() {
		return getOpOtherAccess().getRule();
	}

	//AAdditiveExpression returns aadl2::PropertyExpression:
	//	AMultiplicativeExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAdd)
	//	rightOperand=AMultiplicativeExpression)*;
	public AAdditiveExpressionElements getAAdditiveExpressionAccess() {
		return pAAdditiveExpression;
	}
	
	public ParserRule getAAdditiveExpressionRule() {
		return getAAdditiveExpressionAccess().getRule();
	}

	//OpAdd:
	//	"+" | "-";
	public OpAddElements getOpAddAccess() {
		return pOpAdd;
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}

	//AMultiplicativeExpression returns aadl2::PropertyExpression:
	//	AUnaryOperation (=> ({ABinaryOperation.leftOperand=current} feature=OpMulti) rightOperand=AUnaryOperation)*;
	public AMultiplicativeExpressionElements getAMultiplicativeExpressionAccess() {
		return pAMultiplicativeExpression;
	}
	
	public ParserRule getAMultiplicativeExpressionRule() {
		return getAMultiplicativeExpressionAccess().getRule();
	}

	//OpMulti:
	//	"*" | "**" | "/" | "%";
	public OpMultiElements getOpMultiAccess() {
		return pOpMulti;
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}

	//AUnaryOperation returns aadl2::PropertyExpression:
	//	{AUnaryOperation} feature=OpUnary operand=AUnaryOperation | APrimaryExpression;
	public AUnaryOperationElements getAUnaryOperationAccess() {
		return pAUnaryOperation;
	}
	
	public ParserRule getAUnaryOperationRule() {
		return getAUnaryOperationAccess().getRule();
	}

	//OpUnary:
	//	"!" | "-" | "+";
	public OpUnaryElements getOpUnaryAccess() {
		return pOpUnary;
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}

	//APrimaryExpression returns aadl2::PropertyExpression:
	//	ALiteral | AVariableReference | APropertyReference | AFunctionCall | AParenthesizedExpression;
	public APrimaryExpressionElements getAPrimaryExpressionAccess() {
		return pAPrimaryExpression;
	}
	
	public ParserRule getAPrimaryExpressionRule() {
		return getAPrimaryExpressionAccess().getRule();
	}

	//AFunctionCall returns aadl2::PropertyExpression:
	//	{AFunctionCall} function=ID "(" functionCallArguments+=AExpression ("," functionCallArguments+=AExpression)* ")";
	public AFunctionCallElements getAFunctionCallAccess() {
		return pAFunctionCall;
	}
	
	public ParserRule getAFunctionCallRule() {
		return getAFunctionCallAccess().getRule();
	}

	//AThis returns aadl2::PropertyExpression:
	//	{AThis} "this";
	public AThisElements getAThisAccess() {
		return pAThis;
	}
	
	public ParserRule getAThisRule() {
		return getAThisAccess().getRule();
	}

	//ALiteral returns aadl2::PropertyExpression:
	//	ASetTerm | AListTerm | ABooleanLiteral | ARealTerm | AIntegerTerm | ANullLiteral | StringTerm | AThis;
	public ALiteralElements getALiteralAccess() {
		return pALiteral;
	}
	
	public ParserRule getALiteralRule() {
		return getALiteralAccess().getRule();
	}

	//AIntegerTerm returns aadl2::IntegerLiteral:
	//	value=AInt unit=[aadl2::UnitLiteral]?;
	public AIntegerTermElements getAIntegerTermAccess() {
		return pAIntegerTerm;
	}
	
	public ParserRule getAIntegerTermRule() {
		return getAIntegerTermAccess().getRule();
	}

	//AInt returns aadl2::Integer:
	//	INT;
	public AIntElements getAIntAccess() {
		return pAInt;
	}
	
	public ParserRule getAIntRule() {
		return getAIntAccess().getRule();
	}

	//ARealTerm returns aadl2::RealLiteral:
	//	value=AReal unit=[aadl2::UnitLiteral]?;
	public ARealTermElements getARealTermAccess() {
		return pARealTerm;
	}
	
	public ParserRule getARealTermRule() {
		return getARealTermAccess().getRule();
	}

	//AReal returns aadl2::Real:
	//	REAL_LIT;
	public ARealElements getARealAccess() {
		return pAReal;
	}
	
	public ParserRule getARealRule() {
		return getARealAccess().getRule();
	}

	//ANumericRangeTerm returns aadl2::RangeValue:
	//	minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
	//	NumAlt ".." maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt ("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt)?;
	public ANumericRangeTermElements getANumericRangeTermAccess() {
		return pANumericRangeTerm;
	}
	
	public ParserRule getANumericRangeTermRule() {
		return getANumericRangeTermAccess().getRule();
	}

	//NumAlt returns aadl2::PropertyExpression:
	//	ARealTerm | AIntegerTerm;
	public NumAltElements getNumAltAccess() {
		return pNumAlt;
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}

	//ASetTerm returns aadl2::PropertyExpression: //	{ASetLiteral} '#' '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
	//	{ASetLiteral} "{" (elements+=AExpression ("," elements+=AExpression)*)? "}";
	public ASetTermElements getASetTermAccess() {
		return pASetTerm;
	}
	
	public ParserRule getASetTermRule() {
		return getASetTermAccess().getRule();
	}

	//AListTerm returns aadl2::PropertyExpression:
	//	{AListTerm} "#" "[" (elements+=AExpression ("," elements+=AExpression)*)? "]";
	public AListTermElements getAListTermAccess() {
		return pAListTerm;
	}
	
	public ParserRule getAListTermRule() {
		return getAListTermAccess().getRule();
	}

	//AParenthesizedExpression returns aadl2::PropertyExpression:
	//	"(" AExpression ")";
	public AParenthesizedExpressionElements getAParenthesizedExpressionAccess() {
		return pAParenthesizedExpression;
	}
	
	public ParserRule getAParenthesizedExpressionRule() {
		return getAParenthesizedExpressionAccess().getRule();
	}

	//ABooleanLiteral returns aadl2::PropertyExpression:
	//	{aadl2::BooleanLiteral} (value?="true" | "false");
	public ABooleanLiteralElements getABooleanLiteralAccess() {
		return pABooleanLiteral;
	}
	
	public ParserRule getABooleanLiteralRule() {
		return getABooleanLiteralAccess().getRule();
	}

	//ANullLiteral returns aadl2::PropertyExpression:
	//	{ANullLiteral} "null";
	public ANullLiteralElements getANullLiteralAccess() {
		return pANullLiteral;
	}
	
	public ParserRule getANullLiteralRule() {
		return getANullLiteralAccess().getRule();
	}

	//StringTerm returns aadl2::StringLiteral:
	//	value=NoQuoteString;
	public StringTermElements getStringTermAccess() {
		return pStringTerm;
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}

	//NoQuoteString: // remove quotes from string in ValueConverter
	//	STRING;
	public NoQuoteStringElements getNoQuoteStringAccess() {
		return pNoQuoteString;
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}

	//ComponentCategory returns aadl2::ComponentCategory:
	//	"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
	//	"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor";
	public ComponentCategoryElements getComponentCategoryAccess() {
		return pComponentCategory;
	}
	
	public ParserRule getComponentCategoryRule() {
		return getComponentCategoryAccess().getRule();
	}

	//terminal fragment EXPONENT:
	//	("e" | "E") ("+" | "-")? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return tEXPONENT;
	} 

	//terminal fragment INT_EXPONENT:
	//	("e" | "E") "+"? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return tINT_EXPONENT;
	} 

	//terminal REAL_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("." DIGIT+ ("_" DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return tREAL_LIT;
	} 

	////terminal INTEGER_LIT : 
	////		(DIGIT)+('_' (DIGIT)+)*
	////		(( '#' BASED_INTEGER  '#' ( INT_EXPONENT )? )
	////			| (INT_EXPONENT)?
	////		)
	////  ;
	//terminal fragment DIGIT:
	//	"0".."9";
	public TerminalRule getDIGITRule() {
		return tDIGIT;
	} 

	//terminal fragment EXTENDED_DIGIT:
	//	"0".."9" | "a".."f" | "A".."F";
	public TerminalRule getEXTENDED_DIGITRule() {
		return tEXTENDED_DIGIT;
	} 

	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ("_"? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return tBASED_INTEGER;
	} 

	//// Qualified classifier reference
	//AadlClassifierReference:
	//	ID ("::" ID)+ ("." ID)?;
	public AadlClassifierReferenceElements getAadlClassifierReferenceAccess() {
		return pAadlClassifierReference;
	}
	
	public ParserRule getAadlClassifierReferenceRule() {
		return getAadlClassifierReferenceAccess().getRule();
	}

	//AADLPROPERTYREFERENCE:
	//	ID ("::" ID)?;
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
	//	ID ("." ID)*;
	public QualifiedNameElements getQualifiedNameAccess() {
		return pQualifiedName;
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
