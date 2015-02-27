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

import org.osate.alisa.workbench.alisa.AlisaFactory;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AlisaWorkArea;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.alisa.AssuranceTask;
import org.osate.alisa.workbench.alisa.Description;
import org.osate.alisa.workbench.alisa.DescriptionElement;

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
  private EClass assurancePlanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass descriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass descriptionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assuranceTaskEClass = null;

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
  public EClass getAssurancePlan()
  {
    return assurancePlanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssurancePlan_Name()
  {
    return (EAttribute)assurancePlanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssurancePlan_Title()
  {
    return (EAttribute)assurancePlanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_System()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_Description()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_Plans()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_VerifiedAssumption()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_SelectionFilter()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDescription()
  {
    return descriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDescription_Description()
  {
    return (EReference)descriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDescriptionElement()
  {
    return descriptionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDescriptionElement_Text()
  {
    return (EAttribute)descriptionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDescriptionElement_ThisTarget()
  {
    return (EAttribute)descriptionElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssuranceTask()
  {
    return assuranceTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceTask_AssurancePlan()
  {
    return (EReference)assuranceTaskEClass.getEStructuralFeatures().get(0);
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

    assurancePlanEClass = createEClass(ASSURANCE_PLAN);
    createEAttribute(assurancePlanEClass, ASSURANCE_PLAN__NAME);
    createEAttribute(assurancePlanEClass, ASSURANCE_PLAN__TITLE);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__SYSTEM);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__DESCRIPTION);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__PLANS);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__VERIFIED_ASSUMPTION);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__SELECTION_FILTER);

    descriptionEClass = createEClass(DESCRIPTION);
    createEReference(descriptionEClass, DESCRIPTION__DESCRIPTION);

    descriptionElementEClass = createEClass(DESCRIPTION_ELEMENT);
    createEAttribute(descriptionElementEClass, DESCRIPTION_ELEMENT__TEXT);
    createEAttribute(descriptionElementEClass, DESCRIPTION_ELEMENT__THIS_TARGET);

    assuranceTaskEClass = createEClass(ASSURANCE_TASK);
    createEReference(assuranceTaskEClass, ASSURANCE_TASK__ASSURANCE_PLAN);
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
    VerifyPackage theVerifyPackage = (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    assuranceTaskEClass.getESuperTypes().add(this.getAssurancePlan());

    // Initialize classes and features; add operations and parameters
    initEClass(alisaWorkAreaEClass, AlisaWorkArea.class, "AlisaWorkArea", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlisaWorkArea_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AlisaWorkArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAlisaWorkArea_Cases(), this.getAssurancePlan(), null, "cases", null, 0, -1, AlisaWorkArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assurancePlanEClass, AssurancePlan.class, "AssurancePlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssurancePlan_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssurancePlan_Title(), theEcorePackage.getEString(), "title", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_System(), theAadl2Package.getComponentImplementation(), null, "system", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_Description(), this.getDescription(), null, "description", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_Plans(), theVerifyPackage.getVerificationPlan(), null, "plans", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_VerifiedAssumption(), theAadl2Package.getComponentClassifier(), null, "verifiedAssumption", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_SelectionFilter(), theCategoriesPackage.getSelectionCategory(), null, "selectionFilter", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(descriptionEClass, Description.class, "Description", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDescription_Description(), this.getDescriptionElement(), null, "description", null, 0, -1, Description.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(descriptionElementEClass, DescriptionElement.class, "DescriptionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDescriptionElement_Text(), theEcorePackage.getEString(), "text", null, 0, 1, DescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDescriptionElement_ThisTarget(), theEcorePackage.getEBoolean(), "thisTarget", null, 0, 1, DescriptionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assuranceTaskEClass, AssuranceTask.class, "AssuranceTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssuranceTask_AssurancePlan(), this.getAssurancePlan(), null, "assurancePlan", null, 0, 1, AssuranceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //AlisaPackageImpl
