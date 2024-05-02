/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.instance.textual.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.aadl2.instance.textual.ide.contentassist.antlr.internal.InternalInstanceParser;
import org.osate.aadl2.instance.textual.services.InstanceGrammarAccess;

public class InstanceParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(InstanceGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, InstanceGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getSystemInstanceAccess().getAlternatives_5(), "rule__SystemInstance__Alternatives_5");
			builder.put(grammarAccess.getFeatureInstanceAccess().getAlternatives_6_1(), "rule__FeatureInstance__Alternatives_6_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getAlternatives_7_1(), "rule__ComponentInstance__Alternatives_7_1");
			builder.put(grammarAccess.getConnectionInstanceAccess().getAlternatives_5(), "rule__ConnectionInstance__Alternatives_5");
			builder.put(grammarAccess.getConnectionInstanceAccess().getAlternatives_10(), "rule__ConnectionInstance__Alternatives_10");
			builder.put(grammarAccess.getModeInstanceAccess().getAlternatives_4_1(), "rule__ModeInstance__Alternatives_4_1");
			builder.put(grammarAccess.getPropertyExpressionAccess().getAlternatives(), "rule__PropertyExpression__Alternatives");
			builder.put(grammarAccess.getDirectionTypeAccess().getAlternatives(), "rule__DirectionType__Alternatives");
			builder.put(grammarAccess.getFeatureCategoryAccess().getAlternatives(), "rule__FeatureCategory__Alternatives");
			builder.put(grammarAccess.getComponentCategoryAccess().getAlternatives(), "rule__ComponentCategory__Alternatives");
			builder.put(grammarAccess.getConnectionKindAccess().getAlternatives(), "rule__ConnectionKind__Alternatives");
			builder.put(grammarAccess.getDeclarativeRefAccess().getAlternatives_4(), "rule__DeclarativeRef__Alternatives_4");
			builder.put(grammarAccess.getInstanceRefAccess().getAlternatives(), "rule__InstanceRef__Alternatives");
			builder.put(grammarAccess.getInstanceRefAccess().getAlternatives_1_1(), "rule__InstanceRef__Alternatives_1_1");
			builder.put(grammarAccess.getPropertyAssociationRefAccess().getAlternatives_4_0(), "rule__PropertyAssociationRef__Alternatives_4_0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1(), "rule__ContainedPropertyAssociation__Alternatives_1");
			builder.put(grammarAccess.getPropertyAssociationAccess().getAlternatives_1(), "rule__PropertyAssociation__Alternatives_1");
			builder.put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
			builder.put(grammarAccess.getPlusMinusAccess().getAlternatives(), "rule__PlusMinus__Alternatives");
			builder.put(grammarAccess.getSignedIntAccess().getAlternatives_0(), "rule__SignedInt__Alternatives_0");
			builder.put(grammarAccess.getSignedRealAccess().getAlternatives_0(), "rule__SignedReal__Alternatives_0");
			builder.put(grammarAccess.getNumAltAccess().getAlternatives(), "rule__NumAlt__Alternatives");
			builder.put(grammarAccess.getSystemInstanceAccess().getGroup(), "rule__SystemInstance__Group__0");
			builder.put(grammarAccess.getFeatureInstanceAccess().getGroup(), "rule__FeatureInstance__Group__0");
			builder.put(grammarAccess.getFeatureInstanceAccess().getGroup_3(), "rule__FeatureInstance__Group_3__0");
			builder.put(grammarAccess.getFeatureInstanceAccess().getGroup_6(), "rule__FeatureInstance__Group_6__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup(), "rule__ComponentInstance__Group__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_3(), "rule__ComponentInstance__Group_3__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_4(), "rule__ComponentInstance__Group_4__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_4_4(), "rule__ComponentInstance__Group_4_4__0");
			builder.put(grammarAccess.getComponentInstanceAccess().getGroup_7(), "rule__ComponentInstance__Group_7__0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getGroup(), "rule__ConnectionInstance__Group__0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getGroup_7(), "rule__ConnectionInstance__Group_7__0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getGroup_7_4(), "rule__ConnectionInstance__Group_7_4__0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getGroup_8(), "rule__ConnectionInstance__Group_8__0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getGroup_8_4(), "rule__ConnectionInstance__Group_8_4__0");
			builder.put(grammarAccess.getConnectionReferenceAccess().getGroup(), "rule__ConnectionReference__Group__0");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getGroup(), "rule__FlowSpecificationInstance__Group__0");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_7(), "rule__FlowSpecificationInstance__Group_7__0");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_7_4(), "rule__FlowSpecificationInstance__Group_7_4__0");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_8(), "rule__FlowSpecificationInstance__Group_8__0");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_8_4(), "rule__FlowSpecificationInstance__Group_8_4__0");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getGroup_11(), "rule__FlowSpecificationInstance__Group_11__0");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getGroup(), "rule__EndToEndFlowInstance__Group__0");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_5(), "rule__EndToEndFlowInstance__Group_5__0");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_5_1(), "rule__EndToEndFlowInstance__Group_5_1__0");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6(), "rule__EndToEndFlowInstance__Group_6__0");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_6_4(), "rule__EndToEndFlowInstance__Group_6_4__0");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getGroup_9(), "rule__EndToEndFlowInstance__Group_9__0");
			builder.put(grammarAccess.getModeInstanceAccess().getGroup(), "rule__ModeInstance__Group__0");
			builder.put(grammarAccess.getModeInstanceAccess().getGroup_4(), "rule__ModeInstance__Group_4__0");
			builder.put(grammarAccess.getModeInstanceAccess().getGroup_4_1_1(), "rule__ModeInstance__Group_4_1_1__0");
			builder.put(grammarAccess.getModeInstanceAccess().getGroup_4_1_1_2(), "rule__ModeInstance__Group_4_1_1_2__0");
			builder.put(grammarAccess.getModeInstanceAccess().getGroup_7(), "rule__ModeInstance__Group_7__0");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getGroup(), "rule__ModeTransitionInstance__Group__0");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getGroup_5(), "rule__ModeTransitionInstance__Group_5__0");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getGroup_5_1(), "rule__ModeTransitionInstance__Group_5_1__0");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getGroup_10(), "rule__ModeTransitionInstance__Group_10__0");
			builder.put(grammarAccess.getSystemOperationModeAccess().getGroup(), "rule__SystemOperationMode__Group__0");
			builder.put(grammarAccess.getSystemOperationModeAccess().getGroup_2(), "rule__SystemOperationMode__Group_2__0");
			builder.put(grammarAccess.getSystemOperationModeAccess().getGroup_2_1(), "rule__SystemOperationMode__Group_2_1__0");
			builder.put(grammarAccess.getPropertyAssociationInstanceAccess().getGroup(), "rule__PropertyAssociationInstance__Group__0");
			builder.put(grammarAccess.getPropertyAssociationInstanceAccess().getGroup_3(), "rule__PropertyAssociationInstance__Group_3__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup(), "rule__OptionalModalPropertyValue__Group__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1(), "rule__OptionalModalPropertyValue__Group_1__0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_4(), "rule__OptionalModalPropertyValue__Group_1_4__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup(), "rule__ContainmentPathElement__Group__0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getGroup_2(), "rule__ContainmentPathElement__Group_2__0");
			builder.put(grammarAccess.getInstanceReferenceValueAccess().getGroup(), "rule__InstanceReferenceValue__Group__0");
			builder.put(grammarAccess.getDirectionTypeAccess().getGroup_2(), "rule__DirectionType__Group_2__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_8(), "rule__ComponentCategory__Group_8__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_10(), "rule__ComponentCategory__Group_10__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_12(), "rule__ComponentCategory__Group_12__0");
			builder.put(grammarAccess.getComponentCategoryAccess().getGroup_13(), "rule__ComponentCategory__Group_13__0");
			builder.put(grammarAccess.getClassifierRefAccess().getGroup(), "rule__ClassifierRef__Group__0");
			builder.put(grammarAccess.getClassifierRefAccess().getGroup_0(), "rule__ClassifierRef__Group_0__0");
			builder.put(grammarAccess.getClassifierRefAccess().getGroup_2(), "rule__ClassifierRef__Group_2__0");
			builder.put(grammarAccess.getImplRefAccess().getGroup(), "rule__ImplRef__Group__0");
			builder.put(grammarAccess.getImplRefAccess().getGroup_0(), "rule__ImplRef__Group_0__0");
			builder.put(grammarAccess.getDeclarativeRefAccess().getGroup(), "rule__DeclarativeRef__Group__0");
			builder.put(grammarAccess.getDeclarativeRefAccess().getGroup_0(), "rule__DeclarativeRef__Group_0__0");
			builder.put(grammarAccess.getDeclarativeRefAccess().getGroup_2(), "rule__DeclarativeRef__Group_2__0");
			builder.put(grammarAccess.getDeclarativeRefAccess().getGroup_4_0(), "rule__DeclarativeRef__Group_4_0__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup_1(), "rule__InstanceRef__Group_1__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup_1_0(), "rule__InstanceRef__Group_1_0__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup_1_0_1(), "rule__InstanceRef__Group_1_0_1__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup_1_1_0(), "rule__InstanceRef__Group_1_1_0__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup_1_1_1(), "rule__InstanceRef__Group_1_1_1__0");
			builder.put(grammarAccess.getInstanceRefAccess().getGroup_1_1_1_1(), "rule__InstanceRef__Group_1_1_1_1__0");
			builder.put(grammarAccess.getTransitionRefAccess().getGroup(), "rule__TransitionRef__Group__0");
			builder.put(grammarAccess.getPropertyAssociationRefAccess().getGroup(), "rule__PropertyAssociationRef__Group__0");
			builder.put(grammarAccess.getPropertyAssociationRefAccess().getGroup_0(), "rule__PropertyAssociationRef__Group_0__0");
			builder.put(grammarAccess.getPropertyAssociationRefAccess().getGroup_2(), "rule__PropertyAssociationRef__Group_2__0");
			builder.put(grammarAccess.getPropertyAssociationRefAccess().getGroup_4(), "rule__PropertyAssociationRef__Group_4__0");
			builder.put(grammarAccess.getPropertyAssociationRefAccess().getGroup_4_0_1(), "rule__PropertyAssociationRef__Group_4_0_1__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup(), "rule__ContainedPropertyAssociation__Group__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3(), "rule__ContainedPropertyAssociation__Group_3__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1(), "rule__ContainedPropertyAssociation__Group_3_1__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4(), "rule__ContainedPropertyAssociation__Group_4__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_2(), "rule__ContainedPropertyAssociation__Group_4_2__0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5(), "rule__ContainedPropertyAssociation__Group_5__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup(), "rule__PropertyAssociation__Group__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_3(), "rule__PropertyAssociation__Group_3__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_3_1(), "rule__PropertyAssociation__Group_3_1__0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_4(), "rule__PropertyAssociation__Group_4__0");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getGroup(), "rule__BasicPropertyAssociation__Group__0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getGroup(), "rule__ModalPropertyValue__Group__0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getGroup_4(), "rule__ModalPropertyValue__Group_4__0");
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
			builder.put(grammarAccess.getSystemInstanceAccess().getCategoryAssignment_0(), "rule__SystemInstance__CategoryAssignment_0");
			builder.put(grammarAccess.getSystemInstanceAccess().getNameAssignment_1(), "rule__SystemInstance__NameAssignment_1");
			builder.put(grammarAccess.getSystemInstanceAccess().getComponentImplementationAssignment_3(), "rule__SystemInstance__ComponentImplementationAssignment_3");
			builder.put(grammarAccess.getSystemInstanceAccess().getFeatureInstanceAssignment_5_0(), "rule__SystemInstance__FeatureInstanceAssignment_5_0");
			builder.put(grammarAccess.getSystemInstanceAccess().getComponentInstanceAssignment_5_1(), "rule__SystemInstance__ComponentInstanceAssignment_5_1");
			builder.put(grammarAccess.getSystemInstanceAccess().getConnectionInstanceAssignment_5_2(), "rule__SystemInstance__ConnectionInstanceAssignment_5_2");
			builder.put(grammarAccess.getSystemInstanceAccess().getFlowSpecificationAssignment_5_3(), "rule__SystemInstance__FlowSpecificationAssignment_5_3");
			builder.put(grammarAccess.getSystemInstanceAccess().getEndToEndFlowAssignment_5_4(), "rule__SystemInstance__EndToEndFlowAssignment_5_4");
			builder.put(grammarAccess.getSystemInstanceAccess().getModeInstanceAssignment_5_5(), "rule__SystemInstance__ModeInstanceAssignment_5_5");
			builder.put(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceAssignment_5_6(), "rule__SystemInstance__ModeTransitionInstanceAssignment_5_6");
			builder.put(grammarAccess.getSystemInstanceAccess().getSystemOperationModeAssignment_5_7(), "rule__SystemInstance__SystemOperationModeAssignment_5_7");
			builder.put(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationAssignment_5_8(), "rule__SystemInstance__OwnedPropertyAssociationAssignment_5_8");
			builder.put(grammarAccess.getFeatureInstanceAccess().getDirectionAssignment_0(), "rule__FeatureInstance__DirectionAssignment_0");
			builder.put(grammarAccess.getFeatureInstanceAccess().getCategoryAssignment_1(), "rule__FeatureInstance__CategoryAssignment_1");
			builder.put(grammarAccess.getFeatureInstanceAccess().getNameAssignment_2(), "rule__FeatureInstance__NameAssignment_2");
			builder.put(grammarAccess.getFeatureInstanceAccess().getIndexAssignment_3_1(), "rule__FeatureInstance__IndexAssignment_3_1");
			builder.put(grammarAccess.getFeatureInstanceAccess().getFeatureAssignment_5(), "rule__FeatureInstance__FeatureAssignment_5");
			builder.put(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceAssignment_6_1_0(), "rule__FeatureInstance__FeatureInstanceAssignment_6_1_0");
			builder.put(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationAssignment_6_1_1(), "rule__FeatureInstance__OwnedPropertyAssociationAssignment_6_1_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getCategoryAssignment_0(), "rule__ComponentInstance__CategoryAssignment_0");
			builder.put(grammarAccess.getComponentInstanceAccess().getClassifierAssignment_1(), "rule__ComponentInstance__ClassifierAssignment_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getNameAssignment_2(), "rule__ComponentInstance__NameAssignment_2");
			builder.put(grammarAccess.getComponentInstanceAccess().getIndexAssignment_3_1(), "rule__ComponentInstance__IndexAssignment_3_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getInModeAssignment_4_3(), "rule__ComponentInstance__InModeAssignment_4_3");
			builder.put(grammarAccess.getComponentInstanceAccess().getInModeAssignment_4_4_1(), "rule__ComponentInstance__InModeAssignment_4_4_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getSubcomponentAssignment_6(), "rule__ComponentInstance__SubcomponentAssignment_6");
			builder.put(grammarAccess.getComponentInstanceAccess().getFeatureInstanceAssignment_7_1_0(), "rule__ComponentInstance__FeatureInstanceAssignment_7_1_0");
			builder.put(grammarAccess.getComponentInstanceAccess().getComponentInstanceAssignment_7_1_1(), "rule__ComponentInstance__ComponentInstanceAssignment_7_1_1");
			builder.put(grammarAccess.getComponentInstanceAccess().getConnectionInstanceAssignment_7_1_2(), "rule__ComponentInstance__ConnectionInstanceAssignment_7_1_2");
			builder.put(grammarAccess.getComponentInstanceAccess().getFlowSpecificationAssignment_7_1_3(), "rule__ComponentInstance__FlowSpecificationAssignment_7_1_3");
			builder.put(grammarAccess.getComponentInstanceAccess().getEndToEndFlowAssignment_7_1_4(), "rule__ComponentInstance__EndToEndFlowAssignment_7_1_4");
			builder.put(grammarAccess.getComponentInstanceAccess().getModeInstanceAssignment_7_1_5(), "rule__ComponentInstance__ModeInstanceAssignment_7_1_5");
			builder.put(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceAssignment_7_1_6(), "rule__ComponentInstance__ModeTransitionInstanceAssignment_7_1_6");
			builder.put(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationAssignment_7_1_7(), "rule__ComponentInstance__OwnedPropertyAssociationAssignment_7_1_7");
			builder.put(grammarAccess.getConnectionInstanceAccess().getCompleteAssignment_0(), "rule__ConnectionInstance__CompleteAssignment_0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getKindAssignment_1(), "rule__ConnectionInstance__KindAssignment_1");
			builder.put(grammarAccess.getConnectionInstanceAccess().getNameAssignment_2(), "rule__ConnectionInstance__NameAssignment_2");
			builder.put(grammarAccess.getConnectionInstanceAccess().getSourceAssignment_4(), "rule__ConnectionInstance__SourceAssignment_4");
			builder.put(grammarAccess.getConnectionInstanceAccess().getBidirectionalAssignment_5_0(), "rule__ConnectionInstance__BidirectionalAssignment_5_0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getDestinationAssignment_6(), "rule__ConnectionInstance__DestinationAssignment_6");
			builder.put(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_7_3(), "rule__ConnectionInstance__InSystemOperationModeAssignment_7_3");
			builder.put(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeAssignment_7_4_1(), "rule__ConnectionInstance__InSystemOperationModeAssignment_7_4_1");
			builder.put(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_8_3(), "rule__ConnectionInstance__InModeTransitionAssignment_8_3");
			builder.put(grammarAccess.getConnectionInstanceAccess().getInModeTransitionAssignment_8_4_1(), "rule__ConnectionInstance__InModeTransitionAssignment_8_4_1");
			builder.put(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceAssignment_10_0(), "rule__ConnectionInstance__ConnectionReferenceAssignment_10_0");
			builder.put(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationAssignment_10_1(), "rule__ConnectionInstance__OwnedPropertyAssociationAssignment_10_1");
			builder.put(grammarAccess.getConnectionReferenceAccess().getSourceAssignment_0(), "rule__ConnectionReference__SourceAssignment_0");
			builder.put(grammarAccess.getConnectionReferenceAccess().getDestinationAssignment_2(), "rule__ConnectionReference__DestinationAssignment_2");
			builder.put(grammarAccess.getConnectionReferenceAccess().getReverseAssignment_4(), "rule__ConnectionReference__ReverseAssignment_4");
			builder.put(grammarAccess.getConnectionReferenceAccess().getConnectionAssignment_5(), "rule__ConnectionReference__ConnectionAssignment_5");
			builder.put(grammarAccess.getConnectionReferenceAccess().getContextAssignment_7(), "rule__ConnectionReference__ContextAssignment_7");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getNameAssignment_1(), "rule__FlowSpecificationInstance__NameAssignment_1");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getSourceAssignment_3(), "rule__FlowSpecificationInstance__SourceAssignment_3");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationAssignment_5(), "rule__FlowSpecificationInstance__DestinationAssignment_5");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getInModeAssignment_7_3(), "rule__FlowSpecificationInstance__InModeAssignment_7_3");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getInModeAssignment_7_4_1(), "rule__FlowSpecificationInstance__InModeAssignment_7_4_1");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionAssignment_8_3(), "rule__FlowSpecificationInstance__InModeTransitionAssignment_8_3");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionAssignment_8_4_1(), "rule__FlowSpecificationInstance__InModeTransitionAssignment_8_4_1");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationAssignment_10(), "rule__FlowSpecificationInstance__FlowSpecificationAssignment_10");
			builder.put(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationAssignment_11_1(), "rule__FlowSpecificationInstance__OwnedPropertyAssociationAssignment_11_1");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getNameAssignment_4(), "rule__EndToEndFlowInstance__NameAssignment_4");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5_0(), "rule__EndToEndFlowInstance__FlowElementAssignment_5_0");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementAssignment_5_1_1(), "rule__EndToEndFlowInstance__FlowElementAssignment_5_1_1");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_6_3(), "rule__EndToEndFlowInstance__InSystemOperationModeAssignment_6_3");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeAssignment_6_4_1(), "rule__EndToEndFlowInstance__InSystemOperationModeAssignment_6_4_1");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowAssignment_8(), "rule__EndToEndFlowInstance__EndToEndFlowAssignment_8");
			builder.put(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationAssignment_9_1(), "rule__EndToEndFlowInstance__OwnedPropertyAssociationAssignment_9_1");
			builder.put(grammarAccess.getModeInstanceAccess().getInitialAssignment_0(), "rule__ModeInstance__InitialAssignment_0");
			builder.put(grammarAccess.getModeInstanceAccess().getDerivedAssignment_1(), "rule__ModeInstance__DerivedAssignment_1");
			builder.put(grammarAccess.getModeInstanceAccess().getNameAssignment_3(), "rule__ModeInstance__NameAssignment_3");
			builder.put(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_0(), "rule__ModeInstance__ParentAssignment_4_1_0");
			builder.put(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_1_1(), "rule__ModeInstance__ParentAssignment_4_1_1_1");
			builder.put(grammarAccess.getModeInstanceAccess().getParentAssignment_4_1_1_2_1(), "rule__ModeInstance__ParentAssignment_4_1_1_2_1");
			builder.put(grammarAccess.getModeInstanceAccess().getModeAssignment_6(), "rule__ModeInstance__ModeAssignment_6");
			builder.put(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationAssignment_7_1(), "rule__ModeInstance__OwnedPropertyAssociationAssignment_7_1");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getNameAssignment_2(), "rule__ModeTransitionInstance__NameAssignment_2");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getSourceAssignment_3(), "rule__ModeTransitionInstance__SourceAssignment_3");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getTriggerAssignment_5_0(), "rule__ModeTransitionInstance__TriggerAssignment_5_0");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getTriggerAssignment_5_1_1(), "rule__ModeTransitionInstance__TriggerAssignment_5_1_1");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getDestinationAssignment_7(), "rule__ModeTransitionInstance__DestinationAssignment_7");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionAssignment_9(), "rule__ModeTransitionInstance__ModeTransitionAssignment_9");
			builder.put(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationAssignment_10_1(), "rule__ModeTransitionInstance__OwnedPropertyAssociationAssignment_10_1");
			builder.put(grammarAccess.getSystemOperationModeAccess().getNameAssignment_1(), "rule__SystemOperationMode__NameAssignment_1");
			builder.put(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2_0(), "rule__SystemOperationMode__CurrentModeAssignment_2_0");
			builder.put(grammarAccess.getSystemOperationModeAccess().getCurrentModeAssignment_2_1_1(), "rule__SystemOperationMode__CurrentModeAssignment_2_1_1");
			builder.put(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssignment_0(), "rule__PropertyAssociationInstance__PropertyAssignment_0");
			builder.put(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueAssignment_2(), "rule__PropertyAssociationInstance__OwnedValueAssignment_2");
			builder.put(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueAssignment_3_1(), "rule__PropertyAssociationInstance__OwnedValueAssignment_3_1");
			builder.put(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationAssignment_5(), "rule__PropertyAssociationInstance__PropertyAssociationAssignment_5");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__OptionalModalPropertyValue__OwnedValueAssignment_0");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3(), "rule__OptionalModalPropertyValue__InModeAssignment_1_3");
			builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_4_1(), "rule__OptionalModalPropertyValue__InModeAssignment_1_4_1");
			builder.put(grammarAccess.getContainmentPathElementAccess().getNamedElementAssignment_0(), "rule__ContainmentPathElement__NamedElementAssignment_0");
			builder.put(grammarAccess.getContainmentPathElementAccess().getArrayRangeAssignment_1(), "rule__ContainmentPathElement__ArrayRangeAssignment_1");
			builder.put(grammarAccess.getContainmentPathElementAccess().getPathAssignment_2_1(), "rule__ContainmentPathElement__PathAssignment_2_1");
			builder.put(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectAssignment_2(), "rule__InstanceReferenceValue__ReferencedInstanceObjectAssignment_2");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0(), "rule__ContainedPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__ContainedPropertyAssociation__AppendAssignment_1_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2(), "rule__ContainedPropertyAssociation__ConstantAssignment_2");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_2_1");
			builder.put(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_2(), "rule__ContainedPropertyAssociation__InBindingAssignment_5_2");
			builder.put(grammarAccess.getPropertyAssociationAccess().getPropertyAssignment_0(), "rule__PropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__PropertyAssociation__AppendAssignment_1_1");
			builder.put(grammarAccess.getPropertyAssociationAccess().getConstantAssignment_2(), "rule__PropertyAssociation__ConstantAssignment_2");
			builder.put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__PropertyAssociation__OwnedValueAssignment_3_0");
			builder.put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__PropertyAssociation__OwnedValueAssignment_3_1_1");
			builder.put(grammarAccess.getPropertyAssociationAccess().getInBindingAssignment_4_2(), "rule__PropertyAssociation__InBindingAssignment_4_2");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getPropertyAssignment_0(), "rule__BasicPropertyAssociation__PropertyAssignment_0");
			builder.put(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__BasicPropertyAssociation__OwnedValueAssignment_2");
			builder.put(grammarAccess.getContainmentPathAccess().getPathAssignment(), "rule__ContainmentPath__PathAssignment");
			builder.put(grammarAccess.getModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__ModalPropertyValue__OwnedValueAssignment_0");
			builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_3(), "rule__ModalPropertyValue__InModeAssignment_3");
			builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_4_1(), "rule__ModalPropertyValue__InModeAssignment_4_1");
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
	private InstanceGrammarAccess grammarAccess;

	@Override
	protected InternalInstanceParser createParser() {
		InternalInstanceParser result = new InternalInstanceParser(null);
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

	public InstanceGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(InstanceGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
