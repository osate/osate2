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
		private final Assignment cUserCategoriesAssignment_0 = (Assignment)cUnorderedGroup.eContents().get(0);
		private final RuleCall cUserCategoriesUserCategoriesParserRuleCall_0_0 = (RuleCall)cUserCategoriesAssignment_0.eContents().get(0);
		private final Assignment cPhaseCategoriesAssignment_1 = (Assignment)cUnorderedGroup.eContents().get(1);
		private final RuleCall cPhaseCategoriesPhaseCategoriesParserRuleCall_1_0 = (RuleCall)cPhaseCategoriesAssignment_1.eContents().get(0);
		private final Assignment cQualityCategoriesAssignment_2 = (Assignment)cUnorderedGroup.eContents().get(2);
		private final RuleCall cQualityCategoriesQualityCategoriesParserRuleCall_2_0 = (RuleCall)cQualityCategoriesAssignment_2.eContents().get(0);
		
		//CategoriesDefinitions:
		//	userCategories=UserCategories? & phaseCategories=PhaseCategories? & //&  categoryFilters=CategoryFilters?
		//	qualityCategories=QualityCategories?;
		@Override public ParserRule getRule() { return rule; }

		//userCategories=UserCategories? & phaseCategories=PhaseCategories? & //&  categoryFilters=CategoryFilters?
		//qualityCategories=QualityCategories?
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//userCategories=UserCategories?
		public Assignment getUserCategoriesAssignment_0() { return cUserCategoriesAssignment_0; }

		//UserCategories
		public RuleCall getUserCategoriesUserCategoriesParserRuleCall_0_0() { return cUserCategoriesUserCategoriesParserRuleCall_0_0; }

		//phaseCategories=PhaseCategories?
		public Assignment getPhaseCategoriesAssignment_1() { return cPhaseCategoriesAssignment_1; }

		//PhaseCategories
		public RuleCall getPhaseCategoriesPhaseCategoriesParserRuleCall_1_0() { return cPhaseCategoriesPhaseCategoriesParserRuleCall_1_0; }

		////&  categoryFilters=CategoryFilters?
		//qualityCategories=QualityCategories?
		public Assignment getQualityCategoriesAssignment_2() { return cQualityCategoriesAssignment_2; }

		//QualityCategories
		public RuleCall getQualityCategoriesQualityCategoriesParserRuleCall_2_0() { return cQualityCategoriesQualityCategoriesParserRuleCall_2_0; }
	}

	public class UserCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UserCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUserCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cCategoryKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cCategoryAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cCategoryUserCategoryParserRuleCall_3_0 = (RuleCall)cCategoryAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//UserCategories returns Categories:
		//	{UserCategories} "category" "[" category+=UserCategory+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{UserCategories} "category" "[" category+=UserCategory+ "]"
		public Group getGroup() { return cGroup; }

		//{UserCategories}
		public Action getUserCategoriesAction_0() { return cUserCategoriesAction_0; }

		//"category"
		public Keyword getCategoryKeyword_1() { return cCategoryKeyword_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//category+=UserCategory+
		public Assignment getCategoryAssignment_3() { return cCategoryAssignment_3; }

		//UserCategory
		public RuleCall getCategoryUserCategoryParserRuleCall_3_0() { return cCategoryUserCategoryParserRuleCall_3_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class QualityCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualityCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cQualityCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cQualityKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cCategoryAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cCategoryQualityCategoryParserRuleCall_3_0 = (RuleCall)cCategoryAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//QualityCategories returns Categories:
		//	{QualityCategories} "quality" "[" category+=QualityCategory+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{QualityCategories} "quality" "[" category+=QualityCategory+ "]"
		public Group getGroup() { return cGroup; }

		//{QualityCategories}
		public Action getQualityCategoriesAction_0() { return cQualityCategoriesAction_0; }

		//"quality"
		public Keyword getQualityKeyword_1() { return cQualityKeyword_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//category+=QualityCategory+
		public Assignment getCategoryAssignment_3() { return cCategoryAssignment_3; }

		//QualityCategory
		public RuleCall getCategoryQualityCategoryParserRuleCall_3_0() { return cCategoryQualityCategoryParserRuleCall_3_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class PhaseCategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PhaseCategories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPhaseCategoriesAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cPhaseKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cCategoryAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cCategoryPhaseCategoryParserRuleCall_3_0 = (RuleCall)cCategoryAssignment_3.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//PhaseCategories returns Categories:
		//	{PhaseCategories} "phase" "[" category+=PhaseCategory+ "]";
		@Override public ParserRule getRule() { return rule; }

		//{PhaseCategories} "phase" "[" category+=PhaseCategory+ "]"
		public Group getGroup() { return cGroup; }

		//{PhaseCategories}
		public Action getPhaseCategoriesAction_0() { return cPhaseCategoriesAction_0; }

		//"phase"
		public Keyword getPhaseKeyword_1() { return cPhaseKeyword_1; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//category+=PhaseCategory+
		public Assignment getCategoryAssignment_3() { return cCategoryAssignment_3; }

		//PhaseCategory
		public RuleCall getCategoryPhaseCategoryParserRuleCall_3_0() { return cCategoryPhaseCategoryParserRuleCall_3_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }
	}

	public class UserCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UserCategory");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cUserCategoryAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * user selection  indicates a user defined selection categories  
		// * / UserCategory returns Category:
		//	{UserCategory} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{UserCategory} name=ID
		public Group getGroup() { return cGroup; }

		//{UserCategory}
		public Action getUserCategoryAction_0() { return cUserCategoryAction_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class QualityCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualityCategory");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cQualityCategoryAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * quality attribute indicates a quality attribute 
		// * / QualityCategory returns Category:
		//	{QualityCategory} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{QualityCategory} name=ID
		public Group getGroup() { return cGroup; }

		//{QualityCategory}
		public Action getQualityCategoryAction_0() { return cQualityCategoryAction_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
	}

	public class PhaseCategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PhaseCategory");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cPhaseCategoryAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		/// **
		// * phase category indicates a development phase 
		// * / PhaseCategory returns Category:
		//	{PhaseCategory} name=ID;
		@Override public ParserRule getRule() { return rule; }

		//{PhaseCategory} name=ID
		public Group getGroup() { return cGroup; }

		//{PhaseCategory}
		public Action getPhaseCategoryAction_0() { return cPhaseCategoryAction_0; }

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
		private final Keyword cCategoryKeyword_0_2_0 = (Keyword)cGroup_0_2.eContents().get(0);
		private final Assignment cUserCategoryAssignment_0_2_1 = (Assignment)cGroup_0_2.eContents().get(1);
		private final CrossReference cUserCategoryUserCategoryCrossReference_0_2_1_0 = (CrossReference)cUserCategoryAssignment_0_2_1.eContents().get(0);
		private final RuleCall cUserCategoryUserCategoryIDTerminalRuleCall_0_2_1_0_1 = (RuleCall)cUserCategoryUserCategoryCrossReference_0_2_1_0.eContents().get(1);
		private final Assignment cAnyUserSelectionAssignment_0_2_2 = (Assignment)cGroup_0_2.eContents().get(2);
		private final Keyword cAnyUserSelectionAnyKeyword_0_2_2_0 = (Keyword)cAnyUserSelectionAssignment_0_2_2.eContents().get(0);
		private final Group cGroup_1 = (Group)cUnorderedGroup.eContents().get(1);
		private final Keyword cQualityKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cQualityCategoryAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final CrossReference cQualityCategoryQualityCategoryCrossReference_1_1_0 = (CrossReference)cQualityCategoryAssignment_1_1.eContents().get(0);
		private final RuleCall cQualityCategoryQualityCategoryIDTerminalRuleCall_1_1_0_1 = (RuleCall)cQualityCategoryQualityCategoryCrossReference_1_1_0.eContents().get(1);
		private final Assignment cAnyQualityAttributeAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final Keyword cAnyQualityAttributeAnyKeyword_1_2_0 = (Keyword)cAnyQualityAttributeAssignment_1_2.eContents().get(0);
		private final Group cGroup_2 = (Group)cUnorderedGroup.eContents().get(2);
		private final Group cGroup_2_0 = (Group)cGroup_2.eContents().get(0);
		private final Keyword cPhaseKeyword_2_0_0 = (Keyword)cGroup_2_0.eContents().get(0);
		private final Assignment cPhaseCategoryAssignment_2_0_1 = (Assignment)cGroup_2_0.eContents().get(1);
		private final CrossReference cPhaseCategoryPhaseCategoryCrossReference_2_0_1_0 = (CrossReference)cPhaseCategoryAssignment_2_0_1.eContents().get(0);
		private final RuleCall cPhaseCategoryPhaseCategoryIDTerminalRuleCall_2_0_1_0_1 = (RuleCall)cPhaseCategoryPhaseCategoryCrossReference_2_0_1_0.eContents().get(1);
		private final Assignment cAnyDevelopmentPhaseAssignment_2_0_2 = (Assignment)cGroup_2_0.eContents().get(2);
		private final Keyword cAnyDevelopmentPhaseAnyKeyword_2_0_2_0 = (Keyword)cAnyDevelopmentPhaseAssignment_2_0_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		
		////
		////CategoryFilters returns CategoryFilters:
		////	'filters' 
		////	filters+=NamedCategoryFilter+ 
		////;
		////
		//CategoryFilter:
		//	name=ID "[" ("category" userCategory+=[UserCategory]+ anyUserSelection?="any"?)? & ("quality"
		//	qualityCategory+=[QualityCategory]+ anyQualityAttribute?="any"?)? & ("phase" phaseCategory+=[PhaseCategory]+
		//	anyDevelopmentPhase?="any"?)? "]";
		@Override public ParserRule getRule() { return rule; }

		//name=ID "[" ("category" userCategory+=[UserCategory]+ anyUserSelection?="any"?)? & ("quality"
		//qualityCategory+=[QualityCategory]+ anyQualityAttribute?="any"?)? & ("phase" phaseCategory+=[PhaseCategory]+
		//anyDevelopmentPhase?="any"?)? "]"
		public UnorderedGroup getUnorderedGroup() { return cUnorderedGroup; }

		//name=ID "[" ("category" userCategory+=[UserCategory]+ anyUserSelection?="any"?)?
		public Group getGroup_0() { return cGroup_0; }

		//name=ID
		public Assignment getNameAssignment_0_0() { return cNameAssignment_0_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0_0() { return cNameIDTerminalRuleCall_0_0_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0_1() { return cLeftSquareBracketKeyword_0_1; }

		//("category" userCategory+=[UserCategory]+ anyUserSelection?="any"?)?
		public Group getGroup_0_2() { return cGroup_0_2; }

		//"category"
		public Keyword getCategoryKeyword_0_2_0() { return cCategoryKeyword_0_2_0; }

		//userCategory+=[UserCategory]+
		public Assignment getUserCategoryAssignment_0_2_1() { return cUserCategoryAssignment_0_2_1; }

		//[UserCategory]
		public CrossReference getUserCategoryUserCategoryCrossReference_0_2_1_0() { return cUserCategoryUserCategoryCrossReference_0_2_1_0; }

		//ID
		public RuleCall getUserCategoryUserCategoryIDTerminalRuleCall_0_2_1_0_1() { return cUserCategoryUserCategoryIDTerminalRuleCall_0_2_1_0_1; }

		//anyUserSelection?="any"?
		public Assignment getAnyUserSelectionAssignment_0_2_2() { return cAnyUserSelectionAssignment_0_2_2; }

		//"any"
		public Keyword getAnyUserSelectionAnyKeyword_0_2_2_0() { return cAnyUserSelectionAnyKeyword_0_2_2_0; }

		//("quality" qualityCategory+=[QualityCategory]+ anyQualityAttribute?="any"?)?
		public Group getGroup_1() { return cGroup_1; }

		//"quality"
		public Keyword getQualityKeyword_1_0() { return cQualityKeyword_1_0; }

		//qualityCategory+=[QualityCategory]+
		public Assignment getQualityCategoryAssignment_1_1() { return cQualityCategoryAssignment_1_1; }

		//[QualityCategory]
		public CrossReference getQualityCategoryQualityCategoryCrossReference_1_1_0() { return cQualityCategoryQualityCategoryCrossReference_1_1_0; }

		//ID
		public RuleCall getQualityCategoryQualityCategoryIDTerminalRuleCall_1_1_0_1() { return cQualityCategoryQualityCategoryIDTerminalRuleCall_1_1_0_1; }

		//anyQualityAttribute?="any"?
		public Assignment getAnyQualityAttributeAssignment_1_2() { return cAnyQualityAttributeAssignment_1_2; }

		//"any"
		public Keyword getAnyQualityAttributeAnyKeyword_1_2_0() { return cAnyQualityAttributeAnyKeyword_1_2_0; }

		//("phase" phaseCategory+=[PhaseCategory]+ anyDevelopmentPhase?="any"?)? "]"
		public Group getGroup_2() { return cGroup_2; }

		//("phase" phaseCategory+=[PhaseCategory]+ anyDevelopmentPhase?="any"?)?
		public Group getGroup_2_0() { return cGroup_2_0; }

		//"phase"
		public Keyword getPhaseKeyword_2_0_0() { return cPhaseKeyword_2_0_0; }

		//phaseCategory+=[PhaseCategory]+
		public Assignment getPhaseCategoryAssignment_2_0_1() { return cPhaseCategoryAssignment_2_0_1; }

		//[PhaseCategory]
		public CrossReference getPhaseCategoryPhaseCategoryCrossReference_2_0_1_0() { return cPhaseCategoryPhaseCategoryCrossReference_2_0_1_0; }

		//ID
		public RuleCall getPhaseCategoryPhaseCategoryIDTerminalRuleCall_2_0_1_0_1() { return cPhaseCategoryPhaseCategoryIDTerminalRuleCall_2_0_1_0_1; }

		//anyDevelopmentPhase?="any"?
		public Assignment getAnyDevelopmentPhaseAssignment_2_0_2() { return cAnyDevelopmentPhaseAssignment_2_0_2; }

		//"any"
		public Keyword getAnyDevelopmentPhaseAnyKeyword_2_0_2_0() { return cAnyDevelopmentPhaseAnyKeyword_2_0_2_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2_1() { return cRightSquareBracketKeyword_2_1; }
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
	private final UserCategoriesElements pUserCategories;
	private final QualityCategoriesElements pQualityCategories;
	private final PhaseCategoriesElements pPhaseCategories;
	private final UserCategoryElements pUserCategory;
	private final QualityCategoryElements pQualityCategory;
	private final PhaseCategoryElements pPhaseCategory;
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
		this.pUserCategories = new UserCategoriesElements();
		this.pQualityCategories = new QualityCategoriesElements();
		this.pPhaseCategories = new PhaseCategoriesElements();
		this.pUserCategory = new UserCategoryElements();
		this.pQualityCategory = new QualityCategoryElements();
		this.pPhaseCategory = new PhaseCategoryElements();
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
	//	userCategories=UserCategories? & phaseCategories=PhaseCategories? & //&  categoryFilters=CategoryFilters?
	//	qualityCategories=QualityCategories?;
	public CategoriesDefinitionsElements getCategoriesDefinitionsAccess() {
		return pCategoriesDefinitions;
	}
	
	public ParserRule getCategoriesDefinitionsRule() {
		return getCategoriesDefinitionsAccess().getRule();
	}

	//UserCategories returns Categories:
	//	{UserCategories} "category" "[" category+=UserCategory+ "]";
	public UserCategoriesElements getUserCategoriesAccess() {
		return pUserCategories;
	}
	
	public ParserRule getUserCategoriesRule() {
		return getUserCategoriesAccess().getRule();
	}

	//QualityCategories returns Categories:
	//	{QualityCategories} "quality" "[" category+=QualityCategory+ "]";
	public QualityCategoriesElements getQualityCategoriesAccess() {
		return pQualityCategories;
	}
	
	public ParserRule getQualityCategoriesRule() {
		return getQualityCategoriesAccess().getRule();
	}

	//PhaseCategories returns Categories:
	//	{PhaseCategories} "phase" "[" category+=PhaseCategory+ "]";
	public PhaseCategoriesElements getPhaseCategoriesAccess() {
		return pPhaseCategories;
	}
	
	public ParserRule getPhaseCategoriesRule() {
		return getPhaseCategoriesAccess().getRule();
	}

	/// **
	// * user selection  indicates a user defined selection categories  
	// * / UserCategory returns Category:
	//	{UserCategory} name=ID;
	public UserCategoryElements getUserCategoryAccess() {
		return pUserCategory;
	}
	
	public ParserRule getUserCategoryRule() {
		return getUserCategoryAccess().getRule();
	}

	/// **
	// * quality attribute indicates a quality attribute 
	// * / QualityCategory returns Category:
	//	{QualityCategory} name=ID;
	public QualityCategoryElements getQualityCategoryAccess() {
		return pQualityCategory;
	}
	
	public ParserRule getQualityCategoryRule() {
		return getQualityCategoryAccess().getRule();
	}

	/// **
	// * phase category indicates a development phase 
	// * / PhaseCategory returns Category:
	//	{PhaseCategory} name=ID;
	public PhaseCategoryElements getPhaseCategoryAccess() {
		return pPhaseCategory;
	}
	
	public ParserRule getPhaseCategoryRule() {
		return getPhaseCategoryAccess().getRule();
	}

	////
	////CategoryFilters returns CategoryFilters:
	////	'filters' 
	////	filters+=NamedCategoryFilter+ 
	////;
	////
	//CategoryFilter:
	//	name=ID "[" ("category" userCategory+=[UserCategory]+ anyUserSelection?="any"?)? & ("quality"
	//	qualityCategory+=[QualityCategory]+ anyQualityAttribute?="any"?)? & ("phase" phaseCategory+=[PhaseCategory]+
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
