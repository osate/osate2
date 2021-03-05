/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.alisa.workbench.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.alisa.workbench.ide.contentassist.antlr.internal.InternalAlisaParser;
import org.osate.alisa.workbench.services.AlisaGrammarAccess;

public class AlisaParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(AlisaGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, AlisaGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getAssurancePlanAccess().getAlternatives_7_3_2(), "rule__AssurancePlan__Alternatives_7_3_2");
			builder.put(grammarAccess.getAssurancePlanAccess().getAlternatives_7_4_2(), "rule__AssurancePlan__Alternatives_7_4_2");
			builder.put(grammarAccess.getDescriptionElementAccess().getAlternatives(), "rule__DescriptionElement__Alternatives");
			builder.put(grammarAccess.getTypeRefAccess().getAlternatives(), "rule__TypeRef__Alternatives");
			builder.put(grammarAccess.getValDeclarationAccess().getAlternatives_3_1(), "rule__ValDeclaration__Alternatives_3_1");
			builder.put(grammarAccess.getValDeclarationAccess().getAlternatives_3_1_2_1(), "rule__ValDeclaration__Alternatives_3_1_2_1");
			builder.put(grammarAccess.getComputeDeclarationAccess().getAlternatives_4(), "rule__ComputeDeclaration__Alternatives_4");
			builder.put(grammarAccess.getComputeDeclarationAccess().getAlternatives_4_2_1(), "rule__ComputeDeclaration__Alternatives_4_2_1");
			builder.put(grammarAccess.getAModelOrPropertyReferenceAccess().getAlternatives(), "rule__AModelOrPropertyReference__Alternatives");
			builder.put(grammarAccess.getShowValueAccess().getAlternatives_1_0(), "rule__ShowValue__Alternatives_1_0");
			builder.put(grammarAccess.getOpOrAccess().getAlternatives(), "rule__OpOr__Alternatives");
			builder.put(grammarAccess.getOpAndAccess().getAlternatives(), "rule__OpAnd__Alternatives");
			builder.put(grammarAccess.getOpEqualityAccess().getAlternatives(), "rule__OpEquality__Alternatives");
			builder.put(grammarAccess.getOpCompareAccess().getAlternatives(), "rule__OpCompare__Alternatives");
			builder.put(grammarAccess.getOpAddAccess().getAlternatives(), "rule__OpAdd__Alternatives");
			builder.put(grammarAccess.getOpMultiAccess().getAlternatives(), "rule__OpMulti__Alternatives");
			builder.put(grammarAccess.getAUnaryOperationAccess().getAlternatives(), "rule__AUnaryOperation__Alternatives");
			builder.put(grammarAccess.getOpUnaryAccess().getAlternatives(), "rule__OpUnary__Alternatives");
			builder.put(grammarAccess.getAUnitExpressionAccess().getAlternatives_1_1(), "rule__AUnitExpression__Alternatives_1_1");
			builder.put(grammarAccess.getAPrimaryExpressionAccess().getAlternatives(), "rule__APrimaryExpression__Alternatives");
			builder.put(grammarAccess.getALiteralAccess().getAlternatives(), "rule__ALiteral__Alternatives");
			builder.put(grammarAccess.getABooleanLiteralAccess().getAlternatives_1(), "rule__ABooleanLiteral__Alternatives_1");
			builder.put(grammarAccess.getComponentCategoryAccess().getAlternatives(), "rule__ComponentCategory__Alternatives");
			builder.put(grammarAccess.getOperationAccess().getAlternatives(), "rule__Operation__Alternatives");
			builder.put(grammarAccess.getTargetTypeAccess().getAlternatives(), "rule__TargetType__Alternatives");
			builder.put(grammarAccess.getAssuranceCaseAccess().getGroup(), "rule__AssuranceCase__Group__0");
			builder.put(grammarAccess.getAssuranceCaseAccess().getGroup_3(), "rule__AssuranceCase__Group_3__0");
			builder.put(grammarAccess.getAssurancePlanAccess().getGroup(), "rule__AssurancePlan__Group__0");
			builder.put(grammarAccess.getAssurancePlanAccess().getGroup_3(), "rule__AssurancePlan__Group_3__0");
			builder.put(grammarAccess.getAssurancePlanAccess().getGroup_7_1(), "rule__AssurancePlan__Group_7_1__0");
			builder.put(grammarAccess.getAssurancePlanAccess().getGroup_7_2(), "rule__AssurancePlan__Group_7_2__0");
			builder.put(grammarAccess.getAssurancePlanAccess().getGroup_7_3(), "rule__AssurancePlan__Group_7_3__0");
			builder.put(grammarAccess.getAssurancePlanAccess().getGroup_7_4(), "rule__AssurancePlan__Group_7_4__0");
			builder.put(grammarAccess.getAssurancePlanAccess().getGroup_7_5(), "rule__AssurancePlan__Group_7_5__0");
			builder.put(grammarAccess.getAssuranceTaskAccess().getGroup(), "rule__AssuranceTask__Group__0");
			builder.put(grammarAccess.getAssuranceTaskAccess().getGroup_4(), "rule__AssuranceTask__Group_4__0");
			builder.put(grammarAccess.getAssuranceTaskAccess().getGroup_6_1(), "rule__AssuranceTask__Group_6_1__0");
			builder.put(grammarAccess.getAssuranceTaskAccess().getGroup_6_2(), "rule__AssuranceTask__Group_6_2__0");
			builder.put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
			builder.put(grammarAccess.getRationaleAccess().getGroup(), "rule__Rationale__Group__0");
			builder.put(grammarAccess.getUncertaintyAccess().getGroup(), "rule__Uncertainty__Group__0");
			builder.put(grammarAccess.getUncertaintyAccess().getGroup_3_0(), "rule__Uncertainty__Group_3_0__0");
			builder.put(grammarAccess.getUncertaintyAccess().getGroup_3_1(), "rule__Uncertainty__Group_3_1__0");
			builder.put(grammarAccess.getUncertaintyAccess().getGroup_3_2(), "rule__Uncertainty__Group_3_2__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_0(), "rule__TypeRef__Group_0__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_1(), "rule__TypeRef__Group_1__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_1_2(), "rule__TypeRef__Group_1_2__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_2(), "rule__TypeRef__Group_2__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_2_2(), "rule__TypeRef__Group_2_2__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_3(), "rule__TypeRef__Group_3__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_4(), "rule__TypeRef__Group_4__0");
			builder.put(grammarAccess.getTypeRefAccess().getGroup_5(), "rule__TypeRef__Group_5__0");
			builder.put(grammarAccess.getPropertyRefAccess().getGroup(), "rule__PropertyRef__Group__0");
			builder.put(grammarAccess.getValDeclarationAccess().getGroup(), "rule__ValDeclaration__Group__0");
			builder.put(grammarAccess.getValDeclarationAccess().getGroup_3(), "rule__ValDeclaration__Group_3__0");
			builder.put(grammarAccess.getValDeclarationAccess().getGroup_3_1_1(), "rule__ValDeclaration__Group_3_1_1__0");
			builder.put(grammarAccess.getValDeclarationAccess().getGroup_3_1_2(), "rule__ValDeclaration__Group_3_1_2__0");
			builder.put(grammarAccess.getValDeclarationAccess().getGroup_3_1_2_1_1(), "rule__ValDeclaration__Group_3_1_2_1_1__0");
			builder.put(grammarAccess.getComputeDeclarationAccess().getGroup(), "rule__ComputeDeclaration__Group__0");
			builder.put(grammarAccess.getComputeDeclarationAccess().getGroup_4_1(), "rule__ComputeDeclaration__Group_4_1__0");
			builder.put(grammarAccess.getComputeDeclarationAccess().getGroup_4_2(), "rule__ComputeDeclaration__Group_4_2__0");
			builder.put(grammarAccess.getComputeDeclarationAccess().getGroup_4_2_1_1(), "rule__ComputeDeclaration__Group_4_2_1_1__0");
			builder.put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0(), "rule__AModelOrPropertyReference__Group_0__0");
			builder.put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1(), "rule__AModelOrPropertyReference__Group_0_1__0");
			builder.put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0(), "rule__AModelOrPropertyReference__Group_0_1_0__0");
			builder.put(grammarAccess.getAModelOrPropertyReferenceAccess().getGroup_0_1_0_0(), "rule__AModelOrPropertyReference__Group_0_1_0_0__0");
			builder.put(grammarAccess.getAModelReferenceAccess().getGroup(), "rule__AModelReference__Group__0");
			builder.put(grammarAccess.getAModelReferenceAccess().getGroup_1(), "rule__AModelReference__Group_1__0");
			builder.put(grammarAccess.getAPropertyReferenceAccess().getGroup(), "rule__APropertyReference__Group__0");
			builder.put(grammarAccess.getAVariableReferenceAccess().getGroup(), "rule__AVariableReference__Group__0");
			builder.put(grammarAccess.getShowValueAccess().getGroup(), "rule__ShowValue__Group__0");
			builder.put(grammarAccess.getShowValueAccess().getGroup_1(), "rule__ShowValue__Group_1__0");
			builder.put(grammarAccess.getImageReferenceAccess().getGroup(), "rule__ImageReference__Group__0");
			builder.put(grammarAccess.getIMGREFAccess().getGroup(), "rule__IMGREF__Group__0");
			builder.put(grammarAccess.getIMGREFAccess().getGroup_0(), "rule__IMGREF__Group_0__0");
			builder.put(grammarAccess.getAOrExpressionAccess().getGroup(), "rule__AOrExpression__Group__0");
			builder.put(grammarAccess.getAOrExpressionAccess().getGroup_1(), "rule__AOrExpression__Group_1__0");
			builder.put(grammarAccess.getAOrExpressionAccess().getGroup_1_0(), "rule__AOrExpression__Group_1_0__0");
			builder.put(grammarAccess.getAOrExpressionAccess().getGroup_1_0_0(), "rule__AOrExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getAAndExpressionAccess().getGroup(), "rule__AAndExpression__Group__0");
			builder.put(grammarAccess.getAAndExpressionAccess().getGroup_1(), "rule__AAndExpression__Group_1__0");
			builder.put(grammarAccess.getAAndExpressionAccess().getGroup_1_0(), "rule__AAndExpression__Group_1_0__0");
			builder.put(grammarAccess.getAAndExpressionAccess().getGroup_1_0_0(), "rule__AAndExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getAEqualityExpressionAccess().getGroup(), "rule__AEqualityExpression__Group__0");
			builder.put(grammarAccess.getAEqualityExpressionAccess().getGroup_1(), "rule__AEqualityExpression__Group_1__0");
			builder.put(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0(), "rule__AEqualityExpression__Group_1_0__0");
			builder.put(grammarAccess.getAEqualityExpressionAccess().getGroup_1_0_0(), "rule__AEqualityExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getARelationalExpressionAccess().getGroup(), "rule__ARelationalExpression__Group__0");
			builder.put(grammarAccess.getARelationalExpressionAccess().getGroup_1(), "rule__ARelationalExpression__Group_1__0");
			builder.put(grammarAccess.getARelationalExpressionAccess().getGroup_1_0(), "rule__ARelationalExpression__Group_1_0__0");
			builder.put(grammarAccess.getARelationalExpressionAccess().getGroup_1_0_0(), "rule__ARelationalExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getAAdditiveExpressionAccess().getGroup(), "rule__AAdditiveExpression__Group__0");
			builder.put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1(), "rule__AAdditiveExpression__Group_1__0");
			builder.put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0(), "rule__AAdditiveExpression__Group_1_0__0");
			builder.put(grammarAccess.getAAdditiveExpressionAccess().getGroup_1_0_0(), "rule__AAdditiveExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup(), "rule__AMultiplicativeExpression__Group__0");
			builder.put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1(), "rule__AMultiplicativeExpression__Group_1__0");
			builder.put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0(), "rule__AMultiplicativeExpression__Group_1_0__0");
			builder.put(grammarAccess.getAMultiplicativeExpressionAccess().getGroup_1_0_0(), "rule__AMultiplicativeExpression__Group_1_0_0__0");
			builder.put(grammarAccess.getAUnaryOperationAccess().getGroup_0(), "rule__AUnaryOperation__Group_0__0");
			builder.put(grammarAccess.getAUnitExpressionAccess().getGroup(), "rule__AUnitExpression__Group__0");
			builder.put(grammarAccess.getAUnitExpressionAccess().getGroup_1(), "rule__AUnitExpression__Group_1__0");
			builder.put(grammarAccess.getAFunctionCallAccess().getGroup(), "rule__AFunctionCall__Group__0");
			builder.put(grammarAccess.getAFunctionCallAccess().getGroup_3(), "rule__AFunctionCall__Group_3__0");
			builder.put(grammarAccess.getAFunctionCallAccess().getGroup_3_1(), "rule__AFunctionCall__Group_3_1__0");
			builder.put(grammarAccess.getARangeExpressionAccess().getGroup(), "rule__ARangeExpression__Group__0");
			builder.put(grammarAccess.getARangeExpressionAccess().getGroup_5(), "rule__ARangeExpression__Group_5__0");
			builder.put(grammarAccess.getAIfExpressionAccess().getGroup(), "rule__AIfExpression__Group__0");
			builder.put(grammarAccess.getAIfExpressionAccess().getGroup_5(), "rule__AIfExpression__Group_5__0");
			builder.put(grammarAccess.getABooleanLiteralAccess().getGroup(), "rule__ABooleanLiteral__Group__0");
			builder.put(grammarAccess.getAParenthesizedExpressionAccess().getGroup(), "rule__AParenthesizedExpression__Group__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_8(), "rule__ComponentCategory__Group_8__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_10(), "rule__ComponentCategory__Group_10__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_12(), "rule__ComponentCategory__Group_12__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_13(), "rule__ComponentCategory__Group_13__0");
			builder.put(grammarAccess.getAadlClassifierReferenceAccess().getGroup(), "rule__AadlClassifierReference__Group__0");
			builder.put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_1(), "rule__AadlClassifierReference__Group_1__0");
			builder.put(grammarAccess.getAadlClassifierReferenceAccess().getGroup_2(), "rule__AadlClassifierReference__Group_2__0");
			builder.put(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup(), "rule__AADLPROPERTYREFERENCE__Group__0");
			builder.put(grammarAccess.getAADLPROPERTYREFERENCEAccess().getGroup_1(), "rule__AADLPROPERTYREFERENCE__Group_1__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getAssuranceCaseAccess().getNameAssignment_2(), "rule__AssuranceCase__NameAssignment_2");
			builder.put(grammarAccess.getAssuranceCaseAccess().getTitleAssignment_3_1(), "rule__AssuranceCase__TitleAssignment_3_1");
			builder.put(grammarAccess.getAssuranceCaseAccess().getSystemAssignment_5(), "rule__AssuranceCase__SystemAssignment_5");
			builder.put(grammarAccess.getAssuranceCaseAccess().getDescriptionAssignment_7(), "rule__AssuranceCase__DescriptionAssignment_7");
			builder.put(grammarAccess.getAssuranceCaseAccess().getAssurancePlansAssignment_8(), "rule__AssuranceCase__AssurancePlansAssignment_8");
			builder.put(grammarAccess.getAssuranceCaseAccess().getTasksAssignment_9(), "rule__AssuranceCase__TasksAssignment_9");
			builder.put(grammarAccess.getAssurancePlanAccess().getNameAssignment_2(), "rule__AssurancePlan__NameAssignment_2");
			builder.put(grammarAccess.getAssurancePlanAccess().getTitleAssignment_3_1(), "rule__AssurancePlan__TitleAssignment_3_1");
			builder.put(grammarAccess.getAssurancePlanAccess().getTargetAssignment_5(), "rule__AssurancePlan__TargetAssignment_5");
			builder.put(grammarAccess.getAssurancePlanAccess().getDescriptionAssignment_7_0(), "rule__AssurancePlan__DescriptionAssignment_7_0");
			builder.put(grammarAccess.getAssurancePlanAccess().getAssureAssignment_7_1_1(), "rule__AssurancePlan__AssureAssignment_7_1_1");
			builder.put(grammarAccess.getAssurancePlanAccess().getAssureGlobalAssignment_7_2_2(), "rule__AssurancePlan__AssureGlobalAssignment_7_2_2");
			builder.put(grammarAccess.getAssurancePlanAccess().getAssureSubsystemsAssignment_7_3_2_0(), "rule__AssurancePlan__AssureSubsystemsAssignment_7_3_2_0");
			builder.put(grammarAccess.getAssurancePlanAccess().getAssureAllAssignment_7_3_2_1(), "rule__AssurancePlan__AssureAllAssignment_7_3_2_1");
			builder.put(grammarAccess.getAssurancePlanAccess().getAssumeSubsystemsAssignment_7_4_2_0(), "rule__AssurancePlan__AssumeSubsystemsAssignment_7_4_2_0");
			builder.put(grammarAccess.getAssurancePlanAccess().getAssumeAllAssignment_7_4_2_1(), "rule__AssurancePlan__AssumeAllAssignment_7_4_2_1");
			builder.put(grammarAccess.getAssurancePlanAccess().getIssuesAssignment_7_5_1(), "rule__AssurancePlan__IssuesAssignment_7_5_1");
			builder.put(grammarAccess.getAssuranceTaskAccess().getNameAssignment_3(), "rule__AssuranceTask__NameAssignment_3");
			builder.put(grammarAccess.getAssuranceTaskAccess().getTitleAssignment_4_1(), "rule__AssuranceTask__TitleAssignment_4_1");
			builder.put(grammarAccess.getAssuranceTaskAccess().getDescriptionAssignment_6_0(), "rule__AssuranceTask__DescriptionAssignment_6_0");
			builder.put(grammarAccess.getAssuranceTaskAccess().getCategoryAssignment_6_1_1(), "rule__AssuranceTask__CategoryAssignment_6_1_1");
			builder.put(grammarAccess.getAssuranceTaskAccess().getAnyCategoryAssignment_6_1_2(), "rule__AssuranceTask__AnyCategoryAssignment_6_1_2");
			builder.put(grammarAccess.getAssuranceTaskAccess().getIssuesAssignment_6_2_1(), "rule__AssuranceTask__IssuesAssignment_6_2_1");
			builder.put(grammarAccess.getDescriptionAccess().getDescriptionAssignment_1(), "rule__Description__DescriptionAssignment_1");
			builder.put(grammarAccess.getDescriptionElementAccess().getTextAssignment_0(), "rule__DescriptionElement__TextAssignment_0");
			builder.put(grammarAccess.getDescriptionElementAccess().getThisTargetAssignment_1(), "rule__DescriptionElement__ThisTargetAssignment_1");
			builder.put(grammarAccess.getDescriptionElementAccess().getImageAssignment_2(), "rule__DescriptionElement__ImageAssignment_2");
			builder.put(grammarAccess.getDescriptionElementAccess().getShowValueAssignment_3(), "rule__DescriptionElement__ShowValueAssignment_3");
			builder.put(grammarAccess.getRationaleAccess().getDescriptionAssignment_1(), "rule__Rationale__DescriptionAssignment_1");
			builder.put(grammarAccess.getUncertaintyAccess().getVolatilityAssignment_3_0_1(), "rule__Uncertainty__VolatilityAssignment_3_0_1");
			builder.put(grammarAccess.getUncertaintyAccess().getPrecedenceAssignment_3_1_1(), "rule__Uncertainty__PrecedenceAssignment_3_1_1");
			builder.put(grammarAccess.getUncertaintyAccess().getImpactAssignment_3_2_1(), "rule__Uncertainty__ImpactAssignment_3_2_1");
			builder.put(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_1_2_1(), "rule__TypeRef__ReferencedUnitsTypeAssignment_1_2_1");
			builder.put(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeAssignment_2_2_1(), "rule__TypeRef__ReferencedUnitsTypeAssignment_2_2_1");
			builder.put(grammarAccess.getTypeRefAccess().getRefAssignment_5_1(), "rule__TypeRef__RefAssignment_5_1");
			builder.put(grammarAccess.getPropertyRefAccess().getRefAssignment_1(), "rule__PropertyRef__RefAssignment_1");
			builder.put(grammarAccess.getValDeclarationAccess().getNameAssignment_2(), "rule__ValDeclaration__NameAssignment_2");
			builder.put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_0(), "rule__ValDeclaration__TypeAssignment_3_1_0");
			builder.put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_1_1(), "rule__ValDeclaration__TypeAssignment_3_1_1_1");
			builder.put(grammarAccess.getValDeclarationAccess().getRangeAssignment_3_1_2_0(), "rule__ValDeclaration__RangeAssignment_3_1_2_0");
			builder.put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_0(), "rule__ValDeclaration__TypeAssignment_3_1_2_1_0");
			builder.put(grammarAccess.getValDeclarationAccess().getTypeAssignment_3_1_2_1_1_1(), "rule__ValDeclaration__TypeAssignment_3_1_2_1_1_1");
			builder.put(grammarAccess.getValDeclarationAccess().getValueAssignment_5(), "rule__ValDeclaration__ValueAssignment_5");
			builder.put(grammarAccess.getComputeDeclarationAccess().getNameAssignment_2(), "rule__ComputeDeclaration__NameAssignment_2");
			builder.put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_0(), "rule__ComputeDeclaration__TypeAssignment_4_0");
			builder.put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_1_1(), "rule__ComputeDeclaration__TypeAssignment_4_1_1");
			builder.put(grammarAccess.getComputeDeclarationAccess().getRangeAssignment_4_2_0(), "rule__ComputeDeclaration__RangeAssignment_4_2_0");
			builder.put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_0(), "rule__ComputeDeclaration__TypeAssignment_4_2_1_0");
			builder.put(grammarAccess.getComputeDeclarationAccess().getTypeAssignment_4_2_1_1_1(), "rule__ComputeDeclaration__TypeAssignment_4_2_1_1_1");
			builder.put(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAssignment_0_1_1(), "rule__AModelOrPropertyReference__PropertyAssignment_0_1_1");
			builder.put(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_0(), "rule__AModelReference__ModelElementAssignment_0");
			builder.put(grammarAccess.getAModelReferenceAccess().getModelElementAssignment_1_2(), "rule__AModelReference__ModelElementAssignment_1_2");
			builder.put(grammarAccess.getAPropertyReferenceAccess().getPropertyAssignment_2(), "rule__APropertyReference__PropertyAssignment_2");
			builder.put(grammarAccess.getAVariableReferenceAccess().getVariableAssignment_1(), "rule__AVariableReference__VariableAssignment_1");
			builder.put(grammarAccess.getShowValueAccess().getExpressionAssignment_0(), "rule__ShowValue__ExpressionAssignment_0");
			builder.put(grammarAccess.getShowValueAccess().getConvertAssignment_1_0_0(), "rule__ShowValue__ConvertAssignment_1_0_0");
			builder.put(grammarAccess.getShowValueAccess().getDropAssignment_1_0_1(), "rule__ShowValue__DropAssignment_1_0_1");
			builder.put(grammarAccess.getShowValueAccess().getUnitAssignment_1_1(), "rule__ShowValue__UnitAssignment_1_1");
			builder.put(grammarAccess.getImageReferenceAccess().getImgfileAssignment_1(), "rule__ImageReference__ImgfileAssignment_1");
			builder.put(grammarAccess.getAOrExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AOrExpression__OperatorAssignment_1_0_0_1");
			builder.put(grammarAccess.getAOrExpressionAccess().getRightAssignment_1_1(), "rule__AOrExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getAAndExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AAndExpression__OperatorAssignment_1_0_0_1");
			builder.put(grammarAccess.getAAndExpressionAccess().getRightAssignment_1_1(), "rule__AAndExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getAEqualityExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AEqualityExpression__OperatorAssignment_1_0_0_1");
			builder.put(grammarAccess.getAEqualityExpressionAccess().getRightAssignment_1_1(), "rule__AEqualityExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getARelationalExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__ARelationalExpression__OperatorAssignment_1_0_0_1");
			builder.put(grammarAccess.getARelationalExpressionAccess().getRightAssignment_1_1(), "rule__ARelationalExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getAAdditiveExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AAdditiveExpression__OperatorAssignment_1_0_0_1");
			builder.put(grammarAccess.getAAdditiveExpressionAccess().getRightAssignment_1_1(), "rule__AAdditiveExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorAssignment_1_0_0_1(), "rule__AMultiplicativeExpression__OperatorAssignment_1_0_0_1");
			builder.put(grammarAccess.getAMultiplicativeExpressionAccess().getRightAssignment_1_1(), "rule__AMultiplicativeExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getAUnaryOperationAccess().getOperatorAssignment_0_1(), "rule__AUnaryOperation__OperatorAssignment_0_1");
			builder.put(grammarAccess.getAUnaryOperationAccess().getOperandAssignment_0_2(), "rule__AUnaryOperation__OperandAssignment_0_2");
			builder.put(grammarAccess.getAUnitExpressionAccess().getConvertAssignment_1_1_0(), "rule__AUnitExpression__ConvertAssignment_1_1_0");
			builder.put(grammarAccess.getAUnitExpressionAccess().getDropAssignment_1_1_1(), "rule__AUnitExpression__DropAssignment_1_1_1");
			builder.put(grammarAccess.getAUnitExpressionAccess().getUnitAssignment_1_2(), "rule__AUnitExpression__UnitAssignment_1_2");
			builder.put(grammarAccess.getAFunctionCallAccess().getFunctionAssignment_1(), "rule__AFunctionCall__FunctionAssignment_1");
			builder.put(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_0(), "rule__AFunctionCall__ArgumentsAssignment_3_0");
			builder.put(grammarAccess.getAFunctionCallAccess().getArgumentsAssignment_3_1_1(), "rule__AFunctionCall__ArgumentsAssignment_3_1_1");
			builder.put(grammarAccess.getARangeExpressionAccess().getMinimumAssignment_2(), "rule__ARangeExpression__MinimumAssignment_2");
			builder.put(grammarAccess.getARangeExpressionAccess().getMaximumAssignment_4(), "rule__ARangeExpression__MaximumAssignment_4");
			builder.put(grammarAccess.getARangeExpressionAccess().getDeltaAssignment_5_1(), "rule__ARangeExpression__DeltaAssignment_5_1");
			builder.put(grammarAccess.getAIfExpressionAccess().getIfAssignment_2(), "rule__AIfExpression__IfAssignment_2");
			builder.put(grammarAccess.getAIfExpressionAccess().getThenAssignment_4(), "rule__AIfExpression__ThenAssignment_4");
			builder.put(grammarAccess.getAIfExpressionAccess().getElseAssignment_5_1(), "rule__AIfExpression__ElseAssignment_5_1");
			builder.put(grammarAccess.getAIntegerTermAccess().getValueAssignment(), "rule__AIntegerTerm__ValueAssignment");
			builder.put(grammarAccess.getARealTermAccess().getValueAssignment(), "rule__ARealTerm__ValueAssignment");
			builder.put(grammarAccess.getABooleanLiteralAccess().getValueAssignment_1_0(), "rule__ABooleanLiteral__ValueAssignment_1_0");
			builder.put(grammarAccess.getStringTermAccess().getValueAssignment(), "rule__StringTerm__ValueAssignment");
			builder.put(grammarAccess.getAssurancePlanAccess().getUnorderedGroup_7(), "rule__AssurancePlan__UnorderedGroup_7");
			builder.put(grammarAccess.getAssuranceTaskAccess().getUnorderedGroup_6(), "rule__AssuranceTask__UnorderedGroup_6");
			builder.put(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), "rule__Uncertainty__UnorderedGroup_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private AlisaGrammarAccess grammarAccess;

	@Override
	protected InternalAlisaParser createParser() {
		InternalAlisaParser result = new InternalAlisaParser(null);
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

	public AlisaGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AlisaGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
