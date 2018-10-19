/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Built In Fn Call Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr#getFn <em>Fn</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getBuiltInFnCallExpr()
 * @model
 * @generated
 */
public interface BuiltInFnCallExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Fn</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fn</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fn</em>' attribute.
   * @see #setFn(String)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getBuiltInFnCallExpr_Fn()
   * @model
   * @generated
   */
  String getFn();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr#getFn <em>Fn</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fn</em>' attribute.
   * @see #getFn()
   * @generated
   */
  void setFn(String value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getBuiltInFnCallExpr_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getArgs();

} // BuiltInFnCallExpr
