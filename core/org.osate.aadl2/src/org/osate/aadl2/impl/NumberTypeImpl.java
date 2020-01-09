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
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.UnitsType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getOwnedUnitsType <em>Owned Units Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getReferencedUnitsType <em>Referenced Units Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getUnitsType <em>Units Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NumberTypeImpl extends NonListTypeImpl implements NumberType {
	/**
	 * The cached value of the '{@link #getOwnedUnitsType() <em>Owned Units Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUnitsType()
	 * @generated
	 * @ordered
	 */
	protected UnitsType ownedUnitsType;
	/**
	 * The cached value of the '{@link #getReferencedUnitsType() <em>Referenced Units Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedUnitsType()
	 * @generated
	 * @ordered
	 */
	protected UnitsType referencedUnitsType;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected NumericRange range;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getNumberType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitsType getOwnedUnitsType() {
		return ownedUnitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedUnitsType(UnitsType newOwnedUnitsType, NotificationChain msgs) {
		UnitsType oldOwnedUnitsType = ownedUnitsType;
		ownedUnitsType = newOwnedUnitsType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE, oldOwnedUnitsType, newOwnedUnitsType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedUnitsType(UnitsType newOwnedUnitsType) {
		if (newOwnedUnitsType != ownedUnitsType) {
			NotificationChain msgs = null;
			if (ownedUnitsType != null)
				msgs = ((InternalEObject) ownedUnitsType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE, null, msgs);
			if (newOwnedUnitsType != null)
				msgs = ((InternalEObject) newOwnedUnitsType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE, null, msgs);
			msgs = basicSetOwnedUnitsType(newOwnedUnitsType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE,
					newOwnedUnitsType, newOwnedUnitsType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitsType createOwnedUnitsType() {
		UnitsType newOwnedUnitsType = (UnitsType) create(Aadl2Package.eINSTANCE.getUnitsType());
		setOwnedUnitsType(newOwnedUnitsType);
		return newOwnedUnitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitsType getReferencedUnitsType() {
		if (referencedUnitsType != null && ((EObject) referencedUnitsType).eIsProxy()) {
			InternalEObject oldReferencedUnitsType = (InternalEObject) referencedUnitsType;
			referencedUnitsType = (UnitsType) eResolveProxy(oldReferencedUnitsType);
			if (referencedUnitsType != oldReferencedUnitsType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE, oldReferencedUnitsType,
							referencedUnitsType));
			}
		}
		return referencedUnitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitsType basicGetReferencedUnitsType() {
		return referencedUnitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedUnitsType(UnitsType newReferencedUnitsType) {
		UnitsType oldReferencedUnitsType = referencedUnitsType;
		referencedUnitsType = newReferencedUnitsType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE,
					oldReferencedUnitsType, referencedUnitsType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitsType getUnitsType() {
		UnitsType unitsType = basicGetUnitsType();
		return unitsType != null && ((EObject) unitsType).eIsProxy()
				? (UnitsType) eResolveProxy((InternalEObject) unitsType)
				: unitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UnitsType basicGetUnitsType() {
		// TODO: implement this method to return the 'Units Type' reference
		return (ownedUnitsType != null) ? ownedUnitsType : referencedUnitsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericRange getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRange(NumericRange newRange, NotificationChain msgs) {
		NumericRange oldRange = range;
		range = newRange;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.NUMBER_TYPE__RANGE, oldRange, newRange);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(NumericRange newRange) {
		if (newRange != range) {
			NotificationChain msgs = null;
			if (range != null)
				msgs = ((InternalEObject) range).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMBER_TYPE__RANGE, null, msgs);
			if (newRange != null)
				msgs = ((InternalEObject) newRange).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.NUMBER_TYPE__RANGE, null, msgs);
			msgs = basicSetRange(newRange, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMBER_TYPE__RANGE, newRange, newRange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericRange createRange() {
		NumericRange newRange = (NumericRange) create(Aadl2Package.eINSTANCE.getNumericRange());
		setRange(newRange);
		return newRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE:
			return basicSetOwnedUnitsType(null, msgs);
		case Aadl2Package.NUMBER_TYPE__RANGE:
			return basicSetRange(null, msgs);
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
		case Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE:
			return getOwnedUnitsType();
		case Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE:
			if (resolve)
				return getReferencedUnitsType();
			return basicGetReferencedUnitsType();
		case Aadl2Package.NUMBER_TYPE__RANGE:
			return getRange();
		case Aadl2Package.NUMBER_TYPE__UNITS_TYPE:
			if (resolve)
				return getUnitsType();
			return basicGetUnitsType();
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
		case Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE:
			setOwnedUnitsType((UnitsType) newValue);
			return;
		case Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE:
			setReferencedUnitsType((UnitsType) newValue);
			return;
		case Aadl2Package.NUMBER_TYPE__RANGE:
			setRange((NumericRange) newValue);
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
		case Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE:
			setOwnedUnitsType((UnitsType) null);
			return;
		case Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE:
			setReferencedUnitsType((UnitsType) null);
			return;
		case Aadl2Package.NUMBER_TYPE__RANGE:
			setRange((NumericRange) null);
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
		case Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE:
			return ownedUnitsType != null;
		case Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE:
			return referencedUnitsType != null;
		case Aadl2Package.NUMBER_TYPE__RANGE:
			return range != null;
		case Aadl2Package.NUMBER_TYPE__UNITS_TYPE:
			return basicGetUnitsType() != null;
		}
		return super.eIsSet(featureID);
	}

} // NumberTypeImpl
