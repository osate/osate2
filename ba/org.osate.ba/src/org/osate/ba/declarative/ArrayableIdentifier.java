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

import org.eclipse.emf.common.util.EList ;
import org.osate.ba.aadlba.IntegerValue ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrayable Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.ArrayableIdentifier#getArrayIndexes <em>Array Indexes</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getArrayableIdentifier()
 * @model
 * @generated
 */
public interface ArrayableIdentifier extends Identifier
{
  /**
   * Returns the value of the '<em><b>Array Indexes</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.IntegerValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Indexes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Indexes</em>' containment reference list.
   * @see #isSetArrayIndexes()
   * @see #unsetArrayIndexes()
   * @see org.osate.ba.declarative.DeclarativePackage#getArrayableIdentifier_ArrayIndexes()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<IntegerValue> getArrayIndexes() ;

  /**
   * Unsets the value of the '{@link org.osate.ba.declarative.ArrayableIdentifier#getArrayIndexes <em>Array Indexes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetArrayIndexes()
   * @see #getArrayIndexes()
   * @generated
   */
  void unsetArrayIndexes() ;

  /**
   * Returns whether the value of the '{@link org.osate.ba.declarative.ArrayableIdentifier#getArrayIndexes <em>Array Indexes</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Array Indexes</em>' containment reference list is set.
   * @see #unsetArrayIndexes()
   * @see #getArrayIndexes()
   * @generated
   */
  boolean isSetArrayIndexes() ;

} // ArrayableIdentifier
