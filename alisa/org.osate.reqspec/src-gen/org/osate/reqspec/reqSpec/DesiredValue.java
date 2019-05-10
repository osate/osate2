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

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.PropertyExpression;

import org.osate.alisa.common.common.AVariableReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Desired Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.DesiredValue#getDesired <em>Desired</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.DesiredValue#isUpto <em>Upto</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.DesiredValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getDesiredValue()
 * @model
 * @generated
 */
public interface DesiredValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Desired</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Desired</em>' reference.
   * @see #setDesired(AVariableReference)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getDesiredValue_Desired()
   * @model
   * @generated
   */
  AVariableReference getDesired();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.DesiredValue#getDesired <em>Desired</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Desired</em>' reference.
   * @see #getDesired()
   * @generated
   */
  void setDesired(AVariableReference value);

  /**
   * Returns the value of the '<em><b>Upto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upto</em>' attribute.
   * @see #setUpto(boolean)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getDesiredValue_Upto()
   * @model
   * @generated
   */
  boolean isUpto();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.DesiredValue#isUpto <em>Upto</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upto</em>' attribute.
   * @see #isUpto()
   * @generated
   */
  void setUpto(boolean value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(PropertyExpression)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getDesiredValue_Value()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getValue();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.DesiredValue#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(PropertyExpression value);

} // DesiredValue
