/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.ecore.EClass;
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
      ErrorModelFactory theErrorModelFactory = (ErrorModelFactory)EPackage.Registry.INSTANCE.getEFactory(ErrorModelPackage.eNS_URI);
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
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE: return createErrorModelSubclause();
      case ErrorModelPackage.ERROR_MODEL_LIBRARY: return createErrorModelLibrary();
      case ErrorModelPackage.EMV2_PROPERTY_ASSOCIATION: return createEMV2PropertyAssociation();
      case ErrorModelPackage.EMV2_PATH: return createEMV2Path();
      case ErrorModelPackage.EMV2_PATH_ELEMENT: return createEMV2PathElement();
      case ErrorModelPackage.ERROR_TYPES: return createErrorTypes();
      case ErrorModelPackage.ERROR_TYPE: return createErrorType();
      case ErrorModelPackage.TYPE_SET: return createTypeSet();
      case ErrorModelPackage.TYPE_TOKEN: return createTypeToken();
      case ErrorModelPackage.TYPE_TRANSFORMATION_SET: return createTypeTransformationSet();
      case ErrorModelPackage.TYPE_TRANSFORMATION: return createTypeTransformation();
      case ErrorModelPackage.TYPE_MAPPING_SET: return createTypeMappingSet();
      case ErrorModelPackage.TYPE_MAPPING: return createTypeMapping();
      case ErrorModelPackage.ERROR_PROPAGATION: return createErrorPropagation();
      case ErrorModelPackage.FEATUREOR_PP_REFERENCE: return createFeatureorPPReference();
      case ErrorModelPackage.ERROR_FLOW: return createErrorFlow();
      case ErrorModelPackage.ERROR_SOURCE: return createErrorSource();
      case ErrorModelPackage.ERROR_SINK: return createErrorSink();
      case ErrorModelPackage.ERROR_PATH: return createErrorPath();
      case ErrorModelPackage.IF_CONDITION: return createIfCondition();
      case ErrorModelPackage.PROPAGATION_POINT: return createPropagationPoint();
      case ErrorModelPackage.PROPAGATION_PATH: return createPropagationPath();
      case ErrorModelPackage.QUALIFIED_PROPAGATION_POINT: return createQualifiedPropagationPoint();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE_MACHINE: return createErrorBehaviorStateMachine();
      case ErrorModelPackage.ERROR_BEHAVIOR_EVENT: return createErrorBehaviorEvent();
      case ErrorModelPackage.ERROR_EVENT: return createErrorEvent();
      case ErrorModelPackage.REPAIR_EVENT: return createRepairEvent();
      case ErrorModelPackage.RECOVER_EVENT: return createRecoverEvent();
      case ErrorModelPackage.ERROR_BEHAVIOR_STATE: return createErrorBehaviorState();
      case ErrorModelPackage.ERROR_BEHAVIOR_TRANSITION: return createErrorBehaviorTransition();
      case ErrorModelPackage.TRANSITION_BRANCH: return createTransitionBranch();
      case ErrorModelPackage.BRANCH_VALUE: return createBranchValue();
      case ErrorModelPackage.CONDITION_EXPRESSION: return createConditionExpression();
      case ErrorModelPackage.ORMORE_EXPRESSION: return createOrmoreExpression();
      case ErrorModelPackage.ORLESS_EXPRESSION: return createOrlessExpression();
      case ErrorModelPackage.CONDITION_ELEMENT: return createConditionElement();
      case ErrorModelPackage.EVENT_OR_PROPAGATION: return createEventOrPropagation();
      case ErrorModelPackage.OUTGOING_PROPAGATION_CONDITION: return createOutgoingPropagationCondition();
      case ErrorModelPackage.ERROR_DETECTION: return createErrorDetection();
      case ErrorModelPackage.REPORTING_PORT_REFERENCE: return createReportingPortReference();
      case ErrorModelPackage.ERROR_CODE_VALUE: return createErrorCodeValue();
      case ErrorModelPackage.ERROR_STATE_TO_MODE_MAPPING: return createErrorStateToModeMapping();
      case ErrorModelPackage.COMPOSITE_STATE: return createCompositeState();
      case ErrorModelPackage.QUALIFIED_ERROR_BEHAVIOR_STATE: return createQualifiedErrorBehaviorState();
      case ErrorModelPackage.SUBCOMPONENT_ELEMENT: return createSubcomponentElement();
      case ErrorModelPackage.EMV2_ROOT: return createEMV2Root();
      case ErrorModelPackage.OR_EXPRESSION: return createOrExpression();
      case ErrorModelPackage.AND_EXPRESSION: return createAndExpression();
      case ErrorModelPackage.ALL_EXPRESSION: return createAllExpression();
      case ErrorModelPackage.QUALIFIED_ERROR_EVENT_OR_PROPAGATION: return createQualifiedErrorEventOrPropagation();
      case ErrorModelPackage.QUALIFIED_ERROR_PROPAGATION: return createQualifiedErrorPropagation();
      case ErrorModelPackage.SCONDITION_ELEMENT: return createSConditionElement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelSubclause createErrorModelSubclause()
  {
    ErrorModelSubclauseImpl errorModelSubclause = new ErrorModelSubclauseImpl();
    return errorModelSubclause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorModelLibrary createErrorModelLibrary()
  {
    ErrorModelLibraryImpl errorModelLibrary = new ErrorModelLibraryImpl();
    return errorModelLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2PropertyAssociation createEMV2PropertyAssociation()
  {
    EMV2PropertyAssociationImpl emv2PropertyAssociation = new EMV2PropertyAssociationImpl();
    return emv2PropertyAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2Path createEMV2Path()
  {
    EMV2PathImpl emv2Path = new EMV2PathImpl();
    return emv2Path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2PathElement createEMV2PathElement()
  {
    EMV2PathElementImpl emv2PathElement = new EMV2PathElementImpl();
    return emv2PathElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorTypes createErrorTypes()
  {
    ErrorTypesImpl errorTypes = new ErrorTypesImpl();
    return errorTypes;
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
  public TypeSet createTypeSet()
  {
    TypeSetImpl typeSet = new TypeSetImpl();
    return typeSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeToken createTypeToken()
  {
    TypeTokenImpl typeToken = new TypeTokenImpl();
    return typeToken;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformationSet createTypeTransformationSet()
  {
    TypeTransformationSetImpl typeTransformationSet = new TypeTransformationSetImpl();
    return typeTransformationSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformation createTypeTransformation()
  {
    TypeTransformationImpl typeTransformation = new TypeTransformationImpl();
    return typeTransformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMappingSet createTypeMappingSet()
  {
    TypeMappingSetImpl typeMappingSet = new TypeMappingSetImpl();
    return typeMappingSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMapping createTypeMapping()
  {
    TypeMappingImpl typeMapping = new TypeMappingImpl();
    return typeMapping;
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
  public FeatureorPPReference createFeatureorPPReference()
  {
    FeatureorPPReferenceImpl featureorPPReference = new FeatureorPPReferenceImpl();
    return featureorPPReference;
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
  public IfCondition createIfCondition()
  {
    IfConditionImpl ifCondition = new IfConditionImpl();
    return ifCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropagationPoint createPropagationPoint()
  {
    PropagationPointImpl propagationPoint = new PropagationPointImpl();
    return propagationPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropagationPath createPropagationPath()
  {
    PropagationPathImpl propagationPath = new PropagationPathImpl();
    return propagationPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedPropagationPoint createQualifiedPropagationPoint()
  {
    QualifiedPropagationPointImpl qualifiedPropagationPoint = new QualifiedPropagationPointImpl();
    return qualifiedPropagationPoint;
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
  public RecoverEvent createRecoverEvent()
  {
    RecoverEventImpl recoverEvent = new RecoverEventImpl();
    return recoverEvent;
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
  public TransitionBranch createTransitionBranch()
  {
    TransitionBranchImpl transitionBranch = new TransitionBranchImpl();
    return transitionBranch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BranchValue createBranchValue()
  {
    BranchValueImpl branchValue = new BranchValueImpl();
    return branchValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionExpression createConditionExpression()
  {
    ConditionExpressionImpl conditionExpression = new ConditionExpressionImpl();
    return conditionExpression;
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
  public ConditionElement createConditionElement()
  {
    ConditionElementImpl conditionElement = new ConditionElementImpl();
    return conditionElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventOrPropagation createEventOrPropagation()
  {
    EventOrPropagationImpl eventOrPropagation = new EventOrPropagationImpl();
    return eventOrPropagation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutgoingPropagationCondition createOutgoingPropagationCondition()
  {
    OutgoingPropagationConditionImpl outgoingPropagationCondition = new OutgoingPropagationConditionImpl();
    return outgoingPropagationCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorDetection createErrorDetection()
  {
    ErrorDetectionImpl errorDetection = new ErrorDetectionImpl();
    return errorDetection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReportingPortReference createReportingPortReference()
  {
    ReportingPortReferenceImpl reportingPortReference = new ReportingPortReferenceImpl();
    return reportingPortReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorCodeValue createErrorCodeValue()
  {
    ErrorCodeValueImpl errorCodeValue = new ErrorCodeValueImpl();
    return errorCodeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorStateToModeMapping createErrorStateToModeMapping()
  {
    ErrorStateToModeMappingImpl errorStateToModeMapping = new ErrorStateToModeMappingImpl();
    return errorStateToModeMapping;
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
  public QualifiedErrorBehaviorState createQualifiedErrorBehaviorState()
  {
    QualifiedErrorBehaviorStateImpl qualifiedErrorBehaviorState = new QualifiedErrorBehaviorStateImpl();
    return qualifiedErrorBehaviorState;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubcomponentElement createSubcomponentElement()
  {
    SubcomponentElementImpl subcomponentElement = new SubcomponentElementImpl();
    return subcomponentElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMV2Root createEMV2Root()
  {
    EMV2RootImpl emv2Root = new EMV2RootImpl();
    return emv2Root;
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
  public AllExpression createAllExpression()
  {
    AllExpressionImpl allExpression = new AllExpressionImpl();
    return allExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedErrorEventOrPropagation createQualifiedErrorEventOrPropagation()
  {
    QualifiedErrorEventOrPropagationImpl qualifiedErrorEventOrPropagation = new QualifiedErrorEventOrPropagationImpl();
    return qualifiedErrorEventOrPropagation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedErrorPropagation createQualifiedErrorPropagation()
  {
    QualifiedErrorPropagationImpl qualifiedErrorPropagation = new QualifiedErrorPropagationImpl();
    return qualifiedErrorPropagation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SConditionElement createSConditionElement()
  {
    SConditionElementImpl sConditionElement = new SConditionElementImpl();
    return sConditionElement;
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
