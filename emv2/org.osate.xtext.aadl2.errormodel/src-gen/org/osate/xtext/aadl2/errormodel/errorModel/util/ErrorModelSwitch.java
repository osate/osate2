/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.xtext.aadl2.errormodel.errorModel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

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
public class ErrorModelSwitch<T> extends Switch<T>
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
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE:
      {
        ErrorModelSubclause errorModelSubclause = (ErrorModelSubclause)theEObject;
        T result = caseErrorModelSubclause(errorModelSubclause);
        if (result == null) result = caseAnnexSubclause(errorModelSubclause);
        if (result == null) result = caseModalElement(errorModelSubclause);
        if (result == null) result = caseNamedElement(errorModelSubclause);
        if (result == null) result = caseElement(errorModelSubclause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_MODEL_LIBRARY:
      {
        ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)theEObject;
        T result = caseErrorModelLibrary(errorModelLibrary);
        if (result == null) result = caseAnnexLibrary(errorModelLibrary);
        if (result == null) result = caseNamedElement(errorModelLibrary);
        if (result == null) result = caseElement(errorModelLibrary);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION:
      {
        EMV2PropertyAssociation emv2PropertyAssociation = (EMV2PropertyAssociation)theEObject;
        T result = caseEMV2PropertyAssociation(emv2PropertyAssociation);
        if (result == null) result = caseElement(emv2PropertyAssociation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.EMV2_PATH:
      {
        EMV2Path emv2Path = (EMV2Path)theEObject;
        T result = caseEMV2Path(emv2Path);
        if (result == null) result = caseElement(emv2Path);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.EMV2_PATH_ELEMENT:
      {
        EMV2PathElement emv2PathElement = (EMV2PathElement)theEObject;
        T result = caseEMV2PathElement(emv2PathElement);
        if (result == null) result = caseElement(emv2PathElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_TYPES:
      {
        ErrorTypes errorTypes = (ErrorTypes)theEObject;
        T result = caseErrorTypes(errorTypes);
        if (result == null) result = caseNamedElement(errorTypes);
        if (result == null) result = caseElement(errorTypes);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_TYPE:
      {
        ErrorType errorType = (ErrorType)theEObject;
        T result = caseErrorType(errorType);
        if (result == null) result = caseErrorTypes(errorType);
        if (result == null) result = caseNamedElement(errorType);
        if (result == null) result = caseElement(errorType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TYPE_SET:
      {
        TypeSet typeSet = (TypeSet)theEObject;
        T result = caseTypeSet(typeSet);
        if (result == null) result = caseErrorTypes(typeSet);
        if (result == null) result = caseNamedElement(typeSet);
        if (result == null) result = caseElement(typeSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TYPE_TOKEN:
      {
        TypeToken typeToken = (TypeToken)theEObject;
        T result = caseTypeToken(typeToken);
        if (result == null) result = caseElement(typeToken);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET:
      {
        TypeTransformationSet typeTransformationSet = (TypeTransformationSet)theEObject;
        T result = caseTypeTransformationSet(typeTransformationSet);
        if (result == null) result = caseNamedElement(typeTransformationSet);
        if (result == null) result = caseElement(typeTransformationSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TYPE_TRANSFORMATION:
      {
        TypeTransformation typeTransformation = (TypeTransformation)theEObject;
        T result = caseTypeTransformation(typeTransformation);
        if (result == null) result = caseElement(typeTransformation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TYPE_MAPPING_SET:
      {
        TypeMappingSet typeMappingSet = (TypeMappingSet)theEObject;
        T result = caseTypeMappingSet(typeMappingSet);
        if (result == null) result = caseNamedElement(typeMappingSet);
        if (result == null) result = caseElement(typeMappingSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TYPE_MAPPING:
      {
        TypeMapping typeMapping = (TypeMapping)theEObject;
        T result = caseTypeMapping(typeMapping);
        if (result == null) result = caseElement(typeMapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_PROPAGATION:
      {
        ErrorPropagation errorPropagation = (ErrorPropagation)theEObject;
        T result = caseErrorPropagation(errorPropagation);
        if (result == null) result = caseEventOrPropagation(errorPropagation);
        if (result == null) result = caseNamedElement(errorPropagation);
        if (result == null) result = caseElement(errorPropagation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.FEATUREOR_PP_REFERENCE:
      {
        FeatureorPPReference featureorPPReference = (FeatureorPPReference)theEObject;
        T result = caseFeatureorPPReference(featureorPPReference);
        if (result == null) result = caseElement(featureorPPReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_FLOW:
      {
        ErrorFlow errorFlow = (ErrorFlow)theEObject;
        T result = caseErrorFlow(errorFlow);
        if (result == null) result = caseNamedElement(errorFlow);
        if (result == null) result = caseElement(errorFlow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_SOURCE:
      {
        ErrorSource errorSource = (ErrorSource)theEObject;
        T result = caseErrorSource(errorSource);
        if (result == null) result = caseErrorFlow(errorSource);
        if (result == null) result = caseNamedElement(errorSource);
        if (result == null) result = caseElement(errorSource);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_SINK:
      {
        ErrorSink errorSink = (ErrorSink)theEObject;
        T result = caseErrorSink(errorSink);
        if (result == null) result = caseErrorFlow(errorSink);
        if (result == null) result = caseNamedElement(errorSink);
        if (result == null) result = caseElement(errorSink);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_PATH:
      {
        ErrorPath errorPath = (ErrorPath)theEObject;
        T result = caseErrorPath(errorPath);
        if (result == null) result = caseErrorFlow(errorPath);
        if (result == null) result = caseNamedElement(errorPath);
        if (result == null) result = caseElement(errorPath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.IF_CONDITION:
      {
        IfCondition ifCondition = (IfCondition)theEObject;
        T result = caseIfCondition(ifCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.PROPAGATION_POINT:
      {
        PropagationPoint propagationPoint = (PropagationPoint)theEObject;
        T result = casePropagationPoint(propagationPoint);
        if (result == null) result = caseNamedElement(propagationPoint);
        if (result == null) result = caseElement(propagationPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.PROPAGATION_PATH:
      {
        PropagationPath propagationPath = (PropagationPath)theEObject;
        T result = casePropagationPath(propagationPath);
        if (result == null) result = caseNamedElement(propagationPath);
        if (result == null) result = caseElement(propagationPath);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT:
      {
        QualifiedPropagationPoint qualifiedPropagationPoint = (QualifiedPropagationPoint)theEObject;
        T result = caseQualifiedPropagationPoint(qualifiedPropagationPoint);
        if (result == null) result = caseElement(qualifiedPropagationPoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE:
      {
        ErrorBehaviorStateMachine errorBehaviorStateMachine = (ErrorBehaviorStateMachine)theEObject;
        T result = caseErrorBehaviorStateMachine(errorBehaviorStateMachine);
        if (result == null) result = caseNamedElement(errorBehaviorStateMachine);
        if (result == null) result = caseElement(errorBehaviorStateMachine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_EVENT:
      {
        ErrorBehaviorEvent errorBehaviorEvent = (ErrorBehaviorEvent)theEObject;
        T result = caseErrorBehaviorEvent(errorBehaviorEvent);
        if (result == null) result = caseEventOrPropagation(errorBehaviorEvent);
        if (result == null) result = caseNamedElement(errorBehaviorEvent);
        if (result == null) result = caseElement(errorBehaviorEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_EVENT:
      {
        ErrorEvent errorEvent = (ErrorEvent)theEObject;
        T result = caseErrorEvent(errorEvent);
        if (result == null) result = caseErrorBehaviorEvent(errorEvent);
        if (result == null) result = caseEventOrPropagation(errorEvent);
        if (result == null) result = caseNamedElement(errorEvent);
        if (result == null) result = caseElement(errorEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.REPAIR_EVENT:
      {
        RepairEvent repairEvent = (RepairEvent)theEObject;
        T result = caseRepairEvent(repairEvent);
        if (result == null) result = caseErrorBehaviorEvent(repairEvent);
        if (result == null) result = caseEventOrPropagation(repairEvent);
        if (result == null) result = caseNamedElement(repairEvent);
        if (result == null) result = caseElement(repairEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.RECOVER_EVENT:
      {
        RecoverEvent recoverEvent = (RecoverEvent)theEObject;
        T result = caseRecoverEvent(recoverEvent);
        if (result == null) result = caseErrorBehaviorEvent(recoverEvent);
        if (result == null) result = caseEventOrPropagation(recoverEvent);
        if (result == null) result = caseNamedElement(recoverEvent);
        if (result == null) result = caseElement(recoverEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE:
      {
        ErrorBehaviorState errorBehaviorState = (ErrorBehaviorState)theEObject;
        T result = caseErrorBehaviorState(errorBehaviorState);
        if (result == null) result = caseNamedElement(errorBehaviorState);
        if (result == null) result = caseElement(errorBehaviorState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION:
      {
        ErrorBehaviorTransition errorBehaviorTransition = (ErrorBehaviorTransition)theEObject;
        T result = caseErrorBehaviorTransition(errorBehaviorTransition);
        if (result == null) result = caseNamedElement(errorBehaviorTransition);
        if (result == null) result = caseElement(errorBehaviorTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.TRANSITION_BRANCH:
      {
        TransitionBranch transitionBranch = (TransitionBranch)theEObject;
        T result = caseTransitionBranch(transitionBranch);
        if (result == null) result = caseElement(transitionBranch);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.BRANCH_VALUE:
      {
        BranchValue branchValue = (BranchValue)theEObject;
        T result = caseBranchValue(branchValue);
        if (result == null) result = caseElement(branchValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.CONDITION_EXPRESSION:
      {
        ConditionExpression conditionExpression = (ConditionExpression)theEObject;
        T result = caseConditionExpression(conditionExpression);
        if (result == null) result = caseElement(conditionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ORMORE_EXPRESSION:
      {
        OrmoreExpression ormoreExpression = (OrmoreExpression)theEObject;
        T result = caseOrmoreExpression(ormoreExpression);
        if (result == null) result = caseConditionExpression(ormoreExpression);
        if (result == null) result = caseElement(ormoreExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ORLESS_EXPRESSION:
      {
        OrlessExpression orlessExpression = (OrlessExpression)theEObject;
        T result = caseOrlessExpression(orlessExpression);
        if (result == null) result = caseConditionExpression(orlessExpression);
        if (result == null) result = caseElement(orlessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.CONDITION_ELEMENT:
      {
        ConditionElement conditionElement = (ConditionElement)theEObject;
        T result = caseConditionElement(conditionElement);
        if (result == null) result = caseConditionExpression(conditionElement);
        if (result == null) result = caseElement(conditionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.EVENT_OR_PROPAGATION:
      {
        EventOrPropagation eventOrPropagation = (EventOrPropagation)theEObject;
        T result = caseEventOrPropagation(eventOrPropagation);
        if (result == null) result = caseNamedElement(eventOrPropagation);
        if (result == null) result = caseElement(eventOrPropagation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION:
      {
        OutgoingPropagationCondition outgoingPropagationCondition = (OutgoingPropagationCondition)theEObject;
        T result = caseOutgoingPropagationCondition(outgoingPropagationCondition);
        if (result == null) result = caseNamedElement(outgoingPropagationCondition);
        if (result == null) result = caseElement(outgoingPropagationCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_DETECTION:
      {
        ErrorDetection errorDetection = (ErrorDetection)theEObject;
        T result = caseErrorDetection(errorDetection);
        if (result == null) result = caseNamedElement(errorDetection);
        if (result == null) result = caseElement(errorDetection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_CODE_VALUE:
      {
        ErrorCodeValue errorCodeValue = (ErrorCodeValue)theEObject;
        T result = caseErrorCodeValue(errorCodeValue);
        if (result == null) result = caseElement(errorCodeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING:
      {
        ErrorStateToModeMapping errorStateToModeMapping = (ErrorStateToModeMapping)theEObject;
        T result = caseErrorStateToModeMapping(errorStateToModeMapping);
        if (result == null) result = caseElement(errorStateToModeMapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.COMPOSITE_STATE:
      {
        CompositeState compositeState = (CompositeState)theEObject;
        T result = caseCompositeState(compositeState);
        if (result == null) result = caseNamedElement(compositeState);
        if (result == null) result = caseElement(compositeState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE:
      {
        QualifiedErrorBehaviorState qualifiedErrorBehaviorState = (QualifiedErrorBehaviorState)theEObject;
        T result = caseQualifiedErrorBehaviorState(qualifiedErrorBehaviorState);
        if (result == null) result = caseElement(qualifiedErrorBehaviorState);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.SUBCOMPONENT_ELEMENT:
      {
        SubcomponentElement subcomponentElement = (SubcomponentElement)theEObject;
        T result = caseSubcomponentElement(subcomponentElement);
        if (result == null) result = caseElement(subcomponentElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.EMV2_ROOT:
      {
        EMV2Root emv2Root = (EMV2Root)theEObject;
        T result = caseEMV2Root(emv2Root);
        if (result == null) result = caseNamedElement(emv2Root);
        if (result == null) result = caseElement(emv2Root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = caseConditionExpression(orExpression);
        if (result == null) result = caseElement(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = caseConditionExpression(andExpression);
        if (result == null) result = caseElement(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.ALL_EXPRESSION:
      {
        AllExpression allExpression = (AllExpression)theEObject;
        T result = caseAllExpression(allExpression);
        if (result == null) result = caseConditionExpression(allExpression);
        if (result == null) result = caseElement(allExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.QUALIFIED_ERROR_EVENT_OR_PROPAGATION:
      {
        QualifiedErrorEventOrPropagation qualifiedErrorEventOrPropagation = (QualifiedErrorEventOrPropagation)theEObject;
        T result = caseQualifiedErrorEventOrPropagation(qualifiedErrorEventOrPropagation);
        if (result == null) result = caseEMV2Path(qualifiedErrorEventOrPropagation);
        if (result == null) result = caseElement(qualifiedErrorEventOrPropagation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.QUALIFIED_ERROR_PROPAGATION:
      {
        QualifiedErrorPropagation qualifiedErrorPropagation = (QualifiedErrorPropagation)theEObject;
        T result = caseQualifiedErrorPropagation(qualifiedErrorPropagation);
        if (result == null) result = caseEMV2Path(qualifiedErrorPropagation);
        if (result == null) result = caseElement(qualifiedErrorPropagation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ErrorModelPackage.SCONDITION_ELEMENT:
      {
        SConditionElement sConditionElement = (SConditionElement)theEObject;
        T result = caseSConditionElement(sConditionElement);
        if (result == null) result = caseConditionElement(sConditionElement);
        if (result == null) result = caseConditionExpression(sConditionElement);
        if (result == null) result = caseElement(sConditionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subclause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subclause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorModelSubclause(ErrorModelSubclause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Library</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorModelLibrary(ErrorModelLibrary object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EMV2 Property Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EMV2 Property Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEMV2PropertyAssociation(EMV2PropertyAssociation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EMV2 Path</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EMV2 Path</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEMV2Path(EMV2Path object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EMV2 Path Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EMV2 Path Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEMV2PathElement(EMV2PathElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Types</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Types</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorTypes(ErrorTypes object)
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
   * Returns the result of interpreting the object as an instance of '<em>Type Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeSet(TypeSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Token</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Token</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeToken(TypeToken object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Transformation Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Transformation Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeTransformationSet(TypeTransformationSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Transformation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Transformation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeTransformation(TypeTransformation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Mapping Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Mapping Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeMappingSet(TypeMappingSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeMapping(TypeMapping object)
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
   * Returns the result of interpreting the object as an instance of '<em>Featureor PP Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Featureor PP Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureorPPReference(FeatureorPPReference object)
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
   * Returns the result of interpreting the object as an instance of '<em>If Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfCondition(IfCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Propagation Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Propagation Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropagationPoint(PropagationPoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Propagation Path</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Propagation Path</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropagationPath(PropagationPath object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Propagation Point</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Propagation Point</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedPropagationPoint(QualifiedPropagationPoint object)
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
   * Returns the result of interpreting the object as an instance of '<em>Recover Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Recover Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecoverEvent(RecoverEvent object)
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
   * Returns the result of interpreting the object as an instance of '<em>Transition Branch</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Branch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionBranch(TransitionBranch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Branch Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Branch Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBranchValue(BranchValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Condition Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Condition Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionExpression(ConditionExpression object)
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
   * Returns the result of interpreting the object as an instance of '<em>Condition Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Condition Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionElement(ConditionElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Or Propagation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Or Propagation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventOrPropagation(EventOrPropagation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Outgoing Propagation Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Outgoing Propagation Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutgoingPropagationCondition(OutgoingPropagationCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Detection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Detection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorDetection(ErrorDetection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error Code Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error Code Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorCodeValue(ErrorCodeValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Error State To Mode Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Error State To Mode Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseErrorStateToModeMapping(ErrorStateToModeMapping object)
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
   * Returns the result of interpreting the object as an instance of '<em>Qualified Error Behavior State</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Error Behavior State</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedErrorBehaviorState(QualifiedErrorBehaviorState object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subcomponent Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subcomponent Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubcomponentElement(SubcomponentElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EMV2 Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EMV2 Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEMV2Root(EMV2Root object)
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
   * Returns the result of interpreting the object as an instance of '<em>All Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>All Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAllExpression(AllExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Error Event Or Propagation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Error Event Or Propagation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedErrorEventOrPropagation(QualifiedErrorEventOrPropagation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Error Propagation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Error Propagation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedErrorPropagation(QualifiedErrorPropagation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SCondition Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SCondition Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSConditionElement(SConditionElement object)
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
   * Returns the result of interpreting the object as an instance of '<em>Annex Library</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Annex Library</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnnexLibrary(AnnexLibrary object)
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

} //ErrorModelSwitch
