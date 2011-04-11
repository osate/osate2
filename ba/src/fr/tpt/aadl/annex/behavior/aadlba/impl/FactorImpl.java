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

package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Factor;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Value;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getValueOwned <em>Value Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getValueSdOwned <em>Value Sd Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactorImpl extends BehaviorElementImpl implements Factor {
	/**
	 * The cached value of the '{@link #getValueOwned() <em>Value Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueOwned()
	 * @generated
	 * @ordered
	 */
	protected Value valueOwned;

	/**
	 * The cached value of the '{@link #getValueSdOwned() <em>Value Sd Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueSdOwned()
	 * @generated
	 * @ordered
	 */
	protected Value valueSdOwned;

	/**
	 * The default value of the '{@link #getBinaryNumericOperatorOwned() <em>Binary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinaryNumericOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected static final BinaryNumericOperator BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT = BinaryNumericOperator.NONE;

	/**
	 * The cached value of the '{@link #getBinaryNumericOperatorOwned() <em>Binary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinaryNumericOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected BinaryNumericOperator binaryNumericOperatorOwned = BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;

	/**
	 * This is true if the Binary Numeric Operator Owned attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean binaryNumericOperatorOwnedESet;

	/**
	 * The default value of the '{@link #getUnaryNumericOperatorOwned() <em>Unary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnaryNumericOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected static final UnaryNumericOperator UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT = UnaryNumericOperator.NONE;

	/**
	 * The cached value of the '{@link #getUnaryNumericOperatorOwned() <em>Unary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnaryNumericOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected UnaryNumericOperator unaryNumericOperatorOwned = UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;

	/**
	 * This is true if the Unary Numeric Operator Owned attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unaryNumericOperatorOwnedESet;

	/**
	 * The default value of the '{@link #getUnaryBooleanOperatorOwned() <em>Unary Boolean Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnaryBooleanOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected static final UnaryBooleanOperator UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT = UnaryBooleanOperator.NONE;

	/**
	 * The cached value of the '{@link #getUnaryBooleanOperatorOwned() <em>Unary Boolean Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnaryBooleanOperatorOwned()
	 * @generated
	 * @ordered
	 */
	protected UnaryBooleanOperator unaryBooleanOperatorOwned = UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT;

	/**
	 * This is true if the Unary Boolean Operator Owned attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean unaryBooleanOperatorOwnedESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FactorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.FACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getValueOwned() {
		return valueOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueOwned(Value newValueOwned, NotificationChain msgs) {
		Value oldValueOwned = valueOwned;
		valueOwned = newValueOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_OWNED, oldValueOwned, newValueOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueOwned(Value newValueOwned) {
		if (newValueOwned != valueOwned) {
			NotificationChain msgs = null;
			if (valueOwned != null)
				msgs = ((InternalEObject)valueOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_OWNED, null, msgs);
			if (newValueOwned != null)
				msgs = ((InternalEObject)newValueOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_OWNED, null, msgs);
			msgs = basicSetValueOwned(newValueOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_OWNED, newValueOwned, newValueOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value getValueSdOwned() {
		return valueSdOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueSdOwned(Value newValueSdOwned, NotificationChain msgs) {
		Value oldValueSdOwned = valueSdOwned;
		valueSdOwned = newValueSdOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_SD_OWNED, oldValueSdOwned, newValueSdOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueSdOwned(Value newValueSdOwned) {
		if (newValueSdOwned != valueSdOwned) {
			NotificationChain msgs = null;
			if (valueSdOwned != null)
				msgs = ((InternalEObject)valueSdOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_SD_OWNED, null, msgs);
			if (newValueSdOwned != null)
				msgs = ((InternalEObject)newValueSdOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_SD_OWNED, null, msgs);
			msgs = basicSetValueSdOwned(newValueSdOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_SD_OWNED, newValueSdOwned, newValueSdOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryNumericOperator getBinaryNumericOperatorOwned() {
		return binaryNumericOperatorOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinaryNumericOperatorOwned(BinaryNumericOperator newBinaryNumericOperatorOwned) {
		BinaryNumericOperator oldBinaryNumericOperatorOwned = binaryNumericOperatorOwned;
		binaryNumericOperatorOwned = newBinaryNumericOperatorOwned == null ? BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT : newBinaryNumericOperatorOwned;
		boolean oldBinaryNumericOperatorOwnedESet = binaryNumericOperatorOwnedESet;
		binaryNumericOperatorOwnedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED, oldBinaryNumericOperatorOwned, binaryNumericOperatorOwned, !oldBinaryNumericOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBinaryNumericOperatorOwned() {
		BinaryNumericOperator oldBinaryNumericOperatorOwned = binaryNumericOperatorOwned;
		boolean oldBinaryNumericOperatorOwnedESet = binaryNumericOperatorOwnedESet;
		binaryNumericOperatorOwned = BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;
		binaryNumericOperatorOwnedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED, oldBinaryNumericOperatorOwned, BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT, oldBinaryNumericOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBinaryNumericOperatorOwned() {
		return binaryNumericOperatorOwnedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryNumericOperator getUnaryNumericOperatorOwned() {
		return unaryNumericOperatorOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnaryNumericOperatorOwned(UnaryNumericOperator newUnaryNumericOperatorOwned) {
		UnaryNumericOperator oldUnaryNumericOperatorOwned = unaryNumericOperatorOwned;
		unaryNumericOperatorOwned = newUnaryNumericOperatorOwned == null ? UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT : newUnaryNumericOperatorOwned;
		boolean oldUnaryNumericOperatorOwnedESet = unaryNumericOperatorOwnedESet;
		unaryNumericOperatorOwnedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED, oldUnaryNumericOperatorOwned, unaryNumericOperatorOwned, !oldUnaryNumericOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnaryNumericOperatorOwned() {
		UnaryNumericOperator oldUnaryNumericOperatorOwned = unaryNumericOperatorOwned;
		boolean oldUnaryNumericOperatorOwnedESet = unaryNumericOperatorOwnedESet;
		unaryNumericOperatorOwned = UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;
		unaryNumericOperatorOwnedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED, oldUnaryNumericOperatorOwned, UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT, oldUnaryNumericOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnaryNumericOperatorOwned() {
		return unaryNumericOperatorOwnedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryBooleanOperator getUnaryBooleanOperatorOwned() {
		return unaryBooleanOperatorOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnaryBooleanOperatorOwned(UnaryBooleanOperator newUnaryBooleanOperatorOwned) {
		UnaryBooleanOperator oldUnaryBooleanOperatorOwned = unaryBooleanOperatorOwned;
		unaryBooleanOperatorOwned = newUnaryBooleanOperatorOwned == null ? UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT : newUnaryBooleanOperatorOwned;
		boolean oldUnaryBooleanOperatorOwnedESet = unaryBooleanOperatorOwnedESet;
		unaryBooleanOperatorOwnedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED, oldUnaryBooleanOperatorOwned, unaryBooleanOperatorOwned, !oldUnaryBooleanOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUnaryBooleanOperatorOwned() {
		UnaryBooleanOperator oldUnaryBooleanOperatorOwned = unaryBooleanOperatorOwned;
		boolean oldUnaryBooleanOperatorOwnedESet = unaryBooleanOperatorOwnedESet;
		unaryBooleanOperatorOwned = UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT;
		unaryBooleanOperatorOwnedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED, oldUnaryBooleanOperatorOwned, UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT, oldUnaryBooleanOperatorOwnedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUnaryBooleanOperatorOwned() {
		return unaryBooleanOperatorOwnedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.FACTOR__VALUE_OWNED:
				return basicSetValueOwned(null, msgs);
			case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
				return basicSetValueSdOwned(null, msgs);
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
			case AadlBaPackage.FACTOR__VALUE_OWNED:
				return getValueOwned();
			case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
				return getValueSdOwned();
			case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
				return getBinaryNumericOperatorOwned();
			case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
				return getUnaryNumericOperatorOwned();
			case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
				return getUnaryBooleanOperatorOwned();
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
			case AadlBaPackage.FACTOR__VALUE_OWNED:
				setValueOwned((Value)newValue);
				return;
			case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
				setValueSdOwned((Value)newValue);
				return;
			case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
				setBinaryNumericOperatorOwned((BinaryNumericOperator)newValue);
				return;
			case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
				setUnaryNumericOperatorOwned((UnaryNumericOperator)newValue);
				return;
			case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
				setUnaryBooleanOperatorOwned((UnaryBooleanOperator)newValue);
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
			case AadlBaPackage.FACTOR__VALUE_OWNED:
				setValueOwned((Value)null);
				return;
			case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
				setValueSdOwned((Value)null);
				return;
			case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
				unsetBinaryNumericOperatorOwned();
				return;
			case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
				unsetUnaryNumericOperatorOwned();
				return;
			case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
				unsetUnaryBooleanOperatorOwned();
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
			case AadlBaPackage.FACTOR__VALUE_OWNED:
				return valueOwned != null;
			case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
				return valueSdOwned != null;
			case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
				return isSetBinaryNumericOperatorOwned();
			case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
				return isSetUnaryNumericOperatorOwned();
			case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
				return isSetUnaryBooleanOperatorOwned();
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (binaryNumericOperatorOwned: ");
		if (binaryNumericOperatorOwnedESet) result.append(binaryNumericOperatorOwned); else result.append("<unset>");
		result.append(", unaryNumericOperatorOwned: ");
		if (unaryNumericOperatorOwnedESet) result.append(unaryNumericOperatorOwned); else result.append("<unset>");
		result.append(", unaryBooleanOperatorOwned: ");
		if (unaryBooleanOperatorOwnedESet) result.append(unaryBooleanOperatorOwned); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //FactorImpl
