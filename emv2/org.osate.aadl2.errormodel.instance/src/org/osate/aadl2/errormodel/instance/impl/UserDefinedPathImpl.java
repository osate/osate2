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
import org.osate.aadl2.errormodel.instance.PointPropagation;
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
	public PointPropagation getSourcePropagation() {
		if (sourcePropagation != null && sourcePropagation.eIsProxy()) {
			InternalEObject oldSourcePropagation = (InternalEObject) sourcePropagation;
			sourcePropagation = (PointPropagation) eResolveProxy(oldSourcePropagation);
			if (sourcePropagation != oldSourcePropagation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION, oldSourcePropagation,
							sourcePropagation));
				}
			}
		}
		return sourcePropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointPropagation basicGetSourcePropagation() {
		return sourcePropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourcePropagation(PointPropagation newSourcePropagation) {
		PointPropagation oldSourcePropagation = sourcePropagation;
		sourcePropagation = newSourcePropagation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION, oldSourcePropagation,
					sourcePropagation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PointPropagation getDestinationPropagation() {
		if (destinationPropagation != null && destinationPropagation.eIsProxy()) {
			InternalEObject oldDestinationPropagation = (InternalEObject) destinationPropagation;
			destinationPropagation = (PointPropagation) eResolveProxy(oldDestinationPropagation);
			if (destinationPropagation != oldDestinationPropagation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION, oldDestinationPropagation,
							destinationPropagation));
				}
			}
		}
		return destinationPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointPropagation basicGetDestinationPropagation() {
		return destinationPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDestinationPropagation(PointPropagation newDestinationPropagation) {
		PointPropagation oldDestinationPropagation = destinationPropagation;
		destinationPropagation = newDestinationPropagation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION, oldDestinationPropagation,
					destinationPropagation));
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
		case EMV2InstancePackage.USER_DEFINED_PATH__PATH:
			if (resolve) {
				return getPath();
			}
			return basicGetPath();
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			if (resolve) {
				return getSourcePropagation();
			}
			return basicGetSourcePropagation();
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			if (resolve) {
				return getDestinationPropagation();
			}
			return basicGetDestinationPropagation();
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
		case EMV2InstancePackage.USER_DEFINED_PATH__SOURCE_PROPAGATION:
			return sourcePropagation != null;
		case EMV2InstancePackage.USER_DEFINED_PATH__DESTINATION_PROPAGATION:
			return destinationPropagation != null;
		}
		return super.eIsSet(featureID);
	}

} // UserDefinedPathImpl
