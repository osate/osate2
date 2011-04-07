/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl#getLowerIntegerValue <em>Lower Integer Value</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl#getUpperIntegerValue <em>Upper Integer Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegerRangeImpl extends BehaviorElementImpl implements IntegerRange {
	/**
	 * The cached value of the '{@link #getLowerIntegerValue() <em>Lower Integer Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerIntegerValue()
	 * @generated
	 * @ordered
	 */
	protected IntegerValue lowerIntegerValue;

	/**
	 * The cached value of the '{@link #getUpperIntegerValue() <em>Upper Integer Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperIntegerValue()
	 * @generated
	 * @ordered
	 */
	protected IntegerValue upperIntegerValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.INTEGER_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerValue getLowerIntegerValue() {
		return lowerIntegerValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLowerIntegerValue(IntegerValue newLowerIntegerValue, NotificationChain msgs) {
		IntegerValue oldLowerIntegerValue = lowerIntegerValue;
		lowerIntegerValue = newLowerIntegerValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE, oldLowerIntegerValue, newLowerIntegerValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerIntegerValue(IntegerValue newLowerIntegerValue) {
		if (newLowerIntegerValue != lowerIntegerValue) {
			NotificationChain msgs = null;
			if (lowerIntegerValue != null)
				msgs = ((InternalEObject)lowerIntegerValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE, null, msgs);
			if (newLowerIntegerValue != null)
				msgs = ((InternalEObject)newLowerIntegerValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE, null, msgs);
			msgs = basicSetLowerIntegerValue(newLowerIntegerValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE, newLowerIntegerValue, newLowerIntegerValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerValue getUpperIntegerValue() {
		return upperIntegerValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperIntegerValue(IntegerValue newUpperIntegerValue, NotificationChain msgs) {
		IntegerValue oldUpperIntegerValue = upperIntegerValue;
		upperIntegerValue = newUpperIntegerValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE, oldUpperIntegerValue, newUpperIntegerValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperIntegerValue(IntegerValue newUpperIntegerValue) {
		if (newUpperIntegerValue != upperIntegerValue) {
			NotificationChain msgs = null;
			if (upperIntegerValue != null)
				msgs = ((InternalEObject)upperIntegerValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE, null, msgs);
			if (newUpperIntegerValue != null)
				msgs = ((InternalEObject)newUpperIntegerValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE, null, msgs);
			msgs = basicSetUpperIntegerValue(newUpperIntegerValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE, newUpperIntegerValue, newUpperIntegerValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE:
				return basicSetLowerIntegerValue(null, msgs);
			case AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE:
				return basicSetUpperIntegerValue(null, msgs);
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
			case AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE:
				return getLowerIntegerValue();
			case AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE:
				return getUpperIntegerValue();
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
			case AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE:
				setLowerIntegerValue((IntegerValue)newValue);
				return;
			case AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE:
				setUpperIntegerValue((IntegerValue)newValue);
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
			case AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE:
				setLowerIntegerValue((IntegerValue)null);
				return;
			case AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE:
				setUpperIntegerValue((IntegerValue)null);
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
			case AadlBaPackage.INTEGER_RANGE__LOWER_INTEGER_VALUE:
				return lowerIntegerValue != null;
			case AadlBaPackage.INTEGER_RANGE__UPPER_INTEGER_VALUE:
				return upperIntegerValue != null;
		}
		return super.eIsSet(featureID);
	}

} //IntegerRangeImpl
