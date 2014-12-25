/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.CommonPackage;

import org.osate.categories.categories.CategoriesPackage;

import org.osate.organization.organization.OrganizationPackage;

import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.Hazard;
import org.osate.reqspec.reqSpec.RSLVariable;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.ReqSpecContainer;
import org.osate.reqspec.reqSpec.ReqSpecFactory;
import org.osate.reqspec.reqSpec.ReqSpecFolder;
import org.osate.reqspec.reqSpec.ReqSpecModel;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReqSpecPackageImpl extends EPackageImpl implements ReqSpecPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqSpecContainerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contractualElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqSpecModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqSpecFolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rslVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass goalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hazardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalDocumentEClass = null;

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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ReqSpecPackageImpl()
  {
    super(eNS_URI, ReqSpecFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ReqSpecPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ReqSpecPackage init()
  {
    if (isInited) return (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);

    // Obtain or create and register package
    ReqSpecPackageImpl theReqSpecPackage = (ReqSpecPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReqSpecPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ReqSpecPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    Aadl2Package.eINSTANCE.eClass();
    CommonPackage.eINSTANCE.eClass();
    CategoriesPackage.eINSTANCE.eClass();
    OrganizationPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theReqSpecPackage.createPackageContents();

    // Initialize created meta-data
    theReqSpecPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theReqSpecPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ReqSpecPackage.eNS_URI, theReqSpecPackage);
    return theReqSpecPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqSpec()
  {
    return reqSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqSpecContainer()
  {
    return reqSpecContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecContainer_Target()
  {
    return (EReference)reqSpecContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecContainer_Content()
  {
    return (EReference)reqSpecContainerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqSpecContainer_Issue()
  {
    return (EAttribute)reqSpecContainerEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContractualElement()
  {
    return contractualElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_Name()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_Title()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractualElement_Target()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractualElement_TargetContext()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_Rationale()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_Issue()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqSpecModel()
  {
    return reqSpecModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqSpecModel_Name()
  {
    return (EAttribute)reqSpecModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecModel_Import()
  {
    return (EReference)reqSpecModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqSpecFolder()
  {
    return reqSpecFolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqSpecFolder_Label()
  {
    return (EAttribute)reqSpecFolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRSLVariable()
  {
    return rslVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRSLVariable_Name()
  {
    return (EAttribute)rslVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRSLVariable_Value()
  {
    return (EAttribute)rslVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGoal()
  {
    return goalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_Category()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_Description()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGoal_Assert()
  {
    return (EAttribute)goalEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_RefinesReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_Subgoal()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_DecomposesReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_EvolvesReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_ConflictsReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_StakeholderReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_StakeholderRequirementReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_SystemRequirementReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_DocReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequirement()
  {
    return requirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_Category()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_Description()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRequirement_Assert()
  {
    return (EAttribute)requirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_ReqValue()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_GoalReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_HazardReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_RefinesReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_Subrequirement()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_DecomposesReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_EvolvesReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_StakeholderRequirementReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_SystemRequirementReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_DocReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHazard()
  {
    return hazardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHazard_Category()
  {
    return (EReference)hazardEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHazard_Description()
  {
    return (EAttribute)hazardEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalDocument()
  {
    return externalDocumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalDocument_DocReference()
  {
    return (EAttribute)externalDocumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalDocument_DocFragment()
  {
    return (EAttribute)externalDocumentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecFactory getReqSpecFactory()
  {
    return (ReqSpecFactory)getEFactoryInstance();
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
    reqSpecEClass = createEClass(REQ_SPEC);

    reqSpecContainerEClass = createEClass(REQ_SPEC_CONTAINER);
    createEReference(reqSpecContainerEClass, REQ_SPEC_CONTAINER__TARGET);
    createEReference(reqSpecContainerEClass, REQ_SPEC_CONTAINER__CONTENT);
    createEAttribute(reqSpecContainerEClass, REQ_SPEC_CONTAINER__ISSUE);

    contractualElementEClass = createEClass(CONTRACTUAL_ELEMENT);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__NAME);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__TITLE);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__TARGET);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__TARGET_CONTEXT);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__RATIONALE);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__ISSUE);

    reqSpecModelEClass = createEClass(REQ_SPEC_MODEL);
    createEAttribute(reqSpecModelEClass, REQ_SPEC_MODEL__NAME);
    createEReference(reqSpecModelEClass, REQ_SPEC_MODEL__IMPORT);

    reqSpecFolderEClass = createEClass(REQ_SPEC_FOLDER);
    createEAttribute(reqSpecFolderEClass, REQ_SPEC_FOLDER__LABEL);

    rslVariableEClass = createEClass(RSL_VARIABLE);
    createEAttribute(rslVariableEClass, RSL_VARIABLE__NAME);
    createEAttribute(rslVariableEClass, RSL_VARIABLE__VALUE);

    goalEClass = createEClass(GOAL);
    createEReference(goalEClass, GOAL__CATEGORY);
    createEReference(goalEClass, GOAL__DESCRIPTION);
    createEAttribute(goalEClass, GOAL__ASSERT);
    createEReference(goalEClass, GOAL__REFINES_REFERENCE);
    createEReference(goalEClass, GOAL__SUBGOAL);
    createEReference(goalEClass, GOAL__DECOMPOSES_REFERENCE);
    createEReference(goalEClass, GOAL__EVOLVES_REFERENCE);
    createEReference(goalEClass, GOAL__CONFLICTS_REFERENCE);
    createEReference(goalEClass, GOAL__STAKEHOLDER_REFERENCE);
    createEReference(goalEClass, GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE);
    createEReference(goalEClass, GOAL__SYSTEM_REQUIREMENT_REFERENCE);
    createEReference(goalEClass, GOAL__DOC_REFERENCE);

    requirementEClass = createEClass(REQUIREMENT);
    createEReference(requirementEClass, REQUIREMENT__CATEGORY);
    createEReference(requirementEClass, REQUIREMENT__DESCRIPTION);
    createEAttribute(requirementEClass, REQUIREMENT__ASSERT);
    createEReference(requirementEClass, REQUIREMENT__REQ_VALUE);
    createEReference(requirementEClass, REQUIREMENT__GOAL_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__HAZARD_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__REFINES_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__SUBREQUIREMENT);
    createEReference(requirementEClass, REQUIREMENT__DECOMPOSES_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__EVOLVES_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__SYSTEM_REQUIREMENT_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__DOC_REFERENCE);

    hazardEClass = createEClass(HAZARD);
    createEReference(hazardEClass, HAZARD__CATEGORY);
    createEAttribute(hazardEClass, HAZARD__DESCRIPTION);

    externalDocumentEClass = createEClass(EXTERNAL_DOCUMENT);
    createEAttribute(externalDocumentEClass, EXTERNAL_DOCUMENT__DOC_REFERENCE);
    createEAttribute(externalDocumentEClass, EXTERNAL_DOCUMENT__DOC_FRAGMENT);
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
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);
    OrganizationPackage theOrganizationPackage = (OrganizationPackage)EPackage.Registry.INSTANCE.getEPackage(OrganizationPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    reqSpecModelEClass.getESuperTypes().add(this.getReqSpec());
    reqSpecModelEClass.getESuperTypes().add(this.getReqSpecContainer());
    reqSpecFolderEClass.getESuperTypes().add(this.getReqSpecContainer());
    goalEClass.getESuperTypes().add(this.getContractualElement());
    requirementEClass.getESuperTypes().add(this.getContractualElement());
    hazardEClass.getESuperTypes().add(this.getContractualElement());

    // Initialize classes and features; add operations and parameters
    initEClass(reqSpecEClass, ReqSpec.class, "ReqSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(reqSpecContainerEClass, ReqSpecContainer.class, "ReqSpecContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReqSpecContainer_Target(), theAadl2Package.getClassifier(), null, "target", null, 0, 1, ReqSpecContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecContainer_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, ReqSpecContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReqSpecContainer_Issue(), theEcorePackage.getEString(), "issue", null, 0, -1, ReqSpecContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contractualElementEClass, ContractualElement.class, "ContractualElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContractualElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Target(), theAadl2Package.getNamedElement(), null, "target", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_TargetContext(), theAadl2Package.getClassifier(), null, "targetContext", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Rationale(), theEcorePackage.getEString(), "rationale", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Issue(), theEcorePackage.getEString(), "issue", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqSpecModelEClass, ReqSpecModel.class, "ReqSpecModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReqSpecModel_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ReqSpecModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecModel_Import(), theCommonPackage.getImport(), null, "import", null, 0, -1, ReqSpecModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqSpecFolderEClass, ReqSpecFolder.class, "ReqSpecFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReqSpecFolder_Label(), theEcorePackage.getEString(), "label", null, 0, 1, ReqSpecFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rslVariableEClass, RSLVariable.class, "RSLVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRSLVariable_Name(), theEcorePackage.getEString(), "name", null, 0, 1, RSLVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRSLVariable_Value(), theEcorePackage.getEString(), "value", null, 0, 1, RSLVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGoal_Category(), theCategoriesPackage.getRequirementCategory(), null, "category", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGoal_Assert(), theEcorePackage.getEString(), "assert", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_RefinesReference(), this.getGoal(), null, "refinesReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_Subgoal(), this.getGoal(), null, "subgoal", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_DecomposesReference(), this.getGoal(), null, "decomposesReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_EvolvesReference(), this.getGoal(), null, "evolvesReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_ConflictsReference(), this.getGoal(), null, "conflictsReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_StakeholderReference(), theOrganizationPackage.getStakeholder(), null, "stakeholderReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_StakeholderRequirementReference(), this.getGoal(), null, "stakeholderRequirementReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_SystemRequirementReference(), this.getContractualElement(), null, "systemRequirementReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_DocReference(), this.getExternalDocument(), null, "docReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirement_Category(), theCategoriesPackage.getRequirementCategory(), null, "category", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRequirement_Assert(), theEcorePackage.getEString(), "assert", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_ReqValue(), this.getRSLVariable(), null, "reqValue", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_GoalReference(), this.getGoal(), null, "goalReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_HazardReference(), this.getHazard(), null, "hazardReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_RefinesReference(), this.getRequirement(), null, "refinesReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_Subrequirement(), this.getRequirement(), null, "subrequirement", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_DecomposesReference(), this.getRequirement(), null, "decomposesReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_EvolvesReference(), this.getRequirement(), null, "evolvesReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_StakeholderRequirementReference(), this.getGoal(), null, "stakeholderRequirementReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_SystemRequirementReference(), this.getContractualElement(), null, "systemRequirementReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_DocReference(), this.getExternalDocument(), null, "docReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hazardEClass, Hazard.class, "Hazard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHazard_Category(), theCategoriesPackage.getHazardCategory(), null, "category", null, 0, 1, Hazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHazard_Description(), theEcorePackage.getEString(), "description", null, 0, 1, Hazard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalDocumentEClass, ExternalDocument.class, "ExternalDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExternalDocument_DocReference(), theEcorePackage.getEString(), "docReference", null, 0, 1, ExternalDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExternalDocument_DocFragment(), theEcorePackage.getEString(), "docFragment", null, 0, 1, ExternalDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ReqSpecPackageImpl
