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
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.result.ResultType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Else Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.ElseResultImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ElseResultImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ElseResultImpl#getFail <em>Fail</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ElseResultImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ElseResultImpl#getDidFail <em>Did Fail</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElseResultImpl extends VerificationExprImpl implements ElseResult {
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
	 * The cached value of the '{@link #getError() <em>Error</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationExpr> error;

	/**
	 * The cached value of the '{@link #getFail() <em>Fail</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFail()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationExpr> fail;

	/**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationExpr> timeout;

	/**
	 * The default value of the '{@link #getDidFail() <em>Did Fail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDidFail()
	 * @generated NOT
	 * @ordered
	 */
	protected static final ResultType DID_FAIL_EDEFAULT = ResultType.SUCCESS;

	/**
	 * The cached value of the '{@link #getDidFail() <em>Did Fail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDidFail()
	 * @generated
	 * @ordered
	 */
	protected ResultType didFail = DID_FAIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElseResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssurePackage.Literals.ELSE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VerificationExpr> getFirst() {
		if (first == null) {
			first = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.ELSE_RESULT__FIRST);
		}
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VerificationExpr> getError() {
		if (error == null) {
			error = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.ELSE_RESULT__ERROR);
		}
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VerificationExpr> getFail() {
		if (fail == null) {
			fail = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.ELSE_RESULT__FAIL);
		}
		return fail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VerificationExpr> getTimeout() {
		if (timeout == null) {
			timeout = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.ELSE_RESULT__TIMEOUT);
		}
		return timeout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResultType getDidFail() {
		return didFail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDidFail(ResultType newDidFail) {
		ResultType oldDidFail = didFail;
		didFail = newDidFail == null ? DID_FAIL_EDEFAULT : newDidFail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.ELSE_RESULT__DID_FAIL, oldDidFail, didFail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssurePackage.ELSE_RESULT__FIRST:
				return ((InternalEList<?>)getFirst()).basicRemove(otherEnd, msgs);
			case AssurePackage.ELSE_RESULT__ERROR:
				return ((InternalEList<?>)getError()).basicRemove(otherEnd, msgs);
			case AssurePackage.ELSE_RESULT__FAIL:
				return ((InternalEList<?>)getFail()).basicRemove(otherEnd, msgs);
			case AssurePackage.ELSE_RESULT__TIMEOUT:
				return ((InternalEList<?>)getTimeout()).basicRemove(otherEnd, msgs);
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
			case AssurePackage.ELSE_RESULT__FIRST:
				return getFirst();
			case AssurePackage.ELSE_RESULT__ERROR:
				return getError();
			case AssurePackage.ELSE_RESULT__FAIL:
				return getFail();
			case AssurePackage.ELSE_RESULT__TIMEOUT:
				return getTimeout();
			case AssurePackage.ELSE_RESULT__DID_FAIL:
				return getDidFail();
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
			case AssurePackage.ELSE_RESULT__FIRST:
				getFirst().clear();
				getFirst().addAll((Collection<? extends VerificationExpr>)newValue);
				return;
			case AssurePackage.ELSE_RESULT__ERROR:
				getError().clear();
				getError().addAll((Collection<? extends VerificationExpr>)newValue);
				return;
			case AssurePackage.ELSE_RESULT__FAIL:
				getFail().clear();
				getFail().addAll((Collection<? extends VerificationExpr>)newValue);
				return;
			case AssurePackage.ELSE_RESULT__TIMEOUT:
				getTimeout().clear();
				getTimeout().addAll((Collection<? extends VerificationExpr>)newValue);
				return;
			case AssurePackage.ELSE_RESULT__DID_FAIL:
				setDidFail((ResultType)newValue);
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
			case AssurePackage.ELSE_RESULT__FIRST:
				getFirst().clear();
				return;
			case AssurePackage.ELSE_RESULT__ERROR:
				getError().clear();
				return;
			case AssurePackage.ELSE_RESULT__FAIL:
				getFail().clear();
				return;
			case AssurePackage.ELSE_RESULT__TIMEOUT:
				getTimeout().clear();
				return;
			case AssurePackage.ELSE_RESULT__DID_FAIL:
				setDidFail(DID_FAIL_EDEFAULT);
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
			case AssurePackage.ELSE_RESULT__FIRST:
				return first != null && !first.isEmpty();
			case AssurePackage.ELSE_RESULT__ERROR:
				return error != null && !error.isEmpty();
			case AssurePackage.ELSE_RESULT__FAIL:
				return fail != null && !fail.isEmpty();
			case AssurePackage.ELSE_RESULT__TIMEOUT:
				return timeout != null && !timeout.isEmpty();
			case AssurePackage.ELSE_RESULT__DID_FAIL:
				return didFail != DID_FAIL_EDEFAULT;
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
		result.append(" (didFail: ");
		result.append(didFail);
		result.append(')');
		return result.toString();
	}

} //ElseResultImpl
