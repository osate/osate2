/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.PortSendAction;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Send Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl#getPortName <em>Port Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl#getValueExpressionOwned <em>Value Expression Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortSendActionImpl extends ElementImpl implements PortSendAction {
	/**
	 * The cached value of the '{@link #getPortName() <em>Port Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortName()
	 * @generated
	 * @ordered
	 */
	protected Name portName;

	/**
	 * The cached value of the '{@link #getValueExpressionOwned() <em>Value Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpressionOwned()
	 * @generated
	 * @ordered
	 */
	protected ValueExpression valueExpressionOwned;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortSendActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.PORT_SEND_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Name getPortName() {
		return portName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPortName(Name newPortName, NotificationChain msgs) {
		Name oldPortName = portName;
		portName = newPortName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_SEND_ACTION__PORT_NAME, oldPortName, newPortName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortName(Name newPortName) {
		if (newPortName != portName) {
			NotificationChain msgs = null;
			if (portName != null)
				msgs = ((InternalEObject)portName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_SEND_ACTION__PORT_NAME, null, msgs);
			if (newPortName != null)
				msgs = ((InternalEObject)newPortName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_SEND_ACTION__PORT_NAME, null, msgs);
			msgs = basicSetPortName(newPortName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_SEND_ACTION__PORT_NAME, newPortName, newPortName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueExpression getValueExpressionOwned() {
		return valueExpressionOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueExpressionOwned(ValueExpression newValueExpressionOwned, NotificationChain msgs) {
		ValueExpression oldValueExpressionOwned = valueExpressionOwned;
		valueExpressionOwned = newValueExpressionOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED, oldValueExpressionOwned, newValueExpressionOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueExpressionOwned(ValueExpression newValueExpressionOwned) {
		if (newValueExpressionOwned != valueExpressionOwned) {
			NotificationChain msgs = null;
			if (valueExpressionOwned != null)
				msgs = ((InternalEObject)valueExpressionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED, null, msgs);
			if (newValueExpressionOwned != null)
				msgs = ((InternalEObject)newValueExpressionOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED, null, msgs);
			msgs = basicSetValueExpressionOwned(newValueExpressionOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED, newValueExpressionOwned, newValueExpressionOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.PORT_SEND_ACTION__PORT_NAME:
				return basicSetPortName(null, msgs);
			case AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED:
				return basicSetValueExpressionOwned(null, msgs);
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
			case AadlBaPackage.PORT_SEND_ACTION__PORT_NAME:
				return getPortName();
			case AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED:
				return getValueExpressionOwned();
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
			case AadlBaPackage.PORT_SEND_ACTION__PORT_NAME:
				setPortName((Name)newValue);
				return;
			case AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED:
				setValueExpressionOwned((ValueExpression)newValue);
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
			case AadlBaPackage.PORT_SEND_ACTION__PORT_NAME:
				setPortName((Name)null);
				return;
			case AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED:
				setValueExpressionOwned((ValueExpression)null);
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
			case AadlBaPackage.PORT_SEND_ACTION__PORT_NAME:
				return portName != null;
			case AadlBaPackage.PORT_SEND_ACTION__VALUE_EXPRESSION_OWNED:
				return valueExpressionOwned != null;
		}
		return super.eIsSet(featureID);
	}

} //PortSendActionImpl
