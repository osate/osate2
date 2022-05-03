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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Point Propagation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.PointPropagationImpl#getPoint <em>Point</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.PointPropagationImpl#getSourceUserDefinedPaths <em>Source User Defined Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.PointPropagationImpl#getDestinationUserDefinedPaths <em>Destination User Defined Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PointPropagationImpl extends ErrorPropagationInstanceImpl implements PointPropagation {
	/**
	 * The cached value of the '{@link #getPoint() <em>Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoint()
	 * @generated
	 * @ordered
	 */
	protected PropagationPointInstance point;

	/**
	 * The cached value of the '{@link #getSourceUserDefinedPaths() <em>Source User Defined Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceUserDefinedPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<UserDefinedPath> sourceUserDefinedPaths;
	/**
	 * The cached value of the '{@link #getDestinationUserDefinedPaths() <em>Destination User Defined Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationUserDefinedPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<UserDefinedPath> destinationUserDefinedPaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointPropagationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.POINT_PROPAGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropagationPointInstance getPoint() {
		if (point != null && point.eIsProxy()) {
			InternalEObject oldPoint = (InternalEObject) point;
			point = (PropagationPointInstance) eResolveProxy(oldPoint);
			if (point != oldPoint) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.POINT_PROPAGATION__POINT, oldPoint, point));
				}
			}
		}
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationPointInstance basicGetPoint() {
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPoint(PropagationPointInstance newPoint) {
		PropagationPointInstance oldPoint = point;
		point = newPoint;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.POINT_PROPAGATION__POINT,
					oldPoint, point));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserDefinedPath> getSourceUserDefinedPaths() {
		if (sourceUserDefinedPaths == null) {
			sourceUserDefinedPaths = new EObjectWithInverseResolvingEList<>(UserDefinedPath.class, this,
					EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS,
					EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION);
		}
		return sourceUserDefinedPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserDefinedPath> getDestinationUserDefinedPaths() {
		if (destinationUserDefinedPaths == null) {
			destinationUserDefinedPaths = new EObjectWithInverseResolvingEList<>(UserDefinedPath.class,
					this, EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS,
					EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION);
		}
		return destinationUserDefinedPaths;
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
		case EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSourceUserDefinedPaths()).basicAdd(otherEnd,
					msgs);
		case EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDestinationUserDefinedPaths())
					.basicAdd(otherEnd, msgs);
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
		case EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS:
			return ((InternalEList<?>) getSourceUserDefinedPaths()).basicRemove(otherEnd, msgs);
		case EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS:
			return ((InternalEList<?>) getDestinationUserDefinedPaths()).basicRemove(otherEnd, msgs);
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
		case EMV2InstancePackage.POINT_PROPAGATION__POINT:
			if (resolve) {
				return getPoint();
			}
			return basicGetPoint();
		case EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS:
			return getSourceUserDefinedPaths();
		case EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS:
			return getDestinationUserDefinedPaths();
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
		case EMV2InstancePackage.POINT_PROPAGATION__POINT:
			setPoint((PropagationPointInstance) newValue);
			return;
		case EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS:
			getSourceUserDefinedPaths().clear();
			getSourceUserDefinedPaths().addAll((Collection<? extends UserDefinedPath>) newValue);
			return;
		case EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS:
			getDestinationUserDefinedPaths().clear();
			getDestinationUserDefinedPaths().addAll((Collection<? extends UserDefinedPath>) newValue);
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
		case EMV2InstancePackage.POINT_PROPAGATION__POINT:
			setPoint((PropagationPointInstance) null);
			return;
		case EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS:
			getSourceUserDefinedPaths().clear();
			return;
		case EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS:
			getDestinationUserDefinedPaths().clear();
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
		case EMV2InstancePackage.POINT_PROPAGATION__POINT:
			return point != null;
		case EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS:
			return sourceUserDefinedPaths != null && !sourceUserDefinedPaths.isEmpty();
		case EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS:
			return destinationUserDefinedPaths != null && !destinationUserDefinedPaths.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // PointPropagationImpl
