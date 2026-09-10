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
 * A representation of the model object '<em><b>Internal Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.InternalCondition#getInternalPorts <em>Internal Ports</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getInternalCondition()
 * @model
 * @generated
 */
public interface InternalCondition extends BehaviorCondition {
	/**
	 * Returns the value of the '<em><b>Internal Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.ba.aadlba.InternalPortHolder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Ports</em>' containment reference list.
	 * @see #isSetInternalPorts()
	 * @see #unsetInternalPorts()
	 * @see org.osate.ba.aadlba.AadlBaPackage#getInternalCondition_InternalPorts()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<InternalPortHolder> getInternalPorts();

	/**
	 * Unsets the value of the '{@link org.osate.ba.aadlba.InternalCondition#getInternalPorts <em>Internal Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternalPorts()
	 * @see #getInternalPorts()
	 * @generated
	 */
	void unsetInternalPorts();

	/**
	 * Returns whether the value of the '{@link org.osate.ba.aadlba.InternalCondition#getInternalPorts <em>Internal Ports</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Ports</em>' containment reference list is set.
	 * @see #unsetInternalPorts()
	 * @see #getInternalPorts()
	 * @generated
	 */
	boolean isSetInternalPorts();

} // InternalCondition
