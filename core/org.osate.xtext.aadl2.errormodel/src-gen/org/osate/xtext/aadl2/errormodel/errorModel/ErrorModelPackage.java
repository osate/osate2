/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory
 * @model kind="package"
 * @generated
 */
public interface ErrorModelPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "errorModel";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/aadl2/errormodel/ErrorModel";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "errorModel";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ErrorModelPackage eINSTANCE = org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl <em>EM2 Annex Subclause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getEM2AnnexSubclause()
   * @generated
   */
  int EM2_ANNEX_SUBCLAUSE = 0;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EM2_ANNEX_SUBCLAUSE__TYPES = 0;

  /**
   * The feature id for the '<em><b>Ebsm</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EM2_ANNEX_SUBCLAUSE__EBSM = 1;

  /**
   * The feature id for the '<em><b>Ep</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EM2_ANNEX_SUBCLAUSE__EP = 2;

  /**
   * The feature id for the '<em><b>Ceb</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EM2_ANNEX_SUBCLAUSE__CEB = 3;

  /**
   * The feature id for the '<em><b>Compeb</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EM2_ANNEX_SUBCLAUSE__COMPEB = 4;

  /**
   * The number of structural features of the '<em>EM2 Annex Subclause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EM2_ANNEX_SUBCLAUSE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl <em>Error Type Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorTypeSet()
   * @generated
   */
  int ERROR_TYPE_SET = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_SET__NAME = 0;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_SET__TYPES = 1;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_SET__FEATURES = 2;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_SET__EXTENDS = 3;

  /**
   * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_SET__REFINEMENTS = 4;

  /**
   * The number of structural features of the '<em>Error Type Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_SET_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeImpl <em>Error Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorType()
   * @generated
   */
  int ERROR_TYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE__NAME = 0;

  /**
   * The feature id for the '<em><b>Subtypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE__SUBTYPES = 1;

  /**
   * The number of structural features of the '<em>Error Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.FeatureImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = 0;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeRefinementImpl <em>Error Type Refinement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeRefinementImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorTypeRefinement()
   * @generated
   */
  int ERROR_TYPE_REFINEMENT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_REFINEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Subtypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_REFINEMENT__SUBTYPES = 1;

  /**
   * The number of structural features of the '<em>Error Type Refinement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_TYPE_REFINEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationsImpl <em>Error Propagations</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationsImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPropagations()
   * @generated
   */
  int ERROR_PROPAGATIONS = 5;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATIONS__IMPORTED_NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>Propagations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATIONS__PROPAGATIONS = 1;

  /**
   * The feature id for the '<em><b>Flows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATIONS__FLOWS = 2;

  /**
   * The number of structural features of the '<em>Error Propagations</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATIONS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl <em>Error Propagation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPropagation()
   * @generated
   */
  int ERROR_PROPAGATION = 6;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Mask</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION__MASK = 1;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION__DIRECTION = 2;

  /**
   * The feature id for the '<em><b>Binding</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION__BINDING = 3;

  /**
   * The feature id for the '<em><b>Appliesto</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION__APPLIESTO = 4;

  /**
   * The number of structural features of the '<em>Error Propagation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorFlowImpl <em>Error Flow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorFlowImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorFlow()
   * @generated
   */
  int ERROR_FLOW = 7;

  /**
   * The number of structural features of the '<em>Error Flow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_FLOW_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl <em>Error Source</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorSource()
   * @generated
   */
  int ERROR_SOURCE = 8;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SOURCE__OUTGOING = ERROR_FLOW_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Error Source</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SOURCE_FEATURE_COUNT = ERROR_FLOW_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSinkImpl <em>Error Sink</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSinkImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorSink()
   * @generated
   */
  int ERROR_SINK = 9;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SINK__INCOMING = ERROR_FLOW_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Error Sink</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_SINK_FEATURE_COUNT = ERROR_FLOW_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl <em>Error Path</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPath()
   * @generated
   */
  int ERROR_PATH = 10;

  /**
   * The feature id for the '<em><b>Incoming</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PATH__INCOMING = ERROR_FLOW_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Outgoing</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PATH__OUTGOING = ERROR_FLOW_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Error Path</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PATH_FEATURE_COUNT = ERROR_FLOW_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.StateConditionExpressionImpl <em>State Condition Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.StateConditionExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getStateConditionExpression()
   * @generated
   */
  int STATE_CONDITION_EXPRESSION = 32;

  /**
   * The number of structural features of the '<em>State Condition Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_CONDITION_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggerConditionExpressionImpl <em>Trigger Condition Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggerConditionExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getTriggerConditionExpression()
   * @generated
   */
  int TRIGGER_CONDITION_EXPRESSION = 22;

  /**
   * The number of structural features of the '<em>Trigger Condition Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT = STATE_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl <em>Error Propagation Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPropagationReference()
   * @generated
   */
  int ERROR_PROPAGATION_REFERENCE = 11;

  /**
   * The feature id for the '<em><b>Binding</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION_REFERENCE__BINDING = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION_REFERENCE__FEATURE = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Self</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION_REFERENCE__SELF = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Errortype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION_REFERENCE__ERRORTYPE = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Error Propagation Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_PROPAGATION_REFERENCE_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl <em>Error Behavior State Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorStateMachine()
   * @generated
   */
  int ERROR_BEHAVIOR_STATE_MACHINE = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_MACHINE__NAME = 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS = 1;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE = 2;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_MACHINE__EVENTS = 3;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_MACHINE__STATES = 4;

  /**
   * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS = 5;

  /**
   * The number of structural features of the '<em>Error Behavior State Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_MACHINE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorEventImpl <em>Error Behavior Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorEventImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorEvent()
   * @generated
   */
  int ERROR_BEHAVIOR_EVENT = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_EVENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Error Behavior Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_EVENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl <em>Error Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorEvent()
   * @generated
   */
  int ERROR_EVENT = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_EVENT__NAME = ERROR_BEHAVIOR_EVENT__NAME;

  /**
   * The number of structural features of the '<em>Error Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_EVENT_FEATURE_COUNT = ERROR_BEHAVIOR_EVENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.RepairEventImpl <em>Repair Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.RepairEventImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getRepairEvent()
   * @generated
   */
  int REPAIR_EVENT = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPAIR_EVENT__NAME = ERROR_BEHAVIOR_EVENT__NAME;

  /**
   * The number of structural features of the '<em>Repair Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPAIR_EVENT_FEATURE_COUNT = ERROR_BEHAVIOR_EVENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateImpl <em>Error Behavior State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorState()
   * @generated
   */
  int ERROR_BEHAVIOR_STATE = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE__NAME = 0;

  /**
   * The feature id for the '<em><b>Intial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE__INTIAL = 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE__PROPERTIES = 2;

  /**
   * The number of structural features of the '<em>Error Behavior State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_STATE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl <em>Error Behavior Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorTransition()
   * @generated
   */
  int ERROR_BEHAVIOR_TRANSITION = 17;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_TRANSITION__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_TRANSITION__DESTINATION = 1;

  /**
   * The number of structural features of the '<em>Error Behavior Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_BEHAVIOR_TRANSITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggeredTransitionImpl <em>Triggered Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggeredTransitionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getTriggeredTransition()
   * @generated
   */
  int TRIGGERED_TRANSITION = 18;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__SOURCE = ERROR_BEHAVIOR_TRANSITION__SOURCE;

  /**
   * The feature id for the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__DESTINATION = ERROR_BEHAVIOR_TRANSITION__DESTINATION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__NAME = ERROR_BEHAVIOR_TRANSITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION__EVENTS = ERROR_BEHAVIOR_TRANSITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Triggered Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGERED_TRANSITION_FEATURE_COUNT = ERROR_BEHAVIOR_TRANSITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.BranchTransitionImpl <em>Branch Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.BranchTransitionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getBranchTransition()
   * @generated
   */
  int BRANCH_TRANSITION = 19;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH_TRANSITION__SOURCE = ERROR_BEHAVIOR_TRANSITION__SOURCE;

  /**
   * The feature id for the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH_TRANSITION__DESTINATION = ERROR_BEHAVIOR_TRANSITION__DESTINATION;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH_TRANSITION__VALUE = ERROR_BEHAVIOR_TRANSITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Branch Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH_TRANSITION_FEATURE_COUNT = ERROR_BEHAVIOR_TRANSITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl <em>Component Error Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getComponentErrorBehavior()
   * @generated
   */
  int COMPONENT_ERROR_BEHAVIOR = 20;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>Transition Condition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION = 1;

  /**
   * The feature id for the '<em><b>Propagation Condition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION = 2;

  /**
   * The feature id for the '<em><b>Detection Event</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT = 3;

  /**
   * The number of structural features of the '<em>Component Error Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ERROR_BEHAVIOR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionConditionImpl <em>Transition Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionConditionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getTransitionCondition()
   * @generated
   */
  int TRANSITION_CONDITION = 21;

  /**
   * The feature id for the '<em><b>Error Transition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONDITION__ERROR_TRANSITION = 0;

  /**
   * The feature id for the '<em><b>Mask</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONDITION__MASK = 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONDITION__CONDITION = 2;

  /**
   * The number of structural features of the '<em>Transition Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_CONDITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OrmoreExpressionImpl <em>Ormore Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OrmoreExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOrmoreExpression()
   * @generated
   */
  int ORMORE_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORMORE_EXPRESSION__COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORMORE_EXPRESSION__OPERANDS = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Ormore Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORMORE_EXPRESSION_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OrlessExpressionImpl <em>Orless Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OrlessExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOrlessExpression()
   * @generated
   */
  int ORLESS_EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORLESS_EXPRESSION__COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORLESS_EXPRESSION__OPERANDS = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Orless Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORLESS_EXPRESSION_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OthersExpressionImpl <em>Others Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OthersExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOthersExpression()
   * @generated
   */
  int OTHERS_EXPRESSION = 25;

  /**
   * The number of structural features of the '<em>Others Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHERS_EXPRESSION_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventReferenceImpl <em>Error Event Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventReferenceImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorEventReference()
   * @generated
   */
  int ERROR_EVENT_REFERENCE = 26;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_EVENT_REFERENCE__REFERENCE = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Error Event Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_EVENT_REFERENCE_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl <em>Working Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getWorkingReference()
   * @generated
   */
  int WORKING_REFERENCE = 27;

  /**
   * The feature id for the '<em><b>Binding</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKING_REFERENCE__BINDING = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKING_REFERENCE__FEATURE = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Self</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKING_REFERENCE__SELF = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Working</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKING_REFERENCE__WORKING = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Working Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORKING_REFERENCE_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl <em>Propagation Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropagationCondition()
   * @generated
   */
  int PROPAGATION_CONDITION = 28;

  /**
   * The feature id for the '<em><b>Out Propagation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPAGATION_CONDITION__OUT_PROPAGATION = 0;

  /**
   * The feature id for the '<em><b>Mask</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPAGATION_CONDITION__MASK = 1;

  /**
   * The feature id for the '<em><b>Working</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPAGATION_CONDITION__WORKING = 2;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPAGATION_CONDITION__STATE = 3;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPAGATION_CONDITION__CONDITION = 4;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPAGATION_CONDITION__FEATURE = 5;

  /**
   * The number of structural features of the '<em>Propagation Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPAGATION_CONDITION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.DetectionEventImpl <em>Detection Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.DetectionEventImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getDetectionEvent()
   * @generated
   */
  int DETECTION_EVENT = 29;

  /**
   * The feature id for the '<em><b>Self</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETECTION_EVENT__SELF = 0;

  /**
   * The feature id for the '<em><b>Event Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETECTION_EVENT__EVENT_PORT = 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETECTION_EVENT__CONDITION = 2;

  /**
   * The number of structural features of the '<em>Detection Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETECTION_EVENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl <em>Composite Error Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getCompositeErrorBehavior()
   * @generated
   */
  int COMPOSITE_ERROR_BEHAVIOR = 30;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_ERROR_BEHAVIOR__IMPORTED_NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_ERROR_BEHAVIOR__STATE = 1;

  /**
   * The number of structural features of the '<em>Composite Error Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_ERROR_BEHAVIOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeStateImpl <em>Composite State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeStateImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getCompositeState()
   * @generated
   */
  int COMPOSITE_STATE = 31;

  /**
   * The feature id for the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_STATE__STATE = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_STATE__CONDITION = 1;

  /**
   * The number of structural features of the '<em>Composite State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_STATE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentStateReferenceImpl <em>Subcomponent State Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentStateReferenceImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getSubcomponentStateReference()
   * @generated
   */
  int SUBCOMPONENT_STATE_REFERENCE = 33;

  /**
   * The feature id for the '<em><b>Subcomponent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT = STATE_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Errortype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE = STATE_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Subcomponent State Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBCOMPONENT_STATE_REFERENCE_FEATURE_COUNT = STATE_CONDITION_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyAssociationImpl <em>Property Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyAssociationImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropertyAssociation()
   * @generated
   */
  int PROPERTY_ASSOCIATION = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ASSOCIATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ASSOCIATION__VALUE = 1;

  /**
   * The number of structural features of the '<em>Property Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ASSOCIATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyExpressionImpl <em>Property Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropertyExpression()
   * @generated
   */
  int PROPERTY_EXPRESSION = 35;

  /**
   * The number of structural features of the '<em>Property Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.LiteralImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 36;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__NAME = PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ProbabilityValueImpl <em>Probability Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ProbabilityValueImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getProbabilityValue()
   * @generated
   */
  int PROBABILITY_VALUE = 37;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_VALUE__NUMBER = PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Distribution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_VALUE__DISTRIBUTION = PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Probability Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROBABILITY_VALUE_FEATURE_COUNT = PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.AndExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 38;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__OPERANDS = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OrExpressionImpl
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 39;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__OPERANDS = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = TRIGGER_CONDITION_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection <em>Propagation Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection
   * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropagationDirection()
   * @generated
   */
  int PROPAGATION_DIRECTION = 40;


  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause <em>EM2 Annex Subclause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EM2 Annex Subclause</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause
   * @generated
   */
  EClass getEM2AnnexSubclause();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getTypes()
   * @see #getEM2AnnexSubclause()
   * @generated
   */
  EReference getEM2AnnexSubclause_Types();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getEbsm <em>Ebsm</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ebsm</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getEbsm()
   * @see #getEM2AnnexSubclause()
   * @generated
   */
  EReference getEM2AnnexSubclause_Ebsm();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getEp <em>Ep</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ep</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getEp()
   * @see #getEM2AnnexSubclause()
   * @generated
   */
  EReference getEM2AnnexSubclause_Ep();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getCeb <em>Ceb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ceb</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getCeb()
   * @see #getEM2AnnexSubclause()
   * @generated
   */
  EReference getEM2AnnexSubclause_Ceb();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getCompeb <em>Compeb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Compeb</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EM2AnnexSubclause#getCompeb()
   * @see #getEM2AnnexSubclause()
   * @generated
   */
  EReference getEM2AnnexSubclause_Compeb();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet <em>Error Type Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Type Set</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet
   * @generated
   */
  EClass getErrorTypeSet();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getName()
   * @see #getErrorTypeSet()
   * @generated
   */
  EAttribute getErrorTypeSet_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getTypes()
   * @see #getErrorTypeSet()
   * @generated
   */
  EReference getErrorTypeSet_Types();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getFeatures()
   * @see #getErrorTypeSet()
   * @generated
   */
  EReference getErrorTypeSet_Features();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getExtends()
   * @see #getErrorTypeSet()
   * @generated
   */
  EReference getErrorTypeSet_Extends();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getRefinements <em>Refinements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Refinements</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeSet#getRefinements()
   * @see #getErrorTypeSet()
   * @generated
   */
  EReference getErrorTypeSet_Refinements();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType <em>Error Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Type</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorType
   * @generated
   */
  EClass getErrorType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getName()
   * @see #getErrorType()
   * @generated
   */
  EAttribute getErrorType_Name();

  /**
   * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSubtypes <em>Subtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subtypes</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorType#getSubtypes()
   * @see #getErrorType()
   * @generated
   */
  EReference getErrorType_Subtypes();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.Feature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.Feature#getName()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Name();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement <em>Error Type Refinement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Type Refinement</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement
   * @generated
   */
  EClass getErrorTypeRefinement();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement#getName()
   * @see #getErrorTypeRefinement()
   * @generated
   */
  EReference getErrorTypeRefinement_Name();

  /**
   * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement#getSubtypes <em>Subtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subtypes</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypeRefinement#getSubtypes()
   * @see #getErrorTypeRefinement()
   * @generated
   */
  EReference getErrorTypeRefinement_Subtypes();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations <em>Error Propagations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Propagations</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations
   * @generated
   */
  EClass getErrorPropagations();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getImportedNamespace()
   * @see #getErrorPropagations()
   * @generated
   */
  EAttribute getErrorPropagations_ImportedNamespace();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getPropagations <em>Propagations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Propagations</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getPropagations()
   * @see #getErrorPropagations()
   * @generated
   */
  EReference getErrorPropagations_Propagations();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getFlows <em>Flows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Flows</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getFlows()
   * @see #getErrorPropagations()
   * @generated
   */
  EReference getErrorPropagations_Flows();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation <em>Error Propagation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Propagation</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
   * @generated
   */
  EClass getErrorPropagation();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getType()
   * @see #getErrorPropagation()
   * @generated
   */
  EReference getErrorPropagation_Type();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#isMask <em>Mask</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mask</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#isMask()
   * @see #getErrorPropagation()
   * @generated
   */
  EAttribute getErrorPropagation_Mask();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getDirection()
   * @see #getErrorPropagation()
   * @generated
   */
  EAttribute getErrorPropagation_Direction();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getBinding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Binding</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getBinding()
   * @see #getErrorPropagation()
   * @generated
   */
  EAttribute getErrorPropagation_Binding();

  /**
   * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getAppliesto <em>Appliesto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Appliesto</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation#getAppliesto()
   * @see #getErrorPropagation()
   * @generated
   */
  EReference getErrorPropagation_Appliesto();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow <em>Error Flow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Flow</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow
   * @generated
   */
  EClass getErrorFlow();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource <em>Error Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Source</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource
   * @generated
   */
  EClass getErrorSource();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Outgoing</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource#getOutgoing()
   * @see #getErrorSource()
   * @generated
   */
  EReference getErrorSource_Outgoing();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink <em>Error Sink</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Sink</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink
   * @generated
   */
  EClass getErrorSink();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Incoming</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink#getIncoming()
   * @see #getErrorSink()
   * @generated
   */
  EReference getErrorSink_Incoming();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath <em>Error Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Path</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath
   * @generated
   */
  EClass getErrorPath();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getIncoming <em>Incoming</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Incoming</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getIncoming()
   * @see #getErrorPath()
   * @generated
   */
  EReference getErrorPath_Incoming();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getOutgoing <em>Outgoing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Outgoing</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath#getOutgoing()
   * @see #getErrorPath()
   * @generated
   */
  EReference getErrorPath_Outgoing();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference <em>Error Propagation Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Propagation Reference</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference
   * @generated
   */
  EClass getErrorPropagationReference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#getBinding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Binding</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#getBinding()
   * @see #getErrorPropagationReference()
   * @generated
   */
  EAttribute getErrorPropagationReference_Binding();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#getFeature()
   * @see #getErrorPropagationReference()
   * @generated
   */
  EReference getErrorPropagationReference_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#isSelf <em>Self</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Self</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#isSelf()
   * @see #getErrorPropagationReference()
   * @generated
   */
  EAttribute getErrorPropagationReference_Self();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#getErrortype <em>Errortype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Errortype</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagationReference#getErrortype()
   * @see #getErrorPropagationReference()
   * @generated
   */
  EReference getErrorPropagationReference_Errortype();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine <em>Error Behavior State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Behavior State Machine</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine
   * @generated
   */
  EClass getErrorBehaviorStateMachine();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getName()
   * @see #getErrorBehaviorStateMachine()
   * @generated
   */
  EAttribute getErrorBehaviorStateMachine_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getExtends()
   * @see #getErrorBehaviorStateMachine()
   * @generated
   */
  EReference getErrorBehaviorStateMachine_Extends();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getImportedNamespace()
   * @see #getErrorBehaviorStateMachine()
   * @generated
   */
  EAttribute getErrorBehaviorStateMachine_ImportedNamespace();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getEvents()
   * @see #getErrorBehaviorStateMachine()
   * @generated
   */
  EReference getErrorBehaviorStateMachine_Events();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getStates()
   * @see #getErrorBehaviorStateMachine()
   * @generated
   */
  EReference getErrorBehaviorStateMachine_States();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getTransitions <em>Transitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transitions</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getTransitions()
   * @see #getErrorBehaviorStateMachine()
   * @generated
   */
  EReference getErrorBehaviorStateMachine_Transitions();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent <em>Error Behavior Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Behavior Event</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent
   * @generated
   */
  EClass getErrorBehaviorEvent();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent#getName()
   * @see #getErrorBehaviorEvent()
   * @generated
   */
  EAttribute getErrorBehaviorEvent_Name();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent <em>Error Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Event</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
   * @generated
   */
  EClass getErrorEvent();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent <em>Repair Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Repair Event</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent
   * @generated
   */
  EClass getRepairEvent();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState <em>Error Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Behavior State</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
   * @generated
   */
  EClass getErrorBehaviorState();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState#getName()
   * @see #getErrorBehaviorState()
   * @generated
   */
  EAttribute getErrorBehaviorState_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState#isIntial <em>Intial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Intial</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState#isIntial()
   * @see #getErrorBehaviorState()
   * @generated
   */
  EAttribute getErrorBehaviorState_Intial();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState#getProperties()
   * @see #getErrorBehaviorState()
   * @generated
   */
  EReference getErrorBehaviorState_Properties();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition <em>Error Behavior Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Behavior Transition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition
   * @generated
   */
  EClass getErrorBehaviorTransition();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getSource()
   * @see #getErrorBehaviorTransition()
   * @generated
   */
  EReference getErrorBehaviorTransition_Source();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getDestination <em>Destination</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Destination</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getDestination()
   * @see #getErrorBehaviorTransition()
   * @generated
   */
  EReference getErrorBehaviorTransition_Destination();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition <em>Triggered Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Triggered Transition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition
   * @generated
   */
  EClass getTriggeredTransition();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition#getName()
   * @see #getTriggeredTransition()
   * @generated
   */
  EAttribute getTriggeredTransition_Name();

  /**
   * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Events</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TriggeredTransition#getEvents()
   * @see #getTriggeredTransition()
   * @generated
   */
  EReference getTriggeredTransition_Events();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchTransition <em>Branch Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Branch Transition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.BranchTransition
   * @generated
   */
  EClass getBranchTransition();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchTransition#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.BranchTransition#getValue()
   * @see #getBranchTransition()
   * @generated
   */
  EAttribute getBranchTransition_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior <em>Component Error Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Error Behavior</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior
   * @generated
   */
  EClass getComponentErrorBehavior();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getImportedNamespace()
   * @see #getComponentErrorBehavior()
   * @generated
   */
  EAttribute getComponentErrorBehavior_ImportedNamespace();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getTransitionCondition <em>Transition Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transition Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getTransitionCondition()
   * @see #getComponentErrorBehavior()
   * @generated
   */
  EReference getComponentErrorBehavior_TransitionCondition();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getPropagationCondition <em>Propagation Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Propagation Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getPropagationCondition()
   * @see #getComponentErrorBehavior()
   * @generated
   */
  EReference getComponentErrorBehavior_PropagationCondition();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getDetectionEvent <em>Detection Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Detection Event</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getDetectionEvent()
   * @see #getComponentErrorBehavior()
   * @generated
   */
  EReference getComponentErrorBehavior_DetectionEvent();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition <em>Transition Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition
   * @generated
   */
  EClass getTransitionCondition();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getErrorTransition <em>Error Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Error Transition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getErrorTransition()
   * @see #getTransitionCondition()
   * @generated
   */
  EReference getTransitionCondition_ErrorTransition();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#isMask <em>Mask</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mask</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#isMask()
   * @see #getTransitionCondition()
   * @generated
   */
  EAttribute getTransitionCondition_Mask();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getCondition()
   * @see #getTransitionCondition()
   * @generated
   */
  EReference getTransitionCondition_Condition();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression <em>Trigger Condition Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger Condition Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TriggerConditionExpression
   * @generated
   */
  EClass getTriggerConditionExpression();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression <em>Ormore Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ormore Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression
   * @generated
   */
  EClass getOrmoreExpression();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression#getCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression#getCount()
   * @see #getOrmoreExpression()
   * @generated
   */
  EAttribute getOrmoreExpression_Count();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression#getOperands()
   * @see #getOrmoreExpression()
   * @generated
   */
  EReference getOrmoreExpression_Operands();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression <em>Orless Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Orless Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression
   * @generated
   */
  EClass getOrlessExpression();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression#getCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression#getCount()
   * @see #getOrlessExpression()
   * @generated
   */
  EAttribute getOrlessExpression_Count();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression#getOperands()
   * @see #getOrlessExpression()
   * @generated
   */
  EReference getOrlessExpression_Operands();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OthersExpression <em>Others Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Others Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OthersExpression
   * @generated
   */
  EClass getOthersExpression();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEventReference <em>Error Event Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error Event Reference</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorEventReference
   * @generated
   */
  EClass getErrorEventReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEventReference#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorEventReference#getReference()
   * @see #getErrorEventReference()
   * @generated
   */
  EReference getErrorEventReference_Reference();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference <em>Working Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Working Reference</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference
   * @generated
   */
  EClass getWorkingReference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getBinding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Binding</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getBinding()
   * @see #getWorkingReference()
   * @generated
   */
  EAttribute getWorkingReference_Binding();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#getFeature()
   * @see #getWorkingReference()
   * @generated
   */
  EReference getWorkingReference_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isSelf <em>Self</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Self</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isSelf()
   * @see #getWorkingReference()
   * @generated
   */
  EAttribute getWorkingReference_Self();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isWorking <em>Working</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Working</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.WorkingReference#isWorking()
   * @see #getWorkingReference()
   * @generated
   */
  EAttribute getWorkingReference_Working();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition <em>Propagation Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Propagation Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition
   * @generated
   */
  EClass getPropagationCondition();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getOutPropagation <em>Out Propagation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Out Propagation</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getOutPropagation()
   * @see #getPropagationCondition()
   * @generated
   */
  EReference getPropagationCondition_OutPropagation();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isMask <em>Mask</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mask</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isMask()
   * @see #getPropagationCondition()
   * @generated
   */
  EAttribute getPropagationCondition_Mask();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isWorking <em>Working</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Working</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#isWorking()
   * @see #getPropagationCondition()
   * @generated
   */
  EAttribute getPropagationCondition_Working();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getState()
   * @see #getPropagationCondition()
   * @generated
   */
  EReference getPropagationCondition_State();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getCondition()
   * @see #getPropagationCondition()
   * @generated
   */
  EReference getPropagationCondition_Condition();

  /**
   * Returns the meta object for the reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Feature</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition#getFeature()
   * @see #getPropagationCondition()
   * @generated
   */
  EReference getPropagationCondition_Feature();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent <em>Detection Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Detection Event</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent
   * @generated
   */
  EClass getDetectionEvent();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#isSelf <em>Self</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Self</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#isSelf()
   * @see #getDetectionEvent()
   * @generated
   */
  EAttribute getDetectionEvent_Self();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getEventPort <em>Event Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event Port</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getEventPort()
   * @see #getDetectionEvent()
   * @generated
   */
  EReference getDetectionEvent_EventPort();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getCondition()
   * @see #getDetectionEvent()
   * @generated
   */
  EReference getDetectionEvent_Condition();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior <em>Composite Error Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composite Error Behavior</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior
   * @generated
   */
  EClass getCompositeErrorBehavior();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getImportedNamespace()
   * @see #getCompositeErrorBehavior()
   * @generated
   */
  EAttribute getCompositeErrorBehavior_ImportedNamespace();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getState()
   * @see #getCompositeErrorBehavior()
   * @generated
   */
  EReference getCompositeErrorBehavior_State();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState <em>Composite State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composite State</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeState
   * @generated
   */
  EClass getCompositeState();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>State</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getState()
   * @see #getCompositeState()
   * @generated
   */
  EReference getCompositeState_State();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getCondition()
   * @see #getCompositeState()
   * @generated
   */
  EReference getCompositeState_Condition();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.StateConditionExpression <em>State Condition Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Condition Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.StateConditionExpression
   * @generated
   */
  EClass getStateConditionExpression();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference <em>Subcomponent State Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subcomponent State Reference</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference
   * @generated
   */
  EClass getSubcomponentStateReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getSubcomponent <em>Subcomponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Subcomponent</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getSubcomponent()
   * @see #getSubcomponentStateReference()
   * @generated
   */
  EReference getSubcomponentStateReference_Subcomponent();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getErrortype <em>Errortype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Errortype</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentStateReference#getErrortype()
   * @see #getSubcomponentStateReference()
   * @generated
   */
  EReference getSubcomponentStateReference_Errortype();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation <em>Property Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Association</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation
   * @generated
   */
  EClass getPropertyAssociation();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation#getName()
   * @see #getPropertyAssociation()
   * @generated
   */
  EAttribute getPropertyAssociation_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropertyAssociation#getValue()
   * @see #getPropertyAssociation()
   * @generated
   */
  EReference getPropertyAssociation_Value();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropertyExpression <em>Property Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropertyExpression
   * @generated
   */
  EClass getPropertyExpression();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.Literal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.Literal#getName()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Name();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue <em>Probability Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Probability Value</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue
   * @generated
   */
  EClass getProbabilityValue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue#getNumber()
   * @see #getProbabilityValue()
   * @generated
   */
  EAttribute getProbabilityValue_Number();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue#getDistribution <em>Distribution</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Distribution</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ProbabilityValue#getDistribution()
   * @see #getProbabilityValue()
   * @generated
   */
  EAttribute getProbabilityValue_Distribution();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.AndExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.AndExpression#getOperands()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Operands();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OrExpression#getOperands()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Operands();

  /**
   * Returns the meta object for enum '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection <em>Propagation Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Propagation Direction</em>'.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection
   * @generated
   */
  EEnum getPropagationDirection();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ErrorModelFactory getErrorModelFactory();

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
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl <em>EM2 Annex Subclause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.EM2AnnexSubclauseImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getEM2AnnexSubclause()
     * @generated
     */
    EClass EM2_ANNEX_SUBCLAUSE = eINSTANCE.getEM2AnnexSubclause();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EM2_ANNEX_SUBCLAUSE__TYPES = eINSTANCE.getEM2AnnexSubclause_Types();

    /**
     * The meta object literal for the '<em><b>Ebsm</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EM2_ANNEX_SUBCLAUSE__EBSM = eINSTANCE.getEM2AnnexSubclause_Ebsm();

    /**
     * The meta object literal for the '<em><b>Ep</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EM2_ANNEX_SUBCLAUSE__EP = eINSTANCE.getEM2AnnexSubclause_Ep();

    /**
     * The meta object literal for the '<em><b>Ceb</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EM2_ANNEX_SUBCLAUSE__CEB = eINSTANCE.getEM2AnnexSubclause_Ceb();

    /**
     * The meta object literal for the '<em><b>Compeb</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EM2_ANNEX_SUBCLAUSE__COMPEB = eINSTANCE.getEM2AnnexSubclause_Compeb();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl <em>Error Type Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeSetImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorTypeSet()
     * @generated
     */
    EClass ERROR_TYPE_SET = eINSTANCE.getErrorTypeSet();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_TYPE_SET__NAME = eINSTANCE.getErrorTypeSet_Name();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_TYPE_SET__TYPES = eINSTANCE.getErrorTypeSet_Types();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_TYPE_SET__FEATURES = eINSTANCE.getErrorTypeSet_Features();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_TYPE_SET__EXTENDS = eINSTANCE.getErrorTypeSet_Extends();

    /**
     * The meta object literal for the '<em><b>Refinements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_TYPE_SET__REFINEMENTS = eINSTANCE.getErrorTypeSet_Refinements();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeImpl <em>Error Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorType()
     * @generated
     */
    EClass ERROR_TYPE = eINSTANCE.getErrorType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_TYPE__NAME = eINSTANCE.getErrorType_Name();

    /**
     * The meta object literal for the '<em><b>Subtypes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_TYPE__SUBTYPES = eINSTANCE.getErrorType_Subtypes();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.FeatureImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeRefinementImpl <em>Error Type Refinement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorTypeRefinementImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorTypeRefinement()
     * @generated
     */
    EClass ERROR_TYPE_REFINEMENT = eINSTANCE.getErrorTypeRefinement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_TYPE_REFINEMENT__NAME = eINSTANCE.getErrorTypeRefinement_Name();

    /**
     * The meta object literal for the '<em><b>Subtypes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_TYPE_REFINEMENT__SUBTYPES = eINSTANCE.getErrorTypeRefinement_Subtypes();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationsImpl <em>Error Propagations</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationsImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPropagations()
     * @generated
     */
    EClass ERROR_PROPAGATIONS = eINSTANCE.getErrorPropagations();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_PROPAGATIONS__IMPORTED_NAMESPACE = eINSTANCE.getErrorPropagations_ImportedNamespace();

    /**
     * The meta object literal for the '<em><b>Propagations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PROPAGATIONS__PROPAGATIONS = eINSTANCE.getErrorPropagations_Propagations();

    /**
     * The meta object literal for the '<em><b>Flows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PROPAGATIONS__FLOWS = eINSTANCE.getErrorPropagations_Flows();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl <em>Error Propagation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPropagation()
     * @generated
     */
    EClass ERROR_PROPAGATION = eINSTANCE.getErrorPropagation();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PROPAGATION__TYPE = eINSTANCE.getErrorPropagation_Type();

    /**
     * The meta object literal for the '<em><b>Mask</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_PROPAGATION__MASK = eINSTANCE.getErrorPropagation_Mask();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_PROPAGATION__DIRECTION = eINSTANCE.getErrorPropagation_Direction();

    /**
     * The meta object literal for the '<em><b>Binding</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_PROPAGATION__BINDING = eINSTANCE.getErrorPropagation_Binding();

    /**
     * The meta object literal for the '<em><b>Appliesto</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PROPAGATION__APPLIESTO = eINSTANCE.getErrorPropagation_Appliesto();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorFlowImpl <em>Error Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorFlowImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorFlow()
     * @generated
     */
    EClass ERROR_FLOW = eINSTANCE.getErrorFlow();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl <em>Error Source</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSourceImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorSource()
     * @generated
     */
    EClass ERROR_SOURCE = eINSTANCE.getErrorSource();

    /**
     * The meta object literal for the '<em><b>Outgoing</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_SOURCE__OUTGOING = eINSTANCE.getErrorSource_Outgoing();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSinkImpl <em>Error Sink</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorSinkImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorSink()
     * @generated
     */
    EClass ERROR_SINK = eINSTANCE.getErrorSink();

    /**
     * The meta object literal for the '<em><b>Incoming</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_SINK__INCOMING = eINSTANCE.getErrorSink_Incoming();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl <em>Error Path</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPathImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPath()
     * @generated
     */
    EClass ERROR_PATH = eINSTANCE.getErrorPath();

    /**
     * The meta object literal for the '<em><b>Incoming</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PATH__INCOMING = eINSTANCE.getErrorPath_Incoming();

    /**
     * The meta object literal for the '<em><b>Outgoing</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PATH__OUTGOING = eINSTANCE.getErrorPath_Outgoing();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl <em>Error Propagation Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationReferenceImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorPropagationReference()
     * @generated
     */
    EClass ERROR_PROPAGATION_REFERENCE = eINSTANCE.getErrorPropagationReference();

    /**
     * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_PROPAGATION_REFERENCE__BINDING = eINSTANCE.getErrorPropagationReference_Binding();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PROPAGATION_REFERENCE__FEATURE = eINSTANCE.getErrorPropagationReference_Feature();

    /**
     * The meta object literal for the '<em><b>Self</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_PROPAGATION_REFERENCE__SELF = eINSTANCE.getErrorPropagationReference_Self();

    /**
     * The meta object literal for the '<em><b>Errortype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_PROPAGATION_REFERENCE__ERRORTYPE = eINSTANCE.getErrorPropagationReference_Errortype();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl <em>Error Behavior State Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateMachineImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorStateMachine()
     * @generated
     */
    EClass ERROR_BEHAVIOR_STATE_MACHINE = eINSTANCE.getErrorBehaviorStateMachine();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_BEHAVIOR_STATE_MACHINE__NAME = eINSTANCE.getErrorBehaviorStateMachine_Name();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_BEHAVIOR_STATE_MACHINE__EXTENDS = eINSTANCE.getErrorBehaviorStateMachine_Extends();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_BEHAVIOR_STATE_MACHINE__IMPORTED_NAMESPACE = eINSTANCE.getErrorBehaviorStateMachine_ImportedNamespace();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_BEHAVIOR_STATE_MACHINE__EVENTS = eINSTANCE.getErrorBehaviorStateMachine_Events();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_BEHAVIOR_STATE_MACHINE__STATES = eINSTANCE.getErrorBehaviorStateMachine_States();

    /**
     * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_BEHAVIOR_STATE_MACHINE__TRANSITIONS = eINSTANCE.getErrorBehaviorStateMachine_Transitions();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorEventImpl <em>Error Behavior Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorEventImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorEvent()
     * @generated
     */
    EClass ERROR_BEHAVIOR_EVENT = eINSTANCE.getErrorBehaviorEvent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_BEHAVIOR_EVENT__NAME = eINSTANCE.getErrorBehaviorEvent_Name();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl <em>Error Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorEvent()
     * @generated
     */
    EClass ERROR_EVENT = eINSTANCE.getErrorEvent();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.RepairEventImpl <em>Repair Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.RepairEventImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getRepairEvent()
     * @generated
     */
    EClass REPAIR_EVENT = eINSTANCE.getRepairEvent();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateImpl <em>Error Behavior State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorStateImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorState()
     * @generated
     */
    EClass ERROR_BEHAVIOR_STATE = eINSTANCE.getErrorBehaviorState();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_BEHAVIOR_STATE__NAME = eINSTANCE.getErrorBehaviorState_Name();

    /**
     * The meta object literal for the '<em><b>Intial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR_BEHAVIOR_STATE__INTIAL = eINSTANCE.getErrorBehaviorState_Intial();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_BEHAVIOR_STATE__PROPERTIES = eINSTANCE.getErrorBehaviorState_Properties();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl <em>Error Behavior Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorBehaviorTransitionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorBehaviorTransition()
     * @generated
     */
    EClass ERROR_BEHAVIOR_TRANSITION = eINSTANCE.getErrorBehaviorTransition();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_BEHAVIOR_TRANSITION__SOURCE = eINSTANCE.getErrorBehaviorTransition_Source();

    /**
     * The meta object literal for the '<em><b>Destination</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_BEHAVIOR_TRANSITION__DESTINATION = eINSTANCE.getErrorBehaviorTransition_Destination();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggeredTransitionImpl <em>Triggered Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggeredTransitionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getTriggeredTransition()
     * @generated
     */
    EClass TRIGGERED_TRANSITION = eINSTANCE.getTriggeredTransition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRIGGERED_TRANSITION__NAME = eINSTANCE.getTriggeredTransition_Name();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGERED_TRANSITION__EVENTS = eINSTANCE.getTriggeredTransition_Events();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.BranchTransitionImpl <em>Branch Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.BranchTransitionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getBranchTransition()
     * @generated
     */
    EClass BRANCH_TRANSITION = eINSTANCE.getBranchTransition();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BRANCH_TRANSITION__VALUE = eINSTANCE.getBranchTransition_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl <em>Component Error Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ComponentErrorBehaviorImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getComponentErrorBehavior()
     * @generated
     */
    EClass COMPONENT_ERROR_BEHAVIOR = eINSTANCE.getComponentErrorBehavior();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT_ERROR_BEHAVIOR__IMPORTED_NAMESPACE = eINSTANCE.getComponentErrorBehavior_ImportedNamespace();

    /**
     * The meta object literal for the '<em><b>Transition Condition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ERROR_BEHAVIOR__TRANSITION_CONDITION = eINSTANCE.getComponentErrorBehavior_TransitionCondition();

    /**
     * The meta object literal for the '<em><b>Propagation Condition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ERROR_BEHAVIOR__PROPAGATION_CONDITION = eINSTANCE.getComponentErrorBehavior_PropagationCondition();

    /**
     * The meta object literal for the '<em><b>Detection Event</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ERROR_BEHAVIOR__DETECTION_EVENT = eINSTANCE.getComponentErrorBehavior_DetectionEvent();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionConditionImpl <em>Transition Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.TransitionConditionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getTransitionCondition()
     * @generated
     */
    EClass TRANSITION_CONDITION = eINSTANCE.getTransitionCondition();

    /**
     * The meta object literal for the '<em><b>Error Transition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_CONDITION__ERROR_TRANSITION = eINSTANCE.getTransitionCondition_ErrorTransition();

    /**
     * The meta object literal for the '<em><b>Mask</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION_CONDITION__MASK = eINSTANCE.getTransitionCondition_Mask();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_CONDITION__CONDITION = eINSTANCE.getTransitionCondition_Condition();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggerConditionExpressionImpl <em>Trigger Condition Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.TriggerConditionExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getTriggerConditionExpression()
     * @generated
     */
    EClass TRIGGER_CONDITION_EXPRESSION = eINSTANCE.getTriggerConditionExpression();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OrmoreExpressionImpl <em>Ormore Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OrmoreExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOrmoreExpression()
     * @generated
     */
    EClass ORMORE_EXPRESSION = eINSTANCE.getOrmoreExpression();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ORMORE_EXPRESSION__COUNT = eINSTANCE.getOrmoreExpression_Count();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORMORE_EXPRESSION__OPERANDS = eINSTANCE.getOrmoreExpression_Operands();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OrlessExpressionImpl <em>Orless Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OrlessExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOrlessExpression()
     * @generated
     */
    EClass ORLESS_EXPRESSION = eINSTANCE.getOrlessExpression();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ORLESS_EXPRESSION__COUNT = eINSTANCE.getOrlessExpression_Count();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORLESS_EXPRESSION__OPERANDS = eINSTANCE.getOrlessExpression_Operands();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OthersExpressionImpl <em>Others Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OthersExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOthersExpression()
     * @generated
     */
    EClass OTHERS_EXPRESSION = eINSTANCE.getOthersExpression();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventReferenceImpl <em>Error Event Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorEventReferenceImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getErrorEventReference()
     * @generated
     */
    EClass ERROR_EVENT_REFERENCE = eINSTANCE.getErrorEventReference();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR_EVENT_REFERENCE__REFERENCE = eINSTANCE.getErrorEventReference_Reference();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl <em>Working Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.WorkingReferenceImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getWorkingReference()
     * @generated
     */
    EClass WORKING_REFERENCE = eINSTANCE.getWorkingReference();

    /**
     * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORKING_REFERENCE__BINDING = eINSTANCE.getWorkingReference_Binding();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WORKING_REFERENCE__FEATURE = eINSTANCE.getWorkingReference_Feature();

    /**
     * The meta object literal for the '<em><b>Self</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORKING_REFERENCE__SELF = eINSTANCE.getWorkingReference_Self();

    /**
     * The meta object literal for the '<em><b>Working</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORKING_REFERENCE__WORKING = eINSTANCE.getWorkingReference_Working();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl <em>Propagation Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationConditionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropagationCondition()
     * @generated
     */
    EClass PROPAGATION_CONDITION = eINSTANCE.getPropagationCondition();

    /**
     * The meta object literal for the '<em><b>Out Propagation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPAGATION_CONDITION__OUT_PROPAGATION = eINSTANCE.getPropagationCondition_OutPropagation();

    /**
     * The meta object literal for the '<em><b>Mask</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPAGATION_CONDITION__MASK = eINSTANCE.getPropagationCondition_Mask();

    /**
     * The meta object literal for the '<em><b>Working</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPAGATION_CONDITION__WORKING = eINSTANCE.getPropagationCondition_Working();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPAGATION_CONDITION__STATE = eINSTANCE.getPropagationCondition_State();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPAGATION_CONDITION__CONDITION = eINSTANCE.getPropagationCondition_Condition();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPAGATION_CONDITION__FEATURE = eINSTANCE.getPropagationCondition_Feature();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.DetectionEventImpl <em>Detection Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.DetectionEventImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getDetectionEvent()
     * @generated
     */
    EClass DETECTION_EVENT = eINSTANCE.getDetectionEvent();

    /**
     * The meta object literal for the '<em><b>Self</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DETECTION_EVENT__SELF = eINSTANCE.getDetectionEvent_Self();

    /**
     * The meta object literal for the '<em><b>Event Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DETECTION_EVENT__EVENT_PORT = eINSTANCE.getDetectionEvent_EventPort();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DETECTION_EVENT__CONDITION = eINSTANCE.getDetectionEvent_Condition();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl <em>Composite Error Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeErrorBehaviorImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getCompositeErrorBehavior()
     * @generated
     */
    EClass COMPOSITE_ERROR_BEHAVIOR = eINSTANCE.getCompositeErrorBehavior();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPOSITE_ERROR_BEHAVIOR__IMPORTED_NAMESPACE = eINSTANCE.getCompositeErrorBehavior_ImportedNamespace();

    /**
     * The meta object literal for the '<em><b>State</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_ERROR_BEHAVIOR__STATE = eINSTANCE.getCompositeErrorBehavior_State();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeStateImpl <em>Composite State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.CompositeStateImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getCompositeState()
     * @generated
     */
    EClass COMPOSITE_STATE = eINSTANCE.getCompositeState();

    /**
     * The meta object literal for the '<em><b>State</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_STATE__STATE = eINSTANCE.getCompositeState_State();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_STATE__CONDITION = eINSTANCE.getCompositeState_Condition();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.StateConditionExpressionImpl <em>State Condition Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.StateConditionExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getStateConditionExpression()
     * @generated
     */
    EClass STATE_CONDITION_EXPRESSION = eINSTANCE.getStateConditionExpression();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentStateReferenceImpl <em>Subcomponent State Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.SubcomponentStateReferenceImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getSubcomponentStateReference()
     * @generated
     */
    EClass SUBCOMPONENT_STATE_REFERENCE = eINSTANCE.getSubcomponentStateReference();

    /**
     * The meta object literal for the '<em><b>Subcomponent</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBCOMPONENT_STATE_REFERENCE__SUBCOMPONENT = eINSTANCE.getSubcomponentStateReference_Subcomponent();

    /**
     * The meta object literal for the '<em><b>Errortype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBCOMPONENT_STATE_REFERENCE__ERRORTYPE = eINSTANCE.getSubcomponentStateReference_Errortype();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyAssociationImpl <em>Property Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyAssociationImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropertyAssociation()
     * @generated
     */
    EClass PROPERTY_ASSOCIATION = eINSTANCE.getPropertyAssociation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_ASSOCIATION__NAME = eINSTANCE.getPropertyAssociation_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_ASSOCIATION__VALUE = eINSTANCE.getPropertyAssociation_Value();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyExpressionImpl <em>Property Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.PropertyExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropertyExpression()
     * @generated
     */
    EClass PROPERTY_EXPRESSION = eINSTANCE.getPropertyExpression();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.LiteralImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__NAME = eINSTANCE.getLiteral_Name();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ProbabilityValueImpl <em>Probability Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ProbabilityValueImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getProbabilityValue()
     * @generated
     */
    EClass PROBABILITY_VALUE = eINSTANCE.getProbabilityValue();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROBABILITY_VALUE__NUMBER = eINSTANCE.getProbabilityValue_Number();

    /**
     * The meta object literal for the '<em><b>Distribution</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROBABILITY_VALUE__DISTRIBUTION = eINSTANCE.getProbabilityValue_Distribution();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.AndExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__OPERANDS = eINSTANCE.getAndExpression_Operands();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.OrExpressionImpl
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__OPERANDS = eINSTANCE.getOrExpression_Operands();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection <em>Propagation Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationDirection
     * @see org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl#getPropagationDirection()
     * @generated
     */
    EEnum PROPAGATION_DIRECTION = eINSTANCE.getPropagationDirection();

  }

} //ErrorModelPackage
