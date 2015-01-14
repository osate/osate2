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
 *   <li>{@link org.osate.assure.assure.CaseResult#getPassCount <em>Pass Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getNeutralCount <em>Neutral Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getUnknownCount <em>Unknown Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getSucessMsg <em>Sucess Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getFailMsg <em>Fail Msg</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getSubCaseResult <em>Sub Case Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getClaimResult <em>Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.CaseResult#getHazardResult <em>Hazard Result</em>}</li>
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
   * Returns the value of the '<em><b>Pass Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pass Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pass Count</em>' attribute.
   * @see #setPassCount(int)
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_PassCount()
   * @model
   * @generated
   */
  int getPassCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getPassCount <em>Pass Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pass Count</em>' attribute.
   * @see #getPassCount()
   * @generated
   */
  void setPassCount(int value);

  /**
   * Returns the value of the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail Count</em>' attribute.
   * @see #setFailCount(int)
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_FailCount()
   * @model
   * @generated
   */
  int getFailCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getFailCount <em>Fail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Count</em>' attribute.
   * @see #getFailCount()
   * @generated
   */
  void setFailCount(int value);

  /**
   * Returns the value of the '<em><b>Neutral Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Neutral Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Neutral Count</em>' attribute.
   * @see #setNeutralCount(int)
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_NeutralCount()
   * @model
   * @generated
   */
  int getNeutralCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getNeutralCount <em>Neutral Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Neutral Count</em>' attribute.
   * @see #getNeutralCount()
   * @generated
   */
  void setNeutralCount(int value);

  /**
   * Returns the value of the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unknown Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unknown Count</em>' attribute.
   * @see #setUnknownCount(int)
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_UnknownCount()
   * @model
   * @generated
   */
  int getUnknownCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getUnknownCount <em>Unknown Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unknown Count</em>' attribute.
   * @see #getUnknownCount()
   * @generated
   */
  void setUnknownCount(int value);

  /**
   * Returns the value of the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Weight</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weight</em>' attribute.
   * @see #setWeight(int)
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_Weight()
   * @model
   * @generated
   */
  int getWeight();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getWeight <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weight</em>' attribute.
   * @see #getWeight()
   * @generated
   */
  void setWeight(int value);

  /**
   * Returns the value of the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sucess Msg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sucess Msg</em>' attribute.
   * @see #setSucessMsg(String)
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_SucessMsg()
   * @model
   * @generated
   */
  String getSucessMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getSucessMsg <em>Sucess Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sucess Msg</em>' attribute.
   * @see #getSucessMsg()
   * @generated
   */
  void setSucessMsg(String value);

  /**
   * Returns the value of the '<em><b>Fail Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail Msg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail Msg</em>' attribute.
   * @see #setFailMsg(String)
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_FailMsg()
   * @model
   * @generated
   */
  String getFailMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.CaseResult#getFailMsg <em>Fail Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Msg</em>' attribute.
   * @see #getFailMsg()
   * @generated
   */
  void setFailMsg(String value);

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

  /**
   * Returns the value of the '<em><b>Hazard Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.HazardResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hazard Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hazard Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getCaseResult_HazardResult()
   * @model containment="true"
   * @generated
   */
  EList<HazardResult> getHazardResult();

} // CaseResult
