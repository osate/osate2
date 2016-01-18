/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EObject;

import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationPlan;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified VA Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.QualifiedVAReference#getVerificationPlan <em>Verification Plan</em>}</li>
 *   <li>{@link org.osate.assure.assure.QualifiedVAReference#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.osate.assure.assure.QualifiedVAReference#getVerificationActivity <em>Verification Activity</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getQualifiedVAReference()
 * @model
 * @generated
 */
public interface QualifiedVAReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Verification Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification Plan</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification Plan</em>' reference.
   * @see #setVerificationPlan(VerificationPlan)
   * @see org.osate.assure.assure.AssurePackage#getQualifiedVAReference_VerificationPlan()
   * @model
   * @generated
   */
  VerificationPlan getVerificationPlan();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.QualifiedVAReference#getVerificationPlan <em>Verification Plan</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification Plan</em>' reference.
   * @see #getVerificationPlan()
   * @generated
   */
  void setVerificationPlan(VerificationPlan value);

  /**
   * Returns the value of the '<em><b>Requirement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement</em>' containment reference.
   * @see #setRequirement(NestedClaimReference)
   * @see org.osate.assure.assure.AssurePackage#getQualifiedVAReference_Requirement()
   * @model containment="true"
   * @generated
   */
  NestedClaimReference getRequirement();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.QualifiedVAReference#getRequirement <em>Requirement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirement</em>' containment reference.
   * @see #getRequirement()
   * @generated
   */
  void setRequirement(NestedClaimReference value);

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
   * @see org.osate.assure.assure.AssurePackage#getQualifiedVAReference_VerificationActivity()
   * @model
   * @generated
   */
  VerificationActivity getVerificationActivity();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.QualifiedVAReference#getVerificationActivity <em>Verification Activity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification Activity</em>' reference.
   * @see #getVerificationActivity()
   * @generated
   */
  void setVerificationActivity(VerificationActivity value);

} // QualifiedVAReference
