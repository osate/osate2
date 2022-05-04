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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.errormodel.instance.ConnectionEndPropagation;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.instance.ConnectionInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ConnectionPathImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ConnectionPathImpl#getSourcePropagations <em>Source Propagations</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.ConnectionPathImpl#getDestinationPropagations <em>Destination Propagations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionPathImpl extends EMV2InstanceObjectImpl implements ConnectionPath {
	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstance connection;

	/**
	 * The cached value of the '{@link #getSourcePropagations() <em>Source Propagations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePropagations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionEndPropagation> sourcePropagations;

	/**
	 * The cached value of the '{@link #getDestinationPropagations() <em>Destination Propagations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPropagations()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionEndPropagation> destinationPropagations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.CONNECTION_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionInstance getConnection() {
		if (connection != null && connection.eIsProxy()) {
			InternalEObject oldConnection = (InternalEObject) connection;
			connection = (ConnectionInstance) eResolveProxy(oldConnection);
			if (connection != oldConnection) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.CONNECTION_PATH__CONNECTION, oldConnection, connection));
				}
			}
		}
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstance basicGetConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnection(ConnectionInstance newConnection) {
		ConnectionInstance oldConnection = connection;
		connection = newConnection;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.CONNECTION_PATH__CONNECTION,
					oldConnection, connection));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConnectionEndPropagation> getSourcePropagations() {
		if (sourcePropagations == null) {
			sourcePropagations = new EObjectWithInverseEList.ManyInverse<>(
					ConnectionEndPropagation.class, this, EMV2InstancePackage.CONNECTION_PATH__SOURCE_PROPAGATIONS,
					EMV2InstancePackage.CONNECTION_END_PROPAGATION__SOURCE_CONNECTION_PATHS);
		}
		return sourcePropagations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConnectionEndPropagation> getDestinationPropagations() {
		if (destinationPropagations == null) {
			destinationPropagations = new EObjectWithInverseEList.ManyInverse<>(
					ConnectionEndPropagation.class, this, EMV2InstancePackage.CONNECTION_PATH__DESTINATION_PROPAGATIONS,
					EMV2InstancePackage.CONNECTION_END_PROPAGATION__DESTINATION_CONNECTION_PATHS);
		}
		return destinationPropagations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ErrorPropagationInstance getSourcePropagation() {
		return getSourcePropagations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ErrorPropagationInstance getDestinationPropagation() {
		return getDestinationPropagations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.CONNECTION_PATH__SOURCE_PROPAGATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSourcePropagations()).basicAdd(otherEnd,
					msgs);
		case EMV2InstancePackage.CONNECTION_PATH__DESTINATION_PROPAGATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDestinationPropagations()).basicAdd(otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.CONNECTION_PATH__SOURCE_PROPAGATIONS:
			return ((InternalEList<?>) getSourcePropagations()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.CONNECTION_PATH__DESTINATION_PROPAGATIONS:
			return ((InternalEList<?>) getDestinationPropagations()).basicRemove(otherEnd, msgs);
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
		case EMV2InstancePackage.CONNECTION_PATH__CONNECTION:
			if (resolve) {
				return getConnection();
			}
			return basicGetConnection();
		case EMV2InstancePackage.CONNECTION_PATH__SOURCE_PROPAGATIONS:
			return getSourcePropagations();
		case EMV2InstancePackage.CONNECTION_PATH__DESTINATION_PROPAGATIONS:
			return getDestinationPropagations();
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
		case EMV2InstancePackage.CONNECTION_PATH__CONNECTION:
			setConnection((ConnectionInstance) newValue);
			return;
		case EMV2InstancePackage.CONNECTION_PATH__SOURCE_PROPAGATIONS:
			getSourcePropagations().clear();
			getSourcePropagations().addAll((Collection<? extends ConnectionEndPropagation>) newValue);
			return;
		case EMV2InstancePackage.CONNECTION_PATH__DESTINATION_PROPAGATIONS:
			getDestinationPropagations().clear();
			getDestinationPropagations().addAll((Collection<? extends ConnectionEndPropagation>) newValue);
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
		case EMV2InstancePackage.CONNECTION_PATH__CONNECTION:
			setConnection((ConnectionInstance) null);
			return;
		case EMV2InstancePackage.CONNECTION_PATH__SOURCE_PROPAGATIONS:
			getSourcePropagations().clear();
			return;
		case EMV2InstancePackage.CONNECTION_PATH__DESTINATION_PROPAGATIONS:
			getDestinationPropagations().clear();
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
		case EMV2InstancePackage.CONNECTION_PATH__CONNECTION:
			return connection != null;
		case EMV2InstancePackage.CONNECTION_PATH__SOURCE_PROPAGATIONS:
			return sourcePropagations != null && !sourcePropagations.isEmpty();
		case EMV2InstancePackage.CONNECTION_PATH__DESTINATION_PROPAGATIONS:
			return destinationPropagations != null && !destinationPropagations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ConnectionPathImpl
