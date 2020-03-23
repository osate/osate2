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
import org.osate.ba.utils.visitor.IBAVisitable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dispatch Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.DispatchCondition#getDispatchTriggerCondition <em>Dispatch Trigger Condition</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getDispatchCondition()
 * @model
 * @generated
 */
public interface DispatchCondition extends BehaviorCondition
{
  /**
   * Returns the value of the '<em><b>Dispatch Trigger Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dispatch Trigger Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dispatch Trigger Condition</em>' containment reference.
   * @see #setDispatchTriggerCondition(DispatchTriggerCondition)
   * @see org.osate.ba.aadlba.AadlBaPackage#getDispatchCondition_DispatchTriggerCondition()
   * @model containment="true"
   * @generated
   */
  DispatchTriggerCondition getDispatchTriggerCondition();

  /**
   * Sets the value of the '{@link org.osate.ba.aadlba.DispatchCondition#getDispatchTriggerCondition <em>Dispatch Trigger Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dispatch Trigger Condition</em>' containment reference.
   * @see #getDispatchTriggerCondition()
   * @generated
   */
  void setDispatchTriggerCondition(DispatchTriggerCondition value);

  /**
   * Returns the value of the '<em><b>Frozen Ports</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.ba.aadlba.ActualPortHolder}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Frozen Ports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Frozen Ports</em>' containment reference list.
   * @see #isSetFrozenPorts()
   * @see #unsetFrozenPorts()
   * @see org.osate.ba.aadlba.AadlBaPackage#getDispatchCondition_FrozenPorts()
   * @model containment="true" unsettable="true"
   * @generated
   */
  EList<ActualPortHolder> getFrozenPorts();

  /**
   * Unsets the value of the '{@link org.osate.ba.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetFrozenPorts()
   * @see #getFrozenPorts()
   * @generated
   */
  void unsetFrozenPorts();

  /**
   * Returns whether the value of the '{@link org.osate.ba.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}' containment reference list is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Frozen Ports</em>' containment reference list is set.
   * @see #unsetFrozenPorts()
   * @see #getFrozenPorts()
   * @generated
   */
  boolean isSetFrozenPorts();

} // DispatchCondition
