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
package org.osate.ba.aadlba.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.InternalPortHolder;
import org.osate.ba.aadlba.InternalPortSendAction;
import org.osate.ba.aadlba.ValueExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Port Send Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.InternalPortSendActionImpl#getInternalPort <em>Internal Port</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.InternalPortSendActionImpl#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalPortSendActionImpl extends BehaviorElementImpl implements InternalPortSendAction {
	/**
	 * The cached value of the '{@link #getInternalPort() <em>Internal Port</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalPort()
	 * @generated
	 * @ordered
	 */
	protected InternalPortHolder internalPort;

	/**
	 * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpression()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression valueExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalPortSendActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.INTERNAL_PORT_SEND_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InternalPortHolder getInternalPort() {
		return internalPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalPort(InternalPortHolder newInternalPort, NotificationChain msgs) {
		InternalPortHolder oldInternalPort = internalPort;
		internalPort = newInternalPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT, oldInternalPort, newInternalPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInternalPort(InternalPortHolder newInternalPort) {
		if (newInternalPort != internalPort) {
			NotificationChain msgs = null;
			if (internalPort != null)
				msgs = ((InternalEObject)internalPort).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT, null, msgs);
			if (newInternalPort != null)
				msgs = ((InternalEObject)newInternalPort).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT, null, msgs);
			msgs = basicSetInternalPort(newInternalPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT, newInternalPort, newInternalPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueExpression getValueExpression() {
		return valueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueExpression(ValueExpression newValueExpression, NotificationChain msgs) {
		ValueExpression oldValueExpression = valueExpression;
		valueExpression = newValueExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueExpression(ValueExpression newValueExpression) {
		if (newValueExpression != valueExpression) {
			NotificationChain msgs = null;
			if (valueExpression != null)
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT:
				return basicSetInternalPort(null, msgs);
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT:
				return getInternalPort();
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION:
				return getValueExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT:
				setInternalPort((InternalPortHolder)newValue);
				return;
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION:
				setValueExpression((ValueExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT:
				setInternalPort((InternalPortHolder)null);
				return;
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION:
				setValueExpression((ValueExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__INTERNAL_PORT:
				return internalPort != null;
			case AadlBaPackage.INTERNAL_PORT_SEND_ACTION__VALUE_EXPRESSION:
				return valueExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //InternalPortSendActionImpl
