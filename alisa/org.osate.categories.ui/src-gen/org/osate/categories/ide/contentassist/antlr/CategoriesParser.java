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
package org.osate.categories.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.categories.ide.contentassist.antlr.internal.InternalCategoriesParser;
import org.osate.categories.services.CategoriesGrammarAccess;

public class CategoriesParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(CategoriesGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, CategoriesGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getCategoriesDefinitionsAccess().getGroup(), "rule__CategoriesDefinitions__Group__0");
			builder.put(grammarAccess.getCategoriesAccess().getGroup(), "rule__Categories__Group__0");
			builder.put(grammarAccess.getCategoryFilterAccess().getGroup(), "rule__CategoryFilter__Group__0");
			builder.put(grammarAccess.getCatRefAccess().getGroup(), "rule__CatRef__Group__0");
			builder.put(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0(), "rule__CategoriesDefinitions__CategoriesAssignment_0");
			builder.put(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1(), "rule__CategoriesDefinitions__CategoryFiltersAssignment_1");
			builder.put(grammarAccess.getCategoriesAccess().getNameAssignment_0(), "rule__Categories__NameAssignment_0");
			builder.put(grammarAccess.getCategoriesAccess().getCategoryAssignment_2(), "rule__Categories__CategoryAssignment_2");
			builder.put(grammarAccess.getCategoryAccess().getNameAssignment(), "rule__Category__NameAssignment");
			builder.put(grammarAccess.getCategoryFilterAccess().getNameAssignment_1(), "rule__CategoryFilter__NameAssignment_1");
			builder.put(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3(), "rule__CategoryFilter__CategoryAssignment_3");
			builder.put(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4(), "rule__CategoryFilter__AnyCategoryAssignment_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private CategoriesGrammarAccess grammarAccess;

	@Override
	protected InternalCategoriesParser createParser() {
		InternalCategoriesParser result = new InternalCategoriesParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
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
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
