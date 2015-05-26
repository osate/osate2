/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.ecore.EObject;

import org.osate.alisa.common.common.ComputeDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Activity Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationActivityParameter#getCompute <em>Compute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationActivityParameter()
 * @model
 * @generated
 */
public interface VerificationActivityParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Compute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Compute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compute</em>' reference.
   * @see #setCompute(ComputeDeclaration)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivityParameter_Compute()
   * @model
   * @generated
   */
  ComputeDeclaration getCompute();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivityParameter#getCompute <em>Compute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compute</em>' reference.
   * @see #getCompute()
   * @generated
   */
  void setCompute(ComputeDeclaration value);

} // VerificationActivityParameter
