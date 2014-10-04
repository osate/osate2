/**
 * <copyright>
 * Copyright  2011 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getOwnedElementType <em>Owned Element Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getReferencedElementType <em>Referenced Element Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getListType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getElementTypeGen() {
		PropertyType elementType = basicGetElementType();
		return elementType != null && ((EObject) elementType).eIsProxy() ? (PropertyType) eResolveProxy((InternalEObject) elementType)
				: elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyType getElementType() {
		PropertyType elementType = basicGetElementType();
		return elementType != null && ((EObject) elementType).eIsProxy() ? (PropertyType) eResolveProxy((InternalEObject) elementType)
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
	@Override
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
	@Override
	public void setOwnedElementType(PropertyType newOwnedElementType) {
		if (newOwnedElementType != ownedElementType) {
			NotificationChain msgs = null;
			if (ownedElementType != null) {
				msgs = ((InternalEObject) ownedElementType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE, null, msgs);
			}
			if (newOwnedElementType != null) {
				msgs = ((InternalEObject) newOwnedElementType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE, null, msgs);
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
