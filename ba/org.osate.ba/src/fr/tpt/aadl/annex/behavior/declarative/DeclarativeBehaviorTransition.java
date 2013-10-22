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

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;

import org.eclipse.emf.common.util.EList ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorTransition#getSrcStates <em>Src States</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorTransition#getDestState <em>Dest State</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeBehaviorTransition()
 * @model
 * @generated
 */
public interface DeclarativeBehaviorTransition extends BehaviorTransition,
                                              DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Src States</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.annex.behavior.declarative.Identifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Src States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Src States</em>' containment reference list.
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeBehaviorTransition_SrcStates()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Identifier> getSrcStates() ;

  /**
   * Returns the value of the '<em><b>Dest State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dest State</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dest State</em>' containment reference.
   * @see #setDestState(Identifier)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeBehaviorTransition_DestState()
   * @model containment="true" required="true"
   * @generated
   */
  Identifier getDestState() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorTransition#getDestState <em>Dest State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dest State</em>' containment reference.
   * @see #getDestState()
   * @generated
   */
  void setDestState(Identifier value) ;

} // DeclarativeBehaviorTransition
