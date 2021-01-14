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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Action Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.BehaviorActionBlock#getContent <em>Content</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.BehaviorActionBlock#getTimeout <em>Timeout</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorActionBlock()
 * @model
 * @generated
 */
public interface BehaviorActionBlock extends BehaviorAction, BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference.
	 * @see #setContent(BehaviorActions)
	 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorActionBlock_Content()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BehaviorActions getContent();

	/**
	 * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorActionBlock#getContent <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' containment reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(BehaviorActions value);

	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' containment reference.
	 * @see #setTimeout(BehaviorTime)
	 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorActionBlock_Timeout()
	 * @model containment="true"
	 * @generated
	 */
	BehaviorTime getTimeout();

	/**
	 * Sets the value of the '{@link org.osate.ba.aadlba.BehaviorActionBlock#getTimeout <em>Timeout</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' containment reference.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(BehaviorTime value);

} // BehaviorActionBlock
