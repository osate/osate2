/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
