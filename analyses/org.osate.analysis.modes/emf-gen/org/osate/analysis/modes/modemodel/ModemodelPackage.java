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
package org.osate.analysis.modes.modemodel;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osate.aadl2.Aadl2Package;
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
 * <!-- begin-model-doc -->
 * The node representing the initial mode on this level.
 * <!-- end-model-doc -->
 * @see org.osate.analysis.modes.modemodel.ModemodelFactory
 * @generated
 */
public class ModemodelPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "modemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://osate.org/modemodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "modemodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ModemodelPackage eINSTANCE = org.osate.analysis.modes.modemodel.ModemodelPackage.init();

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.SOMNode <em>SOM Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.SOMNode
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getSOMNode()
	 * @generated
	 */
	public static final int SOM_NODE = 0;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__OUT_TRANSITIONS = 0;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__IN_TRANSITIONS = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__PARENT = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__CHILDREN = 3;

	/**
	 * The feature id for the '<em><b>Reachable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__REACHABLE = 4;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__MODE = 5;

	/**
	 * The feature id for the '<em><b>Level</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__LEVEL = 6;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__DERIVED = 7;

	/**
	 * The feature id for the '<em><b>Inactive Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__INACTIVE_CONNECTIONS = 8;

	/**
	 * The feature id for the '<em><b>Inactive Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE__INACTIVE_COMPONENTS = 9;

	/**
	 * The number of structural features of the '<em>SOM Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_NODE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.SOMLevel <em>SOM Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.SOMLevel
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getSOMLevel()
	 * @generated
	 */
	public static final int SOM_LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_LEVEL__NODES = 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_LEVEL__COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_LEVEL__TRANSITIONS = 2;

	/**
	 * The feature id for the '<em><b>Initial Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_LEVEL__INITIAL_NODE = 3;

	/**
	 * The number of structural features of the '<em>SOM Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_LEVEL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.InactiveNode <em>Inactive Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.InactiveNode
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getInactiveNode()
	 * @generated
	 */
	public static final int INACTIVE_NODE = 2;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__OUT_TRANSITIONS = SOM_NODE__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__IN_TRANSITIONS = SOM_NODE__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__PARENT = SOM_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__CHILDREN = SOM_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Reachable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__REACHABLE = SOM_NODE__REACHABLE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__MODE = SOM_NODE__MODE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__LEVEL = SOM_NODE__LEVEL;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__DERIVED = SOM_NODE__DERIVED;

	/**
	 * The feature id for the '<em><b>Inactive Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__INACTIVE_CONNECTIONS = SOM_NODE__INACTIVE_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Inactive Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__INACTIVE_COMPONENTS = SOM_NODE__INACTIVE_COMPONENTS;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE__ACTIVE = SOM_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inactive Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_NODE_FEATURE_COUNT = SOM_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.ActiveNode <em>Active Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.ActiveNode
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getActiveNode()
	 * @generated
	 */
	public static final int ACTIVE_NODE = 3;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__OUT_TRANSITIONS = SOM_NODE__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__IN_TRANSITIONS = SOM_NODE__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__PARENT = SOM_NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__CHILDREN = SOM_NODE__CHILDREN;

	/**
	 * The feature id for the '<em><b>Reachable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__REACHABLE = SOM_NODE__REACHABLE;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__MODE = SOM_NODE__MODE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__LEVEL = SOM_NODE__LEVEL;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__DERIVED = SOM_NODE__DERIVED;

	/**
	 * The feature id for the '<em><b>Inactive Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__INACTIVE_CONNECTIONS = SOM_NODE__INACTIVE_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Inactive Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__INACTIVE_COMPONENTS = SOM_NODE__INACTIVE_COMPONENTS;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE__ACTIVE = SOM_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Active Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_NODE_FEATURE_COUNT = SOM_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.Transition <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.Transition
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTransition()
	 * @generated
	 */
	public static final int TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITION__SRC = 0;

	/**
	 * The feature id for the '<em><b>Dst</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITION__DST = 1;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITION__TRIGGER = 2;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITION__CONNECTIONS = 3;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRANSITION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.Trigger <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.Trigger
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTrigger()
	 * @generated
	 */
	public static final int TRIGGER = 5;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER__TRANSITIONS = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER__KEY = 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER__COMPONENT = 2;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.SOMGraph <em>SOM Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.SOMGraph
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getSOMGraph()
	 * @generated
	 */
	public static final int SOM_GRAPH = 6;

	/**
	 * The feature id for the '<em><b>Levels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_GRAPH__LEVELS = 0;

	/**
	 * The feature id for the '<em><b>Triggers</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_GRAPH__TRIGGERS = 1;

	/**
	 * The number of structural features of the '<em>SOM Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SOM_GRAPH_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.FeatureTrigger <em>Feature Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.FeatureTrigger
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getFeatureTrigger()
	 * @generated
	 */
	public static final int FEATURE_TRIGGER = 7;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_TRIGGER__TRANSITIONS = TRIGGER__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_TRIGGER__KEY = TRIGGER__KEY;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_TRIGGER__COMPONENT = TRIGGER__COMPONENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_TRIGGER__FEATURE = TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_TRIGGER_FEATURE_COUNT = TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.InternalTrigger <em>Internal Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.InternalTrigger
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getInternalTrigger()
	 * @generated
	 */
	public static final int INTERNAL_TRIGGER = 8;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_TRIGGER__TRANSITIONS = TRIGGER__TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_TRIGGER__KEY = TRIGGER__KEY;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_TRIGGER__COMPONENT = TRIGGER__COMPONENT;

	/**
	 * The feature id for the '<em><b>Internal Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_TRIGGER__INTERNAL_FEATURE = TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Internal Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_TRIGGER_FEATURE_COUNT = TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.TriggerMap <em>Trigger Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.TriggerMap
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTriggerMap()
	 * @generated
	 */
	public static final int TRIGGER_MAP = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER_MAP__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER_MAP__KEY = 1;

	/**
	 * The number of structural features of the '<em>Trigger Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.TriggerKey <em>Trigger Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.TriggerKey
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTriggerKey()
	 * @generated
	 */
	public static final int TRIGGER_KEY = 10;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER_KEY__TRIGGER = 0;

	/**
	 * The number of structural features of the '<em>Trigger Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRIGGER_KEY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.FeatureKey <em>Feature Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.FeatureKey
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getFeatureKey()
	 * @generated
	 */
	public static final int FEATURE_KEY = 11;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_KEY__TRIGGER = TRIGGER_KEY__TRIGGER;

	/**
	 * The number of structural features of the '<em>Feature Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_KEY_FEATURE_COUNT = TRIGGER_KEY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.modes.modemodel.InternalKey <em>Internal Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.modes.modemodel.InternalKey
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getInternalKey()
	 * @generated
	 */
	public static final int INTERNAL_KEY = 12;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_KEY__TRIGGER = TRIGGER_KEY__TRIGGER;

	/**
	 * The number of structural features of the '<em>Internal Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int INTERNAL_KEY_FEATURE_COUNT = TRIGGER_KEY_FEATURE_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass somNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass somLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inactiveNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activeNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass somGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalKeyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModemodelPackage() {
		super(eNS_URI, ModemodelFactory.INSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link ModemodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModemodelPackage init() {
		if (isInited) {
			return (ModemodelPackage) EPackage.Registry.INSTANCE.getEPackage(ModemodelPackage.eNS_URI);
		}

		// Obtain or create and register package
		Object registeredModemodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ModemodelPackage theModemodelPackage = registeredModemodelPackage instanceof ModemodelPackage
				? (ModemodelPackage) registeredModemodelPackage
				: new ModemodelPackage();

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();
		InstancePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModemodelPackage.createPackageContents();

		// Initialize created meta-data
		theModemodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModemodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModemodelPackage.eNS_URI, theModemodelPackage);
		return theModemodelPackage;
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.SOMNode <em>SOM Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SOM Node</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode
	 * @generated
	 */
	public EClass getSOMNode() {
		return somNodeEClass;
	}

	/**
	 * Returns the meta object for the reference list '{@link org.osate.analysis.modes.modemodel.SOMNode#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Out Transitions</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getOutTransitions()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_OutTransitions() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.osate.analysis.modes.modemodel.SOMNode#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Transitions</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getInTransitions()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_InTransitions() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.SOMNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getParent()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_Parent() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.osate.analysis.modes.modemodel.SOMNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getChildren()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_Children() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.modes.modemodel.SOMNode#isReachable <em>Reachable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reachable</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#isReachable()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EAttribute getSOMNode_Reachable() {
		return (EAttribute) somNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.SOMNode#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mode</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getMode()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_Mode() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * Returns the meta object for the container reference '{@link org.osate.analysis.modes.modemodel.SOMNode#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Level</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getLevel()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_Level() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.modes.modemodel.SOMNode#isDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derived</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#isDerived()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EAttribute getSOMNode_Derived() {
		return (EAttribute) somNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.osate.analysis.modes.modemodel.SOMNode#getInactiveConnections <em>Inactive Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inactive Connections</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getInactiveConnections()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_InactiveConnections() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.osate.analysis.modes.modemodel.SOMNode#getInactiveComponents <em>Inactive Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inactive Components</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMNode#getInactiveComponents()
	 * @see #getSOMNode()
	 * @generated
	 */
	public EReference getSOMNode_InactiveComponents() {
		return (EReference) somNodeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.SOMLevel <em>SOM Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SOM Level</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMLevel
	 * @generated
	 */
	public EClass getSOMLevel() {
		return somLevelEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.modes.modemodel.SOMLevel#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMLevel#getNodes()
	 * @see #getSOMLevel()
	 * @generated
	 */
	public EReference getSOMLevel_Nodes() {
		return (EReference) somLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.SOMLevel#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMLevel#getComponent()
	 * @see #getSOMLevel()
	 * @generated
	 */
	public EReference getSOMLevel_Component() {
		return (EReference) somLevelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.modes.modemodel.SOMLevel#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMLevel#getTransitions()
	 * @see #getSOMLevel()
	 * @generated
	 */
	public EReference getSOMLevel_Transitions() {
		return (EReference) somLevelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.SOMLevel#getInitialNode <em>Initial Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Node</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMLevel#getInitialNode()
	 * @see #getSOMLevel()
	 * @generated
	 */
	public EReference getSOMLevel_InitialNode() {
		return (EReference) somLevelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.InactiveNode <em>Inactive Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inactive Node</em>'.
	 * @see org.osate.analysis.modes.modemodel.InactiveNode
	 * @generated
	 */
	public EClass getInactiveNode() {
		return inactiveNodeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.modes.modemodel.InactiveNode#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.osate.analysis.modes.modemodel.InactiveNode#isActive()
	 * @see #getInactiveNode()
	 * @generated
	 */
	public EAttribute getInactiveNode_Active() {
		return (EAttribute) inactiveNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.ActiveNode <em>Active Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Node</em>'.
	 * @see org.osate.analysis.modes.modemodel.ActiveNode
	 * @generated
	 */
	public EClass getActiveNode() {
		return activeNodeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.modes.modemodel.ActiveNode#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.osate.analysis.modes.modemodel.ActiveNode#isActive()
	 * @see #getActiveNode()
	 * @generated
	 */
	public EAttribute getActiveNode_Active() {
		return (EAttribute) activeNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.osate.analysis.modes.modemodel.Transition
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.Transition#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see org.osate.analysis.modes.modemodel.Transition#getSrc()
	 * @see #getTransition()
	 * @generated
	 */
	public EReference getTransition_Src() {
		return (EReference) transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.Transition#getDst <em>Dst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dst</em>'.
	 * @see org.osate.analysis.modes.modemodel.Transition#getDst()
	 * @see #getTransition()
	 * @generated
	 */
	public EReference getTransition_Dst() {
		return (EReference) transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trigger</em>'.
	 * @see org.osate.analysis.modes.modemodel.Transition#getTrigger()
	 * @see #getTransition()
	 * @generated
	 */
	public EReference getTransition_Trigger() {
		return (EReference) transitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.osate.analysis.modes.modemodel.Transition#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see org.osate.analysis.modes.modemodel.Transition#getConnections()
	 * @see #getTransition()
	 * @generated
	 */
	public EReference getTransition_Connections() {
		return (EReference) transitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.osate.analysis.modes.modemodel.Trigger
	 * @generated
	 */
	public EClass getTrigger() {
		return triggerEClass;
	}

	/**
	 * Returns the meta object for the reference list '{@link org.osate.analysis.modes.modemodel.Trigger#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transitions</em>'.
	 * @see org.osate.analysis.modes.modemodel.Trigger#getTransitions()
	 * @see #getTrigger()
	 * @generated
	 */
	public EReference getTrigger_Transitions() {
		return (EReference) triggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.Trigger#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see org.osate.analysis.modes.modemodel.Trigger#getKey()
	 * @see #getTrigger()
	 * @generated
	 */
	public EReference getTrigger_Key() {
		return (EReference) triggerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.Trigger#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.osate.analysis.modes.modemodel.Trigger#getComponent()
	 * @see #getTrigger()
	 * @generated
	 */
	public EReference getTrigger_Component() {
		return (EReference) triggerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.SOMGraph <em>SOM Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SOM Graph</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMGraph
	 * @generated
	 */
	public EClass getSOMGraph() {
		return somGraphEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.modes.modemodel.SOMGraph#getLevels <em>Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Levels</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMGraph#getLevels()
	 * @see #getSOMGraph()
	 * @generated
	 */
	public EReference getSOMGraph_Levels() {
		return (EReference) somGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the map '{@link org.osate.analysis.modes.modemodel.SOMGraph#getTriggers <em>Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Triggers</em>'.
	 * @see org.osate.analysis.modes.modemodel.SOMGraph#getTriggers()
	 * @see #getSOMGraph()
	 * @generated
	 */
	public EReference getSOMGraph_Triggers() {
		return (EReference) somGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.FeatureTrigger <em>Feature Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Trigger</em>'.
	 * @see org.osate.analysis.modes.modemodel.FeatureTrigger
	 * @generated
	 */
	public EClass getFeatureTrigger() {
		return featureTriggerEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.FeatureTrigger#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.osate.analysis.modes.modemodel.FeatureTrigger#getFeature()
	 * @see #getFeatureTrigger()
	 * @generated
	 */
	public EReference getFeatureTrigger_Feature() {
		return (EReference) featureTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.InternalTrigger <em>Internal Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Trigger</em>'.
	 * @see org.osate.analysis.modes.modemodel.InternalTrigger
	 * @generated
	 */
	public EClass getInternalTrigger() {
		return internalTriggerEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.InternalTrigger#getInternalFeature <em>Internal Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Internal Feature</em>'.
	 * @see org.osate.analysis.modes.modemodel.InternalTrigger#getInternalFeature()
	 * @see #getInternalTrigger()
	 * @generated
	 */
	public EReference getInternalTrigger_InternalFeature() {
		return (EReference) internalTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Trigger Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger Map</em>'.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public EClass getTriggerMap() {
		return triggerMapEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getTriggerMap()
	 * @generated
	 */
	public EReference getTriggerMap_Value() {
		return (EReference) triggerMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getTriggerMap()
	 * @generated
	 */
	public EReference getTriggerMap_Key() {
		return (EReference) triggerMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.TriggerKey <em>Trigger Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger Key</em>'.
	 * @see org.osate.analysis.modes.modemodel.TriggerKey
	 * @generated
	 */
	public EClass getTriggerKey() {
		return triggerKeyEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.modes.modemodel.TriggerKey#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trigger</em>'.
	 * @see org.osate.analysis.modes.modemodel.TriggerKey#getTrigger()
	 * @see #getTriggerKey()
	 * @generated
	 */
	public EReference getTriggerKey_Trigger() {
		return (EReference) triggerKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.FeatureKey <em>Feature Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Key</em>'.
	 * @see org.osate.analysis.modes.modemodel.FeatureKey
	 * @generated
	 */
	public EClass getFeatureKey() {
		return featureKeyEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.modes.modemodel.InternalKey <em>Internal Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Key</em>'.
	 * @see org.osate.analysis.modes.modemodel.InternalKey
	 * @generated
	 */
	public EClass getInternalKey() {
		return internalKeyEClass;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public ModemodelFactory getModemodelFactory() {
		return (ModemodelFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		somNodeEClass = createEClass(SOM_NODE);
		createEReference(somNodeEClass, SOM_NODE__OUT_TRANSITIONS);
		createEReference(somNodeEClass, SOM_NODE__IN_TRANSITIONS);
		createEReference(somNodeEClass, SOM_NODE__PARENT);
		createEReference(somNodeEClass, SOM_NODE__CHILDREN);
		createEAttribute(somNodeEClass, SOM_NODE__REACHABLE);
		createEReference(somNodeEClass, SOM_NODE__MODE);
		createEReference(somNodeEClass, SOM_NODE__LEVEL);
		createEAttribute(somNodeEClass, SOM_NODE__DERIVED);
		createEReference(somNodeEClass, SOM_NODE__INACTIVE_CONNECTIONS);
		createEReference(somNodeEClass, SOM_NODE__INACTIVE_COMPONENTS);

		somLevelEClass = createEClass(SOM_LEVEL);
		createEReference(somLevelEClass, SOM_LEVEL__NODES);
		createEReference(somLevelEClass, SOM_LEVEL__COMPONENT);
		createEReference(somLevelEClass, SOM_LEVEL__TRANSITIONS);
		createEReference(somLevelEClass, SOM_LEVEL__INITIAL_NODE);

		inactiveNodeEClass = createEClass(INACTIVE_NODE);
		createEAttribute(inactiveNodeEClass, INACTIVE_NODE__ACTIVE);

		activeNodeEClass = createEClass(ACTIVE_NODE);
		createEAttribute(activeNodeEClass, ACTIVE_NODE__ACTIVE);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__SRC);
		createEReference(transitionEClass, TRANSITION__DST);
		createEReference(transitionEClass, TRANSITION__TRIGGER);
		createEReference(transitionEClass, TRANSITION__CONNECTIONS);

		triggerEClass = createEClass(TRIGGER);
		createEReference(triggerEClass, TRIGGER__TRANSITIONS);
		createEReference(triggerEClass, TRIGGER__KEY);
		createEReference(triggerEClass, TRIGGER__COMPONENT);

		somGraphEClass = createEClass(SOM_GRAPH);
		createEReference(somGraphEClass, SOM_GRAPH__LEVELS);
		createEReference(somGraphEClass, SOM_GRAPH__TRIGGERS);

		featureTriggerEClass = createEClass(FEATURE_TRIGGER);
		createEReference(featureTriggerEClass, FEATURE_TRIGGER__FEATURE);

		internalTriggerEClass = createEClass(INTERNAL_TRIGGER);
		createEReference(internalTriggerEClass, INTERNAL_TRIGGER__INTERNAL_FEATURE);

		triggerMapEClass = createEClass(TRIGGER_MAP);
		createEReference(triggerMapEClass, TRIGGER_MAP__VALUE);
		createEReference(triggerMapEClass, TRIGGER_MAP__KEY);

		triggerKeyEClass = createEClass(TRIGGER_KEY);
		createEReference(triggerKeyEClass, TRIGGER_KEY__TRIGGER);

		featureKeyEClass = createEClass(FEATURE_KEY);

		internalKeyEClass = createEClass(INTERNAL_KEY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		InstancePackage theInstancePackage = (InstancePackage) EPackage.Registry.INSTANCE
				.getEPackage(InstancePackage.eNS_URI);
		Aadl2Package theAadl2Package = (Aadl2Package) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		inactiveNodeEClass.getESuperTypes().add(getSOMNode());
		activeNodeEClass.getESuperTypes().add(getSOMNode());
		featureTriggerEClass.getESuperTypes().add(getTrigger());
		internalTriggerEClass.getESuperTypes().add(getTrigger());
		featureKeyEClass.getESuperTypes().add(getTriggerKey());
		internalKeyEClass.getESuperTypes().add(getTriggerKey());

		// Initialize classes and features; add operations and parameters
		initEClass(somNodeEClass, SOMNode.class, "SOMNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSOMNode_OutTransitions(), getTransition(), getTransition_Src(), "outTransitions", null, 0, -1,
				SOMNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMNode_InTransitions(), getTransition(), getTransition_Dst(), "inTransitions", null, 0, -1,
				SOMNode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMNode_Parent(), getSOMNode(), getSOMNode_Children(), "parent", null, 1, 1, SOMNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMNode_Children(), getSOMNode(), getSOMNode_Parent(), "children", null, 0, -1, SOMNode.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSOMNode_Reachable(), ecorePackage.getEBoolean(), "reachable", null, 0, 1, SOMNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMNode_Mode(), theInstancePackage.getModeInstance(), null, "mode", null, 0, 1, SOMNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMNode_Level(), getSOMLevel(), getSOMLevel_Nodes(), "level", null, 1, 1, SOMNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSOMNode_Derived(), ecorePackage.getEBoolean(), "derived", null, 0, 1, SOMNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMNode_InactiveConnections(), theInstancePackage.getConnectionInstance(), null,
				"inactiveConnections", null, 0, -1, SOMNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMNode_InactiveComponents(), theInstancePackage.getComponentInstance(), null,
				"inactiveComponents", null, 0, -1, SOMNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(somNodeEClass, ecorePackage.getEBoolean(), "isActive", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(somNodeEClass, ecorePackage.getEBoolean(), "hasMode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(somLevelEClass, SOMLevel.class, "SOMLevel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSOMLevel_Nodes(), getSOMNode(), getSOMNode_Level(), "nodes", null, 0, -1, SOMLevel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMLevel_Component(), theInstancePackage.getComponentInstance(), null, "component", null, 1,
				1, SOMLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMLevel_Transitions(), getTransition(), null, "transitions", null, 0, -1, SOMLevel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSOMLevel_InitialNode(), getSOMNode(), null, "initialNode", null, 1, 1, SOMLevel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inactiveNodeEClass, InactiveNode.class, "InactiveNode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInactiveNode_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, InactiveNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(activeNodeEClass, ActiveNode.class, "ActiveNode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActiveNode_Active(), ecorePackage.getEBoolean(), "active", "true", 0, 1, ActiveNode.class,
				!IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_Src(), getSOMNode(), getSOMNode_OutTransitions(), "src", null, 1, 1,
				Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Dst(), getSOMNode(), getSOMNode_InTransitions(), "dst", null, 1, 1,
				Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Trigger(), getTrigger(), getTrigger_Transitions(), "trigger", null, 1, 1,
				Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Connections(), theInstancePackage.getConnectionInstance(), null, "connections",
				null, 1, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(triggerEClass, Trigger.class, "Trigger", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrigger_Transitions(), getTransition(), getTransition_Trigger(), "transitions", null, 0, -1,
				Trigger.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrigger_Key(), getTriggerKey(), getTriggerKey_Trigger(), "key", null, 1, 1, Trigger.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrigger_Component(), theInstancePackage.getComponentInstance(), null, "component", null, 1, 1,
				Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(somGraphEClass, SOMGraph.class, "SOMGraph", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSOMGraph_Levels(), getSOMLevel(), null, "levels", null, 0, -1, SOMGraph.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getSOMGraph_Triggers(), getTriggerMap(), null, "triggers", null, 0, -1, SOMGraph.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureTriggerEClass, FeatureTrigger.class, "FeatureTrigger", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureTrigger_Feature(), theInstancePackage.getFeatureInstance(), null, "feature", null, 1,
				1, FeatureTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalTriggerEClass, InternalTrigger.class, "InternalTrigger", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalTrigger_InternalFeature(), theAadl2Package.getInternalFeature(), null,
				"internalFeature", null, 1, 1, InternalTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(triggerMapEClass, Map.Entry.class, "TriggerMap", !IS_ABSTRACT, !IS_INTERFACE,
				!IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTriggerMap_Value(), getTrigger(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getTriggerMap_Key(), getTriggerKey(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(triggerKeyEClass, TriggerKey.class, "TriggerKey", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTriggerKey_Trigger(), getTrigger(), getTrigger_Key(), "trigger", null, 1, 1, TriggerKey.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureKeyEClass, FeatureKey.class, "FeatureKey", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(featureKeyEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureKeyEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(internalKeyEClass, InternalKey.class, "InternalKey", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(internalKeyEClass, ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(internalKeyEClass, ecorePackage.getEInt(), "hashCode", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

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
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.SOMNode <em>SOM Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.SOMNode
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getSOMNode()
		 * @generated
		 */
		public static final EClass SOM_NODE = eINSTANCE.getSOMNode();

		/**
		 * The meta object literal for the '<em><b>Out Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__OUT_TRANSITIONS = eINSTANCE.getSOMNode_OutTransitions();

		/**
		 * The meta object literal for the '<em><b>In Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__IN_TRANSITIONS = eINSTANCE.getSOMNode_InTransitions();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__PARENT = eINSTANCE.getSOMNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__CHILDREN = eINSTANCE.getSOMNode_Children();

		/**
		 * The meta object literal for the '<em><b>Reachable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute SOM_NODE__REACHABLE = eINSTANCE.getSOMNode_Reachable();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__MODE = eINSTANCE.getSOMNode_Mode();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__LEVEL = eINSTANCE.getSOMNode_Level();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute SOM_NODE__DERIVED = eINSTANCE.getSOMNode_Derived();

		/**
		 * The meta object literal for the '<em><b>Inactive Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__INACTIVE_CONNECTIONS = eINSTANCE.getSOMNode_InactiveConnections();

		/**
		 * The meta object literal for the '<em><b>Inactive Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_NODE__INACTIVE_COMPONENTS = eINSTANCE.getSOMNode_InactiveComponents();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.SOMLevel <em>SOM Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.SOMLevel
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getSOMLevel()
		 * @generated
		 */
		public static final EClass SOM_LEVEL = eINSTANCE.getSOMLevel();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_LEVEL__NODES = eINSTANCE.getSOMLevel_Nodes();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_LEVEL__COMPONENT = eINSTANCE.getSOMLevel_Component();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_LEVEL__TRANSITIONS = eINSTANCE.getSOMLevel_Transitions();

		/**
		 * The meta object literal for the '<em><b>Initial Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_LEVEL__INITIAL_NODE = eINSTANCE.getSOMLevel_InitialNode();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.InactiveNode <em>Inactive Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.InactiveNode
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getInactiveNode()
		 * @generated
		 */
		public static final EClass INACTIVE_NODE = eINSTANCE.getInactiveNode();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute INACTIVE_NODE__ACTIVE = eINSTANCE.getInactiveNode_Active();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.ActiveNode <em>Active Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.ActiveNode
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getActiveNode()
		 * @generated
		 */
		public static final EClass ACTIVE_NODE = eINSTANCE.getActiveNode();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ACTIVE_NODE__ACTIVE = eINSTANCE.getActiveNode_Active();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.Transition <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.Transition
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTransition()
		 * @generated
		 */
		public static final EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRANSITION__SRC = eINSTANCE.getTransition_Src();

		/**
		 * The meta object literal for the '<em><b>Dst</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRANSITION__DST = eINSTANCE.getTransition_Dst();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRANSITION__TRIGGER = eINSTANCE.getTransition_Trigger();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRANSITION__CONNECTIONS = eINSTANCE.getTransition_Connections();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.Trigger <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.Trigger
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTrigger()
		 * @generated
		 */
		public static final EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRIGGER__TRANSITIONS = eINSTANCE.getTrigger_Transitions();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRIGGER__KEY = eINSTANCE.getTrigger_Key();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRIGGER__COMPONENT = eINSTANCE.getTrigger_Component();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.SOMGraph <em>SOM Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.SOMGraph
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getSOMGraph()
		 * @generated
		 */
		public static final EClass SOM_GRAPH = eINSTANCE.getSOMGraph();

		/**
		 * The meta object literal for the '<em><b>Levels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_GRAPH__LEVELS = eINSTANCE.getSOMGraph_Levels();

		/**
		 * The meta object literal for the '<em><b>Triggers</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference SOM_GRAPH__TRIGGERS = eINSTANCE.getSOMGraph_Triggers();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.FeatureTrigger <em>Feature Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.FeatureTrigger
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getFeatureTrigger()
		 * @generated
		 */
		public static final EClass FEATURE_TRIGGER = eINSTANCE.getFeatureTrigger();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FEATURE_TRIGGER__FEATURE = eINSTANCE.getFeatureTrigger_Feature();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.InternalTrigger <em>Internal Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.InternalTrigger
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getInternalTrigger()
		 * @generated
		 */
		public static final EClass INTERNAL_TRIGGER = eINSTANCE.getInternalTrigger();

		/**
		 * The meta object literal for the '<em><b>Internal Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference INTERNAL_TRIGGER__INTERNAL_FEATURE = eINSTANCE
				.getInternalTrigger_InternalFeature();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.TriggerMap <em>Trigger Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.TriggerMap
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTriggerMap()
		 * @generated
		 */
		public static final EClass TRIGGER_MAP = eINSTANCE.getTriggerMap();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRIGGER_MAP__VALUE = eINSTANCE.getTriggerMap_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRIGGER_MAP__KEY = eINSTANCE.getTriggerMap_Key();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.TriggerKey <em>Trigger Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.TriggerKey
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getTriggerKey()
		 * @generated
		 */
		public static final EClass TRIGGER_KEY = eINSTANCE.getTriggerKey();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TRIGGER_KEY__TRIGGER = eINSTANCE.getTriggerKey_Trigger();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.FeatureKey <em>Feature Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.FeatureKey
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getFeatureKey()
		 * @generated
		 */
		public static final EClass FEATURE_KEY = eINSTANCE.getFeatureKey();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.modes.modemodel.InternalKey <em>Internal Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.modes.modemodel.InternalKey
		 * @see org.osate.analysis.modes.modemodel.ModemodelPackage#getInternalKey()
		 * @generated
		 */
		public static final EClass INTERNAL_KEY = eINSTANCE.getInternalKey();

	}

} // ModemodelPackage
