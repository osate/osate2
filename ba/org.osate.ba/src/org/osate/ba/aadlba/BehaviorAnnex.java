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

import java.util.Map ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Element ;
import org.osate.ba.texteditor.AadlBaHighlighter ;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.visitor.IBAVisitable ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorAnnex#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorAnnex#getActions <em>Actions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorAnnex#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorAnnex#getInitialState <em>Initial State</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorAnnex()
 * @model
 * @generated
 */
public interface BehaviorAnnex extends AnnexSubclause, BehaviorElement
{
  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.BehaviorVariable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see #isSetVariables()
   * @see #unsetVariables()
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorAnnex_Variables()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<BehaviorVariable> getVariables();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetVariables()
   * @see #getVariables()
   * @generated
   */
  void unsetVariables();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Variables</em>' containment reference list is set.
   * @see #unsetVariables()
   * @see #getVariables()
   * @generated
   */
  boolean isSetVariables();

  /**
   * Returns the value of the '<em><b>States</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.BehaviorState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>States</em>' containment reference list.
   * @see #isSetStates()
   * @see #unsetStates()
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorAnnex_States()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<BehaviorState> getStates();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.BehaviorAnnex#getStates <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetStates()
   * @see #getStates()
   * @generated
   */
  void unsetStates();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.BehaviorAnnex#getStates <em>States</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>States</em>' containment reference list is set.
   * @see #unsetStates()
   * @see #getStates()
   * @generated
   */
  boolean isSetStates();

  /**
   * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.BehaviorTransition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitions</em>' containment reference list.
   * @see #isSetTransitions()
   * @see #unsetTransitions()
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorAnnex_Transitions()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<BehaviorTransition> getTransitions();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetTransitions()
   * @see #getTransitions()
   * @generated
   */
  void unsetTransitions();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Transitions</em>' containment reference list is set.
   * @see #unsetTransitions()
   * @see #getTransitions()
   * @generated
   */
  boolean isSetTransitions();

  /**
   * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.BehaviorActionBlock}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' containment reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorAnnex_Actions()
   * @model containment="true"
   * @generated
   */
  EList<BehaviorActionBlock> getActions();

  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.BehaviorCondition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorAnnex_Conditions()
   * @model containment="true"
   * @generated
   */
  EList<BehaviorCondition> getConditions();
  
  /**
   * Returns the value of the '<em><b>Initial State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial State</em>' reference.
   * @see #setInitialState(BehaviorState)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorAnnex_InitialState()
   * @model required="true"
   * @generated
   */
  BehaviorState getInitialState();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorAnnex#getInitialState <em>Initial State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial State</em>' reference.
   * @see #getInitialState()
   * @generated
   */
  void setInitialState(BehaviorState value);

  /**
   * @generated NOT
   */
  
  Map<AadlBaLocationReference, Element> getLinks();

} // BehaviorAnnex
