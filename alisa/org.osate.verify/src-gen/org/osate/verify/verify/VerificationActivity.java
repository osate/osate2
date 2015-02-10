/**
 */
package org.osate.verify.verify;

import org.osate.alisa.common.common.ComputeDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getMethod <em>Method</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getComputeVariable <em>Compute Variable</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getRationale <em>Rationale</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity()
 * @model
 * @generated
 */
public interface VerificationActivity extends VerificationAction
{
  /**
   * Returns the value of the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' reference.
   * @see #setMethod(VerificationMethod)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Method()
   * @model
   * @generated
   */
  VerificationMethod getMethod();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getMethod <em>Method</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' reference.
   * @see #getMethod()
   * @generated
   */
  void setMethod(VerificationMethod value);

  /**
   * Returns the value of the '<em><b>Compute Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compute Variable</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compute Variable</em>' reference.
   * @see #setComputeVariable(ComputeDeclaration)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_ComputeVariable()
   * @model
   * @generated
   */
  ComputeDeclaration getComputeVariable();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getComputeVariable <em>Compute Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compute Variable</em>' reference.
   * @see #getComputeVariable()
   * @generated
   */
  void setComputeVariable(ComputeDeclaration value);

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' attribute.
   * @see #setTimeout(int)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Timeout()
   * @model
   * @generated
   */
  int getTimeout();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getTimeout <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' attribute.
   * @see #getTimeout()
   * @generated
   */
  void setTimeout(int value);

  /**
   * Returns the value of the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rationale</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rationale</em>' attribute.
   * @see #setRationale(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Rationale()
   * @model
   * @generated
   */
  String getRationale();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getRationale <em>Rationale</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rationale</em>' attribute.
   * @see #getRationale()
   * @generated
   */
  void setRationale(String value);

} // VerificationActivity
