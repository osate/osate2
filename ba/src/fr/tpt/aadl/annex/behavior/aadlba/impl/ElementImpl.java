/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
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

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Element;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl#getAadlRef <em>Aadl Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementImpl extends edu.cmu.sei.aadl.aadl2.impl.ElementImpl implements Element {
	/**
	 * The cached value of the '{@link #getBaRef() <em>Ba Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaRef()
	 * @generated
	 * @ordered
	 */
	protected Element baRef;

	/**
	 * The cached value of the '{@link #getAadlRef() <em>Aadl Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAadlRef()
	 * @generated
	 * @ordered
	 */
	protected edu.cmu.sei.aadl.aadl2.Element aadlRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBaRef() {
		if (baRef != null && ((EObject)baRef).eIsProxy()) {
			InternalEObject oldBaRef = (InternalEObject)baRef;
			baRef = (Element)eResolveProxy(oldBaRef);
			if (baRef != oldBaRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.ELEMENT__BA_REF, oldBaRef, baRef));
			}
		}
		return baRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetBaRef() {
		return baRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaRef(Element newBaRef) {
		Element oldBaRef = baRef;
		baRef = newBaRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ELEMENT__BA_REF, oldBaRef, baRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.cmu.sei.aadl.aadl2.Element getAadlRef() {
		if (aadlRef != null && ((EObject)aadlRef).eIsProxy()) {
			InternalEObject oldAadlRef = (InternalEObject)aadlRef;
			aadlRef = (edu.cmu.sei.aadl.aadl2.Element)eResolveProxy(oldAadlRef);
			if (aadlRef != oldAadlRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.ELEMENT__AADL_REF, oldAadlRef, aadlRef));
			}
		}
		return aadlRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.cmu.sei.aadl.aadl2.Element basicGetAadlRef() {
		return aadlRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAadlRef(edu.cmu.sei.aadl.aadl2.Element newAadlRef) {
		edu.cmu.sei.aadl.aadl2.Element oldAadlRef = aadlRef;
		aadlRef = newAadlRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ELEMENT__AADL_REF, oldAadlRef, aadlRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AadlBaPackage.ELEMENT__BA_REF:
				if (resolve) return getBaRef();
				return basicGetBaRef();
			case AadlBaPackage.ELEMENT__AADL_REF:
				if (resolve) return getAadlRef();
				return basicGetAadlRef();
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
			case AadlBaPackage.ELEMENT__BA_REF:
				setBaRef((Element)newValue);
				return;
			case AadlBaPackage.ELEMENT__AADL_REF:
				setAadlRef((edu.cmu.sei.aadl.aadl2.Element)newValue);
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
			case AadlBaPackage.ELEMENT__BA_REF:
				setBaRef((Element)null);
				return;
			case AadlBaPackage.ELEMENT__AADL_REF:
				setAadlRef((edu.cmu.sei.aadl.aadl2.Element)null);
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
			case AadlBaPackage.ELEMENT__BA_REF:
				return baRef != null;
			case AadlBaPackage.ELEMENT__AADL_REF:
				return aadlRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementImpl
