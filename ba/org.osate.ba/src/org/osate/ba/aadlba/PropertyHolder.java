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

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.PropertyHolder#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.PropertyHolder#getFields <em>Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyHolder()
 * @model
 * @generated
 */
public interface PropertyHolder extends BehaviorElement
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
   * @see #setProperty(Property)
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyHolder_Property()
   * @model required="true"
   * @generated
   */
  Property getProperty();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.PropertyHolder#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(Property value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.PropertyField}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see #isSetFields()
   * @see #unsetFields()
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyHolder_Fields()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<PropertyField> getFields();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.PropertyHolder#getFields <em>Fields</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFields()
   * @see #getFields()
   * @generated
   */
  void unsetFields();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.PropertyHolder#getFields <em>Fields</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Fields</em>' containment reference list is set.
   * @see #unsetFields()
   * @see #getFields()
   * @generated
   */
  boolean isSetFields();

} // PropertyHolder
