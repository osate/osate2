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

import org.osate.aadl2.PropertySet;
import org.osate.ba.utils.visitor.IBAVisitable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Set Property Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.PropertySetPropertyReference#getPropertySet <em>Property Set</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getPropertySetPropertyReference()
 * @model
 * @generated
 */
public interface PropertySetPropertyReference extends PropertyReference
{
  /**
   * Returns the value of the '<em><b>Property Set</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Set</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Set</em>' reference.
   * @see #setPropertySet(PropertySet)
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertySetPropertyReference_PropertySet()
   * @model
   * @generated
   */
  PropertySet getPropertySet();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.PropertySetPropertyReference#getPropertySet <em>Property Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Set</em>' reference.
   * @see #getPropertySet()
   * @generated
   */
  void setPropertySet(PropertySet value);

} // PropertySetPropertyReference
