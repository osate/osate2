/**
 */
package org.osate.results;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Issue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.results.ResultIssue#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.results.ResultIssue#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.results.ResultIssue#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.results.ResultIssue#getExceptionType <em>Exception Type</em>}</li>
 *   <li>{@link org.osate.results.ResultIssue#getDiagnosticId <em>Diagnostic Id</em>}</li>
 *   <li>{@link org.osate.results.ResultIssue#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @see org.osate.results.ResultsPackage#getResultIssue()
 * @model
 * @generated
 */
public interface ResultIssue extends EObject {
	/**
	 * Returns the value of the '<em><b>Issue Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.results.ResultIssueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issue Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issue Type</em>' attribute.
	 * @see org.osate.results.ResultIssueType
	 * @see #setIssueType(ResultIssueType)
	 * @see org.osate.results.ResultsPackage#getResultIssue_IssueType()
	 * @model
	 * @generated
	 */
	ResultIssueType getIssueType();

	/**
	 * Sets the value of the '{@link org.osate.results.ResultIssue#getIssueType <em>Issue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issue Type</em>' attribute.
	 * @see org.osate.results.ResultIssueType
	 * @see #getIssueType()
	 * @generated
	 */
	void setIssueType(ResultIssueType value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.osate.results.ResultsPackage#getResultIssue_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.results.ResultIssue#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see org.osate.results.ResultsPackage#getResultIssue_Target()
	 * @model
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.osate.results.ResultIssue#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>Exception Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Type</em>' attribute.
	 * @see #setExceptionType(String)
	 * @see org.osate.results.ResultsPackage#getResultIssue_ExceptionType()
	 * @model
	 * @generated
	 */
	String getExceptionType();

	/**
	 * Sets the value of the '{@link org.osate.results.ResultIssue#getExceptionType <em>Exception Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Type</em>' attribute.
	 * @see #getExceptionType()
	 * @generated
	 */
	void setExceptionType(String value);

	/**
	 * Returns the value of the '<em><b>Diagnostic Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostic Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostic Id</em>' attribute.
	 * @see #setDiagnosticId(String)
	 * @see org.osate.results.ResultsPackage#getResultIssue_DiagnosticId()
	 * @model
	 * @generated
	 */
	String getDiagnosticId();

	/**
	 * Sets the value of the '{@link org.osate.results.ResultIssue#getDiagnosticId <em>Diagnostic Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic Id</em>' attribute.
	 * @see #getDiagnosticId()
	 * @generated
	 */
	void setDiagnosticId(String value);

	/**
	 * Returns the value of the '<em><b>Issues</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.results.ResultIssue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issues</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issues</em>' containment reference list.
	 * @see org.osate.results.ResultsPackage#getResultIssue_Issues()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResultIssue> getIssues();

} // ResultIssue
