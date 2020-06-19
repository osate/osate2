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
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.ListType;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getReferencedPropertyType <em>Referenced Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getOwnedPropertyType <em>Owned Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getPropertyType <em>Property Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicPropertyImpl extends TypedElementImpl implements BasicProperty {
	/**
	 * The cached value of the '{@link #getReferencedPropertyType() <em>Referenced Property Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedPropertyType()
	 * @generated
	 * @ordered
	 */
	protected PropertyType referencedPropertyType;
	/**
	 * The cached value of the '{@link #getOwnedPropertyType() <em>Owned Property Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyType()
	 * @generated
	 * @ordered
	 */
	protected PropertyType ownedPropertyType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getBasicProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getReferencedPropertyType() {
		if (referencedPropertyType != null && ((EObject) referencedPropertyType).eIsProxy()) {
			InternalEObject oldReferencedPropertyType = (InternalEObject) referencedPropertyType;
			referencedPropertyType = (PropertyType) eResolveProxy(oldReferencedPropertyType);
			if (referencedPropertyType != oldReferencedPropertyType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE, oldReferencedPropertyType,
							referencedPropertyType));
				}
			}
		}
		return referencedPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType basicGetReferencedPropertyType() {
		return referencedPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedPropertyType(PropertyType newReferencedPropertyType) {
		PropertyType oldReferencedPropertyType = referencedPropertyType;
		referencedPropertyType = newReferencedPropertyType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE,
					oldReferencedPropertyType, referencedPropertyType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getPropertyType() {
		PropertyType propertyType = basicGetPropertyType();
		return propertyType != null && ((EObject) propertyType).eIsProxy()
				? (PropertyType) eResolveProxy((InternalEObject) propertyType)
				: propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyType basicGetPropertyType() {
		// DONE: implement this method to return the 'Property Type' reference
		if (eIsSet(Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE)) {
			return getOwnedPropertyType();
		} else {
			return basicGetReferencedPropertyType();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPropertyType() {
		return basicGetPropertyType() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getOwnedPropertyType() {
		return ownedPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPropertyType(PropertyType newOwnedPropertyType, NotificationChain msgs) {
		PropertyType oldOwnedPropertyType = ownedPropertyType;
		ownedPropertyType = newOwnedPropertyType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE, oldOwnedPropertyType, newOwnedPropertyType);
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
	public void setOwnedPropertyType(PropertyType newOwnedPropertyType) {
		if (newOwnedPropertyType != ownedPropertyType) {
			NotificationChain msgs = null;
			if (ownedPropertyType != null) {
				msgs = ((InternalEObject) ownedPropertyType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE, null, msgs);
			}
			if (newOwnedPropertyType != null) {
				msgs = ((InternalEObject) newOwnedPropertyType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE, null, msgs);
			}
			msgs = basicSetOwnedPropertyType(newOwnedPropertyType, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE,
					newOwnedPropertyType, newOwnedPropertyType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createOwnedPropertyType(EClass eClass) {
		PropertyType newOwnedPropertyType = (PropertyType) create(eClass);
		setOwnedPropertyType(newOwnedPropertyType);
		return newOwnedPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE:
			return basicSetOwnedPropertyType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		return getPropertyType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return basicGetPropertyType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(Type newType) {
		// do nothing
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE:
			if (resolve) {
				return getReferencedPropertyType();
			}
			return basicGetReferencedPropertyType();
		case Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE:
			return getOwnedPropertyType();
		case Aadl2Package.BASIC_PROPERTY__PROPERTY_TYPE:
			if (resolve) {
				return getPropertyType();
			}
			return basicGetPropertyType();
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
		case Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE:
			setReferencedPropertyType((PropertyType) newValue);
			return;
		case Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE:
			setOwnedPropertyType((PropertyType) newValue);
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
		case Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE:
			setReferencedPropertyType((PropertyType) null);
			return;
		case Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE:
			setOwnedPropertyType((PropertyType) null);
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
		case Aadl2Package.BASIC_PROPERTY__TYPE:
			return isSetType();
		case Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE:
			return referencedPropertyType != null;
		case Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE:
			return ownedPropertyType != null;
		case Aadl2Package.BASIC_PROPERTY__PROPERTY_TYPE:
			return isSetPropertyType();
		}
		return super.eIsSet(featureID);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.BasicProperty#isList()
	 */
	public boolean isList() {
		return getType() instanceof ListType;
	}

} // BasicPropertyImpl
