/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EObject;

import org.osate.results.results.ResultReport;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getResultState <em>Result State</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getFailMsg <em>Fail Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getFailTarget <em>Fail Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getResultReport <em>Result Report</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationResult()
 * @model
 * @generated
 */
public interface VerificationResult extends EObject
{
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
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Fail Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail Msg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail Msg</em>' attribute.
   * @see #setFailMsg(String)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_FailMsg()
   * @model
   * @generated
   */
  String getFailMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getFailMsg <em>Fail Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Msg</em>' attribute.
   * @see #getFailMsg()
   * @generated
   */
  void setFailMsg(String value);

  /**
   * Returns the value of the '<em><b>Fail Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail Target</em>' reference.
   * @see #setFailTarget(EObject)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_FailTarget()
   * @model
   * @generated
   */
  EObject getFailTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getFailTarget <em>Fail Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Target</em>' reference.
   * @see #getFailTarget()
   * @generated
   */
  void setFailTarget(EObject value);

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

} // VerificationResult
