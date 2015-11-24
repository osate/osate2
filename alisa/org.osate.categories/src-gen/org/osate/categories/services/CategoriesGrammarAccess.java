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
package org.osate.categories.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class CategoriesGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class CategoriesDefinitionsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CategoriesDefinitions");
		private final UnorderedGroup cUnorderedGroup = (UnorderedGroup)rule.eContents().get(1);
		private final Assignment cRequirementTypeCategoriesAssignment_0 = (Assignment)cUnorderedGroup.eContents().get(0);
		private final RuleCall cRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0 = (RuleCall)cRequirementTypeCategoriesAssignment_0.eContents().get(0);
		private final Assignment cMethodTypeCategoriesAssignment_1 = (Assignment)cUnorderedGroup.eContents().get(1);
		private final RuleCall cMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0 = (RuleCall)cMethodTypeCategoriesAssignment_1.eContents().get(0);
		private final Assignment cSelectioncategoriesAssignment_2 = (Assignment)cUnorderedGroup.eContents().get(2);
		private final RuleCall cSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0 = (RuleCall)cSelectioncategoriesAssignment_2.eContents().get(0);
		private final Assignment cDevelopmentPhaseCategoriesAssignment_3 = (Assignment)cUnorderedGroup.eContents().get(3);
		private final RuleCall cDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0 = (RuleCall)cDevelopmentPhaseCategoriesAssignment_3.eContents().get(0);
		private final Assignment cQualityAttributeCategoriesAssignment_4 = (Assignment)cUnorderedGroup.eContents().get(4);
		private final RuleCall cQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0 = (RuleCall)cQualityAttributeCategoriesAssignment_4.eContents().get(0);
		
		//CategoriesDefinitions:
		//	requirementTypeCategories=RequirementTypeCategories? & methodTypeCategories=MethodTypeCategories? &
		//	selectioncategories=UserSelectionCategories? & developmentPhaseCategories=DevelopmentPhaseCategories? & //&  categoryFilters=CategoryFilters?
		//	qualityAttributeCategories=QualityAttributeCategories?;
		@Override public ParserRule getRule() { return rule; }

		//requirementTypeCategories=RequirementTypeCategories? & methodTypeCategories=MethodTypeCategories? &
		//selectioncategories=UserSelectionCategories? & developmentPhaseCategories=DevelopmentPhaseCategories? & //&  categoryFilters=CategoryFilters?
		//qualityAttributeCategories=QualityAttributeCategories?
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//requirementTypeCategories=RequirementTypeCategories?
		public Assignment getRequirementTypeCategoriesAssignment_0() { return cRequirementTypeCategoriesAssignment_0; }

		//RequirementTypeCategories
		public RuleCall getRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0() { return cRequirementTypeCategoriesRequirementTypeCategoriesParserRuleCall_0_0; }

		//methodTypeCategories=MethodTypeCategories?
		public Assignment getMethodTypeCategoriesAssignment_1() { return cMethodTypeCategoriesAssignment_1; }

		//MethodTypeCategories
		public RuleCall getMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0() { return cMethodTypeCategoriesMethodTypeCategoriesParserRuleCall_1_0; }

		//selectioncategories=UserSelectionCategories?
		public Assignment getSelectioncategoriesAssignment_2() { return cSelectioncategoriesAssignment_2; }

		//UserSelectionCategories
		public RuleCall getSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0() { return cSelectioncategoriesUserSelectionCategoriesParserRuleCall_2_0; }

		//developmentPhaseCategories=DevelopmentPhaseCategories?
		public Assignment getDevelopmentPhaseCategoriesAssignment_3() { return cDevelopmentPhaseCategoriesAssignment_3; }

		//DevelopmentPhaseCategories
		public RuleCall getDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0() { return cDevelopmentPhaseCategoriesDevelopmentPhaseCategoriesParserRuleCall_3_0; }

		////&  categoryFilters=CategoryFilters?
		//qualityAttributeCategories=QualityAttributeCategories?
		public Assignment getQualityAttributeCategoriesAssignment_4() { return cQualityAttributeCategoriesAssignment_4; }

		//QualityAttributeCategories
		public RuleCall getQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0() { return cQualityAttributeCategoriesQualityAttributeCategoriesParserRuleCall_4_0; }
	}

	public class RequirementTypeCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RequirementTypeCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRequirementTypeCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cRequirementKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCategoryAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCategoryRequirementTypeParserRuleCall_4_0 = (RuleCall)cCategoryAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//RequirementTypeCategories returns Categories:
		//	{RequirementTypeCategories} "requirement" "type" "[" category+=RequirementType+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{RequirementTypeCategories} "requirement" "type" "[" category+=RequirementType+ "]"
		public Group getGroup() { return cGroup; }

		//{RequirementTypeCategories}
		public Action getRequirementTypeCategoriesAction_0() { return cRequirementTypeCategoriesAction_0; }

		//"requirement"
		public Keyword getRequirementKeyword_1() { return cRequirementKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//category+=RequirementType+
		public Assignment getCategoryAssignment_4() { return cCategoryAssignment_4; }

		//RequirementType
		public RuleCall getCategoryRequirementTypeParserRuleCall_4_0() { return cCategoryRequirementTypeParserRuleCall_4_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class MethodTypeCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MethodTypeCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMethodTypeCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cMethodKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cTypeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCategoryAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCategoryMethodTypeParserRuleCall_4_0 = (RuleCall)cCategoryAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//MethodTypeCategories returns Categories:
		//	{MethodTypeCategories} "method" "type" "[" category+=MethodType+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{MethodTypeCategories} "method" "type" "[" category+=MethodType+ "]"
		public Group getGroup() { return cGroup; }

		//{MethodTypeCategories}
		public Action getMethodTypeCategoriesAction_0() { return cMethodTypeCategoriesAction_0; }

		//"method"
		public Keyword getMethodKeyword_1() { return cMethodKeyword_1; }

		//"type"
		public Keyword getTypeKeyword_2() { return cTypeKeyword_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//category+=MethodType+
		public Assignment getCategoryAssignment_4() { return cCategoryAssignment_4; }

		//MethodType
		public RuleCall getCategoryMethodTypeParserRuleCall_4_0() { return cCategoryMethodTypeParserRuleCall_4_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class UserSelectionCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UserSelectionCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUserSelectionCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cUserKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cSelectionKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCategoryAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCategoryUserSelectionParserRuleCall_4_0 = (RuleCall)cCategoryAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//UserSelectionCategories returns Categories:
		//	{UserSelectionCategories} "user" "selection" "[" category+=UserSelection+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{UserSelectionCategories} "user" "selection" "[" category+=UserSelection+ "]"
		public Group getGroup() { return cGroup; }

		//{UserSelectionCategories}
		public Action getUserSelectionCategoriesAction_0() { return cUserSelectionCategoriesAction_0; }

		//"user"
		public Keyword getUserKeyword_1() { return cUserKeyword_1; }

		//"selection"
		public Keyword getSelectionKeyword_2() { return cSelectionKeyword_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//category+=UserSelection+
		public Assignment getCategoryAssignment_4() { return cCategoryAssignment_4; }

		//UserSelection
		public RuleCall getCategoryUserSelectionParserRuleCall_4_0() { return cCategoryUserSelectionParserRuleCall_4_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class QualityAttributeCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualityAttributeCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cQualityAttributeCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cQualityKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cAttributeKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCategoryAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCategoryQualityAttributeParserRuleCall_4_0 = (RuleCall)cCategoryAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//QualityAttributeCategories returns Categories:
		//	{QualityAttributeCategories} "quality" "attribute" "[" category+=QualityAttribute+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{QualityAttributeCategories} "quality" "attribute" "[" category+=QualityAttribute+ "]"
		public Group getGroup() { return cGroup; }

		//{QualityAttributeCategories}
		public Action getQualityAttributeCategoriesAction_0() { return cQualityAttributeCategoriesAction_0; }

		//"quality"
		public Keyword getQualityKeyword_1() { return cQualityKeyword_1; }

		//"attribute"
		public Keyword getAttributeKeyword_2() { return cAttributeKeyword_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//category+=QualityAttribute+
		public Assignment getCategoryAssignment_4() { return cCategoryAssignment_4; }

		//QualityAttribute
		public RuleCall getCategoryQualityAttributeParserRuleCall_4_0() { return cCategoryQualityAttributeParserRuleCall_4_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class DevelopmentPhaseCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DevelopmentPhaseCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDevelopmentPhaseCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cDevelopmentKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cPhaseKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Assignment cCategoryAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCategoryDevelopmentPhaseParserRuleCall_4_0 = (RuleCall)cCategoryAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//DevelopmentPhaseCategories returns Categories:
		//	{DevelopmentPhaseCategories} "development" "phase" "[" category+=DevelopmentPhase+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{DevelopmentPhaseCategories} "development" "phase" "[" category+=DevelopmentPhase+ "]"
		public Group getGroup() { return cGroup; }

		//{DevelopmentPhaseCategories}
		public Action getDevelopmentPhaseCategoriesAction_0() { return cDevelopmentPhaseCategoriesAction_0; }

		//"development"
		public Keyword getDevelopmentKeyword_1() { return cDevelopmentKeyword_1; }

		//"phase"
		public Keyword getPhaseKeyword_2() { return cPhaseKeyword_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_3() { return cLeftSquareBracketKeyword_3; }

		//category+=DevelopmentPhase+
		public Assignment getCategoryAssignment_4() { return cCategoryAssignment_4; }

		//DevelopmentPhase
		public RuleCall getCategoryDevelopmentPhaseParserRuleCall_4_0() { return cCategoryDevelopmentPhaseParserRuleCall_4_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class RequirementTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RequirementType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cRequirementTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * Requirement category indicates the type of requirement
		// * / RequirementType returns Category:
		//	{RequirementType} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{RequirementType} name=ID
		public Group getGroup() { return cGroup; }

		//{RequirementType}
		public Action getRequirementTypeAction_0() { return cRequirementTypeAction_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class MethodTypeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MethodType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMethodTypeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * Method type indicates the type of verification method
		// * / MethodType returns Category:
		//	{MethodType} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{MethodType} name=ID
		public Group getGroup() { return cGroup; }

		//{MethodType}
		public Action getMethodTypeAction_0() { return cMethodTypeAction_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class UserSelectionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UserSelection");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUserSelectionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * user selection  indicates a user defined selection categories  
		// * / UserSelection returns Category:
		//	{UserSelection} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{UserSelection} name=ID
		public Group getGroup() { return cGroup; }

		//{UserSelection}
		public Action getUserSelectionAction_0() { return cUserSelectionAction_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class QualityAttributeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualityAttribute");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cQualityAttributeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * quality attribute indicates a quality attribute 
		// * / QualityAttribute returns Category:
		//	{QualityAttribute} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{QualityAttribute} name=ID
		public Group getGroup() { return cGroup; }

		//{QualityAttribute}
		public Action getQualityAttributeAction_0() { return cQualityAttributeAction_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class DevelopmentPhaseElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DevelopmentPhase");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cDevelopmentPhaseAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * phase category indicates a development phase 
		// * / DevelopmentPhase returns Category:
		//	{DevelopmentPhase} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{DevelopmentPhase} name=ID
		public Group getGroup() { return cGroup; }

		//{DevelopmentPhase}
		public Action getDevelopmentPhaseAction_0() { return cDevelopmentPhaseAction_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class CategoryFilterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CategoryFilter");
		private final UnorderedGroup cUnorderedGroup = (UnorderedGroup)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cUnorderedGroup.eContents().get(0);
		private final Assignment cNameAssignment_0_0 = (Assignment)cGroup_0.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0_0 = (RuleCall)cNameAssignment_0_0.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_0_1 = (Keyword)cGroup_0.eContents().get(1);
		private final Group cGroup_0_2 = (Group)cGroup_0.eContents().get(2);
		private final Keyword cRequirementKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Keyword cTypeKeyword_0_2_1 = (Keyword)cGroup_0_2.eContents().get(1);
		private final Assignment cRequirementTypeAssignment_0_2_2 = (Assignment)cGroup_0_2.eContents().get(2);
		private final CrossReference cRequirementTypeRequirementTypeCrossReference_0_2_2_0 = (CrossReference)cRequirementTypeAssignment_0_2_2.eContents().get(0);
		private final RuleCall cRequirementTypeRequirementTypeIDTerminalRuleCall_0_2_2_0_1 = (RuleCall)cRequirementTypeRequirementTypeCrossReference_0_2_2_0.eContents().get(1);
		private final Assignment cAnyRequirementTypeAssignment_0_2_3 = (Assignment)cGroup_0_2.eContents().get(3);
		private final Keyword cAnyRequirementTypeAnyKeyword_0_2_3_0 = (Keyword)cAnyRequirementTypeAssignment_0_2_3.eContents().get(0);
		private final Group cGroup_1 = (Group)cUnorderedGroup.eContents().get(1);
		private final Keyword cMethodKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Keyword cTypeKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cMethodTypeAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final CrossReference cMethodTypeMethodTypeCrossReference_1_2_0 = (CrossReference)cMethodTypeAssignment_1_2.eContents().get(0);
		private final RuleCall cMethodTypeMethodTypeIDTerminalRuleCall_1_2_0_1 = (RuleCall)cMethodTypeMethodTypeCrossReference_1_2_0.eContents().get(1);
		private final Assignment cAnyMethodTypeAssignment_1_3 = (Assignment)cGroup_1.eContents().get(3);
		private final Keyword cAnyMethodTypeAnyKeyword_1_3_0 = (Keyword)cAnyMethodTypeAssignment_1_3.eContents().get(0);
		private final Group cGroup_2 = (Group)cUnorderedGroup.eContents().get(2);
		private final Keyword cUserKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Keyword cSelectionKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Assignment cUserSelectionAssignment_2_2 = (Assignment)cGroup_2.eContents().get(2);
		private final CrossReference cUserSelectionUserSelectionCrossReference_2_2_0 = (CrossReference)cUserSelectionAssignment_2_2.eContents().get(0);
		private final RuleCall cUserSelectionUserSelectionIDTerminalRuleCall_2_2_0_1 = (RuleCall)cUserSelectionUserSelectionCrossReference_2_2_0.eContents().get(1);
		private final Assignment cAnyUserSelectionAssignment_2_3 = (Assignment)cGroup_2.eContents().get(3);
		private final Keyword cAnyUserSelectionAnyKeyword_2_3_0 = (Keyword)cAnyUserSelectionAssignment_2_3.eContents().get(0);
		private final Group cGroup_3 = (Group)cUnorderedGroup.eContents().get(3);
		private final Keyword cQualityKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cAttributeKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Assignment cQualityAttributeAssignment_3_2 = (Assignment)cGroup_3.eContents().get(2);
		private final CrossReference cQualityAttributeQualityAttributeCrossReference_3_2_0 = (CrossReference)cQualityAttributeAssignment_3_2.eContents().get(0);
		private final RuleCall cQualityAttributeQualityAttributeIDTerminalRuleCall_3_2_0_1 = (RuleCall)cQualityAttributeQualityAttributeCrossReference_3_2_0.eContents().get(1);
		private final Assignment cAnyQualityAttributeAssignment_3_3 = (Assignment)cGroup_3.eContents().get(3);
		private final Keyword cAnyQualityAttributeAnyKeyword_3_3_0 = (Keyword)cAnyQualityAttributeAssignment_3_3.eContents().get(0);
		private final Group cGroup_4 = (Group)cUnorderedGroup.eContents().get(4);
		private final Group cGroup_4_0 = (Group)cGroup_4.eContents().get(0);
		private final Keyword cDevelopmentKeyword_4_0_0 = (Keyword)cGroup_4_0.eContents().get(0);
		private final Keyword cPhaseKeyword_4_0_1 = (Keyword)cGroup_4_0.eContents().get(1);
		private final Assignment cDevelopmentPhaseAssignment_4_0_2 = (Assignment)cGroup_4_0.eContents().get(2);
		private final CrossReference cDevelopmentPhaseDevelopmentPhaseCrossReference_4_0_2_0 = (CrossReference)cDevelopmentPhaseAssignment_4_0_2.eContents().get(0);
		private final RuleCall cDevelopmentPhaseDevelopmentPhaseIDTerminalRuleCall_4_0_2_0_1 = (RuleCall)cDevelopmentPhaseDevelopmentPhaseCrossReference_4_0_2_0.eContents().get(1);
		private final Assignment cAnyDevelopmentPhaseAssignment_4_0_3 = (Assignment)cGroup_4_0.eContents().get(3);
		private final Keyword cAnyDevelopmentPhaseAnyKeyword_4_0_3_0 = (Keyword)cAnyDevelopmentPhaseAssignment_4_0_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4_1 = (Keyword)cGroup_4.eContents().get(1);
		
		////
		////CategoryFilters returns CategoryFilters:
		////	'filters' 
		////	filters+=NamedCategoryFilter+ 
		////;
		////
		//CategoryFilter:
		//	name=ID "[" ("requirement" "type" requirementType+=[RequirementType]+ anyRequirementType?="any"?)? & ("method" "type"
		//	methodType+=[MethodType]+ anyMethodType?="any"?)? & ("user" "selection" userSelection+=[UserSelection]+
		//	anyUserSelection?="any"?)? & ("quality" "attribute" qualityAttribute+=[QualityAttribute]+
		//	anyQualityAttribute?="any"?)? & ("development" "phase" developmentPhase+=[DevelopmentPhase]+
		//	anyDevelopmentPhase?="any"?)? "]";
		@Override public ParserRule getRule() { return rule; }

		//name=ID "[" ("requirement" "type" requirementType+=[RequirementType]+ anyRequirementType?="any"?)? & ("method" "type"
		//methodType+=[MethodType]+ anyMethodType?="any"?)? & ("user" "selection" userSelection+=[UserSelection]+
		//anyUserSelection?="any"?)? & ("quality" "attribute" qualityAttribute+=[QualityAttribute]+
		//anyQualityAttribute?="any"?)? & ("development" "phase" developmentPhase+=[DevelopmentPhase]+
		//anyDevelopmentPhase?="any"?)? "]"
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//name=ID "[" ("requirement" "type" requirementType+=[RequirementType]+ anyRequirementType?="any"?)?
		public Group getGroup_0() { return cGroup_0; }

		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0_1() { return cLeftSquareBracketKeyword_0_1; }

		//("requirement" "type" requirementType+=[RequirementType]+ anyRequirementType?="any"?)?
		public Group getGroup_0_2() { return cGroup_0_2; }

		//"requirement"
		public Keyword getRequirementKeyword_0_2_0() { return cRequirementKeyword_0_2_0; }

		//"type"
		public Keyword getTypeKeyword_0_2_1() { return cTypeKeyword_0_2_1; }

		//requirementType+=[RequirementType]+
		public Assignment getRequirementTypeAssignment_0_2_2() { return cRequirementTypeAssignment_0_2_2; }

		//[RequirementType]
		public CrossReference getRequirementTypeRequirementTypeCrossReference_0_2_2_0() { return cRequirementTypeRequirementTypeCrossReference_0_2_2_0; }

		//ID
		public RuleCall getRequirementTypeRequirementTypeIDTerminalRuleCall_0_2_2_0_1() { return cRequirementTypeRequirementTypeIDTerminalRuleCall_0_2_2_0_1; }

		//anyRequirementType?="any"?
		public Assignment getAnyRequirementTypeAssignment_0_2_3() { return cAnyRequirementTypeAssignment_0_2_3; }

		//"any"
		public Keyword getAnyRequirementTypeAnyKeyword_0_2_3_0() { return cAnyRequirementTypeAnyKeyword_0_2_3_0; }

		//("method" "type" methodType+=[MethodType]+ anyMethodType?="any"?)?
		public Group getGroup_1() { return cGroup_1; }

		//"method"
		public Keyword getMethodKeyword_1_0() { return cMethodKeyword_1_0; }

		//"type"
		public Keyword getTypeKeyword_1_1() { return cTypeKeyword_1_1; }

		//methodType+=[MethodType]+
		public Assignment getMethodTypeAssignment_1_2() { return cMethodTypeAssignment_1_2; }

		//[MethodType]
		public CrossReference getMethodTypeMethodTypeCrossReference_1_2_0() { return cMethodTypeMethodTypeCrossReference_1_2_0; }

		//ID
		public RuleCall getMethodTypeMethodTypeIDTerminalRuleCall_1_2_0_1() { return cMethodTypeMethodTypeIDTerminalRuleCall_1_2_0_1; }

		//anyMethodType?="any"?
		public Assignment getAnyMethodTypeAssignment_1_3() { return cAnyMethodTypeAssignment_1_3; }

		//"any"
		public Keyword getAnyMethodTypeAnyKeyword_1_3_0() { return cAnyMethodTypeAnyKeyword_1_3_0; }

		//("user" "selection" userSelection+=[UserSelection]+ anyUserSelection?="any"?)?
		public Group getGroup_2() { return cGroup_2; }

		//"user"
		public Keyword getUserKeyword_2_0() { return cUserKeyword_2_0; }

		//"selection"
		public Keyword getSelectionKeyword_2_1() { return cSelectionKeyword_2_1; }

		//userSelection+=[UserSelection]+
		public Assignment getUserSelectionAssignment_2_2() { return cUserSelectionAssignment_2_2; }

		//[UserSelection]
		public CrossReference getUserSelectionUserSelectionCrossReference_2_2_0() { return cUserSelectionUserSelectionCrossReference_2_2_0; }

		//ID
		public RuleCall getUserSelectionUserSelectionIDTerminalRuleCall_2_2_0_1() { return cUserSelectionUserSelectionIDTerminalRuleCall_2_2_0_1; }

		//anyUserSelection?="any"?
		public Assignment getAnyUserSelectionAssignment_2_3() { return cAnyUserSelectionAssignment_2_3; }

		//"any"
		public Keyword getAnyUserSelectionAnyKeyword_2_3_0() { return cAnyUserSelectionAnyKeyword_2_3_0; }

		//("quality" "attribute" qualityAttribute+=[QualityAttribute]+ anyQualityAttribute?="any"?)?
		public Group getGroup_3() { return cGroup_3; }

		//"quality"
		public Keyword getQualityKeyword_3_0() { return cQualityKeyword_3_0; }

		//"attribute"
		public Keyword getAttributeKeyword_3_1() { return cAttributeKeyword_3_1; }

		//qualityAttribute+=[QualityAttribute]+
		public Assignment getQualityAttributeAssignment_3_2() { return cQualityAttributeAssignment_3_2; }

		//[QualityAttribute]
		public CrossReference getQualityAttributeQualityAttributeCrossReference_3_2_0() { return cQualityAttributeQualityAttributeCrossReference_3_2_0; }

		//ID
		public RuleCall getQualityAttributeQualityAttributeIDTerminalRuleCall_3_2_0_1() { return cQualityAttributeQualityAttributeIDTerminalRuleCall_3_2_0_1; }

		//anyQualityAttribute?="any"?
		public Assignment getAnyQualityAttributeAssignment_3_3() { return cAnyQualityAttributeAssignment_3_3; }

		//"any"
		public Keyword getAnyQualityAttributeAnyKeyword_3_3_0() { return cAnyQualityAttributeAnyKeyword_3_3_0; }

		//("development" "phase" developmentPhase+=[DevelopmentPhase]+ anyDevelopmentPhase?="any"?)? "]"
		public Group getGroup_4() { return cGroup_4; }

		//("development" "phase" developmentPhase+=[DevelopmentPhase]+ anyDevelopmentPhase?="any"?)?
		public Group getGroup_4_0() { return cGroup_4_0; }

		//"development"
		public Keyword getDevelopmentKeyword_4_0_0() { return cDevelopmentKeyword_4_0_0; }

		//"phase"
		public Keyword getPhaseKeyword_4_0_1() { return cPhaseKeyword_4_0_1; }

		//developmentPhase+=[DevelopmentPhase]+
		public Assignment getDevelopmentPhaseAssignment_4_0_2() { return cDevelopmentPhaseAssignment_4_0_2; }

		//[DevelopmentPhase]
		public CrossReference getDevelopmentPhaseDevelopmentPhaseCrossReference_4_0_2_0() { return cDevelopmentPhaseDevelopmentPhaseCrossReference_4_0_2_0; }

		//ID
		public RuleCall getDevelopmentPhaseDevelopmentPhaseIDTerminalRuleCall_4_0_2_0_1() { return cDevelopmentPhaseDevelopmentPhaseIDTerminalRuleCall_4_0_2_0_1; }

		//anyDevelopmentPhase?="any"?
		public Assignment getAnyDevelopmentPhaseAssignment_4_0_3() { return cAnyDevelopmentPhaseAssignment_4_0_3; }

		//"any"
		public Keyword getAnyDevelopmentPhaseAnyKeyword_4_0_3_0() { return cAnyDevelopmentPhaseAnyKeyword_4_0_3_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4_1() { return cRightSquareBracketKeyword_4_1; }
	}

	public class CatRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CatRef");
		private final RuleCall cIDTerminalRuleCall = (RuleCall)rule.eContents().get(1);
		
		//// Category reference. Currently it is only a single ID
		//CatRef: //('.' ID)?
		//	ID;
		@Override public ParserRule getRule() { return rule; }

		////('.' ID)?
		//ID
		public RuleCall getIDTerminalRuleCall() { return cIDTerminalRuleCall; }
	}
	
	
	private final CategoriesDefinitionsElements pCategoriesDefinitions;
	private final RequirementTypeCategoriesElements pRequirementTypeCategories;
	private final MethodTypeCategoriesElements pMethodTypeCategories;
	private final UserSelectionCategoriesElements pUserSelectionCategories;
	private final QualityAttributeCategoriesElements pQualityAttributeCategories;
	private final DevelopmentPhaseCategoriesElements pDevelopmentPhaseCategories;
	private final RequirementTypeElements pRequirementType;
	private final MethodTypeElements pMethodType;
	private final UserSelectionElements pUserSelection;
	private final QualityAttributeElements pQualityAttribute;
	private final DevelopmentPhaseElements pDevelopmentPhase;
	private final CategoryFilterElements pCategoryFilter;
	private final CatRefElements pCatRef;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public CategoriesGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pCategoriesDefinitions = new CategoriesDefinitionsElements();
		this.pRequirementTypeCategories = new RequirementTypeCategoriesElements();
		this.pMethodTypeCategories = new MethodTypeCategoriesElements();
		this.pUserSelectionCategories = new UserSelectionCategoriesElements();
		this.pQualityAttributeCategories = new QualityAttributeCategoriesElements();
		this.pDevelopmentPhaseCategories = new DevelopmentPhaseCategoriesElements();
		this.pRequirementType = new RequirementTypeElements();
		this.pMethodType = new MethodTypeElements();
		this.pUserSelection = new UserSelectionElements();
		this.pQualityAttribute = new QualityAttributeElements();
		this.pDevelopmentPhase = new DevelopmentPhaseElements();
		this.pCategoryFilter = new CategoryFilterElements();
		this.pCatRef = new CatRefElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.osate.categories.Categories".equals(grammar.getName())) {
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

	
	//CategoriesDefinitions:
	//	requirementTypeCategories=RequirementTypeCategories? & methodTypeCategories=MethodTypeCategories? &
	//	selectioncategories=UserSelectionCategories? & developmentPhaseCategories=DevelopmentPhaseCategories? & //&  categoryFilters=CategoryFilters?
	//	qualityAttributeCategories=QualityAttributeCategories?;
	public CategoriesDefinitionsElements getCategoriesDefinitionsAccess() {
		return pCategoriesDefinitions;
	}
	
	public ParserRule getCategoriesDefinitionsRule() {
		return getCategoriesDefinitionsAccess().getRule();
	}

	//RequirementTypeCategories returns Categories:
	//	{RequirementTypeCategories} "requirement" "type" "[" category+=RequirementType+ "]";
	public RequirementTypeCategoriesElements getRequirementTypeCategoriesAccess() {
		return pRequirementTypeCategories;
	}
	
	public ParserRule getRequirementTypeCategoriesRule() {
		return getRequirementTypeCategoriesAccess().getRule();
	}

	//MethodTypeCategories returns Categories:
	//	{MethodTypeCategories} "method" "type" "[" category+=MethodType+ "]";
	public MethodTypeCategoriesElements getMethodTypeCategoriesAccess() {
		return pMethodTypeCategories;
	}
	
	public ParserRule getMethodTypeCategoriesRule() {
		return getMethodTypeCategoriesAccess().getRule();
	}

	//UserSelectionCategories returns Categories:
	//	{UserSelectionCategories} "user" "selection" "[" category+=UserSelection+ "]";
	public UserSelectionCategoriesElements getUserSelectionCategoriesAccess() {
		return pUserSelectionCategories;
	}
	
	public ParserRule getUserSelectionCategoriesRule() {
		return getUserSelectionCategoriesAccess().getRule();
	}

	//QualityAttributeCategories returns Categories:
	//	{QualityAttributeCategories} "quality" "attribute" "[" category+=QualityAttribute+ "]";
	public QualityAttributeCategoriesElements getQualityAttributeCategoriesAccess() {
		return pQualityAttributeCategories;
	}
	
	public ParserRule getQualityAttributeCategoriesRule() {
		return getQualityAttributeCategoriesAccess().getRule();
	}

	//DevelopmentPhaseCategories returns Categories:
	//	{DevelopmentPhaseCategories} "development" "phase" "[" category+=DevelopmentPhase+ "]";
	public DevelopmentPhaseCategoriesElements getDevelopmentPhaseCategoriesAccess() {
		return pDevelopmentPhaseCategories;
	}
	
	public ParserRule getDevelopmentPhaseCategoriesRule() {
		return getDevelopmentPhaseCategoriesAccess().getRule();
	}

	/// **
	// * Requirement category indicates the type of requirement
	// * / RequirementType returns Category:
	//	{RequirementType} name=ID;
	public RequirementTypeElements getRequirementTypeAccess() {
		return pRequirementType;
	}
	
	public ParserRule getRequirementTypeRule() {
		return getRequirementTypeAccess().getRule();
	}

	/// **
	// * Method type indicates the type of verification method
	// * / MethodType returns Category:
	//	{MethodType} name=ID;
	public MethodTypeElements getMethodTypeAccess() {
		return pMethodType;
	}
	
	public ParserRule getMethodTypeRule() {
		return getMethodTypeAccess().getRule();
	}

	/// **
	// * user selection  indicates a user defined selection categories  
	// * / UserSelection returns Category:
	//	{UserSelection} name=ID;
	public UserSelectionElements getUserSelectionAccess() {
		return pUserSelection;
	}
	
	public ParserRule getUserSelectionRule() {
		return getUserSelectionAccess().getRule();
	}

	/// **
	// * quality attribute indicates a quality attribute 
	// * / QualityAttribute returns Category:
	//	{QualityAttribute} name=ID;
	public QualityAttributeElements getQualityAttributeAccess() {
		return pQualityAttribute;
	}
	
	public ParserRule getQualityAttributeRule() {
		return getQualityAttributeAccess().getRule();
	}

	/// **
	// * phase category indicates a development phase 
	// * / DevelopmentPhase returns Category:
	//	{DevelopmentPhase} name=ID;
	public DevelopmentPhaseElements getDevelopmentPhaseAccess() {
		return pDevelopmentPhase;
	}
	
	public ParserRule getDevelopmentPhaseRule() {
		return getDevelopmentPhaseAccess().getRule();
	}

	////
	////CategoryFilters returns CategoryFilters:
	////	'filters' 
	////	filters+=NamedCategoryFilter+ 
	////;
	////
	//CategoryFilter:
	//	name=ID "[" ("requirement" "type" requirementType+=[RequirementType]+ anyRequirementType?="any"?)? & ("method" "type"
	//	methodType+=[MethodType]+ anyMethodType?="any"?)? & ("user" "selection" userSelection+=[UserSelection]+
	//	anyUserSelection?="any"?)? & ("quality" "attribute" qualityAttribute+=[QualityAttribute]+
	//	anyQualityAttribute?="any"?)? & ("development" "phase" developmentPhase+=[DevelopmentPhase]+
	//	anyDevelopmentPhase?="any"?)? "]";
	public CategoryFilterElements getCategoryFilterAccess() {
		return pCategoryFilter;
	}
	
	public ParserRule getCategoryFilterRule() {
		return getCategoryFilterAccess().getRule();
	}

	//// Category reference. Currently it is only a single ID
	//CatRef: //('.' ID)?
	//	ID;
	public CatRefElements getCatRefAccess() {
		return pCatRef;
	}
	
	public ParserRule getCatRefRule() {
		return getCatRefAccess().getRule();
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
