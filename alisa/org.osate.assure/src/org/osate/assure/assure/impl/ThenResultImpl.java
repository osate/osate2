/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.VerificationExpr;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Then Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.ThenResultImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ThenResultImpl#getSecond <em>Second</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ThenResultImpl#isDidThenFail <em>Did Then Fail</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThenResultImpl extends VerificationExprImpl implements ThenResult {
	/**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationExpr> first;

	/**
	 * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecond()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationExpr> second;

	/**
	 * The default value of the '{@link #isDidThenFail() <em>Did Then Fail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDidThenFail()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DID_THEN_FAIL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDidThenFail() <em>Did Then Fail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDidThenFail()
	 * @generated
	 * @ordered
	 */
	protected boolean didThenFail = DID_THEN_FAIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThenResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssurePackage.Literals.THEN_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VerificationExpr> getFirst() {
		if (first == null) {
			first = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.THEN_RESULT__FIRST);
		}
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VerificationExpr> getSecond() {
		if (second == null) {
			second = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.THEN_RESULT__SECOND);
		}
		return second;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDidThenFail() {
		return didThenFail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDidThenFail(boolean newDidThenFail) {
		boolean oldDidThenFail = didThenFail;
		didThenFail = newDidThenFail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.THEN_RESULT__DID_THEN_FAIL, oldDidThenFail, didThenFail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssurePackage.THEN_RESULT__FIRST:
				return ((InternalEList<?>)getFirst()).basicRemove(otherEnd, msgs);
			case AssurePackage.THEN_RESULT__SECOND:
				return ((InternalEList<?>)getSecond()).basicRemove(otherEnd, msgs);
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
			case AssurePackage.THEN_RESULT__FIRST:
				return getFirst();
			case AssurePackage.THEN_RESULT__SECOND:
				return getSecond();
			case AssurePackage.THEN_RESULT__DID_THEN_FAIL:
				return isDidThenFail();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AssurePackage.THEN_RESULT__FIRST:
				getFirst().clear();
				getFirst().addAll((Collection<? extends VerificationExpr>)newValue);
				return;
			case AssurePackage.THEN_RESULT__SECOND:
				getSecond().clear();
				getSecond().addAll((Collection<? extends VerificationExpr>)newValue);
				return;
			case AssurePackage.THEN_RESULT__DID_THEN_FAIL:
				setDidThenFail((Boolean)newValue);
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
			case AssurePackage.THEN_RESULT__FIRST:
				getFirst().clear();
				return;
			case AssurePackage.THEN_RESULT__SECOND:
				getSecond().clear();
				return;
			case AssurePackage.THEN_RESULT__DID_THEN_FAIL:
				setDidThenFail(DID_THEN_FAIL_EDEFAULT);
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
			case AssurePackage.THEN_RESULT__FIRST:
				return first != null && !first.isEmpty();
			case AssurePackage.THEN_RESULT__SECOND:
				return second != null && !second.isEmpty();
			case AssurePackage.THEN_RESULT__DID_THEN_FAIL:
				return didThenFail != DID_THEN_FAIL_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (didThenFail: ");
		result.append(didThenFail);
		result.append(')');
		return result.toString();
	}

} //ThenResultImpl
