/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.instance.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl#getState <em>State</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl#getTypeSet <em>Type Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateInstanceImpl extends EMV2InstanceObjectImpl implements StateInstance {
	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected ErrorBehaviorState state;

	/**
	 * The cached value of the '{@link #getTypeSet() <em>Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeSet()
	 * @generated
	 * @ordered
	 */
	protected AnonymousTypeSet typeSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.STATE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorBehaviorState getState() {
		if (state != null && state.eIsProxy()) {
			InternalEObject oldState = (InternalEObject) state;
			state = (ErrorBehaviorState) eResolveProxy(oldState);
			if (state != oldState) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMV2InstancePackage.STATE_INSTANCE__STATE,
							oldState, state));
				}
			}
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorBehaviorState basicGetState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setState(ErrorBehaviorState newState) {
		ErrorBehaviorState oldState = state;
		state = newState;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_INSTANCE__STATE, oldState,
					state));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousTypeSet getTypeSet() {
		return typeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSet(AnonymousTypeSet newTypeSet, NotificationChain msgs) {
		AnonymousTypeSet oldTypeSet = typeSet;
		typeSet = newTypeSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.STATE_INSTANCE__TYPE_SET, oldTypeSet, newTypeSet);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeSet(AnonymousTypeSet newTypeSet) {
		if (newTypeSet != typeSet) {
			NotificationChain msgs = null;
			if (typeSet != null) {
				msgs = ((InternalEObject) typeSet).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.STATE_INSTANCE__TYPE_SET, null, msgs);
			}
			if (newTypeSet != null) {
				msgs = ((InternalEObject) newTypeSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - EMV2InstancePackage.STATE_INSTANCE__TYPE_SET, null, msgs);
			}
			msgs = basicSetTypeSet(newTypeSet, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.STATE_INSTANCE__TYPE_SET,
					newTypeSet, newTypeSet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.STATE_INSTANCE__TYPE_SET:
			return basicSetTypeSet(null, msgs);
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
		case EMV2InstancePackage.STATE_INSTANCE__STATE:
			if (resolve) {
				return getState();
			}
			return basicGetState();
		case EMV2InstancePackage.STATE_INSTANCE__TYPE_SET:
			return getTypeSet();
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
		case EMV2InstancePackage.STATE_INSTANCE__STATE:
			setState((ErrorBehaviorState) newValue);
			return;
		case EMV2InstancePackage.STATE_INSTANCE__TYPE_SET:
			setTypeSet((AnonymousTypeSet) newValue);
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
		case EMV2InstancePackage.STATE_INSTANCE__STATE:
			setState((ErrorBehaviorState) null);
			return;
		case EMV2InstancePackage.STATE_INSTANCE__TYPE_SET:
			setTypeSet((AnonymousTypeSet) null);
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
		case EMV2InstancePackage.STATE_INSTANCE__STATE:
			return state != null;
		case EMV2InstancePackage.STATE_INSTANCE__TYPE_SET:
			return typeSet != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public List<? extends NamedElement> getInstantiatedObjects() {
		return List.of(getState());
	}
} // StateInstanceImpl
