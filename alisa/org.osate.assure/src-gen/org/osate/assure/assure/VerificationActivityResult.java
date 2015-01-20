/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Activity Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getSucessMsg <em>Sucess Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getAssumptionResult <em>Assumption Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationActivityResult#getPreconditionResult <em>Precondition Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult()
 * @model
 * @generated
 */
public interface VerificationActivityResult extends VerificationExpr
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(VerificationActivity)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_Target()
   * @model
   * @generated
   */
  VerificationActivity getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VerificationActivity value);

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
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_ExecutionState()
   * @model
   * @generated
   */
  VerificationExecutionState getExecutionState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getExecutionState <em>Execution State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execution State</em>' attribute.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see #getExecutionState()
   * @generated
   */
  void setExecutionState(VerificationExecutionState value);

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(VerificationResult)
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_Result()
   * @model containment="true"
   * @generated
   */
  VerificationResult getResult();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(VerificationResult value);

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
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_SucessMsg()
   * @model
   * @generated
   */
  String getSucessMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationActivityResult#getSucessMsg <em>Sucess Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sucess Msg</em>' attribute.
   * @see #getSucessMsg()
   * @generated
   */
  void setSucessMsg(String value);

  /**
   * Returns the value of the '<em><b>Assumption Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.AssumptionResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assumption Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assumption Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_AssumptionResult()
   * @model containment="true"
   * @generated
   */
  EList<AssumptionResult> getAssumptionResult();

  /**
   * Returns the value of the '<em><b>Precondition Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.PreconditionResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Precondition Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationActivityResult_PreconditionResult()
   * @model containment="true"
   * @generated
   */
  EList<PreconditionResult> getPreconditionResult();

} // VerificationActivityResult
