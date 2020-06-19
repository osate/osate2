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
 * A representation of the model object '<em><b>Property Name Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.PropertyNameHolder#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.PropertyNameHolder#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyNameHolder()
 * @model
 * @generated
 */
public interface PropertyNameHolder extends BehaviorElement
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference.
   * @see #setProperty(PropertyElementHolder)
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyNameHolder_Property()
   * @model containment="true" required="true"
   * @generated
   */
  PropertyElementHolder getProperty();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.PropertyNameHolder#getProperty <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' containment reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(PropertyElementHolder value);

  /**
   * Returns the value of the '<em><b>Field</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' containment reference.
   * @see #isSetField()
   * @see #unsetField()
   * @see #setField(PropertyNameField)
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyNameHolder_Field()
   * @model containment="true" unsettable="true"
   * @generated
   */
  PropertyNameField getField();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.PropertyNameHolder#getField <em>Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' containment reference.
   * @see #isSetField()
   * @see #unsetField()
   * @see #getField()
   * @generated
   */
  void setField(PropertyNameField value);

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.PropertyNameHolder#getField <em>Field</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetField()
   * @see #getField()
   * @see #setField(PropertyNameField)
   * @generated
   */
  void unsetField();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.PropertyNameHolder#getField <em>Field</em>}' containment reference is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Field</em>' containment reference is set.
   * @see #unsetField()
   * @see #getField()
   * @see #setField(PropertyNameField)
   * @generated
   */
  boolean isSetField();

} // PropertyNameHolder
