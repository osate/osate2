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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uncertainty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getImportance <em>Importance</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getDifficulty <em>Difficulty</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getUncertainty()
 * @model
 * @generated
 */
public interface Uncertainty extends EObject
{
  /**
   * Returns the value of the '<em><b>Importance</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Importance</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Importance</em>' attribute.
   * @see #setImportance(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Importance()
   * @model
   * @generated
   */
  int getImportance();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getImportance <em>Importance</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Importance</em>' attribute.
   * @see #getImportance()
   * @generated
   */
  void setImportance(int value);

  /**
   * Returns the value of the '<em><b>Difficulty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Difficulty</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Difficulty</em>' attribute.
   * @see #setDifficulty(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Difficulty()
   * @model
   * @generated
   */
  int getDifficulty();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getDifficulty <em>Difficulty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Difficulty</em>' attribute.
   * @see #getDifficulty()
   * @generated
   */
  void setDifficulty(int value);

} // Uncertainty
