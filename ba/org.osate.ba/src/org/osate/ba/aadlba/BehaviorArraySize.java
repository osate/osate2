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

import org.osate.aadl2.ArraySize;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Array Size</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.BehaviorArraySize#getIntegerValue <em>Integer Value</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorArraySize()
 * @model annotation="Documentation documentation='The size of one behavior variable array dimension. The size is the integer value that was written, held without evaluation. The inherited size and sizeProperty carry the extent only for the two forms core AADL can express, an integer literal and a property constant.'"
 * @generated
 */
public interface BehaviorArraySize extends ArraySize, BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Integer Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Value</em>' containment reference.
	 * @see #setIntegerValue(IntegerValue)
	 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorArraySize_IntegerValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntegerValue getIntegerValue();

	/**
	 * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorArraySize#getIntegerValue <em>Integer Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Value</em>' containment reference.
	 * @see #getIntegerValue()
	 * @generated
	 */
	void setIntegerValue(IntegerValue value);

} // BehaviorArraySize
