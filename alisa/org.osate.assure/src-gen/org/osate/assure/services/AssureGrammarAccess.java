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
package org.osate.assure.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.osate.alisa.common.services.CommonGrammarAccess;

@Singleton
public class AssureGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class AssuranceCaseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AssuranceCase");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCaseKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameQualifiedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cForKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTargetAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cTargetAssurancePlanCrossReference_2_1_0 = (CrossReference)cTargetAssignment_2_1.eContents().get(0);
		private final RuleCall cTargetAssurancePlanQualifiedNameParserRuleCall_2_1_0_1 = (RuleCall)cTargetAssurancePlanCrossReference_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cSystemKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTargetSystemAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTargetSystemIDTerminalRuleCall_3_1_0 = (RuleCall)cTargetSystemAssignment_3_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cMetricsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cMetricsMetricsParserRuleCall_5_0 = (RuleCall)cMetricsAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cMessageKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cMessageAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_6_1_0 = (RuleCall)cMessageAssignment_6_1.eContents().get(0);
		private final Assignment cClaimResultAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cClaimResultClaimResultParserRuleCall_7_0 = (RuleCall)cClaimResultAssignment_7.eContents().get(0);
		private final Assignment cSubAssuranceCaseAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cSubAssuranceCaseAssuranceCaseParserRuleCall_8_0 = (RuleCall)cSubAssuranceCaseAssignment_8.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//// result for a system in the architecture hierarchy
		//AssuranceCase:
		//	"case" name=QualifiedName ("for" target=[Alisa::AssurancePlan|QualifiedName])? ("system" targetSystem=ID)? "["
		//	metrics=Metrics ("message" message=STRING)? claimResult+=ClaimResult* subAssuranceCase+=AssuranceCase* "]";
		@Override public ParserRule getRule() { return rule; }

		//"case" name=QualifiedName ("for" target=[Alisa::AssurancePlan|QualifiedName])? ("system" targetSystem=ID)? "["
		//metrics=Metrics ("message" message=STRING)? claimResult+=ClaimResult* subAssuranceCase+=AssuranceCase* "]"
		public Group getGroup() { return cGroup; }

		//"case"
		public Keyword getCaseKeyword_0() { return cCaseKeyword_0; }

		//name=QualifiedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_1_0() { return cNameQualifiedNameParserRuleCall_1_0; }

		//("for" target=[Alisa::AssurancePlan|QualifiedName])?
		public Group getGroup_2() { return cGroup_2; }

		//"for"
		public Keyword getForKeyword_2_0() { return cForKeyword_2_0; }

		//target=[Alisa::AssurancePlan|QualifiedName]
		public Assignment getTargetAssignment_2_1() { return cTargetAssignment_2_1; }

		//[Alisa::AssurancePlan|QualifiedName]
		public CrossReference getTargetAssurancePlanCrossReference_2_1_0() { return cTargetAssurancePlanCrossReference_2_1_0; }

		//QualifiedName
		public RuleCall getTargetAssurancePlanQualifiedNameParserRuleCall_2_1_0_1() { return cTargetAssurancePlanQualifiedNameParserRuleCall_2_1_0_1; }

		//("system" targetSystem=ID)?
		public Group getGroup_3() { return cGroup_3; }

		//"system"
		public Keyword getSystemKeyword_3_0() { return cSystemKeyword_3_0; }

		//targetSystem=ID
		public Assignment getTargetSystemAssignment_3_1() { return cTargetSystemAssignment_3_1; }

		//ID
		public RuleCall getTargetSystemIDTerminalRuleCall_3_1_0() { return cTargetSystemIDTerminalRuleCall_3_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_5() { return cMetricsAssignment_5; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_5_0() { return cMetricsMetricsParserRuleCall_5_0; }

		//("message" message=STRING)?
		public Group getGroup_6() { return cGroup_6; }

		//"message"
		public Keyword getMessageKeyword_6_0() { return cMessageKeyword_6_0; }

		//message=STRING
		public Assignment getMessageAssignment_6_1() { return cMessageAssignment_6_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_6_1_0() { return cMessageSTRINGTerminalRuleCall_6_1_0; }

		//claimResult+=ClaimResult*
		public Assignment getClaimResultAssignment_7() { return cClaimResultAssignment_7; }

		//ClaimResult
		public RuleCall getClaimResultClaimResultParserRuleCall_7_0() { return cClaimResultClaimResultParserRuleCall_7_0; }

		//subAssuranceCase+=AssuranceCase*
		public Assignment getSubAssuranceCaseAssignment_8() { return cSubAssuranceCaseAssignment_8; }

		//AssuranceCase
		public RuleCall getSubAssuranceCaseAssuranceCaseParserRuleCall_8_0() { return cSubAssuranceCaseAssuranceCaseParserRuleCall_8_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_9() { return cRightSquareBracketKeyword_9; }
	}

	public class ClaimResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ClaimResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cClaimKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTargetAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTargetRequirementCrossReference_1_0 = (CrossReference)cTargetAssignment_1.eContents().get(0);
		private final RuleCall cTargetRequirementQualifiedNameParserRuleCall_1_0_1 = (RuleCall)cTargetRequirementCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cMetricsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMetricsMetricsParserRuleCall_3_0 = (RuleCall)cMetricsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cMessageKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cMessageAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cMessageAssignment_4_1.eContents().get(0);
		private final Assignment cSubClaimResultAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cSubClaimResultClaimResultParserRuleCall_5_0 = (RuleCall)cSubClaimResultAssignment_5.eContents().get(0);
		private final Assignment cVerificationActivityResultAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cVerificationActivityResultVerificationExprParserRuleCall_6_0 = (RuleCall)cVerificationActivityResultAssignment_6.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//// Result of meeting a requirement
		//ClaimResult:
		//	"claim" target=[ReqSpec::Requirement|QualifiedName] "[" metrics=Metrics ("message" message=STRING)?
		//	subClaimResult+=ClaimResult* verificationActivityResult+=VerificationExpr* "]";
		@Override public ParserRule getRule() { return rule; }

		//"claim" target=[ReqSpec::Requirement|QualifiedName] "[" metrics=Metrics ("message" message=STRING)?
		//subClaimResult+=ClaimResult* verificationActivityResult+=VerificationExpr* "]"
		public Group getGroup() { return cGroup; }

		//"claim"
		public Keyword getClaimKeyword_0() { return cClaimKeyword_0; }

		//target=[ReqSpec::Requirement|QualifiedName]
		public Assignment getTargetAssignment_1() { return cTargetAssignment_1; }

		//[ReqSpec::Requirement|QualifiedName]
		public CrossReference getTargetRequirementCrossReference_1_0() { return cTargetRequirementCrossReference_1_0; }

		//QualifiedName
		public RuleCall getTargetRequirementQualifiedNameParserRuleCall_1_0_1() { return cTargetRequirementQualifiedNameParserRuleCall_1_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_3() { return cMetricsAssignment_3; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_3_0() { return cMetricsMetricsParserRuleCall_3_0; }

		//("message" message=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//"message"
		public Keyword getMessageKeyword_4_0() { return cMessageKeyword_4_0; }

		//message=STRING
		public Assignment getMessageAssignment_4_1() { return cMessageAssignment_4_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_4_1_0() { return cMessageSTRINGTerminalRuleCall_4_1_0; }

		//subClaimResult+=ClaimResult*
		public Assignment getSubClaimResultAssignment_5() { return cSubClaimResultAssignment_5; }

		//ClaimResult
		public RuleCall getSubClaimResultClaimResultParserRuleCall_5_0() { return cSubClaimResultClaimResultParserRuleCall_5_0; }

		//verificationActivityResult+=VerificationExpr*
		public Assignment getVerificationActivityResultAssignment_6() { return cVerificationActivityResultAssignment_6; }

		//VerificationExpr
		public RuleCall getVerificationActivityResultVerificationExprParserRuleCall_6_0() { return cVerificationActivityResultVerificationExprParserRuleCall_6_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_7() { return cRightSquareBracketKeyword_7; }
	}

	public class PreconditionResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PreconditionResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPreconditionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cPreconditionResultAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cTargetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cTargetVerificationMethodCrossReference_2_0 = (CrossReference)cTargetAssignment_2.eContents().get(0);
		private final RuleCall cTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cTargetVerificationMethodCrossReference_2_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cExecutionstateKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cExecutionStateAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cExecutionStateVerificationExecutionStateEnumRuleCall_5_0 = (RuleCall)cExecutionStateAssignment_5.eContents().get(0);
		private final Keyword cResultstateKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cResultStateAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cResultStateVerificationResultStateEnumRuleCall_7_0 = (RuleCall)cResultStateAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cIssuesKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Assignment cIssuesAssignment_8_2 = (Assignment)cGroup_8.eContents().get(2);
		private final RuleCall cIssuesResultIssueParserRuleCall_8_2_0 = (RuleCall)cIssuesAssignment_8_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8_3 = (Keyword)cGroup_8.eContents().get(3);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cReportKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cResultReportAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final CrossReference cResultReportResultReportCrossReference_9_1_0 = (CrossReference)cResultReportAssignment_9_1.eContents().get(0);
		private final RuleCall cResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1 = (RuleCall)cResultReportResultReportCrossReference_9_1_0.eContents().get(1);
		private final Assignment cMetricsAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cMetricsMetricsParserRuleCall_10_0 = (RuleCall)cMetricsAssignment_10.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cMessageKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cMessageAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_11_1_0 = (RuleCall)cMessageAssignment_11_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_12 = (Keyword)cGroup.eContents().get(12);
		
		//PreconditionResult returns VerificationResult:
		//	"precondition" {PreconditionResult} target=[Verify::VerificationMethod|QualifiedName] "[" "executionstate"
		//	executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
		//	issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? // pointer to separate report
		//	metrics=Metrics ("message" message=STRING)? "]";
		@Override public ParserRule getRule() { return rule; }

		//"precondition" {PreconditionResult} target=[Verify::VerificationMethod|QualifiedName] "[" "executionstate"
		//executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
		//issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? // pointer to separate report
		//metrics=Metrics ("message" message=STRING)? "]"
		public Group getGroup() { return cGroup; }

		//"precondition"
		public Keyword getPreconditionKeyword_0() { return cPreconditionKeyword_0; }

		//{PreconditionResult}
		public Action getPreconditionResultAction_1() { return cPreconditionResultAction_1; }

		//target=[Verify::VerificationMethod|QualifiedName]
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }

		//[Verify::VerificationMethod|QualifiedName]
		public CrossReference getTargetVerificationMethodCrossReference_2_0() { return cTargetVerificationMethodCrossReference_2_0; }

		//QualifiedName
		public RuleCall getTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1() { return cTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//"executionstate"
		public Keyword getExecutionstateKeyword_4() { return cExecutionstateKeyword_4; }

		//executionState=VerificationExecutionState
		public Assignment getExecutionStateAssignment_5() { return cExecutionStateAssignment_5; }

		//VerificationExecutionState
		public RuleCall getExecutionStateVerificationExecutionStateEnumRuleCall_5_0() { return cExecutionStateVerificationExecutionStateEnumRuleCall_5_0; }

		//"resultstate"
		public Keyword getResultstateKeyword_6() { return cResultstateKeyword_6; }

		//resultState=VerificationResultState
		public Assignment getResultStateAssignment_7() { return cResultStateAssignment_7; }

		//VerificationResultState
		public RuleCall getResultStateVerificationResultStateEnumRuleCall_7_0() { return cResultStateVerificationResultStateEnumRuleCall_7_0; }

		//("issues" "[" issues+=ResultIssue* "]")?
		public Group getGroup_8() { return cGroup_8; }

		//"issues"
		public Keyword getIssuesKeyword_8_0() { return cIssuesKeyword_8_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_8_1() { return cLeftSquareBracketKeyword_8_1; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_8_2() { return cIssuesAssignment_8_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_2_0() { return cIssuesResultIssueParserRuleCall_8_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8_3() { return cRightSquareBracketKeyword_8_3; }

		//("report" resultReport=[results::ResultReport|QualifiedName])?
		public Group getGroup_9() { return cGroup_9; }

		//"report"
		public Keyword getReportKeyword_9_0() { return cReportKeyword_9_0; }

		//resultReport=[results::ResultReport|QualifiedName]
		public Assignment getResultReportAssignment_9_1() { return cResultReportAssignment_9_1; }

		//[results::ResultReport|QualifiedName]
		public CrossReference getResultReportResultReportCrossReference_9_1_0() { return cResultReportResultReportCrossReference_9_1_0; }

		//QualifiedName
		public RuleCall getResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1() { return cResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_10() { return cMetricsAssignment_10; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_10_0() { return cMetricsMetricsParserRuleCall_10_0; }

		//("message" message=STRING)?
		public Group getGroup_11() { return cGroup_11; }

		//"message"
		public Keyword getMessageKeyword_11_0() { return cMessageKeyword_11_0; }

		//message=STRING
		public Assignment getMessageAssignment_11_1() { return cMessageAssignment_11_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_11_1_0() { return cMessageSTRINGTerminalRuleCall_11_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_12() { return cRightSquareBracketKeyword_12; }
	}

	public class ValidationResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ValidationResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cValidationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cValidationResultAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cTargetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cTargetVerificationMethodCrossReference_2_0 = (CrossReference)cTargetAssignment_2.eContents().get(0);
		private final RuleCall cTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cTargetVerificationMethodCrossReference_2_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cExecutionstateKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cExecutionStateAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cExecutionStateVerificationExecutionStateEnumRuleCall_5_0 = (RuleCall)cExecutionStateAssignment_5.eContents().get(0);
		private final Keyword cResultstateKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cResultStateAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cResultStateVerificationResultStateEnumRuleCall_7_0 = (RuleCall)cResultStateAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cIssuesKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Assignment cIssuesAssignment_8_2 = (Assignment)cGroup_8.eContents().get(2);
		private final RuleCall cIssuesResultIssueParserRuleCall_8_2_0 = (RuleCall)cIssuesAssignment_8_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8_3 = (Keyword)cGroup_8.eContents().get(3);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cReportKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cResultReportAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final CrossReference cResultReportResultReportCrossReference_9_1_0 = (CrossReference)cResultReportAssignment_9_1.eContents().get(0);
		private final RuleCall cResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1 = (RuleCall)cResultReportResultReportCrossReference_9_1_0.eContents().get(1);
		private final Assignment cMetricsAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cMetricsMetricsParserRuleCall_10_0 = (RuleCall)cMetricsAssignment_10.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cMessageKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cMessageAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_11_1_0 = (RuleCall)cMessageAssignment_11_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_12 = (Keyword)cGroup.eContents().get(12);
		
		//ValidationResult returns VerificationResult:
		//	"validation" {ValidationResult} target=[Verify::VerificationMethod|QualifiedName] "[" "executionstate"
		//	executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
		//	issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? // pointer to separate report
		//	metrics=Metrics ("message" message=STRING)? "]";
		@Override public ParserRule getRule() { return rule; }

		//"validation" {ValidationResult} target=[Verify::VerificationMethod|QualifiedName] "[" "executionstate"
		//executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
		//issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? // pointer to separate report
		//metrics=Metrics ("message" message=STRING)? "]"
		public Group getGroup() { return cGroup; }

		//"validation"
		public Keyword getValidationKeyword_0() { return cValidationKeyword_0; }

		//{ValidationResult}
		public Action getValidationResultAction_1() { return cValidationResultAction_1; }

		//target=[Verify::VerificationMethod|QualifiedName]
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }

		//[Verify::VerificationMethod|QualifiedName]
		public CrossReference getTargetVerificationMethodCrossReference_2_0() { return cTargetVerificationMethodCrossReference_2_0; }

		//QualifiedName
		public RuleCall getTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1() { return cTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//"executionstate"
		public Keyword getExecutionstateKeyword_4() { return cExecutionstateKeyword_4; }

		//executionState=VerificationExecutionState
		public Assignment getExecutionStateAssignment_5() { return cExecutionStateAssignment_5; }

		//VerificationExecutionState
		public RuleCall getExecutionStateVerificationExecutionStateEnumRuleCall_5_0() { return cExecutionStateVerificationExecutionStateEnumRuleCall_5_0; }

		//"resultstate"
		public Keyword getResultstateKeyword_6() { return cResultstateKeyword_6; }

		//resultState=VerificationResultState
		public Assignment getResultStateAssignment_7() { return cResultStateAssignment_7; }

		//VerificationResultState
		public RuleCall getResultStateVerificationResultStateEnumRuleCall_7_0() { return cResultStateVerificationResultStateEnumRuleCall_7_0; }

		//("issues" "[" issues+=ResultIssue* "]")?
		public Group getGroup_8() { return cGroup_8; }

		//"issues"
		public Keyword getIssuesKeyword_8_0() { return cIssuesKeyword_8_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_8_1() { return cLeftSquareBracketKeyword_8_1; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_8_2() { return cIssuesAssignment_8_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_2_0() { return cIssuesResultIssueParserRuleCall_8_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8_3() { return cRightSquareBracketKeyword_8_3; }

		//("report" resultReport=[results::ResultReport|QualifiedName])?
		public Group getGroup_9() { return cGroup_9; }

		//"report"
		public Keyword getReportKeyword_9_0() { return cReportKeyword_9_0; }

		//resultReport=[results::ResultReport|QualifiedName]
		public Assignment getResultReportAssignment_9_1() { return cResultReportAssignment_9_1; }

		//[results::ResultReport|QualifiedName]
		public CrossReference getResultReportResultReportCrossReference_9_1_0() { return cResultReportResultReportCrossReference_9_1_0; }

		//QualifiedName
		public RuleCall getResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1() { return cResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_10() { return cMetricsAssignment_10; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_10_0() { return cMetricsMetricsParserRuleCall_10_0; }

		//("message" message=STRING)?
		public Group getGroup_11() { return cGroup_11; }

		//"message"
		public Keyword getMessageKeyword_11_0() { return cMessageKeyword_11_0; }

		//message=STRING
		public Assignment getMessageAssignment_11_1() { return cMessageAssignment_11_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_11_1_0() { return cMessageSTRINGTerminalRuleCall_11_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_12() { return cRightSquareBracketKeyword_12; }
	}

	public class VerificationActivityResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationActivityResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVerificationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cVerificationActivityResultAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cTargetAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cTargetVerificationActivityCrossReference_2_0 = (CrossReference)cTargetAssignment_2.eContents().get(0);
		private final RuleCall cTargetVerificationActivityQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cTargetVerificationActivityCrossReference_2_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cExecutionstateKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cExecutionStateAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cExecutionStateVerificationExecutionStateEnumRuleCall_5_0 = (RuleCall)cExecutionStateAssignment_5.eContents().get(0);
		private final Keyword cResultstateKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cResultStateAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cResultStateVerificationResultStateEnumRuleCall_7_0 = (RuleCall)cResultStateAssignment_7.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cIssuesKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Assignment cIssuesAssignment_8_2 = (Assignment)cGroup_8.eContents().get(2);
		private final RuleCall cIssuesResultIssueParserRuleCall_8_2_0 = (RuleCall)cIssuesAssignment_8_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8_3 = (Keyword)cGroup_8.eContents().get(3);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cReportKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cResultReportAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final CrossReference cResultReportResultReportCrossReference_9_1_0 = (CrossReference)cResultReportAssignment_9_1.eContents().get(0);
		private final RuleCall cResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1 = (RuleCall)cResultReportResultReportCrossReference_9_1_0.eContents().get(1);
		private final Assignment cMetricsAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cMetricsMetricsParserRuleCall_10_0 = (RuleCall)cMetricsAssignment_10.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cMessageKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cMessageAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_11_1_0 = (RuleCall)cMessageAssignment_11_1.eContents().get(0);
		private final Assignment cPreconditionResultAssignment_12 = (Assignment)cGroup.eContents().get(12);
		private final RuleCall cPreconditionResultPreconditionResultParserRuleCall_12_0 = (RuleCall)cPreconditionResultAssignment_12.eContents().get(0);
		private final Assignment cValidationResultAssignment_13 = (Assignment)cGroup.eContents().get(13);
		private final RuleCall cValidationResultValidationResultParserRuleCall_13_0 = (RuleCall)cValidationResultAssignment_13.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_14 = (Keyword)cGroup.eContents().get(14);
		
		//// result of executing a verification activity
		//VerificationActivityResult returns VerificationResult:
		//	"verification" {VerificationActivityResult} target=[Verify::VerificationActivity|QualifiedName] "[" "executionstate"
		//	executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
		//	issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? metrics=Metrics ("message"
		//	message=STRING)? preconditionResult=PreconditionResult? validationResult=ValidationResult? "]";
		@Override public ParserRule getRule() { return rule; }

		//"verification" {VerificationActivityResult} target=[Verify::VerificationActivity|QualifiedName] "[" "executionstate"
		//executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
		//issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? metrics=Metrics ("message"
		//message=STRING)? preconditionResult=PreconditionResult? validationResult=ValidationResult? "]"
		public Group getGroup() { return cGroup; }

		//"verification"
		public Keyword getVerificationKeyword_0() { return cVerificationKeyword_0; }

		//{VerificationActivityResult}
		public Action getVerificationActivityResultAction_1() { return cVerificationActivityResultAction_1; }

		//target=[Verify::VerificationActivity|QualifiedName]
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }

		//[Verify::VerificationActivity|QualifiedName]
		public CrossReference getTargetVerificationActivityCrossReference_2_0() { return cTargetVerificationActivityCrossReference_2_0; }

		//QualifiedName
		public RuleCall getTargetVerificationActivityQualifiedNameParserRuleCall_2_0_1() { return cTargetVerificationActivityQualifiedNameParserRuleCall_2_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//"executionstate"
		public Keyword getExecutionstateKeyword_4() { return cExecutionstateKeyword_4; }

		//executionState=VerificationExecutionState
		public Assignment getExecutionStateAssignment_5() { return cExecutionStateAssignment_5; }

		//VerificationExecutionState
		public RuleCall getExecutionStateVerificationExecutionStateEnumRuleCall_5_0() { return cExecutionStateVerificationExecutionStateEnumRuleCall_5_0; }

		//"resultstate"
		public Keyword getResultstateKeyword_6() { return cResultstateKeyword_6; }

		//resultState=VerificationResultState
		public Assignment getResultStateAssignment_7() { return cResultStateAssignment_7; }

		//VerificationResultState
		public RuleCall getResultStateVerificationResultStateEnumRuleCall_7_0() { return cResultStateVerificationResultStateEnumRuleCall_7_0; }

		//("issues" "[" issues+=ResultIssue* "]")?
		public Group getGroup_8() { return cGroup_8; }

		//"issues"
		public Keyword getIssuesKeyword_8_0() { return cIssuesKeyword_8_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_8_1() { return cLeftSquareBracketKeyword_8_1; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_8_2() { return cIssuesAssignment_8_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_2_0() { return cIssuesResultIssueParserRuleCall_8_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8_3() { return cRightSquareBracketKeyword_8_3; }

		//("report" resultReport=[results::ResultReport|QualifiedName])?
		public Group getGroup_9() { return cGroup_9; }

		//"report"
		public Keyword getReportKeyword_9_0() { return cReportKeyword_9_0; }

		//resultReport=[results::ResultReport|QualifiedName]
		public Assignment getResultReportAssignment_9_1() { return cResultReportAssignment_9_1; }

		//[results::ResultReport|QualifiedName]
		public CrossReference getResultReportResultReportCrossReference_9_1_0() { return cResultReportResultReportCrossReference_9_1_0; }

		//QualifiedName
		public RuleCall getResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1() { return cResultReportResultReportQualifiedNameParserRuleCall_9_1_0_1; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_10() { return cMetricsAssignment_10; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_10_0() { return cMetricsMetricsParserRuleCall_10_0; }

		//("message" message=STRING)?
		public Group getGroup_11() { return cGroup_11; }

		//"message"
		public Keyword getMessageKeyword_11_0() { return cMessageKeyword_11_0; }

		//message=STRING
		public Assignment getMessageAssignment_11_1() { return cMessageAssignment_11_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_11_1_0() { return cMessageSTRINGTerminalRuleCall_11_1_0; }

		//preconditionResult=PreconditionResult?
		public Assignment getPreconditionResultAssignment_12() { return cPreconditionResultAssignment_12; }

		//PreconditionResult
		public RuleCall getPreconditionResultPreconditionResultParserRuleCall_12_0() { return cPreconditionResultPreconditionResultParserRuleCall_12_0; }

		//validationResult=ValidationResult?
		public Assignment getValidationResultAssignment_13() { return cValidationResultAssignment_13; }

		//ValidationResult
		public RuleCall getValidationResultValidationResultParserRuleCall_13_0() { return cValidationResultValidationResultParserRuleCall_13_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_14() { return cRightSquareBracketKeyword_14; }
	}

	public class AssureResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AssureResult");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVerificationExprParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAssuranceCaseParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cClaimResultParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPreconditionResultParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cValidationResultParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//AssureResult:
		//	VerificationExpr | AssuranceCase | ClaimResult | PreconditionResult | ValidationResult;
		@Override public ParserRule getRule() { return rule; }

		//VerificationExpr | AssuranceCase | ClaimResult | PreconditionResult | ValidationResult
		public Alternatives getAlternatives() { return cAlternatives; }

		//VerificationExpr
		public RuleCall getVerificationExprParserRuleCall_0() { return cVerificationExprParserRuleCall_0; }

		//AssuranceCase
		public RuleCall getAssuranceCaseParserRuleCall_1() { return cAssuranceCaseParserRuleCall_1; }

		//ClaimResult
		public RuleCall getClaimResultParserRuleCall_2() { return cClaimResultParserRuleCall_2; }

		//PreconditionResult
		public RuleCall getPreconditionResultParserRuleCall_3() { return cPreconditionResultParserRuleCall_3; }

		//ValidationResult
		public RuleCall getValidationResultParserRuleCall_4() { return cValidationResultParserRuleCall_4; }
	}

	public class VerificationExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationExpr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVerificationActivityResultParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cElseResultParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cThenResultParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//VerificationExpr:
		//	VerificationActivityResult | ElseResult | ThenResult;
		@Override public ParserRule getRule() { return rule; }

		//VerificationActivityResult | ElseResult | ThenResult
		public Alternatives getAlternatives() { return cAlternatives; }

		//VerificationActivityResult
		public RuleCall getVerificationActivityResultParserRuleCall_0() { return cVerificationActivityResultParserRuleCall_0; }

		//ElseResult
		public RuleCall getElseResultParserRuleCall_1() { return cElseResultParserRuleCall_1; }

		//ThenResult
		public RuleCall getThenResultParserRuleCall_2() { return cThenResultParserRuleCall_2; }
	}

	public class ElseResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ElseResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cElseKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cFirstAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFirstVerificationExprParserRuleCall_1_0 = (RuleCall)cFirstAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cErrorKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cErrorAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cErrorVerificationExprParserRuleCall_2_1_0 = (RuleCall)cErrorAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFailKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cFailAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cFailVerificationExprParserRuleCall_3_1_0 = (RuleCall)cFailAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cTimeoutKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cTimeoutAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cTimeoutVerificationExprParserRuleCall_4_1_0 = (RuleCall)cTimeoutAssignment_4_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cDidFailAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cDidFailElseTypeEnumRuleCall_6_0 = (RuleCall)cDidFailAssignment_6.eContents().get(0);
		private final Assignment cMetricsAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cMetricsMetricsParserRuleCall_7_0 = (RuleCall)cMetricsAssignment_7.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//ElseResult:
		//	"else" first+=VerificationExpr+ ("error" error+=VerificationExpr+)? ("fail" fail+=VerificationExpr+)? ("timeout"
		//	timeout+=VerificationExpr+)? "[" didFail=ElseType? metrics=Metrics "]";
		@Override public ParserRule getRule() { return rule; }

		//"else" first+=VerificationExpr+ ("error" error+=VerificationExpr+)? ("fail" fail+=VerificationExpr+)? ("timeout"
		//timeout+=VerificationExpr+)? "[" didFail=ElseType? metrics=Metrics "]"
		public Group getGroup() { return cGroup; }

		//"else"
		public Keyword getElseKeyword_0() { return cElseKeyword_0; }

		//first+=VerificationExpr+
		public Assignment getFirstAssignment_1() { return cFirstAssignment_1; }

		//VerificationExpr
		public RuleCall getFirstVerificationExprParserRuleCall_1_0() { return cFirstVerificationExprParserRuleCall_1_0; }

		//("error" error+=VerificationExpr+)?
		public Group getGroup_2() { return cGroup_2; }

		//"error"
		public Keyword getErrorKeyword_2_0() { return cErrorKeyword_2_0; }

		//error+=VerificationExpr+
		public Assignment getErrorAssignment_2_1() { return cErrorAssignment_2_1; }

		//VerificationExpr
		public RuleCall getErrorVerificationExprParserRuleCall_2_1_0() { return cErrorVerificationExprParserRuleCall_2_1_0; }

		//("fail" fail+=VerificationExpr+)?
		public Group getGroup_3() { return cGroup_3; }

		//"fail"
		public Keyword getFailKeyword_3_0() { return cFailKeyword_3_0; }

		//fail+=VerificationExpr+
		public Assignment getFailAssignment_3_1() { return cFailAssignment_3_1; }

		//VerificationExpr
		public RuleCall getFailVerificationExprParserRuleCall_3_1_0() { return cFailVerificationExprParserRuleCall_3_1_0; }

		//("timeout" timeout+=VerificationExpr+)?
		public Group getGroup_4() { return cGroup_4; }

		//"timeout"
		public Keyword getTimeoutKeyword_4_0() { return cTimeoutKeyword_4_0; }

		//timeout+=VerificationExpr+
		public Assignment getTimeoutAssignment_4_1() { return cTimeoutAssignment_4_1; }

		//VerificationExpr
		public RuleCall getTimeoutVerificationExprParserRuleCall_4_1_0() { return cTimeoutVerificationExprParserRuleCall_4_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_5() { return cLeftSquareBracketKeyword_5; }

		//didFail=ElseType?
		public Assignment getDidFailAssignment_6() { return cDidFailAssignment_6; }

		//ElseType
		public RuleCall getDidFailElseTypeEnumRuleCall_6_0() { return cDidFailElseTypeEnumRuleCall_6_0; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_7() { return cMetricsAssignment_7; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_7_0() { return cMetricsMetricsParserRuleCall_7_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class ThenResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ThenResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cThenKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cFirstAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cFirstVerificationExprParserRuleCall_1_0 = (RuleCall)cFirstAssignment_1.eContents().get(0);
		private final Keyword cDoKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cSecondAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cSecondVerificationExprParserRuleCall_3_0 = (RuleCall)cSecondAssignment_3.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cDidThenFailAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final Keyword cDidThenFailThenfailedKeyword_5_0 = (Keyword)cDidThenFailAssignment_5.eContents().get(0);
		private final Assignment cMetricsAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cMetricsMetricsParserRuleCall_6_0 = (RuleCall)cMetricsAssignment_6.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//ThenResult:
		//	"then" first+=VerificationExpr+ "do" second+=VerificationExpr+ "[" didThenFail?="thenfailed"? metrics=Metrics "]";
		@Override public ParserRule getRule() { return rule; }

		//"then" first+=VerificationExpr+ "do" second+=VerificationExpr+ "[" didThenFail?="thenfailed"? metrics=Metrics "]"
		public Group getGroup() { return cGroup; }

		//"then"
		public Keyword getThenKeyword_0() { return cThenKeyword_0; }

		//first+=VerificationExpr+
		public Assignment getFirstAssignment_1() { return cFirstAssignment_1; }

		//VerificationExpr
		public RuleCall getFirstVerificationExprParserRuleCall_1_0() { return cFirstVerificationExprParserRuleCall_1_0; }

		//"do"
		public Keyword getDoKeyword_2() { return cDoKeyword_2; }

		//second+=VerificationExpr+
		public Assignment getSecondAssignment_3() { return cSecondAssignment_3; }

		//VerificationExpr
		public RuleCall getSecondVerificationExprParserRuleCall_3_0() { return cSecondVerificationExprParserRuleCall_3_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//didThenFail?="thenfailed"?
		public Assignment getDidThenFailAssignment_5() { return cDidThenFailAssignment_5; }

		//"thenfailed"
		public Keyword getDidThenFailThenfailedKeyword_5_0() { return cDidThenFailThenfailedKeyword_5_0; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_6() { return cMetricsAssignment_6; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_6_0() { return cMetricsMetricsParserRuleCall_6_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_7() { return cRightSquareBracketKeyword_7; }
	}

	public class MetricsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Metrics");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMetricsAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cTbdcountKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTbdCountAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTbdCountINTTerminalRuleCall_1_1_0 = (RuleCall)cTbdCountAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cSuccesscountKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSuccessCountAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cSuccessCountINTTerminalRuleCall_2_1_0 = (RuleCall)cSuccessCountAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFailcountKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cFailCountAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cFailCountINTTerminalRuleCall_3_1_0 = (RuleCall)cFailCountAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cTimeoutcountKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cTimeoutCountAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cTimeoutCountINTTerminalRuleCall_4_1_0 = (RuleCall)cTimeoutCountAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cErrorcountKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cErrorCountAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cErrorCountINTTerminalRuleCall_5_1_0 = (RuleCall)cErrorCountAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cDidelsecountKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cDidelseCountAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cDidelseCountINTTerminalRuleCall_6_1_0 = (RuleCall)cDidelseCountAssignment_6_1.eContents().get(0);
		private final Group cGroup_7 = (Group)cGroup.eContents().get(7);
		private final Keyword cThenskipcountKeyword_7_0 = (Keyword)cGroup_7.eContents().get(0);
		private final Assignment cThenskipCountAssignment_7_1 = (Assignment)cGroup_7.eContents().get(1);
		private final RuleCall cThenskipCountINTTerminalRuleCall_7_1_0 = (RuleCall)cThenskipCountAssignment_7_1.eContents().get(0);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cPrefailcountKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Assignment cPreconditionfailCountAssignment_8_1 = (Assignment)cGroup_8.eContents().get(1);
		private final RuleCall cPreconditionfailCountINTTerminalRuleCall_8_1_0 = (RuleCall)cPreconditionfailCountAssignment_8_1.eContents().get(0);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cValidfailcountKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cValidationfailCountAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final RuleCall cValidationfailCountINTTerminalRuleCall_9_1_0 = (RuleCall)cValidationfailCountAssignment_9_1.eContents().get(0);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cWeightKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Assignment cWeightAssignment_10_1 = (Assignment)cGroup_10.eContents().get(1);
		private final RuleCall cWeightINTTerminalRuleCall_10_1_0 = (RuleCall)cWeightAssignment_10_1.eContents().get(0);
		
		//Metrics:
		//	{Metrics} ("tbdcount" tbdCount=INT)? ("successcount" successCount=INT)? ("failcount" failCount=INT)? ("timeoutcount"
		//	timeoutCount=INT)? ("errorcount" errorCount=INT)? ("didelsecount" didelseCount=INT)? // else branch executed
		//	("thenskipcount" thenskipCount=INT)? ("prefailcount" preconditionfailCount=INT)? ("validfailcount"
		//	validationfailCount=INT)? ("weight" weight=INT)?;
		@Override public ParserRule getRule() { return rule; }

		//{Metrics} ("tbdcount" tbdCount=INT)? ("successcount" successCount=INT)? ("failcount" failCount=INT)? ("timeoutcount"
		//timeoutCount=INT)? ("errorcount" errorCount=INT)? ("didelsecount" didelseCount=INT)? // else branch executed
		//("thenskipcount" thenskipCount=INT)? ("prefailcount" preconditionfailCount=INT)? ("validfailcount"
		//validationfailCount=INT)? ("weight" weight=INT)?
		public Group getGroup() { return cGroup; }

		//{Metrics}
		public Action getMetricsAction_0() { return cMetricsAction_0; }

		//("tbdcount" tbdCount=INT)?
		public Group getGroup_1() { return cGroup_1; }

		//"tbdcount"
		public Keyword getTbdcountKeyword_1_0() { return cTbdcountKeyword_1_0; }

		//tbdCount=INT
		public Assignment getTbdCountAssignment_1_1() { return cTbdCountAssignment_1_1; }

		//INT
		public RuleCall getTbdCountINTTerminalRuleCall_1_1_0() { return cTbdCountINTTerminalRuleCall_1_1_0; }

		//("successcount" successCount=INT)?
		public Group getGroup_2() { return cGroup_2; }

		//"successcount"
		public Keyword getSuccesscountKeyword_2_0() { return cSuccesscountKeyword_2_0; }

		//successCount=INT
		public Assignment getSuccessCountAssignment_2_1() { return cSuccessCountAssignment_2_1; }

		//INT
		public RuleCall getSuccessCountINTTerminalRuleCall_2_1_0() { return cSuccessCountINTTerminalRuleCall_2_1_0; }

		//("failcount" failCount=INT)?
		public Group getGroup_3() { return cGroup_3; }

		//"failcount"
		public Keyword getFailcountKeyword_3_0() { return cFailcountKeyword_3_0; }

		//failCount=INT
		public Assignment getFailCountAssignment_3_1() { return cFailCountAssignment_3_1; }

		//INT
		public RuleCall getFailCountINTTerminalRuleCall_3_1_0() { return cFailCountINTTerminalRuleCall_3_1_0; }

		//("timeoutcount" timeoutCount=INT)?
		public Group getGroup_4() { return cGroup_4; }

		//"timeoutcount"
		public Keyword getTimeoutcountKeyword_4_0() { return cTimeoutcountKeyword_4_0; }

		//timeoutCount=INT
		public Assignment getTimeoutCountAssignment_4_1() { return cTimeoutCountAssignment_4_1; }

		//INT
		public RuleCall getTimeoutCountINTTerminalRuleCall_4_1_0() { return cTimeoutCountINTTerminalRuleCall_4_1_0; }

		//("errorcount" errorCount=INT)?
		public Group getGroup_5() { return cGroup_5; }

		//"errorcount"
		public Keyword getErrorcountKeyword_5_0() { return cErrorcountKeyword_5_0; }

		//errorCount=INT
		public Assignment getErrorCountAssignment_5_1() { return cErrorCountAssignment_5_1; }

		//INT
		public RuleCall getErrorCountINTTerminalRuleCall_5_1_0() { return cErrorCountINTTerminalRuleCall_5_1_0; }

		//("didelsecount" didelseCount=INT)?
		public Group getGroup_6() { return cGroup_6; }

		//"didelsecount"
		public Keyword getDidelsecountKeyword_6_0() { return cDidelsecountKeyword_6_0; }

		//didelseCount=INT
		public Assignment getDidelseCountAssignment_6_1() { return cDidelseCountAssignment_6_1; }

		//INT
		public RuleCall getDidelseCountINTTerminalRuleCall_6_1_0() { return cDidelseCountINTTerminalRuleCall_6_1_0; }

		//("thenskipcount" thenskipCount=INT)?
		public Group getGroup_7() { return cGroup_7; }

		//"thenskipcount"
		public Keyword getThenskipcountKeyword_7_0() { return cThenskipcountKeyword_7_0; }

		//thenskipCount=INT
		public Assignment getThenskipCountAssignment_7_1() { return cThenskipCountAssignment_7_1; }

		//INT
		public RuleCall getThenskipCountINTTerminalRuleCall_7_1_0() { return cThenskipCountINTTerminalRuleCall_7_1_0; }

		//("prefailcount" preconditionfailCount=INT)?
		public Group getGroup_8() { return cGroup_8; }

		//"prefailcount"
		public Keyword getPrefailcountKeyword_8_0() { return cPrefailcountKeyword_8_0; }

		//preconditionfailCount=INT
		public Assignment getPreconditionfailCountAssignment_8_1() { return cPreconditionfailCountAssignment_8_1; }

		//INT
		public RuleCall getPreconditionfailCountINTTerminalRuleCall_8_1_0() { return cPreconditionfailCountINTTerminalRuleCall_8_1_0; }

		//("validfailcount" validationfailCount=INT)?
		public Group getGroup_9() { return cGroup_9; }

		//"validfailcount"
		public Keyword getValidfailcountKeyword_9_0() { return cValidfailcountKeyword_9_0; }

		//validationfailCount=INT
		public Assignment getValidationfailCountAssignment_9_1() { return cValidationfailCountAssignment_9_1; }

		//INT
		public RuleCall getValidationfailCountINTTerminalRuleCall_9_1_0() { return cValidationfailCountINTTerminalRuleCall_9_1_0; }

		//("weight" weight=INT)?
		public Group getGroup_10() { return cGroup_10; }

		//"weight"
		public Keyword getWeightKeyword_10_0() { return cWeightKeyword_10_0; }

		//weight=INT
		public Assignment getWeightAssignment_10_1() { return cWeightAssignment_10_1; }

		//INT
		public RuleCall getWeightINTTerminalRuleCall_10_1_0() { return cWeightINTTerminalRuleCall_10_1_0; }
	}
	
	
	public class ElseTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "ElseType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cOKEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cOKOkKeyword_0_0 = (Keyword)cOKEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cFAILEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cFAILFailKeyword_1_0 = (Keyword)cFAILEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cTIMEOUTEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cTIMEOUTTimeoutKeyword_2_0 = (Keyword)cTIMEOUTEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cERROREnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cERRORErrorKeyword_3_0 = (Keyword)cERROREnumLiteralDeclaration_3.eContents().get(0);
		
		//enum ElseType:
		//	OK="ok" | FAIL="fail" | TIMEOUT="timeout" | ERROR="error";
		public EnumRule getRule() { return rule; }

		//OK="ok" | FAIL="fail" | TIMEOUT="timeout" | ERROR="error"
		public Alternatives getAlternatives() { return cAlternatives; }

		//OK="ok"
		public EnumLiteralDeclaration getOKEnumLiteralDeclaration_0() { return cOKEnumLiteralDeclaration_0; }

		//"ok"
		public Keyword getOKOkKeyword_0_0() { return cOKOkKeyword_0_0; }

		//FAIL="fail"
		public EnumLiteralDeclaration getFAILEnumLiteralDeclaration_1() { return cFAILEnumLiteralDeclaration_1; }

		//"fail"
		public Keyword getFAILFailKeyword_1_0() { return cFAILFailKeyword_1_0; }

		//TIMEOUT="timeout"
		public EnumLiteralDeclaration getTIMEOUTEnumLiteralDeclaration_2() { return cTIMEOUTEnumLiteralDeclaration_2; }

		//"timeout"
		public Keyword getTIMEOUTTimeoutKeyword_2_0() { return cTIMEOUTTimeoutKeyword_2_0; }

		//ERROR="error"
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_3() { return cERROREnumLiteralDeclaration_3; }

		//"error"
		public Keyword getERRORErrorKeyword_3_0() { return cERRORErrorKeyword_3_0; }
	}

	public class VerificationResultStateElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationResultState");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cTBDEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cTBDTbdKeyword_0_0 = (Keyword)cTBDEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cSUCCESSEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cSUCCESSSuccessKeyword_1_0 = (Keyword)cSUCCESSEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cFAILEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cFAILFailKeyword_2_0 = (Keyword)cFAILEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cERROREnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cERRORErrorKeyword_3_0 = (Keyword)cERROREnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cTIMEOUTEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cTIMEOUTTimeoutKeyword_4_0 = (Keyword)cTIMEOUTEnumLiteralDeclaration_4.eContents().get(0);
		
		//enum VerificationResultState:
		//	TBD="tbd" | SUCCESS="success" | FAIL="fail" | ERROR="error" | TIMEOUT="timeout";
		public EnumRule getRule() { return rule; }

		//TBD="tbd" | SUCCESS="success" | FAIL="fail" | ERROR="error" | TIMEOUT="timeout"
		public Alternatives getAlternatives() { return cAlternatives; }

		//TBD="tbd"
		public EnumLiteralDeclaration getTBDEnumLiteralDeclaration_0() { return cTBDEnumLiteralDeclaration_0; }

		//"tbd"
		public Keyword getTBDTbdKeyword_0_0() { return cTBDTbdKeyword_0_0; }

		//SUCCESS="success"
		public EnumLiteralDeclaration getSUCCESSEnumLiteralDeclaration_1() { return cSUCCESSEnumLiteralDeclaration_1; }

		//"success"
		public Keyword getSUCCESSSuccessKeyword_1_0() { return cSUCCESSSuccessKeyword_1_0; }

		//FAIL="fail"
		public EnumLiteralDeclaration getFAILEnumLiteralDeclaration_2() { return cFAILEnumLiteralDeclaration_2; }

		//"fail"
		public Keyword getFAILFailKeyword_2_0() { return cFAILFailKeyword_2_0; }

		//ERROR="error"
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_3() { return cERROREnumLiteralDeclaration_3; }

		//"error"
		public Keyword getERRORErrorKeyword_3_0() { return cERRORErrorKeyword_3_0; }

		//TIMEOUT="timeout"
		public EnumLiteralDeclaration getTIMEOUTEnumLiteralDeclaration_4() { return cTIMEOUTEnumLiteralDeclaration_4; }

		//"timeout"
		public Keyword getTIMEOUTTimeoutKeyword_4_0() { return cTIMEOUTTimeoutKeyword_4_0; }
	}

	public class VerificationExecutionStateElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationExecutionState");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cTODOEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cTODOTodoKeyword_0_0 = (Keyword)cTODOEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cRUNNINGEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cRUNNINGRunningKeyword_1_0 = (Keyword)cRUNNINGEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cREDOEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cREDORedoKeyword_2_0 = (Keyword)cREDOEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cCOMPLETEDEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cCOMPLETEDCompletedKeyword_3_0 = (Keyword)cCOMPLETEDEnumLiteralDeclaration_3.eContents().get(0);
		
		//enum VerificationExecutionState:
		//	TODO= // verification to be performed
		//	"todo" | RUNNING= // verification in progress (background processing)
		//	"running" | REDO= // invalidated while in progress. redo verification.
		//	"redo" | COMPLETED= // completed. verification result is valid
		//	"completed";
		public EnumRule getRule() { return rule; }

		//TODO= // verification to be performed
		//"todo" | RUNNING= // verification in progress (background processing)
		//"running" | REDO= // invalidated while in progress. redo verification.
		//"redo" | COMPLETED= // completed. verification result is valid
		//"completed"
		public Alternatives getAlternatives() { return cAlternatives; }

		//TODO= // verification to be performed
		//"todo"
		public EnumLiteralDeclaration getTODOEnumLiteralDeclaration_0() { return cTODOEnumLiteralDeclaration_0; }

		//// verification to be performed
		//"todo"
		public Keyword getTODOTodoKeyword_0_0() { return cTODOTodoKeyword_0_0; }

		//RUNNING= // verification in progress (background processing)
		//"running"
		public EnumLiteralDeclaration getRUNNINGEnumLiteralDeclaration_1() { return cRUNNINGEnumLiteralDeclaration_1; }

		//// verification in progress (background processing)
		//"running"
		public Keyword getRUNNINGRunningKeyword_1_0() { return cRUNNINGRunningKeyword_1_0; }

		//REDO= // invalidated while in progress. redo verification.
		//"redo"
		public EnumLiteralDeclaration getREDOEnumLiteralDeclaration_2() { return cREDOEnumLiteralDeclaration_2; }

		//// invalidated while in progress. redo verification.
		//"redo"
		public Keyword getREDORedoKeyword_2_0() { return cREDORedoKeyword_2_0; }

		//COMPLETED= // completed. verification result is valid
		//"completed"
		public EnumLiteralDeclaration getCOMPLETEDEnumLiteralDeclaration_3() { return cCOMPLETEDEnumLiteralDeclaration_3; }

		//// completed. verification result is valid
		//"completed"
		public Keyword getCOMPLETEDCompletedKeyword_3_0() { return cCOMPLETEDCompletedKeyword_3_0; }
	}
	
	private final AssuranceCaseElements pAssuranceCase;
	private final ClaimResultElements pClaimResult;
	private final PreconditionResultElements pPreconditionResult;
	private final ValidationResultElements pValidationResult;
	private final VerificationActivityResultElements pVerificationActivityResult;
	private final AssureResultElements pAssureResult;
	private final ElseTypeElements unknownRuleElseType;
	private final VerificationExprElements pVerificationExpr;
	private final ElseResultElements pElseResult;
	private final ThenResultElements pThenResult;
	private final MetricsElements pMetrics;
	private final VerificationResultStateElements unknownRuleVerificationResultState;
	private final VerificationExecutionStateElements unknownRuleVerificationExecutionState;
	
	private final Grammar grammar;

	private final CommonGrammarAccess gaCommon;

	@Inject
	public AssureGrammarAccess(GrammarProvider grammarProvider,
		CommonGrammarAccess gaCommon) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCommon = gaCommon;
		this.pAssuranceCase = new AssuranceCaseElements();
		this.pClaimResult = new ClaimResultElements();
		this.pPreconditionResult = new PreconditionResultElements();
		this.pValidationResult = new ValidationResultElements();
		this.pVerificationActivityResult = new VerificationActivityResultElements();
		this.pAssureResult = new AssureResultElements();
		this.unknownRuleElseType = new ElseTypeElements();
		this.pVerificationExpr = new VerificationExprElements();
		this.pElseResult = new ElseResultElements();
		this.pThenResult = new ThenResultElements();
		this.pMetrics = new MetricsElements();
		this.unknownRuleVerificationResultState = new VerificationResultStateElements();
		this.unknownRuleVerificationExecutionState = new VerificationExecutionStateElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.assure.Assure".equals(grammar.getName())) {
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
	

	public CommonGrammarAccess getCommonGrammarAccess() {
		return gaCommon;
	}

	
	//// result for a system in the architecture hierarchy
	//AssuranceCase:
	//	"case" name=QualifiedName ("for" target=[Alisa::AssurancePlan|QualifiedName])? ("system" targetSystem=ID)? "["
	//	metrics=Metrics ("message" message=STRING)? claimResult+=ClaimResult* subAssuranceCase+=AssuranceCase* "]";
	public AssuranceCaseElements getAssuranceCaseAccess() {
		return pAssuranceCase;
	}
	
	public ParserRule getAssuranceCaseRule() {
		return getAssuranceCaseAccess().getRule();
	}

	//// Result of meeting a requirement
	//ClaimResult:
	//	"claim" target=[ReqSpec::Requirement|QualifiedName] "[" metrics=Metrics ("message" message=STRING)?
	//	subClaimResult+=ClaimResult* verificationActivityResult+=VerificationExpr* "]";
	public ClaimResultElements getClaimResultAccess() {
		return pClaimResult;
	}
	
	public ParserRule getClaimResultRule() {
		return getClaimResultAccess().getRule();
	}

	//PreconditionResult returns VerificationResult:
	//	"precondition" {PreconditionResult} target=[Verify::VerificationMethod|QualifiedName] "[" "executionstate"
	//	executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
	//	issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? // pointer to separate report
	//	metrics=Metrics ("message" message=STRING)? "]";
	public PreconditionResultElements getPreconditionResultAccess() {
		return pPreconditionResult;
	}
	
	public ParserRule getPreconditionResultRule() {
		return getPreconditionResultAccess().getRule();
	}

	//ValidationResult returns VerificationResult:
	//	"validation" {ValidationResult} target=[Verify::VerificationMethod|QualifiedName] "[" "executionstate"
	//	executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
	//	issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? // pointer to separate report
	//	metrics=Metrics ("message" message=STRING)? "]";
	public ValidationResultElements getValidationResultAccess() {
		return pValidationResult;
	}
	
	public ParserRule getValidationResultRule() {
		return getValidationResultAccess().getRule();
	}

	//// result of executing a verification activity
	//VerificationActivityResult returns VerificationResult:
	//	"verification" {VerificationActivityResult} target=[Verify::VerificationActivity|QualifiedName] "[" "executionstate"
	//	executionState=VerificationExecutionState "resultstate" resultState=VerificationResultState ("issues" "["
	//	issues+=ResultIssue* "]")? ("report" resultReport=[results::ResultReport|QualifiedName])? metrics=Metrics ("message"
	//	message=STRING)? preconditionResult=PreconditionResult? validationResult=ValidationResult? "]";
	public VerificationActivityResultElements getVerificationActivityResultAccess() {
		return pVerificationActivityResult;
	}
	
	public ParserRule getVerificationActivityResultRule() {
		return getVerificationActivityResultAccess().getRule();
	}

	//AssureResult:
	//	VerificationExpr | AssuranceCase | ClaimResult | PreconditionResult | ValidationResult;
	public AssureResultElements getAssureResultAccess() {
		return pAssureResult;
	}
	
	public ParserRule getAssureResultRule() {
		return getAssureResultAccess().getRule();
	}

	//enum ElseType:
	//	OK="ok" | FAIL="fail" | TIMEOUT="timeout" | ERROR="error";
	public ElseTypeElements getElseTypeAccess() {
		return unknownRuleElseType;
	}
	
	public EnumRule getElseTypeRule() {
		return getElseTypeAccess().getRule();
	}

	//VerificationExpr:
	//	VerificationActivityResult | ElseResult | ThenResult;
	public VerificationExprElements getVerificationExprAccess() {
		return pVerificationExpr;
	}
	
	public ParserRule getVerificationExprRule() {
		return getVerificationExprAccess().getRule();
	}

	//ElseResult:
	//	"else" first+=VerificationExpr+ ("error" error+=VerificationExpr+)? ("fail" fail+=VerificationExpr+)? ("timeout"
	//	timeout+=VerificationExpr+)? "[" didFail=ElseType? metrics=Metrics "]";
	public ElseResultElements getElseResultAccess() {
		return pElseResult;
	}
	
	public ParserRule getElseResultRule() {
		return getElseResultAccess().getRule();
	}

	//ThenResult:
	//	"then" first+=VerificationExpr+ "do" second+=VerificationExpr+ "[" didThenFail?="thenfailed"? metrics=Metrics "]";
	public ThenResultElements getThenResultAccess() {
		return pThenResult;
	}
	
	public ParserRule getThenResultRule() {
		return getThenResultAccess().getRule();
	}

	//Metrics:
	//	{Metrics} ("tbdcount" tbdCount=INT)? ("successcount" successCount=INT)? ("failcount" failCount=INT)? ("timeoutcount"
	//	timeoutCount=INT)? ("errorcount" errorCount=INT)? ("didelsecount" didelseCount=INT)? // else branch executed
	//	("thenskipcount" thenskipCount=INT)? ("prefailcount" preconditionfailCount=INT)? ("validfailcount"
	//	validationfailCount=INT)? ("weight" weight=INT)?;
	public MetricsElements getMetricsAccess() {
		return pMetrics;
	}
	
	public ParserRule getMetricsRule() {
		return getMetricsAccess().getRule();
	}

	//enum VerificationResultState:
	//	TBD="tbd" | SUCCESS="success" | FAIL="fail" | ERROR="error" | TIMEOUT="timeout";
	public VerificationResultStateElements getVerificationResultStateAccess() {
		return unknownRuleVerificationResultState;
	}
	
	public EnumRule getVerificationResultStateRule() {
		return getVerificationResultStateAccess().getRule();
	}

	//enum VerificationExecutionState:
	//	TODO= // verification to be performed
	//	"todo" | RUNNING= // verification in progress (background processing)
	//	"running" | REDO= // invalidated while in progress. redo verification.
	//	"redo" | COMPLETED= // completed. verification result is valid
	//	"completed";
	public VerificationExecutionStateElements getVerificationExecutionStateAccess() {
		return unknownRuleVerificationExecutionState;
	}
	
	public EnumRule getVerificationExecutionStateRule() {
		return getVerificationExecutionStateAccess().getRule();
	}

	//Description:
	//	"description" description+=DescriptionElement+;
	public CommonGrammarAccess.DescriptionElements getDescriptionAccess() {
		return gaCommon.getDescriptionAccess();
	}
	
	public ParserRule getDescriptionRule() {
		return getDescriptionAccess().getRule();
	}

	//DescriptionElement:
	//	text=STRING | showValue=ShowValue | thisTarget?="this" | image=ImageReference;
	public CommonGrammarAccess.DescriptionElementElements getDescriptionElementAccess() {
		return gaCommon.getDescriptionElementAccess();
	}
	
	public ParserRule getDescriptionElementRule() {
		return getDescriptionElementAccess().getRule();
	}

	//Rationale:
	//	"rationale" text=STRING;
	public CommonGrammarAccess.RationaleElements getRationaleAccess() {
		return gaCommon.getRationaleAccess();
	}
	
	public ParserRule getRationaleRule() {
		return getRationaleAccess().getRule();
	}

	//Uncertainty:
	//	"uncertainty" "[" ("importance" importance=INT & "difficulty" difficulty=INT) "]";
	public CommonGrammarAccess.UncertaintyElements getUncertaintyAccess() {
		return gaCommon.getUncertaintyAccess();
	}
	
	public ParserRule getUncertaintyRule() {
		return getUncertaintyAccess().getRule();
	}

	//// This is similar to diagnostics
	//ResultIssue:
	//	"issue" issueType=ResultIssueType message=STRING ("target" target=[ecore::EObject|URIID])? ("exception"
	//	exceptionType=STRING)? ("[" issues+=ResultIssue* "]")?;
	public CommonGrammarAccess.ResultIssueElements getResultIssueAccess() {
		return gaCommon.getResultIssueAccess();
	}
	
	public ParserRule getResultIssueRule() {
		return getResultIssueAccess().getRule();
	}

	//enum ResultIssueType:
	//	TBD="tbd" | UNKNOWN="unknown" | ERROR="error" | WARNING="warning" | INFO="info" | SUCCESS="success" | FAIL="fail";
	public CommonGrammarAccess.ResultIssueTypeElements getResultIssueTypeAccess() {
		return gaCommon.getResultIssueTypeAccess();
	}
	
	public EnumRule getResultIssueTypeRule() {
		return getResultIssueTypeAccess().getRule();
	}

	//ValDeclaration returns AVariableDeclaration:
	//	{ValDeclaration} "val" (=> (type=ID name=ID) | name=ID) "=" right=AExpression;
	public CommonGrammarAccess.ValDeclarationElements getValDeclarationAccess() {
		return gaCommon.getValDeclarationAccess();
	}
	
	public ParserRule getValDeclarationRule() {
		return getValDeclarationAccess().getRule();
	}

	//ComputeDeclaration returns AVariableDeclaration:
	//	{ComputeDeclaration} "compute" (=> (type=ID name=ID) | name=ID);
	public CommonGrammarAccess.ComputeDeclarationElements getComputeDeclarationAccess() {
		return gaCommon.getComputeDeclarationAccess();
	}
	
	public ParserRule getComputeDeclarationRule() {
		return getComputeDeclarationAccess().getRule();
	}

	//APropertyReference returns AExpression:
	//	{APropertyReference} "@" property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE];
	public CommonGrammarAccess.APropertyReferenceElements getAPropertyReferenceAccess() {
		return gaCommon.getAPropertyReferenceAccess();
	}
	
	public ParserRule getAPropertyReferenceRule() {
		return getAPropertyReferenceAccess().getRule();
	}

	//AVariableReference returns AExpression:
	//	{AVariableReference} variable=[AVariableDeclaration];
	public CommonGrammarAccess.AVariableReferenceElements getAVariableReferenceAccess() {
		return gaCommon.getAVariableReferenceAccess();
	}
	
	public ParserRule getAVariableReferenceRule() {
		return getAVariableReferenceAccess().getRule();
	}

	//ShowValue:
	//	ref=[AVariableDeclaration] ("%" unit=[aadl2::UnitLiteral])?;
	public CommonGrammarAccess.ShowValueElements getShowValueAccess() {
		return gaCommon.getShowValueAccess();
	}
	
	public ParserRule getShowValueRule() {
		return getShowValueAccess().getRule();
	}

	//ImageReference:
	//	"img" imgfile=IMGREF;
	public CommonGrammarAccess.ImageReferenceElements getImageReferenceAccess() {
		return gaCommon.getImageReferenceAccess();
	}
	
	public ParserRule getImageReferenceRule() {
		return getImageReferenceAccess().getRule();
	}

	//IMGREF:
	//	(ID "/")* ID "." ID;
	public CommonGrammarAccess.IMGREFElements getIMGREFAccess() {
		return gaCommon.getIMGREFAccess();
	}
	
	public ParserRule getIMGREFRule() {
		return getIMGREFAccess().getRule();
	}

	//// Expressions
	//AExpression returns aadl2::PropertyExpression:
	//	AOrExpression;
	public CommonGrammarAccess.AExpressionElements getAExpressionAccess() {
		return gaCommon.getAExpressionAccess();
	}
	
	public ParserRule getAExpressionRule() {
		return getAExpressionAccess().getRule();
	}

	//AOrExpression returns aadl2::PropertyExpression:
	//	AAndExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOr) rightOperand=AAndExpression)*;
	public CommonGrammarAccess.AOrExpressionElements getAOrExpressionAccess() {
		return gaCommon.getAOrExpressionAccess();
	}
	
	public ParserRule getAOrExpressionRule() {
		return getAOrExpressionAccess().getRule();
	}

	//OpOr:
	//	"||";
	public CommonGrammarAccess.OpOrElements getOpOrAccess() {
		return gaCommon.getOpOrAccess();
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}

	//AAndExpression returns aadl2::PropertyExpression:
	//	AEqualityExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAnd) rightOperand=AEqualityExpression)*;
	public CommonGrammarAccess.AAndExpressionElements getAAndExpressionAccess() {
		return gaCommon.getAAndExpressionAccess();
	}
	
	public ParserRule getAAndExpressionRule() {
		return getAAndExpressionAccess().getRule();
	}

	//OpAnd:
	//	"&&";
	public CommonGrammarAccess.OpAndElements getOpAndAccess() {
		return gaCommon.getOpAndAccess();
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}

	//AEqualityExpression returns aadl2::PropertyExpression:
	//	ARelationalExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpEquality)
	//	rightOperand=ARelationalExpression)*;
	public CommonGrammarAccess.AEqualityExpressionElements getAEqualityExpressionAccess() {
		return gaCommon.getAEqualityExpressionAccess();
	}
	
	public ParserRule getAEqualityExpressionRule() {
		return getAEqualityExpressionAccess().getRule();
	}

	//OpEquality:
	//	"==" | "!=";
	public CommonGrammarAccess.OpEqualityElements getOpEqualityAccess() {
		return gaCommon.getOpEqualityAccess();
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}

	//ARelationalExpression returns aadl2::PropertyExpression:
	//	AOtherOperatorExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpCompare)
	//	rightOperand=AOtherOperatorExpression)*;
	public CommonGrammarAccess.ARelationalExpressionElements getARelationalExpressionAccess() {
		return gaCommon.getARelationalExpressionAccess();
	}
	
	public ParserRule getARelationalExpressionRule() {
		return getARelationalExpressionAccess().getRule();
	}

	//OpCompare:
	//	">=" | "<" "=" | ">" | "<";
	public CommonGrammarAccess.OpCompareElements getOpCompareAccess() {
		return gaCommon.getOpCompareAccess();
	}
	
	public ParserRule getOpCompareRule() {
		return getOpCompareAccess().getRule();
	}

	//AOtherOperatorExpression returns aadl2::PropertyExpression:
	//	AAdditiveExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpOther) rightOperand=AAdditiveExpression)*;
	public CommonGrammarAccess.AOtherOperatorExpressionElements getAOtherOperatorExpressionAccess() {
		return gaCommon.getAOtherOperatorExpressionAccess();
	}
	
	public ParserRule getAOtherOperatorExpressionRule() {
		return getAOtherOperatorExpressionAccess().getRule();
	}

	//OpOther:
	//	"->" | "..<" | ">" ".." | ".." | "=>" | ">" (=> (">" ">") | ">") | "<" (=> ("<" "<") | "<" | "=>") | "<>" | "?:";
	public CommonGrammarAccess.OpOtherElements getOpOtherAccess() {
		return gaCommon.getOpOtherAccess();
	}
	
	public ParserRule getOpOtherRule() {
		return getOpOtherAccess().getRule();
	}

	//AAdditiveExpression returns aadl2::PropertyExpression:
	//	AMultiplicativeExpression (=> ({ABinaryOperation.leftOperand=current} feature=OpAdd)
	//	rightOperand=AMultiplicativeExpression)*;
	public CommonGrammarAccess.AAdditiveExpressionElements getAAdditiveExpressionAccess() {
		return gaCommon.getAAdditiveExpressionAccess();
	}
	
	public ParserRule getAAdditiveExpressionRule() {
		return getAAdditiveExpressionAccess().getRule();
	}

	//OpAdd:
	//	"+" | "-";
	public CommonGrammarAccess.OpAddElements getOpAddAccess() {
		return gaCommon.getOpAddAccess();
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}

	//AMultiplicativeExpression returns aadl2::PropertyExpression:
	//	AUnaryOperation (=> ({ABinaryOperation.leftOperand=current} feature=OpMulti) rightOperand=AUnaryOperation)*;
	public CommonGrammarAccess.AMultiplicativeExpressionElements getAMultiplicativeExpressionAccess() {
		return gaCommon.getAMultiplicativeExpressionAccess();
	}
	
	public ParserRule getAMultiplicativeExpressionRule() {
		return getAMultiplicativeExpressionAccess().getRule();
	}

	//OpMulti:
	//	"*" | "**" | "/" | "%";
	public CommonGrammarAccess.OpMultiElements getOpMultiAccess() {
		return gaCommon.getOpMultiAccess();
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}

	//AUnaryOperation returns aadl2::PropertyExpression:
	//	{AUnaryOperation} feature=OpUnary operand=AUnaryOperation | APrimaryExpression;
	public CommonGrammarAccess.AUnaryOperationElements getAUnaryOperationAccess() {
		return gaCommon.getAUnaryOperationAccess();
	}
	
	public ParserRule getAUnaryOperationRule() {
		return getAUnaryOperationAccess().getRule();
	}

	//OpUnary:
	//	"!" | "-" | "+";
	public CommonGrammarAccess.OpUnaryElements getOpUnaryAccess() {
		return gaCommon.getOpUnaryAccess();
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}

	//APrimaryExpression returns aadl2::PropertyExpression:
	//	ALiteral | AVariableReference | APropertyReference | AParenthesizedExpression;
	public CommonGrammarAccess.APrimaryExpressionElements getAPrimaryExpressionAccess() {
		return gaCommon.getAPrimaryExpressionAccess();
	}
	
	public ParserRule getAPrimaryExpressionRule() {
		return getAPrimaryExpressionAccess().getRule();
	}

	//ALiteral returns aadl2::PropertyExpression:
	//	ASetTerm | AListTerm | ABooleanLiteral | ARealTerm | AIntegerTerm | ANullLiteral | StringTerm;
	public CommonGrammarAccess.ALiteralElements getALiteralAccess() {
		return gaCommon.getALiteralAccess();
	}
	
	public ParserRule getALiteralRule() {
		return getALiteralAccess().getRule();
	}

	//AIntegerTerm returns aadl2::IntegerLiteral:
	//	value=AInt unit=[aadl2::UnitLiteral]?;
	public CommonGrammarAccess.AIntegerTermElements getAIntegerTermAccess() {
		return gaCommon.getAIntegerTermAccess();
	}
	
	public ParserRule getAIntegerTermRule() {
		return getAIntegerTermAccess().getRule();
	}

	//AInt returns aadl2::Integer:
	//	INT;
	public CommonGrammarAccess.AIntElements getAIntAccess() {
		return gaCommon.getAIntAccess();
	}
	
	public ParserRule getAIntRule() {
		return getAIntAccess().getRule();
	}

	//ARealTerm returns aadl2::RealLiteral:
	//	value=AReal unit=[aadl2::UnitLiteral]?;
	public CommonGrammarAccess.ARealTermElements getARealTermAccess() {
		return gaCommon.getARealTermAccess();
	}
	
	public ParserRule getARealTermRule() {
		return getARealTermAccess().getRule();
	}

	//AReal returns aadl2::Real:
	//	REAL_LIT;
	public CommonGrammarAccess.ARealElements getARealAccess() {
		return gaCommon.getARealAccess();
	}
	
	public ParserRule getARealRule() {
		return getARealAccess().getRule();
	}

	//ANumericRangeTerm returns aadl2::RangeValue:
	//	minimum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)  
	//	NumAlt ".." maximum= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt ("delta" delta= //(RealTerm|IntegerTerm| SignedConstant | ConstantValue)
	//	NumAlt)?;
	public CommonGrammarAccess.ANumericRangeTermElements getANumericRangeTermAccess() {
		return gaCommon.getANumericRangeTermAccess();
	}
	
	public ParserRule getANumericRangeTermRule() {
		return getANumericRangeTermAccess().getRule();
	}

	//NumAlt returns aadl2::PropertyExpression:
	//	ARealTerm | AIntegerTerm;
	public CommonGrammarAccess.NumAltElements getNumAltAccess() {
		return gaCommon.getNumAltAccess();
	}
	
	public ParserRule getNumAltRule() {
		return getNumAltAccess().getRule();
	}

	//ASetTerm returns aadl2::PropertyExpression: //	{ASetLiteral} '#' '{' (elements+=AExpression (',' elements+=AExpression )*)? '}'
	//	{ASetLiteral} "{" (elements+=AExpression ("," elements+=AExpression)*)? "}";
	public CommonGrammarAccess.ASetTermElements getASetTermAccess() {
		return gaCommon.getASetTermAccess();
	}
	
	public ParserRule getASetTermRule() {
		return getASetTermAccess().getRule();
	}

	//AListTerm returns aadl2::PropertyExpression:
	//	{AListTerm} "#" "[" (elements+=AExpression ("," elements+=AExpression)*)? "]";
	public CommonGrammarAccess.AListTermElements getAListTermAccess() {
		return gaCommon.getAListTermAccess();
	}
	
	public ParserRule getAListTermRule() {
		return getAListTermAccess().getRule();
	}

	//AParenthesizedExpression returns aadl2::PropertyExpression:
	//	"(" AExpression ")";
	public CommonGrammarAccess.AParenthesizedExpressionElements getAParenthesizedExpressionAccess() {
		return gaCommon.getAParenthesizedExpressionAccess();
	}
	
	public ParserRule getAParenthesizedExpressionRule() {
		return getAParenthesizedExpressionAccess().getRule();
	}

	//ABooleanLiteral returns aadl2::PropertyExpression:
	//	{aadl2::BooleanLiteral} (value?="true" | "false");
	public CommonGrammarAccess.ABooleanLiteralElements getABooleanLiteralAccess() {
		return gaCommon.getABooleanLiteralAccess();
	}
	
	public ParserRule getABooleanLiteralRule() {
		return getABooleanLiteralAccess().getRule();
	}

	//ANullLiteral returns aadl2::PropertyExpression:
	//	{ANullLiteral} "null";
	public CommonGrammarAccess.ANullLiteralElements getANullLiteralAccess() {
		return gaCommon.getANullLiteralAccess();
	}
	
	public ParserRule getANullLiteralRule() {
		return getANullLiteralAccess().getRule();
	}

	//StringTerm returns aadl2::StringLiteral:
	//	value=NoQuoteString;
	public CommonGrammarAccess.StringTermElements getStringTermAccess() {
		return gaCommon.getStringTermAccess();
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}

	//NoQuoteString: // remove quotes from string in ValueConverter
	//	STRING;
	public CommonGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaCommon.getNoQuoteStringAccess();
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}

	//ComponentCategory returns aadl2::ComponentCategory:
	//	"abstract" | "bus" | "data" | "device" | "memory" | "process" | "processor" | "subprogram" | "subprogram" "group" |
	//	"system" | "thread" "group" | "thread" | "virtual" "bus" | "virtual" "processor";
	public CommonGrammarAccess.ComponentCategoryElements getComponentCategoryAccess() {
		return gaCommon.getComponentCategoryAccess();
	}
	
	public ParserRule getComponentCategoryRule() {
		return getComponentCategoryAccess().getRule();
	}

	//terminal fragment EXPONENT:
	//	("e" | "E") ("+" | "-")? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return gaCommon.getEXPONENTRule();
	} 

	//terminal fragment INT_EXPONENT:
	//	("e" | "E") "+"? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return gaCommon.getINT_EXPONENTRule();
	} 

	//terminal REAL_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("." DIGIT+ ("_" DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return gaCommon.getREAL_LITRule();
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
		return gaCommon.getDIGITRule();
	} 

	//terminal fragment EXTENDED_DIGIT:
	//	"0".."9" | "a".."f" | "A".."F";
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaCommon.getEXTENDED_DIGITRule();
	} 

	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ("_"? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return gaCommon.getBASED_INTEGERRule();
	} 

	//// Qualified classifier reference
	//AadlClassifierReference:
	//	ID ("::" ID)+ ("." ID)?;
	public CommonGrammarAccess.AadlClassifierReferenceElements getAadlClassifierReferenceAccess() {
		return gaCommon.getAadlClassifierReferenceAccess();
	}
	
	public ParserRule getAadlClassifierReferenceRule() {
		return getAadlClassifierReferenceAccess().getRule();
	}

	//AADLPROPERTYREFERENCE:
	//	ID ("::" ID)?;
	public CommonGrammarAccess.AADLPROPERTYREFERENCEElements getAADLPROPERTYREFERENCEAccess() {
		return gaCommon.getAADLPROPERTYREFERENCEAccess();
	}
	
	public ParserRule getAADLPROPERTYREFERENCERule() {
		return getAADLPROPERTYREFERENCEAccess().getRule();
	}

	//URIID:
	//	STRING;
	public CommonGrammarAccess.URIIDElements getURIIDAccess() {
		return gaCommon.getURIIDAccess();
	}
	
	public ParserRule getURIIDRule() {
		return getURIIDAccess().getRule();
	}

	////terminal URIID : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9'|'#'|'@'|'/'|':')*;
	//QualifiedName:
	//	ID ("." ID)*;
	public CommonGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaCommon.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaCommon.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaCommon.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaCommon.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaCommon.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaCommon.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaCommon.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaCommon.getANY_OTHERRule();
	} 
}
