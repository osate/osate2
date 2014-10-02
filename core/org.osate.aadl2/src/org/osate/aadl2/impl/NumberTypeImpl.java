/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: NumberTypeImpl.java,v 1.15 2009-05-01 18:44:15 jseibel Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getOwnedUnitsType <em>Owned Units Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getReferencedUnitsType <em>Referenced Units Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NumberTypeImpl#getUnitsType <em>Units Type</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getNumberType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void setOwnedUnitsType(UnitsType newOwnedUnitsType) {
		if (newOwnedUnitsType != ownedUnitsType) {
			NotificationChain msgs = null;
			if (ownedUnitsType != null) {
				msgs = ((InternalEObject) ownedUnitsType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE, null, msgs);
			}
			if (newOwnedUnitsType != null) {
				msgs = ((InternalEObject) newOwnedUnitsType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE, null, msgs);
			}
			msgs = basicSetOwnedUnitsType(newOwnedUnitsType, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE,
					newOwnedUnitsType, newOwnedUnitsType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public UnitsType getReferencedUnitsType() {
		if (referencedUnitsType != null && ((EObject) referencedUnitsType).eIsProxy()) {
			InternalEObject oldReferencedUnitsType = (InternalEObject) referencedUnitsType;
			referencedUnitsType = (UnitsType) eResolveProxy(oldReferencedUnitsType);
			if (referencedUnitsType != oldReferencedUnitsType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE, oldReferencedUnitsType,
							referencedUnitsType));
				}
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
	@Override
	public void setReferencedUnitsType(UnitsType newReferencedUnitsType) {
		UnitsType oldReferencedUnitsType = referencedUnitsType;
		referencedUnitsType = newReferencedUnitsType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE,
					oldReferencedUnitsType, referencedUnitsType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnitsType getUnitsType() {
		UnitsType unitsType = basicGetUnitsType();
		return unitsType != null && ((EObject) unitsType).eIsProxy() ? (UnitsType) eResolveProxy((InternalEObject) unitsType)
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
	@Override
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
	@Override
	public void setRange(NumericRange newRange) {
		if (newRange != range) {
			NotificationChain msgs = null;
			if (range != null) {
				msgs = ((InternalEObject) range).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.NUMBER_TYPE__RANGE, null, msgs);
			}
			if (newRange != null) {
				msgs = ((InternalEObject) newRange).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.NUMBER_TYPE__RANGE, null, msgs);
			}
			msgs = basicSetRange(newRange, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NUMBER_TYPE__RANGE, newRange, newRange));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.NUMBER_TYPE__OWNED_UNITS_TYPE:
			return getOwnedUnitsType();
		case Aadl2Package.NUMBER_TYPE__REFERENCED_UNITS_TYPE:
			if (resolve) {
				return getReferencedUnitsType();
			}
			return basicGetReferencedUnitsType();
		case Aadl2Package.NUMBER_TYPE__RANGE:
			return getRange();
		case Aadl2Package.NUMBER_TYPE__UNITS_TYPE:
			if (resolve) {
				return getUnitsType();
			}
			return basicGetUnitsType();
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
	@Override
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
	@Override
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
