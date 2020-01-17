/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.NestedClaimReference;
import org.osate.assure.assure.QualifiedVerificationPlanElementReference;

import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Verification Plan Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl#getVerificationPlan <em>Verification Plan</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl#getRequirement <em>Requirement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualifiedVerificationPlanElementReferenceImpl extends MinimalEObjectImpl.Container implements QualifiedVerificationPlanElementReference {
	/**
	 * The cached value of the '{@link #getVerificationPlan() <em>Verification Plan</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationPlan()
	 * @generated
	 * @ordered
	 */
	protected VerificationPlan verificationPlan;

	/**
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected NestedClaimReference requirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedVerificationPlanElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssurePackage.Literals.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VerificationPlan getVerificationPlan() {
		if (verificationPlan != null && verificationPlan.eIsProxy()) {
			InternalEObject oldVerificationPlan = (InternalEObject)verificationPlan;
			verificationPlan = (VerificationPlan)eResolveProxy(oldVerificationPlan);
			if (verificationPlan != oldVerificationPlan) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN, oldVerificationPlan, verificationPlan));
			}
		}
		return verificationPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerificationPlan basicGetVerificationPlan() {
		return verificationPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerificationPlan(VerificationPlan newVerificationPlan) {
		VerificationPlan oldVerificationPlan = verificationPlan;
		verificationPlan = newVerificationPlan;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN, oldVerificationPlan, verificationPlan));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NestedClaimReference getRequirement() {
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirement(NestedClaimReference newRequirement, NotificationChain msgs) {
		NestedClaimReference oldRequirement = requirement;
		requirement = newRequirement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT, oldRequirement, newRequirement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirement(NestedClaimReference newRequirement) {
		if (newRequirement != requirement) {
			NotificationChain msgs = null;
			if (requirement != null)
				msgs = ((InternalEObject)requirement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT, null, msgs);
			if (newRequirement != null)
				msgs = ((InternalEObject)newRequirement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT, null, msgs);
			msgs = basicSetRequirement(newRequirement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT, newRequirement, newRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT:
				return basicSetRequirement(null, msgs);
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
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN:
				if (resolve) return getVerificationPlan();
				return basicGetVerificationPlan();
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT:
				return getRequirement();
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
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN:
				setVerificationPlan((VerificationPlan)newValue);
				return;
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT:
				setRequirement((NestedClaimReference)newValue);
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
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN:
				setVerificationPlan((VerificationPlan)null);
				return;
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT:
				setRequirement((NestedClaimReference)null);
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
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN:
				return verificationPlan != null;
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT:
				return requirement != null;
		}
		return super.eIsSet(featureID);
	}

} //QualifiedVerificationPlanElementReferenceImpl
