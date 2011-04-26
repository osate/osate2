/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage
 * @generated
 */
public interface ErrorModelFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ErrorModelFactory eINSTANCE = org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelFactoryImpl.init();

  /**
   * Returns a new object of class '<em>EM2 Annex Subclause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EM2 Annex Subclause</em>'.
   * @generated
   */
  EM2AnnexSubclause createEM2AnnexSubclause();

  /**
   * Returns a new object of class '<em>Error Type Set</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Type Set</em>'.
   * @generated
   */
  ErrorTypeSet createErrorTypeSet();

  /**
   * Returns a new object of class '<em>Error Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Type</em>'.
   * @generated
   */
  ErrorType createErrorType();

  /**
   * Returns a new object of class '<em>Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature</em>'.
   * @generated
   */
  Feature createFeature();

  /**
   * Returns a new object of class '<em>Error Type Refinement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Type Refinement</em>'.
   * @generated
   */
  ErrorTypeRefinement createErrorTypeRefinement();

  /**
   * Returns a new object of class '<em>Error Propagations</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Propagations</em>'.
   * @generated
   */
  ErrorPropagations createErrorPropagations();

  /**
   * Returns a new object of class '<em>Error Propagation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Propagation</em>'.
   * @generated
   */
  ErrorPropagation createErrorPropagation();

  /**
   * Returns a new object of class '<em>Error Flow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Flow</em>'.
   * @generated
   */
  ErrorFlow createErrorFlow();

  /**
   * Returns a new object of class '<em>Error Source</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Source</em>'.
   * @generated
   */
  ErrorSource createErrorSource();

  /**
   * Returns a new object of class '<em>Error Sink</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Sink</em>'.
   * @generated
   */
  ErrorSink createErrorSink();

  /**
   * Returns a new object of class '<em>Error Path</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Path</em>'.
   * @generated
   */
  ErrorPath createErrorPath();

  /**
   * Returns a new object of class '<em>Error Propagation Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Propagation Reference</em>'.
   * @generated
   */
  ErrorPropagationReference createErrorPropagationReference();

  /**
   * Returns a new object of class '<em>Error Behavior State Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior State Machine</em>'.
   * @generated
   */
  ErrorBehaviorStateMachine createErrorBehaviorStateMachine();

  /**
   * Returns a new object of class '<em>Error Behavior Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior Event</em>'.
   * @generated
   */
  ErrorBehaviorEvent createErrorBehaviorEvent();

  /**
   * Returns a new object of class '<em>Error Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Event</em>'.
   * @generated
   */
  ErrorEvent createErrorEvent();

  /**
   * Returns a new object of class '<em>Repair Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Repair Event</em>'.
   * @generated
   */
  RepairEvent createRepairEvent();

  /**
   * Returns a new object of class '<em>Error Behavior State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior State</em>'.
   * @generated
   */
  ErrorBehaviorState createErrorBehaviorState();

  /**
   * Returns a new object of class '<em>Error Behavior Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Behavior Transition</em>'.
   * @generated
   */
  ErrorBehaviorTransition createErrorBehaviorTransition();

  /**
   * Returns a new object of class '<em>Triggered Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Triggered Transition</em>'.
   * @generated
   */
  TriggeredTransition createTriggeredTransition();

  /**
   * Returns a new object of class '<em>Branch Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Branch Transition</em>'.
   * @generated
   */
  BranchTransition createBranchTransition();

  /**
   * Returns a new object of class '<em>Component Error Behavior</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Error Behavior</em>'.
   * @generated
   */
  ComponentErrorBehavior createComponentErrorBehavior();

  /**
   * Returns a new object of class '<em>Transition Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Condition</em>'.
   * @generated
   */
  TransitionCondition createTransitionCondition();

  /**
   * Returns a new object of class '<em>Trigger Condition Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trigger Condition Expression</em>'.
   * @generated
   */
  TriggerConditionExpression createTriggerConditionExpression();

  /**
   * Returns a new object of class '<em>Ormore Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ormore Expression</em>'.
   * @generated
   */
  OrmoreExpression createOrmoreExpression();

  /**
   * Returns a new object of class '<em>Orless Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Orless Expression</em>'.
   * @generated
   */
  OrlessExpression createOrlessExpression();

  /**
   * Returns a new object of class '<em>Others Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Others Expression</em>'.
   * @generated
   */
  OthersExpression createOthersExpression();

  /**
   * Returns a new object of class '<em>Error Event Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Error Event Reference</em>'.
   * @generated
   */
  ErrorEventReference createErrorEventReference();

  /**
   * Returns a new object of class '<em>Working Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Working Reference</em>'.
   * @generated
   */
  WorkingReference createWorkingReference();

  /**
   * Returns a new object of class '<em>Propagation Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Propagation Condition</em>'.
   * @generated
   */
  PropagationCondition createPropagationCondition();

  /**
   * Returns a new object of class '<em>Detection Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Detection Event</em>'.
   * @generated
   */
  DetectionEvent createDetectionEvent();

  /**
   * Returns a new object of class '<em>Composite Error Behavior</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composite Error Behavior</em>'.
   * @generated
   */
  CompositeErrorBehavior createCompositeErrorBehavior();

  /**
   * Returns a new object of class '<em>Composite State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composite State</em>'.
   * @generated
   */
  CompositeState createCompositeState();

  /**
   * Returns a new object of class '<em>State Condition Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Condition Expression</em>'.
   * @generated
   */
  StateConditionExpression createStateConditionExpression();

  /**
   * Returns a new object of class '<em>Subcomponent State Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subcomponent State Reference</em>'.
   * @generated
   */
  SubcomponentStateReference createSubcomponentStateReference();

  /**
   * Returns a new object of class '<em>Property Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Association</em>'.
   * @generated
   */
  PropertyAssociation createPropertyAssociation();

  /**
   * Returns a new object of class '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Expression</em>'.
   * @generated
   */
  PropertyExpression createPropertyExpression();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Probability Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Probability Value</em>'.
   * @generated
   */
  ProbabilityValue createProbabilityValue();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ErrorModelPackage getErrorModelPackage();

} //ErrorModelFactory
