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
package org.osate.results.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class ResultsGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ResultReportsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultReports");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cResultReportParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cResultReportCollectionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIssueReportParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//ResultReports:
		//	ResultReport | ResultReportCollection | IssueReport;
		@Override public ParserRule getRule() { return rule; }

		//ResultReport | ResultReportCollection | IssueReport
		public Alternatives getAlternatives() { return cAlternatives; }

		//ResultReport
		public RuleCall getResultReportParserRuleCall_0() { return cResultReportParserRuleCall_0; }

		//ResultReportCollection
		public RuleCall getResultReportCollectionParserRuleCall_1() { return cResultReportCollectionParserRuleCall_1; }

		//IssueReport
		public RuleCall getIssueReportParserRuleCall_2() { return cIssueReportParserRuleCall_2; }
	}

	public class ResultReportCollectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultReportCollection");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReportsKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cTargetKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cTargetAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cTargetEObjectCrossReference_5_0 = (CrossReference)cTargetAssignment_5.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_5_0_1 = (RuleCall)cTargetEObjectCrossReference_5_0.eContents().get(1);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cDescriptionKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cDecriptionAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cDecriptionSTRINGTerminalRuleCall_6_1_0 = (RuleCall)cDecriptionAssignment_6_1.eContents().get(0);
		private final Assignment cContentAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cContentResultReportParserRuleCall_7_0 = (RuleCall)cContentAssignment_7.eContents().get(0);
		private final Assignment cIssuesAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cIssuesResultIssueParserRuleCall_8_0 = (RuleCall)cIssuesAssignment_8.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//// Collection of reports for an instance model (root), e.g., for collection of end to end flows
		//ResultReportCollection:
		//	"reports" name=ID (":" title=STRING)? "[" "target" target= // system instance or other EObject
		//	[ecore::EObject|URIID] ("description" decription=STRING)? content+=ResultReport* issues+=ResultIssue? "]";
		@Override public ParserRule getRule() { return rule; }

		//"reports" name=ID (":" title=STRING)? "[" "target" target= // system instance or other EObject
		//[ecore::EObject|URIID] ("description" decription=STRING)? content+=ResultReport* issues+=ResultIssue? "]"
		public Group getGroup() { return cGroup; }

		//"reports"
		public Keyword getReportsKeyword_0() { return cReportsKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//"target"
		public Keyword getTargetKeyword_4() { return cTargetKeyword_4; }

		//target= // system instance or other EObject
		//[ecore::EObject|URIID]
		public Assignment getTargetAssignment_5() { return cTargetAssignment_5; }

		//// system instance or other EObject
		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_5_0() { return cTargetEObjectCrossReference_5_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_5_0_1() { return cTargetEObjectURIIDParserRuleCall_5_0_1; }

		//("description" decription=STRING)?
		public Group getGroup_6() { return cGroup_6; }

		//"description"
		public Keyword getDescriptionKeyword_6_0() { return cDescriptionKeyword_6_0; }

		//decription=STRING
		public Assignment getDecriptionAssignment_6_1() { return cDecriptionAssignment_6_1; }

		//STRING
		public RuleCall getDecriptionSTRINGTerminalRuleCall_6_1_0() { return cDecriptionSTRINGTerminalRuleCall_6_1_0; }

		//content+=ResultReport*
		public Assignment getContentAssignment_7() { return cContentAssignment_7; }

		//ResultReport
		public RuleCall getContentResultReportParserRuleCall_7_0() { return cContentResultReportParserRuleCall_7_0; }

		//issues+=ResultIssue?
		public Assignment getIssuesAssignment_8() { return cIssuesAssignment_8; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_0() { return cIssuesResultIssueParserRuleCall_8_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_9() { return cRightSquareBracketKeyword_9; }
	}

	public class ResultReportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultReport");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cResultReportAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cReportKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Assignment cTargetAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cTargetEObjectCrossReference_4_0 = (CrossReference)cTargetAssignment_4.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_4_0_1 = (RuleCall)cTargetEObjectCrossReference_4_0.eContents().get(1);
		private final Assignment cIssueTypeAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cIssueTypeResultIssueTypeEnumRuleCall_5_0 = (RuleCall)cIssueTypeAssignment_5.eContents().get(0);
		private final Assignment cMessageAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cMessageSTRINGTerminalRuleCall_6_0 = (RuleCall)cMessageAssignment_6.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cExceptionKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cExceptionTypeAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cExceptionTypeSTRINGTerminalRuleCall_7_1_0 = (RuleCall)cExceptionTypeAssignment_7_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cDescriptionKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cDecriptionAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final RuleCall cDecriptionSTRINGTerminalRuleCall_9_1_0 = (RuleCall)cDecriptionAssignment_9_1.eContents().get(0);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cHeadingKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Assignment cHeadingAssignment_10_1 = (Assignment)cGroup_10.eContents().get(1);
		private final RuleCall cHeadingSTRINGTerminalRuleCall_10_1_0 = (RuleCall)cHeadingAssignment_10_1.eContents().get(0);
		private final Assignment cContentAssignment_10_2 = (Assignment)cGroup_10.eContents().get(2);
		private final RuleCall cContentResultContributorParserRuleCall_10_2_0 = (RuleCall)cContentAssignment_10_2.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cResultsKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cResultDataAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cResultDataResultDataParserRuleCall_11_1_0 = (RuleCall)cResultDataAssignment_11_1.eContents().get(0);
		private final Assignment cIssuesAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final RuleCall cIssuesResultIssueParserRuleCall_12_0 = (RuleCall)cIssuesAssignment_12.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_13 = (Keyword)cGroup.eContents().get(13);
		
		//// one report of an analysis for one item in the instance model.
		//// it may be a report per SOM or per end to end flow
		//// result represents the result data that can be queried
		//ResultReport returns ResultIssue:
		//	{ResultReport} "report" name=ID (":" title=STRING)? target= // system instance or other EObject
		//	[ecore::EObject|URIID] issueType=ResultIssueType message=STRING ("exception" exceptionType=STRING)? "[" ("description"
		//	decription=STRING)? ("heading" heading=STRING content+=ResultContributor*)? ("results" resultData+=ResultData+)?
		//	issues+=ResultIssue? "]";
		@Override public ParserRule getRule() { return rule; }

		//{ResultReport} "report" name=ID (":" title=STRING)? target= // system instance or other EObject
		//[ecore::EObject|URIID] issueType=ResultIssueType message=STRING ("exception" exceptionType=STRING)? "[" ("description"
		//decription=STRING)? ("heading" heading=STRING content+=ResultContributor*)? ("results" resultData+=ResultData+)?
		//issues+=ResultIssue? "]"
		public Group getGroup() { return cGroup; }

		//{ResultReport}
		public Action getResultReportAction_0() { return cResultReportAction_0; }

		//"report"
		public Keyword getReportKeyword_1() { return cReportKeyword_1; }

		//name=ID
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_2_0() { return cNameIDTerminalRuleCall_2_0; }

		//(":" title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//":"
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//target= // system instance or other EObject
		//[ecore::EObject|URIID]
		public Assignment getTargetAssignment_4() { return cTargetAssignment_4; }

		//// system instance or other EObject
		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_4_0() { return cTargetEObjectCrossReference_4_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_4_0_1() { return cTargetEObjectURIIDParserRuleCall_4_0_1; }

		//issueType=ResultIssueType
		public Assignment getIssueTypeAssignment_5() { return cIssueTypeAssignment_5; }

		//ResultIssueType
		public RuleCall getIssueTypeResultIssueTypeEnumRuleCall_5_0() { return cIssueTypeResultIssueTypeEnumRuleCall_5_0; }

		//message=STRING
		public Assignment getMessageAssignment_6() { return cMessageAssignment_6; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_6_0() { return cMessageSTRINGTerminalRuleCall_6_0; }

		//("exception" exceptionType=STRING)?
		public Group getGroup_7() { return cGroup_7; }

		//"exception"
		public Keyword getExceptionKeyword_7_0() { return cExceptionKeyword_7_0; }

		//exceptionType=STRING
		public Assignment getExceptionTypeAssignment_7_1() { return cExceptionTypeAssignment_7_1; }

		//STRING
		public RuleCall getExceptionTypeSTRINGTerminalRuleCall_7_1_0() { return cExceptionTypeSTRINGTerminalRuleCall_7_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_8() { return cLeftSquareBracketKeyword_8; }

		//("description" decription=STRING)?
		public Group getGroup_9() { return cGroup_9; }

		//"description"
		public Keyword getDescriptionKeyword_9_0() { return cDescriptionKeyword_9_0; }

		//decription=STRING
		public Assignment getDecriptionAssignment_9_1() { return cDecriptionAssignment_9_1; }

		//STRING
		public RuleCall getDecriptionSTRINGTerminalRuleCall_9_1_0() { return cDecriptionSTRINGTerminalRuleCall_9_1_0; }

		//("heading" heading=STRING content+=ResultContributor*)?
		public Group getGroup_10() { return cGroup_10; }

		//"heading"
		public Keyword getHeadingKeyword_10_0() { return cHeadingKeyword_10_0; }

		//heading=STRING
		public Assignment getHeadingAssignment_10_1() { return cHeadingAssignment_10_1; }

		//STRING
		public RuleCall getHeadingSTRINGTerminalRuleCall_10_1_0() { return cHeadingSTRINGTerminalRuleCall_10_1_0; }

		//content+=ResultContributor*
		public Assignment getContentAssignment_10_2() { return cContentAssignment_10_2; }

		//ResultContributor
		public RuleCall getContentResultContributorParserRuleCall_10_2_0() { return cContentResultContributorParserRuleCall_10_2_0; }

		//("results" resultData+=ResultData+)?
		public Group getGroup_11() { return cGroup_11; }

		//"results"
		public Keyword getResultsKeyword_11_0() { return cResultsKeyword_11_0; }

		//resultData+=ResultData+
		public Assignment getResultDataAssignment_11_1() { return cResultDataAssignment_11_1; }

		//ResultData
		public RuleCall getResultDataResultDataParserRuleCall_11_1_0() { return cResultDataResultDataParserRuleCall_11_1_0; }

		//issues+=ResultIssue?
		public Assignment getIssuesAssignment_12() { return cIssuesAssignment_12; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_12_0() { return cIssuesResultIssueParserRuleCall_12_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_13() { return cRightSquareBracketKeyword_13; }
	}

	public class ResultContributorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultContributor");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cResultContributorAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cContributorKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTargetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cTargetEObjectCrossReference_2_0 = (CrossReference)cTargetAssignment_2.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_2_0_1 = (RuleCall)cTargetEObjectCrossReference_2_0.eContents().get(1);
		private final Assignment cIssueTypeAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cIssueTypeResultIssueTypeEnumRuleCall_3_0 = (RuleCall)cIssueTypeAssignment_3.eContents().get(0);
		private final Assignment cMessageAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cMessageSTRINGTerminalRuleCall_4_0 = (RuleCall)cMessageAssignment_4.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cExceptionKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cExceptionTypeAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cExceptionTypeSTRINGTerminalRuleCall_5_1_0 = (RuleCall)cExceptionTypeAssignment_5_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Keyword cDataKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Assignment cCellAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cCellSTRINGTerminalRuleCall_8_0 = (RuleCall)cCellAssignment_8.eContents().get(0);
		private final Assignment cIssuesAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cIssuesResultIssueParserRuleCall_9_0 = (RuleCall)cIssuesAssignment_9.eContents().get(0);
		private final Assignment cSubcontributorAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cSubcontributorResultContributorParserRuleCall_10_0 = (RuleCall)cSubcontributorAssignment_10.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_11 = (Keyword)cGroup.eContents().get(11);
		
		//// one row to represent a contributor to the result calculation.
		//// this structure can be nested
		//// each contributor can have issues reported
		//// user may define a subclass of this to add analysis specific data representations
		//ResultContributor returns ResultIssue:
		//	{ResultContributor} "contributor" target= // instance model element or declarative model element
		//	[ecore::EObject|URIID] issueType=ResultIssueType message=STRING ("exception" exceptionType=STRING)? "[" "data"
		//	cell+=STRING+ issues+=ResultIssue* subcontributor+=ResultContributor* "]";
		@Override public ParserRule getRule() { return rule; }

		//{ResultContributor} "contributor" target= // instance model element or declarative model element
		//[ecore::EObject|URIID] issueType=ResultIssueType message=STRING ("exception" exceptionType=STRING)? "[" "data"
		//cell+=STRING+ issues+=ResultIssue* subcontributor+=ResultContributor* "]"
		public Group getGroup() { return cGroup; }

		//{ResultContributor}
		public Action getResultContributorAction_0() { return cResultContributorAction_0; }

		//"contributor"
		public Keyword getContributorKeyword_1() { return cContributorKeyword_1; }

		//target= // instance model element or declarative model element
		//[ecore::EObject|URIID]
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }

		//// instance model element or declarative model element
		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_2_0() { return cTargetEObjectCrossReference_2_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_2_0_1() { return cTargetEObjectURIIDParserRuleCall_2_0_1; }

		//issueType=ResultIssueType
		public Assignment getIssueTypeAssignment_3() { return cIssueTypeAssignment_3; }

		//ResultIssueType
		public RuleCall getIssueTypeResultIssueTypeEnumRuleCall_3_0() { return cIssueTypeResultIssueTypeEnumRuleCall_3_0; }

		//message=STRING
		public Assignment getMessageAssignment_4() { return cMessageAssignment_4; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_4_0() { return cMessageSTRINGTerminalRuleCall_4_0; }

		//("exception" exceptionType=STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//"exception"
		public Keyword getExceptionKeyword_5_0() { return cExceptionKeyword_5_0; }

		//exceptionType=STRING
		public Assignment getExceptionTypeAssignment_5_1() { return cExceptionTypeAssignment_5_1; }

		//STRING
		public RuleCall getExceptionTypeSTRINGTerminalRuleCall_5_1_0() { return cExceptionTypeSTRINGTerminalRuleCall_5_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_6() { return cLeftSquareBracketKeyword_6; }

		//"data"
		public Keyword getDataKeyword_7() { return cDataKeyword_7; }

		//cell+=STRING+
		public Assignment getCellAssignment_8() { return cCellAssignment_8; }

		//STRING
		public RuleCall getCellSTRINGTerminalRuleCall_8_0() { return cCellSTRINGTerminalRuleCall_8_0; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_9() { return cIssuesAssignment_9; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_9_0() { return cIssuesResultIssueParserRuleCall_9_0; }

		//subcontributor+=ResultContributor*
		public Assignment getSubcontributorAssignment_10() { return cSubcontributorAssignment_10; }

		//ResultContributor
		public RuleCall getSubcontributorResultContributorParserRuleCall_10_0() { return cSubcontributorResultContributorParserRuleCall_10_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_11() { return cRightSquareBracketKeyword_11; }
	}

	public class IssueReportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IssueReport");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cIssueReportAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cIssuesKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cIssueTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cIssueTypeResultIssueTypeEnumRuleCall_2_0 = (RuleCall)cIssueTypeAssignment_2.eContents().get(0);
		private final Assignment cMessageAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMessageSTRINGTerminalRuleCall_3_0 = (RuleCall)cMessageAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cTargetKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cTargetAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cTargetEObjectCrossReference_4_1_0 = (CrossReference)cTargetAssignment_4_1.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_4_1_0_1 = (RuleCall)cTargetEObjectCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cExceptionKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cExceptionTypeAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cExceptionTypeSTRINGTerminalRuleCall_5_1_0 = (RuleCall)cExceptionTypeAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cLeftSquareBracketKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cIssuesAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cIssuesResultIssueParserRuleCall_6_1_0 = (RuleCall)cIssuesAssignment_6_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		
		//IssueReport returns ResultIssue:
		//	{IssueReport} "issues" issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])?
		//	("exception" exceptionType=STRING)? ("[" issues+=ResultIssue* "]")?;
		@Override public ParserRule getRule() { return rule; }

		//{IssueReport} "issues" issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception"
		//exceptionType=STRING)? ("[" issues+=ResultIssue* "]")?
		public Group getGroup() { return cGroup; }

		//{IssueReport}
		public Action getIssueReportAction_0() { return cIssueReportAction_0; }

		//"issues"
		public Keyword getIssuesKeyword_1() { return cIssuesKeyword_1; }

		//issueType=ResultIssueType
		public Assignment getIssueTypeAssignment_2() { return cIssueTypeAssignment_2; }

		//ResultIssueType
		public RuleCall getIssueTypeResultIssueTypeEnumRuleCall_2_0() { return cIssueTypeResultIssueTypeEnumRuleCall_2_0; }

		//message=STRING
		public Assignment getMessageAssignment_3() { return cMessageAssignment_3; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_3_0() { return cMessageSTRINGTerminalRuleCall_3_0; }

		//("target" target=[ecore::EObject|URIID])?
		public Group getGroup_4() { return cGroup_4; }

		//"target"
		public Keyword getTargetKeyword_4_0() { return cTargetKeyword_4_0; }

		//target=[ecore::EObject|URIID]
		public Assignment getTargetAssignment_4_1() { return cTargetAssignment_4_1; }

		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_4_1_0() { return cTargetEObjectCrossReference_4_1_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_4_1_0_1() { return cTargetEObjectURIIDParserRuleCall_4_1_0_1; }

		//("exception" exceptionType=STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//"exception"
		public Keyword getExceptionKeyword_5_0() { return cExceptionKeyword_5_0; }

		//exceptionType=STRING
		public Assignment getExceptionTypeAssignment_5_1() { return cExceptionTypeAssignment_5_1; }

		//STRING
		public RuleCall getExceptionTypeSTRINGTerminalRuleCall_5_1_0() { return cExceptionTypeSTRINGTerminalRuleCall_5_1_0; }

		//("[" issues+=ResultIssue* "]")?
		public Group getGroup_6() { return cGroup_6; }

		//"["
		public Keyword getLeftSquareBracketKeyword_6_0() { return cLeftSquareBracketKeyword_6_0; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_6_1() { return cIssuesAssignment_6_1; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_6_1_0() { return cIssuesResultIssueParserRuleCall_6_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6_2() { return cRightSquareBracketKeyword_6_2; }
	}

	public class ResultIssueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultIssue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIssueKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIssueTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cIssueTypeResultIssueTypeEnumRuleCall_1_0 = (RuleCall)cIssueTypeAssignment_1.eContents().get(0);
		private final Assignment cMessageAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMessageSTRINGTerminalRuleCall_2_0 = (RuleCall)cMessageAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cTargetKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTargetAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cTargetEObjectCrossReference_3_1_0 = (CrossReference)cTargetAssignment_3_1.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_3_1_0_1 = (RuleCall)cTargetEObjectCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cExceptionKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cExceptionTypeAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cExceptionTypeSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cExceptionTypeAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLeftSquareBracketKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cIssuesAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cIssuesResultIssueParserRuleCall_5_1_0 = (RuleCall)cIssuesAssignment_5_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		
		//// This is similar to diagnostics
		//ResultIssue:
		//	"issue" issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception"
		//	exceptionType=STRING)? ("[" issues+=ResultIssue* "]")?;
		@Override public ParserRule getRule() { return rule; }

		//"issue" issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception"
		//exceptionType=STRING)? ("[" issues+=ResultIssue* "]")?
		public Group getGroup() { return cGroup; }

		//"issue"
		public Keyword getIssueKeyword_0() { return cIssueKeyword_0; }

		//issueType=ResultIssueType
		public Assignment getIssueTypeAssignment_1() { return cIssueTypeAssignment_1; }

		//ResultIssueType
		public RuleCall getIssueTypeResultIssueTypeEnumRuleCall_1_0() { return cIssueTypeResultIssueTypeEnumRuleCall_1_0; }

		//message=STRING
		public Assignment getMessageAssignment_2() { return cMessageAssignment_2; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_2_0() { return cMessageSTRINGTerminalRuleCall_2_0; }

		//("target" target=[ecore::EObject|URIID])?
		public Group getGroup_3() { return cGroup_3; }

		//"target"
		public Keyword getTargetKeyword_3_0() { return cTargetKeyword_3_0; }

		//target=[ecore::EObject|URIID]
		public Assignment getTargetAssignment_3_1() { return cTargetAssignment_3_1; }

		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_3_1_0() { return cTargetEObjectCrossReference_3_1_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_3_1_0_1() { return cTargetEObjectURIIDParserRuleCall_3_1_0_1; }

		//("exception" exceptionType=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//"exception"
		public Keyword getExceptionKeyword_4_0() { return cExceptionKeyword_4_0; }

		//exceptionType=STRING
		public Assignment getExceptionTypeAssignment_4_1() { return cExceptionTypeAssignment_4_1; }

		//STRING
		public RuleCall getExceptionTypeSTRINGTerminalRuleCall_4_1_0() { return cExceptionTypeSTRINGTerminalRuleCall_4_1_0; }

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

	public class ResultDataElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultData");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueSTRINGTerminalRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//// default implementation of result data
		//// a set of name value pairs with the values expressed as strings
		//// user can create a subclass of this to provide a specialized representation
		//ResultData:
		//	name=ID "=" value=STRING;
		@Override public ParserRule getRule() { return rule; }

		//name=ID "=" value=STRING
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//value=STRING
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_2_0() { return cValueSTRINGTerminalRuleCall_2_0; }
	}

	public class URIIDElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "URIID");
		private final RuleCall cSTRINGTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		////terminal URIID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'#'|'@'|'/'|':')*;
		//URIID:
		//	STRING;
		@Override public ParserRule getRule() { return rule; }

		////terminal URIID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'#'|'@'|'/'|':')*;
		//STRING
		public RuleCall getSTRINGTerminalRuleCall() { return cSTRINGTerminalRuleCall; }
	}
	
	
	public class ResultIssueTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ResultIssueType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cERROREnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cERRORErrorKeyword_0_0 = (Keyword)cERROREnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cWARNINGEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cWARNINGWarningKeyword_1_0 = (Keyword)cWARNINGEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cINFOEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cINFOInfoKeyword_2_0 = (Keyword)cINFOEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cSUCCESSEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cSUCCESSSuccessKeyword_3_0 = (Keyword)cSUCCESSEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cFAILEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cFAILFailKeyword_4_0 = (Keyword)cFAILEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cUNKNOWNEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cUNKNOWNUnknownKeyword_5_0 = (Keyword)cUNKNOWNEnumLiteralDeclaration_5.eContents().get(0);
		
		//enum ResultIssueType:
		//	ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail" | UNKNOWN="unknown";
		public EnumRule getRule() { return rule; }

		//ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail" | UNKNOWN="unknown"
		public Alternatives getAlternatives() { return cAlternatives; }

		//ERROR="error"
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_0() { return cERROREnumLiteralDeclaration_0; }

		//"error"
		public Keyword getERRORErrorKeyword_0_0() { return cERRORErrorKeyword_0_0; }

		//WARNING="warning"
		public EnumLiteralDeclaration getWARNINGEnumLiteralDeclaration_1() { return cWARNINGEnumLiteralDeclaration_1; }

		//"warning"
		public Keyword getWARNINGWarningKeyword_1_0() { return cWARNINGWarningKeyword_1_0; }

		//INFO="info"
		public EnumLiteralDeclaration getINFOEnumLiteralDeclaration_2() { return cINFOEnumLiteralDeclaration_2; }

		//"info"
		public Keyword getINFOInfoKeyword_2_0() { return cINFOInfoKeyword_2_0; }

		//SUCCESS="success"
		public EnumLiteralDeclaration getSUCCESSEnumLiteralDeclaration_3() { return cSUCCESSEnumLiteralDeclaration_3; }

		//"success"
		public Keyword getSUCCESSSuccessKeyword_3_0() { return cSUCCESSSuccessKeyword_3_0; }

		//FAIL="fail"
		public EnumLiteralDeclaration getFAILEnumLiteralDeclaration_4() { return cFAILEnumLiteralDeclaration_4; }

		//"fail"
		public Keyword getFAILFailKeyword_4_0() { return cFAILFailKeyword_4_0; }

		//UNKNOWN="unknown"
		public EnumLiteralDeclaration getUNKNOWNEnumLiteralDeclaration_5() { return cUNKNOWNEnumLiteralDeclaration_5; }

		//"unknown"
		public Keyword getUNKNOWNUnknownKeyword_5_0() { return cUNKNOWNUnknownKeyword_5_0; }
	}
	
	private final ResultReportsElements pResultReports;
	private final ResultReportCollectionElements pResultReportCollection;
	private final ResultReportElements pResultReport;
	private final ResultContributorElements pResultContributor;
	private final IssueReportElements pIssueReport;
	private final ResultIssueElements pResultIssue;
	private final ResultDataElements pResultData;
	private final ResultIssueTypeElements unknownRuleResultIssueType;
	private final URIIDElements pURIID;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public ResultsGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pResultReports = new ResultReportsElements();
		this.pResultReportCollection = new ResultReportCollectionElements();
		this.pResultReport = new ResultReportElements();
		this.pResultContributor = new ResultContributorElements();
		this.pIssueReport = new IssueReportElements();
		this.pResultIssue = new ResultIssueElements();
		this.pResultData = new ResultDataElements();
		this.unknownRuleResultIssueType = new ResultIssueTypeElements();
		this.pURIID = new URIIDElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.results.Results".equals(grammar.getName())) {
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

	
	//ResultReports:
	//	ResultReport | ResultReportCollection | IssueReport;
	public ResultReportsElements getResultReportsAccess() {
		return pResultReports;
	}
	
	public ParserRule getResultReportsRule() {
		return getResultReportsAccess().getRule();
	}

	//// Collection of reports for an instance model (root), e.g., for collection of end to end flows
	//ResultReportCollection:
	//	"reports" name=ID (":" title=STRING)? "[" "target" target= // system instance or other EObject
	//	[ecore::EObject|URIID] ("description" decription=STRING)? content+=ResultReport* issues+=ResultIssue? "]";
	public ResultReportCollectionElements getResultReportCollectionAccess() {
		return pResultReportCollection;
	}
	
	public ParserRule getResultReportCollectionRule() {
		return getResultReportCollectionAccess().getRule();
	}

	//// one report of an analysis for one item in the instance model.
	//// it may be a report per SOM or per end to end flow
	//// result represents the result data that can be queried
	//ResultReport returns ResultIssue:
	//	{ResultReport} "report" name=ID (":" title=STRING)? target= // system instance or other EObject
	//	[ecore::EObject|URIID] issueType=ResultIssueType message=STRING ("exception" exceptionType=STRING)? "[" ("description"
	//	decription=STRING)? ("heading" heading=STRING content+=ResultContributor*)? ("results" resultData+=ResultData+)?
	//	issues+=ResultIssue? "]";
	public ResultReportElements getResultReportAccess() {
		return pResultReport;
	}
	
	public ParserRule getResultReportRule() {
		return getResultReportAccess().getRule();
	}

	//// one row to represent a contributor to the result calculation.
	//// this structure can be nested
	//// each contributor can have issues reported
	//// user may define a subclass of this to add analysis specific data representations
	//ResultContributor returns ResultIssue:
	//	{ResultContributor} "contributor" target= // instance model element or declarative model element
	//	[ecore::EObject|URIID] issueType=ResultIssueType message=STRING ("exception" exceptionType=STRING)? "[" "data"
	//	cell+=STRING+ issues+=ResultIssue* subcontributor+=ResultContributor* "]";
	public ResultContributorElements getResultContributorAccess() {
		return pResultContributor;
	}
	
	public ParserRule getResultContributorRule() {
		return getResultContributorAccess().getRule();
	}

	//IssueReport returns ResultIssue:
	//	{IssueReport} "issues" issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])?
	//	("exception" exceptionType=STRING)? ("[" issues+=ResultIssue* "]")?;
	public IssueReportElements getIssueReportAccess() {
		return pIssueReport;
	}
	
	public ParserRule getIssueReportRule() {
		return getIssueReportAccess().getRule();
	}

	//// This is similar to diagnostics
	//ResultIssue:
	//	"issue" issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception"
	//	exceptionType=STRING)? ("[" issues+=ResultIssue* "]")?;
	public ResultIssueElements getResultIssueAccess() {
		return pResultIssue;
	}
	
	public ParserRule getResultIssueRule() {
		return getResultIssueAccess().getRule();
	}

	//// default implementation of result data
	//// a set of name value pairs with the values expressed as strings
	//// user can create a subclass of this to provide a specialized representation
	//ResultData:
	//	name=ID "=" value=STRING;
	public ResultDataElements getResultDataAccess() {
		return pResultData;
	}
	
	public ParserRule getResultDataRule() {
		return getResultDataAccess().getRule();
	}

	//enum ResultIssueType:
	//	ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail" | UNKNOWN="unknown";
	public ResultIssueTypeElements getResultIssueTypeAccess() {
		return unknownRuleResultIssueType;
	}
	
	public EnumRule getResultIssueTypeRule() {
		return getResultIssueTypeAccess().getRule();
	}

	////terminal URIID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'#'|'@'|'/'|':')*;
	//URIID:
	//	STRING;
	public URIIDElements getURIIDAccess() {
		return pURIID;
	}
	
	public ParserRule getURIIDRule() {
		return getURIIDAccess().getRule();
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
