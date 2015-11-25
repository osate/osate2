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
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getUserCategories <em>User Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getPhaseCategories <em>Phase Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoriesDefinitions#getQualityCategories <em>Quality Categories</em>}</li>
 * </ul>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions()
 * @model
 * @generated
 */
public interface CategoriesDefinitions extends EObject
{
  /**
   * Returns the value of the '<em><b>User Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Categories</em>' containment reference.
   * @see #setUserCategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_UserCategories()
   * @model containment="true"
   * @generated
   */
  Categories getUserCategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getUserCategories <em>User Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User Categories</em>' containment reference.
   * @see #getUserCategories()
   * @generated
   */
  void setUserCategories(Categories value);

  /**
   * Returns the value of the '<em><b>Phase Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Phase Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Phase Categories</em>' containment reference.
   * @see #setPhaseCategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_PhaseCategories()
   * @model containment="true"
   * @generated
   */
  Categories getPhaseCategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getPhaseCategories <em>Phase Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Phase Categories</em>' containment reference.
   * @see #getPhaseCategories()
   * @generated
   */
  void setPhaseCategories(Categories value);

  /**
   * Returns the value of the '<em><b>Quality Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quality Categories</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quality Categories</em>' containment reference.
   * @see #setQualityCategories(Categories)
   * @see org.osate.categories.categories.CategoriesPackage#getCategoriesDefinitions_QualityCategories()
   * @model containment="true"
   * @generated
   */
  Categories getQualityCategories();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoriesDefinitions#getQualityCategories <em>Quality Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quality Categories</em>' containment reference.
   * @see #getQualityCategories()
   * @generated
   */
  void setQualityCategories(Categories value);

} // CategoriesDefinitions
