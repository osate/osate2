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
package org.osate.aadl2.errormodel.instance.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.instance.AbstractTypeSet;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.AllPropagations;
import org.osate.aadl2.errormodel.instance.AllPropagationsNoError;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.Branch;
import org.osate.aadl2.errormodel.instance.BranchSameState;
import org.osate.aadl2.errormodel.instance.BranchStateReference;
import org.osate.aadl2.errormodel.instance.Branches;
import org.osate.aadl2.errormodel.instance.CompositeConditionExpression;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.ConditionExpressionInstance;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.ConnectionEndPropagation;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.ConstantCode;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.DestinationPropagationReference;
import org.osate.aadl2.errormodel.instance.DestinationStateReference;
import org.osate.aadl2.errormodel.instance.DetectionInstance;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceObject;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.ErrorCodeInstance;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.IntegerCode;
import org.osate.aadl2.errormodel.instance.ModeMappingInstance;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.OthersExpression;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.SameState;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateMachineProperties;
import org.osate.aadl2.errormodel.instance.StateReference;
import org.osate.aadl2.errormodel.instance.StateSource;
import org.osate.aadl2.errormodel.instance.StringCode;
import org.osate.aadl2.errormodel.instance.TransitionDestination;
import org.osate.aadl2.errormodel.instance.TransitionInstance;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.InstanceObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage
 * @generated
 */
public class EMV2InstanceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EMV2InstancePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMV2InstanceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EMV2InstancePackage.eINSTANCE;
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
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMV2InstanceSwitch<Adapter> modelSwitch = new EMV2InstanceSwitch<>() {
		@Override
		public Adapter caseEMV2AnnexInstance(EMV2AnnexInstance object) {
			return createEMV2AnnexInstanceAdapter();
		}

		@Override
		public Adapter caseEMV2InstanceObject(EMV2InstanceObject object) {
			return createEMV2InstanceObjectAdapter();
		}

		@Override
		public Adapter caseStateMachineProperties(StateMachineProperties object) {
			return createStateMachinePropertiesAdapter();
		}

		@Override
		public Adapter caseErrorPropagationInstance(ErrorPropagationInstance object) {
			return createErrorPropagationInstanceAdapter();
		}

		@Override
		public Adapter caseConnectionEndPropagation(ConnectionEndPropagation object) {
			return createConnectionEndPropagationAdapter();
		}

		@Override
		public Adapter caseFeaturePropagation(FeaturePropagation object) {
			return createFeaturePropagationAdapter();
		}

		@Override
		public Adapter caseAccessPropagation(AccessPropagation object) {
			return createAccessPropagationAdapter();
		}

		@Override
		public Adapter casePointPropagation(PointPropagation object) {
			return createPointPropagationAdapter();
		}

		@Override
		public Adapter caseBindingPropagation(BindingPropagation object) {
			return createBindingPropagationAdapter();
		}

		@Override
		public Adapter caseTypeSetElement(TypeSetElement object) {
			return createTypeSetElementAdapter();
		}

		@Override
		public Adapter caseTypeTokenInstance(TypeTokenInstance object) {
			return createTypeTokenInstanceAdapter();
		}

		@Override
		public Adapter caseTypeInstance(TypeInstance object) {
			return createTypeInstanceAdapter();
		}

		@Override
		public Adapter caseTypeProductInstance(TypeProductInstance object) {
			return createTypeProductInstanceAdapter();
		}

		@Override
		public Adapter caseAbstractTypeSet(AbstractTypeSet object) {
			return createAbstractTypeSetAdapter();
		}

		@Override
		public Adapter caseTypeSetInstance(TypeSetInstance object) {
			return createTypeSetInstanceAdapter();
		}

		@Override
		public Adapter caseAnonymousTypeSet(AnonymousTypeSet object) {
			return createAnonymousTypeSetAdapter();
		}

		@Override
		public Adapter caseErrorFlowInstance(ErrorFlowInstance object) {
			return createErrorFlowInstanceAdapter();
		}

		@Override
		public Adapter caseErrorSourceInstance(ErrorSourceInstance object) {
			return createErrorSourceInstanceAdapter();
		}

		@Override
		public Adapter caseErrorSinkInstance(ErrorSinkInstance object) {
			return createErrorSinkInstanceAdapter();
		}

		@Override
		public Adapter caseErrorPathInstance(ErrorPathInstance object) {
			return createErrorPathInstanceAdapter();
		}

		@Override
		public Adapter casePropagationPointInstance(PropagationPointInstance object) {
			return createPropagationPointInstanceAdapter();
		}

		@Override
		public Adapter casePropagationPathInstance(PropagationPathInstance object) {
			return createPropagationPathInstanceAdapter();
		}

		@Override
		public Adapter caseConnectionPath(ConnectionPath object) {
			return createConnectionPathAdapter();
		}

		@Override
		public Adapter caseBindingPath(BindingPath object) {
			return createBindingPathAdapter();
		}

		@Override
		public Adapter caseUserDefinedPath(UserDefinedPath object) {
			return createUserDefinedPathAdapter();
		}

		@Override
		public Adapter caseStateInstance(StateInstance object) {
			return createStateInstanceAdapter();
		}

		@Override
		public Adapter caseEventInstance(EventInstance object) {
			return createEventInstanceAdapter();
		}

		@Override
		public Adapter caseErrorEventInstance(ErrorEventInstance object) {
			return createErrorEventInstanceAdapter();
		}

		@Override
		public Adapter caseRecoverEventInstance(RecoverEventInstance object) {
			return createRecoverEventInstanceAdapter();
		}

		@Override
		public Adapter caseRepairEventInstance(RepairEventInstance object) {
			return createRepairEventInstanceAdapter();
		}

		@Override
		public Adapter caseTransitionInstance(TransitionInstance object) {
			return createTransitionInstanceAdapter();
		}

		@Override
		public Adapter caseStateSource(StateSource object) {
			return createStateSourceAdapter();
		}

		@Override
		public Adapter caseSourceStateReference(SourceStateReference object) {
			return createSourceStateReferenceAdapter();
		}

		@Override
		public Adapter caseAllSources(AllSources object) {
			return createAllSourcesAdapter();
		}

		@Override
		public Adapter caseConditionExpressionInstance(ConditionExpressionInstance object) {
			return createConditionExpressionInstanceAdapter();
		}

		@Override
		public Adapter caseEventReference(EventReference object) {
			return createEventReferenceAdapter();
		}

		@Override
		public Adapter caseConditionPropagationReference(ConditionPropagationReference object) {
			return createConditionPropagationReferenceAdapter();
		}

		@Override
		public Adapter caseNoErrorPropagationReference(NoErrorPropagationReference object) {
			return createNoErrorPropagationReferenceAdapter();
		}

		@Override
		public Adapter caseCountExpression(CountExpression object) {
			return createCountExpressionAdapter();
		}

		@Override
		public Adapter caseTransitionDestination(TransitionDestination object) {
			return createTransitionDestinationAdapter();
		}

		@Override
		public Adapter caseDestinationStateReference(DestinationStateReference object) {
			return createDestinationStateReferenceAdapter();
		}

		@Override
		public Adapter caseSameState(SameState object) {
			return createSameStateAdapter();
		}

		@Override
		public Adapter caseBranches(Branches object) {
			return createBranchesAdapter();
		}

		@Override
		public Adapter caseBranch(Branch object) {
			return createBranchAdapter();
		}

		@Override
		public Adapter caseBranchStateReference(BranchStateReference object) {
			return createBranchStateReferenceAdapter();
		}

		@Override
		public Adapter caseBranchSameState(BranchSameState object) {
			return createBranchSameStateAdapter();
		}

		@Override
		public Adapter caseOutgoingPropagationConditionInstance(OutgoingPropagationConditionInstance object) {
			return createOutgoingPropagationConditionInstanceAdapter();
		}

		@Override
		public Adapter caseOutgoingPropagationConditionDestination(OutgoingPropagationConditionDestination object) {
			return createOutgoingPropagationConditionDestinationAdapter();
		}

		@Override
		public Adapter caseDestinationPropagationReference(DestinationPropagationReference object) {
			return createDestinationPropagationReferenceAdapter();
		}

		@Override
		public Adapter caseAllPropagations(AllPropagations object) {
			return createAllPropagationsAdapter();
		}

		@Override
		public Adapter caseAllPropagationsNoError(AllPropagationsNoError object) {
			return createAllPropagationsNoErrorAdapter();
		}

		@Override
		public Adapter caseDetectionInstance(DetectionInstance object) {
			return createDetectionInstanceAdapter();
		}

		@Override
		public Adapter caseErrorCodeInstance(ErrorCodeInstance object) {
			return createErrorCodeInstanceAdapter();
		}

		@Override
		public Adapter caseIntegerCode(IntegerCode object) {
			return createIntegerCodeAdapter();
		}

		@Override
		public Adapter caseStringCode(StringCode object) {
			return createStringCodeAdapter();
		}

		@Override
		public Adapter caseConstantCode(ConstantCode object) {
			return createConstantCodeAdapter();
		}

		@Override
		public Adapter caseModeMappingInstance(ModeMappingInstance object) {
			return createModeMappingInstanceAdapter();
		}

		@Override
		public Adapter caseCompositeStateInstance(CompositeStateInstance object) {
			return createCompositeStateInstanceAdapter();
		}

		@Override
		public Adapter caseCompositeConditionExpression(CompositeConditionExpression object) {
			return createCompositeConditionExpressionAdapter();
		}

		@Override
		public Adapter caseOthersExpression(OthersExpression object) {
			return createOthersExpressionAdapter();
		}

		@Override
		public Adapter caseStateReference(StateReference object) {
			return createStateReferenceAdapter();
		}

		@Override
		public Adapter caseElement(Element object) {
			return createElementAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseAnnexInstance(AnnexInstance object) {
			return createAnnexInstanceAdapter();
		}

		@Override
		public Adapter caseInstanceObject(InstanceObject object) {
			return createInstanceObjectAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.EMV2AnnexInstance <em>EMV2 Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.EMV2AnnexInstance
	 * @generated
	 */
	public Adapter createEMV2AnnexInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.EMV2InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstanceObject
	 * @generated
	 */
	public Adapter createEMV2InstanceObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.StateMachineProperties <em>State Machine Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.StateMachineProperties
	 * @generated
	 */
	public Adapter createStateMachinePropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.StateInstance <em>State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.StateInstance
	 * @generated
	 */
	public Adapter createStateInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.CompositeStateInstance <em>Composite State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.CompositeStateInstance
	 * @generated
	 */
	public Adapter createCompositeStateInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.CompositeConditionExpression <em>Composite Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.CompositeConditionExpression
	 * @generated
	 */
	public Adapter createCompositeConditionExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.OthersExpression <em>Others Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.OthersExpression
	 * @generated
	 */
	public Adapter createOthersExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.StateReference <em>State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.StateReference
	 * @generated
	 */
	public Adapter createStateReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ErrorFlowInstance <em>Error Flow Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ErrorFlowInstance
	 * @generated
	 */
	public Adapter createErrorFlowInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ErrorSourceInstance <em>Error Source Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSourceInstance
	 * @generated
	 */
	public Adapter createErrorSourceInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ErrorSinkInstance <em>Error Sink Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ErrorSinkInstance
	 * @generated
	 */
	public Adapter createErrorSinkInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance <em>Error Path Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPathInstance
	 * @generated
	 */
	public Adapter createErrorPathInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.PropagationPointInstance <em>Propagation Point Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.PropagationPointInstance
	 * @generated
	 */
	public Adapter createPropagationPointInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.PropagationPathInstance <em>Propagation Path Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.PropagationPathInstance
	 * @generated
	 */
	public Adapter createPropagationPathInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ConnectionPath <em>Connection Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionPath
	 * @generated
	 */
	public Adapter createConnectionPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.BindingPath <em>Binding Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.BindingPath
	 * @generated
	 */
	public Adapter createBindingPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath <em>User Defined Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath
	 * @generated
	 */
	public Adapter createUserDefinedPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.EventInstance <em>Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.EventInstance
	 * @generated
	 */
	public Adapter createEventInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ErrorEventInstance <em>Error Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ErrorEventInstance
	 * @generated
	 */
	public Adapter createErrorEventInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.RecoverEventInstance <em>Recover Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.RecoverEventInstance
	 * @generated
	 */
	public Adapter createRecoverEventInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.RepairEventInstance <em>Repair Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.RepairEventInstance
	 * @generated
	 */
	public Adapter createRepairEventInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.TransitionInstance <em>Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.TransitionInstance
	 * @generated
	 */
	public Adapter createTransitionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.StateSource <em>State Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.StateSource
	 * @generated
	 */
	public Adapter createStateSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.SourceStateReference <em>Source State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.SourceStateReference
	 * @generated
	 */
	public Adapter createSourceStateReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.AllSources <em>All Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.AllSources
	 * @generated
	 */
	public Adapter createAllSourcesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ConditionExpressionInstance <em>Condition Expression Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ConditionExpressionInstance
	 * @generated
	 */
	public Adapter createConditionExpressionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.EventReference <em>Event Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.EventReference
	 * @generated
	 */
	public Adapter createEventReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ConditionPropagationReference <em>Condition Propagation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ConditionPropagationReference
	 * @generated
	 */
	public Adapter createConditionPropagationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.NoErrorPropagationReference <em>No Error Propagation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.NoErrorPropagationReference
	 * @generated
	 */
	public Adapter createNoErrorPropagationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.CountExpression <em>Count Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.CountExpression
	 * @generated
	 */
	public Adapter createCountExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.TransitionDestination <em>Transition Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.TransitionDestination
	 * @generated
	 */
	public Adapter createTransitionDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.DestinationStateReference <em>Destination State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.DestinationStateReference
	 * @generated
	 */
	public Adapter createDestinationStateReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.SameState <em>Same State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.SameState
	 * @generated
	 */
	public Adapter createSameStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.Branches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.Branches
	 * @generated
	 */
	public Adapter createBranchesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.Branch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.Branch
	 * @generated
	 */
	public Adapter createBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.BranchStateReference <em>Branch State Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.BranchStateReference
	 * @generated
	 */
	public Adapter createBranchStateReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.BranchSameState <em>Branch Same State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.BranchSameState
	 * @generated
	 */
	public Adapter createBranchSameStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance <em>Outgoing Propagation Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance
	 * @generated
	 */
	public Adapter createOutgoingPropagationConditionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination <em>Outgoing Propagation Condition Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination
	 * @generated
	 */
	public Adapter createOutgoingPropagationConditionDestinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.DestinationPropagationReference <em>Destination Propagation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.DestinationPropagationReference
	 * @generated
	 */
	public Adapter createDestinationPropagationReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.AllPropagations <em>All Propagations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.AllPropagations
	 * @generated
	 */
	public Adapter createAllPropagationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.AllPropagationsNoError <em>All Propagations No Error</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.AllPropagationsNoError
	 * @generated
	 */
	public Adapter createAllPropagationsNoErrorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.DetectionInstance <em>Detection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.DetectionInstance
	 * @generated
	 */
	public Adapter createDetectionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ErrorCodeInstance <em>Error Code Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ErrorCodeInstance
	 * @generated
	 */
	public Adapter createErrorCodeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.IntegerCode <em>Integer Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.IntegerCode
	 * @generated
	 */
	public Adapter createIntegerCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.StringCode <em>String Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.StringCode
	 * @generated
	 */
	public Adapter createStringCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ConstantCode <em>Constant Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ConstantCode
	 * @generated
	 */
	public Adapter createConstantCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ModeMappingInstance <em>Mode Mapping Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ModeMappingInstance
	 * @generated
	 */
	public Adapter createModeMappingInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance <em>Error Propagation Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance
	 * @generated
	 */
	public Adapter createErrorPropagationInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.ConnectionEndPropagation <em>Connection End Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.ConnectionEndPropagation
	 * @generated
	 */
	public Adapter createConnectionEndPropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.FeaturePropagation <em>Feature Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.FeaturePropagation
	 * @generated
	 */
	public Adapter createFeaturePropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.PointPropagation <em>Point Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.PointPropagation
	 * @generated
	 */
	public Adapter createPointPropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.AccessPropagation <em>Access Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.AccessPropagation
	 * @generated
	 */
	public Adapter createAccessPropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.BindingPropagation <em>Binding Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.BindingPropagation
	 * @generated
	 */
	public Adapter createBindingPropagationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.TypeSetElement <em>Type Set Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.TypeSetElement
	 * @generated
	 */
	public Adapter createTypeSetElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.TypeTokenInstance <em>Type Token Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.TypeTokenInstance
	 * @generated
	 */
	public Adapter createTypeTokenInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.TypeInstance <em>Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.TypeInstance
	 * @generated
	 */
	public Adapter createTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.TypeSetInstance <em>Type Set Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.TypeSetInstance
	 * @generated
	 */
	public Adapter createTypeSetInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.AnonymousTypeSet <em>Anonymous Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.AnonymousTypeSet
	 * @generated
	 */
	public Adapter createAnonymousTypeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.TypeProductInstance <em>Type Product Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.TypeProductInstance
	 * @generated
	 */
	public Adapter createTypeProductInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.errormodel.instance.AbstractTypeSet <em>Abstract Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.errormodel.instance.AbstractTypeSet
	 * @generated
	 */
	public Adapter createAbstractTypeSetAdapter() {
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
	public Adapter createElementAdapter() {
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
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.instance.AnnexInstance <em>Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.instance.AnnexInstance
	 * @generated
	 */
	public Adapter createAnnexInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.instance.InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.instance.InstanceObject
	 * @generated
	 */
	public Adapter createInstanceObjectAdapter() {
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
	public Adapter createEObjectAdapter() {
		return null;
	}

} // EMV2InstanceAdapterFactory
