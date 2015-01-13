/**
 */
package org.osate.verify.verify;

import org.osate.categories.categories.VerificationCategory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Condition Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.AtomicConditionExpr#getCat <em>Cat</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getAtomicConditionExpr()
 * @model
 * @generated
 */
public interface AtomicConditionExpr extends ConditionExpr
{
  /**
   * Returns the value of the '<em><b>Cat</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cat</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cat</em>' reference.
   * @see #setCat(VerificationCategory)
   * @see org.osate.verify.verify.VerifyPackage#getAtomicConditionExpr_Cat()
   * @model
   * @generated
   */
  VerificationCategory getCat();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.AtomicConditionExpr#getCat <em>Cat</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cat</em>' reference.
   * @see #getCat()
   * @generated
   */
  void setCat(VerificationCategory value);

} // AtomicConditionExpr
