/**
 */
package org.osate.reqspec.reqSpec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getIfExpr <em>If Expr</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getThenExpr <em>Then Expr</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getElseExpr <em>Else Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIfThenElseExpr()
 * @model
 * @generated
 */
public interface IfThenElseExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>If Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Expr</em>' containment reference.
   * @see #setIfExpr(Expr)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIfThenElseExpr_IfExpr()
   * @model containment="true"
   * @generated
   */
  Expr getIfExpr();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getIfExpr <em>If Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Expr</em>' containment reference.
   * @see #getIfExpr()
   * @generated
   */
  void setIfExpr(Expr value);

  /**
   * Returns the value of the '<em><b>Then Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Expr</em>' containment reference.
   * @see #setThenExpr(Expr)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIfThenElseExpr_ThenExpr()
   * @model containment="true"
   * @generated
   */
  Expr getThenExpr();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getThenExpr <em>Then Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Expr</em>' containment reference.
   * @see #getThenExpr()
   * @generated
   */
  void setThenExpr(Expr value);

  /**
   * Returns the value of the '<em><b>Else Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Expr</em>' containment reference.
   * @see #setElseExpr(Expr)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIfThenElseExpr_ElseExpr()
   * @model containment="true"
   * @generated
   */
  Expr getElseExpr();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getElseExpr <em>Else Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Expr</em>' containment reference.
   * @see #getElseExpr()
   * @generated
   */
  void setElseExpr(Expr value);

} // IfThenElseExpr
