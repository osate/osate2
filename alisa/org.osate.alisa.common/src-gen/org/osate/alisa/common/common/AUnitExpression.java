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
import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AUnit Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.AUnitExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.AUnitExpression#isConvert <em>Convert</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.AUnitExpression#isDrop <em>Drop</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.AUnitExpression#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getAUnitExpression()
 * @model
 * @generated
 */
public interface AUnitExpression extends EObject, PropertyExpression
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getAUnitExpression_Expression()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getExpression();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AUnitExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(PropertyExpression value);

  /**
   * Returns the value of the '<em><b>Convert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Convert</em>' attribute.
   * @see #setConvert(boolean)
   * @see org.osate.alisa.common.common.CommonPackage#getAUnitExpression_Convert()
   * @model
   * @generated
   */
  boolean isConvert();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AUnitExpression#isConvert <em>Convert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Convert</em>' attribute.
   * @see #isConvert()
   * @generated
   */
  void setConvert(boolean value);

  /**
   * Returns the value of the '<em><b>Drop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Drop</em>' attribute.
   * @see #setDrop(boolean)
   * @see org.osate.alisa.common.common.CommonPackage#getAUnitExpression_Drop()
   * @model
   * @generated
   */
  boolean isDrop();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AUnitExpression#isDrop <em>Drop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Drop</em>' attribute.
   * @see #isDrop()
   * @generated
   */
  void setDrop(boolean value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitLiteral)
   * @see org.osate.alisa.common.common.CommonPackage#getAUnitExpression_Unit()
   * @model
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AUnitExpression#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // AUnitExpression
