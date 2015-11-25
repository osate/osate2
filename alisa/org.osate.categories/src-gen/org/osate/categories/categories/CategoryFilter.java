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
 * A representation of the model object '<em><b>Category Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.CategoryFilter#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoryFilter#getUserCategory <em>User Category</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoryFilter#isAnyUserSelection <em>Any User Selection</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoryFilter#getQualityCategory <em>Quality Category</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoryFilter#isAnyQualityAttribute <em>Any Quality Attribute</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoryFilter#getPhaseCategory <em>Phase Category</em>}</li>
 *   <li>{@link org.osate.categories.categories.CategoryFilter#isAnyDevelopmentPhase <em>Any Development Phase</em>}</li>
 * </ul>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter()
 * @model
 * @generated
 */
public interface CategoryFilter extends EObject
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
   * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoryFilter#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>User Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.UserCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User Category</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User Category</em>' reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter_UserCategory()
   * @model
   * @generated
   */
  EList<UserCategory> getUserCategory();

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
   * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter_AnyUserSelection()
   * @model
   * @generated
   */
  boolean isAnyUserSelection();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoryFilter#isAnyUserSelection <em>Any User Selection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any User Selection</em>' attribute.
   * @see #isAnyUserSelection()
   * @generated
   */
  void setAnyUserSelection(boolean value);

  /**
   * Returns the value of the '<em><b>Quality Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.QualityCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quality Category</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quality Category</em>' reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter_QualityCategory()
   * @model
   * @generated
   */
  EList<QualityCategory> getQualityCategory();

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
   * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter_AnyQualityAttribute()
   * @model
   * @generated
   */
  boolean isAnyQualityAttribute();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoryFilter#isAnyQualityAttribute <em>Any Quality Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any Quality Attribute</em>' attribute.
   * @see #isAnyQualityAttribute()
   * @generated
   */
  void setAnyQualityAttribute(boolean value);

  /**
   * Returns the value of the '<em><b>Phase Category</b></em>' reference list.
   * The list contents are of type {@link org.osate.categories.categories.PhaseCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Phase Category</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Phase Category</em>' reference list.
   * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter_PhaseCategory()
   * @model
   * @generated
   */
  EList<PhaseCategory> getPhaseCategory();

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
   * @see org.osate.categories.categories.CategoriesPackage#getCategoryFilter_AnyDevelopmentPhase()
   * @model
   * @generated
   */
  boolean isAnyDevelopmentPhase();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.CategoryFilter#isAnyDevelopmentPhase <em>Any Development Phase</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Any Development Phase</em>' attribute.
   * @see #isAnyDevelopmentPhase()
   * @generated
   */
  void setAnyDevelopmentPhase(boolean value);

} // CategoryFilter
