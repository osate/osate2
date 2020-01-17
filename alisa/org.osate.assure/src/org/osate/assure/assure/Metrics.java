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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metrics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.Metrics#getTbdCount <em>Tbd Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getErrorCount <em>Error Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getDidelseCount <em>Didelse Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getThenskipCount <em>Thenskip Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getPreconditionfailCount <em>Preconditionfail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getValidationfailCount <em>Validationfail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getFeaturesCount <em>Features Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getFeaturesRequirementsCount <em>Features Requirements Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getQualityCategoryRequirementsCount <em>Quality Category Requirements Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getTotalQualityCategoryCount <em>Total Quality Category Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getRequirementsWithoutPlanClaimCount <em>Requirements Without Plan Claim Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getNoVerificationPlansCount <em>No Verification Plans Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getRequirementsCount <em>Requirements Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getExceptionsCount <em>Exceptions Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getReqTargetHasEMV2SubclauseCount <em>Req Target Has EMV2 Subclause Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getFeaturesRequiringClassifierCount <em>Features Requiring Classifier Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getFeaturesWithRequiredClassifierCount <em>Features With Required Classifier Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.Metrics#getExecutionTime <em>Execution Time</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getMetrics()
 * @model
 * @generated
 */
public interface Metrics extends EObject {
	/**
	 * Returns the value of the '<em><b>Tbd Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tbd Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tbd Count</em>' attribute.
	 * @see #setTbdCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_TbdCount()
	 * @model
	 * @generated
	 */
	int getTbdCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getTbdCount <em>Tbd Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tbd Count</em>' attribute.
	 * @see #getTbdCount()
	 * @generated
	 */
	void setTbdCount(int value);

	/**
	 * Returns the value of the '<em><b>Success Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Success Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success Count</em>' attribute.
	 * @see #setSuccessCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_SuccessCount()
	 * @model
	 * @generated
	 */
	int getSuccessCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getSuccessCount <em>Success Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success Count</em>' attribute.
	 * @see #getSuccessCount()
	 * @generated
	 */
	void setSuccessCount(int value);

	/**
	 * Returns the value of the '<em><b>Fail Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fail Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fail Count</em>' attribute.
	 * @see #setFailCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_FailCount()
	 * @model
	 * @generated
	 */
	int getFailCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getFailCount <em>Fail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fail Count</em>' attribute.
	 * @see #getFailCount()
	 * @generated
	 */
	void setFailCount(int value);

	/**
	 * Returns the value of the '<em><b>Error Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Count</em>' attribute.
	 * @see #setErrorCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_ErrorCount()
	 * @model
	 * @generated
	 */
	int getErrorCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getErrorCount <em>Error Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Count</em>' attribute.
	 * @see #getErrorCount()
	 * @generated
	 */
	void setErrorCount(int value);

	/**
	 * Returns the value of the '<em><b>Didelse Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Didelse Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Didelse Count</em>' attribute.
	 * @see #setDidelseCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_DidelseCount()
	 * @model
	 * @generated
	 */
	int getDidelseCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getDidelseCount <em>Didelse Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Didelse Count</em>' attribute.
	 * @see #getDidelseCount()
	 * @generated
	 */
	void setDidelseCount(int value);

	/**
	 * Returns the value of the '<em><b>Thenskip Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thenskip Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thenskip Count</em>' attribute.
	 * @see #setThenskipCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_ThenskipCount()
	 * @model
	 * @generated
	 */
	int getThenskipCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getThenskipCount <em>Thenskip Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thenskip Count</em>' attribute.
	 * @see #getThenskipCount()
	 * @generated
	 */
	void setThenskipCount(int value);

	/**
	 * Returns the value of the '<em><b>Preconditionfail Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preconditionfail Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preconditionfail Count</em>' attribute.
	 * @see #setPreconditionfailCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_PreconditionfailCount()
	 * @model
	 * @generated
	 */
	int getPreconditionfailCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getPreconditionfailCount <em>Preconditionfail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preconditionfail Count</em>' attribute.
	 * @see #getPreconditionfailCount()
	 * @generated
	 */
	void setPreconditionfailCount(int value);

	/**
	 * Returns the value of the '<em><b>Validationfail Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validationfail Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validationfail Count</em>' attribute.
	 * @see #setValidationfailCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_ValidationfailCount()
	 * @model
	 * @generated
	 */
	int getValidationfailCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getValidationfailCount <em>Validationfail Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validationfail Count</em>' attribute.
	 * @see #getValidationfailCount()
	 * @generated
	 */
	void setValidationfailCount(int value);

	/**
	 * Returns the value of the '<em><b>Features Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features Count</em>' attribute.
	 * @see #setFeaturesCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_FeaturesCount()
	 * @model
	 * @generated
	 */
	int getFeaturesCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getFeaturesCount <em>Features Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features Count</em>' attribute.
	 * @see #getFeaturesCount()
	 * @generated
	 */
	void setFeaturesCount(int value);

	/**
	 * Returns the value of the '<em><b>Features Requirements Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features Requirements Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features Requirements Count</em>' attribute.
	 * @see #setFeaturesRequirementsCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_FeaturesRequirementsCount()
	 * @model
	 * @generated
	 */
	int getFeaturesRequirementsCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getFeaturesRequirementsCount <em>Features Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features Requirements Count</em>' attribute.
	 * @see #getFeaturesRequirementsCount()
	 * @generated
	 */
	void setFeaturesRequirementsCount(int value);

	/**
	 * Returns the value of the '<em><b>Quality Category Requirements Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Category Requirements Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Category Requirements Count</em>' attribute.
	 * @see #setQualityCategoryRequirementsCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_QualityCategoryRequirementsCount()
	 * @model
	 * @generated
	 */
	int getQualityCategoryRequirementsCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getQualityCategoryRequirementsCount <em>Quality Category Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Category Requirements Count</em>' attribute.
	 * @see #getQualityCategoryRequirementsCount()
	 * @generated
	 */
	void setQualityCategoryRequirementsCount(int value);

	/**
	 * Returns the value of the '<em><b>Total Quality Category Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Quality Category Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Quality Category Count</em>' attribute.
	 * @see #setTotalQualityCategoryCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_TotalQualityCategoryCount()
	 * @model
	 * @generated
	 */
	int getTotalQualityCategoryCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getTotalQualityCategoryCount <em>Total Quality Category Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Quality Category Count</em>' attribute.
	 * @see #getTotalQualityCategoryCount()
	 * @generated
	 */
	void setTotalQualityCategoryCount(int value);

	/**
	 * Returns the value of the '<em><b>Requirements Without Plan Claim Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements Without Plan Claim Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements Without Plan Claim Count</em>' attribute.
	 * @see #setRequirementsWithoutPlanClaimCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_RequirementsWithoutPlanClaimCount()
	 * @model
	 * @generated
	 */
	int getRequirementsWithoutPlanClaimCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getRequirementsWithoutPlanClaimCount <em>Requirements Without Plan Claim Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirements Without Plan Claim Count</em>' attribute.
	 * @see #getRequirementsWithoutPlanClaimCount()
	 * @generated
	 */
	void setRequirementsWithoutPlanClaimCount(int value);

	/**
	 * Returns the value of the '<em><b>No Verification Plans Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Verification Plans Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Verification Plans Count</em>' attribute.
	 * @see #setNoVerificationPlansCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_NoVerificationPlansCount()
	 * @model
	 * @generated
	 */
	int getNoVerificationPlansCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getNoVerificationPlansCount <em>No Verification Plans Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Verification Plans Count</em>' attribute.
	 * @see #getNoVerificationPlansCount()
	 * @generated
	 */
	void setNoVerificationPlansCount(int value);

	/**
	 * Returns the value of the '<em><b>Requirements Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements Count</em>' attribute.
	 * @see #setRequirementsCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_RequirementsCount()
	 * @model
	 * @generated
	 */
	int getRequirementsCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getRequirementsCount <em>Requirements Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirements Count</em>' attribute.
	 * @see #getRequirementsCount()
	 * @generated
	 */
	void setRequirementsCount(int value);

	/**
	 * Returns the value of the '<em><b>Exceptions Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exceptions Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions Count</em>' attribute.
	 * @see #setExceptionsCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_ExceptionsCount()
	 * @model
	 * @generated
	 */
	int getExceptionsCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getExceptionsCount <em>Exceptions Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exceptions Count</em>' attribute.
	 * @see #getExceptionsCount()
	 * @generated
	 */
	void setExceptionsCount(int value);

	/**
	 * Returns the value of the '<em><b>Req Target Has EMV2 Subclause Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req Target Has EMV2 Subclause Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req Target Has EMV2 Subclause Count</em>' attribute.
	 * @see #setReqTargetHasEMV2SubclauseCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_ReqTargetHasEMV2SubclauseCount()
	 * @model
	 * @generated
	 */
	int getReqTargetHasEMV2SubclauseCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getReqTargetHasEMV2SubclauseCount <em>Req Target Has EMV2 Subclause Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req Target Has EMV2 Subclause Count</em>' attribute.
	 * @see #getReqTargetHasEMV2SubclauseCount()
	 * @generated
	 */
	void setReqTargetHasEMV2SubclauseCount(int value);

	/**
	 * Returns the value of the '<em><b>Features Requiring Classifier Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features Requiring Classifier Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features Requiring Classifier Count</em>' attribute.
	 * @see #setFeaturesRequiringClassifierCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_FeaturesRequiringClassifierCount()
	 * @model
	 * @generated
	 */
	int getFeaturesRequiringClassifierCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getFeaturesRequiringClassifierCount <em>Features Requiring Classifier Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features Requiring Classifier Count</em>' attribute.
	 * @see #getFeaturesRequiringClassifierCount()
	 * @generated
	 */
	void setFeaturesRequiringClassifierCount(int value);

	/**
	 * Returns the value of the '<em><b>Features With Required Classifier Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features With Required Classifier Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features With Required Classifier Count</em>' attribute.
	 * @see #setFeaturesWithRequiredClassifierCount(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_FeaturesWithRequiredClassifierCount()
	 * @model
	 * @generated
	 */
	int getFeaturesWithRequiredClassifierCount();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getFeaturesWithRequiredClassifierCount <em>Features With Required Classifier Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Features With Required Classifier Count</em>' attribute.
	 * @see #getFeaturesWithRequiredClassifierCount()
	 * @generated
	 */
	void setFeaturesWithRequiredClassifierCount(int value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_Weight()
	 * @model
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

	/**
	 * Returns the value of the '<em><b>Execution Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Time</em>' attribute.
	 * @see #setExecutionTime(long)
	 * @see org.osate.assure.assure.AssurePackage#getMetrics_ExecutionTime()
	 * @model dataType="org.osate.aadl2.Integer"
	 * @generated
	 */
	long getExecutionTime();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.Metrics#getExecutionTime <em>Execution Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Time</em>' attribute.
	 * @see #getExecutionTime()
	 * @generated
	 */
	void setExecutionTime(long value);

} // Metrics
