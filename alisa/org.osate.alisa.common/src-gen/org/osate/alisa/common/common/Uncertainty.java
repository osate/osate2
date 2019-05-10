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
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getVolatility <em>Volatility</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getPrecedence <em>Precedence</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.Uncertainty#getImpact <em>Impact</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getUncertainty()
 * @model
 * @generated
 */
public interface Uncertainty extends EObject
{
  /**
   * Returns the value of the '<em><b>Volatility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Volatility</em>' attribute.
   * @see #setVolatility(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Volatility()
   * @model
   * @generated
   */
  int getVolatility();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getVolatility <em>Volatility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Volatility</em>' attribute.
   * @see #getVolatility()
   * @generated
   */
  void setVolatility(int value);

  /**
   * Returns the value of the '<em><b>Precedence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precedence</em>' attribute.
   * @see #setPrecedence(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Precedence()
   * @model
   * @generated
   */
  int getPrecedence();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getPrecedence <em>Precedence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precedence</em>' attribute.
   * @see #getPrecedence()
   * @generated
   */
  void setPrecedence(int value);

  /**
   * Returns the value of the '<em><b>Impact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Impact</em>' attribute.
   * @see #setImpact(int)
   * @see org.osate.alisa.common.common.CommonPackage#getUncertainty_Impact()
   * @model
   * @generated
   */
  int getImpact();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.Uncertainty#getImpact <em>Impact</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Impact</em>' attribute.
   * @see #getImpact()
   * @generated
   */
  void setImpact(int value);

} // Uncertainty
