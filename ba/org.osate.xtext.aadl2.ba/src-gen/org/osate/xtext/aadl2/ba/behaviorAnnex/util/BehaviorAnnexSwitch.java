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
package org.osate.xtext.aadl2.ba.behaviorAnnex.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

import org.osate.xtext.aadl2.ba.behaviorAnnex.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage
 * @generated
 */
public class BehaviorAnnexSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static BehaviorAnnexPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorAnnexSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = BehaviorAnnexPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case BehaviorAnnexPackage.BEHAVIOR_ANNEX:
      {
        BehaviorAnnex behaviorAnnex = (BehaviorAnnex)theEObject;
        T result = caseBehaviorAnnex(behaviorAnnex);
        if (result == null) result = caseAnnexSubclause(behaviorAnnex);
        if (result == null) result = caseModalElement(behaviorAnnex);
        if (result == null) result = caseNamedElement(behaviorAnnex);
        if (result == null) result = caseElement(behaviorAnnex);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE_GROUP:
      {
        BehaviorVariableGroup behaviorVariableGroup = (BehaviorVariableGroup)theEObject;
        T result = caseBehaviorVariableGroup(behaviorVariableGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_VARIABLE:
      {
        BehaviorVariable behaviorVariable = (BehaviorVariable)theEObject;
        T result = caseBehaviorVariable(behaviorVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.ARRAY_DIMENSION:
      {
        ArrayDimension arrayDimension = (ArrayDimension)theEObject;
        T result = caseArrayDimension(arrayDimension);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_PROPERTY_ASSOCIATION:
      {
        BehaviorPropertyAssociation behaviorPropertyAssociation = (BehaviorPropertyAssociation)theEObject;
        T result = caseBehaviorPropertyAssociation(behaviorPropertyAssociation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_STATE_GROUP:
      {
        BehaviorStateGroup behaviorStateGroup = (BehaviorStateGroup)theEObject;
        T result = caseBehaviorStateGroup(behaviorStateGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_STATE:
      {
        BehaviorState behaviorState = (BehaviorState)theEObject;
        T result = caseBehaviorState(behaviorState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_TRANSITION:
      {
        BehaviorTransition behaviorTransition = (BehaviorTransition)theEObject;
        T result = caseBehaviorTransition(behaviorTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_CONDITION:
      {
        BehaviorCondition behaviorCondition = (BehaviorCondition)theEObject;
        T result = caseBehaviorCondition(behaviorCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.EXECUTE_CONDITION:
      {
        ExecuteCondition executeCondition = (ExecuteCondition)theEObject;
        T result = caseExecuteCondition(executeCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.DISPATCH_CONDITION:
      {
        DispatchCondition dispatchCondition = (DispatchCondition)theEObject;
        T result = caseDispatchCondition(dispatchCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_CONDITION:
      {
        DispatchTriggerCondition dispatchTriggerCondition = (DispatchTriggerCondition)theEObject;
        T result = caseDispatchTriggerCondition(dispatchTriggerCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION:
      {
        DispatchTriggerLogicalExpression dispatchTriggerLogicalExpression = (DispatchTriggerLogicalExpression)theEObject;
        T result = caseDispatchTriggerLogicalExpression(dispatchTriggerLogicalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.DISPATCH_CONJUNCTION:
      {
        DispatchConjunction dispatchConjunction = (DispatchConjunction)theEObject;
        T result = caseDispatchConjunction(dispatchConjunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.MODE_SWITCH_CONDITION:
      {
        ModeSwitchCondition modeSwitchCondition = (ModeSwitchCondition)theEObject;
        T result = caseModeSwitchCondition(modeSwitchCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.MODE_SWITCH_CONJUNCTION:
      {
        ModeSwitchConjunction modeSwitchConjunction = (ModeSwitchConjunction)theEObject;
        T result = caseModeSwitchConjunction(modeSwitchConjunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_ACTION_BLOCK:
      {
        BehaviorActionBlock behaviorActionBlock = (BehaviorActionBlock)theEObject;
        T result = caseBehaviorActionBlock(behaviorActionBlock);
        if (result == null) result = caseBehaviorAction(behaviorActionBlock);
        if (result == null) result = caseBehaviorActions(behaviorActionBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_ACTIONS:
      {
        BehaviorActions behaviorActions = (BehaviorActions)theEObject;
        T result = caseBehaviorActions(behaviorActions);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_ACTION:
      {
        BehaviorAction behaviorAction = (BehaviorAction)theEObject;
        T result = caseBehaviorAction(behaviorAction);
        if (result == null) result = caseBehaviorActions(behaviorAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.ASSIGNMENT_ACTION:
      {
        AssignmentAction assignmentAction = (AssignmentAction)theEObject;
        T result = caseAssignmentAction(assignmentAction);
        if (result == null) result = caseBehaviorAction(assignmentAction);
        if (result == null) result = caseBehaviorActions(assignmentAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.COMMUNICATION_ACTION:
      {
        CommunicationAction communicationAction = (CommunicationAction)theEObject;
        T result = caseCommunicationAction(communicationAction);
        if (result == null) result = caseBehaviorAction(communicationAction);
        if (result == null) result = caseBehaviorActions(communicationAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.TIMED_ACTION:
      {
        TimedAction timedAction = (TimedAction)theEObject;
        T result = caseTimedAction(timedAction);
        if (result == null) result = caseBehaviorAction(timedAction);
        if (result == null) result = caseBehaviorActions(timedAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.IF_STATEMENT:
      {
        IfStatement ifStatement = (IfStatement)theEObject;
        T result = caseIfStatement(ifStatement);
        if (result == null) result = caseBehaviorAction(ifStatement);
        if (result == null) result = caseBehaviorActions(ifStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.ELSE_IF_CLAUSE:
      {
        ElseIfClause elseIfClause = (ElseIfClause)theEObject;
        T result = caseElseIfClause(elseIfClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.FOR_STATEMENT:
      {
        ForStatement forStatement = (ForStatement)theEObject;
        T result = caseForStatement(forStatement);
        if (result == null) result = caseBehaviorAction(forStatement);
        if (result == null) result = caseBehaviorActions(forStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.WHILE_STATEMENT:
      {
        WhileStatement whileStatement = (WhileStatement)theEObject;
        T result = caseWhileStatement(whileStatement);
        if (result == null) result = caseBehaviorAction(whileStatement);
        if (result == null) result = caseBehaviorActions(whileStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.DO_UNTIL_STATEMENT:
      {
        DoUntilStatement doUntilStatement = (DoUntilStatement)theEObject;
        T result = caseDoUntilStatement(doUntilStatement);
        if (result == null) result = caseBehaviorAction(doUntilStatement);
        if (result == null) result = caseBehaviorActions(doUntilStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.ELEMENT_VALUES:
      {
        ElementValues elementValues = (ElementValues)theEObject;
        T result = caseElementValues(elementValues);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_TIME:
      {
        BehaviorTime behaviorTime = (BehaviorTime)theEObject;
        T result = caseBehaviorTime(behaviorTime);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.INTEGER_VALUE:
      {
        IntegerValue integerValue = (IntegerValue)theEObject;
        T result = caseIntegerValue(integerValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.VALUE_EXPRESSION:
      {
        ValueExpression valueExpression = (ValueExpression)theEObject;
        T result = caseValueExpression(valueExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.VALUE_CONSTANT:
      {
        ValueConstant valueConstant = (ValueConstant)theEObject;
        T result = caseValueConstant(valueConstant);
        if (result == null) result = caseValueExpression(valueConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_INTEGER_LITERAL:
      {
        BehaviorIntegerLiteral behaviorIntegerLiteral = (BehaviorIntegerLiteral)theEObject;
        T result = caseBehaviorIntegerLiteral(behaviorIntegerLiteral);
        if (result == null) result = caseIntegerValue(behaviorIntegerLiteral);
        if (result == null) result = caseValueConstant(behaviorIntegerLiteral);
        if (result == null) result = casePropertyIndexValue(behaviorIntegerLiteral);
        if (result == null) result = caseValueExpression(behaviorIntegerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_REAL_LITERAL:
      {
        BehaviorRealLiteral behaviorRealLiteral = (BehaviorRealLiteral)theEObject;
        T result = caseBehaviorRealLiteral(behaviorRealLiteral);
        if (result == null) result = caseValueConstant(behaviorRealLiteral);
        if (result == null) result = caseValueExpression(behaviorRealLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_STRING_LITERAL:
      {
        BehaviorStringLiteral behaviorStringLiteral = (BehaviorStringLiteral)theEObject;
        T result = caseBehaviorStringLiteral(behaviorStringLiteral);
        if (result == null) result = caseValueConstant(behaviorStringLiteral);
        if (result == null) result = caseValueExpression(behaviorStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_BOOLEAN_LITERAL:
      {
        BehaviorBooleanLiteral behaviorBooleanLiteral = (BehaviorBooleanLiteral)theEObject;
        T result = caseBehaviorBooleanLiteral(behaviorBooleanLiteral);
        if (result == null) result = caseValueConstant(behaviorBooleanLiteral);
        if (result == null) result = caseValueExpression(behaviorBooleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.REFERENCE_EXPRESSION:
      {
        ReferenceExpression referenceExpression = (ReferenceExpression)theEObject;
        T result = caseReferenceExpression(referenceExpression);
        if (result == null) result = caseIntegerValue(referenceExpression);
        if (result == null) result = caseValueExpression(referenceExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.HASH_PROPERTY_REFERENCE:
      {
        HashPropertyReference hashPropertyReference = (HashPropertyReference)theEObject;
        T result = caseHashPropertyReference(hashPropertyReference);
        if (result == null) result = caseIntegerValue(hashPropertyReference);
        if (result == null) result = caseValueConstant(hashPropertyReference);
        if (result == null) result = caseValueExpression(hashPropertyReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.PROPERTY_REFERENCE_TAIL:
      {
        PropertyReferenceTail propertyReferenceTail = (PropertyReferenceTail)theEObject;
        T result = casePropertyReferenceTail(propertyReferenceTail);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.NAMED_PROPERTY_FIELD:
      {
        NamedPropertyField namedPropertyField = (NamedPropertyField)theEObject;
        T result = caseNamedPropertyField(namedPropertyField);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.PROPERTY_ARRAY_INDEX:
      {
        PropertyArrayIndex propertyArrayIndex = (PropertyArrayIndex)theEObject;
        T result = casePropertyArrayIndex(propertyArrayIndex);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.PROPERTY_INDEX_VALUE:
      {
        PropertyIndexValue propertyIndexValue = (PropertyIndexValue)theEObject;
        T result = casePropertyIndexValue(propertyIndexValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.PROPERTY_INDEX_PROPERTY_REFERENCE:
      {
        PropertyIndexPropertyReference propertyIndexPropertyReference = (PropertyIndexPropertyReference)theEObject;
        T result = casePropertyIndexPropertyReference(propertyIndexPropertyReference);
        if (result == null) result = casePropertyIndexValue(propertyIndexPropertyReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION:
      {
        UnindexedReferenceExpression unindexedReferenceExpression = (UnindexedReferenceExpression)theEObject;
        T result = caseUnindexedReferenceExpression(unindexedReferenceExpression);
        if (result == null) result = casePropertyIndexValue(unindexedReferenceExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE:
      {
        UnindexedReference unindexedReference = (UnindexedReference)theEObject;
        T result = caseUnindexedReference(unindexedReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_TAIL:
      {
        UnindexedReferenceTail unindexedReferenceTail = (UnindexedReferenceTail)theEObject;
        T result = caseUnindexedReferenceTail(unindexedReferenceTail);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_SEGMENT:
      {
        UnindexedReferenceSegment unindexedReferenceSegment = (UnindexedReferenceSegment)theEObject;
        T result = caseUnindexedReferenceSegment(unindexedReferenceSegment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.REFERENCE:
      {
        Reference reference = (Reference)theEObject;
        T result = caseReference(reference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.REFERENCE_TAIL:
      {
        ReferenceTail referenceTail = (ReferenceTail)theEObject;
        T result = caseReferenceTail(referenceTail);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.REFERENCE_SEGMENT:
      {
        ReferenceSegment referenceSegment = (ReferenceSegment)theEObject;
        T result = caseReferenceSegment(referenceSegment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.ARRAY_INDEX:
      {
        ArrayIndex arrayIndex = (ArrayIndex)theEObject;
        T result = caseArrayIndex(arrayIndex);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_ACTION_SEQUENCE:
      {
        BehaviorActionSequence behaviorActionSequence = (BehaviorActionSequence)theEObject;
        T result = caseBehaviorActionSequence(behaviorActionSequence);
        if (result == null) result = caseBehaviorActions(behaviorActionSequence);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BEHAVIOR_ACTION_SET:
      {
        BehaviorActionSet behaviorActionSet = (BehaviorActionSet)theEObject;
        T result = caseBehaviorActionSet(behaviorActionSet);
        if (result == null) result = caseBehaviorActions(behaviorActionSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.BINARY_EXPRESSION:
      {
        BinaryExpression binaryExpression = (BinaryExpression)theEObject;
        T result = caseBinaryExpression(binaryExpression);
        if (result == null) result = caseValueExpression(binaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BehaviorAnnexPackage.UNARY_EXPRESSION:
      {
        UnaryExpression unaryExpression = (UnaryExpression)theEObject;
        T result = caseUnaryExpression(unaryExpression);
        if (result == null) result = caseValueExpression(unaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Annex</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Annex</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorAnnex(BehaviorAnnex object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Variable Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Variable Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorVariableGroup(BehaviorVariableGroup object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorVariable(BehaviorVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayDimension(ArrayDimension object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Property Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Property Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorPropertyAssociation(BehaviorPropertyAssociation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior State Group</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior State Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorStateGroup(BehaviorStateGroup object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorState(BehaviorState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorTransition(BehaviorTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorCondition(BehaviorCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Execute Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Execute Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecuteCondition(ExecuteCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchCondition(DispatchCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Trigger Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Trigger Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchTriggerCondition(DispatchTriggerCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Trigger Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Trigger Logical Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Conjunction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Conjunction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchConjunction(DispatchConjunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mode Switch Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mode Switch Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModeSwitchCondition(ModeSwitchCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mode Switch Conjunction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mode Switch Conjunction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModeSwitchConjunction(ModeSwitchConjunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Action Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Action Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorActionBlock(BehaviorActionBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Actions</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Actions</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorActions(BehaviorActions object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorAction(BehaviorAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentAction(AssignmentAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Communication Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Communication Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommunicationAction(CommunicationAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Timed Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Timed Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimedAction(TimedAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfStatement(IfStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Else If Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Else If Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElseIfClause(ElseIfClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForStatement(ForStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhileStatement(WhileStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Do Until Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Do Until Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoUntilStatement(DoUntilStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementValues(ElementValues object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Time</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Time</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorTime(BehaviorTime object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValue(IntegerValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueExpression(ValueExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueConstant(ValueConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Real Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Real Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorRealLiteral(BehaviorRealLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorStringLiteral(BehaviorStringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceExpression(ReferenceExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hash Property Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hash Property Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHashPropertyReference(HashPropertyReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Reference Tail</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Reference Tail</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyReferenceTail(PropertyReferenceTail object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Property Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Property Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedPropertyField(NamedPropertyField object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Array Index</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Array Index</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyArrayIndex(PropertyArrayIndex object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Index Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Index Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyIndexValue(PropertyIndexValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Index Property Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Index Property Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyIndexPropertyReference(PropertyIndexPropertyReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unindexed Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unindexed Reference Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnindexedReferenceExpression(UnindexedReferenceExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unindexed Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unindexed Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnindexedReference(UnindexedReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unindexed Reference Tail</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unindexed Reference Tail</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnindexedReferenceTail(UnindexedReferenceTail object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unindexed Reference Segment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unindexed Reference Segment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnindexedReferenceSegment(UnindexedReferenceSegment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReference(Reference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Tail</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Tail</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceTail(ReferenceTail object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Segment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Segment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceSegment(ReferenceSegment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Index</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Index</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayIndex(ArrayIndex object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Action Sequence</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Action Sequence</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorActionSequence(BehaviorActionSequence object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Action Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Action Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorActionSet(BehaviorActionSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryExpression(BinaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryExpression(UnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Modal Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Modal Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModalElement(ModalElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annex Subclause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnexSubclause(AnnexSubclause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //BehaviorAnnexSwitch
