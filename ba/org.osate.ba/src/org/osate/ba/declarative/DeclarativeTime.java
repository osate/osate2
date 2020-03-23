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

import org.osate.ba.aadlba.BehaviorTime ;
import org.osate.ba.aadlba.CompletionRelativeTimeout ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.DeclarativeTime#getUnitId <em>Unit Id</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeTime()
 * @model
 * @generated
 */
public interface DeclarativeTime extends BehaviorTime,
                                 CompletionRelativeTimeout,
                                 DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Unit Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit Id</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit Id</em>' containment reference.
   * @see #setUnitId(Identifier)
   * @see org.osate.ba.declarative.DeclarativePackage#getDeclarativeTime_UnitId()
   * @model containment="true" required="true"
   * @generated
   */
  Identifier getUnitId() ;

  /**
   * Sets the value of the '{@link org.osate.ba.declarative.DeclarativeTime#getUnitId <em>Unit Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit Id</em>' containment reference.
   * @see #getUnitId()
   * @generated
   */
  void setUnitId(Identifier value) ;

} // DeclarativeTime
