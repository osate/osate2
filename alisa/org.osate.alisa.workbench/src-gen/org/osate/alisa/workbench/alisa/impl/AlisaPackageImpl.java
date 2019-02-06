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
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.alisa.AssuranceTask;

import org.osate.categories.categories.CategoriesPackage;

import org.osate.organization.organization.OrganizationPackage;

import org.osate.reqspec.reqSpec.ReqSpecPackage;

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
  private EClass assuranceCaseEClass = null;

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
    Object registeredAlisaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    AlisaPackageImpl theAlisaPackage = registeredAlisaPackage instanceof AlisaPackageImpl ? (AlisaPackageImpl)registeredAlisaPackage : new AlisaPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    Aadl2Package.eINSTANCE.eClass();
    CommonPackage.eINSTANCE.eClass();
    CategoriesPackage.eINSTANCE.eClass();
    VerifyPackage.eINSTANCE.eClass();
    ReqSpecPackage.eINSTANCE.eClass();
    OrganizationPackage.eINSTANCE.eClass();

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
  public EClass getAssuranceCase()
  {
    return assuranceCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceCase_Name()
  {
    return (EAttribute)assuranceCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceCase_Title()
  {
    return (EAttribute)assuranceCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCase_System()
  {
    return (EReference)assuranceCaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCase_Description()
  {
    return (EReference)assuranceCaseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCase_AssurancePlans()
  {
    return (EReference)assuranceCaseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCase_Tasks()
  {
    return (EReference)assuranceCaseEClass.getEStructuralFeatures().get(5);
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
  public EReference getAssurancePlan_Target()
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
  public EReference getAssurancePlan_Assure()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_AssureGlobal()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_AssureSubsystems()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssurancePlan_AssureAll()
  {
    return (EAttribute)assurancePlanEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssurancePlan_AssumeSubsystems()
  {
    return (EReference)assurancePlanEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssurancePlan_AssumeAll()
  {
    return (EAttribute)assurancePlanEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssurancePlan_Issues()
  {
    return (EAttribute)assurancePlanEClass.getEStructuralFeatures().get(10);
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
  public EAttribute getAssuranceTask_Title()
  {
    return (EAttribute)assuranceTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceTask_Description()
  {
    return (EReference)assuranceTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceTask_Issues()
  {
    return (EAttribute)assuranceTaskEClass.getEStructuralFeatures().get(2);
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
    assuranceCaseEClass = createEClass(ASSURANCE_CASE);
    createEAttribute(assuranceCaseEClass, ASSURANCE_CASE__NAME);
    createEAttribute(assuranceCaseEClass, ASSURANCE_CASE__TITLE);
    createEReference(assuranceCaseEClass, ASSURANCE_CASE__SYSTEM);
    createEReference(assuranceCaseEClass, ASSURANCE_CASE__DESCRIPTION);
    createEReference(assuranceCaseEClass, ASSURANCE_CASE__ASSURANCE_PLANS);
    createEReference(assuranceCaseEClass, ASSURANCE_CASE__TASKS);

    assurancePlanEClass = createEClass(ASSURANCE_PLAN);
    createEAttribute(assurancePlanEClass, ASSURANCE_PLAN__NAME);
    createEAttribute(assurancePlanEClass, ASSURANCE_PLAN__TITLE);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__TARGET);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__DESCRIPTION);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__ASSURE);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__ASSURE_GLOBAL);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__ASSURE_SUBSYSTEMS);
    createEAttribute(assurancePlanEClass, ASSURANCE_PLAN__ASSURE_ALL);
    createEReference(assurancePlanEClass, ASSURANCE_PLAN__ASSUME_SUBSYSTEMS);
    createEAttribute(assurancePlanEClass, ASSURANCE_PLAN__ASSUME_ALL);
    createEAttribute(assurancePlanEClass, ASSURANCE_PLAN__ISSUES);

    assuranceTaskEClass = createEClass(ASSURANCE_TASK);
    createEAttribute(assuranceTaskEClass, ASSURANCE_TASK__TITLE);
    createEReference(assuranceTaskEClass, ASSURANCE_TASK__DESCRIPTION);
    createEAttribute(assuranceTaskEClass, ASSURANCE_TASK__ISSUES);
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
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);
    VerifyPackage theVerifyPackage = (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    assuranceTaskEClass.getESuperTypes().add(theCategoriesPackage.getCategoryFilter());

    // Initialize classes and features; add operations and parameters
    initEClass(assuranceCaseEClass, AssuranceCase.class, "AssuranceCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssuranceCase_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssuranceCase_Title(), theEcorePackage.getEString(), "title", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCase_System(), theAadl2Package.getComponentType(), null, "system", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCase_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCase_AssurancePlans(), this.getAssurancePlan(), null, "assurancePlans", null, 0, -1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCase_Tasks(), theCategoriesPackage.getCategoryFilter(), null, "tasks", null, 0, -1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assurancePlanEClass, AssurancePlan.class, "AssurancePlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssurancePlan_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssurancePlan_Title(), theEcorePackage.getEString(), "title", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_Target(), theAadl2Package.getComponentImplementation(), null, "target", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_Assure(), theVerifyPackage.getVerificationPlan(), null, "assure", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_AssureGlobal(), theVerifyPackage.getVerificationPlan(), null, "assureGlobal", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_AssureSubsystems(), theAadl2Package.getSubcomponent(), null, "assureSubsystems", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssurancePlan_AssureAll(), theEcorePackage.getEBoolean(), "assureAll", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssurancePlan_AssumeSubsystems(), theAadl2Package.getSubcomponent(), null, "assumeSubsystems", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssurancePlan_AssumeAll(), theEcorePackage.getEBoolean(), "assumeAll", null, 0, 1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssurancePlan_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, AssurancePlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assuranceTaskEClass, AssuranceTask.class, "AssuranceTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssuranceTask_Title(), theEcorePackage.getEString(), "title", null, 0, 1, AssuranceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceTask_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, AssuranceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssuranceTask_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, AssuranceTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //AlisaPackageImpl
