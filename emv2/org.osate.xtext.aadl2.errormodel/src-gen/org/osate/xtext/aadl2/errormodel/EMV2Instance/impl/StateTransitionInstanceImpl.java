/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Transition Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl#getTargetState <em>Target State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl#getStateTransition <em>State Transition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateTransitionInstanceImpl extends EMV2InstanceObjectImpl implements StateTransitionInstance {
	/**
	 * The cached value of the '{@link #getTargetState() <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetState()
	 * @generated
	 * @ordered
	 */
	protected StateInstance targetState;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Literal condition;

	/**
	 * The cached value of the '{@link #getStateTransition() <em>State Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateTransition()
	 * @generated
	 * @ordered
	 */
	protected ErrorBehaviorTransition stateTransition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateTransitionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.STATE_TRANSITION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateInstance getTargetState() {
		if (targetState != null && targetState.eIsProxy()) {
			InternalEObject oldTargetState = (InternalEObject)targetState;
			targetState = (StateInstance)eResolveProxy(oldTargetState);
			if (targetState != oldTargetState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.STATE_TRANSITION_INSTANCE__TARGET_STATE, oldTargetState, targetState));
			}
		}
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateInstance basicGetTargetState() {
		return targetState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetState(StateInstance newTargetState) {
		StateInstance oldTargetState = targetState;
		targetState = newTargetState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_TRANSITION_INSTANCE__TARGET_STATE, oldTargetState, targetState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Literal newCondition, NotificationChain msgs) {
		Literal oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(Literal newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorBehaviorTransition getStateTransition() {
		if (stateTransition != null && stateTransition.eIsProxy()) {
			InternalEObject oldStateTransition = (InternalEObject)stateTransition;
			stateTransition = (ErrorBehaviorTransition)eResolveProxy(oldStateTransition);
			if (stateTransition != oldStateTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.STATE_TRANSITION_INSTANCE__STATE_TRANSITION, oldStateTransition, stateTransition));
			}
		}
		return stateTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorBehaviorTransition basicGetStateTransition() {
		return stateTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStateTransition(ErrorBehaviorTransition newStateTransition) {
		ErrorBehaviorTransition oldStateTransition = stateTransition;
		stateTransition = newStateTransition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_TRANSITION_INSTANCE__STATE_TRANSITION, oldStateTransition, stateTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION:
				return basicSetCondition(null, msgs);
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
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__TARGET_STATE:
				if (resolve) return getTargetState();
				return basicGetTargetState();
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION:
				return getCondition();
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__STATE_TRANSITION:
				if (resolve) return getStateTransition();
				return basicGetStateTransition();
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
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__TARGET_STATE:
				setTargetState((StateInstance)newValue);
				return;
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION:
				setCondition((Literal)newValue);
				return;
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__STATE_TRANSITION:
				setStateTransition((ErrorBehaviorTransition)newValue);
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
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__TARGET_STATE:
				setTargetState((StateInstance)null);
				return;
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION:
				setCondition((Literal)null);
				return;
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__STATE_TRANSITION:
				setStateTransition((ErrorBehaviorTransition)null);
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
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__TARGET_STATE:
				return targetState != null;
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__CONDITION:
				return condition != null;
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE__STATE_TRANSITION:
				return stateTransition != null;
		}
		return super.eIsSet(featureID);
	}

} //StateTransitionInstanceImpl
