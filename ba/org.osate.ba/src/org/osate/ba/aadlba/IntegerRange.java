/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba;

import org.osate.ba.utils.visitor.IBAVisitable ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.IntegerRange#getLowerIntegerValue <em>Lower Integer Value</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.IntegerRange#getUpperIntegerValue <em>Upper Integer Value</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getIntegerRange()
 * @model
 * @generated
 */
public interface IntegerRange extends ElementValues
{
  /**
   * Returns the value of the '<em><b>Lower Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Integer Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Integer Value</em>' containment reference.
   * @see #setLowerIntegerValue(IntegerValue)
   * @see org.osate.ba.aadlba.AadlBaPackage#getIntegerRange_LowerIntegerValue()
   * @model containment="true" required="true"
   * @generated
   */
  IntegerValue getLowerIntegerValue();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.IntegerRange#getLowerIntegerValue <em>Lower Integer Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Integer Value</em>' containment reference.
   * @see #getLowerIntegerValue()
   * @generated
   */
  void setLowerIntegerValue(IntegerValue value);

  /**
   * Returns the value of the '<em><b>Upper Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Integer Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Integer Value</em>' containment reference.
   * @see #setUpperIntegerValue(IntegerValue)
   * @see org.osate.ba.aadlba.AadlBaPackage#getIntegerRange_UpperIntegerValue()
   * @model containment="true" required="true"
   * @generated
   */
  IntegerValue getUpperIntegerValue();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.IntegerRange#getUpperIntegerValue <em>Upper Integer Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Integer Value</em>' containment reference.
   * @see #getUpperIntegerValue()
   * @generated
   */
  void setUpperIntegerValue(IntegerValue value);

} // IntegerRange
