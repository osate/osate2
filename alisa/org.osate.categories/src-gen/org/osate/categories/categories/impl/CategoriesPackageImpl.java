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
import org.osate.categories.categories.HazardCategories;
import org.osate.categories.categories.HazardCategory;
import org.osate.categories.categories.RequirementCategories;
import org.osate.categories.categories.RequirementCategory;
import org.osate.categories.categories.VerificationCategories;
import org.osate.categories.categories.VerificationCategory;

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
  private EClass hazardCategoriesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationCategoriesEClass = null;

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
  private EClass hazardCategoryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationCategoryEClass = null;

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
  public EClass getHazardCategories()
  {
    return hazardCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHazardCategories_Category()
  {
    return (EReference)hazardCategoriesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationCategories()
  {
    return verificationCategoriesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationCategories_Category()
  {
    return (EReference)verificationCategoriesEClass.getEStructuralFeatures().get(0);
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
  public EReference getRequirementCategory_Extends()
  {
    return (EReference)requirementCategoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHazardCategory()
  {
    return hazardCategoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHazardCategory_Extends()
  {
    return (EReference)hazardCategoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationCategory()
  {
    return verificationCategoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationCategory_Extends()
  {
    return (EReference)verificationCategoryEClass.getEStructuralFeatures().get(0);
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

    hazardCategoriesEClass = createEClass(HAZARD_CATEGORIES);
    createEReference(hazardCategoriesEClass, HAZARD_CATEGORIES__CATEGORY);

    verificationCategoriesEClass = createEClass(VERIFICATION_CATEGORIES);
    createEReference(verificationCategoriesEClass, VERIFICATION_CATEGORIES__CATEGORY);

    categoryEClass = createEClass(CATEGORY);
    createEAttribute(categoryEClass, CATEGORY__NAME);

    requirementCategoryEClass = createEClass(REQUIREMENT_CATEGORY);
    createEReference(requirementCategoryEClass, REQUIREMENT_CATEGORY__EXTENDS);

    hazardCategoryEClass = createEClass(HAZARD_CATEGORY);
    createEReference(hazardCategoryEClass, HAZARD_CATEGORY__EXTENDS);

    verificationCategoryEClass = createEClass(VERIFICATION_CATEGORY);
    createEReference(verificationCategoryEClass, VERIFICATION_CATEGORY__EXTENDS);
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
    hazardCategoriesEClass.getESuperTypes().add(this.getCategories());
    verificationCategoriesEClass.getESuperTypes().add(this.getCategories());
    requirementCategoryEClass.getESuperTypes().add(this.getCategory());
    hazardCategoryEClass.getESuperTypes().add(this.getCategory());
    verificationCategoryEClass.getESuperTypes().add(this.getCategory());

    // Initialize classes and features; add operations and parameters
    initEClass(categoriesEClass, Categories.class, "Categories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(requirementCategoriesEClass, RequirementCategories.class, "RequirementCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirementCategories_Category(), this.getRequirementCategory(), null, "category", null, 0, -1, RequirementCategories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hazardCategoriesEClass, HazardCategories.class, "HazardCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHazardCategories_Category(), this.getHazardCategory(), null, "category", null, 0, -1, HazardCategories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationCategoriesEClass, VerificationCategories.class, "VerificationCategories", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerificationCategories_Category(), this.getVerificationCategory(), null, "category", null, 0, -1, VerificationCategories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCategory_Name(), ecorePackage.getEString(), "name", null, 0, 1, Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementCategoryEClass, RequirementCategory.class, "RequirementCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirementCategory_Extends(), this.getRequirementCategory(), null, "extends", null, 0, 1, RequirementCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hazardCategoryEClass, HazardCategory.class, "HazardCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHazardCategory_Extends(), this.getHazardCategory(), null, "extends", null, 0, 1, HazardCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationCategoryEClass, VerificationCategory.class, "VerificationCategory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerificationCategory_Extends(), this.getVerificationCategory(), null, "extends", null, 0, 1, VerificationCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //CategoriesPackageImpl
