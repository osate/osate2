/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LoopStatementImpl extends BehaviorElementImpl implements LoopStatement {
	/**
	 * The cached value of the '{@link #getBehaviorActionsOwned() <em>Behavior Actions Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 * @ordered
	 */
	protected BehaviorActions behaviorActionsOwned;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.LOOP_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorActions getBehaviorActionsOwned() {
		return behaviorActionsOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehaviorActionsOwned(BehaviorActions newBehaviorActionsOwned, NotificationChain msgs) {
		BehaviorActions oldBehaviorActionsOwned = behaviorActionsOwned;
		behaviorActionsOwned = newBehaviorActionsOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED, oldBehaviorActionsOwned, newBehaviorActionsOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorActionsOwned(BehaviorActions newBehaviorActionsOwned) {
		if (newBehaviorActionsOwned != behaviorActionsOwned) {
			NotificationChain msgs = null;
			if (behaviorActionsOwned != null)
				msgs = ((InternalEObject)behaviorActionsOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			if (newBehaviorActionsOwned != null)
				msgs = ((InternalEObject)newBehaviorActionsOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			msgs = basicSetBehaviorActionsOwned(newBehaviorActionsOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED, newBehaviorActionsOwned, newBehaviorActionsOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return basicSetBehaviorActionsOwned(null, msgs);
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
			case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return getBehaviorActionsOwned();
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
			case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				setBehaviorActionsOwned((BehaviorActions)newValue);
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
			case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				setBehaviorActionsOwned((BehaviorActions)null);
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
			case AadlBaPackage.LOOP_STATEMENT__BEHAVIOR_ACTIONS_OWNED:
				return behaviorActionsOwned != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopStatementImpl
