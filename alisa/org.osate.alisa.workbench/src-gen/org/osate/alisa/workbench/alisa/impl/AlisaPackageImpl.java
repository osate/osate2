/**
 */
package org.osate.alisa.workbench.alisa.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.CommonPackage;

import org.osate.alisa.workbench.alisa.AlisaFactory;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AlisaWorkArea;
import org.osate.alisa.workbench.alisa.AndSelectionConditionExpr;
import org.osate.alisa.workbench.alisa.AssuranceCasePlan;
import org.osate.alisa.workbench.alisa.SelectionCategoryReference;
import org.osate.alisa.workbench.alisa.SelectionConditionExpr;

import org.osate.categories.categories.CategoriesPackage;

import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlisaPackageImpl extends EPackageImpl implements AlisaPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alisaWorkAreaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assuranceCasePlanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectionConditionExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selectionCategoryReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andSelectionConditionExprEClass = null;

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
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AlisaPackageImpl()
  {
    super(eNS_URI, AlisaFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AlisaPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AlisaPackage init()
  {
    if (isInited) return (AlisaPackage)EPackage.Registry.INSTANCE.getEPackage(AlisaPackage.eNS_URI);

    // Obtain or create and register package
    AlisaPackageImpl theAlisaPackage = (AlisaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AlisaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AlisaPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    VerifyPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAlisaPackage.createPackageContents();

    // Initialize created meta-data
    theAlisaPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAlisaPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AlisaPackage.eNS_URI, theAlisaPackage);
    return theAlisaPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlisaWorkArea()
  {
    return alisaWorkAreaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlisaWorkArea_Name()
  {
    return (EAttribute)alisaWorkAreaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlisaWorkArea_Cases()
  {
    return (EReference)alisaWorkAreaEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssuranceCasePlan()
  {
    return assuranceCasePlanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceCasePlan_Name()
  {
    return (EAttribute)assuranceCasePlanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCasePlan_System()
  {
    return (EReference)assuranceCasePlanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceCasePlan_Title()
  {
    return (EAttribute)assuranceCasePlanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCasePlan_Description()
  {
    return (EReference)assuranceCasePlanEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCasePlan_Constant()
  {
    return (EReference)assuranceCasePlanEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCasePlan_Plans()
  {
    return (EReference)assuranceCasePlanEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCasePlan_SelectionFilter()
  {
    return (EReference)assuranceCasePlanEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelectionConditionExpr()
  {
    return selectionConditionExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelectionCategoryReference()
  {
    return selectionCategoryReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSelectionCategoryReference_Cat()
  {
    return (EReference)selectionCategoryReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndSelectionConditionExpr()
  {
    return andSelectionConditionExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndSelectionConditionExpr_Left()
  {
    return (EReference)andSelectionConditionExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndSelectionConditionExpr_Right()
  {
    return (EReference)andSelectionConditionExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlisaFactory getAlisaFactory()
  {
    return (AlisaFactory)getEFactoryInstance();
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
    alisaWorkAreaEClass = createEClass(ALISA_WORK_AREA);
    createEAttribute(alisaWorkAreaEClass, ALISA_WORK_AREA__NAME);
    createEReference(alisaWorkAreaEClass, ALISA_WORK_AREA__CASES);

    assuranceCasePlanEClass = createEClass(ASSURANCE_CASE_PLAN);
    createEAttribute(assuranceCasePlanEClass, ASSURANCE_CASE_PLAN__NAME);
    createEReference(assuranceCasePlanEClass, ASSURANCE_CASE_PLAN__SYSTEM);
    createEAttribute(assuranceCasePlanEClass, ASSURANCE_CASE_PLAN__TITLE);
    createEReference(assuranceCasePlanEClass, ASSURANCE_CASE_PLAN__DESCRIPTION);
    createEReference(assuranceCasePlanEClass, ASSURANCE_CASE_PLAN__CONSTANT);
    createEReference(assuranceCasePlanEClass, ASSURANCE_CASE_PLAN__PLANS);
    createEReference(assuranceCasePlanEClass, ASSURANCE_CASE_PLAN__SELECTION_FILTER);

    selectionConditionExprEClass = createEClass(SELECTION_CONDITION_EXPR);

    selectionCategoryReferenceEClass = createEClass(SELECTION_CATEGORY_REFERENCE);
    createEReference(selectionCategoryReferenceEClass, SELECTION_CATEGORY_REFERENCE__CAT);

    andSelectionConditionExprEClass = createEClass(AND_SELECTION_CONDITION_EXPR);
    createEReference(andSelectionConditionExprEClass, AND_SELECTION_CONDITION_EXPR__LEFT);
    createEReference(andSelectionConditionExprEClass, AND_SELECTION_CONDITION_EXPR__RIGHT);
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
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
    VerifyPackage theVerifyPackage = (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    selectionCategoryReferenceEClass.getESuperTypes().add(this.getSelectionConditionExpr());
    andSelectionConditionExprEClass.getESuperTypes().add(this.getSelectionConditionExpr());

    // Initialize classes and features; add operations and parameters
    initEClass(alisaWorkAreaEClass, AlisaWorkArea.class, "AlisaWorkArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlisaWorkArea_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AlisaWorkArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAlisaWorkArea_Cases(), this.getAssuranceCasePlan(), null, "cases", null, 0, -1, AlisaWorkArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assuranceCasePlanEClass, AssuranceCasePlan.class, "AssuranceCasePlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssuranceCasePlan_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AssuranceCasePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCasePlan_System(), theAadl2Package.getComponentImplementation(), null, "system", null, 0, 1, AssuranceCasePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssuranceCasePlan_Title(), theEcorePackage.getEString(), "title", null, 0, 1, AssuranceCasePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCasePlan_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, AssuranceCasePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCasePlan_Constant(), theCommonPackage.getFinalValue(), null, "constant", null, 0, -1, AssuranceCasePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCasePlan_Plans(), theVerifyPackage.getVerificationPlan(), null, "plans", null, 0, -1, AssuranceCasePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCasePlan_SelectionFilter(), this.getSelectionConditionExpr(), null, "selectionFilter", null, 0, 1, AssuranceCasePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selectionConditionExprEClass, SelectionConditionExpr.class, "SelectionConditionExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(selectionCategoryReferenceEClass, SelectionCategoryReference.class, "SelectionCategoryReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSelectionCategoryReference_Cat(), theCategoriesPackage.getVerificationCategory(), null, "cat", null, 0, 1, SelectionCategoryReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andSelectionConditionExprEClass, AndSelectionConditionExpr.class, "AndSelectionConditionExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndSelectionConditionExpr_Left(), this.getSelectionConditionExpr(), null, "left", null, 0, 1, AndSelectionConditionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndSelectionConditionExpr_Right(), this.getSelectionConditionExpr(), null, "right", null, 0, 1, AndSelectionConditionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //AlisaPackageImpl
