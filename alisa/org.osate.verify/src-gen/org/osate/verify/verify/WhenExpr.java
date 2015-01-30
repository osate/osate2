/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.common.util.EList;

import org.osate.categories.categories.VerificationCategory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>When Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.WhenExpr#getVerification <em>Verification</em>}</li>
 *   <li>{@link org.osate.verify.verify.WhenExpr#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getWhenExpr()
 * @model
 * @generated
 */
public interface WhenExpr extends ArgumentExpr
{
  /**
   * Returns the value of the '<em><b>Verification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification</em>' containment reference.
   * @see #setVerification(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getWhenExpr_Verification()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getVerification();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.WhenExpr#getVerification <em>Verification</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification</em>' containment reference.
   * @see #getVerification()
   * @generated
   */
  void setVerification(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.VerificationCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getWhenExpr_Condition()
   * @model
   * @generated
   */
  EList<VerificationCategory> getCondition();

} // WhenExpr
