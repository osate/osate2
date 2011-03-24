/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl#getLowerBehaviorTime <em>Lower Behavior Time</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl#getUpperBehaviorTime <em>Upper Behavior Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedActionImpl extends ElementImpl implements TimedAction {
	/**
	 * The cached value of the '{@link #getLowerBehaviorTime() <em>Lower Behavior Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBehaviorTime()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTime lowerBehaviorTime;

	/**
	 * This is true if the Lower Behavior Time containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean lowerBehaviorTimeESet;

	/**
	 * The cached value of the '{@link #getUpperBehaviorTime() <em>Upper Behavior Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBehaviorTime()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTime upperBehaviorTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.TIMED_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTime getLowerBehaviorTime() {
		return lowerBehaviorTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLowerBehaviorTime(BehaviorTime newLowerBehaviorTime, NotificationChain msgs) {
		BehaviorTime oldLowerBehaviorTime = lowerBehaviorTime;
		lowerBehaviorTime = newLowerBehaviorTime;
		boolean oldLowerBehaviorTimeESet = lowerBehaviorTimeESet;
		lowerBehaviorTimeESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME, oldLowerBehaviorTime, newLowerBehaviorTime, !oldLowerBehaviorTimeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBehaviorTime(BehaviorTime newLowerBehaviorTime) {
		if (newLowerBehaviorTime != lowerBehaviorTime) {
			NotificationChain msgs = null;
			if (lowerBehaviorTime != null)
				msgs = ((InternalEObject)lowerBehaviorTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME, null, msgs);
			if (newLowerBehaviorTime != null)
				msgs = ((InternalEObject)newLowerBehaviorTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME, null, msgs);
			msgs = basicSetLowerBehaviorTime(newLowerBehaviorTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLowerBehaviorTimeESet = lowerBehaviorTimeESet;
			lowerBehaviorTimeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME, newLowerBehaviorTime, newLowerBehaviorTime, !oldLowerBehaviorTimeESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetLowerBehaviorTime(NotificationChain msgs) {
		BehaviorTime oldLowerBehaviorTime = lowerBehaviorTime;
		lowerBehaviorTime = null;
		boolean oldLowerBehaviorTimeESet = lowerBehaviorTimeESet;
		lowerBehaviorTimeESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME, oldLowerBehaviorTime, null, oldLowerBehaviorTimeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerBehaviorTime() {
		if (lowerBehaviorTime != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)lowerBehaviorTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME, null, msgs);
			msgs = basicUnsetLowerBehaviorTime(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldLowerBehaviorTimeESet = lowerBehaviorTimeESet;
			lowerBehaviorTimeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME, null, null, oldLowerBehaviorTimeESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerBehaviorTime() {
		return lowerBehaviorTimeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTime getUpperBehaviorTime() {
		return upperBehaviorTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpperBehaviorTime(BehaviorTime newUpperBehaviorTime, NotificationChain msgs) {
		BehaviorTime oldUpperBehaviorTime = upperBehaviorTime;
		upperBehaviorTime = newUpperBehaviorTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME, oldUpperBehaviorTime, newUpperBehaviorTime);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBehaviorTime(BehaviorTime newUpperBehaviorTime) {
		if (newUpperBehaviorTime != upperBehaviorTime) {
			NotificationChain msgs = null;
			if (upperBehaviorTime != null)
				msgs = ((InternalEObject)upperBehaviorTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME, null, msgs);
			if (newUpperBehaviorTime != null)
				msgs = ((InternalEObject)newUpperBehaviorTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME, null, msgs);
			msgs = basicSetUpperBehaviorTime(newUpperBehaviorTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME, newUpperBehaviorTime, newUpperBehaviorTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME:
				return basicUnsetLowerBehaviorTime(msgs);
			case AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME:
				return basicSetUpperBehaviorTime(null, msgs);
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
			case AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME:
				return getLowerBehaviorTime();
			case AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME:
				return getUpperBehaviorTime();
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
			case AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME:
				setLowerBehaviorTime((BehaviorTime)newValue);
				return;
			case AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME:
				setUpperBehaviorTime((BehaviorTime)newValue);
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
			case AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME:
				unsetLowerBehaviorTime();
				return;
			case AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME:
				setUpperBehaviorTime((BehaviorTime)null);
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
			case AadlBaPackage.TIMED_ACTION__LOWER_BEHAVIOR_TIME:
				return isSetLowerBehaviorTime();
			case AadlBaPackage.TIMED_ACTION__UPPER_BEHAVIOR_TIME:
				return upperBehaviorTime != null;
		}
		return super.eIsSet(featureID);
	}

} //TimedActionImpl
