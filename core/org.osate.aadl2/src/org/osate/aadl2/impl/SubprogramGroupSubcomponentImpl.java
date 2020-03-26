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
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subprogram Group Subcomponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubprogramGroupSubcomponentImpl#getSubcomponentType <em>Subcomponent Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubprogramGroupSubcomponentImpl#getSubprogramGroupSubcomponentType <em>Subprogram Group Subcomponent Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubprogramGroupSubcomponentImpl extends SubcomponentImpl implements SubprogramGroupSubcomponent {
	/**
	 * The cached value of the '{@link #getSubprogramGroupSubcomponentType() <em>Subprogram Group Subcomponent Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprogramGroupSubcomponentType()
	 * @generated
	 * @ordered
	 */
	protected SubprogramGroupSubcomponentType subprogramGroupSubcomponentType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubprogramGroupSubcomponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubprogramGroupSubcomponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentType getSubcomponentType() {
		SubcomponentType subcomponentType = basicGetSubcomponentType();
		return subcomponentType != null && ((EObject) subcomponentType).eIsProxy()
				? (SubcomponentType) eResolveProxy((InternalEObject) subcomponentType)
				: subcomponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentType basicGetSubcomponentType() {
		if (eIsSet(Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE)) {
			return basicGetSubprogramGroupSubcomponentType();
		}
		return super.basicGetSubcomponentType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupSubcomponentType getSubprogramGroupSubcomponentType() {
		if (subprogramGroupSubcomponentType != null && ((EObject) subprogramGroupSubcomponentType).eIsProxy()) {
			InternalEObject oldSubprogramGroupSubcomponentType = (InternalEObject) subprogramGroupSubcomponentType;
			subprogramGroupSubcomponentType = (SubprogramGroupSubcomponentType) eResolveProxy(
					oldSubprogramGroupSubcomponentType);
			if (subprogramGroupSubcomponentType != oldSubprogramGroupSubcomponentType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE,
							oldSubprogramGroupSubcomponentType, subprogramGroupSubcomponentType));
				}
			}
		}
		return subprogramGroupSubcomponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubprogramGroupSubcomponentType basicGetSubprogramGroupSubcomponentType() {
		return subprogramGroupSubcomponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubprogramGroupSubcomponentType(SubprogramGroupSubcomponentType newSubprogramGroupSubcomponentType) {
		SubprogramGroupSubcomponentType oldSubprogramGroupSubcomponentType = subprogramGroupSubcomponentType;
		subprogramGroupSubcomponentType = newSubprogramGroupSubcomponentType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE,
					oldSubprogramGroupSubcomponentType, subprogramGroupSubcomponentType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE:
			if (resolve) {
				return getSubprogramGroupSubcomponentType();
			}
			return basicGetSubprogramGroupSubcomponentType();
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
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE:
			setSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType) newValue);
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
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE:
			setSubprogramGroupSubcomponentType((SubprogramGroupSubcomponentType) null);
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
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBCOMPONENT_TYPE:
			return isSetSubcomponentType();
		case Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE:
			return subprogramGroupSubcomponentType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubcomponentType() {
		return super.isSetSubcomponentType()
				|| eIsSet(Aadl2Package.SUBPROGRAM_GROUP_SUBCOMPONENT__SUBPROGRAM_GROUP_SUBCOMPONENT_TYPE);
	}

	public ComponentCategory getCategory() {
		return ComponentCategory.SUBPROGRAM_GROUP;
	}
} // SubprogramGroupSubcomponentImpl
