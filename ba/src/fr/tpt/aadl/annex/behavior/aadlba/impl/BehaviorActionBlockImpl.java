/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Action Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl#getBehaviorTimeOwned <em>Behavior Time Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorActionBlockImpl extends ElementImpl implements BehaviorActionBlock {
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
	 * The cached value of the '{@link #getBehaviorTimeOwned() <em>Behavior Time Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorTimeOwned()
	 * @generated
	 * @ordered
	 */
	protected BehaviorTime behaviorTimeOwned;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorActionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_ACTION_BLOCK;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED, oldBehaviorActionsOwned, newBehaviorActionsOwned);
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
				msgs = ((InternalEObject)behaviorActionsOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			if (newBehaviorActionsOwned != null)
				msgs = ((InternalEObject)newBehaviorActionsOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			msgs = basicSetBehaviorActionsOwned(newBehaviorActionsOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED, newBehaviorActionsOwned, newBehaviorActionsOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorTime getBehaviorTimeOwned() {
		return behaviorTimeOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehaviorTimeOwned(BehaviorTime newBehaviorTimeOwned, NotificationChain msgs) {
		BehaviorTime oldBehaviorTimeOwned = behaviorTimeOwned;
		behaviorTimeOwned = newBehaviorTimeOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED, oldBehaviorTimeOwned, newBehaviorTimeOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorTimeOwned(BehaviorTime newBehaviorTimeOwned) {
		if (newBehaviorTimeOwned != behaviorTimeOwned) {
			NotificationChain msgs = null;
			if (behaviorTimeOwned != null)
				msgs = ((InternalEObject)behaviorTimeOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED, null, msgs);
			if (newBehaviorTimeOwned != null)
				msgs = ((InternalEObject)newBehaviorTimeOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED, null, msgs);
			msgs = basicSetBehaviorTimeOwned(newBehaviorTimeOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED, newBehaviorTimeOwned, newBehaviorTimeOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED:
				return basicSetBehaviorActionsOwned(null, msgs);
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED:
				return basicSetBehaviorTimeOwned(null, msgs);
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
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED:
				return getBehaviorActionsOwned();
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED:
				return getBehaviorTimeOwned();
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
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED:
				setBehaviorActionsOwned((BehaviorActions)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED:
				setBehaviorTimeOwned((BehaviorTime)newValue);
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
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED:
				setBehaviorActionsOwned((BehaviorActions)null);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED:
				setBehaviorTimeOwned((BehaviorTime)null);
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
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_ACTIONS_OWNED:
				return behaviorActionsOwned != null;
			case AadlBaPackage.BEHAVIOR_ACTION_BLOCK__BEHAVIOR_TIME_OWNED:
				return behaviorTimeOwned != null;
		}
		return super.eIsSet(featureID);
	}

} //BehaviorActionBlockImpl
