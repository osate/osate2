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
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getList <em>List</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BasicPropertyImpl#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicPropertyImpl extends TypedElementImpl implements BasicProperty {
	/**
	 * The default value of the '{@link #getList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getList()
	 * @generated
	 * @ordered
	 */
	protected static final long LIST_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getList() <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getList()
	 * @generated
	 * @ordered
	 */
	protected long list = LIST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected PropertyType ownedType;

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
	public PropertyType getOwnedType() {
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedType(PropertyType newOwnedType, NotificationChain msgs) {
		PropertyType oldOwnedType = ownedType;
		ownedType = newOwnedType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.BASIC_PROPERTY__OWNED_TYPE, oldOwnedType, newOwnedType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		Resource.Internal eInternalResource = eInternalResource();
		if (eInternalResource == null || !eInternalResource.isLoading()) {
			if (newOwnedType != null) {
				if (newOwnedType != type) {
					setType(newOwnedType);
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
	public void setOwnedType(PropertyType newOwnedType) {
		if (newOwnedType != ownedType) {
			NotificationChain msgs = null;
			if (ownedType != null)
				msgs = ((InternalEObject) ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.BASIC_PROPERTY__OWNED_TYPE, null, msgs);
			if (newOwnedType != null)
				msgs = ((InternalEObject) newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.BASIC_PROPERTY__OWNED_TYPE, null, msgs);
			msgs = basicSetOwnedType(newOwnedType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BASIC_PROPERTY__OWNED_TYPE,
					newOwnedType, newOwnedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createOwnedType(EClass eClass) {
		PropertyType newOwnedType = (PropertyType) create(eClass);
		setOwnedType(newOwnedType);
		return newOwnedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.BASIC_PROPERTY__OWNED_TYPE:
			return basicSetOwnedType(null, msgs);
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
		if (type != null && ((EObject) type).eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (Type) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.BASIC_PROPERTY__TYPE,
							oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BASIC_PROPERTY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return type != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getList() {
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(long newList) {
		long oldList = list;
		list = newList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BASIC_PROPERTY__LIST, oldList, list));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.BASIC_PROPERTY__LIST:
			return getList();
		case Aadl2Package.BASIC_PROPERTY__OWNED_TYPE:
			return getOwnedType();
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
		case Aadl2Package.BASIC_PROPERTY__LIST:
			setList((Long) newValue);
			return;
		case Aadl2Package.BASIC_PROPERTY__OWNED_TYPE:
			setOwnedType((PropertyType) newValue);
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
		case Aadl2Package.BASIC_PROPERTY__LIST:
			setList(LIST_EDEFAULT);
			return;
		case Aadl2Package.BASIC_PROPERTY__OWNED_TYPE:
			setOwnedType((PropertyType) null);
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
		case Aadl2Package.BASIC_PROPERTY__LIST:
			return list != LIST_EDEFAULT;
		case Aadl2Package.BASIC_PROPERTY__OWNED_TYPE:
			return ownedType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (list: ");
		result.append(list);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see org.osate.aadl2.BasicProperty#isList()
	 */
	public boolean isList() {
		return list > 0;
	}

} //BasicPropertyImpl
