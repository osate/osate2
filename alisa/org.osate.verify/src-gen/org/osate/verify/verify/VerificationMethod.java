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

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Property;

import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.TargetType;

import org.osate.categories.categories.Category;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getFormals <em>Formals</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#isIsPredicate <em>Is Predicate</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#isIsResultReport <em>Is Result Report</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getMethodKind <em>Method Kind</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getValidation <em>Validation</em>}</li>
 *   <li>{@link org.osate.verify.verify.VerificationMethod#getCategory <em>Category</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod()
 * @model
 * @generated
 */
public interface VerificationMethod extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Target Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.alisa.common.common.TargetType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Type</em>' attribute.
   * @see org.osate.alisa.common.common.TargetType
   * @see #setTargetType(TargetType)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_TargetType()
   * @model
   * @generated
   */
  TargetType getTargetType();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getTargetType <em>Target Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Type</em>' attribute.
   * @see org.osate.alisa.common.common.TargetType
   * @see #getTargetType()
   * @generated
   */
  void setTargetType(TargetType value);

  /**
   * Returns the value of the '<em><b>Formals</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.verify.verify.FormalParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formals</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Formals()
   * @model containment="true"
   * @generated
   */
  EList<FormalParameter> getFormals();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' reference list.
   * The list contents are of type {@link org.osate.aadl2.Property}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Properties()
   * @model
   * @generated
   */
  EList<Property> getProperties();

  /**
   * Returns the value of the '<em><b>Results</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.verify.verify.FormalParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Results</em>' containment reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Results()
   * @model containment="true"
   * @generated
   */
  EList<FormalParameter> getResults();

  /**
   * Returns the value of the '<em><b>Is Predicate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Predicate</em>' attribute.
   * @see #setIsPredicate(boolean)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_IsPredicate()
   * @model
   * @generated
   */
  boolean isIsPredicate();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#isIsPredicate <em>Is Predicate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Predicate</em>' attribute.
   * @see #isIsPredicate()
   * @generated
   */
  void setIsPredicate(boolean value);

  /**
   * Returns the value of the '<em><b>Is Result Report</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Result Report</em>' attribute.
   * @see #setIsResultReport(boolean)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_IsResultReport()
   * @model
   * @generated
   */
  boolean isIsResultReport();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#isIsResultReport <em>Is Result Report</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Result Report</em>' attribute.
   * @see #isIsResultReport()
   * @generated
   */
  void setIsResultReport(boolean value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(ComponentClassifier)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Target()
   * @model
   * @generated
   */
  ComponentClassifier getTarget();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ComponentClassifier value);

  /**
   * Returns the value of the '<em><b>Component Category</b></em>' attribute list.
   * The list contents are of type {@link org.osate.aadl2.ComponentCategory}.
   * The literals are from the enumeration {@link org.osate.aadl2.ComponentCategory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Category</em>' attribute list.
   * @see org.osate.aadl2.ComponentCategory
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_ComponentCategory()
   * @model unique="false"
   * @generated
   */
  EList<ComponentCategory> getComponentCategory();

  /**
   * Returns the value of the '<em><b>Method Kind</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Kind</em>' containment reference.
   * @see #setMethodKind(MethodKind)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_MethodKind()
   * @model containment="true"
   * @generated
   */
  MethodKind getMethodKind();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getMethodKind <em>Method Kind</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Kind</em>' containment reference.
   * @see #getMethodKind()
   * @generated
   */
  void setMethodKind(MethodKind value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Precondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition</em>' containment reference.
   * @see #setPrecondition(VerificationCondition)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Precondition()
   * @model containment="true"
   * @generated
   */
  VerificationCondition getPrecondition();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getPrecondition <em>Precondition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precondition</em>' containment reference.
   * @see #getPrecondition()
   * @generated
   */
  void setPrecondition(VerificationCondition value);

  /**
   * Returns the value of the '<em><b>Validation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Validation</em>' containment reference.
   * @see #setValidation(VerificationCondition)
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Validation()
   * @model containment="true"
   * @generated
   */
  VerificationCondition getValidation();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.VerificationMethod#getValidation <em>Validation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Validation</em>' containment reference.
   * @see #getValidation()
   * @generated
   */
  void setValidation(VerificationCondition value);

  /**
   * Returns the value of the '<em><b>Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.Category}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' reference list.
   * @see org.osate.verify.verify.VerifyPackage#getVerificationMethod_Category()
   * @model
   * @generated
   */
  EList<Category> getCategory();

} // VerificationMethod
