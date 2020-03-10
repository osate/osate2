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
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance;

import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Synchronization Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateSynchronizationInstanceImpl#getTargetState <em>Target State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateSynchronizationInstanceImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateSynchronizationInstanceImpl#getStateSynchronization <em>State Synchronization</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateSynchronizationInstanceImpl extends EMV2InstanceObjectImpl implements StateSynchronizationInstance {
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
	 * The cached value of the '{@link #getStateSynchronization() <em>State Synchronization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateSynchronization()
	 * @generated
	 * @ordered
	 */
	protected CompositeState stateSynchronization;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateSynchronizationInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.STATE_SYNCHRONIZATION_INSTANCE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE, oldTargetState, targetState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE, oldTargetState, targetState));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeState getStateSynchronization() {
		if (stateSynchronization != null && stateSynchronization.eIsProxy()) {
			InternalEObject oldStateSynchronization = (InternalEObject)stateSynchronization;
			stateSynchronization = (CompositeState)eResolveProxy(oldStateSynchronization);
			if (stateSynchronization != oldStateSynchronization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION, oldStateSynchronization, stateSynchronization));
			}
		}
		return stateSynchronization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState basicGetStateSynchronization() {
		return stateSynchronization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStateSynchronization(CompositeState newStateSynchronization) {
		CompositeState oldStateSynchronization = stateSynchronization;
		stateSynchronization = newStateSynchronization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION, oldStateSynchronization, stateSynchronization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION:
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
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE:
				if (resolve) return getTargetState();
				return basicGetTargetState();
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION:
				return getCondition();
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION:
				if (resolve) return getStateSynchronization();
				return basicGetStateSynchronization();
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
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE:
				setTargetState((StateInstance)newValue);
				return;
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION:
				setCondition((Literal)newValue);
				return;
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION:
				setStateSynchronization((CompositeState)newValue);
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
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE:
				setTargetState((StateInstance)null);
				return;
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION:
				setCondition((Literal)null);
				return;
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION:
				setStateSynchronization((CompositeState)null);
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
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE:
				return targetState != null;
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__CONDITION:
				return condition != null;
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION:
				return stateSynchronization != null;
		}
		return super.eIsSet(featureID);
	}

} //StateSynchronizationInstanceImpl
