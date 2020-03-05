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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.NamedElement;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.QualifiedClaimReference;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Claim Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getTargetReference <em>Target Reference</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getSubClaimResult <em>Sub Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getVerificationActivityResult <em>Verification Activity Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.ClaimResultImpl#getPredicateResult <em>Predicate Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClaimResultImpl extends AssureResultImpl implements ClaimResult {
	/**
	 * The cached value of the '{@link #getTargetReference() <em>Target Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetReference()
	 * @generated
	 * @ordered
	 */
	protected QualifiedClaimReference targetReference;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement modelElement;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubClaimResult() <em>Sub Claim Result</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubClaimResult()
	 * @generated
	 * @ordered
	 */
	protected EList<ClaimResult> subClaimResult;

	/**
	 * The cached value of the '{@link #getVerificationActivityResult() <em>Verification Activity Result</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerificationActivityResult()
	 * @generated
	 * @ordered
	 */
	protected EList<VerificationExpr> verificationActivityResult;

	/**
	 * The cached value of the '{@link #getPredicateResult() <em>Predicate Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicateResult()
	 * @generated
	 * @ordered
	 */
	protected VerificationResult predicateResult;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClaimResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssurePackage.Literals.CLAIM_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QualifiedClaimReference getTargetReference() {
		return targetReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetReference(QualifiedClaimReference newTargetReference, NotificationChain msgs) {
		QualifiedClaimReference oldTargetReference = targetReference;
		targetReference = newTargetReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__TARGET_REFERENCE, oldTargetReference, newTargetReference);
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
	public void setTargetReference(QualifiedClaimReference newTargetReference) {
		if (newTargetReference != targetReference) {
			NotificationChain msgs = null;
			if (targetReference != null)
				msgs = ((InternalEObject)targetReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CLAIM_RESULT__TARGET_REFERENCE, null, msgs);
			if (newTargetReference != null)
				msgs = ((InternalEObject)newTargetReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CLAIM_RESULT__TARGET_REFERENCE, null, msgs);
			msgs = basicSetTargetReference(newTargetReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__TARGET_REFERENCE, newTargetReference, newTargetReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NamedElement getModelElement() {
		if (modelElement != null && ((EObject)modelElement).eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = (NamedElement)eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.CLAIM_RESULT__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelElement(NamedElement newModelElement) {
		NamedElement oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__MODEL_ELEMENT, oldModelElement, modelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClaimResult> getSubClaimResult() {
		if (subClaimResult == null) {
			subClaimResult = new EObjectContainmentEList<ClaimResult>(ClaimResult.class, this, AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT);
		}
		return subClaimResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VerificationExpr> getVerificationActivityResult() {
		if (verificationActivityResult == null) {
			verificationActivityResult = new EObjectContainmentEList<VerificationExpr>(VerificationExpr.class, this, AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT);
		}
		return verificationActivityResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VerificationResult getPredicateResult() {
		return predicateResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredicateResult(VerificationResult newPredicateResult, NotificationChain msgs) {
		VerificationResult oldPredicateResult = predicateResult;
		predicateResult = newPredicateResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__PREDICATE_RESULT, oldPredicateResult, newPredicateResult);
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
	public void setPredicateResult(VerificationResult newPredicateResult) {
		if (newPredicateResult != predicateResult) {
			NotificationChain msgs = null;
			if (predicateResult != null)
				msgs = ((InternalEObject)predicateResult).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CLAIM_RESULT__PREDICATE_RESULT, null, msgs);
			if (newPredicateResult != null)
				msgs = ((InternalEObject)newPredicateResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssurePackage.CLAIM_RESULT__PREDICATE_RESULT, null, msgs);
			msgs = basicSetPredicateResult(newPredicateResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.CLAIM_RESULT__PREDICATE_RESULT, newPredicateResult, newPredicateResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssurePackage.CLAIM_RESULT__TARGET_REFERENCE:
				return basicSetTargetReference(null, msgs);
			case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
				return ((InternalEList<?>)getSubClaimResult()).basicRemove(otherEnd, msgs);
			case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
				return ((InternalEList<?>)getVerificationActivityResult()).basicRemove(otherEnd, msgs);
			case AssurePackage.CLAIM_RESULT__PREDICATE_RESULT:
				return basicSetPredicateResult(null, msgs);
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
			case AssurePackage.CLAIM_RESULT__TARGET_REFERENCE:
				return getTargetReference();
			case AssurePackage.CLAIM_RESULT__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
			case AssurePackage.CLAIM_RESULT__MESSAGE:
				return getMessage();
			case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
				return getSubClaimResult();
			case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
				return getVerificationActivityResult();
			case AssurePackage.CLAIM_RESULT__PREDICATE_RESULT:
				return getPredicateResult();
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
			case AssurePackage.CLAIM_RESULT__TARGET_REFERENCE:
				setTargetReference((QualifiedClaimReference)newValue);
				return;
			case AssurePackage.CLAIM_RESULT__MODEL_ELEMENT:
				setModelElement((NamedElement)newValue);
				return;
			case AssurePackage.CLAIM_RESULT__MESSAGE:
				setMessage((String)newValue);
				return;
			case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
				getSubClaimResult().clear();
				getSubClaimResult().addAll((Collection<? extends ClaimResult>)newValue);
				return;
			case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
				getVerificationActivityResult().clear();
				getVerificationActivityResult().addAll((Collection<? extends VerificationExpr>)newValue);
				return;
			case AssurePackage.CLAIM_RESULT__PREDICATE_RESULT:
				setPredicateResult((VerificationResult)newValue);
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
			case AssurePackage.CLAIM_RESULT__TARGET_REFERENCE:
				setTargetReference((QualifiedClaimReference)null);
				return;
			case AssurePackage.CLAIM_RESULT__MODEL_ELEMENT:
				setModelElement((NamedElement)null);
				return;
			case AssurePackage.CLAIM_RESULT__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
				getSubClaimResult().clear();
				return;
			case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
				getVerificationActivityResult().clear();
				return;
			case AssurePackage.CLAIM_RESULT__PREDICATE_RESULT:
				setPredicateResult((VerificationResult)null);
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
			case AssurePackage.CLAIM_RESULT__TARGET_REFERENCE:
				return targetReference != null;
			case AssurePackage.CLAIM_RESULT__MODEL_ELEMENT:
				return modelElement != null;
			case AssurePackage.CLAIM_RESULT__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case AssurePackage.CLAIM_RESULT__SUB_CLAIM_RESULT:
				return subClaimResult != null && !subClaimResult.isEmpty();
			case AssurePackage.CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT:
				return verificationActivityResult != null && !verificationActivityResult.isEmpty();
			case AssurePackage.CLAIM_RESULT__PREDICATE_RESULT:
				return predicateResult != null;
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
		result.append(" (message: ");
		result.append(message);
		result.append(')');
		return result.toString();
	}

} //ClaimResultImpl
