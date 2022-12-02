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
	 * The feature id for the '<em><b>Propagations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__PROPAGATIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Error Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__ERROR_FLOWS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Propagation Paths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__STATES = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__INITIAL_STATE = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__EVENTS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__TRANSITIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__CONDITIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Detections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__DETECTIONS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Mode Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__MODE_MAPPINGS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Composites</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__COMPOSITES = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Propagation Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>EMV2 Annex Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMV2_ANNEX_INSTANCE_FEATURE_COUNT = InstancePackage.ANNEX_INSTANCE_FEATURE_COUNT + 12;

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
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl <em>State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.StateInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateInstance()
	 * @generated
	 */
	int STATE_INSTANCE = 24;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl <em>Composite State Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCompositeStateInstance()
	 * @generated
	 */
	int COMPOSITE_STATE_INSTANCE = 56;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.ErrorFlowInstance <em>Error Flow Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.ErrorFlowInstance
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorFlowInstance()
	 * @generated
	 */
	int ERROR_FLOW_INSTANCE = 15;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorSourceInstanceImpl <em>Error Source Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorSourceInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorSourceInstance()
	 * @generated
	 */
	int ERROR_SOURCE_INSTANCE = 16;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.PropagationPointInstanceImpl <em>Propagation Point Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.PropagationPointInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getPropagationPointInstance()
	 * @generated
	 */
	int PROPAGATION_POINT_INSTANCE = 19;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.EventInstance <em>Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.EventInstance
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEventInstance()
	 * @generated
	 */
	int EVENT_INSTANCE = 25;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorEventInstanceImpl <em>Error Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorEventInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorEventInstance()
	 * @generated
	 */
	int ERROR_EVENT_INSTANCE = 26;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.RecoverEventInstanceImpl <em>Recover Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.RecoverEventInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getRecoverEventInstance()
	 * @generated
	 */
	int RECOVER_EVENT_INSTANCE = 27;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.RepairEventInstanceImpl <em>Repair Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.RepairEventInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getRepairEventInstance()
	 * @generated
	 */
	int REPAIR_EVENT_INSTANCE = 28;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl <em>Error Propagation Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ErrorPropagationInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorPropagationInstance()
	 * @generated
	 */
	int ERROR_PROPAGATION_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Error Sinks</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__ERROR_SINKS = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Source Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Destination Error Paths</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Error Propagation Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_PROPAGATION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConnectionEndPropagationImpl <em>Connection End Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConnectionEndPropagationImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConnectionEndPropagation()
	 * @generated
	 */
	int CONNECTION_END_PROPAGATION = 3;

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
	int FEATURE_PROPAGATION = 4;

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
	int POINT_PROPAGATION = 6;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AccessPropagationImpl <em>Access Propagation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AccessPropagationImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAccessPropagation()
	 * @generated
	 */
	int ACCESS_PROPAGATION = 5;

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
	int BINDING_PROPAGATION = 7;

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
	int TYPE_SET_ELEMENT = 8;

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
	int TYPE_TOKEN_INSTANCE = 9;

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
	int TYPE_INSTANCE = 10;

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
	int TYPE_SET_INSTANCE = 13;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AnonymousTypeSetImpl <em>Anonymous Type Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AnonymousTypeSetImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAnonymousTypeSet()
	 * @generated
	 */
	int ANONYMOUS_TYPE_SET = 14;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.TypeProductInstanceImpl <em>Type Product Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.TypeProductInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTypeProductInstance()
	 * @generated
	 */
	int TYPE_PRODUCT_INSTANCE = 11;

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
	int ABSTRACT_TYPE_SET = 12;

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
	int ERROR_SINK_INSTANCE = 17;

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
	int ERROR_PATH_INSTANCE = 18;

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
	int PROPAGATION_PATH_INSTANCE = 20;

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
	int CONNECTION_PATH = 21;

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
	int BINDING_PATH = 22;

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
	int USER_DEFINED_PATH = 23;

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
	 * The number of structural features of the '<em>Event Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__OWNED_ELEMENT = EVENT_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__OWNED_COMMENT = EVENT_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__NAME = EVENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__QUALIFIED_NAME = EVENT_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EVENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__ANNEX_INSTANCE = EVENT_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Error Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__ERROR_EVENT = EVENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE__TYPE_SET = EVENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Error Event Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_EVENT_INSTANCE_FEATURE_COUNT = EVENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__OWNED_ELEMENT = EVENT_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__OWNED_COMMENT = EVENT_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__NAME = EVENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__QUALIFIED_NAME = EVENT_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EVENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__ANNEX_INSTANCE = EVENT_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Recover Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__RECOVER_EVENT = EVENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Initiators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE__EVENT_INITIATORS = EVENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Recover Event Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOVER_EVENT_INSTANCE_FEATURE_COUNT = EVENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__OWNED_ELEMENT = EVENT_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__OWNED_COMMENT = EVENT_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__NAME = EVENT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__QUALIFIED_NAME = EVENT_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EVENT_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__ANNEX_INSTANCE = EVENT_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Repair Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__REPAIR_EVENT = EVENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Initiators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE__EVENT_INITIATORS = EVENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Repair Event Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPAIR_EVENT_INSTANCE_FEATURE_COUNT = EVENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.TransitionInstanceImpl <em>Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.TransitionInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTransitionInstance()
	 * @generated
	 */
	int TRANSITION_INSTANCE = 29;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__TRANSITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__DESTINATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.StateSource <em>State Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.StateSource
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateSource()
	 * @generated
	 */
	int STATE_SOURCE = 30;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SOURCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SOURCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SOURCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SOURCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SOURCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SOURCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>State Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_SOURCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.SourceStateReferenceImpl <em>Source State Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.SourceStateReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getSourceStateReference()
	 * @generated
	 */
	int SOURCE_STATE_REFERENCE = 31;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__OWNED_ELEMENT = STATE_SOURCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__OWNED_COMMENT = STATE_SOURCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__NAME = STATE_SOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__QUALIFIED_NAME = STATE_SOURCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__OWNED_PROPERTY_ASSOCIATION = STATE_SOURCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__ANNEX_INSTANCE = STATE_SOURCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__STATE = STATE_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE__TYPE_SET = STATE_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Source State Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_STATE_REFERENCE_FEATURE_COUNT = STATE_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AllSourcesImpl <em>All Sources</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AllSourcesImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAllSources()
	 * @generated
	 */
	int ALL_SOURCES = 32;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_SOURCES__OWNED_ELEMENT = STATE_SOURCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_SOURCES__OWNED_COMMENT = STATE_SOURCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_SOURCES__NAME = STATE_SOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_SOURCES__QUALIFIED_NAME = STATE_SOURCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_SOURCES__OWNED_PROPERTY_ASSOCIATION = STATE_SOURCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_SOURCES__ANNEX_INSTANCE = STATE_SOURCE__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>All Sources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_SOURCES_FEATURE_COUNT = STATE_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.CompositeConditionExpression <em>Composite Condition Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.CompositeConditionExpression
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCompositeConditionExpression()
	 * @generated
	 */
	int COMPOSITE_CONDITION_EXPRESSION = 57;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_EXPRESSION__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_EXPRESSION__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_EXPRESSION__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_EXPRESSION__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_EXPRESSION__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_EXPRESSION__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Composite Condition Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CONDITION_EXPRESSION_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.ConditionExpressionInstance <em>Condition Expression Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.ConditionExpressionInstance
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConditionExpressionInstance()
	 * @generated
	 */
	int CONDITION_EXPRESSION_INSTANCE = 33;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_INSTANCE__OWNED_ELEMENT = COMPOSITE_CONDITION_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_INSTANCE__OWNED_COMMENT = COMPOSITE_CONDITION_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_INSTANCE__NAME = COMPOSITE_CONDITION_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_INSTANCE__QUALIFIED_NAME = COMPOSITE_CONDITION_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = COMPOSITE_CONDITION_EXPRESSION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_INSTANCE__ANNEX_INSTANCE = COMPOSITE_CONDITION_EXPRESSION__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Condition Expression Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT = COMPOSITE_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.EventReferenceImpl <em>Event Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.EventReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEventReference()
	 * @generated
	 */
	int EVENT_REFERENCE = 34;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__OWNED_ELEMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__OWNED_COMMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__NAME = CONDITION_EXPRESSION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__QUALIFIED_NAME = CONDITION_EXPRESSION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__OWNED_PROPERTY_ASSOCIATION = CONDITION_EXPRESSION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__ANNEX_INSTANCE = CONDITION_EXPRESSION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__EVENT = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__TYPE_SET = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE_FEATURE_COUNT = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConditionPropagationReferenceImpl <em>Condition Propagation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConditionPropagationReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConditionPropagationReference()
	 * @generated
	 */
	int CONDITION_PROPAGATION_REFERENCE = 35;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__OWNED_ELEMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__OWNED_COMMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__NAME = CONDITION_EXPRESSION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__QUALIFIED_NAME = CONDITION_EXPRESSION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__OWNED_PROPERTY_ASSOCIATION = CONDITION_EXPRESSION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__ANNEX_INSTANCE = CONDITION_EXPRESSION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__PROPAGATION = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE__TYPE_SET = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Condition Propagation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_PROPAGATION_REFERENCE_FEATURE_COUNT = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.NoErrorPropagationReferenceImpl <em>No Error Propagation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.NoErrorPropagationReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getNoErrorPropagationReference()
	 * @generated
	 */
	int NO_ERROR_PROPAGATION_REFERENCE = 36;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE__OWNED_ELEMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE__OWNED_COMMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE__NAME = CONDITION_EXPRESSION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE__QUALIFIED_NAME = CONDITION_EXPRESSION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE__OWNED_PROPERTY_ASSOCIATION = CONDITION_EXPRESSION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE__ANNEX_INSTANCE = CONDITION_EXPRESSION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE__PROPAGATION = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>No Error Propagation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_ERROR_PROPAGATION_REFERENCE_FEATURE_COUNT = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.CountExpressionImpl <em>Count Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.CountExpressionImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCountExpression()
	 * @generated
	 */
	int COUNT_EXPRESSION = 37;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__OWNED_ELEMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__OWNED_COMMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__NAME = CONDITION_EXPRESSION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__QUALIFIED_NAME = CONDITION_EXPRESSION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__OWNED_PROPERTY_ASSOCIATION = CONDITION_EXPRESSION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__ANNEX_INSTANCE = CONDITION_EXPRESSION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__OPERANDS = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__OPERATION = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION__COUNT = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Count Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_EXPRESSION_FEATURE_COUNT = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.TransitionDestination <em>Transition Destination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.TransitionDestination
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTransitionDestination()
	 * @generated
	 */
	int TRANSITION_DESTINATION = 38;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_DESTINATION__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_DESTINATION__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_DESTINATION__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_DESTINATION__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_DESTINATION__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Transition Destination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_DESTINATION_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.DestinationStateReferenceImpl <em>Destination State Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.DestinationStateReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getDestinationStateReference()
	 * @generated
	 */
	int DESTINATION_STATE_REFERENCE = 39;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__OWNED_ELEMENT = TRANSITION_DESTINATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__OWNED_COMMENT = TRANSITION_DESTINATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__NAME = TRANSITION_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__QUALIFIED_NAME = TRANSITION_DESTINATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__OWNED_PROPERTY_ASSOCIATION = TRANSITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__ANNEX_INSTANCE = TRANSITION_DESTINATION__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__STATE = TRANSITION_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE__TYPE_SET = TRANSITION_DESTINATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Destination State Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_STATE_REFERENCE_FEATURE_COUNT = TRANSITION_DESTINATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.SameStateImpl <em>Same State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.SameStateImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getSameState()
	 * @generated
	 */
	int SAME_STATE = 40;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_STATE__OWNED_ELEMENT = TRANSITION_DESTINATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_STATE__OWNED_COMMENT = TRANSITION_DESTINATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_STATE__NAME = TRANSITION_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_STATE__QUALIFIED_NAME = TRANSITION_DESTINATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_STATE__OWNED_PROPERTY_ASSOCIATION = TRANSITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_STATE__ANNEX_INSTANCE = TRANSITION_DESTINATION__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Same State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAME_STATE_FEATURE_COUNT = TRANSITION_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchesImpl <em>Branches</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.BranchesImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranches()
	 * @generated
	 */
	int BRANCHES = 41;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES__OWNED_ELEMENT = TRANSITION_DESTINATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES__OWNED_COMMENT = TRANSITION_DESTINATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES__NAME = TRANSITION_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES__QUALIFIED_NAME = TRANSITION_DESTINATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES__OWNED_PROPERTY_ASSOCIATION = TRANSITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES__ANNEX_INSTANCE = TRANSITION_DESTINATION__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Branches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES__BRANCHES = TRANSITION_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Branches</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCHES_FEATURE_COUNT = TRANSITION_DESTINATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.BranchImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranch()
	 * @generated
	 */
	int BRANCH = 42;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH__PROBABILITY = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchStateReferenceImpl <em>Branch State Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.BranchStateReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranchStateReference()
	 * @generated
	 */
	int BRANCH_STATE_REFERENCE = 43;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__OWNED_ELEMENT = BRANCH__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__OWNED_COMMENT = BRANCH__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__NAME = BRANCH__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__QUALIFIED_NAME = BRANCH__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__OWNED_PROPERTY_ASSOCIATION = BRANCH__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__ANNEX_INSTANCE = BRANCH__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__PROBABILITY = BRANCH__PROBABILITY;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__STATE = BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE__TYPE_SET = BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Branch State Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_STATE_REFERENCE_FEATURE_COUNT = BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchSameStateImpl <em>Branch Same State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.BranchSameStateImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranchSameState()
	 * @generated
	 */
	int BRANCH_SAME_STATE = 44;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE__OWNED_ELEMENT = BRANCH__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE__OWNED_COMMENT = BRANCH__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE__NAME = BRANCH__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE__QUALIFIED_NAME = BRANCH__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE__OWNED_PROPERTY_ASSOCIATION = BRANCH__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE__ANNEX_INSTANCE = BRANCH__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE__PROBABILITY = BRANCH__PROBABILITY;

	/**
	 * The number of structural features of the '<em>Branch Same State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_SAME_STATE_FEATURE_COUNT = BRANCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl <em>Outgoing Propagation Condition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOutgoingPropagationConditionInstance()
	 * @generated
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE = 45;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Outgoing Propagation Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT
			+ 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Outgoing Propagation Condition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination <em>Outgoing Propagation Condition Destination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOutgoingPropagationConditionDestination()
	 * @generated
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION = 46;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Outgoing Propagation Condition Destination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTGOING_PROPAGATION_CONDITION_DESTINATION_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.DestinationPropagationReferenceImpl <em>Destination Propagation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.DestinationPropagationReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getDestinationPropagationReference()
	 * @generated
	 */
	int DESTINATION_PROPAGATION_REFERENCE = 47;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__OWNED_ELEMENT = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__OWNED_COMMENT = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__NAME = OUTGOING_PROPAGATION_CONDITION_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__QUALIFIED_NAME = OUTGOING_PROPAGATION_CONDITION_DESTINATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__OWNED_PROPERTY_ASSOCIATION = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__ANNEX_INSTANCE = OUTGOING_PROPAGATION_CONDITION_DESTINATION__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__PROPAGATION = OUTGOING_PROPAGATION_CONDITION_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE__TYPE_SET = OUTGOING_PROPAGATION_CONDITION_DESTINATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Destination Propagation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESTINATION_PROPAGATION_REFERENCE_FEATURE_COUNT = OUTGOING_PROPAGATION_CONDITION_DESTINATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AllPropagationsImpl <em>All Propagations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AllPropagationsImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAllPropagations()
	 * @generated
	 */
	int ALL_PROPAGATIONS = 48;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS__OWNED_ELEMENT = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS__OWNED_COMMENT = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS__NAME = OUTGOING_PROPAGATION_CONDITION_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS__QUALIFIED_NAME = OUTGOING_PROPAGATION_CONDITION_DESTINATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS__OWNED_PROPERTY_ASSOCIATION = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS__ANNEX_INSTANCE = OUTGOING_PROPAGATION_CONDITION_DESTINATION__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS__TYPE_SET = OUTGOING_PROPAGATION_CONDITION_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>All Propagations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_FEATURE_COUNT = OUTGOING_PROPAGATION_CONDITION_DESTINATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.AllPropagationsNoErrorImpl <em>All Propagations No Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.AllPropagationsNoErrorImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAllPropagationsNoError()
	 * @generated
	 */
	int ALL_PROPAGATIONS_NO_ERROR = 49;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_NO_ERROR__OWNED_ELEMENT = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_NO_ERROR__OWNED_COMMENT = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_NO_ERROR__NAME = OUTGOING_PROPAGATION_CONDITION_DESTINATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_NO_ERROR__QUALIFIED_NAME = OUTGOING_PROPAGATION_CONDITION_DESTINATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_NO_ERROR__OWNED_PROPERTY_ASSOCIATION = OUTGOING_PROPAGATION_CONDITION_DESTINATION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_NO_ERROR__ANNEX_INSTANCE = OUTGOING_PROPAGATION_CONDITION_DESTINATION__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>All Propagations No Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_PROPAGATIONS_NO_ERROR_FEATURE_COUNT = OUTGOING_PROPAGATION_CONDITION_DESTINATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.DetectionInstanceImpl <em>Detection Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.DetectionInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getDetectionInstance()
	 * @generated
	 */
	int DETECTION_INSTANCE = 50;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Detection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__DETECTION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__SOURCE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__DESTINATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE__ERROR_CODE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Detection Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETECTION_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.ErrorCodeInstance <em>Error Code Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.ErrorCodeInstance
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorCodeInstance()
	 * @generated
	 */
	int ERROR_CODE_INSTANCE = 51;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CODE_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CODE_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CODE_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CODE_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CODE_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CODE_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Error Code Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_CODE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.IntegerCodeImpl <em>Integer Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.IntegerCodeImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getIntegerCode()
	 * @generated
	 */
	int INTEGER_CODE = 52;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE__OWNED_ELEMENT = ERROR_CODE_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE__OWNED_COMMENT = ERROR_CODE_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE__NAME = ERROR_CODE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE__QUALIFIED_NAME = ERROR_CODE_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE__OWNED_PROPERTY_ASSOCIATION = ERROR_CODE_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE__ANNEX_INSTANCE = ERROR_CODE_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE__CODE = ERROR_CODE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_CODE_FEATURE_COUNT = ERROR_CODE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.StringCodeImpl <em>String Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.StringCodeImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStringCode()
	 * @generated
	 */
	int STRING_CODE = 53;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE__OWNED_ELEMENT = ERROR_CODE_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE__OWNED_COMMENT = ERROR_CODE_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE__NAME = ERROR_CODE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE__QUALIFIED_NAME = ERROR_CODE_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE__OWNED_PROPERTY_ASSOCIATION = ERROR_CODE_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE__ANNEX_INSTANCE = ERROR_CODE_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE__CODE = ERROR_CODE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_CODE_FEATURE_COUNT = ERROR_CODE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstantCodeImpl <em>Constant Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ConstantCodeImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstantCode()
	 * @generated
	 */
	int CONSTANT_CODE = 54;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE__OWNED_ELEMENT = ERROR_CODE_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE__OWNED_COMMENT = ERROR_CODE_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE__NAME = ERROR_CODE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE__QUALIFIED_NAME = ERROR_CODE_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE__OWNED_PROPERTY_ASSOCIATION = ERROR_CODE_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE__ANNEX_INSTANCE = ERROR_CODE_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Code</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE__CODE = ERROR_CODE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_CODE_FEATURE_COUNT = ERROR_CODE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.ModeMappingInstanceImpl <em>Mode Mapping Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.ModeMappingInstanceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getModeMappingInstance()
	 * @generated
	 */
	int MODE_MAPPING_INSTANCE = 55;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__OWNED_ELEMENT = EMV2_INSTANCE_OBJECT__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__OWNED_COMMENT = EMV2_INSTANCE_OBJECT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__NAME = EMV2_INSTANCE_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__QUALIFIED_NAME = EMV2_INSTANCE_OBJECT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__OWNED_PROPERTY_ASSOCIATION = EMV2_INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__ANNEX_INSTANCE = EMV2_INSTANCE_OBJECT__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>Mode Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__MODE_MAPPING = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__STATE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__TYPE_SET = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Modes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE__MODES = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mode Mapping Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_MAPPING_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Composite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__COMPOSITE = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__CONDITION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__DESTINATION = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Destination Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Composite State Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_INSTANCE_FEATURE_COUNT = EMV2_INSTANCE_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.OthersExpressionImpl <em>Others Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.OthersExpressionImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOthersExpression()
	 * @generated
	 */
	int OTHERS_EXPRESSION = 58;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERS_EXPRESSION__OWNED_ELEMENT = COMPOSITE_CONDITION_EXPRESSION__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERS_EXPRESSION__OWNED_COMMENT = COMPOSITE_CONDITION_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERS_EXPRESSION__NAME = COMPOSITE_CONDITION_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERS_EXPRESSION__QUALIFIED_NAME = COMPOSITE_CONDITION_EXPRESSION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERS_EXPRESSION__OWNED_PROPERTY_ASSOCIATION = COMPOSITE_CONDITION_EXPRESSION__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERS_EXPRESSION__ANNEX_INSTANCE = COMPOSITE_CONDITION_EXPRESSION__ANNEX_INSTANCE;

	/**
	 * The number of structural features of the '<em>Others Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHERS_EXPRESSION_FEATURE_COUNT = COMPOSITE_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.impl.StateReferenceImpl <em>State Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.impl.StateReferenceImpl
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateReference()
	 * @generated
	 */
	int STATE_REFERENCE = 59;

	/**
	 * The feature id for the '<em><b>Owned Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__OWNED_ELEMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__OWNED_COMMENT = CONDITION_EXPRESSION_INSTANCE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__NAME = CONDITION_EXPRESSION_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__QUALIFIED_NAME = CONDITION_EXPRESSION_INSTANCE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__OWNED_PROPERTY_ASSOCIATION = CONDITION_EXPRESSION_INSTANCE__OWNED_PROPERTY_ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Annex Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__ANNEX_INSTANCE = CONDITION_EXPRESSION_INSTANCE__ANNEX_INSTANCE;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__STATE = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE__TYPE_SET = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_REFERENCE_FEATURE_COUNT = CONDITION_EXPRESSION_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.BindingType <em>Binding Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.BindingType
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingType()
	 * @generated
	 */
	int BINDING_TYPE = 60;

	/**
	 * The meta object id for the '{@link org.osate.aadl2.errormodel.instance.CountExpressionOperation <em>Count Expression Operation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.aadl2.errormodel.instance.CountExpressionOperation
	 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCountExpressionOperation()
	 * @generated
	 */
	int COUNT_EXPRESSION_OPERATION = 61;

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
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getConditions()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Conditions();

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
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getDetections <em>Detections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Detections</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getDetections()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_Detections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getModeMappings <em>Mode Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mode Mappings</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance#getModeMappings()
	 * @see #getEMV2AnnexInstance()
	 * @generated
	 */
	EReference getEMV2AnnexInstance_ModeMappings();

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
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance <em>Composite State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite State Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance
	 * @generated
	 */
	EClass getCompositeStateInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance#getComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance#getComposite()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_Composite();

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
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance#getDestination()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance#getDestinationTypeSet <em>Destination Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance#getDestinationTypeSet()
	 * @see #getCompositeStateInstance()
	 * @generated
	 */
	EReference getCompositeStateInstance_DestinationTypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.CompositeConditionExpression <em>Composite Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Condition Expression</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CompositeConditionExpression
	 * @generated
	 */
	EClass getCompositeConditionExpression();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.OthersExpression <em>Others Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Others Expression</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OthersExpression
	 * @generated
	 */
	EClass getOthersExpression();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.StateReference <em>State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateReference
	 * @generated
	 */
	EClass getStateReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.StateReference#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateReference#getState()
	 * @see #getStateReference()
	 * @generated
	 */
	EReference getStateReference_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.StateReference#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateReference#getTypeSet()
	 * @see #getStateReference()
	 * @generated
	 */
	EReference getStateReference_TypeSet();

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
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorEventInstance <em>Error Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Event Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorEventInstance
	 * @generated
	 */
	EClass getErrorEventInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ErrorEventInstance#getErrorEvent <em>Error Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Event</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorEventInstance#getErrorEvent()
	 * @see #getErrorEventInstance()
	 * @generated
	 */
	EReference getErrorEventInstance_ErrorEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ErrorEventInstance#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorEventInstance#getTypeSet()
	 * @see #getErrorEventInstance()
	 * @generated
	 */
	EReference getErrorEventInstance_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.RecoverEventInstance <em>Recover Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recover Event Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.RecoverEventInstance
	 * @generated
	 */
	EClass getRecoverEventInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.RecoverEventInstance#getRecoverEvent <em>Recover Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recover Event</em>'.
	 * @see org.osate.aadl2.errormodel.instance.RecoverEventInstance#getRecoverEvent()
	 * @see #getRecoverEventInstance()
	 * @generated
	 */
	EReference getRecoverEventInstance_RecoverEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.RecoverEventInstance#getEventInitiators <em>Event Initiators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Initiators</em>'.
	 * @see org.osate.aadl2.errormodel.instance.RecoverEventInstance#getEventInitiators()
	 * @see #getRecoverEventInstance()
	 * @generated
	 */
	EReference getRecoverEventInstance_EventInitiators();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.RepairEventInstance <em>Repair Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repair Event Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.RepairEventInstance
	 * @generated
	 */
	EClass getRepairEventInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.RepairEventInstance#getRepairEvent <em>Repair Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Repair Event</em>'.
	 * @see org.osate.aadl2.errormodel.instance.RepairEventInstance#getRepairEvent()
	 * @see #getRepairEventInstance()
	 * @generated
	 */
	EReference getRepairEventInstance_RepairEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.RepairEventInstance#getEventInitiators <em>Event Initiators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event Initiators</em>'.
	 * @see org.osate.aadl2.errormodel.instance.RepairEventInstance#getEventInitiators()
	 * @see #getRepairEventInstance()
	 * @generated
	 */
	EReference getRepairEventInstance_EventInitiators();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.TransitionInstance <em>Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TransitionInstance
	 * @generated
	 */
	EClass getTransitionInstance();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.TransitionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TransitionInstance#getCondition()
	 * @see #getTransitionInstance()
	 * @generated
	 */
	EReference getTransitionInstance_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.TransitionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TransitionInstance#getDestination()
	 * @see #getTransitionInstance()
	 * @generated
	 */
	EReference getTransitionInstance_Destination();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.StateSource <em>State Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Source</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StateSource
	 * @generated
	 */
	EClass getStateSource();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.TransitionInstance#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TransitionInstance#getTransition()
	 * @see #getTransitionInstance()
	 * @generated
	 */
	EReference getTransitionInstance_Transition();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.TransitionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TransitionInstance#getSource()
	 * @see #getTransitionInstance()
	 * @generated
	 */
	EReference getTransitionInstance_Source();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.SourceStateReference <em>Source State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source State Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.SourceStateReference
	 * @generated
	 */
	EClass getSourceStateReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.SourceStateReference#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.SourceStateReference#getState()
	 * @see #getSourceStateReference()
	 * @generated
	 */
	EReference getSourceStateReference_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.SourceStateReference#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.SourceStateReference#getTypeSet()
	 * @see #getSourceStateReference()
	 * @generated
	 */
	EReference getSourceStateReference_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.AllSources <em>All Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Sources</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AllSources
	 * @generated
	 */
	EClass getAllSources();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConditionExpressionInstance <em>Condition Expression Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Expression Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConditionExpressionInstance
	 * @generated
	 */
	EClass getConditionExpressionInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.EventReference <em>Event Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EventReference
	 * @generated
	 */
	EClass getEventReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.EventReference#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EventReference#getEvent()
	 * @see #getEventReference()
	 * @generated
	 */
	EReference getEventReference_Event();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.EventReference#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.EventReference#getTypeSet()
	 * @see #getEventReference()
	 * @generated
	 */
	EReference getEventReference_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConditionPropagationReference <em>Condition Propagation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Propagation Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConditionPropagationReference
	 * @generated
	 */
	EClass getConditionPropagationReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ConditionPropagationReference#getPropagation <em>Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConditionPropagationReference#getPropagation()
	 * @see #getConditionPropagationReference()
	 * @generated
	 */
	EReference getConditionPropagationReference_Propagation();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ConditionPropagationReference#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConditionPropagationReference#getTypeSet()
	 * @see #getConditionPropagationReference()
	 * @generated
	 */
	EReference getConditionPropagationReference_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.NoErrorPropagationReference <em>No Error Propagation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No Error Propagation Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.NoErrorPropagationReference
	 * @generated
	 */
	EClass getNoErrorPropagationReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.NoErrorPropagationReference#getPropagation <em>Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.NoErrorPropagationReference#getPropagation()
	 * @see #getNoErrorPropagationReference()
	 * @generated
	 */
	EReference getNoErrorPropagationReference_Propagation();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.CountExpression <em>Count Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Count Expression</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CountExpression
	 * @generated
	 */
	EClass getCountExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.CountExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CountExpression#getOperands()
	 * @see #getCountExpression()
	 * @generated
	 */
	EReference getCountExpression_Operands();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.CountExpression#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CountExpression#getOperation()
	 * @see #getCountExpression()
	 * @generated
	 */
	EAttribute getCountExpression_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.CountExpression#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CountExpression#getCount()
	 * @see #getCountExpression()
	 * @generated
	 */
	EAttribute getCountExpression_Count();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.TransitionDestination <em>Transition Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Destination</em>'.
	 * @see org.osate.aadl2.errormodel.instance.TransitionDestination
	 * @generated
	 */
	EClass getTransitionDestination();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.DestinationStateReference <em>Destination State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Destination State Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DestinationStateReference
	 * @generated
	 */
	EClass getDestinationStateReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.DestinationStateReference#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DestinationStateReference#getState()
	 * @see #getDestinationStateReference()
	 * @generated
	 */
	EReference getDestinationStateReference_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.DestinationStateReference#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DestinationStateReference#getTypeSet()
	 * @see #getDestinationStateReference()
	 * @generated
	 */
	EReference getDestinationStateReference_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.SameState <em>Same State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Same State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.SameState
	 * @generated
	 */
	EClass getSameState();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.Branches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branches</em>'.
	 * @see org.osate.aadl2.errormodel.instance.Branches
	 * @generated
	 */
	EClass getBranches();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.aadl2.errormodel.instance.Branches#getBranches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branches</em>'.
	 * @see org.osate.aadl2.errormodel.instance.Branches#getBranches()
	 * @see #getBranches()
	 * @generated
	 */
	EReference getBranches_Branches();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see org.osate.aadl2.errormodel.instance.Branch
	 * @generated
	 */
	EClass getBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.Branch#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see org.osate.aadl2.errormodel.instance.Branch#getProbability()
	 * @see #getBranch()
	 * @generated
	 */
	EAttribute getBranch_Probability();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.BranchStateReference <em>Branch State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch State Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BranchStateReference
	 * @generated
	 */
	EClass getBranchStateReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.BranchStateReference#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BranchStateReference#getState()
	 * @see #getBranchStateReference()
	 * @generated
	 */
	EReference getBranchStateReference_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.BranchStateReference#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BranchStateReference#getTypeSet()
	 * @see #getBranchStateReference()
	 * @generated
	 */
	EReference getBranchStateReference_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.BranchSameState <em>Branch Same State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Same State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BranchSameState
	 * @generated
	 */
	EClass getBranchSameState();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance <em>Outgoing Propagation Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outgoing Propagation Condition Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance
	 * @generated
	 */
	EClass getOutgoingPropagationConditionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getOutgoingPropagationCondition <em>Outgoing Propagation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing Propagation Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getOutgoingPropagationCondition()
	 * @see #getOutgoingPropagationConditionInstance()
	 * @generated
	 */
	EReference getOutgoingPropagationConditionInstance_OutgoingPropagationCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getSource()
	 * @see #getOutgoingPropagationConditionInstance()
	 * @generated
	 */
	EReference getOutgoingPropagationConditionInstance_Source();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getCondition()
	 * @see #getOutgoingPropagationConditionInstance()
	 * @generated
	 */
	EReference getOutgoingPropagationConditionInstance_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getDestination()
	 * @see #getOutgoingPropagationConditionInstance()
	 * @generated
	 */
	EReference getOutgoingPropagationConditionInstance_Destination();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination <em>Outgoing Propagation Condition Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outgoing Propagation Condition Destination</em>'.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination
	 * @generated
	 */
	EClass getOutgoingPropagationConditionDestination();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.DestinationPropagationReference <em>Destination Propagation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Destination Propagation Reference</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DestinationPropagationReference
	 * @generated
	 */
	EClass getDestinationPropagationReference();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.DestinationPropagationReference#getPropagation <em>Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Propagation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DestinationPropagationReference#getPropagation()
	 * @see #getDestinationPropagationReference()
	 * @generated
	 */
	EReference getDestinationPropagationReference_Propagation();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.DestinationPropagationReference#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DestinationPropagationReference#getTypeSet()
	 * @see #getDestinationPropagationReference()
	 * @generated
	 */
	EReference getDestinationPropagationReference_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.AllPropagations <em>All Propagations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Propagations</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AllPropagations
	 * @generated
	 */
	EClass getAllPropagations();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.AllPropagations#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AllPropagations#getTypeSet()
	 * @see #getAllPropagations()
	 * @generated
	 */
	EReference getAllPropagations_TypeSet();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.AllPropagationsNoError <em>All Propagations No Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Propagations No Error</em>'.
	 * @see org.osate.aadl2.errormodel.instance.AllPropagationsNoError
	 * @generated
	 */
	EClass getAllPropagationsNoError();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.DetectionInstance <em>Detection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detection Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DetectionInstance
	 * @generated
	 */
	EClass getDetectionInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getDetection <em>Detection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Detection</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DetectionInstance#getDetection()
	 * @see #getDetectionInstance()
	 * @generated
	 */
	EReference getDetectionInstance_Detection();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DetectionInstance#getSource()
	 * @see #getDetectionInstance()
	 * @generated
	 */
	EReference getDetectionInstance_Source();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DetectionInstance#getCondition()
	 * @see #getDetectionInstance()
	 * @generated
	 */
	EReference getDetectionInstance_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Destination</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DetectionInstance#getDestination()
	 * @see #getDetectionInstance()
	 * @generated
	 */
	EReference getDetectionInstance_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.DetectionInstance#getErrorCode <em>Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Error Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.DetectionInstance#getErrorCode()
	 * @see #getDetectionInstance()
	 * @generated
	 */
	EReference getDetectionInstance_ErrorCode();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ErrorCodeInstance <em>Error Code Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Code Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ErrorCodeInstance
	 * @generated
	 */
	EClass getErrorCodeInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.IntegerCode <em>Integer Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.IntegerCode
	 * @generated
	 */
	EClass getIntegerCode();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.IntegerCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.IntegerCode#getCode()
	 * @see #getIntegerCode()
	 * @generated
	 */
	EAttribute getIntegerCode_Code();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.StringCode <em>String Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StringCode
	 * @generated
	 */
	EClass getStringCode();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.aadl2.errormodel.instance.StringCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.StringCode#getCode()
	 * @see #getStringCode()
	 * @generated
	 */
	EAttribute getStringCode_Code();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ConstantCode <em>Constant Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstantCode
	 * @generated
	 */
	EClass getConstantCode();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ConstantCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Code</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ConstantCode#getCode()
	 * @see #getConstantCode()
	 * @generated
	 */
	EReference getConstantCode_Code();

	/**
	 * Returns the meta object for class '{@link org.osate.aadl2.errormodel.instance.ModeMappingInstance <em>Mode Mapping Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode Mapping Instance</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ModeMappingInstance
	 * @generated
	 */
	EClass getModeMappingInstance();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ModeMappingInstance#getModeMapping <em>Mode Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mode Mapping</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ModeMappingInstance#getModeMapping()
	 * @see #getModeMappingInstance()
	 * @generated
	 */
	EReference getModeMappingInstance_ModeMapping();

	/**
	 * Returns the meta object for the reference '{@link org.osate.aadl2.errormodel.instance.ModeMappingInstance#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ModeMappingInstance#getState()
	 * @see #getModeMappingInstance()
	 * @generated
	 */
	EReference getModeMappingInstance_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.osate.aadl2.errormodel.instance.ModeMappingInstance#getTypeSet <em>Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Set</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ModeMappingInstance#getTypeSet()
	 * @see #getModeMappingInstance()
	 * @generated
	 */
	EReference getModeMappingInstance_TypeSet();

	/**
	 * Returns the meta object for the reference list '{@link org.osate.aadl2.errormodel.instance.ModeMappingInstance#getModes <em>Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modes</em>'.
	 * @see org.osate.aadl2.errormodel.instance.ModeMappingInstance#getModes()
	 * @see #getModeMappingInstance()
	 * @generated
	 */
	EReference getModeMappingInstance_Modes();

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
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.instance.BindingType <em>Binding Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binding Type</em>'.
	 * @see org.osate.aadl2.errormodel.instance.BindingType
	 * @generated
	 */
	EEnum getBindingType();

	/**
	 * Returns the meta object for enum '{@link org.osate.aadl2.errormodel.instance.CountExpressionOperation <em>Count Expression Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Count Expression Operation</em>'.
	 * @see org.osate.aadl2.errormodel.instance.CountExpressionOperation
	 * @generated
	 */
	EEnum getCountExpressionOperation();

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
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__CONDITIONS = eINSTANCE.getEMV2AnnexInstance_Conditions();

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
		 * The meta object literal for the '<em><b>Detections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__DETECTIONS = eINSTANCE.getEMV2AnnexInstance_Detections();

		/**
		 * The meta object literal for the '<em><b>Mode Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMV2_ANNEX_INSTANCE__MODE_MAPPINGS = eINSTANCE.getEMV2AnnexInstance_ModeMappings();

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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl <em>Composite State Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.CompositeStateInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCompositeStateInstance()
		 * @generated
		 */
		EClass COMPOSITE_STATE_INSTANCE = eINSTANCE.getCompositeStateInstance();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE_INSTANCE__COMPOSITE = eINSTANCE.getCompositeStateInstance_Composite();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE_INSTANCE__CONDITION = eINSTANCE.getCompositeStateInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE_INSTANCE__DESTINATION = eINSTANCE.getCompositeStateInstance_Destination();

		/**
		 * The meta object literal for the '<em><b>Destination Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET = eINSTANCE
				.getCompositeStateInstance_DestinationTypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.CompositeConditionExpression <em>Composite Condition Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.CompositeConditionExpression
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCompositeConditionExpression()
		 * @generated
		 */
		EClass COMPOSITE_CONDITION_EXPRESSION = eINSTANCE.getCompositeConditionExpression();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.OthersExpressionImpl <em>Others Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.OthersExpressionImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOthersExpression()
		 * @generated
		 */
		EClass OTHERS_EXPRESSION = eINSTANCE.getOthersExpression();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.StateReferenceImpl <em>State Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.StateReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateReference()
		 * @generated
		 */
		EClass STATE_REFERENCE = eINSTANCE.getStateReference();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_REFERENCE__STATE = eINSTANCE.getStateReference_State();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_REFERENCE__TYPE_SET = eINSTANCE.getStateReference_TypeSet();

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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.EventInstance <em>Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.EventInstance
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEventInstance()
		 * @generated
		 */
		EClass EVENT_INSTANCE = eINSTANCE.getEventInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ErrorEventInstanceImpl <em>Error Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ErrorEventInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorEventInstance()
		 * @generated
		 */
		EClass ERROR_EVENT_INSTANCE = eINSTANCE.getErrorEventInstance();

		/**
		 * The meta object literal for the '<em><b>Error Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_EVENT_INSTANCE__ERROR_EVENT = eINSTANCE.getErrorEventInstance_ErrorEvent();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_EVENT_INSTANCE__TYPE_SET = eINSTANCE.getErrorEventInstance_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.RecoverEventInstanceImpl <em>Recover Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.RecoverEventInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getRecoverEventInstance()
		 * @generated
		 */
		EClass RECOVER_EVENT_INSTANCE = eINSTANCE.getRecoverEventInstance();

		/**
		 * The meta object literal for the '<em><b>Recover Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOVER_EVENT_INSTANCE__RECOVER_EVENT = eINSTANCE.getRecoverEventInstance_RecoverEvent();

		/**
		 * The meta object literal for the '<em><b>Event Initiators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOVER_EVENT_INSTANCE__EVENT_INITIATORS = eINSTANCE.getRecoverEventInstance_EventInitiators();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.RepairEventInstanceImpl <em>Repair Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.RepairEventInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getRepairEventInstance()
		 * @generated
		 */
		EClass REPAIR_EVENT_INSTANCE = eINSTANCE.getRepairEventInstance();

		/**
		 * The meta object literal for the '<em><b>Repair Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_EVENT_INSTANCE__REPAIR_EVENT = eINSTANCE.getRepairEventInstance_RepairEvent();

		/**
		 * The meta object literal for the '<em><b>Event Initiators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPAIR_EVENT_INSTANCE__EVENT_INITIATORS = eINSTANCE.getRepairEventInstance_EventInitiators();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.TransitionInstanceImpl <em>Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.TransitionInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTransitionInstance()
		 * @generated
		 */
		EClass TRANSITION_INSTANCE = eINSTANCE.getTransitionInstance();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_INSTANCE__CONDITION = eINSTANCE.getTransitionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_INSTANCE__DESTINATION = eINSTANCE.getTransitionInstance_Destination();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.StateSource <em>State Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.StateSource
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStateSource()
		 * @generated
		 */
		EClass STATE_SOURCE = eINSTANCE.getStateSource();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_INSTANCE__TRANSITION = eINSTANCE.getTransitionInstance_Transition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_INSTANCE__SOURCE = eINSTANCE.getTransitionInstance_Source();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.SourceStateReferenceImpl <em>Source State Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.SourceStateReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getSourceStateReference()
		 * @generated
		 */
		EClass SOURCE_STATE_REFERENCE = eINSTANCE.getSourceStateReference();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_STATE_REFERENCE__STATE = eINSTANCE.getSourceStateReference_State();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_STATE_REFERENCE__TYPE_SET = eINSTANCE.getSourceStateReference_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.AllSourcesImpl <em>All Sources</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.AllSourcesImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAllSources()
		 * @generated
		 */
		EClass ALL_SOURCES = eINSTANCE.getAllSources();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.ConditionExpressionInstance <em>Condition Expression Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.ConditionExpressionInstance
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConditionExpressionInstance()
		 * @generated
		 */
		EClass CONDITION_EXPRESSION_INSTANCE = eINSTANCE.getConditionExpressionInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.EventReferenceImpl <em>Event Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.EventReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getEventReference()
		 * @generated
		 */
		EClass EVENT_REFERENCE = eINSTANCE.getEventReference();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_REFERENCE__EVENT = eINSTANCE.getEventReference_Event();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_REFERENCE__TYPE_SET = eINSTANCE.getEventReference_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ConditionPropagationReferenceImpl <em>Condition Propagation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ConditionPropagationReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConditionPropagationReference()
		 * @generated
		 */
		EClass CONDITION_PROPAGATION_REFERENCE = eINSTANCE.getConditionPropagationReference();

		/**
		 * The meta object literal for the '<em><b>Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_PROPAGATION_REFERENCE__PROPAGATION = eINSTANCE
				.getConditionPropagationReference_Propagation();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_PROPAGATION_REFERENCE__TYPE_SET = eINSTANCE.getConditionPropagationReference_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.NoErrorPropagationReferenceImpl <em>No Error Propagation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.NoErrorPropagationReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getNoErrorPropagationReference()
		 * @generated
		 */
		EClass NO_ERROR_PROPAGATION_REFERENCE = eINSTANCE.getNoErrorPropagationReference();

		/**
		 * The meta object literal for the '<em><b>Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NO_ERROR_PROPAGATION_REFERENCE__PROPAGATION = eINSTANCE.getNoErrorPropagationReference_Propagation();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.CountExpressionImpl <em>Count Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.CountExpressionImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCountExpression()
		 * @generated
		 */
		EClass COUNT_EXPRESSION = eINSTANCE.getCountExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNT_EXPRESSION__OPERANDS = eINSTANCE.getCountExpression_Operands();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNT_EXPRESSION__OPERATION = eINSTANCE.getCountExpression_Operation();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNT_EXPRESSION__COUNT = eINSTANCE.getCountExpression_Count();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.TransitionDestination <em>Transition Destination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.TransitionDestination
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getTransitionDestination()
		 * @generated
		 */
		EClass TRANSITION_DESTINATION = eINSTANCE.getTransitionDestination();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.DestinationStateReferenceImpl <em>Destination State Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.DestinationStateReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getDestinationStateReference()
		 * @generated
		 */
		EClass DESTINATION_STATE_REFERENCE = eINSTANCE.getDestinationStateReference();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESTINATION_STATE_REFERENCE__STATE = eINSTANCE.getDestinationStateReference_State();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESTINATION_STATE_REFERENCE__TYPE_SET = eINSTANCE.getDestinationStateReference_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.SameStateImpl <em>Same State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.SameStateImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getSameState()
		 * @generated
		 */
		EClass SAME_STATE = eINSTANCE.getSameState();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchesImpl <em>Branches</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.BranchesImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranches()
		 * @generated
		 */
		EClass BRANCHES = eINSTANCE.getBranches();

		/**
		 * The meta object literal for the '<em><b>Branches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCHES__BRANCHES = eINSTANCE.getBranches_Branches();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.BranchImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranch()
		 * @generated
		 */
		EClass BRANCH = eINSTANCE.getBranch();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BRANCH__PROBABILITY = eINSTANCE.getBranch_Probability();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchStateReferenceImpl <em>Branch State Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.BranchStateReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranchStateReference()
		 * @generated
		 */
		EClass BRANCH_STATE_REFERENCE = eINSTANCE.getBranchStateReference();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_STATE_REFERENCE__STATE = eINSTANCE.getBranchStateReference_State();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_STATE_REFERENCE__TYPE_SET = eINSTANCE.getBranchStateReference_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.BranchSameStateImpl <em>Branch Same State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.BranchSameStateImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBranchSameState()
		 * @generated
		 */
		EClass BRANCH_SAME_STATE = eINSTANCE.getBranchSameState();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl <em>Outgoing Propagation Condition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.OutgoingPropagationConditionInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOutgoingPropagationConditionInstance()
		 * @generated
		 */
		EClass OUTGOING_PROPAGATION_CONDITION_INSTANCE = eINSTANCE.getOutgoingPropagationConditionInstance();

		/**
		 * The meta object literal for the '<em><b>Outgoing Propagation Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION = eINSTANCE
				.getOutgoingPropagationConditionInstance_OutgoingPropagationCondition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE = eINSTANCE
				.getOutgoingPropagationConditionInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION = eINSTANCE
				.getOutgoingPropagationConditionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION = eINSTANCE
				.getOutgoingPropagationConditionInstance_Destination();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination <em>Outgoing Propagation Condition Destination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getOutgoingPropagationConditionDestination()
		 * @generated
		 */
		EClass OUTGOING_PROPAGATION_CONDITION_DESTINATION = eINSTANCE.getOutgoingPropagationConditionDestination();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.DestinationPropagationReferenceImpl <em>Destination Propagation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.DestinationPropagationReferenceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getDestinationPropagationReference()
		 * @generated
		 */
		EClass DESTINATION_PROPAGATION_REFERENCE = eINSTANCE.getDestinationPropagationReference();

		/**
		 * The meta object literal for the '<em><b>Propagation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESTINATION_PROPAGATION_REFERENCE__PROPAGATION = eINSTANCE
				.getDestinationPropagationReference_Propagation();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESTINATION_PROPAGATION_REFERENCE__TYPE_SET = eINSTANCE.getDestinationPropagationReference_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.AllPropagationsImpl <em>All Propagations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.AllPropagationsImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAllPropagations()
		 * @generated
		 */
		EClass ALL_PROPAGATIONS = eINSTANCE.getAllPropagations();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL_PROPAGATIONS__TYPE_SET = eINSTANCE.getAllPropagations_TypeSet();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.AllPropagationsNoErrorImpl <em>All Propagations No Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.AllPropagationsNoErrorImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getAllPropagationsNoError()
		 * @generated
		 */
		EClass ALL_PROPAGATIONS_NO_ERROR = eINSTANCE.getAllPropagationsNoError();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.DetectionInstanceImpl <em>Detection Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.DetectionInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getDetectionInstance()
		 * @generated
		 */
		EClass DETECTION_INSTANCE = eINSTANCE.getDetectionInstance();

		/**
		 * The meta object literal for the '<em><b>Detection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETECTION_INSTANCE__DETECTION = eINSTANCE.getDetectionInstance_Detection();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETECTION_INSTANCE__SOURCE = eINSTANCE.getDetectionInstance_Source();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETECTION_INSTANCE__CONDITION = eINSTANCE.getDetectionInstance_Condition();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETECTION_INSTANCE__DESTINATION = eINSTANCE.getDetectionInstance_Destination();

		/**
		 * The meta object literal for the '<em><b>Error Code</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETECTION_INSTANCE__ERROR_CODE = eINSTANCE.getDetectionInstance_ErrorCode();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.ErrorCodeInstance <em>Error Code Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.ErrorCodeInstance
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getErrorCodeInstance()
		 * @generated
		 */
		EClass ERROR_CODE_INSTANCE = eINSTANCE.getErrorCodeInstance();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.IntegerCodeImpl <em>Integer Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.IntegerCodeImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getIntegerCode()
		 * @generated
		 */
		EClass INTEGER_CODE = eINSTANCE.getIntegerCode();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_CODE__CODE = eINSTANCE.getIntegerCode_Code();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.StringCodeImpl <em>String Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.StringCodeImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getStringCode()
		 * @generated
		 */
		EClass STRING_CODE = eINSTANCE.getStringCode();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_CODE__CODE = eINSTANCE.getStringCode_Code();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ConstantCodeImpl <em>Constant Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ConstantCodeImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getConstantCode()
		 * @generated
		 */
		EClass CONSTANT_CODE = eINSTANCE.getConstantCode();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_CODE__CODE = eINSTANCE.getConstantCode_Code();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.impl.ModeMappingInstanceImpl <em>Mode Mapping Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.impl.ModeMappingInstanceImpl
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getModeMappingInstance()
		 * @generated
		 */
		EClass MODE_MAPPING_INSTANCE = eINSTANCE.getModeMappingInstance();

		/**
		 * The meta object literal for the '<em><b>Mode Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_MAPPING_INSTANCE__MODE_MAPPING = eINSTANCE.getModeMappingInstance_ModeMapping();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_MAPPING_INSTANCE__STATE = eINSTANCE.getModeMappingInstance_State();

		/**
		 * The meta object literal for the '<em><b>Type Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_MAPPING_INSTANCE__TYPE_SET = eINSTANCE.getModeMappingInstance_TypeSet();

		/**
		 * The meta object literal for the '<em><b>Modes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODE_MAPPING_INSTANCE__MODES = eINSTANCE.getModeMappingInstance_Modes();

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
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.BindingType <em>Binding Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.BindingType
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getBindingType()
		 * @generated
		 */
		EEnum BINDING_TYPE = eINSTANCE.getBindingType();

		/**
		 * The meta object literal for the '{@link org.osate.aadl2.errormodel.instance.CountExpressionOperation <em>Count Expression Operation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.aadl2.errormodel.instance.CountExpressionOperation
		 * @see org.osate.aadl2.errormodel.instance.impl.EMV2InstancePackageImpl#getCountExpressionOperation()
		 * @generated
		 */
		EEnum COUNT_EXPRESSION_OPERATION = eINSTANCE.getCountExpressionOperation();

	}

} // EMV2InstancePackage
