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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage
 * @generated
 */
public interface EMV2InstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMV2InstanceFactory eINSTANCE = org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EMV2 Annex Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMV2 Annex Instance</em>'.
	 * @generated
	 */
	EMV2AnnexInstance createEMV2AnnexInstance();

	/**
	 * Returns a new object of class '<em>State Machine Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine Instance</em>'.
	 * @generated
	 */
	StateMachineInstance createStateMachineInstance();

	/**
	 * Returns a new object of class '<em>State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Instance</em>'.
	 * @generated
	 */
	StateInstance createStateInstance();

	/**
	 * Returns a new object of class '<em>Constrained Instance Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constrained Instance Object</em>'.
	 * @generated
	 */
	ConstrainedInstanceObject createConstrainedInstanceObject();

	/**
	 * Returns a new object of class '<em>State Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Transition Instance</em>'.
	 * @generated
	 */
	StateTransitionInstance createStateTransitionInstance();

	/**
	 * Returns a new object of class '<em>Composite State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite State Instance</em>'.
	 * @generated
	 */
	CompositeStateInstance createCompositeStateInstance();

	/**
	 * Returns a new object of class '<em>Error Flow Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Flow Instance</em>'.
	 * @generated
	 */
	ErrorFlowInstance createErrorFlowInstance();

	/**
	 * Returns a new object of class '<em>Error Behavior Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Behavior Instance</em>'.
	 * @generated
	 */
	ErrorBehaviorInstance createErrorBehaviorInstance();

	/**
	 * Returns a new object of class '<em>Propagation Path Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Propagation Path Instance</em>'.
	 * @generated
	 */
	PropagationPathInstance createPropagationPathInstance();

	/**
	 * Returns a new object of class '<em>Propagation Point Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Propagation Point Instance</em>'.
	 * @generated
	 */
	PropagationPointInstance createPropagationPointInstance();

	/**
	 * Returns a new object of class '<em>Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Instance</em>'.
	 * @generated
	 */
	EventInstance createEventInstance();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EMV2InstancePackage getEMV2InstancePackage();

} //EMV2InstanceFactory
