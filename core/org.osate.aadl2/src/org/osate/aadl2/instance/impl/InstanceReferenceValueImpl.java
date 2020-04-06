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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.impl.PropertyValueImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.InstanceReferenceValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.InstanceReferenceValueImpl#getReferencedInstanceObject <em>Referenced Instance Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstanceReferenceValueImpl extends PropertyValueImpl implements InstanceReferenceValue {
	/**
	 * The cached value of the '{@link #getReferencedInstanceObject() <em>Referenced Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedInstanceObject()
	 * @generated
	 * @ordered
	 */
	protected InstanceObject referencedInstanceObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceReferenceValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.INSTANCE_REFERENCE_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceObject getReferencedInstanceObject() {
		if (referencedInstanceObject != null && referencedInstanceObject.eIsProxy()) {
			InternalEObject oldReferencedInstanceObject = (InternalEObject) referencedInstanceObject;
			referencedInstanceObject = (InstanceObject) eResolveProxy(oldReferencedInstanceObject);
			if (referencedInstanceObject != oldReferencedInstanceObject) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT,
							oldReferencedInstanceObject, referencedInstanceObject));
				}
			}
		}
		return referencedInstanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceObject basicGetReferencedInstanceObject() {
		return referencedInstanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedInstanceObject(InstanceObject newReferencedInstanceObject) {
		InstanceObject oldReferencedInstanceObject = referencedInstanceObject;
		referencedInstanceObject = newReferencedInstanceObject;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT, oldReferencedInstanceObject,
					referencedInstanceObject));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT:
			if (resolve) {
				return getReferencedInstanceObject();
			}
			return basicGetReferencedInstanceObject();
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
		case InstancePackage.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT:
			setReferencedInstanceObject((InstanceObject) newValue);
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
		case InstancePackage.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT:
			setReferencedInstanceObject((InstanceObject) null);
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
		case InstancePackage.INSTANCE_REFERENCE_VALUE__REFERENCED_INSTANCE_OBJECT:
			return referencedInstanceObject != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Instance reference property values are already instaitated, so just
	 * return self.
	 */
	public PropertyExpression instantiate(final ComponentInstance root) {
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean sameAs(PropertyExpression pe) {
		return (pe instanceof InstanceReferenceValue)
				&& ((InstanceReferenceValue) pe).getReferencedInstanceObject() == referencedInstanceObject;
	}

} // InstanceReferenceValueImpl
