/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.assure.assure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.Metrics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metrics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getTbdCount <em>Tbd Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getErrorCount <em>Error Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getDidelseCount <em>Didelse Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getThenskipCount <em>Thenskip Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getPreconditionfailCount <em>Preconditionfail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getValidationfailCount <em>Validationfail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getFeaturesCount <em>Features Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getFeaturesRequirementsCount <em>Features Requirements Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getQualityCategoryRequirementsCount <em>Quality Category Requirements Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getTotalQualityCategoryCount <em>Total Quality Category Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getRequirementsWithoutPlanClaimCount <em>Requirements Without Plan Claim Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getNoVerificationPlansCount <em>No Verification Plans Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getRequirementsCount <em>Requirements Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getExceptionsCount <em>Exceptions Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getReqTargetHasEMV2SubclauseCount <em>Req Target Has EMV2 Subclause Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getFeaturesRequiringClassifierCount <em>Features Requiring Classifier Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getFeaturesWithRequiredClassifierCount <em>Features With Required Classifier Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.impl.MetricsImpl#getExecutionTime <em>Execution Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetricsImpl extends MinimalEObjectImpl.Container implements Metrics {
	/**
	 * The default value of the '{@link #getTbdCount() <em>Tbd Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTbdCount()
	 * @generated
	 * @ordered
	 */
	protected static final int TBD_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTbdCount() <em>Tbd Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTbdCount()
	 * @generated
	 * @ordered
	 */
	protected int tbdCount = TBD_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuccessCount() <em>Success Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessCount()
	 * @generated
	 * @ordered
	 */
	protected static final int SUCCESS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSuccessCount() <em>Success Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessCount()
	 * @generated
	 * @ordered
	 */
	protected int successCount = SUCCESS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailCount() <em>Fail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailCount()
	 * @generated
	 * @ordered
	 */
	protected static final int FAIL_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFailCount() <em>Fail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailCount()
	 * @generated
	 * @ordered
	 */
	protected int failCount = FAIL_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrorCount() <em>Error Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCount()
	 * @generated
	 * @ordered
	 */
	protected static final int ERROR_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getErrorCount() <em>Error Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCount()
	 * @generated
	 * @ordered
	 */
	protected int errorCount = ERROR_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDidelseCount() <em>Didelse Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDidelseCount()
	 * @generated
	 * @ordered
	 */
	protected static final int DIDELSE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDidelseCount() <em>Didelse Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDidelseCount()
	 * @generated
	 * @ordered
	 */
	protected int didelseCount = DIDELSE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getThenskipCount() <em>Thenskip Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenskipCount()
	 * @generated
	 * @ordered
	 */
	protected static final int THENSKIP_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getThenskipCount() <em>Thenskip Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenskipCount()
	 * @generated
	 * @ordered
	 */
	protected int thenskipCount = THENSKIP_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreconditionfailCount() <em>Preconditionfail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditionfailCount()
	 * @generated
	 * @ordered
	 */
	protected static final int PRECONDITIONFAIL_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPreconditionfailCount() <em>Preconditionfail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditionfailCount()
	 * @generated
	 * @ordered
	 */
	protected int preconditionfailCount = PRECONDITIONFAIL_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidationfailCount() <em>Validationfail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationfailCount()
	 * @generated
	 * @ordered
	 */
	protected static final int VALIDATIONFAIL_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValidationfailCount() <em>Validationfail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationfailCount()
	 * @generated
	 * @ordered
	 */
	protected int validationfailCount = VALIDATIONFAIL_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeaturesCount() <em>Features Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesCount()
	 * @generated
	 * @ordered
	 */
	protected static final int FEATURES_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFeaturesCount() <em>Features Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesCount()
	 * @generated
	 * @ordered
	 */
	protected int featuresCount = FEATURES_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeaturesRequirementsCount() <em>Features Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesRequirementsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int FEATURES_REQUIREMENTS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFeaturesRequirementsCount() <em>Features Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesRequirementsCount()
	 * @generated
	 * @ordered
	 */
	protected int featuresRequirementsCount = FEATURES_REQUIREMENTS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualityCategoryRequirementsCount() <em>Quality Category Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityCategoryRequirementsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int QUALITY_CATEGORY_REQUIREMENTS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getQualityCategoryRequirementsCount() <em>Quality Category Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityCategoryRequirementsCount()
	 * @generated
	 * @ordered
	 */
	protected int qualityCategoryRequirementsCount = QUALITY_CATEGORY_REQUIREMENTS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalQualityCategoryCount() <em>Total Quality Category Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalQualityCategoryCount()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_QUALITY_CATEGORY_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalQualityCategoryCount() <em>Total Quality Category Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalQualityCategoryCount()
	 * @generated
	 * @ordered
	 */
	protected int totalQualityCategoryCount = TOTAL_QUALITY_CATEGORY_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequirementsWithoutPlanClaimCount() <em>Requirements Without Plan Claim Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementsWithoutPlanClaimCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRequirementsWithoutPlanClaimCount() <em>Requirements Without Plan Claim Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementsWithoutPlanClaimCount()
	 * @generated
	 * @ordered
	 */
	protected int requirementsWithoutPlanClaimCount = REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getNoVerificationPlansCount() <em>No Verification Plans Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoVerificationPlansCount()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_VERIFICATION_PLANS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNoVerificationPlansCount() <em>No Verification Plans Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoVerificationPlansCount()
	 * @generated
	 * @ordered
	 */
	protected int noVerificationPlansCount = NO_VERIFICATION_PLANS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequirementsCount() <em>Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIREMENTS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRequirementsCount() <em>Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementsCount()
	 * @generated
	 * @ordered
	 */
	protected int requirementsCount = REQUIREMENTS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExceptionsCount() <em>Exceptions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int EXCEPTIONS_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getExceptionsCount() <em>Exceptions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionsCount()
	 * @generated
	 * @ordered
	 */
	protected int exceptionsCount = EXCEPTIONS_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getReqTargetHasEMV2SubclauseCount() <em>Req Target Has EMV2 Subclause Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqTargetHasEMV2SubclauseCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReqTargetHasEMV2SubclauseCount() <em>Req Target Has EMV2 Subclause Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqTargetHasEMV2SubclauseCount()
	 * @generated
	 * @ordered
	 */
	protected int reqTargetHasEMV2SubclauseCount = REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeaturesRequiringClassifierCount() <em>Features Requiring Classifier Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesRequiringClassifierCount()
	 * @generated
	 * @ordered
	 */
	protected static final int FEATURES_REQUIRING_CLASSIFIER_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFeaturesRequiringClassifierCount() <em>Features Requiring Classifier Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesRequiringClassifierCount()
	 * @generated
	 * @ordered
	 */
	protected int featuresRequiringClassifierCount = FEATURES_REQUIRING_CLASSIFIER_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeaturesWithRequiredClassifierCount() <em>Features With Required Classifier Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesWithRequiredClassifierCount()
	 * @generated
	 * @ordered
	 */
	protected static final int FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFeaturesWithRequiredClassifierCount() <em>Features With Required Classifier Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesWithRequiredClassifierCount()
	 * @generated
	 * @ordered
	 */
	protected int featuresWithRequiredClassifierCount = FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected int weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected static final long EXECUTION_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getExecutionTime() <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionTime()
	 * @generated
	 * @ordered
	 */
	protected long executionTime = EXECUTION_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AssurePackage.Literals.METRICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTbdCount() {
		return tbdCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTbdCount(int newTbdCount) {
		int oldTbdCount = tbdCount;
		tbdCount = newTbdCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__TBD_COUNT, oldTbdCount, tbdCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSuccessCount() {
		return successCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuccessCount(int newSuccessCount) {
		int oldSuccessCount = successCount;
		successCount = newSuccessCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__SUCCESS_COUNT, oldSuccessCount, successCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFailCount() {
		return failCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFailCount(int newFailCount) {
		int oldFailCount = failCount;
		failCount = newFailCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__FAIL_COUNT, oldFailCount, failCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getErrorCount() {
		return errorCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setErrorCount(int newErrorCount) {
		int oldErrorCount = errorCount;
		errorCount = newErrorCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__ERROR_COUNT, oldErrorCount, errorCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDidelseCount() {
		return didelseCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDidelseCount(int newDidelseCount) {
		int oldDidelseCount = didelseCount;
		didelseCount = newDidelseCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__DIDELSE_COUNT, oldDidelseCount, didelseCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getThenskipCount() {
		return thenskipCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThenskipCount(int newThenskipCount) {
		int oldThenskipCount = thenskipCount;
		thenskipCount = newThenskipCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__THENSKIP_COUNT, oldThenskipCount, thenskipCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPreconditionfailCount() {
		return preconditionfailCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreconditionfailCount(int newPreconditionfailCount) {
		int oldPreconditionfailCount = preconditionfailCount;
		preconditionfailCount = newPreconditionfailCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__PRECONDITIONFAIL_COUNT, oldPreconditionfailCount, preconditionfailCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValidationfailCount() {
		return validationfailCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidationfailCount(int newValidationfailCount) {
		int oldValidationfailCount = validationfailCount;
		validationfailCount = newValidationfailCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__VALIDATIONFAIL_COUNT, oldValidationfailCount, validationfailCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFeaturesCount() {
		return featuresCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeaturesCount(int newFeaturesCount) {
		int oldFeaturesCount = featuresCount;
		featuresCount = newFeaturesCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__FEATURES_COUNT, oldFeaturesCount, featuresCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFeaturesRequirementsCount() {
		return featuresRequirementsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeaturesRequirementsCount(int newFeaturesRequirementsCount) {
		int oldFeaturesRequirementsCount = featuresRequirementsCount;
		featuresRequirementsCount = newFeaturesRequirementsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__FEATURES_REQUIREMENTS_COUNT, oldFeaturesRequirementsCount, featuresRequirementsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getQualityCategoryRequirementsCount() {
		return qualityCategoryRequirementsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQualityCategoryRequirementsCount(int newQualityCategoryRequirementsCount) {
		int oldQualityCategoryRequirementsCount = qualityCategoryRequirementsCount;
		qualityCategoryRequirementsCount = newQualityCategoryRequirementsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT, oldQualityCategoryRequirementsCount, qualityCategoryRequirementsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getTotalQualityCategoryCount() {
		return totalQualityCategoryCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTotalQualityCategoryCount(int newTotalQualityCategoryCount) {
		int oldTotalQualityCategoryCount = totalQualityCategoryCount;
		totalQualityCategoryCount = newTotalQualityCategoryCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__TOTAL_QUALITY_CATEGORY_COUNT, oldTotalQualityCategoryCount, totalQualityCategoryCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRequirementsWithoutPlanClaimCount() {
		return requirementsWithoutPlanClaimCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirementsWithoutPlanClaimCount(int newRequirementsWithoutPlanClaimCount) {
		int oldRequirementsWithoutPlanClaimCount = requirementsWithoutPlanClaimCount;
		requirementsWithoutPlanClaimCount = newRequirementsWithoutPlanClaimCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT, oldRequirementsWithoutPlanClaimCount, requirementsWithoutPlanClaimCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNoVerificationPlansCount() {
		return noVerificationPlansCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoVerificationPlansCount(int newNoVerificationPlansCount) {
		int oldNoVerificationPlansCount = noVerificationPlansCount;
		noVerificationPlansCount = newNoVerificationPlansCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__NO_VERIFICATION_PLANS_COUNT, oldNoVerificationPlansCount, noVerificationPlansCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRequirementsCount() {
		return requirementsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirementsCount(int newRequirementsCount) {
		int oldRequirementsCount = requirementsCount;
		requirementsCount = newRequirementsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__REQUIREMENTS_COUNT, oldRequirementsCount, requirementsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getExceptionsCount() {
		return exceptionsCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExceptionsCount(int newExceptionsCount) {
		int oldExceptionsCount = exceptionsCount;
		exceptionsCount = newExceptionsCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__EXCEPTIONS_COUNT, oldExceptionsCount, exceptionsCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getReqTargetHasEMV2SubclauseCount() {
		return reqTargetHasEMV2SubclauseCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReqTargetHasEMV2SubclauseCount(int newReqTargetHasEMV2SubclauseCount) {
		int oldReqTargetHasEMV2SubclauseCount = reqTargetHasEMV2SubclauseCount;
		reqTargetHasEMV2SubclauseCount = newReqTargetHasEMV2SubclauseCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT, oldReqTargetHasEMV2SubclauseCount, reqTargetHasEMV2SubclauseCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFeaturesRequiringClassifierCount() {
		return featuresRequiringClassifierCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeaturesRequiringClassifierCount(int newFeaturesRequiringClassifierCount) {
		int oldFeaturesRequiringClassifierCount = featuresRequiringClassifierCount;
		featuresRequiringClassifierCount = newFeaturesRequiringClassifierCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT, oldFeaturesRequiringClassifierCount, featuresRequiringClassifierCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFeaturesWithRequiredClassifierCount() {
		return featuresWithRequiredClassifierCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeaturesWithRequiredClassifierCount(int newFeaturesWithRequiredClassifierCount) {
		int oldFeaturesWithRequiredClassifierCount = featuresWithRequiredClassifierCount;
		featuresWithRequiredClassifierCount = newFeaturesWithRequiredClassifierCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT, oldFeaturesWithRequiredClassifierCount, featuresWithRequiredClassifierCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWeight(int newWeight) {
		int oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getExecutionTime() {
		return executionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecutionTime(long newExecutionTime) {
		long oldExecutionTime = executionTime;
		executionTime = newExecutionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AssurePackage.METRICS__EXECUTION_TIME, oldExecutionTime, executionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AssurePackage.METRICS__TBD_COUNT:
				return getTbdCount();
			case AssurePackage.METRICS__SUCCESS_COUNT:
				return getSuccessCount();
			case AssurePackage.METRICS__FAIL_COUNT:
				return getFailCount();
			case AssurePackage.METRICS__ERROR_COUNT:
				return getErrorCount();
			case AssurePackage.METRICS__DIDELSE_COUNT:
				return getDidelseCount();
			case AssurePackage.METRICS__THENSKIP_COUNT:
				return getThenskipCount();
			case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
				return getPreconditionfailCount();
			case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
				return getValidationfailCount();
			case AssurePackage.METRICS__FEATURES_COUNT:
				return getFeaturesCount();
			case AssurePackage.METRICS__FEATURES_REQUIREMENTS_COUNT:
				return getFeaturesRequirementsCount();
			case AssurePackage.METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT:
				return getQualityCategoryRequirementsCount();
			case AssurePackage.METRICS__TOTAL_QUALITY_CATEGORY_COUNT:
				return getTotalQualityCategoryCount();
			case AssurePackage.METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT:
				return getRequirementsWithoutPlanClaimCount();
			case AssurePackage.METRICS__NO_VERIFICATION_PLANS_COUNT:
				return getNoVerificationPlansCount();
			case AssurePackage.METRICS__REQUIREMENTS_COUNT:
				return getRequirementsCount();
			case AssurePackage.METRICS__EXCEPTIONS_COUNT:
				return getExceptionsCount();
			case AssurePackage.METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT:
				return getReqTargetHasEMV2SubclauseCount();
			case AssurePackage.METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT:
				return getFeaturesRequiringClassifierCount();
			case AssurePackage.METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT:
				return getFeaturesWithRequiredClassifierCount();
			case AssurePackage.METRICS__WEIGHT:
				return getWeight();
			case AssurePackage.METRICS__EXECUTION_TIME:
				return getExecutionTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AssurePackage.METRICS__TBD_COUNT:
				setTbdCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__SUCCESS_COUNT:
				setSuccessCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__FAIL_COUNT:
				setFailCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__ERROR_COUNT:
				setErrorCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__DIDELSE_COUNT:
				setDidelseCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__THENSKIP_COUNT:
				setThenskipCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
				setPreconditionfailCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
				setValidationfailCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__FEATURES_COUNT:
				setFeaturesCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__FEATURES_REQUIREMENTS_COUNT:
				setFeaturesRequirementsCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT:
				setQualityCategoryRequirementsCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__TOTAL_QUALITY_CATEGORY_COUNT:
				setTotalQualityCategoryCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT:
				setRequirementsWithoutPlanClaimCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__NO_VERIFICATION_PLANS_COUNT:
				setNoVerificationPlansCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__REQUIREMENTS_COUNT:
				setRequirementsCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__EXCEPTIONS_COUNT:
				setExceptionsCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT:
				setReqTargetHasEMV2SubclauseCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT:
				setFeaturesRequiringClassifierCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT:
				setFeaturesWithRequiredClassifierCount((Integer)newValue);
				return;
			case AssurePackage.METRICS__WEIGHT:
				setWeight((Integer)newValue);
				return;
			case AssurePackage.METRICS__EXECUTION_TIME:
				setExecutionTime((Long)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AssurePackage.METRICS__TBD_COUNT:
				setTbdCount(TBD_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__SUCCESS_COUNT:
				setSuccessCount(SUCCESS_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__FAIL_COUNT:
				setFailCount(FAIL_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__ERROR_COUNT:
				setErrorCount(ERROR_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__DIDELSE_COUNT:
				setDidelseCount(DIDELSE_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__THENSKIP_COUNT:
				setThenskipCount(THENSKIP_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
				setPreconditionfailCount(PRECONDITIONFAIL_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
				setValidationfailCount(VALIDATIONFAIL_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__FEATURES_COUNT:
				setFeaturesCount(FEATURES_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__FEATURES_REQUIREMENTS_COUNT:
				setFeaturesRequirementsCount(FEATURES_REQUIREMENTS_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT:
				setQualityCategoryRequirementsCount(QUALITY_CATEGORY_REQUIREMENTS_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__TOTAL_QUALITY_CATEGORY_COUNT:
				setTotalQualityCategoryCount(TOTAL_QUALITY_CATEGORY_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT:
				setRequirementsWithoutPlanClaimCount(REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__NO_VERIFICATION_PLANS_COUNT:
				setNoVerificationPlansCount(NO_VERIFICATION_PLANS_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__REQUIREMENTS_COUNT:
				setRequirementsCount(REQUIREMENTS_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__EXCEPTIONS_COUNT:
				setExceptionsCount(EXCEPTIONS_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT:
				setReqTargetHasEMV2SubclauseCount(REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT:
				setFeaturesRequiringClassifierCount(FEATURES_REQUIRING_CLASSIFIER_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT:
				setFeaturesWithRequiredClassifierCount(FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT_EDEFAULT);
				return;
			case AssurePackage.METRICS__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case AssurePackage.METRICS__EXECUTION_TIME:
				setExecutionTime(EXECUTION_TIME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AssurePackage.METRICS__TBD_COUNT:
				return tbdCount != TBD_COUNT_EDEFAULT;
			case AssurePackage.METRICS__SUCCESS_COUNT:
				return successCount != SUCCESS_COUNT_EDEFAULT;
			case AssurePackage.METRICS__FAIL_COUNT:
				return failCount != FAIL_COUNT_EDEFAULT;
			case AssurePackage.METRICS__ERROR_COUNT:
				return errorCount != ERROR_COUNT_EDEFAULT;
			case AssurePackage.METRICS__DIDELSE_COUNT:
				return didelseCount != DIDELSE_COUNT_EDEFAULT;
			case AssurePackage.METRICS__THENSKIP_COUNT:
				return thenskipCount != THENSKIP_COUNT_EDEFAULT;
			case AssurePackage.METRICS__PRECONDITIONFAIL_COUNT:
				return preconditionfailCount != PRECONDITIONFAIL_COUNT_EDEFAULT;
			case AssurePackage.METRICS__VALIDATIONFAIL_COUNT:
				return validationfailCount != VALIDATIONFAIL_COUNT_EDEFAULT;
			case AssurePackage.METRICS__FEATURES_COUNT:
				return featuresCount != FEATURES_COUNT_EDEFAULT;
			case AssurePackage.METRICS__FEATURES_REQUIREMENTS_COUNT:
				return featuresRequirementsCount != FEATURES_REQUIREMENTS_COUNT_EDEFAULT;
			case AssurePackage.METRICS__QUALITY_CATEGORY_REQUIREMENTS_COUNT:
				return qualityCategoryRequirementsCount != QUALITY_CATEGORY_REQUIREMENTS_COUNT_EDEFAULT;
			case AssurePackage.METRICS__TOTAL_QUALITY_CATEGORY_COUNT:
				return totalQualityCategoryCount != TOTAL_QUALITY_CATEGORY_COUNT_EDEFAULT;
			case AssurePackage.METRICS__REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT:
				return requirementsWithoutPlanClaimCount != REQUIREMENTS_WITHOUT_PLAN_CLAIM_COUNT_EDEFAULT;
			case AssurePackage.METRICS__NO_VERIFICATION_PLANS_COUNT:
				return noVerificationPlansCount != NO_VERIFICATION_PLANS_COUNT_EDEFAULT;
			case AssurePackage.METRICS__REQUIREMENTS_COUNT:
				return requirementsCount != REQUIREMENTS_COUNT_EDEFAULT;
			case AssurePackage.METRICS__EXCEPTIONS_COUNT:
				return exceptionsCount != EXCEPTIONS_COUNT_EDEFAULT;
			case AssurePackage.METRICS__REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT:
				return reqTargetHasEMV2SubclauseCount != REQ_TARGET_HAS_EMV2_SUBCLAUSE_COUNT_EDEFAULT;
			case AssurePackage.METRICS__FEATURES_REQUIRING_CLASSIFIER_COUNT:
				return featuresRequiringClassifierCount != FEATURES_REQUIRING_CLASSIFIER_COUNT_EDEFAULT;
			case AssurePackage.METRICS__FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT:
				return featuresWithRequiredClassifierCount != FEATURES_WITH_REQUIRED_CLASSIFIER_COUNT_EDEFAULT;
			case AssurePackage.METRICS__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case AssurePackage.METRICS__EXECUTION_TIME:
				return executionTime != EXECUTION_TIME_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (tbdCount: ");
		result.append(tbdCount);
		result.append(", successCount: ");
		result.append(successCount);
		result.append(", failCount: ");
		result.append(failCount);
		result.append(", errorCount: ");
		result.append(errorCount);
		result.append(", didelseCount: ");
		result.append(didelseCount);
		result.append(", thenskipCount: ");
		result.append(thenskipCount);
		result.append(", preconditionfailCount: ");
		result.append(preconditionfailCount);
		result.append(", validationfailCount: ");
		result.append(validationfailCount);
		result.append(", featuresCount: ");
		result.append(featuresCount);
		result.append(", featuresRequirementsCount: ");
		result.append(featuresRequirementsCount);
		result.append(", qualityCategoryRequirementsCount: ");
		result.append(qualityCategoryRequirementsCount);
		result.append(", totalQualityCategoryCount: ");
		result.append(totalQualityCategoryCount);
		result.append(", requirementsWithoutPlanClaimCount: ");
		result.append(requirementsWithoutPlanClaimCount);
		result.append(", noVerificationPlansCount: ");
		result.append(noVerificationPlansCount);
		result.append(", requirementsCount: ");
		result.append(requirementsCount);
		result.append(", exceptionsCount: ");
		result.append(exceptionsCount);
		result.append(", reqTargetHasEMV2SubclauseCount: ");
		result.append(reqTargetHasEMV2SubclauseCount);
		result.append(", featuresRequiringClassifierCount: ");
		result.append(featuresRequiringClassifierCount);
		result.append(", featuresWithRequiredClassifierCount: ");
		result.append(featuresWithRequiredClassifierCount);
		result.append(", weight: ");
		result.append(weight);
		result.append(", executionTime: ");
		result.append(executionTime);
		result.append(')');
		return result.toString();
	}

} //MetricsImpl
