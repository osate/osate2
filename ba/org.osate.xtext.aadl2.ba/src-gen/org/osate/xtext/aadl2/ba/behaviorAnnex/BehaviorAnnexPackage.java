/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.behaviorAnnex;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.osate.aadl2.Aadl2Package;

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
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexFactory
 * @model kind="package"
 * @generated
 */
public interface BehaviorAnnexPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "behaviorAnnex";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.aadl.info/BehaviorSpecification";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "behaviorAnnex";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BehaviorAnnexPackage eINSTANCE = org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexImpl <em>Behavior Annex</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorAnnex()
   * @generated
   */
  int BEHAVIOR_ANNEX = 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__OWNED_ELEMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__OWNED_COMMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__NAME = Aadl2Package.ANNEX_SUBCLAUSE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__QUALIFIED_NAME = Aadl2Package.ANNEX_SUBCLAUSE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>In Mode</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__IN_MODE = Aadl2Package.ANNEX_SUBCLAUSE__IN_MODE;

  /**
   * The feature id for the '<em><b>Variable Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__VARIABLE_GROUPS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__STATE_GROUPS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__TRANSITIONS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Behavior Annex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX_FEATURE_COUNT = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl <em>Behavior Variable Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorVariableGroup()
   * @generated
   */
  int BEHAVIOR_VARIABLE_GROUP = 1;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_GROUP__VARIABLES = 0;

  /**
   * The feature id for the '<em><b>Data Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER = 1;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE = 2;

  /**
   * The feature id for the '<em><b>Property Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS = 3;

  /**
   * The number of structural features of the '<em>Behavior Variable Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_GROUP_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableImpl <em>Behavior Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorVariable()
   * @generated
   */
  int BEHAVIOR_VARIABLE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Array Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__ARRAY_DIMENSIONS = 1;

  /**
   * The number of structural features of the '<em>Behavior Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayDimensionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getArrayDimension()
   * @generated
   */
  int ARRAY_DIMENSION = 3;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION__SIZE = 0;

  /**
   * The number of structural features of the '<em>Array Dimension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorPropertyAssociationImpl <em>Behavior Property Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorPropertyAssociationImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorPropertyAssociation()
   * @generated
   */
  int BEHAVIOR_PROPERTY_ASSOCIATION = 4;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_ASSOCIATION__PROPERTY = 0;

  /**
   * The feature id for the '<em><b>Owned Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_ASSOCIATION__OWNED_VALUE = 1;

  /**
   * The number of structural features of the '<em>Behavior Property Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_ASSOCIATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl <em>Behavior State Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorStateGroup()
   * @generated
   */
  int BEHAVIOR_STATE_GROUP = 5;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE_GROUP__STATES = 0;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE_GROUP__INITIAL = 1;

  /**
   * The feature id for the '<em><b>Complete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE_GROUP__COMPLETE = 2;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE_GROUP__FINAL = 3;

  /**
   * The number of structural features of the '<em>Behavior State Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE_GROUP_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorState()
   * @generated
   */
  int BEHAVIOR_STATE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__NAME = 0;

  /**
   * The number of structural features of the '<em>Behavior State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorTransition()
   * @generated
   */
  int BEHAVIOR_TRANSITION = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__PRIORITY = 1;

  /**
   * The feature id for the '<em><b>Source States</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__SOURCE_STATES = 2;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__CONDITION = 3;

  /**
   * The feature id for the '<em><b>Destination State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__DESTINATION_STATE = 4;

  /**
   * The feature id for the '<em><b>Action Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__ACTION_BLOCK = 5;

  /**
   * The number of structural features of the '<em>Behavior Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorConditionImpl <em>Behavior Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorConditionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorCondition()
   * @generated
   */
  int BEHAVIOR_CONDITION = 8;

  /**
   * The feature id for the '<em><b>Dispatch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_CONDITION__DISPATCH = 0;

  /**
   * The feature id for the '<em><b>Mode Switch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_CONDITION__MODE_SWITCH = 1;

  /**
   * The feature id for the '<em><b>Execute</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_CONDITION__EXECUTE = 2;

  /**
   * The number of structural features of the '<em>Behavior Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_CONDITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ExecuteConditionImpl <em>Execute Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ExecuteConditionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getExecuteCondition()
   * @generated
   */
  int EXECUTE_CONDITION = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CONDITION__VALUE = 0;

  /**
   * The feature id for the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CONDITION__TIMEOUT = 1;

  /**
   * The feature id for the '<em><b>Otherwise</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CONDITION__OTHERWISE = 2;

  /**
   * The number of structural features of the '<em>Execute Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CONDITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConditionImpl <em>Dispatch Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConditionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchCondition()
   * @generated
   */
  int DISPATCH_CONDITION = 10;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION__TRIGGER = 0;

  /**
   * The feature id for the '<em><b>Frozen Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION__FROZEN_PORTS = 1;

  /**
   * The number of structural features of the '<em>Dispatch Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl <em>Dispatch Trigger Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchTriggerCondition()
   * @generated
   */
  int DISPATCH_TRIGGER_CONDITION = 11;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION__TIMEOUT = 1;

  /**
   * The feature id for the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION__TIME = 2;

  /**
   * The feature id for the '<em><b>Stop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION__STOP = 3;

  /**
   * The number of structural features of the '<em>Dispatch Trigger Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerLogicalExpressionImpl <em>Dispatch Trigger Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerLogicalExpressionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchTriggerLogicalExpression()
   * @generated
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION = 12;

  /**
   * The feature id for the '<em><b>Conjunctions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__CONJUNCTIONS = 0;

  /**
   * The number of structural features of the '<em>Dispatch Trigger Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConjunctionImpl <em>Dispatch Conjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConjunctionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchConjunction()
   * @generated
   */
  int DISPATCH_CONJUNCTION = 13;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONJUNCTION__TRIGGERS = 0;

  /**
   * The number of structural features of the '<em>Dispatch Conjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONJUNCTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConditionImpl <em>Mode Switch Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConditionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getModeSwitchCondition()
   * @generated
   */
  int MODE_SWITCH_CONDITION = 14;

  /**
   * The feature id for the '<em><b>Conjunctions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODE_SWITCH_CONDITION__CONJUNCTIONS = 0;

  /**
   * The number of structural features of the '<em>Mode Switch Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODE_SWITCH_CONDITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConjunctionImpl <em>Mode Switch Conjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConjunctionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getModeSwitchConjunction()
   * @generated
   */
  int MODE_SWITCH_CONJUNCTION = 15;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODE_SWITCH_CONJUNCTION__TRIGGERS = 0;

  /**
   * The number of structural features of the '<em>Mode Switch Conjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODE_SWITCH_CONJUNCTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionsImpl <em>Behavior Actions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionsImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActions()
   * @generated
   */
  int BEHAVIOR_ACTIONS = 17;

  /**
   * The number of structural features of the '<em>Behavior Actions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTIONS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionImpl <em>Behavior Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorAction()
   * @generated
   */
  int BEHAVIOR_ACTION = 18;

  /**
   * The number of structural features of the '<em>Behavior Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_FEATURE_COUNT = BEHAVIOR_ACTIONS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionBlockImpl <em>Behavior Action Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionBlockImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActionBlock()
   * @generated
   */
  int BEHAVIOR_ACTION_BLOCK = 16;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_BLOCK__CONTENT = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Timeout</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_BLOCK__TIMEOUT = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Behavior Action Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_BLOCK_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.AssignmentActionImpl <em>Assignment Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.AssignmentActionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getAssignmentAction()
   * @generated
   */
  int ASSIGNMENT_ACTION = 19;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION__TARGET = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION__VALUE = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION__ANY = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assignment Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl <em>Communication Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getCommunicationAction()
   * @generated
   */
  int COMMUNICATION_ACTION = 20;

  /**
   * The feature id for the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__REFERENCE = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Send</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__SEND = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__PARAMETERS = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Dequeue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__DEQUEUE = BEHAVIOR_ACTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__TARGET = BEHAVIOR_ACTION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Freeze</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__FREEZE = BEHAVIOR_ACTION_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Lock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__LOCK = BEHAVIOR_ACTION_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Unlock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__UNLOCK = BEHAVIOR_ACTION_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__ALL = BEHAVIOR_ACTION_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>All Lock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__ALL_LOCK = BEHAVIOR_ACTION_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>All Unlock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__ALL_UNLOCK = BEHAVIOR_ACTION_FEATURE_COUNT + 10;

  /**
   * The number of structural features of the '<em>Communication Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 11;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.TimedActionImpl <em>Timed Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.TimedActionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getTimedAction()
   * @generated
   */
  int TIMED_ACTION = 21;

  /**
   * The feature id for the '<em><b>Lower Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION__LOWER_TIME = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION__UPPER_TIME = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Processors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION__PROCESSORS = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Timed Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 22;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__CONDITION = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__THEN_ACTIONS = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Ifs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE_IFS = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Else Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE_ACTIONS = BEHAVIOR_ACTION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElseIfClauseImpl <em>Else If Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElseIfClauseImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getElseIfClause()
   * @generated
   */
  int ELSE_IF_CLAUSE = 23;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF_CLAUSE__CONDITION = 0;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF_CLAUSE__ACTIONS = 1;

  /**
   * The number of structural features of the '<em>Else If Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_IF_CLAUSE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl <em>For Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getForStatement()
   * @generated
   */
  int FOR_STATEMENT = 24;

  /**
   * The feature id for the '<em><b>For</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__FOR = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Forall</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__FORALL = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__VARIABLE = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Data Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__DATA_CLASSIFIER = BEHAVIOR_ACTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__VALUES = BEHAVIOR_ACTION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT__ACTIONS = BEHAVIOR_ACTION_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>For Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_STATEMENT_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.WhileStatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.WhileStatementImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getWhileStatement()
   * @generated
   */
  int WHILE_STATEMENT = 25;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__CONDITION = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__ACTIONS = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DoUntilStatementImpl <em>Do Until Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DoUntilStatementImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDoUntilStatement()
   * @generated
   */
  int DO_UNTIL_STATEMENT = 26;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_UNTIL_STATEMENT__ACTIONS = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_UNTIL_STATEMENT__CONDITION = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Do Until Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_UNTIL_STATEMENT_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElementValuesImpl <em>Element Values</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElementValuesImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getElementValues()
   * @generated
   */
  int ELEMENT_VALUES = 27;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_VALUES__LOWER = 0;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_VALUES__UPPER = 1;

  /**
   * The number of structural features of the '<em>Element Values</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_VALUES_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTimeImpl <em>Behavior Time</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTimeImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorTime()
   * @generated
   */
  int BEHAVIOR_TIME = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME__VALUE = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME__UNIT = 1;

  /**
   * The number of structural features of the '<em>Behavior Time</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IntegerValueImpl <em>Integer Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IntegerValueImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getIntegerValue()
   * @generated
   */
  int INTEGER_VALUE = 29;

  /**
   * The number of structural features of the '<em>Integer Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueExpressionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getValueExpression()
   * @generated
   */
  int VALUE_EXPRESSION = 30;

  /**
   * The number of structural features of the '<em>Value Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueConstantImpl <em>Value Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueConstantImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getValueConstant()
   * @generated
   */
  int VALUE_CONSTANT = 31;

  /**
   * The number of structural features of the '<em>Value Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONSTANT_FEATURE_COUNT = VALUE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorIntegerLiteralImpl <em>Behavior Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorIntegerLiteralImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorIntegerLiteral()
   * @generated
   */
  int BEHAVIOR_INTEGER_LITERAL = 32;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_INTEGER_LITERAL__VALUE = INTEGER_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Integer Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_INTEGER_LITERAL_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorRealLiteralImpl <em>Behavior Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorRealLiteralImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorRealLiteral()
   * @generated
   */
  int BEHAVIOR_REAL_LITERAL = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_REAL_LITERAL__VALUE = VALUE_CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_REAL_LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStringLiteralImpl <em>Behavior String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStringLiteralImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorStringLiteral()
   * @generated
   */
  int BEHAVIOR_STRING_LITERAL = 34;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STRING_LITERAL__VALUE = VALUE_CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STRING_LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorBooleanLiteralImpl <em>Behavior Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorBooleanLiteralImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorBooleanLiteral()
   * @generated
   */
  int BEHAVIOR_BOOLEAN_LITERAL = 35;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_BOOLEAN_LITERAL__VALUE = VALUE_CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_BOOLEAN_LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl <em>Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReferenceExpression()
   * @generated
   */
  int REFERENCE_EXPRESSION = 36;

  /**
   * The feature id for the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_EXPRESSION__REFERENCE = INTEGER_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_EXPRESSION__PROPERTY = INTEGER_VALUE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Dequeue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_EXPRESSION__DEQUEUE = INTEGER_VALUE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_EXPRESSION__COUNT = INTEGER_VALUE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Fresh</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_EXPRESSION__FRESH = INTEGER_VALUE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_EXPRESSION_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.HashPropertyReferenceImpl <em>Hash Property Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.HashPropertyReferenceImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getHashPropertyReference()
   * @generated
   */
  int HASH_PROPERTY_REFERENCE = 37;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_PROPERTY_REFERENCE__PROPERTY = INTEGER_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_PROPERTY_REFERENCE__INDEXES = INTEGER_VALUE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_PROPERTY_REFERENCE__FIELDS = INTEGER_VALUE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Hash Property Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HASH_PROPERTY_REFERENCE_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyReferenceTailImpl <em>Property Reference Tail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyReferenceTailImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyReferenceTail()
   * @generated
   */
  int PROPERTY_REFERENCE_TAIL = 38;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_TAIL__PROPERTY = 0;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_TAIL__INDEXES = 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_TAIL__FIELDS = 2;

  /**
   * The number of structural features of the '<em>Property Reference Tail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_TAIL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.NamedPropertyFieldImpl <em>Named Property Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.NamedPropertyFieldImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getNamedPropertyField()
   * @generated
   */
  int NAMED_PROPERTY_FIELD = 39;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_PROPERTY_FIELD__NAME = 0;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_PROPERTY_FIELD__INDEXES = 1;

  /**
   * The number of structural features of the '<em>Named Property Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_PROPERTY_FIELD_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyArrayIndexImpl <em>Property Array Index</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyArrayIndexImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyArrayIndex()
   * @generated
   */
  int PROPERTY_ARRAY_INDEX = 40;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ARRAY_INDEX__VALUE = 0;

  /**
   * The number of structural features of the '<em>Property Array Index</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ARRAY_INDEX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexValueImpl <em>Property Index Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexValueImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyIndexValue()
   * @generated
   */
  int PROPERTY_INDEX_VALUE = 41;

  /**
   * The number of structural features of the '<em>Property Index Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_INDEX_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexPropertyReferenceImpl <em>Property Index Property Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexPropertyReferenceImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyIndexPropertyReference()
   * @generated
   */
  int PROPERTY_INDEX_PROPERTY_REFERENCE = 42;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_INDEX_PROPERTY_REFERENCE__PROPERTY = PROPERTY_INDEX_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Index Property Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_INDEX_PROPERTY_REFERENCE_FEATURE_COUNT = PROPERTY_INDEX_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl <em>Unindexed Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReferenceExpression()
   * @generated
   */
  int UNINDEXED_REFERENCE_EXPRESSION = 43;

  /**
   * The feature id for the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_EXPRESSION__REFERENCE = PROPERTY_INDEX_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Dequeue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE = PROPERTY_INDEX_VALUE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_EXPRESSION__COUNT = PROPERTY_INDEX_VALUE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Fresh</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_EXPRESSION__FRESH = PROPERTY_INDEX_VALUE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Unindexed Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_EXPRESSION_FEATURE_COUNT = PROPERTY_INDEX_VALUE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceImpl <em>Unindexed Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReference()
   * @generated
   */
  int UNINDEXED_REFERENCE = 44;

  /**
   * The feature id for the '<em><b>Segments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE__SEGMENTS = 0;

  /**
   * The feature id for the '<em><b>Tails</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE__TAILS = 1;

  /**
   * The number of structural features of the '<em>Unindexed Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceTailImpl <em>Unindexed Reference Tail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceTailImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReferenceTail()
   * @generated
   */
  int UNINDEXED_REFERENCE_TAIL = 45;

  /**
   * The feature id for the '<em><b>Separator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_TAIL__SEPARATOR = 0;

  /**
   * The feature id for the '<em><b>Segment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_TAIL__SEGMENT = 1;

  /**
   * The number of structural features of the '<em>Unindexed Reference Tail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_TAIL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceSegmentImpl <em>Unindexed Reference Segment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceSegmentImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReferenceSegment()
   * @generated
   */
  int UNINDEXED_REFERENCE_SEGMENT = 46;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_SEGMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Unindexed Reference Segment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNINDEXED_REFERENCE_SEGMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 47;

  /**
   * The feature id for the '<em><b>Segments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__SEGMENTS = 0;

  /**
   * The feature id for the '<em><b>Tails</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__TAILS = 1;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceTailImpl <em>Reference Tail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceTailImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReferenceTail()
   * @generated
   */
  int REFERENCE_TAIL = 48;

  /**
   * The feature id for the '<em><b>Separator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TAIL__SEPARATOR = 0;

  /**
   * The feature id for the '<em><b>Segment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TAIL__SEGMENT = 1;

  /**
   * The number of structural features of the '<em>Reference Tail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TAIL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceSegmentImpl <em>Reference Segment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceSegmentImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReferenceSegment()
   * @generated
   */
  int REFERENCE_SEGMENT = 49;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_SEGMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_SEGMENT__INDEXES = 1;

  /**
   * The number of structural features of the '<em>Reference Segment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_SEGMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayIndexImpl <em>Array Index</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayIndexImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getArrayIndex()
   * @generated
   */
  int ARRAY_INDEX = 50;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_INDEX__VALUE = 0;

  /**
   * The number of structural features of the '<em>Array Index</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_INDEX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSequenceImpl <em>Behavior Action Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSequenceImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActionSequence()
   * @generated
   */
  int BEHAVIOR_ACTION_SEQUENCE = 51;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SEQUENCE__ACTIONS = BEHAVIOR_ACTIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Action Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SEQUENCE_FEATURE_COUNT = BEHAVIOR_ACTIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSetImpl <em>Behavior Action Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSetImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActionSet()
   * @generated
   */
  int BEHAVIOR_ACTION_SET = 52;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SET__ACTIONS = BEHAVIOR_ACTIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Action Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SET_FEATURE_COUNT = BEHAVIOR_ACTIONS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BinaryExpressionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBinaryExpression()
   * @generated
   */
  int BINARY_EXPRESSION = 53;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPRESSION__LEFT = VALUE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPRESSION__OPERATOR = VALUE_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPRESSION__RIGHT = VALUE_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPRESSION_FEATURE_COUNT = VALUE_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnaryExpressionImpl
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 54;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OPERATOR = VALUE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OPERAND = VALUE_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = VALUE_EXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex <em>Behavior Annex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Annex</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex
   * @generated
   */
  EClass getBehaviorAnnex();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex#getVariableGroups <em>Variable Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variable Groups</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex#getVariableGroups()
   * @see #getBehaviorAnnex()
   * @generated
   */
  EReference getBehaviorAnnex_VariableGroups();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex#getStateGroups <em>State Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Groups</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex#getStateGroups()
   * @see #getBehaviorAnnex()
   * @generated
   */
  EReference getBehaviorAnnex_StateGroups();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex#getTransitions()
   * @see #getBehaviorAnnex()
   * @generated
   */
  EReference getBehaviorAnnex_Transitions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup <em>Behavior Variable Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Variable Group</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup
   * @generated
   */
  EClass getBehaviorVariableGroup();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getVariables()
   * @see #getBehaviorVariableGroup()
   * @generated
   */
  EReference getBehaviorVariableGroup_Variables();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getDataClassifier <em>Data Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Data Classifier</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getDataClassifier()
   * @see #getBehaviorVariableGroup()
   * @generated
   */
  EReference getBehaviorVariableGroup_DataClassifier();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getInitialValue()
   * @see #getBehaviorVariableGroup()
   * @generated
   */
  EReference getBehaviorVariableGroup_InitialValue();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getPropertyAssociations <em>Property Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property Associations</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup#getPropertyAssociations()
   * @see #getBehaviorVariableGroup()
   * @generated
   */
  EReference getBehaviorVariableGroup_PropertyAssociations();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable <em>Behavior Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Variable</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable
   * @generated
   */
  EClass getBehaviorVariable();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable#getName()
   * @see #getBehaviorVariable()
   * @generated
   */
  EAttribute getBehaviorVariable_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable#getArrayDimensions <em>Array Dimensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Array Dimensions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable#getArrayDimensions()
   * @see #getBehaviorVariable()
   * @generated
   */
  EReference getBehaviorVariable_ArrayDimensions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension <em>Array Dimension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Dimension</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension
   * @generated
   */
  EClass getArrayDimension();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension#getSize()
   * @see #getArrayDimension()
   * @generated
   */
  EReference getArrayDimension_Size();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation <em>Behavior Property Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Property Association</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation
   * @generated
   */
  EClass getBehaviorPropertyAssociation();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation#getProperty()
   * @see #getBehaviorPropertyAssociation()
   * @generated
   */
  EReference getBehaviorPropertyAssociation_Property();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation#getOwnedValue <em>Owned Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation#getOwnedValue()
   * @see #getBehaviorPropertyAssociation()
   * @generated
   */
  EReference getBehaviorPropertyAssociation_OwnedValue();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup <em>Behavior State Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior State Group</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup
   * @generated
   */
  EClass getBehaviorStateGroup();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#getStates()
   * @see #getBehaviorStateGroup()
   * @generated
   */
  EReference getBehaviorStateGroup_States();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#isInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#isInitial()
   * @see #getBehaviorStateGroup()
   * @generated
   */
  EAttribute getBehaviorStateGroup_Initial();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#isComplete <em>Complete</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Complete</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#isComplete()
   * @see #getBehaviorStateGroup()
   * @generated
   */
  EAttribute getBehaviorStateGroup_Complete();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup#isFinal()
   * @see #getBehaviorStateGroup()
   * @generated
   */
  EAttribute getBehaviorStateGroup_Final();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState <em>Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior State</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState
   * @generated
   */
  EClass getBehaviorState();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState#getName()
   * @see #getBehaviorState()
   * @generated
   */
  EAttribute getBehaviorState_Name();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition <em>Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Transition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition
   * @generated
   */
  EClass getBehaviorTransition();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getName()
   * @see #getBehaviorTransition()
   * @generated
   */
  EAttribute getBehaviorTransition_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getPriority()
   * @see #getBehaviorTransition()
   * @generated
   */
  EAttribute getBehaviorTransition_Priority();

  /**
   * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getSourceStates <em>Source States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Source States</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getSourceStates()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_SourceStates();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getCondition()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_Condition();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getDestinationState <em>Destination State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Destination State</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getDestinationState()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_DestinationState();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getActionBlock <em>Action Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action Block</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getActionBlock()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_ActionBlock();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition <em>Behavior Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition
   * @generated
   */
  EClass getBehaviorCondition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition#getDispatch <em>Dispatch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dispatch</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition#getDispatch()
   * @see #getBehaviorCondition()
   * @generated
   */
  EReference getBehaviorCondition_Dispatch();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition#getModeSwitch <em>Mode Switch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mode Switch</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition#getModeSwitch()
   * @see #getBehaviorCondition()
   * @generated
   */
  EReference getBehaviorCondition_ModeSwitch();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition#getExecute <em>Execute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Execute</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition#getExecute()
   * @see #getBehaviorCondition()
   * @generated
   */
  EReference getBehaviorCondition_Execute();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition <em>Execute Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execute Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition
   * @generated
   */
  EClass getExecuteCondition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition#getValue()
   * @see #getExecuteCondition()
   * @generated
   */
  EReference getExecuteCondition_Value();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition#isTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timeout</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition#isTimeout()
   * @see #getExecuteCondition()
   * @generated
   */
  EAttribute getExecuteCondition_Timeout();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition#isOtherwise <em>Otherwise</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Otherwise</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition#isOtherwise()
   * @see #getExecuteCondition()
   * @generated
   */
  EAttribute getExecuteCondition_Otherwise();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition <em>Dispatch Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition
   * @generated
   */
  EClass getDispatchCondition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition#getTrigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trigger</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition#getTrigger()
   * @see #getDispatchCondition()
   * @generated
   */
  EReference getDispatchCondition_Trigger();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Frozen Ports</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition#getFrozenPorts()
   * @see #getDispatchCondition()
   * @generated
   */
  EReference getDispatchCondition_FrozenPorts();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Trigger Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition
   * @generated
   */
  EClass getDispatchTriggerCondition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getExpression()
   * @see #getDispatchTriggerCondition()
   * @generated
   */
  EReference getDispatchTriggerCondition_Expression();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timeout</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isTimeout()
   * @see #getDispatchTriggerCondition()
   * @generated
   */
  EAttribute getDispatchTriggerCondition_Timeout();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Time</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getTime()
   * @see #getDispatchTriggerCondition()
   * @generated
   */
  EReference getDispatchTriggerCondition_Time();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isStop <em>Stop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Stop</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isStop()
   * @see #getDispatchTriggerCondition()
   * @generated
   */
  EAttribute getDispatchTriggerCondition_Stop();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression <em>Dispatch Trigger Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Trigger Logical Expression</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression
   * @generated
   */
  EClass getDispatchTriggerLogicalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression#getConjunctions <em>Conjunctions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conjunctions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression#getConjunctions()
   * @see #getDispatchTriggerLogicalExpression()
   * @generated
   */
  EReference getDispatchTriggerLogicalExpression_Conjunctions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction <em>Dispatch Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Conjunction</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction
   * @generated
   */
  EClass getDispatchConjunction();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction#getTriggers()
   * @see #getDispatchConjunction()
   * @generated
   */
  EReference getDispatchConjunction_Triggers();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition <em>Mode Switch Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mode Switch Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition
   * @generated
   */
  EClass getModeSwitchCondition();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition#getConjunctions <em>Conjunctions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conjunctions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition#getConjunctions()
   * @see #getModeSwitchCondition()
   * @generated
   */
  EReference getModeSwitchCondition_Conjunctions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction <em>Mode Switch Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mode Switch Conjunction</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction
   * @generated
   */
  EClass getModeSwitchConjunction();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction#getTriggers()
   * @see #getModeSwitchConjunction()
   * @generated
   */
  EReference getModeSwitchConjunction_Triggers();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock <em>Behavior Action Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action Block</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock
   * @generated
   */
  EClass getBehaviorActionBlock();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock#getContent()
   * @see #getBehaviorActionBlock()
   * @generated
   */
  EReference getBehaviorActionBlock_Content();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock#getTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Timeout</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock#getTimeout()
   * @see #getBehaviorActionBlock()
   * @generated
   */
  EReference getBehaviorActionBlock_Timeout();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions <em>Behavior Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions
   * @generated
   */
  EClass getBehaviorActions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction <em>Behavior Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction
   * @generated
   */
  EClass getBehaviorAction();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction <em>Assignment Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Action</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction
   * @generated
   */
  EClass getAssignmentAction();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction#getTarget()
   * @see #getAssignmentAction()
   * @generated
   */
  EReference getAssignmentAction_Target();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction#getValue()
   * @see #getAssignmentAction()
   * @generated
   */
  EReference getAssignmentAction_Value();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction#isAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction#isAny()
   * @see #getAssignmentAction()
   * @generated
   */
  EAttribute getAssignmentAction_Any();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction <em>Communication Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Communication Action</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction
   * @generated
   */
  EClass getCommunicationAction();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getReference()
   * @see #getCommunicationAction()
   * @generated
   */
  EReference getCommunicationAction_Reference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isSend <em>Send</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Send</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isSend()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_Send();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getParameters()
   * @see #getCommunicationAction()
   * @generated
   */
  EReference getCommunicationAction_Parameters();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isDequeue <em>Dequeue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dequeue</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isDequeue()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_Dequeue();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getTarget()
   * @see #getCommunicationAction()
   * @generated
   */
  EReference getCommunicationAction_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isFreeze <em>Freeze</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Freeze</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isFreeze()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_Freeze();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isLock <em>Lock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lock</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isLock()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_Lock();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isUnlock <em>Unlock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unlock</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isUnlock()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_Unlock();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAll <em>All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>All</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAll()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_All();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllLock <em>All Lock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>All Lock</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllLock()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_AllLock();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllUnlock <em>All Unlock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>All Unlock</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllUnlock()
   * @see #getCommunicationAction()
   * @generated
   */
  EAttribute getCommunicationAction_AllUnlock();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction <em>Timed Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timed Action</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction
   * @generated
   */
  EClass getTimedAction();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction#getLowerTime <em>Lower Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower Time</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction#getLowerTime()
   * @see #getTimedAction()
   * @generated
   */
  EReference getTimedAction_LowerTime();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction#getUpperTime <em>Upper Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper Time</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction#getUpperTime()
   * @see #getTimedAction()
   * @generated
   */
  EReference getTimedAction_UpperTime();

  /**
   * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction#getProcessors <em>Processors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Processors</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction#getProcessors()
   * @see #getTimedAction()
   * @generated
   */
  EReference getTimedAction_Processors();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement
   * @generated
   */
  EClass getIfStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getCondition()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getThenActions <em>Then Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getThenActions()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ThenActions();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getElseIfs <em>Else Ifs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Else Ifs</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getElseIfs()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ElseIfs();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getElseActions <em>Else Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getElseActions()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ElseActions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause <em>Else If Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else If Clause</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause
   * @generated
   */
  EClass getElseIfClause();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause#getCondition()
   * @see #getElseIfClause()
   * @generated
   */
  EReference getElseIfClause_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause#getActions()
   * @see #getElseIfClause()
   * @generated
   */
  EReference getElseIfClause_Actions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Statement</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement
   * @generated
   */
  EClass getForStatement();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isFor <em>For</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>For</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isFor()
   * @see #getForStatement()
   * @generated
   */
  EAttribute getForStatement_For();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isForall <em>Forall</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Forall</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isForall()
   * @see #getForStatement()
   * @generated
   */
  EAttribute getForStatement_Forall();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getVariable()
   * @see #getForStatement()
   * @generated
   */
  EAttribute getForStatement_Variable();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getDataClassifier <em>Data Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Data Classifier</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getDataClassifier()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_DataClassifier();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Values</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getValues()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Values();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getActions()
   * @see #getForStatement()
   * @generated
   */
  EReference getForStatement_Actions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Statement</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement
   * @generated
   */
  EClass getWhileStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement#getCondition()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement#getActions()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Actions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement <em>Do Until Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Do Until Statement</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement
   * @generated
   */
  EClass getDoUntilStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement#getActions()
   * @see #getDoUntilStatement()
   * @generated
   */
  EReference getDoUntilStatement_Actions();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement#getCondition()
   * @see #getDoUntilStatement()
   * @generated
   */
  EReference getDoUntilStatement_Condition();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues <em>Element Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Values</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues
   * @generated
   */
  EClass getElementValues();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues#getLower()
   * @see #getElementValues()
   * @generated
   */
  EReference getElementValues_Lower();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues#getUpper()
   * @see #getElementValues()
   * @generated
   */
  EReference getElementValues_Upper();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime <em>Behavior Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Time</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime
   * @generated
   */
  EClass getBehaviorTime();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime#getValue()
   * @see #getBehaviorTime()
   * @generated
   */
  EReference getBehaviorTime_Value();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime#getUnit()
   * @see #getBehaviorTime()
   * @generated
   */
  EReference getBehaviorTime_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue
   * @generated
   */
  EClass getIntegerValue();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression <em>Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Expression</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression
   * @generated
   */
  EClass getValueExpression();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant <em>Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Constant</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant
   * @generated
   */
  EClass getValueConstant();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral <em>Behavior Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Integer Literal</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral
   * @generated
   */
  EClass getBehaviorIntegerLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral#getValue()
   * @see #getBehaviorIntegerLiteral()
   * @generated
   */
  EAttribute getBehaviorIntegerLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral <em>Behavior Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Real Literal</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral
   * @generated
   */
  EClass getBehaviorRealLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral#getValue()
   * @see #getBehaviorRealLiteral()
   * @generated
   */
  EAttribute getBehaviorRealLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral <em>Behavior String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior String Literal</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral
   * @generated
   */
  EClass getBehaviorStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral#getValue()
   * @see #getBehaviorStringLiteral()
   * @generated
   */
  EAttribute getBehaviorStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral <em>Behavior Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Boolean Literal</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral
   * @generated
   */
  EClass getBehaviorBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral#isValue()
   * @see #getBehaviorBooleanLiteral()
   * @generated
   */
  EAttribute getBehaviorBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression <em>Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Expression</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression
   * @generated
   */
  EClass getReferenceExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getReference()
   * @see #getReferenceExpression()
   * @generated
   */
  EReference getReferenceExpression_Reference();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getProperty()
   * @see #getReferenceExpression()
   * @generated
   */
  EReference getReferenceExpression_Property();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isDequeue <em>Dequeue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dequeue</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isDequeue()
   * @see #getReferenceExpression()
   * @generated
   */
  EAttribute getReferenceExpression_Dequeue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isCount()
   * @see #getReferenceExpression()
   * @generated
   */
  EAttribute getReferenceExpression_Count();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isFresh <em>Fresh</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fresh</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isFresh()
   * @see #getReferenceExpression()
   * @generated
   */
  EAttribute getReferenceExpression_Fresh();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference <em>Hash Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hash Property Reference</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference
   * @generated
   */
  EClass getHashPropertyReference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference#getProperty()
   * @see #getHashPropertyReference()
   * @generated
   */
  EAttribute getHashPropertyReference_Property();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Indexes</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference#getIndexes()
   * @see #getHashPropertyReference()
   * @generated
   */
  EReference getHashPropertyReference_Indexes();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference#getFields()
   * @see #getHashPropertyReference()
   * @generated
   */
  EReference getHashPropertyReference_Fields();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail <em>Property Reference Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Reference Tail</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail
   * @generated
   */
  EClass getPropertyReferenceTail();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail#getProperty()
   * @see #getPropertyReferenceTail()
   * @generated
   */
  EAttribute getPropertyReferenceTail_Property();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Indexes</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail#getIndexes()
   * @see #getPropertyReferenceTail()
   * @generated
   */
  EReference getPropertyReferenceTail_Indexes();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail#getFields()
   * @see #getPropertyReferenceTail()
   * @generated
   */
  EReference getPropertyReferenceTail_Fields();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField <em>Named Property Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Property Field</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField
   * @generated
   */
  EClass getNamedPropertyField();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField#getName()
   * @see #getNamedPropertyField()
   * @generated
   */
  EAttribute getNamedPropertyField_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Indexes</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField#getIndexes()
   * @see #getNamedPropertyField()
   * @generated
   */
  EReference getNamedPropertyField_Indexes();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex <em>Property Array Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Array Index</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex
   * @generated
   */
  EClass getPropertyArrayIndex();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex#getValue()
   * @see #getPropertyArrayIndex()
   * @generated
   */
  EReference getPropertyArrayIndex_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexValue <em>Property Index Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Index Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexValue
   * @generated
   */
  EClass getPropertyIndexValue();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference <em>Property Index Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Index Property Reference</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference
   * @generated
   */
  EClass getPropertyIndexPropertyReference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference#getProperty()
   * @see #getPropertyIndexPropertyReference()
   * @generated
   */
  EAttribute getPropertyIndexPropertyReference_Property();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression <em>Unindexed Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unindexed Reference Expression</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression
   * @generated
   */
  EClass getUnindexedReferenceExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#getReference()
   * @see #getUnindexedReferenceExpression()
   * @generated
   */
  EReference getUnindexedReferenceExpression_Reference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#isDequeue <em>Dequeue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dequeue</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#isDequeue()
   * @see #getUnindexedReferenceExpression()
   * @generated
   */
  EAttribute getUnindexedReferenceExpression_Dequeue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#isCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#isCount()
   * @see #getUnindexedReferenceExpression()
   * @generated
   */
  EAttribute getUnindexedReferenceExpression_Count();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#isFresh <em>Fresh</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fresh</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression#isFresh()
   * @see #getUnindexedReferenceExpression()
   * @generated
   */
  EAttribute getUnindexedReferenceExpression_Fresh();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference <em>Unindexed Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unindexed Reference</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference
   * @generated
   */
  EClass getUnindexedReference();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference#getSegments <em>Segments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Segments</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference#getSegments()
   * @see #getUnindexedReference()
   * @generated
   */
  EReference getUnindexedReference_Segments();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference#getTails <em>Tails</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tails</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference#getTails()
   * @see #getUnindexedReference()
   * @generated
   */
  EReference getUnindexedReference_Tails();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail <em>Unindexed Reference Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unindexed Reference Tail</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail
   * @generated
   */
  EClass getUnindexedReferenceTail();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail#getSeparator <em>Separator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Separator</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail#getSeparator()
   * @see #getUnindexedReferenceTail()
   * @generated
   */
  EAttribute getUnindexedReferenceTail_Separator();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail#getSegment <em>Segment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Segment</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail#getSegment()
   * @see #getUnindexedReferenceTail()
   * @generated
   */
  EReference getUnindexedReferenceTail_Segment();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment <em>Unindexed Reference Segment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unindexed Reference Segment</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment
   * @generated
   */
  EClass getUnindexedReferenceSegment();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment#getName()
   * @see #getUnindexedReferenceSegment()
   * @generated
   */
  EAttribute getUnindexedReferenceSegment_Name();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.Reference#getSegments <em>Segments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Segments</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.Reference#getSegments()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Segments();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.Reference#getTails <em>Tails</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tails</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.Reference#getTails()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Tails();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail <em>Reference Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Tail</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail
   * @generated
   */
  EClass getReferenceTail();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail#getSeparator <em>Separator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Separator</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail#getSeparator()
   * @see #getReferenceTail()
   * @generated
   */
  EAttribute getReferenceTail_Separator();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail#getSegment <em>Segment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Segment</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail#getSegment()
   * @see #getReferenceTail()
   * @generated
   */
  EReference getReferenceTail_Segment();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment <em>Reference Segment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Segment</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment
   * @generated
   */
  EClass getReferenceSegment();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment#getName()
   * @see #getReferenceSegment()
   * @generated
   */
  EAttribute getReferenceSegment_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment#getIndexes <em>Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Indexes</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment#getIndexes()
   * @see #getReferenceSegment()
   * @generated
   */
  EReference getReferenceSegment_Indexes();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex <em>Array Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Index</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex
   * @generated
   */
  EClass getArrayIndex();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex#getValue()
   * @see #getArrayIndex()
   * @generated
   */
  EReference getArrayIndex_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence <em>Behavior Action Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action Sequence</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence
   * @generated
   */
  EClass getBehaviorActionSequence();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence#getActions()
   * @see #getBehaviorActionSequence()
   * @generated
   */
  EReference getBehaviorActionSequence_Actions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet <em>Behavior Action Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action Set</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet
   * @generated
   */
  EClass getBehaviorActionSet();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet#getActions()
   * @see #getBehaviorActionSet()
   * @generated
   */
  EReference getBehaviorActionSet_Actions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression <em>Binary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Expression</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression
   * @generated
   */
  EClass getBinaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression#getLeft()
   * @see #getBinaryExpression()
   * @generated
   */
  EReference getBinaryExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression#getOperator()
   * @see #getBinaryExpression()
   * @generated
   */
  EAttribute getBinaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression#getRight()
   * @see #getBinaryExpression()
   * @generated
   */
  EReference getBinaryExpression_Right();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression#getOperator()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression#getOperand()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Operand();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BehaviorAnnexFactory getBehaviorAnnexFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexImpl <em>Behavior Annex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorAnnex()
     * @generated
     */
    EClass BEHAVIOR_ANNEX = eINSTANCE.getBehaviorAnnex();

    /**
     * The meta object literal for the '<em><b>Variable Groups</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ANNEX__VARIABLE_GROUPS = eINSTANCE.getBehaviorAnnex_VariableGroups();

    /**
     * The meta object literal for the '<em><b>State Groups</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ANNEX__STATE_GROUPS = eINSTANCE.getBehaviorAnnex_StateGroups();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ANNEX__TRANSITIONS = eINSTANCE.getBehaviorAnnex_Transitions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl <em>Behavior Variable Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableGroupImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorVariableGroup()
     * @generated
     */
    EClass BEHAVIOR_VARIABLE_GROUP = eINSTANCE.getBehaviorVariableGroup();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_VARIABLE_GROUP__VARIABLES = eINSTANCE.getBehaviorVariableGroup_Variables();

    /**
     * The meta object literal for the '<em><b>Data Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_VARIABLE_GROUP__DATA_CLASSIFIER = eINSTANCE.getBehaviorVariableGroup_DataClassifier();

    /**
     * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_VARIABLE_GROUP__INITIAL_VALUE = eINSTANCE.getBehaviorVariableGroup_InitialValue();

    /**
     * The meta object literal for the '<em><b>Property Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_VARIABLE_GROUP__PROPERTY_ASSOCIATIONS = eINSTANCE.getBehaviorVariableGroup_PropertyAssociations();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableImpl <em>Behavior Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorVariableImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorVariable()
     * @generated
     */
    EClass BEHAVIOR_VARIABLE = eINSTANCE.getBehaviorVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_VARIABLE__NAME = eINSTANCE.getBehaviorVariable_Name();

    /**
     * The meta object literal for the '<em><b>Array Dimensions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_VARIABLE__ARRAY_DIMENSIONS = eINSTANCE.getBehaviorVariable_ArrayDimensions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayDimensionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getArrayDimension()
     * @generated
     */
    EClass ARRAY_DIMENSION = eINSTANCE.getArrayDimension();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_DIMENSION__SIZE = eINSTANCE.getArrayDimension_Size();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorPropertyAssociationImpl <em>Behavior Property Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorPropertyAssociationImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorPropertyAssociation()
     * @generated
     */
    EClass BEHAVIOR_PROPERTY_ASSOCIATION = eINSTANCE.getBehaviorPropertyAssociation();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_PROPERTY_ASSOCIATION__PROPERTY = eINSTANCE.getBehaviorPropertyAssociation_Property();

    /**
     * The meta object literal for the '<em><b>Owned Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_PROPERTY_ASSOCIATION__OWNED_VALUE = eINSTANCE.getBehaviorPropertyAssociation_OwnedValue();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl <em>Behavior State Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateGroupImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorStateGroup()
     * @generated
     */
    EClass BEHAVIOR_STATE_GROUP = eINSTANCE.getBehaviorStateGroup();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_STATE_GROUP__STATES = eINSTANCE.getBehaviorStateGroup_States();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STATE_GROUP__INITIAL = eINSTANCE.getBehaviorStateGroup_Initial();

    /**
     * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STATE_GROUP__COMPLETE = eINSTANCE.getBehaviorStateGroup_Complete();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STATE_GROUP__FINAL = eINSTANCE.getBehaviorStateGroup_Final();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStateImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorState()
     * @generated
     */
    EClass BEHAVIOR_STATE = eINSTANCE.getBehaviorState();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STATE__NAME = eINSTANCE.getBehaviorState_Name();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTransitionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorTransition()
     * @generated
     */
    EClass BEHAVIOR_TRANSITION = eINSTANCE.getBehaviorTransition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_TRANSITION__NAME = eINSTANCE.getBehaviorTransition_Name();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_TRANSITION__PRIORITY = eINSTANCE.getBehaviorTransition_Priority();

    /**
     * The meta object literal for the '<em><b>Source States</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TRANSITION__SOURCE_STATES = eINSTANCE.getBehaviorTransition_SourceStates();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TRANSITION__CONDITION = eINSTANCE.getBehaviorTransition_Condition();

    /**
     * The meta object literal for the '<em><b>Destination State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TRANSITION__DESTINATION_STATE = eINSTANCE.getBehaviorTransition_DestinationState();

    /**
     * The meta object literal for the '<em><b>Action Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TRANSITION__ACTION_BLOCK = eINSTANCE.getBehaviorTransition_ActionBlock();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorConditionImpl <em>Behavior Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorConditionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorCondition()
     * @generated
     */
    EClass BEHAVIOR_CONDITION = eINSTANCE.getBehaviorCondition();

    /**
     * The meta object literal for the '<em><b>Dispatch</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_CONDITION__DISPATCH = eINSTANCE.getBehaviorCondition_Dispatch();

    /**
     * The meta object literal for the '<em><b>Mode Switch</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_CONDITION__MODE_SWITCH = eINSTANCE.getBehaviorCondition_ModeSwitch();

    /**
     * The meta object literal for the '<em><b>Execute</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_CONDITION__EXECUTE = eINSTANCE.getBehaviorCondition_Execute();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ExecuteConditionImpl <em>Execute Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ExecuteConditionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getExecuteCondition()
     * @generated
     */
    EClass EXECUTE_CONDITION = eINSTANCE.getExecuteCondition();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTE_CONDITION__VALUE = eINSTANCE.getExecuteCondition_Value();

    /**
     * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXECUTE_CONDITION__TIMEOUT = eINSTANCE.getExecuteCondition_Timeout();

    /**
     * The meta object literal for the '<em><b>Otherwise</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXECUTE_CONDITION__OTHERWISE = eINSTANCE.getExecuteCondition_Otherwise();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConditionImpl <em>Dispatch Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConditionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchCondition()
     * @generated
     */
    EClass DISPATCH_CONDITION = eINSTANCE.getDispatchCondition();

    /**
     * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_CONDITION__TRIGGER = eINSTANCE.getDispatchCondition_Trigger();

    /**
     * The meta object literal for the '<em><b>Frozen Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_CONDITION__FROZEN_PORTS = eINSTANCE.getDispatchCondition_FrozenPorts();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl <em>Dispatch Trigger Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerConditionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchTriggerCondition()
     * @generated
     */
    EClass DISPATCH_TRIGGER_CONDITION = eINSTANCE.getDispatchTriggerCondition();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_TRIGGER_CONDITION__EXPRESSION = eINSTANCE.getDispatchTriggerCondition_Expression();

    /**
     * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DISPATCH_TRIGGER_CONDITION__TIMEOUT = eINSTANCE.getDispatchTriggerCondition_Timeout();

    /**
     * The meta object literal for the '<em><b>Time</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_TRIGGER_CONDITION__TIME = eINSTANCE.getDispatchTriggerCondition_Time();

    /**
     * The meta object literal for the '<em><b>Stop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DISPATCH_TRIGGER_CONDITION__STOP = eINSTANCE.getDispatchTriggerCondition_Stop();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerLogicalExpressionImpl <em>Dispatch Trigger Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchTriggerLogicalExpressionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchTriggerLogicalExpression()
     * @generated
     */
    EClass DISPATCH_TRIGGER_LOGICAL_EXPRESSION = eINSTANCE.getDispatchTriggerLogicalExpression();

    /**
     * The meta object literal for the '<em><b>Conjunctions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_TRIGGER_LOGICAL_EXPRESSION__CONJUNCTIONS = eINSTANCE.getDispatchTriggerLogicalExpression_Conjunctions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConjunctionImpl <em>Dispatch Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DispatchConjunctionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDispatchConjunction()
     * @generated
     */
    EClass DISPATCH_CONJUNCTION = eINSTANCE.getDispatchConjunction();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_CONJUNCTION__TRIGGERS = eINSTANCE.getDispatchConjunction_Triggers();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConditionImpl <em>Mode Switch Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConditionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getModeSwitchCondition()
     * @generated
     */
    EClass MODE_SWITCH_CONDITION = eINSTANCE.getModeSwitchCondition();

    /**
     * The meta object literal for the '<em><b>Conjunctions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODE_SWITCH_CONDITION__CONJUNCTIONS = eINSTANCE.getModeSwitchCondition_Conjunctions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConjunctionImpl <em>Mode Switch Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ModeSwitchConjunctionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getModeSwitchConjunction()
     * @generated
     */
    EClass MODE_SWITCH_CONJUNCTION = eINSTANCE.getModeSwitchConjunction();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODE_SWITCH_CONJUNCTION__TRIGGERS = eINSTANCE.getModeSwitchConjunction_Triggers();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionBlockImpl <em>Behavior Action Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionBlockImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActionBlock()
     * @generated
     */
    EClass BEHAVIOR_ACTION_BLOCK = eINSTANCE.getBehaviorActionBlock();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ACTION_BLOCK__CONTENT = eINSTANCE.getBehaviorActionBlock_Content();

    /**
     * The meta object literal for the '<em><b>Timeout</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ACTION_BLOCK__TIMEOUT = eINSTANCE.getBehaviorActionBlock_Timeout();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionsImpl <em>Behavior Actions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionsImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActions()
     * @generated
     */
    EClass BEHAVIOR_ACTIONS = eINSTANCE.getBehaviorActions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionImpl <em>Behavior Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorAction()
     * @generated
     */
    EClass BEHAVIOR_ACTION = eINSTANCE.getBehaviorAction();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.AssignmentActionImpl <em>Assignment Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.AssignmentActionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getAssignmentAction()
     * @generated
     */
    EClass ASSIGNMENT_ACTION = eINSTANCE.getAssignmentAction();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_ACTION__TARGET = eINSTANCE.getAssignmentAction_Target();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_ACTION__VALUE = eINSTANCE.getAssignmentAction_Value();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_ACTION__ANY = eINSTANCE.getAssignmentAction_Any();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl <em>Communication Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getCommunicationAction()
     * @generated
     */
    EClass COMMUNICATION_ACTION = eINSTANCE.getCommunicationAction();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMUNICATION_ACTION__REFERENCE = eINSTANCE.getCommunicationAction_Reference();

    /**
     * The meta object literal for the '<em><b>Send</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__SEND = eINSTANCE.getCommunicationAction_Send();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMUNICATION_ACTION__PARAMETERS = eINSTANCE.getCommunicationAction_Parameters();

    /**
     * The meta object literal for the '<em><b>Dequeue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__DEQUEUE = eINSTANCE.getCommunicationAction_Dequeue();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMUNICATION_ACTION__TARGET = eINSTANCE.getCommunicationAction_Target();

    /**
     * The meta object literal for the '<em><b>Freeze</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__FREEZE = eINSTANCE.getCommunicationAction_Freeze();

    /**
     * The meta object literal for the '<em><b>Lock</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__LOCK = eINSTANCE.getCommunicationAction_Lock();

    /**
     * The meta object literal for the '<em><b>Unlock</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__UNLOCK = eINSTANCE.getCommunicationAction_Unlock();

    /**
     * The meta object literal for the '<em><b>All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__ALL = eINSTANCE.getCommunicationAction_All();

    /**
     * The meta object literal for the '<em><b>All Lock</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__ALL_LOCK = eINSTANCE.getCommunicationAction_AllLock();

    /**
     * The meta object literal for the '<em><b>All Unlock</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMUNICATION_ACTION__ALL_UNLOCK = eINSTANCE.getCommunicationAction_AllUnlock();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.TimedActionImpl <em>Timed Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.TimedActionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getTimedAction()
     * @generated
     */
    EClass TIMED_ACTION = eINSTANCE.getTimedAction();

    /**
     * The meta object literal for the '<em><b>Lower Time</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMED_ACTION__LOWER_TIME = eINSTANCE.getTimedAction_LowerTime();

    /**
     * The meta object literal for the '<em><b>Upper Time</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMED_ACTION__UPPER_TIME = eINSTANCE.getTimedAction_UpperTime();

    /**
     * The meta object literal for the '<em><b>Processors</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMED_ACTION__PROCESSORS = eINSTANCE.getTimedAction_Processors();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IfStatementImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getIfStatement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

    /**
     * The meta object literal for the '<em><b>Then Actions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__THEN_ACTIONS = eINSTANCE.getIfStatement_ThenActions();

    /**
     * The meta object literal for the '<em><b>Else Ifs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE_IFS = eINSTANCE.getIfStatement_ElseIfs();

    /**
     * The meta object literal for the '<em><b>Else Actions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE_ACTIONS = eINSTANCE.getIfStatement_ElseActions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElseIfClauseImpl <em>Else If Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElseIfClauseImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getElseIfClause()
     * @generated
     */
    EClass ELSE_IF_CLAUSE = eINSTANCE.getElseIfClause();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_IF_CLAUSE__CONDITION = eINSTANCE.getElseIfClause_Condition();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELSE_IF_CLAUSE__ACTIONS = eINSTANCE.getElseIfClause_Actions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl <em>For Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ForStatementImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getForStatement()
     * @generated
     */
    EClass FOR_STATEMENT = eINSTANCE.getForStatement();

    /**
     * The meta object literal for the '<em><b>For</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR_STATEMENT__FOR = eINSTANCE.getForStatement_For();

    /**
     * The meta object literal for the '<em><b>Forall</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR_STATEMENT__FORALL = eINSTANCE.getForStatement_Forall();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR_STATEMENT__VARIABLE = eINSTANCE.getForStatement_Variable();

    /**
     * The meta object literal for the '<em><b>Data Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__DATA_CLASSIFIER = eINSTANCE.getForStatement_DataClassifier();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__VALUES = eINSTANCE.getForStatement_Values();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_STATEMENT__ACTIONS = eINSTANCE.getForStatement_Actions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.WhileStatementImpl <em>While Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.WhileStatementImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getWhileStatement()
     * @generated
     */
    EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__ACTIONS = eINSTANCE.getWhileStatement_Actions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DoUntilStatementImpl <em>Do Until Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.DoUntilStatementImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getDoUntilStatement()
     * @generated
     */
    EClass DO_UNTIL_STATEMENT = eINSTANCE.getDoUntilStatement();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_UNTIL_STATEMENT__ACTIONS = eINSTANCE.getDoUntilStatement_Actions();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_UNTIL_STATEMENT__CONDITION = eINSTANCE.getDoUntilStatement_Condition();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElementValuesImpl <em>Element Values</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ElementValuesImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getElementValues()
     * @generated
     */
    EClass ELEMENT_VALUES = eINSTANCE.getElementValues();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_VALUES__LOWER = eINSTANCE.getElementValues_Lower();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_VALUES__UPPER = eINSTANCE.getElementValues_Upper();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTimeImpl <em>Behavior Time</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorTimeImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorTime()
     * @generated
     */
    EClass BEHAVIOR_TIME = eINSTANCE.getBehaviorTime();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TIME__VALUE = eINSTANCE.getBehaviorTime_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TIME__UNIT = eINSTANCE.getBehaviorTime_Unit();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IntegerValueImpl <em>Integer Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.IntegerValueImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getIntegerValue()
     * @generated
     */
    EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueExpressionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getValueExpression()
     * @generated
     */
    EClass VALUE_EXPRESSION = eINSTANCE.getValueExpression();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueConstantImpl <em>Value Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ValueConstantImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getValueConstant()
     * @generated
     */
    EClass VALUE_CONSTANT = eINSTANCE.getValueConstant();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorIntegerLiteralImpl <em>Behavior Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorIntegerLiteralImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorIntegerLiteral()
     * @generated
     */
    EClass BEHAVIOR_INTEGER_LITERAL = eINSTANCE.getBehaviorIntegerLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_INTEGER_LITERAL__VALUE = eINSTANCE.getBehaviorIntegerLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorRealLiteralImpl <em>Behavior Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorRealLiteralImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorRealLiteral()
     * @generated
     */
    EClass BEHAVIOR_REAL_LITERAL = eINSTANCE.getBehaviorRealLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_REAL_LITERAL__VALUE = eINSTANCE.getBehaviorRealLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStringLiteralImpl <em>Behavior String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorStringLiteralImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorStringLiteral()
     * @generated
     */
    EClass BEHAVIOR_STRING_LITERAL = eINSTANCE.getBehaviorStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STRING_LITERAL__VALUE = eINSTANCE.getBehaviorStringLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorBooleanLiteralImpl <em>Behavior Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorBooleanLiteralImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorBooleanLiteral()
     * @generated
     */
    EClass BEHAVIOR_BOOLEAN_LITERAL = eINSTANCE.getBehaviorBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_BOOLEAN_LITERAL__VALUE = eINSTANCE.getBehaviorBooleanLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl <em>Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceExpressionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReferenceExpression()
     * @generated
     */
    EClass REFERENCE_EXPRESSION = eINSTANCE.getReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_EXPRESSION__REFERENCE = eINSTANCE.getReferenceExpression_Reference();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_EXPRESSION__PROPERTY = eINSTANCE.getReferenceExpression_Property();

    /**
     * The meta object literal for the '<em><b>Dequeue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_EXPRESSION__DEQUEUE = eINSTANCE.getReferenceExpression_Dequeue();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_EXPRESSION__COUNT = eINSTANCE.getReferenceExpression_Count();

    /**
     * The meta object literal for the '<em><b>Fresh</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_EXPRESSION__FRESH = eINSTANCE.getReferenceExpression_Fresh();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.HashPropertyReferenceImpl <em>Hash Property Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.HashPropertyReferenceImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getHashPropertyReference()
     * @generated
     */
    EClass HASH_PROPERTY_REFERENCE = eINSTANCE.getHashPropertyReference();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HASH_PROPERTY_REFERENCE__PROPERTY = eINSTANCE.getHashPropertyReference_Property();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HASH_PROPERTY_REFERENCE__INDEXES = eINSTANCE.getHashPropertyReference_Indexes();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HASH_PROPERTY_REFERENCE__FIELDS = eINSTANCE.getHashPropertyReference_Fields();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyReferenceTailImpl <em>Property Reference Tail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyReferenceTailImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyReferenceTail()
     * @generated
     */
    EClass PROPERTY_REFERENCE_TAIL = eINSTANCE.getPropertyReferenceTail();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_REFERENCE_TAIL__PROPERTY = eINSTANCE.getPropertyReferenceTail_Property();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_REFERENCE_TAIL__INDEXES = eINSTANCE.getPropertyReferenceTail_Indexes();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_REFERENCE_TAIL__FIELDS = eINSTANCE.getPropertyReferenceTail_Fields();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.NamedPropertyFieldImpl <em>Named Property Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.NamedPropertyFieldImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getNamedPropertyField()
     * @generated
     */
    EClass NAMED_PROPERTY_FIELD = eINSTANCE.getNamedPropertyField();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_PROPERTY_FIELD__NAME = eINSTANCE.getNamedPropertyField_Name();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_PROPERTY_FIELD__INDEXES = eINSTANCE.getNamedPropertyField_Indexes();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyArrayIndexImpl <em>Property Array Index</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyArrayIndexImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyArrayIndex()
     * @generated
     */
    EClass PROPERTY_ARRAY_INDEX = eINSTANCE.getPropertyArrayIndex();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_ARRAY_INDEX__VALUE = eINSTANCE.getPropertyArrayIndex_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexValueImpl <em>Property Index Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexValueImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyIndexValue()
     * @generated
     */
    EClass PROPERTY_INDEX_VALUE = eINSTANCE.getPropertyIndexValue();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexPropertyReferenceImpl <em>Property Index Property Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.PropertyIndexPropertyReferenceImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getPropertyIndexPropertyReference()
     * @generated
     */
    EClass PROPERTY_INDEX_PROPERTY_REFERENCE = eINSTANCE.getPropertyIndexPropertyReference();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_INDEX_PROPERTY_REFERENCE__PROPERTY = eINSTANCE.getPropertyIndexPropertyReference_Property();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl <em>Unindexed Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReferenceExpression()
     * @generated
     */
    EClass UNINDEXED_REFERENCE_EXPRESSION = eINSTANCE.getUnindexedReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNINDEXED_REFERENCE_EXPRESSION__REFERENCE = eINSTANCE.getUnindexedReferenceExpression_Reference();

    /**
     * The meta object literal for the '<em><b>Dequeue</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE = eINSTANCE.getUnindexedReferenceExpression_Dequeue();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNINDEXED_REFERENCE_EXPRESSION__COUNT = eINSTANCE.getUnindexedReferenceExpression_Count();

    /**
     * The meta object literal for the '<em><b>Fresh</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNINDEXED_REFERENCE_EXPRESSION__FRESH = eINSTANCE.getUnindexedReferenceExpression_Fresh();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceImpl <em>Unindexed Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReference()
     * @generated
     */
    EClass UNINDEXED_REFERENCE = eINSTANCE.getUnindexedReference();

    /**
     * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNINDEXED_REFERENCE__SEGMENTS = eINSTANCE.getUnindexedReference_Segments();

    /**
     * The meta object literal for the '<em><b>Tails</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNINDEXED_REFERENCE__TAILS = eINSTANCE.getUnindexedReference_Tails();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceTailImpl <em>Unindexed Reference Tail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceTailImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReferenceTail()
     * @generated
     */
    EClass UNINDEXED_REFERENCE_TAIL = eINSTANCE.getUnindexedReferenceTail();

    /**
     * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNINDEXED_REFERENCE_TAIL__SEPARATOR = eINSTANCE.getUnindexedReferenceTail_Separator();

    /**
     * The meta object literal for the '<em><b>Segment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNINDEXED_REFERENCE_TAIL__SEGMENT = eINSTANCE.getUnindexedReferenceTail_Segment();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceSegmentImpl <em>Unindexed Reference Segment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceSegmentImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnindexedReferenceSegment()
     * @generated
     */
    EClass UNINDEXED_REFERENCE_SEGMENT = eINSTANCE.getUnindexedReferenceSegment();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNINDEXED_REFERENCE_SEGMENT__NAME = eINSTANCE.getUnindexedReferenceSegment_Name();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__SEGMENTS = eINSTANCE.getReference_Segments();

    /**
     * The meta object literal for the '<em><b>Tails</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__TAILS = eINSTANCE.getReference_Tails();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceTailImpl <em>Reference Tail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceTailImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReferenceTail()
     * @generated
     */
    EClass REFERENCE_TAIL = eINSTANCE.getReferenceTail();

    /**
     * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_TAIL__SEPARATOR = eINSTANCE.getReferenceTail_Separator();

    /**
     * The meta object literal for the '<em><b>Segment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_TAIL__SEGMENT = eINSTANCE.getReferenceTail_Segment();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceSegmentImpl <em>Reference Segment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ReferenceSegmentImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getReferenceSegment()
     * @generated
     */
    EClass REFERENCE_SEGMENT = eINSTANCE.getReferenceSegment();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_SEGMENT__NAME = eINSTANCE.getReferenceSegment_Name();

    /**
     * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_SEGMENT__INDEXES = eINSTANCE.getReferenceSegment_Indexes();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayIndexImpl <em>Array Index</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.ArrayIndexImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getArrayIndex()
     * @generated
     */
    EClass ARRAY_INDEX = eINSTANCE.getArrayIndex();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_INDEX__VALUE = eINSTANCE.getArrayIndex_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSequenceImpl <em>Behavior Action Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSequenceImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActionSequence()
     * @generated
     */
    EClass BEHAVIOR_ACTION_SEQUENCE = eINSTANCE.getBehaviorActionSequence();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ACTION_SEQUENCE__ACTIONS = eINSTANCE.getBehaviorActionSequence_Actions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSetImpl <em>Behavior Action Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorActionSetImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBehaviorActionSet()
     * @generated
     */
    EClass BEHAVIOR_ACTION_SET = eINSTANCE.getBehaviorActionSet();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ACTION_SET__ACTIONS = eINSTANCE.getBehaviorActionSet_Actions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BinaryExpressionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getBinaryExpression()
     * @generated
     */
    EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPRESSION__LEFT = eINSTANCE.getBinaryExpression_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_EXPRESSION__OPERATOR = eINSTANCE.getBinaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPRESSION__RIGHT = eINSTANCE.getBinaryExpression_Right();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnaryExpressionImpl
     * @see org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__OPERATOR = eINSTANCE.getUnaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__OPERAND = eINSTANCE.getUnaryExpression_Operand();

  }

} //BehaviorAnnexPackage
