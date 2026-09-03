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
package org.osate.xtext.aadl2.ba.behaviorAnnex.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

import org.osate.xtext.aadl2.ba.behaviorAnnex.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage
 * @generated
 */
public class BehaviorAnnexAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static BehaviorAnnexPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorAnnexAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = BehaviorAnnexPackage.eINSTANCE;
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
  protected BehaviorAnnexSwitch<Adapter> modelSwitch =
    new BehaviorAnnexSwitch<Adapter>()
    {
      @Override
      public Adapter caseBehaviorAnnex(BehaviorAnnex object)
      {
        return createBehaviorAnnexAdapter();
      }
      @Override
      public Adapter caseBehaviorVariableGroup(BehaviorVariableGroup object)
      {
        return createBehaviorVariableGroupAdapter();
      }
      @Override
      public Adapter caseBehaviorVariable(BehaviorVariable object)
      {
        return createBehaviorVariableAdapter();
      }
      @Override
      public Adapter caseArrayDimension(ArrayDimension object)
      {
        return createArrayDimensionAdapter();
      }
      @Override
      public Adapter caseBehaviorPropertyAssociation(BehaviorPropertyAssociation object)
      {
        return createBehaviorPropertyAssociationAdapter();
      }
      @Override
      public Adapter caseBehaviorStateGroup(BehaviorStateGroup object)
      {
        return createBehaviorStateGroupAdapter();
      }
      @Override
      public Adapter caseBehaviorState(BehaviorState object)
      {
        return createBehaviorStateAdapter();
      }
      @Override
      public Adapter caseBehaviorTransition(BehaviorTransition object)
      {
        return createBehaviorTransitionAdapter();
      }
      @Override
      public Adapter caseBehaviorCondition(BehaviorCondition object)
      {
        return createBehaviorConditionAdapter();
      }
      @Override
      public Adapter caseExecuteCondition(ExecuteCondition object)
      {
        return createExecuteConditionAdapter();
      }
      @Override
      public Adapter caseDispatchCondition(DispatchCondition object)
      {
        return createDispatchConditionAdapter();
      }
      @Override
      public Adapter caseDispatchTriggerCondition(DispatchTriggerCondition object)
      {
        return createDispatchTriggerConditionAdapter();
      }
      @Override
      public Adapter caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
      {
        return createDispatchTriggerLogicalExpressionAdapter();
      }
      @Override
      public Adapter caseDispatchConjunction(DispatchConjunction object)
      {
        return createDispatchConjunctionAdapter();
      }
      @Override
      public Adapter caseModeSwitchCondition(ModeSwitchCondition object)
      {
        return createModeSwitchConditionAdapter();
      }
      @Override
      public Adapter caseModeSwitchConjunction(ModeSwitchConjunction object)
      {
        return createModeSwitchConjunctionAdapter();
      }
      @Override
      public Adapter caseBehaviorActionBlock(BehaviorActionBlock object)
      {
        return createBehaviorActionBlockAdapter();
      }
      @Override
      public Adapter caseBehaviorActions(BehaviorActions object)
      {
        return createBehaviorActionsAdapter();
      }
      @Override
      public Adapter caseBehaviorAction(BehaviorAction object)
      {
        return createBehaviorActionAdapter();
      }
      @Override
      public Adapter caseAssignmentAction(AssignmentAction object)
      {
        return createAssignmentActionAdapter();
      }
      @Override
      public Adapter caseCommunicationAction(CommunicationAction object)
      {
        return createCommunicationActionAdapter();
      }
      @Override
      public Adapter caseTimedAction(TimedAction object)
      {
        return createTimedActionAdapter();
      }
      @Override
      public Adapter caseIfStatement(IfStatement object)
      {
        return createIfStatementAdapter();
      }
      @Override
      public Adapter caseElseIfClause(ElseIfClause object)
      {
        return createElseIfClauseAdapter();
      }
      @Override
      public Adapter caseForStatement(ForStatement object)
      {
        return createForStatementAdapter();
      }
      @Override
      public Adapter caseWhileStatement(WhileStatement object)
      {
        return createWhileStatementAdapter();
      }
      @Override
      public Adapter caseDoUntilStatement(DoUntilStatement object)
      {
        return createDoUntilStatementAdapter();
      }
      @Override
      public Adapter caseElementValues(ElementValues object)
      {
        return createElementValuesAdapter();
      }
      @Override
      public Adapter caseBehaviorTime(BehaviorTime object)
      {
        return createBehaviorTimeAdapter();
      }
      @Override
      public Adapter caseIntegerValue(IntegerValue object)
      {
        return createIntegerValueAdapter();
      }
      @Override
      public Adapter caseValueExpression(ValueExpression object)
      {
        return createValueExpressionAdapter();
      }
      @Override
      public Adapter caseValueConstant(ValueConstant object)
      {
        return createValueConstantAdapter();
      }
      @Override
      public Adapter caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
      {
        return createBehaviorIntegerLiteralAdapter();
      }
      @Override
      public Adapter caseBehaviorRealLiteral(BehaviorRealLiteral object)
      {
        return createBehaviorRealLiteralAdapter();
      }
      @Override
      public Adapter caseBehaviorStringLiteral(BehaviorStringLiteral object)
      {
        return createBehaviorStringLiteralAdapter();
      }
      @Override
      public Adapter caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
      {
        return createBehaviorBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseReferenceExpression(ReferenceExpression object)
      {
        return createReferenceExpressionAdapter();
      }
      @Override
      public Adapter caseHashPropertyReference(HashPropertyReference object)
      {
        return createHashPropertyReferenceAdapter();
      }
      @Override
      public Adapter casePropertyReferenceTail(PropertyReferenceTail object)
      {
        return createPropertyReferenceTailAdapter();
      }
      @Override
      public Adapter caseNamedPropertyField(NamedPropertyField object)
      {
        return createNamedPropertyFieldAdapter();
      }
      @Override
      public Adapter casePropertyArrayIndex(PropertyArrayIndex object)
      {
        return createPropertyArrayIndexAdapter();
      }
      @Override
      public Adapter casePropertyIndexValue(PropertyIndexValue object)
      {
        return createPropertyIndexValueAdapter();
      }
      @Override
      public Adapter casePropertyIndexPropertyReference(PropertyIndexPropertyReference object)
      {
        return createPropertyIndexPropertyReferenceAdapter();
      }
      @Override
      public Adapter caseUnindexedReferenceExpression(UnindexedReferenceExpression object)
      {
        return createUnindexedReferenceExpressionAdapter();
      }
      @Override
      public Adapter caseUnindexedReference(UnindexedReference object)
      {
        return createUnindexedReferenceAdapter();
      }
      @Override
      public Adapter caseUnindexedReferenceTail(UnindexedReferenceTail object)
      {
        return createUnindexedReferenceTailAdapter();
      }
      @Override
      public Adapter caseUnindexedReferenceSegment(UnindexedReferenceSegment object)
      {
        return createUnindexedReferenceSegmentAdapter();
      }
      @Override
      public Adapter caseReference(Reference object)
      {
        return createReferenceAdapter();
      }
      @Override
      public Adapter caseReferenceTail(ReferenceTail object)
      {
        return createReferenceTailAdapter();
      }
      @Override
      public Adapter caseReferenceSegment(ReferenceSegment object)
      {
        return createReferenceSegmentAdapter();
      }
      @Override
      public Adapter caseArrayIndex(ArrayIndex object)
      {
        return createArrayIndexAdapter();
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
      public Adapter caseBinaryExpression(BinaryExpression object)
      {
        return createBinaryExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex <em>Behavior Annex</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex
   * @generated
   */
  public Adapter createBehaviorAnnexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup <em>Behavior Variable Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup
   * @generated
   */
  public Adapter createBehaviorVariableGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable <em>Behavior Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable
   * @generated
   */
  public Adapter createBehaviorVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension <em>Array Dimension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension
   * @generated
   */
  public Adapter createArrayDimensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation <em>Behavior Property Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorPropertyAssociation
   * @generated
   */
  public Adapter createBehaviorPropertyAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup <em>Behavior State Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup
   * @generated
   */
  public Adapter createBehaviorStateGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState <em>Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState
   * @generated
   */
  public Adapter createBehaviorStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition <em>Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition
   * @generated
   */
  public Adapter createBehaviorTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition <em>Behavior Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorCondition
   * @generated
   */
  public Adapter createBehaviorConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition <em>Execute Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ExecuteCondition
   * @generated
   */
  public Adapter createExecuteConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition <em>Dispatch Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition
   * @generated
   */
  public Adapter createDispatchConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition <em>Dispatch Trigger Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition
   * @generated
   */
  public Adapter createDispatchTriggerConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression <em>Dispatch Trigger Logical Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerLogicalExpression
   * @generated
   */
  public Adapter createDispatchTriggerLogicalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction <em>Dispatch Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchConjunction
   * @generated
   */
  public Adapter createDispatchConjunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition <em>Mode Switch Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchCondition
   * @generated
   */
  public Adapter createModeSwitchConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction <em>Mode Switch Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchConjunction
   * @generated
   */
  public Adapter createModeSwitchConjunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock <em>Behavior Action Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionBlock
   * @generated
   */
  public Adapter createBehaviorActionBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions <em>Behavior Actions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActions
   * @generated
   */
  public Adapter createBehaviorActionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction <em>Behavior Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAction
   * @generated
   */
  public Adapter createBehaviorActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction <em>Assignment Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction
   * @generated
   */
  public Adapter createAssignmentActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction <em>Communication Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction
   * @generated
   */
  public Adapter createCommunicationActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction <em>Timed Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction
   * @generated
   */
  public Adapter createTimedActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement <em>If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement
   * @generated
   */
  public Adapter createIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause <em>Else If Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause
   * @generated
   */
  public Adapter createElseIfClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement
   * @generated
   */
  public Adapter createForStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.WhileStatement
   * @generated
   */
  public Adapter createWhileStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement <em>Do Until Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.DoUntilStatement
   * @generated
   */
  public Adapter createDoUntilStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues <em>Element Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ElementValues
   * @generated
   */
  public Adapter createElementValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime <em>Behavior Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime
   * @generated
   */
  public Adapter createBehaviorTimeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue
   * @generated
   */
  public Adapter createIntegerValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression <em>Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression
   * @generated
   */
  public Adapter createValueExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant <em>Value Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ValueConstant
   * @generated
   */
  public Adapter createValueConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral <em>Behavior Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral
   * @generated
   */
  public Adapter createBehaviorIntegerLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral <em>Behavior Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorRealLiteral
   * @generated
   */
  public Adapter createBehaviorRealLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral <em>Behavior String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStringLiteral
   * @generated
   */
  public Adapter createBehaviorStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral <em>Behavior Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorBooleanLiteral
   * @generated
   */
  public Adapter createBehaviorBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression <em>Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression
   * @generated
   */
  public Adapter createReferenceExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference <em>Hash Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference
   * @generated
   */
  public Adapter createHashPropertyReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail <em>Property Reference Tail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail
   * @generated
   */
  public Adapter createPropertyReferenceTailAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField <em>Named Property Field</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField
   * @generated
   */
  public Adapter createNamedPropertyFieldAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex <em>Property Array Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyArrayIndex
   * @generated
   */
  public Adapter createPropertyArrayIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexValue <em>Property Index Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexValue
   * @generated
   */
  public Adapter createPropertyIndexValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference <em>Property Index Property Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference
   * @generated
   */
  public Adapter createPropertyIndexPropertyReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression <em>Unindexed Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression
   * @generated
   */
  public Adapter createUnindexedReferenceExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference <em>Unindexed Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference
   * @generated
   */
  public Adapter createUnindexedReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail <em>Unindexed Reference Tail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail
   * @generated
   */
  public Adapter createUnindexedReferenceTailAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment <em>Unindexed Reference Segment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment
   * @generated
   */
  public Adapter createUnindexedReferenceSegmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.Reference
   * @generated
   */
  public Adapter createReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail <em>Reference Tail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail
   * @generated
   */
  public Adapter createReferenceTailAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment <em>Reference Segment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment
   * @generated
   */
  public Adapter createReferenceSegmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex <em>Array Index</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex
   * @generated
   */
  public Adapter createArrayIndexAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence <em>Behavior Action Sequence</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSequence
   * @generated
   */
  public Adapter createBehaviorActionSequenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet <em>Behavior Action Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorActionSet
   * @generated
   */
  public Adapter createBehaviorActionSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression <em>Binary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BinaryExpression
   * @generated
   */
  public Adapter createBinaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
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

} //BehaviorAnnexAdapterFactory
