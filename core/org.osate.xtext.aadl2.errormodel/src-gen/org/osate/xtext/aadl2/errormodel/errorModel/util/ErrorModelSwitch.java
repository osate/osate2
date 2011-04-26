/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.osate.xtext.aadl2.errormodel.errorModel.*;

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
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
 * @generated
 */
public class ErrorModelSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ErrorModelPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ErrorModelPackage.eINSTANCE;
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
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
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
    switch (classifierID)
    {
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE:
      {
        EM2AnnexSubclause em2AnnexSubclause = (EM2AnnexSubclause)theEObject;
        T result = caseEM2AnnexSubclause(em2AnnexSubclause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_TYPE_SET:
      {
        ErrorTypeSet errorTypeSet = (ErrorTypeSet)theEObject;
        T result = caseErrorTypeSet(errorTypeSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_TYPE:
      {
        ErrorType errorType = (ErrorType)theEObject;
        T result = caseErrorType(errorType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.FEATURE:
      {
        Feature feature = (Feature)theEObject;
        T result = caseFeature(feature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT:
      {
        ErrorTypeRefinement errorTypeRefinement = (ErrorTypeRefinement)theEObject;
        T result = caseErrorTypeRefinement(errorTypeRefinement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_PROPAGATIONS:
      {
        ErrorPropagations errorPropagations = (ErrorPropagations)theEObject;
        T result = caseErrorPropagations(errorPropagations);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_PROPAGATION:
      {
        ErrorPropagation errorPropagation = (ErrorPropagation)theEObject;
        T result = caseErrorPropagation(errorPropagation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_FLOW:
      {
        ErrorFlow errorFlow = (ErrorFlow)theEObject;
        T result = caseErrorFlow(errorFlow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_SOURCE:
      {
        ErrorSource errorSource = (ErrorSource)theEObject;
        T result = caseErrorSource(errorSource);
        if (result == null) result = caseErrorFlow(errorSource);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_SINK:
      {
        ErrorSink errorSink = (ErrorSink)theEObject;
        T result = caseErrorSink(errorSink);
        if (result == null) result = caseErrorFlow(errorSink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_PATH:
      {
        ErrorPath errorPath = (ErrorPath)theEObject;
        T result = caseErrorPath(errorPath);
        if (result == null) result = caseErrorFlow(errorPath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE:
      {
        ErrorPropagationReference errorPropagationReference = (ErrorPropagationReference)theEObject;
        T result = caseErrorPropagationReference(errorPropagationReference);
        if (result == null) result = caseTriggerConditionExpression(errorPropagationReference);
        if (result == null) result = caseStateConditionExpression(errorPropagationReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE:
      {
        ErrorBehaviorStateMachine errorBehaviorStateMachine = (ErrorBehaviorStateMachine)theEObject;
        T result = caseErrorBehaviorStateMachine(errorBehaviorStateMachine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_EVENT:
      {
        ErrorBehaviorEvent errorBehaviorEvent = (ErrorBehaviorEvent)theEObject;
        T result = caseErrorBehaviorEvent(errorBehaviorEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_EVENT:
      {
        ErrorEvent errorEvent = (ErrorEvent)theEObject;
        T result = caseErrorEvent(errorEvent);
        if (result == null) result = caseErrorBehaviorEvent(errorEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.REPAIR_EVENT:
      {
        RepairEvent repairEvent = (RepairEvent)theEObject;
        T result = caseRepairEvent(repairEvent);
        if (result == null) result = caseErrorBehaviorEvent(repairEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE:
      {
        ErrorBehaviorState errorBehaviorState = (ErrorBehaviorState)theEObject;
        T result = caseErrorBehaviorState(errorBehaviorState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION:
      {
        ErrorBehaviorTransition errorBehaviorTransition = (ErrorBehaviorTransition)theEObject;
        T result = caseErrorBehaviorTransition(errorBehaviorTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TRIGGERED_TRANSITION:
      {
        TriggeredTransition triggeredTransition = (TriggeredTransition)theEObject;
        T result = caseTriggeredTransition(triggeredTransition);
        if (result == null) result = caseErrorBehaviorTransition(triggeredTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.BRANCH_TRANSITION:
      {
        BranchTransition branchTransition = (BranchTransition)theEObject;
        T result = caseBranchTransition(branchTransition);
        if (result == null) result = caseErrorBehaviorTransition(branchTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR:
      {
        ComponentErrorBehavior componentErrorBehavior = (ComponentErrorBehavior)theEObject;
        T result = caseComponentErrorBehavior(componentErrorBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TRANSITION_CONDITION:
      {
        TransitionCondition transitionCondition = (TransitionCondition)theEObject;
        T result = caseTransitionCondition(transitionCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TRIGGER_CONDITION_EXPRESSION:
      {
        TriggerConditionExpression triggerConditionExpression = (TriggerConditionExpression)theEObject;
        T result = caseTriggerConditionExpression(triggerConditionExpression);
        if (result == null) result = caseStateConditionExpression(triggerConditionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ORMORE_EXPRESSION:
      {
        OrmoreExpression ormoreExpression = (OrmoreExpression)theEObject;
        T result = caseOrmoreExpression(ormoreExpression);
        if (result == null) result = caseTriggerConditionExpression(ormoreExpression);
        if (result == null) result = caseStateConditionExpression(ormoreExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ORLESS_EXPRESSION:
      {
        OrlessExpression orlessExpression = (OrlessExpression)theEObject;
        T result = caseOrlessExpression(orlessExpression);
        if (result == null) result = caseTriggerConditionExpression(orlessExpression);
        if (result == null) result = caseStateConditionExpression(orlessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.OTHERS_EXPRESSION:
      {
        OthersExpression othersExpression = (OthersExpression)theEObject;
        T result = caseOthersExpression(othersExpression);
        if (result == null) result = caseTriggerConditionExpression(othersExpression);
        if (result == null) result = caseStateConditionExpression(othersExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_EVENT_REFERENCE:
      {
        ErrorEventReference errorEventReference = (ErrorEventReference)theEObject;
        T result = caseErrorEventReference(errorEventReference);
        if (result == null) result = caseTriggerConditionExpression(errorEventReference);
        if (result == null) result = caseStateConditionExpression(errorEventReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.WORKING_REFERENCE:
      {
        WorkingReference workingReference = (WorkingReference)theEObject;
        T result = caseWorkingReference(workingReference);
        if (result == null) result = caseTriggerConditionExpression(workingReference);
        if (result == null) result = caseStateConditionExpression(workingReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.PROPAGATION_CONDITION:
      {
        PropagationCondition propagationCondition = (PropagationCondition)theEObject;
        T result = casePropagationCondition(propagationCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.DETECTION_EVENT:
      {
        DetectionEvent detectionEvent = (DetectionEvent)theEObject;
        T result = caseDetectionEvent(detectionEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR:
      {
        CompositeErrorBehavior compositeErrorBehavior = (CompositeErrorBehavior)theEObject;
        T result = caseCompositeErrorBehavior(compositeErrorBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.COMPOSITE_STATE:
      {
        CompositeState compositeState = (CompositeState)theEObject;
        T result = caseCompositeState(compositeState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.STATE_CONDITION_EXPRESSION:
      {
        StateConditionExpression stateConditionExpression = (StateConditionExpression)theEObject;
        T result = caseStateConditionExpression(stateConditionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE:
      {
        SubcomponentStateReference subcomponentStateReference = (SubcomponentStateReference)theEObject;
        T result = caseSubcomponentStateReference(subcomponentStateReference);
        if (result == null) result = caseStateConditionExpression(subcomponentStateReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.PROPERTY_ASSOCIATION:
      {
        PropertyAssociation propertyAssociation = (PropertyAssociation)theEObject;
        T result = casePropertyAssociation(propertyAssociation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.PROPERTY_EXPRESSION:
      {
        PropertyExpression propertyExpression = (PropertyExpression)theEObject;
        T result = casePropertyExpression(propertyExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = casePropertyExpression(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.PROBABILITY_VALUE:
      {
        ProbabilityValue probabilityValue = (ProbabilityValue)theEObject;
        T result = caseProbabilityValue(probabilityValue);
        if (result == null) result = casePropertyExpression(probabilityValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = caseTriggerConditionExpression(andExpression);
        if (result == null) result = caseStateConditionExpression(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = caseTriggerConditionExpression(orExpression);
        if (result == null) result = caseStateConditionExpression(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EM2 Annex Subclause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EM2 Annex Subclause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEM2AnnexSubclause(EM2AnnexSubclause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Type Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Type Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorTypeSet(ErrorTypeSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorType(ErrorType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeature(Feature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Type Refinement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Type Refinement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorTypeRefinement(ErrorTypeRefinement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Propagations</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Propagations</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorPropagations(ErrorPropagations object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Propagation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Propagation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorPropagation(ErrorPropagation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Flow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Flow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorFlow(ErrorFlow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Source</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Source</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorSource(ErrorSource object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Sink</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Sink</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorSink(ErrorSink object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Path</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Path</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorPath(ErrorPath object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Propagation Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Propagation Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorPropagationReference(ErrorPropagationReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Behavior State Machine</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Behavior State Machine</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorBehaviorStateMachine(ErrorBehaviorStateMachine object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Behavior Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Behavior Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorBehaviorEvent(ErrorBehaviorEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorEvent(ErrorEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Repair Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Repair Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRepairEvent(RepairEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Behavior State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Behavior State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorBehaviorState(ErrorBehaviorState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Behavior Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorBehaviorTransition(ErrorBehaviorTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Triggered Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Triggered Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTriggeredTransition(TriggeredTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Branch Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Branch Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBranchTransition(BranchTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Error Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Error Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentErrorBehavior(ComponentErrorBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionCondition(TransitionCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trigger Condition Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trigger Condition Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTriggerConditionExpression(TriggerConditionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ormore Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ormore Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrmoreExpression(OrmoreExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Orless Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Orless Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrlessExpression(OrlessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Others Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Others Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOthersExpression(OthersExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Event Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Event Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorEventReference(ErrorEventReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Working Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Working Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWorkingReference(WorkingReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Propagation Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Propagation Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropagationCondition(PropagationCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Detection Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Detection Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDetectionEvent(DetectionEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Composite Error Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Composite Error Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompositeErrorBehavior(CompositeErrorBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Composite State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Composite State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompositeState(CompositeState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Condition Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Condition Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateConditionExpression(StateConditionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subcomponent State Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subcomponent State Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubcomponentStateReference(SubcomponentStateReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyAssociation(PropertyAssociation object)
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
   * Returns the result of interpreting the object as an instance of '<em>Probability Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Probability Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProbabilityValue(ProbabilityValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpression(OrExpression object)
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

} //ErrorModelSwitch
