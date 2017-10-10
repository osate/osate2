/**
 */
package org.osate.result;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Issue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.Issue#getIssueType <em>Issue Type</em>}</li>
 *   <li>{@link org.osate.result.Issue#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.result.Issue#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.osate.result.Issue#getExceptionType <em>Exception Type</em>}</li>
 *   <li>{@link org.osate.result.Issue#getDiagnostic <em>Diagnostic</em>}</li>
 *   <li>{@link org.osate.result.Issue#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.result.Issue#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.osate.result.ResultPackage#getIssue()
 * @model
 * @generated
 */
public interface Issue extends EObject {
	/**
	 * Returns the value of the '<em><b>Issue Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.result.IssueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issue Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issue Type</em>' attribute.
	 * @see org.osate.result.IssueType
	 * @see #setIssueType(IssueType)
	 * @see org.osate.result.ResultPackage#getIssue_IssueType()
	 * @model
	 * @generated
	 */
	IssueType getIssueType();

	/**
	 * Sets the value of the '{@link org.osate.result.Issue#getIssueType <em>Issue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issue Type</em>' attribute.
	 * @see org.osate.result.IssueType
	 * @see #getIssueType()
	 * @generated
	 */
	void setIssueType(IssueType value);

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
	 * @see org.osate.result.ResultPackage#getIssue_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.result.Issue#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Source Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Reference</em>' reference.
	 * @see #setSourceReference(EObject)
	 * @see org.osate.result.ResultPackage#getIssue_SourceReference()
	 * @model
	 * @generated
	 */
	EObject getSourceReference();

	/**
	 * Sets the value of the '{@link org.osate.result.Issue#getSourceReference <em>Source Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Reference</em>' reference.
	 * @see #getSourceReference()
	 * @generated
	 */
	void setSourceReference(EObject value);

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
	 * @see org.osate.result.ResultPackage#getIssue_ExceptionType()
	 * @model
	 * @generated
	 */
	String getExceptionType();

	/**
	 * Sets the value of the '{@link org.osate.result.Issue#getExceptionType <em>Exception Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Type</em>' attribute.
	 * @see #getExceptionType()
	 * @generated
	 */
	void setExceptionType(String value);

	/**
	 * Returns the value of the '<em><b>Diagnostic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostic</em>' attribute.
	 * @see #setDiagnostic(String)
	 * @see org.osate.result.ResultPackage#getIssue_Diagnostic()
	 * @model
	 * @generated
	 */
	String getDiagnostic();

	/**
	 * Sets the value of the '{@link org.osate.result.Issue#getDiagnostic <em>Diagnostic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagnostic</em>' attribute.
	 * @see #getDiagnostic()
	 * @generated
	 */
	void setDiagnostic(String value);

	/**
	 * Returns the value of the '<em><b>Issues</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Issue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issues</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issues</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getIssue_Issues()
	 * @model containment="true"
	 * @generated
	 */
	EList<Issue> getIssues();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.osate.result.ResultPackage#getIssue_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.osate.result.Issue#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // Issue
