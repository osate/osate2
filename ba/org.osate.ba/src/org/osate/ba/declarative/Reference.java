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
import org.osate.aadl2.ContainmentPathElement ;
import org.osate.ba.aadlba.ActualPortHolder ;
import org.osate.ba.aadlba.DispatchTrigger ;
import org.osate.ba.aadlba.DispatchTriggerCondition ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.IntegerValueVariable ;
import org.osate.ba.aadlba.ModeSwitchTrigger ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.ValueVariable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.declarative.Reference#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.declarative.DeclarativePackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends ActualPortHolder, DeclarativeBehaviorElement,
                           IntegerValueVariable, ValueVariable, ElementValues,
                           Target, DispatchTriggerCondition, DispatchTrigger,
                           ModeSwitchTrigger, ContainmentPathElement
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.declarative.ArrayableIdentifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' containment reference list.
   * @see org.osate.ba.declarative.DeclarativePackage#getReference_Ids()
   * @model containment="true" required="true"
   * @generated
   */
  EList<ArrayableIdentifier> getIds() ;

} // Reference
