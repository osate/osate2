/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba.util;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Data;
import org.osate.aadl2.Element;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.ba.aadlba.* ;

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
 * @see org.osate.ba.aadlba.AadlBaPackage
 * @generated
 */
public class AadlBaSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AadlBaPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AadlBaSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AadlBaPackage.eINSTANCE;
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
      case AadlBaPackage.ACTUAL_PORT_HOLDER:
      {
        ActualPortHolder actualPortHolder = (ActualPortHolder)theEObject;
        T result = caseActualPortHolder(actualPortHolder);
        if (result == null) result = casePortHolder(actualPortHolder);
        if (result == null) result = caseIntegerValueVariable(actualPortHolder);
        if (result == null) result = caseFeatureHolder(actualPortHolder);
        if (result == null) result = caseValueVariable(actualPortHolder);
        if (result == null) result = caseValue(actualPortHolder);
        if (result == null) result = caseIntegerValue(actualPortHolder);
        if (result == null) result = caseClassifierFeatureHolder(actualPortHolder);
        if (result == null) result = caseIndexableElement(actualPortHolder);
        if (result == null) result = caseGroupableElement(actualPortHolder);
        if (result == null) result = caseElementHolder(actualPortHolder);
        if (result == null) result = caseBehaviorElement(actualPortHolder);
        if (result == null) result = caseElement(actualPortHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ASSIGNMENT_ACTION:
      {
        AssignmentAction assignmentAction = (AssignmentAction)theEObject;
        T result = caseAssignmentAction(assignmentAction);
        if (result == null) result = caseBasicAction(assignmentAction);
        if (result == null) result = caseBehaviorAction(assignmentAction);
        if (result == null) result = caseBehaviorActions(assignmentAction);
        if (result == null) result = caseBehaviorElement(assignmentAction);
        if (result == null) result = caseElement(assignmentAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ANY:
      {
        Any any = (Any)theEObject;
        T result = caseAny(any);
        if (result == null) result = caseValueExpression(any);
        if (result == null) result = caseValue(any);
        if (result == null) result = caseParameterLabel(any);
        if (result == null) result = caseExecuteCondition(any);
        if (result == null) result = caseBehaviorCondition(any);
        if (result == null) result = caseBehaviorElement(any);
        if (result == null) result = caseElement(any);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BASIC_ACTION:
      {
        BasicAction basicAction = (BasicAction)theEObject;
        T result = caseBasicAction(basicAction);
        if (result == null) result = caseBehaviorAction(basicAction);
        if (result == null) result = caseBehaviorActions(basicAction);
        if (result == null) result = caseBehaviorElement(basicAction);
        if (result == null) result = caseElement(basicAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BASIC_PROPERTY_HOLDER:
      {
        BasicPropertyHolder basicPropertyHolder = (BasicPropertyHolder)theEObject;
        T result = caseBasicPropertyHolder(basicPropertyHolder);
        if (result == null) result = casePropertyElementHolder(basicPropertyHolder);
        if (result == null) result = caseIndexableElement(basicPropertyHolder);
        if (result == null) result = caseBehaviorElement(basicPropertyHolder);
        if (result == null) result = caseElement(basicPropertyHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ACTION:
      {
        BehaviorAction behaviorAction = (BehaviorAction)theEObject;
        T result = caseBehaviorAction(behaviorAction);
        if (result == null) result = caseBehaviorActions(behaviorAction);
        if (result == null) result = caseBehaviorElement(behaviorAction);
        if (result == null) result = caseElement(behaviorAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ACTION_BLOCK:
      {
        BehaviorActionBlock behaviorActionBlock = (BehaviorActionBlock)theEObject;
        T result = caseBehaviorActionBlock(behaviorActionBlock);
        if (result == null) result = caseBehaviorAction(behaviorActionBlock);
        if (result == null) result = caseBehaviorActions(behaviorActionBlock);
        if (result == null) result = caseBehaviorElement(behaviorActionBlock);
        if (result == null) result = caseElement(behaviorActionBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ACTION_COLLECTION:
      {
        BehaviorActionCollection behaviorActionCollection = (BehaviorActionCollection)theEObject;
        T result = caseBehaviorActionCollection(behaviorActionCollection);
        if (result == null) result = caseBehaviorActions(behaviorActionCollection);
        if (result == null) result = caseBehaviorElement(behaviorActionCollection);
        if (result == null) result = caseElement(behaviorActionCollection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ACTIONS:
      {
        BehaviorActions behaviorActions = (BehaviorActions)theEObject;
        T result = caseBehaviorActions(behaviorActions);
        if (result == null) result = caseBehaviorElement(behaviorActions);
        if (result == null) result = caseElement(behaviorActions);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE:
      {
        BehaviorActionSequence behaviorActionSequence = (BehaviorActionSequence)theEObject;
        T result = caseBehaviorActionSequence(behaviorActionSequence);
        if (result == null) result = caseBehaviorActionCollection(behaviorActionSequence);
        if (result == null) result = caseBehaviorActions(behaviorActionSequence);
        if (result == null) result = caseBehaviorElement(behaviorActionSequence);
        if (result == null) result = caseElement(behaviorActionSequence);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ACTION_SET:
      {
        BehaviorActionSet behaviorActionSet = (BehaviorActionSet)theEObject;
        T result = caseBehaviorActionSet(behaviorActionSet);
        if (result == null) result = caseBehaviorActionCollection(behaviorActionSet);
        if (result == null) result = caseBehaviorActions(behaviorActionSet);
        if (result == null) result = caseBehaviorElement(behaviorActionSet);
        if (result == null) result = caseElement(behaviorActionSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ANNEX:
      {
        BehaviorAnnex behaviorAnnex = (BehaviorAnnex)theEObject;
        T result = caseBehaviorAnnex(behaviorAnnex);
        if (result == null) result = caseAnnexSubclause(behaviorAnnex);
        if (result == null) result = caseBehaviorElement(behaviorAnnex);
        if (result == null) result = caseModalElement(behaviorAnnex);
        if (result == null) result = caseNamedElement(behaviorAnnex);
        if (result == null) result = caseElement(behaviorAnnex);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL:
      {
        BehaviorBooleanLiteral behaviorBooleanLiteral = (BehaviorBooleanLiteral)theEObject;
        T result = caseBehaviorBooleanLiteral(behaviorBooleanLiteral);
        if (result == null) result = caseBooleanLiteral(behaviorBooleanLiteral);
        if (result == null) result = caseLiteral(behaviorBooleanLiteral);
        if (result == null) result = casePropertyValue(behaviorBooleanLiteral);
        if (result == null) result = caseIntegerValueConstant(behaviorBooleanLiteral);
        if (result == null) result = casePropertyExpression(behaviorBooleanLiteral);
        if (result == null) result = caseValueConstant(behaviorBooleanLiteral);
        if (result == null) result = caseValue(behaviorBooleanLiteral);
        if (result == null) result = caseIntegerValue(behaviorBooleanLiteral);
        if (result == null) result = caseBehaviorElement(behaviorBooleanLiteral);
        if (result == null) result = caseElement(behaviorBooleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_CONDITION:
      {
        BehaviorCondition behaviorCondition = (BehaviorCondition)theEObject;
        T result = caseBehaviorCondition(behaviorCondition);
        if (result == null) result = caseBehaviorElement(behaviorCondition);
        if (result == null) result = caseElement(behaviorCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_ELEMENT:
      {
        BehaviorElement behaviorElement = (BehaviorElement)theEObject;
        T result = caseBehaviorElement(behaviorElement);
        if (result == null) result = caseElement(behaviorElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL:
      {
        BehaviorIntegerLiteral behaviorIntegerLiteral = (BehaviorIntegerLiteral)theEObject;
        T result = caseBehaviorIntegerLiteral(behaviorIntegerLiteral);
        if (result == null) result = caseIntegerLiteral(behaviorIntegerLiteral);
        if (result == null) result = caseNumericLiteral(behaviorIntegerLiteral);
        if (result == null) result = caseNumberValue(behaviorIntegerLiteral);
        if (result == null) result = caseLiteral(behaviorIntegerLiteral);
        if (result == null) result = casePropertyValue(behaviorIntegerLiteral);
        if (result == null) result = caseIntegerValueConstant(behaviorIntegerLiteral);
        if (result == null) result = casePropertyExpression(behaviorIntegerLiteral);
        if (result == null) result = caseValueConstant(behaviorIntegerLiteral);
        if (result == null) result = caseValue(behaviorIntegerLiteral);
        if (result == null) result = caseIntegerValue(behaviorIntegerLiteral);
        if (result == null) result = caseBehaviorElement(behaviorIntegerLiteral);
        if (result == null) result = caseElement(behaviorIntegerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT:
      {
        BehaviorNamedElement behaviorNamedElement = (BehaviorNamedElement)theEObject;
        T result = caseBehaviorNamedElement(behaviorNamedElement);
        if (result == null) result = caseNamedElement(behaviorNamedElement);
        if (result == null) result = caseBehaviorElement(behaviorNamedElement);
        if (result == null) result = caseElement(behaviorNamedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT:
      {
        BehaviorPropertyConstant behaviorPropertyConstant = (BehaviorPropertyConstant)theEObject;
        T result = caseBehaviorPropertyConstant(behaviorPropertyConstant);
        if (result == null) result = caseIntegerValueConstant(behaviorPropertyConstant);
        if (result == null) result = caseValueConstant(behaviorPropertyConstant);
        if (result == null) result = caseValue(behaviorPropertyConstant);
        if (result == null) result = caseIntegerValue(behaviorPropertyConstant);
        if (result == null) result = caseBehaviorElement(behaviorPropertyConstant);
        if (result == null) result = caseElement(behaviorPropertyConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_REAL_LITERAL:
      {
        BehaviorRealLiteral behaviorRealLiteral = (BehaviorRealLiteral)theEObject;
        T result = caseBehaviorRealLiteral(behaviorRealLiteral);
        if (result == null) result = caseRealLiteral(behaviorRealLiteral);
        if (result == null) result = caseNumericLiteral(behaviorRealLiteral);
        if (result == null) result = caseNumberValue(behaviorRealLiteral);
        if (result == null) result = caseLiteral(behaviorRealLiteral);
        if (result == null) result = casePropertyValue(behaviorRealLiteral);
        if (result == null) result = caseIntegerValueConstant(behaviorRealLiteral);
        if (result == null) result = casePropertyExpression(behaviorRealLiteral);
        if (result == null) result = caseValueConstant(behaviorRealLiteral);
        if (result == null) result = caseValue(behaviorRealLiteral);
        if (result == null) result = caseIntegerValue(behaviorRealLiteral);
        if (result == null) result = caseBehaviorElement(behaviorRealLiteral);
        if (result == null) result = caseElement(behaviorRealLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_STATE:
      {
        BehaviorState behaviorState = (BehaviorState)theEObject;
        T result = caseBehaviorState(behaviorState);
        if (result == null) result = caseBehaviorNamedElement(behaviorState);
        if (result == null) result = caseNamedElement(behaviorState);
        if (result == null) result = caseBehaviorElement(behaviorState);
        if (result == null) result = caseElement(behaviorState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_STRING_LITERAL:
      {
        BehaviorStringLiteral behaviorStringLiteral = (BehaviorStringLiteral)theEObject;
        T result = caseBehaviorStringLiteral(behaviorStringLiteral);
        if (result == null) result = caseStringLiteral(behaviorStringLiteral);
        if (result == null) result = caseLiteral(behaviorStringLiteral);
        if (result == null) result = casePropertyValue(behaviorStringLiteral);
        if (result == null) result = caseIntegerValueConstant(behaviorStringLiteral);
        if (result == null) result = casePropertyExpression(behaviorStringLiteral);
        if (result == null) result = caseValueConstant(behaviorStringLiteral);
        if (result == null) result = caseValue(behaviorStringLiteral);
        if (result == null) result = caseIntegerValue(behaviorStringLiteral);
        if (result == null) result = caseBehaviorElement(behaviorStringLiteral);
        if (result == null) result = caseElement(behaviorStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_TIME:
      {
        BehaviorTime behaviorTime = (BehaviorTime)theEObject;
        T result = caseBehaviorTime(behaviorTime);
        if (result == null) result = caseBehaviorElement(behaviorTime);
        if (result == null) result = caseElement(behaviorTime);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_TRANSITION:
      {
        BehaviorTransition behaviorTransition = (BehaviorTransition)theEObject;
        T result = caseBehaviorTransition(behaviorTransition);
        if (result == null) result = caseBehaviorNamedElement(behaviorTransition);
        if (result == null) result = caseNamedElement(behaviorTransition);
        if (result == null) result = caseBehaviorElement(behaviorTransition);
        if (result == null) result = caseElement(behaviorTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_VARIABLE:
      {
        BehaviorVariable behaviorVariable = (BehaviorVariable)theEObject;
        T result = caseBehaviorVariable(behaviorVariable);
        if (result == null) result = caseBehaviorNamedElement(behaviorVariable);
        if (result == null) result = caseArrayableElement(behaviorVariable);
        if (result == null) result = caseData(behaviorVariable);
        if (result == null) result = caseNamedElement(behaviorVariable);
        if (result == null) result = caseBehaviorElement(behaviorVariable);
        if (result == null) result = caseElement(behaviorVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.BEHAVIOR_VARIABLE_HOLDER:
      {
        BehaviorVariableHolder behaviorVariableHolder = (BehaviorVariableHolder)theEObject;
        T result = caseBehaviorVariableHolder(behaviorVariableHolder);
        if (result == null) result = caseDataHolder(behaviorVariableHolder);
        if (result == null) result = caseIndexableElement(behaviorVariableHolder);
        if (result == null) result = caseTarget(behaviorVariableHolder);
        if (result == null) result = caseElementValues(behaviorVariableHolder);
        if (result == null) result = caseSubprogramHolderProxy(behaviorVariableHolder);
        if (result == null) result = caseClassifierFeatureHolder(behaviorVariableHolder);
        if (result == null) result = caseElementHolder(behaviorVariableHolder);
        if (result == null) result = caseIntegerValueVariable(behaviorVariableHolder);
        if (result == null) result = caseParameterLabel(behaviorVariableHolder);
        if (result == null) result = caseIntegerValue(behaviorVariableHolder);
        if (result == null) result = caseValueVariable(behaviorVariableHolder);
        if (result == null) result = caseElement(behaviorVariableHolder);
        if (result == null) result = caseValue(behaviorVariableHolder);
        if (result == null) result = caseBehaviorElement(behaviorVariableHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.CALLED_SUBPROGRAM_HOLDER:
      {
        CalledSubprogramHolder calledSubprogramHolder = (CalledSubprogramHolder)theEObject;
        T result = caseCalledSubprogramHolder(calledSubprogramHolder);
        if (result == null) result = caseElementHolder(calledSubprogramHolder);
        if (result == null) result = caseIndexableElement(calledSubprogramHolder);
        if (result == null) result = caseGroupableElement(calledSubprogramHolder);
        if (result == null) result = caseBehaviorElement(calledSubprogramHolder);
        if (result == null) result = caseElement(calledSubprogramHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.CLASSIFIER_FEATURE_HOLDER:
      {
        ClassifierFeatureHolder classifierFeatureHolder = (ClassifierFeatureHolder)theEObject;
        T result = caseClassifierFeatureHolder(classifierFeatureHolder);
        if (result == null) result = caseElementHolder(classifierFeatureHolder);
        if (result == null) result = caseBehaviorElement(classifierFeatureHolder);
        if (result == null) result = caseElement(classifierFeatureHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.CLASSIFIER_FEATURE_PROPERTY_REFERENCE:
      {
        ClassifierFeaturePropertyReference classifierFeaturePropertyReference = (ClassifierFeaturePropertyReference)theEObject;
        T result = caseClassifierFeaturePropertyReference(classifierFeaturePropertyReference);
        if (result == null) result = casePropertyReference(classifierFeaturePropertyReference);
        if (result == null) result = caseIntegerValueConstant(classifierFeaturePropertyReference);
        if (result == null) result = caseValueConstant(classifierFeaturePropertyReference);
        if (result == null) result = caseValue(classifierFeaturePropertyReference);
        if (result == null) result = caseIntegerValue(classifierFeaturePropertyReference);
        if (result == null) result = caseBehaviorElement(classifierFeaturePropertyReference);
        if (result == null) result = caseElement(classifierFeaturePropertyReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.CLASSIFIER_PROPERTY_REFERENCE:
      {
        ClassifierPropertyReference classifierPropertyReference = (ClassifierPropertyReference)theEObject;
        T result = caseClassifierPropertyReference(classifierPropertyReference);
        if (result == null) result = casePropertyReference(classifierPropertyReference);
        if (result == null) result = caseIntegerValueConstant(classifierPropertyReference);
        if (result == null) result = caseValueConstant(classifierPropertyReference);
        if (result == null) result = caseValue(classifierPropertyReference);
        if (result == null) result = caseIntegerValue(classifierPropertyReference);
        if (result == null) result = caseBehaviorElement(classifierPropertyReference);
        if (result == null) result = caseElement(classifierPropertyReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.COMMUNICATION_ACTION:
      {
        CommunicationAction communicationAction = (CommunicationAction)theEObject;
        T result = caseCommunicationAction(communicationAction);
        if (result == null) result = caseBasicAction(communicationAction);
        if (result == null) result = caseBehaviorAction(communicationAction);
        if (result == null) result = caseBehaviorActions(communicationAction);
        if (result == null) result = caseBehaviorElement(communicationAction);
        if (result == null) result = caseElement(communicationAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT:
      {
        CompletionRelativeTimeout completionRelativeTimeout = (CompletionRelativeTimeout)theEObject;
        T result = caseCompletionRelativeTimeout(completionRelativeTimeout);
        if (result == null) result = caseBehaviorTime(completionRelativeTimeout);
        if (result == null) result = caseDispatchRelativeTimeout(completionRelativeTimeout);
        if (result == null) result = caseDispatchTriggerCondition(completionRelativeTimeout);
        if (result == null) result = caseBehaviorElement(completionRelativeTimeout);
        if (result == null) result = caseElement(completionRelativeTimeout);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.COND_STATEMENT:
      {
        CondStatement condStatement = (CondStatement)theEObject;
        T result = caseCondStatement(condStatement);
        if (result == null) result = caseBehaviorAction(condStatement);
        if (result == null) result = caseBehaviorActions(condStatement);
        if (result == null) result = caseBehaviorElement(condStatement);
        if (result == null) result = caseElement(condStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DATA_ACCESS_HOLDER:
      {
        DataAccessHolder dataAccessHolder = (DataAccessHolder)theEObject;
        T result = caseDataAccessHolder(dataAccessHolder);
        if (result == null) result = caseDataHolder(dataAccessHolder);
        if (result == null) result = caseTarget(dataAccessHolder);
        if (result == null) result = caseElementValues(dataAccessHolder);
        if (result == null) result = caseSubprogramHolderProxy(dataAccessHolder);
        if (result == null) result = caseFeatureHolder(dataAccessHolder);
        if (result == null) result = caseIntegerValueVariable(dataAccessHolder);
        if (result == null) result = caseParameterLabel(dataAccessHolder);
        if (result == null) result = caseClassifierFeatureHolder(dataAccessHolder);
        if (result == null) result = caseIndexableElement(dataAccessHolder);
        if (result == null) result = caseGroupableElement(dataAccessHolder);
        if (result == null) result = caseElementHolder(dataAccessHolder);
        if (result == null) result = caseIntegerValue(dataAccessHolder);
        if (result == null) result = caseValueVariable(dataAccessHolder);
        if (result == null) result = caseElement(dataAccessHolder);
        if (result == null) result = caseValue(dataAccessHolder);
        if (result == null) result = caseBehaviorElement(dataAccessHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DATA_ACCESS_PROTOTYPE_HOLDER:
      {
        DataAccessPrototypeHolder dataAccessPrototypeHolder = (DataAccessPrototypeHolder)theEObject;
        T result = caseDataAccessPrototypeHolder(dataAccessPrototypeHolder);
        if (result == null) result = caseDataHolder(dataAccessPrototypeHolder);
        if (result == null) result = casePrototypeHolder(dataAccessPrototypeHolder);
        if (result == null) result = caseTarget(dataAccessPrototypeHolder);
        if (result == null) result = caseElementValues(dataAccessPrototypeHolder);
        if (result == null) result = caseIntegerValueVariable(dataAccessPrototypeHolder);
        if (result == null) result = caseIndexableElement(dataAccessPrototypeHolder);
        if (result == null) result = caseGroupableElement(dataAccessPrototypeHolder);
        if (result == null) result = caseClassifierFeatureHolder(dataAccessPrototypeHolder);
        if (result == null) result = caseParameterLabel(dataAccessPrototypeHolder);
        if (result == null) result = caseElementHolder(dataAccessPrototypeHolder);
        if (result == null) result = caseIntegerValue(dataAccessPrototypeHolder);
        if (result == null) result = caseValueVariable(dataAccessPrototypeHolder);
        if (result == null) result = caseElement(dataAccessPrototypeHolder);
        if (result == null) result = caseValue(dataAccessPrototypeHolder);
        if (result == null) result = caseBehaviorElement(dataAccessPrototypeHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DATA_COMPONENT_REFERENCE:
      {
        DataComponentReference dataComponentReference = (DataComponentReference)theEObject;
        T result = caseDataComponentReference(dataComponentReference);
        if (result == null) result = caseElementValues(dataComponentReference);
        if (result == null) result = caseTarget(dataComponentReference);
        if (result == null) result = caseIntegerValueVariable(dataComponentReference);
        if (result == null) result = caseParameterLabel(dataComponentReference);
        if (result == null) result = caseValueVariable(dataComponentReference);
        if (result == null) result = caseValue(dataComponentReference);
        if (result == null) result = caseIntegerValue(dataComponentReference);
        if (result == null) result = caseBehaviorElement(dataComponentReference);
        if (result == null) result = caseElement(dataComponentReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DATA_HOLDER:
      {
        DataHolder dataHolder = (DataHolder)theEObject;
        T result = caseDataHolder(dataHolder);
        if (result == null) result = caseElementHolder(dataHolder);
        if (result == null) result = caseIntegerValueVariable(dataHolder);
        if (result == null) result = caseIntegerValue(dataHolder);
        if (result == null) result = caseValueVariable(dataHolder);
        if (result == null) result = caseElement(dataHolder);
        if (result == null) result = caseValue(dataHolder);
        if (result == null) result = caseBehaviorElement(dataHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DATA_PORT_HOLDER:
      {
        DataPortHolder dataPortHolder = (DataPortHolder)theEObject;
        T result = caseDataPortHolder(dataPortHolder);
        if (result == null) result = caseActualPortHolder(dataPortHolder);
        if (result == null) result = caseTarget(dataPortHolder);
        if (result == null) result = casePortHolder(dataPortHolder);
        if (result == null) result = caseParameterLabel(dataPortHolder);
        if (result == null) result = caseIntegerValueVariable(dataPortHolder);
        if (result == null) result = caseFeatureHolder(dataPortHolder);
        if (result == null) result = caseValueVariable(dataPortHolder);
        if (result == null) result = caseValue(dataPortHolder);
        if (result == null) result = caseIntegerValue(dataPortHolder);
        if (result == null) result = caseClassifierFeatureHolder(dataPortHolder);
        if (result == null) result = caseIndexableElement(dataPortHolder);
        if (result == null) result = caseGroupableElement(dataPortHolder);
        if (result == null) result = caseElementHolder(dataPortHolder);
        if (result == null) result = caseBehaviorElement(dataPortHolder);
        if (result == null) result = caseElement(dataPortHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DATA_SUBCOMPONENT_HOLDER:
      {
        DataSubcomponentHolder dataSubcomponentHolder = (DataSubcomponentHolder)theEObject;
        T result = caseDataSubcomponentHolder(dataSubcomponentHolder);
        if (result == null) result = caseDataHolder(dataSubcomponentHolder);
        if (result == null) result = caseTarget(dataSubcomponentHolder);
        if (result == null) result = caseElementValues(dataSubcomponentHolder);
        if (result == null) result = caseSubprogramHolderProxy(dataSubcomponentHolder);
        if (result == null) result = caseSubcomponentHolder(dataSubcomponentHolder);
        if (result == null) result = caseIntegerValueVariable(dataSubcomponentHolder);
        if (result == null) result = caseParameterLabel(dataSubcomponentHolder);
        if (result == null) result = caseClassifierFeatureHolder(dataSubcomponentHolder);
        if (result == null) result = caseIndexableElement(dataSubcomponentHolder);
        if (result == null) result = caseGroupableElement(dataSubcomponentHolder);
        if (result == null) result = caseElementHolder(dataSubcomponentHolder);
        if (result == null) result = caseIntegerValue(dataSubcomponentHolder);
        if (result == null) result = caseValueVariable(dataSubcomponentHolder);
        if (result == null) result = caseElement(dataSubcomponentHolder);
        if (result == null) result = caseValue(dataSubcomponentHolder);
        if (result == null) result = caseBehaviorElement(dataSubcomponentHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DISPATCH_CONDITION:
      {
        DispatchCondition dispatchCondition = (DispatchCondition)theEObject;
        T result = caseDispatchCondition(dispatchCondition);
        if (result == null) result = caseBehaviorCondition(dispatchCondition);
        if (result == null) result = caseBehaviorElement(dispatchCondition);
        if (result == null) result = caseElement(dispatchCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DISPATCH_CONJUNCTION:
      {
        DispatchConjunction dispatchConjunction = (DispatchConjunction)theEObject;
        T result = caseDispatchConjunction(dispatchConjunction);
        if (result == null) result = caseBehaviorElement(dispatchConjunction);
        if (result == null) result = caseElement(dispatchConjunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DISPATCH_RELATIVE_TIMEOUT:
      {
        DispatchRelativeTimeout dispatchRelativeTimeout = (DispatchRelativeTimeout)theEObject;
        T result = caseDispatchRelativeTimeout(dispatchRelativeTimeout);
        if (result == null) result = caseDispatchTriggerCondition(dispatchRelativeTimeout);
        if (result == null) result = caseBehaviorElement(dispatchRelativeTimeout);
        if (result == null) result = caseElement(dispatchRelativeTimeout);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DISPATCH_TRIGGER:
      {
        DispatchTrigger dispatchTrigger = (DispatchTrigger)theEObject;
        T result = caseDispatchTrigger(dispatchTrigger);
        if (result == null) result = caseBehaviorElement(dispatchTrigger);
        if (result == null) result = caseElement(dispatchTrigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DISPATCH_TRIGGER_CONDITION:
      {
        DispatchTriggerCondition dispatchTriggerCondition = (DispatchTriggerCondition)theEObject;
        T result = caseDispatchTriggerCondition(dispatchTriggerCondition);
        if (result == null) result = caseBehaviorElement(dispatchTriggerCondition);
        if (result == null) result = caseElement(dispatchTriggerCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DISPATCH_TRIGGER_CONDITION_STOP:
      {
        DispatchTriggerConditionStop dispatchTriggerConditionStop = (DispatchTriggerConditionStop)theEObject;
        T result = caseDispatchTriggerConditionStop(dispatchTriggerConditionStop);
        if (result == null) result = caseDispatchTriggerCondition(dispatchTriggerConditionStop);
        if (result == null) result = caseBehaviorElement(dispatchTriggerConditionStop);
        if (result == null) result = caseElement(dispatchTriggerConditionStop);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION:
      {
        DispatchTriggerLogicalExpression dispatchTriggerLogicalExpression = (DispatchTriggerLogicalExpression)theEObject;
        T result = caseDispatchTriggerLogicalExpression(dispatchTriggerLogicalExpression);
        if (result == null) result = caseDispatchTriggerCondition(dispatchTriggerLogicalExpression);
        if (result == null) result = caseBehaviorElement(dispatchTriggerLogicalExpression);
        if (result == null) result = caseElement(dispatchTriggerLogicalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ELEMENT_HOLDER:
      {
        ElementHolder elementHolder = (ElementHolder)theEObject;
        T result = caseElementHolder(elementHolder);
        if (result == null) result = caseBehaviorElement(elementHolder);
        if (result == null) result = caseElement(elementHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ELEMENT_VALUES:
      {
        ElementValues elementValues = (ElementValues)theEObject;
        T result = caseElementValues(elementValues);
        if (result == null) result = caseBehaviorElement(elementValues);
        if (result == null) result = caseElement(elementValues);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ELSE_STATEMENT:
      {
        ElseStatement elseStatement = (ElseStatement)theEObject;
        T result = caseElseStatement(elseStatement);
        if (result == null) result = caseCondStatement(elseStatement);
        if (result == null) result = caseBehaviorAction(elseStatement);
        if (result == null) result = caseBehaviorActions(elseStatement);
        if (result == null) result = caseBehaviorElement(elseStatement);
        if (result == null) result = caseElement(elseStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ENUM_LITERAL_HOLDER:
      {
        EnumLiteralHolder enumLiteralHolder = (EnumLiteralHolder)theEObject;
        T result = caseEnumLiteralHolder(enumLiteralHolder);
        if (result == null) result = casePropertyElementHolder(enumLiteralHolder);
        if (result == null) result = caseIndexableElement(enumLiteralHolder);
        if (result == null) result = caseBehaviorElement(enumLiteralHolder);
        if (result == null) result = caseElement(enumLiteralHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.EVENT_DATA_PORT_HOLDER:
      {
        EventDataPortHolder eventDataPortHolder = (EventDataPortHolder)theEObject;
        T result = caseEventDataPortHolder(eventDataPortHolder);
        if (result == null) result = caseActualPortHolder(eventDataPortHolder);
        if (result == null) result = caseElementValues(eventDataPortHolder);
        if (result == null) result = caseDispatchTrigger(eventDataPortHolder);
        if (result == null) result = caseModeSwitchTrigger(eventDataPortHolder);
        if (result == null) result = caseTarget(eventDataPortHolder);
        if (result == null) result = casePortHolder(eventDataPortHolder);
        if (result == null) result = caseParameterLabel(eventDataPortHolder);
        if (result == null) result = caseIntegerValueVariable(eventDataPortHolder);
        if (result == null) result = caseFeatureHolder(eventDataPortHolder);
        if (result == null) result = caseValueVariable(eventDataPortHolder);
        if (result == null) result = caseValue(eventDataPortHolder);
        if (result == null) result = caseIntegerValue(eventDataPortHolder);
        if (result == null) result = caseClassifierFeatureHolder(eventDataPortHolder);
        if (result == null) result = caseIndexableElement(eventDataPortHolder);
        if (result == null) result = caseGroupableElement(eventDataPortHolder);
        if (result == null) result = caseElementHolder(eventDataPortHolder);
        if (result == null) result = caseBehaviorElement(eventDataPortHolder);
        if (result == null) result = caseElement(eventDataPortHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.EVENT_PORT_HOLDER:
      {
        EventPortHolder eventPortHolder = (EventPortHolder)theEObject;
        T result = caseEventPortHolder(eventPortHolder);
        if (result == null) result = caseActualPortHolder(eventPortHolder);
        if (result == null) result = caseDispatchTrigger(eventPortHolder);
        if (result == null) result = caseModeSwitchTrigger(eventPortHolder);
        if (result == null) result = caseTarget(eventPortHolder);
        if (result == null) result = casePortHolder(eventPortHolder);
        if (result == null) result = caseParameterLabel(eventPortHolder);
        if (result == null) result = caseIntegerValueVariable(eventPortHolder);
        if (result == null) result = caseFeatureHolder(eventPortHolder);
        if (result == null) result = caseValueVariable(eventPortHolder);
        if (result == null) result = caseValue(eventPortHolder);
        if (result == null) result = caseIntegerValue(eventPortHolder);
        if (result == null) result = caseClassifierFeatureHolder(eventPortHolder);
        if (result == null) result = caseIndexableElement(eventPortHolder);
        if (result == null) result = caseGroupableElement(eventPortHolder);
        if (result == null) result = caseElementHolder(eventPortHolder);
        if (result == null) result = caseBehaviorElement(eventPortHolder);
        if (result == null) result = caseElement(eventPortHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.EXECUTE_CONDITION:
      {
        ExecuteCondition executeCondition = (ExecuteCondition)theEObject;
        T result = caseExecuteCondition(executeCondition);
        if (result == null) result = caseBehaviorCondition(executeCondition);
        if (result == null) result = caseBehaviorElement(executeCondition);
        if (result == null) result = caseElement(executeCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.EXECUTION_TIMEOUT_CATCH:
      {
        ExecutionTimeoutCatch executionTimeoutCatch = (ExecutionTimeoutCatch)theEObject;
        T result = caseExecutionTimeoutCatch(executionTimeoutCatch);
        if (result == null) result = caseExecuteCondition(executionTimeoutCatch);
        if (result == null) result = caseBehaviorCondition(executionTimeoutCatch);
        if (result == null) result = caseBehaviorElement(executionTimeoutCatch);
        if (result == null) result = caseElement(executionTimeoutCatch);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.FACTOR:
      {
        Factor factor = (Factor)theEObject;
        T result = caseFactor(factor);
        if (result == null) result = caseBehaviorElement(factor);
        if (result == null) result = caseElement(factor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.FEATURE_HOLDER:
      {
        FeatureHolder featureHolder = (FeatureHolder)theEObject;
        T result = caseFeatureHolder(featureHolder);
        if (result == null) result = caseClassifierFeatureHolder(featureHolder);
        if (result == null) result = caseIndexableElement(featureHolder);
        if (result == null) result = caseGroupableElement(featureHolder);
        if (result == null) result = caseElementHolder(featureHolder);
        if (result == null) result = caseBehaviorElement(featureHolder);
        if (result == null) result = caseElement(featureHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.FEATURE_PROTOTYPE_HOLDER:
      {
        FeaturePrototypeHolder featurePrototypeHolder = (FeaturePrototypeHolder)theEObject;
        T result = caseFeaturePrototypeHolder(featurePrototypeHolder);
        if (result == null) result = caseDataHolder(featurePrototypeHolder);
        if (result == null) result = casePrototypeHolder(featurePrototypeHolder);
        if (result == null) result = caseTarget(featurePrototypeHolder);
        if (result == null) result = caseElementValues(featurePrototypeHolder);
        if (result == null) result = caseIntegerValueVariable(featurePrototypeHolder);
        if (result == null) result = caseIndexableElement(featurePrototypeHolder);
        if (result == null) result = caseGroupableElement(featurePrototypeHolder);
        if (result == null) result = caseClassifierFeatureHolder(featurePrototypeHolder);
        if (result == null) result = caseParameterLabel(featurePrototypeHolder);
        if (result == null) result = caseElementHolder(featurePrototypeHolder);
        if (result == null) result = caseIntegerValue(featurePrototypeHolder);
        if (result == null) result = caseValueVariable(featurePrototypeHolder);
        if (result == null) result = caseElement(featurePrototypeHolder);
        if (result == null) result = caseValue(featurePrototypeHolder);
        if (result == null) result = caseBehaviorElement(featurePrototypeHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT:
      {
        ForOrForAllStatement forOrForAllStatement = (ForOrForAllStatement)theEObject;
        T result = caseForOrForAllStatement(forOrForAllStatement);
        if (result == null) result = caseLoopStatement(forOrForAllStatement);
        if (result == null) result = caseCondStatement(forOrForAllStatement);
        if (result == null) result = caseBehaviorAction(forOrForAllStatement);
        if (result == null) result = caseBehaviorActions(forOrForAllStatement);
        if (result == null) result = caseBehaviorElement(forOrForAllStatement);
        if (result == null) result = caseElement(forOrForAllStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.GROUPABLE_ELEMENT:
      {
        GroupableElement groupableElement = (GroupableElement)theEObject;
        T result = caseGroupableElement(groupableElement);
        if (result == null) result = caseBehaviorElement(groupableElement);
        if (result == null) result = caseElement(groupableElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.GROUP_HOLDER:
      {
        GroupHolder groupHolder = (GroupHolder)theEObject;
        T result = caseGroupHolder(groupHolder);
        if (result == null) result = caseElementHolder(groupHolder);
        if (result == null) result = caseIndexableElement(groupHolder);
        if (result == null) result = caseBehaviorElement(groupHolder);
        if (result == null) result = caseElement(groupHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.GROUP_PROTOTYPE_HOLDER:
      {
        GroupPrototypeHolder groupPrototypeHolder = (GroupPrototypeHolder)theEObject;
        T result = caseGroupPrototypeHolder(groupPrototypeHolder);
        if (result == null) result = caseGroupHolder(groupPrototypeHolder);
        if (result == null) result = caseElementHolder(groupPrototypeHolder);
        if (result == null) result = caseIndexableElement(groupPrototypeHolder);
        if (result == null) result = caseBehaviorElement(groupPrototypeHolder);
        if (result == null) result = caseElement(groupPrototypeHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.IF_STATEMENT:
      {
        IfStatement ifStatement = (IfStatement)theEObject;
        T result = caseIfStatement(ifStatement);
        if (result == null) result = caseElseStatement(ifStatement);
        if (result == null) result = caseCondStatement(ifStatement);
        if (result == null) result = caseBehaviorAction(ifStatement);
        if (result == null) result = caseBehaviorActions(ifStatement);
        if (result == null) result = caseBehaviorElement(ifStatement);
        if (result == null) result = caseElement(ifStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.INDEXABLE_ELEMENT:
      {
        IndexableElement indexableElement = (IndexableElement)theEObject;
        T result = caseIndexableElement(indexableElement);
        if (result == null) result = caseBehaviorElement(indexableElement);
        if (result == null) result = caseElement(indexableElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.INTEGER_RANGE:
      {
        IntegerRange integerRange = (IntegerRange)theEObject;
        T result = caseIntegerRange(integerRange);
        if (result == null) result = caseElementValues(integerRange);
        if (result == null) result = caseBehaviorElement(integerRange);
        if (result == null) result = caseElement(integerRange);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.INTEGER_VALUE:
      {
        IntegerValue integerValue = (IntegerValue)theEObject;
        T result = caseIntegerValue(integerValue);
        if (result == null) result = caseBehaviorElement(integerValue);
        if (result == null) result = caseElement(integerValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.INTEGER_VALUE_CONSTANT:
      {
        IntegerValueConstant integerValueConstant = (IntegerValueConstant)theEObject;
        T result = caseIntegerValueConstant(integerValueConstant);
        if (result == null) result = caseIntegerValue(integerValueConstant);
        if (result == null) result = caseValueConstant(integerValueConstant);
        if (result == null) result = caseValue(integerValueConstant);
        if (result == null) result = caseBehaviorElement(integerValueConstant);
        if (result == null) result = caseElement(integerValueConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.INTEGER_VALUE_VARIABLE:
      {
        IntegerValueVariable integerValueVariable = (IntegerValueVariable)theEObject;
        T result = caseIntegerValueVariable(integerValueVariable);
        if (result == null) result = caseIntegerValue(integerValueVariable);
        if (result == null) result = caseValueVariable(integerValueVariable);
        if (result == null) result = caseValue(integerValueVariable);
        if (result == null) result = caseBehaviorElement(integerValueVariable);
        if (result == null) result = caseElement(integerValueVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ITERATIVE_VARIABLE:
      {
        IterativeVariable iterativeVariable = (IterativeVariable)theEObject;
        T result = caseIterativeVariable(iterativeVariable);
        if (result == null) result = caseBehaviorNamedElement(iterativeVariable);
        if (result == null) result = caseNamedElement(iterativeVariable);
        if (result == null) result = caseBehaviorElement(iterativeVariable);
        if (result == null) result = caseElement(iterativeVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.ITERATIVE_VARIABLE_HOLDER:
      {
        IterativeVariableHolder iterativeVariableHolder = (IterativeVariableHolder)theEObject;
        T result = caseIterativeVariableHolder(iterativeVariableHolder);
        if (result == null) result = caseDataHolder(iterativeVariableHolder);
        if (result == null) result = caseElementHolder(iterativeVariableHolder);
        if (result == null) result = caseIntegerValueVariable(iterativeVariableHolder);
        if (result == null) result = caseIntegerValue(iterativeVariableHolder);
        if (result == null) result = caseValueVariable(iterativeVariableHolder);
        if (result == null) result = caseElement(iterativeVariableHolder);
        if (result == null) result = caseValue(iterativeVariableHolder);
        if (result == null) result = caseBehaviorElement(iterativeVariableHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = caseIntegerValueConstant(literal);
        if (result == null) result = caseValueConstant(literal);
        if (result == null) result = caseValue(literal);
        if (result == null) result = caseIntegerValue(literal);
        if (result == null) result = caseBehaviorElement(literal);
        if (result == null) result = caseElement(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.LOCK_ACTION:
      {
        LockAction lockAction = (LockAction)theEObject;
        T result = caseLockAction(lockAction);
        if (result == null) result = caseSharedDataAction(lockAction);
        if (result == null) result = caseCommunicationAction(lockAction);
        if (result == null) result = caseBasicAction(lockAction);
        if (result == null) result = caseBehaviorAction(lockAction);
        if (result == null) result = caseBehaviorActions(lockAction);
        if (result == null) result = caseBehaviorElement(lockAction);
        if (result == null) result = caseElement(lockAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.LOOP_STATEMENT:
      {
        LoopStatement loopStatement = (LoopStatement)theEObject;
        T result = caseLoopStatement(loopStatement);
        if (result == null) result = caseCondStatement(loopStatement);
        if (result == null) result = caseBehaviorAction(loopStatement);
        if (result == null) result = caseBehaviorActions(loopStatement);
        if (result == null) result = caseBehaviorElement(loopStatement);
        if (result == null) result = caseElement(loopStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.LOWER_BOUND:
      {
        LowerBound lowerBound = (LowerBound)theEObject;
        T result = caseLowerBound(lowerBound);
        if (result == null) result = casePropertyNameField(lowerBound);
        if (result == null) result = caseBehaviorElement(lowerBound);
        if (result == null) result = caseElement(lowerBound);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.NUMERIC_LITERAL:
      {
        NumericLiteral numericLiteral = (NumericLiteral)theEObject;
        T result = caseNumericLiteral(numericLiteral);
        if (result == null) result = caseNumberValue(numericLiteral);
        if (result == null) result = caseLiteral(numericLiteral);
        if (result == null) result = casePropertyValue(numericLiteral);
        if (result == null) result = caseIntegerValueConstant(numericLiteral);
        if (result == null) result = casePropertyExpression(numericLiteral);
        if (result == null) result = caseValueConstant(numericLiteral);
        if (result == null) result = caseValue(numericLiteral);
        if (result == null) result = caseIntegerValue(numericLiteral);
        if (result == null) result = caseBehaviorElement(numericLiteral);
        if (result == null) result = caseElement(numericLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.OTHERWISE:
      {
        Otherwise otherwise = (Otherwise)theEObject;
        T result = caseOtherwise(otherwise);
        if (result == null) result = caseExecuteCondition(otherwise);
        if (result == null) result = caseBehaviorCondition(otherwise);
        if (result == null) result = caseBehaviorElement(otherwise);
        if (result == null) result = caseElement(otherwise);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PARAMETER_HOLDER:
      {
        ParameterHolder parameterHolder = (ParameterHolder)theEObject;
        T result = caseParameterHolder(parameterHolder);
        if (result == null) result = caseDataHolder(parameterHolder);
        if (result == null) result = caseTarget(parameterHolder);
        if (result == null) result = caseElementValues(parameterHolder);
        if (result == null) result = caseFeatureHolder(parameterHolder);
        if (result == null) result = caseIntegerValueVariable(parameterHolder);
        if (result == null) result = caseParameterLabel(parameterHolder);
        if (result == null) result = caseClassifierFeatureHolder(parameterHolder);
        if (result == null) result = caseIndexableElement(parameterHolder);
        if (result == null) result = caseGroupableElement(parameterHolder);
        if (result == null) result = caseElementHolder(parameterHolder);
        if (result == null) result = caseIntegerValue(parameterHolder);
        if (result == null) result = caseValueVariable(parameterHolder);
        if (result == null) result = caseElement(parameterHolder);
        if (result == null) result = caseValue(parameterHolder);
        if (result == null) result = caseBehaviorElement(parameterHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PARAMETER_LABEL:
      {
        ParameterLabel parameterLabel = (ParameterLabel)theEObject;
        T result = caseParameterLabel(parameterLabel);
        if (result == null) result = caseBehaviorElement(parameterLabel);
        if (result == null) result = caseElement(parameterLabel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_COUNT_VALUE:
      {
        PortCountValue portCountValue = (PortCountValue)theEObject;
        T result = casePortCountValue(portCountValue);
        if (result == null) result = caseActualPortHolder(portCountValue);
        if (result == null) result = casePortHolder(portCountValue);
        if (result == null) result = caseIntegerValueVariable(portCountValue);
        if (result == null) result = caseFeatureHolder(portCountValue);
        if (result == null) result = caseValueVariable(portCountValue);
        if (result == null) result = caseValue(portCountValue);
        if (result == null) result = caseIntegerValue(portCountValue);
        if (result == null) result = caseClassifierFeatureHolder(portCountValue);
        if (result == null) result = caseIndexableElement(portCountValue);
        if (result == null) result = caseGroupableElement(portCountValue);
        if (result == null) result = caseElementHolder(portCountValue);
        if (result == null) result = caseBehaviorElement(portCountValue);
        if (result == null) result = caseElement(portCountValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_DEQUEUE_ACTION:
      {
        PortDequeueAction portDequeueAction = (PortDequeueAction)theEObject;
        T result = casePortDequeueAction(portDequeueAction);
        if (result == null) result = caseCommunicationAction(portDequeueAction);
        if (result == null) result = caseBasicAction(portDequeueAction);
        if (result == null) result = caseBehaviorAction(portDequeueAction);
        if (result == null) result = caseBehaviorActions(portDequeueAction);
        if (result == null) result = caseBehaviorElement(portDequeueAction);
        if (result == null) result = caseElement(portDequeueAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_DEQUEUE_VALUE:
      {
        PortDequeueValue portDequeueValue = (PortDequeueValue)theEObject;
        T result = casePortDequeueValue(portDequeueValue);
        if (result == null) result = caseActualPortHolder(portDequeueValue);
        if (result == null) result = casePortHolder(portDequeueValue);
        if (result == null) result = caseIntegerValueVariable(portDequeueValue);
        if (result == null) result = caseFeatureHolder(portDequeueValue);
        if (result == null) result = caseValueVariable(portDequeueValue);
        if (result == null) result = caseValue(portDequeueValue);
        if (result == null) result = caseIntegerValue(portDequeueValue);
        if (result == null) result = caseClassifierFeatureHolder(portDequeueValue);
        if (result == null) result = caseIndexableElement(portDequeueValue);
        if (result == null) result = caseGroupableElement(portDequeueValue);
        if (result == null) result = caseElementHolder(portDequeueValue);
        if (result == null) result = caseBehaviorElement(portDequeueValue);
        if (result == null) result = caseElement(portDequeueValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_FREEZE_ACTION:
      {
        PortFreezeAction portFreezeAction = (PortFreezeAction)theEObject;
        T result = casePortFreezeAction(portFreezeAction);
        if (result == null) result = caseActualPortHolder(portFreezeAction);
        if (result == null) result = caseCommunicationAction(portFreezeAction);
        if (result == null) result = casePortHolder(portFreezeAction);
        if (result == null) result = caseBasicAction(portFreezeAction);
        if (result == null) result = caseIntegerValueVariable(portFreezeAction);
        if (result == null) result = caseFeatureHolder(portFreezeAction);
        if (result == null) result = caseBehaviorAction(portFreezeAction);
        if (result == null) result = caseValueVariable(portFreezeAction);
        if (result == null) result = caseValue(portFreezeAction);
        if (result == null) result = caseIntegerValue(portFreezeAction);
        if (result == null) result = caseClassifierFeatureHolder(portFreezeAction);
        if (result == null) result = caseIndexableElement(portFreezeAction);
        if (result == null) result = caseGroupableElement(portFreezeAction);
        if (result == null) result = caseBehaviorActions(portFreezeAction);
        if (result == null) result = caseElementHolder(portFreezeAction);
        if (result == null) result = caseBehaviorElement(portFreezeAction);
        if (result == null) result = caseElement(portFreezeAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_FRESH_VALUE:
      {
        PortFreshValue portFreshValue = (PortFreshValue)theEObject;
        T result = casePortFreshValue(portFreshValue);
        if (result == null) result = caseActualPortHolder(portFreshValue);
        if (result == null) result = casePortHolder(portFreshValue);
        if (result == null) result = caseIntegerValueVariable(portFreshValue);
        if (result == null) result = caseFeatureHolder(portFreshValue);
        if (result == null) result = caseValueVariable(portFreshValue);
        if (result == null) result = caseValue(portFreshValue);
        if (result == null) result = caseIntegerValue(portFreshValue);
        if (result == null) result = caseClassifierFeatureHolder(portFreshValue);
        if (result == null) result = caseIndexableElement(portFreshValue);
        if (result == null) result = caseGroupableElement(portFreshValue);
        if (result == null) result = caseElementHolder(portFreshValue);
        if (result == null) result = caseBehaviorElement(portFreshValue);
        if (result == null) result = caseElement(portFreshValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_HOLDER:
      {
        PortHolder portHolder = (PortHolder)theEObject;
        T result = casePortHolder(portHolder);
        if (result == null) result = caseIntegerValueVariable(portHolder);
        if (result == null) result = caseFeatureHolder(portHolder);
        if (result == null) result = caseValueVariable(portHolder);
        if (result == null) result = caseValue(portHolder);
        if (result == null) result = caseIntegerValue(portHolder);
        if (result == null) result = caseClassifierFeatureHolder(portHolder);
        if (result == null) result = caseIndexableElement(portHolder);
        if (result == null) result = caseGroupableElement(portHolder);
        if (result == null) result = caseElementHolder(portHolder);
        if (result == null) result = caseBehaviorElement(portHolder);
        if (result == null) result = caseElement(portHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_PROTOTYPE_HOLDER:
      {
        PortPrototypeHolder portPrototypeHolder = (PortPrototypeHolder)theEObject;
        T result = casePortPrototypeHolder(portPrototypeHolder);
        if (result == null) result = casePortHolder(portPrototypeHolder);
        if (result == null) result = casePrototypeHolder(portPrototypeHolder);
        if (result == null) result = caseTarget(portPrototypeHolder);
        if (result == null) result = caseIntegerValueVariable(portPrototypeHolder);
        if (result == null) result = caseFeatureHolder(portPrototypeHolder);
        if (result == null) result = caseParameterLabel(portPrototypeHolder);
        if (result == null) result = caseValueVariable(portPrototypeHolder);
        if (result == null) result = caseValue(portPrototypeHolder);
        if (result == null) result = caseIntegerValue(portPrototypeHolder);
        if (result == null) result = caseClassifierFeatureHolder(portPrototypeHolder);
        if (result == null) result = caseIndexableElement(portPrototypeHolder);
        if (result == null) result = caseGroupableElement(portPrototypeHolder);
        if (result == null) result = caseElementHolder(portPrototypeHolder);
        if (result == null) result = caseBehaviorElement(portPrototypeHolder);
        if (result == null) result = caseElement(portPrototypeHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PORT_SEND_ACTION:
      {
        PortSendAction portSendAction = (PortSendAction)theEObject;
        T result = casePortSendAction(portSendAction);
        if (result == null) result = caseCommunicationAction(portSendAction);
        if (result == null) result = caseBasicAction(portSendAction);
        if (result == null) result = caseBehaviorAction(portSendAction);
        if (result == null) result = caseBehaviorActions(portSendAction);
        if (result == null) result = caseBehaviorElement(portSendAction);
        if (result == null) result = caseElement(portSendAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_ASSOCIATION_HOLDER:
      {
        PropertyAssociationHolder propertyAssociationHolder = (PropertyAssociationHolder)theEObject;
        T result = casePropertyAssociationHolder(propertyAssociationHolder);
        if (result == null) result = casePropertyElementHolder(propertyAssociationHolder);
        if (result == null) result = caseIndexableElement(propertyAssociationHolder);
        if (result == null) result = caseBehaviorElement(propertyAssociationHolder);
        if (result == null) result = caseElement(propertyAssociationHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_ELEMENT_HOLDER:
      {
        PropertyElementHolder propertyElementHolder = (PropertyElementHolder)theEObject;
        T result = casePropertyElementHolder(propertyElementHolder);
        if (result == null) result = caseIndexableElement(propertyElementHolder);
        if (result == null) result = caseBehaviorElement(propertyElementHolder);
        if (result == null) result = caseElement(propertyElementHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_EXPRESSION_HOLDER:
      {
        PropertyExpressionHolder propertyExpressionHolder = (PropertyExpressionHolder)theEObject;
        T result = casePropertyExpressionHolder(propertyExpressionHolder);
        if (result == null) result = casePropertyElementHolder(propertyExpressionHolder);
        if (result == null) result = caseIndexableElement(propertyExpressionHolder);
        if (result == null) result = caseBehaviorElement(propertyExpressionHolder);
        if (result == null) result = caseElement(propertyExpressionHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_NAME_FIELD:
      {
        PropertyNameField propertyNameField = (PropertyNameField)theEObject;
        T result = casePropertyNameField(propertyNameField);
        if (result == null) result = caseBehaviorElement(propertyNameField);
        if (result == null) result = caseElement(propertyNameField);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_NAME_HOLDER:
      {
        PropertyNameHolder propertyNameHolder = (PropertyNameHolder)theEObject;
        T result = casePropertyNameHolder(propertyNameHolder);
        if (result == null) result = caseBehaviorElement(propertyNameHolder);
        if (result == null) result = caseElement(propertyNameHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_REFERENCE:
      {
        PropertyReference propertyReference = (PropertyReference)theEObject;
        T result = casePropertyReference(propertyReference);
        if (result == null) result = caseIntegerValueConstant(propertyReference);
        if (result == null) result = caseValueConstant(propertyReference);
        if (result == null) result = caseValue(propertyReference);
        if (result == null) result = caseIntegerValue(propertyReference);
        if (result == null) result = caseBehaviorElement(propertyReference);
        if (result == null) result = caseElement(propertyReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_SET_PROPERTY_REFERENCE:
      {
        PropertySetPropertyReference propertySetPropertyReference = (PropertySetPropertyReference)theEObject;
        T result = casePropertySetPropertyReference(propertySetPropertyReference);
        if (result == null) result = casePropertyReference(propertySetPropertyReference);
        if (result == null) result = caseIntegerValueConstant(propertySetPropertyReference);
        if (result == null) result = caseValueConstant(propertySetPropertyReference);
        if (result == null) result = caseValue(propertySetPropertyReference);
        if (result == null) result = caseIntegerValue(propertySetPropertyReference);
        if (result == null) result = caseBehaviorElement(propertySetPropertyReference);
        if (result == null) result = caseElement(propertySetPropertyReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROPERTY_TYPE_HOLDER:
      {
        PropertyTypeHolder propertyTypeHolder = (PropertyTypeHolder)theEObject;
        T result = casePropertyTypeHolder(propertyTypeHolder);
        if (result == null) result = casePropertyElementHolder(propertyTypeHolder);
        if (result == null) result = caseIndexableElement(propertyTypeHolder);
        if (result == null) result = caseBehaviorElement(propertyTypeHolder);
        if (result == null) result = caseElement(propertyTypeHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.PROTOTYPE_HOLDER:
      {
        PrototypeHolder prototypeHolder = (PrototypeHolder)theEObject;
        T result = casePrototypeHolder(prototypeHolder);
        if (result == null) result = caseIndexableElement(prototypeHolder);
        if (result == null) result = caseGroupableElement(prototypeHolder);
        if (result == null) result = caseClassifierFeatureHolder(prototypeHolder);
        if (result == null) result = caseElementHolder(prototypeHolder);
        if (result == null) result = caseBehaviorElement(prototypeHolder);
        if (result == null) result = caseElement(prototypeHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.RELATION:
      {
        Relation relation = (Relation)theEObject;
        T result = caseRelation(relation);
        if (result == null) result = caseBehaviorElement(relation);
        if (result == null) result = caseElement(relation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SHARED_DATA_ACTION:
      {
        SharedDataAction sharedDataAction = (SharedDataAction)theEObject;
        T result = caseSharedDataAction(sharedDataAction);
        if (result == null) result = caseCommunicationAction(sharedDataAction);
        if (result == null) result = caseBasicAction(sharedDataAction);
        if (result == null) result = caseBehaviorAction(sharedDataAction);
        if (result == null) result = caseBehaviorActions(sharedDataAction);
        if (result == null) result = caseBehaviorElement(sharedDataAction);
        if (result == null) result = caseElement(sharedDataAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SIMPLE_EXPRESSION:
      {
        SimpleExpression simpleExpression = (SimpleExpression)theEObject;
        T result = caseSimpleExpression(simpleExpression);
        if (result == null) result = caseBehaviorElement(simpleExpression);
        if (result == null) result = caseElement(simpleExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.STRUCT_UNION_ELEMENT:
      {
        StructUnionElement structUnionElement = (StructUnionElement)theEObject;
        T result = caseStructUnionElement(structUnionElement);
        if (result == null) result = caseBehaviorNamedElement(structUnionElement);
        if (result == null) result = caseNamedElement(structUnionElement);
        if (result == null) result = caseBehaviorElement(structUnionElement);
        if (result == null) result = caseElement(structUnionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER:
      {
        StructUnionElementHolder structUnionElementHolder = (StructUnionElementHolder)theEObject;
        T result = caseStructUnionElementHolder(structUnionElementHolder);
        if (result == null) result = caseDataHolder(structUnionElementHolder);
        if (result == null) result = caseIndexableElement(structUnionElementHolder);
        if (result == null) result = caseTarget(structUnionElementHolder);
        if (result == null) result = caseElementValues(structUnionElementHolder);
        if (result == null) result = caseElementHolder(structUnionElementHolder);
        if (result == null) result = caseIntegerValueVariable(structUnionElementHolder);
        if (result == null) result = caseParameterLabel(structUnionElementHolder);
        if (result == null) result = caseIntegerValue(structUnionElementHolder);
        if (result == null) result = caseValueVariable(structUnionElementHolder);
        if (result == null) result = caseElement(structUnionElementHolder);
        if (result == null) result = caseValue(structUnionElementHolder);
        if (result == null) result = caseBehaviorElement(structUnionElementHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SUBCOMPONENT_HOLDER:
      {
        SubcomponentHolder subcomponentHolder = (SubcomponentHolder)theEObject;
        T result = caseSubcomponentHolder(subcomponentHolder);
        if (result == null) result = caseClassifierFeatureHolder(subcomponentHolder);
        if (result == null) result = caseIndexableElement(subcomponentHolder);
        if (result == null) result = caseGroupableElement(subcomponentHolder);
        if (result == null) result = caseElementHolder(subcomponentHolder);
        if (result == null) result = caseBehaviorElement(subcomponentHolder);
        if (result == null) result = caseElement(subcomponentHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SUBPROGRAM_ACCESS_HOLDER:
      {
        SubprogramAccessHolder subprogramAccessHolder = (SubprogramAccessHolder)theEObject;
        T result = caseSubprogramAccessHolder(subprogramAccessHolder);
        if (result == null) result = caseDispatchTriggerCondition(subprogramAccessHolder);
        if (result == null) result = caseCalledSubprogramHolder(subprogramAccessHolder);
        if (result == null) result = caseFeatureHolder(subprogramAccessHolder);
        if (result == null) result = caseIndexableElement(subprogramAccessHolder);
        if (result == null) result = caseGroupableElement(subprogramAccessHolder);
        if (result == null) result = caseClassifierFeatureHolder(subprogramAccessHolder);
        if (result == null) result = caseBehaviorElement(subprogramAccessHolder);
        if (result == null) result = caseElement(subprogramAccessHolder);
        if (result == null) result = caseElementHolder(subprogramAccessHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SUBPROGRAM_CALL_ACTION:
      {
        SubprogramCallAction subprogramCallAction = (SubprogramCallAction)theEObject;
        T result = caseSubprogramCallAction(subprogramCallAction);
        if (result == null) result = caseCommunicationAction(subprogramCallAction);
        if (result == null) result = caseBasicAction(subprogramCallAction);
        if (result == null) result = caseBehaviorAction(subprogramCallAction);
        if (result == null) result = caseBehaviorActions(subprogramCallAction);
        if (result == null) result = caseBehaviorElement(subprogramCallAction);
        if (result == null) result = caseElement(subprogramCallAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SUBPROGRAM_HOLDER:
      {
        SubprogramHolder subprogramHolder = (SubprogramHolder)theEObject;
        T result = caseSubprogramHolder(subprogramHolder);
        if (result == null) result = caseCalledSubprogramHolder(subprogramHolder);
        if (result == null) result = caseElementHolder(subprogramHolder);
        if (result == null) result = caseIndexableElement(subprogramHolder);
        if (result == null) result = caseGroupableElement(subprogramHolder);
        if (result == null) result = caseBehaviorElement(subprogramHolder);
        if (result == null) result = caseElement(subprogramHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SUBPROGRAM_HOLDER_PROXY:
      {
        SubprogramHolderProxy subprogramHolderProxy = (SubprogramHolderProxy)theEObject;
        T result = caseSubprogramHolderProxy(subprogramHolderProxy);
        if (result == null) result = caseBehaviorElement(subprogramHolderProxy);
        if (result == null) result = caseElement(subprogramHolderProxy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SUBPROGRAM_PROTOTYPE_HOLDER:
      {
        SubprogramPrototypeHolder subprogramPrototypeHolder = (SubprogramPrototypeHolder)theEObject;
        T result = caseSubprogramPrototypeHolder(subprogramPrototypeHolder);
        if (result == null) result = caseCalledSubprogramHolder(subprogramPrototypeHolder);
        if (result == null) result = casePrototypeHolder(subprogramPrototypeHolder);
        if (result == null) result = caseIndexableElement(subprogramPrototypeHolder);
        if (result == null) result = caseGroupableElement(subprogramPrototypeHolder);
        if (result == null) result = caseClassifierFeatureHolder(subprogramPrototypeHolder);
        if (result == null) result = caseElementHolder(subprogramPrototypeHolder);
        if (result == null) result = caseBehaviorElement(subprogramPrototypeHolder);
        if (result == null) result = caseElement(subprogramPrototypeHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.SUBPROGRAM_SUBCOMPONENT_HOLDER:
      {
        SubprogramSubcomponentHolder subprogramSubcomponentHolder = (SubprogramSubcomponentHolder)theEObject;
        T result = caseSubprogramSubcomponentHolder(subprogramSubcomponentHolder);
        if (result == null) result = caseSubcomponentHolder(subprogramSubcomponentHolder);
        if (result == null) result = caseCalledSubprogramHolder(subprogramSubcomponentHolder);
        if (result == null) result = caseClassifierFeatureHolder(subprogramSubcomponentHolder);
        if (result == null) result = caseIndexableElement(subprogramSubcomponentHolder);
        if (result == null) result = caseGroupableElement(subprogramSubcomponentHolder);
        if (result == null) result = caseElementHolder(subprogramSubcomponentHolder);
        if (result == null) result = caseBehaviorElement(subprogramSubcomponentHolder);
        if (result == null) result = caseElement(subprogramSubcomponentHolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.TARGET:
      {
        Target target = (Target)theEObject;
        T result = caseTarget(target);
        if (result == null) result = caseParameterLabel(target);
        if (result == null) result = caseBehaviorElement(target);
        if (result == null) result = caseElement(target);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.TERM:
      {
        Term term = (Term)theEObject;
        T result = caseTerm(term);
        if (result == null) result = caseBehaviorElement(term);
        if (result == null) result = caseElement(term);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.TIMED_ACTION:
      {
        TimedAction timedAction = (TimedAction)theEObject;
        T result = caseTimedAction(timedAction);
        if (result == null) result = caseBasicAction(timedAction);
        if (result == null) result = caseBehaviorAction(timedAction);
        if (result == null) result = caseBehaviorActions(timedAction);
        if (result == null) result = caseBehaviorElement(timedAction);
        if (result == null) result = caseElement(timedAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.UNLOCK_ACTION:
      {
        UnlockAction unlockAction = (UnlockAction)theEObject;
        T result = caseUnlockAction(unlockAction);
        if (result == null) result = caseSharedDataAction(unlockAction);
        if (result == null) result = caseCommunicationAction(unlockAction);
        if (result == null) result = caseBasicAction(unlockAction);
        if (result == null) result = caseBehaviorAction(unlockAction);
        if (result == null) result = caseBehaviorActions(unlockAction);
        if (result == null) result = caseBehaviorElement(unlockAction);
        if (result == null) result = caseElement(unlockAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.UPPER_BOUND:
      {
        UpperBound upperBound = (UpperBound)theEObject;
        T result = caseUpperBound(upperBound);
        if (result == null) result = casePropertyNameField(upperBound);
        if (result == null) result = caseBehaviorElement(upperBound);
        if (result == null) result = caseElement(upperBound);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = caseBehaviorElement(value);
        if (result == null) result = caseElement(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.VALUE_CONSTANT:
      {
        ValueConstant valueConstant = (ValueConstant)theEObject;
        T result = caseValueConstant(valueConstant);
        if (result == null) result = caseValue(valueConstant);
        if (result == null) result = caseBehaviorElement(valueConstant);
        if (result == null) result = caseElement(valueConstant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.VALUE_EXPRESSION:
      {
        ValueExpression valueExpression = (ValueExpression)theEObject;
        T result = caseValueExpression(valueExpression);
        if (result == null) result = caseValue(valueExpression);
        if (result == null) result = caseParameterLabel(valueExpression);
        if (result == null) result = caseExecuteCondition(valueExpression);
        if (result == null) result = caseBehaviorCondition(valueExpression);
        if (result == null) result = caseBehaviorElement(valueExpression);
        if (result == null) result = caseElement(valueExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.VALUE_VARIABLE:
      {
        ValueVariable valueVariable = (ValueVariable)theEObject;
        T result = caseValueVariable(valueVariable);
        if (result == null) result = caseValue(valueVariable);
        if (result == null) result = caseBehaviorElement(valueVariable);
        if (result == null) result = caseElement(valueVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT:
      {
        WhileOrDoUntilStatement whileOrDoUntilStatement = (WhileOrDoUntilStatement)theEObject;
        T result = caseWhileOrDoUntilStatement(whileOrDoUntilStatement);
        if (result == null) result = caseLoopStatement(whileOrDoUntilStatement);
        if (result == null) result = caseCondStatement(whileOrDoUntilStatement);
        if (result == null) result = caseBehaviorAction(whileOrDoUntilStatement);
        if (result == null) result = caseBehaviorActions(whileOrDoUntilStatement);
        if (result == null) result = caseBehaviorElement(whileOrDoUntilStatement);
        if (result == null) result = caseElement(whileOrDoUntilStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION:
      {
        ModeSwitchTriggerLogicalExpression modeSwitchTriggerLogicalExpression = (ModeSwitchTriggerLogicalExpression)theEObject;
        T result = caseModeSwitchTriggerLogicalExpression(modeSwitchTriggerLogicalExpression);
        if (result == null) result = caseModeSwitchTriggerCondition(modeSwitchTriggerLogicalExpression);
        if (result == null) result = caseBehaviorCondition(modeSwitchTriggerLogicalExpression);
        if (result == null) result = caseBehaviorElement(modeSwitchTriggerLogicalExpression);
        if (result == null) result = caseElement(modeSwitchTriggerLogicalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.MODE_SWITCH_TRIGGER_CONDITION:
      {
        ModeSwitchTriggerCondition modeSwitchTriggerCondition = (ModeSwitchTriggerCondition)theEObject;
        T result = caseModeSwitchTriggerCondition(modeSwitchTriggerCondition);
        if (result == null) result = caseBehaviorCondition(modeSwitchTriggerCondition);
        if (result == null) result = caseBehaviorElement(modeSwitchTriggerCondition);
        if (result == null) result = caseElement(modeSwitchTriggerCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.MODE_SWITCH_CONJUNCTION:
      {
        ModeSwitchConjunction modeSwitchConjunction = (ModeSwitchConjunction)theEObject;
        T result = caseModeSwitchConjunction(modeSwitchConjunction);
        if (result == null) result = caseBehaviorElement(modeSwitchConjunction);
        if (result == null) result = caseElement(modeSwitchConjunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AadlBaPackage.MODE_SWITCH_TRIGGER:
      {
        ModeSwitchTrigger modeSwitchTrigger = (ModeSwitchTrigger)theEObject;
        T result = caseModeSwitchTrigger(modeSwitchTrigger);
        if (result == null) result = caseBehaviorElement(modeSwitchTrigger);
        if (result == null) result = caseElement(modeSwitchTrigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actual Port Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actual Port Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActualPortHolder(ActualPortHolder object)
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
   * Returns the result of interpreting the object as an instance of '<em>Any</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Any</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAny(Any object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicAction(BasicAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Property Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Property Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicPropertyHolder(BasicPropertyHolder object)
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
   * Returns the result of interpreting the object as an instance of '<em>Behavior Action Collection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Action Collection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorActionCollection(BehaviorActionCollection object)
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
   * Returns the result of interpreting the object as an instance of '<em>Behavior Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorElement(BehaviorElement object)
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
   * Returns the result of interpreting the object as an instance of '<em>Behavior Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorNamedElement(BehaviorNamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Behavior Property Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Property Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorPropertyConstant(BehaviorPropertyConstant object)
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
   * Returns the result of interpreting the object as an instance of '<em>Behavior Variable Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Behavior Variable Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBehaviorVariableHolder(BehaviorVariableHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Called Subprogram Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Called Subprogram Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCalledSubprogramHolder(CalledSubprogramHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Feature Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Feature Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierFeatureHolder(ClassifierFeatureHolder object)
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
   * Returns the result of interpreting the object as an instance of '<em>Completion Relative Timeout</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Completion Relative Timeout</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompletionRelativeTimeout(CompletionRelativeTimeout object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Feature Property Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Feature Property Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierFeaturePropertyReference(ClassifierFeaturePropertyReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cond Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cond Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCondStatement(CondStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Access Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Access Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataAccessHolder(DataAccessHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Access Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Access Prototype Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataAccessPrototypeHolder(DataAccessPrototypeHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Component Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Component Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataComponentReference(DataComponentReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataHolder(DataHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Port Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Port Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataPortHolder(DataPortHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Subcomponent Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Subcomponent Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataSubcomponentHolder(DataSubcomponentHolder object)
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
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Relative Timeout</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Relative Timeout</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchRelativeTimeout(DispatchRelativeTimeout object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchTrigger(DispatchTrigger object)
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
   * Returns the result of interpreting the object as an instance of '<em>Dispatch Trigger Condition Stop</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dispatch Trigger Condition Stop</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object)
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
   * Returns the result of interpreting the object as an instance of '<em>Element Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementHolder(ElementHolder object)
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
   * Returns the result of interpreting the object as an instance of '<em>Else Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Else Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElseStatement(ElseStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Literal Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Literal Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumLiteralHolder(EnumLiteralHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Data Port Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Data Port Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventDataPortHolder(EventDataPortHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Port Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Port Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventPortHolder(EventPortHolder object)
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
   * Returns the result of interpreting the object as an instance of '<em>Execution Timeout Catch</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Execution Timeout Catch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutionTimeoutCatch(ExecutionTimeoutCatch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Factor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Factor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFactor(Factor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Prototype Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeaturePrototypeHolder(FeaturePrototypeHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Or For All Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Or For All Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForOrForAllStatement(ForOrForAllStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Groupable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Groupable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroupableElement(GroupableElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Group Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Group Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroupHolder(GroupHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Group Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Group Prototype Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroupPrototypeHolder(GroupPrototypeHolder object)
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
   * Returns the result of interpreting the object as an instance of '<em>Indexable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indexable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndexableElement(IndexableElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerRange(IntegerRange object)
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
   * Returns the result of interpreting the object as an instance of '<em>Integer Value Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValueConstant(IntegerValueConstant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Value Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValueVariable(IntegerValueVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Iterative Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Iterative Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIterativeVariable(IterativeVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Iterative Variable Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Iterative Variable Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIterativeVariableHolder(IterativeVariableHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lock Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lock Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLockAction(LockAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoopStatement(LoopStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericLiteral(NumericLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Otherwise</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Otherwise</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOtherwise(Otherwise object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterHolder(ParameterHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Label</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Label</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterLabel(ParameterLabel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Count Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Count Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortCountValue(PortCountValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Dequeue Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Dequeue Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortDequeueAction(PortDequeueAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Dequeue Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Dequeue Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortDequeueValue(PortDequeueValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Freeze Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Freeze Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortFreezeAction(PortFreezeAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Fresh Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Fresh Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortFreshValue(PortFreshValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortHolder(PortHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Prototype Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortPrototypeHolder(PortPrototypeHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Port Send Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Port Send Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePortSendAction(PortSendAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Name Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Name Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyNameField(PropertyNameField object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Name Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Name Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyNameHolder(PropertyNameHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Element Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Element Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyElementHolder(PropertyElementHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Association Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Association Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyAssociationHolder(PropertyAssociationHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Expression Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Expression Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyExpressionHolder(PropertyExpressionHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Type Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Type Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyTypeHolder(PropertyTypeHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prototype Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrototypeHolder(PrototypeHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelation(Relation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Shared Data Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shared Data Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSharedDataAction(SharedDataAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleExpression(SimpleExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Union Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Union Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructUnionElement(StructUnionElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Struct Union Element Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Struct Union Element Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStructUnionElementHolder(StructUnionElementHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subprogram Access Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subprogram Access Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubprogramAccessHolder(SubprogramAccessHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subprogram Call Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subprogram Call Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubprogramCallAction(SubprogramCallAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subprogram Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subprogram Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubprogramHolder(SubprogramHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subprogram Holder Proxy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subprogram Holder Proxy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubprogramHolderProxy(SubprogramHolderProxy object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subprogram Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subprogram Prototype Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubprogramPrototypeHolder(SubprogramPrototypeHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Target</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Target</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTarget(Target object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerm(Term object)
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
   * Returns the result of interpreting the object as an instance of '<em>Unlock Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unlock Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnlockAction(UnlockAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
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
   * Returns the result of interpreting the object as an instance of '<em>Value Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueVariable(ValueVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While Or Do Until Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While Or Do Until Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhileOrDoUntilStatement(WhileOrDoUntilStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mode Switch Trigger Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mode Switch Trigger Logical Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModeSwitchTriggerLogicalExpression(ModeSwitchTriggerLogicalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mode Switch Trigger Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mode Switch Trigger Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModeSwitchTriggerCondition(ModeSwitchTriggerCondition object)
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
   * Returns the result of interpreting the object as an instance of '<em>Mode Switch Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mode Switch Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModeSwitchTrigger(ModeSwitchTrigger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Set Property Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Set Property Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertySetPropertyReference(PropertySetPropertyReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subcomponent Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subcomponent Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubcomponentHolder(SubcomponentHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subprogram Subcomponent Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subprogram Subcomponent Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubprogramSubcomponentHolder(SubprogramSubcomponentHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Holder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Holder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureHolder(FeatureHolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Property Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Property Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierPropertyReference(ClassifierPropertyReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyReference(PropertyReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Upper Bound</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Upper Bound</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUpperBound(UpperBound object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lower Bound</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lower Bound</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLowerBound(LowerBound object)
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
   * Returns the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyExpression(PropertyExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyValue(PropertyValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteral(BooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberValue(NumberValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerLiteral(IntegerLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealLiteral(RealLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteral(StringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arrayable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arrayable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayableElement(ArrayableElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseData(Data object)
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

} //AadlBaSwitch
