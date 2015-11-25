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
package org.osate.categories.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.osate.categories.services.CategoriesGrammarAccess;

public class CategoriesParser extends AbstractContentAssistParser {
	
	@Inject
	private CategoriesGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser createParser() {
		org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser result = new org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getUserCategoriesAccess().getGroup(), "rule__UserCategories__Group__0");
					put(grammarAccess.getQualityCategoriesAccess().getGroup(), "rule__QualityCategories__Group__0");
					put(grammarAccess.getPhaseCategoriesAccess().getGroup(), "rule__PhaseCategories__Group__0");
					put(grammarAccess.getUserCategoryAccess().getGroup(), "rule__UserCategory__Group__0");
					put(grammarAccess.getQualityCategoryAccess().getGroup(), "rule__QualityCategory__Group__0");
					put(grammarAccess.getPhaseCategoryAccess().getGroup(), "rule__PhaseCategory__Group__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_0(), "rule__CategoryFilter__Group_0__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_0_2(), "rule__CategoryFilter__Group_0_2__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_1(), "rule__CategoryFilter__Group_1__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_2(), "rule__CategoryFilter__Group_2__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_2_0(), "rule__CategoryFilter__Group_2_0__0");
					put(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesAssignment_0(), "rule__CategoriesDefinitions__UserCategoriesAssignment_0");
					put(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesAssignment_1(), "rule__CategoriesDefinitions__PhaseCategoriesAssignment_1");
					put(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesAssignment_2(), "rule__CategoriesDefinitions__QualityCategoriesAssignment_2");
					put(grammarAccess.getUserCategoriesAccess().getCategoryAssignment_3(), "rule__UserCategories__CategoryAssignment_3");
					put(grammarAccess.getQualityCategoriesAccess().getCategoryAssignment_3(), "rule__QualityCategories__CategoryAssignment_3");
					put(grammarAccess.getPhaseCategoriesAccess().getCategoryAssignment_3(), "rule__PhaseCategories__CategoryAssignment_3");
					put(grammarAccess.getUserCategoryAccess().getNameAssignment_1(), "rule__UserCategory__NameAssignment_1");
					put(grammarAccess.getQualityCategoryAccess().getNameAssignment_1(), "rule__QualityCategory__NameAssignment_1");
					put(grammarAccess.getPhaseCategoryAccess().getNameAssignment_1(), "rule__PhaseCategory__NameAssignment_1");
					put(grammarAccess.getCategoryFilterAccess().getNameAssignment_0_0(), "rule__CategoryFilter__NameAssignment_0_0");
					put(grammarAccess.getCategoryFilterAccess().getUserCategoryAssignment_0_2_1(), "rule__CategoryFilter__UserCategoryAssignment_0_2_1");
					put(grammarAccess.getCategoryFilterAccess().getAnyUserSelectionAssignment_0_2_2(), "rule__CategoryFilter__AnyUserSelectionAssignment_0_2_2");
					put(grammarAccess.getCategoryFilterAccess().getQualityCategoryAssignment_1_1(), "rule__CategoryFilter__QualityCategoryAssignment_1_1");
					put(grammarAccess.getCategoryFilterAccess().getAnyQualityAttributeAssignment_1_2(), "rule__CategoryFilter__AnyQualityAttributeAssignment_1_2");
					put(grammarAccess.getCategoryFilterAccess().getPhaseCategoryAssignment_2_0_1(), "rule__CategoryFilter__PhaseCategoryAssignment_2_0_1");
					put(grammarAccess.getCategoryFilterAccess().getAnyDevelopmentPhaseAssignment_2_0_2(), "rule__CategoryFilter__AnyDevelopmentPhaseAssignment_2_0_2");
					put(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), "rule__CategoriesDefinitions__UnorderedGroup");
					put(grammarAccess.getCategoryFilterAccess().getUnorderedGroup(), "rule__CategoryFilter__UnorderedGroup");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser typedParser = (org.osate.categories.ui.contentassist.antlr.internal.InternalCategoriesParser) parser;
			typedParser.entryRuleCategoriesDefinitions();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public CategoriesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CategoriesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
