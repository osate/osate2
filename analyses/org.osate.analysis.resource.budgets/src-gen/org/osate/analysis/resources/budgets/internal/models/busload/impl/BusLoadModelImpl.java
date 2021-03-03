/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.analysis.model.analysis.impl.AnalysisElementImpl;
import org.osate.analysis.resources.budgets.internal.models.busload.Bus;
import org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel;
import org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Load Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusLoadModelImpl#getRootBuses <em>Root Buses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BusLoadModelImpl extends AnalysisElementImpl implements BusLoadModel {
	/**
	 * The cached value of the '{@link #getRootBuses() <em>Root Buses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootBuses()
	 * @generated
	 * @ordered
	 */
	protected EList<Bus> rootBuses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusLoadModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BusloadPackage.Literals.BUS_LOAD_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Bus> getRootBuses() {
		if (rootBuses == null) {
			rootBuses = new EObjectContainmentEList<Bus>(Bus.class, this, BusloadPackage.BUS_LOAD_MODEL__ROOT_BUSES);
		}
		return rootBuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BusloadPackage.BUS_LOAD_MODEL__ROOT_BUSES:
				return ((InternalEList<?>)getRootBuses()).basicRemove(otherEnd, msgs);
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
			case BusloadPackage.BUS_LOAD_MODEL__ROOT_BUSES:
				return getRootBuses();
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
			case BusloadPackage.BUS_LOAD_MODEL__ROOT_BUSES:
				getRootBuses().clear();
				getRootBuses().addAll((Collection<? extends Bus>)newValue);
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
			case BusloadPackage.BUS_LOAD_MODEL__ROOT_BUSES:
				getRootBuses().clear();
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
			case BusloadPackage.BUS_LOAD_MODEL__ROOT_BUSES:
				return rootBuses != null && !rootBuses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BusLoadModelImpl
