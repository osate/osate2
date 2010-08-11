/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.util;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import edu.cmu.sei.aadl.aadl2.ModalElement;

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
public class AadlBaSwitch<T>
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
   public T doSwitch(EObject theEObject)
   {
		return doSwitch(theEObject.eClass(), theEObject);
	}

   /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
   protected T doSwitch(EClass theEClass, EObject theEObject)
   {
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
   protected T doSwitch(int classifierID, EObject theEObject)
   {
		switch (classifierID) {
			case AadlBaPackage.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = caseAadl2_Element(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = caseElement(comment);
				if (result == null) result = caseAadl2_Element(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseElement(namedElement);
				if (result == null) result = caseAadl2_Element(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.NAMESPACE: {
				Namespace namespace = (Namespace)theEObject;
				T result = caseNamespace(namespace);
				if (result == null) result = caseNamedElement(namespace);
				if (result == null) result = caseElement(namespace);
				if (result == null) result = caseAadl2_Element(namespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.GLOBAL_NAMESPACE: {
				GlobalNamespace globalNamespace = (GlobalNamespace)theEObject;
				T result = caseGlobalNamespace(globalNamespace);
				if (result == null) result = caseNamespace(globalNamespace);
				if (result == null) result = caseNamedElement(globalNamespace);
				if (result == null) result = caseElement(globalNamespace);
				if (result == null) result = caseAadl2_Element(globalNamespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ANNEX: {
				BehaviorAnnex behaviorAnnex = (BehaviorAnnex)theEObject;
				T result = caseBehaviorAnnex(behaviorAnnex);
				if (result == null) result = caseAnnexSubclause(behaviorAnnex);
				if (result == null) result = caseElement(behaviorAnnex);
				if (result == null) result = caseModalElement(behaviorAnnex);
				if (result == null) result = caseAadl2_NamedElement(behaviorAnnex);
				if (result == null) result = caseAadl2_Element(behaviorAnnex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE: {
				UniqueComponentClassifierReference uniqueComponentClassifierReference = (UniqueComponentClassifierReference)theEObject;
				T result = caseUniqueComponentClassifierReference(uniqueComponentClassifierReference);
				if (result == null) result = caseNamedElement(uniqueComponentClassifierReference);
				if (result == null) result = caseElement(uniqueComponentClassifierReference);
				if (result == null) result = caseAadl2_Element(uniqueComponentClassifierReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_VARIABLE: {
				BehaviorVariable behaviorVariable = (BehaviorVariable)theEObject;
				T result = caseBehaviorVariable(behaviorVariable);
				if (result == null) result = caseElement(behaviorVariable);
				if (result == null) result = caseAadl2_Element(behaviorVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_STATE: {
				BehaviorState behaviorState = (BehaviorState)theEObject;
				T result = caseBehaviorState(behaviorState);
				if (result == null) result = caseElement(behaviorState);
				if (result == null) result = caseAadl2_Element(behaviorState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_TRANSITION: {
				BehaviorTransition behaviorTransition = (BehaviorTransition)theEObject;
				T result = caseBehaviorTransition(behaviorTransition);
				if (result == null) result = caseElement(behaviorTransition);
				if (result == null) result = caseAadl2_Element(behaviorTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_CONDITION: {
				BehaviorCondition behaviorCondition = (BehaviorCondition)theEObject;
				T result = caseBehaviorCondition(behaviorCondition);
				if (result == null) result = caseElement(behaviorCondition);
				if (result == null) result = caseAadl2_Element(behaviorCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DECLARATOR: {
				Declarator declarator = (Declarator)theEObject;
				T result = caseDeclarator(declarator);
				if (result == null) result = caseNamedElement(declarator);
				if (result == null) result = caseElement(declarator);
				if (result == null) result = caseAadl2_Element(declarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.ARRAY_SIZE: {
				ArraySize arraySize = (ArraySize)theEObject;
				T result = caseArraySize(arraySize);
				if (result == null) result = caseElement(arraySize);
				if (result == null) result = caseAadl2_Element(arraySize);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_CONDITION: {
				DispatchCondition dispatchCondition = (DispatchCondition)theEObject;
				T result = caseDispatchCondition(dispatchCondition);
				if (result == null) result = caseBehaviorCondition(dispatchCondition);
				if (result == null) result = caseElement(dispatchCondition);
				if (result == null) result = caseAadl2_Element(dispatchCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION: {
				DispatchLogicalExpression dispatchLogicalExpression = (DispatchLogicalExpression)theEObject;
				T result = caseDispatchLogicalExpression(dispatchLogicalExpression);
				if (result == null) result = caseElement(dispatchLogicalExpression);
				if (result == null) result = caseAadl2_Element(dispatchLogicalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DISPATCH_TRIGGER: {
				DispatchTrigger dispatchTrigger = (DispatchTrigger)theEObject;
				T result = caseDispatchTrigger(dispatchTrigger);
				if (result == null) result = caseElement(dispatchTrigger);
				if (result == null) result = caseAadl2_Element(dispatchTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTIONS: {
				BehaviorActions behaviorActions = (BehaviorActions)theEObject;
				T result = caseBehaviorActions(behaviorActions);
				if (result == null) result = caseElement(behaviorActions);
				if (result == null) result = caseAadl2_Element(behaviorActions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_ACTION: {
				BehaviorAction behaviorAction = (BehaviorAction)theEObject;
				T result = caseBehaviorAction(behaviorAction);
				if (result == null) result = caseElement(behaviorAction);
				if (result == null) result = caseAadl2_Element(behaviorAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.COND_STATEMENT: {
				CondStatement condStatement = (CondStatement)theEObject;
				T result = caseCondStatement(condStatement);
				if (result == null) result = caseElement(condStatement);
				if (result == null) result = caseAadl2_Element(condStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BASIC_ACTION: {
				BasicAction basicAction = (BasicAction)theEObject;
				T result = caseBasicAction(basicAction);
				if (result == null) result = caseElement(basicAction);
				if (result == null) result = caseAadl2_Element(basicAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseCondStatement(ifStatement);
				if (result == null) result = caseElement(ifStatement);
				if (result == null) result = caseAadl2_Element(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.FOR_OR_FOR_ALL_STATEMENT: {
				ForOrForAllStatement forOrForAllStatement = (ForOrForAllStatement)theEObject;
				T result = caseForOrForAllStatement(forOrForAllStatement);
				if (result == null) result = caseNamedElement(forOrForAllStatement);
				if (result == null) result = caseLoopStatement(forOrForAllStatement);
				if (result == null) result = caseCondStatement(forOrForAllStatement);
				if (result == null) result = caseElement(forOrForAllStatement);
				if (result == null) result = caseAadl2_Element(forOrForAllStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseLoopStatement(whileStatement);
				if (result == null) result = caseCondStatement(whileStatement);
				if (result == null) result = caseElement(whileStatement);
				if (result == null) result = caseAadl2_Element(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DO_UNTIL_STATEMENT: {
				DoUntilStatement doUntilStatement = (DoUntilStatement)theEObject;
				T result = caseDoUntilStatement(doUntilStatement);
				if (result == null) result = caseLoopStatement(doUntilStatement);
				if (result == null) result = caseCondStatement(doUntilStatement);
				if (result == null) result = caseElement(doUntilStatement);
				if (result == null) result = caseAadl2_Element(doUntilStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.ELEMENT_VALUES: {
				ElementValues elementValues = (ElementValues)theEObject;
				T result = caseElementValues(elementValues);
				if (result == null) result = caseElement(elementValues);
				if (result == null) result = caseAadl2_Element(elementValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.ASSIGNMENT_ACTION: {
				AssignmentAction assignmentAction = (AssignmentAction)theEObject;
				T result = caseAssignmentAction(assignmentAction);
				if (result == null) result = caseBasicAction(assignmentAction);
				if (result == null) result = caseElement(assignmentAction);
				if (result == null) result = caseAadl2_Element(assignmentAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.COMMUNICATION_ACTION: {
				CommunicationAction communicationAction = (CommunicationAction)theEObject;
				T result = caseCommunicationAction(communicationAction);
				if (result == null) result = caseBasicAction(communicationAction);
				if (result == null) result = caseElement(communicationAction);
				if (result == null) result = caseAadl2_Element(communicationAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.SUBPROGRAM_PARAMETER_LIST: {
				SubprogramParameterList subprogramParameterList = (SubprogramParameterList)theEObject;
				T result = caseSubprogramParameterList(subprogramParameterList);
				if (result == null) result = caseElement(subprogramParameterList);
				if (result == null) result = caseAadl2_Element(subprogramParameterList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.TIMED_ACTION: {
				TimedAction timedAction = (TimedAction)theEObject;
				T result = caseTimedAction(timedAction);
				if (result == null) result = caseBasicAction(timedAction);
				if (result == null) result = caseElement(timedAction);
				if (result == null) result = caseAadl2_Element(timedAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.TARGET: {
				Target target = (Target)theEObject;
				T result = caseTarget(target);
				if (result == null) result = caseParameterLabel(target);
				if (result == null) result = caseElement(target);
				if (result == null) result = caseAadl2_Element(target);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PARAMETER_LABEL: {
				ParameterLabel parameterLabel = (ParameterLabel)theEObject;
				T result = caseParameterLabel(parameterLabel);
				if (result == null) result = caseElement(parameterLabel);
				if (result == null) result = caseAadl2_Element(parameterLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.DATA_COMPONENT_REFERENCE: {
				DataComponentReference dataComponentReference = (DataComponentReference)theEObject;
				T result = caseDataComponentReference(dataComponentReference);
				if (result == null) result = caseElementValues(dataComponentReference);
				if (result == null) result = caseElement(dataComponentReference);
				if (result == null) result = caseAadl2_Element(dataComponentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.NAME: {
				Name name = (Name)theEObject;
				T result = caseName(name);
				if (result == null) result = caseNamedElement(name);
				if (result == null) result = caseElementValues(name);
				if (result == null) result = caseElement(name);
				if (result == null) result = caseAadl2_Element(name);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.ARRAY_INDEX: {
				ArrayIndex arrayIndex = (ArrayIndex)theEObject;
				T result = caseArrayIndex(arrayIndex);
				if (result == null) result = caseElement(arrayIndex);
				if (result == null) result = caseAadl2_Element(arrayIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = caseElement(value);
				if (result == null) result = caseAadl2_Element(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.VALUE_VARIABLE: {
				ValueVariable valueVariable = (ValueVariable)theEObject;
				T result = caseValueVariable(valueVariable);
				if (result == null) result = caseValue(valueVariable);
				if (result == null) result = caseIntegerValue(valueVariable);
				if (result == null) result = caseElement(valueVariable);
				if (result == null) result = caseAadl2_Element(valueVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.VALUE_CONSTANT: {
				ValueConstant valueConstant = (ValueConstant)theEObject;
				T result = caseValueConstant(valueConstant);
				if (result == null) result = caseValue(valueConstant);
				if (result == null) result = caseIntegerValue(valueConstant);
				if (result == null) result = caseElement(valueConstant);
				if (result == null) result = caseAadl2_Element(valueConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.VALUE_EXPRESSION: {
				ValueExpression valueExpression = (ValueExpression)theEObject;
				T result = caseValueExpression(valueExpression);
				if (result == null) result = caseValue(valueExpression);
				if (result == null) result = caseParameterLabel(valueExpression);
				if (result == null) result = caseElement(valueExpression);
				if (result == null) result = caseAadl2_Element(valueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.RELATION: {
				Relation relation = (Relation)theEObject;
				T result = caseRelation(relation);
				if (result == null) result = caseElement(relation);
				if (result == null) result = caseAadl2_Element(relation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.SIMPLE_EXPRESSION: {
				SimpleExpression simpleExpression = (SimpleExpression)theEObject;
				T result = caseSimpleExpression(simpleExpression);
				if (result == null) result = caseElement(simpleExpression);
				if (result == null) result = caseAadl2_Element(simpleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseElement(term);
				if (result == null) result = caseAadl2_Element(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.FACTOR: {
				Factor factor = (Factor)theEObject;
				T result = caseFactor(factor);
				if (result == null) result = caseElement(factor);
				if (result == null) result = caseAadl2_Element(factor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.INTEGER_RANGE: {
				IntegerRange integerRange = (IntegerRange)theEObject;
				T result = caseIntegerRange(integerRange);
				if (result == null) result = caseElementValues(integerRange);
				if (result == null) result = caseElement(integerRange);
				if (result == null) result = caseAadl2_Element(integerRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.INTEGER_VALUE: {
				IntegerValue integerValue = (IntegerValue)theEObject;
				T result = caseIntegerValue(integerValue);
				if (result == null) result = caseElement(integerValue);
				if (result == null) result = caseAadl2_Element(integerValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BEHAVIOR_TIME: {
				BehaviorTime behaviorTime = (BehaviorTime)theEObject;
				T result = caseBehaviorTime(behaviorTime);
				if (result == null) result = caseElement(behaviorTime);
				if (result == null) result = caseAadl2_Element(behaviorTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PROPERTY_CONSTANT: {
				PropertyConstant propertyConstant = (PropertyConstant)theEObject;
				T result = casePropertyConstant(propertyConstant);
				if (result == null) result = caseNamedElement(propertyConstant);
				if (result == null) result = caseValueConstant(propertyConstant);
				if (result == null) result = caseValue(propertyConstant);
				if (result == null) result = caseIntegerValue(propertyConstant);
				if (result == null) result = caseElement(propertyConstant);
				if (result == null) result = caseAadl2_Element(propertyConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.PROPERTY_VALUE: {
				PropertyValue propertyValue = (PropertyValue)theEObject;
				T result = casePropertyValue(propertyValue);
				if (result == null) result = caseNamedElement(propertyValue);
				if (result == null) result = caseValueConstant(propertyValue);
				if (result == null) result = caseValue(propertyValue);
				if (result == null) result = caseIntegerValue(propertyValue);
				if (result == null) result = caseElement(propertyValue);
				if (result == null) result = caseAadl2_Element(propertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.IDENTIFIER: {
				Identifier identifier = (Identifier)theEObject;
				T result = caseIdentifier(identifier);
				if (result == null) result = caseElement(identifier);
				if (result == null) result = caseAadl2_Element(identifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.NUMERIC_LITERAL: {
				NumericLiteral numericLiteral = (NumericLiteral)theEObject;
				T result = caseNumericLiteral(numericLiteral);
				if (result == null) result = caseValueConstant(numericLiteral);
				if (result == null) result = caseValue(numericLiteral);
				if (result == null) result = caseIntegerValue(numericLiteral);
				if (result == null) result = caseElement(numericLiteral);
				if (result == null) result = caseAadl2_Element(numericLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseValueConstant(booleanLiteral);
				if (result == null) result = caseValue(booleanLiteral);
				if (result == null) result = caseIntegerValue(booleanLiteral);
				if (result == null) result = caseElement(booleanLiteral);
				if (result == null) result = caseAadl2_Element(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseValueConstant(stringLiteral);
				if (result == null) result = caseValue(stringLiteral);
				if (result == null) result = caseIntegerValue(stringLiteral);
				if (result == null) result = caseElement(stringLiteral);
				if (result == null) result = caseAadl2_Element(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.NUMERAL: {
				Numeral numeral = (Numeral)theEObject;
				T result = caseNumeral(numeral);
				if (result == null) result = caseElement(numeral);
				if (result == null) result = caseAadl2_Element(numeral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.EXECUTE_CONDITION: {
				ExecuteCondition executeCondition = (ExecuteCondition)theEObject;
				T result = caseExecuteCondition(executeCondition);
				if (result == null) result = caseBehaviorCondition(executeCondition);
				if (result == null) result = caseElement(executeCondition);
				if (result == null) result = caseAadl2_Element(executeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AadlBaPackage.LOOP_STATEMENT: {
				LoopStatement loopStatement = (LoopStatement)theEObject;
				T result = caseLoopStatement(loopStatement);
				if (result == null) result = caseCondStatement(loopStatement);
				if (result == null) result = caseElement(loopStatement);
				if (result == null) result = caseAadl2_Element(loopStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
   public T caseComment(Comment object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
   public T caseNamespace(Namespace object)
   {
		return null;
	}

   /**
	 * Returns the result of interpreting the object as an instance of '<em>Global Namespace</em>'.
	 * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
   public T caseGlobalNamespace(GlobalNamespace object)
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
   public T caseUniqueComponentClassifierReference(UniqueComponentClassifierReference object)
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
   public T caseDeclarator(Declarator object)
   {
		return null;
	}

   /**
	 * Returns the result of interpreting the object as an instance of '<em>Array Size</em>'.
	 * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Size</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
   public T caseArraySize(ArraySize object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Dispatch Logical Expression</em>'.
	 * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dispatch Logical Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
   public T caseDispatchLogicalExpression(DispatchLogicalExpression object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Subprogram Parameter List</em>'.
	 * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subprogram Parameter List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
   public T caseSubprogramParameterList(SubprogramParameterList object)
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
   public T caseName(Name object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Property Constant</em>'.
	 * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
   public T casePropertyConstant(PropertyConstant object)
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
   public T caseIdentifier(Identifier object)
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
   public T caseNumeral(Numeral object)
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
   public T caseAadl2_Element(edu.cmu.sei.aadl.aadl2.Element object)
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
   public T caseAadl2_NamedElement(edu.cmu.sei.aadl.aadl2.NamedElement object)
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
   public T defaultCase(EObject object)
   {
		return null;
	}

} //AadlBaSwitch
