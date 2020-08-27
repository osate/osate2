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
package org.osate.organization.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.organization.ide.contentassist.antlr.internal.InternalOrganizationParser;
import org.osate.organization.services.OrganizationGrammarAccess;

public class OrganizationParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(OrganizationGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, OrganizationGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getOrganizationAccess().getGroup(), "rule__Organization__Group__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_0(), "rule__Stakeholder__Group_0__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_0_3_0(), "rule__Stakeholder__Group_0_3_0__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_0_3_1(), "rule__Stakeholder__Group_0_3_1__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_0_3_2(), "rule__Stakeholder__Group_0_3_2__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_0_3_3(), "rule__Stakeholder__Group_0_3_3__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_0_3_4(), "rule__Stakeholder__Group_0_3_4__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_0_3_5(), "rule__Stakeholder__Group_0_3_5__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_1(), "rule__Stakeholder__Group_1__0");
			builder.put(grammarAccess.getStakeholderAccess().getGroup_1_0(), "rule__Stakeholder__Group_1_0__0");
			builder.put(grammarAccess.getQIDAccess().getGroup(), "rule__QID__Group__0");
			builder.put(grammarAccess.getQIDAccess().getGroup_1(), "rule__QID__Group_1__0");
			builder.put(grammarAccess.getOrganizationAccess().getNameAssignment_1(), "rule__Organization__NameAssignment_1");
			builder.put(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2(), "rule__Organization__StakeholderAssignment_2");
			builder.put(grammarAccess.getStakeholderAccess().getNameAssignment_0_1(), "rule__Stakeholder__NameAssignment_0_1");
			builder.put(grammarAccess.getStakeholderAccess().getFullnameAssignment_0_3_0_2(), "rule__Stakeholder__FullnameAssignment_0_3_0_2");
			builder.put(grammarAccess.getStakeholderAccess().getTitleAssignment_0_3_1_1(), "rule__Stakeholder__TitleAssignment_0_3_1_1");
			builder.put(grammarAccess.getStakeholderAccess().getDescriptionAssignment_0_3_2_1(), "rule__Stakeholder__DescriptionAssignment_0_3_2_1");
			builder.put(grammarAccess.getStakeholderAccess().getRoleAssignment_0_3_3_1(), "rule__Stakeholder__RoleAssignment_0_3_3_1");
			builder.put(grammarAccess.getStakeholderAccess().getEmailAssignment_0_3_4_1(), "rule__Stakeholder__EmailAssignment_0_3_4_1");
			builder.put(grammarAccess.getStakeholderAccess().getPhoneAssignment_0_3_5_1(), "rule__Stakeholder__PhoneAssignment_0_3_5_1");
			builder.put(grammarAccess.getStakeholderAccess().getSupervisorAssignment_1_0_1(), "rule__Stakeholder__SupervisorAssignment_1_0_1");
			builder.put(grammarAccess.getStakeholderAccess().getUnorderedGroup(), "rule__Stakeholder__UnorderedGroup");
			builder.put(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), "rule__Stakeholder__UnorderedGroup_0_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private OrganizationGrammarAccess grammarAccess;

	@Override
	protected InternalOrganizationParser createParser() {
		InternalOrganizationParser result = new InternalOrganizationParser(null);
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

	public OrganizationGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OrganizationGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
