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
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.PropertyExpression;

import org.osate.alisa.common.common.AExpression;

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
   * Returns the value of the '<em><b>Desired</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Desired</em>' containment reference.
   * @see #setDesired(AExpression)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getDesiredValue_Desired()
   * @model containment="true"
   * @generated
   */
  AExpression getDesired();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.DesiredValue#getDesired <em>Desired</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Desired</em>' containment reference.
   * @see #getDesired()
   * @generated
   */
  void setDesired(AExpression value);

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
