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
package org.osate.ba.aadlba.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;
import org.osate.ba.aadlba.AadlBaFactory;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.ActualPortHolder;
import org.osate.ba.aadlba.Any;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BasicAction;
import org.osate.ba.aadlba.BasicPropertyHolder;
import org.osate.ba.aadlba.BehaviorAction;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorActionCollection;
import org.osate.ba.aadlba.BehaviorActionSequence;
import org.osate.ba.aadlba.BehaviorActionSet;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorBooleanLiteral;
import org.osate.ba.aadlba.BehaviorCondition;
import org.osate.ba.aadlba.BehaviorElement;
import org.osate.ba.aadlba.BehaviorFeatureType;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.BehaviorNamedElement;
import org.osate.ba.aadlba.BehaviorPropertyConstant;
import org.osate.ba.aadlba.BehaviorRealLiteral;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorStringLiteral;
import org.osate.ba.aadlba.BehaviorTime;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.BehaviorVariableHolder;
import org.osate.ba.aadlba.BinaryAddingOperator;
import org.osate.ba.aadlba.BinaryNumericOperator;
import org.osate.ba.aadlba.CalledSubprogramHolder;
import org.osate.ba.aadlba.ClassifierFeatureHolder;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;
import org.osate.ba.aadlba.ClassifierPropertyReference;
import org.osate.ba.aadlba.CommunicationAction;
import org.osate.ba.aadlba.CompletionRelativeTimeout;
import org.osate.ba.aadlba.CondStatement;
import org.osate.ba.aadlba.DataAccessHolder;
import org.osate.ba.aadlba.DataAccessPrototypeHolder;
import org.osate.ba.aadlba.DataComponentReference;
import org.osate.ba.aadlba.DataHolder;
import org.osate.ba.aadlba.DataPortHolder;
import org.osate.ba.aadlba.DataRepresentation;
import org.osate.ba.aadlba.DataSubcomponentHolder;
import org.osate.ba.aadlba.DispatchCondition;
import org.osate.ba.aadlba.DispatchConjunction;
import org.osate.ba.aadlba.DispatchRelativeTimeout;
import org.osate.ba.aadlba.DispatchTrigger;
import org.osate.ba.aadlba.DispatchTriggerCondition;
import org.osate.ba.aadlba.DispatchTriggerConditionStop;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.ba.aadlba.ElementValues;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.EnumLiteralHolder;
import org.osate.ba.aadlba.EventDataPortHolder;
import org.osate.ba.aadlba.EventPortHolder;
import org.osate.ba.aadlba.ExecuteCondition;
import org.osate.ba.aadlba.ExecutionTimeoutCatch;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.FeatureHolder;
import org.osate.ba.aadlba.FeaturePrototypeHolder;
import org.osate.ba.aadlba.FeatureType;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.GroupHolder;
import org.osate.ba.aadlba.GroupPrototypeHolder;
import org.osate.ba.aadlba.GroupableElement;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.IndexableElement;
import org.osate.ba.aadlba.IntegerRange;
import org.osate.ba.aadlba.IntegerValue;
import org.osate.ba.aadlba.IntegerValueConstant;
import org.osate.ba.aadlba.IntegerValueVariable;
import org.osate.ba.aadlba.IterativeVariable;
import org.osate.ba.aadlba.IterativeVariableHolder;
import org.osate.ba.aadlba.Literal;
import org.osate.ba.aadlba.LockAction;
import org.osate.ba.aadlba.LogicalOperator;
import org.osate.ba.aadlba.LoopStatement;
import org.osate.ba.aadlba.LowerBound;
import org.osate.ba.aadlba.ModeSwitchConjunction;
import org.osate.ba.aadlba.ModeSwitchTrigger;
import org.osate.ba.aadlba.ModeSwitchTriggerCondition;
import org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression;
import org.osate.ba.aadlba.MultiplyingOperator;
import org.osate.ba.aadlba.NumericLiteral;
import org.osate.ba.aadlba.Otherwise;
import org.osate.ba.aadlba.ParameterHolder;
import org.osate.ba.aadlba.ParameterLabel;
import org.osate.ba.aadlba.PortCountValue;
import org.osate.ba.aadlba.PortDequeueAction;
import org.osate.ba.aadlba.PortDequeueValue;
import org.osate.ba.aadlba.PortFreezeAction;
import org.osate.ba.aadlba.PortFreshValue;
import org.osate.ba.aadlba.PortHolder;
import org.osate.ba.aadlba.PortPrototypeHolder;
import org.osate.ba.aadlba.PortSendAction;
import org.osate.ba.aadlba.PropertyAssociationHolder;
import org.osate.ba.aadlba.PropertyElementHolder;
import org.osate.ba.aadlba.PropertyExpressionHolder;
import org.osate.ba.aadlba.PropertyNameField;
import org.osate.ba.aadlba.PropertyNameHolder;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.ba.aadlba.PropertySetPropertyReference;
import org.osate.ba.aadlba.PropertyTypeHolder;
import org.osate.ba.aadlba.PrototypeHolder;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.RelationalOperator;
import org.osate.ba.aadlba.SharedDataAction;
import org.osate.ba.aadlba.SimpleExpression;
import org.osate.ba.aadlba.StructUnionElement;
import org.osate.ba.aadlba.StructUnionElementHolder;
import org.osate.ba.aadlba.SubcomponentHolder;
import org.osate.ba.aadlba.SubprogramAccessHolder;
import org.osate.ba.aadlba.SubprogramCallAction;
import org.osate.ba.aadlba.SubprogramHolder;
import org.osate.ba.aadlba.SubprogramHolderProxy;
import org.osate.ba.aadlba.SubprogramPrototypeHolder;
import org.osate.ba.aadlba.SubprogramSubcomponentHolder;
import org.osate.ba.aadlba.Target;
import org.osate.ba.aadlba.Term;
import org.osate.ba.aadlba.TimedAction;
import org.osate.ba.aadlba.UnaryAddingOperator;
import org.osate.ba.aadlba.UnaryBooleanOperator;
import org.osate.ba.aadlba.UnaryNumericOperator;
import org.osate.ba.aadlba.UnlockAction;
import org.osate.ba.aadlba.UpperBound;
import org.osate.ba.aadlba.Value;
import org.osate.ba.aadlba.ValueConstant;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.aadlba.ValueVariable;
import org.osate.ba.aadlba.WhileOrDoUntilStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AadlBaPackageImpl extends EPackageImpl implements AadlBaPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actualPortHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass basicActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass basicPropertyHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorActionBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorActionCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorActionsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorActionSequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorActionSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorAnnexEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorBooleanLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorIntegerLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorNamedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorPropertyConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorRealLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorStringLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorTimeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorVariableHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass calledSubprogramHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierFeatureHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass communicationActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass completionRelativeTimeoutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierFeaturePropertyReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass condStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataAccessHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataAccessPrototypeHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataComponentReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataPortHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataSubcomponentHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dispatchConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dispatchConjunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dispatchRelativeTimeoutEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dispatchTriggerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dispatchTriggerConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dispatchTriggerConditionStopEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dispatchTriggerLogicalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementValuesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elseStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumLiteralHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventDataPortHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventPortHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executeConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executionTimeoutCatchEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass factorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featurePrototypeHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forOrForAllStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass groupableElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass groupHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass groupPrototypeHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indexableElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerRangeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerValueConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerValueVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iterativeVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iterativeVariableHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lockActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass otherwiseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterLabelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portCountValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portDequeueActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portDequeueValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portFreezeActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portFreshValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portPrototypeHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass portSendActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyNameFieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyNameHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyElementHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyAssociationHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyExpressionHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyTypeHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prototypeHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sharedDataActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structUnionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass structUnionElementHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subprogramAccessHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subprogramCallActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subprogramHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subprogramHolderProxyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subprogramPrototypeHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass targetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass termEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timedActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unlockActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueConstantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileOrDoUntilStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modeSwitchTriggerLogicalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modeSwitchTriggerConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modeSwitchConjunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modeSwitchTriggerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertySetPropertyReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subcomponentHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subprogramSubcomponentHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureHolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierPropertyReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass upperBoundEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lowerBoundEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum behaviorFeatureTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum binaryAddingOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum binaryNumericOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum dataRepresentationEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum featureTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum logicalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum multiplyingOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum relationalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum unaryAddingOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum unaryBooleanOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum unaryNumericOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType booleanEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType integerEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType realEDataType = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType stringEDataType = null;

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
   * @see org.osate.ba.aadlba.AadlBaPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AadlBaPackageImpl()
  {
    super(eNS_URI, AadlBaFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AadlBaPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AadlBaPackage init()
  {
    if (isInited) return (AadlBaPackage)EPackage.Registry.INSTANCE.getEPackage(AadlBaPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredAadlBaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    AadlBaPackageImpl theAadlBaPackage = registeredAadlBaPackage instanceof AadlBaPackageImpl ? (AadlBaPackageImpl)registeredAadlBaPackage : new AadlBaPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    Aadl2Package.eINSTANCE.eClass();

    // Create package meta-data objects
    theAadlBaPackage.createPackageContents();

    // Initialize created meta-data
    theAadlBaPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAadlBaPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AadlBaPackage.eNS_URI, theAadlBaPackage);
    return theAadlBaPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getActualPortHolder()
  {
    return actualPortHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAssignmentAction()
  {
    return assignmentActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssignmentAction_Target()
  {
    return (EReference)assignmentActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAssignmentAction_ValueExpression()
  {
    return (EReference)assignmentActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAny()
  {
    return anyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBasicAction()
  {
    return basicActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBasicPropertyHolder()
  {
    return basicPropertyHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorAction()
  {
    return behaviorActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActionBlock()
  {
    return behaviorActionBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorActionBlock_Content()
  {
    return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorActionBlock_Timeout()
  {
    return (EReference)behaviorActionBlockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActionCollection()
  {
    return behaviorActionCollectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorActionCollection_Actions()
  {
    return (EReference)behaviorActionCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActions()
  {
    return behaviorActionsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActionSequence()
  {
    return behaviorActionSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorActionSet()
  {
    return behaviorActionSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorAnnex()
  {
    return behaviorAnnexEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_Variables()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_States()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_Transitions()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_Actions()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_Conditions()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorAnnex_InitialState()
  {
    return (EReference)behaviorAnnexEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorBooleanLiteral()
  {
    return behaviorBooleanLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorCondition()
  {
    return behaviorConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorElement()
  {
    return behaviorElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorIntegerLiteral()
  {
    return behaviorIntegerLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorNamedElement()
  {
    return behaviorNamedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorPropertyConstant()
  {
    return behaviorPropertyConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorPropertyConstant_Property()
  {
    return (EReference)behaviorPropertyConstantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorPropertyConstant_PropertySet()
  {
    return (EReference)behaviorPropertyConstantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorRealLiteral()
  {
    return behaviorRealLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorState()
  {
    return behaviorStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorState_Initial()
  {
    return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorState_Complete()
  {
    return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorState_Final()
  {
    return (EAttribute)behaviorStateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorState_BindedMode()
  {
    return (EReference)behaviorStateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorState_IncomingTransitions()
  {
    return (EReference)behaviorStateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorState_OutgoingTransitions()
  {
    return (EReference)behaviorStateEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorStringLiteral()
  {
    return behaviorStringLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorTime()
  {
    return behaviorTimeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTime_IntegerValue()
  {
    return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTime_Unit()
  {
    return (EReference)behaviorTimeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorTransition()
  {
    return behaviorTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_SourceState()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_Condition()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_DestinationState()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorTransition_ActionBlock()
  {
    return (EReference)behaviorTransitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getBehaviorTransition_Priority()
  {
    return (EAttribute)behaviorTransitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorVariable()
  {
    return behaviorVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorVariable_DataClassifier()
  {
    return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getBehaviorVariable_OwnedPropertyAssociations()
  {
    return (EReference)behaviorVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getBehaviorVariableHolder()
  {
    return behaviorVariableHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCalledSubprogramHolder()
  {
    return calledSubprogramHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClassifierFeatureHolder()
  {
    return classifierFeatureHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCommunicationAction()
  {
    return communicationActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCompletionRelativeTimeout()
  {
    return completionRelativeTimeoutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClassifierFeaturePropertyReference()
  {
    return classifierFeaturePropertyReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassifierFeaturePropertyReference_Component()
  {
    return (EReference)classifierFeaturePropertyReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getCondStatement()
  {
    return condStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getCondStatement_BehaviorActions()
  {
    return (EReference)condStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDataAccessHolder()
  {
    return dataAccessHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDataAccessPrototypeHolder()
  {
    return dataAccessPrototypeHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDataComponentReference()
  {
    return dataComponentReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDataComponentReference_Data()
  {
    return (EReference)dataComponentReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDataHolder()
  {
    return dataHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDataPortHolder()
  {
    return dataPortHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDataSubcomponentHolder()
  {
    return dataSubcomponentHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchCondition()
  {
    return dispatchConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchCondition_DispatchTriggerCondition()
  {
    return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchCondition_FrozenPorts()
  {
    return (EReference)dispatchConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchConjunction()
  {
    return dispatchConjunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchConjunction_DispatchTriggers()
  {
    return (EReference)dispatchConjunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchRelativeTimeout()
  {
    return dispatchRelativeTimeoutEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchTrigger()
  {
    return dispatchTriggerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchTriggerCondition()
  {
    return dispatchTriggerConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchTriggerConditionStop()
  {
    return dispatchTriggerConditionStopEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDispatchTriggerLogicalExpression()
  {
    return dispatchTriggerLogicalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDispatchTriggerLogicalExpression_DispatchConjunctions()
  {
    return (EReference)dispatchTriggerLogicalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getElementHolder()
  {
    return elementHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElementHolder_Element()
  {
    return (EReference)elementHolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getElementValues()
  {
    return elementValuesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getElseStatement()
  {
    return elseStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEnumLiteralHolder()
  {
    return enumLiteralHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEventDataPortHolder()
  {
    return eventDataPortHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getEventPortHolder()
  {
    return eventPortHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExecuteCondition()
  {
    return executeConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExecutionTimeoutCatch()
  {
    return executionTimeoutCatchEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFactor()
  {
    return factorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFactor_FirstValue()
  {
    return (EReference)factorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFactor_SecondValue()
  {
    return (EReference)factorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFactor_BinaryNumericOperator()
  {
    return (EAttribute)factorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFactor_UnaryNumericOperator()
  {
    return (EAttribute)factorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFactor_UnaryBooleanOperator()
  {
    return (EAttribute)factorEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFeaturePrototypeHolder()
  {
    return featurePrototypeHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getForOrForAllStatement()
  {
    return forOrForAllStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getForOrForAllStatement_IteratedValues()
  {
    return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getForOrForAllStatement_ForAll()
  {
    return (EAttribute)forOrForAllStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getForOrForAllStatement_IterativeVariable()
  {
    return (EReference)forOrForAllStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGroupableElement()
  {
    return groupableElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGroupableElement_GroupHolders()
  {
    return (EReference)groupableElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGroupHolder()
  {
    return groupHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGroupPrototypeHolder()
  {
    return groupPrototypeHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGroupPrototypeHolder_PrototypeBinding()
  {
    return (EReference)groupPrototypeHolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIfStatement()
  {
    return ifStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIfStatement_LogicalValueExpression()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getIfStatement_Elif()
  {
    return (EAttribute)ifStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIfStatement_ElseStatement()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIndexableElement()
  {
    return indexableElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIndexableElement_ArrayIndexes()
  {
    return (EReference)indexableElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntegerRange()
  {
    return integerRangeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIntegerRange_LowerIntegerValue()
  {
    return (EReference)integerRangeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIntegerRange_UpperIntegerValue()
  {
    return (EReference)integerRangeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntegerValue()
  {
    return integerValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntegerValueConstant()
  {
    return integerValueConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIntegerValueVariable()
  {
    return integerValueVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIterativeVariable()
  {
    return iterativeVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIterativeVariable_DataClassifier()
  {
    return (EReference)iterativeVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIterativeVariableHolder()
  {
    return iterativeVariableHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLiteral()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLockAction()
  {
    return lockActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLoopStatement()
  {
    return loopStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getNumericLiteral()
  {
    return numericLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getOtherwise()
  {
    return otherwiseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getParameterHolder()
  {
    return parameterHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getParameterLabel()
  {
    return parameterLabelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortCountValue()
  {
    return portCountValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortDequeueAction()
  {
    return portDequeueActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPortDequeueAction_Port()
  {
    return (EReference)portDequeueActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPortDequeueAction_Target()
  {
    return (EReference)portDequeueActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortDequeueValue()
  {
    return portDequeueValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortFreezeAction()
  {
    return portFreezeActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortFreshValue()
  {
    return portFreshValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortHolder()
  {
    return portHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortPrototypeHolder()
  {
    return portPrototypeHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPortSendAction()
  {
    return portSendActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPortSendAction_Port()
  {
    return (EReference)portSendActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPortSendAction_ValueExpression()
  {
    return (EReference)portSendActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyNameField()
  {
    return propertyNameFieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyNameHolder()
  {
    return propertyNameHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyNameHolder_Property()
  {
    return (EReference)propertyNameHolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyNameHolder_Field()
  {
    return (EReference)propertyNameHolderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyElementHolder()
  {
    return propertyElementHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyElementHolder_Element()
  {
    return (EReference)propertyElementHolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyAssociationHolder()
  {
    return propertyAssociationHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyExpressionHolder()
  {
    return propertyExpressionHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyTypeHolder()
  {
    return propertyTypeHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPrototypeHolder()
  {
    return prototypeHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPrototypeHolder_PrototypeBinding()
  {
    return (EReference)prototypeHolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRelation()
  {
    return relationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRelation_FirstExpression()
  {
    return (EReference)relationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRelation_SecondExpression()
  {
    return (EReference)relationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRelation_RelationalOperator()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSharedDataAction()
  {
    return sharedDataActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSharedDataAction_DataAccess()
  {
    return (EReference)sharedDataActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSimpleExpression()
  {
    return simpleExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getSimpleExpression_UnaryAddingOperator()
  {
    return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSimpleExpression_Terms()
  {
    return (EReference)simpleExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getSimpleExpression_BinaryAddingOperators()
  {
    return (EAttribute)simpleExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStructUnionElement()
  {
    return structUnionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStructUnionElement_DataClassifier()
  {
    return (EReference)structUnionElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStructUnionElementHolder()
  {
    return structUnionElementHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSubprogramAccessHolder()
  {
    return subprogramAccessHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSubprogramCallAction()
  {
    return subprogramCallActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSubprogramCallAction_Subprogram()
  {
    return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSubprogramCallAction_ParameterLabels()
  {
    return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSubprogramCallAction_Proxy()
  {
    return (EReference)subprogramCallActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSubprogramHolder()
  {
    return subprogramHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSubprogramHolderProxy()
  {
    return subprogramHolderProxyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSubprogramPrototypeHolder()
  {
    return subprogramPrototypeHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTarget()
  {
    return targetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTerm()
  {
    return termEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTerm_Factors()
  {
    return (EReference)termEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getTerm_MultiplyingOperators()
  {
    return (EAttribute)termEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTimedAction()
  {
    return timedActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimedAction_LowerTime()
  {
    return (EReference)timedActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimedAction_UpperTime()
  {
    return (EReference)timedActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getTimedAction_ProcessorClassifier()
  {
    return (EReference)timedActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUnlockAction()
  {
    return unlockActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValueConstant()
  {
    return valueConstantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValueExpression()
  {
    return valueExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getValueExpression_Relations()
  {
    return (EReference)valueExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getValueExpression_LogicalOperators()
  {
    return (EAttribute)valueExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValueVariable()
  {
    return valueVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getWhileOrDoUntilStatement()
  {
    return whileOrDoUntilStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getWhileOrDoUntilStatement_LogicalValueExpression()
  {
    return (EReference)whileOrDoUntilStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getWhileOrDoUntilStatement_DoUntil()
  {
    return (EAttribute)whileOrDoUntilStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModeSwitchTriggerLogicalExpression()
  {
    return modeSwitchTriggerLogicalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModeSwitchTriggerLogicalExpression_ModeSwitchConjunctions()
  {
    return (EReference)modeSwitchTriggerLogicalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModeSwitchTriggerCondition()
  {
    return modeSwitchTriggerConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModeSwitchConjunction()
  {
    return modeSwitchConjunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModeSwitchConjunction_ModeSwitchTriggers()
  {
    return (EReference)modeSwitchConjunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModeSwitchTrigger()
  {
    return modeSwitchTriggerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertySetPropertyReference()
  {
    return propertySetPropertyReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertySetPropertyReference_PropertySet()
  {
    return (EReference)propertySetPropertyReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSubcomponentHolder()
  {
    return subcomponentHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSubprogramSubcomponentHolder()
  {
    return subprogramSubcomponentHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFeatureHolder()
  {
    return featureHolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClassifierPropertyReference()
  {
    return classifierPropertyReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClassifierPropertyReference_Classifier()
  {
    return (EReference)classifierPropertyReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPropertyReference()
  {
    return propertyReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getPropertyReference_Properties()
  {
    return (EReference)propertyReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getUpperBound()
  {
    return upperBoundEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getLowerBound()
  {
    return lowerBoundEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getBehaviorFeatureType()
  {
    return behaviorFeatureTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getBinaryAddingOperator()
  {
    return binaryAddingOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getBinaryNumericOperator()
  {
    return binaryNumericOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getDataRepresentation()
  {
    return dataRepresentationEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getFeatureType()
  {
    return featureTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getLogicalOperator()
  {
    return logicalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getMultiplyingOperator()
  {
    return multiplyingOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getRelationalOperator()
  {
    return relationalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getUnaryAddingOperator()
  {
    return unaryAddingOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getUnaryBooleanOperator()
  {
    return unaryBooleanOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EEnum getUnaryNumericOperator()
  {
    return unaryNumericOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getBoolean()
  {
    return booleanEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getInteger()
  {
    return integerEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getReal()
  {
    return realEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getString()
  {
    return stringEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AadlBaFactory getAadlBaFactory()
  {
    return (AadlBaFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    actualPortHolderEClass = createEClass(ACTUAL_PORT_HOLDER);

    assignmentActionEClass = createEClass(ASSIGNMENT_ACTION);
    createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__TARGET);
    createEReference(assignmentActionEClass, ASSIGNMENT_ACTION__VALUE_EXPRESSION);

    anyEClass = createEClass(ANY);

    basicActionEClass = createEClass(BASIC_ACTION);

    basicPropertyHolderEClass = createEClass(BASIC_PROPERTY_HOLDER);

    behaviorActionEClass = createEClass(BEHAVIOR_ACTION);

    behaviorActionBlockEClass = createEClass(BEHAVIOR_ACTION_BLOCK);
    createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__CONTENT);
    createEReference(behaviorActionBlockEClass, BEHAVIOR_ACTION_BLOCK__TIMEOUT);

    behaviorActionCollectionEClass = createEClass(BEHAVIOR_ACTION_COLLECTION);
    createEReference(behaviorActionCollectionEClass, BEHAVIOR_ACTION_COLLECTION__ACTIONS);

    behaviorActionsEClass = createEClass(BEHAVIOR_ACTIONS);

    behaviorActionSequenceEClass = createEClass(BEHAVIOR_ACTION_SEQUENCE);

    behaviorActionSetEClass = createEClass(BEHAVIOR_ACTION_SET);

    behaviorAnnexEClass = createEClass(BEHAVIOR_ANNEX);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__VARIABLES);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__STATES);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__TRANSITIONS);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__ACTIONS);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__CONDITIONS);
    createEReference(behaviorAnnexEClass, BEHAVIOR_ANNEX__INITIAL_STATE);

    behaviorBooleanLiteralEClass = createEClass(BEHAVIOR_BOOLEAN_LITERAL);

    behaviorConditionEClass = createEClass(BEHAVIOR_CONDITION);

    behaviorElementEClass = createEClass(BEHAVIOR_ELEMENT);

    behaviorIntegerLiteralEClass = createEClass(BEHAVIOR_INTEGER_LITERAL);

    behaviorNamedElementEClass = createEClass(BEHAVIOR_NAMED_ELEMENT);

    behaviorPropertyConstantEClass = createEClass(BEHAVIOR_PROPERTY_CONSTANT);
    createEReference(behaviorPropertyConstantEClass, BEHAVIOR_PROPERTY_CONSTANT__PROPERTY);
    createEReference(behaviorPropertyConstantEClass, BEHAVIOR_PROPERTY_CONSTANT__PROPERTY_SET);

    behaviorRealLiteralEClass = createEClass(BEHAVIOR_REAL_LITERAL);

    behaviorStateEClass = createEClass(BEHAVIOR_STATE);
    createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__INITIAL);
    createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__COMPLETE);
    createEAttribute(behaviorStateEClass, BEHAVIOR_STATE__FINAL);
    createEReference(behaviorStateEClass, BEHAVIOR_STATE__BINDED_MODE);
    createEReference(behaviorStateEClass, BEHAVIOR_STATE__INCOMING_TRANSITIONS);
    createEReference(behaviorStateEClass, BEHAVIOR_STATE__OUTGOING_TRANSITIONS);

    behaviorStringLiteralEClass = createEClass(BEHAVIOR_STRING_LITERAL);

    behaviorTimeEClass = createEClass(BEHAVIOR_TIME);
    createEReference(behaviorTimeEClass, BEHAVIOR_TIME__INTEGER_VALUE);
    createEReference(behaviorTimeEClass, BEHAVIOR_TIME__UNIT);

    behaviorTransitionEClass = createEClass(BEHAVIOR_TRANSITION);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__SOURCE_STATE);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__CONDITION);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__DESTINATION_STATE);
    createEReference(behaviorTransitionEClass, BEHAVIOR_TRANSITION__ACTION_BLOCK);
    createEAttribute(behaviorTransitionEClass, BEHAVIOR_TRANSITION__PRIORITY);

    behaviorVariableEClass = createEClass(BEHAVIOR_VARIABLE);
    createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__DATA_CLASSIFIER);
    createEReference(behaviorVariableEClass, BEHAVIOR_VARIABLE__OWNED_PROPERTY_ASSOCIATIONS);

    behaviorVariableHolderEClass = createEClass(BEHAVIOR_VARIABLE_HOLDER);

    calledSubprogramHolderEClass = createEClass(CALLED_SUBPROGRAM_HOLDER);

    classifierFeatureHolderEClass = createEClass(CLASSIFIER_FEATURE_HOLDER);

    classifierFeaturePropertyReferenceEClass = createEClass(CLASSIFIER_FEATURE_PROPERTY_REFERENCE);
    createEReference(classifierFeaturePropertyReferenceEClass, CLASSIFIER_FEATURE_PROPERTY_REFERENCE__COMPONENT);

    classifierPropertyReferenceEClass = createEClass(CLASSIFIER_PROPERTY_REFERENCE);
    createEReference(classifierPropertyReferenceEClass, CLASSIFIER_PROPERTY_REFERENCE__CLASSIFIER);

    communicationActionEClass = createEClass(COMMUNICATION_ACTION);

    completionRelativeTimeoutEClass = createEClass(COMPLETION_RELATIVE_TIMEOUT);

    condStatementEClass = createEClass(COND_STATEMENT);
    createEReference(condStatementEClass, COND_STATEMENT__BEHAVIOR_ACTIONS);

    dataAccessHolderEClass = createEClass(DATA_ACCESS_HOLDER);

    dataAccessPrototypeHolderEClass = createEClass(DATA_ACCESS_PROTOTYPE_HOLDER);

    dataComponentReferenceEClass = createEClass(DATA_COMPONENT_REFERENCE);
    createEReference(dataComponentReferenceEClass, DATA_COMPONENT_REFERENCE__DATA);

    dataHolderEClass = createEClass(DATA_HOLDER);

    dataPortHolderEClass = createEClass(DATA_PORT_HOLDER);

    dataSubcomponentHolderEClass = createEClass(DATA_SUBCOMPONENT_HOLDER);

    dispatchConditionEClass = createEClass(DISPATCH_CONDITION);
    createEReference(dispatchConditionEClass, DISPATCH_CONDITION__DISPATCH_TRIGGER_CONDITION);
    createEReference(dispatchConditionEClass, DISPATCH_CONDITION__FROZEN_PORTS);

    dispatchConjunctionEClass = createEClass(DISPATCH_CONJUNCTION);
    createEReference(dispatchConjunctionEClass, DISPATCH_CONJUNCTION__DISPATCH_TRIGGERS);

    dispatchRelativeTimeoutEClass = createEClass(DISPATCH_RELATIVE_TIMEOUT);

    dispatchTriggerEClass = createEClass(DISPATCH_TRIGGER);

    dispatchTriggerConditionEClass = createEClass(DISPATCH_TRIGGER_CONDITION);

    dispatchTriggerConditionStopEClass = createEClass(DISPATCH_TRIGGER_CONDITION_STOP);

    dispatchTriggerLogicalExpressionEClass = createEClass(DISPATCH_TRIGGER_LOGICAL_EXPRESSION);
    createEReference(dispatchTriggerLogicalExpressionEClass, DISPATCH_TRIGGER_LOGICAL_EXPRESSION__DISPATCH_CONJUNCTIONS);

    elementHolderEClass = createEClass(ELEMENT_HOLDER);
    createEReference(elementHolderEClass, ELEMENT_HOLDER__ELEMENT);

    elementValuesEClass = createEClass(ELEMENT_VALUES);

    elseStatementEClass = createEClass(ELSE_STATEMENT);

    enumLiteralHolderEClass = createEClass(ENUM_LITERAL_HOLDER);

    eventDataPortHolderEClass = createEClass(EVENT_DATA_PORT_HOLDER);

    eventPortHolderEClass = createEClass(EVENT_PORT_HOLDER);

    executeConditionEClass = createEClass(EXECUTE_CONDITION);

    executionTimeoutCatchEClass = createEClass(EXECUTION_TIMEOUT_CATCH);

    factorEClass = createEClass(FACTOR);
    createEReference(factorEClass, FACTOR__FIRST_VALUE);
    createEReference(factorEClass, FACTOR__SECOND_VALUE);
    createEAttribute(factorEClass, FACTOR__BINARY_NUMERIC_OPERATOR);
    createEAttribute(factorEClass, FACTOR__UNARY_NUMERIC_OPERATOR);
    createEAttribute(factorEClass, FACTOR__UNARY_BOOLEAN_OPERATOR);

    featureHolderEClass = createEClass(FEATURE_HOLDER);

    featurePrototypeHolderEClass = createEClass(FEATURE_PROTOTYPE_HOLDER);

    forOrForAllStatementEClass = createEClass(FOR_OR_FOR_ALL_STATEMENT);
    createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__ITERATED_VALUES);
    createEAttribute(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__FOR_ALL);
    createEReference(forOrForAllStatementEClass, FOR_OR_FOR_ALL_STATEMENT__ITERATIVE_VARIABLE);

    groupableElementEClass = createEClass(GROUPABLE_ELEMENT);
    createEReference(groupableElementEClass, GROUPABLE_ELEMENT__GROUP_HOLDERS);

    groupHolderEClass = createEClass(GROUP_HOLDER);

    groupPrototypeHolderEClass = createEClass(GROUP_PROTOTYPE_HOLDER);
    createEReference(groupPrototypeHolderEClass, GROUP_PROTOTYPE_HOLDER__PROTOTYPE_BINDING);

    ifStatementEClass = createEClass(IF_STATEMENT);
    createEReference(ifStatementEClass, IF_STATEMENT__LOGICAL_VALUE_EXPRESSION);
    createEAttribute(ifStatementEClass, IF_STATEMENT__ELIF);
    createEReference(ifStatementEClass, IF_STATEMENT__ELSE_STATEMENT);

    indexableElementEClass = createEClass(INDEXABLE_ELEMENT);
    createEReference(indexableElementEClass, INDEXABLE_ELEMENT__ARRAY_INDEXES);

    integerRangeEClass = createEClass(INTEGER_RANGE);
    createEReference(integerRangeEClass, INTEGER_RANGE__LOWER_INTEGER_VALUE);
    createEReference(integerRangeEClass, INTEGER_RANGE__UPPER_INTEGER_VALUE);

    integerValueEClass = createEClass(INTEGER_VALUE);

    integerValueConstantEClass = createEClass(INTEGER_VALUE_CONSTANT);

    integerValueVariableEClass = createEClass(INTEGER_VALUE_VARIABLE);

    iterativeVariableEClass = createEClass(ITERATIVE_VARIABLE);
    createEReference(iterativeVariableEClass, ITERATIVE_VARIABLE__DATA_CLASSIFIER);

    iterativeVariableHolderEClass = createEClass(ITERATIVE_VARIABLE_HOLDER);

    literalEClass = createEClass(LITERAL);

    lockActionEClass = createEClass(LOCK_ACTION);

    loopStatementEClass = createEClass(LOOP_STATEMENT);

    lowerBoundEClass = createEClass(LOWER_BOUND);

    numericLiteralEClass = createEClass(NUMERIC_LITERAL);

    otherwiseEClass = createEClass(OTHERWISE);

    parameterHolderEClass = createEClass(PARAMETER_HOLDER);

    parameterLabelEClass = createEClass(PARAMETER_LABEL);

    portCountValueEClass = createEClass(PORT_COUNT_VALUE);

    portDequeueActionEClass = createEClass(PORT_DEQUEUE_ACTION);
    createEReference(portDequeueActionEClass, PORT_DEQUEUE_ACTION__PORT);
    createEReference(portDequeueActionEClass, PORT_DEQUEUE_ACTION__TARGET);

    portDequeueValueEClass = createEClass(PORT_DEQUEUE_VALUE);

    portFreezeActionEClass = createEClass(PORT_FREEZE_ACTION);

    portFreshValueEClass = createEClass(PORT_FRESH_VALUE);

    portHolderEClass = createEClass(PORT_HOLDER);

    portPrototypeHolderEClass = createEClass(PORT_PROTOTYPE_HOLDER);

    portSendActionEClass = createEClass(PORT_SEND_ACTION);
    createEReference(portSendActionEClass, PORT_SEND_ACTION__PORT);
    createEReference(portSendActionEClass, PORT_SEND_ACTION__VALUE_EXPRESSION);

    propertyAssociationHolderEClass = createEClass(PROPERTY_ASSOCIATION_HOLDER);

    propertyElementHolderEClass = createEClass(PROPERTY_ELEMENT_HOLDER);
    createEReference(propertyElementHolderEClass, PROPERTY_ELEMENT_HOLDER__ELEMENT);

    propertyExpressionHolderEClass = createEClass(PROPERTY_EXPRESSION_HOLDER);

    propertyNameFieldEClass = createEClass(PROPERTY_NAME_FIELD);

    propertyNameHolderEClass = createEClass(PROPERTY_NAME_HOLDER);
    createEReference(propertyNameHolderEClass, PROPERTY_NAME_HOLDER__PROPERTY);
    createEReference(propertyNameHolderEClass, PROPERTY_NAME_HOLDER__FIELD);

    propertyReferenceEClass = createEClass(PROPERTY_REFERENCE);
    createEReference(propertyReferenceEClass, PROPERTY_REFERENCE__PROPERTIES);

    propertySetPropertyReferenceEClass = createEClass(PROPERTY_SET_PROPERTY_REFERENCE);
    createEReference(propertySetPropertyReferenceEClass, PROPERTY_SET_PROPERTY_REFERENCE__PROPERTY_SET);

    propertyTypeHolderEClass = createEClass(PROPERTY_TYPE_HOLDER);

    prototypeHolderEClass = createEClass(PROTOTYPE_HOLDER);
    createEReference(prototypeHolderEClass, PROTOTYPE_HOLDER__PROTOTYPE_BINDING);

    relationEClass = createEClass(RELATION);
    createEReference(relationEClass, RELATION__FIRST_EXPRESSION);
    createEReference(relationEClass, RELATION__SECOND_EXPRESSION);
    createEAttribute(relationEClass, RELATION__RELATIONAL_OPERATOR);

    sharedDataActionEClass = createEClass(SHARED_DATA_ACTION);
    createEReference(sharedDataActionEClass, SHARED_DATA_ACTION__DATA_ACCESS);

    simpleExpressionEClass = createEClass(SIMPLE_EXPRESSION);
    createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__UNARY_ADDING_OPERATOR);
    createEReference(simpleExpressionEClass, SIMPLE_EXPRESSION__TERMS);
    createEAttribute(simpleExpressionEClass, SIMPLE_EXPRESSION__BINARY_ADDING_OPERATORS);

    structUnionElementEClass = createEClass(STRUCT_UNION_ELEMENT);
    createEReference(structUnionElementEClass, STRUCT_UNION_ELEMENT__DATA_CLASSIFIER);

    structUnionElementHolderEClass = createEClass(STRUCT_UNION_ELEMENT_HOLDER);

    subcomponentHolderEClass = createEClass(SUBCOMPONENT_HOLDER);

    subprogramAccessHolderEClass = createEClass(SUBPROGRAM_ACCESS_HOLDER);

    subprogramCallActionEClass = createEClass(SUBPROGRAM_CALL_ACTION);
    createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__SUBPROGRAM);
    createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__PARAMETER_LABELS);
    createEReference(subprogramCallActionEClass, SUBPROGRAM_CALL_ACTION__PROXY);

    subprogramHolderEClass = createEClass(SUBPROGRAM_HOLDER);

    subprogramHolderProxyEClass = createEClass(SUBPROGRAM_HOLDER_PROXY);

    subprogramPrototypeHolderEClass = createEClass(SUBPROGRAM_PROTOTYPE_HOLDER);

    subprogramSubcomponentHolderEClass = createEClass(SUBPROGRAM_SUBCOMPONENT_HOLDER);

    targetEClass = createEClass(TARGET);

    termEClass = createEClass(TERM);
    createEReference(termEClass, TERM__FACTORS);
    createEAttribute(termEClass, TERM__MULTIPLYING_OPERATORS);

    timedActionEClass = createEClass(TIMED_ACTION);
    createEReference(timedActionEClass, TIMED_ACTION__LOWER_TIME);
    createEReference(timedActionEClass, TIMED_ACTION__UPPER_TIME);
    createEReference(timedActionEClass, TIMED_ACTION__PROCESSOR_CLASSIFIER);

    unlockActionEClass = createEClass(UNLOCK_ACTION);

    upperBoundEClass = createEClass(UPPER_BOUND);

    valueEClass = createEClass(VALUE);

    valueConstantEClass = createEClass(VALUE_CONSTANT);

    valueExpressionEClass = createEClass(VALUE_EXPRESSION);
    createEReference(valueExpressionEClass, VALUE_EXPRESSION__RELATIONS);
    createEAttribute(valueExpressionEClass, VALUE_EXPRESSION__LOGICAL_OPERATORS);

    valueVariableEClass = createEClass(VALUE_VARIABLE);

    whileOrDoUntilStatementEClass = createEClass(WHILE_OR_DO_UNTIL_STATEMENT);
    createEReference(whileOrDoUntilStatementEClass, WHILE_OR_DO_UNTIL_STATEMENT__LOGICAL_VALUE_EXPRESSION);
    createEAttribute(whileOrDoUntilStatementEClass, WHILE_OR_DO_UNTIL_STATEMENT__DO_UNTIL);

    modeSwitchTriggerLogicalExpressionEClass = createEClass(MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION);
    createEReference(modeSwitchTriggerLogicalExpressionEClass, MODE_SWITCH_TRIGGER_LOGICAL_EXPRESSION__MODE_SWITCH_CONJUNCTIONS);

    modeSwitchTriggerConditionEClass = createEClass(MODE_SWITCH_TRIGGER_CONDITION);

    modeSwitchConjunctionEClass = createEClass(MODE_SWITCH_CONJUNCTION);
    createEReference(modeSwitchConjunctionEClass, MODE_SWITCH_CONJUNCTION__MODE_SWITCH_TRIGGERS);

    modeSwitchTriggerEClass = createEClass(MODE_SWITCH_TRIGGER);

    // Create enums
    behaviorFeatureTypeEEnum = createEEnum(BEHAVIOR_FEATURE_TYPE);
    binaryAddingOperatorEEnum = createEEnum(BINARY_ADDING_OPERATOR);
    binaryNumericOperatorEEnum = createEEnum(BINARY_NUMERIC_OPERATOR);
    dataRepresentationEEnum = createEEnum(DATA_REPRESENTATION);
    featureTypeEEnum = createEEnum(FEATURE_TYPE);
    logicalOperatorEEnum = createEEnum(LOGICAL_OPERATOR);
    multiplyingOperatorEEnum = createEEnum(MULTIPLYING_OPERATOR);
    relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
    unaryAddingOperatorEEnum = createEEnum(UNARY_ADDING_OPERATOR);
    unaryBooleanOperatorEEnum = createEEnum(UNARY_BOOLEAN_OPERATOR);
    unaryNumericOperatorEEnum = createEEnum(UNARY_NUMERIC_OPERATOR);

    // Create data types
    booleanEDataType = createEDataType(BOOLEAN);
    integerEDataType = createEDataType(INTEGER);
    realEDataType = createEDataType(REAL);
    stringEDataType = createEDataType(STRING);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    actualPortHolderEClass.getESuperTypes().add(this.getPortHolder());
    assignmentActionEClass.getESuperTypes().add(this.getBasicAction());
    anyEClass.getESuperTypes().add(this.getValueExpression());
    basicActionEClass.getESuperTypes().add(this.getBehaviorAction());
    basicPropertyHolderEClass.getESuperTypes().add(this.getPropertyElementHolder());
    behaviorActionEClass.getESuperTypes().add(this.getBehaviorActions());
    behaviorActionBlockEClass.getESuperTypes().add(this.getBehaviorAction());
    behaviorActionBlockEClass.getESuperTypes().add(this.getBehaviorElement());
    behaviorActionCollectionEClass.getESuperTypes().add(this.getBehaviorActions());
    behaviorActionsEClass.getESuperTypes().add(this.getBehaviorElement());
    behaviorActionSequenceEClass.getESuperTypes().add(this.getBehaviorActionCollection());
    behaviorActionSetEClass.getESuperTypes().add(this.getBehaviorActionCollection());
    behaviorAnnexEClass.getESuperTypes().add(theAadl2Package.getAnnexSubclause());
    behaviorAnnexEClass.getESuperTypes().add(this.getBehaviorElement());
    behaviorBooleanLiteralEClass.getESuperTypes().add(theAadl2Package.getBooleanLiteral());
    behaviorBooleanLiteralEClass.getESuperTypes().add(this.getLiteral());
    behaviorConditionEClass.getESuperTypes().add(this.getBehaviorElement());
    behaviorElementEClass.getESuperTypes().add(theAadl2Package.getElement());
    behaviorIntegerLiteralEClass.getESuperTypes().add(theAadl2Package.getIntegerLiteral());
    behaviorIntegerLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
    behaviorNamedElementEClass.getESuperTypes().add(theAadl2Package.getNamedElement());
    behaviorNamedElementEClass.getESuperTypes().add(this.getBehaviorElement());
    behaviorPropertyConstantEClass.getESuperTypes().add(this.getValueConstant());
    behaviorPropertyConstantEClass.getESuperTypes().add(this.getIntegerValueConstant());
    behaviorRealLiteralEClass.getESuperTypes().add(theAadl2Package.getRealLiteral());
    behaviorRealLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
    behaviorStateEClass.getESuperTypes().add(this.getBehaviorNamedElement());
    behaviorStringLiteralEClass.getESuperTypes().add(theAadl2Package.getStringLiteral());
    behaviorStringLiteralEClass.getESuperTypes().add(this.getLiteral());
    behaviorTimeEClass.getESuperTypes().add(this.getBehaviorElement());
    behaviorTransitionEClass.getESuperTypes().add(this.getBehaviorNamedElement());
    behaviorVariableEClass.getESuperTypes().add(this.getBehaviorNamedElement());
    behaviorVariableEClass.getESuperTypes().add(theAadl2Package.getArrayableElement());
    behaviorVariableEClass.getESuperTypes().add(theAadl2Package.getData());
    behaviorVariableHolderEClass.getESuperTypes().add(this.getDataHolder());
    behaviorVariableHolderEClass.getESuperTypes().add(this.getIndexableElement());
    behaviorVariableHolderEClass.getESuperTypes().add(this.getTarget());
    behaviorVariableHolderEClass.getESuperTypes().add(this.getElementValues());
    behaviorVariableHolderEClass.getESuperTypes().add(this.getSubprogramHolderProxy());
    behaviorVariableHolderEClass.getESuperTypes().add(this.getClassifierFeatureHolder());
    calledSubprogramHolderEClass.getESuperTypes().add(this.getElementHolder());
    calledSubprogramHolderEClass.getESuperTypes().add(this.getIndexableElement());
    calledSubprogramHolderEClass.getESuperTypes().add(this.getGroupableElement());
    classifierFeatureHolderEClass.getESuperTypes().add(this.getElementHolder());
    classifierFeaturePropertyReferenceEClass.getESuperTypes().add(this.getPropertyReference());
    classifierPropertyReferenceEClass.getESuperTypes().add(this.getPropertyReference());
    communicationActionEClass.getESuperTypes().add(this.getBasicAction());
    completionRelativeTimeoutEClass.getESuperTypes().add(this.getBehaviorTime());
    completionRelativeTimeoutEClass.getESuperTypes().add(this.getDispatchRelativeTimeout());
    condStatementEClass.getESuperTypes().add(this.getBehaviorAction());
    dataAccessHolderEClass.getESuperTypes().add(this.getDataHolder());
    dataAccessHolderEClass.getESuperTypes().add(this.getTarget());
    dataAccessHolderEClass.getESuperTypes().add(this.getElementValues());
    dataAccessHolderEClass.getESuperTypes().add(this.getSubprogramHolderProxy());
    dataAccessHolderEClass.getESuperTypes().add(this.getFeatureHolder());
    dataAccessPrototypeHolderEClass.getESuperTypes().add(this.getDataHolder());
    dataAccessPrototypeHolderEClass.getESuperTypes().add(this.getPrototypeHolder());
    dataAccessPrototypeHolderEClass.getESuperTypes().add(this.getTarget());
    dataAccessPrototypeHolderEClass.getESuperTypes().add(this.getElementValues());
    dataComponentReferenceEClass.getESuperTypes().add(this.getElementValues());
    dataComponentReferenceEClass.getESuperTypes().add(this.getTarget());
    dataComponentReferenceEClass.getESuperTypes().add(this.getValueVariable());
    dataComponentReferenceEClass.getESuperTypes().add(this.getIntegerValueVariable());
    dataHolderEClass.getESuperTypes().add(this.getElementHolder());
    dataHolderEClass.getESuperTypes().add(this.getIntegerValueVariable());
    dataHolderEClass.getESuperTypes().add(this.getValueVariable());
    dataPortHolderEClass.getESuperTypes().add(this.getActualPortHolder());
    dataPortHolderEClass.getESuperTypes().add(this.getTarget());
    dataSubcomponentHolderEClass.getESuperTypes().add(this.getDataHolder());
    dataSubcomponentHolderEClass.getESuperTypes().add(this.getTarget());
    dataSubcomponentHolderEClass.getESuperTypes().add(this.getElementValues());
    dataSubcomponentHolderEClass.getESuperTypes().add(this.getSubprogramHolderProxy());
    dataSubcomponentHolderEClass.getESuperTypes().add(this.getSubcomponentHolder());
    dispatchConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
    dispatchConjunctionEClass.getESuperTypes().add(this.getBehaviorElement());
    dispatchRelativeTimeoutEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
    dispatchTriggerEClass.getESuperTypes().add(this.getBehaviorElement());
    dispatchTriggerConditionEClass.getESuperTypes().add(this.getBehaviorElement());
    dispatchTriggerConditionStopEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
    dispatchTriggerLogicalExpressionEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
    elementHolderEClass.getESuperTypes().add(this.getBehaviorElement());
    elementValuesEClass.getESuperTypes().add(this.getBehaviorElement());
    elseStatementEClass.getESuperTypes().add(this.getCondStatement());
    enumLiteralHolderEClass.getESuperTypes().add(this.getPropertyElementHolder());
    eventDataPortHolderEClass.getESuperTypes().add(this.getActualPortHolder());
    eventDataPortHolderEClass.getESuperTypes().add(this.getElementValues());
    eventDataPortHolderEClass.getESuperTypes().add(this.getDispatchTrigger());
    eventDataPortHolderEClass.getESuperTypes().add(this.getModeSwitchTrigger());
    eventDataPortHolderEClass.getESuperTypes().add(this.getTarget());
    eventPortHolderEClass.getESuperTypes().add(this.getActualPortHolder());
    eventPortHolderEClass.getESuperTypes().add(this.getDispatchTrigger());
    eventPortHolderEClass.getESuperTypes().add(this.getModeSwitchTrigger());
    eventPortHolderEClass.getESuperTypes().add(this.getTarget());
    executeConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
    executionTimeoutCatchEClass.getESuperTypes().add(this.getExecuteCondition());
    factorEClass.getESuperTypes().add(this.getBehaviorElement());
    featureHolderEClass.getESuperTypes().add(this.getClassifierFeatureHolder());
    featureHolderEClass.getESuperTypes().add(this.getIndexableElement());
    featureHolderEClass.getESuperTypes().add(this.getGroupableElement());
    featurePrototypeHolderEClass.getESuperTypes().add(this.getDataHolder());
    featurePrototypeHolderEClass.getESuperTypes().add(this.getPrototypeHolder());
    featurePrototypeHolderEClass.getESuperTypes().add(this.getTarget());
    featurePrototypeHolderEClass.getESuperTypes().add(this.getElementValues());
    forOrForAllStatementEClass.getESuperTypes().add(this.getLoopStatement());
    groupableElementEClass.getESuperTypes().add(this.getBehaviorElement());
    groupHolderEClass.getESuperTypes().add(this.getElementHolder());
    groupHolderEClass.getESuperTypes().add(this.getIndexableElement());
    groupPrototypeHolderEClass.getESuperTypes().add(this.getGroupHolder());
    ifStatementEClass.getESuperTypes().add(this.getCondStatement());
    ifStatementEClass.getESuperTypes().add(this.getElseStatement());
    indexableElementEClass.getESuperTypes().add(this.getBehaviorElement());
    integerRangeEClass.getESuperTypes().add(this.getElementValues());
    integerValueEClass.getESuperTypes().add(this.getBehaviorElement());
    integerValueConstantEClass.getESuperTypes().add(this.getIntegerValue());
    integerValueConstantEClass.getESuperTypes().add(this.getValueConstant());
    integerValueVariableEClass.getESuperTypes().add(this.getIntegerValue());
    integerValueVariableEClass.getESuperTypes().add(this.getValueVariable());
    iterativeVariableEClass.getESuperTypes().add(this.getBehaviorNamedElement());
    iterativeVariableHolderEClass.getESuperTypes().add(this.getDataHolder());
    literalEClass.getESuperTypes().add(this.getValueConstant());
    literalEClass.getESuperTypes().add(this.getIntegerValueConstant());
    lockActionEClass.getESuperTypes().add(this.getSharedDataAction());
    loopStatementEClass.getESuperTypes().add(this.getCondStatement());
    lowerBoundEClass.getESuperTypes().add(this.getPropertyNameField());
    numericLiteralEClass.getESuperTypes().add(theAadl2Package.getNumberValue());
    numericLiteralEClass.getESuperTypes().add(this.getLiteral());
    otherwiseEClass.getESuperTypes().add(this.getExecuteCondition());
    parameterHolderEClass.getESuperTypes().add(this.getDataHolder());
    parameterHolderEClass.getESuperTypes().add(this.getTarget());
    parameterHolderEClass.getESuperTypes().add(this.getElementValues());
    parameterHolderEClass.getESuperTypes().add(this.getFeatureHolder());
    parameterLabelEClass.getESuperTypes().add(this.getBehaviorElement());
    portCountValueEClass.getESuperTypes().add(this.getActualPortHolder());
    portDequeueActionEClass.getESuperTypes().add(this.getCommunicationAction());
    portDequeueValueEClass.getESuperTypes().add(this.getActualPortHolder());
    portFreezeActionEClass.getESuperTypes().add(this.getActualPortHolder());
    portFreezeActionEClass.getESuperTypes().add(this.getCommunicationAction());
    portFreshValueEClass.getESuperTypes().add(this.getActualPortHolder());
    portHolderEClass.getESuperTypes().add(this.getValueVariable());
    portHolderEClass.getESuperTypes().add(this.getIntegerValueVariable());
    portHolderEClass.getESuperTypes().add(this.getFeatureHolder());
    portPrototypeHolderEClass.getESuperTypes().add(this.getPortHolder());
    portPrototypeHolderEClass.getESuperTypes().add(this.getPrototypeHolder());
    portPrototypeHolderEClass.getESuperTypes().add(this.getTarget());
    portSendActionEClass.getESuperTypes().add(this.getCommunicationAction());
    propertyAssociationHolderEClass.getESuperTypes().add(this.getPropertyElementHolder());
    propertyElementHolderEClass.getESuperTypes().add(this.getBehaviorElement());
    propertyElementHolderEClass.getESuperTypes().add(this.getIndexableElement());
    propertyExpressionHolderEClass.getESuperTypes().add(this.getPropertyElementHolder());
    propertyNameFieldEClass.getESuperTypes().add(this.getBehaviorElement());
    propertyNameHolderEClass.getESuperTypes().add(this.getBehaviorElement());
    propertyReferenceEClass.getESuperTypes().add(this.getValueConstant());
    propertyReferenceEClass.getESuperTypes().add(this.getIntegerValueConstant());
    propertySetPropertyReferenceEClass.getESuperTypes().add(this.getPropertyReference());
    propertyTypeHolderEClass.getESuperTypes().add(this.getPropertyElementHolder());
    prototypeHolderEClass.getESuperTypes().add(this.getIndexableElement());
    prototypeHolderEClass.getESuperTypes().add(this.getGroupableElement());
    prototypeHolderEClass.getESuperTypes().add(this.getClassifierFeatureHolder());
    relationEClass.getESuperTypes().add(this.getBehaviorElement());
    sharedDataActionEClass.getESuperTypes().add(this.getCommunicationAction());
    simpleExpressionEClass.getESuperTypes().add(this.getBehaviorElement());
    structUnionElementEClass.getESuperTypes().add(this.getBehaviorNamedElement());
    structUnionElementHolderEClass.getESuperTypes().add(this.getDataHolder());
    structUnionElementHolderEClass.getESuperTypes().add(this.getIndexableElement());
    structUnionElementHolderEClass.getESuperTypes().add(this.getTarget());
    structUnionElementHolderEClass.getESuperTypes().add(this.getElementValues());
    subcomponentHolderEClass.getESuperTypes().add(this.getClassifierFeatureHolder());
    subcomponentHolderEClass.getESuperTypes().add(this.getIndexableElement());
    subcomponentHolderEClass.getESuperTypes().add(this.getGroupableElement());
    subprogramAccessHolderEClass.getESuperTypes().add(this.getDispatchTriggerCondition());
    subprogramAccessHolderEClass.getESuperTypes().add(this.getCalledSubprogramHolder());
    subprogramAccessHolderEClass.getESuperTypes().add(this.getFeatureHolder());
    subprogramCallActionEClass.getESuperTypes().add(this.getCommunicationAction());
    subprogramHolderEClass.getESuperTypes().add(this.getCalledSubprogramHolder());
    subprogramHolderProxyEClass.getESuperTypes().add(this.getBehaviorElement());
    subprogramPrototypeHolderEClass.getESuperTypes().add(this.getCalledSubprogramHolder());
    subprogramPrototypeHolderEClass.getESuperTypes().add(this.getPrototypeHolder());
    subprogramSubcomponentHolderEClass.getESuperTypes().add(this.getSubcomponentHolder());
    subprogramSubcomponentHolderEClass.getESuperTypes().add(this.getCalledSubprogramHolder());
    targetEClass.getESuperTypes().add(this.getParameterLabel());
    targetEClass.getESuperTypes().add(this.getBehaviorElement());
    termEClass.getESuperTypes().add(this.getBehaviorElement());
    timedActionEClass.getESuperTypes().add(this.getBasicAction());
    unlockActionEClass.getESuperTypes().add(this.getSharedDataAction());
    upperBoundEClass.getESuperTypes().add(this.getPropertyNameField());
    valueEClass.getESuperTypes().add(this.getBehaviorElement());
    valueConstantEClass.getESuperTypes().add(this.getValue());
    valueExpressionEClass.getESuperTypes().add(this.getValue());
    valueExpressionEClass.getESuperTypes().add(this.getParameterLabel());
    valueExpressionEClass.getESuperTypes().add(this.getExecuteCondition());
    valueVariableEClass.getESuperTypes().add(this.getValue());
    whileOrDoUntilStatementEClass.getESuperTypes().add(this.getLoopStatement());
    modeSwitchTriggerLogicalExpressionEClass.getESuperTypes().add(this.getModeSwitchTriggerCondition());
    modeSwitchTriggerConditionEClass.getESuperTypes().add(this.getBehaviorCondition());
    modeSwitchConjunctionEClass.getESuperTypes().add(this.getBehaviorElement());
    modeSwitchTriggerEClass.getESuperTypes().add(this.getBehaviorElement());

    // Initialize classes and features; add operations and parameters
    initEClass(actualPortHolderEClass, ActualPortHolder.class, "ActualPortHolder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    EOperation op = addEOperation(actualPortHolderEClass, null, "setPort", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getPort(), "port", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(actualPortHolderEClass, theAadl2Package.getPort(), "getPort", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(assignmentActionEClass, AssignmentAction.class, "AssignmentAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignmentAction_Target(), this.getTarget(), null, "target", null, 1, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentAction_ValueExpression(), this.getValueExpression(), null, "valueExpression", null, 1, 1, AssignmentAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(anyEClass, Any.class, "Any", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(basicActionEClass, BasicAction.class, "BasicAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(basicPropertyHolderEClass, BasicPropertyHolder.class, "BasicPropertyHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(basicPropertyHolderEClass, null, "setBasicProperty", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getBasicProperty(), "basicProperty", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(basicPropertyHolderEClass, theAadl2Package.getBasicProperty(), "getBasicProperty", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(behaviorActionEClass, BehaviorAction.class, "BehaviorAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorActionBlockEClass, BehaviorActionBlock.class, "BehaviorActionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorActionBlock_Content(), this.getBehaviorActions(), null, "content", null, 1, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorActionBlock_Timeout(), this.getBehaviorTime(), null, "timeout", null, 0, 1, BehaviorActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorActionCollectionEClass, BehaviorActionCollection.class, "BehaviorActionCollection", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorActionCollection_Actions(), this.getBehaviorAction(), null, "actions", null, 2, -1, BehaviorActionCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorActionsEClass, BehaviorActions.class, "BehaviorActions", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorActionSequenceEClass, BehaviorActionSequence.class, "BehaviorActionSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorActionSetEClass, BehaviorActionSet.class, "BehaviorActionSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorAnnexEClass, BehaviorAnnex.class, "BehaviorAnnex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorAnnex_Variables(), this.getBehaviorVariable(), null, "variables", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorAnnex_States(), this.getBehaviorState(), null, "states", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorAnnex_Transitions(), this.getBehaviorTransition(), null, "transitions", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorAnnex_Actions(), this.getBehaviorActionBlock(), null, "actions", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorAnnex_Conditions(), this.getBehaviorCondition(), null, "conditions", null, 0, -1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorAnnex_InitialState(), this.getBehaviorState(), null, "initialState", null, 1, 1, BehaviorAnnex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorBooleanLiteralEClass, BehaviorBooleanLiteral.class, "BehaviorBooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorConditionEClass, BehaviorCondition.class, "BehaviorCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorElementEClass, BehaviorElement.class, "BehaviorElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorIntegerLiteralEClass, BehaviorIntegerLiteral.class, "BehaviorIntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorNamedElementEClass, BehaviorNamedElement.class, "BehaviorNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorPropertyConstantEClass, BehaviorPropertyConstant.class, "BehaviorPropertyConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorPropertyConstant_Property(), theAadl2Package.getPropertyConstant(), null, "property", null, 1, 1, BehaviorPropertyConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorPropertyConstant_PropertySet(), theAadl2Package.getPropertySet(), null, "propertySet", null, 0, 1, BehaviorPropertyConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorRealLiteralEClass, BehaviorRealLiteral.class, "BehaviorRealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorStateEClass, BehaviorState.class, "BehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBehaviorState_Initial(), this.getBoolean(), "initial", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehaviorState_Complete(), this.getBoolean(), "complete", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehaviorState_Final(), this.getBoolean(), "final", "false", 1, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorState_BindedMode(), theAadl2Package.getMode(), null, "bindedMode", null, 0, 1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorState_IncomingTransitions(), this.getBehaviorTransition(), this.getBehaviorTransition_DestinationState(), "incomingTransitions", null, 0, -1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorState_OutgoingTransitions(), this.getBehaviorTransition(), this.getBehaviorTransition_SourceState(), "outgoingTransitions", null, 0, -1, BehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorStringLiteralEClass, BehaviorStringLiteral.class, "BehaviorStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(behaviorTimeEClass, BehaviorTime.class, "BehaviorTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorTime_IntegerValue(), this.getIntegerValue(), null, "integerValue", null, 1, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTime_Unit(), theAadl2Package.getUnitLiteral(), null, "unit", null, 0, 1, BehaviorTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorTransitionEClass, BehaviorTransition.class, "BehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorTransition_SourceState(), this.getBehaviorState(), this.getBehaviorState_OutgoingTransitions(), "sourceState", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTransition_Condition(), this.getBehaviorCondition(), null, "condition", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTransition_DestinationState(), this.getBehaviorState(), this.getBehaviorState_IncomingTransitions(), "destinationState", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorTransition_ActionBlock(), this.getBehaviorActionBlock(), null, "actionBlock", null, 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBehaviorTransition_Priority(), theAadl2Package.getInteger(), "priority", "-1", 0, 1, BehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorVariableEClass, BehaviorVariable.class, "BehaviorVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorVariable_DataClassifier(), theAadl2Package.getDataClassifier(), null, "dataClassifier", null, 1, 1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorVariable_OwnedPropertyAssociations(), theAadl2Package.getPropertyAssociation(), null, "ownedPropertyAssociations", null, 0, -1, BehaviorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorVariableHolderEClass, BehaviorVariableHolder.class, "BehaviorVariableHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(behaviorVariableHolderEClass, null, "setVariable", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getBehaviorVariable(), "variable", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(behaviorVariableHolderEClass, this.getBehaviorVariable(), "getBehaviorVariable", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(calledSubprogramHolderEClass, CalledSubprogramHolder.class, "CalledSubprogramHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(classifierFeatureHolderEClass, ClassifierFeatureHolder.class, "ClassifierFeatureHolder", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(classifierFeatureHolderEClass, null, "setClassifierFeature", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getClassifierFeature(), "classifierFeature", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(classifierFeatureHolderEClass, theAadl2Package.getClassifierFeature(), "getClassifierFeature", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(classifierFeaturePropertyReferenceEClass, ClassifierFeaturePropertyReference.class, "ClassifierFeaturePropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassifierFeaturePropertyReference_Component(), this.getClassifierFeatureHolder(), null, "component", null, 1, 1, ClassifierFeaturePropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classifierPropertyReferenceEClass, ClassifierPropertyReference.class, "ClassifierPropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassifierPropertyReference_Classifier(), theAadl2Package.getClassifier(), null, "classifier", null, 1, 1, ClassifierPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(communicationActionEClass, CommunicationAction.class, "CommunicationAction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(completionRelativeTimeoutEClass, CompletionRelativeTimeout.class, "CompletionRelativeTimeout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(condStatementEClass, CondStatement.class, "CondStatement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCondStatement_BehaviorActions(), this.getBehaviorActions(), null, "behaviorActions", null, 1, 1, CondStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataAccessHolderEClass, DataAccessHolder.class, "DataAccessHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(dataAccessHolderEClass, null, "setDataAccess", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getDataAccess(), "dataAccess", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(dataAccessHolderEClass, theAadl2Package.getDataAccess(), "getDataAccess", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(dataAccessPrototypeHolderEClass, DataAccessPrototypeHolder.class, "DataAccessPrototypeHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dataComponentReferenceEClass, DataComponentReference.class, "DataComponentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataComponentReference_Data(), this.getDataHolder(), null, "data", null, 2, -1, DataComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataHolderEClass, DataHolder.class, "DataHolder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dataPortHolderEClass, DataPortHolder.class, "DataPortHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(dataPortHolderEClass, null, "setDataPort", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getDataPort(), "dataPort", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(dataPortHolderEClass, theAadl2Package.getDataPort(), "getDataPort", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(dataSubcomponentHolderEClass, DataSubcomponentHolder.class, "DataSubcomponentHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(dataSubcomponentHolderEClass, null, "setDataSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getDataSubcomponent(), "dataSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(dataSubcomponentHolderEClass, theAadl2Package.getDataSubcomponent(), "getDataSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(dispatchConditionEClass, DispatchCondition.class, "DispatchCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDispatchCondition_DispatchTriggerCondition(), this.getDispatchTriggerCondition(), null, "dispatchTriggerCondition", null, 0, 1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDispatchCondition_FrozenPorts(), this.getActualPortHolder(), null, "frozenPorts", null, 0, -1, DispatchCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dispatchConjunctionEClass, DispatchConjunction.class, "DispatchConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDispatchConjunction_DispatchTriggers(), this.getDispatchTrigger(), null, "dispatchTriggers", null, 1, -1, DispatchConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dispatchRelativeTimeoutEClass, DispatchRelativeTimeout.class, "DispatchRelativeTimeout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dispatchTriggerEClass, DispatchTrigger.class, "DispatchTrigger", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dispatchTriggerConditionEClass, DispatchTriggerCondition.class, "DispatchTriggerCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dispatchTriggerConditionStopEClass, DispatchTriggerConditionStop.class, "DispatchTriggerConditionStop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dispatchTriggerLogicalExpressionEClass, DispatchTriggerLogicalExpression.class, "DispatchTriggerLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDispatchTriggerLogicalExpression_DispatchConjunctions(), this.getDispatchConjunction(), null, "dispatchConjunctions", null, 1, -1, DispatchTriggerLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementHolderEClass, ElementHolder.class, "ElementHolder", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElementHolder_Element(), theAadl2Package.getNamedElement(), null, "element", null, 0, 1, ElementHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementValuesEClass, ElementValues.class, "ElementValues", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(elseStatementEClass, ElseStatement.class, "ElseStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumLiteralHolderEClass, EnumLiteralHolder.class, "EnumLiteralHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(enumLiteralHolderEClass, null, "setEnumLiteral", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getEnumerationLiteral(), "enumLiteral", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(enumLiteralHolderEClass, theAadl2Package.getEnumerationLiteral(), "getEnumLiteral", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(eventDataPortHolderEClass, EventDataPortHolder.class, "EventDataPortHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(eventDataPortHolderEClass, null, "setEventDataPort", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getEventDataPort(), "eventDataPort", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(eventDataPortHolderEClass, theAadl2Package.getEventDataPort(), "geteventDataPort", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(eventPortHolderEClass, EventPortHolder.class, "EventPortHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(eventPortHolderEClass, null, "setEventPort", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getEventPort(), "eventPort", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(eventPortHolderEClass, theAadl2Package.getEventPort(), "getEventPort", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(executeConditionEClass, ExecuteCondition.class, "ExecuteCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(executionTimeoutCatchEClass, ExecutionTimeoutCatch.class, "ExecutionTimeoutCatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(factorEClass, Factor.class, "Factor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFactor_FirstValue(), this.getValue(), null, "firstValue", null, 1, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFactor_SecondValue(), this.getValue(), null, "secondValue", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFactor_BinaryNumericOperator(), this.getBinaryNumericOperator(), "binaryNumericOperator", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFactor_UnaryNumericOperator(), this.getUnaryNumericOperator(), "unaryNumericOperator", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFactor_UnaryBooleanOperator(), this.getUnaryBooleanOperator(), "unaryBooleanOperator", null, 0, 1, Factor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureHolderEClass, FeatureHolder.class, "FeatureHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(featureHolderEClass, null, "setFeature", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getFeature(), "feature", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(featureHolderEClass, theAadl2Package.getFeature(), "getFeature", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(featurePrototypeHolderEClass, FeaturePrototypeHolder.class, "FeaturePrototypeHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(forOrForAllStatementEClass, ForOrForAllStatement.class, "ForOrForAllStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForOrForAllStatement_IteratedValues(), this.getElementValues(), null, "iteratedValues", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getForOrForAllStatement_ForAll(), this.getBoolean(), "forAll", "false", 0, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForOrForAllStatement_IterativeVariable(), this.getIterativeVariable(), null, "iterativeVariable", null, 1, 1, ForOrForAllStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(groupableElementEClass, GroupableElement.class, "GroupableElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGroupableElement_GroupHolders(), this.getGroupHolder(), null, "groupHolders", null, 0, -1, GroupableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(groupHolderEClass, GroupHolder.class, "GroupHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(groupHolderEClass, null, "setGroup", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getNamedElement(), "group", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(groupHolderEClass, theAadl2Package.getNamedElement(), "getGroup", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(groupPrototypeHolderEClass, GroupPrototypeHolder.class, "GroupPrototypeHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGroupPrototypeHolder_PrototypeBinding(), theAadl2Package.getPrototypeBinding(), null, "prototypeBinding", null, 0, 1, GroupPrototypeHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = addEOperation(groupPrototypeHolderEClass, null, "setPrototype", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getPrototype(), "prototype", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(groupPrototypeHolderEClass, theAadl2Package.getPrototype(), "getPrototype", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfStatement_LogicalValueExpression(), this.getValueExpression(), null, "logicalValueExpression", null, 1, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIfStatement_Elif(), this.getBoolean(), "elif", "false", 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfStatement_ElseStatement(), this.getElseStatement(), null, "elseStatement", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(indexableElementEClass, IndexableElement.class, "IndexableElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIndexableElement_ArrayIndexes(), this.getIntegerValue(), null, "arrayIndexes", null, 0, -1, IndexableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerRangeEClass, IntegerRange.class, "IntegerRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIntegerRange_LowerIntegerValue(), this.getIntegerValue(), null, "lowerIntegerValue", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIntegerRange_UpperIntegerValue(), this.getIntegerValue(), null, "upperIntegerValue", null, 1, 1, IntegerRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(integerValueConstantEClass, IntegerValueConstant.class, "IntegerValueConstant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(integerValueVariableEClass, IntegerValueVariable.class, "IntegerValueVariable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(iterativeVariableEClass, IterativeVariable.class, "IterativeVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIterativeVariable_DataClassifier(), theAadl2Package.getDataClassifier(), null, "dataClassifier", null, 0, 1, IterativeVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iterativeVariableHolderEClass, IterativeVariableHolder.class, "IterativeVariableHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(iterativeVariableHolderEClass, null, "setIterativeVariable", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIterativeVariable(), "itV", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(iterativeVariableHolderEClass, this.getIterativeVariable(), "getIterativeVariable", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lockActionEClass, LockAction.class, "LockAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(loopStatementEClass, LoopStatement.class, "LoopStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lowerBoundEClass, LowerBound.class, "LowerBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericLiteralEClass, NumericLiteral.class, "NumericLiteral", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(otherwiseEClass, Otherwise.class, "Otherwise", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parameterHolderEClass, ParameterHolder.class, "ParameterHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(parameterHolderEClass, null, "setParameter", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getParameter(), "parameter", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(parameterHolderEClass, theAadl2Package.getParameter(), "getParameter", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(parameterLabelEClass, ParameterLabel.class, "ParameterLabel", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(portCountValueEClass, PortCountValue.class, "PortCountValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(portDequeueActionEClass, PortDequeueAction.class, "PortDequeueAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPortDequeueAction_Port(), this.getActualPortHolder(), null, "port", null, 1, 1, PortDequeueAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortDequeueAction_Target(), this.getTarget(), null, "target", null, 0, 1, PortDequeueAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(portDequeueValueEClass, PortDequeueValue.class, "PortDequeueValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(portFreezeActionEClass, PortFreezeAction.class, "PortFreezeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(portFreshValueEClass, PortFreshValue.class, "PortFreshValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(portHolderEClass, PortHolder.class, "PortHolder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(portPrototypeHolderEClass, PortPrototypeHolder.class, "PortPrototypeHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(portSendActionEClass, PortSendAction.class, "PortSendAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPortSendAction_Port(), this.getActualPortHolder(), null, "port", null, 0, 1, PortSendAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPortSendAction_ValueExpression(), this.getValueExpression(), null, "valueExpression", null, 0, 1, PortSendAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyAssociationHolderEClass, PropertyAssociationHolder.class, "PropertyAssociationHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(propertyAssociationHolderEClass, null, "setPropertyAssociation", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getPropertyAssociation(), "propertyAssociation", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(propertyAssociationHolderEClass, theAadl2Package.getPropertyAssociation(), "getPropertyAssociation", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(propertyElementHolderEClass, PropertyElementHolder.class, "PropertyElementHolder", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyElementHolder_Element(), theAadl2Package.getElement(), null, "element", null, 1, 1, PropertyElementHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyExpressionHolderEClass, PropertyExpressionHolder.class, "PropertyExpressionHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(propertyExpressionHolderEClass, null, "setPropertyExpression", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getPropertyExpression(), "propertyExpression", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(propertyExpressionHolderEClass, theAadl2Package.getPropertyExpression(), "getPropertyExpression", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(propertyNameFieldEClass, PropertyNameField.class, "PropertyNameField", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(propertyNameHolderEClass, PropertyNameHolder.class, "PropertyNameHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyNameHolder_Property(), this.getPropertyElementHolder(), null, "property", null, 1, 1, PropertyNameHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyNameHolder_Field(), this.getPropertyNameField(), null, "field", null, 0, 1, PropertyNameHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyReferenceEClass, PropertyReference.class, "PropertyReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyReference_Properties(), this.getPropertyNameHolder(), null, "properties", null, 1, -1, PropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertySetPropertyReferenceEClass, PropertySetPropertyReference.class, "PropertySetPropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertySetPropertyReference_PropertySet(), theAadl2Package.getPropertySet(), null, "propertySet", null, 0, 1, PropertySetPropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyTypeHolderEClass, PropertyTypeHolder.class, "PropertyTypeHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(propertyTypeHolderEClass, null, "setPropertyType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getPropertyType(), "propertyType", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(propertyTypeHolderEClass, theAadl2Package.getPropertyType(), "getPropertyType", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(prototypeHolderEClass, PrototypeHolder.class, "PrototypeHolder", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrototypeHolder_PrototypeBinding(), theAadl2Package.getPrototypeBinding(), null, "prototypeBinding", null, 0, 1, PrototypeHolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = addEOperation(prototypeHolderEClass, null, "setPrototype", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getPrototype(), "prototype", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(prototypeHolderEClass, theAadl2Package.getPrototype(), "getPrototype", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelation_FirstExpression(), this.getSimpleExpression(), null, "firstExpression", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelation_SecondExpression(), this.getSimpleExpression(), null, "secondExpression", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_RelationalOperator(), this.getRelationalOperator(), "relationalOperator", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sharedDataActionEClass, SharedDataAction.class, "SharedDataAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSharedDataAction_DataAccess(), this.getDataAccessHolder(), null, "dataAccess", null, 0, 1, SharedDataAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleExpressionEClass, SimpleExpression.class, "SimpleExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleExpression_UnaryAddingOperator(), this.getUnaryAddingOperator(), "unaryAddingOperator", null, 0, 1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSimpleExpression_Terms(), this.getTerm(), null, "terms", null, 1, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleExpression_BinaryAddingOperators(), this.getBinaryAddingOperator(), "binaryAddingOperators", null, 0, -1, SimpleExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structUnionElementEClass, StructUnionElement.class, "StructUnionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStructUnionElement_DataClassifier(), theAadl2Package.getDataClassifier(), null, "dataClassifier", null, 1, 1, StructUnionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(structUnionElementHolderEClass, StructUnionElementHolder.class, "StructUnionElementHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(structUnionElementHolderEClass, null, "setStructUnionElement", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getStructUnionElement(), "structUnionElement", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(structUnionElementHolderEClass, this.getStructUnionElement(), "getStructUnionElement", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(subcomponentHolderEClass, SubcomponentHolder.class, "SubcomponentHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(subcomponentHolderEClass, null, "setSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getSubcomponent(), "subcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(subcomponentHolderEClass, theAadl2Package.getSubcomponent(), "getSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(subprogramAccessHolderEClass, SubprogramAccessHolder.class, "SubprogramAccessHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(subprogramAccessHolderEClass, null, "setSubprogramAccess", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getSubprogramAccess(), "subprogramAccess", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(subprogramAccessHolderEClass, theAadl2Package.getSubprogramAccess(), "getSubprogramAccess", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(subprogramCallActionEClass, SubprogramCallAction.class, "SubprogramCallAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubprogramCallAction_Subprogram(), this.getCalledSubprogramHolder(), null, "subprogram", null, 1, 1, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubprogramCallAction_ParameterLabels(), this.getParameterLabel(), null, "parameterLabels", null, 0, -1, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubprogramCallAction_Proxy(), this.getSubprogramHolderProxy(), null, "proxy", null, 0, 1, SubprogramCallAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subprogramHolderEClass, SubprogramHolder.class, "SubprogramHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(subprogramHolderEClass, null, "setSubprogram", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getSubprogram(), "subprogram", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(subprogramHolderEClass, theAadl2Package.getSubprogram(), "getSubprogram", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(subprogramHolderProxyEClass, SubprogramHolderProxy.class, "SubprogramHolderProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(subprogramPrototypeHolderEClass, SubprogramPrototypeHolder.class, "SubprogramPrototypeHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(subprogramSubcomponentHolderEClass, SubprogramSubcomponentHolder.class, "SubprogramSubcomponentHolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    op = addEOperation(subprogramSubcomponentHolderEClass, null, "setSubprogramSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getSubprogramSubcomponent(), "subprogramSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(subprogramSubcomponentHolderEClass, theAadl2Package.getSubprogramSubcomponent(), "getSubprogramSubcomponent", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTerm_Factors(), this.getFactor(), null, "factors", null, 1, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTerm_MultiplyingOperators(), this.getMultiplyingOperator(), "multiplyingOperators", null, 0, -1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timedActionEClass, TimedAction.class, "TimedAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimedAction_LowerTime(), this.getBehaviorTime(), null, "lowerTime", null, 1, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimedAction_UpperTime(), this.getBehaviorTime(), null, "upperTime", null, 0, 1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimedAction_ProcessorClassifier(), theAadl2Package.getProcessorClassifier(), null, "processorClassifier", null, 0, -1, TimedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unlockActionEClass, UnlockAction.class, "UnlockAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(upperBoundEClass, UpperBound.class, "UpperBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueConstantEClass, ValueConstant.class, "ValueConstant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueExpressionEClass, ValueExpression.class, "ValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValueExpression_Relations(), this.getRelation(), null, "relations", null, 0, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getValueExpression_LogicalOperators(), this.getLogicalOperator(), "logicalOperators", null, 0, -1, ValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueVariableEClass, ValueVariable.class, "ValueVariable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(whileOrDoUntilStatementEClass, WhileOrDoUntilStatement.class, "WhileOrDoUntilStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhileOrDoUntilStatement_LogicalValueExpression(), this.getValueExpression(), null, "logicalValueExpression", null, 1, 1, WhileOrDoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWhileOrDoUntilStatement_DoUntil(), this.getBoolean(), "doUntil", "false", 0, 1, WhileOrDoUntilStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modeSwitchTriggerLogicalExpressionEClass, ModeSwitchTriggerLogicalExpression.class, "ModeSwitchTriggerLogicalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModeSwitchTriggerLogicalExpression_ModeSwitchConjunctions(), this.getModeSwitchConjunction(), null, "modeSwitchConjunctions", null, 1, -1, ModeSwitchTriggerLogicalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modeSwitchTriggerConditionEClass, ModeSwitchTriggerCondition.class, "ModeSwitchTriggerCondition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(modeSwitchConjunctionEClass, ModeSwitchConjunction.class, "ModeSwitchConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModeSwitchConjunction_ModeSwitchTriggers(), this.getModeSwitchTrigger(), null, "modeSwitchTriggers", null, 1, -1, ModeSwitchConjunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modeSwitchTriggerEClass, ModeSwitchTrigger.class, "ModeSwitchTrigger", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(behaviorFeatureTypeEEnum, BehaviorFeatureType.class, "BehaviorFeatureType");
    addEEnumLiteral(behaviorFeatureTypeEEnum, BehaviorFeatureType.NONE);
    addEEnumLiteral(behaviorFeatureTypeEEnum, BehaviorFeatureType.BEHAVIOR_VARIABLE);
    addEEnumLiteral(behaviorFeatureTypeEEnum, BehaviorFeatureType.ITERATIVE_VARIABLE);

    initEEnum(binaryAddingOperatorEEnum, BinaryAddingOperator.class, "BinaryAddingOperator");
    addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.NONE);
    addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.PLUS);
    addEEnumLiteral(binaryAddingOperatorEEnum, BinaryAddingOperator.MINUS);

    initEEnum(binaryNumericOperatorEEnum, BinaryNumericOperator.class, "BinaryNumericOperator");
    addEEnumLiteral(binaryNumericOperatorEEnum, BinaryNumericOperator.NONE);
    addEEnumLiteral(binaryNumericOperatorEEnum, BinaryNumericOperator.MULTIPLY_MULTIPLY);

    initEEnum(dataRepresentationEEnum, DataRepresentation.class, "DataRepresentation");
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.UNKNOWN);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.ARRAY);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.BOOLEAN);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.CHARACTER);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.ENUM);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.FIXED);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.FLOAT);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.INTEGER);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.STRING);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.STRUCT);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.UNION);
    addEEnumLiteral(dataRepresentationEEnum, DataRepresentation.ENUM_LITERAL);

    initEEnum(featureTypeEEnum, FeatureType.class, "FeatureType");
    addEEnumLiteral(featureTypeEEnum, FeatureType.NONE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_DATA_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_DATA_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_DATA_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_DATA_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_DATA_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_DATA_PORT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_SUBCOMPONENT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_CLASSIFIER);
    addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.COMPONENT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.COMPONENT_PROTOTYPE_BINDING);
    addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_PROTOTYPE_BINDING);
    addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_GROUP_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_GROUP_PROTOTYPE_BINDING);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_DATA_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_DATA_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.DATA_SUBCOMPONENT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.DATA_CLASSIFIER);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_PARAMETER);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_PARAMETER);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_PARAMETER);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROPERTY_CONSTANT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROPERTY_VALUE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_BUS_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_BUS_ACCESS);
    addEEnumLiteral(featureTypeEEnum, FeatureType.FEATURE_GROUP);
    addEEnumLiteral(featureTypeEEnum, FeatureType.CLASSIFIER_VALUE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.ABSTRACT_FEATURE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_FEATURE_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_FEATURE_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_FEATURE_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.THREAD_GROUP);
    addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_GROUP);
    addEEnumLiteral(featureTypeEEnum, FeatureType.SUBPROGRAM_GROUP_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.THREAD_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.THREAD_GROUP_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_DATA_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_DATA_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_DATA_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_EVENT_DATA_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.OUT_EVENT_DATA_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.IN_OUT_EVENT_DATA_PORT_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_DATA_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_DATA_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROVIDES_BUS_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.REQUIRES_BUS_ACCESS_PROTOTYPE);
    addEEnumLiteral(featureTypeEEnum, FeatureType.SYSTEM_SUBCOMPONENT);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROCESSOR_CLASSIFIER);
    addEEnumLiteral(featureTypeEEnum, FeatureType.PROCESS_CLASSIFIER);

    initEEnum(logicalOperatorEEnum, LogicalOperator.class, "LogicalOperator");
    addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.NONE);
    addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.AND);
    addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.OR);
    addEEnumLiteral(logicalOperatorEEnum, LogicalOperator.XOR);

    initEEnum(multiplyingOperatorEEnum, MultiplyingOperator.class, "MultiplyingOperator");
    addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.NONE);
    addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MULTIPLY);
    addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.DIVIDE);
    addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.MOD);
    addEEnumLiteral(multiplyingOperatorEEnum, MultiplyingOperator.REM);

    initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NONE);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUAL);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NOT_EQUAL);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_OR_EQUAL_THAN);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_OR_EQUAL_THAN);

    initEEnum(unaryAddingOperatorEEnum, UnaryAddingOperator.class, "UnaryAddingOperator");
    addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.NONE);
    addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.PLUS);
    addEEnumLiteral(unaryAddingOperatorEEnum, UnaryAddingOperator.MINUS);

    initEEnum(unaryBooleanOperatorEEnum, UnaryBooleanOperator.class, "UnaryBooleanOperator");
    addEEnumLiteral(unaryBooleanOperatorEEnum, UnaryBooleanOperator.NONE);
    addEEnumLiteral(unaryBooleanOperatorEEnum, UnaryBooleanOperator.NOT);

    initEEnum(unaryNumericOperatorEEnum, UnaryNumericOperator.class, "UnaryNumericOperator");
    addEEnumLiteral(unaryNumericOperatorEEnum, UnaryNumericOperator.NONE);
    addEEnumLiteral(unaryNumericOperatorEEnum, UnaryNumericOperator.ABS);

    // Initialize data types
    initEDataType(booleanEDataType, boolean.class, "Boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(integerEDataType, int.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(realEDataType, double.class, "Real", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.topcased.org/documentation
    createDocumentationAnnotations();
    // Documentation
    createDocumentation_1Annotations();
    // documentation
    createDocumentation_2Annotations();
  }

  /**
   * Initializes the annotations for <b>http://www.topcased.org/documentation</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createDocumentationAnnotations()
  {
    String source = "http://www.topcased.org/documentation";
    addAnnotation
      (booleanEDataType,
       source,
       new String[]
       {
         "documentation", "A Boolean type is used for logical expression, consisting of the predefined values true and false."
       });
    addAnnotation
      (integerEDataType,
       source,
       new String[]
       {
         "documentation", "An integer is a primitive type representing integer values."
       });
    addAnnotation
      (realEDataType,
       source,
       new String[]
       {
         "documentation", "A real is a primitive type representing real numeric values."
       });
    addAnnotation
      (stringEDataType,
       source,
       new String[]
       {
         "documentation", "A string is a sequence of characters in some suitable character set used to display information about the model. Character sets may include non-Roman alphabets and characters."
       });
  }

  /**
   * Initializes the annotations for <b>Documentation</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createDocumentation_1Annotations()
  {
    String source = "Documentation";
    addAnnotation
      (lockActionEClass,
       source,
       new String[]
       {
         "documentation", "A null data name means that all shared data are locked while in the critical section"
       });
  }

  /**
   * Initializes the annotations for <b>documentation</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createDocumentation_2Annotations()
  {
    String source = "documentation";
    addAnnotation
      (unlockActionEClass,
       source,
       new String[]
       {
         "documentation", "A null data name means that all shared data are unlocked at the end of the critical section"
       });
  }

} //AadlBaPackageImpl
