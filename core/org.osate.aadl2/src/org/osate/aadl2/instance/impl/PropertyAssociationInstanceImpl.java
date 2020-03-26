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
package org.osate.aadl2.instance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.impl.PropertyAssociationImpl;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.PropertyAssociationInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Association Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.PropertyAssociationInstanceImpl#getPropertyAssociation <em>Property Association</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyAssociationInstanceImpl extends PropertyAssociationImpl implements PropertyAssociationInstance {
	/**
	 * The cached value of the '{@link #getPropertyAssociation() <em>Property Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyAssociation()
	 * @generated
	 * @ordered
	 */
	protected PropertyAssociation propertyAssociation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyAssociationInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.PROPERTY_ASSOCIATION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAssociation getPropertyAssociation() {
		if (propertyAssociation != null && ((EObject) propertyAssociation).eIsProxy()) {
			InternalEObject oldPropertyAssociation = (InternalEObject) propertyAssociation;
			propertyAssociation = (PropertyAssociation) eResolveProxy(oldPropertyAssociation);
			if (propertyAssociation != oldPropertyAssociation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION, oldPropertyAssociation,
							propertyAssociation));
				}
			}
		}
		return propertyAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAssociation basicGetPropertyAssociation() {
		return propertyAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyAssociation(PropertyAssociation newPropertyAssociation) {
		PropertyAssociation oldPropertyAssociation = propertyAssociation;
		propertyAssociation = newPropertyAssociation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION, oldPropertyAssociation,
					propertyAssociation));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION:
			if (resolve) {
				return getPropertyAssociation();
			}
			return basicGetPropertyAssociation();
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
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION:
			setPropertyAssociation((PropertyAssociation) newValue);
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
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION:
			setPropertyAssociation((PropertyAssociation) null);
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
		case InstancePackage.PROPERTY_ASSOCIATION_INSTANCE__PROPERTY_ASSOCIATION:
			return propertyAssociation != null;
		}
		return super.eIsSet(featureID);
	}

} // PropertyAssociationInstanceImpl
