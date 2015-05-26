/**
 */
package org.osate.verify.verify;

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
 * @see org.osate.verify.verify.VerifyFactory
 * @model kind="package"
 * @generated
 */
public interface VerifyPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "verify";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/verify/Verify";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "verify";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VerifyPackage eINSTANCE = org.osate.verify.verify.impl.VerifyPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationImpl <em>Verification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerification()
   * @generated
   */
  int VERIFICATION = 0;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION__CONTENTS = 0;

  /**
   * The number of structural features of the '<em>Verification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationPlanImpl <em>Verification Plan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationPlanImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationPlan()
   * @generated
   */
  int VERIFICATION_PLAN = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__TITLE = 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__TARGET = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Claim</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__CLAIM = 4;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__RATIONALE = 5;

  /**
   * The feature id for the '<em><b>Verified Assumption</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__VERIFIED_ASSUMPTION = 6;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN__ISSUES = 7;

  /**
   * The number of structural features of the '<em>Verification Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PLAN_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.ClaimImpl <em>Claim</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.ClaimImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getClaim()
   * @generated
   */
  int CLAIM = 2;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__REQUIREMENT = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__TITLE = 1;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__WEIGHT = 2;

  /**
   * The feature id for the '<em><b>Activities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__ACTIVITIES = 3;

  /**
   * The feature id for the '<em><b>Assert</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__ASSERT = 4;

  /**
   * The feature id for the '<em><b>Argument</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__ARGUMENT = 5;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__RATIONALE = 6;

  /**
   * The feature id for the '<em><b>Subclaim</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__SUBCLAIM = 7;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM__ISSUES = 8;

  /**
   * The number of structural features of the '<em>Claim</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationActivityParameterImpl <em>Verification Activity Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationActivityParameterImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationActivityParameter()
   * @generated
   */
  int VERIFICATION_ACTIVITY_PARAMETER = 3;

  /**
   * The feature id for the '<em><b>Compute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_PARAMETER__COMPUTE = 0;

  /**
   * The number of structural features of the '<em>Verification Activity Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_PARAMETER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationActivityImpl <em>Verification Activity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationActivityImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationActivity()
   * @generated
   */
  int VERIFICATION_ACTIVITY = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY__NAME = 0;

  /**
   * The feature id for the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY__METHOD = 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY__PARAMETERS = 2;

  /**
   * The feature id for the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY__TIMEOUT = 3;

  /**
   * The number of structural features of the '<em>Verification Activity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_ACTIVITY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationConditionImpl <em>Verification Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationConditionImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationCondition()
   * @generated
   */
  int VERIFICATION_CONDITION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CONDITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CONDITION__TITLE = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CONDITION__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CONDITION__METHOD = 3;

  /**
   * The feature id for the '<em><b>Compute Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CONDITION__COMPUTE_VARIABLE = 4;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CONDITION__RATIONALE = 5;

  /**
   * The number of structural features of the '<em>Verification Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_CONDITION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.ArgumentExprImpl <em>Argument Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.ArgumentExprImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getArgumentExpr()
   * @generated
   */
  int ARGUMENT_EXPR = 6;

  /**
   * The number of structural features of the '<em>Argument Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationMethodRegistryImpl <em>Verification Method Registry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationMethodRegistryImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationMethodRegistry()
   * @generated
   */
  int VERIFICATION_METHOD_REGISTRY = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_REGISTRY__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_REGISTRY__TITLE = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_REGISTRY__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Methods</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_REGISTRY__METHODS = 3;

  /**
   * The number of structural features of the '<em>Verification Method Registry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_REGISTRY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationMethodParameterImpl <em>Verification Method Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationMethodParameterImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationMethodParameter()
   * @generated
   */
  int VERIFICATION_METHOD_PARAMETER = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_PARAMETER__NAME = 0;

  /**
   * The number of structural features of the '<em>Verification Method Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_PARAMETER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationMethodImpl <em>Verification Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationMethodImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationMethod()
   * @generated
   */
  int VERIFICATION_METHOD = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__NAME = 0;

  /**
   * The feature id for the '<em><b>Params</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__PARAMS = 1;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__TITLE = 2;

  /**
   * The feature id for the '<em><b>Method Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__METHOD_TYPE = 3;

  /**
   * The feature id for the '<em><b>Scope</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__SCOPE = 4;

  /**
   * The feature id for the '<em><b>Reporting</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__REPORTING = 5;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__DESCRIPTION = 6;

  /**
   * The feature id for the '<em><b>Method Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__METHOD_PATH = 7;

  /**
   * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__CONDITIONS = 8;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD__CATEGORY = 9;

  /**
   * The number of structural features of the '<em>Verification Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_METHOD_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationValidationImpl <em>Verification Validation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationValidationImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationValidation()
   * @generated
   */
  int VERIFICATION_VALIDATION = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_VALIDATION__NAME = VERIFICATION_CONDITION__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_VALIDATION__TITLE = VERIFICATION_CONDITION__TITLE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_VALIDATION__DESCRIPTION = VERIFICATION_CONDITION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_VALIDATION__METHOD = VERIFICATION_CONDITION__METHOD;

  /**
   * The feature id for the '<em><b>Compute Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_VALIDATION__COMPUTE_VARIABLE = VERIFICATION_CONDITION__COMPUTE_VARIABLE;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_VALIDATION__RATIONALE = VERIFICATION_CONDITION__RATIONALE;

  /**
   * The number of structural features of the '<em>Verification Validation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_VALIDATION_FEATURE_COUNT = VERIFICATION_CONDITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.VerificationPreconditionImpl <em>Verification Precondition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.VerificationPreconditionImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationPrecondition()
   * @generated
   */
  int VERIFICATION_PRECONDITION = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PRECONDITION__NAME = VERIFICATION_CONDITION__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PRECONDITION__TITLE = VERIFICATION_CONDITION__TITLE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PRECONDITION__DESCRIPTION = VERIFICATION_CONDITION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PRECONDITION__METHOD = VERIFICATION_CONDITION__METHOD;

  /**
   * The feature id for the '<em><b>Compute Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PRECONDITION__COMPUTE_VARIABLE = VERIFICATION_CONDITION__COMPUTE_VARIABLE;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PRECONDITION__RATIONALE = VERIFICATION_CONDITION__RATIONALE;

  /**
   * The number of structural features of the '<em>Verification Precondition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VERIFICATION_PRECONDITION_FEATURE_COUNT = VERIFICATION_CONDITION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.AllExprImpl <em>All Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.AllExprImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getAllExpr()
   * @generated
   */
  int ALL_EXPR = 12;

  /**
   * The feature id for the '<em><b>All</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALL_EXPR__ALL = ARGUMENT_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>All Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALL_EXPR_FEATURE_COUNT = ARGUMENT_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.AndThenExprImpl <em>And Then Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.AndThenExprImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getAndThenExpr()
   * @generated
   */
  int AND_THEN_EXPR = 13;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_EXPR__LEFT = ARGUMENT_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_EXPR__RIGHT = ARGUMENT_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Then Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_THEN_EXPR_FEATURE_COUNT = ARGUMENT_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.FailThenExprImpl <em>Fail Then Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.FailThenExprImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getFailThenExpr()
   * @generated
   */
  int FAIL_THEN_EXPR = 14;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_EXPR__LEFT = ARGUMENT_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Failed</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_EXPR__FAILED = ARGUMENT_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unknown</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_EXPR__UNKNOWN = ARGUMENT_EXPR_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_EXPR__RIGHT = ARGUMENT_EXPR_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Fail Then Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_THEN_EXPR_FEATURE_COUNT = ARGUMENT_EXPR_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.WhenExprImpl <em>When Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.WhenExprImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getWhenExpr()
   * @generated
   */
  int WHEN_EXPR = 15;

  /**
   * The feature id for the '<em><b>Verification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_EXPR__VERIFICATION = ARGUMENT_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_EXPR__CONDITION = ARGUMENT_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>When Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_EXPR_FEATURE_COUNT = ARGUMENT_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.impl.RefExprImpl <em>Ref Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.impl.RefExprImpl
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getRefExpr()
   * @generated
   */
  int REF_EXPR = 16;

  /**
   * The feature id for the '<em><b>Verification</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_EXPR__VERIFICATION = ARGUMENT_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_EXPR__WEIGHT = ARGUMENT_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Ref Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_EXPR_FEATURE_COUNT = ARGUMENT_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.SupportedTypes <em>Supported Types</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.SupportedTypes
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getSupportedTypes()
   * @generated
   */
  int SUPPORTED_TYPES = 17;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.SupportedScopes <em>Supported Scopes</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.SupportedScopes
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getSupportedScopes()
   * @generated
   */
  int SUPPORTED_SCOPES = 18;

  /**
   * The meta object id for the '{@link org.osate.verify.verify.SupportedReporting <em>Supported Reporting</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.verify.verify.SupportedReporting
   * @see org.osate.verify.verify.impl.VerifyPackageImpl#getSupportedReporting()
   * @generated
   */
  int SUPPORTED_REPORTING = 19;


  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.Verification <em>Verification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification</em>'.
   * @see org.osate.verify.verify.Verification
   * @generated
   */
  EClass getVerification();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.verify.verify.Verification#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.osate.verify.verify.Verification#getContents()
   * @see #getVerification()
   * @generated
   */
  EReference getVerification_Contents();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationPlan <em>Verification Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Plan</em>'.
   * @see org.osate.verify.verify.VerificationPlan
   * @generated
   */
  EClass getVerificationPlan();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationPlan#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getName()
   * @see #getVerificationPlan()
   * @generated
   */
  EAttribute getVerificationPlan_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationPlan#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getTitle()
   * @see #getVerificationPlan()
   * @generated
   */
  EAttribute getVerificationPlan_Title();

  /**
   * Returns the meta object for the reference '{@link org.osate.verify.verify.VerificationPlan#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getTarget()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_Target();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.VerificationPlan#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getDescription()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_Description();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.verify.verify.VerificationPlan#getClaim <em>Claim</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claim</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getClaim()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_Claim();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.VerificationPlan#getRationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rationale</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getRationale()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_Rationale();

  /**
   * Returns the meta object for the reference list '{@link org.osate.verify.verify.VerificationPlan#getVerifiedAssumption <em>Verified Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Verified Assumption</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getVerifiedAssumption()
   * @see #getVerificationPlan()
   * @generated
   */
  EReference getVerificationPlan_VerifiedAssumption();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.verify.verify.VerificationPlan#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issues</em>'.
   * @see org.osate.verify.verify.VerificationPlan#getIssues()
   * @see #getVerificationPlan()
   * @generated
   */
  EAttribute getVerificationPlan_Issues();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.Claim <em>Claim</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim</em>'.
   * @see org.osate.verify.verify.Claim
   * @generated
   */
  EClass getClaim();

  /**
   * Returns the meta object for the reference '{@link org.osate.verify.verify.Claim#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Requirement</em>'.
   * @see org.osate.verify.verify.Claim#getRequirement()
   * @see #getClaim()
   * @generated
   */
  EReference getClaim_Requirement();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.Claim#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.verify.verify.Claim#getTitle()
   * @see #getClaim()
   * @generated
   */
  EAttribute getClaim_Title();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.Claim#getWeight <em>Weight</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weight</em>'.
   * @see org.osate.verify.verify.Claim#getWeight()
   * @see #getClaim()
   * @generated
   */
  EAttribute getClaim_Weight();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.verify.verify.Claim#getActivities <em>Activities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Activities</em>'.
   * @see org.osate.verify.verify.Claim#getActivities()
   * @see #getClaim()
   * @generated
   */
  EReference getClaim_Activities();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.Claim#getAssert <em>Assert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assert</em>'.
   * @see org.osate.verify.verify.Claim#getAssert()
   * @see #getClaim()
   * @generated
   */
  EReference getClaim_Assert();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.Claim#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Argument</em>'.
   * @see org.osate.verify.verify.Claim#getArgument()
   * @see #getClaim()
   * @generated
   */
  EAttribute getClaim_Argument();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.Claim#getRationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rationale</em>'.
   * @see org.osate.verify.verify.Claim#getRationale()
   * @see #getClaim()
   * @generated
   */
  EReference getClaim_Rationale();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.verify.verify.Claim#getSubclaim <em>Subclaim</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subclaim</em>'.
   * @see org.osate.verify.verify.Claim#getSubclaim()
   * @see #getClaim()
   * @generated
   */
  EReference getClaim_Subclaim();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.verify.verify.Claim#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issues</em>'.
   * @see org.osate.verify.verify.Claim#getIssues()
   * @see #getClaim()
   * @generated
   */
  EAttribute getClaim_Issues();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationActivityParameter <em>Verification Activity Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Activity Parameter</em>'.
   * @see org.osate.verify.verify.VerificationActivityParameter
   * @generated
   */
  EClass getVerificationActivityParameter();

  /**
   * Returns the meta object for the reference '{@link org.osate.verify.verify.VerificationActivityParameter#getCompute <em>Compute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Compute</em>'.
   * @see org.osate.verify.verify.VerificationActivityParameter#getCompute()
   * @see #getVerificationActivityParameter()
   * @generated
   */
  EReference getVerificationActivityParameter_Compute();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationActivity <em>Verification Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Activity</em>'.
   * @see org.osate.verify.verify.VerificationActivity
   * @generated
   */
  EClass getVerificationActivity();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationActivity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.verify.verify.VerificationActivity#getName()
   * @see #getVerificationActivity()
   * @generated
   */
  EAttribute getVerificationActivity_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.verify.verify.VerificationActivity#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Method</em>'.
   * @see org.osate.verify.verify.VerificationActivity#getMethod()
   * @see #getVerificationActivity()
   * @generated
   */
  EReference getVerificationActivity_Method();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.verify.verify.VerificationActivity#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Parameters</em>'.
   * @see org.osate.verify.verify.VerificationActivity#getParameters()
   * @see #getVerificationActivity()
   * @generated
   */
  EAttribute getVerificationActivity_Parameters();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationActivity#getTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timeout</em>'.
   * @see org.osate.verify.verify.VerificationActivity#getTimeout()
   * @see #getVerificationActivity()
   * @generated
   */
  EAttribute getVerificationActivity_Timeout();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationCondition <em>Verification Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Condition</em>'.
   * @see org.osate.verify.verify.VerificationCondition
   * @generated
   */
  EClass getVerificationCondition();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationCondition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.verify.verify.VerificationCondition#getName()
   * @see #getVerificationCondition()
   * @generated
   */
  EAttribute getVerificationCondition_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationCondition#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.verify.verify.VerificationCondition#getTitle()
   * @see #getVerificationCondition()
   * @generated
   */
  EAttribute getVerificationCondition_Title();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.VerificationCondition#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.verify.verify.VerificationCondition#getDescription()
   * @see #getVerificationCondition()
   * @generated
   */
  EReference getVerificationCondition_Description();

  /**
   * Returns the meta object for the reference '{@link org.osate.verify.verify.VerificationCondition#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Method</em>'.
   * @see org.osate.verify.verify.VerificationCondition#getMethod()
   * @see #getVerificationCondition()
   * @generated
   */
  EReference getVerificationCondition_Method();

  /**
   * Returns the meta object for the reference '{@link org.osate.verify.verify.VerificationCondition#getComputeVariable <em>Compute Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Compute Variable</em>'.
   * @see org.osate.verify.verify.VerificationCondition#getComputeVariable()
   * @see #getVerificationCondition()
   * @generated
   */
  EReference getVerificationCondition_ComputeVariable();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.VerificationCondition#getRationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rationale</em>'.
   * @see org.osate.verify.verify.VerificationCondition#getRationale()
   * @see #getVerificationCondition()
   * @generated
   */
  EReference getVerificationCondition_Rationale();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.ArgumentExpr <em>Argument Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument Expr</em>'.
   * @see org.osate.verify.verify.ArgumentExpr
   * @generated
   */
  EClass getArgumentExpr();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationMethodRegistry <em>Verification Method Registry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Method Registry</em>'.
   * @see org.osate.verify.verify.VerificationMethodRegistry
   * @generated
   */
  EClass getVerificationMethodRegistry();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethodRegistry#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.verify.verify.VerificationMethodRegistry#getName()
   * @see #getVerificationMethodRegistry()
   * @generated
   */
  EAttribute getVerificationMethodRegistry_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethodRegistry#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.verify.verify.VerificationMethodRegistry#getTitle()
   * @see #getVerificationMethodRegistry()
   * @generated
   */
  EAttribute getVerificationMethodRegistry_Title();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.VerificationMethodRegistry#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.verify.verify.VerificationMethodRegistry#getDescription()
   * @see #getVerificationMethodRegistry()
   * @generated
   */
  EReference getVerificationMethodRegistry_Description();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.verify.verify.VerificationMethodRegistry#getMethods <em>Methods</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Methods</em>'.
   * @see org.osate.verify.verify.VerificationMethodRegistry#getMethods()
   * @see #getVerificationMethodRegistry()
   * @generated
   */
  EReference getVerificationMethodRegistry_Methods();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationMethodParameter <em>Verification Method Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Method Parameter</em>'.
   * @see org.osate.verify.verify.VerificationMethodParameter
   * @generated
   */
  EClass getVerificationMethodParameter();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethodParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.verify.verify.VerificationMethodParameter#getName()
   * @see #getVerificationMethodParameter()
   * @generated
   */
  EAttribute getVerificationMethodParameter_Name();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationMethod <em>Verification Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Method</em>'.
   * @see org.osate.verify.verify.VerificationMethod
   * @generated
   */
  EClass getVerificationMethod();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethod#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getName()
   * @see #getVerificationMethod()
   * @generated
   */
  EAttribute getVerificationMethod_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.verify.verify.VerificationMethod#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Params</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getParams()
   * @see #getVerificationMethod()
   * @generated
   */
  EAttribute getVerificationMethod_Params();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethod#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getTitle()
   * @see #getVerificationMethod()
   * @generated
   */
  EAttribute getVerificationMethod_Title();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethod#getMethodType <em>Method Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method Type</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getMethodType()
   * @see #getVerificationMethod()
   * @generated
   */
  EAttribute getVerificationMethod_MethodType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethod#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scope</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getScope()
   * @see #getVerificationMethod()
   * @generated
   */
  EAttribute getVerificationMethod_Scope();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethod#getReporting <em>Reporting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reporting</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getReporting()
   * @see #getVerificationMethod()
   * @generated
   */
  EAttribute getVerificationMethod_Reporting();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.VerificationMethod#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getDescription()
   * @see #getVerificationMethod()
   * @generated
   */
  EReference getVerificationMethod_Description();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.VerificationMethod#getMethodPath <em>Method Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method Path</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getMethodPath()
   * @see #getVerificationMethod()
   * @generated
   */
  EAttribute getVerificationMethod_MethodPath();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.verify.verify.VerificationMethod#getConditions <em>Conditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conditions</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getConditions()
   * @see #getVerificationMethod()
   * @generated
   */
  EReference getVerificationMethod_Conditions();

  /**
   * Returns the meta object for the reference list '{@link org.osate.verify.verify.VerificationMethod#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Category</em>'.
   * @see org.osate.verify.verify.VerificationMethod#getCategory()
   * @see #getVerificationMethod()
   * @generated
   */
  EReference getVerificationMethod_Category();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationValidation <em>Verification Validation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Validation</em>'.
   * @see org.osate.verify.verify.VerificationValidation
   * @generated
   */
  EClass getVerificationValidation();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.VerificationPrecondition <em>Verification Precondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Verification Precondition</em>'.
   * @see org.osate.verify.verify.VerificationPrecondition
   * @generated
   */
  EClass getVerificationPrecondition();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.AllExpr <em>All Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>All Expr</em>'.
   * @see org.osate.verify.verify.AllExpr
   * @generated
   */
  EClass getAllExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.verify.verify.AllExpr#getAll <em>All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>All</em>'.
   * @see org.osate.verify.verify.AllExpr#getAll()
   * @see #getAllExpr()
   * @generated
   */
  EReference getAllExpr_All();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.AndThenExpr <em>And Then Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Then Expr</em>'.
   * @see org.osate.verify.verify.AndThenExpr
   * @generated
   */
  EClass getAndThenExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.AndThenExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.verify.verify.AndThenExpr#getLeft()
   * @see #getAndThenExpr()
   * @generated
   */
  EReference getAndThenExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.AndThenExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.verify.verify.AndThenExpr#getRight()
   * @see #getAndThenExpr()
   * @generated
   */
  EReference getAndThenExpr_Right();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.FailThenExpr <em>Fail Then Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fail Then Expr</em>'.
   * @see org.osate.verify.verify.FailThenExpr
   * @generated
   */
  EClass getFailThenExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.FailThenExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.verify.verify.FailThenExpr#getLeft()
   * @see #getFailThenExpr()
   * @generated
   */
  EReference getFailThenExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.FailThenExpr#isFailed <em>Failed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Failed</em>'.
   * @see org.osate.verify.verify.FailThenExpr#isFailed()
   * @see #getFailThenExpr()
   * @generated
   */
  EAttribute getFailThenExpr_Failed();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.FailThenExpr#isUnknown <em>Unknown</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unknown</em>'.
   * @see org.osate.verify.verify.FailThenExpr#isUnknown()
   * @see #getFailThenExpr()
   * @generated
   */
  EAttribute getFailThenExpr_Unknown();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.FailThenExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.verify.verify.FailThenExpr#getRight()
   * @see #getFailThenExpr()
   * @generated
   */
  EReference getFailThenExpr_Right();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.WhenExpr <em>When Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>When Expr</em>'.
   * @see org.osate.verify.verify.WhenExpr
   * @generated
   */
  EClass getWhenExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.verify.verify.WhenExpr#getVerification <em>Verification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Verification</em>'.
   * @see org.osate.verify.verify.WhenExpr#getVerification()
   * @see #getWhenExpr()
   * @generated
   */
  EReference getWhenExpr_Verification();

  /**
   * Returns the meta object for the reference list '{@link org.osate.verify.verify.WhenExpr#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Condition</em>'.
   * @see org.osate.verify.verify.WhenExpr#getCondition()
   * @see #getWhenExpr()
   * @generated
   */
  EReference getWhenExpr_Condition();

  /**
   * Returns the meta object for class '{@link org.osate.verify.verify.RefExpr <em>Ref Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Expr</em>'.
   * @see org.osate.verify.verify.RefExpr
   * @generated
   */
  EClass getRefExpr();

  /**
   * Returns the meta object for the reference '{@link org.osate.verify.verify.RefExpr#getVerification <em>Verification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Verification</em>'.
   * @see org.osate.verify.verify.RefExpr#getVerification()
   * @see #getRefExpr()
   * @generated
   */
  EReference getRefExpr_Verification();

  /**
   * Returns the meta object for the attribute '{@link org.osate.verify.verify.RefExpr#getWeight <em>Weight</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Weight</em>'.
   * @see org.osate.verify.verify.RefExpr#getWeight()
   * @see #getRefExpr()
   * @generated
   */
  EAttribute getRefExpr_Weight();

  /**
   * Returns the meta object for enum '{@link org.osate.verify.verify.SupportedTypes <em>Supported Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Supported Types</em>'.
   * @see org.osate.verify.verify.SupportedTypes
   * @generated
   */
  EEnum getSupportedTypes();

  /**
   * Returns the meta object for enum '{@link org.osate.verify.verify.SupportedScopes <em>Supported Scopes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Supported Scopes</em>'.
   * @see org.osate.verify.verify.SupportedScopes
   * @generated
   */
  EEnum getSupportedScopes();

  /**
   * Returns the meta object for enum '{@link org.osate.verify.verify.SupportedReporting <em>Supported Reporting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Supported Reporting</em>'.
   * @see org.osate.verify.verify.SupportedReporting
   * @generated
   */
  EEnum getSupportedReporting();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  VerifyFactory getVerifyFactory();

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
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationImpl <em>Verification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerification()
     * @generated
     */
    EClass VERIFICATION = eINSTANCE.getVerification();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION__CONTENTS = eINSTANCE.getVerification_Contents();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationPlanImpl <em>Verification Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationPlanImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationPlan()
     * @generated
     */
    EClass VERIFICATION_PLAN = eINSTANCE.getVerificationPlan();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_PLAN__NAME = eINSTANCE.getVerificationPlan_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_PLAN__TITLE = eINSTANCE.getVerificationPlan_Title();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__TARGET = eINSTANCE.getVerificationPlan_Target();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__DESCRIPTION = eINSTANCE.getVerificationPlan_Description();

    /**
     * The meta object literal for the '<em><b>Claim</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__CLAIM = eINSTANCE.getVerificationPlan_Claim();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__RATIONALE = eINSTANCE.getVerificationPlan_Rationale();

    /**
     * The meta object literal for the '<em><b>Verified Assumption</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_PLAN__VERIFIED_ASSUMPTION = eINSTANCE.getVerificationPlan_VerifiedAssumption();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_PLAN__ISSUES = eINSTANCE.getVerificationPlan_Issues();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.ClaimImpl <em>Claim</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.ClaimImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getClaim()
     * @generated
     */
    EClass CLAIM = eINSTANCE.getClaim();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM__REQUIREMENT = eINSTANCE.getClaim_Requirement();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM__TITLE = eINSTANCE.getClaim_Title();

    /**
     * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM__WEIGHT = eINSTANCE.getClaim_Weight();

    /**
     * The meta object literal for the '<em><b>Activities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM__ACTIVITIES = eINSTANCE.getClaim_Activities();

    /**
     * The meta object literal for the '<em><b>Assert</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM__ASSERT = eINSTANCE.getClaim_Assert();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM__ARGUMENT = eINSTANCE.getClaim_Argument();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM__RATIONALE = eINSTANCE.getClaim_Rationale();

    /**
     * The meta object literal for the '<em><b>Subclaim</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM__SUBCLAIM = eINSTANCE.getClaim_Subclaim();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM__ISSUES = eINSTANCE.getClaim_Issues();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationActivityParameterImpl <em>Verification Activity Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationActivityParameterImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationActivityParameter()
     * @generated
     */
    EClass VERIFICATION_ACTIVITY_PARAMETER = eINSTANCE.getVerificationActivityParameter();

    /**
     * The meta object literal for the '<em><b>Compute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY_PARAMETER__COMPUTE = eINSTANCE.getVerificationActivityParameter_Compute();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationActivityImpl <em>Verification Activity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationActivityImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationActivity()
     * @generated
     */
    EClass VERIFICATION_ACTIVITY = eINSTANCE.getVerificationActivity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY__NAME = eINSTANCE.getVerificationActivity_Name();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_ACTIVITY__METHOD = eINSTANCE.getVerificationActivity_Method();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY__PARAMETERS = eINSTANCE.getVerificationActivity_Parameters();

    /**
     * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_ACTIVITY__TIMEOUT = eINSTANCE.getVerificationActivity_Timeout();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationConditionImpl <em>Verification Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationConditionImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationCondition()
     * @generated
     */
    EClass VERIFICATION_CONDITION = eINSTANCE.getVerificationCondition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_CONDITION__NAME = eINSTANCE.getVerificationCondition_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_CONDITION__TITLE = eINSTANCE.getVerificationCondition_Title();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_CONDITION__DESCRIPTION = eINSTANCE.getVerificationCondition_Description();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_CONDITION__METHOD = eINSTANCE.getVerificationCondition_Method();

    /**
     * The meta object literal for the '<em><b>Compute Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_CONDITION__COMPUTE_VARIABLE = eINSTANCE.getVerificationCondition_ComputeVariable();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_CONDITION__RATIONALE = eINSTANCE.getVerificationCondition_Rationale();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.ArgumentExprImpl <em>Argument Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.ArgumentExprImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getArgumentExpr()
     * @generated
     */
    EClass ARGUMENT_EXPR = eINSTANCE.getArgumentExpr();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationMethodRegistryImpl <em>Verification Method Registry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationMethodRegistryImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationMethodRegistry()
     * @generated
     */
    EClass VERIFICATION_METHOD_REGISTRY = eINSTANCE.getVerificationMethodRegistry();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD_REGISTRY__NAME = eINSTANCE.getVerificationMethodRegistry_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD_REGISTRY__TITLE = eINSTANCE.getVerificationMethodRegistry_Title();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_METHOD_REGISTRY__DESCRIPTION = eINSTANCE.getVerificationMethodRegistry_Description();

    /**
     * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_METHOD_REGISTRY__METHODS = eINSTANCE.getVerificationMethodRegistry_Methods();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationMethodParameterImpl <em>Verification Method Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationMethodParameterImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationMethodParameter()
     * @generated
     */
    EClass VERIFICATION_METHOD_PARAMETER = eINSTANCE.getVerificationMethodParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD_PARAMETER__NAME = eINSTANCE.getVerificationMethodParameter_Name();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationMethodImpl <em>Verification Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationMethodImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationMethod()
     * @generated
     */
    EClass VERIFICATION_METHOD = eINSTANCE.getVerificationMethod();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD__NAME = eINSTANCE.getVerificationMethod_Name();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD__PARAMS = eINSTANCE.getVerificationMethod_Params();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD__TITLE = eINSTANCE.getVerificationMethod_Title();

    /**
     * The meta object literal for the '<em><b>Method Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD__METHOD_TYPE = eINSTANCE.getVerificationMethod_MethodType();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD__SCOPE = eINSTANCE.getVerificationMethod_Scope();

    /**
     * The meta object literal for the '<em><b>Reporting</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD__REPORTING = eINSTANCE.getVerificationMethod_Reporting();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_METHOD__DESCRIPTION = eINSTANCE.getVerificationMethod_Description();

    /**
     * The meta object literal for the '<em><b>Method Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VERIFICATION_METHOD__METHOD_PATH = eINSTANCE.getVerificationMethod_MethodPath();

    /**
     * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_METHOD__CONDITIONS = eINSTANCE.getVerificationMethod_Conditions();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VERIFICATION_METHOD__CATEGORY = eINSTANCE.getVerificationMethod_Category();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationValidationImpl <em>Verification Validation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationValidationImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationValidation()
     * @generated
     */
    EClass VERIFICATION_VALIDATION = eINSTANCE.getVerificationValidation();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.VerificationPreconditionImpl <em>Verification Precondition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.VerificationPreconditionImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getVerificationPrecondition()
     * @generated
     */
    EClass VERIFICATION_PRECONDITION = eINSTANCE.getVerificationPrecondition();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.AllExprImpl <em>All Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.AllExprImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getAllExpr()
     * @generated
     */
    EClass ALL_EXPR = eINSTANCE.getAllExpr();

    /**
     * The meta object literal for the '<em><b>All</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALL_EXPR__ALL = eINSTANCE.getAllExpr_All();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.AndThenExprImpl <em>And Then Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.AndThenExprImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getAndThenExpr()
     * @generated
     */
    EClass AND_THEN_EXPR = eINSTANCE.getAndThenExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_THEN_EXPR__LEFT = eINSTANCE.getAndThenExpr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_THEN_EXPR__RIGHT = eINSTANCE.getAndThenExpr_Right();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.FailThenExprImpl <em>Fail Then Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.FailThenExprImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getFailThenExpr()
     * @generated
     */
    EClass FAIL_THEN_EXPR = eINSTANCE.getFailThenExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAIL_THEN_EXPR__LEFT = eINSTANCE.getFailThenExpr_Left();

    /**
     * The meta object literal for the '<em><b>Failed</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAIL_THEN_EXPR__FAILED = eINSTANCE.getFailThenExpr_Failed();

    /**
     * The meta object literal for the '<em><b>Unknown</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FAIL_THEN_EXPR__UNKNOWN = eINSTANCE.getFailThenExpr_Unknown();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAIL_THEN_EXPR__RIGHT = eINSTANCE.getFailThenExpr_Right();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.WhenExprImpl <em>When Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.WhenExprImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getWhenExpr()
     * @generated
     */
    EClass WHEN_EXPR = eINSTANCE.getWhenExpr();

    /**
     * The meta object literal for the '<em><b>Verification</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHEN_EXPR__VERIFICATION = eINSTANCE.getWhenExpr_Verification();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHEN_EXPR__CONDITION = eINSTANCE.getWhenExpr_Condition();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.impl.RefExprImpl <em>Ref Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.impl.RefExprImpl
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getRefExpr()
     * @generated
     */
    EClass REF_EXPR = eINSTANCE.getRefExpr();

    /**
     * The meta object literal for the '<em><b>Verification</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_EXPR__VERIFICATION = eINSTANCE.getRefExpr_Verification();

    /**
     * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REF_EXPR__WEIGHT = eINSTANCE.getRefExpr_Weight();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.SupportedTypes <em>Supported Types</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.SupportedTypes
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getSupportedTypes()
     * @generated
     */
    EEnum SUPPORTED_TYPES = eINSTANCE.getSupportedTypes();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.SupportedScopes <em>Supported Scopes</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.SupportedScopes
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getSupportedScopes()
     * @generated
     */
    EEnum SUPPORTED_SCOPES = eINSTANCE.getSupportedScopes();

    /**
     * The meta object literal for the '{@link org.osate.verify.verify.SupportedReporting <em>Supported Reporting</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.verify.verify.SupportedReporting
     * @see org.osate.verify.verify.impl.VerifyPackageImpl#getSupportedReporting()
     * @generated
     */
    EEnum SUPPORTED_REPORTING = eINSTANCE.getSupportedReporting();

  }

} //VerifyPackage
