/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.CaseResult#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getSubCaseResult <em>Sub Case Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getClaimResult <em>Claim Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getCaseResult()
 * @model
 * @generated
 */
public interface CaseResult extends AssuranceResult
{
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
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_Result()
   * @model containment="true"
   * @generated
   */
  AggregateResultData getResult();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(AggregateResultData value);

  /**
   * Returns the value of the '<em><b>Sub Case Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.CaseResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Case Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Case Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_SubCaseResult()
   * @model containment="true"
   * @generated
   */
  EList<CaseResult> getSubCaseResult();

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
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_ClaimResult()
   * @model containment="true"
   * @generated
   */
  EList<ClaimResult> getClaimResult();

} // CaseResult
