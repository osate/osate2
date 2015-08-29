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

import org.osate.alisa.workbench.alisa.AlisaPackage;

import org.osate.assure.assure.AssuranceCase;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.ElseType;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.ResultIssueType;
import org.osate.assure.assure.ThenResult;
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
  private EClass assuranceCaseEClass = null;

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
  private EClass elseResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thenResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metricsEClass = null;

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
  private EClass preconditionResultEClass = null;

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
  private EClass verificationActivityResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum elseTypeEEnum = null;

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
    AlisaPackage.eINSTANCE.eClass();
    ResultsPackage.eINSTANCE.eClass();

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
  public EReference getAssuranceCase_Target()
  {
    return (EReference)assuranceCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceCase_TargetSystem()
  {
    return (EAttribute)assuranceCaseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssuranceCase_Message()
  {
    return (EAttribute)assuranceCaseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCase_ClaimResult()
  {
    return (EReference)assuranceCaseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssuranceCase_SubAssuranceCase()
  {
    return (EReference)assuranceCaseEClass.getEStructuralFeatures().get(5);
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
  public EAttribute getClaimResult_Message()
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
  public EReference getAssureResult_Metrics()
  {
    return (EReference)assureResultEClass.getEStructuralFeatures().get(0);
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
  public EClass getElseResult()
  {
    return elseResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseResult_First()
  {
    return (EReference)elseResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseResult_Other()
  {
    return (EReference)elseResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseResult_Fail()
  {
    return (EReference)elseResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseResult_Timeout()
  {
    return (EReference)elseResultEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElseResult_DidFail()
  {
    return (EAttribute)elseResultEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThenResult()
  {
    return thenResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThenResult_First()
  {
    return (EReference)thenResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThenResult_Second()
  {
    return (EReference)thenResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getThenResult_DidThenFail()
  {
    return (EAttribute)thenResultEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetrics()
  {
    return metricsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_TbdCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_SuccessCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_FailCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_TimeoutCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_OtherCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_DidelseCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_ThenskipCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_PreconditionfailCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_ValidationfailCount()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetrics_Weight()
  {
    return (EAttribute)metricsEClass.getEStructuralFeatures().get(9);
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
  public EReference getVerificationActivityResult_ConditionResult()
  {
    return (EReference)verificationActivityResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getElseType()
  {
    return elseTypeEEnum;
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
    assuranceCaseEClass = createEClass(ASSURANCE_CASE);
    createEAttribute(assuranceCaseEClass, ASSURANCE_CASE__NAME);
    createEReference(assuranceCaseEClass, ASSURANCE_CASE__TARGET);
    createEAttribute(assuranceCaseEClass, ASSURANCE_CASE__TARGET_SYSTEM);
    createEAttribute(assuranceCaseEClass, ASSURANCE_CASE__MESSAGE);
    createEReference(assuranceCaseEClass, ASSURANCE_CASE__CLAIM_RESULT);
    createEReference(assuranceCaseEClass, ASSURANCE_CASE__SUB_ASSURANCE_CASE);

    claimResultEClass = createEClass(CLAIM_RESULT);
    createEReference(claimResultEClass, CLAIM_RESULT__TARGET);
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
    createEReference(assureResultEClass, ASSURE_RESULT__METRICS);

    verificationExprEClass = createEClass(VERIFICATION_EXPR);

    elseResultEClass = createEClass(ELSE_RESULT);
    createEReference(elseResultEClass, ELSE_RESULT__FIRST);
    createEReference(elseResultEClass, ELSE_RESULT__OTHER);
    createEReference(elseResultEClass, ELSE_RESULT__FAIL);
    createEReference(elseResultEClass, ELSE_RESULT__TIMEOUT);
    createEAttribute(elseResultEClass, ELSE_RESULT__DID_FAIL);

    thenResultEClass = createEClass(THEN_RESULT);
    createEReference(thenResultEClass, THEN_RESULT__FIRST);
    createEReference(thenResultEClass, THEN_RESULT__SECOND);
    createEAttribute(thenResultEClass, THEN_RESULT__DID_THEN_FAIL);

    metricsEClass = createEClass(METRICS);
    createEAttribute(metricsEClass, METRICS__TBD_COUNT);
    createEAttribute(metricsEClass, METRICS__SUCCESS_COUNT);
    createEAttribute(metricsEClass, METRICS__FAIL_COUNT);
    createEAttribute(metricsEClass, METRICS__TIMEOUT_COUNT);
    createEAttribute(metricsEClass, METRICS__OTHER_COUNT);
    createEAttribute(metricsEClass, METRICS__DIDELSE_COUNT);
    createEAttribute(metricsEClass, METRICS__THENSKIP_COUNT);
    createEAttribute(metricsEClass, METRICS__PRECONDITIONFAIL_COUNT);
    createEAttribute(metricsEClass, METRICS__VALIDATIONFAIL_COUNT);
    createEAttribute(metricsEClass, METRICS__WEIGHT);

    resultIssueEClass = createEClass(RESULT_ISSUE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__ISSUE_TYPE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__NAME);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__MESSAGE);
    createEAttribute(resultIssueEClass, RESULT_ISSUE__EXCEPTION_TYPE);
    createEReference(resultIssueEClass, RESULT_ISSUE__TARGET);
    createEReference(resultIssueEClass, RESULT_ISSUE__ISSUES);

    preconditionResultEClass = createEClass(PRECONDITION_RESULT);
    createEReference(preconditionResultEClass, PRECONDITION_RESULT__TARGET);

    validationResultEClass = createEClass(VALIDATION_RESULT);
    createEReference(validationResultEClass, VALIDATION_RESULT__TARGET);

    verificationActivityResultEClass = createEClass(VERIFICATION_ACTIVITY_RESULT);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__TARGET);
    createEReference(verificationActivityResultEClass, VERIFICATION_ACTIVITY_RESULT__CONDITION_RESULT);

    // Create enums
    elseTypeEEnum = createEEnum(ELSE_TYPE);
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
    AlisaPackage theAlisaPackage = (AlisaPackage)EPackage.Registry.INSTANCE.getEPackage(AlisaPackage.eNS_URI);
    ReqSpecPackage theReqSpecPackage = (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);
    ResultsPackage theResultsPackage = (ResultsPackage)EPackage.Registry.INSTANCE.getEPackage(ResultsPackage.eNS_URI);
    VerifyPackage theVerifyPackage = (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    assuranceCaseEClass.getESuperTypes().add(this.getAssureResult());
    claimResultEClass.getESuperTypes().add(this.getAssureResult());
    verificationResultEClass.getESuperTypes().add(this.getAssureResult());
    verificationResultEClass.getESuperTypes().add(this.getVerificationExpr());
    verificationExprEClass.getESuperTypes().add(this.getAssureResult());
    elseResultEClass.getESuperTypes().add(this.getVerificationExpr());
    thenResultEClass.getESuperTypes().add(this.getVerificationExpr());
    preconditionResultEClass.getESuperTypes().add(this.getVerificationResult());
    validationResultEClass.getESuperTypes().add(this.getVerificationResult());
    verificationActivityResultEClass.getESuperTypes().add(this.getVerificationResult());

    // Initialize classes and features; add operations and parameters
    initEClass(assuranceCaseEClass, AssuranceCase.class, "AssuranceCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssuranceCase_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCase_Target(), theAlisaPackage.getAssurancePlan(), null, "target", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssuranceCase_TargetSystem(), theEcorePackage.getEString(), "targetSystem", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssuranceCase_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCase_ClaimResult(), this.getClaimResult(), null, "claimResult", null, 0, -1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssuranceCase_SubAssuranceCase(), this.getAssuranceCase(), null, "subAssuranceCase", null, 0, -1, AssuranceCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimResultEClass, ClaimResult.class, "ClaimResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClaimResult_Target(), theReqSpecPackage.getRequirement(), null, "target", null, 0, 1, ClaimResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
    initEReference(getAssureResult_Metrics(), this.getMetrics(), null, "metrics", null, 0, 1, AssureResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationExprEClass, VerificationExpr.class, "VerificationExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(elseResultEClass, ElseResult.class, "ElseResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElseResult_First(), this.getVerificationExpr(), null, "first", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElseResult_Other(), this.getVerificationExpr(), null, "other", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElseResult_Fail(), this.getVerificationExpr(), null, "fail", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElseResult_Timeout(), this.getVerificationExpr(), null, "timeout", null, 0, -1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getElseResult_DidFail(), this.getElseType(), "didFail", null, 0, 1, ElseResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thenResultEClass, ThenResult.class, "ThenResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThenResult_First(), this.getVerificationExpr(), null, "first", null, 0, -1, ThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThenResult_Second(), this.getVerificationExpr(), null, "second", null, 0, -1, ThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getThenResult_DidThenFail(), theEcorePackage.getEBoolean(), "didThenFail", null, 0, 1, ThenResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(metricsEClass, Metrics.class, "Metrics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMetrics_TbdCount(), theEcorePackage.getEInt(), "tbdCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_SuccessCount(), theEcorePackage.getEInt(), "successCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_FailCount(), theEcorePackage.getEInt(), "failCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_TimeoutCount(), theEcorePackage.getEInt(), "timeoutCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_OtherCount(), theEcorePackage.getEInt(), "otherCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_DidelseCount(), theEcorePackage.getEInt(), "didelseCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_ThenskipCount(), theEcorePackage.getEInt(), "thenskipCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_PreconditionfailCount(), theEcorePackage.getEInt(), "preconditionfailCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_ValidationfailCount(), theEcorePackage.getEInt(), "validationfailCount", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetrics_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, Metrics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultIssueEClass, ResultIssue.class, "ResultIssue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResultIssue_IssueType(), this.getResultIssueType(), "issueType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_Message(), theEcorePackage.getEString(), "message", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResultIssue_ExceptionType(), theEcorePackage.getEString(), "exceptionType", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Target(), theEcorePackage.getEObject(), null, "target", null, 0, 1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getResultIssue_Issues(), this.getResultIssue(), null, "issues", null, 0, -1, ResultIssue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preconditionResultEClass, PreconditionResult.class, "PreconditionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPreconditionResult_Target(), theVerifyPackage.getVerificationCondition(), null, "target", null, 0, 1, PreconditionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(validationResultEClass, ValidationResult.class, "ValidationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValidationResult_Target(), theVerifyPackage.getVerificationCondition(), null, "target", null, 0, 1, ValidationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationActivityResultEClass, VerificationActivityResult.class, "VerificationActivityResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerificationActivityResult_Target(), theVerifyPackage.getVerificationActivity(), null, "target", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivityResult_ConditionResult(), this.getVerificationResult(), null, "conditionResult", null, 0, 1, VerificationActivityResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(elseTypeEEnum, ElseType.class, "ElseType");
    addEEnumLiteral(elseTypeEEnum, ElseType.FAIL);
    addEEnumLiteral(elseTypeEEnum, ElseType.TIMEOUT);
    addEEnumLiteral(elseTypeEEnum, ElseType.OTHER);

    initEEnum(resultIssueTypeEEnum, ResultIssueType.class, "ResultIssueType");
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.ERROR);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.WARNING);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.SUCCESS);
    addEEnumLiteral(resultIssueTypeEEnum, ResultIssueType.INFO);

    initEEnum(verificationResultStateEEnum, VerificationResultState.class, "VerificationResultState");
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.TBD);
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.SUCCESS);
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.FAIL);
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.OTHER);
    addEEnumLiteral(verificationResultStateEEnum, VerificationResultState.TIMEOUT);

    initEEnum(verificationExecutionStateEEnum, VerificationExecutionState.class, "VerificationExecutionState");
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.TODO);
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.RUNNING);
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.REDO);
    addEEnumLiteral(verificationExecutionStateEEnum, VerificationExecutionState.COMPLETED);

    // Create resource
    createResource(eNS_URI);
  }

} //AssurePackageImpl
