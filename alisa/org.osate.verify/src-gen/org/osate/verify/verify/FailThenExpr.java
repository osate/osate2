/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fail Then Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.FailThenExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.verify.verify.FailThenExpr#isFailed <em>Failed</em>}</li>
 *   <li>{@link org.osate.verify.verify.FailThenExpr#isUnknown <em>Unknown</em>}</li>
 *   <li>{@link org.osate.verify.verify.FailThenExpr#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getFailThenExpr()
 * @model
 * @generated
 */
public interface FailThenExpr extends ArgumentExpr
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
   * @see org.osate.verify.verify.VerifyPackage#getFailThenExpr_Left()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getLeft();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.FailThenExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Failed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failed</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failed</em>' attribute.
   * @see #setFailed(boolean)
   * @see org.osate.verify.verify.VerifyPackage#getFailThenExpr_Failed()
   * @model
   * @generated
   */
  boolean isFailed();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.FailThenExpr#isFailed <em>Failed</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failed</em>' attribute.
   * @see #isFailed()
   * @generated
   */
  void setFailed(boolean value);

  /**
   * Returns the value of the '<em><b>Unknown</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unknown</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unknown</em>' attribute.
   * @see #setUnknown(boolean)
   * @see org.osate.verify.verify.VerifyPackage#getFailThenExpr_Unknown()
   * @model
   * @generated
   */
  boolean isUnknown();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.FailThenExpr#isUnknown <em>Unknown</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unknown</em>' attribute.
   * @see #isUnknown()
   * @generated
   */
  void setUnknown(boolean value);

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
   * @see org.osate.verify.verify.VerifyPackage#getFailThenExpr_Right()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getRight();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.FailThenExpr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(ArgumentExpr value);

} // FailThenExpr
