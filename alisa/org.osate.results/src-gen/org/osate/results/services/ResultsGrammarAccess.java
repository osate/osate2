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
	
	
	public class ResultReportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultReport");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cResultDataReportParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cResultReportCollectionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cIssuesReportParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//ResultReport:
		//	ResultDataReport | ResultReportCollection | IssuesReport;
		@Override public ParserRule getRule() { return rule; }

		//ResultDataReport | ResultReportCollection | IssuesReport
		public Alternatives getAlternatives() { return cAlternatives; }

		//ResultDataReport
		public RuleCall getResultDataReportParserRuleCall_0() { return cResultDataReportParserRuleCall_0; }

		//ResultReportCollection
		public RuleCall getResultReportCollectionParserRuleCall_1() { return cResultReportCollectionParserRuleCall_1; }

		//IssuesReport
		public RuleCall getIssuesReportParserRuleCall_2() { return cIssuesReportParserRuleCall_2; }
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
		private final Keyword cForKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cTargetAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cTargetEObjectCrossReference_4_0 = (CrossReference)cTargetAssignment_4.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_4_0_1 = (RuleCall)cTargetEObjectCrossReference_4_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
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
		//	"reports" name=ID (":" title=STRING)? "for" target= // system instance or other EObject
		//	[ecore::EObject|URIID] "[" ("description" decription=STRING)? content+=ResultReport* issues+=ResultIssue? "]";
		@Override public ParserRule getRule() { return rule; }

		//"reports" name=ID (":" title=STRING)? "for" target= // system instance or other EObject
		//[ecore::EObject|URIID] "[" ("description" decription=STRING)? content+=ResultReport* issues+=ResultIssue? "]"
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

		//"for"
		public Keyword getForKeyword_3() { return cForKeyword_3; }

		//target= // system instance or other EObject
		//[ecore::EObject|URIID]
		public Assignment getTargetAssignment_4() { return cTargetAssignment_4; }

		//// system instance or other EObject
		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_4_0() { return cTargetEObjectCrossReference_4_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_4_0_1() { return cTargetEObjectURIIDParserRuleCall_4_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_5() { return cLeftSquareBracketKeyword_5; }

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

	public class ResultDataReportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultDataReport");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReportKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Keyword cForKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cTargetAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cTargetEObjectCrossReference_4_0 = (CrossReference)cTargetAssignment_4.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_4_0_1 = (RuleCall)cTargetEObjectCrossReference_4_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cDescriptionKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cDecriptionAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cDecriptionSTRINGTerminalRuleCall_6_1_0 = (RuleCall)cDecriptionAssignment_6_1.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cHeadingKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cHeadingAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cHeadingSTRINGTerminalRuleCall_7_1_0 = (RuleCall)cHeadingAssignment_7_1.eContents().get(0);
		private final Assignment cContentAssignment_7_2 = (Assignment)cGroup_7.eContents().get(2);
		private final RuleCall cContentResultContributorParserRuleCall_7_2_0 = (RuleCall)cContentAssignment_7_2.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cResultsKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cResultDataAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cResultDataResultDataParserRuleCall_8_1_0 = (RuleCall)cResultDataAssignment_8_1.eContents().get(0);
		private final Assignment cIssuesAssignment_9 = (Assignment)cGroup.eContents().get(9);
		private final RuleCall cIssuesResultIssueParserRuleCall_9_0 = (RuleCall)cIssuesAssignment_9.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_10 = (Keyword)cGroup.eContents().get(10);
		
		//// one report of an analysis for one item in the instance model.
		//// it may be a report per SOM or per end to end flow
		//// result represents the result data that can be queried
		//ResultDataReport:
		//	"report" name=ID (":" title=STRING)? "for" target= // system instance or other EObject
		//	[ecore::EObject|URIID] "[" ("description" decription=STRING)? ("heading" heading=STRING content+=ResultContributor*)?
		//	("results" resultData+=ResultData+)? issues+=ResultIssue* "]";
		@Override public ParserRule getRule() { return rule; }

		//"report" name=ID (":" title=STRING)? "for" target= // system instance or other EObject
		//[ecore::EObject|URIID] "[" ("description" decription=STRING)? ("heading" heading=STRING content+=ResultContributor*)?
		//("results" resultData+=ResultData+)? issues+=ResultIssue* "]"
		public Group getGroup() { return cGroup; }

		//"report"
		public Keyword getReportKeyword_0() { return cReportKeyword_0; }

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

		//"for"
		public Keyword getForKeyword_3() { return cForKeyword_3; }

		//target= // system instance or other EObject
		//[ecore::EObject|URIID]
		public Assignment getTargetAssignment_4() { return cTargetAssignment_4; }

		//// system instance or other EObject
		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_4_0() { return cTargetEObjectCrossReference_4_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_4_0_1() { return cTargetEObjectURIIDParserRuleCall_4_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_5() { return cLeftSquareBracketKeyword_5; }

		//("description" decription=STRING)?
		public Group getGroup_6() { return cGroup_6; }

		//"description"
		public Keyword getDescriptionKeyword_6_0() { return cDescriptionKeyword_6_0; }

		//decription=STRING
		public Assignment getDecriptionAssignment_6_1() { return cDecriptionAssignment_6_1; }

		//STRING
		public RuleCall getDecriptionSTRINGTerminalRuleCall_6_1_0() { return cDecriptionSTRINGTerminalRuleCall_6_1_0; }

		//("heading" heading=STRING content+=ResultContributor*)?
		public Group getGroup_7() { return cGroup_7; }

		//"heading"
		public Keyword getHeadingKeyword_7_0() { return cHeadingKeyword_7_0; }

		//heading=STRING
		public Assignment getHeadingAssignment_7_1() { return cHeadingAssignment_7_1; }

		//STRING
		public RuleCall getHeadingSTRINGTerminalRuleCall_7_1_0() { return cHeadingSTRINGTerminalRuleCall_7_1_0; }

		//content+=ResultContributor*
		public Assignment getContentAssignment_7_2() { return cContentAssignment_7_2; }

		//ResultContributor
		public RuleCall getContentResultContributorParserRuleCall_7_2_0() { return cContentResultContributorParserRuleCall_7_2_0; }

		//("results" resultData+=ResultData+)?
		public Group getGroup_8() { return cGroup_8; }

		//"results"
		public Keyword getResultsKeyword_8_0() { return cResultsKeyword_8_0; }

		//resultData+=ResultData+
		public Assignment getResultDataAssignment_8_1() { return cResultDataAssignment_8_1; }

		//ResultData
		public RuleCall getResultDataResultDataParserRuleCall_8_1_0() { return cResultDataResultDataParserRuleCall_8_1_0; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_9() { return cIssuesAssignment_9; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_9_0() { return cIssuesResultIssueParserRuleCall_9_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_10() { return cRightSquareBracketKeyword_10; }
	}

	public class ResultContributorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResultContributor");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cContributorKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTargetEObjectCrossReference_1_0 = (CrossReference)cTargetAssignment_1.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_1_0_1 = (RuleCall)cTargetEObjectCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cResultsKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cResultDataAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cResultDataResultDataParserRuleCall_3_1_0 = (RuleCall)cResultDataAssignment_3_1.eContents().get(0);
		private final Assignment cIssuesAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cIssuesResultIssueParserRuleCall_4_0 = (RuleCall)cIssuesAssignment_4.eContents().get(0);
		private final Assignment cSubcontributorAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cSubcontributorResultContributorParserRuleCall_5_0 = (RuleCall)cSubcontributorAssignment_5.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//// one row to represent a contributor to the result calculation.
		//// this structure can be nested
		//// each contributor can have issues reported
		//// user may define a subclass of this to add analysis specific data representations
		//ResultContributor:
		//	"contributor" target= // instance model element or declarative model element
		//	[ecore::EObject|URIID] "[" ("results" resultData+=ResultData+)? issues+=ResultIssue* subcontributor+=ResultContributor*
		//	"]";
		@Override public ParserRule getRule() { return rule; }

		//"contributor" target= // instance model element or declarative model element
		//[ecore::EObject|URIID] "[" ("results" resultData+=ResultData+)? issues+=ResultIssue* subcontributor+=ResultContributor*
		//"]"
		public Group getGroup() { return cGroup; }

		//"contributor"
		public Keyword getContributorKeyword_0() { return cContributorKeyword_0; }

		//target= // instance model element or declarative model element
		//[ecore::EObject|URIID]
		public Assignment getTargetAssignment_1() { return cTargetAssignment_1; }

		//// instance model element or declarative model element
		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_1_0() { return cTargetEObjectCrossReference_1_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_1_0_1() { return cTargetEObjectURIIDParserRuleCall_1_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//("results" resultData+=ResultData+)?
		public Group getGroup_3() { return cGroup_3; }

		//"results"
		public Keyword getResultsKeyword_3_0() { return cResultsKeyword_3_0; }

		//resultData+=ResultData+
		public Assignment getResultDataAssignment_3_1() { return cResultDataAssignment_3_1; }

		//ResultData
		public RuleCall getResultDataResultDataParserRuleCall_3_1_0() { return cResultDataResultDataParserRuleCall_3_1_0; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_4() { return cIssuesAssignment_4; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_4_0() { return cIssuesResultIssueParserRuleCall_4_0; }

		//subcontributor+=ResultContributor*
		public Assignment getSubcontributorAssignment_5() { return cSubcontributorAssignment_5; }

		//ResultContributor
		public RuleCall getSubcontributorResultContributorParserRuleCall_5_0() { return cSubcontributorResultContributorParserRuleCall_5_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class IssuesReportElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IssuesReport");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cIssuesKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cForKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTargetAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cTargetEObjectCrossReference_2_1_0 = (CrossReference)cTargetAssignment_2_1.eContents().get(0);
		private final RuleCall cTargetEObjectURIIDParserRuleCall_2_1_0_1 = (RuleCall)cTargetEObjectCrossReference_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftSquareBracketKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cDescriptionKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cDescriptionAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cDescriptionSTRINGTerminalRuleCall_3_1_1_0 = (RuleCall)cDescriptionAssignment_3_1_1.eContents().get(0);
		private final Assignment cIssuesAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final RuleCall cIssuesResultIssueParserRuleCall_3_2_0 = (RuleCall)cIssuesAssignment_3_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3_3 = (Keyword)cGroup_3.eContents().get(3);
		
		//IssuesReport:
		//	"issues" name=ID ("for" target=[ecore::EObject|URIID])? ("[" ("description" description=STRING)? issues+=ResultIssue*
		//	"]")?;
		@Override public ParserRule getRule() { return rule; }

		//"issues" name=ID ("for" target=[ecore::EObject|URIID])? ("[" ("description" description=STRING)? issues+=ResultIssue*
		//"]")?
		public Group getGroup() { return cGroup; }

		//"issues"
		public Keyword getIssuesKeyword_0() { return cIssuesKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("for" target=[ecore::EObject|URIID])?
		public Group getGroup_2() { return cGroup_2; }

		//"for"
		public Keyword getForKeyword_2_0() { return cForKeyword_2_0; }

		//target=[ecore::EObject|URIID]
		public Assignment getTargetAssignment_2_1() { return cTargetAssignment_2_1; }

		//[ecore::EObject|URIID]
		public CrossReference getTargetEObjectCrossReference_2_1_0() { return cTargetEObjectCrossReference_2_1_0; }

		//URIID
		public RuleCall getTargetEObjectURIIDParserRuleCall_2_1_0_1() { return cTargetEObjectURIIDParserRuleCall_2_1_0_1; }

		//("[" ("description" description=STRING)? issues+=ResultIssue* "]")?
		public Group getGroup_3() { return cGroup_3; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3_0() { return cLeftSquareBracketKeyword_3_0; }

		//("description" description=STRING)?
		public Group getGroup_3_1() { return cGroup_3_1; }

		//"description"
		public Keyword getDescriptionKeyword_3_1_0() { return cDescriptionKeyword_3_1_0; }

		//description=STRING
		public Assignment getDescriptionAssignment_3_1_1() { return cDescriptionAssignment_3_1_1; }

		//STRING
		public RuleCall getDescriptionSTRINGTerminalRuleCall_3_1_1_0() { return cDescriptionSTRINGTerminalRuleCall_3_1_1_0; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_3_2() { return cIssuesAssignment_3_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_3_2_0() { return cIssuesResultIssueParserRuleCall_3_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_3_3() { return cRightSquareBracketKeyword_3_3; }
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
		private final EnumLiteralDeclaration cTBDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cTBDTbdKeyword_0_0 = (Keyword)cTBDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cUNKNOWNEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cUNKNOWNUnknownKeyword_1_0 = (Keyword)cUNKNOWNEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cERROREnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cERRORErrorKeyword_2_0 = (Keyword)cERROREnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cWARNINGEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cWARNINGWarningKeyword_3_0 = (Keyword)cWARNINGEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cINFOEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cINFOInfoKeyword_4_0 = (Keyword)cINFOEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cSUCCESSEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cSUCCESSSuccessKeyword_5_0 = (Keyword)cSUCCESSEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cFAILEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cFAILFailKeyword_6_0 = (Keyword)cFAILEnumLiteralDeclaration_6.eContents().get(0);
		
		//enum ResultIssueType:
		//	TBD="tbd" | UNKNOWN="unknown" | ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail";
		public EnumRule getRule() { return rule; }

		//TBD="tbd" | UNKNOWN="unknown" | ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail"
		public Alternatives getAlternatives() { return cAlternatives; }

		//TBD="tbd"
		public EnumLiteralDeclaration getTBDEnumLiteralDeclaration_0() { return cTBDEnumLiteralDeclaration_0; }

		//"tbd"
		public Keyword getTBDTbdKeyword_0_0() { return cTBDTbdKeyword_0_0; }

		//UNKNOWN="unknown"
		public EnumLiteralDeclaration getUNKNOWNEnumLiteralDeclaration_1() { return cUNKNOWNEnumLiteralDeclaration_1; }

		//"unknown"
		public Keyword getUNKNOWNUnknownKeyword_1_0() { return cUNKNOWNUnknownKeyword_1_0; }

		//ERROR="error"
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_2() { return cERROREnumLiteralDeclaration_2; }

		//"error"
		public Keyword getERRORErrorKeyword_2_0() { return cERRORErrorKeyword_2_0; }

		//WARNING="warning"
		public EnumLiteralDeclaration getWARNINGEnumLiteralDeclaration_3() { return cWARNINGEnumLiteralDeclaration_3; }

		//"warning"
		public Keyword getWARNINGWarningKeyword_3_0() { return cWARNINGWarningKeyword_3_0; }

		//INFO="info"
		public EnumLiteralDeclaration getINFOEnumLiteralDeclaration_4() { return cINFOEnumLiteralDeclaration_4; }

		//"info"
		public Keyword getINFOInfoKeyword_4_0() { return cINFOInfoKeyword_4_0; }

		//SUCCESS="success"
		public EnumLiteralDeclaration getSUCCESSEnumLiteralDeclaration_5() { return cSUCCESSEnumLiteralDeclaration_5; }

		//"success"
		public Keyword getSUCCESSSuccessKeyword_5_0() { return cSUCCESSSuccessKeyword_5_0; }

		//FAIL="fail"
		public EnumLiteralDeclaration getFAILEnumLiteralDeclaration_6() { return cFAILEnumLiteralDeclaration_6; }

		//"fail"
		public Keyword getFAILFailKeyword_6_0() { return cFAILFailKeyword_6_0; }
	}
	
	private final ResultReportElements pResultReport;
	private final ResultReportCollectionElements pResultReportCollection;
	private final ResultDataReportElements pResultDataReport;
	private final ResultContributorElements pResultContributor;
	private final IssuesReportElements pIssuesReport;
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
		this.pResultReport = new ResultReportElements();
		this.pResultReportCollection = new ResultReportCollectionElements();
		this.pResultDataReport = new ResultDataReportElements();
		this.pResultContributor = new ResultContributorElements();
		this.pIssuesReport = new IssuesReportElements();
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

	
	//ResultReport:
	//	ResultDataReport | ResultReportCollection | IssuesReport;
	public ResultReportElements getResultReportAccess() {
		return pResultReport;
	}
	
	public ParserRule getResultReportRule() {
		return getResultReportAccess().getRule();
	}

	//// Collection of reports for an instance model (root), e.g., for collection of end to end flows
	//ResultReportCollection:
	//	"reports" name=ID (":" title=STRING)? "for" target= // system instance or other EObject
	//	[ecore::EObject|URIID] "[" ("description" decription=STRING)? content+=ResultReport* issues+=ResultIssue? "]";
	public ResultReportCollectionElements getResultReportCollectionAccess() {
		return pResultReportCollection;
	}
	
	public ParserRule getResultReportCollectionRule() {
		return getResultReportCollectionAccess().getRule();
	}

	//// one report of an analysis for one item in the instance model.
	//// it may be a report per SOM or per end to end flow
	//// result represents the result data that can be queried
	//ResultDataReport:
	//	"report" name=ID (":" title=STRING)? "for" target= // system instance or other EObject
	//	[ecore::EObject|URIID] "[" ("description" decription=STRING)? ("heading" heading=STRING content+=ResultContributor*)?
	//	("results" resultData+=ResultData+)? issues+=ResultIssue* "]";
	public ResultDataReportElements getResultDataReportAccess() {
		return pResultDataReport;
	}
	
	public ParserRule getResultDataReportRule() {
		return getResultDataReportAccess().getRule();
	}

	//// one row to represent a contributor to the result calculation.
	//// this structure can be nested
	//// each contributor can have issues reported
	//// user may define a subclass of this to add analysis specific data representations
	//ResultContributor:
	//	"contributor" target= // instance model element or declarative model element
	//	[ecore::EObject|URIID] "[" ("results" resultData+=ResultData+)? issues+=ResultIssue* subcontributor+=ResultContributor*
	//	"]";
	public ResultContributorElements getResultContributorAccess() {
		return pResultContributor;
	}
	
	public ParserRule getResultContributorRule() {
		return getResultContributorAccess().getRule();
	}

	//IssuesReport:
	//	"issues" name=ID ("for" target=[ecore::EObject|URIID])? ("[" ("description" description=STRING)? issues+=ResultIssue*
	//	"]")?;
	public IssuesReportElements getIssuesReportAccess() {
		return pIssuesReport;
	}
	
	public ParserRule getIssuesReportRule() {
		return getIssuesReportAccess().getRule();
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
	//	TBD="tbd" | UNKNOWN="unknown" | ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail";
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
