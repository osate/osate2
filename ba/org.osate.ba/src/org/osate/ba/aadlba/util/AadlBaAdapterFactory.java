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
package org.osate.ba.aadlba.util;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Data;
import org.osate.aadl2.Element;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.ba.aadlba.* ;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.ba.aadlba.AadlBaPackage
 * @generated
 */
public class AadlBaAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AadlBaPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AadlBaAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AadlBaPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AadlBaSwitch<Adapter> modelSwitch =
    new AadlBaSwitch<Adapter>()
    {
      @Override
      public Adapter caseActualPortHolder(ActualPortHolder object)
      {
        return createActualPortHolderAdapter();
      }
      @Override
      public Adapter caseAssignmentAction(AssignmentAction object)
      {
        return createAssignmentActionAdapter();
      }
      @Override
      public Adapter caseAny(Any object)
      {
        return createAnyAdapter();
      }
      @Override
      public Adapter caseBasicAction(BasicAction object)
      {
        return createBasicActionAdapter();
      }
      @Override
      public Adapter caseBasicPropertyHolder(BasicPropertyHolder object)
      {
        return createBasicPropertyHolderAdapter();
      }
      @Override
      public Adapter caseBehaviorAction(BehaviorAction object)
      {
        return createBehaviorActionAdapter();
      }
      @Override
      public Adapter caseBehaviorActionBlock(BehaviorActionBlock object)
      {
        return createBehaviorActionBlockAdapter();
      }
      @Override
      public Adapter caseBehaviorActionCollection(BehaviorActionCollection object)
      {
        return createBehaviorActionCollectionAdapter();
      }
      @Override
      public Adapter caseBehaviorActions(BehaviorActions object)
      {
        return createBehaviorActionsAdapter();
      }
      @Override
      public Adapter caseBehaviorActionSequence(BehaviorActionSequence object)
      {
        return createBehaviorActionSequenceAdapter();
      }
      @Override
      public Adapter caseBehaviorActionSet(BehaviorActionSet object)
      {
        return createBehaviorActionSetAdapter();
      }
      @Override
      public Adapter caseBehaviorAnnex(BehaviorAnnex object)
      {
        return createBehaviorAnnexAdapter();
      }
      @Override
      public Adapter caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
      {
        return createBehaviorBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseBehaviorCondition(BehaviorCondition object)
      {
        return createBehaviorConditionAdapter();
      }
      @Override
      public Adapter caseBehaviorElement(BehaviorElement object)
      {
        return createBehaviorElementAdapter();
      }
      @Override
      public Adapter caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
      {
        return createBehaviorIntegerLiteralAdapter();
      }
      @Override
      public Adapter caseBehaviorNamedElement(BehaviorNamedElement object)
      {
        return createBehaviorNamedElementAdapter();
      }
      @Override
      public Adapter caseBehaviorPropertyConstant(BehaviorPropertyConstant object)
      {
        return createBehaviorPropertyConstantAdapter();
      }
      @Override
      public Adapter caseBehaviorRealLiteral(BehaviorRealLiteral object)
      {
        return createBehaviorRealLiteralAdapter();
      }
      @Override
      public Adapter caseBehaviorState(BehaviorState object)
      {
        return createBehaviorStateAdapter();
      }
      @Override
      public Adapter caseBehaviorStringLiteral(BehaviorStringLiteral object)
      {
        return createBehaviorStringLiteralAdapter();
      }
      @Override
      public Adapter caseBehaviorTime(BehaviorTime object)
      {
        return createBehaviorTimeAdapter();
      }
      @Override
      public Adapter caseBehaviorTransition(BehaviorTransition object)
      {
        return createBehaviorTransitionAdapter();
      }
      @Override
      public Adapter caseBehaviorVariable(BehaviorVariable object)
      {
        return createBehaviorVariableAdapter();
      }
      @Override
      public Adapter caseBehaviorVariableHolder(BehaviorVariableHolder object)
      {
        return createBehaviorVariableHolderAdapter();
      }
      @Override
      public Adapter caseCalledSubprogramHolder(CalledSubprogramHolder object)
      {
        return createCalledSubprogramHolderAdapter();
      }
      @Override
      public Adapter caseClassifierFeatureHolder(ClassifierFeatureHolder object)
      {
        return createClassifierFeatureHolderAdapter();
      }
      @Override
      public Adapter caseClassifierFeaturePropertyReference(ClassifierFeaturePropertyReference object)
      {
        return createClassifierFeaturePropertyReferenceAdapter();
      }
      @Override
      public Adapter caseClassifierPropertyReference(ClassifierPropertyReference object)
      {
        return createClassifierPropertyReferenceAdapter();
      }
      @Override
      public Adapter caseCommunicationAction(CommunicationAction object)
      {
        return createCommunicationActionAdapter();
      }
      @Override
      public Adapter caseCompletionRelativeTimeout(CompletionRelativeTimeout object)
      {
        return createCompletionRelativeTimeoutAdapter();
      }
      @Override
      public Adapter caseCondStatement(CondStatement object)
      {
        return createCondStatementAdapter();
      }
      @Override
      public Adapter caseDataAccessHolder(DataAccessHolder object)
      {
        return createDataAccessHolderAdapter();
      }
      @Override
      public Adapter caseDataAccessPrototypeHolder(DataAccessPrototypeHolder object)
      {
        return createDataAccessPrototypeHolderAdapter();
      }
      @Override
      public Adapter caseDataComponentReference(DataComponentReference object)
      {
        return createDataComponentReferenceAdapter();
      }
      @Override
      public Adapter caseDataHolder(DataHolder object)
      {
        return createDataHolderAdapter();
      }
      @Override
      public Adapter caseDataPortHolder(DataPortHolder object)
      {
        return createDataPortHolderAdapter();
      }
      @Override
      public Adapter caseDataSubcomponentHolder(DataSubcomponentHolder object)
      {
        return createDataSubcomponentHolderAdapter();
      }
      @Override
      public Adapter caseDispatchCondition(DispatchCondition object)
      {
        return createDispatchConditionAdapter();
      }
      @Override
      public Adapter caseDispatchConjunction(DispatchConjunction object)
      {
        return createDispatchConjunctionAdapter();
      }
      @Override
      public Adapter caseDispatchRelativeTimeout(DispatchRelativeTimeout object)
      {
        return createDispatchRelativeTimeoutAdapter();
      }
      @Override
      public Adapter caseDispatchTrigger(DispatchTrigger object)
      {
        return createDispatchTriggerAdapter();
      }
      @Override
      public Adapter caseDispatchTriggerCondition(DispatchTriggerCondition object)
      {
        return createDispatchTriggerConditionAdapter();
      }
      @Override
      public Adapter caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object)
      {
        return createDispatchTriggerConditionStopAdapter();
      }
      @Override
      public Adapter caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
      {
        return createDispatchTriggerLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseElementHolder(ElementHolder object)
      {
        return createElementHolderAdapter();
      }
      @Override
      public Adapter caseElementValues(ElementValues object)
      {
        return createElementValuesAdapter();
      }
      @Override
      public Adapter caseElseStatement(ElseStatement object)
      {
        return createElseStatementAdapter();
      }
      @Override
      public Adapter caseEnumLiteralHolder(EnumLiteralHolder object)
      {
        return createEnumLiteralHolderAdapter();
      }
      @Override
      public Adapter caseEventDataPortHolder(EventDataPortHolder object)
      {
        return createEventDataPortHolderAdapter();
      }
      @Override
      public Adapter caseEventPortHolder(EventPortHolder object)
      {
        return createEventPortHolderAdapter();
      }
      @Override
      public Adapter caseExecuteCondition(ExecuteCondition object)
      {
        return createExecuteConditionAdapter();
      }
      @Override
      public Adapter caseExecutionTimeoutCatch(ExecutionTimeoutCatch object)
      {
        return createExecutionTimeoutCatchAdapter();
      }
      @Override
      public Adapter caseFactor(Factor object)
      {
        return createFactorAdapter();
      }
      @Override
      public Adapter caseFeatureHolder(FeatureHolder object)
      {
        return createFeatureHolderAdapter();
      }
      @Override
      public Adapter caseFeaturePrototypeHolder(FeaturePrototypeHolder object)
      {
        return createFeaturePrototypeHolderAdapter();
      }
      @Override
      public Adapter caseForOrForAllStatement(ForOrForAllStatement object)
      {
        return createForOrForAllStatementAdapter();
      }
      @Override
      public Adapter caseGroupableElement(GroupableElement object)
      {
        return createGroupableElementAdapter();
      }
      @Override
      public Adapter caseGroupHolder(GroupHolder object)
      {
        return createGroupHolderAdapter();
      }
      @Override
      public Adapter caseGroupPrototypeHolder(GroupPrototypeHolder object)
      {
        return createGroupPrototypeHolderAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseIndexableElement(IndexableElement object)
      {
        return createIndexableElementAdapter();
      }
      @Override
      public Adapter caseIntegerRange(IntegerRange object)
      {
        return createIntegerRangeAdapter();
      }
      @Override
      public Adapter caseIntegerValue(IntegerValue object)
      {
        return createIntegerValueAdapter();
      }
      @Override
      public Adapter caseIntegerValueConstant(IntegerValueConstant object)
      {
        return createIntegerValueConstantAdapter();
      }
      @Override
      public Adapter caseIntegerValueVariable(IntegerValueVariable object)
      {
        return createIntegerValueVariableAdapter();
      }
      @Override
      public Adapter caseIterativeVariable(IterativeVariable object)
      {
        return createIterativeVariableAdapter();
      }
      @Override
      public Adapter caseIterativeVariableHolder(IterativeVariableHolder object)
      {
        return createIterativeVariableHolderAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseLockAction(LockAction object)
      {
        return createLockActionAdapter();
      }
      @Override
      public Adapter caseLoopStatement(LoopStatement object)
      {
        return createLoopStatementAdapter();
      }
      @Override
      public Adapter caseLowerBound(LowerBound object)
      {
        return createLowerBoundAdapter();
      }
      @Override
      public Adapter caseNumericLiteral(NumericLiteral object)
      {
        return createNumericLiteralAdapter();
      }
      @Override
      public Adapter caseOtherwise(Otherwise object)
      {
        return createOtherwiseAdapter();
      }
      @Override
      public Adapter caseParameterHolder(ParameterHolder object)
      {
        return createParameterHolderAdapter();
      }
      @Override
      public Adapter caseParameterLabel(ParameterLabel object)
      {
        return createParameterLabelAdapter();
      }
      @Override
      public Adapter casePortCountValue(PortCountValue object)
      {
        return createPortCountValueAdapter();
      }
      @Override
      public Adapter casePortDequeueAction(PortDequeueAction object)
      {
        return createPortDequeueActionAdapter();
      }
      @Override
      public Adapter casePortDequeueValue(PortDequeueValue object)
      {
        return createPortDequeueValueAdapter();
      }
      @Override
      public Adapter casePortFreezeAction(PortFreezeAction object)
      {
        return createPortFreezeActionAdapter();
      }
      @Override
      public Adapter casePortFreshValue(PortFreshValue object)
      {
        return createPortFreshValueAdapter();
      }
      @Override
      public Adapter casePortHolder(PortHolder object)
      {
        return createPortHolderAdapter();
      }
      @Override
      public Adapter casePortPrototypeHolder(PortPrototypeHolder object)
      {
        return createPortPrototypeHolderAdapter();
      }
      @Override
      public Adapter casePortSendAction(PortSendAction object)
      {
        return createPortSendActionAdapter();
      }
      @Override
      public Adapter casePropertyAssociationHolder(PropertyAssociationHolder object)
      {
        return createPropertyAssociationHolderAdapter();
      }
      @Override
      public Adapter casePropertyElementHolder(PropertyElementHolder object)
      {
        return createPropertyElementHolderAdapter();
      }
      @Override
      public Adapter casePropertyExpressionHolder(PropertyExpressionHolder object)
      {
        return createPropertyExpressionHolderAdapter();
      }
      @Override
      public Adapter casePropertyNameField(PropertyNameField object)
      {
        return createPropertyNameFieldAdapter();
      }
      @Override
      public Adapter casePropertyNameHolder(PropertyNameHolder object)
      {
        return createPropertyNameHolderAdapter();
      }
      @Override
      public Adapter casePropertyReference(PropertyReference object)
      {
        return createPropertyReferenceAdapter();
      }
      @Override
      public Adapter casePropertySetPropertyReference(PropertySetPropertyReference object)
      {
        return createPropertySetPropertyReferenceAdapter();
      }
      @Override
      public Adapter casePropertyTypeHolder(PropertyTypeHolder object)
      {
        return createPropertyTypeHolderAdapter();
      }
      @Override
      public Adapter casePrototypeHolder(PrototypeHolder object)
      {
        return createPrototypeHolderAdapter();
      }
      @Override
      public Adapter caseRelation(Relation object)
      {
        return createRelationAdapter();
      }
      @Override
      public Adapter caseSharedDataAction(SharedDataAction object)
      {
        return createSharedDataActionAdapter();
      }
      @Override
      public Adapter caseSimpleExpression(SimpleExpression object)
      {
        return createSimpleExpressionAdapter();
      }
      @Override
      public Adapter caseStructUnionElement(StructUnionElement object)
      {
        return createStructUnionElementAdapter();
      }
      @Override
      public Adapter caseStructUnionElementHolder(StructUnionElementHolder object)
      {
        return createStructUnionElementHolderAdapter();
      }
      @Override
      public Adapter caseSubcomponentHolder(SubcomponentHolder object)
      {
        return createSubcomponentHolderAdapter();
      }
      @Override
      public Adapter caseSubprogramAccessHolder(SubprogramAccessHolder object)
      {
        return createSubprogramAccessHolderAdapter();
      }
      @Override
      public Adapter caseSubprogramCallAction(SubprogramCallAction object)
      {
        return createSubprogramCallActionAdapter();
      }
      @Override
      public Adapter caseSubprogramHolder(SubprogramHolder object)
      {
        return createSubprogramHolderAdapter();
      }
      @Override
      public Adapter caseSubprogramHolderProxy(SubprogramHolderProxy object)
      {
        return createSubprogramHolderProxyAdapter();
      }
      @Override
      public Adapter caseSubprogramPrototypeHolder(SubprogramPrototypeHolder object)
      {
        return createSubprogramPrototypeHolderAdapter();
      }
      @Override
      public Adapter caseSubprogramSubcomponentHolder(SubprogramSubcomponentHolder object)
      {
        return createSubprogramSubcomponentHolderAdapter();
      }
      @Override
      public Adapter caseTarget(Target object)
      {
        return createTargetAdapter();
      }
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseTimedAction(TimedAction object)
      {
        return createTimedActionAdapter();
      }
      @Override
      public Adapter caseUnlockAction(UnlockAction object)
      {
        return createUnlockActionAdapter();
      }
      @Override
      public Adapter caseUpperBound(UpperBound object)
      {
        return createUpperBoundAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseValueConstant(ValueConstant object)
      {
        return createValueConstantAdapter();
      }
      @Override
      public Adapter caseValueExpression(ValueExpression object)
      {
        return createValueExpressionAdapter();
      }
      @Override
      public Adapter caseValueVariable(ValueVariable object)
      {
        return createValueVariableAdapter();
      }
      @Override
      public Adapter caseWhileOrDoUntilStatement(WhileOrDoUntilStatement object)
      {
        return createWhileOrDoUntilStatementAdapter();
      }
      @Override
      public Adapter caseModeSwitchTriggerLogicalExpression(ModeSwitchTriggerLogicalExpression object)
      {
        return createModeSwitchTriggerLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseModeSwitchTriggerCondition(ModeSwitchTriggerCondition object)
      {
        return createModeSwitchTriggerConditionAdapter();
      }
      @Override
      public Adapter caseModeSwitchConjunction(ModeSwitchConjunction object)
      {
        return createModeSwitchConjunctionAdapter();
      }
      @Override
      public Adapter caseModeSwitchTrigger(ModeSwitchTrigger object)
      {
        return createModeSwitchTriggerAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseModalElement(ModalElement object)
      {
        return createModalElementAdapter();
      }
      @Override
      public Adapter caseAnnexSubclause(AnnexSubclause object)
      {
        return createAnnexSubclauseAdapter();
      }
      @Override
      public Adapter casePropertyExpression(PropertyExpression object)
      {
        return createPropertyExpressionAdapter();
      }
      @Override
      public Adapter casePropertyValue(PropertyValue object)
      {
        return createPropertyValueAdapter();
      }
      @Override
      public Adapter caseBooleanLiteral(BooleanLiteral object)
      {
        return createBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseNumberValue(NumberValue object)
      {
        return createNumberValueAdapter();
      }
      @Override
      public Adapter caseIntegerLiteral(IntegerLiteral object)
      {
        return createIntegerLiteralAdapter();
      }
      @Override
      public Adapter caseRealLiteral(RealLiteral object)
      {
        return createRealLiteralAdapter();
      }
      @Override
      public Adapter caseStringLiteral(StringLiteral object)
      {
        return createStringLiteralAdapter();
      }
      @Override
      public Adapter caseArrayableElement(ArrayableElement object)
      {
        return createArrayableElementAdapter();
      }
      @Override
      public Adapter caseData(Data object)
      {
        return createDataAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ActualPortHolder <em>Actual Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ActualPortHolder
   * @generated
   */
  public Adapter createActualPortHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.AssignmentAction <em>Assignment Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.AssignmentAction
   * @generated
   */
  public Adapter createAssignmentActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Any <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Any
   * @generated
   */
  public Adapter createAnyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BasicAction <em>Basic Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BasicAction
   * @generated
   */
  public Adapter createBasicActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BasicPropertyHolder <em>Basic Property Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BasicPropertyHolder
   * @generated
   */
  public Adapter createBasicPropertyHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorAction <em>Behavior Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorAction
   * @generated
   */
  public Adapter createBehaviorActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorActionBlock <em>Behavior Action Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorActionBlock
   * @generated
   */
  public Adapter createBehaviorActionBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorActionCollection <em>Behavior Action Collection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorActionCollection
   * @generated
   */
  public Adapter createBehaviorActionCollectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorActions <em>Behavior Actions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorActions
   * @generated
   */
  public Adapter createBehaviorActionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorActionSequence <em>Behavior Action Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorActionSequence
   * @generated
   */
  public Adapter createBehaviorActionSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorActionSet <em>Behavior Action Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorActionSet
   * @generated
   */
  public Adapter createBehaviorActionSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorAnnex <em>Behavior Annex</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorAnnex
   * @generated
   */
  public Adapter createBehaviorAnnexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorBooleanLiteral <em>Behavior Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorBooleanLiteral
   * @generated
   */
  public Adapter createBehaviorBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorCondition <em>Behavior Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorCondition
   * @generated
   */
  public Adapter createBehaviorConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorElement <em>Behavior Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorElement
   * @generated
   */
  public Adapter createBehaviorElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorIntegerLiteral <em>Behavior Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorIntegerLiteral
   * @generated
   */
  public Adapter createBehaviorIntegerLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorNamedElement <em>Behavior Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorNamedElement
   * @generated
   */
  public Adapter createBehaviorNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorPropertyConstant <em>Behavior Property Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorPropertyConstant
   * @generated
   */
  public Adapter createBehaviorPropertyConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorRealLiteral <em>Behavior Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorRealLiteral
   * @generated
   */
  public Adapter createBehaviorRealLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorState <em>Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorState
   * @generated
   */
  public Adapter createBehaviorStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorStringLiteral <em>Behavior String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorStringLiteral
   * @generated
   */
  public Adapter createBehaviorStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorTime <em>Behavior Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorTime
   * @generated
   */
  public Adapter createBehaviorTimeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorTransition <em>Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorTransition
   * @generated
   */
  public Adapter createBehaviorTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorVariable <em>Behavior Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorVariable
   * @generated
   */
  public Adapter createBehaviorVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.BehaviorVariableHolder <em>Behavior Variable Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.BehaviorVariableHolder
   * @generated
   */
  public Adapter createBehaviorVariableHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.CalledSubprogramHolder <em>Called Subprogram Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.CalledSubprogramHolder
   * @generated
   */
  public Adapter createCalledSubprogramHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ClassifierFeatureHolder <em>Classifier Feature Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ClassifierFeatureHolder
   * @generated
   */
  public Adapter createClassifierFeatureHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.CommunicationAction <em>Communication Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.CommunicationAction
   * @generated
   */
  public Adapter createCommunicationActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.CompletionRelativeTimeout <em>Completion Relative Timeout</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.CompletionRelativeTimeout
   * @generated
   */
  public Adapter createCompletionRelativeTimeoutAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ClassifierFeaturePropertyReference <em>Classifier Feature Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ClassifierFeaturePropertyReference
   * @generated
   */
  public Adapter createClassifierFeaturePropertyReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.CondStatement <em>Cond Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.CondStatement
   * @generated
   */
  public Adapter createCondStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DataAccessHolder <em>Data Access Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DataAccessHolder
   * @generated
   */
  public Adapter createDataAccessHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DataAccessPrototypeHolder <em>Data Access Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DataAccessPrototypeHolder
   * @generated
   */
  public Adapter createDataAccessPrototypeHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DataComponentReference <em>Data Component Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DataComponentReference
   * @generated
   */
  public Adapter createDataComponentReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DataHolder <em>Data Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DataHolder
   * @generated
   */
  public Adapter createDataHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DataPortHolder <em>Data Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DataPortHolder
   * @generated
   */
  public Adapter createDataPortHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DataSubcomponentHolder <em>Data Subcomponent Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DataSubcomponentHolder
   * @generated
   */
  public Adapter createDataSubcomponentHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DispatchCondition <em>Dispatch Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DispatchCondition
   * @generated
   */
  public Adapter createDispatchConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DispatchConjunction <em>Dispatch Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DispatchConjunction
   * @generated
   */
  public Adapter createDispatchConjunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DispatchRelativeTimeout <em>Dispatch Relative Timeout</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DispatchRelativeTimeout
   * @generated
   */
  public Adapter createDispatchRelativeTimeoutAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DispatchTrigger <em>Dispatch Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DispatchTrigger
   * @generated
   */
  public Adapter createDispatchTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DispatchTriggerCondition
   * @generated
   */
  public Adapter createDispatchTriggerConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DispatchTriggerConditionStop <em>Dispatch Trigger Condition Stop</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DispatchTriggerConditionStop
   * @generated
   */
  public Adapter createDispatchTriggerConditionStopAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.DispatchTriggerLogicalExpression <em>Dispatch Trigger Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.DispatchTriggerLogicalExpression
   * @generated
   */
  public Adapter createDispatchTriggerLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ElementHolder <em>Element Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ElementHolder
   * @generated
   */
  public Adapter createElementHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ElementValues <em>Element Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ElementValues
   * @generated
   */
  public Adapter createElementValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ElseStatement <em>Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ElseStatement
   * @generated
   */
  public Adapter createElseStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.EnumLiteralHolder <em>Enum Literal Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.EnumLiteralHolder
   * @generated
   */
  public Adapter createEnumLiteralHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.EventDataPortHolder <em>Event Data Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.EventDataPortHolder
   * @generated
   */
  public Adapter createEventDataPortHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.EventPortHolder <em>Event Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.EventPortHolder
   * @generated
   */
  public Adapter createEventPortHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ExecuteCondition <em>Execute Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ExecuteCondition
   * @generated
   */
  public Adapter createExecuteConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ExecutionTimeoutCatch <em>Execution Timeout Catch</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ExecutionTimeoutCatch
   * @generated
   */
  public Adapter createExecutionTimeoutCatchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Factor <em>Factor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Factor
   * @generated
   */
  public Adapter createFactorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.FeaturePrototypeHolder <em>Feature Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.FeaturePrototypeHolder
   * @generated
   */
  public Adapter createFeaturePrototypeHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ForOrForAllStatement <em>For Or For All Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ForOrForAllStatement
   * @generated
   */
  public Adapter createForOrForAllStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.GroupableElement <em>Groupable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.GroupableElement
   * @generated
   */
  public Adapter createGroupableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.GroupHolder <em>Group Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.GroupHolder
   * @generated
   */
  public Adapter createGroupHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.GroupPrototypeHolder <em>Group Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.GroupPrototypeHolder
   * @generated
   */
  public Adapter createGroupPrototypeHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IndexableElement <em>Indexable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IndexableElement
   * @generated
   */
  public Adapter createIndexableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IntegerRange <em>Integer Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IntegerRange
   * @generated
   */
  public Adapter createIntegerRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IntegerValue
   * @generated
   */
  public Adapter createIntegerValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IntegerValueConstant <em>Integer Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IntegerValueConstant
   * @generated
   */
  public Adapter createIntegerValueConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IntegerValueVariable <em>Integer Value Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IntegerValueVariable
   * @generated
   */
  public Adapter createIntegerValueVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IterativeVariable <em>Iterative Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IterativeVariable
   * @generated
   */
  public Adapter createIterativeVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.IterativeVariableHolder <em>Iterative Variable Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.IterativeVariableHolder
   * @generated
   */
  public Adapter createIterativeVariableHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.LockAction <em>Lock Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.LockAction
   * @generated
   */
  public Adapter createLockActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.LoopStatement <em>Loop Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.LoopStatement
   * @generated
   */
  public Adapter createLoopStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.NumericLiteral <em>Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.NumericLiteral
   * @generated
   */
  public Adapter createNumericLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Otherwise <em>Otherwise</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Otherwise
   * @generated
   */
  public Adapter createOtherwiseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ParameterHolder <em>Parameter Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ParameterHolder
   * @generated
   */
  public Adapter createParameterHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ParameterLabel <em>Parameter Label</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ParameterLabel
   * @generated
   */
  public Adapter createParameterLabelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortCountValue <em>Port Count Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortCountValue
   * @generated
   */
  public Adapter createPortCountValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortDequeueAction <em>Port Dequeue Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortDequeueAction
   * @generated
   */
  public Adapter createPortDequeueActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortDequeueValue <em>Port Dequeue Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortDequeueValue
   * @generated
   */
  public Adapter createPortDequeueValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortFreezeAction <em>Port Freeze Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortFreezeAction
   * @generated
   */
  public Adapter createPortFreezeActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortFreshValue <em>Port Fresh Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortFreshValue
   * @generated
   */
  public Adapter createPortFreshValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortHolder <em>Port Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortHolder
   * @generated
   */
  public Adapter createPortHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortPrototypeHolder <em>Port Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortPrototypeHolder
   * @generated
   */
  public Adapter createPortPrototypeHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PortSendAction <em>Port Send Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PortSendAction
   * @generated
   */
  public Adapter createPortSendActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertyNameField <em>Property Name Field</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertyNameField
   * @generated
   */
  public Adapter createPropertyNameFieldAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertyNameHolder <em>Property Name Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertyNameHolder
   * @generated
   */
  public Adapter createPropertyNameHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertyElementHolder <em>Property Element Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertyElementHolder
   * @generated
   */
  public Adapter createPropertyElementHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertyAssociationHolder <em>Property Association Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertyAssociationHolder
   * @generated
   */
  public Adapter createPropertyAssociationHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertyExpressionHolder <em>Property Expression Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertyExpressionHolder
   * @generated
   */
  public Adapter createPropertyExpressionHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertyTypeHolder <em>Property Type Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertyTypeHolder
   * @generated
   */
  public Adapter createPropertyTypeHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PrototypeHolder <em>Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PrototypeHolder
   * @generated
   */
  public Adapter createPrototypeHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Relation
   * @generated
   */
  public Adapter createRelationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SharedDataAction <em>Shared Data Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SharedDataAction
   * @generated
   */
  public Adapter createSharedDataActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SimpleExpression <em>Simple Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SimpleExpression
   * @generated
   */
  public Adapter createSimpleExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.StructUnionElement <em>Struct Union Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.StructUnionElement
   * @generated
   */
  public Adapter createStructUnionElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.StructUnionElementHolder <em>Struct Union Element Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.StructUnionElementHolder
   * @generated
   */
  public Adapter createStructUnionElementHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SubprogramAccessHolder <em>Subprogram Access Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SubprogramAccessHolder
   * @generated
   */
  public Adapter createSubprogramAccessHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SubprogramCallAction <em>Subprogram Call Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SubprogramCallAction
   * @generated
   */
  public Adapter createSubprogramCallActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SubprogramHolder <em>Subprogram Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SubprogramHolder
   * @generated
   */
  public Adapter createSubprogramHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SubprogramHolderProxy <em>Subprogram Holder Proxy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SubprogramHolderProxy
   * @generated
   */
  public Adapter createSubprogramHolderProxyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SubprogramPrototypeHolder <em>Subprogram Prototype Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SubprogramPrototypeHolder
   * @generated
   */
  public Adapter createSubprogramPrototypeHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Target <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Target
   * @generated
   */
  public Adapter createTargetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.TimedAction <em>Timed Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.TimedAction
   * @generated
   */
  public Adapter createTimedActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.UnlockAction <em>Unlock Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.UnlockAction
   * @generated
   */
  public Adapter createUnlockActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ValueConstant <em>Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ValueConstant
   * @generated
   */
  public Adapter createValueConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ValueExpression <em>Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ValueExpression
   * @generated
   */
  public Adapter createValueExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ValueVariable <em>Value Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ValueVariable
   * @generated
   */
  public Adapter createValueVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.WhileOrDoUntilStatement <em>While Or Do Until Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.WhileOrDoUntilStatement
   * @generated
   */
  public Adapter createWhileOrDoUntilStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression <em>Mode Switch Trigger Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression
   * @generated
   */
  public Adapter createModeSwitchTriggerLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ModeSwitchTriggerCondition <em>Mode Switch Trigger Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ModeSwitchTriggerCondition
   * @generated
   */
  public Adapter createModeSwitchTriggerConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ModeSwitchConjunction <em>Mode Switch Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ModeSwitchConjunction
   * @generated
   */
  public Adapter createModeSwitchConjunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ModeSwitchTrigger <em>Mode Switch Trigger</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ModeSwitchTrigger
   * @generated
   */
  public Adapter createModeSwitchTriggerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertySetPropertyReference <em>Property Set Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertySetPropertyReference
   * @generated
   */
  public Adapter createPropertySetPropertyReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SubcomponentHolder <em>Subcomponent Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SubcomponentHolder
   * @generated
   */
  public Adapter createSubcomponentHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.SubprogramSubcomponentHolder <em>Subprogram Subcomponent Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.SubprogramSubcomponentHolder
   * @generated
   */
  public Adapter createSubprogramSubcomponentHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.FeatureHolder <em>Feature Holder</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.FeatureHolder
   * @generated
   */
  public Adapter createFeatureHolderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.ClassifierPropertyReference <em>Classifier Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.ClassifierPropertyReference
   * @generated
   */
  public Adapter createClassifierPropertyReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.PropertyReference <em>Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.PropertyReference
   * @generated
   */
  public Adapter createPropertyReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.UpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.UpperBound
   * @generated
   */
  public Adapter createUpperBoundAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.ba.aadlba.LowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.ba.aadlba.LowerBound
   * @generated
   */
  public Adapter createLowerBoundAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ModalElement <em>Modal Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ModalElement
   * @generated
   */
  public Adapter createModalElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexSubclause <em>Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexSubclause
   * @generated
   */
  public Adapter createAnnexSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyExpression <em>Property Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.PropertyExpression
   * @generated
   */
  public Adapter createPropertyExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.PropertyValue <em>Property Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.PropertyValue
   * @generated
   */
  public Adapter createPropertyValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.BooleanLiteral
   * @generated
   */
  public Adapter createBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.NumberValue <em>Number Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.NumberValue
   * @generated
   */
  public Adapter createNumberValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.IntegerLiteral
   * @generated
   */
  public Adapter createIntegerLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.RealLiteral
   * @generated
   */
  public Adapter createRealLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.StringLiteral
   * @generated
   */
  public Adapter createStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.ArrayableElement <em>Arrayable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.ArrayableElement
   * @generated
   */
  public Adapter createArrayableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.Data <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.Data
   * @generated
   */
  public Adapter createDataAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AadlBaAdapterFactory
