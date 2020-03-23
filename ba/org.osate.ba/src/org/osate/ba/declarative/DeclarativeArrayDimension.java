/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.declarative ;

import org.osate.aadl2.ArrayDimension ;
import org.osate.ba.aadlba.IntegerValueConstant ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativeArrayDimension#getDimension <em>Dimension</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeArrayDimension()
 * @model
 * @generated
 */
public interface DeclarativeArrayDimension extends ArrayDimension,
                                           DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Dimension</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dimension</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dimension</em>' containment reference.
   * @see #setDimension(IntegerValueConstant)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeArrayDimension_Dimension()
   * @model containment="true" required="true"
   * @generated
   */
  IntegerValueConstant getDimension() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativeArrayDimension#getDimension <em>Dimension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dimension</em>' containment reference.
   * @see #getDimension()
   * @generated
   */
  void setDimension(IntegerValueConstant value) ;

} // DeclarativeArrayDimension
