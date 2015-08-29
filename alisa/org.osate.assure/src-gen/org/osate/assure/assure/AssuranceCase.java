/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.alisa.workbench.alisa.AssurancePlan;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getTargetSystem <em>Target System</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getClaimResult <em>Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceCase#getSubAssuranceCase <em>Sub Assurance Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssuranceCase()
 * @model
 * @generated
 */
public interface AssuranceCase extends AssureResult
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceCase#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(AssurancePlan)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_Target()
   * @model
   * @generated
   */
  AssurancePlan getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceCase#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(AssurancePlan value);

  /**
   * Returns the value of the '<em><b>Target System</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target System</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target System</em>' attribute.
   * @see #setTargetSystem(String)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_TargetSystem()
   * @model
   * @generated
   */
  String getTargetSystem();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceCase#getTargetSystem <em>Target System</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target System</em>' attribute.
   * @see #getTargetSystem()
   * @generated
   */
  void setTargetSystem(String value);

  /**
   * Returns the value of the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' attribute.
   * @see #setMessage(String)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceCase#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

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
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_ClaimResult()
   * @model containment="true"
   * @generated
   */
  EList<ClaimResult> getClaimResult();

  /**
   * Returns the value of the '<em><b>Sub Assurance Case</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.AssuranceCase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Assurance Case</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Assurance Case</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getAssuranceCase_SubAssuranceCase()
   * @model containment="true"
   * @generated
   */
  EList<AssuranceCase> getSubAssuranceCase();

} // AssuranceCase
