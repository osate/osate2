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

import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.ResultIssueType;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExecutionState;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;

import org.osate.reqspec.reqSpec.ReqSpecPackage;

import org.osate.results.results.ResultsPackage;

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
  private EClass assuranceEvidenceEClass = null;

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
  private EClass verificationResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assureResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationExprEClass = null;

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
  private EClass andThenResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultIssueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass validationResultEClass = null;

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
  private EEnum resultIssueTypeEEnum = null;

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
    ResultsPackage.eINSTANCE.eClass();
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
  public EClass getAssuranceEvidence()
  {
    return assuranceEvidenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceEvidence_Name()
  {
    return (EAttribute)assuranceEvidenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceEvidence_Target()
  {
    return (EReference)assuranceEvidenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceEvidence_Instance()
  {
    return (EReference)assuranceEvidenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceEvidence_Message()
  {
    return (EAttribute)assuranceEvidenceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceEvidence_SubAssuranceEvidence()
  {
    return (EReference)assuranceEvidenceEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceEvidence_ClaimResult()
  {
    return (EReference)assuranceEvidenceEClass.getEStructuralFeatures().get(5);
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
  public EReference getClaimResult_Instance()
  {
    return (EReference)claimResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClaimResult_Message()
  {
    return (EAttribute)claimResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimResult_SubClaimResult()
  {
    return (EReference)claimResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaimResult_VerificationActivityResult()
  {
    return (EReference)claimResultEClass.getEStructuralFeatures().get(4);
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
  public EAttribute getVerificationResult_ExecutionState()
  {
    return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationResult_ResultState()
  {
    return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationResult_Issues()
  {
    return (EReference)verificationResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationResult_ResultReport()
  {
    return (EReference)verificationResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationResult_Message()
  {
    return (EAttribute)verificationResultEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssureResult()
  {
    return assureResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssureResult_SuccessCount()
  {
    return (EAttribute)assureResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssureResult_FailCount()
  {
    return (EAttribute)assureResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssureResult_UnknownCount()
  {
    return (EAttribute)assureResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssureResult_FailthenCount()
  {
    return (EAttribute)assureResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssureResult_AndthenCount()
  {
    return (EAttribute)assureResultEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssureResult_TbdCount()
  {
    return (EAttribute)assureResultEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssureResult_Weight()
  {
    return (EAttribute)assureResultEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationExpr()
  {
    return verificationExprEClass;
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
  public EReference getFailThenResult_First()
  {
    return (EReference)failThenResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFailThenResult_Second()
  {
    return (EReference)failThenResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFailThenResult_FailThen()
  {
    return (EAttribute)failThenResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFailThenResult_UnknownThen()
  {
    return (EAttribute)failThenResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFailThenResult_DidFail()
  {
    return (EAttribute)failThenResultEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndThenResult()
  {
    return andThenResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndThenResult_First()
  {
    return (EReference)andThenResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndThenResult_Second()
  {
    return (EReference)andThenResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAndThenResult_DidAndThenFail()
  {
    return (EAttribute)andThenResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultIssue()
  {
    return resultIssueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultIssue_IssueType()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultIssue_Name()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultIssue_Message()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResultIssue_ExceptionType()
  {
    return (EAttribute)resultIssueEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultIssue_Target()
  {
    return (EReference)resultIssueEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultIssue_Issues()
  {
    return (EReference)resultIssueEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValidationResult()
  {
    return validationResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValidationResult_Target()
  {
    return (EReference)validationResultEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getPreconditionResult_Name()
  {
    return (EAttribute)preconditionResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreconditionResult_Target()
  {
    return (EReference)preconditionResultEClass.getEStructuralFeatures().get(1);
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
  public EReference getVerificationActivityResult_Target()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_ValidationResult()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivityResult_PreconditionResult()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getResultIssueType()
  {
    return resultIssueTypeEEnum;
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
    assuranceEvidenceEClass = createEClass(ASSURANCE_EVIDENCE);
    createEAttribute(assuranceEvidenceEClass, ASSURANCE_EVIDENCE__NAME);
    createEReference(assuranceEvidenceEClass, ASSURANCE_EVIDENCE__TARGET);
    createEReference(assuranceEvidenceEClass, ASSURANCE_EVIDENCE__INSTANCE);
    createEAttribute(assuranceEvidenceEClass, ASSURANCE_EVIDENCE__MESSAGE);
    createEReference(assuranceEvidenceEClass, ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE);
    createEReference(assuranceEvidenceEClass, ASSURANCE_EVIDENCE__CLAIM_RESULT);

    claimResultEClass = createEClass(CLAIM_RESULT);
    createEReference(claimResultEClass, CLAIM_RESULT__TARGET);
    createEReference(claimResultEClass, CLAIM_RESULT__INSTANCE);
    createEAttribute(claimResultEClass, CLAIM_RESULT__MESSAGE);
    createEReference(claimResultEClass, CLAIM_RESULT__SUB_CLAIM_RESULT);
    createEReference(claimResultEClass, CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT);

    verificationResultEClass = createEClass(VERIFICATION_RESULT);
    createEAttribute(verificationResultEClass, VERIFICATION_RESULT__EXECUTION_STATE);
    createEAttribute(verificationResultEClass, VERIFICATION_RESULT__RESULT_STATE);
    createEReference(verificationResultEClass, VERIFICATION_RESULT__ISSUES);
    createEReference(verificationResultEClass, VERIFICATION_RESULT__RESULT_REPORT);
    createEAttribute(verificationResultEClass, VERIFICATION_RESULT__MESSAGE);

    assureResultEClass = createEClass(ASSURE_RESULT);
    createEAttribute(assureResultEClass, ASSURE_RESULT__SUCCESS_COUNT);
    createEAttribute(assureResultEClass, ASSURE_RESULT__FAIL_COUNT);
    createEAttribute(assureResultEClass, ASSURE_RESULT__UNKNOWN_COUNT);
    createEAttribute(assureResultEClass, ASSURE_RESULT__FAILTHEN_COUNT);
    createEAttribute(assureResultEClass, ASSURE_RESULT__ANDTHEN_COUNT);
    createEAttribute(assureResultEClass, ASSURE_RESULT__TBD_COUNT);
    createEAttribute(assureResultEClass, ASSURE_RESULT__WEIGHT);

    verificationExprEClass = createEClass(VERIFICATION_EXPR);

    failThenResultEClass = createEClass(FAIL_THEN_RESULT);
    createEReference(failThenResultEClass, FAIL_THEN_RESULT__FIRST);
    createEReference(failThenResultEClass, FAIL_THEN_RESULT__SECOND);
    createEAttribute(failThenResultEClass, FAIL_THEN_RESULT__FAIL_THEN);
    createEAttribute(failThenResultEClass, FAIL_THEN_RESULT__UNKNOWN_THEN);
    createEAttribute(failThenResultEClass, FAIL_THEN_RESULT__DID_FAIL);

    andThenResultEClass = createEClass(AND_THEN_RESULT);
    createEReference(andThenResultEClass, AND_THEN_RESULT__FIRST);
    createEReference(andThenResultEClass, AND_THEN_RESULT__SECOND);
    createEAttribute(andThenResultEClass, AND_THEN_RESULT__DID_AND_THEN_FAIL);

    resultIssueEClass = createEClass(RESULT_ISSUE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__ISSUE_TYPE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__NAME);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__MESSAGE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__EXCEPTION_TYPE);
    createEReference(resultIssueEClass, RESULT_ISSUE__TARGET);
    createEReference(resultIssueEClass, RESULT_ISSUE__ISSUES);

    validationResultEClass = createEClass(VALIDATION_RESULT);
    createEReference(validationResultEClass, VALIDATION_RESULT__TARGET);

    preconditionResultEClass = createEClass(PRECONDITION_RESULT);
    createEAttribute(preconditionResultEClass, PRECONDITION_RESULT__NAME);
    createEReference(preconditionResultEClass, PRECONDITION_RESULT__TARGET);

    verificationActivityResultEClass = createEClass(VERIFICATION_ACTIVITY_RESULT);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__TARGET);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT);

    // Create enums
    resultIssueTypeEEnum = createEEnum(RESULT_ISSUE_TYPE);
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
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);
    ReqSpecPackage theReqSpecPackage = (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);
    ResultsPackage theResultsPackage = (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
    VerifyPackage theVerifyPackage = (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    assuranceEvidenceEClass.getESuperTypes().add(this.getAssureResult());
    claimResultEClass.getESuperTypes().add(this.getAssureResult());
    verificationResultEClass.getESuperTypes().add(this.getAssureResult());
    verificationResultEClass.getESuperTypes().add(this.getVerificationExpr());
    verificationExprEClass.getESuperTypes().add(this.getAssureResult());
    failThenResultEClass.getESuperTypes().add(this.getVerificationExpr());
    andThenResultEClass.getESuperTypes().add(this.getVerificationExpr());
    validationResultEClass.getESuperTypes().add(this.getVerificationResult());
    preconditionResultEClass.getESuperTypes().add(this.getVerificationResult());
    verificationActivityResultEClass.getESuperTypes().add(this.getVerificationResult());

    // Initialize classes and features; add operations and parameters
    initEClass(assuranceEvidenceEClass, AssuranceEvidence.class, "AssuranceEvidence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssuranceEvidence_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AssuranceEvidence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceEvidence_Target(), theAadl2Package.getComponentClassifier(), null, "target", null, 0, 1, AssuranceEvidence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceEvidence_Instance(), theInstancePackage.getInstanceObject(), null, "instance", null, 0, 1, AssuranceEvidence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssuranceEvidence_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AssuranceEvidence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceEvidence_SubAssuranceEvidence(), this.getAssuranceEvidence(), null, "subAssuranceEvidence", null, 0, -1, AssuranceEvidence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceEvidence_ClaimResult(), this.getClaimResult(), null, "claimResult", null, 0, -1, AssuranceEvidence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimResultEClass, ClaimResult.class, "ClaimResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClaimResult_Target(), theReqSpecPackage.getRequirement(), null, "target", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaimResult_Instance(), theInstancePackage.getInstanceObject(), null, "instance", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaimResult_Message(), theEcorePackage.getEString(), "message", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaimResult_SubClaimResult(), this.getClaimResult(), null, "subClaimResult", null, 0, -1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaimResult_VerificationActivityResult(), this.getVerificationExpr(), null, "verificationActivityResult", null, 0, -1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationResultEClass, VerificationResult.class, "VerificationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationResult_ExecutionState(), this.getVerificationExecutionState(), "executionState", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationResult_ResultState(), this.getVerificationResultState(), "resultState", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationResult_Issues(), this.getResultIssue(), null, "issues", null, 0, -1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationResult_ResultReport(), theResultsPackage.getResultReport(), null, "resultReport", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationResult_Message(), theEcorePackage.getEString(), "message", null, 0, 1, VerificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assureResultEClass, AssureResult.class, "AssureResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssureResult_SuccessCount(), theEcorePackage.getEInt(), "successCount", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssureResult_FailCount(), theEcorePackage.getEInt(), "failCount", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssureResult_UnknownCount(), theEcorePackage.getEInt(), "unknownCount", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssureResult_FailthenCount(), theEcorePackage.getEInt(), "failthenCount", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssureResult_AndthenCount(), theEcorePackage.getEInt(), "andthenCount", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssureResult_TbdCount(), theEcorePackage.getEInt(), "tbdCount", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssureResult_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationExprEClass, VerificationExpr.class, "VerificationExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(failThenResultEClass, FailThenResult.class, "FailThenResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFailThenResult_First(), this.getVerificationExpr(), null, "first", null, 0, -1, FailThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFailThenResult_Second(), this.getVerificationExpr(), null, "second", null, 0, -1, FailThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFailThenResult_FailThen(), theEcorePackage.getEBoolean(), "failThen", null, 0, 1, FailThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFailThenResult_UnknownThen(), theEcorePackage.getEBoolean(), "unknownThen", null, 0, 1, FailThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFailThenResult_DidFail(), theEcorePackage.getEBoolean(), "didFail", null, 0, 1, FailThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andThenResultEClass, AndThenResult.class, "AndThenResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndThenResult_First(), this.getVerificationExpr(), null, "first", null, 0, -1, AndThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndThenResult_Second(), this.getVerificationExpr(), null, "second", null, 0, -1, AndThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAndThenResult_DidAndThenFail(), theEcorePackage.getEBoolean(), "didAndThenFail", null, 0, 1, AndThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultIssueEClass, ResultIssue.class, "ResultIssue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultIssue_IssueType(), this.getResultIssueType(), "issueType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_Message(), theEcorePackage.getEString(), "message", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_ExceptionType(), theEcorePackage.getEString(), "exceptionType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Issues(), this.getResultIssue(), null, "issues", null, 0, -1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(validationResultEClass, ValidationResult.class, "ValidationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValidationResult_Target(), theVerifyPackage.getVerificationValidation(), null, "target", null, 0, 1, ValidationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preconditionResultEClass, PreconditionResult.class, "PreconditionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPreconditionResult_Name(), theEcorePackage.getEString(), "name", null, 0, 1, PreconditionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPreconditionResult_Target(), theVerifyPackage.getVerificationPrecondition(), null, "target", null, 0, 1, PreconditionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationActivityResultEClass, VerificationActivityResult.class, "VerificationActivityResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerificationActivityResult_Target(), theVerifyPackage.getVerificationActivity(), null, "target", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_ValidationResult(), this.getVerificationResult(), null, "validationResult", null, 0, -1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_PreconditionResult(), this.getVerificationResult(), null, "preconditionResult", null, 0, -1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(resultIssueTypeEEnum, ResultIssueType.class, "ResultIssueType");
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.ERROR);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.WARNING);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.SUCCESS);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.INFO);

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
