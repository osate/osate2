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
      case CategoriesPackage.METHOD_CATEGORIES: return createMethodCategories();
      case CategoriesPackage.SELECTION_CATEGORIES: return createSelectionCategories();
      case CategoriesPackage.CATEGORY: return createCategory();
      case CategoriesPackage.REQUIREMENT_CATEGORY: return createRequirementCategory();
      case CategoriesPackage.METHOD_CATEGORY: return createMethodCategory();
      case CategoriesPackage.SELECTION_CATEGORY: return createSelectionCategory();
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
  public MethodCategories createMethodCategories()
  {
    MethodCategoriesImpl methodCategories = new MethodCategoriesImpl();
    return methodCategories;
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
  public MethodCategory createMethodCategory()
  {
    MethodCategoryImpl methodCategory = new MethodCategoryImpl();
    return methodCategory;
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
