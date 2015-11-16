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
   * The feature id for the '<em><b>Requirementcategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES = 0;

  /**
   * The feature id for the '<em><b>Componentcategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES = 1;

  /**
   * The feature id for the '<em><b>Methodcategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__METHODCATEGORIES = 2;

  /**
   * The feature id for the '<em><b>Selectioncategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES = 3;

  /**
   * The feature id for the '<em><b>Phasecategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__PHASECATEGORIES = 4;

  /**
   * The feature id for the '<em><b>Qualitycategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__QUALITYCATEGORIES = 5;

  /**
   * The feature id for the '<em><b>Categoryfilter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__CATEGORYFILTER = 6;

  /**
   * The number of structural features of the '<em>Definitions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS_FEATURE_COUNT = 7;

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
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoryFiltersImpl <em>Category Filters</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoryFiltersImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategoryFilters()
   * @generated
   */
  int CATEGORY_FILTERS = 3;

  /**
   * The feature id for the '<em><b>Filters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTERS__FILTERS = 0;

  /**
   * The number of structural features of the '<em>Category Filters</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.RequirementCategoriesImpl <em>Requirement Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.RequirementCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementCategories()
   * @generated
   */
  int REQUIREMENT_CATEGORIES = 4;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Requirement Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.MethodCategoriesImpl <em>Method Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.MethodCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodCategories()
   * @generated
   */
  int METHOD_CATEGORIES = 5;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Method Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.SelectionCategoriesImpl <em>Selection Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.SelectionCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getSelectionCategories()
   * @generated
   */
  int SELECTION_CATEGORIES = 6;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Selection Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.QualityCategoriesImpl <em>Quality Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.QualityCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityCategories()
   * @generated
   */
  int QUALITY_CATEGORIES = 7;

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
   * The meta object id for the '{@link org.osate.categories.categories.impl.ComponentCategoriesImpl <em>Component Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.ComponentCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getComponentCategories()
   * @generated
   */
  int COMPONENT_CATEGORIES = 8;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Component Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.RequirementCategoryImpl <em>Requirement Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.RequirementCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementCategory()
   * @generated
   */
  int REQUIREMENT_CATEGORY = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Requirement Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.MethodCategoryImpl <em>Method Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.MethodCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodCategory()
   * @generated
   */
  int METHOD_CATEGORY = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Method Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.SelectionCategoryImpl <em>Selection Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.SelectionCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getSelectionCategory()
   * @generated
   */
  int SELECTION_CATEGORY = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Selection Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.QualityCategoryImpl <em>Quality Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.QualityCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityCategory()
   * @generated
   */
  int QUALITY_CATEGORY = 12;

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
  int PHASE_CATEGORY = 13;

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
   * The meta object id for the '{@link org.osate.categories.categories.impl.ComponentCategoryImpl <em>Component Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.ComponentCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getComponentCategory()
   * @generated
   */
  int COMPONENT_CATEGORY = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Component Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategorySetImpl <em>Category Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategorySetImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategorySet()
   * @generated
   */
  int CATEGORY_SET = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_SET__NAME = CATEGORY__NAME;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_SET__ELEMENTS = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Category Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_SET_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;


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
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getRequirementcategories <em>Requirementcategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requirementcategories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getRequirementcategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_Requirementcategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getComponentcategories <em>Componentcategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Componentcategories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getComponentcategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_Componentcategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getMethodcategories <em>Methodcategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Methodcategories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getMethodcategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_Methodcategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getSelectioncategories <em>Selectioncategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Selectioncategories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getSelectioncategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_Selectioncategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getPhasecategories <em>Phasecategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Phasecategories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getPhasecategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_Phasecategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getQualitycategories <em>Qualitycategories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Qualitycategories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getQualitycategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_Qualitycategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getCategoryfilter <em>Categoryfilter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Categoryfilter</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getCategoryfilter()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_Categoryfilter();

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
   * Returns the meta object for class '{@link org.osate.categories.categories.CategoryFilters <em>Category Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Category Filters</em>'.
   * @see org.osate.categories.categories.CategoryFilters
   * @generated
   */
  EClass getCategoryFilters();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.CategoryFilters#getFilters <em>Filters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Filters</em>'.
   * @see org.osate.categories.categories.CategoryFilters#getFilters()
   * @see #getCategoryFilters()
   * @generated
   */
  EReference getCategoryFilters_Filters();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.RequirementCategories <em>Requirement Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Categories</em>'.
   * @see org.osate.categories.categories.RequirementCategories
   * @generated
   */
  EClass getRequirementCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.MethodCategories <em>Method Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Categories</em>'.
   * @see org.osate.categories.categories.MethodCategories
   * @generated
   */
  EClass getMethodCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.SelectionCategories <em>Selection Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection Categories</em>'.
   * @see org.osate.categories.categories.SelectionCategories
   * @generated
   */
  EClass getSelectionCategories();

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
   * Returns the meta object for class '{@link org.osate.categories.categories.ComponentCategories <em>Component Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Categories</em>'.
   * @see org.osate.categories.categories.ComponentCategories
   * @generated
   */
  EClass getComponentCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.RequirementCategory <em>Requirement Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Category</em>'.
   * @see org.osate.categories.categories.RequirementCategory
   * @generated
   */
  EClass getRequirementCategory();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.MethodCategory <em>Method Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Category</em>'.
   * @see org.osate.categories.categories.MethodCategory
   * @generated
   */
  EClass getMethodCategory();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.SelectionCategory <em>Selection Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection Category</em>'.
   * @see org.osate.categories.categories.SelectionCategory
   * @generated
   */
  EClass getSelectionCategory();

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
   * Returns the meta object for class '{@link org.osate.categories.categories.ComponentCategory <em>Component Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Category</em>'.
   * @see org.osate.categories.categories.ComponentCategory
   * @generated
   */
  EClass getComponentCategory();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.CategorySet <em>Category Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Category Set</em>'.
   * @see org.osate.categories.categories.CategorySet
   * @generated
   */
  EClass getCategorySet();

  /**
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategorySet#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Elements</em>'.
   * @see org.osate.categories.categories.CategorySet#getElements()
   * @see #getCategorySet()
   * @generated
   */
  EReference getCategorySet_Elements();

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
     * The meta object literal for the '<em><b>Requirementcategories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES = eINSTANCE.getCategoriesDefinitions_Requirementcategories();

    /**
     * The meta object literal for the '<em><b>Componentcategories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES = eINSTANCE.getCategoriesDefinitions_Componentcategories();

    /**
     * The meta object literal for the '<em><b>Methodcategories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__METHODCATEGORIES = eINSTANCE.getCategoriesDefinitions_Methodcategories();

    /**
     * The meta object literal for the '<em><b>Selectioncategories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES = eINSTANCE.getCategoriesDefinitions_Selectioncategories();

    /**
     * The meta object literal for the '<em><b>Phasecategories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__PHASECATEGORIES = eINSTANCE.getCategoriesDefinitions_Phasecategories();

    /**
     * The meta object literal for the '<em><b>Qualitycategories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__QUALITYCATEGORIES = eINSTANCE.getCategoriesDefinitions_Qualitycategories();

    /**
     * The meta object literal for the '<em><b>Categoryfilter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__CATEGORYFILTER = eINSTANCE.getCategoriesDefinitions_Categoryfilter();

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
     * The meta object literal for the '{@link org.osate.categories.categories.impl.CategoryFiltersImpl <em>Category Filters</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.CategoryFiltersImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategoryFilters()
     * @generated
     */
    EClass CATEGORY_FILTERS = eINSTANCE.getCategoryFilters();

    /**
     * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTERS__FILTERS = eINSTANCE.getCategoryFilters_Filters();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.RequirementCategoriesImpl <em>Requirement Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.RequirementCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementCategories()
     * @generated
     */
    EClass REQUIREMENT_CATEGORIES = eINSTANCE.getRequirementCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.MethodCategoriesImpl <em>Method Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.MethodCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodCategories()
     * @generated
     */
    EClass METHOD_CATEGORIES = eINSTANCE.getMethodCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.SelectionCategoriesImpl <em>Selection Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.SelectionCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getSelectionCategories()
     * @generated
     */
    EClass SELECTION_CATEGORIES = eINSTANCE.getSelectionCategories();

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
     * The meta object literal for the '{@link org.osate.categories.categories.impl.ComponentCategoriesImpl <em>Component Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.ComponentCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getComponentCategories()
     * @generated
     */
    EClass COMPONENT_CATEGORIES = eINSTANCE.getComponentCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.RequirementCategoryImpl <em>Requirement Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.RequirementCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementCategory()
     * @generated
     */
    EClass REQUIREMENT_CATEGORY = eINSTANCE.getRequirementCategory();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.MethodCategoryImpl <em>Method Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.MethodCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodCategory()
     * @generated
     */
    EClass METHOD_CATEGORY = eINSTANCE.getMethodCategory();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.SelectionCategoryImpl <em>Selection Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.SelectionCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getSelectionCategory()
     * @generated
     */
    EClass SELECTION_CATEGORY = eINSTANCE.getSelectionCategory();

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

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.ComponentCategoryImpl <em>Component Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.ComponentCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getComponentCategory()
     * @generated
     */
    EClass COMPONENT_CATEGORY = eINSTANCE.getComponentCategory();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.CategorySetImpl <em>Category Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.CategorySetImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategorySet()
     * @generated
     */
    EClass CATEGORY_SET = eINSTANCE.getCategorySet();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_SET__ELEMENTS = eINSTANCE.getCategorySet_Elements();

  }

} //CategoriesPackage
