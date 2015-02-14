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
  int ASSURE_RESULT = 3;

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
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURE_RESULT__UNKNOWN_COUNT = 2;

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
   * The meta object id for the '{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl <em>Assurance Evidence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AssuranceEvidenceImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceEvidence()
   * @generated
   */
  int ASSURANCE_EVIDENCE = 0;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__SUCCESS_COUNT = ASSURE_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__FAIL_COUNT = ASSURE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__UNKNOWN_COUNT = ASSURE_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__FAILTHEN_COUNT = ASSURE_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__ANDTHEN_COUNT = ASSURE_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__TBD_COUNT = ASSURE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__WEIGHT = ASSURE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__TARGET = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Instance</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__INSTANCE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Sub Assurance Evidence</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE__CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Assurance Evidence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_EVIDENCE_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 6;

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
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_RESULT__UNKNOWN_COUNT = ASSURE_RESULT__UNKNOWN_COUNT;

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
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationResultImpl <em>Verification Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResult()
   * @generated
   */
  int VERIFICATION_RESULT = 2;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__SUCCESS_COUNT = ASSURE_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__FAIL_COUNT = ASSURE_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__UNKNOWN_COUNT = ASSURE_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__FAILTHEN_COUNT = ASSURE_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__ANDTHEN_COUNT = ASSURE_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__TBD_COUNT = ASSURE_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__WEIGHT = ASSURE_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__EXECUTION_STATE = ASSURE_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__RESULT_STATE = ASSURE_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__ISSUES = ASSURE_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__RESULT_REPORT = ASSURE_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Verification Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationExprImpl <em>Verification Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationExprImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExpr()
   * @generated
   */
  int VERIFICATION_EXPR = 4;

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
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_EXPR__UNKNOWN_COUNT = ASSURE_RESULT__UNKNOWN_COUNT;

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
   * The meta object id for the '{@link org.osate.assure.assure.impl.FailThenResultImpl <em>Fail Then Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.FailThenResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getFailThenResult()
   * @generated
   */
  int FAIL_THEN_RESULT = 5;

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
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__UNKNOWN_COUNT = VERIFICATION_EXPR__UNKNOWN_COUNT;

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
   * The feature id for the '<em><b>Fail Then</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__FAIL_THEN = VERIFICATION_EXPR_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Unknown Then</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__UNKNOWN_THEN = VERIFICATION_EXPR_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Did Fail</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT__DID_FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Fail Then Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.AndThenResultImpl <em>And Then Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.AndThenResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getAndThenResult()
   * @generated
   */
  int AND_THEN_RESULT = 6;

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
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_RESULT__UNKNOWN_COUNT = VERIFICATION_EXPR__UNKNOWN_COUNT;

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
  int RESULT_ISSUE = 7;

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
   * The meta object id for the '{@link org.osate.assure.assure.impl.ValidationResultImpl <em>Validation Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.ValidationResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getValidationResult()
   * @generated
   */
  int VALIDATION_RESULT = 8;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__SUCCESS_COUNT = VERIFICATION_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__FAIL_COUNT = VERIFICATION_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__UNKNOWN_COUNT = VERIFICATION_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__FAILTHEN_COUNT = VERIFICATION_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__ANDTHEN_COUNT = VERIFICATION_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__TBD_COUNT = VERIFICATION_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__WEIGHT = VERIFICATION_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__NAME = VERIFICATION_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__EXECUTION_STATE = VERIFICATION_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__RESULT_STATE = VERIFICATION_RESULT__RESULT_STATE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__RESULT_REPORT = VERIFICATION_RESULT__RESULT_REPORT;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT__TARGET = VERIFICATION_RESULT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Validation Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALIDATION_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.PreconditionResultImpl <em>Precondition Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.PreconditionResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getPreconditionResult()
   * @generated
   */
  int PRECONDITION_RESULT = 9;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__SUCCESS_COUNT = VERIFICATION_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__FAIL_COUNT = VERIFICATION_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__UNKNOWN_COUNT = VERIFICATION_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__FAILTHEN_COUNT = VERIFICATION_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__ANDTHEN_COUNT = VERIFICATION_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__TBD_COUNT = VERIFICATION_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__WEIGHT = VERIFICATION_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__NAME = VERIFICATION_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__EXECUTION_STATE = VERIFICATION_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__RESULT_STATE = VERIFICATION_RESULT__RESULT_STATE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__RESULT_REPORT = VERIFICATION_RESULT__RESULT_REPORT;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT__TARGET = VERIFICATION_RESULT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Precondition Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
   * @generated
   */
  int VERIFICATION_ACTIVITY_RESULT = 10;

  /**
   * The feature id for the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__SUCCESS_COUNT = VERIFICATION_RESULT__SUCCESS_COUNT;

  /**
   * The feature id for the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__FAIL_COUNT = VERIFICATION_RESULT__FAIL_COUNT;

  /**
   * The feature id for the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__UNKNOWN_COUNT = VERIFICATION_RESULT__UNKNOWN_COUNT;

  /**
   * The feature id for the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__FAILTHEN_COUNT = VERIFICATION_RESULT__FAILTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ANDTHEN_COUNT = VERIFICATION_RESULT__ANDTHEN_COUNT;

  /**
   * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__TBD_COUNT = VERIFICATION_RESULT__TBD_COUNT;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__WEIGHT = VERIFICATION_RESULT__WEIGHT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__NAME = VERIFICATION_RESULT__NAME;

  /**
   * The feature id for the '<em><b>Execution State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__EXECUTION_STATE = VERIFICATION_RESULT__EXECUTION_STATE;

  /**
   * The feature id for the '<em><b>Result State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__RESULT_STATE = VERIFICATION_RESULT__RESULT_STATE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

  /**
   * The feature id for the '<em><b>Result Report</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__RESULT_REPORT = VERIFICATION_RESULT__RESULT_REPORT;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__TARGET = VERIFICATION_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Validation Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Precondition Result</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = VERIFICATION_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Verification Activity Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.ResultIssueType <em>Result Issue Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.ResultIssueType
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getResultIssueType()
   * @generated
   */
  int RESULT_ISSUE_TYPE = 11;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationResultState <em>Verification Result State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationResultState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResultState()
   * @generated
   */
  int VERIFICATION_RESULT_STATE = 12;

  /**
   * The meta object id for the '{@link org.osate.assure.assure.VerificationExecutionState <em>Verification Execution State</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationExecutionState()
   * @generated
   */
  int VERIFICATION_EXECUTION_STATE = 13;


  /**
   * Returns the meta object for class '{@link org.osate.assure.assure.AssuranceEvidence <em>Assurance Evidence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assurance Evidence</em>'.
   * @see org.osate.assure.assure.AssuranceEvidence
   * @generated
   */
  EClass getAssuranceEvidence();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssuranceEvidence#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.AssuranceEvidence#getName()
   * @see #getAssuranceEvidence()
   * @generated
   */
  EAttribute getAssuranceEvidence_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.AssuranceEvidence#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.AssuranceEvidence#getTarget()
   * @see #getAssuranceEvidence()
   * @generated
   */
  EReference getAssuranceEvidence_Target();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.AssuranceEvidence#getInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance</em>'.
   * @see org.osate.assure.assure.AssuranceEvidence#getInstance()
   * @see #getAssuranceEvidence()
   * @generated
   */
  EReference getAssuranceEvidence_Instance();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssuranceEvidence#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.AssuranceEvidence#getMessage()
   * @see #getAssuranceEvidence()
   * @generated
   */
  EAttribute getAssuranceEvidence_Message();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AssuranceEvidence#getSubAssuranceEvidence <em>Sub Assurance Evidence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Assurance Evidence</em>'.
   * @see org.osate.assure.assure.AssuranceEvidence#getSubAssuranceEvidence()
   * @see #getAssuranceEvidence()
   * @generated
   */
  EReference getAssuranceEvidence_SubAssuranceEvidence();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AssuranceEvidence#getClaimResult <em>Claim Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claim Result</em>'.
   * @see org.osate.assure.assure.AssuranceEvidence#getClaimResult()
   * @see #getAssuranceEvidence()
   * @generated
   */
  EReference getAssuranceEvidence_ClaimResult();

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
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationResult <em>Verification Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Result</em>'.
   * @see org.osate.assure.assure.VerificationResult
   * @generated
   */
  EClass getVerificationResult();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.assure.assure.VerificationResult#getName()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getExecutionState <em>Execution State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Execution State</em>'.
   * @see org.osate.assure.assure.VerificationResult#getExecutionState()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_ExecutionState();

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
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationResult#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.assure.assure.VerificationResult#getIssues()
   * @see #getVerificationResult()
   * @generated
   */
  EReference getVerificationResult_Issues();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.VerificationResult#getResultReport <em>Result Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Result Report</em>'.
   * @see org.osate.assure.assure.VerificationResult#getResultReport()
   * @see #getVerificationResult()
   * @generated
   */
  EReference getVerificationResult_ResultReport();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.VerificationResult#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.assure.assure.VerificationResult#getMessage()
   * @see #getVerificationResult()
   * @generated
   */
  EAttribute getVerificationResult_Message();

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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssureResult#getUnknownCount <em>Unknown Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unknown Count</em>'.
   * @see org.osate.assure.assure.AssureResult#getUnknownCount()
   * @see #getAssureResult()
   * @generated
   */
  EAttribute getAssureResult_UnknownCount();

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
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.FailThenResult#isFailThen <em>Fail Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fail Then</em>'.
   * @see org.osate.assure.assure.FailThenResult#isFailThen()
   * @see #getFailThenResult()
   * @generated
   */
  EAttribute getFailThenResult_FailThen();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.FailThenResult#isUnknownThen <em>Unknown Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unknown Then</em>'.
   * @see org.osate.assure.assure.FailThenResult#isUnknownThen()
   * @see #getFailThenResult()
   * @generated
   */
  EAttribute getFailThenResult_UnknownThen();

  /**
   * Returns the meta object for the attribute '{@link org.osate.assure.assure.FailThenResult#isDidFail <em>Did Fail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Did Fail</em>'.
   * @see org.osate.assure.assure.FailThenResult#isDidFail()
   * @see #getFailThenResult()
   * @generated
   */
  EAttribute getFailThenResult_DidFail();

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
   * Returns the meta object for class '{@link org.osate.assure.assure.ValidationResult <em>Validation Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Validation Result</em>'.
   * @see org.osate.assure.assure.ValidationResult
   * @generated
   */
  EClass getValidationResult();

  /**
   * Returns the meta object for the reference '{@link org.osate.assure.assure.ValidationResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.assure.assure.ValidationResult#getTarget()
   * @see #getValidationResult()
   * @generated
   */
  EReference getValidationResult_Target();

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
   * Returns the meta object for class '{@link org.osate.assure.assure.VerificationActivityResult <em>Verification Activity Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Activity Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult
   * @generated
   */
  EClass getVerificationActivityResult();

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
   * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationActivityResult#getValidationResult <em>Validation Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Validation Result</em>'.
   * @see org.osate.assure.assure.VerificationActivityResult#getValidationResult()
   * @see #getVerificationActivityResult()
   * @generated
   */
  EReference getVerificationActivityResult_ValidationResult();

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
     * The meta object literal for the '{@link org.osate.assure.assure.impl.AssuranceEvidenceImpl <em>Assurance Evidence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.AssuranceEvidenceImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceEvidence()
     * @generated
     */
    EClass ASSURANCE_EVIDENCE = eINSTANCE.getAssuranceEvidence();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_EVIDENCE__NAME = eINSTANCE.getAssuranceEvidence_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_EVIDENCE__TARGET = eINSTANCE.getAssuranceEvidence_Target();

    /**
     * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_EVIDENCE__INSTANCE = eINSTANCE.getAssuranceEvidence_Instance();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_EVIDENCE__MESSAGE = eINSTANCE.getAssuranceEvidence_Message();

    /**
     * The meta object literal for the '<em><b>Sub Assurance Evidence</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_EVIDENCE__SUB_ASSURANCE_EVIDENCE = eINSTANCE.getAssuranceEvidence_SubAssuranceEvidence();

    /**
     * The meta object literal for the '<em><b>Claim Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_EVIDENCE__CLAIM_RESULT = eINSTANCE.getAssuranceEvidence_ClaimResult();

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
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationResultImpl <em>Verification Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationResult()
     * @generated
     */
    EClass VERIFICATION_RESULT = eINSTANCE.getVerificationResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__NAME = eINSTANCE.getVerificationResult_Name();

    /**
     * The meta object literal for the '<em><b>Execution State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__EXECUTION_STATE = eINSTANCE.getVerificationResult_ExecutionState();

    /**
     * The meta object literal for the '<em><b>Result State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__RESULT_STATE = eINSTANCE.getVerificationResult_ResultState();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_RESULT__ISSUES = eINSTANCE.getVerificationResult_Issues();

    /**
     * The meta object literal for the '<em><b>Result Report</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_RESULT__RESULT_REPORT = eINSTANCE.getVerificationResult_ResultReport();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_RESULT__MESSAGE = eINSTANCE.getVerificationResult_Message();

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
     * The meta object literal for the '<em><b>Unknown Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURE_RESULT__UNKNOWN_COUNT = eINSTANCE.getAssureResult_UnknownCount();

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
     * The meta object literal for the '<em><b>Fail Then</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAIL_THEN_RESULT__FAIL_THEN = eINSTANCE.getFailThenResult_FailThen();

    /**
     * The meta object literal for the '<em><b>Unknown Then</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAIL_THEN_RESULT__UNKNOWN_THEN = eINSTANCE.getFailThenResult_UnknownThen();

    /**
     * The meta object literal for the '<em><b>Did Fail</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAIL_THEN_RESULT__DID_FAIL = eINSTANCE.getFailThenResult_DidFail();

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
     * The meta object literal for the '{@link org.osate.assure.assure.impl.ValidationResultImpl <em>Validation Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.ValidationResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getValidationResult()
     * @generated
     */
    EClass VALIDATION_RESULT = eINSTANCE.getValidationResult();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALIDATION_RESULT__TARGET = eINSTANCE.getValidationResult_Target();

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
     * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
     * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
     * @generated
     */
    EClass VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getVerificationActivityResult();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__TARGET = eINSTANCE.getVerificationActivityResult_Target();

    /**
     * The meta object literal for the '<em><b>Validation Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT = eINSTANCE.getVerificationActivityResult_ValidationResult();

    /**
     * The meta object literal for the '<em><b>Precondition Result</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = eINSTANCE.getVerificationActivityResult_PreconditionResult();

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
