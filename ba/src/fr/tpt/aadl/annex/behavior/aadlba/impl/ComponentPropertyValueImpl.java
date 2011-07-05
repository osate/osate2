/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ComponentPropertyValue;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ComponentPropertyValueImpl#getPropertyIdentifier <em>Property Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ComponentPropertyValueImpl#getElementListIdentifier <em>Element List Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentPropertyValueImpl extends BehaviorNamedElementImpl implements ComponentPropertyValue {
	/**
	 * The cached value of the '{@link #getPropertyIdentifier() <em>Property Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier propertyIdentifier;

	/**
	 * The cached value of the '{@link #getElementListIdentifier() <em>Element List Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementListIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Identifier elementListIdentifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentPropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.COMPONENT_PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getPropertyIdentifier() {
		return propertyIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPropertyIdentifier(Identifier newPropertyIdentifier, NotificationChain msgs) {
		Identifier oldPropertyIdentifier = propertyIdentifier;
		propertyIdentifier = newPropertyIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER, oldPropertyIdentifier, newPropertyIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyIdentifier(Identifier newPropertyIdentifier) {
		if (newPropertyIdentifier != propertyIdentifier) {
			NotificationChain msgs = null;
			if (propertyIdentifier != null)
				msgs = ((InternalEObject)propertyIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER, null, msgs);
			if (newPropertyIdentifier != null)
				msgs = ((InternalEObject)newPropertyIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER, null, msgs);
			msgs = basicSetPropertyIdentifier(newPropertyIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER, newPropertyIdentifier, newPropertyIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identifier getElementListIdentifier() {
		return elementListIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementListIdentifier(Identifier newElementListIdentifier, NotificationChain msgs) {
		Identifier oldElementListIdentifier = elementListIdentifier;
		elementListIdentifier = newElementListIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER, oldElementListIdentifier, newElementListIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementListIdentifier(Identifier newElementListIdentifier) {
		if (newElementListIdentifier != elementListIdentifier) {
			NotificationChain msgs = null;
			if (elementListIdentifier != null)
				msgs = ((InternalEObject)elementListIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER, null, msgs);
			if (newElementListIdentifier != null)
				msgs = ((InternalEObject)newElementListIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER, null, msgs);
			msgs = basicSetElementListIdentifier(newElementListIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER, newElementListIdentifier, newElementListIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER:
				return basicSetPropertyIdentifier(null, msgs);
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER:
				return basicSetElementListIdentifier(null, msgs);
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
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER:
				return getPropertyIdentifier();
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER:
				return getElementListIdentifier();
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
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER:
				setPropertyIdentifier((Identifier)newValue);
				return;
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER:
				setElementListIdentifier((Identifier)newValue);
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
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER:
				setPropertyIdentifier((Identifier)null);
				return;
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER:
				setElementListIdentifier((Identifier)null);
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
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__PROPERTY_IDENTIFIER:
				return propertyIdentifier != null;
			case AadlBaPackage.COMPONENT_PROPERTY_VALUE__ELEMENT_LIST_IDENTIFIER:
				return elementListIdentifier != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentPropertyValueImpl
