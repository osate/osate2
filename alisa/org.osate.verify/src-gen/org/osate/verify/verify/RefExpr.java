/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ref Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.RefExpr#getVerification <em>Verification</em>}</li>
 *   <li>{@link org.osate.verify.verify.RefExpr#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getRefExpr()
 * @model
 * @generated
 */
public interface RefExpr extends ArgumentExpr
{
  /**
   * Returns the value of the '<em><b>Verification</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification</em>' reference.
   * @see #setVerification(VerificationAction)
   * @see org.osate.verify.verify.VerifyPackage#getRefExpr_Verification()
   * @model
   * @generated
   */
  VerificationAction getVerification();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.RefExpr#getVerification <em>Verification</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification</em>' reference.
   * @see #getVerification()
   * @generated
   */
  void setVerification(VerificationAction value);

  /**
   * Returns the value of the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Weight</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weight</em>' attribute.
   * @see #setWeight(int)
   * @see org.osate.verify.verify.VerifyPackage#getRefExpr_Weight()
   * @model
   * @generated
   */
  int getWeight();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.RefExpr#getWeight <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weight</em>' attribute.
   * @see #getWeight()
   * @generated
   */
  void setWeight(int value);

} // RefExpr
