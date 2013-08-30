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
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.annex.behavior.declarative ;

import fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.Target ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable ;

import org.eclipse.emf.common.util.EList ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.Reference#getIds <em>Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends ActualPortHolder,
                          DeclarativeBehaviorElement, IntegerValueVariable,
                          ValueVariable, ElementValues, Target,
                          DispatchTriggerCondition, DispatchTrigger
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' containment reference list.
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getReference_Ids()
   * @model containment="true" required="true"
   * @generated
   */
  EList<ArrayableIdentifier> getIds() ;

} // Reference
