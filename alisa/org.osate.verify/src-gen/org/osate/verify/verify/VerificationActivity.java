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
package org.osate.verify.verify;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PropertyExpression;

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getMethod <em>Method</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getActuals <em>Actuals</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationActivity#getWeight <em>Weight</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity()
 * @model
 * @generated
 */
public interface VerificationActivity extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getName <em>Name</em>}' attribute.
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
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Computes</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.verify.verify.ComputeRef}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Computes</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Computes()
   * @model containment="true"
   * @generated
   */
  EList<ComputeRef> getComputes();

  /**
   * Returns the value of the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' reference.
   * @see #setMethod(VerificationMethod)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Method()
   * @model
   * @generated
   */
  VerificationMethod getMethod();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getMethod <em>Method</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' reference.
   * @see #getMethod()
   * @generated
   */
  void setMethod(VerificationMethod value);

  /**
   * Returns the value of the '<em><b>Actuals</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.PropertyExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actuals</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Actuals()
   * @model containment="true"
   * @generated
   */
  EList<PropertyExpression> getActuals();

  /**
   * Returns the value of the '<em><b>Property Values</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.PropertyExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Values</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_PropertyValues()
   * @model containment="true"
   * @generated
   */
  EList<PropertyExpression> getPropertyValues();

  /**
   * Returns the value of the '<em><b>Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.Category}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Category()
   * @model
   * @generated
   */
  EList<Category> getCategory();

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' containment reference.
   * @see #setTimeout(IntegerLiteral)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Timeout()
   * @model containment="true"
   * @generated
   */
  IntegerLiteral getTimeout();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getTimeout <em>Timeout</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' containment reference.
   * @see #getTimeout()
   * @generated
   */
  void setTimeout(IntegerLiteral value);

  /**
   * Returns the value of the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weight</em>' attribute.
   * @see #setWeight(int)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationActivity_Weight()
   * @model
   * @generated
   */
  int getWeight();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationActivity#getWeight <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weight</em>' attribute.
   * @see #getWeight()
   * @generated
   */
  void setWeight(int value);

} // VerificationActivity
