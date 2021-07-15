/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consumer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerConsumerImpl#getFeatureInstance <em>Feature Instance</em>}</li>
 * </ul>
 *
 * @generated
 * @since 4.1
 */
public class PowerConsumerImpl extends PowerElementImpl implements PowerConsumer {
	/**
	 * The cached value of the '{@link #getFeatureInstance() <em>Feature Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureInstance()
	 * @generated
	 * @ordered
	 */
	protected FeatureInstance featureInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerConsumerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PowerPackage.Literals.POWER_CONSUMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureInstance getFeatureInstance() {
		if (featureInstance != null && featureInstance.eIsProxy()) {
			InternalEObject oldFeatureInstance = (InternalEObject)featureInstance;
			featureInstance = (FeatureInstance)eResolveProxy(oldFeatureInstance);
			if (featureInstance != oldFeatureInstance) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PowerPackage.POWER_CONSUMER__FEATURE_INSTANCE, oldFeatureInstance, featureInstance));
				}
			}
		}
		return featureInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInstance basicGetFeatureInstance() {
		return featureInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeatureInstance(FeatureInstance newFeatureInstance) {
		FeatureInstance oldFeatureInstance = featureInstance;
		featureInstance = newFeatureInstance;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PowerPackage.POWER_CONSUMER__FEATURE_INSTANCE, oldFeatureInstance, featureInstance));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PowerPackage.POWER_CONSUMER__FEATURE_INSTANCE:
				if (resolve) {
					return getFeatureInstance();
				}
				return basicGetFeatureInstance();
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
			case PowerPackage.POWER_CONSUMER__FEATURE_INSTANCE:
				setFeatureInstance((FeatureInstance)newValue);
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
			case PowerPackage.POWER_CONSUMER__FEATURE_INSTANCE:
				setFeatureInstance((FeatureInstance)null);
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
			case PowerPackage.POWER_CONSUMER__FEATURE_INSTANCE:
				return featureInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //PowerConsumerImpl
