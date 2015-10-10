/**
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
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoriesImpl <em>Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategories()
   * @generated
   */
  int CATEGORIES = 0;

  /**
   * The number of structural features of the '<em>Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORIES_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.RequirementCategoriesImpl <em>Requirement Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.RequirementCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementCategories()
   * @generated
   */
  int REQUIREMENT_CATEGORIES = 1;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORIES__CATEGORY = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Requirement Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.MethodCategoriesImpl <em>Method Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.MethodCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodCategories()
   * @generated
   */
  int METHOD_CATEGORIES = 2;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORIES__CATEGORY = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Method Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.SelectionCategoriesImpl <em>Selection Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.SelectionCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getSelectionCategories()
   * @generated
   */
  int SELECTION_CATEGORIES = 3;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORIES__CATEGORY = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Selection Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoryImpl <em>Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategory()
   * @generated
   */
  int CATEGORY = 4;

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
   * The meta object id for the '{@link org.osate.categories.categories.impl.RequirementCategoryImpl <em>Requirement Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.RequirementCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementCategory()
   * @generated
   */
  int REQUIREMENT_CATEGORY = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The feature id for the '<em><b>Sub Categories</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY__SUB_CATEGORIES = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Requirement Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.MethodCategoryImpl <em>Method Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.MethodCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getMethodCategory()
   * @generated
   */
  int METHOD_CATEGORY = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The feature id for the '<em><b>Sub Categories</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORY__SUB_CATEGORIES = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Method Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.SelectionCategoryImpl <em>Selection Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.SelectionCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getSelectionCategory()
   * @generated
   */
  int SELECTION_CATEGORY = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The feature id for the '<em><b>Sub Categories</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY__SUB_CATEGORIES = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Selection Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;


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
   * Returns the meta object for class '{@link org.osate.categories.categories.RequirementCategories <em>Requirement Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Categories</em>'.
   * @see org.osate.categories.categories.RequirementCategories
   * @generated
   */
  EClass getRequirementCategories();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.RequirementCategories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.RequirementCategories#getCategory()
   * @see #getRequirementCategories()
   * @generated
   */
  EReference getRequirementCategories_Category();

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
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.MethodCategories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.MethodCategories#getCategory()
   * @see #getMethodCategories()
   * @generated
   */
  EReference getMethodCategories_Category();

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
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.SelectionCategories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.SelectionCategories#getCategory()
   * @see #getSelectionCategories()
   * @generated
   */
  EReference getSelectionCategories_Category();

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
   * Returns the meta object for class '{@link org.osate.categories.categories.RequirementCategory <em>Requirement Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Category</em>'.
   * @see org.osate.categories.categories.RequirementCategory
   * @generated
   */
  EClass getRequirementCategory();

  /**
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.RequirementCategory#getSubCategories <em>Sub Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sub Categories</em>'.
   * @see org.osate.categories.categories.RequirementCategory#getSubCategories()
   * @see #getRequirementCategory()
   * @generated
   */
  EReference getRequirementCategory_SubCategories();

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
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.MethodCategory#getSubCategories <em>Sub Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sub Categories</em>'.
   * @see org.osate.categories.categories.MethodCategory#getSubCategories()
   * @see #getMethodCategory()
   * @generated
   */
  EReference getMethodCategory_SubCategories();

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
   * Returns the meta object for the reference list '{@link org.osate.categories.categories.SelectionCategory#getSubCategories <em>Sub Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Sub Categories</em>'.
   * @see org.osate.categories.categories.SelectionCategory#getSubCategories()
   * @see #getSelectionCategory()
   * @generated
   */
  EReference getSelectionCategory_SubCategories();

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
     * The meta object literal for the '{@link org.osate.categories.categories.impl.CategoriesImpl <em>Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.CategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategories()
     * @generated
     */
    EClass CATEGORIES = eINSTANCE.getCategories();

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
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_CATEGORIES__CATEGORY = eINSTANCE.getRequirementCategories_Category();

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
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_CATEGORIES__CATEGORY = eINSTANCE.getMethodCategories_Category();

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
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_CATEGORIES__CATEGORY = eINSTANCE.getSelectionCategories_Category();

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
     * The meta object literal for the '{@link org.osate.categories.categories.impl.RequirementCategoryImpl <em>Requirement Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.RequirementCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getRequirementCategory()
     * @generated
     */
    EClass REQUIREMENT_CATEGORY = eINSTANCE.getRequirementCategory();

    /**
     * The meta object literal for the '<em><b>Sub Categories</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_CATEGORY__SUB_CATEGORIES = eINSTANCE.getRequirementCategory_SubCategories();

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
     * The meta object literal for the '<em><b>Sub Categories</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_CATEGORY__SUB_CATEGORIES = eINSTANCE.getMethodCategory_SubCategories();

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
     * The meta object literal for the '<em><b>Sub Categories</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_CATEGORY__SUB_CATEGORIES = eINSTANCE.getSelectionCategory_SubCategories();

  }

} //CategoriesPackage
