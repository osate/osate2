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
package org.osate.xtext.aadl2.ba.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;
import org.osate.xtext.aadl2.properties.serializer.PropertiesSemanticSequencer;

@SuppressWarnings("all")
public abstract class AbstractBehaviorAnnexSemanticSequencer extends PropertiesSemanticSequencer {

    @Inject
    private BehaviorAnnexGrammarAccess grammarAccess;

    @Override
    public void sequence(ISerializationContext context, EObject semanticObject) {
        EPackage epackage = semanticObject.eClass().getEPackage();
        ParserRule rule = context.getParserRule();
        Action action = context.getAssignedAction();
        Set<Parameter> parameters = context.getEnabledBooleanParameters();
        if (epackage == Aadl2Package.eINSTANCE)
            switch (semanticObject.eClass().getClassifierID()) {
            case Aadl2Package.ARRAY_RANGE:
                sequence_ArrayRange(context, (ArrayRange) semanticObject);
                return;
            case Aadl2Package.BASIC_PROPERTY_ASSOCIATION:
                sequence_FieldPropertyAssociation(context, (BasicPropertyAssociation) semanticObject);
                return;
            case Aadl2Package.BOOLEAN_LITERAL:
                sequence_BooleanLiteral(context, (BooleanLiteral) semanticObject);
                return;
            case Aadl2Package.CLASSIFIER_VALUE:
                sequence_ComponentClassifierTerm(context, (ClassifierValue) semanticObject);
                return;
            case Aadl2Package.COMPUTED_VALUE:
                sequence_ComputedTerm(context, (ComputedValue) semanticObject);
                return;
            case Aadl2Package.CONTAINED_NAMED_ELEMENT:
                sequence_ContainmentPath(context, (ContainedNamedElement) semanticObject);
                return;
            case Aadl2Package.CONTAINMENT_PATH_ELEMENT:
                sequence_ContainmentPathElement(context, (ContainmentPathElement) semanticObject);
                return;
            case Aadl2Package.INTEGER_LITERAL:
                sequence_IntegerTerm(context, (IntegerLiteral) semanticObject);
                return;
            case Aadl2Package.LIST_VALUE:
                sequence_ListTerm(context, (ListValue) semanticObject);
                return;
            case Aadl2Package.MODAL_PROPERTY_VALUE:
                if (rule == grammarAccess.getModalPropertyValueRule()) {
                    sequence_ModalPropertyValue(context, (ModalPropertyValue) semanticObject);
                    return;
                }
                else if (rule == grammarAccess.getOptionalModalPropertyValueRule()) {
                    sequence_OptionalModalPropertyValue(context, (ModalPropertyValue) semanticObject);
                    return;
                }
                else if (rule == grammarAccess.getPropertyValueRule()) {
                    sequence_PropertyValue(context, (ModalPropertyValue) semanticObject);
                    return;
                }
                else break;
            case Aadl2Package.NAMED_VALUE:
                if (rule == grammarAccess.getConstantValueRule()
                        || rule == grammarAccess.getNumAltRule()) {
                    sequence_ConstantValue(context, (NamedValue) semanticObject);
                    return;
                }
                else if (rule == grammarAccess.getPropertyExpressionRule()
                        || rule == grammarAccess.getLiteralorReferenceTermRule()) {
                    sequence_LiteralorReferenceTerm(context, (NamedValue) semanticObject);
                    return;
                }
                else break;
            case Aadl2Package.OPERATION:
                sequence_SignedConstant(context, (Operation) semanticObject);
                return;
            case Aadl2Package.PROPERTY_ASSOCIATION:
                if (rule == grammarAccess.getBasicPropertyAssociationRule()) {
                    sequence_BasicPropertyAssociation(context, (PropertyAssociation) semanticObject);
                    return;
                }
                else if (rule == grammarAccess.getPModelRule()
                        || rule == grammarAccess.getContainedPropertyAssociationRule()) {
                    sequence_ContainedPropertyAssociation(context, (PropertyAssociation) semanticObject);
                    return;
                }
                else if (rule == grammarAccess.getPropertyAssociationRule()) {
                    sequence_PropertyAssociation(context, (PropertyAssociation) semanticObject);
                    return;
                }
                else break;
            case Aadl2Package.RANGE_VALUE:
                sequence_NumericRangeTerm(context, (RangeValue) semanticObject);
                return;
            case Aadl2Package.REAL_LITERAL:
                sequence_RealTerm(context, (RealLiteral) semanticObject);
                return;
            case Aadl2Package.RECORD_VALUE:
                if (rule == grammarAccess.getOldRecordTermRule()) {
                    sequence_OldRecordTerm(context, (RecordValue) semanticObject);
                    return;
                }
                else if (rule == grammarAccess.getPropertyExpressionRule()
                        || rule == grammarAccess.getRecordTermRule()) {
                    sequence_RecordTerm(context, (RecordValue) semanticObject);
                    return;
                }
                else break;
            case Aadl2Package.REFERENCE_VALUE:
                sequence_ReferenceTerm(context, (ReferenceValue) semanticObject);
                return;
            case Aadl2Package.STRING_LITERAL:
                sequence_StringTerm(context, (StringLiteral) semanticObject);
                return;
            }
        else if (epackage == BehaviorAnnexPackage.eINSTANCE)
            switch (semanticObject.eClass().getClassifierID()) {
            case BehaviorAnnexPackage.ARRAY_DIMENSION:
                sequence_ArrayDimension(context, (ArrayDimension) semanticObject);
                return;
            case BehaviorAnnexPackage.ARRAY_INDEX:
                sequence_ArrayIndex(context, (ArrayIndex) semanticObject);
                return;
            case BehaviorAnnexPackage.ASSIGNMENT_ACTION:
                sequence_AssignmentAction(context, (AssignmentAction) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_ACTION_BLOCK:
                sequence_BehaviorActionBlock(context, (BehaviorActionBlock) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_ACTION_SEQUENCE:
                sequence_BehaviorActions(context, (BehaviorActionSequence) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_ACTION_SET:
                sequence_BehaviorActions(context, (BehaviorActionSet) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_ANNEX:
                sequence_BehaviorAnnex(context, (BehaviorAnnex) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_BOOLEAN_LITERAL:
                sequence_BehaviorBooleanLiteral(context, (BehaviorBooleanLiteral) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_CONDITION:
                sequence_BehaviorCondition(context, (BehaviorCondition) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_INTEGER_LITERAL:
                sequence_BehaviorIntegerLiteral(context, (BehaviorIntegerLiteral) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_PROPERTY_ASSOCIATION:
                sequence_BehaviorPropertyAssociation(context, (BehaviorPropertyAssociation) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_REAL_LITERAL:
                sequence_BehaviorRealLiteral(context, (BehaviorRealLiteral) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_STATE:
                sequence_BehaviorState(context, (BehaviorState) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP:
                sequence_BehaviorStateGroup(context, (BehaviorStateGroup) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_STRING_LITERAL:
                sequence_BehaviorStringLiteral(context, (BehaviorStringLiteral) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_TIME:
                sequence_BehaviorTime(context, (BehaviorTime) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_TRANSITION:
                sequence_BehaviorTransition(context, (BehaviorTransition) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_VARIABLE:
                sequence_BehaviorVariable(context, (BehaviorVariable) semanticObject);
                return;
            case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP:
                sequence_BehaviorVariableGroup(context, (BehaviorVariableGroup) semanticObject);
                return;
            case BehaviorAnnexPackage.BINARY_EXPRESSION:
                sequence_AdditiveExpression_LogicalAndExpression_LogicalOrExpression_MultiplicativeExpression_PowerExpression_RelationalExpression(context, (BinaryExpression) semanticObject);
                return;
            case BehaviorAnnexPackage.COMMUNICATION_ACTION:
                sequence_CommunicationAction(context, (CommunicationAction) semanticObject);
                return;
            case BehaviorAnnexPackage.DISPATCH_CONDITION:
                sequence_DispatchCondition(context, (DispatchCondition) semanticObject);
                return;
            case BehaviorAnnexPackage.DISPATCH_CONJUNCTION:
                sequence_DispatchConjunction(context, (DispatchConjunction) semanticObject);
                return;
            case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION:
                sequence_DispatchTriggerCondition(context, (DispatchTriggerCondition) semanticObject);
                return;
            case BehaviorAnnexPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION:
                sequence_DispatchTriggerLogicalExpression(context, (DispatchTriggerLogicalExpression) semanticObject);
                return;
            case BehaviorAnnexPackage.DO_UNTIL_STATEMENT:
                sequence_DoUntilStatement(context, (DoUntilStatement) semanticObject);
                return;
            case BehaviorAnnexPackage.ELEMENT_VALUES:
                sequence_ElementValues(context, (ElementValues) semanticObject);
                return;
            case BehaviorAnnexPackage.ELSE_IF_CLAUSE:
                sequence_ElseIfClause(context, (ElseIfClause) semanticObject);
                return;
            case BehaviorAnnexPackage.EXECUTE_CONDITION:
                sequence_ExecuteCondition(context, (ExecuteCondition) semanticObject);
                return;
            case BehaviorAnnexPackage.FOR_STATEMENT:
                sequence_ForStatement(context, (ForStatement) semanticObject);
                return;
            case BehaviorAnnexPackage.HASH_PROPERTY_REFERENCE:
                sequence_HashPropertyReference(context, (HashPropertyReference) semanticObject);
                return;
            case BehaviorAnnexPackage.IF_STATEMENT:
                sequence_IfStatement(context, (IfStatement) semanticObject);
                return;
            case BehaviorAnnexPackage.MODE_SWITCH_CONDITION:
                sequence_ModeSwitchCondition(context, (ModeSwitchCondition) semanticObject);
                return;
            case BehaviorAnnexPackage.MODE_SWITCH_CONJUNCTION:
                sequence_ModeSwitchConjunction(context, (ModeSwitchConjunction) semanticObject);
                return;
            case BehaviorAnnexPackage.NAMED_PROPERTY_FIELD:
                sequence_NamedPropertyField(context, (NamedPropertyField) semanticObject);
                return;
            case BehaviorAnnexPackage.PROPERTY_ARRAY_INDEX:
                sequence_PropertyArrayIndex(context, (PropertyArrayIndex) semanticObject);
                return;
            case BehaviorAnnexPackage.PROPERTY_INDEX_PROPERTY_REFERENCE:
                sequence_PropertyIndexPropertyReference(context, (PropertyIndexPropertyReference) semanticObject);
                return;
            case BehaviorAnnexPackage.PROPERTY_REFERENCE_TAIL:
                sequence_PropertyReferenceTail(context, (PropertyReferenceTail) semanticObject);
                return;
            case BehaviorAnnexPackage.REFERENCE:
                sequence_Reference(context, (Reference) semanticObject);
                return;
            case BehaviorAnnexPackage.REFERENCE_EXPRESSION:
                sequence_ReferenceExpression(context, (ReferenceExpression) semanticObject);
                return;
            case BehaviorAnnexPackage.REFERENCE_SEGMENT:
                sequence_ReferenceSegment(context, (ReferenceSegment) semanticObject);
                return;
            case BehaviorAnnexPackage.REFERENCE_TAIL:
                sequence_ReferenceTail(context, (ReferenceTail) semanticObject);
                return;
            case BehaviorAnnexPackage.TIMED_ACTION:
                sequence_TimedAction(context, (TimedAction) semanticObject);
                return;
            case BehaviorAnnexPackage.UNARY_EXPRESSION:
                sequence_UnaryExpression(context, (UnaryExpression) semanticObject);
                return;
            case BehaviorAnnexPackage.UNINDEXED_REFERENCE:
                sequence_UnindexedReference(context, (UnindexedReference) semanticObject);
                return;
            case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION:
                sequence_UnindexedReferenceExpression(context, (UnindexedReferenceExpression) semanticObject);
                return;
            case BehaviorAnnexPackage.UNINDEXED_REFERENCE_SEGMENT:
                sequence_UnindexedReferenceSegment(context, (UnindexedReferenceSegment) semanticObject);
                return;
            case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL:
                sequence_UnindexedReferenceTail(context, (UnindexedReferenceTail) semanticObject);
                return;
            case BehaviorAnnexPackage.WHILE_STATEMENT:
                sequence_WhileStatement(context, (WhileStatement) semanticObject);
                return;
            }
        if (errorAcceptor != null)
            errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
    }

    /**
     * <pre>
     * Contexts:
     *     ValueExpression returns BinaryExpression
     *     LogicalOrExpression returns BinaryExpression
     *     LogicalOrExpression.BinaryExpression_1_0 returns BinaryExpression
     *     LogicalAndExpression returns BinaryExpression
     *     LogicalAndExpression.BinaryExpression_1_0 returns BinaryExpression
     *     RelationalExpression returns BinaryExpression
     *     RelationalExpression.BinaryExpression_1_0 returns BinaryExpression
     *     AdditiveExpression returns BinaryExpression
     *     AdditiveExpression.BinaryExpression_1_0 returns BinaryExpression
     *     MultiplicativeExpression returns BinaryExpression
     *     MultiplicativeExpression.BinaryExpression_1_0 returns BinaryExpression
     *     PowerExpression returns BinaryExpression
     *     PowerExpression.BinaryExpression_1_0 returns BinaryExpression
     *     UnaryExpression returns BinaryExpression
     *     PrimaryExpression returns BinaryExpression
     *
     * Constraint:
     *     (
     *         (left=LogicalOrExpression_BinaryExpression_1_0 (operator='or' | operator='xor') right=LogicalAndExpression) |
     *         (left=LogicalAndExpression_BinaryExpression_1_0 operator='and' right=RelationalExpression) |
     *         (
     *             left=RelationalExpression_BinaryExpression_1_0
     *             (
     *                 operator='=' |
     *                 operator='!=' |
     *                 operator='&lt;' |
     *                 operator='&lt;=' |
     *                 operator='&gt;' |
     *                 operator='&gt;='
     *             )
     *             right=AdditiveExpression
     *         ) |
     *         (left=AdditiveExpression_BinaryExpression_1_0 (operator='+' | operator='-') right=MultiplicativeExpression) |
     *         (left=MultiplicativeExpression_BinaryExpression_1_0 (operator='*' | operator='/' | operator='mod' | operator='rem') right=PowerExpression) |
     *         (left=PowerExpression_BinaryExpression_1_0 operator='**' right=PowerExpression)
     *     )
     * </pre>
     */
    protected void sequence_AdditiveExpression_LogicalAndExpression_LogicalOrExpression_MultiplicativeExpression_PowerExpression_RelationalExpression(ISerializationContext context, BinaryExpression semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ArrayDimension returns ArrayDimension
     *
     * Constraint:
     *     size=IntegerValue
     * </pre>
     */
    protected void sequence_ArrayDimension(ISerializationContext context, ArrayDimension semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.ARRAY_DIMENSION__SIZE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.ARRAY_DIMENSION__SIZE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getArrayDimensionAccess().getSizeIntegerValueParserRuleCall_1_0(), semanticObject.getSize());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     ArrayIndex returns ArrayIndex
     *
     * Constraint:
     *     value=IntegerValue
     * </pre>
     */
    protected void sequence_ArrayIndex(ISerializationContext context, ArrayIndex semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.ARRAY_INDEX__VALUE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.ARRAY_INDEX__VALUE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getArrayIndexAccess().getValueIntegerValueParserRuleCall_1_0(), semanticObject.getValue());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns AssignmentAction
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns AssignmentAction
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns AssignmentAction
     *     BehaviorAction returns AssignmentAction
     *     AssignmentAction returns AssignmentAction
     *
     * Constraint:
     *     (target=Reference (value=ValueExpression | any?='any'))
     * </pre>
     */
    protected void sequence_AssignmentAction(ISerializationContext context, AssignmentAction semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActionBlock returns BehaviorActionBlock
     *     BehaviorActions returns BehaviorActionBlock
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns BehaviorActionBlock
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns BehaviorActionBlock
     *     BehaviorAction returns BehaviorActionBlock
     *
     * Constraint:
     *     (content=BehaviorActions timeout=BehaviorTime?)
     * </pre>
     */
    protected void sequence_BehaviorActionBlock(ISerializationContext context, BehaviorActionBlock semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns BehaviorActionSequence
     *
     * Constraint:
     *     (actions+=BehaviorActions_BehaviorActionSequence_1_0_0 actions+=BehaviorAction actions+=BehaviorAction*)
     * </pre>
     */
    protected void sequence_BehaviorActions(ISerializationContext context, BehaviorActionSequence semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns BehaviorActionSet
     *
     * Constraint:
     *     (actions+=BehaviorActions_BehaviorActionSet_1_1_0 actions+=BehaviorAction actions+=BehaviorAction*)
     * </pre>
     */
    protected void sequence_BehaviorActions(ISerializationContext context, BehaviorActionSet semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     AnnexSubclause returns BehaviorAnnex
     *     BehaviorAnnex returns BehaviorAnnex
     *
     * Constraint:
     *     (variableGroups+=BehaviorVariableGroup* stateGroups+=BehaviorStateGroup* transitions+=BehaviorTransition*)
     * </pre>
     */
    protected void sequence_BehaviorAnnex(ISerializationContext context, BehaviorAnnex semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ValueExpression returns BehaviorBooleanLiteral
     *     LogicalOrExpression returns BehaviorBooleanLiteral
     *     LogicalOrExpression.BinaryExpression_1_0 returns BehaviorBooleanLiteral
     *     LogicalAndExpression returns BehaviorBooleanLiteral
     *     LogicalAndExpression.BinaryExpression_1_0 returns BehaviorBooleanLiteral
     *     RelationalExpression returns BehaviorBooleanLiteral
     *     RelationalExpression.BinaryExpression_1_0 returns BehaviorBooleanLiteral
     *     AdditiveExpression returns BehaviorBooleanLiteral
     *     AdditiveExpression.BinaryExpression_1_0 returns BehaviorBooleanLiteral
     *     MultiplicativeExpression returns BehaviorBooleanLiteral
     *     MultiplicativeExpression.BinaryExpression_1_0 returns BehaviorBooleanLiteral
     *     PowerExpression returns BehaviorBooleanLiteral
     *     PowerExpression.BinaryExpression_1_0 returns BehaviorBooleanLiteral
     *     UnaryExpression returns BehaviorBooleanLiteral
     *     PrimaryExpression returns BehaviorBooleanLiteral
     *     ValueConstant returns BehaviorBooleanLiteral
     *     BehaviorBooleanLiteral returns BehaviorBooleanLiteral
     *
     * Constraint:
     *     value?='true'?
     * </pre>
     */
    protected void sequence_BehaviorBooleanLiteral(ISerializationContext context, BehaviorBooleanLiteral semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorCondition returns BehaviorCondition
     *
     * Constraint:
     *     (dispatch=DispatchCondition | modeSwitch=ModeSwitchCondition | execute=ExecuteCondition)
     * </pre>
     */
    protected void sequence_BehaviorCondition(ISerializationContext context, BehaviorCondition semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     IntegerValue returns BehaviorIntegerLiteral
     *     ValueExpression returns BehaviorIntegerLiteral
     *     LogicalOrExpression returns BehaviorIntegerLiteral
     *     LogicalOrExpression.BinaryExpression_1_0 returns BehaviorIntegerLiteral
     *     LogicalAndExpression returns BehaviorIntegerLiteral
     *     LogicalAndExpression.BinaryExpression_1_0 returns BehaviorIntegerLiteral
     *     RelationalExpression returns BehaviorIntegerLiteral
     *     RelationalExpression.BinaryExpression_1_0 returns BehaviorIntegerLiteral
     *     AdditiveExpression returns BehaviorIntegerLiteral
     *     AdditiveExpression.BinaryExpression_1_0 returns BehaviorIntegerLiteral
     *     MultiplicativeExpression returns BehaviorIntegerLiteral
     *     MultiplicativeExpression.BinaryExpression_1_0 returns BehaviorIntegerLiteral
     *     PowerExpression returns BehaviorIntegerLiteral
     *     PowerExpression.BinaryExpression_1_0 returns BehaviorIntegerLiteral
     *     UnaryExpression returns BehaviorIntegerLiteral
     *     PrimaryExpression returns BehaviorIntegerLiteral
     *     ValueConstant returns BehaviorIntegerLiteral
     *     BehaviorIntegerLiteral returns BehaviorIntegerLiteral
     *     PropertyIndexValue returns BehaviorIntegerLiteral
     *
     * Constraint:
     *     value=INTEGER_LIT
     * </pre>
     */
    protected void sequence_BehaviorIntegerLiteral(ISerializationContext context, BehaviorIntegerLiteral semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_INTEGER_LITERAL__VALUE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_INTEGER_LITERAL__VALUE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getBehaviorIntegerLiteralAccess().getValueINTEGER_LITTerminalRuleCall_0(), semanticObject.getValue());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorPropertyAssociation returns BehaviorPropertyAssociation
     *
     * Constraint:
     *     (property=[Property|QPREF] ownedValue=PropertyExpression)
     * </pre>
     */
    protected void sequence_BehaviorPropertyAssociation(ISerializationContext context, BehaviorPropertyAssociation semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_PROPERTY_ASSOCIATION__PROPERTY) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_PROPERTY_ASSOCIATION__PROPERTY));
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_PROPERTY_ASSOCIATION__OWNED_VALUE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_PROPERTY_ASSOCIATION__OWNED_VALUE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getBehaviorPropertyAssociationAccess().getPropertyPropertyQPREFParserRuleCall_0_0_1(), semanticObject.eGet(BehaviorAnnexPackage.Literals.BEHAVIOR_PROPERTY_ASSOCIATION__PROPERTY, false));
        feeder.accept(grammarAccess.getBehaviorPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0(), semanticObject.getOwnedValue());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     ValueExpression returns BehaviorRealLiteral
     *     LogicalOrExpression returns BehaviorRealLiteral
     *     LogicalOrExpression.BinaryExpression_1_0 returns BehaviorRealLiteral
     *     LogicalAndExpression returns BehaviorRealLiteral
     *     LogicalAndExpression.BinaryExpression_1_0 returns BehaviorRealLiteral
     *     RelationalExpression returns BehaviorRealLiteral
     *     RelationalExpression.BinaryExpression_1_0 returns BehaviorRealLiteral
     *     AdditiveExpression returns BehaviorRealLiteral
     *     AdditiveExpression.BinaryExpression_1_0 returns BehaviorRealLiteral
     *     MultiplicativeExpression returns BehaviorRealLiteral
     *     MultiplicativeExpression.BinaryExpression_1_0 returns BehaviorRealLiteral
     *     PowerExpression returns BehaviorRealLiteral
     *     PowerExpression.BinaryExpression_1_0 returns BehaviorRealLiteral
     *     UnaryExpression returns BehaviorRealLiteral
     *     PrimaryExpression returns BehaviorRealLiteral
     *     ValueConstant returns BehaviorRealLiteral
     *     BehaviorRealLiteral returns BehaviorRealLiteral
     *
     * Constraint:
     *     value=REAL_LIT
     * </pre>
     */
    protected void sequence_BehaviorRealLiteral(ISerializationContext context, BehaviorRealLiteral semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_REAL_LITERAL__VALUE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_REAL_LITERAL__VALUE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getBehaviorRealLiteralAccess().getValueREAL_LITTerminalRuleCall_0(), semanticObject.getValue());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorStateGroup returns BehaviorStateGroup
     *
     * Constraint:
     *     (states+=BehaviorState states+=BehaviorState* initial?='initial'? complete?='complete'? final?='final'?)
     * </pre>
     */
    protected void sequence_BehaviorStateGroup(ISerializationContext context, BehaviorStateGroup semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorState returns BehaviorState
     *
     * Constraint:
     *     name=ID
     * </pre>
     */
    protected void sequence_BehaviorState(ISerializationContext context, BehaviorState semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_STATE__NAME) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_STATE__NAME));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getBehaviorStateAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     ValueExpression returns BehaviorStringLiteral
     *     LogicalOrExpression returns BehaviorStringLiteral
     *     LogicalOrExpression.BinaryExpression_1_0 returns BehaviorStringLiteral
     *     LogicalAndExpression returns BehaviorStringLiteral
     *     LogicalAndExpression.BinaryExpression_1_0 returns BehaviorStringLiteral
     *     RelationalExpression returns BehaviorStringLiteral
     *     RelationalExpression.BinaryExpression_1_0 returns BehaviorStringLiteral
     *     AdditiveExpression returns BehaviorStringLiteral
     *     AdditiveExpression.BinaryExpression_1_0 returns BehaviorStringLiteral
     *     MultiplicativeExpression returns BehaviorStringLiteral
     *     MultiplicativeExpression.BinaryExpression_1_0 returns BehaviorStringLiteral
     *     PowerExpression returns BehaviorStringLiteral
     *     PowerExpression.BinaryExpression_1_0 returns BehaviorStringLiteral
     *     UnaryExpression returns BehaviorStringLiteral
     *     PrimaryExpression returns BehaviorStringLiteral
     *     ValueConstant returns BehaviorStringLiteral
     *     BehaviorStringLiteral returns BehaviorStringLiteral
     *
     * Constraint:
     *     value=STRING
     * </pre>
     */
    protected void sequence_BehaviorStringLiteral(ISerializationContext context, BehaviorStringLiteral semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_STRING_LITERAL__VALUE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_STRING_LITERAL__VALUE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getBehaviorStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorTime returns BehaviorTime
     *
     * Constraint:
     *     (value=IntegerValue unit=[UnitLiteral|ID])
     * </pre>
     */
    protected void sequence_BehaviorTime(ISerializationContext context, BehaviorTime semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_TIME__VALUE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_TIME__VALUE));
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_TIME__UNIT) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.BEHAVIOR_TIME__UNIT));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getBehaviorTimeAccess().getValueIntegerValueParserRuleCall_0_0(), semanticObject.getValue());
        feeder.accept(grammarAccess.getBehaviorTimeAccess().getUnitUnitLiteralIDTerminalRuleCall_1_0_1(), semanticObject.eGet(BehaviorAnnexPackage.Literals.BEHAVIOR_TIME__UNIT, false));
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorTransition returns BehaviorTransition
     *
     * Constraint:
     *     (
     *         (name=ID priority=INTEGER_LIT?)?
     *         sourceStates+=[BehaviorState|ID]
     *         sourceStates+=[BehaviorState|ID]*
     *         condition=BehaviorCondition?
     *         destinationState=[BehaviorState|ID]
     *         actionBlock=BehaviorActionBlock?
     *     )
     * </pre>
     */
    protected void sequence_BehaviorTransition(ISerializationContext context, BehaviorTransition semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorVariableGroup returns BehaviorVariableGroup
     *
     * Constraint:
     *     (
     *         variables+=BehaviorVariable
     *         variables+=BehaviorVariable*
     *         dataClassifier=[ComponentClassifier|QCREF]
     *         initialValue=ValueConstant?
     *         propertyAssociations+=BehaviorPropertyAssociation*
     *     )
     * </pre>
     */
    protected void sequence_BehaviorVariableGroup(ISerializationContext context, BehaviorVariableGroup semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorVariable returns BehaviorVariable
     *
     * Constraint:
     *     (name=ID arrayDimensions+=ArrayDimension*)
     * </pre>
     */
    protected void sequence_BehaviorVariable(ISerializationContext context, BehaviorVariable semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns CommunicationAction
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns CommunicationAction
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns CommunicationAction
     *     BehaviorAction returns CommunicationAction
     *     CommunicationAction returns CommunicationAction
     *
     * Constraint:
     *     (
     *         (
     *             reference=Reference
     *             ((send?='!' (parameters+=ValueExpression parameters+=ValueExpression*)?) | (dequeue?='?' target=Reference?) | freeze?='&gt;&gt;' | lock?='!&lt;' | unlock?='!&gt;')
     *         ) |
     *         (all?='*' (allLock?='!&lt;' | allUnlock?='!&gt;'))
     *     )
     * </pre>
     */
    protected void sequence_CommunicationAction(ISerializationContext context, CommunicationAction semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     DispatchCondition returns DispatchCondition
     *
     * Constraint:
     *     (trigger=DispatchTriggerCondition | (trigger=DispatchTriggerCondition frozenPorts+=Reference frozenPorts+=Reference*))?
     * </pre>
     */
    protected void sequence_DispatchCondition(ISerializationContext context, DispatchCondition semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     DispatchConjunction returns DispatchConjunction
     *
     * Constraint:
     *     (triggers+=Reference triggers+=Reference*)
     * </pre>
     */
    protected void sequence_DispatchConjunction(ISerializationContext context, DispatchConjunction semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     DispatchTriggerCondition returns DispatchTriggerCondition
     *
     * Constraint:
     *     (expression=DispatchTriggerLogicalExpression | (timeout?='timeout' time=BehaviorTime?) | stop?='stop')
     * </pre>
     */
    protected void sequence_DispatchTriggerCondition(ISerializationContext context, DispatchTriggerCondition semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     DispatchTriggerLogicalExpression returns DispatchTriggerLogicalExpression
     *
     * Constraint:
     *     (conjunctions+=DispatchConjunction conjunctions+=DispatchConjunction*)
     * </pre>
     */
    protected void sequence_DispatchTriggerLogicalExpression(ISerializationContext context, DispatchTriggerLogicalExpression semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns DoUntilStatement
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns DoUntilStatement
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns DoUntilStatement
     *     BehaviorAction returns DoUntilStatement
     *     DoUntilStatement returns DoUntilStatement
     *
     * Constraint:
     *     (actions=BehaviorActions condition=ValueExpression)
     * </pre>
     */
    protected void sequence_DoUntilStatement(ISerializationContext context, DoUntilStatement semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.DO_UNTIL_STATEMENT__ACTIONS) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.DO_UNTIL_STATEMENT__ACTIONS));
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.DO_UNTIL_STATEMENT__CONDITION) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.DO_UNTIL_STATEMENT__CONDITION));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getDoUntilStatementAccess().getActionsBehaviorActionsParserRuleCall_1_0(), semanticObject.getActions());
        feeder.accept(grammarAccess.getDoUntilStatementAccess().getConditionValueExpressionParserRuleCall_4_0(), semanticObject.getCondition());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     ElementValues returns ElementValues
     *
     * Constraint:
     *     (lower=IntegerValue upper=IntegerValue?)
     * </pre>
     */
    protected void sequence_ElementValues(ISerializationContext context, ElementValues semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ElseIfClause returns ElseIfClause
     *
     * Constraint:
     *     (condition=ValueExpression actions=BehaviorActions)
     * </pre>
     */
    protected void sequence_ElseIfClause(ISerializationContext context, ElseIfClause semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.ELSE_IF_CLAUSE__CONDITION) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.ELSE_IF_CLAUSE__CONDITION));
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.ELSE_IF_CLAUSE__ACTIONS) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.ELSE_IF_CLAUSE__ACTIONS));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getElseIfClauseAccess().getConditionValueExpressionParserRuleCall_2_0(), semanticObject.getCondition());
        feeder.accept(grammarAccess.getElseIfClauseAccess().getActionsBehaviorActionsParserRuleCall_4_0(), semanticObject.getActions());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     ExecuteCondition returns ExecuteCondition
     *
     * Constraint:
     *     (value=ValueExpression | timeout?='timeout' | otherwise?='otherwise')
     * </pre>
     */
    protected void sequence_ExecuteCondition(ISerializationContext context, ExecuteCondition semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns ForStatement
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns ForStatement
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns ForStatement
     *     BehaviorAction returns ForStatement
     *     ForStatement returns ForStatement
     *
     * Constraint:
     *     ((for?='for' | forall?='forall') variable=ID dataClassifier=[ComponentClassifier|QCREF] values=ElementValues actions=BehaviorActions)
     * </pre>
     */
    protected void sequence_ForStatement(ISerializationContext context, ForStatement semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     IntegerValue returns HashPropertyReference
     *     ValueExpression returns HashPropertyReference
     *     LogicalOrExpression returns HashPropertyReference
     *     LogicalOrExpression.BinaryExpression_1_0 returns HashPropertyReference
     *     LogicalAndExpression returns HashPropertyReference
     *     LogicalAndExpression.BinaryExpression_1_0 returns HashPropertyReference
     *     RelationalExpression returns HashPropertyReference
     *     RelationalExpression.BinaryExpression_1_0 returns HashPropertyReference
     *     AdditiveExpression returns HashPropertyReference
     *     AdditiveExpression.BinaryExpression_1_0 returns HashPropertyReference
     *     MultiplicativeExpression returns HashPropertyReference
     *     MultiplicativeExpression.BinaryExpression_1_0 returns HashPropertyReference
     *     PowerExpression returns HashPropertyReference
     *     PowerExpression.BinaryExpression_1_0 returns HashPropertyReference
     *     UnaryExpression returns HashPropertyReference
     *     PrimaryExpression returns HashPropertyReference
     *     ValueConstant returns HashPropertyReference
     *     HashPropertyReference returns HashPropertyReference
     *
     * Constraint:
     *     (property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*)
     * </pre>
     */
    protected void sequence_HashPropertyReference(ISerializationContext context, HashPropertyReference semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns IfStatement
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns IfStatement
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns IfStatement
     *     BehaviorAction returns IfStatement
     *     IfStatement returns IfStatement
     *
     * Constraint:
     *     (condition=ValueExpression thenActions=BehaviorActions elseIfs+=ElseIfClause* elseActions=BehaviorActions?)
     * </pre>
     */
    protected void sequence_IfStatement(ISerializationContext context, IfStatement semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ModeSwitchCondition returns ModeSwitchCondition
     *
     * Constraint:
     *     (conjunctions+=ModeSwitchConjunction conjunctions+=ModeSwitchConjunction*)
     * </pre>
     */
    protected void sequence_ModeSwitchCondition(ISerializationContext context, ModeSwitchCondition semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ModeSwitchConjunction returns ModeSwitchConjunction
     *
     * Constraint:
     *     (triggers+=Reference triggers+=Reference*)
     * </pre>
     */
    protected void sequence_ModeSwitchConjunction(ISerializationContext context, ModeSwitchConjunction semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     NamedPropertyField returns NamedPropertyField
     *
     * Constraint:
     *     (name=ID indexes+=PropertyArrayIndex*)
     * </pre>
     */
    protected void sequence_NamedPropertyField(ISerializationContext context, NamedPropertyField semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     PropertyArrayIndex returns PropertyArrayIndex
     *
     * Constraint:
     *     value=PropertyIndexValue
     * </pre>
     */
    protected void sequence_PropertyArrayIndex(ISerializationContext context, PropertyArrayIndex semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.PROPERTY_ARRAY_INDEX__VALUE) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.PROPERTY_ARRAY_INDEX__VALUE));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getPropertyArrayIndexAccess().getValuePropertyIndexValueParserRuleCall_1_0(), semanticObject.getValue());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     PropertyIndexValue returns PropertyIndexPropertyReference
     *     PropertyIndexPropertyReference returns PropertyIndexPropertyReference
     *
     * Constraint:
     *     property=QualifiedName
     * </pre>
     */
    protected void sequence_PropertyIndexPropertyReference(ISerializationContext context, PropertyIndexPropertyReference semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.PROPERTY_INDEX_PROPERTY_REFERENCE__PROPERTY) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.PROPERTY_INDEX_PROPERTY_REFERENCE__PROPERTY));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getPropertyIndexPropertyReferenceAccess().getPropertyQualifiedNameParserRuleCall_1_0(), semanticObject.getProperty());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     PropertyReferenceTail returns PropertyReferenceTail
     *
     * Constraint:
     *     (property=QualifiedName indexes+=PropertyArrayIndex* fields+=NamedPropertyField*)
     * </pre>
     */
    protected void sequence_PropertyReferenceTail(ISerializationContext context, PropertyReferenceTail semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     IntegerValue returns ReferenceExpression
     *     ValueExpression returns ReferenceExpression
     *     LogicalOrExpression returns ReferenceExpression
     *     LogicalOrExpression.BinaryExpression_1_0 returns ReferenceExpression
     *     LogicalAndExpression returns ReferenceExpression
     *     LogicalAndExpression.BinaryExpression_1_0 returns ReferenceExpression
     *     RelationalExpression returns ReferenceExpression
     *     RelationalExpression.BinaryExpression_1_0 returns ReferenceExpression
     *     AdditiveExpression returns ReferenceExpression
     *     AdditiveExpression.BinaryExpression_1_0 returns ReferenceExpression
     *     MultiplicativeExpression returns ReferenceExpression
     *     MultiplicativeExpression.BinaryExpression_1_0 returns ReferenceExpression
     *     PowerExpression returns ReferenceExpression
     *     PowerExpression.BinaryExpression_1_0 returns ReferenceExpression
     *     UnaryExpression returns ReferenceExpression
     *     PrimaryExpression returns ReferenceExpression
     *     ReferenceExpression returns ReferenceExpression
     *
     * Constraint:
     *     (reference=Reference (property=PropertyReferenceTail | dequeue?='?' | count?='count' | fresh?='fresh')?)
     * </pre>
     */
    protected void sequence_ReferenceExpression(ISerializationContext context, ReferenceExpression semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ReferenceSegment returns ReferenceSegment
     *
     * Constraint:
     *     (name=ID indexes+=ArrayIndex*)
     * </pre>
     */
    protected void sequence_ReferenceSegment(ISerializationContext context, ReferenceSegment semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ReferenceTail returns ReferenceTail
     *
     * Constraint:
     *     (separator=ReferenceSeparator segment=ReferenceSegment)
     * </pre>
     */
    protected void sequence_ReferenceTail(ISerializationContext context, ReferenceTail semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.REFERENCE_TAIL__SEPARATOR) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.REFERENCE_TAIL__SEPARATOR));
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.REFERENCE_TAIL__SEGMENT) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.REFERENCE_TAIL__SEGMENT));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0(), semanticObject.getSeparator());
        feeder.accept(grammarAccess.getReferenceTailAccess().getSegmentReferenceSegmentParserRuleCall_1_0(), semanticObject.getSegment());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     Reference returns Reference
     *
     * Constraint:
     *     (segments+=ReferenceSegment tails+=ReferenceTail*)
     * </pre>
     */
    protected void sequence_Reference(ISerializationContext context, Reference semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns TimedAction
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns TimedAction
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns TimedAction
     *     BehaviorAction returns TimedAction
     *     TimedAction returns TimedAction
     *
     * Constraint:
     *     (lowerTime=BehaviorTime upperTime=BehaviorTime? (processors+=[ComponentClassifier|QCREF] processors+=[ComponentClassifier|QCREF]*)?)
     * </pre>
     */
    protected void sequence_TimedAction(ISerializationContext context, TimedAction semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     ValueExpression returns UnaryExpression
     *     LogicalOrExpression returns UnaryExpression
     *     LogicalOrExpression.BinaryExpression_1_0 returns UnaryExpression
     *     LogicalAndExpression returns UnaryExpression
     *     LogicalAndExpression.BinaryExpression_1_0 returns UnaryExpression
     *     RelationalExpression returns UnaryExpression
     *     RelationalExpression.BinaryExpression_1_0 returns UnaryExpression
     *     AdditiveExpression returns UnaryExpression
     *     AdditiveExpression.BinaryExpression_1_0 returns UnaryExpression
     *     MultiplicativeExpression returns UnaryExpression
     *     MultiplicativeExpression.BinaryExpression_1_0 returns UnaryExpression
     *     PowerExpression returns UnaryExpression
     *     PowerExpression.BinaryExpression_1_0 returns UnaryExpression
     *     UnaryExpression returns UnaryExpression
     *     PrimaryExpression returns UnaryExpression
     *
     * Constraint:
     *     ((operator='+' | operator='-' | operator='abs' | operator='not') operand=UnaryExpression)
     * </pre>
     */
    protected void sequence_UnaryExpression(ISerializationContext context, UnaryExpression semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     PropertyIndexValue returns UnindexedReferenceExpression
     *     UnindexedReferenceExpression returns UnindexedReferenceExpression
     *
     * Constraint:
     *     (reference=UnindexedReference (dequeue?='?' | count?='count' | fresh?='fresh')?)
     * </pre>
     */
    protected void sequence_UnindexedReferenceExpression(ISerializationContext context, UnindexedReferenceExpression semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     UnindexedReferenceSegment returns UnindexedReferenceSegment
     *
     * Constraint:
     *     name=ID
     * </pre>
     */
    protected void sequence_UnindexedReferenceSegment(ISerializationContext context, UnindexedReferenceSegment semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_SEGMENT__NAME) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_SEGMENT__NAME));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getUnindexedReferenceSegmentAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     UnindexedReferenceTail returns UnindexedReferenceTail
     *
     * Constraint:
     *     (separator=ReferenceSeparator segment=UnindexedReferenceSegment)
     * </pre>
     */
    protected void sequence_UnindexedReferenceTail(ISerializationContext context, UnindexedReferenceTail semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_TAIL__SEPARATOR) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_TAIL__SEPARATOR));
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_TAIL__SEGMENT) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_TAIL__SEGMENT));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getUnindexedReferenceTailAccess().getSeparatorReferenceSeparatorParserRuleCall_0_0(), semanticObject.getSeparator());
        feeder.accept(grammarAccess.getUnindexedReferenceTailAccess().getSegmentUnindexedReferenceSegmentParserRuleCall_1_0(), semanticObject.getSegment());
        feeder.finish();
    }


    /**
     * <pre>
     * Contexts:
     *     UnindexedReference returns UnindexedReference
     *
     * Constraint:
     *     (segments+=UnindexedReferenceSegment tails+=UnindexedReferenceTail*)
     * </pre>
     */
    protected void sequence_UnindexedReference(ISerializationContext context, UnindexedReference semanticObject) {
        genericSequencer.createSequence(context, semanticObject);
    }


    /**
     * <pre>
     * Contexts:
     *     BehaviorActions returns WhileStatement
     *     BehaviorActions.BehaviorActionSequence_1_0_0 returns WhileStatement
     *     BehaviorActions.BehaviorActionSet_1_1_0 returns WhileStatement
     *     BehaviorAction returns WhileStatement
     *     WhileStatement returns WhileStatement
     *
     * Constraint:
     *     (condition=ValueExpression actions=BehaviorActions)
     * </pre>
     */
    protected void sequence_WhileStatement(ISerializationContext context, WhileStatement semanticObject) {
        if (errorAcceptor != null) {
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.WHILE_STATEMENT__CONDITION) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.WHILE_STATEMENT__CONDITION));
            if (transientValues.isValueTransient(semanticObject, BehaviorAnnexPackage.Literals.WHILE_STATEMENT__ACTIONS) == ValueTransient.YES)
                errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BehaviorAnnexPackage.Literals.WHILE_STATEMENT__ACTIONS));
        }
        SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
        feeder.accept(grammarAccess.getWhileStatementAccess().getConditionValueExpressionParserRuleCall_2_0(), semanticObject.getCondition());
        feeder.accept(grammarAccess.getWhileStatementAccess().getActionsBehaviorActionsParserRuleCall_5_0(), semanticObject.getActions());
        feeder.finish();
    }


}
