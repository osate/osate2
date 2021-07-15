/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.analysis.model.impl.AnalysisElementImpl;
import org.osate.analysis.resource.budgets.internal.models.power.PowerModel;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;
import org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerModelImpl#getRootPowerTransmissionSystem <em>Root Power Transmission System</em>}</li>
 * </ul>
 *
 * @generated
 * @since 4.1
 */
public class PowerModelImpl extends AnalysisElementImpl implements PowerModel {
	/**
	 * The cached value of the '{@link #getRootPowerTransmissionSystem() <em>Root Power Transmission System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPowerTransmissionSystem()
	 * @generated
	 * @ordered
	 */
	protected EList<PowerTransmissionSystem> rootPowerTransmissionSystem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PowerPackage.Literals.POWER_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PowerTransmissionSystem> getRootPowerTransmissionSystem() {
		if (rootPowerTransmissionSystem == null) {
			rootPowerTransmissionSystem = new EObjectContainmentEList<PowerTransmissionSystem>(PowerTransmissionSystem.class, this, PowerPackage.POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM);
		}
		return rootPowerTransmissionSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PowerPackage.POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM:
				return ((InternalEList<?>)getRootPowerTransmissionSystem()).basicRemove(otherEnd, msgs);
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
			case PowerPackage.POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM:
				return getRootPowerTransmissionSystem();
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
			case PowerPackage.POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM:
				getRootPowerTransmissionSystem().clear();
				getRootPowerTransmissionSystem().addAll((Collection<? extends PowerTransmissionSystem>)newValue);
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
			case PowerPackage.POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM:
				getRootPowerTransmissionSystem().clear();
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
			case PowerPackage.POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM:
				return rootPowerTransmissionSystem != null && !rootPowerTransmissionSystem.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PowerModelImpl
