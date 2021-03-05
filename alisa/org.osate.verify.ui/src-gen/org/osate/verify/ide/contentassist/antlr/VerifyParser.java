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
package org.osate.verify.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.verify.ide.contentassist.antlr.internal.InternalVerifyParser;
import org.osate.verify.services.VerifyGrammarAccess;

public class VerifyParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(VerifyGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, VerifyGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getVerificationAccess().getContentsAlternatives_0(), "rule__Verification__ContentsAlternatives_0");
			builder.put(grammarAccess.getElseEvidenceExprAccess().getAlternatives(), "rule__ElseEvidenceExpr__Alternatives");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getAlternatives_1_1(), "rule__SingleElseEvidenceExpr__Alternatives_1_1");
			builder.put(grammarAccess.getCompositeEvidenceExprAccess().getAlternatives(), "rule__CompositeEvidenceExpr__Alternatives");
			builder.put(grammarAccess.getFormalParameterAccess().getAlternatives_2(), "rule__FormalParameter__Alternatives_2");
			builder.put(grammarAccess.getVerificationMethodAccess().getAlternatives_2_1(), "rule__VerificationMethod__Alternatives_2_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getAlternatives_2_5(), "rule__VerificationMethod__Alternatives_2_5");
			builder.put(grammarAccess.getVerificationMethodAccess().getAlternatives_4_1(), "rule__VerificationMethod__Alternatives_4_1");
			builder.put(grammarAccess.getMethodKindAccess().getAlternatives(), "rule__MethodKind__Alternatives");
			builder.put(grammarAccess.getAgreeMethodAccess().getAlternatives_1(), "rule__AgreeMethod__Alternatives_1");
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
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup(), "rule__VerificationPlan__Group__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_3(), "rule__VerificationPlan__Group_3__0");
			builder.put(grammarAccess.getVerificationPlanAccess().getGroup_7_3(), "rule__VerificationPlan__Group_7_3__0");
			builder.put(grammarAccess.getClaimAccess().getGroup(), "rule__Claim__Group__0");
			builder.put(grammarAccess.getClaimAccess().getGroup_3(), "rule__Claim__Group_3__0");
			builder.put(grammarAccess.getClaimAccess().getGroup_5_0(), "rule__Claim__Group_5_0__0");
			builder.put(grammarAccess.getClaimAccess().getGroup_5_1(), "rule__Claim__Group_5_1__0");
			builder.put(grammarAccess.getClaimAccess().getGroup_5_3(), "rule__Claim__Group_5_3__0");
			builder.put(grammarAccess.getClaimAccess().getGroup_5_5(), "rule__Claim__Group_5_5__0");
			builder.put(grammarAccess.getThenEvidenceExprAccess().getGroup(), "rule__ThenEvidenceExpr__Group__0");
			builder.put(grammarAccess.getThenEvidenceExprAccess().getGroup_1(), "rule__ThenEvidenceExpr__Group_1__0");
			builder.put(grammarAccess.getThenEvidenceExprAccess().getGroup_1_0(), "rule__ThenEvidenceExpr__Group_1_0__0");
			builder.put(grammarAccess.getThenEvidenceExprAccess().getGroup_1_0_0(), "rule__ThenEvidenceExpr__Group_1_0_0__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup(), "rule__SingleElseEvidenceExpr__Group__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1(), "rule__SingleElseEvidenceExpr__Group_1__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_0(), "rule__SingleElseEvidenceExpr__Group_1_0__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_0_0(), "rule__SingleElseEvidenceExpr__Group_1_0_0__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1(), "rule__SingleElseEvidenceExpr__Group_1_1_1__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1_1(), "rule__SingleElseEvidenceExpr__Group_1_1_1_1__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1_2(), "rule__SingleElseEvidenceExpr__Group_1_1_1_2__0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getGroup_1_1_1_3(), "rule__SingleElseEvidenceExpr__Group_1_1_1_3__0");
			builder.put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup(), "rule__CompositeElseEvidenceExpr__Group__0");
			builder.put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup_1(), "rule__CompositeElseEvidenceExpr__Group_1__0");
			builder.put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup_1_0(), "rule__CompositeElseEvidenceExpr__Group_1_0__0");
			builder.put(grammarAccess.getCompositeElseEvidenceExprAccess().getGroup_1_0_0(), "rule__CompositeElseEvidenceExpr__Group_1_0_0__0");
			builder.put(grammarAccess.getQuantifiedEvidenceExprAccess().getGroup(), "rule__QuantifiedEvidenceExpr__Group__0");
			builder.put(grammarAccess.getQuantifiedEvidenceExprAccess().getGroup_4(), "rule__QuantifiedEvidenceExpr__Group_4__0");
			builder.put(grammarAccess.getCompositeEvidenceExprAccess().getGroup_0(), "rule__CompositeEvidenceExpr__Group_0__0");
			builder.put(grammarAccess.getVAReferenceAccess().getGroup(), "rule__VAReference__Group__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup(), "rule__VerificationActivity__Group__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_1(), "rule__VerificationActivity__Group_1__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_3(), "rule__VerificationActivity__Group_3__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_3_1(), "rule__VerificationActivity__Group_3_1__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_6(), "rule__VerificationActivity__Group_6__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_6_1(), "rule__VerificationActivity__Group_6_1__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_8(), "rule__VerificationActivity__Group_8__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_8_3(), "rule__VerificationActivity__Group_8_3__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_8_3_1(), "rule__VerificationActivity__Group_8_3_1__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_9(), "rule__VerificationActivity__Group_9__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_9_1_0(), "rule__VerificationActivity__Group_9_1_0__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_9_1_1(), "rule__VerificationActivity__Group_9_1_1__0");
			builder.put(grammarAccess.getVerificationActivityAccess().getGroup_9_1_2(), "rule__VerificationActivity__Group_9_1_2__0");
			builder.put(grammarAccess.getVerificationValidationAccess().getGroup(), "rule__VerificationValidation__Group__0");
			builder.put(grammarAccess.getVerificationValidationAccess().getGroup_4(), "rule__VerificationValidation__Group_4__0");
			builder.put(grammarAccess.getVerificationValidationAccess().getGroup_4_1(), "rule__VerificationValidation__Group_4_1__0");
			builder.put(grammarAccess.getVerificationPreconditionAccess().getGroup(), "rule__VerificationPrecondition__Group__0");
			builder.put(grammarAccess.getVerificationPreconditionAccess().getGroup_4(), "rule__VerificationPrecondition__Group_4__0");
			builder.put(grammarAccess.getVerificationPreconditionAccess().getGroup_4_1(), "rule__VerificationPrecondition__Group_4_1__0");
			builder.put(grammarAccess.getVerificationMethodRegistryAccess().getGroup(), "rule__VerificationMethodRegistry__Group__0");
			builder.put(grammarAccess.getVerificationMethodRegistryAccess().getGroup_3(), "rule__VerificationMethodRegistry__Group_3__0");
			builder.put(grammarAccess.getVerificationMethodRegistryAccess().getGroup_5(), "rule__VerificationMethodRegistry__Group_5__0");
			builder.put(grammarAccess.getFormalParameterAccess().getGroup(), "rule__FormalParameter__Group__0");
			builder.put(grammarAccess.getFormalParameterAccess().getGroup_2_1(), "rule__FormalParameter__Group_2_1__0");
			builder.put(grammarAccess.getFormalParameterAccess().getGroup_3(), "rule__FormalParameter__Group_3__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup(), "rule__VerificationMethod__Group__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2(), "rule__VerificationMethod__Group_2__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_1_1(), "rule__VerificationMethod__Group_2_1_1__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_1_1_1(), "rule__VerificationMethod__Group_2_1_1_1__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_1_2(), "rule__VerificationMethod__Group_2_1_2__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_1_2_3(), "rule__VerificationMethod__Group_2_1_2_3__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_3(), "rule__VerificationMethod__Group_2_3__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_3_2(), "rule__VerificationMethod__Group_2_3_2__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_3_2_1(), "rule__VerificationMethod__Group_2_3_2_1__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_4(), "rule__VerificationMethod__Group_2_4__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_4_2(), "rule__VerificationMethod__Group_2_4_2__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_2_4_2_1(), "rule__VerificationMethod__Group_2_4_2_1__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_3(), "rule__VerificationMethod__Group_3__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_4(), "rule__VerificationMethod__Group_4__0");
			builder.put(grammarAccess.getVerificationMethodAccess().getGroup_6_4(), "rule__VerificationMethod__Group_6_4__0");
			builder.put(grammarAccess.getResoluteMethodAccess().getGroup(), "rule__ResoluteMethod__Group__0");
			builder.put(grammarAccess.getJavaMethodAccess().getGroup(), "rule__JavaMethod__Group__0");
			builder.put(grammarAccess.getJavaMethodAccess().getGroup_2(), "rule__JavaMethod__Group_2__0");
			builder.put(grammarAccess.getJavaMethodAccess().getGroup_2_1(), "rule__JavaMethod__Group_2_1__0");
			builder.put(grammarAccess.getJavaMethodAccess().getGroup_2_1_1(), "rule__JavaMethod__Group_2_1_1__0");
			builder.put(grammarAccess.getPythonMethodAccess().getGroup(), "rule__PythonMethod__Group__0");
			builder.put(grammarAccess.getManualMethodAccess().getGroup(), "rule__ManualMethod__Group__0");
			builder.put(grammarAccess.getPluginMethodAccess().getGroup(), "rule__PluginMethod__Group__0");
			builder.put(grammarAccess.getAgreeMethodAccess().getGroup(), "rule__AgreeMethod__Group__0");
			builder.put(grammarAccess.getJUnit4MethodAccess().getGroup(), "rule__JUnit4Method__Group__0");
			builder.put(grammarAccess.getJavaParameterAccess().getGroup(), "rule__JavaParameter__Group__0");
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
			builder.put(grammarAccess.getVerificationAccess().getContentsAssignment(), "rule__Verification__ContentsAssignment");
			builder.put(grammarAccess.getVerificationPlanAccess().getNameAssignment_2(), "rule__VerificationPlan__NameAssignment_2");
			builder.put(grammarAccess.getVerificationPlanAccess().getTitleAssignment_3_1(), "rule__VerificationPlan__TitleAssignment_3_1");
			builder.put(grammarAccess.getVerificationPlanAccess().getRequirementSetAssignment_5(), "rule__VerificationPlan__RequirementSetAssignment_5");
			builder.put(grammarAccess.getVerificationPlanAccess().getDescriptionAssignment_7_0(), "rule__VerificationPlan__DescriptionAssignment_7_0");
			builder.put(grammarAccess.getVerificationPlanAccess().getClaimAssignment_7_1(), "rule__VerificationPlan__ClaimAssignment_7_1");
			builder.put(grammarAccess.getVerificationPlanAccess().getRationaleAssignment_7_2(), "rule__VerificationPlan__RationaleAssignment_7_2");
			builder.put(grammarAccess.getVerificationPlanAccess().getIssuesAssignment_7_3_1(), "rule__VerificationPlan__IssuesAssignment_7_3_1");
			builder.put(grammarAccess.getClaimAccess().getRequirementAssignment_2(), "rule__Claim__RequirementAssignment_2");
			builder.put(grammarAccess.getClaimAccess().getTitleAssignment_3_1(), "rule__Claim__TitleAssignment_3_1");
			builder.put(grammarAccess.getClaimAccess().getActivitiesAssignment_5_0_1(), "rule__Claim__ActivitiesAssignment_5_0_1");
			builder.put(grammarAccess.getClaimAccess().getAssertAssignment_5_1_1(), "rule__Claim__AssertAssignment_5_1_1");
			builder.put(grammarAccess.getClaimAccess().getRationaleAssignment_5_2(), "rule__Claim__RationaleAssignment_5_2");
			builder.put(grammarAccess.getClaimAccess().getWeightAssignment_5_3_1(), "rule__Claim__WeightAssignment_5_3_1");
			builder.put(grammarAccess.getClaimAccess().getSubclaimAssignment_5_4(), "rule__Claim__SubclaimAssignment_5_4");
			builder.put(grammarAccess.getClaimAccess().getIssuesAssignment_5_5_1(), "rule__Claim__IssuesAssignment_5_5_1");
			builder.put(grammarAccess.getThenEvidenceExprAccess().getSuccessorAssignment_1_1(), "rule__ThenEvidenceExpr__SuccessorAssignment_1_1");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getErrorAssignment_1_1_0(), "rule__SingleElseEvidenceExpr__ErrorAssignment_1_1_0");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getFailAssignment_1_1_1_1_2(), "rule__SingleElseEvidenceExpr__FailAssignment_1_1_1_1_2");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getTimeoutAssignment_1_1_1_2_2(), "rule__SingleElseEvidenceExpr__TimeoutAssignment_1_1_1_2_2");
			builder.put(grammarAccess.getSingleElseEvidenceExprAccess().getErrorAssignment_1_1_1_3_2(), "rule__SingleElseEvidenceExpr__ErrorAssignment_1_1_1_3_2");
			builder.put(grammarAccess.getCompositeElseEvidenceExprAccess().getErrorAssignment_1_1(), "rule__CompositeElseEvidenceExpr__ErrorAssignment_1_1");
			builder.put(grammarAccess.getQuantifiedEvidenceExprAccess().getElementsAssignment_3(), "rule__QuantifiedEvidenceExpr__ElementsAssignment_3");
			builder.put(grammarAccess.getQuantifiedEvidenceExprAccess().getElementsAssignment_4_1(), "rule__QuantifiedEvidenceExpr__ElementsAssignment_4_1");
			builder.put(grammarAccess.getVAReferenceAccess().getVerificationAssignment_1(), "rule__VAReference__VerificationAssignment_1");
			builder.put(grammarAccess.getComputeRefAccess().getComputeAssignment(), "rule__ComputeRef__ComputeAssignment");
			builder.put(grammarAccess.getVerificationActivityAccess().getNameAssignment_0(), "rule__VerificationActivity__NameAssignment_0");
			builder.put(grammarAccess.getVerificationActivityAccess().getTitleAssignment_1_1(), "rule__VerificationActivity__TitleAssignment_1_1");
			builder.put(grammarAccess.getVerificationActivityAccess().getComputesAssignment_3_0(), "rule__VerificationActivity__ComputesAssignment_3_0");
			builder.put(grammarAccess.getVerificationActivityAccess().getComputesAssignment_3_1_1(), "rule__VerificationActivity__ComputesAssignment_3_1_1");
			builder.put(grammarAccess.getVerificationActivityAccess().getMethodAssignment_4(), "rule__VerificationActivity__MethodAssignment_4");
			builder.put(grammarAccess.getVerificationActivityAccess().getActualsAssignment_6_0(), "rule__VerificationActivity__ActualsAssignment_6_0");
			builder.put(grammarAccess.getVerificationActivityAccess().getActualsAssignment_6_1_1(), "rule__VerificationActivity__ActualsAssignment_6_1_1");
			builder.put(grammarAccess.getVerificationActivityAccess().getPropertyValuesAssignment_8_3_0(), "rule__VerificationActivity__PropertyValuesAssignment_8_3_0");
			builder.put(grammarAccess.getVerificationActivityAccess().getPropertyValuesAssignment_8_3_1_1(), "rule__VerificationActivity__PropertyValuesAssignment_8_3_1_1");
			builder.put(grammarAccess.getVerificationActivityAccess().getCategoryAssignment_9_1_0_1(), "rule__VerificationActivity__CategoryAssignment_9_1_0_1");
			builder.put(grammarAccess.getVerificationActivityAccess().getTimeoutAssignment_9_1_1_1(), "rule__VerificationActivity__TimeoutAssignment_9_1_1_1");
			builder.put(grammarAccess.getVerificationActivityAccess().getWeightAssignment_9_1_2_1(), "rule__VerificationActivity__WeightAssignment_9_1_2_1");
			builder.put(grammarAccess.getVerificationValidationAccess().getMethodAssignment_2(), "rule__VerificationValidation__MethodAssignment_2");
			builder.put(grammarAccess.getVerificationValidationAccess().getParametersAssignment_4_0(), "rule__VerificationValidation__ParametersAssignment_4_0");
			builder.put(grammarAccess.getVerificationValidationAccess().getParametersAssignment_4_1_1(), "rule__VerificationValidation__ParametersAssignment_4_1_1");
			builder.put(grammarAccess.getVerificationPreconditionAccess().getMethodAssignment_2(), "rule__VerificationPrecondition__MethodAssignment_2");
			builder.put(grammarAccess.getVerificationPreconditionAccess().getParametersAssignment_4_0(), "rule__VerificationPrecondition__ParametersAssignment_4_0");
			builder.put(grammarAccess.getVerificationPreconditionAccess().getParametersAssignment_4_1_1(), "rule__VerificationPrecondition__ParametersAssignment_4_1_1");
			builder.put(grammarAccess.getVerificationMethodRegistryAccess().getNameAssignment_2(), "rule__VerificationMethodRegistry__NameAssignment_2");
			builder.put(grammarAccess.getVerificationMethodRegistryAccess().getTitleAssignment_3_1(), "rule__VerificationMethodRegistry__TitleAssignment_3_1");
			builder.put(grammarAccess.getVerificationMethodRegistryAccess().getDescriptionAssignment_5_0(), "rule__VerificationMethodRegistry__DescriptionAssignment_5_0");
			builder.put(grammarAccess.getVerificationMethodRegistryAccess().getMethodsAssignment_5_1(), "rule__VerificationMethodRegistry__MethodsAssignment_5_1");
			builder.put(grammarAccess.getFormalParameterAccess().getNameAssignment_0(), "rule__FormalParameter__NameAssignment_0");
			builder.put(grammarAccess.getFormalParameterAccess().getTypeAssignment_2_0(), "rule__FormalParameter__TypeAssignment_2_0");
			builder.put(grammarAccess.getFormalParameterAccess().getTypeAssignment_2_1_1(), "rule__FormalParameter__TypeAssignment_2_1_1");
			builder.put(grammarAccess.getFormalParameterAccess().getUnitAssignment_3_1(), "rule__FormalParameter__UnitAssignment_3_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getNameAssignment_1(), "rule__VerificationMethod__NameAssignment_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getTargetTypeAssignment_2_1_0(), "rule__VerificationMethod__TargetTypeAssignment_2_1_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getFormalsAssignment_2_1_1_0(), "rule__VerificationMethod__FormalsAssignment_2_1_1_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getFormalsAssignment_2_1_1_1_1(), "rule__VerificationMethod__FormalsAssignment_2_1_1_1_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getTargetTypeAssignment_2_1_2_0(), "rule__VerificationMethod__TargetTypeAssignment_2_1_2_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getFormalsAssignment_2_1_2_2(), "rule__VerificationMethod__FormalsAssignment_2_1_2_2");
			builder.put(grammarAccess.getVerificationMethodAccess().getFormalsAssignment_2_1_2_3_1(), "rule__VerificationMethod__FormalsAssignment_2_1_2_3_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getPropertiesAssignment_2_3_2_0(), "rule__VerificationMethod__PropertiesAssignment_2_3_2_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getPropertiesAssignment_2_3_2_1_1(), "rule__VerificationMethod__PropertiesAssignment_2_3_2_1_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getResultsAssignment_2_4_2_0(), "rule__VerificationMethod__ResultsAssignment_2_4_2_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getResultsAssignment_2_4_2_1_1(), "rule__VerificationMethod__ResultsAssignment_2_4_2_1_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getIsPredicateAssignment_2_5_0(), "rule__VerificationMethod__IsPredicateAssignment_2_5_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getIsResultReportAssignment_2_5_1(), "rule__VerificationMethod__IsResultReportAssignment_2_5_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getTitleAssignment_3_1(), "rule__VerificationMethod__TitleAssignment_3_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getTargetAssignment_4_1_0(), "rule__VerificationMethod__TargetAssignment_4_1_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getComponentCategoryAssignment_4_1_1(), "rule__VerificationMethod__ComponentCategoryAssignment_4_1_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getMethodKindAssignment_6_0(), "rule__VerificationMethod__MethodKindAssignment_6_0");
			builder.put(grammarAccess.getVerificationMethodAccess().getDescriptionAssignment_6_1(), "rule__VerificationMethod__DescriptionAssignment_6_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getPreconditionAssignment_6_2(), "rule__VerificationMethod__PreconditionAssignment_6_2");
			builder.put(grammarAccess.getVerificationMethodAccess().getValidationAssignment_6_3(), "rule__VerificationMethod__ValidationAssignment_6_3");
			builder.put(grammarAccess.getVerificationMethodAccess().getCategoryAssignment_6_4_1(), "rule__VerificationMethod__CategoryAssignment_6_4_1");
			builder.put(grammarAccess.getResoluteMethodAccess().getMethodReferenceAssignment_1(), "rule__ResoluteMethod__MethodReferenceAssignment_1");
			builder.put(grammarAccess.getJavaMethodAccess().getMethodPathAssignment_1(), "rule__JavaMethod__MethodPathAssignment_1");
			builder.put(grammarAccess.getJavaMethodAccess().getParamsAssignment_2_1_0(), "rule__JavaMethod__ParamsAssignment_2_1_0");
			builder.put(grammarAccess.getJavaMethodAccess().getParamsAssignment_2_1_1_1(), "rule__JavaMethod__ParamsAssignment_2_1_1_1");
			builder.put(grammarAccess.getPythonMethodAccess().getMethodPathAssignment_1(), "rule__PythonMethod__MethodPathAssignment_1");
			builder.put(grammarAccess.getManualMethodAccess().getDialogIDAssignment_2(), "rule__ManualMethod__DialogIDAssignment_2");
			builder.put(grammarAccess.getPluginMethodAccess().getMethodIDAssignment_1(), "rule__PluginMethod__MethodIDAssignment_1");
			builder.put(grammarAccess.getAgreeMethodAccess().getSingleLayerAssignment_1_0(), "rule__AgreeMethod__SingleLayerAssignment_1_0");
			builder.put(grammarAccess.getAgreeMethodAccess().getAllAssignment_1_1(), "rule__AgreeMethod__AllAssignment_1_1");
			builder.put(grammarAccess.getJUnit4MethodAccess().getClassPathAssignment_1(), "rule__JUnit4Method__ClassPathAssignment_1");
			builder.put(grammarAccess.getJavaParameterAccess().getParameterTypeAssignment_0(), "rule__JavaParameter__ParameterTypeAssignment_0");
			builder.put(grammarAccess.getJavaParameterAccess().getNameAssignment_1(), "rule__JavaParameter__NameAssignment_1");
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
			builder.put(grammarAccess.getVerificationPlanAccess().getUnorderedGroup_7(), "rule__VerificationPlan__UnorderedGroup_7");
			builder.put(grammarAccess.getClaimAccess().getUnorderedGroup_5(), "rule__Claim__UnorderedGroup_5");
			builder.put(grammarAccess.getVerificationActivityAccess().getUnorderedGroup_9_1(), "rule__VerificationActivity__UnorderedGroup_9_1");
			builder.put(grammarAccess.getVerificationMethodAccess().getUnorderedGroup_6(), "rule__VerificationMethod__UnorderedGroup_6");
			builder.put(grammarAccess.getUncertaintyAccess().getUnorderedGroup_3(), "rule__Uncertainty__UnorderedGroup_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private VerifyGrammarAccess grammarAccess;

	@Override
	protected InternalVerifyParser createParser() {
		InternalVerifyParser result = new InternalVerifyParser(null);
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

	public VerifyGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(VerifyGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
