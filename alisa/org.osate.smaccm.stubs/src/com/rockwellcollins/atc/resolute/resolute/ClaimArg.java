/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Claim Arg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg#getArg <em>Arg</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimArg()
 * @model
 * @generated
 */
public interface ClaimArg extends ClaimText
{
  /**
   * Returns the value of the '<em><b>Arg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arg</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg</em>' reference.
   * @see #setArg(ClaimTextVar)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimArg_Arg()
   * @model
   * @generated
   */
  ClaimTextVar getArg();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg#getArg <em>Arg</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg</em>' reference.
   * @see #getArg()
   * @generated
   */
  void setArg(ClaimTextVar value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitLiteral)
   * @see com.rockwellcollins.atc.resolute.resolute.ResolutePackage#getClaimArg_Unit()
   * @model
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // ClaimArg
