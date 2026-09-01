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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage
 * @generated
 */
public interface BehaviorAnnexFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BehaviorAnnexFactory eINSTANCE = org.osate.xtext.aadl2.ba.behaviorAnnex.impl.BehaviorAnnexFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Behavior Annex</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Annex</em>'.
   * @generated
   */
  BehaviorAnnex createBehaviorAnnex();

  /**
   * Returns a new object of class '<em>Behavior Variable Group</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Variable Group</em>'.
   * @generated
   */
  BehaviorVariableGroup createBehaviorVariableGroup();

  /**
   * Returns a new object of class '<em>Behavior Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Variable</em>'.
   * @generated
   */
  BehaviorVariable createBehaviorVariable();

  /**
   * Returns a new object of class '<em>Array Dimension</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Dimension</em>'.
   * @generated
   */
  ArrayDimension createArrayDimension();

  /**
   * Returns a new object of class '<em>Behavior Property Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Property Association</em>'.
   * @generated
   */
  BehaviorPropertyAssociation createBehaviorPropertyAssociation();

  /**
   * Returns a new object of class '<em>Behavior State Group</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior State Group</em>'.
   * @generated
   */
  BehaviorStateGroup createBehaviorStateGroup();

  /**
   * Returns a new object of class '<em>Behavior State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior State</em>'.
   * @generated
   */
  BehaviorState createBehaviorState();

  /**
   * Returns a new object of class '<em>Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Transition</em>'.
   * @generated
   */
  BehaviorTransition createBehaviorTransition();

  /**
   * Returns a new object of class '<em>Behavior Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Condition</em>'.
   * @generated
   */
  BehaviorCondition createBehaviorCondition();

  /**
   * Returns a new object of class '<em>Execute Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Execute Condition</em>'.
   * @generated
   */
  ExecuteCondition createExecuteCondition();

  /**
   * Returns a new object of class '<em>Dispatch Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Condition</em>'.
   * @generated
   */
  DispatchCondition createDispatchCondition();

  /**
   * Returns a new object of class '<em>Dispatch Trigger Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Trigger Condition</em>'.
   * @generated
   */
  DispatchTriggerCondition createDispatchTriggerCondition();

  /**
   * Returns a new object of class '<em>Dispatch Trigger Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Trigger Logical Expression</em>'.
   * @generated
   */
  DispatchTriggerLogicalExpression createDispatchTriggerLogicalExpression();

  /**
   * Returns a new object of class '<em>Dispatch Conjunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Conjunction</em>'.
   * @generated
   */
  DispatchConjunction createDispatchConjunction();

  /**
   * Returns a new object of class '<em>Mode Switch Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mode Switch Condition</em>'.
   * @generated
   */
  ModeSwitchCondition createModeSwitchCondition();

  /**
   * Returns a new object of class '<em>Mode Switch Conjunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mode Switch Conjunction</em>'.
   * @generated
   */
  ModeSwitchConjunction createModeSwitchConjunction();

  /**
   * Returns a new object of class '<em>Behavior Action Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Action Block</em>'.
   * @generated
   */
  BehaviorActionBlock createBehaviorActionBlock();

  /**
   * Returns a new object of class '<em>Behavior Actions</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Actions</em>'.
   * @generated
   */
  BehaviorActions createBehaviorActions();

  /**
   * Returns a new object of class '<em>Behavior Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Action</em>'.
   * @generated
   */
  BehaviorAction createBehaviorAction();

  /**
   * Returns a new object of class '<em>Assignment Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Action</em>'.
   * @generated
   */
  AssignmentAction createAssignmentAction();

  /**
   * Returns a new object of class '<em>Communication Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Communication Action</em>'.
   * @generated
   */
  CommunicationAction createCommunicationAction();

  /**
   * Returns a new object of class '<em>Timed Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timed Action</em>'.
   * @generated
   */
  TimedAction createTimedAction();

  /**
   * Returns a new object of class '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Statement</em>'.
   * @generated
   */
  IfStatement createIfStatement();

  /**
   * Returns a new object of class '<em>Else If Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Else If Clause</em>'.
   * @generated
   */
  ElseIfClause createElseIfClause();

  /**
   * Returns a new object of class '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Statement</em>'.
   * @generated
   */
  ForStatement createForStatement();

  /**
   * Returns a new object of class '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Statement</em>'.
   * @generated
   */
  WhileStatement createWhileStatement();

  /**
   * Returns a new object of class '<em>Do Until Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Do Until Statement</em>'.
   * @generated
   */
  DoUntilStatement createDoUntilStatement();

  /**
   * Returns a new object of class '<em>Element Values</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element Values</em>'.
   * @generated
   */
  ElementValues createElementValues();

  /**
   * Returns a new object of class '<em>Behavior Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Time</em>'.
   * @generated
   */
  BehaviorTime createBehaviorTime();

  /**
   * Returns a new object of class '<em>Integer Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Value</em>'.
   * @generated
   */
  IntegerValue createIntegerValue();

  /**
   * Returns a new object of class '<em>Value Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Expression</em>'.
   * @generated
   */
  ValueExpression createValueExpression();

  /**
   * Returns a new object of class '<em>Value Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Constant</em>'.
   * @generated
   */
  ValueConstant createValueConstant();

  /**
   * Returns a new object of class '<em>Behavior Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Integer Literal</em>'.
   * @generated
   */
  BehaviorIntegerLiteral createBehaviorIntegerLiteral();

  /**
   * Returns a new object of class '<em>Behavior Real Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Real Literal</em>'.
   * @generated
   */
  BehaviorRealLiteral createBehaviorRealLiteral();

  /**
   * Returns a new object of class '<em>Behavior String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior String Literal</em>'.
   * @generated
   */
  BehaviorStringLiteral createBehaviorStringLiteral();

  /**
   * Returns a new object of class '<em>Behavior Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Boolean Literal</em>'.
   * @generated
   */
  BehaviorBooleanLiteral createBehaviorBooleanLiteral();

  /**
   * Returns a new object of class '<em>Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference Expression</em>'.
   * @generated
   */
  ReferenceExpression createReferenceExpression();

  /**
   * Returns a new object of class '<em>Hash Property Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hash Property Reference</em>'.
   * @generated
   */
  HashPropertyReference createHashPropertyReference();

  /**
   * Returns a new object of class '<em>Property Reference Tail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Reference Tail</em>'.
   * @generated
   */
  PropertyReferenceTail createPropertyReferenceTail();

  /**
   * Returns a new object of class '<em>Named Property Field</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Property Field</em>'.
   * @generated
   */
  NamedPropertyField createNamedPropertyField();

  /**
   * Returns a new object of class '<em>Property Array Index</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Array Index</em>'.
   * @generated
   */
  PropertyArrayIndex createPropertyArrayIndex();

  /**
   * Returns a new object of class '<em>Property Index Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Index Value</em>'.
   * @generated
   */
  PropertyIndexValue createPropertyIndexValue();

  /**
   * Returns a new object of class '<em>Property Index Property Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Index Property Reference</em>'.
   * @generated
   */
  PropertyIndexPropertyReference createPropertyIndexPropertyReference();

  /**
   * Returns a new object of class '<em>Unindexed Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unindexed Reference Expression</em>'.
   * @generated
   */
  UnindexedReferenceExpression createUnindexedReferenceExpression();

  /**
   * Returns a new object of class '<em>Unindexed Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unindexed Reference</em>'.
   * @generated
   */
  UnindexedReference createUnindexedReference();

  /**
   * Returns a new object of class '<em>Unindexed Reference Tail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unindexed Reference Tail</em>'.
   * @generated
   */
  UnindexedReferenceTail createUnindexedReferenceTail();

  /**
   * Returns a new object of class '<em>Unindexed Reference Segment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unindexed Reference Segment</em>'.
   * @generated
   */
  UnindexedReferenceSegment createUnindexedReferenceSegment();

  /**
   * Returns a new object of class '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference</em>'.
   * @generated
   */
  Reference createReference();

  /**
   * Returns a new object of class '<em>Reference Tail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference Tail</em>'.
   * @generated
   */
  ReferenceTail createReferenceTail();

  /**
   * Returns a new object of class '<em>Reference Segment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference Segment</em>'.
   * @generated
   */
  ReferenceSegment createReferenceSegment();

  /**
   * Returns a new object of class '<em>Array Index</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Index</em>'.
   * @generated
   */
  ArrayIndex createArrayIndex();

  /**
   * Returns a new object of class '<em>Behavior Action Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Action Sequence</em>'.
   * @generated
   */
  BehaviorActionSequence createBehaviorActionSequence();

  /**
   * Returns a new object of class '<em>Behavior Action Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Action Set</em>'.
   * @generated
   */
  BehaviorActionSet createBehaviorActionSet();

  /**
   * Returns a new object of class '<em>Binary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Expression</em>'.
   * @generated
   */
  BinaryExpression createBinaryExpression();

  /**
   * Returns a new object of class '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expression</em>'.
   * @generated
   */
  UnaryExpression createUnaryExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  BehaviorAnnexPackage getBehaviorAnnexPackage();

} //BehaviorAnnexFactory
