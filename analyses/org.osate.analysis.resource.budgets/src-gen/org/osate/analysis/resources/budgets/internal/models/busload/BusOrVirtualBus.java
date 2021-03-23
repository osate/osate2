/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 * 
 */
package org.osate.analysis.resources.budgets.internal.models.busload;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus Or Virtual Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundVirtualBuses <em>Bound Virtual Buses</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundConnections <em>Bound Connections</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundBroadcasts <em>Bound Broadcasts</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBusInstance <em>Bus Instance</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getDataOverhead <em>Data Overhead</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus()
 * @model abstract="true"
 * @generated
 */
public interface BusOrVirtualBus extends BusloadElement {
	/**
	 * Returns the value of the '<em><b>Bound Virtual Buses</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Virtual Buses</em>' containment reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BoundVirtualBuses()
	 * @model containment="true"
	 * @generated
	 */
	EList<VirtualBus> getBoundVirtualBuses();

	/**
	 * Returns the value of the '<em><b>Bound Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Connections</em>' containment reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BoundConnections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connection> getBoundConnections();

	/**
	 * Returns the value of the '<em><b>Bound Broadcasts</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Broadcasts</em>' containment reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BoundBroadcasts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Broadcast> getBoundBroadcasts();

	/**
	 * Returns the value of the '<em><b>Bus Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bus Instance</em>' reference.
	 * @see #setBusInstance(ComponentInstance)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BusInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getBusInstance();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBusInstance <em>Bus Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Instance</em>' reference.
	 * @see #getBusInstance()
	 * @generated
	 */
	void setBusInstance(ComponentInstance value);

	/**
	 * Returns the value of the '<em><b>Data Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Overhead</em>' attribute.
	 * @see #setDataOverhead(double)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_DataOverhead()
	 * @model
	 * @generated
	 */
	double getDataOverhead();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getDataOverhead <em>Data Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Overhead</em>' attribute.
	 * @see #getDataOverhead()
	 * @generated
	 */
	void setDataOverhead(double value);

} // BusOrVirtualBus
