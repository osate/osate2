/**
 */
package org.osate.result;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagnostic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.Diagnostic#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.result.Diagnostic#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.result.Diagnostic#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.osate.result.Diagnostic#getExceptionType <em>Exception Type</em>}</li>
 *   <li>{@link org.osate.result.Diagnostic#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.result.Diagnostic#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.osate.result.ResultPackage#getDiagnostic()
 * @model
 * @generated
 */
public interface Diagnostic extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.osate.result.DiagnosticType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.osate.result.DiagnosticType
	 * @see #setType(DiagnosticType)
	 * @see org.osate.result.ResultPackage#getDiagnostic_Type()
	 * @model default="NONE"
	 * @generated
	 */
	DiagnosticType getType();

	/**
	 * Sets the value of the '{@link org.osate.result.Diagnostic#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.osate.result.DiagnosticType
	 * @see #getType()
	 * @generated
	 */
	void setType(DiagnosticType value);

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
	 * @see org.osate.result.ResultPackage#getDiagnostic_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.result.Diagnostic#getMessage <em>Message</em>}' attribute.
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
	 * @see org.osate.result.ResultPackage#getDiagnostic_SourceReference()
	 * @model
	 * @generated
	 */
	EObject getSourceReference();

	/**
	 * Sets the value of the '{@link org.osate.result.Diagnostic#getSourceReference <em>Source Reference</em>}' reference.
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
	 * @see org.osate.result.ResultPackage#getDiagnostic_ExceptionType()
	 * @model
	 * @generated
	 */
	String getExceptionType();

	/**
	 * Sets the value of the '{@link org.osate.result.Diagnostic#getExceptionType <em>Exception Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Type</em>' attribute.
	 * @see #getExceptionType()
	 * @generated
	 */
	void setExceptionType(String value);

	/**
	 * Returns the value of the '<em><b>Issues</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Diagnostic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issues</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issues</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getDiagnostic_Issues()
	 * @model containment="true"
	 * @generated
	 */
	EList<Diagnostic> getIssues();

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
	 * @see org.osate.result.ResultPackage#getDiagnostic_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.osate.result.Diagnostic#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // Diagnostic
