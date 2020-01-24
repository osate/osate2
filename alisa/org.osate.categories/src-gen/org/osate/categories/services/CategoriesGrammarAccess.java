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
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.categories.Categories.CategoriesDefinitions");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cCategoriesAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cCategoriesCategoriesParserRuleCall_0_0 = (RuleCall)cCategoriesAssignment_0.eContents().get(0);
		private final Assignment cCategoryFiltersAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cCategoryFiltersCategoryFilterParserRuleCall_1_0 = (RuleCall)cCategoryFiltersAssignment_1.eContents().get(0);
		
		//CategoriesDefinitions:
		//	categories+=Categories* categoryFilters+=CategoryFilter*;
		@Override public ParserRule getRule() { return rule; }

		//categories+=Categories* categoryFilters+=CategoryFilter*
		public Group getGroup() { return cGroup; }

		//categories+=Categories*
		public Assignment getCategoriesAssignment_0() { return cCategoriesAssignment_0; }

		//Categories
		public RuleCall getCategoriesCategoriesParserRuleCall_0_0() { return cCategoriesCategoriesParserRuleCall_0_0; }

		//categoryFilters+=CategoryFilter*
		public Assignment getCategoryFiltersAssignment_1() { return cCategoryFiltersAssignment_1; }

		//CategoryFilter
		public RuleCall getCategoryFiltersCategoryFilterParserRuleCall_1_0() { return cCategoryFiltersCategoryFilterParserRuleCall_1_0; }
	}

	public class CategoriesElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.categories.Categories.Categories");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cCategoryAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cCategoryCategoryParserRuleCall_2_0 = (RuleCall)cCategoryAssignment_2.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Categories:
		//	name=ID
		//	'[' category+=Category+
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//name=ID '[' category+=Category+ ']'
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_1() { return cLeftSquareBracketKeyword_1; }

		//category+=Category+
		public Assignment getCategoryAssignment_2() { return cCategoryAssignment_2; }

		//Category
		public RuleCall getCategoryCategoryParserRuleCall_2_0() { return cCategoryCategoryParserRuleCall_2_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_3() { return cRightSquareBracketKeyword_3; }
	}

	public class CategoryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.categories.Categories.Category");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		///**
		// * user selection  indicates a user defined selection categories  
		// */ Category:
		//	name=ID;
		@Override public ParserRule getRule() { return rule; }

		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}

	public class CategoryFilterElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.categories.Categories.CategoryFilter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFilterKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cCategoryAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cCategoryCategoryCrossReference_3_0 = (CrossReference)cCategoryAssignment_3.eContents().get(0);
		private final RuleCall cCategoryCategoryCatRefParserRuleCall_3_0_1 = (RuleCall)cCategoryCategoryCrossReference_3_0.eContents().get(1);
		private final Assignment cAnyCategoryAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final Keyword cAnyCategoryAnyKeyword_4_0 = (Keyword)cAnyCategoryAssignment_4.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		////
		////CategoryFilters returns CategoryFilters:
		////	'filters' 
		////	filters+=NamedCategoryFilter+ 
		////;
		////
		//CategoryFilter:
		//	'filter' name=ID '['
		//	category+=[Category|CatRef]* anyCategory?='any'?
		//	']';
		@Override public ParserRule getRule() { return rule; }

		//'filter' name=ID '[' category+=[Category|CatRef]* anyCategory?='any'? ']'
		public Group getGroup() { return cGroup; }

		//'filter'
		public Keyword getFilterKeyword_0() { return cFilterKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//'['
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//category+=[Category|CatRef]*
		public Assignment getCategoryAssignment_3() { return cCategoryAssignment_3; }

		//[Category|CatRef]
		public CrossReference getCategoryCategoryCrossReference_3_0() { return cCategoryCategoryCrossReference_3_0; }

		//CatRef
		public RuleCall getCategoryCategoryCatRefParserRuleCall_3_0_1() { return cCategoryCategoryCatRefParserRuleCall_3_0_1; }

		//anyCategory?='any'?
		public Assignment getAnyCategoryAssignment_4() { return cAnyCategoryAssignment_4; }

		//'any'
		public Keyword getAnyCategoryAnyKeyword_4_0() { return cAnyCategoryAnyKeyword_4_0; }

		//']'
		public Keyword getRightSquareBracketKeyword_5() { return cRightSquareBracketKeyword_5; }
	}

	public class CatRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.osate.categories.Categories.CatRef");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cFullStopKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_2 = (RuleCall)cGroup.eContents().get(2);
		
		//// Category reference. 
		//CatRef:
		//	ID '.' ID;
		@Override public ParserRule getRule() { return rule; }

		//ID '.' ID
		public Group getGroup() { return cGroup; }

		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }

		//'.'
		public Keyword getFullStopKeyword_1() { return cFullStopKeyword_1; }

		//ID
		public RuleCall getIDTerminalRuleCall_2() { return cIDTerminalRuleCall_2; }
	}
	
	
	private final CategoriesDefinitionsElements pCategoriesDefinitions;
	private final CategoriesElements pCategories;
	private final CategoryElements pCategory;
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
		this.pCategories = new CategoriesElements();
		this.pCategory = new CategoryElements();
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
	//	categories+=Categories* categoryFilters+=CategoryFilter*;
	public CategoriesDefinitionsElements getCategoriesDefinitionsAccess() {
		return pCategoriesDefinitions;
	}
	
	public ParserRule getCategoriesDefinitionsRule() {
		return getCategoriesDefinitionsAccess().getRule();
	}

	//Categories:
	//	name=ID
	//	'[' category+=Category+
	//	']';
	public CategoriesElements getCategoriesAccess() {
		return pCategories;
	}
	
	public ParserRule getCategoriesRule() {
		return getCategoriesAccess().getRule();
	}

	///**
	// * user selection  indicates a user defined selection categories  
	// */ Category:
	//	name=ID;
	public CategoryElements getCategoryAccess() {
		return pCategory;
	}
	
	public ParserRule getCategoryRule() {
		return getCategoryAccess().getRule();
	}

	////
	////CategoryFilters returns CategoryFilters:
	////	'filters' 
	////	filters+=NamedCategoryFilter+ 
	////;
	////
	//CategoryFilter:
	//	'filter' name=ID '['
	//	category+=[Category|CatRef]* anyCategory?='any'?
	//	']';
	public CategoryFilterElements getCategoryFilterAccess() {
		return pCategoryFilter;
	}
	
	public ParserRule getCategoryFilterRule() {
		return getCategoryFilterAccess().getRule();
	}

	//// Category reference. 
	//CatRef:
	//	ID '.' ID;
	public CatRefElements getCatRefAccess() {
		return pCatRef;
	}
	
	public ParserRule getCatRefRule() {
		return getCatRefAccess().getRule();
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
