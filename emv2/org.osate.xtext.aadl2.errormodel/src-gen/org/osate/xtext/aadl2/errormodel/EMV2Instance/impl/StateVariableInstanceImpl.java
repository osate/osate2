/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Variable Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateVariableInstanceImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateVariableInstanceImpl#getCurrentState <em>Current State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateVariableInstanceImpl extends EMV2InstanceObjectImpl implements StateVariableInstance {
	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<StateInstance> states;

	/**
	 * The cached value of the '{@link #getCurrentState() <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected StateInstance currentState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateVariableInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.STATE_VARIABLE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StateInstance> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<StateInstance>(StateInstance.class, this, EMV2InstancePackage.STATE_VARIABLE_INSTANCE__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateInstance getCurrentState() {
		if (currentState != null && currentState.eIsProxy()) {
			InternalEObject oldCurrentState = (InternalEObject)currentState;
			currentState = (StateInstance)eResolveProxy(oldCurrentState);
			if (currentState != oldCurrentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.STATE_VARIABLE_INSTANCE__CURRENT_STATE, oldCurrentState, currentState));
			}
		}
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateInstance basicGetCurrentState() {
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentState(StateInstance newCurrentState) {
		StateInstance oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_VARIABLE_INSTANCE__CURRENT_STATE, oldCurrentState, currentState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__STATES:
				return getStates();
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__CURRENT_STATE:
				if (resolve) return getCurrentState();
				return basicGetCurrentState();
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
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends StateInstance>)newValue);
				return;
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__CURRENT_STATE:
				setCurrentState((StateInstance)newValue);
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
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__STATES:
				getStates().clear();
				return;
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__CURRENT_STATE:
				setCurrentState((StateInstance)null);
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
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__STATES:
				return states != null && !states.isEmpty();
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE__CURRENT_STATE:
				return currentState != null;
		}
		return super.eIsSet(featureID);
	}

} //StateVariableInstanceImpl
