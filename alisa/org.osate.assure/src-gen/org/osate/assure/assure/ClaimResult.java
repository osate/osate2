/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Claim Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getSubClaimResult <em>Sub Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.ClaimResult#getVerificationResult <em>Verification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getClaimResult()
 * @model
 * @generated
 */
public interface ClaimResult extends AssuranceResult
{
  /**
   * Returns the value of the '<em><b>Requirement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement</em>' reference.
   * @see #setRequirement(Requirement)
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_Requirement()
   * @model
   * @generated
   */
  Requirement getRequirement();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.ClaimResult#getRequirement <em>Requirement</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirement</em>' reference.
   * @see #getRequirement()
   * @generated
   */
  void setRequirement(Requirement value);

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(AggregateResultData)
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_Result()
   * @model containment="true"
   * @generated
   */
  AggregateResultData getResult();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.ClaimResult#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(AggregateResultData value);

  /**
   * Returns the value of the '<em><b>Sub Claim Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.ClaimResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Claim Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Claim Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_SubClaimResult()
   * @model containment="true"
   * @generated
   */
  EList<ClaimResult> getSubClaimResult();

  /**
   * Returns the value of the '<em><b>Verification Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getClaimResult_VerificationResult()
   * @model containment="true"
   * @generated
   */
  EList<VerificationResult> getVerificationResult();

} // ClaimResult
