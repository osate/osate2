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
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLDetails::Components::Device.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.DeviceType#getOwnedDataPorts <em>Owned Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.DeviceType#getOwnedEventDataPorts <em>Owned Event Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.DeviceType#getOwnedEventPorts <em>Owned Event Port</em>}</li>
 *   <li>{@link org.osate.aadl2.DeviceType#getOwnedBusAccesses <em>Owned Bus Access</em>}</li>
 *   <li>{@link org.osate.aadl2.DeviceType#getOwnedSubprogramAccesses <em>Owned Subprogram Access</em>}</li>
 *   <li>{@link org.osate.aadl2.DeviceType#getOwnedSubprogramGroupAccesses <em>Owned Subprogram Group Access</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getDeviceType()
 * @model
 * @generated
 */
public interface DeviceType extends ComponentType, DeviceClassifier {
	/**
	 * Returns the value of the '<em><b>Owned Data Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DataPort}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Device.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Data Port</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getDeviceType_OwnedDataPort()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<DataPort> getOwnedDataPorts();

	/**
	 * Creates a new {@link org.osate.aadl2.DataPort} and appends it to the '<em><b>Owned Data Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DataPort}.
	 * @see #getOwnedDataPorts()
	 * @generated
	 */
	DataPort createOwnedDataPort();

	/**
	 * Returns the value of the '<em><b>Owned Event Data Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EventDataPort}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Event Data Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Device.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Event Data Port</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getDeviceType_OwnedEventDataPort()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<EventDataPort> getOwnedEventDataPorts();

	/**
	 * Creates a new {@link org.osate.aadl2.EventDataPort} and appends it to the '<em><b>Owned Event Data Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.EventDataPort}.
	 * @see #getOwnedEventDataPorts()
	 * @generated
	 */
	EventDataPort createOwnedEventDataPort();

	/**
	 * Returns the value of the '<em><b>Owned Event Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EventPort}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Event Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Device.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Event Port</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getDeviceType_OwnedEventPort()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<EventPort> getOwnedEventPorts();

	/**
	 * Creates a new {@link org.osate.aadl2.EventPort} and appends it to the '<em><b>Owned Event Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.EventPort}.
	 * @see #getOwnedEventPorts()
	 * @generated
	 */
	EventPort createOwnedEventPort();

	/**
	 * Returns the value of the '<em><b>Owned Bus Access</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.BusAccess}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Bus Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Device.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Bus Access</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getDeviceType_OwnedBusAccess()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<BusAccess> getOwnedBusAccesses();

	/**
	 * Creates a new {@link org.osate.aadl2.BusAccess} and appends it to the '<em><b>Owned Bus Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.BusAccess}.
	 * @see #getOwnedBusAccesses()
	 * @generated
	 */
	BusAccess createOwnedBusAccess();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Access</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramAccess}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Device.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Access</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getDeviceType_OwnedSubprogramAccess()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<SubprogramAccess> getOwnedSubprogramAccesses();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramAccess} and appends it to the '<em><b>Owned Subprogram Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramAccess}.
	 * @see #getOwnedSubprogramAccesses()
	 * @generated
	 */
	SubprogramAccess createOwnedSubprogramAccess();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Group Access</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramGroupAccess}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Group Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Device.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Group Access</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getDeviceType_OwnedSubprogramGroupAccess()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<SubprogramGroupAccess> getOwnedSubprogramGroupAccesses();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramGroupAccess} and appends it to the '<em><b>Owned Subprogram Group Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramGroupAccess}.
	 * @see #getOwnedSubprogramGroupAccesses()
	 * @generated
	 */
	SubprogramGroupAccess createOwnedSubprogramGroupAccess();

} // DeviceType
