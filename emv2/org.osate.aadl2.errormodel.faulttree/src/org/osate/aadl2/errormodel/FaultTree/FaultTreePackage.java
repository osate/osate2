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
package org.osate.aadl2.errormodel.FaultTree;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeFactory
 * @model kind="package"
 * @generated
 */
public interface FaultTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FaultTree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.aadl.info/FaultTree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FaultTree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FaultTreePackage eINSTANCE = org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl <em>Fault Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl
	 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getFaultTree()
	 * @generated
	 */
	int FAULT_TREE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Fault Tree Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE__FAULT_TREE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE__ROOT = 3;

	/**
	 * The feature id for the '<em><b>Instance Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE__INSTANCE_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE__EVENTS = 5;

	/**
	 * The number of structural features of the '<em>Fault Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Fault Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_TREE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.FaultTree.impl.EventImpl
	 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Sub Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SUB_EVENTS = 2;

	/**
	 * The feature id for the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__K = 3;

	/**
	 * The feature id for the '<em><b>Assigned Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ASSIGNED_PROBABILITY = 4;

	/**
	 * The feature id for the '<em><b>Computed Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__COMPUTED_PROBABILITY = 5;

	/**
	 * The feature id for the '<em><b>Related Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__RELATED_INSTANCE_OBJECT = 6;

	/**
	 * The feature id for the '<em><b>Related Error Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__RELATED_ERROR_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Reference Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__REFERENCE_COUNT = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = 9;

	/**
	 * The feature id for the '<em><b>Sub Event Logic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SUB_EVENT_LOGIC = 10;

	/**
	 * The feature id for the '<em><b>Related EMV2 Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__RELATED_EMV2_OBJECT = 11;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SCALE = 12;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 13;

	/**
	 * The operation id for the '<em>Get Probability</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT___GET_PROBABILITY = 0;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.FaultTree.EventType <em>Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.FaultTree.EventType
	 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.FaultTree.LogicOperation <em>Logic Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.FaultTree.LogicOperation
	 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getLogicOperation()
	 * @generated
	 */
	int LOGIC_OPERATION = 3;


	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTreeType <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeType
	 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getFaultTreeType()
	 * @generated
	 */
	int FAULT_TREE_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree <em>Fault Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fault Tree</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTree
	 * @generated
	 */
	EClass getFaultTree();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTree#getName()
	 * @see #getFaultTree()
	 * @generated
	 */
	EAttribute getFaultTree_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTree#getMessage()
	 * @see #getFaultTree()
	 * @generated
	 */
	EAttribute getFaultTree_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getFaultTreeType <em>Fault Tree Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Tree Type</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTree#getFaultTreeType()
	 * @see #getFaultTree()
	 * @generated
	 */
	EAttribute getFaultTree_FaultTreeType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTree#getEvents()
	 * @see #getFaultTree()
	 * @generated
	 */
	EReference getFaultTree_Events();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTree#getRoot()
	 * @see #getFaultTree()
	 * @generated
	 */
	EReference getFaultTree_Root();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getInstanceRoot <em>Instance Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Root</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTree#getInstanceRoot()
	 * @see #getFaultTree()
	 * @generated
	 */
	EReference getFaultTree_InstanceRoot();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.FaultTree.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getName()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getMessage()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Message();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.FaultTree.Event#getSubEvents <em>Sub Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Events</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getSubEvents()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_SubEvents();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getK <em>K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>K</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getK()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_K();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getAssignedProbability <em>Assigned Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assigned Probability</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getAssignedProbability()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_AssignedProbability();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getComputedProbability <em>Computed Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Computed Probability</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getComputedProbability()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_ComputedProbability();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedInstanceObject <em>Related Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Instance Object</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getRelatedInstanceObject()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_RelatedInstanceObject();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getReferenceCount <em>Reference Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Count</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getReferenceCount()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_ReferenceCount();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getSubEventLogic <em>Sub Event Logic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Event Logic</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getSubEventLogic()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_SubEventLogic();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedEMV2Object <em>Related EMV2 Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related EMV2 Object</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getRelatedEMV2Object()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_RelatedEMV2Object();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.FaultTree.Event#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getScale()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Scale();

	/**
	 * Returns the meta object for the '{@link org.osate.aadl2.errormodel.FaultTree.Event#getProbability() <em>Get Probability</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Probability</em>' operation.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getProbability()
	 * @generated
	 */
	EOperation getEvent__GetProbability();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.FaultTree.Event#getRelatedErrorType <em>Related Error Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Error Type</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.Event#getRelatedErrorType()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_RelatedErrorType();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.FaultTree.EventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Event Type</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.EventType
	 * @generated
	 */
	EEnum getEventType();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.FaultTree.LogicOperation <em>Logic Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logic Operation</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.LogicOperation
	 * @generated
	 */
	EEnum getLogicOperation();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.FaultTree.FaultTreeType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeType
	 * @generated
	 */
	EEnum getFaultTreeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FaultTreeFactory getFaultTreeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl <em>Fault Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreeImpl
		 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getFaultTree()
		 * @generated
		 */
		EClass FAULT_TREE = eINSTANCE.getFaultTree();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_TREE__NAME = eINSTANCE.getFaultTree_Name();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_TREE__MESSAGE = eINSTANCE.getFaultTree_Message();

		/**
		 * The meta object literal for the '<em><b>Fault Tree Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_TREE__FAULT_TREE_TYPE = eINSTANCE.getFaultTree_FaultTreeType();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_TREE__EVENTS = eINSTANCE.getFaultTree_Events();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_TREE__ROOT = eINSTANCE.getFaultTree_Root();

		/**
		 * The meta object literal for the '<em><b>Instance Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_TREE__INSTANCE_ROOT = eINSTANCE.getFaultTree_InstanceRoot();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.FaultTree.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.FaultTree.impl.EventImpl
		 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__MESSAGE = eINSTANCE.getEvent_Message();

		/**
		 * The meta object literal for the '<em><b>Sub Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__SUB_EVENTS = eINSTANCE.getEvent_SubEvents();

		/**
		 * The meta object literal for the '<em><b>K</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__K = eINSTANCE.getEvent_K();

		/**
		 * The meta object literal for the '<em><b>Assigned Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__ASSIGNED_PROBABILITY = eINSTANCE.getEvent_AssignedProbability();

		/**
		 * The meta object literal for the '<em><b>Computed Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__COMPUTED_PROBABILITY = eINSTANCE.getEvent_ComputedProbability();

		/**
		 * The meta object literal for the '<em><b>Related Instance Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__RELATED_INSTANCE_OBJECT = eINSTANCE.getEvent_RelatedInstanceObject();

		/**
		 * The meta object literal for the '<em><b>Reference Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__REFERENCE_COUNT = eINSTANCE.getEvent_ReferenceCount();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Sub Event Logic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__SUB_EVENT_LOGIC = eINSTANCE.getEvent_SubEventLogic();

		/**
		 * The meta object literal for the '<em><b>Related EMV2 Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__RELATED_EMV2_OBJECT = eINSTANCE.getEvent_RelatedEMV2Object();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__SCALE = eINSTANCE.getEvent_Scale();

		/**
		 * The meta object literal for the '<em><b>Get Probability</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVENT___GET_PROBABILITY = eINSTANCE.getEvent__GetProbability();

		/**
		 * The meta object literal for the '<em><b>Related Error Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__RELATED_ERROR_TYPE = eINSTANCE.getEvent_RelatedErrorType();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.FaultTree.EventType <em>Event Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.FaultTree.EventType
		 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getEventType()
		 * @generated
		 */
		EEnum EVENT_TYPE = eINSTANCE.getEventType();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.FaultTree.LogicOperation <em>Logic Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.FaultTree.LogicOperation
		 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getLogicOperation()
		 * @generated
		 */
		EEnum LOGIC_OPERATION = eINSTANCE.getLogicOperation();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTreeType <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeType
		 * @see org.osate.aadl2.errormodel.FaultTree.impl.FaultTreePackageImpl#getFaultTreeType()
		 * @generated
		 */
		EEnum FAULT_TREE_TYPE = eINSTANCE.getFaultTreeType();

	}

} //FaultTreePackage
