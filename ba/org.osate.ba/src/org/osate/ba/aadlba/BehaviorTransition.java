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

import org.osate.ba.utils.visitor.IBAVisitable ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.BehaviorTransition#getSourceState <em>Source State</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorTransition#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorTransition#getDestinationState <em>Destination State</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorTransition#getActionBlock <em>Action Block</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorTransition#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorTransition()
 * @model
 * @generated
 */
public interface BehaviorTransition extends BehaviorNamedElement
{
  /**
   * Returns the value of the '<em><b>Source State</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.osate.ba.aadlba.BehaviorState#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source State</em>' reference.
   * @see #setSourceState(BehaviorState)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorTransition_SourceState()
   * @see org.osate.ba.aadlba.BehaviorState#getOutgoingTransitions
   * @model opposite="outgoingTransitions"
   * @generated
   */
  BehaviorState getSourceState();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorTransition#getSourceState <em>Source State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source State</em>' reference.
   * @see #getSourceState()
   * @generated
   */
  void setSourceState(BehaviorState value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(BehaviorCondition)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorTransition_Condition()
   * @model containment="true"
   * @generated
   */
  BehaviorCondition getCondition();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorTransition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(BehaviorCondition value);

  /**
   * Returns the value of the '<em><b>Destination State</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.osate.ba.aadlba.BehaviorState#getIncomingTransitions <em>Incoming Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Destination State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination State</em>' reference.
   * @see #setDestinationState(BehaviorState)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorTransition_DestinationState()
   * @see org.osate.ba.aadlba.BehaviorState#getIncomingTransitions
   * @model opposite="incomingTransitions"
   * @generated
   */
  BehaviorState getDestinationState();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorTransition#getDestinationState <em>Destination State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination State</em>' reference.
   * @see #getDestinationState()
   * @generated
   */
  void setDestinationState(BehaviorState value);

  /**
   * Returns the value of the '<em><b>Action Block</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action Block</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Block</em>' reference.
   * @see #setActionBlock(BehaviorActionBlock)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorTransition_ActionBlock()
   * @model
   * @generated
   */
  BehaviorActionBlock getActionBlock();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorTransition#getActionBlock <em>Action Block</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action Block</em>' reference.
   * @see #getActionBlock()
   * @generated
   */
  void setActionBlock(BehaviorActionBlock value);

  /**
   * Returns the value of the '<em><b>Priority</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' attribute.
   * @see #setPriority(long)
   * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorTransition_Priority()
   * @model default="-1" unique="false" dataType="org.osate.aadl2.Integer"
   * @generated
   */
  long getPriority();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorTransition#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' attribute.
   * @see #getPriority()
   * @generated
   */
  void setPriority(long value);

} // BehaviorTransition
