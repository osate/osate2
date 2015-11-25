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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.categories.categories.CategoriesFactory
 * @model kind="package"
 * @generated
 */
public interface CategoriesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "categories";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/categories/Categories";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "categories";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CategoriesPackage eINSTANCE = org.osate.categories.categories.impl.CategoriesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl <em>Definitions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoriesDefinitionsImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategoriesDefinitions()
   * @generated
   */
  int CATEGORIES_DEFINITIONS = 0;

  /**
   * The feature id for the '<em><b>User Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__USER_CATEGORIES = 0;

  /**
   * The feature id for the '<em><b>Phase Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__PHASE_CATEGORIES = 1;

  /**
   * The feature id for the '<em><b>Quality Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES = 2;

  /**
   * The number of structural features of the '<em>Definitions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoriesImpl <em>Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategories()
   * @generated
   */
  int CATEGORIES = 1;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES__CATEGORY = 0;

  /**
   * The number of structural features of the '<em>Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoryImpl <em>Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategory()
   * @generated
   */
  int CATEGORY = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__NAME = 0;

  /**
   * The number of structural features of the '<em>Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoryFilterImpl <em>Category Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoryFilterImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategoryFilter()
   * @generated
   */
  int CATEGORY_FILTER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__NAME = 0;

  /**
   * The feature id for the '<em><b>User Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__USER_CATEGORY = 1;

  /**
   * The feature id for the '<em><b>Any User Selection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_USER_SELECTION = 2;

  /**
   * The feature id for the '<em><b>Quality Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__QUALITY_CATEGORY = 3;

  /**
   * The feature id for the '<em><b>Any Quality Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE = 4;

  /**
   * The feature id for the '<em><b>Phase Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__PHASE_CATEGORY = 5;

  /**
   * The feature id for the '<em><b>Any Development Phase</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE = 6;

  /**
   * The number of structural features of the '<em>Category Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.UserCategoriesImpl <em>User Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.UserCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserCategories()
   * @generated
   */
  int USER_CATEGORIES = 4;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>User Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.QualityCategoriesImpl <em>Quality Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.QualityCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityCategories()
   * @generated
   */
  int QUALITY_CATEGORIES = 5;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Quality Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.PhaseCategoriesImpl <em>Phase Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.PhaseCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getPhaseCategories()
   * @generated
   */
  int PHASE_CATEGORIES = 6;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHASE_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Phase Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHASE_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.UserCategoryImpl <em>User Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.UserCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserCategory()
   * @generated
   */
  int USER_CATEGORY = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>User Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.QualityCategoryImpl <em>Quality Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.QualityCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityCategory()
   * @generated
   */
  int QUALITY_CATEGORY = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Quality Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.PhaseCategoryImpl <em>Phase Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.PhaseCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getPhaseCategory()
   * @generated
   */
  int PHASE_CATEGORY = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHASE_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Phase Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHASE_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.CategoriesDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definitions</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions
   * @generated
   */
  EClass getCategoriesDefinitions();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getUserCategories <em>User Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>User Categories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getUserCategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_UserCategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getPhaseCategories <em>Phase Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Phase Categories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getPhaseCategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_PhaseCategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getQualityCategories <em>Quality Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Quality Categories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getQualityCategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_QualityCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.Categories <em>Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Categories</em>'.
   * @see org.osate.categories.categories.Categories
   * @generated
   */
  EClass getCategories();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.Categories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.Categories#getCategory()
   * @see #getCategories()
   * @generated
   */
  EReference getCategories_Category();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.Category <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Category</em>'.
   * @see org.osate.categories.categories.Category
   * @generated
   */
  EClass getCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.Category#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.categories.categories.Category#getName()
   * @see #getCategory()
   * @generated
   */
  EAttribute getCategory_Name();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.CategoryFilter <em>Category Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Category Filter</em>'.
   * @see org.osate.categories.categories.CategoryFilter
   * @generated
   */
  EClass getCategoryFilter();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.CategoryFilter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getName()
   * @see #getCategoryFilter()
   * @generated
   */
  EAttribute getCategoryFilter_Name();

  /**
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getUserCategory <em>User Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>User Category</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getUserCategory()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_UserCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.CategoryFilter#isAnyUserSelection <em>Any User Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any User Selection</em>'.
   * @see org.osate.categories.categories.CategoryFilter#isAnyUserSelection()
   * @see #getCategoryFilter()
   * @generated
   */
  EAttribute getCategoryFilter_AnyUserSelection();

  /**
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getQualityCategory <em>Quality Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Quality Category</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getQualityCategory()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_QualityCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.CategoryFilter#isAnyQualityAttribute <em>Any Quality Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Quality Attribute</em>'.
   * @see org.osate.categories.categories.CategoryFilter#isAnyQualityAttribute()
   * @see #getCategoryFilter()
   * @generated
   */
  EAttribute getCategoryFilter_AnyQualityAttribute();

  /**
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getPhaseCategory <em>Phase Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Phase Category</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getPhaseCategory()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_PhaseCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.CategoryFilter#isAnyDevelopmentPhase <em>Any Development Phase</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Development Phase</em>'.
   * @see org.osate.categories.categories.CategoryFilter#isAnyDevelopmentPhase()
   * @see #getCategoryFilter()
   * @generated
   */
  EAttribute getCategoryFilter_AnyDevelopmentPhase();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.UserCategories <em>User Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Categories</em>'.
   * @see org.osate.categories.categories.UserCategories
   * @generated
   */
  EClass getUserCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.QualityCategories <em>Quality Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quality Categories</em>'.
   * @see org.osate.categories.categories.QualityCategories
   * @generated
   */
  EClass getQualityCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.PhaseCategories <em>Phase Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Phase Categories</em>'.
   * @see org.osate.categories.categories.PhaseCategories
   * @generated
   */
  EClass getPhaseCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.UserCategory <em>User Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Category</em>'.
   * @see org.osate.categories.categories.UserCategory
   * @generated
   */
  EClass getUserCategory();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.QualityCategory <em>Quality Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quality Category</em>'.
   * @see org.osate.categories.categories.QualityCategory
   * @generated
   */
  EClass getQualityCategory();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.PhaseCategory <em>Phase Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Phase Category</em>'.
   * @see org.osate.categories.categories.PhaseCategory
   * @generated
   */
  EClass getPhaseCategory();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CategoriesFactory getCategoriesFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl <em>Definitions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.CategoriesDefinitionsImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategoriesDefinitions()
     * @generated
     */
    EClass CATEGORIES_DEFINITIONS = eINSTANCE.getCategoriesDefinitions();

    /**
     * The meta object literal for the '<em><b>User Categories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__USER_CATEGORIES = eINSTANCE.getCategoriesDefinitions_UserCategories();

    /**
     * The meta object literal for the '<em><b>Phase Categories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__PHASE_CATEGORIES = eINSTANCE.getCategoriesDefinitions_PhaseCategories();

    /**
     * The meta object literal for the '<em><b>Quality Categories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES = eINSTANCE.getCategoriesDefinitions_QualityCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.CategoriesImpl <em>Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.CategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategories()
     * @generated
     */
    EClass CATEGORIES = eINSTANCE.getCategories();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES__CATEGORY = eINSTANCE.getCategories_Category();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.CategoryImpl <em>Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.CategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategory()
     * @generated
     */
    EClass CATEGORY = eINSTANCE.getCategory();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.CategoryFilterImpl <em>Category Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.CategoryFilterImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategoryFilter()
     * @generated
     */
    EClass CATEGORY_FILTER = eINSTANCE.getCategoryFilter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__NAME = eINSTANCE.getCategoryFilter_Name();

    /**
     * The meta object literal for the '<em><b>User Category</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__USER_CATEGORY = eINSTANCE.getCategoryFilter_UserCategory();

    /**
     * The meta object literal for the '<em><b>Any User Selection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_USER_SELECTION = eINSTANCE.getCategoryFilter_AnyUserSelection();

    /**
     * The meta object literal for the '<em><b>Quality Category</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__QUALITY_CATEGORY = eINSTANCE.getCategoryFilter_QualityCategory();

    /**
     * The meta object literal for the '<em><b>Any Quality Attribute</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE = eINSTANCE.getCategoryFilter_AnyQualityAttribute();

    /**
     * The meta object literal for the '<em><b>Phase Category</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__PHASE_CATEGORY = eINSTANCE.getCategoryFilter_PhaseCategory();

    /**
     * The meta object literal for the '<em><b>Any Development Phase</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE = eINSTANCE.getCategoryFilter_AnyDevelopmentPhase();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.UserCategoriesImpl <em>User Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.UserCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserCategories()
     * @generated
     */
    EClass USER_CATEGORIES = eINSTANCE.getUserCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.QualityCategoriesImpl <em>Quality Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.QualityCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityCategories()
     * @generated
     */
    EClass QUALITY_CATEGORIES = eINSTANCE.getQualityCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.PhaseCategoriesImpl <em>Phase Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.PhaseCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getPhaseCategories()
     * @generated
     */
    EClass PHASE_CATEGORIES = eINSTANCE.getPhaseCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.UserCategoryImpl <em>User Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.UserCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserCategory()
     * @generated
     */
    EClass USER_CATEGORY = eINSTANCE.getUserCategory();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.QualityCategoryImpl <em>Quality Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.QualityCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityCategory()
     * @generated
     */
    EClass QUALITY_CATEGORY = eINSTANCE.getQualityCategory();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.PhaseCategoryImpl <em>Phase Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.PhaseCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getPhaseCategory()
     * @generated
     */
    EClass PHASE_CATEGORY = eINSTANCE.getPhaseCategory();

  }

} //CategoriesPackage
