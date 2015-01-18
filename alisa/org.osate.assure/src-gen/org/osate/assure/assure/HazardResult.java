/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.reqspec.reqSpec.Hazard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hazard Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.HazardResult#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.HazardResult#getPassCount <em>Pass Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.HazardResult#getClaimResult <em>Claim Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getHazardResult()
 * @model
 * @generated
 */
public interface HazardResult extends AggregateResult
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Hazard)
   * @see org.osate.assure.assure.AssurePackage#getHazardResult_Target()
   * @model
   * @generated
   */
  Hazard getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.HazardResult#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Hazard value);

  /**
   * Returns the value of the '<em><b>Pass Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pass Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pass Count</em>' attribute.
   * @see #setPassCount(int)
   * @see org.osate.assure.assure.AssurePackage#getHazardResult_PassCount()
   * @model
   * @generated
   */
  int getPassCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.HazardResult#getPassCount <em>Pass Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pass Count</em>' attribute.
   * @see #getPassCount()
   * @generated
   */
  void setPassCount(int value);

  /**
   * Returns the value of the '<em><b>Claim Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.ClaimResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Claim Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Claim Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getHazardResult_ClaimResult()
   * @model containment="true"
   * @generated
   */
  EList<ClaimResult> getClaimResult();

} // HazardResult
