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
import org.osate.assure.assure.VerificationResult;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;
import org.osate.result.Result;
import org.osate.result.ResultType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getAnalysisresultreference <em>Analysisresultreference</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.VerificationResultImpl#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VerificationResultImpl extends AssureResultImpl implements VerificationResult {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ResultType TYPE_EDEFAULT = ResultType.NONE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ResultType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIssues() <em>Issues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<Diagnostic> issues;

	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<Result> results;

	/**
	 * The cached value of the '{@link #getAnalysisresultreference() <em>Analysisresultreference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalysisresultreference()
	 * @generated
	 * @ordered
	 */
	protected AnalysisResult analysisresultreference;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VerificationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssurePackage.Literals.VERIFICATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResultType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ResultType newType) {
		ResultType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Diagnostic> getIssues() {
		if (issues == null) {
			issues = new EObjectContainmentEList<Diagnostic>(Diagnostic.class, this, AssurePackage.VERIFICATION_RESULT__ISSUES);
		}
		return issues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Result> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<Result>(Result.class, this, AssurePackage.VERIFICATION_RESULT__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnalysisResult getAnalysisresultreference() {
		if (analysisresultreference != null && analysisresultreference.eIsProxy()) {
			InternalEObject oldAnalysisresultreference = (InternalEObject)analysisresultreference;
			analysisresultreference = (AnalysisResult)eResolveProxy(oldAnalysisresultreference);
			if (analysisresultreference != oldAnalysisresultreference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssurePackage.VERIFICATION_RESULT__ANALYSISRESULTREFERENCE, oldAnalysisresultreference, analysisresultreference));
			}
		}
		return analysisresultreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisResult basicGetAnalysisresultreference() {
		return analysisresultreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnalysisresultreference(AnalysisResult newAnalysisresultreference) {
		AnalysisResult oldAnalysisresultreference = analysisresultreference;
		analysisresultreference = newAnalysisresultreference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__ANALYSISRESULTREFERENCE, oldAnalysisresultreference, analysisresultreference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.VERIFICATION_RESULT__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AssurePackage.VERIFICATION_RESULT__ISSUES:
				return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
			case AssurePackage.VERIFICATION_RESULT__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
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
			case AssurePackage.VERIFICATION_RESULT__TYPE:
				return getType();
			case AssurePackage.VERIFICATION_RESULT__ISSUES:
				return getIssues();
			case AssurePackage.VERIFICATION_RESULT__RESULTS:
				return getResults();
			case AssurePackage.VERIFICATION_RESULT__ANALYSISRESULTREFERENCE:
				if (resolve) return getAnalysisresultreference();
				return basicGetAnalysisresultreference();
			case AssurePackage.VERIFICATION_RESULT__MESSAGE:
				return getMessage();
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
			case AssurePackage.VERIFICATION_RESULT__TYPE:
				setType((ResultType)newValue);
				return;
			case AssurePackage.VERIFICATION_RESULT__ISSUES:
				getIssues().clear();
				getIssues().addAll((Collection<? extends Diagnostic>)newValue);
				return;
			case AssurePackage.VERIFICATION_RESULT__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends Result>)newValue);
				return;
			case AssurePackage.VERIFICATION_RESULT__ANALYSISRESULTREFERENCE:
				setAnalysisresultreference((AnalysisResult)newValue);
				return;
			case AssurePackage.VERIFICATION_RESULT__MESSAGE:
				setMessage((String)newValue);
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
			case AssurePackage.VERIFICATION_RESULT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case AssurePackage.VERIFICATION_RESULT__ISSUES:
				getIssues().clear();
				return;
			case AssurePackage.VERIFICATION_RESULT__RESULTS:
				getResults().clear();
				return;
			case AssurePackage.VERIFICATION_RESULT__ANALYSISRESULTREFERENCE:
				setAnalysisresultreference((AnalysisResult)null);
				return;
			case AssurePackage.VERIFICATION_RESULT__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
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
			case AssurePackage.VERIFICATION_RESULT__TYPE:
				return type != TYPE_EDEFAULT;
			case AssurePackage.VERIFICATION_RESULT__ISSUES:
				return issues != null && !issues.isEmpty();
			case AssurePackage.VERIFICATION_RESULT__RESULTS:
				return results != null && !results.isEmpty();
			case AssurePackage.VERIFICATION_RESULT__ANALYSISRESULTREFERENCE:
				return analysisresultreference != null;
			case AssurePackage.VERIFICATION_RESULT__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", message: ");
		result.append(message);
		result.append(')');
		return result.toString();
	}

} //VerificationResultImpl
