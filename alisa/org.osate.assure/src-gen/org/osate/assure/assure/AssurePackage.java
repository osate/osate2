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
   * The meta object id for the '{@link org.osate.assure.assure.impl.AssureResultImpl <em>Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AssureResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssureResult()
   * @generated
   */
  int ASSURE_RESULT = 5;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__SUCCESS_COUNT = 0;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__FAIL_COUNT = 1;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__ERROR_COUNT = 2;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__FAILTHEN_COUNT = 3;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__ANDTHEN_COUNT = 4;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__TBD_COUNT = 5;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__WEIGHT = 6;

  /**
   * The number of structural features of the '<em>Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT_FEATURE_COUNT = 7;

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
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__SUCCESS_COUNT = ASSURE_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__FAIL_COUNT = ASSURE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__ERROR_COUNT = ASSURE_RESULT__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__FAILTHEN_COUNT = ASSURE_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__ANDTHEN_COUNT = ASSURE_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__TBD_COUNT = ASSURE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__WEIGHT = ASSURE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__TARGET = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__INSTANCE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Sub Case Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__SUB_CASE_RESULT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT__CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Case Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 6;

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
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__SUCCESS_COUNT = ASSURE_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__FAIL_COUNT = ASSURE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__ERROR_COUNT = ASSURE_RESULT__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__FAILTHEN_COUNT = ASSURE_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__ANDTHEN_COUNT = ASSURE_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__TBD_COUNT = ASSURE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__WEIGHT = ASSURE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__TARGET = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__INSTANCE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Sub Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__SUB_CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Verification Activity Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT = ASSURE_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Claim Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AssumptionResultImpl <em>Assumption Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AssumptionResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssumptionResult()
   * @generated
   */
  int ASSUMPTION_RESULT = 2;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__SUCCESS_COUNT = ASSURE_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__FAIL_COUNT = ASSURE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__ERROR_COUNT = ASSURE_RESULT__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__FAILTHEN_COUNT = ASSURE_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__ANDTHEN_COUNT = ASSURE_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__TBD_COUNT = ASSURE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__WEIGHT = ASSURE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__TARGET = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Verification Activity Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Assumption Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSUMPTION_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.PreconditionResultImpl <em>Precondition Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.PreconditionResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getPreconditionResult()
   * @generated
   */
  int PRECONDITION_RESULT = 3;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__SUCCESS_COUNT = ASSURE_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__FAIL_COUNT = ASSURE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__ERROR_COUNT = ASSURE_RESULT__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__FAILTHEN_COUNT = ASSURE_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__ANDTHEN_COUNT = ASSURE_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__TBD_COUNT = ASSURE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__WEIGHT = ASSURE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__TARGET = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Verification Activity Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__VERIFICATION_ACTIVITY_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Precondition Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationExprImpl <em>Verification Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationExprImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExpr()
   * @generated
   */
  int VERIFICATION_EXPR = 6;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__SUCCESS_COUNT = ASSURE_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__FAIL_COUNT = ASSURE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__ERROR_COUNT = ASSURE_RESULT__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__FAILTHEN_COUNT = ASSURE_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__ANDTHEN_COUNT = ASSURE_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__TBD_COUNT = ASSURE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__WEIGHT = ASSURE_RESULT__WEIGHT;

  /**
   * The number of structural features of the '<em>Verification Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
   * @generated
   */
  int VERIFICATION_ACTIVITY_RESULT = 4;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__SUCCESS_COUNT = VERIFICATION_EXPR__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__FAIL_COUNT = VERIFICATION_EXPR__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ERROR_COUNT = VERIFICATION_EXPR__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__FAILTHEN_COUNT = VERIFICATION_EXPR__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ANDTHEN_COUNT = VERIFICATION_EXPR__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__TBD_COUNT = VERIFICATION_EXPR__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__WEIGHT = VERIFICATION_EXPR__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__NAME = VERIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__TARGET = VERIFICATION_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE = VERIFICATION_EXPR_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__RESULT_STATE = VERIFICATION_EXPR_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ISSUES = VERIFICATION_EXPR_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__RESULT_REPORT = VERIFICATION_EXPR_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__MESSAGE = VERIFICATION_EXPR_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Assumption Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ASSUMPTION_RESULT = VERIFICATION_EXPR_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Precondition Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = VERIFICATION_EXPR_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Verification Activity Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.FailThenResultImpl <em>Fail Then Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.FailThenResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getFailThenResult()
   * @generated
   */
  int FAIL_THEN_RESULT = 7;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__SUCCESS_COUNT = VERIFICATION_EXPR__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__FAIL_COUNT = VERIFICATION_EXPR__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__ERROR_COUNT = VERIFICATION_EXPR__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__FAILTHEN_COUNT = VERIFICATION_EXPR__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__ANDTHEN_COUNT = VERIFICATION_EXPR__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__TBD_COUNT = VERIFICATION_EXPR__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__WEIGHT = VERIFICATION_EXPR__WEIGHT;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__FIRST = VERIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__SECOND = VERIFICATION_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Did Fail Then Fail</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__DID_FAIL_THEN_FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Fail Then Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AndThenResultImpl <em>And Then Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AndThenResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAndThenResult()
   * @generated
   */
  int AND_THEN_RESULT = 8;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__SUCCESS_COUNT = VERIFICATION_EXPR__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__FAIL_COUNT = VERIFICATION_EXPR__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__ERROR_COUNT = VERIFICATION_EXPR__ERROR_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__FAILTHEN_COUNT = VERIFICATION_EXPR__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__ANDTHEN_COUNT = VERIFICATION_EXPR__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__TBD_COUNT = VERIFICATION_EXPR__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__WEIGHT = VERIFICATION_EXPR__WEIGHT;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__FIRST = VERIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__SECOND = VERIFICATION_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Did And Then Fail</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__DID_AND_THEN_FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>And Then Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.ResultIssueImpl <em>Result Issue</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ResultIssueImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getResultIssue()
   * @generated
   */
  int RESULT_ISSUE = 9;

  /**
   * The feature id for the '<em><b>Issue Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__ISSUE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__NAME = 1;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__MESSAGE = 2;

  /**
   * The feature id for the '<em><b>Exception Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__EXCEPTION_TYPE = 3;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__TARGET = 4;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__ISSUES = 5;

  /**
   * The number of structural features of the '<em>Result Issue</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.ResultIssueType <em>Result Issue Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.ResultIssueType
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getResultIssueType()
   * @generated
   */
  int RESULT_ISSUE_TYPE = 10;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationResultState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultState()
   * @generated
   */
  int VERIFICATION_RESULT_STATE = 11;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExecutionState()
   * @generated
   */
  int VERIFICATION_EXECUTION_STATE = 12;


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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.CaseResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.CaseResult#getName()
   * @see #getCaseResult()
   * @generated
   */
  EAttribute getCaseResult_Name();

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
   * Returns the meta object for the reference '{@link org.osate.assure.assure.CaseResult#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance</em>'.
   * @see org.osate.assure.assure.CaseResult#getInstance()
   * @see #getCaseResult()
   * @generated
   */
  EReference getCaseResult_Instance();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.CaseResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.CaseResult#getMessage()
   * @see #getCaseResult()
   * @generated
   */
  EAttribute getCaseResult_Message();

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
   * Returns the meta object for class '{@link org.osate.assure.assure.ClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.ClaimResult
   * @generated
   */
  EClass getClaimResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ClaimResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.ClaimResult#getName()
   * @see #getClaimResult()
   * @generated
   */
  EAttribute getClaimResult_Name();

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
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ClaimResult#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance</em>'.
   * @see org.osate.assure.assure.ClaimResult#getInstance()
   * @see #getClaimResult()
   * @generated
   */
  EReference getClaimResult_Instance();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ClaimResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.ClaimResult#getMessage()
   * @see #getClaimResult()
   * @generated
   */
  EAttribute getClaimResult_Message();

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
   * Returns the meta object for class '{@link org.osate.assure.assure.AssumptionResult <em>Assumption Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assumption Result</em>'.
   * @see org.osate.assure.assure.AssumptionResult
   * @generated
   */
  EClass getAssumptionResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssumptionResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.AssumptionResult#getName()
   * @see #getAssumptionResult()
   * @generated
   */
  EAttribute getAssumptionResult_Name();

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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssumptionResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.AssumptionResult#getMessage()
   * @see #getAssumptionResult()
   * @generated
   */
  EAttribute getAssumptionResult_Message();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AssumptionResult#getVerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Verification Activity Result</em>'.
   * @see org.osate.assure.assure.AssumptionResult#getVerificationActivityResult()
   * @see #getAssumptionResult()
   * @generated
   */
  EReference getAssumptionResult_VerificationActivityResult();

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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.PreconditionResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.PreconditionResult#getName()
   * @see #getPreconditionResult()
   * @generated
   */
  EAttribute getPreconditionResult_Name();

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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.PreconditionResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.PreconditionResult#getMessage()
   * @see #getPreconditionResult()
   * @generated
   */
  EAttribute getPreconditionResult_Message();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.PreconditionResult#getVerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Verification Activity Result</em>'.
   * @see org.osate.assure.assure.PreconditionResult#getVerificationActivityResult()
   * @see #getPreconditionResult()
   * @generated
   */
  EReference getPreconditionResult_VerificationActivityResult();

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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationActivityResult#getResultState <em>Result State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Result State</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getResultState()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EAttribute getVerificationActivityResult_ResultState();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationActivityResult#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getIssues()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_Issues();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.VerificationActivityResult#getResultReport <em>Result Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Result Report</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getResultReport()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_ResultReport();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationActivityResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getMessage()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EAttribute getVerificationActivityResult_Message();

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
   * Returns the meta object for class '{@link org.osate.assure.assure.AssureResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result</em>'.
   * @see org.osate.assure.assure.AssureResult
   * @generated
   */
  EClass getAssureResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getSuccessCount <em>Success Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Success Count</em>'.
   * @see org.osate.assure.assure.AssureResult#getSuccessCount()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_SuccessCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getFailCount <em>Fail Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail Count</em>'.
   * @see org.osate.assure.assure.AssureResult#getFailCount()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_FailCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getErrorCount <em>Error Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Error Count</em>'.
   * @see org.osate.assure.assure.AssureResult#getErrorCount()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_ErrorCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getFailthenCount <em>Failthen Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Failthen Count</em>'.
   * @see org.osate.assure.assure.AssureResult#getFailthenCount()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_FailthenCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getAndthenCount <em>Andthen Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Andthen Count</em>'.
   * @see org.osate.assure.assure.AssureResult#getAndthenCount()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_AndthenCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getTbdCount <em>Tbd Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tbd Count</em>'.
   * @see org.osate.assure.assure.AssureResult#getTbdCount()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_TbdCount();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getWeight <em>Weight</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weight</em>'.
   * @see org.osate.assure.assure.AssureResult#getWeight()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_Weight();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationExpr <em>Verification Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Expr</em>'.
   * @see org.osate.assure.assure.VerificationExpr
   * @generated
   */
  EClass getVerificationExpr();

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
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.FailThenResult#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>First</em>'.
   * @see org.osate.assure.assure.FailThenResult#getFirst()
   * @see #getFailThenResult()
   * @generated
   */
  EReference getFailThenResult_First();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.FailThenResult#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Second</em>'.
   * @see org.osate.assure.assure.FailThenResult#getSecond()
   * @see #getFailThenResult()
   * @generated
   */
  EReference getFailThenResult_Second();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.FailThenResult#isDidFailThenFail <em>Did Fail Then Fail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Did Fail Then Fail</em>'.
   * @see org.osate.assure.assure.FailThenResult#isDidFailThenFail()
   * @see #getFailThenResult()
   * @generated
   */
  EAttribute getFailThenResult_DidFailThenFail();

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
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AndThenResult#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>First</em>'.
   * @see org.osate.assure.assure.AndThenResult#getFirst()
   * @see #getAndThenResult()
   * @generated
   */
  EReference getAndThenResult_First();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AndThenResult#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Second</em>'.
   * @see org.osate.assure.assure.AndThenResult#getSecond()
   * @see #getAndThenResult()
   * @generated
   */
  EReference getAndThenResult_Second();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AndThenResult#isDidAndThenFail <em>Did And Then Fail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Did And Then Fail</em>'.
   * @see org.osate.assure.assure.AndThenResult#isDidAndThenFail()
   * @see #getAndThenResult()
   * @generated
   */
  EAttribute getAndThenResult_DidAndThenFail();

  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.ResultIssue <em>Result Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Issue</em>'.
   * @see org.osate.assure.assure.ResultIssue
   * @generated
   */
  EClass getResultIssue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ResultIssue#getIssueType <em>Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Issue Type</em>'.
   * @see org.osate.assure.assure.ResultIssue#getIssueType()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_IssueType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ResultIssue#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.ResultIssue#getName()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ResultIssue#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.ResultIssue#getMessage()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_Message();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.ResultIssue#getExceptionType <em>Exception Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exception Type</em>'.
   * @see org.osate.assure.assure.ResultIssue#getExceptionType()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_ExceptionType();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ResultIssue#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.ResultIssue#getTarget()
   * @see #getResultIssue()
   * @generated
   */
  EReference getResultIssue_Target();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ResultIssue#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.assure.assure.ResultIssue#getIssues()
   * @see #getResultIssue()
   * @generated
   */
  EReference getResultIssue_Issues();

  /**
   * Returns the meta object for enum '{@link org.osate.assure.assure.ResultIssueType <em>Result Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Result Issue Type</em>'.
   * @see org.osate.assure.assure.ResultIssueType
   * @generated
   */
  EEnum getResultIssueType();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_RESULT__NAME = eINSTANCE.getCaseResult_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__TARGET = eINSTANCE.getCaseResult_Target();

    /**
     * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_RESULT__INSTANCE = eINSTANCE.getCaseResult_Instance();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_RESULT__MESSAGE = eINSTANCE.getCaseResult_Message();

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
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ClaimResultImpl <em>Claim Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ClaimResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getClaimResult()
     * @generated
     */
    EClass CLAIM_RESULT = eINSTANCE.getClaimResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM_RESULT__NAME = eINSTANCE.getClaimResult_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__TARGET = eINSTANCE.getClaimResult_Target();

    /**
     * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_RESULT__INSTANCE = eINSTANCE.getClaimResult_Instance();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM_RESULT__MESSAGE = eINSTANCE.getClaimResult_Message();

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
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AssumptionResultImpl <em>Assumption Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AssumptionResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssumptionResult()
     * @generated
     */
    EClass ASSUMPTION_RESULT = eINSTANCE.getAssumptionResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSUMPTION_RESULT__NAME = eINSTANCE.getAssumptionResult_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSUMPTION_RESULT__TARGET = eINSTANCE.getAssumptionResult_Target();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSUMPTION_RESULT__MESSAGE = eINSTANCE.getAssumptionResult_Message();

    /**
     * The meta object literal for the '<em><b>Verification Activity Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSUMPTION_RESULT__VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getAssumptionResult_VerificationActivityResult();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRECONDITION_RESULT__NAME = eINSTANCE.getPreconditionResult_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRECONDITION_RESULT__TARGET = eINSTANCE.getPreconditionResult_Target();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRECONDITION_RESULT__MESSAGE = eINSTANCE.getPreconditionResult_Message();

    /**
     * The meta object literal for the '<em><b>Verification Activity Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRECONDITION_RESULT__VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getPreconditionResult_VerificationActivityResult();

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
     * The meta object literal for the '<em><b>Result State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY_RESULT__RESULT_STATE = eINSTANCE.getVerificationActivityResult_ResultState();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__ISSUES = eINSTANCE.getVerificationActivityResult_Issues();

    /**
     * The meta object literal for the '<em><b>Result Report</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__RESULT_REPORT = eINSTANCE.getVerificationActivityResult_ResultReport();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY_RESULT__MESSAGE = eINSTANCE.getVerificationActivityResult_Message();

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
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AssureResultImpl <em>Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AssureResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssureResult()
     * @generated
     */
    EClass ASSURE_RESULT = eINSTANCE.getAssureResult();

    /**
     * The meta object literal for the '<em><b>Success Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__SUCCESS_COUNT = eINSTANCE.getAssureResult_SuccessCount();

    /**
     * The meta object literal for the '<em><b>Fail Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__FAIL_COUNT = eINSTANCE.getAssureResult_FailCount();

    /**
     * The meta object literal for the '<em><b>Error Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__ERROR_COUNT = eINSTANCE.getAssureResult_ErrorCount();

    /**
     * The meta object literal for the '<em><b>Failthen Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__FAILTHEN_COUNT = eINSTANCE.getAssureResult_FailthenCount();

    /**
     * The meta object literal for the '<em><b>Andthen Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__ANDTHEN_COUNT = eINSTANCE.getAssureResult_AndthenCount();

    /**
     * The meta object literal for the '<em><b>Tbd Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__TBD_COUNT = eINSTANCE.getAssureResult_TbdCount();

    /**
     * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__WEIGHT = eINSTANCE.getAssureResult_Weight();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationExprImpl <em>Verification Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationExprImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExpr()
     * @generated
     */
    EClass VERIFICATION_EXPR = eINSTANCE.getVerificationExpr();

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
     * The meta object literal for the '<em><b>First</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAIL_THEN_RESULT__FIRST = eINSTANCE.getFailThenResult_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAIL_THEN_RESULT__SECOND = eINSTANCE.getFailThenResult_Second();

    /**
     * The meta object literal for the '<em><b>Did Fail Then Fail</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAIL_THEN_RESULT__DID_FAIL_THEN_FAIL = eINSTANCE.getFailThenResult_DidFailThenFail();

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
     * The meta object literal for the '<em><b>First</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_THEN_RESULT__FIRST = eINSTANCE.getAndThenResult_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_THEN_RESULT__SECOND = eINSTANCE.getAndThenResult_Second();

    /**
     * The meta object literal for the '<em><b>Did And Then Fail</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AND_THEN_RESULT__DID_AND_THEN_FAIL = eINSTANCE.getAndThenResult_DidAndThenFail();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ResultIssueImpl <em>Result Issue</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ResultIssueImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getResultIssue()
     * @generated
     */
    EClass RESULT_ISSUE = eINSTANCE.getResultIssue();

    /**
     * The meta object literal for the '<em><b>Issue Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__ISSUE_TYPE = eINSTANCE.getResultIssue_IssueType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__NAME = eINSTANCE.getResultIssue_Name();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__MESSAGE = eINSTANCE.getResultIssue_Message();

    /**
     * The meta object literal for the '<em><b>Exception Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__EXCEPTION_TYPE = eINSTANCE.getResultIssue_ExceptionType();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_ISSUE__TARGET = eINSTANCE.getResultIssue_Target();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_ISSUE__ISSUES = eINSTANCE.getResultIssue_Issues();

    /**
     * The meta object literal for the '{@link org.osate.assure.assure.ResultIssueType <em>Result Issue Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.ResultIssueType
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getResultIssueType()
     * @generated
     */
    EEnum RESULT_ISSUE_TYPE = eINSTANCE.getResultIssueType();

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
