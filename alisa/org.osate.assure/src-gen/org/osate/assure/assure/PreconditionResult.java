/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.verify.verify.VerificationPrecondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precondition Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.PreconditionResult#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.PreconditionResult#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.PreconditionResult#getVerificationResult <em>Verification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getPreconditionResult()
 * @model
 * @generated
 */
public interface PreconditionResult extends AggregateResult
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(VerificationPrecondition)
   * @see org.osate.assure.assure.AssurePackage#getPreconditionResult_Target()
   * @model
   * @generated
   */
  VerificationPrecondition getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.PreconditionResult#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VerificationPrecondition value);

  /**
   * Returns the value of the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Success Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Success Count</em>' attribute.
   * @see #setSuccessCount(int)
   * @see org.osate.assure.assure.AssurePackage#getPreconditionResult_SuccessCount()
   * @model
   * @generated
   */
  int getSuccessCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.PreconditionResult#getSuccessCount <em>Success Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Success Count</em>' attribute.
   * @see #getSuccessCount()
   * @generated
   */
  void setSuccessCount(int value);

  /**
   * Returns the value of the '<em><b>Verification Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationActivityResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getPreconditionResult_VerificationResult()
   * @model containment="true"
   * @generated
   */
  EList<VerificationActivityResult> getVerificationResult();

} // PreconditionResult
