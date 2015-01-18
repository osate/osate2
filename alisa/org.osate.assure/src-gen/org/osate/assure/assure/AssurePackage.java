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
   * The meta object id for the '{@link org.osate.assure.assure.impl.AggregateResultImpl <em>Aggregate Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AggregateResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAggregateResult()
   * @generated
   */
  int AGGREGATE_RESULT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT__NAME = 0;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT__FAIL_COUNT = 1;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT__UNKNOWN_COUNT = 2;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT__TBD_COUNT = 3;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT__WEIGHT = 4;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT__SUCESS_MSG = 5;

  /**
   * The number of structural features of the '<em>Aggregate Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATE_RESULT_FEATURE_COUNT = 6;

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
  int CASE_RESULT__NAME = AGGREGATE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__FAIL_COUNT = AGGREGATE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__UNKNOWN_COUNT = AGGREGATE_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__TBD_COUNT = AGGREGATE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__WEIGHT = AGGREGATE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__SUCESS_MSG = AGGREGATE_RESULT__SUCESS_MSG;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__TARGET = AGGREGATE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Instance URI</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__INSTANCE_URI = AGGREGATE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Pass Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__PASS_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Sub Case Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__SUB_CASE_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__CLAIM_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Hazard Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__HAZARD_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Case Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT_FEATURE_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ClaimResultImpl <em>Claim Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ClaimResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getClaimResult()
   * @generated
   */
  int CLAIM_RESULT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__NAME = AGGREGATE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__FAIL_COUNT = AGGREGATE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__UNKNOWN_COUNT = AGGREGATE_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__TBD_COUNT = AGGREGATE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__WEIGHT = AGGREGATE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__SUCESS_MSG = AGGREGATE_RESULT__SUCESS_MSG;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__TARGET = AGGREGATE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__SUCCESS_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Sub Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__SUB_CLAIM_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Verification Activity Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Claim Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT_FEATURE_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.HazardResultImpl <em>Hazard Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.HazardResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getHazardResult()
   * @generated
   */
  int HAZARD_RESULT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__NAME = AGGREGATE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__FAIL_COUNT = AGGREGATE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__UNKNOWN_COUNT = AGGREGATE_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__TBD_COUNT = AGGREGATE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__WEIGHT = AGGREGATE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__SUCESS_MSG = AGGREGATE_RESULT__SUCESS_MSG;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__TARGET = AGGREGATE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pass Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__PASS_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT__CLAIM_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Hazard Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_RESULT_FEATURE_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AssumptionResultImpl <em>Assumption Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AssumptionResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssumptionResult()
   * @generated
   */
  int ASSUMPTION_RESULT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__NAME = AGGREGATE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__FAIL_COUNT = AGGREGATE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__UNKNOWN_COUNT = AGGREGATE_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__TBD_COUNT = AGGREGATE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__WEIGHT = AGGREGATE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__SUCESS_MSG = AGGREGATE_RESULT__SUCESS_MSG;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__TARGET = AGGREGATE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__SUCCESS_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Verification Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__VERIFICATION_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assumption Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT_FEATURE_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.PreconditionResultImpl <em>Precondition Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.PreconditionResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getPreconditionResult()
   * @generated
   */
  int PRECONDITION_RESULT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__NAME = AGGREGATE_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__FAIL_COUNT = AGGREGATE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__UNKNOWN_COUNT = AGGREGATE_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__TBD_COUNT = AGGREGATE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__WEIGHT = AGGREGATE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__SUCESS_MSG = AGGREGATE_RESULT__SUCESS_MSG;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__TARGET = AGGREGATE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__SUCCESS_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Verification Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__VERIFICATION_RESULT = AGGREGATE_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Precondition Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT_FEATURE_COUNT = AGGREGATE_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
   * @generated
   */
  int VERIFICATION_ACTIVITY_RESULT = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__NAME = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__TARGET = 1;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE = 2;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__RESULT = 3;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__WEIGHT = 4;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG = 5;

  /**
   * The feature id for the '<em><b>Assumption Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT = 6;

  /**
   * The feature id for the '<em><b>Precondition Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = 7;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__FIRST = 8;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__SECOND = 9;

  /**
   * The number of structural features of the '<em>Verification Activity Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationResultImpl <em>Verification Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResult()
   * @generated
   */
  int VERIFICATION_RESULT = 7;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__RESULT_STATE = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__TYPE = 1;

  /**
   * The feature id for the '<em><b>Fail Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__FAIL_MSG = 2;

  /**
   * The feature id for the '<em><b>Fail Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__FAIL_TARGET = 3;

  /**
   * The number of structural features of the '<em>Verification Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.FailThenResultImpl <em>Fail Then Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.FailThenResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getFailThenResult()
   * @generated
   */
  int FAIL_THEN_RESULT = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__NAME = VERIFICATION_ACTIVITY_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__TARGET = VERIFICATION_ACTIVITY_RESULT__TARGET;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__EXECUTION_STATE = VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__RESULT = VERIFICATION_ACTIVITY_RESULT__RESULT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__WEIGHT = VERIFICATION_ACTIVITY_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__SUCESS_MSG = VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG;

  /**
   * The feature id for the '<em><b>Assumption Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__ASSUMPTION_RESULT = VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT;

  /**
   * The feature id for the '<em><b>Precondition Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__PRECONDITION_RESULT = VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__FIRST = VERIFICATION_ACTIVITY_RESULT__FIRST;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__SECOND = VERIFICATION_ACTIVITY_RESULT__SECOND;

  /**
   * The number of structural features of the '<em>Fail Then Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT_FEATURE_COUNT = VERIFICATION_ACTIVITY_RESULT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AndThenResultImpl <em>And Then Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AndThenResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAndThenResult()
   * @generated
   */
  int AND_THEN_RESULT = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__NAME = VERIFICATION_ACTIVITY_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__TARGET = VERIFICATION_ACTIVITY_RESULT__TARGET;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__EXECUTION_STATE = VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__RESULT = VERIFICATION_ACTIVITY_RESULT__RESULT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__WEIGHT = VERIFICATION_ACTIVITY_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__SUCESS_MSG = VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG;

  /**
   * The feature id for the '<em><b>Assumption Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__ASSUMPTION_RESULT = VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT;

  /**
   * The feature id for the '<em><b>Precondition Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__PRECONDITION_RESULT = VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__FIRST = VERIFICATION_ACTIVITY_RESULT__FIRST;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__SECOND = VERIFICATION_ACTIVITY_RESULT__SECOND;

  /**
   * The number of structural features of the '<em>And Then Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT_FEATURE_COUNT = VERIFICATION_ACTIVITY_RESULT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationResultState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultState()
   * @generated
   */
  int VERIFICATION_RESULT_STATE = 10;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExecutionState()
   * @generated
   */
  int VERIFICATION_EXECUTION_STATE = 11;


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
   * Returns the meta object for the reference '{@link org.osate.assure.assure.CaseResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.CaseResult#getTarget()
   * @see #getCaseResult()
   * @generated
   */
  EReference getCaseResult_Target();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.CaseResult#getInstanceURI <em>Instance URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance URI</em>'.
   * @see org.osate.assure.assure.CaseResult#getInstanceURI()
   * @see #getCaseResult()
   * @generated
   */
  EReference getCaseResult_InstanceURI();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.CaseResult#getPassCount <em>Pass Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pass Count</em>'.
   * @see org.osate.assure.assure.CaseResult#getPassCount()
   * @see #getCaseResult()
   * @generated
   */
  EAttribute getCaseResult_PassCount();

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
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.CaseResult#getHazardResult <em>Hazard Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Hazard Result</em>'.
   * @see org.osate.assure.assure.CaseResult#getHazardResult()
   * @see #getCaseResult()
   * @generated
   */
  EReference getCaseResult_HazardResult();

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
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ClaimResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.ClaimResult#getTarget()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ClaimResult#getSuccessCount <em>Success Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Success Count</em>'.
   * @see org.osate.assure.assure.ClaimResult#getSuccessCount()
   * @see #getClaimResult()
   * @generated
   */
  EAttribute getClaimResult_SuccessCount();

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
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ClaimResult#getVerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Verification Activity Result</em>'.
   * @see org.osate.assure.assure.ClaimResult#getVerificationActivityResult()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_VerificationActivityResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.HazardResult <em>Hazard Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hazard Result</em>'.
   * @see org.osate.assure.assure.HazardResult
   * @generated
   */
  EClass getHazardResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.HazardResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.HazardResult#getTarget()
   * @see #getHazardResult()
   * @generated
   */
  EReference getHazardResult_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.HazardResult#getPassCount <em>Pass Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pass Count</em>'.
   * @see org.osate.assure.assure.HazardResult#getPassCount()
   * @see #getHazardResult()
   * @generated
   */
  EAttribute getHazardResult_PassCount();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.HazardResult#getClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.HazardResult#getClaimResult()
   * @see #getHazardResult()
   * @generated
   */
  EReference getHazardResult_ClaimResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AggregateResult <em>Aggregate Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregate Result</em>'.
   * @see org.osate.assure.assure.AggregateResult
   * @generated
   */
  EClass getAggregateResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.AggregateResult#getName()
   * @see #getAggregateResult()
   * @generated
   */
  EAttribute getAggregateResult_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResult#getFailCount <em>Fail Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail Count</em>'.
   * @see org.osate.assure.assure.AggregateResult#getFailCount()
   * @see #getAggregateResult()
   * @generated
   */
  EAttribute getAggregateResult_FailCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResult#getUnknownCount <em>Unknown Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unknown Count</em>'.
   * @see org.osate.assure.assure.AggregateResult#getUnknownCount()
   * @see #getAggregateResult()
   * @generated
   */
  EAttribute getAggregateResult_UnknownCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResult#getTbdCount <em>Tbd Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tbd Count</em>'.
   * @see org.osate.assure.assure.AggregateResult#getTbdCount()
   * @see #getAggregateResult()
   * @generated
   */
  EAttribute getAggregateResult_TbdCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResult#getWeight <em>Weight</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weight</em>'.
   * @see org.osate.assure.assure.AggregateResult#getWeight()
   * @see #getAggregateResult()
   * @generated
   */
  EAttribute getAggregateResult_Weight();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AggregateResult#getSucessMsg <em>Sucess Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sucess Msg</em>'.
   * @see org.osate.assure.assure.AggregateResult#getSucessMsg()
   * @see #getAggregateResult()
   * @generated
   */
  EAttribute getAggregateResult_SucessMsg();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AssumptionResult <em>Assumption Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assumption Result</em>'.
   * @see org.osate.assure.assure.AssumptionResult
   * @generated
   */
  EClass getAssumptionResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.AssumptionResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.AssumptionResult#getTarget()
   * @see #getAssumptionResult()
   * @generated
   */
  EReference getAssumptionResult_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssumptionResult#getSuccessCount <em>Success Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Success Count</em>'.
   * @see org.osate.assure.assure.AssumptionResult#getSuccessCount()
   * @see #getAssumptionResult()
   * @generated
   */
  EAttribute getAssumptionResult_SuccessCount();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AssumptionResult#getVerificationResult <em>Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Verification Result</em>'.
   * @see org.osate.assure.assure.AssumptionResult#getVerificationResult()
   * @see #getAssumptionResult()
   * @generated
   */
  EReference getAssumptionResult_VerificationResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.PreconditionResult <em>Precondition Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Precondition Result</em>'.
   * @see org.osate.assure.assure.PreconditionResult
   * @generated
   */
  EClass getPreconditionResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.PreconditionResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.PreconditionResult#getTarget()
   * @see #getPreconditionResult()
   * @generated
   */
  EReference getPreconditionResult_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.PreconditionResult#getSuccessCount <em>Success Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Success Count</em>'.
   * @see org.osate.assure.assure.PreconditionResult#getSuccessCount()
   * @see #getPreconditionResult()
   * @generated
   */
  EAttribute getPreconditionResult_SuccessCount();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.PreconditionResult#getVerificationResult <em>Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Verification Result</em>'.
   * @see org.osate.assure.assure.PreconditionResult#getVerificationResult()
   * @see #getPreconditionResult()
   * @generated
   */
  EReference getPreconditionResult_VerificationResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Activity Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult
   * @generated
   */
  EClass getVerificationActivityResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationActivityResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getName()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EAttribute getVerificationActivityResult_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.VerificationActivityResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getTarget()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationActivityResult#getExecutionState <em>Execution State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Execution State</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getExecutionState()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EAttribute getVerificationActivityResult_ExecutionState();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.assure.assure.VerificationActivityResult#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getResult()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_Result();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationActivityResult#getWeight <em>Weight</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weight</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getWeight()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EAttribute getVerificationActivityResult_Weight();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationActivityResult#getSucessMsg <em>Sucess Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sucess Msg</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getSucessMsg()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EAttribute getVerificationActivityResult_SucessMsg();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationActivityResult#getAssumptionResult <em>Assumption Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assumption Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getAssumptionResult()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_AssumptionResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationActivityResult#getPreconditionResult <em>Precondition Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Precondition Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getPreconditionResult()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_PreconditionResult();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationActivityResult#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>First</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getFirst()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_First();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationActivityResult#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Second</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getSecond()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_Second();

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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getResultState <em>Result State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Result State</em>'.
   * @see org.osate.assure.assure.VerificationResult#getResultState()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_ResultState();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.osate.assure.assure.VerificationResult#getType()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Type();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getFailMsg <em>Fail Msg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail Msg</em>'.
   * @see org.osate.assure.assure.VerificationResult#getFailMsg()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_FailMsg();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.VerificationResult#getFailTarget <em>Fail Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Fail Target</em>'.
   * @see org.osate.assure.assure.VerificationResult#getFailTarget()
   * @see #getVerificationResult()
   * @generated
   */
  EReference getVerificationResult_FailTarget();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.FailThenResult <em>Fail Then Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fail Then Result</em>'.
   * @see org.osate.assure.assure.FailThenResult
   * @generated
   */
  EClass getFailThenResult();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AndThenResult <em>And Then Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Then Result</em>'.
   * @see org.osate.assure.assure.AndThenResult
   * @generated
   */
  EClass getAndThenResult();

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
   * Returns the meta object for enum '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Verification Execution State</em>'.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @generated
   */
  EEnum getVerificationExecutionState();

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
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__TARGET = eINSTANCE.getCaseResult_Target();

    /**
     * The meta object literal for the '<em><b>Instance URI</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__INSTANCE_URI = eINSTANCE.getCaseResult_InstanceURI();

    /**
     * The meta object literal for the '<em><b>Pass Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_RESULT__PASS_COUNT = eINSTANCE.getCaseResult_PassCount();

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
     * The meta object literal for the '<em><b>Hazard Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__HAZARD_RESULT = eINSTANCE.getCaseResult_HazardResult();

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
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__TARGET = eINSTANCE.getClaimResult_Target();

    /**
     * The meta object literal for the '<em><b>Success Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM_RESULT__SUCCESS_COUNT = eINSTANCE.getClaimResult_SuccessCount();

    /**
     * The meta object literal for the '<em><b>Sub Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__SUB_CLAIM_RESULT = eINSTANCE.getClaimResult_SubClaimResult();

    /**
     * The meta object literal for the '<em><b>Verification Activity Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getClaimResult_VerificationActivityResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.HazardResultImpl <em>Hazard Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.HazardResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getHazardResult()
     * @generated
     */
    EClass HAZARD_RESULT = eINSTANCE.getHazardResult();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARD_RESULT__TARGET = eINSTANCE.getHazardResult_Target();

    /**
     * The meta object literal for the '<em><b>Pass Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAZARD_RESULT__PASS_COUNT = eINSTANCE.getHazardResult_PassCount();

    /**
     * The meta object literal for the '<em><b>Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARD_RESULT__CLAIM_RESULT = eINSTANCE.getHazardResult_ClaimResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AggregateResultImpl <em>Aggregate Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AggregateResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAggregateResult()
     * @generated
     */
    EClass AGGREGATE_RESULT = eINSTANCE.getAggregateResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT__NAME = eINSTANCE.getAggregateResult_Name();

    /**
     * The meta object literal for the '<em><b>Fail Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT__FAIL_COUNT = eINSTANCE.getAggregateResult_FailCount();

    /**
     * The meta object literal for the '<em><b>Unknown Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT__UNKNOWN_COUNT = eINSTANCE.getAggregateResult_UnknownCount();

    /**
     * The meta object literal for the '<em><b>Tbd Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT__TBD_COUNT = eINSTANCE.getAggregateResult_TbdCount();

    /**
     * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT__WEIGHT = eINSTANCE.getAggregateResult_Weight();

    /**
     * The meta object literal for the '<em><b>Sucess Msg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AGGREGATE_RESULT__SUCESS_MSG = eINSTANCE.getAggregateResult_SucessMsg();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AssumptionResultImpl <em>Assumption Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AssumptionResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssumptionResult()
     * @generated
     */
    EClass ASSUMPTION_RESULT = eINSTANCE.getAssumptionResult();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSUMPTION_RESULT__TARGET = eINSTANCE.getAssumptionResult_Target();

    /**
     * The meta object literal for the '<em><b>Success Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSUMPTION_RESULT__SUCCESS_COUNT = eINSTANCE.getAssumptionResult_SuccessCount();

    /**
     * The meta object literal for the '<em><b>Verification Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSUMPTION_RESULT__VERIFICATION_RESULT = eINSTANCE.getAssumptionResult_VerificationResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.PreconditionResultImpl <em>Precondition Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.PreconditionResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getPreconditionResult()
     * @generated
     */
    EClass PRECONDITION_RESULT = eINSTANCE.getPreconditionResult();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRECONDITION_RESULT__TARGET = eINSTANCE.getPreconditionResult_Target();

    /**
     * The meta object literal for the '<em><b>Success Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRECONDITION_RESULT__SUCCESS_COUNT = eINSTANCE.getPreconditionResult_SuccessCount();

    /**
     * The meta object literal for the '<em><b>Verification Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRECONDITION_RESULT__VERIFICATION_RESULT = eINSTANCE.getPreconditionResult_VerificationResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
     * @generated
     */
    EClass VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getVerificationActivityResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY_RESULT__NAME = eINSTANCE.getVerificationActivityResult_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__TARGET = eINSTANCE.getVerificationActivityResult_Target();

    /**
     * The meta object literal for the '<em><b>Execution State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE = eINSTANCE.getVerificationActivityResult_ExecutionState();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__RESULT = eINSTANCE.getVerificationActivityResult_Result();

    /**
     * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY_RESULT__WEIGHT = eINSTANCE.getVerificationActivityResult_Weight();

    /**
     * The meta object literal for the '<em><b>Sucess Msg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY_RESULT__SUCESS_MSG = eINSTANCE.getVerificationActivityResult_SucessMsg();

    /**
     * The meta object literal for the '<em><b>Assumption Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT = eINSTANCE.getVerificationActivityResult_AssumptionResult();

    /**
     * The meta object literal for the '<em><b>Precondition Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = eINSTANCE.getVerificationActivityResult_PreconditionResult();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__FIRST = eINSTANCE.getVerificationActivityResult_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__SECOND = eINSTANCE.getVerificationActivityResult_Second();

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
     * The meta object literal for the '<em><b>Result State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__RESULT_STATE = eINSTANCE.getVerificationResult_ResultState();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__TYPE = eINSTANCE.getVerificationResult_Type();

    /**
     * The meta object literal for the '<em><b>Fail Msg</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__FAIL_MSG = eINSTANCE.getVerificationResult_FailMsg();

    /**
     * The meta object literal for the '<em><b>Fail Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_RESULT__FAIL_TARGET = eINSTANCE.getVerificationResult_FailTarget();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.FailThenResultImpl <em>Fail Then Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.FailThenResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getFailThenResult()
     * @generated
     */
    EClass FAIL_THEN_RESULT = eINSTANCE.getFailThenResult();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AndThenResultImpl <em>And Then Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AndThenResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAndThenResult()
     * @generated
     */
    EClass AND_THEN_RESULT = eINSTANCE.getAndThenResult();

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
     * The meta object literal for the '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.VerificationExecutionState
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExecutionState()
     * @generated
     */
    EEnum VERIFICATION_EXECUTION_STATE = eINSTANCE.getVerificationExecutionState();

  }

} //AssurePackage
