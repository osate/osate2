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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.categories.categories.CategoriesPackage
 * @generated
 */
public interface CategoriesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CategoriesFactory eINSTANCE = org.osate.categories.categories.impl.CategoriesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Definitions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Definitions</em>'.
   * @generated
   */
  CategoriesDefinitions createCategoriesDefinitions();

  /**
   * Returns a new object of class '<em>Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Categories</em>'.
   * @generated
   */
  Categories createCategories();

  /**
   * Returns a new object of class '<em>Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Category</em>'.
   * @generated
   */
  Category createCategory();

  /**
   * Returns a new object of class '<em>Category Filter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Category Filter</em>'.
   * @generated
   */
  CategoryFilter createCategoryFilter();

  /**
   * Returns a new object of class '<em>Requirement Type Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement Type Categories</em>'.
   * @generated
   */
  RequirementTypeCategories createRequirementTypeCategories();

  /**
   * Returns a new object of class '<em>Method Type Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Type Categories</em>'.
   * @generated
   */
  MethodTypeCategories createMethodTypeCategories();

  /**
   * Returns a new object of class '<em>User Selection Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User Selection Categories</em>'.
   * @generated
   */
  UserSelectionCategories createUserSelectionCategories();

  /**
   * Returns a new object of class '<em>Quality Attribute Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quality Attribute Categories</em>'.
   * @generated
   */
  QualityAttributeCategories createQualityAttributeCategories();

  /**
   * Returns a new object of class '<em>Development Phase Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Development Phase Categories</em>'.
   * @generated
   */
  DevelopmentPhaseCategories createDevelopmentPhaseCategories();

  /**
   * Returns a new object of class '<em>Requirement Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement Type</em>'.
   * @generated
   */
  RequirementType createRequirementType();

  /**
   * Returns a new object of class '<em>Method Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Type</em>'.
   * @generated
   */
  MethodType createMethodType();

  /**
   * Returns a new object of class '<em>User Selection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User Selection</em>'.
   * @generated
   */
  UserSelection createUserSelection();

  /**
   * Returns a new object of class '<em>Quality Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quality Attribute</em>'.
   * @generated
   */
  QualityAttribute createQualityAttribute();

  /**
   * Returns a new object of class '<em>Development Phase</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Development Phase</em>'.
   * @generated
   */
  DevelopmentPhase createDevelopmentPhase();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CategoriesPackage getCategoriesPackage();

} //CategoriesFactory
