/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Then Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.AndThenExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.verify.verify.AndThenExpr#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getAndThenExpr()
 * @model
 * @generated
 */
public interface AndThenExpr extends ArgumentExpr
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getAndThenExpr_Left()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getLeft();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.AndThenExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getAndThenExpr_Right()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getRight();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.AndThenExpr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(ArgumentExpr value);

} // AndThenExpr
