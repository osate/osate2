/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement;

import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl#getNamespaceSeparator <em>Namespace Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BehaviorNamedElementImpl extends BehaviorElementImpl implements BehaviorNamedElement {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Identifier name;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected Identifier qualifiedName;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected Identifier namespace;

	/**
	 * The default value of the '{@link #getNamespaceSeparator() <em>Namespace Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaceSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_SEPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespaceSeparator() <em>Namespace Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaceSeparator()
	 * @generated
	 * @ordered
	 */
	protected String namespaceSeparator = NAMESPACE_SEPARATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorNamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getName() {
		if (name != null && ((EObject)name).eIsProxy()) {
			InternalEObject oldName = (InternalEObject)name;
			name = (Identifier)eResolveProxy(oldName);
			if (name != oldName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAME, oldName, name));
			}
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Identifier newName) {
		Identifier oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getQualifiedName() {
		if (qualifiedName != null && ((EObject)qualifiedName).eIsProxy()) {
			InternalEObject oldQualifiedName = (InternalEObject)qualifiedName;
			qualifiedName = (Identifier)eResolveProxy(oldQualifiedName);
			if (qualifiedName != oldQualifiedName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
			}
		}
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier basicGetQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(Identifier newQualifiedName) {
		Identifier oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamespace(Identifier newNamespace, NotificationChain msgs) {
		Identifier oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE, oldNamespace, newNamespace);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(Identifier newNamespace) {
		if (newNamespace != namespace) {
			NotificationChain msgs = null;
			if (namespace != null)
				msgs = ((InternalEObject)namespace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE, null, msgs);
			if (newNamespace != null)
				msgs = ((InternalEObject)newNamespace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE, null, msgs);
			msgs = basicSetNamespace(newNamespace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE, newNamespace, newNamespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespaceSeparator() {
		return namespaceSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespaceSeparator(String newNamespaceSeparator) {
		String oldNamespaceSeparator = namespaceSeparator;
		namespaceSeparator = newNamespaceSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE_SEPARATOR, oldNamespaceSeparator, namespaceSeparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE:
				return basicSetNamespace(null, msgs);
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
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAME:
				if (resolve) return getName();
				return basicGetName();
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME:
				if (resolve) return getQualifiedName();
				return basicGetQualifiedName();
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE:
				return getNamespace();
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE_SEPARATOR:
				return getNamespaceSeparator();
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
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAME:
				setName((Identifier)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME:
				setQualifiedName((Identifier)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE:
				setNamespace((Identifier)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE_SEPARATOR:
				setNamespaceSeparator((String)newValue);
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
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAME:
				setName((Identifier)null);
				return;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME:
				setQualifiedName((Identifier)null);
				return;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE:
				setNamespace((Identifier)null);
				return;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE_SEPARATOR:
				setNamespaceSeparator(NAMESPACE_SEPARATOR_EDEFAULT);
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
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAME:
				return name != null;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME:
				return qualifiedName != null;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE:
				return namespace != null;
			case AadlBaPackage.BEHAVIOR_NAMED_ELEMENT__NAMESPACE_SEPARATOR:
				return NAMESPACE_SEPARATOR_EDEFAULT == null ? namespaceSeparator != null : !NAMESPACE_SEPARATOR_EDEFAULT.equals(namespaceSeparator);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (namespaceSeparator: ");
		result.append(namespaceSeparator);
		result.append(')');
		return result.toString();
	}

} //BehaviorNamedElementImpl
