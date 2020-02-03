/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
public interface AssurePackage extends EPackage {
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
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSURE_RESULT__METRICS = 0;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSURE_RESULT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.AssuranceCaseResultImpl <em>Assurance Case Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.AssuranceCaseResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceCaseResult()
	 * @generated
	 */
	int ASSURANCE_CASE_RESULT = 0;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSURANCE_CASE_RESULT__METRICS = ASSURE_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSURANCE_CASE_RESULT__NAME = ASSURE_RESULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSURANCE_CASE_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSURANCE_CASE_RESULT__MODEL_RESULT = ASSURE_RESULT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assurance Case Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSURANCE_CASE_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.ModelResultImpl <em>Model Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.ModelResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getModelResult()
	 * @generated
	 */
	int MODEL_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT__METRICS = ASSURE_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Plan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT__PLAN = ASSURE_RESULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT__TARGET = ASSURE_RESULT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT__CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Subsystem Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT__SUBSYSTEM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sub Assurance Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT__SUB_ASSURANCE_CASE = ASSURE_RESULT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Model Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.SubsystemResultImpl <em>Subsystem Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.SubsystemResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getSubsystemResult()
	 * @generated
	 */
	int SUBSYSTEM_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_RESULT__METRICS = ASSURE_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Target System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_RESULT__TARGET_SYSTEM = ASSURE_RESULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Claim Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_RESULT__CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Subsystem Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_RESULT__SUBSYSTEM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Subsystem Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.ClaimResultImpl <em>Claim Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.ClaimResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getClaimResult()
	 * @generated
	 */
	int CLAIM_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAIM_RESULT__METRICS = ASSURE_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Target Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAIM_RESULT__TARGET_REFERENCE = ASSURE_RESULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAIM_RESULT__MODEL_ELEMENT = ASSURE_RESULT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAIM_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Claim Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAIM_RESULT__SUB_CLAIM_RESULT = ASSURE_RESULT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Verification Activity Result</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAIM_RESULT__VERIFICATION_ACTIVITY_RESULT = ASSURE_RESULT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Predicate Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLAIM_RESULT__PREDICATE_RESULT = ASSURE_RESULT_FEATURE_COUNT + 5;

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
	int VERIFICATION_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_RESULT__METRICS = ASSURE_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_RESULT__TYPE = ASSURE_RESULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_RESULT__ISSUES = ASSURE_RESULT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_RESULT__RESULTS = ASSURE_RESULT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_RESULT__MESSAGE = ASSURE_RESULT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Analysisresult</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.0
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_RESULT__ANALYSISRESULT = ASSURE_RESULT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Verification Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_RESULT_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 5;

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
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_EXPR__METRICS = ASSURE_RESULT__METRICS;

	/**
	 * The number of structural features of the '<em>Verification Expr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_EXPR_FEATURE_COUNT = ASSURE_RESULT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.ElseResultImpl <em>Else Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.ElseResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getElseResult()
	 * @generated
	 */
	int ELSE_RESULT = 7;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_RESULT__METRICS = VERIFICATION_EXPR__METRICS;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_RESULT__FIRST = VERIFICATION_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_RESULT__ERROR = VERIFICATION_EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_RESULT__FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timeout</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_RESULT__TIMEOUT = VERIFICATION_EXPR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Did Fail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_RESULT__DID_FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Else Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELSE_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.ThenResultImpl <em>Then Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.ThenResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getThenResult()
	 * @generated
	 */
	int THEN_RESULT = 8;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_RESULT__METRICS = VERIFICATION_EXPR__METRICS;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_RESULT__FIRST = VERIFICATION_EXPR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_RESULT__SECOND = VERIFICATION_EXPR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Did Then Fail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_RESULT__DID_THEN_FAIL = VERIFICATION_EXPR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Then Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_RESULT_FEATURE_COUNT = VERIFICATION_EXPR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.MetricsImpl <em>Metrics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.MetricsImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getMetrics()
	 * @generated
	 */
	int METRICS = 9;

	/**
	 * The feature id for the '<em><b>Tbd Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__TBD_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Success Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__SUCCESS_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Fail Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__FAIL_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Error Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__ERROR_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Didelse Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__DIDELSE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Thenskip Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__THENSKIP_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Preconditionfail Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__PRECONDITIONFAIL_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Validationfail Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__VALIDATIONFAIL_COUNT = 7;

	/**
	 * The feature id for the '<em><b>Features Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__FEATURES_COUNT = 8;

	/**
	 * The feature id for the '<em><b>Features Requirements Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__FEATURES_REQUIREMENTS_COUNT = 9;

	/**
	 * The feature id for the '<em><b>Quality Category Requirements Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Total Quality Category Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__TOTAL_QUALITY_CATEGORY_COUNT = 11;

	/**
	 * The feature id for the '<em><b>Requirements Without Plan Claim Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT = 12;

	/**
	 * The feature id for the '<em><b>No Verification Plans Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__NO_VERIFICATION_PLANS_COUNT = 13;

	/**
	 * The feature id for the '<em><b>Requirements Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__REQUIREMENTS_COUNT = 14;

	/**
	 * The feature id for the '<em><b>Exceptions Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__EXCEPTIONS_COUNT = 15;

	/**
	 * The feature id for the '<em><b>Req Target Has EMV2 Subclause Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT = 16;

	/**
	 * The feature id for the '<em><b>Features Requiring Classifier Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT = 17;

	/**
	 * The feature id for the '<em><b>Features With Required Classifier Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT = 18;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__WEIGHT = 19;

	/**
	 * The feature id for the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS__EXECUTION_TIME = 20;

	/**
	 * The number of structural features of the '<em>Metrics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRICS_FEATURE_COUNT = 21;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl <em>Qualified Verification Plan Element Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVerificationPlanElementReference()
	 * @generated
	 */
	int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Verification Plan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN = 0;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT = 1;

	/**
	 * The number of structural features of the '<em>Qualified Verification Plan Element Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.QualifiedClaimReferenceImpl <em>Qualified Claim Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.QualifiedClaimReferenceImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedClaimReference()
	 * @generated
	 */
	int QUALIFIED_CLAIM_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Verification Plan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLAIM_REFERENCE__VERIFICATION_PLAN = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLAIM_REFERENCE__REQUIREMENT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT;

	/**
	 * The number of structural features of the '<em>Qualified Claim Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_CLAIM_REFERENCE_FEATURE_COUNT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl <em>Qualified VA Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.QualifiedVAReferenceImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVAReference()
	 * @generated
	 */
	int QUALIFIED_VA_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>Verification Plan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_VA_REFERENCE__VERIFICATION_PLAN = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_VA_REFERENCE__REQUIREMENT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Verification Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Qualified VA Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALIFIED_VA_REFERENCE_FEATURE_COUNT = QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.NestedClaimReferenceImpl <em>Nested Claim Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.NestedClaimReferenceImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getNestedClaimReference()
	 * @generated
	 */
	int NESTED_CLAIM_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_CLAIM_REFERENCE__REQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Sub</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_CLAIM_REFERENCE__SUB = 1;

	/**
	 * The number of structural features of the '<em>Nested Claim Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_CLAIM_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.PreconditionResultImpl <em>Precondition Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.PreconditionResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getPreconditionResult()
	 * @generated
	 */
	int PRECONDITION_RESULT = 14;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_RESULT__METRICS = VERIFICATION_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_RESULT__TYPE = VERIFICATION_RESULT__TYPE;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_RESULT__RESULTS = VERIFICATION_RESULT__RESULTS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

	/**
	 * The feature id for the '<em><b>Analysisresult</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.0
	 * @generated
	 * @ordered
	 */
	int PRECONDITION_RESULT__ANALYSISRESULT = VERIFICATION_RESULT__ANALYSISRESULT;

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
	 * The meta object id for the '{@link org.osate.assure.assure.impl.ValidationResultImpl <em>Validation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.ValidationResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getValidationResult()
	 * @generated
	 */
	int VALIDATION_RESULT = 15;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RESULT__METRICS = VERIFICATION_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RESULT__TYPE = VERIFICATION_RESULT__TYPE;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RESULT__RESULTS = VERIFICATION_RESULT__RESULTS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

	/**
	 * The feature id for the '<em><b>Analysisresult</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.0
	 * @generated
	 * @ordered
	 */
	int VALIDATION_RESULT__ANALYSISRESULT = VERIFICATION_RESULT__ANALYSISRESULT;

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
	 * The meta object id for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
	 * @generated
	 */
	int VERIFICATION_ACTIVITY_RESULT = 16;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__METRICS = VERIFICATION_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__TYPE = VERIFICATION_RESULT__TYPE;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__RESULTS = VERIFICATION_RESULT__RESULTS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

	/**
	 * The feature id for the '<em><b>Analysisresult</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.0
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__ANALYSISRESULT = VERIFICATION_RESULT__ANALYSISRESULT;

	/**
	 * The feature id for the '<em><b>Target Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__TARGET_REFERENCE = VERIFICATION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Precondition Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Validation Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT = VERIFICATION_RESULT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Verification Activity Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_ACTIVITY_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.assure.assure.impl.PredicateResultImpl <em>Predicate Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.assure.assure.impl.PredicateResultImpl
	 * @see org.osate.assure.assure.impl.AssurePackageImpl#getPredicateResult()
	 * @generated
	 */
	int PREDICATE_RESULT = 17;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT__METRICS = VERIFICATION_RESULT__METRICS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT__TYPE = VERIFICATION_RESULT__TYPE;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT__ISSUES = VERIFICATION_RESULT__ISSUES;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT__RESULTS = VERIFICATION_RESULT__RESULTS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT__MESSAGE = VERIFICATION_RESULT__MESSAGE;

	/**
	 * The feature id for the '<em><b>Analysisresult</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.0
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT__ANALYSISRESULT = VERIFICATION_RESULT__ANALYSISRESULT;

	/**
	 * The feature id for the '<em><b>Target Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT__TARGET_REFERENCE = VERIFICATION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Predicate Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_RESULT_FEATURE_COUNT = VERIFICATION_RESULT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.AssuranceCaseResult <em>Assurance Case Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assurance Case Result</em>'.
	 * @see org.osate.assure.assure.AssuranceCaseResult
	 * @generated
	 */
	EClass getAssuranceCaseResult();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssuranceCaseResult#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.assure.assure.AssuranceCaseResult#getName()
	 * @see #getAssuranceCaseResult()
	 * @generated
	 */
	EAttribute getAssuranceCaseResult_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.AssuranceCaseResult#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.assure.assure.AssuranceCaseResult#getMessage()
	 * @see #getAssuranceCaseResult()
	 * @generated
	 */
	EAttribute getAssuranceCaseResult_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.AssuranceCaseResult#getModelResult <em>Model Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Result</em>'.
	 * @see org.osate.assure.assure.AssuranceCaseResult#getModelResult()
	 * @see #getAssuranceCaseResult()
	 * @generated
	 */
	EReference getAssuranceCaseResult_ModelResult();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.ModelResult <em>Model Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Result</em>'.
	 * @see org.osate.assure.assure.ModelResult
	 * @generated
	 */
	EClass getModelResult();

	/**
	 * Returns the meta object for the reference '{@link org.osate.assure.assure.ModelResult#getPlan <em>Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Plan</em>'.
	 * @see org.osate.assure.assure.ModelResult#getPlan()
	 * @see #getModelResult()
	 * @generated
	 */
	EReference getModelResult_Plan();

	/**
	 * Returns the meta object for the reference '{@link org.osate.assure.assure.ModelResult#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.osate.assure.assure.ModelResult#getTarget()
	 * @see #getModelResult()
	 * @generated
	 */
	EReference getModelResult_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.ModelResult#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.assure.assure.ModelResult#getMessage()
	 * @see #getModelResult()
	 * @generated
	 */
	EAttribute getModelResult_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ModelResult#getClaimResult <em>Claim Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Claim Result</em>'.
	 * @see org.osate.assure.assure.ModelResult#getClaimResult()
	 * @see #getModelResult()
	 * @generated
	 */
	EReference getModelResult_ClaimResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ModelResult#getSubsystemResult <em>Subsystem Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subsystem Result</em>'.
	 * @see org.osate.assure.assure.ModelResult#getSubsystemResult()
	 * @see #getModelResult()
	 * @generated
	 */
	EReference getModelResult_SubsystemResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ModelResult#getSubAssuranceCase <em>Sub Assurance Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Assurance Case</em>'.
	 * @see org.osate.assure.assure.ModelResult#getSubAssuranceCase()
	 * @see #getModelResult()
	 * @generated
	 */
	EReference getModelResult_SubAssuranceCase();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.SubsystemResult <em>Subsystem Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Result</em>'.
	 * @see org.osate.assure.assure.SubsystemResult
	 * @generated
	 */
	EClass getSubsystemResult();

	/**
	 * Returns the meta object for the reference '{@link org.osate.assure.assure.SubsystemResult#getTargetSystem <em>Target System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target System</em>'.
	 * @see org.osate.assure.assure.SubsystemResult#getTargetSystem()
	 * @see #getSubsystemResult()
	 * @generated
	 */
	EReference getSubsystemResult_TargetSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.SubsystemResult#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.assure.assure.SubsystemResult#getMessage()
	 * @see #getSubsystemResult()
	 * @generated
	 */
	EAttribute getSubsystemResult_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.SubsystemResult#getClaimResult <em>Claim Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Claim Result</em>'.
	 * @see org.osate.assure.assure.SubsystemResult#getClaimResult()
	 * @see #getSubsystemResult()
	 * @generated
	 */
	EReference getSubsystemResult_ClaimResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.SubsystemResult#getSubsystemResult <em>Subsystem Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subsystem Result</em>'.
	 * @see org.osate.assure.assure.SubsystemResult#getSubsystemResult()
	 * @see #getSubsystemResult()
	 * @generated
	 */
	EReference getSubsystemResult_SubsystemResult();

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
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.ClaimResult#getTargetReference <em>Target Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Reference</em>'.
	 * @see org.osate.assure.assure.ClaimResult#getTargetReference()
	 * @see #getClaimResult()
	 * @generated
	 */
	EReference getClaimResult_TargetReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.assure.assure.ClaimResult#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see org.osate.assure.assure.ClaimResult#getModelElement()
	 * @see #getClaimResult()
	 * @generated
	 */
	EReference getClaimResult_ModelElement();

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
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.ClaimResult#getPredicateResult <em>Predicate Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate Result</em>'.
	 * @see org.osate.assure.assure.ClaimResult#getPredicateResult()
	 * @see #getClaimResult()
	 * @generated
	 */
	EReference getClaimResult_PredicateResult();

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
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationResult#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.osate.assure.assure.VerificationResult#getResults()
	 * @see #getVerificationResult()
	 * @generated
	 */
	EReference getVerificationResult_Results();

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
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.VerificationResult#getAnalysisresult <em>Analysisresult</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Analysisresult</em>'.
	 * @see org.osate.assure.assure.VerificationResult#getAnalysisresult()
	 * @see #getVerificationResult()
	 * @since 2.0
	 * @generated
	 */
	EReference getVerificationResult_Analysisresult();

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
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.AssureResult#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Metrics</em>'.
	 * @see org.osate.assure.assure.AssureResult#getMetrics()
	 * @see #getAssureResult()
	 * @generated
	 */
	EReference getAssureResult_Metrics();

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
	 * Returns the meta object for class '{@link org.osate.assure.assure.ElseResult <em>Else Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Else Result</em>'.
	 * @see org.osate.assure.assure.ElseResult
	 * @generated
	 */
	EClass getElseResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>First</em>'.
	 * @see org.osate.assure.assure.ElseResult#getFirst()
	 * @see #getElseResult()
	 * @generated
	 */
	EReference getElseResult_First();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error</em>'.
	 * @see org.osate.assure.assure.ElseResult#getError()
	 * @see #getElseResult()
	 * @generated
	 */
	EReference getElseResult_Error();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getFail <em>Fail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fail</em>'.
	 * @see org.osate.assure.assure.ElseResult#getFail()
	 * @see #getElseResult()
	 * @generated
	 */
	EReference getElseResult_Fail();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ElseResult#getTimeout <em>Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Timeout</em>'.
	 * @see org.osate.assure.assure.ElseResult#getTimeout()
	 * @see #getElseResult()
	 * @generated
	 */
	EReference getElseResult_Timeout();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.ElseResult#getDidFail <em>Did Fail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Did Fail</em>'.
	 * @see org.osate.assure.assure.ElseResult#getDidFail()
	 * @see #getElseResult()
	 * @generated
	 */
	EAttribute getElseResult_DidFail();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.ThenResult <em>Then Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Then Result</em>'.
	 * @see org.osate.assure.assure.ThenResult
	 * @generated
	 */
	EClass getThenResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ThenResult#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>First</em>'.
	 * @see org.osate.assure.assure.ThenResult#getFirst()
	 * @see #getThenResult()
	 * @generated
	 */
	EReference getThenResult_First();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.assure.assure.ThenResult#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Second</em>'.
	 * @see org.osate.assure.assure.ThenResult#getSecond()
	 * @see #getThenResult()
	 * @generated
	 */
	EReference getThenResult_Second();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.ThenResult#isDidThenFail <em>Did Then Fail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Did Then Fail</em>'.
	 * @see org.osate.assure.assure.ThenResult#isDidThenFail()
	 * @see #getThenResult()
	 * @generated
	 */
	EAttribute getThenResult_DidThenFail();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.Metrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metrics</em>'.
	 * @see org.osate.assure.assure.Metrics
	 * @generated
	 */
	EClass getMetrics();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getTbdCount <em>Tbd Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tbd Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getTbdCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_TbdCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getSuccessCount <em>Success Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getSuccessCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_SuccessCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getFailCount <em>Fail Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fail Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getFailCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_FailCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getErrorCount <em>Error Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getErrorCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_ErrorCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getDidelseCount <em>Didelse Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Didelse Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getDidelseCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_DidelseCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getThenskipCount <em>Thenskip Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thenskip Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getThenskipCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_ThenskipCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getPreconditionfailCount <em>Preconditionfail Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preconditionfail Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getPreconditionfailCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_PreconditionfailCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getValidationfailCount <em>Validationfail Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validationfail Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getValidationfailCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_ValidationfailCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getFeaturesCount <em>Features Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Features Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getFeaturesCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_FeaturesCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getFeaturesRequirementsCount <em>Features Requirements Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Features Requirements Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getFeaturesRequirementsCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_FeaturesRequirementsCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getQualityCategoryRequirementsCount <em>Quality Category Requirements Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Category Requirements Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getQualityCategoryRequirementsCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_QualityCategoryRequirementsCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getTotalQualityCategoryCount <em>Total Quality Category Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Quality Category Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getTotalQualityCategoryCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_TotalQualityCategoryCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getRequirementsWithoutPlanClaimCount <em>Requirements Without Plan Claim Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirements Without Plan Claim Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getRequirementsWithoutPlanClaimCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_RequirementsWithoutPlanClaimCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getNoVerificationPlansCount <em>No Verification Plans Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No Verification Plans Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getNoVerificationPlansCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_NoVerificationPlansCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getRequirementsCount <em>Requirements Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirements Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getRequirementsCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_RequirementsCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getExceptionsCount <em>Exceptions Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exceptions Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getExceptionsCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_ExceptionsCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getReqTargetHasEMV2SubclauseCount <em>Req Target Has EMV2 Subclause Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req Target Has EMV2 Subclause Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getReqTargetHasEMV2SubclauseCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_ReqTargetHasEMV2SubclauseCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getFeaturesRequiringClassifierCount <em>Features Requiring Classifier Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Features Requiring Classifier Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getFeaturesRequiringClassifierCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_FeaturesRequiringClassifierCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getFeaturesWithRequiredClassifierCount <em>Features With Required Classifier Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Features With Required Classifier Count</em>'.
	 * @see org.osate.assure.assure.Metrics#getFeaturesWithRequiredClassifierCount()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_FeaturesWithRequiredClassifierCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.osate.assure.assure.Metrics#getWeight()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_Weight();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.assure.assure.Metrics#getExecutionTime <em>Execution Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Time</em>'.
	 * @see org.osate.assure.assure.Metrics#getExecutionTime()
	 * @see #getMetrics()
	 * @generated
	 */
	EAttribute getMetrics_ExecutionTime();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.QualifiedVerificationPlanElementReference <em>Qualified Verification Plan Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Verification Plan Element Reference</em>'.
	 * @see org.osate.assure.assure.QualifiedVerificationPlanElementReference
	 * @generated
	 */
	EClass getQualifiedVerificationPlanElementReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.assure.assure.QualifiedVerificationPlanElementReference#getVerificationPlan <em>Verification Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Verification Plan</em>'.
	 * @see org.osate.assure.assure.QualifiedVerificationPlanElementReference#getVerificationPlan()
	 * @see #getQualifiedVerificationPlanElementReference()
	 * @generated
	 */
	EReference getQualifiedVerificationPlanElementReference_VerificationPlan();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.QualifiedVerificationPlanElementReference#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requirement</em>'.
	 * @see org.osate.assure.assure.QualifiedVerificationPlanElementReference#getRequirement()
	 * @see #getQualifiedVerificationPlanElementReference()
	 * @generated
	 */
	EReference getQualifiedVerificationPlanElementReference_Requirement();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.QualifiedClaimReference <em>Qualified Claim Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Claim Reference</em>'.
	 * @see org.osate.assure.assure.QualifiedClaimReference
	 * @generated
	 */
	EClass getQualifiedClaimReference();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.QualifiedVAReference <em>Qualified VA Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified VA Reference</em>'.
	 * @see org.osate.assure.assure.QualifiedVAReference
	 * @generated
	 */
	EClass getQualifiedVAReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.assure.assure.QualifiedVAReference#getVerificationActivity <em>Verification Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Verification Activity</em>'.
	 * @see org.osate.assure.assure.QualifiedVAReference#getVerificationActivity()
	 * @see #getQualifiedVAReference()
	 * @generated
	 */
	EReference getQualifiedVAReference_VerificationActivity();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.NestedClaimReference <em>Nested Claim Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested Claim Reference</em>'.
	 * @see org.osate.assure.assure.NestedClaimReference
	 * @generated
	 */
	EClass getNestedClaimReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.assure.assure.NestedClaimReference#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Requirement</em>'.
	 * @see org.osate.assure.assure.NestedClaimReference#getRequirement()
	 * @see #getNestedClaimReference()
	 * @generated
	 */
	EReference getNestedClaimReference_Requirement();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.NestedClaimReference#getSub <em>Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sub</em>'.
	 * @see org.osate.assure.assure.NestedClaimReference#getSub()
	 * @see #getNestedClaimReference()
	 * @generated
	 */
	EReference getNestedClaimReference_Sub();

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
	 * Returns the meta object for class '{@link org.osate.assure.assure.VerificationActivityResult <em>Verification Activity Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verification Activity Result</em>'.
	 * @see org.osate.assure.assure.VerificationActivityResult
	 * @generated
	 */
	EClass getVerificationActivityResult();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.VerificationActivityResult#getTargetReference <em>Target Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Reference</em>'.
	 * @see org.osate.assure.assure.VerificationActivityResult#getTargetReference()
	 * @see #getVerificationActivityResult()
	 * @generated
	 */
	EReference getVerificationActivityResult_TargetReference();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.VerificationActivityResult#getPreconditionResult <em>Precondition Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Precondition Result</em>'.
	 * @see org.osate.assure.assure.VerificationActivityResult#getPreconditionResult()
	 * @see #getVerificationActivityResult()
	 * @generated
	 */
	EReference getVerificationActivityResult_PreconditionResult();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.VerificationActivityResult#getValidationResult <em>Validation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Validation Result</em>'.
	 * @see org.osate.assure.assure.VerificationActivityResult#getValidationResult()
	 * @see #getVerificationActivityResult()
	 * @generated
	 */
	EReference getVerificationActivityResult_ValidationResult();

	/**
	 * Returns the meta object for class '{@link org.osate.assure.assure.PredicateResult <em>Predicate Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Result</em>'.
	 * @see org.osate.assure.assure.PredicateResult
	 * @generated
	 */
	EClass getPredicateResult();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.assure.assure.PredicateResult#getTargetReference <em>Target Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Reference</em>'.
	 * @see org.osate.assure.assure.PredicateResult#getTargetReference()
	 * @see #getPredicateResult()
	 * @generated
	 */
	EReference getPredicateResult_TargetReference();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.AssuranceCaseResultImpl <em>Assurance Case Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.AssuranceCaseResultImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getAssuranceCaseResult()
		 * @generated
		 */
		EClass ASSURANCE_CASE_RESULT = eINSTANCE.getAssuranceCaseResult();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSURANCE_CASE_RESULT__NAME = eINSTANCE.getAssuranceCaseResult_Name();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSURANCE_CASE_RESULT__MESSAGE = eINSTANCE.getAssuranceCaseResult_Message();

		/**
		 * The meta object literal for the '<em><b>Model Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSURANCE_CASE_RESULT__MODEL_RESULT = eINSTANCE.getAssuranceCaseResult_ModelResult();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.ModelResultImpl <em>Model Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.ModelResultImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getModelResult()
		 * @generated
		 */
		EClass MODEL_RESULT = eINSTANCE.getModelResult();

		/**
		 * The meta object literal for the '<em><b>Plan</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RESULT__PLAN = eINSTANCE.getModelResult_Plan();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RESULT__TARGET = eINSTANCE.getModelResult_Target();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_RESULT__MESSAGE = eINSTANCE.getModelResult_Message();

		/**
		 * The meta object literal for the '<em><b>Claim Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RESULT__CLAIM_RESULT = eINSTANCE.getModelResult_ClaimResult();

		/**
		 * The meta object literal for the '<em><b>Subsystem Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RESULT__SUBSYSTEM_RESULT = eINSTANCE.getModelResult_SubsystemResult();

		/**
		 * The meta object literal for the '<em><b>Sub Assurance Case</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RESULT__SUB_ASSURANCE_CASE = eINSTANCE.getModelResult_SubAssuranceCase();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.SubsystemResultImpl <em>Subsystem Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.SubsystemResultImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getSubsystemResult()
		 * @generated
		 */
		EClass SUBSYSTEM_RESULT = eINSTANCE.getSubsystemResult();

		/**
		 * The meta object literal for the '<em><b>Target System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_RESULT__TARGET_SYSTEM = eINSTANCE.getSubsystemResult_TargetSystem();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUBSYSTEM_RESULT__MESSAGE = eINSTANCE.getSubsystemResult_Message();

		/**
		 * The meta object literal for the '<em><b>Claim Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_RESULT__CLAIM_RESULT = eINSTANCE.getSubsystemResult_ClaimResult();

		/**
		 * The meta object literal for the '<em><b>Subsystem Result</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_RESULT__SUBSYSTEM_RESULT = eINSTANCE.getSubsystemResult_SubsystemResult();

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
		 * The meta object literal for the '<em><b>Target Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAIM_RESULT__TARGET_REFERENCE = eINSTANCE.getClaimResult_TargetReference();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAIM_RESULT__MODEL_ELEMENT = eINSTANCE.getClaimResult_ModelElement();

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
		 * The meta object literal for the '<em><b>Predicate Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLAIM_RESULT__PREDICATE_RESULT = eINSTANCE.getClaimResult_PredicateResult();

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
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFICATION_RESULT__TYPE = eINSTANCE.getVerificationResult_Type();

		/**
		 * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFICATION_RESULT__ISSUES = eINSTANCE.getVerificationResult_Issues();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFICATION_RESULT__RESULTS = eINSTANCE.getVerificationResult_Results();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFICATION_RESULT__MESSAGE = eINSTANCE.getVerificationResult_Message();

		/**
		 * The meta object literal for the '<em><b>Analysisresult</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @since 2.0
		 * @generated
		 */
		EReference VERIFICATION_RESULT__ANALYSISRESULT = eINSTANCE.getVerificationResult_Analysisresult();

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
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSURE_RESULT__METRICS = eINSTANCE.getAssureResult_Metrics();

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
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.ElseResultImpl <em>Else Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.ElseResultImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getElseResult()
		 * @generated
		 */
		EClass ELSE_RESULT = eINSTANCE.getElseResult();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_RESULT__FIRST = eINSTANCE.getElseResult_First();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_RESULT__ERROR = eINSTANCE.getElseResult_Error();

		/**
		 * The meta object literal for the '<em><b>Fail</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_RESULT__FAIL = eINSTANCE.getElseResult_Fail();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELSE_RESULT__TIMEOUT = eINSTANCE.getElseResult_Timeout();

		/**
		 * The meta object literal for the '<em><b>Did Fail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELSE_RESULT__DID_FAIL = eINSTANCE.getElseResult_DidFail();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.ThenResultImpl <em>Then Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.ThenResultImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getThenResult()
		 * @generated
		 */
		EClass THEN_RESULT = eINSTANCE.getThenResult();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THEN_RESULT__FIRST = eINSTANCE.getThenResult_First();

		/**
		 * The meta object literal for the '<em><b>Second</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THEN_RESULT__SECOND = eINSTANCE.getThenResult_Second();

		/**
		 * The meta object literal for the '<em><b>Did Then Fail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THEN_RESULT__DID_THEN_FAIL = eINSTANCE.getThenResult_DidThenFail();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.MetricsImpl <em>Metrics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.MetricsImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getMetrics()
		 * @generated
		 */
		EClass METRICS = eINSTANCE.getMetrics();

		/**
		 * The meta object literal for the '<em><b>Tbd Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__TBD_COUNT = eINSTANCE.getMetrics_TbdCount();

		/**
		 * The meta object literal for the '<em><b>Success Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__SUCCESS_COUNT = eINSTANCE.getMetrics_SuccessCount();

		/**
		 * The meta object literal for the '<em><b>Fail Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__FAIL_COUNT = eINSTANCE.getMetrics_FailCount();

		/**
		 * The meta object literal for the '<em><b>Error Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__ERROR_COUNT = eINSTANCE.getMetrics_ErrorCount();

		/**
		 * The meta object literal for the '<em><b>Didelse Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__DIDELSE_COUNT = eINSTANCE.getMetrics_DidelseCount();

		/**
		 * The meta object literal for the '<em><b>Thenskip Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__THENSKIP_COUNT = eINSTANCE.getMetrics_ThenskipCount();

		/**
		 * The meta object literal for the '<em><b>Preconditionfail Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__PRECONDITIONFAIL_COUNT = eINSTANCE.getMetrics_PreconditionfailCount();

		/**
		 * The meta object literal for the '<em><b>Validationfail Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__VALIDATIONFAIL_COUNT = eINSTANCE.getMetrics_ValidationfailCount();

		/**
		 * The meta object literal for the '<em><b>Features Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__FEATURES_COUNT = eINSTANCE.getMetrics_FeaturesCount();

		/**
		 * The meta object literal for the '<em><b>Features Requirements Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__FEATURES_REQUIREMENTS_COUNT = eINSTANCE.getMetrics_FeaturesRequirementsCount();

		/**
		 * The meta object literal for the '<em><b>Quality Category Requirements Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT = eINSTANCE.getMetrics_QualityCategoryRequirementsCount();

		/**
		 * The meta object literal for the '<em><b>Total Quality Category Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__TOTAL_QUALITY_CATEGORY_COUNT = eINSTANCE.getMetrics_TotalQualityCategoryCount();

		/**
		 * The meta object literal for the '<em><b>Requirements Without Plan Claim Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT = eINSTANCE.getMetrics_RequirementsWithoutPlanClaimCount();

		/**
		 * The meta object literal for the '<em><b>No Verification Plans Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__NO_VERIFICATION_PLANS_COUNT = eINSTANCE.getMetrics_NoVerificationPlansCount();

		/**
		 * The meta object literal for the '<em><b>Requirements Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__REQUIREMENTS_COUNT = eINSTANCE.getMetrics_RequirementsCount();

		/**
		 * The meta object literal for the '<em><b>Exceptions Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__EXCEPTIONS_COUNT = eINSTANCE.getMetrics_ExceptionsCount();

		/**
		 * The meta object literal for the '<em><b>Req Target Has EMV2 Subclause Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT = eINSTANCE.getMetrics_ReqTargetHasEMV2SubclauseCount();

		/**
		 * The meta object literal for the '<em><b>Features Requiring Classifier Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT = eINSTANCE.getMetrics_FeaturesRequiringClassifierCount();

		/**
		 * The meta object literal for the '<em><b>Features With Required Classifier Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT = eINSTANCE.getMetrics_FeaturesWithRequiredClassifierCount();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__WEIGHT = eINSTANCE.getMetrics_Weight();

		/**
		 * The meta object literal for the '<em><b>Execution Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRICS__EXECUTION_TIME = eINSTANCE.getMetrics_ExecutionTime();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl <em>Qualified Verification Plan Element Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.QualifiedVerificationPlanElementReferenceImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVerificationPlanElementReference()
		 * @generated
		 */
		EClass QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE = eINSTANCE.getQualifiedVerificationPlanElementReference();

		/**
		 * The meta object literal for the '<em><b>Verification Plan</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__VERIFICATION_PLAN = eINSTANCE.getQualifiedVerificationPlanElementReference_VerificationPlan();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE__REQUIREMENT = eINSTANCE.getQualifiedVerificationPlanElementReference_Requirement();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.QualifiedClaimReferenceImpl <em>Qualified Claim Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.QualifiedClaimReferenceImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedClaimReference()
		 * @generated
		 */
		EClass QUALIFIED_CLAIM_REFERENCE = eINSTANCE.getQualifiedClaimReference();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.QualifiedVAReferenceImpl <em>Qualified VA Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.QualifiedVAReferenceImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getQualifiedVAReference()
		 * @generated
		 */
		EClass QUALIFIED_VA_REFERENCE = eINSTANCE.getQualifiedVAReference();

		/**
		 * The meta object literal for the '<em><b>Verification Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_VA_REFERENCE__VERIFICATION_ACTIVITY = eINSTANCE.getQualifiedVAReference_VerificationActivity();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.NestedClaimReferenceImpl <em>Nested Claim Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.NestedClaimReferenceImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getNestedClaimReference()
		 * @generated
		 */
		EClass NESTED_CLAIM_REFERENCE = eINSTANCE.getNestedClaimReference();

		/**
		 * The meta object literal for the '<em><b>Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_CLAIM_REFERENCE__REQUIREMENT = eINSTANCE.getNestedClaimReference_Requirement();

		/**
		 * The meta object literal for the '<em><b>Sub</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_CLAIM_REFERENCE__SUB = eINSTANCE.getNestedClaimReference_Sub();

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
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.VerificationActivityResultImpl <em>Verification Activity Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.VerificationActivityResultImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getVerificationActivityResult()
		 * @generated
		 */
		EClass VERIFICATION_ACTIVITY_RESULT = eINSTANCE.getVerificationActivityResult();

		/**
		 * The meta object literal for the '<em><b>Target Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFICATION_ACTIVITY_RESULT__TARGET_REFERENCE = eINSTANCE.getVerificationActivityResult_TargetReference();

		/**
		 * The meta object literal for the '<em><b>Precondition Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFICATION_ACTIVITY_RESULT__PRECONDITION_RESULT = eINSTANCE.getVerificationActivityResult_PreconditionResult();

		/**
		 * The meta object literal for the '<em><b>Validation Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERIFICATION_ACTIVITY_RESULT__VALIDATION_RESULT = eINSTANCE.getVerificationActivityResult_ValidationResult();

		/**
		 * The meta object literal for the '{@link org.osate.assure.assure.impl.PredicateResultImpl <em>Predicate Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.assure.assure.impl.PredicateResultImpl
		 * @see org.osate.assure.assure.impl.AssurePackageImpl#getPredicateResult()
		 * @generated
		 */
		EClass PREDICATE_RESULT = eINSTANCE.getPredicateResult();

		/**
		 * The meta object literal for the '<em><b>Target Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE_RESULT__TARGET_REFERENCE = eINSTANCE.getPredicateResult_TargetReference();

	}

} //AssurePackage
