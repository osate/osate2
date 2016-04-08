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

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getCategoryFilters <em>Category Filters</em>}</li>
 * </ul>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions()
 * @model
 * @generated
 */
public interface CategoriesDefinitions extends EObject
{
  /**
   * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.categories.categories.Categories}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Categories</em>' containment reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_Categories()
   * @model containment="true"
   * @generated
   */
  EList<Categories> getCategories();

  /**
   * Returns the value of the '<em><b>Category Filters</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.categories.categories.CategoryFilter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category Filters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category Filters</em>' containment reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_CategoryFilters()
   * @model containment="true"
   * @generated
   */
  EList<CategoryFilter> getCategoryFilters();

} // CategoriesDefinitions
