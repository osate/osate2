/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.errormodel.instance;

import org.osate.aadl2.instance.FeatureInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detection Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getDetection <em>Detection</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getErrorCode <em>Error Code</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getDetectionInstance()
 * @model
 * @generated
 */
public interface DetectionInstance extends EMV2InstanceObject {
	/**
	 * Returns the value of the '<em><b>Detection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detection</em>' reference.
	 * @see #setDetection(ErrorDetection)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getDetectionInstance_Detection()
	 * @model
	 * @generated
	 */
	ErrorDetection getDetection();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getDetection <em>Detection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detection</em>' reference.
	 * @see #getDetection()
	 * @generated
	 */
	void setDetection(ErrorDetection value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(StateSource)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getDetectionInstance_Source()
	 * @model containment="true"
	 * @generated
	 */
	StateSource getSource();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(StateSource value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ConditionExpressionInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getDetectionInstance_Condition()
	 * @model containment="true"
	 * @generated
	 */
	ConditionExpressionInstance getCondition();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionExpressionInstance value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(FeatureInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getDetectionInstance_Destination()
	 * @model
	 * @generated
	 */
	FeatureInstance getDestination();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(FeatureInstance value);

	/**
	 * Returns the value of the '<em><b>Error Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Code</em>' containment reference.
	 * @see #setErrorCode(ErrorCodeInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getDetectionInstance_ErrorCode()
	 * @model containment="true"
	 * @generated
	 */
	ErrorCodeInstance getErrorCode();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getErrorCode <em>Error Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Code</em>' containment reference.
	 * @see #getErrorCode()
	 * @generated
	 */
	void setErrorCode(ErrorCodeInstance value);

} // DetectionInstance
