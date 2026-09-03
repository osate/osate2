/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.osate.xtext.aadl2.ba.ide.contentassist.antlr.internal.InternalBehaviorAnnexParser;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;

public class BehaviorAnnexParser extends AbstractContentAssistParser {

    @Singleton
    public static final class NameMappings {

        private final Map<AbstractElement, String> mappings;

        @Inject
        public NameMappings(BehaviorAnnexGrammarAccess grammarAccess) {
            ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
            init(builder, grammarAccess);
            this.mappings = builder.build();
        }

        public String getRuleName(AbstractElement element) {
            return mappings.get(element);
        }

        private static void init(ImmutableMap.Builder<AbstractElement, String> builder, BehaviorAnnexGrammarAccess grammarAccess) {
            builder.put(grammarAccess.getBehaviorConditionAccess().getAlternatives(), "rule__BehaviorCondition__Alternatives");
            builder.put(grammarAccess.getBehaviorConditionAccess().getAlternatives_0_1(), "rule__BehaviorCondition__Alternatives_0_1");
            builder.put(grammarAccess.getExecuteConditionAccess().getAlternatives(), "rule__ExecuteCondition__Alternatives");
            builder.put(grammarAccess.getDispatchTriggerConditionAccess().getAlternatives(), "rule__DispatchTriggerCondition__Alternatives");
            builder.put(grammarAccess.getBehaviorActionsAccess().getAlternatives_1(), "rule__BehaviorActions__Alternatives_1");
            builder.put(grammarAccess.getBehaviorActionAccess().getAlternatives(), "rule__BehaviorAction__Alternatives");
            builder.put(grammarAccess.getAssignmentActionAccess().getAlternatives_2(), "rule__AssignmentAction__Alternatives_2");
            builder.put(grammarAccess.getCommunicationActionAccess().getAlternatives(), "rule__CommunicationAction__Alternatives");
            builder.put(grammarAccess.getCommunicationActionAccess().getAlternatives_0_1(), "rule__CommunicationAction__Alternatives_0_1");
            builder.put(grammarAccess.getCommunicationActionAccess().getAlternatives_1_1(), "rule__CommunicationAction__Alternatives_1_1");
            builder.put(grammarAccess.getForStatementAccess().getAlternatives_0(), "rule__ForStatement__Alternatives_0");
            builder.put(grammarAccess.getIntegerValueAccess().getAlternatives(), "rule__IntegerValue__Alternatives");
            builder.put(grammarAccess.getLogicalOrExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__LogicalOrExpression__OperatorAlternatives_1_1_0");
            builder.put(grammarAccess.getRelationalExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__RelationalExpression__OperatorAlternatives_1_1_0");
            builder.put(grammarAccess.getAdditiveExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__AdditiveExpression__OperatorAlternatives_1_1_0");
            builder.put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAlternatives_1_1_0(), "rule__MultiplicativeExpression__OperatorAlternatives_1_1_0");
            builder.put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
            builder.put(grammarAccess.getUnaryExpressionAccess().getOperatorAlternatives_0_1_0(), "rule__UnaryExpression__OperatorAlternatives_0_1_0");
            builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
            builder.put(grammarAccess.getValueConstantAccess().getAlternatives(), "rule__ValueConstant__Alternatives");
            builder.put(grammarAccess.getBehaviorBooleanLiteralAccess().getAlternatives_1(), "rule__BehaviorBooleanLiteral__Alternatives_1");
            builder.put(grammarAccess.getReferenceExpressionAccess().getAlternatives_1(), "rule__ReferenceExpression__Alternatives_1");
            builder.put(grammarAccess.getReferenceExpressionAccess().getAlternatives_1_2_1(), "rule__ReferenceExpression__Alternatives_1_2_1");
            builder.put(grammarAccess.getPropertyIndexValueAccess().getAlternatives(), "rule__PropertyIndexValue__Alternatives");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getAlternatives_1(), "rule__UnindexedReferenceExpression__Alternatives_1");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getAlternatives_1_1_1(), "rule__UnindexedReferenceExpression__Alternatives_1_1_1");
            builder.put(grammarAccess.getReferenceSeparatorAccess().getAlternatives(), "rule__ReferenceSeparator__Alternatives");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAlternatives_1(), "rule__ContainedPropertyAssociation__Alternatives_1");
            builder.put(grammarAccess.getPropertyAssociationAccess().getAlternatives_1(), "rule__PropertyAssociation__Alternatives_1");
            builder.put(grammarAccess.getPropertyExpressionAccess().getAlternatives(), "rule__PropertyExpression__Alternatives");
            builder.put(grammarAccess.getBooleanLiteralAccess().getAlternatives_1(), "rule__BooleanLiteral__Alternatives_1");
            builder.put(grammarAccess.getPlusMinusAccess().getAlternatives(), "rule__PlusMinus__Alternatives");
            builder.put(grammarAccess.getSignedIntAccess().getAlternatives_0(), "rule__SignedInt__Alternatives_0");
            builder.put(grammarAccess.getSignedRealAccess().getAlternatives_0(), "rule__SignedReal__Alternatives_0");
            builder.put(grammarAccess.getNumAltAccess().getAlternatives(), "rule__NumAlt__Alternatives");
            builder.put(grammarAccess.getBehaviorAnnexAccess().getGroup(), "rule__BehaviorAnnex__Group__0");
            builder.put(grammarAccess.getBehaviorAnnexAccess().getGroup_1(), "rule__BehaviorAnnex__Group_1__0");
            builder.put(grammarAccess.getBehaviorAnnexAccess().getGroup_2(), "rule__BehaviorAnnex__Group_2__0");
            builder.put(grammarAccess.getBehaviorAnnexAccess().getGroup_3(), "rule__BehaviorAnnex__Group_3__0");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getGroup(), "rule__BehaviorVariableGroup__Group__0");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getGroup_1(), "rule__BehaviorVariableGroup__Group_1__0");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getGroup_4(), "rule__BehaviorVariableGroup__Group_4__0");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getGroup_5(), "rule__BehaviorVariableGroup__Group_5__0");
            builder.put(grammarAccess.getBehaviorVariableAccess().getGroup(), "rule__BehaviorVariable__Group__0");
            builder.put(grammarAccess.getArrayDimensionAccess().getGroup(), "rule__ArrayDimension__Group__0");
            builder.put(grammarAccess.getBehaviorPropertyAssociationAccess().getGroup(), "rule__BehaviorPropertyAssociation__Group__0");
            builder.put(grammarAccess.getBehaviorStateGroupAccess().getGroup(), "rule__BehaviorStateGroup__Group__0");
            builder.put(grammarAccess.getBehaviorStateGroupAccess().getGroup_1(), "rule__BehaviorStateGroup__Group_1__0");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getGroup(), "rule__BehaviorTransition__Group__0");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getGroup_0(), "rule__BehaviorTransition__Group_0__0");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getGroup_0_1(), "rule__BehaviorTransition__Group_0_1__0");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getGroup_2(), "rule__BehaviorTransition__Group_2__0");
            builder.put(grammarAccess.getBehaviorConditionAccess().getGroup_0(), "rule__BehaviorCondition__Group_0__0");
            builder.put(grammarAccess.getDispatchConditionAccess().getGroup(), "rule__DispatchCondition__Group__0");
            builder.put(grammarAccess.getDispatchConditionAccess().getGroup_2(), "rule__DispatchCondition__Group_2__0");
            builder.put(grammarAccess.getDispatchConditionAccess().getGroup_2_2(), "rule__DispatchCondition__Group_2_2__0");
            builder.put(grammarAccess.getDispatchTriggerConditionAccess().getGroup_1(), "rule__DispatchTriggerCondition__Group_1__0");
            builder.put(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getGroup(), "rule__DispatchTriggerLogicalExpression__Group__0");
            builder.put(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getGroup_1(), "rule__DispatchTriggerLogicalExpression__Group_1__0");
            builder.put(grammarAccess.getDispatchConjunctionAccess().getGroup(), "rule__DispatchConjunction__Group__0");
            builder.put(grammarAccess.getDispatchConjunctionAccess().getGroup_1(), "rule__DispatchConjunction__Group_1__0");
            builder.put(grammarAccess.getModeSwitchConditionAccess().getGroup(), "rule__ModeSwitchCondition__Group__0");
            builder.put(grammarAccess.getModeSwitchConditionAccess().getGroup_1(), "rule__ModeSwitchCondition__Group_1__0");
            builder.put(grammarAccess.getModeSwitchConjunctionAccess().getGroup(), "rule__ModeSwitchConjunction__Group__0");
            builder.put(grammarAccess.getModeSwitchConjunctionAccess().getGroup_1(), "rule__ModeSwitchConjunction__Group_1__0");
            builder.put(grammarAccess.getBehaviorActionBlockAccess().getGroup(), "rule__BehaviorActionBlock__Group__0");
            builder.put(grammarAccess.getBehaviorActionBlockAccess().getGroup_3(), "rule__BehaviorActionBlock__Group_3__0");
            builder.put(grammarAccess.getBehaviorActionsAccess().getGroup(), "rule__BehaviorActions__Group__0");
            builder.put(grammarAccess.getBehaviorActionsAccess().getGroup_1_0(), "rule__BehaviorActions__Group_1_0__0");
            builder.put(grammarAccess.getBehaviorActionsAccess().getGroup_1_0_3(), "rule__BehaviorActions__Group_1_0_3__0");
            builder.put(grammarAccess.getBehaviorActionsAccess().getGroup_1_1(), "rule__BehaviorActions__Group_1_1__0");
            builder.put(grammarAccess.getBehaviorActionsAccess().getGroup_1_1_3(), "rule__BehaviorActions__Group_1_1_3__0");
            builder.put(grammarAccess.getAssignmentActionAccess().getGroup(), "rule__AssignmentAction__Group__0");
            builder.put(grammarAccess.getCommunicationActionAccess().getGroup_0(), "rule__CommunicationAction__Group_0__0");
            builder.put(grammarAccess.getCommunicationActionAccess().getGroup_0_1_0(), "rule__CommunicationAction__Group_0_1_0__0");
            builder.put(grammarAccess.getCommunicationActionAccess().getGroup_0_1_0_1(), "rule__CommunicationAction__Group_0_1_0_1__0");
            builder.put(grammarAccess.getCommunicationActionAccess().getGroup_0_1_0_1_2(), "rule__CommunicationAction__Group_0_1_0_1_2__0");
            builder.put(grammarAccess.getCommunicationActionAccess().getGroup_0_1_1(), "rule__CommunicationAction__Group_0_1_1__0");
            builder.put(grammarAccess.getCommunicationActionAccess().getGroup_0_1_1_1(), "rule__CommunicationAction__Group_0_1_1_1__0");
            builder.put(grammarAccess.getCommunicationActionAccess().getGroup_1(), "rule__CommunicationAction__Group_1__0");
            builder.put(grammarAccess.getTimedActionAccess().getGroup(), "rule__TimedAction__Group__0");
            builder.put(grammarAccess.getTimedActionAccess().getGroup_3(), "rule__TimedAction__Group_3__0");
            builder.put(grammarAccess.getTimedActionAccess().getGroup_5(), "rule__TimedAction__Group_5__0");
            builder.put(grammarAccess.getTimedActionAccess().getGroup_5_4(), "rule__TimedAction__Group_5_4__0");
            builder.put(grammarAccess.getIfStatementAccess().getGroup(), "rule__IfStatement__Group__0");
            builder.put(grammarAccess.getIfStatementAccess().getGroup_6(), "rule__IfStatement__Group_6__0");
            builder.put(grammarAccess.getElseIfClauseAccess().getGroup(), "rule__ElseIfClause__Group__0");
            builder.put(grammarAccess.getForStatementAccess().getGroup(), "rule__ForStatement__Group__0");
            builder.put(grammarAccess.getWhileStatementAccess().getGroup(), "rule__WhileStatement__Group__0");
            builder.put(grammarAccess.getDoUntilStatementAccess().getGroup(), "rule__DoUntilStatement__Group__0");
            builder.put(grammarAccess.getElementValuesAccess().getGroup(), "rule__ElementValues__Group__0");
            builder.put(grammarAccess.getElementValuesAccess().getGroup_1(), "rule__ElementValues__Group_1__0");
            builder.put(grammarAccess.getBehaviorTimeAccess().getGroup(), "rule__BehaviorTime__Group__0");
            builder.put(grammarAccess.getLogicalOrExpressionAccess().getGroup(), "rule__LogicalOrExpression__Group__0");
            builder.put(grammarAccess.getLogicalOrExpressionAccess().getGroup_1(), "rule__LogicalOrExpression__Group_1__0");
            builder.put(grammarAccess.getLogicalAndExpressionAccess().getGroup(), "rule__LogicalAndExpression__Group__0");
            builder.put(grammarAccess.getLogicalAndExpressionAccess().getGroup_1(), "rule__LogicalAndExpression__Group_1__0");
            builder.put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
            builder.put(grammarAccess.getRelationalExpressionAccess().getGroup_1(), "rule__RelationalExpression__Group_1__0");
            builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
            builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
            builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
            builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
            builder.put(grammarAccess.getPowerExpressionAccess().getGroup(), "rule__PowerExpression__Group__0");
            builder.put(grammarAccess.getPowerExpressionAccess().getGroup_1(), "rule__PowerExpression__Group_1__0");
            builder.put(grammarAccess.getUnaryExpressionAccess().getGroup_0(), "rule__UnaryExpression__Group_0__0");
            builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_2(), "rule__PrimaryExpression__Group_2__0");
            builder.put(grammarAccess.getBehaviorBooleanLiteralAccess().getGroup(), "rule__BehaviorBooleanLiteral__Group__0");
            builder.put(grammarAccess.getReferenceExpressionAccess().getGroup(), "rule__ReferenceExpression__Group__0");
            builder.put(grammarAccess.getReferenceExpressionAccess().getGroup_1_2(), "rule__ReferenceExpression__Group_1_2__0");
            builder.put(grammarAccess.getHashPropertyReferenceAccess().getGroup(), "rule__HashPropertyReference__Group__0");
            builder.put(grammarAccess.getPropertyReferenceTailAccess().getGroup(), "rule__PropertyReferenceTail__Group__0");
            builder.put(grammarAccess.getNamedPropertyFieldAccess().getGroup(), "rule__NamedPropertyField__Group__0");
            builder.put(grammarAccess.getPropertyArrayIndexAccess().getGroup(), "rule__PropertyArrayIndex__Group__0");
            builder.put(grammarAccess.getPropertyIndexPropertyReferenceAccess().getGroup(), "rule__PropertyIndexPropertyReference__Group__0");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getGroup(), "rule__UnindexedReferenceExpression__Group__0");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getGroup_1_1(), "rule__UnindexedReferenceExpression__Group_1_1__0");
            builder.put(grammarAccess.getUnindexedReferenceAccess().getGroup(), "rule__UnindexedReference__Group__0");
            builder.put(grammarAccess.getUnindexedReferenceTailAccess().getGroup(), "rule__UnindexedReferenceTail__Group__0");
            builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
            builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
            builder.put(grammarAccess.getReferenceAccess().getGroup(), "rule__Reference__Group__0");
            builder.put(grammarAccess.getReferenceTailAccess().getGroup(), "rule__ReferenceTail__Group__0");
            builder.put(grammarAccess.getReferenceSegmentAccess().getGroup(), "rule__ReferenceSegment__Group__0");
            builder.put(grammarAccess.getArrayIndexAccess().getGroup(), "rule__ArrayIndex__Group__0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup(), "rule__ContainedPropertyAssociation__Group__0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3(), "rule__ContainedPropertyAssociation__Group_3__0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_3_1(), "rule__ContainedPropertyAssociation__Group_3_1__0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4(), "rule__ContainedPropertyAssociation__Group_4__0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_4_3(), "rule__ContainedPropertyAssociation__Group_4_3__0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getGroup_5(), "rule__ContainedPropertyAssociation__Group_5__0");
            builder.put(grammarAccess.getPropertyAssociationAccess().getGroup(), "rule__PropertyAssociation__Group__0");
            builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_3(), "rule__PropertyAssociation__Group_3__0");
            builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_3_1(), "rule__PropertyAssociation__Group_3_1__0");
            builder.put(grammarAccess.getPropertyAssociationAccess().getGroup_4(), "rule__PropertyAssociation__Group_4__0");
            builder.put(grammarAccess.getBasicPropertyAssociationAccess().getGroup(), "rule__BasicPropertyAssociation__Group__0");
            builder.put(grammarAccess.getModalPropertyValueAccess().getGroup(), "rule__ModalPropertyValue__Group__0");
            builder.put(grammarAccess.getModalPropertyValueAccess().getGroup_5(), "rule__ModalPropertyValue__Group_5__0");
            builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup(), "rule__OptionalModalPropertyValue__Group__0");
            builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1(), "rule__OptionalModalPropertyValue__Group_1__0");
            builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getGroup_1_4(), "rule__OptionalModalPropertyValue__Group_1_4__0");
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
            builder.put(grammarAccess.getQCLREFAccess().getGroup(), "rule__QCLREF__Group__0");
            builder.put(grammarAccess.getQPREFAccess().getGroup(), "rule__QPREF__Group__0");
            builder.put(grammarAccess.getQPREFAccess().getGroup_1(), "rule__QPREF__Group_1__0");
            builder.put(grammarAccess.getQCREFAccess().getGroup(), "rule__QCREF__Group__0");
            builder.put(grammarAccess.getQCREFAccess().getGroup_0(), "rule__QCREF__Group_0__0");
            builder.put(grammarAccess.getQCREFAccess().getGroup_2(), "rule__QCREF__Group_2__0");
            builder.put(grammarAccess.getBehaviorAnnexAccess().getVariableGroupsAssignment_1_1(), "rule__BehaviorAnnex__VariableGroupsAssignment_1_1");
            builder.put(grammarAccess.getBehaviorAnnexAccess().getStateGroupsAssignment_2_1(), "rule__BehaviorAnnex__StateGroupsAssignment_2_1");
            builder.put(grammarAccess.getBehaviorAnnexAccess().getTransitionsAssignment_3_1(), "rule__BehaviorAnnex__TransitionsAssignment_3_1");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getVariablesAssignment_0(), "rule__BehaviorVariableGroup__VariablesAssignment_0");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getVariablesAssignment_1_1(), "rule__BehaviorVariableGroup__VariablesAssignment_1_1");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getDataClassifierAssignment_3(), "rule__BehaviorVariableGroup__DataClassifierAssignment_3");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getInitialValueAssignment_4_1(), "rule__BehaviorVariableGroup__InitialValueAssignment_4_1");
            builder.put(grammarAccess.getBehaviorVariableGroupAccess().getPropertyAssociationsAssignment_5_1(), "rule__BehaviorVariableGroup__PropertyAssociationsAssignment_5_1");
            builder.put(grammarAccess.getBehaviorVariableAccess().getNameAssignment_0(), "rule__BehaviorVariable__NameAssignment_0");
            builder.put(grammarAccess.getBehaviorVariableAccess().getArrayDimensionsAssignment_1(), "rule__BehaviorVariable__ArrayDimensionsAssignment_1");
            builder.put(grammarAccess.getArrayDimensionAccess().getSizeAssignment_1(), "rule__ArrayDimension__SizeAssignment_1");
            builder.put(grammarAccess.getBehaviorPropertyAssociationAccess().getPropertyAssignment_0(), "rule__BehaviorPropertyAssociation__PropertyAssignment_0");
            builder.put(grammarAccess.getBehaviorPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__BehaviorPropertyAssociation__OwnedValueAssignment_2");
            builder.put(grammarAccess.getBehaviorStateGroupAccess().getStatesAssignment_0(), "rule__BehaviorStateGroup__StatesAssignment_0");
            builder.put(grammarAccess.getBehaviorStateGroupAccess().getStatesAssignment_1_1(), "rule__BehaviorStateGroup__StatesAssignment_1_1");
            builder.put(grammarAccess.getBehaviorStateGroupAccess().getInitialAssignment_3(), "rule__BehaviorStateGroup__InitialAssignment_3");
            builder.put(grammarAccess.getBehaviorStateGroupAccess().getCompleteAssignment_4(), "rule__BehaviorStateGroup__CompleteAssignment_4");
            builder.put(grammarAccess.getBehaviorStateGroupAccess().getFinalAssignment_5(), "rule__BehaviorStateGroup__FinalAssignment_5");
            builder.put(grammarAccess.getBehaviorStateAccess().getNameAssignment(), "rule__BehaviorState__NameAssignment");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getNameAssignment_0_0(), "rule__BehaviorTransition__NameAssignment_0_0");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getPriorityAssignment_0_1_1(), "rule__BehaviorTransition__PriorityAssignment_0_1_1");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getSourceStatesAssignment_1(), "rule__BehaviorTransition__SourceStatesAssignment_1");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getSourceStatesAssignment_2_1(), "rule__BehaviorTransition__SourceStatesAssignment_2_1");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getConditionAssignment_4(), "rule__BehaviorTransition__ConditionAssignment_4");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getDestinationStateAssignment_6(), "rule__BehaviorTransition__DestinationStateAssignment_6");
            builder.put(grammarAccess.getBehaviorTransitionAccess().getActionBlockAssignment_7(), "rule__BehaviorTransition__ActionBlockAssignment_7");
            builder.put(grammarAccess.getBehaviorConditionAccess().getDispatchAssignment_0_1_0(), "rule__BehaviorCondition__DispatchAssignment_0_1_0");
            builder.put(grammarAccess.getBehaviorConditionAccess().getModeSwitchAssignment_0_1_1(), "rule__BehaviorCondition__ModeSwitchAssignment_0_1_1");
            builder.put(grammarAccess.getBehaviorConditionAccess().getExecuteAssignment_1(), "rule__BehaviorCondition__ExecuteAssignment_1");
            builder.put(grammarAccess.getExecuteConditionAccess().getValueAssignment_0(), "rule__ExecuteCondition__ValueAssignment_0");
            builder.put(grammarAccess.getExecuteConditionAccess().getTimeoutAssignment_1(), "rule__ExecuteCondition__TimeoutAssignment_1");
            builder.put(grammarAccess.getExecuteConditionAccess().getOtherwiseAssignment_2(), "rule__ExecuteCondition__OtherwiseAssignment_2");
            builder.put(grammarAccess.getDispatchConditionAccess().getTriggerAssignment_1(), "rule__DispatchCondition__TriggerAssignment_1");
            builder.put(grammarAccess.getDispatchConditionAccess().getFrozenPortsAssignment_2_1(), "rule__DispatchCondition__FrozenPortsAssignment_2_1");
            builder.put(grammarAccess.getDispatchConditionAccess().getFrozenPortsAssignment_2_2_1(), "rule__DispatchCondition__FrozenPortsAssignment_2_2_1");
            builder.put(grammarAccess.getDispatchTriggerConditionAccess().getExpressionAssignment_0(), "rule__DispatchTriggerCondition__ExpressionAssignment_0");
            builder.put(grammarAccess.getDispatchTriggerConditionAccess().getTimeoutAssignment_1_0(), "rule__DispatchTriggerCondition__TimeoutAssignment_1_0");
            builder.put(grammarAccess.getDispatchTriggerConditionAccess().getTimeAssignment_1_1(), "rule__DispatchTriggerCondition__TimeAssignment_1_1");
            builder.put(grammarAccess.getDispatchTriggerConditionAccess().getStopAssignment_2(), "rule__DispatchTriggerCondition__StopAssignment_2");
            builder.put(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsAssignment_0(), "rule__DispatchTriggerLogicalExpression__ConjunctionsAssignment_0");
            builder.put(grammarAccess.getDispatchTriggerLogicalExpressionAccess().getConjunctionsAssignment_1_1(), "rule__DispatchTriggerLogicalExpression__ConjunctionsAssignment_1_1");
            builder.put(grammarAccess.getDispatchConjunctionAccess().getTriggersAssignment_0(), "rule__DispatchConjunction__TriggersAssignment_0");
            builder.put(grammarAccess.getDispatchConjunctionAccess().getTriggersAssignment_1_1(), "rule__DispatchConjunction__TriggersAssignment_1_1");
            builder.put(grammarAccess.getModeSwitchConditionAccess().getConjunctionsAssignment_0(), "rule__ModeSwitchCondition__ConjunctionsAssignment_0");
            builder.put(grammarAccess.getModeSwitchConditionAccess().getConjunctionsAssignment_1_1(), "rule__ModeSwitchCondition__ConjunctionsAssignment_1_1");
            builder.put(grammarAccess.getModeSwitchConjunctionAccess().getTriggersAssignment_0(), "rule__ModeSwitchConjunction__TriggersAssignment_0");
            builder.put(grammarAccess.getModeSwitchConjunctionAccess().getTriggersAssignment_1_1(), "rule__ModeSwitchConjunction__TriggersAssignment_1_1");
            builder.put(grammarAccess.getBehaviorActionBlockAccess().getContentAssignment_1(), "rule__BehaviorActionBlock__ContentAssignment_1");
            builder.put(grammarAccess.getBehaviorActionBlockAccess().getTimeoutAssignment_3_1(), "rule__BehaviorActionBlock__TimeoutAssignment_3_1");
            builder.put(grammarAccess.getBehaviorActionsAccess().getActionsAssignment_1_0_2(), "rule__BehaviorActions__ActionsAssignment_1_0_2");
            builder.put(grammarAccess.getBehaviorActionsAccess().getActionsAssignment_1_0_3_1(), "rule__BehaviorActions__ActionsAssignment_1_0_3_1");
            builder.put(grammarAccess.getBehaviorActionsAccess().getActionsAssignment_1_1_2(), "rule__BehaviorActions__ActionsAssignment_1_1_2");
            builder.put(grammarAccess.getBehaviorActionsAccess().getActionsAssignment_1_1_3_1(), "rule__BehaviorActions__ActionsAssignment_1_1_3_1");
            builder.put(grammarAccess.getAssignmentActionAccess().getTargetAssignment_0(), "rule__AssignmentAction__TargetAssignment_0");
            builder.put(grammarAccess.getAssignmentActionAccess().getValueAssignment_2_0(), "rule__AssignmentAction__ValueAssignment_2_0");
            builder.put(grammarAccess.getAssignmentActionAccess().getAnyAssignment_2_1(), "rule__AssignmentAction__AnyAssignment_2_1");
            builder.put(grammarAccess.getCommunicationActionAccess().getReferenceAssignment_0_0(), "rule__CommunicationAction__ReferenceAssignment_0_0");
            builder.put(grammarAccess.getCommunicationActionAccess().getSendAssignment_0_1_0_0(), "rule__CommunicationAction__SendAssignment_0_1_0_0");
            builder.put(grammarAccess.getCommunicationActionAccess().getParametersAssignment_0_1_0_1_1(), "rule__CommunicationAction__ParametersAssignment_0_1_0_1_1");
            builder.put(grammarAccess.getCommunicationActionAccess().getParametersAssignment_0_1_0_1_2_1(), "rule__CommunicationAction__ParametersAssignment_0_1_0_1_2_1");
            builder.put(grammarAccess.getCommunicationActionAccess().getDequeueAssignment_0_1_1_0(), "rule__CommunicationAction__DequeueAssignment_0_1_1_0");
            builder.put(grammarAccess.getCommunicationActionAccess().getTargetAssignment_0_1_1_1_1(), "rule__CommunicationAction__TargetAssignment_0_1_1_1_1");
            builder.put(grammarAccess.getCommunicationActionAccess().getFreezeAssignment_0_1_2(), "rule__CommunicationAction__FreezeAssignment_0_1_2");
            builder.put(grammarAccess.getCommunicationActionAccess().getLockAssignment_0_1_3(), "rule__CommunicationAction__LockAssignment_0_1_3");
            builder.put(grammarAccess.getCommunicationActionAccess().getUnlockAssignment_0_1_4(), "rule__CommunicationAction__UnlockAssignment_0_1_4");
            builder.put(grammarAccess.getCommunicationActionAccess().getAllAssignment_1_0(), "rule__CommunicationAction__AllAssignment_1_0");
            builder.put(grammarAccess.getCommunicationActionAccess().getAllLockAssignment_1_1_0(), "rule__CommunicationAction__AllLockAssignment_1_1_0");
            builder.put(grammarAccess.getCommunicationActionAccess().getAllUnlockAssignment_1_1_1(), "rule__CommunicationAction__AllUnlockAssignment_1_1_1");
            builder.put(grammarAccess.getTimedActionAccess().getLowerTimeAssignment_2(), "rule__TimedAction__LowerTimeAssignment_2");
            builder.put(grammarAccess.getTimedActionAccess().getUpperTimeAssignment_3_1(), "rule__TimedAction__UpperTimeAssignment_3_1");
            builder.put(grammarAccess.getTimedActionAccess().getProcessorsAssignment_5_3(), "rule__TimedAction__ProcessorsAssignment_5_3");
            builder.put(grammarAccess.getTimedActionAccess().getProcessorsAssignment_5_4_1(), "rule__TimedAction__ProcessorsAssignment_5_4_1");
            builder.put(grammarAccess.getIfStatementAccess().getConditionAssignment_2(), "rule__IfStatement__ConditionAssignment_2");
            builder.put(grammarAccess.getIfStatementAccess().getThenActionsAssignment_4(), "rule__IfStatement__ThenActionsAssignment_4");
            builder.put(grammarAccess.getIfStatementAccess().getElseIfsAssignment_5(), "rule__IfStatement__ElseIfsAssignment_5");
            builder.put(grammarAccess.getIfStatementAccess().getElseActionsAssignment_6_1(), "rule__IfStatement__ElseActionsAssignment_6_1");
            builder.put(grammarAccess.getElseIfClauseAccess().getConditionAssignment_2(), "rule__ElseIfClause__ConditionAssignment_2");
            builder.put(grammarAccess.getElseIfClauseAccess().getActionsAssignment_4(), "rule__ElseIfClause__ActionsAssignment_4");
            builder.put(grammarAccess.getForStatementAccess().getForAssignment_0_0(), "rule__ForStatement__ForAssignment_0_0");
            builder.put(grammarAccess.getForStatementAccess().getForallAssignment_0_1(), "rule__ForStatement__ForallAssignment_0_1");
            builder.put(grammarAccess.getForStatementAccess().getVariableAssignment_2(), "rule__ForStatement__VariableAssignment_2");
            builder.put(grammarAccess.getForStatementAccess().getDataClassifierAssignment_4(), "rule__ForStatement__DataClassifierAssignment_4");
            builder.put(grammarAccess.getForStatementAccess().getValuesAssignment_6(), "rule__ForStatement__ValuesAssignment_6");
            builder.put(grammarAccess.getForStatementAccess().getActionsAssignment_9(), "rule__ForStatement__ActionsAssignment_9");
            builder.put(grammarAccess.getWhileStatementAccess().getConditionAssignment_2(), "rule__WhileStatement__ConditionAssignment_2");
            builder.put(grammarAccess.getWhileStatementAccess().getActionsAssignment_5(), "rule__WhileStatement__ActionsAssignment_5");
            builder.put(grammarAccess.getDoUntilStatementAccess().getActionsAssignment_1(), "rule__DoUntilStatement__ActionsAssignment_1");
            builder.put(grammarAccess.getDoUntilStatementAccess().getConditionAssignment_4(), "rule__DoUntilStatement__ConditionAssignment_4");
            builder.put(grammarAccess.getElementValuesAccess().getLowerAssignment_0(), "rule__ElementValues__LowerAssignment_0");
            builder.put(grammarAccess.getElementValuesAccess().getUpperAssignment_1_1(), "rule__ElementValues__UpperAssignment_1_1");
            builder.put(grammarAccess.getBehaviorTimeAccess().getValueAssignment_0(), "rule__BehaviorTime__ValueAssignment_0");
            builder.put(grammarAccess.getBehaviorTimeAccess().getUnitAssignment_1(), "rule__BehaviorTime__UnitAssignment_1");
            builder.put(grammarAccess.getLogicalOrExpressionAccess().getOperatorAssignment_1_1(), "rule__LogicalOrExpression__OperatorAssignment_1_1");
            builder.put(grammarAccess.getLogicalOrExpressionAccess().getRightAssignment_1_2(), "rule__LogicalOrExpression__RightAssignment_1_2");
            builder.put(grammarAccess.getLogicalAndExpressionAccess().getOperatorAssignment_1_1(), "rule__LogicalAndExpression__OperatorAssignment_1_1");
            builder.put(grammarAccess.getLogicalAndExpressionAccess().getRightAssignment_1_2(), "rule__LogicalAndExpression__RightAssignment_1_2");
            builder.put(grammarAccess.getRelationalExpressionAccess().getOperatorAssignment_1_1(), "rule__RelationalExpression__OperatorAssignment_1_1");
            builder.put(grammarAccess.getRelationalExpressionAccess().getRightAssignment_1_2(), "rule__RelationalExpression__RightAssignment_1_2");
            builder.put(grammarAccess.getAdditiveExpressionAccess().getOperatorAssignment_1_1(), "rule__AdditiveExpression__OperatorAssignment_1_1");
            builder.put(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_2(), "rule__AdditiveExpression__RightAssignment_1_2");
            builder.put(grammarAccess.getMultiplicativeExpressionAccess().getOperatorAssignment_1_1(), "rule__MultiplicativeExpression__OperatorAssignment_1_1");
            builder.put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_2(), "rule__MultiplicativeExpression__RightAssignment_1_2");
            builder.put(grammarAccess.getPowerExpressionAccess().getOperatorAssignment_1_1(), "rule__PowerExpression__OperatorAssignment_1_1");
            builder.put(grammarAccess.getPowerExpressionAccess().getRightAssignment_1_2(), "rule__PowerExpression__RightAssignment_1_2");
            builder.put(grammarAccess.getUnaryExpressionAccess().getOperatorAssignment_0_1(), "rule__UnaryExpression__OperatorAssignment_0_1");
            builder.put(grammarAccess.getUnaryExpressionAccess().getOperandAssignment_0_2(), "rule__UnaryExpression__OperandAssignment_0_2");
            builder.put(grammarAccess.getBehaviorIntegerLiteralAccess().getValueAssignment(), "rule__BehaviorIntegerLiteral__ValueAssignment");
            builder.put(grammarAccess.getBehaviorRealLiteralAccess().getValueAssignment(), "rule__BehaviorRealLiteral__ValueAssignment");
            builder.put(grammarAccess.getBehaviorStringLiteralAccess().getValueAssignment(), "rule__BehaviorStringLiteral__ValueAssignment");
            builder.put(grammarAccess.getBehaviorBooleanLiteralAccess().getValueAssignment_1_0(), "rule__BehaviorBooleanLiteral__ValueAssignment_1_0");
            builder.put(grammarAccess.getReferenceExpressionAccess().getReferenceAssignment_0(), "rule__ReferenceExpression__ReferenceAssignment_0");
            builder.put(grammarAccess.getReferenceExpressionAccess().getPropertyAssignment_1_0(), "rule__ReferenceExpression__PropertyAssignment_1_0");
            builder.put(grammarAccess.getReferenceExpressionAccess().getDequeueAssignment_1_1(), "rule__ReferenceExpression__DequeueAssignment_1_1");
            builder.put(grammarAccess.getReferenceExpressionAccess().getCountAssignment_1_2_1_0(), "rule__ReferenceExpression__CountAssignment_1_2_1_0");
            builder.put(grammarAccess.getReferenceExpressionAccess().getFreshAssignment_1_2_1_1(), "rule__ReferenceExpression__FreshAssignment_1_2_1_1");
            builder.put(grammarAccess.getHashPropertyReferenceAccess().getPropertyAssignment_1(), "rule__HashPropertyReference__PropertyAssignment_1");
            builder.put(grammarAccess.getHashPropertyReferenceAccess().getIndexesAssignment_2(), "rule__HashPropertyReference__IndexesAssignment_2");
            builder.put(grammarAccess.getHashPropertyReferenceAccess().getFieldsAssignment_3(), "rule__HashPropertyReference__FieldsAssignment_3");
            builder.put(grammarAccess.getPropertyReferenceTailAccess().getPropertyAssignment_1(), "rule__PropertyReferenceTail__PropertyAssignment_1");
            builder.put(grammarAccess.getPropertyReferenceTailAccess().getIndexesAssignment_2(), "rule__PropertyReferenceTail__IndexesAssignment_2");
            builder.put(grammarAccess.getPropertyReferenceTailAccess().getFieldsAssignment_3(), "rule__PropertyReferenceTail__FieldsAssignment_3");
            builder.put(grammarAccess.getNamedPropertyFieldAccess().getNameAssignment_1(), "rule__NamedPropertyField__NameAssignment_1");
            builder.put(grammarAccess.getNamedPropertyFieldAccess().getIndexesAssignment_2(), "rule__NamedPropertyField__IndexesAssignment_2");
            builder.put(grammarAccess.getPropertyArrayIndexAccess().getValueAssignment_1(), "rule__PropertyArrayIndex__ValueAssignment_1");
            builder.put(grammarAccess.getPropertyIndexPropertyReferenceAccess().getPropertyAssignment_1(), "rule__PropertyIndexPropertyReference__PropertyAssignment_1");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getReferenceAssignment_0(), "rule__UnindexedReferenceExpression__ReferenceAssignment_0");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getDequeueAssignment_1_0(), "rule__UnindexedReferenceExpression__DequeueAssignment_1_0");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getCountAssignment_1_1_1_0(), "rule__UnindexedReferenceExpression__CountAssignment_1_1_1_0");
            builder.put(grammarAccess.getUnindexedReferenceExpressionAccess().getFreshAssignment_1_1_1_1(), "rule__UnindexedReferenceExpression__FreshAssignment_1_1_1_1");
            builder.put(grammarAccess.getUnindexedReferenceAccess().getSegmentsAssignment_0(), "rule__UnindexedReference__SegmentsAssignment_0");
            builder.put(grammarAccess.getUnindexedReferenceAccess().getTailsAssignment_1(), "rule__UnindexedReference__TailsAssignment_1");
            builder.put(grammarAccess.getUnindexedReferenceTailAccess().getSeparatorAssignment_0(), "rule__UnindexedReferenceTail__SeparatorAssignment_0");
            builder.put(grammarAccess.getUnindexedReferenceTailAccess().getSegmentAssignment_1(), "rule__UnindexedReferenceTail__SegmentAssignment_1");
            builder.put(grammarAccess.getUnindexedReferenceSegmentAccess().getNameAssignment(), "rule__UnindexedReferenceSegment__NameAssignment");
            builder.put(grammarAccess.getReferenceAccess().getSegmentsAssignment_0(), "rule__Reference__SegmentsAssignment_0");
            builder.put(grammarAccess.getReferenceAccess().getTailsAssignment_1(), "rule__Reference__TailsAssignment_1");
            builder.put(grammarAccess.getReferenceTailAccess().getSeparatorAssignment_0(), "rule__ReferenceTail__SeparatorAssignment_0");
            builder.put(grammarAccess.getReferenceTailAccess().getSegmentAssignment_1(), "rule__ReferenceTail__SegmentAssignment_1");
            builder.put(grammarAccess.getReferenceSegmentAccess().getNameAssignment_0(), "rule__ReferenceSegment__NameAssignment_0");
            builder.put(grammarAccess.getReferenceSegmentAccess().getIndexesAssignment_1(), "rule__ReferenceSegment__IndexesAssignment_1");
            builder.put(grammarAccess.getArrayIndexAccess().getValueAssignment_1(), "rule__ArrayIndex__ValueAssignment_1");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getPropertyAssignment_0(), "rule__ContainedPropertyAssociation__PropertyAssignment_0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__ContainedPropertyAssociation__AppendAssignment_1_1");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getConstantAssignment_2(), "rule__ContainedPropertyAssociation__ConstantAssignment_2");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_0");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__ContainedPropertyAssociation__OwnedValueAssignment_3_1_1");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_2(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_2");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToAssignment_4_3_1(), "rule__ContainedPropertyAssociation__AppliesToAssignment_4_3_1");
            builder.put(grammarAccess.getContainedPropertyAssociationAccess().getInBindingAssignment_5_3(), "rule__ContainedPropertyAssociation__InBindingAssignment_5_3");
            builder.put(grammarAccess.getPropertyAssociationAccess().getPropertyAssignment_0(), "rule__PropertyAssociation__PropertyAssignment_0");
            builder.put(grammarAccess.getPropertyAssociationAccess().getAppendAssignment_1_1(), "rule__PropertyAssociation__AppendAssignment_1_1");
            builder.put(grammarAccess.getPropertyAssociationAccess().getConstantAssignment_2(), "rule__PropertyAssociation__ConstantAssignment_2");
            builder.put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_0(), "rule__PropertyAssociation__OwnedValueAssignment_3_0");
            builder.put(grammarAccess.getPropertyAssociationAccess().getOwnedValueAssignment_3_1_1(), "rule__PropertyAssociation__OwnedValueAssignment_3_1_1");
            builder.put(grammarAccess.getPropertyAssociationAccess().getInBindingAssignment_4_3(), "rule__PropertyAssociation__InBindingAssignment_4_3");
            builder.put(grammarAccess.getBasicPropertyAssociationAccess().getPropertyAssignment_0(), "rule__BasicPropertyAssociation__PropertyAssignment_0");
            builder.put(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValueAssignment_2(), "rule__BasicPropertyAssociation__OwnedValueAssignment_2");
            builder.put(grammarAccess.getContainmentPathAccess().getPathAssignment(), "rule__ContainmentPath__PathAssignment");
            builder.put(grammarAccess.getModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__ModalPropertyValue__OwnedValueAssignment_0");
            builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_4(), "rule__ModalPropertyValue__InModeAssignment_4");
            builder.put(grammarAccess.getModalPropertyValueAccess().getInModeAssignment_5_1(), "rule__ModalPropertyValue__InModeAssignment_5_1");
            builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValueAssignment_0(), "rule__OptionalModalPropertyValue__OwnedValueAssignment_0");
            builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_3(), "rule__OptionalModalPropertyValue__InModeAssignment_1_3");
            builder.put(grammarAccess.getOptionalModalPropertyValueAccess().getInModeAssignment_1_4_1(), "rule__OptionalModalPropertyValue__InModeAssignment_1_4_1");
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
    private BehaviorAnnexGrammarAccess grammarAccess;

    @Override
    protected InternalBehaviorAnnexParser createParser() {
        InternalBehaviorAnnexParser result = new InternalBehaviorAnnexParser(null);
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

    public BehaviorAnnexGrammarAccess getGrammarAccess() {
        return this.grammarAccess;
    }

    public void setGrammarAccess(BehaviorAnnexGrammarAccess grammarAccess) {
        this.grammarAccess = grammarAccess;
    }

    public NameMappings getNameMappings() {
        return nameMappings;
    }

    public void setNameMappings(NameMappings nameMappings) {
        this.nameMappings = nameMappings;
    }
}
