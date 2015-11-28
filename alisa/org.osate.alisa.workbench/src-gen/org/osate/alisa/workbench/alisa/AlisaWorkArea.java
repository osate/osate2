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

import org.osate.categories.categories.CategoryFilter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Work Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getPlan <em>Plan</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAlisaWorkArea()
 * @model
 * @generated
 */
public interface AlisaWorkArea extends EObject
{
  /**
   * Returns the value of the '<em><b>Plan</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plan</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plan</em>' containment reference.
   * @see #setPlan(AssurancePlan)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAlisaWorkArea_Plan()
   * @model containment="true"
   * @generated
   */
  AssurancePlan getPlan();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getPlan <em>Plan</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Plan</em>' containment reference.
   * @see #getPlan()
   * @generated
   */
  void setPlan(AssurancePlan value);

  /**
   * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.categories.categories.CategoryFilter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tasks</em>' containment reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAlisaWorkArea_Tasks()
   * @model containment="true"
   * @generated
   */
  EList<CategoryFilter> getTasks();

} // AlisaWorkArea
