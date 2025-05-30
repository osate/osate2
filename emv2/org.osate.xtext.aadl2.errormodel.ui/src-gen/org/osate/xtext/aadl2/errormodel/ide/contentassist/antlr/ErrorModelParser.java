/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.xtext.aadl2.errormodel.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.xtext.aadl2.errormodel.ide.contentassist.antlr.internal.InternalErrorModelParser;
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;

public class ErrorModelParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ErrorModelGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ErrorModelGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getEMV2RootAccess().getAlternatives_1(), "rule__EMV2Root__Alternatives_1");
			builder.put(grammarAccess.getNamedElementAccess().getAlternatives(), "rule__NamedElement__Alternatives");
			builder.put(grammarAccess.getElementAccess().getAlternatives(), "rule__Element__Alternatives");
			builder.put(grammarAccess.getPropertyAssociationAccess().getAlternatives(), "rule__PropertyAssociation__Alternatives");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getAlternatives_1_4(), "rule__ErrorModelLibrary__Alternatives_1_4");
			builder.put(grammarAccess.getEMV2LibraryAccess().getAlternatives(), "rule__EMV2Library__Alternatives");
			builder.put(grammarAccess.getEMV2LibraryAccess().getAlternatives_0_1_2_4(), "rule__EMV2Library__Alternatives_0_1_2_4");
			builder.put(grammarAccess.getEMV2LibraryAccess().getAlternatives_1_6_4(), "rule__EMV2Library__Alternatives_1_6_4");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getAlternatives(), "rule__EMV2PathElementOrKind__Alternatives");
			builder.put(grammarAccess.getErrorTypesAccess().getAlternatives(), "rule__ErrorTypes__Alternatives");
			builder.put(grammarAccess.getTypeDefinitionAccess().getAlternatives_1(), "rule__TypeDefinition__Alternatives_1");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getAlternatives_1(), "rule__TypeSetDefinition__Alternatives_1");
			builder.put(grammarAccess.getTypeTokenOrNoErrorAccess().getAlternatives(), "rule__TypeTokenOrNoError__Alternatives");
			builder.put(grammarAccess.getTypeTokenConstraintNoErrorAccess().getAlternatives(), "rule__TypeTokenConstraintNoError__Alternatives");
			builder.put(grammarAccess.getTypeTransformationAccess().getAlternatives_0(), "rule__TypeTransformation__Alternatives_0");
			builder.put(grammarAccess.getErrorPropagationAccess().getAlternatives_1(), "rule__ErrorPropagation__Alternatives_1");
			builder.put(grammarAccess.getPropagationDirectionAccess().getAlternatives(), "rule__PropagationDirection__Alternatives");
			builder.put(grammarAccess.getPropagationKindAccess().getAlternatives(), "rule__PropagationKind__Alternatives");
			builder.put(grammarAccess.getErrorFlowAccess().getAlternatives(), "rule__ErrorFlow__Alternatives");
			builder.put(grammarAccess.getErrorSourceAccess().getAlternatives_4(), "rule__ErrorSource__Alternatives_4");
			builder.put(grammarAccess.getErrorSourceAccess().getAlternatives_6_1(), "rule__ErrorSource__Alternatives_6_1");
			builder.put(grammarAccess.getErrorSinkAccess().getAlternatives_4(), "rule__ErrorSink__Alternatives_4");
			builder.put(grammarAccess.getErrorPathAccess().getAlternatives_4(), "rule__ErrorPath__Alternatives_4");
			builder.put(grammarAccess.getErrorPathAccess().getAlternatives_7(), "rule__ErrorPath__Alternatives_7");
			builder.put(grammarAccess.getErrorPathAccess().getAlternatives_8(), "rule__ErrorPath__Alternatives_8");
			builder.put(grammarAccess.getIfConditionAccess().getAlternatives(), "rule__IfCondition__Alternatives");
			builder.put(grammarAccess.getErrorPropagationPointAccess().getAlternatives_1(), "rule__ErrorPropagationPoint__Alternatives_1");
			builder.put(grammarAccess.getQualifiedPropagationPointAccess().getAlternatives(), "rule__QualifiedPropagationPoint__Alternatives");
			builder.put(grammarAccess.getErrorBehaviorEventAccess().getAlternatives(), "rule__ErrorBehaviorEvent__Alternatives");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getAlternatives_1(), "rule__ErrorBehaviorTransition__Alternatives_1");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getAlternatives_5(), "rule__ErrorBehaviorTransition__Alternatives_5");
			builder.put(grammarAccess.getTransitionBranchAccess().getAlternatives_0(), "rule__TransitionBranch__Alternatives_0");
			builder.put(grammarAccess.getBranchValueAccess().getAlternatives_1(), "rule__BranchValue__Alternatives_1");
			builder.put(grammarAccess.getConditionTermAccess().getAlternatives(), "rule__ConditionTerm__Alternatives");
			builder.put(grammarAccess.getEMV2ErrorPropagationPathAccess().getAlternatives(), "rule__EMV2ErrorPropagationPath__Alternatives");
			builder.put(grammarAccess.getEventOrPropagationAccess().getAlternatives(), "rule__EventOrPropagation__Alternatives");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getAlternatives_1(), "rule__OutgoingPropagationCondition__Alternatives_1");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getAlternatives_5_0(), "rule__OutgoingPropagationCondition__Alternatives_5_0");
			builder.put(grammarAccess.getErrorDetectionAccess().getAlternatives_1(), "rule__ErrorDetection__Alternatives_1");
			builder.put(grammarAccess.getErrorCodeValueAccess().getAlternatives(), "rule__ErrorCodeValue__Alternatives");
			builder.put(grammarAccess.getCompositeStateAccess().getAlternatives_2(), "rule__CompositeState__Alternatives_2");
			builder.put(grammarAccess.getSConditionTermAccess().getAlternatives(), "rule__SConditionTerm__Alternatives");
			builder.put(grammarAccess.getSConditionElementAccess().getAlternatives_1(), "rule__SConditionElement__Alternatives_1");
			builder.put(grammarAccess.getQualifiedErrorBehaviorStateAccess().getAlternatives_2(), "rule__QualifiedErrorBehaviorState__Alternatives_2");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1(), "rule__ContainedPropertyAssociation__Alternatives_1");
			builder.put(grammarAccess.getPropertyExpressionAccess().getAlternatives(), "rule__PropertyExpression__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
			builder.put(grammarAccess.getPlusMinusAccess().getAlternatives(), "rule__PlusMinus__Alternatives");
			builder.put(grammarAccess.getSignedIntAccess().getAlternatives_0(), "rule__SignedInt__Alternatives_0");
			builder.put(grammarAccess.getSignedRealAccess().getAlternatives_0(), "rule__SignedReal__Alternatives_0");
			builder.put(grammarAccess.getNumAltAccess().getAlternatives(), "rule__NumAlt__Alternatives");
			builder.put(grammarAccess.getEMV2RootAccess().getGroup(), "rule__EMV2Root__Group__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup(), "rule__ErrorModelSubclause__Group__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_1(), "rule__ErrorModelSubclause__Group_1__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_1_3(), "rule__ErrorModelSubclause__Group_1_3__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_2(), "rule__ErrorModelSubclause__Group_2__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_3(), "rule__ErrorModelSubclause__Group_3__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_4(), "rule__ErrorModelSubclause__Group_4__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_5(), "rule__ErrorModelSubclause__Group_5__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_5_3(), "rule__ErrorModelSubclause__Group_5_3__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_6(), "rule__ErrorModelSubclause__Group_6__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_3(), "rule__ErrorModelSubclause__Group_6_3__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_4(), "rule__ErrorModelSubclause__Group_6_4__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_5(), "rule__ErrorModelSubclause__Group_6_5__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_6(), "rule__ErrorModelSubclause__Group_6_6__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_7(), "rule__ErrorModelSubclause__Group_6_7__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_6_8(), "rule__ErrorModelSubclause__Group_6_8__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_7(), "rule__ErrorModelSubclause__Group_7__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_7_3(), "rule__ErrorModelSubclause__Group_7_3__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_8(), "rule__ErrorModelSubclause__Group_8__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_8_2(), "rule__ErrorModelSubclause__Group_8_2__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_9(), "rule__ErrorModelSubclause__Group_9__0");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getGroup_10(), "rule__ErrorModelSubclause__Group_10__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup(), "rule__EMV2Subclause__Group__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_3(), "rule__EMV2Subclause__Group_3__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_3_3(), "rule__EMV2Subclause__Group_3_3__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_4(), "rule__EMV2Subclause__Group_4__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_5(), "rule__EMV2Subclause__Group_5__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_6(), "rule__EMV2Subclause__Group_6__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_7(), "rule__EMV2Subclause__Group_7__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_7_3(), "rule__EMV2Subclause__Group_7_3__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_8(), "rule__EMV2Subclause__Group_8__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_8_3(), "rule__EMV2Subclause__Group_8_3__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_8_4(), "rule__EMV2Subclause__Group_8_4__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_8_5(), "rule__EMV2Subclause__Group_8_5__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_8_6(), "rule__EMV2Subclause__Group_8_6__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_8_7(), "rule__EMV2Subclause__Group_8_7__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_8_8(), "rule__EMV2Subclause__Group_8_8__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_9(), "rule__EMV2Subclause__Group_9__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_9_3(), "rule__EMV2Subclause__Group_9_3__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_10(), "rule__EMV2Subclause__Group_10__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_10_2(), "rule__EMV2Subclause__Group_10_2__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_11(), "rule__EMV2Subclause__Group_11__0");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getGroup_12(), "rule__EMV2Subclause__Group_12__0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getGroup(), "rule__ErrorModelLibrary__Group__0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getGroup_1(), "rule__ErrorModelLibrary__Group_1__0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getGroup_1_2(), "rule__ErrorModelLibrary__Group_1_2__0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getGroup_1_2_3(), "rule__ErrorModelLibrary__Group_1_2_3__0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getGroup_1_3(), "rule__ErrorModelLibrary__Group_1_3__0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getGroup_1_3_2(), "rule__ErrorModelLibrary__Group_1_3_2__0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getGroup_1_5(), "rule__ErrorModelLibrary__Group_1_5__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0(), "rule__EMV2Library__Group_0__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0_1(), "rule__EMV2Library__Group_0_1__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2(), "rule__EMV2Library__Group_0_1_2__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_2(), "rule__EMV2Library__Group_0_1_2_2__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_2_3(), "rule__EMV2Library__Group_0_1_2_2_3__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_3(), "rule__EMV2Library__Group_0_1_2_3__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_3_2(), "rule__EMV2Library__Group_0_1_2_3_2__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_0_1_2_5(), "rule__EMV2Library__Group_0_1_2_5__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_1(), "rule__EMV2Library__Group_1__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_1_6(), "rule__EMV2Library__Group_1_6__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_2(), "rule__EMV2Library__Group_1_6_2__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_2_3(), "rule__EMV2Library__Group_1_6_2_3__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_3(), "rule__EMV2Library__Group_1_6_3__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_3_2(), "rule__EMV2Library__Group_1_6_3_2__0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getGroup_1_6_5(), "rule__EMV2Library__Group_1_6_5__0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getGroup(), "rule__EMV2PropertyAssociation__Group__0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_2(), "rule__EMV2PropertyAssociation__Group_2__0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_2_1(), "rule__EMV2PropertyAssociation__Group_2_1__0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3(), "rule__EMV2PropertyAssociation__Group_3__0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3_2(), "rule__EMV2PropertyAssociation__Group_3_2__0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getGroup_3_2_1(), "rule__EMV2PropertyAssociation__Group_3_2_1__0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup(), "rule__BasicEMV2PropertyAssociation__Group__0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_2(), "rule__BasicEMV2PropertyAssociation__Group_2__0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_2_1(), "rule__BasicEMV2PropertyAssociation__Group_2_1__0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3(), "rule__BasicEMV2PropertyAssociation__Group_3__0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3_2(), "rule__BasicEMV2PropertyAssociation__Group_3_2__0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getGroup_3_2_1(), "rule__BasicEMV2PropertyAssociation__Group_3_2_1__0");
			builder.put(grammarAccess.getEMV2PathAccess().getGroup(), "rule__EMV2Path__Group__0");
			builder.put(grammarAccess.getEMV2PathAccess().getGroup_0(), "rule__EMV2Path__Group_0__0");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_0(), "rule__EMV2PathElementOrKind__Group_0__0");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_0_1(), "rule__EMV2PathElementOrKind__Group_0_1__0");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_1(), "rule__EMV2PathElementOrKind__Group_1__0");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getGroup_1_1(), "rule__EMV2PathElementOrKind__Group_1_1__0");
			builder.put(grammarAccess.getEMV2PathElementAccess().getGroup(), "rule__EMV2PathElement__Group__0");
			builder.put(grammarAccess.getEMV2PathElementAccess().getGroup_1(), "rule__EMV2PathElement__Group_1__0");
			builder.put(grammarAccess.getTypeDefinitionAccess().getGroup(), "rule__TypeDefinition__Group__0");
			builder.put(grammarAccess.getTypeDefinitionAccess().getGroup_1_0(), "rule__TypeDefinition__Group_1_0__0");
			builder.put(grammarAccess.getTypeDefinitionAccess().getGroup_1_1(), "rule__TypeDefinition__Group_1_1__0");
			builder.put(grammarAccess.getTypeDefinitionAccess().getGroup_1_2(), "rule__TypeDefinition__Group_1_2__0");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getGroup(), "rule__TypeSetDefinition__Group__0");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_0(), "rule__TypeSetDefinition__Group_1_0__0");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_0_5(), "rule__TypeSetDefinition__Group_1_0_5__0");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getGroup_1_1(), "rule__TypeSetDefinition__Group_1_1__0");
			builder.put(grammarAccess.getTypeSetConstructorAccess().getGroup(), "rule__TypeSetConstructor__Group__0");
			builder.put(grammarAccess.getTypeSetConstructorAccess().getGroup_2(), "rule__TypeSetConstructor__Group_2__0");
			builder.put(grammarAccess.getTypeSetElementAccess().getGroup(), "rule__TypeSetElement__Group__0");
			builder.put(grammarAccess.getTypeSetElementAccess().getGroup_1(), "rule__TypeSetElement__Group_1__0");
			builder.put(grammarAccess.getNoErrorTypeSetAccess().getGroup(), "rule__NoErrorTypeSet__Group__0");
			builder.put(grammarAccess.getNoErrorTypeTokenAccess().getGroup(), "rule__NoErrorTypeToken__Group__0");
			builder.put(grammarAccess.getTypeTransformationSetAccess().getGroup(), "rule__TypeTransformationSet__Group__0");
			builder.put(grammarAccess.getTypeTransformationSetAccess().getGroup_3(), "rule__TypeTransformationSet__Group_3__0");
			builder.put(grammarAccess.getTypeTransformationSetAccess().getGroup_3_3(), "rule__TypeTransformationSet__Group_3_3__0");
			builder.put(grammarAccess.getTypeTransformationAccess().getGroup(), "rule__TypeTransformation__Group__0");
			builder.put(grammarAccess.getTypeMappingSetAccess().getGroup(), "rule__TypeMappingSet__Group__0");
			builder.put(grammarAccess.getTypeMappingSetAccess().getGroup_3(), "rule__TypeMappingSet__Group_3__0");
			builder.put(grammarAccess.getTypeMappingSetAccess().getGroup_3_3(), "rule__TypeMappingSet__Group_3_3__0");
			builder.put(grammarAccess.getTypeMappingAccess().getGroup(), "rule__TypeMapping__Group__0");
			builder.put(grammarAccess.getErrorPropagationAccess().getGroup(), "rule__ErrorPropagation__Group__0");
			builder.put(grammarAccess.getFeatureorPPReferenceAccess().getGroup(), "rule__FeatureorPPReference__Group__0");
			builder.put(grammarAccess.getFeatureorPPReferenceAccess().getGroup_1(), "rule__FeatureorPPReference__Group_1__0");
			builder.put(grammarAccess.getErrorSourceAccess().getGroup(), "rule__ErrorSource__Group__0");
			builder.put(grammarAccess.getErrorSourceAccess().getGroup_6(), "rule__ErrorSource__Group_6__0");
			builder.put(grammarAccess.getErrorSourceAccess().getGroup_6_1_0(), "rule__ErrorSource__Group_6_1_0__0");
			builder.put(grammarAccess.getErrorSourceAccess().getGroup_7(), "rule__ErrorSource__Group_7__0");
			builder.put(grammarAccess.getErrorSinkAccess().getGroup(), "rule__ErrorSink__Group__0");
			builder.put(grammarAccess.getErrorSinkAccess().getGroup_6(), "rule__ErrorSink__Group_6__0");
			builder.put(grammarAccess.getErrorPathAccess().getGroup(), "rule__ErrorPath__Group__0");
			builder.put(grammarAccess.getErrorPathAccess().getGroup_8_1(), "rule__ErrorPath__Group_8_1__0");
			builder.put(grammarAccess.getErrorPathAccess().getGroup_9(), "rule__ErrorPath__Group_9__0");
			builder.put(grammarAccess.getErrorPropagationPointAccess().getGroup(), "rule__ErrorPropagationPoint__Group__0");
			builder.put(grammarAccess.getErrorPropagationPointAccess().getGroup_0(), "rule__ErrorPropagationPoint__Group_0__0");
			builder.put(grammarAccess.getPropagationPointAccess().getGroup(), "rule__PropagationPoint__Group__0");
			builder.put(grammarAccess.getPropagationPathAccess().getGroup(), "rule__PropagationPath__Group__0");
			builder.put(grammarAccess.getPropagationPathAccess().getGroup_0(), "rule__PropagationPath__Group_0__0");
			builder.put(grammarAccess.getQualifiedPropagationPointAccess().getGroup_0(), "rule__QualifiedPropagationPoint__Group_0__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup(), "rule__ErrorBehaviorStateMachine__Group__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_3(), "rule__ErrorBehaviorStateMachine__Group_3__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_3_3(), "rule__ErrorBehaviorStateMachine__Group_3_3__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_4(), "rule__ErrorBehaviorStateMachine__Group_4__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_5(), "rule__ErrorBehaviorStateMachine__Group_5__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_6(), "rule__ErrorBehaviorStateMachine__Group_6__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_7(), "rule__ErrorBehaviorStateMachine__Group_7__0");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getGroup_8(), "rule__ErrorBehaviorStateMachine__Group_8__0");
			builder.put(grammarAccess.getErrorEventAccess().getGroup(), "rule__ErrorEvent__Group__0");
			builder.put(grammarAccess.getErrorEventAccess().getGroup_5(), "rule__ErrorEvent__Group_5__0");
			builder.put(grammarAccess.getRepairEventAccess().getGroup(), "rule__RepairEvent__Group__0");
			builder.put(grammarAccess.getRepairEventAccess().getGroup_4(), "rule__RepairEvent__Group_4__0");
			builder.put(grammarAccess.getRepairEventAccess().getGroup_4_2(), "rule__RepairEvent__Group_4_2__0");
			builder.put(grammarAccess.getRecoverEventAccess().getGroup(), "rule__RecoverEvent__Group__0");
			builder.put(grammarAccess.getRecoverEventAccess().getGroup_4(), "rule__RecoverEvent__Group_4__0");
			builder.put(grammarAccess.getRecoverEventAccess().getGroup_4_2(), "rule__RecoverEvent__Group_4_2__0");
			builder.put(grammarAccess.getRecoverEventAccess().getGroup_5(), "rule__RecoverEvent__Group_5__0");
			builder.put(grammarAccess.getErrorBehaviorStateAccess().getGroup(), "rule__ErrorBehaviorState__Group__0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getGroup(), "rule__ErrorBehaviorTransition__Group__0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_0(), "rule__ErrorBehaviorTransition__Group_0__0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_1_0(), "rule__ErrorBehaviorTransition__Group_1_0__0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_0(), "rule__ErrorBehaviorTransition__Group_5_0__0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_1(), "rule__ErrorBehaviorTransition__Group_5_1__0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2(), "rule__ErrorBehaviorTransition__Group_5_2__0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getGroup_5_2_2(), "rule__ErrorBehaviorTransition__Group_5_2_2__0");
			builder.put(grammarAccess.getTransitionBranchAccess().getGroup(), "rule__TransitionBranch__Group__0");
			builder.put(grammarAccess.getTransitionBranchAccess().getGroup_0_0(), "rule__TransitionBranch__Group_0_0__0");
			builder.put(grammarAccess.getTransitionBranchAccess().getGroup_0_1(), "rule__TransitionBranch__Group_0_1__0");
			builder.put(grammarAccess.getBranchValueAccess().getGroup(), "rule__BranchValue__Group__0");
			builder.put(grammarAccess.getConditionExpressionAccess().getGroup(), "rule__ConditionExpression__Group__0");
			builder.put(grammarAccess.getConditionExpressionAccess().getGroup_1(), "rule__ConditionExpression__Group_1__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
			builder.put(grammarAccess.getAllExpressionAccess().getGroup(), "rule__AllExpression__Group__0");
			builder.put(grammarAccess.getAllExpressionAccess().getGroup_2(), "rule__AllExpression__Group_2__0");
			builder.put(grammarAccess.getAllExpressionAccess().getGroup_5(), "rule__AllExpression__Group_5__0");
			builder.put(grammarAccess.getOrmoreExpressionAccess().getGroup(), "rule__OrmoreExpression__Group__0");
			builder.put(grammarAccess.getOrmoreExpressionAccess().getGroup_4(), "rule__OrmoreExpression__Group_4__0");
			builder.put(grammarAccess.getOrlessExpressionAccess().getGroup(), "rule__OrlessExpression__Group__0");
			builder.put(grammarAccess.getOrlessExpressionAccess().getGroup_4(), "rule__OrlessExpression__Group_4__0");
			builder.put(grammarAccess.getConditionTermAccess().getGroup_4(), "rule__ConditionTerm__Group_4__0");
			builder.put(grammarAccess.getConditionElementAccess().getGroup(), "rule__ConditionElement__Group__0");
			builder.put(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getGroup(), "rule__QualifiedErrorEventOrPropagation__Group__0");
			builder.put(grammarAccess.getEMV2ErrorPropagationPathAccess().getGroup_1(), "rule__EMV2ErrorPropagationPath__Group_1__0");
			builder.put(grammarAccess.getEMV2ErrorPropagationPathAccess().getGroup_1_1(), "rule__EMV2ErrorPropagationPath__Group_1_1__0");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getGroup(), "rule__OutgoingPropagationCondition__Group__0");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_0(), "rule__OutgoingPropagationCondition__Group_0__0");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_1_0(), "rule__OutgoingPropagationCondition__Group_1_0__0");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getGroup_5(), "rule__OutgoingPropagationCondition__Group_5__0");
			builder.put(grammarAccess.getErrorDetectionAccess().getGroup(), "rule__ErrorDetection__Group__0");
			builder.put(grammarAccess.getErrorDetectionAccess().getGroup_0(), "rule__ErrorDetection__Group_0__0");
			builder.put(grammarAccess.getErrorDetectionAccess().getGroup_1_0(), "rule__ErrorDetection__Group_1_0__0");
			builder.put(grammarAccess.getErrorDetectionAccess().getGroup_7(), "rule__ErrorDetection__Group_7__0");
			builder.put(grammarAccess.getReportingPortReferenceAccess().getGroup(), "rule__ReportingPortReference__Group__0");
			builder.put(grammarAccess.getReportingPortReferenceAccess().getGroup_1(), "rule__ReportingPortReference__Group_1__0");
			builder.put(grammarAccess.getErrorStateToModeMappingAccess().getGroup(), "rule__ErrorStateToModeMapping__Group__0");
			builder.put(grammarAccess.getErrorStateToModeMappingAccess().getGroup_6(), "rule__ErrorStateToModeMapping__Group_6__0");
			builder.put(grammarAccess.getCompositeStateAccess().getGroup(), "rule__CompositeState__Group__0");
			builder.put(grammarAccess.getCompositeStateAccess().getGroup_0(), "rule__CompositeState__Group_0__0");
			builder.put(grammarAccess.getSConditionExpressionAccess().getGroup(), "rule__SConditionExpression__Group__0");
			builder.put(grammarAccess.getSConditionExpressionAccess().getGroup_1(), "rule__SConditionExpression__Group_1__0");
			builder.put(grammarAccess.getSAndExpressionAccess().getGroup(), "rule__SAndExpression__Group__0");
			builder.put(grammarAccess.getSAndExpressionAccess().getGroup_1(), "rule__SAndExpression__Group_1__0");
			builder.put(grammarAccess.getSOrmoreExpressionAccess().getGroup(), "rule__SOrmoreExpression__Group__0");
			builder.put(grammarAccess.getSOrmoreExpressionAccess().getGroup_4(), "rule__SOrmoreExpression__Group_4__0");
			builder.put(grammarAccess.getSOrlessExpressionAccess().getGroup(), "rule__SOrlessExpression__Group__0");
			builder.put(grammarAccess.getSOrlessExpressionAccess().getGroup_4(), "rule__SOrlessExpression__Group_4__0");
			builder.put(grammarAccess.getSAllExpressionAccess().getGroup(), "rule__SAllExpression__Group__0");
			builder.put(grammarAccess.getSAllExpressionAccess().getGroup_2(), "rule__SAllExpression__Group_2__0");
			builder.put(grammarAccess.getSAllExpressionAccess().getGroup_5(), "rule__SAllExpression__Group_5__0");
			builder.put(grammarAccess.getSConditionTermAccess().getGroup_4(), "rule__SConditionTerm__Group_4__0");
			builder.put(grammarAccess.getQualifiedErrorPropagationAccess().getGroup(), "rule__QualifiedErrorPropagation__Group__0");
			builder.put(grammarAccess.getSConditionElementAccess().getGroup(), "rule__SConditionElement__Group__0");
			builder.put(grammarAccess.getSConditionElementAccess().getGroup_1_0(), "rule__SConditionElement__Group_1_0__0");
			builder.put(grammarAccess.getSConditionElementAccess().getGroup_1_1(), "rule__SConditionElement__Group_1_1__0");
			builder.put(grammarAccess.getSConditionElementAccess().getGroup_1_1_1(), "rule__SConditionElement__Group_1_1_1__0");
			builder.put(grammarAccess.getQualifiedErrorBehaviorStateAccess().getGroup(), "rule__QualifiedErrorBehaviorState__Group__0");
			builder.put(grammarAccess.getQUALIFIEDNAMEAccess().getGroup(), "rule__QUALIFIEDNAME__Group__0");
			builder.put(grammarAccess.getQUALIFIEDNAMEAccess().getGroup_1(), "rule__QUALIFIEDNAME__Group_1__0");
			builder.put(grammarAccess.getQEMREFAccess().getGroup(), "rule__QEMREF__Group__0");
			builder.put(grammarAccess.getQEMREFAccess().getGroup_1(), "rule__QEMREF__Group_1__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup(), "rule__ContainedPropertyAssociation__Group__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3(), "rule__ContainedPropertyAssociation__Group_3__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1(), "rule__ContainedPropertyAssociation__Group_3_1__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4(), "rule__ContainedPropertyAssociation__Group_4__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_2(), "rule__ContainedPropertyAssociation__Group_4_2__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5(), "rule__ContainedPropertyAssociation__Group_5__0");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getGroup(), "rule__BasicPropertyAssociation__Group__0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getGroup(), "rule__ModalPropertyValue__Group__0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getGroup_4(), "rule__ModalPropertyValue__Group_4__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup(), "rule__OptionalModalPropertyValue__Group__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1(), "rule__OptionalModalPropertyValue__Group_1__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_3(), "rule__OptionalModalPropertyValue__Group_1_3__0");
			builder.put(grammarAccess.getBooleanLiteralAccess().getGroup(), "rule__BooleanLiteral__Group__0");
			builder.put(grammarAccess.getReferenceTermAccess().getGroup(), "rule__ReferenceTerm__Group__0");
			builder.put(grammarAccess.getRecordTermAccess().getGroup(), "rule__RecordTerm__Group__0");
			builder.put(grammarAccess.getOldRecordTermAccess().getGroup(), "rule__OldRecordTerm__Group__0");
			builder.put(grammarAccess.getComputedTermAccess().getGroup(), "rule__ComputedTerm__Group__0");
			builder.put(grammarAccess.getComponentClassifierTermAccess().getGroup(), "rule__ComponentClassifierTerm__Group__0");
			builder.put(grammarAccess.getListTermAccess().getGroup(), "rule__ListTerm__Group__0");
			builder.put(grammarAccess.getListTermAccess().getGroup_2(), "rule__ListTerm__Group_2__0");
			builder.put(grammarAccess.getListTermAccess().getGroup_2_1(), "rule__ListTerm__Group_2_1__0");
			builder.put(grammarAccess.getFieldPropertyAssociationAccess().getGroup(), "rule__FieldPropertyAssociation__Group__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup(), "rule__ContainmentPathElement__Group__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup_0(), "rule__ContainmentPathElement__Group_0__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup_1(), "rule__ContainmentPathElement__Group_1__0");
			builder.put(grammarAccess.getANNEXREFAccess().getGroup(), "rule__ANNEXREF__Group__0");
			builder.put(grammarAccess.getArrayRangeAccess().getGroup(), "rule__ArrayRange__Group__0");
			builder.put(grammarAccess.getArrayRangeAccess().getGroup_3(), "rule__ArrayRange__Group_3__0");
			builder.put(grammarAccess.getSignedConstantAccess().getGroup(), "rule__SignedConstant__Group__0");
			builder.put(grammarAccess.getIntegerTermAccess().getGroup(), "rule__IntegerTerm__Group__0");
			builder.put(grammarAccess.getSignedIntAccess().getGroup(), "rule__SignedInt__Group__0");
			builder.put(grammarAccess.getRealTermAccess().getGroup(), "rule__RealTerm__Group__0");
			builder.put(grammarAccess.getSignedRealAccess().getGroup(), "rule__SignedReal__Group__0");
			builder.put(grammarAccess.getNumericRangeTermAccess().getGroup(), "rule__NumericRangeTerm__Group__0");
			builder.put(grammarAccess.getNumericRangeTermAccess().getGroup_3(), "rule__NumericRangeTerm__Group_3__0");
			builder.put(grammarAccess.getAppliesToKeywordsAccess().getGroup(), "rule__AppliesToKeywords__Group__0");
			builder.put(grammarAccess.getInBindingKeywordsAccess().getGroup(), "rule__InBindingKeywords__Group__0");
			builder.put(grammarAccess.getInModesKeywordsAccess().getGroup(), "rule__InModesKeywords__Group__0");
			builder.put(grammarAccess.getQCLREFAccess().getGroup(), "rule__QCLREF__Group__0");
			builder.put(grammarAccess.getQPREFAccess().getGroup(), "rule__QPREF__Group__0");
			builder.put(grammarAccess.getQPREFAccess().getGroup_1(), "rule__QPREF__Group_1__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup(), "rule__QCREF__Group__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup_0(), "rule__QCREF__Group_0__0");
			builder.put(grammarAccess.getQCREFAccess().getGroup_2(), "rule__QCREF__Group_2__0");
			builder.put(grammarAccess.getEMV2RootAccess().getLibraryAssignment_1_0(), "rule__EMV2Root__LibraryAssignment_1_0");
			builder.put(grammarAccess.getEMV2RootAccess().getSubclausesAssignment_1_1(), "rule__EMV2Root__SubclausesAssignment_1_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getUseTypesAssignment_1_2(), "rule__ErrorModelSubclause__UseTypesAssignment_1_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getUseTypesAssignment_1_3_1(), "rule__ErrorModelSubclause__UseTypesAssignment_1_3_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getTypeEquivalenceAssignment_2_3(), "rule__ErrorModelSubclause__TypeEquivalenceAssignment_2_3");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getTypeMappingSetAssignment_3_2(), "rule__ErrorModelSubclause__TypeMappingSetAssignment_3_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getUseBehaviorAssignment_4_2(), "rule__ErrorModelSubclause__UseBehaviorAssignment_4_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getPropagationsAssignment_5_2(), "rule__ErrorModelSubclause__PropagationsAssignment_5_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getFlowsAssignment_5_3_1(), "rule__ErrorModelSubclause__FlowsAssignment_5_3_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getUseTransformationAssignment_6_3_2(), "rule__ErrorModelSubclause__UseTransformationAssignment_6_3_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getEventsAssignment_6_4_1(), "rule__ErrorModelSubclause__EventsAssignment_6_4_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getTransitionsAssignment_6_5_1(), "rule__ErrorModelSubclause__TransitionsAssignment_6_5_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getOutgoingPropagationConditionsAssignment_6_6_1(), "rule__ErrorModelSubclause__OutgoingPropagationConditionsAssignment_6_6_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getErrorDetectionsAssignment_6_7_1(), "rule__ErrorModelSubclause__ErrorDetectionsAssignment_6_7_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getErrorStateToModeMappingsAssignment_6_8_2(), "rule__ErrorModelSubclause__ErrorStateToModeMappingsAssignment_6_8_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getStatesAssignment_7_3_1(), "rule__ErrorModelSubclause__StatesAssignment_7_3_1");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getTypeTransformationSetAssignment_8_2_2(), "rule__ErrorModelSubclause__TypeTransformationSetAssignment_8_2_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getConnectionErrorSourcesAssignment_8_3(), "rule__ErrorModelSubclause__ConnectionErrorSourcesAssignment_8_3");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getPointsAssignment_9_2(), "rule__ErrorModelSubclause__PointsAssignment_9_2");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getPathsAssignment_9_3(), "rule__ErrorModelSubclause__PathsAssignment_9_3");
			builder.put(grammarAccess.getErrorModelSubclauseAccess().getPropertiesAssignment_10_1(), "rule__ErrorModelSubclause__PropertiesAssignment_10_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getNameAssignment_2(), "rule__EMV2Subclause__NameAssignment_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getUseTypesAssignment_3_2(), "rule__EMV2Subclause__UseTypesAssignment_3_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getUseTypesAssignment_3_3_1(), "rule__EMV2Subclause__UseTypesAssignment_3_3_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getTypeEquivalenceAssignment_4_3(), "rule__EMV2Subclause__TypeEquivalenceAssignment_4_3");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getTypeMappingSetAssignment_5_2(), "rule__EMV2Subclause__TypeMappingSetAssignment_5_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getUseBehaviorAssignment_6_2(), "rule__EMV2Subclause__UseBehaviorAssignment_6_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getPropagationsAssignment_7_2(), "rule__EMV2Subclause__PropagationsAssignment_7_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getFlowsAssignment_7_3_1(), "rule__EMV2Subclause__FlowsAssignment_7_3_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getUseTransformationAssignment_8_3_2(), "rule__EMV2Subclause__UseTransformationAssignment_8_3_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getEventsAssignment_8_4_1(), "rule__EMV2Subclause__EventsAssignment_8_4_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getTransitionsAssignment_8_5_1(), "rule__EMV2Subclause__TransitionsAssignment_8_5_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getOutgoingPropagationConditionsAssignment_8_6_1(), "rule__EMV2Subclause__OutgoingPropagationConditionsAssignment_8_6_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getErrorDetectionsAssignment_8_7_1(), "rule__EMV2Subclause__ErrorDetectionsAssignment_8_7_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getErrorStateToModeMappingsAssignment_8_8_2(), "rule__EMV2Subclause__ErrorStateToModeMappingsAssignment_8_8_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getStatesAssignment_9_3_1(), "rule__EMV2Subclause__StatesAssignment_9_3_1");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getTypeTransformationSetAssignment_10_2_2(), "rule__EMV2Subclause__TypeTransformationSetAssignment_10_2_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getConnectionErrorSourcesAssignment_10_3(), "rule__EMV2Subclause__ConnectionErrorSourcesAssignment_10_3");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getPointsAssignment_11_2(), "rule__EMV2Subclause__PointsAssignment_11_2");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getPathsAssignment_11_3(), "rule__EMV2Subclause__PathsAssignment_11_3");
			builder.put(grammarAccess.getEMV2SubclauseAccess().getPropertiesAssignment_12_1(), "rule__EMV2Subclause__PropertiesAssignment_12_1");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getUseTypesAssignment_1_2_2(), "rule__ErrorModelLibrary__UseTypesAssignment_1_2_2");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getUseTypesAssignment_1_2_3_1(), "rule__ErrorModelLibrary__UseTypesAssignment_1_2_3_1");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getExtendsAssignment_1_3_1(), "rule__ErrorModelLibrary__ExtendsAssignment_1_3_1");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getExtendsAssignment_1_3_2_1(), "rule__ErrorModelLibrary__ExtendsAssignment_1_3_2_1");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getTypesAssignment_1_4_0(), "rule__ErrorModelLibrary__TypesAssignment_1_4_0");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getTypesetsAssignment_1_4_1(), "rule__ErrorModelLibrary__TypesetsAssignment_1_4_1");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getPropertiesAssignment_1_5_1(), "rule__ErrorModelLibrary__PropertiesAssignment_1_5_1");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getBehaviorsAssignment_2(), "rule__ErrorModelLibrary__BehaviorsAssignment_2");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getMappingsAssignment_3(), "rule__ErrorModelLibrary__MappingsAssignment_3");
			builder.put(grammarAccess.getErrorModelLibraryAccess().getTransformationsAssignment_4(), "rule__ErrorModelLibrary__TransformationsAssignment_4");
			builder.put(grammarAccess.getEMV2LibraryAccess().getNameAssignment_0_1_1(), "rule__EMV2Library__NameAssignment_0_1_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_0_1_2_2_2(), "rule__EMV2Library__UseTypesAssignment_0_1_2_2_2");
			builder.put(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_0_1_2_2_3_1(), "rule__EMV2Library__UseTypesAssignment_0_1_2_2_3_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_0_1_2_3_1(), "rule__EMV2Library__ExtendsAssignment_0_1_2_3_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_0_1_2_3_2_1(), "rule__EMV2Library__ExtendsAssignment_0_1_2_3_2_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getTypesAssignment_0_1_2_4_0(), "rule__EMV2Library__TypesAssignment_0_1_2_4_0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getTypesetsAssignment_0_1_2_4_1(), "rule__EMV2Library__TypesetsAssignment_0_1_2_4_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_0_1_2_5_1(), "rule__EMV2Library__PropertiesAssignment_0_1_2_5_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getBehaviorsAssignment_0_1_3(), "rule__EMV2Library__BehaviorsAssignment_0_1_3");
			builder.put(grammarAccess.getEMV2LibraryAccess().getMappingsAssignment_0_1_4(), "rule__EMV2Library__MappingsAssignment_0_1_4");
			builder.put(grammarAccess.getEMV2LibraryAccess().getTransformationsAssignment_0_1_5(), "rule__EMV2Library__TransformationsAssignment_0_1_5");
			builder.put(grammarAccess.getEMV2LibraryAccess().getNameAssignment_1_1(), "rule__EMV2Library__NameAssignment_1_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_1_6_2_2(), "rule__EMV2Library__UseTypesAssignment_1_6_2_2");
			builder.put(grammarAccess.getEMV2LibraryAccess().getUseTypesAssignment_1_6_2_3_1(), "rule__EMV2Library__UseTypesAssignment_1_6_2_3_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_1_6_3_1(), "rule__EMV2Library__ExtendsAssignment_1_6_3_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getExtendsAssignment_1_6_3_2_1(), "rule__EMV2Library__ExtendsAssignment_1_6_3_2_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getTypesAssignment_1_6_4_0(), "rule__EMV2Library__TypesAssignment_1_6_4_0");
			builder.put(grammarAccess.getEMV2LibraryAccess().getTypesetsAssignment_1_6_4_1(), "rule__EMV2Library__TypesetsAssignment_1_6_4_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getPropertiesAssignment_1_6_5_1(), "rule__EMV2Library__PropertiesAssignment_1_6_5_1");
			builder.put(grammarAccess.getEMV2LibraryAccess().getBehaviorsAssignment_1_7(), "rule__EMV2Library__BehaviorsAssignment_1_7");
			builder.put(grammarAccess.getEMV2LibraryAccess().getMappingsAssignment_1_8(), "rule__EMV2Library__MappingsAssignment_1_8");
			builder.put(grammarAccess.getEMV2LibraryAccess().getTransformationsAssignment_1_9(), "rule__EMV2Library__TransformationsAssignment_1_9");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getPropertyAssignment_0(), "rule__EMV2PropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_0(), "rule__EMV2PropertyAssociation__OwnedValuesAssignment_2_0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_1_1(), "rule__EMV2PropertyAssociation__OwnedValuesAssignment_2_1_1");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_2_0(), "rule__EMV2PropertyAssociation__Emv2PathAssignment_3_2_0");
			builder.put(grammarAccess.getEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_2_1_1(), "rule__EMV2PropertyAssociation__Emv2PathAssignment_3_2_1_1");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getPropertyAssignment_0(), "rule__BasicEMV2PropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_0(), "rule__BasicEMV2PropertyAssociation__OwnedValuesAssignment_2_0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getOwnedValuesAssignment_2_1_1(), "rule__BasicEMV2PropertyAssociation__OwnedValuesAssignment_2_1_1");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_2_0(), "rule__BasicEMV2PropertyAssociation__Emv2PathAssignment_3_2_0");
			builder.put(grammarAccess.getBasicEMV2PropertyAssociationAccess().getEmv2PathAssignment_3_2_1_1(), "rule__BasicEMV2PropertyAssociation__Emv2PathAssignment_3_2_1_1");
			builder.put(grammarAccess.getEMV2PathAccess().getContainmentPathAssignment_0_1(), "rule__EMV2Path__ContainmentPathAssignment_0_1");
			builder.put(grammarAccess.getEMV2PathAccess().getEmv2TargetAssignment_1(), "rule__EMV2Path__Emv2TargetAssignment_1");
			builder.put(grammarAccess.getBasicEMV2PathAccess().getEmv2TargetAssignment(), "rule__BasicEMV2Path__Emv2TargetAssignment");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getEmv2PropagationKindAssignment_0_0(), "rule__EMV2PathElementOrKind__Emv2PropagationKindAssignment_0_0");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getErrorTypeAssignment_0_1_1(), "rule__EMV2PathElementOrKind__ErrorTypeAssignment_0_1_1");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getNamedElementAssignment_1_0(), "rule__EMV2PathElementOrKind__NamedElementAssignment_1_0");
			builder.put(grammarAccess.getEMV2PathElementOrKindAccess().getPathAssignment_1_1_1(), "rule__EMV2PathElementOrKind__PathAssignment_1_1_1");
			builder.put(grammarAccess.getEMV2PathElementAccess().getNamedElementAssignment_0(), "rule__EMV2PathElement__NamedElementAssignment_0");
			builder.put(grammarAccess.getEMV2PathElementAccess().getPathAssignment_1_1(), "rule__EMV2PathElement__PathAssignment_1_1");
			builder.put(grammarAccess.getTypeDefinitionAccess().getNameAssignment_0(), "rule__TypeDefinition__NameAssignment_0");
			builder.put(grammarAccess.getTypeDefinitionAccess().getSuperTypeAssignment_1_1_3(), "rule__TypeDefinition__SuperTypeAssignment_1_1_3");
			builder.put(grammarAccess.getTypeDefinitionAccess().getAliasedTypeAssignment_1_2_2(), "rule__TypeDefinition__AliasedTypeAssignment_1_2_2");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getNameAssignment_0(), "rule__TypeSetDefinition__NameAssignment_0");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensAssignment_1_0_4(), "rule__TypeSetDefinition__TypeTokensAssignment_1_0_4");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getTypeTokensAssignment_1_0_5_1(), "rule__TypeSetDefinition__TypeTokensAssignment_1_0_5_1");
			builder.put(grammarAccess.getTypeSetDefinitionAccess().getAliasedTypeAssignment_1_1_3(), "rule__TypeSetDefinition__AliasedTypeAssignment_1_1_3");
			builder.put(grammarAccess.getTypeSetConstructorAccess().getTypeTokensAssignment_1(), "rule__TypeSetConstructor__TypeTokensAssignment_1");
			builder.put(grammarAccess.getTypeSetConstructorAccess().getTypeTokensAssignment_2_1(), "rule__TypeSetConstructor__TypeTokensAssignment_2_1");
			builder.put(grammarAccess.getTypeSetElementAccess().getTypeAssignment_0(), "rule__TypeSetElement__TypeAssignment_0");
			builder.put(grammarAccess.getTypeSetElementAccess().getTypeAssignment_1_1(), "rule__TypeSetElement__TypeAssignment_1_1");
			builder.put(grammarAccess.getNoErrorTypeSetAccess().getTypeTokensAssignment_2(), "rule__NoErrorTypeSet__TypeTokensAssignment_2");
			builder.put(grammarAccess.getNoErrorTypeTokenAccess().getNoErrorAssignment_1(), "rule__NoErrorTypeToken__NoErrorAssignment_1");
			builder.put(grammarAccess.getTypeTransformationSetAccess().getNameAssignment_2(), "rule__TypeTransformationSet__NameAssignment_2");
			builder.put(grammarAccess.getTypeTransformationSetAccess().getUseTypesAssignment_3_2(), "rule__TypeTransformationSet__UseTypesAssignment_3_2");
			builder.put(grammarAccess.getTypeTransformationSetAccess().getUseTypesAssignment_3_3_1(), "rule__TypeTransformationSet__UseTypesAssignment_3_3_1");
			builder.put(grammarAccess.getTypeTransformationSetAccess().getTransformationAssignment_4(), "rule__TypeTransformationSet__TransformationAssignment_4");
			builder.put(grammarAccess.getTypeTransformationAccess().getSourceAssignment_0_0(), "rule__TypeTransformation__SourceAssignment_0_0");
			builder.put(grammarAccess.getTypeTransformationAccess().getAllSourcesAssignment_0_1(), "rule__TypeTransformation__AllSourcesAssignment_0_1");
			builder.put(grammarAccess.getTypeTransformationAccess().getContributorAssignment_2(), "rule__TypeTransformation__ContributorAssignment_2");
			builder.put(grammarAccess.getTypeTransformationAccess().getTargetAssignment_4(), "rule__TypeTransformation__TargetAssignment_4");
			builder.put(grammarAccess.getTypeMappingSetAccess().getNameAssignment_2(), "rule__TypeMappingSet__NameAssignment_2");
			builder.put(grammarAccess.getTypeMappingSetAccess().getUseTypesAssignment_3_2(), "rule__TypeMappingSet__UseTypesAssignment_3_2");
			builder.put(grammarAccess.getTypeMappingSetAccess().getUseTypesAssignment_3_3_1(), "rule__TypeMappingSet__UseTypesAssignment_3_3_1");
			builder.put(grammarAccess.getTypeMappingSetAccess().getMappingAssignment_4(), "rule__TypeMappingSet__MappingAssignment_4");
			builder.put(grammarAccess.getTypeMappingAccess().getSourceAssignment_0(), "rule__TypeMapping__SourceAssignment_0");
			builder.put(grammarAccess.getTypeMappingAccess().getTargetAssignment_2(), "rule__TypeMapping__TargetAssignment_2");
			builder.put(grammarAccess.getErrorPropagationAccess().getKindAssignment_1_0(), "rule__ErrorPropagation__KindAssignment_1_0");
			builder.put(grammarAccess.getErrorPropagationAccess().getFeatureorPPRefAssignment_1_1(), "rule__ErrorPropagation__FeatureorPPRefAssignment_1_1");
			builder.put(grammarAccess.getErrorPropagationAccess().getNotAssignment_3(), "rule__ErrorPropagation__NotAssignment_3");
			builder.put(grammarAccess.getErrorPropagationAccess().getDirectionAssignment_4(), "rule__ErrorPropagation__DirectionAssignment_4");
			builder.put(grammarAccess.getErrorPropagationAccess().getTypeSetAssignment_6(), "rule__ErrorPropagation__TypeSetAssignment_6");
			builder.put(grammarAccess.getFeatureorPPReferenceAccess().getFeatureorPPAssignment_0(), "rule__FeatureorPPReference__FeatureorPPAssignment_0");
			builder.put(grammarAccess.getFeatureorPPReferenceAccess().getNextAssignment_1_1(), "rule__FeatureorPPReference__NextAssignment_1_1");
			builder.put(grammarAccess.getErrorSourceAccess().getNameAssignment_0(), "rule__ErrorSource__NameAssignment_0");
			builder.put(grammarAccess.getErrorSourceAccess().getSourceModelElementAssignment_4_0(), "rule__ErrorSource__SourceModelElementAssignment_4_0");
			builder.put(grammarAccess.getErrorSourceAccess().getAllAssignment_4_1(), "rule__ErrorSource__AllAssignment_4_1");
			builder.put(grammarAccess.getErrorSourceAccess().getTypeTokenConstraintAssignment_5(), "rule__ErrorSource__TypeTokenConstraintAssignment_5");
			builder.put(grammarAccess.getErrorSourceAccess().getFailureModeReferenceAssignment_6_1_0_0(), "rule__ErrorSource__FailureModeReferenceAssignment_6_1_0_0");
			builder.put(grammarAccess.getErrorSourceAccess().getFailureModeTypeAssignment_6_1_0_1(), "rule__ErrorSource__FailureModeTypeAssignment_6_1_0_1");
			builder.put(grammarAccess.getErrorSourceAccess().getFailureModeTypeAssignment_6_1_1(), "rule__ErrorSource__FailureModeTypeAssignment_6_1_1");
			builder.put(grammarAccess.getErrorSourceAccess().getFailureModeDescriptionAssignment_6_1_2(), "rule__ErrorSource__FailureModeDescriptionAssignment_6_1_2");
			builder.put(grammarAccess.getErrorSourceAccess().getFlowconditionAssignment_7_1(), "rule__ErrorSource__FlowconditionAssignment_7_1");
			builder.put(grammarAccess.getErrorSinkAccess().getNameAssignment_0(), "rule__ErrorSink__NameAssignment_0");
			builder.put(grammarAccess.getErrorSinkAccess().getIncomingAssignment_4_0(), "rule__ErrorSink__IncomingAssignment_4_0");
			builder.put(grammarAccess.getErrorSinkAccess().getAllIncomingAssignment_4_1(), "rule__ErrorSink__AllIncomingAssignment_4_1");
			builder.put(grammarAccess.getErrorSinkAccess().getTypeTokenConstraintAssignment_5(), "rule__ErrorSink__TypeTokenConstraintAssignment_5");
			builder.put(grammarAccess.getErrorSinkAccess().getFlowconditionAssignment_6_1(), "rule__ErrorSink__FlowconditionAssignment_6_1");
			builder.put(grammarAccess.getErrorPathAccess().getNameAssignment_0(), "rule__ErrorPath__NameAssignment_0");
			builder.put(grammarAccess.getErrorPathAccess().getIncomingAssignment_4_0(), "rule__ErrorPath__IncomingAssignment_4_0");
			builder.put(grammarAccess.getErrorPathAccess().getAllIncomingAssignment_4_1(), "rule__ErrorPath__AllIncomingAssignment_4_1");
			builder.put(grammarAccess.getErrorPathAccess().getTypeTokenConstraintAssignment_5(), "rule__ErrorPath__TypeTokenConstraintAssignment_5");
			builder.put(grammarAccess.getErrorPathAccess().getOutgoingAssignment_7_0(), "rule__ErrorPath__OutgoingAssignment_7_0");
			builder.put(grammarAccess.getErrorPathAccess().getAllOutgoingAssignment_7_1(), "rule__ErrorPath__AllOutgoingAssignment_7_1");
			builder.put(grammarAccess.getErrorPathAccess().getTargetTokenAssignment_8_0(), "rule__ErrorPath__TargetTokenAssignment_8_0");
			builder.put(grammarAccess.getErrorPathAccess().getTypeMappingSetAssignment_8_1_2(), "rule__ErrorPath__TypeMappingSetAssignment_8_1_2");
			builder.put(grammarAccess.getErrorPathAccess().getFlowconditionAssignment_9_1(), "rule__ErrorPath__FlowconditionAssignment_9_1");
			builder.put(grammarAccess.getIfConditionAccess().getDescriptionAssignment_0(), "rule__IfCondition__DescriptionAssignment_0");
			builder.put(grammarAccess.getIfConditionAccess().getResoluteFunctionAssignment_1(), "rule__IfCondition__ResoluteFunctionAssignment_1");
			builder.put(grammarAccess.getIfConditionAccess().getJavaMethodAssignment_2(), "rule__IfCondition__JavaMethodAssignment_2");
			builder.put(grammarAccess.getPropagationPointAccess().getNameAssignment_0(), "rule__PropagationPoint__NameAssignment_0");
			builder.put(grammarAccess.getPropagationPathAccess().getNameAssignment_0_0(), "rule__PropagationPath__NameAssignment_0_0");
			builder.put(grammarAccess.getPropagationPathAccess().getSourceAssignment_1(), "rule__PropagationPath__SourceAssignment_1");
			builder.put(grammarAccess.getPropagationPathAccess().getTargetAssignment_3(), "rule__PropagationPath__TargetAssignment_3");
			builder.put(grammarAccess.getQualifiedPropagationPointAccess().getSubcomponentAssignment_0_0(), "rule__QualifiedPropagationPoint__SubcomponentAssignment_0_0");
			builder.put(grammarAccess.getQualifiedPropagationPointAccess().getNextAssignment_0_2(), "rule__QualifiedPropagationPoint__NextAssignment_0_2");
			builder.put(grammarAccess.getQualifiedPropagationPointAccess().getPropagationPointAssignment_1(), "rule__QualifiedPropagationPoint__PropagationPointAssignment_1");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getNameAssignment_2(), "rule__ErrorBehaviorStateMachine__NameAssignment_2");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesAssignment_3_2(), "rule__ErrorBehaviorStateMachine__UseTypesAssignment_3_2");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTypesAssignment_3_3_1(), "rule__ErrorBehaviorStateMachine__UseTypesAssignment_3_3_1");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getUseTransformationAssignment_4_2(), "rule__ErrorBehaviorStateMachine__UseTransformationAssignment_4_2");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsAssignment_5_1(), "rule__ErrorBehaviorStateMachine__EventsAssignment_5_1");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesAssignment_6_1(), "rule__ErrorBehaviorStateMachine__StatesAssignment_6_1");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsAssignment_7_1(), "rule__ErrorBehaviorStateMachine__TransitionsAssignment_7_1");
			builder.put(grammarAccess.getErrorBehaviorStateMachineAccess().getPropertiesAssignment_8_1(), "rule__ErrorBehaviorStateMachine__PropertiesAssignment_8_1");
			builder.put(grammarAccess.getErrorEventAccess().getNameAssignment_0(), "rule__ErrorEvent__NameAssignment_0");
			builder.put(grammarAccess.getErrorEventAccess().getTypeSetAssignment_4(), "rule__ErrorEvent__TypeSetAssignment_4");
			builder.put(grammarAccess.getErrorEventAccess().getEventconditionAssignment_5_1(), "rule__ErrorEvent__EventconditionAssignment_5_1");
			builder.put(grammarAccess.getRepairEventAccess().getNameAssignment_0(), "rule__RepairEvent__NameAssignment_0");
			builder.put(grammarAccess.getRepairEventAccess().getEventInitiatorAssignment_4_1(), "rule__RepairEvent__EventInitiatorAssignment_4_1");
			builder.put(grammarAccess.getRepairEventAccess().getEventInitiatorAssignment_4_2_1(), "rule__RepairEvent__EventInitiatorAssignment_4_2_1");
			builder.put(grammarAccess.getRecoverEventAccess().getNameAssignment_0(), "rule__RecoverEvent__NameAssignment_0");
			builder.put(grammarAccess.getRecoverEventAccess().getEventInitiatorAssignment_4_1(), "rule__RecoverEvent__EventInitiatorAssignment_4_1");
			builder.put(grammarAccess.getRecoverEventAccess().getEventInitiatorAssignment_4_2_1(), "rule__RecoverEvent__EventInitiatorAssignment_4_2_1");
			builder.put(grammarAccess.getRecoverEventAccess().getConditionAssignment_5_1(), "rule__RecoverEvent__ConditionAssignment_5_1");
			builder.put(grammarAccess.getErrorBehaviorStateAccess().getNameAssignment_0(), "rule__ErrorBehaviorState__NameAssignment_0");
			builder.put(grammarAccess.getErrorBehaviorStateAccess().getIntialAssignment_2(), "rule__ErrorBehaviorState__IntialAssignment_2");
			builder.put(grammarAccess.getErrorBehaviorStateAccess().getTypeSetAssignment_4(), "rule__ErrorBehaviorState__TypeSetAssignment_4");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getNameAssignment_0_0(), "rule__ErrorBehaviorTransition__NameAssignment_0_0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getSourceAssignment_1_0_0(), "rule__ErrorBehaviorTransition__SourceAssignment_1_0_0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getTypeTokenConstraintAssignment_1_0_1(), "rule__ErrorBehaviorTransition__TypeTokenConstraintAssignment_1_0_1");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getAllStatesAssignment_1_1(), "rule__ErrorBehaviorTransition__AllStatesAssignment_1_1");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getConditionAssignment_3(), "rule__ErrorBehaviorTransition__ConditionAssignment_3");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getTargetAssignment_5_0_0(), "rule__ErrorBehaviorTransition__TargetAssignment_5_0_0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getTargetTokenAssignment_5_0_1(), "rule__ErrorBehaviorTransition__TargetTokenAssignment_5_0_1");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getSteadyStateAssignment_5_1_0(), "rule__ErrorBehaviorTransition__SteadyStateAssignment_5_1_0");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesAssignment_5_2_1(), "rule__ErrorBehaviorTransition__DestinationBranchesAssignment_5_2_1");
			builder.put(grammarAccess.getErrorBehaviorTransitionAccess().getDestinationBranchesAssignment_5_2_2_1(), "rule__ErrorBehaviorTransition__DestinationBranchesAssignment_5_2_2_1");
			builder.put(grammarAccess.getTransitionBranchAccess().getTargetAssignment_0_0_0(), "rule__TransitionBranch__TargetAssignment_0_0_0");
			builder.put(grammarAccess.getTransitionBranchAccess().getTargetTokenAssignment_0_0_1(), "rule__TransitionBranch__TargetTokenAssignment_0_0_1");
			builder.put(grammarAccess.getTransitionBranchAccess().getSteadyStateAssignment_0_1_0(), "rule__TransitionBranch__SteadyStateAssignment_0_1_0");
			builder.put(grammarAccess.getTransitionBranchAccess().getValueAssignment_2(), "rule__TransitionBranch__ValueAssignment_2");
			builder.put(grammarAccess.getBranchValueAccess().getRealvalueAssignment_1_0(), "rule__BranchValue__RealvalueAssignment_1_0");
			builder.put(grammarAccess.getBranchValueAccess().getSymboliclabelAssignment_1_1(), "rule__BranchValue__SymboliclabelAssignment_1_1");
			builder.put(grammarAccess.getBranchValueAccess().getOthersAssignment_1_2(), "rule__BranchValue__OthersAssignment_1_2");
			builder.put(grammarAccess.getConditionExpressionAccess().getOperandsAssignment_1_2(), "rule__ConditionExpression__OperandsAssignment_1_2");
			builder.put(grammarAccess.getAndExpressionAccess().getOperandsAssignment_1_2(), "rule__AndExpression__OperandsAssignment_1_2");
			builder.put(grammarAccess.getAllExpressionAccess().getCountAssignment_2_1(), "rule__AllExpression__CountAssignment_2_1");
			builder.put(grammarAccess.getAllExpressionAccess().getOperandsAssignment_4(), "rule__AllExpression__OperandsAssignment_4");
			builder.put(grammarAccess.getAllExpressionAccess().getOperandsAssignment_5_1(), "rule__AllExpression__OperandsAssignment_5_1");
			builder.put(grammarAccess.getOrmoreExpressionAccess().getCountAssignment_0(), "rule__OrmoreExpression__CountAssignment_0");
			builder.put(grammarAccess.getOrmoreExpressionAccess().getOperandsAssignment_3(), "rule__OrmoreExpression__OperandsAssignment_3");
			builder.put(grammarAccess.getOrmoreExpressionAccess().getOperandsAssignment_4_1(), "rule__OrmoreExpression__OperandsAssignment_4_1");
			builder.put(grammarAccess.getOrlessExpressionAccess().getCountAssignment_0(), "rule__OrlessExpression__CountAssignment_0");
			builder.put(grammarAccess.getOrlessExpressionAccess().getOperandsAssignment_3(), "rule__OrlessExpression__OperandsAssignment_3");
			builder.put(grammarAccess.getOrlessExpressionAccess().getOperandsAssignment_4_1(), "rule__OrlessExpression__OperandsAssignment_4_1");
			builder.put(grammarAccess.getConditionElementAccess().getQualifiedErrorPropagationReferenceAssignment_0(), "rule__ConditionElement__QualifiedErrorPropagationReferenceAssignment_0");
			builder.put(grammarAccess.getConditionElementAccess().getConstraintAssignment_1(), "rule__ConditionElement__ConstraintAssignment_1");
			builder.put(grammarAccess.getQualifiedErrorEventOrPropagationAccess().getEmv2TargetAssignment_1(), "rule__QualifiedErrorEventOrPropagation__Emv2TargetAssignment_1");
			builder.put(grammarAccess.getEMV2ErrorPropagationPathAccess().getEmv2PropagationKindAssignment_0(), "rule__EMV2ErrorPropagationPath__Emv2PropagationKindAssignment_0");
			builder.put(grammarAccess.getEMV2ErrorPropagationPathAccess().getNamedElementAssignment_1_0(), "rule__EMV2ErrorPropagationPath__NamedElementAssignment_1_0");
			builder.put(grammarAccess.getEMV2ErrorPropagationPathAccess().getPathAssignment_1_1_1(), "rule__EMV2ErrorPropagationPath__PathAssignment_1_1_1");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getNameAssignment_0_0(), "rule__OutgoingPropagationCondition__NameAssignment_0_0");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getStateAssignment_1_0_0(), "rule__OutgoingPropagationCondition__StateAssignment_1_0_0");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenConstraintAssignment_1_0_1(), "rule__OutgoingPropagationCondition__TypeTokenConstraintAssignment_1_0_1");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getAllStatesAssignment_1_1(), "rule__OutgoingPropagationCondition__AllStatesAssignment_1_1");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getConditionAssignment_3(), "rule__OutgoingPropagationCondition__ConditionAssignment_3");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getOutgoingAssignment_5_0_0(), "rule__OutgoingPropagationCondition__OutgoingAssignment_5_0_0");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getAllPropagationsAssignment_5_0_1(), "rule__OutgoingPropagationCondition__AllPropagationsAssignment_5_0_1");
			builder.put(grammarAccess.getOutgoingPropagationConditionAccess().getTypeTokenAssignment_5_1(), "rule__OutgoingPropagationCondition__TypeTokenAssignment_5_1");
			builder.put(grammarAccess.getErrorDetectionAccess().getNameAssignment_0_0(), "rule__ErrorDetection__NameAssignment_0_0");
			builder.put(grammarAccess.getErrorDetectionAccess().getStateAssignment_1_0_0(), "rule__ErrorDetection__StateAssignment_1_0_0");
			builder.put(grammarAccess.getErrorDetectionAccess().getTypeTokenConstraintAssignment_1_0_1(), "rule__ErrorDetection__TypeTokenConstraintAssignment_1_0_1");
			builder.put(grammarAccess.getErrorDetectionAccess().getAllStatesAssignment_1_1(), "rule__ErrorDetection__AllStatesAssignment_1_1");
			builder.put(grammarAccess.getErrorDetectionAccess().getConditionAssignment_3(), "rule__ErrorDetection__ConditionAssignment_3");
			builder.put(grammarAccess.getErrorDetectionAccess().getDetectionReportingPortAssignment_5(), "rule__ErrorDetection__DetectionReportingPortAssignment_5");
			builder.put(grammarAccess.getErrorDetectionAccess().getErrorCodeAssignment_7_1(), "rule__ErrorDetection__ErrorCodeAssignment_7_1");
			builder.put(grammarAccess.getReportingPortReferenceAccess().getElementAssignment_0(), "rule__ReportingPortReference__ElementAssignment_0");
			builder.put(grammarAccess.getReportingPortReferenceAccess().getElementAssignment_1_2(), "rule__ReportingPortReference__ElementAssignment_1_2");
			builder.put(grammarAccess.getErrorCodeValueAccess().getIntValueAssignment_0(), "rule__ErrorCodeValue__IntValueAssignment_0");
			builder.put(grammarAccess.getErrorCodeValueAccess().getConstantAssignment_1(), "rule__ErrorCodeValue__ConstantAssignment_1");
			builder.put(grammarAccess.getErrorCodeValueAccess().getEnumLiteralAssignment_2(), "rule__ErrorCodeValue__EnumLiteralAssignment_2");
			builder.put(grammarAccess.getErrorStateToModeMappingAccess().getErrorStateAssignment_0(), "rule__ErrorStateToModeMapping__ErrorStateAssignment_0");
			builder.put(grammarAccess.getErrorStateToModeMappingAccess().getTypeTokenAssignment_1(), "rule__ErrorStateToModeMapping__TypeTokenAssignment_1");
			builder.put(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesAssignment_5(), "rule__ErrorStateToModeMapping__MappedModesAssignment_5");
			builder.put(grammarAccess.getErrorStateToModeMappingAccess().getMappedModesAssignment_6_1(), "rule__ErrorStateToModeMapping__MappedModesAssignment_6_1");
			builder.put(grammarAccess.getCompositeStateAccess().getNameAssignment_0_0(), "rule__CompositeState__NameAssignment_0_0");
			builder.put(grammarAccess.getCompositeStateAccess().getConditionAssignment_2_0(), "rule__CompositeState__ConditionAssignment_2_0");
			builder.put(grammarAccess.getCompositeStateAccess().getOthersAssignment_2_1(), "rule__CompositeState__OthersAssignment_2_1");
			builder.put(grammarAccess.getCompositeStateAccess().getStateAssignment_4(), "rule__CompositeState__StateAssignment_4");
			builder.put(grammarAccess.getCompositeStateAccess().getTypedTokenAssignment_5(), "rule__CompositeState__TypedTokenAssignment_5");
			builder.put(grammarAccess.getSConditionExpressionAccess().getOperandsAssignment_1_2(), "rule__SConditionExpression__OperandsAssignment_1_2");
			builder.put(grammarAccess.getSAndExpressionAccess().getOperandsAssignment_1_2(), "rule__SAndExpression__OperandsAssignment_1_2");
			builder.put(grammarAccess.getSOrmoreExpressionAccess().getCountAssignment_0(), "rule__SOrmoreExpression__CountAssignment_0");
			builder.put(grammarAccess.getSOrmoreExpressionAccess().getOperandsAssignment_3(), "rule__SOrmoreExpression__OperandsAssignment_3");
			builder.put(grammarAccess.getSOrmoreExpressionAccess().getOperandsAssignment_4_1(), "rule__SOrmoreExpression__OperandsAssignment_4_1");
			builder.put(grammarAccess.getSOrlessExpressionAccess().getCountAssignment_0(), "rule__SOrlessExpression__CountAssignment_0");
			builder.put(grammarAccess.getSOrlessExpressionAccess().getOperandsAssignment_3(), "rule__SOrlessExpression__OperandsAssignment_3");
			builder.put(grammarAccess.getSOrlessExpressionAccess().getOperandsAssignment_4_1(), "rule__SOrlessExpression__OperandsAssignment_4_1");
			builder.put(grammarAccess.getSAllExpressionAccess().getCountAssignment_2_1(), "rule__SAllExpression__CountAssignment_2_1");
			builder.put(grammarAccess.getSAllExpressionAccess().getOperandsAssignment_4(), "rule__SAllExpression__OperandsAssignment_4");
			builder.put(grammarAccess.getSAllExpressionAccess().getOperandsAssignment_5_1(), "rule__SAllExpression__OperandsAssignment_5_1");
			builder.put(grammarAccess.getQualifiedErrorPropagationAccess().getEmv2TargetAssignment_1(), "rule__QualifiedErrorPropagation__Emv2TargetAssignment_1");
			builder.put(grammarAccess.getSConditionElementAccess().getQualifiedStateAssignment_1_0_0(), "rule__SConditionElement__QualifiedStateAssignment_1_0_0");
			builder.put(grammarAccess.getSConditionElementAccess().getConstraintAssignment_1_0_1(), "rule__SConditionElement__ConstraintAssignment_1_0_1");
			builder.put(grammarAccess.getSConditionElementAccess().getQualifiedErrorPropagationReferenceAssignment_1_1_1_0(), "rule__SConditionElement__QualifiedErrorPropagationReferenceAssignment_1_1_1_0");
			builder.put(grammarAccess.getSConditionElementAccess().getConstraintAssignment_1_1_1_1(), "rule__SConditionElement__ConstraintAssignment_1_1_1_1");
			builder.put(grammarAccess.getQualifiedErrorBehaviorStateAccess().getSubcomponentAssignment_0(), "rule__QualifiedErrorBehaviorState__SubcomponentAssignment_0");
			builder.put(grammarAccess.getQualifiedErrorBehaviorStateAccess().getNextAssignment_2_0(), "rule__QualifiedErrorBehaviorState__NextAssignment_2_0");
			builder.put(grammarAccess.getQualifiedErrorBehaviorStateAccess().getStateAssignment_2_1(), "rule__QualifiedErrorBehaviorState__StateAssignment_2_1");
			builder.put(grammarAccess.getSubcomponentElementAccess().getSubcomponentAssignment(), "rule__SubcomponentElement__SubcomponentAssignment");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0(), "rule__ContainedPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__ContainedPropertyAssociation__AppendAssignment_1_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2(), "rule__ContainedPropertyAssociation__ConstantAssignment_2");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_2_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_2(), "rule__ContainedPropertyAssociation__InBindingAssignment_5_2");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getPropertyAssignment_0(), "rule__BasicPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__BasicPropertyAssociation__OwnedValueAssignment_2");
			builder.put(grammarAccess.getContainmentPathAccess().getPathAssignment(), "rule__ContainmentPath__PathAssignment");
			builder.put(grammarAccess.getModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__ModalPropertyValue__OwnedValueAssignment_0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_3(), "rule__ModalPropertyValue__InModeAssignment_3");
			builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_4_1(), "rule__ModalPropertyValue__InModeAssignment_4_1");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__OptionalModalPropertyValue__OwnedValueAssignment_0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_2(), "rule__OptionalModalPropertyValue__InModeAssignment_1_2");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3_1(), "rule__OptionalModalPropertyValue__InModeAssignment_1_3_1");
			builder.put(grammarAccess.getPropertyValueAccess().getOwnedValueAssignment(), "rule__PropertyValue__OwnedValueAssignment");
			builder.put(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAssignment(), "rule__LiteralorReferenceTerm__NamedValueAssignment");
			builder.put(grammarAccess.getBooleanLiteralAccess().getValueAssignment_1_0(), "rule__BooleanLiteral__ValueAssignment_1_0");
			builder.put(grammarAccess.getConstantValueAccess().getNamedValueAssignment(), "rule__ConstantValue__NamedValueAssignment");
			builder.put(grammarAccess.getReferenceTermAccess().getPathAssignment_2(), "rule__ReferenceTerm__PathAssignment_2");
			builder.put(grammarAccess.getRecordTermAccess().getOwnedFieldValueAssignment_1(), "rule__RecordTerm__OwnedFieldValueAssignment_1");
			builder.put(grammarAccess.getOldRecordTermAccess().getOwnedFieldValueAssignment_1(), "rule__OldRecordTerm__OwnedFieldValueAssignment_1");
			builder.put(grammarAccess.getComputedTermAccess().getFunctionAssignment_2(), "rule__ComputedTerm__FunctionAssignment_2");
			builder.put(grammarAccess.getComponentClassifierTermAccess().getClassifierAssignment_2(), "rule__ComponentClassifierTerm__ClassifierAssignment_2");
			builder.put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_0(), "rule__ListTerm__OwnedListElementAssignment_2_0");
			builder.put(grammarAccess.getListTermAccess().getOwnedListElementAssignment_2_1_1(), "rule__ListTerm__OwnedListElementAssignment_2_1_1");
			builder.put(grammarAccess.getFieldPropertyAssociationAccess().getPropertyAssignment_0(), "rule__FieldPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__FieldPropertyAssociation__OwnedValueAssignment_2");
			builder.put(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0_0(), "rule__ContainmentPathElement__NamedElementAssignment_0_0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_0_1(), "rule__ContainmentPathElement__ArrayRangeAssignment_0_1");
			builder.put(grammarAccess.getContainmentPathElementAccess().getPathAssignment_1_1(), "rule__ContainmentPathElement__PathAssignment_1_1");
			builder.put(grammarAccess.getStringTermAccess().getValueAssignment(), "rule__StringTerm__ValueAssignment");
			builder.put(grammarAccess.getArrayRangeAccess().getLowerBoundAssignment_2(), "rule__ArrayRange__LowerBoundAssignment_2");
			builder.put(grammarAccess.getArrayRangeAccess().getUpperBoundAssignment_3_1(), "rule__ArrayRange__UpperBoundAssignment_3_1");
			builder.put(grammarAccess.getSignedConstantAccess().getOpAssignment_0(), "rule__SignedConstant__OpAssignment_0");
			builder.put(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionAssignment_1(), "rule__SignedConstant__OwnedPropertyExpressionAssignment_1");
			builder.put(grammarAccess.getIntegerTermAccess().getValueAssignment_0(), "rule__IntegerTerm__ValueAssignment_0");
			builder.put(grammarAccess.getIntegerTermAccess().getUnitAssignment_1(), "rule__IntegerTerm__UnitAssignment_1");
			builder.put(grammarAccess.getRealTermAccess().getValueAssignment_0(), "rule__RealTerm__ValueAssignment_0");
			builder.put(grammarAccess.getRealTermAccess().getUnitAssignment_1(), "rule__RealTerm__UnitAssignment_1");
			builder.put(grammarAccess.getNumericRangeTermAccess().getMinimumAssignment_0(), "rule__NumericRangeTerm__MinimumAssignment_0");
			builder.put(grammarAccess.getNumericRangeTermAccess().getMaximumAssignment_2(), "rule__NumericRangeTerm__MaximumAssignment_2");
			builder.put(grammarAccess.getNumericRangeTermAccess().getDeltaAssignment_3_1(), "rule__NumericRangeTerm__DeltaAssignment_3_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ErrorModelGrammarAccess grammarAccess;

	@Override
	protected InternalErrorModelParser createParser() {
		InternalErrorModelParser result = new InternalErrorModelParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_COMMENT" };
	}

	public ErrorModelGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ErrorModelGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
