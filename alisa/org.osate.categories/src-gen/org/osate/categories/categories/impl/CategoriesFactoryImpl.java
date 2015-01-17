/**
 */
package org.osate.categories.categories.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.categories.categories.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CategoriesFactoryImpl extends EFactoryImpl implements CategoriesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CategoriesFactory init()
  {
    try
    {
      CategoriesFactory theCategoriesFactory = (CategoriesFactory)EPackage.Registry.INSTANCE.getEFactory(CategoriesPackage.eNS_URI);
      if (theCategoriesFactory != null)
      {
        return theCategoriesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CategoriesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CategoriesFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case CategoriesPackage.CATEGORIES: return createCategories();
      case CategoriesPackage.REQUIREMENT_CATEGORIES: return createRequirementCategories();
      case CategoriesPackage.HAZARD_CATEGORIES: return createHazardCategories();
      case CategoriesPackage.VERIFICATION_CATEGORIES: return createVerificationCategories();
      case CategoriesPackage.SELECTION_CATEGORIES: return createSelectionCategories();
      case CategoriesPackage.ASSERT_FAIL_CATEGORIES: return createAssertFailCategories();
      case CategoriesPackage.EXECUTION_FAIL_CATEGORIES: return createExecutionFailCategories();
      case CategoriesPackage.CATEGORY: return createCategory();
      case CategoriesPackage.REQUIREMENT_CATEGORY: return createRequirementCategory();
      case CategoriesPackage.HAZARD_CATEGORY: return createHazardCategory();
      case CategoriesPackage.VERIFICATION_CATEGORY: return createVerificationCategory();
      case CategoriesPackage.SELECTION_CATEGORY: return createSelectionCategory();
      case CategoriesPackage.ASSERT_FAIL_CATEGORY: return createAssertFailCategory();
      case CategoriesPackage.EXECUTION_FAIL_CATEGORY: return createExecutionFailCategory();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories createCategories()
  {
    CategoriesImpl categories = new CategoriesImpl();
    return categories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementCategories createRequirementCategories()
  {
    RequirementCategoriesImpl requirementCategories = new RequirementCategoriesImpl();
    return requirementCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HazardCategories createHazardCategories()
  {
    HazardCategoriesImpl hazardCategories = new HazardCategoriesImpl();
    return hazardCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategories createVerificationCategories()
  {
    VerificationCategoriesImpl verificationCategories = new VerificationCategoriesImpl();
    return verificationCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectionCategories createSelectionCategories()
  {
    SelectionCategoriesImpl selectionCategories = new SelectionCategoriesImpl();
    return selectionCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssertFailCategories createAssertFailCategories()
  {
    AssertFailCategoriesImpl assertFailCategories = new AssertFailCategoriesImpl();
    return assertFailCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutionFailCategories createExecutionFailCategories()
  {
    ExecutionFailCategoriesImpl executionFailCategories = new ExecutionFailCategoriesImpl();
    return executionFailCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Category createCategory()
  {
    CategoryImpl category = new CategoryImpl();
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementCategory createRequirementCategory()
  {
    RequirementCategoryImpl requirementCategory = new RequirementCategoryImpl();
    return requirementCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HazardCategory createHazardCategory()
  {
    HazardCategoryImpl hazardCategory = new HazardCategoryImpl();
    return hazardCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory createVerificationCategory()
  {
    VerificationCategoryImpl verificationCategory = new VerificationCategoryImpl();
    return verificationCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectionCategory createSelectionCategory()
  {
    SelectionCategoryImpl selectionCategory = new SelectionCategoryImpl();
    return selectionCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssertFailCategory createAssertFailCategory()
  {
    AssertFailCategoryImpl assertFailCategory = new AssertFailCategoryImpl();
    return assertFailCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutionFailCategory createExecutionFailCategory()
  {
    ExecutionFailCategoryImpl executionFailCategory = new ExecutionFailCategoryImpl();
    return executionFailCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CategoriesPackage getCategoriesPackage()
  {
    return (CategoriesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CategoriesPackage getPackage()
  {
    return CategoriesPackage.eINSTANCE;
  }

} //CategoriesFactoryImpl
