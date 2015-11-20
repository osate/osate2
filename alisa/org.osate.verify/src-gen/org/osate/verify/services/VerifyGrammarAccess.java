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
package org.osate.verify.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.osate.alisa.common.services.CommonGrammarAccess;

@Singleton
public class VerifyGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class VerificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Verification");
		private final Assignment cContentsAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cContentsAlternatives_0 = (Alternatives)cContentsAssignment.eContents().get(0);
		private final RuleCall cContentsVerificationPlanParserRuleCall_0_0 = (RuleCall)cContentsAlternatives_0.eContents().get(0);
		private final RuleCall cContentsVerificationMethodRegistryParserRuleCall_0_1 = (RuleCall)cContentsAlternatives_0.eContents().get(1);
		
		//Verification:
		//	contents+=(VerificationPlan | VerificationMethodRegistry)+;
		@Override public ParserRule getRule() { return rule; }

		//contents+=(VerificationPlan | VerificationMethodRegistry)+
		public Assignment getContentsAssignment() { return cContentsAssignment; }

		//VerificationPlan | VerificationMethodRegistry
		public Alternatives getContentsAlternatives_0() { return cContentsAlternatives_0; }

		//VerificationPlan
		public RuleCall getContentsVerificationPlanParserRuleCall_0_0() { return cContentsVerificationPlanParserRuleCall_0_0; }

		//VerificationMethodRegistry
		public RuleCall getContentsVerificationMethodRegistryParserRuleCall_0_1() { return cContentsVerificationMethodRegistryParserRuleCall_0_1; }
	}

	public class VerificationPlanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationPlan");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVerificationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cPlanKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameQualifiedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Keyword cForKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cSystemRequirementsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cSystemRequirementsSystemRequirementsCrossReference_5_0 = (CrossReference)cSystemRequirementsAssignment_5.eContents().get(0);
		private final RuleCall cSystemRequirementsSystemRequirementsQualifiedNameParserRuleCall_5_0_1 = (RuleCall)cSystemRequirementsSystemRequirementsCrossReference_5_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final UnorderedGroup cUnorderedGroup_7 = (UnorderedGroup)cGroup.eContents().get(7);
		private final Assignment cDescriptionAssignment_7_0 = (Assignment)cUnorderedGroup_7.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_7_0_0 = (RuleCall)cDescriptionAssignment_7_0.eContents().get(0);
		private final Assignment cClaimAssignment_7_1 = (Assignment)cUnorderedGroup_7.eContents().get(1);
		private final RuleCall cClaimClaimParserRuleCall_7_1_0 = (RuleCall)cClaimAssignment_7_1.eContents().get(0);
		private final Assignment cRationaleAssignment_7_2 = (Assignment)cUnorderedGroup_7.eContents().get(2);
		private final RuleCall cRationaleRationaleParserRuleCall_7_2_0 = (RuleCall)cRationaleAssignment_7_2.eContents().get(0);
		private final Group cGroup_7_3 = (Group)cUnorderedGroup_7.eContents().get(3);
		private final Keyword cIssuesKeyword_7_3_0 = (Keyword)cGroup_7_3.eContents().get(0);
		private final Assignment cIssuesAssignment_7_3_1 = (Assignment)cGroup_7_3.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_7_3_1_0 = (RuleCall)cIssuesAssignment_7_3_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//VerificationPlan:
		//	"verification" "plan" name=QualifiedName (":" title=STRING)? "for"
		//	systemRequirements=[ReqSpec::SystemRequirements|QualifiedName] "[" (description=Description? & claim+=Claim* &
		//	rationale=Rationale? & ("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"verification" "plan" name=QualifiedName (":" title=STRING)? "for"
		//systemRequirements=[ReqSpec::SystemRequirements|QualifiedName] "[" (description=Description? & claim+=Claim* &
		//rationale=Rationale? & ("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"verification"
		public Keyword getVerificationKeyword_0() { return cVerificationKeyword_0; }

		//"plan"
		public Keyword getPlanKeyword_1() { return cPlanKeyword_1; }

		//name=QualifiedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_2_0() { return cNameQualifiedNameParserRuleCall_2_0; }

		//(":" title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//":"
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//"for"
		public Keyword getForKeyword_4() { return cForKeyword_4; }

		//systemRequirements=[ReqSpec::SystemRequirements|QualifiedName]
		public Assignment getSystemRequirementsAssignment_5() { return cSystemRequirementsAssignment_5; }

		//[ReqSpec::SystemRequirements|QualifiedName]
		public CrossReference getSystemRequirementsSystemRequirementsCrossReference_5_0() { return cSystemRequirementsSystemRequirementsCrossReference_5_0; }

		//QualifiedName
		public RuleCall getSystemRequirementsSystemRequirementsQualifiedNameParserRuleCall_5_0_1() { return cSystemRequirementsSystemRequirementsQualifiedNameParserRuleCall_5_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_6() { return cLeftSquareBracketKeyword_6; }

		//description=Description? & claim+=Claim* & rationale=Rationale? & ("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_7() { return cUnorderedGroup_7; }

		//description=Description?
		public Assignment getDescriptionAssignment_7_0() { return cDescriptionAssignment_7_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_7_0_0() { return cDescriptionDescriptionParserRuleCall_7_0_0; }

		//claim+=Claim*
		public Assignment getClaimAssignment_7_1() { return cClaimAssignment_7_1; }

		//Claim
		public RuleCall getClaimClaimParserRuleCall_7_1_0() { return cClaimClaimParserRuleCall_7_1_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_7_2() { return cRationaleAssignment_7_2; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_7_2_0() { return cRationaleRationaleParserRuleCall_7_2_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_7_3() { return cGroup_7_3; }

		//"issues"
		public Keyword getIssuesKeyword_7_3_0() { return cIssuesKeyword_7_3_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_7_3_1() { return cIssuesAssignment_7_3_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_7_3_1_0() { return cIssuesSTRINGTerminalRuleCall_7_3_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class ClaimElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Claim");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cClaimKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cRequirementAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cRequirementRequirementCrossReference_1_0 = (CrossReference)cRequirementAssignment_1.eContents().get(0);
		private final RuleCall cRequirementRequirementQualifiedNameParserRuleCall_1_0_1 = (RuleCall)cRequirementRequirementCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftParenthesisKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cWeightAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cWeightNumberParserRuleCall_3_1_0 = (RuleCall)cWeightAssignment_3_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final UnorderedGroup cUnorderedGroup_5 = (UnorderedGroup)cGroup.eContents().get(5);
		private final Group cGroup_5_0 = (Group)cUnorderedGroup_5.eContents().get(0);
		private final Keyword cActivitiesKeyword_5_0_0 = (Keyword)cGroup_5_0.eContents().get(0);
		private final Assignment cActivitiesAssignment_5_0_1 = (Assignment)cGroup_5_0.eContents().get(1);
		private final RuleCall cActivitiesVerificationActivityParserRuleCall_5_0_1_0 = (RuleCall)cActivitiesAssignment_5_0_1.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cUnorderedGroup_5.eContents().get(1);
		private final Keyword cAssertKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cAssertAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final RuleCall cAssertArgumentExprParserRuleCall_5_1_1_0 = (RuleCall)cAssertAssignment_5_1_1.eContents().get(0);
		private final Assignment cRationaleAssignment_5_2 = (Assignment)cUnorderedGroup_5.eContents().get(2);
		private final RuleCall cRationaleRationaleParserRuleCall_5_2_0 = (RuleCall)cRationaleAssignment_5_2.eContents().get(0);
		private final Assignment cSubclaimAssignment_5_3 = (Assignment)cUnorderedGroup_5.eContents().get(3);
		private final RuleCall cSubclaimClaimParserRuleCall_5_3_0 = (RuleCall)cSubclaimAssignment_5_3.eContents().get(0);
		private final Group cGroup_5_4 = (Group)cUnorderedGroup_5.eContents().get(4);
		private final Keyword cIssuesKeyword_5_4_0 = (Keyword)cGroup_5_4.eContents().get(0);
		private final Assignment cIssuesAssignment_5_4_1 = (Assignment)cGroup_5_4.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_5_4_1_0 = (RuleCall)cIssuesAssignment_5_4_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Claim:
		//	"claim" requirement=[ReqSpec::Requirement|QualifiedName] (":" title=STRING)? ("(" weight=Number ")")? "["
		//	(("activities" activities+=VerificationActivity*)? & ("assert" assert=ArgumentExpr)? & rationale=Rationale? &
		//	subclaim+=Claim* & ("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"claim" requirement=[ReqSpec::Requirement|QualifiedName] (":" title=STRING)? ("(" weight=Number ")")? "[" (("activities"
		//activities+=VerificationActivity*)? & ("assert" assert=ArgumentExpr)? & rationale=Rationale? & subclaim+=Claim* &
		//("issues" issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"claim"
		public Keyword getClaimKeyword_0() { return cClaimKeyword_0; }

		//requirement=[ReqSpec::Requirement|QualifiedName]
		public Assignment getRequirementAssignment_1() { return cRequirementAssignment_1; }

		//[ReqSpec::Requirement|QualifiedName]
		public CrossReference getRequirementRequirementCrossReference_1_0() { return cRequirementRequirementCrossReference_1_0; }

		//QualifiedName
		public RuleCall getRequirementRequirementQualifiedNameParserRuleCall_1_0_1() { return cRequirementRequirementQualifiedNameParserRuleCall_1_0_1; }

		//(":" title=STRING)?
		public Group getGroup_2() { return cGroup_2; }

		//":"
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }

		//title=STRING
		public Assignment getTitleAssignment_2_1() { return cTitleAssignment_2_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_2_1_0() { return cTitleSTRINGTerminalRuleCall_2_1_0; }

		//("(" weight=Number ")")?
		public Group getGroup_3() { return cGroup_3; }

		//"("
		public Keyword getLeftParenthesisKeyword_3_0() { return cLeftParenthesisKeyword_3_0; }

		//weight=Number
		public Assignment getWeightAssignment_3_1() { return cWeightAssignment_3_1; }

		//Number
		public RuleCall getWeightNumberParserRuleCall_3_1_0() { return cWeightNumberParserRuleCall_3_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_3_2() { return cRightParenthesisKeyword_3_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//("activities" activities+=VerificationActivity*)? & ("assert" assert=ArgumentExpr)? & rationale=Rationale? &
		//subclaim+=Claim* & ("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_5() { return cUnorderedGroup_5; }

		//("activities" activities+=VerificationActivity*)?
		public Group getGroup_5_0() { return cGroup_5_0; }

		//"activities"
		public Keyword getActivitiesKeyword_5_0_0() { return cActivitiesKeyword_5_0_0; }

		//activities+=VerificationActivity*
		public Assignment getActivitiesAssignment_5_0_1() { return cActivitiesAssignment_5_0_1; }

		//VerificationActivity
		public RuleCall getActivitiesVerificationActivityParserRuleCall_5_0_1_0() { return cActivitiesVerificationActivityParserRuleCall_5_0_1_0; }

		//("assert" assert=ArgumentExpr)?
		public Group getGroup_5_1() { return cGroup_5_1; }

		//"assert"
		public Keyword getAssertKeyword_5_1_0() { return cAssertKeyword_5_1_0; }

		//assert=ArgumentExpr
		public Assignment getAssertAssignment_5_1_1() { return cAssertAssignment_5_1_1; }

		//ArgumentExpr
		public RuleCall getAssertArgumentExprParserRuleCall_5_1_1_0() { return cAssertArgumentExprParserRuleCall_5_1_1_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_5_2() { return cRationaleAssignment_5_2; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_5_2_0() { return cRationaleRationaleParserRuleCall_5_2_0; }

		//subclaim+=Claim*
		public Assignment getSubclaimAssignment_5_3() { return cSubclaimAssignment_5_3; }

		//Claim
		public RuleCall getSubclaimClaimParserRuleCall_5_3_0() { return cSubclaimClaimParserRuleCall_5_3_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_5_4() { return cGroup_5_4; }

		//"issues"
		public Keyword getIssuesKeyword_5_4_0() { return cIssuesKeyword_5_4_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_5_4_1() { return cIssuesAssignment_5_4_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_5_4_1_0() { return cIssuesSTRINGTerminalRuleCall_5_4_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class ArgumentExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ArgumentExpr");
		private final RuleCall cThenEvidenceExprParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ArgumentExpr:
		//	ThenEvidenceExpr;
		@Override public ParserRule getRule() { return rule; }

		//ThenEvidenceExpr
		public RuleCall getThenEvidenceExprParserRuleCall() { return cThenEvidenceExprParserRuleCall; }
	}

	public class ThenEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ThenEvidenceExpr");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cElseEvidenceExprParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cThenExprLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cThenKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cSuccessorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cSuccessorThenEvidenceExprParserRuleCall_1_1_0 = (RuleCall)cSuccessorAssignment_1_1.eContents().get(0);
		
		//ThenEvidenceExpr returns ArgumentExpr:
		//	ElseEvidenceExpr (=> ({ThenExpr.left=current} "then") successor=ThenEvidenceExpr)*;
		@Override public ParserRule getRule() { return rule; }

		//ElseEvidenceExpr (=> ({ThenExpr.left=current} "then") successor=ThenEvidenceExpr)*
		public Group getGroup() { return cGroup; }

		//ElseEvidenceExpr
		public RuleCall getElseEvidenceExprParserRuleCall_0() { return cElseEvidenceExprParserRuleCall_0; }

		//(=> ({ThenExpr.left=current} "then") successor=ThenEvidenceExpr)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ThenExpr.left=current} "then")
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ThenExpr.left=current} "then"
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ThenExpr.left=current}
		public Action getThenExprLeftAction_1_0_0_0() { return cThenExprLeftAction_1_0_0_0; }

		//"then"
		public Keyword getThenKeyword_1_0_0_1() { return cThenKeyword_1_0_0_1; }

		//successor=ThenEvidenceExpr
		public Assignment getSuccessorAssignment_1_1() { return cSuccessorAssignment_1_1; }

		//ThenEvidenceExpr
		public RuleCall getSuccessorThenEvidenceExprParserRuleCall_1_1_0() { return cSuccessorThenEvidenceExprParserRuleCall_1_1_0; }
	}

	public class ElseEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ElseEvidenceExpr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSingleElseEvidenceExprParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCompositeElseEvidenceExprParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//// Execute as alternative if the first one fails.
		//// The results of both are reported
		//ElseEvidenceExpr returns ArgumentExpr:
		//	SingleElseEvidenceExpr | CompositeElseEvidenceExpr;
		@Override public ParserRule getRule() { return rule; }

		//SingleElseEvidenceExpr | CompositeElseEvidenceExpr
		public Alternatives getAlternatives() { return cAlternatives; }

		//SingleElseEvidenceExpr
		public RuleCall getSingleElseEvidenceExprParserRuleCall_0() { return cSingleElseEvidenceExprParserRuleCall_0; }

		//CompositeElseEvidenceExpr
		public RuleCall getCompositeElseEvidenceExprParserRuleCall_1() { return cCompositeElseEvidenceExprParserRuleCall_1; }
	}

	public class SingleElseEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SingleElseEvidenceExpr");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cVAReferenceParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cElseExprLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cElseKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Alternatives cAlternatives_1_1 = (Alternatives)cGroup_1.eContents().get(1);
		private final Assignment cErrorAssignment_1_1_0 = (Assignment)cAlternatives_1_1.eContents().get(0);
		private final RuleCall cErrorElseEvidenceExprParserRuleCall_1_1_0_0 = (RuleCall)cErrorAssignment_1_1_0.eContents().get(0);
		private final Group cGroup_1_1_1 = (Group)cAlternatives_1_1.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_1_1_1_0 = (Keyword)cGroup_1_1_1.eContents().get(0);
		private final Group cGroup_1_1_1_1 = (Group)cGroup_1_1_1.eContents().get(1);
		private final Keyword cFailKeyword_1_1_1_1_0 = (Keyword)cGroup_1_1_1_1.eContents().get(0);
		private final Keyword cColonKeyword_1_1_1_1_1 = (Keyword)cGroup_1_1_1_1.eContents().get(1);
		private final Assignment cFailAssignment_1_1_1_1_2 = (Assignment)cGroup_1_1_1_1.eContents().get(2);
		private final RuleCall cFailThenEvidenceExprParserRuleCall_1_1_1_1_2_0 = (RuleCall)cFailAssignment_1_1_1_1_2.eContents().get(0);
		private final Group cGroup_1_1_1_2 = (Group)cGroup_1_1_1.eContents().get(2);
		private final Keyword cTimeoutKeyword_1_1_1_2_0 = (Keyword)cGroup_1_1_1_2.eContents().get(0);
		private final Keyword cColonKeyword_1_1_1_2_1 = (Keyword)cGroup_1_1_1_2.eContents().get(1);
		private final Assignment cTimeoutAssignment_1_1_1_2_2 = (Assignment)cGroup_1_1_1_2.eContents().get(2);
		private final RuleCall cTimeoutThenEvidenceExprParserRuleCall_1_1_1_2_2_0 = (RuleCall)cTimeoutAssignment_1_1_1_2_2.eContents().get(0);
		private final Group cGroup_1_1_1_3 = (Group)cGroup_1_1_1.eContents().get(3);
		private final Keyword cErrorKeyword_1_1_1_3_0 = (Keyword)cGroup_1_1_1_3.eContents().get(0);
		private final Keyword cColonKeyword_1_1_1_3_1 = (Keyword)cGroup_1_1_1_3.eContents().get(1);
		private final Assignment cErrorAssignment_1_1_1_3_2 = (Assignment)cGroup_1_1_1_3.eContents().get(2);
		private final RuleCall cErrorThenEvidenceExprParserRuleCall_1_1_1_3_2_0 = (RuleCall)cErrorAssignment_1_1_1_3_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_1_1_1_4 = (Keyword)cGroup_1_1_1.eContents().get(4);
		
		//SingleElseEvidenceExpr returns ArgumentExpr:
		//	VAReference (=> ({ElseExpr.left=current} "else") (error=ElseEvidenceExpr | "[" ("fail" ":" fail=ThenEvidenceExpr)?
		//	("timeout" ":" timeout=ThenEvidenceExpr)? ("error" ":" error=ThenEvidenceExpr)? "]"))*;
		@Override public ParserRule getRule() { return rule; }

		//VAReference (=> ({ElseExpr.left=current} "else") (error=ElseEvidenceExpr | "[" ("fail" ":" fail=ThenEvidenceExpr)?
		//("timeout" ":" timeout=ThenEvidenceExpr)? ("error" ":" error=ThenEvidenceExpr)? "]"))*
		public Group getGroup() { return cGroup; }

		//VAReference
		public RuleCall getVAReferenceParserRuleCall_0() { return cVAReferenceParserRuleCall_0; }

		//(=> ({ElseExpr.left=current} "else") (error=ElseEvidenceExpr | "[" ("fail" ":" fail=ThenEvidenceExpr)? ("timeout" ":"
		//timeout=ThenEvidenceExpr)? ("error" ":" error=ThenEvidenceExpr)? "]"))*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ElseExpr.left=current} "else")
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ElseExpr.left=current} "else"
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ElseExpr.left=current}
		public Action getElseExprLeftAction_1_0_0_0() { return cElseExprLeftAction_1_0_0_0; }

		//"else"
		public Keyword getElseKeyword_1_0_0_1() { return cElseKeyword_1_0_0_1; }

		//error=ElseEvidenceExpr | "[" ("fail" ":" fail=ThenEvidenceExpr)? ("timeout" ":" timeout=ThenEvidenceExpr)? ("error" ":"
		//error=ThenEvidenceExpr)? "]"
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//error=ElseEvidenceExpr
		public Assignment getErrorAssignment_1_1_0() { return cErrorAssignment_1_1_0; }

		//ElseEvidenceExpr
		public RuleCall getErrorElseEvidenceExprParserRuleCall_1_1_0_0() { return cErrorElseEvidenceExprParserRuleCall_1_1_0_0; }

		//"[" ("fail" ":" fail=ThenEvidenceExpr)? ("timeout" ":" timeout=ThenEvidenceExpr)? ("error" ":" error=ThenEvidenceExpr)?
		//"]"
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_1_1_1_0() { return cLeftSquareBracketKeyword_1_1_1_0; }

		//("fail" ":" fail=ThenEvidenceExpr)?
		public Group getGroup_1_1_1_1() { return cGroup_1_1_1_1; }

		//"fail"
		public Keyword getFailKeyword_1_1_1_1_0() { return cFailKeyword_1_1_1_1_0; }

		//":"
		public Keyword getColonKeyword_1_1_1_1_1() { return cColonKeyword_1_1_1_1_1; }

		//fail=ThenEvidenceExpr
		public Assignment getFailAssignment_1_1_1_1_2() { return cFailAssignment_1_1_1_1_2; }

		//ThenEvidenceExpr
		public RuleCall getFailThenEvidenceExprParserRuleCall_1_1_1_1_2_0() { return cFailThenEvidenceExprParserRuleCall_1_1_1_1_2_0; }

		//("timeout" ":" timeout=ThenEvidenceExpr)?
		public Group getGroup_1_1_1_2() { return cGroup_1_1_1_2; }

		//"timeout"
		public Keyword getTimeoutKeyword_1_1_1_2_0() { return cTimeoutKeyword_1_1_1_2_0; }

		//":"
		public Keyword getColonKeyword_1_1_1_2_1() { return cColonKeyword_1_1_1_2_1; }

		//timeout=ThenEvidenceExpr
		public Assignment getTimeoutAssignment_1_1_1_2_2() { return cTimeoutAssignment_1_1_1_2_2; }

		//ThenEvidenceExpr
		public RuleCall getTimeoutThenEvidenceExprParserRuleCall_1_1_1_2_2_0() { return cTimeoutThenEvidenceExprParserRuleCall_1_1_1_2_2_0; }

		//("error" ":" error=ThenEvidenceExpr)?
		public Group getGroup_1_1_1_3() { return cGroup_1_1_1_3; }

		//"error"
		public Keyword getErrorKeyword_1_1_1_3_0() { return cErrorKeyword_1_1_1_3_0; }

		//":"
		public Keyword getColonKeyword_1_1_1_3_1() { return cColonKeyword_1_1_1_3_1; }

		//error=ThenEvidenceExpr
		public Assignment getErrorAssignment_1_1_1_3_2() { return cErrorAssignment_1_1_1_3_2; }

		//ThenEvidenceExpr
		public RuleCall getErrorThenEvidenceExprParserRuleCall_1_1_1_3_2_0() { return cErrorThenEvidenceExprParserRuleCall_1_1_1_3_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_1_1_1_4() { return cRightSquareBracketKeyword_1_1_1_4; }
	}

	public class CompositeElseEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompositeElseEvidenceExpr");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cCompositeEvidenceExprParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cElseExprLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cElseKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cErrorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cErrorElseEvidenceExprParserRuleCall_1_1_0 = (RuleCall)cErrorAssignment_1_1.eContents().get(0);
		
		//CompositeElseEvidenceExpr returns ArgumentExpr:
		//	CompositeEvidenceExpr (=> ({ElseExpr.left=current} "else") error=ElseEvidenceExpr)*;
		@Override public ParserRule getRule() { return rule; }

		//CompositeEvidenceExpr (=> ({ElseExpr.left=current} "else") error=ElseEvidenceExpr)*
		public Group getGroup() { return cGroup; }

		//CompositeEvidenceExpr
		public RuleCall getCompositeEvidenceExprParserRuleCall_0() { return cCompositeEvidenceExprParserRuleCall_0; }

		//(=> ({ElseExpr.left=current} "else") error=ElseEvidenceExpr)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ElseExpr.left=current} "else")
		public Group getGroup_1_0() { return cGroup_1_0; }

		//{ElseExpr.left=current} "else"
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ElseExpr.left=current}
		public Action getElseExprLeftAction_1_0_0_0() { return cElseExprLeftAction_1_0_0_0; }

		//"else"
		public Keyword getElseKeyword_1_0_0_1() { return cElseKeyword_1_0_0_1; }

		//error=ElseEvidenceExpr
		public Assignment getErrorAssignment_1_1() { return cErrorAssignment_1_1; }

		//ElseEvidenceExpr
		public RuleCall getErrorElseEvidenceExprParserRuleCall_1_1_0() { return cErrorElseEvidenceExprParserRuleCall_1_1_0; }
	}

	public class QuantifiedEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QuantifiedEvidenceExpr");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAllKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cAllExprAction_1 = (Action)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cElementsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cElementsThenEvidenceExprParserRuleCall_3_0 = (RuleCall)cElementsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cCommaKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cElementsAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cElementsThenEvidenceExprParserRuleCall_4_1_0 = (RuleCall)cElementsAssignment_4_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//QuantifiedEvidenceExpr returns ArgumentExpr:
		//	"all" {AllExpr} "[" elements+=ThenEvidenceExpr ("," elements+=ThenEvidenceExpr)* "]";
		@Override public ParserRule getRule() { return rule; }

		//"all" {AllExpr} "[" elements+=ThenEvidenceExpr ("," elements+=ThenEvidenceExpr)* "]"
		public Group getGroup() { return cGroup; }

		//"all"
		public Keyword getAllKeyword_0() { return cAllKeyword_0; }

		//{AllExpr}
		public Action getAllExprAction_1() { return cAllExprAction_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//elements+=ThenEvidenceExpr
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }

		//ThenEvidenceExpr
		public RuleCall getElementsThenEvidenceExprParserRuleCall_3_0() { return cElementsThenEvidenceExprParserRuleCall_3_0; }

		//("," elements+=ThenEvidenceExpr)*
		public Group getGroup_4() { return cGroup_4; }

		//","
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//elements+=ThenEvidenceExpr
		public Assignment getElementsAssignment_4_1() { return cElementsAssignment_4_1; }

		//ThenEvidenceExpr
		public RuleCall getElementsThenEvidenceExprParserRuleCall_4_1_0() { return cElementsThenEvidenceExprParserRuleCall_4_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class CompositeEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompositeEvidenceExpr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final RuleCall cThenEvidenceExprParserRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final RuleCall cQuantifiedEvidenceExprParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//CompositeEvidenceExpr returns ArgumentExpr:
		//	"(" ThenEvidenceExpr ")" | QuantifiedEvidenceExpr;
		@Override public ParserRule getRule() { return rule; }

		//"(" ThenEvidenceExpr ")" | QuantifiedEvidenceExpr
		public Alternatives getAlternatives() { return cAlternatives; }

		//"(" ThenEvidenceExpr ")"
		public Group getGroup_0() { return cGroup_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }

		//ThenEvidenceExpr
		public RuleCall getThenEvidenceExprParserRuleCall_0_1() { return cThenEvidenceExprParserRuleCall_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_0_2() { return cRightParenthesisKeyword_0_2; }

		//QuantifiedEvidenceExpr
		public RuleCall getQuantifiedEvidenceExprParserRuleCall_1() { return cQuantifiedEvidenceExprParserRuleCall_1; }
	}

	public class VAReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VAReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRefExprAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cVerificationAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cVerificationVerificationActivityCrossReference_1_0 = (CrossReference)cVerificationAssignment_1.eContents().get(0);
		private final RuleCall cVerificationVerificationActivityIDTerminalRuleCall_1_0_1 = (RuleCall)cVerificationVerificationActivityCrossReference_1_0.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cWeightAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cWeightINTTerminalRuleCall_2_1_0 = (RuleCall)cWeightAssignment_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		
		////SingleEvidenceExpr returns ArgumentExpr:
		////	VAReference (=> ({WhenExpr.verification=current} 'when') condition+=[categories::VerificationCategory|ID]+)?; // should it be a selection category as well
		//VAReference returns ArgumentExpr:
		//	{RefExpr} verification=[VerificationActivity] ("(" weight=INT ")")?;
		@Override public ParserRule getRule() { return rule; }

		//{RefExpr} verification=[VerificationActivity] ("(" weight=INT ")")?
		public Group getGroup() { return cGroup; }

		//{RefExpr}
		public Action getRefExprAction_0() { return cRefExprAction_0; }

		//verification=[VerificationActivity]
		public Assignment getVerificationAssignment_1() { return cVerificationAssignment_1; }

		//[VerificationActivity]
		public CrossReference getVerificationVerificationActivityCrossReference_1_0() { return cVerificationVerificationActivityCrossReference_1_0; }

		//ID
		public RuleCall getVerificationVerificationActivityIDTerminalRuleCall_1_0_1() { return cVerificationVerificationActivityIDTerminalRuleCall_1_0_1; }

		//("(" weight=INT ")")?
		public Group getGroup_2() { return cGroup_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//weight=INT
		public Assignment getWeightAssignment_2_1() { return cWeightAssignment_2_1; }

		//INT
		public RuleCall getWeightINTTerminalRuleCall_2_1_0() { return cWeightINTTerminalRuleCall_2_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }
	}

	public class VerificationActivityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationActivity");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTitleAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_1_1_0 = (RuleCall)cTitleAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cForKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTargetAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cTargetComponentImplementationCrossReference_2_1_0 = (CrossReference)cTargetAssignment_2_1.eContents().get(0);
		private final RuleCall cTargetComponentImplementationAadlClassifierReferenceParserRuleCall_2_1_0_1 = (RuleCall)cTargetComponentImplementationCrossReference_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cCategoryKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cCategoryAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cCategoryCategoryCrossReference_3_1_0 = (CrossReference)cCategoryAssignment_3_1.eContents().get(0);
		private final RuleCall cCategoryCategoryIDTerminalRuleCall_3_1_0_1 = (RuleCall)cCategoryCategoryCrossReference_3_1_0.eContents().get(1);
		private final Keyword cColonKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cResultAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final CrossReference cResultComputeDeclarationCrossReference_5_0_0 = (CrossReference)cResultAssignment_5_0.eContents().get(0);
		private final RuleCall cResultComputeDeclarationIDTerminalRuleCall_5_0_0_1 = (RuleCall)cResultComputeDeclarationCrossReference_5_0_0.eContents().get(1);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cCommaKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cResultAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final CrossReference cResultComputeDeclarationCrossReference_5_1_1_0 = (CrossReference)cResultAssignment_5_1_1.eContents().get(0);
		private final RuleCall cResultComputeDeclarationIDTerminalRuleCall_5_1_1_0_1 = (RuleCall)cResultComputeDeclarationCrossReference_5_1_1_0.eContents().get(1);
		private final Keyword cEqualsSignKeyword_5_2 = (Keyword)cGroup_5.eContents().get(2);
		private final Assignment cMethodAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cMethodVerificationMethodCrossReference_6_0 = (CrossReference)cMethodAssignment_6.eContents().get(0);
		private final RuleCall cMethodVerificationMethodQualifiedNameParserRuleCall_6_0_1 = (RuleCall)cMethodVerificationMethodCrossReference_6_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Assignment cParametersAssignment_8_0 = (Assignment)cGroup_8.eContents().get(0);
		private final CrossReference cParametersValDeclarationCrossReference_8_0_0 = (CrossReference)cParametersAssignment_8_0.eContents().get(0);
		private final RuleCall cParametersValDeclarationIDTerminalRuleCall_8_0_0_1 = (RuleCall)cParametersValDeclarationCrossReference_8_0_0.eContents().get(1);
		private final Group cGroup_8_1 = (Group)cGroup_8.eContents().get(1);
		private final Keyword cCommaKeyword_8_1_0 = (Keyword)cGroup_8_1.eContents().get(0);
		private final Assignment cParametersAssignment_8_1_1 = (Assignment)cGroup_8_1.eContents().get(1);
		private final CrossReference cParametersValDeclarationCrossReference_8_1_1_0 = (CrossReference)cParametersAssignment_8_1_1.eContents().get(0);
		private final RuleCall cParametersValDeclarationIDTerminalRuleCall_8_1_1_0_1 = (RuleCall)cParametersValDeclarationCrossReference_8_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_9 = (Keyword)cGroup.eContents().get(9);
		private final Group cGroup_10 = (Group)cGroup.eContents().get(10);
		private final Keyword cPropertyKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Keyword cValuesKeyword_10_1 = (Keyword)cGroup_10.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_10_2 = (Keyword)cGroup_10.eContents().get(2);
		private final Group cGroup_10_3 = (Group)cGroup_10.eContents().get(3);
		private final Assignment cPropertyValuesAssignment_10_3_0 = (Assignment)cGroup_10_3.eContents().get(0);
		private final CrossReference cPropertyValuesValDeclarationCrossReference_10_3_0_0 = (CrossReference)cPropertyValuesAssignment_10_3_0.eContents().get(0);
		private final RuleCall cPropertyValuesValDeclarationIDTerminalRuleCall_10_3_0_0_1 = (RuleCall)cPropertyValuesValDeclarationCrossReference_10_3_0_0.eContents().get(1);
		private final Group cGroup_10_3_1 = (Group)cGroup_10_3.eContents().get(1);
		private final Keyword cCommaKeyword_10_3_1_0 = (Keyword)cGroup_10_3_1.eContents().get(0);
		private final Assignment cPropertyValuesAssignment_10_3_1_1 = (Assignment)cGroup_10_3_1.eContents().get(1);
		private final CrossReference cPropertyValuesValDeclarationCrossReference_10_3_1_1_0 = (CrossReference)cPropertyValuesAssignment_10_3_1_1.eContents().get(0);
		private final RuleCall cPropertyValuesValDeclarationIDTerminalRuleCall_10_3_1_1_0_1 = (RuleCall)cPropertyValuesValDeclarationCrossReference_10_3_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_10_4 = (Keyword)cGroup_10.eContents().get(4);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cTimeoutKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cTimeoutAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cTimeoutINTTerminalRuleCall_11_1_0 = (RuleCall)cTimeoutAssignment_11_1.eContents().get(0);
		
		//VerificationActivity:
		//	name=ID (":" title=STRING)? ("for" target=[aadl2::ComponentImplementation|AadlClassifierReference])? // for specific AADL model configuration
		//	("category" category+=[categories::Category]+)? ":" (result+=[common::ComputeDeclaration] (","
		//	result+=[common::ComputeDeclaration])* "=")? method=[VerificationMethod|QualifiedName] "("
		//	(parameters+=[common::ValDeclaration] ("," parameters+=[common::ValDeclaration])*)? ")" ("property" "values" "("
		//	(propertyValues+=[common::ValDeclaration] ("," propertyValues+=[common::ValDeclaration])*)? ")")? ("timeout"
		//	timeout=INT)?;
		@Override public ParserRule getRule() { return rule; }

		//name=ID (":" title=STRING)? ("for" target=[aadl2::ComponentImplementation|AadlClassifierReference])? // for specific AADL model configuration
		//("category" category+=[categories::Category]+)? ":" (result+=[common::ComputeDeclaration] (","
		//result+=[common::ComputeDeclaration])* "=")? method=[VerificationMethod|QualifiedName] "("
		//(parameters+=[common::ValDeclaration] ("," parameters+=[common::ValDeclaration])*)? ")" ("property" "values" "("
		//(propertyValues+=[common::ValDeclaration] ("," propertyValues+=[common::ValDeclaration])*)? ")")? ("timeout"
		//timeout=INT)?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//(":" title=STRING)?
		public Group getGroup_1() { return cGroup_1; }

		//":"
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//title=STRING
		public Assignment getTitleAssignment_1_1() { return cTitleAssignment_1_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_1_1_0() { return cTitleSTRINGTerminalRuleCall_1_1_0; }

		//("for" target=[aadl2::ComponentImplementation|AadlClassifierReference])?
		public Group getGroup_2() { return cGroup_2; }

		//"for"
		public Keyword getForKeyword_2_0() { return cForKeyword_2_0; }

		//target=[aadl2::ComponentImplementation|AadlClassifierReference]
		public Assignment getTargetAssignment_2_1() { return cTargetAssignment_2_1; }

		//[aadl2::ComponentImplementation|AadlClassifierReference]
		public CrossReference getTargetComponentImplementationCrossReference_2_1_0() { return cTargetComponentImplementationCrossReference_2_1_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentImplementationAadlClassifierReferenceParserRuleCall_2_1_0_1() { return cTargetComponentImplementationAadlClassifierReferenceParserRuleCall_2_1_0_1; }

		//("category" category+=[categories::Category]+)?
		public Group getGroup_3() { return cGroup_3; }

		//"category"
		public Keyword getCategoryKeyword_3_0() { return cCategoryKeyword_3_0; }

		//category+=[categories::Category]+
		public Assignment getCategoryAssignment_3_1() { return cCategoryAssignment_3_1; }

		//[categories::Category]
		public CrossReference getCategoryCategoryCrossReference_3_1_0() { return cCategoryCategoryCrossReference_3_1_0; }

		//ID
		public RuleCall getCategoryCategoryIDTerminalRuleCall_3_1_0_1() { return cCategoryCategoryIDTerminalRuleCall_3_1_0_1; }

		//":"
		public Keyword getColonKeyword_4() { return cColonKeyword_4; }

		//(result+=[common::ComputeDeclaration] ("," result+=[common::ComputeDeclaration])* "=")?
		public Group getGroup_5() { return cGroup_5; }

		//result+=[common::ComputeDeclaration]
		public Assignment getResultAssignment_5_0() { return cResultAssignment_5_0; }

		//[common::ComputeDeclaration]
		public CrossReference getResultComputeDeclarationCrossReference_5_0_0() { return cResultComputeDeclarationCrossReference_5_0_0; }

		//ID
		public RuleCall getResultComputeDeclarationIDTerminalRuleCall_5_0_0_1() { return cResultComputeDeclarationIDTerminalRuleCall_5_0_0_1; }

		//("," result+=[common::ComputeDeclaration])*
		public Group getGroup_5_1() { return cGroup_5_1; }

		//","
		public Keyword getCommaKeyword_5_1_0() { return cCommaKeyword_5_1_0; }

		//result+=[common::ComputeDeclaration]
		public Assignment getResultAssignment_5_1_1() { return cResultAssignment_5_1_1; }

		//[common::ComputeDeclaration]
		public CrossReference getResultComputeDeclarationCrossReference_5_1_1_0() { return cResultComputeDeclarationCrossReference_5_1_1_0; }

		//ID
		public RuleCall getResultComputeDeclarationIDTerminalRuleCall_5_1_1_0_1() { return cResultComputeDeclarationIDTerminalRuleCall_5_1_1_0_1; }

		//"="
		public Keyword getEqualsSignKeyword_5_2() { return cEqualsSignKeyword_5_2; }

		//method=[VerificationMethod|QualifiedName]
		public Assignment getMethodAssignment_6() { return cMethodAssignment_6; }

		//[VerificationMethod|QualifiedName]
		public CrossReference getMethodVerificationMethodCrossReference_6_0() { return cMethodVerificationMethodCrossReference_6_0; }

		//QualifiedName
		public RuleCall getMethodVerificationMethodQualifiedNameParserRuleCall_6_0_1() { return cMethodVerificationMethodQualifiedNameParserRuleCall_6_0_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_7() { return cLeftParenthesisKeyword_7; }

		//(parameters+=[common::ValDeclaration] ("," parameters+=[common::ValDeclaration])*)?
		public Group getGroup_8() { return cGroup_8; }

		//parameters+=[common::ValDeclaration]
		public Assignment getParametersAssignment_8_0() { return cParametersAssignment_8_0; }

		//[common::ValDeclaration]
		public CrossReference getParametersValDeclarationCrossReference_8_0_0() { return cParametersValDeclarationCrossReference_8_0_0; }

		//ID
		public RuleCall getParametersValDeclarationIDTerminalRuleCall_8_0_0_1() { return cParametersValDeclarationIDTerminalRuleCall_8_0_0_1; }

		//("," parameters+=[common::ValDeclaration])*
		public Group getGroup_8_1() { return cGroup_8_1; }

		//","
		public Keyword getCommaKeyword_8_1_0() { return cCommaKeyword_8_1_0; }

		//parameters+=[common::ValDeclaration]
		public Assignment getParametersAssignment_8_1_1() { return cParametersAssignment_8_1_1; }

		//[common::ValDeclaration]
		public CrossReference getParametersValDeclarationCrossReference_8_1_1_0() { return cParametersValDeclarationCrossReference_8_1_1_0; }

		//ID
		public RuleCall getParametersValDeclarationIDTerminalRuleCall_8_1_1_0_1() { return cParametersValDeclarationIDTerminalRuleCall_8_1_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_9() { return cRightParenthesisKeyword_9; }

		//("property" "values" "(" (propertyValues+=[common::ValDeclaration] ("," propertyValues+=[common::ValDeclaration])*)?
		//")")?
		public Group getGroup_10() { return cGroup_10; }

		//"property"
		public Keyword getPropertyKeyword_10_0() { return cPropertyKeyword_10_0; }

		//"values"
		public Keyword getValuesKeyword_10_1() { return cValuesKeyword_10_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_10_2() { return cLeftParenthesisKeyword_10_2; }

		//(propertyValues+=[common::ValDeclaration] ("," propertyValues+=[common::ValDeclaration])*)?
		public Group getGroup_10_3() { return cGroup_10_3; }

		//propertyValues+=[common::ValDeclaration]
		public Assignment getPropertyValuesAssignment_10_3_0() { return cPropertyValuesAssignment_10_3_0; }

		//[common::ValDeclaration]
		public CrossReference getPropertyValuesValDeclarationCrossReference_10_3_0_0() { return cPropertyValuesValDeclarationCrossReference_10_3_0_0; }

		//ID
		public RuleCall getPropertyValuesValDeclarationIDTerminalRuleCall_10_3_0_0_1() { return cPropertyValuesValDeclarationIDTerminalRuleCall_10_3_0_0_1; }

		//("," propertyValues+=[common::ValDeclaration])*
		public Group getGroup_10_3_1() { return cGroup_10_3_1; }

		//","
		public Keyword getCommaKeyword_10_3_1_0() { return cCommaKeyword_10_3_1_0; }

		//propertyValues+=[common::ValDeclaration]
		public Assignment getPropertyValuesAssignment_10_3_1_1() { return cPropertyValuesAssignment_10_3_1_1; }

		//[common::ValDeclaration]
		public CrossReference getPropertyValuesValDeclarationCrossReference_10_3_1_1_0() { return cPropertyValuesValDeclarationCrossReference_10_3_1_1_0; }

		//ID
		public RuleCall getPropertyValuesValDeclarationIDTerminalRuleCall_10_3_1_1_0_1() { return cPropertyValuesValDeclarationIDTerminalRuleCall_10_3_1_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_10_4() { return cRightParenthesisKeyword_10_4; }

		//("timeout" timeout=INT)?
		public Group getGroup_11() { return cGroup_11; }

		//"timeout"
		public Keyword getTimeoutKeyword_11_0() { return cTimeoutKeyword_11_0; }

		//timeout=INT
		public Assignment getTimeoutAssignment_11_1() { return cTimeoutAssignment_11_1; }

		//INT
		public RuleCall getTimeoutINTTerminalRuleCall_11_1_0() { return cTimeoutINTTerminalRuleCall_11_1_0; }
	}

	public class VerificationConditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationCondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives cAlternatives_0 = (Alternatives)cGroup.eContents().get(0);
		private final Group cGroup_0_0 = (Group)cAlternatives_0.eContents().get(0);
		private final Keyword cValidationKeyword_0_0_0 = (Keyword)cGroup_0_0.eContents().get(0);
		private final Action cVerificationValidationAction_0_0_1 = (Action)cGroup_0_0.eContents().get(1);
		private final Group cGroup_0_1 = (Group)cAlternatives_0.eContents().get(1);
		private final Keyword cPreconditionKeyword_0_1_0 = (Keyword)cGroup_0_1.eContents().get(0);
		private final Action cVerificationPreconditionAction_0_1_1 = (Action)cGroup_0_1.eContents().get(1);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cTitleAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_2_1_0 = (RuleCall)cTitleAssignment_2_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final UnorderedGroup cUnorderedGroup_4 = (UnorderedGroup)cGroup.eContents().get(4);
		private final Assignment cDescriptionAssignment_4_0 = (Assignment)cUnorderedGroup_4.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_4_0_0 = (RuleCall)cDescriptionAssignment_4_0.eContents().get(0);
		private final Group cGroup_4_1 = (Group)cUnorderedGroup_4.eContents().get(1);
		private final Assignment cMethodAssignment_4_1_0 = (Assignment)cGroup_4_1.eContents().get(0);
		private final CrossReference cMethodVerificationMethodCrossReference_4_1_0_0 = (CrossReference)cMethodAssignment_4_1_0.eContents().get(0);
		private final RuleCall cMethodVerificationMethodQualifiedNameParserRuleCall_4_1_0_0_1 = (RuleCall)cMethodVerificationMethodCrossReference_4_1_0_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_4_1_1 = (Keyword)cGroup_4_1.eContents().get(1);
		private final Group cGroup_4_1_2 = (Group)cGroup_4_1.eContents().get(2);
		private final Assignment cParametersAssignment_4_1_2_0 = (Assignment)cGroup_4_1_2.eContents().get(0);
		private final CrossReference cParametersAExpressionCrossReference_4_1_2_0_0 = (CrossReference)cParametersAssignment_4_1_2_0.eContents().get(0);
		private final RuleCall cParametersAExpressionIDTerminalRuleCall_4_1_2_0_0_1 = (RuleCall)cParametersAExpressionCrossReference_4_1_2_0_0.eContents().get(1);
		private final Group cGroup_4_1_2_1 = (Group)cGroup_4_1_2.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_2_1_0 = (Keyword)cGroup_4_1_2_1.eContents().get(0);
		private final Assignment cParametersAssignment_4_1_2_1_1 = (Assignment)cGroup_4_1_2_1.eContents().get(1);
		private final CrossReference cParametersAExpressionCrossReference_4_1_2_1_1_0 = (CrossReference)cParametersAssignment_4_1_2_1_1.eContents().get(0);
		private final RuleCall cParametersAExpressionIDTerminalRuleCall_4_1_2_1_1_0_1 = (RuleCall)cParametersAExpressionCrossReference_4_1_2_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_1_3 = (Keyword)cGroup_4_1.eContents().get(3);
		private final Group cGroup_4_1_4 = (Group)cGroup_4_1.eContents().get(4);
		private final Keyword cPropertyKeyword_4_1_4_0 = (Keyword)cGroup_4_1_4.eContents().get(0);
		private final Keyword cValuesKeyword_4_1_4_1 = (Keyword)cGroup_4_1_4.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_4_1_4_2 = (Keyword)cGroup_4_1_4.eContents().get(2);
		private final Group cGroup_4_1_4_3 = (Group)cGroup_4_1_4.eContents().get(3);
		private final Assignment cPropertyValuesAssignment_4_1_4_3_0 = (Assignment)cGroup_4_1_4_3.eContents().get(0);
		private final CrossReference cPropertyValuesAExpressionCrossReference_4_1_4_3_0_0 = (CrossReference)cPropertyValuesAssignment_4_1_4_3_0.eContents().get(0);
		private final RuleCall cPropertyValuesAExpressionIDTerminalRuleCall_4_1_4_3_0_0_1 = (RuleCall)cPropertyValuesAExpressionCrossReference_4_1_4_3_0_0.eContents().get(1);
		private final Group cGroup_4_1_4_3_1 = (Group)cGroup_4_1_4_3.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_4_3_1_0 = (Keyword)cGroup_4_1_4_3_1.eContents().get(0);
		private final Assignment cPropertyValuesAssignment_4_1_4_3_1_1 = (Assignment)cGroup_4_1_4_3_1.eContents().get(1);
		private final CrossReference cPropertyValuesAExpressionCrossReference_4_1_4_3_1_1_0 = (CrossReference)cPropertyValuesAssignment_4_1_4_3_1_1.eContents().get(0);
		private final RuleCall cPropertyValuesAExpressionIDTerminalRuleCall_4_1_4_3_1_1_0_1 = (RuleCall)cPropertyValuesAExpressionCrossReference_4_1_4_3_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_4_1_4_4 = (Keyword)cGroup_4_1_4.eContents().get(4);
		private final Group cGroup_4_1_5 = (Group)cGroup_4_1.eContents().get(5);
		private final Keyword cTimeoutKeyword_4_1_5_0 = (Keyword)cGroup_4_1_5.eContents().get(0);
		private final Assignment cTimeoutAssignment_4_1_5_1 = (Assignment)cGroup_4_1_5.eContents().get(1);
		private final RuleCall cTimeoutINTTerminalRuleCall_4_1_5_1_0 = (RuleCall)cTimeoutAssignment_4_1_5_1.eContents().get(0);
		private final Assignment cRationaleAssignment_4_2 = (Assignment)cUnorderedGroup_4.eContents().get(2);
		private final RuleCall cRationaleRationaleParserRuleCall_4_2_0 = (RuleCall)cRationaleAssignment_4_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//VerificationCondition:
		//	("validation" {VerificationValidation} | "precondition" {VerificationPrecondition}) name=ID (":" title=STRING)? "["
		//	(description=Description? & method=[VerificationMethod|QualifiedName] "(" (parameters+=[common::AExpression] (","
		//	parameters+=[common::AExpression])*)? ")" ("property" "values" "(" (propertyValues+=[common::AExpression] (","
		//	propertyValues+=[common::AExpression])*)? ")")? ("timeout" timeout=INT)? & rationale=Rationale?) "]";
		@Override public ParserRule getRule() { return rule; }

		//("validation" {VerificationValidation} | "precondition" {VerificationPrecondition}) name=ID (":" title=STRING)? "["
		//(description=Description? & method=[VerificationMethod|QualifiedName] "(" (parameters+=[common::AExpression] (","
		//parameters+=[common::AExpression])*)? ")" ("property" "values" "(" (propertyValues+=[common::AExpression] (","
		//propertyValues+=[common::AExpression])*)? ")")? ("timeout" timeout=INT)? & rationale=Rationale?) "]"
		public Group getGroup() { return cGroup; }

		//"validation" {VerificationValidation} | "precondition" {VerificationPrecondition}
		public Alternatives getAlternatives_0() { return cAlternatives_0; }

		//"validation" {VerificationValidation}
		public Group getGroup_0_0() { return cGroup_0_0; }

		//"validation"
		public Keyword getValidationKeyword_0_0_0() { return cValidationKeyword_0_0_0; }

		//{VerificationValidation}
		public Action getVerificationValidationAction_0_0_1() { return cVerificationValidationAction_0_0_1; }

		//"precondition" {VerificationPrecondition}
		public Group getGroup_0_1() { return cGroup_0_1; }

		//"precondition"
		public Keyword getPreconditionKeyword_0_1_0() { return cPreconditionKeyword_0_1_0; }

		//{VerificationPrecondition}
		public Action getVerificationPreconditionAction_0_1_1() { return cVerificationPreconditionAction_0_1_1; }

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

		//description=Description? & method=[VerificationMethod|QualifiedName] "(" (parameters+=[common::AExpression] (","
		//parameters+=[common::AExpression])*)? ")" ("property" "values" "(" (propertyValues+=[common::AExpression] (","
		//propertyValues+=[common::AExpression])*)? ")")? ("timeout" timeout=INT)? & rationale=Rationale?
		public UnorderedGroup getUnorderedGroup_4() { return cUnorderedGroup_4; }

		//description=Description?
		public Assignment getDescriptionAssignment_4_0() { return cDescriptionAssignment_4_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_4_0_0() { return cDescriptionDescriptionParserRuleCall_4_0_0; }

		//method=[VerificationMethod|QualifiedName] "(" (parameters+=[common::AExpression] (","
		//parameters+=[common::AExpression])*)? ")" ("property" "values" "(" (propertyValues+=[common::AExpression] (","
		//propertyValues+=[common::AExpression])*)? ")")? ("timeout" timeout=INT)?
		public Group getGroup_4_1() { return cGroup_4_1; }

		//method=[VerificationMethod|QualifiedName]
		public Assignment getMethodAssignment_4_1_0() { return cMethodAssignment_4_1_0; }

		//[VerificationMethod|QualifiedName]
		public CrossReference getMethodVerificationMethodCrossReference_4_1_0_0() { return cMethodVerificationMethodCrossReference_4_1_0_0; }

		//QualifiedName
		public RuleCall getMethodVerificationMethodQualifiedNameParserRuleCall_4_1_0_0_1() { return cMethodVerificationMethodQualifiedNameParserRuleCall_4_1_0_0_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_4_1_1() { return cLeftParenthesisKeyword_4_1_1; }

		//(parameters+=[common::AExpression] ("," parameters+=[common::AExpression])*)?
		public Group getGroup_4_1_2() { return cGroup_4_1_2; }

		//parameters+=[common::AExpression]
		public Assignment getParametersAssignment_4_1_2_0() { return cParametersAssignment_4_1_2_0; }

		//[common::AExpression]
		public CrossReference getParametersAExpressionCrossReference_4_1_2_0_0() { return cParametersAExpressionCrossReference_4_1_2_0_0; }

		//ID
		public RuleCall getParametersAExpressionIDTerminalRuleCall_4_1_2_0_0_1() { return cParametersAExpressionIDTerminalRuleCall_4_1_2_0_0_1; }

		//("," parameters+=[common::AExpression])*
		public Group getGroup_4_1_2_1() { return cGroup_4_1_2_1; }

		//","
		public Keyword getCommaKeyword_4_1_2_1_0() { return cCommaKeyword_4_1_2_1_0; }

		//parameters+=[common::AExpression]
		public Assignment getParametersAssignment_4_1_2_1_1() { return cParametersAssignment_4_1_2_1_1; }

		//[common::AExpression]
		public CrossReference getParametersAExpressionCrossReference_4_1_2_1_1_0() { return cParametersAExpressionCrossReference_4_1_2_1_1_0; }

		//ID
		public RuleCall getParametersAExpressionIDTerminalRuleCall_4_1_2_1_1_0_1() { return cParametersAExpressionIDTerminalRuleCall_4_1_2_1_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_4_1_3() { return cRightParenthesisKeyword_4_1_3; }

		//("property" "values" "(" (propertyValues+=[common::AExpression] ("," propertyValues+=[common::AExpression])*)? ")")?
		public Group getGroup_4_1_4() { return cGroup_4_1_4; }

		//"property"
		public Keyword getPropertyKeyword_4_1_4_0() { return cPropertyKeyword_4_1_4_0; }

		//"values"
		public Keyword getValuesKeyword_4_1_4_1() { return cValuesKeyword_4_1_4_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_4_1_4_2() { return cLeftParenthesisKeyword_4_1_4_2; }

		//(propertyValues+=[common::AExpression] ("," propertyValues+=[common::AExpression])*)?
		public Group getGroup_4_1_4_3() { return cGroup_4_1_4_3; }

		//propertyValues+=[common::AExpression]
		public Assignment getPropertyValuesAssignment_4_1_4_3_0() { return cPropertyValuesAssignment_4_1_4_3_0; }

		//[common::AExpression]
		public CrossReference getPropertyValuesAExpressionCrossReference_4_1_4_3_0_0() { return cPropertyValuesAExpressionCrossReference_4_1_4_3_0_0; }

		//ID
		public RuleCall getPropertyValuesAExpressionIDTerminalRuleCall_4_1_4_3_0_0_1() { return cPropertyValuesAExpressionIDTerminalRuleCall_4_1_4_3_0_0_1; }

		//("," propertyValues+=[common::AExpression])*
		public Group getGroup_4_1_4_3_1() { return cGroup_4_1_4_3_1; }

		//","
		public Keyword getCommaKeyword_4_1_4_3_1_0() { return cCommaKeyword_4_1_4_3_1_0; }

		//propertyValues+=[common::AExpression]
		public Assignment getPropertyValuesAssignment_4_1_4_3_1_1() { return cPropertyValuesAssignment_4_1_4_3_1_1; }

		//[common::AExpression]
		public CrossReference getPropertyValuesAExpressionCrossReference_4_1_4_3_1_1_0() { return cPropertyValuesAExpressionCrossReference_4_1_4_3_1_1_0; }

		//ID
		public RuleCall getPropertyValuesAExpressionIDTerminalRuleCall_4_1_4_3_1_1_0_1() { return cPropertyValuesAExpressionIDTerminalRuleCall_4_1_4_3_1_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_4_1_4_4() { return cRightParenthesisKeyword_4_1_4_4; }

		//("timeout" timeout=INT)?
		public Group getGroup_4_1_5() { return cGroup_4_1_5; }

		//"timeout"
		public Keyword getTimeoutKeyword_4_1_5_0() { return cTimeoutKeyword_4_1_5_0; }

		//timeout=INT
		public Assignment getTimeoutAssignment_4_1_5_1() { return cTimeoutAssignment_4_1_5_1; }

		//INT
		public RuleCall getTimeoutINTTerminalRuleCall_4_1_5_1_0() { return cTimeoutINTTerminalRuleCall_4_1_5_1_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_4_2() { return cRationaleAssignment_4_2; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_4_2_0() { return cRationaleRationaleParserRuleCall_4_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class VerificationMethodRegistryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationMethodRegistry");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVerificationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cMethodsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameIDTerminalRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cDescriptionAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_5_0_0 = (RuleCall)cDescriptionAssignment_5_0.eContents().get(0);
		private final Assignment cMethodsAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cMethodsVerificationMethodParserRuleCall_5_1_0 = (RuleCall)cMethodsAssignment_5_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//VerificationMethodRegistry:
		//	"verification" "methods" name=ID (":" title=STRING)? "[" (description=Description? methods+=VerificationMethod*) "]";
		@Override public ParserRule getRule() { return rule; }

		//"verification" "methods" name=ID (":" title=STRING)? "[" (description=Description? methods+=VerificationMethod*) "]"
		public Group getGroup() { return cGroup; }

		//"verification"
		public Keyword getVerificationKeyword_0() { return cVerificationKeyword_0; }

		//"methods"
		public Keyword getMethodsKeyword_1() { return cMethodsKeyword_1; }

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

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//description=Description? methods+=VerificationMethod*
		public Group getGroup_5() { return cGroup_5; }

		//description=Description?
		public Assignment getDescriptionAssignment_5_0() { return cDescriptionAssignment_5_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_5_0_0() { return cDescriptionDescriptionParserRuleCall_5_0_0; }

		//methods+=VerificationMethod*
		public Assignment getMethodsAssignment_5_1() { return cMethodsAssignment_5_1; }

		//VerificationMethod
		public RuleCall getMethodsVerificationMethodParserRuleCall_5_1_0() { return cMethodsVerificationMethodParserRuleCall_5_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class FormalParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "FormalParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cParameterTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cParameterTypeIDTerminalRuleCall_0_0 = (RuleCall)cParameterTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cPercentSignKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cUnitAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_2_1_0 = (CrossReference)cUnitAssignment_2_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_2_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_2_1_0.eContents().get(1);
		
		//FormalParameter:
		//	parameterType=ID name=ID ("%" unit=[aadl2::UnitLiteral])?;
		@Override public ParserRule getRule() { return rule; }

		//parameterType=ID name=ID ("%" unit=[aadl2::UnitLiteral])?
		public Group getGroup() { return cGroup; }

		//parameterType=ID
		public Assignment getParameterTypeAssignment_0() { return cParameterTypeAssignment_0; }

		//ID
		public RuleCall getParameterTypeIDTerminalRuleCall_0_0() { return cParameterTypeIDTerminalRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("%" unit=[aadl2::UnitLiteral])?
		public Group getGroup_2() { return cGroup_2; }

		//"%"
		public Keyword getPercentSignKeyword_2_0() { return cPercentSignKeyword_2_0; }

		//unit=[aadl2::UnitLiteral]
		public Assignment getUnitAssignment_2_1() { return cUnitAssignment_2_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_2_1_0() { return cUnitUnitLiteralCrossReference_2_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_2_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_2_1_0_1; }
	}

	public class VerificationMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VerificationMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMethodKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Assignment cParamsAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final RuleCall cParamsFormalParameterParserRuleCall_2_1_0_0 = (RuleCall)cParamsAssignment_2_1_0.eContents().get(0);
		private final Group cGroup_2_1_1 = (Group)cGroup_2_1.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_1_0 = (Keyword)cGroup_2_1_1.eContents().get(0);
		private final Assignment cParamsAssignment_2_1_1_1 = (Assignment)cGroup_2_1_1.eContents().get(1);
		private final RuleCall cParamsFormalParameterParserRuleCall_2_1_1_1_0 = (RuleCall)cParamsAssignment_2_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_2_3 = (Group)cGroup_2.eContents().get(3);
		private final Keyword cPropertiesKeyword_2_3_0 = (Keyword)cGroup_2_3.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_3_1 = (Keyword)cGroup_2_3.eContents().get(1);
		private final Group cGroup_2_3_2 = (Group)cGroup_2_3.eContents().get(2);
		private final Assignment cPropertiesAssignment_2_3_2_0 = (Assignment)cGroup_2_3_2.eContents().get(0);
		private final CrossReference cPropertiesPropertyCrossReference_2_3_2_0_0 = (CrossReference)cPropertiesAssignment_2_3_2_0.eContents().get(0);
		private final RuleCall cPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_0_0_1 = (RuleCall)cPropertiesPropertyCrossReference_2_3_2_0_0.eContents().get(1);
		private final Group cGroup_2_3_2_1 = (Group)cGroup_2_3_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_3_2_1_0 = (Keyword)cGroup_2_3_2_1.eContents().get(0);
		private final Assignment cPropertiesAssignment_2_3_2_1_1 = (Assignment)cGroup_2_3_2_1.eContents().get(1);
		private final CrossReference cPropertiesPropertyCrossReference_2_3_2_1_1_0 = (CrossReference)cPropertiesAssignment_2_3_2_1_1.eContents().get(0);
		private final RuleCall cPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_1_1_0_1 = (RuleCall)cPropertiesPropertyCrossReference_2_3_2_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2_3_3 = (Keyword)cGroup_2_3.eContents().get(3);
		private final Alternatives cAlternatives_2_4 = (Alternatives)cGroup_2.eContents().get(4);
		private final Assignment cIsPredicateAssignment_2_4_0 = (Assignment)cAlternatives_2_4.eContents().get(0);
		private final Keyword cIsPredicateBooleanKeyword_2_4_0_0 = (Keyword)cIsPredicateAssignment_2_4_0.eContents().get(0);
		private final Assignment cIsResultReportAssignment_2_4_1 = (Assignment)cAlternatives_2_4.eContents().get(1);
		private final Keyword cIsResultReportReportKeyword_2_4_1_0 = (Keyword)cIsResultReportAssignment_2_4_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final UnorderedGroup cUnorderedGroup_5 = (UnorderedGroup)cGroup.eContents().get(5);
		private final Assignment cMethodTypeAssignment_5_0 = (Assignment)cUnorderedGroup_5.eContents().get(0);
		private final RuleCall cMethodTypeMethodTypeParserRuleCall_5_0_0 = (RuleCall)cMethodTypeAssignment_5_0.eContents().get(0);
		private final Assignment cDescriptionAssignment_5_1 = (Assignment)cUnorderedGroup_5.eContents().get(1);
		private final RuleCall cDescriptionDescriptionParserRuleCall_5_1_0 = (RuleCall)cDescriptionAssignment_5_1.eContents().get(0);
		private final Assignment cConditionAssignment_5_2 = (Assignment)cUnorderedGroup_5.eContents().get(2);
		private final RuleCall cConditionVerificationConditionParserRuleCall_5_2_0 = (RuleCall)cConditionAssignment_5_2.eContents().get(0);
		private final Group cGroup_5_3 = (Group)cUnorderedGroup_5.eContents().get(3);
		private final Keyword cCategoryKeyword_5_3_0 = (Keyword)cGroup_5_3.eContents().get(0);
		private final Assignment cCategoryAssignment_5_3_1 = (Assignment)cGroup_5_3.eContents().get(1);
		private final CrossReference cCategoryCategoryCrossReference_5_3_1_0 = (CrossReference)cCategoryAssignment_5_3_1.eContents().get(0);
		private final RuleCall cCategoryCategoryIDTerminalRuleCall_5_3_1_0_1 = (RuleCall)cCategoryCategoryCrossReference_5_3_1_0.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//VerificationMethod:
		//	"method" name=ID ("(" (params+=FormalParameter ("," params+=FormalParameter)*)? ")" ("properties" "("
		//	(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] ("," properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
		//	")")? (isPredicate?="boolean" | isResultReport?="report")?)? (":" title=STRING)? "[" (methodType=MethodType &
		//	description=Description? & condition=VerificationCondition? & ("category" category+=[categories::Category]+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"method" name=ID ("(" (params+=FormalParameter ("," params+=FormalParameter)*)? ")" ("properties" "("
		//(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] ("," properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
		//")")? (isPredicate?="boolean" | isResultReport?="report")?)? (":" title=STRING)? "[" (methodType=MethodType &
		//description=Description? & condition=VerificationCondition? & ("category" category+=[categories::Category]+)?) "]"
		public Group getGroup() { return cGroup; }

		//"method"
		public Keyword getMethodKeyword_0() { return cMethodKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("(" (params+=FormalParameter ("," params+=FormalParameter)*)? ")" ("properties" "("
		//(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] ("," properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
		//")")? (isPredicate?="boolean" | isResultReport?="report")?)?
		public Group getGroup_2() { return cGroup_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//(params+=FormalParameter ("," params+=FormalParameter)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//params+=FormalParameter
		public Assignment getParamsAssignment_2_1_0() { return cParamsAssignment_2_1_0; }

		//FormalParameter
		public RuleCall getParamsFormalParameterParserRuleCall_2_1_0_0() { return cParamsFormalParameterParserRuleCall_2_1_0_0; }

		//("," params+=FormalParameter)*
		public Group getGroup_2_1_1() { return cGroup_2_1_1; }

		//","
		public Keyword getCommaKeyword_2_1_1_0() { return cCommaKeyword_2_1_1_0; }

		//params+=FormalParameter
		public Assignment getParamsAssignment_2_1_1_1() { return cParamsAssignment_2_1_1_1; }

		//FormalParameter
		public RuleCall getParamsFormalParameterParserRuleCall_2_1_1_1_0() { return cParamsFormalParameterParserRuleCall_2_1_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }

		//("properties" "(" (properties+=[aadl2::Property|AADLPROPERTYREFERENCE] (","
		//properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)? ")")?
		public Group getGroup_2_3() { return cGroup_2_3; }

		//"properties"
		public Keyword getPropertiesKeyword_2_3_0() { return cPropertiesKeyword_2_3_0; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_3_1() { return cLeftParenthesisKeyword_2_3_1; }

		//(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] ("," properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
		public Group getGroup_2_3_2() { return cGroup_2_3_2; }

		//properties+=[aadl2::Property|AADLPROPERTYREFERENCE]
		public Assignment getPropertiesAssignment_2_3_2_0() { return cPropertiesAssignment_2_3_2_0; }

		//[aadl2::Property|AADLPROPERTYREFERENCE]
		public CrossReference getPropertiesPropertyCrossReference_2_3_2_0_0() { return cPropertiesPropertyCrossReference_2_3_2_0_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_0_0_1() { return cPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_0_0_1; }

		//("," properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*
		public Group getGroup_2_3_2_1() { return cGroup_2_3_2_1; }

		//","
		public Keyword getCommaKeyword_2_3_2_1_0() { return cCommaKeyword_2_3_2_1_0; }

		//properties+=[aadl2::Property|AADLPROPERTYREFERENCE]
		public Assignment getPropertiesAssignment_2_3_2_1_1() { return cPropertiesAssignment_2_3_2_1_1; }

		//[aadl2::Property|AADLPROPERTYREFERENCE]
		public CrossReference getPropertiesPropertyCrossReference_2_3_2_1_1_0() { return cPropertiesPropertyCrossReference_2_3_2_1_1_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_1_1_0_1() { return cPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_1_1_0_1; }

		//")"
		public Keyword getRightParenthesisKeyword_2_3_3() { return cRightParenthesisKeyword_2_3_3; }

		//(isPredicate?="boolean" | isResultReport?="report")?
		public Alternatives getAlternatives_2_4() { return cAlternatives_2_4; }

		//isPredicate?="boolean"
		public Assignment getIsPredicateAssignment_2_4_0() { return cIsPredicateAssignment_2_4_0; }

		//"boolean"
		public Keyword getIsPredicateBooleanKeyword_2_4_0_0() { return cIsPredicateBooleanKeyword_2_4_0_0; }

		//isResultReport?="report"
		public Assignment getIsResultReportAssignment_2_4_1() { return cIsResultReportAssignment_2_4_1; }

		//"report"
		public Keyword getIsResultReportReportKeyword_2_4_1_0() { return cIsResultReportReportKeyword_2_4_1_0; }

		//(":" title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//":"
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//methodType=MethodType & description=Description? & condition=VerificationCondition? & ("category"
		//category+=[categories::Category]+)?
		public UnorderedGroup getUnorderedGroup_5() { return cUnorderedGroup_5; }

		//methodType=MethodType
		public Assignment getMethodTypeAssignment_5_0() { return cMethodTypeAssignment_5_0; }

		//MethodType
		public RuleCall getMethodTypeMethodTypeParserRuleCall_5_0_0() { return cMethodTypeMethodTypeParserRuleCall_5_0_0; }

		//description=Description?
		public Assignment getDescriptionAssignment_5_1() { return cDescriptionAssignment_5_1; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_5_1_0() { return cDescriptionDescriptionParserRuleCall_5_1_0; }

		//condition=VerificationCondition?
		public Assignment getConditionAssignment_5_2() { return cConditionAssignment_5_2; }

		//VerificationCondition
		public RuleCall getConditionVerificationConditionParserRuleCall_5_2_0() { return cConditionVerificationConditionParserRuleCall_5_2_0; }

		//("category" category+=[categories::Category]+)?
		public Group getGroup_5_3() { return cGroup_5_3; }

		//"category"
		public Keyword getCategoryKeyword_5_3_0() { return cCategoryKeyword_5_3_0; }

		//category+=[categories::Category]+
		public Assignment getCategoryAssignment_5_3_1() { return cCategoryAssignment_5_3_1; }

		//[categories::Category]
		public CrossReference getCategoryCategoryCrossReference_5_3_1_0() { return cCategoryCategoryCrossReference_5_3_1_0; }

		//ID
		public RuleCall getCategoryCategoryIDTerminalRuleCall_5_3_1_0_1() { return cCategoryCategoryIDTerminalRuleCall_5_3_1_0_1; }

		//"]"
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class MethodTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MethodType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cResoluteMethodParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cJavaMethodParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cManualMethodParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPluginMethodParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//MethodType:
		//	ResoluteMethod | JavaMethod | ManualMethod | PluginMethod;
		@Override public ParserRule getRule() { return rule; }

		//ResoluteMethod | JavaMethod | ManualMethod | PluginMethod
		public Alternatives getAlternatives() { return cAlternatives; }

		//ResoluteMethod
		public RuleCall getResoluteMethodParserRuleCall_0() { return cResoluteMethodParserRuleCall_0; }

		//JavaMethod
		public RuleCall getJavaMethodParserRuleCall_1() { return cJavaMethodParserRuleCall_1; }

		//ManualMethod
		public RuleCall getManualMethodParserRuleCall_2() { return cManualMethodParserRuleCall_2; }

		//PluginMethod
		public RuleCall getPluginMethodParserRuleCall_3() { return cPluginMethodParserRuleCall_3; }
	}

	public class ResoluteMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ResoluteMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cResoluteKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMethodReferenceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cMethodReferenceFunctionDefinitionCrossReference_1_0 = (CrossReference)cMethodReferenceAssignment_1.eContents().get(0);
		private final RuleCall cMethodReferenceFunctionDefinitionIDTerminalRuleCall_1_0_1 = (RuleCall)cMethodReferenceFunctionDefinitionCrossReference_1_0.eContents().get(1);
		
		//ResoluteMethod:
		//	"resolute" methodReference=[resolute::FunctionDefinition];
		@Override public ParserRule getRule() { return rule; }

		//"resolute" methodReference=[resolute::FunctionDefinition]
		public Group getGroup() { return cGroup; }

		//"resolute"
		public Keyword getResoluteKeyword_0() { return cResoluteKeyword_0; }

		//methodReference=[resolute::FunctionDefinition]
		public Assignment getMethodReferenceAssignment_1() { return cMethodReferenceAssignment_1; }

		//[resolute::FunctionDefinition]
		public CrossReference getMethodReferenceFunctionDefinitionCrossReference_1_0() { return cMethodReferenceFunctionDefinitionCrossReference_1_0; }

		//ID
		public RuleCall getMethodReferenceFunctionDefinitionIDTerminalRuleCall_1_0_1() { return cMethodReferenceFunctionDefinitionIDTerminalRuleCall_1_0_1; }
	}

	public class JavaMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "JavaMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cJavaKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMethodPathAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMethodPathQualifiedNameParserRuleCall_1_0 = (RuleCall)cMethodPathAssignment_1.eContents().get(0);
		
		//JavaMethod:
		//	"java" methodPath=QualifiedName;
		@Override public ParserRule getRule() { return rule; }

		//"java" methodPath=QualifiedName
		public Group getGroup() { return cGroup; }

		//"java"
		public Keyword getJavaKeyword_0() { return cJavaKeyword_0; }

		//methodPath=QualifiedName
		public Assignment getMethodPathAssignment_1() { return cMethodPathAssignment_1; }

		//QualifiedName
		public RuleCall getMethodPathQualifiedNameParserRuleCall_1_0() { return cMethodPathQualifiedNameParserRuleCall_1_0; }
	}

	public class ManualMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ManualMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cManualKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cManualMethodAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cDialogIDAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDialogIDQualifiedNameParserRuleCall_2_0 = (RuleCall)cDialogIDAssignment_2.eContents().get(0);
		
		//ManualMethod:
		//	"manual" {ManualMethod} dialogID=QualifiedName;
		@Override public ParserRule getRule() { return rule; }

		//"manual" {ManualMethod} dialogID=QualifiedName
		public Group getGroup() { return cGroup; }

		//"manual"
		public Keyword getManualKeyword_0() { return cManualKeyword_0; }

		//{ManualMethod}
		public Action getManualMethodAction_1() { return cManualMethodAction_1; }

		//dialogID=QualifiedName
		public Assignment getDialogIDAssignment_2() { return cDialogIDAssignment_2; }

		//QualifiedName
		public RuleCall getDialogIDQualifiedNameParserRuleCall_2_0() { return cDialogIDQualifiedNameParserRuleCall_2_0; }
	}

	public class PluginMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PluginMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPluginKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMethodIDAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMethodIDIDTerminalRuleCall_1_0 = (RuleCall)cMethodIDAssignment_1.eContents().get(0);
		
		////enum SupportedScopes: SELF='self' | PARTS='parts' | ALL='all';
		////enum SupportedReporting: MARKER='marker' |ERRORMARKER='errormarker' | DIAGNOSTICS='diagnostics'| ASSERTEXCEPTION='assertexception'|RESULTREPORT='resultreport' ;
		//PluginMethod:
		//	"plugin" methodID=ID;
		@Override public ParserRule getRule() { return rule; }

		//"plugin" methodID=ID
		public Group getGroup() { return cGroup; }

		//"plugin"
		public Keyword getPluginKeyword_0() { return cPluginKeyword_0; }

		//methodID=ID
		public Assignment getMethodIDAssignment_1() { return cMethodIDAssignment_1; }

		//ID
		public RuleCall getMethodIDIDTerminalRuleCall_1_0() { return cMethodIDIDTerminalRuleCall_1_0; }
	}
	
	
	private final VerificationElements pVerification;
	private final VerificationPlanElements pVerificationPlan;
	private final ClaimElements pClaim;
	private final ArgumentExprElements pArgumentExpr;
	private final ThenEvidenceExprElements pThenEvidenceExpr;
	private final ElseEvidenceExprElements pElseEvidenceExpr;
	private final SingleElseEvidenceExprElements pSingleElseEvidenceExpr;
	private final CompositeElseEvidenceExprElements pCompositeElseEvidenceExpr;
	private final QuantifiedEvidenceExprElements pQuantifiedEvidenceExpr;
	private final CompositeEvidenceExprElements pCompositeEvidenceExpr;
	private final VAReferenceElements pVAReference;
	private final VerificationActivityElements pVerificationActivity;
	private final VerificationConditionElements pVerificationCondition;
	private final VerificationMethodRegistryElements pVerificationMethodRegistry;
	private final FormalParameterElements pFormalParameter;
	private final VerificationMethodElements pVerificationMethod;
	private final MethodTypeElements pMethodType;
	private final ResoluteMethodElements pResoluteMethod;
	private final JavaMethodElements pJavaMethod;
	private final ManualMethodElements pManualMethod;
	private final PluginMethodElements pPluginMethod;
	
	private final Grammar grammar;

	private final CommonGrammarAccess gaCommon;

	@Inject
	public VerifyGrammarAccess(GrammarProvider grammarProvider,
		CommonGrammarAccess gaCommon) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCommon = gaCommon;
		this.pVerification = new VerificationElements();
		this.pVerificationPlan = new VerificationPlanElements();
		this.pClaim = new ClaimElements();
		this.pArgumentExpr = new ArgumentExprElements();
		this.pThenEvidenceExpr = new ThenEvidenceExprElements();
		this.pElseEvidenceExpr = new ElseEvidenceExprElements();
		this.pSingleElseEvidenceExpr = new SingleElseEvidenceExprElements();
		this.pCompositeElseEvidenceExpr = new CompositeElseEvidenceExprElements();
		this.pQuantifiedEvidenceExpr = new QuantifiedEvidenceExprElements();
		this.pCompositeEvidenceExpr = new CompositeEvidenceExprElements();
		this.pVAReference = new VAReferenceElements();
		this.pVerificationActivity = new VerificationActivityElements();
		this.pVerificationCondition = new VerificationConditionElements();
		this.pVerificationMethodRegistry = new VerificationMethodRegistryElements();
		this.pFormalParameter = new FormalParameterElements();
		this.pVerificationMethod = new VerificationMethodElements();
		this.pMethodType = new MethodTypeElements();
		this.pResoluteMethod = new ResoluteMethodElements();
		this.pJavaMethod = new JavaMethodElements();
		this.pManualMethod = new ManualMethodElements();
		this.pPluginMethod = new PluginMethodElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.verify.Verify".equals(grammar.getName())) {
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

	
	//Verification:
	//	contents+=(VerificationPlan | VerificationMethodRegistry)+;
	public VerificationElements getVerificationAccess() {
		return pVerification;
	}
	
	public ParserRule getVerificationRule() {
		return getVerificationAccess().getRule();
	}

	//VerificationPlan:
	//	"verification" "plan" name=QualifiedName (":" title=STRING)? "for"
	//	systemRequirements=[ReqSpec::SystemRequirements|QualifiedName] "[" (description=Description? & claim+=Claim* &
	//	rationale=Rationale? & ("issues" issues+=STRING+)?) "]";
	public VerificationPlanElements getVerificationPlanAccess() {
		return pVerificationPlan;
	}
	
	public ParserRule getVerificationPlanRule() {
		return getVerificationPlanAccess().getRule();
	}

	//Claim:
	//	"claim" requirement=[ReqSpec::Requirement|QualifiedName] (":" title=STRING)? ("(" weight=Number ")")? "["
	//	(("activities" activities+=VerificationActivity*)? & ("assert" assert=ArgumentExpr)? & rationale=Rationale? &
	//	subclaim+=Claim* & ("issues" issues+=STRING+)?) "]";
	public ClaimElements getClaimAccess() {
		return pClaim;
	}
	
	public ParserRule getClaimRule() {
		return getClaimAccess().getRule();
	}

	//ArgumentExpr:
	//	ThenEvidenceExpr;
	public ArgumentExprElements getArgumentExprAccess() {
		return pArgumentExpr;
	}
	
	public ParserRule getArgumentExprRule() {
		return getArgumentExprAccess().getRule();
	}

	//ThenEvidenceExpr returns ArgumentExpr:
	//	ElseEvidenceExpr (=> ({ThenExpr.left=current} "then") successor=ThenEvidenceExpr)*;
	public ThenEvidenceExprElements getThenEvidenceExprAccess() {
		return pThenEvidenceExpr;
	}
	
	public ParserRule getThenEvidenceExprRule() {
		return getThenEvidenceExprAccess().getRule();
	}

	//// Execute as alternative if the first one fails.
	//// The results of both are reported
	//ElseEvidenceExpr returns ArgumentExpr:
	//	SingleElseEvidenceExpr | CompositeElseEvidenceExpr;
	public ElseEvidenceExprElements getElseEvidenceExprAccess() {
		return pElseEvidenceExpr;
	}
	
	public ParserRule getElseEvidenceExprRule() {
		return getElseEvidenceExprAccess().getRule();
	}

	//SingleElseEvidenceExpr returns ArgumentExpr:
	//	VAReference (=> ({ElseExpr.left=current} "else") (error=ElseEvidenceExpr | "[" ("fail" ":" fail=ThenEvidenceExpr)?
	//	("timeout" ":" timeout=ThenEvidenceExpr)? ("error" ":" error=ThenEvidenceExpr)? "]"))*;
	public SingleElseEvidenceExprElements getSingleElseEvidenceExprAccess() {
		return pSingleElseEvidenceExpr;
	}
	
	public ParserRule getSingleElseEvidenceExprRule() {
		return getSingleElseEvidenceExprAccess().getRule();
	}

	//CompositeElseEvidenceExpr returns ArgumentExpr:
	//	CompositeEvidenceExpr (=> ({ElseExpr.left=current} "else") error=ElseEvidenceExpr)*;
	public CompositeElseEvidenceExprElements getCompositeElseEvidenceExprAccess() {
		return pCompositeElseEvidenceExpr;
	}
	
	public ParserRule getCompositeElseEvidenceExprRule() {
		return getCompositeElseEvidenceExprAccess().getRule();
	}

	//QuantifiedEvidenceExpr returns ArgumentExpr:
	//	"all" {AllExpr} "[" elements+=ThenEvidenceExpr ("," elements+=ThenEvidenceExpr)* "]";
	public QuantifiedEvidenceExprElements getQuantifiedEvidenceExprAccess() {
		return pQuantifiedEvidenceExpr;
	}
	
	public ParserRule getQuantifiedEvidenceExprRule() {
		return getQuantifiedEvidenceExprAccess().getRule();
	}

	//CompositeEvidenceExpr returns ArgumentExpr:
	//	"(" ThenEvidenceExpr ")" | QuantifiedEvidenceExpr;
	public CompositeEvidenceExprElements getCompositeEvidenceExprAccess() {
		return pCompositeEvidenceExpr;
	}
	
	public ParserRule getCompositeEvidenceExprRule() {
		return getCompositeEvidenceExprAccess().getRule();
	}

	////SingleEvidenceExpr returns ArgumentExpr:
	////	VAReference (=> ({WhenExpr.verification=current} 'when') condition+=[categories::VerificationCategory|ID]+)?; // should it be a selection category as well
	//VAReference returns ArgumentExpr:
	//	{RefExpr} verification=[VerificationActivity] ("(" weight=INT ")")?;
	public VAReferenceElements getVAReferenceAccess() {
		return pVAReference;
	}
	
	public ParserRule getVAReferenceRule() {
		return getVAReferenceAccess().getRule();
	}

	//VerificationActivity:
	//	name=ID (":" title=STRING)? ("for" target=[aadl2::ComponentImplementation|AadlClassifierReference])? // for specific AADL model configuration
	//	("category" category+=[categories::Category]+)? ":" (result+=[common::ComputeDeclaration] (","
	//	result+=[common::ComputeDeclaration])* "=")? method=[VerificationMethod|QualifiedName] "("
	//	(parameters+=[common::ValDeclaration] ("," parameters+=[common::ValDeclaration])*)? ")" ("property" "values" "("
	//	(propertyValues+=[common::ValDeclaration] ("," propertyValues+=[common::ValDeclaration])*)? ")")? ("timeout"
	//	timeout=INT)?;
	public VerificationActivityElements getVerificationActivityAccess() {
		return pVerificationActivity;
	}
	
	public ParserRule getVerificationActivityRule() {
		return getVerificationActivityAccess().getRule();
	}

	//VerificationCondition:
	//	("validation" {VerificationValidation} | "precondition" {VerificationPrecondition}) name=ID (":" title=STRING)? "["
	//	(description=Description? & method=[VerificationMethod|QualifiedName] "(" (parameters+=[common::AExpression] (","
	//	parameters+=[common::AExpression])*)? ")" ("property" "values" "(" (propertyValues+=[common::AExpression] (","
	//	propertyValues+=[common::AExpression])*)? ")")? ("timeout" timeout=INT)? & rationale=Rationale?) "]";
	public VerificationConditionElements getVerificationConditionAccess() {
		return pVerificationCondition;
	}
	
	public ParserRule getVerificationConditionRule() {
		return getVerificationConditionAccess().getRule();
	}

	//VerificationMethodRegistry:
	//	"verification" "methods" name=ID (":" title=STRING)? "[" (description=Description? methods+=VerificationMethod*) "]";
	public VerificationMethodRegistryElements getVerificationMethodRegistryAccess() {
		return pVerificationMethodRegistry;
	}
	
	public ParserRule getVerificationMethodRegistryRule() {
		return getVerificationMethodRegistryAccess().getRule();
	}

	//FormalParameter:
	//	parameterType=ID name=ID ("%" unit=[aadl2::UnitLiteral])?;
	public FormalParameterElements getFormalParameterAccess() {
		return pFormalParameter;
	}
	
	public ParserRule getFormalParameterRule() {
		return getFormalParameterAccess().getRule();
	}

	//VerificationMethod:
	//	"method" name=ID ("(" (params+=FormalParameter ("," params+=FormalParameter)*)? ")" ("properties" "("
	//	(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] ("," properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
	//	")")? (isPredicate?="boolean" | isResultReport?="report")?)? (":" title=STRING)? "[" (methodType=MethodType &
	//	description=Description? & condition=VerificationCondition? & ("category" category+=[categories::Category]+)?) "]";
	public VerificationMethodElements getVerificationMethodAccess() {
		return pVerificationMethod;
	}
	
	public ParserRule getVerificationMethodRule() {
		return getVerificationMethodAccess().getRule();
	}

	//MethodType:
	//	ResoluteMethod | JavaMethod | ManualMethod | PluginMethod;
	public MethodTypeElements getMethodTypeAccess() {
		return pMethodType;
	}
	
	public ParserRule getMethodTypeRule() {
		return getMethodTypeAccess().getRule();
	}

	//ResoluteMethod:
	//	"resolute" methodReference=[resolute::FunctionDefinition];
	public ResoluteMethodElements getResoluteMethodAccess() {
		return pResoluteMethod;
	}
	
	public ParserRule getResoluteMethodRule() {
		return getResoluteMethodAccess().getRule();
	}

	//JavaMethod:
	//	"java" methodPath=QualifiedName;
	public JavaMethodElements getJavaMethodAccess() {
		return pJavaMethod;
	}
	
	public ParserRule getJavaMethodRule() {
		return getJavaMethodAccess().getRule();
	}

	//ManualMethod:
	//	"manual" {ManualMethod} dialogID=QualifiedName;
	public ManualMethodElements getManualMethodAccess() {
		return pManualMethod;
	}
	
	public ParserRule getManualMethodRule() {
		return getManualMethodAccess().getRule();
	}

	////enum SupportedScopes: SELF='self' | PARTS='parts' | ALL='all';
	////enum SupportedReporting: MARKER='marker' |ERRORMARKER='errormarker' | DIAGNOSTICS='diagnostics'| ASSERTEXCEPTION='assertexception'|RESULTREPORT='resultreport' ;
	//PluginMethod:
	//	"plugin" methodID=ID;
	public PluginMethodElements getPluginMethodAccess() {
		return pPluginMethod;
	}
	
	public ParserRule getPluginMethodRule() {
		return getPluginMethodAccess().getRule();
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
	//	"uncertainty" "[" ("volatility" volatility=Number & "costimpact" costimpact=Number & "scheduleimpact"
	//	scheduleimpact=Number & "familiarity" familiarity=Number & "timecriticality" timecriticality=Number & "riskindex"
	//	riskindex=Number & "maturityindex" maturityindex=Number) "]";
	public CommonGrammarAccess.UncertaintyElements getUncertaintyAccess() {
		return gaCommon.getUncertaintyAccess();
	}
	
	public ParserRule getUncertaintyRule() {
		return getUncertaintyAccess().getRule();
	}

	//ValDeclaration returns AVariableDeclaration:
	//	{ValDeclaration} "val" (=> (type=ID name=ID) | name=ID) "=" right=AExpression?;
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
	//	INTEGER_LIT;
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

	//terminal INTEGER_LIT:
	//	DIGIT+ ("_" DIGIT+)* ("#" BASED_INTEGER "#" INT_EXPONENT? | INT_EXPONENT?);
	public TerminalRule getINTEGER_LITRule() {
		return gaCommon.getINTEGER_LITRule();
	} 

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

	//QualifiedName:
	//	ID ("." ID)*;
	public CommonGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaCommon.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//Number hidden():
	//	HEX | (INT | DECIMAL) ("." (INT | DECIMAL))?;
	public CommonGrammarAccess.NumberElements getNumberAccess() {
		return gaCommon.getNumberAccess();
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}

	//terminal HEX:
	//	("0x" | "0X") ("0".."9" | "a".."f" | "A".."F" | "_")+ ("#" (("b" | "B") ("i" | "I") | ("l" | "L")))?;
	public TerminalRule getHEXRule() {
		return gaCommon.getHEXRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9" ("0".."9" | "_")*;
	public TerminalRule getINTRule() {
		return gaCommon.getINTRule();
	} 

	//terminal DECIMAL:
	//	INT (("e" | "E") ("+" | "-")? INT)? (("b" | "B") ("i" | "I" | "d" | "D") | ("l" | "L" | "d" | "D" | "f" | "F"))?;
	public TerminalRule getDECIMALRule() {
		return gaCommon.getDECIMALRule();
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaCommon.getIDRule();
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
