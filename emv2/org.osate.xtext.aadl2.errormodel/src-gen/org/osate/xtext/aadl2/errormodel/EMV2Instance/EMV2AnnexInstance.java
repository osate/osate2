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
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.instance.AnnexInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMV2 Annex Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getPropagationPoints <em>Propagation Points</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorPropagationConditions <em>Error Propagation Conditions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorDetections <em>Error Detections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorFlows <em>Error Flows</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getComposites <em>Composites</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getPropagationPaths <em>Propagation Paths</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getInPropagations <em>In Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getOutPropagations <em>Out Propagations</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance()
 * @model
 * @generated
 */
public interface EMV2AnnexInstance extends AnnexInstance {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateTransitionInstance> getTransitions();

	/**
	 * Returns the value of the '<em><b>Propagation Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPointInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Points</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_PropagationPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropagationPointInstance> getPropagationPoints();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventInstance> getEvents();

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' containment reference.
	 * @see #setStateMachine(StateMachineInstance)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_StateMachine()
	 * @model containment="true"
	 * @generated
	 */
	StateMachineInstance getStateMachine();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getStateMachine <em>State Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' containment reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachineInstance value);

	/**
	 * Returns the value of the '<em><b>Error Propagation Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Propagation Conditions</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_ErrorPropagationConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ErrorPropagationConditionInstance> getErrorPropagationConditions();

	/**
	 * Returns the value of the '<em><b>Error Detections</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Detections</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_ErrorDetections()
	 * @model containment="true"
	 * @generated
	 */
	EList<ErrorDetectionInstance> getErrorDetections();

	/**
	 * Returns the value of the '<em><b>Error Flows</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Flows</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_ErrorFlows()
	 * @model containment="true"
	 * @generated
	 */
	EList<ErrorFlowInstance> getErrorFlows();

	/**
	 * Returns the value of the '<em><b>Composites</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composites</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_Composites()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompositeStateInstance> getComposites();

	/**
	 * Returns the value of the '<em><b>Propagation Paths</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Paths</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_PropagationPaths()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropagationPathInstance> getPropagationPaths();

	/**
	 * Returns the value of the '<em><b>In Propagations</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Propagations</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_InPropagations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ErrorPropagationInstance> getInPropagations();

	/**
	 * Returns the value of the '<em><b>Out Propagations</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Propagations</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_OutPropagations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ErrorPropagationInstance> getOutPropagations();

} // EMV2AnnexInstance
