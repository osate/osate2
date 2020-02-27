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

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Mode;
import org.osate.ba.utils.visitor.IBAVisitable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.BehaviorState#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorState#isComplete <em>Complete</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorState#isFinal <em>Final</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorState#getBindedMode <em>Binded Mode</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorState#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorState#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorState()
 * @model
 * @generated
 */
public interface BehaviorState extends BehaviorNamedElement
{
  /**
   * Returns the value of the '<em><b>Initial</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial</em>' attribute.
   * @see #setInitial(boolean)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorState_Initial()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean" required="true"
   * @generated
   */
  boolean isInitial();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorState#isInitial <em>Initial</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial</em>' attribute.
   * @see #isInitial()
   * @generated
   */
  void setInitial(boolean value);

  /**
   * Returns the value of the '<em><b>Complete</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Complete</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Complete</em>' attribute.
   * @see #setComplete(boolean)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorState_Complete()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean" required="true"
   * @generated
   */
  boolean isComplete();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorState#isComplete <em>Complete</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Complete</em>' attribute.
   * @see #isComplete()
   * @generated
   */
  void setComplete(boolean value);

  /**
   * Returns the value of the '<em><b>Final</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final</em>' attribute.
   * @see #setFinal(boolean)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorState_Final()
   * @model default="false" dataType="org.osate.ba.aadlba.Boolean" required="true"
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorState#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Binded Mode</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binded Mode</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binded Mode</em>' reference.
   * @see #setBindedMode(Mode)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorState_BindedMode()
   * @model
   * @generated
   */
  Mode getBindedMode();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorState#getBindedMode <em>Binded Mode</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binded Mode</em>' reference.
   * @see #getBindedMode()
   * @generated
   */
  void setBindedMode(Mode value);

  /**
   * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.BehaviorTransition}.
   * It is bidirectional and its opposite is '{@link org.osate.ba.aadlba.BehaviorTransition#getDestinationState <em>Destination State</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming Transitions</em>' reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorState_IncomingTransitions()
   * @see org.osate.ba.aadlba.BehaviorTransition#getDestinationState
   * @model opposite="destinationState"
   * @generated
   */
  EList<BehaviorTransition> getIncomingTransitions();

  /**
   * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.BehaviorTransition}.
   * It is bidirectional and its opposite is '{@link org.osate.ba.aadlba.BehaviorTransition#getSourceState <em>Source State</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Transitions</em>' reference list.
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorState_OutgoingTransitions()
   * @see org.osate.ba.aadlba.BehaviorTransition#getSourceState
   * @model opposite="sourceState"
   * @generated
   */
  EList<BehaviorTransition> getOutgoingTransitions();

} // BehaviorState
