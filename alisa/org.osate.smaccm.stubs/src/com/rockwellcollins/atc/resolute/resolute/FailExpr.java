/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fail Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.FailExpr#getVal <em>Val</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.FailExpr#getFailmsg <em>Failmsg</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getFailExpr()
 * @model
 * @generated
 */
public interface FailExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' containment reference.
   * @see #setVal(Expr)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getFailExpr_Val()
   * @model containment="true"
   * @generated
   */
  Expr getVal();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.FailExpr#getVal <em>Val</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' containment reference.
   * @see #getVal()
   * @generated
   */
  void setVal(Expr value);

  /**
   * Returns the value of the '<em><b>Failmsg</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.resolute.resolute.ClaimText}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failmsg</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failmsg</em>' containment reference list.
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getFailExpr_Failmsg()
   * @model containment="true"
   * @generated
   */
  EList<ClaimText> getFailmsg();

} // FailExpr
