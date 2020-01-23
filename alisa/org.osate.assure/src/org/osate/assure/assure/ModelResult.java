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

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.ComponentImplementation;

import org.osate.alisa.workbench.alisa.AssurancePlan;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.ModelResult#getPlan <em>Plan</em>}</li>
 *   <li>{@link org.osate.assure.assure.ModelResult#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.assure.assure.ModelResult#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.assure.assure.ModelResult#getClaimResult <em>Claim Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.ModelResult#getSubsystemResult <em>Subsystem Result</em>}</li>
 *   <li>{@link org.osate.assure.assure.ModelResult#getSubAssuranceCase <em>Sub Assurance Case</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getModelResult()
 * @model
 * @generated
 */
public interface ModelResult extends AssureResult {
	/**
	 * Returns the value of the '<em><b>Plan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plan</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plan</em>' reference.
	 * @see #setPlan(AssurancePlan)
	 * @see org.osate.assure.assure.AssurePackage#getModelResult_Plan()
	 * @model
	 * @generated
	 */
	AssurancePlan getPlan();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.ModelResult#getPlan <em>Plan</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plan</em>' reference.
	 * @see #getPlan()
	 * @generated
	 */
	void setPlan(AssurancePlan value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ComponentImplementation)
	 * @see org.osate.assure.assure.AssurePackage#getModelResult_Target()
	 * @model
	 * @generated
	 */
	ComponentImplementation getTarget();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.ModelResult#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ComponentImplementation value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.osate.assure.assure.AssurePackage#getModelResult_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.ModelResult#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Claim Result</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.assure.assure.ClaimResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Claim Result</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Claim Result</em>' containment reference list.
	 * @see org.osate.assure.assure.AssurePackage#getModelResult_ClaimResult()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClaimResult> getClaimResult();

	/**
	 * Returns the value of the '<em><b>Subsystem Result</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.assure.assure.SubsystemResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystem Result</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystem Result</em>' containment reference list.
	 * @see org.osate.assure.assure.AssurePackage#getModelResult_SubsystemResult()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubsystemResult> getSubsystemResult();

	/**
	 * Returns the value of the '<em><b>Sub Assurance Case</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.assure.assure.AssuranceCaseResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Assurance Case</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Assurance Case</em>' containment reference list.
	 * @see org.osate.assure.assure.AssurePackage#getModelResult_SubAssuranceCase()
	 * @model containment="true"
	 * @generated
	 */
	EList<AssuranceCaseResult> getSubAssuranceCase();

} // ModelResult
