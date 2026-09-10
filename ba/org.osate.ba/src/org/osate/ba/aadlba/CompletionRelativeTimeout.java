/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Completion Relative Timeout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.CompletionRelativeTimeout#getResetPorts <em>Reset Ports</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getCompletionRelativeTimeout()
 * @model
 * @generated
 */
public interface CompletionRelativeTimeout extends BehaviorTime, DispatchRelativeTimeout {

	/**
	 * Returns the value of the '<em><b>Reset Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.ba.aadlba.TimeoutResetPort}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset Ports</em>' containment reference list.
	 * @see #isSetResetPorts()
	 * @see #unsetResetPorts()
	 * @see org.osate.ba.aadlba.AadlBaPackage#getCompletionRelativeTimeout_ResetPorts()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<TimeoutResetPort> getResetPorts();

	/**
	 * Unsets the value of the '{@link org.osate.ba.aadlba.CompletionRelativeTimeout#getResetPorts <em>Reset Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetResetPorts()
	 * @see #getResetPorts()
	 * @generated
	 */
	void unsetResetPorts();

	/**
	 * Returns whether the value of the '{@link org.osate.ba.aadlba.CompletionRelativeTimeout#getResetPorts <em>Reset Ports</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reset Ports</em>' containment reference list is set.
	 * @see #unsetResetPorts()
	 * @see #getResetPorts()
	 * @generated
	 */
	boolean isSetResetPorts();
} // CompletionRelativeTimeout
