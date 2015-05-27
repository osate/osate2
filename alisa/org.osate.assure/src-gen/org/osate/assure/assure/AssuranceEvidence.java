/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.ComponentClassifier;

import org.osate.aadl2.instance.InstanceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Evidence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssuranceEvidence#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceEvidence#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceEvidence#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceEvidence#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceEvidence#getSubAssuranceEvidence <em>Sub Assurance Evidence</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssuranceEvidence#getClaimResult <em>Claim Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssuranceEvidence()
 * @model
 * @generated
 */
public interface AssuranceEvidence extends AssureResult
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
   * @see org.osate.assure.assure.AssurePackage#getAssuranceEvidence_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceEvidence#getName <em>Name</em>}' attribute.
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
   * @see #setTarget(ComponentClassifier)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceEvidence_Target()
   * @model
   * @generated
   */
  ComponentClassifier getTarget();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceEvidence#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ComponentClassifier value);

  /**
   * Returns the value of the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance</em>' reference.
   * @see #setInstance(InstanceObject)
   * @see org.osate.assure.assure.AssurePackage#getAssuranceEvidence_Instance()
   * @model
   * @generated
   */
  InstanceObject getInstance();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceEvidence#getInstance <em>Instance</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance</em>' reference.
   * @see #getInstance()
   * @generated
   */
  void setInstance(InstanceObject value);

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
   * @see org.osate.assure.assure.AssurePackage#getAssuranceEvidence_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssuranceEvidence#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

  /**
   * Returns the value of the '<em><b>Sub Assurance Evidence</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.AssuranceEvidence}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Assurance Evidence</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Assurance Evidence</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getAssuranceEvidence_SubAssuranceEvidence()
   * @model containment="true"
   * @generated
   */
  EList<AssuranceEvidence> getSubAssuranceEvidence();

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
   * @see org.osate.assure.assure.AssurePackage#getAssuranceEvidence_ClaimResult()
   * @model containment="true"
   * @generated
   */
  EList<ClaimResult> getClaimResult();

} // AssuranceEvidence
