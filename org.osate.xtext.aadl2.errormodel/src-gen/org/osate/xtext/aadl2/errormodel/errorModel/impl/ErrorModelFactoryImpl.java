/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.xtext.aadl2.errormodel.errorModel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorModelFactoryImpl extends EFactoryImpl implements ErrorModelFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ErrorModelFactory init()
  {
    try
    {
      ErrorModelFactory theErrorModelFactory = (ErrorModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.osate.org/aadl2/errormodel/ErrorModel"); 
      if (theErrorModelFactory != null)
      {
        return theErrorModelFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ErrorModelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ErrorModelPackage.EM2_ANNEX_SUBCLAUSE: return createEM2AnnexSubclause();
      case ErrorModelPackage.ERROR_TYPE_SET: return createErrorTypeSet();
      case ErrorModelPackage.ERROR_TYPE: return createErrorType();
      case ErrorModelPackage.FEATURE: return createFeature();
      case ErrorModelPackage.ERROR_TYPE_REFINEMENT: return createErrorTypeRefinement();
      case ErrorModelPackage.ERROR_PROPAGATIONS: return createErrorPropagations();
      case ErrorModelPackage.ERROR_PROPAGATION: return createErrorPropagation();
      case ErrorModelPackage.ERROR_FLOW: return createErrorFlow();
      case ErrorModelPackage.ERROR_SOURCE: return createErrorSource();
      case ErrorModelPackage.ERROR_SINK: return createErrorSink();
      case ErrorModelPackage.ERROR_PATH: return createErrorPath();
      case ErrorModelPackage.ERROR_PROPAGATION_REFERENCE: return createErrorPropagationReference();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE: return createErrorBehaviorStateMachine();
      case ErrorModelPackage.ERROR_BEHAVIOR_EVENT: return createErrorBehaviorEvent();
      case ErrorModelPackage.ERROR_EVENT: return createErrorEvent();
      case ErrorModelPackage.REPAIR_EVENT: return createRepairEvent();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE: return createErrorBehaviorState();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION: return createErrorBehaviorTransition();
      case ErrorModelPackage.TRIGGERED_TRANSITION: return createTriggeredTransition();
      case ErrorModelPackage.BRANCH_TRANSITION: return createBranchTransition();
      case ErrorModelPackage.COMPONENT_ERROR_BEHAVIOR: return createComponentErrorBehavior();
      case ErrorModelPackage.TRANSITION_CONDITION: return createTransitionCondition();
      case ErrorModelPackage.TRIGGER_CONDITION_EXPRESSION: return createTriggerConditionExpression();
      case ErrorModelPackage.ORMORE_EXPRESSION: return createOrmoreExpression();
      case ErrorModelPackage.ORLESS_EXPRESSION: return createOrlessExpression();
      case ErrorModelPackage.OTHERS_EXPRESSION: return createOthersExpression();
      case ErrorModelPackage.ERROR_EVENT_REFERENCE: return createErrorEventReference();
      case ErrorModelPackage.WORKING_REFERENCE: return createWorkingReference();
      case ErrorModelPackage.PROPAGATION_CONDITION: return createPropagationCondition();
      case ErrorModelPackage.DETECTION_EVENT: return createDetectionEvent();
      case ErrorModelPackage.COMPOSITE_ERROR_BEHAVIOR: return createCompositeErrorBehavior();
      case ErrorModelPackage.COMPOSITE_STATE: return createCompositeState();
      case ErrorModelPackage.STATE_CONDITION_EXPRESSION: return createStateConditionExpression();
      case ErrorModelPackage.SUBCOMPONENT_STATE_REFERENCE: return createSubcomponentStateReference();
      case ErrorModelPackage.PROPERTY_ASSOCIATION: return createPropertyAssociation();
      case ErrorModelPackage.PROPERTY_EXPRESSION: return createPropertyExpression();
      case ErrorModelPackage.LITERAL: return createLiteral();
      case ErrorModelPackage.PROBABILITY_VALUE: return createProbabilityValue();
      case ErrorModelPackage.AND_EXPRESSION: return createAndExpression();
      case ErrorModelPackage.OR_EXPRESSION: return createOrExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ErrorModelPackage.PROPAGATION_DIRECTION:
        return createPropagationDirectionFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ErrorModelPackage.PROPAGATION_DIRECTION:
        return convertPropagationDirectionToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EM2AnnexSubclause createEM2AnnexSubclause()
  {
    EM2AnnexSubclauseImpl em2AnnexSubclause = new EM2AnnexSubclauseImpl();
    return em2AnnexSubclause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypeSet createErrorTypeSet()
  {
    ErrorTypeSetImpl errorTypeSet = new ErrorTypeSetImpl();
    return errorTypeSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorType createErrorType()
  {
    ErrorTypeImpl errorType = new ErrorTypeImpl();
    return errorType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypeRefinement createErrorTypeRefinement()
  {
    ErrorTypeRefinementImpl errorTypeRefinement = new ErrorTypeRefinementImpl();
    return errorTypeRefinement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagations createErrorPropagations()
  {
    ErrorPropagationsImpl errorPropagations = new ErrorPropagationsImpl();
    return errorPropagations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagation createErrorPropagation()
  {
    ErrorPropagationImpl errorPropagation = new ErrorPropagationImpl();
    return errorPropagation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorFlow createErrorFlow()
  {
    ErrorFlowImpl errorFlow = new ErrorFlowImpl();
    return errorFlow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorSource createErrorSource()
  {
    ErrorSourceImpl errorSource = new ErrorSourceImpl();
    return errorSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorSink createErrorSink()
  {
    ErrorSinkImpl errorSink = new ErrorSinkImpl();
    return errorSink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPath createErrorPath()
  {
    ErrorPathImpl errorPath = new ErrorPathImpl();
    return errorPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorPropagationReference createErrorPropagationReference()
  {
    ErrorPropagationReferenceImpl errorPropagationReference = new ErrorPropagationReferenceImpl();
    return errorPropagationReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorStateMachine createErrorBehaviorStateMachine()
  {
    ErrorBehaviorStateMachineImpl errorBehaviorStateMachine = new ErrorBehaviorStateMachineImpl();
    return errorBehaviorStateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorEvent createErrorBehaviorEvent()
  {
    ErrorBehaviorEventImpl errorBehaviorEvent = new ErrorBehaviorEventImpl();
    return errorBehaviorEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorEvent createErrorEvent()
  {
    ErrorEventImpl errorEvent = new ErrorEventImpl();
    return errorEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RepairEvent createRepairEvent()
  {
    RepairEventImpl repairEvent = new RepairEventImpl();
    return repairEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorState createErrorBehaviorState()
  {
    ErrorBehaviorStateImpl errorBehaviorState = new ErrorBehaviorStateImpl();
    return errorBehaviorState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorTransition createErrorBehaviorTransition()
  {
    ErrorBehaviorTransitionImpl errorBehaviorTransition = new ErrorBehaviorTransitionImpl();
    return errorBehaviorTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggeredTransition createTriggeredTransition()
  {
    TriggeredTransitionImpl triggeredTransition = new TriggeredTransitionImpl();
    return triggeredTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BranchTransition createBranchTransition()
  {
    BranchTransitionImpl branchTransition = new BranchTransitionImpl();
    return branchTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentErrorBehavior createComponentErrorBehavior()
  {
    ComponentErrorBehaviorImpl componentErrorBehavior = new ComponentErrorBehaviorImpl();
    return componentErrorBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitionCondition createTransitionCondition()
  {
    TransitionConditionImpl transitionCondition = new TransitionConditionImpl();
    return transitionCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerConditionExpression createTriggerConditionExpression()
  {
    TriggerConditionExpressionImpl triggerConditionExpression = new TriggerConditionExpressionImpl();
    return triggerConditionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrmoreExpression createOrmoreExpression()
  {
    OrmoreExpressionImpl ormoreExpression = new OrmoreExpressionImpl();
    return ormoreExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrlessExpression createOrlessExpression()
  {
    OrlessExpressionImpl orlessExpression = new OrlessExpressionImpl();
    return orlessExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OthersExpression createOthersExpression()
  {
    OthersExpressionImpl othersExpression = new OthersExpressionImpl();
    return othersExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorEventReference createErrorEventReference()
  {
    ErrorEventReferenceImpl errorEventReference = new ErrorEventReferenceImpl();
    return errorEventReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkingReference createWorkingReference()
  {
    WorkingReferenceImpl workingReference = new WorkingReferenceImpl();
    return workingReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropagationCondition createPropagationCondition()
  {
    PropagationConditionImpl propagationCondition = new PropagationConditionImpl();
    return propagationCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DetectionEvent createDetectionEvent()
  {
    DetectionEventImpl detectionEvent = new DetectionEventImpl();
    return detectionEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompositeErrorBehavior createCompositeErrorBehavior()
  {
    CompositeErrorBehaviorImpl compositeErrorBehavior = new CompositeErrorBehaviorImpl();
    return compositeErrorBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompositeState createCompositeState()
  {
    CompositeStateImpl compositeState = new CompositeStateImpl();
    return compositeState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateConditionExpression createStateConditionExpression()
  {
    StateConditionExpressionImpl stateConditionExpression = new StateConditionExpressionImpl();
    return stateConditionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubcomponentStateReference createSubcomponentStateReference()
  {
    SubcomponentStateReferenceImpl subcomponentStateReference = new SubcomponentStateReferenceImpl();
    return subcomponentStateReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyAssociation createPropertyAssociation()
  {
    PropertyAssociationImpl propertyAssociation = new PropertyAssociationImpl();
    return propertyAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyExpression createPropertyExpression()
  {
    PropertyExpressionImpl propertyExpression = new PropertyExpressionImpl();
    return propertyExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProbabilityValue createProbabilityValue()
  {
    ProbabilityValueImpl probabilityValue = new ProbabilityValueImpl();
    return probabilityValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpression createOrExpression()
  {
    OrExpressionImpl orExpression = new OrExpressionImpl();
    return orExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropagationDirection createPropagationDirectionFromString(EDataType eDataType, String initialValue)
  {
    PropagationDirection result = PropagationDirection.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPropagationDirectionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelPackage getErrorModelPackage()
  {
    return (ErrorModelPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ErrorModelPackage getPackage()
  {
    return ErrorModelPackage.eINSTANCE;
  }

} //ErrorModelFactoryImpl
