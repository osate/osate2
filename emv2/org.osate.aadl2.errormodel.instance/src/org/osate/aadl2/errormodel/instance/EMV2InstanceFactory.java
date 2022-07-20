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
package org.osate.aadl2.errormodel.instance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage
 * @generated
 */
public interface EMV2InstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMV2InstanceFactory eINSTANCE = org.osate.aadl2.errormodel.instance.impl.EMV2InstanceFactoryImpl.init();

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
	 * Returns a new object of class '<em>Composite State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite State Instance</em>'.
	 * @generated
	 */
	CompositeStateInstance createCompositeStateInstance();

	/**
	 * Returns a new object of class '<em>Error Source Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Source Instance</em>'.
	 * @generated
	 */
	ErrorSourceInstance createErrorSourceInstance();

	/**
	 * Returns a new object of class '<em>Error Sink Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Sink Instance</em>'.
	 * @generated
	 */
	ErrorSinkInstance createErrorSinkInstance();

	/**
	 * Returns a new object of class '<em>Error Path Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Path Instance</em>'.
	 * @generated
	 */
	ErrorPathInstance createErrorPathInstance();

	/**
	 * Returns a new object of class '<em>Propagation Point Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Propagation Point Instance</em>'.
	 * @generated
	 */
	PropagationPointInstance createPropagationPointInstance();

	/**
	 * Returns a new object of class '<em>Connection Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection Path</em>'.
	 * @generated
	 */
	ConnectionPath createConnectionPath();

	/**
	 * Returns a new object of class '<em>Binding Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding Path</em>'.
	 * @generated
	 */
	BindingPath createBindingPath();

	/**
	 * Returns a new object of class '<em>User Defined Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Defined Path</em>'.
	 * @generated
	 */
	UserDefinedPath createUserDefinedPath();

	/**
	 * Returns a new object of class '<em>Error Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Event Instance</em>'.
	 * @generated
	 */
	ErrorEventInstance createErrorEventInstance();

	/**
	 * Returns a new object of class '<em>Recover Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recover Event Instance</em>'.
	 * @generated
	 */
	RecoverEventInstance createRecoverEventInstance();

	/**
	 * Returns a new object of class '<em>Repair Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repair Event Instance</em>'.
	 * @generated
	 */
	RepairEventInstance createRepairEventInstance();

	/**
	 * Returns a new object of class '<em>Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Instance</em>'.
	 * @generated
	 */
	TransitionInstance createTransitionInstance();

	/**
	 * Returns a new object of class '<em>Source State Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source State Reference</em>'.
	 * @generated
	 */
	SourceStateReference createSourceStateReference();

	/**
	 * Returns a new object of class '<em>All Sources</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Sources</em>'.
	 * @generated
	 */
	AllSources createAllSources();

	/**
	 * Returns a new object of class '<em>Event Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Reference</em>'.
	 * @generated
	 */
	EventReference createEventReference();

	/**
	 * Returns a new object of class '<em>Condition Propagation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Propagation Reference</em>'.
	 * @generated
	 */
	ConditionPropagationReference createConditionPropagationReference();

	/**
	 * Returns a new object of class '<em>No Error Propagation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>No Error Propagation Reference</em>'.
	 * @generated
	 */
	NoErrorPropagationReference createNoErrorPropagationReference();

	/**
	 * Returns a new object of class '<em>Count Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Count Expression</em>'.
	 * @generated
	 */
	CountExpression createCountExpression();

	/**
	 * Returns a new object of class '<em>Destination State Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Destination State Reference</em>'.
	 * @generated
	 */
	DestinationStateReference createDestinationStateReference();

	/**
	 * Returns a new object of class '<em>Same State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Same State</em>'.
	 * @generated
	 */
	SameState createSameState();

	/**
	 * Returns a new object of class '<em>Branches</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branches</em>'.
	 * @generated
	 */
	Branches createBranches();

	/**
	 * Returns a new object of class '<em>Branch State Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch State Reference</em>'.
	 * @generated
	 */
	BranchStateReference createBranchStateReference();

	/**
	 * Returns a new object of class '<em>Branch Same State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch Same State</em>'.
	 * @generated
	 */
	BranchSameState createBranchSameState();

	/**
	 * Returns a new object of class '<em>Outgoing Propagation Condition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outgoing Propagation Condition Instance</em>'.
	 * @generated
	 */
	OutgoingPropagationConditionInstance createOutgoingPropagationConditionInstance();

	/**
	 * Returns a new object of class '<em>Destination Propagation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Destination Propagation Reference</em>'.
	 * @generated
	 */
	DestinationPropagationReference createDestinationPropagationReference();

	/**
	 * Returns a new object of class '<em>All Propagations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Propagations</em>'.
	 * @generated
	 */
	AllPropagations createAllPropagations();

	/**
	 * Returns a new object of class '<em>All Propagations No Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Propagations No Error</em>'.
	 * @generated
	 */
	AllPropagationsNoError createAllPropagationsNoError();

	/**
	 * Returns a new object of class '<em>Detection Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detection Instance</em>'.
	 * @generated
	 */
	DetectionInstance createDetectionInstance();

	/**
	 * Returns a new object of class '<em>Constraint Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint Expression</em>'.
	 * @generated
	 */
	ConstraintExpression createConstraintExpression();

	/**
	 * Returns a new object of class '<em>Feature Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Propagation</em>'.
	 * @generated
	 */
	FeaturePropagation createFeaturePropagation();

	/**
	 * Returns a new object of class '<em>Point Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point Propagation</em>'.
	 * @generated
	 */
	PointPropagation createPointPropagation();

	/**
	 * Returns a new object of class '<em>Access Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Propagation</em>'.
	 * @generated
	 */
	AccessPropagation createAccessPropagation();

	/**
	 * Returns a new object of class '<em>Binding Propagation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding Propagation</em>'.
	 * @generated
	 */
	BindingPropagation createBindingPropagation();

	/**
	 * Returns a new object of class '<em>Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Instance</em>'.
	 * @generated
	 */
	TypeInstance createTypeInstance();

	/**
	 * Returns a new object of class '<em>Type Set Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Set Instance</em>'.
	 * @generated
	 */
	TypeSetInstance createTypeSetInstance();

	/**
	 * Returns a new object of class '<em>Anonymous Type Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Anonymous Type Set</em>'.
	 * @generated
	 */
	AnonymousTypeSet createAnonymousTypeSet();

	/**
	 * Returns a new object of class '<em>Type Product Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Product Instance</em>'.
	 * @generated
	 */
	TypeProductInstance createTypeProductInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EMV2InstancePackage getEMV2InstancePackage();

} // EMV2InstanceFactory
