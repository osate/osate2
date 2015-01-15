/**
 */
package org.osate.assure.assure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evidence Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.EvidenceResult#getState <em>State</em>}</li>
 *   <li>{@link org.osate.assure.assure.EvidenceResult#getStatus <em>Status</em>}</li>
 *   <li>{@link org.osate.assure.assure.EvidenceResult#getSucessMsg <em>Sucess Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.EvidenceResult#getFailMsg <em>Fail Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getEvidenceResult()
 * @model
 * @generated
 */
public interface EvidenceResult extends AssuranceResult
{
  /**
   * Returns the value of the '<em><b>State</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationResultState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #setState(VerificationResultState)
   * @see org.osate.assure.assure.AssurePackage#getEvidenceResult_State()
   * @model
   * @generated
   */
  VerificationResultState getState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.EvidenceResult#getState <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #getState()
   * @generated
   */
  void setState(VerificationResultState value);

  /**
   * Returns the value of the '<em><b>Status</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationResultStatus}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultStatus
   * @see #setStatus(VerificationResultStatus)
   * @see org.osate.assure.assure.AssurePackage#getEvidenceResult_Status()
   * @model
   * @generated
   */
  VerificationResultStatus getStatus();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.EvidenceResult#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultStatus
   * @see #getStatus()
   * @generated
   */
  void setStatus(VerificationResultStatus value);

  /**
   * Returns the value of the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sucess Msg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sucess Msg</em>' attribute.
   * @see #setSucessMsg(String)
   * @see org.osate.assure.assure.AssurePackage#getEvidenceResult_SucessMsg()
   * @model
   * @generated
   */
  String getSucessMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.EvidenceResult#getSucessMsg <em>Sucess Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sucess Msg</em>' attribute.
   * @see #getSucessMsg()
   * @generated
   */
  void setSucessMsg(String value);

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
   * @see org.osate.assure.assure.AssurePackage#getEvidenceResult_FailMsg()
   * @model
   * @generated
   */
  String getFailMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.EvidenceResult#getFailMsg <em>Fail Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Msg</em>' attribute.
   * @see #getFailMsg()
   * @generated
   */
  void setFailMsg(String value);

} // EvidenceResult
