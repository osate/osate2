/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage
 * @generated
 */
public interface ReqSpecFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReqSpecFactory eINSTANCE = org.osate.reqspec.reqSpec.impl.ReqSpecFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Req Spec</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Req Spec</em>'.
   * @generated
   */
  ReqSpec createReqSpec();

  /**
   * Returns a new object of class '<em>Global Constants</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Global Constants</em>'.
   * @generated
   */
  GlobalConstants createGlobalConstants();

  /**
   * Returns a new object of class '<em>Contractual Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Contractual Element</em>'.
   * @generated
   */
  ContractualElement createContractualElement();

  /**
   * Returns a new object of class '<em>Req Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Req Root</em>'.
   * @generated
   */
  ReqRoot createReqRoot();

  /**
   * Returns a new object of class '<em>Stakeholder Goals</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stakeholder Goals</em>'.
   * @generated
   */
  StakeholderGoals createStakeholderGoals();

  /**
   * Returns a new object of class '<em>Req Document</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Req Document</em>'.
   * @generated
   */
  ReqDocument createReqDocument();

  /**
   * Returns a new object of class '<em>Document Section</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document Section</em>'.
   * @generated
   */
  DocumentSection createDocumentSection();

  /**
   * Returns a new object of class '<em>Requirement Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement Set</em>'.
   * @generated
   */
  RequirementSet createRequirementSet();

  /**
   * Returns a new object of class '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goal</em>'.
   * @generated
   */
  Goal createGoal();

  /**
   * Returns a new object of class '<em>Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement</em>'.
   * @generated
   */
  Requirement createRequirement();

  /**
   * Returns a new object of class '<em>Include Global Requirement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include Global Requirement</em>'.
   * @generated
   */
  IncludeGlobalRequirement createIncludeGlobalRequirement();

  /**
   * Returns a new object of class '<em>When Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>When Condition</em>'.
   * @generated
   */
  WhenCondition createWhenCondition();

  /**
   * Returns a new object of class '<em>Req Predicate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Req Predicate</em>'.
   * @generated
   */
  ReqPredicate createReqPredicate();

  /**
   * Returns a new object of class '<em>Informal Predicate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Informal Predicate</em>'.
   * @generated
   */
  InformalPredicate createInformalPredicate();

  /**
   * Returns a new object of class '<em>Value Predicate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Predicate</em>'.
   * @generated
   */
  ValuePredicate createValuePredicate();

  /**
   * Returns a new object of class '<em>Desired Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Desired Value</em>'.
   * @generated
   */
  DesiredValue createDesiredValue();

  /**
   * Returns a new object of class '<em>External Document</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Document</em>'.
   * @generated
   */
  ExternalDocument createExternalDocument();

  /**
   * Returns a new object of class '<em>System Requirement Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>System Requirement Set</em>'.
   * @generated
   */
  SystemRequirementSet createSystemRequirementSet();

  /**
   * Returns a new object of class '<em>Global Requirement Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Global Requirement Set</em>'.
   * @generated
   */
  GlobalRequirementSet createGlobalRequirementSet();

  /**
   * Returns a new object of class '<em>Req Val Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Req Val Declaration</em>'.
   * @generated
   */
  ReqValDeclaration createReqValDeclaration();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ReqSpecPackage getReqSpecPackage();

} //ReqSpecFactory
