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
package org.osate.xtext.aadl2.ba.behaviorAnnex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.xtext.aadl2.ba.behaviorAnnex.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BehaviorAnnexFactoryImpl extends EFactoryImpl implements BehaviorAnnexFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BehaviorAnnexFactory init()
  {
    try
    {
      BehaviorAnnexFactory theBehaviorAnnexFactory = (BehaviorAnnexFactory)EPackage.Registry.INSTANCE.getEFactory(BehaviorAnnexPackage.eNS_URI);
      if (theBehaviorAnnexFactory != null)
      {
        return theBehaviorAnnexFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BehaviorAnnexFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorAnnexFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX: return createBehaviorAnnex();
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP: return createBehaviorVariableGroup();
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE: return createBehaviorVariable();
      case BehaviorAnnexPackage.ARRAY_DIMENSION: return createArrayDimension();
      case BehaviorAnnexPackage.BEHAVIOR_PROPERTY_ASSOCIATION: return createBehaviorPropertyAssociation();
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP: return createBehaviorStateGroup();
      case BehaviorAnnexPackage.BEHAVIOR_STATE: return createBehaviorState();
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION: return createBehaviorTransition();
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION: return createBehaviorCondition();
      case BehaviorAnnexPackage.EXECUTE_CONDITION: return createExecuteCondition();
      case BehaviorAnnexPackage.DISPATCH_CONDITION: return createDispatchCondition();
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION: return createDispatchTriggerCondition();
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION: return createDispatchTriggerLogicalExpression();
      case BehaviorAnnexPackage.DISPATCH_CONJUNCTION: return createDispatchConjunction();
      case BehaviorAnnexPackage.MODE_SWITCH_CONDITION: return createModeSwitchCondition();
      case BehaviorAnnexPackage.MODE_SWITCH_CONJUNCTION: return createModeSwitchConjunction();
      case BehaviorAnnexPackage.BEHAVIOR_ACTION_BLOCK: return createBehaviorActionBlock();
      case BehaviorAnnexPackage.BEHAVIOR_ACTIONS: return createBehaviorActions();
      case BehaviorAnnexPackage.BEHAVIOR_ACTION: return createBehaviorAction();
      case BehaviorAnnexPackage.ASSIGNMENT_ACTION: return createAssignmentAction();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION: return createCommunicationAction();
      case BehaviorAnnexPackage.TIMED_ACTION: return createTimedAction();
      case BehaviorAnnexPackage.IF_STATEMENT: return createIfStatement();
      case BehaviorAnnexPackage.ELSE_IF_CLAUSE: return createElseIfClause();
      case BehaviorAnnexPackage.FOR_STATEMENT: return createForStatement();
      case BehaviorAnnexPackage.WHILE_STATEMENT: return createWhileStatement();
      case BehaviorAnnexPackage.DO_UNTIL_STATEMENT: return createDoUntilStatement();
      case BehaviorAnnexPackage.ELEMENT_VALUES: return createElementValues();
      case BehaviorAnnexPackage.BEHAVIOR_TIME: return createBehaviorTime();
      case BehaviorAnnexPackage.INTEGER_VALUE: return createIntegerValue();
      case BehaviorAnnexPackage.VALUE_EXPRESSION: return createValueExpression();
      case BehaviorAnnexPackage.VALUE_CONSTANT: return createValueConstant();
      case BehaviorAnnexPackage.BEHAVIOR_INTEGER_LITERAL: return createBehaviorIntegerLiteral();
      case BehaviorAnnexPackage.BEHAVIOR_REAL_LITERAL: return createBehaviorRealLiteral();
      case BehaviorAnnexPackage.BEHAVIOR_STRING_LITERAL: return createBehaviorStringLiteral();
      case BehaviorAnnexPackage.BEHAVIOR_BOOLEAN_LITERAL: return createBehaviorBooleanLiteral();
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION: return createReferenceExpression();
      case BehaviorAnnexPackage.HASH_PROPERTY_REFERENCE: return createHashPropertyReference();
      case BehaviorAnnexPackage.PROPERTY_REFERENCE_TAIL: return createPropertyReferenceTail();
      case BehaviorAnnexPackage.NAMED_PROPERTY_FIELD: return createNamedPropertyField();
      case BehaviorAnnexPackage.PROPERTY_ARRAY_INDEX: return createPropertyArrayIndex();
      case BehaviorAnnexPackage.PROPERTY_INDEX_VALUE: return createPropertyIndexValue();
      case BehaviorAnnexPackage.PROPERTY_INDEX_PROPERTY_REFERENCE: return createPropertyIndexPropertyReference();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION: return createUnindexedReferenceExpression();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE: return createUnindexedReference();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL: return createUnindexedReferenceTail();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_SEGMENT: return createUnindexedReferenceSegment();
      case BehaviorAnnexPackage.REFERENCE: return createReference();
      case BehaviorAnnexPackage.REFERENCE_TAIL: return createReferenceTail();
      case BehaviorAnnexPackage.REFERENCE_SEGMENT: return createReferenceSegment();
      case BehaviorAnnexPackage.ARRAY_INDEX: return createArrayIndex();
      case BehaviorAnnexPackage.BEHAVIOR_ACTION_SEQUENCE: return createBehaviorActionSequence();
      case BehaviorAnnexPackage.BEHAVIOR_ACTION_SET: return createBehaviorActionSet();
      case BehaviorAnnexPackage.BINARY_EXPRESSION: return createBinaryExpression();
      case BehaviorAnnexPackage.UNARY_EXPRESSION: return createUnaryExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorAnnex createBehaviorAnnex()
  {
    BehaviorAnnexImpl behaviorAnnex = new BehaviorAnnexImpl();
    return behaviorAnnex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorVariableGroup createBehaviorVariableGroup()
  {
    BehaviorVariableGroupImpl behaviorVariableGroup = new BehaviorVariableGroupImpl();
    return behaviorVariableGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorVariable createBehaviorVariable()
  {
    BehaviorVariableImpl behaviorVariable = new BehaviorVariableImpl();
    return behaviorVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArrayDimension createArrayDimension()
  {
    ArrayDimensionImpl arrayDimension = new ArrayDimensionImpl();
    return arrayDimension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorPropertyAssociation createBehaviorPropertyAssociation()
  {
    BehaviorPropertyAssociationImpl behaviorPropertyAssociation = new BehaviorPropertyAssociationImpl();
    return behaviorPropertyAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorStateGroup createBehaviorStateGroup()
  {
    BehaviorStateGroupImpl behaviorStateGroup = new BehaviorStateGroupImpl();
    return behaviorStateGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorState createBehaviorState()
  {
    BehaviorStateImpl behaviorState = new BehaviorStateImpl();
    return behaviorState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorTransition createBehaviorTransition()
  {
    BehaviorTransitionImpl behaviorTransition = new BehaviorTransitionImpl();
    return behaviorTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorCondition createBehaviorCondition()
  {
    BehaviorConditionImpl behaviorCondition = new BehaviorConditionImpl();
    return behaviorCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExecuteCondition createExecuteCondition()
  {
    ExecuteConditionImpl executeCondition = new ExecuteConditionImpl();
    return executeCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DispatchCondition createDispatchCondition()
  {
    DispatchConditionImpl dispatchCondition = new DispatchConditionImpl();
    return dispatchCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DispatchTriggerCondition createDispatchTriggerCondition()
  {
    DispatchTriggerConditionImpl dispatchTriggerCondition = new DispatchTriggerConditionImpl();
    return dispatchTriggerCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DispatchTriggerLogicalExpression createDispatchTriggerLogicalExpression()
  {
    DispatchTriggerLogicalExpressionImpl dispatchTriggerLogicalExpression = new DispatchTriggerLogicalExpressionImpl();
    return dispatchTriggerLogicalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DispatchConjunction createDispatchConjunction()
  {
    DispatchConjunctionImpl dispatchConjunction = new DispatchConjunctionImpl();
    return dispatchConjunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModeSwitchCondition createModeSwitchCondition()
  {
    ModeSwitchConditionImpl modeSwitchCondition = new ModeSwitchConditionImpl();
    return modeSwitchCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModeSwitchConjunction createModeSwitchConjunction()
  {
    ModeSwitchConjunctionImpl modeSwitchConjunction = new ModeSwitchConjunctionImpl();
    return modeSwitchConjunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActionBlock createBehaviorActionBlock()
  {
    BehaviorActionBlockImpl behaviorActionBlock = new BehaviorActionBlockImpl();
    return behaviorActionBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActions createBehaviorActions()
  {
    BehaviorActionsImpl behaviorActions = new BehaviorActionsImpl();
    return behaviorActions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorAction createBehaviorAction()
  {
    BehaviorActionImpl behaviorAction = new BehaviorActionImpl();
    return behaviorAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssignmentAction createAssignmentAction()
  {
    AssignmentActionImpl assignmentAction = new AssignmentActionImpl();
    return assignmentAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CommunicationAction createCommunicationAction()
  {
    CommunicationActionImpl communicationAction = new CommunicationActionImpl();
    return communicationAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimedAction createTimedAction()
  {
    TimedActionImpl timedAction = new TimedActionImpl();
    return timedAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElseIfClause createElseIfClause()
  {
    ElseIfClauseImpl elseIfClause = new ElseIfClauseImpl();
    return elseIfClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ForStatement createForStatement()
  {
    ForStatementImpl forStatement = new ForStatementImpl();
    return forStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DoUntilStatement createDoUntilStatement()
  {
    DoUntilStatementImpl doUntilStatement = new DoUntilStatementImpl();
    return doUntilStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ElementValues createElementValues()
  {
    ElementValuesImpl elementValues = new ElementValuesImpl();
    return elementValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorTime createBehaviorTime()
  {
    BehaviorTimeImpl behaviorTime = new BehaviorTimeImpl();
    return behaviorTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntegerValue createIntegerValue()
  {
    IntegerValueImpl integerValue = new IntegerValueImpl();
    return integerValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueExpression createValueExpression()
  {
    ValueExpressionImpl valueExpression = new ValueExpressionImpl();
    return valueExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueConstant createValueConstant()
  {
    ValueConstantImpl valueConstant = new ValueConstantImpl();
    return valueConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorIntegerLiteral createBehaviorIntegerLiteral()
  {
    BehaviorIntegerLiteralImpl behaviorIntegerLiteral = new BehaviorIntegerLiteralImpl();
    return behaviorIntegerLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorRealLiteral createBehaviorRealLiteral()
  {
    BehaviorRealLiteralImpl behaviorRealLiteral = new BehaviorRealLiteralImpl();
    return behaviorRealLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorStringLiteral createBehaviorStringLiteral()
  {
    BehaviorStringLiteralImpl behaviorStringLiteral = new BehaviorStringLiteralImpl();
    return behaviorStringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorBooleanLiteral createBehaviorBooleanLiteral()
  {
    BehaviorBooleanLiteralImpl behaviorBooleanLiteral = new BehaviorBooleanLiteralImpl();
    return behaviorBooleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReferenceExpression createReferenceExpression()
  {
    ReferenceExpressionImpl referenceExpression = new ReferenceExpressionImpl();
    return referenceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public HashPropertyReference createHashPropertyReference()
  {
    HashPropertyReferenceImpl hashPropertyReference = new HashPropertyReferenceImpl();
    return hashPropertyReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyReferenceTail createPropertyReferenceTail()
  {
    PropertyReferenceTailImpl propertyReferenceTail = new PropertyReferenceTailImpl();
    return propertyReferenceTail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedPropertyField createNamedPropertyField()
  {
    NamedPropertyFieldImpl namedPropertyField = new NamedPropertyFieldImpl();
    return namedPropertyField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyArrayIndex createPropertyArrayIndex()
  {
    PropertyArrayIndexImpl propertyArrayIndex = new PropertyArrayIndexImpl();
    return propertyArrayIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyIndexValue createPropertyIndexValue()
  {
    PropertyIndexValueImpl propertyIndexValue = new PropertyIndexValueImpl();
    return propertyIndexValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyIndexPropertyReference createPropertyIndexPropertyReference()
  {
    PropertyIndexPropertyReferenceImpl propertyIndexPropertyReference = new PropertyIndexPropertyReferenceImpl();
    return propertyIndexPropertyReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnindexedReferenceExpression createUnindexedReferenceExpression()
  {
    UnindexedReferenceExpressionImpl unindexedReferenceExpression = new UnindexedReferenceExpressionImpl();
    return unindexedReferenceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnindexedReference createUnindexedReference()
  {
    UnindexedReferenceImpl unindexedReference = new UnindexedReferenceImpl();
    return unindexedReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnindexedReferenceTail createUnindexedReferenceTail()
  {
    UnindexedReferenceTailImpl unindexedReferenceTail = new UnindexedReferenceTailImpl();
    return unindexedReferenceTail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnindexedReferenceSegment createUnindexedReferenceSegment()
  {
    UnindexedReferenceSegmentImpl unindexedReferenceSegment = new UnindexedReferenceSegmentImpl();
    return unindexedReferenceSegment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Reference createReference()
  {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReferenceTail createReferenceTail()
  {
    ReferenceTailImpl referenceTail = new ReferenceTailImpl();
    return referenceTail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReferenceSegment createReferenceSegment()
  {
    ReferenceSegmentImpl referenceSegment = new ReferenceSegmentImpl();
    return referenceSegment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArrayIndex createArrayIndex()
  {
    ArrayIndexImpl arrayIndex = new ArrayIndexImpl();
    return arrayIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActionSequence createBehaviorActionSequence()
  {
    BehaviorActionSequenceImpl behaviorActionSequence = new BehaviorActionSequenceImpl();
    return behaviorActionSequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorActionSet createBehaviorActionSet()
  {
    BehaviorActionSetImpl behaviorActionSet = new BehaviorActionSetImpl();
    return behaviorActionSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BinaryExpression createBinaryExpression()
  {
    BinaryExpressionImpl binaryExpression = new BinaryExpressionImpl();
    return binaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BehaviorAnnexPackage getBehaviorAnnexPackage()
  {
    return (BehaviorAnnexPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BehaviorAnnexPackage getPackage()
  {
    return BehaviorAnnexPackage.eINSTANCE;
  }

} //BehaviorAnnexFactoryImpl
