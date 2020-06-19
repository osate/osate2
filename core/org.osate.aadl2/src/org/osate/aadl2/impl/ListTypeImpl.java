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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ListType;
import org.osate.aadl2.PropertyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getOwnedElementType <em>Owned Element Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getReferencedElementType <em>Referenced Element Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListTypeImpl extends PropertyTypeImpl implements ListType {
	/**
	 * The cached value of the '{@link #getOwnedElementType() <em>Owned Element Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElementType()
	 * @generated
	 * @ordered
	 */
	protected PropertyType ownedElementType;

	/**
	 * The cached value of the '{@link #getReferencedElementType() <em>Referenced Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedElementType()
	 * @generated
	 * @ordered
	 */
	protected PropertyType referencedElementType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getListType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getElementType() {
		PropertyType elementType = basicGetElementType();
		return elementType != null && ((EObject) elementType).eIsProxy()
				? (PropertyType) eResolveProxy((InternalEObject) elementType)
				: elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyType basicGetElementType() {
		// DONE: implement this method to return the 'Element Type' reference
		if (ownedElementType != null) {
			return ownedElementType;
		}
		return referencedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getOwnedElementType() {
		return ownedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedElementType(PropertyType newOwnedElementType, NotificationChain msgs) {
		PropertyType oldOwnedElementType = ownedElementType;
		ownedElementType = newOwnedElementType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE, oldOwnedElementType, newOwnedElementType);
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
	public void setOwnedElementType(PropertyType newOwnedElementType) {
		if (newOwnedElementType != ownedElementType) {
			NotificationChain msgs = null;
			if (ownedElementType != null) {
				msgs = ((InternalEObject) ownedElementType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE, null, msgs);
			}
			if (newOwnedElementType != null) {
				msgs = ((InternalEObject) newOwnedElementType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE, null, msgs);
			}
			msgs = basicSetOwnedElementType(newOwnedElementType, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE,
					newOwnedElementType, newOwnedElementType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createOwnedElementType(EClass eClass) {
		PropertyType newOwnedElementType = (PropertyType) create(eClass);
		setOwnedElementType(newOwnedElementType);
		return newOwnedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getReferencedElementType() {
		if (referencedElementType != null && ((EObject) referencedElementType).eIsProxy()) {
			InternalEObject oldReferencedElementType = (InternalEObject) referencedElementType;
			referencedElementType = (PropertyType) eResolveProxy(oldReferencedElementType);
			if (referencedElementType != oldReferencedElementType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.LIST_TYPE__REFERENCED_ELEMENT_TYPE, oldReferencedElementType,
							referencedElementType));
				}
			}
		}
		return referencedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType basicGetReferencedElementType() {
		return referencedElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedElementType(PropertyType newReferencedElementType) {
		PropertyType oldReferencedElementType = referencedElementType;
		referencedElementType = newReferencedElementType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.LIST_TYPE__REFERENCED_ELEMENT_TYPE,
					oldReferencedElementType, referencedElementType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			return basicSetOwnedElementType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			return getOwnedElementType();
		case Aadl2Package.LIST_TYPE__REFERENCED_ELEMENT_TYPE:
			if (resolve) {
				return getReferencedElementType();
			}
			return basicGetReferencedElementType();
		case Aadl2Package.LIST_TYPE__ELEMENT_TYPE:
			if (resolve) {
				return getElementType();
			}
			return basicGetElementType();
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
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			setOwnedElementType((PropertyType) newValue);
			return;
		case Aadl2Package.LIST_TYPE__REFERENCED_ELEMENT_TYPE:
			setReferencedElementType((PropertyType) newValue);
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
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			setOwnedElementType((PropertyType) null);
			return;
		case Aadl2Package.LIST_TYPE__REFERENCED_ELEMENT_TYPE:
			setReferencedElementType((PropertyType) null);
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
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			return ownedElementType != null;
		case Aadl2Package.LIST_TYPE__REFERENCED_ELEMENT_TYPE:
			return referencedElementType != null;
		case Aadl2Package.LIST_TYPE__ELEMENT_TYPE:
			return basicGetElementType() != null;
		}
		return super.eIsSet(featureID);
	}

} // ListTypeImpl
