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

import edu.cmu.sei.aadl.aadl2.Element;

import edu.cmu.sei.aadl.aadl2.impl.ElementImpl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorElementImpl#getBaRef <em>Ba Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorElementImpl#getAadlRef <em>Aadl Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BehaviorElementImpl extends ElementImpl implements BehaviorElement {
	/**
	 * The cached value of the '{@link #getBaRef() <em>Ba Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaRef()
	 * @generated
	 * @ordered
	 */
	protected BehaviorElement baRef;

	/**
	 * The cached value of the '{@link #getAadlRef() <em>Aadl Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAadlRef()
	 * @generated
	 * @ordered
	 */
	protected Element aadlRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AadlBaPackage.Literals.BEHAVIOR_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorElement getBaRef() {
		if (baRef != null && ((EObject)baRef).eIsProxy()) {
			InternalEObject oldBaRef = (InternalEObject)baRef;
			baRef = (BehaviorElement)eResolveProxy(oldBaRef);
			if (baRef != oldBaRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF, oldBaRef, baRef));
			}
		}
		return baRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorElement basicGetBaRef() {
		return baRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaRef(BehaviorElement newBaRef) {
		BehaviorElement oldBaRef = baRef;
		baRef = newBaRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF, oldBaRef, baRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getAadlRef() {
		if (aadlRef != null && ((EObject)aadlRef).eIsProxy()) {
			InternalEObject oldAadlRef = (InternalEObject)aadlRef;
			aadlRef = (Element)eResolveProxy(oldAadlRef);
			if (aadlRef != oldAadlRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF, oldAadlRef, aadlRef));
			}
		}
		return aadlRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetAadlRef() {
		return aadlRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAadlRef(Element newAadlRef) {
		Element oldAadlRef = aadlRef;
		aadlRef = newAadlRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF, oldAadlRef, aadlRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF:
				if (resolve) return getBaRef();
				return basicGetBaRef();
			case AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF:
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
			case AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF:
				setBaRef((BehaviorElement)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF:
				setAadlRef((Element)newValue);
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
			case AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF:
				setBaRef((BehaviorElement)null);
				return;
			case AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF:
				setAadlRef((Element)null);
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
			case AadlBaPackage.BEHAVIOR_ELEMENT__BA_REF:
				return baRef != null;
			case AadlBaPackage.BEHAVIOR_ELEMENT__AADL_REF:
				return aadlRef != null;
		}
		return super.eIsSet(featureID);
	}

} //BehaviorElementImpl
