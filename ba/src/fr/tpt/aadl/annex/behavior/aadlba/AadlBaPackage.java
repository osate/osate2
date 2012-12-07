/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory
 * @model kind="package"
 * @generated
 */
public interface AadlBaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "aadlba";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "https://eve.enst.fr/svn/aadl-eclipse-dev/aadlba/trunk/fr.tpt.aadl.annex.behavior/aadlba";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "aadlba";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AadlBaPackage eINSTANCE = fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorElementImpl <em>Behavior Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorElementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorElement()
   * @generated
   */
  int BEHAVIOR_ELEMENT = 13;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ELEMENT__OWNED_ELEMENT = Aadl2Package.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ELEMENT__OWNED_COMMENT = Aadl2Package.ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Behavior Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ELEMENT_FEATURE_COUNT = Aadl2Package.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActions()
   * @generated
   */
  int BEHAVIOR_ACTIONS = 7;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAction()
   * @generated
   */
  int BEHAVIOR_ACTION = 4;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBasicAction()
   * @generated
   */
  int BASIC_ACTION = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl <em>Assignment Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getAssignmentAction()
   * @generated
   */
  int ASSIGNMENT_ACTION = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl <em>Behavior Action Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionBlock()
   * @generated
   */
  int BEHAVIOR_ACTION_BLOCK = 5;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionCollection()
   * @generated
   */
  int BEHAVIOR_ACTION_COLLECTION = 6;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl <em>Behavior Action Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSequence()
   * @generated
   */
  int BEHAVIOR_ACTION_SEQUENCE = 8;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl <em>Behavior Action Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSet()
   * @generated
   */
  int BEHAVIOR_ACTION_SET = 9;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl <em>Behavior Annex</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAnnex()
   * @generated
   */
  int BEHAVIOR_ANNEX = 10;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorBooleanLiteralImpl <em>Behavior Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorBooleanLiteralImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorBooleanLiteral()
   * @generated
   */
  int BEHAVIOR_BOOLEAN_LITERAL = 11;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorCondition()
   * @generated
   */
  int BEHAVIOR_CONDITION = 12;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.Value
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValue()
   * @generated
   */
  int VALUE = 94;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueConstant()
   * @generated
   */
  int VALUE_CONSTANT = 95;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Literal <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.Literal
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 65;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorEnumerationLiteralImpl <em>Behavior Enumeration Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorEnumerationLiteralImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorEnumerationLiteral()
   * @generated
   */
  int BEHAVIOR_ENUMERATION_LITERAL = 14;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl <em>Behavior Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorIntegerLiteral()
   * @generated
   */
  int BEHAVIOR_INTEGER_LITERAL = 15;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl <em>Behavior Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorNamedElement()
   * @generated
   */
  int BEHAVIOR_NAMED_ELEMENT = 16;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyImpl <em>Behavior Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorProperty()
   * @generated
   */
  int BEHAVIOR_PROPERTY = 17;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyConstantImpl <em>Behavior Property Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyConstantImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorPropertyConstant()
   * @generated
   */
  int BEHAVIOR_PROPERTY_CONSTANT = 18;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyValueImpl <em>Behavior Property Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyValueImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorPropertyValue()
   * @generated
   */
  int BEHAVIOR_PROPERTY_VALUE = 19;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorRealLiteralImpl <em>Behavior Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorRealLiteralImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorRealLiteral()
   * @generated
   */
  int BEHAVIOR_REAL_LITERAL = 20;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorState()
   * @generated
   */
  int BEHAVIOR_STATE = 21;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStringLiteralImpl <em>Behavior String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStringLiteralImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorStringLiteral()
   * @generated
   */
  int BEHAVIOR_STRING_LITERAL = 22;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl <em>Behavior Time</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTime()
   * @generated
   */
  int BEHAVIOR_TIME = 23;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTransition()
   * @generated
   */
  int BEHAVIOR_TRANSITION = 24;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl <em>Behavior Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorVariable()
   * @generated
   */
  int BEHAVIOR_VARIABLE = 25;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommunicationAction()
   * @generated
   */
  int COMMUNICATION_ACTION = 28;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutImpl <em>Completion Relative Timeout</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCompletionRelativeTimeout()
   * @generated
   */
  int COMPLETION_RELATIVE_TIMEOUT = 29;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCondStatement()
   * @generated
   */
  int COND_STATEMENT = 30;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementValues()
   * @generated
   */
  int ELEMENT_VALUES = 45;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl <em>Data Component Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataComponentReference()
   * @generated
   */
  int DATA_COMPONENT_REFERENCE = 33;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl <em>Dispatch Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchCondition()
   * @generated
   */
  int DISPATCH_CONDITION = 37;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl <em>Dispatch Conjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchConjunction()
   * @generated
   */
  int DISPATCH_CONJUNCTION = 38;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerCondition()
   * @generated
   */
  int DISPATCH_TRIGGER_CONDITION = 41;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl <em>Dispatch Trigger Condition Stop</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerConditionStop()
   * @generated
   */
  int DISPATCH_TRIGGER_CONDITION_STOP = 42;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl <em>Dispatch Trigger Logical Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerLogicalExpression()
   * @generated
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION = 43;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElseStatementImpl <em>Else Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ElseStatementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElseStatement()
   * @generated
   */
  int ELSE_STATEMENT = 46;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecuteCondition()
   * @generated
   */
  int EXECUTE_CONDITION = 49;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl <em>Factor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFactor()
   * @generated
   */
  int FACTOR = 51;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl <em>Loop Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLoopStatement()
   * @generated
   */
  int LOOP_STATEMENT = 67;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl <em>For Or For All Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getForOrForAllStatement()
   * @generated
   */
  int FOR_OR_FOR_ALL_STATEMENT = 53;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 57;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl <em>Integer Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerRange()
   * @generated
   */
  int INTEGER_RANGE = 59;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValue()
   * @generated
   */
  int INTEGER_VALUE = 60;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueConstant()
   * @generated
   */
  int INTEGER_VALUE_CONSTANT = 61;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueVariable()
   * @generated
   */
  int INTEGER_VALUE_VARIABLE = 62;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl <em>Shared Data Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSharedDataAction()
   * @generated
   */
  int SHARED_DATA_ACTION = 82;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl <em>Lock Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLockAction()
   * @generated
   */
  int LOCK_ACTION = 66;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral <em>Numeric Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumericLiteral()
   * @generated
   */
  int NUMERIC_LITERAL = 68;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl <em>Otherwise</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getOtherwise()
   * @generated
   */
  int OTHERWISE = 69;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterLabel()
   * @generated
   */
  int PARAMETER_LABEL = 71;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IndexableElement <em>Indexable Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.IndexableElement
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIndexableElement()
   * @generated
   */
  int INDEXABLE_ELEMENT = 58;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEXABLE_ELEMENT__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEXABLE_ELEMENT__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEXABLE_ELEMENT__ARRAY_INDEXES = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Indexable Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEXABLE_ELEMENT_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementHolder <em>Element Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElementHolder
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementHolder()
   * @generated
   */
  int ELEMENT_HOLDER = 44;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortHolderImpl <em>Port Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortHolder()
   * @generated
   */
  int PORT_HOLDER = 77;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_HOLDER__OWNED_ELEMENT = INDEXABLE_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_HOLDER__OWNED_COMMENT = INDEXABLE_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_HOLDER__ARRAY_INDEXES = INDEXABLE_ELEMENT__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_HOLDER__ELEMENT = INDEXABLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_HOLDER__GROUP_HOLDERS = INDEXABLE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Port Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_HOLDER_FEATURE_COUNT = INDEXABLE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ActualPortHolderImpl <em>Actual Port Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ActualPortHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getActualPortHolder()
   * @generated
   */
  int ACTUAL_PORT_HOLDER = 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PORT_HOLDER__OWNED_ELEMENT = PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PORT_HOLDER__OWNED_COMMENT = PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PORT_HOLDER__ARRAY_INDEXES = PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PORT_HOLDER__ELEMENT = PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PORT_HOLDER__GROUP_HOLDERS = PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Actual Port Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_PORT_HOLDER_FEATURE_COUNT = PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTIONS__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTIONS__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Behavior Actions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTIONS_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION__OWNED_ELEMENT = BEHAVIOR_ACTIONS__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION__OWNED_COMMENT = BEHAVIOR_ACTIONS__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Behavior Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_FEATURE_COUNT = BEHAVIOR_ACTIONS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_ACTION__OWNED_ELEMENT = BEHAVIOR_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_ACTION__OWNED_COMMENT = BEHAVIOR_ACTION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Basic Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_ACTION_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION__OWNED_ELEMENT = BASIC_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION__OWNED_COMMENT = BASIC_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION__TARGET = BASIC_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION__VALUE_EXPRESSION = BASIC_ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assignment Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl <em>Port Count Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortCountValue()
   * @generated
   */
  int PORT_COUNT_VALUE = 72;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl <em>Port Dequeue Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueAction()
   * @generated
   */
  int PORT_DEQUEUE_ACTION = 73;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl <em>Port Dequeue Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueValue()
   * @generated
   */
  int PORT_DEQUEUE_VALUE = 74;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl <em>Port Freeze Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreezeAction()
   * @generated
   */
  int PORT_FREEZE_ACTION = 75;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl <em>Port Fresh Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreshValue()
   * @generated
   */
  int PORT_FRESH_VALUE = 76;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl <em>Port Send Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortSendAction()
   * @generated
   */
  int PORT_SEND_ACTION = 79;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl <em>Relation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelation()
   * @generated
   */
  int RELATION = 81;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl <em>Simple Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSimpleExpression()
   * @generated
   */
  int SIMPLE_EXPRESSION = 83;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl <em>Subprogram Call Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramCallAction()
   * @generated
   */
  int SUBPROGRAM_CALL_ACTION = 87;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl <em>Target</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTarget()
   * @generated
   */
  int TARGET = 90;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTerm()
   * @generated
   */
  int TERM = 91;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl <em>Timed Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTimedAction()
   * @generated
   */
  int TIMED_ACTION = 92;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl <em>Unlock Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnlockAction()
   * @generated
   */
  int UNLOCK_ACTION = 93;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueExpression()
   * @generated
   */
  int VALUE_EXPRESSION = 96;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXPRESSION__OWNED_ELEMENT = VALUE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXPRESSION__OWNED_COMMENT = VALUE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXPRESSION__RELATIONS = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Logical Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXPRESSION__LOGICAL_OPERATORS = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Value Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_EXPRESSION_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueVariable()
   * @generated
   */
  int VALUE_VARIABLE = 97;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl <em>While Or Do Until Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getWhileOrDoUntilStatement()
   * @generated
   */
  int WHILE_OR_DO_UNTIL_STATEMENT = 98;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ExecutionTimeoutCatchImpl <em>Execution Timeout Catch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ExecutionTimeoutCatchImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecutionTimeoutCatch()
   * @generated
   */
  int EXECUTION_TIMEOUT_CATCH = 50;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchRelativeTimeoutImpl <em>Dispatch Relative Timeout</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchRelativeTimeoutImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchRelativeTimeout()
   * @generated
   */
  int DISPATCH_RELATIVE_TIMEOUT = 39;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataHolderImpl <em>Data Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataHolder()
   * @generated
   */
  int DATA_HOLDER = 34;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CalledSubprogramHolderImpl <em>Called Subprogram Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CalledSubprogramHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCalledSubprogramHolder()
   * @generated
   */
  int CALLED_SUBPROGRAM_HOLDER = 27;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramHolderImpl <em>Subprogram Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramHolder()
   * @generated
   */
  int SUBPROGRAM_HOLDER = 88;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableImpl <em>Iterative Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIterativeVariable()
   * @generated
   */
  int ITERATIVE_VARIABLE = 63;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessHolderImpl <em>Data Access Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataAccessHolder()
   * @generated
   */
  int DATA_ACCESS_HOLDER = 31;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataSubcomponentHolderImpl <em>Data Subcomponent Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataSubcomponentHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataSubcomponentHolder()
   * @generated
   */
  int DATA_SUBCOMPONENT_HOLDER = 36;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableHolderImpl <em>Behavior Variable Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorVariableHolder()
   * @generated
   */
  int BEHAVIOR_VARIABLE_HOLDER = 26;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataPortHolderImpl <em>Data Port Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataPortHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataPortHolder()
   * @generated
   */
  int DATA_PORT_HOLDER = 35;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.EventPortHolderImpl <em>Event Port Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.EventPortHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getEventPortHolder()
   * @generated
   */
  int EVENT_PORT_HOLDER = 48;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.EventDataPortHolderImpl <em>Event Data Port Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.EventDataPortHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getEventDataPortHolder()
   * @generated
   */
  int EVENT_DATA_PORT_HOLDER = 47;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterHolderImpl <em>Parameter Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterHolder()
   * @generated
   */
  int PARAMETER_HOLDER = 70;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramAccessHolderImpl <em>Subprogram Access Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramAccessHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramAccessHolder()
   * @generated
   */
  int SUBPROGRAM_ACCESS_HOLDER = 86;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger <em>Dispatch Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTrigger()
   * @generated
   */
  int DISPATCH_TRIGGER = 40;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AnyImpl <em>Any</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AnyImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getAny()
   * @generated
   */
  int ANY = 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY__OWNED_ELEMENT = VALUE_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY__OWNED_COMMENT = VALUE_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Relations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY__RELATIONS = VALUE_EXPRESSION__RELATIONS;

  /**
   * The feature id for the '<em><b>Logical Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY__LOGICAL_OPERATORS = VALUE_EXPRESSION__LOGICAL_OPERATORS;

  /**
   * The number of structural features of the '<em>Any</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANY_FEATURE_COUNT = VALUE_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_BLOCK__OWNED_ELEMENT = BEHAVIOR_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_BLOCK__OWNED_COMMENT = BEHAVIOR_ACTION__OWNED_COMMENT;

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
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_COLLECTION__OWNED_ELEMENT = BEHAVIOR_ACTIONS__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_COLLECTION__OWNED_COMMENT = BEHAVIOR_ACTIONS__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_COLLECTION__ACTIONS = BEHAVIOR_ACTIONS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Action Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_COLLECTION_FEATURE_COUNT = BEHAVIOR_ACTIONS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SEQUENCE__OWNED_ELEMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SEQUENCE__OWNED_COMMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SEQUENCE__ACTIONS = BEHAVIOR_ACTION_COLLECTION__ACTIONS;

  /**
   * The number of structural features of the '<em>Behavior Action Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SEQUENCE_FEATURE_COUNT = BEHAVIOR_ACTION_COLLECTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SET__OWNED_ELEMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SET__OWNED_COMMENT = BEHAVIOR_ACTION_COLLECTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SET__ACTIONS = BEHAVIOR_ACTION_COLLECTION__ACTIONS;

  /**
   * The number of structural features of the '<em>Behavior Action Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ACTION_SET_FEATURE_COUNT = BEHAVIOR_ACTION_COLLECTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
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
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__VARIABLES = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__STATES = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX__TRANSITIONS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BEHAVIOR_ANNEX__ACTIONS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 3;

		/**
   * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BEHAVIOR_ANNEX__CONDITIONS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 4;

		/**
   * The number of structural features of the '<em>Behavior Annex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ANNEX_FEATURE_COUNT = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_BOOLEAN_LITERAL__OWNED_ELEMENT = Aadl2Package.BOOLEAN_LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_BOOLEAN_LITERAL__OWNED_COMMENT = Aadl2Package.BOOLEAN_LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BEHAVIOR_BOOLEAN_LITERAL__VALUE = Aadl2Package.BOOLEAN_LITERAL__VALUE;

		/**
   * The number of structural features of the '<em>Behavior Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_BOOLEAN_LITERAL_FEATURE_COUNT = Aadl2Package.BOOLEAN_LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_CONDITION__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_CONDITION__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Behavior Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_CONDITION_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONSTANT__OWNED_ELEMENT = VALUE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONSTANT__OWNED_COMMENT = VALUE__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Value Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONSTANT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__OWNED_ELEMENT = VALUE_CONSTANT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__OWNED_COMMENT = VALUE_CONSTANT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ENUMERATION_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ENUMERATION_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ENUMERATION_LITERAL__PROPERTY = LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Enum Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL = LITERAL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Component</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ENUMERATION_LITERAL__COMPONENT = LITERAL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Behavior Enumeration Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_ENUMERATION_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_INTEGER_LITERAL__OWNED_ELEMENT = Aadl2Package.INTEGER_LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_INTEGER_LITERAL__OWNED_COMMENT = Aadl2Package.INTEGER_LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_INTEGER_LITERAL__UNIT = Aadl2Package.INTEGER_LITERAL__UNIT;

  /**
   * The feature id for the '<em><b>Base</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BEHAVIOR_INTEGER_LITERAL__BASE = Aadl2Package.INTEGER_LITERAL__BASE;

		/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BEHAVIOR_INTEGER_LITERAL__VALUE = Aadl2Package.INTEGER_LITERAL__VALUE;

		/**
   * The number of structural features of the '<em>Behavior Integer Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_INTEGER_LITERAL_FEATURE_COUNT = Aadl2Package.INTEGER_LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_NAMED_ELEMENT__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_NAMED_ELEMENT__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_NAMED_ELEMENT__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>Behavior Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY__OWNED_ELEMENT = VALUE_CONSTANT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY__OWNED_COMMENT = VALUE_CONSTANT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Property Set</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY__PROPERTY_SET = VALUE_CONSTANT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_FEATURE_COUNT = VALUE_CONSTANT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_CONSTANT__OWNED_ELEMENT = BEHAVIOR_PROPERTY__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_CONSTANT__OWNED_COMMENT = BEHAVIOR_PROPERTY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Property Set</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET = BEHAVIOR_PROPERTY__PROPERTY_SET;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_CONSTANT__PROPERTY = BEHAVIOR_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Property Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_CONSTANT_FEATURE_COUNT = BEHAVIOR_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_VALUE__OWNED_ELEMENT = BEHAVIOR_PROPERTY__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_VALUE__OWNED_COMMENT = BEHAVIOR_PROPERTY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Property Set</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_VALUE__PROPERTY_SET = BEHAVIOR_PROPERTY__PROPERTY_SET;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_VALUE__PROPERTY = BEHAVIOR_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Property Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_PROPERTY_VALUE_FEATURE_COUNT = BEHAVIOR_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_REAL_LITERAL__OWNED_ELEMENT = Aadl2Package.REAL_LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_REAL_LITERAL__OWNED_COMMENT = Aadl2Package.REAL_LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_REAL_LITERAL__UNIT = Aadl2Package.REAL_LITERAL__UNIT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BEHAVIOR_REAL_LITERAL__VALUE = Aadl2Package.REAL_LITERAL__VALUE;

		/**
   * The number of structural features of the '<em>Behavior Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_REAL_LITERAL_FEATURE_COUNT = Aadl2Package.REAL_LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__OWNED_ELEMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__OWNED_COMMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__NAME = BEHAVIOR_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__QUALIFIED_NAME = BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__OWNED_PROPERTY_ASSOCIATION = BEHAVIOR_NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__INITIAL = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Complete</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__COMPLETE = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__FINAL = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Binded Mode</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE__BINDED_MODE = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Behavior State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STATE_FEATURE_COUNT = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STRING_LITERAL__OWNED_ELEMENT = Aadl2Package.STRING_LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STRING_LITERAL__OWNED_COMMENT = Aadl2Package.STRING_LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BEHAVIOR_STRING_LITERAL__VALUE = Aadl2Package.STRING_LITERAL__VALUE;

		/**
   * The number of structural features of the '<em>Behavior String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_STRING_LITERAL_FEATURE_COUNT = Aadl2Package.STRING_LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME__INTEGER_VALUE = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME__UNIT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Behavior Time</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TIME_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__OWNED_ELEMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__OWNED_COMMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__NAME = BEHAVIOR_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__QUALIFIED_NAME = BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__OWNED_PROPERTY_ASSOCIATION = BEHAVIOR_NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Source State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__SOURCE_STATE = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__CONDITION = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Destination State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__DESTINATION_STATE = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Action Block</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__ACTION_BLOCK = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION__PRIORITY = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Behavior Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_TRANSITION_FEATURE_COUNT = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__OWNED_ELEMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__OWNED_COMMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__NAME = BEHAVIOR_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__QUALIFIED_NAME = BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATION = BEHAVIOR_NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Array Dimension</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__ARRAY_DIMENSION = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Data Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE__DATA_CLASSIFIER = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Behavior Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_FEATURE_COUNT = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_HOLDER__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_HOLDER__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_HOLDER__ELEMENT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Element Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_HOLDER_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_HOLDER__OWNED_ELEMENT = ELEMENT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_HOLDER__OWNED_COMMENT = ELEMENT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_HOLDER__ELEMENT = ELEMENT_HOLDER__ELEMENT;

  /**
   * The number of structural features of the '<em>Data Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_HOLDER_FEATURE_COUNT = ELEMENT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_HOLDER__ARRAY_INDEXES = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Behavior Variable Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEHAVIOR_VARIABLE_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLED_SUBPROGRAM_HOLDER__OWNED_ELEMENT = ELEMENT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLED_SUBPROGRAM_HOLDER__OWNED_COMMENT = ELEMENT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLED_SUBPROGRAM_HOLDER__ELEMENT = ELEMENT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLED_SUBPROGRAM_HOLDER__ARRAY_INDEXES = ELEMENT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLED_SUBPROGRAM_HOLDER__GROUP_HOLDERS = ELEMENT_HOLDER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Called Subprogram Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLED_SUBPROGRAM_HOLDER_FEATURE_COUNT = ELEMENT_HOLDER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__OWNED_ELEMENT = BASIC_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION__OWNED_COMMENT = BASIC_ACTION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Communication Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMUNICATION_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLETION_RELATIVE_TIMEOUT__OWNED_ELEMENT = BEHAVIOR_TIME__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLETION_RELATIVE_TIMEOUT__OWNED_COMMENT = BEHAVIOR_TIME__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLETION_RELATIVE_TIMEOUT__INTEGER_VALUE = BEHAVIOR_TIME__INTEGER_VALUE;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLETION_RELATIVE_TIMEOUT__UNIT = BEHAVIOR_TIME__UNIT;

  /**
   * The number of structural features of the '<em>Completion Relative Timeout</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLETION_RELATIVE_TIMEOUT_FEATURE_COUNT = BEHAVIOR_TIME_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_STATEMENT__OWNED_ELEMENT = BEHAVIOR_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_STATEMENT__OWNED_COMMENT = BEHAVIOR_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_STATEMENT__BEHAVIOR_ACTIONS = BEHAVIOR_ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Cond Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COND_STATEMENT_FEATURE_COUNT = BEHAVIOR_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_HOLDER__GROUP_HOLDERS = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_HOLDER__ARRAY_INDEXES = DATA_HOLDER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Data Access Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.GroupHolderImpl <em>Group Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.GroupHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGroupHolder()
   * @generated
   */
  int GROUP_HOLDER = 55;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement <em>Groupable Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.GroupableElement
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGroupableElement()
   * @generated
   */
  int GROUPABLE_ELEMENT = 54;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortPrototypeHolderImpl <em>Port Prototype Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortPrototypeHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortPrototypeHolder()
   * @generated
   */
  int PORT_PROTOTYPE_HOLDER = 78;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder <em>Prototype Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPrototypeHolder()
   * @generated
   */
  int PROTOTYPE_HOLDER = 80;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessPrototypeHolderImpl <em>Data Access Prototype Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessPrototypeHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataAccessPrototypeHolder()
   * @generated
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER = 32;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Prototype Binding</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER__PROTOTYPE_BINDING = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER__ARRAY_INDEXES = DATA_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER__GROUP_HOLDERS = DATA_HOLDER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Data Access Prototype Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_ACCESS_PROTOTYPE_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_VALUES__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_VALUES__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Element Values</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_VALUES_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_COMPONENT_REFERENCE__OWNED_ELEMENT = ELEMENT_VALUES__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_COMPONENT_REFERENCE__OWNED_COMMENT = ELEMENT_VALUES__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_COMPONENT_REFERENCE__DATA = ELEMENT_VALUES_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Data Component Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_COMPONENT_REFERENCE_FEATURE_COUNT = ELEMENT_VALUES_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_PORT_HOLDER__OWNED_ELEMENT = ACTUAL_PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_PORT_HOLDER__OWNED_COMMENT = ACTUAL_PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_PORT_HOLDER__ARRAY_INDEXES = ACTUAL_PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_PORT_HOLDER__ELEMENT = ACTUAL_PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_PORT_HOLDER__GROUP_HOLDERS = ACTUAL_PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Data Port Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_PORT_HOLDER_FEATURE_COUNT = ACTUAL_PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_SUBCOMPONENT_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_SUBCOMPONENT_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_SUBCOMPONENT_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_SUBCOMPONENT_HOLDER__GROUP_HOLDERS = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_SUBCOMPONENT_HOLDER__ARRAY_INDEXES = DATA_HOLDER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Data Subcomponent Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_SUBCOMPONENT_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION__OWNED_ELEMENT = BEHAVIOR_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION__OWNED_COMMENT = BEHAVIOR_CONDITION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Dispatch Trigger Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION = BEHAVIOR_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Frozen Ports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION__FROZEN_PORTS = BEHAVIOR_CONDITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Dispatch Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONDITION_FEATURE_COUNT = BEHAVIOR_CONDITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONJUNCTION__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONJUNCTION__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Dispatch Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Dispatch Conjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_CONJUNCTION_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Dispatch Trigger Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_RELATIVE_TIMEOUT__OWNED_ELEMENT = DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_RELATIVE_TIMEOUT__OWNED_COMMENT = DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Dispatch Relative Timeout</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_RELATIVE_TIMEOUT_FEATURE_COUNT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Dispatch Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION_STOP__OWNED_ELEMENT = DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION_STOP__OWNED_COMMENT = DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Dispatch Trigger Condition Stop</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_CONDITION_STOP_FEATURE_COUNT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__OWNED_ELEMENT = DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__OWNED_COMMENT = DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Dispatch Conjunctions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Dispatch Trigger Logical Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPATCH_TRIGGER_LOGICAL_EXPRESSION_FEATURE_COUNT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_STATEMENT__OWNED_ELEMENT = COND_STATEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_STATEMENT__OWNED_COMMENT = COND_STATEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_STATEMENT__BEHAVIOR_ACTIONS = COND_STATEMENT__BEHAVIOR_ACTIONS;

  /**
   * The number of structural features of the '<em>Else Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELSE_STATEMENT_FEATURE_COUNT = COND_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DATA_PORT_HOLDER__OWNED_ELEMENT = ACTUAL_PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DATA_PORT_HOLDER__OWNED_COMMENT = ACTUAL_PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DATA_PORT_HOLDER__ARRAY_INDEXES = ACTUAL_PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DATA_PORT_HOLDER__ELEMENT = ACTUAL_PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DATA_PORT_HOLDER__GROUP_HOLDERS = ACTUAL_PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Event Data Port Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DATA_PORT_HOLDER_FEATURE_COUNT = ACTUAL_PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PORT_HOLDER__OWNED_ELEMENT = ACTUAL_PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PORT_HOLDER__OWNED_COMMENT = ACTUAL_PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PORT_HOLDER__ARRAY_INDEXES = ACTUAL_PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PORT_HOLDER__ELEMENT = ACTUAL_PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PORT_HOLDER__GROUP_HOLDERS = ACTUAL_PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Event Port Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_PORT_HOLDER_FEATURE_COUNT = ACTUAL_PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CONDITION__OWNED_ELEMENT = BEHAVIOR_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CONDITION__OWNED_COMMENT = BEHAVIOR_CONDITION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Execute Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CONDITION_FEATURE_COUNT = BEHAVIOR_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_TIMEOUT_CATCH__OWNED_ELEMENT = EXECUTE_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_TIMEOUT_CATCH__OWNED_COMMENT = EXECUTE_CONDITION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Execution Timeout Catch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_TIMEOUT_CATCH_FEATURE_COUNT = EXECUTE_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>First Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR__FIRST_VALUE = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR__SECOND_VALUE = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Binary Numeric Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR__BINARY_NUMERIC_OPERATOR = BEHAVIOR_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Unary Numeric Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR__UNARY_NUMERIC_OPERATOR = BEHAVIOR_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Unary Boolean Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR__UNARY_BOOLEAN_OPERATOR = BEHAVIOR_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Factor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTOR_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FeaturePrototypeHolderImpl <em>Feature Prototype Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.FeaturePrototypeHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFeaturePrototypeHolder()
   * @generated
   */
  int FEATURE_PROTOTYPE_HOLDER = 52;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_PROTOTYPE_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_PROTOTYPE_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_PROTOTYPE_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Prototype Binding</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_PROTOTYPE_HOLDER__PROTOTYPE_BINDING = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_PROTOTYPE_HOLDER__ARRAY_INDEXES = DATA_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_PROTOTYPE_HOLDER__GROUP_HOLDERS = DATA_HOLDER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Feature Prototype Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_PROTOTYPE_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_STATEMENT__OWNED_ELEMENT = COND_STATEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_STATEMENT__OWNED_COMMENT = COND_STATEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_STATEMENT__BEHAVIOR_ACTIONS = COND_STATEMENT__BEHAVIOR_ACTIONS;

  /**
   * The number of structural features of the '<em>Loop Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_STATEMENT_FEATURE_COUNT = COND_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_OR_FOR_ALL_STATEMENT__OWNED_ELEMENT = LOOP_STATEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_OR_FOR_ALL_STATEMENT__OWNED_COMMENT = LOOP_STATEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_OR_FOR_ALL_STATEMENT__BEHAVIOR_ACTIONS = LOOP_STATEMENT__BEHAVIOR_ACTIONS;

  /**
   * The feature id for the '<em><b>Iterated Values</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES = LOOP_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>For All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_OR_FOR_ALL_STATEMENT__FOR_ALL = LOOP_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Iterative Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE = LOOP_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>For Or For All Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_OR_FOR_ALL_STATEMENT_FEATURE_COUNT = LOOP_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPABLE_ELEMENT__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPABLE_ELEMENT__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPABLE_ELEMENT__GROUP_HOLDERS = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Groupable Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUPABLE_ELEMENT_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_HOLDER__OWNED_ELEMENT = ELEMENT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_HOLDER__OWNED_COMMENT = ELEMENT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_HOLDER__ELEMENT = ELEMENT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_HOLDER__ARRAY_INDEXES = ELEMENT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Group Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_HOLDER_FEATURE_COUNT = ELEMENT_HOLDER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramPrototypeHolderImpl <em>Subprogram Prototype Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramPrototypeHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramPrototypeHolder()
   * @generated
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER = 89;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.GroupPrototypeHolderImpl <em>Group Prototype Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.GroupPrototypeHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGroupPrototypeHolder()
   * @generated
   */
  int GROUP_PROTOTYPE_HOLDER = 56;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_PROTOTYPE_HOLDER__OWNED_ELEMENT = GROUP_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_PROTOTYPE_HOLDER__OWNED_COMMENT = GROUP_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_PROTOTYPE_HOLDER__ELEMENT = GROUP_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_PROTOTYPE_HOLDER__ARRAY_INDEXES = GROUP_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Prototype Binding</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_PROTOTYPE_HOLDER__PROTOTYPE_BINDING = GROUP_HOLDER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Group Prototype Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_PROTOTYPE_HOLDER_FEATURE_COUNT = GROUP_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__OWNED_ELEMENT = COND_STATEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__OWNED_COMMENT = COND_STATEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__BEHAVIOR_ACTIONS = COND_STATEMENT__BEHAVIOR_ACTIONS;

  /**
   * The feature id for the '<em><b>Logical Value Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__LOGICAL_VALUE_EXPRESSION = COND_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Elif</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELIF = COND_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE_STATEMENT = COND_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = COND_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_RANGE__OWNED_ELEMENT = ELEMENT_VALUES__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_RANGE__OWNED_COMMENT = ELEMENT_VALUES__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Lower Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_RANGE__LOWER_INTEGER_VALUE = ELEMENT_VALUES_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Integer Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_RANGE__UPPER_INTEGER_VALUE = ELEMENT_VALUES_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Integer Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_RANGE_FEATURE_COUNT = ELEMENT_VALUES_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Integer Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_CONSTANT__OWNED_ELEMENT = INTEGER_VALUE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_CONSTANT__OWNED_COMMENT = INTEGER_VALUE__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Integer Value Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_CONSTANT_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_VARIABLE__OWNED_ELEMENT = INTEGER_VALUE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_VARIABLE__OWNED_COMMENT = INTEGER_VALUE__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Integer Value Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_VARIABLE_FEATURE_COUNT = INTEGER_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE__OWNED_ELEMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE__OWNED_COMMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE__NAME = BEHAVIOR_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE__QUALIFIED_NAME = BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE__OWNED_PROPERTY_ASSOCIATION = BEHAVIOR_NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Data Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE__DATA_CLASSIFIER = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Iterative Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE_FEATURE_COUNT = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementImpl <em>Struct Union Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getStructUnionElement()
   * @generated
   */
  int STRUCT_UNION_ELEMENT = 84;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementHolderImpl <em>Struct Union Element Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getStructUnionElementHolder()
   * @generated
   */
  int STRUCT_UNION_ELEMENT_HOLDER = 85;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableHolderImpl <em>Iterative Variable Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableHolderImpl
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIterativeVariableHolder()
   * @generated
   */
  int ITERATIVE_VARIABLE_HOLDER = 64;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The number of structural features of the '<em>Iterative Variable Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATIVE_VARIABLE_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHARED_DATA_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHARED_DATA_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Data Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHARED_DATA_ACTION__DATA_ACCESS = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Shared Data Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHARED_DATA_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCK_ACTION__OWNED_ELEMENT = SHARED_DATA_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCK_ACTION__OWNED_COMMENT = SHARED_DATA_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Data Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCK_ACTION__DATA_ACCESS = SHARED_DATA_ACTION__DATA_ACCESS;

  /**
   * The number of structural features of the '<em>Lock Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCK_ACTION_FEATURE_COUNT = SHARED_DATA_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_LITERAL__OWNED_ELEMENT = Aadl2Package.NUMBER_VALUE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_LITERAL__OWNED_COMMENT = Aadl2Package.NUMBER_VALUE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_LITERAL__UNIT = Aadl2Package.NUMBER_VALUE__UNIT;

  /**
   * The number of structural features of the '<em>Numeric Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_LITERAL_FEATURE_COUNT = Aadl2Package.NUMBER_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHERWISE__OWNED_ELEMENT = EXECUTE_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHERWISE__OWNED_COMMENT = EXECUTE_CONDITION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Otherwise</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHERWISE_FEATURE_COUNT = EXECUTE_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_HOLDER__GROUP_HOLDERS = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_HOLDER__ARRAY_INDEXES = DATA_HOLDER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Parameter Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LABEL__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LABEL__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Parameter Label</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LABEL_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_COUNT_VALUE__OWNED_ELEMENT = ACTUAL_PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_COUNT_VALUE__OWNED_COMMENT = ACTUAL_PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_COUNT_VALUE__ARRAY_INDEXES = ACTUAL_PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_COUNT_VALUE__ELEMENT = ACTUAL_PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_COUNT_VALUE__GROUP_HOLDERS = ACTUAL_PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Port Count Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_COUNT_VALUE_FEATURE_COUNT = ACTUAL_PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Port</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_ACTION__PORT = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_ACTION__TARGET = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Port Dequeue Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_VALUE__OWNED_ELEMENT = ACTUAL_PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_VALUE__OWNED_COMMENT = ACTUAL_PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_VALUE__ARRAY_INDEXES = ACTUAL_PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_VALUE__ELEMENT = ACTUAL_PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_VALUE__GROUP_HOLDERS = ACTUAL_PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Port Dequeue Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_DEQUEUE_VALUE_FEATURE_COUNT = ACTUAL_PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FREEZE_ACTION__OWNED_ELEMENT = ACTUAL_PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FREEZE_ACTION__OWNED_COMMENT = ACTUAL_PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FREEZE_ACTION__ARRAY_INDEXES = ACTUAL_PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FREEZE_ACTION__ELEMENT = ACTUAL_PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FREEZE_ACTION__GROUP_HOLDERS = ACTUAL_PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Port Freeze Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FREEZE_ACTION_FEATURE_COUNT = ACTUAL_PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FRESH_VALUE__OWNED_ELEMENT = ACTUAL_PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FRESH_VALUE__OWNED_COMMENT = ACTUAL_PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FRESH_VALUE__ARRAY_INDEXES = ACTUAL_PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FRESH_VALUE__ELEMENT = ACTUAL_PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FRESH_VALUE__GROUP_HOLDERS = ACTUAL_PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Port Fresh Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_FRESH_VALUE_FEATURE_COUNT = ACTUAL_PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_PROTOTYPE_HOLDER__OWNED_ELEMENT = PORT_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_PROTOTYPE_HOLDER__OWNED_COMMENT = PORT_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_PROTOTYPE_HOLDER__ARRAY_INDEXES = PORT_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_PROTOTYPE_HOLDER__ELEMENT = PORT_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_PROTOTYPE_HOLDER__GROUP_HOLDERS = PORT_HOLDER__GROUP_HOLDERS;

  /**
   * The feature id for the '<em><b>Prototype Binding</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_PROTOTYPE_HOLDER__PROTOTYPE_BINDING = PORT_HOLDER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Port Prototype Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_PROTOTYPE_HOLDER_FEATURE_COUNT = PORT_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_SEND_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_SEND_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Port</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_SEND_ACTION__PORT = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_SEND_ACTION__VALUE_EXPRESSION = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Port Send Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_SEND_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOTYPE_HOLDER__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOTYPE_HOLDER__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Prototype Binding</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOTYPE_HOLDER__PROTOTYPE_BINDING = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Prototype Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROTOTYPE_HOLDER_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>First Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__FIRST_EXPRESSION = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__SECOND_EXPRESSION = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Relational Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__RELATIONAL_OPERATOR = BEHAVIOR_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Relation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EXPRESSION__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EXPRESSION__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Unary Adding Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Terms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EXPRESSION__TERMS = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Binary Adding Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS = BEHAVIOR_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Simple Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EXPRESSION_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT__OWNED_ELEMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT__OWNED_COMMENT = BEHAVIOR_NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT__NAME = BEHAVIOR_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT__QUALIFIED_NAME = BEHAVIOR_NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT__OWNED_PROPERTY_ASSOCIATION = BEHAVIOR_NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Data Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT__DATA_CLASSIFIER = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Struct Union Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT_FEATURE_COUNT = BEHAVIOR_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT_HOLDER__OWNED_ELEMENT = DATA_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT_HOLDER__OWNED_COMMENT = DATA_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT_HOLDER__ELEMENT = DATA_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT_HOLDER__ARRAY_INDEXES = DATA_HOLDER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Struct Union Element Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_UNION_ELEMENT_HOLDER_FEATURE_COUNT = DATA_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_ACCESS_HOLDER__OWNED_ELEMENT = DISPATCH_TRIGGER_CONDITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_ACCESS_HOLDER__OWNED_COMMENT = DISPATCH_TRIGGER_CONDITION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_ACCESS_HOLDER__ELEMENT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_ACCESS_HOLDER__ARRAY_INDEXES = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_ACCESS_HOLDER__GROUP_HOLDERS = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Subprogram Access Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_ACCESS_HOLDER_FEATURE_COUNT = DISPATCH_TRIGGER_CONDITION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_CALL_ACTION__OWNED_ELEMENT = COMMUNICATION_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_CALL_ACTION__OWNED_COMMENT = COMMUNICATION_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Subprogram</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_CALL_ACTION__SUBPROGRAM = COMMUNICATION_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameter Labels</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS = COMMUNICATION_ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Data Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_CALL_ACTION__DATA_ACCESS = COMMUNICATION_ACTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Subprogram Call Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_CALL_ACTION_FEATURE_COUNT = COMMUNICATION_ACTION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_HOLDER__OWNED_ELEMENT = CALLED_SUBPROGRAM_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_HOLDER__OWNED_COMMENT = CALLED_SUBPROGRAM_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_HOLDER__ELEMENT = CALLED_SUBPROGRAM_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_HOLDER__ARRAY_INDEXES = CALLED_SUBPROGRAM_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_HOLDER__GROUP_HOLDERS = CALLED_SUBPROGRAM_HOLDER__GROUP_HOLDERS;

  /**
   * The number of structural features of the '<em>Subprogram Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_HOLDER_FEATURE_COUNT = CALLED_SUBPROGRAM_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER__OWNED_ELEMENT = CALLED_SUBPROGRAM_HOLDER__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER__OWNED_COMMENT = CALLED_SUBPROGRAM_HOLDER__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER__ELEMENT = CALLED_SUBPROGRAM_HOLDER__ELEMENT;

  /**
   * The feature id for the '<em><b>Array Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER__ARRAY_INDEXES = CALLED_SUBPROGRAM_HOLDER__ARRAY_INDEXES;

  /**
   * The feature id for the '<em><b>Group Holders</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER__GROUP_HOLDERS = CALLED_SUBPROGRAM_HOLDER__GROUP_HOLDERS;

  /**
   * The feature id for the '<em><b>Prototype Binding</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER__PROTOTYPE_BINDING = CALLED_SUBPROGRAM_HOLDER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subprogram Prototype Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBPROGRAM_PROTOTYPE_HOLDER_FEATURE_COUNT = CALLED_SUBPROGRAM_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__OWNED_ELEMENT = PARAMETER_LABEL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET__OWNED_COMMENT = PARAMETER_LABEL__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Target</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_FEATURE_COUNT = PARAMETER_LABEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__OWNED_ELEMENT = BEHAVIOR_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__OWNED_COMMENT = BEHAVIOR_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Factors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__FACTORS = BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Multiplying Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__MULTIPLYING_OPERATORS = BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_FEATURE_COUNT = BEHAVIOR_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION__OWNED_ELEMENT = BASIC_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION__OWNED_COMMENT = BASIC_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Lower Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION__LOWER_TIME = BASIC_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION__UPPER_TIME = BASIC_ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Timed Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMED_ACTION_FEATURE_COUNT = BASIC_ACTION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLOCK_ACTION__OWNED_ELEMENT = SHARED_DATA_ACTION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLOCK_ACTION__OWNED_COMMENT = SHARED_DATA_ACTION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Data Access</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLOCK_ACTION__DATA_ACCESS = SHARED_DATA_ACTION__DATA_ACCESS;

  /**
   * The number of structural features of the '<em>Unlock Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLOCK_ACTION_FEATURE_COUNT = SHARED_DATA_ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_VARIABLE__OWNED_ELEMENT = VALUE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_VARIABLE__OWNED_COMMENT = VALUE__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Value Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_VARIABLE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_OR_DO_UNTIL_STATEMENT__OWNED_ELEMENT = LOOP_STATEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_OR_DO_UNTIL_STATEMENT__OWNED_COMMENT = LOOP_STATEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Behavior Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_OR_DO_UNTIL_STATEMENT__BEHAVIOR_ACTIONS = LOOP_STATEMENT__BEHAVIOR_ACTIONS;

  /**
   * The feature id for the '<em><b>Logical Value Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION = LOOP_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Do Until</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL = LOOP_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While Or Do Until Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_OR_DO_UNTIL_STATEMENT_FEATURE_COUNT = LOOP_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorFeatureType <em>Behavior Feature Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorFeatureType
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorFeatureType()
   * @generated
   */
  int BEHAVIOR_FEATURE_TYPE = 99;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator <em>Binary Adding Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryAddingOperator()
   * @generated
   */
  int BINARY_ADDING_OPERATOR = 100;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryNumericOperator()
   * @generated
   */
  int BINARY_NUMERIC_OPERATOR = 101;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation <em>Data Representation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataRepresentation()
   * @generated
   */
  int DATA_REPRESENTATION = 102;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.FeatureType <em>Feature Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.FeatureType
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFeatureType()
   * @generated
   */
  int FEATURE_TYPE = 103;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator <em>Logical Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLogicalOperator()
   * @generated
   */
  int LOGICAL_OPERATOR = 104;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator <em>Multiplying Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getMultiplyingOperator()
   * @generated
   */
  int MULTIPLYING_OPERATOR = 105;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 106;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryAddingOperator()
   * @generated
   */
  int UNARY_ADDING_OPERATOR = 107;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryBooleanOperator()
   * @generated
   */
  int UNARY_BOOLEAN_OPERATOR = 108;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator <em>Unary Numeric Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryNumericOperator()
   * @generated
   */
  int UNARY_NUMERIC_OPERATOR = 109;

  /**
   * The meta object id for the '<em>Boolean</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBoolean()
   * @generated
   */
  int BOOLEAN = 110;

  /**
   * The meta object id for the '<em>Integer</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getInteger()
   * @generated
   */
  int INTEGER = 111;

  /**
   * The meta object id for the '<em>Real</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getReal()
   * @generated
   */
  int REAL = 112;

  /**
   * The meta object id for the '<em>String</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getString()
   * @generated
   */
  int STRING = 113;


  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction <em>Assignment Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction
   * @generated
   */
  EClass getAssignmentAction();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getTarget()
   * @see #getAssignmentAction()
   * @generated
   */
  EReference getAssignmentAction_Target();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getValueExpression <em>Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getValueExpression()
   * @see #getAssignmentAction()
   * @generated
   */
  EReference getAssignmentAction_ValueExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
   * @generated
   */
  EClass getBasicAction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
   * @generated
   */
  EClass getBehaviorAction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock <em>Behavior Action Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action Block</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock
   * @generated
   */
  EClass getBehaviorActionBlock();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getContent()
   * @see #getBehaviorActionBlock()
   * @generated
   */
  EReference getBehaviorActionBlock_Content();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getTimeout <em>Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Timeout</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock#getTimeout()
   * @see #getBehaviorActionBlock()
   * @generated
   */
  EReference getBehaviorActionBlock_Timeout();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action Collection</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection
   * @generated
   */
  EClass getBehaviorActionCollection();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection#getActions()
   * @see #getBehaviorActionCollection()
   * @generated
   */
  EReference getBehaviorActionCollection_Actions();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Actions</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
   * @generated
   */
  EClass getBehaviorActions();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence <em>Behavior Action Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action Sequence</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence
   * @generated
   */
  EClass getBehaviorActionSequence();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet <em>Behavior Action Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Action Set</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet
   * @generated
   */
  EClass getBehaviorActionSet();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex <em>Behavior Annex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Annex</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex
   * @generated
   */
  EClass getBehaviorAnnex();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getVariables()
   * @see #getBehaviorAnnex()
   * @generated
   */
  EReference getBehaviorAnnex_Variables();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getStates()
   * @see #getBehaviorAnnex()
   * @generated
   */
  EReference getBehaviorAnnex_States();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getTransitions()
   * @see #getBehaviorAnnex()
   * @generated
   */
  EReference getBehaviorAnnex_Transitions();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getActions()
   * @see #getBehaviorAnnex()
   * @generated
   */
	EReference getBehaviorAnnex_Actions();

		/**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getConditions <em>Conditions</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Conditions</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex#getConditions()
   * @see #getBehaviorAnnex()
   * @generated
   */
	EReference getBehaviorAnnex_Conditions();

		/**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral <em>Behavior Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Boolean Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral
   * @generated
   */
  EClass getBehaviorBooleanLiteral();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Condition</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
   * @generated
   */
  EClass getBehaviorCondition();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement <em>Behavior Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Element</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement
   * @generated
   */
  EClass getBehaviorElement();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral <em>Behavior Enumeration Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Enumeration Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral
   * @generated
   */
  EClass getBehaviorEnumerationLiteral();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral#getProperty()
   * @see #getBehaviorEnumerationLiteral()
   * @generated
   */
  EReference getBehaviorEnumerationLiteral_Property();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral#getEnumLiteral <em>Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Enum Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral#getEnumLiteral()
   * @see #getBehaviorEnumerationLiteral()
   * @generated
   */
  EReference getBehaviorEnumerationLiteral_EnumLiteral();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Component</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral#getComponent()
   * @see #getBehaviorEnumerationLiteral()
   * @generated
   */
  EReference getBehaviorEnumerationLiteral_Component();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral <em>Behavior Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Integer Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral
   * @generated
   */
  EClass getBehaviorIntegerLiteral();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement <em>Behavior Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Named Element</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement
   * @generated
   */
  EClass getBehaviorNamedElement();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant <em>Behavior Property Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Property Constant</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant
   * @generated
   */
  EClass getBehaviorPropertyConstant();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant#getProperty()
   * @see #getBehaviorPropertyConstant()
   * @generated
   */
  EReference getBehaviorPropertyConstant_Property();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyValue <em>Behavior Property Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Property Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyValue
   * @generated
   */
  EClass getBehaviorPropertyValue();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyValue#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyValue#getProperty()
   * @see #getBehaviorPropertyValue()
   * @generated
   */
  EReference getBehaviorPropertyValue_Property();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorRealLiteral <em>Behavior Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Real Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorRealLiteral
   * @generated
   */
  EClass getBehaviorRealLiteral();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState <em>Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior State</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState
   * @generated
   */
  EClass getBehaviorState();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isInitial <em>Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isInitial()
   * @see #getBehaviorState()
   * @generated
   */
  EAttribute getBehaviorState_Initial();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isComplete <em>Complete</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Complete</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isComplete()
   * @see #getBehaviorState()
   * @generated
   */
  EAttribute getBehaviorState_Complete();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#isFinal()
   * @see #getBehaviorState()
   * @generated
   */
  EAttribute getBehaviorState_Final();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getBindedMode <em>Binded Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Binded Mode</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorState#getBindedMode()
   * @see #getBehaviorState()
   * @generated
   */
  EReference getBehaviorState_BindedMode();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorStringLiteral <em>Behavior String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior String Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorStringLiteral
   * @generated
   */
  EClass getBehaviorStringLiteral();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime <em>Behavior Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Time</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime
   * @generated
   */
  EClass getBehaviorTime();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Integer Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getIntegerValue()
   * @see #getBehaviorTime()
   * @generated
   */
  EReference getBehaviorTime_IntegerValue();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime#getUnit()
   * @see #getBehaviorTime()
   * @generated
   */
  EReference getBehaviorTime_Unit();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition <em>Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Transition</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition
   * @generated
   */
  EClass getBehaviorTransition();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceState <em>Source State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source State</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceState()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_SourceState();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getCondition()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_Condition();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationState <em>Destination State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Destination State</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationState()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_DestinationState();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getActionBlock <em>Action Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Action Block</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getActionBlock()
   * @see #getBehaviorTransition()
   * @generated
   */
  EReference getBehaviorTransition_ActionBlock();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getPriority()
   * @see #getBehaviorTransition()
   * @generated
   */
  EAttribute getBehaviorTransition_Priority();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable <em>Behavior Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Variable</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable
   * @generated
   */
  EClass getBehaviorVariable();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getDataClassifier <em>Data Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Data Classifier</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getDataClassifier()
   * @see #getBehaviorVariable()
   * @generated
   */
  EReference getBehaviorVariable_DataClassifier();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Communication Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
   * @generated
   */
  EClass getCommunicationAction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeout <em>Completion Relative Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Completion Relative Timeout</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeout
   * @generated
   */
  EClass getCompletionRelativeTimeout();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cond Statement</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
   * @generated
   */
  EClass getCondStatement();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement#getBehaviorActions <em>Behavior Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Behavior Actions</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement#getBehaviorActions()
   * @see #getCondStatement()
   * @generated
   */
  EReference getCondStatement_BehaviorActions();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference <em>Data Component Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Component Reference</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference
   * @generated
   */
  EClass getDataComponentReference();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getData <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Data</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getData()
   * @see #getDataComponentReference()
   * @generated
   */
  EReference getDataComponentReference_Data();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition <em>Dispatch Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Condition</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition
   * @generated
   */
  EClass getDispatchCondition();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getDispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dispatch Trigger Condition</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getDispatchTriggerCondition()
   * @see #getDispatchCondition()
   * @generated
   */
  EReference getDispatchCondition_DispatchTriggerCondition();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getFrozenPorts <em>Frozen Ports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Frozen Ports</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition#getFrozenPorts()
   * @see #getDispatchCondition()
   * @generated
   */
  EReference getDispatchCondition_FrozenPorts();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction <em>Dispatch Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Conjunction</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction
   * @generated
   */
  EClass getDispatchConjunction();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction#getDispatchTriggers <em>Dispatch Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dispatch Triggers</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction#getDispatchTriggers()
   * @see #getDispatchConjunction()
   * @generated
   */
  EReference getDispatchConjunction_DispatchTriggers();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Trigger Condition</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
   * @generated
   */
  EClass getDispatchTriggerCondition();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop <em>Dispatch Trigger Condition Stop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Trigger Condition Stop</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop
   * @generated
   */
  EClass getDispatchTriggerConditionStop();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression <em>Dispatch Trigger Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Trigger Logical Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression
   * @generated
   */
  EClass getDispatchTriggerLogicalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression#getDispatchConjunctions <em>Dispatch Conjunctions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dispatch Conjunctions</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression#getDispatchConjunctions()
   * @see #getDispatchTriggerLogicalExpression()
   * @generated
   */
  EReference getDispatchTriggerLogicalExpression_DispatchConjunctions();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Values</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
   * @generated
   */
  EClass getElementValues();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElseStatement <em>Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Else Statement</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElseStatement
   * @generated
   */
  EClass getElseStatement();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execute Condition</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
   * @generated
   */
  EClass getExecuteCondition();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor <em>Factor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factor</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Factor
   * @generated
   */
  EClass getFactor();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getFirstValue <em>First Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getFirstValue()
   * @see #getFactor()
   * @generated
   */
  EReference getFactor_FirstValue();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getSecondValue <em>Second Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getSecondValue()
   * @see #getFactor()
   * @generated
   */
  EReference getFactor_SecondValue();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperator <em>Binary Numeric Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Binary Numeric Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperator()
   * @see #getFactor()
   * @generated
   */
  EAttribute getFactor_BinaryNumericOperator();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperator <em>Unary Numeric Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unary Numeric Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperator()
   * @see #getFactor()
   * @generated
   */
  EAttribute getFactor_UnaryNumericOperator();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperator <em>Unary Boolean Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unary Boolean Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperator()
   * @see #getFactor()
   * @generated
   */
  EAttribute getFactor_UnaryBooleanOperator();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.FeaturePrototypeHolder <em>Feature Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Prototype Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.FeaturePrototypeHolder
   * @generated
   */
  EClass getFeaturePrototypeHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement <em>For Or For All Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>For Or For All Statement</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement
   * @generated
   */
  EClass getForOrForAllStatement();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getIteratedValues <em>Iterated Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iterated Values</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getIteratedValues()
   * @see #getForOrForAllStatement()
   * @generated
   */
  EReference getForOrForAllStatement_IteratedValues();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll <em>For All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>For All</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll()
   * @see #getForOrForAllStatement()
   * @generated
   */
  EAttribute getForOrForAllStatement_ForAll();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getIterativeVariable <em>Iterative Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iterative Variable</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getIterativeVariable()
   * @see #getForOrForAllStatement()
   * @generated
   */
  EReference getForOrForAllStatement_IterativeVariable();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Statement</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement
   * @generated
   */
  EClass getIfStatement();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getLogicalValueExpression <em>Logical Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Logical Value Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getLogicalValueExpression()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_LogicalValueExpression();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isElif <em>Elif</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Elif</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement#isElif()
   * @see #getIfStatement()
   * @generated
   */
  EAttribute getIfStatement_Elif();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getElseStatement <em>Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Statement</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IfStatement#getElseStatement()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ElseStatement();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange <em>Integer Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Range</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange
   * @generated
   */
  EClass getIntegerRange();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getLowerIntegerValue <em>Lower Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower Integer Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getLowerIntegerValue()
   * @see #getIntegerRange()
   * @generated
   */
  EReference getIntegerRange_LowerIntegerValue();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getUpperIntegerValue <em>Upper Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper Integer Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerRange#getUpperIntegerValue()
   * @see #getIntegerRange()
   * @generated
   */
  EReference getIntegerRange_UpperIntegerValue();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
   * @generated
   */
  EClass getIntegerValue();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Value Constant</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
   * @generated
   */
  EClass getIntegerValueConstant();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Value Variable</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
   * @generated
   */
  EClass getIntegerValueVariable();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.LockAction <em>Lock Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lock Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.LockAction
   * @generated
   */
  EClass getLockAction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.LoopStatement <em>Loop Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop Statement</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.LoopStatement
   * @generated
   */
  EClass getLoopStatement();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral <em>Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Literal</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral
   * @generated
   */
  EClass getNumericLiteral();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Otherwise <em>Otherwise</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Otherwise</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Otherwise
   * @generated
   */
  EClass getOtherwise();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Label</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
   * @generated
   */
  EClass getParameterLabel();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortCountValue <em>Port Count Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Count Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortCountValue
   * @generated
   */
  EClass getPortCountValue();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction <em>Port Dequeue Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Dequeue Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction
   * @generated
   */
  EClass getPortDequeueAction();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Port</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getPort()
   * @see #getPortDequeueAction()
   * @generated
   */
  EReference getPortDequeueAction_Port();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction#getTarget()
   * @see #getPortDequeueAction()
   * @generated
   */
  EReference getPortDequeueAction_Target();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue <em>Port Dequeue Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Dequeue Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue
   * @generated
   */
  EClass getPortDequeueValue();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction <em>Port Freeze Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Freeze Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction
   * @generated
   */
  EClass getPortFreezeAction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue <em>Port Fresh Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Fresh Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue
   * @generated
   */
  EClass getPortFreshValue();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction <em>Port Send Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Send Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortSendAction
   * @generated
   */
  EClass getPortSendAction();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Port</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getPort()
   * @see #getPortSendAction()
   * @generated
   */
  EReference getPortSendAction_Port();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getValueExpression <em>Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortSendAction#getValueExpression()
   * @see #getPortSendAction()
   * @generated
   */
  EReference getPortSendAction_ValueExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Relation
   * @generated
   */
  EClass getRelation();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getFirstExpression <em>First Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Relation#getFirstExpression()
   * @see #getRelation()
   * @generated
   */
  EReference getRelation_FirstExpression();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSecondExpression <em>Second Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Relation#getSecondExpression()
   * @see #getRelation()
   * @generated
   */
  EReference getRelation_SecondExpression();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relational Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperator()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_RelationalOperator();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction <em>Shared Data Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shared Data Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction
   * @generated
   */
  EClass getSharedDataAction();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccess <em>Data Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data Access</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction#getDataAccess()
   * @see #getSharedDataAction()
   * @generated
   */
  EReference getSharedDataAction_DataAccess();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression <em>Simple Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression
   * @generated
   */
  EClass getSimpleExpression();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperator <em>Unary Adding Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unary Adding Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperator()
   * @see #getSimpleExpression()
   * @generated
   */
  EAttribute getSimpleExpression_UnaryAddingOperator();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTerms <em>Terms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Terms</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTerms()
   * @see #getSimpleExpression()
   * @generated
   */
  EReference getSimpleExpression_Terms();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperators <em>Binary Adding Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Binary Adding Operators</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperators()
   * @see #getSimpleExpression()
   * @generated
   */
  EAttribute getSimpleExpression_BinaryAddingOperators();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction <em>Subprogram Call Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subprogram Call Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction
   * @generated
   */
  EClass getSubprogramCallAction();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogram <em>Subprogram</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Subprogram</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getSubprogram()
   * @see #getSubprogramCallAction()
   * @generated
   */
  EReference getSubprogramCallAction_Subprogram();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getParameterLabels <em>Parameter Labels</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Labels</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getParameterLabels()
   * @see #getSubprogramCallAction()
   * @generated
   */
  EReference getSubprogramCallAction_ParameterLabels();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getDataAccess <em>Data Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Data Access</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction#getDataAccess()
   * @see #getSubprogramCallAction()
   * @generated
   */
  EReference getSubprogramCallAction_DataAccess();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Target
   * @generated
   */
  EClass getTarget();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Term
   * @generated
   */
  EClass getTerm();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactors <em>Factors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Factors</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Term#getFactors()
   * @see #getTerm()
   * @generated
   */
  EReference getTerm_Factors();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperators <em>Multiplying Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Multiplying Operators</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperators()
   * @see #getTerm()
   * @generated
   */
  EAttribute getTerm_MultiplyingOperators();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction <em>Timed Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timed Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction
   * @generated
   */
  EClass getTimedAction();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerTime <em>Lower Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower Time</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getLowerTime()
   * @see #getTimedAction()
   * @generated
   */
  EReference getTimedAction_LowerTime();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperTime <em>Upper Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper Time</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.TimedAction#getUpperTime()
   * @see #getTimedAction()
   * @generated
   */
  EReference getTimedAction_UpperTime();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.UnlockAction <em>Unlock Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unlock Action</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.UnlockAction
   * @generated
   */
  EClass getUnlockAction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Constant</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
   * @generated
   */
  EClass getValueConstant();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression <em>Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression
   * @generated
   */
  EClass getValueExpression();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelations <em>Relations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relations</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelations()
   * @see #getValueExpression()
   * @generated
   */
  EReference getValueExpression_Relations();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Logical Operators</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperators()
   * @see #getValueExpression()
   * @generated
   */
  EAttribute getValueExpression_LogicalOperators();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Variable</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
   * @generated
   */
  EClass getValueVariable();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement <em>While Or Do Until Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While Or Do Until Statement</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement
   * @generated
   */
  EClass getWhileOrDoUntilStatement();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#getLogicalValueExpression <em>Logical Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Logical Value Expression</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#getLogicalValueExpression()
   * @see #getWhileOrDoUntilStatement()
   * @generated
   */
  EReference getWhileOrDoUntilStatement_LogicalValueExpression();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#isDoUntil <em>Do Until</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Do Until</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement#isDoUntil()
   * @see #getWhileOrDoUntilStatement()
   * @generated
   */
  EAttribute getWhileOrDoUntilStatement_DoUntil();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder <em>Actual Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actual Port Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder
   * @generated
   */
  EClass getActualPortHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecutionTimeoutCatch <em>Execution Timeout Catch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execution Timeout Catch</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ExecutionTimeoutCatch
   * @generated
   */
  EClass getExecutionTimeoutCatch();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchRelativeTimeout <em>Dispatch Relative Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Relative Timeout</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchRelativeTimeout
   * @generated
   */
  EClass getDispatchRelativeTimeout();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataHolder <em>Data Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataHolder
   * @generated
   */
  EClass getDataHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramHolder <em>Subprogram Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subprogram Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramHolder
   * @generated
   */
  EClass getSubprogramHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IterativeVariable <em>Iterative Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iterative Variable</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IterativeVariable
   * @generated
   */
  EClass getIterativeVariable();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.IterativeVariable#getDataClassifier <em>Data Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Data Classifier</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IterativeVariable#getDataClassifier()
   * @see #getIterativeVariable()
   * @generated
   */
  EReference getIterativeVariable_DataClassifier();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataAccessHolder <em>Data Access Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Access Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataAccessHolder
   * @generated
   */
  EClass getDataAccessHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataSubcomponentHolder <em>Data Subcomponent Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Subcomponent Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataSubcomponentHolder
   * @generated
   */
  EClass getDataSubcomponentHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariableHolder <em>Behavior Variable Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Variable Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariableHolder
   * @generated
   */
  EClass getBehaviorVariableHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementHolder <em>Element Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElementHolder
   * @generated
   */
  EClass getElementHolder();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementHolder#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Element</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ElementHolder#getElement()
   * @see #getElementHolder()
   * @generated
   */
  EReference getElementHolder_Element();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataPortHolder <em>Data Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Port Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataPortHolder
   * @generated
   */
  EClass getDataPortHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.EventPortHolder <em>Event Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Port Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.EventPortHolder
   * @generated
   */
  EClass getEventPortHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.EventDataPortHolder <em>Event Data Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Data Port Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.EventDataPortHolder
   * @generated
   */
  EClass getEventDataPortHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterHolder <em>Parameter Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterHolder
   * @generated
   */
  EClass getParameterHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramAccessHolder <em>Subprogram Access Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subprogram Access Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramAccessHolder
   * @generated
   */
  EClass getSubprogramAccessHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger <em>Dispatch Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dispatch Trigger</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger
   * @generated
   */
  EClass getDispatchTrigger();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorProperty <em>Behavior Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Behavior Property</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorProperty
   * @generated
   */
  EClass getBehaviorProperty();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorProperty#getPropertySet <em>Property Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property Set</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorProperty#getPropertySet()
   * @see #getBehaviorProperty()
   * @generated
   */
  EReference getBehaviorProperty_PropertySet();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.Any <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Any</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.Any
   * @generated
   */
  EClass getAny();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupHolder <em>Group Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.GroupHolder
   * @generated
   */
  EClass getGroupHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.CalledSubprogramHolder <em>Called Subprogram Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Called Subprogram Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.CalledSubprogramHolder
   * @generated
   */
  EClass getCalledSubprogramHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IndexableElement <em>Indexable Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Indexable Element</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IndexableElement
   * @generated
   */
  EClass getIndexableElement();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.IndexableElement#getArrayIndexes <em>Array Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Array Indexes</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IndexableElement#getArrayIndexes()
   * @see #getIndexableElement()
   * @generated
   */
  EReference getIndexableElement_ArrayIndexes();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement <em>Groupable Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Groupable Element</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.GroupableElement
   * @generated
   */
  EClass getGroupableElement();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement#getGroupHolders <em>Group Holders</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Group Holders</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.GroupableElement#getGroupHolders()
   * @see #getGroupableElement()
   * @generated
   */
  EReference getGroupableElement_GroupHolders();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortHolder <em>Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortHolder
   * @generated
   */
  EClass getPortHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PortPrototypeHolder <em>Port Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Prototype Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PortPrototypeHolder
   * @generated
   */
  EClass getPortPrototypeHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder <em>Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prototype Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder
   * @generated
   */
  EClass getPrototypeHolder();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder#getPrototypeBinding <em>Prototype Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Prototype Binding</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder#getPrototypeBinding()
   * @see #getPrototypeHolder()
   * @generated
   */
  EReference getPrototypeHolder_PrototypeBinding();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.DataAccessPrototypeHolder <em>Data Access Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Access Prototype Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataAccessPrototypeHolder
   * @generated
   */
  EClass getDataAccessPrototypeHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramPrototypeHolder <em>Subprogram Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subprogram Prototype Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.SubprogramPrototypeHolder
   * @generated
   */
  EClass getSubprogramPrototypeHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupPrototypeHolder <em>Group Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group Prototype Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.GroupPrototypeHolder
   * @generated
   */
  EClass getGroupPrototypeHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.StructUnionElement <em>Struct Union Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Union Element</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.StructUnionElement
   * @generated
   */
  EClass getStructUnionElement();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.annex.behavior.aadlba.StructUnionElement#getDataClassifier <em>Data Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Data Classifier</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.StructUnionElement#getDataClassifier()
   * @see #getStructUnionElement()
   * @generated
   */
  EReference getStructUnionElement_DataClassifier();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.StructUnionElementHolder <em>Struct Union Element Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct Union Element Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.StructUnionElementHolder
   * @generated
   */
  EClass getStructUnionElementHolder();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.annex.behavior.aadlba.IterativeVariableHolder <em>Iterative Variable Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iterative Variable Holder</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.IterativeVariableHolder
   * @generated
   */
  EClass getIterativeVariableHolder();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorFeatureType <em>Behavior Feature Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Behavior Feature Type</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorFeatureType
   * @generated
   */
  EEnum getBehaviorFeatureType();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator <em>Binary Adding Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Binary Adding Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
   * @generated
   */
  EEnum getBinaryAddingOperator();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Binary Numeric Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
   * @generated
   */
  EEnum getBinaryNumericOperator();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation <em>Data Representation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Data Representation</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation
   * @generated
   */
  EEnum getDataRepresentation();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.FeatureType <em>Feature Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Feature Type</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.FeatureType
   * @generated
   */
  EEnum getFeatureType();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator <em>Logical Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Logical Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
   * @generated
   */
  EEnum getLogicalOperator();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator <em>Multiplying Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiplying Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
   * @generated
   */
  EEnum getMultiplyingOperator();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Adding Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
   * @generated
   */
  EEnum getUnaryAddingOperator();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Boolean Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
   * @generated
   */
  EEnum getUnaryBooleanOperator();

  /**
   * Returns the meta object for enum '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator <em>Unary Numeric Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Numeric Operator</em>'.
   * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
   * @generated
   */
  EEnum getUnaryNumericOperator();

  /**
   * Returns the meta object for data type '<em>Boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Boolean</em>'.
   * @model instanceClass="boolean"
   *        annotation="http://www.topcased.org/documentation documentation='A Boolean type is used for logical expression, consisting of the predefined values true and false.'"
   * @generated
   */
  EDataType getBoolean();

  /**
   * Returns the meta object for data type '<em>Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Integer</em>'.
   * @model instanceClass="int"
   *        annotation="http://www.topcased.org/documentation documentation='An integer is a primitive type representing integer values.'"
   * @generated
   */
  EDataType getInteger();

  /**
   * Returns the meta object for data type '<em>Real</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Real</em>'.
   * @model instanceClass="double"
   *        annotation="http://www.topcased.org/documentation documentation='A real is a primitive type representing real numeric values.'"
   * @generated
   */
  EDataType getReal();

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>String</em>'.
   * @see java.lang.String
   * @model instanceClass="java.lang.String"
   *        annotation="http://www.topcased.org/documentation documentation='A string is a sequence of characters in some suitable character set used to display information about the model. Character sets may include non-Roman alphabets and characters.'"
   * @generated
   */
  EDataType getString();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AadlBaFactory getAadlBaFactory();

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
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl <em>Assignment Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AssignmentActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getAssignmentAction()
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
     * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_ACTION__VALUE_EXPRESSION = eINSTANCE.getAssignmentAction_ValueExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BasicAction <em>Basic Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BasicAction
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBasicAction()
     * @generated
     */
    EClass BASIC_ACTION = eINSTANCE.getBasicAction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction <em>Behavior Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAction()
     * @generated
     */
    EClass BEHAVIOR_ACTION = eINSTANCE.getBehaviorAction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl <em>Behavior Action Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionBlockImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionBlock()
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
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionCollection()
     * @generated
     */
    EClass BEHAVIOR_ACTION_COLLECTION = eINSTANCE.getBehaviorActionCollection();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ACTION_COLLECTION__ACTIONS = eINSTANCE.getBehaviorActionCollection_Actions();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions <em>Behavior Actions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActions()
     * @generated
     */
    EClass BEHAVIOR_ACTIONS = eINSTANCE.getBehaviorActions();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl <em>Behavior Action Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSequenceImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSequence()
     * @generated
     */
    EClass BEHAVIOR_ACTION_SEQUENCE = eINSTANCE.getBehaviorActionSequence();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl <em>Behavior Action Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionSetImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorActionSet()
     * @generated
     */
    EClass BEHAVIOR_ACTION_SET = eINSTANCE.getBehaviorActionSet();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl <em>Behavior Annex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorAnnex()
     * @generated
     */
    EClass BEHAVIOR_ANNEX = eINSTANCE.getBehaviorAnnex();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ANNEX__VARIABLES = eINSTANCE.getBehaviorAnnex_Variables();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ANNEX__STATES = eINSTANCE.getBehaviorAnnex_States();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ANNEX__TRANSITIONS = eINSTANCE.getBehaviorAnnex_Transitions();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BEHAVIOR_ANNEX__ACTIONS = eINSTANCE.getBehaviorAnnex_Actions();

				/**
     * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference BEHAVIOR_ANNEX__CONDITIONS = eINSTANCE.getBehaviorAnnex_Conditions();

				/**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorBooleanLiteralImpl <em>Behavior Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorBooleanLiteralImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorBooleanLiteral()
     * @generated
     */
    EClass BEHAVIOR_BOOLEAN_LITERAL = eINSTANCE.getBehaviorBooleanLiteral();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition <em>Behavior Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorCondition()
     * @generated
     */
    EClass BEHAVIOR_CONDITION = eINSTANCE.getBehaviorCondition();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorElementImpl <em>Behavior Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorElementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorElement()
     * @generated
     */
    EClass BEHAVIOR_ELEMENT = eINSTANCE.getBehaviorElement();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorEnumerationLiteralImpl <em>Behavior Enumeration Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorEnumerationLiteralImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorEnumerationLiteral()
     * @generated
     */
    EClass BEHAVIOR_ENUMERATION_LITERAL = eINSTANCE.getBehaviorEnumerationLiteral();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ENUMERATION_LITERAL__PROPERTY = eINSTANCE.getBehaviorEnumerationLiteral_Property();

    /**
     * The meta object literal for the '<em><b>Enum Literal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ENUMERATION_LITERAL__ENUM_LITERAL = eINSTANCE.getBehaviorEnumerationLiteral_EnumLiteral();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_ENUMERATION_LITERAL__COMPONENT = eINSTANCE.getBehaviorEnumerationLiteral_Component();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl <em>Behavior Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorIntegerLiteralImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorIntegerLiteral()
     * @generated
     */
    EClass BEHAVIOR_INTEGER_LITERAL = eINSTANCE.getBehaviorIntegerLiteral();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl <em>Behavior Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorNamedElementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorNamedElement()
     * @generated
     */
    EClass BEHAVIOR_NAMED_ELEMENT = eINSTANCE.getBehaviorNamedElement();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyConstantImpl <em>Behavior Property Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyConstantImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorPropertyConstant()
     * @generated
     */
    EClass BEHAVIOR_PROPERTY_CONSTANT = eINSTANCE.getBehaviorPropertyConstant();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_PROPERTY_CONSTANT__PROPERTY = eINSTANCE.getBehaviorPropertyConstant_Property();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyValueImpl <em>Behavior Property Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyValueImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorPropertyValue()
     * @generated
     */
    EClass BEHAVIOR_PROPERTY_VALUE = eINSTANCE.getBehaviorPropertyValue();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_PROPERTY_VALUE__PROPERTY = eINSTANCE.getBehaviorPropertyValue_Property();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorRealLiteralImpl <em>Behavior Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorRealLiteralImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorRealLiteral()
     * @generated
     */
    EClass BEHAVIOR_REAL_LITERAL = eINSTANCE.getBehaviorRealLiteral();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl <em>Behavior State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorState()
     * @generated
     */
    EClass BEHAVIOR_STATE = eINSTANCE.getBehaviorState();

    /**
     * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STATE__INITIAL = eINSTANCE.getBehaviorState_Initial();

    /**
     * The meta object literal for the '<em><b>Complete</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STATE__COMPLETE = eINSTANCE.getBehaviorState_Complete();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_STATE__FINAL = eINSTANCE.getBehaviorState_Final();

    /**
     * The meta object literal for the '<em><b>Binded Mode</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_STATE__BINDED_MODE = eINSTANCE.getBehaviorState_BindedMode();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStringLiteralImpl <em>Behavior String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStringLiteralImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorStringLiteral()
     * @generated
     */
    EClass BEHAVIOR_STRING_LITERAL = eINSTANCE.getBehaviorStringLiteral();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl <em>Behavior Time</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTime()
     * @generated
     */
    EClass BEHAVIOR_TIME = eINSTANCE.getBehaviorTime();

    /**
     * The meta object literal for the '<em><b>Integer Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TIME__INTEGER_VALUE = eINSTANCE.getBehaviorTime_IntegerValue();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TIME__UNIT = eINSTANCE.getBehaviorTime_Unit();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl <em>Behavior Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorTransition()
     * @generated
     */
    EClass BEHAVIOR_TRANSITION = eINSTANCE.getBehaviorTransition();

    /**
     * The meta object literal for the '<em><b>Source State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TRANSITION__SOURCE_STATE = eINSTANCE.getBehaviorTransition_SourceState();

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
     * The meta object literal for the '<em><b>Action Block</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_TRANSITION__ACTION_BLOCK = eINSTANCE.getBehaviorTransition_ActionBlock();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BEHAVIOR_TRANSITION__PRIORITY = eINSTANCE.getBehaviorTransition_Priority();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl <em>Behavior Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorVariable()
     * @generated
     */
    EClass BEHAVIOR_VARIABLE = eINSTANCE.getBehaviorVariable();

    /**
     * The meta object literal for the '<em><b>Data Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_VARIABLE__DATA_CLASSIFIER = eINSTANCE.getBehaviorVariable_DataClassifier();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction <em>Communication Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCommunicationAction()
     * @generated
     */
    EClass COMMUNICATION_ACTION = eINSTANCE.getCommunicationAction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutImpl <em>Completion Relative Timeout</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CompletionRelativeTimeoutImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCompletionRelativeTimeout()
     * @generated
     */
    EClass COMPLETION_RELATIVE_TIMEOUT = eINSTANCE.getCompletionRelativeTimeout();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.CondStatement <em>Cond Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.CondStatement
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCondStatement()
     * @generated
     */
    EClass COND_STATEMENT = eINSTANCE.getCondStatement();

    /**
     * The meta object literal for the '<em><b>Behavior Actions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COND_STATEMENT__BEHAVIOR_ACTIONS = eINSTANCE.getCondStatement_BehaviorActions();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl <em>Data Component Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataComponentReference()
     * @generated
     */
    EClass DATA_COMPONENT_REFERENCE = eINSTANCE.getDataComponentReference();

    /**
     * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_COMPONENT_REFERENCE__DATA = eINSTANCE.getDataComponentReference_Data();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl <em>Dispatch Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchCondition()
     * @generated
     */
    EClass DISPATCH_CONDITION = eINSTANCE.getDispatchCondition();

    /**
     * The meta object literal for the '<em><b>Dispatch Trigger Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION = eINSTANCE.getDispatchCondition_DispatchTriggerCondition();

    /**
     * The meta object literal for the '<em><b>Frozen Ports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_CONDITION__FROZEN_PORTS = eINSTANCE.getDispatchCondition_FrozenPorts();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl <em>Dispatch Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConjunctionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchConjunction()
     * @generated
     */
    EClass DISPATCH_CONJUNCTION = eINSTANCE.getDispatchConjunction();

    /**
     * The meta object literal for the '<em><b>Dispatch Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS = eINSTANCE.getDispatchConjunction_DispatchTriggers();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerCondition()
     * @generated
     */
    EClass DISPATCH_TRIGGER_CONDITION = eINSTANCE.getDispatchTriggerCondition();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl <em>Dispatch Trigger Condition Stop</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerConditionStopImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerConditionStop()
     * @generated
     */
    EClass DISPATCH_TRIGGER_CONDITION_STOP = eINSTANCE.getDispatchTriggerConditionStop();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl <em>Dispatch Trigger Logical Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerLogicalExpressionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTriggerLogicalExpression()
     * @generated
     */
    EClass DISPATCH_TRIGGER_LOGICAL_EXPRESSION = eINSTANCE.getDispatchTriggerLogicalExpression();

    /**
     * The meta object literal for the '<em><b>Dispatch Conjunctions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS = eINSTANCE.getDispatchTriggerLogicalExpression_DispatchConjunctions();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementValues <em>Element Values</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.ElementValues
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementValues()
     * @generated
     */
    EClass ELEMENT_VALUES = eINSTANCE.getElementValues();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElseStatementImpl <em>Else Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ElseStatementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElseStatement()
     * @generated
     */
    EClass ELSE_STATEMENT = eINSTANCE.getElseStatement();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition <em>Execute Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecuteCondition()
     * @generated
     */
    EClass EXECUTE_CONDITION = eINSTANCE.getExecuteCondition();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl <em>Factor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFactor()
     * @generated
     */
    EClass FACTOR = eINSTANCE.getFactor();

    /**
     * The meta object literal for the '<em><b>First Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTOR__FIRST_VALUE = eINSTANCE.getFactor_FirstValue();

    /**
     * The meta object literal for the '<em><b>Second Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTOR__SECOND_VALUE = eINSTANCE.getFactor_SecondValue();

    /**
     * The meta object literal for the '<em><b>Binary Numeric Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACTOR__BINARY_NUMERIC_OPERATOR = eINSTANCE.getFactor_BinaryNumericOperator();

    /**
     * The meta object literal for the '<em><b>Unary Numeric Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACTOR__UNARY_NUMERIC_OPERATOR = eINSTANCE.getFactor_UnaryNumericOperator();

    /**
     * The meta object literal for the '<em><b>Unary Boolean Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FACTOR__UNARY_BOOLEAN_OPERATOR = eINSTANCE.getFactor_UnaryBooleanOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FeaturePrototypeHolderImpl <em>Feature Prototype Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.FeaturePrototypeHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFeaturePrototypeHolder()
     * @generated
     */
    EClass FEATURE_PROTOTYPE_HOLDER = eINSTANCE.getFeaturePrototypeHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl <em>For Or For All Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ForOrForAllStatementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getForOrForAllStatement()
     * @generated
     */
    EClass FOR_OR_FOR_ALL_STATEMENT = eINSTANCE.getForOrForAllStatement();

    /**
     * The meta object literal for the '<em><b>Iterated Values</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES = eINSTANCE.getForOrForAllStatement_IteratedValues();

    /**
     * The meta object literal for the '<em><b>For All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOR_OR_FOR_ALL_STATEMENT__FOR_ALL = eINSTANCE.getForOrForAllStatement_ForAll();

    /**
     * The meta object literal for the '<em><b>Iterative Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE = eINSTANCE.getForOrForAllStatement_IterativeVariable();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl <em>If Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IfStatementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIfStatement()
     * @generated
     */
    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    /**
     * The meta object literal for the '<em><b>Logical Value Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__LOGICAL_VALUE_EXPRESSION = eINSTANCE.getIfStatement_LogicalValueExpression();

    /**
     * The meta object literal for the '<em><b>Elif</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF_STATEMENT__ELIF = eINSTANCE.getIfStatement_Elif();

    /**
     * The meta object literal for the '<em><b>Else Statement</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE_STATEMENT = eINSTANCE.getIfStatement_ElseStatement();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl <em>Integer Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IntegerRangeImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerRange()
     * @generated
     */
    EClass INTEGER_RANGE = eINSTANCE.getIntegerRange();

    /**
     * The meta object literal for the '<em><b>Lower Integer Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTEGER_RANGE__LOWER_INTEGER_VALUE = eINSTANCE.getIntegerRange_LowerIntegerValue();

    /**
     * The meta object literal for the '<em><b>Upper Integer Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTEGER_RANGE__UPPER_INTEGER_VALUE = eINSTANCE.getIntegerRange_UpperIntegerValue();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue <em>Integer Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValue
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValue()
     * @generated
     */
    EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueConstant()
     * @generated
     */
    EClass INTEGER_VALUE_CONSTANT = eINSTANCE.getIntegerValueConstant();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIntegerValueVariable()
     * @generated
     */
    EClass INTEGER_VALUE_VARIABLE = eINSTANCE.getIntegerValueVariable();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Literal <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.Literal
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl <em>Lock Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LockActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLockAction()
     * @generated
     */
    EClass LOCK_ACTION = eINSTANCE.getLockAction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl <em>Loop Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.LoopStatementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLoopStatement()
     * @generated
     */
    EClass LOOP_STATEMENT = eINSTANCE.getLoopStatement();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral <em>Numeric Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getNumericLiteral()
     * @generated
     */
    EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl <em>Otherwise</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.OtherwiseImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getOtherwise()
     * @generated
     */
    EClass OTHERWISE = eINSTANCE.getOtherwise();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel <em>Parameter Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterLabel()
     * @generated
     */
    EClass PARAMETER_LABEL = eINSTANCE.getParameterLabel();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl <em>Port Count Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortCountValueImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortCountValue()
     * @generated
     */
    EClass PORT_COUNT_VALUE = eINSTANCE.getPortCountValue();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl <em>Port Dequeue Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueAction()
     * @generated
     */
    EClass PORT_DEQUEUE_ACTION = eINSTANCE.getPortDequeueAction();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_DEQUEUE_ACTION__PORT = eINSTANCE.getPortDequeueAction_Port();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_DEQUEUE_ACTION__TARGET = eINSTANCE.getPortDequeueAction_Target();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl <em>Port Dequeue Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortDequeueValueImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortDequeueValue()
     * @generated
     */
    EClass PORT_DEQUEUE_VALUE = eINSTANCE.getPortDequeueValue();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl <em>Port Freeze Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreezeActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreezeAction()
     * @generated
     */
    EClass PORT_FREEZE_ACTION = eINSTANCE.getPortFreezeAction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl <em>Port Fresh Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortFreshValueImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortFreshValue()
     * @generated
     */
    EClass PORT_FRESH_VALUE = eINSTANCE.getPortFreshValue();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl <em>Port Send Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortSendActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortSendAction()
     * @generated
     */
    EClass PORT_SEND_ACTION = eINSTANCE.getPortSendAction();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_SEND_ACTION__PORT = eINSTANCE.getPortSendAction_Port();

    /**
     * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_SEND_ACTION__VALUE_EXPRESSION = eINSTANCE.getPortSendAction_ValueExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl <em>Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.RelationImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelation()
     * @generated
     */
    EClass RELATION = eINSTANCE.getRelation();

    /**
     * The meta object literal for the '<em><b>First Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATION__FIRST_EXPRESSION = eINSTANCE.getRelation_FirstExpression();

    /**
     * The meta object literal for the '<em><b>Second Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATION__SECOND_EXPRESSION = eINSTANCE.getRelation_SecondExpression();

    /**
     * The meta object literal for the '<em><b>Relational Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__RELATIONAL_OPERATOR = eINSTANCE.getRelation_RelationalOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl <em>Shared Data Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SharedDataActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSharedDataAction()
     * @generated
     */
    EClass SHARED_DATA_ACTION = eINSTANCE.getSharedDataAction();

    /**
     * The meta object literal for the '<em><b>Data Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHARED_DATA_ACTION__DATA_ACCESS = eINSTANCE.getSharedDataAction_DataAccess();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl <em>Simple Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SimpleExpressionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSimpleExpression()
     * @generated
     */
    EClass SIMPLE_EXPRESSION = eINSTANCE.getSimpleExpression();

    /**
     * The meta object literal for the '<em><b>Unary Adding Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR = eINSTANCE.getSimpleExpression_UnaryAddingOperator();

    /**
     * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_EXPRESSION__TERMS = eINSTANCE.getSimpleExpression_Terms();

    /**
     * The meta object literal for the '<em><b>Binary Adding Operators</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS = eINSTANCE.getSimpleExpression_BinaryAddingOperators();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl <em>Subprogram Call Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramCallActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramCallAction()
     * @generated
     */
    EClass SUBPROGRAM_CALL_ACTION = eINSTANCE.getSubprogramCallAction();

    /**
     * The meta object literal for the '<em><b>Subprogram</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBPROGRAM_CALL_ACTION__SUBPROGRAM = eINSTANCE.getSubprogramCallAction_Subprogram();

    /**
     * The meta object literal for the '<em><b>Parameter Labels</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS = eINSTANCE.getSubprogramCallAction_ParameterLabels();

    /**
     * The meta object literal for the '<em><b>Data Access</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBPROGRAM_CALL_ACTION__DATA_ACCESS = eINSTANCE.getSubprogramCallAction_DataAccess();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl <em>Target</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTarget()
     * @generated
     */
    EClass TARGET = eINSTANCE.getTarget();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TermImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTerm()
     * @generated
     */
    EClass TERM = eINSTANCE.getTerm();

    /**
     * The meta object literal for the '<em><b>Factors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERM__FACTORS = eINSTANCE.getTerm_Factors();

    /**
     * The meta object literal for the '<em><b>Multiplying Operators</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERM__MULTIPLYING_OPERATORS = eINSTANCE.getTerm_MultiplyingOperators();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl <em>Timed Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getTimedAction()
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
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl <em>Unlock Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.UnlockActionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnlockAction()
     * @generated
     */
    EClass UNLOCK_ACTION = eINSTANCE.getUnlockAction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.Value <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.Value
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueConstant <em>Value Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.ValueConstant
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueConstant()
     * @generated
     */
    EClass VALUE_CONSTANT = eINSTANCE.getValueConstant();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl <em>Value Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ValueExpressionImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueExpression()
     * @generated
     */
    EClass VALUE_EXPRESSION = eINSTANCE.getValueExpression();

    /**
     * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_EXPRESSION__RELATIONS = eINSTANCE.getValueExpression_Relations();

    /**
     * The meta object literal for the '<em><b>Logical Operators</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_EXPRESSION__LOGICAL_OPERATORS = eINSTANCE.getValueExpression_LogicalOperators();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable <em>Value Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.ValueVariable
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getValueVariable()
     * @generated
     */
    EClass VALUE_VARIABLE = eINSTANCE.getValueVariable();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl <em>While Or Do Until Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.WhileOrDoUntilStatementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getWhileOrDoUntilStatement()
     * @generated
     */
    EClass WHILE_OR_DO_UNTIL_STATEMENT = eINSTANCE.getWhileOrDoUntilStatement();

    /**
     * The meta object literal for the '<em><b>Logical Value Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION = eINSTANCE.getWhileOrDoUntilStatement_LogicalValueExpression();

    /**
     * The meta object literal for the '<em><b>Do Until</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL = eINSTANCE.getWhileOrDoUntilStatement_DoUntil();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ActualPortHolderImpl <em>Actual Port Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ActualPortHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getActualPortHolder()
     * @generated
     */
    EClass ACTUAL_PORT_HOLDER = eINSTANCE.getActualPortHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ExecutionTimeoutCatchImpl <em>Execution Timeout Catch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ExecutionTimeoutCatchImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getExecutionTimeoutCatch()
     * @generated
     */
    EClass EXECUTION_TIMEOUT_CATCH = eINSTANCE.getExecutionTimeoutCatch();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchRelativeTimeoutImpl <em>Dispatch Relative Timeout</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchRelativeTimeoutImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchRelativeTimeout()
     * @generated
     */
    EClass DISPATCH_RELATIVE_TIMEOUT = eINSTANCE.getDispatchRelativeTimeout();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataHolderImpl <em>Data Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataHolder()
     * @generated
     */
    EClass DATA_HOLDER = eINSTANCE.getDataHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramHolderImpl <em>Subprogram Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramHolder()
     * @generated
     */
    EClass SUBPROGRAM_HOLDER = eINSTANCE.getSubprogramHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableImpl <em>Iterative Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIterativeVariable()
     * @generated
     */
    EClass ITERATIVE_VARIABLE = eINSTANCE.getIterativeVariable();

    /**
     * The meta object literal for the '<em><b>Data Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ITERATIVE_VARIABLE__DATA_CLASSIFIER = eINSTANCE.getIterativeVariable_DataClassifier();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessHolderImpl <em>Data Access Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataAccessHolder()
     * @generated
     */
    EClass DATA_ACCESS_HOLDER = eINSTANCE.getDataAccessHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataSubcomponentHolderImpl <em>Data Subcomponent Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataSubcomponentHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataSubcomponentHolder()
     * @generated
     */
    EClass DATA_SUBCOMPONENT_HOLDER = eINSTANCE.getDataSubcomponentHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableHolderImpl <em>Behavior Variable Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorVariableHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorVariableHolder()
     * @generated
     */
    EClass BEHAVIOR_VARIABLE_HOLDER = eINSTANCE.getBehaviorVariableHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.ElementHolder <em>Element Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.ElementHolder
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getElementHolder()
     * @generated
     */
    EClass ELEMENT_HOLDER = eINSTANCE.getElementHolder();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_HOLDER__ELEMENT = eINSTANCE.getElementHolder_Element();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataPortHolderImpl <em>Data Port Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataPortHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataPortHolder()
     * @generated
     */
    EClass DATA_PORT_HOLDER = eINSTANCE.getDataPortHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.EventPortHolderImpl <em>Event Port Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.EventPortHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getEventPortHolder()
     * @generated
     */
    EClass EVENT_PORT_HOLDER = eINSTANCE.getEventPortHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.EventDataPortHolderImpl <em>Event Data Port Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.EventDataPortHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getEventDataPortHolder()
     * @generated
     */
    EClass EVENT_DATA_PORT_HOLDER = eINSTANCE.getEventDataPortHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterHolderImpl <em>Parameter Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.ParameterHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getParameterHolder()
     * @generated
     */
    EClass PARAMETER_HOLDER = eINSTANCE.getParameterHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramAccessHolderImpl <em>Subprogram Access Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramAccessHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramAccessHolder()
     * @generated
     */
    EClass SUBPROGRAM_ACCESS_HOLDER = eINSTANCE.getSubprogramAccessHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger <em>Dispatch Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDispatchTrigger()
     * @generated
     */
    EClass DISPATCH_TRIGGER = eINSTANCE.getDispatchTrigger();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyImpl <em>Behavior Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorPropertyImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorProperty()
     * @generated
     */
    EClass BEHAVIOR_PROPERTY = eINSTANCE.getBehaviorProperty();

    /**
     * The meta object literal for the '<em><b>Property Set</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BEHAVIOR_PROPERTY__PROPERTY_SET = eINSTANCE.getBehaviorProperty_PropertySet();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.AnyImpl <em>Any</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AnyImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getAny()
     * @generated
     */
    EClass ANY = eINSTANCE.getAny();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.GroupHolderImpl <em>Group Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.GroupHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGroupHolder()
     * @generated
     */
    EClass GROUP_HOLDER = eINSTANCE.getGroupHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.CalledSubprogramHolderImpl <em>Called Subprogram Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.CalledSubprogramHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getCalledSubprogramHolder()
     * @generated
     */
    EClass CALLED_SUBPROGRAM_HOLDER = eINSTANCE.getCalledSubprogramHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.IndexableElement <em>Indexable Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.IndexableElement
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIndexableElement()
     * @generated
     */
    EClass INDEXABLE_ELEMENT = eINSTANCE.getIndexableElement();

    /**
     * The meta object literal for the '<em><b>Array Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDEXABLE_ELEMENT__ARRAY_INDEXES = eINSTANCE.getIndexableElement_ArrayIndexes();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.GroupableElement <em>Groupable Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.GroupableElement
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGroupableElement()
     * @generated
     */
    EClass GROUPABLE_ELEMENT = eINSTANCE.getGroupableElement();

    /**
     * The meta object literal for the '<em><b>Group Holders</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUPABLE_ELEMENT__GROUP_HOLDERS = eINSTANCE.getGroupableElement_GroupHolders();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortHolderImpl <em>Port Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortHolder()
     * @generated
     */
    EClass PORT_HOLDER = eINSTANCE.getPortHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.PortPrototypeHolderImpl <em>Port Prototype Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.PortPrototypeHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPortPrototypeHolder()
     * @generated
     */
    EClass PORT_PROTOTYPE_HOLDER = eINSTANCE.getPortPrototypeHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder <em>Prototype Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.PrototypeHolder
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getPrototypeHolder()
     * @generated
     */
    EClass PROTOTYPE_HOLDER = eINSTANCE.getPrototypeHolder();

    /**
     * The meta object literal for the '<em><b>Prototype Binding</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROTOTYPE_HOLDER__PROTOTYPE_BINDING = eINSTANCE.getPrototypeHolder_PrototypeBinding();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessPrototypeHolderImpl <em>Data Access Prototype Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.DataAccessPrototypeHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataAccessPrototypeHolder()
     * @generated
     */
    EClass DATA_ACCESS_PROTOTYPE_HOLDER = eINSTANCE.getDataAccessPrototypeHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramPrototypeHolderImpl <em>Subprogram Prototype Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.SubprogramPrototypeHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getSubprogramPrototypeHolder()
     * @generated
     */
    EClass SUBPROGRAM_PROTOTYPE_HOLDER = eINSTANCE.getSubprogramPrototypeHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.GroupPrototypeHolderImpl <em>Group Prototype Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.GroupPrototypeHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getGroupPrototypeHolder()
     * @generated
     */
    EClass GROUP_PROTOTYPE_HOLDER = eINSTANCE.getGroupPrototypeHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementImpl <em>Struct Union Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getStructUnionElement()
     * @generated
     */
    EClass STRUCT_UNION_ELEMENT = eINSTANCE.getStructUnionElement();

    /**
     * The meta object literal for the '<em><b>Data Classifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT_UNION_ELEMENT__DATA_CLASSIFIER = eINSTANCE.getStructUnionElement_DataClassifier();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementHolderImpl <em>Struct Union Element Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.StructUnionElementHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getStructUnionElementHolder()
     * @generated
     */
    EClass STRUCT_UNION_ELEMENT_HOLDER = eINSTANCE.getStructUnionElementHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableHolderImpl <em>Iterative Variable Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.IterativeVariableHolderImpl
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getIterativeVariableHolder()
     * @generated
     */
    EClass ITERATIVE_VARIABLE_HOLDER = eINSTANCE.getIterativeVariableHolder();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorFeatureType <em>Behavior Feature Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BehaviorFeatureType
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBehaviorFeatureType()
     * @generated
     */
    EEnum BEHAVIOR_FEATURE_TYPE = eINSTANCE.getBehaviorFeatureType();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator <em>Binary Adding Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryAddingOperator()
     * @generated
     */
    EEnum BINARY_ADDING_OPERATOR = eINSTANCE.getBinaryAddingOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator <em>Binary Numeric Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBinaryNumericOperator()
     * @generated
     */
    EEnum BINARY_NUMERIC_OPERATOR = eINSTANCE.getBinaryNumericOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation <em>Data Representation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getDataRepresentation()
     * @generated
     */
    EEnum DATA_REPRESENTATION = eINSTANCE.getDataRepresentation();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.FeatureType <em>Feature Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.FeatureType
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getFeatureType()
     * @generated
     */
    EEnum FEATURE_TYPE = eINSTANCE.getFeatureType();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator <em>Logical Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getLogicalOperator()
     * @generated
     */
    EEnum LOGICAL_OPERATOR = eINSTANCE.getLogicalOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator <em>Multiplying Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getMultiplyingOperator()
     * @generated
     */
    EEnum MULTIPLYING_OPERATOR = eINSTANCE.getMultiplyingOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator <em>Unary Adding Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryAddingOperator()
     * @generated
     */
    EEnum UNARY_ADDING_OPERATOR = eINSTANCE.getUnaryAddingOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator <em>Unary Boolean Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryBooleanOperator()
     * @generated
     */
    EEnum UNARY_BOOLEAN_OPERATOR = eINSTANCE.getUnaryBooleanOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator <em>Unary Numeric Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getUnaryNumericOperator()
     * @generated
     */
    EEnum UNARY_NUMERIC_OPERATOR = eINSTANCE.getUnaryNumericOperator();

    /**
     * The meta object literal for the '<em>Boolean</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getBoolean()
     * @generated
     */
    EDataType BOOLEAN = eINSTANCE.getBoolean();

    /**
     * The meta object literal for the '<em>Integer</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getInteger()
     * @generated
     */
    EDataType INTEGER = eINSTANCE.getInteger();

    /**
     * The meta object literal for the '<em>Real</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getReal()
     * @generated
     */
    EDataType REAL = eINSTANCE.getReal();

    /**
     * The meta object literal for the '<em>String</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see fr.tpt.aadl.annex.behavior.aadlba.impl.AadlBaPackageImpl#getString()
     * @generated
     */
    EDataType STRING = eINSTANCE.getString();

  }

} //AadlBaPackage
