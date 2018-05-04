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
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class AssureGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class AssuranceCaseResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.AssuranceCaseResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cCaseKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameQualifiedNameParserRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cMetricsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMetricsMetricsParserRuleCall_3_0 = (RuleCall)cMetricsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cMessageKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cMessageAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cMessageAssignment_4_1.eContents().get(0);
		private final Assignment cModelResultAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cModelResultModelResultParserRuleCall_5_0 = (RuleCall)cModelResultAssignment_5.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//// result for a system in the architecture hierarchy
		//AssuranceCaseResult:
		//	'case' name=QualifiedName
		//	'['
		//	metrics=Metrics ('message' message=STRING)?
		//	modelResult+=ModelResult*
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'case' name=QualifiedName '[' metrics=Metrics ('message' message=STRING)? modelResult+=ModelResult* ']'
		public Group getGroup() { return cGroup; }

		//'case'
		public Keyword getCaseKeyword_0() { return cCaseKeyword_0; }

		//name=QualifiedName
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//QualifiedName
		public RuleCall getNameQualifiedNameParserRuleCall_1_0() { return cNameQualifiedNameParserRuleCall_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_3() { return cMetricsAssignment_3; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_3_0() { return cMetricsMetricsParserRuleCall_3_0; }

		//('message' message=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//'message'
		public Keyword getMessageKeyword_4_0() { return cMessageKeyword_4_0; }

		//message=STRING
		public Assignment getMessageAssignment_4_1() { return cMessageAssignment_4_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_4_1_0() { return cMessageSTRINGTerminalRuleCall_4_1_0; }

		//modelResult+=ModelResult*
		public Assignment getModelResultAssignment_5() { return cModelResultAssignment_5; }

		//ModelResult
		public RuleCall getModelResultModelResultParserRuleCall_5_0() { return cModelResultModelResultParserRuleCall_5_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_6() { return cRightSquareBracketKeyword_6; }
	}

	public class ModelResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ModelResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cModelKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cPlanAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cPlanAssurancePlanCrossReference_1_0 = (CrossReference)cPlanAssignment_1.eContents().get(0);
		private final RuleCall cPlanAssurancePlanQualifiedNameParserRuleCall_1_0_1 = (RuleCall)cPlanAssurancePlanCrossReference_1_0.eContents().get(1);
		private final Keyword cForKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cTargetAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cTargetComponentImplementationCrossReference_3_0 = (CrossReference)cTargetAssignment_3.eContents().get(0);
		private final RuleCall cTargetComponentImplementationAadlClassifierReferenceParserRuleCall_3_0_1 = (RuleCall)cTargetComponentImplementationCrossReference_3_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cMetricsAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cMetricsMetricsParserRuleCall_5_0 = (RuleCall)cMetricsAssignment_5.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cMessageKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cMessageAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_6_1_0 = (RuleCall)cMessageAssignment_6_1.eContents().get(0);
		private final Assignment cClaimResultAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cClaimResultClaimResultParserRuleCall_7_0 = (RuleCall)cClaimResultAssignment_7.eContents().get(0);
		private final Assignment cSubsystemResultAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cSubsystemResultSubsystemResultParserRuleCall_8_0 = (RuleCall)cSubsystemResultAssignment_8.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//ModelResult:
		//	'model' plan=[Alisa::AssurancePlan|QualifiedName]
		//	'for' target=[aadl2::ComponentImplementation|AadlClassifierReference]
		//	'['
		//	metrics=Metrics ('message' message=STRING)?
		//	claimResult+=ClaimResult*
		//	subsystemResult+=SubsystemResult*
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'model' plan=[Alisa::AssurancePlan|QualifiedName] 'for' target=[aadl2::ComponentImplementation|AadlClassifierReference]
		//'[' metrics=Metrics ('message' message=STRING)? claimResult+=ClaimResult* subsystemResult+=SubsystemResult* ']'
		public Group getGroup() { return cGroup; }

		//'model'
		public Keyword getModelKeyword_0() { return cModelKeyword_0; }

		//plan=[Alisa::AssurancePlan|QualifiedName]
		public Assignment getPlanAssignment_1() { return cPlanAssignment_1; }

		//[Alisa::AssurancePlan|QualifiedName]
		public CrossReference getPlanAssurancePlanCrossReference_1_0() { return cPlanAssurancePlanCrossReference_1_0; }

		//QualifiedName
		public RuleCall getPlanAssurancePlanQualifiedNameParserRuleCall_1_0_1() { return cPlanAssurancePlanQualifiedNameParserRuleCall_1_0_1; }

		//'for'
		public Keyword getForKeyword_2() { return cForKeyword_2; }

		//target=[aadl2::ComponentImplementation|AadlClassifierReference]
		public Assignment getTargetAssignment_3() { return cTargetAssignment_3; }

		//[aadl2::ComponentImplementation|AadlClassifierReference]
		public CrossReference getTargetComponentImplementationCrossReference_3_0() { return cTargetComponentImplementationCrossReference_3_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentImplementationAadlClassifierReferenceParserRuleCall_3_0_1() { return cTargetComponentImplementationAadlClassifierReferenceParserRuleCall_3_0_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_5() { return cMetricsAssignment_5; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_5_0() { return cMetricsMetricsParserRuleCall_5_0; }

		//('message' message=STRING)?
		public Group getGroup_6() { return cGroup_6; }

		//'message'
		public Keyword getMessageKeyword_6_0() { return cMessageKeyword_6_0; }

		//message=STRING
		public Assignment getMessageAssignment_6_1() { return cMessageAssignment_6_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_6_1_0() { return cMessageSTRINGTerminalRuleCall_6_1_0; }

		//claimResult+=ClaimResult*
		public Assignment getClaimResultAssignment_7() { return cClaimResultAssignment_7; }

		//ClaimResult
		public RuleCall getClaimResultClaimResultParserRuleCall_7_0() { return cClaimResultClaimResultParserRuleCall_7_0; }

		//subsystemResult+=SubsystemResult*
		public Assignment getSubsystemResultAssignment_8() { return cSubsystemResultAssignment_8; }

		//SubsystemResult
		public RuleCall getSubsystemResultSubsystemResultParserRuleCall_8_0() { return cSubsystemResultSubsystemResultParserRuleCall_8_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_9() { return cRightSquareBracketKeyword_9; }
	}

	public class SubsystemResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.SubsystemResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSubsystemKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTargetSystemAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTargetSystemSubcomponentCrossReference_1_0 = (CrossReference)cTargetSystemAssignment_1.eContents().get(0);
		private final RuleCall cTargetSystemSubcomponentIDTerminalRuleCall_1_0_1 = (RuleCall)cTargetSystemSubcomponentCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cMetricsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMetricsMetricsParserRuleCall_3_0 = (RuleCall)cMetricsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cMessageKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cMessageAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cMessageAssignment_4_1.eContents().get(0);
		private final Assignment cClaimResultAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final RuleCall cClaimResultClaimResultParserRuleCall_5_0 = (RuleCall)cClaimResultAssignment_5.eContents().get(0);
		private final Assignment cSubsystemResultAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cSubsystemResultSubsystemResultParserRuleCall_6_0 = (RuleCall)cSubsystemResultAssignment_6.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		
		//SubsystemResult:
		//	'subsystem' //name=QualifiedName 'for' 
		//	targetSystem=[aadl2::Subcomponent]
		//	'['
		//	metrics=Metrics ('message' message=STRING)?
		//	claimResult+=ClaimResult*
		//	subsystemResult+=SubsystemResult*
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'subsystem' //name=QualifiedName 'for' 
		//targetSystem=[aadl2::Subcomponent] '[' metrics=Metrics ('message' message=STRING)? claimResult+=ClaimResult*
		//subsystemResult+=SubsystemResult* ']'
		public Group getGroup() { return cGroup; }

		//'subsystem'
		public Keyword getSubsystemKeyword_0() { return cSubsystemKeyword_0; }

		////name=QualifiedName 'for' 
		//targetSystem=[aadl2::Subcomponent]
		public Assignment getTargetSystemAssignment_1() { return cTargetSystemAssignment_1; }

		//[aadl2::Subcomponent]
		public CrossReference getTargetSystemSubcomponentCrossReference_1_0() { return cTargetSystemSubcomponentCrossReference_1_0; }

		//ID
		public RuleCall getTargetSystemSubcomponentIDTerminalRuleCall_1_0_1() { return cTargetSystemSubcomponentIDTerminalRuleCall_1_0_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_3() { return cMetricsAssignment_3; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_3_0() { return cMetricsMetricsParserRuleCall_3_0; }

		//('message' message=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//'message'
		public Keyword getMessageKeyword_4_0() { return cMessageKeyword_4_0; }

		//message=STRING
		public Assignment getMessageAssignment_4_1() { return cMessageAssignment_4_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_4_1_0() { return cMessageSTRINGTerminalRuleCall_4_1_0; }

		//claimResult+=ClaimResult*
		public Assignment getClaimResultAssignment_5() { return cClaimResultAssignment_5; }

		//ClaimResult
		public RuleCall getClaimResultClaimResultParserRuleCall_5_0() { return cClaimResultClaimResultParserRuleCall_5_0; }

		//subsystemResult+=SubsystemResult*
		public Assignment getSubsystemResultAssignment_6() { return cSubsystemResultAssignment_6; }

		//SubsystemResult
		public RuleCall getSubsystemResultSubsystemResultParserRuleCall_6_0() { return cSubsystemResultSubsystemResultParserRuleCall_6_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_7() { return cRightSquareBracketKeyword_7; }
	}

	public class ClaimResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ClaimResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cClaimKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cTargetReferenceAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cTargetReferenceQualifiedClaimReferenceParserRuleCall_1_0 = (RuleCall)cTargetReferenceAssignment_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cMetricsAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cMetricsMetricsParserRuleCall_3_0 = (RuleCall)cMetricsAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cForKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cModelElementAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final CrossReference cModelElementNamedElementCrossReference_4_1_0 = (CrossReference)cModelElementAssignment_4_1.eContents().get(0);
		private final RuleCall cModelElementNamedElementIDTerminalRuleCall_4_1_0_1 = (RuleCall)cModelElementNamedElementCrossReference_4_1_0.eContents().get(1);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cMessageKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cMessageAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_5_1_0 = (RuleCall)cMessageAssignment_5_1.eContents().get(0);
		private final Assignment cSubClaimResultAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final RuleCall cSubClaimResultClaimResultParserRuleCall_6_0 = (RuleCall)cSubClaimResultAssignment_6.eContents().get(0);
		private final Assignment cVerificationActivityResultAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cVerificationActivityResultVerificationExprParserRuleCall_7_0 = (RuleCall)cVerificationActivityResultAssignment_7.eContents().get(0);
		private final Assignment cPredicateResultAssignment_8 = (Assignment)cGroup.eContents().get(8);
		private final RuleCall cPredicateResultPredicateResultParserRuleCall_8_0 = (RuleCall)cPredicateResultAssignment_8.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//// Result of meeting a requirement
		//ClaimResult:
		//	'claim' targetReference=QualifiedClaimReference //target=[ReqSpec::Requirement|QualifiedName]
		//	'['
		//	metrics=Metrics ('for' modelElement=[aadl2::NamedElement])? ('message' message=STRING)?
		//	subClaimResult+=ClaimResult*
		//	verificationActivityResult+=VerificationExpr*
		//	predicateResult=PredicateResult?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'claim' targetReference=QualifiedClaimReference //target=[ReqSpec::Requirement|QualifiedName]
		//'[' metrics=Metrics ('for' modelElement=[aadl2::NamedElement])? ('message' message=STRING)? subClaimResult+=ClaimResult*
		//verificationActivityResult+=VerificationExpr* predicateResult=PredicateResult? ']'
		public Group getGroup() { return cGroup; }

		//'claim'
		public Keyword getClaimKeyword_0() { return cClaimKeyword_0; }

		//targetReference=QualifiedClaimReference
		public Assignment getTargetReferenceAssignment_1() { return cTargetReferenceAssignment_1; }

		//QualifiedClaimReference
		public RuleCall getTargetReferenceQualifiedClaimReferenceParserRuleCall_1_0() { return cTargetReferenceQualifiedClaimReferenceParserRuleCall_1_0; }

		////target=[ReqSpec::Requirement|QualifiedName]
		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_3() { return cMetricsAssignment_3; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_3_0() { return cMetricsMetricsParserRuleCall_3_0; }

		//('for' modelElement=[aadl2::NamedElement])?
		public Group getGroup_4() { return cGroup_4; }

		//'for'
		public Keyword getForKeyword_4_0() { return cForKeyword_4_0; }

		//modelElement=[aadl2::NamedElement]
		public Assignment getModelElementAssignment_4_1() { return cModelElementAssignment_4_1; }

		//[aadl2::NamedElement]
		public CrossReference getModelElementNamedElementCrossReference_4_1_0() { return cModelElementNamedElementCrossReference_4_1_0; }

		//ID
		public RuleCall getModelElementNamedElementIDTerminalRuleCall_4_1_0_1() { return cModelElementNamedElementIDTerminalRuleCall_4_1_0_1; }

		//('message' message=STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//'message'
		public Keyword getMessageKeyword_5_0() { return cMessageKeyword_5_0; }

		//message=STRING
		public Assignment getMessageAssignment_5_1() { return cMessageAssignment_5_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_5_1_0() { return cMessageSTRINGTerminalRuleCall_5_1_0; }

		//subClaimResult+=ClaimResult*
		public Assignment getSubClaimResultAssignment_6() { return cSubClaimResultAssignment_6; }

		//ClaimResult
		public RuleCall getSubClaimResultClaimResultParserRuleCall_6_0() { return cSubClaimResultClaimResultParserRuleCall_6_0; }

		//verificationActivityResult+=VerificationExpr*
		public Assignment getVerificationActivityResultAssignment_7() { return cVerificationActivityResultAssignment_7; }

		//VerificationExpr
		public RuleCall getVerificationActivityResultVerificationExprParserRuleCall_7_0() { return cVerificationActivityResultVerificationExprParserRuleCall_7_0; }

		//predicateResult=PredicateResult?
		public Assignment getPredicateResultAssignment_8() { return cPredicateResultAssignment_8; }

		//PredicateResult
		public RuleCall getPredicateResultPredicateResultParserRuleCall_8_0() { return cPredicateResultPredicateResultParserRuleCall_8_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_9() { return cRightSquareBracketKeyword_9; }
	}

	public class PreconditionResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.PreconditionResult");
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
		private final Keyword cResultsKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cResultsAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final CrossReference cResultsAnalysisResultCrossReference_9_1_0 = (CrossReference)cResultsAssignment_9_1.eContents().get(0);
		private final RuleCall cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1 = (RuleCall)cResultsAnalysisResultCrossReference_9_1_0.eContents().get(1);
		private final Assignment cMetricsAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cMetricsMetricsParserRuleCall_10_0 = (RuleCall)cMetricsAssignment_10.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cMessageKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cMessageAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_11_1_0 = (RuleCall)cMessageAssignment_11_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_12 = (Keyword)cGroup.eContents().get(12);
		
		//PreconditionResult VerificationResult:
		//	'precondition' {PreconditionResult} target=[Verify::VerificationMethod|QualifiedName]
		//	'['
		//	'executionstate' executionState=VerificationExecutionState
		//	'resultstate' resultState=VerificationResultState ('issues' '['
		//	issues+=ResultIssue*
		//	']')? ('results' results=[results::AnalysisResult|QualifiedName])? // pointer to separate report
		//	metrics=Metrics ('message' message=STRING)?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'precondition' {PreconditionResult} target=[Verify::VerificationMethod|QualifiedName] '[' 'executionstate'
		//executionState=VerificationExecutionState 'resultstate' resultState=VerificationResultState ('issues' '['
		//issues+=ResultIssue* ']')? ('results' results=[results::AnalysisResult|QualifiedName])? // pointer to separate report
		//metrics=Metrics ('message' message=STRING)? ']'
		public Group getGroup() { return cGroup; }

		//'precondition'
		public Keyword getPreconditionKeyword_0() { return cPreconditionKeyword_0; }

		//{PreconditionResult}
		public Action getPreconditionResultAction_1() { return cPreconditionResultAction_1; }

		//target=[Verify::VerificationMethod|QualifiedName]
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }

		//[Verify::VerificationMethod|QualifiedName]
		public CrossReference getTargetVerificationMethodCrossReference_2_0() { return cTargetVerificationMethodCrossReference_2_0; }

		//QualifiedName
		public RuleCall getTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1() { return cTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//'executionstate'
		public Keyword getExecutionstateKeyword_4() { return cExecutionstateKeyword_4; }

		//executionState=VerificationExecutionState
		public Assignment getExecutionStateAssignment_5() { return cExecutionStateAssignment_5; }

		//VerificationExecutionState
		public RuleCall getExecutionStateVerificationExecutionStateEnumRuleCall_5_0() { return cExecutionStateVerificationExecutionStateEnumRuleCall_5_0; }

		//'resultstate'
		public Keyword getResultstateKeyword_6() { return cResultstateKeyword_6; }

		//resultState=VerificationResultState
		public Assignment getResultStateAssignment_7() { return cResultStateAssignment_7; }

		//VerificationResultState
		public RuleCall getResultStateVerificationResultStateEnumRuleCall_7_0() { return cResultStateVerificationResultStateEnumRuleCall_7_0; }

		//('issues' '[' issues+=ResultIssue* ']')?
		public Group getGroup_8() { return cGroup_8; }

		//'issues'
		public Keyword getIssuesKeyword_8_0() { return cIssuesKeyword_8_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_8_1() { return cLeftSquareBracketKeyword_8_1; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_8_2() { return cIssuesAssignment_8_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_2_0() { return cIssuesResultIssueParserRuleCall_8_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_8_3() { return cRightSquareBracketKeyword_8_3; }

		//('results' results=[results::AnalysisResult|QualifiedName])?
		public Group getGroup_9() { return cGroup_9; }

		//'results'
		public Keyword getResultsKeyword_9_0() { return cResultsKeyword_9_0; }

		//results=[results::AnalysisResult|QualifiedName]
		public Assignment getResultsAssignment_9_1() { return cResultsAssignment_9_1; }

		//[results::AnalysisResult|QualifiedName]
		public CrossReference getResultsAnalysisResultCrossReference_9_1_0() { return cResultsAnalysisResultCrossReference_9_1_0; }

		//QualifiedName
		public RuleCall getResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1() { return cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1; }

		//// pointer to separate report
		//metrics=Metrics
		public Assignment getMetricsAssignment_10() { return cMetricsAssignment_10; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_10_0() { return cMetricsMetricsParserRuleCall_10_0; }

		//('message' message=STRING)?
		public Group getGroup_11() { return cGroup_11; }

		//'message'
		public Keyword getMessageKeyword_11_0() { return cMessageKeyword_11_0; }

		//message=STRING
		public Assignment getMessageAssignment_11_1() { return cMessageAssignment_11_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_11_1_0() { return cMessageSTRINGTerminalRuleCall_11_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_12() { return cRightSquareBracketKeyword_12; }
	}

	public class ValidationResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ValidationResult");
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
		private final Keyword cResultsKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cResultsAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final CrossReference cResultsAnalysisResultCrossReference_9_1_0 = (CrossReference)cResultsAssignment_9_1.eContents().get(0);
		private final RuleCall cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1 = (RuleCall)cResultsAnalysisResultCrossReference_9_1_0.eContents().get(1);
		private final Assignment cMetricsAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cMetricsMetricsParserRuleCall_10_0 = (RuleCall)cMetricsAssignment_10.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cMessageKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cMessageAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_11_1_0 = (RuleCall)cMessageAssignment_11_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_12 = (Keyword)cGroup.eContents().get(12);
		
		//ValidationResult VerificationResult:
		//	'validation' {ValidationResult} target=[Verify::VerificationMethod|QualifiedName]
		//	'['
		//	'executionstate' executionState=VerificationExecutionState
		//	'resultstate' resultState=VerificationResultState ('issues' '['
		//	issues+=ResultIssue*
		//	']')? ('results' results=[results::AnalysisResult|QualifiedName])? // pointer to separate report
		//	metrics=Metrics ('message' message=STRING)?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'validation' {ValidationResult} target=[Verify::VerificationMethod|QualifiedName] '[' 'executionstate'
		//executionState=VerificationExecutionState 'resultstate' resultState=VerificationResultState ('issues' '['
		//issues+=ResultIssue* ']')? ('results' results=[results::AnalysisResult|QualifiedName])? // pointer to separate report
		//metrics=Metrics ('message' message=STRING)? ']'
		public Group getGroup() { return cGroup; }

		//'validation'
		public Keyword getValidationKeyword_0() { return cValidationKeyword_0; }

		//{ValidationResult}
		public Action getValidationResultAction_1() { return cValidationResultAction_1; }

		//target=[Verify::VerificationMethod|QualifiedName]
		public Assignment getTargetAssignment_2() { return cTargetAssignment_2; }

		//[Verify::VerificationMethod|QualifiedName]
		public CrossReference getTargetVerificationMethodCrossReference_2_0() { return cTargetVerificationMethodCrossReference_2_0; }

		//QualifiedName
		public RuleCall getTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1() { return cTargetVerificationMethodQualifiedNameParserRuleCall_2_0_1; }

		//'['
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//'executionstate'
		public Keyword getExecutionstateKeyword_4() { return cExecutionstateKeyword_4; }

		//executionState=VerificationExecutionState
		public Assignment getExecutionStateAssignment_5() { return cExecutionStateAssignment_5; }

		//VerificationExecutionState
		public RuleCall getExecutionStateVerificationExecutionStateEnumRuleCall_5_0() { return cExecutionStateVerificationExecutionStateEnumRuleCall_5_0; }

		//'resultstate'
		public Keyword getResultstateKeyword_6() { return cResultstateKeyword_6; }

		//resultState=VerificationResultState
		public Assignment getResultStateAssignment_7() { return cResultStateAssignment_7; }

		//VerificationResultState
		public RuleCall getResultStateVerificationResultStateEnumRuleCall_7_0() { return cResultStateVerificationResultStateEnumRuleCall_7_0; }

		//('issues' '[' issues+=ResultIssue* ']')?
		public Group getGroup_8() { return cGroup_8; }

		//'issues'
		public Keyword getIssuesKeyword_8_0() { return cIssuesKeyword_8_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_8_1() { return cLeftSquareBracketKeyword_8_1; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_8_2() { return cIssuesAssignment_8_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_2_0() { return cIssuesResultIssueParserRuleCall_8_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_8_3() { return cRightSquareBracketKeyword_8_3; }

		//('results' results=[results::AnalysisResult|QualifiedName])?
		public Group getGroup_9() { return cGroup_9; }

		//'results'
		public Keyword getResultsKeyword_9_0() { return cResultsKeyword_9_0; }

		//results=[results::AnalysisResult|QualifiedName]
		public Assignment getResultsAssignment_9_1() { return cResultsAssignment_9_1; }

		//[results::AnalysisResult|QualifiedName]
		public CrossReference getResultsAnalysisResultCrossReference_9_1_0() { return cResultsAnalysisResultCrossReference_9_1_0; }

		//QualifiedName
		public RuleCall getResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1() { return cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1; }

		//// pointer to separate report
		//metrics=Metrics
		public Assignment getMetricsAssignment_10() { return cMetricsAssignment_10; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_10_0() { return cMetricsMetricsParserRuleCall_10_0; }

		//('message' message=STRING)?
		public Group getGroup_11() { return cGroup_11; }

		//'message'
		public Keyword getMessageKeyword_11_0() { return cMessageKeyword_11_0; }

		//message=STRING
		public Assignment getMessageAssignment_11_1() { return cMessageAssignment_11_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_11_1_0() { return cMessageSTRINGTerminalRuleCall_11_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_12() { return cRightSquareBracketKeyword_12; }
	}

	public class VerificationActivityResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.VerificationActivityResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cVerificationKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Action cVerificationActivityResultAction_1 = (Action)cGroup.eContents().get(1);
		private final Assignment cTargetReferenceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTargetReferenceQualifiedVAReferenceParserRuleCall_2_0 = (RuleCall)cTargetReferenceAssignment_2.eContents().get(0);
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
		private final Keyword cResultsKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cResultsAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final CrossReference cResultsAnalysisResultCrossReference_9_1_0 = (CrossReference)cResultsAssignment_9_1.eContents().get(0);
		private final RuleCall cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1 = (RuleCall)cResultsAnalysisResultCrossReference_9_1_0.eContents().get(1);
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
		//VerificationActivityResult VerificationResult:
		//	'verification' {VerificationActivityResult} targetReference=QualifiedVAReference //target=[Verify::VerificationActivity|QualifiedName]
		//	'['
		//	'executionstate' executionState=VerificationExecutionState
		//	'resultstate' resultState=VerificationResultState ('issues' '['
		//	issues+=ResultIssue*
		//	']')? ('results' results=[results::AnalysisResult|QualifiedName])?
		//	metrics=Metrics ('message' message=STRING)?
		//	preconditionResult=PreconditionResult?
		//	validationResult=ValidationResult?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'verification' {VerificationActivityResult} targetReference=QualifiedVAReference //target=[Verify::VerificationActivity|QualifiedName]
		//'[' 'executionstate' executionState=VerificationExecutionState 'resultstate' resultState=VerificationResultState
		//('issues' '[' issues+=ResultIssue* ']')? ('results' results=[results::AnalysisResult|QualifiedName])? metrics=Metrics
		//('message' message=STRING)? preconditionResult=PreconditionResult? validationResult=ValidationResult? ']'
		public Group getGroup() { return cGroup; }

		//'verification'
		public Keyword getVerificationKeyword_0() { return cVerificationKeyword_0; }

		//{VerificationActivityResult}
		public Action getVerificationActivityResultAction_1() { return cVerificationActivityResultAction_1; }

		//targetReference=QualifiedVAReference
		public Assignment getTargetReferenceAssignment_2() { return cTargetReferenceAssignment_2; }

		//QualifiedVAReference
		public RuleCall getTargetReferenceQualifiedVAReferenceParserRuleCall_2_0() { return cTargetReferenceQualifiedVAReferenceParserRuleCall_2_0; }

		////target=[Verify::VerificationActivity|QualifiedName]
		//'['
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//'executionstate'
		public Keyword getExecutionstateKeyword_4() { return cExecutionstateKeyword_4; }

		//executionState=VerificationExecutionState
		public Assignment getExecutionStateAssignment_5() { return cExecutionStateAssignment_5; }

		//VerificationExecutionState
		public RuleCall getExecutionStateVerificationExecutionStateEnumRuleCall_5_0() { return cExecutionStateVerificationExecutionStateEnumRuleCall_5_0; }

		//'resultstate'
		public Keyword getResultstateKeyword_6() { return cResultstateKeyword_6; }

		//resultState=VerificationResultState
		public Assignment getResultStateAssignment_7() { return cResultStateAssignment_7; }

		//VerificationResultState
		public RuleCall getResultStateVerificationResultStateEnumRuleCall_7_0() { return cResultStateVerificationResultStateEnumRuleCall_7_0; }

		//('issues' '[' issues+=ResultIssue* ']')?
		public Group getGroup_8() { return cGroup_8; }

		//'issues'
		public Keyword getIssuesKeyword_8_0() { return cIssuesKeyword_8_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_8_1() { return cLeftSquareBracketKeyword_8_1; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_8_2() { return cIssuesAssignment_8_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_2_0() { return cIssuesResultIssueParserRuleCall_8_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_8_3() { return cRightSquareBracketKeyword_8_3; }

		//('results' results=[results::AnalysisResult|QualifiedName])?
		public Group getGroup_9() { return cGroup_9; }

		//'results'
		public Keyword getResultsKeyword_9_0() { return cResultsKeyword_9_0; }

		//results=[results::AnalysisResult|QualifiedName]
		public Assignment getResultsAssignment_9_1() { return cResultsAssignment_9_1; }

		//[results::AnalysisResult|QualifiedName]
		public CrossReference getResultsAnalysisResultCrossReference_9_1_0() { return cResultsAnalysisResultCrossReference_9_1_0; }

		//QualifiedName
		public RuleCall getResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1() { return cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_10() { return cMetricsAssignment_10; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_10_0() { return cMetricsMetricsParserRuleCall_10_0; }

		//('message' message=STRING)?
		public Group getGroup_11() { return cGroup_11; }

		//'message'
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

		//']'
		public Keyword getRightSquareBracketKeyword_14() { return cRightSquareBracketKeyword_14; }
	}

	public class PredicateResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.PredicateResult");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPredicateResultAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cPredicateKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTargetReferenceAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTargetReferenceQualifiedClaimReferenceParserRuleCall_2_0 = (RuleCall)cTargetReferenceAssignment_2.eContents().get(0);
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
		private final Keyword cResultsKeyword_9_0 = (Keyword)cGroup_9.eContents().get(0);
		private final Assignment cResultsAssignment_9_1 = (Assignment)cGroup_9.eContents().get(1);
		private final CrossReference cResultsAnalysisResultCrossReference_9_1_0 = (CrossReference)cResultsAssignment_9_1.eContents().get(0);
		private final RuleCall cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1 = (RuleCall)cResultsAnalysisResultCrossReference_9_1_0.eContents().get(1);
		private final Assignment cMetricsAssignment_10 = (Assignment)cGroup.eContents().get(10);
		private final RuleCall cMetricsMetricsParserRuleCall_10_0 = (RuleCall)cMetricsAssignment_10.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cMessageKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cMessageAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_11_1_0 = (RuleCall)cMessageAssignment_11_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_12 = (Keyword)cGroup.eContents().get(12);
		
		//PredicateResult VerificationResult:
		//	{PredicateResult}
		//	'predicate' targetReference=QualifiedClaimReference
		//	'['
		//	'executionstate' executionState=VerificationExecutionState
		//	'resultstate' resultState=VerificationResultState ('issues' '['
		//	issues+=ResultIssue*
		//	']')? ('results' results=[results::AnalysisResult|QualifiedName])?
		//	metrics=Metrics ('message' message=STRING)?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//{PredicateResult} 'predicate' targetReference=QualifiedClaimReference '[' 'executionstate'
		//executionState=VerificationExecutionState 'resultstate' resultState=VerificationResultState ('issues' '['
		//issues+=ResultIssue* ']')? ('results' results=[results::AnalysisResult|QualifiedName])? metrics=Metrics ('message'
		//message=STRING)? ']'
		public Group getGroup() { return cGroup; }

		//{PredicateResult}
		public Action getPredicateResultAction_0() { return cPredicateResultAction_0; }

		//'predicate'
		public Keyword getPredicateKeyword_1() { return cPredicateKeyword_1; }

		//targetReference=QualifiedClaimReference
		public Assignment getTargetReferenceAssignment_2() { return cTargetReferenceAssignment_2; }

		//QualifiedClaimReference
		public RuleCall getTargetReferenceQualifiedClaimReferenceParserRuleCall_2_0() { return cTargetReferenceQualifiedClaimReferenceParserRuleCall_2_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//'executionstate'
		public Keyword getExecutionstateKeyword_4() { return cExecutionstateKeyword_4; }

		//executionState=VerificationExecutionState
		public Assignment getExecutionStateAssignment_5() { return cExecutionStateAssignment_5; }

		//VerificationExecutionState
		public RuleCall getExecutionStateVerificationExecutionStateEnumRuleCall_5_0() { return cExecutionStateVerificationExecutionStateEnumRuleCall_5_0; }

		//'resultstate'
		public Keyword getResultstateKeyword_6() { return cResultstateKeyword_6; }

		//resultState=VerificationResultState
		public Assignment getResultStateAssignment_7() { return cResultStateAssignment_7; }

		//VerificationResultState
		public RuleCall getResultStateVerificationResultStateEnumRuleCall_7_0() { return cResultStateVerificationResultStateEnumRuleCall_7_0; }

		//('issues' '[' issues+=ResultIssue* ']')?
		public Group getGroup_8() { return cGroup_8; }

		//'issues'
		public Keyword getIssuesKeyword_8_0() { return cIssuesKeyword_8_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_8_1() { return cLeftSquareBracketKeyword_8_1; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_8_2() { return cIssuesAssignment_8_2; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_8_2_0() { return cIssuesResultIssueParserRuleCall_8_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_8_3() { return cRightSquareBracketKeyword_8_3; }

		//('results' results=[results::AnalysisResult|QualifiedName])?
		public Group getGroup_9() { return cGroup_9; }

		//'results'
		public Keyword getResultsKeyword_9_0() { return cResultsKeyword_9_0; }

		//results=[results::AnalysisResult|QualifiedName]
		public Assignment getResultsAssignment_9_1() { return cResultsAssignment_9_1; }

		//[results::AnalysisResult|QualifiedName]
		public CrossReference getResultsAnalysisResultCrossReference_9_1_0() { return cResultsAnalysisResultCrossReference_9_1_0; }

		//QualifiedName
		public RuleCall getResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1() { return cResultsAnalysisResultQualifiedNameParserRuleCall_9_1_0_1; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_10() { return cMetricsAssignment_10; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_10_0() { return cMetricsMetricsParserRuleCall_10_0; }

		//('message' message=STRING)?
		public Group getGroup_11() { return cGroup_11; }

		//'message'
		public Keyword getMessageKeyword_11_0() { return cMessageKeyword_11_0; }

		//message=STRING
		public Assignment getMessageAssignment_11_1() { return cMessageAssignment_11_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_11_1_0() { return cMessageSTRINGTerminalRuleCall_11_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_12() { return cRightSquareBracketKeyword_12; }
	}

	public class AssureResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.AssureResult");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVerificationExprParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cModelResultParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSubsystemResultParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cAssuranceCaseResultParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cClaimResultParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cPreconditionResultParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cValidationResultParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cPredicateResultParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		
		//AssureResult:
		//	VerificationExpr | ModelResult | SubsystemResult | AssuranceCaseResult | ClaimResult | PreconditionResult |
		//	ValidationResult | PredicateResult;
		@Override public ParserRule getRule() { return rule; }

		//VerificationExpr | ModelResult | SubsystemResult | AssuranceCaseResult | ClaimResult | PreconditionResult |
		//ValidationResult | PredicateResult
		public Alternatives getAlternatives() { return cAlternatives; }

		//VerificationExpr
		public RuleCall getVerificationExprParserRuleCall_0() { return cVerificationExprParserRuleCall_0; }

		//ModelResult
		public RuleCall getModelResultParserRuleCall_1() { return cModelResultParserRuleCall_1; }

		//SubsystemResult
		public RuleCall getSubsystemResultParserRuleCall_2() { return cSubsystemResultParserRuleCall_2; }

		//AssuranceCaseResult
		public RuleCall getAssuranceCaseResultParserRuleCall_3() { return cAssuranceCaseResultParserRuleCall_3; }

		//ClaimResult
		public RuleCall getClaimResultParserRuleCall_4() { return cClaimResultParserRuleCall_4; }

		//PreconditionResult
		public RuleCall getPreconditionResultParserRuleCall_5() { return cPreconditionResultParserRuleCall_5; }

		//ValidationResult
		public RuleCall getValidationResultParserRuleCall_6() { return cValidationResultParserRuleCall_6; }

		//PredicateResult
		public RuleCall getPredicateResultParserRuleCall_7() { return cPredicateResultParserRuleCall_7; }
	}

	public class VerificationExprElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.VerificationExpr");
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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ElseResult");
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
		//	'else' first+=VerificationExpr+ ('error' error+=VerificationExpr+)? ('fail' fail+=VerificationExpr+)? ('timeout'
		//	timeout+=VerificationExpr+)?
		//	'['
		//	didFail=ElseType?
		//	metrics=Metrics
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'else' first+=VerificationExpr+ ('error' error+=VerificationExpr+)? ('fail' fail+=VerificationExpr+)? ('timeout'
		//timeout+=VerificationExpr+)? '[' didFail=ElseType? metrics=Metrics ']'
		public Group getGroup() { return cGroup; }

		//'else'
		public Keyword getElseKeyword_0() { return cElseKeyword_0; }

		//first+=VerificationExpr+
		public Assignment getFirstAssignment_1() { return cFirstAssignment_1; }

		//VerificationExpr
		public RuleCall getFirstVerificationExprParserRuleCall_1_0() { return cFirstVerificationExprParserRuleCall_1_0; }

		//('error' error+=VerificationExpr+)?
		public Group getGroup_2() { return cGroup_2; }

		//'error'
		public Keyword getErrorKeyword_2_0() { return cErrorKeyword_2_0; }

		//error+=VerificationExpr+
		public Assignment getErrorAssignment_2_1() { return cErrorAssignment_2_1; }

		//VerificationExpr
		public RuleCall getErrorVerificationExprParserRuleCall_2_1_0() { return cErrorVerificationExprParserRuleCall_2_1_0; }

		//('fail' fail+=VerificationExpr+)?
		public Group getGroup_3() { return cGroup_3; }

		//'fail'
		public Keyword getFailKeyword_3_0() { return cFailKeyword_3_0; }

		//fail+=VerificationExpr+
		public Assignment getFailAssignment_3_1() { return cFailAssignment_3_1; }

		//VerificationExpr
		public RuleCall getFailVerificationExprParserRuleCall_3_1_0() { return cFailVerificationExprParserRuleCall_3_1_0; }

		//('timeout' timeout+=VerificationExpr+)?
		public Group getGroup_4() { return cGroup_4; }

		//'timeout'
		public Keyword getTimeoutKeyword_4_0() { return cTimeoutKeyword_4_0; }

		//timeout+=VerificationExpr+
		public Assignment getTimeoutAssignment_4_1() { return cTimeoutAssignment_4_1; }

		//VerificationExpr
		public RuleCall getTimeoutVerificationExprParserRuleCall_4_1_0() { return cTimeoutVerificationExprParserRuleCall_4_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_5() { return cLeftSquareBracketKeyword_5; }

		//didFail=ElseType?
		public Assignment getDidFailAssignment_6() { return cDidFailAssignment_6; }

		//ElseType
		public RuleCall getDidFailElseTypeEnumRuleCall_6_0() { return cDidFailElseTypeEnumRuleCall_6_0; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_7() { return cMetricsAssignment_7; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_7_0() { return cMetricsMetricsParserRuleCall_7_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class ThenResultElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ThenResult");
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
		//	'then' first+=VerificationExpr+ 'do' second+=VerificationExpr+
		//	'['
		//	didThenFail?='thenfailed'?
		//	metrics=Metrics
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'then' first+=VerificationExpr+ 'do' second+=VerificationExpr+ '[' didThenFail?='thenfailed'? metrics=Metrics ']'
		public Group getGroup() { return cGroup; }

		//'then'
		public Keyword getThenKeyword_0() { return cThenKeyword_0; }

		//first+=VerificationExpr+
		public Assignment getFirstAssignment_1() { return cFirstAssignment_1; }

		//VerificationExpr
		public RuleCall getFirstVerificationExprParserRuleCall_1_0() { return cFirstVerificationExprParserRuleCall_1_0; }

		//'do'
		public Keyword getDoKeyword_2() { return cDoKeyword_2; }

		//second+=VerificationExpr+
		public Assignment getSecondAssignment_3() { return cSecondAssignment_3; }

		//VerificationExpr
		public RuleCall getSecondVerificationExprParserRuleCall_3_0() { return cSecondVerificationExprParserRuleCall_3_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_4() { return cLeftSquareBracketKeyword_4; }

		//didThenFail?='thenfailed'?
		public Assignment getDidThenFailAssignment_5() { return cDidThenFailAssignment_5; }

		//'thenfailed'
		public Keyword getDidThenFailThenfailedKeyword_5_0() { return cDidThenFailThenfailedKeyword_5_0; }

		//metrics=Metrics
		public Assignment getMetricsAssignment_6() { return cMetricsAssignment_6; }

		//Metrics
		public RuleCall getMetricsMetricsParserRuleCall_6_0() { return cMetricsMetricsParserRuleCall_6_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_7() { return cRightSquareBracketKeyword_7; }
	}

	public class MetricsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.Metrics");
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
		private final Keyword cFeaturescountKeyword_10_0 = (Keyword)cGroup_10.eContents().get(0);
		private final Assignment cFeaturesCountAssignment_10_1 = (Assignment)cGroup_10.eContents().get(1);
		private final RuleCall cFeaturesCountINTTerminalRuleCall_10_1_0 = (RuleCall)cFeaturesCountAssignment_10_1.eContents().get(0);
		private final Group cGroup_11 = (Group)cGroup.eContents().get(11);
		private final Keyword cFeaturesrequirementscountKeyword_11_0 = (Keyword)cGroup_11.eContents().get(0);
		private final Assignment cFeaturesRequirementsCountAssignment_11_1 = (Assignment)cGroup_11.eContents().get(1);
		private final RuleCall cFeaturesRequirementsCountINTTerminalRuleCall_11_1_0 = (RuleCall)cFeaturesRequirementsCountAssignment_11_1.eContents().get(0);
		private final Group cGroup_12 = (Group)cGroup.eContents().get(12);
		private final Keyword cQualitycategoryrequirementscountKeyword_12_0 = (Keyword)cGroup_12.eContents().get(0);
		private final Assignment cQualityCategoryRequirementsCountAssignment_12_1 = (Assignment)cGroup_12.eContents().get(1);
		private final RuleCall cQualityCategoryRequirementsCountINTTerminalRuleCall_12_1_0 = (RuleCall)cQualityCategoryRequirementsCountAssignment_12_1.eContents().get(0);
		private final Group cGroup_13 = (Group)cGroup.eContents().get(13);
		private final Keyword cTotalqualitycategorycountKeyword_13_0 = (Keyword)cGroup_13.eContents().get(0);
		private final Assignment cTotalQualityCategoryCountAssignment_13_1 = (Assignment)cGroup_13.eContents().get(1);
		private final RuleCall cTotalQualityCategoryCountINTTerminalRuleCall_13_1_0 = (RuleCall)cTotalQualityCategoryCountAssignment_13_1.eContents().get(0);
		private final Group cGroup_14 = (Group)cGroup.eContents().get(14);
		private final Keyword cRequirementswithoutplanclaimcountKeyword_14_0 = (Keyword)cGroup_14.eContents().get(0);
		private final Assignment cRequirementsWithoutPlanClaimCountAssignment_14_1 = (Assignment)cGroup_14.eContents().get(1);
		private final RuleCall cRequirementsWithoutPlanClaimCountINTTerminalRuleCall_14_1_0 = (RuleCall)cRequirementsWithoutPlanClaimCountAssignment_14_1.eContents().get(0);
		private final Group cGroup_15 = (Group)cGroup.eContents().get(15);
		private final Keyword cNoverificationplanscountKeyword_15_0 = (Keyword)cGroup_15.eContents().get(0);
		private final Assignment cNoVerificationPlansCountAssignment_15_1 = (Assignment)cGroup_15.eContents().get(1);
		private final RuleCall cNoVerificationPlansCountINTTerminalRuleCall_15_1_0 = (RuleCall)cNoVerificationPlansCountAssignment_15_1.eContents().get(0);
		private final Group cGroup_16 = (Group)cGroup.eContents().get(16);
		private final Keyword cRequirementscountKeyword_16_0 = (Keyword)cGroup_16.eContents().get(0);
		private final Assignment cRequirementsCountAssignment_16_1 = (Assignment)cGroup_16.eContents().get(1);
		private final RuleCall cRequirementsCountINTTerminalRuleCall_16_1_0 = (RuleCall)cRequirementsCountAssignment_16_1.eContents().get(0);
		private final Group cGroup_17 = (Group)cGroup.eContents().get(17);
		private final Keyword cExceptionscountKeyword_17_0 = (Keyword)cGroup_17.eContents().get(0);
		private final Assignment cExceptionsCountAssignment_17_1 = (Assignment)cGroup_17.eContents().get(1);
		private final RuleCall cExceptionsCountINTTerminalRuleCall_17_1_0 = (RuleCall)cExceptionsCountAssignment_17_1.eContents().get(0);
		private final Group cGroup_18 = (Group)cGroup.eContents().get(18);
		private final Keyword cReqtargethasemv2subclausecountKeyword_18_0 = (Keyword)cGroup_18.eContents().get(0);
		private final Assignment cReqTargetHasEMV2SubclauseCountAssignment_18_1 = (Assignment)cGroup_18.eContents().get(1);
		private final RuleCall cReqTargetHasEMV2SubclauseCountINTTerminalRuleCall_18_1_0 = (RuleCall)cReqTargetHasEMV2SubclauseCountAssignment_18_1.eContents().get(0);
		private final Group cGroup_19 = (Group)cGroup.eContents().get(19);
		private final Keyword cFeaturesrequiringclassifiercountKeyword_19_0 = (Keyword)cGroup_19.eContents().get(0);
		private final Assignment cFeaturesRequiringClassifierCountAssignment_19_1 = (Assignment)cGroup_19.eContents().get(1);
		private final RuleCall cFeaturesRequiringClassifierCountINTTerminalRuleCall_19_1_0 = (RuleCall)cFeaturesRequiringClassifierCountAssignment_19_1.eContents().get(0);
		private final Group cGroup_20 = (Group)cGroup.eContents().get(20);
		private final Keyword cFeatureswithrequiredclassifiercountKeyword_20_0 = (Keyword)cGroup_20.eContents().get(0);
		private final Assignment cFeaturesWithRequiredClassifierCountAssignment_20_1 = (Assignment)cGroup_20.eContents().get(1);
		private final RuleCall cFeaturesWithRequiredClassifierCountINTTerminalRuleCall_20_1_0 = (RuleCall)cFeaturesWithRequiredClassifierCountAssignment_20_1.eContents().get(0);
		private final Group cGroup_21 = (Group)cGroup.eContents().get(21);
		private final Keyword cWeightKeyword_21_0 = (Keyword)cGroup_21.eContents().get(0);
		private final Assignment cWeightAssignment_21_1 = (Assignment)cGroup_21.eContents().get(1);
		private final RuleCall cWeightINTTerminalRuleCall_21_1_0 = (RuleCall)cWeightAssignment_21_1.eContents().get(0);
		private final Group cGroup_22 = (Group)cGroup.eContents().get(22);
		private final Keyword cTimeKeyword_22_0 = (Keyword)cGroup_22.eContents().get(0);
		private final Assignment cExecutionTimeAssignment_22_1 = (Assignment)cGroup_22.eContents().get(1);
		private final RuleCall cExecutionTimeAIntParserRuleCall_22_1_0 = (RuleCall)cExecutionTimeAssignment_22_1.eContents().get(0);
		
		//Metrics:
		//	{Metrics} ('tbdcount' tbdCount=INT)? ('successcount' successCount=INT)? ('failcount' failCount=INT)? ('timeoutcount'
		//	timeoutCount=INT)? ('errorcount' errorCount=INT)? ('didelsecount' didelseCount=INT)? ('thenskipcount'
		//	thenskipCount=INT)? ('prefailcount' preconditionfailCount=INT)? ('validfailcount' validationfailCount=INT)?
		//	('featurescount' featuresCount=INT)? ('featuresrequirementscount' featuresRequirementsCount=INT)?
		//	('qualitycategoryrequirementscount' qualityCategoryRequirementsCount=INT)? ('totalqualitycategorycount'
		//	totalQualityCategoryCount=INT)? ('requirementswithoutplanclaimcount' requirementsWithoutPlanClaimCount=INT)?
		//	('noverificationplanscount' noVerificationPlansCount=INT)? ('requirementscount' requirementsCount=INT)?
		//	('exceptionscount' exceptionsCount=INT)? ('reqtargethasemv2subclausecount' reqTargetHasEMV2SubclauseCount=INT)?
		//	('featuresrequiringclassifiercount' featuresRequiringClassifierCount=INT)? ('featureswithrequiredclassifiercount'
		//	featuresWithRequiredClassifierCount=INT)? ('weight' weight=INT)? ('time' executionTime=AInt)?;
		@Override public ParserRule getRule() { return rule; }

		//{Metrics} ('tbdcount' tbdCount=INT)? ('successcount' successCount=INT)? ('failcount' failCount=INT)? ('timeoutcount'
		//timeoutCount=INT)? ('errorcount' errorCount=INT)? ('didelsecount' didelseCount=INT)? ('thenskipcount'
		//thenskipCount=INT)? ('prefailcount' preconditionfailCount=INT)? ('validfailcount' validationfailCount=INT)?
		//('featurescount' featuresCount=INT)? ('featuresrequirementscount' featuresRequirementsCount=INT)?
		//('qualitycategoryrequirementscount' qualityCategoryRequirementsCount=INT)? ('totalqualitycategorycount'
		//totalQualityCategoryCount=INT)? ('requirementswithoutplanclaimcount' requirementsWithoutPlanClaimCount=INT)?
		//('noverificationplanscount' noVerificationPlansCount=INT)? ('requirementscount' requirementsCount=INT)?
		//('exceptionscount' exceptionsCount=INT)? ('reqtargethasemv2subclausecount' reqTargetHasEMV2SubclauseCount=INT)?
		//('featuresrequiringclassifiercount' featuresRequiringClassifierCount=INT)? ('featureswithrequiredclassifiercount'
		//featuresWithRequiredClassifierCount=INT)? ('weight' weight=INT)? ('time' executionTime=AInt)?
		public Group getGroup() { return cGroup; }

		//{Metrics}
		public Action getMetricsAction_0() { return cMetricsAction_0; }

		//('tbdcount' tbdCount=INT)?
		public Group getGroup_1() { return cGroup_1; }

		//'tbdcount'
		public Keyword getTbdcountKeyword_1_0() { return cTbdcountKeyword_1_0; }

		//tbdCount=INT
		public Assignment getTbdCountAssignment_1_1() { return cTbdCountAssignment_1_1; }

		//INT
		public RuleCall getTbdCountINTTerminalRuleCall_1_1_0() { return cTbdCountINTTerminalRuleCall_1_1_0; }

		//('successcount' successCount=INT)?
		public Group getGroup_2() { return cGroup_2; }

		//'successcount'
		public Keyword getSuccesscountKeyword_2_0() { return cSuccesscountKeyword_2_0; }

		//successCount=INT
		public Assignment getSuccessCountAssignment_2_1() { return cSuccessCountAssignment_2_1; }

		//INT
		public RuleCall getSuccessCountINTTerminalRuleCall_2_1_0() { return cSuccessCountINTTerminalRuleCall_2_1_0; }

		//('failcount' failCount=INT)?
		public Group getGroup_3() { return cGroup_3; }

		//'failcount'
		public Keyword getFailcountKeyword_3_0() { return cFailcountKeyword_3_0; }

		//failCount=INT
		public Assignment getFailCountAssignment_3_1() { return cFailCountAssignment_3_1; }

		//INT
		public RuleCall getFailCountINTTerminalRuleCall_3_1_0() { return cFailCountINTTerminalRuleCall_3_1_0; }

		//('timeoutcount' timeoutCount=INT)?
		public Group getGroup_4() { return cGroup_4; }

		//'timeoutcount'
		public Keyword getTimeoutcountKeyword_4_0() { return cTimeoutcountKeyword_4_0; }

		//timeoutCount=INT
		public Assignment getTimeoutCountAssignment_4_1() { return cTimeoutCountAssignment_4_1; }

		//INT
		public RuleCall getTimeoutCountINTTerminalRuleCall_4_1_0() { return cTimeoutCountINTTerminalRuleCall_4_1_0; }

		//('errorcount' errorCount=INT)?
		public Group getGroup_5() { return cGroup_5; }

		//'errorcount'
		public Keyword getErrorcountKeyword_5_0() { return cErrorcountKeyword_5_0; }

		//errorCount=INT
		public Assignment getErrorCountAssignment_5_1() { return cErrorCountAssignment_5_1; }

		//INT
		public RuleCall getErrorCountINTTerminalRuleCall_5_1_0() { return cErrorCountINTTerminalRuleCall_5_1_0; }

		//('didelsecount' didelseCount=INT)?
		public Group getGroup_6() { return cGroup_6; }

		//'didelsecount'
		public Keyword getDidelsecountKeyword_6_0() { return cDidelsecountKeyword_6_0; }

		//didelseCount=INT
		public Assignment getDidelseCountAssignment_6_1() { return cDidelseCountAssignment_6_1; }

		//INT
		public RuleCall getDidelseCountINTTerminalRuleCall_6_1_0() { return cDidelseCountINTTerminalRuleCall_6_1_0; }

		//('thenskipcount' thenskipCount=INT)?
		public Group getGroup_7() { return cGroup_7; }

		//'thenskipcount'
		public Keyword getThenskipcountKeyword_7_0() { return cThenskipcountKeyword_7_0; }

		//thenskipCount=INT
		public Assignment getThenskipCountAssignment_7_1() { return cThenskipCountAssignment_7_1; }

		//INT
		public RuleCall getThenskipCountINTTerminalRuleCall_7_1_0() { return cThenskipCountINTTerminalRuleCall_7_1_0; }

		//('prefailcount' preconditionfailCount=INT)?
		public Group getGroup_8() { return cGroup_8; }

		//'prefailcount'
		public Keyword getPrefailcountKeyword_8_0() { return cPrefailcountKeyword_8_0; }

		//preconditionfailCount=INT
		public Assignment getPreconditionfailCountAssignment_8_1() { return cPreconditionfailCountAssignment_8_1; }

		//INT
		public RuleCall getPreconditionfailCountINTTerminalRuleCall_8_1_0() { return cPreconditionfailCountINTTerminalRuleCall_8_1_0; }

		//('validfailcount' validationfailCount=INT)?
		public Group getGroup_9() { return cGroup_9; }

		//'validfailcount'
		public Keyword getValidfailcountKeyword_9_0() { return cValidfailcountKeyword_9_0; }

		//validationfailCount=INT
		public Assignment getValidationfailCountAssignment_9_1() { return cValidationfailCountAssignment_9_1; }

		//INT
		public RuleCall getValidationfailCountINTTerminalRuleCall_9_1_0() { return cValidationfailCountINTTerminalRuleCall_9_1_0; }

		//('featurescount' featuresCount=INT)?
		public Group getGroup_10() { return cGroup_10; }

		//'featurescount'
		public Keyword getFeaturescountKeyword_10_0() { return cFeaturescountKeyword_10_0; }

		//featuresCount=INT
		public Assignment getFeaturesCountAssignment_10_1() { return cFeaturesCountAssignment_10_1; }

		//INT
		public RuleCall getFeaturesCountINTTerminalRuleCall_10_1_0() { return cFeaturesCountINTTerminalRuleCall_10_1_0; }

		//('featuresrequirementscount' featuresRequirementsCount=INT)?
		public Group getGroup_11() { return cGroup_11; }

		//'featuresrequirementscount'
		public Keyword getFeaturesrequirementscountKeyword_11_0() { return cFeaturesrequirementscountKeyword_11_0; }

		//featuresRequirementsCount=INT
		public Assignment getFeaturesRequirementsCountAssignment_11_1() { return cFeaturesRequirementsCountAssignment_11_1; }

		//INT
		public RuleCall getFeaturesRequirementsCountINTTerminalRuleCall_11_1_0() { return cFeaturesRequirementsCountINTTerminalRuleCall_11_1_0; }

		//('qualitycategoryrequirementscount' qualityCategoryRequirementsCount=INT)?
		public Group getGroup_12() { return cGroup_12; }

		//'qualitycategoryrequirementscount'
		public Keyword getQualitycategoryrequirementscountKeyword_12_0() { return cQualitycategoryrequirementscountKeyword_12_0; }

		//qualityCategoryRequirementsCount=INT
		public Assignment getQualityCategoryRequirementsCountAssignment_12_1() { return cQualityCategoryRequirementsCountAssignment_12_1; }

		//INT
		public RuleCall getQualityCategoryRequirementsCountINTTerminalRuleCall_12_1_0() { return cQualityCategoryRequirementsCountINTTerminalRuleCall_12_1_0; }

		//('totalqualitycategorycount' totalQualityCategoryCount=INT)?
		public Group getGroup_13() { return cGroup_13; }

		//'totalqualitycategorycount'
		public Keyword getTotalqualitycategorycountKeyword_13_0() { return cTotalqualitycategorycountKeyword_13_0; }

		//totalQualityCategoryCount=INT
		public Assignment getTotalQualityCategoryCountAssignment_13_1() { return cTotalQualityCategoryCountAssignment_13_1; }

		//INT
		public RuleCall getTotalQualityCategoryCountINTTerminalRuleCall_13_1_0() { return cTotalQualityCategoryCountINTTerminalRuleCall_13_1_0; }

		//('requirementswithoutplanclaimcount' requirementsWithoutPlanClaimCount=INT)?
		public Group getGroup_14() { return cGroup_14; }

		//'requirementswithoutplanclaimcount'
		public Keyword getRequirementswithoutplanclaimcountKeyword_14_0() { return cRequirementswithoutplanclaimcountKeyword_14_0; }

		//requirementsWithoutPlanClaimCount=INT
		public Assignment getRequirementsWithoutPlanClaimCountAssignment_14_1() { return cRequirementsWithoutPlanClaimCountAssignment_14_1; }

		//INT
		public RuleCall getRequirementsWithoutPlanClaimCountINTTerminalRuleCall_14_1_0() { return cRequirementsWithoutPlanClaimCountINTTerminalRuleCall_14_1_0; }

		//('noverificationplanscount' noVerificationPlansCount=INT)?
		public Group getGroup_15() { return cGroup_15; }

		//'noverificationplanscount'
		public Keyword getNoverificationplanscountKeyword_15_0() { return cNoverificationplanscountKeyword_15_0; }

		//noVerificationPlansCount=INT
		public Assignment getNoVerificationPlansCountAssignment_15_1() { return cNoVerificationPlansCountAssignment_15_1; }

		//INT
		public RuleCall getNoVerificationPlansCountINTTerminalRuleCall_15_1_0() { return cNoVerificationPlansCountINTTerminalRuleCall_15_1_0; }

		//('requirementscount' requirementsCount=INT)?
		public Group getGroup_16() { return cGroup_16; }

		//'requirementscount'
		public Keyword getRequirementscountKeyword_16_0() { return cRequirementscountKeyword_16_0; }

		//requirementsCount=INT
		public Assignment getRequirementsCountAssignment_16_1() { return cRequirementsCountAssignment_16_1; }

		//INT
		public RuleCall getRequirementsCountINTTerminalRuleCall_16_1_0() { return cRequirementsCountINTTerminalRuleCall_16_1_0; }

		//('exceptionscount' exceptionsCount=INT)?
		public Group getGroup_17() { return cGroup_17; }

		//'exceptionscount'
		public Keyword getExceptionscountKeyword_17_0() { return cExceptionscountKeyword_17_0; }

		//exceptionsCount=INT
		public Assignment getExceptionsCountAssignment_17_1() { return cExceptionsCountAssignment_17_1; }

		//INT
		public RuleCall getExceptionsCountINTTerminalRuleCall_17_1_0() { return cExceptionsCountINTTerminalRuleCall_17_1_0; }

		//('reqtargethasemv2subclausecount' reqTargetHasEMV2SubclauseCount=INT)?
		public Group getGroup_18() { return cGroup_18; }

		//'reqtargethasemv2subclausecount'
		public Keyword getReqtargethasemv2subclausecountKeyword_18_0() { return cReqtargethasemv2subclausecountKeyword_18_0; }

		//reqTargetHasEMV2SubclauseCount=INT
		public Assignment getReqTargetHasEMV2SubclauseCountAssignment_18_1() { return cReqTargetHasEMV2SubclauseCountAssignment_18_1; }

		//INT
		public RuleCall getReqTargetHasEMV2SubclauseCountINTTerminalRuleCall_18_1_0() { return cReqTargetHasEMV2SubclauseCountINTTerminalRuleCall_18_1_0; }

		//('featuresrequiringclassifiercount' featuresRequiringClassifierCount=INT)?
		public Group getGroup_19() { return cGroup_19; }

		//'featuresrequiringclassifiercount'
		public Keyword getFeaturesrequiringclassifiercountKeyword_19_0() { return cFeaturesrequiringclassifiercountKeyword_19_0; }

		//featuresRequiringClassifierCount=INT
		public Assignment getFeaturesRequiringClassifierCountAssignment_19_1() { return cFeaturesRequiringClassifierCountAssignment_19_1; }

		//INT
		public RuleCall getFeaturesRequiringClassifierCountINTTerminalRuleCall_19_1_0() { return cFeaturesRequiringClassifierCountINTTerminalRuleCall_19_1_0; }

		//('featureswithrequiredclassifiercount' featuresWithRequiredClassifierCount=INT)?
		public Group getGroup_20() { return cGroup_20; }

		//'featureswithrequiredclassifiercount'
		public Keyword getFeatureswithrequiredclassifiercountKeyword_20_0() { return cFeatureswithrequiredclassifiercountKeyword_20_0; }

		//featuresWithRequiredClassifierCount=INT
		public Assignment getFeaturesWithRequiredClassifierCountAssignment_20_1() { return cFeaturesWithRequiredClassifierCountAssignment_20_1; }

		//INT
		public RuleCall getFeaturesWithRequiredClassifierCountINTTerminalRuleCall_20_1_0() { return cFeaturesWithRequiredClassifierCountINTTerminalRuleCall_20_1_0; }

		//('weight' weight=INT)?
		public Group getGroup_21() { return cGroup_21; }

		//'weight'
		public Keyword getWeightKeyword_21_0() { return cWeightKeyword_21_0; }

		//weight=INT
		public Assignment getWeightAssignment_21_1() { return cWeightAssignment_21_1; }

		//INT
		public RuleCall getWeightINTTerminalRuleCall_21_1_0() { return cWeightINTTerminalRuleCall_21_1_0; }

		//('time' executionTime=AInt)?
		public Group getGroup_22() { return cGroup_22; }

		//'time'
		public Keyword getTimeKeyword_22_0() { return cTimeKeyword_22_0; }

		//executionTime=AInt
		public Assignment getExecutionTimeAssignment_22_1() { return cExecutionTimeAssignment_22_1; }

		//AInt
		public RuleCall getExecutionTimeAIntParserRuleCall_22_1_0() { return cExecutionTimeAIntParserRuleCall_22_1_0; }
	}

	public class QualifiedVerificationPlanElementReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.QualifiedVerificationPlanElementReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cQualifiedClaimReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cQualifiedVAReferenceParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//QualifiedVerificationPlanElementReference:
		//	QualifiedClaimReference | QualifiedVAReference;
		@Override public ParserRule getRule() { return rule; }

		//QualifiedClaimReference | QualifiedVAReference
		public Alternatives getAlternatives() { return cAlternatives; }

		//QualifiedClaimReference
		public RuleCall getQualifiedClaimReferenceParserRuleCall_0() { return cQualifiedClaimReferenceParserRuleCall_0; }

		//QualifiedVAReference
		public RuleCall getQualifiedVAReferenceParserRuleCall_1() { return cQualifiedVAReferenceParserRuleCall_1; }
	}

	public class QualifiedClaimReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.QualifiedClaimReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVerificationPlanAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cVerificationPlanVerificationPlanCrossReference_0_0 = (CrossReference)cVerificationPlanAssignment_0.eContents().get(0);
		private final RuleCall cVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1 = (RuleCall)cVerificationPlanVerificationPlanCrossReference_0_0.eContents().get(1);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRequirementAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRequirementNestedClaimReferenceParserRuleCall_2_0 = (RuleCall)cRequirementAssignment_2.eContents().get(0);
		
		//QualifiedClaimReference:
		//	verificationPlan=[Verify::VerificationPlan|QualifiedName] '#' requirement=NestedClaimReference;
		@Override public ParserRule getRule() { return rule; }

		//verificationPlan=[Verify::VerificationPlan|QualifiedName] '#' requirement=NestedClaimReference
		public Group getGroup() { return cGroup; }

		//verificationPlan=[Verify::VerificationPlan|QualifiedName]
		public Assignment getVerificationPlanAssignment_0() { return cVerificationPlanAssignment_0; }

		//[Verify::VerificationPlan|QualifiedName]
		public CrossReference getVerificationPlanVerificationPlanCrossReference_0_0() { return cVerificationPlanVerificationPlanCrossReference_0_0; }

		//QualifiedName
		public RuleCall getVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1() { return cVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1; }

		//'#'
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }

		//requirement=NestedClaimReference
		public Assignment getRequirementAssignment_2() { return cRequirementAssignment_2; }

		//NestedClaimReference
		public RuleCall getRequirementNestedClaimReferenceParserRuleCall_2_0() { return cRequirementNestedClaimReferenceParserRuleCall_2_0; }
	}

	public class QualifiedVAReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.QualifiedVAReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVerificationPlanAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cVerificationPlanVerificationPlanCrossReference_0_0 = (CrossReference)cVerificationPlanAssignment_0.eContents().get(0);
		private final RuleCall cVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1 = (RuleCall)cVerificationPlanVerificationPlanCrossReference_0_0.eContents().get(1);
		private final Keyword cNumberSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cRequirementAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cRequirementNestedClaimReferenceParserRuleCall_2_0 = (RuleCall)cRequirementAssignment_2.eContents().get(0);
		private final Keyword cNumberSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cVerificationActivityAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final CrossReference cVerificationActivityVerificationActivityCrossReference_4_0 = (CrossReference)cVerificationActivityAssignment_4.eContents().get(0);
		private final RuleCall cVerificationActivityVerificationActivityIDTerminalRuleCall_4_0_1 = (RuleCall)cVerificationActivityVerificationActivityCrossReference_4_0.eContents().get(1);
		
		//QualifiedVAReference:
		//	verificationPlan=[Verify::VerificationPlan|QualifiedName] '#' requirement=NestedClaimReference
		//	"#" verificationActivity=[Verify::VerificationActivity];
		@Override public ParserRule getRule() { return rule; }

		//verificationPlan=[Verify::VerificationPlan|QualifiedName] '#' requirement=NestedClaimReference "#"
		//verificationActivity=[Verify::VerificationActivity]
		public Group getGroup() { return cGroup; }

		//verificationPlan=[Verify::VerificationPlan|QualifiedName]
		public Assignment getVerificationPlanAssignment_0() { return cVerificationPlanAssignment_0; }

		//[Verify::VerificationPlan|QualifiedName]
		public CrossReference getVerificationPlanVerificationPlanCrossReference_0_0() { return cVerificationPlanVerificationPlanCrossReference_0_0; }

		//QualifiedName
		public RuleCall getVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1() { return cVerificationPlanVerificationPlanQualifiedNameParserRuleCall_0_0_1; }

		//'#'
		public Keyword getNumberSignKeyword_1() { return cNumberSignKeyword_1; }

		//requirement=NestedClaimReference
		public Assignment getRequirementAssignment_2() { return cRequirementAssignment_2; }

		//NestedClaimReference
		public RuleCall getRequirementNestedClaimReferenceParserRuleCall_2_0() { return cRequirementNestedClaimReferenceParserRuleCall_2_0; }

		//"#"
		public Keyword getNumberSignKeyword_3() { return cNumberSignKeyword_3; }

		//verificationActivity=[Verify::VerificationActivity]
		public Assignment getVerificationActivityAssignment_4() { return cVerificationActivityAssignment_4; }

		//[Verify::VerificationActivity]
		public CrossReference getVerificationActivityVerificationActivityCrossReference_4_0() { return cVerificationActivityVerificationActivityCrossReference_4_0; }

		//ID
		public RuleCall getVerificationActivityVerificationActivityIDTerminalRuleCall_4_0_1() { return cVerificationActivityVerificationActivityIDTerminalRuleCall_4_0_1; }
	}

	public class NestedClaimReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.NestedClaimReference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cRequirementAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final CrossReference cRequirementRequirementCrossReference_0_0 = (CrossReference)cRequirementAssignment_0.eContents().get(0);
		private final RuleCall cRequirementRequirementIDTerminalRuleCall_0_0_1 = (RuleCall)cRequirementRequirementCrossReference_0_0.eContents().get(1);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cSubAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cSubNestedClaimReferenceParserRuleCall_1_1_0 = (RuleCall)cSubAssignment_1_1.eContents().get(0);
		
		//NestedClaimReference:
		//	requirement=[ReqSpec::Requirement] ('.' sub=NestedClaimReference)?;
		@Override public ParserRule getRule() { return rule; }

		//requirement=[ReqSpec::Requirement] ('.' sub=NestedClaimReference)?
		public Group getGroup() { return cGroup; }

		//requirement=[ReqSpec::Requirement]
		public Assignment getRequirementAssignment_0() { return cRequirementAssignment_0; }

		//[ReqSpec::Requirement]
		public CrossReference getRequirementRequirementCrossReference_0_0() { return cRequirementRequirementCrossReference_0_0; }

		//ID
		public RuleCall getRequirementRequirementIDTerminalRuleCall_0_0_1() { return cRequirementRequirementIDTerminalRuleCall_0_0_1; }

		//('.' sub=NestedClaimReference)?
		public Group getGroup_1() { return cGroup_1; }

		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }

		//sub=NestedClaimReference
		public Assignment getSubAssignment_1_1() { return cSubAssignment_1_1; }

		//NestedClaimReference
		public RuleCall getSubNestedClaimReferenceParserRuleCall_1_1_0() { return cSubNestedClaimReferenceParserRuleCall_1_1_0; }
	}

	public class ResultIssueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ResultIssue");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cTypeAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cTypeResultIssueTypeEnumRuleCall_0_0 = (RuleCall)cTypeAssignment_0.eContents().get(0);
		private final Assignment cMessageAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cMessageSTRINGTerminalRuleCall_1_0 = (RuleCall)cMessageAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cSourceKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cSourceReferenceAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cSourceReferenceEObjectCrossReference_2_1_0 = (CrossReference)cSourceReferenceAssignment_2_1.eContents().get(0);
		private final RuleCall cSourceReferenceEObjectNoQuoteStringParserRuleCall_2_1_0_1 = (RuleCall)cSourceReferenceEObjectCrossReference_2_1_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cExceptionKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cExceptionTypeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cExceptionTypeSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cExceptionTypeAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftSquareBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cIssuesAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cIssuesResultIssueParserRuleCall_4_1_0 = (RuleCall)cIssuesAssignment_4_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4_2 = (Keyword)cGroup_4.eContents().get(2);
		
		//ResultIssue results::Diagnostic:
		//	type=ResultIssueType
		//	message=STRING ('source' sourceReference=[ecore::EObject|NoQuoteString])? ('exception' exceptionType=STRING)? ('['
		//	issues+=ResultIssue* ']')?;
		@Override public ParserRule getRule() { return rule; }

		//type=ResultIssueType message=STRING ('source' sourceReference=[ecore::EObject|NoQuoteString])? ('exception'
		//exceptionType=STRING)? ('[' issues+=ResultIssue* ']')?
		public Group getGroup() { return cGroup; }

		//type=ResultIssueType
		public Assignment getTypeAssignment_0() { return cTypeAssignment_0; }

		//ResultIssueType
		public RuleCall getTypeResultIssueTypeEnumRuleCall_0_0() { return cTypeResultIssueTypeEnumRuleCall_0_0; }

		//message=STRING
		public Assignment getMessageAssignment_1() { return cMessageAssignment_1; }

		//STRING
		public RuleCall getMessageSTRINGTerminalRuleCall_1_0() { return cMessageSTRINGTerminalRuleCall_1_0; }

		//('source' sourceReference=[ecore::EObject|NoQuoteString])?
		public Group getGroup_2() { return cGroup_2; }

		//'source'
		public Keyword getSourceKeyword_2_0() { return cSourceKeyword_2_0; }

		//sourceReference=[ecore::EObject|NoQuoteString]
		public Assignment getSourceReferenceAssignment_2_1() { return cSourceReferenceAssignment_2_1; }

		//[ecore::EObject|NoQuoteString]
		public CrossReference getSourceReferenceEObjectCrossReference_2_1_0() { return cSourceReferenceEObjectCrossReference_2_1_0; }

		//NoQuoteString
		public RuleCall getSourceReferenceEObjectNoQuoteStringParserRuleCall_2_1_0_1() { return cSourceReferenceEObjectNoQuoteStringParserRuleCall_2_1_0_1; }

		//('exception' exceptionType=STRING)?
		public Group getGroup_3() { return cGroup_3; }

		//'exception'
		public Keyword getExceptionKeyword_3_0() { return cExceptionKeyword_3_0; }

		//exceptionType=STRING
		public Assignment getExceptionTypeAssignment_3_1() { return cExceptionTypeAssignment_3_1; }

		//STRING
		public RuleCall getExceptionTypeSTRINGTerminalRuleCall_3_1_0() { return cExceptionTypeSTRINGTerminalRuleCall_3_1_0; }

		//('[' issues+=ResultIssue* ']')?
		public Group getGroup_4() { return cGroup_4; }

		//'['
		public Keyword getLeftSquareBracketKeyword_4_0() { return cLeftSquareBracketKeyword_4_0; }

		//issues+=ResultIssue*
		public Assignment getIssuesAssignment_4_1() { return cIssuesAssignment_4_1; }

		//ResultIssue
		public RuleCall getIssuesResultIssueParserRuleCall_4_1_0() { return cIssuesResultIssueParserRuleCall_4_1_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_4_2() { return cRightSquareBracketKeyword_4_2; }
	}
	
	
	public class ElseTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ElseType");
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
		//	OK='ok' | FAIL='fail' | TIMEOUT='timeout' | ERROR='error';
		public EnumRule getRule() { return rule; }

		//OK='ok' | FAIL='fail' | TIMEOUT='timeout' | ERROR='error'
		public Alternatives getAlternatives() { return cAlternatives; }

		//OK='ok'
		public EnumLiteralDeclaration getOKEnumLiteralDeclaration_0() { return cOKEnumLiteralDeclaration_0; }

		//'ok'
		public Keyword getOKOkKeyword_0_0() { return cOKOkKeyword_0_0; }

		//FAIL='fail'
		public EnumLiteralDeclaration getFAILEnumLiteralDeclaration_1() { return cFAILEnumLiteralDeclaration_1; }

		//'fail'
		public Keyword getFAILFailKeyword_1_0() { return cFAILFailKeyword_1_0; }

		//TIMEOUT='timeout'
		public EnumLiteralDeclaration getTIMEOUTEnumLiteralDeclaration_2() { return cTIMEOUTEnumLiteralDeclaration_2; }

		//'timeout'
		public Keyword getTIMEOUTTimeoutKeyword_2_0() { return cTIMEOUTTimeoutKeyword_2_0; }

		//ERROR='error'
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_3() { return cERROREnumLiteralDeclaration_3; }

		//'error'
		public Keyword getERRORErrorKeyword_3_0() { return cERRORErrorKeyword_3_0; }
	}

	public class VerificationResultStateElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.VerificationResultState");
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
		//	TBD='tbd' | SUCCESS='success' | FAIL='fail' | ERROR='error' | TIMEOUT='timeout';
		public EnumRule getRule() { return rule; }

		//TBD='tbd' | SUCCESS='success' | FAIL='fail' | ERROR='error' | TIMEOUT='timeout'
		public Alternatives getAlternatives() { return cAlternatives; }

		//TBD='tbd'
		public EnumLiteralDeclaration getTBDEnumLiteralDeclaration_0() { return cTBDEnumLiteralDeclaration_0; }

		//'tbd'
		public Keyword getTBDTbdKeyword_0_0() { return cTBDTbdKeyword_0_0; }

		//SUCCESS='success'
		public EnumLiteralDeclaration getSUCCESSEnumLiteralDeclaration_1() { return cSUCCESSEnumLiteralDeclaration_1; }

		//'success'
		public Keyword getSUCCESSSuccessKeyword_1_0() { return cSUCCESSSuccessKeyword_1_0; }

		//FAIL='fail'
		public EnumLiteralDeclaration getFAILEnumLiteralDeclaration_2() { return cFAILEnumLiteralDeclaration_2; }

		//'fail'
		public Keyword getFAILFailKeyword_2_0() { return cFAILFailKeyword_2_0; }

		//ERROR='error'
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_3() { return cERROREnumLiteralDeclaration_3; }

		//'error'
		public Keyword getERRORErrorKeyword_3_0() { return cERRORErrorKeyword_3_0; }

		//TIMEOUT='timeout'
		public EnumLiteralDeclaration getTIMEOUTEnumLiteralDeclaration_4() { return cTIMEOUTEnumLiteralDeclaration_4; }

		//'timeout'
		public Keyword getTIMEOUTTimeoutKeyword_4_0() { return cTIMEOUTTimeoutKeyword_4_0; }
	}

	public class VerificationExecutionStateElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.VerificationExecutionState");
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
		//	TODO='todo' // verification to be performed
		//	| RUNNING='running' // verification in progress (background processing)
		//	| REDO='redo' // invalidated while in progress. redo verification.
		//	| COMPLETED='completed' // completed. verification result is valid
		//;
		public EnumRule getRule() { return rule; }

		//TODO='todo' // verification to be performed
		//| RUNNING='running' // verification in progress (background processing)
		//| REDO='redo' // invalidated while in progress. redo verification.
		//| COMPLETED='completed'
		public Alternatives getAlternatives() { return cAlternatives; }

		//TODO='todo'
		public EnumLiteralDeclaration getTODOEnumLiteralDeclaration_0() { return cTODOEnumLiteralDeclaration_0; }

		//'todo'
		public Keyword getTODOTodoKeyword_0_0() { return cTODOTodoKeyword_0_0; }

		//RUNNING='running'
		public EnumLiteralDeclaration getRUNNINGEnumLiteralDeclaration_1() { return cRUNNINGEnumLiteralDeclaration_1; }

		//'running'
		public Keyword getRUNNINGRunningKeyword_1_0() { return cRUNNINGRunningKeyword_1_0; }

		//REDO='redo'
		public EnumLiteralDeclaration getREDOEnumLiteralDeclaration_2() { return cREDOEnumLiteralDeclaration_2; }

		//'redo'
		public Keyword getREDORedoKeyword_2_0() { return cREDORedoKeyword_2_0; }

		//COMPLETED='completed'
		public EnumLiteralDeclaration getCOMPLETEDEnumLiteralDeclaration_3() { return cCOMPLETEDEnumLiteralDeclaration_3; }

		//'completed'
		public Keyword getCOMPLETEDCompletedKeyword_3_0() { return cCOMPLETEDCompletedKeyword_3_0; }
	}

	public class ResultIssueTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.assure.Assure.ResultIssueType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cNONEEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cNONENoneKeyword_0_0 = (Keyword)cNONEEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cERROREnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cERRORErrorKeyword_1_0 = (Keyword)cERROREnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cWARNINGEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cWARNINGWarningKeyword_2_0 = (Keyword)cWARNINGEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cINFOEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cINFOInfoKeyword_3_0 = (Keyword)cINFOEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cSUCCESSEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cSUCCESSSuccessKeyword_4_0 = (Keyword)cSUCCESSEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cFAILUREEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cFAILUREFailKeyword_5_0 = (Keyword)cFAILUREEnumLiteralDeclaration_5.eContents().get(0);
		
		//enum ResultIssueType returns results::DiagnosticType:
		//	NONE='none' | ERROR='error' | WARNING='warning' | INFO='info' | SUCCESS='success' | FAILURE='fail';
		public EnumRule getRule() { return rule; }

		//NONE='none' | ERROR='error' | WARNING='warning' | INFO='info' | SUCCESS='success' | FAILURE='fail'
		public Alternatives getAlternatives() { return cAlternatives; }

		//NONE='none'
		public EnumLiteralDeclaration getNONEEnumLiteralDeclaration_0() { return cNONEEnumLiteralDeclaration_0; }

		//'none'
		public Keyword getNONENoneKeyword_0_0() { return cNONENoneKeyword_0_0; }

		//ERROR='error'
		public EnumLiteralDeclaration getERROREnumLiteralDeclaration_1() { return cERROREnumLiteralDeclaration_1; }

		//'error'
		public Keyword getERRORErrorKeyword_1_0() { return cERRORErrorKeyword_1_0; }

		//WARNING='warning'
		public EnumLiteralDeclaration getWARNINGEnumLiteralDeclaration_2() { return cWARNINGEnumLiteralDeclaration_2; }

		//'warning'
		public Keyword getWARNINGWarningKeyword_2_0() { return cWARNINGWarningKeyword_2_0; }

		//INFO='info'
		public EnumLiteralDeclaration getINFOEnumLiteralDeclaration_3() { return cINFOEnumLiteralDeclaration_3; }

		//'info'
		public Keyword getINFOInfoKeyword_3_0() { return cINFOInfoKeyword_3_0; }

		//SUCCESS='success'
		public EnumLiteralDeclaration getSUCCESSEnumLiteralDeclaration_4() { return cSUCCESSEnumLiteralDeclaration_4; }

		//'success'
		public Keyword getSUCCESSSuccessKeyword_4_0() { return cSUCCESSSuccessKeyword_4_0; }

		//FAILURE='fail'
		public EnumLiteralDeclaration getFAILUREEnumLiteralDeclaration_5() { return cFAILUREEnumLiteralDeclaration_5; }

		//'fail'
		public Keyword getFAILUREFailKeyword_5_0() { return cFAILUREFailKeyword_5_0; }
	}
	
	private final AssuranceCaseResultElements pAssuranceCaseResult;
	private final ModelResultElements pModelResult;
	private final SubsystemResultElements pSubsystemResult;
	private final ClaimResultElements pClaimResult;
	private final PreconditionResultElements pPreconditionResult;
	private final ValidationResultElements pValidationResult;
	private final VerificationActivityResultElements pVerificationActivityResult;
	private final PredicateResultElements pPredicateResult;
	private final AssureResultElements pAssureResult;
	private final ElseTypeElements eElseType;
	private final VerificationExprElements pVerificationExpr;
	private final ElseResultElements pElseResult;
	private final ThenResultElements pThenResult;
	private final MetricsElements pMetrics;
	private final VerificationResultStateElements eVerificationResultState;
	private final VerificationExecutionStateElements eVerificationExecutionState;
	private final QualifiedVerificationPlanElementReferenceElements pQualifiedVerificationPlanElementReference;
	private final QualifiedClaimReferenceElements pQualifiedClaimReference;
	private final QualifiedVAReferenceElements pQualifiedVAReference;
	private final NestedClaimReferenceElements pNestedClaimReference;
	private final ResultIssueElements pResultIssue;
	private final ResultIssueTypeElements eResultIssueType;
	
	private final Grammar grammar;

	private final CommonGrammarAccess gaCommon;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public AssureGrammarAccess(GrammarProvider grammarProvider,
		CommonGrammarAccess gaCommon,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCommon = gaCommon;
		this.gaTerminals = gaTerminals;
		this.pAssuranceCaseResult = new AssuranceCaseResultElements();
		this.pModelResult = new ModelResultElements();
		this.pSubsystemResult = new SubsystemResultElements();
		this.pClaimResult = new ClaimResultElements();
		this.pPreconditionResult = new PreconditionResultElements();
		this.pValidationResult = new ValidationResultElements();
		this.pVerificationActivityResult = new VerificationActivityResultElements();
		this.pPredicateResult = new PredicateResultElements();
		this.pAssureResult = new AssureResultElements();
		this.eElseType = new ElseTypeElements();
		this.pVerificationExpr = new VerificationExprElements();
		this.pElseResult = new ElseResultElements();
		this.pThenResult = new ThenResultElements();
		this.pMetrics = new MetricsElements();
		this.eVerificationResultState = new VerificationResultStateElements();
		this.eVerificationExecutionState = new VerificationExecutionStateElements();
		this.pQualifiedVerificationPlanElementReference = new QualifiedVerificationPlanElementReferenceElements();
		this.pQualifiedClaimReference = new QualifiedClaimReferenceElements();
		this.pQualifiedVAReference = new QualifiedVAReferenceElements();
		this.pNestedClaimReference = new NestedClaimReferenceElements();
		this.pResultIssue = new ResultIssueElements();
		this.eResultIssueType = new ResultIssueTypeElements();
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

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//// result for a system in the architecture hierarchy
	//AssuranceCaseResult:
	//	'case' name=QualifiedName
	//	'['
	//	metrics=Metrics ('message' message=STRING)?
	//	modelResult+=ModelResult*
	//	']';
	public AssuranceCaseResultElements getAssuranceCaseResultAccess() {
		return pAssuranceCaseResult;
	}
	
	public ParserRule getAssuranceCaseResultRule() {
		return getAssuranceCaseResultAccess().getRule();
	}

	//ModelResult:
	//	'model' plan=[Alisa::AssurancePlan|QualifiedName]
	//	'for' target=[aadl2::ComponentImplementation|AadlClassifierReference]
	//	'['
	//	metrics=Metrics ('message' message=STRING)?
	//	claimResult+=ClaimResult*
	//	subsystemResult+=SubsystemResult*
	//	']';
	public ModelResultElements getModelResultAccess() {
		return pModelResult;
	}
	
	public ParserRule getModelResultRule() {
		return getModelResultAccess().getRule();
	}

	//SubsystemResult:
	//	'subsystem' //name=QualifiedName 'for' 
	//	targetSystem=[aadl2::Subcomponent]
	//	'['
	//	metrics=Metrics ('message' message=STRING)?
	//	claimResult+=ClaimResult*
	//	subsystemResult+=SubsystemResult*
	//	']';
	public SubsystemResultElements getSubsystemResultAccess() {
		return pSubsystemResult;
	}
	
	public ParserRule getSubsystemResultRule() {
		return getSubsystemResultAccess().getRule();
	}

	//// Result of meeting a requirement
	//ClaimResult:
	//	'claim' targetReference=QualifiedClaimReference //target=[ReqSpec::Requirement|QualifiedName]
	//	'['
	//	metrics=Metrics ('for' modelElement=[aadl2::NamedElement])? ('message' message=STRING)?
	//	subClaimResult+=ClaimResult*
	//	verificationActivityResult+=VerificationExpr*
	//	predicateResult=PredicateResult?
	//	']';
	public ClaimResultElements getClaimResultAccess() {
		return pClaimResult;
	}
	
	public ParserRule getClaimResultRule() {
		return getClaimResultAccess().getRule();
	}

	//PreconditionResult VerificationResult:
	//	'precondition' {PreconditionResult} target=[Verify::VerificationMethod|QualifiedName]
	//	'['
	//	'executionstate' executionState=VerificationExecutionState
	//	'resultstate' resultState=VerificationResultState ('issues' '['
	//	issues+=ResultIssue*
	//	']')? ('results' results=[results::AnalysisResult|QualifiedName])? // pointer to separate report
	//	metrics=Metrics ('message' message=STRING)?
	//	']';
	public PreconditionResultElements getPreconditionResultAccess() {
		return pPreconditionResult;
	}
	
	public ParserRule getPreconditionResultRule() {
		return getPreconditionResultAccess().getRule();
	}

	//ValidationResult VerificationResult:
	//	'validation' {ValidationResult} target=[Verify::VerificationMethod|QualifiedName]
	//	'['
	//	'executionstate' executionState=VerificationExecutionState
	//	'resultstate' resultState=VerificationResultState ('issues' '['
	//	issues+=ResultIssue*
	//	']')? ('results' results=[results::AnalysisResult|QualifiedName])? // pointer to separate report
	//	metrics=Metrics ('message' message=STRING)?
	//	']';
	public ValidationResultElements getValidationResultAccess() {
		return pValidationResult;
	}
	
	public ParserRule getValidationResultRule() {
		return getValidationResultAccess().getRule();
	}

	//// result of executing a verification activity
	//VerificationActivityResult VerificationResult:
	//	'verification' {VerificationActivityResult} targetReference=QualifiedVAReference //target=[Verify::VerificationActivity|QualifiedName]
	//	'['
	//	'executionstate' executionState=VerificationExecutionState
	//	'resultstate' resultState=VerificationResultState ('issues' '['
	//	issues+=ResultIssue*
	//	']')? ('results' results=[results::AnalysisResult|QualifiedName])?
	//	metrics=Metrics ('message' message=STRING)?
	//	preconditionResult=PreconditionResult?
	//	validationResult=ValidationResult?
	//	']';
	public VerificationActivityResultElements getVerificationActivityResultAccess() {
		return pVerificationActivityResult;
	}
	
	public ParserRule getVerificationActivityResultRule() {
		return getVerificationActivityResultAccess().getRule();
	}

	//PredicateResult VerificationResult:
	//	{PredicateResult}
	//	'predicate' targetReference=QualifiedClaimReference
	//	'['
	//	'executionstate' executionState=VerificationExecutionState
	//	'resultstate' resultState=VerificationResultState ('issues' '['
	//	issues+=ResultIssue*
	//	']')? ('results' results=[results::AnalysisResult|QualifiedName])?
	//	metrics=Metrics ('message' message=STRING)?
	//	']';
	public PredicateResultElements getPredicateResultAccess() {
		return pPredicateResult;
	}
	
	public ParserRule getPredicateResultRule() {
		return getPredicateResultAccess().getRule();
	}

	//AssureResult:
	//	VerificationExpr | ModelResult | SubsystemResult | AssuranceCaseResult | ClaimResult | PreconditionResult |
	//	ValidationResult | PredicateResult;
	public AssureResultElements getAssureResultAccess() {
		return pAssureResult;
	}
	
	public ParserRule getAssureResultRule() {
		return getAssureResultAccess().getRule();
	}

	//enum ElseType:
	//	OK='ok' | FAIL='fail' | TIMEOUT='timeout' | ERROR='error';
	public ElseTypeElements getElseTypeAccess() {
		return eElseType;
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
	//	'else' first+=VerificationExpr+ ('error' error+=VerificationExpr+)? ('fail' fail+=VerificationExpr+)? ('timeout'
	//	timeout+=VerificationExpr+)?
	//	'['
	//	didFail=ElseType?
	//	metrics=Metrics
	//	']';
	public ElseResultElements getElseResultAccess() {
		return pElseResult;
	}
	
	public ParserRule getElseResultRule() {
		return getElseResultAccess().getRule();
	}

	//ThenResult:
	//	'then' first+=VerificationExpr+ 'do' second+=VerificationExpr+
	//	'['
	//	didThenFail?='thenfailed'?
	//	metrics=Metrics
	//	']';
	public ThenResultElements getThenResultAccess() {
		return pThenResult;
	}
	
	public ParserRule getThenResultRule() {
		return getThenResultAccess().getRule();
	}

	//Metrics:
	//	{Metrics} ('tbdcount' tbdCount=INT)? ('successcount' successCount=INT)? ('failcount' failCount=INT)? ('timeoutcount'
	//	timeoutCount=INT)? ('errorcount' errorCount=INT)? ('didelsecount' didelseCount=INT)? ('thenskipcount'
	//	thenskipCount=INT)? ('prefailcount' preconditionfailCount=INT)? ('validfailcount' validationfailCount=INT)?
	//	('featurescount' featuresCount=INT)? ('featuresrequirementscount' featuresRequirementsCount=INT)?
	//	('qualitycategoryrequirementscount' qualityCategoryRequirementsCount=INT)? ('totalqualitycategorycount'
	//	totalQualityCategoryCount=INT)? ('requirementswithoutplanclaimcount' requirementsWithoutPlanClaimCount=INT)?
	//	('noverificationplanscount' noVerificationPlansCount=INT)? ('requirementscount' requirementsCount=INT)?
	//	('exceptionscount' exceptionsCount=INT)? ('reqtargethasemv2subclausecount' reqTargetHasEMV2SubclauseCount=INT)?
	//	('featuresrequiringclassifiercount' featuresRequiringClassifierCount=INT)? ('featureswithrequiredclassifiercount'
	//	featuresWithRequiredClassifierCount=INT)? ('weight' weight=INT)? ('time' executionTime=AInt)?;
	public MetricsElements getMetricsAccess() {
		return pMetrics;
	}
	
	public ParserRule getMetricsRule() {
		return getMetricsAccess().getRule();
	}

	//enum VerificationResultState:
	//	TBD='tbd' | SUCCESS='success' | FAIL='fail' | ERROR='error' | TIMEOUT='timeout';
	public VerificationResultStateElements getVerificationResultStateAccess() {
		return eVerificationResultState;
	}
	
	public EnumRule getVerificationResultStateRule() {
		return getVerificationResultStateAccess().getRule();
	}

	//enum VerificationExecutionState:
	//	TODO='todo' // verification to be performed
	//	| RUNNING='running' // verification in progress (background processing)
	//	| REDO='redo' // invalidated while in progress. redo verification.
	//	| COMPLETED='completed' // completed. verification result is valid
	//;
	public VerificationExecutionStateElements getVerificationExecutionStateAccess() {
		return eVerificationExecutionState;
	}
	
	public EnumRule getVerificationExecutionStateRule() {
		return getVerificationExecutionStateAccess().getRule();
	}

	//QualifiedVerificationPlanElementReference:
	//	QualifiedClaimReference | QualifiedVAReference;
	public QualifiedVerificationPlanElementReferenceElements getQualifiedVerificationPlanElementReferenceAccess() {
		return pQualifiedVerificationPlanElementReference;
	}
	
	public ParserRule getQualifiedVerificationPlanElementReferenceRule() {
		return getQualifiedVerificationPlanElementReferenceAccess().getRule();
	}

	//QualifiedClaimReference:
	//	verificationPlan=[Verify::VerificationPlan|QualifiedName] '#' requirement=NestedClaimReference;
	public QualifiedClaimReferenceElements getQualifiedClaimReferenceAccess() {
		return pQualifiedClaimReference;
	}
	
	public ParserRule getQualifiedClaimReferenceRule() {
		return getQualifiedClaimReferenceAccess().getRule();
	}

	//QualifiedVAReference:
	//	verificationPlan=[Verify::VerificationPlan|QualifiedName] '#' requirement=NestedClaimReference
	//	"#" verificationActivity=[Verify::VerificationActivity];
	public QualifiedVAReferenceElements getQualifiedVAReferenceAccess() {
		return pQualifiedVAReference;
	}
	
	public ParserRule getQualifiedVAReferenceRule() {
		return getQualifiedVAReferenceAccess().getRule();
	}

	//NestedClaimReference:
	//	requirement=[ReqSpec::Requirement] ('.' sub=NestedClaimReference)?;
	public NestedClaimReferenceElements getNestedClaimReferenceAccess() {
		return pNestedClaimReference;
	}
	
	public ParserRule getNestedClaimReferenceRule() {
		return getNestedClaimReferenceAccess().getRule();
	}

	//ResultIssue results::Diagnostic:
	//	type=ResultIssueType
	//	message=STRING ('source' sourceReference=[ecore::EObject|NoQuoteString])? ('exception' exceptionType=STRING)? ('['
	//	issues+=ResultIssue* ']')?;
	public ResultIssueElements getResultIssueAccess() {
		return pResultIssue;
	}
	
	public ParserRule getResultIssueRule() {
		return getResultIssueAccess().getRule();
	}

	//enum ResultIssueType returns results::DiagnosticType:
	//	NONE='none' | ERROR='error' | WARNING='warning' | INFO='info' | SUCCESS='success' | FAILURE='fail';
	public ResultIssueTypeElements getResultIssueTypeAccess() {
		return eResultIssueType;
	}
	
	public EnumRule getResultIssueTypeRule() {
		return getResultIssueTypeAccess().getRule();
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
	//	'rationale' text=STRING;
	public CommonGrammarAccess.RationaleElements getRationaleAccess() {
		return gaCommon.getRationaleAccess();
	}
	
	public ParserRule getRationaleRule() {
		return getRationaleAccess().getRule();
	}

	//Uncertainty:
	//	'uncertainty'
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
	//	'"' ('\\' . | !('\\' | '"'))* '"' | "'" ('\\' . | !('\\' | "'"))* "'";
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
