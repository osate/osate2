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
 * $Id: BasicPropertyImpl.java,v 1.14 2010-04-15 14:15:01 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getReferencedPropertyType <em>Referenced Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getOwnedPropertyType <em>Owned Property Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getPropertyType <em>Property Type</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getBasicProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void setReferencedPropertyType(PropertyType newReferencedPropertyType) {
		PropertyType oldReferencedPropertyType = referencedPropertyType;
		referencedPropertyType = newReferencedPropertyType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.BASIC_PROPERTY__REFERENCED_PROPERTY_TYPE, oldReferencedPropertyType,
					referencedPropertyType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyType getPropertyType() {
		PropertyType propertyType = basicGetPropertyType();
		return propertyType != null && ((EObject) propertyType).eIsProxy() ? (PropertyType) eResolveProxy((InternalEObject) propertyType)
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
	@Override
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
	@Override
	public void setOwnedPropertyType(PropertyType newOwnedPropertyType) {
		if (newOwnedPropertyType != ownedPropertyType) {
			NotificationChain msgs = null;
			if (ownedPropertyType != null) {
				msgs = ((InternalEObject) ownedPropertyType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE, null, msgs);
			}
			if (newOwnedPropertyType != null) {
				msgs = ((InternalEObject) newOwnedPropertyType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.BASIC_PROPERTY__OWNED_PROPERTY_TYPE, null, msgs);
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
	@Override
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
	@Override
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
	@Override
	public Type getType() {
		return getPropertyType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type basicGetType() {
		return basicGetPropertyType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public boolean isList() {
		return getType() instanceof ListType;
	}

} // BasicPropertyImpl
