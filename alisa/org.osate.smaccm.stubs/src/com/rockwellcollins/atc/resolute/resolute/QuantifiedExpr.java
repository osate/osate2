/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantified Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getQuant <em>Quant</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getArgs <em>Args</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getQuantifiedExpr()
 * @model
 * @generated
 */
public interface QuantifiedExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Quant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quant</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quant</em>' attribute.
   * @see #setQuant(String)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getQuantifiedExpr_Quant()
   * @model
   * @generated
   */
  String getQuant();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getQuant <em>Quant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quant</em>' attribute.
   * @see #getQuant()
   * @generated
   */
  void setQuant(String value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.Arg}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getQuantifiedExpr_Args()
   * @model containment="true"
   * @generated
   */
  EList<Arg> getArgs();

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getQuantifiedExpr_Expr()
   * @model containment="true"
   * @generated
   */
  Expr getExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expr value);

} // QuantifiedExpr
