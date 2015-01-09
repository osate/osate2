/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssureFactory
 * @model kind="package"
 * @generated
 */
public interface AssurePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "assure";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/assure/Assure";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "assure";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AssurePackage eINSTANCE = org.osate.assure.assure.impl.AssurePackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AssuranceResultImpl <em>Assurance Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AssuranceResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceResult()
   * @generated
   */
  int ASSURANCE_RESULT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_RESULT__NAME = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_RESULT__TARGET = 1;

  /**
   * The number of structural features of the '<em>Assurance Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_RESULT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.CaseResultImpl <em>Case Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.CaseResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getCaseResult()
   * @generated
   */
  int CASE_RESULT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__NAME = ASSURANCE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__TARGET = ASSURANCE_RESULT__TARGET;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__RESULT = ASSURANCE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sub Case Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__SUB_CASE_RESULT = ASSURANCE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__CLAIM_RESULT = ASSURANCE_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Case Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT_FEATURE_COUNT = ASSURANCE_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationResultImpl <em>Verification Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResult()
   * @generated
   */
  int VERIFICATION_RESULT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__NAME = ASSURANCE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__TARGET = ASSURANCE_RESULT__TARGET;

  /**
   * The feature id for the '<em><b>Verification Activity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__VERIFICATION_ACTIVITY = ASSURANCE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__TITLE = ASSURANCE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__DESCRIPTION = ASSURANCE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__DATE = ASSURANCE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__STATE = ASSURANCE_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__STATUS = ASSURANCE_RESULT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Assumption Verification Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT = ASSURANCE_RESULT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Verification Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT_FEATURE_COUNT = ASSURANCE_RESULT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ClaimResultImpl <em>Claim Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ClaimResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getClaimResult()
   * @generated
   */
  int CLAIM_RESULT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__NAME = ASSURANCE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__TARGET = ASSURANCE_RESULT__TARGET;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__REQUIREMENT = ASSURANCE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__RESULT = ASSURANCE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Sub Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__SUB_CLAIM_RESULT = ASSURANCE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Verification Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__VERIFICATION_RESULT = ASSURANCE_RESULT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Claim Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT_FEATURE_COUNT = ASSURANCE_RESULT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AggregateResultDataImpl <em>Aggregate Result Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AggregateResultDataImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAggregateResultData()
   * @generated
   */
  int AGGREGATE_RESULT_DATA = 3;

  /**
   * The feature id for the '<em><b>Pass Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT_DATA__PASS_COUNT = 0;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT_DATA__FAIL_COUNT = 1;

  /**
   * The feature id for the '<em><b>Neutral Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT_DATA__NEUTRAL_COUNT = 2;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT_DATA__UNKNOWN_COUNT = 3;

  /**
   * The number of structural features of the '<em>Aggregate Result Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT_DATA_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationResultState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultState()
   * @generated
   */
  int VERIFICATION_RESULT_STATE = 5;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationResultStatus <em>Verification Result Status</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationResultStatus
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultStatus()
   * @generated
   */
  int VERIFICATION_RESULT_STATUS = 6;


  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.CaseResult <em>Case Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case Result</em>'.
   * @see org.osate.assure.assure.CaseResult
   * @generated
   */
  EClass getCaseResult();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.CaseResult#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see org.osate.assure.assure.CaseResult#getResult()
   * @see #getCaseResult()
   * @generated
   */
  EReference getCaseResult_Result();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.CaseResult#getSubCaseResult <em>Sub Case Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Case Result</em>'.
   * @see org.osate.assure.assure.CaseResult#getSubCaseResult()
   * @see #getCaseResult()
   * @generated
   */
  EReference getCaseResult_SubCaseResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.CaseResult#getClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.CaseResult#getClaimResult()
   * @see #getCaseResult()
   * @generated
   */
  EReference getCaseResult_ClaimResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationResult <em>Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Result</em>'.
   * @see org.osate.assure.assure.VerificationResult
   * @generated
   */
  EClass getVerificationResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.VerificationResult#getVerificationActivity <em>Verification Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Verification Activity</em>'.
   * @see org.osate.assure.assure.VerificationResult#getVerificationActivity()
   * @see #getVerificationResult()
   * @generated
   */
  EReference getVerificationResult_VerificationActivity();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.assure.assure.VerificationResult#getTitle()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Title();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.osate.assure.assure.VerificationResult#getDescription()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Description();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getDate <em>Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date</em>'.
   * @see org.osate.assure.assure.VerificationResult#getDate()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Date();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State</em>'.
   * @see org.osate.assure.assure.VerificationResult#getState()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_State();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getStatus <em>Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Status</em>'.
   * @see org.osate.assure.assure.VerificationResult#getStatus()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Status();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationResult#getAssumptionVerificationResult <em>Assumption Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assumption Verification Result</em>'.
   * @see org.osate.assure.assure.VerificationResult#getAssumptionVerificationResult()
   * @see #getVerificationResult()
   * @generated
   */
  EReference getVerificationResult_AssumptionVerificationResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.ClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.ClaimResult
   * @generated
   */
  EClass getClaimResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ClaimResult#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Requirement</em>'.
   * @see org.osate.assure.assure.ClaimResult#getRequirement()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_Requirement();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.ClaimResult#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see org.osate.assure.assure.ClaimResult#getResult()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_Result();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ClaimResult#getSubClaimResult <em>Sub Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Claim Result</em>'.
   * @see org.osate.assure.assure.ClaimResult#getSubClaimResult()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_SubClaimResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ClaimResult#getVerificationResult <em>Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Verification Result</em>'.
   * @see org.osate.assure.assure.ClaimResult#getVerificationResult()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_VerificationResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AggregateResultData <em>Aggregate Result Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregate Result Data</em>'.
   * @see org.osate.assure.assure.AggregateResultData
   * @generated
   */
  EClass getAggregateResultData();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResultData#getPassCount <em>Pass Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pass Count</em>'.
   * @see org.osate.assure.assure.AggregateResultData#getPassCount()
   * @see #getAggregateResultData()
   * @generated
   */
  EAttribute getAggregateResultData_PassCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResultData#getFailCount <em>Fail Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail Count</em>'.
   * @see org.osate.assure.assure.AggregateResultData#getFailCount()
   * @see #getAggregateResultData()
   * @generated
   */
  EAttribute getAggregateResultData_FailCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResultData#getNeutralCount <em>Neutral Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Neutral Count</em>'.
   * @see org.osate.assure.assure.AggregateResultData#getNeutralCount()
   * @see #getAggregateResultData()
   * @generated
   */
  EAttribute getAggregateResultData_NeutralCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResultData#getUnknownCount <em>Unknown Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unknown Count</em>'.
   * @see org.osate.assure.assure.AggregateResultData#getUnknownCount()
   * @see #getAggregateResultData()
   * @generated
   */
  EAttribute getAggregateResultData_UnknownCount();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AssuranceResult <em>Assurance Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assurance Result</em>'.
   * @see org.osate.assure.assure.AssuranceResult
   * @generated
   */
  EClass getAssuranceResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssuranceResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.AssuranceResult#getName()
   * @see #getAssuranceResult()
   * @generated
   */
  EAttribute getAssuranceResult_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.AssuranceResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.AssuranceResult#getTarget()
   * @see #getAssuranceResult()
   * @generated
   */
  EReference getAssuranceResult_Target();

  /**
   * Returns the meta object for enum '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Verification Result State</em>'.
   * @see org.osate.assure.assure.VerificationResultState
   * @generated
   */
  EEnum getVerificationResultState();

  /**
   * Returns the meta object for enum '{@link org.osate.assure.assure.VerificationResultStatus <em>Verification Result Status</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Verification Result Status</em>'.
   * @see org.osate.assure.assure.VerificationResultStatus
   * @generated
   */
  EEnum getVerificationResultStatus();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AssureFactory getAssureFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.CaseResultImpl <em>Case Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.CaseResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getCaseResult()
     * @generated
     */
    EClass CASE_RESULT = eINSTANCE.getCaseResult();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__RESULT = eINSTANCE.getCaseResult_Result();

    /**
     * The meta object literal for the '<em><b>Sub Case Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__SUB_CASE_RESULT = eINSTANCE.getCaseResult_SubCaseResult();

    /**
     * The meta object literal for the '<em><b>Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__CLAIM_RESULT = eINSTANCE.getCaseResult_ClaimResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationResultImpl <em>Verification Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResult()
     * @generated
     */
    EClass VERIFICATION_RESULT = eINSTANCE.getVerificationResult();

    /**
     * The meta object literal for the '<em><b>Verification Activity</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_RESULT__VERIFICATION_ACTIVITY = eINSTANCE.getVerificationResult_VerificationActivity();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__TITLE = eINSTANCE.getVerificationResult_Title();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__DESCRIPTION = eINSTANCE.getVerificationResult_Description();

    /**
     * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__DATE = eINSTANCE.getVerificationResult_Date();

    /**
     * The meta object literal for the '<em><b>State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__STATE = eINSTANCE.getVerificationResult_State();

    /**
     * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__STATUS = eINSTANCE.getVerificationResult_Status();

    /**
     * The meta object literal for the '<em><b>Assumption Verification Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_RESULT__ASSUMPTION_VERIFICATION_RESULT = eINSTANCE.getVerificationResult_AssumptionVerificationResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ClaimResultImpl <em>Claim Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ClaimResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getClaimResult()
     * @generated
     */
    EClass CLAIM_RESULT = eINSTANCE.getClaimResult();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__REQUIREMENT = eINSTANCE.getClaimResult_Requirement();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__RESULT = eINSTANCE.getClaimResult_Result();

    /**
     * The meta object literal for the '<em><b>Sub Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__SUB_CLAIM_RESULT = eINSTANCE.getClaimResult_SubClaimResult();

    /**
     * The meta object literal for the '<em><b>Verification Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__VERIFICATION_RESULT = eINSTANCE.getClaimResult_VerificationResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AggregateResultDataImpl <em>Aggregate Result Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AggregateResultDataImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAggregateResultData()
     * @generated
     */
    EClass AGGREGATE_RESULT_DATA = eINSTANCE.getAggregateResultData();

    /**
     * The meta object literal for the '<em><b>Pass Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT_DATA__PASS_COUNT = eINSTANCE.getAggregateResultData_PassCount();

    /**
     * The meta object literal for the '<em><b>Fail Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT_DATA__FAIL_COUNT = eINSTANCE.getAggregateResultData_FailCount();

    /**
     * The meta object literal for the '<em><b>Neutral Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT_DATA__NEUTRAL_COUNT = eINSTANCE.getAggregateResultData_NeutralCount();

    /**
     * The meta object literal for the '<em><b>Unknown Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT_DATA__UNKNOWN_COUNT = eINSTANCE.getAggregateResultData_UnknownCount();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AssuranceResultImpl <em>Assurance Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AssuranceResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceResult()
     * @generated
     */
    EClass ASSURANCE_RESULT = eINSTANCE.getAssuranceResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_RESULT__NAME = eINSTANCE.getAssuranceResult_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_RESULT__TARGET = eINSTANCE.getAssuranceResult_Target();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.VerificationResultState
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultState()
     * @generated
     */
    EEnum VERIFICATION_RESULT_STATE = eINSTANCE.getVerificationResultState();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.VerificationResultStatus <em>Verification Result Status</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.VerificationResultStatus
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultStatus()
     * @generated
     */
    EEnum VERIFICATION_RESULT_STATUS = eINSTANCE.getVerificationResultStatus();

  }

} //AssurePackage
