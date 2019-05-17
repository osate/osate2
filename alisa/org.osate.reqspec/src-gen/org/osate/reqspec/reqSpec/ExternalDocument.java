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
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ExternalDocument#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ExternalDocument#getDocFragment <em>Doc Fragment</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getExternalDocument()
 * @model
 * @generated
 */
public interface ExternalDocument extends EObject
{
  /**
   * Returns the value of the '<em><b>Doc Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Doc Reference</em>' attribute.
   * @see #setDocReference(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getExternalDocument_DocReference()
   * @model
   * @generated
   */
  String getDocReference();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ExternalDocument#getDocReference <em>Doc Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Doc Reference</em>' attribute.
   * @see #getDocReference()
   * @generated
   */
  void setDocReference(String value);

  /**
   * Returns the value of the '<em><b>Doc Fragment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Doc Fragment</em>' attribute.
   * @see #setDocFragment(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getExternalDocument_DocFragment()
   * @model
   * @generated
   */
  String getDocFragment();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ExternalDocument#getDocFragment <em>Doc Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Doc Fragment</em>' attribute.
   * @see #getDocFragment()
   * @generated
   */
  void setDocFragment(String value);

} // ExternalDocument
