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
package org.osate.xtext.aadl2.errormodel.errorModel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;

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
      public Adapter caseErrorModelSubclause(ErrorModelSubclause object)
      {
        return createErrorModelSubclauseAdapter();
      }
      @Override
      public Adapter caseErrorModelLibrary(ErrorModelLibrary object)
      {
        return createErrorModelLibraryAdapter();
      }
      @Override
      public Adapter caseEMV2PropertyAssociation(EMV2PropertyAssociation object)
      {
        return createEMV2PropertyAssociationAdapter();
      }
      @Override
      public Adapter caseEMV2Path(EMV2Path object)
      {
        return createEMV2PathAdapter();
      }
      @Override
      public Adapter caseEMV2PathElement(EMV2PathElement object)
      {
        return createEMV2PathElementAdapter();
      }
      @Override
      public Adapter caseErrorTypes(ErrorTypes object)
      {
        return createErrorTypesAdapter();
      }
      @Override
      public Adapter caseErrorType(ErrorType object)
      {
        return createErrorTypeAdapter();
      }
      @Override
      public Adapter caseTypeSet(TypeSet object)
      {
        return createTypeSetAdapter();
      }
      @Override
      public Adapter caseTypeToken(TypeToken object)
      {
        return createTypeTokenAdapter();
      }
      @Override
      public Adapter caseTypeTransformationSet(TypeTransformationSet object)
      {
        return createTypeTransformationSetAdapter();
      }
      @Override
      public Adapter caseTypeTransformation(TypeTransformation object)
      {
        return createTypeTransformationAdapter();
      }
      @Override
      public Adapter caseTypeMappingSet(TypeMappingSet object)
      {
        return createTypeMappingSetAdapter();
      }
      @Override
      public Adapter caseTypeMapping(TypeMapping object)
      {
        return createTypeMappingAdapter();
      }
      @Override
      public Adapter caseErrorPropagation(ErrorPropagation object)
      {
        return createErrorPropagationAdapter();
      }
      @Override
      public Adapter caseFeatureorPPReference(FeatureorPPReference object)
      {
        return createFeatureorPPReferenceAdapter();
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
      public Adapter caseIfCondition(IfCondition object)
      {
        return createIfConditionAdapter();
      }
      @Override
      public Adapter casePropagationPoint(PropagationPoint object)
      {
        return createPropagationPointAdapter();
      }
      @Override
      public Adapter casePropagationPath(PropagationPath object)
      {
        return createPropagationPathAdapter();
      }
      @Override
      public Adapter caseQualifiedPropagationPoint(QualifiedPropagationPoint object)
      {
        return createQualifiedPropagationPointAdapter();
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
      public Adapter caseRecoverEvent(RecoverEvent object)
      {
        return createRecoverEventAdapter();
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
      public Adapter caseTransitionBranch(TransitionBranch object)
      {
        return createTransitionBranchAdapter();
      }
      @Override
      public Adapter caseBranchValue(BranchValue object)
      {
        return createBranchValueAdapter();
      }
      @Override
      public Adapter caseConditionExpression(ConditionExpression object)
      {
        return createConditionExpressionAdapter();
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
      public Adapter caseConditionElement(ConditionElement object)
      {
        return createConditionElementAdapter();
      }
      @Override
      public Adapter caseEventOrPropagation(EventOrPropagation object)
      {
        return createEventOrPropagationAdapter();
      }
      @Override
      public Adapter caseOutgoingPropagationCondition(OutgoingPropagationCondition object)
      {
        return createOutgoingPropagationConditionAdapter();
      }
      @Override
      public Adapter caseErrorDetection(ErrorDetection object)
      {
        return createErrorDetectionAdapter();
      }
      @Override
      public Adapter caseReportingPortReference(ReportingPortReference object)
      {
        return createReportingPortReferenceAdapter();
      }
      @Override
      public Adapter caseErrorCodeValue(ErrorCodeValue object)
      {
        return createErrorCodeValueAdapter();
      }
      @Override
      public Adapter caseErrorStateToModeMapping(ErrorStateToModeMapping object)
      {
        return createErrorStateToModeMappingAdapter();
      }
      @Override
      public Adapter caseCompositeState(CompositeState object)
      {
        return createCompositeStateAdapter();
      }
      @Override
      public Adapter caseQualifiedErrorBehaviorState(QualifiedErrorBehaviorState object)
      {
        return createQualifiedErrorBehaviorStateAdapter();
      }
      @Override
      public Adapter caseSubcomponentElement(SubcomponentElement object)
      {
        return createSubcomponentElementAdapter();
      }
      @Override
      public Adapter caseEMV2Root(EMV2Root object)
      {
        return createEMV2RootAdapter();
      }
      @Override
      public Adapter caseOrExpression(OrExpression object)
      {
        return createOrExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseAllExpression(AllExpression object)
      {
        return createAllExpressionAdapter();
      }
      @Override
      public Adapter caseQualifiedErrorEventOrPropagation(QualifiedErrorEventOrPropagation object)
      {
        return createQualifiedErrorEventOrPropagationAdapter();
      }
      @Override
      public Adapter caseQualifiedErrorPropagation(QualifiedErrorPropagation object)
      {
        return createQualifiedErrorPropagationAdapter();
      }
      @Override
      public Adapter caseSConditionElement(SConditionElement object)
      {
        return createSConditionElementAdapter();
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
      public Adapter caseAnnexLibrary(AnnexLibrary object)
      {
        return createAnnexLibraryAdapter();
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause <em>Subclause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
   * @generated
   */
  public Adapter createErrorModelSubclauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
   * @generated
   */
  public Adapter createErrorModelLibraryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation <em>EMV2 Property Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation
   * @generated
   */
  public Adapter createEMV2PropertyAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path <em>EMV2 Path</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path
   * @generated
   */
  public Adapter createEMV2PathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement <em>EMV2 Path Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement
   * @generated
   */
  public Adapter createEMV2PathElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes <em>Error Types</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes
   * @generated
   */
  public Adapter createErrorTypesAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeSet <em>Type Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TypeSet
   * @generated
   */
  public Adapter createTypeSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeToken <em>Type Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TypeToken
   * @generated
   */
  public Adapter createTypeTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet <em>Type Transformation Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet
   * @generated
   */
  public Adapter createTypeTransformationSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation <em>Type Transformation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformation
   * @generated
   */
  public Adapter createTypeTransformationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet <em>Type Mapping Set</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet
   * @generated
   */
  public Adapter createTypeMappingSetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping <em>Type Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping
   * @generated
   */
  public Adapter createTypeMappingAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference <em>Featureor PP Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference
   * @generated
   */
  public Adapter createFeatureorPPReferenceAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.IfCondition <em>If Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.IfCondition
   * @generated
   */
  public Adapter createIfConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint <em>Propagation Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint
   * @generated
   */
  public Adapter createPropagationPointAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath <em>Propagation Path</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath
   * @generated
   */
  public Adapter createPropagationPathAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint <em>Qualified Propagation Point</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint
   * @generated
   */
  public Adapter createQualifiedPropagationPointAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent <em>Recover Event</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent
   * @generated
   */
  public Adapter createRecoverEventAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch <em>Transition Branch</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch
   * @generated
   */
  public Adapter createTransitionBranchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.BranchValue <em>Branch Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.BranchValue
   * @generated
   */
  public Adapter createBranchValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression <em>Condition Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression
   * @generated
   */
  public Adapter createConditionExpressionAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement <em>Condition Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement
   * @generated
   */
  public Adapter createConditionElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation <em>Event Or Propagation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation
   * @generated
   */
  public Adapter createEventOrPropagationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition <em>Outgoing Propagation Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition
   * @generated
   */
  public Adapter createOutgoingPropagationConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection <em>Error Detection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection
   * @generated
   */
  public Adapter createErrorDetectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ReportingPortReference <em>Reporting Port Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ReportingPortReference
   * @generated
   */
  public Adapter createReportingPortReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue <em>Error Code Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorCodeValue
   * @generated
   */
  public Adapter createErrorCodeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping <em>Error State To Mode Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping
   * @generated
   */
  public Adapter createErrorStateToModeMappingAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState <em>Qualified Error Behavior State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState
   * @generated
   */
  public Adapter createQualifiedErrorBehaviorStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement <em>Subcomponent Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement
   * @generated
   */
  public Adapter createSubcomponentElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root <em>EMV2 Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.EMV2Root
   * @generated
   */
  public Adapter createEMV2RootAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.AllExpression <em>All Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.AllExpression
   * @generated
   */
  public Adapter createAllExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation <em>Qualified Error Event Or Propagation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation
   * @generated
   */
  public Adapter createQualifiedErrorEventOrPropagationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorPropagation <em>Qualified Error Propagation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorPropagation
   * @generated
   */
  public Adapter createQualifiedErrorPropagationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement <em>SCondition Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement
   * @generated
   */
  public Adapter createSConditionElementAdapter()
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
   * Creates a new adapter for an object of class '{@link org.osate.aadl2.AnnexLibrary <em>Annex Library</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.osate.aadl2.AnnexLibrary
   * @generated
   */
  public Adapter createAnnexLibraryAdapter()
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
