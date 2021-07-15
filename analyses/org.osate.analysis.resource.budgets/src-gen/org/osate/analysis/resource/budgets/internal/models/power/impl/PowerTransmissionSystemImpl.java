/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;
import org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier;
import org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transmission System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerTransmissionSystemImpl#getComponentInstance <em>Component Instance</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerTransmissionSystemImpl#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerTransmissionSystemImpl#getConsumers <em>Consumers</em>}</li>
 * </ul>
 *
 * @generated
 * @since 4.1
 */
public class PowerTransmissionSystemImpl extends PowerElementImpl implements PowerTransmissionSystem {
	/**
	 * The cached value of the '{@link #getComponentInstance() <em>Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInstance()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance componentInstance;

	/**
	 * The cached value of the '{@link #getSuppliers() <em>Suppliers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppliers()
	 * @generated
	 * @ordered
	 */
	protected EList<PowerSupplier> suppliers;

	/**
	 * The cached value of the '{@link #getConsumers() <em>Consumers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsumers()
	 * @generated
	 * @ordered
	 */
	protected EList<PowerConsumer> consumers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerTransmissionSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PowerPackage.Literals.POWER_TRANSMISSION_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentInstance getComponentInstance() {
		if (componentInstance != null && componentInstance.eIsProxy()) {
			InternalEObject oldComponentInstance = (InternalEObject)componentInstance;
			componentInstance = (ComponentInstance)eResolveProxy(oldComponentInstance);
			if (componentInstance != oldComponentInstance) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PowerPackage.POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE, oldComponentInstance, componentInstance));
				}
			}
		}
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetComponentInstance() {
		return componentInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComponentInstance(ComponentInstance newComponentInstance) {
		ComponentInstance oldComponentInstance = componentInstance;
		componentInstance = newComponentInstance;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PowerPackage.POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE, oldComponentInstance, componentInstance));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PowerSupplier> getSuppliers() {
		if (suppliers == null) {
			suppliers = new EObjectContainmentEList<PowerSupplier>(PowerSupplier.class, this, PowerPackage.POWER_TRANSMISSION_SYSTEM__SUPPLIERS);
		}
		return suppliers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PowerConsumer> getConsumers() {
		if (consumers == null) {
			consumers = new EObjectContainmentEList<PowerConsumer>(PowerConsumer.class, this, PowerPackage.POWER_TRANSMISSION_SYSTEM__CONSUMERS);
		}
		return consumers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__SUPPLIERS:
				return ((InternalEList<?>)getSuppliers()).basicRemove(otherEnd, msgs);
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__CONSUMERS:
				return ((InternalEList<?>)getConsumers()).basicRemove(otherEnd, msgs);
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
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE:
				if (resolve) {
					return getComponentInstance();
				}
				return basicGetComponentInstance();
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__SUPPLIERS:
				return getSuppliers();
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__CONSUMERS:
				return getConsumers();
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
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)newValue);
				return;
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__SUPPLIERS:
				getSuppliers().clear();
				getSuppliers().addAll((Collection<? extends PowerSupplier>)newValue);
				return;
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__CONSUMERS:
				getConsumers().clear();
				getConsumers().addAll((Collection<? extends PowerConsumer>)newValue);
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
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE:
				setComponentInstance((ComponentInstance)null);
				return;
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__SUPPLIERS:
				getSuppliers().clear();
				return;
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__CONSUMERS:
				getConsumers().clear();
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
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE:
				return componentInstance != null;
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__SUPPLIERS:
				return suppliers != null && !suppliers.isEmpty();
			case PowerPackage.POWER_TRANSMISSION_SYSTEM__CONSUMERS:
				return consumers != null && !consumers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PowerTransmissionSystemImpl
