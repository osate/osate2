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

import org.osate.aadl2.EnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.PropertyEnumLiteral#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyEnumLiteral()
 * @model
 * @generated
 */
public interface PropertyEnumLiteral extends PropertyField
{
  /**
   * Returns the value of the '<em><b>Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' reference.
   * @see #setLiteral(EnumerationLiteral)
   * @see org.osate.ba.aadlba.AadlBaPackage#getPropertyEnumLiteral_Literal()
   * @model required="true"
   * @generated
   */
  EnumerationLiteral getLiteral();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.PropertyEnumLiteral#getLiteral <em>Literal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(EnumerationLiteral value);

} // PropertyEnumLiteral
