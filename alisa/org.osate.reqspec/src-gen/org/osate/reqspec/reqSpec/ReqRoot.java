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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.alisa.common.common.Description;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Req Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqRoot#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqRoot#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqRoot#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqRoot#getDocReference <em>Doc Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqRoot#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqRoot()
 * @model
 * @generated
 */
public interface ReqRoot extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqRoot_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqRoot#getName <em>Name</em>}' attribute.
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqRoot_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqRoot#getTitle <em>Title</em>}' attribute.
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqRoot_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqRoot#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Doc Reference</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.ExternalDocument}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Doc Reference</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqRoot_DocReference()
   * @model containment="true"
   * @generated
   */
  EList<ExternalDocument> getDocReference();

  /**
   * Returns the value of the '<em><b>Issues</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' attribute list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqRoot_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

} // ReqRoot
