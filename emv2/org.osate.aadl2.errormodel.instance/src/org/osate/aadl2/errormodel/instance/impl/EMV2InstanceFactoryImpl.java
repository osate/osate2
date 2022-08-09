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
package org.osate.aadl2.errormodel.instance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.AllPropagations;
import org.osate.aadl2.errormodel.instance.AllPropagationsNoError;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.BranchSameState;
import org.osate.aadl2.errormodel.instance.BranchStateReference;
import org.osate.aadl2.errormodel.instance.Branches;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.ConstantCode;
import org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject;
import org.osate.aadl2.errormodel.instance.ConstraintExpression;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.DestinationPropagationReference;
import org.osate.aadl2.errormodel.instance.DestinationStateReference;
import org.osate.aadl2.errormodel.instance.DetectionInstance;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceFactory;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.EOperation;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.IntegerCode;
import org.osate.aadl2.errormodel.instance.ModeMappingInstance;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.SameState;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateMachineInstance;
import org.osate.aadl2.errormodel.instance.StringCode;
import org.osate.aadl2.errormodel.instance.TransitionInstance;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMV2InstanceFactoryImpl extends EFactoryImpl implements EMV2InstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EMV2InstanceFactory init() {
		try {
			EMV2InstanceFactory theEMV2InstanceFactory = (EMV2InstanceFactory) EPackage.Registry.INSTANCE
					.getEFactory(EMV2InstancePackage.eNS_URI);
			if (theEMV2InstanceFactory != null) {
				return theEMV2InstanceFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EMV2InstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMV2InstanceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE:
			return createEMV2AnnexInstance();
		case EMV2InstancePackage.STATE_MACHINE_INSTANCE:
			return createStateMachineInstance();
		case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT:
			return createConstrainedInstanceObject();
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE:
			return createCompositeStateInstance();
		case EMV2InstancePackage.CONSTRAINT_EXPRESSION:
			return createConstraintExpression();
		case EMV2InstancePackage.FEATURE_PROPAGATION:
			return createFeaturePropagation();
		case EMV2InstancePackage.ACCESS_PROPAGATION:
			return createAccessPropagation();
		case EMV2InstancePackage.POINT_PROPAGATION:
			return createPointPropagation();
		case EMV2InstancePackage.BINDING_PROPAGATION:
			return createBindingPropagation();
		case EMV2InstancePackage.TYPE_INSTANCE:
			return createTypeInstance();
		case EMV2InstancePackage.TYPE_PRODUCT_INSTANCE:
			return createTypeProductInstance();
		case EMV2InstancePackage.TYPE_SET_INSTANCE:
			return createTypeSetInstance();
		case EMV2InstancePackage.ANONYMOUS_TYPE_SET:
			return createAnonymousTypeSet();
		case EMV2InstancePackage.ERROR_SOURCE_INSTANCE:
			return createErrorSourceInstance();
		case EMV2InstancePackage.ERROR_SINK_INSTANCE:
			return createErrorSinkInstance();
		case EMV2InstancePackage.ERROR_PATH_INSTANCE:
			return createErrorPathInstance();
		case EMV2InstancePackage.PROPAGATION_POINT_INSTANCE:
			return createPropagationPointInstance();
		case EMV2InstancePackage.CONNECTION_PATH:
			return createConnectionPath();
		case EMV2InstancePackage.BINDING_PATH:
			return createBindingPath();
		case EMV2InstancePackage.USER_DEFINED_PATH:
			return createUserDefinedPath();
		case EMV2InstancePackage.STATE_INSTANCE:
			return createStateInstance();
		case EMV2InstancePackage.ERROR_EVENT_INSTANCE:
			return createErrorEventInstance();
		case EMV2InstancePackage.RECOVER_EVENT_INSTANCE:
			return createRecoverEventInstance();
		case EMV2InstancePackage.REPAIR_EVENT_INSTANCE:
			return createRepairEventInstance();
		case EMV2InstancePackage.TRANSITION_INSTANCE:
			return createTransitionInstance();
		case EMV2InstancePackage.SOURCE_STATE_REFERENCE:
			return createSourceStateReference();
		case EMV2InstancePackage.ALL_SOURCES:
			return createAllSources();
		case EMV2InstancePackage.EVENT_REFERENCE:
			return createEventReference();
		case EMV2InstancePackage.CONDITION_PROPAGATION_REFERENCE:
			return createConditionPropagationReference();
		case EMV2InstancePackage.NO_ERROR_PROPAGATION_REFERENCE:
			return createNoErrorPropagationReference();
		case EMV2InstancePackage.COUNT_EXPRESSION:
			return createCountExpression();
		case EMV2InstancePackage.DESTINATION_STATE_REFERENCE:
			return createDestinationStateReference();
		case EMV2InstancePackage.SAME_STATE:
			return createSameState();
		case EMV2InstancePackage.BRANCHES:
			return createBranches();
		case EMV2InstancePackage.BRANCH_STATE_REFERENCE:
			return createBranchStateReference();
		case EMV2InstancePackage.BRANCH_SAME_STATE:
			return createBranchSameState();
		case EMV2InstancePackage.OUTGOING_PROPAGATION_CONDITION_INSTANCE:
			return createOutgoingPropagationConditionInstance();
		case EMV2InstancePackage.DESTINATION_PROPAGATION_REFERENCE:
			return createDestinationPropagationReference();
		case EMV2InstancePackage.ALL_PROPAGATIONS:
			return createAllPropagations();
		case EMV2InstancePackage.ALL_PROPAGATIONS_NO_ERROR:
			return createAllPropagationsNoError();
		case EMV2InstancePackage.DETECTION_INSTANCE:
			return createDetectionInstance();
		case EMV2InstancePackage.INTEGER_CODE:
			return createIntegerCode();
		case EMV2InstancePackage.STRING_CODE:
			return createStringCode();
		case EMV2InstancePackage.CONSTANT_CODE:
			return createConstantCode();
		case EMV2InstancePackage.MODE_MAPPING_INSTANCE:
			return createModeMappingInstance();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case EMV2InstancePackage.EOPERATION:
			return createEOperationFromString(eDataType, initialValue);
		case EMV2InstancePackage.BINDING_TYPE:
			return createBindingTypeFromString(eDataType, initialValue);
		case EMV2InstancePackage.COUNT_EXPRESSION_OPERATION:
			return createCountExpressionOperationFromString(eDataType, initialValue);
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
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case EMV2InstancePackage.EOPERATION:
			return convertEOperationToString(eDataType, instanceValue);
		case EMV2InstancePackage.BINDING_TYPE:
			return convertBindingTypeToString(eDataType, instanceValue);
		case EMV2InstancePackage.COUNT_EXPRESSION_OPERATION:
			return convertCountExpressionOperationToString(eDataType, instanceValue);
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
	public EMV2AnnexInstance createEMV2AnnexInstance() {
		EMV2AnnexInstanceImpl emv2AnnexInstance = new EMV2AnnexInstanceImpl();
		return emv2AnnexInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachineInstance createStateMachineInstance() {
		StateMachineInstanceImpl stateMachineInstance = new StateMachineInstanceImpl();
		return stateMachineInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateInstance createStateInstance() {
		StateInstanceImpl stateInstance = new StateInstanceImpl();
		return stateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstrainedInstanceObject createConstrainedInstanceObject() {
		ConstrainedInstanceObjectImpl constrainedInstanceObject = new ConstrainedInstanceObjectImpl();
		return constrainedInstanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeStateInstance createCompositeStateInstance() {
		CompositeStateInstanceImpl compositeStateInstance = new CompositeStateInstanceImpl();
		return compositeStateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorSourceInstance createErrorSourceInstance() {
		ErrorSourceInstanceImpl errorSourceInstance = new ErrorSourceInstanceImpl();
		return errorSourceInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorSinkInstance createErrorSinkInstance() {
		ErrorSinkInstanceImpl errorSinkInstance = new ErrorSinkInstanceImpl();
		return errorSinkInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPathInstance createErrorPathInstance() {
		ErrorPathInstanceImpl errorPathInstance = new ErrorPathInstanceImpl();
		return errorPathInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropagationPointInstance createPropagationPointInstance() {
		PropagationPointInstanceImpl propagationPointInstance = new PropagationPointInstanceImpl();
		return propagationPointInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionPath createConnectionPath() {
		ConnectionPathImpl connectionPath = new ConnectionPathImpl();
		return connectionPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingPath createBindingPath() {
		BindingPathImpl bindingPath = new BindingPathImpl();
		return bindingPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserDefinedPath createUserDefinedPath() {
		UserDefinedPathImpl userDefinedPath = new UserDefinedPathImpl();
		return userDefinedPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorEventInstance createErrorEventInstance() {
		ErrorEventInstanceImpl errorEventInstance = new ErrorEventInstanceImpl();
		return errorEventInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RecoverEventInstance createRecoverEventInstance() {
		RecoverEventInstanceImpl recoverEventInstance = new RecoverEventInstanceImpl();
		return recoverEventInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RepairEventInstance createRepairEventInstance() {
		RepairEventInstanceImpl repairEventInstance = new RepairEventInstanceImpl();
		return repairEventInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TransitionInstance createTransitionInstance() {
		TransitionInstanceImpl transitionInstance = new TransitionInstanceImpl();
		return transitionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceStateReference createSourceStateReference() {
		SourceStateReferenceImpl sourceStateReference = new SourceStateReferenceImpl();
		return sourceStateReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AllSources createAllSources() {
		AllSourcesImpl allSources = new AllSourcesImpl();
		return allSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventReference createEventReference() {
		EventReferenceImpl eventReference = new EventReferenceImpl();
		return eventReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConditionPropagationReference createConditionPropagationReference() {
		ConditionPropagationReferenceImpl conditionPropagationReference = new ConditionPropagationReferenceImpl();
		return conditionPropagationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NoErrorPropagationReference createNoErrorPropagationReference() {
		NoErrorPropagationReferenceImpl noErrorPropagationReference = new NoErrorPropagationReferenceImpl();
		return noErrorPropagationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CountExpression createCountExpression() {
		CountExpressionImpl countExpression = new CountExpressionImpl();
		return countExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DestinationStateReference createDestinationStateReference() {
		DestinationStateReferenceImpl destinationStateReference = new DestinationStateReferenceImpl();
		return destinationStateReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SameState createSameState() {
		SameStateImpl sameState = new SameStateImpl();
		return sameState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Branches createBranches() {
		BranchesImpl branches = new BranchesImpl();
		return branches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BranchStateReference createBranchStateReference() {
		BranchStateReferenceImpl branchStateReference = new BranchStateReferenceImpl();
		return branchStateReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BranchSameState createBranchSameState() {
		BranchSameStateImpl branchSameState = new BranchSameStateImpl();
		return branchSameState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OutgoingPropagationConditionInstance createOutgoingPropagationConditionInstance() {
		OutgoingPropagationConditionInstanceImpl outgoingPropagationConditionInstance = new OutgoingPropagationConditionInstanceImpl();
		return outgoingPropagationConditionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DestinationPropagationReference createDestinationPropagationReference() {
		DestinationPropagationReferenceImpl destinationPropagationReference = new DestinationPropagationReferenceImpl();
		return destinationPropagationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AllPropagations createAllPropagations() {
		AllPropagationsImpl allPropagations = new AllPropagationsImpl();
		return allPropagations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AllPropagationsNoError createAllPropagationsNoError() {
		AllPropagationsNoErrorImpl allPropagationsNoError = new AllPropagationsNoErrorImpl();
		return allPropagationsNoError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DetectionInstance createDetectionInstance() {
		DetectionInstanceImpl detectionInstance = new DetectionInstanceImpl();
		return detectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerCode createIntegerCode() {
		IntegerCodeImpl integerCode = new IntegerCodeImpl();
		return integerCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringCode createStringCode() {
		StringCodeImpl stringCode = new StringCodeImpl();
		return stringCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantCode createConstantCode() {
		ConstantCodeImpl constantCode = new ConstantCodeImpl();
		return constantCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModeMappingInstance createModeMappingInstance() {
		ModeMappingInstanceImpl modeMappingInstance = new ModeMappingInstanceImpl();
		return modeMappingInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintExpression createConstraintExpression() {
		ConstraintExpressionImpl constraintExpression = new ConstraintExpressionImpl();
		return constraintExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeaturePropagation createFeaturePropagation() {
		FeaturePropagationImpl featurePropagation = new FeaturePropagationImpl();
		return featurePropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PointPropagation createPointPropagation() {
		PointPropagationImpl pointPropagation = new PointPropagationImpl();
		return pointPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessPropagation createAccessPropagation() {
		AccessPropagationImpl accessPropagation = new AccessPropagationImpl();
		return accessPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingPropagation createBindingPropagation() {
		BindingPropagationImpl bindingPropagation = new BindingPropagationImpl();
		return bindingPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeInstance createTypeInstance() {
		TypeInstanceImpl typeInstance = new TypeInstanceImpl();
		return typeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeSetInstance createTypeSetInstance() {
		TypeSetInstanceImpl typeSetInstance = new TypeSetInstanceImpl();
		return typeSetInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousTypeSet createAnonymousTypeSet() {
		AnonymousTypeSetImpl anonymousTypeSet = new AnonymousTypeSetImpl();
		return anonymousTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeProductInstance createTypeProductInstance() {
		TypeProductInstanceImpl typeProductInstance = new TypeProductInstanceImpl();
		return typeProductInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation createEOperationFromString(EDataType eDataType, String initialValue) {
		EOperation result = EOperation.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEOperationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingType createBindingTypeFromString(EDataType eDataType, String initialValue) {
		BindingType result = BindingType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBindingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CountExpressionOperation createCountExpressionOperationFromString(EDataType eDataType, String initialValue) {
		CountExpressionOperation result = CountExpressionOperation.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCountExpressionOperationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMV2InstancePackage getEMV2InstancePackage() {
		return (EMV2InstancePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EMV2InstancePackage getPackage() {
		return EMV2InstancePackage.eINSTANCE;
	}

} // EMV2InstanceFactoryImpl
