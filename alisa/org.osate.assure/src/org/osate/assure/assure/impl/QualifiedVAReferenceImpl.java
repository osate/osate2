/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.QualifiedVAReference;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified VA Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl#getVerificationActivity <em>Verification Activity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedVAReferenceImpl extends QualifiedVerificationPlanElementReferenceImpl implements QualifiedVAReference {
	/**
	 * The cached value of the '{@link #getVerificationActivity() <em>Verification Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationActivity()
	 * @generated
	 * @ordered
	 */
	protected VerificationActivity verificationActivity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedVAReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssurePackage.Literals.QUALIFIED_VA_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VerificationActivity getVerificationActivity() {
		if (verificationActivity != null && verificationActivity.eIsProxy()) {
			InternalEObject oldVerificationActivity = (InternalEObject)verificationActivity;
			verificationActivity = (VerificationActivity)eResolveProxy(oldVerificationActivity);
			if (verificationActivity != oldVerificationActivity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
			}
		}
		return verificationActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationActivity basicGetVerificationActivity() {
		return verificationActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerificationActivity(VerificationActivity newVerificationActivity) {
		VerificationActivity oldVerificationActivity = verificationActivity;
		verificationActivity = newVerificationActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY, oldVerificationActivity, verificationActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
				if (resolve) return getVerificationActivity();
				return basicGetVerificationActivity();
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
			case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
				setVerificationActivity((VerificationActivity)newValue);
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
			case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
				setVerificationActivity((VerificationActivity)null);
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
			case AssurePackage.QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY:
				return verificationActivity != null;
		}
		return super.eIsSet(featureID);
	}

} //QualifiedVAReferenceImpl
