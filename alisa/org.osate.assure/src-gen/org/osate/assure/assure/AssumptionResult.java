/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.verify.verify.VerificationAssumption;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assumption Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssumptionResult#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssumptionResult#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssumptionResult#getSucessMsg <em>Sucess Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssumptionResult#getVerificationActivityResult <em>Verification Activity Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssumptionResult()
 * @model
 * @generated
 */
public interface AssumptionResult extends AssureResult
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
   * @see org.osate.assure.assure.AssurePackage#getAssumptionResult_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssumptionResult#getName <em>Name</em>}' attribute.
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
   * @see #setTarget(VerificationAssumption)
   * @see org.osate.assure.assure.AssurePackage#getAssumptionResult_Target()
   * @model
   * @generated
   */
  VerificationAssumption getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssumptionResult#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VerificationAssumption value);

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
   * @see org.osate.assure.assure.AssurePackage#getAssumptionResult_SucessMsg()
   * @model
   * @generated
   */
  String getSucessMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssumptionResult#getSucessMsg <em>Sucess Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sucess Msg</em>' attribute.
   * @see #getSucessMsg()
   * @generated
   */
  void setSucessMsg(String value);

  /**
   * Returns the value of the '<em><b>Verification Activity Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Activity Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Activity Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getAssumptionResult_VerificationActivityResult()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getVerificationActivityResult();

} // AssumptionResult
