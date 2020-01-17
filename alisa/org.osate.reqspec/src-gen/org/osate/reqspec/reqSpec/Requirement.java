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

import org.osate.aadl2.ComponentCategory;

import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.TargetType;

import org.osate.organization.organization.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getException <em>Exception</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getExceptionText <em>Exception Text</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getInheritsReference <em>Inherits Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getComputes <em>Computes</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getRefinesReference <em>Refines Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getDecomposesReference <em>Decomposes Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getDevelopmentStakeholder <em>Development Stakeholder</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getRequirementReference <em>Requirement Reference</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getComponentCategory <em>Component Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.Requirement#getTargetType <em>Target Type</em>}</li>
 * </ul>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends ContractualElement
{
  /**
   * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate</em>' containment reference.
   * @see #setPredicate(ReqPredicate)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Predicate()
   * @model containment="true"
   * @generated
   */
  ReqPredicate getPredicate();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getPredicate <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate</em>' containment reference.
   * @see #getPredicate()
   * @generated
   */
  void setPredicate(ReqPredicate value);

  /**
   * Returns the value of the '<em><b>Exception</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception</em>' reference.
   * @see #setException(EObject)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Exception()
   * @model
   * @generated
   */
  EObject getException();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getException <em>Exception</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception</em>' reference.
   * @see #getException()
   * @generated
   */
  void setException(EObject value);

  /**
   * Returns the value of the '<em><b>Exception Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exception Text</em>' attribute.
   * @see #setExceptionText(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_ExceptionText()
   * @model
   * @generated
   */
  String getExceptionText();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getExceptionText <em>Exception Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exception Text</em>' attribute.
   * @see #getExceptionText()
   * @generated
   */
  void setExceptionText(String value);

  /**
   * Returns the value of the '<em><b>Inherits Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inherits Reference</em>' reference.
   * @see #setInheritsReference(Requirement)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_InheritsReference()
   * @model
   * @generated
   */
  Requirement getInheritsReference();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getInheritsReference <em>Inherits Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inherits Reference</em>' reference.
   * @see #getInheritsReference()
   * @generated
   */
  void setInheritsReference(Requirement value);

  /**
   * Returns the value of the '<em><b>Computes</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.AVariableDeclaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Computes</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_Computes()
   * @model containment="true"
   * @generated
   */
  EList<AVariableDeclaration> getComputes();

  /**
   * Returns the value of the '<em><b>Refines Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refines Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_RefinesReference()
   * @model
   * @generated
   */
  EList<Requirement> getRefinesReference();

  /**
   * Returns the value of the '<em><b>Decomposes Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decomposes Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_DecomposesReference()
   * @model
   * @generated
   */
  EList<Requirement> getDecomposesReference();

  /**
   * Returns the value of the '<em><b>Development Stakeholder</b></em>' reference list.
   * The list contents are of type {@link org.osate.organization.organization.Stakeholder}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Development Stakeholder</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_DevelopmentStakeholder()
   * @model
   * @generated
   */
  EList<Stakeholder> getDevelopmentStakeholder();

  /**
   * Returns the value of the '<em><b>Requirement Reference</b></em>' reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.Requirement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Reference</em>' reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_RequirementReference()
   * @model
   * @generated
   */
  EList<Requirement> getRequirementReference();

  /**
   * Returns the value of the '<em><b>Component Category</b></em>' attribute list.
   * The list contents are of type {@link org.osate.aadl2.ComponentCategory}.
   * The literals are from the enumeration {@link org.osate.aadl2.ComponentCategory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component Category</em>' attribute list.
   * @see org.osate.aadl2.ComponentCategory
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_ComponentCategory()
   * @model unique="false"
   * @generated
   */
  EList<ComponentCategory> getComponentCategory();

  /**
   * Returns the value of the '<em><b>Target Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.alisa.common.common.TargetType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Type</em>' attribute.
   * @see org.osate.alisa.common.common.TargetType
   * @see #setTargetType(TargetType)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRequirement_TargetType()
   * @model
   * @generated
   */
  TargetType getTargetType();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.Requirement#getTargetType <em>Target Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Type</em>' attribute.
   * @see org.osate.alisa.common.common.TargetType
   * @see #getTargetType()
   * @generated
   */
  void setTargetType(TargetType value);

} // Requirement
