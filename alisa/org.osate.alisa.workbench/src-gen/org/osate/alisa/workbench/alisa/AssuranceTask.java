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
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.common.util.EList;

import org.osate.alisa.common.common.Description;

import org.osate.categories.categories.DevelopmentPhase;
import org.osate.categories.categories.MethodType;
import org.osate.categories.categories.QualityAttribute;
import org.osate.categories.categories.RequirementType;
import org.osate.categories.categories.UserSelection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assurance Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getTitle <em>Title</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyRequirementType <em>Any Requirement Type</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyMethodType <em>Any Method Type</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getUserSelection <em>User Selection</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyUserSelection <em>Any User Selection</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getQualityAttribute <em>Quality Attribute</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyQualityAttribute <em>Any Quality Attribute</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDevelopmentPhase <em>Development Phase</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyDevelopmentPhase <em>Any Development Phase</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.AssuranceTask#getIssues <em>Issues</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask()
 * @model
 * @generated
 */
public interface AssuranceTask extends CategoryFilter
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getName <em>Name</em>}' attribute.
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
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Assurance Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assurance Plan</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assurance Plan</em>' reference.
   * @see #setAssurancePlan(AssurancePlan)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AssurancePlan()
   * @model
   * @generated
   */
  AssurancePlan getAssurancePlan();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assurance Plan</em>' reference.
   * @see #getAssurancePlan()
   * @generated
   */
  void setAssurancePlan(AssurancePlan value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Description()
   * @model containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

  /**
   * Returns the value of the '<em><b>Requirement Type</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.RequirementType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Type</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Type</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_RequirementType()
   * @model
   * @generated
   */
  EList<RequirementType> getRequirementType();

  /**
   * Returns the value of the '<em><b>Any Requirement Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Requirement Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Requirement Type</em>' attribute.
   * @see #setAnyRequirementType(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AnyRequirementType()
   * @model
   * @generated
   */
  boolean isAnyRequirementType();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyRequirementType <em>Any Requirement Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any Requirement Type</em>' attribute.
   * @see #isAnyRequirementType()
   * @generated
   */
  void setAnyRequirementType(boolean value);

  /**
   * Returns the value of the '<em><b>Method Type</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.MethodType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Type</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Type</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_MethodType()
   * @model
   * @generated
   */
  EList<MethodType> getMethodType();

  /**
   * Returns the value of the '<em><b>Any Method Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Method Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Method Type</em>' attribute.
   * @see #setAnyMethodType(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AnyMethodType()
   * @model
   * @generated
   */
  boolean isAnyMethodType();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyMethodType <em>Any Method Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any Method Type</em>' attribute.
   * @see #isAnyMethodType()
   * @generated
   */
  void setAnyMethodType(boolean value);

  /**
   * Returns the value of the '<em><b>User Selection</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.UserSelection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Selection</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Selection</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_UserSelection()
   * @model
   * @generated
   */
  EList<UserSelection> getUserSelection();

  /**
   * Returns the value of the '<em><b>Any User Selection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any User Selection</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any User Selection</em>' attribute.
   * @see #setAnyUserSelection(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AnyUserSelection()
   * @model
   * @generated
   */
  boolean isAnyUserSelection();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyUserSelection <em>Any User Selection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any User Selection</em>' attribute.
   * @see #isAnyUserSelection()
   * @generated
   */
  void setAnyUserSelection(boolean value);

  /**
   * Returns the value of the '<em><b>Quality Attribute</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.QualityAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quality Attribute</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quality Attribute</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_QualityAttribute()
   * @model
   * @generated
   */
  EList<QualityAttribute> getQualityAttribute();

  /**
   * Returns the value of the '<em><b>Any Quality Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Quality Attribute</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Quality Attribute</em>' attribute.
   * @see #setAnyQualityAttribute(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AnyQualityAttribute()
   * @model
   * @generated
   */
  boolean isAnyQualityAttribute();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyQualityAttribute <em>Any Quality Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any Quality Attribute</em>' attribute.
   * @see #isAnyQualityAttribute()
   * @generated
   */
  void setAnyQualityAttribute(boolean value);

  /**
   * Returns the value of the '<em><b>Development Phase</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.DevelopmentPhase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Development Phase</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Development Phase</em>' reference list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_DevelopmentPhase()
   * @model
   * @generated
   */
  EList<DevelopmentPhase> getDevelopmentPhase();

  /**
   * Returns the value of the '<em><b>Any Development Phase</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Development Phase</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Development Phase</em>' attribute.
   * @see #setAnyDevelopmentPhase(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_AnyDevelopmentPhase()
   * @model
   * @generated
   */
  boolean isAnyDevelopmentPhase();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyDevelopmentPhase <em>Any Development Phase</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any Development Phase</em>' attribute.
   * @see #isAnyDevelopmentPhase()
   * @generated
   */
  void setAnyDevelopmentPhase(boolean value);

  /**
   * Returns the value of the '<em><b>Issues</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issues</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' attribute list.
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getAssuranceTask_Issues()
   * @model unique="false"
   * @generated
   */
  EList<String> getIssues();

} // AssuranceTask
