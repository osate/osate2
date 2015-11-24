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
package org.osate.alisa.workbench.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.osate.alisa.common.services.CommonGrammarAccess;

@Singleton
public class AlisaGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class AlisaWorkAreaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AlisaWorkArea");
		private final Assignment cCasesAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cCasesAlternatives_0 = (Alternatives)cCasesAssignment.eContents().get(0);
		private final RuleCall cCasesAssurancePlanParserRuleCall_0_0 = (RuleCall)cCasesAlternatives_0.eContents().get(0);
		private final RuleCall cCasesAssuranceTaskParserRuleCall_0_1 = (RuleCall)cCasesAlternatives_0.eContents().get(1);
		
		//AlisaWorkArea:
		//	cases+=(AssurancePlan | AssuranceTask)*;
		@Override public ParserRule getRule() { return rule; }

		//cases+=(AssurancePlan | AssuranceTask)*
		public Assignment getCasesAssignment() { return cCasesAssignment; }

		//AssurancePlan | AssuranceTask
		public Alternatives getCasesAlternatives_0() { return cCasesAlternatives_0; }

		//AssurancePlan
		public RuleCall getCasesAssurancePlanParserRuleCall_0_0() { return cCasesAssurancePlanParserRuleCall_0_0; }

		//AssuranceTask
		public RuleCall getCasesAssuranceTaskParserRuleCall_0_1() { return cCasesAssuranceTaskParserRuleCall_0_1; }
	}

	public class AssurancePlanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AssurancePlan");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAssuranceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cPlanKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cNameAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cNameQualifiedNameParserRuleCall_2_0 = (RuleCall)cNameAssignment_2.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cColonKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cTitleAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_3_1_0 = (RuleCall)cTitleAssignment_3_1.eContents().get(0);
		private final Keyword cForKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Assignment cTargetAssignment_5 = (Assignment)cGroup.eContents().get(5);
		private final CrossReference cTargetComponentImplementationCrossReference_5_0 = (CrossReference)cTargetAssignment_5.eContents().get(0);
		private final RuleCall cTargetComponentImplementationAadlClassifierReferenceParserRuleCall_5_0_1 = (RuleCall)cTargetComponentImplementationCrossReference_5_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final UnorderedGroup cUnorderedGroup_7 = (UnorderedGroup)cGroup.eContents().get(7);
		private final Assignment cDescriptionAssignment_7_0 = (Assignment)cUnorderedGroup_7.eContents().get(0);
		private final RuleCall cDescriptionDescriptionParserRuleCall_7_0_0 = (RuleCall)cDescriptionAssignment_7_0.eContents().get(0);
		private final Group cGroup_7_1 = (Group)cUnorderedGroup_7.eContents().get(1);
		private final Keyword cAssureKeyword_7_1_0 = (Keyword)cGroup_7_1.eContents().get(0);
		private final Assignment cAssureAssignment_7_1_1 = (Assignment)cGroup_7_1.eContents().get(1);
		private final CrossReference cAssureVerificationPlanCrossReference_7_1_1_0 = (CrossReference)cAssureAssignment_7_1_1.eContents().get(0);
		private final RuleCall cAssureVerificationPlanQualifiedNameParserRuleCall_7_1_1_0_1 = (RuleCall)cAssureVerificationPlanCrossReference_7_1_1_0.eContents().get(1);
		private final Alternatives cAlternatives_7_2 = (Alternatives)cUnorderedGroup_7.eContents().get(2);
		private final Group cGroup_7_2_0 = (Group)cAlternatives_7_2.eContents().get(0);
		private final Keyword cAssureKeyword_7_2_0_0 = (Keyword)cGroup_7_2_0.eContents().get(0);
		private final Keyword cSubsystemKeyword_7_2_0_1 = (Keyword)cGroup_7_2_0.eContents().get(1);
		private final Assignment cAssureSubsystemsAssignment_7_2_0_2 = (Assignment)cGroup_7_2_0.eContents().get(2);
		private final CrossReference cAssureSubsystemsSubcomponentCrossReference_7_2_0_2_0 = (CrossReference)cAssureSubsystemsAssignment_7_2_0_2.eContents().get(0);
		private final RuleCall cAssureSubsystemsSubcomponentIDTerminalRuleCall_7_2_0_2_0_1 = (RuleCall)cAssureSubsystemsSubcomponentCrossReference_7_2_0_2_0.eContents().get(1);
		private final Assignment cAssureAllAssignment_7_2_1 = (Assignment)cAlternatives_7_2.eContents().get(1);
		private final Keyword cAssureAllAllKeyword_7_2_1_0 = (Keyword)cAssureAllAssignment_7_2_1.eContents().get(0);
		private final Group cGroup_7_3 = (Group)cUnorderedGroup_7.eContents().get(3);
		private final Keyword cAssumeKeyword_7_3_0 = (Keyword)cGroup_7_3.eContents().get(0);
		private final Keyword cSubsystemKeyword_7_3_1 = (Keyword)cGroup_7_3.eContents().get(1);
		private final Alternatives cAlternatives_7_3_2 = (Alternatives)cGroup_7_3.eContents().get(2);
		private final Assignment cAssumeSubsystemsAssignment_7_3_2_0 = (Assignment)cAlternatives_7_3_2.eContents().get(0);
		private final CrossReference cAssumeSubsystemsSubcomponentCrossReference_7_3_2_0_0 = (CrossReference)cAssumeSubsystemsAssignment_7_3_2_0.eContents().get(0);
		private final RuleCall cAssumeSubsystemsSubcomponentIDTerminalRuleCall_7_3_2_0_0_1 = (RuleCall)cAssumeSubsystemsSubcomponentCrossReference_7_3_2_0_0.eContents().get(1);
		private final Assignment cAssumeAllAssignment_7_3_2_1 = (Assignment)cAlternatives_7_3_2.eContents().get(1);
		private final Keyword cAssumeAllAllKeyword_7_3_2_1_0 = (Keyword)cAssumeAllAssignment_7_3_2_1.eContents().get(0);
		private final Group cGroup_7_4 = (Group)cUnorderedGroup_7.eContents().get(4);
		private final Keyword cIssuesKeyword_7_4_0 = (Keyword)cGroup_7_4.eContents().get(0);
		private final Assignment cIssuesAssignment_7_4_1 = (Assignment)cGroup_7_4.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_7_4_1_0 = (RuleCall)cIssuesAssignment_7_4_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//AssurancePlan:
		//	"assurance" "plan" name=QualifiedName (":" title=STRING)? "for"
		//	target=[aadl2::ComponentImplementation|AadlClassifierReference] "[" (description=Description? & ("assure"
		//	assure+=[Verify::VerificationPlan|QualifiedName]+)? & ("assure" "subsystem" assureSubsystems+=[aadl2::Subcomponent]+
		//	| assureAll?="all")? & ("assume" "subsystem" (assumeSubsystems+=[aadl2::Subcomponent]+ | assumeAll?="all"))? &
		//	("issues" issues+=STRING+)?) "]";
		@Override public ParserRule getRule() { return rule; }

		//"assurance" "plan" name=QualifiedName (":" title=STRING)? "for"
		//target=[aadl2::ComponentImplementation|AadlClassifierReference] "[" (description=Description? & ("assure"
		//assure+=[Verify::VerificationPlan|QualifiedName]+)? & ("assure" "subsystem" assureSubsystems+=[aadl2::Subcomponent]+ |
		//assureAll?="all")? & ("assume" "subsystem" (assumeSubsystems+=[aadl2::Subcomponent]+ | assumeAll?="all"))? & ("issues"
		//issues+=STRING+)?) "]"
		public Group getGroup() { return cGroup; }

		//"assurance"
		public Keyword getAssuranceKeyword_0() { return cAssuranceKeyword_0; }

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

		//target=[aadl2::ComponentImplementation|AadlClassifierReference]
		public Assignment getTargetAssignment_5() { return cTargetAssignment_5; }

		//[aadl2::ComponentImplementation|AadlClassifierReference]
		public CrossReference getTargetComponentImplementationCrossReference_5_0() { return cTargetComponentImplementationCrossReference_5_0; }

		//AadlClassifierReference
		public RuleCall getTargetComponentImplementationAadlClassifierReferenceParserRuleCall_5_0_1() { return cTargetComponentImplementationAadlClassifierReferenceParserRuleCall_5_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_6() { return cLeftSquareBracketKeyword_6; }

		//description=Description? & ("assure" assure+=[Verify::VerificationPlan|QualifiedName]+)? & ("assure" "subsystem"
		//assureSubsystems+=[aadl2::Subcomponent]+ | assureAll?="all")? & ("assume" "subsystem"
		//(assumeSubsystems+=[aadl2::Subcomponent]+ | assumeAll?="all"))? & ("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_7() { return cUnorderedGroup_7; }

		//description=Description?
		public Assignment getDescriptionAssignment_7_0() { return cDescriptionAssignment_7_0; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_7_0_0() { return cDescriptionDescriptionParserRuleCall_7_0_0; }

		//("assure" assure+=[Verify::VerificationPlan|QualifiedName]+)?
		public Group getGroup_7_1() { return cGroup_7_1; }

		//"assure"
		public Keyword getAssureKeyword_7_1_0() { return cAssureKeyword_7_1_0; }

		//assure+=[Verify::VerificationPlan|QualifiedName]+
		public Assignment getAssureAssignment_7_1_1() { return cAssureAssignment_7_1_1; }

		//[Verify::VerificationPlan|QualifiedName]
		public CrossReference getAssureVerificationPlanCrossReference_7_1_1_0() { return cAssureVerificationPlanCrossReference_7_1_1_0; }

		//QualifiedName
		public RuleCall getAssureVerificationPlanQualifiedNameParserRuleCall_7_1_1_0_1() { return cAssureVerificationPlanQualifiedNameParserRuleCall_7_1_1_0_1; }

		//("assure" "subsystem" assureSubsystems+=[aadl2::Subcomponent]+ | assureAll?="all")?
		public Alternatives getAlternatives_7_2() { return cAlternatives_7_2; }

		//"assure" "subsystem" assureSubsystems+=[aadl2::Subcomponent]+
		public Group getGroup_7_2_0() { return cGroup_7_2_0; }

		//"assure"
		public Keyword getAssureKeyword_7_2_0_0() { return cAssureKeyword_7_2_0_0; }

		//"subsystem"
		public Keyword getSubsystemKeyword_7_2_0_1() { return cSubsystemKeyword_7_2_0_1; }

		//assureSubsystems+=[aadl2::Subcomponent]+
		public Assignment getAssureSubsystemsAssignment_7_2_0_2() { return cAssureSubsystemsAssignment_7_2_0_2; }

		//[aadl2::Subcomponent]
		public CrossReference getAssureSubsystemsSubcomponentCrossReference_7_2_0_2_0() { return cAssureSubsystemsSubcomponentCrossReference_7_2_0_2_0; }

		//ID
		public RuleCall getAssureSubsystemsSubcomponentIDTerminalRuleCall_7_2_0_2_0_1() { return cAssureSubsystemsSubcomponentIDTerminalRuleCall_7_2_0_2_0_1; }

		//assureAll?="all"
		public Assignment getAssureAllAssignment_7_2_1() { return cAssureAllAssignment_7_2_1; }

		//"all"
		public Keyword getAssureAllAllKeyword_7_2_1_0() { return cAssureAllAllKeyword_7_2_1_0; }

		//("assume" "subsystem" (assumeSubsystems+=[aadl2::Subcomponent]+ | assumeAll?="all"))?
		public Group getGroup_7_3() { return cGroup_7_3; }

		//"assume"
		public Keyword getAssumeKeyword_7_3_0() { return cAssumeKeyword_7_3_0; }

		//"subsystem"
		public Keyword getSubsystemKeyword_7_3_1() { return cSubsystemKeyword_7_3_1; }

		//assumeSubsystems+=[aadl2::Subcomponent]+ | assumeAll?="all"
		public Alternatives getAlternatives_7_3_2() { return cAlternatives_7_3_2; }

		//assumeSubsystems+=[aadl2::Subcomponent]+
		public Assignment getAssumeSubsystemsAssignment_7_3_2_0() { return cAssumeSubsystemsAssignment_7_3_2_0; }

		//[aadl2::Subcomponent]
		public CrossReference getAssumeSubsystemsSubcomponentCrossReference_7_3_2_0_0() { return cAssumeSubsystemsSubcomponentCrossReference_7_3_2_0_0; }

		//ID
		public RuleCall getAssumeSubsystemsSubcomponentIDTerminalRuleCall_7_3_2_0_0_1() { return cAssumeSubsystemsSubcomponentIDTerminalRuleCall_7_3_2_0_0_1; }

		//assumeAll?="all"
		public Assignment getAssumeAllAssignment_7_3_2_1() { return cAssumeAllAssignment_7_3_2_1; }

		//"all"
		public Keyword getAssumeAllAllKeyword_7_3_2_1_0() { return cAssumeAllAllKeyword_7_3_2_1_0; }

		//("issues" issues+=STRING+)?
		public Group getGroup_7_4() { return cGroup_7_4; }

		//"issues"
		public Keyword getIssuesKeyword_7_4_0() { return cIssuesKeyword_7_4_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_7_4_1() { return cIssuesAssignment_7_4_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_7_4_1_0() { return cIssuesSTRINGTerminalRuleCall_7_4_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8() { return cRightSquareBracketKeyword_8; }
	}

	public class AssuranceTaskElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AssuranceTask");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAssuranceTaskAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAssuranceKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTaskKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cNameAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cNameIDTerminalRuleCall_3_0 = (RuleCall)cNameAssignment_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cColonKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cTitleAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cTitleSTRINGTerminalRuleCall_4_1_0 = (RuleCall)cTitleAssignment_4_1.eContents().get(0);
		private final Keyword cForKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Assignment cAssurancePlanAssignment_6 = (Assignment)cGroup.eContents().get(6);
		private final CrossReference cAssurancePlanAssurancePlanCrossReference_6_0 = (CrossReference)cAssurancePlanAssignment_6.eContents().get(0);
		private final RuleCall cAssurancePlanAssurancePlanQualifiedNameParserRuleCall_6_0_1 = (RuleCall)cAssurancePlanAssurancePlanCrossReference_6_0.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_7 = (Keyword)cGroup.eContents().get(7);
		private final UnorderedGroup cUnorderedGroup_8 = (UnorderedGroup)cGroup.eContents().get(8);
		private final Group cGroup_8_0 = (Group)cUnorderedGroup_8.eContents().get(0);
		private final Keyword cDescriptionKeyword_8_0_0 = (Keyword)cGroup_8_0.eContents().get(0);
		private final Assignment cDescriptionAssignment_8_0_1 = (Assignment)cGroup_8_0.eContents().get(1);
		private final RuleCall cDescriptionDescriptionParserRuleCall_8_0_1_0 = (RuleCall)cDescriptionAssignment_8_0_1.eContents().get(0);
		private final UnorderedGroup cUnorderedGroup_8_1 = (UnorderedGroup)cUnorderedGroup_8.eContents().get(1);
		private final Group cGroup_8_1_0 = (Group)cUnorderedGroup_8_1.eContents().get(0);
		private final Keyword cFilterKeyword_8_1_0_0 = (Keyword)cGroup_8_1_0.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_8_1_0_1 = (Keyword)cGroup_8_1_0.eContents().get(1);
		private final Group cGroup_8_1_0_2 = (Group)cGroup_8_1_0.eContents().get(2);
		private final Keyword cRequirementKeyword_8_1_0_2_0 = (Keyword)cGroup_8_1_0_2.eContents().get(0);
		private final Keyword cTypeKeyword_8_1_0_2_1 = (Keyword)cGroup_8_1_0_2.eContents().get(1);
		private final Assignment cRequirementTypeAssignment_8_1_0_2_2 = (Assignment)cGroup_8_1_0_2.eContents().get(2);
		private final CrossReference cRequirementTypeRequirementTypeCrossReference_8_1_0_2_2_0 = (CrossReference)cRequirementTypeAssignment_8_1_0_2_2.eContents().get(0);
		private final RuleCall cRequirementTypeRequirementTypeIDTerminalRuleCall_8_1_0_2_2_0_1 = (RuleCall)cRequirementTypeRequirementTypeCrossReference_8_1_0_2_2_0.eContents().get(1);
		private final Assignment cAnyRequirementTypeAssignment_8_1_0_2_3 = (Assignment)cGroup_8_1_0_2.eContents().get(3);
		private final Keyword cAnyRequirementTypeAnyKeyword_8_1_0_2_3_0 = (Keyword)cAnyRequirementTypeAssignment_8_1_0_2_3.eContents().get(0);
		private final Group cGroup_8_1_1 = (Group)cUnorderedGroup_8_1.eContents().get(1);
		private final Keyword cMethodKeyword_8_1_1_0 = (Keyword)cGroup_8_1_1.eContents().get(0);
		private final Keyword cTypeKeyword_8_1_1_1 = (Keyword)cGroup_8_1_1.eContents().get(1);
		private final Assignment cMethodTypeAssignment_8_1_1_2 = (Assignment)cGroup_8_1_1.eContents().get(2);
		private final CrossReference cMethodTypeMethodTypeCrossReference_8_1_1_2_0 = (CrossReference)cMethodTypeAssignment_8_1_1_2.eContents().get(0);
		private final RuleCall cMethodTypeMethodTypeIDTerminalRuleCall_8_1_1_2_0_1 = (RuleCall)cMethodTypeMethodTypeCrossReference_8_1_1_2_0.eContents().get(1);
		private final Assignment cAnyMethodTypeAssignment_8_1_1_3 = (Assignment)cGroup_8_1_1.eContents().get(3);
		private final Keyword cAnyMethodTypeAnyKeyword_8_1_1_3_0 = (Keyword)cAnyMethodTypeAssignment_8_1_1_3.eContents().get(0);
		private final Group cGroup_8_1_2 = (Group)cUnorderedGroup_8_1.eContents().get(2);
		private final Keyword cUserKeyword_8_1_2_0 = (Keyword)cGroup_8_1_2.eContents().get(0);
		private final Keyword cSelectionKeyword_8_1_2_1 = (Keyword)cGroup_8_1_2.eContents().get(1);
		private final Assignment cUserSelectionAssignment_8_1_2_2 = (Assignment)cGroup_8_1_2.eContents().get(2);
		private final CrossReference cUserSelectionUserSelectionCrossReference_8_1_2_2_0 = (CrossReference)cUserSelectionAssignment_8_1_2_2.eContents().get(0);
		private final RuleCall cUserSelectionUserSelectionIDTerminalRuleCall_8_1_2_2_0_1 = (RuleCall)cUserSelectionUserSelectionCrossReference_8_1_2_2_0.eContents().get(1);
		private final Assignment cAnyUserSelectionAssignment_8_1_2_3 = (Assignment)cGroup_8_1_2.eContents().get(3);
		private final Keyword cAnyUserSelectionAnyKeyword_8_1_2_3_0 = (Keyword)cAnyUserSelectionAssignment_8_1_2_3.eContents().get(0);
		private final Group cGroup_8_1_3 = (Group)cUnorderedGroup_8_1.eContents().get(3);
		private final Keyword cQualityKeyword_8_1_3_0 = (Keyword)cGroup_8_1_3.eContents().get(0);
		private final Keyword cAttributeKeyword_8_1_3_1 = (Keyword)cGroup_8_1_3.eContents().get(1);
		private final Assignment cQualityAttributeAssignment_8_1_3_2 = (Assignment)cGroup_8_1_3.eContents().get(2);
		private final CrossReference cQualityAttributeQualityAttributeCrossReference_8_1_3_2_0 = (CrossReference)cQualityAttributeAssignment_8_1_3_2.eContents().get(0);
		private final RuleCall cQualityAttributeQualityAttributeIDTerminalRuleCall_8_1_3_2_0_1 = (RuleCall)cQualityAttributeQualityAttributeCrossReference_8_1_3_2_0.eContents().get(1);
		private final Assignment cAnyQualityAttributeAssignment_8_1_3_3 = (Assignment)cGroup_8_1_3.eContents().get(3);
		private final Keyword cAnyQualityAttributeAnyKeyword_8_1_3_3_0 = (Keyword)cAnyQualityAttributeAssignment_8_1_3_3.eContents().get(0);
		private final Group cGroup_8_1_4 = (Group)cUnorderedGroup_8_1.eContents().get(4);
		private final Group cGroup_8_1_4_0 = (Group)cGroup_8_1_4.eContents().get(0);
		private final Keyword cDevelopmentKeyword_8_1_4_0_0 = (Keyword)cGroup_8_1_4_0.eContents().get(0);
		private final Keyword cPhaseKeyword_8_1_4_0_1 = (Keyword)cGroup_8_1_4_0.eContents().get(1);
		private final Assignment cDevelopmentPhaseAssignment_8_1_4_0_2 = (Assignment)cGroup_8_1_4_0.eContents().get(2);
		private final CrossReference cDevelopmentPhaseDevelopmentPhaseCrossReference_8_1_4_0_2_0 = (CrossReference)cDevelopmentPhaseAssignment_8_1_4_0_2.eContents().get(0);
		private final RuleCall cDevelopmentPhaseDevelopmentPhaseIDTerminalRuleCall_8_1_4_0_2_0_1 = (RuleCall)cDevelopmentPhaseDevelopmentPhaseCrossReference_8_1_4_0_2_0.eContents().get(1);
		private final Assignment cAnyDevelopmentPhaseAssignment_8_1_4_0_3 = (Assignment)cGroup_8_1_4_0.eContents().get(3);
		private final Keyword cAnyDevelopmentPhaseAnyKeyword_8_1_4_0_3_0 = (Keyword)cAnyDevelopmentPhaseAssignment_8_1_4_0_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_8_1_4_1 = (Keyword)cGroup_8_1_4.eContents().get(1);
		private final Group cGroup_8_2 = (Group)cUnorderedGroup_8.eContents().get(2);
		private final Keyword cIssuesKeyword_8_2_0 = (Keyword)cGroup_8_2.eContents().get(0);
		private final Assignment cIssuesAssignment_8_2_1 = (Assignment)cGroup_8_2.eContents().get(1);
		private final RuleCall cIssuesSTRINGTerminalRuleCall_8_2_1_0 = (RuleCall)cIssuesAssignment_8_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_9 = (Keyword)cGroup.eContents().get(9);
		
		//AssuranceTask returns CategoryFilter:
		//	{AssuranceTask} "assurance" "task" name=ID (":" title=STRING)? "for" assurancePlan=[AssurancePlan|QualifiedName] "["
		//	(("description" description=Description)? & ("filter" "[" ("requirement" "type"
		//	requirementType+=[categories::RequirementType]+ anyRequirementType?="any"?)? & ("method" "type"
		//	methodType+=[categories::MethodType]+ anyMethodType?="any"?)? & ("user" "selection"
		//	userSelection+=[categories::UserSelection]+ anyUserSelection?="any"?)? & ("quality" "attribute"
		//	qualityAttribute+=[categories::QualityAttribute]+ anyQualityAttribute?="any"?)? & ("development" "phase"
		//	developmentPhase+=[categories::DevelopmentPhase]+ anyDevelopmentPhase?="any"?)? "]")? & ("issues" issues+=STRING+)?)
		//	"]";
		@Override public ParserRule getRule() { return rule; }

		//{AssuranceTask} "assurance" "task" name=ID (":" title=STRING)? "for" assurancePlan=[AssurancePlan|QualifiedName] "["
		//(("description" description=Description)? & ("filter" "[" ("requirement" "type"
		//requirementType+=[categories::RequirementType]+ anyRequirementType?="any"?)? & ("method" "type"
		//methodType+=[categories::MethodType]+ anyMethodType?="any"?)? & ("user" "selection"
		//userSelection+=[categories::UserSelection]+ anyUserSelection?="any"?)? & ("quality" "attribute"
		//qualityAttribute+=[categories::QualityAttribute]+ anyQualityAttribute?="any"?)? & ("development" "phase"
		//developmentPhase+=[categories::DevelopmentPhase]+ anyDevelopmentPhase?="any"?)? "]")? & ("issues" issues+=STRING+)?)
		//"]"
		public Group getGroup() { return cGroup; }

		//{AssuranceTask}
		public Action getAssuranceTaskAction_0() { return cAssuranceTaskAction_0; }

		//"assurance"
		public Keyword getAssuranceKeyword_1() { return cAssuranceKeyword_1; }

		//"task"
		public Keyword getTaskKeyword_2() { return cTaskKeyword_2; }

		//name=ID
		public Assignment getNameAssignment_3() { return cNameAssignment_3; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_3_0() { return cNameIDTerminalRuleCall_3_0; }

		//(":" title=STRING)?
		public Group getGroup_4() { return cGroup_4; }

		//":"
		public Keyword getColonKeyword_4_0() { return cColonKeyword_4_0; }

		//title=STRING
		public Assignment getTitleAssignment_4_1() { return cTitleAssignment_4_1; }

		//STRING
		public RuleCall getTitleSTRINGTerminalRuleCall_4_1_0() { return cTitleSTRINGTerminalRuleCall_4_1_0; }

		//"for"
		public Keyword getForKeyword_5() { return cForKeyword_5; }

		//assurancePlan=[AssurancePlan|QualifiedName]
		public Assignment getAssurancePlanAssignment_6() { return cAssurancePlanAssignment_6; }

		//[AssurancePlan|QualifiedName]
		public CrossReference getAssurancePlanAssurancePlanCrossReference_6_0() { return cAssurancePlanAssurancePlanCrossReference_6_0; }

		//QualifiedName
		public RuleCall getAssurancePlanAssurancePlanQualifiedNameParserRuleCall_6_0_1() { return cAssurancePlanAssurancePlanQualifiedNameParserRuleCall_6_0_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_7() { return cLeftSquareBracketKeyword_7; }

		//("description" description=Description)? & ("filter" "[" ("requirement" "type"
		//requirementType+=[categories::RequirementType]+ anyRequirementType?="any"?)? & ("method" "type"
		//methodType+=[categories::MethodType]+ anyMethodType?="any"?)? & ("user" "selection"
		//userSelection+=[categories::UserSelection]+ anyUserSelection?="any"?)? & ("quality" "attribute"
		//qualityAttribute+=[categories::QualityAttribute]+ anyQualityAttribute?="any"?)? & ("development" "phase"
		//developmentPhase+=[categories::DevelopmentPhase]+ anyDevelopmentPhase?="any"?)? "]")? & ("issues" issues+=STRING+)?
		public UnorderedGroup getUnorderedGroup_8() { return cUnorderedGroup_8; }

		//("description" description=Description)?
		public Group getGroup_8_0() { return cGroup_8_0; }

		//"description"
		public Keyword getDescriptionKeyword_8_0_0() { return cDescriptionKeyword_8_0_0; }

		//description=Description
		public Assignment getDescriptionAssignment_8_0_1() { return cDescriptionAssignment_8_0_1; }

		//Description
		public RuleCall getDescriptionDescriptionParserRuleCall_8_0_1_0() { return cDescriptionDescriptionParserRuleCall_8_0_1_0; }

		//("filter" "[" ("requirement" "type" requirementType+=[categories::RequirementType]+ anyRequirementType?="any"?)? &
		//("method" "type" methodType+=[categories::MethodType]+ anyMethodType?="any"?)? & ("user" "selection"
		//userSelection+=[categories::UserSelection]+ anyUserSelection?="any"?)? & ("quality" "attribute"
		//qualityAttribute+=[categories::QualityAttribute]+ anyQualityAttribute?="any"?)? & ("development" "phase"
		//developmentPhase+=[categories::DevelopmentPhase]+ anyDevelopmentPhase?="any"?)? "]")?
		public UnorderedGroup getUnorderedGroup_8_1() { return cUnorderedGroup_8_1; }

		//"filter" "[" ("requirement" "type" requirementType+=[categories::RequirementType]+ anyRequirementType?="any"?)?
		public Group getGroup_8_1_0() { return cGroup_8_1_0; }

		//"filter"
		public Keyword getFilterKeyword_8_1_0_0() { return cFilterKeyword_8_1_0_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_8_1_0_1() { return cLeftSquareBracketKeyword_8_1_0_1; }

		//("requirement" "type" requirementType+=[categories::RequirementType]+ anyRequirementType?="any"?)?
		public Group getGroup_8_1_0_2() { return cGroup_8_1_0_2; }

		//"requirement"
		public Keyword getRequirementKeyword_8_1_0_2_0() { return cRequirementKeyword_8_1_0_2_0; }

		//"type"
		public Keyword getTypeKeyword_8_1_0_2_1() { return cTypeKeyword_8_1_0_2_1; }

		//requirementType+=[categories::RequirementType]+
		public Assignment getRequirementTypeAssignment_8_1_0_2_2() { return cRequirementTypeAssignment_8_1_0_2_2; }

		//[categories::RequirementType]
		public CrossReference getRequirementTypeRequirementTypeCrossReference_8_1_0_2_2_0() { return cRequirementTypeRequirementTypeCrossReference_8_1_0_2_2_0; }

		//ID
		public RuleCall getRequirementTypeRequirementTypeIDTerminalRuleCall_8_1_0_2_2_0_1() { return cRequirementTypeRequirementTypeIDTerminalRuleCall_8_1_0_2_2_0_1; }

		//anyRequirementType?="any"?
		public Assignment getAnyRequirementTypeAssignment_8_1_0_2_3() { return cAnyRequirementTypeAssignment_8_1_0_2_3; }

		//"any"
		public Keyword getAnyRequirementTypeAnyKeyword_8_1_0_2_3_0() { return cAnyRequirementTypeAnyKeyword_8_1_0_2_3_0; }

		//("method" "type" methodType+=[categories::MethodType]+ anyMethodType?="any"?)?
		public Group getGroup_8_1_1() { return cGroup_8_1_1; }

		//"method"
		public Keyword getMethodKeyword_8_1_1_0() { return cMethodKeyword_8_1_1_0; }

		//"type"
		public Keyword getTypeKeyword_8_1_1_1() { return cTypeKeyword_8_1_1_1; }

		//methodType+=[categories::MethodType]+
		public Assignment getMethodTypeAssignment_8_1_1_2() { return cMethodTypeAssignment_8_1_1_2; }

		//[categories::MethodType]
		public CrossReference getMethodTypeMethodTypeCrossReference_8_1_1_2_0() { return cMethodTypeMethodTypeCrossReference_8_1_1_2_0; }

		//ID
		public RuleCall getMethodTypeMethodTypeIDTerminalRuleCall_8_1_1_2_0_1() { return cMethodTypeMethodTypeIDTerminalRuleCall_8_1_1_2_0_1; }

		//anyMethodType?="any"?
		public Assignment getAnyMethodTypeAssignment_8_1_1_3() { return cAnyMethodTypeAssignment_8_1_1_3; }

		//"any"
		public Keyword getAnyMethodTypeAnyKeyword_8_1_1_3_0() { return cAnyMethodTypeAnyKeyword_8_1_1_3_0; }

		//("user" "selection" userSelection+=[categories::UserSelection]+ anyUserSelection?="any"?)?
		public Group getGroup_8_1_2() { return cGroup_8_1_2; }

		//"user"
		public Keyword getUserKeyword_8_1_2_0() { return cUserKeyword_8_1_2_0; }

		//"selection"
		public Keyword getSelectionKeyword_8_1_2_1() { return cSelectionKeyword_8_1_2_1; }

		//userSelection+=[categories::UserSelection]+
		public Assignment getUserSelectionAssignment_8_1_2_2() { return cUserSelectionAssignment_8_1_2_2; }

		//[categories::UserSelection]
		public CrossReference getUserSelectionUserSelectionCrossReference_8_1_2_2_0() { return cUserSelectionUserSelectionCrossReference_8_1_2_2_0; }

		//ID
		public RuleCall getUserSelectionUserSelectionIDTerminalRuleCall_8_1_2_2_0_1() { return cUserSelectionUserSelectionIDTerminalRuleCall_8_1_2_2_0_1; }

		//anyUserSelection?="any"?
		public Assignment getAnyUserSelectionAssignment_8_1_2_3() { return cAnyUserSelectionAssignment_8_1_2_3; }

		//"any"
		public Keyword getAnyUserSelectionAnyKeyword_8_1_2_3_0() { return cAnyUserSelectionAnyKeyword_8_1_2_3_0; }

		//("quality" "attribute" qualityAttribute+=[categories::QualityAttribute]+ anyQualityAttribute?="any"?)?
		public Group getGroup_8_1_3() { return cGroup_8_1_3; }

		//"quality"
		public Keyword getQualityKeyword_8_1_3_0() { return cQualityKeyword_8_1_3_0; }

		//"attribute"
		public Keyword getAttributeKeyword_8_1_3_1() { return cAttributeKeyword_8_1_3_1; }

		//qualityAttribute+=[categories::QualityAttribute]+
		public Assignment getQualityAttributeAssignment_8_1_3_2() { return cQualityAttributeAssignment_8_1_3_2; }

		//[categories::QualityAttribute]
		public CrossReference getQualityAttributeQualityAttributeCrossReference_8_1_3_2_0() { return cQualityAttributeQualityAttributeCrossReference_8_1_3_2_0; }

		//ID
		public RuleCall getQualityAttributeQualityAttributeIDTerminalRuleCall_8_1_3_2_0_1() { return cQualityAttributeQualityAttributeIDTerminalRuleCall_8_1_3_2_0_1; }

		//anyQualityAttribute?="any"?
		public Assignment getAnyQualityAttributeAssignment_8_1_3_3() { return cAnyQualityAttributeAssignment_8_1_3_3; }

		//"any"
		public Keyword getAnyQualityAttributeAnyKeyword_8_1_3_3_0() { return cAnyQualityAttributeAnyKeyword_8_1_3_3_0; }

		//("development" "phase" developmentPhase+=[categories::DevelopmentPhase]+ anyDevelopmentPhase?="any"?)? "]"
		public Group getGroup_8_1_4() { return cGroup_8_1_4; }

		//("development" "phase" developmentPhase+=[categories::DevelopmentPhase]+ anyDevelopmentPhase?="any"?)?
		public Group getGroup_8_1_4_0() { return cGroup_8_1_4_0; }

		//"development"
		public Keyword getDevelopmentKeyword_8_1_4_0_0() { return cDevelopmentKeyword_8_1_4_0_0; }

		//"phase"
		public Keyword getPhaseKeyword_8_1_4_0_1() { return cPhaseKeyword_8_1_4_0_1; }

		//developmentPhase+=[categories::DevelopmentPhase]+
		public Assignment getDevelopmentPhaseAssignment_8_1_4_0_2() { return cDevelopmentPhaseAssignment_8_1_4_0_2; }

		//[categories::DevelopmentPhase]
		public CrossReference getDevelopmentPhaseDevelopmentPhaseCrossReference_8_1_4_0_2_0() { return cDevelopmentPhaseDevelopmentPhaseCrossReference_8_1_4_0_2_0; }

		//ID
		public RuleCall getDevelopmentPhaseDevelopmentPhaseIDTerminalRuleCall_8_1_4_0_2_0_1() { return cDevelopmentPhaseDevelopmentPhaseIDTerminalRuleCall_8_1_4_0_2_0_1; }

		//anyDevelopmentPhase?="any"?
		public Assignment getAnyDevelopmentPhaseAssignment_8_1_4_0_3() { return cAnyDevelopmentPhaseAssignment_8_1_4_0_3; }

		//"any"
		public Keyword getAnyDevelopmentPhaseAnyKeyword_8_1_4_0_3_0() { return cAnyDevelopmentPhaseAnyKeyword_8_1_4_0_3_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_8_1_4_1() { return cRightSquareBracketKeyword_8_1_4_1; }

		//("issues" issues+=STRING+)?
		public Group getGroup_8_2() { return cGroup_8_2; }

		//"issues"
		public Keyword getIssuesKeyword_8_2_0() { return cIssuesKeyword_8_2_0; }

		//issues+=STRING+
		public Assignment getIssuesAssignment_8_2_1() { return cIssuesAssignment_8_2_1; }

		//STRING
		public RuleCall getIssuesSTRINGTerminalRuleCall_8_2_1_0() { return cIssuesSTRINGTerminalRuleCall_8_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_9() { return cRightSquareBracketKeyword_9; }
	}
	
	
	private final AlisaWorkAreaElements pAlisaWorkArea;
	private final AssurancePlanElements pAssurancePlan;
	private final AssuranceTaskElements pAssuranceTask;
	
	private final Grammar grammar;

	private final CommonGrammarAccess gaCommon;

	@Inject
	public AlisaGrammarAccess(GrammarProvider grammarProvider,
		CommonGrammarAccess gaCommon) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaCommon = gaCommon;
		this.pAlisaWorkArea = new AlisaWorkAreaElements();
		this.pAssurancePlan = new AssurancePlanElements();
		this.pAssuranceTask = new AssuranceTaskElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.alisa.workbench.Alisa".equals(grammar.getName())) {
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

	
	//AlisaWorkArea:
	//	cases+=(AssurancePlan | AssuranceTask)*;
	public AlisaWorkAreaElements getAlisaWorkAreaAccess() {
		return pAlisaWorkArea;
	}
	
	public ParserRule getAlisaWorkAreaRule() {
		return getAlisaWorkAreaAccess().getRule();
	}

	//AssurancePlan:
	//	"assurance" "plan" name=QualifiedName (":" title=STRING)? "for"
	//	target=[aadl2::ComponentImplementation|AadlClassifierReference] "[" (description=Description? & ("assure"
	//	assure+=[Verify::VerificationPlan|QualifiedName]+)? & ("assure" "subsystem" assureSubsystems+=[aadl2::Subcomponent]+
	//	| assureAll?="all")? & ("assume" "subsystem" (assumeSubsystems+=[aadl2::Subcomponent]+ | assumeAll?="all"))? &
	//	("issues" issues+=STRING+)?) "]";
	public AssurancePlanElements getAssurancePlanAccess() {
		return pAssurancePlan;
	}
	
	public ParserRule getAssurancePlanRule() {
		return getAssurancePlanAccess().getRule();
	}

	//AssuranceTask returns CategoryFilter:
	//	{AssuranceTask} "assurance" "task" name=ID (":" title=STRING)? "for" assurancePlan=[AssurancePlan|QualifiedName] "["
	//	(("description" description=Description)? & ("filter" "[" ("requirement" "type"
	//	requirementType+=[categories::RequirementType]+ anyRequirementType?="any"?)? & ("method" "type"
	//	methodType+=[categories::MethodType]+ anyMethodType?="any"?)? & ("user" "selection"
	//	userSelection+=[categories::UserSelection]+ anyUserSelection?="any"?)? & ("quality" "attribute"
	//	qualityAttribute+=[categories::QualityAttribute]+ anyQualityAttribute?="any"?)? & ("development" "phase"
	//	developmentPhase+=[categories::DevelopmentPhase]+ anyDevelopmentPhase?="any"?)? "]")? & ("issues" issues+=STRING+)?)
	//	"]";
	public AssuranceTaskElements getAssuranceTaskAccess() {
		return pAssuranceTask;
	}
	
	public ParserRule getAssuranceTaskRule() {
		return getAssuranceTaskAccess().getRule();
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
