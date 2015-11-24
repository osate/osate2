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
					put(grammarAccess.getRequirementTypeCategoriesAccess().getGroup(), "rule__RequirementTypeCategories__Group__0");
					put(grammarAccess.getMethodTypeCategoriesAccess().getGroup(), "rule__MethodTypeCategories__Group__0");
					put(grammarAccess.getUserSelectionCategoriesAccess().getGroup(), "rule__UserSelectionCategories__Group__0");
					put(grammarAccess.getQualityAttributeCategoriesAccess().getGroup(), "rule__QualityAttributeCategories__Group__0");
					put(grammarAccess.getDevelopmentPhaseCategoriesAccess().getGroup(), "rule__DevelopmentPhaseCategories__Group__0");
					put(grammarAccess.getRequirementTypeAccess().getGroup(), "rule__RequirementType__Group__0");
					put(grammarAccess.getMethodTypeAccess().getGroup(), "rule__MethodType__Group__0");
					put(grammarAccess.getUserSelectionAccess().getGroup(), "rule__UserSelection__Group__0");
					put(grammarAccess.getQualityAttributeAccess().getGroup(), "rule__QualityAttribute__Group__0");
					put(grammarAccess.getDevelopmentPhaseAccess().getGroup(), "rule__DevelopmentPhase__Group__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_0(), "rule__CategoryFilter__Group_0__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_0_2(), "rule__CategoryFilter__Group_0_2__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_1(), "rule__CategoryFilter__Group_1__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_2(), "rule__CategoryFilter__Group_2__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_3(), "rule__CategoryFilter__Group_3__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_4(), "rule__CategoryFilter__Group_4__0");
					put(grammarAccess.getCategoryFilterAccess().getGroup_4_0(), "rule__CategoryFilter__Group_4_0__0");
					put(grammarAccess.getCategoriesDefinitionsAccess().getRequirementTypeCategoriesAssignment_0(), "rule__CategoriesDefinitions__RequirementTypeCategoriesAssignment_0");
					put(grammarAccess.getCategoriesDefinitionsAccess().getMethodTypeCategoriesAssignment_1(), "rule__CategoriesDefinitions__MethodTypeCategoriesAssignment_1");
					put(grammarAccess.getCategoriesDefinitionsAccess().getSelectioncategoriesAssignment_2(), "rule__CategoriesDefinitions__SelectioncategoriesAssignment_2");
					put(grammarAccess.getCategoriesDefinitionsAccess().getDevelopmentPhaseCategoriesAssignment_3(), "rule__CategoriesDefinitions__DevelopmentPhaseCategoriesAssignment_3");
					put(grammarAccess.getCategoriesDefinitionsAccess().getQualityAttributeCategoriesAssignment_4(), "rule__CategoriesDefinitions__QualityAttributeCategoriesAssignment_4");
					put(grammarAccess.getRequirementTypeCategoriesAccess().getCategoryAssignment_4(), "rule__RequirementTypeCategories__CategoryAssignment_4");
					put(grammarAccess.getMethodTypeCategoriesAccess().getCategoryAssignment_4(), "rule__MethodTypeCategories__CategoryAssignment_4");
					put(grammarAccess.getUserSelectionCategoriesAccess().getCategoryAssignment_4(), "rule__UserSelectionCategories__CategoryAssignment_4");
					put(grammarAccess.getQualityAttributeCategoriesAccess().getCategoryAssignment_4(), "rule__QualityAttributeCategories__CategoryAssignment_4");
					put(grammarAccess.getDevelopmentPhaseCategoriesAccess().getCategoryAssignment_4(), "rule__DevelopmentPhaseCategories__CategoryAssignment_4");
					put(grammarAccess.getRequirementTypeAccess().getNameAssignment_1(), "rule__RequirementType__NameAssignment_1");
					put(grammarAccess.getMethodTypeAccess().getNameAssignment_1(), "rule__MethodType__NameAssignment_1");
					put(grammarAccess.getUserSelectionAccess().getNameAssignment_1(), "rule__UserSelection__NameAssignment_1");
					put(grammarAccess.getQualityAttributeAccess().getNameAssignment_1(), "rule__QualityAttribute__NameAssignment_1");
					put(grammarAccess.getDevelopmentPhaseAccess().getNameAssignment_1(), "rule__DevelopmentPhase__NameAssignment_1");
					put(grammarAccess.getCategoryFilterAccess().getNameAssignment_0_0(), "rule__CategoryFilter__NameAssignment_0_0");
					put(grammarAccess.getCategoryFilterAccess().getRequirementTypeAssignment_0_2_2(), "rule__CategoryFilter__RequirementTypeAssignment_0_2_2");
					put(grammarAccess.getCategoryFilterAccess().getAnyRequirementTypeAssignment_0_2_3(), "rule__CategoryFilter__AnyRequirementTypeAssignment_0_2_3");
					put(grammarAccess.getCategoryFilterAccess().getMethodTypeAssignment_1_2(), "rule__CategoryFilter__MethodTypeAssignment_1_2");
					put(grammarAccess.getCategoryFilterAccess().getAnyMethodTypeAssignment_1_3(), "rule__CategoryFilter__AnyMethodTypeAssignment_1_3");
					put(grammarAccess.getCategoryFilterAccess().getUserSelectionAssignment_2_2(), "rule__CategoryFilter__UserSelectionAssignment_2_2");
					put(grammarAccess.getCategoryFilterAccess().getAnyUserSelectionAssignment_2_3(), "rule__CategoryFilter__AnyUserSelectionAssignment_2_3");
					put(grammarAccess.getCategoryFilterAccess().getQualityAttributeAssignment_3_2(), "rule__CategoryFilter__QualityAttributeAssignment_3_2");
					put(grammarAccess.getCategoryFilterAccess().getAnyQualityAttributeAssignment_3_3(), "rule__CategoryFilter__AnyQualityAttributeAssignment_3_3");
					put(grammarAccess.getCategoryFilterAccess().getDevelopmentPhaseAssignment_4_0_2(), "rule__CategoryFilter__DevelopmentPhaseAssignment_4_0_2");
					put(grammarAccess.getCategoryFilterAccess().getAnyDevelopmentPhaseAssignment_4_0_3(), "rule__CategoryFilter__AnyDevelopmentPhaseAssignment_4_0_3");
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
