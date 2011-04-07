/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.util;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.BooleanLiteral;
import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.IntegerLiteral;
import edu.cmu.sei.aadl.aadl2.ModalElement;

import edu.cmu.sei.aadl.aadl2.NamedElement;
import edu.cmu.sei.aadl.aadl2.NumberValue;
import edu.cmu.sei.aadl.aadl2.PropertyExpression;
import edu.cmu.sei.aadl.aadl2.PropertyValue;
import edu.cmu.sei.aadl.aadl2.RealLiteral;
import edu.cmu.sei.aadl.aadl2.StringLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage
 * @generated
 */
public class AadlBaSwitch<T> {
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
	public AadlBaSwitch() {
		if (modelPackage == null) {
			modelPackage = AadlBaPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AadlBaPackage.ASSIGNMENT_ACTION: {
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
			case AadlBaPackage.BASIC_ACTION: {
				BasicAction basicAction = (BasicAction)theEObject;
				T result = caseBasicAction(basicAction);
				if (result == null) result = caseBehaviorAction(basicAction);
				if (result == null) result = caseBehaviorActions(basicAction);
				if (result == null) result = caseBehaviorElement(basicAction);
				if (result == null) result = caseElement(basicAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTION: {
				BehaviorAction behaviorAction = (BehaviorAction)theEObject;
				T result = caseBehaviorAction(behaviorAction);
				if (result == null) result = caseBehaviorActions(behaviorAction);
				if (result == null) result = caseBehaviorElement(behaviorAction);
				if (result == null) result = caseElement(behaviorAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK: {
				BehaviorActionBlock behaviorActionBlock = (BehaviorActionBlock)theEObject;
				T result = caseBehaviorActionBlock(behaviorActionBlock);
				if (result == null) result = caseBehaviorAction(behaviorActionBlock);
				if (result == null) result = caseElement(behaviorActionBlock);
				if (result == null) result = caseBehaviorActions(behaviorActionBlock);
				if (result == null) result = caseBehaviorElement(behaviorActionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTION_COLLECTION: {
				BehaviorActionCollection behaviorActionCollection = (BehaviorActionCollection)theEObject;
				T result = caseBehaviorActionCollection(behaviorActionCollection);
				if (result == null) result = caseBehaviorActions(behaviorActionCollection);
				if (result == null) result = caseBehaviorElement(behaviorActionCollection);
				if (result == null) result = caseElement(behaviorActionCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTIONS: {
				BehaviorActions behaviorActions = (BehaviorActions)theEObject;
				T result = caseBehaviorActions(behaviorActions);
				if (result == null) result = caseBehaviorElement(behaviorActions);
				if (result == null) result = caseElement(behaviorActions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTION_SEQUENCE: {
				BehaviorActionSequence behaviorActionSequence = (BehaviorActionSequence)theEObject;
				T result = caseBehaviorActionSequence(behaviorActionSequence);
				if (result == null) result = caseBehaviorActionCollection(behaviorActionSequence);
				if (result == null) result = caseBehaviorActions(behaviorActionSequence);
				if (result == null) result = caseBehaviorElement(behaviorActionSequence);
				if (result == null) result = caseElement(behaviorActionSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTION_SET: {
				BehaviorActionSet behaviorActionSet = (BehaviorActionSet)theEObject;
				T result = caseBehaviorActionSet(behaviorActionSet);
				if (result == null) result = caseBehaviorActionCollection(behaviorActionSet);
				if (result == null) result = caseBehaviorActions(behaviorActionSet);
				if (result == null) result = caseBehaviorElement(behaviorActionSet);
				if (result == null) result = caseElement(behaviorActionSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ANNEX: {
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
			case AadlBaPackage.BEHAVIOR_CONDITION: {
				BehaviorCondition behaviorCondition = (BehaviorCondition)theEObject;
				T result = caseBehaviorCondition(behaviorCondition);
				if (result == null) result = caseBehaviorElement(behaviorCondition);
				if (result == null) result = caseElement(behaviorCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ELEMENT: {
				BehaviorElement behaviorElement = (BehaviorElement)theEObject;
				T result = caseBehaviorElement(behaviorElement);
				if (result == null) result = caseElement(behaviorElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT: {
				BehaviorNamedElement behaviorNamedElement = (BehaviorNamedElement)theEObject;
				T result = caseBehaviorNamedElement(behaviorNamedElement);
				if (result == null) result = caseBehaviorElement(behaviorNamedElement);
				if (result == null) result = caseElement(behaviorNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_STATE: {
				BehaviorState behaviorState = (BehaviorState)theEObject;
				T result = caseBehaviorState(behaviorState);
				if (result == null) result = caseBehaviorElement(behaviorState);
				if (result == null) result = caseElement(behaviorState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_TIME: {
				BehaviorTime behaviorTime = (BehaviorTime)theEObject;
				T result = caseBehaviorTime(behaviorTime);
				if (result == null) result = caseBehaviorElement(behaviorTime);
				if (result == null) result = caseElement(behaviorTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_TRANSITION: {
				BehaviorTransition behaviorTransition = (BehaviorTransition)theEObject;
				T result = caseBehaviorTransition(behaviorTransition);
				if (result == null) result = caseBehaviorElement(behaviorTransition);
				if (result == null) result = caseElement(behaviorTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_VARIABLE: {
				BehaviorVariable behaviorVariable = (BehaviorVariable)theEObject;
				T result = caseBehaviorVariable(behaviorVariable);
				if (result == null) result = caseBehaviorElement(behaviorVariable);
				if (result == null) result = caseElement(behaviorVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_BOOLEAN_LITERAL: {
				BehaviorBooleanLiteral behaviorBooleanLiteral = (BehaviorBooleanLiteral)theEObject;
				T result = caseBehaviorBooleanLiteral(behaviorBooleanLiteral);
				if (result == null) result = caseLiteral(behaviorBooleanLiteral);
				if (result == null) result = caseBooleanLiteral(behaviorBooleanLiteral);
				if (result == null) result = caseValueConstant(behaviorBooleanLiteral);
				if (result == null) result = casePropertyValue(behaviorBooleanLiteral);
				if (result == null) result = caseValue(behaviorBooleanLiteral);
				if (result == null) result = caseIntegerValueConstant(behaviorBooleanLiteral);
				if (result == null) result = casePropertyExpression(behaviorBooleanLiteral);
				if (result == null) result = caseIntegerValue(behaviorBooleanLiteral);
				if (result == null) result = caseBehaviorElement(behaviorBooleanLiteral);
				if (result == null) result = caseElement(behaviorBooleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_STRING_LITERAL: {
				BehaviorStringLiteral behaviorStringLiteral = (BehaviorStringLiteral)theEObject;
				T result = caseBehaviorStringLiteral(behaviorStringLiteral);
				if (result == null) result = caseLiteral(behaviorStringLiteral);
				if (result == null) result = caseStringLiteral(behaviorStringLiteral);
				if (result == null) result = caseValueConstant(behaviorStringLiteral);
				if (result == null) result = casePropertyValue(behaviorStringLiteral);
				if (result == null) result = caseValue(behaviorStringLiteral);
				if (result == null) result = caseIntegerValueConstant(behaviorStringLiteral);
				if (result == null) result = casePropertyExpression(behaviorStringLiteral);
				if (result == null) result = caseIntegerValue(behaviorStringLiteral);
				if (result == null) result = caseBehaviorElement(behaviorStringLiteral);
				if (result == null) result = caseElement(behaviorStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.COMMUNICATION_ACTION: {
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
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH: {
				CompletionRelativeTimeoutConditionAndCatch completionRelativeTimeoutConditionAndCatch = (CompletionRelativeTimeoutConditionAndCatch)theEObject;
				T result = caseCompletionRelativeTimeoutConditionAndCatch(completionRelativeTimeoutConditionAndCatch);
				if (result == null) result = caseDispatchTriggerCondition(completionRelativeTimeoutConditionAndCatch);
				if (result == null) result = caseBehaviorTime(completionRelativeTimeoutConditionAndCatch);
				if (result == null) result = caseBehaviorElement(completionRelativeTimeoutConditionAndCatch);
				if (result == null) result = caseElement(completionRelativeTimeoutConditionAndCatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.COND_STATEMENT: {
				CondStatement condStatement = (CondStatement)theEObject;
				T result = caseCondStatement(condStatement);
				if (result == null) result = caseBehaviorAction(condStatement);
				if (result == null) result = caseBehaviorActions(condStatement);
				if (result == null) result = caseBehaviorElement(condStatement);
				if (result == null) result = caseElement(condStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DATA_COMPONENT_REFERENCE: {
				DataComponentReference dataComponentReference = (DataComponentReference)theEObject;
				T result = caseDataComponentReference(dataComponentReference);
				if (result == null) result = caseElementValues(dataComponentReference);
				if (result == null) result = caseTarget(dataComponentReference);
				if (result == null) result = caseValueVariable(dataComponentReference);
				if (result == null) result = caseParameterLabel(dataComponentReference);
				if (result == null) result = caseValue(dataComponentReference);
				if (result == null) result = caseIntegerValueVariable(dataComponentReference);
				if (result == null) result = caseElement(dataComponentReference);
				if (result == null) result = caseIntegerValue(dataComponentReference);
				if (result == null) result = caseBehaviorElement(dataComponentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DECLARATOR: {
				Declarator declarator = (Declarator)theEObject;
				T result = caseDeclarator(declarator);
				if (result == null) result = caseBehaviorElement(declarator);
				if (result == null) result = caseElement(declarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_CONDITION: {
				DispatchCondition dispatchCondition = (DispatchCondition)theEObject;
				T result = caseDispatchCondition(dispatchCondition);
				if (result == null) result = caseBehaviorCondition(dispatchCondition);
				if (result == null) result = caseBehaviorElement(dispatchCondition);
				if (result == null) result = caseElement(dispatchCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_CONJUNCTION: {
				DispatchConjunction dispatchConjunction = (DispatchConjunction)theEObject;
				T result = caseDispatchConjunction(dispatchConjunction);
				if (result == null) result = caseBehaviorElement(dispatchConjunction);
				if (result == null) result = caseElement(dispatchConjunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_TRIGGER_CONDITION: {
				DispatchTriggerCondition dispatchTriggerCondition = (DispatchTriggerCondition)theEObject;
				T result = caseDispatchTriggerCondition(dispatchTriggerCondition);
				if (result == null) result = caseBehaviorElement(dispatchTriggerCondition);
				if (result == null) result = caseElement(dispatchTriggerCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_TRIGGER_CONDITION_STOP: {
				DispatchTriggerConditionStop dispatchTriggerConditionStop = (DispatchTriggerConditionStop)theEObject;
				T result = caseDispatchTriggerConditionStop(dispatchTriggerConditionStop);
				if (result == null) result = caseDispatchTriggerCondition(dispatchTriggerConditionStop);
				if (result == null) result = caseBehaviorElement(dispatchTriggerConditionStop);
				if (result == null) result = caseElement(dispatchTriggerConditionStop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_TRIGGER_LOGICAL_EXPRESSION: {
				DispatchTriggerLogicalExpression dispatchTriggerLogicalExpression = (DispatchTriggerLogicalExpression)theEObject;
				T result = caseDispatchTriggerLogicalExpression(dispatchTriggerLogicalExpression);
				if (result == null) result = caseDispatchTriggerCondition(dispatchTriggerLogicalExpression);
				if (result == null) result = caseBehaviorElement(dispatchTriggerLogicalExpression);
				if (result == null) result = caseElement(dispatchTriggerLogicalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.ELEMENT_VALUES: {
				ElementValues elementValues = (ElementValues)theEObject;
				T result = caseElementValues(elementValues);
				if (result == null) result = caseBehaviorElement(elementValues);
				if (result == null) result = caseElement(elementValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.EXECUTE_CONDITION: {
				ExecuteCondition executeCondition = (ExecuteCondition)theEObject;
				T result = caseExecuteCondition(executeCondition);
				if (result == null) result = caseBehaviorCondition(executeCondition);
				if (result == null) result = caseBehaviorElement(executeCondition);
				if (result == null) result = caseElement(executeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.FACTOR: {
				Factor factor = (Factor)theEObject;
				T result = caseFactor(factor);
				if (result == null) result = caseBehaviorElement(factor);
				if (result == null) result = caseElement(factor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT: {
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
			case AadlBaPackage.IDENTIFIER: {
				Identifier identifier = (Identifier)theEObject;
				T result = caseIdentifier(identifier);
				if (result == null) result = caseDispatchTriggerCondition(identifier);
				if (result == null) result = caseBehaviorElement(identifier);
				if (result == null) result = caseElement(identifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseCondStatement(ifStatement);
				if (result == null) result = caseBehaviorAction(ifStatement);
				if (result == null) result = caseBehaviorActions(ifStatement);
				if (result == null) result = caseBehaviorElement(ifStatement);
				if (result == null) result = caseElement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_INTEGER_LITERAL: {
				BehaviorIntegerLiteral behaviorIntegerLiteral = (BehaviorIntegerLiteral)theEObject;
				T result = caseBehaviorIntegerLiteral(behaviorIntegerLiteral);
				if (result == null) result = caseNumericLiteral(behaviorIntegerLiteral);
				if (result == null) result = caseIntegerLiteral(behaviorIntegerLiteral);
				if (result == null) result = caseLiteral(behaviorIntegerLiteral);
				if (result == null) result = caseNumberValue(behaviorIntegerLiteral);
				if (result == null) result = caseValueConstant(behaviorIntegerLiteral);
				if (result == null) result = casePropertyValue(behaviorIntegerLiteral);
				if (result == null) result = caseValue(behaviorIntegerLiteral);
				if (result == null) result = caseIntegerValueConstant(behaviorIntegerLiteral);
				if (result == null) result = casePropertyExpression(behaviorIntegerLiteral);
				if (result == null) result = caseIntegerValue(behaviorIntegerLiteral);
				if (result == null) result = caseBehaviorElement(behaviorIntegerLiteral);
				if (result == null) result = caseElement(behaviorIntegerLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.INTEGER_RANGE: {
				IntegerRange integerRange = (IntegerRange)theEObject;
				T result = caseIntegerRange(integerRange);
				if (result == null) result = caseElementValues(integerRange);
				if (result == null) result = caseBehaviorElement(integerRange);
				if (result == null) result = caseElement(integerRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.INTEGER_VALUE: {
				IntegerValue integerValue = (IntegerValue)theEObject;
				T result = caseIntegerValue(integerValue);
				if (result == null) result = caseBehaviorElement(integerValue);
				if (result == null) result = caseElement(integerValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.INTEGER_VALUE_CONSTANT: {
				IntegerValueConstant integerValueConstant = (IntegerValueConstant)theEObject;
				T result = caseIntegerValueConstant(integerValueConstant);
				if (result == null) result = caseIntegerValue(integerValueConstant);
				if (result == null) result = caseBehaviorElement(integerValueConstant);
				if (result == null) result = caseElement(integerValueConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.INTEGER_VALUE_VARIABLE: {
				IntegerValueVariable integerValueVariable = (IntegerValueVariable)theEObject;
				T result = caseIntegerValueVariable(integerValueVariable);
				if (result == null) result = caseIntegerValue(integerValueVariable);
				if (result == null) result = caseBehaviorElement(integerValueVariable);
				if (result == null) result = caseElement(integerValueVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseValueConstant(literal);
				if (result == null) result = caseValue(literal);
				if (result == null) result = caseIntegerValueConstant(literal);
				if (result == null) result = caseIntegerValue(literal);
				if (result == null) result = caseBehaviorElement(literal);
				if (result == null) result = caseElement(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.LOCK_ACTION: {
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
			case AadlBaPackage.LOOP_STATEMENT: {
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
			case AadlBaPackage.NAME: {
				Name name = (Name)theEObject;
				T result = caseName(name);
				if (result == null) result = caseElementValues(name);
				if (result == null) result = caseTarget(name);
				if (result == null) result = caseValueVariable(name);
				if (result == null) result = caseParameterLabel(name);
				if (result == null) result = caseValue(name);
				if (result == null) result = caseIntegerValueVariable(name);
				if (result == null) result = caseElement(name);
				if (result == null) result = caseIntegerValue(name);
				if (result == null) result = caseBehaviorElement(name);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.NUMERAL: {
				Numeral numeral = (Numeral)theEObject;
				T result = caseNumeral(numeral);
				if (result == null) result = caseBehaviorElement(numeral);
				if (result == null) result = caseElement(numeral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.NUMERIC_LITERAL: {
				NumericLiteral numericLiteral = (NumericLiteral)theEObject;
				T result = caseNumericLiteral(numericLiteral);
				if (result == null) result = caseLiteral(numericLiteral);
				if (result == null) result = caseNumberValue(numericLiteral);
				if (result == null) result = caseValueConstant(numericLiteral);
				if (result == null) result = casePropertyValue(numericLiteral);
				if (result == null) result = caseValue(numericLiteral);
				if (result == null) result = caseIntegerValueConstant(numericLiteral);
				if (result == null) result = casePropertyExpression(numericLiteral);
				if (result == null) result = caseIntegerValue(numericLiteral);
				if (result == null) result = caseBehaviorElement(numericLiteral);
				if (result == null) result = caseElement(numericLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.OTHERWISE: {
				Otherwise otherwise = (Otherwise)theEObject;
				T result = caseOtherwise(otherwise);
				if (result == null) result = caseExecuteCondition(otherwise);
				if (result == null) result = caseBehaviorCondition(otherwise);
				if (result == null) result = caseBehaviorElement(otherwise);
				if (result == null) result = caseElement(otherwise);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PARAMETER_LABEL: {
				ParameterLabel parameterLabel = (ParameterLabel)theEObject;
				T result = caseParameterLabel(parameterLabel);
				if (result == null) result = caseBehaviorElement(parameterLabel);
				if (result == null) result = caseElement(parameterLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PORT_COUNT_VALUE: {
				PortCountValue portCountValue = (PortCountValue)theEObject;
				T result = casePortCountValue(portCountValue);
				if (result == null) result = caseName(portCountValue);
				if (result == null) result = caseValueVariable(portCountValue);
				if (result == null) result = caseValue(portCountValue);
				if (result == null) result = caseIntegerValueVariable(portCountValue);
				if (result == null) result = caseElementValues(portCountValue);
				if (result == null) result = caseTarget(portCountValue);
				if (result == null) result = caseIntegerValue(portCountValue);
				if (result == null) result = caseParameterLabel(portCountValue);
				if (result == null) result = caseBehaviorElement(portCountValue);
				if (result == null) result = caseElement(portCountValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PORT_DEQUEUE_ACTION: {
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
			case AadlBaPackage.PORT_DEQUEUE_VALUE: {
				PortDequeueValue portDequeueValue = (PortDequeueValue)theEObject;
				T result = casePortDequeueValue(portDequeueValue);
				if (result == null) result = caseName(portDequeueValue);
				if (result == null) result = caseValueVariable(portDequeueValue);
				if (result == null) result = caseValue(portDequeueValue);
				if (result == null) result = caseIntegerValueVariable(portDequeueValue);
				if (result == null) result = caseElementValues(portDequeueValue);
				if (result == null) result = caseTarget(portDequeueValue);
				if (result == null) result = caseIntegerValue(portDequeueValue);
				if (result == null) result = caseParameterLabel(portDequeueValue);
				if (result == null) result = caseBehaviorElement(portDequeueValue);
				if (result == null) result = caseElement(portDequeueValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PORT_FREEZE_ACTION: {
				PortFreezeAction portFreezeAction = (PortFreezeAction)theEObject;
				T result = casePortFreezeAction(portFreezeAction);
				if (result == null) result = caseCommunicationAction(portFreezeAction);
				if (result == null) result = caseName(portFreezeAction);
				if (result == null) result = caseBasicAction(portFreezeAction);
				if (result == null) result = caseElementValues(portFreezeAction);
				if (result == null) result = caseTarget(portFreezeAction);
				if (result == null) result = caseValueVariable(portFreezeAction);
				if (result == null) result = caseBehaviorAction(portFreezeAction);
				if (result == null) result = caseParameterLabel(portFreezeAction);
				if (result == null) result = caseValue(portFreezeAction);
				if (result == null) result = caseIntegerValueVariable(portFreezeAction);
				if (result == null) result = caseBehaviorActions(portFreezeAction);
				if (result == null) result = caseIntegerValue(portFreezeAction);
				if (result == null) result = caseBehaviorElement(portFreezeAction);
				if (result == null) result = caseElement(portFreezeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PORT_FRESH_VALUE: {
				PortFreshValue portFreshValue = (PortFreshValue)theEObject;
				T result = casePortFreshValue(portFreshValue);
				if (result == null) result = caseName(portFreshValue);
				if (result == null) result = caseValueVariable(portFreshValue);
				if (result == null) result = caseValue(portFreshValue);
				if (result == null) result = caseIntegerValueVariable(portFreshValue);
				if (result == null) result = caseElementValues(portFreshValue);
				if (result == null) result = caseTarget(portFreshValue);
				if (result == null) result = caseIntegerValue(portFreshValue);
				if (result == null) result = caseParameterLabel(portFreshValue);
				if (result == null) result = caseBehaviorElement(portFreshValue);
				if (result == null) result = caseElement(portFreshValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PORT_SEND_ACTION: {
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
			case AadlBaPackage.BEHAVIOR_PROPERTY_CONSTANT: {
				BehaviorPropertyConstant behaviorPropertyConstant = (BehaviorPropertyConstant)theEObject;
				T result = caseBehaviorPropertyConstant(behaviorPropertyConstant);
				if (result == null) result = caseBehaviorNamedElement(behaviorPropertyConstant);
				if (result == null) result = caseValueConstant(behaviorPropertyConstant);
				if (result == null) result = caseValue(behaviorPropertyConstant);
				if (result == null) result = caseIntegerValueConstant(behaviorPropertyConstant);
				if (result == null) result = caseElement(behaviorPropertyConstant);
				if (result == null) result = caseIntegerValue(behaviorPropertyConstant);
				if (result == null) result = caseBehaviorElement(behaviorPropertyConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_PROPERTY_VALUE: {
				BehaviorPropertyValue behaviorPropertyValue = (BehaviorPropertyValue)theEObject;
				T result = caseBehaviorPropertyValue(behaviorPropertyValue);
				if (result == null) result = caseBehaviorNamedElement(behaviorPropertyValue);
				if (result == null) result = caseValueConstant(behaviorPropertyValue);
				if (result == null) result = caseValue(behaviorPropertyValue);
				if (result == null) result = caseIntegerValueConstant(behaviorPropertyValue);
				if (result == null) result = caseElement(behaviorPropertyValue);
				if (result == null) result = caseIntegerValue(behaviorPropertyValue);
				if (result == null) result = caseBehaviorElement(behaviorPropertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_REAL_LITERAL: {
				BehaviorRealLiteral behaviorRealLiteral = (BehaviorRealLiteral)theEObject;
				T result = caseBehaviorRealLiteral(behaviorRealLiteral);
				if (result == null) result = caseNumericLiteral(behaviorRealLiteral);
				if (result == null) result = caseRealLiteral(behaviorRealLiteral);
				if (result == null) result = caseLiteral(behaviorRealLiteral);
				if (result == null) result = caseNumberValue(behaviorRealLiteral);
				if (result == null) result = caseValueConstant(behaviorRealLiteral);
				if (result == null) result = casePropertyValue(behaviorRealLiteral);
				if (result == null) result = caseValue(behaviorRealLiteral);
				if (result == null) result = caseIntegerValueConstant(behaviorRealLiteral);
				if (result == null) result = casePropertyExpression(behaviorRealLiteral);
				if (result == null) result = caseIntegerValue(behaviorRealLiteral);
				if (result == null) result = caseBehaviorElement(behaviorRealLiteral);
				if (result == null) result = caseElement(behaviorRealLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = caseBehaviorElement(relation);
				if (result == null) result = caseElement(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.SHARED_DATA_ACTION: {
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
			case AadlBaPackage.SIMPLE_EXPRESSION: {
				SimpleExpression simpleExpression = (SimpleExpression)theEObject;
				T result = caseSimpleExpression(simpleExpression);
				if (result == null) result = caseBehaviorElement(simpleExpression);
				if (result == null) result = caseElement(simpleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.SUBPROGRAM_CALL_ACTION: {
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
			case AadlBaPackage.TARGET: {
				Target target = (Target)theEObject;
				T result = caseTarget(target);
				if (result == null) result = caseParameterLabel(target);
				if (result == null) result = caseBehaviorElement(target);
				if (result == null) result = caseElement(target);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseBehaviorElement(term);
				if (result == null) result = caseElement(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.TIMED_ACTION: {
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
			case AadlBaPackage.TIMEOUT_CATCH: {
				TimeoutCatch timeoutCatch = (TimeoutCatch)theEObject;
				T result = caseTimeoutCatch(timeoutCatch);
				if (result == null) result = caseExecuteCondition(timeoutCatch);
				if (result == null) result = caseDispatchTriggerCondition(timeoutCatch);
				if (result == null) result = caseBehaviorCondition(timeoutCatch);
				if (result == null) result = caseBehaviorElement(timeoutCatch);
				if (result == null) result = caseElement(timeoutCatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE: {
				UniqueComponentClassifierReference uniqueComponentClassifierReference = (UniqueComponentClassifierReference)theEObject;
				T result = caseUniqueComponentClassifierReference(uniqueComponentClassifierReference);
				if (result == null) result = caseBehaviorNamedElement(uniqueComponentClassifierReference);
				if (result == null) result = caseBehaviorElement(uniqueComponentClassifierReference);
				if (result == null) result = caseElement(uniqueComponentClassifierReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.UNLOCK_ACTION: {
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
			case AadlBaPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = caseBehaviorElement(value);
				if (result == null) result = caseElement(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.VALUE_CONSTANT: {
				ValueConstant valueConstant = (ValueConstant)theEObject;
				T result = caseValueConstant(valueConstant);
				if (result == null) result = caseValue(valueConstant);
				if (result == null) result = caseIntegerValueConstant(valueConstant);
				if (result == null) result = caseIntegerValue(valueConstant);
				if (result == null) result = caseBehaviorElement(valueConstant);
				if (result == null) result = caseElement(valueConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.VALUE_EXPRESSION: {
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
			case AadlBaPackage.VALUE_VARIABLE: {
				ValueVariable valueVariable = (ValueVariable)theEObject;
				T result = caseValueVariable(valueVariable);
				if (result == null) result = caseValue(valueVariable);
				if (result == null) result = caseIntegerValueVariable(valueVariable);
				if (result == null) result = caseIntegerValue(valueVariable);
				if (result == null) result = caseBehaviorElement(valueVariable);
				if (result == null) result = caseElement(valueVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.WHILE_OR_DO_UNTIL_STATEMENT: {
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
	public T caseBehaviorAnnex(BehaviorAnnex object) {
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
	public T caseBehaviorCondition(BehaviorCondition object) {
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
	public T caseBehaviorElement(BehaviorElement object) {
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
	public T caseBehaviorNamedElement(BehaviorNamedElement object) {
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
	public T caseBehaviorState(BehaviorState object) {
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
	public T caseBehaviorTransition(BehaviorTransition object) {
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
	public T caseBehaviorVariable(BehaviorVariable object) {
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
	public T caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object) {
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
	public T caseBehaviorStringLiteral(BehaviorStringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclarator(Declarator object) {
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
	public T caseElement(Element object) {
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
	public T caseExecuteCondition(ExecuteCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
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
	public T caseNamedElement(NamedElement object) {
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
	public T caseOtherwise(Otherwise object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timeout Catch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timeout Catch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeoutCatch(TimeoutCatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Component Classifier Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Component Classifier Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniqueComponentClassifierReference(UniqueComponentClassifierReference object) {
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
	public T caseBehaviorTime(BehaviorTime object) {
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
	public T caseBooleanLiteral(BooleanLiteral object) {
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
	public T caseFactor(Factor object) {
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
	public T caseIntegerLiteral(IntegerLiteral object) {
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
	public T caseIntegerRange(IntegerRange object) {
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
	public T caseIntegerValue(IntegerValue object) {
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
	public T caseIntegerValueConstant(IntegerValueConstant object) {
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
	public T caseIntegerValueVariable(IntegerValueVariable object) {
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
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumeral(Numeral object) {
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
	public T caseNumericLiteral(NumericLiteral object) {
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
	public T casePortCountValue(PortCountValue object) {
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
	public T casePortDequeueValue(PortDequeueValue object) {
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
	public T casePortFreshValue(PortFreshValue object) {
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
	public T caseRealLiteral(RealLiteral object) {
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
	public T caseRelation(Relation object) {
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
	public T caseSimpleExpression(SimpleExpression object) {
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
	public T caseStringLiteral(StringLiteral object) {
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
	public T caseNumberValue(NumberValue object) {
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
	public T caseTerm(Term object) {
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
	public T caseValue(Value object) {
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
	public T caseValueConstant(ValueConstant object) {
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
	public T caseValueExpression(ValueExpression object) {
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
	public T caseValueVariable(ValueVariable object) {
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
	public T caseAssignmentAction(AssignmentAction object) {
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
	public T caseBasicAction(BasicAction object) {
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
	public T caseBehaviorAction(BehaviorAction object) {
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
	public T caseBehaviorActionBlock(BehaviorActionBlock object) {
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
	public T caseBehaviorActionCollection(BehaviorActionCollection object) {
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
	public T caseBehaviorActions(BehaviorActions object) {
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
	public T caseBehaviorActionSequence(BehaviorActionSequence object) {
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
	public T caseBehaviorActionSet(BehaviorActionSet object) {
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
	public T caseCommunicationAction(CommunicationAction object) {
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
	public T caseCondStatement(CondStatement object) {
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
	public T caseDataComponentReference(DataComponentReference object) {
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
	public T caseElementValues(ElementValues object) {
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
	public T caseForOrForAllStatement(ForOrForAllStatement object) {
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
	public T caseIfStatement(IfStatement object) {
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
	public T caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object) {
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
	public T caseLockAction(LockAction object) {
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
	public T caseLoopStatement(LoopStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseName(Name object) {
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
	public T caseParameterLabel(ParameterLabel object) {
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
	public T casePortDequeueAction(PortDequeueAction object) {
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
	public T casePortFreezeAction(PortFreezeAction object) {
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
	public T casePortSendAction(PortSendAction object) {
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
	public T caseBehaviorPropertyConstant(BehaviorPropertyConstant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorPropertyValue(BehaviorPropertyValue object) {
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
	public T caseBehaviorRealLiteral(BehaviorRealLiteral object) {
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
	public T caseSharedDataAction(SharedDataAction object) {
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
	public T caseSubprogramCallAction(SubprogramCallAction object) {
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
	public T caseTarget(Target object) {
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
	public T caseTimedAction(TimedAction object) {
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
	public T caseUnlockAction(UnlockAction object) {
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
	public T caseWhileOrDoUntilStatement(WhileOrDoUntilStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Completion Relative Timeout Condition And Catch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Completion Relative Timeout Condition And Catch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompletionRelativeTimeoutConditionAndCatch(CompletionRelativeTimeoutConditionAndCatch object) {
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
	public T caseDispatchCondition(DispatchCondition object) {
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
	public T caseDispatchConjunction(DispatchConjunction object) {
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
	public T caseDispatchTriggerCondition(DispatchTriggerCondition object) {
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
	public T caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object) {
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
	public T caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object) {
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
	public T caseModalElement(ModalElement object) {
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
	public T caseAnnexSubclause(AnnexSubclause object) {
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
	public T casePropertyExpression(PropertyExpression object) {
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
	public T casePropertyValue(PropertyValue object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //AadlBaSwitch
