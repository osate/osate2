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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getTransitionIdentifier <em>Transition Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getSourceStateIdentifiers <em>Source State Identifiers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getDestinationStateIdentifier <em>Destination State Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getBehaviorActionBlockOwned <em>Behavior Action Block Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorTransitionImpl extends ElementImpl implements BehaviorTransition {
	/**
	 * The cached value of the '{@link #getTransitionIdentifier() <em>Transition Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier transitionIdentifier;

	/**
	 * The cached value of the '{@link #getSourceStateIdentifiers() <em>Source State Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceStateIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<Identifier> sourceStateIdentifiers;

	/**
	 * The cached value of the '{@link #getBehaviorConditionOwned() <em>Behavior Condition Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorConditionOwned()
	 * @generated
	 * @ordered
	 */
	protected BehaviorCondition behaviorConditionOwned;

	/**
	 * The cached value of the '{@link #getDestinationStateIdentifier() <em>Destination State Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationStateIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier destinationStateIdentifier;

	/**
	 * The cached value of the '{@link #getBehaviorActionBlockOwned() <em>Behavior Action Block Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorActionBlockOwned()
	 * @generated
	 * @ordered
	 */
	protected BehaviorActionBlock behaviorActionBlockOwned;

	/**
	 * The cached value of the '{@link #getBehaviorTransitionPriority() <em>Behavior Transition Priority</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorTransitionPriority()
	 * @generated
	 * @ordered
	 */
	protected Numeral behaviorTransitionPriority;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getTransitionIdentifier() {
		return transitionIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransitionIdentifier(Identifier newTransitionIdentifier, NotificationChain msgs) {
		Identifier oldTransitionIdentifier = transitionIdentifier;
		transitionIdentifier = newTransitionIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, oldTransitionIdentifier, newTransitionIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionIdentifier(Identifier newTransitionIdentifier) {
		if (newTransitionIdentifier != transitionIdentifier) {
			NotificationChain msgs = null;
			if (transitionIdentifier != null)
				msgs = ((InternalEObject)transitionIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, null, msgs);
			if (newTransitionIdentifier != null)
				msgs = ((InternalEObject)newTransitionIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, null, msgs);
			msgs = basicSetTransitionIdentifier(newTransitionIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, newTransitionIdentifier, newTransitionIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Identifier> getSourceStateIdentifiers() {
		if (sourceStateIdentifiers == null) {
			sourceStateIdentifiers = new EObjectContainmentEList.Unsettable<Identifier>(Identifier.class, this, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS);
		}
		return sourceStateIdentifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSourceStateIdentifiers() {
		if (sourceStateIdentifiers != null) ((InternalEList.Unsettable<?>)sourceStateIdentifiers).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSourceStateIdentifiers() {
		return sourceStateIdentifiers != null && ((InternalEList.Unsettable<?>)sourceStateIdentifiers).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorCondition getBehaviorConditionOwned() {
		return behaviorConditionOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehaviorConditionOwned(BehaviorCondition newBehaviorConditionOwned, NotificationChain msgs) {
		BehaviorCondition oldBehaviorConditionOwned = behaviorConditionOwned;
		behaviorConditionOwned = newBehaviorConditionOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, oldBehaviorConditionOwned, newBehaviorConditionOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorConditionOwned(BehaviorCondition newBehaviorConditionOwned) {
		if (newBehaviorConditionOwned != behaviorConditionOwned) {
			NotificationChain msgs = null;
			if (behaviorConditionOwned != null)
				msgs = ((InternalEObject)behaviorConditionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, null, msgs);
			if (newBehaviorConditionOwned != null)
				msgs = ((InternalEObject)newBehaviorConditionOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, null, msgs);
			msgs = basicSetBehaviorConditionOwned(newBehaviorConditionOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, newBehaviorConditionOwned, newBehaviorConditionOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getDestinationStateIdentifier() {
		return destinationStateIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestinationStateIdentifier(Identifier newDestinationStateIdentifier, NotificationChain msgs) {
		Identifier oldDestinationStateIdentifier = destinationStateIdentifier;
		destinationStateIdentifier = newDestinationStateIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, oldDestinationStateIdentifier, newDestinationStateIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationStateIdentifier(Identifier newDestinationStateIdentifier) {
		if (newDestinationStateIdentifier != destinationStateIdentifier) {
			NotificationChain msgs = null;
			if (destinationStateIdentifier != null)
				msgs = ((InternalEObject)destinationStateIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, null, msgs);
			if (newDestinationStateIdentifier != null)
				msgs = ((InternalEObject)newDestinationStateIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, null, msgs);
			msgs = basicSetDestinationStateIdentifier(newDestinationStateIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, newDestinationStateIdentifier, newDestinationStateIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorActionBlock getBehaviorActionBlockOwned() {
		return behaviorActionBlockOwned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehaviorActionBlockOwned(BehaviorActionBlock newBehaviorActionBlockOwned, NotificationChain msgs) {
		BehaviorActionBlock oldBehaviorActionBlockOwned = behaviorActionBlockOwned;
		behaviorActionBlockOwned = newBehaviorActionBlockOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED, oldBehaviorActionBlockOwned, newBehaviorActionBlockOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorActionBlockOwned(BehaviorActionBlock newBehaviorActionBlockOwned) {
		if (newBehaviorActionBlockOwned != behaviorActionBlockOwned) {
			NotificationChain msgs = null;
			if (behaviorActionBlockOwned != null)
				msgs = ((InternalEObject)behaviorActionBlockOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED, null, msgs);
			if (newBehaviorActionBlockOwned != null)
				msgs = ((InternalEObject)newBehaviorActionBlockOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED, null, msgs);
			msgs = basicSetBehaviorActionBlockOwned(newBehaviorActionBlockOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED, newBehaviorActionBlockOwned, newBehaviorActionBlockOwned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Numeral getBehaviorTransitionPriority() {
		if (behaviorTransitionPriority != null && ((EObject)behaviorTransitionPriority).eIsProxy()) {
			InternalEObject oldBehaviorTransitionPriority = (InternalEObject)behaviorTransitionPriority;
			behaviorTransitionPriority = (Numeral)eResolveProxy(oldBehaviorTransitionPriority);
			if (behaviorTransitionPriority != oldBehaviorTransitionPriority) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, oldBehaviorTransitionPriority, behaviorTransitionPriority));
			}
		}
		return behaviorTransitionPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Numeral basicGetBehaviorTransitionPriority() {
		return behaviorTransitionPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorTransitionPriority(Numeral newBehaviorTransitionPriority) {
		Numeral oldBehaviorTransitionPriority = behaviorTransitionPriority;
		behaviorTransitionPriority = newBehaviorTransitionPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, oldBehaviorTransitionPriority, behaviorTransitionPriority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
				return basicSetTransitionIdentifier(null, msgs);
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
				return ((InternalEList<?>)getSourceStateIdentifiers()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
				return basicSetBehaviorConditionOwned(null, msgs);
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
				return basicSetDestinationStateIdentifier(null, msgs);
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED:
				return basicSetBehaviorActionBlockOwned(null, msgs);
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
				return getTransitionIdentifier();
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
				return getSourceStateIdentifiers();
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
				return getBehaviorConditionOwned();
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
				return getDestinationStateIdentifier();
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED:
				return getBehaviorActionBlockOwned();
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
				if (resolve) return getBehaviorTransitionPriority();
				return basicGetBehaviorTransitionPriority();
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
				setTransitionIdentifier((Identifier)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
				getSourceStateIdentifiers().clear();
				getSourceStateIdentifiers().addAll((Collection<? extends Identifier>)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
				setBehaviorConditionOwned((BehaviorCondition)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
				setDestinationStateIdentifier((Identifier)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED:
				setBehaviorActionBlockOwned((BehaviorActionBlock)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
				setBehaviorTransitionPriority((Numeral)newValue);
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
				setTransitionIdentifier((Identifier)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
				unsetSourceStateIdentifiers();
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
				setBehaviorConditionOwned((BehaviorCondition)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
				setDestinationStateIdentifier((Identifier)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED:
				setBehaviorActionBlockOwned((BehaviorActionBlock)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
				setBehaviorTransitionPriority((Numeral)null);
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
				return transitionIdentifier != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
				return isSetSourceStateIdentifiers();
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
				return behaviorConditionOwned != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
				return destinationStateIdentifier != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTION_BLOCK_OWNED:
				return behaviorActionBlockOwned != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
				return behaviorTransitionPriority != null;
		}
		return super.eIsSet(featureID);
	}

} //BehaviorTransitionImpl
