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
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

import org.osate.alisa.common.common.Description;

import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#getAssure <em>Assure</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#getAssureSubsystems <em>Assure Subsystems</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#isAssureAll <em>Assure All</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#getAssumeSubsystems <em>Assume Subsystems</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#isAssumeAll <em>Assume All</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.ModelPlan#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan()
 * @model
 * @generated
 */
public interface ModelPlan extends EObject
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(ComponentImplementation)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_Target()
   * @model
   * @generated
   */
  ComponentImplementation getTarget();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.ModelPlan#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ComponentImplementation value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.ModelPlan#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Assure</b></em>' reference list.
   * The list contents are of type {@link org.osate.verify.verify.VerificationPlan}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assure</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assure</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_Assure()
   * @model
   * @generated
   */
  EList<VerificationPlan> getAssure();

  /**
   * Returns the value of the '<em><b>Assure Subsystems</b></em>' reference list.
   * The list contents are of type {@link org.osate.aadl2.Subcomponent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assure Subsystems</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assure Subsystems</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_AssureSubsystems()
   * @model
   * @generated
   */
  EList<Subcomponent> getAssureSubsystems();

  /**
   * Returns the value of the '<em><b>Assure All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assure All</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assure All</em>' attribute.
   * @see #setAssureAll(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_AssureAll()
   * @model
   * @generated
   */
  boolean isAssureAll();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.ModelPlan#isAssureAll <em>Assure All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assure All</em>' attribute.
   * @see #isAssureAll()
   * @generated
   */
  void setAssureAll(boolean value);

  /**
   * Returns the value of the '<em><b>Assume Subsystems</b></em>' reference list.
   * The list contents are of type {@link org.osate.aadl2.Subcomponent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assume Subsystems</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assume Subsystems</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_AssumeSubsystems()
   * @model
   * @generated
   */
  EList<Subcomponent> getAssumeSubsystems();

  /**
   * Returns the value of the '<em><b>Assume All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assume All</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assume All</em>' attribute.
   * @see #setAssumeAll(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_AssumeAll()
   * @model
   * @generated
   */
  boolean isAssumeAll();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.ModelPlan#isAssumeAll <em>Assume All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assume All</em>' attribute.
   * @see #isAssumeAll()
   * @generated
   */
  void setAssumeAll(boolean value);

  /**
   * Returns the value of the '<em><b>Issues</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issues</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' attribute list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getModelPlan_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

} // ModelPlan
