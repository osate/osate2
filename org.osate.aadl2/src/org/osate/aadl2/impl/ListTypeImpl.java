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
import org.eclipse.emf.ecore.resource.Resource;
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
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ListTypeImpl#getOwnedElementType <em>Owned Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListTypeImpl extends PropertyTypeImpl implements ListType {
	/**
	 * The cached value of the '{@link #getElementType() <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementType()
	 * @generated
	 * @ordered
	 */
	protected PropertyType elementType;
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
		if (elementType != null && ((EObject) elementType).eIsProxy()) {
			InternalEObject oldElementType = (InternalEObject) elementType;
			elementType = (PropertyType) eResolveProxy(oldElementType);
			if (elementType != oldElementType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.LIST_TYPE__ELEMENT_TYPE,
							oldElementType, elementType));
			}
		}
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyType getElementType() {
		if (elementType == null) {
			elementType = ownedElementType;
		}
		return getElementTypeGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType basicGetElementTypeGen() {
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyType basicGetElementType() {
		if (elementType == null) {
			elementType = ownedElementType;
		}
		return basicGetElementTypeGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setElementType(PropertyType newElementType) {
		PropertyType oldElementType = elementType;
		elementType = newElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.LIST_TYPE__ELEMENT_TYPE, oldElementType,
					elementType));
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
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwnedElementType != null) {
				if (newOwnedElementType != elementType) {
					setElementType(newOwnedElementType);
				}
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
			if (ownedElementType != null)
				msgs = ((InternalEObject) ownedElementType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE, null, msgs);
			if (newOwnedElementType != null)
				msgs = ((InternalEObject) newOwnedElementType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE, null, msgs);
			msgs = basicSetOwnedElementType(newOwnedElementType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE,
					newOwnedElementType, newOwnedElementType));
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
		case Aadl2Package.LIST_TYPE__ELEMENT_TYPE:
			if (resolve)
				return getElementType();
			return basicGetElementType();
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			return getOwnedElementType();
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
		case Aadl2Package.LIST_TYPE__ELEMENT_TYPE:
			setElementType((PropertyType) newValue);
			return;
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			setOwnedElementType((PropertyType) newValue);
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
		case Aadl2Package.LIST_TYPE__ELEMENT_TYPE:
			setElementType((PropertyType) null);
			return;
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			setOwnedElementType((PropertyType) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.LIST_TYPE__ELEMENT_TYPE:
			if (elementType == null) {
				elementType = ownedElementType;
			}
			return elementType != null;
		case Aadl2Package.LIST_TYPE__OWNED_ELEMENT_TYPE:
			return ownedElementType != null;
		}
		return super.eIsSet(featureID);
	}

} // ListTypeImpl
