/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.SetExpr#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getSetExpr()
 * @model
 * @generated
 */
public interface SetExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exprs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exprs</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getSetExpr_Exprs()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getExprs();

} // SetExpr
