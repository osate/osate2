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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.CompletionRelativeTimeout;
import org.osate.ba.aadlba.TimeoutResetPort;
import org.osate.ba.utils.visitor.IBAVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion Relative Timeout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.CompletionRelativeTimeoutImpl#getResetPorts <em>Reset Ports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompletionRelativeTimeoutImpl extends BehaviorTimeImpl implements CompletionRelativeTimeout {
	/**
	 * The cached value of the '{@link #getResetPorts() <em>Reset Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResetPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeoutResetPort> resetPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletionRelativeTimeoutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.COMPLETION_RELATIVE_TIMEOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TimeoutResetPort> getResetPorts() {
		if (resetPorts == null) {
			resetPorts = new EObjectContainmentEList.Unsettable<>(TimeoutResetPort.class, this,
					AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT__RESET_PORTS);
		}
		return resetPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetResetPorts() {
		if (resetPorts != null) {
			((InternalEList.Unsettable<?>) resetPorts).unset();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetResetPorts() {
		return resetPorts != null && ((InternalEList.Unsettable<?>) resetPorts).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT__RESET_PORTS:
			return ((InternalEList<?>) getResetPorts()).basicRemove(otherEnd, msgs);
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
		case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT__RESET_PORTS:
			return getResetPorts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT__RESET_PORTS:
			getResetPorts().clear();
			getResetPorts().addAll((Collection<? extends TimeoutResetPort>) newValue);
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
		case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT__RESET_PORTS:
			unsetResetPorts();
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
		case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT__RESET_PORTS:
			return isSetResetPorts();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void accept(IBAVisitor visitor) {
		visitor.visit(this);
	}
} // CompletionRelativeTimeoutImpl
