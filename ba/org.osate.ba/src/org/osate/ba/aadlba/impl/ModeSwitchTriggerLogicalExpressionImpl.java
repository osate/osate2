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
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.LogicalOperator;
import org.osate.ba.aadlba.ModeSwitchConjunction;
import org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Switch Trigger Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.ModeSwitchTriggerLogicalExpressionImpl#getModeSwitchConjunctions <em>Mode Switch Conjunctions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.ModeSwitchTriggerLogicalExpressionImpl#getLogicalOperators <em>Logical Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeSwitchTriggerLogicalExpressionImpl extends BehaviorElementImpl
		implements ModeSwitchTriggerLogicalExpression {
	/**
	 * The cached value of the '{@link #getModeSwitchConjunctions() <em>Mode Switch Conjunctions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeSwitchConjunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeSwitchConjunction> modeSwitchConjunctions;

	/**
	 * The cached value of the '{@link #getLogicalOperators() <em>Logical Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicalOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<LogicalOperator> logicalOperators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeSwitchTriggerLogicalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeSwitchConjunction> getModeSwitchConjunctions() {
		if (modeSwitchConjunctions == null) {
			modeSwitchConjunctions = new EObjectContainmentEList<>(ModeSwitchConjunction.class,
					this, AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__MODE_SWITCH_CONJUNCTIONS);
		}
		return modeSwitchConjunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LogicalOperator> getLogicalOperators() {
		if (logicalOperators == null) {
			logicalOperators = new EDataTypeEList.Unsettable<>(LogicalOperator.class, this,
					AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__LOGICAL_OPERATORS);
		}
		return logicalOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLogicalOperators() {
		if (logicalOperators != null) {
			((InternalEList.Unsettable<?>) logicalOperators).unset();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLogicalOperators() {
		return logicalOperators != null && ((InternalEList.Unsettable<?>) logicalOperators).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__MODE_SWITCH_CONJUNCTIONS:
			return ((InternalEList<?>) getModeSwitchConjunctions()).basicRemove(otherEnd, msgs);
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
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__MODE_SWITCH_CONJUNCTIONS:
			return getModeSwitchConjunctions();
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__LOGICAL_OPERATORS:
			return getLogicalOperators();
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
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__MODE_SWITCH_CONJUNCTIONS:
			getModeSwitchConjunctions().clear();
			getModeSwitchConjunctions().addAll((Collection<? extends ModeSwitchConjunction>) newValue);
			return;
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__LOGICAL_OPERATORS:
			getLogicalOperators().clear();
			getLogicalOperators().addAll((Collection<? extends LogicalOperator>) newValue);
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
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__MODE_SWITCH_CONJUNCTIONS:
			getModeSwitchConjunctions().clear();
			return;
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__LOGICAL_OPERATORS:
			unsetLogicalOperators();
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
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__MODE_SWITCH_CONJUNCTIONS:
			return modeSwitchConjunctions != null && !modeSwitchConjunctions.isEmpty();
		case AadlBaPackage.MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__LOGICAL_OPERATORS:
			return isSetLogicalOperators();
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
		result.append(" (logicalOperators: ");
		result.append(logicalOperators);
		result.append(')');
		return result.toString();
	}

} // ModeSwitchTriggerLogicalExpressionImpl
