/**
 */
package org.osate.categories.categories.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.categories.categories.Categories;
import org.osate.categories.categories.CategoriesFactory;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.Category;
import org.osate.categories.categories.MethodCategories;
import org.osate.categories.categories.MethodCategory;
import org.osate.categories.categories.RequirementCategories;
import org.osate.categories.categories.RequirementCategory;
import org.osate.categories.categories.SelectionCategories;
import org.osate.categories.categories.SelectionCategory;

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
  private EClass categoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectionCategoriesEClass = null;

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
  private EClass requirementCategoryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodCategoryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectionCategoryEClass = null;

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
  public EClass getCategories()
  {
    return categoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequirementCategories()
  {
    return requirementCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirementCategories_Category()
  {
    return (EReference)requirementCategoriesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodCategories()
  {
    return methodCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodCategories_Category()
  {
    return (EReference)methodCategoriesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelectionCategories()
  {
    return selectionCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectionCategories_Category()
  {
    return (EReference)selectionCategoriesEClass.getEStructuralFeatures().get(0);
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
  public EClass getRequirementCategory()
  {
    return requirementCategoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirementCategory_SubCategories()
  {
    return (EReference)requirementCategoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodCategory()
  {
    return methodCategoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodCategory_SubCategories()
  {
    return (EReference)methodCategoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelectionCategory()
  {
    return selectionCategoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectionCategory_SubCategories()
  {
    return (EReference)selectionCategoryEClass.getEStructuralFeatures().get(0);
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
    categoriesEClass = createEClass(CATEGORIES);

    requirementCategoriesEClass = createEClass(REQUIREMENT_CATEGORIES);
    createEReference(requirementCategoriesEClass, REQUIREMENT_CATEGORIES__CATEGORY);

    methodCategoriesEClass = createEClass(METHOD_CATEGORIES);
    createEReference(methodCategoriesEClass, METHOD_CATEGORIES__CATEGORY);

    selectionCategoriesEClass = createEClass(SELECTION_CATEGORIES);
    createEReference(selectionCategoriesEClass, SELECTION_CATEGORIES__CATEGORY);

    categoryEClass = createEClass(CATEGORY);
    createEAttribute(categoryEClass, CATEGORY__NAME);

    requirementCategoryEClass = createEClass(REQUIREMENT_CATEGORY);
    createEReference(requirementCategoryEClass, REQUIREMENT_CATEGORY__SUB_CATEGORIES);

    methodCategoryEClass = createEClass(METHOD_CATEGORY);
    createEReference(methodCategoryEClass, METHOD_CATEGORY__SUB_CATEGORIES);

    selectionCategoryEClass = createEClass(SELECTION_CATEGORY);
    createEReference(selectionCategoryEClass, SELECTION_CATEGORY__SUB_CATEGORIES);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    requirementCategoriesEClass.getESuperTypes().add(this.getCategories());
    methodCategoriesEClass.getESuperTypes().add(this.getCategories());
    selectionCategoriesEClass.getESuperTypes().add(this.getCategories());
    requirementCategoryEClass.getESuperTypes().add(this.getCategory());
    methodCategoryEClass.getESuperTypes().add(this.getCategory());
    selectionCategoryEClass.getESuperTypes().add(this.getCategory());

    // Initialize classes and features; add operations and parameters
    initEClass(categoriesEClass, Categories.class, "Categories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(requirementCategoriesEClass, RequirementCategories.class, "RequirementCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirementCategories_Category(), this.getRequirementCategory(), null, "category", null, 0, -1, RequirementCategories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodCategoriesEClass, MethodCategories.class, "MethodCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMethodCategories_Category(), this.getMethodCategory(), null, "category", null, 0, -1, MethodCategories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selectionCategoriesEClass, SelectionCategories.class, "SelectionCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSelectionCategories_Category(), this.getSelectionCategory(), null, "category", null, 0, -1, SelectionCategories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementCategoryEClass, RequirementCategory.class, "RequirementCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirementCategory_SubCategories(), this.getRequirementCategory(), null, "subCategories", null, 0, -1, RequirementCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodCategoryEClass, MethodCategory.class, "MethodCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMethodCategory_SubCategories(), this.getMethodCategory(), null, "subCategories", null, 0, -1, MethodCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selectionCategoryEClass, SelectionCategory.class, "SelectionCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSelectionCategory_SubCategories(), this.getSelectionCategory(), null, "subCategories", null, 0, -1, SelectionCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //CategoriesPackageImpl
