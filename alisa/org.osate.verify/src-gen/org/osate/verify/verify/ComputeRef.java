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

import org.eclipse.emf.ecore.EObject;

import org.osate.alisa.common.common.ComputeDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compute Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.ComputeRef#getCompute <em>Compute</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getComputeRef()
 * @model
 * @generated
 */
public interface ComputeRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Compute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Compute</em>' reference.
   * @see #setCompute(ComputeDeclaration)
   * @see org.osate.verify.verify.VerifyPackage#getComputeRef_Compute()
   * @model
   * @generated
   */
  ComputeDeclaration getCompute();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ComputeRef#getCompute <em>Compute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Compute</em>' reference.
   * @see #getCompute()
   * @generated
   */
  void setCompute(ComputeDeclaration value);

} // ComputeRef
