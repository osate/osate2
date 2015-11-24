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
package org.osate.verify.verify;

import org.osate.reqspec.reqSpec.GlobalRequirements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Verification Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.GlobalVerificationPlan#getRequirements <em>Requirements</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getGlobalVerificationPlan()
 * @model
 * @generated
 */
public interface GlobalVerificationPlan extends VerificationPlan
{
  /**
   * Returns the value of the '<em><b>Requirements</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirements</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' reference.
   * @see #setRequirements(GlobalRequirements)
   * @see org.osate.verify.verify.VerifyPackage#getGlobalVerificationPlan_Requirements()
   * @model
   * @generated
   */
  GlobalRequirements getRequirements();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.GlobalVerificationPlan#getRequirements <em>Requirements</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirements</em>' reference.
   * @see #getRequirements()
   * @generated
   */
  void setRequirements(GlobalRequirements value);

} // GlobalVerificationPlan
