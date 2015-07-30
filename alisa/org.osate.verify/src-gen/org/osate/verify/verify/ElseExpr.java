/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getOther <em>Other</em>}</li>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getFail <em>Fail</em>}</li>
 *   <li>{@link org.osate.verify.verify.ElseExpr#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getElseExpr()
 * @model
 * @generated
 */
public interface ElseExpr extends ArgumentExpr
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
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Left()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getLeft();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Other</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Other</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Other</em>' containment reference.
   * @see #setOther(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Other()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getOther();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getOther <em>Other</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Other</em>' containment reference.
   * @see #getOther()
   * @generated
   */
  void setOther(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Fail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail</em>' containment reference.
   * @see #setFail(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Fail()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getFail();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getFail <em>Fail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail</em>' containment reference.
   * @see #getFail()
   * @generated
   */
  void setFail(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' containment reference.
   * @see #setTimeout(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getElseExpr_Timeout()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getTimeout();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ElseExpr#getTimeout <em>Timeout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' containment reference.
   * @see #getTimeout()
   * @generated
   */
  void setTimeout(ArgumentExpr value);

} // ElseExpr
