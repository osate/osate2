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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.alisa.common.common.Description;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Method Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationMethodRegistry#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethodRegistry#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethodRegistry#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethodRegistry#getMethods <em>Methods</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationMethodRegistry()
 * @model
 * @generated
 */
public interface VerificationMethodRegistry extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethodRegistry_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethodRegistry#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethodRegistry_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethodRegistry#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethodRegistry_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethodRegistry#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.verify.verify.VerificationMethod}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Methods</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethodRegistry_Methods()
   * @model containment="true"
   * @generated
   */
  EList<VerificationMethod> getMethods();

} // VerificationMethodRegistry
