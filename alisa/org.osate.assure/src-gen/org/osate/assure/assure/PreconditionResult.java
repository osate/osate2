/**
 */
package org.osate.assure.assure;

import org.osate.verify.verify.VerificationCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precondition Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.PreconditionResult#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getPreconditionResult()
 * @model
 * @generated
 */
public interface PreconditionResult extends VerificationResult
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
   * @see #setTarget(VerificationCondition)
   * @see org.osate.assure.assure.AssurePackage#getPreconditionResult_Target()
   * @model
   * @generated
   */
  VerificationCondition getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.PreconditionResult#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VerificationCondition value);

} // PreconditionResult
