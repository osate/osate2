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
 * $Id: RangeTypeImpl.java,v 1.10 2009-05-01 18:44:16 jseibel Exp $
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRangeType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
