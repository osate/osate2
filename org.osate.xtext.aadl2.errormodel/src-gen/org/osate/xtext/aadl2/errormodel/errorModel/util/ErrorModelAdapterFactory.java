/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.xtext.aadl2.errormodel.errorModel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
 * @generated
 */
public class ErrorModelAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ErrorModelPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ErrorModelPackage.eINSTANCE;
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
  protected ErrorModelSwitch<Adapter> modelSwitch =
    new ErrorModelSwitch<Adapter>()
    {
      @Override
      public Adapter caseEM2AnnexSubclause(EM2AnnexSubclause object)
      {
        return createEM2AnnexSubclauseAdapter();
      }
      @Override
      public Adapter caseErrorTypeSet(ErrorTypeSet object)
      {
        return createErrorTypeSetAdapter();
      }
      @Override
      public Adapter caseErrorType(ErrorType object)
      {
        return createErrorTypeAdapter();
      }
      @Override
      public Adapter caseFeature(Feature object)
      {
        return createFeatureAdapter();
      }
      @Override
      public Adapter caseErrorTypeRefinement(ErrorTypeRefinement object)
      {
        return createErrorTypeRefinementAdapter();
      }
      @Override
      public Adapter caseErrorPropagations(ErrorPropagations object)
      {
        return createErrorPropagationsAdapter();
      }
      @Override
      public Adapter caseErrorPropagation(ErrorPropagation object)
      {
        return createErrorPropagationAdapter();
      }
      @Override
      public Adapter caseErrorFlow(ErrorFlow object)
      {
        return createErrorFlowAdapter();
      }
      @Override
      public Adapter caseErrorSource(ErrorSource object)
      {
        return createErrorSourceAdapter();
      }
      @Override
      public Adapter caseErrorSink(ErrorSink object)
      {
        return createErrorSinkAdapter();
      }
      @Override
      public Adapter caseErrorPath(ErrorPath object)
      {
        return createErrorPathAdapter();
      }
      @Override
      public Adapter caseErrorPropagationReference(ErrorPropagationReference object)
      {
        return createErrorPropagationReferenceAdapter();
      }
      @Override
      public Adapter caseErrorBehaviorStateMachine(ErrorBehaviorStateMachine object)
      {
        return createErrorBehaviorStateMachineAdapter();
      }
      @Override
      public Adapter caseErrorBehaviorEvent(ErrorBehaviorEvent object)
      {
        return createErrorBehaviorEventAdapter();
      }
      @Override
      public Adapter caseErrorEvent(ErrorEvent object)
      {
        return createErrorEventAdapter();
      }
      @Override
      public Adapter caseRepairEvent(RepairEvent object)
      {
        return createRepairEventAdapter();
      }
      @Override
      public Adapter caseErrorBehaviorState(ErrorBehaviorState object)
      {
        return createErrorBehaviorStateAdapter();
      }
      @Override
      public Adapter caseErrorBehaviorTransition(ErrorBehaviorTransition object)
      {
        return createErrorBehaviorTransitionAdapter();
      }
      @Override
      public Adapter caseTriggeredTransition(TriggeredTransition object)
      {
        return createTriggeredTransitionAdapter();
      }
      @Override
      public Adapter caseBranchTransition(BranchTransition object)
      {
        return createBranchTransitionAdapter();
      }
      @Override
      public Adapter caseComponentErrorBehavior(ComponentErrorBehavior object)
      {
        return createComponentErrorBehaviorAdapter();
      }
      @Override
      public Adapter caseTransitionCondition(TransitionCondition object)
      {
        return createTransitionConditionAdapter();
      }
      @Override
      public Adapter caseTriggerConditionExpression(TriggerConditionExpression object)
      {
        return createTriggerConditionExpressionAdapter();
      }
      @Override
      public Adapter caseOrmoreExpression(OrmoreExpression object)
      {
        return createOrmoreExpressionAdapter();
      }
      @Override
      public Adapter caseOrlessExpression(OrlessExpression object)
      {
        return createOrlessExpressionAdapter();
      }
      @Override
      public Adapter caseOthersExpression(OthersExpression object)
      {
        return createOthersExpressionAdapter();
      }
      @Override
      public Adapter caseErrorEventReference(ErrorEventReference object)
      {
        return createErrorEventReferenceAdapter();
      }
      @Override
      public Adapter caseWorkingReference(WorkingReference object)
      {
        return createWorkingReferenceAdapter();
      }
      @Override
      public Adapter casePropagationCondition(PropagationCondition object)
      {
        return createPropagationConditionAdapter();
      }
      @Override
      public Adapter caseDetectionEvent(DetectionEvent object)
      {
        return createDetectionEventAdapter();
      }
      @Override
      public Adapter caseCompositeErrorBehavior(CompositeErrorBehavior object)
      {
        return createCompositeErrorBehaviorAdapter();
      }
      @Override
      public Adapter caseCompositeState(CompositeState object)
      {
        return createCompositeStateAdapter();
      }
      @Override
      public Adapter caseStateConditionExpression(StateConditionExpression object)
      {
        return createStateConditionExpressionAdapter();
      }
      @Override
      public Adapter caseSubcomponentStateReference(SubcomponentStateReference object)
      {
        return createSubcomponentStateReferenceAdapter();
      }
      @Override
      public Adapter casePropertyAssociation(PropertyAssociation object)
      {
        return createPropertyAssociationAdapter();
      }
      @Override
      public Adapter casePropertyExpression(PropertyExpression object)
      {
        return createPropertyExpressionAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseProbabilityValue(ProbabilityValue object)
      {
        return createProbabilityValueAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseOrExpression(OrExpression object)
      {
        return createOrExpressionAdapter();
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause <em>EM2 Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause
   * @generated
   */
  public Adapter createEM2AnnexSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet <em>Error Type Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet
   * @generated
   */
  public Adapter createErrorTypeSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType <em>Error Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorType
   * @generated
   */
  public Adapter createErrorTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.Feature
   * @generated
   */
  public Adapter createFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement <em>Error Type Refinement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement
   * @generated
   */
  public Adapter createErrorTypeRefinementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations <em>Error Propagations</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations
   * @generated
   */
  public Adapter createErrorPropagationsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation <em>Error Propagation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
   * @generated
   */
  public Adapter createErrorPropagationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow <em>Error Flow</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow
   * @generated
   */
  public Adapter createErrorFlowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource <em>Error Source</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
   * @generated
   */
  public Adapter createErrorSourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink <em>Error Sink</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink
   * @generated
   */
  public Adapter createErrorSinkAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath <em>Error Path</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath
   * @generated
   */
  public Adapter createErrorPathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference <em>Error Propagation Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference
   * @generated
   */
  public Adapter createErrorPropagationReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine <em>Error Behavior State Machine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine
   * @generated
   */
  public Adapter createErrorBehaviorStateMachineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent <em>Error Behavior Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent
   * @generated
   */
  public Adapter createErrorBehaviorEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent <em>Error Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
   * @generated
   */
  public Adapter createErrorEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent <em>Repair Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent
   * @generated
   */
  public Adapter createRepairEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState <em>Error Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
   * @generated
   */
  public Adapter createErrorBehaviorStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition <em>Error Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition
   * @generated
   */
  public Adapter createErrorBehaviorTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition <em>Triggered Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition
   * @generated
   */
  public Adapter createTriggeredTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchTransition <em>Branch Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.BranchTransition
   * @generated
   */
  public Adapter createBranchTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior <em>Component Error Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior
   * @generated
   */
  public Adapter createComponentErrorBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition <em>Transition Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition
   * @generated
   */
  public Adapter createTransitionConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression <em>Trigger Condition Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression
   * @generated
   */
  public Adapter createTriggerConditionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression <em>Ormore Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression
   * @generated
   */
  public Adapter createOrmoreExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression <em>Orless Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression
   * @generated
   */
  public Adapter createOrlessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OthersExpression <em>Others Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OthersExpression
   * @generated
   */
  public Adapter createOthersExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEventReference <em>Error Event Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorEventReference
   * @generated
   */
  public Adapter createErrorEventReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference <em>Working Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference
   * @generated
   */
  public Adapter createWorkingReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition <em>Propagation Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition
   * @generated
   */
  public Adapter createPropagationConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent <em>Detection Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent
   * @generated
   */
  public Adapter createDetectionEventAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior <em>Composite Error Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior
   * @generated
   */
  public Adapter createCompositeErrorBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState <em>Composite State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeState
   * @generated
   */
  public Adapter createCompositeStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.StateConditionExpression <em>State Condition Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.StateConditionExpression
   * @generated
   */
  public Adapter createStateConditionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference <em>Subcomponent State Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference
   * @generated
   */
  public Adapter createSubcomponentStateReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation <em>Property Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation
   * @generated
   */
  public Adapter createPropertyAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropertyExpression <em>Property Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropertyExpression
   * @generated
   */
  public Adapter createPropertyExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue <em>Probability Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue
   * @generated
   */
  public Adapter createProbabilityValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrExpression
   * @generated
   */
  public Adapter createOrExpressionAdapter()
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

} //ErrorModelAdapterFactory
