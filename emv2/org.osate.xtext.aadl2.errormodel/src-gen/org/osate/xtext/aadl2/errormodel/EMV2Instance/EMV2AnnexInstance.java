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
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getBehaviors <em>Behaviors</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getComposites <em>Composites</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getActions <em>Actions</em>}</li>
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
	 * Returns the value of the '<em><b>Behaviors</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviors</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_Behaviors()
	 * @model containment="true"
	 * @generated
	 */
	EList<BehaviorInstance> getBehaviors();

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
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getEMV2AnnexInstance_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstrainedInstanceObject> getActions();

} // EMV2AnnexInstance
