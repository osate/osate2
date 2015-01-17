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
   * The meta object id for the '{@link org.osate.categories.categories.impl.HazardCategoriesImpl <em>Hazard Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.HazardCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getHazardCategories()
   * @generated
   */
  int HAZARD_CATEGORIES = 2;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_CATEGORIES__CATEGORY = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Hazard Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.VerificationCategoriesImpl <em>Verification Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.VerificationCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getVerificationCategories()
   * @generated
   */
  int VERIFICATION_CATEGORIES = 3;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CATEGORIES__CATEGORY = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Verification Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.SelectionCategoriesImpl <em>Selection Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.SelectionCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getSelectionCategories()
   * @generated
   */
  int SELECTION_CATEGORIES = 4;

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
   * The meta object id for the '{@link org.osate.categories.categories.impl.AssertFailCategoriesImpl <em>Assert Fail Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.AssertFailCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getAssertFailCategories()
   * @generated
   */
  int ASSERT_FAIL_CATEGORIES = 5;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERT_FAIL_CATEGORIES__CATEGORY = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Assert Fail Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERT_FAIL_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.ExecutionFailCategoriesImpl <em>Execution Fail Categories</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.ExecutionFailCategoriesImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getExecutionFailCategories()
   * @generated
   */
  int EXECUTION_FAIL_CATEGORIES = 6;

  /**
   * The feature id for the '<em><b>Category</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_FAIL_CATEGORIES__CATEGORY = CATEGORIES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Execution Fail Categories</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_FAIL_CATEGORIES_FEATURE_COUNT = CATEGORIES_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.CategoryImpl <em>Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.CategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getCategory()
   * @generated
   */
  int CATEGORY = 7;

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
  int REQUIREMENT_CATEGORY = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY__EXTENDS = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Requirement Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.HazardCategoryImpl <em>Hazard Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.HazardCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getHazardCategory()
   * @generated
   */
  int HAZARD_CATEGORY = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_CATEGORY__EXTENDS = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Hazard Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.VerificationCategoryImpl <em>Verification Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.VerificationCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getVerificationCategory()
   * @generated
   */
  int VERIFICATION_CATEGORY = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CATEGORY__NAME = CATEGORY__NAME;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CATEGORY__EXTENDS = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Verification Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;

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
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY__EXTENDS = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Selection Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.AssertFailCategoryImpl <em>Assert Fail Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.AssertFailCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getAssertFailCategory()
   * @generated
   */
  int ASSERT_FAIL_CATEGORY = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERT_FAIL_CATEGORY__NAME = 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERT_FAIL_CATEGORY__EXTENDS = 1;

  /**
   * The number of structural features of the '<em>Assert Fail Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERT_FAIL_CATEGORY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.categories.categories.impl.ExecutionFailCategoryImpl <em>Execution Fail Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.categories.categories.impl.ExecutionFailCategoryImpl
   * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getExecutionFailCategory()
   * @generated
   */
  int EXECUTION_FAIL_CATEGORY = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_FAIL_CATEGORY__NAME = 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_FAIL_CATEGORY__EXTENDS = 1;

  /**
   * The number of structural features of the '<em>Execution Fail Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_FAIL_CATEGORY_FEATURE_COUNT = 2;


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
   * Returns the meta object for class '{@link org.osate.categories.categories.HazardCategories <em>Hazard Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hazard Categories</em>'.
   * @see org.osate.categories.categories.HazardCategories
   * @generated
   */
  EClass getHazardCategories();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.HazardCategories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.HazardCategories#getCategory()
   * @see #getHazardCategories()
   * @generated
   */
  EReference getHazardCategories_Category();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.VerificationCategories <em>Verification Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Categories</em>'.
   * @see org.osate.categories.categories.VerificationCategories
   * @generated
   */
  EClass getVerificationCategories();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.VerificationCategories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.VerificationCategories#getCategory()
   * @see #getVerificationCategories()
   * @generated
   */
  EReference getVerificationCategories_Category();

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
   * Returns the meta object for class '{@link org.osate.categories.categories.AssertFailCategories <em>Assert Fail Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assert Fail Categories</em>'.
   * @see org.osate.categories.categories.AssertFailCategories
   * @generated
   */
  EClass getAssertFailCategories();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.AssertFailCategories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.AssertFailCategories#getCategory()
   * @see #getAssertFailCategories()
   * @generated
   */
  EReference getAssertFailCategories_Category();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.ExecutionFailCategories <em>Execution Fail Categories</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execution Fail Categories</em>'.
   * @see org.osate.categories.categories.ExecutionFailCategories
   * @generated
   */
  EClass getExecutionFailCategories();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.categories.categories.ExecutionFailCategories#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Category</em>'.
   * @see org.osate.categories.categories.ExecutionFailCategories#getCategory()
   * @see #getExecutionFailCategories()
   * @generated
   */
  EReference getExecutionFailCategories_Category();

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
   * Returns the meta object for the reference '{@link org.osate.categories.categories.RequirementCategory#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.categories.categories.RequirementCategory#getExtends()
   * @see #getRequirementCategory()
   * @generated
   */
  EReference getRequirementCategory_Extends();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.HazardCategory <em>Hazard Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hazard Category</em>'.
   * @see org.osate.categories.categories.HazardCategory
   * @generated
   */
  EClass getHazardCategory();

  /**
   * Returns the meta object for the reference '{@link org.osate.categories.categories.HazardCategory#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.categories.categories.HazardCategory#getExtends()
   * @see #getHazardCategory()
   * @generated
   */
  EReference getHazardCategory_Extends();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.VerificationCategory <em>Verification Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Category</em>'.
   * @see org.osate.categories.categories.VerificationCategory
   * @generated
   */
  EClass getVerificationCategory();

  /**
   * Returns the meta object for the reference '{@link org.osate.categories.categories.VerificationCategory#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.categories.categories.VerificationCategory#getExtends()
   * @see #getVerificationCategory()
   * @generated
   */
  EReference getVerificationCategory_Extends();

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
   * Returns the meta object for the reference '{@link org.osate.categories.categories.SelectionCategory#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.categories.categories.SelectionCategory#getExtends()
   * @see #getSelectionCategory()
   * @generated
   */
  EReference getSelectionCategory_Extends();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.AssertFailCategory <em>Assert Fail Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assert Fail Category</em>'.
   * @see org.osate.categories.categories.AssertFailCategory
   * @generated
   */
  EClass getAssertFailCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.AssertFailCategory#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.categories.categories.AssertFailCategory#getName()
   * @see #getAssertFailCategory()
   * @generated
   */
  EAttribute getAssertFailCategory_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.categories.categories.AssertFailCategory#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.categories.categories.AssertFailCategory#getExtends()
   * @see #getAssertFailCategory()
   * @generated
   */
  EReference getAssertFailCategory_Extends();

  /**
   * Returns the meta object for class '{@link org.osate.categories.categories.ExecutionFailCategory <em>Execution Fail Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execution Fail Category</em>'.
   * @see org.osate.categories.categories.ExecutionFailCategory
   * @generated
   */
  EClass getExecutionFailCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.categories.categories.ExecutionFailCategory#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.categories.categories.ExecutionFailCategory#getName()
   * @see #getExecutionFailCategory()
   * @generated
   */
  EAttribute getExecutionFailCategory_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.categories.categories.ExecutionFailCategory#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.categories.categories.ExecutionFailCategory#getExtends()
   * @see #getExecutionFailCategory()
   * @generated
   */
  EReference getExecutionFailCategory_Extends();

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
     * The meta object literal for the '{@link org.osate.categories.categories.impl.HazardCategoriesImpl <em>Hazard Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.HazardCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getHazardCategories()
     * @generated
     */
    EClass HAZARD_CATEGORIES = eINSTANCE.getHazardCategories();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARD_CATEGORIES__CATEGORY = eINSTANCE.getHazardCategories_Category();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.VerificationCategoriesImpl <em>Verification Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.VerificationCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getVerificationCategories()
     * @generated
     */
    EClass VERIFICATION_CATEGORIES = eINSTANCE.getVerificationCategories();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_CATEGORIES__CATEGORY = eINSTANCE.getVerificationCategories_Category();

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
     * The meta object literal for the '{@link org.osate.categories.categories.impl.AssertFailCategoriesImpl <em>Assert Fail Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.AssertFailCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getAssertFailCategories()
     * @generated
     */
    EClass ASSERT_FAIL_CATEGORIES = eINSTANCE.getAssertFailCategories();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSERT_FAIL_CATEGORIES__CATEGORY = eINSTANCE.getAssertFailCategories_Category();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.ExecutionFailCategoriesImpl <em>Execution Fail Categories</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.ExecutionFailCategoriesImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getExecutionFailCategories()
     * @generated
     */
    EClass EXECUTION_FAIL_CATEGORIES = eINSTANCE.getExecutionFailCategories();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTION_FAIL_CATEGORIES__CATEGORY = eINSTANCE.getExecutionFailCategories_Category();

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
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_CATEGORY__EXTENDS = eINSTANCE.getRequirementCategory_Extends();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.HazardCategoryImpl <em>Hazard Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.HazardCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getHazardCategory()
     * @generated
     */
    EClass HAZARD_CATEGORY = eINSTANCE.getHazardCategory();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARD_CATEGORY__EXTENDS = eINSTANCE.getHazardCategory_Extends();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.VerificationCategoryImpl <em>Verification Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.VerificationCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getVerificationCategory()
     * @generated
     */
    EClass VERIFICATION_CATEGORY = eINSTANCE.getVerificationCategory();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_CATEGORY__EXTENDS = eINSTANCE.getVerificationCategory_Extends();

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
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_CATEGORY__EXTENDS = eINSTANCE.getSelectionCategory_Extends();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.AssertFailCategoryImpl <em>Assert Fail Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.AssertFailCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getAssertFailCategory()
     * @generated
     */
    EClass ASSERT_FAIL_CATEGORY = eINSTANCE.getAssertFailCategory();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSERT_FAIL_CATEGORY__NAME = eINSTANCE.getAssertFailCategory_Name();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSERT_FAIL_CATEGORY__EXTENDS = eINSTANCE.getAssertFailCategory_Extends();

    /**
     * The meta object literal for the '{@link org.osate.categories.categories.impl.ExecutionFailCategoryImpl <em>Execution Fail Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.categories.categories.impl.ExecutionFailCategoryImpl
     * @see org.osate.categories.categories.impl.CategoriesPackageImpl#getExecutionFailCategory()
     * @generated
     */
    EClass EXECUTION_FAIL_CATEGORY = eINSTANCE.getExecutionFailCategory();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXECUTION_FAIL_CATEGORY__NAME = eINSTANCE.getExecutionFailCategory_Name();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTION_FAIL_CATEGORY__EXTENDS = eINSTANCE.getExecutionFailCategory_Extends();

  }

} //CategoriesPackage
