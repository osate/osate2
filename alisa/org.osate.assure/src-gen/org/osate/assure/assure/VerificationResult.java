/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.results.results.ResultReport;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getResultState <em>Result State</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getResultReport <em>Result Report</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationResult()
 * @model
 * @generated
 */
public interface VerificationResult extends AssureResult, VerificationExpr
{
  /**
   * Returns the value of the '<em><b>Execution State</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationExecutionState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Execution State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Execution State</em>' attribute.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see #setExecutionState(VerificationExecutionState)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_ExecutionState()
   * @model
   * @generated
   */
  VerificationExecutionState getExecutionState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getExecutionState <em>Execution State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execution State</em>' attribute.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see #getExecutionState()
   * @generated
   */
  void setExecutionState(VerificationExecutionState value);

  /**
   * Returns the value of the '<em><b>Result State</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationResultState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #setResultState(VerificationResultState)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_ResultState()
   * @model
   * @generated
   */
  VerificationResultState getResultState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getResultState <em>Result State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #getResultState()
   * @generated
   */
  void setResultState(VerificationResultState value);

  /**
   * Returns the value of the '<em><b>Issues</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.ResultIssue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issues</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Issues()
   * @model containment="true"
   * @generated
   */
  EList<ResultIssue> getIssues();

  /**
   * Returns the value of the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Report</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Report</em>' reference.
   * @see #setResultReport(ResultReport)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_ResultReport()
   * @model
   * @generated
   */
  ResultReport getResultReport();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getResultReport <em>Result Report</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Report</em>' reference.
   * @see #getResultReport()
   * @generated
   */
  void setResultReport(ResultReport value);

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
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

} // VerificationResult
