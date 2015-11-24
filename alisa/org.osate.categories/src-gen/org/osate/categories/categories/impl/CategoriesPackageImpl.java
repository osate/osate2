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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.categories.categories.Categories;
import org.osate.categories.categories.CategoriesDefinitions;
import org.osate.categories.categories.CategoriesFactory;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.Category;
import org.osate.categories.categories.CategoryFilter;
import org.osate.categories.categories.DevelopmentPhase;
import org.osate.categories.categories.DevelopmentPhaseCategories;
import org.osate.categories.categories.MethodType;
import org.osate.categories.categories.MethodTypeCategories;
import org.osate.categories.categories.QualityAttribute;
import org.osate.categories.categories.QualityAttributeCategories;
import org.osate.categories.categories.RequirementType;
import org.osate.categories.categories.RequirementTypeCategories;
import org.osate.categories.categories.UserSelection;
import org.osate.categories.categories.UserSelectionCategories;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CategoriesPackageImpl extends EPackageImpl implements CategoriesPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass categoriesDefinitionsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass categoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass categoryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass categoryFilterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementTypeCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodTypeCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass userSelectionCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualityAttributeCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass developmentPhaseCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass userSelectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualityAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass developmentPhaseEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.osate.categories.categories.CategoriesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CategoriesPackageImpl()
  {
    super(eNS_URI, CategoriesFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link CategoriesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CategoriesPackage init()
  {
    if (isInited) return (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);

    // Obtain or create and register package
    CategoriesPackageImpl theCategoriesPackage = (CategoriesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CategoriesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CategoriesPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theCategoriesPackage.createPackageContents();

    // Initialize created meta-data
    theCategoriesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCategoriesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CategoriesPackage.eNS_URI, theCategoriesPackage);
    return theCategoriesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCategoriesDefinitions()
  {
    return categoriesDefinitionsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoriesDefinitions_RequirementTypeCategories()
  {
    return (EReference)categoriesDefinitionsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoriesDefinitions_MethodTypeCategories()
  {
    return (EReference)categoriesDefinitionsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoriesDefinitions_Selectioncategories()
  {
    return (EReference)categoriesDefinitionsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoriesDefinitions_DevelopmentPhaseCategories()
  {
    return (EReference)categoriesDefinitionsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoriesDefinitions_QualityAttributeCategories()
  {
    return (EReference)categoriesDefinitionsEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCategories()
  {
    return categoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategories_Category()
  {
    return (EReference)categoriesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCategory()
  {
    return categoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategory_Name()
  {
    return (EAttribute)categoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCategoryFilter()
  {
    return categoryFilterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategoryFilter_Name()
  {
    return (EAttribute)categoryFilterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoryFilter_RequirementType()
  {
    return (EReference)categoryFilterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategoryFilter_AnyRequirementType()
  {
    return (EAttribute)categoryFilterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoryFilter_MethodType()
  {
    return (EReference)categoryFilterEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategoryFilter_AnyMethodType()
  {
    return (EAttribute)categoryFilterEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoryFilter_UserSelection()
  {
    return (EReference)categoryFilterEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategoryFilter_AnyUserSelection()
  {
    return (EAttribute)categoryFilterEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoryFilter_QualityAttribute()
  {
    return (EReference)categoryFilterEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategoryFilter_AnyQualityAttribute()
  {
    return (EAttribute)categoryFilterEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCategoryFilter_DevelopmentPhase()
  {
    return (EReference)categoryFilterEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCategoryFilter_AnyDevelopmentPhase()
  {
    return (EAttribute)categoryFilterEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequirementTypeCategories()
  {
    return requirementTypeCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodTypeCategories()
  {
    return methodTypeCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUserSelectionCategories()
  {
    return userSelectionCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualityAttributeCategories()
  {
    return qualityAttributeCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDevelopmentPhaseCategories()
  {
    return developmentPhaseCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequirementType()
  {
    return requirementTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodType()
  {
    return methodTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUserSelection()
  {
    return userSelectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualityAttribute()
  {
    return qualityAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDevelopmentPhase()
  {
    return developmentPhaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CategoriesFactory getCategoriesFactory()
  {
    return (CategoriesFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    categoriesDefinitionsEClass = createEClass(CATEGORIES_DEFINITIONS);
    createEReference(categoriesDefinitionsEClass, CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES);
    createEReference(categoriesDefinitionsEClass, CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES);
    createEReference(categoriesDefinitionsEClass, CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES);
    createEReference(categoriesDefinitionsEClass, CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES);
    createEReference(categoriesDefinitionsEClass, CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES);

    categoriesEClass = createEClass(CATEGORIES);
    createEReference(categoriesEClass, CATEGORIES__CATEGORY);

    categoryEClass = createEClass(CATEGORY);
    createEAttribute(categoryEClass, CATEGORY__NAME);

    categoryFilterEClass = createEClass(CATEGORY_FILTER);
    createEAttribute(categoryFilterEClass, CATEGORY_FILTER__NAME);
    createEReference(categoryFilterEClass, CATEGORY_FILTER__REQUIREMENT_TYPE);
    createEAttribute(categoryFilterEClass, CATEGORY_FILTER__ANY_REQUIREMENT_TYPE);
    createEReference(categoryFilterEClass, CATEGORY_FILTER__METHOD_TYPE);
    createEAttribute(categoryFilterEClass, CATEGORY_FILTER__ANY_METHOD_TYPE);
    createEReference(categoryFilterEClass, CATEGORY_FILTER__USER_SELECTION);
    createEAttribute(categoryFilterEClass, CATEGORY_FILTER__ANY_USER_SELECTION);
    createEReference(categoryFilterEClass, CATEGORY_FILTER__QUALITY_ATTRIBUTE);
    createEAttribute(categoryFilterEClass, CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE);
    createEReference(categoryFilterEClass, CATEGORY_FILTER__DEVELOPMENT_PHASE);
    createEAttribute(categoryFilterEClass, CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE);

    requirementTypeCategoriesEClass = createEClass(REQUIREMENT_TYPE_CATEGORIES);

    methodTypeCategoriesEClass = createEClass(METHOD_TYPE_CATEGORIES);

    userSelectionCategoriesEClass = createEClass(USER_SELECTION_CATEGORIES);

    qualityAttributeCategoriesEClass = createEClass(QUALITY_ATTRIBUTE_CATEGORIES);

    developmentPhaseCategoriesEClass = createEClass(DEVELOPMENT_PHASE_CATEGORIES);

    requirementTypeEClass = createEClass(REQUIREMENT_TYPE);

    methodTypeEClass = createEClass(METHOD_TYPE);

    userSelectionEClass = createEClass(USER_SELECTION);

    qualityAttributeEClass = createEClass(QUALITY_ATTRIBUTE);

    developmentPhaseEClass = createEClass(DEVELOPMENT_PHASE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    requirementTypeCategoriesEClass.getESuperTypes().add(this.getCategories());
    methodTypeCategoriesEClass.getESuperTypes().add(this.getCategories());
    userSelectionCategoriesEClass.getESuperTypes().add(this.getCategories());
    qualityAttributeCategoriesEClass.getESuperTypes().add(this.getCategories());
    developmentPhaseCategoriesEClass.getESuperTypes().add(this.getCategories());
    requirementTypeEClass.getESuperTypes().add(this.getCategory());
    methodTypeEClass.getESuperTypes().add(this.getCategory());
    userSelectionEClass.getESuperTypes().add(this.getCategory());
    qualityAttributeEClass.getESuperTypes().add(this.getCategory());
    developmentPhaseEClass.getESuperTypes().add(this.getCategory());

    // Initialize classes and features; add operations and parameters
    initEClass(categoriesDefinitionsEClass, CategoriesDefinitions.class, "CategoriesDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCategoriesDefinitions_RequirementTypeCategories(), this.getCategories(), null, "requirementTypeCategories", null, 0, 1, CategoriesDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoriesDefinitions_MethodTypeCategories(), this.getCategories(), null, "methodTypeCategories", null, 0, 1, CategoriesDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoriesDefinitions_Selectioncategories(), this.getCategories(), null, "selectioncategories", null, 0, 1, CategoriesDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoriesDefinitions_DevelopmentPhaseCategories(), this.getCategories(), null, "developmentPhaseCategories", null, 0, 1, CategoriesDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoriesDefinitions_QualityAttributeCategories(), this.getCategories(), null, "qualityAttributeCategories", null, 0, 1, CategoriesDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(categoriesEClass, Categories.class, "Categories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCategories_Category(), this.getCategory(), null, "category", null, 0, -1, Categories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCategory_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(categoryFilterEClass, CategoryFilter.class, "CategoryFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCategoryFilter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoryFilter_RequirementType(), this.getRequirementType(), null, "requirementType", null, 0, -1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategoryFilter_AnyRequirementType(), theEcorePackage.getEBoolean(), "anyRequirementType", null, 0, 1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoryFilter_MethodType(), this.getMethodType(), null, "methodType", null, 0, -1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategoryFilter_AnyMethodType(), theEcorePackage.getEBoolean(), "anyMethodType", null, 0, 1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoryFilter_UserSelection(), this.getUserSelection(), null, "userSelection", null, 0, -1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategoryFilter_AnyUserSelection(), theEcorePackage.getEBoolean(), "anyUserSelection", null, 0, 1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoryFilter_QualityAttribute(), this.getQualityAttribute(), null, "qualityAttribute", null, 0, -1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategoryFilter_AnyQualityAttribute(), theEcorePackage.getEBoolean(), "anyQualityAttribute", null, 0, 1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCategoryFilter_DevelopmentPhase(), this.getDevelopmentPhase(), null, "developmentPhase", null, 0, -1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCategoryFilter_AnyDevelopmentPhase(), theEcorePackage.getEBoolean(), "anyDevelopmentPhase", null, 0, 1, CategoryFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementTypeCategoriesEClass, RequirementTypeCategories.class, "RequirementTypeCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(methodTypeCategoriesEClass, MethodTypeCategories.class, "MethodTypeCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(userSelectionCategoriesEClass, UserSelectionCategories.class, "UserSelectionCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(qualityAttributeCategoriesEClass, QualityAttributeCategories.class, "QualityAttributeCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(developmentPhaseCategoriesEClass, DevelopmentPhaseCategories.class, "DevelopmentPhaseCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(requirementTypeEClass, RequirementType.class, "RequirementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(methodTypeEClass, MethodType.class, "MethodType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(userSelectionEClass, UserSelection.class, "UserSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(qualityAttributeEClass, QualityAttribute.class, "QualityAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(developmentPhaseEClass, DevelopmentPhase.class, "DevelopmentPhase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //CategoriesPackageImpl
