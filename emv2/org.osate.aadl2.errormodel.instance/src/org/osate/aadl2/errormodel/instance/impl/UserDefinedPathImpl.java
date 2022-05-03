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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Defined Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl#getSourcePoint <em>Source Point</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl#getDestinationPoint <em>Destination Point</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl#getSourcePropagation <em>Source Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl#getDestinationPropagation <em>Destination Propagation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserDefinedPathImpl extends EMV2InstanceObjectImpl implements UserDefinedPath {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected PropagationPath path;

	/**
	 * The cached value of the '{@link #getSourcePoint() <em>Source Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePoint()
	 * @generated
	 * @ordered
	 */
	protected PropagationPointInstance sourcePoint;

	/**
	 * The cached value of the '{@link #getDestinationPoint() <em>Destination Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPoint()
	 * @generated
	 * @ordered
	 */
	protected PropagationPointInstance destinationPoint;

	/**
	 * The cached value of the '{@link #getSourcePropagation() <em>Source Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePropagation()
	 * @generated
	 * @ordered
	 */
	protected PointPropagation sourcePropagation;

	/**
	 * The cached value of the '{@link #getDestinationPropagation() <em>Destination Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationPropagation()
	 * @generated
	 * @ordered
	 */
	protected PointPropagation destinationPropagation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserDefinedPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMV2InstancePackage.Literals.USER_DEFINED_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropagationPath getPath() {
		if (path != null && path.eIsProxy()) {
			InternalEObject oldPath = (InternalEObject) path;
			path = (PropagationPath) eResolveProxy(oldPath);
			if (path != oldPath) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.USER_DEFINED_PATH__PATH, oldPath, path));
				}
			}
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationPath basicGetPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPath(PropagationPath newPath) {
		PropagationPath oldPath = path;
		path = newPath;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.USER_DEFINED_PATH__PATH, oldPath,
					path));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropagationPointInstance getSourcePoint() {
		if (sourcePoint != null && sourcePoint.eIsProxy()) {
			InternalEObject oldSourcePoint = (InternalEObject) sourcePoint;
			sourcePoint = (PropagationPointInstance) eResolveProxy(oldSourcePoint);
			if (sourcePoint != oldSourcePoint) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_POINT, oldSourcePoint, sourcePoint));
				}
			}
		}
		return sourcePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationPointInstance basicGetSourcePoint() {
		return sourcePoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourcePoint(PropagationPointInstance newSourcePoint) {
		PropagationPointInstance oldSourcePoint = sourcePoint;
		sourcePoint = newSourcePoint;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_POINT,
					oldSourcePoint, sourcePoint));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropagationPointInstance getDestinationPoint() {
		if (destinationPoint != null && destinationPoint.eIsProxy()) {
			InternalEObject oldDestinationPoint = (InternalEObject) destinationPoint;
			destinationPoint = (PropagationPointInstance) eResolveProxy(oldDestinationPoint);
			if (destinationPoint != oldDestinationPoint) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_POINT, oldDestinationPoint,
							destinationPoint));
				}
			}
		}
		return destinationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropagationPointInstance basicGetDestinationPoint() {
		return destinationPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDestinationPoint(PropagationPointInstance newDestinationPoint) {
		PropagationPointInstance oldDestinationPoint = destinationPoint;
		destinationPoint = newDestinationPoint;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_POINT, oldDestinationPoint, destinationPoint));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PointPropagation getSourcePropagation() {
		return sourcePropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePropagation(PointPropagation newSourcePropagation, NotificationChain msgs) {
		PointPropagation oldSourcePropagation = sourcePropagation;
		sourcePropagation = newSourcePropagation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION, oldSourcePropagation,
					newSourcePropagation);
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
	public void setSourcePropagation(PointPropagation newSourcePropagation) {
		if (newSourcePropagation != sourcePropagation) {
			NotificationChain msgs = null;
			if (sourcePropagation != null) {
				msgs = ((InternalEObject) sourcePropagation).eInverseRemove(this,
						EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS, PointPropagation.class, msgs);
			}
			if (newSourcePropagation != null) {
				msgs = ((InternalEObject) newSourcePropagation).eInverseAdd(this,
						EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS, PointPropagation.class, msgs);
			}
			msgs = basicSetSourcePropagation(newSourcePropagation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION, newSourcePropagation,
					newSourcePropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PointPropagation getDestinationPropagation() {
		return destinationPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestinationPropagation(PointPropagation newDestinationPropagation,
			NotificationChain msgs) {
		PointPropagation oldDestinationPropagation = destinationPropagation;
		destinationPropagation = newDestinationPropagation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION, oldDestinationPropagation,
					newDestinationPropagation);
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
	public void setDestinationPropagation(PointPropagation newDestinationPropagation) {
		if (newDestinationPropagation != destinationPropagation) {
			NotificationChain msgs = null;
			if (destinationPropagation != null) {
				msgs = ((InternalEObject) destinationPropagation).eInverseRemove(this,
						EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS, PointPropagation.class,
						msgs);
			}
			if (newDestinationPropagation != null) {
				msgs = ((InternalEObject) newDestinationPropagation).eInverseAdd(this,
						EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS, PointPropagation.class,
						msgs);
			}
			msgs = basicSetDestinationPropagation(newDestinationPropagation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION, newDestinationPropagation,
					newDestinationPropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			if (sourcePropagation != null) {
				msgs = ((InternalEObject) sourcePropagation).eInverseRemove(this,
						EMV2InstancePackage.POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS, PointPropagation.class, msgs);
			}
			return basicSetSourcePropagation((PointPropagation) otherEnd, msgs);
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			if (destinationPropagation != null) {
				msgs = ((InternalEObject) destinationPropagation).eInverseRemove(this,
						EMV2InstancePackage.POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS, PointPropagation.class,
						msgs);
			}
			return basicSetDestinationPropagation((PointPropagation) otherEnd, msgs);
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
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			return basicSetSourcePropagation(null, msgs);
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			return basicSetDestinationPropagation(null, msgs);
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
		case EMV2InstancePackage.USER_DEFINED_PATH__PATH:
			if (resolve) {
				return getPath();
			}
			return basicGetPath();
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_POINT:
			if (resolve) {
				return getSourcePoint();
			}
			return basicGetSourcePoint();
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_POINT:
			if (resolve) {
				return getDestinationPoint();
			}
			return basicGetDestinationPoint();
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			return getSourcePropagation();
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			return getDestinationPropagation();
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
		case EMV2InstancePackage.USER_DEFINED_PATH__PATH:
			setPath((PropagationPath) newValue);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_POINT:
			setSourcePoint((PropagationPointInstance) newValue);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_POINT:
			setDestinationPoint((PropagationPointInstance) newValue);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			setSourcePropagation((PointPropagation) newValue);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			setDestinationPropagation((PointPropagation) newValue);
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
		case EMV2InstancePackage.USER_DEFINED_PATH__PATH:
			setPath((PropagationPath) null);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_POINT:
			setSourcePoint((PropagationPointInstance) null);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_POINT:
			setDestinationPoint((PropagationPointInstance) null);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			setSourcePropagation((PointPropagation) null);
			return;
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			setDestinationPropagation((PointPropagation) null);
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
		case EMV2InstancePackage.USER_DEFINED_PATH__PATH:
			return path != null;
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_POINT:
			return sourcePoint != null;
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_POINT:
			return destinationPoint != null;
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			return sourcePropagation != null;
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			return destinationPropagation != null;
		}
		return super.eIsSet(featureID);
	}

} // UserDefinedPathImpl
