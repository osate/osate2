/**
 */
package com.rockwellcollins.atc.resolute.resolute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getCond <em>Cond</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getThen <em>Then</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr()
 * @model
 * @generated
 */
public interface IfThenElseExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond</em>' containment reference.
   * @see #setCond(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr_Cond()
   * @model containment="true"
   * @generated
   */
  Expr getCond();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(Expr value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr_Then()
   * @model containment="true"
   * @generated
   */
  Expr getThen();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Expr value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIfThenElseExpr_Else()
   * @model containment="true"
   * @generated
   */
  Expr getElse();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Expr value);

} // IfThenElseExpr
