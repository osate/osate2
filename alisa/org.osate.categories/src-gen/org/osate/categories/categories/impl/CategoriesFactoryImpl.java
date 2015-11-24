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
      case CategoriesPackage.CATEGORY_FILTER: return createCategoryFilter();
      case CategoriesPackage.REQUIREMENT_TYPE_CATEGORIES: return createRequirementTypeCategories();
      case CategoriesPackage.METHOD_TYPE_CATEGORIES: return createMethodTypeCategories();
      case CategoriesPackage.USER_SELECTION_CATEGORIES: return createUserSelectionCategories();
      case CategoriesPackage.QUALITY_ATTRIBUTE_CATEGORIES: return createQualityAttributeCategories();
      case CategoriesPackage.DEVELOPMENT_PHASE_CATEGORIES: return createDevelopmentPhaseCategories();
      case CategoriesPackage.REQUIREMENT_TYPE: return createRequirementType();
      case CategoriesPackage.METHOD_TYPE: return createMethodType();
      case CategoriesPackage.USER_SELECTION: return createUserSelection();
      case CategoriesPackage.QUALITY_ATTRIBUTE: return createQualityAttribute();
      case CategoriesPackage.DEVELOPMENT_PHASE: return createDevelopmentPhase();
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
  public CategoryFilter createCategoryFilter()
  {
    CategoryFilterImpl categoryFilter = new CategoryFilterImpl();
    return categoryFilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementTypeCategories createRequirementTypeCategories()
  {
    RequirementTypeCategoriesImpl requirementTypeCategories = new RequirementTypeCategoriesImpl();
    return requirementTypeCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodTypeCategories createMethodTypeCategories()
  {
    MethodTypeCategoriesImpl methodTypeCategories = new MethodTypeCategoriesImpl();
    return methodTypeCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserSelectionCategories createUserSelectionCategories()
  {
    UserSelectionCategoriesImpl userSelectionCategories = new UserSelectionCategoriesImpl();
    return userSelectionCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualityAttributeCategories createQualityAttributeCategories()
  {
    QualityAttributeCategoriesImpl qualityAttributeCategories = new QualityAttributeCategoriesImpl();
    return qualityAttributeCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DevelopmentPhaseCategories createDevelopmentPhaseCategories()
  {
    DevelopmentPhaseCategoriesImpl developmentPhaseCategories = new DevelopmentPhaseCategoriesImpl();
    return developmentPhaseCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequirementType createRequirementType()
  {
    RequirementTypeImpl requirementType = new RequirementTypeImpl();
    return requirementType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodType createMethodType()
  {
    MethodTypeImpl methodType = new MethodTypeImpl();
    return methodType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserSelection createUserSelection()
  {
    UserSelectionImpl userSelection = new UserSelectionImpl();
    return userSelection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualityAttribute createQualityAttribute()
  {
    QualityAttributeImpl qualityAttribute = new QualityAttributeImpl();
    return qualityAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DevelopmentPhase createDevelopmentPhase()
  {
    DevelopmentPhaseImpl developmentPhase = new DevelopmentPhaseImpl();
    return developmentPhase;
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
