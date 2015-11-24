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
   * The feature id for the '<em><b>Requirement Type Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES = 0;

  /**
   * The feature id for the '<em><b>Method Type Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES = 1;

  /**
   * The feature id for the '<em><b>Selectioncategories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES = 2;

  /**
   * The feature id for the '<em><b>Development Phase Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES = 3;

  /**
   * The feature id for the '<em><b>Quality Attribute Categories</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES = 4;

  /**
   * The number of structural features of the '<em>Definitions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_DEFINITIONS_FEATURE_COUNT = 5;

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
   * The feature id for the '<em><b>Requirement Type</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__REQUIREMENT_TYPE = 1;

  /**
   * The feature id for the '<em><b>Any Requirement Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_REQUIREMENT_TYPE = 2;

  /**
   * The feature id for the '<em><b>Method Type</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__METHOD_TYPE = 3;

  /**
   * The feature id for the '<em><b>Any Method Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_METHOD_TYPE = 4;

  /**
   * The feature id for the '<em><b>User Selection</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__USER_SELECTION = 5;

  /**
   * The feature id for the '<em><b>Any User Selection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_USER_SELECTION = 6;

  /**
   * The feature id for the '<em><b>Quality Attribute</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__QUALITY_ATTRIBUTE = 7;

  /**
   * The feature id for the '<em><b>Any Quality Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE = 8;

  /**
   * The feature id for the '<em><b>Development Phase</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__DEVELOPMENT_PHASE = 9;

  /**
   * The feature id for the '<em><b>Any Development Phase</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE = 10;

  /**
   * The number of structural features of the '<em>Category Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER_FEATURE_COUNT = 11;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.RequirementTypeCategoriesImpl <em>Requirement Type Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.RequirementTypeCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementTypeCategories()
   * @generated
   */
  int REQUIREMENT_TYPE_CATEGORIES = 4;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_TYPE_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Requirement Type Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_TYPE_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.MethodTypeCategoriesImpl <em>Method Type Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.MethodTypeCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodTypeCategories()
   * @generated
   */
  int METHOD_TYPE_CATEGORIES = 5;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_TYPE_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Method Type Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_TYPE_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.UserSelectionCategoriesImpl <em>User Selection Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.UserSelectionCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserSelectionCategories()
   * @generated
   */
  int USER_SELECTION_CATEGORIES = 6;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_SELECTION_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>User Selection Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_SELECTION_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.QualityAttributeCategoriesImpl <em>Quality Attribute Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.QualityAttributeCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityAttributeCategories()
   * @generated
   */
  int QUALITY_ATTRIBUTE_CATEGORIES = 7;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_ATTRIBUTE_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Quality Attribute Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_ATTRIBUTE_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.DevelopmentPhaseCategoriesImpl <em>Development Phase Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.DevelopmentPhaseCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getDevelopmentPhaseCategories()
   * @generated
   */
  int DEVELOPMENT_PHASE_CATEGORIES = 8;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVELOPMENT_PHASE_CATEGORIES__CATEGORY = CATEGORIES__CATEGORY;

  /**
   * The number of structural features of the '<em>Development Phase Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVELOPMENT_PHASE_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.RequirementTypeImpl <em>Requirement Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.RequirementTypeImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementType()
   * @generated
   */
  int REQUIREMENT_TYPE = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_TYPE__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Requirement Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_TYPE_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.MethodTypeImpl <em>Method Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.MethodTypeImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodType()
   * @generated
   */
  int METHOD_TYPE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_TYPE__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Method Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_TYPE_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.UserSelectionImpl <em>User Selection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.UserSelectionImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserSelection()
   * @generated
   */
  int USER_SELECTION = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_SELECTION__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>User Selection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_SELECTION_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.QualityAttributeImpl <em>Quality Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.QualityAttributeImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityAttribute()
   * @generated
   */
  int QUALITY_ATTRIBUTE = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_ATTRIBUTE__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Quality Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALITY_ATTRIBUTE_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.DevelopmentPhaseImpl <em>Development Phase</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.DevelopmentPhaseImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getDevelopmentPhase()
   * @generated
   */
  int DEVELOPMENT_PHASE = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVELOPMENT_PHASE__NAME = CATEGORY__NAME;

  /**
   * The number of structural features of the '<em>Development Phase</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEVELOPMENT_PHASE_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;


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
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getRequirementTypeCategories <em>Requirement Type Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requirement Type Categories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getRequirementTypeCategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_RequirementTypeCategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getMethodTypeCategories <em>Method Type Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Method Type Categories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getMethodTypeCategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_MethodTypeCategories();

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
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getDevelopmentPhaseCategories <em>Development Phase Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Development Phase Categories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getDevelopmentPhaseCategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_DevelopmentPhaseCategories();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.categories.categories.CategoriesDefinitions#getQualityAttributeCategories <em>Quality Attribute Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Quality Attribute Categories</em>'.
   * @see org.osate.categories.categories.CategoriesDefinitions#getQualityAttributeCategories()
   * @see #getCategoriesDefinitions()
   * @generated
   */
  EReference getCategoriesDefinitions_QualityAttributeCategories();

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
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getRequirementType <em>Requirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Requirement Type</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getRequirementType()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_RequirementType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.CategoryFilter#isAnyRequirementType <em>Any Requirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Requirement Type</em>'.
   * @see org.osate.categories.categories.CategoryFilter#isAnyRequirementType()
   * @see #getCategoryFilter()
   * @generated
   */
  EAttribute getCategoryFilter_AnyRequirementType();

  /**
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getMethodType <em>Method Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Method Type</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getMethodType()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_MethodType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.CategoryFilter#isAnyMethodType <em>Any Method Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Method Type</em>'.
   * @see org.osate.categories.categories.CategoryFilter#isAnyMethodType()
   * @see #getCategoryFilter()
   * @generated
   */
  EAttribute getCategoryFilter_AnyMethodType();

  /**
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getUserSelection <em>User Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>User Selection</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getUserSelection()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_UserSelection();

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
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getQualityAttribute <em>Quality Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Quality Attribute</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getQualityAttribute()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_QualityAttribute();

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
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.CategoryFilter#getDevelopmentPhase <em>Development Phase</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Development Phase</em>'.
   * @see org.osate.categories.categories.CategoryFilter#getDevelopmentPhase()
   * @see #getCategoryFilter()
   * @generated
   */
  EReference getCategoryFilter_DevelopmentPhase();

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
   * Returns the meta object for class '{@link org.osate.categories.categories.RequirementTypeCategories <em>Requirement Type Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Type Categories</em>'.
   * @see org.osate.categories.categories.RequirementTypeCategories
   * @generated
   */
  EClass getRequirementTypeCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.MethodTypeCategories <em>Method Type Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Type Categories</em>'.
   * @see org.osate.categories.categories.MethodTypeCategories
   * @generated
   */
  EClass getMethodTypeCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.UserSelectionCategories <em>User Selection Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Selection Categories</em>'.
   * @see org.osate.categories.categories.UserSelectionCategories
   * @generated
   */
  EClass getUserSelectionCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.QualityAttributeCategories <em>Quality Attribute Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quality Attribute Categories</em>'.
   * @see org.osate.categories.categories.QualityAttributeCategories
   * @generated
   */
  EClass getQualityAttributeCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.DevelopmentPhaseCategories <em>Development Phase Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Development Phase Categories</em>'.
   * @see org.osate.categories.categories.DevelopmentPhaseCategories
   * @generated
   */
  EClass getDevelopmentPhaseCategories();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.RequirementType <em>Requirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Type</em>'.
   * @see org.osate.categories.categories.RequirementType
   * @generated
   */
  EClass getRequirementType();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.MethodType <em>Method Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Type</em>'.
   * @see org.osate.categories.categories.MethodType
   * @generated
   */
  EClass getMethodType();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.UserSelection <em>User Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Selection</em>'.
   * @see org.osate.categories.categories.UserSelection
   * @generated
   */
  EClass getUserSelection();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.QualityAttribute <em>Quality Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quality Attribute</em>'.
   * @see org.osate.categories.categories.QualityAttribute
   * @generated
   */
  EClass getQualityAttribute();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.DevelopmentPhase <em>Development Phase</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Development Phase</em>'.
   * @see org.osate.categories.categories.DevelopmentPhase
   * @generated
   */
  EClass getDevelopmentPhase();

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
     * The meta object literal for the '<em><b>Requirement Type Categories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES = eINSTANCE.getCategoriesDefinitions_RequirementTypeCategories();

    /**
     * The meta object literal for the '<em><b>Method Type Categories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES = eINSTANCE.getCategoriesDefinitions_MethodTypeCategories();

    /**
     * The meta object literal for the '<em><b>Selectioncategories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES = eINSTANCE.getCategoriesDefinitions_Selectioncategories();

    /**
     * The meta object literal for the '<em><b>Development Phase Categories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES = eINSTANCE.getCategoriesDefinitions_DevelopmentPhaseCategories();

    /**
     * The meta object literal for the '<em><b>Quality Attribute Categories</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES = eINSTANCE.getCategoriesDefinitions_QualityAttributeCategories();

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
     * The meta object literal for the '<em><b>Requirement Type</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__REQUIREMENT_TYPE = eINSTANCE.getCategoryFilter_RequirementType();

    /**
     * The meta object literal for the '<em><b>Any Requirement Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_REQUIREMENT_TYPE = eINSTANCE.getCategoryFilter_AnyRequirementType();

    /**
     * The meta object literal for the '<em><b>Method Type</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__METHOD_TYPE = eINSTANCE.getCategoryFilter_MethodType();

    /**
     * The meta object literal for the '<em><b>Any Method Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_METHOD_TYPE = eINSTANCE.getCategoryFilter_AnyMethodType();

    /**
     * The meta object literal for the '<em><b>User Selection</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__USER_SELECTION = eINSTANCE.getCategoryFilter_UserSelection();

    /**
     * The meta object literal for the '<em><b>Any User Selection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_USER_SELECTION = eINSTANCE.getCategoryFilter_AnyUserSelection();

    /**
     * The meta object literal for the '<em><b>Quality Attribute</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__QUALITY_ATTRIBUTE = eINSTANCE.getCategoryFilter_QualityAttribute();

    /**
     * The meta object literal for the '<em><b>Any Quality Attribute</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE = eINSTANCE.getCategoryFilter_AnyQualityAttribute();

    /**
     * The meta object literal for the '<em><b>Development Phase</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CATEGORY_FILTER__DEVELOPMENT_PHASE = eINSTANCE.getCategoryFilter_DevelopmentPhase();

    /**
     * The meta object literal for the '<em><b>Any Development Phase</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE = eINSTANCE.getCategoryFilter_AnyDevelopmentPhase();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.RequirementTypeCategoriesImpl <em>Requirement Type Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.RequirementTypeCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementTypeCategories()
     * @generated
     */
    EClass REQUIREMENT_TYPE_CATEGORIES = eINSTANCE.getRequirementTypeCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.MethodTypeCategoriesImpl <em>Method Type Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.MethodTypeCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodTypeCategories()
     * @generated
     */
    EClass METHOD_TYPE_CATEGORIES = eINSTANCE.getMethodTypeCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.UserSelectionCategoriesImpl <em>User Selection Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.UserSelectionCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserSelectionCategories()
     * @generated
     */
    EClass USER_SELECTION_CATEGORIES = eINSTANCE.getUserSelectionCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.QualityAttributeCategoriesImpl <em>Quality Attribute Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.QualityAttributeCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityAttributeCategories()
     * @generated
     */
    EClass QUALITY_ATTRIBUTE_CATEGORIES = eINSTANCE.getQualityAttributeCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.DevelopmentPhaseCategoriesImpl <em>Development Phase Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.DevelopmentPhaseCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getDevelopmentPhaseCategories()
     * @generated
     */
    EClass DEVELOPMENT_PHASE_CATEGORIES = eINSTANCE.getDevelopmentPhaseCategories();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.RequirementTypeImpl <em>Requirement Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.RequirementTypeImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementType()
     * @generated
     */
    EClass REQUIREMENT_TYPE = eINSTANCE.getRequirementType();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.MethodTypeImpl <em>Method Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.MethodTypeImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodType()
     * @generated
     */
    EClass METHOD_TYPE = eINSTANCE.getMethodType();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.UserSelectionImpl <em>User Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.UserSelectionImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getUserSelection()
     * @generated
     */
    EClass USER_SELECTION = eINSTANCE.getUserSelection();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.QualityAttributeImpl <em>Quality Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.QualityAttributeImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getQualityAttribute()
     * @generated
     */
    EClass QUALITY_ATTRIBUTE = eINSTANCE.getQualityAttribute();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.DevelopmentPhaseImpl <em>Development Phase</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.DevelopmentPhaseImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getDevelopmentPhase()
     * @generated
     */
    EClass DEVELOPMENT_PHASE = eINSTANCE.getDevelopmentPhase();

  }

} //CategoriesPackage
