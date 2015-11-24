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
package org.osate.categories.categories;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getRequirementTypeCategories <em>Requirement Type Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getMethodTypeCategories <em>Method Type Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getSelectioncategories <em>Selectioncategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getDevelopmentPhaseCategories <em>Development Phase Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getQualityAttributeCategories <em>Quality Attribute Categories</em>}</li>
 * </ul>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions()
 * @model
 * @generated
 */
public interface CategoriesDefinitions extends EObject
{
  /**
   * Returns the value of the '<em><b>Requirement Type Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Type Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Type Categories</em>' containment reference.
   * @see #setRequirementTypeCategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_RequirementTypeCategories()
   * @model containment="true"
   * @generated
   */
  Categories getRequirementTypeCategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getRequirementTypeCategories <em>Requirement Type Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirement Type Categories</em>' containment reference.
   * @see #getRequirementTypeCategories()
   * @generated
   */
  void setRequirementTypeCategories(Categories value);

  /**
   * Returns the value of the '<em><b>Method Type Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Type Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Type Categories</em>' containment reference.
   * @see #setMethodTypeCategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_MethodTypeCategories()
   * @model containment="true"
   * @generated
   */
  Categories getMethodTypeCategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getMethodTypeCategories <em>Method Type Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Type Categories</em>' containment reference.
   * @see #getMethodTypeCategories()
   * @generated
   */
  void setMethodTypeCategories(Categories value);

  /**
   * Returns the value of the '<em><b>Selectioncategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selectioncategories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selectioncategories</em>' containment reference.
   * @see #setSelectioncategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_Selectioncategories()
   * @model containment="true"
   * @generated
   */
  Categories getSelectioncategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getSelectioncategories <em>Selectioncategories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selectioncategories</em>' containment reference.
   * @see #getSelectioncategories()
   * @generated
   */
  void setSelectioncategories(Categories value);

  /**
   * Returns the value of the '<em><b>Development Phase Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Development Phase Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Development Phase Categories</em>' containment reference.
   * @see #setDevelopmentPhaseCategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_DevelopmentPhaseCategories()
   * @model containment="true"
   * @generated
   */
  Categories getDevelopmentPhaseCategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getDevelopmentPhaseCategories <em>Development Phase Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Development Phase Categories</em>' containment reference.
   * @see #getDevelopmentPhaseCategories()
   * @generated
   */
  void setDevelopmentPhaseCategories(Categories value);

  /**
   * Returns the value of the '<em><b>Quality Attribute Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quality Attribute Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quality Attribute Categories</em>' containment reference.
   * @see #setQualityAttributeCategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_QualityAttributeCategories()
   * @model containment="true"
   * @generated
   */
  Categories getQualityAttributeCategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getQualityAttributeCategories <em>Quality Attribute Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quality Attribute Categories</em>' containment reference.
   * @see #getQualityAttributeCategories()
   * @generated
   */
  void setQualityAttributeCategories(Categories value);

} // CategoriesDefinitions
