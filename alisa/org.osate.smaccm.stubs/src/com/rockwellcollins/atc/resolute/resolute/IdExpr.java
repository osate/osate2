/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.IdExpr#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIdExpr()
 * @model
 * @generated
 */
public interface IdExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' reference.
   * @see #setId(NamedElement)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getIdExpr_Id()
   * @model
   * @generated
   */
  NamedElement getId();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.IdExpr#getId <em>Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' reference.
   * @see #getId()
   * @generated
   */
  void setId(NamedElement value);

} // IdExpr
