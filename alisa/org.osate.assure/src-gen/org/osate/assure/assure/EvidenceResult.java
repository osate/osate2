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
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationExecutionState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' attribute.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see #setState(VerificationExecutionState)
   * @see org.osate.assure.assure.AssurePackage#getEvidenceResult_State()
   * @model
   * @generated
   */
  VerificationExecutionState getState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.EvidenceResult#getState <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' attribute.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see #getState()
   * @generated
   */
  void setState(VerificationExecutionState value);

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
