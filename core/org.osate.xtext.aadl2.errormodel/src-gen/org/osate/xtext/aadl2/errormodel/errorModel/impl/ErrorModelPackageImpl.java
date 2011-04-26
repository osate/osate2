/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEventReference;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.Feature;
import org.osate.xtext.aadl2.errormodel.errorModel.Literal;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OthersExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection;
import org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.PropertyExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.StateConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ErrorModelPackageImpl extends EPackageImpl implements ErrorModelPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass em2AnnexSubclauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorTypeSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorTypeRefinementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorPropagationsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorPropagationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorFlowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorSourceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorSinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorPathEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorPropagationReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorStateMachineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass repairEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorBehaviorTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggeredTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass branchTransitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentErrorBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass triggerConditionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ormoreExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orlessExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass othersExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorEventReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass workingReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propagationConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass detectionEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compositeErrorBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compositeStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateConditionExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subcomponentStateReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyAssociationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyExpressionEClass = null;

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
  private EClass probabilityValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum propagationDirectionEEnum = null;

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
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ErrorModelPackageImpl()
  {
    super(eNS_URI, ErrorModelFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ErrorModelPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ErrorModelPackage init()
  {
    if (isInited) return (ErrorModelPackage)EPackage.Registry.INSTANCE.getEPackage(ErrorModelPackage.eNS_URI);

    // Obtain or create and register package
    ErrorModelPackageImpl theErrorModelPackage = (ErrorModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ErrorModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ErrorModelPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theErrorModelPackage.createPackageContents();

    // Initialize created meta-data
    theErrorModelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theErrorModelPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ErrorModelPackage.eNS_URI, theErrorModelPackage);
    return theErrorModelPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEM2AnnexSubclause()
  {
    return em2AnnexSubclauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEM2AnnexSubclause_Types()
  {
    return (EReference)em2AnnexSubclauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEM2AnnexSubclause_Ebsm()
  {
    return (EReference)em2AnnexSubclauseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEM2AnnexSubclause_Ep()
  {
    return (EReference)em2AnnexSubclauseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEM2AnnexSubclause_Ceb()
  {
    return (EReference)em2AnnexSubclauseEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEM2AnnexSubclause_Compeb()
  {
    return (EReference)em2AnnexSubclauseEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorTypeSet()
  {
    return errorTypeSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorTypeSet_Name()
  {
    return (EAttribute)errorTypeSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorTypeSet_Types()
  {
    return (EReference)errorTypeSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorTypeSet_Features()
  {
    return (EReference)errorTypeSetEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorTypeSet_Extends()
  {
    return (EReference)errorTypeSetEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorTypeSet_Refinements()
  {
    return (EReference)errorTypeSetEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorType()
  {
    return errorTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorType_Name()
  {
    return (EAttribute)errorTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorType_Subtypes()
  {
    return (EReference)errorTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeature()
  {
    return featureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeature_Name()
  {
    return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorTypeRefinement()
  {
    return errorTypeRefinementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorTypeRefinement_Name()
  {
    return (EReference)errorTypeRefinementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorTypeRefinement_Subtypes()
  {
    return (EReference)errorTypeRefinementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorPropagations()
  {
    return errorPropagationsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagations_ImportedNamespace()
  {
    return (EAttribute)errorPropagationsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagations_Propagations()
  {
    return (EReference)errorPropagationsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagations_Flows()
  {
    return (EReference)errorPropagationsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorPropagation()
  {
    return errorPropagationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagation_Type()
  {
    return (EReference)errorPropagationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagation_Mask()
  {
    return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagation_Direction()
  {
    return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagation_Binding()
  {
    return (EAttribute)errorPropagationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagation_Appliesto()
  {
    return (EReference)errorPropagationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorFlow()
  {
    return errorFlowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorSource()
  {
    return errorSourceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSource_Outgoing()
  {
    return (EReference)errorSourceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorSink()
  {
    return errorSinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorSink_Incoming()
  {
    return (EReference)errorSinkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorPath()
  {
    return errorPathEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPath_Incoming()
  {
    return (EReference)errorPathEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPath_Outgoing()
  {
    return (EReference)errorPathEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorPropagationReference()
  {
    return errorPropagationReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagationReference_Binding()
  {
    return (EAttribute)errorPropagationReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagationReference_Feature()
  {
    return (EReference)errorPropagationReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorPropagationReference_Self()
  {
    return (EAttribute)errorPropagationReferenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorPropagationReference_Errortype()
  {
    return (EReference)errorPropagationReferenceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorStateMachine()
  {
    return errorBehaviorStateMachineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorStateMachine_Name()
  {
    return (EAttribute)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_Extends()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorStateMachine_ImportedNamespace()
  {
    return (EAttribute)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_Events()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_States()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorStateMachine_Transitions()
  {
    return (EReference)errorBehaviorStateMachineEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorEvent()
  {
    return errorBehaviorEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorEvent_Name()
  {
    return (EAttribute)errorBehaviorEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorEvent()
  {
    return errorEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRepairEvent()
  {
    return repairEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorState()
  {
    return errorBehaviorStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorState_Name()
  {
    return (EAttribute)errorBehaviorStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorBehaviorState_Intial()
  {
    return (EAttribute)errorBehaviorStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorState_Properties()
  {
    return (EReference)errorBehaviorStateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorBehaviorTransition()
  {
    return errorBehaviorTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_Source()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorBehaviorTransition_Destination()
  {
    return (EReference)errorBehaviorTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTriggeredTransition()
  {
    return triggeredTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTriggeredTransition_Name()
  {
    return (EAttribute)triggeredTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTriggeredTransition_Events()
  {
    return (EReference)triggeredTransitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBranchTransition()
  {
    return branchTransitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBranchTransition_Value()
  {
    return (EAttribute)branchTransitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentErrorBehavior()
  {
    return componentErrorBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponentErrorBehavior_ImportedNamespace()
  {
    return (EAttribute)componentErrorBehaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentErrorBehavior_TransitionCondition()
  {
    return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentErrorBehavior_PropagationCondition()
  {
    return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentErrorBehavior_DetectionEvent()
  {
    return (EReference)componentErrorBehaviorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionCondition()
  {
    return transitionConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionCondition_ErrorTransition()
  {
    return (EReference)transitionConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransitionCondition_Mask()
  {
    return (EAttribute)transitionConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionCondition_Condition()
  {
    return (EReference)transitionConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTriggerConditionExpression()
  {
    return triggerConditionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrmoreExpression()
  {
    return ormoreExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrmoreExpression_Count()
  {
    return (EAttribute)ormoreExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrmoreExpression_Operands()
  {
    return (EReference)ormoreExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrlessExpression()
  {
    return orlessExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrlessExpression_Count()
  {
    return (EAttribute)orlessExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrlessExpression_Operands()
  {
    return (EReference)orlessExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOthersExpression()
  {
    return othersExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorEventReference()
  {
    return errorEventReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getErrorEventReference_Reference()
  {
    return (EReference)errorEventReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorkingReference()
  {
    return workingReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorkingReference_Binding()
  {
    return (EAttribute)workingReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkingReference_Feature()
  {
    return (EReference)workingReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorkingReference_Self()
  {
    return (EAttribute)workingReferenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorkingReference_Working()
  {
    return (EAttribute)workingReferenceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropagationCondition()
  {
    return propagationConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropagationCondition_OutPropagation()
  {
    return (EReference)propagationConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropagationCondition_Mask()
  {
    return (EAttribute)propagationConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropagationCondition_Working()
  {
    return (EAttribute)propagationConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropagationCondition_State()
  {
    return (EReference)propagationConditionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropagationCondition_Condition()
  {
    return (EReference)propagationConditionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropagationCondition_Feature()
  {
    return (EReference)propagationConditionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDetectionEvent()
  {
    return detectionEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDetectionEvent_Self()
  {
    return (EAttribute)detectionEventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDetectionEvent_EventPort()
  {
    return (EReference)detectionEventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDetectionEvent_Condition()
  {
    return (EReference)detectionEventEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompositeErrorBehavior()
  {
    return compositeErrorBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCompositeErrorBehavior_ImportedNamespace()
  {
    return (EAttribute)compositeErrorBehaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeErrorBehavior_State()
  {
    return (EReference)compositeErrorBehaviorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompositeState()
  {
    return compositeStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeState_State()
  {
    return (EReference)compositeStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompositeState_Condition()
  {
    return (EReference)compositeStateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateConditionExpression()
  {
    return stateConditionExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubcomponentStateReference()
  {
    return subcomponentStateReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubcomponentStateReference_Subcomponent()
  {
    return (EReference)subcomponentStateReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubcomponentStateReference_Errortype()
  {
    return (EReference)subcomponentStateReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyAssociation()
  {
    return propertyAssociationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropertyAssociation_Name()
  {
    return (EAttribute)propertyAssociationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyAssociation_Value()
  {
    return (EReference)propertyAssociationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyExpression()
  {
    return propertyExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteral()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteral_Name()
  {
    return (EAttribute)literalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProbabilityValue()
  {
    return probabilityValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProbabilityValue_Number()
  {
    return (EAttribute)probabilityValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProbabilityValue_Distribution()
  {
    return (EAttribute)probabilityValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Operands()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpression()
  {
    return orExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Operands()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPropagationDirection()
  {
    return propagationDirectionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelFactory getErrorModelFactory()
  {
    return (ErrorModelFactory)getEFactoryInstance();
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
    em2AnnexSubclauseEClass = createEClass(EM2_ANNEX_SUBCLAUSE);
    createEReference(em2AnnexSubclauseEClass, EM2_ANNEX_SUBCLAUSE__TYPES);
    createEReference(em2AnnexSubclauseEClass, EM2_ANNEX_SUBCLAUSE__EBSM);
    createEReference(em2AnnexSubclauseEClass, EM2_ANNEX_SUBCLAUSE__EP);
    createEReference(em2AnnexSubclauseEClass, EM2_ANNEX_SUBCLAUSE__CEB);
    createEReference(em2AnnexSubclauseEClass, EM2_ANNEX_SUBCLAUSE__COMPEB);

    errorTypeSetEClass = createEClass(ERROR_TYPE_SET);
    createEAttribute(errorTypeSetEClass, ERROR_TYPE_SET__NAME);
    createEReference(errorTypeSetEClass, ERROR_TYPE_SET__TYPES);
    createEReference(errorTypeSetEClass, ERROR_TYPE_SET__FEATURES);
    createEReference(errorTypeSetEClass, ERROR_TYPE_SET__EXTENDS);
    createEReference(errorTypeSetEClass, ERROR_TYPE_SET__REFINEMENTS);

    errorTypeEClass = createEClass(ERROR_TYPE);
    createEAttribute(errorTypeEClass, ERROR_TYPE__NAME);
    createEReference(errorTypeEClass, ERROR_TYPE__SUBTYPES);

    featureEClass = createEClass(FEATURE);
    createEAttribute(featureEClass, FEATURE__NAME);

    errorTypeRefinementEClass = createEClass(ERROR_TYPE_REFINEMENT);
    createEReference(errorTypeRefinementEClass, ERROR_TYPE_REFINEMENT__NAME);
    createEReference(errorTypeRefinementEClass, ERROR_TYPE_REFINEMENT__SUBTYPES);

    errorPropagationsEClass = createEClass(ERROR_PROPAGATIONS);
    createEAttribute(errorPropagationsEClass, ERROR_PROPAGATIONS__IMPORTED_NAMESPACE);
    createEReference(errorPropagationsEClass, ERROR_PROPAGATIONS__PROPAGATIONS);
    createEReference(errorPropagationsEClass, ERROR_PROPAGATIONS__FLOWS);

    errorPropagationEClass = createEClass(ERROR_PROPAGATION);
    createEReference(errorPropagationEClass, ERROR_PROPAGATION__TYPE);
    createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__MASK);
    createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__DIRECTION);
    createEAttribute(errorPropagationEClass, ERROR_PROPAGATION__BINDING);
    createEReference(errorPropagationEClass, ERROR_PROPAGATION__APPLIESTO);

    errorFlowEClass = createEClass(ERROR_FLOW);

    errorSourceEClass = createEClass(ERROR_SOURCE);
    createEReference(errorSourceEClass, ERROR_SOURCE__OUTGOING);

    errorSinkEClass = createEClass(ERROR_SINK);
    createEReference(errorSinkEClass, ERROR_SINK__INCOMING);

    errorPathEClass = createEClass(ERROR_PATH);
    createEReference(errorPathEClass, ERROR_PATH__INCOMING);
    createEReference(errorPathEClass, ERROR_PATH__OUTGOING);

    errorPropagationReferenceEClass = createEClass(ERROR_PROPAGATION_REFERENCE);
    createEAttribute(errorPropagationReferenceEClass, ERROR_PROPAGATION_REFERENCE__BINDING);
    createEReference(errorPropagationReferenceEClass, ERROR_PROPAGATION_REFERENCE__FEATURE);
    createEAttribute(errorPropagationReferenceEClass, ERROR_PROPAGATION_REFERENCE__SELF);
    createEReference(errorPropagationReferenceEClass, ERROR_PROPAGATION_REFERENCE__ERRORTYPE);

    errorBehaviorStateMachineEClass = createEClass(ERROR_BEHAVIOR_STATE_MACHINE);
    createEAttribute(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__NAME);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS);
    createEAttribute(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__EVENTS);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__STATES);
    createEReference(errorBehaviorStateMachineEClass, ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS);

    errorBehaviorEventEClass = createEClass(ERROR_BEHAVIOR_EVENT);
    createEAttribute(errorBehaviorEventEClass, ERROR_BEHAVIOR_EVENT__NAME);

    errorEventEClass = createEClass(ERROR_EVENT);

    repairEventEClass = createEClass(REPAIR_EVENT);

    errorBehaviorStateEClass = createEClass(ERROR_BEHAVIOR_STATE);
    createEAttribute(errorBehaviorStateEClass, ERROR_BEHAVIOR_STATE__NAME);
    createEAttribute(errorBehaviorStateEClass, ERROR_BEHAVIOR_STATE__INTIAL);
    createEReference(errorBehaviorStateEClass, ERROR_BEHAVIOR_STATE__PROPERTIES);

    errorBehaviorTransitionEClass = createEClass(ERROR_BEHAVIOR_TRANSITION);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__SOURCE);
    createEReference(errorBehaviorTransitionEClass, ERROR_BEHAVIOR_TRANSITION__DESTINATION);

    triggeredTransitionEClass = createEClass(TRIGGERED_TRANSITION);
    createEAttribute(triggeredTransitionEClass, TRIGGERED_TRANSITION__NAME);
    createEReference(triggeredTransitionEClass, TRIGGERED_TRANSITION__EVENTS);

    branchTransitionEClass = createEClass(BRANCH_TRANSITION);
    createEAttribute(branchTransitionEClass, BRANCH_TRANSITION__VALUE);

    componentErrorBehaviorEClass = createEClass(COMPONENT_ERROR_BEHAVIOR);
    createEAttribute(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE);
    createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION);
    createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION);
    createEReference(componentErrorBehaviorEClass, COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT);

    transitionConditionEClass = createEClass(TRANSITION_CONDITION);
    createEReference(transitionConditionEClass, TRANSITION_CONDITION__ERROR_TRANSITION);
    createEAttribute(transitionConditionEClass, TRANSITION_CONDITION__MASK);
    createEReference(transitionConditionEClass, TRANSITION_CONDITION__CONDITION);

    triggerConditionExpressionEClass = createEClass(TRIGGER_CONDITION_EXPRESSION);

    ormoreExpressionEClass = createEClass(ORMORE_EXPRESSION);
    createEAttribute(ormoreExpressionEClass, ORMORE_EXPRESSION__COUNT);
    createEReference(ormoreExpressionEClass, ORMORE_EXPRESSION__OPERANDS);

    orlessExpressionEClass = createEClass(ORLESS_EXPRESSION);
    createEAttribute(orlessExpressionEClass, ORLESS_EXPRESSION__COUNT);
    createEReference(orlessExpressionEClass, ORLESS_EXPRESSION__OPERANDS);

    othersExpressionEClass = createEClass(OTHERS_EXPRESSION);

    errorEventReferenceEClass = createEClass(ERROR_EVENT_REFERENCE);
    createEReference(errorEventReferenceEClass, ERROR_EVENT_REFERENCE__REFERENCE);

    workingReferenceEClass = createEClass(WORKING_REFERENCE);
    createEAttribute(workingReferenceEClass, WORKING_REFERENCE__BINDING);
    createEReference(workingReferenceEClass, WORKING_REFERENCE__FEATURE);
    createEAttribute(workingReferenceEClass, WORKING_REFERENCE__SELF);
    createEAttribute(workingReferenceEClass, WORKING_REFERENCE__WORKING);

    propagationConditionEClass = createEClass(PROPAGATION_CONDITION);
    createEReference(propagationConditionEClass, PROPAGATION_CONDITION__OUT_PROPAGATION);
    createEAttribute(propagationConditionEClass, PROPAGATION_CONDITION__MASK);
    createEAttribute(propagationConditionEClass, PROPAGATION_CONDITION__WORKING);
    createEReference(propagationConditionEClass, PROPAGATION_CONDITION__STATE);
    createEReference(propagationConditionEClass, PROPAGATION_CONDITION__CONDITION);
    createEReference(propagationConditionEClass, PROPAGATION_CONDITION__FEATURE);

    detectionEventEClass = createEClass(DETECTION_EVENT);
    createEAttribute(detectionEventEClass, DETECTION_EVENT__SELF);
    createEReference(detectionEventEClass, DETECTION_EVENT__EVENT_PORT);
    createEReference(detectionEventEClass, DETECTION_EVENT__CONDITION);

    compositeErrorBehaviorEClass = createEClass(COMPOSITE_ERROR_BEHAVIOR);
    createEAttribute(compositeErrorBehaviorEClass, COMPOSITE_ERROR_BEHAVIOR__IMPORTED_NAMESPACE);
    createEReference(compositeErrorBehaviorEClass, COMPOSITE_ERROR_BEHAVIOR__STATE);

    compositeStateEClass = createEClass(COMPOSITE_STATE);
    createEReference(compositeStateEClass, COMPOSITE_STATE__STATE);
    createEReference(compositeStateEClass, COMPOSITE_STATE__CONDITION);

    stateConditionExpressionEClass = createEClass(STATE_CONDITION_EXPRESSION);

    subcomponentStateReferenceEClass = createEClass(SUBCOMPONENT_STATE_REFERENCE);
    createEReference(subcomponentStateReferenceEClass, SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT);
    createEReference(subcomponentStateReferenceEClass, SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE);

    propertyAssociationEClass = createEClass(PROPERTY_ASSOCIATION);
    createEAttribute(propertyAssociationEClass, PROPERTY_ASSOCIATION__NAME);
    createEReference(propertyAssociationEClass, PROPERTY_ASSOCIATION__VALUE);

    propertyExpressionEClass = createEClass(PROPERTY_EXPRESSION);

    literalEClass = createEClass(LITERAL);
    createEAttribute(literalEClass, LITERAL__NAME);

    probabilityValueEClass = createEClass(PROBABILITY_VALUE);
    createEAttribute(probabilityValueEClass, PROBABILITY_VALUE__NUMBER);
    createEAttribute(probabilityValueEClass, PROBABILITY_VALUE__DISTRIBUTION);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__OPERANDS);

    orExpressionEClass = createEClass(OR_EXPRESSION);
    createEReference(orExpressionEClass, OR_EXPRESSION__OPERANDS);

    // Create enums
    propagationDirectionEEnum = createEEnum(PROPAGATION_DIRECTION);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    errorSourceEClass.getESuperTypes().add(this.getErrorFlow());
    errorSinkEClass.getESuperTypes().add(this.getErrorFlow());
    errorPathEClass.getESuperTypes().add(this.getErrorFlow());
    errorPropagationReferenceEClass.getESuperTypes().add(this.getTriggerConditionExpression());
    errorEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
    repairEventEClass.getESuperTypes().add(this.getErrorBehaviorEvent());
    triggeredTransitionEClass.getESuperTypes().add(this.getErrorBehaviorTransition());
    branchTransitionEClass.getESuperTypes().add(this.getErrorBehaviorTransition());
    triggerConditionExpressionEClass.getESuperTypes().add(this.getStateConditionExpression());
    ormoreExpressionEClass.getESuperTypes().add(this.getTriggerConditionExpression());
    ormoreExpressionEClass.getESuperTypes().add(this.getStateConditionExpression());
    orlessExpressionEClass.getESuperTypes().add(this.getTriggerConditionExpression());
    orlessExpressionEClass.getESuperTypes().add(this.getStateConditionExpression());
    othersExpressionEClass.getESuperTypes().add(this.getTriggerConditionExpression());
    othersExpressionEClass.getESuperTypes().add(this.getStateConditionExpression());
    errorEventReferenceEClass.getESuperTypes().add(this.getTriggerConditionExpression());
    workingReferenceEClass.getESuperTypes().add(this.getTriggerConditionExpression());
    subcomponentStateReferenceEClass.getESuperTypes().add(this.getStateConditionExpression());
    literalEClass.getESuperTypes().add(this.getPropertyExpression());
    probabilityValueEClass.getESuperTypes().add(this.getPropertyExpression());
    andExpressionEClass.getESuperTypes().add(this.getTriggerConditionExpression());
    orExpressionEClass.getESuperTypes().add(this.getTriggerConditionExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(em2AnnexSubclauseEClass, EM2AnnexSubclause.class, "EM2AnnexSubclause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEM2AnnexSubclause_Types(), this.getErrorTypeSet(), null, "types", null, 0, -1, EM2AnnexSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEM2AnnexSubclause_Ebsm(), this.getErrorBehaviorStateMachine(), null, "ebsm", null, 0, -1, EM2AnnexSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEM2AnnexSubclause_Ep(), this.getErrorPropagations(), null, "ep", null, 0, -1, EM2AnnexSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEM2AnnexSubclause_Ceb(), this.getComponentErrorBehavior(), null, "ceb", null, 0, -1, EM2AnnexSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEM2AnnexSubclause_Compeb(), this.getCompositeErrorBehavior(), null, "compeb", null, 0, -1, EM2AnnexSubclause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorTypeSetEClass, ErrorTypeSet.class, "ErrorTypeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorTypeSet_Name(), ecorePackage.getEString(), "name", null, 0, 1, ErrorTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorTypeSet_Types(), this.getErrorType(), null, "types", null, 0, -1, ErrorTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorTypeSet_Features(), this.getFeature(), null, "features", null, 0, -1, ErrorTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorTypeSet_Extends(), this.getErrorTypeSet(), null, "extends", null, 0, 1, ErrorTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorTypeSet_Refinements(), this.getErrorTypeRefinement(), null, "refinements", null, 0, -1, ErrorTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorTypeEClass, ErrorType.class, "ErrorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorType_Name(), ecorePackage.getEString(), "name", null, 0, 1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorType_Subtypes(), this.getErrorType(), null, "subtypes", null, 0, -1, ErrorType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorTypeRefinementEClass, ErrorTypeRefinement.class, "ErrorTypeRefinement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorTypeRefinement_Name(), this.getErrorType(), null, "name", null, 0, 1, ErrorTypeRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorTypeRefinement_Subtypes(), this.getErrorType(), null, "subtypes", null, 0, -1, ErrorTypeRefinement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorPropagationsEClass, ErrorPropagations.class, "ErrorPropagations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorPropagations_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPropagations_Propagations(), this.getErrorPropagation(), null, "propagations", null, 0, -1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPropagations_Flows(), this.getErrorFlow(), null, "flows", null, 0, -1, ErrorPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorPropagationEClass, ErrorPropagation.class, "ErrorPropagation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorPropagation_Type(), this.getErrorType(), null, "type", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPropagation_Mask(), ecorePackage.getEBoolean(), "mask", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPropagation_Direction(), this.getPropagationDirection(), "direction", null, 0, 1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPropagation_Binding(), ecorePackage.getEString(), "binding", null, 0, -1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPropagation_Appliesto(), this.getFeature(), null, "appliesto", null, 0, -1, ErrorPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorFlowEClass, ErrorFlow.class, "ErrorFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(errorSourceEClass, ErrorSource.class, "ErrorSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorSource_Outgoing(), this.getErrorPropagationReference(), null, "outgoing", null, 0, 1, ErrorSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorSinkEClass, ErrorSink.class, "ErrorSink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorSink_Incoming(), this.getErrorPropagationReference(), null, "incoming", null, 0, 1, ErrorSink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorPathEClass, ErrorPath.class, "ErrorPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorPath_Incoming(), this.getErrorPropagationReference(), null, "incoming", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPath_Outgoing(), this.getErrorPropagationReference(), null, "outgoing", null, 0, 1, ErrorPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorPropagationReferenceEClass, ErrorPropagationReference.class, "ErrorPropagationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorPropagationReference_Binding(), ecorePackage.getEString(), "binding", null, 0, 1, ErrorPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPropagationReference_Feature(), this.getFeature(), null, "feature", null, 0, 1, ErrorPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorPropagationReference_Self(), ecorePackage.getEBoolean(), "self", null, 0, 1, ErrorPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorPropagationReference_Errortype(), this.getErrorType(), null, "errortype", null, 0, 1, ErrorPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorBehaviorStateMachineEClass, ErrorBehaviorStateMachine.class, "ErrorBehaviorStateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorBehaviorStateMachine_Name(), ecorePackage.getEString(), "name", null, 0, 1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_Extends(), this.getErrorBehaviorStateMachine(), null, "extends", null, 0, 1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorBehaviorStateMachine_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_Events(), this.getErrorBehaviorEvent(), null, "events", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_States(), this.getErrorBehaviorState(), null, "states", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorStateMachine_Transitions(), this.getErrorBehaviorTransition(), null, "transitions", null, 0, -1, ErrorBehaviorStateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorBehaviorEventEClass, ErrorBehaviorEvent.class, "ErrorBehaviorEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorBehaviorEvent_Name(), ecorePackage.getEString(), "name", null, 0, 1, ErrorBehaviorEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorEventEClass, ErrorEvent.class, "ErrorEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(repairEventEClass, RepairEvent.class, "RepairEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(errorBehaviorStateEClass, ErrorBehaviorState.class, "ErrorBehaviorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorBehaviorState_Name(), ecorePackage.getEString(), "name", null, 0, 1, ErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getErrorBehaviorState_Intial(), ecorePackage.getEBoolean(), "intial", null, 0, 1, ErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorState_Properties(), this.getPropertyAssociation(), null, "properties", null, 0, -1, ErrorBehaviorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorBehaviorTransitionEClass, ErrorBehaviorTransition.class, "ErrorBehaviorTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorBehaviorTransition_Source(), this.getErrorBehaviorState(), null, "source", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getErrorBehaviorTransition_Destination(), this.getErrorBehaviorState(), null, "destination", null, 0, 1, ErrorBehaviorTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(triggeredTransitionEClass, TriggeredTransition.class, "TriggeredTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTriggeredTransition_Name(), ecorePackage.getEString(), "name", null, 0, 1, TriggeredTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTriggeredTransition_Events(), this.getErrorBehaviorEvent(), null, "events", null, 0, -1, TriggeredTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(branchTransitionEClass, BranchTransition.class, "BranchTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBranchTransition_Value(), ecorePackage.getEString(), "value", null, 0, 1, BranchTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentErrorBehaviorEClass, ComponentErrorBehavior.class, "ComponentErrorBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComponentErrorBehavior_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentErrorBehavior_TransitionCondition(), this.getTransitionCondition(), null, "transitionCondition", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentErrorBehavior_PropagationCondition(), this.getPropagationCondition(), null, "propagationCondition", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentErrorBehavior_DetectionEvent(), this.getDetectionEvent(), null, "detectionEvent", null, 0, -1, ComponentErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionConditionEClass, TransitionCondition.class, "TransitionCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionCondition_ErrorTransition(), this.getTriggeredTransition(), null, "errorTransition", null, 0, 1, TransitionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransitionCondition_Mask(), ecorePackage.getEBoolean(), "mask", null, 0, 1, TransitionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransitionCondition_Condition(), this.getTriggerConditionExpression(), null, "condition", null, 0, 1, TransitionCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(triggerConditionExpressionEClass, TriggerConditionExpression.class, "TriggerConditionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ormoreExpressionEClass, OrmoreExpression.class, "OrmoreExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOrmoreExpression_Count(), ecorePackage.getEInt(), "count", null, 0, 1, OrmoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrmoreExpression_Operands(), this.getStateConditionExpression(), null, "operands", null, 0, -1, OrmoreExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orlessExpressionEClass, OrlessExpression.class, "OrlessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOrlessExpression_Count(), ecorePackage.getEInt(), "count", null, 0, 1, OrlessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrlessExpression_Operands(), this.getStateConditionExpression(), null, "operands", null, 0, -1, OrlessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(othersExpressionEClass, OthersExpression.class, "OthersExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(errorEventReferenceEClass, ErrorEventReference.class, "ErrorEventReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getErrorEventReference_Reference(), this.getErrorBehaviorEvent(), null, "reference", null, 0, 1, ErrorEventReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(workingReferenceEClass, WorkingReference.class, "WorkingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWorkingReference_Binding(), ecorePackage.getEString(), "binding", null, 0, 1, WorkingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWorkingReference_Feature(), this.getFeature(), null, "feature", null, 0, 1, WorkingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWorkingReference_Self(), ecorePackage.getEBoolean(), "self", null, 0, 1, WorkingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWorkingReference_Working(), ecorePackage.getEBoolean(), "working", null, 0, 1, WorkingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propagationConditionEClass, PropagationCondition.class, "PropagationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropagationCondition_OutPropagation(), this.getErrorPropagation(), null, "outPropagation", null, 0, 1, PropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPropagationCondition_Mask(), ecorePackage.getEBoolean(), "mask", null, 0, 1, PropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPropagationCondition_Working(), ecorePackage.getEBoolean(), "working", null, 0, 1, PropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropagationCondition_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, PropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropagationCondition_Condition(), this.getTriggerConditionExpression(), null, "condition", null, 0, 1, PropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropagationCondition_Feature(), this.getFeature(), null, "feature", null, 0, -1, PropagationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(detectionEventEClass, DetectionEvent.class, "DetectionEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDetectionEvent_Self(), ecorePackage.getEBoolean(), "self", null, 0, 1, DetectionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDetectionEvent_EventPort(), this.getFeature(), null, "eventPort", null, 0, 1, DetectionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDetectionEvent_Condition(), this.getTriggerConditionExpression(), null, "condition", null, 0, 1, DetectionEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compositeErrorBehaviorEClass, CompositeErrorBehavior.class, "CompositeErrorBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCompositeErrorBehavior_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, CompositeErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCompositeErrorBehavior_State(), this.getCompositeState(), null, "state", null, 0, -1, CompositeErrorBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(compositeStateEClass, CompositeState.class, "CompositeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCompositeState_State(), this.getErrorBehaviorState(), null, "state", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCompositeState_Condition(), this.getStateConditionExpression(), null, "condition", null, 0, 1, CompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateConditionExpressionEClass, StateConditionExpression.class, "StateConditionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(subcomponentStateReferenceEClass, SubcomponentStateReference.class, "SubcomponentStateReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubcomponentStateReference_Subcomponent(), this.getFeature(), null, "subcomponent", null, 0, 1, SubcomponentStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubcomponentStateReference_Errortype(), this.getErrorBehaviorState(), null, "errortype", null, 0, 1, SubcomponentStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyAssociationEClass, PropertyAssociation.class, "PropertyAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyAssociation_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropertyAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyAssociation_Value(), this.getPropertyExpression(), null, "value", null, 0, 1, PropertyAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyExpressionEClass, PropertyExpression.class, "PropertyExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteral_Name(), ecorePackage.getEString(), "name", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(probabilityValueEClass, ProbabilityValue.class, "ProbabilityValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProbabilityValue_Number(), ecorePackage.getEString(), "number", null, 0, 1, ProbabilityValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProbabilityValue_Distribution(), ecorePackage.getEString(), "distribution", null, 0, 1, ProbabilityValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Operands(), this.getTriggerConditionExpression(), null, "operands", null, 0, -1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpression_Operands(), this.getTriggerConditionExpression(), null, "operands", null, 0, -1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(propagationDirectionEEnum, PropagationDirection.class, "PropagationDirection");
    addEEnumLiteral(propagationDirectionEEnum, PropagationDirection.IN);
    addEEnumLiteral(propagationDirectionEEnum, PropagationDirection.OUT);

    // Create resource
    createResource(eNS_URI);
  }

} //ErrorModelPackageImpl
