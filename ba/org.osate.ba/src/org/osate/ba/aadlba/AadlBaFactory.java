/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.ba.aadlba.AadlBaPackage
 * @generated
 */
public interface AadlBaFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AadlBaFactory eINSTANCE = org.osate.ba.aadlba.impl.AadlBaFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Assignment Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Action</em>'.
   * @generated
   */
  AssignmentAction createAssignmentAction();

  /**
   * Returns a new object of class '<em>Any</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Any</em>'.
   * @generated
   */
  Any createAny();

  /**
   * Returns a new object of class '<em>Basic Property Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Basic Property Holder</em>'.
   * @generated
   */
  BasicPropertyHolder createBasicPropertyHolder();

  /**
   * Returns a new object of class '<em>Behavior Action Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Action Block</em>'.
   * @generated
   */
  BehaviorActionBlock createBehaviorActionBlock();

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
   * Returns a new object of class '<em>Behavior Annex</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Annex</em>'.
   * @generated
   */
  BehaviorAnnex createBehaviorAnnex();

  /**
   * Returns a new object of class '<em>Behavior Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Boolean Literal</em>'.
   * @generated
   */
  BehaviorBooleanLiteral createBehaviorBooleanLiteral();

  /**
   * Returns a new object of class '<em>Behavior Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Integer Literal</em>'.
   * @generated
   */
  BehaviorIntegerLiteral createBehaviorIntegerLiteral();

  /**
   * Returns a new object of class '<em>Behavior Property Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Property Constant</em>'.
   * @generated
   */
  BehaviorPropertyConstant createBehaviorPropertyConstant();

  /**
   * Returns a new object of class '<em>Behavior Real Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Real Literal</em>'.
   * @generated
   */
  BehaviorRealLiteral createBehaviorRealLiteral();

  /**
   * Returns a new object of class '<em>Behavior State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior State</em>'.
   * @generated
   */
  BehaviorState createBehaviorState();

  /**
   * Returns a new object of class '<em>Behavior String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior String Literal</em>'.
   * @generated
   */
  BehaviorStringLiteral createBehaviorStringLiteral();

  /**
   * Returns a new object of class '<em>Behavior Time</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Time</em>'.
   * @generated
   */
  BehaviorTime createBehaviorTime();

  /**
   * Returns a new object of class '<em>Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Transition</em>'.
   * @generated
   */
  BehaviorTransition createBehaviorTransition();

  /**
   * Returns a new object of class '<em>Behavior Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Variable</em>'.
   * @generated
   */
  BehaviorVariable createBehaviorVariable();

  /**
   * Returns a new object of class '<em>Behavior Variable Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Variable Holder</em>'.
   * @generated
   */
  BehaviorVariableHolder createBehaviorVariableHolder();

  /**
   * Returns a new object of class '<em>Called Subprogram Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Called Subprogram Holder</em>'.
   * @generated
   */
  CalledSubprogramHolder createCalledSubprogramHolder();

  /**
   * Returns a new object of class '<em>Completion Relative Timeout</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Completion Relative Timeout</em>'.
   * @generated
   */
  CompletionRelativeTimeout createCompletionRelativeTimeout();

  /**
   * Returns a new object of class '<em>Classifier Feature Property Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Feature Property Reference</em>'.
   * @generated
   */
  ClassifierFeaturePropertyReference createClassifierFeaturePropertyReference();

  /**
   * Returns a new object of class '<em>Data Access Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Access Holder</em>'.
   * @generated
   */
  DataAccessHolder createDataAccessHolder();

  /**
   * Returns a new object of class '<em>Data Access Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Access Prototype Holder</em>'.
   * @generated
   */
  DataAccessPrototypeHolder createDataAccessPrototypeHolder();

  /**
   * Returns a new object of class '<em>Data Component Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Component Reference</em>'.
   * @generated
   */
  DataComponentReference createDataComponentReference();

  /**
   * Returns a new object of class '<em>Data Port Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Port Holder</em>'.
   * @generated
   */
  DataPortHolder createDataPortHolder();

  /**
   * Returns a new object of class '<em>Data Subcomponent Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Subcomponent Holder</em>'.
   * @generated
   */
  DataSubcomponentHolder createDataSubcomponentHolder();

  /**
   * Returns a new object of class '<em>Dispatch Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Condition</em>'.
   * @generated
   */
  DispatchCondition createDispatchCondition();

  /**
   * Returns a new object of class '<em>Dispatch Conjunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Conjunction</em>'.
   * @generated
   */
  DispatchConjunction createDispatchConjunction();

  /**
   * Returns a new object of class '<em>Dispatch Relative Timeout</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Relative Timeout</em>'.
   * @generated
   */
  DispatchRelativeTimeout createDispatchRelativeTimeout();

  /**
   * Returns a new object of class '<em>Dispatch Trigger Condition Stop</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Trigger Condition Stop</em>'.
   * @generated
   */
  DispatchTriggerConditionStop createDispatchTriggerConditionStop();

  /**
   * Returns a new object of class '<em>Dispatch Trigger Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dispatch Trigger Logical Expression</em>'.
   * @generated
   */
  DispatchTriggerLogicalExpression createDispatchTriggerLogicalExpression();

  /**
   * Returns a new object of class '<em>Else Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Else Statement</em>'.
   * @generated
   */
  ElseStatement createElseStatement();

  /**
   * Returns a new object of class '<em>Enum Literal Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Literal Holder</em>'.
   * @generated
   */
  EnumLiteralHolder createEnumLiteralHolder();

  /**
   * Returns a new object of class '<em>Event Data Port Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Data Port Holder</em>'.
   * @generated
   */
  EventDataPortHolder createEventDataPortHolder();

  /**
   * Returns a new object of class '<em>Event Port Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Port Holder</em>'.
   * @generated
   */
  EventPortHolder createEventPortHolder();

  /**
   * Returns a new object of class '<em>Execution Timeout Catch</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Execution Timeout Catch</em>'.
   * @generated
   */
  ExecutionTimeoutCatch createExecutionTimeoutCatch();

  /**
   * Returns a new object of class '<em>Factor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Factor</em>'.
   * @generated
   */
  Factor createFactor();

  /**
   * Returns a new object of class '<em>Feature Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Prototype Holder</em>'.
   * @generated
   */
  FeaturePrototypeHolder createFeaturePrototypeHolder();

  /**
   * Returns a new object of class '<em>For Or For All Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Or For All Statement</em>'.
   * @generated
   */
  ForOrForAllStatement createForOrForAllStatement();

  /**
   * Returns a new object of class '<em>Group Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Group Holder</em>'.
   * @generated
   */
  GroupHolder createGroupHolder();

  /**
   * Returns a new object of class '<em>Group Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Group Prototype Holder</em>'.
   * @generated
   */
  GroupPrototypeHolder createGroupPrototypeHolder();

  /**
   * Returns a new object of class '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Statement</em>'.
   * @generated
   */
  IfStatement createIfStatement();

  /**
   * Returns a new object of class '<em>Integer Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Range</em>'.
   * @generated
   */
  IntegerRange createIntegerRange();

  /**
   * Returns a new object of class '<em>Iterative Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iterative Variable</em>'.
   * @generated
   */
  IterativeVariable createIterativeVariable();

  /**
   * Returns a new object of class '<em>Iterative Variable Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iterative Variable Holder</em>'.
   * @generated
   */
  IterativeVariableHolder createIterativeVariableHolder();

  /**
   * Returns a new object of class '<em>Lock Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lock Action</em>'.
   * @generated
   */
  LockAction createLockAction();

  /**
   * Returns a new object of class '<em>Otherwise</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Otherwise</em>'.
   * @generated
   */
  Otherwise createOtherwise();

  /**
   * Returns a new object of class '<em>Parameter Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Holder</em>'.
   * @generated
   */
  ParameterHolder createParameterHolder();

  /**
   * Returns a new object of class '<em>Port Count Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Count Value</em>'.
   * @generated
   */
  PortCountValue createPortCountValue();

  /**
   * Returns a new object of class '<em>Port Dequeue Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Dequeue Action</em>'.
   * @generated
   */
  PortDequeueAction createPortDequeueAction();

  /**
   * Returns a new object of class '<em>Port Dequeue Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Dequeue Value</em>'.
   * @generated
   */
  PortDequeueValue createPortDequeueValue();

  /**
   * Returns a new object of class '<em>Port Freeze Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Freeze Action</em>'.
   * @generated
   */
  PortFreezeAction createPortFreezeAction();

  /**
   * Returns a new object of class '<em>Port Fresh Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Fresh Value</em>'.
   * @generated
   */
  PortFreshValue createPortFreshValue();

  /**
   * Returns a new object of class '<em>Port Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Prototype Holder</em>'.
   * @generated
   */
  PortPrototypeHolder createPortPrototypeHolder();

  /**
   * Returns a new object of class '<em>Port Send Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Port Send Action</em>'.
   * @generated
   */
  PortSendAction createPortSendAction();

  /**
   * Returns a new object of class '<em>Property Name Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Name Holder</em>'.
   * @generated
   */
  PropertyNameHolder createPropertyNameHolder();

  /**
   * Returns a new object of class '<em>Property Association Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Association Holder</em>'.
   * @generated
   */
  PropertyAssociationHolder createPropertyAssociationHolder();

  /**
   * Returns a new object of class '<em>Property Expression Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Expression Holder</em>'.
   * @generated
   */
  PropertyExpressionHolder createPropertyExpressionHolder();

  /**
   * Returns a new object of class '<em>Property Type Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Type Holder</em>'.
   * @generated
   */
  PropertyTypeHolder createPropertyTypeHolder();

  /**
   * Returns a new object of class '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation</em>'.
   * @generated
   */
  Relation createRelation();

  /**
   * Returns a new object of class '<em>Simple Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Expression</em>'.
   * @generated
   */
  SimpleExpression createSimpleExpression();

  /**
   * Returns a new object of class '<em>Struct Union Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Union Element</em>'.
   * @generated
   */
  StructUnionElement createStructUnionElement();

  /**
   * Returns a new object of class '<em>Struct Union Element Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Struct Union Element Holder</em>'.
   * @generated
   */
  StructUnionElementHolder createStructUnionElementHolder();

  /**
   * Returns a new object of class '<em>Subprogram Access Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subprogram Access Holder</em>'.
   * @generated
   */
  SubprogramAccessHolder createSubprogramAccessHolder();

  /**
   * Returns a new object of class '<em>Subprogram Call Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subprogram Call Action</em>'.
   * @generated
   */
  SubprogramCallAction createSubprogramCallAction();

  /**
   * Returns a new object of class '<em>Subprogram Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subprogram Holder</em>'.
   * @generated
   */
  SubprogramHolder createSubprogramHolder();

  /**
   * Returns a new object of class '<em>Subprogram Holder Proxy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subprogram Holder Proxy</em>'.
   * @generated
   */
  SubprogramHolderProxy createSubprogramHolderProxy();

  /**
   * Returns a new object of class '<em>Subprogram Prototype Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subprogram Prototype Holder</em>'.
   * @generated
   */
  SubprogramPrototypeHolder createSubprogramPrototypeHolder();

  /**
   * Returns a new object of class '<em>Target</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Target</em>'.
   * @generated
   */
  Target createTarget();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  Term createTerm();

  /**
   * Returns a new object of class '<em>Timed Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timed Action</em>'.
   * @generated
   */
  TimedAction createTimedAction();

  /**
   * Returns a new object of class '<em>Unlock Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unlock Action</em>'.
   * @generated
   */
  UnlockAction createUnlockAction();

  /**
   * Returns a new object of class '<em>Value Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Expression</em>'.
   * @generated
   */
  ValueExpression createValueExpression();

  /**
   * Returns a new object of class '<em>While Or Do Until Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Or Do Until Statement</em>'.
   * @generated
   */
  WhileOrDoUntilStatement createWhileOrDoUntilStatement();

  /**
   * Returns a new object of class '<em>Mode Switch Trigger Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mode Switch Trigger Logical Expression</em>'.
   * @generated
   */
  ModeSwitchTriggerLogicalExpression createModeSwitchTriggerLogicalExpression();

  /**
   * Returns a new object of class '<em>Mode Switch Conjunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mode Switch Conjunction</em>'.
   * @generated
   */
  ModeSwitchConjunction createModeSwitchConjunction();

  /**
   * Returns a new object of class '<em>Property Set Property Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Set Property Reference</em>'.
   * @generated
   */
  PropertySetPropertyReference createPropertySetPropertyReference();

  /**
   * Returns a new object of class '<em>Subcomponent Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subcomponent Holder</em>'.
   * @generated
   */
  SubcomponentHolder createSubcomponentHolder();

  /**
   * Returns a new object of class '<em>Subprogram Subcomponent Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subprogram Subcomponent Holder</em>'.
   * @generated
   */
  SubprogramSubcomponentHolder createSubprogramSubcomponentHolder();

  /**
   * Returns a new object of class '<em>Feature Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Holder</em>'.
   * @generated
   */
  FeatureHolder createFeatureHolder();

  /**
   * Returns a new object of class '<em>Classifier Property Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Property Reference</em>'.
   * @generated
   */
  ClassifierPropertyReference createClassifierPropertyReference();

  /**
   * Returns a new object of class '<em>Upper Bound</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Upper Bound</em>'.
   * @generated
   */
  UpperBound createUpperBound();

  /**
   * Returns a new object of class '<em>Lower Bound</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lower Bound</em>'.
   * @generated
   */
  LowerBound createLowerBound();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AadlBaPackage getAadlBaPackage();

} //AadlBaFactory
