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
 * @see org.osate.aadl2.errormodel.instance.EMV2InstanceFactory
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
	String eNAME = "instance";

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
	EMV2InstancePackage eINSTANCE = org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl <em>EMV2 Annex Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEMV2AnnexInstance()
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
	 * The feature id for the '<em><b>Old Propagation Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__OLD_PROPAGATION_PATHS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Propagations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__PROPAGATIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Propagation Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__STATES = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__INITIAL_STATE = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>EMV2 Annex Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE_FEATURE_COUNT = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.EMV2InstanceObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstanceObjectImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEMV2InstanceObject()
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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.StateMachineInstanceImpl <em>State Machine Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.StateMachineInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateMachineInstance()
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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl <em>State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateInstance()
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
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE__TYPE_SET = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstraintElementImpl <em>Constraint Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConstraintElementImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstraintElement()
	 * @generated
	 */
	int CONSTRAINT_ELEMENT = 11;

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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstrainedInstanceObjectImpl <em>Constrained Instance Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConstrainedInstanceObjectImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstrainedInstanceObject()
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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.StateTransitionInstanceImpl <em>State Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.StateTransitionInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateTransitionInstance()
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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl <em>Composite State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCompositeStateInstance()
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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.ErrorFlowInstance <em>Error Flow Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.ErrorFlowInstance
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorFlowInstance()
	 * @generated
	 */
	int ERROR_FLOW_INSTANCE = 26;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorSourceInstanceImpl <em>Error Source Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorSourceInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorSourceInstance()
	 * @generated
	 */
	int ERROR_SOURCE_INSTANCE = 27;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationConditionInstanceImpl <em>Error Propagation Condition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorPropagationConditionInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorPropagationConditionInstance()
	 * @generated
	 */
	int ERROR_PROPAGATION_CONDITION_INSTANCE = 7;

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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorDetectionInstanceImpl <em>Error Detection Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorDetectionInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorDetectionInstance()
	 * @generated
	 */
	int ERROR_DETECTION_INSTANCE = 8;

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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.PropagationPointInstanceImpl <em>Propagation Point Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.PropagationPointInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getPropagationPointInstance()
	 * @generated
	 */
	int PROPAGATION_POINT_INSTANCE = 30;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.EventInstanceImpl <em>Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.EventInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEventInstance()
	 * @generated
	 */
	int EVENT_INSTANCE = 9;

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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstraintExpressionImpl <em>Constraint Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConstraintExpressionImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstraintExpression()
	 * @generated
	 */
	int CONSTRAINT_EXPRESSION = 10;

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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.OldPropagationPathInstanceImpl <em>Old Propagation Path Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.OldPropagationPathInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOldPropagationPathInstance()
	 * @generated
	 */
	int OLD_PROPAGATION_PATH_INSTANCE = 12;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Emv2 Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__EMV2_ELEMENT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE__TARGET = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Old Propagation Path Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_PROPAGATION_PATH_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl <em>Error Propagation Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorPropagationInstance()
	 * @generated
	 */
	int ERROR_PROPAGATION_INSTANCE = 13;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OWNED_ELEMENT = CONSTRAINED_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OWNED_COMMENT = CONSTRAINED_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__NAME = CONSTRAINED_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__QUALIFIED_NAME = CONSTRAINED_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = CONSTRAINED_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__ANNEX_INSTANCE = CONSTRAINED_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__INSTANCE_OBJECT = CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__CONSTRAINT = CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Propagation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__PROPAGATION_KIND = CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND;

	/**
	 * The feature id for the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Error Sinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__ERROR_SINKS = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Source Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Destination Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Error Propagation Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT = CONSTRAINED_INSTANCE_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConnectionEndPropagationImpl <em>Connection End Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConnectionEndPropagationImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConnectionEndPropagation()
	 * @generated
	 */
	int CONNECTION_END_PROPAGATION = 14;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__OWNED_ELEMENT = ERROR_PROPAGATION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__OWNED_COMMENT = ERROR_PROPAGATION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__NAME = ERROR_PROPAGATION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__QUALIFIED_NAME = ERROR_PROPAGATION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__OWNED_PROPERTY_ASSOCIATION = ERROR_PROPAGATION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__ANNEX_INSTANCE = ERROR_PROPAGATION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__INSTANCE_OBJECT = ERROR_PROPAGATION_INSTANCE__INSTANCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__CONSTRAINT = ERROR_PROPAGATION_INSTANCE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Propagation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__PROPAGATION_KIND = ERROR_PROPAGATION_INSTANCE__PROPAGATION_KIND;

	/**
	 * The feature id for the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__IN_ERROR_PROPAGATION = ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__OUT_ERROR_PROPAGATION = ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__IN_TYPE_SET = ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__OUT_TYPE_SET = ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Error Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__ERROR_SOURCES = ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES;

	/**
	 * The feature id for the '<em><b>Error Sinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__ERROR_SINKS = ERROR_PROPAGATION_INSTANCE__ERROR_SINKS;

	/**
	 * The feature id for the '<em><b>Source Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__SOURCE_ERROR_PATHS = ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Destination Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__DESTINATION_ERROR_PATHS = ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Source Connection Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__SOURCE_CONNECTION_PATHS = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Destination Connection Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION__DESTINATION_CONNECTION_PATHS = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connection End Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_PROPAGATION_FEATURE_COUNT = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.FeaturePropagationImpl <em>Feature Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.FeaturePropagationImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getFeaturePropagation()
	 * @generated
	 */
	int FEATURE_PROPAGATION = 15;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__OWNED_ELEMENT = CONNECTION_END_PROPAGATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__OWNED_COMMENT = CONNECTION_END_PROPAGATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__NAME = CONNECTION_END_PROPAGATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__QUALIFIED_NAME = CONNECTION_END_PROPAGATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__OWNED_PROPERTY_ASSOCIATION = CONNECTION_END_PROPAGATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__ANNEX_INSTANCE = CONNECTION_END_PROPAGATION__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__INSTANCE_OBJECT = CONNECTION_END_PROPAGATION__INSTANCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__CONSTRAINT = CONNECTION_END_PROPAGATION__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Propagation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__PROPAGATION_KIND = CONNECTION_END_PROPAGATION__PROPAGATION_KIND;

	/**
	 * The feature id for the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__IN_ERROR_PROPAGATION = CONNECTION_END_PROPAGATION__IN_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__OUT_ERROR_PROPAGATION = CONNECTION_END_PROPAGATION__OUT_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__IN_TYPE_SET = CONNECTION_END_PROPAGATION__IN_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__OUT_TYPE_SET = CONNECTION_END_PROPAGATION__OUT_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Error Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__ERROR_SOURCES = CONNECTION_END_PROPAGATION__ERROR_SOURCES;

	/**
	 * The feature id for the '<em><b>Error Sinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__ERROR_SINKS = CONNECTION_END_PROPAGATION__ERROR_SINKS;

	/**
	 * The feature id for the '<em><b>Source Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__SOURCE_ERROR_PATHS = CONNECTION_END_PROPAGATION__SOURCE_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Destination Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__DESTINATION_ERROR_PATHS = CONNECTION_END_PROPAGATION__DESTINATION_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Source Connection Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__SOURCE_CONNECTION_PATHS = CONNECTION_END_PROPAGATION__SOURCE_CONNECTION_PATHS;

	/**
	 * The feature id for the '<em><b>Destination Connection Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__DESTINATION_CONNECTION_PATHS = CONNECTION_END_PROPAGATION__DESTINATION_CONNECTION_PATHS;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION__FEATURE = CONNECTION_END_PROPAGATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PROPAGATION_FEATURE_COUNT = CONNECTION_END_PROPAGATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.PointPropagationImpl <em>Point Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.PointPropagationImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getPointPropagation()
	 * @generated
	 */
	int POINT_PROPAGATION = 17;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AccessPropagationImpl <em>Access Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AccessPropagationImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAccessPropagation()
	 * @generated
	 */
	int ACCESS_PROPAGATION = 16;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__OWNED_ELEMENT = CONNECTION_END_PROPAGATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__OWNED_COMMENT = CONNECTION_END_PROPAGATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__NAME = CONNECTION_END_PROPAGATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__QUALIFIED_NAME = CONNECTION_END_PROPAGATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__OWNED_PROPERTY_ASSOCIATION = CONNECTION_END_PROPAGATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__ANNEX_INSTANCE = CONNECTION_END_PROPAGATION__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__INSTANCE_OBJECT = CONNECTION_END_PROPAGATION__INSTANCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__CONSTRAINT = CONNECTION_END_PROPAGATION__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Propagation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__PROPAGATION_KIND = CONNECTION_END_PROPAGATION__PROPAGATION_KIND;

	/**
	 * The feature id for the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__IN_ERROR_PROPAGATION = CONNECTION_END_PROPAGATION__IN_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__OUT_ERROR_PROPAGATION = CONNECTION_END_PROPAGATION__OUT_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__IN_TYPE_SET = CONNECTION_END_PROPAGATION__IN_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__OUT_TYPE_SET = CONNECTION_END_PROPAGATION__OUT_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Error Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__ERROR_SOURCES = CONNECTION_END_PROPAGATION__ERROR_SOURCES;

	/**
	 * The feature id for the '<em><b>Error Sinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__ERROR_SINKS = CONNECTION_END_PROPAGATION__ERROR_SINKS;

	/**
	 * The feature id for the '<em><b>Source Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__SOURCE_ERROR_PATHS = CONNECTION_END_PROPAGATION__SOURCE_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Destination Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__DESTINATION_ERROR_PATHS = CONNECTION_END_PROPAGATION__DESTINATION_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Source Connection Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__SOURCE_CONNECTION_PATHS = CONNECTION_END_PROPAGATION__SOURCE_CONNECTION_PATHS;

	/**
	 * The feature id for the '<em><b>Destination Connection Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION__DESTINATION_CONNECTION_PATHS = CONNECTION_END_PROPAGATION__DESTINATION_CONNECTION_PATHS;

	/**
	 * The number of structural features of the '<em>Access Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_PROPAGATION_FEATURE_COUNT = CONNECTION_END_PROPAGATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__OWNED_ELEMENT = ERROR_PROPAGATION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__OWNED_COMMENT = ERROR_PROPAGATION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__NAME = ERROR_PROPAGATION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__QUALIFIED_NAME = ERROR_PROPAGATION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__OWNED_PROPERTY_ASSOCIATION = ERROR_PROPAGATION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__ANNEX_INSTANCE = ERROR_PROPAGATION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__INSTANCE_OBJECT = ERROR_PROPAGATION_INSTANCE__INSTANCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__CONSTRAINT = ERROR_PROPAGATION_INSTANCE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Propagation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__PROPAGATION_KIND = ERROR_PROPAGATION_INSTANCE__PROPAGATION_KIND;

	/**
	 * The feature id for the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__IN_ERROR_PROPAGATION = ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__OUT_ERROR_PROPAGATION = ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__IN_TYPE_SET = ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__OUT_TYPE_SET = ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Error Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__ERROR_SOURCES = ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES;

	/**
	 * The feature id for the '<em><b>Error Sinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__ERROR_SINKS = ERROR_PROPAGATION_INSTANCE__ERROR_SINKS;

	/**
	 * The feature id for the '<em><b>Source Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__SOURCE_ERROR_PATHS = ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Destination Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__DESTINATION_ERROR_PATHS = ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__POINT = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source User Defined Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination User Defined Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Point Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_PROPAGATION_FEATURE_COUNT = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.BindingPropagationImpl <em>Binding Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.BindingPropagationImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingPropagation()
	 * @generated
	 */
	int BINDING_PROPAGATION = 18;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__OWNED_ELEMENT = ERROR_PROPAGATION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__OWNED_COMMENT = ERROR_PROPAGATION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__NAME = ERROR_PROPAGATION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__QUALIFIED_NAME = ERROR_PROPAGATION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__OWNED_PROPERTY_ASSOCIATION = ERROR_PROPAGATION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__ANNEX_INSTANCE = ERROR_PROPAGATION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__INSTANCE_OBJECT = ERROR_PROPAGATION_INSTANCE__INSTANCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__CONSTRAINT = ERROR_PROPAGATION_INSTANCE__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Propagation Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__PROPAGATION_KIND = ERROR_PROPAGATION_INSTANCE__PROPAGATION_KIND;

	/**
	 * The feature id for the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__IN_ERROR_PROPAGATION = ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__OUT_ERROR_PROPAGATION = ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION;

	/**
	 * The feature id for the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__IN_TYPE_SET = ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__OUT_TYPE_SET = ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET;

	/**
	 * The feature id for the '<em><b>Error Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__ERROR_SOURCES = ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES;

	/**
	 * The feature id for the '<em><b>Error Sinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__ERROR_SINKS = ERROR_PROPAGATION_INSTANCE__ERROR_SINKS;

	/**
	 * The feature id for the '<em><b>Source Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__SOURCE_ERROR_PATHS = ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Destination Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__DESTINATION_ERROR_PATHS = ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__BINDING = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Binding Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__SOURCE_BINDING_PATHS = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination Binding Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION__DESTINATION_BINDING_PATHS = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binding Propagation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PROPAGATION_FEATURE_COUNT = ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.TypeSetElement <em>Type Set Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.TypeSetElement
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeSetElement()
	 * @generated
	 */
	int TYPE_SET_ELEMENT = 19;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_ELEMENT__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_ELEMENT__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_ELEMENT__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_ELEMENT__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_ELEMENT__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_ELEMENT__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Type Set Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_ELEMENT_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.TypeTokenInstance <em>Type Token Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.TypeTokenInstance
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeTokenInstance()
	 * @generated
	 */
	int TYPE_TOKEN_INSTANCE = 20;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TOKEN_INSTANCE__OWNED_ELEMENT = TYPE_SET_ELEMENT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TOKEN_INSTANCE__OWNED_COMMENT = TYPE_SET_ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TOKEN_INSTANCE__NAME = TYPE_SET_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TOKEN_INSTANCE__QUALIFIED_NAME = TYPE_SET_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TOKEN_INSTANCE__OWNED_PROPERTY_ASSOCIATION = TYPE_SET_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TOKEN_INSTANCE__ANNEX_INSTANCE = TYPE_SET_ELEMENT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Type Token Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TOKEN_INSTANCE_FEATURE_COUNT = TYPE_SET_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.TypeInstanceImpl <em>Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.TypeInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeInstance()
	 * @generated
	 */
	int TYPE_INSTANCE = 21;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__OWNED_ELEMENT = TYPE_TOKEN_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__OWNED_COMMENT = TYPE_TOKEN_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__NAME = TYPE_TOKEN_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__QUALIFIED_NAME = TYPE_TOKEN_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = TYPE_TOKEN_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__ANNEX_INSTANCE = TYPE_TOKEN_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE__TYPE = TYPE_TOKEN_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_INSTANCE_FEATURE_COUNT = TYPE_TOKEN_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.TypeSetInstanceImpl <em>Type Set Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.TypeSetInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeSetInstance()
	 * @generated
	 */
	int TYPE_SET_INSTANCE = 24;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AnonymousTypeSetImpl <em>Anonymous Type Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AnonymousTypeSetImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAnonymousTypeSet()
	 * @generated
	 */
	int ANONYMOUS_TYPE_SET = 25;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.TypeProductInstanceImpl <em>Type Product Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.TypeProductInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeProductInstance()
	 * @generated
	 */
	int TYPE_PRODUCT_INSTANCE = 22;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE__OWNED_ELEMENT = TYPE_TOKEN_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE__OWNED_COMMENT = TYPE_TOKEN_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE__NAME = TYPE_TOKEN_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE__QUALIFIED_NAME = TYPE_TOKEN_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = TYPE_TOKEN_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE__ANNEX_INSTANCE = TYPE_TOKEN_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE__TYPES = TYPE_TOKEN_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Product Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_PRODUCT_INSTANCE_FEATURE_COUNT = TYPE_TOKEN_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AbstractTypeSetImpl <em>Abstract Type Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AbstractTypeSetImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAbstractTypeSet()
	 * @generated
	 */
	int ABSTRACT_TYPE_SET = 23;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET__ELEMENTS = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Type Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_SET_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__OWNED_ELEMENT = ABSTRACT_TYPE_SET__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__OWNED_COMMENT = ABSTRACT_TYPE_SET__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__NAME = ABSTRACT_TYPE_SET__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__QUALIFIED_NAME = ABSTRACT_TYPE_SET__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__OWNED_PROPERTY_ASSOCIATION = ABSTRACT_TYPE_SET__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__ANNEX_INSTANCE = ABSTRACT_TYPE_SET__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__ELEMENTS = ABSTRACT_TYPE_SET__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE__TYPE_SET = ABSTRACT_TYPE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Set Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SET_INSTANCE_FEATURE_COUNT = ABSTRACT_TYPE_SET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET__OWNED_ELEMENT = ABSTRACT_TYPE_SET__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET__OWNED_COMMENT = ABSTRACT_TYPE_SET__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET__NAME = ABSTRACT_TYPE_SET__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET__QUALIFIED_NAME = ABSTRACT_TYPE_SET__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET__OWNED_PROPERTY_ASSOCIATION = ABSTRACT_TYPE_SET__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET__ANNEX_INSTANCE = ABSTRACT_TYPE_SET__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET__ELEMENTS = ABSTRACT_TYPE_SET__ELEMENTS;

	/**
	 * The number of structural features of the '<em>Anonymous Type Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANONYMOUS_TYPE_SET_FEATURE_COUNT = ABSTRACT_TYPE_SET_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Error Flow Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_FLOW_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__OWNED_ELEMENT = ERROR_FLOW_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__OWNED_COMMENT = ERROR_FLOW_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__NAME = ERROR_FLOW_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__QUALIFIED_NAME = ERROR_FLOW_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = ERROR_FLOW_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__ANNEX_INSTANCE = ERROR_FLOW_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Error Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__ERROR_SOURCE = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__PROPAGATION = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE__TYPE_SET = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Error Source Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SOURCE_INSTANCE_FEATURE_COUNT = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorSinkInstanceImpl <em>Error Sink Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorSinkInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorSinkInstance()
	 * @generated
	 */
	int ERROR_SINK_INSTANCE = 28;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__OWNED_ELEMENT = ERROR_FLOW_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__OWNED_COMMENT = ERROR_FLOW_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__NAME = ERROR_FLOW_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__QUALIFIED_NAME = ERROR_FLOW_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__OWNED_PROPERTY_ASSOCIATION = ERROR_FLOW_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__ANNEX_INSTANCE = ERROR_FLOW_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Error Sink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__ERROR_SINK = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__PROPAGATION = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE__TYPE_SET = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Error Sink Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_SINK_INSTANCE_FEATURE_COUNT = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl <em>Error Path Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorPathInstance()
	 * @generated
	 */
	int ERROR_PATH_INSTANCE = 29;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__OWNED_ELEMENT = ERROR_FLOW_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__OWNED_COMMENT = ERROR_FLOW_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__NAME = ERROR_FLOW_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__QUALIFIED_NAME = ERROR_FLOW_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__OWNED_PROPERTY_ASSOCIATION = ERROR_FLOW_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__ANNEX_INSTANCE = ERROR_FLOW_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Error Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__ERROR_PATH = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__SOURCE_PROPAGATION = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__SOURCE_TYPE_SET = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Destination Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Destination Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE__DESTINATION_TYPE_SET = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Error Path Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PATH_INSTANCE_FEATURE_COUNT = ERROR_FLOW_INSTANCE_FEATURE_COUNT + 5;

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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.PropagationPathInstance <em>Propagation Path Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.PropagationPathInstance
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getPropagationPathInstance()
	 * @generated
	 */
	int PROPAGATION_PATH_INSTANCE = 31;

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
	 * The number of structural features of the '<em>Propagation Path Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPAGATION_PATH_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConnectionPathImpl <em>Connection Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConnectionPathImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConnectionPath()
	 * @generated
	 */
	int CONNECTION_PATH = 32;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__OWNED_ELEMENT = PROPAGATION_PATH_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__OWNED_COMMENT = PROPAGATION_PATH_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__NAME = PROPAGATION_PATH_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__QUALIFIED_NAME = PROPAGATION_PATH_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__OWNED_PROPERTY_ASSOCIATION = PROPAGATION_PATH_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__ANNEX_INSTANCE = PROPAGATION_PATH_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__CONNECTION = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Propagations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__SOURCE_PROPAGATIONS = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination Propagations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH__DESTINATION_PROPAGATIONS = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connection Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_PATH_FEATURE_COUNT = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.BindingPathImpl <em>Binding Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.BindingPathImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingPath()
	 * @generated
	 */
	int BINDING_PATH = 33;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__OWNED_ELEMENT = PROPAGATION_PATH_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__OWNED_COMMENT = PROPAGATION_PATH_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__NAME = PROPAGATION_PATH_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__QUALIFIED_NAME = PROPAGATION_PATH_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__OWNED_PROPERTY_ASSOCIATION = PROPAGATION_PATH_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__ANNEX_INSTANCE = PROPAGATION_PATH_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__TYPE = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Propagations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__SOURCE_PROPAGATIONS = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination Propagations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH__DESTINATION_PROPAGATIONS = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binding Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_PATH_FEATURE_COUNT = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl <em>User Defined Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getUserDefinedPath()
	 * @generated
	 */
	int USER_DEFINED_PATH = 34;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__OWNED_ELEMENT = PROPAGATION_PATH_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__OWNED_COMMENT = PROPAGATION_PATH_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__NAME = PROPAGATION_PATH_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__QUALIFIED_NAME = PROPAGATION_PATH_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__OWNED_PROPERTY_ASSOCIATION = PROPAGATION_PATH_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__ANNEX_INSTANCE = PROPAGATION_PATH_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__PATH = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__SOURCE_POINT = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__DESTINATION_POINT = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__SOURCE_PROPAGATION = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Destination Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH__DESTINATION_PROPAGATION = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>User Defined Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_PATH_FEATURE_COUNT = PROPAGATION_PATH_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.EOperation <em>EOperation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.EOperation
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEOperation()
	 * @generated
	 */
	int EOPERATION = 35;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.BindingType <em>Binding Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.BindingType
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingType()
	 * @generated
	 */
	int BINDING_TYPE = 36;

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance <em>EMV2 Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMV2 Annex Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance
	 * @generated
	 */
	EClass getEMV2AnnexInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getTransitions()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getPropagationPoints <em>Propagation Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propagation Points</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getPropagationPoints()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_PropagationPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getEvents()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Events();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State Machine</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getStateMachine()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_StateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getErrorPropagationConditions <em>Error Propagation Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Propagation Conditions</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getErrorPropagationConditions()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_ErrorPropagationConditions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getErrorDetections <em>Error Detections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Detections</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getErrorDetections()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_ErrorDetections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getErrorFlows <em>Error Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Error Flows</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getErrorFlows()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_ErrorFlows();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getComposites <em>Composites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composites</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getComposites()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Composites();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getOldPropagationPaths <em>Old Propagation Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Old Propagation Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getOldPropagationPaths()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_OldPropagationPaths();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getPropagations <em>Propagations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propagations</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getPropagations()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Propagations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getPropagationPaths <em>Propagation Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Propagation Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getPropagationPaths()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_PropagationPaths();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getStates()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_States();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getInitialState()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_InitialState();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.EMV2InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstanceObject
	 * @generated
	 */
	EClass getEMV2InstanceObject();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.StateMachineInstance <em>State Machine Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateMachineInstance
	 * @generated
	 */
	EClass getStateMachineInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.StateMachineInstance#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateMachineInstance#getStates()
	 * @see #getStateMachineInstance()
	 * @generated
	 */
	EReference getStateMachineInstance_States();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.StateMachineInstance#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateMachineInstance#getCurrentState()
	 * @see #getStateMachineInstance()
	 * @generated
	 */
	EReference getStateMachineInstance_CurrentState();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.StateMachineInstance#getStateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Machine</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateMachineInstance#getStateMachine()
	 * @see #getStateMachineInstance()
	 * @generated
	 */
	EReference getStateMachineInstance_StateMachine();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.StateInstance <em>State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateInstance
	 * @generated
	 */
	EClass getStateInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.StateInstance#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateInstance#getState()
	 * @see #getStateInstance()
	 * @generated
	 */
	EReference getStateInstance_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.StateInstance#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateInstance#getTypeSet()
	 * @see #getStateInstance()
	 * @generated
	 */
	EReference getStateInstance_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject <em>Constrained Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained Instance Object</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject
	 * @generated
	 */
	EClass getConstrainedInstanceObject();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject#getInstanceObject <em>Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance Object</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject#getInstanceObject()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EReference getConstrainedInstanceObject_InstanceObject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject#getConstraint()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EReference getConstrainedInstanceObject_Constraint();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject#getPropagationKind <em>Propagation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation Kind</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject#getPropagationKind()
	 * @see #getConstrainedInstanceObject()
	 * @generated
	 */
	EAttribute getConstrainedInstanceObject_PropagationKind();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.StateTransitionInstance <em>State Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Transition Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateTransitionInstance
	 * @generated
	 */
	EClass getStateTransitionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.StateTransitionInstance#getStateTransition <em>State Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State Transition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateTransitionInstance#getStateTransition()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_StateTransition();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.StateTransitionInstance#getInStates <em>In States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In States</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateTransitionInstance#getInStates()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_InStates();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.StateTransitionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateTransitionInstance#getCondition()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.StateTransitionInstance#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateTransitionInstance#getTargetState()
	 * @see #getStateTransitionInstance()
	 * @generated
	 */
	EReference getStateTransitionInstance_TargetState();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance <em>Composite State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite State Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance
	 * @generated
	 */
	EClass getCompositeStateInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance#getTargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance#getTargetState()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_TargetState();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance#getCondition()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance#getCompositeState <em>Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance#getCompositeState()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_CompositeState();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorFlowInstance <em>Error Flow Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Flow Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorFlowInstance
	 * @generated
	 */
	EClass getErrorFlowInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorSourceInstance <em>Error Source Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Source Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSourceInstance
	 * @generated
	 */
	EClass getErrorSourceInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorSourceInstance#getErrorSource <em>Error Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Source</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSourceInstance#getErrorSource()
	 * @see #getErrorSourceInstance()
	 * @generated
	 */
	EReference getErrorSourceInstance_ErrorSource();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorSourceInstance#getPropagation <em>Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSourceInstance#getPropagation()
	 * @see #getErrorSourceInstance()
	 * @generated
	 */
	EReference getErrorSourceInstance_Propagation();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorSourceInstance#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSourceInstance#getTypeSet()
	 * @see #getErrorSourceInstance()
	 * @generated
	 */
	EReference getErrorSourceInstance_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorSinkInstance <em>Error Sink Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Sink Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSinkInstance
	 * @generated
	 */
	EClass getErrorSinkInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorSinkInstance#getErrorSink <em>Error Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Sink</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSinkInstance#getErrorSink()
	 * @see #getErrorSinkInstance()
	 * @generated
	 */
	EReference getErrorSinkInstance_ErrorSink();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorSinkInstance#getPropagation <em>Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSinkInstance#getPropagation()
	 * @see #getErrorSinkInstance()
	 * @generated
	 */
	EReference getErrorSinkInstance_Propagation();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorSinkInstance#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSinkInstance#getTypeSet()
	 * @see #getErrorSinkInstance()
	 * @generated
	 */
	EReference getErrorSinkInstance_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance <em>Error Path Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Path Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPathInstance
	 * @generated
	 */
	EClass getErrorPathInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getErrorPath <em>Error Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Path</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPathInstance#getErrorPath()
	 * @see #getErrorPathInstance()
	 * @generated
	 */
	EReference getErrorPathInstance_ErrorPath();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourcePropagation <em>Source Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourcePropagation()
	 * @see #getErrorPathInstance()
	 * @generated
	 */
	EReference getErrorPathInstance_SourcePropagation();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationPropagation <em>Destination Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationPropagation()
	 * @see #getErrorPathInstance()
	 * @generated
	 */
	EReference getErrorPathInstance_DestinationPropagation();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationTypeSet <em>Destination Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationTypeSet()
	 * @see #getErrorPathInstance()
	 * @generated
	 */
	EReference getErrorPathInstance_DestinationTypeSet();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourceTypeSet <em>Source Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourceTypeSet()
	 * @see #getErrorPathInstance()
	 * @generated
	 */
	EReference getErrorPathInstance_SourceTypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance <em>Error Propagation Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Propagation Condition Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance
	 * @generated
	 */
	EClass getErrorPropagationConditionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getEmv2Element <em>Emv2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emv2 Element</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getEmv2Element()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_Emv2Element();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getInStates <em>In States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In States</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getInStates()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_InStates();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getCondition()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getOutgoingPropagation <em>Outgoing Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outgoing Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#getOutgoingPropagation()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EReference getErrorPropagationConditionInstance_OutgoingPropagation();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#isSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#isSource()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EAttribute getErrorPropagationConditionInstance_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#isSink <em>Sink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sink</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance#isSink()
	 * @see #getErrorPropagationConditionInstance()
	 * @generated
	 */
	EAttribute getErrorPropagationConditionInstance_Sink();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorDetectionInstance <em>Error Detection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Detection Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorDetectionInstance
	 * @generated
	 */
	EClass getErrorDetectionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getEmv2Element <em>Emv2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emv2 Element</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getEmv2Element()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_Emv2Element();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getInStates <em>In States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In States</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getInStates()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_InStates();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getCondition()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_Condition();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getErrorCode <em>Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getErrorCode()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EAttribute getErrorDetectionInstance_ErrorCode();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorDetectionInstance#getPort()
	 * @see #getErrorDetectionInstance()
	 * @generated
	 */
	EReference getErrorDetectionInstance_Port();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.PropagationPointInstance <em>Propagation Point Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Point Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.PropagationPointInstance
	 * @generated
	 */
	EClass getPropagationPointInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.PropagationPointInstance#getPropagationPoint <em>Propagation Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Propagation Point</em>'.
	 * @see org.osate.aadl2.errormodel.instance.PropagationPointInstance#getPropagationPoint()
	 * @see #getPropagationPointInstance()
	 * @generated
	 */
	EReference getPropagationPointInstance_PropagationPoint();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.PropagationPathInstance <em>Propagation Path Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Propagation Path Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.PropagationPathInstance
	 * @generated
	 */
	EClass getPropagationPathInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConnectionPath <em>Connection Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Path</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionPath
	 * @generated
	 */
	EClass getConnectionPath();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ConnectionPath#getConnection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionPath#getConnection()
	 * @see #getConnectionPath()
	 * @generated
	 */
	EReference getConnectionPath_Connection();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ConnectionPath#getSourcePropagations <em>Source Propagations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Propagations</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionPath#getSourcePropagations()
	 * @see #getConnectionPath()
	 * @generated
	 */
	EReference getConnectionPath_SourcePropagations();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ConnectionPath#getDestinationPropagations <em>Destination Propagations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination Propagations</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionPath#getDestinationPropagations()
	 * @see #getConnectionPath()
	 * @generated
	 */
	EReference getConnectionPath_DestinationPropagations();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.BindingPath <em>Binding Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Path</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPath
	 * @generated
	 */
	EClass getBindingPath();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.BindingPath#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPath#getType()
	 * @see #getBindingPath()
	 * @generated
	 */
	EAttribute getBindingPath_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.BindingPath#getSourcePropagations <em>Source Propagations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Propagations</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPath#getSourcePropagations()
	 * @see #getBindingPath()
	 * @generated
	 */
	EReference getBindingPath_SourcePropagations();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.BindingPath#getDestinationPropagations <em>Destination Propagations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination Propagations</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPath#getDestinationPropagations()
	 * @see #getBindingPath()
	 * @generated
	 */
	EReference getBindingPath_DestinationPropagations();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath <em>User Defined Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Defined Path</em>'.
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath
	 * @generated
	 */
	EClass getUserDefinedPath();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Path</em>'.
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath#getPath()
	 * @see #getUserDefinedPath()
	 * @generated
	 */
	EReference getUserDefinedPath_Path();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePoint <em>Source Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Point</em>'.
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePoint()
	 * @see #getUserDefinedPath()
	 * @generated
	 */
	EReference getUserDefinedPath_SourcePoint();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPoint <em>Destination Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination Point</em>'.
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPoint()
	 * @see #getUserDefinedPath()
	 * @generated
	 */
	EReference getUserDefinedPath_DestinationPoint();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePropagation <em>Source Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePropagation()
	 * @see #getUserDefinedPath()
	 * @generated
	 */
	EReference getUserDefinedPath_SourcePropagation();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPropagation <em>Destination Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPropagation()
	 * @see #getUserDefinedPath()
	 * @generated
	 */
	EReference getUserDefinedPath_DestinationPropagation();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.EventInstance <em>Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EventInstance
	 * @generated
	 */
	EClass getEventInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.EventInstance#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EventInstance#getEvent()
	 * @see #getEventInstance()
	 * @generated
	 */
	EReference getEventInstance_Event();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EventInstance#getGeneratedTypedEvents <em>Generated Typed Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generated Typed Events</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EventInstance#getGeneratedTypedEvents()
	 * @see #getEventInstance()
	 * @generated
	 */
	EReference getEventInstance_GeneratedTypedEvents();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConstraintExpression <em>Constraint Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Expression</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstraintExpression
	 * @generated
	 */
	EClass getConstraintExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.ConstraintExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstraintExpression#getOperator()
	 * @see #getConstraintExpression()
	 * @generated
	 */
	EAttribute getConstraintExpression_Operator();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.ConstraintExpression#getK <em>K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>K</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstraintExpression#getK()
	 * @see #getConstraintExpression()
	 * @generated
	 */
	EAttribute getConstraintExpression_K();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.ConstraintExpression#getConstraintElements <em>Constraint Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Elements</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstraintExpression#getConstraintElements()
	 * @see #getConstraintExpression()
	 * @generated
	 */
	EReference getConstraintExpression_ConstraintElements();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConstraintElement <em>Constraint Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Element</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstraintElement
	 * @generated
	 */
	EClass getConstraintElement();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.OldPropagationPathInstance <em>Old Propagation Path Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Old Propagation Path Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OldPropagationPathInstance
	 * @generated
	 */
	EClass getOldPropagationPathInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.OldPropagationPathInstance#getEmv2Element <em>Emv2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Emv2 Element</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OldPropagationPathInstance#getEmv2Element()
	 * @see #getOldPropagationPathInstance()
	 * @generated
	 */
	EReference getOldPropagationPathInstance_Emv2Element();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.OldPropagationPathInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OldPropagationPathInstance#getSource()
	 * @see #getOldPropagationPathInstance()
	 * @generated
	 */
	EReference getOldPropagationPathInstance_Source();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.OldPropagationPathInstance#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OldPropagationPathInstance#getTarget()
	 * @see #getOldPropagationPathInstance()
	 * @generated
	 */
	EReference getOldPropagationPathInstance_Target();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance <em>Error Propagation Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Propagation Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance
	 * @generated
	 */
	EClass getErrorPropagationInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInErrorPropagation <em>In Error Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Error Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInErrorPropagation()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_InErrorPropagation();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutErrorPropagation <em>Out Error Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Out Error Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutErrorPropagation()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_OutErrorPropagation();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInTypeSet <em>In Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInTypeSet()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_InTypeSet();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutTypeSet <em>Out Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Out Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutTypeSet()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_OutTypeSet();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getErrorSources <em>Error Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Error Sources</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getErrorSources()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_ErrorSources();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getErrorSinks <em>Error Sinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Error Sinks</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getErrorSinks()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_ErrorSinks();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getSourceErrorPaths <em>Source Error Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Error Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getSourceErrorPaths()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_SourceErrorPaths();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getDestinationErrorPaths <em>Destination Error Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination Error Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getDestinationErrorPaths()
	 * @see #getErrorPropagationInstance()
	 * @generated
	 */
	EReference getErrorPropagationInstance_DestinationErrorPaths();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConnectionEndPropagation <em>Connection End Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection End Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionEndPropagation
	 * @generated
	 */
	EClass getConnectionEndPropagation();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ConnectionEndPropagation#getSourceConnectionPaths <em>Source Connection Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Connection Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionEndPropagation#getSourceConnectionPaths()
	 * @see #getConnectionEndPropagation()
	 * @generated
	 */
	EReference getConnectionEndPropagation_SourceConnectionPaths();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ConnectionEndPropagation#getDestinationConnectionPaths <em>Destination Connection Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination Connection Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionEndPropagation#getDestinationConnectionPaths()
	 * @see #getConnectionEndPropagation()
	 * @generated
	 */
	EReference getConnectionEndPropagation_DestinationConnectionPaths();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.FeaturePropagation <em>Feature Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.FeaturePropagation
	 * @generated
	 */
	EClass getFeaturePropagation();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.FeaturePropagation#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.osate.aadl2.errormodel.instance.FeaturePropagation#getFeature()
	 * @see #getFeaturePropagation()
	 * @generated
	 */
	EReference getFeaturePropagation_Feature();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.PointPropagation <em>Point Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.PointPropagation
	 * @generated
	 */
	EClass getPointPropagation();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.PointPropagation#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Point</em>'.
	 * @see org.osate.aadl2.errormodel.instance.PointPropagation#getPoint()
	 * @see #getPointPropagation()
	 * @generated
	 */
	EReference getPointPropagation_Point();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.PointPropagation#getSourceUserDefinedPaths <em>Source User Defined Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source User Defined Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.PointPropagation#getSourceUserDefinedPaths()
	 * @see #getPointPropagation()
	 * @generated
	 */
	EReference getPointPropagation_SourceUserDefinedPaths();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.PointPropagation#getDestinationUserDefinedPaths <em>Destination User Defined Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination User Defined Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.PointPropagation#getDestinationUserDefinedPaths()
	 * @see #getPointPropagation()
	 * @generated
	 */
	EReference getPointPropagation_DestinationUserDefinedPaths();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.AccessPropagation <em>Access Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AccessPropagation
	 * @generated
	 */
	EClass getAccessPropagation();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.BindingPropagation <em>Binding Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPropagation
	 * @generated
	 */
	EClass getBindingPropagation();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.BindingPropagation#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPropagation#getBinding()
	 * @see #getBindingPropagation()
	 * @generated
	 */
	EAttribute getBindingPropagation_Binding();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.BindingPropagation#getSourceBindingPaths <em>Source Binding Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Binding Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPropagation#getSourceBindingPaths()
	 * @see #getBindingPropagation()
	 * @generated
	 */
	EReference getBindingPropagation_SourceBindingPaths();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.BindingPropagation#getDestinationBindingPaths <em>Destination Binding Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Destination Binding Paths</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingPropagation#getDestinationBindingPaths()
	 * @see #getBindingPropagation()
	 * @generated
	 */
	EReference getBindingPropagation_DestinationBindingPaths();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.TypeSetElement <em>Type Set Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Set Element</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeSetElement
	 * @generated
	 */
	EClass getTypeSetElement();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.TypeTokenInstance <em>Type Token Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Token Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeTokenInstance
	 * @generated
	 */
	EClass getTypeTokenInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.TypeInstance <em>Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeInstance
	 * @generated
	 */
	EClass getTypeInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.TypeInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeInstance#getType()
	 * @see #getTypeInstance()
	 * @generated
	 */
	EReference getTypeInstance_Type();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.TypeSetInstance <em>Type Set Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Set Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeSetInstance
	 * @generated
	 */
	EClass getTypeSetInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.TypeSetInstance#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeSetInstance#getTypeSet()
	 * @see #getTypeSetInstance()
	 * @generated
	 */
	EReference getTypeSetInstance_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.AnonymousTypeSet <em>Anonymous Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Anonymous Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AnonymousTypeSet
	 * @generated
	 */
	EClass getAnonymousTypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.TypeProductInstance <em>Type Product Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Product Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeProductInstance
	 * @generated
	 */
	EClass getTypeProductInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.TypeProductInstance#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TypeProductInstance#getTypes()
	 * @see #getTypeProductInstance()
	 * @generated
	 */
	EReference getTypeProductInstance_Types();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.AbstractTypeSet <em>Abstract Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AbstractTypeSet
	 * @generated
	 */
	EClass getAbstractTypeSet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.AbstractTypeSet#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AbstractTypeSet#getElements()
	 * @see #getAbstractTypeSet()
	 * @generated
	 */
	EReference getAbstractTypeSet_Elements();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.instance.EOperation <em>EOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EOperation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EOperation
	 * @generated
	 */
	EEnum getEOperation();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.instance.BindingType <em>Binding Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binding Type</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingType
	 * @generated
	 */
	EEnum getBindingType();

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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl <em>EMV2 Annex Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2AnnexInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEMV2AnnexInstance()
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
		EReference EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS = eINSTANCE
				.getEMV2AnnexInstance_ErrorPropagationConditions();

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
		 * The meta object literal for the '<em><b>Old Propagation Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__OLD_PROPAGATION_PATHS = eINSTANCE.getEMV2AnnexInstance_OldPropagationPaths();

		/**
		 * The meta object literal for the '<em><b>Propagations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__PROPAGATIONS = eINSTANCE.getEMV2AnnexInstance_Propagations();

		/**
		 * The meta object literal for the '<em><b>Propagation Paths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS = eINSTANCE.getEMV2AnnexInstance_PropagationPaths();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__STATES = eINSTANCE.getEMV2AnnexInstance_States();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__INITIAL_STATE = eINSTANCE.getEMV2AnnexInstance_InitialState();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.EMV2InstanceObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstanceObjectImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEMV2InstanceObject()
		 * @generated
		 */
		EClass EMV2_INSTANCE_OBJECT = eINSTANCE.getEMV2InstanceObject();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.StateMachineInstanceImpl <em>State Machine Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.StateMachineInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateMachineInstance()
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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl <em>State Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateInstance()
		 * @generated
		 */
		EClass STATE_INSTANCE = eINSTANCE.getStateInstance();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_INSTANCE__STATE = eINSTANCE.getStateInstance_State();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_INSTANCE__TYPE_SET = eINSTANCE.getStateInstance_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstrainedInstanceObjectImpl <em>Constrained Instance Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ConstrainedInstanceObjectImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstrainedInstanceObject()
		 * @generated
		 */
		EClass CONSTRAINED_INSTANCE_OBJECT = eINSTANCE.getConstrainedInstanceObject();

		/**
		 * The meta object literal for the '<em><b>Instance Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT = eINSTANCE
				.getConstrainedInstanceObject_InstanceObject();

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
		EAttribute CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND = eINSTANCE
				.getConstrainedInstanceObject_PropagationKind();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.StateTransitionInstanceImpl <em>State Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.StateTransitionInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateTransitionInstance()
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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl <em>Composite State Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCompositeStateInstance()
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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.ErrorFlowInstance <em>Error Flow Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.ErrorFlowInstance
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorFlowInstance()
		 * @generated
		 */
		EClass ERROR_FLOW_INSTANCE = eINSTANCE.getErrorFlowInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorSourceInstanceImpl <em>Error Source Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ErrorSourceInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorSourceInstance()
		 * @generated
		 */
		EClass ERROR_SOURCE_INSTANCE = eINSTANCE.getErrorSourceInstance();

		/**
		 * The meta object literal for the '<em><b>Error Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_SOURCE_INSTANCE__ERROR_SOURCE = eINSTANCE.getErrorSourceInstance_ErrorSource();

		/**
		 * The meta object literal for the '<em><b>Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_SOURCE_INSTANCE__PROPAGATION = eINSTANCE.getErrorSourceInstance_Propagation();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_SOURCE_INSTANCE__TYPE_SET = eINSTANCE.getErrorSourceInstance_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorSinkInstanceImpl <em>Error Sink Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ErrorSinkInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorSinkInstance()
		 * @generated
		 */
		EClass ERROR_SINK_INSTANCE = eINSTANCE.getErrorSinkInstance();

		/**
		 * The meta object literal for the '<em><b>Error Sink</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_SINK_INSTANCE__ERROR_SINK = eINSTANCE.getErrorSinkInstance_ErrorSink();

		/**
		 * The meta object literal for the '<em><b>Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_SINK_INSTANCE__PROPAGATION = eINSTANCE.getErrorSinkInstance_Propagation();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_SINK_INSTANCE__TYPE_SET = eINSTANCE.getErrorSinkInstance_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl <em>Error Path Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ErrorPathInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorPathInstance()
		 * @generated
		 */
		EClass ERROR_PATH_INSTANCE = eINSTANCE.getErrorPathInstance();

		/**
		 * The meta object literal for the '<em><b>Error Path</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PATH_INSTANCE__ERROR_PATH = eINSTANCE.getErrorPathInstance_ErrorPath();

		/**
		 * The meta object literal for the '<em><b>Source Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PATH_INSTANCE__SOURCE_PROPAGATION = eINSTANCE.getErrorPathInstance_SourcePropagation();

		/**
		 * The meta object literal for the '<em><b>Destination Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION = eINSTANCE
				.getErrorPathInstance_DestinationPropagation();

		/**
		 * The meta object literal for the '<em><b>Destination Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PATH_INSTANCE__DESTINATION_TYPE_SET = eINSTANCE.getErrorPathInstance_DestinationTypeSet();

		/**
		 * The meta object literal for the '<em><b>Source Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PATH_INSTANCE__SOURCE_TYPE_SET = eINSTANCE.getErrorPathInstance_SourceTypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationConditionInstanceImpl <em>Error Propagation Condition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ErrorPropagationConditionInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorPropagationConditionInstance()
		 * @generated
		 */
		EClass ERROR_PROPAGATION_CONDITION_INSTANCE = eINSTANCE.getErrorPropagationConditionInstance();

		/**
		 * The meta object literal for the '<em><b>Emv2 Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT = eINSTANCE
				.getErrorPropagationConditionInstance_Emv2Element();

		/**
		 * The meta object literal for the '<em><b>In States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES = eINSTANCE
				.getErrorPropagationConditionInstance_InStates();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION = eINSTANCE
				.getErrorPropagationConditionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Outgoing Propagation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION = eINSTANCE
				.getErrorPropagationConditionInstance_OutgoingPropagation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE = eINSTANCE
				.getErrorPropagationConditionInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Sink</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_PROPAGATION_CONDITION_INSTANCE__SINK = eINSTANCE.getErrorPropagationConditionInstance_Sink();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorDetectionInstanceImpl <em>Error Detection Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ErrorDetectionInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorDetectionInstance()
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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.PropagationPointInstanceImpl <em>Propagation Point Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.PropagationPointInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getPropagationPointInstance()
		 * @generated
		 */
		EClass PROPAGATION_POINT_INSTANCE = eINSTANCE.getPropagationPointInstance();

		/**
		 * The meta object literal for the '<em><b>Propagation Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPAGATION_POINT_INSTANCE__PROPAGATION_POINT = eINSTANCE
				.getPropagationPointInstance_PropagationPoint();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.PropagationPathInstance <em>Propagation Path Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.PropagationPathInstance
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getPropagationPathInstance()
		 * @generated
		 */
		EClass PROPAGATION_PATH_INSTANCE = eINSTANCE.getPropagationPathInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ConnectionPathImpl <em>Connection Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ConnectionPathImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConnectionPath()
		 * @generated
		 */
		EClass CONNECTION_PATH = eINSTANCE.getConnectionPath();

		/**
		 * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_PATH__CONNECTION = eINSTANCE.getConnectionPath_Connection();

		/**
		 * The meta object literal for the '<em><b>Source Propagations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_PATH__SOURCE_PROPAGATIONS = eINSTANCE.getConnectionPath_SourcePropagations();

		/**
		 * The meta object literal for the '<em><b>Destination Propagations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_PATH__DESTINATION_PROPAGATIONS = eINSTANCE.getConnectionPath_DestinationPropagations();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.BindingPathImpl <em>Binding Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.BindingPathImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingPath()
		 * @generated
		 */
		EClass BINDING_PATH = eINSTANCE.getBindingPath();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_PATH__TYPE = eINSTANCE.getBindingPath_Type();

		/**
		 * The meta object literal for the '<em><b>Source Propagations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_PATH__SOURCE_PROPAGATIONS = eINSTANCE.getBindingPath_SourcePropagations();

		/**
		 * The meta object literal for the '<em><b>Destination Propagations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_PATH__DESTINATION_PROPAGATIONS = eINSTANCE.getBindingPath_DestinationPropagations();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl <em>User Defined Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.UserDefinedPathImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getUserDefinedPath()
		 * @generated
		 */
		EClass USER_DEFINED_PATH = eINSTANCE.getUserDefinedPath();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_PATH__PATH = eINSTANCE.getUserDefinedPath_Path();

		/**
		 * The meta object literal for the '<em><b>Source Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_PATH__SOURCE_POINT = eINSTANCE.getUserDefinedPath_SourcePoint();

		/**
		 * The meta object literal for the '<em><b>Destination Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_PATH__DESTINATION_POINT = eINSTANCE.getUserDefinedPath_DestinationPoint();

		/**
		 * The meta object literal for the '<em><b>Source Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_PATH__SOURCE_PROPAGATION = eINSTANCE.getUserDefinedPath_SourcePropagation();

		/**
		 * The meta object literal for the '<em><b>Destination Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DEFINED_PATH__DESTINATION_PROPAGATION = eINSTANCE.getUserDefinedPath_DestinationPropagation();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.EventInstanceImpl <em>Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.EventInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEventInstance()
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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstraintExpressionImpl <em>Constraint Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ConstraintExpressionImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstraintExpression()
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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstraintElementImpl <em>Constraint Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ConstraintElementImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstraintElement()
		 * @generated
		 */
		EClass CONSTRAINT_ELEMENT = eINSTANCE.getConstraintElement();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.OldPropagationPathInstanceImpl <em>Old Propagation Path Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.OldPropagationPathInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOldPropagationPathInstance()
		 * @generated
		 */
		EClass OLD_PROPAGATION_PATH_INSTANCE = eINSTANCE.getOldPropagationPathInstance();

		/**
		 * The meta object literal for the '<em><b>Emv2 Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OLD_PROPAGATION_PATH_INSTANCE__EMV2_ELEMENT = eINSTANCE.getOldPropagationPathInstance_Emv2Element();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OLD_PROPAGATION_PATH_INSTANCE__SOURCE = eINSTANCE.getOldPropagationPathInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OLD_PROPAGATION_PATH_INSTANCE__TARGET = eINSTANCE.getOldPropagationPathInstance_Target();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl <em>Error Propagation Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorPropagationInstance()
		 * @generated
		 */
		EClass ERROR_PROPAGATION_INSTANCE = eINSTANCE.getErrorPropagationInstance();

		/**
		 * The meta object literal for the '<em><b>In Error Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION = eINSTANCE
				.getErrorPropagationInstance_InErrorPropagation();

		/**
		 * The meta object literal for the '<em><b>Out Error Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION = eINSTANCE
				.getErrorPropagationInstance_OutErrorPropagation();

		/**
		 * The meta object literal for the '<em><b>In Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET = eINSTANCE.getErrorPropagationInstance_InTypeSet();

		/**
		 * The meta object literal for the '<em><b>Out Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET = eINSTANCE.getErrorPropagationInstance_OutTypeSet();

		/**
		 * The meta object literal for the '<em><b>Error Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES = eINSTANCE.getErrorPropagationInstance_ErrorSources();

		/**
		 * The meta object literal for the '<em><b>Error Sinks</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__ERROR_SINKS = eINSTANCE.getErrorPropagationInstance_ErrorSinks();

		/**
		 * The meta object literal for the '<em><b>Source Error Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS = eINSTANCE
				.getErrorPropagationInstance_SourceErrorPaths();

		/**
		 * The meta object literal for the '<em><b>Destination Error Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS = eINSTANCE
				.getErrorPropagationInstance_DestinationErrorPaths();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ConnectionEndPropagationImpl <em>Connection End Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ConnectionEndPropagationImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConnectionEndPropagation()
		 * @generated
		 */
		EClass CONNECTION_END_PROPAGATION = eINSTANCE.getConnectionEndPropagation();

		/**
		 * The meta object literal for the '<em><b>Source Connection Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_END_PROPAGATION__SOURCE_CONNECTION_PATHS = eINSTANCE
				.getConnectionEndPropagation_SourceConnectionPaths();

		/**
		 * The meta object literal for the '<em><b>Destination Connection Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_END_PROPAGATION__DESTINATION_CONNECTION_PATHS = eINSTANCE
				.getConnectionEndPropagation_DestinationConnectionPaths();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.FeaturePropagationImpl <em>Feature Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.FeaturePropagationImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getFeaturePropagation()
		 * @generated
		 */
		EClass FEATURE_PROPAGATION = eINSTANCE.getFeaturePropagation();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PROPAGATION__FEATURE = eINSTANCE.getFeaturePropagation_Feature();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.PointPropagationImpl <em>Point Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.PointPropagationImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getPointPropagation()
		 * @generated
		 */
		EClass POINT_PROPAGATION = eINSTANCE.getPointPropagation();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_PROPAGATION__POINT = eINSTANCE.getPointPropagation_Point();

		/**
		 * The meta object literal for the '<em><b>Source User Defined Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS = eINSTANCE
				.getPointPropagation_SourceUserDefinedPaths();

		/**
		 * The meta object literal for the '<em><b>Destination User Defined Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS = eINSTANCE
				.getPointPropagation_DestinationUserDefinedPaths();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.AccessPropagationImpl <em>Access Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.AccessPropagationImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAccessPropagation()
		 * @generated
		 */
		EClass ACCESS_PROPAGATION = eINSTANCE.getAccessPropagation();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.BindingPropagationImpl <em>Binding Propagation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.BindingPropagationImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingPropagation()
		 * @generated
		 */
		EClass BINDING_PROPAGATION = eINSTANCE.getBindingPropagation();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_PROPAGATION__BINDING = eINSTANCE.getBindingPropagation_Binding();

		/**
		 * The meta object literal for the '<em><b>Source Binding Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_PROPAGATION__SOURCE_BINDING_PATHS = eINSTANCE.getBindingPropagation_SourceBindingPaths();

		/**
		 * The meta object literal for the '<em><b>Destination Binding Paths</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_PROPAGATION__DESTINATION_BINDING_PATHS = eINSTANCE
				.getBindingPropagation_DestinationBindingPaths();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.TypeSetElement <em>Type Set Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.TypeSetElement
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeSetElement()
		 * @generated
		 */
		EClass TYPE_SET_ELEMENT = eINSTANCE.getTypeSetElement();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.TypeTokenInstance <em>Type Token Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.TypeTokenInstance
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeTokenInstance()
		 * @generated
		 */
		EClass TYPE_TOKEN_INSTANCE = eINSTANCE.getTypeTokenInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.TypeInstanceImpl <em>Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.TypeInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeInstance()
		 * @generated
		 */
		EClass TYPE_INSTANCE = eINSTANCE.getTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_INSTANCE__TYPE = eINSTANCE.getTypeInstance_Type();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.TypeSetInstanceImpl <em>Type Set Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.TypeSetInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeSetInstance()
		 * @generated
		 */
		EClass TYPE_SET_INSTANCE = eINSTANCE.getTypeSetInstance();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SET_INSTANCE__TYPE_SET = eINSTANCE.getTypeSetInstance_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.AnonymousTypeSetImpl <em>Anonymous Type Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.AnonymousTypeSetImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAnonymousTypeSet()
		 * @generated
		 */
		EClass ANONYMOUS_TYPE_SET = eINSTANCE.getAnonymousTypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.TypeProductInstanceImpl <em>Type Product Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.TypeProductInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeProductInstance()
		 * @generated
		 */
		EClass TYPE_PRODUCT_INSTANCE = eINSTANCE.getTypeProductInstance();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_PRODUCT_INSTANCE__TYPES = eINSTANCE.getTypeProductInstance_Types();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.AbstractTypeSetImpl <em>Abstract Type Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.AbstractTypeSetImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAbstractTypeSet()
		 * @generated
		 */
		EClass ABSTRACT_TYPE_SET = eINSTANCE.getAbstractTypeSet();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TYPE_SET__ELEMENTS = eINSTANCE.getAbstractTypeSet_Elements();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.EOperation <em>EOperation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.EOperation
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEOperation()
		 * @generated
		 */
		EEnum EOPERATION = eINSTANCE.getEOperation();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.BindingType <em>Binding Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.BindingType
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingType()
		 * @generated
		 */
		EEnum BINDING_TYPE = eINSTANCE.getBindingType();

	}

} // EMV2InstancePackage
