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
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ARange</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ARange#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ARange#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ARange#getDelta <em>Delta</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getARange()
 * @model
 * @generated
 */
public interface ARange extends EObject, PropertyExpression
{
  /**
   * Returns the value of the '<em><b>Minimum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Minimum</em>' containment reference.
   * @see #setMinimum(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getARange_Minimum()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getMinimum();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ARange#getMinimum <em>Minimum</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Minimum</em>' containment reference.
   * @see #getMinimum()
   * @generated
   */
  void setMinimum(PropertyExpression value);

  /**
   * Returns the value of the '<em><b>Maximum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maximum</em>' containment reference.
   * @see #setMaximum(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getARange_Maximum()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getMaximum();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ARange#getMaximum <em>Maximum</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Maximum</em>' containment reference.
   * @see #getMaximum()
   * @generated
   */
  void setMaximum(PropertyExpression value);

  /**
   * Returns the value of the '<em><b>Delta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delta</em>' containment reference.
   * @see #setDelta(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getARange_Delta()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getDelta();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ARange#getDelta <em>Delta</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delta</em>' containment reference.
   * @see #getDelta()
   * @generated
   */
  void setDelta(PropertyExpression value);

} // ARange
