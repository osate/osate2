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
package org.osate.verify.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.osate.alisa.common.services.CommonGrammarAccess;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class VerifyGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class VerificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.Verification");
		private final Assignment cContentsAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cContentsAlternatives_0 = (Alternatives)cContentsAssignment.eContents().get(0);
		private final RuleCall cContentsVerificationPlanParserRuleCall_0_0 = (RuleCall)cContentsAlternatives_0.eContents().get(0);
		private final RuleCall cContentsVerificationMethodRegistryParserRuleCall_0_1 = (RuleCall)cContentsAlternatives_0.eContents().get(1);
		
		//Verification:
		//	contents+=(VerificationPlan | VerificationMethodRegistry)+;
		@Override public ParserRule getRule() { return rule; }

		//contents+=(VerificationPlan | VerificationMethodRegistry)+
		public Assignment getContentsAssignment() { return cContentsAssignment; }

		//(VerificationPlan | VerificationMethodRegistry)
		public Alternatives getContentsAlternatives_0() { return cContentsAlternatives_0; }

		//VerificationPlan
		public RuleCall getContentsVerificationPlanParserRuleCall_0_0() { return cContentsVerificationPlanParserRuleCall_0_0; }

		//VerificationMethodRegistry
		public RuleCall getContentsVerificationMethodRegistryParserRuleCall_0_1() { return cContentsVerificationMethodRegistryParserRuleCall_0_1; }
	}

	public class VerificationPlanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.VerificationPlan");
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
		private final Assignment cRequirementSetAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cRequirementSetRequirementSetCrossReference_5_0 = (CrossReference)cRequirementSetAssignment_5.eContents().get(0);
		private final RuleCall cRequirementSetRequirementSetQualifiedNameParserRuleCall_5_0_1 = (RuleCall)cRequirementSetRequirementSetCrossReference_5_0.eContents().get(1);
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
		//	'verification' 'plan' name=QualifiedName (':' title=STRING)?
		//	'for' requirementSet=[ReqSpec::RequirementSet|QualifiedName]
		//	'[' (description=Description?
		//	& claim+=Claim*
		//	& rationale=Rationale?
		//	& ('issues' issues+=STRING+)?)
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'verification' 'plan' name=QualifiedName (':' title=STRING)? 'for'
		//requirementSet=[ReqSpec::RequirementSet|QualifiedName] '[' (description=Description? & claim+=Claim* &
		//rationale=Rationale? & ('issues' issues+=STRING+)?) ']'
		public Group getGroup() { return cGroup; }

		//'verification'
		public Keyword getVerificationKeyword_0() { return cVerificationKeyword_0; }

		//'plan'
		public Keyword getPlanKeyword_1() { return cPlanKeyword_1; }

		//name=QualifiedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_2_0() { return cNameQualifiedNameParserRuleCall_2_0; }

		//(':' title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//'for'
		public Keyword getForKeyword_4() { return cForKeyword_4; }

		//requirementSet=[ReqSpec::RequirementSet|QualifiedName]
		public Assignment getRequirementSetAssignment_5() { return cRequirementSetAssignment_5; }

		//[ReqSpec::RequirementSet|QualifiedName]
		public CrossReference getRequirementSetRequirementSetCrossReference_5_0() { return cRequirementSetRequirementSetCrossReference_5_0; }

		//QualifiedName
		public RuleCall getRequirementSetRequirementSetQualifiedNameParserRuleCall_5_0_1() { return cRequirementSetRequirementSetQualifiedNameParserRuleCall_5_0_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_6() { return cLeftSquareBracketKeyword_6; }

		//(description=Description? & claim+=Claim* & rationale=Rationale? & ('issues' issues+=STRING+)?)
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

		//('issues' issues+=STRING+)?
		public Group getGroup_7_3() { return cGroup_7_3; }

		//'issues'
		public Keyword getIssuesKeyword_7_3_0() { return cIssuesKeyword_7_3_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_7_3_1() { return cIssuesAssignment_7_3_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_7_3_1_0() { return cIssuesSTRINGTerminalRuleCall_7_3_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class ClaimElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.Claim");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cClaimAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cClaimKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRequirementAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cRequirementRequirementCrossReference_2_0 = (CrossReference)cRequirementAssignment_2.eContents().get(0);
		private final RuleCall cRequirementRequirementQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cRequirementRequirementCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
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
		private final Group cGroup_5_3 = (Group)cUnorderedGroup_5.eContents().get(3);
		private final Keyword cWeightKeyword_5_3_0 = (Keyword)cGroup_5_3.eContents().get(0);
		private final Assignment cWeightAssignment_5_3_1 = (Assignment)cGroup_5_3.eContents().get(1);
		private final RuleCall cWeightINTTerminalRuleCall_5_3_1_0 = (RuleCall)cWeightAssignment_5_3_1.eContents().get(0);
		private final Assignment cSubclaimAssignment_5_4 = (Assignment)cUnorderedGroup_5.eContents().get(4);
		private final RuleCall cSubclaimClaimParserRuleCall_5_4_0 = (RuleCall)cSubclaimAssignment_5_4.eContents().get(0);
		private final Group cGroup_5_5 = (Group)cUnorderedGroup_5.eContents().get(5);
		private final Keyword cIssuesKeyword_5_5_0 = (Keyword)cGroup_5_5.eContents().get(0);
		private final Assignment cIssuesAssignment_5_5_1 = (Assignment)cGroup_5_5.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_5_5_1_0 = (RuleCall)cIssuesAssignment_5_5_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//Claim:
		//	{Claim} 'claim' requirement=[ReqSpec::Requirement|QualifiedName]? (':' title=STRING)?
		//	'[' (('activities' activities+=VerificationActivity*)?
		//	& ('assert' assert=ArgumentExpr)?
		//	& rationale=Rationale?
		//	& ('weight' weight=INT)?
		//	& subclaim+=Claim*
		//	& ('issues' issues+=STRING+)?)
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//{Claim} 'claim' requirement=[ReqSpec::Requirement|QualifiedName]? (':' title=STRING)? '[' (('activities'
		//activities+=VerificationActivity*)? & ('assert' assert=ArgumentExpr)? & rationale=Rationale? & ('weight' weight=INT)? &
		//subclaim+=Claim* & ('issues' issues+=STRING+)?) ']'
		public Group getGroup() { return cGroup; }

		//{Claim}
		public Action getClaimAction_0() { return cClaimAction_0; }

		//'claim'
		public Keyword getClaimKeyword_1() { return cClaimKeyword_1; }

		//requirement=[ReqSpec::Requirement|QualifiedName]?
		public Assignment getRequirementAssignment_2() { return cRequirementAssignment_2; }

		//[ReqSpec::Requirement|QualifiedName]
		public CrossReference getRequirementRequirementCrossReference_2_0() { return cRequirementRequirementCrossReference_2_0; }

		//QualifiedName
		public RuleCall getRequirementRequirementQualifiedNameParserRuleCall_2_0_1() { return cRequirementRequirementQualifiedNameParserRuleCall_2_0_1; }

		//(':' title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//(('activities' activities+=VerificationActivity*)? & ('assert' assert=ArgumentExpr)? & rationale=Rationale? & ('weight'
		//weight=INT)? & subclaim+=Claim* & ('issues' issues+=STRING+)?)
		public UnorderedGroup getUnorderedGroup_5() { return cUnorderedGroup_5; }

		//('activities' activities+=VerificationActivity*)?
		public Group getGroup_5_0() { return cGroup_5_0; }

		//'activities'
		public Keyword getActivitiesKeyword_5_0_0() { return cActivitiesKeyword_5_0_0; }

		//activities+=VerificationActivity*
		public Assignment getActivitiesAssignment_5_0_1() { return cActivitiesAssignment_5_0_1; }

		//VerificationActivity
		public RuleCall getActivitiesVerificationActivityParserRuleCall_5_0_1_0() { return cActivitiesVerificationActivityParserRuleCall_5_0_1_0; }

		//('assert' assert=ArgumentExpr)?
		public Group getGroup_5_1() { return cGroup_5_1; }

		//'assert'
		public Keyword getAssertKeyword_5_1_0() { return cAssertKeyword_5_1_0; }

		//assert=ArgumentExpr
		public Assignment getAssertAssignment_5_1_1() { return cAssertAssignment_5_1_1; }

		//ArgumentExpr
		public RuleCall getAssertArgumentExprParserRuleCall_5_1_1_0() { return cAssertArgumentExprParserRuleCall_5_1_1_0; }

		//rationale=Rationale?
		public Assignment getRationaleAssignment_5_2() { return cRationaleAssignment_5_2; }

		//Rationale
		public RuleCall getRationaleRationaleParserRuleCall_5_2_0() { return cRationaleRationaleParserRuleCall_5_2_0; }

		//('weight' weight=INT)?
		public Group getGroup_5_3() { return cGroup_5_3; }

		//'weight'
		public Keyword getWeightKeyword_5_3_0() { return cWeightKeyword_5_3_0; }

		//weight=INT
		public Assignment getWeightAssignment_5_3_1() { return cWeightAssignment_5_3_1; }

		//INT
		public RuleCall getWeightINTTerminalRuleCall_5_3_1_0() { return cWeightINTTerminalRuleCall_5_3_1_0; }

		//subclaim+=Claim*
		public Assignment getSubclaimAssignment_5_4() { return cSubclaimAssignment_5_4; }

		//Claim
		public RuleCall getSubclaimClaimParserRuleCall_5_4_0() { return cSubclaimClaimParserRuleCall_5_4_0; }

		//('issues' issues+=STRING+)?
		public Group getGroup_5_5() { return cGroup_5_5; }

		//'issues'
		public Keyword getIssuesKeyword_5_5_0() { return cIssuesKeyword_5_5_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_5_5_1() { return cIssuesAssignment_5_5_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_5_5_1_0() { return cIssuesSTRINGTerminalRuleCall_5_5_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class ArgumentExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.ArgumentExpr");
		private final RuleCall cThenEvidenceExprParserRuleCall = (RuleCall)rule.eContents().get(1);
		
		//ArgumentExpr:
		//	ThenEvidenceExpr;
		@Override public ParserRule getRule() { return rule; }

		//ThenEvidenceExpr
		public RuleCall getThenEvidenceExprParserRuleCall() { return cThenEvidenceExprParserRuleCall; }
	}

	public class ThenEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.ThenEvidenceExpr");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cElseEvidenceExprParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cThenExprLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cThenKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cSuccessorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cSuccessorThenEvidenceExprParserRuleCall_1_1_0 = (RuleCall)cSuccessorAssignment_1_1.eContents().get(0);
		
		//ThenEvidenceExpr ArgumentExpr:
		//	ElseEvidenceExpr (=> ({ThenExpr.left=current} 'then') successor=ThenEvidenceExpr)*;
		@Override public ParserRule getRule() { return rule; }

		//ElseEvidenceExpr (=> ({ThenExpr.left=current} 'then') successor=ThenEvidenceExpr)*
		public Group getGroup() { return cGroup; }

		//ElseEvidenceExpr
		public RuleCall getElseEvidenceExprParserRuleCall_0() { return cElseEvidenceExprParserRuleCall_0; }

		//(=> ({ThenExpr.left=current} 'then') successor=ThenEvidenceExpr)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ThenExpr.left=current} 'then')
		public Group getGroup_1_0() { return cGroup_1_0; }

		//({ThenExpr.left=current} 'then')
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ThenExpr.left=current}
		public Action getThenExprLeftAction_1_0_0_0() { return cThenExprLeftAction_1_0_0_0; }

		//'then'
		public Keyword getThenKeyword_1_0_0_1() { return cThenKeyword_1_0_0_1; }

		//successor=ThenEvidenceExpr
		public Assignment getSuccessorAssignment_1_1() { return cSuccessorAssignment_1_1; }

		//ThenEvidenceExpr
		public RuleCall getSuccessorThenEvidenceExprParserRuleCall_1_1_0() { return cSuccessorThenEvidenceExprParserRuleCall_1_1_0; }
	}

	public class ElseEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.ElseEvidenceExpr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSingleElseEvidenceExprParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cCompositeElseEvidenceExprParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//// Execute as alternative if the first one fails.
		//// The results of both are reported
		//ElseEvidenceExpr ArgumentExpr:
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.SingleElseEvidenceExpr");
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
		
		//SingleElseEvidenceExpr ArgumentExpr:
		//	VAReference (=> ({ElseExpr.left=current} 'else') (error=ElseEvidenceExpr |
		//	'[' ('fail' ':' fail=ThenEvidenceExpr)? ('timeout' ':' timeout=ThenEvidenceExpr)? ('error' ':'
		//	error=ThenEvidenceExpr)?
		//	']'))*;
		@Override public ParserRule getRule() { return rule; }

		//VAReference (=> ({ElseExpr.left=current} 'else') (error=ElseEvidenceExpr | '[' ('fail' ':' fail=ThenEvidenceExpr)?
		//('timeout' ':' timeout=ThenEvidenceExpr)? ('error' ':' error=ThenEvidenceExpr)? ']'))*
		public Group getGroup() { return cGroup; }

		//VAReference
		public RuleCall getVAReferenceParserRuleCall_0() { return cVAReferenceParserRuleCall_0; }

		//(=> ({ElseExpr.left=current} 'else') (error=ElseEvidenceExpr | '[' ('fail' ':' fail=ThenEvidenceExpr)? ('timeout' ':'
		//timeout=ThenEvidenceExpr)? ('error' ':' error=ThenEvidenceExpr)? ']'))*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ElseExpr.left=current} 'else')
		public Group getGroup_1_0() { return cGroup_1_0; }

		//({ElseExpr.left=current} 'else')
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ElseExpr.left=current}
		public Action getElseExprLeftAction_1_0_0_0() { return cElseExprLeftAction_1_0_0_0; }

		//'else'
		public Keyword getElseKeyword_1_0_0_1() { return cElseKeyword_1_0_0_1; }

		//(error=ElseEvidenceExpr | '[' ('fail' ':' fail=ThenEvidenceExpr)? ('timeout' ':' timeout=ThenEvidenceExpr)? ('error' ':'
		//error=ThenEvidenceExpr)? ']')
		public Alternatives getAlternatives_1_1() { return cAlternatives_1_1; }

		//error=ElseEvidenceExpr
		public Assignment getErrorAssignment_1_1_0() { return cErrorAssignment_1_1_0; }

		//ElseEvidenceExpr
		public RuleCall getErrorElseEvidenceExprParserRuleCall_1_1_0_0() { return cErrorElseEvidenceExprParserRuleCall_1_1_0_0; }

		//'[' ('fail' ':' fail=ThenEvidenceExpr)? ('timeout' ':' timeout=ThenEvidenceExpr)? ('error' ':' error=ThenEvidenceExpr)?
		//']'
		public Group getGroup_1_1_1() { return cGroup_1_1_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_1_1_1_0() { return cLeftSquareBracketKeyword_1_1_1_0; }

		//('fail' ':' fail=ThenEvidenceExpr)?
		public Group getGroup_1_1_1_1() { return cGroup_1_1_1_1; }

		//'fail'
		public Keyword getFailKeyword_1_1_1_1_0() { return cFailKeyword_1_1_1_1_0; }

		//':'
		public Keyword getColonKeyword_1_1_1_1_1() { return cColonKeyword_1_1_1_1_1; }

		//fail=ThenEvidenceExpr
		public Assignment getFailAssignment_1_1_1_1_2() { return cFailAssignment_1_1_1_1_2; }

		//ThenEvidenceExpr
		public RuleCall getFailThenEvidenceExprParserRuleCall_1_1_1_1_2_0() { return cFailThenEvidenceExprParserRuleCall_1_1_1_1_2_0; }

		//('timeout' ':' timeout=ThenEvidenceExpr)?
		public Group getGroup_1_1_1_2() { return cGroup_1_1_1_2; }

		//'timeout'
		public Keyword getTimeoutKeyword_1_1_1_2_0() { return cTimeoutKeyword_1_1_1_2_0; }

		//':'
		public Keyword getColonKeyword_1_1_1_2_1() { return cColonKeyword_1_1_1_2_1; }

		//timeout=ThenEvidenceExpr
		public Assignment getTimeoutAssignment_1_1_1_2_2() { return cTimeoutAssignment_1_1_1_2_2; }

		//ThenEvidenceExpr
		public RuleCall getTimeoutThenEvidenceExprParserRuleCall_1_1_1_2_2_0() { return cTimeoutThenEvidenceExprParserRuleCall_1_1_1_2_2_0; }

		//('error' ':' error=ThenEvidenceExpr)?
		public Group getGroup_1_1_1_3() { return cGroup_1_1_1_3; }

		//'error'
		public Keyword getErrorKeyword_1_1_1_3_0() { return cErrorKeyword_1_1_1_3_0; }

		//':'
		public Keyword getColonKeyword_1_1_1_3_1() { return cColonKeyword_1_1_1_3_1; }

		//error=ThenEvidenceExpr
		public Assignment getErrorAssignment_1_1_1_3_2() { return cErrorAssignment_1_1_1_3_2; }

		//ThenEvidenceExpr
		public RuleCall getErrorThenEvidenceExprParserRuleCall_1_1_1_3_2_0() { return cErrorThenEvidenceExprParserRuleCall_1_1_1_3_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_1_1_1_4() { return cRightSquareBracketKeyword_1_1_1_4; }
	}

	public class CompositeElseEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.CompositeElseEvidenceExpr");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cCompositeEvidenceExprParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Group cGroup_1_0 = (Group)cGroup_1.eContents().get(0);
		private final Group cGroup_1_0_0 = (Group)cGroup_1_0.eContents().get(0);
		private final Action cElseExprLeftAction_1_0_0_0 = (Action)cGroup_1_0_0.eContents().get(0);
		private final Keyword cElseKeyword_1_0_0_1 = (Keyword)cGroup_1_0_0.eContents().get(1);
		private final Assignment cErrorAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cErrorElseEvidenceExprParserRuleCall_1_1_0 = (RuleCall)cErrorAssignment_1_1.eContents().get(0);
		
		//CompositeElseEvidenceExpr ArgumentExpr:
		//	CompositeEvidenceExpr (=> ({ElseExpr.left=current} 'else') error=ElseEvidenceExpr)*;
		@Override public ParserRule getRule() { return rule; }

		//CompositeEvidenceExpr (=> ({ElseExpr.left=current} 'else') error=ElseEvidenceExpr)*
		public Group getGroup() { return cGroup; }

		//CompositeEvidenceExpr
		public RuleCall getCompositeEvidenceExprParserRuleCall_0() { return cCompositeEvidenceExprParserRuleCall_0; }

		//(=> ({ElseExpr.left=current} 'else') error=ElseEvidenceExpr)*
		public Group getGroup_1() { return cGroup_1; }

		//=> ({ElseExpr.left=current} 'else')
		public Group getGroup_1_0() { return cGroup_1_0; }

		//({ElseExpr.left=current} 'else')
		public Group getGroup_1_0_0() { return cGroup_1_0_0; }

		//{ElseExpr.left=current}
		public Action getElseExprLeftAction_1_0_0_0() { return cElseExprLeftAction_1_0_0_0; }

		//'else'
		public Keyword getElseKeyword_1_0_0_1() { return cElseKeyword_1_0_0_1; }

		//error=ElseEvidenceExpr
		public Assignment getErrorAssignment_1_1() { return cErrorAssignment_1_1; }

		//ElseEvidenceExpr
		public RuleCall getErrorElseEvidenceExprParserRuleCall_1_1_0() { return cErrorElseEvidenceExprParserRuleCall_1_1_0; }
	}

	public class QuantifiedEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.QuantifiedEvidenceExpr");
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
		
		//QuantifiedEvidenceExpr ArgumentExpr:
		//	'all' {AllExpr} '[' elements+=ThenEvidenceExpr (',' elements+=ThenEvidenceExpr)* ']';
		@Override public ParserRule getRule() { return rule; }

		//'all' {AllExpr} '[' elements+=ThenEvidenceExpr (',' elements+=ThenEvidenceExpr)* ']'
		public Group getGroup() { return cGroup; }

		//'all'
		public Keyword getAllKeyword_0() { return cAllKeyword_0; }

		//{AllExpr}
		public Action getAllExprAction_1() { return cAllExprAction_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//elements+=ThenEvidenceExpr
		public Assignment getElementsAssignment_3() { return cElementsAssignment_3; }

		//ThenEvidenceExpr
		public RuleCall getElementsThenEvidenceExprParserRuleCall_3_0() { return cElementsThenEvidenceExprParserRuleCall_3_0; }

		//(',' elements+=ThenEvidenceExpr)*
		public Group getGroup_4() { return cGroup_4; }

		//','
		public Keyword getCommaKeyword_4_0() { return cCommaKeyword_4_0; }

		//elements+=ThenEvidenceExpr
		public Assignment getElementsAssignment_4_1() { return cElementsAssignment_4_1; }

		//ThenEvidenceExpr
		public RuleCall getElementsThenEvidenceExprParserRuleCall_4_1_0() { return cElementsThenEvidenceExprParserRuleCall_4_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class CompositeEvidenceExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.CompositeEvidenceExpr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cAlternatives.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final RuleCall cThenEvidenceExprParserRuleCall_0_1 = (RuleCall)cGroup_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final RuleCall cQuantifiedEvidenceExprParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//CompositeEvidenceExpr ArgumentExpr:
		//	'(' ThenEvidenceExpr ')' | QuantifiedEvidenceExpr;
		@Override public ParserRule getRule() { return rule; }

		//'(' ThenEvidenceExpr ')' | QuantifiedEvidenceExpr
		public Alternatives getAlternatives() { return cAlternatives; }

		//'(' ThenEvidenceExpr ')'
		public Group getGroup_0() { return cGroup_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_0_0() { return cLeftParenthesisKeyword_0_0; }

		//ThenEvidenceExpr
		public RuleCall getThenEvidenceExprParserRuleCall_0_1() { return cThenEvidenceExprParserRuleCall_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_0_2() { return cRightParenthesisKeyword_0_2; }

		//QuantifiedEvidenceExpr
		public RuleCall getQuantifiedEvidenceExprParserRuleCall_1() { return cQuantifiedEvidenceExprParserRuleCall_1; }
	}

	public class VAReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.VAReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRefExprAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cVerificationAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cVerificationVerificationActivityCrossReference_1_0 = (CrossReference)cVerificationAssignment_1.eContents().get(0);
		private final RuleCall cVerificationVerificationActivityIDTerminalRuleCall_1_0_1 = (RuleCall)cVerificationVerificationActivityCrossReference_1_0.eContents().get(1);
		
		//VAReference ArgumentExpr:
		//	{RefExpr} verification=[VerificationActivity];
		@Override public ParserRule getRule() { return rule; }

		//{RefExpr} verification=[VerificationActivity]
		public Group getGroup() { return cGroup; }

		//{RefExpr}
		public Action getRefExprAction_0() { return cRefExprAction_0; }

		//verification=[VerificationActivity]
		public Assignment getVerificationAssignment_1() { return cVerificationAssignment_1; }

		//[VerificationActivity]
		public CrossReference getVerificationVerificationActivityCrossReference_1_0() { return cVerificationVerificationActivityCrossReference_1_0; }

		//ID
		public RuleCall getVerificationVerificationActivityIDTerminalRuleCall_1_0_1() { return cVerificationVerificationActivityIDTerminalRuleCall_1_0_1; }
	}

	public class ComputeRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.ComputeRef");
		private final Assignment cComputeAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cComputeComputeDeclarationCrossReference_0 = (CrossReference)cComputeAssignment.eContents().get(0);
		private final RuleCall cComputeComputeDeclarationIDTerminalRuleCall_0_1 = (RuleCall)cComputeComputeDeclarationCrossReference_0.eContents().get(1);
		
		//ComputeRef:
		//	compute=[common::ComputeDeclaration];
		@Override public ParserRule getRule() { return rule; }

		//compute=[common::ComputeDeclaration]
		public Assignment getComputeAssignment() { return cComputeAssignment; }

		//[common::ComputeDeclaration]
		public CrossReference getComputeComputeDeclarationCrossReference_0() { return cComputeComputeDeclarationCrossReference_0; }

		//ID
		public RuleCall getComputeComputeDeclarationIDTerminalRuleCall_0_1() { return cComputeComputeDeclarationIDTerminalRuleCall_0_1; }
	}

	public class VerificationActivityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.VerificationActivity");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cColonKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cTitleAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_1_1_0 = (RuleCall)cTitleAssignment_1_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cComputesAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cComputesComputeRefParserRuleCall_3_0_0 = (RuleCall)cComputesAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cComputesAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cComputesComputeRefParserRuleCall_3_1_1_0 = (RuleCall)cComputesAssignment_3_1_1.eContents().get(0);
		private final Keyword cEqualsSignKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Assignment cMethodAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cMethodVerificationMethodCrossReference_4_0 = (CrossReference)cMethodAssignment_4.eContents().get(0);
		private final RuleCall cMethodVerificationMethodQualifiedNameParserRuleCall_4_0_1 = (RuleCall)cMethodVerificationMethodCrossReference_4_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Assignment cActualsAssignment_6_0 = (Assignment)cGroup_6.eContents().get(0);
		private final RuleCall cActualsAExpressionParserRuleCall_6_0_0 = (RuleCall)cActualsAssignment_6_0.eContents().get(0);
		private final Group cGroup_6_1 = (Group)cGroup_6.eContents().get(1);
		private final Keyword cCommaKeyword_6_1_0 = (Keyword)cGroup_6_1.eContents().get(0);
		private final Assignment cActualsAssignment_6_1_1 = (Assignment)cGroup_6_1.eContents().get(1);
		private final RuleCall cActualsAExpressionParserRuleCall_6_1_1_0 = (RuleCall)cActualsAssignment_6_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final Group cGroup_8 = (Group)cGroup.eContents().get(8);
		private final Keyword cPropertyKeyword_8_0 = (Keyword)cGroup_8.eContents().get(0);
		private final Keyword cValuesKeyword_8_1 = (Keyword)cGroup_8.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_8_2 = (Keyword)cGroup_8.eContents().get(2);
		private final Group cGroup_8_3 = (Group)cGroup_8.eContents().get(3);
		private final Assignment cPropertyValuesAssignment_8_3_0 = (Assignment)cGroup_8_3.eContents().get(0);
		private final RuleCall cPropertyValuesAExpressionParserRuleCall_8_3_0_0 = (RuleCall)cPropertyValuesAssignment_8_3_0.eContents().get(0);
		private final Group cGroup_8_3_1 = (Group)cGroup_8_3.eContents().get(1);
		private final Keyword cCommaKeyword_8_3_1_0 = (Keyword)cGroup_8_3_1.eContents().get(0);
		private final Assignment cPropertyValuesAssignment_8_3_1_1 = (Assignment)cGroup_8_3_1.eContents().get(1);
		private final RuleCall cPropertyValuesAExpressionParserRuleCall_8_3_1_1_0 = (RuleCall)cPropertyValuesAssignment_8_3_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_8_4 = (Keyword)cGroup_8.eContents().get(4);
		private final Group cGroup_9 = (Group)cGroup.eContents().get(9);
		private final Keyword cLeftSquareBracketKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final UnorderedGroup cUnorderedGroup_9_1 = (UnorderedGroup)cGroup_9.eContents().get(1);
		private final Group cGroup_9_1_0 = (Group)cUnorderedGroup_9_1.eContents().get(0);
		private final Keyword cCategoryKeyword_9_1_0_0 = (Keyword)cGroup_9_1_0.eContents().get(0);
		private final Assignment cCategoryAssignment_9_1_0_1 = (Assignment)cGroup_9_1_0.eContents().get(1);
		private final CrossReference cCategoryCategoryCrossReference_9_1_0_1_0 = (CrossReference)cCategoryAssignment_9_1_0_1.eContents().get(0);
		private final RuleCall cCategoryCategoryQualifiedNameParserRuleCall_9_1_0_1_0_1 = (RuleCall)cCategoryCategoryCrossReference_9_1_0_1_0.eContents().get(1);
		private final Group cGroup_9_1_1 = (Group)cUnorderedGroup_9_1.eContents().get(1);
		private final Keyword cTimeoutKeyword_9_1_1_0 = (Keyword)cGroup_9_1_1.eContents().get(0);
		private final Assignment cTimeoutAssignment_9_1_1_1 = (Assignment)cGroup_9_1_1.eContents().get(1);
		private final RuleCall cTimeoutAIntegerTermParserRuleCall_9_1_1_1_0 = (RuleCall)cTimeoutAssignment_9_1_1_1.eContents().get(0);
		private final Group cGroup_9_1_2 = (Group)cUnorderedGroup_9_1.eContents().get(2);
		private final Keyword cWeightKeyword_9_1_2_0 = (Keyword)cGroup_9_1_2.eContents().get(0);
		private final Assignment cWeightAssignment_9_1_2_1 = (Assignment)cGroup_9_1_2.eContents().get(1);
		private final RuleCall cWeightINTTerminalRuleCall_9_1_2_1_0 = (RuleCall)cWeightAssignment_9_1_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_9_2 = (Keyword)cGroup_9.eContents().get(2);
		
		//VerificationActivity:
		//	name=ID (':' title=STRING)?
		//	':' (computes+=ComputeRef (',' computes+=ComputeRef)* '=')?
		//	method=[VerificationMethod|QualifiedName]
		//	//	'(' (parameters+=[common::ValDeclaration|ID] (',' parameters+=[common::ValDeclaration|ID])*)? ')' 
		//	'(' (actuals+=AExpression (',' actuals+=AExpression)*)? ')' ('property' 'values' '(' (propertyValues+=AExpression (','
		//	propertyValues+=AExpression)*)?
		//	')')? ('[' (('category' category+=[categories::Category|QualifiedName]+)?
		//	& ('timeout' timeout=AIntegerTerm)?
		//	& ('weight' weight=INT)?) ']')?;
		@Override public ParserRule getRule() { return rule; }

		//name=ID (':' title=STRING)? ':' (computes+=ComputeRef (',' computes+=ComputeRef)* '=')?
		//method=[VerificationMethod|QualifiedName] //	'(' (parameters+=[common::ValDeclaration|ID] (',' parameters+=[common::ValDeclaration|ID])*)? ')' 
		//'(' (actuals+=AExpression (',' actuals+=AExpression)*)? ')' ('property' 'values' '(' (propertyValues+=AExpression (','
		//propertyValues+=AExpression)*)? ')')? ('[' (('category' category+=[categories::Category|QualifiedName]+)? & ('timeout'
		//timeout=AIntegerTerm)? & ('weight' weight=INT)?) ']')?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//(':' title=STRING)?
		public Group getGroup_1() { return cGroup_1; }

		//':'
		public Keyword getColonKeyword_1_0() { return cColonKeyword_1_0; }

		//title=STRING
		public Assignment getTitleAssignment_1_1() { return cTitleAssignment_1_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_1_1_0() { return cTitleSTRINGTerminalRuleCall_1_1_0; }

		//':'
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//(computes+=ComputeRef (',' computes+=ComputeRef)* '=')?
		public Group getGroup_3() { return cGroup_3; }

		//computes+=ComputeRef
		public Assignment getComputesAssignment_3_0() { return cComputesAssignment_3_0; }

		//ComputeRef
		public RuleCall getComputesComputeRefParserRuleCall_3_0_0() { return cComputesComputeRefParserRuleCall_3_0_0; }

		//(',' computes+=ComputeRef)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//','
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//computes+=ComputeRef
		public Assignment getComputesAssignment_3_1_1() { return cComputesAssignment_3_1_1; }

		//ComputeRef
		public RuleCall getComputesComputeRefParserRuleCall_3_1_1_0() { return cComputesComputeRefParserRuleCall_3_1_1_0; }

		//'='
		public Keyword getEqualsSignKeyword_3_2() { return cEqualsSignKeyword_3_2; }

		//method=[VerificationMethod|QualifiedName]
		public Assignment getMethodAssignment_4() { return cMethodAssignment_4; }

		//[VerificationMethod|QualifiedName]
		public CrossReference getMethodVerificationMethodCrossReference_4_0() { return cMethodVerificationMethodCrossReference_4_0; }

		//QualifiedName
		public RuleCall getMethodVerificationMethodQualifiedNameParserRuleCall_4_0_1() { return cMethodVerificationMethodQualifiedNameParserRuleCall_4_0_1; }

		////	'(' (parameters+=[common::ValDeclaration|ID] (',' parameters+=[common::ValDeclaration|ID])*)? ')' 
		//'('
		public Keyword getLeftParenthesisKeyword_5() { return cLeftParenthesisKeyword_5; }

		//(actuals+=AExpression (',' actuals+=AExpression)*)?
		public Group getGroup_6() { return cGroup_6; }

		//actuals+=AExpression
		public Assignment getActualsAssignment_6_0() { return cActualsAssignment_6_0; }

		//AExpression
		public RuleCall getActualsAExpressionParserRuleCall_6_0_0() { return cActualsAExpressionParserRuleCall_6_0_0; }

		//(',' actuals+=AExpression)*
		public Group getGroup_6_1() { return cGroup_6_1; }

		//','
		public Keyword getCommaKeyword_6_1_0() { return cCommaKeyword_6_1_0; }

		//actuals+=AExpression
		public Assignment getActualsAssignment_6_1_1() { return cActualsAssignment_6_1_1; }

		//AExpression
		public RuleCall getActualsAExpressionParserRuleCall_6_1_1_0() { return cActualsAExpressionParserRuleCall_6_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_7() { return cRightParenthesisKeyword_7; }

		//('property' 'values' '(' (propertyValues+=AExpression (',' propertyValues+=AExpression)*)? ')')?
		public Group getGroup_8() { return cGroup_8; }

		//'property'
		public Keyword getPropertyKeyword_8_0() { return cPropertyKeyword_8_0; }

		//'values'
		public Keyword getValuesKeyword_8_1() { return cValuesKeyword_8_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_8_2() { return cLeftParenthesisKeyword_8_2; }

		//(propertyValues+=AExpression (',' propertyValues+=AExpression)*)?
		public Group getGroup_8_3() { return cGroup_8_3; }

		//propertyValues+=AExpression
		public Assignment getPropertyValuesAssignment_8_3_0() { return cPropertyValuesAssignment_8_3_0; }

		//AExpression
		public RuleCall getPropertyValuesAExpressionParserRuleCall_8_3_0_0() { return cPropertyValuesAExpressionParserRuleCall_8_3_0_0; }

		//(',' propertyValues+=AExpression)*
		public Group getGroup_8_3_1() { return cGroup_8_3_1; }

		//','
		public Keyword getCommaKeyword_8_3_1_0() { return cCommaKeyword_8_3_1_0; }

		//propertyValues+=AExpression
		public Assignment getPropertyValuesAssignment_8_3_1_1() { return cPropertyValuesAssignment_8_3_1_1; }

		//AExpression
		public RuleCall getPropertyValuesAExpressionParserRuleCall_8_3_1_1_0() { return cPropertyValuesAExpressionParserRuleCall_8_3_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_8_4() { return cRightParenthesisKeyword_8_4; }

		//('[' (('category' category+=[categories::Category|QualifiedName]+)? & ('timeout' timeout=AIntegerTerm)? & ('weight'
		//weight=INT)?) ']')?
		public Group getGroup_9() { return cGroup_9; }

		//'['
		public Keyword getLeftSquareBracketKeyword_9_0() { return cLeftSquareBracketKeyword_9_0; }

		//(('category' category+=[categories::Category|QualifiedName]+)? & ('timeout' timeout=AIntegerTerm)? & ('weight'
		//weight=INT)?)
		public UnorderedGroup getUnorderedGroup_9_1() { return cUnorderedGroup_9_1; }

		//('category' category+=[categories::Category|QualifiedName]+)?
		public Group getGroup_9_1_0() { return cGroup_9_1_0; }

		//'category'
		public Keyword getCategoryKeyword_9_1_0_0() { return cCategoryKeyword_9_1_0_0; }

		//category+=[categories::Category|QualifiedName]+
		public Assignment getCategoryAssignment_9_1_0_1() { return cCategoryAssignment_9_1_0_1; }

		//[categories::Category|QualifiedName]
		public CrossReference getCategoryCategoryCrossReference_9_1_0_1_0() { return cCategoryCategoryCrossReference_9_1_0_1_0; }

		//QualifiedName
		public RuleCall getCategoryCategoryQualifiedNameParserRuleCall_9_1_0_1_0_1() { return cCategoryCategoryQualifiedNameParserRuleCall_9_1_0_1_0_1; }

		//('timeout' timeout=AIntegerTerm)?
		public Group getGroup_9_1_1() { return cGroup_9_1_1; }

		//'timeout'
		public Keyword getTimeoutKeyword_9_1_1_0() { return cTimeoutKeyword_9_1_1_0; }

		//timeout=AIntegerTerm
		public Assignment getTimeoutAssignment_9_1_1_1() { return cTimeoutAssignment_9_1_1_1; }

		//AIntegerTerm
		public RuleCall getTimeoutAIntegerTermParserRuleCall_9_1_1_1_0() { return cTimeoutAIntegerTermParserRuleCall_9_1_1_1_0; }

		//('weight' weight=INT)?
		public Group getGroup_9_1_2() { return cGroup_9_1_2; }

		//'weight'
		public Keyword getWeightKeyword_9_1_2_0() { return cWeightKeyword_9_1_2_0; }

		//weight=INT
		public Assignment getWeightAssignment_9_1_2_1() { return cWeightAssignment_9_1_2_1; }

		//INT
		public RuleCall getWeightINTTerminalRuleCall_9_1_2_1_0() { return cWeightINTTerminalRuleCall_9_1_2_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_9_2() { return cRightSquareBracketKeyword_9_2; }
	}

	public class VerificationValidationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.VerificationValidation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cValidationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cVerificationValidationAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cMethodAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cMethodVerificationMethodCrossReference_2_0 = (CrossReference)cMethodAssignment_2.eContents().get(0);
		private final RuleCall cMethodVerificationMethodQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cMethodVerificationMethodCrossReference_2_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cParametersAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final CrossReference cParametersFormalParameterCrossReference_4_0_0 = (CrossReference)cParametersAssignment_4_0.eContents().get(0);
		private final RuleCall cParametersFormalParameterIDTerminalRuleCall_4_0_0_1 = (RuleCall)cParametersFormalParameterCrossReference_4_0_0.eContents().get(1);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cParametersAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final CrossReference cParametersFormalParameterCrossReference_4_1_1_0 = (CrossReference)cParametersAssignment_4_1_1.eContents().get(0);
		private final RuleCall cParametersFormalParameterIDTerminalRuleCall_4_1_1_0_1 = (RuleCall)cParametersFormalParameterCrossReference_4_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//VerificationValidation VerificationCondition:
		//	'validation' {VerificationValidation} method=[VerificationMethod|QualifiedName]
		//	'(' (parameters+=[FormalParameter] (',' parameters+=[FormalParameter])*)? ')';
		@Override public ParserRule getRule() { return rule; }

		//'validation' {VerificationValidation} method=[VerificationMethod|QualifiedName] '(' (parameters+=[FormalParameter] (','
		//parameters+=[FormalParameter])*)? ')'
		public Group getGroup() { return cGroup; }

		//'validation'
		public Keyword getValidationKeyword_0() { return cValidationKeyword_0; }

		//{VerificationValidation}
		public Action getVerificationValidationAction_1() { return cVerificationValidationAction_1; }

		//method=[VerificationMethod|QualifiedName]
		public Assignment getMethodAssignment_2() { return cMethodAssignment_2; }

		//[VerificationMethod|QualifiedName]
		public CrossReference getMethodVerificationMethodCrossReference_2_0() { return cMethodVerificationMethodCrossReference_2_0; }

		//QualifiedName
		public RuleCall getMethodVerificationMethodQualifiedNameParserRuleCall_2_0_1() { return cMethodVerificationMethodQualifiedNameParserRuleCall_2_0_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//(parameters+=[FormalParameter] (',' parameters+=[FormalParameter])*)?
		public Group getGroup_4() { return cGroup_4; }

		//parameters+=[FormalParameter]
		public Assignment getParametersAssignment_4_0() { return cParametersAssignment_4_0; }

		//[FormalParameter]
		public CrossReference getParametersFormalParameterCrossReference_4_0_0() { return cParametersFormalParameterCrossReference_4_0_0; }

		//ID
		public RuleCall getParametersFormalParameterIDTerminalRuleCall_4_0_0_1() { return cParametersFormalParameterIDTerminalRuleCall_4_0_0_1; }

		//(',' parameters+=[FormalParameter])*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//parameters+=[FormalParameter]
		public Assignment getParametersAssignment_4_1_1() { return cParametersAssignment_4_1_1; }

		//[FormalParameter]
		public CrossReference getParametersFormalParameterCrossReference_4_1_1_0() { return cParametersFormalParameterCrossReference_4_1_1_0; }

		//ID
		public RuleCall getParametersFormalParameterIDTerminalRuleCall_4_1_1_0_1() { return cParametersFormalParameterIDTerminalRuleCall_4_1_1_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}

	public class VerificationPreconditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.VerificationPrecondition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPreconditionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cVerificationPreconditionAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cMethodAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cMethodVerificationMethodCrossReference_2_0 = (CrossReference)cMethodAssignment_2.eContents().get(0);
		private final RuleCall cMethodVerificationMethodQualifiedNameParserRuleCall_2_0_1 = (RuleCall)cMethodVerificationMethodCrossReference_2_0.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Assignment cParametersAssignment_4_0 = (Assignment)cGroup_4.eContents().get(0);
		private final CrossReference cParametersFormalParameterCrossReference_4_0_0 = (CrossReference)cParametersAssignment_4_0.eContents().get(0);
		private final RuleCall cParametersFormalParameterIDTerminalRuleCall_4_0_0_1 = (RuleCall)cParametersFormalParameterCrossReference_4_0_0.eContents().get(1);
		private final Group cGroup_4_1 = (Group)cGroup_4.eContents().get(1);
		private final Keyword cCommaKeyword_4_1_0 = (Keyword)cGroup_4_1.eContents().get(0);
		private final Assignment cParametersAssignment_4_1_1 = (Assignment)cGroup_4_1.eContents().get(1);
		private final CrossReference cParametersFormalParameterCrossReference_4_1_1_0 = (CrossReference)cParametersAssignment_4_1_1.eContents().get(0);
		private final RuleCall cParametersFormalParameterIDTerminalRuleCall_4_1_1_0_1 = (RuleCall)cParametersFormalParameterCrossReference_4_1_1_0.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//VerificationPrecondition VerificationCondition:
		//	'precondition' {VerificationPrecondition} method=[VerificationMethod|QualifiedName]
		//	'(' (parameters+=[FormalParameter] (',' parameters+=[FormalParameter])*)? ')';
		@Override public ParserRule getRule() { return rule; }

		//'precondition' {VerificationPrecondition} method=[VerificationMethod|QualifiedName] '(' (parameters+=[FormalParameter]
		//(',' parameters+=[FormalParameter])*)? ')'
		public Group getGroup() { return cGroup; }

		//'precondition'
		public Keyword getPreconditionKeyword_0() { return cPreconditionKeyword_0; }

		//{VerificationPrecondition}
		public Action getVerificationPreconditionAction_1() { return cVerificationPreconditionAction_1; }

		//method=[VerificationMethod|QualifiedName]
		public Assignment getMethodAssignment_2() { return cMethodAssignment_2; }

		//[VerificationMethod|QualifiedName]
		public CrossReference getMethodVerificationMethodCrossReference_2_0() { return cMethodVerificationMethodCrossReference_2_0; }

		//QualifiedName
		public RuleCall getMethodVerificationMethodQualifiedNameParserRuleCall_2_0_1() { return cMethodVerificationMethodQualifiedNameParserRuleCall_2_0_1; }

		//'('
		public Keyword getLeftParenthesisKeyword_3() { return cLeftParenthesisKeyword_3; }

		//(parameters+=[FormalParameter] (',' parameters+=[FormalParameter])*)?
		public Group getGroup_4() { return cGroup_4; }

		//parameters+=[FormalParameter]
		public Assignment getParametersAssignment_4_0() { return cParametersAssignment_4_0; }

		//[FormalParameter]
		public CrossReference getParametersFormalParameterCrossReference_4_0_0() { return cParametersFormalParameterCrossReference_4_0_0; }

		//ID
		public RuleCall getParametersFormalParameterIDTerminalRuleCall_4_0_0_1() { return cParametersFormalParameterIDTerminalRuleCall_4_0_0_1; }

		//(',' parameters+=[FormalParameter])*
		public Group getGroup_4_1() { return cGroup_4_1; }

		//','
		public Keyword getCommaKeyword_4_1_0() { return cCommaKeyword_4_1_0; }

		//parameters+=[FormalParameter]
		public Assignment getParametersAssignment_4_1_1() { return cParametersAssignment_4_1_1; }

		//[FormalParameter]
		public CrossReference getParametersFormalParameterCrossReference_4_1_1_0() { return cParametersFormalParameterCrossReference_4_1_1_0; }

		//ID
		public RuleCall getParametersFormalParameterIDTerminalRuleCall_4_1_1_0_1() { return cParametersFormalParameterIDTerminalRuleCall_4_1_1_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_5() { return cRightParenthesisKeyword_5; }
	}

	public class VerificationMethodRegistryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.VerificationMethodRegistry");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVerificationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cMethodsKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameQualifiedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
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
		//	'verification' 'methods' name=QualifiedName (':' title=STRING)?
		//	//	( 'for' (target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ ))?
		//	'[' (description=Description?
		//	methods+=VerificationMethod*)
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'verification' 'methods' name=QualifiedName (':' title=STRING)? //	( 'for' (target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ ))?
		//'[' (description=Description? methods+=VerificationMethod*) ']'
		public Group getGroup() { return cGroup; }

		//'verification'
		public Keyword getVerificationKeyword_0() { return cVerificationKeyword_0; }

		//'methods'
		public Keyword getMethodsKeyword_1() { return cMethodsKeyword_1; }

		//name=QualifiedName
		public Assignment getNameAssignment_2() { return cNameAssignment_2; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_2_0() { return cNameQualifiedNameParserRuleCall_2_0; }

		//(':' title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		////	( 'for' (target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ ))?
		//'['
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//(description=Description? methods+=VerificationMethod*)
		public Group getGroup_5() { return cGroup_5; }

		//description=Description?
		public Assignment getDescriptionAssignment_5_0() { return cDescriptionAssignment_5_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_5_0_0() { return cDescriptionDescriptionParserRuleCall_5_0_0; }

		//methods+=VerificationMethod*
		public Assignment getMethodsAssignment_5_1() { return cMethodsAssignment_5_1; }

		//VerificationMethod
		public RuleCall getMethodsVerificationMethodParserRuleCall_5_1_0() { return cMethodsVerificationMethodParserRuleCall_5_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class FormalParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.FormalParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cColonKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cTypeAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final RuleCall cTypeTypeRefParserRuleCall_2_0_0 = (RuleCall)cTypeAssignment_2_0.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cAlternatives_2.eContents().get(1);
		private final Keyword cTypeofKeyword_2_1_0 = (Keyword)cGroup_2_1.eContents().get(0);
		private final Assignment cTypeAssignment_2_1_1 = (Assignment)cGroup_2_1.eContents().get(1);
		private final RuleCall cTypePropertyRefParserRuleCall_2_1_1_0 = (RuleCall)cTypeAssignment_2_1_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cInKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cUnitAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cUnitUnitLiteralCrossReference_3_1_0 = (CrossReference)cUnitAssignment_3_1.eContents().get(0);
		private final RuleCall cUnitUnitLiteralIDTerminalRuleCall_3_1_0_1 = (RuleCall)cUnitUnitLiteralCrossReference_3_1_0.eContents().get(1);
		
		//FormalParameter:
		//	name=ID ':' (type=TypeRef | 'typeof' type=PropertyRef) ('in' unit=[aadl2::UnitLiteral])?;
		@Override public ParserRule getRule() { return rule; }

		//name=ID ':' (type=TypeRef | 'typeof' type=PropertyRef) ('in' unit=[aadl2::UnitLiteral])?
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//':'
		public Keyword getColonKeyword_1() { return cColonKeyword_1; }

		//(type=TypeRef | 'typeof' type=PropertyRef)
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//type=TypeRef
		public Assignment getTypeAssignment_2_0() { return cTypeAssignment_2_0; }

		//TypeRef
		public RuleCall getTypeTypeRefParserRuleCall_2_0_0() { return cTypeTypeRefParserRuleCall_2_0_0; }

		//'typeof' type=PropertyRef
		public Group getGroup_2_1() { return cGroup_2_1; }

		//'typeof'
		public Keyword getTypeofKeyword_2_1_0() { return cTypeofKeyword_2_1_0; }

		//type=PropertyRef
		public Assignment getTypeAssignment_2_1_1() { return cTypeAssignment_2_1_1; }

		//PropertyRef
		public RuleCall getTypePropertyRefParserRuleCall_2_1_1_0() { return cTypePropertyRefParserRuleCall_2_1_1_0; }

		//('in' unit=[aadl2::UnitLiteral])?
		public Group getGroup_3() { return cGroup_3; }

		//'in'
		public Keyword getInKeyword_3_0() { return cInKeyword_3_0; }

		//unit=[aadl2::UnitLiteral]
		public Assignment getUnitAssignment_3_1() { return cUnitAssignment_3_1; }

		//[aadl2::UnitLiteral]
		public CrossReference getUnitUnitLiteralCrossReference_3_1_0() { return cUnitUnitLiteralCrossReference_3_1_0; }

		//ID
		public RuleCall getUnitUnitLiteralIDTerminalRuleCall_3_1_0_1() { return cUnitUnitLiteralIDTerminalRuleCall_3_1_0_1; }
	}

	public class VerificationMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.VerificationMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cMethodKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Alternatives cAlternatives_2_1 = (Alternatives)cGroup_2.eContents().get(1);
		private final Assignment cTargetTypeAssignment_2_1_0 = (Assignment)cAlternatives_2_1.eContents().get(0);
		private final RuleCall cTargetTypeTargetTypeEnumRuleCall_2_1_0_0 = (RuleCall)cTargetTypeAssignment_2_1_0.eContents().get(0);
		private final Group cGroup_2_1_1 = (Group)cAlternatives_2_1.eContents().get(1);
		private final Assignment cFormalsAssignment_2_1_1_0 = (Assignment)cGroup_2_1_1.eContents().get(0);
		private final RuleCall cFormalsFormalParameterParserRuleCall_2_1_1_0_0 = (RuleCall)cFormalsAssignment_2_1_1_0.eContents().get(0);
		private final Group cGroup_2_1_1_1 = (Group)cGroup_2_1_1.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_1_1_0 = (Keyword)cGroup_2_1_1_1.eContents().get(0);
		private final Assignment cFormalsAssignment_2_1_1_1_1 = (Assignment)cGroup_2_1_1_1.eContents().get(1);
		private final RuleCall cFormalsFormalParameterParserRuleCall_2_1_1_1_1_0 = (RuleCall)cFormalsAssignment_2_1_1_1_1.eContents().get(0);
		private final Group cGroup_2_1_2 = (Group)cAlternatives_2_1.eContents().get(2);
		private final Assignment cTargetTypeAssignment_2_1_2_0 = (Assignment)cGroup_2_1_2.eContents().get(0);
		private final RuleCall cTargetTypeTargetTypeEnumRuleCall_2_1_2_0_0 = (RuleCall)cTargetTypeAssignment_2_1_2_0.eContents().get(0);
		private final Keyword cCommaKeyword_2_1_2_1 = (Keyword)cGroup_2_1_2.eContents().get(1);
		private final Assignment cFormalsAssignment_2_1_2_2 = (Assignment)cGroup_2_1_2.eContents().get(2);
		private final RuleCall cFormalsFormalParameterParserRuleCall_2_1_2_2_0 = (RuleCall)cFormalsAssignment_2_1_2_2.eContents().get(0);
		private final Group cGroup_2_1_2_3 = (Group)cGroup_2_1_2.eContents().get(3);
		private final Keyword cCommaKeyword_2_1_2_3_0 = (Keyword)cGroup_2_1_2_3.eContents().get(0);
		private final Assignment cFormalsAssignment_2_1_2_3_1 = (Assignment)cGroup_2_1_2_3.eContents().get(1);
		private final RuleCall cFormalsFormalParameterParserRuleCall_2_1_2_3_1_0 = (RuleCall)cFormalsAssignment_2_1_2_3_1.eContents().get(0);
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
		private final Group cGroup_2_4 = (Group)cGroup_2.eContents().get(4);
		private final Keyword cReturnsKeyword_2_4_0 = (Keyword)cGroup_2_4.eContents().get(0);
		private final Keyword cLeftParenthesisKeyword_2_4_1 = (Keyword)cGroup_2_4.eContents().get(1);
		private final Group cGroup_2_4_2 = (Group)cGroup_2_4.eContents().get(2);
		private final Assignment cResultsAssignment_2_4_2_0 = (Assignment)cGroup_2_4_2.eContents().get(0);
		private final RuleCall cResultsFormalParameterParserRuleCall_2_4_2_0_0 = (RuleCall)cResultsAssignment_2_4_2_0.eContents().get(0);
		private final Group cGroup_2_4_2_1 = (Group)cGroup_2_4_2.eContents().get(1);
		private final Keyword cCommaKeyword_2_4_2_1_0 = (Keyword)cGroup_2_4_2_1.eContents().get(0);
		private final Assignment cResultsAssignment_2_4_2_1_1 = (Assignment)cGroup_2_4_2_1.eContents().get(1);
		private final RuleCall cResultsFormalParameterParserRuleCall_2_4_2_1_1_0 = (RuleCall)cResultsAssignment_2_4_2_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_4_3 = (Keyword)cGroup_2_4.eContents().get(3);
		private final Alternatives cAlternatives_2_5 = (Alternatives)cGroup_2.eContents().get(5);
		private final Assignment cIsPredicateAssignment_2_5_0 = (Assignment)cAlternatives_2_5.eContents().get(0);
		private final Keyword cIsPredicateBooleanKeyword_2_5_0_0 = (Keyword)cIsPredicateAssignment_2_5_0.eContents().get(0);
		private final Assignment cIsResultReportAssignment_2_5_1 = (Assignment)cAlternatives_2_5.eContents().get(1);
		private final Keyword cIsResultReportReportKeyword_2_5_1_0 = (Keyword)cIsResultReportAssignment_2_5_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cForKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Alternatives cAlternatives_4_1 = (Alternatives)cGroup_4.eContents().get(1);
		private final Assignment cTargetAssignment_4_1_0 = (Assignment)cAlternatives_4_1.eContents().get(0);
		private final CrossReference cTargetComponentClassifierCrossReference_4_1_0_0 = (CrossReference)cTargetAssignment_4_1_0.eContents().get(0);
		private final RuleCall cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1 = (RuleCall)cTargetComponentClassifierCrossReference_4_1_0_0.eContents().get(1);
		private final Assignment cComponentCategoryAssignment_4_1_1 = (Assignment)cAlternatives_4_1.eContents().get(1);
		private final RuleCall cComponentCategoryComponentCategoryParserRuleCall_4_1_1_0 = (RuleCall)cComponentCategoryAssignment_4_1_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final UnorderedGroup cUnorderedGroup_6 = (UnorderedGroup)cGroup.eContents().get(6);
		private final Assignment cMethodKindAssignment_6_0 = (Assignment)cUnorderedGroup_6.eContents().get(0);
		private final RuleCall cMethodKindMethodKindParserRuleCall_6_0_0 = (RuleCall)cMethodKindAssignment_6_0.eContents().get(0);
		private final Assignment cDescriptionAssignment_6_1 = (Assignment)cUnorderedGroup_6.eContents().get(1);
		private final RuleCall cDescriptionDescriptionParserRuleCall_6_1_0 = (RuleCall)cDescriptionAssignment_6_1.eContents().get(0);
		private final Assignment cPreconditionAssignment_6_2 = (Assignment)cUnorderedGroup_6.eContents().get(2);
		private final RuleCall cPreconditionVerificationPreconditionParserRuleCall_6_2_0 = (RuleCall)cPreconditionAssignment_6_2.eContents().get(0);
		private final Assignment cValidationAssignment_6_3 = (Assignment)cUnorderedGroup_6.eContents().get(3);
		private final RuleCall cValidationVerificationValidationParserRuleCall_6_3_0 = (RuleCall)cValidationAssignment_6_3.eContents().get(0);
		private final Group cGroup_6_4 = (Group)cUnorderedGroup_6.eContents().get(4);
		private final Keyword cCategoryKeyword_6_4_0 = (Keyword)cGroup_6_4.eContents().get(0);
		private final Assignment cCategoryAssignment_6_4_1 = (Assignment)cGroup_6_4.eContents().get(1);
		private final CrossReference cCategoryCategoryCrossReference_6_4_1_0 = (CrossReference)cCategoryAssignment_6_4_1.eContents().get(0);
		private final RuleCall cCategoryCategoryQualifiedNameParserRuleCall_6_4_1_0_1 = (RuleCall)cCategoryCategoryCrossReference_6_4_1_0.eContents().get(1);
		private final Keyword cRightSquareBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//VerificationMethod:
		//	'method' name=ID ('(' (targetType=TargetType? | formals+=FormalParameter (',' formals+=FormalParameter)* |
		//	targetType=TargetType ',' formals+=FormalParameter (',' formals+=FormalParameter)*)
		//	')' ('properties' '(' (properties+=[aadl2::Property|AADLPROPERTYREFERENCE] (','
		//	properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
		//	')')? ('returns' '(' (results+=FormalParameter (',' results+=FormalParameter)*)?
		//	')')? (isPredicate?='boolean' | isResultReport?='report')?)? (':' title=STRING)? ('for'
		//	(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+))?
		//	'[' (methodKind=MethodKind
		//	& description=Description?
		//	& precondition=VerificationPrecondition?
		//	& validation=VerificationValidation?
		//	& ('category' category+=[categories::Category|QualifiedName]+)?)
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'method' name=ID ('(' (targetType=TargetType? | formals+=FormalParameter (',' formals+=FormalParameter)* |
		//targetType=TargetType ',' formals+=FormalParameter (',' formals+=FormalParameter)*) ')' ('properties' '('
		//(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] (',' properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)? ')')?
		//('returns' '(' (results+=FormalParameter (',' results+=FormalParameter)*)? ')')? (isPredicate?='boolean' |
		//isResultReport?='report')?)? (':' title=STRING)? ('for' (target=[aadl2::ComponentClassifier|AadlClassifierReference] |
		//componentCategory+=ComponentCategory+))? '[' (methodKind=MethodKind & description=Description? &
		//precondition=VerificationPrecondition? & validation=VerificationValidation? & ('category'
		//category+=[categories::Category|QualifiedName]+)?) ']'
		public Group getGroup() { return cGroup; }

		//'method'
		public Keyword getMethodKeyword_0() { return cMethodKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//('(' (targetType=TargetType? | formals+=FormalParameter (',' formals+=FormalParameter)* | targetType=TargetType ','
		//formals+=FormalParameter (',' formals+=FormalParameter)*) ')' ('properties' '('
		//(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] (',' properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)? ')')?
		//('returns' '(' (results+=FormalParameter (',' results+=FormalParameter)*)? ')')? (isPredicate?='boolean' |
		//isResultReport?='report')?)?
		public Group getGroup_2() { return cGroup_2; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//(targetType=TargetType? | formals+=FormalParameter (',' formals+=FormalParameter)* | targetType=TargetType ','
		//formals+=FormalParameter (',' formals+=FormalParameter)*)
		public Alternatives getAlternatives_2_1() { return cAlternatives_2_1; }

		//targetType=TargetType?
		public Assignment getTargetTypeAssignment_2_1_0() { return cTargetTypeAssignment_2_1_0; }

		//TargetType
		public RuleCall getTargetTypeTargetTypeEnumRuleCall_2_1_0_0() { return cTargetTypeTargetTypeEnumRuleCall_2_1_0_0; }

		//formals+=FormalParameter (',' formals+=FormalParameter)*
		public Group getGroup_2_1_1() { return cGroup_2_1_1; }

		//formals+=FormalParameter
		public Assignment getFormalsAssignment_2_1_1_0() { return cFormalsAssignment_2_1_1_0; }

		//FormalParameter
		public RuleCall getFormalsFormalParameterParserRuleCall_2_1_1_0_0() { return cFormalsFormalParameterParserRuleCall_2_1_1_0_0; }

		//(',' formals+=FormalParameter)*
		public Group getGroup_2_1_1_1() { return cGroup_2_1_1_1; }

		//','
		public Keyword getCommaKeyword_2_1_1_1_0() { return cCommaKeyword_2_1_1_1_0; }

		//formals+=FormalParameter
		public Assignment getFormalsAssignment_2_1_1_1_1() { return cFormalsAssignment_2_1_1_1_1; }

		//FormalParameter
		public RuleCall getFormalsFormalParameterParserRuleCall_2_1_1_1_1_0() { return cFormalsFormalParameterParserRuleCall_2_1_1_1_1_0; }

		//targetType=TargetType ',' formals+=FormalParameter (',' formals+=FormalParameter)*
		public Group getGroup_2_1_2() { return cGroup_2_1_2; }

		//targetType=TargetType
		public Assignment getTargetTypeAssignment_2_1_2_0() { return cTargetTypeAssignment_2_1_2_0; }

		//TargetType
		public RuleCall getTargetTypeTargetTypeEnumRuleCall_2_1_2_0_0() { return cTargetTypeTargetTypeEnumRuleCall_2_1_2_0_0; }

		//','
		public Keyword getCommaKeyword_2_1_2_1() { return cCommaKeyword_2_1_2_1; }

		//formals+=FormalParameter
		public Assignment getFormalsAssignment_2_1_2_2() { return cFormalsAssignment_2_1_2_2; }

		//FormalParameter
		public RuleCall getFormalsFormalParameterParserRuleCall_2_1_2_2_0() { return cFormalsFormalParameterParserRuleCall_2_1_2_2_0; }

		//(',' formals+=FormalParameter)*
		public Group getGroup_2_1_2_3() { return cGroup_2_1_2_3; }

		//','
		public Keyword getCommaKeyword_2_1_2_3_0() { return cCommaKeyword_2_1_2_3_0; }

		//formals+=FormalParameter
		public Assignment getFormalsAssignment_2_1_2_3_1() { return cFormalsAssignment_2_1_2_3_1; }

		//FormalParameter
		public RuleCall getFormalsFormalParameterParserRuleCall_2_1_2_3_1_0() { return cFormalsFormalParameterParserRuleCall_2_1_2_3_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }

		//('properties' '(' (properties+=[aadl2::Property|AADLPROPERTYREFERENCE] (','
		//properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)? ')')?
		public Group getGroup_2_3() { return cGroup_2_3; }

		//'properties'
		public Keyword getPropertiesKeyword_2_3_0() { return cPropertiesKeyword_2_3_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_3_1() { return cLeftParenthesisKeyword_2_3_1; }

		//(properties+=[aadl2::Property|AADLPROPERTYREFERENCE] (',' properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
		public Group getGroup_2_3_2() { return cGroup_2_3_2; }

		//properties+=[aadl2::Property|AADLPROPERTYREFERENCE]
		public Assignment getPropertiesAssignment_2_3_2_0() { return cPropertiesAssignment_2_3_2_0; }

		//[aadl2::Property|AADLPROPERTYREFERENCE]
		public CrossReference getPropertiesPropertyCrossReference_2_3_2_0_0() { return cPropertiesPropertyCrossReference_2_3_2_0_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_0_0_1() { return cPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_0_0_1; }

		//(',' properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*
		public Group getGroup_2_3_2_1() { return cGroup_2_3_2_1; }

		//','
		public Keyword getCommaKeyword_2_3_2_1_0() { return cCommaKeyword_2_3_2_1_0; }

		//properties+=[aadl2::Property|AADLPROPERTYREFERENCE]
		public Assignment getPropertiesAssignment_2_3_2_1_1() { return cPropertiesAssignment_2_3_2_1_1; }

		//[aadl2::Property|AADLPROPERTYREFERENCE]
		public CrossReference getPropertiesPropertyCrossReference_2_3_2_1_1_0() { return cPropertiesPropertyCrossReference_2_3_2_1_1_0; }

		//AADLPROPERTYREFERENCE
		public RuleCall getPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_1_1_0_1() { return cPropertiesPropertyAADLPROPERTYREFERENCEParserRuleCall_2_3_2_1_1_0_1; }

		//')'
		public Keyword getRightParenthesisKeyword_2_3_3() { return cRightParenthesisKeyword_2_3_3; }

		//('returns' '(' (results+=FormalParameter (',' results+=FormalParameter)*)? ')')?
		public Group getGroup_2_4() { return cGroup_2_4; }

		//'returns'
		public Keyword getReturnsKeyword_2_4_0() { return cReturnsKeyword_2_4_0; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_4_1() { return cLeftParenthesisKeyword_2_4_1; }

		//(results+=FormalParameter (',' results+=FormalParameter)*)?
		public Group getGroup_2_4_2() { return cGroup_2_4_2; }

		//results+=FormalParameter
		public Assignment getResultsAssignment_2_4_2_0() { return cResultsAssignment_2_4_2_0; }

		//FormalParameter
		public RuleCall getResultsFormalParameterParserRuleCall_2_4_2_0_0() { return cResultsFormalParameterParserRuleCall_2_4_2_0_0; }

		//(',' results+=FormalParameter)*
		public Group getGroup_2_4_2_1() { return cGroup_2_4_2_1; }

		//','
		public Keyword getCommaKeyword_2_4_2_1_0() { return cCommaKeyword_2_4_2_1_0; }

		//results+=FormalParameter
		public Assignment getResultsAssignment_2_4_2_1_1() { return cResultsAssignment_2_4_2_1_1; }

		//FormalParameter
		public RuleCall getResultsFormalParameterParserRuleCall_2_4_2_1_1_0() { return cResultsFormalParameterParserRuleCall_2_4_2_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2_4_3() { return cRightParenthesisKeyword_2_4_3; }

		//(isPredicate?='boolean' | isResultReport?='report')?
		public Alternatives getAlternatives_2_5() { return cAlternatives_2_5; }

		//isPredicate?='boolean'
		public Assignment getIsPredicateAssignment_2_5_0() { return cIsPredicateAssignment_2_5_0; }

		//'boolean'
		public Keyword getIsPredicateBooleanKeyword_2_5_0_0() { return cIsPredicateBooleanKeyword_2_5_0_0; }

		//isResultReport?='report'
		public Assignment getIsResultReportAssignment_2_5_1() { return cIsResultReportAssignment_2_5_1; }

		//'report'
		public Keyword getIsResultReportReportKeyword_2_5_1_0() { return cIsResultReportReportKeyword_2_5_1_0; }

		//(':' title=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//':'
		public Keyword getColonKeyword_3_0() { return cColonKeyword_3_0; }

		//title=STRING
		public Assignment getTitleAssignment_3_1() { return cTitleAssignment_3_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_3_1_0() { return cTitleSTRINGTerminalRuleCall_3_1_0; }

		//('for' (target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+))?
		public Group getGroup_4() { return cGroup_4; }

		//'for'
		public Keyword getForKeyword_4_0() { return cForKeyword_4_0; }

		//(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+)
		public Alternatives getAlternatives_4_1() { return cAlternatives_4_1; }

		//target=[aadl2::ComponentClassifier|AadlClassifierReference]
		public Assignment getTargetAssignment_4_1_0() { return cTargetAssignment_4_1_0; }

		//[aadl2::ComponentClassifier|AadlClassifierReference]
		public CrossReference getTargetComponentClassifierCrossReference_4_1_0_0() { return cTargetComponentClassifierCrossReference_4_1_0_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1() { return cTargetComponentClassifierAadlClassifierReferenceParserRuleCall_4_1_0_0_1; }

		//componentCategory+=ComponentCategory+
		public Assignment getComponentCategoryAssignment_4_1_1() { return cComponentCategoryAssignment_4_1_1; }

		//ComponentCategory
		public RuleCall getComponentCategoryComponentCategoryParserRuleCall_4_1_1_0() { return cComponentCategoryComponentCategoryParserRuleCall_4_1_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_5() { return cLeftSquareBracketKeyword_5; }

		//(methodKind=MethodKind & description=Description? & precondition=VerificationPrecondition? &
		//validation=VerificationValidation? & ('category' category+=[categories::Category|QualifiedName]+)?)
		public UnorderedGroup getUnorderedGroup_6() { return cUnorderedGroup_6; }

		//methodKind=MethodKind
		public Assignment getMethodKindAssignment_6_0() { return cMethodKindAssignment_6_0; }

		//MethodKind
		public RuleCall getMethodKindMethodKindParserRuleCall_6_0_0() { return cMethodKindMethodKindParserRuleCall_6_0_0; }

		//description=Description?
		public Assignment getDescriptionAssignment_6_1() { return cDescriptionAssignment_6_1; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_6_1_0() { return cDescriptionDescriptionParserRuleCall_6_1_0; }

		//precondition=VerificationPrecondition?
		public Assignment getPreconditionAssignment_6_2() { return cPreconditionAssignment_6_2; }

		//VerificationPrecondition
		public RuleCall getPreconditionVerificationPreconditionParserRuleCall_6_2_0() { return cPreconditionVerificationPreconditionParserRuleCall_6_2_0; }

		//validation=VerificationValidation?
		public Assignment getValidationAssignment_6_3() { return cValidationAssignment_6_3; }

		//VerificationValidation
		public RuleCall getValidationVerificationValidationParserRuleCall_6_3_0() { return cValidationVerificationValidationParserRuleCall_6_3_0; }

		//('category' category+=[categories::Category|QualifiedName]+)?
		public Group getGroup_6_4() { return cGroup_6_4; }

		//'category'
		public Keyword getCategoryKeyword_6_4_0() { return cCategoryKeyword_6_4_0; }

		//category+=[categories::Category|QualifiedName]+
		public Assignment getCategoryAssignment_6_4_1() { return cCategoryAssignment_6_4_1; }

		//[categories::Category|QualifiedName]
		public CrossReference getCategoryCategoryCrossReference_6_4_1_0() { return cCategoryCategoryCrossReference_6_4_1_0; }

		//QualifiedName
		public RuleCall getCategoryCategoryQualifiedNameParserRuleCall_6_4_1_0_1() { return cCategoryCategoryQualifiedNameParserRuleCall_6_4_1_0_1; }

		//']'
		public Keyword getRightSquareBracketKeyword_7() { return cRightSquareBracketKeyword_7; }
	}

	public class MethodKindElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.MethodKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cResoluteMethodParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cJavaMethodParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cManualMethodParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cPluginMethodParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cAgreeMethodParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cJUnit4MethodParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cPythonMethodParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		
		//MethodKind:
		//	ResoluteMethod | JavaMethod | ManualMethod | PluginMethod | AgreeMethod | JUnit4Method | PythonMethod;
		@Override public ParserRule getRule() { return rule; }

		//ResoluteMethod | JavaMethod | ManualMethod | PluginMethod | AgreeMethod | JUnit4Method | PythonMethod
		public Alternatives getAlternatives() { return cAlternatives; }

		//ResoluteMethod
		public RuleCall getResoluteMethodParserRuleCall_0() { return cResoluteMethodParserRuleCall_0; }

		//JavaMethod
		public RuleCall getJavaMethodParserRuleCall_1() { return cJavaMethodParserRuleCall_1; }

		//ManualMethod
		public RuleCall getManualMethodParserRuleCall_2() { return cManualMethodParserRuleCall_2; }

		//PluginMethod
		public RuleCall getPluginMethodParserRuleCall_3() { return cPluginMethodParserRuleCall_3; }

		//AgreeMethod
		public RuleCall getAgreeMethodParserRuleCall_4() { return cAgreeMethodParserRuleCall_4; }

		//JUnit4Method
		public RuleCall getJUnit4MethodParserRuleCall_5() { return cJUnit4MethodParserRuleCall_5; }

		//PythonMethod
		public RuleCall getPythonMethodParserRuleCall_6() { return cPythonMethodParserRuleCall_6; }
	}

	public class ResoluteMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.ResoluteMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cResoluteKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMethodReferenceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cMethodReferenceEObjectCrossReference_1_0 = (CrossReference)cMethodReferenceAssignment_1.eContents().get(0);
		private final RuleCall cMethodReferenceEObjectQualifiedNameParserRuleCall_1_0_1 = (RuleCall)cMethodReferenceEObjectCrossReference_1_0.eContents().get(1);
		
		//ResoluteMethod:
		//	'resolute' methodReference=[ecore::EObject|QualifiedName];
		@Override public ParserRule getRule() { return rule; }

		//'resolute' methodReference=[ecore::EObject|QualifiedName]
		public Group getGroup() { return cGroup; }

		//'resolute'
		public Keyword getResoluteKeyword_0() { return cResoluteKeyword_0; }

		//methodReference=[ecore::EObject|QualifiedName]
		public Assignment getMethodReferenceAssignment_1() { return cMethodReferenceAssignment_1; }

		//[ecore::EObject|QualifiedName]
		public CrossReference getMethodReferenceEObjectCrossReference_1_0() { return cMethodReferenceEObjectCrossReference_1_0; }

		//QualifiedName
		public RuleCall getMethodReferenceEObjectQualifiedNameParserRuleCall_1_0_1() { return cMethodReferenceEObjectQualifiedNameParserRuleCall_1_0_1; }
	}

	public class JavaMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.JavaMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cJavaKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMethodPathAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMethodPathQualifiedNameParserRuleCall_1_0 = (RuleCall)cMethodPathAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Group cGroup_2_1 = (Group)cGroup_2.eContents().get(1);
		private final Assignment cParamsAssignment_2_1_0 = (Assignment)cGroup_2_1.eContents().get(0);
		private final RuleCall cParamsJavaParameterParserRuleCall_2_1_0_0 = (RuleCall)cParamsAssignment_2_1_0.eContents().get(0);
		private final Group cGroup_2_1_1 = (Group)cGroup_2_1.eContents().get(1);
		private final Keyword cCommaKeyword_2_1_1_0 = (Keyword)cGroup_2_1_1.eContents().get(0);
		private final Assignment cParamsAssignment_2_1_1_1 = (Assignment)cGroup_2_1_1.eContents().get(1);
		private final RuleCall cParamsJavaParameterParserRuleCall_2_1_1_1_0 = (RuleCall)cParamsAssignment_2_1_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		
		//JavaMethod:
		//	'java' methodPath=QualifiedName ('(' (params+=JavaParameter (',' params+=JavaParameter)*)? ')')?;
		@Override public ParserRule getRule() { return rule; }

		//'java' methodPath=QualifiedName ('(' (params+=JavaParameter (',' params+=JavaParameter)*)? ')')?
		public Group getGroup() { return cGroup; }

		//'java'
		public Keyword getJavaKeyword_0() { return cJavaKeyword_0; }

		//methodPath=QualifiedName
		public Assignment getMethodPathAssignment_1() { return cMethodPathAssignment_1; }

		//QualifiedName
		public RuleCall getMethodPathQualifiedNameParserRuleCall_1_0() { return cMethodPathQualifiedNameParserRuleCall_1_0; }

		//('(' (params+=JavaParameter (',' params+=JavaParameter)*)? ')')?
		public Group getGroup_2() { return cGroup_2; }

		//'('
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//(params+=JavaParameter (',' params+=JavaParameter)*)?
		public Group getGroup_2_1() { return cGroup_2_1; }

		//params+=JavaParameter
		public Assignment getParamsAssignment_2_1_0() { return cParamsAssignment_2_1_0; }

		//JavaParameter
		public RuleCall getParamsJavaParameterParserRuleCall_2_1_0_0() { return cParamsJavaParameterParserRuleCall_2_1_0_0; }

		//(',' params+=JavaParameter)*
		public Group getGroup_2_1_1() { return cGroup_2_1_1; }

		//','
		public Keyword getCommaKeyword_2_1_1_0() { return cCommaKeyword_2_1_1_0; }

		//params+=JavaParameter
		public Assignment getParamsAssignment_2_1_1_1() { return cParamsAssignment_2_1_1_1; }

		//JavaParameter
		public RuleCall getParamsJavaParameterParserRuleCall_2_1_1_1_0() { return cParamsJavaParameterParserRuleCall_2_1_1_1_0; }

		//')'
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }
	}

	public class PythonMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.PythonMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPythonKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMethodPathAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMethodPathQualifiedNameParserRuleCall_1_0 = (RuleCall)cMethodPathAssignment_1.eContents().get(0);
		
		//PythonMethod:
		//	'python' methodPath=QualifiedName;
		@Override public ParserRule getRule() { return rule; }

		//'python' methodPath=QualifiedName
		public Group getGroup() { return cGroup; }

		//'python'
		public Keyword getPythonKeyword_0() { return cPythonKeyword_0; }

		//methodPath=QualifiedName
		public Assignment getMethodPathAssignment_1() { return cMethodPathAssignment_1; }

		//QualifiedName
		public RuleCall getMethodPathQualifiedNameParserRuleCall_1_0() { return cMethodPathQualifiedNameParserRuleCall_1_0; }
	}

	public class ManualMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.ManualMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cManualKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cManualMethodAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cDialogIDAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cDialogIDQualifiedNameParserRuleCall_2_0 = (RuleCall)cDialogIDAssignment_2.eContents().get(0);
		
		//ManualMethod:
		//	'manual' {ManualMethod} dialogID=QualifiedName;
		@Override public ParserRule getRule() { return rule; }

		//'manual' {ManualMethod} dialogID=QualifiedName
		public Group getGroup() { return cGroup; }

		//'manual'
		public Keyword getManualKeyword_0() { return cManualKeyword_0; }

		//{ManualMethod}
		public Action getManualMethodAction_1() { return cManualMethodAction_1; }

		//dialogID=QualifiedName
		public Assignment getDialogIDAssignment_2() { return cDialogIDAssignment_2; }

		//QualifiedName
		public RuleCall getDialogIDQualifiedNameParserRuleCall_2_0() { return cDialogIDQualifiedNameParserRuleCall_2_0; }
	}

	public class PluginMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.PluginMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cPluginKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cMethodIDAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMethodIDIDTerminalRuleCall_1_0 = (RuleCall)cMethodIDAssignment_1.eContents().get(0);
		
		//PluginMethod:
		//	'plugin' methodID=ID;
		@Override public ParserRule getRule() { return rule; }

		//'plugin' methodID=ID
		public Group getGroup() { return cGroup; }

		//'plugin'
		public Keyword getPluginKeyword_0() { return cPluginKeyword_0; }

		//methodID=ID
		public Assignment getMethodIDAssignment_1() { return cMethodIDAssignment_1; }

		//ID
		public RuleCall getMethodIDIDTerminalRuleCall_1_0() { return cMethodIDIDTerminalRuleCall_1_0; }
	}

	public class AgreeMethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.AgreeMethod");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAgreeKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Alternatives cAlternatives_1 = (Alternatives)cGroup.eContents().get(1);
		private final Assignment cSingleLayerAssignment_1_0 = (Assignment)cAlternatives_1.eContents().get(0);
		private final Keyword cSingleLayerSingleKeyword_1_0_0 = (Keyword)cSingleLayerAssignment_1_0.eContents().get(0);
		private final Assignment cAllAssignment_1_1 = (Assignment)cAlternatives_1.eContents().get(1);
		private final Keyword cAllAllKeyword_1_1_0 = (Keyword)cAllAssignment_1_1.eContents().get(0);
		
		//AgreeMethod:
		//	'agree' (singleLayer?='single' | all?='all');
		@Override public ParserRule getRule() { return rule; }

		//'agree' (singleLayer?='single' | all?='all')
		public Group getGroup() { return cGroup; }

		//'agree'
		public Keyword getAgreeKeyword_0() { return cAgreeKeyword_0; }

		//(singleLayer?='single' | all?='all')
		public Alternatives getAlternatives_1() { return cAlternatives_1; }

		//singleLayer?='single'
		public Assignment getSingleLayerAssignment_1_0() { return cSingleLayerAssignment_1_0; }

		//'single'
		public Keyword getSingleLayerSingleKeyword_1_0_0() { return cSingleLayerSingleKeyword_1_0_0; }

		//all?='all'
		public Assignment getAllAssignment_1_1() { return cAllAssignment_1_1; }

		//'all'
		public Keyword getAllAllKeyword_1_1_0() { return cAllAllKeyword_1_1_0; }
	}

	public class JUnit4MethodElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.JUnit4Method");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cJunitKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cClassPathAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cClassPathQualifiedNameParserRuleCall_1_0 = (RuleCall)cClassPathAssignment_1.eContents().get(0);
		
		//JUnit4Method:
		//	'junit' classPath=QualifiedName;
		@Override public ParserRule getRule() { return rule; }

		//'junit' classPath=QualifiedName
		public Group getGroup() { return cGroup; }

		//'junit'
		public Keyword getJunitKeyword_0() { return cJunitKeyword_0; }

		//classPath=QualifiedName
		public Assignment getClassPathAssignment_1() { return cClassPathAssignment_1; }

		//QualifiedName
		public RuleCall getClassPathQualifiedNameParserRuleCall_1_0() { return cClassPathQualifiedNameParserRuleCall_1_0; }
	}

	public class JavaParameterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.verify.Verify.JavaParameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cParameterTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cParameterTypeIDTerminalRuleCall_0_0 = (RuleCall)cParameterTypeAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//JavaParameter:
		//	parameterType=ID name=ID;
		@Override public ParserRule getRule() { return rule; }

		//parameterType=ID name=ID
		public Group getGroup() { return cGroup; }

		//parameterType=ID
		public Assignment getParameterTypeAssignment_0() { return cParameterTypeAssignment_0; }

		//ID
		public RuleCall getParameterTypeIDTerminalRuleCall_0_0() { return cParameterTypeIDTerminalRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
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
	private final ComputeRefElements pComputeRef;
	private final VerificationActivityElements pVerificationActivity;
	private final VerificationValidationElements pVerificationValidation;
	private final VerificationPreconditionElements pVerificationPrecondition;
	private final VerificationMethodRegistryElements pVerificationMethodRegistry;
	private final FormalParameterElements pFormalParameter;
	private final VerificationMethodElements pVerificationMethod;
	private final MethodKindElements pMethodKind;
	private final ResoluteMethodElements pResoluteMethod;
	private final JavaMethodElements pJavaMethod;
	private final PythonMethodElements pPythonMethod;
	private final ManualMethodElements pManualMethod;
	private final PluginMethodElements pPluginMethod;
	private final AgreeMethodElements pAgreeMethod;
	private final JUnit4MethodElements pJUnit4Method;
	private final JavaParameterElements pJavaParameter;
	
	private final Grammar grammar;

	private final CommonGrammarAccess gaCommon;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public VerifyGrammarAccess(GrammarProvider grammarProvider,
		CommonGrammarAccess gaCommon,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCommon = gaCommon;
		this.gaTerminals = gaTerminals;
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
		this.pComputeRef = new ComputeRefElements();
		this.pVerificationActivity = new VerificationActivityElements();
		this.pVerificationValidation = new VerificationValidationElements();
		this.pVerificationPrecondition = new VerificationPreconditionElements();
		this.pVerificationMethodRegistry = new VerificationMethodRegistryElements();
		this.pFormalParameter = new FormalParameterElements();
		this.pVerificationMethod = new VerificationMethodElements();
		this.pMethodKind = new MethodKindElements();
		this.pResoluteMethod = new ResoluteMethodElements();
		this.pJavaMethod = new JavaMethodElements();
		this.pPythonMethod = new PythonMethodElements();
		this.pManualMethod = new ManualMethodElements();
		this.pPluginMethod = new PluginMethodElements();
		this.pAgreeMethod = new AgreeMethodElements();
		this.pJUnit4Method = new JUnit4MethodElements();
		this.pJavaParameter = new JavaParameterElements();
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

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
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
	//	'verification' 'plan' name=QualifiedName (':' title=STRING)?
	//	'for' requirementSet=[ReqSpec::RequirementSet|QualifiedName]
	//	'[' (description=Description?
	//	& claim+=Claim*
	//	& rationale=Rationale?
	//	& ('issues' issues+=STRING+)?)
	//	']';
	public VerificationPlanElements getVerificationPlanAccess() {
		return pVerificationPlan;
	}
	
	public ParserRule getVerificationPlanRule() {
		return getVerificationPlanAccess().getRule();
	}

	//Claim:
	//	{Claim} 'claim' requirement=[ReqSpec::Requirement|QualifiedName]? (':' title=STRING)?
	//	'[' (('activities' activities+=VerificationActivity*)?
	//	& ('assert' assert=ArgumentExpr)?
	//	& rationale=Rationale?
	//	& ('weight' weight=INT)?
	//	& subclaim+=Claim*
	//	& ('issues' issues+=STRING+)?)
	//	']';
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

	//ThenEvidenceExpr ArgumentExpr:
	//	ElseEvidenceExpr (=> ({ThenExpr.left=current} 'then') successor=ThenEvidenceExpr)*;
	public ThenEvidenceExprElements getThenEvidenceExprAccess() {
		return pThenEvidenceExpr;
	}
	
	public ParserRule getThenEvidenceExprRule() {
		return getThenEvidenceExprAccess().getRule();
	}

	//// Execute as alternative if the first one fails.
	//// The results of both are reported
	//ElseEvidenceExpr ArgumentExpr:
	//	SingleElseEvidenceExpr | CompositeElseEvidenceExpr;
	public ElseEvidenceExprElements getElseEvidenceExprAccess() {
		return pElseEvidenceExpr;
	}
	
	public ParserRule getElseEvidenceExprRule() {
		return getElseEvidenceExprAccess().getRule();
	}

	//SingleElseEvidenceExpr ArgumentExpr:
	//	VAReference (=> ({ElseExpr.left=current} 'else') (error=ElseEvidenceExpr |
	//	'[' ('fail' ':' fail=ThenEvidenceExpr)? ('timeout' ':' timeout=ThenEvidenceExpr)? ('error' ':'
	//	error=ThenEvidenceExpr)?
	//	']'))*;
	public SingleElseEvidenceExprElements getSingleElseEvidenceExprAccess() {
		return pSingleElseEvidenceExpr;
	}
	
	public ParserRule getSingleElseEvidenceExprRule() {
		return getSingleElseEvidenceExprAccess().getRule();
	}

	//CompositeElseEvidenceExpr ArgumentExpr:
	//	CompositeEvidenceExpr (=> ({ElseExpr.left=current} 'else') error=ElseEvidenceExpr)*;
	public CompositeElseEvidenceExprElements getCompositeElseEvidenceExprAccess() {
		return pCompositeElseEvidenceExpr;
	}
	
	public ParserRule getCompositeElseEvidenceExprRule() {
		return getCompositeElseEvidenceExprAccess().getRule();
	}

	//QuantifiedEvidenceExpr ArgumentExpr:
	//	'all' {AllExpr} '[' elements+=ThenEvidenceExpr (',' elements+=ThenEvidenceExpr)* ']';
	public QuantifiedEvidenceExprElements getQuantifiedEvidenceExprAccess() {
		return pQuantifiedEvidenceExpr;
	}
	
	public ParserRule getQuantifiedEvidenceExprRule() {
		return getQuantifiedEvidenceExprAccess().getRule();
	}

	//CompositeEvidenceExpr ArgumentExpr:
	//	'(' ThenEvidenceExpr ')' | QuantifiedEvidenceExpr;
	public CompositeEvidenceExprElements getCompositeEvidenceExprAccess() {
		return pCompositeEvidenceExpr;
	}
	
	public ParserRule getCompositeEvidenceExprRule() {
		return getCompositeEvidenceExprAccess().getRule();
	}

	//VAReference ArgumentExpr:
	//	{RefExpr} verification=[VerificationActivity];
	public VAReferenceElements getVAReferenceAccess() {
		return pVAReference;
	}
	
	public ParserRule getVAReferenceRule() {
		return getVAReferenceAccess().getRule();
	}

	//ComputeRef:
	//	compute=[common::ComputeDeclaration];
	public ComputeRefElements getComputeRefAccess() {
		return pComputeRef;
	}
	
	public ParserRule getComputeRefRule() {
		return getComputeRefAccess().getRule();
	}

	//VerificationActivity:
	//	name=ID (':' title=STRING)?
	//	':' (computes+=ComputeRef (',' computes+=ComputeRef)* '=')?
	//	method=[VerificationMethod|QualifiedName]
	//	//	'(' (parameters+=[common::ValDeclaration|ID] (',' parameters+=[common::ValDeclaration|ID])*)? ')' 
	//	'(' (actuals+=AExpression (',' actuals+=AExpression)*)? ')' ('property' 'values' '(' (propertyValues+=AExpression (','
	//	propertyValues+=AExpression)*)?
	//	')')? ('[' (('category' category+=[categories::Category|QualifiedName]+)?
	//	& ('timeout' timeout=AIntegerTerm)?
	//	& ('weight' weight=INT)?) ']')?;
	public VerificationActivityElements getVerificationActivityAccess() {
		return pVerificationActivity;
	}
	
	public ParserRule getVerificationActivityRule() {
		return getVerificationActivityAccess().getRule();
	}

	//VerificationValidation VerificationCondition:
	//	'validation' {VerificationValidation} method=[VerificationMethod|QualifiedName]
	//	'(' (parameters+=[FormalParameter] (',' parameters+=[FormalParameter])*)? ')';
	public VerificationValidationElements getVerificationValidationAccess() {
		return pVerificationValidation;
	}
	
	public ParserRule getVerificationValidationRule() {
		return getVerificationValidationAccess().getRule();
	}

	//VerificationPrecondition VerificationCondition:
	//	'precondition' {VerificationPrecondition} method=[VerificationMethod|QualifiedName]
	//	'(' (parameters+=[FormalParameter] (',' parameters+=[FormalParameter])*)? ')';
	public VerificationPreconditionElements getVerificationPreconditionAccess() {
		return pVerificationPrecondition;
	}
	
	public ParserRule getVerificationPreconditionRule() {
		return getVerificationPreconditionAccess().getRule();
	}

	//VerificationMethodRegistry:
	//	'verification' 'methods' name=QualifiedName (':' title=STRING)?
	//	//	( 'for' (target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+ ))?
	//	'[' (description=Description?
	//	methods+=VerificationMethod*)
	//	']';
	public VerificationMethodRegistryElements getVerificationMethodRegistryAccess() {
		return pVerificationMethodRegistry;
	}
	
	public ParserRule getVerificationMethodRegistryRule() {
		return getVerificationMethodRegistryAccess().getRule();
	}

	//FormalParameter:
	//	name=ID ':' (type=TypeRef | 'typeof' type=PropertyRef) ('in' unit=[aadl2::UnitLiteral])?;
	public FormalParameterElements getFormalParameterAccess() {
		return pFormalParameter;
	}
	
	public ParserRule getFormalParameterRule() {
		return getFormalParameterAccess().getRule();
	}

	//VerificationMethod:
	//	'method' name=ID ('(' (targetType=TargetType? | formals+=FormalParameter (',' formals+=FormalParameter)* |
	//	targetType=TargetType ',' formals+=FormalParameter (',' formals+=FormalParameter)*)
	//	')' ('properties' '(' (properties+=[aadl2::Property|AADLPROPERTYREFERENCE] (','
	//	properties+=[aadl2::Property|AADLPROPERTYREFERENCE])*)?
	//	')')? ('returns' '(' (results+=FormalParameter (',' results+=FormalParameter)*)?
	//	')')? (isPredicate?='boolean' | isResultReport?='report')?)? (':' title=STRING)? ('for'
	//	(target=[aadl2::ComponentClassifier|AadlClassifierReference] | componentCategory+=ComponentCategory+))?
	//	'[' (methodKind=MethodKind
	//	& description=Description?
	//	& precondition=VerificationPrecondition?
	//	& validation=VerificationValidation?
	//	& ('category' category+=[categories::Category|QualifiedName]+)?)
	//	']';
	public VerificationMethodElements getVerificationMethodAccess() {
		return pVerificationMethod;
	}
	
	public ParserRule getVerificationMethodRule() {
		return getVerificationMethodAccess().getRule();
	}

	//MethodKind:
	//	ResoluteMethod | JavaMethod | ManualMethod | PluginMethod | AgreeMethod | JUnit4Method | PythonMethod;
	public MethodKindElements getMethodKindAccess() {
		return pMethodKind;
	}
	
	public ParserRule getMethodKindRule() {
		return getMethodKindAccess().getRule();
	}

	//ResoluteMethod:
	//	'resolute' methodReference=[ecore::EObject|QualifiedName];
	public ResoluteMethodElements getResoluteMethodAccess() {
		return pResoluteMethod;
	}
	
	public ParserRule getResoluteMethodRule() {
		return getResoluteMethodAccess().getRule();
	}

	//JavaMethod:
	//	'java' methodPath=QualifiedName ('(' (params+=JavaParameter (',' params+=JavaParameter)*)? ')')?;
	public JavaMethodElements getJavaMethodAccess() {
		return pJavaMethod;
	}
	
	public ParserRule getJavaMethodRule() {
		return getJavaMethodAccess().getRule();
	}

	//PythonMethod:
	//	'python' methodPath=QualifiedName;
	public PythonMethodElements getPythonMethodAccess() {
		return pPythonMethod;
	}
	
	public ParserRule getPythonMethodRule() {
		return getPythonMethodAccess().getRule();
	}

	//ManualMethod:
	//	'manual' {ManualMethod} dialogID=QualifiedName;
	public ManualMethodElements getManualMethodAccess() {
		return pManualMethod;
	}
	
	public ParserRule getManualMethodRule() {
		return getManualMethodAccess().getRule();
	}

	//PluginMethod:
	//	'plugin' methodID=ID;
	public PluginMethodElements getPluginMethodAccess() {
		return pPluginMethod;
	}
	
	public ParserRule getPluginMethodRule() {
		return getPluginMethodAccess().getRule();
	}

	//AgreeMethod:
	//	'agree' (singleLayer?='single' | all?='all');
	public AgreeMethodElements getAgreeMethodAccess() {
		return pAgreeMethod;
	}
	
	public ParserRule getAgreeMethodRule() {
		return getAgreeMethodAccess().getRule();
	}

	//JUnit4Method:
	//	'junit' classPath=QualifiedName;
	public JUnit4MethodElements getJUnit4MethodAccess() {
		return pJUnit4Method;
	}
	
	public ParserRule getJUnit4MethodRule() {
		return getJUnit4MethodAccess().getRule();
	}

	//JavaParameter:
	//	parameterType=ID name=ID;
	public JavaParameterElements getJavaParameterAccess() {
		return pJavaParameter;
	}
	
	public ParserRule getJavaParameterRule() {
		return getJavaParameterAccess().getRule();
	}

	//Description:
	//	'description' description+=DescriptionElement+;
	public CommonGrammarAccess.DescriptionElements getDescriptionAccess() {
		return gaCommon.getDescriptionAccess();
	}
	
	public ParserRule getDescriptionRule() {
		return getDescriptionAccess().getRule();
	}

	//DescriptionElement:
	//	text=STRING | => thisTarget?='this' | => image=ImageReference | showValue=ShowValue;
	public CommonGrammarAccess.DescriptionElementElements getDescriptionElementAccess() {
		return gaCommon.getDescriptionElementAccess();
	}
	
	public ParserRule getDescriptionElementRule() {
		return getDescriptionElementAccess().getRule();
	}

	//Rationale:
	//	'rationale' description+=DescriptionElement+;
	public CommonGrammarAccess.RationaleElements getRationaleAccess() {
		return gaCommon.getRationaleAccess();
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
	public CommonGrammarAccess.UncertaintyElements getUncertaintyAccess() {
		return gaCommon.getUncertaintyAccess();
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
	public CommonGrammarAccess.TypeRefElements getTypeRefAccess() {
		return gaCommon.getTypeRefAccess();
	}
	
	public ParserRule getTypeRefRule() {
		return getTypeRefAccess().getRule();
	}

	//PropertyRef aadl2::PropertyType:
	//	{PropertyRef} ref=[aadl2::Property|AADLPROPERTYREFERENCE];
	public CommonGrammarAccess.PropertyRefElements getPropertyRefAccess() {
		return gaCommon.getPropertyRefAccess();
	}
	
	public ParserRule getPropertyRefRule() {
		return getPropertyRefAccess().getRule();
	}

	//ValDeclaration AVariableDeclaration:
	//	{ValDeclaration} 'val' name=ID (':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof'
	//	type=PropertyRef) ']'))? '=' value=AExpression;
	public CommonGrammarAccess.ValDeclarationElements getValDeclarationAccess() {
		return gaCommon.getValDeclarationAccess();
	}
	
	public ParserRule getValDeclarationRule() {
		return getValDeclarationAccess().getRule();
	}

	//ComputeDeclaration AVariableDeclaration:
	//	{ComputeDeclaration}
	//	'compute' name=ID ':' (type=TypeRef | 'typeof' type=PropertyRef | range?='[' (type=TypeRef | 'typeof'
	//	type=PropertyRef) ']');
	public CommonGrammarAccess.ComputeDeclarationElements getComputeDeclarationAccess() {
		return gaCommon.getComputeDeclarationAccess();
	}
	
	public ParserRule getComputeDeclarationRule() {
		return getComputeDeclarationAccess().getRule();
	}

	//// Reference to property, property constant, or model element.
	//AModelOrPropertyReference AExpression:
	//	AModelReference (=> ({APropertyReference.modelElementReference=current} '#')
	//	property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE])?
	//	| APropertyReference;
	public CommonGrammarAccess.AModelOrPropertyReferenceElements getAModelOrPropertyReferenceAccess() {
		return gaCommon.getAModelOrPropertyReferenceAccess();
	}
	
	public ParserRule getAModelOrPropertyReferenceRule() {
		return getAModelOrPropertyReferenceAccess().getRule();
	}

	//AModelReference:
	//	modelElement=[aadl2::NamedElement|ThisKeyword] ({AModelReference.prev=current} '.'
	//	modelElement=[aadl2::NamedElement])*;
	public CommonGrammarAccess.AModelReferenceElements getAModelReferenceAccess() {
		return gaCommon.getAModelReferenceAccess();
	}
	
	public ParserRule getAModelReferenceRule() {
		return getAModelReferenceAccess().getRule();
	}

	//APropertyReference:
	//	{APropertyReference} '#' property=[aadl2::AbstractNamedValue|AADLPROPERTYREFERENCE];
	public CommonGrammarAccess.APropertyReferenceElements getAPropertyReferenceAccess() {
		return gaCommon.getAPropertyReferenceAccess();
	}
	
	public ParserRule getAPropertyReferenceRule() {
		return getAPropertyReferenceAccess().getRule();
	}

	//AVariableReference AExpression:
	//	{AVariableReference} variable=[AVariableDeclaration];
	public CommonGrammarAccess.AVariableReferenceElements getAVariableReferenceAccess() {
		return gaCommon.getAVariableReferenceAccess();
	}
	
	public ParserRule getAVariableReferenceRule() {
		return getAVariableReferenceAccess().getRule();
	}

	//ShowValue AUnitExpression:
	//	expression=AVariableReference ((convert?='%' | drop?='in') unit=[aadl2::UnitLiteral])?;
	public CommonGrammarAccess.ShowValueElements getShowValueAccess() {
		return gaCommon.getShowValueAccess();
	}
	
	public ParserRule getShowValueRule() {
		return getShowValueAccess().getRule();
	}

	//ImageReference:
	//	'img' imgfile=IMGREF;
	public CommonGrammarAccess.ImageReferenceElements getImageReferenceAccess() {
		return gaCommon.getImageReferenceAccess();
	}
	
	public ParserRule getImageReferenceRule() {
		return getImageReferenceAccess().getRule();
	}

	//IMGREF:
	//	(ID '/')* ID '.' ID;
	public CommonGrammarAccess.IMGREFElements getIMGREFAccess() {
		return gaCommon.getIMGREFAccess();
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
	public CommonGrammarAccess.OperationElements getOperationAccess() {
		return gaCommon.getOperationAccess();
	}
	
	public EnumRule getOperationRule() {
		return getOperationAccess().getRule();
	}

	//AExpression aadl2::PropertyExpression:
	//	AOrExpression;
	public CommonGrammarAccess.AExpressionElements getAExpressionAccess() {
		return gaCommon.getAExpressionAccess();
	}
	
	public ParserRule getAExpressionRule() {
		return getAExpressionAccess().getRule();
	}

	//AOrExpression aadl2::PropertyExpression:
	//	AAndExpression (=> ({ABinaryOperation.left=current} operator=OpOr) right=AAndExpression)*;
	public CommonGrammarAccess.AOrExpressionElements getAOrExpressionAccess() {
		return gaCommon.getAOrExpressionAccess();
	}
	
	public ParserRule getAOrExpressionRule() {
		return getAOrExpressionAccess().getRule();
	}

	//OpOr Operation:
	//	'or' | '||';
	public CommonGrammarAccess.OpOrElements getOpOrAccess() {
		return gaCommon.getOpOrAccess();
	}
	
	public ParserRule getOpOrRule() {
		return getOpOrAccess().getRule();
	}

	//AAndExpression aadl2::PropertyExpression:
	//	AEqualityExpression (=> ({ABinaryOperation.left=current} operator=OpAnd) right=AEqualityExpression)*;
	public CommonGrammarAccess.AAndExpressionElements getAAndExpressionAccess() {
		return gaCommon.getAAndExpressionAccess();
	}
	
	public ParserRule getAAndExpressionRule() {
		return getAAndExpressionAccess().getRule();
	}

	//OpAnd Operation:
	//	'and' | '&&';
	public CommonGrammarAccess.OpAndElements getOpAndAccess() {
		return gaCommon.getOpAndAccess();
	}
	
	public ParserRule getOpAndRule() {
		return getOpAndAccess().getRule();
	}

	//AEqualityExpression aadl2::PropertyExpression:
	//	ARelationalExpression (=> ({ABinaryOperation.left=current} operator=OpEquality) right=ARelationalExpression)*;
	public CommonGrammarAccess.AEqualityExpressionElements getAEqualityExpressionAccess() {
		return gaCommon.getAEqualityExpressionAccess();
	}
	
	public ParserRule getAEqualityExpressionRule() {
		return getAEqualityExpressionAccess().getRule();
	}

	//OpEquality Operation:
	//	'==' | '!=';
	public CommonGrammarAccess.OpEqualityElements getOpEqualityAccess() {
		return gaCommon.getOpEqualityAccess();
	}
	
	public ParserRule getOpEqualityRule() {
		return getOpEqualityAccess().getRule();
	}

	//ARelationalExpression aadl2::PropertyExpression:
	//	AAdditiveExpression (=> ({ABinaryOperation.left=current} operator=OpCompare) right=AAdditiveExpression)*;
	public CommonGrammarAccess.ARelationalExpressionElements getARelationalExpressionAccess() {
		return gaCommon.getARelationalExpressionAccess();
	}
	
	public ParserRule getARelationalExpressionRule() {
		return getARelationalExpressionAccess().getRule();
	}

	//OpCompare Operation:
	//	'>=' | '<=' | '>' | '<' | '><';
	public CommonGrammarAccess.OpCompareElements getOpCompareAccess() {
		return gaCommon.getOpCompareAccess();
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
	public CommonGrammarAccess.AAdditiveExpressionElements getAAdditiveExpressionAccess() {
		return gaCommon.getAAdditiveExpressionAccess();
	}
	
	public ParserRule getAAdditiveExpressionRule() {
		return getAAdditiveExpressionAccess().getRule();
	}

	//OpAdd Operation:
	//	'+' | '-';
	public CommonGrammarAccess.OpAddElements getOpAddAccess() {
		return gaCommon.getOpAddAccess();
	}
	
	public ParserRule getOpAddRule() {
		return getOpAddAccess().getRule();
	}

	//AMultiplicativeExpression aadl2::PropertyExpression:
	//	AUnaryOperation (=> ({ABinaryOperation.left=current} operator=OpMulti) right=AUnaryOperation)*;
	public CommonGrammarAccess.AMultiplicativeExpressionElements getAMultiplicativeExpressionAccess() {
		return gaCommon.getAMultiplicativeExpressionAccess();
	}
	
	public ParserRule getAMultiplicativeExpressionRule() {
		return getAMultiplicativeExpressionAccess().getRule();
	}

	//OpMulti Operation:
	//	'*' | '/' | 'div' | 'mod';
	public CommonGrammarAccess.OpMultiElements getOpMultiAccess() {
		return gaCommon.getOpMultiAccess();
	}
	
	public ParserRule getOpMultiRule() {
		return getOpMultiAccess().getRule();
	}

	//AUnaryOperation aadl2::PropertyExpression:
	//	{AUnaryOperation} => operator=OpUnary operand=AUnaryOperation | AUnitExpression;
	public CommonGrammarAccess.AUnaryOperationElements getAUnaryOperationAccess() {
		return gaCommon.getAUnaryOperationAccess();
	}
	
	public ParserRule getAUnaryOperationRule() {
		return getAUnaryOperationAccess().getRule();
	}

	//OpUnary Operation:
	//	"not" | "-" | "+";
	public CommonGrammarAccess.OpUnaryElements getOpUnaryAccess() {
		return gaCommon.getOpUnaryAccess();
	}
	
	public ParserRule getOpUnaryRule() {
		return getOpUnaryAccess().getRule();
	}

	//AUnitExpression aadl2::PropertyExpression:
	//	APrimaryExpression ({AUnitExpression.expression=current} (convert?='%' | drop?='in')? unit=[aadl2::UnitLiteral])?;
	public CommonGrammarAccess.AUnitExpressionElements getAUnitExpressionAccess() {
		return gaCommon.getAUnitExpressionAccess();
	}
	
	public ParserRule getAUnitExpressionRule() {
		return getAUnitExpressionAccess().getRule();
	}

	//APrimaryExpression aadl2::PropertyExpression:
	//	ALiteral | AVariableReference | AModelOrPropertyReference | AFunctionCall | ARangeExpression | AIfExpression
	//	| AParenthesizedExpression;
	public CommonGrammarAccess.APrimaryExpressionElements getAPrimaryExpressionAccess() {
		return gaCommon.getAPrimaryExpressionAccess();
	}
	
	public ParserRule getAPrimaryExpressionRule() {
		return getAPrimaryExpressionAccess().getRule();
	}

	//AFunctionCall aadl2::PropertyExpression:
	//	{AFunctionCall} function=QualifiedName '(' (arguments+=AExpression (',' arguments+=AExpression)*)? ')';
	public CommonGrammarAccess.AFunctionCallElements getAFunctionCallAccess() {
		return gaCommon.getAFunctionCallAccess();
	}
	
	public ParserRule getAFunctionCallRule() {
		return getAFunctionCallAccess().getRule();
	}

	//ARangeExpression aadl2::PropertyExpression:
	//	{ARange} '[' minimum=AExpression '..' maximum=AExpression (=> 'delta' delta=AExpression)? ']';
	public CommonGrammarAccess.ARangeExpressionElements getARangeExpressionAccess() {
		return gaCommon.getARangeExpressionAccess();
	}
	
	public ParserRule getARangeExpressionRule() {
		return getARangeExpressionAccess().getRule();
	}

	//AIfExpression aadl2::PropertyExpression:
	//	{AConditional} 'if' if=AExpression 'then' then=AExpression ('else' else=AExpression)? 'endif';
	public CommonGrammarAccess.AIfExpressionElements getAIfExpressionAccess() {
		return gaCommon.getAIfExpressionAccess();
	}
	
	public ParserRule getAIfExpressionRule() {
		return getAIfExpressionAccess().getRule();
	}

	//ALiteral aadl2::PropertyExpression:
	//	ABooleanLiteral | ARealTerm | AIntegerTerm | StringTerm;
	public CommonGrammarAccess.ALiteralElements getALiteralAccess() {
		return gaCommon.getALiteralAccess();
	}
	
	public ParserRule getALiteralRule() {
		return getALiteralAccess().getRule();
	}

	//AIntegerTerm aadl2::IntegerLiteral:
	//	value=AInt;
	public CommonGrammarAccess.AIntegerTermElements getAIntegerTermAccess() {
		return gaCommon.getAIntegerTermAccess();
	}
	
	public ParserRule getAIntegerTermRule() {
		return getAIntegerTermAccess().getRule();
	}

	//AInt aadl2::Integer:
	//	INT;
	public CommonGrammarAccess.AIntElements getAIntAccess() {
		return gaCommon.getAIntAccess();
	}
	
	public ParserRule getAIntRule() {
		return getAIntAccess().getRule();
	}

	//ARealTerm aadl2::RealLiteral:
	//	value=AReal;
	public CommonGrammarAccess.ARealTermElements getARealTermAccess() {
		return gaCommon.getARealTermAccess();
	}
	
	public ParserRule getARealTermRule() {
		return getARealTermAccess().getRule();
	}

	//AReal aadl2::Real:
	//	REAL_LIT;
	public CommonGrammarAccess.ARealElements getARealAccess() {
		return gaCommon.getARealAccess();
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
	public CommonGrammarAccess.ABooleanLiteralElements getABooleanLiteralAccess() {
		return gaCommon.getABooleanLiteralAccess();
	}
	
	public ParserRule getABooleanLiteralRule() {
		return getABooleanLiteralAccess().getRule();
	}

	//StringTerm aadl2::StringLiteral:
	//	value=NoQuoteString;
	public CommonGrammarAccess.StringTermElements getStringTermAccess() {
		return gaCommon.getStringTermAccess();
	}
	
	public ParserRule getStringTermRule() {
		return getStringTermAccess().getRule();
	}

	//NoQuoteString:
	//	STRING;
	public CommonGrammarAccess.NoQuoteStringElements getNoQuoteStringAccess() {
		return gaCommon.getNoQuoteStringAccess();
	}
	
	public ParserRule getNoQuoteStringRule() {
		return getNoQuoteStringAccess().getRule();
	}

	//AParenthesizedExpression aadl2::PropertyExpression:
	//	'(' AExpression ')';
	public CommonGrammarAccess.AParenthesizedExpressionElements getAParenthesizedExpressionAccess() {
		return gaCommon.getAParenthesizedExpressionAccess();
	}
	
	public ParserRule getAParenthesizedExpressionRule() {
		return getAParenthesizedExpressionAccess().getRule();
	}

	//ComponentCategory aadl2::ComponentCategory:
	//	'abstract' | 'bus' | 'data'
	//	| 'device' | 'memory' | 'process' | 'processor' | 'subprogram'
	//	| 'subprogram' 'group' | 'system' | 'thread' 'group'
	//	| 'thread' | 'virtual' 'bus' | 'virtual' 'processor';
	public CommonGrammarAccess.ComponentCategoryElements getComponentCategoryAccess() {
		return gaCommon.getComponentCategoryAccess();
	}
	
	public ParserRule getComponentCategoryRule() {
		return getComponentCategoryAccess().getRule();
	}

	//enum TargetType:
	//	COMPONENT='component' | FEATURE='feature' | CONNECTION='connection' | FLOW='flow' | MODE='mode' | ELEMENT='element' |
	//	ROOT='root';
	public CommonGrammarAccess.TargetTypeElements getTargetTypeAccess() {
		return gaCommon.getTargetTypeAccess();
	}
	
	public EnumRule getTargetTypeRule() {
		return getTargetTypeAccess().getRule();
	}

	//terminal fragment EXPONENT:
	//	('e' | 'E') ('+' | '-')? DIGIT+;
	public TerminalRule getEXPONENTRule() {
		return gaCommon.getEXPONENTRule();
	} 

	//terminal fragment INT_EXPONENT:
	//	('e' | 'E') '+'? DIGIT+;
	public TerminalRule getINT_EXPONENTRule() {
		return gaCommon.getINT_EXPONENTRule();
	} 

	//terminal REAL_LIT:
	//	DIGIT+ ('_' DIGIT+)* ('.' DIGIT+ ('_' DIGIT+)* EXPONENT?);
	public TerminalRule getREAL_LITRule() {
		return gaCommon.getREAL_LITRule();
	} 

	//terminal fragment DIGIT:
	//	'0'..'9';
	public TerminalRule getDIGITRule() {
		return gaCommon.getDIGITRule();
	} 

	//terminal fragment EXTENDED_DIGIT:
	//	'0'..'9' | 'a'..'f' | 'A'..'F';
	public TerminalRule getEXTENDED_DIGITRule() {
		return gaCommon.getEXTENDED_DIGITRule();
	} 

	//terminal fragment BASED_INTEGER:
	//	EXTENDED_DIGIT ('_'? EXTENDED_DIGIT)*;
	public TerminalRule getBASED_INTEGERRule() {
		return gaCommon.getBASED_INTEGERRule();
	} 

	//// Qualified classifier reference
	//AadlClassifierReference:
	//	ID ('::' ID)+ ('.' ID)?;
	public CommonGrammarAccess.AadlClassifierReferenceElements getAadlClassifierReferenceAccess() {
		return gaCommon.getAadlClassifierReferenceAccess();
	}
	
	public ParserRule getAadlClassifierReferenceRule() {
		return getAadlClassifierReferenceAccess().getRule();
	}

	//AADLPROPERTYREFERENCE:
	//	ID ('::' ID)?;
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
	//	ID ('.' ID)*;
	public CommonGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaCommon.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//ThisKeyword:
	//	'this';
	public CommonGrammarAccess.ThisKeywordElements getThisKeywordAccess() {
		return gaCommon.getThisKeywordAccess();
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
