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
package org.osate.reqspec.reqSpec.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.ValDeclaration;

import org.osate.reqspec.reqSpec.*;

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
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage
 * @generated
 */
public class ReqSpecSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReqSpecPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ReqSpecPackage.eINSTANCE;
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
      case ReqSpecPackage.REQ_SPEC:
      {
        ReqSpec reqSpec = (ReqSpec)theEObject;
        T result = caseReqSpec(reqSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.GLOBAL_CONSTANTS:
      {
        GlobalConstants globalConstants = (GlobalConstants)theEObject;
        T result = caseGlobalConstants(globalConstants);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.CONTRACTUAL_ELEMENT:
      {
        ContractualElement contractualElement = (ContractualElement)theEObject;
        T result = caseContractualElement(contractualElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_ROOT:
      {
        ReqRoot reqRoot = (ReqRoot)theEObject;
        T result = caseReqRoot(reqRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.STAKEHOLDER_GOALS:
      {
        StakeholderGoals stakeholderGoals = (StakeholderGoals)theEObject;
        T result = caseStakeholderGoals(stakeholderGoals);
        if (result == null) result = caseReqRoot(stakeholderGoals);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_DOCUMENT:
      {
        ReqDocument reqDocument = (ReqDocument)theEObject;
        T result = caseReqDocument(reqDocument);
        if (result == null) result = caseReqRoot(reqDocument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.DOCUMENT_SECTION:
      {
        DocumentSection documentSection = (DocumentSection)theEObject;
        T result = caseDocumentSection(documentSection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQUIREMENT_SET:
      {
        RequirementSet requirementSet = (RequirementSet)theEObject;
        T result = caseRequirementSet(requirementSet);
        if (result == null) result = caseReqRoot(requirementSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.GOAL:
      {
        Goal goal = (Goal)theEObject;
        T result = caseGoal(goal);
        if (result == null) result = caseContractualElement(goal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQUIREMENT:
      {
        Requirement requirement = (Requirement)theEObject;
        T result = caseRequirement(requirement);
        if (result == null) result = caseContractualElement(requirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT:
      {
        IncludeGlobalRequirement includeGlobalRequirement = (IncludeGlobalRequirement)theEObject;
        T result = caseIncludeGlobalRequirement(includeGlobalRequirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.WHEN_CONDITION:
      {
        WhenCondition whenCondition = (WhenCondition)theEObject;
        T result = caseWhenCondition(whenCondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_PREDICATE:
      {
        ReqPredicate reqPredicate = (ReqPredicate)theEObject;
        T result = caseReqPredicate(reqPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.INFORMAL_PREDICATE:
      {
        InformalPredicate informalPredicate = (InformalPredicate)theEObject;
        T result = caseInformalPredicate(informalPredicate);
        if (result == null) result = caseReqPredicate(informalPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.VALUE_PREDICATE:
      {
        ValuePredicate valuePredicate = (ValuePredicate)theEObject;
        T result = caseValuePredicate(valuePredicate);
        if (result == null) result = caseReqPredicate(valuePredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.DESIRED_VALUE:
      {
        DesiredValue desiredValue = (DesiredValue)theEObject;
        T result = caseDesiredValue(desiredValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.EXTERNAL_DOCUMENT:
      {
        ExternalDocument externalDocument = (ExternalDocument)theEObject;
        T result = caseExternalDocument(externalDocument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET:
      {
        SystemRequirementSet systemRequirementSet = (SystemRequirementSet)theEObject;
        T result = caseSystemRequirementSet(systemRequirementSet);
        if (result == null) result = caseRequirementSet(systemRequirementSet);
        if (result == null) result = caseReqRoot(systemRequirementSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.GLOBAL_REQUIREMENT_SET:
      {
        GlobalRequirementSet globalRequirementSet = (GlobalRequirementSet)theEObject;
        T result = caseGlobalRequirementSet(globalRequirementSet);
        if (result == null) result = caseRequirementSet(globalRequirementSet);
        if (result == null) result = caseReqRoot(globalRequirementSet);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_VAL_DECLARATION:
      {
        ReqValDeclaration reqValDeclaration = (ReqValDeclaration)theEObject;
        T result = caseReqValDeclaration(reqValDeclaration);
        if (result == null) result = caseValDeclaration(reqValDeclaration);
        if (result == null) result = caseAVariableDeclaration(reqValDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqSpec(ReqSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Global Constants</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Global Constants</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGlobalConstants(GlobalConstants object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contractual Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contractual Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractualElement(ContractualElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqRoot(ReqRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stakeholder Goals</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stakeholder Goals</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStakeholderGoals(StakeholderGoals object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Document</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Document</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqDocument(ReqDocument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Document Section</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document Section</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocumentSection(DocumentSection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requirement Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirementSet(RequirementSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGoal(Goal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirement(Requirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include Global Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include Global Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIncludeGlobalRequirement(IncludeGlobalRequirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>When Condition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>When Condition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhenCondition(WhenCondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqPredicate(ReqPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Informal Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Informal Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInformalPredicate(InformalPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValuePredicate(ValuePredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Desired Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Desired Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDesiredValue(DesiredValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Document</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Document</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalDocument(ExternalDocument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>System Requirement Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>System Requirement Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSystemRequirementSet(SystemRequirementSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Global Requirement Set</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Global Requirement Set</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGlobalRequirementSet(GlobalRequirementSet object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Val Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Val Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqValDeclaration(ReqValDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>AVariable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AVariable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAVariableDeclaration(AVariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Val Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Val Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValDeclaration(ValDeclaration object)
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

} //ReqSpecSwitch
