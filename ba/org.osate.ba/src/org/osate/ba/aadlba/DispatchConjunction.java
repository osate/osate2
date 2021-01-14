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
 * A representation of the model object '<em><b>Dispatch Conjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getDispatchConjunction()
 * @model
 * @generated
 */
public interface DispatchConjunction extends BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Dispatch Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.ba.aadlba.DispatchTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatch Triggers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatch Triggers</em>' containment reference list.
	 * @see #isSetDispatchTriggers()
	 * @see #unsetDispatchTriggers()
	 * @see org.osate.ba.aadlba.AadlBaPackage#getDispatchConjunction_DispatchTriggers()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<DispatchTrigger> getDispatchTriggers();

	/**
	 * Unsets the value of the '{@link org.osate.ba.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDispatchTriggers()
	 * @see #getDispatchTriggers()
	 * @generated
	 */
	void unsetDispatchTriggers();

	/**
	 * Returns whether the value of the '{@link org.osate.ba.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dispatch Triggers</em>' containment reference list is set.
	 * @see #unsetDispatchTriggers()
	 * @see #getDispatchTriggers()
	 * @generated
	 */
	boolean isSetDispatchTriggers();

} // DispatchConjunction
