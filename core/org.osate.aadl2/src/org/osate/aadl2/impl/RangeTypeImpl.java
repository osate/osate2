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
import org.osate.aadl2.NumberType;
import org.osate.aadl2.RangeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.RangeTypeImpl#getOwnedNumberType <em>Owned Number Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.RangeTypeImpl#getNumberType <em>Number Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.RangeTypeImpl#getReferencedNumberType <em>Referenced Number Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RangeTypeImpl extends NonListTypeImpl implements RangeType {
	/**
	 * The cached value of the '{@link #getOwnedNumberType() <em>Owned Number Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedNumberType()
	 * @generated
	 * @ordered
	 */
	protected NumberType ownedNumberType;

	/**
	 * The cached value of the '{@link #getReferencedNumberType() <em>Referenced Number Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedNumberType()
	 * @generated
	 * @ordered
	 */
	protected NumberType referencedNumberType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRangeType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberType getNumberType() {
		NumberType numberType = basicGetNumberType();
		return numberType != null && ((EObject) numberType).eIsProxy()
				? (NumberType) eResolveProxy((InternalEObject) numberType)
				: numberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NumberType basicGetNumberType() {
		// DONE: implement this method to return the 'Number Type' reference
		if (ownedNumberType != null) {
			return ownedNumberType;
		}
		return referencedNumberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberType getReferencedNumberType() {
		if (referencedNumberType != null && ((EObject) referencedNumberType).eIsProxy()) {
			InternalEObject oldReferencedNumberType = (InternalEObject) referencedNumberType;
			referencedNumberType = (NumberType) eResolveProxy(oldReferencedNumberType);
			if (referencedNumberType != oldReferencedNumberType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.RANGE_TYPE__REFERENCED_NUMBER_TYPE, oldReferencedNumberType,
							referencedNumberType));
				}
			}
		}
		return referencedNumberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberType basicGetReferencedNumberType() {
		return referencedNumberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedNumberType(NumberType newReferencedNumberType) {
		NumberType oldReferencedNumberType = referencedNumberType;
		referencedNumberType = newReferencedNumberType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_TYPE__REFERENCED_NUMBER_TYPE,
					oldReferencedNumberType, referencedNumberType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberType getOwnedNumberType() {
		return ownedNumberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedNumberType(NumberType newOwnedNumberType, NotificationChain msgs) {
		NumberType oldOwnedNumberType = ownedNumberType;
		ownedNumberType = newOwnedNumberType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE, oldOwnedNumberType, newOwnedNumberType);
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
	public void setOwnedNumberType(NumberType newOwnedNumberType) {
		if (newOwnedNumberType != ownedNumberType) {
			NotificationChain msgs = null;
			if (ownedNumberType != null) {
				msgs = ((InternalEObject) ownedNumberType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE, null, msgs);
			}
			if (newOwnedNumberType != null) {
				msgs = ((InternalEObject) newOwnedNumberType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE, null, msgs);
			}
			msgs = basicSetOwnedNumberType(newOwnedNumberType, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE,
					newOwnedNumberType, newOwnedNumberType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberType createOwnedNumberType(EClass eClass) {
		NumberType newOwnedNumberType = (NumberType) create(eClass);
		setOwnedNumberType(newOwnedNumberType);
		return newOwnedNumberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE:
			return basicSetOwnedNumberType(null, msgs);
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
		case Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE:
			return getOwnedNumberType();
		case Aadl2Package.RANGE_TYPE__NUMBER_TYPE:
			if (resolve) {
				return getNumberType();
			}
			return basicGetNumberType();
		case Aadl2Package.RANGE_TYPE__REFERENCED_NUMBER_TYPE:
			if (resolve) {
				return getReferencedNumberType();
			}
			return basicGetReferencedNumberType();
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
		case Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE:
			setOwnedNumberType((NumberType) newValue);
			return;
		case Aadl2Package.RANGE_TYPE__REFERENCED_NUMBER_TYPE:
			setReferencedNumberType((NumberType) newValue);
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
		case Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE:
			setOwnedNumberType((NumberType) null);
			return;
		case Aadl2Package.RANGE_TYPE__REFERENCED_NUMBER_TYPE:
			setReferencedNumberType((NumberType) null);
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
		case Aadl2Package.RANGE_TYPE__OWNED_NUMBER_TYPE:
			return ownedNumberType != null;
		case Aadl2Package.RANGE_TYPE__NUMBER_TYPE:
			return basicGetNumberType() != null;
		case Aadl2Package.RANGE_TYPE__REFERENCED_NUMBER_TYPE:
			return referencedNumberType != null;
		}
		return super.eIsSet(featureID);
	}

} // RangeTypeImpl
