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
package org.osate.aadl2.errormodel.instance;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repair Event Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.RepairEventInstance#getRepairEvent <em>Repair Event</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.RepairEventInstance#getEventInitiators <em>Event Initiators</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getRepairEventInstance()
 * @model
 * @generated
 */
public interface RepairEventInstance extends EventInstance {
	/**
	 * Returns the value of the '<em><b>Repair Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repair Event</em>' reference.
	 * @see #setRepairEvent(RepairEvent)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getRepairEventInstance_RepairEvent()
	 * @model
	 * @generated
	 */
	RepairEvent getRepairEvent();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.RepairEventInstance#getRepairEvent <em>Repair Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repair Event</em>' reference.
	 * @see #getRepairEvent()
	 * @generated
	 */
	void setRepairEvent(RepairEvent value);

	/**
	 * Returns the value of the '<em><b>Event Initiators</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionInstanceEnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Initiators</em>' reference list.
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getRepairEventInstance_EventInitiators()
	 * @model
	 * @generated
	 */
	EList<ConnectionInstanceEnd> getEventInitiators();

} // RepairEventInstance
