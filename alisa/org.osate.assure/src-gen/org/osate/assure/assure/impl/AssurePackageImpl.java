/**
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.aadl2.instance.InstancePackage;

import org.osate.assure.assure.AggregateResult;
import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.HazardResult;
import org.osate.assure.assure.IfThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExecutionState;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;

import org.osate.reqspec.reqSpec.ReqSpecPackage;

import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssurePackageImpl extends EPackageImpl implements AssurePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass caseResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass claimResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hazardResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aggregateResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assumptionResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preconditionResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationActivityResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass failThenResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifThenResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum verificationResultStateEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum verificationExecutionStateEEnum = null;

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
   * @see org.osate.assure.assure.AssurePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AssurePackageImpl()
  {
    super(eNS_URI, AssureFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AssurePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AssurePackage init()
  {
    if (isInited) return (AssurePackage)EPackage.Registry.INSTANCE.getEPackage(AssurePackage.eNS_URI);

    // Obtain or create and register package
    AssurePackageImpl theAssurePackage = (AssurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AssurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AssurePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    InstancePackage.eINSTANCE.eClass();
    VerifyPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAssurePackage.createPackageContents();

    // Initialize created meta-data
    theAssurePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAssurePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AssurePackage.eNS_URI, theAssurePackage);
    return theAssurePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCaseResult()
  {
    return caseResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseResult_Target()
  {
    return (EReference)caseResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseResult_InstanceURI()
  {
    return (EReference)caseResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCaseResult_PassCount()
  {
    return (EAttribute)caseResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseResult_SubCaseResult()
  {
    return (EReference)caseResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseResult_ClaimResult()
  {
    return (EReference)caseResultEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCaseResult_HazardResult()
  {
    return (EReference)caseResultEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClaimResult()
  {
    return claimResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimResult_Target()
  {
    return (EReference)claimResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClaimResult_SuccessCount()
  {
    return (EAttribute)claimResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimResult_SubClaimResult()
  {
    return (EReference)claimResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimResult_VerificationActivityResult()
  {
    return (EReference)claimResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHazardResult()
  {
    return hazardResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHazardResult_Target()
  {
    return (EReference)hazardResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHazardResult_PassCount()
  {
    return (EAttribute)hazardResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHazardResult_ClaimResult()
  {
    return (EReference)hazardResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAggregateResult()
  {
    return aggregateResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAggregateResult_Name()
  {
    return (EAttribute)aggregateResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAggregateResult_FailCount()
  {
    return (EAttribute)aggregateResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAggregateResult_UnknownCount()
  {
    return (EAttribute)aggregateResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAggregateResult_TbdCount()
  {
    return (EAttribute)aggregateResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAggregateResult_Weight()
  {
    return (EAttribute)aggregateResultEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAggregateResult_SucessMsg()
  {
    return (EAttribute)aggregateResultEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssumptionResult()
  {
    return assumptionResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssumptionResult_Target()
  {
    return (EReference)assumptionResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssumptionResult_SuccessCount()
  {
    return (EAttribute)assumptionResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssumptionResult_VerificationResult()
  {
    return (EReference)assumptionResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreconditionResult()
  {
    return preconditionResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreconditionResult_Target()
  {
    return (EReference)preconditionResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreconditionResult_SuccessCount()
  {
    return (EAttribute)preconditionResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreconditionResult_VerificationResult()
  {
    return (EReference)preconditionResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationActivityResult()
  {
    return verificationActivityResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivityResult_Name()
  {
    return (EAttribute)verificationActivityResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_Target()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivityResult_ExecutionState()
  {
    return (EAttribute)verificationActivityResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_Result()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivityResult_Weight()
  {
    return (EAttribute)verificationActivityResultEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivityResult_SucessMsg()
  {
    return (EAttribute)verificationActivityResultEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_AssumptionResult()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_PreconditionResult()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_First()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_Second()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationResult()
  {
    return verificationResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationResult_ResultState()
  {
    return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationResult_Type()
  {
    return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationResult_FailMsg()
  {
    return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationResult_FailTarget()
  {
    return (EReference)verificationResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFailThenResult()
  {
    return failThenResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfThenResult()
  {
    return ifThenResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVerificationResultState()
  {
    return verificationResultStateEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVerificationExecutionState()
  {
    return verificationExecutionStateEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssureFactory getAssureFactory()
  {
    return (AssureFactory)getEFactoryInstance();
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
    caseResultEClass = createEClass(CASE_RESULT);
    createEReference(caseResultEClass, CASE_RESULT__TARGET);
    createEReference(caseResultEClass, CASE_RESULT__INSTANCE_URI);
    createEAttribute(caseResultEClass, CASE_RESULT__PASS_COUNT);
    createEReference(caseResultEClass, CASE_RESULT__SUB_CASE_RESULT);
    createEReference(caseResultEClass, CASE_RESULT__CLAIM_RESULT);
    createEReference(caseResultEClass, CASE_RESULT__HAZARD_RESULT);

    claimResultEClass = createEClass(CLAIM_RESULT);
    createEReference(claimResultEClass, CLAIM_RESULT__TARGET);
    createEAttribute(claimResultEClass, CLAIM_RESULT__SUCCESS_COUNT);
    createEReference(claimResultEClass, CLAIM_RESULT__SUB_CLAIM_RESULT);
    createEReference(claimResultEClass, CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT);

    hazardResultEClass = createEClass(HAZARD_RESULT);
    createEReference(hazardResultEClass, HAZARD_RESULT__TARGET);
    createEAttribute(hazardResultEClass, HAZARD_RESULT__PASS_COUNT);
    createEReference(hazardResultEClass, HAZARD_RESULT__CLAIM_RESULT);

    aggregateResultEClass = createEClass(AGGREGATE_RESULT);
    createEAttribute(aggregateResultEClass, AGGREGATE_RESULT__NAME);
    createEAttribute(aggregateResultEClass, AGGREGATE_RESULT__FAIL_COUNT);
    createEAttribute(aggregateResultEClass, AGGREGATE_RESULT__UNKNOWN_COUNT);
    createEAttribute(aggregateResultEClass, AGGREGATE_RESULT__TBD_COUNT);
    createEAttribute(aggregateResultEClass, AGGREGATE_RESULT__WEIGHT);
    createEAttribute(aggregateResultEClass, AGGREGATE_RESULT__SUCESS_MSG);

    assumptionResultEClass = createEClass(ASSUMPTION_RESULT);
    createEReference(assumptionResultEClass, ASSUMPTION_RESULT__TARGET);
    createEAttribute(assumptionResultEClass, ASSUMPTION_RESULT__SUCCESS_COUNT);
    createEReference(assumptionResultEClass, ASSUMPTION_RESULT__VERIFICATION_RESULT);

    preconditionResultEClass = createEClass(PRECONDITION_RESULT);
    createEReference(preconditionResultEClass, PRECONDITION_RESULT__TARGET);
    createEAttribute(preconditionResultEClass, PRECONDITION_RESULT__SUCCESS_COUNT);
    createEReference(preconditionResultEClass, PRECONDITION_RESULT__VERIFICATION_RESULT);

    verificationActivityResultEClass = createEClass(VERIFICATION_ACTIVITY_RESULT);
    createEAttribute(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__NAME);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__TARGET);
    createEAttribute(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__RESULT);
    createEAttribute(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__WEIGHT);
    createEAttribute(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__FIRST);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__SECOND);

    verificationResultEClass = createEClass(VERIFICATION_RESULT);
    createEAttribute(verificationResultEClass, VERIFICATION_RESULT__RESULT_STATE);
    createEAttribute(verificationResultEClass, VERIFICATION_RESULT__TYPE);
    createEAttribute(verificationResultEClass, VERIFICATION_RESULT__FAIL_MSG);
    createEReference(verificationResultEClass, VERIFICATION_RESULT__FAIL_TARGET);

    failThenResultEClass = createEClass(FAIL_THEN_RESULT);

    ifThenResultEClass = createEClass(IF_THEN_RESULT);

    // Create enums
    verificationResultStateEEnum = createEEnum(VERIFICATION_RESULT_STATE);
    verificationExecutionStateEEnum = createEEnum(VERIFICATION_EXECUTION_STATE);
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
    InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    ReqSpecPackage theReqSpecPackage = (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);
    VerifyPackage theVerifyPackage = (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    caseResultEClass.getESuperTypes().add(this.getAggregateResult());
    claimResultEClass.getESuperTypes().add(this.getAggregateResult());
    hazardResultEClass.getESuperTypes().add(this.getAggregateResult());
    assumptionResultEClass.getESuperTypes().add(this.getAggregateResult());
    preconditionResultEClass.getESuperTypes().add(this.getAggregateResult());
    failThenResultEClass.getESuperTypes().add(this.getVerificationActivityResult());
    ifThenResultEClass.getESuperTypes().add(this.getVerificationActivityResult());

    // Initialize classes and features; add operations and parameters
    initEClass(caseResultEClass, CaseResult.class, "CaseResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCaseResult_Target(), theAadl2Package.getClassifier(), null, "target", null, 0, 1, CaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCaseResult_InstanceURI(), theInstancePackage.getInstanceObject(), null, "instanceURI", null, 0, 1, CaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCaseResult_PassCount(), theEcorePackage.getEInt(), "passCount", null, 0, 1, CaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCaseResult_SubCaseResult(), this.getCaseResult(), null, "subCaseResult", null, 0, -1, CaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCaseResult_ClaimResult(), this.getClaimResult(), null, "claimResult", null, 0, -1, CaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCaseResult_HazardResult(), this.getHazardResult(), null, "hazardResult", null, 0, -1, CaseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimResultEClass, ClaimResult.class, "ClaimResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClaimResult_Target(), theReqSpecPackage.getRequirement(), null, "target", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaimResult_SuccessCount(), theEcorePackage.getEInt(), "successCount", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaimResult_SubClaimResult(), this.getClaimResult(), null, "subClaimResult", null, 0, -1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaimResult_VerificationActivityResult(), this.getVerificationActivityResult(), null, "verificationActivityResult", null, 0, -1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hazardResultEClass, HazardResult.class, "HazardResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getHazardResult_Target(), theReqSpecPackage.getHazard(), null, "target", null, 0, 1, HazardResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHazardResult_PassCount(), theEcorePackage.getEInt(), "passCount", null, 0, 1, HazardResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHazardResult_ClaimResult(), this.getClaimResult(), null, "claimResult", null, 0, -1, HazardResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aggregateResultEClass, AggregateResult.class, "AggregateResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAggregateResult_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AggregateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAggregateResult_FailCount(), theEcorePackage.getEInt(), "failCount", null, 0, 1, AggregateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAggregateResult_UnknownCount(), theEcorePackage.getEInt(), "unknownCount", null, 0, 1, AggregateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAggregateResult_TbdCount(), theEcorePackage.getEInt(), "tbdCount", null, 0, 1, AggregateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAggregateResult_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, AggregateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAggregateResult_SucessMsg(), theEcorePackage.getEString(), "sucessMsg", null, 0, 1, AggregateResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assumptionResultEClass, AssumptionResult.class, "AssumptionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssumptionResult_Target(), theVerifyPackage.getVerificationAssumption(), null, "target", null, 0, 1, AssumptionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssumptionResult_SuccessCount(), theEcorePackage.getEInt(), "successCount", null, 0, 1, AssumptionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssumptionResult_VerificationResult(), this.getVerificationActivityResult(), null, "verificationResult", null, 0, -1, AssumptionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preconditionResultEClass, PreconditionResult.class, "PreconditionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPreconditionResult_Target(), theVerifyPackage.getVerificationPrecondition(), null, "target", null, 0, 1, PreconditionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPreconditionResult_SuccessCount(), theEcorePackage.getEInt(), "successCount", null, 0, 1, PreconditionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPreconditionResult_VerificationResult(), this.getVerificationActivityResult(), null, "verificationResult", null, 0, -1, PreconditionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationActivityResultEClass, VerificationActivityResult.class, "VerificationActivityResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationActivityResult_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_Target(), theVerifyPackage.getVerificationActivity(), null, "target", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivityResult_ExecutionState(), this.getVerificationExecutionState(), "executionState", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_Result(), this.getVerificationResult(), null, "result", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivityResult_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivityResult_SucessMsg(), theEcorePackage.getEString(), "sucessMsg", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_AssumptionResult(), this.getAssumptionResult(), null, "assumptionResult", null, 0, -1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_PreconditionResult(), this.getPreconditionResult(), null, "preconditionResult", null, 0, -1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_First(), this.getVerificationActivityResult(), null, "first", null, 0, -1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_Second(), this.getVerificationActivityResult(), null, "second", null, 0, -1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationResultEClass, VerificationResult.class, "VerificationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationResult_ResultState(), this.getVerificationResultState(), "resultState", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationResult_Type(), theEcorePackage.getEString(), "type", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationResult_FailMsg(), theEcorePackage.getEString(), "failMsg", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationResult_FailTarget(), theEcorePackage.getEObject(), null, "failTarget", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(failThenResultEClass, FailThenResult.class, "FailThenResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ifThenResultEClass, IfThenResult.class, "IfThenResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(verificationResultStateEEnum, VerificationResultState.class, "VerificationResultState");
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.TBD);
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.SUCCESS);
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.FAIL);
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.UNKNOWN);

    initEEnum(verificationExecutionStateEEnum, VerificationExecutionState.class, "VerificationExecutionState");
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.TODO);
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.RUNNING);
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.REDO);
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.COMPLETED);

    // Create resource
    createResource(eNS_URI);
  }

} //AssurePackageImpl
