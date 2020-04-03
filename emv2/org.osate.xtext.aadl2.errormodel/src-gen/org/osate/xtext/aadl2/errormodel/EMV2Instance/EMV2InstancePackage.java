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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.osate.aadl2.instance.InstancePackage;

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
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory
 * @model kind="package"
 * @generated
 */
public interface EMV2InstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EMV2Instance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.osate.org/EMV2Instance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EMV2Instance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMV2InstancePackage eINSTANCE = org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl <em>EMV2 Annex Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2AnnexInstance()
	 * @generated
	 */
	int EMV2_ANNEX_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__OWNED_ELEMENT = InstancePackage.ANNEX_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__OWNED_COMMENT = InstancePackage.ANNEX_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__NAME = InstancePackage.ANNEX_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__QUALIFIED_NAME = InstancePackage.ANNEX_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__OWNED_PROPERTY_ASSOCIATION = InstancePackage.ANNEX_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Subclause</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__ANNEX_SUBCLAUSE = InstancePackage.ANNEX_INSTANCE__ANNEX_SUBCLAUSE;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__TRANSITIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Propagation Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__EVENTS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__STATE_MACHINE = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Propagation Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Error Detections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Error Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__ERROR_FLOWS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Composites</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__COMPOSITES = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Propagation Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>EMV2 Annex Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE_FEATURE_COUNT = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2InstanceObject()
	 * @generated
	 */
	int EMV2_INSTANCE_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__OWNED_ELEMENT = InstancePackage.INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__OWNED_COMMENT = InstancePackage.INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__NAME = InstancePackage.INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__QUALIFIED_NAME = InstancePackage.INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION = InstancePackage.INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE = InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_INSTANCE_OBJECT_FEATURE_COUNT = InstancePackage.INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateMachineInstanceImpl <em>State Machine Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateMachineInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateMachineInstance()
	 * @generated
	 */
	int STATE_MACHINE_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__STATES = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__CURRENT_STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>State Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE__STATE_MACHINE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State Machine Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl <em>State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateInstance()
	 * @generated
	 */
	int STATE_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintElementImpl <em>Constraint Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintElementImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstraintElement()
	 * @generated
	 */
	int CONSTRAINT_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ELEMENT__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ELEMENT__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ELEMENT__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ELEMENT__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ELEMENT__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ELEMENT__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Constraint Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_ELEMENT_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl <em>Constrained Instance Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstrainedInstanceObject()
	 * @generated
	 */
	int CONSTRAINED_INSTANCE_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__OWNED_ELEMENT = CONSTRAINT_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__OWNED_COMMENT = CONSTRAINT_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__NAME = CONSTRAINT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__QUALIFIED_NAME = CONSTRAINT_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION = CONSTRAINT_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__ANNEX_INSTANCE = CONSTRAINT_ELEMENT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT = CONSTRAINT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT = CONSTRAINT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Propagation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND = CONSTRAINT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constrained Instance Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT = CONSTRAINT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl <em>State Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateTransitionInstance()
	 * @generated
	 */
	int STATE_TRANSITION_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>State Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__STATE_TRANSITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__IN_STATES = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE__TARGET_STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>State Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TRANSITION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.CompositeStateInstanceImpl <em>Composite State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.CompositeStateInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getCompositeStateInstance()
	 * @generated
	 */
	int COMPOSITE_STATE_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__TARGET_STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__COMPOSITE_STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorFlowInstanceImpl <em>Error Flow Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorFlowInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getErrorFlowInstance()
	 * @generated
	 */
	int ERROR_FLOW_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Emv2 Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__EMV2_ELEMENT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__INCOMING = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__OUTGOING = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sink</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE__SINK = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Error Flow Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl <em>Error Propagation Condition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getErrorPropagationConditionInstance()
	 * @generated
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE = 8;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Emv2 Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outgoing Propagation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sink</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE__SINK = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Error Propagation Condition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl <em>Error Detection Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getErrorDetectionInstance()
	 * @generated
	 */
	int ERROR_DETECTION_INSTANCE = 9;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Emv2 Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__EMV2_ELEMENT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__IN_STATES = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__ERROR_CODE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE__PORT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Error Detection Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_DETECTION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPointInstanceImpl <em>Propagation Point Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPointInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getPropagationPointInstance()
	 * @generated
	 */
	int PROPAGATION_POINT_INSTANCE = 10;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Propagation Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE__PROPAGATION_POINT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Propagation Point Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_POINT_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EventInstanceImpl <em>Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EventInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEventInstance()
	 * @generated
	 */
	int EVENT_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__EVENT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generated Typed Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__GENERATED_TYPED_EVENTS = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintExpressionImpl <em>Constraint Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintExpressionImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstraintExpression()
	 * @generated
	 */
	int CONSTRAINT_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__OWNED_ELEMENT = CONSTRAINT_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__OWNED_COMMENT = CONSTRAINT_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__NAME = CONSTRAINT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__QUALIFIED_NAME = CONSTRAINT_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__OWNED_PROPERTY_ASSOCIATION = CONSTRAINT_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__ANNEX_INSTANCE = CONSTRAINT_ELEMENT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__OPERATOR = CONSTRAINT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__K = CONSTRAINT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION__CONSTRAINT_ELEMENTS = CONSTRAINT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_EXPRESSION_FEATURE_COUNT = CONSTRAINT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPathInstanceImpl <em>Propagation Path Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPathInstanceImpl
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getPropagationPathInstance()
	 * @generated
	 */
	int PROPAGATION_PATH_INSTANCE = 14;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Emv2 Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__EMV2_ELEMENT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE__TARGET = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Propagation Path Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation <em>EOperation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEOperation()
	 * @generated
	 */
	int EOPERATION = 15;


	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance <em>EMV2 Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMV2 Annex Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance
	 * @generated
	 */
	EClass getEMV2AnnexInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getTransitions()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getPropagationPoints <em>Propagation Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propagation Points</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getPropagationPoints()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_PropagationPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getEvents()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Events();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Machine</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getStateMachine()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_StateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorPropagationConditions <em>Error Propagation Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Propagation Conditions</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorPropagationConditions()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_ErrorPropagationConditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorDetections <em>Error Detections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Detections</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorDetections()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_ErrorDetections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorFlows <em>Error Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Flows</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getErrorFlows()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_ErrorFlows();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getComposites <em>Composites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composites</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getComposites()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Composites();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getPropagationPaths <em>Propagation Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propagation Paths</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance#getPropagationPaths()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_PropagationPaths();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject
	 * @generated
	 */
	EClass getEMV2InstanceObject();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance <em>State Machine Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance
	 * @generated
	 */
	EClass getStateMachineInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance#getStates()
	 * @see #getStateMachineInstance()
	 * @generated
	 */
	EReference getStateMachineInstance_States();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current State</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance#getCurrentState()
	 * @see #getStateMachineInstance()
	 * @generated
	 */
	EReference getStateMachineInstance_CurrentState();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Machine</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance#getStateMachine()
	 * @see #getStateMachineInstance()
	 * @generated
	 */
	EReference getStateMachineInstance_StateMachine();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance <em>State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance
	 * @generated
	 */
	EClass getStateInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject <em>Constrained Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained Instance Object</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject
	 * @generated
	 */
	EClass getConstrainedInstanceObject();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getInstanceObject <em>Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Object</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getInstanceObject()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EReference getConstrainedInstanceObject_InstanceObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getConstraint()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EReference getConstrainedInstanceObject_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getPropagationKind <em>Propagation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Kind</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject#getPropagationKind()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EAttribute getConstrainedInstanceObject_PropagationKind();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance <em>State Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Transition Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance
	 * @generated
	 */
	EClass getStateTransitionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getStateTransition <em>State Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Transition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getStateTransition()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_StateTransition();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getInStates <em>In States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In States</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getInStates()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_InStates();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getCondition()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance#getTargetState()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_TargetState();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance <em>Composite State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite State Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance
	 * @generated
	 */
	EClass getCompositeStateInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance#getTargetState()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_TargetState();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance#getCondition()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance#getCompositeState <em>Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite State</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance#getCompositeState()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_CompositeState();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance <em>Error Flow Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Flow Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance
	 * @generated
	 */
	EClass getErrorFlowInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#getEmv2Element <em>Emv2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emv2 Element</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#getEmv2Element()
	 * @see #getErrorFlowInstance()
	 * @generated
	 */
	EReference getErrorFlowInstance_Emv2Element();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Incoming</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#getIncoming()
	 * @see #getErrorFlowInstance()
	 * @generated
	 */
	EReference getErrorFlowInstance_Incoming();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outgoing</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#getOutgoing()
	 * @see #getErrorFlowInstance()
	 * @generated
	 */
	EReference getErrorFlowInstance_Outgoing();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#isSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#isSource()
	 * @see #getErrorFlowInstance()
	 * @generated
	 */
	EAttribute getErrorFlowInstance_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#isSink <em>Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sink</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorFlowInstance#isSink()
	 * @see #getErrorFlowInstance()
	 * @generated
	 */
	EAttribute getErrorFlowInstance_Sink();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance <em>Error Propagation Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Propagation Condition Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance
	 * @generated
	 */
	EClass getErrorPropagationConditionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getEmv2Element <em>Emv2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emv2 Element</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getEmv2Element()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_Emv2Element();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getInStates <em>In States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In States</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getInStates()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_InStates();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getCondition()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getOutgoingPropagation <em>Outgoing Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outgoing Propagation</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#getOutgoingPropagation()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_OutgoingPropagation();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#isSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#isSource()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EAttribute getErrorPropagationConditionInstance_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#isSink <em>Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sink</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorPropagationConditionInstance#isSink()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EAttribute getErrorPropagationConditionInstance_Sink();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance <em>Error Detection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Detection Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance
	 * @generated
	 */
	EClass getErrorDetectionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getEmv2Element <em>Emv2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emv2 Element</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getEmv2Element()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_Emv2Element();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getInStates <em>In States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In States</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getInStates()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_InStates();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getCondition()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_Condition();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getErrorCode <em>Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Code</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getErrorCode()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EAttribute getErrorDetectionInstance_ErrorCode();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ErrorDetectionInstance#getPort()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_Port();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPointInstance <em>Propagation Point Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Point Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPointInstance
	 * @generated
	 */
	EClass getPropagationPointInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPointInstance#getPropagationPoint <em>Propagation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Propagation Point</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPointInstance#getPropagationPoint()
	 * @see #getPropagationPointInstance()
	 * @generated
	 */
	EReference getPropagationPointInstance_PropagationPoint();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance <em>Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance
	 * @generated
	 */
	EClass getEventInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance#getEvent()
	 * @see #getEventInstance()
	 * @generated
	 */
	EReference getEventInstance_Event();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance#getGeneratedTypedEvents <em>Generated Typed Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generated Typed Events</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance#getGeneratedTypedEvents()
	 * @see #getEventInstance()
	 * @generated
	 */
	EReference getEventInstance_GeneratedTypedEvents();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression <em>Constraint Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Expression</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression
	 * @generated
	 */
	EClass getConstraintExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression#getOperator()
	 * @see #getConstraintExpression()
	 * @generated
	 */
	EAttribute getConstraintExpression_Operator();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression#getK <em>K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>K</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression#getK()
	 * @see #getConstraintExpression()
	 * @generated
	 */
	EAttribute getConstraintExpression_K();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression#getConstraintElements <em>Constraint Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Elements</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintExpression#getConstraintElements()
	 * @see #getConstraintExpression()
	 * @generated
	 */
	EReference getConstraintExpression_ConstraintElements();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintElement <em>Constraint Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Element</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintElement
	 * @generated
	 */
	EClass getConstraintElement();

	/**
	 * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance <em>Propagation Path Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Path Instance</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance
	 * @generated
	 */
	EClass getPropagationPathInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance#getEmv2Element <em>Emv2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emv2 Element</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance#getEmv2Element()
	 * @see #getPropagationPathInstance()
	 * @generated
	 */
	EReference getPropagationPathInstance_Emv2Element();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance#getSource()
	 * @see #getPropagationPathInstance()
	 * @generated
	 */
	EReference getPropagationPathInstance_Source();

	/**
	 * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.PropagationPathInstance#getTarget()
	 * @see #getPropagationPathInstance()
	 * @generated
	 */
	EReference getPropagationPathInstance_Target();

	/**
	 * Returns the meta object for enum '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation <em>EOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EOperation</em>'.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
	 * @generated
	 */
	EEnum getEOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EMV2InstanceFactory getEMV2InstanceFactory();

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
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl <em>EMV2 Annex Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2AnnexInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2AnnexInstance()
		 * @generated
		 */
		EClass EMV2_ANNEX_INSTANCE = eINSTANCE.getEMV2AnnexInstance();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__TRANSITIONS = eINSTANCE.getEMV2AnnexInstance_Transitions();

		/**
		 * The meta object literal for the '<em><b>Propagation Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS = eINSTANCE.getEMV2AnnexInstance_PropagationPoints();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__EVENTS = eINSTANCE.getEMV2AnnexInstance_Events();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__STATE_MACHINE = eINSTANCE.getEMV2AnnexInstance_StateMachine();

		/**
		 * The meta object literal for the '<em><b>Error Propagation Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS = eINSTANCE.getEMV2AnnexInstance_ErrorPropagationConditions();

		/**
		 * The meta object literal for the '<em><b>Error Detections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS = eINSTANCE.getEMV2AnnexInstance_ErrorDetections();

		/**
		 * The meta object literal for the '<em><b>Error Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__ERROR_FLOWS = eINSTANCE.getEMV2AnnexInstance_ErrorFlows();

		/**
		 * The meta object literal for the '<em><b>Composites</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__COMPOSITES = eINSTANCE.getEMV2AnnexInstance_Composites();

		/**
		 * The meta object literal for the '<em><b>Propagation Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS = eINSTANCE.getEMV2AnnexInstance_PropagationPaths();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceObjectImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEMV2InstanceObject()
		 * @generated
		 */
		EClass EMV2_INSTANCE_OBJECT = eINSTANCE.getEMV2InstanceObject();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateMachineInstanceImpl <em>State Machine Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateMachineInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateMachineInstance()
		 * @generated
		 */
		EClass STATE_MACHINE_INSTANCE = eINSTANCE.getStateMachineInstance();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_INSTANCE__STATES = eINSTANCE.getStateMachineInstance_States();

		/**
		 * The meta object literal for the '<em><b>Current State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_INSTANCE__CURRENT_STATE = eINSTANCE.getStateMachineInstance_CurrentState();

		/**
		 * The meta object literal for the '<em><b>State Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_INSTANCE__STATE_MACHINE = eINSTANCE.getStateMachineInstance_StateMachine();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl <em>State Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateInstance()
		 * @generated
		 */
		EClass STATE_INSTANCE = eINSTANCE.getStateInstance();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl <em>Constrained Instance Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstrainedInstanceObjectImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstrainedInstanceObject()
		 * @generated
		 */
		EClass CONSTRAINED_INSTANCE_OBJECT = eINSTANCE.getConstrainedInstanceObject();

		/**
		 * The meta object literal for the '<em><b>Instance Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT = eINSTANCE.getConstrainedInstanceObject_InstanceObject();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT = eINSTANCE.getConstrainedInstanceObject_Constraint();

		/**
		 * The meta object literal for the '<em><b>Propagation Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND = eINSTANCE.getConstrainedInstanceObject_PropagationKind();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl <em>State Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.StateTransitionInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getStateTransitionInstance()
		 * @generated
		 */
		EClass STATE_TRANSITION_INSTANCE = eINSTANCE.getStateTransitionInstance();

		/**
		 * The meta object literal for the '<em><b>State Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TRANSITION_INSTANCE__STATE_TRANSITION = eINSTANCE.getStateTransitionInstance_StateTransition();

		/**
		 * The meta object literal for the '<em><b>In States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TRANSITION_INSTANCE__IN_STATES = eINSTANCE.getStateTransitionInstance_InStates();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TRANSITION_INSTANCE__CONDITION = eINSTANCE.getStateTransitionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_TRANSITION_INSTANCE__TARGET_STATE = eINSTANCE.getStateTransitionInstance_TargetState();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.CompositeStateInstanceImpl <em>Composite State Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.CompositeStateInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getCompositeStateInstance()
		 * @generated
		 */
		EClass COMPOSITE_STATE_INSTANCE = eINSTANCE.getCompositeStateInstance();

		/**
		 * The meta object literal for the '<em><b>Target State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE_INSTANCE__TARGET_STATE = eINSTANCE.getCompositeStateInstance_TargetState();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE_INSTANCE__CONDITION = eINSTANCE.getCompositeStateInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Composite State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE_INSTANCE__COMPOSITE_STATE = eINSTANCE.getCompositeStateInstance_CompositeState();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorFlowInstanceImpl <em>Error Flow Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorFlowInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getErrorFlowInstance()
		 * @generated
		 */
		EClass ERROR_FLOW_INSTANCE = eINSTANCE.getErrorFlowInstance();

		/**
		 * The meta object literal for the '<em><b>Emv2 Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_FLOW_INSTANCE__EMV2_ELEMENT = eINSTANCE.getErrorFlowInstance_Emv2Element();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_FLOW_INSTANCE__INCOMING = eINSTANCE.getErrorFlowInstance_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_FLOW_INSTANCE__OUTGOING = eINSTANCE.getErrorFlowInstance_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_FLOW_INSTANCE__SOURCE = eINSTANCE.getErrorFlowInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Sink</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_FLOW_INSTANCE__SINK = eINSTANCE.getErrorFlowInstance_Sink();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl <em>Error Propagation Condition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorPropagationConditionInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getErrorPropagationConditionInstance()
		 * @generated
		 */
		EClass ERROR_PROPAGATION_CONDITION_INSTANCE = eINSTANCE.getErrorPropagationConditionInstance();

		/**
		 * The meta object literal for the '<em><b>Emv2 Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT = eINSTANCE.getErrorPropagationConditionInstance_Emv2Element();

		/**
		 * The meta object literal for the '<em><b>In States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES = eINSTANCE.getErrorPropagationConditionInstance_InStates();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION = eINSTANCE.getErrorPropagationConditionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Outgoing Propagation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION = eINSTANCE.getErrorPropagationConditionInstance_OutgoingPropagation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE = eINSTANCE.getErrorPropagationConditionInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Sink</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_PROPAGATION_CONDITION_INSTANCE__SINK = eINSTANCE.getErrorPropagationConditionInstance_Sink();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl <em>Error Detection Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ErrorDetectionInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getErrorDetectionInstance()
		 * @generated
		 */
		EClass ERROR_DETECTION_INSTANCE = eINSTANCE.getErrorDetectionInstance();

		/**
		 * The meta object literal for the '<em><b>Emv2 Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_DETECTION_INSTANCE__EMV2_ELEMENT = eINSTANCE.getErrorDetectionInstance_Emv2Element();

		/**
		 * The meta object literal for the '<em><b>In States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_DETECTION_INSTANCE__IN_STATES = eINSTANCE.getErrorDetectionInstance_InStates();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_DETECTION_INSTANCE__CONDITION = eINSTANCE.getErrorDetectionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Error Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_DETECTION_INSTANCE__ERROR_CODE = eINSTANCE.getErrorDetectionInstance_ErrorCode();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_DETECTION_INSTANCE__PORT = eINSTANCE.getErrorDetectionInstance_Port();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPointInstanceImpl <em>Propagation Point Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPointInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getPropagationPointInstance()
		 * @generated
		 */
		EClass PROPAGATION_POINT_INSTANCE = eINSTANCE.getPropagationPointInstance();

		/**
		 * The meta object literal for the '<em><b>Propagation Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_POINT_INSTANCE__PROPAGATION_POINT = eINSTANCE.getPropagationPointInstance_PropagationPoint();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EventInstanceImpl <em>Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EventInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEventInstance()
		 * @generated
		 */
		EClass EVENT_INSTANCE = eINSTANCE.getEventInstance();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_INSTANCE__EVENT = eINSTANCE.getEventInstance_Event();

		/**
		 * The meta object literal for the '<em><b>Generated Typed Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_INSTANCE__GENERATED_TYPED_EVENTS = eINSTANCE.getEventInstance_GeneratedTypedEvents();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintExpressionImpl <em>Constraint Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintExpressionImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstraintExpression()
		 * @generated
		 */
		EClass CONSTRAINT_EXPRESSION = eINSTANCE.getConstraintExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_EXPRESSION__OPERATOR = eINSTANCE.getConstraintExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>K</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT_EXPRESSION__K = eINSTANCE.getConstraintExpression_K();

		/**
		 * The meta object literal for the '<em><b>Constraint Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_EXPRESSION__CONSTRAINT_ELEMENTS = eINSTANCE.getConstraintExpression_ConstraintElements();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintElementImpl <em>Constraint Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.ConstraintElementImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getConstraintElement()
		 * @generated
		 */
		EClass CONSTRAINT_ELEMENT = eINSTANCE.getConstraintElement();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPathInstanceImpl <em>Propagation Path Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.PropagationPathInstanceImpl
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getPropagationPathInstance()
		 * @generated
		 */
		EClass PROPAGATION_PATH_INSTANCE = eINSTANCE.getPropagationPathInstance();

		/**
		 * The meta object literal for the '<em><b>Emv2 Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH_INSTANCE__EMV2_ELEMENT = eINSTANCE.getPropagationPathInstance_Emv2Element();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH_INSTANCE__SOURCE = eINSTANCE.getPropagationPathInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_PATH_INSTANCE__TARGET = eINSTANCE.getPropagationPathInstance_Target();

		/**
		 * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation <em>EOperation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
		 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstancePackageImpl#getEOperation()
		 * @generated
		 */
		EEnum EOPERATION = eINSTANCE.getEOperation();

	}

} //EMV2InstancePackage
