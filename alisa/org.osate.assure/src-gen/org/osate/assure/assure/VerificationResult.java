/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.verify.verify.VerificationActivity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getVerificationActivity <em>Verification Activity</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getDate <em>Date</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getState <em>State</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getStatus <em>Status</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getAssumptionVerificationResult <em>Assumption Verification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationResult()
 * @model
 * @generated
 */
public interface VerificationResult extends AssuranceResult
{
  /**
   * Returns the value of the '<em><b>Verification Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Activity</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Activity</em>' reference.
   * @see #setVerificationActivity(VerificationActivity)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_VerificationActivity()
   * @model
   * @generated
   */
  VerificationActivity getVerificationActivity();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getVerificationActivity <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification Activity</em>' reference.
   * @see #getVerificationActivity()
   * @generated
   */
  void setVerificationActivity(VerificationActivity value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date</em>' attribute.
   * @see #setDate(String)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Date()
   * @model
   * @generated
   */
  String getDate();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getDate <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date</em>' attribute.
   * @see #getDate()
   * @generated
   */
  void setDate(String value);

  /**
   * Returns the value of the '<em><b>State</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationResultState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #setState(VerificationResultState)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_State()
   * @model
   * @generated
   */
  VerificationResultState getState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getState <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #getState()
   * @generated
   */
  void setState(VerificationResultState value);

  /**
   * Returns the value of the '<em><b>Status</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationResultStatus}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultStatus
   * @see #setStatus(VerificationResultStatus)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Status()
   * @model
   * @generated
   */
  VerificationResultStatus getStatus();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultStatus
   * @see #getStatus()
   * @generated
   */
  void setStatus(VerificationResultStatus value);

  /**
   * Returns the value of the '<em><b>Assumption Verification Result</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assumption Verification Result</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assumption Verification Result</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_AssumptionVerificationResult()
   * @model containment="true"
   * @generated
   */
  EList<VerificationResult> getAssumptionVerificationResult();

} // VerificationResult
