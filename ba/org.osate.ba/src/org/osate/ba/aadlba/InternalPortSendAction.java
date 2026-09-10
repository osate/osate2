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
 * A representation of the model object '<em><b>Internal Port Send Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.InternalPortSendAction#getInternalPort <em>Internal Port</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.InternalPortSendAction#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getInternalPortSendAction()
 * @model
 * @generated
 */
public interface InternalPortSendAction extends CommunicationAction {
	/**
	 * Returns the value of the '<em><b>Internal Port</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Port</em>' containment reference.
	 * @see #setInternalPort(InternalPortHolder)
	 * @see org.osate.ba.aadlba.AadlBaPackage#getInternalPortSendAction_InternalPort()
	 * @model containment="true"
	 * @generated
	 */
	InternalPortHolder getInternalPort();

	/**
	 * Sets the value of the '{@link org.osate.ba.aadlba.InternalPortSendAction#getInternalPort <em>Internal Port</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Port</em>' containment reference.
	 * @see #getInternalPort()
	 * @generated
	 */
	void setInternalPort(InternalPortHolder value);

	/**
	 * Returns the value of the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression</em>' containment reference.
	 * @see #setValueExpression(ValueExpression)
	 * @see org.osate.ba.aadlba.AadlBaPackage#getInternalPortSendAction_ValueExpression()
	 * @model containment="true"
	 * @generated
	 */
	ValueExpression getValueExpression();

	/**
	 * Sets the value of the '{@link org.osate.ba.aadlba.InternalPortSendAction#getValueExpression <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' containment reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(ValueExpression value);

} // InternalPortSendAction
