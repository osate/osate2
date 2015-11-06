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
      case CategoriesPackage.CATEGORIES_DEFINITIONS: return createCategoriesDefinitions();
      case CategoriesPackage.CATEGORIES: return createCategories();
      case CategoriesPackage.CATEGORY: return createCategory();
      case CategoriesPackage.CATEGORY_FILTERS: return createCategoryFilters();
      case CategoriesPackage.REQUIREMENT_CATEGORIES: return createRequirementCategories();
      case CategoriesPackage.METHOD_CATEGORIES: return createMethodCategories();
      case CategoriesPackage.SELECTION_CATEGORIES: return createSelectionCategories();
      case CategoriesPackage.QUALITY_CATEGORIES: return createQualityCategories();
      case CategoriesPackage.COMPONENT_CATEGORIES: return createComponentCategories();
      case CategoriesPackage.REQUIREMENT_CATEGORY: return createRequirementCategory();
      case CategoriesPackage.METHOD_CATEGORY: return createMethodCategory();
      case CategoriesPackage.SELECTION_CATEGORY: return createSelectionCategory();
      case CategoriesPackage.QUALITY_CATEGORY: return createQualityCategory();
      case CategoriesPackage.COMPONENT_CATEGORY: return createComponentCategory();
      case CategoriesPackage.CATEGORY_SET: return createCategorySet();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CategoriesDefinitions createCategoriesDefinitions()
  {
    CategoriesDefinitionsImpl categoriesDefinitions = new CategoriesDefinitionsImpl();
    return categoriesDefinitions;
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
  public CategoryFilters createCategoryFilters()
  {
    CategoryFiltersImpl categoryFilters = new CategoryFiltersImpl();
    return categoryFilters;
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
  public QualityCategories createQualityCategories()
  {
    QualityCategoriesImpl qualityCategories = new QualityCategoriesImpl();
    return qualityCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentCategories createComponentCategories()
  {
    ComponentCategoriesImpl componentCategories = new ComponentCategoriesImpl();
    return componentCategories;
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
  public QualityCategory createQualityCategory()
  {
    QualityCategoryImpl qualityCategory = new QualityCategoryImpl();
    return qualityCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentCategory createComponentCategory()
  {
    ComponentCategoryImpl componentCategory = new ComponentCategoryImpl();
    return componentCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CategorySet createCategorySet()
  {
    CategorySetImpl categorySet = new CategorySetImpl();
    return categorySet;
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
