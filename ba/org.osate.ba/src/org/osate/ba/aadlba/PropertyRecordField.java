/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package org.osate.ba.aadlba;

import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Record Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.PropertyRecordField#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.PropertyRecordField#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyRecordField()
 * @model
 * @generated
 */
public interface PropertyRecordField extends PropertyField
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(BasicProperty)
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyRecordField_Property()
   * @model required="true"
   * @generated
   */
  BasicProperty getProperty();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.PropertyRecordField#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(BasicProperty value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(PropertyExpression)
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyRecordField_Value()
   * @model
   * @generated
   */
  PropertyExpression getValue();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.PropertyRecordField#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(PropertyExpression value);

} // PropertyRecordField
