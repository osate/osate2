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
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureGroupTypeRename;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Group Type Rename</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeRenameImpl#getRenamedFeatureGroupType <em>Renamed Feature Group Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureGroupTypeRenameImpl extends NamedElementImpl implements FeatureGroupTypeRename {
	/**
	 * The cached value of the '{@link #getRenamedFeatureGroupType() <em>Renamed Feature Group Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenamedFeatureGroupType()
	 * @generated
	 * @ordered
	 */
	protected FeatureGroupType renamedFeatureGroupType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureGroupTypeRenameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFeatureGroupTypeRename();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupType getRenamedFeatureGroupType() throws AssertionError {
		if (renamedFeatureGroupType != null && ((EObject) renamedFeatureGroupType).eIsProxy()) {
			InternalEObject oldRenamedFeatureGroupType = (InternalEObject) renamedFeatureGroupType;
			renamedFeatureGroupType = (FeatureGroupType) eResolveProxy(oldRenamedFeatureGroupType);
			if (renamedFeatureGroupType != oldRenamedFeatureGroupType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FEATURE_GROUP_TYPE_RENAME__RENAMED_FEATURE_GROUP_TYPE,
							oldRenamedFeatureGroupType, renamedFeatureGroupType));
				}
			}
		}
		return renamedFeatureGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupType basicGetRenamedFeatureGroupType() {
		return renamedFeatureGroupType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenamedFeatureGroupType(FeatureGroupType newRenamedFeatureGroupType) {
		FeatureGroupType oldRenamedFeatureGroupType = renamedFeatureGroupType;
		renamedFeatureGroupType = newRenamedFeatureGroupType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FEATURE_GROUP_TYPE_RENAME__RENAMED_FEATURE_GROUP_TYPE, oldRenamedFeatureGroupType,
					renamedFeatureGroupType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME__RENAMED_FEATURE_GROUP_TYPE:
			if (resolve) {
				return getRenamedFeatureGroupType();
			}
			return basicGetRenamedFeatureGroupType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME__RENAMED_FEATURE_GROUP_TYPE:
			setRenamedFeatureGroupType((FeatureGroupType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME__RENAMED_FEATURE_GROUP_TYPE:
			setRenamedFeatureGroupType((FeatureGroupType) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.FEATURE_GROUP_TYPE_RENAME__RENAMED_FEATURE_GROUP_TYPE:
			return renamedFeatureGroupType != null;
		}
		return super.eIsSet(featureID);
	}

} // FeatureGroupTypeRenameImpl
