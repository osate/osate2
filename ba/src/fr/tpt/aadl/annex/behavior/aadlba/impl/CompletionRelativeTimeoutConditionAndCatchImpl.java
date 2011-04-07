/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion Relative Timeout Condition And Catch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutConditionAndCatchImpl#getIntegerValueOwned <em>Integer Value Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutConditionAndCatchImpl#getUnitIdentifier <em>Unit Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletionRelativeTimeoutConditionAndCatchImpl extends BehaviorElementImpl implements CompletionRelativeTimeoutConditionAndCatch {
	/**
	 * The cached value of the '{@link #getIntegerValueOwned() <em>Integer Value Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerValueOwned()
	 * @generated
	 * @ordered
	 */
	protected IntegerValue integerValueOwned;

	/**
	 * The cached value of the '{@link #getUnitIdentifier() <em>Unit Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier unitIdentifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletionRelativeTimeoutConditionAndCatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerValue getIntegerValueOwned() {
		return integerValueOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntegerValueOwned(IntegerValue newIntegerValueOwned, NotificationChain msgs) {
		IntegerValue oldIntegerValueOwned = integerValueOwned;
		integerValueOwned = newIntegerValueOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED, oldIntegerValueOwned, newIntegerValueOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerValueOwned(IntegerValue newIntegerValueOwned) {
		if (newIntegerValueOwned != integerValueOwned) {
			NotificationChain msgs = null;
			if (integerValueOwned != null)
				msgs = ((InternalEObject)integerValueOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED, null, msgs);
			if (newIntegerValueOwned != null)
				msgs = ((InternalEObject)newIntegerValueOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED, null, msgs);
			msgs = basicSetIntegerValueOwned(newIntegerValueOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED, newIntegerValueOwned, newIntegerValueOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getUnitIdentifier() {
		return unitIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitIdentifier(Identifier newUnitIdentifier, NotificationChain msgs) {
		Identifier oldUnitIdentifier = unitIdentifier;
		unitIdentifier = newUnitIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER, oldUnitIdentifier, newUnitIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitIdentifier(Identifier newUnitIdentifier) {
		if (newUnitIdentifier != unitIdentifier) {
			NotificationChain msgs = null;
			if (unitIdentifier != null)
				msgs = ((InternalEObject)unitIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER, null, msgs);
			if (newUnitIdentifier != null)
				msgs = ((InternalEObject)newUnitIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER, null, msgs);
			msgs = basicSetUnitIdentifier(newUnitIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER, newUnitIdentifier, newUnitIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED:
				return basicSetIntegerValueOwned(null, msgs);
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER:
				return basicSetUnitIdentifier(null, msgs);
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
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED:
				return getIntegerValueOwned();
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER:
				return getUnitIdentifier();
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
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED:
				setIntegerValueOwned((IntegerValue)newValue);
				return;
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER:
				setUnitIdentifier((Identifier)newValue);
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
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED:
				setIntegerValueOwned((IntegerValue)null);
				return;
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER:
				setUnitIdentifier((Identifier)null);
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
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED:
				return integerValueOwned != null;
			case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER:
				return unitIdentifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BehaviorTime.class) {
			switch (derivedFeatureID) {
				case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED: return AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED;
				case AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER: return AadlBaPackage.BEHAVIOR_TIME__UNIT_IDENTIFIER;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BehaviorTime.class) {
			switch (baseFeatureID) {
				case AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED: return AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__INTEGER_VALUE_OWNED;
				case AadlBaPackage.BEHAVIOR_TIME__UNIT_IDENTIFIER: return AadlBaPackage.COMPLETION_RELATIVE_TIMEOUT_CONDITION_AND_CATCH__UNIT_IDENTIFIER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CompletionRelativeTimeoutConditionAndCatchImpl
