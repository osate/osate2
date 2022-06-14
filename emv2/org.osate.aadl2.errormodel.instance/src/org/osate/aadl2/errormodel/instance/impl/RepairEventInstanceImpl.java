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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repair Event Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.RepairEventInstanceImpl#getRepairEvent <em>Repair Event</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.RepairEventInstanceImpl#getEventInitiators <em>Event Initiators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepairEventInstanceImpl extends EMV2InstanceObjectImpl implements RepairEventInstance {
	/**
	 * The cached value of the '{@link #getRepairEvent() <em>Repair Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepairEvent()
	 * @generated
	 * @ordered
	 */
	protected RepairEvent repairEvent;

	/**
	 * The cached value of the '{@link #getEventInitiators() <em>Event Initiators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventInitiators()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstanceEnd> eventInitiators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepairEventInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.REPAIR_EVENT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RepairEvent getRepairEvent() {
		if (repairEvent != null && repairEvent.eIsProxy()) {
			InternalEObject oldRepairEvent = (InternalEObject) repairEvent;
			repairEvent = (RepairEvent) eResolveProxy(oldRepairEvent);
			if (repairEvent != oldRepairEvent) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.REPAIR_EVENT_INSTANCE__REPAIR_EVENT, oldRepairEvent, repairEvent));
				}
			}
		}
		return repairEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepairEvent basicGetRepairEvent() {
		return repairEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepairEvent(RepairEvent newRepairEvent) {
		RepairEvent oldRepairEvent = repairEvent;
		repairEvent = newRepairEvent;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.REPAIR_EVENT_INSTANCE__REPAIR_EVENT, oldRepairEvent, repairEvent));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConnectionInstanceEnd> getEventInitiators() {
		if (eventInitiators == null) {
			eventInitiators = new EObjectResolvingEList<>(ConnectionInstanceEnd.class, this,
					EMV2InstancePackage.REPAIR_EVENT_INSTANCE__EVENT_INITIATORS);
		}
		return eventInitiators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__REPAIR_EVENT:
			if (resolve) {
				return getRepairEvent();
			}
			return basicGetRepairEvent();
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__EVENT_INITIATORS:
			return getEventInitiators();
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
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__REPAIR_EVENT:
			setRepairEvent((RepairEvent) newValue);
			return;
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__EVENT_INITIATORS:
			getEventInitiators().clear();
			getEventInitiators().addAll((Collection<? extends ConnectionInstanceEnd>) newValue);
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
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__REPAIR_EVENT:
			setRepairEvent((RepairEvent) null);
			return;
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__EVENT_INITIATORS:
			getEventInitiators().clear();
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
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__REPAIR_EVENT:
			return repairEvent != null;
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE__EVENT_INITIATORS:
			return eventInitiators != null && !eventInitiators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // RepairEventInstanceImpl
