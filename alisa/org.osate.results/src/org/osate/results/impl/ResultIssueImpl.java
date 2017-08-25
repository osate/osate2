/**
 */
package org.osate.results.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.results.ResultIssue;
import org.osate.results.ResultIssueType;
import org.osate.results.ResultsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Issue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.impl.ResultIssueImpl#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultIssueImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultIssueImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultIssueImpl#getExceptionType <em>Exception Type</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultIssueImpl#getDiagnosticId <em>Diagnostic Id</em>}</li>
 *   <li>{@link org.osate.results.impl.ResultIssueImpl#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultIssueImpl extends MinimalEObjectImpl.Container implements ResultIssue {
	/**
	 * The default value of the '{@link #getIssueType() <em>Issue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueType()
	 * @generated
	 * @ordered
	 */
	protected static final ResultIssueType ISSUE_TYPE_EDEFAULT = ResultIssueType.TBD;

	/**
	 * The cached value of the '{@link #getIssueType() <em>Issue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssueType()
	 * @generated
	 * @ordered
	 */
	protected ResultIssueType issueType = ISSUE_TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * The default value of the '{@link #getExceptionType() <em>Exception Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionType()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptionType() <em>Exception Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionType()
	 * @generated
	 * @ordered
	 */
	protected String exceptionType = EXCEPTION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiagnosticId() <em>Diagnostic Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticId()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGNOSTIC_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagnosticId() <em>Diagnostic Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagnosticId()
	 * @generated
	 * @ordered
	 */
	protected String diagnosticId = DIAGNOSTIC_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIssues() <em>Issues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<ResultIssue> issues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultIssueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.RESULT_ISSUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultIssueType getIssueType() {
		return issueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIssueType(ResultIssueType newIssueType) {
		ResultIssueType oldIssueType = issueType;
		issueType = newIssueType == null ? ISSUE_TYPE_EDEFAULT : newIssueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__ISSUE_TYPE, oldIssueType, issueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.RESULT_ISSUE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptionType() {
		return exceptionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionType(String newExceptionType) {
		String oldExceptionType = exceptionType;
		exceptionType = newExceptionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE, oldExceptionType, exceptionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiagnosticId() {
		return diagnosticId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagnosticId(String newDiagnosticId) {
		String oldDiagnosticId = diagnosticId;
		diagnosticId = newDiagnosticId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RESULT_ISSUE__DIAGNOSTIC_ID, oldDiagnosticId, diagnosticId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResultIssue> getIssues() {
		if (issues == null) {
			issues = new EObjectContainmentEList<ResultIssue>(ResultIssue.class, this, ResultsPackage.RESULT_ISSUE__ISSUES);
		}
		return issues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.RESULT_ISSUE__ISSUES:
				return ((InternalEList<?>)getIssues()).basicRemove(otherEnd, msgs);
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
			case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
				return getIssueType();
			case ResultsPackage.RESULT_ISSUE__MESSAGE:
				return getMessage();
			case ResultsPackage.RESULT_ISSUE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
				return getExceptionType();
			case ResultsPackage.RESULT_ISSUE__DIAGNOSTIC_ID:
				return getDiagnosticId();
			case ResultsPackage.RESULT_ISSUE__ISSUES:
				return getIssues();
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
			case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
				setIssueType((ResultIssueType)newValue);
				return;
			case ResultsPackage.RESULT_ISSUE__MESSAGE:
				setMessage((String)newValue);
				return;
			case ResultsPackage.RESULT_ISSUE__TARGET:
				setTarget((EObject)newValue);
				return;
			case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
				setExceptionType((String)newValue);
				return;
			case ResultsPackage.RESULT_ISSUE__DIAGNOSTIC_ID:
				setDiagnosticId((String)newValue);
				return;
			case ResultsPackage.RESULT_ISSUE__ISSUES:
				getIssues().clear();
				getIssues().addAll((Collection<? extends ResultIssue>)newValue);
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
			case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
				setIssueType(ISSUE_TYPE_EDEFAULT);
				return;
			case ResultsPackage.RESULT_ISSUE__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ResultsPackage.RESULT_ISSUE__TARGET:
				setTarget((EObject)null);
				return;
			case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
				setExceptionType(EXCEPTION_TYPE_EDEFAULT);
				return;
			case ResultsPackage.RESULT_ISSUE__DIAGNOSTIC_ID:
				setDiagnosticId(DIAGNOSTIC_ID_EDEFAULT);
				return;
			case ResultsPackage.RESULT_ISSUE__ISSUES:
				getIssues().clear();
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
			case ResultsPackage.RESULT_ISSUE__ISSUE_TYPE:
				return issueType != ISSUE_TYPE_EDEFAULT;
			case ResultsPackage.RESULT_ISSUE__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ResultsPackage.RESULT_ISSUE__TARGET:
				return target != null;
			case ResultsPackage.RESULT_ISSUE__EXCEPTION_TYPE:
				return EXCEPTION_TYPE_EDEFAULT == null ? exceptionType != null : !EXCEPTION_TYPE_EDEFAULT.equals(exceptionType);
			case ResultsPackage.RESULT_ISSUE__DIAGNOSTIC_ID:
				return DIAGNOSTIC_ID_EDEFAULT == null ? diagnosticId != null : !DIAGNOSTIC_ID_EDEFAULT.equals(diagnosticId);
			case ResultsPackage.RESULT_ISSUE__ISSUES:
				return issues != null && !issues.isEmpty();
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
		result.append(" (issueType: ");
		result.append(issueType);
		result.append(", message: ");
		result.append(message);
		result.append(", exceptionType: ");
		result.append(exceptionType);
		result.append(", diagnosticId: ");
		result.append(diagnosticId);
		result.append(')');
		return result.toString();
	}

} //ResultIssueImpl
