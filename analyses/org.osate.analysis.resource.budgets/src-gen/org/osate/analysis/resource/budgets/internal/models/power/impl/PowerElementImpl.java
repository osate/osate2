/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.analysis.model.impl.AnalysisElementImpl;
import org.osate.analysis.resource.budgets.internal.models.power.PowerElement;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerElementImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerElementImpl#getBudget <em>Budget</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerElementImpl#getSupply <em>Supply</em>}</li>
 * </ul>
 *
 * @generated
 * @since 4.1
 */
public abstract class PowerElementImpl extends AnalysisElementImpl implements PowerElement {
	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final double CAPACITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected double capacity = CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected static final double BUDGET_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBudget() <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBudget()
	 * @generated
	 * @ordered
	 */
	protected double budget = BUDGET_EDEFAULT;

	/**
	 * The default value of the '{@link #getSupply() <em>Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupply()
	 * @generated
	 * @ordered
	 */
	protected static final double SUPPLY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSupply() <em>Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupply()
	 * @generated
	 * @ordered
	 */
	protected double supply = SUPPLY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PowerPackage.Literals.POWER_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapacity(double newCapacity) {
		double oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PowerPackage.POWER_ELEMENT__CAPACITY, oldCapacity, capacity));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBudget() {
		return budget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBudget(double newBudget) {
		double oldBudget = budget;
		budget = newBudget;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PowerPackage.POWER_ELEMENT__BUDGET, oldBudget, budget));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSupply() {
		return supply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSupply(double newSupply) {
		double oldSupply = supply;
		supply = newSupply;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PowerPackage.POWER_ELEMENT__SUPPLY, oldSupply, supply));
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
			case PowerPackage.POWER_ELEMENT__CAPACITY:
				return getCapacity();
			case PowerPackage.POWER_ELEMENT__BUDGET:
				return getBudget();
			case PowerPackage.POWER_ELEMENT__SUPPLY:
				return getSupply();
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
			case PowerPackage.POWER_ELEMENT__CAPACITY:
				setCapacity((Double)newValue);
				return;
			case PowerPackage.POWER_ELEMENT__BUDGET:
				setBudget((Double)newValue);
				return;
			case PowerPackage.POWER_ELEMENT__SUPPLY:
				setSupply((Double)newValue);
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
			case PowerPackage.POWER_ELEMENT__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
				return;
			case PowerPackage.POWER_ELEMENT__BUDGET:
				setBudget(BUDGET_EDEFAULT);
				return;
			case PowerPackage.POWER_ELEMENT__SUPPLY:
				setSupply(SUPPLY_EDEFAULT);
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
			case PowerPackage.POWER_ELEMENT__CAPACITY:
				return capacity != CAPACITY_EDEFAULT;
			case PowerPackage.POWER_ELEMENT__BUDGET:
				return budget != BUDGET_EDEFAULT;
			case PowerPackage.POWER_ELEMENT__SUPPLY:
				return supply != SUPPLY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (capacity: ");
		result.append(capacity);
		result.append(", budget: ");
		result.append(budget);
		result.append(", supply: ");
		result.append(supply);
		result.append(')');
		return result.toString();
	}

} //PowerElementImpl
