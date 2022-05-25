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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recover Event Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.RecoverEventInstanceImpl#getRecoverEvent <em>Recover Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecoverEventInstanceImpl extends EventInstanceImpl implements RecoverEventInstance {
	/**
	 * The cached value of the '{@link #getRecoverEvent() <em>Recover Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoverEvent()
	 * @generated
	 * @ordered
	 */
	protected RecoverEvent recoverEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecoverEventInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.RECOVER_EVENT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecoverEvent getRecoverEvent() {
		if (recoverEvent != null && recoverEvent.eIsProxy()) {
			InternalEObject oldRecoverEvent = (InternalEObject) recoverEvent;
			recoverEvent = (RecoverEvent) eResolveProxy(oldRecoverEvent);
			if (recoverEvent != oldRecoverEvent) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.RECOVER_EVENT_INSTANCE__RECOVER_EVENT, oldRecoverEvent, recoverEvent));
				}
			}
		}
		return recoverEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoverEvent basicGetRecoverEvent() {
		return recoverEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecoverEvent(RecoverEvent newRecoverEvent) {
		RecoverEvent oldRecoverEvent = recoverEvent;
		recoverEvent = newRecoverEvent;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.RECOVER_EVENT_INSTANCE__RECOVER_EVENT, oldRecoverEvent, recoverEvent));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EMV2InstancePackage.RECOVER_EVENT_INSTANCE__RECOVER_EVENT:
			if (resolve) {
				return getRecoverEvent();
			}
			return basicGetRecoverEvent();
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
		case EMV2InstancePackage.RECOVER_EVENT_INSTANCE__RECOVER_EVENT:
			setRecoverEvent((RecoverEvent) newValue);
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
		case EMV2InstancePackage.RECOVER_EVENT_INSTANCE__RECOVER_EVENT:
			setRecoverEvent((RecoverEvent) null);
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
		case EMV2InstancePackage.RECOVER_EVENT_INSTANCE__RECOVER_EVENT:
			return recoverEvent != null;
		}
		return super.eIsSet(featureID);
	}

} // RecoverEventInstanceImpl
