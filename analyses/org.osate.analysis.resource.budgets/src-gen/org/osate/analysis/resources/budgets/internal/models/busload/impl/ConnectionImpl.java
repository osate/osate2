/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage;
import org.osate.analysis.resources.budgets.internal.models.busload.Connection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.ConnectionImpl#getConnectionInstance <em>Connection Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends BusloadElementImpl implements Connection {
	/**
	 * The cached value of the '{@link #getConnectionInstance() <em>Connection Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionInstance()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstance connectionInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BusloadPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionInstance getConnectionInstance() {
		if (connectionInstance != null && connectionInstance.eIsProxy()) {
			InternalEObject oldConnectionInstance = (InternalEObject)connectionInstance;
			connectionInstance = (ConnectionInstance)eResolveProxy(oldConnectionInstance);
			if (connectionInstance != oldConnectionInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BusloadPackage.CONNECTION__CONNECTION_INSTANCE, oldConnectionInstance, connectionInstance));
			}
		}
		return connectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstance basicGetConnectionInstance() {
		return connectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectionInstance(ConnectionInstance newConnectionInstance) {
		ConnectionInstance oldConnectionInstance = connectionInstance;
		connectionInstance = newConnectionInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BusloadPackage.CONNECTION__CONNECTION_INSTANCE, oldConnectionInstance, connectionInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				if (resolve) return getConnectionInstance();
				return basicGetConnectionInstance();
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
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				setConnectionInstance((ConnectionInstance)newValue);
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
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				setConnectionInstance((ConnectionInstance)null);
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
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				return connectionInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectionImpl
