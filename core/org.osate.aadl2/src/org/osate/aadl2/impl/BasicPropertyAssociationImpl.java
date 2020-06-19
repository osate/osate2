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
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Property Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyAssociationImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyAssociationImpl#getOwnedValue <em>Owned Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicPropertyAssociationImpl extends ElementImpl implements BasicPropertyAssociation {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected BasicProperty property;

	/**
	 * The cached value of the '{@link #getOwnedValue() <em>Owned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedValue()
	 * @generated
	 * @ordered
	 */
	protected PropertyExpression ownedValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicPropertyAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getBasicPropertyAssociation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createOwnedValue(EClass eClass) {
		PropertyExpression newOwnedValue = (PropertyExpression) create(eClass);
		setOwnedValue(newOwnedValue);
		return newOwnedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicProperty getProperty() {
		if (property != null && ((EObject) property).eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject) property;
			property = (BasicProperty) eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.BASIC_PROPERTY_ASSOCIATION__PROPERTY, oldProperty, property));
				}
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicProperty basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(BasicProperty newProperty) {
		BasicProperty oldProperty = property;
		property = newProperty;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BASIC_PROPERTY_ASSOCIATION__PROPERTY,
					oldProperty, property));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression getOwnedValue() {
		return ownedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedValue(PropertyExpression newOwnedValue, NotificationChain msgs) {
		PropertyExpression oldOwnedValue = ownedValue;
		ownedValue = newOwnedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE, oldOwnedValue, newOwnedValue);
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
	public void setOwnedValue(PropertyExpression newOwnedValue) {
		if (newOwnedValue != ownedValue) {
			NotificationChain msgs = null;
			if (ownedValue != null) {
				msgs = ((InternalEObject) ownedValue).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE, null, msgs);
			}
			if (newOwnedValue != null) {
				msgs = ((InternalEObject) newOwnedValue).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE, null, msgs);
			}
			msgs = basicSetOwnedValue(newOwnedValue, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE,
					newOwnedValue, newOwnedValue));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE:
			return basicSetOwnedValue(null, msgs);
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
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__PROPERTY:
			if (resolve) {
				return getProperty();
			}
			return basicGetProperty();
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE:
			return getOwnedValue();
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
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__PROPERTY:
			setProperty((BasicProperty) newValue);
			return;
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE:
			setOwnedValue((PropertyExpression) newValue);
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
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__PROPERTY:
			setProperty((BasicProperty) null);
			return;
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE:
			setOwnedValue((PropertyExpression) null);
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
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__PROPERTY:
			return property != null;
		case Aadl2Package.BASIC_PROPERTY_ASSOCIATION__OWNED_VALUE:
			return ownedValue != null;
		}
		return super.eIsSet(featureID);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.BasicPropertyAssociation#getValue()
	 */
	public PropertyExpression getValue() {
		return getOwnedValue();
	}

} // BasicPropertyAssociationImpl
