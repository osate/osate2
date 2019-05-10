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

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;

import org.osate.alisa.common.common.ValDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder Goals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getImportConstants <em>Import Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.StakeholderGoals#getGoals <em>Goals</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals()
 * @model
 * @generated
 */
public interface StakeholderGoals extends ReqRoot
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(ComponentClassifier)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Target()
   * @model
   * @generated
   */
  ComponentClassifier getTarget();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ComponentClassifier value);

  /**
   * Returns the value of the '<em><b>Component Category</b></em>' attribute list.
   * The list contents are of type {@link org.osate.aadl2.ComponentCategory}.
   * The literals are from the enumeration {@link org.osate.aadl2.ComponentCategory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Category</em>' attribute list.
   * @see org.osate.aadl2.ComponentCategory
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_ComponentCategory()
   * @model unique="false"
   * @generated
   */
  EList<ComponentCategory> getComponentCategory();

  /**
   * Returns the value of the '<em><b>Import Constants</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.GlobalConstants}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Constants</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_ImportConstants()
   * @model
   * @generated
   */
  EList<GlobalConstants> getImportConstants();

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.ValDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Constants()
   * @model containment="true"
   * @generated
   */
  EList<ValDeclaration> getConstants();

  /**
   * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Goal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Goals</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getStakeholderGoals_Goals()
   * @model containment="true"
   * @generated
   */
  EList<Goal> getGoals();

} // StakeholderGoals
